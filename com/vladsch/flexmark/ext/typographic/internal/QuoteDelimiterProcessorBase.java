/*     */ package com.vladsch.flexmark.ext.typographic.internal;
/*     */ 
/*     */ import com.vladsch.flexmark.ext.typographic.TypographicQuotes;
/*     */ import com.vladsch.flexmark.ext.typographic.TypographicSmarts;
/*     */ import com.vladsch.flexmark.parser.InlineParser;
/*     */ import com.vladsch.flexmark.parser.core.delimiter.Delimiter;
/*     */ import com.vladsch.flexmark.parser.delimiter.DelimiterProcessor;
/*     */ import com.vladsch.flexmark.parser.delimiter.DelimiterRun;
/*     */ import com.vladsch.flexmark.util.ast.DelimitedNode;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ 
/*     */ public class QuoteDelimiterProcessorBase
/*     */   implements DelimiterProcessor
/*     */ {
/*     */   protected final TypographicOptions myOptions;
/*     */   protected final char myOpenDelimiter;
/*     */   protected final char myCloseDelimiter;
/*     */   
/*     */   public QuoteDelimiterProcessorBase(TypographicOptions paramTypographicOptions, char paramChar1, char paramChar2, String paramString1, String paramString2, String paramString3) {
/*  21 */     this.myOptions = paramTypographicOptions;
/*  22 */     this.myOpenDelimiter = paramChar1;
/*  23 */     this.myCloseDelimiter = paramChar2;
/*  24 */     this.myOpener = paramString1;
/*  25 */     this.myCloser = paramString2;
/*  26 */     this.myUnmatched = paramString3;
/*     */   }
/*     */   protected final String myOpener; protected final String myCloser; protected final String myUnmatched;
/*     */   
/*     */   public final char getOpeningCharacter() {
/*  31 */     return this.myOpenDelimiter;
/*     */   }
/*     */ 
/*     */   
/*     */   public final char getClosingCharacter() {
/*  36 */     return this.myCloseDelimiter;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMinLength() {
/*  41 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canBeOpener(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6) {
/*  46 */     return paramBoolean1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canBeCloser(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6) {
/*  51 */     return paramBoolean2;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean skipNonOpenerCloser() {
/*  56 */     return false;
/*     */   }
/*     */   
/*     */   protected boolean havePreviousOpener(DelimiterRun paramDelimiterRun) {
/*  60 */     paramDelimiterRun = paramDelimiterRun.getPrevious();
/*  61 */     int i = getMinLength();
/*  62 */     while (paramDelimiterRun != null) {
/*  63 */       if (paramDelimiterRun.getDelimiterChar() == this.myOpenDelimiter) {
/*  64 */         return canOpen(paramDelimiterRun, i);
/*     */       }
/*     */       
/*  67 */       paramDelimiterRun = paramDelimiterRun.getPrevious();
/*     */     } 
/*  69 */     return false;
/*     */   }
/*     */   
/*     */   protected boolean haveNextCloser(DelimiterRun paramDelimiterRun) {
/*  73 */     paramDelimiterRun = paramDelimiterRun.getNext();
/*  74 */     int i = getMinLength();
/*  75 */     while (paramDelimiterRun != null) {
/*  76 */       if (paramDelimiterRun.getDelimiterChar() == this.myCloseDelimiter) {
/*  77 */         return canClose(paramDelimiterRun, i);
/*     */       }
/*  79 */       paramDelimiterRun = paramDelimiterRun.getNext();
/*     */     } 
/*  81 */     return false;
/*     */   }
/*     */   
/*     */   protected boolean canClose(DelimiterRun paramDelimiterRun, int paramInt) {
/*  85 */     if (paramDelimiterRun.canClose()) {
/*  86 */       BasedSequence basedSequence = paramDelimiterRun.getNode().getChars();
/*  87 */       if ((paramDelimiterRun.getNext() != null && basedSequence.isContinuationOf(paramDelimiterRun.getNext().getNode().getChars())) || basedSequence.getEndOffset() >= basedSequence.getBaseSequence().length() || isAllowed((CharSequence)basedSequence.getBaseSequence(), basedSequence.getEndOffset() + paramInt - 1)) {
/*  88 */         return true;
/*     */       }
/*     */     } 
/*  91 */     return false;
/*     */   }
/*     */   
/*     */   protected boolean canOpen(DelimiterRun paramDelimiterRun, int paramInt) {
/*  95 */     if (paramDelimiterRun.canOpen()) {
/*  96 */       BasedSequence basedSequence = paramDelimiterRun.getNode().getChars();
/*  97 */       if ((paramDelimiterRun.getPrevious() != null && paramDelimiterRun.getPrevious().getNode().getChars().isContinuationOf(basedSequence)) || basedSequence.getStartOffset() == 0 || isAllowed((CharSequence)basedSequence.getBaseSequence(), basedSequence.getStartOffset() - paramInt)) {
/*  98 */         return true;
/*     */       }
/*     */     } 
/* 101 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean isAllowed(char paramChar) {
/* 106 */     return !Character.isLetterOrDigit(paramChar);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean isAllowed(CharSequence paramCharSequence, int paramInt) {
/* 111 */     return (paramInt < 0 || paramInt >= paramCharSequence.length() || !Character.isLetterOrDigit(paramCharSequence.charAt(paramInt)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDelimiterUse(DelimiterRun paramDelimiterRun1, DelimiterRun paramDelimiterRun2) {
/* 125 */     int i = getMinLength();
/* 126 */     if (paramDelimiterRun1.length() >= i && paramDelimiterRun2.length() >= i && 
/* 127 */       canOpen(paramDelimiterRun1, i) && canClose(paramDelimiterRun2, i)) return i;
/*     */     
/* 129 */     return 0;
/*     */   }
/*     */   
/*     */   public Node unmatchedDelimiterNode(InlineParser paramInlineParser, DelimiterRun paramDelimiterRun) {
/*     */     BasedSequence basedSequence;
/* 134 */     if (this.myUnmatched != null && this.myOptions.typographicSmarts && (
/*     */       
/* 136 */       basedSequence = paramDelimiterRun.getNode().getChars()).length() == 1) {
/* 137 */       return (Node)new TypographicSmarts(basedSequence, this.myUnmatched);
/*     */     }
/*     */     
/* 140 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void process(Delimiter paramDelimiter1, Delimiter paramDelimiter2, int paramInt) {
/*     */     TypographicQuotes typographicQuotes;
/* 147 */     (typographicQuotes = new TypographicQuotes(paramDelimiter1.getTailChars(paramInt), BasedSequence.NULL, paramDelimiter2.getLeadChars(paramInt))).setTypographicOpening(this.myOpener);
/* 148 */     typographicQuotes.setTypographicClosing(this.myCloser);
/* 149 */     paramDelimiter1.moveNodesBetweenDelimitersTo((DelimitedNode)typographicQuotes, paramDelimiter2);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\typographic\internal\QuoteDelimiterProcessorBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */