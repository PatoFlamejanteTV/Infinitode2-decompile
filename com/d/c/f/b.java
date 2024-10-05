/*     */ package com.d.c.f;
/*     */ 
/*     */ import com.d.c.d.j;
/*     */ 
/*     */ public final class b {
/*     */   private boolean a;
/*     */   private boolean b;
/*     */   private float c;
/*     */   private float d;
/*     */   
/*  11 */   public b() { this.a = false;
/*  12 */     this.b = false; } public b(float paramFloat1, float paramFloat2) { this.a = false; this.b = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  21 */     this.c = paramFloat1;
/*  22 */     this.d = paramFloat2;
/*  23 */     this.b = false;
/*  24 */     this.b = false; } public b(a parama, c paramc, d paramd) {
/*     */     j j;
/*     */     this.a = false;
/*     */     this.b = false;
/*     */     g g;
/*  29 */     if (g = paramc.i(parama) instanceof f) {
/*     */       j j1; f f;
/*  31 */       j = (f = (f)g).j().get(0);
/*  32 */       if (f.j().size() > 1) {
/*  33 */         j1 = f.j().get(1);
/*     */       } else {
/*  35 */         j1 = j;
/*     */       } 
/*  37 */       if (parama.equals(a.aO) || parama.equals(a.aQ)) {
/*  38 */         b(parama, paramc, j, paramd);
/*  39 */         a(parama, paramc, j1, paramd);
/*     */       }
/*     */       else {
/*     */         
/*  43 */         a(parama, paramc, j, paramd);
/*  44 */         b(parama, paramc, j1, paramd);
/*     */         
/*     */         return;
/*     */       } 
/*  48 */     } else if (j instanceof e) {
/*     */       e e;
/*     */       
/*  51 */       if ((e = (e)j).a().contains("%")) {
/*  52 */         this.a = this.b = true;
/*  53 */         this.c = this.d = j.b() / 100.0F; return;
/*     */       } 
/*  55 */       this.c = this.d = (int)e.a(parama, 0.0F, paramd);
/*     */     } 
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
/*     */   private void a(a parama, c paramc, j paramj, d paramd) {
/*  69 */     if (paramj.a() == 2) {
/*  70 */       this.a = true;
/*  71 */       this.c = paramj.f() / 100.0F; return;
/*     */     } 
/*  73 */     this.c = (int)e.a(paramc, parama, paramj
/*     */ 
/*     */         
/*  76 */         .d(), paramj
/*  77 */         .f(), paramj
/*  78 */         .a(), 0.0F, paramd);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(a parama, c paramc, j paramj, d paramd) {
/*  84 */     if (paramj.a() == 2) {
/*  85 */       paramj.f();
/*  86 */       this.b = true;
/*  87 */       this.d = paramj.f() / 100.0F; return;
/*     */     } 
/*  89 */     this.d = (int)e.a(paramc, parama, paramj
/*     */ 
/*     */         
/*  92 */         .d(), paramj
/*  93 */         .f(), paramj
/*  94 */         .a(), 0.0F, paramd);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean a() {
/* 101 */     return (this.c > 0.0F || this.d > 0.0F);
/*     */   }
/*     */   
/*     */   public final float a(float paramFloat) {
/* 105 */     if (this.a)
/* 106 */       return paramFloat * this.c; 
/* 107 */     if (this.c > paramFloat)
/* 108 */       return paramFloat; 
/* 109 */     return this.c;
/*     */   }
/*     */   
/*     */   public final float b(float paramFloat) {
/* 113 */     if (this.b)
/* 114 */       return paramFloat * this.d; 
/* 115 */     if (this.d > paramFloat)
/* 116 */       return paramFloat; 
/* 117 */     return this.d;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float b() {
/* 122 */     return this.c;
/*     */   }
/*     */   public final float c() {
/* 125 */     return this.d;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\f\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */