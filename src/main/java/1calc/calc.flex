class Token {
    public static final String[] TOKEN_NAMES = {
            "", "PLUS", "TIMES",
            "MINUS", "DIVIDE", "NUMBER",
            "LPAREN", "RPAREN", "EOF", "ID"
    };
    // IDs dos Tokens
    public static final int PLUS = 1;
    public static final int TIMES = 2;
    public static final int MINUS = 3;
    public static final int DIVIDE = 4;
    public static final int NUMBER = 5;
    public static final int LPAREN = 6;
    public static final int RPAREN = 7;
    public static final int EOF = 8;
    public static final int ID = 9;

    public final int tipo;
    public final String  lexema;

    public Token(int tipo, String lexema) {
        this.tipo = tipo;
        this.lexema = lexema;
    }

    public Token(int tipo) {
        this( tipo, null);
    }

    public static String nome(int tipo){
        return Token.TOKEN_NAMES[tipo];
    }

    @Override
    public String toString(){
        return lexema == null? nome(tipo) : nome(tipo) + "(" + this.lexema + ")";
    }
}

%% // diretivas
%class CalcScanner
%public
%unicode
%line
%column
%type Token
%eofval{
    return new Token(Token.EOF);
%eofval}

%{
  public static void main(String args[]) throws java.io.IOException{
      CalcScanner s = new CalcScanner(new java.io.FileReader(args[0]));
      Token token;

      while ((token = s.yylex()) != null){
          System.out.println(s.yyline + " -> " + token);
      }
  }
%}

DIGIT = [0-9]
NUMBER = {DIGIT}+
WHITESPACE = [ \t\r\n]+
LETTER = [a-zA-Z]
ID = [{LETTER}_][{LETTER}{DIGIT}_]*

%% // regras léxicas/scanner/query
"+" { return new Token(Token.PLUS); }
"*" { return new Token(Token.TIMES); }
"-" { return new Token(Token.MINUS); }
"/" { return new Token(Token.DIVIDE); }
"(" { return new Token(Token.LPAREN); }
")" { return new Token(Token.RPAREN); }
{ID} { return new Token(Token.ID, yytext()); }
{NUMBER} { return new Token(Token.NUMBER, yytext() ); }
{WHITESPACE} { /* IGNORE */ }
[^] { throw new Error("Invalid character '" + yytext() + "' na linha " +
                      (yyline + 1) + ", coluna " + (yycolumn + 1)); }


