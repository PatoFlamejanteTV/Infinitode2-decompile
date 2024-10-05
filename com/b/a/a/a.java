/*     */ package com.b.a.a;
/*     */ 
/*     */ import com.a.a.a.am;
/*     */ import com.b.a.c.i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class a
/*     */ {
/*     */   private boolean[] a;
/*     */   private int[] b;
/*     */   private int[] c;
/*     */   private int[] d;
/*     */   private final int[] e;
/*     */   private final int f;
/*     */   
/*     */   public a(int[] paramArrayOfint, int paramInt) {
/*  70 */     this.e = paramArrayOfint;
/*  71 */     this.f = paramInt;
/*  72 */     this.a = new boolean[256];
/*  73 */     this.b = new int[64];
/*  74 */     this.c = new int[64];
/*  75 */     this.d = new int[18];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  82 */     this.d[0] = a(2048, 0, this.f - 1);
/*     */     
/*  84 */     for (byte b = 1; b <= 16; b++) {
/*  85 */       this.d[b] = a(b << 12, this.d[b - 1], this.f - 1);
/*     */     }
/*  87 */     this.d[17] = this.f - 1;
/*     */     
/*  89 */     a();
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
/*     */   public final boolean a(int paramInt) {
/* 102 */     if (paramInt <= 255)
/* 103 */       return this.a[paramInt]; 
/* 104 */     if (paramInt <= 2047)
/* 105 */       return ((this.b[paramInt & 0x3F] & 1 << paramInt >> 6) != 0); 
/* 106 */     if (paramInt < 55296 || (paramInt >= 57344 && paramInt <= 65535)) {
/* 107 */       int i = paramInt >> 12;
/*     */       int j;
/* 109 */       if ((j = this.c[paramInt >> 6 & 0x3F] >> i & 0x10001) <= 1)
/*     */       {
/*     */         
/* 112 */         return (j != 0);
/*     */       }
/*     */       
/* 115 */       return b(paramInt, this.d[i], this.d[i + 1]);
/*     */     } 
/* 117 */     if (paramInt <= 1114111)
/*     */     {
/* 119 */       return b(paramInt, this.d[13], this.d[17]);
/*     */     }
/*     */ 
/*     */     
/* 123 */     return false;
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
/*     */   public final int a(CharSequence paramCharSequence, int paramInt, i.b paramb, am paramam) {
/*     */     // Byte code:
/*     */     //   0: iload_2
/*     */     //   1: istore #6
/*     */     //   3: aload_1
/*     */     //   4: invokeinterface length : ()I
/*     */     //   9: istore #7
/*     */     //   11: iconst_0
/*     */     //   12: istore #8
/*     */     //   14: getstatic com/b/a/c/i$b.a : Lcom/b/a/c/i$b;
/*     */     //   17: aload_3
/*     */     //   18: if_acmpeq -> 240
/*     */     //   21: iload #6
/*     */     //   23: iload #7
/*     */     //   25: if_icmpge -> 459
/*     */     //   28: aload_1
/*     */     //   29: iload #6
/*     */     //   31: invokeinterface charAt : (I)C
/*     */     //   36: dup
/*     */     //   37: istore_3
/*     */     //   38: sipush #255
/*     */     //   41: if_icmpgt -> 56
/*     */     //   44: aload_0
/*     */     //   45: getfield a : [Z
/*     */     //   48: iload_3
/*     */     //   49: baload
/*     */     //   50: ifne -> 234
/*     */     //   53: goto -> 459
/*     */     //   56: iload_3
/*     */     //   57: sipush #2047
/*     */     //   60: if_icmpgt -> 85
/*     */     //   63: aload_0
/*     */     //   64: getfield b : [I
/*     */     //   67: iload_3
/*     */     //   68: bipush #63
/*     */     //   70: iand
/*     */     //   71: iaload
/*     */     //   72: iconst_1
/*     */     //   73: iload_3
/*     */     //   74: bipush #6
/*     */     //   76: ishr
/*     */     //   77: ishl
/*     */     //   78: iand
/*     */     //   79: ifne -> 234
/*     */     //   82: goto -> 459
/*     */     //   85: iload_3
/*     */     //   86: ldc 55296
/*     */     //   88: if_icmplt -> 131
/*     */     //   91: iload_3
/*     */     //   92: ldc 56320
/*     */     //   94: if_icmpge -> 131
/*     */     //   97: iload #6
/*     */     //   99: iconst_1
/*     */     //   100: iadd
/*     */     //   101: iload #7
/*     */     //   103: if_icmpeq -> 131
/*     */     //   106: aload_1
/*     */     //   107: iload #6
/*     */     //   109: iconst_1
/*     */     //   110: iadd
/*     */     //   111: invokeinterface charAt : (I)C
/*     */     //   116: dup
/*     */     //   117: istore #5
/*     */     //   119: ldc 56320
/*     */     //   121: if_icmplt -> 131
/*     */     //   124: iload #5
/*     */     //   126: ldc 57344
/*     */     //   128: if_icmplt -> 197
/*     */     //   131: iload_3
/*     */     //   132: bipush #12
/*     */     //   134: ishr
/*     */     //   135: istore #5
/*     */     //   137: aload_0
/*     */     //   138: getfield c : [I
/*     */     //   141: iload_3
/*     */     //   142: bipush #6
/*     */     //   144: ishr
/*     */     //   145: bipush #63
/*     */     //   147: iand
/*     */     //   148: iaload
/*     */     //   149: iload #5
/*     */     //   151: ishr
/*     */     //   152: ldc 65537
/*     */     //   154: iand
/*     */     //   155: dup
/*     */     //   156: istore #9
/*     */     //   158: iconst_1
/*     */     //   159: if_icmpgt -> 170
/*     */     //   162: iload #9
/*     */     //   164: ifne -> 194
/*     */     //   167: goto -> 459
/*     */     //   170: aload_0
/*     */     //   171: iload_3
/*     */     //   172: aload_0
/*     */     //   173: getfield d : [I
/*     */     //   176: iload #5
/*     */     //   178: iaload
/*     */     //   179: aload_0
/*     */     //   180: getfield d : [I
/*     */     //   183: iload #5
/*     */     //   185: iconst_1
/*     */     //   186: iadd
/*     */     //   187: iaload
/*     */     //   188: invokespecial b : (III)Z
/*     */     //   191: ifeq -> 459
/*     */     //   194: goto -> 234
/*     */     //   197: iload_3
/*     */     //   198: iload #5
/*     */     //   200: invokestatic toCodePoint : (CC)I
/*     */     //   203: istore #5
/*     */     //   205: aload_0
/*     */     //   206: iload #5
/*     */     //   208: aload_0
/*     */     //   209: getfield d : [I
/*     */     //   212: bipush #16
/*     */     //   214: iaload
/*     */     //   215: aload_0
/*     */     //   216: getfield d : [I
/*     */     //   219: bipush #17
/*     */     //   221: iaload
/*     */     //   222: invokespecial b : (III)Z
/*     */     //   225: ifeq -> 459
/*     */     //   228: iinc #8, 1
/*     */     //   231: iinc #6, 1
/*     */     //   234: iinc #6, 1
/*     */     //   237: goto -> 21
/*     */     //   240: iload #6
/*     */     //   242: iload #7
/*     */     //   244: if_icmpge -> 459
/*     */     //   247: aload_1
/*     */     //   248: iload #6
/*     */     //   250: invokeinterface charAt : (I)C
/*     */     //   255: dup
/*     */     //   256: istore_3
/*     */     //   257: sipush #255
/*     */     //   260: if_icmpgt -> 275
/*     */     //   263: aload_0
/*     */     //   264: getfield a : [Z
/*     */     //   267: iload_3
/*     */     //   268: baload
/*     */     //   269: ifeq -> 453
/*     */     //   272: goto -> 459
/*     */     //   275: iload_3
/*     */     //   276: sipush #2047
/*     */     //   279: if_icmpgt -> 304
/*     */     //   282: aload_0
/*     */     //   283: getfield b : [I
/*     */     //   286: iload_3
/*     */     //   287: bipush #63
/*     */     //   289: iand
/*     */     //   290: iaload
/*     */     //   291: iconst_1
/*     */     //   292: iload_3
/*     */     //   293: bipush #6
/*     */     //   295: ishr
/*     */     //   296: ishl
/*     */     //   297: iand
/*     */     //   298: ifeq -> 453
/*     */     //   301: goto -> 459
/*     */     //   304: iload_3
/*     */     //   305: ldc 55296
/*     */     //   307: if_icmplt -> 350
/*     */     //   310: iload_3
/*     */     //   311: ldc 56320
/*     */     //   313: if_icmpge -> 350
/*     */     //   316: iload #6
/*     */     //   318: iconst_1
/*     */     //   319: iadd
/*     */     //   320: iload #7
/*     */     //   322: if_icmpeq -> 350
/*     */     //   325: aload_1
/*     */     //   326: iload #6
/*     */     //   328: iconst_1
/*     */     //   329: iadd
/*     */     //   330: invokeinterface charAt : (I)C
/*     */     //   335: dup
/*     */     //   336: istore #5
/*     */     //   338: ldc 56320
/*     */     //   340: if_icmplt -> 350
/*     */     //   343: iload #5
/*     */     //   345: ldc 57344
/*     */     //   347: if_icmplt -> 416
/*     */     //   350: iload_3
/*     */     //   351: bipush #12
/*     */     //   353: ishr
/*     */     //   354: istore #5
/*     */     //   356: aload_0
/*     */     //   357: getfield c : [I
/*     */     //   360: iload_3
/*     */     //   361: bipush #6
/*     */     //   363: ishr
/*     */     //   364: bipush #63
/*     */     //   366: iand
/*     */     //   367: iaload
/*     */     //   368: iload #5
/*     */     //   370: ishr
/*     */     //   371: ldc 65537
/*     */     //   373: iand
/*     */     //   374: dup
/*     */     //   375: istore #9
/*     */     //   377: iconst_1
/*     */     //   378: if_icmpgt -> 389
/*     */     //   381: iload #9
/*     */     //   383: ifeq -> 413
/*     */     //   386: goto -> 459
/*     */     //   389: aload_0
/*     */     //   390: iload_3
/*     */     //   391: aload_0
/*     */     //   392: getfield d : [I
/*     */     //   395: iload #5
/*     */     //   397: iaload
/*     */     //   398: aload_0
/*     */     //   399: getfield d : [I
/*     */     //   402: iload #5
/*     */     //   404: iconst_1
/*     */     //   405: iadd
/*     */     //   406: iaload
/*     */     //   407: invokespecial b : (III)Z
/*     */     //   410: ifne -> 459
/*     */     //   413: goto -> 453
/*     */     //   416: iload_3
/*     */     //   417: iload #5
/*     */     //   419: invokestatic toCodePoint : (CC)I
/*     */     //   422: istore #5
/*     */     //   424: aload_0
/*     */     //   425: iload #5
/*     */     //   427: aload_0
/*     */     //   428: getfield d : [I
/*     */     //   431: bipush #16
/*     */     //   433: iaload
/*     */     //   434: aload_0
/*     */     //   435: getfield d : [I
/*     */     //   438: bipush #17
/*     */     //   440: iaload
/*     */     //   441: invokespecial b : (III)Z
/*     */     //   444: ifne -> 459
/*     */     //   447: iinc #8, 1
/*     */     //   450: iinc #6, 1
/*     */     //   453: iinc #6, 1
/*     */     //   456: goto -> 240
/*     */     //   459: aload #4
/*     */     //   461: ifnull -> 480
/*     */     //   464: iload #6
/*     */     //   466: iload_2
/*     */     //   467: isub
/*     */     //   468: istore #5
/*     */     //   470: aload #4
/*     */     //   472: iload #5
/*     */     //   474: iload #8
/*     */     //   476: isub
/*     */     //   477: putfield a : I
/*     */     //   480: iload #6
/*     */     //   482: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #142	-> 0
/*     */     //   #143	-> 3
/*     */     //   #144	-> 11
/*     */     //   #145	-> 14
/*     */     //   #147	-> 21
/*     */     //   #148	-> 28
/*     */     //   #149	-> 37
/*     */     //   #150	-> 44
/*     */     //   #151	-> 53
/*     */     //   #153	-> 56
/*     */     //   #154	-> 63
/*     */     //   #155	-> 82
/*     */     //   #157	-> 85
/*     */     //   #158	-> 111
/*     */     //   #159	-> 131
/*     */     //   #160	-> 137
/*     */     //   #161	-> 156
/*     */     //   #164	-> 162
/*     */     //   #165	-> 167
/*     */     //   #169	-> 170
/*     */     //   #173	-> 194
/*     */     //   #175	-> 197
/*     */     //   #176	-> 205
/*     */     //   #179	-> 228
/*     */     //   #180	-> 231
/*     */     //   #182	-> 234
/*     */     //   #186	-> 240
/*     */     //   #187	-> 247
/*     */     //   #188	-> 256
/*     */     //   #189	-> 263
/*     */     //   #190	-> 272
/*     */     //   #192	-> 275
/*     */     //   #193	-> 282
/*     */     //   #194	-> 301
/*     */     //   #196	-> 304
/*     */     //   #197	-> 330
/*     */     //   #198	-> 350
/*     */     //   #199	-> 356
/*     */     //   #200	-> 375
/*     */     //   #203	-> 381
/*     */     //   #204	-> 386
/*     */     //   #208	-> 389
/*     */     //   #212	-> 413
/*     */     //   #214	-> 416
/*     */     //   #215	-> 424
/*     */     //   #218	-> 447
/*     */     //   #219	-> 450
/*     */     //   #221	-> 453
/*     */     //   #224	-> 459
/*     */     //   #225	-> 464
/*     */     //   #226	-> 470
/*     */     //   #228	-> 480
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
/*     */   public final int a(CharSequence paramCharSequence, int paramInt, i.b paramb) {
/* 241 */     if (i.b.a != paramb) {
/*     */       while (true) {
/*     */         while (true) {
/*     */           char c;
/* 245 */           if ((c = paramCharSequence.charAt(--paramInt)) <= 'ÿ') {
/* 246 */             if (!this.a[c])
/*     */               break label52;  break;
/*     */           } 
/* 249 */           if (c <= '߿') {
/* 250 */             if ((this.b[c & 0x3F] & 1 << c >> 6) == 0)
/*     */               break label52;  break;
/*     */           }  int i;
/* 253 */           if (c < '?' || c < '?' || paramInt == 0 || (
/* 254 */             i = paramCharSequence.charAt(paramInt - 1)) < '?' || i >= 56320) {
/* 255 */             i = c >> 12;
/*     */             int j;
/* 257 */             if ((j = this.c[c >> 6 & 0x3F] >> i & 0x10001) <= 1) {
/*     */ 
/*     */               
/* 260 */               if (j == 0) {
/*     */                 break label52;
/*     */               }
/*     */               break;
/*     */             } 
/* 265 */             if (b(c, this.d[i], this.d[i + 1])) {
/*     */               break;
/*     */             }
/*     */             
/*     */             break label52;
/*     */           } 
/* 271 */           i = Character.toCodePoint(i, c);
/* 272 */           if (b(i, this.d[16], this.d[17]))
/*     */           
/*     */           { 
/* 275 */             paramInt--; } else { break label52; }
/*     */            break;
/* 277 */         }  if (paramInt == 0) {
/* 278 */           return 0;
/*     */         }
/*     */       } 
/*     */     } else {
/*     */       label52: while (true) {
/*     */         while (true) {
/*     */           char c;
/* 285 */           if ((c = paramCharSequence.charAt(--paramInt)) <= 'ÿ') {
/* 286 */             if (this.a[c])
/*     */               break label52;  break;
/*     */           } 
/* 289 */           if (c <= '߿') {
/* 290 */             if ((this.b[c & 0x3F] & 1 << c >> 6) != 0)
/*     */               break label52;  break;
/*     */           }  int i;
/* 293 */           if (c < '?' || c < '?' || paramInt == 0 || (
/* 294 */             i = paramCharSequence.charAt(paramInt - 1)) < '?' || i >= 56320) {
/* 295 */             i = c >> 12;
/*     */             int j;
/* 297 */             if ((j = this.c[c >> 6 & 0x3F] >> i & 0x10001) <= 1) {
/*     */ 
/*     */               
/* 300 */               if (j != 0) {
/*     */                 break label52;
/*     */               }
/*     */               break;
/*     */             } 
/* 305 */             if (!b(c, this.d[i], this.d[i + 1])) {
/*     */               break;
/*     */             }
/*     */             
/*     */             break label52;
/*     */           } 
/* 311 */           i = Character.toCodePoint(i, c);
/* 312 */           if (!b(i, this.d[16], this.d[17]))
/*     */           
/*     */           { 
/* 315 */             paramInt--; } else { break label52; }
/*     */            break;
/* 317 */         }  if (paramInt == 0) {
/* 318 */           return 0;
/*     */         }
/*     */       } 
/*     */     } 
/* 322 */     return paramInt + 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(int[] paramArrayOfint, int paramInt1, int paramInt2) {
/* 329 */     if (!g && 64 != paramArrayOfint.length) throw new AssertionError(); 
/* 330 */     int i = paramInt1 >> 6;
/* 331 */     int j = paramInt1 & 0x3F;
/*     */ 
/*     */     
/* 334 */     int k = 1 << i;
/* 335 */     if (paramInt1 + 1 == paramInt2) {
/* 336 */       paramArrayOfint[j] = paramArrayOfint[j] | k;
/*     */       
/*     */       return;
/*     */     } 
/* 340 */     paramInt1 = paramInt2 >> 6;
/* 341 */     paramInt2 &= 0x3F;
/*     */     
/* 343 */     if (i == paramInt1) {
/*     */       
/* 345 */       while (j < paramInt2) {
/* 346 */         paramArrayOfint[j++] = paramArrayOfint[j++] | k;
/*     */       
/*     */       }
/*     */     }
/*     */     else {
/*     */       
/* 352 */       if (j > 0)
/*     */         while (true) {
/* 354 */           paramArrayOfint[j++] = paramArrayOfint[j++] | k;
/* 355 */           if (j >= 64) {
/* 356 */             i++; break;
/*     */           } 
/* 358 */         }   if (i < paramInt1) {
/* 359 */         k = (1 << i) - 1 ^ 0xFFFFFFFF;
/* 360 */         if (paramInt1 < 32) {
/* 361 */           k &= (1 << paramInt1) - 1;
/*     */         }
/* 363 */         for (j = 0; j < 64; j++) {
/* 364 */           paramArrayOfint[j] = paramArrayOfint[j] | k;
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 371 */       k = 1 << paramInt1;
/* 372 */       for (j = 0; j < paramInt2; j++) {
/* 373 */         paramArrayOfint[j] = paramArrayOfint[j] | k;
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void a() {
/*     */     int i, j;
/* 380 */     byte b = 0;
/*     */ 
/*     */     
/*     */     while (true) {
/* 384 */       i = this.e[b++];
/* 385 */       if (b < this.f) {
/* 386 */         j = this.e[b++];
/*     */       } else {
/* 388 */         j = 1114112;
/*     */       } 
/* 390 */       if (i < 256) {
/*     */ 
/*     */         
/*     */         do {
/* 394 */           this.a[i++] = true;
/* 395 */         } while (i < j && i < 256);
/* 396 */         if (j > 256)
/*     */           break;  continue;
/*     */       }  break;
/* 399 */     }  while (i < 2048) {
/* 400 */       a(this.b, i, (j <= 2048) ? j : 2048);
/* 401 */       if (j > 2048) {
/* 402 */         i = 2048;
/*     */         
/*     */         break;
/*     */       } 
/* 406 */       i = this.e[b++];
/* 407 */       if (b < this.f) {
/* 408 */         j = this.e[b++]; continue;
/*     */       } 
/* 410 */       j = 1114112;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 415 */     int k = 2048;
/* 416 */     while (i < 65536) {
/* 417 */       if (j > 65536) {
/* 418 */         j = 65536;
/*     */       }
/*     */       
/* 421 */       if (i < k) {
/* 422 */         i = k;
/*     */       }
/* 424 */       if (i < j) {
/* 425 */         if (0 != (i & 0x3F)) {
/*     */           
/* 427 */           i >>= 6;
/* 428 */           this.c[i & 0x3F] = this.c[i & 0x3F] | 65537 << i >> 6;
/*     */           
/* 430 */           k = i = i + 1 << 6;
/*     */         } 
/* 432 */         if (i < j) {
/* 433 */           if (i < (j & 0xFFFFFFC0))
/*     */           {
/* 435 */             a(this.c, i >> 6, j >> 6);
/*     */           }
/*     */           
/* 438 */           if (0 != (j & 0x3F)) {
/*     */             
/* 440 */             j >>= 6;
/* 441 */             this.c[j & 0x3F] = this.c[j & 0x3F] | 65537 << j >> 6;
/*     */             
/* 443 */             k = j = j + 1 << 6;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 448 */       if (j != 65536) {
/*     */ 
/*     */ 
/*     */         
/* 452 */         i = this.e[b++];
/* 453 */         if (b < this.f) {
/* 454 */           j = this.e[b++]; continue;
/*     */         } 
/* 456 */         j = 1114112;
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
/*     */ 
/*     */ 
/*     */   
/*     */   private int a(int paramInt1, int paramInt2, int paramInt3) {
/* 490 */     if (paramInt1 < this.e[paramInt2]) {
/* 491 */       return paramInt2;
/*     */     }
/*     */     
/* 494 */     if (paramInt2 >= paramInt3 || paramInt1 >= this.e[paramInt3 - 1]) {
/* 495 */       return paramInt3;
/*     */     }
/*     */     
/*     */     int i;
/*     */     
/* 500 */     while ((i = paramInt2 + paramInt3 >>> 1) != paramInt2) {
/*     */       
/* 502 */       if (paramInt1 < this.e[i]) {
/* 503 */         paramInt3 = i; continue;
/*     */       } 
/* 505 */       paramInt2 = i;
/*     */     } 
/*     */     
/* 508 */     return paramInt3;
/*     */   }
/*     */   
/*     */   private final boolean b(int paramInt1, int paramInt2, int paramInt3) {
/* 512 */     return (0 != (a(paramInt1, paramInt2, paramInt3) & 0x1));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\b\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */