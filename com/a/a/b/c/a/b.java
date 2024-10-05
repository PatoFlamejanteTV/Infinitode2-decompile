/*     */ package com.a.a.b.c.a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class b
/*     */   extends a
/*     */ {
/*     */   private static boolean a(char paramChar) {
/*  26 */     return ('0' <= paramChar && paramChar <= '9');
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private long a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2) {
/*     */     // Byte code:
/*     */     //   0: lconst_0
/*     */     //   1: lstore #7
/*     */     //   3: iload_2
/*     */     //   4: istore #9
/*     */     //   6: iconst_m1
/*     */     //   7: istore #10
/*     */     //   9: iconst_0
/*     */     //   10: istore #11
/*     */     //   12: iconst_0
/*     */     //   13: istore #12
/*     */     //   15: iload_2
/*     */     //   16: iload #4
/*     */     //   18: if_icmpge -> 127
/*     */     //   21: aload_1
/*     */     //   22: iload_2
/*     */     //   23: invokeinterface charAt : (I)C
/*     */     //   28: dup
/*     */     //   29: istore #12
/*     */     //   31: invokestatic a : (C)Z
/*     */     //   34: ifeq -> 56
/*     */     //   37: ldc2_w 10
/*     */     //   40: lload #7
/*     */     //   42: lmul
/*     */     //   43: iload #12
/*     */     //   45: i2l
/*     */     //   46: ladd
/*     */     //   47: ldc2_w 48
/*     */     //   50: lsub
/*     */     //   51: lstore #7
/*     */     //   53: goto -> 121
/*     */     //   56: iload #12
/*     */     //   58: bipush #46
/*     */     //   60: if_icmpne -> 127
/*     */     //   63: iload #11
/*     */     //   65: iload #10
/*     */     //   67: iflt -> 74
/*     */     //   70: iconst_1
/*     */     //   71: goto -> 75
/*     */     //   74: iconst_0
/*     */     //   75: ior
/*     */     //   76: istore #11
/*     */     //   78: iload_2
/*     */     //   79: istore #10
/*     */     //   81: iload_2
/*     */     //   82: iload #4
/*     */     //   84: bipush #8
/*     */     //   86: isub
/*     */     //   87: if_icmpge -> 121
/*     */     //   90: aload_1
/*     */     //   91: iload_2
/*     */     //   92: iconst_1
/*     */     //   93: iadd
/*     */     //   94: invokestatic a : (Ljava/lang/CharSequence;I)I
/*     */     //   97: dup
/*     */     //   98: istore #13
/*     */     //   100: iflt -> 121
/*     */     //   103: ldc2_w 100000000
/*     */     //   106: lload #7
/*     */     //   108: lmul
/*     */     //   109: iload #13
/*     */     //   111: i2l
/*     */     //   112: ladd
/*     */     //   113: lstore #7
/*     */     //   115: iinc #2, 8
/*     */     //   118: goto -> 81
/*     */     //   121: iinc #2, 1
/*     */     //   124: goto -> 15
/*     */     //   127: iload_2
/*     */     //   128: istore #14
/*     */     //   130: iload #10
/*     */     //   132: ifge -> 152
/*     */     //   135: iload #14
/*     */     //   137: iload #9
/*     */     //   139: isub
/*     */     //   140: istore #13
/*     */     //   142: iload #14
/*     */     //   144: istore #10
/*     */     //   146: iconst_0
/*     */     //   147: istore #15
/*     */     //   149: goto -> 170
/*     */     //   152: iload #14
/*     */     //   154: iload #9
/*     */     //   156: isub
/*     */     //   157: iconst_1
/*     */     //   158: isub
/*     */     //   159: istore #13
/*     */     //   161: iload #10
/*     */     //   163: iload #14
/*     */     //   165: isub
/*     */     //   166: iconst_1
/*     */     //   167: iadd
/*     */     //   168: istore #15
/*     */     //   170: iconst_0
/*     */     //   171: istore #16
/*     */     //   173: iload #12
/*     */     //   175: bipush #101
/*     */     //   177: if_icmpeq -> 187
/*     */     //   180: iload #12
/*     */     //   182: bipush #69
/*     */     //   184: if_icmpne -> 340
/*     */     //   187: iinc #2, 1
/*     */     //   190: iload_2
/*     */     //   191: iload #4
/*     */     //   193: if_icmpge -> 206
/*     */     //   196: aload_1
/*     */     //   197: iload_2
/*     */     //   198: invokeinterface charAt : (I)C
/*     */     //   203: goto -> 207
/*     */     //   206: iconst_0
/*     */     //   207: dup
/*     */     //   208: istore #12
/*     */     //   210: bipush #45
/*     */     //   212: if_icmpne -> 219
/*     */     //   215: iconst_1
/*     */     //   216: goto -> 220
/*     */     //   219: iconst_0
/*     */     //   220: dup
/*     */     //   221: istore #17
/*     */     //   223: ifne -> 233
/*     */     //   226: iload #12
/*     */     //   228: bipush #43
/*     */     //   230: if_icmpne -> 255
/*     */     //   233: iinc #2, 1
/*     */     //   236: iload_2
/*     */     //   237: iload #4
/*     */     //   239: if_icmpge -> 252
/*     */     //   242: aload_1
/*     */     //   243: iload_2
/*     */     //   244: invokeinterface charAt : (I)C
/*     */     //   249: goto -> 253
/*     */     //   252: iconst_0
/*     */     //   253: istore #12
/*     */     //   255: iload #11
/*     */     //   257: iload #12
/*     */     //   259: invokestatic a : (C)Z
/*     */     //   262: ifne -> 269
/*     */     //   265: iconst_1
/*     */     //   266: goto -> 270
/*     */     //   269: iconst_0
/*     */     //   270: ior
/*     */     //   271: istore #11
/*     */     //   273: iload #16
/*     */     //   275: sipush #1024
/*     */     //   278: if_icmpge -> 294
/*     */     //   281: iload #16
/*     */     //   283: bipush #10
/*     */     //   285: imul
/*     */     //   286: iload #12
/*     */     //   288: iadd
/*     */     //   289: bipush #48
/*     */     //   291: isub
/*     */     //   292: istore #16
/*     */     //   294: iinc #2, 1
/*     */     //   297: iload_2
/*     */     //   298: iload #4
/*     */     //   300: if_icmpge -> 313
/*     */     //   303: aload_1
/*     */     //   304: iload_2
/*     */     //   305: invokeinterface charAt : (I)C
/*     */     //   310: goto -> 314
/*     */     //   313: iconst_0
/*     */     //   314: dup
/*     */     //   315: istore #12
/*     */     //   317: invokestatic a : (C)Z
/*     */     //   320: ifne -> 273
/*     */     //   323: iload #17
/*     */     //   325: ifeq -> 333
/*     */     //   328: iload #16
/*     */     //   330: ineg
/*     */     //   331: istore #16
/*     */     //   333: iload #15
/*     */     //   335: iload #16
/*     */     //   337: iadd
/*     */     //   338: istore #15
/*     */     //   340: iload_2
/*     */     //   341: iload #4
/*     */     //   343: if_icmpge -> 377
/*     */     //   346: iload #12
/*     */     //   348: bipush #100
/*     */     //   350: if_icmpeq -> 374
/*     */     //   353: iload #12
/*     */     //   355: bipush #68
/*     */     //   357: if_icmpeq -> 374
/*     */     //   360: iload #12
/*     */     //   362: bipush #102
/*     */     //   364: if_icmpeq -> 374
/*     */     //   367: iload #12
/*     */     //   369: bipush #70
/*     */     //   371: if_icmpne -> 377
/*     */     //   374: iinc #2, 1
/*     */     //   377: aload_1
/*     */     //   378: iload_2
/*     */     //   379: iload #4
/*     */     //   381: invokestatic c : (Ljava/lang/CharSequence;II)I
/*     */     //   384: istore_2
/*     */     //   385: iload #11
/*     */     //   387: ifne -> 406
/*     */     //   390: iload_2
/*     */     //   391: iload #4
/*     */     //   393: if_icmplt -> 406
/*     */     //   396: iload #6
/*     */     //   398: ifne -> 410
/*     */     //   401: iload #13
/*     */     //   403: ifne -> 410
/*     */     //   406: ldc2_w -1
/*     */     //   409: lreturn
/*     */     //   410: iconst_0
/*     */     //   411: istore #6
/*     */     //   413: iload #13
/*     */     //   415: bipush #19
/*     */     //   417: if_icmple -> 513
/*     */     //   420: lconst_0
/*     */     //   421: lstore #7
/*     */     //   423: iload #9
/*     */     //   425: istore_2
/*     */     //   426: iload_2
/*     */     //   427: iload #14
/*     */     //   429: if_icmpge -> 486
/*     */     //   432: aload_1
/*     */     //   433: iload_2
/*     */     //   434: invokeinterface charAt : (I)C
/*     */     //   439: dup
/*     */     //   440: istore #12
/*     */     //   442: bipush #46
/*     */     //   444: if_icmpne -> 453
/*     */     //   447: iinc #6, 1
/*     */     //   450: goto -> 480
/*     */     //   453: lload #7
/*     */     //   455: ldc2_w 1000000000000000000
/*     */     //   458: invokestatic compareUnsigned : (JJ)I
/*     */     //   461: ifge -> 486
/*     */     //   464: ldc2_w 10
/*     */     //   467: lload #7
/*     */     //   469: lmul
/*     */     //   470: iload #12
/*     */     //   472: i2l
/*     */     //   473: ladd
/*     */     //   474: ldc2_w 48
/*     */     //   477: lsub
/*     */     //   478: lstore #7
/*     */     //   480: iinc #2, 1
/*     */     //   483: goto -> 426
/*     */     //   486: iload_2
/*     */     //   487: iload #14
/*     */     //   489: if_icmpge -> 496
/*     */     //   492: iconst_1
/*     */     //   493: goto -> 497
/*     */     //   496: iconst_0
/*     */     //   497: istore #17
/*     */     //   499: iload #10
/*     */     //   501: iload_2
/*     */     //   502: isub
/*     */     //   503: iload #6
/*     */     //   505: iadd
/*     */     //   506: iload #16
/*     */     //   508: iadd
/*     */     //   509: istore_2
/*     */     //   510: goto -> 518
/*     */     //   513: iconst_0
/*     */     //   514: istore #17
/*     */     //   516: iconst_0
/*     */     //   517: istore_2
/*     */     //   518: aload_0
/*     */     //   519: aload_1
/*     */     //   520: iload_3
/*     */     //   521: iload #4
/*     */     //   523: iload #5
/*     */     //   525: lload #7
/*     */     //   527: iload #15
/*     */     //   529: iload #17
/*     */     //   531: iload_2
/*     */     //   532: invokevirtual a : (Ljava/lang/CharSequence;IIZJIZI)J
/*     */     //   535: lreturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #56	-> 0
/*     */     //   #57	-> 3
/*     */     //   #58	-> 6
/*     */     //   #59	-> 9
/*     */     //   #60	-> 12
/*     */     //   #61	-> 15
/*     */     //   #62	-> 21
/*     */     //   #63	-> 29
/*     */     //   #65	-> 37
/*     */     //   #66	-> 56
/*     */     //   #67	-> 63
/*     */     //   #68	-> 78
/*     */     //   #69	-> 81
/*     */     //   #70	-> 90
/*     */     //   #71	-> 98
/*     */     //   #75	-> 103
/*     */     //   #69	-> 115
/*     */     //   #61	-> 121
/*     */     //   #82	-> 127
/*     */     //   #84	-> 130
/*     */     //   #85	-> 135
/*     */     //   #86	-> 142
/*     */     //   #87	-> 146
/*     */     //   #89	-> 152
/*     */     //   #90	-> 161
/*     */     //   #95	-> 170
/*     */     //   #96	-> 173
/*     */     //   #97	-> 187
/*     */     //   #98	-> 208
/*     */     //   #99	-> 221
/*     */     //   #100	-> 233
/*     */     //   #102	-> 255
/*     */     //   #105	-> 273
/*     */     //   #106	-> 281
/*     */     //   #108	-> 294
/*     */     //   #109	-> 315
/*     */     //   #110	-> 323
/*     */     //   #111	-> 328
/*     */     //   #113	-> 333
/*     */     //   #118	-> 340
/*     */     //   #119	-> 374
/*     */     //   #124	-> 377
/*     */     //   #125	-> 385
/*     */     //   #127	-> 406
/*     */     //   #133	-> 410
/*     */     //   #135	-> 413
/*     */     //   #136	-> 420
/*     */     //   #137	-> 423
/*     */     //   #138	-> 432
/*     */     //   #139	-> 440
/*     */     //   #140	-> 447
/*     */     //   #142	-> 453
/*     */     //   #143	-> 464
/*     */     //   #137	-> 480
/*     */     //   #149	-> 486
/*     */     //   #150	-> 499
/*     */     //   #152	-> 513
/*     */     //   #153	-> 516
/*     */     //   #155	-> 518
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final long a(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/* 178 */     paramInt2 = paramInt1 + paramInt2;
/* 179 */     if (paramInt1 < 0 || paramInt2 > paramCharSequence.length()) {
/* 180 */       return -1L;
/*     */     }
/*     */ 
/*     */     
/*     */     int i;
/*     */     
/* 186 */     if ((i = c(paramCharSequence, paramInt1, paramInt2)) == paramInt2) {
/* 187 */       return -1L;
/*     */     }
/*     */     
/*     */     char c;
/*     */     
/*     */     boolean bool1;
/*     */     
/* 194 */     if ((bool1 = ((c = paramCharSequence.charAt(i)) == '-') ? true : false) || c == '+')
/*     */     {
/* 196 */       if ((c = (++i < paramInt2) ? paramCharSequence.charAt(i) : Character.MIN_VALUE) == '\000') {
/* 197 */         return -1L;
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 203 */     if (c >= 'I') {
/* 204 */       if (c == 'N')
/* 205 */         return b(paramCharSequence, i, paramInt2); 
/* 206 */       return a(paramCharSequence, i, paramInt2, bool1);
/*     */     } 
/*     */ 
/*     */     
/*     */     boolean bool2;
/*     */     
/* 212 */     if (bool2 = (c == '0') ? true : false)
/*     */     {
/* 214 */       if ((c = (++i < paramInt2) ? paramCharSequence.charAt(i) : Character.MIN_VALUE) == 'x' || c == 'X') {
/* 215 */         return a(paramCharSequence, i + 1, paramInt1, paramInt2, bool1);
/*     */       }
/*     */     }
/*     */     
/* 219 */     return a(paramCharSequence, i, paramInt1, paramInt2, bool1, bool2);
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
/*     */   private long a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
/*     */     int m;
/*     */     boolean bool2;
/* 257 */     long l = 0L;
/* 258 */     int i = 0;
/* 259 */     int j = paramInt1;
/* 260 */     int k = -1;
/*     */     
/* 262 */     int n = 0;
/* 263 */     char c = Character.MIN_VALUE;
/* 264 */     for (; paramInt1 < paramInt3; paramInt1++) {
/*     */       boolean bool;
/*     */ 
/*     */       
/* 268 */       if (bool = ((c = paramCharSequence.charAt(paramInt1)) > '') ? true : a.a[c]) {
/* 269 */         l = l << 4L | bool;
/* 270 */       } else if (bool == -4) {
/* 271 */         n |= (k >= 0) ? 1 : 0;
/* 272 */         k = paramInt1;
/*     */       } else {
/*     */         break;
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
/*     */ 
/*     */     
/* 288 */     int i1 = paramInt1;
/* 289 */     if (k < 0) {
/* 290 */       m = i1 - j;
/* 291 */       k = i1;
/*     */     } else {
/* 293 */       m = i1 - j - 1;
/* 294 */       i = Math.min(k - paramInt1 + 1, 1024) << 2;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 299 */     int i2 = 0;
/*     */     boolean bool1;
/* 301 */     if (bool1 = (c == 'p' || c == 'P') ? true : false) {
/*     */ 
/*     */       
/* 304 */       if ((bool2 = ((c = (++paramInt1 < paramInt3) ? paramCharSequence.charAt(paramInt1) : Character.MIN_VALUE) == '-') ? true : false) || c == '+') {
/* 305 */         c = (++paramInt1 < paramInt3) ? paramCharSequence.charAt(paramInt1) : Character.MIN_VALUE;
/*     */       }
/* 307 */       n |= !a(c) ? 1 : 0;
/*     */       
/*     */       while (true) {
/* 310 */         if (i2 < 1024) {
/* 311 */           i2 = i2 * 10 + c - 48;
/*     */         }
/*     */         
/* 314 */         if (!a(c = (++paramInt1 < paramInt3) ? paramCharSequence.charAt(paramInt1) : Character.MIN_VALUE)) {
/* 315 */           if (bool2) {
/* 316 */             i2 = -i2;
/*     */           }
/* 318 */           i += i2;
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 323 */     if (paramInt1 < paramInt3 && (c == 'd' || c == 'D' || c == 'f' || c == 'F')) {
/* 324 */       paramInt1++;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 329 */     paramInt1 = c(paramCharSequence, paramInt1, paramInt3);
/* 330 */     if (n != 0 || paramInt1 < paramInt3 || m == 0 || !bool1)
/*     */     {
/*     */       
/* 333 */       return -1L;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 339 */     n = 0;
/* 340 */     if (m > 16) {
/* 341 */       l = 0L;
/* 342 */       for (paramInt1 = j; paramInt1 < i1; paramInt1++) {
/*     */ 
/*     */ 
/*     */         
/* 346 */         if ((j = ((c = paramCharSequence.charAt(paramInt1)) > '') ? -1 : a.a[c]) >= 0) {
/* 347 */           if (Long.compareUnsigned(l, 1000000000000000000L) < 0) {
/* 348 */             l = l << 4L | j;
/*     */           } else {
/*     */             break;
/*     */           } 
/*     */         } else {
/* 353 */           n++;
/*     */         } 
/*     */       } 
/* 356 */       bool2 = (paramInt1 < i1) ? true : false;
/*     */     } else {
/* 358 */       bool2 = false;
/*     */     } 
/*     */     
/* 361 */     return b(paramCharSequence, paramInt2, paramInt3, paramBoolean, l, i, bool2, k - paramInt1 + n + i2);
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
/*     */   private long a(CharSequence paramCharSequence, int paramInt1, int paramInt2, boolean paramBoolean) {
/* 382 */     if (paramInt1 + 7 < paramInt2 && paramCharSequence
/* 383 */       .charAt(paramInt1) == 'I' && paramCharSequence
/* 384 */       .charAt(paramInt1 + 1) == 'n' && paramCharSequence
/* 385 */       .charAt(paramInt1 + 2) == 'f' && paramCharSequence
/* 386 */       .charAt(paramInt1 + 3) == 'i' && paramCharSequence
/* 387 */       .charAt(paramInt1 + 4) == 'n' && paramCharSequence
/* 388 */       .charAt(paramInt1 + 5) == 'i' && paramCharSequence
/* 389 */       .charAt(paramInt1 + 6) == 't' && paramCharSequence
/* 390 */       .charAt(paramInt1 + 7) == 'y')
/*     */     {
/*     */       
/* 393 */       if ((paramInt1 = c(paramCharSequence, paramInt1 + 8, paramInt2)) == paramInt2) {
/* 394 */         return paramBoolean ? b() : c();
/*     */       }
/*     */     }
/* 397 */     return -1L;
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
/*     */   private long b(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/* 419 */     if (paramInt1 + 2 < paramInt2 && paramCharSequence
/*     */       
/* 421 */       .charAt(paramInt1 + 1) == 'a' && paramCharSequence
/* 422 */       .charAt(paramInt1 + 2) == 'N')
/*     */     {
/*     */       
/* 425 */       if ((paramInt1 = c(paramCharSequence, paramInt1 + 3, paramInt2)) == paramInt2) {
/* 426 */         return a();
/*     */       }
/*     */     }
/* 429 */     return -1L;
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
/*     */   private static int c(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/* 441 */     for (; paramInt1 < paramInt2 && 
/* 442 */       paramCharSequence.charAt(paramInt1) <= ' '; paramInt1++);
/*     */ 
/*     */ 
/*     */     
/* 446 */     return paramInt1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int a(CharSequence paramCharSequence, int paramInt) {
/* 455 */     long l1 = paramCharSequence.charAt(paramInt) | paramCharSequence.charAt(paramInt + 1) << 16L | paramCharSequence.charAt(paramInt + 2) << 32L | paramCharSequence.charAt(paramInt + 3) << 48L;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 460 */     long l2 = paramCharSequence.charAt(paramInt + 4) | paramCharSequence.charAt(paramInt + 5) << 16L | paramCharSequence.charAt(paramInt + 6) << 32L | paramCharSequence.charAt(paramInt + 7) << 48L;
/*     */     
/* 462 */     return e.a(l1, l2);
/*     */   }
/*     */   
/*     */   abstract long a();
/*     */   
/*     */   abstract long b();
/*     */   
/*     */   abstract long c();
/*     */   
/*     */   abstract long a(CharSequence paramCharSequence, int paramInt1, int paramInt2, boolean paramBoolean1, long paramLong, int paramInt3, boolean paramBoolean2, int paramInt4);
/*     */   
/*     */   abstract long b(CharSequence paramCharSequence, int paramInt1, int paramInt2, boolean paramBoolean1, long paramLong, int paramInt3, boolean paramBoolean2, int paramInt4);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\c\a\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */