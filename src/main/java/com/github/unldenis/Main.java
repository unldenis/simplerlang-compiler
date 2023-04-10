package com.github.unldenis;

import com.github.unldenis.antlr.SimplerLangLexer;
import com.github.unldenis.antlr.SimplerLangParser;
import com.github.unldenis.compiler.Compiler;
import com.github.unldenis.compiler.SemanticAnalyzer;
import com.github.unldenis.compiler.SemanticException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {

  public static void main(String[] args) throws IOException {
    var str = Files.readString(new File("tests/01.sl").toPath());
    var chars = new ANTLRInputStream(str);

    var lexer = new SimplerLangLexer(chars);
    var tokens = new CommonTokenStream(lexer);

    var parser = new SimplerLangParser(tokens);
    parser.addParseListener(new SemanticAnalyzer());

    try {
      var tree = parser.program();

      var output = new Compiler().visit(tree);
      System.out.println("-".repeat(15));
      System.out.println("2Java Transpiler");
      System.out.println("-".repeat(15));
      System.out.println(output);
    } catch (SemanticException e) {
      System.err.println(e.getMessage());
    }

  }
}