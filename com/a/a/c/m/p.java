/*    */ package com.a.a.c.m;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class p<T>
/*    */ {
/*    */   private final T a;
/*    */   private p<T> b;
/*    */   
/*    */   public p(T paramT, p<T> paramp) {
/* 16 */     this.a = paramT;
/* 17 */     this.b = paramp;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void a(p<T> paramp) {
/* 22 */     if (this.b != null) {
/* 23 */       throw new IllegalStateException();
/*    */     }
/* 25 */     this.b = paramp;
/*    */   }
/*    */   public final p<T> a() {
/* 28 */     return this.b;
/*    */   } public final T b() {
/* 30 */     return this.a;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\m\p.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */