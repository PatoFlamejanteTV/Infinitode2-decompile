/*     */ package org.a.c.h.a.b;
/*     */ 
/*     */ import org.a.c.b.a;
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.f;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.b.l;
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
/*     */ public final class c
/*     */   extends a
/*     */ {
/*     */   private final a a;
/*     */   private final a b;
/*     */   private final float c;
/*     */   
/*     */   public c(b paramb) {
/*  55 */     super(paramb);
/*     */     
/*  57 */     if (b().a(j.H) instanceof a) {
/*     */       
/*  59 */       this.a = (a)b().a(j.H);
/*     */     }
/*     */     else {
/*     */       
/*  63 */       this.a = new a();
/*     */     } 
/*  65 */     if (this.a.b() == 0)
/*     */     {
/*  67 */       this.a.a((b)new f(0.0F));
/*     */     }
/*     */     
/*  70 */     if (b().a(j.I) instanceof a) {
/*     */       
/*  72 */       this.b = (a)b().a(j.I);
/*     */     }
/*     */     else {
/*     */       
/*  76 */       this.b = new a();
/*     */     } 
/*  78 */     if (this.b.b() == 0)
/*     */     {
/*  80 */       this.b.a((b)new f(1.0F));
/*     */     }
/*     */     
/*  83 */     this.c = b().l(j.co);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int a() {
/*  92 */     return 2;
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
/*     */   public final float[] a(float[] paramArrayOffloat) {
/* 104 */     float f = (float)Math.pow(paramArrayOffloat[0], this.c);
/*     */     
/* 106 */     float[] arrayOfFloat = new float[Math.min(this.a.b(), this.b.b())];
/* 107 */     for (byte b = 0; b < arrayOfFloat.length; b++) {
/*     */       
/* 109 */       float f1 = ((l)this.a.b(b)).a();
/* 110 */       float f2 = ((l)this.b.b(b)).a();
/* 111 */       arrayOfFloat[b] = f1 + f * (f2 - f1);
/*     */     } 
/*     */     
/* 114 */     return b(arrayOfFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private a h() {
/* 124 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private a i() {
/* 134 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private float j() {
/* 144 */     return this.c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 153 */     return "FunctionType2{C0: " + 
/* 154 */       h() + " C1: " + 
/* 155 */       i() + " N: " + 
/* 156 */       j() + "}";
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\a\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */