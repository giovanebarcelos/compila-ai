class CalcToken {
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

    public CalcToken(int tipo, String lexema) {
        this.tipo = tipo;
        this.lexema = lexema;
    }

    public CalcToken(int tipo) {
        this( tipo, null);
    }

    public static String nome(int tipo){
        return CalcToken.TOKEN_NAMES[tipo];
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
%type CalcToken
%eofval{
    return new CalcToken(CalcToken.EOF);
%eofval}

%{
  public static void main(String args[]) throws java.io.IOException{
      CalcScanner s = new CalcScanner(new java.io.FileReader(args[0]));
      CalcToken token;

      while ((token = s.yylex()) != null){
          System.out.println((s.yyline + 1) + " -> " + token);
      }
  }
%}

DIGIT = [0-9]
NUMBER = {DIGIT}+
WHITESPACE = [ \t\r\n]+
LETTER = [a-zA-Z]
ID = ({LETTER}|_)({LETTER}|{DIGIT}|_)*

%% // regras léxicas/scanner/query
"+" { return new CalcToken(CalcToken.PLUS); }
"*" { return new CalcToken(CalcToken.TIMES); }
"-" { return new CalcToken(CalcToken.MINUS); }
"/" { return new CalcToken(CalcToken.DIVIDE); }
"(" { return new CalcToken(CalcToken.LPAREN); }
")" { return new CalcToken(CalcToken.RPAREN); }
{ID} { return new CalcToken(CalcToken.ID, yytext()); }
{NUMBER} { return new CalcToken(CalcToken.NUMBER, yytext() ); }
{WHITESPACE} { /* IGNORE */ }
[^] { throw new Error("Invalid character '" + yytext() + "' na linha " +
                      (yyline + 1) + ", coluna " + (yycolumn + 1)); }


