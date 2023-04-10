package com.github.unldenis.antlr;// Generated from SimplerLang.g4 by ANTLR 4.3
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimplerLangParser}.
 */
public interface SimplerLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimplerLangParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(@NotNull SimplerLangParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplerLangParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(@NotNull SimplerLangParser.PrintContext ctx);

	/**
	 * Enter a parse tree produced by {@link SimplerLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull SimplerLangParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplerLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull SimplerLangParser.StatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link SimplerLangParser#let}.
	 * @param ctx the parse tree
	 */
	void enterLet(@NotNull SimplerLangParser.LetContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplerLangParser#let}.
	 * @param ctx the parse tree
	 */
	void exitLet(@NotNull SimplerLangParser.LetContext ctx);

	/**
	 * Enter a parse tree produced by {@link SimplerLangParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull SimplerLangParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplerLangParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull SimplerLangParser.ProgramContext ctx);
}