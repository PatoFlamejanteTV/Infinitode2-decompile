/*     */ package com.vladsch.flexmark.util.sequence;
/*     */ 
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.data.DataKeyBase;
/*     */ import com.vladsch.flexmark.util.sequence.builder.IBasedSegmentBuilder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class PrefixedSubSequence
/*     */   extends BasedSequenceImpl
/*     */   implements ReplacedBasedSequence
/*     */ {
/*     */   private final CharSequence prefix;
/*     */   private final BasedSequence base;
/*     */   
/*     */   private PrefixedSubSequence(CharSequence paramCharSequence, BasedSequence paramBasedSequence, int paramInt1, int paramInt2) {
/*  19 */     super(0);
/*     */     
/*  21 */     this.prefix = paramCharSequence;
/*  22 */     this.base = paramBasedSequence.subSequence(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object getBase() {
/*  28 */     return this.base.getBase();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final BasedSequence getBaseSequence() {
/*  34 */     return this.base.getBaseSequence();
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getStartOffset() {
/*  39 */     return this.base.getStartOffset();
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getEndOffset() {
/*  44 */     return this.base.getEndOffset();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Range getSourceRange() {
/*  50 */     return this.base.getSourceRange();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final BasedSequence baseSubSequence(int paramInt1, int paramInt2) {
/*  56 */     return this.base.baseSubSequence(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getOptionFlags() {
/*  61 */     return getBaseSequence().getOptionFlags();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean allOptions(int paramInt) {
/*  66 */     return getBaseSequence().allOptions(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean anyOptions(int paramInt) {
/*  71 */     return getBaseSequence().anyOptions(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public final <T> T getOption(DataKeyBase<T> paramDataKeyBase) {
/*  76 */     return getBaseSequence().getOption(paramDataKeyBase);
/*     */   }
/*     */ 
/*     */   
/*     */   public final DataHolder getOptions() {
/*  81 */     return getBaseSequence().getOptions();
/*     */   }
/*     */ 
/*     */   
/*     */   public final int length() {
/*  86 */     return this.prefix.length() + this.base.length();
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getIndexOffset(int paramInt) {
/*  91 */     SequenceUtils.validateIndexInclusiveEnd(paramInt, length());
/*     */     
/*  93 */     if (paramInt < this.prefix.length())
/*     */     {
/*  95 */       return -1;
/*     */     }
/*  97 */     return this.base.getIndexOffset(paramInt - this.prefix.length());
/*     */   }
/*     */ 
/*     */   
/*     */   public final void addSegments(IBasedSegmentBuilder<?> paramIBasedSegmentBuilder) {
/* 102 */     if (this.prefix.length() != 0) {
/* 103 */       paramIBasedSegmentBuilder.append(this.base.getStartOffset(), this.base.getStartOffset());
/* 104 */       paramIBasedSegmentBuilder.append(this.prefix.toString());
/*     */     } 
/* 106 */     this.base.addSegments(paramIBasedSegmentBuilder);
/*     */   }
/*     */ 
/*     */   
/*     */   public final char charAt(int paramInt) {
/* 111 */     SequenceUtils.validateIndex(paramInt, length());
/*     */     
/* 113 */     int i = this.prefix.length();
/* 114 */     if (paramInt < i) {
/* 115 */       return this.prefix.charAt(paramInt);
/*     */     }
/* 117 */     return this.base.charAt(paramInt - i);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final BasedSequence subSequence(int paramInt1, int paramInt2) {
/* 124 */     SequenceUtils.validateStartEnd(paramInt1, paramInt2, length());
/*     */     
/* 126 */     int i = this.prefix.length();
/* 127 */     if (paramInt1 < i) {
/* 128 */       if (paramInt2 <= i)
/*     */       {
/* 130 */         return new PrefixedSubSequence(this.prefix.subSequence(paramInt1, paramInt2), this.base.subSequence(0, 0), 0, 0);
/*     */       }
/*     */       
/* 133 */       return new PrefixedSubSequence(this.prefix.subSequence(paramInt1, i), this.base, 0, paramInt2 - i);
/*     */     } 
/*     */ 
/*     */     
/* 137 */     return this.base.subSequence(paramInt1 - i, paramInt2 - i);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/*     */     StringBuilder stringBuilder;
/* 145 */     (stringBuilder = new StringBuilder()).append(this.prefix);
/* 146 */     this.base.appendTo(stringBuilder);
/* 147 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public static PrefixedSubSequence repeatOf(CharSequence paramCharSequence, int paramInt, BasedSequence paramBasedSequence) {
/* 151 */     return prefixOf(RepeatedSequence.repeatOf(paramCharSequence, paramInt).toString(), paramBasedSequence, 0, paramBasedSequence.length());
/*     */   }
/*     */   
/*     */   public static PrefixedSubSequence repeatOf(char paramChar, int paramInt, BasedSequence paramBasedSequence) {
/* 155 */     return prefixOf(RepeatedSequence.repeatOf(paramChar, paramInt), paramBasedSequence, 0, paramBasedSequence.length());
/*     */   }
/*     */   
/*     */   public static PrefixedSubSequence prefixOf(CharSequence paramCharSequence, BasedSequence paramBasedSequence) {
/* 159 */     return prefixOf(paramCharSequence, paramBasedSequence, 0, paramBasedSequence.length());
/*     */   }
/*     */   
/*     */   public static PrefixedSubSequence prefixOf(CharSequence paramCharSequence, BasedSequence paramBasedSequence, int paramInt) {
/* 163 */     return prefixOf(paramCharSequence, paramBasedSequence, paramInt, paramBasedSequence.length());
/*     */   }
/*     */   
/*     */   public static PrefixedSubSequence prefixOf(CharSequence paramCharSequence, BasedSequence paramBasedSequence, int paramInt1, int paramInt2) {
/* 167 */     return new PrefixedSubSequence(paramCharSequence, paramBasedSequence, paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public static PrefixedSubSequence of(CharSequence paramCharSequence, BasedSequence paramBasedSequence) {
/* 172 */     return prefixOf(paramCharSequence, paramBasedSequence);
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public static PrefixedSubSequence of(CharSequence paramCharSequence, BasedSequence paramBasedSequence, int paramInt) {
/* 177 */     return prefixOf(paramCharSequence, paramBasedSequence, paramInt);
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public static PrefixedSubSequence of(CharSequence paramCharSequence, BasedSequence paramBasedSequence, int paramInt1, int paramInt2) {
/* 182 */     return prefixOf(paramCharSequence, paramBasedSequence, paramInt1, paramInt2);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\PrefixedSubSequence.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */