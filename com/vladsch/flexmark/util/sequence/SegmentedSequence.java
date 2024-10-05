/*     */ package com.vladsch.flexmark.util.sequence;
/*     */ 
/*     */ import com.vladsch.flexmark.util.collection.iteration.ArrayIterable;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.data.DataKeyBase;
/*     */ import com.vladsch.flexmark.util.sequence.builder.ISegmentBuilder;
/*     */ import com.vladsch.flexmark.util.sequence.builder.SequenceBuilder;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class SegmentedSequence
/*     */   extends BasedSequenceImpl
/*     */   implements ReplacedBasedSequence
/*     */ {
/*     */   protected final BasedSequence baseSeq;
/*     */   protected final int startOffset;
/*     */   protected final int endOffset;
/*     */   protected final int length;
/*     */   
/*     */   protected SegmentedSequence(BasedSequence paramBasedSequence, int paramInt1, int paramInt2, int paramInt3) {
/*  21 */     super(0);
/*  22 */     assert paramBasedSequence == paramBasedSequence.getBaseSequence();
/*     */     
/*  24 */     if (paramInt1 < 0 && paramInt2 < 0) {
/*     */       
/*  26 */       paramInt1 = 0;
/*  27 */       paramInt2 = 0;
/*     */     } 
/*     */     
/*  30 */     assert paramInt1 >= 0 : "startOffset: " + paramInt1;
/*  31 */     assert paramInt2 >= paramInt1 && paramInt2 <= paramBasedSequence.length() : "endOffset: " + paramInt2;
/*     */     
/*  33 */     this.baseSeq = paramBasedSequence;
/*  34 */     this.startOffset = paramInt1;
/*  35 */     this.endOffset = paramInt2;
/*  36 */     this.length = paramInt3;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object getBase() {
/*  42 */     return this.baseSeq.getBase();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final BasedSequence getBaseSequence() {
/*  48 */     return this.baseSeq;
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
/*     */   public final int getStartOffset() {
/*  60 */     return this.startOffset;
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
/*     */   public final int getEndOffset() {
/*  72 */     return this.endOffset;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getOptionFlags() {
/*  77 */     return getBaseSequence().getOptionFlags();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean allOptions(int paramInt) {
/*  82 */     return getBaseSequence().allOptions(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean anyOptions(int paramInt) {
/*  87 */     return getBaseSequence().anyOptions(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public final <T> T getOption(DataKeyBase<T> paramDataKeyBase) {
/*  92 */     return getBaseSequence().getOption(paramDataKeyBase);
/*     */   }
/*     */ 
/*     */   
/*     */   public final DataHolder getOptions() {
/*  97 */     return getBaseSequence().getOptions();
/*     */   }
/*     */ 
/*     */   
/*     */   public final int length() {
/* 102 */     return this.length;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Range getSourceRange() {
/* 108 */     return Range.of(getStartOffset(), getEndOffset());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final BasedSequence baseSubSequence(int paramInt1, int paramInt2) {
/* 114 */     SequenceUtils.validateStartEnd(paramInt1, paramInt2, this.baseSeq.length());
/* 115 */     return this.baseSeq.baseSubSequence(paramInt1, paramInt2);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static BasedSequence create(BasedSequence paramBasedSequence, Iterable<? extends BasedSequence> paramIterable) {
/* 135 */     return create((SequenceBuilder)paramBasedSequence.getBuilder().addAll(paramIterable));
/*     */   }
/*     */   
/*     */   public static BasedSequence create(BasedSequence... paramVarArgs) {
/* 139 */     return (paramVarArgs.length == 0) ? BasedSequence.NULL : create(paramVarArgs[0], (Iterable<? extends BasedSequence>)new ArrayIterable((Object[])paramVarArgs));
/*     */   }
/*     */   
/*     */   public static BasedSequence create(SequenceBuilder paramSequenceBuilder) {
/*     */     BasedSequence basedSequence;
/* 144 */     if ((basedSequence = paramSequenceBuilder.getSingleBasedSequence()) != null)
/* 145 */       return basedSequence; 
/* 146 */     if (!paramSequenceBuilder.isEmpty()) {
/*     */       
/* 148 */       if ((basedSequence = paramSequenceBuilder.getBaseSequence()).anyOptions(F_FULL_SEGMENTED_SEQUENCES))
/* 149 */         return SegmentedSequenceFull.create(basedSequence, (ISegmentBuilder<?>)paramSequenceBuilder.getSegmentBuilder()); 
/* 150 */       if (basedSequence.anyOptions(F_TREE_SEGMENTED_SEQUENCES)) {
/* 151 */         return SegmentedSequenceTree.create(basedSequence, (ISegmentBuilder<?>)paramSequenceBuilder.getSegmentBuilder());
/*     */       }
/*     */ 
/*     */       
/* 155 */       return SegmentedSequenceTree.create(basedSequence, (ISegmentBuilder<?>)paramSequenceBuilder.getSegmentBuilder());
/*     */     } 
/*     */     
/* 158 */     return BasedSequence.NULL;
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
/*     */   @Deprecated
/*     */   public static BasedSequence of(BasedSequence paramBasedSequence, Iterable<? extends BasedSequence> paramIterable) {
/* 172 */     return create(paramBasedSequence, paramIterable);
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public static BasedSequence of(BasedSequence... paramVarArgs) {
/* 177 */     return create(paramVarArgs);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\SegmentedSequence.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */