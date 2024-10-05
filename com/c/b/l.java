/*     */ package com.c.b;
/*     */ 
/*     */ import com.c.a.a;
/*     */ import com.c.a.b;
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
/*     */ public class l
/*     */ {
/*     */   private int s;
/*     */   public int a;
/*     */   public int b;
/*     */   private int t;
/*     */   private int u;
/*     */   private int v;
/*     */   
/*     */   static {
/*  35 */     "vorbis".getBytes();
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
/*  69 */   int[] c = new int[2];
/*     */ 
/*     */   
/*     */   int d;
/*     */   
/*     */   private int w;
/*     */   
/*     */   int e;
/*     */   
/*     */   int f;
/*     */   
/*     */   int g;
/*     */   
/*     */   int h;
/*     */   
/*  84 */   o[] i = null;
/*     */   
/*  86 */   int[] j = null;
/*  87 */   Object[] k = null;
/*     */   
/*  89 */   int[] l = null;
/*  90 */   Object[] m = null;
/*     */   
/*  92 */   int[] n = null;
/*  93 */   Object[] o = null;
/*     */   
/*  95 */   int[] p = null;
/*  96 */   Object[] q = null;
/*     */   
/*  98 */   v[] r = null;
/*     */   
/* 100 */   private r[] x = new r[64];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a() {
/* 109 */     this.b = 0;
/*     */   }
/*     */   public final void b() {
/*     */     byte b;
/* 113 */     for (b = 0; b < this.d; b++) {
/* 114 */       this.i[b] = null;
/*     */     }
/* 116 */     this.i = null;
/*     */     
/* 118 */     for (b = 0; b < this.w; b++);
/*     */ 
/*     */     
/* 121 */     this.k = null;
/*     */     
/* 123 */     for (b = 0; b < this.e; b++);
/*     */ 
/*     */     
/* 126 */     this.m = null;
/*     */     
/* 128 */     for (b = 0; b < this.f; b++);
/*     */ 
/*     */     
/* 131 */     this.o = null;
/*     */     
/* 133 */     for (b = 0; b < this.g; b++);
/*     */ 
/*     */     
/* 136 */     this.q = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 142 */     for (b = 0; b < this.h; b++) {
/*     */       
/* 144 */       if (this.r[b] != null)
/*     */       {
/* 146 */         this.r[b] = null;
/*     */       }
/*     */     } 
/*     */     
/* 150 */     this.r = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int a(a parama) {
/* 160 */     this.s = parama.c(32);
/* 161 */     if (this.s != 0) {
/* 162 */       return -1;
/*     */     }
/* 164 */     this.a = parama.c(8);
/* 165 */     this.b = parama.c(32);
/*     */     
/* 167 */     this.t = parama.c(32);
/* 168 */     this.u = parama.c(32);
/* 169 */     this.v = parama.c(32);
/*     */     
/* 171 */     this.c[0] = 1 << parama.c(4);
/* 172 */     this.c[1] = 1 << parama.c(4);
/*     */     
/* 174 */     if (this.b <= 0 || this.a <= 0 || this.c[0] < 8 || this.c[1] < this.c[0] || parama.c(1) != 1) {
/*     */       
/* 176 */       b();
/* 177 */       return -1;
/*     */     } 
/* 179 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int b(a parama) {
/* 186 */     this.h = parama.c(8) + 1;
/*     */     
/* 188 */     if (this.r == null || this.r.length != this.h)
/* 189 */       this.r = new v[this.h];  byte b;
/* 190 */     for (b = 0; b < this.h; b++) {
/* 191 */       this.r[b] = new v();
/* 192 */       if (this.r[b].a(parama) != 0) {
/* 193 */         b();
/* 194 */         return -1;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 199 */     this.e = parama.c(6) + 1;
/* 200 */     if (this.l == null || this.l.length != this.e)
/* 201 */       this.l = new int[this.e]; 
/* 202 */     if (this.m == null || this.m.length != this.e)
/* 203 */       this.m = new Object[this.e]; 
/* 204 */     for (b = 0; b < this.e; b++) {
/* 205 */       this.l[b] = parama.c(16);
/* 206 */       if (this.l[b] < 0 || this.l[b] > 0) {
/* 207 */         b();
/* 208 */         return -1;
/*     */       } 
/* 210 */       this.m[b] = k.a[this.l[b]].a();
/* 211 */       if (this.m[b] == null) {
/* 212 */         b();
/* 213 */         return -1;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 218 */     this.f = parama.c(6) + 1;
/* 219 */     if (this.n == null || this.n.length != this.f)
/* 220 */       this.n = new int[this.f]; 
/* 221 */     if (this.o == null || this.o.length != this.f) {
/* 222 */       this.o = new Object[this.f];
/*     */     }
/* 224 */     for (b = 0; b < this.f; b++) {
/* 225 */       this.n[b] = parama.c(16);
/* 226 */       if (this.n[b] < 0 || this.n[b] >= 2) {
/* 227 */         b();
/* 228 */         return -1;
/*     */       } 
/*     */       
/* 231 */       this.o[b] = h.a[this.n[b]].a(this, parama);
/* 232 */       if (this.o[b] == null) {
/* 233 */         b();
/* 234 */         return -1;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 239 */     this.g = parama.c(6) + 1;
/*     */     
/* 241 */     if (this.p == null || this.p.length != this.g) {
/* 242 */       this.p = new int[this.g];
/*     */     }
/* 244 */     if (this.q == null || this.q.length != this.g) {
/* 245 */       this.q = new Object[this.g];
/*     */     }
/* 247 */     for (b = 0; b < this.g; b++) {
/* 248 */       this.p[b] = parama.c(16);
/* 249 */       if (this.p[b] < 0 || this.p[b] >= 3) {
/* 250 */         b();
/* 251 */         return -1;
/*     */       } 
/* 253 */       this.q[b] = j.a[this.p[b]].a(this, parama);
/* 254 */       if (this.q[b] == null) {
/* 255 */         b();
/* 256 */         return -1;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 261 */     this.w = parama.c(6) + 1;
/* 262 */     if (this.j == null || this.j.length != this.w)
/* 263 */       this.j = new int[this.w]; 
/* 264 */     if (this.k == null || this.k.length != this.w)
/* 265 */       this.k = new Object[this.w]; 
/* 266 */     for (b = 0; b < this.w; b++) {
/* 267 */       this.j[b] = parama.c(16);
/* 268 */       if (this.j[b] < 0 || this.j[b] > 0) {
/* 269 */         b();
/* 270 */         return -1;
/*     */       } 
/* 272 */       this.k[b] = i.a[this.j[b]].a(this, parama);
/* 273 */       if (this.k[b] == null) {
/* 274 */         b();
/* 275 */         return -1;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 280 */     this.d = parama.c(6) + 1;
/* 281 */     if (this.i == null || this.i.length != this.d)
/* 282 */       this.i = new o[this.d]; 
/* 283 */     for (b = 0; b < this.d; b++) {
/* 284 */       this.i[b] = new o();
/* 285 */       (this.i[b]).a = parama.c(1);
/* 286 */       (this.i[b]).b = parama.c(16);
/* 287 */       (this.i[b]).c = parama.c(16);
/* 288 */       (this.i[b]).d = parama.c(8);
/*     */       
/* 290 */       if ((this.i[b]).b > 0 || (this.i[b]).c > 0 || (this.i[b]).d >= this.w) {
/*     */ 
/*     */         
/* 293 */         b();
/* 294 */         return -1;
/*     */       } 
/*     */     } 
/*     */     
/* 298 */     if (parama.c(1) != 1) {
/* 299 */       b();
/* 300 */       return -1;
/*     */     } 
/*     */     
/* 303 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int a(c paramc, b paramb) {
/* 312 */     a a = new a();
/*     */     
/* 314 */     if (paramb != null) {
/* 315 */       a.a(paramb.a, paramb.b, paramb.c);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 320 */       byte[] arrayOfByte = new byte[6];
/* 321 */       int i = a.c(8);
/* 322 */       a.a(arrayOfByte, 6);
/* 323 */       if (arrayOfByte[0] != 118 || arrayOfByte[1] != 111 || arrayOfByte[2] != 114 || arrayOfByte[3] != 98 || arrayOfByte[4] != 105 || arrayOfByte[5] != 115)
/*     */       {
/*     */         
/* 326 */         return -1;
/*     */       }
/* 328 */       switch (i) {
/*     */         case 1:
/* 330 */           if (paramb.d == 0)
/*     */           {
/* 332 */             return -1;
/*     */           }
/* 334 */           if (this.b != 0)
/*     */           {
/* 336 */             return -1;
/*     */           }
/* 338 */           return a(a);
/*     */         case 3:
/* 340 */           if (this.b == 0)
/*     */           {
/* 342 */             return -1;
/*     */           }
/* 344 */           return paramc.a(a);
/*     */         case 5:
/* 346 */           if (this.b == 0 || paramc.a == null)
/*     */           {
/* 348 */             return -1;
/*     */           }
/* 350 */           return b(a);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     } 
/* 358 */     return -1;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 465 */     return "version:" + Integer.valueOf(this.s) + ", channels:" + Integer.valueOf(this.a) + ", rate:" + Integer.valueOf(this.b) + ", bitrate:" + Integer.valueOf(this.t) + "," + Integer.valueOf(this.u) + "," + Integer.valueOf(this.v);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\c\b\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */