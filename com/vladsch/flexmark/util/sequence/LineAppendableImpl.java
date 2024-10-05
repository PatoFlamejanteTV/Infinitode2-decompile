/*      */ package com.vladsch.flexmark.util.sequence;
/*      */ 
/*      */ import com.vladsch.flexmark.util.collection.iteration.Indexed;
/*      */ import com.vladsch.flexmark.util.collection.iteration.IndexedItemIterable;
/*      */ import com.vladsch.flexmark.util.collection.iteration.IndexedItemIterator;
/*      */ import com.vladsch.flexmark.util.misc.BitFieldSet;
/*      */ import com.vladsch.flexmark.util.misc.CharPredicate;
/*      */ import com.vladsch.flexmark.util.misc.Pair;
/*      */ import com.vladsch.flexmark.util.misc.Utils;
/*      */ import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
/*      */ import com.vladsch.flexmark.util.sequence.builder.StringSequenceBuilder;
/*      */ import java.io.IOException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Iterator;
/*      */ import java.util.Stack;
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
/*      */ public class LineAppendableImpl
/*      */   implements LineAppendable
/*      */ {
/*      */   private static final char EOL = '\n';
/*      */   private final boolean passThrough;
/*      */   private final BitFieldSet<LineAppendable.Options> options;
/*      */   private int preFormattedNesting;
/*      */   private int preFormattedFirstLine;
/*      */   private int preFormattedFirstLineOffset;
/*      */   private int preFormattedLastLine;
/*      */   private int preFormattedLastLineOffset;
/*      */   private ISequenceBuilder<?, ?> appendable;
/*      */   final ArrayList<LineInfo> lines;
/*      */   private CharSequence prefix;
/*      */   private CharSequence prefixAfterEol;
/*      */   private CharSequence indentPrefix;
/*      */   private final Stack<CharSequence> prefixStack;
/*      */   private final Stack<Boolean> indentPrefixStack;
/*      */   private boolean allWhitespace;
/*      */   private boolean lastWasWhitespace;
/*      */   private int eolOnFirstText;
/*      */   private final ArrayList<Runnable> indentsOnFirstEol;
/*   53 */   private final Stack<Integer> optionStack = new Stack<>();
/*      */   int modificationCount;
/*      */   
/*      */   public LineAppendableImpl(int paramInt) {
/*   57 */     this((Appendable)null, LineAppendable.toOptionSet(paramInt));
/*      */   }
/*      */   
/*      */   public LineAppendableImpl(Appendable paramAppendable, int paramInt) {
/*   61 */     this(paramAppendable, LineAppendable.toOptionSet(paramInt));
/*      */   }
/*      */   
/*      */   public LineAppendableImpl(Appendable paramAppendable, BitFieldSet<LineAppendable.Options> paramBitFieldSet) {
/*   65 */     this
/*      */       
/*   67 */       .appendable = (paramAppendable instanceof ISequenceBuilder) ? ((ISequenceBuilder)paramAppendable).getBuilder() : ((paramAppendable instanceof LineAppendable) ? ((LineAppendable)paramAppendable).getBuilder() : (ISequenceBuilder<?, ?>)StringSequenceBuilder.emptyBuilder());
/*      */     
/*   69 */     this.options = paramBitFieldSet;
/*   70 */     this.passThrough = any(F_PASS_THROUGH);
/*   71 */     this.preFormattedNesting = 0;
/*   72 */     this.preFormattedFirstLine = -1;
/*   73 */     this.preFormattedLastLine = -1;
/*   74 */     this.allWhitespace = true;
/*   75 */     this.lastWasWhitespace = false;
/*   76 */     this.lines = new ArrayList<>();
/*   77 */     this.prefixStack = new Stack<>();
/*   78 */     this.indentPrefixStack = new Stack<>();
/*   79 */     this.prefix = BasedSequence.EMPTY;
/*   80 */     this.prefixAfterEol = BasedSequence.EMPTY;
/*   81 */     this.indentPrefix = BasedSequence.EMPTY;
/*   82 */     this.eolOnFirstText = 0;
/*   83 */     this.indentsOnFirstEol = new ArrayList<>();
/*      */   }
/*      */ 
/*      */   
/*      */   public LineAppendable getEmptyAppendable() {
/*   88 */     return new LineAppendableImpl(this, getOptions());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public BitFieldSet<LineAppendable.Options> getOptionSet() {
/*   94 */     return this.options;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public LineAppendable setOptions(int paramInt) {
/*  100 */     this.options.setAll(paramInt);
/*  101 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public LineAppendable pushOptions() {
/*  106 */     this.optionStack.push(Integer.valueOf(this.options.toInt()));
/*  107 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public LineAppendable popOptions() {
/*  112 */     if (this.optionStack.isEmpty()) {
/*  113 */       throw new IllegalStateException("Option stack is empty");
/*      */     }
/*  115 */     Integer integer = this.optionStack.pop();
/*  116 */     this.options.setAll(integer.intValue());
/*  117 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public LineAppendable changeOptions(int paramInt1, int paramInt2) {
/*  122 */     if ((paramInt1 & paramInt2) != 0) {
/*  123 */       throw new IllegalStateException(String.format("Add flags:%d and remove flags:%d overlap:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1 & paramInt2) }));
/*      */     }
/*  125 */     this.options.orMask(paramInt1);
/*  126 */     this.options.andNotMask(paramInt2);
/*  127 */     return this;
/*      */   }
/*      */   
/*      */   private boolean any(int paramInt) {
/*  131 */     return this.options.any(paramInt);
/*      */   }
/*      */   
/*      */   private boolean isConvertingTabs() {
/*  135 */     return any(F_CONVERT_TABS | F_COLLAPSE_WHITESPACE);
/*      */   }
/*      */   
/*      */   private boolean isTrimTrailingWhitespace() {
/*  139 */     return any(F_TRIM_TRAILING_WHITESPACE);
/*      */   }
/*      */   
/*      */   private boolean isTrimLeadingWhitespace() {
/*  143 */     return any(F_TRIM_LEADING_WHITESPACE);
/*      */   }
/*      */   
/*      */   private boolean isCollapseWhitespace() {
/*  147 */     return any(F_COLLAPSE_WHITESPACE);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public BasedSequence getIndentPrefix() {
/*  153 */     return BasedSequence.of(this.indentPrefix);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public LineAppendable setIndentPrefix(CharSequence paramCharSequence) {
/*  159 */     this.indentPrefix = (paramCharSequence == null) ? BasedSequence.NULL : paramCharSequence;
/*  160 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public BasedSequence getPrefix() {
/*  165 */     return BasedSequence.of(this.prefixAfterEol);
/*      */   }
/*      */ 
/*      */   
/*      */   public BasedSequence getBeforeEolPrefix() {
/*  170 */     return BasedSequence.of(this.prefix);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public LineAppendable addPrefix(CharSequence paramCharSequence, boolean paramBoolean) {
/*  176 */     if (!this.passThrough && paramCharSequence.length() != 0) {
/*  177 */       if (paramBoolean) {
/*  178 */         this.prefixAfterEol = LineAppendable.combinedPrefix(this.prefixAfterEol, paramCharSequence);
/*      */       } else {
/*  180 */         this.prefix = LineAppendable.combinedPrefix(this.prefixAfterEol, paramCharSequence);
/*  181 */         this.prefixAfterEol = this.prefix;
/*      */       } 
/*      */     }
/*  184 */     return this;
/*      */   }
/*      */   
/*      */   public int getAfterEolPrefixDelta() {
/*  188 */     return this.prefixAfterEol.length() - this.prefix.length();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public LineAppendable setPrefix(CharSequence paramCharSequence, boolean paramBoolean) {
/*  194 */     if (!this.passThrough) {
/*  195 */       if (paramBoolean) {
/*  196 */         this.prefixAfterEol = (paramCharSequence == null) ? BasedSequence.NULL : paramCharSequence;
/*      */       } else {
/*  198 */         this.prefix = (paramCharSequence == null) ? BasedSequence.NULL : paramCharSequence;
/*  199 */         this.prefixAfterEol = this.prefix;
/*      */       } 
/*      */     }
/*  202 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public LineAppendable indent() {
/*  208 */     if (!this.passThrough) {
/*  209 */       line();
/*  210 */       rawIndent();
/*      */     } 
/*  212 */     return this;
/*      */   }
/*      */   
/*      */   private void rawIndent() {
/*  216 */     this.prefixStack.push(this.prefixAfterEol);
/*  217 */     this.prefix = LineAppendable.combinedPrefix(this.prefixAfterEol, this.indentPrefix);
/*  218 */     this.prefixAfterEol = this.prefix;
/*  219 */     this.indentPrefixStack.push(Boolean.TRUE);
/*      */   }
/*      */   
/*      */   private void rawUnIndent() {
/*  223 */     if (this.prefixStack.isEmpty()) throw new IllegalStateException("unIndent with an empty stack"); 
/*  224 */     if (!((Boolean)this.indentPrefixStack.peek()).booleanValue()) throw new IllegalStateException("unIndent for an element added by pushPrefix(), use popPrefix() instead");
/*      */     
/*  226 */     this.prefix = this.prefixStack.pop();
/*  227 */     this.prefixAfterEol = this.prefix;
/*  228 */     this.indentPrefixStack.pop();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public LineAppendable unIndent() {
/*  234 */     if (!this.passThrough) {
/*  235 */       line();
/*  236 */       rawUnIndent();
/*      */     } 
/*  238 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public LineAppendable unIndentNoEol() {
/*  244 */     if (!this.passThrough) {
/*  245 */       if (endsWithEOL()) {
/*  246 */         rawUnIndent();
/*      */       } else {
/*  248 */         CharSequence charSequence = this.prefix;
/*  249 */         rawUnIndent();
/*  250 */         this.prefixAfterEol = this.prefix;
/*  251 */         this.prefix = charSequence;
/*      */       } 
/*      */     }
/*  254 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public LineAppendable pushPrefix() {
/*  260 */     if (!this.passThrough) {
/*  261 */       this.prefixStack.push(this.prefixAfterEol);
/*  262 */       this.indentPrefixStack.push(Boolean.FALSE);
/*      */     } 
/*  264 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public LineAppendable popPrefix(boolean paramBoolean) {
/*  270 */     if (!this.passThrough) {
/*  271 */       if (this.prefixStack.isEmpty()) throw new IllegalStateException("popPrefix with an empty stack"); 
/*  272 */       if (((Boolean)this.indentPrefixStack.peek()).booleanValue()) throw new IllegalStateException("popPrefix for element added by indent(), use unIndent() instead");
/*      */       
/*  274 */       this.prefixAfterEol = this.prefixStack.pop();
/*  275 */       if (!paramBoolean) {
/*  276 */         this.prefix = this.prefixAfterEol;
/*      */       }
/*  278 */       this.indentPrefixStack.pop();
/*      */     } 
/*  280 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   LineInfo getLastLineInfo() {
/*  285 */     return this.lines.isEmpty() ? LineInfo.NULL : this.lines.get(this.lines.size() - 1);
/*      */   }
/*      */   
/*      */   private boolean isTrailingBlankLine() {
/*  289 */     return (this.appendable.length() == 0 && getLastLineInfo().isBlankText());
/*      */   }
/*      */   
/*      */   int lastNonBlankLine(int paramInt) {
/*  293 */     if (paramInt > this.lines.size() && this.appendable.length() > 0 && !this.allWhitespace)
/*      */     {
/*  295 */       return this.lines.size();
/*      */     }
/*      */     
/*  298 */     paramInt = Math.min(this.lines.size(), paramInt); LineInfo lineInfo;
/*  299 */     while (paramInt-- > 0 && (
/*      */       
/*  301 */       lineInfo = this.lines.get(paramInt)).isBlankText());
/*      */     
/*  303 */     return paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getTrailingBlankLines(int paramInt) {
/*  309 */     return (paramInt = Math.min(this.lines.size(), paramInt)) - lastNonBlankLine(paramInt) - 1;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean endsWithEOL() {
/*  314 */     return (this.appendable.length() == 0 && getLastLineInfo().isNotNull());
/*      */   }
/*      */   private LineInfo getLineRange(int paramInt1, int paramInt2, CharSequence paramCharSequence) {
/*      */     LineInfo.Preformatted preformatted;
/*  318 */     assert paramInt1 <= paramInt2;
/*      */ 
/*      */     
/*      */     CharSequence charSequence2, charSequence3;
/*      */     
/*  323 */     if ((charSequence3 = SequenceUtils.<CharSequence>trimmedEOL(charSequence2 = this.appendable.toSequence())) == null || charSequence3.length() == 0) {
/*  324 */       charSequence3 = "\n";
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  329 */     charSequence2 = (paramInt1 == Range.NULL.getStart() && paramInt2 == Range.NULL.getEnd()) ? BasedSequence.NULL : charSequence2.subSequence(paramInt1, Math.max(paramInt1, paramInt2 - Math.max(0, charSequence3.length() - 1)));
/*      */     
/*  331 */     if (paramInt1 >= paramInt2) {
/*  332 */       paramCharSequence = SequenceUtils.trimEnd(paramCharSequence);
/*      */     }
/*      */     
/*  335 */     CharSequence charSequence1 = this.appendable.getBuilder().append(paramCharSequence).append(charSequence2).append(charSequence3).toSequence();
/*      */ 
/*      */ 
/*      */     
/*  339 */     if (this.preFormattedNesting > 0) {
/*  340 */       preformatted = (this.preFormattedFirstLine == this.lines.size()) ? LineInfo.Preformatted.FIRST : LineInfo.Preformatted.BODY;
/*      */     } else {
/*  342 */       preformatted = (this.preFormattedFirstLine == this.lines.size()) ? LineInfo.Preformatted.LAST : LineInfo.Preformatted.NONE;
/*      */     } 
/*      */     
/*  345 */     return LineInfo.create(charSequence1, getLastLineInfo(), paramCharSequence.length(), charSequence2.length(), charSequence1.length(), SequenceUtils.isBlank(paramCharSequence), (this.allWhitespace || charSequence2.length() == 0), preformatted);
/*      */   }
/*      */   
/*      */   private void resetBuilder() {
/*  349 */     this.appendable = this.appendable.getBuilder();
/*  350 */     this.allWhitespace = true;
/*  351 */     this.lastWasWhitespace = true;
/*      */   }
/*      */   
/*      */   private void addLineRange(int paramInt1, int paramInt2, CharSequence paramCharSequence) {
/*  355 */     this.lines.add(getLineRange(paramInt1, paramInt2, paramCharSequence));
/*  356 */     resetBuilder();
/*      */   }
/*      */   
/*      */   private void appendEol(CharSequence paramCharSequence) {
/*  360 */     this.appendable.append(paramCharSequence);
/*      */     
/*  362 */     int i = this.appendable.length();
/*  363 */     addLineRange(0, i - paramCharSequence.length(), this.prefix);
/*  364 */     this.eolOnFirstText = 0;
/*      */     
/*  366 */     rawIndentsOnFirstEol();
/*      */   }
/*      */   
/*      */   private void rawIndentsOnFirstEol() {
/*  370 */     this.prefix = this.prefixAfterEol;
/*      */     
/*  372 */     while (!this.indentsOnFirstEol.isEmpty()) {
/*  373 */       Runnable runnable = this.indentsOnFirstEol.remove(this.indentsOnFirstEol.size() - 1);
/*  374 */       rawIndent();
/*  375 */       runnable.run();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void appendEol(int paramInt) {
/*  380 */     while (paramInt-- > 0) {
/*  381 */       appendEol(BasedSequence.EOL);
/*      */     }
/*      */   }
/*      */   
/*      */   private boolean isPrefixed(int paramInt) {
/*  386 */     return (any(F_PREFIX_PRE_FORMATTED) || this.preFormattedFirstLine == paramInt || (this.preFormattedNesting == 0 && this.preFormattedLastLine != paramInt));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Pair<Range, CharSequence> getRangePrefixAfterEol() {
/*  397 */     int i = 0;
/*  398 */     int j = this.appendable.length() + 1;
/*  399 */     int k = this.lines.size();
/*  400 */     boolean bool = isPrefixed(k);
/*      */     
/*  402 */     if (this.passThrough) {
/*  403 */       return new Pair(Range.of(0, j - 1), bool ? this.prefix : BasedSequence.NULL);
/*      */     }
/*  405 */     if (this.allWhitespace && this.preFormattedNesting == 0 && this.preFormattedFirstLine != k && this.preFormattedLastLine != k) {
/*  406 */       if (!any(F_TRIM_LEADING_EOL) || !this.lines.isEmpty()) {
/*  407 */         return new Pair(Range.of(0, j - 1), this.prefix);
/*      */       }
/*  409 */       return new Pair(Range.NULL, BasedSequence.NULL);
/*      */     } 
/*      */ 
/*      */     
/*  413 */     if (isTrimTrailingWhitespace() && this.preFormattedNesting == 0) {
/*  414 */       if (this.allWhitespace) {
/*  415 */         i = j - 1;
/*      */       } else {
/*  417 */         j -= SequenceUtils.countTrailingSpaceTab(this.appendable.toSequence(), j - 1);
/*      */       } 
/*      */     }
/*      */     
/*  421 */     if (this.preFormattedFirstLine == k && 
/*  422 */       i > this.preFormattedFirstLineOffset) i = this.preFormattedFirstLineOffset;
/*      */ 
/*      */     
/*  425 */     if (this.preFormattedLastLine == k && 
/*  426 */       j < this.preFormattedLastLineOffset + 1) j = this.preFormattedLastLineOffset + 1;
/*      */ 
/*      */     
/*  429 */     return new Pair(Range.of(i, j - 1), bool ? this.prefix : BasedSequence.NULL);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int offsetAfterEol() {
/*  440 */     Pair<Range, CharSequence> pair = getRangePrefixAfterEol();
/*  441 */     LineInfo lineInfo = getLastLineInfo();
/*      */     
/*  443 */     if (((Range)pair.getFirst()).isNull()) {
/*  444 */       return lineInfo.sumLength;
/*      */     }
/*  446 */     Range range = (Range)pair.getFirst();
/*  447 */     CharSequence charSequence = (CharSequence)pair.getSecond();
/*      */     
/*  449 */     if (range.isEmpty() && charSequence.length() != 0) {
/*  450 */       charSequence = SequenceUtils.trimEnd(charSequence);
/*      */     }
/*      */     
/*  453 */     return lineInfo.sumLength + ((Range)pair.getFirst()).getSpan() + charSequence.length();
/*      */   }
/*      */ 
/*      */   
/*      */   private void doEolOnFirstTest() {
/*  458 */     if (this.eolOnFirstText > 0) {
/*  459 */       this.eolOnFirstText = 0;
/*  460 */       appendEol(BasedSequence.EOL);
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
/*      */   private void appendImpl(CharSequence paramCharSequence, int paramInt) {
/*      */     // Byte code:
/*      */     //   0: aload_1
/*      */     //   1: iload_2
/*      */     //   2: invokeinterface charAt : (I)C
/*      */     //   7: istore_3
/*      */     //   8: aload_0
/*      */     //   9: getfield passThrough : Z
/*      */     //   12: ifeq -> 77
/*      */     //   15: iload_3
/*      */     //   16: bipush #10
/*      */     //   18: if_icmpne -> 29
/*      */     //   21: aload_0
/*      */     //   22: getstatic com/vladsch/flexmark/util/sequence/BasedSequence.EOL : Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*      */     //   25: invokespecial appendEol : (Ljava/lang/CharSequence;)V
/*      */     //   28: return
/*      */     //   29: aload_0
/*      */     //   30: getfield eolOnFirstText : I
/*      */     //   33: ifle -> 48
/*      */     //   36: aload_0
/*      */     //   37: iconst_0
/*      */     //   38: putfield eolOnFirstText : I
/*      */     //   41: aload_0
/*      */     //   42: getstatic com/vladsch/flexmark/util/sequence/BasedSequence.EOL : Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*      */     //   45: invokespecial appendEol : (Ljava/lang/CharSequence;)V
/*      */     //   48: iload_3
/*      */     //   49: bipush #9
/*      */     //   51: if_icmpeq -> 65
/*      */     //   54: iload_3
/*      */     //   55: bipush #32
/*      */     //   57: if_icmpeq -> 65
/*      */     //   60: aload_0
/*      */     //   61: iconst_0
/*      */     //   62: putfield allWhitespace : Z
/*      */     //   65: aload_0
/*      */     //   66: getfield appendable : Lcom/vladsch/flexmark/util/sequence/builder/ISequenceBuilder;
/*      */     //   69: iload_3
/*      */     //   70: invokeinterface append : (C)Lcom/vladsch/flexmark/util/sequence/builder/ISequenceBuilder;
/*      */     //   75: pop
/*      */     //   76: return
/*      */     //   77: iload_3
/*      */     //   78: bipush #10
/*      */     //   80: if_icmpne -> 145
/*      */     //   83: aload_0
/*      */     //   84: invokespecial getRangePrefixAfterEol : ()Lcom/vladsch/flexmark/util/misc/Pair;
/*      */     //   87: dup
/*      */     //   88: astore_1
/*      */     //   89: invokevirtual getFirst : ()Ljava/lang/Object;
/*      */     //   92: checkcast com/vladsch/flexmark/util/sequence/Range
/*      */     //   95: dup
/*      */     //   96: astore_2
/*      */     //   97: invokevirtual isNull : ()Z
/*      */     //   100: ifeq -> 110
/*      */     //   103: aload_0
/*      */     //   104: invokespecial resetBuilder : ()V
/*      */     //   107: goto -> 140
/*      */     //   110: aload_0
/*      */     //   111: getfield appendable : Lcom/vladsch/flexmark/util/sequence/builder/ISequenceBuilder;
/*      */     //   114: iload_3
/*      */     //   115: invokeinterface append : (C)Lcom/vladsch/flexmark/util/sequence/builder/ISequenceBuilder;
/*      */     //   120: pop
/*      */     //   121: aload_0
/*      */     //   122: aload_2
/*      */     //   123: invokevirtual getStart : ()I
/*      */     //   126: aload_2
/*      */     //   127: invokevirtual getEnd : ()I
/*      */     //   130: aload_1
/*      */     //   131: invokevirtual getSecond : ()Ljava/lang/Object;
/*      */     //   134: checkcast java/lang/CharSequence
/*      */     //   137: invokespecial addLineRange : (IILjava/lang/CharSequence;)V
/*      */     //   140: aload_0
/*      */     //   141: invokespecial rawIndentsOnFirstEol : ()V
/*      */     //   144: return
/*      */     //   145: aload_0
/*      */     //   146: invokespecial doEolOnFirstTest : ()V
/*      */     //   149: iload_3
/*      */     //   150: bipush #9
/*      */     //   152: if_icmpne -> 253
/*      */     //   155: aload_0
/*      */     //   156: getfield preFormattedNesting : I
/*      */     //   159: ifne -> 197
/*      */     //   162: aload_0
/*      */     //   163: getstatic com/vladsch/flexmark/util/sequence/LineAppendableImpl.F_COLLAPSE_WHITESPACE : I
/*      */     //   166: invokespecial any : (I)Z
/*      */     //   169: ifeq -> 197
/*      */     //   172: aload_0
/*      */     //   173: getfield lastWasWhitespace : Z
/*      */     //   176: ifne -> 393
/*      */     //   179: aload_0
/*      */     //   180: getfield appendable : Lcom/vladsch/flexmark/util/sequence/builder/ISequenceBuilder;
/*      */     //   183: bipush #32
/*      */     //   185: invokeinterface append : (C)Lcom/vladsch/flexmark/util/sequence/builder/ISequenceBuilder;
/*      */     //   190: pop
/*      */     //   191: aload_0
/*      */     //   192: iconst_1
/*      */     //   193: putfield lastWasWhitespace : Z
/*      */     //   196: return
/*      */     //   197: aload_0
/*      */     //   198: getstatic com/vladsch/flexmark/util/sequence/LineAppendableImpl.F_CONVERT_TABS : I
/*      */     //   201: invokespecial any : (I)Z
/*      */     //   204: ifeq -> 237
/*      */     //   207: aload_0
/*      */     //   208: getfield appendable : Lcom/vladsch/flexmark/util/sequence/builder/ISequenceBuilder;
/*      */     //   211: invokeinterface length : ()I
/*      */     //   216: istore_1
/*      */     //   217: iconst_4
/*      */     //   218: iload_1
/*      */     //   219: iconst_4
/*      */     //   220: irem
/*      */     //   221: isub
/*      */     //   222: istore_2
/*      */     //   223: aload_0
/*      */     //   224: getfield appendable : Lcom/vladsch/flexmark/util/sequence/builder/ISequenceBuilder;
/*      */     //   227: bipush #32
/*      */     //   229: iload_2
/*      */     //   230: invokeinterface append : (CI)Lcom/vladsch/flexmark/util/sequence/builder/ISequenceBuilder;
/*      */     //   235: pop
/*      */     //   236: return
/*      */     //   237: aload_0
/*      */     //   238: getfield appendable : Lcom/vladsch/flexmark/util/sequence/builder/ISequenceBuilder;
/*      */     //   241: aload_1
/*      */     //   242: iload_2
/*      */     //   243: dup
/*      */     //   244: iconst_1
/*      */     //   245: iadd
/*      */     //   246: invokeinterface append : (Ljava/lang/CharSequence;II)Lcom/vladsch/flexmark/util/sequence/builder/ISequenceBuilder;
/*      */     //   251: pop
/*      */     //   252: return
/*      */     //   253: iload_3
/*      */     //   254: bipush #32
/*      */     //   256: if_icmpne -> 368
/*      */     //   259: aload_0
/*      */     //   260: getfield preFormattedNesting : I
/*      */     //   263: ifne -> 342
/*      */     //   266: aload_0
/*      */     //   267: getstatic com/vladsch/flexmark/util/sequence/LineAppendableImpl.F_TRIM_LEADING_WHITESPACE : I
/*      */     //   270: invokespecial any : (I)Z
/*      */     //   273: ifeq -> 295
/*      */     //   276: aload_0
/*      */     //   277: getfield appendable : Lcom/vladsch/flexmark/util/sequence/builder/ISequenceBuilder;
/*      */     //   280: invokeinterface length : ()I
/*      */     //   285: ifeq -> 362
/*      */     //   288: aload_0
/*      */     //   289: getfield allWhitespace : Z
/*      */     //   292: ifne -> 362
/*      */     //   295: aload_0
/*      */     //   296: getstatic com/vladsch/flexmark/util/sequence/LineAppendableImpl.F_COLLAPSE_WHITESPACE : I
/*      */     //   299: invokespecial any : (I)Z
/*      */     //   302: ifeq -> 327
/*      */     //   305: aload_0
/*      */     //   306: getfield lastWasWhitespace : Z
/*      */     //   309: ifne -> 362
/*      */     //   312: aload_0
/*      */     //   313: getfield appendable : Lcom/vladsch/flexmark/util/sequence/builder/ISequenceBuilder;
/*      */     //   316: bipush #32
/*      */     //   318: invokeinterface append : (C)Lcom/vladsch/flexmark/util/sequence/builder/ISequenceBuilder;
/*      */     //   323: pop
/*      */     //   324: goto -> 362
/*      */     //   327: aload_0
/*      */     //   328: getfield appendable : Lcom/vladsch/flexmark/util/sequence/builder/ISequenceBuilder;
/*      */     //   331: bipush #32
/*      */     //   333: invokeinterface append : (C)Lcom/vladsch/flexmark/util/sequence/builder/ISequenceBuilder;
/*      */     //   338: pop
/*      */     //   339: goto -> 362
/*      */     //   342: aload_0
/*      */     //   343: getfield appendable : Lcom/vladsch/flexmark/util/sequence/builder/ISequenceBuilder;
/*      */     //   346: aload_1
/*      */     //   347: iload_2
/*      */     //   348: dup
/*      */     //   349: iconst_1
/*      */     //   350: iadd
/*      */     //   351: invokeinterface subSequence : (II)Ljava/lang/CharSequence;
/*      */     //   356: invokeinterface append : (Ljava/lang/CharSequence;)Lcom/vladsch/flexmark/util/sequence/builder/ISequenceBuilder;
/*      */     //   361: pop
/*      */     //   362: aload_0
/*      */     //   363: iconst_1
/*      */     //   364: putfield lastWasWhitespace : Z
/*      */     //   367: return
/*      */     //   368: aload_0
/*      */     //   369: iconst_0
/*      */     //   370: putfield allWhitespace : Z
/*      */     //   373: aload_0
/*      */     //   374: iconst_0
/*      */     //   375: putfield lastWasWhitespace : Z
/*      */     //   378: aload_0
/*      */     //   379: getfield appendable : Lcom/vladsch/flexmark/util/sequence/builder/ISequenceBuilder;
/*      */     //   382: aload_1
/*      */     //   383: iload_2
/*      */     //   384: dup
/*      */     //   385: iconst_1
/*      */     //   386: iadd
/*      */     //   387: invokeinterface append : (Ljava/lang/CharSequence;II)Lcom/vladsch/flexmark/util/sequence/builder/ISequenceBuilder;
/*      */     //   392: pop
/*      */     //   393: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #465	-> 0
/*      */     //   #467	-> 8
/*      */     //   #468	-> 15
/*      */     //   #469	-> 21
/*      */     //   #471	-> 29
/*      */     //   #472	-> 36
/*      */     //   #473	-> 41
/*      */     //   #476	-> 48
/*      */     //   #477	-> 65
/*      */     //   #480	-> 77
/*      */     //   #481	-> 83
/*      */     //   #482	-> 88
/*      */     //   #483	-> 96
/*      */     //   #485	-> 103
/*      */     //   #488	-> 110
/*      */     //   #489	-> 121
/*      */     //   #492	-> 140
/*      */     //   #493	-> 144
/*      */     //   #494	-> 145
/*      */     //   #496	-> 149
/*      */     //   #497	-> 155
/*      */     //   #498	-> 172
/*      */     //   #499	-> 179
/*      */     //   #500	-> 191
/*      */     //   #503	-> 197
/*      */     //   #504	-> 207
/*      */     //   #505	-> 217
/*      */     //   #506	-> 223
/*      */     //   #507	-> 236
/*      */     //   #508	-> 237
/*      */     //   #512	-> 253
/*      */     //   #513	-> 259
/*      */     //   #514	-> 266
/*      */     //   #515	-> 295
/*      */     //   #516	-> 305
/*      */     //   #517	-> 312
/*      */     //   #520	-> 327
/*      */     //   #524	-> 342
/*      */     //   #526	-> 362
/*      */     //   #528	-> 368
/*      */     //   #529	-> 373
/*      */     //   #530	-> 378
/*      */     //   #535	-> 393
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
/*      */   private void appendImpl(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/*  538 */     paramInt1 = paramInt1;
/*  539 */     while (paramInt1 < paramInt2) {
/*  540 */       appendImpl(paramCharSequence, paramInt1++);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public LineAppendable append(CharSequence paramCharSequence) {
/*  547 */     if (paramCharSequence.length() > 0) {
/*  548 */       appendImpl(paramCharSequence, 0, paramCharSequence.length());
/*      */     } else {
/*  550 */       this.appendable.append(paramCharSequence);
/*      */     } 
/*  552 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public ISequenceBuilder<?, ?> getBuilder() {
/*  558 */     return this.appendable.getBuilder();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public LineAppendable append(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/*  564 */     if (paramInt1 < paramInt2) {
/*  565 */       appendImpl(paramCharSequence, paramInt1, paramInt2);
/*      */     }
/*  567 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public LineAppendable append(char paramChar) {
/*  573 */     appendImpl(Character.toString(paramChar), 0);
/*  574 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public LineAppendable append(char paramChar, int paramInt) {
/*  579 */     append(RepeatedSequence.repeatOf(paramChar, paramInt));
/*  580 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public LineAppendable repeat(CharSequence paramCharSequence, int paramInt) {
/*  585 */     append(RepeatedSequence.repeatOf(paramCharSequence, paramInt));
/*  586 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public LineAppendable repeat(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
/*  591 */     append(RepeatedSequence.repeatOf(paramCharSequence.subSequence(paramInt1, paramInt2), paramInt3));
/*  592 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public LineAppendable line() {
/*  598 */     if (this.preFormattedNesting > 0 || this.appendable.length() != 0) {
/*  599 */       appendImpl("\n", 0);
/*      */     } else {
/*  601 */       CharSequence charSequence = this.prefix;
/*  602 */       boolean bool = !this.indentsOnFirstEol.isEmpty() ? true : false;
/*      */       
/*  604 */       rawIndentsOnFirstEol();
/*      */       
/*  606 */       if (bool || (charSequence.length() > 0 && this.prefix.length() == 0))
/*      */       {
/*      */ 
/*      */         
/*  610 */         this.prefix = charSequence;
/*      */       }
/*      */     } 
/*  613 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public LineAppendable lineWithTrailingSpaces(int paramInt) {
/*  619 */     if (this.preFormattedNesting > 0 || this.appendable.length() != 0) {
/*  620 */       int i = this.options.toInt();
/*  621 */       this.options.andNotMask((F_TRIM_TRAILING_WHITESPACE | F_COLLAPSE_WHITESPACE));
/*  622 */       if (paramInt > 0) append(' ', paramInt); 
/*  623 */       appendImpl("\n", 0);
/*  624 */       this.options.setAll(i);
/*      */     } 
/*  626 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public LineAppendable lineIf(boolean paramBoolean) {
/*  632 */     if (paramBoolean) line(); 
/*  633 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public LineAppendable blankLine() {
/*  639 */     line();
/*  640 */     if ((!this.lines.isEmpty() && !isTrailingBlankLine()) || (this.lines.isEmpty() && !any(F_TRIM_LEADING_EOL))) appendEol(BasedSequence.EOL); 
/*  641 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public LineAppendable blankLineIf(boolean paramBoolean) {
/*  647 */     if (paramBoolean) blankLine(); 
/*  648 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public LineAppendable blankLine(int paramInt) {
/*  654 */     line();
/*  655 */     if (!any(F_TRIM_LEADING_EOL) || !this.lines.isEmpty()) {
/*  656 */       paramInt -= getTrailingBlankLines(this.lines.size());
/*  657 */       appendEol(paramInt);
/*      */     } 
/*  659 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public LineAppendable lineOnFirstText(boolean paramBoolean) {
/*  665 */     if (paramBoolean) { this.eolOnFirstText++; }
/*  666 */     else if (this.eolOnFirstText > 0) { this.eolOnFirstText--; }
/*  667 */      return this;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public LineAppendable removeIndentOnFirstEOL(Runnable paramRunnable) {
/*  673 */     this.indentsOnFirstEol.remove(paramRunnable);
/*  674 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public LineAppendable addIndentOnFirstEOL(Runnable paramRunnable) {
/*  680 */     this.indentsOnFirstEol.add(paramRunnable);
/*  681 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getLineCount() {
/*  686 */     return this.lines.size();
/*      */   }
/*      */ 
/*      */   
/*      */   public int getLineCountWithPending() {
/*  691 */     return (this.appendable.length() == 0) ? this.lines.size() : (this.lines.size() + 1);
/*      */   }
/*      */ 
/*      */   
/*      */   public int column() {
/*  696 */     return this.appendable.length();
/*      */   }
/*      */ 
/*      */   
/*      */   public LineInfo getLineInfo(int paramInt) {
/*      */     Pair<Range, CharSequence> pair;
/*  702 */     if (paramInt == this.lines.size()) {
/*  703 */       if (this.appendable.length() == 0) {
/*  704 */         return LineInfo.NULL;
/*      */       }
/*      */ 
/*      */       
/*      */       Range range;
/*      */       
/*  710 */       if ((range = (Range)(pair = getRangePrefixAfterEol()).getFirst()).isNull()) {
/*  711 */         return LineInfo.NULL;
/*      */       }
/*  713 */       return getLineRange(range.getStart(), range.getEnd(), (CharSequence)pair.getSecond());
/*      */     } 
/*      */ 
/*      */     
/*  717 */     return this.lines.get(pair);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public BasedSequence getLine(int paramInt) {
/*  723 */     return getLineInfo(paramInt).getLine();
/*      */   }
/*      */ 
/*      */   
/*      */   public int offset() {
/*  728 */     return (getLastLineInfo()).sumLength;
/*      */   }
/*      */ 
/*      */   
/*      */   public int offsetWithPending() {
/*  733 */     return offsetAfterEol();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isPendingSpace() {
/*  738 */     return (this.appendable.length() > 0 && this.lastWasWhitespace);
/*      */   }
/*      */ 
/*      */   
/*      */   public int getPendingSpace() {
/*  743 */     if (this.lastWasWhitespace && this.appendable.length() != 0) {
/*  744 */       return SequenceUtils.countTrailingSpaceTab(this.appendable.toSequence());
/*      */     }
/*  746 */     return 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getPendingEOL() {
/*  751 */     if (this.appendable.length() == 0)
/*      */     {
/*  753 */       return getTrailingBlankLines(this.lines.size()) + 1;
/*      */     }
/*  755 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isPreFormatted() {
/*  761 */     return (this.preFormattedNesting > 0);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public LineAppendable openPreFormatted(boolean paramBoolean) {
/*  767 */     if (this.preFormattedNesting == 0 && 
/*  768 */       this.preFormattedFirstLine != this.lines.size()) {
/*  769 */       this.preFormattedFirstLine = this.lines.size();
/*  770 */       this.preFormattedFirstLineOffset = this.appendable.length();
/*      */     } 
/*      */ 
/*      */     
/*  774 */     this.preFormattedNesting++;
/*  775 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public LineAppendable closePreFormatted() {
/*  781 */     if (this.preFormattedNesting <= 0) throw new IllegalStateException("closePreFormatted called with nesting == 0"); 
/*  782 */     this.preFormattedNesting--;
/*      */     
/*  784 */     if (this.preFormattedNesting == 0 && !endsWithEOL()) {
/*      */       
/*  786 */       this.preFormattedLastLine = this.lines.size();
/*  787 */       this.preFormattedLastLineOffset = this.appendable.length();
/*      */     } 
/*  789 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public String toString() {
/*  794 */     StringBuilder stringBuilder = new StringBuilder();
/*      */     try {
/*  796 */       appendToNoLine(stringBuilder, true, 2147483647, 2147483647, 0, 2147483647);
/*  797 */     } catch (IOException iOException) {}
/*      */ 
/*      */     
/*  800 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString(int paramInt1, int paramInt2, boolean paramBoolean) {
/*  806 */     StringBuilder stringBuilder = new StringBuilder();
/*      */     try {
/*  808 */       appendTo(stringBuilder, paramBoolean, paramInt1, paramInt2, 0, 2147483647);
/*  809 */     } catch (IOException iOException) {}
/*      */ 
/*      */     
/*  812 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public CharSequence toSequence(int paramInt1, int paramInt2, boolean paramBoolean) {
/*  818 */     ISequenceBuilder<?, ?> iSequenceBuilder = getBuilder();
/*      */     try {
/*  820 */       appendTo(iSequenceBuilder, paramBoolean, paramInt1, paramInt2, 0, 2147483647);
/*  821 */     } catch (IOException iOException) {}
/*      */ 
/*      */     
/*  824 */     return iSequenceBuilder.toSequence();
/*      */   }
/*      */ 
/*      */   
/*      */   public <T extends Appendable> T appendTo(T paramT, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  829 */     line();
/*  830 */     return appendToNoLine(paramT, paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
/*      */   }
/*      */   
/*      */   public <T extends Appendable> T appendToNoLine(T paramT, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  834 */     boolean bool = (paramInt2 >= 0) ? true : false;
/*  835 */     paramInt1 = Math.max(0, paramInt1);
/*  836 */     paramInt2 = Math.max(0, paramInt2);
/*      */     
/*  838 */     int i = this.lines.size();
/*  839 */     paramInt4 = Utils.min(getLineCountWithPending(), new int[] { paramInt4 });
/*  840 */     int j = lastNonBlankLine(paramInt4);
/*  841 */     byte b = 0;
/*      */     
/*  843 */     for (paramInt3 = paramInt3; paramInt3 < paramInt4; paramInt3++) {
/*  844 */       LineInfo lineInfo = getLineInfo(paramInt3);
/*  845 */       boolean bool1 = (paramInt3 < i) ? true : false;
/*      */       
/*  847 */       if (lineInfo.textLength == 0 && !lineInfo.isPreformatted()) {
/*  848 */         if (paramInt3 > j) {
/*      */           
/*  850 */           if (b < paramInt2) {
/*  851 */             b++;
/*  852 */             if (paramBoolean) paramT.append(isTrimTrailingWhitespace() ? SequenceUtils.<CharSequence>trimEnd(lineInfo.getPrefix()) : lineInfo.getPrefix()); 
/*  853 */             if (bool1 && (bool || b != paramInt2)) {
/*  854 */               paramT.append('\n');
/*      */             }
/*      */           }
/*      */         
/*  858 */         } else if (b < paramInt1) {
/*  859 */           b++;
/*  860 */           if (paramBoolean) paramT.append(isTrimTrailingWhitespace() ? SequenceUtils.<CharSequence>trimEnd(lineInfo.getPrefix()) : lineInfo.getPrefix()); 
/*  861 */           if (bool1) paramT.append('\n');
/*      */         
/*      */         } 
/*      */       } else {
/*  865 */         b = 0;
/*  866 */         if (bool1 && (bool || paramInt3 < j || (lineInfo.isPreformatted() && lineInfo.getPreformatted() != LineInfo.Preformatted.LAST)))
/*  867 */         { if (paramBoolean) { paramT.append(lineInfo.lineSeq); }
/*  868 */           else { paramT.append(lineInfo.getText()); }
/*      */            }
/*  870 */         else if (paramBoolean) { paramT.append(lineInfo.getLineNoEOL()); }
/*  871 */         else { paramT.append(lineInfo.getText()); }
/*      */       
/*      */       } 
/*      */     } 
/*  875 */     return paramT;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public LineAppendable append(LineAppendable paramLineAppendable, int paramInt1, int paramInt2, boolean paramBoolean) {
/*  881 */     paramInt2 = Math.min(paramInt2, paramLineAppendable.getLineCountWithPending());
/*      */ 
/*      */     
/*  884 */     for (paramInt1 = Math.max(0, paramInt1); paramInt1 < paramInt2; paramInt1++) {
/*      */       LineInfo lineInfo;
/*  886 */       BasedSequence basedSequence1 = (lineInfo = paramLineAppendable.getLineInfo(paramInt1)).getTextNoEOL();
/*  887 */       BasedSequence basedSequence2 = paramBoolean ? lineInfo.getPrefix() : BasedSequence.NULL;
/*      */       
/*  889 */       CharSequence charSequence = (any(F_PREFIX_PRE_FORMATTED) || !lineInfo.isPreformatted() || lineInfo.getPreformatted() == LineInfo.Preformatted.FIRST) ? LineAppendable.combinedPrefix(this.prefix, basedSequence2) : basedSequence2;
/*      */       
/*  891 */       this.appendable.append(basedSequence1);
/*  892 */       this.allWhitespace = lineInfo.isBlankText();
/*  893 */       this.lastWasWhitespace = (lineInfo.textLength == 0 || CharPredicate.SPACE_TAB.test(basedSequence1.safeCharAt(lineInfo.textLength - 1)));
/*      */       
/*  895 */       if (paramInt1 < paramLineAppendable.getLineCount()) {
/*      */         
/*  897 */         this.appendable.append('\n');
/*  898 */         this.allWhitespace = lineInfo.isBlankText();
/*      */         
/*  900 */         int i = this.appendable.length();
/*  901 */         addLineRange(0, i - 1, charSequence);
/*      */       } else {
/*  903 */         this.prefix = charSequence;
/*      */       } 
/*      */     } 
/*  906 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int removeLinesRaw(int paramInt1, int paramInt2) {
/*  917 */     paramInt1 = Utils.minLimit(paramInt1, new int[] { 0 });
/*  918 */     int i = Utils.maxLimit(paramInt2, new int[] { getLineCountWithPending() });
/*      */     
/*  920 */     if (paramInt1 < i) {
/*  921 */       this.lines.subList(paramInt1, i).clear();
/*  922 */       this.modificationCount++;
/*      */ 
/*      */       
/*  925 */       return paramInt1;
/*      */     } 
/*      */     
/*  928 */     if (paramInt2 >= getLineCountWithPending() && this.appendable.length() > 0)
/*      */     {
/*  930 */       resetBuilder();
/*      */     }
/*      */     
/*  933 */     return this.lines.size();
/*      */   }
/*      */ 
/*      */   
/*      */   void recomputeLineInfo(int paramInt) {
/*  938 */     int i = this.lines.size();
/*      */ 
/*      */     
/*  941 */     if ((paramInt = Math.max(0, paramInt)) < i) {
/*  942 */       LineInfo lineInfo = (paramInt - 1 >= 0) ? this.lines.get(paramInt - 1) : LineInfo.NULL;
/*  943 */       for (paramInt = paramInt; paramInt < i; ) {
/*  944 */         LineInfo lineInfo1 = this.lines.get(paramInt);
/*  945 */         lineInfo = LineInfo.create(lineInfo, lineInfo1);
/*  946 */         this.lines.set(paramInt, lineInfo);
/*      */         
/*  948 */         if (lineInfo.needAggregateUpdate(lineInfo1)) {
/*      */           paramInt++;
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public LineAppendable removeLines(int paramInt1, int paramInt2) {
/*  956 */     paramInt1 = removeLinesRaw(paramInt1, paramInt2);
/*  957 */     recomputeLineInfo(paramInt1);
/*  958 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public LineAppendable removeExtraBlankLines(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  963 */     paramInt1 = Math.max(0, paramInt1);
/*  964 */     paramInt2 = Math.max(0, paramInt2);
/*      */     
/*  966 */     paramInt3 = Utils.min(paramInt4, new int[] { getLineCountWithPending() });
/*      */     
/*  968 */     paramInt4 = 0;
/*  969 */     paramInt2 = paramInt2;
/*  970 */     int i = getLineCountWithPending();
/*      */     
/*  972 */     for (paramInt3 = paramInt3; paramInt3-- > 0; ) {
/*      */       LineInfo lineInfo;
/*      */       
/*  975 */       if ((lineInfo = getLineInfo(paramInt3)).isBlankText() && !lineInfo.isPreformatted()) {
/*  976 */         if (paramInt4 >= paramInt2) {
/*      */           
/*  978 */           i = removeLinesRaw(paramInt3 + paramInt4, paramInt3 + paramInt4 + 1); continue;
/*      */         } 
/*  980 */         paramInt4++;
/*      */         continue;
/*      */       } 
/*  983 */       paramInt4 = 0;
/*  984 */       paramInt2 = paramInt1;
/*      */     } 
/*      */ 
/*      */     
/*  988 */     recomputeLineInfo(i);
/*  989 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setPrefixLength(int paramInt1, int paramInt2) {
/*  994 */     if (paramInt1 == this.lines.size() && this.appendable.length() > 0) {
/*  995 */       line();
/*      */     }
/*      */     
/*      */     LineInfo lineInfo;
/*  999 */     CharSequence charSequence = (lineInfo = this.lines.get(paramInt1)).lineSeq;
/*      */     
/* 1001 */     if (paramInt2 < 0 || paramInt2 > lineInfo.getTextEnd()) {
/* 1002 */       throw new IllegalArgumentException(String.format("prefixLength %d is out of valid range [0, %d) for the line", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(lineInfo.getTextEnd() + 1) }));
/*      */     }
/* 1004 */     if (paramInt2 != lineInfo.prefixLength) {
/* 1005 */       CharSequence charSequence1 = charSequence.subSequence(0, paramInt2);
/* 1006 */       LineInfo lineInfo1 = LineInfo.create(lineInfo.lineSeq, (paramInt1 == 0) ? LineInfo.NULL : this.lines
/*      */           
/* 1008 */           .get(paramInt1 - 1), charSequence1
/* 1009 */           .length(), lineInfo.prefixLength + lineInfo.textLength - paramInt2, lineInfo.length, 
/*      */ 
/*      */           
/* 1012 */           SequenceUtils.isBlank(charSequence1), 
/* 1013 */           SequenceUtils.isBlank(charSequence.subSequence(paramInt2, lineInfo.getTextEnd())), lineInfo
/* 1014 */           .getPreformatted());
/*      */       
/* 1016 */       this.lines.set(paramInt1, lineInfo1);
/* 1017 */       recomputeLineInfo(paramInt1 + 1);
/*      */     } 
/*      */   }
/*      */   
/*      */   private LineInfo createLineInfo(int paramInt, CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 1022 */     LineInfo lineInfo2 = (paramInt == 0) ? LineInfo.NULL : this.lines.get(paramInt - 1);
/* 1023 */     LineInfo lineInfo1 = (paramInt == this.lines.size()) ? LineInfo.NULL : this.lines.get(paramInt);
/* 1024 */     CharSequence charSequence = paramCharSequence2;
/*      */ 
/*      */     
/* 1027 */     if ((paramCharSequence2 = SequenceUtils.<CharSequence>trimmedEOL(paramCharSequence2)) == null) { paramCharSequence2 = "\n"; }
/* 1028 */     else { charSequence = charSequence.subSequence(0, charSequence.length() - paramCharSequence2.length()); }
/*      */     
/* 1030 */     if (charSequence.length() == 0) {
/* 1031 */       paramCharSequence1 = SequenceUtils.trimEnd(paramCharSequence1);
/*      */     }
/*      */     
/* 1034 */     assert !SequenceUtils.containsAny(charSequence, CharPredicate.ANY_EOL) : 
/* 1035 */       String.format("Line text should not contain any EOL, text: %s", new Object[] { SequenceUtils.toVisibleWhitespaceString(charSequence) });
/*      */     
/* 1037 */     paramCharSequence2 = this.appendable.getBuilder().append(paramCharSequence1).append(charSequence).append(paramCharSequence2).toSequence();
/*      */ 
/*      */ 
/*      */     
/* 1041 */     LineInfo.Preformatted preformatted = lineInfo1.isNotNull() ? lineInfo1.getPreformatted() : ((lineInfo2.isPreformatted() && lineInfo2.getPreformatted() != LineInfo.Preformatted.LAST) ? LineInfo.Preformatted.BODY : LineInfo.Preformatted.NONE);
/*      */ 
/*      */     
/* 1044 */     return LineInfo.create(paramCharSequence2, lineInfo2, paramCharSequence1
/*      */ 
/*      */         
/* 1047 */         .length(), charSequence
/* 1048 */         .length(), paramCharSequence2
/* 1049 */         .length(), 
/* 1050 */         SequenceUtils.isBlank(paramCharSequence1), 
/* 1051 */         SequenceUtils.isBlank(charSequence), preformatted);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLine(int paramInt, CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 1058 */     if (paramInt == this.lines.size() && this.appendable.length() > 0) {
/* 1059 */       line();
/*      */     }
/*      */     
/* 1062 */     this.lines.set(paramInt, createLineInfo(paramInt, paramCharSequence1, paramCharSequence2));
/* 1063 */     recomputeLineInfo(paramInt + 1);
/*      */   }
/*      */ 
/*      */   
/*      */   public void insertLine(int paramInt, CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 1068 */     this.lines.add(paramInt, createLineInfo(paramInt, paramCharSequence1, paramCharSequence2));
/* 1069 */     recomputeLineInfo(paramInt + 1);
/*      */   }
/*      */   
/*      */   int tailBlankLinesToRemove(int paramInt1, int paramInt2) {
/* 1073 */     return Utils.max(0, new int[] { getTrailingBlankLines(paramInt1) - Utils.max(0, new int[] { paramInt2 }) });
/*      */   }
/*      */   
/*      */   static class IndexedLineInfoProxy implements Indexed<LineInfo> {
/*      */     final LineAppendableImpl appendable;
/*      */     final int startLine;
/*      */     final int endLine;
/*      */     final int maxTrailingBlankLines;
/*      */     
/*      */     public IndexedLineInfoProxy(LineAppendableImpl param1LineAppendableImpl, int param1Int1, int param1Int2, int param1Int3) {
/* 1083 */       this.appendable = param1LineAppendableImpl;
/* 1084 */       this.startLine = param1Int2;
/* 1085 */       this.endLine = Math.min(param1Int3, param1LineAppendableImpl.getLineCountWithPending());
/* 1086 */       this.maxTrailingBlankLines = param1Int1;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public LineInfo get(int param1Int) {
/* 1092 */       if (param1Int + this.startLine >= this.endLine) {
/* 1093 */         throw new IndexOutOfBoundsException(String.format("index %d is out of valid range [%d, %d)", new Object[] { Integer.valueOf(param1Int), Integer.valueOf(this.startLine), Integer.valueOf(this.endLine) }));
/*      */       }
/* 1095 */       return this.appendable.getLineInfo(param1Int + this.startLine);
/*      */     }
/*      */ 
/*      */     
/*      */     public void set(int param1Int, LineInfo param1LineInfo) {
/* 1100 */       if (param1Int + this.startLine >= this.endLine) {
/* 1101 */         throw new IndexOutOfBoundsException(String.format("index %d is out of valid range [%d, %d)", new Object[] { Integer.valueOf(param1Int), Integer.valueOf(this.startLine), Integer.valueOf(this.endLine) }));
/*      */       }
/* 1103 */       this.appendable.lines.set(this.startLine + param1Int, param1LineInfo);
/* 1104 */       this.appendable.recomputeLineInfo(this.startLine + param1Int + 1);
/*      */     }
/*      */ 
/*      */     
/*      */     public void removeAt(int param1Int) {
/* 1109 */       if (param1Int + this.startLine >= this.endLine)
/* 1110 */         throw new IndexOutOfBoundsException(String.format("index %d is out of valid range [%d, %d)", new Object[] { Integer.valueOf(param1Int), Integer.valueOf(this.startLine), Integer.valueOf(this.endLine) })); 
/* 1111 */       this.appendable.removeLines(param1Int + this.startLine, param1Int + 1);
/*      */     }
/*      */ 
/*      */     
/*      */     public int size() {
/* 1116 */       int i = this.appendable.tailBlankLinesToRemove(this.endLine, this.maxTrailingBlankLines);
/* 1117 */       return Math.max(0, this.endLine - this.startLine - i);
/*      */     }
/*      */ 
/*      */     
/*      */     public int modificationCount() {
/* 1122 */       return this.appendable.modificationCount;
/*      */     }
/*      */   }
/*      */   
/*      */   static class IndexedLineProxy implements Indexed<BasedSequence> {
/*      */     final LineAppendableImpl.IndexedLineInfoProxy proxy;
/*      */     final boolean withPrefixes;
/*      */     
/*      */     public IndexedLineProxy(LineAppendableImpl.IndexedLineInfoProxy param1IndexedLineInfoProxy, boolean param1Boolean) {
/* 1131 */       this.proxy = param1IndexedLineInfoProxy;
/* 1132 */       this.withPrefixes = param1Boolean;
/*      */     }
/*      */ 
/*      */     
/*      */     public BasedSequence get(int param1Int) {
/* 1137 */       if (this.proxy.maxTrailingBlankLines == -1 && param1Int + 1 == this.proxy.size()) {
/* 1138 */         return this.withPrefixes ? this.proxy.get(param1Int).getLineNoEOL() : this.proxy.get(param1Int).getTextNoEOL();
/*      */       }
/* 1140 */       return this.withPrefixes ? this.proxy.get(param1Int).getLine() : this.proxy.get(param1Int).getText();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void set(int param1Int, BasedSequence param1BasedSequence) {
/* 1146 */       if (this.withPrefixes) {
/* 1147 */         this.proxy.appendable.setLine(param1Int + this.proxy.startLine, BasedSequence.NULL, param1BasedSequence); return;
/*      */       } 
/* 1149 */       this.proxy.appendable.setLine(param1Int + this.proxy.startLine, this.proxy.appendable.getLineInfo(param1Int + this.proxy.startLine).getPrefix(), param1BasedSequence);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void removeAt(int param1Int) {
/* 1155 */       this.proxy.removeAt(param1Int);
/*      */     }
/*      */ 
/*      */     
/*      */     public int size() {
/* 1160 */       return this.proxy.size();
/*      */     }
/*      */ 
/*      */     
/*      */     public int modificationCount() {
/* 1165 */       return this.proxy.modificationCount();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   IndexedLineInfoProxy getIndexedLineInfoProxy(int paramInt1, int paramInt2, int paramInt3) {
/* 1171 */     return new IndexedLineInfoProxy(this, paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */   
/*      */   IndexedLineProxy getIndexedLineProxy(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
/* 1176 */     return new IndexedLineProxy(getIndexedLineInfoProxy(paramInt1, paramInt2, paramInt3), paramBoolean);
/*      */   }
/*      */ 
/*      */   
/*      */   public Iterator<LineInfo> iterator() {
/* 1181 */     return (Iterator<LineInfo>)new IndexedItemIterator(getIndexedLineInfoProxy(2147483647, 0, getLineCount()));
/*      */   }
/*      */ 
/*      */   
/*      */   public Iterable<BasedSequence> getLines(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
/* 1186 */     return (Iterable<BasedSequence>)new IndexedItemIterable(getIndexedLineProxy(paramInt1, paramInt2, paramInt3, paramBoolean));
/*      */   }
/*      */ 
/*      */   
/*      */   public Iterable<LineInfo> getLinesInfo(int paramInt1, int paramInt2, int paramInt3) {
/* 1191 */     return (Iterable<LineInfo>)new IndexedItemIterable(getIndexedLineInfoProxy(paramInt1, paramInt2, paramInt3));
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\LineAppendableImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */