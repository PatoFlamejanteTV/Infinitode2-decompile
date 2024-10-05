/*     */ package org.a.b.b;
/*     */ 
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.awt.geom.GeneralPath;
/*     */ import java.awt.geom.Point2D;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.a.a.a.a;
/*     */ import org.a.a.a.c;
/*     */ import org.a.b.d.c;
/*     */ import org.a.b.g.c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class t
/*     */ {
/*  41 */   private static final a c = c.a(t.class);
/*     */   private c d;
/*     */   private final String e;
/*     */   private final String f;
/*  45 */   private GeneralPath g = null;
/*  46 */   private int h = 0;
/*  47 */   private Point2D.Float i = null;
/*  48 */   private Point2D.Float j = null;
/*     */   private boolean k = false;
/*  50 */   private final List<Point2D.Float> l = new ArrayList<Point2D.Float>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected List<Object> a;
/*     */ 
/*     */ 
/*     */   
/*     */   protected int b;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public t(c paramc, String paramString1, String paramString2, List<Object> paramList) {
/*  65 */     this(paramc, paramString1, paramString2);
/*  66 */     this.a = paramList;
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
/*     */   protected t(c paramc, String paramString1, String paramString2) {
/*  78 */     this.d = paramc;
/*  79 */     this.e = paramString1;
/*  80 */     this.f = paramString2;
/*  81 */     this.j = new Point2D.Float(0.0F, 0.0F);
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
/*     */   public final int a() {
/* 112 */     synchronized (c) {
/*     */       
/* 114 */       if (this.g == null)
/*     */       {
/* 116 */         c();
/*     */       }
/*     */     } 
/* 119 */     return this.h;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final GeneralPath b() {
/* 128 */     synchronized (c) {
/*     */       
/* 130 */       if (this.g == null)
/*     */       {
/* 132 */         c();
/*     */       }
/*     */     } 
/* 135 */     return this.g;
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
/*     */   private void c() {
/* 152 */     this.g = new GeneralPath();
/* 153 */     this.i = new Point2D.Float(0.0F, 0.0F);
/* 154 */     this.h = 0;
/*     */ 
/*     */ 
/*     */     
/*     */     u u;
/*     */ 
/*     */ 
/*     */     
/* 162 */     (u = new u(this)).a(this.a);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<Number> a(List<Number> paramList, q paramq) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: dup
/*     */     //   2: getfield b : I
/*     */     //   5: iconst_1
/*     */     //   6: iadd
/*     */     //   7: putfield b : I
/*     */     //   10: getstatic org/a/b/b/q.a : Ljava/util/Map;
/*     */     //   13: aload_2
/*     */     //   14: invokevirtual a : ()Lorg/a/b/b/q$a;
/*     */     //   17: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   22: checkcast java/lang/String
/*     */     //   25: astore_3
/*     */     //   26: ldc 'rmoveto'
/*     */     //   28: aload_3
/*     */     //   29: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   32: ifeq -> 125
/*     */     //   35: aload_1
/*     */     //   36: invokeinterface size : ()I
/*     */     //   41: iconst_2
/*     */     //   42: if_icmplt -> 1265
/*     */     //   45: aload_0
/*     */     //   46: getfield k : Z
/*     */     //   49: ifeq -> 98
/*     */     //   52: aload_0
/*     */     //   53: getfield l : Ljava/util/List;
/*     */     //   56: new java/awt/geom/Point2D$Float
/*     */     //   59: dup
/*     */     //   60: aload_1
/*     */     //   61: iconst_0
/*     */     //   62: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   67: checkcast java/lang/Number
/*     */     //   70: invokevirtual floatValue : ()F
/*     */     //   73: aload_1
/*     */     //   74: iconst_1
/*     */     //   75: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   80: checkcast java/lang/Number
/*     */     //   83: invokevirtual floatValue : ()F
/*     */     //   86: invokespecial <init> : (FF)V
/*     */     //   89: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   94: pop
/*     */     //   95: goto -> 1265
/*     */     //   98: aload_0
/*     */     //   99: aload_1
/*     */     //   100: iconst_0
/*     */     //   101: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   106: checkcast java/lang/Number
/*     */     //   109: aload_1
/*     */     //   110: iconst_1
/*     */     //   111: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   116: checkcast java/lang/Number
/*     */     //   119: invokespecial b : (Ljava/lang/Number;Ljava/lang/Number;)V
/*     */     //   122: goto -> 1265
/*     */     //   125: ldc 'vmoveto'
/*     */     //   127: aload_3
/*     */     //   128: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   131: ifeq -> 205
/*     */     //   134: aload_1
/*     */     //   135: invokeinterface size : ()I
/*     */     //   140: ifle -> 1265
/*     */     //   143: aload_0
/*     */     //   144: getfield k : Z
/*     */     //   147: ifeq -> 184
/*     */     //   150: aload_0
/*     */     //   151: getfield l : Ljava/util/List;
/*     */     //   154: new java/awt/geom/Point2D$Float
/*     */     //   157: dup
/*     */     //   158: fconst_0
/*     */     //   159: aload_1
/*     */     //   160: iconst_0
/*     */     //   161: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   166: checkcast java/lang/Number
/*     */     //   169: invokevirtual floatValue : ()F
/*     */     //   172: invokespecial <init> : (FF)V
/*     */     //   175: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   180: pop
/*     */     //   181: goto -> 1265
/*     */     //   184: aload_0
/*     */     //   185: iconst_0
/*     */     //   186: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   189: aload_1
/*     */     //   190: iconst_0
/*     */     //   191: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   196: checkcast java/lang/Number
/*     */     //   199: invokespecial b : (Ljava/lang/Number;Ljava/lang/Number;)V
/*     */     //   202: goto -> 1265
/*     */     //   205: ldc 'hmoveto'
/*     */     //   207: aload_3
/*     */     //   208: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   211: ifeq -> 285
/*     */     //   214: aload_1
/*     */     //   215: invokeinterface size : ()I
/*     */     //   220: ifle -> 1265
/*     */     //   223: aload_0
/*     */     //   224: getfield k : Z
/*     */     //   227: ifeq -> 264
/*     */     //   230: aload_0
/*     */     //   231: getfield l : Ljava/util/List;
/*     */     //   234: new java/awt/geom/Point2D$Float
/*     */     //   237: dup
/*     */     //   238: aload_1
/*     */     //   239: iconst_0
/*     */     //   240: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   245: checkcast java/lang/Number
/*     */     //   248: invokevirtual floatValue : ()F
/*     */     //   251: fconst_0
/*     */     //   252: invokespecial <init> : (FF)V
/*     */     //   255: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   260: pop
/*     */     //   261: goto -> 1265
/*     */     //   264: aload_0
/*     */     //   265: aload_1
/*     */     //   266: iconst_0
/*     */     //   267: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   272: checkcast java/lang/Number
/*     */     //   275: iconst_0
/*     */     //   276: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   279: invokespecial b : (Ljava/lang/Number;Ljava/lang/Number;)V
/*     */     //   282: goto -> 1265
/*     */     //   285: ldc 'rlineto'
/*     */     //   287: aload_3
/*     */     //   288: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   291: ifeq -> 331
/*     */     //   294: aload_1
/*     */     //   295: invokeinterface size : ()I
/*     */     //   300: iconst_2
/*     */     //   301: if_icmplt -> 1265
/*     */     //   304: aload_0
/*     */     //   305: aload_1
/*     */     //   306: iconst_0
/*     */     //   307: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   312: checkcast java/lang/Number
/*     */     //   315: aload_1
/*     */     //   316: iconst_1
/*     */     //   317: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   322: checkcast java/lang/Number
/*     */     //   325: invokespecial c : (Ljava/lang/Number;Ljava/lang/Number;)V
/*     */     //   328: goto -> 1265
/*     */     //   331: ldc 'hlineto'
/*     */     //   333: aload_3
/*     */     //   334: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   337: ifeq -> 370
/*     */     //   340: aload_1
/*     */     //   341: invokeinterface size : ()I
/*     */     //   346: ifle -> 1265
/*     */     //   349: aload_0
/*     */     //   350: aload_1
/*     */     //   351: iconst_0
/*     */     //   352: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   357: checkcast java/lang/Number
/*     */     //   360: iconst_0
/*     */     //   361: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   364: invokespecial c : (Ljava/lang/Number;Ljava/lang/Number;)V
/*     */     //   367: goto -> 1265
/*     */     //   370: ldc 'vlineto'
/*     */     //   372: aload_3
/*     */     //   373: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   376: ifeq -> 409
/*     */     //   379: aload_1
/*     */     //   380: invokeinterface size : ()I
/*     */     //   385: ifle -> 1265
/*     */     //   388: aload_0
/*     */     //   389: iconst_0
/*     */     //   390: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   393: aload_1
/*     */     //   394: iconst_0
/*     */     //   395: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   400: checkcast java/lang/Number
/*     */     //   403: invokespecial c : (Ljava/lang/Number;Ljava/lang/Number;)V
/*     */     //   406: goto -> 1265
/*     */     //   409: ldc 'rrcurveto'
/*     */     //   411: aload_3
/*     */     //   412: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   415: ifeq -> 496
/*     */     //   418: aload_1
/*     */     //   419: invokeinterface size : ()I
/*     */     //   424: bipush #6
/*     */     //   426: if_icmplt -> 1265
/*     */     //   429: aload_0
/*     */     //   430: aload_1
/*     */     //   431: iconst_0
/*     */     //   432: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   437: checkcast java/lang/Number
/*     */     //   440: aload_1
/*     */     //   441: iconst_1
/*     */     //   442: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   447: checkcast java/lang/Number
/*     */     //   450: aload_1
/*     */     //   451: iconst_2
/*     */     //   452: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   457: checkcast java/lang/Number
/*     */     //   460: aload_1
/*     */     //   461: iconst_3
/*     */     //   462: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   467: checkcast java/lang/Number
/*     */     //   470: aload_1
/*     */     //   471: iconst_4
/*     */     //   472: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   477: checkcast java/lang/Number
/*     */     //   480: aload_1
/*     */     //   481: iconst_5
/*     */     //   482: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   487: checkcast java/lang/Number
/*     */     //   490: invokespecial a : (Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;)V
/*     */     //   493: goto -> 1265
/*     */     //   496: ldc 'closepath'
/*     */     //   498: aload_3
/*     */     //   499: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   502: ifeq -> 512
/*     */     //   505: aload_0
/*     */     //   506: invokespecial d : ()V
/*     */     //   509: goto -> 1265
/*     */     //   512: ldc 'sbw'
/*     */     //   514: aload_3
/*     */     //   515: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   518: ifeq -> 599
/*     */     //   521: aload_1
/*     */     //   522: invokeinterface size : ()I
/*     */     //   527: iconst_3
/*     */     //   528: if_icmplt -> 1265
/*     */     //   531: aload_0
/*     */     //   532: new java/awt/geom/Point2D$Float
/*     */     //   535: dup
/*     */     //   536: aload_1
/*     */     //   537: iconst_0
/*     */     //   538: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   543: checkcast java/lang/Number
/*     */     //   546: invokevirtual floatValue : ()F
/*     */     //   549: aload_1
/*     */     //   550: iconst_1
/*     */     //   551: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   556: checkcast java/lang/Number
/*     */     //   559: invokevirtual floatValue : ()F
/*     */     //   562: invokespecial <init> : (FF)V
/*     */     //   565: putfield i : Ljava/awt/geom/Point2D$Float;
/*     */     //   568: aload_0
/*     */     //   569: aload_1
/*     */     //   570: iconst_2
/*     */     //   571: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   576: checkcast java/lang/Number
/*     */     //   579: invokevirtual intValue : ()I
/*     */     //   582: putfield h : I
/*     */     //   585: aload_0
/*     */     //   586: getfield j : Ljava/awt/geom/Point2D$Float;
/*     */     //   589: aload_0
/*     */     //   590: getfield i : Ljava/awt/geom/Point2D$Float;
/*     */     //   593: invokevirtual setLocation : (Ljava/awt/geom/Point2D;)V
/*     */     //   596: goto -> 1265
/*     */     //   599: ldc 'hsbw'
/*     */     //   601: aload_3
/*     */     //   602: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   605: ifeq -> 674
/*     */     //   608: aload_1
/*     */     //   609: invokeinterface size : ()I
/*     */     //   614: iconst_2
/*     */     //   615: if_icmplt -> 1265
/*     */     //   618: aload_0
/*     */     //   619: new java/awt/geom/Point2D$Float
/*     */     //   622: dup
/*     */     //   623: aload_1
/*     */     //   624: iconst_0
/*     */     //   625: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   630: checkcast java/lang/Number
/*     */     //   633: invokevirtual floatValue : ()F
/*     */     //   636: fconst_0
/*     */     //   637: invokespecial <init> : (FF)V
/*     */     //   640: putfield i : Ljava/awt/geom/Point2D$Float;
/*     */     //   643: aload_0
/*     */     //   644: aload_1
/*     */     //   645: iconst_1
/*     */     //   646: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   651: checkcast java/lang/Number
/*     */     //   654: invokevirtual intValue : ()I
/*     */     //   657: putfield h : I
/*     */     //   660: aload_0
/*     */     //   661: getfield j : Ljava/awt/geom/Point2D$Float;
/*     */     //   664: aload_0
/*     */     //   665: getfield i : Ljava/awt/geom/Point2D$Float;
/*     */     //   668: invokevirtual setLocation : (Ljava/awt/geom/Point2D;)V
/*     */     //   671: goto -> 1265
/*     */     //   674: ldc 'vhcurveto'
/*     */     //   676: aload_3
/*     */     //   677: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   680: ifeq -> 748
/*     */     //   683: aload_1
/*     */     //   684: invokeinterface size : ()I
/*     */     //   689: iconst_4
/*     */     //   690: if_icmplt -> 1265
/*     */     //   693: aload_0
/*     */     //   694: iconst_0
/*     */     //   695: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   698: aload_1
/*     */     //   699: iconst_0
/*     */     //   700: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   705: checkcast java/lang/Number
/*     */     //   708: aload_1
/*     */     //   709: iconst_1
/*     */     //   710: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   715: checkcast java/lang/Number
/*     */     //   718: aload_1
/*     */     //   719: iconst_2
/*     */     //   720: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   725: checkcast java/lang/Number
/*     */     //   728: aload_1
/*     */     //   729: iconst_3
/*     */     //   730: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   735: checkcast java/lang/Number
/*     */     //   738: iconst_0
/*     */     //   739: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   742: invokespecial a : (Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;)V
/*     */     //   745: goto -> 1265
/*     */     //   748: ldc 'hvcurveto'
/*     */     //   750: aload_3
/*     */     //   751: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   754: ifeq -> 822
/*     */     //   757: aload_1
/*     */     //   758: invokeinterface size : ()I
/*     */     //   763: iconst_4
/*     */     //   764: if_icmplt -> 1265
/*     */     //   767: aload_0
/*     */     //   768: aload_1
/*     */     //   769: iconst_0
/*     */     //   770: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   775: checkcast java/lang/Number
/*     */     //   778: iconst_0
/*     */     //   779: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   782: aload_1
/*     */     //   783: iconst_1
/*     */     //   784: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   789: checkcast java/lang/Number
/*     */     //   792: aload_1
/*     */     //   793: iconst_2
/*     */     //   794: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   799: checkcast java/lang/Number
/*     */     //   802: iconst_0
/*     */     //   803: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   806: aload_1
/*     */     //   807: iconst_3
/*     */     //   808: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   813: checkcast java/lang/Number
/*     */     //   816: invokespecial a : (Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;)V
/*     */     //   819: goto -> 1265
/*     */     //   822: ldc 'seac'
/*     */     //   824: aload_3
/*     */     //   825: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   828: ifeq -> 898
/*     */     //   831: aload_1
/*     */     //   832: invokeinterface size : ()I
/*     */     //   837: iconst_5
/*     */     //   838: if_icmplt -> 1265
/*     */     //   841: aload_0
/*     */     //   842: aload_1
/*     */     //   843: iconst_0
/*     */     //   844: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   849: checkcast java/lang/Number
/*     */     //   852: aload_1
/*     */     //   853: iconst_1
/*     */     //   854: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   859: checkcast java/lang/Number
/*     */     //   862: aload_1
/*     */     //   863: iconst_2
/*     */     //   864: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   869: checkcast java/lang/Number
/*     */     //   872: aload_1
/*     */     //   873: iconst_3
/*     */     //   874: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   879: checkcast java/lang/Number
/*     */     //   882: aload_1
/*     */     //   883: iconst_4
/*     */     //   884: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   889: checkcast java/lang/Number
/*     */     //   892: invokespecial a : (Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;)V
/*     */     //   895: goto -> 1265
/*     */     //   898: ldc 'setcurrentpoint'
/*     */     //   900: aload_3
/*     */     //   901: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   904: ifeq -> 944
/*     */     //   907: aload_1
/*     */     //   908: invokeinterface size : ()I
/*     */     //   913: iconst_2
/*     */     //   914: if_icmplt -> 1265
/*     */     //   917: aload_0
/*     */     //   918: aload_1
/*     */     //   919: iconst_0
/*     */     //   920: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   925: checkcast java/lang/Number
/*     */     //   928: aload_1
/*     */     //   929: iconst_1
/*     */     //   930: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   935: checkcast java/lang/Number
/*     */     //   938: invokespecial a : (Ljava/lang/Number;Ljava/lang/Number;)V
/*     */     //   941: goto -> 1265
/*     */     //   944: ldc 'callothersubr'
/*     */     //   946: aload_3
/*     */     //   947: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   950: ifeq -> 982
/*     */     //   953: aload_1
/*     */     //   954: invokeinterface size : ()I
/*     */     //   959: ifle -> 1265
/*     */     //   962: aload_0
/*     */     //   963: aload_1
/*     */     //   964: iconst_0
/*     */     //   965: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   970: checkcast java/lang/Number
/*     */     //   973: invokevirtual intValue : ()I
/*     */     //   976: invokespecial a : (I)V
/*     */     //   979: goto -> 1265
/*     */     //   982: ldc 'div'
/*     */     //   984: aload_3
/*     */     //   985: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   988: ifeq -> 1089
/*     */     //   991: aload_1
/*     */     //   992: dup
/*     */     //   993: invokeinterface size : ()I
/*     */     //   998: iconst_1
/*     */     //   999: isub
/*     */     //   1000: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   1005: checkcast java/lang/Number
/*     */     //   1008: invokevirtual floatValue : ()F
/*     */     //   1011: fstore_2
/*     */     //   1012: aload_1
/*     */     //   1013: dup
/*     */     //   1014: invokeinterface size : ()I
/*     */     //   1019: iconst_2
/*     */     //   1020: isub
/*     */     //   1021: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   1026: checkcast java/lang/Number
/*     */     //   1029: invokevirtual floatValue : ()F
/*     */     //   1032: dup
/*     */     //   1033: fstore_3
/*     */     //   1034: fload_2
/*     */     //   1035: fdiv
/*     */     //   1036: fstore_2
/*     */     //   1037: new java/util/ArrayList
/*     */     //   1040: dup
/*     */     //   1041: aload_1
/*     */     //   1042: invokespecial <init> : (Ljava/util/Collection;)V
/*     */     //   1045: dup
/*     */     //   1046: astore_1
/*     */     //   1047: aload_1
/*     */     //   1048: invokeinterface size : ()I
/*     */     //   1053: iconst_1
/*     */     //   1054: isub
/*     */     //   1055: invokeinterface remove : (I)Ljava/lang/Object;
/*     */     //   1060: pop
/*     */     //   1061: aload_1
/*     */     //   1062: dup
/*     */     //   1063: invokeinterface size : ()I
/*     */     //   1068: iconst_1
/*     */     //   1069: isub
/*     */     //   1070: invokeinterface remove : (I)Ljava/lang/Object;
/*     */     //   1075: pop
/*     */     //   1076: aload_1
/*     */     //   1077: fload_2
/*     */     //   1078: invokestatic valueOf : (F)Ljava/lang/Float;
/*     */     //   1081: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   1086: pop
/*     */     //   1087: aload_1
/*     */     //   1088: areturn
/*     */     //   1089: ldc 'hstem'
/*     */     //   1091: aload_3
/*     */     //   1092: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1095: ifne -> 1265
/*     */     //   1098: ldc 'vstem'
/*     */     //   1100: aload_3
/*     */     //   1101: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1104: ifne -> 1265
/*     */     //   1107: ldc 'hstem3'
/*     */     //   1109: aload_3
/*     */     //   1110: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1113: ifne -> 1265
/*     */     //   1116: ldc 'vstem3'
/*     */     //   1118: aload_3
/*     */     //   1119: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1122: ifne -> 1265
/*     */     //   1125: ldc 'dotsection'
/*     */     //   1127: aload_3
/*     */     //   1128: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1131: ifne -> 1265
/*     */     //   1134: ldc 'endchar'
/*     */     //   1136: aload_3
/*     */     //   1137: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1140: ifne -> 1265
/*     */     //   1143: ldc 'return'
/*     */     //   1145: aload_3
/*     */     //   1146: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1149: ifeq -> 1196
/*     */     //   1152: new java/lang/StringBuilder
/*     */     //   1155: dup
/*     */     //   1156: ldc 'Unexpected charstring command: '
/*     */     //   1158: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1161: aload_2
/*     */     //   1162: invokevirtual a : ()Lorg/a/b/b/q$a;
/*     */     //   1165: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   1168: ldc ' in glyph '
/*     */     //   1170: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1173: aload_0
/*     */     //   1174: getfield f : Ljava/lang/String;
/*     */     //   1177: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1180: ldc ' of font '
/*     */     //   1182: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1185: aload_0
/*     */     //   1186: getfield e : Ljava/lang/String;
/*     */     //   1189: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1192: pop
/*     */     //   1193: goto -> 1265
/*     */     //   1196: aload_3
/*     */     //   1197: ifnull -> 1224
/*     */     //   1200: new java/lang/IllegalArgumentException
/*     */     //   1203: dup
/*     */     //   1204: new java/lang/StringBuilder
/*     */     //   1207: dup
/*     */     //   1208: ldc 'Unhandled command: '
/*     */     //   1210: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1213: aload_3
/*     */     //   1214: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1217: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1220: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1223: athrow
/*     */     //   1224: new java/lang/StringBuilder
/*     */     //   1227: dup
/*     */     //   1228: ldc 'Unknown charstring command: '
/*     */     //   1230: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1233: aload_2
/*     */     //   1234: invokevirtual a : ()Lorg/a/b/b/q$a;
/*     */     //   1237: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   1240: ldc ' in glyph '
/*     */     //   1242: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1245: aload_0
/*     */     //   1246: getfield f : Ljava/lang/String;
/*     */     //   1249: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1252: ldc ' of font '
/*     */     //   1254: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1257: aload_0
/*     */     //   1258: getfield e : Ljava/lang/String;
/*     */     //   1261: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1264: pop
/*     */     //   1265: aconst_null
/*     */     //   1266: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #167	-> 0
/*     */     //   #168	-> 10
/*     */     //   #170	-> 26
/*     */     //   #172	-> 35
/*     */     //   #174	-> 45
/*     */     //   #176	-> 52
/*     */     //   #180	-> 98
/*     */     //   #184	-> 125
/*     */     //   #186	-> 134
/*     */     //   #188	-> 143
/*     */     //   #191	-> 150
/*     */     //   #195	-> 184
/*     */     //   #199	-> 205
/*     */     //   #201	-> 214
/*     */     //   #203	-> 223
/*     */     //   #206	-> 230
/*     */     //   #210	-> 264
/*     */     //   #214	-> 285
/*     */     //   #216	-> 294
/*     */     //   #218	-> 304
/*     */     //   #221	-> 331
/*     */     //   #223	-> 340
/*     */     //   #225	-> 349
/*     */     //   #228	-> 370
/*     */     //   #230	-> 379
/*     */     //   #232	-> 388
/*     */     //   #235	-> 409
/*     */     //   #237	-> 418
/*     */     //   #239	-> 429
/*     */     //   #240	-> 462
/*     */     //   #239	-> 490
/*     */     //   #243	-> 496
/*     */     //   #245	-> 505
/*     */     //   #247	-> 512
/*     */     //   #249	-> 521
/*     */     //   #251	-> 531
/*     */     //   #252	-> 568
/*     */     //   #253	-> 585
/*     */     //   #256	-> 599
/*     */     //   #258	-> 608
/*     */     //   #260	-> 618
/*     */     //   #261	-> 643
/*     */     //   #262	-> 660
/*     */     //   #265	-> 674
/*     */     //   #267	-> 683
/*     */     //   #269	-> 693
/*     */     //   #270	-> 720
/*     */     //   #269	-> 742
/*     */     //   #273	-> 748
/*     */     //   #275	-> 757
/*     */     //   #277	-> 767
/*     */     //   #278	-> 794
/*     */     //   #277	-> 816
/*     */     //   #281	-> 822
/*     */     //   #283	-> 831
/*     */     //   #285	-> 841
/*     */     //   #288	-> 898
/*     */     //   #290	-> 907
/*     */     //   #292	-> 917
/*     */     //   #295	-> 944
/*     */     //   #297	-> 953
/*     */     //   #299	-> 962
/*     */     //   #302	-> 982
/*     */     //   #304	-> 991
/*     */     //   #305	-> 1012
/*     */     //   #307	-> 1033
/*     */     //   #309	-> 1037
/*     */     //   #310	-> 1046
/*     */     //   #311	-> 1061
/*     */     //   #312	-> 1076
/*     */     //   #313	-> 1087
/*     */     //   #315	-> 1089
/*     */     //   #316	-> 1110
/*     */     //   #320	-> 1134
/*     */     //   #324	-> 1143
/*     */     //   #327	-> 1152
/*     */     //   #330	-> 1196
/*     */     //   #333	-> 1200
/*     */     //   #338	-> 1224
/*     */     //   #341	-> 1265
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(Number paramNumber1, Number paramNumber2) {
/* 350 */     this.j.setLocation(paramNumber1.floatValue(), paramNumber2.floatValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(int paramInt) {
/*     */     Point2D.Float float_;
/* 359 */     if (paramInt == 0) {
/*     */ 
/*     */       
/* 362 */       this.k = false;
/*     */       
/* 364 */       if (this.l.size() < 7) {
/*     */         
/* 366 */         (new StringBuilder("flex without moveTo in font ")).append(this.e).append(", glyph ").append(this.f).append(", command ").append(this.b);
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */ 
/*     */       
/* 373 */       (float_ = this.l.get(0)).setLocation(this.j.getX() + float_.getX(), this.j
/* 374 */           .getY() + float_.getY());
/*     */       
/*     */       Point2D.Float float_1;
/*     */       
/* 378 */       (float_1 = this.l.get(1)).setLocation(float_.getX() + float_1.getX(), float_.getY() + float_1.getY());
/*     */ 
/*     */       
/* 381 */       float_1.setLocation(float_1.getX() - this.j.getX(), float_1.getY() - this.j.getY());
/*     */       
/* 383 */       a(Double.valueOf(((Point2D.Float)this.l.get(1)).getX()), Double.valueOf(((Point2D.Float)this.l.get(1)).getY()), 
/* 384 */           Double.valueOf(((Point2D.Float)this.l.get(2)).getX()), Double.valueOf(((Point2D.Float)this.l.get(2)).getY()), 
/* 385 */           Double.valueOf(((Point2D.Float)this.l.get(3)).getX()), Double.valueOf(((Point2D.Float)this.l.get(3)).getY()));
/*     */       
/* 387 */       a(Double.valueOf(((Point2D.Float)this.l.get(4)).getX()), Double.valueOf(((Point2D.Float)this.l.get(4)).getY()), 
/* 388 */           Double.valueOf(((Point2D.Float)this.l.get(5)).getX()), Double.valueOf(((Point2D.Float)this.l.get(5)).getY()), 
/* 389 */           Double.valueOf(((Point2D.Float)this.l.get(6)).getX()), Double.valueOf(((Point2D.Float)this.l.get(6)).getY()));
/*     */       
/* 391 */       this.l.clear(); return;
/*     */     } 
/* 393 */     if (float_ == true) {
/*     */ 
/*     */       
/* 396 */       this.k = true;
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 401 */     throw new IllegalArgumentException("Unexpected other subroutine: " + float_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(Number paramNumber1, Number paramNumber2) {
/* 410 */     float f1 = (float)this.j.getX() + paramNumber1.floatValue();
/* 411 */     float f2 = (float)this.j.getY() + paramNumber2.floatValue();
/* 412 */     this.g.moveTo(f1, f2);
/* 413 */     this.j.setLocation(f1, f2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void c(Number paramNumber1, Number paramNumber2) {
/* 421 */     float f1 = (float)this.j.getX() + paramNumber1.floatValue();
/* 422 */     float f2 = (float)this.j.getY() + paramNumber2.floatValue();
/* 423 */     if (this.g.getCurrentPoint() == null) {
/*     */       
/* 425 */       (new StringBuilder("rlineTo without initial moveTo in font ")).append(this.e).append(", glyph ").append(this.f);
/* 426 */       this.g.moveTo(f1, f2);
/*     */     }
/*     */     else {
/*     */       
/* 430 */       this.g.lineTo(f1, f2);
/*     */     } 
/* 432 */     this.j.setLocation(f1, f2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(Number paramNumber1, Number paramNumber2, Number paramNumber3, Number paramNumber4, Number paramNumber5, Number paramNumber6) {
/* 441 */     float f1 = (float)this.j.getX() + paramNumber1.floatValue();
/* 442 */     float f2 = (float)this.j.getY() + paramNumber2.floatValue();
/* 443 */     float f3 = f1 + paramNumber3.floatValue();
/* 444 */     float f4 = f2 + paramNumber4.floatValue();
/* 445 */     float f5 = f3 + paramNumber5.floatValue();
/* 446 */     float f6 = f4 + paramNumber6.floatValue();
/* 447 */     if (this.g.getCurrentPoint() == null) {
/*     */       
/* 449 */       (new StringBuilder("rrcurveTo without initial moveTo in font ")).append(this.e).append(", glyph ").append(this.f);
/* 450 */       this.g.moveTo(f5, f6);
/*     */     }
/*     */     else {
/*     */       
/* 454 */       this.g.curveTo(f1, f2, f3, f4, f5, f6);
/*     */     } 
/* 456 */     this.j.setLocation(f5, f6);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void d() {
/* 464 */     if (this.g.getCurrentPoint() == null) {
/*     */       
/* 466 */       (new StringBuilder("closepath without initial moveTo in font ")).append(this.e).append(", glyph ").append(this.f);
/*     */     }
/*     */     else {
/*     */       
/* 470 */       this.g.closePath();
/*     */     } 
/* 472 */     this.g.moveTo(this.j.getX(), this.j.getY());
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
/*     */   private void a(Number paramNumber1, Number paramNumber2, Number paramNumber3, Number paramNumber4, Number paramNumber5) {
/* 484 */     String str = c.a.a(paramNumber4.intValue());
/*     */     
/*     */     try {
/* 487 */       t t1 = this.d.a_(str);
/* 488 */       this.g.append(t1.b().getPathIterator((AffineTransform)null), false);
/*     */     }
/* 490 */     catch (IOException iOException) {
/*     */       
/* 492 */       (new StringBuilder("invalid seac character in glyph ")).append(this.f).append(" of font ").append(this.e);
/*     */     } 
/*     */     
/* 495 */     str = c.a.a(paramNumber5.intValue());
/*     */     
/*     */     try {
/* 498 */       t t1 = this.d.a_(str);
/* 499 */       AffineTransform affineTransform = AffineTransform.getTranslateInstance(this.i
/* 500 */           .getX() + paramNumber2.floatValue() - paramNumber1.floatValue(), this.i
/* 501 */           .getY() + paramNumber3.floatValue());
/* 502 */       this.g.append(t1.b().getPathIterator(affineTransform), false);
/*     */       return;
/* 504 */     } catch (IOException iOException) {
/*     */       
/* 506 */       (new StringBuilder("invalid seac character in glyph ")).append(this.f).append(" of font ").append(this.e);
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 513 */     return this.a.toString().replace("|", "\n").replace(",", " ");
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\b\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */