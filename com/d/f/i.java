/*     */ package com.d.f;
/*     */ 
/*     */ import com.d.c.a.a;
/*     */ import com.d.c.a.c;
/*     */ import com.d.c.f.a.a;
/*     */ import com.d.c.f.a.h;
/*     */ import com.d.c.f.d;
/*     */ import com.d.e.v;
/*     */ import com.d.i.aa;
/*     */ import com.d.i.ab;
/*     */ import com.d.i.c;
/*     */ import com.d.i.f;
/*     */ import com.d.i.j;
/*     */ import java.awt.Rectangle;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class i
/*     */   extends c
/*     */ {
/*     */   private int a;
/*     */   private boolean b = false;
/*     */   private int c;
/*     */   private j d;
/*     */   private int e;
/*     */   private int f;
/*     */   
/*     */   public final c c() {
/*     */     i i1;
/*  54 */     (i1 = new i()).a(a());
/*  55 */     i1.a(ai());
/*     */     
/*  57 */     return i1;
/*     */   }
/*     */   
/*     */   public final boolean b_() {
/*  61 */     return (a().J() || !a().d(a.R));
/*     */   }
/*     */ 
/*     */   
/*     */   private d p() {
/*  66 */     return (d)U().U();
/*     */   }
/*     */   
/*     */   private j q() {
/*  70 */     return (j)U();
/*     */   }
/*     */   
/*     */   public final void a_(v paramv, int paramInt) {
/*  74 */     boolean bool = (paramv.r() && p().a().as()) ? true : false;
/*  75 */     int k = 0;
/*  76 */     int m = 0;
/*     */     
/*  78 */     if (bool) {
/*  79 */       k = paramv.A();
/*  80 */       m = paramv.z();
/*     */       
/*  82 */       g(paramv);
/*  83 */       v(paramv);
/*     */       
/*  85 */       paramv.b(paramv.A() + j());
/*  86 */       paramv.a(paramv.z() + o());
/*     */     } 
/*     */     
/*  89 */     super.a_(paramv, paramInt);
/*     */     
/*  91 */     if (bool) {
/*  92 */       if (f(paramv)) {
/*  93 */         if (p().j() == this) {
/*     */ 
/*     */ 
/*     */           
/*  97 */           p().e(true);
/*     */         } else {
/*  99 */           e(true);
/*     */         } 
/*     */       }
/* 102 */       paramv.b(k);
/* 103 */       paramv.a(m);
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean f(v paramv) {
/* 108 */     aa aa = paramv.p().a((d)paramv, (f)this);
/*     */     
/* 110 */     if (aa() + as() < aa.a()) {
/* 111 */       return false;
/*     */     }
/*     */     
/* 114 */     for (Iterator<f> iterator = W(); iterator.hasNext();) {
/*     */ 
/*     */       
/* 117 */       if ((k = (f = iterator.next()).e(paramv)) != Integer.MIN_VALUE && k < aa.a()) {
/* 118 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 122 */     return true;
/*     */   }
/*     */   
/*     */   public final void a(v paramv, j paramj) {
/* 126 */     if (p().a().as()) {
/* 127 */       this.d = new j(paramv, aa());
/* 128 */       this.d.a(paramj);
/*     */       
/* 130 */       if (paramj != null) {
/* 131 */         paramj.a(paramv, aa());
/* 132 */         paramj.b(paramv, aa() + as());
/*     */       } 
/*     */       
/* 135 */       for (Iterator<f> iterator = W(); iterator.hasNext();)
/*     */       {
/* 137 */         (f = iterator.next()).a(paramv, this.d);
/*     */       }
/*     */       
/* 140 */       if (paramj != null && this.d.c()) {
/* 141 */         a(paramv, paramj, this.d, j(), o()); return;
/*     */       } 
/*     */     } else {
/* 144 */       super.a(paramv, paramj);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void g(v paramv) {
/* 149 */     int k = 0;
/*     */     
/* 151 */     for (Iterator<f> iterator = W(); iterator.hasNext();) {
/*     */ 
/*     */ 
/*     */       
/* 155 */       if ((m = (int)(f = iterator.next()).o((d)paramv).t() + (int)f.b((d)paramv).t()) > k) {
/* 156 */         k = m;
/*     */       }
/*     */     } 
/*     */     
/* 160 */     this.e = k;
/*     */   }
/*     */   
/*     */   private void v(v paramv) {
/* 164 */     int k = 0;
/*     */     
/* 166 */     int m = ak();
/* 167 */     int n = q().g();
/*     */     List<?> list;
/* 169 */     if ((list = q().d()).size() > 0 && m < list.size()) {
/* 170 */       list = ((c)list.get(m)).a();
/* 171 */       for (byte b = 0; b < list.size(); b++) {
/*     */         f f;
/*     */         
/* 174 */         if ((f = (f)list.get(b)) != null && f != f.a)
/*     */         {
/*     */           
/* 177 */           if (m >= n - 1 || q().a(m + 1, b) != f) {
/*     */             int i1;
/*     */ 
/*     */ 
/*     */             
/* 182 */             if ((i1 = (int)f.o((d)paramv).v() + (int)f.b((d)paramv).v()) > k)
/* 183 */               k = i1; 
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/* 188 */     this.f = k;
/*     */   }
/*     */ 
/*     */   
/*     */   protected final void a(v paramv, int paramInt) {
/* 193 */     l(paramv);
/*     */     
/*     */     j j1;
/* 196 */     if ((j1 = q()).o()) {
/* 197 */       j1.g(paramv);
/* 198 */       j1.a(false);
/*     */     } 
/*     */     
/* 201 */     if (F() != 4)
/*     */     {
/* 203 */       for (Iterator<f> iterator = W(); iterator.hasNext(); ) {
/* 204 */         f f = iterator.next();
/*     */         
/* 206 */         b(paramv, f, 0);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void w(v paramv) {
/* 216 */     int[] arrayOfInt = new int[V()];
/* 217 */     int k = Integer.MIN_VALUE;
/* 218 */     int m = 0; byte b;
/* 219 */     for (b = 0; b < V(); b++) {
/*     */       f f;
/*     */       
/* 222 */       if ((f = (f)k(b)).j() == c.g) {
/* 223 */         m = f.d(paramv);
/* 224 */         arrayOfInt[b] = m;
/* 225 */         if (m > k) {
/* 226 */           k = m;
/*     */         }
/* 228 */         m = 1;
/*     */       } 
/*     */     } 
/*     */     
/* 232 */     if (m != 0) {
/* 233 */       for (b = 0; b < V(); b++) {
/*     */         f f;
/*     */         
/* 236 */         if ((f = (f)k(b)).j() == c.g && (
/*     */           
/* 238 */           m = k - arrayOfInt[b]) != 0) {
/* 239 */           if (paramv.r() && f.c(paramv, m)) {
/* 240 */             a(paramv, f, m);
/*     */           } else {
/* 242 */             f.c(m);
/* 243 */             f.t(f.as() + m);
/*     */           } 
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 249 */       b(k - aa());
/* 250 */       a(true);
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean x(v paramv) {
/* 255 */     boolean bool = false;
/*     */     
/* 257 */     int k = ak();
/* 258 */     int m = q().g();
/*     */     List<?> list;
/* 260 */     if ((list = q().d()).size() > 0 && k < list.size()) {
/* 261 */       list = ((c)list.get(k)).a();
/* 262 */       for (byte b = 0; b < list.size(); b++) {
/*     */         f f;
/*     */         
/* 265 */         if ((f = (f)list.get(b)) != null && f != f.a)
/*     */         {
/*     */           
/* 268 */           if (k >= m - 1 || q().a(k + 1, b) != f) {
/*     */             int n;
/*     */             
/*     */             c c1;
/*     */             
/* 273 */             if (((c1 = f.j()) == c.al || c1 == c.l) && (
/*     */               
/* 275 */               n = a(f, c1)) > 0) {
/* 276 */               if (paramv.r() && f.c(paramv, n)) {
/* 277 */                 int i1 = f.as();
/* 278 */                 a(paramv, f, n);
/* 279 */                 if (i1 + n != f.as()) {
/* 280 */                   bool = true;
/*     */                 }
/*     */               } else {
/* 283 */                 f.c(n);
/*     */ 
/*     */                 
/* 286 */                 f.t(f.as() + n);
/*     */               } 
/*     */             }
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/* 293 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int a(f paramf, c paramc) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: invokevirtual a : ()Lcom/d/c/f/c;
/*     */     //   4: invokevirtual an : ()I
/*     */     //   7: iconst_1
/*     */     //   8: if_icmpne -> 24
/*     */     //   11: aload_0
/*     */     //   12: invokevirtual as : ()I
/*     */     //   15: aload_1
/*     */     //   16: invokevirtual M : ()I
/*     */     //   19: isub
/*     */     //   20: istore_1
/*     */     //   21: goto -> 44
/*     */     //   24: aload_0
/*     */     //   25: invokevirtual aa : ()I
/*     */     //   28: aload_0
/*     */     //   29: invokevirtual as : ()I
/*     */     //   32: iadd
/*     */     //   33: aload_1
/*     */     //   34: invokevirtual aa : ()I
/*     */     //   37: aload_1
/*     */     //   38: invokevirtual M : ()I
/*     */     //   41: iadd
/*     */     //   42: isub
/*     */     //   43: istore_1
/*     */     //   44: aload_2
/*     */     //   45: getstatic com/d/c/a/c.al : Lcom/d/c/a/c;
/*     */     //   48: if_acmpne -> 55
/*     */     //   51: iload_1
/*     */     //   52: iconst_2
/*     */     //   53: idiv
/*     */     //   54: ireturn
/*     */     //   55: iload_1
/*     */     //   56: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #298	-> 0
/*     */     //   #299	-> 11
/*     */     //   #301	-> 24
/*     */     //   #304	-> 44
/*     */     //   #305	-> 51
/*     */     //   #307	-> 55
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void a(v paramv, a parama, h paramh1, h paramh2) {
/* 314 */     if (f() > 0) {
/* 315 */       t(f());
/*     */     }
/*     */     
/* 318 */     w(paramv);
/*     */     
/* 320 */     c((d)paramv);
/*     */     
/*     */     boolean bool;
/*     */     
/* 324 */     if (bool = x(paramv)) {
/* 325 */       c((d)paramv);
/*     */     }
/*     */     
/* 328 */     if (!t()) {
/* 329 */       y(paramv);
/*     */     }
/*     */     
/* 332 */     s();
/*     */   }
/*     */   
/*     */   private void c(d paramd) {
/* 336 */     int n, m = aa();
/*     */ 
/*     */     
/* 339 */     if (as() != 0) {
/* 340 */       n = m + as();
/*     */     } else {
/* 342 */       n = m;
/*     */     } 
/*     */     int k;
/* 345 */     if (r() && (
/*     */       
/* 347 */       k = p().c(paramd)) > 0 && k > n) {
/* 348 */       n = k;
/*     */     }
/*     */ 
/*     */     
/* 352 */     k = ak();
/* 353 */     int i1 = q().g();
/*     */     List<?> list;
/* 355 */     if ((list = q().d()).size() > 0 && k < list.size()) {
/* 356 */       list = ((c)list.get(k)).a();
/* 357 */       for (byte b = 0; b < list.size(); b++) {
/*     */         f f;
/*     */         
/* 360 */         if ((f = (f)list.get(b)) != null && f != f.a)
/*     */         {
/*     */           
/* 363 */           if (k >= i1 - 1 || q().a(k + 1, b) != f) {
/*     */             int i2;
/*     */ 
/*     */ 
/*     */             
/* 368 */             if ((i2 = f.aa() + f.as()) > n)
/* 369 */               n = i2; 
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/* 374 */     t(n - m);
/*     */   }
/*     */   
/*     */   private boolean r() {
/* 378 */     p();
/*     */     j j1;
/* 380 */     if (d.b(j1 = q(), true) == null) {
/* 381 */       return (j1.k(j1.V() - 1) == this);
/*     */     }
/* 383 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void y(v paramv) {
/* 388 */     int k = 0;
/* 389 */     int m = ak();
/* 390 */     int n = q().g();
/*     */     List<?> list;
/* 392 */     if ((list = q().d()).size() > 0 && m < list.size()) {
/* 393 */       list = ((c)list.get(m)).a();
/* 394 */       for (byte b = 0; b < list.size(); b++) {
/*     */         f f;
/*     */         
/* 397 */         if ((f = (f)list.get(b)) != null && f != f.a)
/*     */         {
/*     */           
/* 400 */           if (m >= n - 1 || q().a(m + 1, b) != f) {
/*     */             Rectangle rectangle;
/*     */ 
/*     */             
/*     */             int i1;
/*     */             
/* 406 */             if ((i1 = (rectangle = f.c(f.ab(), f.aa(), (d)paramv)).y + rectangle.height) > k)
/* 407 */               k = i1; 
/*     */           }  } 
/*     */       } 
/*     */     } 
/* 411 */     if (k > 0) {
/* 412 */       b(k - aa());
/*     */     }
/* 414 */     a(true);
/*     */   }
/*     */   
/*     */   private void s() {
/* 418 */     int k = ak();
/* 419 */     int m = q().g();
/*     */     List<?> list;
/* 421 */     if ((list = q().d()).size() > 0 && k < list.size()) {
/* 422 */       list = ((c)list.get(k)).a();
/* 423 */       for (byte b = 0; b < list.size(); b++) {
/*     */         f f;
/*     */         
/* 426 */         if ((f = (f)list.get(b)) != null && f != f.a)
/*     */         {
/*     */           
/* 429 */           if (k >= m - 1 || q().a(k + 1, b) != f)
/*     */           {
/*     */ 
/*     */             
/* 433 */             if (f.a().an() == 1) {
/* 434 */               f.t(as());
/*     */             } else {
/* 436 */               f.t(aa() + as() - f.aa());
/*     */             }  }  } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void a(v paramv, f paramf, int paramInt) {
/* 443 */     int k = paramf.Q();
/* 444 */     paramf.c(paramv);
/* 445 */     paramf.b(paramv, k);
/* 446 */     b(paramv, paramf, paramInt);
/*     */   }
/*     */   
/*     */   private static void b(v paramv, f paramf, int paramInt) {
/* 450 */     paramf.r(paramv);
/* 451 */     paramf.B();
/*     */     
/* 453 */     paramf.a_(paramv, paramInt);
/*     */   }
/*     */   
/*     */   public final void a(v paramv, c paramc, int paramInt) {
/* 457 */     n(0);
/*     */     
/* 459 */     d d = p();
/* 460 */     o(paramc.as() + d.a().g((d)paramv));
/* 461 */     paramv.a(0, an() - paramInt);
/*     */   }
/*     */   
/*     */   public final int d() {
/* 465 */     return this.a;
/*     */   }
/*     */   
/*     */   private void b(int paramInt) {
/* 469 */     this.a = paramInt;
/*     */   }
/*     */   
/*     */   protected final boolean n() {
/* 473 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void c(ab paramab) {}
/*     */ 
/*     */   
/*     */   public final void b(ab paramab) {}
/*     */ 
/*     */   
/*     */   public final void c(v paramv) {
/* 485 */     super.c(paramv);
/* 486 */     a(false);
/* 487 */     q().a(true);
/* 488 */     a((j)null);
/*     */   }
/*     */   
/*     */   private boolean t() {
/* 492 */     return this.b;
/*     */   }
/*     */   
/*     */   private void a(boolean paramBoolean) {
/* 496 */     this.b = paramBoolean;
/*     */   }
/*     */   
/*     */   protected final String a_() {
/* 500 */     if (t()) {
/* 501 */       return "(baseline=" + d() + ") ";
/*     */     }
/* 503 */     return "";
/*     */   }
/*     */ 
/*     */   
/*     */   public final int f() {
/* 508 */     return this.c;
/*     */   }
/*     */   
/*     */   public final void a(int paramInt) {
/* 512 */     this.c = paramInt;
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
/*     */   public final j g() {
/* 540 */     return this.d;
/*     */   }
/*     */   
/*     */   private void a(j paramj) {
/* 544 */     this.d = paramj;
/*     */   }
/*     */   
/*     */   public final int j() {
/* 548 */     return this.e;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int o() {
/* 556 */     return this.f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int a(v paramv, c paramc, boolean paramBoolean) {
/* 565 */     int k = super.a(paramv, paramc, paramBoolean);
/*     */ 
/*     */     
/* 568 */     if (paramv.r() && a().am()) {
/*     */       aa aa;
/*     */       
/* 571 */       if ((aa = paramv.p().a((d)paramv, aa() + k)) != null) {
/*     */ 
/*     */         
/* 574 */         int m = 0;
/* 575 */         for (Iterator<f> iterator = W(); iterator.hasNext();) {
/*     */ 
/*     */           
/* 578 */           if ((a = (f = iterator.next()).p()) != null) {
/* 579 */             m = Math.max(m, (int)a.t() / 2);
/*     */           }
/*     */         } 
/*     */ 
/*     */         
/* 584 */         int n = aa() + k + (int)n((d)paramv).t() - m;
/*     */         int i1;
/* 586 */         if ((i1 = aa.b() - n) > 0) {
/* 587 */           o(an() + i1);
/* 588 */           k += i1;
/*     */         } 
/*     */       } 
/*     */     } 
/* 592 */     return k;
/*     */   }
/*     */ 
/*     */   
/*     */   protected final c a(c.b paramb) {
/* 597 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\f\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */