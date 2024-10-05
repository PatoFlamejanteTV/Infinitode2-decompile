/*      */ package com.a.a.c.c.b;
/*      */ 
/*      */ import com.a.a.a.ak;
/*      */ import com.a.a.a.l;
/*      */ import com.a.a.b.b.b;
/*      */ import com.a.a.b.c.h;
/*      */ import com.a.a.b.l;
/*      */ import com.a.a.b.o;
/*      */ import com.a.a.b.s;
/*      */ import com.a.a.b.t;
/*      */ import com.a.a.c.a;
/*      */ import com.a.a.c.b.b;
/*      */ import com.a.a.c.b.f;
/*      */ import com.a.a.c.b.q;
/*      */ import com.a.a.c.c;
/*      */ import com.a.a.c.c.a.p;
/*      */ import com.a.a.c.c.a.q;
/*      */ import com.a.a.c.c.a.r;
/*      */ import com.a.a.c.c.f;
/*      */ import com.a.a.c.c.s;
/*      */ import com.a.a.c.c.v;
/*      */ import com.a.a.c.c.x;
/*      */ import com.a.a.c.f.b;
/*      */ import com.a.a.c.f.j;
/*      */ import com.a.a.c.g;
/*      */ import com.a.a.c.i;
/*      */ import com.a.a.c.i.e;
/*      */ import com.a.a.c.j;
/*      */ import com.a.a.c.k;
/*      */ import com.a.a.c.l.f;
/*      */ import com.a.a.c.m.a;
/*      */ import com.a.a.c.m.i;
/*      */ import com.a.a.c.m.k;
/*      */ import com.a.a.c.p;
/*      */ import com.a.a.c.q;
/*      */ import com.a.a.c.v;
/*      */ import java.io.Serializable;
/*      */ import java.util.Collection;
/*      */ import java.util.Date;
/*      */ import java.util.Map;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public abstract class ae<T>
/*      */   extends k<T>
/*      */   implements Serializable
/*      */ {
/*   51 */   protected static final int r = i.b
/*   52 */     .b() | i.c
/*   53 */     .b(); protected final Class<?> s; private j a;
/*      */   
/*      */   static {
/*   56 */     i.q
/*   57 */       .b(); i.t
/*   58 */       .b();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected ae(Class<?> paramClass) {
/*   71 */     this.s = paramClass;
/*   72 */     this.a = null;
/*      */   }
/*      */ 
/*      */   
/*      */   protected ae(j paramj) {
/*   77 */     this.s = (paramj == null) ? Object.class : paramj.b();
/*   78 */     this.a = paramj;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected ae(ae<?> paramae) {
/*   88 */     this.s = paramae.s;
/*   89 */     this.a = paramae.a;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Class<?> a() {
/*   99 */     return this.s;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public j h() {
/*  116 */     return this.a;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final j e(g paramg) {
/*  132 */     if (this.a != null) {
/*  133 */       return this.a;
/*      */     }
/*  135 */     return paramg.b(this.s);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public x i() {
/*  142 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static boolean a(k<?> paramk) {
/*  151 */     return i.e(paramk);
/*      */   }
/*      */   
/*      */   protected static boolean a(p paramp) {
/*  155 */     return i.e(paramp);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object a(l paraml, g paramg, e parame) {
/*  172 */     return parame.d(paraml, paramg);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected T d(l paraml, g paramg) {
/*  200 */     b b = h(paramg);
/*      */     
/*      */     boolean bool;
/*  203 */     if ((bool = paramg.a(i.q)) || b != b.a) {
/*      */       o o;
/*  205 */       if ((o = paraml.g()) == o.e) {
/*  206 */         switch (af.a[b.ordinal()]) {
/*      */           case 1:
/*  208 */             return (T)c(paramg);
/*      */           case 2:
/*      */           case 3:
/*  211 */             return (T)a(paramg);
/*      */         } 
/*      */       
/*  214 */       } else if (bool) {
/*  215 */         b = (b)c(paraml, paramg);
/*  216 */         if (paraml.g() != o.e) {
/*  217 */           j(paramg);
/*      */         }
/*  219 */         return (T)b;
/*      */       } 
/*      */     } 
/*  222 */     return (T)paramg.a(e(paramg), o.d, paraml, null, new Object[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final T m(l paraml, g paramg) {
/*  260 */     x x = i();
/*  261 */     Class<?> clazz = a();
/*  262 */     String str = paraml.R();
/*      */     
/*  264 */     if (x != null && x.e()) {
/*  265 */       return (T)x.a(paramg, str);
/*      */     }
/*  267 */     if (str.isEmpty()) {
/*  268 */       b b = paramg.a(b(), clazz, f.f);
/*      */       
/*  270 */       return (T)a(paramg, b, clazz);
/*      */     } 
/*      */     
/*  273 */     if (h(str)) {
/*  274 */       b b = paramg.a(b(), clazz, b.a);
/*      */       
/*  276 */       return (T)a(paramg, b, clazz);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  283 */     if (x != null) {
/*  284 */       str = str.trim();
/*  285 */       if (x.f() && 
/*  286 */         paramg.a(f.f, Integer.class, f.d) == b.b)
/*      */       {
/*  288 */         return (T)x.a(paramg, c(paramg, str));
/*      */       }
/*      */       
/*  291 */       if (x.g() && 
/*  292 */         paramg.a(f.f, Long.class, f.d) == b.b)
/*      */       {
/*  294 */         return (T)x.a(paramg, e(paramg, str));
/*      */       }
/*      */       
/*  297 */       if (x.k())
/*      */       {
/*  299 */         if (paramg.a(f.h, Boolean.class, f.d) == b.b) {
/*      */           
/*  301 */           String str1 = str.trim();
/*  302 */           if ("true".equals(str1)) {
/*  303 */             return (T)x.a(paramg, true);
/*      */           }
/*  305 */           if ("false".equals(str1)) {
/*  306 */             return (T)x.a(paramg, false);
/*      */           }
/*      */         } 
/*      */       }
/*      */     } 
/*  311 */     return (T)paramg.a(clazz, x, paramg.j(), "no String-argument constructor/factory method to deserialize from String value ('%s')", new Object[] { str });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final Object a(g paramg, b paramb, Class<?> paramClass) {
/*  320 */     switch (af.a[paramb.ordinal()]) {
/*      */       case 1:
/*  322 */         return c(paramg);
/*      */       
/*      */       case 4:
/*  325 */         a(paramg, paramb, paramClass, "", "empty String (\"\")");
/*      */         break;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  331 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private T c(l paraml, g paramg) {
/*      */     Object object;
/*  359 */     if (paraml.a(o.d))
/*      */     {
/*      */       
/*  362 */       return (T)(object = f(paraml, paramg));
/*      */     }
/*  364 */     return (T)a((l)object, paramg);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final boolean n(l paraml, g paramg) {
/*  389 */     switch (paraml.l()) {
/*      */       case 6:
/*  391 */         str = paraml.w();
/*      */         break;
/*      */ 
/*      */ 
/*      */       
/*      */       case 7:
/*  397 */         return Boolean.TRUE.equals(i((l)str, paramg, boolean.class));
/*      */       case 9:
/*  399 */         return true;
/*      */       case 10:
/*  401 */         return false;
/*      */       case 11:
/*  403 */         f(paramg);
/*  404 */         return false;
/*      */       
/*      */       case 1:
/*  407 */         str = paramg.a((l)str, boolean.class);
/*      */         break;
/*      */       
/*      */       case 3:
/*  411 */         if (paramg.a(i.q)) {
/*  412 */           if (str.g() == o.d) {
/*  413 */             return ((Boolean)f((l)str, paramg)).booleanValue();
/*      */           }
/*  415 */           boolean bool1 = n((l)str, paramg);
/*  416 */           g((l)str, paramg);
/*  417 */           return bool1;
/*      */         } 
/*      */       
/*      */       default:
/*  421 */         return ((Boolean)paramg.a(boolean.class, (l)str)).booleanValue();
/*      */     } 
/*      */ 
/*      */     
/*      */     b b;
/*  426 */     if ((b = a(paramg, str, f.h, boolean.class)) == b.c) {
/*  427 */       f(paramg);
/*  428 */       return false;
/*      */     } 
/*  430 */     if (b == b.d) {
/*  431 */       return false;
/*      */     }
/*      */     
/*      */     String str;
/*      */     
/*      */     int i;
/*      */     
/*  438 */     if ((i = (str = str.trim()).length()) == 4) {
/*  439 */       if (j(str)) {
/*  440 */         return true;
/*      */       }
/*  442 */     } else if (i == 5 && 
/*  443 */       k(str)) {
/*  444 */       return false;
/*      */     } 
/*      */     
/*  447 */     if (d(str)) {
/*  448 */       g(paramg, str);
/*  449 */       return false;
/*      */     } 
/*  451 */     Boolean bool = (Boolean)paramg.b(boolean.class, str, "only \"true\"/\"True\"/\"TRUE\" or \"false\"/\"False\"/\"FALSE\" recognized", new Object[0]);
/*      */     
/*  453 */     return Boolean.TRUE.equals(bool);
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean j(String paramString) {
/*      */     char c;
/*  459 */     if ((c = paramString.charAt(0)) == 't') {
/*  460 */       return "true".equals(paramString);
/*      */     }
/*  462 */     if (c == 'T') {
/*  463 */       return ("TRUE".equals(paramString) || "True".equals(paramString));
/*      */     }
/*  465 */     return false;
/*      */   }
/*      */   
/*      */   private static boolean k(String paramString) {
/*      */     char c;
/*  470 */     if ((c = paramString.charAt(0)) == 'f') {
/*  471 */       return "false".equals(paramString);
/*      */     }
/*  473 */     if (c == 'F') {
/*  474 */       return ("FALSE".equals(paramString) || "False".equals(paramString));
/*      */     }
/*  476 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final Boolean a(l paraml, g paramg, Class<?> paramClass) {
/*  502 */     switch (paraml.l()) {
/*      */       case 6:
/*  504 */         str = paraml.w();
/*      */         break;
/*      */       
/*      */       case 7:
/*  508 */         return i((l)str, paramg, paramClass);
/*      */       case 9:
/*  510 */         return Boolean.TRUE;
/*      */       case 10:
/*  512 */         return Boolean.FALSE;
/*      */       case 11:
/*  514 */         return null;
/*      */       
/*      */       case 1:
/*  517 */         str = paramg.a((l)str, paramClass);
/*      */         break;
/*      */       case 3:
/*  520 */         return (Boolean)d((l)str, paramg);
/*      */       default:
/*  522 */         return (Boolean)paramg.a(paramClass, (l)str);
/*      */     } 
/*      */ 
/*      */     
/*      */     b b;
/*  527 */     if ((b = a(paramg, str, f.h, paramClass)) == b.c) {
/*  528 */       return null;
/*      */     }
/*  530 */     if (b == b.d) {
/*  531 */       return Boolean.FALSE;
/*      */     }
/*      */     
/*      */     String str;
/*      */     
/*      */     int i;
/*      */     
/*  538 */     if ((i = (str = str.trim()).length()) == 4) {
/*  539 */       if (j(str)) {
/*  540 */         return Boolean.TRUE;
/*      */       }
/*  542 */     } else if (i == 5 && 
/*  543 */       k(str)) {
/*  544 */       return Boolean.FALSE;
/*      */     } 
/*      */     
/*  547 */     if (b(paramg, str)) {
/*  548 */       return null;
/*      */     }
/*  550 */     return (Boolean)paramg.b(paramClass, str, "only \"true\" or \"false\" recognized", new Object[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final byte o(l paraml, g paramg) {
/*      */     int i;
/*  558 */     switch (paraml.l()) {
/*      */       case 6:
/*  560 */         str = paraml.w();
/*      */         break;
/*      */       
/*      */       case 8:
/*  564 */         if ((b = d((l)str, paramg, byte.class)) == b.c) {
/*  565 */           return 0;
/*      */         }
/*  567 */         if (b == b.d) {
/*  568 */           return 0;
/*      */         }
/*  570 */         return str.E();
/*      */       case 7:
/*  572 */         return str.E();
/*      */       case 11:
/*  574 */         f(paramg);
/*  575 */         return 0;
/*      */       
/*      */       case 1:
/*  578 */         str = paramg.a((l)str, byte.class);
/*      */         break;
/*      */       
/*      */       case 3:
/*  582 */         if (paramg.a(i.q)) {
/*  583 */           if (str.g() == o.d) {
/*  584 */             return ((Byte)f((l)str, paramg)).byteValue();
/*      */           }
/*  586 */           i = o((l)str, paramg);
/*  587 */           g((l)str, paramg);
/*  588 */           return i;
/*      */         } 
/*      */       
/*      */       default:
/*  592 */         return ((Byte)paramg.a(paramg.b(byte.class), (l)str)).byteValue();
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*      */     b b;
/*  598 */     if ((b = a(paramg, str, f.f, byte.class)) == b.c) {
/*      */       
/*  600 */       f(paramg);
/*  601 */       return 0;
/*      */     } 
/*  603 */     if (b == b.d) {
/*  604 */       return 0;
/*      */     }
/*      */     String str;
/*  607 */     if (d(str = str.trim())) {
/*  608 */       g(paramg, str);
/*  609 */       return 0;
/*      */     } 
/*      */     
/*      */     try {
/*  613 */       i = h.a(str);
/*  614 */     } catch (IllegalArgumentException illegalArgumentException) {
/*  615 */       return ((Byte)paramg.b(this.s, str, "not a valid `byte` value", new Object[0])).byteValue();
/*      */     } 
/*      */ 
/*      */     
/*  619 */     if (a(i)) {
/*  620 */       return ((Byte)paramg.b(this.s, str, "overflow, value cannot be represented as 8-bit value", new Object[0])).byteValue();
/*      */     }
/*      */     
/*  623 */     return (byte)i;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected final short p(l paraml, g paramg) {
/*      */     int i;
/*  630 */     switch (paraml.l()) {
/*      */       case 6:
/*  632 */         str = paraml.w();
/*      */         break;
/*      */       
/*      */       case 8:
/*  636 */         if ((b = d((l)str, paramg, short.class)) == b.c) {
/*  637 */           return 0;
/*      */         }
/*  639 */         if (b == b.d) {
/*  640 */           return 0;
/*      */         }
/*  642 */         return str.F();
/*      */       case 7:
/*  644 */         return str.F();
/*      */       case 11:
/*  646 */         f(paramg);
/*  647 */         return 0;
/*      */       
/*      */       case 1:
/*  650 */         str = paramg.a((l)str, short.class);
/*      */         break;
/*      */       
/*      */       case 3:
/*  654 */         if (paramg.a(i.q)) {
/*  655 */           if (str.g() == o.d) {
/*  656 */             return ((Short)f((l)str, paramg)).shortValue();
/*      */           }
/*  658 */           i = p((l)str, paramg);
/*  659 */           g((l)str, paramg);
/*  660 */           return i;
/*      */         } 
/*      */       
/*      */       default:
/*  664 */         return ((Short)paramg.a(paramg.b(short.class), (l)str)).shortValue();
/*      */     } 
/*      */ 
/*      */     
/*      */     b b;
/*  669 */     if ((b = a(paramg, str, f.f, short.class)) == b.c) {
/*      */       
/*  671 */       f(paramg);
/*  672 */       return 0;
/*      */     } 
/*  674 */     if (b == b.d) {
/*  675 */       return 0;
/*      */     }
/*      */     String str;
/*  678 */     if (d(str = str.trim())) {
/*  679 */       g(paramg, str);
/*  680 */       return 0;
/*      */     } 
/*      */     
/*      */     try {
/*  684 */       i = h.a(str);
/*  685 */     } catch (IllegalArgumentException illegalArgumentException) {
/*  686 */       return ((Short)paramg.b(short.class, str, "not a valid `short` value", new Object[0])).shortValue();
/*      */     } 
/*      */     
/*  689 */     if (b(i)) {
/*  690 */       return ((Short)paramg.b(short.class, str, "overflow, value cannot be represented as 16-bit value", new Object[0])).shortValue();
/*      */     }
/*      */     
/*  693 */     return (short)i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final int q(l paraml, g paramg) {
/*  700 */     switch (paraml.l()) {
/*      */       case 6:
/*  702 */         str = paraml.w();
/*      */         break;
/*      */       
/*      */       case 8:
/*  706 */         if ((b = d((l)str, paramg, int.class)) == b.c) {
/*  707 */           return 0;
/*      */         }
/*  709 */         if (b == b.d) {
/*  710 */           return 0;
/*      */         }
/*  712 */         return str.P();
/*      */       case 7:
/*  714 */         return str.G();
/*      */       case 11:
/*  716 */         f(paramg);
/*  717 */         return 0;
/*      */       
/*      */       case 1:
/*  720 */         str = paramg.a((l)str, int.class);
/*      */         break;
/*      */       case 3:
/*  723 */         if (paramg.a(i.q)) {
/*  724 */           if (str.g() == o.d) {
/*  725 */             return ((Integer)f((l)str, paramg)).intValue();
/*      */           }
/*  727 */           int i = q((l)str, paramg);
/*  728 */           g((l)str, paramg);
/*  729 */           return i;
/*      */         } 
/*      */       
/*      */       default:
/*  733 */         return ((Number)paramg.a(int.class, (l)str)).intValue();
/*      */     } 
/*      */ 
/*      */     
/*      */     b b;
/*  738 */     if ((b = a(paramg, str, f.f, int.class)) == b.c) {
/*      */       
/*  740 */       f(paramg);
/*  741 */       return 0;
/*      */     } 
/*  743 */     if (b == b.d) {
/*  744 */       return 0;
/*      */     }
/*      */     String str;
/*  747 */     if (d(str = str.trim())) {
/*  748 */       g(paramg, str);
/*  749 */       return 0;
/*      */     } 
/*  751 */     return c(paramg, str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int c(g paramg, String paramString) {
/*      */     try {
/*  760 */       if (paramString.length() > 9) {
/*      */         Number number; long l;
/*  762 */         if (a(l = h.b(paramString)))
/*      */         {
/*      */ 
/*      */           
/*  766 */           return a(number = (Number)paramg.b(int.class, paramString, "Overflow: numeric value (%s) out of range of int (%d -%d)", new Object[] { paramString, Integer.valueOf(-2147483648), Integer.valueOf(2147483647) })).intValue();
/*      */         }
/*  768 */         return (int)number;
/*      */       } 
/*  770 */       return h.a(paramString);
/*  771 */     } catch (IllegalArgumentException illegalArgumentException) {
/*      */       Number number;
/*      */       
/*  774 */       return a(number = (Number)paramg.b(int.class, paramString, "not a valid `int` value", new Object[0])).intValue();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final Integer b(l paraml, g paramg, Class<?> paramClass) {
/*  786 */     switch (paraml.l()) {
/*      */       case 6:
/*  788 */         str = paraml.w();
/*      */         break;
/*      */       
/*      */       case 8:
/*  792 */         if ((b = d((l)str, paramg, paramClass)) == b.c) {
/*  793 */           return (Integer)a(paramg);
/*      */         }
/*  795 */         if (b == b.d) {
/*  796 */           return (Integer)c(paramg);
/*      */         }
/*  798 */         return Integer.valueOf(str.P());
/*      */       case 7:
/*  800 */         return Integer.valueOf(str.G());
/*      */       case 11:
/*  802 */         return (Integer)a(paramg);
/*      */       
/*      */       case 1:
/*  805 */         str = paramg.a((l)str, (Class)b);
/*      */         break;
/*      */       case 3:
/*  808 */         return (Integer)d((l)str, paramg);
/*      */       default:
/*  810 */         return (Integer)paramg.a(e(paramg), (l)str);
/*      */     } 
/*      */     
/*      */     b b;
/*  814 */     if ((b = a(paramg, str)) == b.c) {
/*  815 */       return (Integer)a(paramg);
/*      */     }
/*  817 */     if (b == b.d) {
/*  818 */       return (Integer)c(paramg);
/*      */     }
/*  820 */     String str = str.trim();
/*  821 */     if (b(paramg, str)) {
/*  822 */       return (Integer)a(paramg);
/*      */     }
/*  824 */     return d(paramg, str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Integer d(g paramg, String paramString) {
/*      */     try {
/*  833 */       if (paramString.length() > 9) {
/*      */         long l;
/*  835 */         if (a(l = h.b(paramString))) {
/*  836 */           return (Integer)paramg.b(Integer.class, paramString, "Overflow: numeric value (%s) out of range of `java.lang.Integer` (%d -%d)", new Object[] { paramString, 
/*      */                 
/*  838 */                 Integer.valueOf(-2147483648), Integer.valueOf(2147483647) });
/*      */         }
/*  840 */         return Integer.valueOf((int)l);
/*      */       } 
/*  842 */       return Integer.valueOf(h.a(paramString));
/*  843 */     } catch (IllegalArgumentException illegalArgumentException) {
/*  844 */       return (Integer)paramg.b(Integer.class, paramString, "not a valid `java.lang.Integer` value", new Object[0]);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final long r(l paraml, g paramg) {
/*  853 */     switch (paraml.l()) {
/*      */       case 6:
/*  855 */         str = paraml.w();
/*      */         break;
/*      */       
/*      */       case 8:
/*  859 */         if ((b = d((l)str, paramg, long.class)) == b.c) {
/*  860 */           return 0L;
/*      */         }
/*  862 */         if (b == b.d) {
/*  863 */           return 0L;
/*      */         }
/*  865 */         return str.Q();
/*      */       case 7:
/*  867 */         return str.H();
/*      */       case 11:
/*  869 */         f(paramg);
/*  870 */         return 0L;
/*      */       
/*      */       case 1:
/*  873 */         str = paramg.a((l)str, long.class);
/*      */         break;
/*      */       case 3:
/*  876 */         if (paramg.a(i.q)) {
/*  877 */           if (str.g() == o.d) {
/*  878 */             return ((Long)f((l)str, paramg)).longValue();
/*      */           }
/*  880 */           long l1 = r((l)str, paramg);
/*  881 */           g((l)str, paramg);
/*  882 */           return l1;
/*      */         } 
/*      */       
/*      */       default:
/*  886 */         return ((Number)paramg.a(long.class, (l)str)).longValue();
/*      */     } 
/*      */ 
/*      */     
/*      */     b b;
/*  891 */     if ((b = a(paramg, str, f.f, long.class)) == b.c) {
/*      */       
/*  893 */       f(paramg);
/*  894 */       return 0L;
/*      */     } 
/*  896 */     if (b == b.d) {
/*  897 */       return 0L;
/*      */     }
/*      */     String str;
/*  900 */     if (d(str = str.trim())) {
/*  901 */       g(paramg, str);
/*  902 */       return 0L;
/*      */     } 
/*  904 */     return e(paramg, str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private long e(g paramg, String paramString) {
/*      */     try {
/*  913 */       return h.b(paramString);
/*  914 */     } catch (IllegalArgumentException illegalArgumentException) {
/*      */       Number number;
/*      */ 
/*      */       
/*  918 */       return a(number = (Number)paramg.b(long.class, paramString, "not a valid `long` value", new Object[0])).longValue();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final Long c(l paraml, g paramg, Class<?> paramClass) {
/*  930 */     switch (paraml.l()) {
/*      */       case 6:
/*  932 */         str = paraml.w();
/*      */         break;
/*      */       
/*      */       case 8:
/*  936 */         if ((b = d((l)str, paramg, paramClass)) == b.c) {
/*  937 */           return (Long)a(paramg);
/*      */         }
/*  939 */         if (b == b.d) {
/*  940 */           return (Long)c(paramg);
/*      */         }
/*  942 */         return Long.valueOf(str.Q());
/*      */       case 11:
/*  944 */         return (Long)a(paramg);
/*      */       case 7:
/*  946 */         return Long.valueOf(str.H());
/*      */       
/*      */       case 1:
/*  949 */         str = paramg.a((l)str, (Class)b);
/*      */         break;
/*      */       case 3:
/*  952 */         return (Long)d((l)str, paramg);
/*      */       default:
/*  954 */         return (Long)paramg.a(e(paramg), (l)str);
/*      */     } 
/*      */     
/*      */     b b;
/*  958 */     if ((b = a(paramg, str)) == b.c) {
/*  959 */       return (Long)a(paramg);
/*      */     }
/*  961 */     if (b == b.d) {
/*  962 */       return (Long)c(paramg);
/*      */     }
/*  964 */     String str = str.trim();
/*  965 */     if (b(paramg, str)) {
/*  966 */       return (Long)a(paramg);
/*      */     }
/*      */     
/*  969 */     return f(paramg, str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Long f(g paramg, String paramString) {
/*      */     try {
/*  978 */       return Long.valueOf(h.b(paramString));
/*  979 */     } catch (IllegalArgumentException illegalArgumentException) {
/*  980 */       return (Long)paramg.b(Long.class, paramString, "not a valid `java.lang.Long` value", new Object[0]);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final float s(l paraml, g paramg) {
/*      */     // Byte code:
/*      */     //   0: aload_1
/*      */     //   1: invokevirtual l : ()I
/*      */     //   4: tableswitch default -> 174, 1 -> 114, 2 -> 174, 3 -> 126, 4 -> 174, 5 -> 174, 6 -> 64, 7 -> 72, 8 -> 102, 9 -> 174, 10 -> 174, 11 -> 107
/*      */     //   64: aload_1
/*      */     //   65: invokevirtual w : ()Ljava/lang/String;
/*      */     //   68: astore_3
/*      */     //   69: goto -> 189
/*      */     //   72: aload_0
/*      */     //   73: aload_1
/*      */     //   74: aload_2
/*      */     //   75: getstatic java/lang/Float.TYPE : Ljava/lang/Class;
/*      */     //   78: invokevirtual e : (Lcom/a/a/b/l;Lcom/a/a/c/g;Ljava/lang/Class;)Lcom/a/a/c/b/b;
/*      */     //   81: dup
/*      */     //   82: astore #4
/*      */     //   84: getstatic com/a/a/c/b/b.c : Lcom/a/a/c/b/b;
/*      */     //   87: if_acmpne -> 92
/*      */     //   90: fconst_0
/*      */     //   91: freturn
/*      */     //   92: aload #4
/*      */     //   94: getstatic com/a/a/c/b/b.d : Lcom/a/a/c/b/b;
/*      */     //   97: if_acmpne -> 102
/*      */     //   100: fconst_0
/*      */     //   101: freturn
/*      */     //   102: aload_1
/*      */     //   103: invokevirtual J : ()F
/*      */     //   106: freturn
/*      */     //   107: aload_0
/*      */     //   108: aload_2
/*      */     //   109: invokevirtual f : (Lcom/a/a/c/g;)V
/*      */     //   112: fconst_0
/*      */     //   113: freturn
/*      */     //   114: aload_2
/*      */     //   115: aload_1
/*      */     //   116: getstatic java/lang/Float.TYPE : Ljava/lang/Class;
/*      */     //   119: invokevirtual a : (Lcom/a/a/b/l;Ljava/lang/Class;)Ljava/lang/String;
/*      */     //   122: astore_3
/*      */     //   123: goto -> 189
/*      */     //   126: aload_2
/*      */     //   127: getstatic com/a/a/c/i.q : Lcom/a/a/c/i;
/*      */     //   130: invokevirtual a : (Lcom/a/a/c/i;)Z
/*      */     //   133: ifeq -> 174
/*      */     //   136: aload_1
/*      */     //   137: invokevirtual g : ()Lcom/a/a/b/o;
/*      */     //   140: getstatic com/a/a/b/o.d : Lcom/a/a/b/o;
/*      */     //   143: if_acmpne -> 159
/*      */     //   146: aload_0
/*      */     //   147: aload_1
/*      */     //   148: aload_2
/*      */     //   149: invokevirtual f : (Lcom/a/a/b/l;Lcom/a/a/c/g;)Ljava/lang/Object;
/*      */     //   152: checkcast java/lang/Float
/*      */     //   155: invokevirtual floatValue : ()F
/*      */     //   158: freturn
/*      */     //   159: aload_0
/*      */     //   160: aload_1
/*      */     //   161: aload_2
/*      */     //   162: invokevirtual s : (Lcom/a/a/b/l;Lcom/a/a/c/g;)F
/*      */     //   165: fstore_3
/*      */     //   166: aload_0
/*      */     //   167: aload_1
/*      */     //   168: aload_2
/*      */     //   169: invokevirtual g : (Lcom/a/a/b/l;Lcom/a/a/c/g;)V
/*      */     //   172: fload_3
/*      */     //   173: freturn
/*      */     //   174: aload_2
/*      */     //   175: getstatic java/lang/Float.TYPE : Ljava/lang/Class;
/*      */     //   178: aload_1
/*      */     //   179: invokevirtual a : (Ljava/lang/Class;Lcom/a/a/b/l;)Ljava/lang/Object;
/*      */     //   182: checkcast java/lang/Number
/*      */     //   185: invokevirtual floatValue : ()F
/*      */     //   188: freturn
/*      */     //   189: aload_0
/*      */     //   190: aload_3
/*      */     //   191: invokevirtual b : (Ljava/lang/String;)Ljava/lang/Float;
/*      */     //   194: dup
/*      */     //   195: astore #4
/*      */     //   197: ifnull -> 206
/*      */     //   200: aload #4
/*      */     //   202: invokevirtual floatValue : ()F
/*      */     //   205: freturn
/*      */     //   206: aload_0
/*      */     //   207: aload_2
/*      */     //   208: aload_3
/*      */     //   209: getstatic com/a/a/c/l/f.f : Lcom/a/a/c/l/f;
/*      */     //   212: getstatic java/lang/Float.TYPE : Ljava/lang/Class;
/*      */     //   215: invokevirtual a : (Lcom/a/a/c/g;Ljava/lang/String;Lcom/a/a/c/l/f;Ljava/lang/Class;)Lcom/a/a/c/b/b;
/*      */     //   218: dup
/*      */     //   219: astore #4
/*      */     //   221: getstatic com/a/a/c/b/b.c : Lcom/a/a/c/b/b;
/*      */     //   224: if_acmpne -> 234
/*      */     //   227: aload_0
/*      */     //   228: aload_2
/*      */     //   229: invokevirtual f : (Lcom/a/a/c/g;)V
/*      */     //   232: fconst_0
/*      */     //   233: freturn
/*      */     //   234: aload #4
/*      */     //   236: getstatic com/a/a/c/b/b.d : Lcom/a/a/c/b/b;
/*      */     //   239: if_acmpne -> 244
/*      */     //   242: fconst_0
/*      */     //   243: freturn
/*      */     //   244: aload_3
/*      */     //   245: invokevirtual trim : ()Ljava/lang/String;
/*      */     //   248: dup
/*      */     //   249: astore_3
/*      */     //   250: invokestatic d : (Ljava/lang/String;)Z
/*      */     //   253: ifeq -> 264
/*      */     //   256: aload_0
/*      */     //   257: aload_2
/*      */     //   258: aload_3
/*      */     //   259: invokevirtual g : (Lcom/a/a/c/g;Ljava/lang/String;)V
/*      */     //   262: fconst_0
/*      */     //   263: freturn
/*      */     //   264: aload_0
/*      */     //   265: aload_1
/*      */     //   266: aload_2
/*      */     //   267: aload_3
/*      */     //   268: invokevirtual a : (Lcom/a/a/b/l;Lcom/a/a/c/g;Ljava/lang/String;)F
/*      */     //   271: freturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #988	-> 0
/*      */     //   #990	-> 64
/*      */     //   #991	-> 69
/*      */     //   #993	-> 72
/*      */     //   #994	-> 82
/*      */     //   #995	-> 90
/*      */     //   #997	-> 92
/*      */     //   #998	-> 100
/*      */     //   #1002	-> 102
/*      */     //   #1004	-> 107
/*      */     //   #1005	-> 112
/*      */     //   #1008	-> 114
/*      */     //   #1009	-> 123
/*      */     //   #1011	-> 126
/*      */     //   #1012	-> 136
/*      */     //   #1013	-> 146
/*      */     //   #1015	-> 159
/*      */     //   #1016	-> 166
/*      */     //   #1017	-> 172
/*      */     //   #1021	-> 174
/*      */     //   #1028	-> 189
/*      */     //   #1029	-> 195
/*      */     //   #1030	-> 200
/*      */     //   #1034	-> 206
/*      */     //   #1036	-> 219
/*      */     //   #1038	-> 227
/*      */     //   #1039	-> 232
/*      */     //   #1041	-> 234
/*      */     //   #1042	-> 242
/*      */     //   #1044	-> 244
/*      */     //   #1045	-> 249
/*      */     //   #1046	-> 256
/*      */     //   #1047	-> 262
/*      */     //   #1049	-> 264
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private float a(l paraml, g paramg, String paramString) {
/*      */     try {
/* 1073 */       return h.c(paramString, paraml.a(t.a));
/* 1074 */     } catch (IllegalArgumentException illegalArgumentException) {
/*      */       Number number;
/*      */       
/* 1077 */       return a(number = (Number)paramg.b(float.class, paramString, "not a valid `float` value", new Object[0])).floatValue();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final Float b(String paramString) {
/* 1094 */     if (!paramString.isEmpty()) {
/* 1095 */       switch (paramString.charAt(0)) {
/*      */         case 'I':
/* 1097 */           if (f(paramString)) {
/* 1098 */             return Float.valueOf(Float.POSITIVE_INFINITY);
/*      */           }
/*      */           break;
/*      */         case 'N':
/* 1102 */           if (g(paramString)) return Float.valueOf(Float.NaN); 
/*      */           break;
/*      */         case '-':
/* 1105 */           if (e(paramString)) {
/* 1106 */             return Float.valueOf(Float.NEGATIVE_INFINITY);
/*      */           }
/*      */           break;
/*      */       } 
/*      */     
/*      */     }
/* 1112 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected final double t(l paraml, g paramg) {
/*      */     b b2;
/* 1119 */     switch (paraml.l()) {
/*      */       case 6:
/* 1121 */         str = paraml.w();
/*      */         break;
/*      */       
/*      */       case 7:
/* 1125 */         if ((b2 = e(paraml, paramg, double.class)) == b.c) {
/* 1126 */           return 0.0D;
/*      */         }
/* 1128 */         if (b2 == b.d) {
/* 1129 */           return 0.0D;
/*      */         }
/*      */       
/*      */       case 8:
/* 1133 */         return paraml.K();
/*      */       case 11:
/* 1135 */         f(paramg);
/* 1136 */         return 0.0D;
/*      */       
/*      */       case 1:
/* 1139 */         str = paramg.a(paraml, double.class);
/*      */         break;
/*      */       case 3:
/* 1142 */         if (paramg.a(i.q)) {
/* 1143 */           if (paraml.g() == o.d) {
/* 1144 */             return ((Double)f(paraml, paramg)).doubleValue();
/*      */           }
/* 1146 */           double d = t(paraml, paramg);
/* 1147 */           g(paraml, paramg);
/* 1148 */           return d;
/*      */         } 
/*      */       
/*      */       default:
/* 1152 */         return ((Number)paramg.a(double.class, paraml)).doubleValue();
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Double double_;
/* 1160 */     if ((double_ = c(str)) != null) {
/* 1161 */       return double_.doubleValue();
/*      */     }
/*      */ 
/*      */     
/*      */     b b1;
/*      */     
/* 1167 */     if ((b1 = a(paramg, str, f.f, double.class)) == b.c) {
/*      */       
/* 1169 */       f(paramg);
/* 1170 */       return 0.0D;
/*      */     } 
/* 1172 */     if (b1 == b.d) {
/* 1173 */       return 0.0D;
/*      */     }
/*      */     String str;
/* 1176 */     if (d(str = str.trim())) {
/* 1177 */       g(paramg, str);
/* 1178 */       return 0.0D;
/*      */     } 
/* 1180 */     return b(paraml, paramg, str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private double b(l paraml, g paramg, String paramString) {
/*      */     try {
/* 1204 */       return a(paramString, paraml.a(t.a));
/* 1205 */     } catch (IllegalArgumentException illegalArgumentException) {
/*      */       Number number;
/*      */       
/* 1208 */       return a(number = (Number)paramg.b(double.class, paramString, "not a valid `double` value (as String to convert)", new Object[0])).doubleValue();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static final double a(String paramString, boolean paramBoolean) {
/* 1231 */     return h.b(paramString, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final Double c(String paramString) {
/* 1248 */     if (!paramString.isEmpty()) {
/* 1249 */       switch (paramString.charAt(0)) {
/*      */         case 'I':
/* 1251 */           if (f(paramString)) {
/* 1252 */             return Double.valueOf(Double.POSITIVE_INFINITY);
/*      */           }
/*      */           break;
/*      */         case 'N':
/* 1256 */           if (g(paramString)) {
/* 1257 */             return Double.valueOf(Double.NaN);
/*      */           }
/*      */           break;
/*      */         case '-':
/* 1261 */           if (e(paramString)) {
/* 1262 */             return Double.valueOf(Double.NEGATIVE_INFINITY);
/*      */           }
/*      */           break;
/*      */       } 
/*      */     
/*      */     }
/* 1268 */     return null;
/*      */   }
/*      */   protected Date a_(l paraml, g paramg) {
/*      */     String str2;
/*      */     Number number;
/*      */     String str1;
/*      */     long l1;
/* 1275 */     switch (paraml.l()) {
/*      */       case 6:
/* 1277 */         str2 = paraml.w();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1304 */         return a(str2.trim(), paramg);case 7: try { l1 = str2.H(); } catch (b b) { l1 = (number = (Number)paramg.a(this.s, str2.B(), "not a valid 64-bit `long` for creating `java.util.Date`", new Object[0])).longValue(); }  return new Date(l1);case 11: return (Date)a(paramg);case 1: str1 = paramg.a((l)number, this.s); return a(str1.trim(), paramg);
/*      */       case 3:
/*      */         return e((l)str1, paramg);
/*      */     } 
/*      */     return (Date)paramg.a(this.s, (l)str1);
/*      */   }
/*      */   private Date e(l paraml, g paramg) {
/* 1311 */     b b = h(paramg);
/*      */     
/*      */     boolean bool;
/* 1314 */     if ((bool = paramg.a(i.q)) || b != b.a) {
/*      */       o o;
/* 1316 */       if ((o = paraml.g()) == o.e) {
/* 1317 */         switch (af.a[b.ordinal()]) {
/*      */           case 1:
/* 1319 */             return (Date)c(paramg);
/*      */           case 2:
/*      */           case 3:
/* 1322 */             return (Date)a(paramg);
/*      */         } 
/*      */       
/* 1325 */       } else if (bool) {
/* 1326 */         if (o == o.d) {
/* 1327 */           return (Date)f(paraml, paramg);
/*      */         }
/* 1329 */         Date date = a_(paraml, paramg);
/* 1330 */         g(paraml, paramg);
/* 1331 */         return date;
/*      */       } 
/*      */     } 
/* 1334 */     return (Date)paramg.a(this.s, o.d, paraml, null, new Object[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Date a(String paramString, g paramg) {
/*      */     try {
/* 1345 */       if (paramString.isEmpty()) {
/* 1346 */         b b = a(paramg, paramString);
/* 1347 */         switch (af.a[b.ordinal()]) {
/*      */           case 1:
/* 1349 */             return new Date(0L);
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/* 1354 */         return null;
/*      */       } 
/*      */       
/* 1357 */       if (d(paramString)) {
/* 1358 */         return null;
/*      */       }
/* 1360 */       return paramg.c(paramString);
/* 1361 */     } catch (IllegalArgumentException illegalArgumentException) {
/* 1362 */       return (Date)paramg.b(this.s, paramString, "not a valid representation (error: %s)", new Object[] {
/*      */             
/* 1364 */             i.g(illegalArgumentException)
/*      */           });
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final String a(l paraml, g paramg, s params) {
/* 1403 */     b b = b.b;
/*      */     
/* 1405 */     switch (paraml.l()) {
/*      */       case 6:
/* 1407 */         return paraml.w();
/*      */ 
/*      */       
/*      */       case 12:
/* 1411 */         if (object = paraml.N() instanceof byte[]) {
/* 1412 */           return paramg.k().a((byte[])object, false);
/*      */         }
/* 1414 */         if (object == null) {
/* 1415 */           return null;
/*      */         }
/*      */         
/* 1418 */         return object.toString();
/*      */       
/*      */       case 1:
/* 1421 */         return paramg.a(paraml, this.s);
/*      */       case 7:
/* 1423 */         b = f(paraml, paramg, this.s);
/*      */         break;
/*      */       case 8:
/* 1426 */         b = g(paraml, paramg, this.s);
/*      */         break;
/*      */       case 9:
/*      */       case 10:
/* 1430 */         b = h(paraml, paramg, this.s);
/*      */         break;
/*      */     } 
/*      */     
/* 1434 */     if (b == b.c) {
/* 1435 */       return (String)object.a(paramg);
/*      */     }
/* 1437 */     if (b == b.d) {
/* 1438 */       return "";
/*      */     }
/*      */ 
/*      */     
/*      */     Object object;
/*      */     
/* 1444 */     if (paraml.k().g() && (
/*      */       
/* 1446 */       object = paraml.R()) != null) {
/* 1447 */       return (String)object;
/*      */     }
/*      */     
/* 1450 */     return (String)paramg.a(e(paramg), paraml);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static boolean d(String paramString) {
/* 1461 */     return "null".equals(paramString);
/*      */   }
/*      */   
/*      */   protected static boolean e(String paramString) {
/* 1465 */     return ("-Infinity".equals(paramString) || "-INF".equals(paramString));
/*      */   }
/*      */   
/*      */   protected static boolean f(String paramString) {
/* 1469 */     return ("Infinity".equals(paramString) || "INF".equals(paramString));
/*      */   }
/*      */   protected static boolean g(String paramString) {
/* 1472 */     return "NaN".equals(paramString);
/*      */   }
/*      */ 
/*      */   
/*      */   protected static final boolean h(String paramString) {
/* 1477 */     int i = paramString.length();
/* 1478 */     for (byte b = 0; b < i; b++) {
/* 1479 */       if (paramString.charAt(b) > ' ') {
/* 1480 */         return false;
/*      */       }
/*      */     } 
/* 1483 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final b a(g paramg, String paramString) {
/* 1498 */     return a(paramg, paramString, b(), a());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private b a(g paramg, String paramString, f paramf, Class<?> paramClass) {
/* 1515 */     if (paramString.isEmpty()) {
/* 1516 */       b = paramg.a(paramf, paramClass, f.f);
/*      */       
/* 1518 */       return a(paramg, b, paramClass, paramString, "empty String (\"\")");
/*      */     } 
/* 1520 */     if (h(paramString)) {
/* 1521 */       b = paramg.a((f)b, paramClass, b.a);
/* 1522 */       return a(paramg, b, paramClass, paramString, "blank String (all whitespace)");
/*      */     } 
/*      */ 
/*      */     
/* 1526 */     if (paramg.a(s.b)) {
/* 1527 */       return b.b;
/*      */     }
/*      */     b b;
/* 1530 */     if ((b = paramg.a((f)b, paramClass, f.d)) == b.a)
/*      */     {
/* 1532 */       paramg.a(this, "Cannot coerce String value (\"%s\") to %s (but might if coercion using `CoercionConfig` was enabled)", new Object[] { paramString, 
/*      */             
/* 1534 */             k() });
/*      */     }
/*      */     
/* 1537 */     return b;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final b d(l paraml, g paramg, Class<?> paramClass) {
/*      */     b b;
/* 1549 */     if ((b = paramg.a(f.f, paramClass, f.b)) == b.a) {
/* 1550 */       return a(paramg, b, paramClass, paraml.B(), "Floating-point value (" + paraml
/* 1551 */           .w() + ")");
/*      */     }
/* 1553 */     return b;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private b f(l paraml, g paramg, Class<?> paramClass) {
/* 1563 */     return a(paraml, paramg, paramClass, paraml.B(), f.a);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private b g(l paraml, g paramg, Class<?> paramClass) {
/* 1573 */     return a(paraml, paramg, paramClass, paraml.B(), f.b);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private b h(l paraml, g paramg, Class<?> paramClass) {
/* 1583 */     return a(paraml, paramg, paramClass, Boolean.valueOf(paraml.M()), f.c);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private b a(l paraml, g paramg, Class<?> paramClass, Object paramObject, f paramf) {
/*      */     b b;
/* 1595 */     if ((b = paramg.a(f.j, paramClass, paramf)) == b.a) {
/* 1596 */       return a(paramg, b, paramClass, paramObject, paramf
/* 1597 */           .name() + " value (" + paraml.w() + ")");
/*      */     }
/* 1599 */     return b;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final b e(l paraml, g paramg, Class<?> paramClass) {
/*      */     b b;
/* 1611 */     if ((b = paramg.a(f.g, paramClass, f.a)) == b.a) {
/* 1612 */       return a(paramg, b, paramClass, paraml.B(), "Integer value (" + paraml
/* 1613 */           .w() + ")");
/*      */     }
/* 1615 */     return b;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Boolean i(l paraml, g paramg, Class<?> paramClass) {
/* 1625 */     b b = paramg.a(f.h, paramClass, f.a);
/* 1626 */     switch (af.a[b.ordinal()]) {
/*      */       case 4:
/* 1628 */         a(paramg, b, paramClass, paraml.B(), "Integer value (" + paraml
/* 1629 */             .w() + ")");
/* 1630 */         return Boolean.FALSE;
/*      */       case 2:
/* 1632 */         return null;
/*      */       case 1:
/* 1634 */         return Boolean.FALSE;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1640 */     if (paraml.D() == l.b.a)
/*      */     {
/* 1642 */       return Boolean.valueOf((paraml.G() != 0));
/*      */     }
/* 1644 */     return Boolean.valueOf(!"0".equals(paraml.w()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final b a(g paramg, b paramb, Class<?> paramClass, Object paramObject, String paramString) {
/* 1655 */     if (paramb == b.a) {
/* 1656 */       paramg.a(paramClass, paramObject, "Cannot coerce %s to %s (but could if coercion was enabled using `CoercionConfig`)", new Object[] { paramString, 
/*      */             
/* 1658 */             k() });
/*      */     }
/* 1660 */     return paramb;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final boolean b(g paramg, String paramString) {
/* 1673 */     if (d(paramString)) {
/* 1674 */       if (!paramg.a(q.C)) {
/* 1675 */         a(paramg, true, (Enum<?>)q.C, "String \"null\"");
/*      */       }
/* 1677 */       return true;
/*      */     } 
/* 1679 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static Object u(l paraml, g paramg) {
/* 1701 */     if (paramg.a(i.b)) {
/* 1702 */       return paraml.I();
/*      */     }
/* 1704 */     if (paramg.a(i.c)) {
/* 1705 */       return Long.valueOf(paraml.H());
/*      */     }
/* 1707 */     return paraml.B();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final void f(g paramg) {
/* 1720 */     if (paramg.a(i.f)) {
/* 1721 */       paramg.a(this, "Cannot coerce `null` to %s (disable `DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES` to allow)", new Object[] {
/*      */             
/* 1723 */             k()
/*      */           });
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void g(g paramg, String paramString) {
/*      */     i i;
/*      */     boolean bool;
/* 1740 */     if (!paramg.a(q.C)) {
/* 1741 */       q q = q.C;
/* 1742 */       bool = true;
/* 1743 */     } else if (paramg.a(i.f)) {
/* 1744 */       i = i.f;
/* 1745 */       bool = false;
/*      */     } else {
/*      */       return;
/*      */     } 
/* 1749 */     paramString = paramString.isEmpty() ? "empty String (\"\")" : String.format("String \"%s\"", new Object[] { paramString });
/* 1750 */     a(paramg, bool, (Enum<?>)i, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(g paramg, boolean paramBoolean, Enum<?> paramEnum, String paramString) {
/* 1756 */     String str = paramBoolean ? "enable" : "disable";
/* 1757 */     paramg.a(this, "Cannot coerce %s to Null value as %s (%s `%s.%s` to allow)", new Object[] { paramString, 
/* 1758 */           k(), str, paramEnum.getDeclaringClass().getSimpleName(), paramEnum.name() });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final String k() {
/*      */     boolean bool;
/*      */     String str;
/*      */     j j1;
/* 1775 */     if ((j1 = h()) != null && !j1.l()) {
/* 1776 */       bool = (j1.n() || j1.F()) ? true : false;
/* 1777 */       str = i.b(j1);
/*      */     } else {
/*      */       Class<?> clazz;
/*      */       
/* 1781 */       bool = ((clazz = a()).isArray() || Collection.class.isAssignableFrom(clazz) || Map.class.isAssignableFrom(clazz)) ? true : false;
/* 1782 */       str = i.c(clazz);
/*      */     } 
/* 1784 */     if (bool) {
/* 1785 */       return "element of " + str;
/*      */     }
/* 1787 */     return str + " value";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static k<Object> a(g paramg, j paramj, c paramc) {
/* 1919 */     return paramg.a(paramj, paramc);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static boolean i(String paramString) {
/*      */     int i;
/* 1932 */     if ((i = paramString.length()) > 0) {
/*      */       char c;
/*      */ 
/*      */ 
/*      */       
/* 1937 */       if ((c = paramString.charAt(0)) == '-' || c == '+') {
/* 1938 */         if (i == 1) {
/* 1939 */           return false;
/*      */         }
/* 1941 */         c = '\001';
/*      */       } else {
/* 1943 */         c = Character.MIN_VALUE;
/*      */       } 
/*      */       
/* 1946 */       for (; c < i; c++) {
/*      */         char c1;
/* 1948 */         if ((c1 = paramString.charAt(c)) > '9' || c1 < '0') {
/* 1949 */           return false;
/*      */         }
/*      */       } 
/* 1952 */       return true;
/*      */     } 
/* 1954 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static k<?> a(g paramg, c paramc, k<?> paramk) {
/*      */     Object object;
/*      */     a a;
/*      */     j j1;
/* 1978 */     if (b(a = paramg.f(), paramc) && (
/*      */       
/* 1980 */       j1 = paramc.e()) != null && (
/*      */       
/* 1982 */       object = a.j(j1)) != null) {
/*      */       
/* 1984 */       paramg.b(); j j2 = (object = paramg.a((b)paramc.e(), object)).a();
/* 1985 */       if (paramk == null) {
/* 1986 */         paramk = paramg.a(j2, paramc);
/*      */       }
/* 1988 */       return new ad((k<Object, ?>)object, j2, paramk);
/*      */     } 
/*      */ 
/*      */     
/* 1992 */     return paramk;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static l.d a(g paramg, c paramc, Class<?> paramClass) {
/* 2013 */     if (paramc != null) {
/* 2014 */       return paramc.a((q)paramg.c(), paramClass);
/*      */     }
/*      */     
/* 2017 */     return paramg.a(paramClass);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final Boolean a(g paramg, c paramc, Class<?> paramClass, l.a parama) {
/*      */     l.d d;
/* 2034 */     if ((d = a(paramg, paramc, paramClass)) != null) {
/* 2035 */       return d.a(parama);
/*      */     }
/* 2037 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final s a(g paramg, v paramv, v paramv1) {
/* 2051 */     if (paramv != null) {
/* 2052 */       return a(paramg, (c)paramv, paramv1.e(), paramv
/* 2053 */           .p());
/*      */     }
/* 2055 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final s b(g paramg, c paramc, k<?> paramk) {
/*      */     j j1;
/*      */     ak ak;
/* 2071 */     if ((ak = b(paramg, paramc)) == ak.a) {
/* 2072 */       return (s)q.a();
/*      */     }
/*      */ 
/*      */     
/* 2076 */     if (ak == ak.b) {
/* 2077 */       if (paramc == null) {
/*      */ 
/*      */         
/* 2080 */         if ((j1 = paramg.b(paramk.a())).n()) {
/* 2081 */           j1 = j1.u();
/*      */         }
/* 2083 */         return (s)r.a(j1);
/*      */       } 
/* 2085 */       return (s)r.a(paramc, paramc.c().u());
/*      */     } 
/*      */     
/*      */     s s;
/* 2089 */     if ((s = a((g)j1, paramc, ak, paramk)) != null) {
/* 2090 */       return s;
/*      */     }
/* 2092 */     return (s)paramk;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected static ak b(g paramg, c paramc) {
/* 2098 */     if (paramc != null) {
/* 2099 */       return paramc.d().f();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 2104 */     return paramg.c().q().b();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static s a(g paramg, c paramc, ak paramak, k<?> paramk) {
/*      */     Class clazz;
/*      */     a a;
/* 2112 */     if (paramak == ak.b) {
/* 2113 */       if (paramc == null) {
/* 2114 */         clazz = (paramk == null) ? Object.class : paramk.a();
/* 2115 */         return (s)r.a(paramg.b(clazz));
/*      */       } 
/* 2117 */       return (s)r.a(paramc);
/*      */     } 
/* 2119 */     if (clazz == ak.c) {
/*      */ 
/*      */       
/* 2122 */       if (paramk == null) {
/* 2123 */         return null;
/*      */       }
/*      */       
/*      */       f f;
/*      */       
/*      */       x x;
/* 2129 */       if (paramk instanceof f && 
/*      */ 
/*      */         
/* 2132 */         !(x = (f = (f)paramk).i()).l()) {
/* 2133 */         j j1 = (paramc == null) ? f.h() : paramc.c();
/* 2134 */         return (s)paramg.a(j1, 
/* 2135 */             String.format("Cannot create empty instance of %s, no default Creator", new Object[] { j1 }));
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2141 */       if ((a = paramk.e()) == a.a) {
/* 2142 */         return (s)q.b();
/*      */       }
/* 2144 */       if (a == a.b) {
/* 2145 */         return (s)q.a(paramk.c(paramg));
/*      */       }
/*      */       
/* 2148 */       return (s)new p(paramk);
/*      */     } 
/* 2150 */     if (a == ak.a) {
/* 2151 */       return (s)q.a();
/*      */     }
/* 2153 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   protected final b g(g paramg) {
/* 2158 */     return paramg.a(b(), a(), f.f);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected final b h(g paramg) {
/* 2164 */     return paramg.a(b(), a(), f.e);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected final b i(g paramg) {
/* 2170 */     return paramg.a(b(), a(), b.a);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void b(l paraml, g paramg, Object<?> paramObject, String paramString) {
/* 2198 */     if (paramObject == null) {
/* 2199 */       paramObject = (Object<?>)a();
/*      */     }
/*      */     
/* 2202 */     paramg.a(paraml, this, paramObject, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final void j(g paramg) {
/* 2214 */     paramg.a(this, o.e, "Attempted to unwrap '%s' value from an array (with `DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS`) but it contains more than one value", new Object[] {
/*      */           
/* 2216 */           a().getName()
/*      */         });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Object f(l paraml, g paramg) {
/* 2229 */     String str = String.format("Cannot deserialize instance of %s out of %s token: nested Arrays not allowed with %s", new Object[] {
/*      */           
/* 2231 */           i.g(this.s), o.d, "DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS"
/*      */         });
/* 2233 */     return paramg.a(e(paramg), paraml.k(), paraml, str, new Object[0]);
/*      */   }
/*      */ 
/*      */   
/*      */   private void g(l paraml, g paramg) {
/*      */     o o;
/* 2239 */     if ((o = paraml.g()) != o.e) {
/* 2240 */       j(paramg);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static final boolean b(Object paramObject1, Object paramObject2) {
/* 2254 */     return (paramObject1 != null && paramObject2 != null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static boolean a(int paramInt) {
/* 2263 */     return (paramInt < -128 || paramInt > 255);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static boolean b(int paramInt) {
/* 2270 */     return (paramInt < -32768 || paramInt > 32767);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean a(long paramLong) {
/* 2277 */     return (paramLong < -2147483648L || paramLong > 2147483647L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Number a(Number paramNumber) {
/* 2284 */     if (paramNumber == null) {
/* 2285 */       paramNumber = Integer.valueOf(0);
/*      */     }
/* 2287 */     return paramNumber;
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\b\ae.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */