/*      */ package com.a.a.b.d;
/*      */ 
/*      */ import com.a.a.b.a;
/*      */ import com.a.a.b.a.b;
/*      */ import com.a.a.b.c.a;
/*      */ import com.a.a.b.c.b;
/*      */ import com.a.a.b.e.a;
/*      */ import com.a.a.b.g.c;
/*      */ import com.a.a.b.g.i;
/*      */ import com.a.a.b.j;
/*      */ import com.a.a.b.l;
/*      */ import com.a.a.b.o;
/*      */ import com.a.a.b.p;
/*      */ import com.a.a.b.s;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.OutputStream;
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class h
/*      */   extends b
/*      */ {
/*   24 */   private static final int E = l.a.n.c();
/*      */   
/*   26 */   private static final int F = l.a.h.c();
/*      */   
/*   28 */   private static final int G = l.a.l.c();
/*      */   
/*   30 */   private static final int H = l.a.m.c();
/*   31 */   private static final int I = l.a.e.c();
/*   32 */   private static final int J = l.a.d.c();
/*   33 */   private static final int K = l.a.b.c();
/*   34 */   private static final int L = l.a.c.c();
/*      */ 
/*      */   
/*   37 */   private static final int[] M = b.b();
/*      */ 
/*      */ 
/*      */   
/*   41 */   private static int[] N = b.a();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private p O;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private a P;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   70 */   private int[] Q = new int[16];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean R;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int S;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int T;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int U;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int V;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private InputStream W;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private byte[] X;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean Y;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public h(a parama, int paramInt1, InputStream paramInputStream, p paramp, a parama1, byte[] paramArrayOfbyte, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean) {
/*  190 */     super(parama, paramInt1);
/*  191 */     this.W = paramInputStream;
/*  192 */     this.O = paramp;
/*  193 */     this.P = parama1;
/*  194 */     this.X = paramArrayOfbyte;
/*  195 */     this.e = paramInt2;
/*  196 */     this.f = paramInt3;
/*  197 */     this.i = paramInt2 - paramInt4;
/*      */     
/*  199 */     this.g = (-paramInt2 + paramInt4);
/*  200 */     this.Y = paramBoolean;
/*      */   }
/*      */ 
/*      */   
/*      */   public final p a() {
/*  205 */     return this.O;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final i<s> c() {
/*  215 */     return c;
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
/*      */   private boolean am() {
/*  251 */     if (this.W != null) {
/*      */       int i;
/*  253 */       if ((i = this.X.length) == 0) {
/*  254 */         return false;
/*      */       }
/*      */ 
/*      */       
/*  258 */       if ((i = this.W.read(this.X, 0, i)) > 0) {
/*  259 */         int j = this.f;
/*      */         
/*  261 */         this.g += j;
/*  262 */         this.i -= j;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  267 */         this.T -= j;
/*      */         
/*  269 */         this.e = 0;
/*  270 */         this.f = i;
/*      */         
/*  272 */         return true;
/*      */       } 
/*      */       
/*  275 */       W();
/*      */       
/*  277 */       if (i == 0) {
/*  278 */         throw new IOException("InputStream.read() returned 0 characters when trying to read " + this.X.length + " bytes");
/*      */       }
/*      */     } 
/*  281 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final void W() {
/*  289 */     if (this.W != null) {
/*  290 */       if (this.d.b() || a(l.a.a)) {
/*  291 */         this.W.close();
/*      */       }
/*  293 */       this.W = null;
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
/*      */   protected final void X() {
/*  306 */     super.X();
/*      */     
/*  308 */     this.P.b(); byte[] arrayOfByte;
/*  309 */     if (this.Y && (
/*      */       
/*  311 */       arrayOfByte = this.X) != null)
/*      */     {
/*      */       
/*  314 */       if (arrayOfByte != u) {
/*  315 */         this.X = u;
/*  316 */         this.d.a(arrayOfByte);
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
/*      */   public final String w() {
/*  331 */     if (this.D == o.h) {
/*  332 */       if (this.R) {
/*  333 */         this.R = false;
/*  334 */         return as();
/*      */       } 
/*  336 */       return this.o.e();
/*      */     } 
/*  338 */     return c(this.D);
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
/*      */   public final String R() {
/*  374 */     if (this.D == o.h) {
/*  375 */       if (this.R) {
/*  376 */         this.R = false;
/*  377 */         return as();
/*      */       } 
/*  379 */       return this.o.e();
/*      */     } 
/*  381 */     if (this.D == o.f) {
/*  382 */       return u();
/*      */     }
/*  384 */     return super.a(null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final String a(String paramString) {
/*  391 */     if (this.D == o.h) {
/*  392 */       if (this.R) {
/*  393 */         this.R = false;
/*  394 */         return as();
/*      */       } 
/*  396 */       return this.o.e();
/*      */     } 
/*  398 */     if (this.D == o.f) {
/*  399 */       return u();
/*      */     }
/*  401 */     return super.a(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int P() {
/*      */     o o;
/*  409 */     if ((o = this.D) == o.i || o == o.j) {
/*      */       
/*  411 */       if ((this.s & 0x1) == 0) {
/*  412 */         if (this.s == 0) {
/*  413 */           return ab();
/*      */         }
/*  415 */         if ((this.s & 0x1) == 0) {
/*  416 */           ac();
/*      */         }
/*      */       } 
/*  419 */       return this.t;
/*      */     } 
/*  421 */     return super.d(0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int d(int paramInt) {
/*      */     o o;
/*  429 */     if ((o = this.D) == o.i || o == o.j) {
/*      */       
/*  431 */       if ((this.s & 0x1) == 0) {
/*  432 */         if (this.s == 0) {
/*  433 */           return ab();
/*      */         }
/*  435 */         if ((this.s & 0x1) == 0) {
/*  436 */           ac();
/*      */         }
/*      */       } 
/*  439 */       return this.t;
/*      */     } 
/*  441 */     return super.d(paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   private String c(o paramo) {
/*  446 */     if (paramo == null) {
/*  447 */       return null;
/*      */     }
/*  449 */     switch (paramo.a()) {
/*      */       case 5:
/*  451 */         return this.m.g();
/*      */ 
/*      */       
/*      */       case 6:
/*      */       case 7:
/*      */       case 8:
/*  457 */         return this.o.e();
/*      */     } 
/*  459 */     return paramo.b();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final char[] x() {
/*  466 */     if (this.D != null) {
/*  467 */       switch (this.D.a()) {
/*      */         
/*      */         case 5:
/*  470 */           if (!this.q) {
/*      */             String str;
/*  472 */             int i = (str = this.m.g()).length();
/*  473 */             if (this.p == null) {
/*  474 */               this.p = this.d.a(i);
/*  475 */             } else if (this.p.length < i) {
/*  476 */               this.p = new char[i];
/*      */             } 
/*  478 */             str.getChars(0, i, this.p, 0);
/*  479 */             this.q = true;
/*      */           } 
/*  481 */           return this.p;
/*      */         
/*      */         case 6:
/*  484 */           if (this.R) {
/*  485 */             this.R = false;
/*  486 */             ah();
/*      */           } 
/*      */         
/*      */         case 7:
/*      */         case 8:
/*  491 */           return this.o.d();
/*      */       } 
/*      */       
/*  494 */       return this.D.c();
/*      */     } 
/*      */     
/*  497 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final int y() {
/*  503 */     if (this.D != null) {
/*  504 */       switch (this.D.a()) {
/*      */         
/*      */         case 5:
/*  507 */           return this.m.g().length();
/*      */         case 6:
/*  509 */           if (this.R) {
/*  510 */             this.R = false;
/*  511 */             ah();
/*      */           } 
/*      */         
/*      */         case 7:
/*      */         case 8:
/*  516 */           return this.o.b();
/*      */       } 
/*      */       
/*  519 */       return (this.D.c()).length;
/*      */     } 
/*      */     
/*  522 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int z() {
/*  529 */     if (this.D != null) {
/*  530 */       switch (this.D.a()) {
/*      */         case 5:
/*  532 */           return 0;
/*      */         case 6:
/*  534 */           if (this.R) {
/*  535 */             this.R = false;
/*  536 */             ah();
/*      */           } 
/*      */         
/*      */         case 7:
/*      */         case 8:
/*  541 */           return this.o.c();
/*      */       } 
/*      */     
/*      */     }
/*  545 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final byte[] a(a parama) {
/*  551 */     if (this.D != o.h && (this.D != o.g || this.r == null))
/*      */     {
/*  553 */       g("Current token (" + this.D + ") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
/*      */     }
/*      */     
/*  556 */     if (this.R) {
/*      */       try {
/*  558 */         this.r = c(parama);
/*  559 */       } catch (IllegalArgumentException illegalArgumentException) {
/*  560 */         throw b("Failed to decode VALUE_STRING as base64 (" + parama + "): " + illegalArgumentException.getMessage());
/*      */       } 
/*      */       
/*  563 */       this.R = false;
/*      */     }
/*  565 */     else if (this.r == null) {
/*      */       
/*  567 */       c c = aa();
/*  568 */       a(w(), c, parama);
/*  569 */       this.r = c.b();
/*      */     } 
/*      */     
/*  572 */     return this.r;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int a(a parama, OutputStream paramOutputStream) {
/*  579 */     if (!this.R || this.D != o.h) {
/*  580 */       byte[] arrayOfByte1 = a(parama);
/*  581 */       paramOutputStream.write(arrayOfByte1);
/*  582 */       return arrayOfByte1.length;
/*      */     } 
/*      */     
/*  585 */     byte[] arrayOfByte = this.d.f();
/*      */     try {
/*  587 */       return a(parama, paramOutputStream, arrayOfByte);
/*      */     } finally {
/*  589 */       this.d.b(arrayOfByte);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int a(a parama, OutputStream paramOutputStream, byte[] paramArrayOfbyte) {
/*      */     // Byte code:
/*      */     //   0: iconst_0
/*      */     //   1: istore #4
/*      */     //   3: aload_3
/*      */     //   4: arraylength
/*      */     //   5: iconst_3
/*      */     //   6: isub
/*      */     //   7: istore #5
/*      */     //   9: iconst_0
/*      */     //   10: istore #6
/*      */     //   12: aload_0
/*      */     //   13: getfield e : I
/*      */     //   16: aload_0
/*      */     //   17: getfield f : I
/*      */     //   20: if_icmplt -> 27
/*      */     //   23: aload_0
/*      */     //   24: invokevirtual ar : ()V
/*      */     //   27: aload_0
/*      */     //   28: getfield X : [B
/*      */     //   31: aload_0
/*      */     //   32: dup
/*      */     //   33: getfield e : I
/*      */     //   36: dup_x1
/*      */     //   37: iconst_1
/*      */     //   38: iadd
/*      */     //   39: putfield e : I
/*      */     //   42: baload
/*      */     //   43: sipush #255
/*      */     //   46: iand
/*      */     //   47: dup
/*      */     //   48: istore #7
/*      */     //   50: bipush #32
/*      */     //   52: if_icmple -> 12
/*      */     //   55: aload_1
/*      */     //   56: iload #7
/*      */     //   58: invokevirtual b : (I)I
/*      */     //   61: dup
/*      */     //   62: istore #8
/*      */     //   64: ifge -> 88
/*      */     //   67: iload #7
/*      */     //   69: bipush #34
/*      */     //   71: if_icmpeq -> 642
/*      */     //   74: aload_0
/*      */     //   75: aload_1
/*      */     //   76: iload #7
/*      */     //   78: iconst_0
/*      */     //   79: invokevirtual a : (Lcom/a/a/b/a;II)I
/*      */     //   82: dup
/*      */     //   83: istore #8
/*      */     //   85: iflt -> 12
/*      */     //   88: iload #4
/*      */     //   90: iload #5
/*      */     //   92: if_icmple -> 113
/*      */     //   95: iload #6
/*      */     //   97: iload #4
/*      */     //   99: iadd
/*      */     //   100: istore #6
/*      */     //   102: aload_2
/*      */     //   103: aload_3
/*      */     //   104: iconst_0
/*      */     //   105: iload #4
/*      */     //   107: invokevirtual write : ([BII)V
/*      */     //   110: iconst_0
/*      */     //   111: istore #4
/*      */     //   113: iload #8
/*      */     //   115: istore #9
/*      */     //   117: aload_0
/*      */     //   118: getfield e : I
/*      */     //   121: aload_0
/*      */     //   122: getfield f : I
/*      */     //   125: if_icmplt -> 132
/*      */     //   128: aload_0
/*      */     //   129: invokevirtual ar : ()V
/*      */     //   132: aload_0
/*      */     //   133: getfield X : [B
/*      */     //   136: aload_0
/*      */     //   137: dup
/*      */     //   138: getfield e : I
/*      */     //   141: dup_x1
/*      */     //   142: iconst_1
/*      */     //   143: iadd
/*      */     //   144: putfield e : I
/*      */     //   147: baload
/*      */     //   148: sipush #255
/*      */     //   151: iand
/*      */     //   152: istore #7
/*      */     //   154: aload_1
/*      */     //   155: iload #7
/*      */     //   157: invokevirtual b : (I)I
/*      */     //   160: dup
/*      */     //   161: istore #8
/*      */     //   163: ifge -> 176
/*      */     //   166: aload_0
/*      */     //   167: aload_1
/*      */     //   168: iload #7
/*      */     //   170: iconst_1
/*      */     //   171: invokevirtual a : (Lcom/a/a/b/a;II)I
/*      */     //   174: istore #8
/*      */     //   176: iload #9
/*      */     //   178: bipush #6
/*      */     //   180: ishl
/*      */     //   181: iload #8
/*      */     //   183: ior
/*      */     //   184: istore #9
/*      */     //   186: aload_0
/*      */     //   187: getfield e : I
/*      */     //   190: aload_0
/*      */     //   191: getfield f : I
/*      */     //   194: if_icmplt -> 201
/*      */     //   197: aload_0
/*      */     //   198: invokevirtual ar : ()V
/*      */     //   201: aload_0
/*      */     //   202: getfield X : [B
/*      */     //   205: aload_0
/*      */     //   206: dup
/*      */     //   207: getfield e : I
/*      */     //   210: dup_x1
/*      */     //   211: iconst_1
/*      */     //   212: iadd
/*      */     //   213: putfield e : I
/*      */     //   216: baload
/*      */     //   217: sipush #255
/*      */     //   220: iand
/*      */     //   221: istore #7
/*      */     //   223: aload_1
/*      */     //   224: iload #7
/*      */     //   226: invokevirtual b : (I)I
/*      */     //   229: dup
/*      */     //   230: istore #8
/*      */     //   232: ifge -> 417
/*      */     //   235: iload #8
/*      */     //   237: bipush #-2
/*      */     //   239: if_icmpeq -> 300
/*      */     //   242: iload #7
/*      */     //   244: bipush #34
/*      */     //   246: if_icmpne -> 290
/*      */     //   249: iload #9
/*      */     //   251: iconst_4
/*      */     //   252: ishr
/*      */     //   253: istore #9
/*      */     //   255: aload_3
/*      */     //   256: iload #4
/*      */     //   258: iinc #4, 1
/*      */     //   261: iload #9
/*      */     //   263: i2b
/*      */     //   264: bastore
/*      */     //   265: aload_1
/*      */     //   266: invokevirtual a : ()Z
/*      */     //   269: ifeq -> 642
/*      */     //   272: aload_0
/*      */     //   273: dup
/*      */     //   274: getfield e : I
/*      */     //   277: iconst_1
/*      */     //   278: isub
/*      */     //   279: putfield e : I
/*      */     //   282: aload_0
/*      */     //   283: aload_1
/*      */     //   284: invokevirtual b : (Lcom/a/a/b/a;)V
/*      */     //   287: goto -> 642
/*      */     //   290: aload_0
/*      */     //   291: aload_1
/*      */     //   292: iload #7
/*      */     //   294: iconst_2
/*      */     //   295: invokevirtual a : (Lcom/a/a/b/a;II)I
/*      */     //   298: istore #8
/*      */     //   300: iload #8
/*      */     //   302: bipush #-2
/*      */     //   304: if_icmpne -> 417
/*      */     //   307: aload_0
/*      */     //   308: getfield e : I
/*      */     //   311: aload_0
/*      */     //   312: getfield f : I
/*      */     //   315: if_icmplt -> 322
/*      */     //   318: aload_0
/*      */     //   319: invokevirtual ar : ()V
/*      */     //   322: aload_0
/*      */     //   323: getfield X : [B
/*      */     //   326: aload_0
/*      */     //   327: dup
/*      */     //   328: getfield e : I
/*      */     //   331: dup_x1
/*      */     //   332: iconst_1
/*      */     //   333: iadd
/*      */     //   334: putfield e : I
/*      */     //   337: baload
/*      */     //   338: sipush #255
/*      */     //   341: iand
/*      */     //   342: istore #7
/*      */     //   344: aload_1
/*      */     //   345: iload #7
/*      */     //   347: invokevirtual a : (I)Z
/*      */     //   350: ifne -> 398
/*      */     //   353: aload_0
/*      */     //   354: aload_1
/*      */     //   355: iload #7
/*      */     //   357: iconst_3
/*      */     //   358: invokevirtual a : (Lcom/a/a/b/a;II)I
/*      */     //   361: bipush #-2
/*      */     //   363: if_icmpeq -> 398
/*      */     //   366: aload_1
/*      */     //   367: iload #7
/*      */     //   369: iconst_3
/*      */     //   370: new java/lang/StringBuilder
/*      */     //   373: dup
/*      */     //   374: ldc 'expected padding character ''
/*      */     //   376: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   379: aload_1
/*      */     //   380: invokevirtual b : ()C
/*      */     //   383: invokevirtual append : (C)Ljava/lang/StringBuilder;
/*      */     //   386: ldc '''
/*      */     //   388: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   391: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   394: invokestatic a : (Lcom/a/a/b/a;IILjava/lang/String;)Ljava/lang/IllegalArgumentException;
/*      */     //   397: athrow
/*      */     //   398: iload #9
/*      */     //   400: iconst_4
/*      */     //   401: ishr
/*      */     //   402: istore #9
/*      */     //   404: aload_3
/*      */     //   405: iload #4
/*      */     //   407: iinc #4, 1
/*      */     //   410: iload #9
/*      */     //   412: i2b
/*      */     //   413: bastore
/*      */     //   414: goto -> 12
/*      */     //   417: iload #9
/*      */     //   419: bipush #6
/*      */     //   421: ishl
/*      */     //   422: iload #8
/*      */     //   424: ior
/*      */     //   425: istore #9
/*      */     //   427: aload_0
/*      */     //   428: getfield e : I
/*      */     //   431: aload_0
/*      */     //   432: getfield f : I
/*      */     //   435: if_icmplt -> 442
/*      */     //   438: aload_0
/*      */     //   439: invokevirtual ar : ()V
/*      */     //   442: aload_0
/*      */     //   443: getfield X : [B
/*      */     //   446: aload_0
/*      */     //   447: dup
/*      */     //   448: getfield e : I
/*      */     //   451: dup_x1
/*      */     //   452: iconst_1
/*      */     //   453: iadd
/*      */     //   454: putfield e : I
/*      */     //   457: baload
/*      */     //   458: sipush #255
/*      */     //   461: iand
/*      */     //   462: istore #7
/*      */     //   464: aload_1
/*      */     //   465: iload #7
/*      */     //   467: invokevirtual b : (I)I
/*      */     //   470: dup
/*      */     //   471: istore #8
/*      */     //   473: ifge -> 593
/*      */     //   476: iload #8
/*      */     //   478: bipush #-2
/*      */     //   480: if_icmpeq -> 554
/*      */     //   483: iload #7
/*      */     //   485: bipush #34
/*      */     //   487: if_icmpne -> 544
/*      */     //   490: iload #9
/*      */     //   492: iconst_2
/*      */     //   493: ishr
/*      */     //   494: istore #9
/*      */     //   496: aload_3
/*      */     //   497: iload #4
/*      */     //   499: iinc #4, 1
/*      */     //   502: iload #9
/*      */     //   504: bipush #8
/*      */     //   506: ishr
/*      */     //   507: i2b
/*      */     //   508: bastore
/*      */     //   509: aload_3
/*      */     //   510: iload #4
/*      */     //   512: iinc #4, 1
/*      */     //   515: iload #9
/*      */     //   517: i2b
/*      */     //   518: bastore
/*      */     //   519: aload_1
/*      */     //   520: invokevirtual a : ()Z
/*      */     //   523: ifeq -> 642
/*      */     //   526: aload_0
/*      */     //   527: dup
/*      */     //   528: getfield e : I
/*      */     //   531: iconst_1
/*      */     //   532: isub
/*      */     //   533: putfield e : I
/*      */     //   536: aload_0
/*      */     //   537: aload_1
/*      */     //   538: invokevirtual b : (Lcom/a/a/b/a;)V
/*      */     //   541: goto -> 642
/*      */     //   544: aload_0
/*      */     //   545: aload_1
/*      */     //   546: iload #7
/*      */     //   548: iconst_3
/*      */     //   549: invokevirtual a : (Lcom/a/a/b/a;II)I
/*      */     //   552: istore #8
/*      */     //   554: iload #8
/*      */     //   556: bipush #-2
/*      */     //   558: if_icmpne -> 593
/*      */     //   561: iload #9
/*      */     //   563: iconst_2
/*      */     //   564: ishr
/*      */     //   565: istore #9
/*      */     //   567: aload_3
/*      */     //   568: iload #4
/*      */     //   570: iinc #4, 1
/*      */     //   573: iload #9
/*      */     //   575: bipush #8
/*      */     //   577: ishr
/*      */     //   578: i2b
/*      */     //   579: bastore
/*      */     //   580: aload_3
/*      */     //   581: iload #4
/*      */     //   583: iinc #4, 1
/*      */     //   586: iload #9
/*      */     //   588: i2b
/*      */     //   589: bastore
/*      */     //   590: goto -> 12
/*      */     //   593: iload #9
/*      */     //   595: bipush #6
/*      */     //   597: ishl
/*      */     //   598: iload #8
/*      */     //   600: ior
/*      */     //   601: istore #9
/*      */     //   603: aload_3
/*      */     //   604: iload #4
/*      */     //   606: iinc #4, 1
/*      */     //   609: iload #9
/*      */     //   611: bipush #16
/*      */     //   613: ishr
/*      */     //   614: i2b
/*      */     //   615: bastore
/*      */     //   616: aload_3
/*      */     //   617: iload #4
/*      */     //   619: iinc #4, 1
/*      */     //   622: iload #9
/*      */     //   624: bipush #8
/*      */     //   626: ishr
/*      */     //   627: i2b
/*      */     //   628: bastore
/*      */     //   629: aload_3
/*      */     //   630: iload #4
/*      */     //   632: iinc #4, 1
/*      */     //   635: iload #9
/*      */     //   637: i2b
/*      */     //   638: bastore
/*      */     //   639: goto -> 12
/*      */     //   642: aload_0
/*      */     //   643: iconst_0
/*      */     //   644: putfield R : Z
/*      */     //   647: iload #4
/*      */     //   649: ifle -> 667
/*      */     //   652: iload #6
/*      */     //   654: iload #4
/*      */     //   656: iadd
/*      */     //   657: istore #6
/*      */     //   659: aload_2
/*      */     //   660: aload_3
/*      */     //   661: iconst_0
/*      */     //   662: iload #4
/*      */     //   664: invokevirtual write : ([BII)V
/*      */     //   667: iload #6
/*      */     //   669: ireturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #596	-> 0
/*      */     //   #597	-> 3
/*      */     //   #598	-> 9
/*      */     //   #604	-> 12
/*      */     //   #605	-> 23
/*      */     //   #607	-> 27
/*      */     //   #608	-> 48
/*      */     //   #609	-> 55
/*      */     //   #610	-> 62
/*      */     //   #611	-> 67
/*      */     //   #614	-> 74
/*      */     //   #615	-> 83
/*      */     //   #621	-> 88
/*      */     //   #622	-> 95
/*      */     //   #623	-> 102
/*      */     //   #624	-> 110
/*      */     //   #627	-> 113
/*      */     //   #631	-> 117
/*      */     //   #632	-> 128
/*      */     //   #634	-> 132
/*      */     //   #635	-> 154
/*      */     //   #636	-> 161
/*      */     //   #637	-> 166
/*      */     //   #639	-> 176
/*      */     //   #642	-> 186
/*      */     //   #643	-> 197
/*      */     //   #645	-> 201
/*      */     //   #646	-> 223
/*      */     //   #649	-> 230
/*      */     //   #650	-> 235
/*      */     //   #652	-> 242
/*      */     //   #653	-> 249
/*      */     //   #654	-> 255
/*      */     //   #655	-> 265
/*      */     //   #656	-> 272
/*      */     //   #657	-> 282
/*      */     //   #661	-> 290
/*      */     //   #663	-> 300
/*      */     //   #665	-> 307
/*      */     //   #666	-> 318
/*      */     //   #668	-> 322
/*      */     //   #669	-> 344
/*      */     //   #670	-> 353
/*      */     //   #671	-> 366
/*      */     //   #675	-> 398
/*      */     //   #676	-> 404
/*      */     //   #677	-> 414
/*      */     //   #681	-> 417
/*      */     //   #683	-> 427
/*      */     //   #684	-> 438
/*      */     //   #686	-> 442
/*      */     //   #687	-> 464
/*      */     //   #688	-> 471
/*      */     //   #689	-> 476
/*      */     //   #691	-> 483
/*      */     //   #692	-> 490
/*      */     //   #693	-> 496
/*      */     //   #694	-> 509
/*      */     //   #695	-> 519
/*      */     //   #696	-> 526
/*      */     //   #697	-> 536
/*      */     //   #701	-> 544
/*      */     //   #703	-> 554
/*      */     //   #710	-> 561
/*      */     //   #711	-> 567
/*      */     //   #712	-> 580
/*      */     //   #713	-> 590
/*      */     //   #717	-> 593
/*      */     //   #718	-> 603
/*      */     //   #719	-> 616
/*      */     //   #720	-> 629
/*      */     //   #721	-> 639
/*      */     //   #722	-> 642
/*      */     //   #723	-> 647
/*      */     //   #724	-> 652
/*      */     //   #725	-> 659
/*      */     //   #727	-> 667
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
/*      */   public final o g() {
/*  747 */     if (this.D == o.f) {
/*  748 */       return an();
/*      */     }
/*      */ 
/*      */     
/*  752 */     this.s = 0;
/*  753 */     if (this.R) {
/*  754 */       at();
/*      */     }
/*      */     int j;
/*  757 */     if ((j = aA()) < 0) {
/*      */       
/*  759 */       close();
/*  760 */       return this.D = null;
/*      */     } 
/*      */     
/*  763 */     this.r = null;
/*      */ 
/*      */     
/*  766 */     if (j == 93) {
/*  767 */       aO();
/*  768 */       return this.D = o.e;
/*      */     } 
/*  770 */     if (j == 125) {
/*  771 */       aP();
/*  772 */       return this.D = o.c;
/*      */     } 
/*      */ 
/*      */     
/*  776 */     if (this.m.l()) {
/*  777 */       if (j != 44) {
/*  778 */         c(j, "was expecting comma to separate " + this.m.e() + " entries");
/*      */       }
/*  780 */       j = ay();
/*      */       
/*  782 */       if ((this.b & E) != 0 && (
/*  783 */         j == 93 || j == 125)) {
/*  784 */         return w(j);
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  791 */     if (!this.m.d()) {
/*  792 */       aM();
/*  793 */       return h(j);
/*      */     } 
/*      */     
/*  796 */     aN();
/*  797 */     String str = k(j);
/*  798 */     this.m.a(str);
/*  799 */     this.D = o.f;
/*      */     
/*  801 */     int i = aC();
/*  802 */     aM();
/*      */ 
/*      */     
/*  805 */     if (i == 34) {
/*  806 */       this.R = true;
/*  807 */       this.n = o.h;
/*  808 */       return this.D;
/*      */     } 
/*      */ 
/*      */     
/*  812 */     switch (i)
/*      */     { case 45:
/*  814 */         o = b(true);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  860 */         this.n = o;
/*  861 */         return this.D;case 43: if (a(e.e.c())) { o = b(false); } else { o = n(o); }  this.n = o; return this.D;case 46: o = a(false); this.n = o; return this.D;case 48: case 49: case 50: case 51: case 52: case 53: case 54: case 55: case 56: case 57: o = i(o); this.n = o; return this.D;case 102: aw(); o = o.l; this.n = o; return this.D;case 110: ax(); o = o.m; this.n = o; return this.D;case 116: av(); o = o.k; this.n = o; return this.D;case 91: o = o.d; this.n = o; return this.D;case 123: o = o.b; this.n = o; return this.D; }  o o = n(o); this.n = o; return this.D;
/*      */   }
/*      */ 
/*      */   
/*      */   private final o h(int paramInt) {
/*  866 */     if (paramInt == 34) {
/*  867 */       this.R = true;
/*  868 */       return this.D = o.h;
/*      */     } 
/*  870 */     switch (paramInt) {
/*      */       case 91:
/*  872 */         this.m = this.m.a(this.k, this.l);
/*  873 */         return this.D = o.d;
/*      */       case 123:
/*  875 */         this.m = this.m.b(this.k, this.l);
/*  876 */         return this.D = o.b;
/*      */       case 116:
/*  878 */         av();
/*  879 */         return this.D = o.k;
/*      */       case 102:
/*  881 */         aw();
/*  882 */         return this.D = o.l;
/*      */       case 110:
/*  884 */         ax();
/*  885 */         return this.D = o.m;
/*      */       case 45:
/*  887 */         return this.D = b(true);
/*      */       case 43:
/*  889 */         if (!a(e.e.c())) {
/*  890 */           return this.D = n(paramInt);
/*      */         }
/*  892 */         return this.D = b(false);
/*      */       case 46:
/*  894 */         return this.D = a(false);
/*      */       case 48:
/*      */       case 49:
/*      */       case 50:
/*      */       case 51:
/*      */       case 52:
/*      */       case 53:
/*      */       case 54:
/*      */       case 55:
/*      */       case 56:
/*      */       case 57:
/*  905 */         return this.D = i(paramInt);
/*      */     } 
/*  907 */     return this.D = n(paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   private final o an() {
/*  912 */     this.q = false;
/*  913 */     o o = this.n;
/*  914 */     this.n = null;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  919 */     if (o == o.d) {
/*  920 */       this.m = this.m.a(this.k, this.l);
/*  921 */     } else if (o == o.b) {
/*  922 */       this.m = this.m.b(this.k, this.l);
/*      */     } 
/*  924 */     return this.D = o;
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
/*      */   public final String h() {
/* 1031 */     this.s = 0;
/* 1032 */     if (this.D == o.f) {
/* 1033 */       an();
/* 1034 */       return null;
/*      */     } 
/* 1036 */     if (this.R) {
/* 1037 */       at();
/*      */     }
/*      */     int i;
/* 1040 */     if ((i = aA()) < 0) {
/* 1041 */       close();
/* 1042 */       this.D = null;
/* 1043 */       return null;
/*      */     } 
/* 1045 */     this.r = null;
/*      */     
/* 1047 */     if (i == 93) {
/* 1048 */       aO();
/* 1049 */       this.D = o.e;
/* 1050 */       return null;
/*      */     } 
/* 1052 */     if (i == 125) {
/* 1053 */       aP();
/* 1054 */       this.D = o.c;
/* 1055 */       return null;
/*      */     } 
/*      */ 
/*      */     
/* 1059 */     if (this.m.l()) {
/* 1060 */       if (i != 44) {
/* 1061 */         c(i, "was expecting comma to separate " + this.m.e() + " entries");
/*      */       }
/* 1063 */       i = ay();
/*      */       
/* 1065 */       if ((this.b & E) != 0 && (
/* 1066 */         i == 93 || i == 125)) {
/* 1067 */         w(i);
/* 1068 */         return null;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1073 */     if (!this.m.d()) {
/* 1074 */       aM();
/* 1075 */       h(i);
/* 1076 */       return null;
/*      */     } 
/*      */     
/* 1079 */     aN();
/* 1080 */     String str = k(i);
/* 1081 */     this.m.a(str);
/* 1082 */     this.D = o.f;
/*      */     
/* 1084 */     i = aC();
/* 1085 */     aM();
/* 1086 */     if (i == 34) {
/* 1087 */       this.R = true;
/* 1088 */       this.n = o.h;
/* 1089 */       return str;
/*      */     } 
/*      */     
/* 1092 */     switch (i)
/*      */     { case 45:
/* 1094 */         o = b(true);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1140 */         this.n = o;
/* 1141 */         return str;case 43: if (a(e.e.c())) { o = b(false); } else { o = n(o); }  this.n = o; return str;case 46: o = a(false); this.n = o; return str;case 48: case 49: case 50: case 51: case 52: case 53: case 54: case 55: case 56: case 57: o = i(o); this.n = o; return str;case 102: aw(); o = o.l; this.n = o; return str;case 110: ax(); o = o.m; this.n = o; return str;case 116: av(); o = o.k; this.n = o; return str;case 91: o = o.d; this.n = o; return str;case 123: o = o.b; this.n = o; return str; }  o o = n(o); this.n = o; return str;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final String i() {
/* 1324 */     if (this.D == o.f) {
/* 1325 */       this.q = false;
/* 1326 */       o o = this.n;
/* 1327 */       this.n = null;
/* 1328 */       this.D = o;
/* 1329 */       if (o == o.h) {
/* 1330 */         if (this.R) {
/* 1331 */           this.R = false;
/* 1332 */           return as();
/*      */         } 
/* 1334 */         return this.o.e();
/*      */       } 
/* 1336 */       if (o == o.d) {
/* 1337 */         this.m = this.m.a(this.k, this.l);
/* 1338 */       } else if (o == o.b) {
/* 1339 */         this.m = this.m.b(this.k, this.l);
/*      */       } 
/* 1341 */       return null;
/*      */     } 
/*      */     
/* 1344 */     return (g() == o.h) ? w() : null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int b(int paramInt) {
/* 1351 */     if (this.D == o.f) {
/* 1352 */       this.q = false;
/* 1353 */       o o = this.n;
/* 1354 */       this.n = null;
/* 1355 */       this.D = o;
/* 1356 */       if (o == o.i) {
/* 1357 */         return G();
/*      */       }
/* 1359 */       if (o == o.d) {
/* 1360 */         this.m = this.m.a(this.k, this.l);
/* 1361 */       } else if (o == o.b) {
/* 1362 */         this.m = this.m.b(this.k, this.l);
/*      */       } 
/* 1364 */       return paramInt;
/*      */     } 
/*      */     
/* 1367 */     return (g() == o.i) ? G() : paramInt;
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
/*      */   private o a(boolean paramBoolean) {
/* 1442 */     if (!a(e.f.c())) {
/* 1443 */       return n(46);
/*      */     }
/* 1445 */     char[] arrayOfChar = this.o.h();
/* 1446 */     byte b1 = 0;
/*      */     
/* 1448 */     if (paramBoolean) {
/* 1449 */       b1++; arrayOfChar[0] = '-';
/*      */     } 
/* 1451 */     return a(arrayOfChar, b1, 46, paramBoolean, 0);
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
/*      */   private o i(int paramInt) {
/* 1479 */     char[] arrayOfChar = this.o.h();
/*      */     
/* 1481 */     if (paramInt == 48) {
/* 1482 */       paramInt = ao();
/*      */     }
/*      */     
/* 1485 */     arrayOfChar[0] = (char)paramInt;
/* 1486 */     byte b1 = 1;
/* 1487 */     byte b2 = 1;
/*      */ 
/*      */     
/* 1490 */     int i = Math.min(this.f, this.e + arrayOfChar.length - 1);
/*      */     
/*      */     while (true) {
/* 1493 */       if (this.e >= i) {
/* 1494 */         return a(arrayOfChar, b2, false, b1);
/*      */       }
/*      */       
/* 1497 */       if ((paramInt = this.X[this.e++] & 0xFF) >= 48 && paramInt <= 57) {
/*      */ 
/*      */         
/* 1500 */         b1++;
/* 1501 */         arrayOfChar[b2++] = (char)paramInt; continue;
/*      */       }  break;
/* 1503 */     }  if (paramInt == 46 || paramInt == 101 || paramInt == 69) {
/* 1504 */       return a(arrayOfChar, b2, paramInt, false, b1);
/*      */     }
/* 1506 */     this.e--;
/* 1507 */     this.o.a(b2);
/*      */     
/* 1509 */     if (this.m.c()) {
/* 1510 */       j(paramInt);
/*      */     }
/*      */     
/* 1513 */     return a(false, b1);
/*      */   }
/*      */ 
/*      */   
/*      */   private final o b(boolean paramBoolean) {
/* 1518 */     char[] arrayOfChar = this.o.h();
/* 1519 */     byte b1 = 0;
/*      */     
/* 1521 */     if (paramBoolean) {
/*      */       
/* 1523 */       b1++; arrayOfChar[0] = '-';
/*      */     } 
/*      */     
/* 1526 */     if (this.e >= this.f) {
/* 1527 */       ar();
/*      */     }
/*      */     
/*      */     int i;
/* 1531 */     if ((i = this.X[this.e++] & 0xFF) <= 48) {
/*      */       
/* 1533 */       if (i != 48) {
/* 1534 */         if (i == 46) {
/* 1535 */           return a(paramBoolean);
/*      */         }
/* 1537 */         return a(i, paramBoolean, true);
/*      */       } 
/* 1539 */       i = ao();
/* 1540 */     } else if (i > 57) {
/* 1541 */       return a(i, paramBoolean, true);
/*      */     } 
/*      */ 
/*      */     
/* 1545 */     arrayOfChar[b1++] = (char)i;
/* 1546 */     byte b2 = 1;
/*      */ 
/*      */ 
/*      */     
/* 1550 */     int j = Math.min(this.f, this.e + arrayOfChar.length - b1);
/*      */     
/*      */     while (true) {
/* 1553 */       if (this.e >= j)
/*      */       {
/* 1555 */         return a(arrayOfChar, b1, paramBoolean, b2);
/*      */       }
/*      */       
/* 1558 */       if ((i = this.X[this.e++] & 0xFF) >= 48 && i <= 57) {
/*      */ 
/*      */         
/* 1561 */         b2++;
/* 1562 */         arrayOfChar[b1++] = (char)i; continue;
/*      */       }  break;
/* 1564 */     }  if (i == 46 || i == 101 || i == 69) {
/* 1565 */       return a(arrayOfChar, b1, i, paramBoolean, b2);
/*      */     }
/*      */     
/* 1568 */     this.e--;
/* 1569 */     this.o.a(b1);
/*      */     
/* 1571 */     if (this.m.c()) {
/* 1572 */       j(i);
/*      */     }
/*      */ 
/*      */     
/* 1576 */     return a(paramBoolean, b2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final o a(char[] paramArrayOfchar, int paramInt1, boolean paramBoolean, int paramInt2) {
/*      */     while (true) {
/* 1586 */       if (this.e >= this.f && !am()) {
/* 1587 */         this.o.a(paramInt1);
/* 1588 */         return a(paramBoolean, paramInt2);
/*      */       } 
/*      */       int i;
/* 1591 */       if ((i = this.X[this.e++] & 0xFF) > 57 || i < 48) {
/* 1592 */         if (i == 46 || i == 101 || i == 69) {
/* 1593 */           return a(paramArrayOfchar, paramInt1, i, paramBoolean, paramInt2);
/*      */         }
/*      */         break;
/*      */       } 
/* 1597 */       if (paramInt1 >= paramArrayOfchar.length) {
/* 1598 */         paramArrayOfchar = this.o.j();
/* 1599 */         paramInt1 = 0;
/*      */       } 
/* 1601 */       paramArrayOfchar[paramInt1++] = (char)i;
/* 1602 */       paramInt2++;
/*      */     } 
/* 1604 */     this.e--;
/* 1605 */     this.o.a(paramInt1);
/*      */     
/* 1607 */     if (this.m.c()) {
/* 1608 */       j(this.X[this.e] & 0xFF);
/*      */     }
/*      */ 
/*      */     
/* 1612 */     return a(paramBoolean, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final int ao() {
/* 1621 */     if (this.e >= this.f && !am()) {
/* 1622 */       return 48;
/*      */     }
/*      */     
/*      */     int i;
/* 1626 */     if ((i = this.X[this.e] & 0xFF) < 48 || i > 57) {
/* 1627 */       return 48;
/*      */     }
/*      */     
/* 1630 */     if ((this.b & F) == 0) {
/* 1631 */       c("Leading zeroes not allowed");
/*      */     }
/*      */     
/* 1634 */     this.e++;
/* 1635 */     if (i == 48) {
/* 1636 */       while (this.e < this.f || am()) {
/*      */         
/* 1638 */         if ((i = this.X[this.e] & 0xFF) < 48 || i > 57) {
/* 1639 */           return 48;
/*      */         }
/* 1641 */         this.e++;
/* 1642 */         if (i != 48) {
/*      */           break;
/*      */         }
/*      */       } 
/*      */     }
/* 1647 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private final o a(char[] paramArrayOfchar, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3) {
/* 1653 */     byte b1 = 0;
/* 1654 */     boolean bool = false;
/*      */ 
/*      */     
/* 1657 */     if (paramInt2 == 46) {
/* 1658 */       if (paramInt1 >= paramArrayOfchar.length) {
/* 1659 */         paramArrayOfchar = this.o.j();
/* 1660 */         paramInt1 = 0;
/*      */       } 
/* 1662 */       paramArrayOfchar[paramInt1++] = (char)paramInt2;
/*      */ 
/*      */       
/*      */       while (true) {
/* 1666 */         if (this.e >= this.f && !am()) {
/* 1667 */           bool = true;
/*      */           
/*      */           break;
/*      */         } 
/* 1671 */         if ((paramInt2 = this.X[this.e++] & 0xFF) >= 48 && paramInt2 <= 57) {
/*      */ 
/*      */           
/* 1674 */           b1++;
/* 1675 */           if (paramInt1 >= paramArrayOfchar.length) {
/* 1676 */             paramArrayOfchar = this.o.j();
/* 1677 */             paramInt1 = 0;
/*      */           } 
/* 1679 */           paramArrayOfchar[paramInt1++] = (char)paramInt2; continue;
/*      */         }  break;
/*      */       } 
/* 1682 */       if (b1 == 0 && 
/* 1683 */         !a(e.g.c())) {
/* 1684 */         b(paramInt2, "Decimal point not followed by a digit");
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1689 */     byte b2 = 0;
/* 1690 */     if (paramInt2 == 101 || paramInt2 == 69) {
/* 1691 */       if (paramInt1 >= paramArrayOfchar.length) {
/* 1692 */         paramArrayOfchar = this.o.j();
/* 1693 */         paramInt1 = 0;
/*      */       } 
/* 1695 */       paramArrayOfchar[paramInt1++] = (char)paramInt2;
/*      */       
/* 1697 */       if (this.e >= this.f) {
/* 1698 */         ar();
/*      */       }
/*      */ 
/*      */       
/* 1702 */       if ((paramInt2 = this.X[this.e++] & 0xFF) == 45 || paramInt2 == 43) {
/* 1703 */         if (paramInt1 >= paramArrayOfchar.length) {
/* 1704 */           paramArrayOfchar = this.o.j();
/* 1705 */           paramInt1 = 0;
/*      */         } 
/* 1707 */         paramArrayOfchar[paramInt1++] = (char)paramInt2;
/*      */         
/* 1709 */         if (this.e >= this.f) {
/* 1710 */           ar();
/*      */         }
/* 1712 */         paramInt2 = this.X[this.e++] & 0xFF;
/*      */       } 
/*      */ 
/*      */       
/* 1716 */       while (paramInt2 >= 48 && paramInt2 <= 57) {
/* 1717 */         b2++;
/* 1718 */         if (paramInt1 >= paramArrayOfchar.length) {
/* 1719 */           paramArrayOfchar = this.o.j();
/* 1720 */           paramInt1 = 0;
/*      */         } 
/* 1722 */         paramArrayOfchar[paramInt1++] = (char)paramInt2;
/* 1723 */         if (this.e >= this.f && !am()) {
/* 1724 */           bool = true;
/*      */           break;
/*      */         } 
/* 1727 */         paramInt2 = this.X[this.e++] & 0xFF;
/*      */       } 
/*      */       
/* 1730 */       if (b2 == 0) {
/* 1731 */         b(paramInt2, "Exponent indicator not followed by a digit");
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1736 */     if (!bool) {
/* 1737 */       this.e--;
/*      */       
/* 1739 */       if (this.m.c()) {
/* 1740 */         j(paramInt2);
/*      */       }
/*      */     } 
/* 1743 */     this.o.a(paramInt1);
/*      */ 
/*      */     
/* 1746 */     return a(paramBoolean, paramInt3, b1, b2);
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
/*      */   private final void j(int paramInt) {
/* 1764 */     this.e++;
/*      */     
/* 1766 */     switch (paramInt) {
/*      */       case 9:
/*      */       case 32:
/*      */         return;
/*      */ 
/*      */ 
/*      */       
/*      */       case 13:
/* 1774 */         this.e--;
/*      */         return;
/*      */       case 10:
/* 1777 */         this.h++;
/* 1778 */         this.i = this.e;
/*      */         return;
/*      */     } 
/* 1781 */     e(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String k(int paramInt) {
/* 1792 */     if (paramInt != 34) {
/* 1793 */       return m(paramInt);
/*      */     }
/*      */     
/* 1796 */     if (this.e + 13 > this.f) {
/* 1797 */       return ap();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1806 */     byte[] arrayOfByte = this.X;
/* 1807 */     int[] arrayOfInt = N;
/*      */     
/* 1809 */     int i = arrayOfByte[this.e++] & 0xFF;
/*      */     
/* 1811 */     if (arrayOfInt[i] == 0) {
/* 1812 */       paramInt = arrayOfByte[this.e++] & 0xFF;
/* 1813 */       if (arrayOfInt[paramInt] == 0) {
/* 1814 */         i = i << 8 | paramInt;
/* 1815 */         paramInt = arrayOfByte[this.e++] & 0xFF;
/* 1816 */         if (arrayOfInt[paramInt] == 0) {
/* 1817 */           i = i << 8 | paramInt;
/* 1818 */           paramInt = arrayOfByte[this.e++] & 0xFF;
/* 1819 */           if (arrayOfInt[paramInt] == 0) {
/* 1820 */             i = i << 8 | paramInt;
/* 1821 */             paramInt = arrayOfByte[this.e++] & 0xFF;
/* 1822 */             if (arrayOfInt[paramInt] == 0) {
/* 1823 */               this.S = i;
/* 1824 */               return l(paramInt);
/*      */             } 
/* 1826 */             if (paramInt == 34) {
/* 1827 */               return c(i, 4);
/*      */             }
/* 1829 */             return b(i, paramInt, 4);
/*      */           } 
/* 1831 */           if (paramInt == 34) {
/* 1832 */             return c(i, 3);
/*      */           }
/* 1834 */           return b(i, paramInt, 3);
/*      */         } 
/* 1836 */         if (paramInt == 34) {
/* 1837 */           return c(i, 2);
/*      */         }
/* 1839 */         return b(i, paramInt, 2);
/*      */       } 
/* 1841 */       if (paramInt == 34) {
/* 1842 */         return c(i, 1);
/*      */       }
/* 1844 */       return b(i, paramInt, 1);
/*      */     } 
/* 1846 */     if (i == 34) {
/* 1847 */       return "";
/*      */     }
/* 1849 */     return b(0, i, 0);
/*      */   }
/*      */ 
/*      */   
/*      */   private String l(int paramInt) {
/* 1854 */     byte[] arrayOfByte = this.X;
/* 1855 */     int[] arrayOfInt = N;
/*      */ 
/*      */     
/* 1858 */     int i = arrayOfByte[this.e++] & 0xFF;
/* 1859 */     if (arrayOfInt[i] != 0) {
/* 1860 */       if (i == 34) {
/* 1861 */         return c(this.S, paramInt, 1);
/*      */       }
/* 1863 */       return a(this.S, paramInt, i, 1);
/*      */     } 
/* 1865 */     paramInt = paramInt << 8 | i;
/* 1866 */     i = arrayOfByte[this.e++] & 0xFF;
/* 1867 */     if (arrayOfInt[i] != 0) {
/* 1868 */       if (i == 34) {
/* 1869 */         return c(this.S, paramInt, 2);
/*      */       }
/* 1871 */       return a(this.S, paramInt, i, 2);
/*      */     } 
/* 1873 */     paramInt = paramInt << 8 | i;
/* 1874 */     i = arrayOfByte[this.e++] & 0xFF;
/* 1875 */     if (arrayOfInt[i] != 0) {
/* 1876 */       if (i == 34) {
/* 1877 */         return c(this.S, paramInt, 3);
/*      */       }
/* 1879 */       return a(this.S, paramInt, i, 3);
/*      */     } 
/* 1881 */     paramInt = paramInt << 8 | i;
/* 1882 */     i = arrayOfByte[this.e++] & 0xFF;
/* 1883 */     if (arrayOfInt[i] != 0) {
/* 1884 */       if (i == 34) {
/* 1885 */         return c(this.S, paramInt, 4);
/*      */       }
/* 1887 */       return a(this.S, paramInt, i, 4);
/*      */     } 
/* 1889 */     return b(i, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private String b(int paramInt1, int paramInt2) {
/* 1895 */     byte[] arrayOfByte = this.X;
/* 1896 */     int[] arrayOfInt = N;
/*      */ 
/*      */     
/* 1899 */     int i = arrayOfByte[this.e++] & 0xFF;
/* 1900 */     if (arrayOfInt[i] != 0) {
/* 1901 */       if (i == 34) {
/* 1902 */         return b(this.S, paramInt2, paramInt1, 1);
/*      */       }
/* 1904 */       return a(this.S, paramInt2, paramInt1, i, 1);
/*      */     } 
/* 1906 */     paramInt1 = paramInt1 << 8 | i;
/* 1907 */     i = arrayOfByte[this.e++] & 0xFF;
/* 1908 */     if (arrayOfInt[i] != 0) {
/* 1909 */       if (i == 34) {
/* 1910 */         return b(this.S, paramInt2, paramInt1, 2);
/*      */       }
/* 1912 */       return a(this.S, paramInt2, paramInt1, i, 2);
/*      */     } 
/* 1914 */     paramInt1 = paramInt1 << 8 | i;
/* 1915 */     i = arrayOfByte[this.e++] & 0xFF;
/* 1916 */     if (arrayOfInt[i] != 0) {
/* 1917 */       if (i == 34) {
/* 1918 */         return b(this.S, paramInt2, paramInt1, 3);
/*      */       }
/* 1920 */       return a(this.S, paramInt2, paramInt1, i, 3);
/*      */     } 
/* 1922 */     paramInt1 = paramInt1 << 8 | i;
/* 1923 */     i = arrayOfByte[this.e++] & 0xFF;
/* 1924 */     if (arrayOfInt[i] != 0) {
/* 1925 */       if (i == 34) {
/* 1926 */         return b(this.S, paramInt2, paramInt1, 4);
/*      */       }
/* 1928 */       return a(this.S, paramInt2, paramInt1, i, 4);
/*      */     } 
/* 1930 */     return a(i, paramInt2, paramInt1);
/*      */   }
/*      */ 
/*      */   
/*      */   private String a(int paramInt1, int paramInt2, int paramInt3) {
/* 1935 */     this.Q[0] = this.S;
/* 1936 */     this.Q[1] = paramInt2;
/* 1937 */     this.Q[2] = paramInt3;
/*      */ 
/*      */     
/* 1940 */     byte[] arrayOfByte = this.X;
/* 1941 */     int[] arrayOfInt = N;
/* 1942 */     byte b1 = 3;
/*      */     
/* 1944 */     while (this.e + 4 <= this.f) {
/* 1945 */       int i = arrayOfByte[this.e++] & 0xFF;
/* 1946 */       if (arrayOfInt[i] != 0) {
/* 1947 */         if (i == 34) {
/* 1948 */           return a(this.Q, b1, paramInt1, 1);
/*      */         }
/* 1950 */         return a(this.Q, b1, paramInt1, i, 1);
/*      */       } 
/*      */       
/* 1953 */       paramInt1 = paramInt1 << 8 | i;
/* 1954 */       i = arrayOfByte[this.e++] & 0xFF;
/* 1955 */       if (arrayOfInt[i] != 0) {
/* 1956 */         if (i == 34) {
/* 1957 */           return a(this.Q, b1, paramInt1, 2);
/*      */         }
/* 1959 */         return a(this.Q, b1, paramInt1, i, 2);
/*      */       } 
/*      */       
/* 1962 */       paramInt1 = paramInt1 << 8 | i;
/* 1963 */       i = arrayOfByte[this.e++] & 0xFF;
/* 1964 */       if (arrayOfInt[i] != 0) {
/* 1965 */         if (i == 34) {
/* 1966 */           return a(this.Q, b1, paramInt1, 3);
/*      */         }
/* 1968 */         return a(this.Q, b1, paramInt1, i, 3);
/*      */       } 
/*      */       
/* 1971 */       paramInt1 = paramInt1 << 8 | i;
/* 1972 */       i = arrayOfByte[this.e++] & 0xFF;
/* 1973 */       if (arrayOfInt[i] != 0) {
/* 1974 */         if (i == 34) {
/* 1975 */           return a(this.Q, b1, paramInt1, 4);
/*      */         }
/* 1977 */         return a(this.Q, b1, paramInt1, i, 4);
/*      */       } 
/*      */ 
/*      */       
/* 1981 */       if (b1 >= this.Q.length) {
/* 1982 */         this.Q = a(this.Q, b1);
/*      */       }
/* 1984 */       this.Q[b1++] = paramInt1;
/* 1985 */       paramInt1 = i;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1992 */     return a(this.Q, b1, 0, paramInt1, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String ap() {
/* 2000 */     if (this.e >= this.f && 
/* 2001 */       !am()) {
/* 2002 */       b(": was expecting closing '\"' for name", o.f);
/*      */     }
/*      */     
/*      */     int i;
/* 2006 */     if ((i = this.X[this.e++] & 0xFF) == 34) {
/* 2007 */       return "";
/*      */     }
/* 2009 */     return a(this.Q, 0, 0, i, 0);
/*      */   }
/*      */   
/*      */   private final String b(int paramInt1, int paramInt2, int paramInt3) {
/* 2013 */     return a(this.Q, 0, paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */   
/*      */   private final String a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 2017 */     this.Q[0] = paramInt1;
/* 2018 */     return a(this.Q, 1, paramInt2, paramInt3, paramInt4);
/*      */   }
/*      */   
/*      */   private final String a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 2022 */     this.Q[0] = paramInt1;
/* 2023 */     this.Q[1] = paramInt2;
/* 2024 */     return a(this.Q, 2, paramInt3, paramInt4, paramInt5);
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
/*      */   private String a(int[] paramArrayOfint, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 2037 */     int[] arrayOfInt = N;
/*      */     
/*      */     while (true) {
/* 2040 */       if (arrayOfInt[paramInt3] != 0)
/* 2041 */         if (paramInt3 != 34) {
/*      */ 
/*      */ 
/*      */           
/* 2045 */           if (paramInt3 != 92) {
/*      */             
/* 2047 */             a(paramInt3, "name");
/*      */           } else {
/*      */             
/* 2050 */             paramInt3 = af();
/*      */           } 
/*      */ 
/*      */ 
/*      */           
/* 2055 */           if (paramInt3 > 127) {
/*      */             
/* 2057 */             if (paramInt4 >= 4) {
/* 2058 */               if (paramInt1 >= paramArrayOfint.length) {
/* 2059 */                 this.Q = paramArrayOfint = a(paramArrayOfint, paramArrayOfint.length);
/*      */               }
/* 2061 */               paramArrayOfint[paramInt1++] = paramInt2;
/* 2062 */               paramInt2 = 0;
/* 2063 */               paramInt4 = 0;
/*      */             } 
/* 2065 */             if (paramInt3 < 2048) {
/* 2066 */               paramInt2 = paramInt2 << 8 | 0xC0 | paramInt3 >> 6;
/* 2067 */               paramInt4++;
/*      */             } else {
/*      */               
/* 2070 */               paramInt2 = paramInt2 << 8 | 0xE0 | paramInt3 >> 12;
/* 2071 */               paramInt4++;
/*      */               
/* 2073 */               if (paramInt4 >= 4) {
/* 2074 */                 if (paramInt1 >= paramArrayOfint.length) {
/* 2075 */                   this.Q = paramArrayOfint = a(paramArrayOfint, paramArrayOfint.length);
/*      */                 }
/* 2077 */                 paramArrayOfint[paramInt1++] = paramInt2;
/* 2078 */                 paramInt2 = 0;
/* 2079 */                 paramInt4 = 0;
/*      */               } 
/* 2081 */               paramInt2 = paramInt2 << 8 | 0x80 | paramInt3 >> 6 & 0x3F;
/* 2082 */               paramInt4++;
/*      */             } 
/*      */             
/* 2085 */             paramInt3 = 0x80 | paramInt3 & 0x3F;
/*      */           } 
/*      */         } else {
/*      */           break;
/* 2089 */         }   if (paramInt4 < 4) {
/* 2090 */         paramInt4++;
/* 2091 */         paramInt2 = paramInt2 << 8 | paramInt3;
/*      */       } else {
/* 2093 */         if (paramInt1 >= paramArrayOfint.length) {
/* 2094 */           this.Q = paramArrayOfint = a(paramArrayOfint, paramArrayOfint.length);
/*      */         }
/* 2096 */         paramArrayOfint[paramInt1++] = paramInt2;
/* 2097 */         paramInt2 = paramInt3;
/* 2098 */         paramInt4 = 1;
/*      */       } 
/* 2100 */       if (this.e >= this.f && 
/* 2101 */         !am()) {
/* 2102 */         b(" in field name", o.f);
/*      */       }
/*      */       
/* 2105 */       paramInt3 = this.X[this.e++] & 0xFF;
/*      */     } 
/*      */     
/* 2108 */     if (paramInt4 > 0) {
/* 2109 */       if (paramInt1 >= paramArrayOfint.length) {
/* 2110 */         this.Q = paramArrayOfint = a(paramArrayOfint, paramArrayOfint.length);
/*      */       }
/* 2112 */       paramArrayOfint[paramInt1++] = d(paramInt2, paramInt4);
/*      */     } 
/*      */     String str;
/* 2115 */     if ((str = this.P.a(paramArrayOfint, paramInt1)) == null) {
/* 2116 */       str = a(paramArrayOfint, paramInt1, paramInt4);
/*      */     }
/* 2118 */     return str;
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
/*      */   private String m(int paramInt) {
/* 2137 */     if (paramInt == 39 && (this.b & I) != 0) {
/* 2138 */       return aq();
/*      */     }
/*      */     
/* 2141 */     if ((this.b & J) == 0) {
/* 2142 */       char c = (char)o(paramInt);
/* 2143 */       c(c, "was expecting double-quote to start field name");
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*      */     int[] arrayOfInt1;
/*      */ 
/*      */     
/* 2151 */     if ((arrayOfInt1 = b.d())[paramInt] != 0) {
/* 2152 */       c(paramInt, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2158 */     int[] arrayOfInt2 = this.Q;
/* 2159 */     byte b1 = 0;
/* 2160 */     int i = 0;
/* 2161 */     byte b2 = 0;
/*      */ 
/*      */     
/*      */     while (true) {
/* 2165 */       if (b2 < 4) {
/* 2166 */         b2++;
/* 2167 */         i = i << 8 | paramInt;
/*      */       } else {
/* 2169 */         if (b1 >= arrayOfInt2.length) {
/* 2170 */           this.Q = arrayOfInt2 = a(arrayOfInt2, arrayOfInt2.length);
/*      */         }
/* 2172 */         arrayOfInt2[b1++] = i;
/* 2173 */         i = paramInt;
/* 2174 */         b2 = 1;
/*      */       } 
/* 2176 */       if (this.e >= this.f && 
/* 2177 */         !am()) {
/* 2178 */         b(" in field name", o.f);
/*      */       }
/*      */       
/* 2181 */       paramInt = this.X[this.e] & 0xFF;
/* 2182 */       if (arrayOfInt1[paramInt] == 0) {
/*      */ 
/*      */         
/* 2185 */         this.e++; continue;
/*      */       }  break;
/*      */     } 
/* 2188 */     if (b2 > 0) {
/* 2189 */       if (b1 >= arrayOfInt2.length) {
/* 2190 */         this.Q = arrayOfInt2 = a(arrayOfInt2, arrayOfInt2.length);
/*      */       }
/* 2192 */       arrayOfInt2[b1++] = i;
/*      */     } 
/*      */     String str;
/* 2195 */     if ((str = this.P.a(arrayOfInt2, b1)) == null) {
/* 2196 */       str = a(arrayOfInt2, b1, b2);
/*      */     }
/* 2198 */     return str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String aq() {
/* 2207 */     if (this.e >= this.f && 
/* 2208 */       !am()) {
/* 2209 */       b(": was expecting closing ''' for field name", o.f);
/*      */     }
/*      */     
/*      */     int i;
/* 2213 */     if ((i = this.X[this.e++] & 0xFF) == 39) {
/* 2214 */       return "";
/*      */     }
/* 2216 */     int[] arrayOfInt1 = this.Q;
/* 2217 */     byte b1 = 0;
/* 2218 */     int j = 0;
/* 2219 */     byte b2 = 0;
/*      */ 
/*      */ 
/*      */     
/* 2223 */     int[] arrayOfInt2 = N;
/*      */ 
/*      */     
/* 2226 */     while (i != 39) {
/*      */ 
/*      */ 
/*      */       
/* 2230 */       if (arrayOfInt2[i] != 0 && i != 34) {
/* 2231 */         if (i != 92) {
/*      */ 
/*      */           
/* 2234 */           a(i, "name");
/*      */         } else {
/*      */           
/* 2237 */           i = af();
/*      */         } 
/*      */         
/* 2240 */         if (i > 127) {
/*      */           
/* 2242 */           if (b2 >= 4) {
/* 2243 */             if (b1 >= arrayOfInt1.length) {
/* 2244 */               this.Q = arrayOfInt1 = a(arrayOfInt1, arrayOfInt1.length);
/*      */             }
/* 2246 */             arrayOfInt1[b1++] = j;
/* 2247 */             j = 0;
/* 2248 */             b2 = 0;
/*      */           } 
/* 2250 */           if (i < 2048) {
/* 2251 */             j = j << 8 | 0xC0 | i >> 6;
/* 2252 */             b2++;
/*      */           } else {
/*      */             
/* 2255 */             j = j << 8 | 0xE0 | i >> 12;
/* 2256 */             b2++;
/*      */             
/* 2258 */             if (b2 >= 4) {
/* 2259 */               if (b1 >= arrayOfInt1.length) {
/* 2260 */                 this.Q = arrayOfInt1 = a(arrayOfInt1, arrayOfInt1.length);
/*      */               }
/* 2262 */               arrayOfInt1[b1++] = j;
/* 2263 */               j = 0;
/* 2264 */               b2 = 0;
/*      */             } 
/* 2266 */             j = j << 8 | 0x80 | i >> 6 & 0x3F;
/* 2267 */             b2++;
/*      */           } 
/*      */           
/* 2270 */           i = 0x80 | i & 0x3F;
/*      */         } 
/*      */       } 
/*      */       
/* 2274 */       if (b2 < 4) {
/* 2275 */         b2++;
/* 2276 */         j = j << 8 | i;
/*      */       } else {
/* 2278 */         if (b1 >= arrayOfInt1.length) {
/* 2279 */           this.Q = arrayOfInt1 = a(arrayOfInt1, arrayOfInt1.length);
/*      */         }
/* 2281 */         arrayOfInt1[b1++] = j;
/* 2282 */         j = i;
/* 2283 */         b2 = 1;
/*      */       } 
/* 2285 */       if (this.e >= this.f && 
/* 2286 */         !am()) {
/* 2287 */         b(" in field name", o.f);
/*      */       }
/*      */       
/* 2290 */       i = this.X[this.e++] & 0xFF;
/*      */     } 
/*      */     
/* 2293 */     if (b2 > 0) {
/* 2294 */       if (b1 >= arrayOfInt1.length) {
/* 2295 */         this.Q = arrayOfInt1 = a(arrayOfInt1, arrayOfInt1.length);
/*      */       }
/* 2297 */       arrayOfInt1[b1++] = d(j, b2);
/*      */     } 
/*      */     String str;
/* 2300 */     if ((str = this.P.a(arrayOfInt1, b1)) == null) {
/* 2301 */       str = a(arrayOfInt1, b1, b2);
/*      */     }
/* 2303 */     return str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final String c(int paramInt1, int paramInt2) {
/* 2314 */     paramInt1 = d(paramInt1, paramInt2);
/*      */     
/*      */     String str;
/* 2317 */     if ((str = this.P.b(paramInt1)) != null) {
/* 2318 */       return str;
/*      */     }
/*      */     
/* 2321 */     this.Q[0] = paramInt1;
/* 2322 */     return a(this.Q, 1, paramInt2);
/*      */   }
/*      */ 
/*      */   
/*      */   private final String c(int paramInt1, int paramInt2, int paramInt3) {
/* 2327 */     paramInt2 = d(paramInt2, paramInt3);
/*      */     
/*      */     String str;
/* 2330 */     if ((str = this.P.a(paramInt1, paramInt2)) != null) {
/* 2331 */       return str;
/*      */     }
/*      */     
/* 2334 */     this.Q[0] = paramInt1;
/* 2335 */     this.Q[1] = paramInt2;
/* 2336 */     return a(this.Q, 2, paramInt3);
/*      */   }
/*      */ 
/*      */   
/*      */   private final String b(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 2341 */     paramInt3 = d(paramInt3, paramInt4);
/*      */     String str;
/* 2343 */     if ((str = this.P.a(paramInt1, paramInt2, paramInt3)) != null) {
/* 2344 */       return str;
/*      */     }
/*      */     int[] arrayOfInt;
/* 2347 */     (arrayOfInt = this.Q)[0] = paramInt1;
/* 2348 */     arrayOfInt[1] = paramInt2;
/* 2349 */     arrayOfInt[2] = d(paramInt3, paramInt4);
/* 2350 */     return a(arrayOfInt, 3, paramInt4);
/*      */   }
/*      */ 
/*      */   
/*      */   private final String a(int[] paramArrayOfint, int paramInt1, int paramInt2, int paramInt3) {
/* 2355 */     if (paramInt1 >= paramArrayOfint.length) {
/* 2356 */       this.Q = paramArrayOfint = a(paramArrayOfint, paramArrayOfint.length);
/*      */     }
/* 2358 */     paramArrayOfint[paramInt1++] = d(paramInt2, paramInt3);
/*      */     String str;
/* 2360 */     if ((str = this.P.a(paramArrayOfint, paramInt1)) == null) {
/* 2361 */       return a(paramArrayOfint, paramInt1, paramInt3);
/*      */     }
/* 2363 */     return str;
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
/*      */   private final String a(int[] paramArrayOfint, int paramInt1, int paramInt2) {
/*      */     boolean bool;
/* 2378 */     int i = (paramInt1 << 2) - 4 + paramInt2;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2387 */     if (paramInt2 < 4) {
/* 2388 */       bool = paramArrayOfint[paramInt1 - 1];
/*      */       
/* 2390 */       paramArrayOfint[paramInt1 - 1] = bool << 4 - paramInt2 << 3;
/*      */     } else {
/* 2392 */       bool = false;
/*      */     } 
/*      */ 
/*      */     
/* 2396 */     char[] arrayOfChar = this.o.h();
/* 2397 */     byte b1 = 0;
/*      */     
/* 2399 */     for (byte b2 = 0; b2 < i; ) {
/* 2400 */       int j = paramArrayOfint[b2 >> 2];
/* 2401 */       int k = b2 & 0x3;
/* 2402 */       j = j >> 3 - k << 3 & 0xFF;
/* 2403 */       b2++;
/*      */       
/* 2405 */       if (j > 127) {
/*      */         int m;
/* 2407 */         if ((j & 0xE0) == 192) {
/* 2408 */           j &= 0x1F;
/* 2409 */           m = 1;
/* 2410 */         } else if ((j & 0xF0) == 224) {
/* 2411 */           j &= 0xF;
/* 2412 */           m = 2;
/* 2413 */         } else if ((j & 0xF8) == 240) {
/* 2414 */           j &= 0x7;
/* 2415 */           m = 3;
/*      */         } else {
/* 2417 */           u(j);
/* 2418 */           m = j = 1;
/*      */         } 
/* 2420 */         if (b2 + m > i) {
/* 2421 */           b(" in field name", o.f);
/*      */         }
/*      */ 
/*      */         
/* 2425 */         int n = paramArrayOfint[b2 >> 2];
/* 2426 */         k = b2 & 0x3;
/* 2427 */         n >>= 3 - k << 3;
/* 2428 */         b2++;
/*      */         
/* 2430 */         if ((n & 0xC0) != 128) {
/* 2431 */           v(n);
/*      */         }
/* 2433 */         j = j << 6 | n & 0x3F;
/* 2434 */         if (m > 1) {
/* 2435 */           n = paramArrayOfint[b2 >> 2];
/* 2436 */           k = b2 & 0x3;
/* 2437 */           n >>= 3 - k << 3;
/* 2438 */           b2++;
/*      */           
/* 2440 */           if ((n & 0xC0) != 128) {
/* 2441 */             v(n);
/*      */           }
/* 2443 */           j = j << 6 | n & 0x3F;
/* 2444 */           if (m > 2) {
/* 2445 */             n = paramArrayOfint[b2 >> 2];
/* 2446 */             k = b2 & 0x3;
/* 2447 */             n >>= 3 - k << 3;
/* 2448 */             b2++;
/* 2449 */             if ((n & 0xC0) != 128) {
/* 2450 */               v(n & 0xFF);
/*      */             }
/* 2452 */             j = j << 6 | n & 0x3F;
/*      */           } 
/*      */         } 
/* 2455 */         if (m > 2) {
/* 2456 */           j -= 65536;
/* 2457 */           if (b1 >= arrayOfChar.length) {
/* 2458 */             arrayOfChar = this.o.k();
/*      */           }
/* 2460 */           arrayOfChar[b1++] = (char)(55296 + (j >> 10));
/* 2461 */           j = 0xDC00 | j & 0x3FF;
/*      */         } 
/*      */       } 
/* 2464 */       if (b1 >= arrayOfChar.length) {
/* 2465 */         arrayOfChar = this.o.k();
/*      */       }
/* 2467 */       arrayOfChar[b1++] = (char)j;
/*      */     } 
/*      */ 
/*      */     
/* 2471 */     String str = new String(arrayOfChar, 0, b1);
/*      */     
/* 2473 */     if (paramInt2 < 4) {
/* 2474 */       paramArrayOfint[paramInt1 - 1] = bool;
/*      */     }
/* 2476 */     return this.P.a(str, paramArrayOfint, paramInt1);
/*      */   }
/*      */ 
/*      */   
/*      */   private static final int d(int paramInt1, int paramInt2) {
/* 2481 */     return (paramInt2 == 4) ? paramInt1 : (paramInt1 | -1 << paramInt2 << 3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void ar() {
/* 2491 */     if (!am()) ak();
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected final void ah() {
/*      */     int i;
/* 2499 */     if ((i = this.e) >= this.f) {
/* 2500 */       ar();
/* 2501 */       i = this.e;
/*      */     } 
/* 2503 */     byte b1 = 0;
/* 2504 */     char[] arrayOfChar = this.o.h();
/* 2505 */     int[] arrayOfInt = M;
/*      */     
/* 2507 */     int j = Math.min(this.f, i + arrayOfChar.length);
/* 2508 */     byte[] arrayOfByte = this.X;
/* 2509 */     while (i < j) {
/* 2510 */       int k = arrayOfByte[i] & 0xFF;
/* 2511 */       if (arrayOfInt[k] != 0) {
/* 2512 */         if (k == 34) {
/* 2513 */           this.e = i + 1;
/* 2514 */           this.o.a(b1);
/*      */           return;
/*      */         } 
/*      */         break;
/*      */       } 
/* 2519 */       i++;
/* 2520 */       arrayOfChar[b1++] = (char)k;
/*      */     } 
/* 2522 */     this.e = i;
/* 2523 */     a(arrayOfChar, b1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String as() {
/*      */     int i;
/* 2531 */     if ((i = this.e) >= this.f) {
/* 2532 */       ar();
/* 2533 */       i = this.e;
/*      */     } 
/* 2535 */     byte b1 = 0;
/* 2536 */     char[] arrayOfChar = this.o.h();
/* 2537 */     int[] arrayOfInt = M;
/*      */     
/* 2539 */     int j = Math.min(this.f, i + arrayOfChar.length);
/* 2540 */     byte[] arrayOfByte = this.X;
/* 2541 */     while (i < j) {
/* 2542 */       int k = arrayOfByte[i] & 0xFF;
/* 2543 */       if (arrayOfInt[k] != 0) {
/* 2544 */         if (k == 34) {
/* 2545 */           this.e = i + 1;
/* 2546 */           return this.o.b(b1);
/*      */         } 
/*      */         break;
/*      */       } 
/* 2550 */       i++;
/* 2551 */       arrayOfChar[b1++] = (char)k;
/*      */     } 
/* 2553 */     this.e = i;
/* 2554 */     a(arrayOfChar, b1);
/* 2555 */     return this.o.e();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final void a(char[] paramArrayOfchar, int paramInt) {
/* 2564 */     int[] arrayOfInt = M;
/* 2565 */     byte[] arrayOfByte = this.X;
/*      */ 
/*      */ 
/*      */     
/*      */     while (true) {
/*      */       int i;
/*      */ 
/*      */       
/* 2573 */       if ((i = this.e) >= this.f) {
/* 2574 */         ar();
/* 2575 */         i = this.e;
/*      */       } 
/* 2577 */       if (paramInt >= paramArrayOfchar.length) {
/* 2578 */         paramArrayOfchar = this.o.j();
/* 2579 */         paramInt = 0;
/*      */       } 
/* 2581 */       int j = Math.min(this.f, i + paramArrayOfchar.length - paramInt);
/* 2582 */       while (i < j) {
/* 2583 */         int k = arrayOfByte[i++] & 0xFF;
/* 2584 */         if (arrayOfInt[k] != 0) {
/* 2585 */           this.e = i;
/*      */         } else {
/*      */           
/* 2588 */           paramArrayOfchar[paramInt++] = (char)k;
/*      */           
/*      */           continue;
/*      */         } 
/*      */         
/* 2593 */         if (k != 34)
/*      */         
/*      */         { 
/*      */           
/* 2597 */           switch (arrayOfInt[k]) {
/*      */             case 1:
/* 2599 */               k = af();
/*      */               break;
/*      */             case 2:
/* 2602 */               k = p(k);
/*      */               break;
/*      */             case 3:
/* 2605 */               if (this.f - this.e >= 2) {
/* 2606 */                 k = r(k); break;
/*      */               } 
/* 2608 */               k = q(k);
/*      */               break;
/*      */             
/*      */             case 4:
/* 2612 */               k = s(k);
/*      */               
/* 2614 */               paramArrayOfchar[paramInt++] = (char)(0xD800 | k >> 10);
/* 2615 */               if (paramInt >= paramArrayOfchar.length) {
/* 2616 */                 paramArrayOfchar = this.o.j();
/* 2617 */                 paramInt = 0;
/*      */               } 
/* 2619 */               k = 0xDC00 | k & 0x3FF;
/*      */               break;
/*      */             
/*      */             default:
/* 2623 */               if (k < 32) {
/*      */                 
/* 2625 */                 a(k, "string value");
/*      */                 break;
/*      */               } 
/* 2628 */               t(k);
/*      */               break;
/*      */           } 
/*      */           
/* 2632 */           if (paramInt >= paramArrayOfchar.length) {
/* 2633 */             paramArrayOfchar = this.o.j();
/* 2634 */             paramInt = 0;
/*      */           } 
/*      */           
/* 2637 */           paramArrayOfchar[paramInt++] = (char)k; } 
/*      */       }  this.e = i;
/* 2639 */     }  this.o.a(paramInt);
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
/*      */   private void at() {
/* 2652 */     this.R = false;
/*      */ 
/*      */     
/* 2655 */     int[] arrayOfInt = M;
/* 2656 */     byte[] arrayOfByte = this.X;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     while (true) {
/* 2664 */       int i = this.e;
/* 2665 */       int j = this.f;
/* 2666 */       if (i >= j) {
/* 2667 */         ar();
/* 2668 */         i = this.e;
/* 2669 */         j = this.f;
/*      */       } 
/* 2671 */       while (i < j) {
/* 2672 */         int k = arrayOfByte[i++] & 0xFF;
/* 2673 */         if (arrayOfInt[k] != 0) {
/* 2674 */           this.e = i;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2681 */           if (k != 34) {
/*      */ 
/*      */ 
/*      */             
/* 2685 */             switch (arrayOfInt[k]) {
/*      */               case 1:
/* 2687 */                 af();
/*      */                 continue;
/*      */               case 2:
/* 2690 */                 aH();
/*      */                 continue;
/*      */               case 3:
/* 2693 */                 aI();
/*      */                 continue;
/*      */               case 4:
/* 2696 */                 aJ();
/*      */                 continue;
/*      */             } 
/* 2699 */             if (k < 32) {
/* 2700 */               a(k, "string value");
/*      */               continue;
/*      */             } 
/* 2703 */             t(k);
/*      */             continue;
/*      */           } 
/*      */           return;
/*      */         } 
/*      */       } 
/*      */       this.e = i;
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
/*      */   private o n(int paramInt) {
/*      */     // Byte code:
/*      */     //   0: iload_1
/*      */     //   1: lookupswitch default -> 262, 39 -> 120, 43 -> 210, 44 -> 78, 73 -> 173, 78 -> 136, 93 -> 68, 125 -> 113
/*      */     //   68: aload_0
/*      */     //   69: getfield m : Lcom/a/a/b/d/d;
/*      */     //   72: invokevirtual b : ()Z
/*      */     //   75: ifeq -> 262
/*      */     //   78: aload_0
/*      */     //   79: getfield m : Lcom/a/a/b/d/d;
/*      */     //   82: invokevirtual c : ()Z
/*      */     //   85: ifne -> 113
/*      */     //   88: aload_0
/*      */     //   89: getfield b : I
/*      */     //   92: getstatic com/a/a/b/d/h.H : I
/*      */     //   95: iand
/*      */     //   96: ifeq -> 113
/*      */     //   99: aload_0
/*      */     //   100: dup
/*      */     //   101: getfield e : I
/*      */     //   104: iconst_1
/*      */     //   105: isub
/*      */     //   106: putfield e : I
/*      */     //   109: getstatic com/a/a/b/o.m : Lcom/a/a/b/o;
/*      */     //   112: areturn
/*      */     //   113: aload_0
/*      */     //   114: iload_1
/*      */     //   115: ldc 'expected a value'
/*      */     //   117: invokevirtual c : (ILjava/lang/String;)V
/*      */     //   120: aload_0
/*      */     //   121: getfield b : I
/*      */     //   124: getstatic com/a/a/b/d/h.I : I
/*      */     //   127: iand
/*      */     //   128: ifeq -> 262
/*      */     //   131: aload_0
/*      */     //   132: invokevirtual au : ()Lcom/a/a/b/o;
/*      */     //   135: areturn
/*      */     //   136: aload_0
/*      */     //   137: ldc 'NaN'
/*      */     //   139: iconst_1
/*      */     //   140: invokevirtual a : (Ljava/lang/String;I)V
/*      */     //   143: aload_0
/*      */     //   144: getfield b : I
/*      */     //   147: getstatic com/a/a/b/d/h.G : I
/*      */     //   150: iand
/*      */     //   151: ifeq -> 164
/*      */     //   154: aload_0
/*      */     //   155: ldc 'NaN'
/*      */     //   157: ldc2_w NaN
/*      */     //   160: invokevirtual a : (Ljava/lang/String;D)Lcom/a/a/b/o;
/*      */     //   163: areturn
/*      */     //   164: aload_0
/*      */     //   165: ldc 'Non-standard token 'NaN': enable `JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS` to allow'
/*      */     //   167: invokevirtual g : (Ljava/lang/String;)V
/*      */     //   170: goto -> 262
/*      */     //   173: aload_0
/*      */     //   174: ldc 'Infinity'
/*      */     //   176: iconst_1
/*      */     //   177: invokevirtual a : (Ljava/lang/String;I)V
/*      */     //   180: aload_0
/*      */     //   181: getfield b : I
/*      */     //   184: getstatic com/a/a/b/d/h.G : I
/*      */     //   187: iand
/*      */     //   188: ifeq -> 201
/*      */     //   191: aload_0
/*      */     //   192: ldc 'Infinity'
/*      */     //   194: ldc2_w Infinity
/*      */     //   197: invokevirtual a : (Ljava/lang/String;D)Lcom/a/a/b/o;
/*      */     //   200: areturn
/*      */     //   201: aload_0
/*      */     //   202: ldc 'Non-standard token 'Infinity': enable `JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS` to allow'
/*      */     //   204: invokevirtual g : (Ljava/lang/String;)V
/*      */     //   207: goto -> 262
/*      */     //   210: aload_0
/*      */     //   211: getfield e : I
/*      */     //   214: aload_0
/*      */     //   215: getfield f : I
/*      */     //   218: if_icmplt -> 235
/*      */     //   221: aload_0
/*      */     //   222: invokevirtual am : ()Z
/*      */     //   225: ifne -> 235
/*      */     //   228: aload_0
/*      */     //   229: getstatic com/a/a/b/o.i : Lcom/a/a/b/o;
/*      */     //   232: invokevirtual b : (Lcom/a/a/b/o;)V
/*      */     //   235: aload_0
/*      */     //   236: dup
/*      */     //   237: getfield X : [B
/*      */     //   240: aload_0
/*      */     //   241: dup
/*      */     //   242: getfield e : I
/*      */     //   245: dup_x1
/*      */     //   246: iconst_1
/*      */     //   247: iadd
/*      */     //   248: putfield e : I
/*      */     //   251: baload
/*      */     //   252: sipush #255
/*      */     //   255: iand
/*      */     //   256: iconst_0
/*      */     //   257: iconst_1
/*      */     //   258: invokevirtual a : (IZZ)Lcom/a/a/b/o;
/*      */     //   261: areturn
/*      */     //   262: iload_1
/*      */     //   263: invokestatic isJavaIdentifierStart : (I)Z
/*      */     //   266: ifeq -> 292
/*      */     //   269: aload_0
/*      */     //   270: new java/lang/StringBuilder
/*      */     //   273: dup
/*      */     //   274: invokespecial <init> : ()V
/*      */     //   277: iload_1
/*      */     //   278: i2c
/*      */     //   279: invokevirtual append : (C)Ljava/lang/StringBuilder;
/*      */     //   282: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   285: aload_0
/*      */     //   286: invokevirtual ad : ()Ljava/lang/String;
/*      */     //   289: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)V
/*      */     //   292: aload_0
/*      */     //   293: iload_1
/*      */     //   294: new java/lang/StringBuilder
/*      */     //   297: dup
/*      */     //   298: ldc 'expected a valid value '
/*      */     //   300: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   303: aload_0
/*      */     //   304: invokevirtual ae : ()Ljava/lang/String;
/*      */     //   307: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   310: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   313: invokevirtual c : (ILjava/lang/String;)V
/*      */     //   316: aconst_null
/*      */     //   317: areturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #2723	-> 0
/*      */     //   #2732	-> 68
/*      */     //   #2741	-> 78
/*      */     //   #2742	-> 88
/*      */     //   #2743	-> 99
/*      */     //   #2744	-> 109
/*      */     //   #2751	-> 113
/*      */     //   #2753	-> 120
/*      */     //   #2754	-> 131
/*      */     //   #2758	-> 136
/*      */     //   #2759	-> 143
/*      */     //   #2760	-> 154
/*      */     //   #2762	-> 164
/*      */     //   #2763	-> 170
/*      */     //   #2765	-> 173
/*      */     //   #2766	-> 180
/*      */     //   #2767	-> 191
/*      */     //   #2769	-> 201
/*      */     //   #2770	-> 207
/*      */     //   #2772	-> 210
/*      */     //   #2773	-> 221
/*      */     //   #2774	-> 228
/*      */     //   #2777	-> 235
/*      */     //   #2780	-> 262
/*      */     //   #2781	-> 269
/*      */     //   #2784	-> 292
/*      */     //   #2785	-> 316
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
/*      */   private o au() {
/* 2792 */     byte b1 = 0;
/* 2793 */     char[] arrayOfChar = this.o.h();
/*      */ 
/*      */     
/* 2796 */     int[] arrayOfInt = M;
/* 2797 */     byte[] arrayOfByte = this.X;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     while (true)
/* 2804 */     { if (this.e >= this.f) {
/* 2805 */         ar();
/*      */       }
/* 2807 */       if (b1 >= arrayOfChar.length) {
/* 2808 */         arrayOfChar = this.o.j();
/* 2809 */         b1 = 0;
/*      */       } 
/* 2811 */       int j = this.f;
/*      */       
/*      */       int i;
/* 2814 */       if ((i = this.e + arrayOfChar.length - b1) < j) {
/* 2815 */         j = i;
/*      */       }
/*      */       
/* 2818 */       while (this.e < j)
/*      */       
/* 2820 */       { if ((i = arrayOfByte[this.e++] & 0xFF) != 39) {
/*      */ 
/*      */           
/* 2823 */           if (arrayOfInt[i] == 0 || i == 34) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 2829 */             arrayOfChar[b1++] = (char)i;
/*      */             
/*      */             continue;
/*      */           } 
/* 2833 */           switch (arrayOfInt[i]) {
/*      */             case 1:
/* 2835 */               i = af();
/*      */               break;
/*      */             case 2:
/* 2838 */               i = p(i);
/*      */               break;
/*      */             case 3:
/* 2841 */               if (this.f - this.e >= 2) {
/* 2842 */                 i = r(i); break;
/*      */               } 
/* 2844 */               i = q(i);
/*      */               break;
/*      */             
/*      */             case 4:
/* 2848 */               i = s(i);
/*      */               
/* 2850 */               arrayOfChar[b1++] = (char)(0xD800 | i >> 10);
/* 2851 */               if (b1 >= arrayOfChar.length) {
/* 2852 */                 arrayOfChar = this.o.j();
/* 2853 */                 b1 = 0;
/*      */               } 
/* 2855 */               i = 0xDC00 | i & 0x3FF;
/*      */               break;
/*      */             
/*      */             default:
/* 2859 */               if (i < 32) {
/* 2860 */                 a(i, "string value");
/*      */               }
/*      */               
/* 2863 */               t(i);
/*      */               break;
/*      */           } 
/* 2866 */           if (b1 >= arrayOfChar.length) {
/* 2867 */             arrayOfChar = this.o.j();
/* 2868 */             b1 = 0;
/*      */           } 
/*      */           
/* 2871 */           arrayOfChar[b1++] = (char)i; continue;
/*      */         } 
/* 2873 */         this.o.a(b1);
/*      */         
/* 2875 */         return o.h; }  }  this.o.a(b1); return o.h;
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
/*      */   private o a(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
/* 2893 */     while (paramInt == 73) {
/* 2894 */       String str1; if (this.e >= this.f && 
/* 2895 */         !am()) {
/* 2896 */         b(o.j);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/* 2901 */       if ((paramInt = this.X[this.e++]) == 78) {
/* 2902 */         str1 = paramBoolean1 ? "-INF" : "+INF";
/* 2903 */       } else if (paramInt == 110) {
/* 2904 */         str1 = paramBoolean1 ? "-Infinity" : "+Infinity";
/*      */       } else {
/*      */         break;
/*      */       } 
/* 2908 */       a(str1, 3);
/* 2909 */       if ((this.b & G) != 0) {
/* 2910 */         return a(str1, paramBoolean1 ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);
/*      */       }
/* 2912 */       a("Non-standard token '%s': enable `JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS` to allow", str1);
/*      */     } 
/*      */     
/* 2915 */     if (!a(e.e.c()) && !paramBoolean1) {
/* 2916 */       b(43, "JSON spec does not allow numbers to have plus signs: enable `JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS` to allow");
/*      */     }
/* 2918 */     String str = paramBoolean1 ? "expected digit (0-9) to follow minus sign, for valid numeric value" : "expected digit (0-9) for valid numeric value";
/*      */ 
/*      */     
/* 2921 */     b(paramInt, str);
/* 2922 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   private void av() {
/*      */     int i;
/*      */     byte[] arrayOfByte;
/* 2929 */     if ((i = this.e) + 3 < this.f && (
/*      */       
/* 2931 */       arrayOfByte = this.X)[i++] == 114 && arrayOfByte[i++] == 117 && arrayOfByte[i++] == 101) {
/*      */       int j;
/*      */ 
/*      */       
/* 2935 */       if ((j = arrayOfByte[i] & 0xFF) < 48 || j == 93 || j == 125) {
/* 2936 */         this.e = i;
/*      */         
/*      */         return;
/*      */       } 
/*      */     } 
/* 2941 */     b("true", 1);
/*      */   }
/*      */   
/*      */   private void aw() {
/*      */     int i;
/*      */     byte[] arrayOfByte;
/* 2947 */     if ((i = this.e) + 4 < this.f && (
/*      */       
/* 2949 */       arrayOfByte = this.X)[i++] == 97 && arrayOfByte[i++] == 108 && arrayOfByte[i++] == 115 && arrayOfByte[i++] == 101) {
/*      */       int j;
/*      */ 
/*      */ 
/*      */       
/* 2954 */       if ((j = arrayOfByte[i] & 0xFF) < 48 || j == 93 || j == 125) {
/* 2955 */         this.e = i;
/*      */         
/*      */         return;
/*      */       } 
/*      */     } 
/* 2960 */     b("false", 1);
/*      */   }
/*      */   
/*      */   private void ax() {
/*      */     int i;
/*      */     byte[] arrayOfByte;
/* 2966 */     if ((i = this.e) + 3 < this.f && (
/*      */       
/* 2968 */       arrayOfByte = this.X)[i++] == 117 && arrayOfByte[i++] == 108 && arrayOfByte[i++] == 108) {
/*      */       int j;
/*      */ 
/*      */       
/* 2972 */       if ((j = arrayOfByte[i] & 0xFF) < 48 || j == 93 || j == 125) {
/* 2973 */         this.e = i;
/*      */         
/*      */         return;
/*      */       } 
/*      */     } 
/* 2978 */     b("null", 1);
/*      */   }
/*      */ 
/*      */   
/*      */   private void a(String paramString, int paramInt) {
/* 2983 */     int i = paramString.length();
/* 2984 */     if (this.e + i >= this.f) {
/* 2985 */       b(paramString, paramInt);
/*      */       return;
/*      */     } 
/*      */     do {
/* 2989 */       if (this.X[this.e] != paramString.charAt(paramInt)) {
/* 2990 */         h(paramString.substring(0, paramInt));
/*      */       }
/* 2992 */       this.e++;
/* 2993 */     } while (++paramInt < i);
/*      */ 
/*      */     
/* 2996 */     if ((i = this.X[this.e] & 0xFF) >= 48 && i != 93 && i != 125) {
/* 2997 */       a(paramString, paramInt, i);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private final void b(String paramString, int paramInt) {
/* 3003 */     int i = paramString.length();
/*      */     do {
/* 3005 */       if ((this.e >= this.f && !am()) || this.X[this.e] != paramString
/* 3006 */         .charAt(paramInt)) {
/* 3007 */         h(paramString.substring(0, paramInt));
/*      */       }
/* 3009 */       this.e++;
/* 3010 */     } while (++paramInt < i);
/*      */ 
/*      */     
/* 3013 */     if (this.e >= this.f && !am()) {
/*      */       return;
/*      */     }
/*      */     
/* 3017 */     if ((i = this.X[this.e] & 0xFF) >= 48 && i != 93 && i != 125) {
/* 3018 */       a(paramString, paramInt, i);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private final void a(String paramString, int paramInt1, int paramInt2) {
/* 3025 */     if (Character.isJavaIdentifierPart(paramInt2 = (char)o(paramInt2))) {
/* 3026 */       h(paramString.substring(0, paramInt1));
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
/*      */   private final int ay() {
/* 3038 */     while (this.e < this.f) {
/*      */       int i;
/* 3040 */       if ((i = this.X[this.e++] & 0xFF) > 32) {
/* 3041 */         if (i == 47 || i == 35) {
/* 3042 */           this.e--;
/* 3043 */           return az();
/*      */         } 
/* 3045 */         return i;
/*      */       } 
/* 3047 */       if (i != 32) {
/* 3048 */         if (i == 10) {
/* 3049 */           this.h++;
/* 3050 */           this.i = this.e; continue;
/* 3051 */         }  if (i == 13) {
/* 3052 */           aK(); continue;
/* 3053 */         }  if (i != 9) {
/* 3054 */           f(i);
/*      */         }
/*      */       } 
/*      */     } 
/* 3058 */     return az();
/*      */   }
/*      */ 
/*      */   
/*      */   private final int az() {
/* 3063 */     while (this.e < this.f || am()) {
/*      */       int i;
/* 3065 */       if ((i = this.X[this.e++] & 0xFF) > 32) {
/* 3066 */         if (i == 47) {
/* 3067 */           aD();
/*      */           continue;
/*      */         } 
/* 3070 */         if (i != 35 || 
/* 3071 */           !aF())
/*      */         {
/*      */ 
/*      */           
/* 3075 */           return i; }  continue;
/*      */       } 
/* 3077 */       if (i != 32) {
/* 3078 */         if (i == 10) {
/* 3079 */           this.h++;
/* 3080 */           this.i = this.e; continue;
/* 3081 */         }  if (i == 13) {
/* 3082 */           aK(); continue;
/* 3083 */         }  if (i != 9) {
/* 3084 */           f(i);
/*      */         }
/*      */       } 
/*      */     } 
/* 3088 */     throw b("Unexpected end-of-input within/between " + this.m.e() + " entries");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final int aA() {
/* 3095 */     if (this.e >= this.f && 
/* 3096 */       !am()) {
/* 3097 */       return Z();
/*      */     }
/*      */     
/*      */     int i;
/* 3101 */     if ((i = this.X[this.e++] & 0xFF) > 32) {
/* 3102 */       if (i == 47 || i == 35) {
/* 3103 */         this.e--;
/* 3104 */         return aB();
/*      */       } 
/* 3106 */       return i;
/*      */     } 
/* 3108 */     if (i != 32) {
/* 3109 */       if (i == 10) {
/* 3110 */         this.h++;
/* 3111 */         this.i = this.e;
/* 3112 */       } else if (i == 13) {
/* 3113 */         aK();
/* 3114 */       } else if (i != 9) {
/* 3115 */         f(i);
/*      */       } 
/*      */     }
/*      */     
/* 3119 */     while (this.e < this.f) {
/*      */       
/* 3121 */       if ((i = this.X[this.e++] & 0xFF) > 32) {
/* 3122 */         if (i == 47 || i == 35) {
/* 3123 */           this.e--;
/* 3124 */           return aB();
/*      */         } 
/* 3126 */         return i;
/*      */       } 
/* 3128 */       if (i != 32) {
/* 3129 */         if (i == 10) {
/* 3130 */           this.h++;
/* 3131 */           this.i = this.e; continue;
/* 3132 */         }  if (i == 13) {
/* 3133 */           aK(); continue;
/* 3134 */         }  if (i != 9) {
/* 3135 */           f(i);
/*      */         }
/*      */       } 
/*      */     } 
/* 3139 */     return aB();
/*      */   }
/*      */ 
/*      */   
/*      */   private final int aB() {
/* 3144 */     while (this.e < this.f || am()) {
/*      */       int i;
/* 3146 */       if ((i = this.X[this.e++] & 0xFF) > 32) {
/* 3147 */         if (i == 47) {
/* 3148 */           aD();
/*      */           continue;
/*      */         } 
/* 3151 */         if (i != 35 || 
/* 3152 */           !aF())
/*      */         {
/*      */ 
/*      */           
/* 3156 */           return i; }  continue;
/* 3157 */       }  if (i != 32) {
/* 3158 */         if (i == 10) {
/* 3159 */           this.h++;
/* 3160 */           this.i = this.e; continue;
/* 3161 */         }  if (i == 13) {
/* 3162 */           aK(); continue;
/* 3163 */         }  if (i != 9) {
/* 3164 */           f(i);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 3169 */     return Z();
/*      */   }
/*      */ 
/*      */   
/*      */   private final int aC() {
/* 3174 */     if (this.e + 4 >= this.f) {
/* 3175 */       return c(false);
/*      */     }
/*      */     
/*      */     byte b1;
/* 3179 */     if ((b1 = this.X[this.e]) == 58) {
/*      */       
/* 3181 */       if ((b1 = this.X[++this.e]) > 32) {
/* 3182 */         if (b1 == 47 || b1 == 35) {
/* 3183 */           return c(true);
/*      */         }
/* 3185 */         this.e++;
/* 3186 */         return b1;
/*      */       } 
/* 3188 */       if ((b1 == 32 || b1 == 9) && (
/*      */         
/* 3190 */         b1 = this.X[++this.e]) > 32) {
/* 3191 */         if (b1 == 47 || b1 == 35) {
/* 3192 */           return c(true);
/*      */         }
/* 3194 */         this.e++;
/* 3195 */         return b1;
/*      */       } 
/*      */       
/* 3198 */       return c(true);
/*      */     } 
/* 3200 */     if (b1 == 32 || b1 == 9) {
/* 3201 */       b1 = this.X[++this.e];
/*      */     }
/* 3203 */     if (b1 == 58) {
/*      */       
/* 3205 */       if ((b1 = this.X[++this.e]) > 32) {
/* 3206 */         if (b1 == 47 || b1 == 35) {
/* 3207 */           return c(true);
/*      */         }
/* 3209 */         this.e++;
/* 3210 */         return b1;
/*      */       } 
/* 3212 */       if ((b1 == 32 || b1 == 9) && (
/*      */         
/* 3214 */         b1 = this.X[++this.e]) > 32) {
/* 3215 */         if (b1 == 47 || b1 == 35) {
/* 3216 */           return c(true);
/*      */         }
/* 3218 */         this.e++;
/* 3219 */         return b1;
/*      */       } 
/*      */       
/* 3222 */       return c(true);
/*      */     } 
/* 3224 */     return c(false);
/*      */   }
/*      */ 
/*      */   
/*      */   private final int c(boolean paramBoolean) {
/* 3229 */     while (this.e < this.f || am()) {
/*      */       int i;
/*      */       
/* 3232 */       if ((i = this.X[this.e++] & 0xFF) > 32) {
/* 3233 */         if (i == 47) {
/* 3234 */           aD();
/*      */           continue;
/*      */         } 
/* 3237 */         if (i != 35 || 
/* 3238 */           !aF())
/*      */         
/*      */         { 
/*      */           
/* 3242 */           if (paramBoolean) {
/* 3243 */             return i;
/*      */           }
/* 3245 */           if (i != 58) {
/* 3246 */             c(i, "was expecting a colon to separate field name and value");
/*      */           }
/* 3248 */           paramBoolean = true; }  continue;
/* 3249 */       }  if (i != 32) {
/* 3250 */         if (i == 10) {
/* 3251 */           this.h++;
/* 3252 */           this.i = this.e; continue;
/* 3253 */         }  if (i == 13) {
/* 3254 */           aK(); continue;
/* 3255 */         }  if (i != 9) {
/* 3256 */           f(i);
/*      */         }
/*      */       } 
/*      */     } 
/* 3260 */     b(" within/between " + this.m.e() + " entries", (o)null);
/*      */     
/* 3262 */     return -1;
/*      */   }
/*      */ 
/*      */   
/*      */   private final void aD() {
/* 3267 */     if ((this.b & K) == 0) {
/* 3268 */       c(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
/*      */     }
/*      */     
/* 3271 */     if (this.e >= this.f && !am()) {
/* 3272 */       b(" in a comment", (o)null);
/*      */     }
/*      */     int i;
/* 3275 */     if ((i = this.X[this.e++] & 0xFF) == 47) {
/* 3276 */       aG(); return;
/* 3277 */     }  if (i == 42) {
/* 3278 */       aE(); return;
/*      */     } 
/* 3280 */     c(i, "was expecting either '*' or '/' for a comment");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final void aE() {
/* 3287 */     int[] arrayOfInt = b.e();
/*      */ 
/*      */ 
/*      */     
/* 3291 */     while (this.e < this.f || am()) {
/* 3292 */       int i = this.X[this.e++] & 0xFF;
/*      */       int j;
/* 3294 */       if ((j = arrayOfInt[i]) != 0) {
/* 3295 */         switch (j) {
/*      */           case 42:
/* 3297 */             if (this.e < this.f || am()) {
/*      */ 
/*      */               
/* 3300 */               if (this.X[this.e] == 47) {
/* 3301 */                 this.e++; return;
/*      */               }  continue;
/*      */             } 
/*      */             break;
/*      */           case 10:
/* 3306 */             this.h++;
/* 3307 */             this.i = this.e;
/*      */             continue;
/*      */           case 13:
/* 3310 */             aK();
/*      */             continue;
/*      */           case 2:
/* 3313 */             aH();
/*      */             continue;
/*      */           case 3:
/* 3316 */             aI();
/*      */             continue;
/*      */           case 4:
/* 3319 */             aJ();
/*      */             continue;
/*      */         } 
/*      */         
/* 3323 */         t(i);
/*      */       } 
/*      */     } 
/*      */     
/* 3327 */     b(" in a comment", (o)null);
/*      */   }
/*      */ 
/*      */   
/*      */   private final boolean aF() {
/* 3332 */     if ((this.b & L) == 0) {
/* 3333 */       return false;
/*      */     }
/* 3335 */     aG();
/* 3336 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final void aG() {
/* 3344 */     int[] arrayOfInt = b.e();
/* 3345 */     while (this.e < this.f || am()) {
/* 3346 */       int i = this.X[this.e++] & 0xFF;
/*      */       int j;
/* 3348 */       if ((j = arrayOfInt[i]) != 0) {
/* 3349 */         switch (j) {
/*      */           case 10:
/* 3351 */             this.h++;
/* 3352 */             this.i = this.e;
/*      */             return;
/*      */           case 13:
/* 3355 */             aK();
/*      */             return;
/*      */           case 42:
/*      */             continue;
/*      */           case 2:
/* 3360 */             aH();
/*      */             continue;
/*      */           case 3:
/* 3363 */             aI();
/*      */             continue;
/*      */           case 4:
/* 3366 */             aJ();
/*      */             continue;
/*      */         } 
/* 3369 */         if (j < 0)
/*      */         {
/* 3371 */           t(i);
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final char af() {
/* 3381 */     if (this.e >= this.f && 
/* 3382 */       !am()) {
/* 3383 */       b(" in character escape sequence", o.h);
/*      */     }
/*      */     
/*      */     int i;
/*      */     
/* 3388 */     switch (i = this.X[this.e++]) {
/*      */       
/*      */       case 98:
/* 3391 */         return '\b';
/*      */       case 116:
/* 3393 */         return '\t';
/*      */       case 110:
/* 3395 */         return '\n';
/*      */       case 102:
/* 3397 */         return '\f';
/*      */       case 114:
/* 3399 */         return '\r';
/*      */ 
/*      */       
/*      */       case 34:
/*      */       case 47:
/*      */       case 92:
/* 3405 */         return (char)i;
/*      */       
/*      */       case 117:
/*      */         break;
/*      */       
/*      */       default:
/* 3411 */         return a((char)o(i));
/*      */     } 
/*      */ 
/*      */     
/* 3415 */     i = 0;
/* 3416 */     for (byte b1 = 0; b1 < 4; b1++) {
/* 3417 */       if (this.e >= this.f && 
/* 3418 */         !am()) {
/* 3419 */         b(" in character escape sequence", o.h);
/*      */       }
/*      */       
/*      */       byte b2;
/*      */       int j;
/* 3424 */       if ((j = b.b(b2 = this.X[this.e++])) < 0) {
/* 3425 */         c(b2 & 0xFF, "expected a hex-digit for character escape sequence");
/*      */       }
/* 3427 */       i = i << 4 | j;
/*      */     } 
/* 3429 */     return (char)i;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private int o(int paramInt) {
/* 3435 */     if ((paramInt = paramInt & 0xFF) > 127) {
/*      */       byte b1;
/*      */ 
/*      */       
/* 3439 */       if ((paramInt & 0xE0) == 192) {
/* 3440 */         paramInt &= 0x1F;
/* 3441 */         b1 = 1;
/* 3442 */       } else if ((paramInt & 0xF0) == 224) {
/* 3443 */         paramInt &= 0xF;
/* 3444 */         b1 = 2;
/* 3445 */       } else if ((paramInt & 0xF8) == 240) {
/*      */         
/* 3447 */         paramInt &= 0x7;
/* 3448 */         b1 = 3;
/*      */       } else {
/* 3450 */         u(paramInt & 0xFF);
/* 3451 */         b1 = 1;
/*      */       } 
/*      */       
/*      */       int i;
/* 3455 */       if (((i = aL()) & 0xC0) != 128) {
/* 3456 */         v(i & 0xFF);
/*      */       }
/* 3458 */       paramInt = paramInt << 6 | i & 0x3F;
/*      */       
/* 3460 */       if (b1 > 1) {
/*      */         
/* 3462 */         if (((i = aL()) & 0xC0) != 128) {
/* 3463 */           v(i & 0xFF);
/*      */         }
/* 3465 */         paramInt = paramInt << 6 | i & 0x3F;
/* 3466 */         if (b1 > 2) {
/*      */           
/* 3468 */           if (((i = aL()) & 0xC0) != 128) {
/* 3469 */             v(i & 0xFF);
/*      */           }
/* 3471 */           paramInt = paramInt << 6 | i & 0x3F;
/*      */         } 
/*      */       } 
/*      */     } 
/* 3475 */     return paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final int p(int paramInt) {
/* 3486 */     if (this.e >= this.f) {
/* 3487 */       ar();
/*      */     }
/*      */     byte b1;
/* 3490 */     if (((b1 = this.X[this.e++]) & 0xC0) != 128) {
/* 3491 */       e(b1 & 0xFF, this.e);
/*      */     }
/* 3493 */     return (paramInt & 0x1F) << 6 | b1 & 0x3F;
/*      */   }
/*      */ 
/*      */   
/*      */   private final int q(int paramInt) {
/* 3498 */     if (this.e >= this.f) {
/* 3499 */       ar();
/*      */     }
/* 3501 */     paramInt &= 0xF;
/*      */     byte b1;
/* 3503 */     if (((b1 = this.X[this.e++]) & 0xC0) != 128) {
/* 3504 */       e(b1 & 0xFF, this.e);
/*      */     }
/* 3506 */     paramInt = paramInt << 6 | b1 & 0x3F;
/* 3507 */     if (this.e >= this.f) {
/* 3508 */       ar();
/*      */     }
/*      */     
/* 3511 */     if (((b1 = this.X[this.e++]) & 0xC0) != 128) {
/* 3512 */       e(b1 & 0xFF, this.e);
/*      */     }
/*      */     
/* 3515 */     return paramInt = paramInt << 6 | b1 & 0x3F;
/*      */   }
/*      */ 
/*      */   
/*      */   private final int r(int paramInt) {
/* 3520 */     paramInt &= 0xF;
/*      */     byte b1;
/* 3522 */     if (((b1 = this.X[this.e++]) & 0xC0) != 128) {
/* 3523 */       e(b1 & 0xFF, this.e);
/*      */     }
/* 3525 */     paramInt = paramInt << 6 | b1 & 0x3F;
/*      */     
/* 3527 */     if (((b1 = this.X[this.e++]) & 0xC0) != 128) {
/* 3528 */       e(b1 & 0xFF, this.e);
/*      */     }
/*      */     
/* 3531 */     return paramInt = paramInt << 6 | b1 & 0x3F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final int s(int paramInt) {
/* 3538 */     if (this.e >= this.f) {
/* 3539 */       ar();
/*      */     }
/*      */     byte b1;
/* 3542 */     if (((b1 = this.X[this.e++]) & 0xC0) != 128) {
/* 3543 */       e(b1 & 0xFF, this.e);
/*      */     }
/* 3545 */     paramInt = (paramInt & 0x7) << 6 | b1 & 0x3F;
/*      */     
/* 3547 */     if (this.e >= this.f) {
/* 3548 */       ar();
/*      */     }
/*      */     
/* 3551 */     if (((b1 = this.X[this.e++]) & 0xC0) != 128) {
/* 3552 */       e(b1 & 0xFF, this.e);
/*      */     }
/* 3554 */     paramInt = paramInt << 6 | b1 & 0x3F;
/* 3555 */     if (this.e >= this.f) {
/* 3556 */       ar();
/*      */     }
/*      */     
/* 3559 */     if (((b1 = this.X[this.e++]) & 0xC0) != 128) {
/* 3560 */       e(b1 & 0xFF, this.e);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3566 */     return (paramInt << 6 | b1 & 0x3F) - 65536;
/*      */   }
/*      */ 
/*      */   
/*      */   private final void aH() {
/* 3571 */     if (this.e >= this.f) {
/* 3572 */       ar();
/*      */     }
/*      */     byte b1;
/* 3575 */     if (((b1 = this.X[this.e++]) & 0xC0) != 128) {
/* 3576 */       e(b1 & 0xFF, this.e);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final void aI() {
/* 3585 */     if (this.e >= this.f) {
/* 3586 */       ar();
/*      */     }
/*      */     
/*      */     byte b1;
/* 3590 */     if (((b1 = this.X[this.e++]) & 0xC0) != 128) {
/* 3591 */       e(b1 & 0xFF, this.e);
/*      */     }
/* 3593 */     if (this.e >= this.f) {
/* 3594 */       ar();
/*      */     }
/*      */     
/* 3597 */     if (((b1 = this.X[this.e++]) & 0xC0) != 128) {
/* 3598 */       e(b1 & 0xFF, this.e);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private final void aJ() {
/* 3604 */     if (this.e >= this.f) {
/* 3605 */       ar();
/*      */     }
/*      */     byte b1;
/* 3608 */     if (((b1 = this.X[this.e++]) & 0xC0) != 128) {
/* 3609 */       e(b1 & 0xFF, this.e);
/*      */     }
/* 3611 */     if (this.e >= this.f) {
/* 3612 */       ar();
/*      */     }
/*      */     
/* 3615 */     if (((b1 = this.X[this.e++]) & 0xC0) != 128) {
/* 3616 */       e(b1 & 0xFF, this.e);
/*      */     }
/* 3618 */     if (this.e >= this.f) {
/* 3619 */       ar();
/*      */     }
/*      */     
/* 3622 */     if (((b1 = this.X[this.e++]) & 0xC0) != 128) {
/* 3623 */       e(b1 & 0xFF, this.e);
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
/*      */   private void aK() {
/* 3637 */     if ((this.e < this.f || am()) && 
/* 3638 */       this.X[this.e] == 10) {
/* 3639 */       this.e++;
/*      */     }
/*      */     
/* 3642 */     this.h++;
/* 3643 */     this.i = this.e;
/*      */   }
/*      */ 
/*      */   
/*      */   private int aL() {
/* 3648 */     if (this.e >= this.f) {
/* 3649 */       ar();
/*      */     }
/* 3651 */     return this.X[this.e++] & 0xFF;
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
/*      */   private void h(String paramString) {
/* 3666 */     a(paramString, ad());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(String paramString1, String paramString2) {
/* 3675 */     StringBuilder stringBuilder = new StringBuilder(paramString1);
/*      */     
/* 3677 */     byte b1 = this.X[this.e++];
/*      */     char c;
/* 3679 */     while ((this.e < this.f || am()) && Character.isJavaIdentifierPart(c = (char)o(b1))) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3687 */       stringBuilder.append(c);
/* 3688 */       if (stringBuilder.length() >= 256) {
/* 3689 */         stringBuilder.append("...");
/*      */         break;
/*      */       } 
/*      */     } 
/* 3693 */     a("Unrecognized token '%s': was expecting %s", stringBuilder, paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void t(int paramInt) {
/* 3699 */     if (paramInt < 32) {
/* 3700 */       f(paramInt);
/*      */     }
/* 3702 */     u(paramInt);
/*      */   }
/*      */   
/*      */   private void u(int paramInt) {
/* 3706 */     g("Invalid UTF-8 start byte 0x" + Integer.toHexString(paramInt));
/*      */   }
/*      */   
/*      */   private void v(int paramInt) {
/* 3710 */     g("Invalid UTF-8 middle byte 0x" + Integer.toHexString(paramInt));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void e(int paramInt1, int paramInt2) {
/* 3716 */     this.e = paramInt2;
/* 3717 */     v(paramInt1);
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
/*      */   private byte[] c(a parama) {
/*      */     // Byte code:
/*      */     //   0: aload_0
/*      */     //   1: invokevirtual aa : ()Lcom/a/a/b/g/c;
/*      */     //   4: astore_2
/*      */     //   5: aload_0
/*      */     //   6: getfield e : I
/*      */     //   9: aload_0
/*      */     //   10: getfield f : I
/*      */     //   13: if_icmplt -> 20
/*      */     //   16: aload_0
/*      */     //   17: invokevirtual ar : ()V
/*      */     //   20: aload_0
/*      */     //   21: getfield X : [B
/*      */     //   24: aload_0
/*      */     //   25: dup
/*      */     //   26: getfield e : I
/*      */     //   29: dup_x1
/*      */     //   30: iconst_1
/*      */     //   31: iadd
/*      */     //   32: putfield e : I
/*      */     //   35: baload
/*      */     //   36: sipush #255
/*      */     //   39: iand
/*      */     //   40: dup
/*      */     //   41: istore_3
/*      */     //   42: bipush #32
/*      */     //   44: if_icmple -> 5
/*      */     //   47: aload_1
/*      */     //   48: iload_3
/*      */     //   49: invokevirtual b : (I)I
/*      */     //   52: dup
/*      */     //   53: istore #4
/*      */     //   55: ifge -> 82
/*      */     //   58: iload_3
/*      */     //   59: bipush #34
/*      */     //   61: if_icmpne -> 69
/*      */     //   64: aload_2
/*      */     //   65: invokevirtual b : ()[B
/*      */     //   68: areturn
/*      */     //   69: aload_0
/*      */     //   70: aload_1
/*      */     //   71: iload_3
/*      */     //   72: iconst_0
/*      */     //   73: invokevirtual a : (Lcom/a/a/b/a;II)I
/*      */     //   76: dup
/*      */     //   77: istore #4
/*      */     //   79: iflt -> 5
/*      */     //   82: iload #4
/*      */     //   84: istore #5
/*      */     //   86: aload_0
/*      */     //   87: getfield e : I
/*      */     //   90: aload_0
/*      */     //   91: getfield f : I
/*      */     //   94: if_icmplt -> 101
/*      */     //   97: aload_0
/*      */     //   98: invokevirtual ar : ()V
/*      */     //   101: aload_0
/*      */     //   102: getfield X : [B
/*      */     //   105: aload_0
/*      */     //   106: dup
/*      */     //   107: getfield e : I
/*      */     //   110: dup_x1
/*      */     //   111: iconst_1
/*      */     //   112: iadd
/*      */     //   113: putfield e : I
/*      */     //   116: baload
/*      */     //   117: sipush #255
/*      */     //   120: iand
/*      */     //   121: istore_3
/*      */     //   122: aload_1
/*      */     //   123: iload_3
/*      */     //   124: invokevirtual b : (I)I
/*      */     //   127: dup
/*      */     //   128: istore #4
/*      */     //   130: ifge -> 142
/*      */     //   133: aload_0
/*      */     //   134: aload_1
/*      */     //   135: iload_3
/*      */     //   136: iconst_1
/*      */     //   137: invokevirtual a : (Lcom/a/a/b/a;II)I
/*      */     //   140: istore #4
/*      */     //   142: iload #5
/*      */     //   144: bipush #6
/*      */     //   146: ishl
/*      */     //   147: iload #4
/*      */     //   149: ior
/*      */     //   150: istore #5
/*      */     //   152: aload_0
/*      */     //   153: getfield e : I
/*      */     //   156: aload_0
/*      */     //   157: getfield f : I
/*      */     //   160: if_icmplt -> 167
/*      */     //   163: aload_0
/*      */     //   164: invokevirtual ar : ()V
/*      */     //   167: aload_0
/*      */     //   168: getfield X : [B
/*      */     //   171: aload_0
/*      */     //   172: dup
/*      */     //   173: getfield e : I
/*      */     //   176: dup_x1
/*      */     //   177: iconst_1
/*      */     //   178: iadd
/*      */     //   179: putfield e : I
/*      */     //   182: baload
/*      */     //   183: sipush #255
/*      */     //   186: iand
/*      */     //   187: istore_3
/*      */     //   188: aload_1
/*      */     //   189: iload_3
/*      */     //   190: invokevirtual b : (I)I
/*      */     //   193: dup
/*      */     //   194: istore #4
/*      */     //   196: ifge -> 369
/*      */     //   199: iload #4
/*      */     //   201: bipush #-2
/*      */     //   203: if_icmpeq -> 260
/*      */     //   206: iload_3
/*      */     //   207: bipush #34
/*      */     //   209: if_icmpne -> 251
/*      */     //   212: iload #5
/*      */     //   214: iconst_4
/*      */     //   215: ishr
/*      */     //   216: istore #5
/*      */     //   218: aload_2
/*      */     //   219: iload #5
/*      */     //   221: invokevirtual a : (I)V
/*      */     //   224: aload_1
/*      */     //   225: invokevirtual a : ()Z
/*      */     //   228: ifeq -> 246
/*      */     //   231: aload_0
/*      */     //   232: dup
/*      */     //   233: getfield e : I
/*      */     //   236: iconst_1
/*      */     //   237: isub
/*      */     //   238: putfield e : I
/*      */     //   241: aload_0
/*      */     //   242: aload_1
/*      */     //   243: invokevirtual b : (Lcom/a/a/b/a;)V
/*      */     //   246: aload_2
/*      */     //   247: invokevirtual b : ()[B
/*      */     //   250: areturn
/*      */     //   251: aload_0
/*      */     //   252: aload_1
/*      */     //   253: iload_3
/*      */     //   254: iconst_2
/*      */     //   255: invokevirtual a : (Lcom/a/a/b/a;II)I
/*      */     //   258: istore #4
/*      */     //   260: iload #4
/*      */     //   262: bipush #-2
/*      */     //   264: if_icmpne -> 369
/*      */     //   267: aload_0
/*      */     //   268: getfield e : I
/*      */     //   271: aload_0
/*      */     //   272: getfield f : I
/*      */     //   275: if_icmplt -> 282
/*      */     //   278: aload_0
/*      */     //   279: invokevirtual ar : ()V
/*      */     //   282: aload_0
/*      */     //   283: getfield X : [B
/*      */     //   286: aload_0
/*      */     //   287: dup
/*      */     //   288: getfield e : I
/*      */     //   291: dup_x1
/*      */     //   292: iconst_1
/*      */     //   293: iadd
/*      */     //   294: putfield e : I
/*      */     //   297: baload
/*      */     //   298: sipush #255
/*      */     //   301: iand
/*      */     //   302: istore_3
/*      */     //   303: aload_1
/*      */     //   304: iload_3
/*      */     //   305: invokevirtual a : (I)Z
/*      */     //   308: ifne -> 354
/*      */     //   311: aload_0
/*      */     //   312: aload_1
/*      */     //   313: iload_3
/*      */     //   314: iconst_3
/*      */     //   315: invokevirtual a : (Lcom/a/a/b/a;II)I
/*      */     //   318: bipush #-2
/*      */     //   320: if_icmpeq -> 354
/*      */     //   323: aload_1
/*      */     //   324: iload_3
/*      */     //   325: iconst_3
/*      */     //   326: new java/lang/StringBuilder
/*      */     //   329: dup
/*      */     //   330: ldc 'expected padding character ''
/*      */     //   332: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   335: aload_1
/*      */     //   336: invokevirtual b : ()C
/*      */     //   339: invokevirtual append : (C)Ljava/lang/StringBuilder;
/*      */     //   342: ldc '''
/*      */     //   344: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   347: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   350: invokestatic a : (Lcom/a/a/b/a;IILjava/lang/String;)Ljava/lang/IllegalArgumentException;
/*      */     //   353: athrow
/*      */     //   354: iload #5
/*      */     //   356: iconst_4
/*      */     //   357: ishr
/*      */     //   358: istore #5
/*      */     //   360: aload_2
/*      */     //   361: iload #5
/*      */     //   363: invokevirtual a : (I)V
/*      */     //   366: goto -> 5
/*      */     //   369: iload #5
/*      */     //   371: bipush #6
/*      */     //   373: ishl
/*      */     //   374: iload #4
/*      */     //   376: ior
/*      */     //   377: istore #5
/*      */     //   379: aload_0
/*      */     //   380: getfield e : I
/*      */     //   383: aload_0
/*      */     //   384: getfield f : I
/*      */     //   387: if_icmplt -> 394
/*      */     //   390: aload_0
/*      */     //   391: invokevirtual ar : ()V
/*      */     //   394: aload_0
/*      */     //   395: getfield X : [B
/*      */     //   398: aload_0
/*      */     //   399: dup
/*      */     //   400: getfield e : I
/*      */     //   403: dup_x1
/*      */     //   404: iconst_1
/*      */     //   405: iadd
/*      */     //   406: putfield e : I
/*      */     //   409: baload
/*      */     //   410: sipush #255
/*      */     //   413: iand
/*      */     //   414: istore_3
/*      */     //   415: aload_1
/*      */     //   416: iload_3
/*      */     //   417: invokevirtual b : (I)I
/*      */     //   420: dup
/*      */     //   421: istore #4
/*      */     //   423: ifge -> 509
/*      */     //   426: iload #4
/*      */     //   428: bipush #-2
/*      */     //   430: if_icmpeq -> 487
/*      */     //   433: iload_3
/*      */     //   434: bipush #34
/*      */     //   436: if_icmpne -> 478
/*      */     //   439: iload #5
/*      */     //   441: iconst_2
/*      */     //   442: ishr
/*      */     //   443: istore #5
/*      */     //   445: aload_2
/*      */     //   446: iload #5
/*      */     //   448: invokevirtual b : (I)V
/*      */     //   451: aload_1
/*      */     //   452: invokevirtual a : ()Z
/*      */     //   455: ifeq -> 473
/*      */     //   458: aload_0
/*      */     //   459: dup
/*      */     //   460: getfield e : I
/*      */     //   463: iconst_1
/*      */     //   464: isub
/*      */     //   465: putfield e : I
/*      */     //   468: aload_0
/*      */     //   469: aload_1
/*      */     //   470: invokevirtual b : (Lcom/a/a/b/a;)V
/*      */     //   473: aload_2
/*      */     //   474: invokevirtual b : ()[B
/*      */     //   477: areturn
/*      */     //   478: aload_0
/*      */     //   479: aload_1
/*      */     //   480: iload_3
/*      */     //   481: iconst_3
/*      */     //   482: invokevirtual a : (Lcom/a/a/b/a;II)I
/*      */     //   485: istore #4
/*      */     //   487: iload #4
/*      */     //   489: bipush #-2
/*      */     //   491: if_icmpne -> 509
/*      */     //   494: iload #5
/*      */     //   496: iconst_2
/*      */     //   497: ishr
/*      */     //   498: istore #5
/*      */     //   500: aload_2
/*      */     //   501: iload #5
/*      */     //   503: invokevirtual b : (I)V
/*      */     //   506: goto -> 5
/*      */     //   509: iload #5
/*      */     //   511: bipush #6
/*      */     //   513: ishl
/*      */     //   514: iload #4
/*      */     //   516: ior
/*      */     //   517: istore #5
/*      */     //   519: aload_2
/*      */     //   520: iload #5
/*      */     //   522: invokevirtual c : (I)V
/*      */     //   525: goto -> 5
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #3740	-> 0
/*      */     //   #3746	-> 5
/*      */     //   #3747	-> 16
/*      */     //   #3749	-> 20
/*      */     //   #3750	-> 41
/*      */     //   #3751	-> 47
/*      */     //   #3752	-> 53
/*      */     //   #3753	-> 58
/*      */     //   #3754	-> 64
/*      */     //   #3756	-> 69
/*      */     //   #3757	-> 77
/*      */     //   #3761	-> 82
/*      */     //   #3765	-> 86
/*      */     //   #3766	-> 97
/*      */     //   #3768	-> 101
/*      */     //   #3769	-> 122
/*      */     //   #3770	-> 128
/*      */     //   #3771	-> 133
/*      */     //   #3773	-> 142
/*      */     //   #3776	-> 152
/*      */     //   #3777	-> 163
/*      */     //   #3779	-> 167
/*      */     //   #3780	-> 188
/*      */     //   #3783	-> 194
/*      */     //   #3784	-> 199
/*      */     //   #3786	-> 206
/*      */     //   #3787	-> 212
/*      */     //   #3788	-> 218
/*      */     //   #3789	-> 224
/*      */     //   #3790	-> 231
/*      */     //   #3791	-> 241
/*      */     //   #3793	-> 246
/*      */     //   #3795	-> 251
/*      */     //   #3797	-> 260
/*      */     //   #3799	-> 267
/*      */     //   #3800	-> 278
/*      */     //   #3802	-> 282
/*      */     //   #3803	-> 303
/*      */     //   #3804	-> 311
/*      */     //   #3805	-> 323
/*      */     //   #3809	-> 354
/*      */     //   #3810	-> 360
/*      */     //   #3811	-> 366
/*      */     //   #3815	-> 369
/*      */     //   #3817	-> 379
/*      */     //   #3818	-> 390
/*      */     //   #3820	-> 394
/*      */     //   #3821	-> 415
/*      */     //   #3822	-> 421
/*      */     //   #3823	-> 426
/*      */     //   #3825	-> 433
/*      */     //   #3826	-> 439
/*      */     //   #3827	-> 445
/*      */     //   #3828	-> 451
/*      */     //   #3829	-> 458
/*      */     //   #3830	-> 468
/*      */     //   #3832	-> 473
/*      */     //   #3834	-> 478
/*      */     //   #3836	-> 487
/*      */     //   #3840	-> 494
/*      */     //   #3841	-> 500
/*      */     //   #3842	-> 506
/*      */     //   #3846	-> 509
/*      */     //   #3847	-> 519
/*      */     //   #3848	-> 525
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
/*      */   public final j f() {
/* 3861 */     if (this.D == o.f) {
/* 3862 */       long l = this.g + (this.T - 1);
/* 3863 */       return new j(ag(), l, -1L, this.U, this.V);
/*      */     } 
/*      */     
/* 3866 */     return new j(ag(), this.j - 1L, -1L, this.k, this.l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final j e() {
/* 3874 */     int i = this.e - this.i + 1;
/* 3875 */     return new j(ag(), this.g + this.e, -1L, this.h, i);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final void aM() {
/* 3883 */     this.k = this.h;
/* 3884 */     int i = this.e;
/* 3885 */     this.j = this.g + i;
/* 3886 */     this.l = i - this.i;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private final void aN() {
/* 3892 */     this.U = this.h;
/* 3893 */     int i = this.e;
/* 3894 */     this.T = i;
/* 3895 */     this.V = i - this.i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final o w(int paramInt) {
/* 3905 */     if (paramInt == 125) {
/* 3906 */       aP();
/* 3907 */       return this.D = o.c;
/*      */     } 
/* 3909 */     aO();
/* 3910 */     return this.D = o.e;
/*      */   }
/*      */   
/*      */   private final void aO() {
/* 3914 */     aM();
/* 3915 */     if (!this.m.b()) {
/* 3916 */       a(93, '}');
/*      */     }
/* 3918 */     this.m = this.m.j();
/*      */   }
/*      */   
/*      */   private final void aP() {
/* 3922 */     aM();
/* 3923 */     if (!this.m.d()) {
/* 3924 */       a(125, ']');
/*      */     }
/* 3926 */     this.m = this.m.j();
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\d\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */