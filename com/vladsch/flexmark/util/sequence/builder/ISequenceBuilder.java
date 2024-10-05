/*    */ package com.vladsch.flexmark.util.sequence.builder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface ISequenceBuilder<T extends ISequenceBuilder<T, S>, S extends CharSequence>
/*    */   extends Appendable
/*    */ {
/*    */   default T addAll(Iterable<? extends CharSequence> paramIterable) {
/* 18 */     return append(paramIterable);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default T append(Iterable<? extends CharSequence> paramIterable) {
/* 25 */     for (CharSequence charSequence : paramIterable) {
/* 26 */       append(charSequence, 0, charSequence.length());
/*    */     }
/*    */     
/* 29 */     return (T)this;
/*    */   }
/*    */ 
/*    */   
/*    */   default T add(CharSequence paramCharSequence) {
/* 34 */     return append(paramCharSequence);
/*    */   }
/*    */ 
/*    */   
/*    */   default T append(CharSequence paramCharSequence) {
/* 39 */     if (paramCharSequence != null) {
/* 40 */       return append(paramCharSequence, 0, paramCharSequence.length());
/*    */     }
/*    */     
/* 43 */     return (T)this;
/*    */   }
/*    */ 
/*    */   
/*    */   default T append(CharSequence paramCharSequence, int paramInt) {
/* 48 */     if (paramCharSequence != null) {
/* 49 */       return append(paramCharSequence, paramInt, paramCharSequence.length());
/*    */     }
/*    */     
/* 52 */     return (T)this;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default boolean isEmpty() {
/* 66 */     return (length() <= 0);
/*    */   }
/*    */   
/*    */   default boolean isNotEmpty() {
/* 70 */     return (length() > 0);
/*    */   }
/*    */   
/*    */   S getSingleBasedSequence();
/*    */   
/*    */   T getBuilder();
/*    */   
/*    */   char charAt(int paramInt);
/*    */   
/*    */   T append(CharSequence paramCharSequence, int paramInt1, int paramInt2);
/*    */   
/*    */   T append(char paramChar);
/*    */   
/*    */   T append(char paramChar, int paramInt);
/*    */   
/*    */   S toSequence();
/*    */   
/*    */   int length();
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\builder\ISequenceBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */