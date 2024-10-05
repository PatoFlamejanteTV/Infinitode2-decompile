/*     */ package com.badlogic.gdx.utils;
/*     */ 
/*     */ import java.io.Reader;
/*     */ import java.io.Writer;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class PropertiesUtils
/*     */ {
/*     */   private static final int NONE = 0;
/*     */   private static final int SLASH = 1;
/*     */   private static final int UNICODE = 2;
/*     */   private static final int CONTINUE = 3;
/*     */   private static final int KEY_DONE = 4;
/*     */   private static final int IGNORE = 5;
/*     */   private static final String LINE_SEPARATOR = "\n";
/*     */   
/*     */   public static void load(ObjectMap<String, String> paramObjectMap, Reader paramReader) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: ifnonnull -> 14
/*     */     //   4: new java/lang/NullPointerException
/*     */     //   7: dup
/*     */     //   8: ldc 'properties cannot be null'
/*     */     //   10: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   13: athrow
/*     */     //   14: aload_1
/*     */     //   15: ifnonnull -> 28
/*     */     //   18: new java/lang/NullPointerException
/*     */     //   21: dup
/*     */     //   22: ldc 'reader cannot be null'
/*     */     //   24: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   27: athrow
/*     */     //   28: iconst_0
/*     */     //   29: istore_2
/*     */     //   30: iconst_0
/*     */     //   31: istore_3
/*     */     //   32: iconst_0
/*     */     //   33: istore #4
/*     */     //   35: bipush #40
/*     */     //   37: newarray char
/*     */     //   39: astore #5
/*     */     //   41: iconst_0
/*     */     //   42: istore #6
/*     */     //   44: iconst_m1
/*     */     //   45: istore #7
/*     */     //   47: iconst_1
/*     */     //   48: istore #8
/*     */     //   50: new java/io/BufferedReader
/*     */     //   53: dup
/*     */     //   54: aload_1
/*     */     //   55: invokespecial <init> : (Ljava/io/Reader;)V
/*     */     //   58: astore #9
/*     */     //   60: aload #9
/*     */     //   62: invokevirtual read : ()I
/*     */     //   65: dup
/*     */     //   66: istore_1
/*     */     //   67: iconst_m1
/*     */     //   68: if_icmpeq -> 606
/*     */     //   71: iload_1
/*     */     //   72: i2c
/*     */     //   73: istore_1
/*     */     //   74: iload #6
/*     */     //   76: aload #5
/*     */     //   78: arraylength
/*     */     //   79: if_icmpne -> 106
/*     */     //   82: aload #5
/*     */     //   84: arraylength
/*     */     //   85: iconst_1
/*     */     //   86: ishl
/*     */     //   87: newarray char
/*     */     //   89: astore #10
/*     */     //   91: aload #5
/*     */     //   93: iconst_0
/*     */     //   94: aload #10
/*     */     //   96: iconst_0
/*     */     //   97: iload #6
/*     */     //   99: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
/*     */     //   102: aload #10
/*     */     //   104: astore #5
/*     */     //   106: iload_2
/*     */     //   107: iconst_2
/*     */     //   108: if_icmpne -> 176
/*     */     //   111: iload_1
/*     */     //   112: bipush #16
/*     */     //   114: invokestatic digit : (CI)I
/*     */     //   117: dup
/*     */     //   118: istore #10
/*     */     //   120: iflt -> 142
/*     */     //   123: iload_3
/*     */     //   124: iconst_4
/*     */     //   125: ishl
/*     */     //   126: iload #10
/*     */     //   128: iadd
/*     */     //   129: istore_3
/*     */     //   130: iinc #4, 1
/*     */     //   133: iload #4
/*     */     //   135: iconst_4
/*     */     //   136: if_icmpge -> 158
/*     */     //   139: goto -> 60
/*     */     //   142: iload #4
/*     */     //   144: iconst_4
/*     */     //   145: if_icmpgt -> 158
/*     */     //   148: new java/lang/IllegalArgumentException
/*     */     //   151: dup
/*     */     //   152: ldc 'Invalid Unicode sequence: illegal character'
/*     */     //   154: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   157: athrow
/*     */     //   158: iconst_0
/*     */     //   159: istore_2
/*     */     //   160: aload #5
/*     */     //   162: iload #6
/*     */     //   164: iinc #6, 1
/*     */     //   167: iload_3
/*     */     //   168: i2c
/*     */     //   169: castore
/*     */     //   170: iload_1
/*     */     //   171: bipush #10
/*     */     //   173: if_icmpne -> 60
/*     */     //   176: iload_2
/*     */     //   177: iconst_1
/*     */     //   178: if_icmpne -> 313
/*     */     //   181: iconst_0
/*     */     //   182: istore_2
/*     */     //   183: iload_1
/*     */     //   184: lookupswitch default -> 310, 10 -> 265, 13 -> 260, 98 -> 270, 102 -> 276, 110 -> 282, 114 -> 288, 116 -> 294, 117 -> 300
/*     */     //   260: iconst_3
/*     */     //   261: istore_2
/*     */     //   262: goto -> 60
/*     */     //   265: iconst_5
/*     */     //   266: istore_2
/*     */     //   267: goto -> 60
/*     */     //   270: bipush #8
/*     */     //   272: istore_1
/*     */     //   273: goto -> 580
/*     */     //   276: bipush #12
/*     */     //   278: istore_1
/*     */     //   279: goto -> 580
/*     */     //   282: bipush #10
/*     */     //   284: istore_1
/*     */     //   285: goto -> 580
/*     */     //   288: bipush #13
/*     */     //   290: istore_1
/*     */     //   291: goto -> 580
/*     */     //   294: bipush #9
/*     */     //   296: istore_1
/*     */     //   297: goto -> 580
/*     */     //   300: iconst_2
/*     */     //   301: istore_2
/*     */     //   302: iconst_0
/*     */     //   303: dup
/*     */     //   304: istore #4
/*     */     //   306: istore_3
/*     */     //   307: goto -> 60
/*     */     //   310: goto -> 580
/*     */     //   313: iload_1
/*     */     //   314: lookupswitch default -> 526, 10 -> 414, 13 -> 424, 33 -> 380, 35 -> 380, 58 -> 511, 61 -> 511, 92 -> 497
/*     */     //   380: iload #8
/*     */     //   382: ifeq -> 526
/*     */     //   385: aload #9
/*     */     //   387: invokevirtual read : ()I
/*     */     //   390: dup
/*     */     //   391: istore_1
/*     */     //   392: iconst_m1
/*     */     //   393: if_icmpeq -> 60
/*     */     //   396: iload_1
/*     */     //   397: i2c
/*     */     //   398: dup
/*     */     //   399: istore_1
/*     */     //   400: bipush #13
/*     */     //   402: if_icmpeq -> 60
/*     */     //   405: iload_1
/*     */     //   406: bipush #10
/*     */     //   408: if_icmpne -> 385
/*     */     //   411: goto -> 60
/*     */     //   414: iload_2
/*     */     //   415: iconst_3
/*     */     //   416: if_icmpne -> 424
/*     */     //   419: iconst_5
/*     */     //   420: istore_2
/*     */     //   421: goto -> 60
/*     */     //   424: iconst_0
/*     */     //   425: istore_2
/*     */     //   426: iconst_1
/*     */     //   427: istore #8
/*     */     //   429: iload #6
/*     */     //   431: ifgt -> 444
/*     */     //   434: iload #6
/*     */     //   436: ifne -> 488
/*     */     //   439: iload #7
/*     */     //   441: ifne -> 488
/*     */     //   444: iload #7
/*     */     //   446: iconst_m1
/*     */     //   447: if_icmpne -> 454
/*     */     //   450: iload #6
/*     */     //   452: istore #7
/*     */     //   454: new java/lang/String
/*     */     //   457: dup
/*     */     //   458: aload #5
/*     */     //   460: iconst_0
/*     */     //   461: iload #6
/*     */     //   463: invokespecial <init> : ([CII)V
/*     */     //   466: astore #10
/*     */     //   468: aload_0
/*     */     //   469: aload #10
/*     */     //   471: iconst_0
/*     */     //   472: iload #7
/*     */     //   474: invokevirtual substring : (II)Ljava/lang/String;
/*     */     //   477: aload #10
/*     */     //   479: iload #7
/*     */     //   481: invokevirtual substring : (I)Ljava/lang/String;
/*     */     //   484: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   487: pop
/*     */     //   488: iconst_m1
/*     */     //   489: istore #7
/*     */     //   491: iconst_0
/*     */     //   492: istore #6
/*     */     //   494: goto -> 60
/*     */     //   497: iload_2
/*     */     //   498: iconst_4
/*     */     //   499: if_icmpne -> 506
/*     */     //   502: iload #6
/*     */     //   504: istore #7
/*     */     //   506: iconst_1
/*     */     //   507: istore_2
/*     */     //   508: goto -> 60
/*     */     //   511: iload #7
/*     */     //   513: iconst_m1
/*     */     //   514: if_icmpne -> 526
/*     */     //   517: iconst_0
/*     */     //   518: istore_2
/*     */     //   519: iload #6
/*     */     //   521: istore #7
/*     */     //   523: goto -> 60
/*     */     //   526: iload_1
/*     */     //   527: invokestatic isSpace : (C)Z
/*     */     //   530: ifeq -> 568
/*     */     //   533: iload_2
/*     */     //   534: iconst_3
/*     */     //   535: if_icmpne -> 540
/*     */     //   538: iconst_5
/*     */     //   539: istore_2
/*     */     //   540: iload #6
/*     */     //   542: ifeq -> 60
/*     */     //   545: iload #6
/*     */     //   547: iload #7
/*     */     //   549: if_icmpeq -> 60
/*     */     //   552: iload_2
/*     */     //   553: iconst_5
/*     */     //   554: if_icmpeq -> 60
/*     */     //   557: iload #7
/*     */     //   559: iconst_m1
/*     */     //   560: if_icmpne -> 568
/*     */     //   563: iconst_4
/*     */     //   564: istore_2
/*     */     //   565: goto -> 60
/*     */     //   568: iload_2
/*     */     //   569: iconst_5
/*     */     //   570: if_icmpeq -> 578
/*     */     //   573: iload_2
/*     */     //   574: iconst_3
/*     */     //   575: if_icmpne -> 580
/*     */     //   578: iconst_0
/*     */     //   579: istore_2
/*     */     //   580: iconst_0
/*     */     //   581: istore #8
/*     */     //   583: iload_2
/*     */     //   584: iconst_4
/*     */     //   585: if_icmpne -> 594
/*     */     //   588: iload #6
/*     */     //   590: istore #7
/*     */     //   592: iconst_0
/*     */     //   593: istore_2
/*     */     //   594: aload #5
/*     */     //   596: iload #6
/*     */     //   598: iinc #6, 1
/*     */     //   601: iload_1
/*     */     //   602: castore
/*     */     //   603: goto -> 60
/*     */     //   606: iload_2
/*     */     //   607: iconst_2
/*     */     //   608: if_icmpne -> 627
/*     */     //   611: iload #4
/*     */     //   613: iconst_4
/*     */     //   614: if_icmpgt -> 627
/*     */     //   617: new java/lang/IllegalArgumentException
/*     */     //   620: dup
/*     */     //   621: ldc 'Invalid Unicode sequence: expected format \uxxxx'
/*     */     //   623: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   626: athrow
/*     */     //   627: iload #7
/*     */     //   629: iconst_m1
/*     */     //   630: if_icmpne -> 642
/*     */     //   633: iload #6
/*     */     //   635: ifle -> 642
/*     */     //   638: iload #6
/*     */     //   640: istore #7
/*     */     //   642: iload #7
/*     */     //   644: iflt -> 709
/*     */     //   647: new java/lang/String
/*     */     //   650: dup
/*     */     //   651: aload #5
/*     */     //   653: iconst_0
/*     */     //   654: iload #6
/*     */     //   656: invokespecial <init> : ([CII)V
/*     */     //   659: dup
/*     */     //   660: astore #10
/*     */     //   662: iconst_0
/*     */     //   663: iload #7
/*     */     //   665: invokevirtual substring : (II)Ljava/lang/String;
/*     */     //   668: astore_1
/*     */     //   669: aload #10
/*     */     //   671: iload #7
/*     */     //   673: invokevirtual substring : (I)Ljava/lang/String;
/*     */     //   676: astore_3
/*     */     //   677: iload_2
/*     */     //   678: iconst_1
/*     */     //   679: if_icmpne -> 702
/*     */     //   682: new java/lang/StringBuilder
/*     */     //   685: dup
/*     */     //   686: invokespecial <init> : ()V
/*     */     //   689: aload_3
/*     */     //   690: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   693: ldc ' '
/*     */     //   695: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   698: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   701: astore_3
/*     */     //   702: aload_0
/*     */     //   703: aload_1
/*     */     //   704: aload_3
/*     */     //   705: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   708: pop
/*     */     //   709: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #50	-> 0
/*     */     //   #51	-> 14
/*     */     //   #52	-> 28
/*     */     //   #53	-> 35
/*     */     //   #54	-> 41
/*     */     //   #55	-> 47
/*     */     //   #57	-> 50
/*     */     //   #60	-> 60
/*     */     //   #61	-> 66
/*     */     //   #64	-> 71
/*     */     //   #66	-> 74
/*     */     //   #67	-> 82
/*     */     //   #68	-> 91
/*     */     //   #69	-> 102
/*     */     //   #71	-> 106
/*     */     //   #72	-> 111
/*     */     //   #73	-> 118
/*     */     //   #74	-> 123
/*     */     //   #75	-> 130
/*     */     //   #76	-> 139
/*     */     //   #78	-> 142
/*     */     //   #79	-> 148
/*     */     //   #81	-> 158
/*     */     //   #82	-> 160
/*     */     //   #83	-> 170
/*     */     //   #87	-> 176
/*     */     //   #88	-> 181
/*     */     //   #89	-> 183
/*     */     //   #91	-> 260
/*     */     //   #92	-> 262
/*     */     //   #94	-> 265
/*     */     //   #95	-> 267
/*     */     //   #97	-> 270
/*     */     //   #98	-> 273
/*     */     //   #100	-> 276
/*     */     //   #101	-> 279
/*     */     //   #103	-> 282
/*     */     //   #104	-> 285
/*     */     //   #106	-> 288
/*     */     //   #107	-> 291
/*     */     //   #109	-> 294
/*     */     //   #110	-> 297
/*     */     //   #112	-> 300
/*     */     //   #113	-> 302
/*     */     //   #114	-> 307
/*     */     //   #117	-> 313
/*     */     //   #120	-> 380
/*     */     //   #122	-> 385
/*     */     //   #123	-> 391
/*     */     //   #126	-> 396
/*     */     //   #127	-> 399
/*     */     //   #128	-> 411
/*     */     //   #135	-> 414
/*     */     //   #136	-> 419
/*     */     //   #137	-> 421
/*     */     //   #141	-> 424
/*     */     //   #142	-> 426
/*     */     //   #143	-> 429
/*     */     //   #144	-> 444
/*     */     //   #145	-> 450
/*     */     //   #147	-> 454
/*     */     //   #148	-> 468
/*     */     //   #150	-> 488
/*     */     //   #151	-> 491
/*     */     //   #152	-> 494
/*     */     //   #154	-> 497
/*     */     //   #155	-> 502
/*     */     //   #157	-> 506
/*     */     //   #158	-> 508
/*     */     //   #161	-> 511
/*     */     //   #162	-> 517
/*     */     //   #163	-> 519
/*     */     //   #164	-> 523
/*     */     //   #169	-> 526
/*     */     //   #170	-> 533
/*     */     //   #171	-> 538
/*     */     //   #174	-> 540
/*     */     //   #177	-> 557
/*     */     //   #178	-> 563
/*     */     //   #179	-> 565
/*     */     //   #182	-> 568
/*     */     //   #183	-> 578
/*     */     //   #186	-> 580
/*     */     //   #187	-> 583
/*     */     //   #188	-> 588
/*     */     //   #189	-> 592
/*     */     //   #191	-> 594
/*     */     //   #193	-> 606
/*     */     //   #194	-> 617
/*     */     //   #196	-> 627
/*     */     //   #197	-> 638
/*     */     //   #199	-> 642
/*     */     //   #200	-> 647
/*     */     //   #201	-> 660
/*     */     //   #202	-> 669
/*     */     //   #203	-> 677
/*     */     //   #204	-> 682
/*     */     //   #206	-> 702
/*     */     //   #208	-> 709
/*     */   }
/*     */   
/*     */   public static void store(ObjectMap<String, String> paramObjectMap, Writer paramWriter, String paramString) {
/* 227 */     storeImpl(paramObjectMap, paramWriter, paramString, false);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void storeImpl(ObjectMap<String, String> paramObjectMap, Writer paramWriter, String paramString, boolean paramBoolean) {
/* 232 */     if (paramString != null) {
/* 233 */       writeComment(paramWriter, paramString);
/*     */     }
/* 235 */     paramWriter.write("#");
/* 236 */     paramWriter.write((new Date()).toString());
/* 237 */     paramWriter.write("\n");
/*     */     
/* 239 */     StringBuilder stringBuilder = new StringBuilder(200);
/* 240 */     for (ObjectMap.Entries<ObjectMap.Entry> entries = paramObjectMap.entries().iterator(); entries.hasNext(); ) { ObjectMap.Entry entry = entries.next();
/* 241 */       dumpString(stringBuilder, (String)entry.key, true, paramBoolean);
/* 242 */       stringBuilder.append('=');
/* 243 */       dumpString(stringBuilder, (String)entry.value, false, paramBoolean);
/* 244 */       paramWriter.write("\n");
/* 245 */       paramWriter.write(stringBuilder.toString());
/* 246 */       stringBuilder.setLength(0); }
/*     */     
/* 248 */     paramWriter.flush();
/*     */   }
/*     */   
/*     */   private static void dumpString(StringBuilder paramStringBuilder, String paramString, boolean paramBoolean1, boolean paramBoolean2) {
/* 252 */     int i = paramString.length();
/* 253 */     for (byte b = 0; b < i; b++) {
/*     */       char c;
/*     */       
/* 256 */       if ((c = paramString.charAt(b)) > '=' && c < '') {
/* 257 */         paramStringBuilder.append((c == '\\') ? "\\\\" : Character.valueOf(c));
/*     */       } else {
/*     */         String str;
/* 260 */         switch (c) {
/*     */           case ' ':
/* 262 */             if (b == 0 || paramBoolean1) {
/* 263 */               paramStringBuilder.append("\\ "); break;
/*     */             } 
/* 265 */             paramStringBuilder.append(c);
/*     */             break;
/*     */           
/*     */           case '\n':
/* 269 */             paramStringBuilder.append("\\n");
/*     */             break;
/*     */           case '\r':
/* 272 */             paramStringBuilder.append("\\r");
/*     */             break;
/*     */           case '\t':
/* 275 */             paramStringBuilder.append("\\t");
/*     */             break;
/*     */           case '\f':
/* 278 */             paramStringBuilder.append("\\f");
/*     */             break;
/*     */           case '!':
/*     */           case '#':
/*     */           case ':':
/*     */           case '=':
/* 284 */             paramStringBuilder.append('\\').append(c);
/*     */             break;
/*     */           default:
/* 287 */             if ((((c < ' ' || c > '~') ? 1 : 0) & paramBoolean2) != 0) {
/* 288 */               str = Integer.toHexString(c);
/* 289 */               paramStringBuilder.append("\\u");
/* 290 */               for (byte b1 = 0; b1 < 4 - str.length(); b1++) {
/* 291 */                 paramStringBuilder.append('0');
/*     */               }
/* 293 */               paramStringBuilder.append(str); break;
/*     */             } 
/* 295 */             paramStringBuilder.append(str);
/*     */             break;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void writeComment(Writer paramWriter, String paramString) {
/* 303 */     paramWriter.write("#");
/* 304 */     int i = paramString.length();
/* 305 */     byte b = 0;
/* 306 */     int j = 0;
/* 307 */     while (b < i) {
/*     */       char c;
/* 309 */       if ((c = paramString.charAt(b)) > 'ÿ' || c == '\n' || c == '\r') {
/* 310 */         if (j != b) paramWriter.write(paramString.substring(j, b)); 
/* 311 */         if (c > 'ÿ') {
/* 312 */           String str = Integer.toHexString(c);
/* 313 */           paramWriter.write("\\u");
/* 314 */           for (c = Character.MIN_VALUE; c < 4 - str.length(); c++) {
/* 315 */             paramWriter.write(48);
/*     */           }
/* 317 */           paramWriter.write(str);
/*     */         } else {
/* 319 */           paramWriter.write("\n");
/* 320 */           if (c == '\r' && b != i - 1 && paramString.charAt(b + 1) == '\n') {
/* 321 */             b++;
/*     */           }
/* 323 */           if (b == i - 1 || (paramString.charAt(b + 1) != '#' && paramString.charAt(b + 1) != '!'))
/* 324 */             paramWriter.write("#"); 
/*     */         } 
/* 326 */         j = b + 1;
/*     */       } 
/* 328 */       b++;
/*     */     } 
/* 330 */     if (j != b) paramWriter.write(paramString.substring(j, b)); 
/* 331 */     paramWriter.write("\n");
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\PropertiesUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */