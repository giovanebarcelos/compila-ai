import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Árvore Sintática Abstrata (AST) genérica, usada por TODOS os exemplos.
 *
 * <p>O front-end (ANTLR ou JFlex/JCup) constrói a AST; o back-end
 * ({@code Semantica.java}, idêntico nas duas versões) só enxerga a AST.
 * Por isso as duas implementações produzem exatamente a mesma saída.</p>
 *
 * <ul>
 *   <li>Nó interior: {@code Ast.no("+", esq, dir)}</li>
 *   <li>Folha (token): {@code Ast.folha("NUM", "42", linha, coluna)}</li>
 * </ul>
 */
public final class Ast {
    public final String tipo;   // rótulo do nó (ex.: "+", "if", "NUM")
    public final String texto;  // lexema (só em folhas; null em nós interiores)
    public int linha = -1, coluna = -1;
    private final List<Ast> filhos = new ArrayList<>();

    private Ast(String tipo, String texto) {
        this.tipo = tipo;
        this.texto = texto;
    }

    /**
     * Nó interior; filhos nulos são ignorados (útil para partes opcionais).
     */
    public static Ast no(String tipo, Ast... filhos) {
        Ast a = new Ast(tipo, null);
        for (Ast f : filhos) a.add(f);
        return a;
    }

    /**
     * Nó interior a partir de uma lista de filhos.
     */
    public static Ast no(String tipo, List<Ast> filhos) {
        Ast a = new Ast(tipo, null);
        for (Ast f : filhos) a.add(f);
        return a;
    }

    /**
     * Folha (token) com posição no código-fonte (linha/coluna começam em 1).
     */
    public static Ast folha(String tipo, String texto, int linha, int coluna) {
        Ast a = new Ast(tipo, texto);
        a.linha = linha;
        a.coluna = coluna;
        return a;
    }

    /**
     * Folha sem posição.
     */
    public static Ast folha(String tipo, String texto) {
        return new Ast(tipo, texto);
    }

    /**
     * Acrescenta um filho (ignora null) e devolve o próprio nó (encadeável).
     */
    public Ast add(Ast filho) {
        if (filho != null) filhos.add(filho);
        return this;
    }

    /**
     * Define a posição (para mensagens de erro semântico).
     */
    public Ast em(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
        return this;
    }

    public List<Ast> filhos() {
        return Collections.unmodifiableList(filhos);
    }

    public Ast filho(int i) {
        return filhos.get(i);
    }

    public int n() {
        return filhos.size();
    }

    public boolean ehFolha() {
        return texto != null;
    }

    public boolean eh(String t) {
        return tipo.equals(t);
    }

    /**
     * Posição no formato [linha:coluna] (ou vazio se desconhecida).
     */
    public String pos() {
        if (linha >= 0) return "[" + linha + ":" + coluna + "]";
        for (Ast f : filhos) {
            String p = f.pos();
            if (!p.isEmpty()) return p;
        }
        return "";
    }

    /**
     * Rótulo exibido: "tipo" (nó) ou "TIPO(lexema)" (folha).
     */
    public String rotulo() {
        if (texto == null) return tipo;
        return tipo + "(" + texto.replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t") + ")";
    }

    /**
     * Formato LISP de uma linha, igual ao "grun -tree": (raiz filho1 filho2 ...).
     */
    @Override
    public String toString() {
        if (filhos.isEmpty()) return rotulo();
        StringBuilder sb = new StringBuilder("(").append(rotulo());
        for (Ast f : filhos) sb.append(' ').append(f);
        return sb.append(')').toString();
    }

    /**
     * Desenho indentado da árvore (├── / └──).
     */
    public String desenhar() {
        StringBuilder sb = new StringBuilder(rotulo()).append('\n');
        for (int i = 0; i < filhos.size(); i++) {
            filhos.get(i).desenhar(sb, "", i == filhos.size() - 1);
        }
        return sb.toString();
    }

    private void desenhar(StringBuilder sb, String prefixo, boolean ultimo) {
        sb.append(prefixo).append(ultimo ? "└── " : "├── ").append(rotulo()).append('\n');
        String p = prefixo + (ultimo ? "    " : "│   ");
        for (int i = 0; i < filhos.size(); i++) {
            filhos.get(i).desenhar(sb, p, i == filhos.size() - 1);
        }
    }
}
