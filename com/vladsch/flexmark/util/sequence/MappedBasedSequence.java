/*     */ package com.vladsch.flexmark.util.sequence;
/*     */ 
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.data.DataKeyBase;
/*     */ import com.vladsch.flexmark.util.sequence.builder.IBasedSegmentBuilder;
/*     */ import com.vladsch.flexmark.util.sequence.mappers.CharMapper;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class MappedBasedSequence
/*     */   extends BasedSequenceImpl
/*     */   implements MappedSequence<BasedSequence>, ReplacedBasedSequence
/*     */ {
/*     */   private final CharMapper mapper;
/*     */   private final BasedSequence baseSeq;
/*     */   
/*     */   private MappedBasedSequence(BasedSequence paramBasedSequence, CharMapper paramCharMapper) {
/*  18 */     super(0);
/*     */     
/*  20 */     this.baseSeq = paramBasedSequence;
/*  21 */     this.mapper = paramCharMapper;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final CharMapper getCharMapper() {
/*  27 */     return this.mapper;
/*     */   }
/*     */ 
/*     */   
/*     */   public final char charAt(int paramInt) {
/*  32 */     return this.mapper.map(this.baseSeq.charAt(paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final BasedSequence getCharSequence() {
/*  38 */     return this.baseSeq;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int length() {
/*  43 */     return this.baseSeq.length();
/*     */   }
/*     */ 
/*     */   
/*     */   public final BasedSequence toMapped(CharMapper paramCharMapper) {
/*  48 */     return (paramCharMapper == CharMapper.IDENTITY) ? this : new MappedBasedSequence(this.baseSeq, this.mapper.andThen(paramCharMapper));
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getOptionFlags() {
/*  53 */     return getBaseSequence().getOptionFlags();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean allOptions(int paramInt) {
/*  58 */     return getBaseSequence().allOptions(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean anyOptions(int paramInt) {
/*  63 */     return getBaseSequence().anyOptions(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public final <T> T getOption(DataKeyBase<T> paramDataKeyBase) {
/*  68 */     return getBaseSequence().getOption(paramDataKeyBase);
/*     */   }
/*     */ 
/*     */   
/*     */   public final DataHolder getOptions() {
/*  73 */     return getBaseSequence().getOptions();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final BasedSequence sequenceOf(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/*  79 */     if (paramCharSequence instanceof MappedBasedSequence)
/*  80 */       return (paramInt1 == 0 && paramInt2 == paramCharSequence.length()) ? (BasedSequence)paramCharSequence : ((BasedSequence)paramCharSequence).subSequence(paramInt1, paramInt2).toMapped(this.mapper); 
/*  81 */     return new MappedBasedSequence(this.baseSeq.sequenceOf(paramCharSequence, paramInt1, paramInt2), this.mapper);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final BasedSequence subSequence(int paramInt1, int paramInt2) {
/*  87 */     SequenceUtils.validateStartEnd(paramInt1, paramInt2, length());
/*     */     
/*  89 */     if (paramInt1 == 0 && paramInt2 == this.baseSeq.length()) {
/*  90 */       return this;
/*     */     }
/*  92 */     return new MappedBasedSequence(this.baseSeq.subSequence(paramInt1, paramInt2), this.mapper);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object getBase() {
/*  98 */     return this.baseSeq.getBase();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final BasedSequence getBaseSequence() {
/* 104 */     return this.baseSeq.getBaseSequence();
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getStartOffset() {
/* 109 */     return this.baseSeq.getStartOffset();
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getEndOffset() {
/* 114 */     return this.baseSeq.getEndOffset();
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getIndexOffset(int paramInt) {
/* 119 */     return (this.baseSeq.charAt(paramInt) == charAt(paramInt)) ? this.baseSeq.getIndexOffset(paramInt) : -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void addSegments(IBasedSegmentBuilder<?> paramIBasedSegmentBuilder) {
/* 124 */     BasedUtils.generateSegments(paramIBasedSegmentBuilder, this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Range getSourceRange() {
/* 130 */     return this.baseSeq.getSourceRange();
/*     */   }
/*     */ 
/*     */   
/*     */   public static BasedSequence mappedOf(BasedSequence paramBasedSequence, CharMapper paramCharMapper) {
/* 135 */     return new MappedBasedSequence(paramBasedSequence, paramCharMapper);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\MappedBasedSequence.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */