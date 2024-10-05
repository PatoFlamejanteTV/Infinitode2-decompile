/*    */ package com.a.a.c.b;
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
/*    */ public enum o
/*    */   implements k
/*    */ {
/* 20 */   a(true),
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 28 */   b(true);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final boolean c;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final int d;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   o(boolean paramBoolean) {
/* 50 */     this.c = true;
/* 51 */     this.d = 1 << ordinal();
/*    */   }
/*    */   
/*    */   public final boolean a() {
/* 55 */     return this.c;
/*    */   } public final boolean a(int paramInt) {
/* 57 */     return ((paramInt & this.d) != 0);
/*    */   } public final int b() {
/* 59 */     return this.d;
/*    */   }
/*    */   
/*    */   public final int c() {
/* 63 */     return 1;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\b\o.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */