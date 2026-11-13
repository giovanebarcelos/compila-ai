import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/** Back-end (idêntico nas duas versões): interpretador com TABELA DE SÍMBOLOS. */
public class Semantica {
    static final Map<String, Double> tabela = new LinkedHashMap<>();

    public static void executar(Ast programa) {
        for (Ast c : programa.filhos()) {
            if (c.eh("=")) {
                double v = avaliar(c.filho(1));
                tabela.put(c.filho(0).texto, v);
                System.out.println(c.filho(0).texto + " <- " + fmt(v));
            } else {
                System.out.println("print: " + fmt(avaliar(c.filho(0))));
            }
        }
        System.out.println("Tabela de símbolos:");
        tabela.forEach((k, v) -> System.out.println("  " + k + " = " + fmt(v)));
    }

    static double avaliar(Ast e) {
        switch (e.tipo) {
            case "NUM": return Double.parseDouble(e.texto);
            case "ID": {
                Double v = tabela.get(e.texto);
                if (v == null) throw ErroCompilacao.semantico(e, "variável '" + e.texto + "' usada antes de ser definida");
                return v;
            }
            case "neg": return -avaliar(e.filho(0));
            case "^": return Math.pow(avaliar(e.filho(0)), avaliar(e.filho(1)));
            case "+": return avaliar(e.filho(0)) + avaliar(e.filho(1));
            case "-": return avaliar(e.filho(0)) - avaliar(e.filho(1));
            case "*": return avaliar(e.filho(0)) * avaliar(e.filho(1));
            case "/": case "%": {
                double a = avaliar(e.filho(0)), b = avaliar(e.filho(1));
                if (b == 0) throw ErroCompilacao.execucao(e, "divisão por zero");
                return e.eh("/") ? a / b : a % b;
            }
            default: throw new IllegalStateException(e.tipo);
        }
    }

    /** 3.0 -> "3", 2.5 -> "2.5" */
    static String fmt(double v) {
        if (v == Math.rint(v) && Math.abs(v) < 1e15) return Long.toString((long) v);
        return BigDecimal.valueOf(v).stripTrailingZeros().toPlainString();
    }
}
