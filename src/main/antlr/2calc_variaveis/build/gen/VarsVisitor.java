// Generated from Vars.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link VarsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface VarsVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link VarsParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(VarsParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Atribuicao}
	 * labeled alternative in {@link VarsParser#comando}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtribuicao(VarsParser.AtribuicaoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Imprime}
	 * labeled alternative in {@link VarsParser#comando}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImprime(VarsParser.ImprimeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Numero}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumero(VarsParser.NumeroContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Variavel}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariavel(VarsParser.VariavelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parenteses}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenteses(VarsParser.ParentesesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDiv(VarsParser.MulDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Potencia}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPotencia(VarsParser.PotenciaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SomaSub}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSomaSub(VarsParser.SomaSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Negativo}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegativo(VarsParser.NegativoContext ctx);
}