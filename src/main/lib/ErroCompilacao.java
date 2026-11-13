/**
 * Erro de compilação com fase e posição. Mensagem padronizada nas duas
 * versões (ANTLR e JFlex/JCup):
 * <pre>Erro léxico [3:7]: caractere inválido '@'</pre>
 */
public class ErroCompilacao extends RuntimeException {
    public final String fase;
    public final int linha, coluna;

    public ErroCompilacao(String fase, int linha, int coluna, String msg) {
        super("Erro " + fase + (linha >= 0 ? " [" + linha + ":" + coluna + "]" : "") + ": " + msg);
        this.fase = fase;
        this.linha = linha;
        this.coluna = coluna;
    }

    public static ErroCompilacao lexico(int linha, int coluna, String msg) {
        return new ErroCompilacao("léxico", linha, coluna, msg);
    }

    public static ErroCompilacao sintatico(int linha, int coluna, String msg) {
        return new ErroCompilacao("sintático", linha, coluna, msg);
    }

    /**
     * Erro semântico apontando para um nó da AST (usa a posição do nó).
     */
    public static ErroCompilacao semantico(Ast no, String msg) {
        return comPosicao("semântico", no, msg);
    }

    /**
     * Erro em tempo de execução (interpretação) apontando para um nó da AST.
     */
    public static ErroCompilacao execucao(Ast no, String msg) {
        return comPosicao("de execução", no, msg);
    }

    private static ErroCompilacao comPosicao(String fase, Ast no, String msg) {
        int l = -1, c = -1;
        String p = no == null ? "" : no.pos();
        if (!p.isEmpty()) {
            String[] lc = p.substring(1, p.length() - 1).split(":");
            l = Integer.parseInt(lc[0]);
            c = Integer.parseInt(lc[1]);
        }
        return new ErroCompilacao(fase, l, c, msg);
    }

    public static ErroCompilacao semantico(String msg) {
        return new ErroCompilacao("semântico", -1, -1, msg);
    }

    public static ErroCompilacao execucao(String msg) {
        return new ErroCompilacao("de execução", -1, -1, msg);
    }
}
