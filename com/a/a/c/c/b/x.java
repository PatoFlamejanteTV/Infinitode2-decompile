/*      */ package com.a.a.c.c.b;
/*      */ 
/*      */ import com.a.a.b.o;
/*      */ import com.a.a.b.t;
/*      */ import java.math.BigDecimal;
/*      */ import java.math.BigInteger;
/*      */ import java.util.HashSet;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class x
/*      */ {
/*   28 */   private static final HashSet<String> a = new HashSet<>();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/*      */     Class[] arrayOfClass;
/*      */     byte b;
/*   43 */     for (arrayOfClass = arrayOfClass = new Class[] { Boolean.class, Byte.class, Short.class, Character.class, Integer.class, Long.class, Float.class, Double.class, Number.class, BigDecimal.class, BigInteger.class }, b = 0; b < 11; ) { Class clazz = arrayOfClass[b];
/*   44 */       a.add(clazz.getName());
/*      */       b++; }
/*      */   
/*      */   }
/*      */   public static com.a.a.c.k<?> a(Class<?> paramClass, String paramString) {
/*   49 */     if (paramClass.isPrimitive()) {
/*   50 */       if (paramClass == int.class) {
/*   51 */         return h.a;
/*      */       }
/*   53 */       if (paramClass == boolean.class) {
/*   54 */         return c.a;
/*      */       }
/*   56 */       if (paramClass == long.class) {
/*   57 */         return i.a;
/*      */       }
/*   59 */       if (paramClass == double.class) {
/*   60 */         return f.a;
/*      */       }
/*   62 */       if (paramClass == char.class) {
/*   63 */         return e.a;
/*      */       }
/*   65 */       if (paramClass == byte.class) {
/*   66 */         return d.a;
/*      */       }
/*   68 */       if (paramClass == short.class) {
/*   69 */         return l.a;
/*      */       }
/*   71 */       if (paramClass == float.class) {
/*   72 */         return g.a;
/*      */       }
/*      */ 
/*      */       
/*   76 */       if (paramClass == void.class) {
/*   77 */         return w.a;
/*      */       }
/*   79 */     } else if (a.contains(paramString)) {
/*      */       
/*   81 */       if (paramClass == Integer.class) {
/*   82 */         return h.b;
/*      */       }
/*   84 */       if (paramClass == Boolean.class) {
/*   85 */         return c.b;
/*      */       }
/*   87 */       if (paramClass == Long.class) {
/*   88 */         return i.b;
/*      */       }
/*   90 */       if (paramClass == Double.class) {
/*   91 */         return f.b;
/*      */       }
/*   93 */       if (paramClass == Character.class) {
/*   94 */         return e.b;
/*      */       }
/*   96 */       if (paramClass == Byte.class) {
/*   97 */         return d.b;
/*      */       }
/*   99 */       if (paramClass == Short.class) {
/*  100 */         return l.b;
/*      */       }
/*  102 */       if (paramClass == Float.class) {
/*  103 */         return g.b;
/*      */       }
/*  105 */       if (paramClass == Number.class) {
/*  106 */         return j.a;
/*      */       }
/*  108 */       if (paramClass == BigDecimal.class) {
/*  109 */         return a.a;
/*      */       }
/*  111 */       if (paramClass == BigInteger.class) {
/*  112 */         return b.a;
/*      */       }
/*      */     } else {
/*  115 */       return null;
/*      */     } 
/*      */     
/*  118 */     throw new IllegalArgumentException("Internal error: can't find deserializer for " + paramClass.getName());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static abstract class k<T>
/*      */     extends ai<T>
/*      */   {
/*      */     private com.a.a.c.l.f a;
/*      */ 
/*      */ 
/*      */     
/*      */     private T b;
/*      */ 
/*      */ 
/*      */     
/*      */     private T d;
/*      */ 
/*      */ 
/*      */     
/*      */     protected final boolean c;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected k(Class<T> param1Class, com.a.a.c.l.f param1f, T param1T1, T param1T2) {
/*  146 */       super(param1Class);
/*  147 */       this.a = param1f;
/*  148 */       this.b = param1T1;
/*  149 */       this.d = param1T2;
/*  150 */       this.c = param1Class.isPrimitive();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final T a(com.a.a.c.g param1g) {
/*  175 */       if (this.c && param1g.a(com.a.a.c.i.f))
/*  176 */         param1g.a(this, "Cannot map `null` into type %s (set DeserializationConfig.DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES to 'false' to allow)", new Object[] {
/*      */               
/*  178 */               com.a.a.c.m.i.d(a())
/*      */             }); 
/*  180 */       return this.b;
/*      */     }
/*      */ 
/*      */     
/*      */     public Object c(com.a.a.c.g param1g) {
/*  185 */       return this.d;
/*      */     }
/*      */ 
/*      */     
/*      */     public final com.a.a.c.l.f b() {
/*  190 */       return this.a;
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
/*      */   @com.a.a.c.a.a
/*      */   public static final class c
/*      */     extends k<Boolean>
/*      */   {
/*  206 */     static final c a = new c((Class)boolean.class, Boolean.FALSE);
/*  207 */     static final c b = new c(Boolean.class, null);
/*      */ 
/*      */     
/*      */     private c(Class<Boolean> param1Class, Boolean param1Boolean) {
/*  211 */       super(param1Class, com.a.a.c.l.f.h, param1Boolean, Boolean.FALSE);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private Boolean c(com.a.a.b.l param1l, com.a.a.c.g param1g) {
/*      */       o o;
/*  218 */       if ((o = param1l.k()) == o.k) {
/*  219 */         return Boolean.TRUE;
/*      */       }
/*  221 */       if (o == o.l) {
/*  222 */         return Boolean.FALSE;
/*      */       }
/*  224 */       if (this.c) {
/*  225 */         return Boolean.valueOf(n(param1l, param1g));
/*      */       }
/*  227 */       return a(param1l, param1g, this.s);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private Boolean e(com.a.a.b.l param1l, com.a.a.c.g param1g) {
/*      */       o o;
/*  238 */       if ((o = param1l.k()) == o.k) {
/*  239 */         return Boolean.TRUE;
/*      */       }
/*  241 */       if (o == o.l) {
/*  242 */         return Boolean.FALSE;
/*      */       }
/*  244 */       if (this.c) {
/*  245 */         return Boolean.valueOf(n(param1l, param1g));
/*      */       }
/*  247 */       return a(param1l, param1g, this.s);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @com.a.a.c.a.a
/*      */   public static class d
/*      */     extends k<Byte>
/*      */   {
/*  257 */     static final d a = new d((Class)byte.class, Byte.valueOf((byte)0));
/*  258 */     static final d b = new d(Byte.class, null);
/*      */ 
/*      */     
/*      */     private d(Class<Byte> param1Class, Byte param1Byte) {
/*  262 */       super(param1Class, com.a.a.c.l.f.f, param1Byte, Byte.valueOf((byte)0));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private Byte c(com.a.a.b.l param1l, com.a.a.c.g param1g) {
/*  268 */       if (param1l.r()) {
/*  269 */         return Byte.valueOf(param1l.E());
/*      */       }
/*  271 */       if (this.c) {
/*  272 */         return Byte.valueOf(o(param1l, param1g));
/*      */       }
/*  274 */       return e(param1l, param1g);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private Byte e(com.a.a.b.l param1l, com.a.a.c.g param1g) {
/*      */       int i;
/*  282 */       switch (param1l.l()) {
/*      */         case 6:
/*  284 */           str = param1l.w();
/*      */           break;
/*      */         
/*      */         case 8:
/*  288 */           if ((b = d((com.a.a.b.l)str, param1g, this.s)) == com.a.a.c.b.b.c) {
/*  289 */             return a(param1g);
/*      */           }
/*  291 */           if (b == com.a.a.c.b.b.d) {
/*  292 */             return (Byte)c(param1g);
/*      */           }
/*  294 */           return Byte.valueOf(str.E());
/*      */         case 11:
/*  296 */           return a(param1g);
/*      */         case 7:
/*  298 */           return Byte.valueOf(str.E());
/*      */         case 3:
/*  300 */           return d((com.a.a.b.l)str, param1g);
/*      */         
/*      */         case 1:
/*  303 */           str = param1g.a((com.a.a.b.l)str, this.s);
/*      */           break;
/*      */         default:
/*  306 */           return (Byte)param1g.a(e(param1g), (com.a.a.b.l)str);
/*      */       } 
/*      */ 
/*      */       
/*      */       com.a.a.c.b.b b;
/*  311 */       if ((b = a(param1g, str)) == com.a.a.c.b.b.c) {
/*  312 */         return a(param1g);
/*      */       }
/*  314 */       if (b == com.a.a.c.b.b.d) {
/*  315 */         return (Byte)c(param1g);
/*      */       }
/*  317 */       String str = str.trim();
/*  318 */       if (b(param1g, str)) {
/*  319 */         return a(param1g);
/*      */       }
/*      */       
/*      */       try {
/*  323 */         i = com.a.a.b.c.h.a(str);
/*  324 */       } catch (IllegalArgumentException illegalArgumentException) {
/*  325 */         return (Byte)param1g.b(this.s, str, "not a valid Byte value", new Object[0]);
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*  330 */       if (a(i)) {
/*  331 */         return (Byte)param1g.b(this.s, str, "overflow, value cannot be represented as 8-bit value", new Object[0]);
/*      */       }
/*      */ 
/*      */       
/*  335 */       return Byte.valueOf((byte)i);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @com.a.a.c.a.a
/*      */   public static class l
/*      */     extends k<Short>
/*      */   {
/*  345 */     static final l a = new l((Class)short.class, Short.valueOf((short)0));
/*  346 */     static final l b = new l(Short.class, null);
/*      */ 
/*      */     
/*      */     private l(Class<Short> param1Class, Short param1Short) {
/*  350 */       super(param1Class, com.a.a.c.l.f.f, param1Short, Short.valueOf((short)0));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private Short c(com.a.a.b.l param1l, com.a.a.c.g param1g) {
/*  357 */       if (param1l.r()) {
/*  358 */         return Short.valueOf(param1l.F());
/*      */       }
/*  360 */       if (this.c) {
/*  361 */         return Short.valueOf(p(param1l, param1g));
/*      */       }
/*  363 */       return e(param1l, param1g);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private Short e(com.a.a.b.l param1l, com.a.a.c.g param1g) {
/*      */       int i;
/*  370 */       switch (param1l.l()) {
/*      */         case 6:
/*  372 */           str = param1l.w();
/*      */           break;
/*      */         
/*      */         case 8:
/*  376 */           if ((b = d((com.a.a.b.l)str, param1g, this.s)) == com.a.a.c.b.b.c) {
/*  377 */             return a(param1g);
/*      */           }
/*  379 */           if (b == com.a.a.c.b.b.d) {
/*  380 */             return (Short)c(param1g);
/*      */           }
/*  382 */           return Short.valueOf(str.F());
/*      */         case 11:
/*  384 */           return a(param1g);
/*      */         case 7:
/*  386 */           return Short.valueOf(str.F());
/*      */         
/*      */         case 1:
/*  389 */           str = param1g.a((com.a.a.b.l)str, this.s);
/*      */           break;
/*      */         case 3:
/*  392 */           return d((com.a.a.b.l)str, param1g);
/*      */         default:
/*  394 */           return (Short)param1g.a(e(param1g), (com.a.a.b.l)str);
/*      */       } 
/*      */ 
/*      */       
/*      */       com.a.a.c.b.b b;
/*  399 */       if ((b = a(param1g, str)) == com.a.a.c.b.b.c) {
/*  400 */         return a(param1g);
/*      */       }
/*  402 */       if (b == com.a.a.c.b.b.d) {
/*  403 */         return (Short)c(param1g);
/*      */       }
/*  405 */       String str = str.trim();
/*  406 */       if (b(param1g, str)) {
/*  407 */         return a(param1g);
/*      */       }
/*      */       
/*      */       try {
/*  411 */         i = com.a.a.b.c.h.a(str);
/*  412 */       } catch (IllegalArgumentException illegalArgumentException) {
/*  413 */         return (Short)param1g.b(this.s, str, "not a valid Short value", new Object[0]);
/*      */       } 
/*      */ 
/*      */       
/*  417 */       if (b(i)) {
/*  418 */         return (Short)param1g.b(this.s, str, "overflow, value cannot be represented as 16-bit value", new Object[0]);
/*      */       }
/*      */       
/*  421 */       return Short.valueOf((short)i);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @com.a.a.c.a.a
/*      */   public static class e
/*      */     extends k<Character>
/*      */   {
/*  431 */     static final e a = new e((Class)char.class, Character.valueOf(false));
/*  432 */     static final e b = new e(Character.class, null);
/*      */ 
/*      */     
/*      */     private e(Class<Character> param1Class, Character param1Character) {
/*  436 */       super(param1Class, com.a.a.c.l.f.f, param1Character, 
/*      */           
/*  438 */           Character.valueOf(false));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private Character c(com.a.a.b.l param1l, com.a.a.c.g param1g) {
/*      */       String str2;
/*      */       int i;
/*  446 */       switch (param1l.l()) {
/*      */ 
/*      */ 
/*      */         
/*      */         case 6:
/*  451 */           str2 = param1l.w();
/*      */           break;
/*      */         case 7:
/*  454 */           b = param1g.a(b(), this.s, com.a.a.c.b.f.a);
/*  455 */           switch (y.a[b.ordinal()]) {
/*      */             case 1:
/*  457 */               a(param1g, b, this.s, str2.B(), "Integer value (" + str2
/*  458 */                   .w() + ")");
/*      */             
/*      */             case 2:
/*  461 */               return a(param1g);
/*      */             case 3:
/*  463 */               return (Character)c(param1g);
/*      */           } 
/*      */ 
/*      */           
/*  467 */           if ((i = str2.G()) >= 0 && i <= 65535) {
/*  468 */             return Character.valueOf((char)i);
/*      */           }
/*  470 */           return (Character)param1g.a(a(), Integer.valueOf(i), "value outside valid Character range (0x0000 - 0xFFFF)", new Object[0]);
/*      */         
/*      */         case 11:
/*  473 */           if (this.c) {
/*  474 */             f(param1g);
/*      */           }
/*  476 */           return a(param1g);
/*      */         
/*      */         case 1:
/*  479 */           str1 = param1g.a(i, this.s);
/*      */           break;
/*      */         case 3:
/*  482 */           return d((com.a.a.b.l)str1, param1g);
/*      */         default:
/*  484 */           return (Character)param1g.a(e(param1g), (com.a.a.b.l)str1);
/*      */       } 
/*      */       
/*  487 */       if (str1.length() == 1) {
/*  488 */         return Character.valueOf(str1.charAt(0));
/*      */       }
/*      */       com.a.a.c.b.b b;
/*  491 */       if ((b = a(param1g, str1)) == com.a.a.c.b.b.c) {
/*  492 */         return a(param1g);
/*      */       }
/*  494 */       if (b == com.a.a.c.b.b.d) {
/*  495 */         return (Character)c(param1g);
/*      */       }
/*  497 */       String str1 = str1.trim();
/*  498 */       if (b(param1g, str1)) {
/*  499 */         return a(param1g);
/*      */       }
/*  501 */       return (Character)param1g.b(a(), str1, "Expected either Integer value code or 1-character String", new Object[0]);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @com.a.a.c.a.a
/*      */   public static final class h
/*      */     extends k<Integer>
/*      */   {
/*  512 */     static final h a = new h((Class)int.class, Integer.valueOf(0));
/*  513 */     static final h b = new h(Integer.class, null);
/*      */     
/*      */     private h(Class<Integer> param1Class, Integer param1Integer) {
/*  516 */       super(param1Class, com.a.a.c.l.f.f, param1Integer, Integer.valueOf(0));
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean c() {
/*  521 */       return true;
/*      */     }
/*      */     
/*      */     private Integer c(com.a.a.b.l param1l, com.a.a.c.g param1g) {
/*  525 */       if (param1l.r()) {
/*  526 */         return Integer.valueOf(param1l.G());
/*      */       }
/*  528 */       if (this.c) {
/*  529 */         return Integer.valueOf(q(param1l, param1g));
/*      */       }
/*  531 */       return b(param1l, param1g, Integer.class);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private Integer e(com.a.a.b.l param1l, com.a.a.c.g param1g) {
/*  540 */       if (param1l.r()) {
/*  541 */         return Integer.valueOf(param1l.G());
/*      */       }
/*  543 */       if (this.c) {
/*  544 */         return Integer.valueOf(q(param1l, param1g));
/*      */       }
/*  546 */       return b(param1l, param1g, Integer.class);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @com.a.a.c.a.a
/*      */   public static final class i
/*      */     extends k<Long>
/*      */   {
/*  556 */     static final i a = new i((Class)long.class, Long.valueOf(0L));
/*  557 */     static final i b = new i(Long.class, null);
/*      */     
/*      */     private i(Class<Long> param1Class, Long param1Long) {
/*  560 */       super(param1Class, com.a.a.c.l.f.f, param1Long, Long.valueOf(0L));
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean c() {
/*  565 */       return true;
/*      */     }
/*      */     
/*      */     private Long c(com.a.a.b.l param1l, com.a.a.c.g param1g) {
/*  569 */       if (param1l.r()) {
/*  570 */         return Long.valueOf(param1l.H());
/*      */       }
/*  572 */       if (this.c) {
/*  573 */         return Long.valueOf(r(param1l, param1g));
/*      */       }
/*  575 */       return c(param1l, param1g, Long.class);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @com.a.a.c.a.a
/*      */   public static class g
/*      */     extends k<Float>
/*      */   {
/*  585 */     static final g a = new g((Class)float.class, Float.valueOf(0.0F));
/*  586 */     static final g b = new g(Float.class, null);
/*      */     
/*      */     private g(Class<Float> param1Class, Float param1Float) {
/*  589 */       super(param1Class, com.a.a.c.l.f.g, param1Float, Float.valueOf(0.0F));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private Float c(com.a.a.b.l param1l, com.a.a.c.g param1g) {
/*  595 */       if (param1l.a(o.j)) {
/*  596 */         return Float.valueOf(param1l.J());
/*      */       }
/*  598 */       if (this.c) {
/*  599 */         return Float.valueOf(s(param1l, param1g));
/*      */       }
/*  601 */       return e(param1l, param1g);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private Float e(com.a.a.b.l param1l, com.a.a.c.g param1g) {
/*      */       com.a.a.c.b.b b2;
/*  608 */       switch (param1l.l()) {
/*      */         case 6:
/*  610 */           str = param1l.w();
/*      */           break;
/*      */         case 11:
/*  613 */           return a(param1g);
/*      */         
/*      */         case 7:
/*  616 */           if ((b2 = e(param1l, param1g, this.s)) == com.a.a.c.b.b.c) {
/*  617 */             return a(param1g);
/*      */           }
/*  619 */           if (b2 == com.a.a.c.b.b.d) {
/*  620 */             return (Float)c(param1g);
/*      */           }
/*      */         
/*      */         case 8:
/*  624 */           return Float.valueOf(param1l.J());
/*      */         
/*      */         case 1:
/*  627 */           str = param1g.a(param1l, this.s);
/*      */           break;
/*      */         case 3:
/*  630 */           return d(param1l, param1g);
/*      */         default:
/*  632 */           return (Float)param1g.a(e(param1g), param1l);
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       Float float_;
/*  640 */       if ((float_ = b(str)) != null) {
/*  641 */         return float_;
/*      */       }
/*      */       
/*      */       com.a.a.c.b.b b1;
/*  645 */       if ((b1 = a(param1g, str)) == com.a.a.c.b.b.c) {
/*  646 */         return a(param1g);
/*      */       }
/*  648 */       if (b1 == com.a.a.c.b.b.d) {
/*  649 */         return (Float)c(param1g);
/*      */       }
/*  651 */       String str = str.trim();
/*  652 */       if (b(param1g, str)) {
/*  653 */         return a(param1g);
/*      */       }
/*      */       try {
/*  656 */         return Float.valueOf(com.a.a.b.c.h.c(str, param1l.a(t.a)));
/*  657 */       } catch (IllegalArgumentException illegalArgumentException) {
/*  658 */         return (Float)param1g.b(this.s, str, "not a valid `Float` value", new Object[0]);
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @com.a.a.c.a.a
/*      */   public static class f
/*      */     extends k<Double>
/*      */   {
/*  669 */     static final f a = new f((Class)double.class, Double.valueOf(0.0D));
/*  670 */     static final f b = new f(Double.class, null);
/*      */     
/*      */     private f(Class<Double> param1Class, Double param1Double) {
/*  673 */       super(param1Class, com.a.a.c.l.f.g, param1Double, Double.valueOf(0.0D));
/*      */     }
/*      */ 
/*      */     
/*      */     private Double c(com.a.a.b.l param1l, com.a.a.c.g param1g) {
/*  678 */       if (param1l.a(o.j)) {
/*  679 */         return Double.valueOf(param1l.K());
/*      */       }
/*  681 */       if (this.c) {
/*  682 */         return Double.valueOf(t(param1l, param1g));
/*      */       }
/*  684 */       return f(param1l, param1g);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private Double e(com.a.a.b.l param1l, com.a.a.c.g param1g) {
/*  693 */       if (param1l.a(o.j)) {
/*  694 */         return Double.valueOf(param1l.K());
/*      */       }
/*  696 */       if (this.c) {
/*  697 */         return Double.valueOf(t(param1l, param1g));
/*      */       }
/*  699 */       return f(param1l, param1g);
/*      */     }
/*      */ 
/*      */     
/*      */     private Double f(com.a.a.b.l param1l, com.a.a.c.g param1g) {
/*      */       com.a.a.c.b.b b2;
/*  705 */       switch (param1l.l()) {
/*      */         case 6:
/*  707 */           str = param1l.w();
/*      */           break;
/*      */         case 11:
/*  710 */           return a(param1g);
/*      */         
/*      */         case 7:
/*  713 */           if ((b2 = e(param1l, param1g, this.s)) == com.a.a.c.b.b.c) {
/*  714 */             return a(param1g);
/*      */           }
/*  716 */           if (b2 == com.a.a.c.b.b.d) {
/*  717 */             return (Double)c(param1g);
/*      */           }
/*      */         
/*      */         case 8:
/*  721 */           return Double.valueOf(param1l.K());
/*      */         
/*      */         case 1:
/*  724 */           str = param1g.a(param1l, this.s);
/*      */           break;
/*      */         case 3:
/*  727 */           return d(param1l, param1g);
/*      */         default:
/*  729 */           return (Double)param1g.a(e(param1g), param1l);
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       Double double_;
/*  737 */       if ((double_ = c(str)) != null) {
/*  738 */         return double_;
/*      */       }
/*      */ 
/*      */       
/*      */       com.a.a.c.b.b b1;
/*      */       
/*  744 */       if ((b1 = a(param1g, str)) == com.a.a.c.b.b.c) {
/*  745 */         return a(param1g);
/*      */       }
/*  747 */       if (b1 == com.a.a.c.b.b.d) {
/*  748 */         return (Double)c(param1g);
/*      */       }
/*  750 */       String str = str.trim();
/*  751 */       if (b(param1g, str)) {
/*  752 */         return a(param1g);
/*      */       }
/*      */       try {
/*  755 */         return Double.valueOf(a(str, param1l.a(t.a)));
/*  756 */       } catch (IllegalArgumentException illegalArgumentException) {
/*  757 */         return (Double)param1g.b(this.s, str, "not a valid `Double` value", new Object[0]);
/*      */       } 
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
/*      */   @com.a.a.c.a.a
/*      */   public static class j
/*      */     extends ai<Object>
/*      */   {
/*  777 */     public static final j a = new j();
/*      */     
/*      */     public j() {
/*  780 */       super(Number.class);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final com.a.a.c.l.f b() {
/*  786 */       return com.a.a.c.l.f.f;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final Object a(com.a.a.b.l param1l, com.a.a.c.g param1g) {
/*  793 */       switch (param1l.l()) {
/*      */         case 6:
/*  795 */           str = param1l.w();
/*      */           break;
/*      */         case 7:
/*  798 */           if (param1g.a(r)) {
/*  799 */             return u(param1l, param1g);
/*      */           }
/*  801 */           return param1l.B();
/*      */         
/*      */         case 8:
/*  804 */           if (param1g.a(com.a.a.c.i.a))
/*      */           {
/*  806 */             if (!param1l.s()) {
/*  807 */               return param1l.L();
/*      */             }
/*      */           }
/*  810 */           return param1l.B();
/*      */         
/*      */         case 1:
/*  813 */           str = param1g.a(param1l, this.s);
/*      */           break;
/*      */         case 3:
/*  816 */           return d(param1l, param1g);
/*      */         default:
/*  818 */           return param1g.a(e(param1g), param1l);
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*      */       com.a.a.c.b.b b;
/*  824 */       if ((b = a(param1g, str)) == com.a.a.c.b.b.c) {
/*  825 */         return a(param1g);
/*      */       }
/*  827 */       if (b == com.a.a.c.b.b.d) {
/*  828 */         return c(param1g);
/*      */       }
/*      */       String str;
/*  831 */       if (d(str = str.trim()))
/*      */       {
/*  833 */         return a(param1g);
/*      */       }
/*  835 */       if (f(str)) {
/*  836 */         return Double.valueOf(Double.POSITIVE_INFINITY);
/*      */       }
/*  838 */       if (e(str)) {
/*  839 */         return Double.valueOf(Double.NEGATIVE_INFINITY);
/*      */       }
/*  841 */       if (g(str)) {
/*  842 */         return Double.valueOf(Double.NaN);
/*      */       }
/*      */       try {
/*  845 */         if (!i(str)) {
/*  846 */           if (param1g.a(com.a.a.c.i.a)) {
/*  847 */             return com.a.a.b.c.h.d(str);
/*      */           }
/*  849 */           return Double.valueOf(
/*  850 */               com.a.a.b.c.h.b(str, param1l.a(t.a)));
/*      */         } 
/*  852 */         if (param1g.a(com.a.a.c.i.b)) {
/*  853 */           return com.a.a.b.c.h.e(str);
/*      */         }
/*  855 */         long l1 = com.a.a.b.c.h.b(str);
/*  856 */         if (!param1g.a(com.a.a.c.i.c) && 
/*  857 */           l1 <= 2147483647L && l1 >= -2147483648L) {
/*  858 */           return Integer.valueOf((int)l1);
/*      */         }
/*      */         
/*  861 */         return Long.valueOf(l1);
/*  862 */       } catch (IllegalArgumentException illegalArgumentException) {
/*  863 */         return param1g.b(this.s, str, "not a valid number", new Object[0]);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final Object a(com.a.a.b.l param1l, com.a.a.c.g param1g, com.a.a.c.i.e param1e) {
/*  879 */       switch (param1l.l()) {
/*      */         
/*      */         case 6:
/*      */         case 7:
/*      */         case 8:
/*  884 */           return a(param1l, param1g);
/*      */       } 
/*  886 */       return param1e.c(param1l, param1g);
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
/*      */   @com.a.a.c.a.a
/*      */   public static class b
/*      */     extends ai<BigInteger>
/*      */   {
/*  905 */     public static final b a = new b();
/*      */     public b() {
/*  907 */       super(BigInteger.class);
/*      */     }
/*      */     
/*      */     public final Object c(com.a.a.c.g param1g) {
/*  911 */       return BigInteger.ZERO;
/*      */     }
/*      */ 
/*      */     
/*      */     public final com.a.a.c.l.f b() {
/*  916 */       return com.a.a.c.l.f.f;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private BigInteger c(com.a.a.b.l param1l, com.a.a.c.g param1g) {
/*  922 */       if (param1l.r()) {
/*  923 */         return param1l.I();
/*      */       }
/*      */ 
/*      */       
/*  927 */       switch (param1l.l()) {
/*      */         case 6:
/*  929 */           str = param1l.w();
/*      */           break;
/*      */         
/*      */         case 8:
/*  933 */           if ((b1 = d((com.a.a.b.l)str, param1g, this.s)) == com.a.a.c.b.b.c) {
/*  934 */             return (BigInteger)a(param1g);
/*      */           }
/*  936 */           if (b1 == com.a.a.c.b.b.d) {
/*  937 */             return (BigInteger)c(param1g);
/*      */           }
/*  939 */           return str.L().toBigInteger();
/*      */         
/*      */         case 1:
/*  942 */           str = param1g.a((com.a.a.b.l)str, this.s);
/*      */           break;
/*      */         case 3:
/*  945 */           return d((com.a.a.b.l)str, param1g);
/*      */         
/*      */         default:
/*  948 */           return (BigInteger)param1g.a(e(param1g), (com.a.a.b.l)str);
/*      */       } 
/*      */       
/*      */       com.a.a.c.b.b b1;
/*  952 */       if ((b1 = a(param1g, str)) == com.a.a.c.b.b.c) {
/*  953 */         return (BigInteger)a(param1g);
/*      */       }
/*  955 */       if (b1 == com.a.a.c.b.b.d) {
/*  956 */         return (BigInteger)c(param1g);
/*      */       }
/*      */       String str;
/*  959 */       if (d(str = str.trim()))
/*      */       {
/*  961 */         return (BigInteger)a(param1g);
/*      */       }
/*      */       try {
/*  964 */         return com.a.a.b.c.h.e(str);
/*  965 */       } catch (IllegalArgumentException illegalArgumentException) {
/*  966 */         return (BigInteger)param1g.b(this.s, str, "not a valid representation", new Object[0]);
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   @com.a.a.c.a.a
/*      */   public static class a
/*      */     extends ai<BigDecimal>
/*      */   {
/*  976 */     public static final a a = new a();
/*      */     public a() {
/*  978 */       super(BigDecimal.class);
/*      */     }
/*      */     
/*      */     public final Object c(com.a.a.c.g param1g) {
/*  982 */       return BigDecimal.ZERO;
/*      */     }
/*      */ 
/*      */     
/*      */     public final com.a.a.c.l.f b() {
/*  987 */       return com.a.a.c.l.f.g;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private BigDecimal c(com.a.a.b.l param1l, com.a.a.c.g param1g) {
/*  995 */       switch (param1l.l()) {
/*      */         
/*      */         case 7:
/*  998 */           if ((b = e(param1l, param1g, this.s)) == com.a.a.c.b.b.c) {
/*  999 */             return (BigDecimal)a(param1g);
/*      */           }
/* 1001 */           if (b == com.a.a.c.b.b.d) {
/* 1002 */             return (BigDecimal)c(param1g);
/*      */           }
/*      */         
/*      */         case 8:
/* 1006 */           return param1l.L();
/*      */         case 6:
/* 1008 */           str = param1l.w();
/*      */           break;
/*      */         
/*      */         case 1:
/* 1012 */           str = param1g.a((com.a.a.b.l)str, this.s);
/*      */           break;
/*      */         case 3:
/* 1015 */           return d((com.a.a.b.l)str, param1g);
/*      */         default:
/* 1017 */           return (BigDecimal)param1g.a(e(param1g), (com.a.a.b.l)str);
/*      */       } 
/*      */       
/*      */       com.a.a.c.b.b b;
/* 1021 */       if ((b = a(param1g, str)) == com.a.a.c.b.b.c) {
/* 1022 */         return (BigDecimal)a(param1g);
/*      */       }
/* 1024 */       if (b == com.a.a.c.b.b.d) {
/* 1025 */         return (BigDecimal)c(param1g);
/*      */       }
/*      */       String str;
/* 1028 */       if (d(str = str.trim()))
/*      */       {
/* 1030 */         return (BigDecimal)a(param1g);
/*      */       }
/*      */       try {
/* 1033 */         return com.a.a.b.c.h.d(str);
/* 1034 */       } catch (IllegalArgumentException illegalArgumentException) {
/* 1035 */         return (BigDecimal)param1g.b(this.s, str, "not a valid representation", new Object[0]);
/*      */       } 
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\b\x.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */