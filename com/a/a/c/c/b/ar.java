/*     */ package com.a.a.c.c.b;
/*     */ 
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.b.s;
/*     */ import com.a.a.c.a.a;
/*     */ import com.a.a.c.f;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.i;
/*     */ import com.a.a.c.i.e;
/*     */ import com.a.a.c.l.f;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ @a
/*     */ final class ar
/*     */   extends ae<Object>
/*     */ {
/*  32 */   protected static final Object[] a = new Object[0];
/*     */   
/*  34 */   private static ar b = new ar();
/*     */   
/*     */   private boolean c;
/*     */   
/*     */   public ar() {
/*  39 */     this(false);
/*     */   }
/*     */   private ar(boolean paramBoolean) {
/*  42 */     super(Object.class);
/*  43 */     this.c = paramBoolean;
/*     */   }
/*     */   
/*     */   public static ar a(boolean paramBoolean) {
/*  47 */     if (paramBoolean) {
/*  48 */       return new ar(true);
/*     */     }
/*  50 */     return b;
/*     */   }
/*     */ 
/*     */   
/*     */   public final f b() {
/*  55 */     return f.e;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Boolean a(f paramf) {
/*  62 */     return this.c ? Boolean.FALSE : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object a(l paraml, g paramg) {
/*  68 */     switch (paraml.l()) {
/*     */       case 1:
/*  70 */         return a(paraml, paramg, 
/*  71 */             a.a(paramg.a(s.a)));
/*     */ 
/*     */       
/*     */       case 2:
/*  75 */         return a.g();
/*     */       case 5:
/*  77 */         return c(paraml, paramg);
/*     */       case 3:
/*  79 */         return a(paraml, paramg, a.a());
/*     */       
/*     */       case 6:
/*  82 */         return paraml.w();
/*     */       case 7:
/*  84 */         if (paramg.a(r)) {
/*  85 */           return u(paraml, paramg);
/*     */         }
/*  87 */         return paraml.B();
/*     */       case 8:
/*  89 */         if (paramg.a(i.a)) {
/*  90 */           return paraml.L();
/*     */         }
/*  92 */         return paraml.B();
/*     */       case 9:
/*  94 */         return Boolean.TRUE;
/*     */       case 10:
/*  96 */         return Boolean.FALSE;
/*     */       case 11:
/*  98 */         return null;
/*     */       case 12:
/* 100 */         return paraml.N();
/*     */     } 
/*     */     
/* 103 */     return paramg.a(e(paramg), paraml);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object a(l paraml, g paramg, e parame) {
/* 111 */     switch (paraml.l()) {
/*     */       case 1:
/*     */       case 3:
/*     */       case 5:
/* 115 */         return parame.d(paraml, paramg);
/*     */     } 
/* 117 */     return a(paraml, paramg, paraml.l());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object a(l paraml, g paramg, Object paramObject) {
/*     */     o o;
/* 126 */     if (this.c) {
/* 127 */       return a(paraml, paramg);
/*     */     }
/* 129 */     switch (paraml.l()) {
/*     */       case 2:
/*     */       case 4:
/* 132 */         return paramObject;
/*     */ 
/*     */       
/*     */       case 1:
/* 136 */         if ((o = paraml.g()) == o.c) {
/* 137 */           return paramObject;
/*     */         }
/*     */ 
/*     */       
/*     */       case 5:
/* 142 */         if (paramObject instanceof Map) {
/* 143 */           Map<String, Object> map = (Map)paramObject;
/*     */           
/* 145 */           String str = paraml.v(); while (true) {
/*     */             Object object2;
/* 147 */             paraml.g();
/*     */             
/*     */             Object object1;
/*     */             
/* 151 */             if ((object1 = map.get(str)) != null) {
/* 152 */               object2 = a(paraml, paramg, object1);
/*     */             } else {
/* 154 */               object2 = a(paraml, paramg);
/*     */             } 
/* 156 */             if (object2 != object1) {
/* 157 */               map.put(str, object2);
/*     */             }
/* 159 */             if ((str = paraml.h()) == null) {
/* 160 */               return paramObject;
/*     */             }
/*     */           } 
/*     */         } 
/*     */         break;
/*     */       case 3:
/* 166 */         if ((o = paraml.g()) == o.e) {
/* 167 */           return paramObject;
/*     */         }
/*     */ 
/*     */         
/* 171 */         if (paramObject instanceof Collection) {
/* 172 */           Collection<Object> collection = (Collection)paramObject;
/*     */           
/*     */           while (true) {
/* 175 */             collection.add(a(paraml, paramg));
/* 176 */             if (paraml.g() == o.e) {
/* 177 */               return paramObject;
/*     */             }
/*     */           } 
/*     */         } 
/*     */         break;
/*     */     } 
/*     */     
/* 184 */     return a(paraml, paramg);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Object c(l paraml, g paramg) {
/* 190 */     a a = a.a(paramg.a(s.a));
/* 191 */     String str = paraml.v();
/* 192 */     for (; str != null; str = paraml.h()) {
/*     */       Object object;
/*     */       o o;
/* 195 */       if ((o = paraml.g()) == null) {
/* 196 */         o = o.a;
/*     */       }
/* 198 */       switch (o.a()) {
/*     */         case 1:
/* 200 */           object = a(paraml, paramg, a.b());
/*     */           break;
/*     */         case 2:
/* 203 */           return a.e();
/*     */         case 3:
/* 205 */           object = a(paraml, paramg, a.c());
/*     */           break;
/*     */         default:
/* 208 */           object = a(paraml, paramg, object.a()); break;
/*     */       } 
/* 210 */       a.a(str, object);
/*     */     } 
/* 212 */     return a.e();
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
/*     */   private Object a(l paraml, g paramg, a parama) {
/*     */     // Byte code:
/*     */     //   0: aload_2
/*     */     //   1: getstatic com/a/a/c/c/b/ar.r : I
/*     */     //   4: invokevirtual a : (I)Z
/*     */     //   7: istore #4
/*     */     //   9: aload_2
/*     */     //   10: getstatic com/a/a/c/i.d : Lcom/a/a/c/i;
/*     */     //   13: invokevirtual a : (Lcom/a/a/c/i;)Z
/*     */     //   16: istore #5
/*     */     //   18: aload_3
/*     */     //   19: astore #6
/*     */     //   21: aload #6
/*     */     //   23: invokevirtual d : ()Z
/*     */     //   26: ifeq -> 287
/*     */     //   29: aload_1
/*     */     //   30: invokevirtual h : ()Ljava/lang/String;
/*     */     //   33: astore #7
/*     */     //   35: aload #7
/*     */     //   37: ifnull -> 265
/*     */     //   40: aload_1
/*     */     //   41: invokevirtual g : ()Lcom/a/a/b/o;
/*     */     //   44: dup
/*     */     //   45: astore #8
/*     */     //   47: ifnonnull -> 55
/*     */     //   50: getstatic com/a/a/b/o.a : Lcom/a/a/b/o;
/*     */     //   53: astore #8
/*     */     //   55: aload #8
/*     */     //   57: invokevirtual a : ()I
/*     */     //   60: tableswitch default -> 236, 1 -> 124, 2 -> 236, 3 -> 136, 4 -> 236, 5 -> 236, 6 -> 148, 7 -> 157, 8 -> 179, 9 -> 205, 10 -> 213, 11 -> 221, 12 -> 227
/*     */     //   124: aload #6
/*     */     //   126: aload #7
/*     */     //   128: invokevirtual a : (Ljava/lang/String;)Lcom/a/a/c/c/b/ar$a;
/*     */     //   131: astore #6
/*     */     //   133: goto -> 256
/*     */     //   136: aload #6
/*     */     //   138: aload #7
/*     */     //   140: invokevirtual b : (Ljava/lang/String;)Lcom/a/a/c/c/b/ar$a;
/*     */     //   143: astore #6
/*     */     //   145: goto -> 21
/*     */     //   148: aload_1
/*     */     //   149: invokevirtual w : ()Ljava/lang/String;
/*     */     //   152: astore #8
/*     */     //   154: goto -> 247
/*     */     //   157: iload #4
/*     */     //   159: ifeq -> 170
/*     */     //   162: aload_1
/*     */     //   163: aload_2
/*     */     //   164: invokestatic u : (Lcom/a/a/b/l;Lcom/a/a/c/g;)Ljava/lang/Object;
/*     */     //   167: goto -> 174
/*     */     //   170: aload_1
/*     */     //   171: invokevirtual B : ()Ljava/lang/Number;
/*     */     //   174: astore #8
/*     */     //   176: goto -> 247
/*     */     //   179: aload_2
/*     */     //   180: getstatic com/a/a/c/i.a : Lcom/a/a/c/i;
/*     */     //   183: invokevirtual a : (Lcom/a/a/c/i;)Z
/*     */     //   186: ifeq -> 196
/*     */     //   189: aload_1
/*     */     //   190: invokevirtual L : ()Ljava/math/BigDecimal;
/*     */     //   193: goto -> 200
/*     */     //   196: aload_1
/*     */     //   197: invokevirtual B : ()Ljava/lang/Number;
/*     */     //   200: astore #8
/*     */     //   202: goto -> 247
/*     */     //   205: getstatic java/lang/Boolean.TRUE : Ljava/lang/Boolean;
/*     */     //   208: astore #8
/*     */     //   210: goto -> 247
/*     */     //   213: getstatic java/lang/Boolean.FALSE : Ljava/lang/Boolean;
/*     */     //   216: astore #8
/*     */     //   218: goto -> 247
/*     */     //   221: aconst_null
/*     */     //   222: astore #8
/*     */     //   224: goto -> 247
/*     */     //   227: aload_1
/*     */     //   228: invokevirtual N : ()Ljava/lang/Object;
/*     */     //   231: astore #8
/*     */     //   233: goto -> 247
/*     */     //   236: aload_2
/*     */     //   237: aload_0
/*     */     //   238: aload_2
/*     */     //   239: invokevirtual e : (Lcom/a/a/c/g;)Lcom/a/a/c/j;
/*     */     //   242: aload_1
/*     */     //   243: invokevirtual a : (Lcom/a/a/c/j;Lcom/a/a/b/l;)Ljava/lang/Object;
/*     */     //   246: areturn
/*     */     //   247: aload #6
/*     */     //   249: aload #7
/*     */     //   251: aload #8
/*     */     //   253: invokevirtual a : (Ljava/lang/String;Ljava/lang/Object;)V
/*     */     //   256: aload_1
/*     */     //   257: invokevirtual h : ()Ljava/lang/String;
/*     */     //   260: astore #7
/*     */     //   262: goto -> 35
/*     */     //   265: aload #6
/*     */     //   267: aload_3
/*     */     //   268: if_acmpne -> 277
/*     */     //   271: aload #6
/*     */     //   273: invokevirtual e : ()Ljava/lang/Object;
/*     */     //   276: areturn
/*     */     //   277: aload #6
/*     */     //   279: invokevirtual f : ()Lcom/a/a/c/c/b/ar$a;
/*     */     //   282: astore #6
/*     */     //   284: goto -> 21
/*     */     //   287: aload_1
/*     */     //   288: invokevirtual g : ()Lcom/a/a/b/o;
/*     */     //   291: dup
/*     */     //   292: astore #7
/*     */     //   294: ifnonnull -> 302
/*     */     //   297: getstatic com/a/a/b/o.a : Lcom/a/a/b/o;
/*     */     //   300: astore #7
/*     */     //   302: aload #7
/*     */     //   304: invokevirtual a : ()I
/*     */     //   307: tableswitch default -> 502, 1 -> 368, 2 -> 502, 3 -> 378, 4 -> 388, 5 -> 502, 6 -> 414, 7 -> 423, 8 -> 445, 9 -> 471, 10 -> 479, 11 -> 487, 12 -> 493
/*     */     //   368: aload #6
/*     */     //   370: invokevirtual b : ()Lcom/a/a/c/c/b/ar$a;
/*     */     //   373: astore #6
/*     */     //   375: goto -> 21
/*     */     //   378: aload #6
/*     */     //   380: invokevirtual c : ()Lcom/a/a/c/c/b/ar$a;
/*     */     //   383: astore #6
/*     */     //   385: goto -> 21
/*     */     //   388: aload #6
/*     */     //   390: aload_3
/*     */     //   391: if_acmpne -> 402
/*     */     //   394: aload #6
/*     */     //   396: iload #5
/*     */     //   398: invokevirtual b : (Z)Ljava/lang/Object;
/*     */     //   401: areturn
/*     */     //   402: aload #6
/*     */     //   404: iload #5
/*     */     //   406: invokevirtual c : (Z)Lcom/a/a/c/c/b/ar$a;
/*     */     //   409: astore #6
/*     */     //   411: goto -> 21
/*     */     //   414: aload_1
/*     */     //   415: invokevirtual w : ()Ljava/lang/String;
/*     */     //   418: astore #8
/*     */     //   420: goto -> 513
/*     */     //   423: iload #4
/*     */     //   425: ifeq -> 436
/*     */     //   428: aload_1
/*     */     //   429: aload_2
/*     */     //   430: invokestatic u : (Lcom/a/a/b/l;Lcom/a/a/c/g;)Ljava/lang/Object;
/*     */     //   433: goto -> 440
/*     */     //   436: aload_1
/*     */     //   437: invokevirtual B : ()Ljava/lang/Number;
/*     */     //   440: astore #8
/*     */     //   442: goto -> 513
/*     */     //   445: aload_2
/*     */     //   446: getstatic com/a/a/c/i.a : Lcom/a/a/c/i;
/*     */     //   449: invokevirtual a : (Lcom/a/a/c/i;)Z
/*     */     //   452: ifeq -> 462
/*     */     //   455: aload_1
/*     */     //   456: invokevirtual L : ()Ljava/math/BigDecimal;
/*     */     //   459: goto -> 466
/*     */     //   462: aload_1
/*     */     //   463: invokevirtual B : ()Ljava/lang/Number;
/*     */     //   466: astore #8
/*     */     //   468: goto -> 513
/*     */     //   471: getstatic java/lang/Boolean.TRUE : Ljava/lang/Boolean;
/*     */     //   474: astore #8
/*     */     //   476: goto -> 513
/*     */     //   479: getstatic java/lang/Boolean.FALSE : Ljava/lang/Boolean;
/*     */     //   482: astore #8
/*     */     //   484: goto -> 513
/*     */     //   487: aconst_null
/*     */     //   488: astore #8
/*     */     //   490: goto -> 513
/*     */     //   493: aload_1
/*     */     //   494: invokevirtual N : ()Ljava/lang/Object;
/*     */     //   497: astore #8
/*     */     //   499: goto -> 513
/*     */     //   502: aload_2
/*     */     //   503: aload_0
/*     */     //   504: aload_2
/*     */     //   505: invokevirtual e : (Lcom/a/a/c/g;)Lcom/a/a/c/j;
/*     */     //   508: aload_1
/*     */     //   509: invokevirtual a : (Lcom/a/a/c/j;Lcom/a/a/b/l;)Ljava/lang/Object;
/*     */     //   512: areturn
/*     */     //   513: aload #6
/*     */     //   515: aload #8
/*     */     //   517: invokevirtual a : (Ljava/lang/Object;)V
/*     */     //   520: goto -> 287
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #219	-> 0
/*     */     //   #220	-> 9
/*     */     //   #222	-> 18
/*     */     //   #226	-> 21
/*     */     //   #227	-> 29
/*     */     //   #230	-> 35
/*     */     //   #232	-> 40
/*     */     //   #233	-> 45
/*     */     //   #234	-> 50
/*     */     //   #236	-> 55
/*     */     //   #238	-> 124
/*     */     //   #240	-> 133
/*     */     //   #242	-> 136
/*     */     //   #244	-> 145
/*     */     //   #246	-> 148
/*     */     //   #247	-> 154
/*     */     //   #249	-> 157
/*     */     //   #250	-> 176
/*     */     //   #252	-> 179
/*     */     //   #253	-> 190
/*     */     //   #254	-> 202
/*     */     //   #256	-> 205
/*     */     //   #257	-> 210
/*     */     //   #259	-> 213
/*     */     //   #260	-> 218
/*     */     //   #262	-> 221
/*     */     //   #263	-> 224
/*     */     //   #265	-> 227
/*     */     //   #266	-> 233
/*     */     //   #268	-> 236
/*     */     //   #270	-> 247
/*     */     //   #230	-> 256
/*     */     //   #273	-> 265
/*     */     //   #274	-> 271
/*     */     //   #276	-> 277
/*     */     //   #277	-> 284
/*     */     //   #281	-> 287
/*     */     //   #282	-> 292
/*     */     //   #283	-> 297
/*     */     //   #286	-> 302
/*     */     //   #288	-> 368
/*     */     //   #289	-> 375
/*     */     //   #291	-> 378
/*     */     //   #292	-> 385
/*     */     //   #294	-> 388
/*     */     //   #295	-> 394
/*     */     //   #297	-> 402
/*     */     //   #298	-> 411
/*     */     //   #300	-> 414
/*     */     //   #301	-> 420
/*     */     //   #303	-> 423
/*     */     //   #304	-> 442
/*     */     //   #306	-> 445
/*     */     //   #307	-> 456
/*     */     //   #308	-> 468
/*     */     //   #310	-> 471
/*     */     //   #311	-> 476
/*     */     //   #313	-> 479
/*     */     //   #314	-> 484
/*     */     //   #316	-> 487
/*     */     //   #317	-> 490
/*     */     //   #319	-> 493
/*     */     //   #320	-> 499
/*     */     //   #322	-> 502
/*     */     //   #324	-> 513
/*     */     //   #325	-> 520
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
/*     */   private Object a(l paraml, g paramg, int paramInt) {
/* 334 */     switch (paramInt) {
/*     */       case 6:
/* 336 */         return paraml.w();
/*     */       case 7:
/* 338 */         if (paramg.a(i.b)) {
/* 339 */           return paraml.I();
/*     */         }
/* 341 */         return paraml.B();
/*     */       
/*     */       case 8:
/* 344 */         if (paramg.a(i.a)) {
/* 345 */           return paraml.L();
/*     */         }
/* 347 */         return paraml.B();
/*     */       case 9:
/* 349 */         return Boolean.TRUE;
/*     */       case 10:
/* 351 */         return Boolean.FALSE;
/*     */       case 12:
/* 353 */         return paraml.N();
/*     */       
/*     */       case 11:
/* 356 */         return null;
/*     */     } 
/*     */ 
/*     */     
/* 360 */     return paramg.a(e(paramg), paraml);
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
/*     */   static final class a
/*     */   {
/*     */     private final a a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private a b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private boolean c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private boolean d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private String e;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private Map<String, Object> f;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private List<Object> g;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private a(a param1a) {
/* 432 */       this.a = param1a;
/* 433 */       this.c = false;
/* 434 */       this.d = false;
/*     */     }
/*     */ 
/*     */     
/*     */     private a(a param1a, boolean param1Boolean1, boolean param1Boolean2) {
/* 439 */       this.a = param1a;
/* 440 */       this.c = true;
/* 441 */       this.d = param1Boolean2;
/*     */     }
/*     */     
/*     */     public static a a(boolean param1Boolean) {
/* 445 */       return new a(null, true, param1Boolean);
/*     */     }
/*     */     
/*     */     public static a a() {
/* 449 */       return new a(null);
/*     */     }
/*     */     
/*     */     private a h() {
/* 453 */       this.c = false;
/* 454 */       return this;
/*     */     }
/*     */     
/*     */     private a d(boolean param1Boolean) {
/* 458 */       this.c = true;
/* 459 */       this.d = param1Boolean;
/* 460 */       return this;
/*     */     }
/*     */     
/*     */     public final a b() {
/* 464 */       if (this.b == null) {
/* 465 */         return new a(this, true, this.d);
/*     */       }
/* 467 */       return this.b.d(this.d);
/*     */     }
/*     */     
/*     */     public final a a(String param1String) {
/* 471 */       this.e = param1String;
/* 472 */       if (this.b == null) {
/* 473 */         return new a(this, true, this.d);
/*     */       }
/* 475 */       return this.b.d(this.d);
/*     */     }
/*     */     
/*     */     public final a c() {
/* 479 */       if (this.b == null) {
/* 480 */         return new a(this);
/*     */       }
/* 482 */       return this.b.h();
/*     */     }
/*     */     
/*     */     public final a b(String param1String) {
/* 486 */       this.e = param1String;
/* 487 */       if (this.b == null) {
/* 488 */         return new a(this);
/*     */       }
/* 490 */       return this.b.h();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean d() {
/* 500 */       return this.c;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void a(String param1String, Object param1Object) {
/* 510 */       if (this.d) {
/* 511 */         b(param1String, param1Object);
/*     */         return;
/*     */       } 
/* 514 */       if (this.f == null) {
/* 515 */         this.f = new LinkedHashMap<>();
/*     */       }
/* 517 */       this.f.put(param1String, param1Object);
/*     */     }
/*     */     
/*     */     private a b(Object param1Object) {
/* 521 */       String str = Objects.<String>requireNonNull(this.e);
/* 522 */       this.e = null;
/* 523 */       if (this.d) {
/* 524 */         b(str, param1Object);
/* 525 */         return this;
/*     */       } 
/* 527 */       if (this.f == null) {
/* 528 */         this.f = new LinkedHashMap<>();
/*     */       }
/* 530 */       this.f.put(str, param1Object);
/* 531 */       return this;
/*     */     }
/*     */     
/*     */     public final void a(Object param1Object) {
/* 535 */       if (this.g == null) {
/* 536 */         this.g = new ArrayList();
/*     */       }
/* 538 */       this.g.add(param1Object);
/*     */     }
/*     */     
/*     */     public final Object e() {
/* 542 */       if (this.f == null) {
/* 543 */         return g();
/*     */       }
/* 545 */       return this.f;
/*     */     }
/*     */     
/*     */     public final a f() {
/*     */       Map<String, Object> map;
/* 550 */       if (this.f == null) {
/* 551 */         LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
/*     */       } else {
/* 553 */         map = this.f;
/* 554 */         this.f = null;
/*     */       } 
/* 556 */       if (this.a.d()) {
/* 557 */         return this.a.b(map);
/*     */       }
/* 559 */       this.a.a(map);
/* 560 */       return this.a;
/*     */     }
/*     */     
/*     */     public final Object b(boolean param1Boolean) {
/* 564 */       if (this.g == null) {
/* 565 */         if (param1Boolean) {
/* 566 */           return ar.a;
/*     */         }
/* 568 */         return i();
/*     */       } 
/* 570 */       if (param1Boolean) {
/* 571 */         return this.g.toArray(ar.a);
/*     */       }
/* 573 */       return this.g;
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
/*     */     public final a c(boolean param1Boolean) {
/*     */       // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: getfield g : Ljava/util/List;
/*     */       //   4: ifnonnull -> 25
/*     */       //   7: iload_1
/*     */       //   8: ifeq -> 18
/*     */       //   11: getstatic com/a/a/c/c/b/ar.a : [Ljava/lang/Object;
/*     */       //   14: astore_1
/*     */       //   15: goto -> 55
/*     */       //   18: invokestatic i : ()Ljava/util/List;
/*     */       //   21: astore_1
/*     */       //   22: goto -> 55
/*     */       //   25: iload_1
/*     */       //   26: ifeq -> 45
/*     */       //   29: aload_0
/*     */       //   30: getfield g : Ljava/util/List;
/*     */       //   33: getstatic com/a/a/c/c/b/ar.a : [Ljava/lang/Object;
/*     */       //   36: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
/*     */       //   41: astore_1
/*     */       //   42: goto -> 50
/*     */       //   45: aload_0
/*     */       //   46: getfield g : Ljava/util/List;
/*     */       //   49: astore_1
/*     */       //   50: aload_0
/*     */       //   51: aconst_null
/*     */       //   52: putfield g : Ljava/util/List;
/*     */       //   55: aload_0
/*     */       //   56: getfield a : Lcom/a/a/c/c/b/ar$a;
/*     */       //   59: invokevirtual d : ()Z
/*     */       //   62: ifeq -> 74
/*     */       //   65: aload_0
/*     */       //   66: getfield a : Lcom/a/a/c/c/b/ar$a;
/*     */       //   69: aload_1
/*     */       //   70: invokevirtual b : (Ljava/lang/Object;)Lcom/a/a/c/c/b/ar$a;
/*     */       //   73: areturn
/*     */       //   74: aload_0
/*     */       //   75: getfield a : Lcom/a/a/c/c/b/ar$a;
/*     */       //   78: aload_1
/*     */       //   79: invokevirtual a : (Ljava/lang/Object;)V
/*     */       //   82: aload_0
/*     */       //   83: getfield a : Lcom/a/a/c/c/b/ar$a;
/*     */       //   86: areturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #578	-> 0
/*     */       //   #579	-> 7
/*     */       //   #580	-> 11
/*     */       //   #582	-> 18
/*     */       //   #585	-> 25
/*     */       //   #586	-> 29
/*     */       //   #588	-> 45
/*     */       //   #590	-> 50
/*     */       //   #592	-> 55
/*     */       //   #593	-> 65
/*     */       //   #595	-> 74
/*     */       //   #596	-> 82
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
/*     */     private void b(String param1String, Object param1Object) {
/* 605 */       if (this.f == null) {
/* 606 */         this.f = new LinkedHashMap<>();
/* 607 */         this.f.put(param1String, param1Object);
/*     */         return;
/*     */       } 
/*     */       Object object;
/* 611 */       if ((object = this.f.put(param1String, param1Object)) != null) {
/*     */         
/* 613 */         if (object instanceof List) {
/* 614 */           ((List<Object>)object).add(param1Object);
/* 615 */           this.f.put(param1String, object); return;
/*     */         } 
/*     */         ArrayList<Object> arrayList;
/* 618 */         (arrayList = new ArrayList()).add(object);
/* 619 */         arrayList.add(param1Object);
/* 620 */         this.f.put(param1String, arrayList);
/*     */       } 
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
/*     */     public static Map<String, Object> g() {
/* 633 */       return new LinkedHashMap<>(2);
/*     */     }
/*     */     
/*     */     private static List<Object> i() {
/* 637 */       return new ArrayList(2);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\b\ar.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */