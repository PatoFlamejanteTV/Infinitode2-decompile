/*    */ package com.a.a.c.k.a;
/*    */ 
/*    */ import com.a.a.a.al;
/*    */ import com.a.a.b.h;
/*    */ import com.a.a.b.r;
/*    */ import com.a.a.c.aa;
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
/*    */ public final class v
/*    */ {
/*    */   private al<?> a;
/*    */   private Object b;
/*    */   private boolean c = false;
/*    */   
/*    */   public v(al<?> paramal) {
/* 29 */     this.a = paramal;
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean a(h paramh, aa paramaa, m paramm) {
/* 34 */     if (this.b != null && (this.c || paramm.e)) {
/*    */       
/* 36 */       if (paramh.d()) {
/* 37 */         String.valueOf(this.b); paramh.l();
/*    */       } else {
/* 39 */         paramm.d.a(this.b, paramh, paramaa);
/*    */       } 
/* 41 */       return true;
/*    */     } 
/* 43 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final Object a(Object paramObject) {
/* 50 */     if (this.b == null) {
/* 51 */       this.b = this.a.b(paramObject);
/*    */     }
/* 53 */     return this.b;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void b(h paramh, aa paramaa, m paramm) {
/* 62 */     this.c = true;
/*    */ 
/*    */     
/* 65 */     if (paramh.d()) {
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 70 */       String str = (this.b == null) ? null : String.valueOf(this.b);
/* 71 */       paramh.f(str);
/*    */       
/*    */       return;
/*    */     } 
/*    */     r r;
/* 76 */     if ((r = paramm.b) != null) {
/*    */       
/* 78 */       paramh.b(r);
/* 79 */       paramm.d.a(this.b, paramh, paramaa);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\a\v.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */