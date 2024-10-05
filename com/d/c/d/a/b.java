/*    */ package com.d.c.d.a;
/*    */ 
/*    */ import com.d.c.a.a;
/*    */ import com.d.c.a.c;
/*    */ import com.d.c.d.d;
/*    */ import com.d.c.d.j;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class b
/*    */   extends a
/*    */ {
/* 36 */   private static final a[] a = new a[] { a.c, a.d, a.e, a.f, a.g };
/*    */ 
/*    */ 
/*    */   
/*    */   private boolean a(j paramj) {
/* 41 */     short s = paramj.a();
/*    */     
/* 43 */     if (a((d)paramj) || s == 2)
/* 44 */       return true; 
/* 45 */     if (s != 21) {
/* 46 */       return false;
/*    */     }
/*    */     c c;
/* 49 */     if ((c = c.b(paramj.c())) != null && l.n
/* 50 */       .get(c.a)) return true; 
/*    */     return false;
/*    */   }
/*    */   
/*    */   public final List a(a parama, List<j> paramList, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: getstatic com/d/c/d/a/b.a : [Lcom/d/c/a/a;
/*    */     //   4: aload_2
/*    */     //   5: iload_3
/*    */     //   6: iload #4
/*    */     //   8: iload #5
/*    */     //   10: invokevirtual a : ([Lcom/d/c/a/a;Ljava/util/List;IZZ)Ljava/util/List;
/*    */     //   13: dup
/*    */     //   14: astore_1
/*    */     //   15: ifnull -> 20
/*    */     //   18: aload_1
/*    */     //   19: areturn
/*    */     //   20: aconst_null
/*    */     //   21: astore #5
/*    */     //   23: aconst_null
/*    */     //   24: astore #6
/*    */     //   26: aconst_null
/*    */     //   27: astore #7
/*    */     //   29: aconst_null
/*    */     //   30: astore #8
/*    */     //   32: aconst_null
/*    */     //   33: astore #9
/*    */     //   35: iconst_0
/*    */     //   36: istore_1
/*    */     //   37: iload_1
/*    */     //   38: aload_2
/*    */     //   39: invokeinterface size : ()I
/*    */     //   44: if_icmpge -> 568
/*    */     //   47: aload_2
/*    */     //   48: iload_1
/*    */     //   49: invokeinterface get : (I)Ljava/lang/Object;
/*    */     //   54: checkcast com/d/c/d/j
/*    */     //   57: dup
/*    */     //   58: astore #10
/*    */     //   60: iconst_0
/*    */     //   61: invokestatic a : (Lcom/d/c/d/d;Z)V
/*    */     //   64: iconst_0
/*    */     //   65: istore #11
/*    */     //   67: aload #10
/*    */     //   69: invokevirtual a : ()S
/*    */     //   72: dup
/*    */     //   73: istore #12
/*    */     //   75: bipush #21
/*    */     //   77: if_icmpne -> 344
/*    */     //   80: aload #10
/*    */     //   82: invokevirtual c : ()Ljava/lang/String;
/*    */     //   85: invokestatic a : (Ljava/lang/String;)Lcom/d/c/d/h;
/*    */     //   88: dup
/*    */     //   89: astore #13
/*    */     //   91: ifnull -> 137
/*    */     //   94: aload #5
/*    */     //   96: ifnull -> 110
/*    */     //   99: new com/d/c/d/b
/*    */     //   102: dup
/*    */     //   103: ldc 'A background-color value cannot be set twice'
/*    */     //   105: iconst_m1
/*    */     //   106: invokespecial <init> : (Ljava/lang/String;I)V
/*    */     //   109: athrow
/*    */     //   110: new com/d/i/v
/*    */     //   113: dup
/*    */     //   114: getstatic com/d/c/a/a.c : Lcom/d/c/a/a;
/*    */     //   117: new com/d/c/d/j
/*    */     //   120: dup
/*    */     //   121: aload #13
/*    */     //   123: invokespecial <init> : (Lcom/d/c/d/g;)V
/*    */     //   126: iload #4
/*    */     //   128: iload_3
/*    */     //   129: invokespecial <init> : (Lcom/d/c/a/a;Lcom/d/c/d/d;ZI)V
/*    */     //   132: astore #5
/*    */     //   134: goto -> 562
/*    */     //   137: getstatic com/d/c/a/a.be : Lcom/d/c/a/a;
/*    */     //   140: pop
/*    */     //   141: aload #10
/*    */     //   143: invokestatic b : (Lcom/d/c/d/d;)Lcom/d/c/a/c;
/*    */     //   146: astore #14
/*    */     //   148: getstatic com/d/c/d/a/l.l : Ljava/util/BitSet;
/*    */     //   151: aload #14
/*    */     //   153: getfield a : I
/*    */     //   156: invokevirtual get : (I)Z
/*    */     //   159: ifeq -> 195
/*    */     //   162: aload #7
/*    */     //   164: ifnull -> 178
/*    */     //   167: new com/d/c/d/b
/*    */     //   170: dup
/*    */     //   171: ldc 'A background-repeat value cannot be set twice'
/*    */     //   173: iconst_m1
/*    */     //   174: invokespecial <init> : (Ljava/lang/String;I)V
/*    */     //   177: athrow
/*    */     //   178: new com/d/i/v
/*    */     //   181: dup
/*    */     //   182: getstatic com/d/c/a/a.e : Lcom/d/c/a/a;
/*    */     //   185: aload #10
/*    */     //   187: iload #4
/*    */     //   189: iload_3
/*    */     //   190: invokespecial <init> : (Lcom/d/c/a/a;Lcom/d/c/d/d;ZI)V
/*    */     //   193: astore #7
/*    */     //   195: getstatic com/d/c/d/a/l.m : Ljava/util/BitSet;
/*    */     //   198: aload #14
/*    */     //   200: getfield a : I
/*    */     //   203: invokevirtual get : (I)Z
/*    */     //   206: ifeq -> 242
/*    */     //   209: aload #8
/*    */     //   211: ifnull -> 225
/*    */     //   214: new com/d/c/d/b
/*    */     //   217: dup
/*    */     //   218: ldc 'A background-attachment value cannot be set twice'
/*    */     //   220: iconst_m1
/*    */     //   221: invokespecial <init> : (Ljava/lang/String;I)V
/*    */     //   224: athrow
/*    */     //   225: new com/d/i/v
/*    */     //   228: dup
/*    */     //   229: getstatic com/d/c/a/a.f : Lcom/d/c/a/a;
/*    */     //   232: aload #10
/*    */     //   234: iload #4
/*    */     //   236: iload_3
/*    */     //   237: invokespecial <init> : (Lcom/d/c/a/a;Lcom/d/c/d/d;ZI)V
/*    */     //   240: astore #8
/*    */     //   242: aload #14
/*    */     //   244: getstatic com/d/c/a/c.bj : Lcom/d/c/a/c;
/*    */     //   247: if_acmpne -> 283
/*    */     //   250: aload #5
/*    */     //   252: ifnull -> 266
/*    */     //   255: new com/d/c/d/b
/*    */     //   258: dup
/*    */     //   259: ldc 'A background-color value cannot be set twice'
/*    */     //   261: iconst_m1
/*    */     //   262: invokespecial <init> : (Ljava/lang/String;I)V
/*    */     //   265: athrow
/*    */     //   266: new com/d/i/v
/*    */     //   269: dup
/*    */     //   270: getstatic com/d/c/a/a.c : Lcom/d/c/a/a;
/*    */     //   273: aload #10
/*    */     //   275: iload #4
/*    */     //   277: iload_3
/*    */     //   278: invokespecial <init> : (Lcom/d/c/a/a;Lcom/d/c/d/d;ZI)V
/*    */     //   281: astore #5
/*    */     //   283: aload #14
/*    */     //   285: getstatic com/d/c/a/c.ap : Lcom/d/c/a/c;
/*    */     //   288: if_acmpne -> 324
/*    */     //   291: aload #6
/*    */     //   293: ifnull -> 307
/*    */     //   296: new com/d/c/d/b
/*    */     //   299: dup
/*    */     //   300: ldc 'A background-image value cannot be set twice'
/*    */     //   302: iconst_m1
/*    */     //   303: invokespecial <init> : (Ljava/lang/String;I)V
/*    */     //   306: athrow
/*    */     //   307: new com/d/i/v
/*    */     //   310: dup
/*    */     //   311: getstatic com/d/c/a/a.d : Lcom/d/c/a/a;
/*    */     //   314: aload #10
/*    */     //   316: iload #4
/*    */     //   318: iload_3
/*    */     //   319: invokespecial <init> : (Lcom/d/c/a/a;Lcom/d/c/d/d;ZI)V
/*    */     //   322: astore #6
/*    */     //   324: getstatic com/d/c/d/a/l.n : Ljava/util/BitSet;
/*    */     //   327: aload #14
/*    */     //   329: getfield a : I
/*    */     //   332: invokevirtual get : (I)Z
/*    */     //   335: ifeq -> 341
/*    */     //   338: iconst_1
/*    */     //   339: istore #11
/*    */     //   341: goto -> 427
/*    */     //   344: iload #12
/*    */     //   346: bipush #25
/*    */     //   348: if_icmpne -> 387
/*    */     //   351: aload #5
/*    */     //   353: ifnull -> 367
/*    */     //   356: new com/d/c/d/b
/*    */     //   359: dup
/*    */     //   360: ldc 'A background-color value cannot be set twice'
/*    */     //   362: iconst_m1
/*    */     //   363: invokespecial <init> : (Ljava/lang/String;I)V
/*    */     //   366: athrow
/*    */     //   367: new com/d/i/v
/*    */     //   370: dup
/*    */     //   371: getstatic com/d/c/a/a.c : Lcom/d/c/a/a;
/*    */     //   374: aload #10
/*    */     //   376: iload #4
/*    */     //   378: iload_3
/*    */     //   379: invokespecial <init> : (Lcom/d/c/a/a;Lcom/d/c/d/d;ZI)V
/*    */     //   382: astore #5
/*    */     //   384: goto -> 427
/*    */     //   387: iload #12
/*    */     //   389: bipush #20
/*    */     //   391: if_icmpne -> 427
/*    */     //   394: aload #6
/*    */     //   396: ifnull -> 410
/*    */     //   399: new com/d/c/d/b
/*    */     //   402: dup
/*    */     //   403: ldc 'A background-image value cannot be set twice'
/*    */     //   405: iconst_m1
/*    */     //   406: invokespecial <init> : (Ljava/lang/String;I)V
/*    */     //   409: athrow
/*    */     //   410: new com/d/i/v
/*    */     //   413: dup
/*    */     //   414: getstatic com/d/c/a/a.d : Lcom/d/c/a/a;
/*    */     //   417: aload #10
/*    */     //   419: iload #4
/*    */     //   421: iload_3
/*    */     //   422: invokespecial <init> : (Lcom/d/c/a/a;Lcom/d/c/d/d;ZI)V
/*    */     //   425: astore #6
/*    */     //   427: iload #11
/*    */     //   429: ifne -> 446
/*    */     //   432: aload #10
/*    */     //   434: invokestatic a : (Lcom/d/c/d/d;)Z
/*    */     //   437: ifne -> 446
/*    */     //   440: iload #12
/*    */     //   442: iconst_2
/*    */     //   443: if_icmpne -> 562
/*    */     //   446: aload #9
/*    */     //   448: ifnull -> 462
/*    */     //   451: new com/d/c/d/b
/*    */     //   454: dup
/*    */     //   455: ldc 'A background-position value cannot be set twice'
/*    */     //   457: iconst_m1
/*    */     //   458: invokespecial <init> : (Ljava/lang/String;I)V
/*    */     //   461: athrow
/*    */     //   462: new java/util/ArrayList
/*    */     //   465: dup
/*    */     //   466: iconst_2
/*    */     //   467: invokespecial <init> : (I)V
/*    */     //   470: dup
/*    */     //   471: astore #13
/*    */     //   473: aload #10
/*    */     //   475: invokeinterface add : (Ljava/lang/Object;)Z
/*    */     //   480: pop
/*    */     //   481: iload_1
/*    */     //   482: aload_2
/*    */     //   483: invokeinterface size : ()I
/*    */     //   488: iconst_1
/*    */     //   489: isub
/*    */     //   490: if_icmpge -> 529
/*    */     //   493: aload_2
/*    */     //   494: iload_1
/*    */     //   495: iconst_1
/*    */     //   496: iadd
/*    */     //   497: invokeinterface get : (I)Ljava/lang/Object;
/*    */     //   502: checkcast com/d/c/d/j
/*    */     //   505: astore #14
/*    */     //   507: aload_0
/*    */     //   508: aload #14
/*    */     //   510: invokespecial a : (Lcom/d/c/d/j;)Z
/*    */     //   513: ifeq -> 529
/*    */     //   516: aload #13
/*    */     //   518: aload #14
/*    */     //   520: invokeinterface add : (Ljava/lang/Object;)Z
/*    */     //   525: pop
/*    */     //   526: iinc #1, 1
/*    */     //   529: getstatic com/d/c/a/a.g : Lcom/d/c/a/a;
/*    */     //   532: invokestatic e : (Lcom/d/c/a/a;)Lcom/d/c/d/a/m;
/*    */     //   535: dup
/*    */     //   536: astore #14
/*    */     //   538: getstatic com/d/c/a/a.g : Lcom/d/c/a/a;
/*    */     //   541: aload #13
/*    */     //   543: iload_3
/*    */     //   544: iload #4
/*    */     //   546: invokeinterface a : (Lcom/d/c/a/a;Ljava/util/List;IZ)Ljava/util/List;
/*    */     //   551: iconst_0
/*    */     //   552: invokeinterface get : (I)Ljava/lang/Object;
/*    */     //   557: checkcast com/d/i/v
/*    */     //   560: astore #9
/*    */     //   562: iinc #1, 1
/*    */     //   565: goto -> 37
/*    */     //   568: aload #5
/*    */     //   570: ifnonnull -> 598
/*    */     //   573: new com/d/i/v
/*    */     //   576: dup
/*    */     //   577: getstatic com/d/c/a/a.c : Lcom/d/c/a/a;
/*    */     //   580: new com/d/c/d/j
/*    */     //   583: dup
/*    */     //   584: getstatic com/d/c/a/c.bj : Lcom/d/c/a/c;
/*    */     //   587: invokespecial <init> : (Lcom/d/c/a/c;)V
/*    */     //   590: iload #4
/*    */     //   592: iload_3
/*    */     //   593: invokespecial <init> : (Lcom/d/c/a/a;Lcom/d/c/d/d;ZI)V
/*    */     //   596: astore #5
/*    */     //   598: aload #6
/*    */     //   600: ifnonnull -> 628
/*    */     //   603: new com/d/i/v
/*    */     //   606: dup
/*    */     //   607: getstatic com/d/c/a/a.d : Lcom/d/c/a/a;
/*    */     //   610: new com/d/c/d/j
/*    */     //   613: dup
/*    */     //   614: getstatic com/d/c/a/c.ap : Lcom/d/c/a/c;
/*    */     //   617: invokespecial <init> : (Lcom/d/c/a/c;)V
/*    */     //   620: iload #4
/*    */     //   622: iload_3
/*    */     //   623: invokespecial <init> : (Lcom/d/c/a/a;Lcom/d/c/d/d;ZI)V
/*    */     //   626: astore #6
/*    */     //   628: aload #7
/*    */     //   630: ifnonnull -> 658
/*    */     //   633: new com/d/i/v
/*    */     //   636: dup
/*    */     //   637: getstatic com/d/c/a/a.e : Lcom/d/c/a/a;
/*    */     //   640: new com/d/c/d/j
/*    */     //   643: dup
/*    */     //   644: getstatic com/d/c/a/c.aF : Lcom/d/c/a/c;
/*    */     //   647: invokespecial <init> : (Lcom/d/c/a/c;)V
/*    */     //   650: iload #4
/*    */     //   652: iload_3
/*    */     //   653: invokespecial <init> : (Lcom/d/c/a/a;Lcom/d/c/d/d;ZI)V
/*    */     //   656: astore #7
/*    */     //   658: aload #8
/*    */     //   660: ifnonnull -> 688
/*    */     //   663: new com/d/i/v
/*    */     //   666: dup
/*    */     //   667: getstatic com/d/c/a/a.f : Lcom/d/c/a/a;
/*    */     //   670: new com/d/c/d/j
/*    */     //   673: dup
/*    */     //   674: getstatic com/d/c/a/c.aM : Lcom/d/c/a/c;
/*    */     //   677: invokespecial <init> : (Lcom/d/c/a/c;)V
/*    */     //   680: iload #4
/*    */     //   682: iload_3
/*    */     //   683: invokespecial <init> : (Lcom/d/c/a/a;Lcom/d/c/d/d;ZI)V
/*    */     //   686: astore #8
/*    */     //   688: aload #9
/*    */     //   690: ifnonnull -> 761
/*    */     //   693: new java/util/ArrayList
/*    */     //   696: dup
/*    */     //   697: iconst_2
/*    */     //   698: invokespecial <init> : (I)V
/*    */     //   701: dup
/*    */     //   702: astore_1
/*    */     //   703: new com/d/c/d/j
/*    */     //   706: dup
/*    */     //   707: iconst_2
/*    */     //   708: fconst_0
/*    */     //   709: ldc '0%'
/*    */     //   711: invokespecial <init> : (SFLjava/lang/String;)V
/*    */     //   714: invokeinterface add : (Ljava/lang/Object;)Z
/*    */     //   719: pop
/*    */     //   720: aload_1
/*    */     //   721: new com/d/c/d/j
/*    */     //   724: dup
/*    */     //   725: iconst_2
/*    */     //   726: fconst_0
/*    */     //   727: ldc '0%'
/*    */     //   729: invokespecial <init> : (SFLjava/lang/String;)V
/*    */     //   732: invokeinterface add : (Ljava/lang/Object;)Z
/*    */     //   737: pop
/*    */     //   738: new com/d/i/v
/*    */     //   741: dup
/*    */     //   742: getstatic com/d/c/a/a.g : Lcom/d/c/a/a;
/*    */     //   745: new com/d/c/d/j
/*    */     //   748: dup
/*    */     //   749: aload_1
/*    */     //   750: invokespecial <init> : (Ljava/util/List;)V
/*    */     //   753: iload #4
/*    */     //   755: iload_3
/*    */     //   756: invokespecial <init> : (Lcom/d/c/a/a;Lcom/d/c/d/d;ZI)V
/*    */     //   759: astore #9
/*    */     //   761: new java/util/ArrayList
/*    */     //   764: dup
/*    */     //   765: iconst_5
/*    */     //   766: invokespecial <init> : (I)V
/*    */     //   769: dup
/*    */     //   770: astore_1
/*    */     //   771: aload #5
/*    */     //   773: invokeinterface add : (Ljava/lang/Object;)Z
/*    */     //   778: pop
/*    */     //   779: aload_1
/*    */     //   780: aload #6
/*    */     //   782: invokeinterface add : (Ljava/lang/Object;)Z
/*    */     //   787: pop
/*    */     //   788: aload_1
/*    */     //   789: aload #7
/*    */     //   791: invokeinterface add : (Ljava/lang/Object;)Z
/*    */     //   796: pop
/*    */     //   797: aload_1
/*    */     //   798: aload #8
/*    */     //   800: invokeinterface add : (Ljava/lang/Object;)Z
/*    */     //   805: pop
/*    */     //   806: aload_1
/*    */     //   807: aload #9
/*    */     //   809: invokeinterface add : (Ljava/lang/Object;)Z
/*    */     //   814: pop
/*    */     //   815: aload_1
/*    */     //   816: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #56	-> 0
/*    */     //   #57	-> 14
/*    */     //   #58	-> 18
/*    */     //   #61	-> 20
/*    */     //   #62	-> 23
/*    */     //   #63	-> 26
/*    */     //   #64	-> 29
/*    */     //   #65	-> 32
/*    */     //   #67	-> 35
/*    */     //   #68	-> 47
/*    */     //   #69	-> 58
/*    */     //   #71	-> 64
/*    */     //   #72	-> 67
/*    */     //   #73	-> 73
/*    */     //   #74	-> 80
/*    */     //   #75	-> 89
/*    */     //   #76	-> 94
/*    */     //   #77	-> 99
/*    */     //   #80	-> 110
/*    */     //   #84	-> 134
/*    */     //   #87	-> 137
/*    */     //   #89	-> 148
/*    */     //   #90	-> 162
/*    */     //   #91	-> 167
/*    */     //   #94	-> 178
/*    */     //   #98	-> 195
/*    */     //   #99	-> 209
/*    */     //   #100	-> 214
/*    */     //   #103	-> 225
/*    */     //   #107	-> 242
/*    */     //   #108	-> 250
/*    */     //   #109	-> 255
/*    */     //   #112	-> 266
/*    */     //   #116	-> 283
/*    */     //   #117	-> 291
/*    */     //   #118	-> 296
/*    */     //   #121	-> 307
/*    */     //   #125	-> 324
/*    */     //   #126	-> 338
/*    */     //   #128	-> 341
/*    */     //   #129	-> 351
/*    */     //   #130	-> 356
/*    */     //   #133	-> 367
/*    */     //   #135	-> 387
/*    */     //   #136	-> 394
/*    */     //   #137	-> 399
/*    */     //   #140	-> 410
/*    */     //   #144	-> 427
/*    */     //   #145	-> 446
/*    */     //   #146	-> 451
/*    */     //   #149	-> 462
/*    */     //   #150	-> 471
/*    */     //   #151	-> 481
/*    */     //   #152	-> 493
/*    */     //   #153	-> 507
/*    */     //   #154	-> 516
/*    */     //   #155	-> 526
/*    */     //   #159	-> 529
/*    */     //   #160	-> 536
/*    */     //   #161	-> 552
/*    */     //   #67	-> 562
/*    */     //   #165	-> 568
/*    */     //   #166	-> 573
/*    */     //   #170	-> 598
/*    */     //   #171	-> 603
/*    */     //   #175	-> 628
/*    */     //   #176	-> 633
/*    */     //   #180	-> 658
/*    */     //   #181	-> 663
/*    */     //   #186	-> 688
/*    */     //   #187	-> 693
/*    */     //   #188	-> 702
/*    */     //   #189	-> 720
/*    */     //   #190	-> 738
/*    */     //   #194	-> 761
/*    */     //   #195	-> 770
/*    */     //   #196	-> 779
/*    */     //   #197	-> 788
/*    */     //   #198	-> 797
/*    */     //   #199	-> 806
/*    */     //   #201	-> 815
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\d\a\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */