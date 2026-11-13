import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Driver comum: front-end (análise léxica + sintática → AST) seguido do
 * back-end (semântica / interpretação / geração de código).
 *
 * <pre>
 * java Main [--ast] [--gui] [--saida DIR] arquivo
 *   --ast        imprime a AST (desenho indentado) antes da saída
 *   --gui        abre a AST numa janela (mesmo visualizador do "grun -gui")
 *   --saida DIR  diretório para arquivos gerados (ex.: código C)
 * </pre>
 * Código de saída: 0 = sucesso, 1 = erro de compilação, 2 = uso, 3 = erro interno.
 */
public final class Compilador {

    /**
     * Front-end: lê o arquivo e devolve a AST.
     */
    public interface FrontEnd {
        Ast analisar(String arquivo) throws Exception;
    }

    /**
     * Back-end: recebe a AST e produz a saída.
     */
    public interface BackEnd {
        void executar(Ast ast) throws Exception;
    }

    private static Path dirSaida = Paths.get(".");
    private static String entrada = "entrada";

    private Compilador() {
    }

    public static void executar(String[] args, FrontEnd frontEnd, BackEnd backEnd) {
        boolean mostrarAst = false, gui = false;
        String arquivo = null;
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "--ast" -> mostrarAst = true;
                case "--gui" -> gui = true;
                case "--saida" -> dirSaida = Paths.get(args[++i]);
                default -> arquivo = args[i];
            }
        }
        if (arquivo == null) {
            System.err.println("Uso: java Main [--ast] [--gui] [--saida DIR] arquivo");
            System.exit(2);
        }
        entrada = Paths.get(arquivo).getFileName().toString();
        try {
            Ast ast = frontEnd.analisar(arquivo);
            if (mostrarAst) {
                System.out.println("=== AST ===");
                System.out.print(ast.desenhar());
                System.out.println("=== Saída ===");
            }
            backEnd.executar(ast);
            System.out.flush();
            if (gui) AstGui.mostrar(ast, "AST — " + entrada);
        } catch (ErroCompilacao e) {
            System.out.flush();
            System.err.println(e.getMessage());
            System.exit(1);
        } catch (NoSuchFileException | java.io.FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + arquivo);
            System.exit(2);
        } catch (Exception e) {
            System.out.flush();
            System.err.println("Erro interno: " + e);
            e.printStackTrace();
            System.exit(3);
        }
    }

    /**
     * Leitor UTF-8 (usado pelos scanners JFlex).
     */
    public static Reader leitor(String arquivo) throws java.io.IOException {
        return new InputStreamReader(Files.newInputStream(Paths.get(arquivo)), StandardCharsets.UTF_8);
    }

    /**
     * Caminho de um arquivo gerado: DIR_SAIDA/&lt;entrada&gt;&lt;extensao&gt; (ex.: ok_1.txt.c).
     */
    public static Path saida(String extensao) throws java.io.IOException {
        Files.createDirectories(dirSaida);
        return dirSaida.resolve(entrada + extensao);
    }
}
