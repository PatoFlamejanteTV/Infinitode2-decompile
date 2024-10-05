/*    */ package com.prineside.tdi2.utils;
/*    */ 
/*    */ public final class IntPair {
/*    */   public int a;
/*    */   public int b;
/*    */   
/*    */   public IntPair() {}
/*    */   
/*    */   public IntPair(int paramInt1, int paramInt2) {
/* 10 */     this.a = paramInt1;
/* 11 */     this.b = paramInt2;
/*    */   }
/*    */ 
/*    */   
/*    */   public final String toString() {
/* 16 */     return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " {" + this.a + ", " + this.b + "}";
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\IntPair.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */