import java_cup.runtime.Symbol;

/**
 * Mensagens de erro sintático para parsers JCup, no mesmo formato da
 * versão ANTLR. Uso dentro do "parser code" do .cup:
 * <pre>
 * public void syntax_error(Symbol s) { throw CupErros.sintatico(s, XSym.terminalNames); }
 * public void unrecovered_syntax_error(Symbol s) { throw CupErros.sintatico(s, XSym.terminalNames); }
 * </pre>
 */
public final class CupErros {
    private CupErros() {
    }

    public static ErroCompilacao sintatico(Symbol s, String[] nomes) {
        return ErroCompilacao.sintatico(s == null ? -1 : s.left, s == null ? -1 : s.right, descrever(s, nomes));
    }

    public static String descrever(Symbol s, String[] nomes) {
        if (s == null || s.sym == 0) return "fim de arquivo inesperado";   // 0 = EOF no CUP
        String nome = s.sym < nomes.length ? nomes[s.sym] : "?";
        String txt = s.value instanceof Ast a ? a.texto : s.value != null ? s.value.toString() : nome;
        return "token inesperado '" + txt.replace("\r", "\\r").replace("\n", "\\n") + "'  (CUP: " + nome + ")";
    }

    /**
     * Atalho para criar folhas da AST a partir do valor (lexema) e posição.
     */
    public static Ast folha(String tipo, Object texto, int linha, int coluna) {
        return Ast.folha(tipo, String.valueOf(texto), linha, coluna);
    }
}
