/*    */ package com.vladsch.flexmark.util.sequence.builder;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.function.BiFunction;
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
/*    */ 
/*    */ public interface SegmentOptimizer
/*    */   extends BiFunction<CharSequence, Object[], Object[]>
/*    */ {
/*    */   static Object[] insert(Object[] paramArrayOfObject, int paramInt) {
/* 34 */     if (paramInt < paramArrayOfObject.length) {
/* 35 */       Object[] arrayOfObject = new Object[paramArrayOfObject.length + 1];
/* 36 */       if (paramInt == 0) {
/* 37 */         System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 1, paramArrayOfObject.length);
/*    */       } else {
/* 39 */         System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 0, paramInt);
/* 40 */         System.arraycopy(paramArrayOfObject, paramInt, arrayOfObject, paramInt + 1, paramArrayOfObject.length - paramInt);
/*    */       } 
/* 42 */       return arrayOfObject;
/*    */     } 
/* 44 */     return Arrays.copyOf(paramArrayOfObject, paramArrayOfObject.length + 1);
/*    */   }
/*    */   
/*    */   Object[] apply(CharSequence paramCharSequence, Object[] paramArrayOfObject);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\builder\SegmentOptimizer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */