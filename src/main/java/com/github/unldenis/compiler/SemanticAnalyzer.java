package com.github.unldenis.compiler;


import com.github.unldenis.antlr.SimplerLangBaseListener;
import com.github.unldenis.antlr.SimplerLangParser.LetContext;
import com.github.unldenis.antlr.SimplerLangParser.PrintContext;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.antlr.v4.runtime.Token;

public class SemanticAnalyzer extends SimplerLangBaseListener {

  private final Map<String, Token> variablesDeclaration;

  public SemanticAnalyzer() {
    variablesDeclaration = new HashMap<>();
  }

  @Override
  public void exitPrint(PrintContext ctx) {
    var node = ctx.VAR();
    if (node != null) {
      var token = node.getSymbol();
      var variable = token.getText();
      var line = token.getLine();
      var pos = token.getCharPositionInLine();

      if (!variablesDeclaration.containsKey(variable)) {
        throw new SemanticException("Variable '%s' [line %d at %d] not declared".formatted(variable, line, pos));
      }
    }
  }

  @Override
  public void exitLet(LetContext ctx) {
    var variable = ctx.VAR().getText();
    if(variablesDeclaration.containsKey(variable)) {
      var token = variablesDeclaration.get(variable);
      var line = token.getLine();
      var pos = token.getCharPositionInLine();

      throw new SemanticException("Variable '%s' already defined in [line %d at %d]".formatted(variable, line, pos));
    }
    variablesDeclaration.put(variable, ctx.VAR().getSymbol());
  }

}
