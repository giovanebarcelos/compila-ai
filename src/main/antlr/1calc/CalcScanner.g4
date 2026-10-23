lexer grammar CalcScanner;

@header {
import java.util.Arrays;
}

@members {
  public static void main(String args[]) throws java.io.IOException {
    String[] types = {"PLUS","TIMES","MINUS","DIVIDE","LPAREN","RPAREN"};

    CalcScanner scanner = new CalcScanner(CharStreams.fromFileName(args[0]));
    Token token;

    while ((token = scanner.nextToken()).getType() != Token.EOF) {
      String name = VOCABULARY.getSymbolicName(token.getType());

      if ( Arrays.stream(types).anyMatch(w -> w.equals(name))) {
         System.out.println(token.getLine()+" -> "+name);
      } else {
         System.out.println(token.getLine()+" -> "+name + "(" + token.getText() + ")" );
      }
    }
  }
}

// regras lexical, scanner, query
ID         : [a-zA-Z_][a-zA-Z0-9_]* ;
NUMBER     : [0-9]+ ;
PLUS       : '+' ;
TIMES      : '*' ;
MINUS      : '-' ;
DIVIDE     : '/' ;
LPAREN     : '(' ;
RPAREN     : ')' ;
WHITESPACE :  [ \t\r\n]+ -> skip;
ERRO: . { if (true) throw new Error("Invalid character '" + getText() + "' na linha " +
                                                  _tokenStartLine + ", coluna " + _tokenStartCharPositionInLine); } ;