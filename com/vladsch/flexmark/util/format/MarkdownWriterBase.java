/*     */ package com.vladsch.flexmark.util.format;
/*     */ 
/*     */ import com.vladsch.flexmark.util.misc.BitFieldSet;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.LineAppendable;
/*     */ import com.vladsch.flexmark.util.sequence.LineAppendableImpl;
/*     */ import com.vladsch.flexmark.util.sequence.LineInfo;
/*     */ import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class MarkdownWriterBase<T extends MarkdownWriterBase<T, N, C>, N, C extends NodeContext<N, C>>
/*     */   implements LineAppendable
/*     */ {
/*     */   protected final LineAppendableImpl appendable;
/*     */   protected C context;
/*     */   
/*     */   public MarkdownWriterBase() {
/*  21 */     this(0);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  26 */     return this.appendable.toString();
/*     */   }
/*     */   
/*     */   public MarkdownWriterBase(int paramInt) {
/*  30 */     this(null, paramInt);
/*     */   }
/*     */   
/*     */   public MarkdownWriterBase(Appendable paramAppendable, int paramInt) {
/*  34 */     this.appendable = new LineAppendableImpl(paramAppendable, paramInt);
/*  35 */     this.appendable.setOptions(this.appendable.getOptions() | LineAppendable.F_PREFIX_PRE_FORMATTED);
/*     */   }
/*     */   
/*     */   public void setContext(C paramC) {
/*  39 */     this.context = paramC;
/*     */   }
/*     */   
/*     */   public C getContext() {
/*  43 */     return this.context;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T tailBlankLine() {
/*  49 */     return tailBlankLine(1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T tailBlankLine(int paramInt) {
/*  56 */     BasedSequence basedSequence1 = this.appendable.getPrefix();
/*     */     BasedSequence basedSequence2;
/*  58 */     if (!(basedSequence2 = lastBlockQuoteChildPrefix(basedSequence1)).equals(basedSequence1)) {
/*     */       
/*  60 */       this.appendable.setPrefix((CharSequence)basedSequence2, false);
/*  61 */       this.appendable.blankLine(paramInt);
/*  62 */       this.appendable.setPrefix((CharSequence)basedSequence1, false);
/*     */     } else {
/*  64 */       this.appendable.blankLine(paramInt);
/*     */     } 
/*     */     
/*  67 */     return (T)this;
/*     */   }
/*     */   
/*     */   public Iterator<LineInfo> iterator() {
/*  71 */     return this.appendable.iterator();
/*  72 */   } public Iterable<BasedSequence> getLines(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) { return this.appendable.getLines(paramInt1, paramInt2, paramInt3, true); }
/*  73 */   public Iterable<LineInfo> getLinesInfo(int paramInt1, int paramInt2, int paramInt3) { return this.appendable.getLinesInfo(paramInt1, paramInt2, paramInt3); }
/*  74 */   public void setPrefixLength(int paramInt1, int paramInt2) { this.appendable.setPrefixLength(paramInt1, paramInt2); }
/*  75 */   public void insertLine(int paramInt, CharSequence paramCharSequence1, CharSequence paramCharSequence2) { this.appendable.insertLine(paramInt, paramCharSequence1, paramCharSequence2); }
/*  76 */   public void setLine(int paramInt, CharSequence paramCharSequence1, CharSequence paramCharSequence2) { this.appendable.setLine(paramInt, paramCharSequence1, paramCharSequence2); }
/*  77 */   public <T extends Appendable> T appendTo(T paramT, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) { return (T)this.appendable.appendTo((Appendable)paramT, paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4); }
/*  78 */   public boolean endsWithEOL() { return this.appendable.endsWithEOL(); }
/*  79 */   public boolean isPendingSpace() { return this.appendable.isPendingSpace(); }
/*  80 */   public boolean isPreFormatted() { return this.appendable.isPreFormatted(); }
/*  81 */   public int getTrailingBlankLines(int paramInt) { return this.appendable.getTrailingBlankLines(paramInt); }
/*  82 */   public int column() { return this.appendable.column(); }
/*  83 */   public int getLineCount() { return this.appendable.getLineCount(); }
/*  84 */   public int getLineCountWithPending() { return this.appendable.getLineCountWithPending(); }
/*  85 */   public int getOptions() { return this.appendable.getOptions(); }
/*  86 */   public int getPendingSpace() { return this.appendable.getPendingSpace(); }
/*  87 */   public int getPendingEOL() { return this.appendable.getPendingEOL(); }
/*  88 */   public int offset() { return this.appendable.offset(); }
/*  89 */   public int offsetWithPending() { return this.appendable.offsetWithPending(); }
/*  90 */   public int getAfterEolPrefixDelta() { return this.appendable.getAfterEolPrefixDelta(); }
/*  91 */   public ISequenceBuilder<?, ?> getBuilder() { return this.appendable.getBuilder(); }
/*  92 */   public BasedSequence getPrefix() { return this.appendable.getPrefix(); }
/*  93 */   public BasedSequence getBeforeEolPrefix() { return this.appendable.getBeforeEolPrefix(); }
/*  94 */   public LineInfo getLineInfo(int paramInt) { return this.appendable.getLineInfo(paramInt); }
/*  95 */   public BasedSequence getLine(int paramInt) { return this.appendable.getLine(paramInt); }
/*  96 */   public BasedSequence getIndentPrefix() { return this.appendable.getIndentPrefix(); }
/*  97 */   public CharSequence toSequence(int paramInt1, int paramInt2, boolean paramBoolean) { return this.appendable.toSequence(paramInt1, paramInt2, paramBoolean); }
/*  98 */   public String toString(int paramInt1, int paramInt2, boolean paramBoolean) { return this.appendable.toString(paramInt1, paramInt2, paramBoolean); }
/*  99 */   public BitFieldSet<LineAppendable.Options> getOptionSet() { return this.appendable.getOptionSet(); }
/* 100 */   public T removeExtraBlankLines(int paramInt1, int paramInt2, int paramInt3, int paramInt4) { this.appendable.removeExtraBlankLines(paramInt1, paramInt2, paramInt3, paramInt4); return (T)this; }
/* 101 */   public T removeLines(int paramInt1, int paramInt2) { this.appendable.removeLines(paramInt1, paramInt2); return (T)this; }
/* 102 */   public T pushOptions() { this.appendable.pushOptions(); return (T)this; }
/* 103 */   public T popOptions() { this.appendable.popOptions(); return (T)this; }
/* 104 */   public T changeOptions(int paramInt1, int paramInt2) { this.appendable.changeOptions(paramInt1, paramInt2); return (T)this; }
/* 105 */   public T addIndentOnFirstEOL(Runnable paramRunnable) { this.appendable.addIndentOnFirstEOL(paramRunnable); return (T)this; }
/* 106 */   public T addPrefix(CharSequence paramCharSequence) { this.appendable.addPrefix(paramCharSequence); return (T)this; }
/* 107 */   public T addPrefix(CharSequence paramCharSequence, boolean paramBoolean) { this.appendable.addPrefix(paramCharSequence, paramBoolean); return (T)this; }
/* 108 */   public T append(char paramChar) { this.appendable.append(paramChar); return (T)this; }
/* 109 */   public T append(CharSequence paramCharSequence) { this.appendable.append(paramCharSequence); return (T)this; }
/* 110 */   public T append(CharSequence paramCharSequence, int paramInt1, int paramInt2) { this.appendable.append(paramCharSequence, paramInt1, paramInt2); return (T)this; }
/* 111 */   public T append(LineAppendable paramLineAppendable, int paramInt1, int paramInt2, boolean paramBoolean) { this.appendable.append(paramLineAppendable, paramInt1, paramInt2, paramBoolean); return (T)this; }
/* 112 */   public T blankLine() { this.appendable.blankLine(); return (T)this; }
/* 113 */   public T blankLine(int paramInt) { this.appendable.blankLine(paramInt); return (T)this; }
/* 114 */   public T blankLineIf(boolean paramBoolean) { this.appendable.blankLineIf(paramBoolean); return (T)this; }
/* 115 */   public T closePreFormatted() { this.appendable.closePreFormatted(); return (T)this; }
/* 116 */   public T indent() { this.appendable.indent(); return (T)this; }
/* 117 */   public T line() { this.appendable.line(); return (T)this; }
/* 118 */   public T lineIf(boolean paramBoolean) { this.appendable.lineIf(paramBoolean); return (T)this; }
/* 119 */   public T lineOnFirstText(boolean paramBoolean) { this.appendable.lineOnFirstText(paramBoolean); return (T)this; }
/* 120 */   public T lineWithTrailingSpaces(int paramInt) { this.appendable.lineWithTrailingSpaces(paramInt); return (T)this; }
/* 121 */   public T openPreFormatted(boolean paramBoolean) { this.appendable.openPreFormatted(paramBoolean); return (T)this; }
/* 122 */   public T popPrefix() { this.appendable.popPrefix(); return (T)this; }
/* 123 */   public T popPrefix(boolean paramBoolean) { this.appendable.popPrefix(paramBoolean); return (T)this; }
/* 124 */   public T pushPrefix() { this.appendable.pushPrefix(); return (T)this; }
/* 125 */   public T removeIndentOnFirstEOL(Runnable paramRunnable) { this.appendable.removeIndentOnFirstEOL(paramRunnable); return (T)this; }
/* 126 */   public T append(char paramChar, int paramInt) { this.appendable.append(paramChar, paramInt); return (T)this; }
/* 127 */   public T setIndentPrefix(CharSequence paramCharSequence) { this.appendable.setIndentPrefix(paramCharSequence); return (T)this; }
/* 128 */   public T setOptions(int paramInt) { this.appendable.setOptions(paramInt); return (T)this; }
/* 129 */   public T setPrefix(CharSequence paramCharSequence) { this.appendable.setPrefix(paramCharSequence); return (T)this; }
/* 130 */   public T setPrefix(CharSequence paramCharSequence, boolean paramBoolean) { this.appendable.setPrefix(paramCharSequence, paramBoolean); return (T)this; }
/* 131 */   public T unIndent() { this.appendable.unIndent(); return (T)this; } public T unIndentNoEol() {
/* 132 */     this.appendable.unIndentNoEol(); return (T)this;
/*     */   }
/*     */   
/*     */   public abstract BasedSequence lastBlockQuoteChildPrefix(BasedSequence paramBasedSequence);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\format\MarkdownWriterBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */