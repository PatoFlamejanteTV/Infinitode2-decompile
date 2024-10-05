/*    */ package com.google.common.base;
/*    */ 
/*    */ import java.nio.Buffer;
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
/*    */ @ElementTypesAreNonnullByDefault
/*    */ final class Java8Compatibility
/*    */ {
/*    */   static void clear(Buffer paramBuffer) {
/* 28 */     paramBuffer.clear();
/*    */   }
/*    */   
/*    */   static void flip(Buffer paramBuffer) {
/* 32 */     paramBuffer.flip();
/*    */   }
/*    */   
/*    */   static void limit(Buffer paramBuffer, int paramInt) {
/* 36 */     paramBuffer.limit(paramInt);
/*    */   }
/*    */   
/*    */   static void position(Buffer paramBuffer, int paramInt) {
/* 40 */     paramBuffer.position(paramInt);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\google\common\base\Java8Compatibility.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */