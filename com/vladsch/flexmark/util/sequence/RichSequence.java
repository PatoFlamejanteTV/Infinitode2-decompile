/*    */ package com.vladsch.flexmark.util.sequence;
/*    */ 
/*    */ public interface RichSequence
/*    */   extends IRichSequence<RichSequence>
/*    */ {
/*  6 */   public static final RichSequence NULL = RichSequenceImpl.create("", 0, 0);
/*  7 */   public static final RichSequence[] EMPTY_ARRAY = new RichSequence[0];
/*    */   
/*    */   static RichSequence of(CharSequence paramCharSequence) {
/* 10 */     return RichSequenceImpl.create(paramCharSequence, 0, paramCharSequence.length());
/*    */   }
/*    */   
/*    */   static RichSequence of(CharSequence paramCharSequence, int paramInt) {
/* 14 */     return RichSequenceImpl.create(paramCharSequence, paramInt, paramCharSequence.length());
/*    */   }
/*    */   
/*    */   static RichSequence of(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/* 18 */     return RichSequenceImpl.create(paramCharSequence, paramInt1, paramInt2);
/*    */   }
/*    */ 
/*    */   
/*    */   static RichSequence ofSpaces(int paramInt) {
/* 23 */     return of(RepeatedSequence.ofSpaces(paramInt));
/*    */   }
/*    */ 
/*    */   
/*    */   static RichSequence repeatOf(char paramChar, int paramInt) {
/* 28 */     return of(RepeatedSequence.repeatOf(String.valueOf(paramChar), 0, paramInt));
/*    */   }
/*    */ 
/*    */   
/*    */   static RichSequence repeatOf(CharSequence paramCharSequence, int paramInt) {
/* 33 */     return of(RepeatedSequence.repeatOf(paramCharSequence, 0, paramCharSequence.length() * paramInt));
/*    */   }
/*    */ 
/*    */   
/*    */   static RichSequence repeatOf(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/* 38 */     return of(RepeatedSequence.repeatOf(paramCharSequence, paramInt1, paramInt2));
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\RichSequence.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */