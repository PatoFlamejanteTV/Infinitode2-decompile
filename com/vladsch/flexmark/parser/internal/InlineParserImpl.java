/*      */ package com.vladsch.flexmark.parser.internal;
/*      */ import com.vladsch.flexmark.ast.AutoLink;
/*      */ import com.vladsch.flexmark.ast.HtmlInlineComment;
/*      */ import com.vladsch.flexmark.ast.InlineLinkNode;
/*      */ import com.vladsch.flexmark.ast.LinkRefDerived;
/*      */ import com.vladsch.flexmark.ast.Paragraph;
/*      */ import com.vladsch.flexmark.ast.RefNode;
/*      */ import com.vladsch.flexmark.ast.Text;
/*      */ import com.vladsch.flexmark.ast.util.TextNodeConverter;
/*      */ import com.vladsch.flexmark.parser.InlineParserExtension;
/*      */ import com.vladsch.flexmark.parser.InlineParserExtensionFactory;
/*      */ import com.vladsch.flexmark.parser.LinkRefProcessor;
/*      */ import com.vladsch.flexmark.parser.LinkRefProcessorFactory;
/*      */ import com.vladsch.flexmark.parser.Parser;
/*      */ import com.vladsch.flexmark.parser.block.CharacterNodeFactory;
/*      */ import com.vladsch.flexmark.parser.core.delimiter.Bracket;
/*      */ import com.vladsch.flexmark.parser.core.delimiter.Delimiter;
/*      */ import com.vladsch.flexmark.parser.delimiter.DelimiterProcessor;
/*      */ import com.vladsch.flexmark.util.ast.Document;
/*      */ import com.vladsch.flexmark.util.ast.Node;
/*      */ import com.vladsch.flexmark.util.data.DataHolder;
/*      */ import com.vladsch.flexmark.util.misc.CharPredicate;
/*      */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*      */ import java.util.ArrayList;
/*      */ import java.util.BitSet;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.regex.Matcher;
/*      */ 
/*      */ public class InlineParserImpl extends LightInlineParserImpl implements InlineParser, ParagraphPreProcessor {
/*      */   protected final BitSet originalSpecialCharacters;
/*      */   protected final BitSet delimiterCharacters;
/*   35 */   protected List<LinkRefProcessor> linkRefProcessors = null; protected final Map<Character, DelimiterProcessor> delimiterProcessors; protected final LinkRefProcessorData linkRefProcessorsData;
/*   36 */   protected Map<Character, List<InlineParserExtension>> inlineParserExtensions = null;
/*   37 */   protected List<InlineParserExtensionFactory> inlineParserExtensionFactories = null;
/*   38 */   protected LinkDestinationParser linkDestinationParser = null;
/*      */   
/*      */   protected BitSet specialCharacters;
/*      */   
/*   42 */   protected BitSet customCharacters = null;
/*   43 */   protected Map<Character, CharacterNodeFactory> customSpecialCharacterFactoryMap = null;
/*   44 */   protected ArrayList<Node> customSpecialCharacterNodes = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected ReferenceRepository referenceRepository;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Delimiter lastDelimiter;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Bracket lastBracket;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public InlineParserImpl(DataHolder paramDataHolder, BitSet paramBitSet1, BitSet paramBitSet2, Map<Character, DelimiterProcessor> paramMap, LinkRefProcessorData paramLinkRefProcessorData, List<InlineParserExtensionFactory> paramList) {
/*   70 */     super(paramDataHolder);
/*   71 */     this.delimiterProcessors = paramMap;
/*   72 */     this.linkRefProcessorsData = paramLinkRefProcessorData;
/*   73 */     this.delimiterCharacters = paramBitSet2;
/*   74 */     this.originalSpecialCharacters = paramBitSet1;
/*   75 */     this.specialCharacters = paramBitSet1;
/*   76 */     this.inlineParserExtensionFactories = !paramList.isEmpty() ? paramList : null;
/*      */     
/*   78 */     if (this.options.useHardcodedLinkAddressParser) {
/*   79 */       this.linkDestinationParser = new LinkDestinationParser(this.options.linksAllowMatchedParentheses, this.options.spaceInLinkUrls, this.options.parseJekyllMacrosInUrls, this.options.intellijDummyIdentifier);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void initializeDocument(Document paramDocument) {
/*   85 */     this.document = paramDocument;
/*   86 */     this.referenceRepository = (ReferenceRepository)Parser.REFERENCES.get((DataHolder)paramDocument);
/*      */     
/*   88 */     this.linkRefProcessors = new ArrayList<>(this.linkRefProcessorsData.processors.size());
/*   89 */     for (LinkRefProcessorFactory linkRefProcessorFactory : this.linkRefProcessorsData.processors) {
/*   90 */       this.linkRefProcessors.add(linkRefProcessorFactory.apply(paramDocument));
/*      */     }
/*      */ 
/*      */     
/*   94 */     if (this.inlineParserExtensionFactories != null) {
/*   95 */       Map<Character, List<InlineParserExtensionFactory>> map = calculateInlineParserExtensions((DataHolder)paramDocument, this.inlineParserExtensionFactories);
/*   96 */       this.inlineParserExtensions = new HashMap<>(map.size());
/*   97 */       HashMap<Object, Object> hashMap = new HashMap<>();
/*   98 */       for (Map.Entry<Character, List<InlineParserExtensionFactory>> entry : map.entrySet()) {
/*   99 */         ArrayList<InlineParserExtension> arrayList = new ArrayList(((List)entry.getValue()).size());
/*  100 */         for (InlineParserExtensionFactory inlineParserExtensionFactory : entry.getValue()) {
/*      */           InlineParserExtension inlineParserExtension;
/*  102 */           if ((inlineParserExtension = (InlineParserExtension)hashMap.get(inlineParserExtensionFactory)) == null) {
/*  103 */             inlineParserExtension = inlineParserExtensionFactory.apply((LightInlineParser)this);
/*  104 */             hashMap.put(inlineParserExtensionFactory, inlineParserExtension);
/*      */           } 
/*  106 */           arrayList.add(inlineParserExtension);
/*      */         } 
/*      */         
/*  109 */         this.inlineParserExtensions.put((Character)entry.getKey(), arrayList);
/*      */ 
/*      */         
/*  112 */         this.specialCharacters.set(((Character)entry.getKey()).charValue());
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void finalizeDocument(Document paramDocument) {
/*  119 */     assert this.referenceRepository == Parser.REFERENCES.get((DataHolder)paramDocument);
/*      */     
/*  121 */     if (this.inlineParserExtensions != null) {
/*  122 */       for (Iterator<List> iterator = this.inlineParserExtensions.values().iterator(); iterator.hasNext();) {
/*  123 */         for (Iterator<?> iterator1 = (list = iterator.next()).iterator(); iterator1.hasNext();) {
/*  124 */           (inlineParserExtension = (InlineParserExtension)iterator1.next()).finalizeDocument(this);
/*      */         }
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public Delimiter getLastDelimiter() {
/*  132 */     return this.lastDelimiter;
/*      */   }
/*      */ 
/*      */   
/*      */   public Bracket getLastBracket() {
/*  137 */     return this.lastBracket;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public List<Node> parseCustom(BasedSequence paramBasedSequence, Node paramNode, BitSet paramBitSet, Map<Character, CharacterNodeFactory> paramMap) {
/*  143 */     this.customCharacters = paramBitSet;
/*  144 */     this.specialCharacters.or(paramBitSet);
/*  145 */     this.customSpecialCharacterFactoryMap = paramMap;
/*  146 */     this.customSpecialCharacterNodes = null;
/*  147 */     parse(paramBasedSequence, paramNode);
/*  148 */     this.specialCharacters = this.originalSpecialCharacters;
/*  149 */     this.customSpecialCharacterFactoryMap = null;
/*  150 */     this.customCharacters = null;
/*  151 */     return this.customSpecialCharacterNodes;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void parse(BasedSequence paramBasedSequence, Node paramNode) {
/*  159 */     this.block = paramNode;
/*  160 */     this.input = (BasedSequence)paramBasedSequence.trim();
/*  161 */     this.index = 0;
/*  162 */     this.lastDelimiter = null;
/*  163 */     this.lastBracket = null;
/*      */     
/*  165 */     boolean bool1 = paramNode instanceof com.vladsch.flexmark.util.ast.DoNotDecorate;
/*      */     
/*      */     boolean bool2;
/*      */     do {
/*      */     
/*  170 */     } while (bool2 = parseInline(bool1));
/*      */     
/*  172 */     processDelimiters((Delimiter)null);
/*  173 */     flushTextNode();
/*      */     
/*  175 */     if (!bool1 && 
/*  176 */       this.inlineParserExtensions != null) {
/*  177 */       for (Iterator<List> iterator = this.inlineParserExtensions.values().iterator(); iterator.hasNext();) {
/*  178 */         for (Iterator<?> iterator1 = (list = iterator.next()).iterator(); iterator1.hasNext();) {
/*  179 */           (inlineParserExtension = (InlineParserExtension)iterator1.next()).finalizeBlock(this);
/*      */         }
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  186 */     mergeTextNodes(paramNode.getFirstChild(), paramNode.getLastChild());
/*      */   }
/*      */ 
/*      */   
/*      */   public void mergeTextNodes(Node paramNode1, Node paramNode2) {
/*  191 */     Text text1 = null;
/*  192 */     Text text2 = null;
/*      */     
/*  194 */     paramNode1 = paramNode1;
/*  195 */     while (paramNode1 != null) {
/*  196 */       if (paramNode1 instanceof Text) {
/*  197 */         text2 = (Text)paramNode1;
/*  198 */         if (text1 == null) {
/*  199 */           text1 = text2;
/*      */         }
/*  201 */         text2 = text2;
/*      */       } else {
/*  203 */         mergeIfNeeded(text1, text2);
/*  204 */         text1 = null;
/*  205 */         text2 = null;
/*      */       } 
/*      */       
/*  208 */       if (paramNode1 != paramNode2)
/*      */       {
/*      */ 
/*      */         
/*  212 */         paramNode1 = paramNode1.getNext();
/*      */       }
/*      */     } 
/*  215 */     mergeIfNeeded(text1, text2);
/*      */   }
/*      */ 
/*      */   
/*      */   public void mergeIfNeeded(Text paramText1, Text paramText2) {
/*  220 */     if (paramText1 != null && paramText2 != null && paramText1 != paramText2) {
/*      */       ArrayList<BasedSequence> arrayList;
/*  222 */       (arrayList = new ArrayList<>()).add(paramText1.getChars());
/*  223 */       Node node2 = paramText1.getNext();
/*  224 */       Node node1 = paramText2.getNext();
/*  225 */       while (node2 != node1) {
/*  226 */         arrayList.add(node2.getChars());
/*  227 */         Node node = node2;
/*  228 */         node2 = node2.getNext();
/*  229 */         node.unlink();
/*      */       } 
/*  231 */       BasedSequence basedSequence = SegmentedSequence.create(paramText1.getChars(), arrayList);
/*  232 */       paramText1.setChars(basedSequence);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int preProcessBlock(Paragraph paramParagraph, ParserState paramParserState) {
/*      */     BasedSequence basedSequence;
/*  244 */     int i = (basedSequence = paramParagraph.getChars()).countLeading(CharPredicate.SPACE_TAB);
/*  245 */     int j = basedSequence.length();
/*      */     
/*  247 */     while (i <= 3 && j > i + 3 && basedSequence.charAt(i) == '[') {
/*  248 */       if (i > 0) {
/*  249 */         basedSequence = basedSequence.subSequence(i, j);
/*  250 */         j -= i;
/*      */       } 
/*      */ 
/*      */       
/*  254 */       if ((i = parseReference((Block)paramParagraph, basedSequence)) != 0) {
/*      */         
/*  256 */         j = (basedSequence = basedSequence.subSequence(i, j)).length();
/*  257 */         i = basedSequence.countLeading(CharPredicate.SPACE_TAB);
/*      */       } 
/*      */     } 
/*  260 */     return basedSequence.getStartOffset() - paramParagraph.getStartOffset();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected int parseReference(Block paramBlock, BasedSequence paramBasedSequence) {
/*      */     // Byte code:
/*      */     //   0: aload_0
/*      */     //   1: aload_2
/*      */     //   2: putfield input : Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*      */     //   5: aload_0
/*      */     //   6: iconst_0
/*      */     //   7: putfield index : I
/*      */     //   10: aload_0
/*      */     //   11: getfield index : I
/*      */     //   14: istore #4
/*      */     //   16: aload_0
/*      */     //   17: invokevirtual parseLinkLabel : ()I
/*      */     //   20: dup
/*      */     //   21: istore_2
/*      */     //   22: ifne -> 27
/*      */     //   25: iconst_0
/*      */     //   26: ireturn
/*      */     //   27: aload_0
/*      */     //   28: invokevirtual peek : ()C
/*      */     //   31: bipush #58
/*      */     //   33: if_icmpeq -> 38
/*      */     //   36: iconst_0
/*      */     //   37: ireturn
/*      */     //   38: aload_0
/*      */     //   39: getfield input : Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*      */     //   42: iconst_0
/*      */     //   43: iload_2
/*      */     //   44: iconst_1
/*      */     //   45: iadd
/*      */     //   46: invokeinterface subSequence : (II)Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*      */     //   51: astore #5
/*      */     //   53: aload_0
/*      */     //   54: dup
/*      */     //   55: getfield index : I
/*      */     //   58: iconst_1
/*      */     //   59: iadd
/*      */     //   60: putfield index : I
/*      */     //   63: aload_0
/*      */     //   64: invokevirtual spnl : ()Z
/*      */     //   67: pop
/*      */     //   68: aload_0
/*      */     //   69: invokevirtual parseLinkDestination : ()Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*      */     //   72: dup
/*      */     //   73: astore_2
/*      */     //   74: ifnull -> 86
/*      */     //   77: aload_2
/*      */     //   78: invokeinterface length : ()I
/*      */     //   83: ifne -> 88
/*      */     //   86: iconst_0
/*      */     //   87: ireturn
/*      */     //   88: aload_0
/*      */     //   89: getfield index : I
/*      */     //   92: istore #6
/*      */     //   94: aload_0
/*      */     //   95: invokevirtual spnl : ()Z
/*      */     //   98: pop
/*      */     //   99: aload_0
/*      */     //   100: invokevirtual parseLinkTitle : ()Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*      */     //   103: dup
/*      */     //   104: astore_3
/*      */     //   105: ifnonnull -> 114
/*      */     //   108: aload_0
/*      */     //   109: iload #6
/*      */     //   111: putfield index : I
/*      */     //   114: iconst_1
/*      */     //   115: istore #7
/*      */     //   117: aload_0
/*      */     //   118: getfield index : I
/*      */     //   121: aload_0
/*      */     //   122: getfield input : Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*      */     //   125: invokeinterface length : ()I
/*      */     //   130: if_icmpeq -> 180
/*      */     //   133: aload_0
/*      */     //   134: dup
/*      */     //   135: getfield myParsing : Lcom/vladsch/flexmark/ast/util/Parsing;
/*      */     //   138: getfield LINE_END : Ljava/util/regex/Pattern;
/*      */     //   141: invokevirtual match : (Ljava/util/regex/Pattern;)Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*      */     //   144: ifnonnull -> 180
/*      */     //   147: aload_3
/*      */     //   148: ifnull -> 177
/*      */     //   151: aconst_null
/*      */     //   152: astore_3
/*      */     //   153: aload_0
/*      */     //   154: iload #6
/*      */     //   156: putfield index : I
/*      */     //   159: aload_0
/*      */     //   160: dup
/*      */     //   161: getfield myParsing : Lcom/vladsch/flexmark/ast/util/Parsing;
/*      */     //   164: getfield LINE_END : Ljava/util/regex/Pattern;
/*      */     //   167: invokevirtual match : (Ljava/util/regex/Pattern;)Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*      */     //   170: ifnull -> 177
/*      */     //   173: iconst_1
/*      */     //   174: goto -> 178
/*      */     //   177: iconst_0
/*      */     //   178: istore #7
/*      */     //   180: iload #7
/*      */     //   182: ifne -> 187
/*      */     //   185: iconst_0
/*      */     //   186: ireturn
/*      */     //   187: aload #5
/*      */     //   189: iconst_1
/*      */     //   190: invokestatic normalizeReferenceChars : (Ljava/lang/CharSequence;Z)Ljava/lang/String;
/*      */     //   193: dup
/*      */     //   194: astore #6
/*      */     //   196: invokevirtual isEmpty : ()Z
/*      */     //   199: ifeq -> 204
/*      */     //   202: iconst_0
/*      */     //   203: ireturn
/*      */     //   204: new com/vladsch/flexmark/ast/Reference
/*      */     //   207: dup
/*      */     //   208: aload #5
/*      */     //   210: aload_2
/*      */     //   211: aload_3
/*      */     //   212: invokespecial <init> : (Lcom/vladsch/flexmark/util/sequence/BasedSequence;Lcom/vladsch/flexmark/util/sequence/BasedSequence;Lcom/vladsch/flexmark/util/sequence/BasedSequence;)V
/*      */     //   215: astore_2
/*      */     //   216: aload_0
/*      */     //   217: getfield referenceRepository : Lcom/vladsch/flexmark/ast/util/ReferenceRepository;
/*      */     //   220: aload #6
/*      */     //   222: aload_2
/*      */     //   223: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
/*      */     //   226: pop
/*      */     //   227: aload_1
/*      */     //   228: aload_2
/*      */     //   229: invokevirtual insertBefore : (Lcom/vladsch/flexmark/util/ast/Node;)V
/*      */     //   232: aload_0
/*      */     //   233: getfield index : I
/*      */     //   236: iload #4
/*      */     //   238: isub
/*      */     //   239: ireturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #271	-> 0
/*      */     //   #272	-> 5
/*      */     //   #276	-> 10
/*      */     //   #279	-> 16
/*      */     //   #280	-> 21
/*      */     //   #281	-> 25
/*      */     //   #285	-> 27
/*      */     //   #286	-> 36
/*      */     //   #289	-> 38
/*      */     //   #290	-> 53
/*      */     //   #293	-> 63
/*      */     //   #295	-> 68
/*      */     //   #297	-> 73
/*      */     //   #298	-> 86
/*      */     //   #301	-> 88
/*      */     //   #302	-> 94
/*      */     //   #303	-> 99
/*      */     //   #304	-> 104
/*      */     //   #306	-> 108
/*      */     //   #309	-> 114
/*      */     //   #310	-> 117
/*      */     //   #311	-> 147
/*      */     //   #317	-> 151
/*      */     //   #319	-> 153
/*      */     //   #321	-> 159
/*      */     //   #325	-> 180
/*      */     //   #326	-> 185
/*      */     //   #329	-> 187
/*      */     //   #330	-> 194
/*      */     //   #331	-> 202
/*      */     //   #334	-> 204
/*      */     //   #338	-> 216
/*      */     //   #340	-> 227
/*      */     //   #342	-> 232
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean parseInline() {
/*  353 */     return parseInline(false);
/*      */   }
/*      */   
/*      */   protected boolean parseInline(boolean paramBoolean) {
/*      */     boolean bool;
/*      */     DelimiterProcessor delimiterProcessor;
/*      */     char c;
/*  360 */     if ((c = peek()) == '\000') {
/*  361 */       return false;
/*      */     }
/*      */     List list;
/*  364 */     if (!paramBoolean && this.inlineParserExtensions != null && (
/*      */       
/*  366 */       list = this.inlineParserExtensions.get(Character.valueOf(c))) != null) {
/*  367 */       for (Iterator<InlineParserExtension> iterator = list.iterator(); iterator.hasNext();) {
/*      */         
/*  369 */         if (bool1 = (inlineParserExtension = iterator.next()).parse((LightInlineParser)this)) return true;
/*      */       
/*      */       } 
/*      */     }
/*      */     
/*  374 */     if (this.customCharacters != null && this.customCharacters.get(c)) {
/*      */       boolean bool1;
/*  376 */       if (!(bool1 = processCustomCharacters())) {
/*  377 */         this.index++;
/*      */ 
/*      */         
/*  380 */         appendText(this.input.subSequence(this.index - 1, this.index));
/*      */       } else {
/*      */         
/*  383 */         processDelimiters((Delimiter)null);
/*  384 */         this.lastDelimiter = null;
/*      */       } 
/*      */       
/*  387 */       return true;
/*      */     } 
/*      */     
/*  390 */     switch (c) {
/*      */       case '\n':
/*      */       case '\r':
/*  393 */         bool = parseNewline();
/*      */         break;
/*      */       case '\\':
/*  396 */         bool = parseBackslash();
/*      */         break;
/*      */       case '`':
/*  399 */         bool = parseBackticks();
/*      */         break;
/*      */       case '[':
/*  402 */         bool = parseOpenBracket();
/*      */         break;
/*      */       case '!':
/*  405 */         bool = parseBang();
/*      */         break;
/*      */       case ']':
/*  408 */         bool = parseCloseBracket();
/*      */         break;
/*      */ 
/*      */ 
/*      */       
/*      */       case '<':
/*  414 */         delimiterProcessor = this.delimiterProcessors.get(Character.valueOf(c));
/*      */ 
/*      */         
/*  417 */         bool = ((bool = this.delimiterCharacters.get(c)) && peek(1) == '<') ? parseDelimiters(delimiterProcessor, c) : ((parseAutolink() || parseHtmlInline()));
/*      */         break;
/*      */ 
/*      */       
/*      */       case '&':
/*  422 */         bool = parseEntity();
/*      */         break;
/*      */ 
/*      */       
/*      */       default:
/*  427 */         if (bool = this.delimiterCharacters.get(c)) {
/*  428 */           delimiterProcessor = this.delimiterProcessors.get(Character.valueOf(c));
/*  429 */           bool = parseDelimiters(delimiterProcessor, c); break;
/*      */         } 
/*  431 */         bool = parseString();
/*      */         break;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  437 */     if (!bool) {
/*  438 */       this.index++;
/*      */ 
/*      */       
/*  441 */       appendText(this.input.subSequence(this.index - 1, this.index));
/*      */     } 
/*      */     
/*  444 */     return true;
/*      */   }
/*      */   
/*      */   private boolean processCustomCharacters() {
/*  448 */     char c2 = peek();
/*      */     CharacterNodeFactory characterNodeFactory;
/*  450 */     if ((characterNodeFactory = this.customSpecialCharacterFactoryMap.get(Character.valueOf(c2))) == null) return false;
/*      */     
/*      */     Node node;
/*  453 */     (node = (Node)characterNodeFactory.get()).setChars(this.input.subSequence(this.index, this.index + 1));
/*      */     
/*  455 */     if (this.currentText != null) {
/*  456 */       BasedSequence basedSequence1 = SegmentedSequence.create(node.getChars(), this.currentText);
/*  457 */       this.currentText = null;
/*      */ 
/*      */       
/*  460 */       int j = basedSequence1.length();
/*  461 */       BasedSequence basedSequence2 = null;
/*  462 */       for (; j > 0 && characterNodeFactory.skipPrev(basedSequence1.charAt(j - 1)); j--);
/*  463 */       if (j < basedSequence1.length()) {
/*  464 */         basedSequence2 = (BasedSequence)basedSequence1.subSequence(j);
/*  465 */         basedSequence1 = basedSequence1.subSequence(0, j);
/*      */       } 
/*      */       
/*  468 */       this.block.appendChild((Node)new Text(basedSequence1));
/*  469 */       if (basedSequence2 != null && characterNodeFactory.wantSkippedWhitespace()) {
/*  470 */         this.block.appendChild((Node)new WhiteSpace(basedSequence2));
/*      */       }
/*      */     } 
/*      */     
/*  474 */     appendNode(node);
/*  475 */     if (this.customSpecialCharacterNodes == null) this.customSpecialCharacterNodes = new ArrayList<>(); 
/*  476 */     this.customSpecialCharacterNodes.add(node);
/*      */     
/*  478 */     int i = this.index + 1; char c1;
/*      */     do {
/*  480 */       this.index++;
/*      */     
/*      */     }
/*  483 */     while ((c1 = peek()) != '\000' && characterNodeFactory.skipNext(c1));
/*      */     
/*  485 */     if (i < this.index && characterNodeFactory.wantSkippedWhitespace()) {
/*  486 */       this.block.appendChild((Node)new WhiteSpace(this.input.subSequence(i, this.index)));
/*      */     }
/*      */     
/*  489 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean parseNewline() {
/*  500 */     byte b = (b = (this.index < this.input.length() - 1 && this.input.charAt(this.index + 1) == '\n') ? 1 : 0) ? 1 : 0;
/*  501 */     this.index += b + 1;
/*      */ 
/*      */     
/*  504 */     flushTextNode();
/*      */ 
/*      */     
/*      */     Node node;
/*      */     
/*  509 */     if (node = this.block.getLastChild() instanceof Text && node.getChars().endsWith(" ")) {
/*      */       Text text;
/*  511 */       BasedSequence basedSequence = (text = (Text)node).getChars();
/*      */       Matcher matcher;
/*  513 */       byte b1 = (matcher = this.myParsing.FINAL_SPACE.matcher((CharSequence)basedSequence)).find() ? (matcher.end() - matcher.start()) : 0;
/*  514 */       if (b1 >= 2) {  } else {  }  appendNode((Node)new SoftLineBreak(this.input.subSequence(this.index - 1 - b, this.index)));
/*  515 */       if (b1 > 0) {
/*  516 */         if (basedSequence.length() > b1) {
/*  517 */           node.setChars((BasedSequence)basedSequence.subSequence(0, basedSequence.length() - b1).trimEnd());
/*      */         } else {
/*  519 */           node.unlink();
/*      */         } 
/*      */       }
/*      */     } else {
/*  523 */       appendNode((Node)new SoftLineBreak(this.input.subSequence(this.index - 1 - b, this.index)));
/*      */     } 
/*      */ 
/*      */     
/*  527 */     while (peek() == ' ') {
/*  528 */       this.index++;
/*      */     }
/*  530 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean parseBackslash() {
/*  540 */     this.index++;
/*  541 */     if (peek() == '\n' || peek() == '\r') {
/*  542 */       byte b = (peek(1) == '\n') ? 2 : 1;
/*  543 */       appendNode((Node)new HardLineBreak(this.input.subSequence(this.index - 1, this.index + b)));
/*  544 */       this.index += b;
/*  545 */     } else if (this.index < this.input.length() && this.myParsing.ESCAPABLE.matcher((CharSequence)this.input.subSequence(this.index, this.index + 1)).matches()) {
/*  546 */       appendText(this.input, this.index - 1, this.index + 1);
/*  547 */       this.index++;
/*      */     } else {
/*  549 */       appendText(this.input.subSequence(this.index - 1, this.index));
/*      */     } 
/*  551 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean parseBackticks() {
/*      */     // Byte code:
/*      */     //   0: aload_0
/*      */     //   1: dup
/*      */     //   2: getfield myParsing : Lcom/vladsch/flexmark/ast/util/Parsing;
/*      */     //   5: getfield TICKS_HERE : Ljava/util/regex/Pattern;
/*      */     //   8: invokevirtual match : (Ljava/util/regex/Pattern;)Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*      */     //   11: dup
/*      */     //   12: astore_1
/*      */     //   13: ifnonnull -> 18
/*      */     //   16: iconst_0
/*      */     //   17: ireturn
/*      */     //   18: aload_0
/*      */     //   19: getfield index : I
/*      */     //   22: istore_2
/*      */     //   23: aload_0
/*      */     //   24: dup
/*      */     //   25: getfield myParsing : Lcom/vladsch/flexmark/ast/util/Parsing;
/*      */     //   28: getfield TICKS : Ljava/util/regex/Pattern;
/*      */     //   31: invokevirtual match : (Ljava/util/regex/Pattern;)Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*      */     //   34: dup
/*      */     //   35: astore_3
/*      */     //   36: ifnull -> 301
/*      */     //   39: aload_3
/*      */     //   40: aload_1
/*      */     //   41: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   44: ifeq -> 23
/*      */     //   47: aload_1
/*      */     //   48: invokeinterface length : ()I
/*      */     //   53: istore_1
/*      */     //   54: aload_0
/*      */     //   55: getfield input : Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*      */     //   58: iload_2
/*      */     //   59: aload_0
/*      */     //   60: getfield index : I
/*      */     //   63: iload_1
/*      */     //   64: isub
/*      */     //   65: invokeinterface subSequence : (II)Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*      */     //   70: astore_3
/*      */     //   71: new com/vladsch/flexmark/ast/Code
/*      */     //   74: dup
/*      */     //   75: aload_0
/*      */     //   76: getfield input : Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*      */     //   79: iload_2
/*      */     //   80: iload_1
/*      */     //   81: isub
/*      */     //   82: iload_2
/*      */     //   83: invokeinterface subSequence : (II)Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*      */     //   88: aload_3
/*      */     //   89: aload_0
/*      */     //   90: getfield input : Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*      */     //   93: aload_0
/*      */     //   94: getfield index : I
/*      */     //   97: iload_1
/*      */     //   98: isub
/*      */     //   99: aload_0
/*      */     //   100: getfield index : I
/*      */     //   103: invokeinterface subSequence : (II)Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*      */     //   108: invokespecial <init> : (Lcom/vladsch/flexmark/util/sequence/BasedSequence;Lcom/vladsch/flexmark/util/sequence/BasedSequence;Lcom/vladsch/flexmark/util/sequence/BasedSequence;)V
/*      */     //   111: astore_1
/*      */     //   112: aload_0
/*      */     //   113: getfield options : Lcom/vladsch/flexmark/parser/InlineParserOptions;
/*      */     //   116: getfield codeSoftLineBreaks : Z
/*      */     //   119: ifeq -> 280
/*      */     //   122: aload_3
/*      */     //   123: invokeinterface length : ()I
/*      */     //   128: istore_2
/*      */     //   129: iconst_0
/*      */     //   130: istore #4
/*      */     //   132: iload #4
/*      */     //   134: iload_2
/*      */     //   135: if_icmpge -> 277
/*      */     //   138: aload_3
/*      */     //   139: getstatic com/vladsch/flexmark/util/misc/CharPredicate.ANY_EOL : Lcom/vladsch/flexmark/util/misc/CharPredicate;
/*      */     //   142: iload #4
/*      */     //   144: invokeinterface indexOfAny : (Lcom/vladsch/flexmark/util/misc/CharPredicate;I)I
/*      */     //   149: dup
/*      */     //   150: istore #5
/*      */     //   152: iconst_m1
/*      */     //   153: if_icmpne -> 160
/*      */     //   156: iload_2
/*      */     //   157: goto -> 162
/*      */     //   160: iload #5
/*      */     //   162: istore #6
/*      */     //   164: new com/vladsch/flexmark/ast/Text
/*      */     //   167: dup
/*      */     //   168: aload_3
/*      */     //   169: iload #4
/*      */     //   171: iload #6
/*      */     //   173: invokeinterface subSequence : (II)Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*      */     //   178: invokespecial <init> : (Lcom/vladsch/flexmark/util/sequence/BasedSequence;)V
/*      */     //   181: astore #4
/*      */     //   183: aload_1
/*      */     //   184: aload #4
/*      */     //   186: invokevirtual appendChild : (Lcom/vladsch/flexmark/util/ast/Node;)V
/*      */     //   189: iload #6
/*      */     //   191: dup
/*      */     //   192: istore #4
/*      */     //   194: iload_2
/*      */     //   195: if_icmpge -> 277
/*      */     //   198: aload_3
/*      */     //   199: iload #4
/*      */     //   201: invokeinterface charAt : (I)C
/*      */     //   206: bipush #13
/*      */     //   208: if_icmpne -> 233
/*      */     //   211: iinc #4, 1
/*      */     //   214: iload #4
/*      */     //   216: iload_2
/*      */     //   217: if_icmpge -> 277
/*      */     //   220: aload_3
/*      */     //   221: iload #4
/*      */     //   223: invokeinterface charAt : (I)C
/*      */     //   228: bipush #10
/*      */     //   230: if_icmpne -> 236
/*      */     //   233: iinc #4, 1
/*      */     //   236: iload #4
/*      */     //   238: iload_2
/*      */     //   239: if_icmpge -> 277
/*      */     //   242: iload #6
/*      */     //   244: iload #4
/*      */     //   246: if_icmpge -> 274
/*      */     //   249: new com/vladsch/flexmark/ast/SoftLineBreak
/*      */     //   252: dup
/*      */     //   253: aload_3
/*      */     //   254: iload #5
/*      */     //   256: iload #4
/*      */     //   258: invokeinterface subSequence : (II)Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*      */     //   263: invokespecial <init> : (Lcom/vladsch/flexmark/util/sequence/BasedSequence;)V
/*      */     //   266: astore #5
/*      */     //   268: aload_1
/*      */     //   269: aload #5
/*      */     //   271: invokevirtual appendChild : (Lcom/vladsch/flexmark/util/ast/Node;)V
/*      */     //   274: goto -> 132
/*      */     //   277: goto -> 294
/*      */     //   280: new com/vladsch/flexmark/ast/Text
/*      */     //   283: dup
/*      */     //   284: aload_3
/*      */     //   285: invokespecial <init> : (Lcom/vladsch/flexmark/util/sequence/BasedSequence;)V
/*      */     //   288: astore_2
/*      */     //   289: aload_1
/*      */     //   290: aload_2
/*      */     //   291: invokevirtual appendChild : (Lcom/vladsch/flexmark/util/ast/Node;)V
/*      */     //   294: aload_0
/*      */     //   295: aload_1
/*      */     //   296: invokevirtual appendNode : (Lcom/vladsch/flexmark/util/ast/Node;)V
/*      */     //   299: iconst_1
/*      */     //   300: ireturn
/*      */     //   301: aload_0
/*      */     //   302: iload_2
/*      */     //   303: putfield index : I
/*      */     //   306: aload_0
/*      */     //   307: aload_1
/*      */     //   308: invokevirtual appendText : (Lcom/vladsch/flexmark/util/sequence/BasedSequence;)V
/*      */     //   311: iconst_1
/*      */     //   312: ireturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #560	-> 0
/*      */     //   #561	-> 12
/*      */     //   #562	-> 16
/*      */     //   #564	-> 18
/*      */     //   #566	-> 23
/*      */     //   #567	-> 39
/*      */     //   #568	-> 47
/*      */     //   #569	-> 54
/*      */     //   #570	-> 71
/*      */     //   #572	-> 112
/*      */     //   #574	-> 122
/*      */     //   #575	-> 129
/*      */     //   #576	-> 132
/*      */     //   #577	-> 138
/*      */     //   #578	-> 150
/*      */     //   #580	-> 164
/*      */     //   #581	-> 183
/*      */     //   #583	-> 189
/*      */     //   #584	-> 192
/*      */     //   #585	-> 198
/*      */     //   #586	-> 211
/*      */     //   #587	-> 214
/*      */     //   #588	-> 220
/*      */     //   #590	-> 233
/*      */     //   #593	-> 236
/*      */     //   #595	-> 242
/*      */     //   #596	-> 249
/*      */     //   #597	-> 268
/*      */     //   #599	-> 274
/*      */     //   #600	-> 277
/*      */     //   #601	-> 280
/*      */     //   #602	-> 289
/*      */     //   #605	-> 294
/*      */     //   #606	-> 299
/*      */     //   #611	-> 301
/*      */     //   #612	-> 306
/*      */     //   #613	-> 311
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class DelimiterData
/*      */   {
/*      */     final int count;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     final boolean canClose;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     final boolean canOpen;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     DelimiterData(int param1Int, boolean param1Boolean1, boolean param1Boolean2) {
/*  622 */       this.count = param1Int;
/*  623 */       this.canOpen = param1Boolean1;
/*  624 */       this.canClose = param1Boolean2;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean parseDelimiters(DelimiterProcessor paramDelimiterProcessor, char paramChar) {
/*      */     DelimiterData delimiterData;
/*  637 */     if ((delimiterData = scanDelimiters(paramDelimiterProcessor, paramChar)) == null) {
/*  638 */       return false;
/*      */     }
/*  640 */     int i = delimiterData.count;
/*  641 */     int j = this.index;
/*      */     
/*  643 */     this.index += i;
/*  644 */     Text text = appendSeparateText(this.input.subSequence(j, this.index));
/*      */ 
/*      */     
/*  647 */     this.lastDelimiter = new Delimiter(this.input, text, paramChar, delimiterData.canOpen, delimiterData.canClose, this.lastDelimiter, j);
/*  648 */     this.lastDelimiter.setNumDelims(i);
/*  649 */     if (this.lastDelimiter.getPrevious() != null) {
/*  650 */       this.lastDelimiter.getPrevious().setNext(this.lastDelimiter);
/*      */     }
/*  652 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean parseOpenBracket() {
/*  661 */     int i = this.index;
/*  662 */     this.index++;
/*      */     
/*  664 */     Text text = appendSeparateText(this.input.subSequence(this.index - 1, this.index));
/*      */ 
/*      */     
/*  667 */     addBracket(Bracket.link(this.input, text, i, this.lastBracket, this.lastDelimiter));
/*  668 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean parseBang() {
/*  678 */     int i = this.index;
/*  679 */     this.index++;
/*  680 */     if (peek() == '[') {
/*  681 */       this.index++;
/*      */       
/*  683 */       Text text = appendSeparateText(this.input.subSequence(this.index - 2, this.index));
/*      */ 
/*      */       
/*  686 */       addBracket(Bracket.image(this.input, text, i + 1, this.lastBracket, this.lastDelimiter));
/*      */     } else {
/*  688 */       appendText(this.input.subSequence(this.index - 1, this.index));
/*      */     } 
/*  690 */     return true;
/*      */   }
/*      */   
/*      */   private void addBracket(Bracket paramBracket) {
/*  694 */     if (this.lastBracket != null) {
/*  695 */       this.lastBracket.setBracketAfter(true);
/*      */     }
/*  697 */     this.lastBracket = paramBracket;
/*      */   }
/*      */   
/*      */   private void removeLastBracket() {
/*  701 */     this.lastBracket = this.lastBracket.getPrevious();
/*      */   }
/*      */   
/*      */   static class ReferenceProcessorMatch {
/*      */     public final LinkRefProcessor processor;
/*      */     public final BasedSequence nodeChars;
/*      */     public final boolean wantExclamation;
/*      */     
/*      */     public ReferenceProcessorMatch(LinkRefProcessor param1LinkRefProcessor, boolean param1Boolean, BasedSequence param1BasedSequence) {
/*  710 */       this.processor = param1LinkRefProcessor;
/*  711 */       this.nodeChars = param1BasedSequence;
/*  712 */       this.wantExclamation = param1Boolean;
/*      */     }
/*      */   }
/*      */   
/*      */   private ReferenceProcessorMatch matchLinkRef(Bracket paramBracket, int paramInt1, int paramInt2, int paramInt3) {
/*  717 */     if (this.linkRefProcessorsData.nestingIndex.length == 0) return null;
/*      */     
/*  719 */     ReferenceProcessorMatch referenceProcessorMatch = null;
/*  720 */     BasedSequence basedSequence1 = null;
/*  721 */     BasedSequence basedSequence2 = null;
/*      */ 
/*      */     
/*  724 */     int j = this.linkRefProcessorsData.processors.size();
/*      */     
/*  726 */     for (int i = this.linkRefProcessorsData.nestingIndex[paramInt2 + paramInt3], k = i; k < j; ) {
/*  727 */       LinkRefProcessor linkRefProcessor = this.linkRefProcessors.get(k);
/*      */ 
/*      */       
/*  730 */       if (paramInt2 + paramInt3 >= linkRefProcessor.getBracketNestingLevel()) {
/*      */         BasedSequence basedSequence;
/*  732 */         boolean bool = linkRefProcessor.getWantExclamationPrefix();
/*      */ 
/*      */         
/*  735 */         if (paramBracket.isImage() && bool) {
/*      */           
/*  737 */           if (basedSequence2 == null) basedSequence2 = this.input.subSequence(paramBracket.getStartIndex() - 1 - paramInt2, paramInt1 + paramInt2); 
/*  738 */           basedSequence = basedSequence2;
/*      */         }
/*  740 */         else if (bool && paramBracket.getStartIndex() >= paramInt2 + 1 && this.input.charAt(paramBracket.getStartIndex() - 1 - paramInt2) == '!') {
/*  741 */           if (basedSequence2 == null) basedSequence2 = this.input.subSequence(paramBracket.getStartIndex() - 1 - paramInt2, paramInt1 + paramInt2); 
/*  742 */           basedSequence = basedSequence2;
/*      */         } else {
/*  744 */           if (basedSequence1 == null) basedSequence1 = this.input.subSequence(paramBracket.getStartIndex() - paramInt2, paramInt1 + paramInt2); 
/*  745 */           basedSequence = basedSequence1;
/*      */         } 
/*      */ 
/*      */         
/*  749 */         if (linkRefProcessor.isMatch(basedSequence)) {
/*  750 */           referenceProcessorMatch = new ReferenceProcessorMatch(linkRefProcessor, bool, basedSequence); break;
/*      */         }  k++;
/*      */       } 
/*      */     } 
/*  754 */     return referenceProcessorMatch;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean parseCloseBracket() {
/*  767 */     int i = ++this.index;
/*      */ 
/*      */     
/*      */     Bracket bracket;
/*      */     
/*  772 */     if ((bracket = this.lastBracket) == null) {
/*      */       
/*  774 */       appendText(this.input.subSequence(this.index - 1, this.index));
/*  775 */       return true;
/*      */     } 
/*      */     
/*  778 */     if (!bracket.isAllowed()) {
/*      */       
/*  780 */       appendText(this.input.subSequence(this.index - 1, this.index));
/*  781 */       removeLastBracket();
/*  782 */       return true;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  788 */     BasedSequence basedSequence1 = null;
/*  789 */     BasedSequence basedSequence2 = null;
/*  790 */     BasedSequence basedSequence3 = null;
/*  791 */     boolean bool1 = false;
/*  792 */     boolean bool2 = false;
/*  793 */     ReferenceProcessorMatch referenceProcessorMatch = null;
/*  794 */     boolean bool3 = false;
/*  795 */     BasedSequence basedSequence4 = BasedSequence.NULL;
/*  796 */     BasedSequence basedSequence5 = BasedSequence.NULL;
/*  797 */     BasedSequence basedSequence6 = BasedSequence.NULL;
/*  798 */     BasedSequence basedSequence7 = null;
/*      */ 
/*      */     
/*  801 */     int j = this.index;
/*      */ 
/*      */     
/*  804 */     if (this.options.spaceInLinkElements && peek() == ' ') {
/*  805 */       sp();
/*      */     }
/*      */     
/*  808 */     if (peek() == '(') {
/*  809 */       j = this.index;
/*      */       
/*  811 */       basedSequence4 = this.input.subSequence(this.index, this.index + 1);
/*  812 */       this.index++;
/*  813 */       spnl();
/*  814 */       if ((basedSequence1 = parseLinkDestination()) != null) {
/*  815 */         if (this.options.parseMultiLineImageUrls && bracket.isImage() && !basedSequence1.startsWith("<") && basedSequence1.endsWith("?") && spnlUrl())
/*      */         
/*      */         { 
/*  818 */           int k = this.index, m = k;
/*      */ 
/*      */           
/*      */           while (true) {
/*  822 */             sp();
/*      */             BasedSequence basedSequence8;
/*  824 */             if ((basedSequence8 = parseLinkTitle()) != null) sp();
/*      */             
/*  826 */             if (peek() == ')') {
/*  827 */               basedSequence5 = this.input.subSequence(this.index, this.index + 1);
/*  828 */               this.index++;
/*  829 */               basedSequence7 = this.input.subSequence(k, m);
/*  830 */               basedSequence2 = basedSequence8;
/*  831 */               bool1 = true;
/*      */               
/*      */               break;
/*      */             } 
/*      */             BasedSequence basedSequence9;
/*  836 */             if ((basedSequence9 = toEOL()) != null) {
/*  837 */               m = this.index; continue;
/*      */             }  break;
/*      */           }  }
/*  840 */         else { spnl();
/*      */           
/*  842 */           if (this.myParsing.WHITESPACE.matcher((CharSequence)this.input.subSequence(this.index - 1, this.index)).matches()) {
/*  843 */             basedSequence2 = parseLinkTitle();
/*  844 */             spnl();
/*      */           } 
/*      */ 
/*      */           
/*  848 */           if (peek() == ')') {
/*  849 */             basedSequence5 = this.input.subSequence(this.index, this.index + 1);
/*  850 */             this.index++;
/*  851 */             bool1 = true;
/*      */           } else {
/*      */             
/*  854 */             this.index = j;
/*      */           }  }
/*      */       
/*      */       } else {
/*  858 */         this.index = j;
/*      */       } 
/*      */     } else {
/*  861 */       this.index = j;
/*      */     } 
/*      */     
/*  864 */     if (!bool1) {
/*      */ 
/*      */       
/*  867 */       if (!this.options.matchLookaheadFirst) {
/*  868 */         referenceProcessorMatch = matchLinkRef(bracket, i, 0, 0);
/*      */       }
/*      */       
/*  871 */       if (referenceProcessorMatch == null) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  876 */         j = this.linkRefProcessorsData.maxNesting;
/*  877 */         byte b = 0;
/*      */         
/*  879 */         if (j > 0) {
/*      */           
/*  881 */           Bracket bracket1 = bracket;
/*  882 */           while (bracket1.getPrevious() != null && bracket1.getStartIndex() == bracket1.getPrevious().getStartIndex() + 1 && peek(b) == ']') {
/*  883 */             bracket1 = bracket1.getPrevious();
/*  884 */             b++;
/*  885 */             if (b == j || bracket1.isImage())
/*      */               break; 
/*      */           } 
/*      */         } 
/*  889 */         for (int k = b + 1; k-- > 0;) {
/*      */ 
/*      */           
/*  892 */           if ((referenceProcessorMatch = matchLinkRef(bracket, i, k, 0)) != null) {
/*  893 */             if (k > 0) {
/*  894 */               while (k-- > 0) {
/*  895 */                 this.index++;
/*  896 */                 this.lastBracket.getNode().unlink();
/*  897 */                 removeLastBracket();
/*      */               } 
/*  899 */               bracket = this.lastBracket;
/*      */             } 
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       } 
/*  906 */       if (referenceProcessorMatch == null) {
/*      */         
/*  908 */         j = this.index;
/*      */         int k;
/*  910 */         if ((k = parseLinkLabel()) > 2) {
/*  911 */           basedSequence3 = this.input.subSequence(j, j + k);
/*  912 */         } else if (!bracket.isBracketAfter()) {
/*      */           
/*  914 */           basedSequence6 = this.input.subSequence(j, j + k);
/*  915 */           if (bracket.isImage()) {
/*      */             
/*  917 */             basedSequence3 = this.input.subSequence(bracket.getStartIndex() - 1, i);
/*      */           } else {
/*  919 */             basedSequence3 = this.input.subSequence(bracket.getStartIndex(), i);
/*      */           } 
/*  921 */           bool2 = true;
/*      */         } 
/*      */         
/*  924 */         if (basedSequence3 != null) {
/*  925 */           String str = Escaping.normalizeReferenceChars((CharSequence)basedSequence3, true);
/*  926 */           if (this.referenceRepository.containsKey(str)) {
/*  927 */             BasedSequence basedSequence = this.input.subSequence(bracket.getStartIndex(), i);
/*      */             boolean bool;
/*  929 */             bool1 = !(bool = containsLinkRefs(bool2 ? basedSequence3 : basedSequence, bracket.getNode().getNext(), Boolean.FALSE)) ? true : false;
/*  930 */             bool3 = true;
/*      */           
/*      */           }
/*  933 */           else if (!bracket.isStraddling(basedSequence3)) {
/*      */ 
/*      */ 
/*      */             
/*  937 */             if (!bool2 && peek() == '[') {
/*      */               int m;
/*  939 */               if ((m = parseLinkLabel()) > 0) {
/*      */                 
/*  941 */                 this.index = j;
/*      */               } else {
/*      */                 boolean bool;
/*      */                 
/*  945 */                 if (!(bool = containsLinkRefs(basedSequence3, bracket.getNode().getNext(), (Boolean)null))) {
/*  946 */                   bool2 = true;
/*  947 */                   bool1 = true;
/*      */                 } 
/*      */               } 
/*      */             } else {
/*      */               boolean bool;
/*      */               
/*  953 */               if (!(bool = containsLinkRefs(basedSequence3, bracket.getNode().getNext(), (Boolean)null))) {
/*  954 */                 bool1 = true;
/*      */               }
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  963 */     if (bool1 || referenceProcessorMatch != null) {
/*      */ 
/*      */ 
/*      */       
/*  967 */       flushTextNode();
/*      */ 
/*      */       
/*  970 */       boolean bool = bracket.isImage();
/*      */ 
/*      */       
/*  973 */       if (!referenceProcessorMatch.wantExclamation && bool) {
/*  974 */         appendText(this.input.subSequence(bracket.getStartIndex() - 1, bracket.getStartIndex()));
/*  975 */         bracket.getNode().setChars((BasedSequence)bracket.getNode().getChars().subSequence(1));
/*      */         
/*  977 */         bool = false;
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*  982 */       j = (referenceProcessorMatch != null) ? referenceProcessorMatch.processor.createNode(referenceProcessorMatch.nodeChars) : ((basedSequence3 != null) ? (bool ? new ImageRef() : new LinkRef()) : (bool ? new Image() : new Link()));
/*      */ 
/*      */ 
/*      */       
/*  986 */       Node node = bracket.getNode().getNext();
/*  987 */       while (node != null) {
/*  988 */         Node node1 = node.getNext();
/*  989 */         j.appendChild(node);
/*  990 */         node = node1;
/*      */       } 
/*      */ 
/*      */       
/*  994 */       if (referenceProcessorMatch != null)
/*      */       {
/*  996 */         if (j.hasChildren()) {
/*  997 */           BasedSequence basedSequence8 = j.getChildChars();
/*  998 */           BasedSequence basedSequence9 = referenceProcessorMatch.processor.adjustInlineText(this.document, j);
/*      */ 
/*      */           
/* 1001 */           Delimiter delimiter = this.lastDelimiter;
/* 1002 */           while (delimiter != null) {
/* 1003 */             Delimiter delimiter1 = delimiter.getPrevious();
/*      */             
/* 1005 */             BasedSequence basedSequence = delimiter.getInput().subSequence(delimiter.getStartIndex(), delimiter.getEndIndex());
/* 1006 */             if (basedSequence8.containsAllOf(basedSequence) && (
/* 1007 */               !basedSequence9.containsAllOf(basedSequence) || !referenceProcessorMatch.processor.allowDelimiters(basedSequence, this.document, j)))
/*      */             {
/* 1009 */               removeDelimiterKeepNode(delimiter);
/*      */             }
/*      */ 
/*      */             
/* 1013 */             delimiter = delimiter1;
/*      */           } 
/*      */           
/* 1016 */           if (!basedSequence9.containsAllOf(basedSequence8))
/*      */           {
/* 1018 */             for (ReversiblePeekingIterator<Node> reversiblePeekingIterator = j.getChildren().iterator(); reversiblePeekingIterator.hasNext(); ) {
/* 1019 */               Node node1; basedSequence8 = (node1 = reversiblePeekingIterator.next()).getChars();
/* 1020 */               if (basedSequence9.containsSomeOf(basedSequence8)) {
/* 1021 */                 if (!basedSequence9.containsAllOf(basedSequence8)) {
/*      */                   
/* 1023 */                   basedSequence8 = basedSequence9.intersect(basedSequence8);
/* 1024 */                   node1.setChars(basedSequence8);
/*      */                 } 
/*      */                 continue;
/*      */               } 
/* 1028 */               node1.unlink();
/*      */             } 
/*      */           }
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/* 1035 */       appendNode(j);
/*      */       
/* 1037 */       if (j instanceof RefNode) {
/*      */         RefNode refNode;
/*      */         
/* 1040 */         (refNode = (RefNode)j).setReferenceChars(basedSequence3);
/* 1041 */         if (bool3) refNode.setDefined(true);
/*      */         
/* 1043 */         if (!bool2) {
/* 1044 */           refNode.setTextChars(this.input.subSequence(bool ? (bracket.getStartIndex() - 1) : bracket.getStartIndex(), i));
/* 1045 */         } else if (!basedSequence6.isEmpty()) {
/* 1046 */           refNode.setTextOpeningMarker(basedSequence6.subSequence(0, 1));
/* 1047 */           refNode.setTextClosingMarker((BasedSequence)basedSequence6.endSequence(1));
/*      */         } 
/* 1049 */         j.setCharsFromContent();
/* 1050 */       } else if (j instanceof InlineLinkNode) {
/*      */         InlineLinkNode inlineLinkNode;
/*      */         
/* 1053 */         (inlineLinkNode = (InlineLinkNode)j).setUrlChars(basedSequence1);
/* 1054 */         inlineLinkNode.setTitleChars(basedSequence2);
/* 1055 */         inlineLinkNode.setLinkOpeningMarker(basedSequence4);
/* 1056 */         inlineLinkNode.setLinkClosingMarker(basedSequence5);
/* 1057 */         inlineLinkNode.setTextChars(bool ? this.input.subSequence(bracket.getStartIndex() - 1, i) : this.input.subSequence(bracket.getStartIndex(), i));
/*      */         
/* 1059 */         if (basedSequence7 != null) {
/* 1060 */           ((Image)j).setUrlContent(basedSequence7);
/*      */         }
/*      */         
/* 1063 */         j.setCharsFromContent();
/*      */       } 
/*      */ 
/*      */       
/* 1067 */       processDelimiters(bracket.getPreviousDelimiter());
/* 1068 */       Text text = bracket.getNode();
/* 1069 */       removeLastBracket();
/*      */       
/* 1071 */       if (referenceProcessorMatch != null) {
/* 1072 */         referenceProcessorMatch.processor.updateNodeElements(this.document, j);
/*      */       }
/*      */ 
/*      */       
/* 1076 */       if (j instanceof Link)
/* 1077 */       { Bracket bracket1 = this.lastBracket;
/* 1078 */         while (bracket1 != null) {
/* 1079 */           if (!bracket1.isImage())
/*      */           {
/* 1081 */             bracket1.setAllowed(false);
/*      */           }
/* 1083 */           bracket1 = bracket1.getPrevious();
/*      */         } 
/*      */         
/* 1086 */         if (this.options.linkTextPriorityOverLinkRef || !containsLinkRefs(j, Boolean.FALSE)) {
/*      */           
/* 1088 */           collapseLinkRefChildren(j, paramLinkRefDerived -> Boolean.valueOf((paramLinkRefDerived instanceof LinkRendered || paramLinkRefDerived.isTentative())), true);
/* 1089 */           text.unlink();
/*      */         }
/*      */         else {
/*      */           
/* 1093 */           j.unlink();
/* 1094 */           this.block.takeChildren(j);
/* 1095 */           appendText(j.baseSubSequence(((Link)j).getTextClosingMarker().getStartOffset(), j.getEndOffset()));
/*      */         }  }
/* 1097 */       else { if (j instanceof RefNode)
/*      */         {
/* 1099 */           collapseLinkRefChildren(j, paramLinkRefDerived -> Boolean.valueOf((paramLinkRefDerived instanceof LinkRendered || paramLinkRefDerived.isTentative())), true);
/*      */         }
/*      */         
/* 1102 */         text.unlink(); }
/*      */ 
/*      */       
/* 1105 */       return true;
/*      */     } 
/* 1107 */     this.index = i;
/* 1108 */     appendText(this.input.subSequence(this.index - 1, this.index));
/* 1109 */     removeLastBracket();
/* 1110 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   protected static boolean containsLinkRefs(Node paramNode, Boolean paramBoolean) {
/* 1115 */     paramNode = paramNode.getFirstChild();
/* 1116 */     while (paramNode != null) {
/* 1117 */       if (paramNode instanceof LinkRendered && (paramBoolean == null || ((LinkRendered)paramNode).isTentative() == paramBoolean.booleanValue())) {
/* 1118 */         return true;
/*      */       }
/* 1120 */       paramNode = paramNode.getNext();
/*      */     } 
/* 1122 */     return false;
/*      */   }
/*      */   
/*      */   protected static boolean containsLinkRefs(BasedSequence paramBasedSequence, Node paramNode, Boolean paramBoolean) {
/* 1126 */     int j = paramBasedSequence.getStartOffset();
/* 1127 */     int i = paramBasedSequence.getEndOffset();
/* 1128 */     while (paramNode != null) {
/* 1129 */       if (paramNode instanceof LinkRefDerived && (paramBoolean == null || ((LinkRefDerived)paramNode).isTentative() == paramBoolean.booleanValue()) && paramNode.getStartOffset() < i && paramNode.getEndOffset() > j) {
/* 1130 */         return true;
/*      */       }
/* 1132 */       paramNode = paramNode.getNext();
/*      */     } 
/* 1134 */     return false;
/*      */   }
/*      */   
/*      */   protected static void collapseLinkRefChildren(Node paramNode, Function<LinkRefDerived, Boolean> paramFunction, boolean paramBoolean) {
/* 1138 */     Node node = paramNode.getFirstChild();
/* 1139 */     boolean bool = false;
/* 1140 */     while (node != null) {
/* 1141 */       Node node1 = node.getNext();
/* 1142 */       if (node instanceof LinkRefDerived && (paramFunction == null || ((Boolean)paramFunction.apply((LinkRefDerived)node)).booleanValue())) {
/*      */         
/* 1144 */         collapseLinkRefChildren(node, paramFunction, false);
/* 1145 */         node.unlink();
/*      */         
/*      */         TextNodeConverter textNodeConverter;
/* 1148 */         (textNodeConverter = new TextNodeConverter(node.getChars())).addChildrenOf(node);
/* 1149 */         if (node1 != null) {
/* 1150 */           textNodeConverter.insertMergedBefore(node1);
/*      */         } else {
/* 1152 */           textNodeConverter.appendMergedTo(paramNode);
/*      */         } 
/* 1154 */         bool = true;
/*      */       } 
/* 1156 */       node = node1;
/*      */     } 
/*      */     
/* 1159 */     if (bool) {
/* 1160 */       TextNodeConverter.mergeTextNodes(paramNode);
/*      */     }
/*      */     
/* 1163 */     if (paramBoolean) {
/*      */       
/* 1165 */       Node node2 = paramNode.getFirstChild();
/* 1166 */       Node node1 = paramNode.getLastChild();
/*      */       
/* 1168 */       if (node2 == node1)
/* 1169 */       { if (node2 != null && !(node2 instanceof com.vladsch.flexmark.util.ast.DoNotTrim)) { node2.setChars((BasedSequence)node2.getChars().trim()); return; }
/*      */          }
/* 1171 */       else { if (node2 != null && !(node2 instanceof com.vladsch.flexmark.util.ast.DoNotTrim)) node2.setChars((BasedSequence)node2.getChars().trimStart()); 
/* 1172 */         if (node1 != null && !(node1 instanceof com.vladsch.flexmark.util.ast.DoNotTrim)) node1.setChars((BasedSequence)node1.getChars().trimEnd());
/*      */          }
/*      */     
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BasedSequence parseLinkDestination() {
/*      */     BasedSequence basedSequence1;
/* 1185 */     if ((basedSequence1 = match(this.myParsing.LINK_DESTINATION_ANGLES)) != null) {
/* 1186 */       return basedSequence1;
/*      */     }
/* 1188 */     if (this.linkDestinationParser != null) {
/* 1189 */       basedSequence1 = this.linkDestinationParser.parseLinkDestination(this.input, this.index);
/* 1190 */       this.index += basedSequence1.length();
/* 1191 */       return basedSequence1;
/*      */     } 
/* 1193 */     boolean bool = this.options.spaceInLinkUrls;
/* 1194 */     if (this.options.linksAllowMatchedParentheses) {
/*      */       BasedSequence basedSequence;
/*      */ 
/*      */       
/* 1198 */       if ((basedSequence = match(this.myParsing.LINK_DESTINATION_MATCHED_PARENS)) != null) {
/* 1199 */         byte b1 = 0;
/* 1200 */         int i = basedSequence.length();
/* 1201 */         for (byte b2 = 0; b2 < i; b2++) {
/*      */           char c;
/* 1203 */           if ((c = basedSequence.charAt(b2)) == '\\') {
/* 1204 */             if (b2 + 1 < i && this.myParsing.ESCAPABLE.matcher((CharSequence)basedSequence.subSequence(b2 + 1, b2 + 2)).matches())
/*      */             {
/* 1206 */               b2++;
/*      */             }
/* 1208 */           } else if (c == '(') {
/* 1209 */             b1++;
/* 1210 */           } else if (c == ')') {
/* 1211 */             if (b1 == 0) {
/*      */               
/* 1213 */               this.index -= i - b2;
/* 1214 */               basedSequence = basedSequence.subSequence(0, b2);
/*      */               break;
/*      */             } 
/* 1217 */             b1--;
/*      */           } 
/*      */         } 
/*      */         
/* 1221 */         return bool ? (BasedSequence)basedSequence.trimEnd(CharPredicate.SPACE) : basedSequence;
/*      */       } 
/*      */       
/* 1224 */       return null;
/*      */     } 
/*      */     
/*      */     BasedSequence basedSequence2;
/* 1228 */     if ((basedSequence2 = match(this.myParsing.LINK_DESTINATION)) != null && bool) return (BasedSequence)basedSequence2.trimEnd(CharPredicate.SPACE);  return basedSequence2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BasedSequence parseLinkTitle() {
/*      */     BasedSequence basedSequence;
/* 1243 */     return basedSequence = match(this.myParsing.LINK_TITLE);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int parseLinkLabel() {
/*      */     BasedSequence basedSequence;
/* 1254 */     return ((basedSequence = match(this.myParsing.LINK_LABEL)) == null) ? 0 : basedSequence.length();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean parseAutolink() {
/*      */     BasedSequence basedSequence;
/* 1265 */     if ((basedSequence = match(this.myParsing.EMAIL_AUTOLINK)) != null) {
/* 1266 */       MailLink mailLink = new MailLink(basedSequence.subSequence(0, 1), basedSequence.subSequence(1, basedSequence.length() - 1), basedSequence.subSequence(basedSequence.length() - 1, basedSequence.length()));
/* 1267 */       appendNode((Node)mailLink);
/* 1268 */       return true;
/* 1269 */     }  if ((basedSequence = match(this.myParsing.AUTOLINK)) != null) {
/* 1270 */       AutoLink autoLink = new AutoLink(basedSequence.subSequence(0, 1), basedSequence.subSequence(1, basedSequence.length() - 1), basedSequence.subSequence(basedSequence.length() - 1, basedSequence.length()));
/* 1271 */       appendNode((Node)autoLink);
/* 1272 */       return true;
/* 1273 */     }  if (this.options.wwwAutoLinkElement && (basedSequence = match(this.myParsing.WWW_AUTOLINK)) != null) {
/* 1274 */       AutoLink autoLink = new AutoLink(basedSequence.subSequence(0, 1), basedSequence.subSequence(1, basedSequence.length() - 1), basedSequence.subSequence(basedSequence.length() - 1, basedSequence.length()));
/* 1275 */       appendNode((Node)autoLink);
/* 1276 */       return true;
/*      */     } 
/* 1278 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean parseHtmlInline() {
/*      */     BasedSequence basedSequence;
/* 1290 */     if ((basedSequence = match(this.myParsing.HTML_TAG)) != null) {
/*      */       HtmlInlineComment htmlInlineComment;
/*      */       HtmlInline htmlInline;
/* 1293 */       if (basedSequence.startsWith("<!--") && basedSequence.endsWith("-->")) {
/* 1294 */         htmlInlineComment = new HtmlInlineComment(basedSequence);
/*      */       } else {
/* 1296 */         htmlInline = new HtmlInline((BasedSequence)htmlInlineComment);
/*      */       } 
/* 1298 */       appendNode((Node)htmlInline);
/* 1299 */       return true;
/*      */     } 
/* 1301 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean parseEntity() {
/*      */     BasedSequence basedSequence;
/* 1313 */     if ((basedSequence = match(this.myParsing.ENTITY_HERE)) != null) {
/* 1314 */       HtmlEntity htmlEntity = new HtmlEntity(basedSequence);
/* 1315 */       appendNode((Node)htmlEntity);
/* 1316 */       return true;
/*      */     } 
/* 1318 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean parseString() {
/* 1328 */     int i = this.index;
/* 1329 */     int j = this.input.length();
/* 1330 */     while (this.index != j && 
/* 1331 */       !this.specialCharacters.get(this.input.charAt(this.index)))
/*      */     {
/*      */       
/* 1334 */       this.index++;
/*      */     }
/* 1336 */     if (i != this.index) {
/* 1337 */       appendText(this.input, i, this.index);
/* 1338 */       return true;
/*      */     } 
/* 1340 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected Object clone() {
/* 1346 */     return super.clone();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected DelimiterData scanDelimiters(DelimiterProcessor paramDelimiterProcessor, char paramChar) {
/*      */     boolean bool1, bool2;
/*      */     boolean bool3, bool4;
/* 1358 */     int i = this.index;
/*      */     
/* 1360 */     byte b = 0;
/* 1361 */     while (peek() == paramChar) {
/* 1362 */       b++;
/* 1363 */       this.index++;
/*      */     } 
/*      */     
/* 1366 */     if (b < paramDelimiterProcessor.getMinLength()) {
/* 1367 */       this.index = i;
/* 1368 */       return null;
/*      */     } 
/*      */     
/* 1371 */     String str1 = (i == 0) ? "\n" : String.valueOf(this.input.charAt(i - 1));
/*      */     
/*      */     char c;
/* 1374 */     String str2 = ((c = peek()) == '\000') ? "\n" : String.valueOf(c);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1381 */     boolean bool5 = this.myParsing.UNICODE_WHITESPACE_CHAR.matcher(str1).matches();
/* 1382 */     boolean bool6 = this.myParsing.UNICODE_WHITESPACE_CHAR.matcher(str2).matches();
/*      */     
/* 1384 */     if (this.options.inlineDelimiterDirectionalPunctuations) {
/* 1385 */       bool1 = this.myParsing.PUNCTUATION_OPEN.matcher(str1).matches();
/* 1386 */       bool2 = this.myParsing.PUNCTUATION_CLOSE.matcher(str2).matches();
/*      */       
/* 1388 */       bool3 = (!bool6 && (!bool2 || bool5 || bool1)) ? true : false;
/*      */       
/* 1390 */       bool4 = (!bool5 && (!bool1 || bool6 || bool2)) ? true : false;
/*      */     } else {
/*      */       
/* 1393 */       bool1 = this.myParsing.PUNCTUATION.matcher(str1).matches();
/* 1394 */       bool2 = this.myParsing.PUNCTUATION.matcher(str2).matches();
/*      */       
/* 1396 */       bool3 = (!bool6 && (!bool2 || bool5 || bool1)) ? true : false;
/*      */       
/* 1398 */       bool4 = (!bool5 && (!bool1 || bool6 || bool2)) ? true : false;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1405 */     boolean bool7 = (paramChar == paramDelimiterProcessor.getOpeningCharacter() && paramDelimiterProcessor.canBeOpener(str1, str2, bool3, bool4, bool1, bool2, bool5, bool6)) ? true : false;
/* 1406 */     paramChar = (paramChar == paramDelimiterProcessor.getClosingCharacter() && paramDelimiterProcessor.canBeCloser(str1, str2, bool3, bool4, bool1, bool2, bool5, bool6)) ? '\001' : Character.MIN_VALUE;
/*      */     
/* 1408 */     this.index = i;
/*      */     
/* 1410 */     if (bool7 || paramChar != '\000' || !paramDelimiterProcessor.skipNonOpenerCloser()) {
/* 1411 */       return new DelimiterData(b, bool7, paramChar);
/*      */     }
/* 1413 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void processDelimiters(Delimiter paramDelimiter) {
/* 1419 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*      */ 
/*      */     
/* 1422 */     Delimiter delimiter = this.lastDelimiter;
/* 1423 */     while (delimiter != null && delimiter.getPrevious() != paramDelimiter) {
/* 1424 */       delimiter = delimiter.getPrevious();
/*      */     }
/*      */ 
/*      */     
/* 1428 */     while (delimiter != null) {
/* 1429 */       char c1 = delimiter.getDelimiterChar();
/*      */       
/* 1431 */       DelimiterProcessor delimiterProcessor = this.delimiterProcessors.get(Character.valueOf(c1));
/* 1432 */       if (!delimiter.canClose() || delimiterProcessor == null) {
/* 1433 */         delimiter = delimiter.getNext();
/*      */         
/*      */         continue;
/*      */       } 
/* 1437 */       char c2 = delimiterProcessor.getOpeningCharacter();
/*      */ 
/*      */       
/* 1440 */       int j = 0;
/* 1441 */       boolean bool1 = false;
/* 1442 */       boolean bool2 = false;
/* 1443 */       Delimiter delimiter1 = delimiter.getPrevious();
/* 1444 */       while (delimiter1 != null && delimiter1 != paramDelimiter && delimiter1 != hashMap.get(Character.valueOf(c1))) {
/*      */         
/* 1446 */         bool2 = true;
/*      */ 
/*      */         
/* 1449 */         if (delimiter1.canOpen() && delimiter1.getDelimiterChar() == c2 && (j = delimiterProcessor.getDelimiterUse((DelimiterRun)delimiter1, (DelimiterRun)delimiter)) > 0) {
/* 1450 */           bool1 = true;
/*      */           
/*      */           break;
/*      */         } 
/* 1454 */         delimiter1 = delimiter1.getPrevious();
/*      */       } 
/*      */       
/* 1457 */       if (!bool1) {
/* 1458 */         if (!bool2) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1466 */           hashMap.put(Character.valueOf(c1), delimiter.getPrevious());
/* 1467 */           if (!delimiter.canOpen())
/*      */           {
/*      */             
/* 1470 */             removeDelimiterKeepNode(delimiter);
/*      */           }
/*      */         } 
/* 1473 */         delimiter = delimiter.getNext();
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/* 1478 */       delimiter1.setNumDelims(delimiter1.getNumDelims() - j);
/* 1479 */       delimiter.setNumDelims(delimiter.getNumDelims() - j);
/*      */       
/* 1481 */       removeDelimitersBetween(delimiter1, delimiter);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1486 */       delimiter1.setNumDelims(delimiter1.getNumDelims() + j);
/* 1487 */       delimiter.setNumDelims(delimiter.getNumDelims() + j);
/*      */       
/* 1489 */       delimiterProcessor.process(delimiter1, delimiter, j);
/*      */       
/* 1491 */       delimiter1.setNumDelims(delimiter1.getNumDelims() - j);
/* 1492 */       delimiter.setNumDelims(delimiter.getNumDelims() - j);
/*      */ 
/*      */       
/* 1495 */       if (delimiter1.getNumDelims() == 0) {
/* 1496 */         removeDelimiterAndNode(delimiter1);
/*      */       } else {
/*      */         
/* 1499 */         delimiter1.getNode().setChars(delimiter1.getNode().getChars().subSequence(0, delimiter1.getNumDelims()));
/*      */       } 
/*      */       
/* 1502 */       if (delimiter.getNumDelims() == 0) {
/* 1503 */         Delimiter delimiter2 = delimiter.getNext();
/* 1504 */         removeDelimiterAndNode(delimiter);
/* 1505 */         delimiter = delimiter2;
/*      */         continue;
/*      */       } 
/*      */       BasedSequence basedSequence;
/* 1509 */       int i = (basedSequence = delimiter.getNode().getChars()).length();
/* 1510 */       delimiter.getNode().setChars(basedSequence.subSequence(i - delimiter.getNumDelims(), i));
/* 1511 */       delimiter.setIndex(delimiter.getIndex() + j);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1516 */     while (this.lastDelimiter != null && this.lastDelimiter != paramDelimiter) {
/* 1517 */       removeDelimiterKeepNode(this.lastDelimiter);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void removeDelimitersBetween(Delimiter paramDelimiter1, Delimiter paramDelimiter2) {
/* 1523 */     paramDelimiter2 = paramDelimiter2.getPrevious();
/* 1524 */     while (paramDelimiter2 != null && paramDelimiter2 != paramDelimiter1) {
/* 1525 */       Delimiter delimiter = paramDelimiter2.getPrevious();
/* 1526 */       removeDelimiterKeepNode(paramDelimiter2);
/* 1527 */       paramDelimiter2 = delimiter;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeDelimiterAndNode(Delimiter paramDelimiter) {
/* 1538 */     Text text1 = paramDelimiter.getNode();
/* 1539 */     Text text2 = paramDelimiter.getPreviousNonDelimiterTextNode();
/* 1540 */     Text text3 = paramDelimiter.getNextNonDelimiterTextNode();
/* 1541 */     if (text2 != null && text3 != null) {
/*      */       
/* 1543 */       text2.setChars(this.input.baseSubSequence(text2.getStartOffset(), text3.getEndOffset()));
/* 1544 */       text3.unlink();
/*      */     } 
/*      */     
/* 1547 */     text1.unlink();
/* 1548 */     removeDelimiter(paramDelimiter);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeDelimiterKeepNode(Delimiter paramDelimiter) {
/*      */     Text text1;
/*      */     DelimiterProcessor delimiterProcessor;
/*      */     Node node;
/* 1561 */     if ((node = (Node)(((delimiterProcessor = this.delimiterProcessors.get(Character.valueOf(paramDelimiter.getDelimiterChar()))) != null) ? delimiterProcessor.unmatchedDelimiterNode(this, (DelimiterRun)paramDelimiter) : null)) != null) {
/* 1562 */       if (node != paramDelimiter.getNode()) {
/*      */         
/* 1564 */         paramDelimiter.getNode().insertAfter(node);
/* 1565 */         paramDelimiter.getNode().unlink();
/*      */       } 
/*      */     } else {
/* 1568 */       text1 = paramDelimiter.getNode();
/*      */     } 
/*      */     
/* 1571 */     Text text2 = paramDelimiter.getPreviousNonDelimiterTextNode();
/* 1572 */     Text text3 = paramDelimiter.getNextNonDelimiterTextNode();
/* 1573 */     if (text1 instanceof Text && (text2 != null || text3 != null))
/*      */     {
/* 1575 */       if (text3 != null && text2 != null) {
/* 1576 */         text1.setChars(this.input.baseSubSequence(text2.getStartOffset(), text3.getEndOffset()));
/* 1577 */         text2.unlink();
/* 1578 */         text3.unlink();
/* 1579 */       } else if (text2 != null) {
/* 1580 */         text1.setChars(this.input.baseSubSequence(text2.getStartOffset(), text1.getEndOffset()));
/* 1581 */         text2.unlink();
/*      */       } else {
/* 1583 */         text1.setChars(this.input.baseSubSequence(text1.getStartOffset(), text3.getEndOffset()));
/* 1584 */         text3.unlink();
/*      */       } 
/*      */     }
/*      */     
/* 1588 */     removeDelimiter(paramDelimiter);
/*      */   }
/*      */ 
/*      */   
/*      */   public void removeDelimiter(Delimiter paramDelimiter) {
/* 1593 */     if (paramDelimiter.getPrevious() != null) {
/* 1594 */       paramDelimiter.getPrevious().setNext(paramDelimiter.getNext());
/*      */     }
/* 1596 */     if (paramDelimiter.getNext() == null) {
/*      */       
/* 1598 */       this.lastDelimiter = paramDelimiter.getPrevious(); return;
/*      */     } 
/* 1600 */     paramDelimiter.getNext().setPrevious(paramDelimiter.getPrevious());
/*      */   }
/*      */ 
/*      */   
/*      */   static Map<Character, List<InlineParserExtensionFactory>> calculateInlineParserExtensions(DataHolder paramDataHolder, List<InlineParserExtensionFactory> paramList) {
/* 1605 */     HashMap<Object, Object> hashMap1 = new HashMap<>();
/*      */     
/* 1607 */     for (Iterator<InlineParserExtensionFactory> iterator = paramList.iterator(); iterator.hasNext(); ) {
/* 1608 */       InlineParserExtensionFactory inlineParserExtensionFactory; CharSequence charSequence = (inlineParserExtensionFactory = iterator.next()).getCharacters();
/* 1609 */       for (byte b = 0; b < charSequence.length(); b++) {
/* 1610 */         char c = charSequence.charAt(b);
/*      */         List<InlineParserExtensionFactory> list;
/* 1612 */         (list = (List<InlineParserExtensionFactory>)hashMap1.computeIfAbsent(Character.valueOf(c), paramCharacter -> new ArrayList())).add(inlineParserExtensionFactory);
/*      */       } 
/*      */     } 
/*      */     
/* 1616 */     HashMap<Object, Object> hashMap2 = new HashMap<>();
/* 1617 */     for (Character character : hashMap1.keySet()) {
/*      */       
/* 1619 */       List list1, list2 = DependencyResolver.resolveFlatDependencies(list1 = (List)hashMap1.get(character), null, null);
/* 1620 */       hashMap2.put(character, list2);
/*      */     } 
/*      */     
/* 1623 */     return (Map)hashMap2;
/*      */   }
/*      */   
/*      */   public static BitSet calculateDelimiterCharacters(DataHolder paramDataHolder, Set<Character> paramSet) {
/* 1627 */     BitSet bitSet = new BitSet();
/* 1628 */     for (Character character : paramSet) {
/* 1629 */       bitSet.set(character.charValue());
/*      */     }
/* 1631 */     return bitSet;
/*      */   }
/*      */   
/*      */   public static BitSet calculateSpecialCharacters(DataHolder paramDataHolder, BitSet paramBitSet) {
/*      */     BitSet bitSet;
/* 1636 */     (bitSet = new BitSet()).or(paramBitSet);
/* 1637 */     bitSet.set(13);
/* 1638 */     bitSet.set(10);
/* 1639 */     bitSet.set(96);
/* 1640 */     bitSet.set(91);
/* 1641 */     bitSet.set(93);
/* 1642 */     bitSet.set(92);
/* 1643 */     bitSet.set(33);
/* 1644 */     bitSet.set(60);
/* 1645 */     bitSet.set(38);
/* 1646 */     return bitSet;
/*      */   }
/*      */   
/*      */   public static Map<Character, DelimiterProcessor> calculateDelimiterProcessors(DataHolder paramDataHolder, List<DelimiterProcessor> paramList) {
/* 1650 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*      */     
/* 1652 */     if (((Boolean)Parser.ASTERISK_DELIMITER_PROCESSOR.get(paramDataHolder)).booleanValue()) {
/* 1653 */       addDelimiterProcessors((List)Collections.singletonList(new AsteriskDelimiterProcessor(((Boolean)Parser.STRONG_WRAPS_EMPHASIS.get(paramDataHolder)).booleanValue())), (Map)hashMap);
/*      */     }
/* 1655 */     if (((Boolean)Parser.UNDERSCORE_DELIMITER_PROCESSOR.get(paramDataHolder)).booleanValue()) {
/* 1656 */       addDelimiterProcessors((List)Collections.singletonList(new UnderscoreDelimiterProcessor(((Boolean)Parser.STRONG_WRAPS_EMPHASIS.get(paramDataHolder)).booleanValue())), (Map)hashMap);
/*      */     }
/*      */     
/* 1659 */     addDelimiterProcessors(paramList, (Map)hashMap);
/* 1660 */     return (Map)hashMap;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static LinkRefProcessorData calculateLinkRefProcessors(DataHolder paramDataHolder, List<LinkRefProcessorFactory> paramList) {
/*      */     // Byte code:
/*      */     //   0: aload_1
/*      */     //   1: invokeinterface size : ()I
/*      */     //   6: iconst_1
/*      */     //   7: if_icmple -> 149
/*      */     //   10: new java/util/ArrayList
/*      */     //   13: dup
/*      */     //   14: aload_1
/*      */     //   15: invokeinterface size : ()I
/*      */     //   20: invokespecial <init> : (I)V
/*      */     //   23: dup
/*      */     //   24: astore_2
/*      */     //   25: aload_1
/*      */     //   26: invokeinterface addAll : (Ljava/util/Collection;)Z
/*      */     //   31: pop
/*      */     //   32: iconst_1
/*      */     //   33: newarray int
/*      */     //   35: dup
/*      */     //   36: iconst_0
/*      */     //   37: iconst_0
/*      */     //   38: iastore
/*      */     //   39: astore_3
/*      */     //   40: aload_2
/*      */     //   41: aload_0
/*      */     //   42: aload_3
/*      */     //   43: <illegal opcode> compare : (Lcom/vladsch/flexmark/util/data/DataHolder;[I)Ljava/util/Comparator;
/*      */     //   48: invokestatic sort : (Ljava/util/List;Ljava/util/Comparator;)V
/*      */     //   51: aload_3
/*      */     //   52: iconst_0
/*      */     //   53: iaload
/*      */     //   54: dup
/*      */     //   55: istore_1
/*      */     //   56: istore_3
/*      */     //   57: iload_1
/*      */     //   58: iconst_1
/*      */     //   59: iadd
/*      */     //   60: newarray int
/*      */     //   62: astore #4
/*      */     //   64: iconst_m1
/*      */     //   65: istore_1
/*      */     //   66: iconst_0
/*      */     //   67: istore #5
/*      */     //   69: aload_2
/*      */     //   70: invokeinterface iterator : ()Ljava/util/Iterator;
/*      */     //   75: astore #6
/*      */     //   77: aload #6
/*      */     //   79: invokeinterface hasNext : ()Z
/*      */     //   84: ifeq -> 137
/*      */     //   87: aload #6
/*      */     //   89: invokeinterface next : ()Ljava/lang/Object;
/*      */     //   94: checkcast com/vladsch/flexmark/parser/LinkRefProcessorFactory
/*      */     //   97: astore #7
/*      */     //   99: iload_1
/*      */     //   100: aload #7
/*      */     //   102: aload_0
/*      */     //   103: invokeinterface getBracketNestingLevel : (Lcom/vladsch/flexmark/util/data/DataHolder;)I
/*      */     //   108: if_icmpge -> 131
/*      */     //   111: aload #7
/*      */     //   113: aload_0
/*      */     //   114: invokeinterface getBracketNestingLevel : (Lcom/vladsch/flexmark/util/data/DataHolder;)I
/*      */     //   119: istore_1
/*      */     //   120: aload #4
/*      */     //   122: iload_1
/*      */     //   123: iload #5
/*      */     //   125: iastore
/*      */     //   126: iload_1
/*      */     //   127: iload_3
/*      */     //   128: if_icmpeq -> 137
/*      */     //   131: iinc #5, 1
/*      */     //   134: goto -> 77
/*      */     //   137: new com/vladsch/flexmark/parser/internal/LinkRefProcessorData
/*      */     //   140: dup
/*      */     //   141: aload_2
/*      */     //   142: iload_3
/*      */     //   143: aload #4
/*      */     //   145: invokespecial <init> : (Ljava/util/List;I[I)V
/*      */     //   148: areturn
/*      */     //   149: aload_1
/*      */     //   150: invokeinterface size : ()I
/*      */     //   155: ifle -> 192
/*      */     //   158: aload_1
/*      */     //   159: iconst_0
/*      */     //   160: invokeinterface get : (I)Ljava/lang/Object;
/*      */     //   165: checkcast com/vladsch/flexmark/parser/LinkRefProcessorFactory
/*      */     //   168: aload_0
/*      */     //   169: invokeinterface getBracketNestingLevel : (Lcom/vladsch/flexmark/util/data/DataHolder;)I
/*      */     //   174: dup
/*      */     //   175: istore_2
/*      */     //   176: iconst_1
/*      */     //   177: iadd
/*      */     //   178: newarray int
/*      */     //   180: astore_3
/*      */     //   181: new com/vladsch/flexmark/parser/internal/LinkRefProcessorData
/*      */     //   184: dup
/*      */     //   185: aload_1
/*      */     //   186: iload_2
/*      */     //   187: aload_3
/*      */     //   188: invokespecial <init> : (Ljava/util/List;I[I)V
/*      */     //   191: areturn
/*      */     //   192: new com/vladsch/flexmark/parser/internal/LinkRefProcessorData
/*      */     //   195: dup
/*      */     //   196: aload_1
/*      */     //   197: iconst_0
/*      */     //   198: iconst_0
/*      */     //   199: newarray int
/*      */     //   201: invokespecial <init> : (Ljava/util/List;I[I)V
/*      */     //   204: areturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #1665	-> 0
/*      */     //   #1666	-> 10
/*      */     //   #1667	-> 24
/*      */     //   #1669	-> 32
/*      */     //   #1671	-> 40
/*      */     //   #1687	-> 51
/*      */     //   #1689	-> 55
/*      */     //   #1690	-> 57
/*      */     //   #1692	-> 64
/*      */     //   #1693	-> 66
/*      */     //   #1694	-> 69
/*      */     //   #1695	-> 99
/*      */     //   #1696	-> 111
/*      */     //   #1697	-> 120
/*      */     //   #1698	-> 126
/*      */     //   #1700	-> 131
/*      */     //   #1701	-> 134
/*      */     //   #1703	-> 137
/*      */     //   #1704	-> 149
/*      */     //   #1705	-> 158
/*      */     //   #1706	-> 175
/*      */     //   #1707	-> 181
/*      */     //   #1709	-> 192
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void addDelimiterProcessors(List<? extends DelimiterProcessor> paramList, Map<Character, DelimiterProcessor> paramMap) {
/* 1714 */     for (Iterator<? extends DelimiterProcessor> iterator = paramList.iterator(); iterator.hasNext(); ) {
/*      */       DelimiterProcessor delimiterProcessor; char c1;
/* 1716 */       addDelimiterProcessorForChar(c1 = (delimiterProcessor = iterator.next()).getOpeningCharacter(), delimiterProcessor, paramMap);
/* 1717 */       char c2 = delimiterProcessor.getClosingCharacter();
/* 1718 */       if (c1 != c2) {
/* 1719 */         addDelimiterProcessorForChar(c2, delimiterProcessor, paramMap);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private static void addDelimiterProcessorForChar(char paramChar, DelimiterProcessor paramDelimiterProcessor, Map<Character, DelimiterProcessor> paramMap) {
/*      */     DelimiterProcessor delimiterProcessor;
/* 1726 */     if ((delimiterProcessor = paramMap.put(Character.valueOf(paramChar), paramDelimiterProcessor)) != null) {
/* 1727 */       if (delimiterProcessor.getClass() != paramDelimiterProcessor.getClass()) {
/* 1728 */         throw new IllegalArgumentException("Delimiter processor conflict with delimiter char '" + paramChar + "', existing " + delimiterProcessor.getClass().getCanonicalName() + ", added " + paramDelimiterProcessor.getClass().getCanonicalName());
/*      */       }
/*      */       
/* 1731 */       System.out.println("Delimiter processor for char '" + paramChar + "', added more than once " + delimiterProcessor.getClass().getCanonicalName());
/*      */     } 
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\internal\InlineParserImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */