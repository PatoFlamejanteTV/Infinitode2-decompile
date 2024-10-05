/*    */ package com.a.a.c.m;
/*    */ 
/*    */ import com.a.a.c.a;
/*    */ import com.a.a.c.b;
/*    */ import com.a.a.c.b.q;
/*    */ import com.a.a.c.f.d;
/*    */ import com.a.a.c.j;
/*    */ import com.a.a.c.l.b;
/*    */ import com.a.a.c.w;
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class z
/*    */   implements Serializable
/*    */ {
/* 22 */   private transient o<b, w> a = new o<>(20, 200);
/*    */ 
/*    */   
/*    */   public final w a(j paramj, q<?> paramq) {
/* 26 */     return a(paramj.b(), paramq);
/*    */   }
/*    */ 
/*    */   
/*    */   public final w a(Class<?> paramClass, q<?> paramq) {
/* 31 */     b b = new b(paramClass);
/*    */     w w2;
/* 33 */     if ((w2 = this.a.a(b)) != null) {
/* 34 */       return w2;
/*    */     }
/* 36 */     b b1 = paramq.c(paramClass);
/* 37 */     a a = paramq.j();
/* 38 */     d d = b1.d();
/*    */     
/*    */     w w1;
/* 41 */     if ((w1 = a.a(d)) == null || !w1.c())
/*    */     {
/* 43 */       w1 = w.a(paramClass.getSimpleName());
/*    */     }
/* 45 */     this.a.a(b, w1);
/* 46 */     return w1;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\m\z.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */