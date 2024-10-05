/*    */ package com.vladsch.flexmark.util.sequence.builder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class StringSequenceBuilder
/*    */   implements ISequenceBuilder<StringSequenceBuilder, CharSequence>
/*    */ {
/*    */   private final StringBuilder segments;
/*    */   
/*    */   public static StringSequenceBuilder emptyBuilder() {
/* 12 */     return new StringSequenceBuilder();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private StringSequenceBuilder() {
/* 18 */     this.segments = new StringBuilder();
/*    */   }
/*    */   
/*    */   public StringSequenceBuilder(int paramInt) {
/* 22 */     this.segments = new StringBuilder(paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   public final StringSequenceBuilder getBuilder() {
/* 27 */     return new StringSequenceBuilder();
/*    */   }
/*    */ 
/*    */   
/*    */   public final char charAt(int paramInt) {
/* 32 */     return this.segments.charAt(paramInt);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final StringSequenceBuilder append(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/* 38 */     if (paramCharSequence != null && paramCharSequence.length() > 0 && paramInt1 < paramInt2) {
/* 39 */       this.segments.append(paramCharSequence, paramInt1, paramInt2);
/*    */     }
/* 41 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final StringSequenceBuilder append(char paramChar) {
/* 47 */     this.segments.append(paramChar);
/* 48 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final StringSequenceBuilder append(char paramChar, int paramInt) {
/* 54 */     for (; paramInt-- > 0; this.segments.append(paramChar));
/* 55 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final CharSequence getSingleBasedSequence() {
/* 61 */     return toSequence();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final CharSequence toSequence() {
/* 67 */     return this.segments;
/*    */   }
/*    */ 
/*    */   
/*    */   public final int length() {
/* 72 */     return this.segments.length();
/*    */   }
/*    */ 
/*    */   
/*    */   public final String toString() {
/* 77 */     return this.segments.toString();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\builder\StringSequenceBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */