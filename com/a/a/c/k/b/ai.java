/*     */ package com.a.a.c.k.b;
/*     */ 
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.aa;
/*     */ import com.a.a.c.i.i;
/*     */ import com.a.a.c.k.j;
/*     */ import com.a.a.c.l.o;
/*     */ import com.a.a.c.o;
/*     */ import com.a.a.c.z;
/*     */ import java.util.HashMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ai
/*     */ {
/*     */   private static HashMap<String, o<?>> a;
/*     */   
/*     */   static {
/*  29 */     (a = new HashMap<>()).put(boolean[].class.getName(), new a());
/*  30 */     a.put(byte[].class.getName(), new g());
/*  31 */     a.put(char[].class.getName(), new b());
/*  32 */     a.put(short[].class.getName(), new g());
/*  33 */     a.put(int[].class.getName(), new e());
/*  34 */     a.put(long[].class.getName(), new f());
/*  35 */     a.put(float[].class.getName(), new d());
/*  36 */     a.put(double[].class.getName(), new c());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static o<?> a(Class<?> paramClass) {
/*  46 */     return a.get(paramClass.getName());
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
/*     */   public static abstract class h<T>
/*     */     extends a<T>
/*     */   {
/*     */     protected h(Class<T> param1Class) {
/*  63 */       super(param1Class);
/*     */     }
/*     */ 
/*     */     
/*     */     protected h(h<T> param1h, com.a.a.c.c param1c, Boolean param1Boolean) {
/*  68 */       super(param1h, param1c, param1Boolean);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final j<?> b(i param1i) {
/*  76 */       return this;
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
/*     */   @com.a.a.c.a.a
/*     */   public static class a
/*     */     extends a<boolean[]>
/*     */   {
/*     */     static {
/*  92 */       o.a().a(Boolean.class);
/*     */     } public a() {
/*  94 */       super((Class)boolean[].class);
/*     */     }
/*     */     
/*     */     private a(a param1a, com.a.a.c.c param1c, Boolean param1Boolean) {
/*  98 */       super(param1a, param1c, param1Boolean);
/*     */     }
/*     */ 
/*     */     
/*     */     public final o<?> a(com.a.a.c.c param1c, Boolean param1Boolean) {
/* 103 */       return (o<?>)new a(this, param1c, param1Boolean);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final j<?> b(i param1i) {
/* 112 */       return this;
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
/*     */     private static boolean a(boolean[] param1ArrayOfboolean) {
/* 128 */       return (param1ArrayOfboolean.length == 0);
/*     */     }
/*     */ 
/*     */     
/*     */     private static boolean b(boolean[] param1ArrayOfboolean) {
/* 133 */       return (param1ArrayOfboolean.length == 1);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private void a(boolean[] param1ArrayOfboolean, com.a.a.b.h param1h, aa param1aa) {
/*     */       int i;
/* 140 */       if ((i = param1ArrayOfboolean.length) == 1 && a(param1aa)) {
/* 141 */         a(param1ArrayOfboolean, param1h);
/*     */         return;
/*     */       } 
/* 144 */       param1h.a(param1ArrayOfboolean, i);
/* 145 */       a(param1ArrayOfboolean, param1h);
/* 146 */       param1h.h();
/*     */     }
/*     */ 
/*     */     
/*     */     private static void a(boolean[] param1ArrayOfboolean, com.a.a.b.h param1h) {
/*     */       byte b;
/*     */       int i;
/* 153 */       for (b = 0, i = param1ArrayOfboolean.length; b < i; b++) {
/* 154 */         param1h.a(param1ArrayOfboolean[b]);
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
/*     */   @com.a.a.c.a.a
/*     */   public static class g
/*     */     extends h<short[]>
/*     */   {
/*     */     static {
/* 179 */       o.a().a(short.class);
/*     */     } public g() {
/* 181 */       super((Class)short[].class);
/*     */     }
/*     */     private g(g param1g, com.a.a.c.c param1c, Boolean param1Boolean) {
/* 184 */       super(param1g, param1c, param1Boolean);
/*     */     }
/*     */ 
/*     */     
/*     */     public final o<?> a(com.a.a.c.c param1c, Boolean param1Boolean) {
/* 189 */       return (o<?>)new g(this, param1c, param1Boolean);
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
/*     */     private static boolean a(short[] param1ArrayOfshort) {
/* 205 */       return (param1ArrayOfshort.length == 0);
/*     */     }
/*     */ 
/*     */     
/*     */     private static boolean b(short[] param1ArrayOfshort) {
/* 210 */       return (param1ArrayOfshort.length == 1);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private void a(short[] param1ArrayOfshort, com.a.a.b.h param1h, aa param1aa) {
/*     */       int i;
/* 217 */       if ((i = param1ArrayOfshort.length) == 1 && a(param1aa)) {
/* 218 */         a(param1ArrayOfshort, param1h);
/*     */         return;
/*     */       } 
/* 221 */       param1h.a(param1ArrayOfshort, i);
/* 222 */       a(param1ArrayOfshort, param1h);
/* 223 */       param1h.h();
/*     */     }
/*     */ 
/*     */     
/*     */     private static void a(short[] param1ArrayOfshort, com.a.a.b.h param1h) {
/*     */       byte b;
/*     */       int i;
/* 230 */       for (b = 0, i = param1ArrayOfshort.length; b < i; b++) {
/* 231 */         param1h.c(param1ArrayOfshort[b]);
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
/*     */   @com.a.a.c.a.a
/*     */   public static class b
/*     */     extends ao<char[]>
/*     */   {
/*     */     public b() {
/* 261 */       super((Class)char[].class);
/*     */     }
/*     */     
/*     */     private static boolean a(char[] param1ArrayOfchar) {
/* 265 */       return (param1ArrayOfchar.length == 0);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void a(char[] param1ArrayOfchar, com.a.a.b.h param1h, aa param1aa) {
/* 273 */       if (param1aa.a(z.l)) {
/* 274 */         param1h.a(param1ArrayOfchar, param1ArrayOfchar.length);
/* 275 */         a(param1h, param1ArrayOfchar);
/* 276 */         param1h.h(); return;
/*     */       } 
/* 278 */       param1h.a(param1ArrayOfchar, 0, param1ArrayOfchar.length);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void a(char[] param1ArrayOfchar, com.a.a.b.h param1h, aa param1aa, i param1i) {
/*     */       com.a.a.b.f.a a;
/*     */       boolean bool;
/* 290 */       if (bool = param1aa.a(z.l)) {
/* 291 */         a = param1i.a(param1h, param1i
/* 292 */             .a(param1ArrayOfchar, o.d));
/* 293 */         a(param1h, param1ArrayOfchar);
/*     */       } else {
/* 295 */         a = param1i.a(param1h, param1i
/* 296 */             .a(param1ArrayOfchar, o.h));
/* 297 */         param1h.a(param1ArrayOfchar, 0, param1ArrayOfchar.length);
/*     */       } 
/* 299 */       param1i.b(param1h, a);
/*     */     }
/*     */     
/*     */     private static void a(com.a.a.b.h param1h, char[] param1ArrayOfchar) {
/*     */       byte b1;
/*     */       int i;
/* 305 */       for (b1 = 0, i = param1ArrayOfchar.length; b1 < i; b1++) {
/* 306 */         param1h.a(param1ArrayOfchar, b1, 1);
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
/*     */   @com.a.a.c.a.a
/*     */   public static class e
/*     */     extends a<int[]>
/*     */   {
/*     */     static {
/* 332 */       o.a().a(int.class);
/*     */     } public e() {
/* 334 */       super((Class)int[].class);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private e(e param1e, com.a.a.c.c param1c, Boolean param1Boolean) {
/* 341 */       super(param1e, param1c, param1Boolean);
/*     */     }
/*     */ 
/*     */     
/*     */     public final o<?> a(com.a.a.c.c param1c, Boolean param1Boolean) {
/* 346 */       return (o<?>)new e(this, param1c, param1Boolean);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final j<?> b(i param1i) {
/* 355 */       return this;
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
/*     */     private static boolean a(int[] param1ArrayOfint) {
/* 371 */       return (param1ArrayOfint.length == 0);
/*     */     }
/*     */ 
/*     */     
/*     */     private static boolean b(int[] param1ArrayOfint) {
/* 376 */       return (param1ArrayOfint.length == 1);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private void a(int[] param1ArrayOfint, com.a.a.b.h param1h, aa param1aa) {
/*     */       int i;
/* 383 */       if ((i = param1ArrayOfint.length) == 1 && a(param1aa)) {
/* 384 */         a(param1ArrayOfint, param1h);
/*     */         
/*     */         return;
/*     */       } 
/* 388 */       param1h.a(param1ArrayOfint, 0, param1ArrayOfint.length);
/*     */     }
/*     */ 
/*     */     
/*     */     private static void a(int[] param1ArrayOfint, com.a.a.b.h param1h) {
/*     */       byte b;
/*     */       int i;
/* 395 */       for (b = 0, i = param1ArrayOfint.length; b < i; b++) {
/* 396 */         param1h.c(param1ArrayOfint[b]);
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
/*     */   @com.a.a.c.a.a
/*     */   public static class f
/*     */     extends h<long[]>
/*     */   {
/*     */     static {
/* 417 */       o.a().a(long.class);
/*     */     } public f() {
/* 419 */       super((Class)long[].class);
/*     */     }
/*     */     private f(f param1f, com.a.a.c.c param1c, Boolean param1Boolean) {
/* 422 */       super(param1f, param1c, param1Boolean);
/*     */     }
/*     */ 
/*     */     
/*     */     public final o<?> a(com.a.a.c.c param1c, Boolean param1Boolean) {
/* 427 */       return (o<?>)new f(this, param1c, param1Boolean);
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
/*     */     private static boolean a(long[] param1ArrayOflong) {
/* 443 */       return (param1ArrayOflong.length == 0);
/*     */     }
/*     */ 
/*     */     
/*     */     private static boolean b(long[] param1ArrayOflong) {
/* 448 */       return (param1ArrayOflong.length == 1);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private void a(long[] param1ArrayOflong, com.a.a.b.h param1h, aa param1aa) {
/*     */       int i;
/* 455 */       if ((i = param1ArrayOflong.length) == 1 && a(param1aa)) {
/* 456 */         a(param1ArrayOflong, param1h);
/*     */         
/*     */         return;
/*     */       } 
/* 460 */       param1h.a(param1ArrayOflong, 0, param1ArrayOflong.length);
/*     */     }
/*     */ 
/*     */     
/*     */     private static void a(long[] param1ArrayOflong, com.a.a.b.h param1h) {
/*     */       byte b;
/*     */       int i;
/* 467 */       for (b = 0, i = param1ArrayOflong.length; b < i; b++) {
/* 468 */         param1h.b(param1ArrayOflong[b]);
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
/*     */   @com.a.a.c.a.a
/*     */   public static class d
/*     */     extends h<float[]>
/*     */   {
/*     */     static {
/* 492 */       o.a().a(float.class);
/*     */     }
/*     */     public d() {
/* 495 */       super((Class)float[].class);
/*     */     }
/*     */     
/*     */     private d(d param1d, com.a.a.c.c param1c, Boolean param1Boolean) {
/* 499 */       super(param1d, param1c, param1Boolean);
/*     */     }
/*     */ 
/*     */     
/*     */     public final o<?> a(com.a.a.c.c param1c, Boolean param1Boolean) {
/* 504 */       return (o<?>)new d(this, param1c, param1Boolean);
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
/*     */     private static boolean a(float[] param1ArrayOffloat) {
/* 520 */       return (param1ArrayOffloat.length == 0);
/*     */     }
/*     */ 
/*     */     
/*     */     private static boolean b(float[] param1ArrayOffloat) {
/* 525 */       return (param1ArrayOffloat.length == 1);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private void a(float[] param1ArrayOffloat, com.a.a.b.h param1h, aa param1aa) {
/*     */       int i;
/* 532 */       if ((i = param1ArrayOffloat.length) == 1 && a(param1aa)) {
/* 533 */         a(param1ArrayOffloat, param1h);
/*     */         return;
/*     */       } 
/* 536 */       param1h.a(param1ArrayOffloat, i);
/* 537 */       a(param1ArrayOffloat, param1h);
/* 538 */       param1h.h();
/*     */     }
/*     */ 
/*     */     
/*     */     private static void a(float[] param1ArrayOffloat, com.a.a.b.h param1h) {
/*     */       byte b;
/*     */       int i;
/* 545 */       for (b = 0, i = param1ArrayOffloat.length; b < i; b++) {
/* 546 */         param1h.a(param1ArrayOffloat[b]);
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
/*     */   @com.a.a.c.a.a
/*     */   public static class c
/*     */     extends a<double[]>
/*     */   {
/*     */     static {
/* 567 */       o.a().a(double.class);
/*     */     } public c() {
/* 569 */       super((Class)double[].class);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private c(c param1c, com.a.a.c.c param1c1, Boolean param1Boolean) {
/* 576 */       super(param1c, param1c1, param1Boolean);
/*     */     }
/*     */ 
/*     */     
/*     */     public final o<?> a(com.a.a.c.c param1c, Boolean param1Boolean) {
/* 581 */       return (o<?>)new c(this, param1c, param1Boolean);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final j<?> b(i param1i) {
/* 590 */       return this;
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
/*     */     private static boolean a(double[] param1ArrayOfdouble) {
/* 606 */       return (param1ArrayOfdouble.length == 0);
/*     */     }
/*     */ 
/*     */     
/*     */     private static boolean b(double[] param1ArrayOfdouble) {
/* 611 */       return (param1ArrayOfdouble.length == 1);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private void a(double[] param1ArrayOfdouble, com.a.a.b.h param1h, aa param1aa) {
/*     */       int i;
/* 618 */       if ((i = param1ArrayOfdouble.length) == 1 && a(param1aa)) {
/* 619 */         a(param1ArrayOfdouble, param1h);
/*     */         
/*     */         return;
/*     */       } 
/* 623 */       param1h.a(param1ArrayOfdouble, 0, param1ArrayOfdouble.length);
/*     */     }
/*     */     
/*     */     private static void a(double[] param1ArrayOfdouble, com.a.a.b.h param1h) {
/*     */       byte b;
/*     */       int i;
/* 629 */       for (b = 0, i = param1ArrayOfdouble.length; b < i; b++)
/* 630 */         param1h.a(param1ArrayOfdouble[b]); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\b\ai.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */