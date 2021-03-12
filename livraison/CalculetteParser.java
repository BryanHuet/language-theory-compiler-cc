// Generated from Calculette.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalculetteParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, NEWLINE=24, 
		TYPE=25, IDENTIFIANT=26, WS=27, NUMBER=28, BLOCK_DEBUT=29, BLOCK_END=30, 
		UNMATCH=31;
	public static final int
		RULE_start = 0, RULE_calcul = 1, RULE_bloc_instructs = 2, RULE_instruction = 3, 
		RULE_decl = 4, RULE_assignation = 5, RULE_methode = 6, RULE_expression = 7, 
		RULE_condition = 8, RULE_finInstruction = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "calcul", "bloc_instructs", "instruction", "decl", "assignation", 
			"methode", "expression", "condition", "finInstruction"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'read'", "'('", "')'", "'write'", "'while'", "'-'", "'+'", 
			"'*'", "'/'", "'(-'", "'true'", "'false'", "'=='", "'!='", "'<'", "'>'", 
			"'<='", "'>='", "'!'", "'&&'", "'||'", "';'", null, null, null, null, 
			null, "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"NEWLINE", "TYPE", "IDENTIFIANT", "WS", "NUMBER", "BLOCK_DEBUT", "BLOCK_END", 
			"UNMATCH"
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

	@Override
	public String getGrammarFileName() { return "Calculette.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	     private int _cur_label = 1;
	     /** générateur de nom d'étiquettes pour les boucles */
	     private String getNewLabel() { return "B" +(_cur_label++);}

	     private TablesSymboles tablesSymboles = new TablesSymboles();
	          
	public CalculetteParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public CalculContext calcul() {
			return getRuleContext(CalculContext.class,0);
		}
		public TerminalNode EOF() { return getToken(CalculetteParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			calcul();
			setState(21);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CalculContext extends ParserRuleContext {
		public String code;
		public DeclContext decl;
		public InstructionContext instruction;
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CalculetteParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CalculetteParser.NEWLINE, i);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public CalculContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calcul; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterCalcul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitCalcul(this);
		}
	}

	public final CalculContext calcul() throws RecognitionException {
		CalculContext _localctx = new CalculContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_calcul);
		 ((CalculContext)_localctx).code =  new String(); 
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE) {
				{
				{
				setState(23);
				((CalculContext)_localctx).decl = decl();
				 _localctx.code += ((CalculContext)_localctx).decl.code; 
				}
				}
				setState(30);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(34);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(31);
					match(NEWLINE);
					}
					} 
				}
				setState(36);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__19) | (1L << T__22) | (1L << NEWLINE) | (1L << IDENTIFIANT) | (1L << NUMBER))) != 0)) {
				{
				{
				setState(37);
				((CalculContext)_localctx).instruction = instruction();
				 _localctx.code += ((CalculContext)_localctx).instruction.code; 
				}
				}
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 _localctx.code += "  HALT\n"; 
			}
			_ctx.stop = _input.LT(-1);
			 System.out.println(_localctx.code); 
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Bloc_instructsContext extends ParserRuleContext {
		public String code;
		public DeclContext decl;
		public InstructionContext instruction;
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CalculetteParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CalculetteParser.NEWLINE, i);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public Bloc_instructsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloc_instructs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterBloc_instructs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitBloc_instructs(this);
		}
	}

	public final Bloc_instructsContext bloc_instructs() throws RecognitionException {
		Bloc_instructsContext _localctx = new Bloc_instructsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_bloc_instructs);
		 ((Bloc_instructsContext)_localctx).code =  new String(); 
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE) {
				{
				{
				setState(47);
				((Bloc_instructsContext)_localctx).decl = decl();
				 _localctx.code += ((Bloc_instructsContext)_localctx).decl.code; 
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(58);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(55);
					match(NEWLINE);
					}
					} 
				}
				setState(60);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__19) | (1L << T__22) | (1L << NEWLINE) | (1L << IDENTIFIANT) | (1L << NUMBER))) != 0)) {
				{
				{
				setState(61);
				((Bloc_instructsContext)_localctx).instruction = instruction();
				 _localctx.code += ((Bloc_instructsContext)_localctx).instruction.code; 
				}
				}
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			_ctx.stop = _input.LT(-1);
			 System.out.println(_localctx.code); 
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstructionContext extends ParserRuleContext {
		public String code;
		public ExpressionContext expression;
		public AssignationContext assignation;
		public ConditionContext condition;
		public MethodeContext methode;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
		}
		public AssignationContext assignation() {
			return getRuleContext(AssignationContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public MethodeContext methode() {
			return getRuleContext(MethodeContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitInstruction(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_instruction);
		try {
			setState(88);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				((InstructionContext)_localctx).expression = expression(0);
				setState(70);
				finInstruction();

				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).expression.code;
				            _localctx.code += "POP\n";
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				((InstructionContext)_localctx).assignation = assignation();
				setState(74);
				finInstruction();

				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).assignation.code;
				        
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(77);
				((InstructionContext)_localctx).condition = condition(0);
				setState(78);
				finInstruction();

				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).condition.code;
				        
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(81);
				((InstructionContext)_localctx).methode = methode();
				setState(82);
				finInstruction();

				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).methode.code;
				        
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(85);
				finInstruction();

				            ((InstructionContext)_localctx).code = "";
				            _localctx.code += "POP\n";
				        
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public String code;
		public Token IDENTIFIANT;
		public ExpressionContext expression;
		public TerminalNode TYPE() { return getToken(CalculetteParser.TYPE, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_decl);
		try {
			setState(102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				match(TYPE);
				setState(91);
				((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(92);
				finInstruction();

				            tablesSymboles.putVar((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null),"int");
				            AdresseType at = tablesSymboles.getAdresseType((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null));
				            ((DeclContext)_localctx).code =  "PUSHG "+at.adresse+"\n";
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
				match(TYPE);
				setState(96);
				((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(97);
				match(T__0);
				setState(98);
				((DeclContext)_localctx).expression = expression(0);
				setState(99);
				finInstruction();

				            tablesSymboles.putVar((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null),"int");
				            AdresseType at = tablesSymboles.getAdresseType((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null));
				            ((DeclContext)_localctx).code =  "PUSHG "+at.adresse+"\n";
				            _localctx.code += ((DeclContext)_localctx).expression.code;
				            _localctx.code += "STOREG "+at.adresse+"\n";
				        
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignationContext extends ParserRuleContext {
		public String code;
		public Token IDENTIFIANT;
		public ExpressionContext expression;
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterAssignation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitAssignation(this);
		}
	}

	public final AssignationContext assignation() throws RecognitionException {
		AssignationContext _localctx = new AssignationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assignation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			setState(105);
			match(T__0);
			setState(106);
			((AssignationContext)_localctx).expression = expression(0);

			            AdresseType at = tablesSymboles.getAdresseType((((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null));
			            ((AssignationContext)_localctx).code =  ((AssignationContext)_localctx).expression.code;
			            _localctx.code += "STOREG "+at.adresse+"\n";
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodeContext extends ParserRuleContext {
		public String code;
		public Token IDENTIFIANT;
		public ExpressionContext expression;
		public ConditionContext a;
		public Bloc_instructsContext b;
		public ConditionContext ab;
		public InstructionContext bb;
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode BLOCK_DEBUT() { return getToken(CalculetteParser.BLOCK_DEBUT, 0); }
		public TerminalNode BLOCK_END() { return getToken(CalculetteParser.BLOCK_END, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public Bloc_instructsContext bloc_instructs() {
			return getRuleContext(Bloc_instructsContext.class,0);
		}
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public MethodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterMethode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitMethode(this);
		}
	}

	public final MethodeContext methode() throws RecognitionException {
		MethodeContext _localctx = new MethodeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_methode);
		int _la;
		try {
			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(110); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(109);
					match(T__1);
					}
					}
					setState(112); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__1 );
				setState(114);
				match(T__2);
				setState(115);
				((MethodeContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(116);
				match(T__3);

				            AdresseType at = tablesSymboles.getAdresseType((((MethodeContext)_localctx).IDENTIFIANT!=null?((MethodeContext)_localctx).IDENTIFIANT.getText():null));
				            ((MethodeContext)_localctx).code =  "READ\n";
				            _localctx.code += "STOREG "+at.adresse+"\n";
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(119); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(118);
					match(T__4);
					}
					}
					setState(121); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__4 );
				setState(123);
				match(T__2);
				setState(124);
				((MethodeContext)_localctx).expression = expression(0);
				setState(125);
				match(T__3);

				            ((MethodeContext)_localctx).code =  ((MethodeContext)_localctx).expression.code;
				            _localctx.code += "WRITE\n";
				            _localctx.code += "POP\n";
				        
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(129); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(128);
					match(T__5);
					}
					}
					setState(131); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__5 );
				setState(133);
				match(T__2);
				setState(134);
				((MethodeContext)_localctx).a = condition(0);
				setState(135);
				match(T__3);
				setState(136);
				match(BLOCK_DEBUT);
				setState(137);
				((MethodeContext)_localctx).b = bloc_instructs();
				setState(138);
				match(BLOCK_END);

				            String debutB = getNewLabel();
				            String finB = getNewLabel();
				            ((MethodeContext)_localctx).code =  "LABEL "+debutB+"\n";
				            _localctx.code += ((MethodeContext)_localctx).a.code;
				            _localctx.code += "JUMPF "+finB+"\n";
				            _localctx.code += ((MethodeContext)_localctx).b.code;
				            _localctx.code += "JUMP "+debutB+"\n";
				            _localctx.code += "LABEL "+finB+"\n";
				        
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(142); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(141);
					match(T__5);
					}
					}
					setState(144); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__5 );
				setState(146);
				match(T__2);
				setState(147);
				((MethodeContext)_localctx).ab = condition(0);
				setState(148);
				match(T__3);
				setState(149);
				((MethodeContext)_localctx).bb = instruction();

				            String debutB = getNewLabel();
				            String finB = getNewLabel();
				            ((MethodeContext)_localctx).code =  "LABEL "+debutB+"\n";
				            _localctx.code += ((MethodeContext)_localctx).ab.code;
				            _localctx.code += "JUMPF "+finB+"\n";
				            _localctx.code += ((MethodeContext)_localctx).bb.code;
				            _localctx.code += "JUMP "+debutB+"\n";
				            _localctx.code += "LABEL "+finB+"\n";
				        
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public String code;
		public ExpressionContext a;
		public Token op;
		public ExpressionContext b;
		public Token NUMBER;
		public Token IDENTIFIANT;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode NUMBER() { return getToken(CalculetteParser.NUMBER, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(155);
				match(T__2);
				setState(156);
				((ExpressionContext)_localctx).a = expression(0);
				setState(157);
				((ExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__6 || _la==T__7) ) {
					((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(158);
				((ExpressionContext)_localctx).b = expression(0);
				setState(159);
				match(T__3);

				            ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code + ((ExpressionContext)_localctx).b.code;
				            _localctx.code += (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null).equals("+") ? "ADD\n" : "SUB\n";
				        
				}
				break;
			case 2:
				{
				setState(162);
				match(T__2);
				setState(163);
				((ExpressionContext)_localctx).a = expression(0);
				setState(164);
				((ExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__8 || _la==T__9) ) {
					((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(165);
				((ExpressionContext)_localctx).b = expression(0);
				setState(166);
				match(T__3);

				        ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code + ((ExpressionContext)_localctx).b.code;
				        _localctx.code += (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null).equals("*") ? "MUL\n" : "DIV\n";
				    
				}
				break;
			case 3:
				{
				setState(169);
				((ExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__2 || _la==T__10) ) {
					((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(170);
				((ExpressionContext)_localctx).NUMBER = match(NUMBER);
				setState(171);
				match(T__3);

				        ((ExpressionContext)_localctx).code =  (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null).equals("(-") ? "PUSHI -"+(((ExpressionContext)_localctx).NUMBER!=null?((ExpressionContext)_localctx).NUMBER.getText():null)+"\n" : "PUSHI "+(((ExpressionContext)_localctx).NUMBER!=null?((ExpressionContext)_localctx).NUMBER.getText():null)+"\n";
				    
				}
				break;
			case 4:
				{
				setState(173);
				((ExpressionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);

				            AdresseType at = tablesSymboles.getAdresseType((((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null));
				            ((ExpressionContext)_localctx).code =  "PUSHG "+at.adresse+"\n";
				        
				}
				break;
			case 5:
				{
				setState(175);
				match(T__6);
				setState(176);
				((ExpressionContext)_localctx).NUMBER = match(NUMBER);

				         ((ExpressionContext)_localctx).code =  "PUSHI -"+(((ExpressionContext)_localctx).NUMBER!=null?((ExpressionContext)_localctx).NUMBER.getText():null)+"\n";
				     
				}
				break;
			case 6:
				{
				setState(178);
				((ExpressionContext)_localctx).NUMBER = match(NUMBER);

				            ((ExpressionContext)_localctx).code =  "PUSHI "+(((ExpressionContext)_localctx).NUMBER!=null?((ExpressionContext)_localctx).NUMBER.getText():null)+"\n";
				        
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(194);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(192);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(182);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(183);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__8 || _la==T__9) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(184);
						((ExpressionContext)_localctx).b = expression(7);

						                  ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code + ((ExpressionContext)_localctx).b.code;
						                  _localctx.code += (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null).equals("*") ? "MUL\n" : "DIV\n";
						              
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(187);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(188);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__6 || _la==T__7) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(189);
						((ExpressionContext)_localctx).b = expression(6);

						                      ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code + ((ExpressionContext)_localctx).b.code;
						                      _localctx.code += (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null).equals("+") ? "ADD\n" : "SUB\n";
						                  
						}
						break;
					}
					} 
				}
				setState(196);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public String code;
		public ConditionContext exprA;
		public ConditionContext exprC;
		public ExpressionContext expr1;
		public Token op;
		public ExpressionContext expr2;
		public ExpressionContext expr3;
		public ExpressionContext expr4;
		public ConditionContext exprB;
		public ConditionContext exprD;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		return condition(0);
	}

	private ConditionContext condition(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionContext _localctx = new ConditionContext(_ctx, _parentState);
		ConditionContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_condition, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				{
				setState(198);
				match(T__11);
				 ((ConditionContext)_localctx).code =  "  PUSHI 1\n"; 
				}
				break;
			case T__12:
				{
				setState(200);
				match(T__12);
				 ((ConditionContext)_localctx).code =  "  PUSHI 0\n"; 
				}
				break;
			case T__2:
			case T__6:
			case T__10:
			case IDENTIFIANT:
			case NUMBER:
				{
				setState(202);
				((ConditionContext)_localctx).expr1 = expression(0);
				setState(203);
				((ConditionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18))) != 0)) ) {
					((ConditionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(204);
				((ConditionContext)_localctx).expr2 = expression(0);

				            ((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).expr1.code + ((ConditionContext)_localctx).expr2.code;
				            if ((((ConditionContext)_localctx).op!=null?((ConditionContext)_localctx).op.getText():null).equals("==")){ _localctx.code += "EQUAL\n"; }
				            else if ((((ConditionContext)_localctx).op!=null?((ConditionContext)_localctx).op.getText():null).equals("!=")){ _localctx.code += "NEQ\n"; }
				            else if ((((ConditionContext)_localctx).op!=null?((ConditionContext)_localctx).op.getText():null).equals("<")){ _localctx.code += "INF\n"; }
				            else if ((((ConditionContext)_localctx).op!=null?((ConditionContext)_localctx).op.getText():null).equals(">")){ _localctx.code += "SUP\n"; }
				            else if ((((ConditionContext)_localctx).op!=null?((ConditionContext)_localctx).op.getText():null).equals("<=")){ _localctx.code += "INFEQ\n"; }
				            else if ((((ConditionContext)_localctx).op!=null?((ConditionContext)_localctx).op.getText():null).equals(">=")){ _localctx.code += "SUPEQ\n"; }
				        
				}
				break;
			case T__19:
				{
				setState(207);
				match(T__19);
				setState(208);
				((ConditionContext)_localctx).expr3 = expression(0);
				setState(209);
				((ConditionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18))) != 0)) ) {
					((ConditionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(210);
				((ConditionContext)_localctx).expr4 = expression(0);

				            ((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).expr3.code + ((ConditionContext)_localctx).expr4.code;
				            if ((((ConditionContext)_localctx).op!=null?((ConditionContext)_localctx).op.getText():null).equals("==")){ _localctx.code += "NEQ\n"; }
				            else if ((((ConditionContext)_localctx).op!=null?((ConditionContext)_localctx).op.getText():null).equals("!=")){ _localctx.code += "EQUAL\n"; }
				            else if ((((ConditionContext)_localctx).op!=null?((ConditionContext)_localctx).op.getText():null).equals("<")){ _localctx.code += "SUP\n"; }
				            else if ((((ConditionContext)_localctx).op!=null?((ConditionContext)_localctx).op.getText():null).equals(">")){ _localctx.code += "INF\n"; }
				            else if ((((ConditionContext)_localctx).op!=null?((ConditionContext)_localctx).op.getText():null).equals("<=")){ _localctx.code += "SUPEQ\n"; }
				            else if ((((ConditionContext)_localctx).op!=null?((ConditionContext)_localctx).op.getText():null).equals(">=")){ _localctx.code += "INFEQ\n"; }
				        
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(227);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(225);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new ConditionContext(_parentctx, _parentState);
						_localctx.exprA = _prevctx;
						_localctx.exprA = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(215);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(216);
						((ConditionContext)_localctx).op = match(T__20);
						setState(217);
						((ConditionContext)_localctx).exprB = condition(3);

						                      ((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).exprA.code + ((ConditionContext)_localctx).exprB.code;
						                      _localctx.code += "MUL \n";
						                  
						}
						break;
					case 2:
						{
						_localctx = new ConditionContext(_parentctx, _parentState);
						_localctx.exprC = _prevctx;
						_localctx.exprC = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(220);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(221);
						((ConditionContext)_localctx).op = match(T__21);
						setState(222);
						((ConditionContext)_localctx).exprD = condition(2);

						                      ((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).exprC.code + ((ConditionContext)_localctx).exprD.code + "\n";
						                      _localctx.code += "ADD \n";
						                      _localctx.code += "PUSHI 0 \n";
						                      _localctx.code += "SUP \n";
						                  
						}
						break;
					}
					} 
				}
				setState(229);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FinInstructionContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(CalculetteParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CalculetteParser.NEWLINE, i);
		}
		public FinInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finInstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterFinInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitFinInstruction(this);
		}
	}

	public final FinInstructionContext finInstruction() throws RecognitionException {
		FinInstructionContext _localctx = new FinInstructionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_finInstruction);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(231); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(230);
					_la = _input.LA(1);
					if ( !(_la==T__22 || _la==NEWLINE) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(233); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 7:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 8:
			return condition_sempred((ConditionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		}
		return true;
	}
	private boolean condition_sempred(ConditionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3!\u00ee\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\3\2\3\2\3\3\3\3\3\3\7\3\35\n\3\f\3\16\3 \13\3\3\3\7\3#\n\3\f\3"+
		"\16\3&\13\3\3\3\3\3\3\3\7\3+\n\3\f\3\16\3.\13\3\3\3\3\3\3\4\3\4\3\4\7"+
		"\4\65\n\4\f\4\16\48\13\4\3\4\7\4;\n\4\f\4\16\4>\13\4\3\4\3\4\3\4\7\4C"+
		"\n\4\f\4\16\4F\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5[\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\5\6i\n\6\3\7\3\7\3\7\3\7\3\7\3\b\6\bq\n\b\r\b\16\br\3\b"+
		"\3\b\3\b\3\b\3\b\6\bz\n\b\r\b\16\b{\3\b\3\b\3\b\3\b\3\b\3\b\6\b\u0084"+
		"\n\b\r\b\16\b\u0085\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\6\b\u0091\n\b"+
		"\r\b\16\b\u0092\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u009b\n\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\5\t\u00b7\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\7\t\u00c3\n\t\f\t\16\t\u00c6\13\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00d8\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\7\n\u00e4\n\n\f\n\16\n\u00e7\13\n\3\13\6\13\u00ea\n\13"+
		"\r\13\16\13\u00eb\3\13\2\4\20\22\f\2\4\6\b\n\f\16\20\22\24\2\7\3\2\t\n"+
		"\3\2\13\f\4\2\5\5\r\r\3\2\20\25\3\2\31\32\2\u0102\2\26\3\2\2\2\4\36\3"+
		"\2\2\2\6\66\3\2\2\2\bZ\3\2\2\2\nh\3\2\2\2\fj\3\2\2\2\16\u009a\3\2\2\2"+
		"\20\u00b6\3\2\2\2\22\u00d7\3\2\2\2\24\u00e9\3\2\2\2\26\27\5\4\3\2\27\30"+
		"\7\2\2\3\30\3\3\2\2\2\31\32\5\n\6\2\32\33\b\3\1\2\33\35\3\2\2\2\34\31"+
		"\3\2\2\2\35 \3\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37$\3\2\2\2 \36\3\2\2"+
		"\2!#\7\32\2\2\"!\3\2\2\2#&\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%,\3\2\2\2&$\3"+
		"\2\2\2\'(\5\b\5\2()\b\3\1\2)+\3\2\2\2*\'\3\2\2\2+.\3\2\2\2,*\3\2\2\2,"+
		"-\3\2\2\2-/\3\2\2\2.,\3\2\2\2/\60\b\3\1\2\60\5\3\2\2\2\61\62\5\n\6\2\62"+
		"\63\b\4\1\2\63\65\3\2\2\2\64\61\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67"+
		"\3\2\2\2\67<\3\2\2\28\66\3\2\2\29;\7\32\2\2:9\3\2\2\2;>\3\2\2\2<:\3\2"+
		"\2\2<=\3\2\2\2=D\3\2\2\2><\3\2\2\2?@\5\b\5\2@A\b\4\1\2AC\3\2\2\2B?\3\2"+
		"\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2E\7\3\2\2\2FD\3\2\2\2GH\5\20\t\2HI\5"+
		"\24\13\2IJ\b\5\1\2J[\3\2\2\2KL\5\f\7\2LM\5\24\13\2MN\b\5\1\2N[\3\2\2\2"+
		"OP\5\22\n\2PQ\5\24\13\2QR\b\5\1\2R[\3\2\2\2ST\5\16\b\2TU\5\24\13\2UV\b"+
		"\5\1\2V[\3\2\2\2WX\5\24\13\2XY\b\5\1\2Y[\3\2\2\2ZG\3\2\2\2ZK\3\2\2\2Z"+
		"O\3\2\2\2ZS\3\2\2\2ZW\3\2\2\2[\t\3\2\2\2\\]\7\33\2\2]^\7\34\2\2^_\5\24"+
		"\13\2_`\b\6\1\2`i\3\2\2\2ab\7\33\2\2bc\7\34\2\2cd\7\3\2\2de\5\20\t\2e"+
		"f\5\24\13\2fg\b\6\1\2gi\3\2\2\2h\\\3\2\2\2ha\3\2\2\2i\13\3\2\2\2jk\7\34"+
		"\2\2kl\7\3\2\2lm\5\20\t\2mn\b\7\1\2n\r\3\2\2\2oq\7\4\2\2po\3\2\2\2qr\3"+
		"\2\2\2rp\3\2\2\2rs\3\2\2\2st\3\2\2\2tu\7\5\2\2uv\7\34\2\2vw\7\6\2\2w\u009b"+
		"\b\b\1\2xz\7\7\2\2yx\3\2\2\2z{\3\2\2\2{y\3\2\2\2{|\3\2\2\2|}\3\2\2\2}"+
		"~\7\5\2\2~\177\5\20\t\2\177\u0080\7\6\2\2\u0080\u0081\b\b\1\2\u0081\u009b"+
		"\3\2\2\2\u0082\u0084\7\b\2\2\u0083\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085"+
		"\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\7\5"+
		"\2\2\u0088\u0089\5\22\n\2\u0089\u008a\7\6\2\2\u008a\u008b\7\37\2\2\u008b"+
		"\u008c\5\6\4\2\u008c\u008d\7 \2\2\u008d\u008e\b\b\1\2\u008e\u009b\3\2"+
		"\2\2\u008f\u0091\7\b\2\2\u0090\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092"+
		"\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0095\7\5"+
		"\2\2\u0095\u0096\5\22\n\2\u0096\u0097\7\6\2\2\u0097\u0098\5\b\5\2\u0098"+
		"\u0099\b\b\1\2\u0099\u009b\3\2\2\2\u009ap\3\2\2\2\u009ay\3\2\2\2\u009a"+
		"\u0083\3\2\2\2\u009a\u0090\3\2\2\2\u009b\17\3\2\2\2\u009c\u009d\b\t\1"+
		"\2\u009d\u009e\7\5\2\2\u009e\u009f\5\20\t\2\u009f\u00a0\t\2\2\2\u00a0"+
		"\u00a1\5\20\t\2\u00a1\u00a2\7\6\2\2\u00a2\u00a3\b\t\1\2\u00a3\u00b7\3"+
		"\2\2\2\u00a4\u00a5\7\5\2\2\u00a5\u00a6\5\20\t\2\u00a6\u00a7\t\3\2\2\u00a7"+
		"\u00a8\5\20\t\2\u00a8\u00a9\7\6\2\2\u00a9\u00aa\b\t\1\2\u00aa\u00b7\3"+
		"\2\2\2\u00ab\u00ac\t\4\2\2\u00ac\u00ad\7\36\2\2\u00ad\u00ae\7\6\2\2\u00ae"+
		"\u00b7\b\t\1\2\u00af\u00b0\7\34\2\2\u00b0\u00b7\b\t\1\2\u00b1\u00b2\7"+
		"\t\2\2\u00b2\u00b3\7\36\2\2\u00b3\u00b7\b\t\1\2\u00b4\u00b5\7\36\2\2\u00b5"+
		"\u00b7\b\t\1\2\u00b6\u009c\3\2\2\2\u00b6\u00a4\3\2\2\2\u00b6\u00ab\3\2"+
		"\2\2\u00b6\u00af\3\2\2\2\u00b6\u00b1\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7"+
		"\u00c4\3\2\2\2\u00b8\u00b9\f\b\2\2\u00b9\u00ba\t\3\2\2\u00ba\u00bb\5\20"+
		"\t\t\u00bb\u00bc\b\t\1\2\u00bc\u00c3\3\2\2\2\u00bd\u00be\f\7\2\2\u00be"+
		"\u00bf\t\2\2\2\u00bf\u00c0\5\20\t\b\u00c0\u00c1\b\t\1\2\u00c1\u00c3\3"+
		"\2\2\2\u00c2\u00b8\3\2\2\2\u00c2\u00bd\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4"+
		"\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\21\3\2\2\2\u00c6\u00c4\3\2\2"+
		"\2\u00c7\u00c8\b\n\1\2\u00c8\u00c9\7\16\2\2\u00c9\u00d8\b\n\1\2\u00ca"+
		"\u00cb\7\17\2\2\u00cb\u00d8\b\n\1\2\u00cc\u00cd\5\20\t\2\u00cd\u00ce\t"+
		"\5\2\2\u00ce\u00cf\5\20\t\2\u00cf\u00d0\b\n\1\2\u00d0\u00d8\3\2\2\2\u00d1"+
		"\u00d2\7\26\2\2\u00d2\u00d3\5\20\t\2\u00d3\u00d4\t\5\2\2\u00d4\u00d5\5"+
		"\20\t\2\u00d5\u00d6\b\n\1\2\u00d6\u00d8\3\2\2\2\u00d7\u00c7\3\2\2\2\u00d7"+
		"\u00ca\3\2\2\2\u00d7\u00cc\3\2\2\2\u00d7\u00d1\3\2\2\2\u00d8\u00e5\3\2"+
		"\2\2\u00d9\u00da\f\4\2\2\u00da\u00db\7\27\2\2\u00db\u00dc\5\22\n\5\u00dc"+
		"\u00dd\b\n\1\2\u00dd\u00e4\3\2\2\2\u00de\u00df\f\3\2\2\u00df\u00e0\7\30"+
		"\2\2\u00e0\u00e1\5\22\n\4\u00e1\u00e2\b\n\1\2\u00e2\u00e4\3\2\2\2\u00e3"+
		"\u00d9\3\2\2\2\u00e3\u00de\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5\u00e3\3\2"+
		"\2\2\u00e5\u00e6\3\2\2\2\u00e6\23\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e8\u00ea"+
		"\t\6\2\2\u00e9\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb"+
		"\u00ec\3\2\2\2\u00ec\25\3\2\2\2\26\36$,\66<DZhr{\u0085\u0092\u009a\u00b6"+
		"\u00c2\u00c4\u00d7\u00e3\u00e5\u00eb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}