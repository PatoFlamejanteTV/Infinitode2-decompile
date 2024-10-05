/*      */ package com.a.a.c.l;
/*      */ 
/*      */ import com.a.a.c.j;
/*      */ import com.a.a.c.k.a.d;
/*      */ import com.a.a.c.m;
/*      */ import com.a.a.c.m.i;
/*      */ import com.a.a.c.m.q;
/*      */ import java.io.Serializable;
/*      */ import java.lang.reflect.GenericArrayType;
/*      */ import java.lang.reflect.ParameterizedType;
/*      */ import java.lang.reflect.Type;
/*      */ import java.lang.reflect.TypeVariable;
/*      */ import java.lang.reflect.WildcardType;
/*      */ import java.util.Collection;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Properties;
/*      */ import java.util.concurrent.atomic.AtomicReference;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class o
/*      */   implements Serializable
/*      */ {
/*   68 */   private static final j[] a = new j[0];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   75 */   private static o b = new o();
/*      */   
/*   77 */   private static n c = n.a();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   89 */   private static final Class<?> d = String.class;
/*   90 */   private static final Class<?> e = Object.class;
/*      */   
/*   92 */   private static final Class<?> f = Comparable.class;
/*   93 */   private static final Class<?> g = Enum.class;
/*   94 */   private static final Class<?> h = m.class;
/*      */   
/*   96 */   private static final Class<?> i = boolean.class;
/*   97 */   private static final Class<?> j = int.class;
/*   98 */   private static final Class<?> k = long.class;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  107 */   private static l l = new l(i);
/*  108 */   private static l m = new l(j);
/*  109 */   private static l n = new l(k);
/*      */ 
/*      */   
/*  112 */   private static l o = new l(d);
/*      */ 
/*      */   
/*  115 */   private static l p = new l(e);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  123 */   private static l q = new l(f);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  131 */   private static l r = new l(g);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  139 */   private static l s = new l(h);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private q<Object, j> t;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private d[] u;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private p v;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private ClassLoader w;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private o() {
/*  174 */     this((q<Object, j>)null);
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
/*      */   private o(q<Object, j> paramq) {
/*      */     com.a.a.c.m.o o1;
/*  190 */     if (paramq == null) {
/*  191 */       o1 = new com.a.a.c.m.o(16, 200);
/*      */     }
/*  193 */     this.t = (q<Object, j>)o1;
/*  194 */     this.v = new p(this);
/*  195 */     this.u = null;
/*  196 */     this.w = null;
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
/*      */   public static o a() {
/*  288 */     return b;
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
/*      */   private ClassLoader c() {
/*  305 */     return this.w;
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
/*      */   public static j b() {
/*  320 */     return d();
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
/*      */   public final Class<?> a(String paramString) {
/*      */     Throwable throwable;
/*      */     Class<?> clazz;
/*  351 */     if (paramString.indexOf('.') < 0 && (
/*      */       
/*  353 */       clazz = d(paramString)) != null) {
/*  354 */       return clazz;
/*      */     }
/*      */ 
/*      */     
/*  358 */     clazz = null;
/*      */     ClassLoader classLoader;
/*  360 */     if ((classLoader = c()) == null) {
/*  361 */       classLoader = Thread.currentThread().getContextClassLoader();
/*      */     }
/*  363 */     if (classLoader != null) {
/*      */       try {
/*  365 */         return a(paramString, classLoader);
/*  366 */       } catch (Exception exception) {
/*  367 */         throwable = i.d((Throwable)(classLoader = null));
/*      */       } 
/*      */     }
/*      */     try {
/*  371 */       return c(paramString);
/*  372 */     } catch (Exception exception) {
/*  373 */       if (throwable == null) {
/*  374 */         throwable = i.d(exception);
/*      */       }
/*      */       
/*  377 */       i.b(throwable);
/*  378 */       throw new ClassNotFoundException(throwable.getMessage(), throwable);
/*      */     } 
/*      */   }
/*      */   
/*      */   private static Class<?> a(String paramString, ClassLoader paramClassLoader) {
/*  383 */     return Class.forName(paramString, true, paramClassLoader);
/*      */   }
/*      */   
/*      */   private static Class<?> c(String paramString) {
/*  387 */     return Class.forName(paramString);
/*      */   }
/*      */ 
/*      */   
/*      */   private static Class<?> d(String paramString) {
/*  392 */     if ("int".equals(paramString)) return int.class; 
/*  393 */     if ("long".equals(paramString)) return long.class; 
/*  394 */     if ("float".equals(paramString)) return float.class; 
/*  395 */     if ("double".equals(paramString)) return double.class; 
/*  396 */     if ("boolean".equals(paramString)) return boolean.class; 
/*  397 */     if ("byte".equals(paramString)) return byte.class; 
/*  398 */     if ("char".equals(paramString)) return char.class; 
/*  399 */     if ("short".equals(paramString)) return short.class; 
/*  400 */     if ("void".equals(paramString)) return void.class; 
/*  401 */     return null;
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
/*      */   public final j a(j paramj, Class<?> paramClass) {
/*  426 */     return a(paramj, paramClass, false);
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
/*      */   public final j a(j paramj, Class<?> paramClass, boolean paramBoolean) {
/*      */     // Byte code:
/*      */     //   0: aload_1
/*      */     //   1: invokevirtual b : ()Ljava/lang/Class;
/*      */     //   4: dup
/*      */     //   5: astore #4
/*      */     //   7: aload_2
/*      */     //   8: if_acmpne -> 13
/*      */     //   11: aload_1
/*      */     //   12: areturn
/*      */     //   13: aload #4
/*      */     //   15: ldc java/lang/Object
/*      */     //   17: if_acmpne -> 33
/*      */     //   20: aload_0
/*      */     //   21: aconst_null
/*      */     //   22: aload_2
/*      */     //   23: getstatic com/a/a/c/l/o.c : Lcom/a/a/c/l/n;
/*      */     //   26: invokevirtual a : (Lcom/a/a/c/l/c;Ljava/lang/Class;Lcom/a/a/c/l/n;)Lcom/a/a/c/j;
/*      */     //   29: astore_2
/*      */     //   30: goto -> 256
/*      */     //   33: aload #4
/*      */     //   35: aload_2
/*      */     //   36: invokevirtual isAssignableFrom : (Ljava/lang/Class;)Z
/*      */     //   39: ifne -> 73
/*      */     //   42: new java/lang/IllegalArgumentException
/*      */     //   45: dup
/*      */     //   46: ldc 'Class %s not subtype of %s'
/*      */     //   48: iconst_2
/*      */     //   49: anewarray java/lang/Object
/*      */     //   52: dup
/*      */     //   53: iconst_0
/*      */     //   54: aload_2
/*      */     //   55: invokestatic g : (Ljava/lang/Class;)Ljava/lang/String;
/*      */     //   58: aastore
/*      */     //   59: dup
/*      */     //   60: iconst_1
/*      */     //   61: aload_1
/*      */     //   62: invokestatic b : (Lcom/a/a/c/j;)Ljava/lang/String;
/*      */     //   65: aastore
/*      */     //   66: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
/*      */     //   69: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   72: athrow
/*      */     //   73: aload_1
/*      */     //   74: invokevirtual n : ()Z
/*      */     //   77: ifeq -> 191
/*      */     //   80: aload_1
/*      */     //   81: invokevirtual p : ()Z
/*      */     //   84: ifeq -> 133
/*      */     //   87: aload_2
/*      */     //   88: ldc java/util/HashMap
/*      */     //   90: if_acmpeq -> 111
/*      */     //   93: aload_2
/*      */     //   94: ldc java/util/LinkedHashMap
/*      */     //   96: if_acmpeq -> 111
/*      */     //   99: aload_2
/*      */     //   100: ldc java/util/EnumMap
/*      */     //   102: if_acmpeq -> 111
/*      */     //   105: aload_2
/*      */     //   106: ldc java/util/TreeMap
/*      */     //   108: if_acmpne -> 191
/*      */     //   111: aload_0
/*      */     //   112: aconst_null
/*      */     //   113: aload_2
/*      */     //   114: dup
/*      */     //   115: aload_1
/*      */     //   116: invokevirtual t : ()Lcom/a/a/c/j;
/*      */     //   119: aload_1
/*      */     //   120: invokevirtual u : ()Lcom/a/a/c/j;
/*      */     //   123: invokestatic a : (Ljava/lang/Class;Lcom/a/a/c/j;Lcom/a/a/c/j;)Lcom/a/a/c/l/n;
/*      */     //   126: invokevirtual a : (Lcom/a/a/c/l/c;Ljava/lang/Class;Lcom/a/a/c/l/n;)Lcom/a/a/c/j;
/*      */     //   129: astore_2
/*      */     //   130: goto -> 256
/*      */     //   133: aload_1
/*      */     //   134: invokevirtual o : ()Z
/*      */     //   137: ifeq -> 191
/*      */     //   140: aload_2
/*      */     //   141: ldc java/util/ArrayList
/*      */     //   143: if_acmpeq -> 164
/*      */     //   146: aload_2
/*      */     //   147: ldc java/util/LinkedList
/*      */     //   149: if_acmpeq -> 164
/*      */     //   152: aload_2
/*      */     //   153: ldc java/util/HashSet
/*      */     //   155: if_acmpeq -> 164
/*      */     //   158: aload_2
/*      */     //   159: ldc java/util/TreeSet
/*      */     //   161: if_acmpne -> 182
/*      */     //   164: aload_0
/*      */     //   165: aconst_null
/*      */     //   166: aload_2
/*      */     //   167: dup
/*      */     //   168: aload_1
/*      */     //   169: invokevirtual u : ()Lcom/a/a/c/j;
/*      */     //   172: invokestatic a : (Ljava/lang/Class;Lcom/a/a/c/j;)Lcom/a/a/c/l/n;
/*      */     //   175: invokevirtual a : (Lcom/a/a/c/l/c;Ljava/lang/Class;Lcom/a/a/c/l/n;)Lcom/a/a/c/j;
/*      */     //   178: astore_2
/*      */     //   179: goto -> 256
/*      */     //   182: aload #4
/*      */     //   184: ldc java/util/EnumSet
/*      */     //   186: if_acmpne -> 191
/*      */     //   189: aload_1
/*      */     //   190: areturn
/*      */     //   191: aload_1
/*      */     //   192: invokevirtual x : ()Lcom/a/a/c/l/n;
/*      */     //   195: invokevirtual b : ()Z
/*      */     //   198: ifeq -> 214
/*      */     //   201: aload_0
/*      */     //   202: aconst_null
/*      */     //   203: aload_2
/*      */     //   204: getstatic com/a/a/c/l/o.c : Lcom/a/a/c/l/n;
/*      */     //   207: invokevirtual a : (Lcom/a/a/c/l/c;Ljava/lang/Class;Lcom/a/a/c/l/n;)Lcom/a/a/c/j;
/*      */     //   210: astore_2
/*      */     //   211: goto -> 256
/*      */     //   214: aload_2
/*      */     //   215: invokevirtual getTypeParameters : ()[Ljava/lang/reflect/TypeVariable;
/*      */     //   218: arraylength
/*      */     //   219: dup
/*      */     //   220: istore #4
/*      */     //   222: ifne -> 238
/*      */     //   225: aload_0
/*      */     //   226: aconst_null
/*      */     //   227: aload_2
/*      */     //   228: getstatic com/a/a/c/l/o.c : Lcom/a/a/c/l/n;
/*      */     //   231: invokevirtual a : (Lcom/a/a/c/l/c;Ljava/lang/Class;Lcom/a/a/c/l/n;)Lcom/a/a/c/j;
/*      */     //   234: astore_2
/*      */     //   235: goto -> 256
/*      */     //   238: aload_0
/*      */     //   239: aload_1
/*      */     //   240: iload #4
/*      */     //   242: aload_2
/*      */     //   243: iload_3
/*      */     //   244: invokespecial a : (Lcom/a/a/c/j;ILjava/lang/Class;Z)Lcom/a/a/c/l/n;
/*      */     //   247: astore_3
/*      */     //   248: aload_0
/*      */     //   249: aconst_null
/*      */     //   250: aload_2
/*      */     //   251: aload_3
/*      */     //   252: invokevirtual a : (Lcom/a/a/c/l/c;Ljava/lang/Class;Lcom/a/a/c/l/n;)Lcom/a/a/c/j;
/*      */     //   255: astore_2
/*      */     //   256: aload_2
/*      */     //   257: aload_1
/*      */     //   258: invokevirtual b : (Lcom/a/a/c/j;)Lcom/a/a/c/j;
/*      */     //   261: dup
/*      */     //   262: astore_2
/*      */     //   263: areturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #451	-> 0
/*      */     //   #452	-> 5
/*      */     //   #453	-> 11
/*      */     //   #459	-> 13
/*      */     //   #460	-> 20
/*      */     //   #461	-> 30
/*      */     //   #463	-> 33
/*      */     //   #464	-> 42
/*      */     //   #465	-> 55
/*      */     //   #464	-> 66
/*      */     //   #471	-> 73
/*      */     //   #472	-> 80
/*      */     //   #473	-> 87
/*      */     //   #477	-> 111
/*      */     //   #478	-> 116
/*      */     //   #477	-> 126
/*      */     //   #479	-> 130
/*      */     //   #481	-> 133
/*      */     //   #482	-> 140
/*      */     //   #486	-> 164
/*      */     //   #487	-> 169
/*      */     //   #486	-> 175
/*      */     //   #488	-> 179
/*      */     //   #492	-> 182
/*      */     //   #493	-> 189
/*      */     //   #498	-> 191
/*      */     //   #499	-> 201
/*      */     //   #500	-> 211
/*      */     //   #504	-> 214
/*      */     //   #505	-> 220
/*      */     //   #506	-> 225
/*      */     //   #507	-> 235
/*      */     //   #510	-> 238
/*      */     //   #512	-> 248
/*      */     //   #518	-> 256
/*      */     //   #519	-> 262
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
/*      */   private n a(j paramj, int paramInt, Class<?> paramClass, boolean paramBoolean) {
/*  525 */     i[] arrayOfI = new i[paramInt];
/*  526 */     for (byte b = 0; b < paramInt; b++) {
/*  527 */       arrayOfI[b] = new i(b);
/*      */     }
/*  529 */     n n1 = n.a(paramClass, (j[])arrayOfI);
/*      */ 
/*      */     
/*      */     j j1;
/*      */     
/*  534 */     if ((j1 = (j1 = a((c)null, paramClass, n1)).d(paramj.b())) == null) {
/*  535 */       throw new IllegalArgumentException(String.format("Internal error: unable to locate supertype (%s) from resolved subtype %s", new Object[] { paramj
/*  536 */               .b().getName(), paramClass
/*  537 */               .getName() }));
/*      */     }
/*      */     
/*      */     String str;
/*  541 */     if ((str = a(paramj, j1)) != null)
/*      */     {
/*      */       
/*  544 */       if (!paramBoolean) {
/*  545 */         throw new IllegalArgumentException("Failed to specialize base type " + paramj.G() + " as " + paramClass
/*  546 */             .getName() + ", problem: " + str);
/*      */       }
/*      */     }
/*      */     
/*  550 */     j[] arrayOfJ = new j[paramInt];
/*  551 */     for (paramBoolean = false; paramBoolean < paramInt; paramBoolean++) {
/*      */       j j2;
/*      */ 
/*      */ 
/*      */       
/*  556 */       if ((j2 = arrayOfI[paramBoolean].H()) == null) {
/*  557 */         j2 = b();
/*      */       }
/*  559 */       arrayOfJ[paramBoolean] = j2;
/*      */     } 
/*  561 */     return n.a(paramClass, arrayOfJ);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private String a(j paramj1, j paramj2) {
/*  567 */     List<j> list2 = paramj1.x().d();
/*      */     
/*      */     List<j> list1;
/*  570 */     int i = (list1 = paramj2.x().d()).size(); byte b;
/*      */     int k;
/*  572 */     for (b = 0, k = list2.size(); b < k; b++) {
/*  573 */       j j1 = list2.get(b);
/*  574 */       j j2 = (b < i) ? list1.get(b) : b();
/*      */       
/*  576 */       if (!b(j1, j2))
/*      */       {
/*      */ 
/*      */         
/*  580 */         if (!j1.a(Object.class))
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  589 */           if (b != 0 || 
/*  590 */             !paramj1.p() || 
/*  591 */             !j2.a(Object.class))
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  597 */             if (!j1.k() || 
/*  598 */               !j1.c(j2.b()))
/*      */             {
/*      */ 
/*      */               
/*  602 */               return String.format("Type parameter #%d/%d differs; can not specialize %s with %s", new Object[] {
/*  603 */                     Integer.valueOf(b + 1), Integer.valueOf(k), j1.G(), j2.G()
/*      */                   }); }  }  }  } 
/*      */     } 
/*  606 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean b(j paramj1, j paramj2) {
/*  612 */     if (paramj2 instanceof i) {
/*  613 */       ((i)paramj2).e(paramj1);
/*  614 */       return true;
/*      */     } 
/*      */ 
/*      */     
/*  618 */     if (paramj1.b() != paramj2.b()) {
/*  619 */       return false;
/*      */     }
/*      */     
/*  622 */     List<j> list1 = paramj1.x().d();
/*  623 */     List<j> list2 = paramj2.x().d(); byte b; int i;
/*  624 */     for (b = 0, i = list1.size(); b < i; b++) {
/*  625 */       j j1 = list1.get(b);
/*  626 */       j j2 = list2.get(b);
/*  627 */       if (!b(j1, j2)) {
/*  628 */         return false;
/*      */       }
/*      */     } 
/*  631 */     return true;
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
/*      */   public static j b(j paramj, Class<?> paramClass) {
/*      */     Class<?> clazz;
/*  648 */     if ((clazz = paramj.b()) == paramClass) {
/*  649 */       return paramj;
/*      */     }
/*      */     j j1;
/*  652 */     if ((j1 = paramj.d(paramClass)) == null) {
/*      */       
/*  654 */       if (!paramClass.isAssignableFrom(clazz)) {
/*  655 */         throw new IllegalArgumentException(String.format("Class %s not a super-type of %s", new Object[] { paramClass
/*  656 */                 .getName(), paramj }));
/*      */       }
/*      */       
/*  659 */       throw new IllegalArgumentException(String.format("Internal error: class %s not included as super-type for %s", new Object[] { paramClass
/*      */               
/*  661 */               .getName(), paramj }));
/*      */     } 
/*  663 */     return j1;
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
/*      */   public final j b(String paramString) {
/*  678 */     return this.v.a(paramString);
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
/*      */   public static j[] c(j paramj, Class<?> paramClass) {
/*  693 */     if ((paramj = paramj.d(paramClass)) == null) {
/*  694 */       return a;
/*      */     }
/*  696 */     return paramj.x().e();
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
/*      */   public final j a(Type paramType) {
/*  752 */     return a((c)null, paramType, c);
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
/*      */   public final j a(Type paramType, n paramn) {
/*  796 */     return a((c)null, paramType, paramn);
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
/*      */   public final e a(Class<? extends Collection> paramClass, Class<?> paramClass1) {
/*  898 */     return a(paramClass, 
/*  899 */         a((c)null, paramClass1, c));
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
/*      */   public final e a(Class<? extends Collection> paramClass, j paramj) {
/*  911 */     n n1 = n.b(paramClass, paramj);
/*  912 */     e e = (e)a((c)null, paramClass, n1);
/*      */     
/*      */     j j1;
/*  915 */     if (n1.b() && paramj != null && 
/*      */ 
/*      */       
/*  918 */       !(j1 = (j1 = e.d(Collection.class)).u()).equals(paramj)) {
/*  919 */       throw new IllegalArgumentException(String.format("Non-generic Collection class %s did not resolve to something with element type %s but %s ", new Object[] {
/*      */               
/*  921 */               i.g(paramClass), paramj, j1
/*      */             }));
/*      */     }
/*  924 */     return e;
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
/*      */   public final h a(Class<? extends Map> paramClass, Class<?> paramClass1, Class<?> paramClass2) {
/*      */     j j1;
/*      */     j j2;
/*  962 */     if (paramClass == Properties.class) {
/*  963 */       j1 = j2 = o;
/*      */     } else {
/*  965 */       j1 = a((c)null, (Class<?>)j1, c);
/*  966 */       j2 = a((c)null, (Class<?>)j2, c);
/*      */     } 
/*  968 */     return a(paramClass, j1, j2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final h a(Class<? extends Map> paramClass, j paramj1, j paramj2) {
/*  977 */     n n1 = n.b(paramClass, new j[] { paramj1, paramj2 });
/*  978 */     h h = (h)a((c)null, paramClass, n1);
/*      */ 
/*      */     
/*  981 */     if (n1.b()) {
/*      */       j j1;
/*      */       j j2;
/*  984 */       if (!(j2 = (j1 = h.d(Map.class)).t()).equals(paramj1)) {
/*  985 */         throw new IllegalArgumentException(String.format("Non-generic Map class %s did not resolve to something with key type %s but %s ", new Object[] {
/*      */                 
/*  987 */                 i.g(paramClass), paramj1, j2
/*      */               }));
/*      */       }
/*  990 */       if (!(paramj1 = j1.u()).equals(paramj2))
/*  991 */         throw new IllegalArgumentException(String.format("Non-generic Map class %s did not resolve to something with value type %s but %s ", new Object[] {
/*      */                 
/*  993 */                 i.g(paramClass), paramj2, paramj1
/*      */               })); 
/*      */     } 
/*  996 */     return h;
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
/*      */   @Deprecated
/*      */   public final j a(Class<?> paramClass) {
/* 1080 */     return d(paramClass, c, null, null);
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
/*      */   public final j a(Class<?> paramClass, n paramn) {
/* 1151 */     j j1 = a((c)null, paramClass, paramn);
/* 1152 */     return a(paramClass, j1);
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
/*      */   private j a(Class<?> paramClass, n paramn, j paramj, j[] paramArrayOfj) {
/*      */     j j1;
/*      */     j<j> j2;
/* 1256 */     if (paramClass == Properties.class)
/* 1257 */     { j1 = j2 = o; }
/*      */     else
/*      */     { int i;
/*      */       
/*      */       List<j> list;
/* 1262 */       switch (i = (list = paramn.d()).size())
/*      */       { case 0:
/* 1264 */           j1 = j2 = d();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1276 */           return h.a(paramClass, paramn, paramj, paramArrayOfj, j1, j2);case 2: j1 = j2.get(0); j2 = j2.get(1); return h.a(paramClass, paramn, paramj, paramArrayOfj, j1, j2); }  throw new IllegalArgumentException(String.format("Strange Map type %s with %d type parameter%s (%s), can not resolve", new Object[] { i.g(paramClass), Integer.valueOf(j1), (j1 == true) ? "" : "s", paramn })); }  return h.a(paramClass, paramn, paramj, paramArrayOfj, j1, j2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private j b(Class<?> paramClass, n paramn, j paramj, j[] paramArrayOfj) {
/*      */     j<j> j1;
/*      */     List<j> list;
/* 1285 */     if ((list = paramn.d()).isEmpty()) {
/* 1286 */       j1 = d();
/* 1287 */     } else if (j1.size() == 1) {
/* 1288 */       j1 = j1.get(0);
/*      */     } else {
/* 1290 */       throw new IllegalArgumentException("Strange Collection type " + paramClass.getName() + ": cannot determine type parameters");
/*      */     } 
/* 1292 */     return e.a(paramClass, paramn, paramj, paramArrayOfj, j1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private j c(Class<?> paramClass, n paramn, j paramj, j[] paramArrayOfj) {
/*      */     j<j> j1;
/*      */     List<j> list;
/* 1301 */     if ((list = paramn.d()).isEmpty()) {
/* 1302 */       j1 = d();
/* 1303 */     } else if (j1.size() == 1) {
/* 1304 */       j1 = j1.get(0);
/*      */     } else {
/* 1306 */       throw new IllegalArgumentException("Strange Reference type " + paramClass.getName() + ": cannot determine type parameters");
/*      */     } 
/* 1308 */     return j.a(paramClass, paramn, paramj, paramArrayOfj, j1);
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
/*      */   private j d(Class<?> paramClass, n paramn, j paramj, j[] paramArrayOfj) {
/*      */     j j1;
/* 1322 */     if (paramn.b() && (
/*      */       
/* 1324 */       j1 = b(paramClass)) != null) {
/* 1325 */       return j1;
/*      */     }
/*      */     
/* 1328 */     return e(paramClass, paramn, paramj, paramArrayOfj);
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
/*      */   private static j e(Class<?> paramClass, n paramn, j paramj, j[] paramArrayOfj) {
/* 1341 */     return new l(paramClass, paramn, paramj, paramArrayOfj);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static j d() {
/* 1350 */     return p;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static j b(Class<?> paramClass) {
/* 1361 */     if (paramClass.isPrimitive()) {
/* 1362 */       if (paramClass == i) return l; 
/* 1363 */       if (paramClass == j) return m; 
/* 1364 */       if (paramClass == k) return n; 
/*      */     } else {
/* 1366 */       if (paramClass == d) return o; 
/* 1367 */       if (paramClass == e) return p; 
/* 1368 */       if (paramClass == h) return s; 
/*      */     } 
/* 1370 */     return null;
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
/*      */   private j a(c paramc, Type paramType, n paramn) {
/*      */     j j1;
/* 1389 */     if (paramType instanceof Class) {
/*      */       
/* 1391 */       j1 = a(paramc, (Class)paramType, c);
/*      */     
/*      */     }
/* 1394 */     else if (paramType instanceof ParameterizedType) {
/* 1395 */       j1 = a((c)j1, (ParameterizedType)paramType, paramn);
/*      */     } else {
/* 1397 */       if (paramType instanceof j)
/*      */       {
/* 1399 */         return (j)paramType;
/*      */       }
/* 1401 */       if (paramType instanceof GenericArrayType) {
/* 1402 */         j1 = a((c)j1, (GenericArrayType)paramType, paramn);
/*      */       }
/* 1404 */       else if (paramType instanceof TypeVariable) {
/* 1405 */         j1 = a((c)j1, (TypeVariable)paramType, paramn);
/*      */       }
/* 1407 */       else if (paramType instanceof WildcardType) {
/* 1408 */         j1 = a((c)j1, (WildcardType)paramType, paramn);
/*      */       } else {
/*      */         
/* 1411 */         throw new IllegalArgumentException("Unrecognized Type: " + ((paramType == null) ? "[null]" : paramType.toString()));
/*      */       } 
/*      */     } 
/*      */     
/* 1415 */     return a(paramType, j1);
/*      */   }
/*      */ 
/*      */   
/*      */   private j a(Type paramType, j paramj) {
/* 1420 */     if (this.u == null) {
/* 1421 */       return paramj;
/*      */     }
/*      */     j j1;
/* 1424 */     (j1 = paramj).x();
/*      */     d[] arrayOfD;
/*      */     int i;
/*      */     byte b;
/* 1428 */     for (i = (arrayOfD = this.u).length, b = 0; b < i; b++) {
/*      */       d d1; j j2;
/* 1430 */       if ((j2 = (d1 = arrayOfD[b]).q()) == null) {
/* 1431 */         throw new IllegalStateException(String.format("TypeModifier %s (of type %s) return null for type %s", new Object[] { d1, d1
/*      */                 
/* 1433 */                 .getClass().getName(), j1 }));
/*      */       }
/* 1435 */       j1 = j2;
/*      */     } 
/* 1437 */     return j1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final j a(c paramc, Class<?> paramClass, n paramn) {
/*      */     Object object;
/*      */     j j1;
/* 1448 */     if ((j1 = b(paramClass)) != null) {
/* 1449 */       return j1;
/*      */     }
/*      */ 
/*      */     
/* 1453 */     if (paramn == null || paramn.b()) {
/* 1454 */       object = paramClass;
/*      */     } else {
/* 1456 */       object = paramn.a(paramClass);
/*      */     } 
/*      */     
/* 1459 */     if ((j1 = (j)this.t.a(object)) != null) {
/* 1460 */       return j1;
/*      */     }
/*      */ 
/*      */     
/* 1464 */     if (paramc == null) {
/* 1465 */       paramc = new c(paramClass);
/*      */     } else {
/*      */       c c1;
/* 1468 */       if ((c1 = paramc.b(paramClass)) != null) {
/*      */         
/* 1470 */         k k = new k(paramClass, c);
/* 1471 */         c1.a(k);
/* 1472 */         return k;
/*      */       } 
/*      */       
/* 1475 */       paramc = paramc.a(paramClass);
/*      */     } 
/*      */ 
/*      */     
/* 1479 */     if (paramClass.isArray()) {
/* 1480 */       j1 = a.a(a(paramc, paramClass.getComponentType(), paramn), paramn);
/*      */     } else {
/*      */       j j2;
/*      */ 
/*      */       
/*      */       j[] arrayOfJ;
/*      */ 
/*      */       
/* 1488 */       if (paramClass.isInterface()) {
/* 1489 */         j2 = null;
/* 1490 */         arrayOfJ = c(paramc, paramClass, paramn);
/*      */       } else {
/*      */         
/* 1493 */         j2 = b(paramc, paramClass, paramn);
/* 1494 */         arrayOfJ = c(paramc, paramClass, paramn);
/*      */       } 
/*      */ 
/*      */       
/* 1498 */       if (paramClass == Properties.class) {
/* 1499 */         j1 = h.a(paramClass, paramn, j2, arrayOfJ, o, o);
/*      */ 
/*      */ 
/*      */       
/*      */       }
/* 1504 */       else if (j2 != null) {
/* 1505 */         j1 = j2.a(paramClass, paramn, j2, arrayOfJ);
/*      */       } 
/*      */       
/* 1508 */       if (j1 == null && (
/*      */         
/* 1510 */         j1 = f(paramClass, paramn, j2, arrayOfJ)) == null && (
/*      */         
/* 1512 */         j1 = g(paramClass, paramn, j2, arrayOfJ)) == null)
/*      */       {
/* 1514 */         j1 = e(paramClass, paramn, j2, arrayOfJ);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1519 */     paramc.a(j1);
/*      */ 
/*      */     
/* 1522 */     if (!j1.C()) {
/* 1523 */       this.t.b(object, j1);
/*      */     }
/* 1525 */     return j1;
/*      */   }
/*      */ 
/*      */   
/*      */   private j b(c paramc, Class<?> paramClass, n paramn) {
/*      */     Type type;
/* 1531 */     if ((type = i.r(paramClass)) == null) {
/* 1532 */       return null;
/*      */     }
/* 1534 */     return a(paramc, type, paramn);
/*      */   }
/*      */ 
/*      */   
/*      */   private j[] c(c paramc, Class<?> paramClass, n paramn) {
/*      */     Type[] arrayOfType;
/* 1540 */     if ((arrayOfType = i.s(paramClass)) == null || arrayOfType.length == 0) {
/* 1541 */       return a;
/*      */     }
/*      */     int i;
/* 1544 */     j[] arrayOfJ = new j[i = arrayOfType.length];
/* 1545 */     for (byte b = 0; b < i; b++) {
/* 1546 */       Type type = arrayOfType[b];
/* 1547 */       arrayOfJ[b] = a(paramc, type, paramn);
/*      */     } 
/* 1549 */     return arrayOfJ;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private j f(Class<?> paramClass, n paramn, j paramj, j[] paramArrayOfj) {
/* 1560 */     if (paramn == null) {
/* 1561 */       paramn = c;
/*      */     }
/*      */     
/* 1564 */     if (paramClass == Map.class) {
/* 1565 */       return a(paramClass, paramn, paramj, paramArrayOfj);
/*      */     }
/* 1567 */     if (paramClass == Collection.class) {
/* 1568 */       return b(paramClass, paramn, paramj, paramArrayOfj);
/*      */     }
/*      */     
/* 1571 */     if (paramClass == AtomicReference.class) {
/* 1572 */       return c(paramClass, paramn, paramj, paramArrayOfj);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1578 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static j g(Class<?> paramClass, n paramn, j paramj, j[] paramArrayOfj) {
/* 1586 */     int i = paramArrayOfj.length;
/*      */     
/* 1588 */     for (byte b = 0; b < i; b++) {
/*      */       j j1;
/* 1590 */       if ((j1 = paramArrayOfj[b].a(paramClass, paramn, paramj, paramArrayOfj)) != null) {
/* 1591 */         return j1;
/*      */       }
/*      */     } 
/* 1594 */     return null;
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
/*      */   private j a(c paramc, ParameterizedType paramParameterizedType, n paramn) {
/*      */     n n1;
/*      */     Class<?> clazz;
/* 1609 */     if ((clazz = (Class)paramParameterizedType.getRawType()) == g) {
/* 1610 */       return r;
/*      */     }
/* 1612 */     if (clazz == f) {
/* 1613 */       return q;
/*      */     }
/*      */ 
/*      */     
/*      */     Type[] arrayOfType;
/*      */ 
/*      */     
/*      */     byte b;
/*      */ 
/*      */     
/* 1623 */     if (!(b = ((arrayOfType = paramParameterizedType.getActualTypeArguments()) == null) ? 0 : arrayOfType.length)) {
/* 1624 */       n1 = c;
/*      */     } else {
/* 1626 */       j[] arrayOfJ = new j[b];
/* 1627 */       for (byte b1 = 0; b1 < b; b1++) {
/* 1628 */         arrayOfJ[b1] = a(paramc, (Type)n1[b1], paramn);
/*      */       }
/* 1630 */       n1 = n.a(clazz, arrayOfJ);
/*      */     } 
/* 1632 */     return a(paramc, clazz, n1);
/*      */   }
/*      */ 
/*      */   
/*      */   private j a(c paramc, GenericArrayType paramGenericArrayType, n paramn) {
/*      */     j j1;
/* 1638 */     return a.a(j1 = a(paramc, paramGenericArrayType.getGenericComponentType(), paramn), paramn);
/*      */   }
/*      */ 
/*      */   
/*      */   private j a(c paramc, TypeVariable<?> paramTypeVariable, n paramn) {
/*      */     Type[] arrayOfType;
/* 1644 */     String str = paramTypeVariable.getName();
/* 1645 */     if (paramn == null) {
/* 1646 */       throw new IllegalArgumentException("Null `bindings` passed (type variable \"" + str + "\")");
/*      */     }
/*      */     j j1;
/* 1649 */     if ((j1 = paramn.b(str)) != null) {
/* 1650 */       return j1;
/*      */     }
/*      */ 
/*      */     
/* 1654 */     if (paramn.c(str)) {
/* 1655 */       return p;
/*      */     }
/* 1657 */     paramn = paramn.a(str);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1668 */     synchronized (paramTypeVariable) {
/* 1669 */       arrayOfType = paramTypeVariable.getBounds();
/*      */     } 
/* 1671 */     return a(paramc, arrayOfType[0], paramn);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private j a(c paramc, WildcardType paramWildcardType, n paramn) {
/* 1681 */     return a(paramc, paramWildcardType.getUpperBounds()[0], paramn);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\l\o.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */