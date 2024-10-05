/*     */ package org.a.c.h.f.a;
/*     */ 
/*     */ import java.awt.color.ColorSpace;
/*     */ import org.a.c.b.a;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.b.f;
/*     */ import org.a.c.b.j;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class b
/*     */   extends a
/*     */ {
/*     */   protected d a;
/*  35 */   private static final ColorSpace f = ColorSpace.getInstance(1001);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  40 */   protected float b = 1.0F;
/*  41 */   protected float c = 1.0F;
/*  42 */   protected float d = 1.0F;
/*     */ 
/*     */   
/*     */   protected b(j paramj) {
/*  46 */     this.e = new a();
/*  47 */     this.a = new d();
/*  48 */     this.e.a((org.a.c.b.b)paramj);
/*  49 */     this.e.a((org.a.c.b.b)this.a);
/*     */     
/*  51 */     a(d());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected b(a parama) {
/*  61 */     this.e = parama;
/*  62 */     this.a = (d)this.e.a(1);
/*     */     
/*  64 */     a(d());
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(w paramw) {
/*  69 */     this.b = paramw.a();
/*  70 */     this.c = paramw.b();
/*  71 */     this.d = paramw.c();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static float[] a(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  79 */     if (paramFloat1 < 0.0F)
/*     */     {
/*  81 */       paramFloat1 = 0.0F;
/*     */     }
/*  83 */     if (paramFloat2 < 0.0F)
/*     */     {
/*  85 */       paramFloat2 = 0.0F;
/*     */     }
/*  87 */     if (paramFloat3 < 0.0F)
/*     */     {
/*  89 */       paramFloat3 = 0.0F;
/*     */     }
/*  91 */     return f.toRGB(new float[] { paramFloat1, paramFloat2, paramFloat3 });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private w d() {
/*     */     a a1;
/* 107 */     if ((a1 = (a)this.a.a(j.dZ)) == null) {
/*     */ 
/*     */       
/* 110 */       (a1 = new a()).a((org.a.c.b.b)new f(1.0F));
/* 111 */       a1.a((org.a.c.b.b)new f(1.0F));
/* 112 */       a1.a((org.a.c.b.b)new f(1.0F));
/*     */     } 
/* 114 */     return new w(a1);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\f\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */