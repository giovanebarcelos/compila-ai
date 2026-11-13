// Generated from Vars.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link VarsParser}.
 */
public interface VarsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link VarsParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(VarsParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link VarsParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(VarsParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Atribuicao}
	 * labeled alternative in {@link VarsParser#comando}.
	 * @param ctx the parse tree
	 */
	void enterAtribuicao(VarsParser.AtribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Atribuicao}
	 * labeled alternative in {@link VarsParser#comando}.
	 * @param ctx the parse tree
	 */
	void exitAtribuicao(VarsParser.AtribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Imprime}
	 * labeled alternative in {@link VarsParser#comando}.
	 * @param ctx the parse tree
	 */
	void enterImprime(VarsParser.ImprimeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Imprime}
	 * labeled alternative in {@link VarsParser#comando}.
	 * @param ctx the parse tree
	 */
	void exitImprime(VarsParser.ImprimeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Numero}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumero(VarsParser.NumeroContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Numero}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumero(VarsParser.NumeroContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variavel}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVariavel(VarsParser.VariavelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variavel}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVariavel(VarsParser.VariavelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parenteses}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenteses(VarsParser.ParentesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parenteses}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenteses(VarsParser.ParentesesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(VarsParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(VarsParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Potencia}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPotencia(VarsParser.PotenciaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Potencia}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPotencia(VarsParser.PotenciaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SomaSub}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSomaSub(VarsParser.SomaSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SomaSub}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSomaSub(VarsParser.SomaSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Negativo}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNegativo(VarsParser.NegativoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Negativo}
	 * labeled alternative in {@link VarsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNegativo(VarsParser.NegativoContext ctx);
}