/*     */ package org.a.b.f;
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
/*     */ public final class f
/*     */   extends an
/*     */ {
/*     */   private d[] c;
/*     */   
/*     */   f(ap paramap) {
/*  61 */     super(paramap);
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
/*     */   public final void a(ap paramap, ak paramak) {
/*  75 */     paramak.c();
/*  76 */     int i = paramak.c();
/*  77 */     this.c = new d[i]; byte b;
/*  78 */     for (b = 0; b < i; b++) {
/*     */       d d1;
/*     */       
/*  81 */       (d1 = new d()).a(paramak);
/*  82 */       this.c[b] = d1;
/*     */     } 
/*  84 */     for (b = 0; b < i; b++)
/*     */     {
/*  86 */       this.c[b].a(this, paramap.w(), paramak);
/*     */     }
/*  88 */     this.a = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final d[] a() {
/*  96 */     return this.c;
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
/*     */   public final d a(int paramInt1, int paramInt2) {
/*     */     d[] arrayOfD;
/*     */     int i;
/*     */     byte b;
/* 112 */     for (i = (arrayOfD = this.c).length, b = 0; b < i; ) {
/*     */       d d1;
/* 114 */       if ((d1 = arrayOfD[b]).b() == paramInt1 && d1
/* 115 */         .a() == paramInt2)
/*     */       {
/* 117 */         return d1; } 
/*     */       b++;
/*     */     } 
/* 120 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\f\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */