import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;

/**
 * Troca os "error listeners" padrão do ANTLR (que só imprimem e tentam
 * se recuperar) por listeners que lançam {@link ErroCompilacao} no 1º erro,
 * com a mesma mensagem usada na versão JFlex/JCup.
 */
public final class AntlrErros {
    private AntlrErros() {
    }

    public static void instalar(Lexer lexer, Parser parser) {
        lexer.removeErrorListeners();
        lexer.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> r, Object simbolo, int linha, int col,
                                    String msg, RecognitionException e) {
                String prefixo = "token recognition error at: ";
                String txt = msg.startsWith(prefixo) ? msg.substring(prefixo.length()) : msg;
                // o ANTLR mostra tudo o que tentou casar ('abc'); como no JFlex, reporta só o 1º caractere
                if (txt.length() >= 3 && txt.startsWith("'") && txt.endsWith("'")) {
                    String dentro = txt.substring(1, txt.length() - 1);
                    int n = dentro.startsWith("\\") && dentro.length() > 1 ? 2 : dentro.offsetByCodePoints(0, 1);
                    txt = "'" + dentro.substring(0, n) + "'";
                }
                throw ErroCompilacao.lexico(linha, col + 1, "caractere inválido " + txt);
            }
        });
        parser.removeErrorListeners();
        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> r, Object simbolo, int linha, int col,
                                    String msg, RecognitionException e) {
                throw ErroCompilacao.sintatico(linha, col + 1, descrever(simbolo) + "  (ANTLR: " + msg + ")");
            }
        });
    }

    static String descrever(Object simbolo) {
        if (simbolo instanceof Token t) {
            if (t.getType() == Token.EOF) return "fim de arquivo inesperado";
            return "token inesperado '" + t.getText().replace("\r", "\\r").replace("\n", "\\n") + "'";
        }
        return "token inesperado";
    }

    /**
     * Atalho para criar folhas da AST a partir de tokens do ANTLR.
     */
    public static Ast folha(String tipo, Token t) {
        return Ast.folha(tipo, t.getText(), t.getLine(), t.getCharPositionInLine() + 1);
    }
}
