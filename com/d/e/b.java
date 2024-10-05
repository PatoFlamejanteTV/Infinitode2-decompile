/*    */ package com.d.e;
/*    */ 
/*    */ import com.d.c.f.d;
/*    */ import com.d.i.c;
/*    */ import com.d.i.f;
/*    */ import com.d.i.u;
/*    */ import java.awt.Point;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class b
/*    */ {
/* 40 */   private int a = 0;
/* 41 */   private int b = 0;
/*    */   
/*    */   private final z c;
/*    */   
/*    */   public b(c paramc, v paramv) {
/* 46 */     this.c = new z(paramc);
/*    */   }
/*    */   
/*    */   public final Point a() {
/* 50 */     return new Point(this.a, this.b);
/*    */   }
/*    */   
/*    */   public final void a(int paramInt1, int paramInt2) {
/* 54 */     this.a -= paramInt1;
/* 55 */     this.b -= paramInt2;
/*    */   }
/*    */   
/*    */   public final n b() {
/* 59 */     return this.c.a();
/*    */   }
/*    */   
/*    */   public final int a(d paramd, u paramu, int paramInt) {
/* 63 */     return b().b(paramd, this, paramu, paramInt);
/*    */   }
/*    */   
/*    */   public final int b(d paramd, u paramu, int paramInt) {
/* 67 */     return b().c(paramd, this, paramu, paramInt);
/*    */   }
/*    */   
/*    */   public final int c(d paramd, u paramu, int paramInt) {
/* 71 */     return a(paramd, paramu, paramInt) + 
/* 72 */       b(paramd, paramu, paramInt);
/*    */   }
/*    */   
/*    */   public final int d(d paramd, u paramu, int paramInt) {
/* 76 */     return b().a(paramd, this, paramu, paramInt);
/*    */   }
/*    */   
/*    */   public final void a(v paramv, c paramc) {
/* 80 */     b().a(paramv, paramv.o(), this, paramc);
/*    */   }
/*    */   
/*    */   public final void a(v paramv, f paramf) {
/* 84 */     b().a(paramv, this, paramf);
/*    */   }
/*    */   
/*    */   public final String toString() {
/* 88 */     return "BlockFormattingContext: (" + this.a + "," + this.b + ")";
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\e\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */