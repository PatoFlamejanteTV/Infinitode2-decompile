/*     */ package org.a.c.h.a.b;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import javax.imageio.stream.MemoryCacheImageInputStream;
/*     */ import org.a.a.a.c;
/*     */ import org.a.c.b.i;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.h.a.g;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class b
/*     */   extends a
/*     */ {
/*  44 */   private static final org.a.a.a.a a = c.a(b.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  51 */   private org.a.c.b.a b = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  57 */   private org.a.c.b.a c = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  62 */   private org.a.c.b.a d = null;
/*     */ 
/*     */ 
/*     */   
/*  66 */   private int[][] e = (int[][])null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public b(org.a.c.b.b paramb) {
/*  75 */     super(paramb);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int a() {
/*  84 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private org.a.c.b.a h() {
/*  95 */     if (this.d == null)
/*     */     {
/*  97 */       this.d = (org.a.c.b.a)b().a(j.dr);
/*     */     }
/*  99 */     return this.d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int[][] i() {
/* 109 */     if (this.e == null) {
/*     */       
/* 111 */       int i = 1;
/* 112 */       int j = e();
/* 113 */       int k = d();
/* 114 */       org.a.c.b.a a1 = h(); int m;
/* 115 */       for (m = 0; m < j; m++)
/*     */       {
/* 117 */         i *= a1.c(m);
/*     */       }
/* 119 */       this.e = new int[i][k];
/* 120 */       m = j();
/* 121 */       j = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 127 */         MemoryCacheImageInputStream memoryCacheImageInputStream = new MemoryCacheImageInputStream((InputStream)c().c());
/* 128 */         for (byte b1 = 0; b1 < i; b1++) {
/*     */           
/* 130 */           for (byte b2 = 0; b2 < k; b2++)
/*     */           {
/*     */             
/* 133 */             this.e[j][b2] = (int)memoryCacheImageInputStream.readBits(m);
/*     */           }
/* 135 */           j++;
/*     */         } 
/* 137 */         memoryCacheImageInputStream.close();
/*     */       }
/* 139 */       catch (IOException iOException) {}
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 144 */     return this.e;
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
/*     */   private int j() {
/* 156 */     return b().j(j.A);
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
/*     */   private org.a.c.b.a k() {
/* 189 */     if (this.b == null) {
/*     */       
/* 191 */       this.b = (org.a.c.b.a)b().a(j.aP);
/*     */       
/* 193 */       if (this.b == null) {
/*     */         
/* 195 */         this.b = new org.a.c.b.a();
/*     */         org.a.c.b.a a1;
/* 197 */         int i = (a1 = h()).b();
/* 198 */         for (byte b1 = 0; b1 < i; b1++) {
/*     */           
/* 200 */           this.b.a((org.a.c.b.b)i.a);
/* 201 */           this.b.a((org.a.c.b.b)i.a((a1.c(b1) - 1)));
/*     */         } 
/*     */       } 
/*     */     } 
/* 205 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private org.a.c.b.a l() {
/* 215 */     if (this.c == null) {
/*     */       
/* 217 */       this.c = (org.a.c.b.a)b().a(j.aq);
/*     */       
/* 219 */       if (this.c == null)
/*     */       {
/* 221 */         this.c = g();
/*     */       }
/*     */     } 
/* 224 */     return this.c;
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
/*     */   private g c(int paramInt) {
/* 236 */     g g = null;
/*     */     org.a.c.b.a a1;
/* 238 */     if ((a1 = k()) != null && a1.b() >= (paramInt << 1) + 1)
/*     */     {
/* 240 */       g = new g(a1, paramInt);
/*     */     }
/* 242 */     return g;
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
/*     */   private g d(int paramInt) {
/* 265 */     g g = null;
/*     */     org.a.c.b.a a1;
/* 267 */     if ((a1 = l()) != null && a1.b() >= (paramInt << 1) + 1)
/*     */     {
/* 269 */       g = new g(a1, paramInt);
/*     */     }
/* 271 */     return g;
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
/*     */   private int a(int[] paramArrayOfint) {
/* 296 */     float[] arrayOfFloat = h().d();
/* 297 */     int i = 0;
/* 298 */     int j = 1;
/*     */     int k, m;
/* 300 */     for (m = (k = paramArrayOfint.length) - 2; m >= 0; m--)
/*     */     {
/* 302 */       j = (int)(j * arrayOfFloat[m]);
/*     */     }
/* 304 */     for (m = k - 1; m >= 0; m--) {
/*     */       
/* 306 */       i += j * paramArrayOfint[m];
/* 307 */       if (m - 1 >= 0)
/*     */       {
/* 309 */         j = (int)(j / arrayOfFloat[m - 1]);
/*     */       }
/*     */     } 
/* 312 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class a
/*     */   {
/*     */     private final float[] a;
/*     */ 
/*     */ 
/*     */     
/*     */     private final int[] b;
/*     */ 
/*     */ 
/*     */     
/*     */     private final int[] c;
/*     */ 
/*     */     
/*     */     private final int d;
/*     */ 
/*     */     
/* 334 */     private final int e = this.f.d();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     a(b this$0, float[] param1ArrayOffloat, int[] param1ArrayOfint1, int[] param1ArrayOfint2) {
/* 346 */       this.a = param1ArrayOffloat;
/* 347 */       this.b = param1ArrayOfint1;
/* 348 */       this.c = param1ArrayOfint2;
/* 349 */       this.d = param1ArrayOffloat.length;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     final float[] a() {
/* 359 */       return a(new int[this.d], 0);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private float[] a(int[] param1ArrayOfint, int param1Int) {
/*     */       // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: getfield e : I
/*     */       //   4: newarray float
/*     */       //   6: astore_3
/*     */       //   7: iload_2
/*     */       //   8: aload_0
/*     */       //   9: getfield a : [F
/*     */       //   12: arraylength
/*     */       //   13: iconst_1
/*     */       //   14: isub
/*     */       //   15: if_icmpne -> 197
/*     */       //   18: aload_0
/*     */       //   19: getfield b : [I
/*     */       //   22: iload_2
/*     */       //   23: iaload
/*     */       //   24: aload_0
/*     */       //   25: getfield c : [I
/*     */       //   28: iload_2
/*     */       //   29: iaload
/*     */       //   30: if_icmpne -> 86
/*     */       //   33: aload_1
/*     */       //   34: iload_2
/*     */       //   35: aload_0
/*     */       //   36: getfield b : [I
/*     */       //   39: iload_2
/*     */       //   40: iaload
/*     */       //   41: iastore
/*     */       //   42: aload_0
/*     */       //   43: getfield f : Lorg/a/c/h/a/b/b;
/*     */       //   46: invokestatic a : (Lorg/a/c/h/a/b/b;)[[I
/*     */       //   49: aload_0
/*     */       //   50: getfield f : Lorg/a/c/h/a/b/b;
/*     */       //   53: aload_1
/*     */       //   54: invokestatic a : (Lorg/a/c/h/a/b/b;[I)I
/*     */       //   57: aaload
/*     */       //   58: astore #4
/*     */       //   60: iconst_0
/*     */       //   61: istore_1
/*     */       //   62: iload_1
/*     */       //   63: aload_0
/*     */       //   64: getfield e : I
/*     */       //   67: if_icmpge -> 84
/*     */       //   70: aload_3
/*     */       //   71: iload_1
/*     */       //   72: aload #4
/*     */       //   74: iload_1
/*     */       //   75: iaload
/*     */       //   76: i2f
/*     */       //   77: fastore
/*     */       //   78: iinc #1, 1
/*     */       //   81: goto -> 62
/*     */       //   84: aload_3
/*     */       //   85: areturn
/*     */       //   86: aload_1
/*     */       //   87: iload_2
/*     */       //   88: aload_0
/*     */       //   89: getfield b : [I
/*     */       //   92: iload_2
/*     */       //   93: iaload
/*     */       //   94: iastore
/*     */       //   95: aload_0
/*     */       //   96: getfield f : Lorg/a/c/h/a/b/b;
/*     */       //   99: invokestatic a : (Lorg/a/c/h/a/b/b;)[[I
/*     */       //   102: aload_0
/*     */       //   103: getfield f : Lorg/a/c/h/a/b/b;
/*     */       //   106: aload_1
/*     */       //   107: invokestatic a : (Lorg/a/c/h/a/b/b;[I)I
/*     */       //   110: aaload
/*     */       //   111: astore #4
/*     */       //   113: aload_1
/*     */       //   114: iload_2
/*     */       //   115: aload_0
/*     */       //   116: getfield c : [I
/*     */       //   119: iload_2
/*     */       //   120: iaload
/*     */       //   121: iastore
/*     */       //   122: aload_0
/*     */       //   123: getfield f : Lorg/a/c/h/a/b/b;
/*     */       //   126: invokestatic a : (Lorg/a/c/h/a/b/b;)[[I
/*     */       //   129: aload_0
/*     */       //   130: getfield f : Lorg/a/c/h/a/b/b;
/*     */       //   133: aload_1
/*     */       //   134: invokestatic a : (Lorg/a/c/h/a/b/b;[I)I
/*     */       //   137: aaload
/*     */       //   138: astore_1
/*     */       //   139: iconst_0
/*     */       //   140: istore #5
/*     */       //   142: iload #5
/*     */       //   144: aload_0
/*     */       //   145: getfield e : I
/*     */       //   148: if_icmpge -> 195
/*     */       //   151: aload_3
/*     */       //   152: iload #5
/*     */       //   154: aload_0
/*     */       //   155: getfield a : [F
/*     */       //   158: iload_2
/*     */       //   159: faload
/*     */       //   160: aload_0
/*     */       //   161: getfield b : [I
/*     */       //   164: iload_2
/*     */       //   165: iaload
/*     */       //   166: i2f
/*     */       //   167: aload_0
/*     */       //   168: getfield c : [I
/*     */       //   171: iload_2
/*     */       //   172: iaload
/*     */       //   173: i2f
/*     */       //   174: aload #4
/*     */       //   176: iload #5
/*     */       //   178: iaload
/*     */       //   179: i2f
/*     */       //   180: aload_1
/*     */       //   181: iload #5
/*     */       //   183: iaload
/*     */       //   184: i2f
/*     */       //   185: invokestatic a : (FFFFF)F
/*     */       //   188: fastore
/*     */       //   189: iinc #5, 1
/*     */       //   192: goto -> 142
/*     */       //   195: aload_3
/*     */       //   196: areturn
/*     */       //   197: aload_0
/*     */       //   198: getfield b : [I
/*     */       //   201: iload_2
/*     */       //   202: iaload
/*     */       //   203: aload_0
/*     */       //   204: getfield c : [I
/*     */       //   207: iload_2
/*     */       //   208: iaload
/*     */       //   209: if_icmpne -> 230
/*     */       //   212: aload_1
/*     */       //   213: iload_2
/*     */       //   214: aload_0
/*     */       //   215: getfield b : [I
/*     */       //   218: iload_2
/*     */       //   219: iaload
/*     */       //   220: iastore
/*     */       //   221: aload_0
/*     */       //   222: aload_1
/*     */       //   223: iload_2
/*     */       //   224: iconst_1
/*     */       //   225: iadd
/*     */       //   226: invokespecial a : ([II)[F
/*     */       //   229: areturn
/*     */       //   230: aload_1
/*     */       //   231: iload_2
/*     */       //   232: aload_0
/*     */       //   233: getfield b : [I
/*     */       //   236: iload_2
/*     */       //   237: iaload
/*     */       //   238: iastore
/*     */       //   239: aload_0
/*     */       //   240: aload_1
/*     */       //   241: iload_2
/*     */       //   242: iconst_1
/*     */       //   243: iadd
/*     */       //   244: invokespecial a : ([II)[F
/*     */       //   247: astore #4
/*     */       //   249: aload_1
/*     */       //   250: iload_2
/*     */       //   251: aload_0
/*     */       //   252: getfield c : [I
/*     */       //   255: iload_2
/*     */       //   256: iaload
/*     */       //   257: iastore
/*     */       //   258: aload_0
/*     */       //   259: aload_1
/*     */       //   260: iload_2
/*     */       //   261: iconst_1
/*     */       //   262: iadd
/*     */       //   263: invokespecial a : ([II)[F
/*     */       //   266: astore_1
/*     */       //   267: iconst_0
/*     */       //   268: istore #5
/*     */       //   270: iload #5
/*     */       //   272: aload_0
/*     */       //   273: getfield e : I
/*     */       //   276: if_icmpge -> 321
/*     */       //   279: aload_3
/*     */       //   280: iload #5
/*     */       //   282: aload_0
/*     */       //   283: getfield a : [F
/*     */       //   286: iload_2
/*     */       //   287: faload
/*     */       //   288: aload_0
/*     */       //   289: getfield b : [I
/*     */       //   292: iload_2
/*     */       //   293: iaload
/*     */       //   294: i2f
/*     */       //   295: aload_0
/*     */       //   296: getfield c : [I
/*     */       //   299: iload_2
/*     */       //   300: iaload
/*     */       //   301: i2f
/*     */       //   302: aload #4
/*     */       //   304: iload #5
/*     */       //   306: faload
/*     */       //   307: aload_1
/*     */       //   308: iload #5
/*     */       //   310: faload
/*     */       //   311: invokestatic a : (FFFFF)F
/*     */       //   314: fastore
/*     */       //   315: iinc #5, 1
/*     */       //   318: goto -> 270
/*     */       //   321: aload_3
/*     */       //   322: areturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #374	-> 0
/*     */       //   #375	-> 7
/*     */       //   #378	-> 18
/*     */       //   #380	-> 33
/*     */       //   #381	-> 42
/*     */       //   #382	-> 60
/*     */       //   #384	-> 70
/*     */       //   #382	-> 78
/*     */       //   #386	-> 84
/*     */       //   #388	-> 86
/*     */       //   #389	-> 95
/*     */       //   #390	-> 113
/*     */       //   #391	-> 122
/*     */       //   #392	-> 139
/*     */       //   #394	-> 151
/*     */       //   #392	-> 189
/*     */       //   #396	-> 195
/*     */       //   #401	-> 197
/*     */       //   #403	-> 212
/*     */       //   #404	-> 221
/*     */       //   #406	-> 230
/*     */       //   #407	-> 239
/*     */       //   #408	-> 249
/*     */       //   #409	-> 258
/*     */       //   #410	-> 267
/*     */       //   #412	-> 279
/*     */       //   #410	-> 315
/*     */       //   #414	-> 321
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
/*     */   public final float[] a(float[] paramArrayOffloat) {
/* 428 */     float[] arrayOfFloat1 = h().d();
/* 429 */     int i = j();
/* 430 */     float f = (float)(Math.pow(2.0D, i) - 1.0D);
/* 431 */     int j = paramArrayOffloat.length;
/* 432 */     int k = d();
/*     */     
/* 434 */     int[] arrayOfInt1 = new int[j];
/* 435 */     int[] arrayOfInt2 = new int[j];
/* 436 */     paramArrayOffloat = (float[])paramArrayOffloat.clone();
/*     */     
/* 438 */     for (byte b1 = 0; b1 < j; b1++) {
/*     */       
/* 440 */       g g1 = b(b1);
/* 441 */       g g2 = c(b1);
/* 442 */       paramArrayOffloat[b1] = a(paramArrayOffloat[b1], g1.a(), g1.b());
/* 443 */       paramArrayOffloat[b1] = a(paramArrayOffloat[b1], g1.a(), g1.b(), g2
/* 444 */           .a(), g2.b());
/* 445 */       paramArrayOffloat[b1] = a(paramArrayOffloat[b1], 0.0F, arrayOfFloat1[b1] - 1.0F);
/* 446 */       arrayOfInt1[b1] = (int)Math.floor(paramArrayOffloat[b1]);
/* 447 */       arrayOfInt2[b1] = (int)Math.ceil(paramArrayOffloat[b1]);
/*     */     } 
/*     */     
/* 450 */     float[] arrayOfFloat2 = (new a(this, paramArrayOffloat, arrayOfInt1, arrayOfInt2)).a();
/*     */     
/* 452 */     for (byte b2 = 0; b2 < k; b2++) {
/*     */       
/* 454 */       g g2 = a(b2);
/* 455 */       g g1 = d(b2);
/* 456 */       arrayOfFloat2[b2] = a(arrayOfFloat2[b2], 0.0F, f, g1.a(), g1.b());
/* 457 */       arrayOfFloat2[b2] = a(arrayOfFloat2[b2], g2.a(), g2.b());
/*     */     } 
/*     */     
/* 460 */     return arrayOfFloat2;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\a\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */