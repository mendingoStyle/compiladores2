/* Generated By:JavaCC: Do not edit this line. Lex.java */
package teste;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lex implements LexConstants {
  public static void main(String args []) throws ParseException, FileNotFoundException
  {

	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    try {
	      System.out.println("Insira o caminho do arquivo: ");
	      String path = br.readLine();
	      FileInputStream fis = new FileInputStream(path);

	      Lex parser = new Lex(fis);

	      try {
	        Lex.Start();
	      } catch (Exception e) {
	        System.out.println("NOK.");
	        System.out.println(e.getMessage());
//	          Lex.ReInit(System.in);
	      } catch (Error e) {
	        System.out.println("Oops.");
	        System.out.println(e.getMessage());
	      }
	    } catch (IOException e) {
	      System.out.println(e);
	    }
	  }

  static final public void Start() throws ParseException {
    jj_consume_token(VOID);
    jj_consume_token(MAIN);
    jj_consume_token(ESQPAR);
    jj_consume_token(DIRPAR);
    jj_consume_token(ESQCURLY);
    statement();
    jj_consume_token(DIRCURLY);
    jj_consume_token(0);
  }

// if, defini??o de uma vari?vel com tipo, atribui??o em uma vari?vel e while
  static final public void statement() throws ParseException {
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
      case WHILE:
      case INT:
      case FLOAT:
      case CHAR:
      case IDENTIFIER:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
        ifCondition();
        break;
      case INT:
      case FLOAT:
      case CHAR:
        variableDefine();
        break;
      case IDENTIFIER:
        variableAssignment();
        break;
      case WHILE:
        whileLoop();
        break;
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

/* if(RelationalStatement())
		ifStatement()
*/
  static final public void ifCondition() throws ParseException {
    jj_consume_token(IF);
    jj_consume_token(ESQPAR);
    RelationalStatement();
    jj_consume_token(DIRPAR);
    ifStatement();
  }

// Vari?vel RelationalSymbol() Vari?vel
  static final public void RelationalStatement() throws ParseException {
    jj_consume_token(IDENTIFIER);
    RelationalSymbol();
    jj_consume_token(IDENTIFIER);
  }

  static final public void RelationalSymbol() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LESSTHAN:
      jj_consume_token(LESSTHAN);
      break;
    case MORETHAN:
      jj_consume_token(MORETHAN);
      break;
    case EQUALTHAN:
      jj_consume_token(EQUALTHAN);
      break;
    case DIFTHAN:
      jj_consume_token(DIFTHAN);
      break;
    case OR:
      jj_consume_token(OR);
      break;
    case AND:
      jj_consume_token(AND);
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Operation() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLUS:
      jj_consume_token(PLUS);
      break;
    case MINUS:
      jj_consume_token(MINUS);
      break;
    case MULTIPLY:
      jj_consume_token(MULTIPLY);
      break;
    case DIVIDE:
      jj_consume_token(DIVIDE);
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

// { statement() } ou OneStatement()
  static final public void ifStatement() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ESQCURLY:
      jj_consume_token(ESQCURLY);
      statement();
      jj_consume_token(DIRCURLY);
      break;
    case IF:
    case INT:
    case FLOAT:
    case CHAR:
    case IDENTIFIER:
      OneStatement();
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

// statatement() sem repeti??o
  static final public void OneStatement() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IF:
      ifCondition();
      break;
    case INT:
    case FLOAT:
    case CHAR:
      variableDefine();
      break;
    case IDENTIFIER:
      variableAssignment();
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

// TipoVari?vel variableDefineHelper()
  static final public void variableDefine() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT:
      jj_consume_token(INT);
      break;
    case FLOAT:
      jj_consume_token(FLOAT);
      break;
    case CHAR:
      jj_consume_token(CHAR);
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    variableDefineHelper();
  }

// Vari?vel;
  static final public void variableDefineHelper() throws ParseException {
    jj_consume_token(IDENTIFIER);
    jj_consume_token(PONTOVIRGULA);
  }

// variableAssigmentHelper() Vari?vel;
  static final public void variableAssignment() throws ParseException {
    variableAssignmentHelper();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUM:
      jj_consume_token(NUM);
      variablesOperationAUX();
      break;
    case FLOAT:
      jj_consume_token(FLOAT);
      jj_consume_token(PONTOVIRGULA);
      break;
    case CHAR:
      jj_consume_token(CHAR);
      jj_consume_token(PONTOVIRGULA);
      break;
    case IDENTIFIER:
      jj_consume_token(IDENTIFIER);
      variablesOperationAUX();
      break;
    case ESQPAR:
      jj_consume_token(ESQPAR);
      variablesOperationESQ();
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

// Vari?vel =
  static final public void variableAssignmentHelper() throws ParseException {
    jj_consume_token(IDENTIFIER);
    jj_consume_token(ASSIGNMENT);
  }

  static final public void variablesOperation() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFIER:
      jj_consume_token(IDENTIFIER);
      variablesOperationAUX();
      break;
    case NUM:
      jj_consume_token(NUM);
      variablesOperationAUX();
      break;
    default:
      jj_la1[8] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void variablesOperationAUX() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLUS:
    case MINUS:
    case MULTIPLY:
    case DIVIDE:
      Operation();
      variablesOperation();
      break;
    case DIRPAR:
      jj_consume_token(DIRPAR);
      Operation();
      variablesOperationESQ();
      break;
    case PONTOVIRGULA:
      jj_consume_token(PONTOVIRGULA);
      break;
    default:
      jj_la1[9] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void variablesOperationESQ() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFIER:
      jj_consume_token(IDENTIFIER);
      variablesOperationESQaAUX();
      break;
    case NUM:
      jj_consume_token(NUM);
      variablesOperationESQaAUX();
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void variablesOperationESQaAUX() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DIRPAR:
      jj_consume_token(DIRPAR);
      jj_consume_token(PONTOVIRGULA);
      break;
    case PLUS:
    case MINUS:
    case MULTIPLY:
    case DIVIDE:
      Operation();
      variablesOperationESQ();
      break;
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

// while(RelationalStatement()) { statement() }
  static final public void whileLoop() throws ParseException {
    jj_consume_token(WHILE);
    jj_consume_token(ESQPAR);
    RelationalStatement();
    jj_consume_token(DIRPAR);
    jj_consume_token(ESQCURLY);
    statement();
    jj_consume_token(DIRCURLY);
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public LexTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[12];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x7480000,0x7480000,0x7e000,0x1e00,0x7080000,0x7080000,0x7000000,0x6000000,0x0,0x1e00,0x0,0x1e00,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x4,0x4,0x0,0x0,0x104,0x4,0x0,0x4c,0xc,0x480,0xc,0x80,};
   }

  /** Constructor with InputStream. */
  public Lex(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Lex(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new LexTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Lex(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new LexTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Lex(LexTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(LexTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[43];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 12; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 43; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
