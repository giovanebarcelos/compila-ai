import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

public class MainVars {
    static void main(String[] args) {
        Compilador.executar(args, arquivo -> {
            VarsLexer lexer = new VarsLexer(CharStreams.fromFileName(arquivo));
            VarsParser parser = new VarsParser(new CommonTokenStream(lexer));
            AntlrErros.instalar(lexer, parser);
            return new ConstrutorAst().visit(parser.programa());
        }, Semantica::executar);
    }

    static class ConstrutorAst extends VarsBaseVisitor<Ast> {
        @Override
        public Ast visitPrograma(VarsParser.ProgramaContext ctx){
            Ast p = Ast.no("programa");
            ctx.comando().forEach(c -> p.add(visit(c)));
            return p;
        }

        @Override
        public Ast visitAtribuicao(VarsParser.AtribuicaoContext ctx){
            return Ast.no("=", AntlrErros.folha("ID", ctx.ID().getSymbol()),
                    visit(ctx.expr()));
        }

        @Override
        public Ast visitImprime(VarsParser.ImprimeContext ctx){
            return Ast.no("print", visit(ctx.expr()));
        }

        @Override
        public Ast visitPotencia(VarsParser.PotenciaContext ctx){
            return bin("^", ctx.expr(0), ctx.expr(1), ctx.getChild(1));
        }

        @Override
        public Ast visitMulDiv(VarsParser.MulDivContext ctx){
            return bin(ctx.op.getText(), ctx.expr(0), ctx.expr(1), ctx.getChild(1));
        }

        @Override
        public Ast visitSomaSub(VarsParser.SomaSubContext ctx){
            return bin(ctx.op.getText(), ctx.expr(0), ctx.expr(1), ctx.getChild(1));
        }

        @Override
        public Ast visitNegativo(VarsParser.NegativoContext ctx){
            return Ast.no("neg", visit(ctx.expr()));
        }

        @Override
        public Ast visitNumero(VarsParser.NumeroContext ctx){
            return AntlrErros.folha("NUM", ctx.NUM().getSymbol());
        }

        @Override
        public Ast visitVariavel(VarsParser.VariavelContext ctx){
            return AntlrErros.folha("ID", ctx.ID().getSymbol());
        }

        @Override
        public Ast visitParenteses(VarsParser.ParentesesContext ctx){
            return visit(ctx.expr());
        }

        private Ast bin(String op, VarsParser.ExprContext a,
                        VarsParser.ExprContext b, ParseTree opNo){
            Token t = ((TerminalNode) opNo).getSymbol();
            return Ast.no(op, visit(a), visit(b)).em(t.getLine(),
                    t.getCharPositionInLine() + 1);
        }
    }
}