/*     */ package com.b.a.c;
/*     */ 
/*     */ import java.nio.BufferOverflowException;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class g
/*     */ {
/*  46 */   private char[] a = new char[100];
/*     */ 
/*     */   
/*     */   private int b;
/*     */   
/*     */   private int c;
/*     */ 
/*     */   
/*     */   public final void a() {
/*  55 */     this.b = this.c = 0;
/*     */   }
/*     */   
/*     */   private void b(int paramInt) {
/*  59 */     this.a[this.b - 1] = (char)paramInt;
/*     */   }
/*     */   private int e() {
/*  62 */     return (this.b > 0) ? this.a[this.b - 1] : 65535;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(int paramInt) {
/*  72 */     if (paramInt < 0) {
/*  73 */       throw new IllegalArgumentException("addUnchanged(" + paramInt + "): length must not be negative");
/*     */     }
/*     */     
/*     */     int i;
/*     */     
/*  78 */     if ((i = e()) < 4095) {
/*     */       int j;
/*  80 */       if ((j = 4095 - i) >= paramInt) {
/*  81 */         b(i + paramInt);
/*     */         return;
/*     */       } 
/*  84 */       b(4095);
/*  85 */       paramInt -= j;
/*     */     } 
/*     */     
/*  88 */     while (paramInt >= 4096) {
/*  89 */       c(4095);
/*  90 */       paramInt -= 4096;
/*     */     } 
/*     */     
/*  93 */     if (paramInt > 0) {
/*  94 */       c(paramInt - 1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(int paramInt1, int paramInt2) {
/* 105 */     if (paramInt1 == paramInt2 && paramInt1 > 0 && paramInt1 <= 6) {
/*     */ 
/*     */       
/* 108 */       int k = e();
/* 109 */       if (4095 < k && k < 28671 && k >> 12 == paramInt1 && (k & 0xFFF) < 4095) {
/*     */         
/* 111 */         b(k + 1);
/*     */         return;
/*     */       } 
/* 114 */       c(paramInt1 << 12);
/*     */       
/*     */       return;
/*     */     } 
/* 118 */     if (paramInt1 < 0 || paramInt2 < 0) {
/* 119 */       throw new IllegalArgumentException("addReplace(" + paramInt1 + ", " + paramInt2 + "): both lengths must be non-negative");
/*     */     }
/*     */ 
/*     */     
/* 123 */     if (paramInt1 == 0 && paramInt2 == 0) {
/*     */       return;
/*     */     }
/*     */     int i;
/* 127 */     if ((i = paramInt2 - paramInt1) != 0) {
/* 128 */       if ((i > 0 && this.c >= 0 && i > Integer.MAX_VALUE - this.c) || (i < 0 && this.c < 0 && i < Integer.MIN_VALUE - this.c))
/*     */       {
/*     */         
/* 131 */         throw new IndexOutOfBoundsException();
/*     */       }
/* 133 */       this.c += i;
/*     */     } 
/*     */ 
/*     */     
/* 137 */     if (paramInt1 < 61 && paramInt2 < 61) {
/*     */       
/* 139 */       i = (i = 0x7000 | paramInt1 << 6) | paramInt2;
/* 140 */       c(i); return;
/* 141 */     }  if (this.a.length - this.b < 5) f(); 
/* 142 */     int j = this.b + 1;
/* 143 */     if (paramInt1 < 61) {
/* 144 */       i = 0x7000 | paramInt1 << 6;
/* 145 */     } else if (paramInt1 <= 32767) {
/* 146 */       i = 32576;
/* 147 */       this.a[j++] = (char)(0x8000 | paramInt1);
/*     */     } else {
/* 149 */       i = 0x7000 | 62 + (paramInt1 >> 30) << 6;
/* 150 */       this.a[j++] = (char)(0x8000 | paramInt1 >> 15);
/* 151 */       this.a[j++] = (char)(0x8000 | paramInt1);
/*     */     } 
/* 153 */     if (paramInt2 < 61) {
/* 154 */       i |= paramInt2;
/* 155 */     } else if (paramInt2 <= 32767) {
/* 156 */       i |= 0x3D;
/* 157 */       this.a[j++] = (char)(0x8000 | paramInt2);
/*     */     } else {
/* 159 */       i |= 62 + (paramInt2 >> 30);
/* 160 */       this.a[j++] = (char)(0x8000 | paramInt2 >> 15);
/* 161 */       this.a[j++] = (char)(0x8000 | paramInt2);
/*     */     } 
/* 163 */     this.a[this.b] = (char)i;
/* 164 */     this.b = j;
/*     */   }
/*     */ 
/*     */   
/*     */   private void c(int paramInt) {
/* 169 */     if (this.b >= this.a.length) f(); 
/* 170 */     this.a[this.b++] = (char)paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean f() {
/*     */     int i;
/* 176 */     if (this.a.length == 100)
/* 177 */     { i = 2000; }
/* 178 */     else { if (this.a.length == Integer.MAX_VALUE)
/* 179 */         throw new BufferOverflowException(); 
/* 180 */       if (this.a.length >= 1073741823) {
/* 181 */         i = Integer.MAX_VALUE;
/*     */       } else {
/* 183 */         i = 2 * this.a.length;
/*     */       }  }
/*     */     
/* 186 */     if (i - this.a.length < 5) {
/* 187 */       throw new BufferOverflowException();
/*     */     }
/* 189 */     this.a = Arrays.copyOf(this.a, i);
/* 190 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int b() {
/* 199 */     return this.c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean c() {
/* 206 */     if (this.c != 0) {
/* 207 */       return true;
/*     */     }
/* 209 */     for (byte b = 0; b < this.b; b++) {
/* 210 */       if (this.a[b] > '࿿') {
/* 211 */         return true;
/*     */       }
/*     */     } 
/* 214 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class a
/*     */   {
/*     */     private final char[] a;
/*     */     
/*     */     private int b;
/*     */     
/*     */     private final int c;
/*     */     private int d;
/*     */     private final boolean e;
/*     */     private final boolean f;
/*     */     private boolean g;
/*     */     private int h;
/*     */     private int i;
/*     */     private int j;
/*     */     private int k;
/*     */     private int l;
/*     */     
/*     */     private a(char[] param1ArrayOfchar, int param1Int, boolean param1Boolean1, boolean param1Boolean2) {
/* 236 */       this.a = param1ArrayOfchar;
/* 237 */       this.c = param1Int;
/* 238 */       this.e = param1Boolean1;
/* 239 */       this.f = param1Boolean2;
/*     */     }
/*     */     
/*     */     private int a(int param1Int) {
/* 243 */       if (param1Int < 61)
/* 244 */         return param1Int; 
/* 245 */       if (param1Int < 62) {
/* 246 */         if (!m && this.b >= this.c) throw new AssertionError(); 
/* 247 */         if (!m && this.a[this.b] < '耀') throw new AssertionError(); 
/* 248 */         return this.a[this.b++] & 0x7FFF;
/*     */       } 
/* 250 */       if (!m && this.b + 2 > this.c) throw new AssertionError(); 
/* 251 */       if (!m && this.a[this.b] < '耀') throw new AssertionError(); 
/* 252 */       if (!m && this.a[this.b + 1] < '耀') throw new AssertionError(); 
/* 253 */       param1Int = (param1Int & 0x1) << 30 | (this.a[this.b] & 0x7FFF) << 15 | this.a[this.b + 1] & 0x7FFF;
/*     */ 
/*     */       
/* 256 */       this.b += 2;
/* 257 */       return param1Int;
/*     */     }
/*     */ 
/*     */     
/*     */     private void g() {
/* 262 */       this.j += this.h;
/* 263 */       if (this.g) {
/* 264 */         this.k += this.i;
/*     */       }
/* 266 */       this.l += this.i;
/*     */     }
/*     */ 
/*     */     
/*     */     private boolean h() {
/* 271 */       this.g = false;
/* 272 */       this.h = this.i = 0;
/* 273 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean a() {
/* 283 */       return a(this.e);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private boolean a(boolean param1Boolean) {
/* 289 */       g();
/* 290 */       if (this.d > 0) {
/*     */         
/* 292 */         this.d--;
/* 293 */         return true;
/*     */       } 
/* 295 */       if (this.b >= this.c) {
/* 296 */         return h();
/*     */       }
/*     */       int i;
/* 299 */       if ((i = this.a[this.b++]) <= '࿿') {
/*     */         
/* 301 */         this.g = false;
/* 302 */         this.h = i + 1;
/* 303 */         while (this.b < this.c && (i = this.a[this.b]) <= '࿿') {
/* 304 */           this.b++;
/* 305 */           this.h += i + 1;
/*     */         } 
/* 307 */         this.i = this.h;
/* 308 */         if (param1Boolean) {
/* 309 */           g();
/* 310 */           if (this.b >= this.c) {
/* 311 */             return h();
/*     */           }
/*     */           
/* 314 */           this.b++;
/*     */         } else {
/* 316 */           return true;
/*     */         } 
/*     */       } 
/* 319 */       this.g = true;
/* 320 */       if (i <= 28671) {
/* 321 */         if (this.f) {
/* 322 */           int j = i >> 12;
/* 323 */           i = (i & 0xFFF) + 1;
/* 324 */           this.h = this.i = i * j;
/*     */         } else {
/*     */           
/* 327 */           this.h = this.i = i >> 12;
/* 328 */           this.d = i & 0xFFF;
/* 329 */           return true;
/*     */         } 
/*     */       } else {
/* 332 */         if (!m && i > 32767) throw new AssertionError(); 
/* 333 */         this.h = a(i >> 6 & 0x3F);
/* 334 */         this.i = a(i & 0x3F);
/* 335 */         if (!this.f) {
/* 336 */           return true;
/*     */         }
/*     */       } 
/*     */       
/* 340 */       while (this.b < this.c && (i = this.a[this.b]) > 4095) {
/* 341 */         this.b++;
/* 342 */         if (i <= 28671) {
/* 343 */           int k = i >> 12;
/*     */           
/* 345 */           i = (i = (i & 0xFFF) + 1) * k;
/* 346 */           this.h += i;
/* 347 */           this.i += i; continue;
/*     */         } 
/* 349 */         if (!m && i > 32767) throw new AssertionError(); 
/* 350 */         int j = a(i >> 6 & 0x3F);
/* 351 */         i = a(i & 0x3F);
/* 352 */         this.h += j;
/* 353 */         this.i += i;
/*     */       } 
/*     */       
/* 356 */       return true;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean b() {
/* 417 */       return this.g;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final int c() {
/* 423 */       return this.h;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final int d() {
/* 430 */       return this.i;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final int e() {
/* 437 */       return this.j;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final int f() {
/* 444 */       return this.k;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final a d() {
/* 471 */     return new a(this.a, this.b, false, true, (byte)0);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\b\a\c\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */