/*    */ package com.vladsch.flexmark.util.sequence.builder;
/*    */ 
/*    */ import com.vladsch.flexmark.util.sequence.RichSequence;
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class RichSequenceBuilder
/*    */   implements ISequenceBuilder<RichSequenceBuilder, RichSequence>
/*    */ {
/*    */   private final StringBuilder segments;
/*    */   
/*    */   public static RichSequenceBuilder emptyBuilder() {
/* 13 */     return new RichSequenceBuilder();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private RichSequenceBuilder() {
/* 19 */     this.segments = new StringBuilder();
/*    */   }
/*    */   
/*    */   public RichSequenceBuilder(int paramInt) {
/* 23 */     this.segments = new StringBuilder(paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   public final RichSequenceBuilder getBuilder() {
/* 28 */     return new RichSequenceBuilder();
/*    */   }
/*    */ 
/*    */   
/*    */   public final char charAt(int paramInt) {
/* 33 */     return this.segments.charAt(paramInt);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final RichSequenceBuilder append(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/* 39 */     if (paramCharSequence != null && paramCharSequence.length() > 0 && paramInt1 < paramInt2) {
/* 40 */       this.segments.append(paramCharSequence, paramInt1, paramInt2);
/*    */     }
/* 42 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final RichSequenceBuilder append(char paramChar) {
/* 48 */     this.segments.append(paramChar);
/* 49 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final RichSequenceBuilder append(char paramChar, int paramInt) {
/* 55 */     for (; paramInt-- > 0; this.segments.append(paramChar));
/* 56 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final RichSequence getSingleBasedSequence() {
/* 62 */     return toSequence();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final RichSequence toSequence() {
/* 68 */     return RichSequence.of(this.segments);
/*    */   }
/*    */ 
/*    */   
/*    */   public final int length() {
/* 73 */     return this.segments.length();
/*    */   }
/*    */ 
/*    */   
/*    */   public final String toString() {
/* 78 */     return this.segments.toString();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\builder\RichSequenceBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */