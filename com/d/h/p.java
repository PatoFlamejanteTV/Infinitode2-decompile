/*    */ package com.d.h;
/*    */ 
/*    */ import com.d.d.b;
/*    */ import org.a.c.h.e.u;
/*    */ import org.a.c.h.e.v;
/*    */ 
/*    */ 
/*    */ public final class p
/*    */   implements b
/*    */ {
/*    */   public final float a;
/*    */   public final float b;
/*    */   public final float c;
/*    */   public final float d;
/*    */   public final float e;
/*    */   public final float f;
/*    */   
/*    */   private p(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/* 19 */     this.a = paramFloat1;
/* 20 */     this.b = paramFloat2;
/* 21 */     this.c = paramFloat3;
/* 22 */     this.d = 100.0F;
/* 23 */     this.e = paramFloat5;
/* 24 */     this.f = 50.0F;
/*    */   }
/*    */   
/*    */   public static p a(u paramu, v paramv) {
/* 28 */     return new p(paramu
/* 29 */         .e().d(), 
/* 30 */         -paramu.e().b(), 
/* 31 */         -paramv.j().g() / 3.0F, 100.0F, 
/*    */         
/* 33 */         -paramv.l(), 50.0F);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\h\p.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */