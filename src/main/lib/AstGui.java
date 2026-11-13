import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JFrame;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.tree.Tree;

/**
 * Mostra a AST numa janela usando o MESMO visualizador do "grun -gui"
 * (org.antlr.v4.gui.TreeViewer). Assim os exemplos JFlex/JCup também
 * apresentam a árvore graficamente, como o grun faz para o ANTLR.
 */
public final class AstGui {
    private AstGui() {
    }

    public static void mostrar(Ast ast, String titulo) throws Exception {
        if (java.awt.GraphicsEnvironment.isHeadless()) {
            System.err.println("(sem ambiente gráfico: janela da AST não exibida)");
            return;
        }
        TreeViewer viewer = new TreeViewer(Collections.emptyList(), new No(ast, null));
        JFrame janela = viewer.open().get();
        janela.setTitle(titulo);
        while (janela.isDisplayable()) Thread.sleep(200); // espera fechar
    }

    /**
     * Adaptador Ast -> Tree do ANTLR (filhos criados uma única vez).
     */
    private static final class No implements Tree {
        private final Ast ast;
        private final No pai;
        private final List<No> filhos = new ArrayList<>();

        No(Ast ast, No pai) {
            this.ast = ast;
            this.pai = pai;
            for (Ast f : ast.filhos()) filhos.add(new No(f, this));
        }

        @Override
        public Tree getParent() {
            return pai;
        }

        @Override
        public Object getPayload() {
            return ast.rotulo();
        }

        @Override
        public Tree getChild(int i) {
            return filhos.get(i);
        }

        @Override
        public int getChildCount() {
            return filhos.size();
        }

        @Override
        public String toStringTree() {
            return ast.toString();
        }

        @Override
        public String toString() {
            return ast.rotulo();
        }
    }
}
