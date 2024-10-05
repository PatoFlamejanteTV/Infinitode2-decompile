/*     */ package org.a.c.h.f.a;
/*     */ 
/*     */ import org.a.c.b.a;
/*     */ import org.a.c.b.b;
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
/*     */ 
/*     */ public final class d
/*     */   extends b
/*     */ {
/*  34 */   private final e f = new e(new float[] { 0.0F, 0.0F, 0.0F }, this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public d() {
/*  41 */     super(j.L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public d(a parama) {
/*  50 */     super(parama);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String a() {
/*  56 */     return j.L.a();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int b() {
/*  62 */     return 3;
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
/*     */   public final e c() {
/*  74 */     return this.f;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float[] a(float[] paramArrayOffloat) {
/*     */     float f;
/*  80 */     if (this.b == 1.0F && this.c == 1.0F && this.d == 1.0F) {
/*     */       
/*  82 */       float f1 = paramArrayOffloat[0];
/*  83 */       float f2 = paramArrayOffloat[1];
/*  84 */       f = paramArrayOffloat[2];
/*     */       
/*  86 */       n n = d();
/*  87 */       f1 = (float)Math.pow(f1, n.a());
/*  88 */       f2 = (float)Math.pow(f2, n.b());
/*  89 */       f = (float)Math.pow(f, n.c());
/*     */ 
/*     */       
/*  92 */       float arrayOfFloat[], f4 = (arrayOfFloat = e())[0];
/*  93 */       float f5 = arrayOfFloat[1];
/*  94 */       float f6 = arrayOfFloat[2];
/*  95 */       float f7 = arrayOfFloat[3];
/*  96 */       float f8 = arrayOfFloat[4];
/*  97 */       float f9 = arrayOfFloat[5];
/*  98 */       float f10 = arrayOfFloat[6];
/*  99 */       float f11 = arrayOfFloat[7];
/* 100 */       float f3 = arrayOfFloat[8];
/*     */       
/* 102 */       f4 = f4 * f1 + f7 * f2 + f10 * f;
/* 103 */       f5 = f5 * f1 + f8 * f2 + f11 * f;
/* 104 */       f = f6 * f1 + f9 * f2 + f3 * f;
/* 105 */       return a(f4, f5, f);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 112 */     return new float[] { f[0], f[1], f[2] };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private n d() {
/*     */     a a;
/* 124 */     if ((a = (a)this.a.a(j.bu)) == null) {
/*     */ 
/*     */       
/* 127 */       (a = new a()).a((b)new f(1.0F));
/* 128 */       a.a((b)new f(1.0F));
/* 129 */       a.a((b)new f(1.0F));
/* 130 */       this.a.a(j.bu, (b)a);
/*     */     } 
/* 132 */     return new n(a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private float[] e() {
/*     */     a a;
/* 143 */     if ((a = (a)this.a.a(j.cf)) == null)
/*     */     {
/* 145 */       return new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F };
/*     */     }
/*     */ 
/*     */     
/* 149 */     return a.d();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\f\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */