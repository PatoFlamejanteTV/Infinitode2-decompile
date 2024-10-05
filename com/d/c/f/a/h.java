/*     */ package com.d.c.f.a;
/*     */ 
/*     */ import com.d.c.a.a;
/*     */ import com.d.c.f.c;
/*     */ import com.d.c.f.d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class h
/*     */ {
/*  13 */   public static final h b = new h(0.0F, 0.0F, 0.0F, 0.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  21 */   protected float c = this.d = this.e = this.f = 0.0F;
/*     */   
/*     */   protected float d;
/*     */   
/*     */   protected float e;
/*     */   protected float f;
/*     */   
/*     */   protected h() {}
/*     */   
/*     */   private h(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  31 */     this();
/*  32 */     this.c = paramFloat1;
/*  33 */     this.d = paramFloat2;
/*  34 */     this.e = paramFloat3;
/*  35 */     this.f = paramFloat4;
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static h a(c paramc, a parama, a.a parama1, float paramFloat, d paramd) {
/*     */     h h1;
/*  54 */     return h1 = new h(!paramc.h(parama1.a) ? 0.0F : paramc.c(parama1.a, paramFloat, paramd), !paramc.h(parama1.b) ? 0.0F : paramc.b(parama1.b, paramFloat, paramd), !paramc.h(parama1.c) ? 0.0F : paramc.c(parama1.c, paramFloat, paramd), !paramc.h(parama1.d) ? 0.0F : paramc.b(parama1.d, paramFloat, paramd));
/*     */   }
/*     */   
/*     */   public String toString() {
/*  58 */     return "RectPropertySet[top=" + this.c + ",right=" + this.d + ",bottom=" + this.e + ",left=" + this.f + "]";
/*     */   }
/*     */   
/*     */   public final float t() {
/*  62 */     return this.c;
/*     */   }
/*     */   
/*     */   public final float u() {
/*  66 */     return this.d;
/*     */   }
/*     */   
/*     */   public final float v() {
/*  70 */     return this.e;
/*     */   }
/*     */   
/*     */   public final float w() {
/*  74 */     return this.f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float x() {
/*  82 */     return this.c + this.e;
/*     */   }
/*     */   
/*     */   public final float y() {
/*  86 */     return this.f + this.d;
/*     */   }
/*     */   
/*     */   public final void a(float paramFloat) {
/*  90 */     this.c = paramFloat;
/*     */   }
/*     */   
/*     */   public final void b(float paramFloat) {
/*  94 */     this.d = paramFloat;
/*     */   }
/*     */   
/*     */   public final void c(float paramFloat) {
/*  98 */     this.e = paramFloat;
/*     */   }
/*     */   
/*     */   public final void d(float paramFloat) {
/* 102 */     this.f = paramFloat;
/*     */   }
/*     */   
/*     */   public final h z() {
/*     */     h h1;
/* 107 */     (h1 = new h()).c = this.c;
/* 108 */     h1.d = this.d;
/* 109 */     h1.e = this.e;
/* 110 */     h1.f = this.f;
/* 111 */     return h1;
/*     */   }
/*     */   
/*     */   public final boolean A() {
/* 115 */     return (this.c == 0.0F && this.d == 0.0F && this.e == 0.0F && this.f == 0.0F);
/*     */   }
/*     */   
/*     */   public final boolean B() {
/* 119 */     return (this.c < 0.0F || this.d < 0.0F || this.e < 0.0F || this.f < 0.0F);
/*     */   }
/*     */   
/*     */   public final void C() {
/* 123 */     if (t() < 0.0F) {
/* 124 */       a(0.0F);
/*     */     }
/* 126 */     if (u() < 0.0F) {
/* 127 */       b(0.0F);
/*     */     }
/* 129 */     if (v() < 0.0F) {
/* 130 */       c(0.0F);
/*     */     }
/* 132 */     if (w() < 0.0F)
/* 133 */       d(0.0F); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\f\a\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */