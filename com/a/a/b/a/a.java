/*     */ package com.a.a.b.a;
/*     */ 
/*     */ import com.a.a.b.d.b;
/*     */ import com.a.a.b.d.f;
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.b.n;
/*     */ import com.a.a.b.p;
/*     */ import com.a.a.b.r;
/*     */ import java.io.InputStream;
/*     */ import java.math.BigDecimal;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class a
/*     */   extends h
/*     */ {
/*  32 */   private static int e = h.a.g
/*  33 */     .b() | h.a.f
/*  34 */     .b() | h.a.i
/*  35 */     .b();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private p f;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int g;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected f d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected a(int paramInt, p paramp) {
/* 107 */     this.g = paramInt;
/* 108 */     this.f = paramp;
/*     */     
/* 110 */     b b = h.a.i.a(paramInt) ? b.a(this) : null;
/* 111 */     this.d = f.b(b);
/* 112 */     this.c = h.a.g.a(paramInt);
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
/*     */   public final void a(Object paramObject) {
/* 142 */     if (this.d != null) {
/* 143 */       this.d.a(paramObject);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean b(h.a parama) {
/* 154 */     return ((this.g & parama.b()) != 0); } public final int b() {
/* 155 */     return this.g;
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
/*     */   public h a(h.a parama) {
/* 182 */     int i = parama.b();
/* 183 */     this.g &= i ^ 0xFFFFFFFF;
/* 184 */     if ((i & e) != 0) {
/* 185 */       if (parama == h.a.g) {
/* 186 */         this.c = false;
/* 187 */       } else if (parama == h.a.f) {
/* 188 */         b(0);
/* 189 */       } else if (parama == h.a.i) {
/* 190 */         this.d = this.d.a(null);
/*     */       } 
/*     */     }
/* 193 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public final h a(int paramInt) {
/* 199 */     int i = paramInt ^ this.g;
/* 200 */     this.g = paramInt;
/* 201 */     if (i != 0) {
/* 202 */       b(paramInt, i);
/*     */     }
/* 204 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public final h a(int paramInt1, int paramInt2) {
/*     */     int i;
/* 210 */     paramInt1 = (i = this.g) & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2;
/*     */     
/* 212 */     if ((paramInt2 = i ^ paramInt1) != 0) {
/* 213 */       this.g = paramInt1;
/* 214 */       b(paramInt1, paramInt2);
/*     */     } 
/* 216 */     return this;
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
/*     */   protected void b(int paramInt1, int paramInt2) {
/* 231 */     if ((paramInt2 & e) == 0) {
/*     */       return;
/*     */     }
/* 234 */     this.c = h.a.g.a(paramInt1);
/* 235 */     if (h.a.f.a(paramInt2)) {
/* 236 */       if (h.a.f.a(paramInt1)) {
/* 237 */         b(127);
/*     */       } else {
/* 239 */         b(0);
/*     */       } 
/*     */     }
/* 242 */     if (h.a.i.a(paramInt2)) {
/* 243 */       if (h.a.i.a(paramInt1)) {
/* 244 */         if (this.d.m() == null) {
/* 245 */           this.d = this.d.a(b.a(this)); return;
/*     */         } 
/*     */       } else {
/* 248 */         this.d = this.d.a(null);
/*     */       } 
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
/*     */ 
/*     */ 
/*     */   
/*     */   public final n a() {
/* 279 */     return (n)this.d;
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
/*     */   public void c(Object paramObject) {
/* 295 */     i();
/* 296 */     if (paramObject != null) {
/* 297 */       a(paramObject);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void b(r paramr) {
/* 308 */     a(paramr.a());
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
/*     */   public void c(r paramr) {
/* 323 */     b(paramr.a());
/*     */   }
/*     */   
/*     */   public final void d(String paramString) {
/* 327 */     g("write raw value");
/* 328 */     c(paramString);
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
/*     */   public final void e(r paramr) {
/* 342 */     g("write raw value");
/* 343 */     d(paramr);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int a(com.a.a.b.a parama, InputStream paramInputStream, int paramInt) {
/* 349 */     n();
/* 350 */     return 0;
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
/*     */   public final void h(Object paramObject) {
/* 379 */     if (paramObject == null) {
/*     */       
/* 381 */       k();
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */     
/* 388 */     if (this.f != null) {
/* 389 */       this.f.a(this, paramObject);
/*     */       return;
/*     */     } 
/* 392 */     i(paramObject);
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
/*     */   public void close() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void o();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void g(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final String b(BigDecimal paramBigDecimal) {
/* 469 */     if (h.a.h.a(this.g)) {
/*     */       int i;
/*     */       
/* 472 */       if ((i = paramBigDecimal.scale()) < -9999 || i > 9999)
/* 473 */         f(String.format("Attempt to write plain `java.math.BigDecimal` (see JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN) with illegal scale (%d): needs to be between [-%d, %d]", new Object[] {
/*     */                 
/* 475 */                 Integer.valueOf(i), Integer.valueOf(9999), Integer.valueOf(9999)
/*     */               })); 
/* 477 */       return paramBigDecimal.toPlainString();
/*     */     } 
/* 479 */     return paramBigDecimal.toString();
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
/*     */   protected final void b(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 511 */     if (paramArrayOfbyte == null) {
/* 512 */       f("Invalid `byte[]` argument: `null`");
/*     */     }
/* 514 */     int i = paramArrayOfbyte.length;
/* 515 */     int j = paramInt1 + paramInt2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 526 */     if ((j = paramInt1 | paramInt2 | j | i - j) < 0) {
/* 527 */       f(String.format("Invalid 'offset' (%d) and/or 'len' (%d) arguments for `byte[]` of length %d", new Object[] {
/*     */               
/* 529 */               Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i)
/*     */             }));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void c(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 537 */     if (paramArrayOfchar == null) {
/* 538 */       f("Invalid `char[]` argument: `null`");
/*     */     }
/* 540 */     int i = paramArrayOfchar.length;
/* 541 */     int j = paramInt1 + paramInt2;
/*     */ 
/*     */     
/* 544 */     if ((j = paramInt1 | paramInt2 | j | i - j) < 0)
/* 545 */       f(String.format("Invalid 'offset' (%d) and/or 'len' (%d) arguments for `char[]` of length %d", new Object[] {
/*     */               
/* 547 */               Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i)
/*     */             })); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\a\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */