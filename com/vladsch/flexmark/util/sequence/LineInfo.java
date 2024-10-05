/*     */ package com.vladsch.flexmark.util.sequence;
/*     */ 
/*     */ import com.vladsch.flexmark.util.misc.BitField;
/*     */ import com.vladsch.flexmark.util.misc.BitFieldSet;
/*     */ import com.vladsch.flexmark.util.misc.Utils;
/*     */ 
/*     */ 
/*     */ public final class LineInfo
/*     */ {
/*     */   public enum Flags
/*     */     implements BitField
/*     */   {
/*  13 */     PREFORMATTED(2),
/*  14 */     BLANK_PREFIX,
/*  15 */     BLANK_TEXT;
/*     */ 
/*     */     
/*     */     final int bits;
/*     */ 
/*     */     
/*     */     Flags(int param1Int1) {
/*  22 */       this.bits = param1Int1;
/*     */     }
/*     */     public final int getBits() {
/*  25 */       return this.bits;
/*     */     } }
/*     */   
/*     */   public enum Preformatted {
/*  29 */     NONE,
/*  30 */     FIRST,
/*  31 */     BODY,
/*  32 */     LAST;
/*     */     
/*     */     final int mask;
/*     */ 
/*     */     
/*     */     Preformatted() {
/*  38 */       this.mask = BitFieldSet.setBitField(0, LineInfo.Flags.PREFORMATTED, ordinal());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     static Preformatted get(int param1Int) {
/*  46 */       if ((param1Int = param1Int & LineInfo.F_PREFORMATTED) == FIRST.mask) return FIRST; 
/*  47 */       if (param1Int == BODY.mask) return BODY; 
/*  48 */       if (param1Int == LAST.mask) return LAST; 
/*  49 */       return NONE;
/*     */     }
/*     */   }
/*     */   
/*  53 */   public static final Flags BLANK_PREFIX = Flags.BLANK_PREFIX;
/*  54 */   public static final Flags BLANK_TEXT = Flags.BLANK_TEXT;
/*  55 */   public static final Flags PREFORMATTED = Flags.PREFORMATTED;
/*     */   
/*  57 */   public static final int F_PREFORMATTED = BitFieldSet.intMask(Flags.PREFORMATTED);
/*  58 */   public static final int F_BLANK_PREFIX = BitFieldSet.intMask(Flags.BLANK_PREFIX);
/*  59 */   public static final int F_BLANK_TEXT = BitFieldSet.intMask(Flags.BLANK_TEXT);
/*     */   
/*  61 */   public static final LineInfo NULL = new LineInfo(BasedSequence.NULL, -1, 0, 0, 0, 0, 0, 0, true, true, Preformatted.NONE);
/*     */   
/*     */   public final CharSequence lineSeq;
/*     */   public final int index;
/*     */   public final int prefixLength;
/*     */   public final int textLength;
/*     */   public final int length;
/*     */   public final int sumPrefixLength;
/*     */   public final int sumTextLength;
/*     */   public final int sumLength;
/*     */   public final int flags;
/*     */   
/*     */   private LineInfo(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean1, boolean paramBoolean2, Preformatted paramPreformatted) {
/*  74 */     assert paramInt2 + paramInt3 < paramInt4 : "Line must be terminated by an EOL";
/*  75 */     assert paramCharSequence.length() == paramInt4;
/*     */     
/*  77 */     this.lineSeq = paramCharSequence;
/*  78 */     this.index = paramInt1;
/*  79 */     this.prefixLength = paramInt2;
/*  80 */     this.textLength = paramInt3;
/*  81 */     this.length = paramInt4;
/*  82 */     this.sumPrefixLength = paramInt5 + paramInt2;
/*  83 */     this.sumTextLength = paramInt6 + paramInt3;
/*  84 */     this.sumLength = paramInt7 + paramInt4;
/*  85 */     this.flags = ((paramBoolean1 || paramInt2 == 0) ? F_BLANK_PREFIX : 0) | ((paramBoolean2 || paramInt3 == 0) ? F_BLANK_TEXT : 0) | paramPreformatted.ordinal();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean needAggregateUpdate(LineInfo paramLineInfo) {
/*  95 */     return (this.sumPrefixLength != paramLineInfo.sumPrefixLength || this.sumTextLength != paramLineInfo.sumTextLength || this.sumLength != paramLineInfo.sumLength);
/*     */   }
/*     */   
/*     */   public final boolean isNull() {
/*  99 */     return (this == NULL);
/*     */   }
/*     */   
/*     */   public final boolean isNotNull() {
/* 103 */     return (this != NULL);
/*     */   }
/*     */   
/*     */   public final boolean isBlankPrefix() {
/* 107 */     return BitFieldSet.any(this.flags, F_BLANK_PREFIX);
/*     */   }
/*     */   
/*     */   public final boolean isBlankText() {
/* 111 */     return BitFieldSet.any(this.flags, F_BLANK_TEXT);
/*     */   }
/*     */   
/*     */   public final boolean isPreformatted() {
/* 115 */     return BitFieldSet.any(this.flags, F_PREFORMATTED);
/*     */   }
/*     */ 
/*     */   
/*     */   public final Preformatted getPreformatted() {
/* 120 */     return Preformatted.get(this.flags);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isBlankTextAndPrefix() {
/* 129 */     return BitFieldSet.all(this.flags, (F_BLANK_PREFIX | F_BLANK_TEXT));
/*     */   }
/*     */   
/*     */   public final int getTextStart() {
/* 133 */     return this.prefixLength;
/*     */   }
/*     */   
/*     */   public final int getTextEnd() {
/* 137 */     return this.prefixLength + this.textLength;
/*     */   }
/*     */ 
/*     */   
/*     */   public final BasedSequence getLine() {
/* 142 */     return (this.lineSeq instanceof BasedSequence) ? (BasedSequence)this.lineSeq : BasedSequence.of(this.lineSeq);
/*     */   }
/*     */ 
/*     */   
/*     */   public final BasedSequence getPrefix() {
/* 147 */     return getLine().subSequence(0, this.prefixLength);
/*     */   }
/*     */ 
/*     */   
/*     */   public final BasedSequence getTextNoEOL() {
/* 152 */     return getLine().subSequence(this.prefixLength, this.prefixLength + this.textLength);
/*     */   }
/*     */ 
/*     */   
/*     */   public final BasedSequence getText() {
/* 157 */     return getLine().subSequence(this.prefixLength, this.length);
/*     */   }
/*     */ 
/*     */   
/*     */   public final BasedSequence getLineNoEOL() {
/* 162 */     return getLine().subSequence(0, this.prefixLength + this.textLength);
/*     */   }
/*     */ 
/*     */   
/*     */   public final BasedSequence getEOL() {
/* 167 */     return getLine().subSequence(this.prefixLength + this.textLength, this.length);
/*     */   }
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 172 */     return "LineInfo{i=" + this.index + ", pl=" + this.prefixLength + ", tl=" + this.textLength + ", l=" + this.length + ", sumPl=" + this.sumPrefixLength + ", sumTl=" + this.sumTextLength + ", sumL=" + this.sumLength + ((this.flags != 0) ? ("," + (
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 180 */       isBlankPrefix() ? " bp" : "") + (isBlankText() ? " bt" : "") + (isPreformatted() ? " p" : "")) : "") + ", '" + 
/* 181 */       Utils.escapeJavaString(this.lineSeq) + "'}";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static LineInfo create(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, Preformatted paramPreformatted) {
/* 187 */     return new LineInfo(paramCharSequence, 0, paramInt1, paramInt2, paramInt3, 0, 0, 0, paramBoolean1, paramBoolean2, paramPreformatted);
/*     */   }
/*     */ 
/*     */   
/*     */   public static LineInfo create(CharSequence paramCharSequence, LineInfo paramLineInfo, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, Preformatted paramPreformatted) {
/* 192 */     return new LineInfo(paramCharSequence, paramLineInfo.index + 1, paramInt1, paramInt2, paramInt3, paramLineInfo.sumPrefixLength, paramLineInfo.sumTextLength, paramLineInfo.sumLength, paramBoolean1, paramBoolean2, paramPreformatted);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static LineInfo create(LineInfo paramLineInfo1, LineInfo paramLineInfo2) {
/* 209 */     return new LineInfo(paramLineInfo2.lineSeq, paramLineInfo1.index + 1, paramLineInfo2.prefixLength, paramLineInfo2.textLength, paramLineInfo2.length, paramLineInfo1.sumPrefixLength, paramLineInfo1.sumTextLength, paramLineInfo1.sumLength, paramLineInfo2
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 218 */         .isBlankPrefix(), paramLineInfo2
/* 219 */         .isBlankText(), paramLineInfo2
/* 220 */         .getPreformatted());
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\LineInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */