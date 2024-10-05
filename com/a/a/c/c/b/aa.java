/*     */ package com.a.a.c.c.b;
/*     */ 
/*     */ import com.a.a.a.ak;
/*     */ import com.a.a.a.l;
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.c.a.q;
/*     */ import com.a.a.c.c.a.r;
/*     */ import com.a.a.c.c.k;
/*     */ import com.a.a.c.c.s;
/*     */ import com.a.a.c.i;
/*     */ import com.a.a.c.k;
/*     */ import com.a.a.c.l;
/*     */ import java.lang.reflect.Array;
/*     */ import java.util.Arrays;
/*     */ import java.util.Objects;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class aa<T>
/*     */   extends ae<T>
/*     */   implements k
/*     */ {
/*     */   private Boolean b;
/*     */   private transient Object c;
/*     */   protected final s a;
/*     */   
/*     */   protected aa(Class<T> paramClass) {
/*  58 */     super(paramClass);
/*  59 */     this.b = null;
/*  60 */     this.a = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected aa(aa<?> paramaa, s params, Boolean paramBoolean) {
/*  68 */     super(paramaa.s);
/*  69 */     this.b = paramBoolean;
/*  70 */     this.a = params;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static k<?> a(Class<?> paramClass) {
/*  76 */     if (paramClass == int.class) {
/*  77 */       return f.b;
/*     */     }
/*  79 */     if (paramClass == long.class) {
/*  80 */       return g.b;
/*     */     }
/*     */     
/*  83 */     if (paramClass == byte.class) {
/*  84 */       return new b();
/*     */     }
/*  86 */     if (paramClass == short.class) {
/*  87 */       return new h();
/*     */     }
/*  89 */     if (paramClass == float.class) {
/*  90 */       return new e();
/*     */     }
/*  92 */     if (paramClass == double.class) {
/*  93 */       return new d();
/*     */     }
/*  95 */     if (paramClass == boolean.class) {
/*  96 */       return new a();
/*     */     }
/*  98 */     if (paramClass == char.class) {
/*  99 */       return new c();
/*     */     }
/* 101 */     throw new IllegalStateException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final k<?> a(com.a.a.c.g paramg, com.a.a.c.c paramc) {
/*     */     r r;
/* 108 */     Boolean bool = a(paramg, paramc, this.s, l.a.a);
/*     */     
/* 110 */     q q = null;
/*     */     
/*     */     ak ak;
/* 113 */     if ((ak = b(paramg, paramc)) == ak.a) {
/* 114 */       q = q.a();
/* 115 */     } else if (ak == ak.b) {
/* 116 */       if (paramc == null) {
/*     */         
/* 118 */         r = r.a(paramg.b(this.s.getComponentType()));
/*     */       } else {
/*     */         
/* 121 */         r = r.a(paramc, paramc.c().u());
/*     */       } 
/*     */     } 
/* 124 */     if (Objects.equals(bool, this.b) && r == this.a) {
/* 125 */       return this;
/*     */     }
/* 127 */     return a((s)r, bool);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract T a(T paramT1, T paramT2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract T c(l paraml, com.a.a.c.g paramg);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract aa<?> a(s params, Boolean paramBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract T g();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public com.a.a.c.l.f b() {
/* 161 */     return com.a.a.c.l.f.a;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Boolean a(com.a.a.c.f paramf) {
/* 166 */     return Boolean.TRUE;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final com.a.a.c.m.a e() {
/* 172 */     return com.a.a.c.m.a.b;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Object c(com.a.a.c.g paramg) {
/*     */     Object object;
/* 178 */     if ((object = this.c) == null) {
/* 179 */       this.c = object = g();
/*     */     }
/* 181 */     return object;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object a(l paraml, com.a.a.c.g paramg, com.a.a.c.i.e parame) {
/* 190 */     return parame.b(paraml, paramg);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final T a(l paraml, com.a.a.c.g paramg, T paramT) {
/* 196 */     Object object = a(paraml, paramg);
/* 197 */     if (paramT == null) {
/* 198 */       return (T)object;
/*     */     }
/*     */     int i;
/* 201 */     if ((i = Array.getLength(paramT)) == 0) {
/* 202 */       return (T)object;
/*     */     }
/* 204 */     return a(paramT, (T)object);
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
/*     */   protected final T e(l paraml, com.a.a.c.g paramg) {
/* 217 */     if (paraml.a(o.h)) {
/* 218 */       return m(paraml, paramg);
/*     */     }
/*     */     
/*     */     boolean bool;
/*     */     
/* 223 */     if (bool = (this.b == Boolean.TRUE || (this.b == null && paramg.a(i.p))) ? true : false) {
/* 224 */       return c(paraml, paramg);
/*     */     }
/* 226 */     return (T)paramg.a(this.s, paraml);
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
/*     */   @com.a.a.c.a.a
/*     */   static final class c
/*     */     extends aa<char[]>
/*     */   {
/*     */     public c() {
/* 246 */       super((Class)char[].class);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected final aa<?> a(s param1s, Boolean param1Boolean) {
/* 255 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     private static char[] j() {
/* 260 */       return new char[0];
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private char[] f(l param1l, com.a.a.c.g param1g) {
/* 270 */       if (param1l.a(o.h)) {
/*     */         
/* 272 */         char[] arrayOfChar1 = param1l.x();
/* 273 */         int i = param1l.z();
/*     */         
/*     */         int j;
/* 276 */         char[] arrayOfChar2 = new char[j = param1l.y()];
/* 277 */         System.arraycopy(arrayOfChar1, i, arrayOfChar2, 0, j);
/* 278 */         return arrayOfChar2;
/*     */       } 
/* 280 */       if (param1l.p()) {
/*     */         
/* 282 */         StringBuilder stringBuilder = new StringBuilder(64);
/*     */         o o;
/* 284 */         while ((o = param1l.g()) != o.e) {
/*     */           String str;
/* 286 */           if (o == o.h) {
/* 287 */             str = param1l.w();
/* 288 */           } else if (o == o.m) {
/* 289 */             if (this.a != null) {
/* 290 */               this.a.a(param1g);
/*     */               continue;
/*     */             } 
/* 293 */             f(param1g);
/* 294 */             str = "\000";
/*     */           } else {
/*     */             CharSequence charSequence;
/* 297 */             str = (charSequence = (CharSequence)param1g.a(char.class, param1l)).toString();
/*     */           } 
/* 299 */           if (str.length() != 1)
/* 300 */             param1g.a(this, "Cannot convert a JSON String of length %d into a char element of char array", new Object[] {
/* 301 */                   Integer.valueOf(str.length())
/*     */                 }); 
/* 303 */           stringBuilder.append(str.charAt(0));
/*     */         } 
/* 305 */         return stringBuilder.toString().toCharArray();
/*     */       } 
/*     */       
/* 308 */       if (param1l.a(o.g)) {
/*     */         Object object;
/* 310 */         if ((object = param1l.N()) == null) return null; 
/* 311 */         if (object instanceof char[]) {
/* 312 */           return (char[])object;
/*     */         }
/* 314 */         if (object instanceof String) {
/* 315 */           return ((String)object).toCharArray();
/*     */         }
/*     */         
/* 318 */         if (object instanceof byte[]) {
/* 319 */           return com.a.a.b.b.a().a((byte[])object, false).toCharArray();
/*     */         }
/*     */       } 
/*     */       
/* 323 */       return (char[])param1g.a(this.s, param1l);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private char[] g(l param1l, com.a.a.c.g param1g) {
/* 330 */       return (char[])param1g.a(this.s, param1l);
/*     */     }
/*     */ 
/*     */     
/*     */     private static char[] a(char[] param1ArrayOfchar1, char[] param1ArrayOfchar2) {
/* 335 */       int i = param1ArrayOfchar1.length;
/* 336 */       int j = param1ArrayOfchar2.length;
/* 337 */       param1ArrayOfchar1 = Arrays.copyOf(param1ArrayOfchar1, i + j);
/* 338 */       System.arraycopy(param1ArrayOfchar2, 0, param1ArrayOfchar1, i, j);
/* 339 */       return param1ArrayOfchar1;
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
/*     */   static final class a
/*     */     extends aa<boolean[]>
/*     */   {
/*     */     public a() {
/* 355 */       super((Class)boolean[].class);
/*     */     } private a(a param1a, s param1s, Boolean param1Boolean) {
/* 357 */       super(param1a, param1s, param1Boolean);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected final aa<?> a(s param1s, Boolean param1Boolean) {
/* 363 */       return new a(this, param1s, param1Boolean);
/*     */     }
/*     */ 
/*     */     
/*     */     private static boolean[] j() {
/* 368 */       return new boolean[0];
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private boolean[] f(l param1l, com.a.a.c.g param1g) {
/* 375 */       if (!param1l.p()) {
/* 376 */         return e(param1l, param1g);
/*     */       }
/*     */       com.a.a.c.m.c.a a1;
/* 379 */       boolean[] arrayOfBoolean = (boolean[])(a1 = param1g.o().a()).b();
/* 380 */       byte b = 0;
/*     */       
/*     */       try {
/*     */         o o;
/* 384 */         while ((o = param1l.g()) != o.e) {
/*     */           boolean bool;
/* 386 */           if (o == o.k) {
/* 387 */             bool = true;
/* 388 */           } else if (bool == o.l) {
/* 389 */             bool = false;
/* 390 */           } else if (bool == o.m) {
/* 391 */             if (this.a != null) {
/* 392 */               this.a.a(param1g);
/*     */               continue;
/*     */             } 
/* 395 */             f(param1g);
/* 396 */             bool = false;
/*     */           } else {
/* 398 */             bool = n(param1l, param1g);
/*     */           } 
/* 400 */           if (b >= arrayOfBoolean.length) {
/* 401 */             arrayOfBoolean = (boolean[])a1.a(arrayOfBoolean, b);
/* 402 */             b = 0;
/*     */           } 
/* 404 */           arrayOfBoolean[b++] = bool;
/*     */         } 
/* 406 */       } catch (Exception exception2) {
/* 407 */         Exception exception1; throw l.a(exception1 = null, arrayOfBoolean, a1.a() + b);
/*     */       } 
/* 409 */       return (boolean[])a1.b(arrayOfBoolean, b);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private boolean[] g(l param1l, com.a.a.c.g param1g) {
/* 415 */       return new boolean[] { n(param1l, param1g) };
/*     */     }
/*     */ 
/*     */     
/*     */     private static boolean[] a(boolean[] param1ArrayOfboolean1, boolean[] param1ArrayOfboolean2) {
/* 420 */       int i = param1ArrayOfboolean1.length;
/* 421 */       int j = param1ArrayOfboolean2.length;
/* 422 */       param1ArrayOfboolean1 = Arrays.copyOf(param1ArrayOfboolean1, i + j);
/* 423 */       System.arraycopy(param1ArrayOfboolean2, 0, param1ArrayOfboolean1, i, j);
/* 424 */       return param1ArrayOfboolean1;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.a.a.c.a.a
/*     */   static final class b
/*     */     extends aa<byte[]>
/*     */   {
/*     */     public b() {
/* 438 */       super((Class)byte[].class);
/*     */     } private b(b param1b, s param1s, Boolean param1Boolean) {
/* 440 */       super(param1b, param1s, param1Boolean);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected final aa<?> a(s param1s, Boolean param1Boolean) {
/* 446 */       return new b(this, param1s, param1Boolean);
/*     */     }
/*     */ 
/*     */     
/*     */     private static byte[] j() {
/* 451 */       return new byte[0];
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final com.a.a.c.l.f b() {
/* 458 */       return com.a.a.c.l.f.k;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private byte[] f(l param1l, com.a.a.c.g param1g) {
/*     */       o o;
/* 467 */       if ((o = param1l.k()) == o.h) {
/*     */         try {
/* 469 */           return param1l.a(param1g.k());
/* 470 */         } catch (com.a.a.b.b.b b4) {
/*     */           com.a.a.b.b.b b3;
/*     */ 
/*     */           
/*     */           String str;
/*     */           
/* 476 */           if ((str = (b3 = null).b()).contains("base64")) {
/* 477 */             return (byte[])param1g.b(byte[].class, param1l
/* 478 */                 .w(), str, new Object[0]);
/*     */           }
/*     */         } 
/*     */       }
/*     */       
/* 483 */       if (o == o.g) {
/*     */         Object object;
/* 485 */         if ((object = param1l.N()) == null) return null; 
/* 486 */         if (object instanceof byte[]) {
/* 487 */           return (byte[])object;
/*     */         }
/*     */       } 
/* 490 */       if (!param1l.p()) {
/* 491 */         return e(param1l, param1g);
/*     */       }
/*     */       com.a.a.c.m.c.b b1;
/* 494 */       byte[] arrayOfByte = (byte[])(b1 = param1g.o().b()).b();
/* 495 */       byte b2 = 0;
/*     */       
/*     */       try {
/* 498 */         while ((o = param1l.g()) != o.e) {
/*     */           byte b3;
/*     */           
/* 501 */           if (o == o.i) {
/* 502 */             b3 = param1l.E();
/*     */           
/*     */           }
/* 505 */           else if (b3 == o.m) {
/* 506 */             if (this.a != null) {
/* 507 */               this.a.a(param1g);
/*     */               continue;
/*     */             } 
/* 510 */             f(param1g);
/* 511 */             b3 = 0;
/*     */           } else {
/* 513 */             b3 = o(param1l, param1g);
/*     */           } 
/*     */           
/* 516 */           if (b2 >= arrayOfByte.length) {
/* 517 */             arrayOfByte = (byte[])b1.a(arrayOfByte, b2);
/* 518 */             b2 = 0;
/*     */           } 
/* 520 */           arrayOfByte[b2++] = b3;
/*     */         } 
/* 522 */       } catch (Exception exception) {
/* 523 */         throw l.a(o = null, arrayOfByte, b1.a() + b2);
/*     */       } 
/* 525 */       return (byte[])b1.b(arrayOfByte, b2);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private byte[] g(l param1l, com.a.a.c.g param1g) {
/*     */       byte b1;
/*     */       o o;
/* 534 */       if ((o = param1l.k()) == o.i) {
/* 535 */         b1 = param1l.E();
/*     */       } else {
/*     */         
/* 538 */         if (o == o.m) {
/* 539 */           if (this.a != null) {
/* 540 */             this.a.a(param1g);
/* 541 */             return (byte[])c(param1g);
/*     */           } 
/* 543 */           f(param1g);
/* 544 */           return null;
/*     */         } 
/*     */         Number number;
/* 547 */         b1 = (number = (Number)param1g.a(this.s.getComponentType(), b1)).byteValue();
/*     */       } 
/* 549 */       return new byte[] { b1 };
/*     */     }
/*     */ 
/*     */     
/*     */     private static byte[] a(byte[] param1ArrayOfbyte1, byte[] param1ArrayOfbyte2) {
/* 554 */       int i = param1ArrayOfbyte1.length;
/* 555 */       int j = param1ArrayOfbyte2.length;
/* 556 */       param1ArrayOfbyte1 = Arrays.copyOf(param1ArrayOfbyte1, i + j);
/* 557 */       System.arraycopy(param1ArrayOfbyte2, 0, param1ArrayOfbyte1, i, j);
/* 558 */       return param1ArrayOfbyte1;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @com.a.a.c.a.a
/*     */   static final class h
/*     */     extends aa<short[]>
/*     */   {
/*     */     public h() {
/* 568 */       super((Class)short[].class);
/*     */     } private h(h param1h, s param1s, Boolean param1Boolean) {
/* 570 */       super(param1h, param1s, param1Boolean);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected final aa<?> a(s param1s, Boolean param1Boolean) {
/* 576 */       return new h(this, param1s, param1Boolean);
/*     */     }
/*     */ 
/*     */     
/*     */     private static short[] j() {
/* 581 */       return new short[0];
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private short[] f(l param1l, com.a.a.c.g param1g) {
/* 587 */       if (!param1l.p()) {
/* 588 */         return e(param1l, param1g);
/*     */       }
/*     */       com.a.a.c.m.c.g g1;
/* 591 */       short[] arrayOfShort = (short[])(g1 = param1g.o().c()).b();
/* 592 */       byte b = 0;
/*     */       
/*     */       try {
/*     */         o o;
/* 596 */         while ((o = param1l.g()) != o.e) {
/*     */           short s;
/* 598 */           if (o == o.m) {
/* 599 */             if (this.a != null) {
/* 600 */               this.a.a(param1g);
/*     */               continue;
/*     */             } 
/* 603 */             f(param1g);
/* 604 */             s = 0;
/*     */           } else {
/* 606 */             s = p(param1l, param1g);
/*     */           } 
/* 608 */           if (b >= arrayOfShort.length) {
/* 609 */             arrayOfShort = (short[])g1.a(arrayOfShort, b);
/* 610 */             b = 0;
/*     */           } 
/* 612 */           arrayOfShort[b++] = s;
/*     */         } 
/* 614 */       } catch (Exception exception2) {
/* 615 */         Exception exception1; throw l.a(exception1 = null, arrayOfShort, g1.a() + b);
/*     */       } 
/* 617 */       return (short[])g1.b(arrayOfShort, b);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private short[] g(l param1l, com.a.a.c.g param1g) {
/* 623 */       return new short[] { p(param1l, param1g) };
/*     */     }
/*     */ 
/*     */     
/*     */     private static short[] a(short[] param1ArrayOfshort1, short[] param1ArrayOfshort2) {
/* 628 */       int i = param1ArrayOfshort1.length;
/* 629 */       int j = param1ArrayOfshort2.length;
/* 630 */       param1ArrayOfshort1 = Arrays.copyOf(param1ArrayOfshort1, i + j);
/* 631 */       System.arraycopy(param1ArrayOfshort2, 0, param1ArrayOfshort1, i, j);
/* 632 */       return param1ArrayOfshort1;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @com.a.a.c.a.a
/*     */   static final class f
/*     */     extends aa<int[]>
/*     */   {
/* 642 */     public static final f b = new f();
/*     */     public f() {
/* 644 */       super((Class)int[].class);
/*     */     } private f(f param1f, s param1s, Boolean param1Boolean) {
/* 646 */       super(param1f, param1s, param1Boolean);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected final aa<?> a(s param1s, Boolean param1Boolean) {
/* 652 */       return new f(this, param1s, param1Boolean);
/*     */     }
/*     */ 
/*     */     
/*     */     private static int[] j() {
/* 657 */       return new int[0];
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private int[] f(l param1l, com.a.a.c.g param1g) {
/* 663 */       if (!param1l.p()) {
/* 664 */         return e(param1l, param1g);
/*     */       }
/*     */       com.a.a.c.m.c.e e;
/* 667 */       int[] arrayOfInt = (int[])(e = param1g.o().d()).b();
/* 668 */       byte b = 0;
/*     */       
/*     */       try {
/*     */         o o;
/* 672 */         while ((o = param1l.g()) != o.e) {
/*     */           int i;
/* 674 */           if (o == o.i) {
/* 675 */             i = param1l.G();
/* 676 */           } else if (i == o.m) {
/* 677 */             if (this.a != null) {
/* 678 */               this.a.a(param1g);
/*     */               continue;
/*     */             } 
/* 681 */             f(param1g);
/* 682 */             i = 0;
/*     */           } else {
/* 684 */             i = q(param1l, param1g);
/*     */           } 
/* 686 */           if (b >= arrayOfInt.length) {
/* 687 */             arrayOfInt = (int[])e.a(arrayOfInt, b);
/* 688 */             b = 0;
/*     */           } 
/* 690 */           arrayOfInt[b++] = i;
/*     */         } 
/* 692 */       } catch (Exception exception2) {
/* 693 */         Exception exception1; throw l.a(exception1 = null, arrayOfInt, e.a() + b);
/*     */       } 
/* 695 */       return (int[])e.b(arrayOfInt, b);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private int[] g(l param1l, com.a.a.c.g param1g) {
/* 701 */       return new int[] { q(param1l, param1g) };
/*     */     }
/*     */ 
/*     */     
/*     */     private static int[] a(int[] param1ArrayOfint1, int[] param1ArrayOfint2) {
/* 706 */       int i = param1ArrayOfint1.length;
/* 707 */       int j = param1ArrayOfint2.length;
/* 708 */       param1ArrayOfint1 = Arrays.copyOf(param1ArrayOfint1, i + j);
/* 709 */       System.arraycopy(param1ArrayOfint2, 0, param1ArrayOfint1, i, j);
/* 710 */       return param1ArrayOfint1;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @com.a.a.c.a.a
/*     */   static final class g
/*     */     extends aa<long[]>
/*     */   {
/* 720 */     public static final g b = new g();
/*     */     public g() {
/* 722 */       super((Class)long[].class);
/*     */     } private g(g param1g, s param1s, Boolean param1Boolean) {
/* 724 */       super(param1g, param1s, param1Boolean);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected final aa<?> a(s param1s, Boolean param1Boolean) {
/* 730 */       return new g(this, param1s, param1Boolean);
/*     */     }
/*     */ 
/*     */     
/*     */     private static long[] j() {
/* 735 */       return new long[0];
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private long[] f(l param1l, com.a.a.c.g param1g) {
/* 741 */       if (!param1l.p()) {
/* 742 */         return e(param1l, param1g);
/*     */       }
/*     */       com.a.a.c.m.c.f f;
/* 745 */       long[] arrayOfLong = (long[])(f = param1g.o().e()).b();
/* 746 */       byte b = 0;
/*     */       
/*     */       try {
/*     */         o o;
/* 750 */         while ((o = param1l.g()) != o.e) {
/*     */           long l1;
/* 752 */           if (o == o.i) {
/* 753 */             l1 = param1l.H();
/* 754 */           } else if (o == o.m) {
/* 755 */             if (this.a != null) {
/* 756 */               this.a.a(param1g);
/*     */               continue;
/*     */             } 
/* 759 */             f(param1g);
/* 760 */             l1 = 0L;
/*     */           } else {
/* 762 */             l1 = r(param1l, param1g);
/*     */           } 
/* 764 */           if (b >= arrayOfLong.length) {
/* 765 */             arrayOfLong = (long[])f.a(arrayOfLong, b);
/* 766 */             b = 0;
/*     */           } 
/* 768 */           arrayOfLong[b++] = l1;
/*     */         } 
/* 770 */       } catch (Exception exception2) {
/* 771 */         Exception exception1; throw l.a(exception1 = null, arrayOfLong, f.a() + b);
/*     */       } 
/* 773 */       return (long[])f.b(arrayOfLong, b);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private long[] g(l param1l, com.a.a.c.g param1g) {
/* 779 */       return new long[] { r(param1l, param1g) };
/*     */     }
/*     */ 
/*     */     
/*     */     private static long[] a(long[] param1ArrayOflong1, long[] param1ArrayOflong2) {
/* 784 */       int i = param1ArrayOflong1.length;
/* 785 */       int j = param1ArrayOflong2.length;
/* 786 */       param1ArrayOflong1 = Arrays.copyOf(param1ArrayOflong1, i + j);
/* 787 */       System.arraycopy(param1ArrayOflong2, 0, param1ArrayOflong1, i, j);
/* 788 */       return param1ArrayOflong1;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @com.a.a.c.a.a
/*     */   static final class e
/*     */     extends aa<float[]>
/*     */   {
/*     */     public e() {
/* 798 */       super((Class)float[].class);
/*     */     } private e(e param1e, s param1s, Boolean param1Boolean) {
/* 800 */       super(param1e, param1s, param1Boolean);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected final aa<?> a(s param1s, Boolean param1Boolean) {
/* 806 */       return new e(this, param1s, param1Boolean);
/*     */     }
/*     */ 
/*     */     
/*     */     private static float[] j() {
/* 811 */       return new float[0];
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private float[] f(l param1l, com.a.a.c.g param1g) {
/* 817 */       if (!param1l.p()) {
/* 818 */         return e(param1l, param1g);
/*     */       }
/*     */       com.a.a.c.m.c.d d;
/* 821 */       float[] arrayOfFloat = (float[])(d = param1g.o().f()).b();
/* 822 */       byte b = 0;
/*     */       
/*     */       try {
/*     */         o o;
/* 826 */         while ((o = param1l.g()) != o.e) {
/*     */           
/* 828 */           if (o == o.m && 
/* 829 */             this.a != null) {
/* 830 */             this.a.a(param1g);
/*     */             
/*     */             continue;
/*     */           } 
/* 834 */           float f = s(param1l, param1g);
/* 835 */           if (b >= arrayOfFloat.length) {
/* 836 */             arrayOfFloat = (float[])d.a(arrayOfFloat, b);
/* 837 */             b = 0;
/*     */           } 
/* 839 */           arrayOfFloat[b++] = f;
/*     */         } 
/* 841 */       } catch (Exception exception2) {
/* 842 */         Exception exception1; throw l.a(exception1 = null, arrayOfFloat, d.a() + b);
/*     */       } 
/* 844 */       return (float[])d.b(arrayOfFloat, b);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private float[] g(l param1l, com.a.a.c.g param1g) {
/* 850 */       return new float[] { s(param1l, param1g) };
/*     */     }
/*     */ 
/*     */     
/*     */     private static float[] a(float[] param1ArrayOffloat1, float[] param1ArrayOffloat2) {
/* 855 */       int i = param1ArrayOffloat1.length;
/* 856 */       int j = param1ArrayOffloat2.length;
/* 857 */       param1ArrayOffloat1 = Arrays.copyOf(param1ArrayOffloat1, i + j);
/* 858 */       System.arraycopy(param1ArrayOffloat2, 0, param1ArrayOffloat1, i, j);
/* 859 */       return param1ArrayOffloat1;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @com.a.a.c.a.a
/*     */   static final class d
/*     */     extends aa<double[]>
/*     */   {
/*     */     public d() {
/* 869 */       super((Class)double[].class);
/*     */     } private d(d param1d, s param1s, Boolean param1Boolean) {
/* 871 */       super(param1d, param1s, param1Boolean);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected final aa<?> a(s param1s, Boolean param1Boolean) {
/* 877 */       return new d(this, param1s, param1Boolean);
/*     */     }
/*     */ 
/*     */     
/*     */     private static double[] j() {
/* 882 */       return new double[0];
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private double[] f(l param1l, com.a.a.c.g param1g) {
/* 888 */       if (!param1l.p()) {
/* 889 */         return e(param1l, param1g);
/*     */       }
/*     */       com.a.a.c.m.c.c c;
/* 892 */       double[] arrayOfDouble = (double[])(c = param1g.o().g()).b();
/* 893 */       byte b = 0;
/*     */       
/*     */       try {
/*     */         o o;
/* 897 */         while ((o = param1l.g()) != o.e) {
/* 898 */           if (o == o.m && 
/* 899 */             this.a != null) {
/* 900 */             this.a.a(param1g);
/*     */             
/*     */             continue;
/*     */           } 
/* 904 */           double d1 = t(param1l, param1g);
/* 905 */           if (b >= arrayOfDouble.length) {
/* 906 */             arrayOfDouble = (double[])c.a(arrayOfDouble, b);
/* 907 */             b = 0;
/*     */           } 
/* 909 */           arrayOfDouble[b++] = d1;
/*     */         } 
/* 911 */       } catch (Exception exception2) {
/* 912 */         Exception exception1; throw l.a(exception1 = null, arrayOfDouble, c.a() + b);
/*     */       } 
/* 914 */       return (double[])c.b(arrayOfDouble, b);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private double[] g(l param1l, com.a.a.c.g param1g) {
/* 920 */       return new double[] { t(param1l, param1g) };
/*     */     }
/*     */ 
/*     */     
/*     */     private static double[] a(double[] param1ArrayOfdouble1, double[] param1ArrayOfdouble2) {
/* 925 */       int i = param1ArrayOfdouble1.length;
/* 926 */       int j = param1ArrayOfdouble2.length;
/* 927 */       param1ArrayOfdouble1 = Arrays.copyOf(param1ArrayOfdouble1, i + j);
/* 928 */       System.arraycopy(param1ArrayOfdouble2, 0, param1ArrayOfdouble1, i, j);
/* 929 */       return param1ArrayOfdouble1;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\b\aa.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */