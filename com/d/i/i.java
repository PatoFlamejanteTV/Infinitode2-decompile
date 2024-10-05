/*    */ package com.d.i;
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
/*    */ public final class i
/*    */ {
/* 25 */   private int a = -1;
/* 26 */   private int b = -1;
/*    */   
/*    */   public final int a() {
/* 29 */     return this.a;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void a(int paramInt) {
/* 37 */     if (this.a == -1 || paramInt < this.a) {
/* 38 */       this.a = paramInt;
/*    */     }
/*    */   }
/*    */   
/*    */   public final int b() {
/* 43 */     return this.b;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void b(int paramInt) {
/* 51 */     if (this.b == -1 || paramInt > this.b) {
/* 52 */       this.b = paramInt;
/*    */     }
/*    */   }
/*    */   
/*    */   public final String toString() {
/* 57 */     return "[top=" + this.a + ", bottom=" + this.b + "]";
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\i\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */