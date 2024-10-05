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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class SubSequence
/*     */   extends BasedSequenceImpl
/*     */ {
/*     */   private final CharSequence charSequence;
/*     */   private final SubSequence baseSeq;
/*     */   private final int startOffset;
/*     */   private final int endOffset;
/*     */   
/*     */   public final SubSequence getBaseSequence() {
/*  24 */     return this.baseSeq;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getOptionFlags() {
/*  29 */     return (this.charSequence instanceof BasedOptionsHolder) ? ((BasedOptionsHolder)this.charSequence).getOptionFlags() : 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean allOptions(int paramInt) {
/*  34 */     return (this.charSequence instanceof BasedOptionsHolder && ((BasedOptionsHolder)this.charSequence).allOptions(paramInt));
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean anyOptions(int paramInt) {
/*  39 */     return (this.charSequence instanceof BasedOptionsHolder && ((BasedOptionsHolder)this.charSequence).anyOptions(paramInt));
/*     */   }
/*     */ 
/*     */   
/*     */   public final <T> T getOption(DataKeyBase<T> paramDataKeyBase) {
/*  44 */     return (T)((this.charSequence instanceof BasedOptionsHolder) ? (Object)((BasedOptionsHolder)this.charSequence).getOption(paramDataKeyBase) : paramDataKeyBase.get(null));
/*     */   }
/*     */ 
/*     */   
/*     */   public final DataHolder getOptions() {
/*  49 */     return (this.charSequence instanceof BasedOptionsHolder) ? ((BasedOptionsHolder)this.charSequence).getOptions() : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final CharSequence getBase() {
/*  55 */     return this.charSequence;
/*     */   }
/*     */   
/*     */   public final int getStartOffset() {
/*  59 */     return this.startOffset;
/*     */   }
/*     */   
/*     */   public final int getEndOffset() {
/*  63 */     return this.endOffset;
/*     */   }
/*     */   
/*     */   private SubSequence(CharSequence paramCharSequence) {
/*  67 */     super((paramCharSequence instanceof String) ? paramCharSequence.hashCode() : 0);
/*  68 */     assert !(paramCharSequence instanceof BasedSequence);
/*  69 */     this.baseSeq = this;
/*  70 */     this.charSequence = paramCharSequence;
/*  71 */     this.startOffset = 0;
/*  72 */     this.endOffset = paramCharSequence.length();
/*     */   }
/*     */ 
/*     */   
/*     */   private SubSequence(SubSequence paramSubSequence, int paramInt1, int paramInt2) {
/*  77 */     super(0);
/*     */     
/*  79 */     assert paramInt1 >= 0 && paramInt2 >= paramInt1 && paramInt2 <= paramSubSequence.length() : String.format("SubSequence must have startIndex >= 0 && endIndex >= startIndex && endIndex <= %d, got startIndex:%d, endIndex: %d", new Object[] { Integer.valueOf(paramSubSequence.length()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
/*     */     
/*  81 */     this.baseSeq = paramSubSequence;
/*  82 */     this.charSequence = paramSubSequence.charSequence;
/*  83 */     this.startOffset = paramInt1;
/*  84 */     this.endOffset = paramInt2;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void addSegments(IBasedSegmentBuilder<?> paramIBasedSegmentBuilder) {
/*  89 */     assert paramIBasedSegmentBuilder.getBaseSequence() == this.baseSeq || paramIBasedSegmentBuilder.getBaseSequence().equals(this.baseSeq);
/*     */     
/*  91 */     paramIBasedSegmentBuilder.append(this.startOffset, this.endOffset);
/*     */   }
/*     */ 
/*     */   
/*     */   public final int length() {
/*  96 */     return this.endOffset - this.startOffset;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Range getSourceRange() {
/* 102 */     return Range.of(this.startOffset, this.endOffset);
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getIndexOffset(int paramInt) {
/* 107 */     SequenceUtils.validateIndexInclusiveEnd(paramInt, length());
/* 108 */     return this.startOffset + paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public final char charAt(int paramInt) {
/* 113 */     SequenceUtils.validateIndex(paramInt, length());
/*     */ 
/*     */     
/* 116 */     return ((paramInt = this.charSequence.charAt(paramInt + this.startOffset)) == 0) ? '�' : paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final SubSequence subSequence(int paramInt1, int paramInt2) {
/* 122 */     SequenceUtils.validateStartEnd(paramInt1, paramInt2, length());
/* 123 */     return baseSubSequence(this.startOffset + paramInt1, this.startOffset + paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final SubSequence baseSubSequence(int paramInt1, int paramInt2) {
/* 129 */     SequenceUtils.validateStartEnd(paramInt1, paramInt2, this.baseSeq.length());
/* 130 */     return (paramInt1 == this.startOffset && paramInt2 == this.endOffset) ? this : ((this.baseSeq != this) ? this.baseSeq.baseSubSequence(paramInt1, paramInt2) : new SubSequence(this, paramInt1, paramInt2));
/*     */   }
/*     */   
/*     */   static BasedSequence create(CharSequence paramCharSequence) {
/* 134 */     if (paramCharSequence == null) return BasedSequence.NULL; 
/* 135 */     if (paramCharSequence instanceof BasedSequence) return (BasedSequence)paramCharSequence; 
/* 136 */     return new SubSequence(paramCharSequence);
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public static BasedSequence of(CharSequence paramCharSequence) {
/* 141 */     return BasedSequence.of(paramCharSequence);
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public static BasedSequence of(CharSequence paramCharSequence, int paramInt) {
/* 146 */     return BasedSequence.of(paramCharSequence).subSequence(paramInt, (paramCharSequence == null) ? 0 : paramCharSequence.length());
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public static BasedSequence of(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/* 151 */     return BasedSequence.of(paramCharSequence).subSequence(paramInt1, paramInt2);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\SubSequence.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */