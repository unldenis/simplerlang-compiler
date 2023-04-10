package com.github.unldenis.compiler;

import com.github.unldenis.antlr.SimplerLangBaseVisitor;
import com.github.unldenis.antlr.SimplerLangParser.LetContext;
import com.github.unldenis.antlr.SimplerLangParser.PrintContext;
import com.github.unldenis.antlr.SimplerLangParser.ProgramContext;
import com.github.unldenis.antlr.SimplerLangParser.StatementContext;

public class Compiler extends SimplerLangBaseVisitor<String> {

  @Override
  public String visitPrint(PrintContext ctx) {
    return "System.out.println(%s)".formatted(ctx.VAR() != null ? ctx.VAR().getText() : ctx.NUMBER().getText());
  }

  @Override
  public String visitStatement(StatementContext ctx) {
    return super.visitStatement(ctx);
  }

  @Override
  public String visitLet(LetContext ctx) {
    return  "int %s = %s".formatted(ctx.VAR().getText(), ctx.NUMBER().getText());
  }

  @Override
  public String visitProgram(ProgramContext ctx) {
    var sb = new StringBuilder();
    sb.append("""
        class Test {
          public static void main(String[] args) {
        """);

    for(var stmt: ctx.statement()) {
      sb.append('\t').append('\t');
      sb.append(visit(stmt));
      sb.append(';').append('\n');
    }

    sb.append("""
          }
        }
        """);
    return sb.toString();
  }
}