/*    */ package org.lwjgl.system;
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
/*    */ public final class CheckIntrinsics
/*    */ {
/*    */   public static int checkIndex(int paramInt1, int paramInt2) {
/* 18 */     if (paramInt1 < 0 || paramInt2 <= paramInt1) {
/* 19 */       throw new IndexOutOfBoundsException();
/*    */     }
/* 21 */     return paramInt1;
/*    */   }
/*    */   
/*    */   public static int checkFromToIndex(int paramInt1, int paramInt2, int paramInt3) {
/* 25 */     if (paramInt1 < 0 || paramInt2 < paramInt1 || paramInt3 < paramInt2) {
/* 26 */       throw new IndexOutOfBoundsException();
/*    */     }
/* 28 */     return paramInt1;
/*    */   }
/*    */   
/*    */   public static int checkFromIndexSize(int paramInt1, int paramInt2, int paramInt3) {
/* 32 */     if ((paramInt3 | paramInt1 | paramInt2) < 0 || paramInt3 - paramInt1 < paramInt2) {
/* 33 */       throw new IndexOutOfBoundsException();
/*    */     }
/* 35 */     return paramInt1;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\CheckIntrinsics.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */