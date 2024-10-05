/*     */ package com.c.b;
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
/*     */ final class p
/*     */   extends i
/*     */ {
/*     */   final Object a(e parame, o paramo, Object paramObject) {
/*  42 */     l l = parame.a;
/*     */     b b;
/*  44 */     paramObject = (b = new b(this)).b = (a)paramObject;
/*  45 */     b.a = paramo;
/*     */     
/*  47 */     b.c = new Object[((a)paramObject).a];
/*  48 */     b.d = new Object[((a)paramObject).a];
/*  49 */     b.e = new Object[((a)paramObject).a];
/*     */     
/*  51 */     b.f = new k[((a)paramObject).a];
/*  52 */     b.g = new h[((a)paramObject).a];
/*  53 */     b.h = new j[((a)paramObject).a];
/*     */     
/*  55 */     for (byte b1 = 0; b1 < ((a)paramObject).a; b1++) {
/*  56 */       int j = ((a)paramObject).c[b1];
/*  57 */       int k = ((a)paramObject).d[b1];
/*  58 */       int m = ((a)paramObject).e[b1];
/*     */       
/*  60 */       b.f[b1] = k.a[l.l[j]];
/*  61 */       b.c[b1] = b.f[b1].b();
/*  62 */       b.g[b1] = h.a[l.n[k]];
/*  63 */       b.d[b1] = b.g[b1].a(parame, paramo, l.o[k]);
/*     */       
/*  65 */       b.h[b1] = j.a[l.p[m]];
/*  66 */       b.e[b1] = b.h[b1].a(parame, paramo, l.q[m]);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  77 */     return b;
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
/*     */   final Object a(l paraml, com.c.a.a parama) {
/* 126 */     a a1 = new a(this);
/*     */     
/* 128 */     if (parama.c(1) != 0) {
/* 129 */       a1.a = parama.c(4) + 1;
/*     */     } else {
/*     */       
/* 132 */       a1.a = 1;
/*     */     } 
/*     */     
/* 135 */     if (parama.c(1) != 0) {
/* 136 */       a1.f = parama.c(8) + 1;
/*     */       
/* 138 */       for (byte b1 = 0; b1 < a1.f; b1++) {
/* 139 */         int j = a1.g[b1] = parama.c(o.b(paraml.a));
/* 140 */         int k = a1.h[b1] = parama.c(o.b(paraml.a));
/*     */         
/* 142 */         if (j < 0 || k < 0 || j == k || j >= paraml.a || k >= paraml.a) {
/*     */ 
/*     */           
/* 145 */           a1.a();
/* 146 */           return null;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 151 */     if (parama.c(2) > 0) {
/* 152 */       a1.a();
/* 153 */       return null;
/*     */     } 
/*     */     
/* 156 */     if (a1.a > 1) {
/* 157 */       for (byte b1 = 0; b1 < paraml.a; b1++) {
/* 158 */         a1.b[b1] = parama.c(4);
/* 159 */         if (a1.b[b1] >= a1.a) {
/* 160 */           a1.a();
/* 161 */           return null;
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 166 */     for (byte b = 0; b < a1.a; b++) {
/* 167 */       a1.c[b] = parama.c(8);
/* 168 */       if (a1.c[b] >= paraml.e) {
/* 169 */         a1.a();
/* 170 */         return null;
/*     */       } 
/* 172 */       a1.d[b] = parama.c(8);
/* 173 */       if (a1.d[b] >= paraml.f) {
/* 174 */         a1.a();
/* 175 */         return null;
/*     */       } 
/* 177 */       a1.e[b] = parama.c(8);
/* 178 */       if (a1.e[b] >= paraml.g) {
/* 179 */         a1.a();
/* 180 */         return null;
/*     */       } 
/*     */     } 
/* 183 */     return a1;
/*     */   }
/*     */   
/* 186 */   private float[][] b = (float[][])null;
/* 187 */   private int[] c = null;
/* 188 */   private int[] d = null;
/* 189 */   private Object[] e = null;
/*     */   
/*     */   final synchronized int a(a parama, Object paramObject) {
/*     */     e e;
/* 193 */     l l = (e = parama.k).a;
/*     */     
/* 195 */     a a1 = ((b)(paramObject = paramObject)).b;
/* 196 */     o o = ((b)paramObject).a;
/* 197 */     int j = parama.f = l.c[parama.d];
/*     */     
/* 199 */     float[] arrayOfFloat = e.c[parama.d][parama.c][parama.e][o.b];
/* 200 */     if (this.b == null || this.b.length < l.a) {
/* 201 */       this.b = new float[l.a][];
/* 202 */       this.d = new int[l.a];
/* 203 */       this.c = new int[l.a];
/* 204 */       this.e = new Object[l.a];
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*     */     int k;
/*     */ 
/*     */ 
/*     */     
/* 213 */     for (k = 0; k < l.a; k++) {
/* 214 */       float[] arrayOfFloat1 = parama.a[k];
/* 215 */       int m = a1.b[k];
/*     */       
/* 217 */       this.e[k] = ((b)paramObject).g[m].a(parama, ((b)paramObject).d[m], this.e[k]);
/*     */       
/* 219 */       if (this.e[k] != null) {
/* 220 */         this.d[k] = 1;
/*     */       } else {
/*     */         
/* 223 */         this.d[k] = 0;
/*     */       } 
/* 225 */       for (byte b = 0; b < j / 2; b++) {
/* 226 */         arrayOfFloat1[b] = 0.0F;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 231 */     for (k = 0; k < a1.f; k++) {
/* 232 */       if (this.d[a1.g[k]] != 0 || this.d[a1.h[k]] != 0) {
/* 233 */         this.d[a1.g[k]] = 1;
/* 234 */         this.d[a1.h[k]] = 1;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 240 */     for (k = 0; k < a1.a; k++) {
/* 241 */       byte b1 = 0;
/* 242 */       for (byte b2 = 0; b2 < l.a; b2++) {
/* 243 */         if (a1.b[b2] == k) {
/* 244 */           if (this.d[b2] != 0) {
/* 245 */             this.c[b1] = 1;
/*     */           } else {
/*     */             
/* 248 */             this.c[b1] = 0;
/*     */           } 
/* 250 */           this.b[b1++] = parama.a[b2];
/*     */         } 
/*     */       } 
/*     */       
/* 254 */       ((b)paramObject).h[k].a(parama, ((b)paramObject).e[k], this.b, this.c, b1);
/*     */     } 
/*     */ 
/*     */     
/* 258 */     for (k = a1.f - 1; k >= 0; k--) {
/* 259 */       float[] arrayOfFloat1 = parama.a[a1.g[k]];
/* 260 */       float[] arrayOfFloat2 = parama.a[a1.h[k]];
/*     */       
/* 262 */       for (byte b = 0; b < j / 2; b++) {
/* 263 */         float f1 = arrayOfFloat1[b];
/* 264 */         float f2 = arrayOfFloat2[b];
/*     */         
/* 266 */         if (f1 > 0.0F) {
/* 267 */           if (f2 > 0.0F) {
/* 268 */             arrayOfFloat1[b] = f1;
/* 269 */             arrayOfFloat2[b] = f1 - f2;
/*     */           } else {
/*     */             
/* 272 */             arrayOfFloat2[b] = f1;
/* 273 */             arrayOfFloat1[b] = f1 + f2;
/*     */           }
/*     */         
/*     */         }
/* 277 */         else if (f2 > 0.0F) {
/* 278 */           arrayOfFloat1[b] = f1;
/* 279 */           arrayOfFloat2[b] = f1 + f2;
/*     */         } else {
/*     */           
/* 282 */           arrayOfFloat2[b] = f1;
/* 283 */           arrayOfFloat1[b] = f1 - f2;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 291 */     for (k = 0; k < l.a; k++) {
/* 292 */       float[] arrayOfFloat1 = parama.a[k];
/* 293 */       int m = a1.b[k];
/* 294 */       ((b)paramObject).g[m].a(parama, ((b)paramObject).d[m], this.e[k], arrayOfFloat1);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 301 */     for (k = 0; k < l.a; k++) {
/* 302 */       float[] arrayOfFloat1 = parama.a[k];
/*     */       
/* 304 */       ((q)e.d[parama.d][0]).a(arrayOfFloat1, arrayOfFloat1);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 311 */     for (k = 0; k < l.a; k++) {
/* 312 */       float[] arrayOfFloat1 = parama.a[k];
/* 313 */       if (this.d[k] != 0) {
/* 314 */         for (byte b = 0; b < j; b++) {
/* 315 */           arrayOfFloat1[b] = arrayOfFloat1[b] * arrayOfFloat[b];
/*     */         }
/*     */       } else {
/*     */         
/* 319 */         for (byte b = 0; b < j; b++) {
/* 320 */           arrayOfFloat1[b] = 0.0F;
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 328 */     return 0;
/*     */   }
/*     */   
/*     */   class a {
/*     */     int a;
/* 333 */     int[] b = new int[256];
/*     */     
/* 335 */     int[] c = new int[16];
/* 336 */     int[] d = new int[16];
/* 337 */     int[] e = new int[16];
/*     */     
/*     */     int f;
/*     */     
/* 341 */     int[] g = new int[256];
/* 342 */     int[] h = new int[256];
/*     */     
/*     */     final void a() {
/* 345 */       this.b = null;
/* 346 */       this.c = null;
/* 347 */       this.d = null;
/* 348 */       this.e = null;
/*     */ 
/*     */       
/* 351 */       this.g = null;
/* 352 */       this.h = null;
/*     */     }
/*     */     
/*     */     a(p this$0) {}
/*     */   }
/*     */   
/*     */   class b {
/*     */     o a;
/*     */     p.a b;
/*     */     Object[] c;
/*     */     Object[] d;
/*     */     Object[] e;
/*     */     k[] f;
/*     */     h[] g;
/*     */     j[] h;
/*     */     
/*     */     b(p this$0) {}
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\c\b\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */