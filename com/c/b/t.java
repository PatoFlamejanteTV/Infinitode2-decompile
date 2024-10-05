/*    */ package com.c.b;
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
/*    */ 
/*    */ final class t
/*    */   extends s
/*    */ {
/*    */   final int a(a parama, Object paramObject, float[][] paramArrayOffloat, int[] paramArrayOfint, int paramInt) {
/* 32 */     byte b1 = 0;
/* 33 */     for (byte b2 = 0; b2 < paramInt; b2++) {
/* 34 */       if (paramArrayOfint[b2] != 0) {
/* 35 */         paramArrayOffloat[b1++] = paramArrayOffloat[b2];
/*    */       }
/*    */     } 
/* 38 */     if (b1 != 0) {
/* 39 */       return a(parama, paramObject, paramArrayOffloat, b1, 1);
/*    */     }
/*    */     
/* 42 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\c\b\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */