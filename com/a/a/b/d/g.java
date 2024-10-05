/*      */ package com.a.a.b.d;
/*      */ 
/*      */ import com.a.a.b.a;
/*      */ import com.a.a.b.a.b;
/*      */ import com.a.a.b.c.a;
/*      */ import com.a.a.b.c.b;
/*      */ import com.a.a.b.e.b;
/*      */ import com.a.a.b.g.c;
/*      */ import com.a.a.b.g.i;
/*      */ import com.a.a.b.g.o;
/*      */ import com.a.a.b.j;
/*      */ import com.a.a.b.l;
/*      */ import com.a.a.b.o;
/*      */ import com.a.a.b.p;
/*      */ import com.a.a.b.s;
/*      */ import java.io.IOException;
/*      */ import java.io.OutputStream;
/*      */ import java.io.Reader;
/*      */ 
/*      */ public final class g
/*      */   extends b
/*      */ {
/*   23 */   private static final int E = l.a.n.c();
/*      */ 
/*      */   
/*   26 */   private static final int F = l.a.h.c();
/*      */ 
/*      */   
/*   29 */   private static final int G = l.a.l.c();
/*      */ 
/*      */   
/*   32 */   private static final int H = l.a.m.c();
/*   33 */   private static final int I = l.a.e.c();
/*   34 */   private static final int J = l.a.d.c();
/*      */   
/*   36 */   private static final int K = l.a.b.c();
/*   37 */   private static final int L = l.a.c.c();
/*      */ 
/*      */ 
/*      */   
/*   41 */   private static int[] M = b.a();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Reader N;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private char[] O;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean P;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private p Q;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private b R;
/*      */ 
/*      */ 
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
/*      */   private boolean T;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private long U;
/*      */ 
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
/*      */   private int W;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public g(a parama, int paramInt, Reader paramReader, p paramp, b paramb) {
/*  172 */     super(parama, paramInt);
/*  173 */     this.N = paramReader;
/*  174 */     this.O = parama.g();
/*  175 */     this.e = 0;
/*  176 */     this.f = 0;
/*  177 */     this.Q = paramp;
/*  178 */     this.R = paramb;
/*  179 */     this.S = paramb.c();
/*  180 */     this.P = true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final p a() {
/*  189 */     return this.Q;
/*      */   }
/*      */ 
/*      */   
/*      */   public final i<s> c() {
/*  194 */     return c;
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
/*      */   private char c(String paramString, o paramo) {
/*  216 */     if (this.e >= this.f && 
/*  217 */       !an()) {
/*  218 */       b(paramString, paramo);
/*      */     }
/*      */     
/*  221 */     return this.O[this.e++];
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
/*      */   protected final void W() {
/*  233 */     if (this.N != null) {
/*  234 */       if (this.d.b() || a(l.a.a)) {
/*  235 */         this.N.close();
/*      */       }
/*  237 */       this.N = null;
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
/*  250 */     super.X();
/*      */     
/*  252 */     this.R.b();
/*      */     char[] arrayOfChar;
/*  254 */     if (this.P && (
/*      */       
/*  256 */       arrayOfChar = this.O) != null) {
/*  257 */       this.O = null;
/*  258 */       this.d.a(arrayOfChar);
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
/*      */   private void am() {
/*  270 */     if (!an()) ak();
/*      */   
/*      */   }
/*      */   
/*      */   private boolean an() {
/*  275 */     if (this.N != null) {
/*      */       int i;
/*  277 */       if ((i = this.N.read(this.O, 0, this.O.length)) > 0) {
/*  278 */         int j = this.f;
/*  279 */         this.g += j;
/*  280 */         this.i -= j;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  285 */         this.U -= j;
/*      */         
/*  287 */         this.e = 0;
/*  288 */         this.f = i;
/*      */         
/*  290 */         return true;
/*      */       } 
/*      */       
/*  293 */       W();
/*      */       
/*  295 */       if (i == 0) {
/*  296 */         throw new IOException("Reader returned 0 characters when trying to read " + this.f);
/*      */       }
/*      */     } 
/*  299 */     return false;
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
/*      */   public final String w() {
/*  317 */     if (this.D == o.h) {
/*  318 */       if (this.T) {
/*  319 */         this.T = false;
/*  320 */         ah();
/*      */       } 
/*  322 */       return this.o.e();
/*      */     } 
/*  324 */     return c(this.D);
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
/*  360 */     if (this.D == o.h) {
/*  361 */       if (this.T) {
/*  362 */         this.T = false;
/*  363 */         ah();
/*      */       } 
/*  365 */       return this.o.e();
/*      */     } 
/*  367 */     if (this.D == o.f) {
/*  368 */       return u();
/*      */     }
/*  370 */     return super.a(null);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final String a(String paramString) {
/*  376 */     if (this.D == o.h) {
/*  377 */       if (this.T) {
/*  378 */         this.T = false;
/*  379 */         ah();
/*      */       } 
/*  381 */       return this.o.e();
/*      */     } 
/*  383 */     if (this.D == o.f) {
/*  384 */       return u();
/*      */     }
/*  386 */     return super.a(paramString);
/*      */   }
/*      */   
/*      */   private String c(o paramo) {
/*  390 */     if (paramo == null) {
/*  391 */       return null;
/*      */     }
/*  393 */     switch (paramo.a()) {
/*      */       case 5:
/*  395 */         return this.m.g();
/*      */ 
/*      */       
/*      */       case 6:
/*      */       case 7:
/*      */       case 8:
/*  401 */         return this.o.e();
/*      */     } 
/*  403 */     return paramo.b();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final char[] x() {
/*  410 */     if (this.D != null) {
/*  411 */       switch (this.D.a()) {
/*      */         case 5:
/*  413 */           if (!this.q) {
/*      */             String str;
/*  415 */             int i = (str = this.m.g()).length();
/*  416 */             if (this.p == null) {
/*  417 */               this.p = this.d.a(i);
/*  418 */             } else if (this.p.length < i) {
/*  419 */               this.p = new char[i];
/*      */             } 
/*  421 */             str.getChars(0, i, this.p, 0);
/*  422 */             this.q = true;
/*      */           } 
/*  424 */           return this.p;
/*      */         case 6:
/*  426 */           if (this.T) {
/*  427 */             this.T = false;
/*  428 */             ah();
/*      */           } 
/*      */         
/*      */         case 7:
/*      */         case 8:
/*  433 */           return this.o.d();
/*      */       } 
/*  435 */       return this.D.c();
/*      */     } 
/*      */     
/*  438 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final int y() {
/*  444 */     if (this.D != null) {
/*  445 */       switch (this.D.a()) {
/*      */         case 5:
/*  447 */           return this.m.g().length();
/*      */         case 6:
/*  449 */           if (this.T) {
/*  450 */             this.T = false;
/*  451 */             ah();
/*      */           } 
/*      */         
/*      */         case 7:
/*      */         case 8:
/*  456 */           return this.o.b();
/*      */       } 
/*  458 */       return (this.D.c()).length;
/*      */     } 
/*      */     
/*  461 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int z() {
/*  468 */     if (this.D != null) {
/*  469 */       switch (this.D.a()) {
/*      */         case 5:
/*  471 */           return 0;
/*      */         case 6:
/*  473 */           if (this.T) {
/*  474 */             this.T = false;
/*  475 */             ah();
/*      */           } 
/*      */         
/*      */         case 7:
/*      */         case 8:
/*  480 */           return this.o.c();
/*      */       } 
/*      */     
/*      */     }
/*  484 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final byte[] a(a parama) {
/*  490 */     if (this.D == o.g && this.r != null) {
/*  491 */       return this.r;
/*      */     }
/*  493 */     if (this.D != o.h) {
/*  494 */       g("Current token (" + this.D + ") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
/*      */     }
/*      */     
/*  497 */     if (this.T) {
/*      */       try {
/*  499 */         this.r = c(parama);
/*  500 */       } catch (IllegalArgumentException illegalArgumentException) {
/*  501 */         throw b("Failed to decode VALUE_STRING as base64 (" + parama + "): " + illegalArgumentException.getMessage());
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*  506 */       this.T = false;
/*      */     }
/*  508 */     else if (this.r == null) {
/*      */       
/*  510 */       c c = aa();
/*  511 */       a(w(), c, parama);
/*  512 */       this.r = c.b();
/*      */     } 
/*      */     
/*  515 */     return this.r;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int a(a parama, OutputStream paramOutputStream) {
/*  522 */     if (!this.T || this.D != o.h) {
/*  523 */       byte[] arrayOfByte1 = a(parama);
/*  524 */       paramOutputStream.write(arrayOfByte1);
/*  525 */       return arrayOfByte1.length;
/*      */     } 
/*      */     
/*  528 */     byte[] arrayOfByte = this.d.f();
/*      */     try {
/*  530 */       return a(parama, paramOutputStream, arrayOfByte);
/*      */     } finally {
/*  532 */       this.d.b(arrayOfByte);
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
/*      */     //   24: invokevirtual am : ()V
/*      */     //   27: aload_0
/*      */     //   28: getfield O : [C
/*      */     //   31: aload_0
/*      */     //   32: dup
/*      */     //   33: getfield e : I
/*      */     //   36: dup_x1
/*      */     //   37: iconst_1
/*      */     //   38: iadd
/*      */     //   39: putfield e : I
/*      */     //   42: caload
/*      */     //   43: dup
/*      */     //   44: istore #7
/*      */     //   46: bipush #32
/*      */     //   48: if_icmple -> 12
/*      */     //   51: aload_1
/*      */     //   52: iload #7
/*      */     //   54: invokevirtual b : (C)I
/*      */     //   57: dup
/*      */     //   58: istore #8
/*      */     //   60: ifge -> 84
/*      */     //   63: iload #7
/*      */     //   65: bipush #34
/*      */     //   67: if_icmpeq -> 622
/*      */     //   70: aload_0
/*      */     //   71: aload_1
/*      */     //   72: iload #7
/*      */     //   74: iconst_0
/*      */     //   75: invokevirtual a : (Lcom/a/a/b/a;CI)I
/*      */     //   78: dup
/*      */     //   79: istore #8
/*      */     //   81: iflt -> 12
/*      */     //   84: iload #4
/*      */     //   86: iload #5
/*      */     //   88: if_icmple -> 109
/*      */     //   91: iload #6
/*      */     //   93: iload #4
/*      */     //   95: iadd
/*      */     //   96: istore #6
/*      */     //   98: aload_2
/*      */     //   99: aload_3
/*      */     //   100: iconst_0
/*      */     //   101: iload #4
/*      */     //   103: invokevirtual write : ([BII)V
/*      */     //   106: iconst_0
/*      */     //   107: istore #4
/*      */     //   109: iload #8
/*      */     //   111: istore #9
/*      */     //   113: aload_0
/*      */     //   114: getfield e : I
/*      */     //   117: aload_0
/*      */     //   118: getfield f : I
/*      */     //   121: if_icmplt -> 128
/*      */     //   124: aload_0
/*      */     //   125: invokevirtual am : ()V
/*      */     //   128: aload_0
/*      */     //   129: getfield O : [C
/*      */     //   132: aload_0
/*      */     //   133: dup
/*      */     //   134: getfield e : I
/*      */     //   137: dup_x1
/*      */     //   138: iconst_1
/*      */     //   139: iadd
/*      */     //   140: putfield e : I
/*      */     //   143: caload
/*      */     //   144: istore #7
/*      */     //   146: aload_1
/*      */     //   147: iload #7
/*      */     //   149: invokevirtual b : (C)I
/*      */     //   152: dup
/*      */     //   153: istore #8
/*      */     //   155: ifge -> 168
/*      */     //   158: aload_0
/*      */     //   159: aload_1
/*      */     //   160: iload #7
/*      */     //   162: iconst_1
/*      */     //   163: invokevirtual a : (Lcom/a/a/b/a;CI)I
/*      */     //   166: istore #8
/*      */     //   168: iload #9
/*      */     //   170: bipush #6
/*      */     //   172: ishl
/*      */     //   173: iload #8
/*      */     //   175: ior
/*      */     //   176: istore #9
/*      */     //   178: aload_0
/*      */     //   179: getfield e : I
/*      */     //   182: aload_0
/*      */     //   183: getfield f : I
/*      */     //   186: if_icmplt -> 193
/*      */     //   189: aload_0
/*      */     //   190: invokevirtual am : ()V
/*      */     //   193: aload_0
/*      */     //   194: getfield O : [C
/*      */     //   197: aload_0
/*      */     //   198: dup
/*      */     //   199: getfield e : I
/*      */     //   202: dup_x1
/*      */     //   203: iconst_1
/*      */     //   204: iadd
/*      */     //   205: putfield e : I
/*      */     //   208: caload
/*      */     //   209: istore #7
/*      */     //   211: aload_1
/*      */     //   212: iload #7
/*      */     //   214: invokevirtual b : (C)I
/*      */     //   217: dup
/*      */     //   218: istore #8
/*      */     //   220: ifge -> 401
/*      */     //   223: iload #8
/*      */     //   225: bipush #-2
/*      */     //   227: if_icmpeq -> 288
/*      */     //   230: iload #7
/*      */     //   232: bipush #34
/*      */     //   234: if_icmpne -> 278
/*      */     //   237: iload #9
/*      */     //   239: iconst_4
/*      */     //   240: ishr
/*      */     //   241: istore #9
/*      */     //   243: aload_3
/*      */     //   244: iload #4
/*      */     //   246: iinc #4, 1
/*      */     //   249: iload #9
/*      */     //   251: i2b
/*      */     //   252: bastore
/*      */     //   253: aload_1
/*      */     //   254: invokevirtual a : ()Z
/*      */     //   257: ifeq -> 622
/*      */     //   260: aload_0
/*      */     //   261: dup
/*      */     //   262: getfield e : I
/*      */     //   265: iconst_1
/*      */     //   266: isub
/*      */     //   267: putfield e : I
/*      */     //   270: aload_0
/*      */     //   271: aload_1
/*      */     //   272: invokevirtual b : (Lcom/a/a/b/a;)V
/*      */     //   275: goto -> 622
/*      */     //   278: aload_0
/*      */     //   279: aload_1
/*      */     //   280: iload #7
/*      */     //   282: iconst_2
/*      */     //   283: invokevirtual a : (Lcom/a/a/b/a;CI)I
/*      */     //   286: istore #8
/*      */     //   288: iload #8
/*      */     //   290: bipush #-2
/*      */     //   292: if_icmpne -> 401
/*      */     //   295: aload_0
/*      */     //   296: getfield e : I
/*      */     //   299: aload_0
/*      */     //   300: getfield f : I
/*      */     //   303: if_icmplt -> 310
/*      */     //   306: aload_0
/*      */     //   307: invokevirtual am : ()V
/*      */     //   310: aload_0
/*      */     //   311: getfield O : [C
/*      */     //   314: aload_0
/*      */     //   315: dup
/*      */     //   316: getfield e : I
/*      */     //   319: dup_x1
/*      */     //   320: iconst_1
/*      */     //   321: iadd
/*      */     //   322: putfield e : I
/*      */     //   325: caload
/*      */     //   326: istore #7
/*      */     //   328: aload_1
/*      */     //   329: iload #7
/*      */     //   331: invokevirtual a : (C)Z
/*      */     //   334: ifne -> 382
/*      */     //   337: aload_0
/*      */     //   338: aload_1
/*      */     //   339: iload #7
/*      */     //   341: iconst_3
/*      */     //   342: invokevirtual a : (Lcom/a/a/b/a;CI)I
/*      */     //   345: bipush #-2
/*      */     //   347: if_icmpeq -> 382
/*      */     //   350: aload_1
/*      */     //   351: iload #7
/*      */     //   353: iconst_3
/*      */     //   354: new java/lang/StringBuilder
/*      */     //   357: dup
/*      */     //   358: ldc 'expected padding character ''
/*      */     //   360: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   363: aload_1
/*      */     //   364: invokevirtual b : ()C
/*      */     //   367: invokevirtual append : (C)Ljava/lang/StringBuilder;
/*      */     //   370: ldc '''
/*      */     //   372: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   375: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   378: invokestatic a : (Lcom/a/a/b/a;IILjava/lang/String;)Ljava/lang/IllegalArgumentException;
/*      */     //   381: athrow
/*      */     //   382: iload #9
/*      */     //   384: iconst_4
/*      */     //   385: ishr
/*      */     //   386: istore #9
/*      */     //   388: aload_3
/*      */     //   389: iload #4
/*      */     //   391: iinc #4, 1
/*      */     //   394: iload #9
/*      */     //   396: i2b
/*      */     //   397: bastore
/*      */     //   398: goto -> 12
/*      */     //   401: iload #9
/*      */     //   403: bipush #6
/*      */     //   405: ishl
/*      */     //   406: iload #8
/*      */     //   408: ior
/*      */     //   409: istore #9
/*      */     //   411: aload_0
/*      */     //   412: getfield e : I
/*      */     //   415: aload_0
/*      */     //   416: getfield f : I
/*      */     //   419: if_icmplt -> 426
/*      */     //   422: aload_0
/*      */     //   423: invokevirtual am : ()V
/*      */     //   426: aload_0
/*      */     //   427: getfield O : [C
/*      */     //   430: aload_0
/*      */     //   431: dup
/*      */     //   432: getfield e : I
/*      */     //   435: dup_x1
/*      */     //   436: iconst_1
/*      */     //   437: iadd
/*      */     //   438: putfield e : I
/*      */     //   441: caload
/*      */     //   442: istore #7
/*      */     //   444: aload_1
/*      */     //   445: iload #7
/*      */     //   447: invokevirtual b : (C)I
/*      */     //   450: dup
/*      */     //   451: istore #8
/*      */     //   453: ifge -> 573
/*      */     //   456: iload #8
/*      */     //   458: bipush #-2
/*      */     //   460: if_icmpeq -> 534
/*      */     //   463: iload #7
/*      */     //   465: bipush #34
/*      */     //   467: if_icmpne -> 524
/*      */     //   470: iload #9
/*      */     //   472: iconst_2
/*      */     //   473: ishr
/*      */     //   474: istore #9
/*      */     //   476: aload_3
/*      */     //   477: iload #4
/*      */     //   479: iinc #4, 1
/*      */     //   482: iload #9
/*      */     //   484: bipush #8
/*      */     //   486: ishr
/*      */     //   487: i2b
/*      */     //   488: bastore
/*      */     //   489: aload_3
/*      */     //   490: iload #4
/*      */     //   492: iinc #4, 1
/*      */     //   495: iload #9
/*      */     //   497: i2b
/*      */     //   498: bastore
/*      */     //   499: aload_1
/*      */     //   500: invokevirtual a : ()Z
/*      */     //   503: ifeq -> 622
/*      */     //   506: aload_0
/*      */     //   507: dup
/*      */     //   508: getfield e : I
/*      */     //   511: iconst_1
/*      */     //   512: isub
/*      */     //   513: putfield e : I
/*      */     //   516: aload_0
/*      */     //   517: aload_1
/*      */     //   518: invokevirtual b : (Lcom/a/a/b/a;)V
/*      */     //   521: goto -> 622
/*      */     //   524: aload_0
/*      */     //   525: aload_1
/*      */     //   526: iload #7
/*      */     //   528: iconst_3
/*      */     //   529: invokevirtual a : (Lcom/a/a/b/a;CI)I
/*      */     //   532: istore #8
/*      */     //   534: iload #8
/*      */     //   536: bipush #-2
/*      */     //   538: if_icmpne -> 573
/*      */     //   541: iload #9
/*      */     //   543: iconst_2
/*      */     //   544: ishr
/*      */     //   545: istore #9
/*      */     //   547: aload_3
/*      */     //   548: iload #4
/*      */     //   550: iinc #4, 1
/*      */     //   553: iload #9
/*      */     //   555: bipush #8
/*      */     //   557: ishr
/*      */     //   558: i2b
/*      */     //   559: bastore
/*      */     //   560: aload_3
/*      */     //   561: iload #4
/*      */     //   563: iinc #4, 1
/*      */     //   566: iload #9
/*      */     //   568: i2b
/*      */     //   569: bastore
/*      */     //   570: goto -> 12
/*      */     //   573: iload #9
/*      */     //   575: bipush #6
/*      */     //   577: ishl
/*      */     //   578: iload #8
/*      */     //   580: ior
/*      */     //   581: istore #9
/*      */     //   583: aload_3
/*      */     //   584: iload #4
/*      */     //   586: iinc #4, 1
/*      */     //   589: iload #9
/*      */     //   591: bipush #16
/*      */     //   593: ishr
/*      */     //   594: i2b
/*      */     //   595: bastore
/*      */     //   596: aload_3
/*      */     //   597: iload #4
/*      */     //   599: iinc #4, 1
/*      */     //   602: iload #9
/*      */     //   604: bipush #8
/*      */     //   606: ishr
/*      */     //   607: i2b
/*      */     //   608: bastore
/*      */     //   609: aload_3
/*      */     //   610: iload #4
/*      */     //   612: iinc #4, 1
/*      */     //   615: iload #9
/*      */     //   617: i2b
/*      */     //   618: bastore
/*      */     //   619: goto -> 12
/*      */     //   622: aload_0
/*      */     //   623: iconst_0
/*      */     //   624: putfield T : Z
/*      */     //   627: iload #4
/*      */     //   629: ifle -> 647
/*      */     //   632: iload #6
/*      */     //   634: iload #4
/*      */     //   636: iadd
/*      */     //   637: istore #6
/*      */     //   639: aload_2
/*      */     //   640: aload_3
/*      */     //   641: iconst_0
/*      */     //   642: iload #4
/*      */     //   644: invokevirtual write : ([BII)V
/*      */     //   647: iload #6
/*      */     //   649: ireturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #538	-> 0
/*      */     //   #539	-> 3
/*      */     //   #540	-> 9
/*      */     //   #546	-> 12
/*      */     //   #547	-> 23
/*      */     //   #549	-> 27
/*      */     //   #550	-> 44
/*      */     //   #551	-> 51
/*      */     //   #552	-> 58
/*      */     //   #553	-> 63
/*      */     //   #556	-> 70
/*      */     //   #557	-> 79
/*      */     //   #563	-> 84
/*      */     //   #564	-> 91
/*      */     //   #565	-> 98
/*      */     //   #566	-> 106
/*      */     //   #569	-> 109
/*      */     //   #573	-> 113
/*      */     //   #574	-> 124
/*      */     //   #576	-> 128
/*      */     //   #577	-> 146
/*      */     //   #578	-> 153
/*      */     //   #579	-> 158
/*      */     //   #581	-> 168
/*      */     //   #584	-> 178
/*      */     //   #585	-> 189
/*      */     //   #587	-> 193
/*      */     //   #588	-> 211
/*      */     //   #591	-> 218
/*      */     //   #592	-> 223
/*      */     //   #594	-> 230
/*      */     //   #595	-> 237
/*      */     //   #596	-> 243
/*      */     //   #597	-> 253
/*      */     //   #598	-> 260
/*      */     //   #599	-> 270
/*      */     //   #603	-> 278
/*      */     //   #605	-> 288
/*      */     //   #607	-> 295
/*      */     //   #608	-> 306
/*      */     //   #610	-> 310
/*      */     //   #611	-> 328
/*      */     //   #612	-> 337
/*      */     //   #613	-> 350
/*      */     //   #617	-> 382
/*      */     //   #618	-> 388
/*      */     //   #619	-> 398
/*      */     //   #623	-> 401
/*      */     //   #625	-> 411
/*      */     //   #626	-> 422
/*      */     //   #628	-> 426
/*      */     //   #629	-> 444
/*      */     //   #630	-> 451
/*      */     //   #631	-> 456
/*      */     //   #633	-> 463
/*      */     //   #634	-> 470
/*      */     //   #635	-> 476
/*      */     //   #636	-> 489
/*      */     //   #637	-> 499
/*      */     //   #638	-> 506
/*      */     //   #639	-> 516
/*      */     //   #643	-> 524
/*      */     //   #645	-> 534
/*      */     //   #652	-> 541
/*      */     //   #653	-> 547
/*      */     //   #654	-> 560
/*      */     //   #655	-> 570
/*      */     //   #659	-> 573
/*      */     //   #660	-> 583
/*      */     //   #661	-> 596
/*      */     //   #662	-> 609
/*      */     //   #663	-> 619
/*      */     //   #664	-> 622
/*      */     //   #665	-> 627
/*      */     //   #666	-> 632
/*      */     //   #667	-> 639
/*      */     //   #669	-> 647
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
/*      */   public final o g() {
/*      */     o o;
/*  689 */     if (this.D == o.f) {
/*  690 */       return ao();
/*      */     }
/*      */ 
/*      */     
/*  694 */     this.s = 0;
/*  695 */     if (this.T) {
/*  696 */       av();
/*      */     }
/*      */     int i;
/*  699 */     if ((i = az()) < 0) {
/*      */ 
/*      */       
/*  702 */       close();
/*  703 */       return this.D = null;
/*      */     } 
/*      */     
/*  706 */     this.r = null;
/*      */ 
/*      */     
/*  709 */     if (i == 93 || i == 125) {
/*  710 */       n(i);
/*  711 */       return this.D;
/*      */     } 
/*      */ 
/*      */     
/*  715 */     if (this.m.l()) {
/*  716 */       i = m(i);
/*      */ 
/*      */       
/*  719 */       if ((this.b & E) != 0 && (
/*  720 */         i == 93 || i == 125)) {
/*  721 */         n(i);
/*  722 */         return this.D;
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*      */     boolean bool;
/*      */ 
/*      */     
/*  731 */     if (bool = this.m.d()) {
/*      */       
/*  733 */       aJ();
/*  734 */       String str = (i == 34) ? ar() : k(i);
/*  735 */       this.m.a(str);
/*  736 */       this.D = o.f;
/*  737 */       i = ax();
/*      */     } 
/*  739 */     aI();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  745 */     switch (i) {
/*      */       case 34:
/*  747 */         this.T = true;
/*  748 */         o = o.h;
/*      */         break;
/*      */       case 91:
/*  751 */         if (!bool) {
/*  752 */           this.m = this.m.a(this.k, this.l);
/*      */         }
/*  754 */         o = o.d;
/*      */         break;
/*      */       case 123:
/*  757 */         if (!bool) {
/*  758 */           this.m = this.m.b(this.k, this.l);
/*      */         }
/*  760 */         o = o.b;
/*      */         break;
/*      */ 
/*      */       
/*      */       case 125:
/*  765 */         c(o, "expected a value");
/*      */       case 116:
/*  767 */         aF();
/*  768 */         o = o.k;
/*      */         break;
/*      */       case 102:
/*  771 */         aG();
/*  772 */         o = o.l;
/*      */         break;
/*      */       case 110:
/*  775 */         aH();
/*  776 */         o = o.m;
/*      */         break;
/*      */       
/*      */       case 45:
/*  780 */         o = b(true);
/*      */         break;
/*      */       case 43:
/*  783 */         if (a(e.e.c())) {
/*  784 */           o = b(false); break;
/*      */         } 
/*  786 */         o = l(o);
/*      */         break;
/*      */       
/*      */       case 46:
/*  790 */         o = a(false);
/*      */         break;
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
/*  802 */         o = i(o);
/*      */         break;
/*      */       default:
/*  805 */         o = l(o);
/*      */         break;
/*      */     } 
/*      */     
/*  809 */     if (bool) {
/*  810 */       this.n = o;
/*  811 */       return this.D;
/*      */     } 
/*  813 */     this.D = o;
/*  814 */     return o;
/*      */   }
/*      */ 
/*      */   
/*      */   private final o ao() {
/*  819 */     this.q = false;
/*  820 */     o o = this.n;
/*  821 */     this.n = null;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  826 */     if (o == o.d) {
/*  827 */       this.m = this.m.a(this.k, this.l);
/*  828 */     } else if (o == o.b) {
/*  829 */       this.m = this.m.b(this.k, this.l);
/*      */     } 
/*  831 */     return this.D = o;
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
/*      */   public final String h() {
/*  930 */     this.s = 0;
/*  931 */     if (this.D == o.f) {
/*  932 */       ao();
/*  933 */       return null;
/*      */     } 
/*  935 */     if (this.T) {
/*  936 */       av();
/*      */     }
/*      */     int i;
/*  939 */     if ((i = az()) < 0) {
/*  940 */       close();
/*  941 */       this.D = null;
/*  942 */       return null;
/*      */     } 
/*  944 */     this.r = null;
/*  945 */     if (i == 93 || i == 125) {
/*  946 */       n(i);
/*  947 */       return null;
/*      */     } 
/*  949 */     if (this.m.l()) {
/*  950 */       i = m(i);
/*  951 */       if ((this.b & E) != 0 && (
/*  952 */         i == 93 || i == 125)) {
/*  953 */         n(i);
/*  954 */         return null;
/*      */       } 
/*      */     } 
/*      */     
/*  958 */     if (!this.m.d()) {
/*  959 */       aI();
/*  960 */       h(i);
/*  961 */       return null;
/*      */     } 
/*      */     
/*  964 */     aJ();
/*  965 */     String str = (i == 34) ? ar() : k(i);
/*  966 */     this.m.a(str);
/*  967 */     this.D = o.f;
/*  968 */     i = ax();
/*      */     
/*  970 */     aI();
/*  971 */     if (i == 34) {
/*  972 */       this.T = true;
/*  973 */       this.n = o.h;
/*  974 */       return str;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  981 */     switch (i)
/*      */     { case 45:
/*  983 */         o = b(true);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1029 */         this.n = o;
/* 1030 */         return str;case 43: if (a(e.e.c())) { o = b(false); } else { o = l(o); }  this.n = o; return str;case 46: o = a(false); this.n = o; return str;case 48: case 49: case 50: case 51: case 52: case 53: case 54: case 55: case 56: case 57: o = i(o); this.n = o; return str;case 102: aG(); o = o.l; this.n = o; return str;case 110: aH(); o = o.m; this.n = o; return str;case 116: aF(); o = o.k; this.n = o; return str;case 91: o = o.d; this.n = o; return str;case 123: o = o.b; this.n = o; return str; }  o o = l(o); this.n = o; return str;
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
/*      */   private final o h(int paramInt) {
/* 1159 */     if (paramInt == 34) {
/* 1160 */       this.T = true;
/* 1161 */       return this.D = o.h;
/*      */     } 
/* 1163 */     switch (paramInt) {
/*      */       case 91:
/* 1165 */         this.m = this.m.a(this.k, this.l);
/* 1166 */         return this.D = o.d;
/*      */       case 123:
/* 1168 */         this.m = this.m.b(this.k, this.l);
/* 1169 */         return this.D = o.b;
/*      */       case 116:
/* 1171 */         a("true", 1);
/* 1172 */         return this.D = o.k;
/*      */       case 102:
/* 1174 */         a("false", 1);
/* 1175 */         return this.D = o.l;
/*      */       case 110:
/* 1177 */         a("null", 1);
/* 1178 */         return this.D = o.m;
/*      */       case 45:
/* 1180 */         return this.D = b(true);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 46:
/* 1186 */         return this.D = a(false);
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
/* 1197 */         return this.D = i(paramInt);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 44:
/* 1209 */         if (!this.m.c() && (
/* 1210 */           this.b & H) != 0) {
/* 1211 */           this.e--;
/* 1212 */           return this.D = o.m;
/*      */         } 
/*      */         break;
/*      */     } 
/* 1216 */     return this.D = l(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final String i() {
/* 1222 */     if (this.D == o.f) {
/* 1223 */       this.q = false;
/* 1224 */       o o = this.n;
/* 1225 */       this.n = null;
/* 1226 */       this.D = o;
/* 1227 */       if (o == o.h) {
/* 1228 */         if (this.T) {
/* 1229 */           this.T = false;
/* 1230 */           ah();
/*      */         } 
/* 1232 */         return this.o.e();
/*      */       } 
/* 1234 */       if (o == o.d) {
/* 1235 */         this.m = this.m.a(this.k, this.l);
/* 1236 */       } else if (o == o.b) {
/* 1237 */         this.m = this.m.b(this.k, this.l);
/*      */       } 
/* 1239 */       return null;
/*      */     } 
/*      */     
/* 1242 */     return (g() == o.h) ? w() : null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int b(int paramInt) {
/* 1249 */     if (this.D == o.f) {
/* 1250 */       this.q = false;
/* 1251 */       o o = this.n;
/* 1252 */       this.n = null;
/* 1253 */       this.D = o;
/* 1254 */       if (o == o.i) {
/* 1255 */         return G();
/*      */       }
/* 1257 */       if (o == o.d) {
/* 1258 */         this.m = this.m.a(this.k, this.l);
/* 1259 */       } else if (o == o.b) {
/* 1260 */         this.m = this.m.b(this.k, this.l);
/*      */       } 
/* 1262 */       return paramInt;
/*      */     } 
/*      */     
/* 1265 */     return (g() == o.i) ? G() : paramInt;
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
/*      */   private o a(boolean paramBoolean) {
/* 1337 */     if (!a(e.f.c())) {
/* 1338 */       return l(46);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1346 */     int i = this.e - 1;
/* 1347 */     if (paramBoolean) {
/* 1348 */       i--;
/*      */     }
/* 1350 */     return a(46, i, this.e, paramBoolean, 0);
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
/*      */   private o i(int paramInt) {
/* 1384 */     int i, j = (i = this.e) - 1;
/* 1385 */     int k = this.f;
/*      */ 
/*      */     
/* 1388 */     if (paramInt == 48) {
/* 1389 */       return b(false, j);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1398 */     byte b1 = 1;
/*      */ 
/*      */ 
/*      */     
/*      */     while (true) {
/* 1403 */       if (i >= k) {
/* 1404 */         this.e = j;
/* 1405 */         return b(false, j);
/*      */       } 
/*      */       
/* 1408 */       if ((paramInt = this.O[i++]) >= 48 && paramInt <= 57) {
/*      */ 
/*      */         
/* 1411 */         b1++; continue;
/*      */       }  break;
/* 1413 */     }  if (paramInt == 46 || paramInt == 101 || paramInt == 69) {
/* 1414 */       this.e = i;
/* 1415 */       return a(paramInt, j, i, false, b1);
/*      */     } 
/*      */ 
/*      */     
/* 1419 */     this.e = --i;
/*      */     
/* 1421 */     if (this.m.c()) {
/* 1422 */       j(paramInt);
/*      */     }
/* 1424 */     paramInt = i - j;
/* 1425 */     this.o.a(this.O, j, paramInt);
/* 1426 */     return a(false, b1);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private final o a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4) {
/* 1432 */     int i = this.f;
/* 1433 */     byte b1 = 0;
/*      */ 
/*      */     
/* 1436 */     if (paramInt1 == 46) {
/*      */       
/*      */       while (true) {
/* 1439 */         if (paramInt3 >= i) {
/* 1440 */           return b(paramBoolean, paramInt2);
/*      */         }
/*      */         
/* 1443 */         if ((paramInt1 = this.O[paramInt3++]) >= 48 && paramInt1 <= 57) {
/*      */ 
/*      */           
/* 1446 */           b1++; continue;
/*      */         }  break;
/*      */       } 
/* 1449 */       if (b1 == 0 && 
/* 1450 */         !a(e.g.c())) {
/* 1451 */         b(paramInt1, "Decimal point not followed by a digit");
/*      */       }
/*      */     } 
/*      */     
/* 1455 */     byte b2 = 0;
/* 1456 */     if (paramInt1 == 101 || paramInt1 == 69) {
/* 1457 */       if (paramInt3 >= i) {
/* 1458 */         this.e = paramInt2;
/* 1459 */         return b(paramBoolean, paramInt2);
/*      */       } 
/*      */ 
/*      */       
/* 1463 */       if ((paramInt1 = this.O[paramInt3++]) == 45 || paramInt1 == 43) {
/* 1464 */         if (paramInt3 >= i) {
/* 1465 */           this.e = paramInt2;
/* 1466 */           return b(paramBoolean, paramInt2);
/*      */         } 
/* 1468 */         paramInt1 = this.O[paramInt3++];
/*      */       } 
/* 1470 */       while (paramInt1 <= 57 && paramInt1 >= 48) {
/* 1471 */         b2++;
/* 1472 */         if (paramInt3 >= i) {
/* 1473 */           this.e = paramInt2;
/* 1474 */           return b(paramBoolean, paramInt2);
/*      */         } 
/* 1476 */         paramInt1 = this.O[paramInt3++];
/*      */       } 
/*      */       
/* 1479 */       if (b2 == 0) {
/* 1480 */         b(paramInt1, "Exponent indicator not followed by a digit");
/*      */       }
/*      */     } 
/*      */     
/* 1484 */     this.e = --paramInt3;
/*      */     
/* 1486 */     if (this.m.c()) {
/* 1487 */       j(paramInt1);
/*      */     }
/* 1489 */     paramInt1 = paramInt3 - paramInt2;
/* 1490 */     this.o.a(this.O, paramInt2, paramInt1);
/*      */     
/* 1492 */     return a(paramBoolean, paramInt4, b1, b2);
/*      */   }
/*      */ 
/*      */   
/*      */   private final o b(boolean paramBoolean) {
/* 1497 */     int i = this.e;
/*      */ 
/*      */     
/* 1500 */     int j = paramBoolean ? (i - 1) : i;
/* 1501 */     int k = this.f;
/*      */     
/* 1503 */     if (i >= k) {
/* 1504 */       return b(paramBoolean, j);
/*      */     }
/*      */     
/*      */     char c;
/* 1508 */     if ((c = this.O[i++]) > '9' || c < '0') {
/* 1509 */       this.e = i;
/* 1510 */       if (c == '.') {
/* 1511 */         return a(paramBoolean);
/*      */       }
/* 1513 */       return a(c, paramBoolean, true);
/*      */     } 
/*      */     
/* 1516 */     if (c == '0') {
/* 1517 */       return b(paramBoolean, j);
/*      */     }
/* 1519 */     byte b1 = 1;
/*      */ 
/*      */ 
/*      */     
/*      */     while (true) {
/* 1524 */       if (i >= k) {
/* 1525 */         return b(paramBoolean, j);
/*      */       }
/*      */       
/* 1528 */       if ((c = this.O[i++]) >= '0' && c <= '9') {
/*      */ 
/*      */         
/* 1531 */         b1++; continue;
/*      */       }  break;
/*      */     } 
/* 1534 */     if (c == '.' || c == 'e' || c == 'E') {
/* 1535 */       this.e = i;
/* 1536 */       return a(c, j, i, paramBoolean, b1);
/*      */     } 
/*      */     
/* 1539 */     this.e = --i;
/* 1540 */     if (this.m.c()) {
/* 1541 */       j(c);
/*      */     }
/* 1543 */     i -= j;
/* 1544 */     this.o.a(this.O, j, i);
/* 1545 */     return a(paramBoolean, b1);
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
/*      */   private final o b(boolean paramBoolean, int paramInt) {
/*      */     // Byte code:
/*      */     //   0: aload_0
/*      */     //   1: iload_1
/*      */     //   2: ifeq -> 11
/*      */     //   5: iload_2
/*      */     //   6: iconst_1
/*      */     //   7: iadd
/*      */     //   8: goto -> 12
/*      */     //   11: iload_2
/*      */     //   12: putfield e : I
/*      */     //   15: aload_0
/*      */     //   16: getfield o : Lcom/a/a/b/g/o;
/*      */     //   19: invokevirtual h : ()[C
/*      */     //   22: astore_2
/*      */     //   23: iconst_0
/*      */     //   24: istore_3
/*      */     //   25: iload_1
/*      */     //   26: ifeq -> 37
/*      */     //   29: aload_2
/*      */     //   30: iconst_0
/*      */     //   31: iinc #3, 1
/*      */     //   34: bipush #45
/*      */     //   36: castore
/*      */     //   37: iconst_0
/*      */     //   38: istore #4
/*      */     //   40: aload_0
/*      */     //   41: getfield e : I
/*      */     //   44: aload_0
/*      */     //   45: getfield f : I
/*      */     //   48: if_icmpge -> 70
/*      */     //   51: aload_0
/*      */     //   52: getfield O : [C
/*      */     //   55: aload_0
/*      */     //   56: dup
/*      */     //   57: getfield e : I
/*      */     //   60: dup_x1
/*      */     //   61: iconst_1
/*      */     //   62: iadd
/*      */     //   63: putfield e : I
/*      */     //   66: caload
/*      */     //   67: goto -> 79
/*      */     //   70: aload_0
/*      */     //   71: ldc 'No digit following minus sign'
/*      */     //   73: getstatic com/a/a/b/o.i : Lcom/a/a/b/o;
/*      */     //   76: invokevirtual c : (Ljava/lang/String;Lcom/a/a/b/o;)C
/*      */     //   79: dup
/*      */     //   80: istore #5
/*      */     //   82: bipush #48
/*      */     //   84: if_icmpne -> 93
/*      */     //   87: aload_0
/*      */     //   88: invokespecial ap : ()C
/*      */     //   91: istore #5
/*      */     //   93: iconst_0
/*      */     //   94: istore #6
/*      */     //   96: iload #5
/*      */     //   98: bipush #48
/*      */     //   100: if_icmplt -> 185
/*      */     //   103: iload #5
/*      */     //   105: bipush #57
/*      */     //   107: if_icmpgt -> 185
/*      */     //   110: iinc #4, 1
/*      */     //   113: iload_3
/*      */     //   114: aload_2
/*      */     //   115: arraylength
/*      */     //   116: if_icmplt -> 129
/*      */     //   119: aload_0
/*      */     //   120: getfield o : Lcom/a/a/b/g/o;
/*      */     //   123: invokevirtual j : ()[C
/*      */     //   126: astore_2
/*      */     //   127: iconst_0
/*      */     //   128: istore_3
/*      */     //   129: aload_2
/*      */     //   130: iload_3
/*      */     //   131: iinc #3, 1
/*      */     //   134: iload #5
/*      */     //   136: castore
/*      */     //   137: aload_0
/*      */     //   138: getfield e : I
/*      */     //   141: aload_0
/*      */     //   142: getfield f : I
/*      */     //   145: if_icmplt -> 164
/*      */     //   148: aload_0
/*      */     //   149: invokevirtual an : ()Z
/*      */     //   152: ifne -> 164
/*      */     //   155: iconst_0
/*      */     //   156: istore #5
/*      */     //   158: iconst_1
/*      */     //   159: istore #6
/*      */     //   161: goto -> 185
/*      */     //   164: aload_0
/*      */     //   165: getfield O : [C
/*      */     //   168: aload_0
/*      */     //   169: dup
/*      */     //   170: getfield e : I
/*      */     //   173: dup_x1
/*      */     //   174: iconst_1
/*      */     //   175: iadd
/*      */     //   176: putfield e : I
/*      */     //   179: caload
/*      */     //   180: istore #5
/*      */     //   182: goto -> 96
/*      */     //   185: iload #4
/*      */     //   187: ifne -> 211
/*      */     //   190: aload_0
/*      */     //   191: getstatic com/a/a/b/d/e.f : Lcom/a/a/b/d/e;
/*      */     //   194: invokevirtual c : ()Lcom/a/a/b/l$a;
/*      */     //   197: invokevirtual a : (Lcom/a/a/b/l$a;)Z
/*      */     //   200: ifne -> 211
/*      */     //   203: aload_0
/*      */     //   204: iload #5
/*      */     //   206: iload_1
/*      */     //   207: invokevirtual a : (IZ)Lcom/a/a/b/o;
/*      */     //   210: areturn
/*      */     //   211: iconst_m1
/*      */     //   212: istore #7
/*      */     //   214: iload #5
/*      */     //   216: bipush #46
/*      */     //   218: if_icmpne -> 360
/*      */     //   221: iconst_0
/*      */     //   222: istore #7
/*      */     //   224: iload_3
/*      */     //   225: aload_2
/*      */     //   226: arraylength
/*      */     //   227: if_icmplt -> 240
/*      */     //   230: aload_0
/*      */     //   231: getfield o : Lcom/a/a/b/g/o;
/*      */     //   234: invokevirtual j : ()[C
/*      */     //   237: astore_2
/*      */     //   238: iconst_0
/*      */     //   239: istore_3
/*      */     //   240: aload_2
/*      */     //   241: iload_3
/*      */     //   242: iinc #3, 1
/*      */     //   245: iload #5
/*      */     //   247: castore
/*      */     //   248: aload_0
/*      */     //   249: getfield e : I
/*      */     //   252: aload_0
/*      */     //   253: getfield f : I
/*      */     //   256: if_icmplt -> 272
/*      */     //   259: aload_0
/*      */     //   260: invokevirtual an : ()Z
/*      */     //   263: ifne -> 272
/*      */     //   266: iconst_1
/*      */     //   267: istore #6
/*      */     //   269: goto -> 333
/*      */     //   272: aload_0
/*      */     //   273: getfield O : [C
/*      */     //   276: aload_0
/*      */     //   277: dup
/*      */     //   278: getfield e : I
/*      */     //   281: dup_x1
/*      */     //   282: iconst_1
/*      */     //   283: iadd
/*      */     //   284: putfield e : I
/*      */     //   287: caload
/*      */     //   288: dup
/*      */     //   289: istore #5
/*      */     //   291: bipush #48
/*      */     //   293: if_icmplt -> 333
/*      */     //   296: iload #5
/*      */     //   298: bipush #57
/*      */     //   300: if_icmpgt -> 333
/*      */     //   303: iinc #7, 1
/*      */     //   306: iload_3
/*      */     //   307: aload_2
/*      */     //   308: arraylength
/*      */     //   309: if_icmplt -> 322
/*      */     //   312: aload_0
/*      */     //   313: getfield o : Lcom/a/a/b/g/o;
/*      */     //   316: invokevirtual j : ()[C
/*      */     //   319: astore_2
/*      */     //   320: iconst_0
/*      */     //   321: istore_3
/*      */     //   322: aload_2
/*      */     //   323: iload_3
/*      */     //   324: iinc #3, 1
/*      */     //   327: iload #5
/*      */     //   329: castore
/*      */     //   330: goto -> 248
/*      */     //   333: iload #7
/*      */     //   335: ifne -> 360
/*      */     //   338: aload_0
/*      */     //   339: getstatic com/a/a/b/d/e.g : Lcom/a/a/b/d/e;
/*      */     //   342: invokevirtual c : ()Lcom/a/a/b/l$a;
/*      */     //   345: invokevirtual a : (Lcom/a/a/b/l$a;)Z
/*      */     //   348: ifne -> 360
/*      */     //   351: aload_0
/*      */     //   352: iload #5
/*      */     //   354: ldc 'Decimal point not followed by a digit'
/*      */     //   356: invokevirtual b : (ILjava/lang/String;)Ljava/lang/Object;
/*      */     //   359: pop
/*      */     //   360: iconst_m1
/*      */     //   361: istore #8
/*      */     //   363: iload #5
/*      */     //   365: bipush #101
/*      */     //   367: if_icmpeq -> 377
/*      */     //   370: iload #5
/*      */     //   372: bipush #69
/*      */     //   374: if_icmpne -> 621
/*      */     //   377: iconst_0
/*      */     //   378: istore #8
/*      */     //   380: iload_3
/*      */     //   381: aload_2
/*      */     //   382: arraylength
/*      */     //   383: if_icmplt -> 396
/*      */     //   386: aload_0
/*      */     //   387: getfield o : Lcom/a/a/b/g/o;
/*      */     //   390: invokevirtual j : ()[C
/*      */     //   393: astore_2
/*      */     //   394: iconst_0
/*      */     //   395: istore_3
/*      */     //   396: aload_2
/*      */     //   397: iload_3
/*      */     //   398: iinc #3, 1
/*      */     //   401: iload #5
/*      */     //   403: castore
/*      */     //   404: aload_0
/*      */     //   405: getfield e : I
/*      */     //   408: aload_0
/*      */     //   409: getfield f : I
/*      */     //   412: if_icmpge -> 434
/*      */     //   415: aload_0
/*      */     //   416: getfield O : [C
/*      */     //   419: aload_0
/*      */     //   420: dup
/*      */     //   421: getfield e : I
/*      */     //   424: dup_x1
/*      */     //   425: iconst_1
/*      */     //   426: iadd
/*      */     //   427: putfield e : I
/*      */     //   430: caload
/*      */     //   431: goto -> 443
/*      */     //   434: aload_0
/*      */     //   435: ldc 'expected a digit for number exponent'
/*      */     //   437: getstatic com/a/a/b/o.j : Lcom/a/a/b/o;
/*      */     //   440: invokevirtual c : (Ljava/lang/String;Lcom/a/a/b/o;)C
/*      */     //   443: dup
/*      */     //   444: istore #5
/*      */     //   446: bipush #45
/*      */     //   448: if_icmpeq -> 458
/*      */     //   451: iload #5
/*      */     //   453: bipush #43
/*      */     //   455: if_icmpne -> 523
/*      */     //   458: iload_3
/*      */     //   459: aload_2
/*      */     //   460: arraylength
/*      */     //   461: if_icmplt -> 474
/*      */     //   464: aload_0
/*      */     //   465: getfield o : Lcom/a/a/b/g/o;
/*      */     //   468: invokevirtual j : ()[C
/*      */     //   471: astore_2
/*      */     //   472: iconst_0
/*      */     //   473: istore_3
/*      */     //   474: aload_2
/*      */     //   475: iload_3
/*      */     //   476: iinc #3, 1
/*      */     //   479: iload #5
/*      */     //   481: castore
/*      */     //   482: aload_0
/*      */     //   483: getfield e : I
/*      */     //   486: aload_0
/*      */     //   487: getfield f : I
/*      */     //   490: if_icmpge -> 512
/*      */     //   493: aload_0
/*      */     //   494: getfield O : [C
/*      */     //   497: aload_0
/*      */     //   498: dup
/*      */     //   499: getfield e : I
/*      */     //   502: dup_x1
/*      */     //   503: iconst_1
/*      */     //   504: iadd
/*      */     //   505: putfield e : I
/*      */     //   508: caload
/*      */     //   509: goto -> 521
/*      */     //   512: aload_0
/*      */     //   513: ldc 'expected a digit for number exponent'
/*      */     //   515: getstatic com/a/a/b/o.j : Lcom/a/a/b/o;
/*      */     //   518: invokevirtual c : (Ljava/lang/String;Lcom/a/a/b/o;)C
/*      */     //   521: istore #5
/*      */     //   523: iload #5
/*      */     //   525: bipush #57
/*      */     //   527: if_icmpgt -> 607
/*      */     //   530: iload #5
/*      */     //   532: bipush #48
/*      */     //   534: if_icmplt -> 607
/*      */     //   537: iinc #8, 1
/*      */     //   540: iload_3
/*      */     //   541: aload_2
/*      */     //   542: arraylength
/*      */     //   543: if_icmplt -> 556
/*      */     //   546: aload_0
/*      */     //   547: getfield o : Lcom/a/a/b/g/o;
/*      */     //   550: invokevirtual j : ()[C
/*      */     //   553: astore_2
/*      */     //   554: iconst_0
/*      */     //   555: istore_3
/*      */     //   556: aload_2
/*      */     //   557: iload_3
/*      */     //   558: iinc #3, 1
/*      */     //   561: iload #5
/*      */     //   563: castore
/*      */     //   564: aload_0
/*      */     //   565: getfield e : I
/*      */     //   568: aload_0
/*      */     //   569: getfield f : I
/*      */     //   572: if_icmplt -> 588
/*      */     //   575: aload_0
/*      */     //   576: invokevirtual an : ()Z
/*      */     //   579: ifne -> 588
/*      */     //   582: iconst_1
/*      */     //   583: istore #6
/*      */     //   585: goto -> 607
/*      */     //   588: aload_0
/*      */     //   589: getfield O : [C
/*      */     //   592: aload_0
/*      */     //   593: dup
/*      */     //   594: getfield e : I
/*      */     //   597: dup_x1
/*      */     //   598: iconst_1
/*      */     //   599: iadd
/*      */     //   600: putfield e : I
/*      */     //   603: caload
/*      */     //   604: goto -> 521
/*      */     //   607: iload #8
/*      */     //   609: ifne -> 621
/*      */     //   612: aload_0
/*      */     //   613: iload #5
/*      */     //   615: ldc 'Exponent indicator not followed by a digit'
/*      */     //   617: invokevirtual b : (ILjava/lang/String;)Ljava/lang/Object;
/*      */     //   620: pop
/*      */     //   621: iload #6
/*      */     //   623: ifne -> 652
/*      */     //   626: aload_0
/*      */     //   627: dup
/*      */     //   628: getfield e : I
/*      */     //   631: iconst_1
/*      */     //   632: isub
/*      */     //   633: putfield e : I
/*      */     //   636: aload_0
/*      */     //   637: getfield m : Lcom/a/a/b/d/d;
/*      */     //   640: invokevirtual c : ()Z
/*      */     //   643: ifeq -> 652
/*      */     //   646: aload_0
/*      */     //   647: iload #5
/*      */     //   649: invokespecial j : (I)V
/*      */     //   652: aload_0
/*      */     //   653: getfield o : Lcom/a/a/b/g/o;
/*      */     //   656: iload_3
/*      */     //   657: invokevirtual a : (I)V
/*      */     //   660: iload #7
/*      */     //   662: ifge -> 678
/*      */     //   665: iload #8
/*      */     //   667: ifge -> 678
/*      */     //   670: aload_0
/*      */     //   671: iload_1
/*      */     //   672: iload #4
/*      */     //   674: invokevirtual a : (ZI)Lcom/a/a/b/o;
/*      */     //   677: areturn
/*      */     //   678: aload_0
/*      */     //   679: iload_1
/*      */     //   680: iload #4
/*      */     //   682: iload #7
/*      */     //   684: iload #8
/*      */     //   686: invokevirtual a : (ZIII)Lcom/a/a/b/o;
/*      */     //   689: areturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #1566	-> 0
/*      */     //   #1567	-> 15
/*      */     //   #1568	-> 23
/*      */     //   #1571	-> 25
/*      */     //   #1572	-> 29
/*      */     //   #1576	-> 37
/*      */     //   #1577	-> 40
/*      */     //   #1578	-> 76
/*      */     //   #1580	-> 80
/*      */     //   #1581	-> 87
/*      */     //   #1583	-> 93
/*      */     //   #1587	-> 96
/*      */     //   #1588	-> 110
/*      */     //   #1589	-> 113
/*      */     //   #1590	-> 119
/*      */     //   #1591	-> 127
/*      */     //   #1593	-> 129
/*      */     //   #1594	-> 137
/*      */     //   #1596	-> 155
/*      */     //   #1597	-> 158
/*      */     //   #1598	-> 161
/*      */     //   #1600	-> 164
/*      */     //   #1603	-> 185
/*      */     //   #1605	-> 190
/*      */     //   #1606	-> 203
/*      */     //   #1610	-> 211
/*      */     //   #1612	-> 214
/*      */     //   #1613	-> 221
/*      */     //   #1614	-> 224
/*      */     //   #1615	-> 230
/*      */     //   #1616	-> 238
/*      */     //   #1618	-> 240
/*      */     //   #1622	-> 248
/*      */     //   #1623	-> 266
/*      */     //   #1624	-> 269
/*      */     //   #1626	-> 272
/*      */     //   #1627	-> 289
/*      */     //   #1630	-> 303
/*      */     //   #1631	-> 306
/*      */     //   #1632	-> 312
/*      */     //   #1633	-> 320
/*      */     //   #1635	-> 322
/*      */     //   #1638	-> 333
/*      */     //   #1639	-> 338
/*      */     //   #1640	-> 351
/*      */     //   #1645	-> 360
/*      */     //   #1646	-> 363
/*      */     //   #1647	-> 377
/*      */     //   #1648	-> 380
/*      */     //   #1649	-> 386
/*      */     //   #1650	-> 394
/*      */     //   #1652	-> 396
/*      */     //   #1654	-> 404
/*      */     //   #1655	-> 440
/*      */     //   #1657	-> 444
/*      */     //   #1658	-> 458
/*      */     //   #1659	-> 464
/*      */     //   #1660	-> 472
/*      */     //   #1662	-> 474
/*      */     //   #1664	-> 482
/*      */     //   #1665	-> 518
/*      */     //   #1669	-> 523
/*      */     //   #1670	-> 537
/*      */     //   #1671	-> 540
/*      */     //   #1672	-> 546
/*      */     //   #1673	-> 554
/*      */     //   #1675	-> 556
/*      */     //   #1676	-> 564
/*      */     //   #1677	-> 582
/*      */     //   #1678	-> 585
/*      */     //   #1680	-> 588
/*      */     //   #1683	-> 607
/*      */     //   #1684	-> 612
/*      */     //   #1689	-> 621
/*      */     //   #1690	-> 626
/*      */     //   #1691	-> 636
/*      */     //   #1692	-> 646
/*      */     //   #1695	-> 652
/*      */     //   #1700	-> 660
/*      */     //   #1701	-> 670
/*      */     //   #1703	-> 678
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
/*      */   private final char ap() {
/*      */     char c;
/* 1711 */     if (this.e < this.f && ((
/*      */ 
/*      */       
/* 1714 */       c = this.O[this.e]) < '0' || c > '9')) {
/* 1715 */       return '0';
/*      */     }
/*      */ 
/*      */     
/* 1719 */     return aq();
/*      */   }
/*      */ 
/*      */   
/*      */   private char aq() {
/* 1724 */     if (this.e >= this.f && !an()) {
/* 1725 */       return '0';
/*      */     }
/*      */     char c;
/* 1728 */     if ((c = this.O[this.e]) < '0' || c > '9') {
/* 1729 */       return '0';
/*      */     }
/* 1731 */     if ((this.b & F) == 0) {
/* 1732 */       c("Leading zeroes not allowed");
/*      */     }
/*      */     
/* 1735 */     this.e++;
/* 1736 */     if (c == '0') {
/* 1737 */       while (this.e < this.f || an()) {
/*      */         
/* 1739 */         if ((c = this.O[this.e]) < '0' || c > '9') {
/* 1740 */           return '0';
/*      */         }
/* 1742 */         this.e++;
/* 1743 */         if (c != '0') {
/*      */           break;
/*      */         }
/*      */       } 
/*      */     }
/* 1748 */     return c;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private o a(int paramInt, boolean paramBoolean) {
/* 1755 */     return a(paramInt, paramBoolean, false);
/*      */   }
/*      */ 
/*      */   
/*      */   private o a(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
/* 1760 */     if (paramInt == 73) {
/* 1761 */       if (this.e >= this.f && 
/* 1762 */         !an()) {
/* 1763 */         b(o.i);
/*      */       }
/*      */ 
/*      */       
/* 1767 */       if ((paramInt = this.O[this.e++]) == 78) {
/* 1768 */         String str1 = paramBoolean1 ? "-INF" : "+INF";
/* 1769 */         a(str1, 3);
/* 1770 */         if ((this.b & G) != 0) {
/* 1771 */           return a(str1, paramBoolean1 ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);
/*      */         }
/* 1773 */         g("Non-standard token '" + str1 + "': enable `JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS` to allow");
/* 1774 */       } else if (paramInt == 110) {
/* 1775 */         String str1 = paramBoolean1 ? "-Infinity" : "+Infinity";
/* 1776 */         a(str1, 3);
/* 1777 */         if ((this.b & G) != 0) {
/* 1778 */           return a(str1, paramBoolean1 ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);
/*      */         }
/* 1780 */         g("Non-standard token '" + str1 + "': enable `JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS` to allow");
/*      */       } 
/*      */     } 
/* 1783 */     if (!a(e.e.c()) && paramBoolean2 && !paramBoolean1) {
/* 1784 */       b(43, "JSON spec does not allow numbers to have plus signs: enable `JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS` to allow");
/*      */     }
/* 1786 */     String str = paramBoolean1 ? "expected digit (0-9) to follow minus sign, for valid numeric value" : "expected digit (0-9) for valid numeric value";
/*      */ 
/*      */     
/* 1789 */     b(paramInt, str);
/* 1790 */     return null;
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
/* 1808 */     this.e++;
/* 1809 */     switch (paramInt) {
/*      */       case 9:
/*      */       case 32:
/*      */         return;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 13:
/* 1820 */         this.e--;
/*      */         return;
/*      */       case 10:
/* 1823 */         this.h++;
/* 1824 */         this.i = this.e;
/*      */         return;
/*      */     } 
/* 1827 */     e(paramInt);
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
/*      */   private String ar() {
/* 1840 */     int i = this.e;
/* 1841 */     int j = this.S;
/* 1842 */     int[] arrayOfInt = M;
/*      */     
/* 1844 */     while (i < this.f) {
/*      */       char c;
/* 1846 */       if ((c = this.O[i]) < arrayOfInt.length && arrayOfInt[c] != 0) {
/* 1847 */         if (c == '"') {
/* 1848 */           int m = this.e;
/* 1849 */           this.e = i + 1;
/* 1850 */           return this.R.a(this.O, m, i - m, j);
/*      */         } 
/*      */         break;
/*      */       } 
/* 1854 */       j = j * 33 + c;
/* 1855 */       i++;
/*      */     } 
/* 1857 */     int k = this.e;
/* 1858 */     this.e = i;
/* 1859 */     return a(k, j, 34);
/*      */   }
/*      */ 
/*      */   
/*      */   private String a(int paramInt1, int paramInt2, int paramInt3) {
/* 1864 */     this.o.a(this.O, paramInt1, this.e - paramInt1);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1869 */     char[] arrayOfChar1 = this.o.g();
/* 1870 */     int j = this.o.i();
/*      */     
/*      */     while (true) {
/* 1873 */       if (this.e >= this.f && 
/* 1874 */         !an()) {
/* 1875 */         b(" in field name", o.f);
/*      */       }
/*      */       
/*      */       char c1;
/*      */       char c2;
/* 1880 */       if ((c2 = c1 = this.O[this.e++]) <= '\\')
/* 1881 */         if (c2 == '\\') {
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1886 */           c1 = af();
/* 1887 */         } else if (c2 <= paramInt3) {
/* 1888 */           if (c2 != paramInt3) {
/*      */ 
/*      */             
/* 1891 */             if (c2 < ' ')
/* 1892 */               a(c2, "name"); 
/*      */           } else {
/*      */             break;
/*      */           } 
/* 1896 */         }   paramInt2 = paramInt2 * 33 + c1;
/*      */       
/* 1898 */       arrayOfChar1[j++] = c1;
/*      */ 
/*      */       
/* 1901 */       if (j >= arrayOfChar1.length) {
/* 1902 */         arrayOfChar1 = this.o.j();
/* 1903 */         j = 0;
/*      */       } 
/*      */     } 
/* 1906 */     this.o.a(j);
/*      */     
/*      */     o o;
/* 1909 */     char[] arrayOfChar2 = (o = this.o).d();
/* 1910 */     int i = o.c();
/* 1911 */     paramInt3 = o.b();
/* 1912 */     return this.R.a(arrayOfChar2, i, paramInt3, paramInt2);
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
/*      */   private String k(int paramInt) {
/*      */     int i;
/*      */     boolean bool;
/* 1932 */     if (paramInt == 39 && (this.b & I) != 0) {
/* 1933 */       return as();
/*      */     }
/*      */     
/* 1936 */     if ((this.b & J) == 0) {
/* 1937 */       c(paramInt, "was expecting double-quote to start field name");
/*      */     }
/*      */     
/* 1940 */     int arrayOfInt[], j = (arrayOfInt = b.c()).length;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1945 */     if (paramInt < j) {
/* 1946 */       bool = (arrayOfInt[paramInt] == 0);
/*      */     } else {
/* 1948 */       bool = Character.isJavaIdentifierPart((char)paramInt);
/*      */     } 
/* 1950 */     if (!bool) {
/* 1951 */       c(paramInt, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
/*      */     }
/* 1953 */     paramInt = this.e;
/* 1954 */     int k = this.S;
/* 1955 */     int m = this.f;
/*      */     
/* 1957 */     if (paramInt < m) {
/*      */       do {
/*      */         char c;
/* 1960 */         if ((c = this.O[paramInt]) < j) {
/* 1961 */           if (arrayOfInt[c] != 0) {
/* 1962 */             i = this.e - 1;
/* 1963 */             this.e = paramInt;
/* 1964 */             return this.R.a(this.O, i, paramInt - i, k);
/*      */           } 
/* 1966 */         } else if (!Character.isJavaIdentifierPart((char)c)) {
/* 1967 */           i = this.e - 1;
/* 1968 */           this.e = paramInt;
/* 1969 */           return this.R.a(this.O, i, paramInt - i, k);
/*      */         } 
/* 1971 */         k = k * 33 + c;
/* 1972 */         ++paramInt;
/* 1973 */       } while (paramInt < m);
/*      */     }
/* 1975 */     int n = this.e - 1;
/* 1976 */     this.e = paramInt;
/* 1977 */     return a(n, k, i);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private String as() {
/* 1983 */     int i = this.e;
/* 1984 */     int j = this.S;
/* 1985 */     int k = this.f;
/*      */     
/* 1987 */     if (i < k) {
/*      */       
/* 1989 */       int arrayOfInt[], n = (arrayOfInt = M).length;
/*      */       
/*      */       while (true) {
/*      */         char c;
/* 1993 */         if ((c = this.O[i]) == '\'') {
/* 1994 */           k = this.e;
/* 1995 */           this.e = i + 1;
/* 1996 */           return this.R.a(this.O, k, i - k, j);
/*      */         } 
/* 1998 */         if (c >= n || arrayOfInt[c] == 0)
/*      */         
/*      */         { 
/* 2001 */           j = j * 33 + c;
/* 2002 */           i++;
/* 2003 */           if (i >= k)
/*      */             break;  continue; }  break;
/*      */       } 
/* 2006 */     }  int m = this.e;
/* 2007 */     this.e = i;
/*      */     
/* 2009 */     return a(m, j, 39);
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
/*      */   private o l(int paramInt) {
/*      */     // Byte code:
/*      */     //   0: iload_1
/*      */     //   1: lookupswitch default -> 243, 39 -> 60, 43 -> 195, 44 -> 86, 73 -> 158, 78 -> 121, 93 -> 76
/*      */     //   60: aload_0
/*      */     //   61: getfield b : I
/*      */     //   64: getstatic com/a/a/b/d/g.I : I
/*      */     //   67: iand
/*      */     //   68: ifeq -> 243
/*      */     //   71: aload_0
/*      */     //   72: invokevirtual at : ()Lcom/a/a/b/o;
/*      */     //   75: areturn
/*      */     //   76: aload_0
/*      */     //   77: getfield m : Lcom/a/a/b/d/d;
/*      */     //   80: invokevirtual b : ()Z
/*      */     //   83: ifeq -> 243
/*      */     //   86: aload_0
/*      */     //   87: getfield m : Lcom/a/a/b/d/d;
/*      */     //   90: invokevirtual c : ()Z
/*      */     //   93: ifne -> 243
/*      */     //   96: aload_0
/*      */     //   97: getfield b : I
/*      */     //   100: getstatic com/a/a/b/d/g.H : I
/*      */     //   103: iand
/*      */     //   104: ifeq -> 243
/*      */     //   107: aload_0
/*      */     //   108: dup
/*      */     //   109: getfield e : I
/*      */     //   112: iconst_1
/*      */     //   113: isub
/*      */     //   114: putfield e : I
/*      */     //   117: getstatic com/a/a/b/o.m : Lcom/a/a/b/o;
/*      */     //   120: areturn
/*      */     //   121: aload_0
/*      */     //   122: ldc 'NaN'
/*      */     //   124: iconst_1
/*      */     //   125: invokevirtual a : (Ljava/lang/String;I)V
/*      */     //   128: aload_0
/*      */     //   129: getfield b : I
/*      */     //   132: getstatic com/a/a/b/d/g.G : I
/*      */     //   135: iand
/*      */     //   136: ifeq -> 149
/*      */     //   139: aload_0
/*      */     //   140: ldc 'NaN'
/*      */     //   142: ldc2_w NaN
/*      */     //   145: invokevirtual a : (Ljava/lang/String;D)Lcom/a/a/b/o;
/*      */     //   148: areturn
/*      */     //   149: aload_0
/*      */     //   150: ldc 'Non-standard token 'NaN': enable `JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS` to allow'
/*      */     //   152: invokevirtual g : (Ljava/lang/String;)V
/*      */     //   155: goto -> 243
/*      */     //   158: aload_0
/*      */     //   159: ldc 'Infinity'
/*      */     //   161: iconst_1
/*      */     //   162: invokevirtual a : (Ljava/lang/String;I)V
/*      */     //   165: aload_0
/*      */     //   166: getfield b : I
/*      */     //   169: getstatic com/a/a/b/d/g.G : I
/*      */     //   172: iand
/*      */     //   173: ifeq -> 186
/*      */     //   176: aload_0
/*      */     //   177: ldc 'Infinity'
/*      */     //   179: ldc2_w Infinity
/*      */     //   182: invokevirtual a : (Ljava/lang/String;D)Lcom/a/a/b/o;
/*      */     //   185: areturn
/*      */     //   186: aload_0
/*      */     //   187: ldc 'Non-standard token 'Infinity': enable `JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS` to allow'
/*      */     //   189: invokevirtual g : (Ljava/lang/String;)V
/*      */     //   192: goto -> 243
/*      */     //   195: aload_0
/*      */     //   196: getfield e : I
/*      */     //   199: aload_0
/*      */     //   200: getfield f : I
/*      */     //   203: if_icmplt -> 220
/*      */     //   206: aload_0
/*      */     //   207: invokevirtual an : ()Z
/*      */     //   210: ifne -> 220
/*      */     //   213: aload_0
/*      */     //   214: getstatic com/a/a/b/o.i : Lcom/a/a/b/o;
/*      */     //   217: invokevirtual b : (Lcom/a/a/b/o;)V
/*      */     //   220: aload_0
/*      */     //   221: dup
/*      */     //   222: getfield O : [C
/*      */     //   225: aload_0
/*      */     //   226: dup
/*      */     //   227: getfield e : I
/*      */     //   230: dup_x1
/*      */     //   231: iconst_1
/*      */     //   232: iadd
/*      */     //   233: putfield e : I
/*      */     //   236: caload
/*      */     //   237: iconst_0
/*      */     //   238: iconst_1
/*      */     //   239: invokevirtual a : (IZZ)Lcom/a/a/b/o;
/*      */     //   242: areturn
/*      */     //   243: iload_1
/*      */     //   244: invokestatic isJavaIdentifierStart : (I)Z
/*      */     //   247: ifeq -> 273
/*      */     //   250: aload_0
/*      */     //   251: new java/lang/StringBuilder
/*      */     //   254: dup
/*      */     //   255: invokespecial <init> : ()V
/*      */     //   258: iload_1
/*      */     //   259: i2c
/*      */     //   260: invokevirtual append : (C)Ljava/lang/StringBuilder;
/*      */     //   263: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   266: aload_0
/*      */     //   267: invokevirtual ad : ()Ljava/lang/String;
/*      */     //   270: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)V
/*      */     //   273: aload_0
/*      */     //   274: iload_1
/*      */     //   275: new java/lang/StringBuilder
/*      */     //   278: dup
/*      */     //   279: ldc 'expected a valid value '
/*      */     //   281: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   284: aload_0
/*      */     //   285: invokevirtual ae : ()Ljava/lang/String;
/*      */     //   288: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   291: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   294: invokevirtual c : (ILjava/lang/String;)V
/*      */     //   297: aconst_null
/*      */     //   298: areturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #2026	-> 0
/*      */     //   #2033	-> 60
/*      */     //   #2034	-> 71
/*      */     //   #2042	-> 76
/*      */     //   #2048	-> 86
/*      */     //   #2049	-> 96
/*      */     //   #2050	-> 107
/*      */     //   #2051	-> 117
/*      */     //   #2056	-> 121
/*      */     //   #2057	-> 128
/*      */     //   #2058	-> 139
/*      */     //   #2060	-> 149
/*      */     //   #2061	-> 155
/*      */     //   #2063	-> 158
/*      */     //   #2064	-> 165
/*      */     //   #2065	-> 176
/*      */     //   #2067	-> 186
/*      */     //   #2068	-> 192
/*      */     //   #2070	-> 195
/*      */     //   #2071	-> 206
/*      */     //   #2072	-> 213
/*      */     //   #2075	-> 220
/*      */     //   #2078	-> 243
/*      */     //   #2079	-> 250
/*      */     //   #2082	-> 273
/*      */     //   #2083	-> 297
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
/*      */   private o at() {
/* 2088 */     char[] arrayOfChar = this.o.h();
/* 2089 */     int i = this.o.i();
/*      */     
/*      */     while (true) {
/* 2092 */       if (this.e >= this.f && 
/* 2093 */         !an()) {
/* 2094 */         b(": was expecting closing quote for a string value", o.h);
/*      */       }
/*      */       
/*      */       char c1;
/*      */       
/*      */       char c2;
/* 2100 */       if ((c2 = c1 = this.O[this.e++]) <= '\\')
/* 2101 */         if (c2 == '\\') {
/*      */ 
/*      */ 
/*      */           
/* 2105 */           c1 = af();
/* 2106 */         } else if (c2 <= '\'') {
/* 2107 */           if (c2 != '\'') {
/*      */ 
/*      */             
/* 2110 */             if (c2 < ' ')
/* 2111 */               a(c2, "string value"); 
/*      */           } else {
/*      */             break;
/*      */           } 
/*      */         }  
/* 2116 */       if (i >= arrayOfChar.length) {
/* 2117 */         arrayOfChar = this.o.j();
/* 2118 */         i = 0;
/*      */       } 
/*      */       
/* 2121 */       arrayOfChar[i++] = c1;
/*      */     } 
/* 2123 */     this.o.a(i);
/* 2124 */     return o.h;
/*      */   }
/*      */ 
/*      */   
/*      */   private String a(int paramInt1, int paramInt2, int[] paramArrayOfint) {
/* 2129 */     this.o.a(this.O, paramInt1, this.e - paramInt1);
/* 2130 */     char[] arrayOfChar1 = this.o.g();
/* 2131 */     int k = this.o.i();
/* 2132 */     int m = paramArrayOfint.length;
/*      */ 
/*      */     
/* 2135 */     while (this.e < this.f || 
/* 2136 */       an()) {
/*      */       char c1;
/*      */ 
/*      */       
/*      */       char c2;
/*      */       
/* 2142 */       if (((c2 = c1 = this.O[this.e]) < m) ? (
/* 2143 */         paramArrayOfint[c2] != 0) : 
/*      */ 
/*      */         
/* 2146 */         !Character.isJavaIdentifierPart(c1)) {
/*      */         break;
/*      */       }
/* 2149 */       this.e++;
/* 2150 */       paramInt2 = paramInt2 * 33 + c2;
/*      */       
/* 2152 */       arrayOfChar1[k++] = c1;
/*      */ 
/*      */       
/* 2155 */       if (k >= arrayOfChar1.length) {
/* 2156 */         arrayOfChar1 = this.o.j();
/* 2157 */         k = 0;
/*      */       } 
/*      */     } 
/* 2160 */     this.o.a(k);
/*      */     
/*      */     o o;
/* 2163 */     char[] arrayOfChar2 = (o = this.o).d();
/* 2164 */     int i = o.c();
/* 2165 */     int j = o.b();
/*      */     
/* 2167 */     return this.R.a(arrayOfChar2, i, j, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final void ah() {
/* 2178 */     int i = this.e;
/* 2179 */     int j = this.f;
/*      */     
/* 2181 */     if (i < j) {
/*      */       
/* 2183 */       int arrayOfInt[], k = (arrayOfInt = M).length;
/*      */       
/*      */       do {
/*      */         char c;
/* 2187 */         if ((c = this.O[i]) < k && arrayOfInt[c] != 0) {
/* 2188 */           if (c == '"') {
/* 2189 */             this.o.a(this.O, this.e, i - this.e);
/* 2190 */             this.e = i + 1;
/*      */             
/*      */             return;
/*      */           } 
/*      */           break;
/*      */         } 
/* 2196 */         ++i;
/* 2197 */       } while (i < j);
/*      */     } 
/*      */ 
/*      */     
/* 2201 */     this.o.b(this.O, this.e, i - this.e);
/* 2202 */     this.e = i;
/* 2203 */     au();
/*      */   }
/*      */ 
/*      */   
/*      */   private void au() {
/* 2208 */     char[] arrayOfChar = this.o.g();
/* 2209 */     int i = this.o.i();
/*      */     
/* 2211 */     int arrayOfInt[], j = (arrayOfInt = M).length;
/*      */     
/*      */     while (true) {
/* 2214 */       if (this.e >= this.f && 
/* 2215 */         !an()) {
/* 2216 */         b(": was expecting closing quote for a string value", o.h);
/*      */       }
/*      */       
/*      */       char c1;
/*      */       
/*      */       char c2;
/* 2222 */       if ((c2 = c1 = this.O[this.e++]) < j && arrayOfInt[c2] != 0)
/* 2223 */         if (c2 != '"') {
/*      */           
/* 2225 */           if (c2 == '\\') {
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 2230 */             c1 = af();
/* 2231 */           } else if (c2 < ' ') {
/* 2232 */             a(c2, "string value");
/*      */           } 
/*      */         } else {
/*      */           break;
/* 2236 */         }   if (i >= arrayOfChar.length) {
/* 2237 */         arrayOfChar = this.o.j();
/* 2238 */         i = 0;
/*      */       } 
/*      */       
/* 2241 */       arrayOfChar[i++] = c1;
/*      */     } 
/* 2243 */     this.o.a(i);
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
/*      */   private void av() {
/* 2256 */     this.T = false;
/*      */     
/* 2258 */     int i = this.e;
/* 2259 */     int j = this.f;
/* 2260 */     char[] arrayOfChar = this.O;
/*      */     
/*      */     while (true) {
/* 2263 */       if (i >= j) {
/* 2264 */         this.e = i;
/* 2265 */         if (!an()) {
/* 2266 */           b(": was expecting closing quote for a string value", o.h);
/*      */         }
/*      */         
/* 2269 */         i = this.e;
/* 2270 */         j = this.f;
/*      */       } 
/*      */       
/*      */       char c;
/* 2274 */       if ((c = c = arrayOfChar[i++]) <= '\\') {
/* 2275 */         if (c == '\\') {
/*      */ 
/*      */           
/* 2278 */           this.e = i;
/* 2279 */           af();
/* 2280 */           i = this.e;
/* 2281 */           j = this.f; continue;
/* 2282 */         }  if (c <= '"') {
/* 2283 */           if (c == '"') {
/* 2284 */             this.e = i;
/*      */             return;
/*      */           } 
/* 2287 */           if (c < ' ') {
/* 2288 */             this.e = i;
/* 2289 */             a(c, "string value");
/*      */           } 
/*      */         } 
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
/*      */   private void aw() {
/* 2305 */     if ((this.e < this.f || an()) && 
/* 2306 */       this.O[this.e] == '\n') {
/* 2307 */       this.e++;
/*      */     }
/*      */     
/* 2310 */     this.h++;
/* 2311 */     this.i = this.e;
/*      */   }
/*      */ 
/*      */   
/*      */   private final int ax() {
/* 2316 */     if (this.e + 4 >= this.f) {
/* 2317 */       return c(false);
/*      */     }
/*      */     char c;
/* 2320 */     if ((c = this.O[this.e]) == ':') {
/*      */       
/* 2322 */       if ((c = this.O[++this.e]) > ' ') {
/* 2323 */         if (c == '/' || c == '#') {
/* 2324 */           return c(true);
/*      */         }
/* 2326 */         this.e++;
/* 2327 */         return c;
/*      */       } 
/* 2329 */       if ((c == ' ' || c == '\t') && (
/*      */         
/* 2331 */         c = this.O[++this.e]) > ' ') {
/* 2332 */         if (c == '/' || c == '#') {
/* 2333 */           return c(true);
/*      */         }
/* 2335 */         this.e++;
/* 2336 */         return c;
/*      */       } 
/*      */       
/* 2339 */       return c(true);
/*      */     } 
/* 2341 */     if (c == ' ' || c == '\t') {
/* 2342 */       c = this.O[++this.e];
/*      */     }
/* 2344 */     if (c == ':') {
/*      */       
/* 2346 */       if ((c = this.O[++this.e]) > ' ') {
/* 2347 */         if (c == '/' || c == '#') {
/* 2348 */           return c(true);
/*      */         }
/* 2350 */         this.e++;
/* 2351 */         return c;
/*      */       } 
/* 2353 */       if ((c == ' ' || c == '\t') && (
/*      */         
/* 2355 */         c = this.O[++this.e]) > ' ') {
/* 2356 */         if (c == '/' || c == '#') {
/* 2357 */           return c(true);
/*      */         }
/* 2359 */         this.e++;
/* 2360 */         return c;
/*      */       } 
/*      */       
/* 2363 */       return c(true);
/*      */     } 
/* 2365 */     return c(false);
/*      */   }
/*      */ 
/*      */   
/*      */   private final int c(boolean paramBoolean) {
/* 2370 */     while (this.e < this.f || an()) {
/*      */       char c;
/* 2372 */       if ((c = this.O[this.e++]) > ' ') {
/* 2373 */         if (c == '/') {
/* 2374 */           aB();
/*      */           continue;
/*      */         } 
/* 2377 */         if (c != '#' || 
/* 2378 */           !aD()) {
/*      */ 
/*      */ 
/*      */           
/* 2382 */           if (paramBoolean) {
/* 2383 */             return c;
/*      */           }
/* 2385 */           if (c != ':') {
/* 2386 */             c(c, "was expecting a colon to separate field name and value");
/*      */           }
/* 2388 */           paramBoolean = true;
/*      */         }  continue;
/*      */       } 
/* 2391 */       if (c < ' ') {
/* 2392 */         if (c == '\n') {
/* 2393 */           this.h++;
/* 2394 */           this.i = this.e; continue;
/* 2395 */         }  if (c == '\r') {
/* 2396 */           aw(); continue;
/* 2397 */         }  if (c != '\t') {
/* 2398 */           f(c);
/*      */         }
/*      */       } 
/*      */     } 
/* 2402 */     b(" within/between " + this.m.e() + " entries", (o)null);
/*      */     
/* 2404 */     return -1;
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
/*      */   private final int m(int paramInt) {
/* 2458 */     if (paramInt != 44) {
/* 2459 */       c(paramInt, "was expecting comma to separate " + this.m.e() + " entries");
/*      */     }
/* 2461 */     while (this.e < this.f) {
/*      */       
/* 2463 */       if ((paramInt = this.O[this.e++]) > 32) {
/* 2464 */         if (paramInt == 47 || paramInt == 35) {
/* 2465 */           this.e--;
/* 2466 */           return ay();
/*      */         } 
/* 2468 */         return paramInt;
/*      */       } 
/* 2470 */       if (paramInt < 32) {
/* 2471 */         if (paramInt == 10) {
/* 2472 */           this.h++;
/* 2473 */           this.i = this.e; continue;
/* 2474 */         }  if (paramInt == 13) {
/* 2475 */           aw(); continue;
/* 2476 */         }  if (paramInt != 9) {
/* 2477 */           f(paramInt);
/*      */         }
/*      */       } 
/*      */     } 
/* 2481 */     return ay();
/*      */   }
/*      */ 
/*      */   
/*      */   private final int ay() {
/* 2486 */     while (this.e < this.f || an()) {
/*      */       char c;
/* 2488 */       if ((c = this.O[this.e++]) > ' ') {
/* 2489 */         if (c == '/') {
/* 2490 */           aB();
/*      */           continue;
/*      */         } 
/* 2493 */         if (c != '#' || 
/* 2494 */           !aD())
/*      */         {
/*      */ 
/*      */           
/* 2498 */           return c; }  continue;
/*      */       } 
/* 2500 */       if (c < ' ') {
/* 2501 */         if (c == '\n') {
/* 2502 */           this.h++;
/* 2503 */           this.i = this.e; continue;
/* 2504 */         }  if (c == '\r') {
/* 2505 */           aw(); continue;
/* 2506 */         }  if (c != '\t') {
/* 2507 */           f(c);
/*      */         }
/*      */       } 
/*      */     } 
/* 2511 */     throw b("Unexpected end-of-input within/between " + this.m.e() + " entries");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final int az() {
/* 2518 */     if (this.e >= this.f && 
/* 2519 */       !an()) {
/* 2520 */       return Z();
/*      */     }
/*      */     
/*      */     char c;
/* 2524 */     if ((c = this.O[this.e++]) > ' ') {
/* 2525 */       if (c == '/' || c == '#') {
/* 2526 */         this.e--;
/* 2527 */         return aA();
/*      */       } 
/* 2529 */       return c;
/*      */     } 
/* 2531 */     if (c != ' ') {
/* 2532 */       if (c == '\n') {
/* 2533 */         this.h++;
/* 2534 */         this.i = this.e;
/* 2535 */       } else if (c == '\r') {
/* 2536 */         aw();
/* 2537 */       } else if (c != '\t') {
/* 2538 */         f(c);
/*      */       } 
/*      */     }
/*      */     
/* 2542 */     while (this.e < this.f) {
/*      */       
/* 2544 */       if ((c = this.O[this.e++]) > ' ') {
/* 2545 */         if (c == '/' || c == '#') {
/* 2546 */           this.e--;
/* 2547 */           return aA();
/*      */         } 
/* 2549 */         return c;
/*      */       } 
/* 2551 */       if (c != ' ') {
/* 2552 */         if (c == '\n') {
/* 2553 */           this.h++;
/* 2554 */           this.i = this.e; continue;
/* 2555 */         }  if (c == '\r') {
/* 2556 */           aw(); continue;
/* 2557 */         }  if (c != '\t') {
/* 2558 */           f(c);
/*      */         }
/*      */       } 
/*      */     } 
/* 2562 */     return aA();
/*      */   }
/*      */ 
/*      */   
/*      */   private int aA() {
/*      */     while (true) {
/* 2568 */       if (this.e >= this.f && 
/* 2569 */         !an()) {
/* 2570 */         return Z();
/*      */       }
/*      */       
/*      */       char c;
/* 2574 */       if ((c = this.O[this.e++]) > ' ') {
/* 2575 */         if (c == '/') {
/* 2576 */           aB();
/*      */           continue;
/*      */         } 
/* 2579 */         if (c != '#' || 
/* 2580 */           !aD())
/*      */         {
/*      */ 
/*      */           
/* 2584 */           return c; }  continue;
/* 2585 */       }  if (c != ' ') {
/* 2586 */         if (c == '\n') {
/* 2587 */           this.h++;
/* 2588 */           this.i = this.e; continue;
/* 2589 */         }  if (c == '\r') {
/* 2590 */           aw(); continue;
/* 2591 */         }  if (c != '\t') {
/* 2592 */           f(c);
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void aB() {
/* 2600 */     if ((this.b & K) == 0) {
/* 2601 */       c(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
/*      */     }
/*      */     
/* 2604 */     if (this.e >= this.f && !an()) {
/* 2605 */       b(" in a comment", (o)null);
/*      */     }
/*      */     char c;
/* 2608 */     if ((c = this.O[this.e++]) == '/') {
/* 2609 */       aE(); return;
/* 2610 */     }  if (c == '*') {
/* 2611 */       aC(); return;
/*      */     } 
/* 2613 */     c(c, "was expecting either '*' or '/' for a comment");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void aC() {
/* 2620 */     while (this.e < this.f || an()) {
/*      */       char c;
/* 2622 */       if ((c = this.O[this.e++]) <= '*') {
/* 2623 */         if (c == '*') {
/* 2624 */           if (this.e < this.f || an()) {
/*      */ 
/*      */             
/* 2627 */             if (this.O[this.e] == '/') {
/* 2628 */               this.e++; return;
/*      */             }  continue;
/*      */           } 
/*      */           break;
/*      */         } 
/* 2633 */         if (c < ' ') {
/* 2634 */           if (c == '\n') {
/* 2635 */             this.h++;
/* 2636 */             this.i = this.e; continue;
/* 2637 */           }  if (c == '\r') {
/* 2638 */             aw(); continue;
/* 2639 */           }  if (c != '\t') {
/* 2640 */             f(c);
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/* 2645 */     b(" in a comment", (o)null);
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean aD() {
/* 2650 */     if ((this.b & L) == 0) {
/* 2651 */       return false;
/*      */     }
/* 2653 */     aE();
/* 2654 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void aE() {
/* 2660 */     while (this.e < this.f || an()) {
/*      */       char c;
/* 2662 */       if ((c = this.O[this.e++]) < ' ') {
/* 2663 */         if (c == '\n') {
/* 2664 */           this.h++;
/* 2665 */           this.i = this.e; return;
/*      */         } 
/* 2667 */         if (c == '\r') {
/* 2668 */           aw(); return;
/*      */         } 
/* 2670 */         if (c != '\t') {
/* 2671 */           f(c);
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected final char af() {
/* 2680 */     if (this.e >= this.f && 
/* 2681 */       !an()) {
/* 2682 */       b(" in character escape sequence", o.h);
/*      */     }
/*      */     
/*      */     int i;
/*      */     
/* 2687 */     switch (i = this.O[this.e++]) {
/*      */       
/*      */       case 'b':
/* 2690 */         return '\b';
/*      */       case 't':
/* 2692 */         return '\t';
/*      */       case 'n':
/* 2694 */         return '\n';
/*      */       case 'f':
/* 2696 */         return '\f';
/*      */       case 'r':
/* 2698 */         return '\r';
/*      */ 
/*      */       
/*      */       case '"':
/*      */       case '/':
/*      */       case '\\':
/* 2704 */         return i;
/*      */       
/*      */       case 'u':
/*      */         break;
/*      */       
/*      */       default:
/* 2710 */         return a(i);
/*      */     } 
/*      */ 
/*      */     
/* 2714 */     i = 0;
/* 2715 */     for (byte b1 = 0; b1 < 4; b1++) {
/* 2716 */       if (this.e >= this.f && 
/* 2717 */         !an()) {
/* 2718 */         b(" in character escape sequence", o.h);
/*      */       }
/*      */       
/*      */       char c;
/*      */       int j;
/* 2723 */       if ((j = b.b(c = this.O[this.e++])) < 0) {
/* 2724 */         c(c, "expected a hex-digit for character escape sequence");
/*      */       }
/* 2726 */       i = i << 4 | j;
/*      */     } 
/* 2728 */     return (char)i;
/*      */   } private final void aF() {
/*      */     int i;
/*      */     char[] arrayOfChar;
/*      */     char c;
/* 2733 */     if ((i = this.e) + 3 < this.f && (
/*      */       
/* 2735 */       arrayOfChar = this.O)[i] == 'r' && arrayOfChar[++i] == 'u' && arrayOfChar[++i] == 'e' && ((
/*      */       
/* 2737 */       c = arrayOfChar[++i]) < '0' || c == ']' || c == '}')) {
/* 2738 */       this.e = i;
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/* 2744 */     a("true", 1);
/*      */   } private final void aG() {
/*      */     int i;
/*      */     char[] arrayOfChar;
/*      */     char c;
/* 2749 */     if ((i = this.e) + 4 < this.f && (
/*      */       
/* 2751 */       arrayOfChar = this.O)[i] == 'a' && arrayOfChar[++i] == 'l' && arrayOfChar[++i] == 's' && arrayOfChar[++i] == 'e' && ((
/*      */       
/* 2753 */       c = arrayOfChar[++i]) < '0' || c == ']' || c == '}')) {
/* 2754 */       this.e = i;
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/* 2760 */     a("false", 1);
/*      */   } private final void aH() {
/*      */     int i;
/*      */     char c;
/*      */     char[] arrayOfChar;
/* 2765 */     if ((i = this.e) + 3 < this.f && (
/*      */       
/* 2767 */       arrayOfChar = this.O)[i] == 'u' && arrayOfChar[++i] == 'l' && arrayOfChar[++i] == 'l' && ((
/*      */       
/* 2769 */       c = arrayOfChar[++i]) < '0' || c == ']' || c == '}')) {
/* 2770 */       this.e = i;
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/* 2776 */     a("null", 1);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(String paramString, int paramInt) {
/* 2782 */     int i = paramString.length();
/* 2783 */     if (this.e + i >= this.f) {
/* 2784 */       b(paramString, paramInt);
/*      */       
/*      */       return;
/*      */     } 
/*      */     while (true) {
/* 2789 */       if (this.O[this.e] != paramString.charAt(paramInt)) {
/* 2790 */         h(paramString.substring(0, paramInt));
/*      */       }
/* 2792 */       this.e++;
/* 2793 */       if (++paramInt >= i) {
/*      */         
/* 2795 */         if ((i = this.O[this.e]) >= 48 && i != 93 && i != 125)
/* 2796 */           a(paramString, paramInt, i); 
/*      */         return;
/*      */       } 
/*      */     } 
/*      */   }
/*      */   private final void b(String paramString, int paramInt) {
/* 2802 */     int i = paramString.length();
/*      */     do {
/* 2804 */       if ((this.e >= this.f && !an()) || this.O[this.e] != paramString
/* 2805 */         .charAt(paramInt)) {
/* 2806 */         h(paramString.substring(0, paramInt));
/*      */       }
/* 2808 */       this.e++;
/* 2809 */     } while (++paramInt < i);
/*      */ 
/*      */     
/* 2812 */     if (this.e >= this.f && !an()) {
/*      */       return;
/*      */     }
/*      */     
/* 2816 */     if ((i = this.O[this.e]) >= 48 && i != 93 && i != 125) {
/* 2817 */       a(paramString, paramInt, i);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private final void a(String paramString, int paramInt1, int paramInt2) {
/* 2824 */     if (Character.isJavaIdentifierPart(paramInt2 = (char)paramInt2)) {
/* 2825 */       h(paramString.substring(0, paramInt1));
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
/*      */     //   17: invokevirtual am : ()V
/*      */     //   20: aload_0
/*      */     //   21: getfield O : [C
/*      */     //   24: aload_0
/*      */     //   25: dup
/*      */     //   26: getfield e : I
/*      */     //   29: dup_x1
/*      */     //   30: iconst_1
/*      */     //   31: iadd
/*      */     //   32: putfield e : I
/*      */     //   35: caload
/*      */     //   36: dup
/*      */     //   37: istore_3
/*      */     //   38: bipush #32
/*      */     //   40: if_icmple -> 5
/*      */     //   43: aload_1
/*      */     //   44: iload_3
/*      */     //   45: invokevirtual b : (C)I
/*      */     //   48: dup
/*      */     //   49: istore #4
/*      */     //   51: ifge -> 78
/*      */     //   54: iload_3
/*      */     //   55: bipush #34
/*      */     //   57: if_icmpne -> 65
/*      */     //   60: aload_2
/*      */     //   61: invokevirtual b : ()[B
/*      */     //   64: areturn
/*      */     //   65: aload_0
/*      */     //   66: aload_1
/*      */     //   67: iload_3
/*      */     //   68: iconst_0
/*      */     //   69: invokevirtual a : (Lcom/a/a/b/a;CI)I
/*      */     //   72: dup
/*      */     //   73: istore #4
/*      */     //   75: iflt -> 5
/*      */     //   78: iload #4
/*      */     //   80: istore #5
/*      */     //   82: aload_0
/*      */     //   83: getfield e : I
/*      */     //   86: aload_0
/*      */     //   87: getfield f : I
/*      */     //   90: if_icmplt -> 97
/*      */     //   93: aload_0
/*      */     //   94: invokevirtual am : ()V
/*      */     //   97: aload_0
/*      */     //   98: getfield O : [C
/*      */     //   101: aload_0
/*      */     //   102: dup
/*      */     //   103: getfield e : I
/*      */     //   106: dup_x1
/*      */     //   107: iconst_1
/*      */     //   108: iadd
/*      */     //   109: putfield e : I
/*      */     //   112: caload
/*      */     //   113: istore_3
/*      */     //   114: aload_1
/*      */     //   115: iload_3
/*      */     //   116: invokevirtual b : (C)I
/*      */     //   119: dup
/*      */     //   120: istore #4
/*      */     //   122: ifge -> 134
/*      */     //   125: aload_0
/*      */     //   126: aload_1
/*      */     //   127: iload_3
/*      */     //   128: iconst_1
/*      */     //   129: invokevirtual a : (Lcom/a/a/b/a;CI)I
/*      */     //   132: istore #4
/*      */     //   134: iload #5
/*      */     //   136: bipush #6
/*      */     //   138: ishl
/*      */     //   139: iload #4
/*      */     //   141: ior
/*      */     //   142: istore #5
/*      */     //   144: aload_0
/*      */     //   145: getfield e : I
/*      */     //   148: aload_0
/*      */     //   149: getfield f : I
/*      */     //   152: if_icmplt -> 159
/*      */     //   155: aload_0
/*      */     //   156: invokevirtual am : ()V
/*      */     //   159: aload_0
/*      */     //   160: getfield O : [C
/*      */     //   163: aload_0
/*      */     //   164: dup
/*      */     //   165: getfield e : I
/*      */     //   168: dup_x1
/*      */     //   169: iconst_1
/*      */     //   170: iadd
/*      */     //   171: putfield e : I
/*      */     //   174: caload
/*      */     //   175: istore_3
/*      */     //   176: aload_1
/*      */     //   177: iload_3
/*      */     //   178: invokevirtual b : (C)I
/*      */     //   181: dup
/*      */     //   182: istore #4
/*      */     //   184: ifge -> 353
/*      */     //   187: iload #4
/*      */     //   189: bipush #-2
/*      */     //   191: if_icmpeq -> 248
/*      */     //   194: iload_3
/*      */     //   195: bipush #34
/*      */     //   197: if_icmpne -> 239
/*      */     //   200: iload #5
/*      */     //   202: iconst_4
/*      */     //   203: ishr
/*      */     //   204: istore #5
/*      */     //   206: aload_2
/*      */     //   207: iload #5
/*      */     //   209: invokevirtual a : (I)V
/*      */     //   212: aload_1
/*      */     //   213: invokevirtual a : ()Z
/*      */     //   216: ifeq -> 234
/*      */     //   219: aload_0
/*      */     //   220: dup
/*      */     //   221: getfield e : I
/*      */     //   224: iconst_1
/*      */     //   225: isub
/*      */     //   226: putfield e : I
/*      */     //   229: aload_0
/*      */     //   230: aload_1
/*      */     //   231: invokevirtual b : (Lcom/a/a/b/a;)V
/*      */     //   234: aload_2
/*      */     //   235: invokevirtual b : ()[B
/*      */     //   238: areturn
/*      */     //   239: aload_0
/*      */     //   240: aload_1
/*      */     //   241: iload_3
/*      */     //   242: iconst_2
/*      */     //   243: invokevirtual a : (Lcom/a/a/b/a;CI)I
/*      */     //   246: istore #4
/*      */     //   248: iload #4
/*      */     //   250: bipush #-2
/*      */     //   252: if_icmpne -> 353
/*      */     //   255: aload_0
/*      */     //   256: getfield e : I
/*      */     //   259: aload_0
/*      */     //   260: getfield f : I
/*      */     //   263: if_icmplt -> 270
/*      */     //   266: aload_0
/*      */     //   267: invokevirtual am : ()V
/*      */     //   270: aload_0
/*      */     //   271: getfield O : [C
/*      */     //   274: aload_0
/*      */     //   275: dup
/*      */     //   276: getfield e : I
/*      */     //   279: dup_x1
/*      */     //   280: iconst_1
/*      */     //   281: iadd
/*      */     //   282: putfield e : I
/*      */     //   285: caload
/*      */     //   286: istore_3
/*      */     //   287: aload_1
/*      */     //   288: iload_3
/*      */     //   289: invokevirtual a : (C)Z
/*      */     //   292: ifne -> 338
/*      */     //   295: aload_0
/*      */     //   296: aload_1
/*      */     //   297: iload_3
/*      */     //   298: iconst_3
/*      */     //   299: invokevirtual a : (Lcom/a/a/b/a;CI)I
/*      */     //   302: bipush #-2
/*      */     //   304: if_icmpeq -> 338
/*      */     //   307: aload_1
/*      */     //   308: iload_3
/*      */     //   309: iconst_3
/*      */     //   310: new java/lang/StringBuilder
/*      */     //   313: dup
/*      */     //   314: ldc 'expected padding character ''
/*      */     //   316: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   319: aload_1
/*      */     //   320: invokevirtual b : ()C
/*      */     //   323: invokevirtual append : (C)Ljava/lang/StringBuilder;
/*      */     //   326: ldc '''
/*      */     //   328: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   331: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   334: invokestatic a : (Lcom/a/a/b/a;IILjava/lang/String;)Ljava/lang/IllegalArgumentException;
/*      */     //   337: athrow
/*      */     //   338: iload #5
/*      */     //   340: iconst_4
/*      */     //   341: ishr
/*      */     //   342: istore #5
/*      */     //   344: aload_2
/*      */     //   345: iload #5
/*      */     //   347: invokevirtual a : (I)V
/*      */     //   350: goto -> 5
/*      */     //   353: iload #5
/*      */     //   355: bipush #6
/*      */     //   357: ishl
/*      */     //   358: iload #4
/*      */     //   360: ior
/*      */     //   361: istore #5
/*      */     //   363: aload_0
/*      */     //   364: getfield e : I
/*      */     //   367: aload_0
/*      */     //   368: getfield f : I
/*      */     //   371: if_icmplt -> 378
/*      */     //   374: aload_0
/*      */     //   375: invokevirtual am : ()V
/*      */     //   378: aload_0
/*      */     //   379: getfield O : [C
/*      */     //   382: aload_0
/*      */     //   383: dup
/*      */     //   384: getfield e : I
/*      */     //   387: dup_x1
/*      */     //   388: iconst_1
/*      */     //   389: iadd
/*      */     //   390: putfield e : I
/*      */     //   393: caload
/*      */     //   394: istore_3
/*      */     //   395: aload_1
/*      */     //   396: iload_3
/*      */     //   397: invokevirtual b : (C)I
/*      */     //   400: dup
/*      */     //   401: istore #4
/*      */     //   403: ifge -> 489
/*      */     //   406: iload #4
/*      */     //   408: bipush #-2
/*      */     //   410: if_icmpeq -> 467
/*      */     //   413: iload_3
/*      */     //   414: bipush #34
/*      */     //   416: if_icmpne -> 458
/*      */     //   419: iload #5
/*      */     //   421: iconst_2
/*      */     //   422: ishr
/*      */     //   423: istore #5
/*      */     //   425: aload_2
/*      */     //   426: iload #5
/*      */     //   428: invokevirtual b : (I)V
/*      */     //   431: aload_1
/*      */     //   432: invokevirtual a : ()Z
/*      */     //   435: ifeq -> 453
/*      */     //   438: aload_0
/*      */     //   439: dup
/*      */     //   440: getfield e : I
/*      */     //   443: iconst_1
/*      */     //   444: isub
/*      */     //   445: putfield e : I
/*      */     //   448: aload_0
/*      */     //   449: aload_1
/*      */     //   450: invokevirtual b : (Lcom/a/a/b/a;)V
/*      */     //   453: aload_2
/*      */     //   454: invokevirtual b : ()[B
/*      */     //   457: areturn
/*      */     //   458: aload_0
/*      */     //   459: aload_1
/*      */     //   460: iload_3
/*      */     //   461: iconst_3
/*      */     //   462: invokevirtual a : (Lcom/a/a/b/a;CI)I
/*      */     //   465: istore #4
/*      */     //   467: iload #4
/*      */     //   469: bipush #-2
/*      */     //   471: if_icmpne -> 489
/*      */     //   474: iload #5
/*      */     //   476: iconst_2
/*      */     //   477: ishr
/*      */     //   478: istore #5
/*      */     //   480: aload_2
/*      */     //   481: iload #5
/*      */     //   483: invokevirtual b : (I)V
/*      */     //   486: goto -> 5
/*      */     //   489: iload #5
/*      */     //   491: bipush #6
/*      */     //   493: ishl
/*      */     //   494: iload #4
/*      */     //   496: ior
/*      */     //   497: istore #5
/*      */     //   499: aload_2
/*      */     //   500: iload #5
/*      */     //   502: invokevirtual c : (I)V
/*      */     //   505: goto -> 5
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #2849	-> 0
/*      */     //   #2856	-> 5
/*      */     //   #2857	-> 16
/*      */     //   #2859	-> 20
/*      */     //   #2860	-> 37
/*      */     //   #2861	-> 43
/*      */     //   #2862	-> 49
/*      */     //   #2863	-> 54
/*      */     //   #2864	-> 60
/*      */     //   #2866	-> 65
/*      */     //   #2867	-> 73
/*      */     //   #2871	-> 78
/*      */     //   #2875	-> 82
/*      */     //   #2876	-> 93
/*      */     //   #2878	-> 97
/*      */     //   #2879	-> 114
/*      */     //   #2880	-> 120
/*      */     //   #2881	-> 125
/*      */     //   #2883	-> 134
/*      */     //   #2886	-> 144
/*      */     //   #2887	-> 155
/*      */     //   #2889	-> 159
/*      */     //   #2890	-> 176
/*      */     //   #2893	-> 182
/*      */     //   #2894	-> 187
/*      */     //   #2896	-> 194
/*      */     //   #2897	-> 200
/*      */     //   #2898	-> 206
/*      */     //   #2899	-> 212
/*      */     //   #2900	-> 219
/*      */     //   #2901	-> 229
/*      */     //   #2903	-> 234
/*      */     //   #2905	-> 239
/*      */     //   #2907	-> 248
/*      */     //   #2909	-> 255
/*      */     //   #2910	-> 266
/*      */     //   #2912	-> 270
/*      */     //   #2913	-> 287
/*      */     //   #2914	-> 295
/*      */     //   #2915	-> 307
/*      */     //   #2919	-> 338
/*      */     //   #2920	-> 344
/*      */     //   #2921	-> 350
/*      */     //   #2926	-> 353
/*      */     //   #2928	-> 363
/*      */     //   #2929	-> 374
/*      */     //   #2931	-> 378
/*      */     //   #2932	-> 395
/*      */     //   #2933	-> 401
/*      */     //   #2934	-> 406
/*      */     //   #2936	-> 413
/*      */     //   #2937	-> 419
/*      */     //   #2938	-> 425
/*      */     //   #2939	-> 431
/*      */     //   #2940	-> 438
/*      */     //   #2941	-> 448
/*      */     //   #2943	-> 453
/*      */     //   #2945	-> 458
/*      */     //   #2947	-> 467
/*      */     //   #2953	-> 474
/*      */     //   #2954	-> 480
/*      */     //   #2955	-> 486
/*      */     //   #2960	-> 489
/*      */     //   #2961	-> 499
/*      */     //   #2962	-> 505
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
/*      */   public final j f() {
/* 2974 */     if (this.D == o.f) {
/* 2975 */       long l = this.g + this.U - 1L;
/* 2976 */       return new j(ag(), -1L, l, this.V, this.W);
/*      */     } 
/*      */     
/* 2979 */     return new j(ag(), -1L, this.j - 1L, this.k, this.l);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final j e() {
/* 2985 */     int i = this.e - this.i + 1;
/* 2986 */     return new j(ag(), -1L, this.g + this.e, this.h, i);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final void aI() {
/* 2994 */     int i = this.e;
/* 2995 */     this.j = this.g + i;
/* 2996 */     this.k = this.h;
/* 2997 */     this.l = i - this.i;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private final void aJ() {
/* 3003 */     int i = this.e;
/* 3004 */     this.U = i;
/* 3005 */     this.V = this.h;
/* 3006 */     this.W = i - this.i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void h(String paramString) {
/* 3016 */     a(paramString, ad());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(String paramString1, String paramString2) {
/* 3025 */     StringBuilder stringBuilder = new StringBuilder(paramString1); char c;
/* 3026 */     while ((this.e < this.f || an()) && 
/*      */       
/* 3028 */       Character.isJavaIdentifierPart(c = this.O[this.e])) {
/*      */ 
/*      */       
/* 3031 */       this.e++;
/* 3032 */       stringBuilder.append(c);
/* 3033 */       if (stringBuilder.length() >= 256) {
/* 3034 */         stringBuilder.append("...");
/*      */         break;
/*      */       } 
/*      */     } 
/* 3038 */     a("Unrecognized token '%s': was expecting %s", stringBuilder, paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void n(int paramInt) {
/* 3048 */     if (paramInt == 93) {
/* 3049 */       aI();
/* 3050 */       if (!this.m.b()) {
/* 3051 */         a(paramInt, '}');
/*      */       }
/* 3053 */       this.m = this.m.j();
/* 3054 */       this.D = o.e;
/*      */     } 
/* 3056 */     if (paramInt == 125) {
/* 3057 */       aI();
/* 3058 */       if (!this.m.d()) {
/* 3059 */         a(paramInt, ']');
/*      */       }
/* 3061 */       this.m = this.m.j();
/* 3062 */       this.D = o.c;
/*      */     } 
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\d\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */