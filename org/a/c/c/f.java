/*     */ package org.a.c.c;
/*     */ 
/*     */ import java.io.OutputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class f
/*     */   extends OutputStream
/*     */ {
/*  48 */   private int a = 0;
/*     */   
/*     */   private final byte[] b;
/*     */   private final int c;
/*     */   private final int d;
/*     */   private final int e;
/*     */   private int[] f;
/*     */   private int[] g;
/*  56 */   private int h = 0;
/*  57 */   private int i = 0;
/*  58 */   private int j = 0;
/*  59 */   private byte k = 0;
/*  60 */   private byte l = 0;
/*     */   
/*     */   private final int m;
/*     */   private final OutputStream n;
/*     */   
/*     */   f(OutputStream paramOutputStream, int paramInt1, int paramInt2, int paramInt3) {
/*  66 */     this.n = paramOutputStream;
/*  67 */     this.d = paramInt1;
/*  68 */     this.e = paramInt2;
/*  69 */     this.m = 1;
/*     */     
/*  71 */     this.g = new int[paramInt1];
/*  72 */     this.f = new int[paramInt1];
/*     */     
/*  74 */     this.c = (paramInt1 + 7) / 8;
/*  75 */     this.b = new byte[this.c];
/*     */   }
/*     */ 
/*     */   
/*     */   public final void write(int paramInt) {
/*  80 */     this.b[this.a] = (byte)paramInt;
/*  81 */     this.a++;
/*     */     
/*  83 */     if (this.a == this.c) {
/*  84 */       a();
/*  85 */       this.a = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void flush() {
/*  91 */     this.n.flush();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void close() {
/*  96 */     this.n.close();
/*     */   }
/*     */   
/*     */   private void a() {
/* 100 */     this.h++;
/* 101 */     int[] arrayOfInt = this.g;
/* 102 */     this.g = this.f;
/* 103 */     this.f = arrayOfInt;
/* 104 */     this.j = this.i;
/* 105 */     this.i = 0;
/*     */     
/* 107 */     byte b = 0;
/* 108 */     boolean bool = true;
/* 109 */     while (b < this.d) {
/* 110 */       int i = b / 8;
/* 111 */       int j = b % 8;
/* 112 */       if ((((this.b[i] >> 7 - j & 0x1) == 1) ? true : false) == bool) {
/* 113 */         this.f[this.i] = b;
/* 114 */         this.i++;
/* 115 */         bool = !bool ? true : false;
/*     */       } 
/* 117 */       b++;
/*     */     } 
/*     */     
/* 120 */     b();
/*     */     
/* 122 */     if (this.h == this.e) {
/* 123 */       d();
/* 124 */       d();
/* 125 */       e();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void b() {
/* 131 */     c();
/*     */   }
/*     */   
/*     */   private int[] a(int paramInt, boolean paramBoolean) {
/* 135 */     int[] arrayOfInt = { this.d, this.d };
/* 136 */     for (byte b = 0; b < this.i; b++) {
/* 137 */       if (paramInt < this.f[b] || (paramInt == 0 && paramBoolean)) {
/* 138 */         arrayOfInt[0] = this.f[b];
/* 139 */         if (b + 1 < this.i) {
/* 140 */           arrayOfInt[1] = this.f[b + 1];
/*     */         }
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 146 */     return arrayOfInt;
/*     */   }
/*     */   
/*     */   private void b(int paramInt, boolean paramBoolean) {
/* 150 */     int i = paramInt / 64;
/* 151 */     a[] arrayOfA = paramBoolean ? p : r;
/* 152 */     while (i > 0) {
/* 153 */       if (i >= arrayOfA.length) {
/* 154 */         a((arrayOfA[arrayOfA.length - 1]).a, (arrayOfA[arrayOfA.length - 1]).b);
/* 155 */         i -= arrayOfA.length;
/*     */         continue;
/*     */       } 
/* 158 */       a((arrayOfA[i - 1]).a, (arrayOfA[i - 1]).b);
/* 159 */       i = 0;
/*     */     } 
/*     */ 
/*     */     
/* 163 */     a a1 = paramBoolean ? o[paramInt % 64] : q[paramInt % 64];
/* 164 */     a(a1.a, a1.b);
/*     */   }
/*     */   
/*     */   private void c() {
/* 168 */     boolean bool = true;
/* 169 */     int i = 0;
/* 170 */     while (i < this.d) {
/* 171 */       int[] arrayOfInt1 = a(i, bool);
/*     */       
/* 173 */       int[] arrayOfInt2 = c(i, bool);
/*     */       
/* 175 */       int j = arrayOfInt1[0] - arrayOfInt2[0];
/* 176 */       if (arrayOfInt1[0] > arrayOfInt2[1]) {
/*     */         
/* 178 */         a(1, 4);
/* 179 */         i = arrayOfInt2[1]; continue;
/*     */       } 
/* 181 */       if (j > 3 || j < -3) {
/*     */         
/* 183 */         a(1, 3);
/* 184 */         b(arrayOfInt1[0] - i, bool);
/* 185 */         b(arrayOfInt1[1] - arrayOfInt1[0], !bool);
/* 186 */         i = arrayOfInt1[1];
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/* 191 */       switch (j) {
/*     */         case 0:
/* 193 */           a(1, 1);
/*     */           break;
/*     */         case 1:
/* 196 */           a(3, 3);
/*     */           break;
/*     */         case 2:
/* 199 */           a(3, 6);
/*     */           break;
/*     */         case 3:
/* 202 */           a(3, 7);
/*     */           break;
/*     */         case -1:
/* 205 */           a(2, 3);
/*     */           break;
/*     */         case -2:
/* 208 */           a(2, 6);
/*     */           break;
/*     */         case -3:
/* 211 */           a(2, 7);
/*     */           break;
/*     */       } 
/* 214 */       bool = !bool ? true : false;
/* 215 */       i = arrayOfInt2[0] + j;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private int[] c(int paramInt, boolean paramBoolean) {
/* 221 */     int[] arrayOfInt = { this.d, this.d };
/* 222 */     for (paramBoolean = !paramBoolean; paramBoolean < this.j; paramBoolean += true) {
/* 223 */       if (this.g[paramBoolean] > paramInt || (paramInt == 0 && !paramBoolean)) {
/* 224 */         arrayOfInt[0] = this.g[paramBoolean];
/* 225 */         if (paramBoolean + 1 < this.j) {
/* 226 */           arrayOfInt[1] = this.g[paramBoolean + 1];
/*     */         }
/*     */         break;
/*     */       } 
/*     */     } 
/* 231 */     return arrayOfInt;
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(int paramInt1, int paramInt2) {
/* 236 */     for (byte b = 0; b < paramInt2; b++) {
/* 237 */       boolean bool = ((paramInt1 >> paramInt2 - b - 1 & 0x1) == 1) ? true : false;
/* 238 */       if (this.m == 1) {
/* 239 */         this.k = (byte)(this.k | (bool ? (1 << 7 - this.l % 8) : 0));
/*     */       } else {
/*     */         
/* 242 */         this.k = (byte)(this.k | (bool ? (1 << this.l % 8) : 0));
/*     */       } 
/* 244 */       this.l = (byte)(this.l + 1);
/*     */       
/* 246 */       if (this.l == 8) {
/* 247 */         this.n.write(this.k);
/* 248 */         f();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void d() {
/* 254 */     a(1, 12);
/*     */   }
/*     */   
/*     */   private void e() {
/* 258 */     if (this.l != 0) {
/* 259 */       this.n.write(this.k);
/*     */     }
/* 261 */     f();
/*     */   }
/*     */   
/*     */   private void f() {
/* 265 */     this.k = 0;
/* 266 */     this.l = 0;
/*     */   }
/*     */   static class a { final int a;
/*     */     
/*     */     private a(int param1Int1, int param1Int2) {
/* 271 */       this.a = param1Int1;
/* 272 */       this.b = param1Int2;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     final int b; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 289 */   private static final a[] o = new a[64];
/* 290 */   private static final a[] p = new a[40]; static { byte b;
/* 291 */     for (b = 0; b < e.c.length; b++) {
/* 292 */       int i = b + 4;
/* 293 */       for (byte b1 = 0; b1 < (e.c[b]).length; b1++) {
/* 294 */         short s1 = e.d[b][b1];
/* 295 */         short s2 = e.c[b][b1];
/*     */         
/* 297 */         if (s1 < 64) {
/* 298 */           o[s1] = new a(s2, i, (byte)0);
/*     */         } else {
/*     */           
/* 301 */           p[s1 / 64 - 1] = new a(s2, i, (byte)0);
/*     */         } 
/*     */       } 
/*     */     }  }
/*     */   
/* 306 */   private static final a[] q = new a[64];
/* 307 */   private static final a[] r = new a[40]; static {
/* 308 */     for (b = 0; b < e.a.length; b++) {
/* 309 */       int i = b + 2;
/* 310 */       for (byte b1 = 0; b1 < (e.a[b]).length; b1++) {
/* 311 */         short s1 = e.b[b][b1];
/* 312 */         short s2 = e.a[b][b1];
/*     */         
/* 314 */         if (s1 < 64) {
/* 315 */           q[s1] = new a(s2, i, (byte)0);
/*     */         } else {
/*     */           
/* 318 */           r[s1 / 64 - 1] = new a(s2, i, (byte)0);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\c\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */