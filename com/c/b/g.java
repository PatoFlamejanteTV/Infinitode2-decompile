/*     */ package com.c.b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class g
/*     */   extends h
/*     */ {
/*     */   final Object a(l paraml, com.c.a.a parama) {
/*  77 */     int j = 0, k = -1;
/*     */     
/*     */     a a1;
/*     */     
/*  81 */     (a1 = new a(this)).a = parama.c(5); byte b1;
/*  82 */     for (b1 = 0; b1 < a1.a; b1++) {
/*  83 */       a1.b[b1] = parama.c(4);
/*  84 */       if (k < a1.b[b1]) {
/*  85 */         k = a1.b[b1];
/*     */       }
/*     */     } 
/*     */     
/*  89 */     for (b1 = 0; b1 < k + 1; b1++) {
/*  90 */       a1.c[b1] = parama.c(3) + 1;
/*  91 */       a1.d[b1] = parama.c(2);
/*  92 */       if (a1.d[b1] < 0) {
/*  93 */         a1.a();
/*  94 */         return null;
/*     */       } 
/*  96 */       if (a1.d[b1] != 0) {
/*  97 */         a1.e[b1] = parama.c(8);
/*     */       }
/*  99 */       if (a1.e[b1] < 0 || a1.e[b1] >= paraml.h) {
/* 100 */         a1.a();
/* 101 */         return null;
/*     */       } 
/* 103 */       for (byte b = 0; b < 1 << a1.d[b1]; b++) {
/* 104 */         a1.f[b1][b] = parama.c(8) - 1;
/* 105 */         if (a1.f[b1][b] < -1 || a1.f[b1][b] >= paraml.h) {
/* 106 */           a1.a();
/* 107 */           return null;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 113 */     a1.g = parama.c(2) + 1;
/* 114 */     int i = parama.c(4);
/*     */     byte b2;
/* 116 */     for (b1 = 0, b2 = 0; b1 < a1.a; b1++) {
/* 117 */       j += a1.c[a1.b[b1]];
/* 118 */       for (; b2 < j; b2++) {
/* 119 */         a1.h[b2 + 2] = parama.c(i);
/* 120 */         if ((k = parama.c(i)) < 0 || k >= 1 << i) {
/* 121 */           a1.a();
/* 122 */           return null;
/*     */         } 
/*     */       } 
/*     */     } 
/* 126 */     a1.h[0] = 0;
/* 127 */     a1.h[1] = 1 << i;
/*     */     
/* 129 */     return a1;
/*     */   }
/*     */   
/*     */   final Object a(e parame, o paramo, Object paramObject) {
/* 133 */     int i = 0;
/*     */     
/* 135 */     int[] arrayOfInt = new int[65];
/*     */ 
/*     */ 
/*     */     
/* 139 */     paramObject = paramObject;
/*     */     b b;
/* 141 */     (b = new b(this)).i = (a)paramObject;
/* 142 */     b.g = ((a)paramObject).h[1];
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int j;
/*     */ 
/*     */ 
/*     */     
/* 151 */     for (j = 0; j < ((a)paramObject).a; j++) {
/* 152 */       i += ((a)paramObject).c[((a)paramObject).b[j]];
/*     */     }
/* 154 */     i += 2;
/* 155 */     b.f = i;
/*     */ 
/*     */     
/* 158 */     for (j = 0; j < i; j++) {
/* 159 */       arrayOfInt[j] = j;
/*     */     }
/*     */     
/*     */     byte b1;
/*     */     
/* 164 */     for (b1 = 0; b1 < i - 1; b1++) {
/* 165 */       for (byte b2 = b1; b2 < i; b2++) {
/* 166 */         if (((a)paramObject).h[arrayOfInt[b1]] > ((a)paramObject).h[arrayOfInt[b2]]) {
/* 167 */           j = arrayOfInt[b2];
/* 168 */           arrayOfInt[b2] = arrayOfInt[b1];
/* 169 */           arrayOfInt[b1] = j;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 175 */     for (b1 = 0; b1 < i; b1++) {
/* 176 */       b.b[b1] = arrayOfInt[b1];
/*     */     }
/*     */     
/* 179 */     for (b1 = 0; b1 < i; b1++) {
/* 180 */       b.c[b.b[b1]] = b1;
/*     */     }
/*     */     
/* 183 */     for (b1 = 0; b1 < i; b1++) {
/* 184 */       b.a[b1] = ((a)paramObject).h[b.b[b1]];
/*     */     }
/*     */ 
/*     */     
/* 188 */     switch (((a)paramObject).g) {
/*     */       case 1:
/* 190 */         b.h = 256;
/*     */         break;
/*     */       case 2:
/* 193 */         b.h = 128;
/*     */         break;
/*     */       case 3:
/* 196 */         b.h = 86;
/*     */         break;
/*     */       case 4:
/* 199 */         b.h = 64;
/*     */         break;
/*     */       default:
/* 202 */         b.h = -1;
/*     */         break;
/*     */     } 
/*     */ 
/*     */     
/* 207 */     for (b1 = 0; b1 < i - 2; b1++) {
/* 208 */       byte b3 = 0;
/* 209 */       byte b2 = 1;
/* 210 */       j = 0;
/* 211 */       int k = b.g;
/* 212 */       int m = ((a)paramObject).h[b1 + 2];
/* 213 */       for (byte b4 = 0; b4 < b1 + 2; b4++) {
/*     */         int n;
/* 215 */         if ((n = ((a)paramObject).h[b4]) > j && n < m) {
/* 216 */           b3 = b4;
/* 217 */           j = n;
/*     */         } 
/* 219 */         if (n < k && n > m) {
/* 220 */           b2 = b4;
/* 221 */           k = n;
/*     */         } 
/*     */       } 
/* 224 */       b.e[b1] = b3;
/* 225 */       b.d[b1] = b2;
/*     */     } 
/*     */     
/* 228 */     return b;
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
/*     */   final Object a(a parama, Object paramObject1, Object paramObject2) {
/* 246 */     a a1 = ((b)(paramObject1 = paramObject1)).i;
/* 247 */     b[] arrayOfB = parama.k.e;
/*     */ 
/*     */     
/* 250 */     if (parama.b.c(1) == 1) {
/* 251 */       int[] arrayOfInt = null;
/* 252 */       if (paramObject2 instanceof int[]) {
/* 253 */         arrayOfInt = (int[])paramObject2;
/*     */       }
/* 255 */       if (arrayOfInt == null || arrayOfInt.length < ((b)paramObject1).f) {
/* 256 */         arrayOfInt = new int[((b)paramObject1).f];
/*     */       } else {
/*     */         
/* 259 */         for (byte b1 = 0; b1 < arrayOfInt.length; b1++) {
/* 260 */           arrayOfInt[b1] = 0;
/*     */         }
/*     */       } 
/* 263 */       arrayOfInt[0] = parama.b.c(o.a(((b)paramObject1).h - 1));
/* 264 */       arrayOfInt[1] = parama.b.c(o.a(((b)paramObject1).h - 1));
/*     */       byte b;
/*     */       int i;
/* 267 */       for (b = 0, i = 2; b < a1.a; b++) {
/* 268 */         int j = a1.b[b];
/* 269 */         int k = a1.c[j];
/* 270 */         int m = a1.d[j];
/* 271 */         int n = 1 << m;
/* 272 */         int i1 = 0;
/*     */ 
/*     */         
/* 275 */         if (m != 0 && (
/*     */ 
/*     */           
/* 278 */           i1 = arrayOfB[a1.e[j]].a(parama.b)) == -1) {
/* 279 */           return null;
/*     */         }
/*     */ 
/*     */         
/* 283 */         for (byte b1 = 0; b1 < k; b1++) {
/* 284 */           int i2 = a1.f[j][i1 & n - 1];
/* 285 */           i1 >>>= m;
/* 286 */           if (i2 >= 0) {
/* 287 */             arrayOfInt[i + b1] = arrayOfB[i2].a(parama.b); if (arrayOfB[i2].a(parama.b) == -1) {
/* 288 */               return null;
/*     */             }
/*     */           } else {
/*     */             
/* 292 */             arrayOfInt[i + b1] = 0;
/*     */           } 
/*     */         } 
/* 295 */         i += k;
/*     */       } 
/*     */ 
/*     */       
/* 299 */       for (b = 2; b < ((b)paramObject1).f; b++) {
/* 300 */         i = a(a1.h[((b)paramObject1).e[b - 2]], a1.h[((b)paramObject1).d[b - 2]], arrayOfInt[((b)paramObject1).e[b - 2]], arrayOfInt[((b)paramObject1).d[b - 2]], a1.h[b]);
/*     */ 
/*     */ 
/*     */         
/* 304 */         int j = ((b)paramObject1).h - i;
/* 305 */         int k = i;
/* 306 */         int m = ((j < k) ? j : k) << 1;
/*     */         
/*     */         int n;
/* 309 */         if ((n = arrayOfInt[b]) != 0) {
/* 310 */           if (n >= m) {
/* 311 */             if (j > k) {
/* 312 */               n -= k;
/*     */             } else {
/*     */               
/* 315 */               n = -1 - n - j;
/*     */             }
/*     */           
/*     */           }
/* 319 */           else if ((n & 0x1) != 0) {
/* 320 */             n = -(n + 1 >>> 1);
/*     */           } else {
/*     */             
/* 323 */             n >>= 1;
/*     */           } 
/*     */ 
/*     */           
/* 327 */           arrayOfInt[b] = n + i;
/* 328 */           arrayOfInt[((b)paramObject1).e[b - 2]] = arrayOfInt[((b)paramObject1).e[b - 2]] & 0x7FFF;
/* 329 */           arrayOfInt[((b)paramObject1).d[b - 2]] = arrayOfInt[((b)paramObject1).d[b - 2]] & 0x7FFF;
/*     */         } else {
/*     */           
/* 332 */           arrayOfInt[b] = i | 0x8000;
/*     */         } 
/*     */       } 
/* 335 */       return arrayOfInt;
/*     */     } 
/*     */     
/* 338 */     return null;
/*     */   }
/*     */   
/*     */   private static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 342 */     paramInt3 &= 0x7FFF;
/*     */ 
/*     */ 
/*     */     
/* 346 */     paramInt4 = (paramInt4 = paramInt4 & 0x7FFF) - paramInt3;
/* 347 */     paramInt2 -= paramInt1;
/*     */     
/*     */     int i;
/*     */     
/* 351 */     paramInt1 = (paramInt1 = (i = Math.abs(paramInt4)) * (paramInt5 - paramInt1)) / paramInt2;
/* 352 */     if (paramInt4 < 0)
/* 353 */       return paramInt3 - paramInt1; 
/* 354 */     return paramInt3 + paramInt1;
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
/*     */   final int a(a parama, Object paramObject1, Object paramObject2, float[] paramArrayOffloat) {
/*     */     // Byte code:
/*     */     //   0: aload_2
/*     */     //   1: checkcast com/c/b/g$b
/*     */     //   4: dup
/*     */     //   5: astore_2
/*     */     //   6: getfield i : Lcom/c/b/g$a;
/*     */     //   9: astore #5
/*     */     //   11: aload_1
/*     */     //   12: getfield k : Lcom/c/b/e;
/*     */     //   15: getfield a : Lcom/c/b/l;
/*     */     //   18: getfield c : [I
/*     */     //   21: aload_1
/*     */     //   22: getfield g : I
/*     */     //   25: iaload
/*     */     //   26: iconst_2
/*     */     //   27: idiv
/*     */     //   28: istore_1
/*     */     //   29: aload_3
/*     */     //   30: ifnull -> 174
/*     */     //   33: aload_3
/*     */     //   34: checkcast [I
/*     */     //   37: astore_3
/*     */     //   38: iconst_0
/*     */     //   39: istore #6
/*     */     //   41: iconst_0
/*     */     //   42: istore #7
/*     */     //   44: aload_3
/*     */     //   45: iconst_0
/*     */     //   46: iaload
/*     */     //   47: aload #5
/*     */     //   49: getfield g : I
/*     */     //   52: imul
/*     */     //   53: istore #8
/*     */     //   55: iconst_1
/*     */     //   56: istore #9
/*     */     //   58: iload #9
/*     */     //   60: aload_2
/*     */     //   61: getfield f : I
/*     */     //   64: if_icmpge -> 141
/*     */     //   67: aload_2
/*     */     //   68: getfield b : [I
/*     */     //   71: iload #9
/*     */     //   73: iaload
/*     */     //   74: istore #10
/*     */     //   76: aload_3
/*     */     //   77: iload #10
/*     */     //   79: iaload
/*     */     //   80: sipush #32767
/*     */     //   83: iand
/*     */     //   84: dup
/*     */     //   85: istore #11
/*     */     //   87: aload_3
/*     */     //   88: iload #10
/*     */     //   90: iaload
/*     */     //   91: if_icmpne -> 135
/*     */     //   94: iload #11
/*     */     //   96: aload #5
/*     */     //   98: getfield g : I
/*     */     //   101: imul
/*     */     //   102: istore #11
/*     */     //   104: aload #5
/*     */     //   106: getfield h : [I
/*     */     //   109: iload #10
/*     */     //   111: iaload
/*     */     //   112: istore #6
/*     */     //   114: iload #7
/*     */     //   116: iload #6
/*     */     //   118: iload #8
/*     */     //   120: iload #11
/*     */     //   122: aload #4
/*     */     //   124: invokestatic a : (IIII[F)V
/*     */     //   127: iload #6
/*     */     //   129: istore #7
/*     */     //   131: iload #11
/*     */     //   133: istore #8
/*     */     //   135: iinc #9, 1
/*     */     //   138: goto -> 58
/*     */     //   141: iload #6
/*     */     //   143: istore #9
/*     */     //   145: iload #9
/*     */     //   147: iload_1
/*     */     //   148: if_icmpge -> 172
/*     */     //   151: aload #4
/*     */     //   153: iload #9
/*     */     //   155: dup2
/*     */     //   156: faload
/*     */     //   157: aload #4
/*     */     //   159: iload #9
/*     */     //   161: iconst_1
/*     */     //   162: isub
/*     */     //   163: faload
/*     */     //   164: fmul
/*     */     //   165: fastore
/*     */     //   166: iinc #9, 1
/*     */     //   169: goto -> 145
/*     */     //   172: iconst_1
/*     */     //   173: ireturn
/*     */     //   174: iconst_0
/*     */     //   175: istore_3
/*     */     //   176: iload_3
/*     */     //   177: iload_1
/*     */     //   178: if_icmpge -> 192
/*     */     //   181: aload #4
/*     */     //   183: iload_3
/*     */     //   184: fconst_0
/*     */     //   185: fastore
/*     */     //   186: iinc #3, 1
/*     */     //   189: goto -> 176
/*     */     //   192: iconst_0
/*     */     //   193: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #359	-> 0
/*     */     //   #360	-> 5
/*     */     //   #361	-> 11
/*     */     //   #363	-> 29
/*     */     //   #365	-> 33
/*     */     //   #366	-> 38
/*     */     //   #367	-> 41
/*     */     //   #368	-> 44
/*     */     //   #369	-> 55
/*     */     //   #370	-> 67
/*     */     //   #371	-> 76
/*     */     //   #372	-> 85
/*     */     //   #373	-> 94
/*     */     //   #374	-> 104
/*     */     //   #376	-> 114
/*     */     //   #378	-> 127
/*     */     //   #379	-> 131
/*     */     //   #369	-> 135
/*     */     //   #382	-> 141
/*     */     //   #383	-> 151
/*     */     //   #382	-> 166
/*     */     //   #385	-> 172
/*     */     //   #387	-> 174
/*     */     //   #388	-> 181
/*     */     //   #387	-> 186
/*     */     //   #390	-> 192
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
/* 393 */   private static float[] b = new float[] { 1.0649863E-7F, 1.1341951E-7F, 1.2079015E-7F, 1.2863978E-7F, 1.369995E-7F, 1.459025E-7F, 1.5538409E-7F, 1.6548181E-7F, 1.7623574E-7F, 1.8768856E-7F, 1.998856E-7F, 2.128753E-7F, 2.2670913E-7F, 2.4144197E-7F, 2.5713223E-7F, 2.7384212E-7F, 2.9163792E-7F, 3.1059022E-7F, 3.307741E-7F, 3.5226967E-7F, 3.7516213E-7F, 3.995423E-7F, 4.255068E-7F, 4.5315863E-7F, 4.8260745E-7F, 5.1397E-7F, 5.4737063E-7F, 5.829419E-7F, 6.208247E-7F, 6.611694E-7F, 7.041359E-7F, 7.4989464E-7F, 7.98627E-7F, 8.505263E-7F, 9.057983E-7F, 9.646621E-7F, 1.0273513E-6F, 1.0941144E-6F, 1.1652161E-6F, 1.2409384E-6F, 1.3215816E-6F, 1.4074654E-6F, 1.4989305E-6F, 1.5963394E-6F, 1.7000785E-6F, 1.8105592E-6F, 1.9282195E-6F, 2.053526E-6F, 2.1869757E-6F, 2.3290977E-6F, 2.4804558E-6F, 2.6416496E-6F, 2.813319E-6F, 2.9961443E-6F, 3.1908505E-6F, 3.39821E-6F, 3.619045E-6F, 3.8542307E-6F, 4.1047006E-6F, 4.371447E-6F, 4.6555283E-6F, 4.958071E-6F, 5.280274E-6F, 5.623416E-6F, 5.988857E-6F, 6.3780467E-6F, 6.7925284E-6F, 7.2339453E-6F, 7.704048E-6F, 8.2047E-6F, 8.737888E-6F, 9.305725E-6F, 9.910464E-6F, 1.0554501E-5F, 1.1240392E-5F, 1.1970856E-5F, 1.2748789E-5F, 1.3577278E-5F, 1.4459606E-5F, 1.5399271E-5F, 1.6400005E-5F, 1.7465769E-5F, 1.8600793E-5F, 1.9809577E-5F, 2.1096914E-5F, 2.2467912E-5F, 2.3928002E-5F, 2.5482977E-5F, 2.7139005E-5F, 2.890265E-5F, 3.078091E-5F, 3.2781227E-5F, 3.4911533E-5F, 3.718028E-5F, 3.9596467E-5F, 4.2169668E-5F, 4.491009E-5F, 4.7828602E-5F, 5.0936775E-5F, 5.424693E-5F, 5.7772202E-5F, 6.152657E-5F, 6.552491E-5F, 6.9783084E-5F, 7.4317984E-5F, 7.914758E-5F, 8.429104E-5F, 8.976875E-5F, 9.560242E-5F, 1.0181521E-4F, 1.0843174E-4F, 1.1547824E-4F, 1.2298267E-4F, 1.3097477E-4F, 1.3948625E-4F, 1.4855085E-4F, 1.5820454E-4F, 1.6848555E-4F, 1.7943469E-4F, 1.9109536E-4F, 2.0351382E-4F, 2.167393E-4F, 2.3082423E-4F, 2.4582449E-4F, 2.6179955E-4F, 2.7881275E-4F, 2.9693157E-4F, 3.1622787E-4F, 3.3677815E-4F, 3.5866388E-4F, 3.8197188E-4F, 4.0679457E-4F, 4.3323037E-4F, 4.613841E-4F, 4.913675E-4F, 5.2329927E-4F, 5.573062E-4F, 5.935231E-4F, 6.320936E-4F, 6.731706E-4F, 7.16917E-4F, 7.635063E-4F, 8.1312325E-4F, 8.6596457E-4F, 9.2223985E-4F, 9.821722E-4F, 0.0010459992F, 0.0011139743F, 0.0011863665F, 0.0012634633F, 0.0013455702F, 0.0014330129F, 0.0015261382F, 0.0016253153F, 0.0017309374F, 0.0018434235F, 0.0019632196F, 0.0020908006F, 0.0022266726F, 0.0023713743F, 0.0025254795F, 0.0026895993F, 0.0028643848F, 0.0030505287F, 0.003248769F, 0.0034598925F, 0.0036847359F, 0.0039241905F, 0.0041792067F, 0.004450795F, 0.004740033F, 0.005048067F, 0.0053761187F, 0.005725489F, 0.0060975635F, 0.0064938175F, 0.0069158226F, 0.0073652514F, 0.007843887F, 0.008353627F, 0.008896492F, 0.009474637F, 0.010090352F, 0.01074608F, 0.011444421F, 0.012188144F, 0.012980198F, 0.013823725F, 0.014722068F, 0.015678791F, 0.016697686F, 0.017782796F, 0.018938422F, 0.020169148F, 0.021479854F, 0.022875736F, 0.02436233F, 0.025945531F, 0.027631618F, 0.029427277F, 0.031339627F, 0.03337625F, 0.035545226F, 0.037855156F, 0.0403152F, 0.042935107F, 0.045725275F, 0.048696756F, 0.05186135F, 0.05523159F, 0.05882085F, 0.062643364F, 0.06671428F, 0.07104975F, 0.075666964F, 0.08058423F, 0.08582105F, 0.09139818F, 0.097337745F, 0.1036633F, 0.11039993F, 0.11757434F, 0.12521498F, 0.13335215F, 0.14201812F, 0.15124726F, 0.16107617F, 0.1715438F, 0.18269168F, 0.19456401F, 0.20720787F, 0.22067343F, 0.23501402F, 0.25028655F, 0.26655158F, 0.28387362F, 0.3023213F, 0.32196787F, 0.34289113F, 0.36517414F, 0.3889052F, 0.41417846F, 0.44109413F, 0.4697589F, 0.50028646F, 0.53279793F, 0.5674221F, 0.6042964F, 0.64356697F, 0.6853896F, 0.72993004F, 0.777365F, 0.8278826F, 0.88168305F, 0.9389798F, 1.0F };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float[] paramArrayOffloat) {
/* 456 */     paramInt4 -= paramInt3;
/* 457 */     int i = paramInt2 - paramInt1;
/* 458 */     int j = Math.abs(paramInt4);
/* 459 */     int k = paramInt4 / i;
/* 460 */     paramInt4 = (paramInt4 < 0) ? (k - 1) : (k + 1);
/* 461 */     paramInt1 = paramInt1;
/* 462 */     paramInt3 = paramInt3;
/* 463 */     int m = 0;
/*     */     
/* 465 */     j -= Math.abs(k * i);
/*     */     
/* 467 */     paramArrayOffloat[paramInt1] = paramArrayOffloat[paramInt1] * b[paramInt3];
/* 468 */     while (++paramInt1 < paramInt2) {
/*     */       
/* 470 */       if ((m = m + j) >= i) {
/* 471 */         m -= i;
/* 472 */         paramInt3 += paramInt4;
/*     */       } else {
/*     */         
/* 475 */         paramInt3 += k;
/*     */       } 
/* 477 */       paramArrayOffloat[paramInt1] = paramArrayOffloat[paramInt1] * b[paramInt3];
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   class a
/*     */   {
/*     */     int a;
/*     */     
/* 487 */     int[] b = new int[31];
/*     */     
/* 489 */     int[] c = new int[16];
/* 490 */     int[] d = new int[16];
/* 491 */     int[] e = new int[16];
/* 492 */     int[][] f = new int[16][];
/*     */     
/*     */     int g;
/* 495 */     int[] h = new int[65];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     a(g this$0) {
/* 512 */       for (byte b = 0; b < this.f.length; b++) {
/* 513 */         this.f[b] = new int[8];
/*     */       }
/*     */     }
/*     */     
/*     */     final void a() {
/* 518 */       this.b = null;
/* 519 */       this.c = null;
/* 520 */       this.d = null;
/* 521 */       this.e = null;
/* 522 */       this.f = (int[][])null;
/* 523 */       this.h = null;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   class b
/*     */   {
/* 565 */     int[] a = new int[65];
/* 566 */     int[] b = new int[65];
/* 567 */     int[] c = new int[65];
/* 568 */     int[] d = new int[63];
/* 569 */     int[] e = new int[63];
/*     */     int f;
/*     */     int g;
/*     */     int h;
/*     */     g.a i;
/*     */     
/*     */     b(g this$0) {}
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\c\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */