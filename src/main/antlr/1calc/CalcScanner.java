// Generated from CalcScanner.g4 by ANTLR 4.13.2

import java.util.Arrays;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class CalcScanner extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ID=1, NUMBER=2, PLUS=3, TIMES=4, MINUS=5, DIVIDE=6, LPAREN=7, RPAREN=8, 
		WHITESPACE=9, ERRO=10;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"ID", "NUMBER", "PLUS", "TIMES", "MINUS", "DIVIDE", "LPAREN", "RPAREN", 
			"WHITESPACE", "ERRO"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'+'", "'*'", "'-'", "'/'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ID", "NUMBER", "PLUS", "TIMES", "MINUS", "DIVIDE", "LPAREN", "RPAREN", 
			"WHITESPACE", "ERRO"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


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


	public CalcScanner(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CalcScanner.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 9:
			ERRO_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void ERRO_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 if (true) throw new Error("Invalid character '" + getText() + "' na linha " +
			                                                  _tokenStartLine + ", coluna " + _tokenStartCharPositionInLine); 
			break;
		}
	}

	public static final String _serializedATN =
		"\u0004\u0000\n7\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0005"+
		"\u0000\u0018\b\u0000\n\u0000\f\u0000\u001b\t\u0000\u0001\u0001\u0004\u0001"+
		"\u001e\b\u0001\u000b\u0001\f\u0001\u001f\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0004\b/\b\b\u000b"+
		"\b\f\b0\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0000\u0000\n\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0001\u0000\u0004\u0003\u0000AZ__az\u0004\u000009A"+
		"Z__az\u0001\u000009\u0003\u0000\t\n\r\r  9\u0000\u0001\u0001\u0000\u0000"+
		"\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000"+
		"\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000"+
		"\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000"+
		"\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000"+
		"\u0013\u0001\u0000\u0000\u0000\u0001\u0015\u0001\u0000\u0000\u0000\u0003"+
		"\u001d\u0001\u0000\u0000\u0000\u0005!\u0001\u0000\u0000\u0000\u0007#\u0001"+
		"\u0000\u0000\u0000\t%\u0001\u0000\u0000\u0000\u000b\'\u0001\u0000\u0000"+
		"\u0000\r)\u0001\u0000\u0000\u0000\u000f+\u0001\u0000\u0000\u0000\u0011"+
		".\u0001\u0000\u0000\u0000\u00134\u0001\u0000\u0000\u0000\u0015\u0019\u0007"+
		"\u0000\u0000\u0000\u0016\u0018\u0007\u0001\u0000\u0000\u0017\u0016\u0001"+
		"\u0000\u0000\u0000\u0018\u001b\u0001\u0000\u0000\u0000\u0019\u0017\u0001"+
		"\u0000\u0000\u0000\u0019\u001a\u0001\u0000\u0000\u0000\u001a\u0002\u0001"+
		"\u0000\u0000\u0000\u001b\u0019\u0001\u0000\u0000\u0000\u001c\u001e\u0007"+
		"\u0002\u0000\u0000\u001d\u001c\u0001\u0000\u0000\u0000\u001e\u001f\u0001"+
		"\u0000\u0000\u0000\u001f\u001d\u0001\u0000\u0000\u0000\u001f \u0001\u0000"+
		"\u0000\u0000 \u0004\u0001\u0000\u0000\u0000!\"\u0005+\u0000\u0000\"\u0006"+
		"\u0001\u0000\u0000\u0000#$\u0005*\u0000\u0000$\b\u0001\u0000\u0000\u0000"+
		"%&\u0005-\u0000\u0000&\n\u0001\u0000\u0000\u0000\'(\u0005/\u0000\u0000"+
		"(\f\u0001\u0000\u0000\u0000)*\u0005(\u0000\u0000*\u000e\u0001\u0000\u0000"+
		"\u0000+,\u0005)\u0000\u0000,\u0010\u0001\u0000\u0000\u0000-/\u0007\u0003"+
		"\u0000\u0000.-\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000\u00000.\u0001"+
		"\u0000\u0000\u000001\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u0000"+
		"23\u0006\b\u0000\u00003\u0012\u0001\u0000\u0000\u000045\t\u0000\u0000"+
		"\u000056\u0006\t\u0001\u00006\u0014\u0001\u0000\u0000\u0000\u0004\u0000"+
		"\u0019\u001f0\u0002\u0006\u0000\u0000\u0001\t\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}