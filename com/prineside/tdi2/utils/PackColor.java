/*     */ package com.prineside.tdi2.utils;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ 
/*     */ public class PackColor
/*     */   extends Color
/*     */ {
/*     */   private Color[] c;
/*     */   private int d;
/*  12 */   private static final Array<Color> e = new Array(true, 1, Color.class);
/*  13 */   private static final float[] f = new float[3];
/*     */ 
/*     */   
/*     */   public PackColor() {}
/*     */ 
/*     */   
/*     */   public PackColor(Color paramColor) {
/*  20 */     super(paramColor);
/*     */     
/*  22 */     if (paramColor instanceof PackColor) {
/*  23 */       from((PackColor)paramColor);
/*     */     }
/*     */   }
/*     */   
/*     */   public PackColor(int paramInt) {
/*  28 */     super(paramInt);
/*     */   }
/*     */   
/*     */   public boolean isArray() {
/*  32 */     return (this.d != 0);
/*     */   }
/*     */   
/*     */   public Array<Color> getColorArray() {
/*  36 */     e.clear();
/*  37 */     if (this.d != 0) {
/*  38 */       for (byte b = 0; b < this.d; b++) {
/*  39 */         e.add(this.c[b]);
/*     */       }
/*     */     }
/*  42 */     return e;
/*     */   }
/*     */   
/*     */   public Color getColorAtIndex(int paramInt) {
/*  46 */     if (this.c == null) {
/*  47 */       return this;
/*     */     }
/*  49 */     if (this.c.length <= paramInt)
/*  50 */       return this.c[this.c.length - 1]; 
/*  51 */     if (paramInt < 0) {
/*  52 */       return this.c[0];
/*     */     }
/*  54 */     return this.c[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PackColor from(PackColor paramPackColor) {
/*  60 */     set(paramPackColor);
/*     */     
/*  62 */     if (paramPackColor.c != null) {
/*  63 */       if (this.c == null) {
/*     */         
/*  65 */         this.c = paramPackColor.c;
/*     */       } else {
/*     */         
/*  68 */         if (paramPackColor.c.length > this.c.length) {
/*     */           
/*  70 */           Color[] arrayOfColor = new Color[paramPackColor.c.length];
/*  71 */           System.arraycopy(this.c, 0, arrayOfColor, 0, this.c.length);
/*  72 */           this.c = arrayOfColor;
/*     */         } 
/*     */         
/*  75 */         int i = Math.min(paramPackColor.c.length, this.c.length);
/*  76 */         for (byte b = 0; b < i; b++) {
/*  77 */           this.c[b].set(paramPackColor.c[b]);
/*     */         }
/*     */       } 
/*     */     }
/*  81 */     this.d = paramPackColor.d;
/*     */     
/*  83 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  88 */     if (this.c == null) {
/*  89 */       return super.toString();
/*     */     }
/*  91 */     StringBuilder stringBuilder = new StringBuilder(super.toString() + " " + this.d + " [");
/*  92 */     byte b1 = 0; Color[] arrayOfColor; int i; byte b2;
/*  93 */     for (i = (arrayOfColor = this.c).length, b2 = 0; b2 < i; ) { Color color = arrayOfColor[b2];
/*  94 */       if (b1) {
/*  95 */         stringBuilder.append(",");
/*     */       }
/*  97 */       StringBuilder stringBuilder1 = new StringBuilder(Integer.toHexString((int)(255.0F * color.r) << 24 | (int)(255.0F * color.g) << 16 | (int)(255.0F * color.b) << 8 | (int)(255.0F * color.a)));
/*  98 */       while (stringBuilder1.length() < 8)
/*  99 */         stringBuilder1.insert(0, "0"); 
/* 100 */       stringBuilder.append(stringBuilder1);
/* 101 */       b1++;
/*     */       b2++; }
/*     */     
/* 104 */     stringBuilder.append("]");
/*     */     
/* 106 */     return stringBuilder.toString();
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
/*     */   public static PackColor parseColorConfigArray(String[] paramArrayOfString, ObjectMap<String, PackColor> paramObjectMap) {
/*     */     PackColor packColor;
/* 120 */     (packColor = new PackColor()).c = new Color[paramArrayOfString.length];
/* 121 */     byte b1 = 0; int i; byte b2;
/* 122 */     for (i = (paramArrayOfString = paramArrayOfString).length, b2 = 0; b2 < i; ) { String str = paramArrayOfString[b2];
/* 123 */       packColor.c[b1++] = parseColorConfig(str, paramObjectMap); b2++; }
/*     */     
/* 125 */     packColor.d = packColor.c.length;
/* 126 */     packColor.set(packColor.c[0]);
/*     */     
/* 128 */     return packColor;
/*     */   }
/*     */   
/*     */   public static PackColor fromColors(Color... paramVarArgs) {
/*     */     PackColor packColor;
/* 133 */     (packColor = new PackColor()).c = new Color[paramVarArgs.length];
/* 134 */     System.arraycopy(paramVarArgs, 0, packColor.c, 0, paramVarArgs.length);
/* 135 */     return packColor;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static PackColor parseColorConfig(String paramString, ObjectMap<String, PackColor> paramObjectMap) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: ldc '>'
/*     */     //   3: invokevirtual contains : (Ljava/lang/CharSequence;)Z
/*     */     //   6: ifeq -> 1322
/*     */     //   9: aload_0
/*     */     //   10: ldc '>'
/*     */     //   12: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
/*     */     //   15: dup
/*     */     //   16: astore_0
/*     */     //   17: iconst_0
/*     */     //   18: aaload
/*     */     //   19: invokevirtual trim : ()Ljava/lang/String;
/*     */     //   22: aload_1
/*     */     //   23: invokestatic parseColorValue : (Ljava/lang/String;Lcom/badlogic/gdx/utils/ObjectMap;)Lcom/badlogic/gdx/graphics/Color;
/*     */     //   26: astore_2
/*     */     //   27: iconst_1
/*     */     //   28: istore_3
/*     */     //   29: iload_3
/*     */     //   30: aload_0
/*     */     //   31: arraylength
/*     */     //   32: if_icmpge -> 1313
/*     */     //   35: aload_0
/*     */     //   36: iload_3
/*     */     //   37: aaload
/*     */     //   38: invokevirtual trim : ()Ljava/lang/String;
/*     */     //   41: astore #4
/*     */     //   43: aload #4
/*     */     //   45: dup
/*     */     //   46: bipush #40
/*     */     //   48: invokevirtual indexOf : (I)I
/*     */     //   51: iconst_1
/*     */     //   52: iadd
/*     */     //   53: aload #4
/*     */     //   55: bipush #41
/*     */     //   57: invokevirtual indexOf : (I)I
/*     */     //   60: invokevirtual substring : (II)Ljava/lang/String;
/*     */     //   63: astore #5
/*     */     //   65: aload #4
/*     */     //   67: iconst_0
/*     */     //   68: invokevirtual charAt : (I)C
/*     */     //   71: bipush #43
/*     */     //   73: if_icmpne -> 230
/*     */     //   76: aload #5
/*     */     //   78: ldc ','
/*     */     //   80: invokevirtual contains : (Ljava/lang/CharSequence;)Z
/*     */     //   83: ifeq -> 206
/*     */     //   86: aload #5
/*     */     //   88: ldc ','
/*     */     //   90: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
/*     */     //   93: astore #5
/*     */     //   95: iconst_0
/*     */     //   96: istore #6
/*     */     //   98: iload #6
/*     */     //   100: iconst_4
/*     */     //   101: if_icmpge -> 203
/*     */     //   104: aload #5
/*     */     //   106: iload #6
/*     */     //   108: aaload
/*     */     //   109: invokevirtual trim : ()Ljava/lang/String;
/*     */     //   112: invokestatic parseFloat : (Ljava/lang/String;)F
/*     */     //   115: fstore #7
/*     */     //   117: iload #6
/*     */     //   119: tableswitch default -> 186, 0 -> 144, 1 -> 158, 2 -> 172
/*     */     //   144: aload_2
/*     */     //   145: dup
/*     */     //   146: getfield r : F
/*     */     //   149: fload #7
/*     */     //   151: fadd
/*     */     //   152: putfield r : F
/*     */     //   155: goto -> 197
/*     */     //   158: aload_2
/*     */     //   159: dup
/*     */     //   160: getfield g : F
/*     */     //   163: fload #7
/*     */     //   165: fadd
/*     */     //   166: putfield g : F
/*     */     //   169: goto -> 197
/*     */     //   172: aload_2
/*     */     //   173: dup
/*     */     //   174: getfield b : F
/*     */     //   177: fload #7
/*     */     //   179: fadd
/*     */     //   180: putfield b : F
/*     */     //   183: goto -> 197
/*     */     //   186: aload_2
/*     */     //   187: dup
/*     */     //   188: getfield a : F
/*     */     //   191: fload #7
/*     */     //   193: fadd
/*     */     //   194: putfield a : F
/*     */     //   197: iinc #6, 1
/*     */     //   200: goto -> 98
/*     */     //   203: goto -> 1265
/*     */     //   206: aload #5
/*     */     //   208: invokevirtual trim : ()Ljava/lang/String;
/*     */     //   211: invokestatic parseFloat : (Ljava/lang/String;)F
/*     */     //   214: fstore #5
/*     */     //   216: aload_2
/*     */     //   217: fload #5
/*     */     //   219: dup
/*     */     //   220: fload #5
/*     */     //   222: dup
/*     */     //   223: invokevirtual add : (FFFF)Lcom/badlogic/gdx/graphics/Color;
/*     */     //   226: pop
/*     */     //   227: goto -> 1265
/*     */     //   230: aload #4
/*     */     //   232: iconst_0
/*     */     //   233: invokevirtual charAt : (I)C
/*     */     //   236: bipush #45
/*     */     //   238: if_icmpne -> 398
/*     */     //   241: aload #5
/*     */     //   243: ldc ','
/*     */     //   245: invokevirtual contains : (Ljava/lang/CharSequence;)Z
/*     */     //   248: ifeq -> 374
/*     */     //   251: aload #5
/*     */     //   253: ldc ','
/*     */     //   255: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
/*     */     //   258: astore #5
/*     */     //   260: iconst_0
/*     */     //   261: istore #6
/*     */     //   263: iload #6
/*     */     //   265: iconst_4
/*     */     //   266: if_icmpge -> 371
/*     */     //   269: aload #5
/*     */     //   271: iload #6
/*     */     //   273: aaload
/*     */     //   274: invokevirtual trim : ()Ljava/lang/String;
/*     */     //   277: invokestatic parseFloat : (Ljava/lang/String;)F
/*     */     //   280: fstore #7
/*     */     //   282: iload #6
/*     */     //   284: tableswitch default -> 354, 0 -> 312, 1 -> 326, 2 -> 340
/*     */     //   312: aload_2
/*     */     //   313: dup
/*     */     //   314: getfield r : F
/*     */     //   317: fload #7
/*     */     //   319: fsub
/*     */     //   320: putfield r : F
/*     */     //   323: goto -> 365
/*     */     //   326: aload_2
/*     */     //   327: dup
/*     */     //   328: getfield g : F
/*     */     //   331: fload #7
/*     */     //   333: fsub
/*     */     //   334: putfield g : F
/*     */     //   337: goto -> 365
/*     */     //   340: aload_2
/*     */     //   341: dup
/*     */     //   342: getfield b : F
/*     */     //   345: fload #7
/*     */     //   347: fsub
/*     */     //   348: putfield b : F
/*     */     //   351: goto -> 365
/*     */     //   354: aload_2
/*     */     //   355: dup
/*     */     //   356: getfield a : F
/*     */     //   359: fload #7
/*     */     //   361: fsub
/*     */     //   362: putfield a : F
/*     */     //   365: iinc #6, 1
/*     */     //   368: goto -> 263
/*     */     //   371: goto -> 1265
/*     */     //   374: aload #5
/*     */     //   376: invokevirtual trim : ()Ljava/lang/String;
/*     */     //   379: invokestatic parseFloat : (Ljava/lang/String;)F
/*     */     //   382: fstore #5
/*     */     //   384: aload_2
/*     */     //   385: fload #5
/*     */     //   387: dup
/*     */     //   388: fload #5
/*     */     //   390: dup
/*     */     //   391: invokevirtual sub : (FFFF)Lcom/badlogic/gdx/graphics/Color;
/*     */     //   394: pop
/*     */     //   395: goto -> 1265
/*     */     //   398: aload #4
/*     */     //   400: iconst_0
/*     */     //   401: invokevirtual charAt : (I)C
/*     */     //   404: bipush #42
/*     */     //   406: if_icmpne -> 558
/*     */     //   409: aload #5
/*     */     //   411: ldc ','
/*     */     //   413: invokevirtual contains : (Ljava/lang/CharSequence;)Z
/*     */     //   416: ifeq -> 542
/*     */     //   419: aload #5
/*     */     //   421: ldc ','
/*     */     //   423: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
/*     */     //   426: astore #5
/*     */     //   428: iconst_0
/*     */     //   429: istore #6
/*     */     //   431: iload #6
/*     */     //   433: iconst_4
/*     */     //   434: if_icmpge -> 539
/*     */     //   437: aload #5
/*     */     //   439: iload #6
/*     */     //   441: aaload
/*     */     //   442: invokevirtual trim : ()Ljava/lang/String;
/*     */     //   445: invokestatic parseFloat : (Ljava/lang/String;)F
/*     */     //   448: fstore #7
/*     */     //   450: iload #6
/*     */     //   452: tableswitch default -> 522, 0 -> 480, 1 -> 494, 2 -> 508
/*     */     //   480: aload_2
/*     */     //   481: dup
/*     */     //   482: getfield r : F
/*     */     //   485: fload #7
/*     */     //   487: fmul
/*     */     //   488: putfield r : F
/*     */     //   491: goto -> 533
/*     */     //   494: aload_2
/*     */     //   495: dup
/*     */     //   496: getfield g : F
/*     */     //   499: fload #7
/*     */     //   501: fmul
/*     */     //   502: putfield g : F
/*     */     //   505: goto -> 533
/*     */     //   508: aload_2
/*     */     //   509: dup
/*     */     //   510: getfield b : F
/*     */     //   513: fload #7
/*     */     //   515: fmul
/*     */     //   516: putfield b : F
/*     */     //   519: goto -> 533
/*     */     //   522: aload_2
/*     */     //   523: dup
/*     */     //   524: getfield a : F
/*     */     //   527: fload #7
/*     */     //   529: fmul
/*     */     //   530: putfield a : F
/*     */     //   533: iinc #6, 1
/*     */     //   536: goto -> 431
/*     */     //   539: goto -> 1265
/*     */     //   542: aload_2
/*     */     //   543: aload #5
/*     */     //   545: invokevirtual trim : ()Ljava/lang/String;
/*     */     //   548: invokestatic parseFloat : (Ljava/lang/String;)F
/*     */     //   551: invokevirtual mul : (F)Lcom/badlogic/gdx/graphics/Color;
/*     */     //   554: pop
/*     */     //   555: goto -> 1265
/*     */     //   558: aload #4
/*     */     //   560: iconst_0
/*     */     //   561: invokevirtual charAt : (I)C
/*     */     //   564: bipush #108
/*     */     //   566: if_icmpeq -> 580
/*     */     //   569: aload #4
/*     */     //   571: iconst_0
/*     */     //   572: invokevirtual charAt : (I)C
/*     */     //   575: bipush #76
/*     */     //   577: if_icmpne -> 663
/*     */     //   580: aload #4
/*     */     //   582: bipush #40
/*     */     //   584: invokevirtual indexOf : (I)I
/*     */     //   587: iconst_1
/*     */     //   588: iadd
/*     */     //   589: istore #5
/*     */     //   591: aload #4
/*     */     //   593: bipush #44
/*     */     //   595: invokevirtual lastIndexOf : (I)I
/*     */     //   598: istore #6
/*     */     //   600: aload #4
/*     */     //   602: iload #5
/*     */     //   604: iload #6
/*     */     //   606: invokevirtual substring : (II)Ljava/lang/String;
/*     */     //   609: invokevirtual trim : ()Ljava/lang/String;
/*     */     //   612: dup
/*     */     //   613: astore #7
/*     */     //   615: aload_1
/*     */     //   616: invokestatic parseColorValue : (Ljava/lang/String;Lcom/badlogic/gdx/utils/ObjectMap;)Lcom/badlogic/gdx/graphics/Color;
/*     */     //   619: dup
/*     */     //   620: astore #5
/*     */     //   622: ifnonnull -> 627
/*     */     //   625: aconst_null
/*     */     //   626: areturn
/*     */     //   627: aload_2
/*     */     //   628: aload #5
/*     */     //   630: aload #4
/*     */     //   632: dup
/*     */     //   633: bipush #44
/*     */     //   635: invokevirtual lastIndexOf : (I)I
/*     */     //   638: iconst_1
/*     */     //   639: iadd
/*     */     //   640: aload #4
/*     */     //   642: bipush #41
/*     */     //   644: invokevirtual lastIndexOf : (I)I
/*     */     //   647: invokevirtual substring : (II)Ljava/lang/String;
/*     */     //   650: invokevirtual trim : ()Ljava/lang/String;
/*     */     //   653: invokestatic parseFloat : (Ljava/lang/String;)F
/*     */     //   656: invokevirtual lerp : (Lcom/badlogic/gdx/graphics/Color;F)Lcom/badlogic/gdx/graphics/Color;
/*     */     //   659: pop
/*     */     //   660: goto -> 1265
/*     */     //   663: aload #4
/*     */     //   665: iconst_0
/*     */     //   666: invokevirtual charAt : (I)C
/*     */     //   669: bipush #114
/*     */     //   671: if_icmpeq -> 685
/*     */     //   674: aload #4
/*     */     //   676: iconst_0
/*     */     //   677: invokevirtual charAt : (I)C
/*     */     //   680: bipush #82
/*     */     //   682: if_icmpne -> 697
/*     */     //   685: aload_2
/*     */     //   686: aload #5
/*     */     //   688: invokestatic parseFloat : (Ljava/lang/String;)F
/*     */     //   691: putfield r : F
/*     */     //   694: goto -> 1265
/*     */     //   697: aload #4
/*     */     //   699: iconst_0
/*     */     //   700: invokevirtual charAt : (I)C
/*     */     //   703: bipush #103
/*     */     //   705: if_icmpeq -> 719
/*     */     //   708: aload #4
/*     */     //   710: iconst_0
/*     */     //   711: invokevirtual charAt : (I)C
/*     */     //   714: bipush #71
/*     */     //   716: if_icmpne -> 731
/*     */     //   719: aload_2
/*     */     //   720: aload #5
/*     */     //   722: invokestatic parseFloat : (Ljava/lang/String;)F
/*     */     //   725: putfield g : F
/*     */     //   728: goto -> 1265
/*     */     //   731: aload #4
/*     */     //   733: iconst_0
/*     */     //   734: invokevirtual charAt : (I)C
/*     */     //   737: bipush #98
/*     */     //   739: if_icmpeq -> 753
/*     */     //   742: aload #4
/*     */     //   744: iconst_0
/*     */     //   745: invokevirtual charAt : (I)C
/*     */     //   748: bipush #66
/*     */     //   750: if_icmpne -> 765
/*     */     //   753: aload_2
/*     */     //   754: aload #5
/*     */     //   756: invokestatic parseFloat : (Ljava/lang/String;)F
/*     */     //   759: putfield b : F
/*     */     //   762: goto -> 1265
/*     */     //   765: aload #4
/*     */     //   767: iconst_0
/*     */     //   768: invokevirtual charAt : (I)C
/*     */     //   771: bipush #97
/*     */     //   773: if_icmpeq -> 787
/*     */     //   776: aload #4
/*     */     //   778: iconst_0
/*     */     //   779: invokevirtual charAt : (I)C
/*     */     //   782: bipush #65
/*     */     //   784: if_icmpne -> 799
/*     */     //   787: aload_2
/*     */     //   788: aload #5
/*     */     //   790: invokestatic parseFloat : (Ljava/lang/String;)F
/*     */     //   793: putfield a : F
/*     */     //   796: goto -> 1265
/*     */     //   799: aload #4
/*     */     //   801: iconst_0
/*     */     //   802: invokevirtual charAt : (I)C
/*     */     //   805: bipush #104
/*     */     //   807: if_icmpeq -> 821
/*     */     //   810: aload #4
/*     */     //   812: iconst_0
/*     */     //   813: invokevirtual charAt : (I)C
/*     */     //   816: bipush #72
/*     */     //   818: if_icmpne -> 853
/*     */     //   821: aload_2
/*     */     //   822: getstatic com/prineside/tdi2/utils/PackColor.f : [F
/*     */     //   825: invokevirtual toHsv : ([F)[F
/*     */     //   828: pop
/*     */     //   829: getstatic com/prineside/tdi2/utils/PackColor.f : [F
/*     */     //   832: iconst_0
/*     */     //   833: dup2
/*     */     //   834: faload
/*     */     //   835: aload #5
/*     */     //   837: invokestatic parseFloat : (Ljava/lang/String;)F
/*     */     //   840: fadd
/*     */     //   841: fastore
/*     */     //   842: aload_2
/*     */     //   843: getstatic com/prineside/tdi2/utils/PackColor.f : [F
/*     */     //   846: invokevirtual fromHsv : ([F)Lcom/badlogic/gdx/graphics/Color;
/*     */     //   849: pop
/*     */     //   850: goto -> 1265
/*     */     //   853: aload #4
/*     */     //   855: iconst_0
/*     */     //   856: invokevirtual charAt : (I)C
/*     */     //   859: bipush #115
/*     */     //   861: if_icmpeq -> 875
/*     */     //   864: aload #4
/*     */     //   866: iconst_0
/*     */     //   867: invokevirtual charAt : (I)C
/*     */     //   870: bipush #83
/*     */     //   872: if_icmpne -> 1055
/*     */     //   875: aload #4
/*     */     //   877: iconst_1
/*     */     //   878: invokevirtual charAt : (I)C
/*     */     //   881: bipush #43
/*     */     //   883: if_icmpeq -> 919
/*     */     //   886: aload #4
/*     */     //   888: iconst_1
/*     */     //   889: invokevirtual charAt : (I)C
/*     */     //   892: bipush #45
/*     */     //   894: if_icmpeq -> 919
/*     */     //   897: aload #4
/*     */     //   899: iconst_1
/*     */     //   900: invokevirtual charAt : (I)C
/*     */     //   903: bipush #42
/*     */     //   905: if_icmpeq -> 919
/*     */     //   908: aload #4
/*     */     //   910: iconst_1
/*     */     //   911: invokevirtual charAt : (I)C
/*     */     //   914: bipush #47
/*     */     //   916: if_icmpne -> 1055
/*     */     //   919: aload #5
/*     */     //   921: invokestatic parseFloat : (Ljava/lang/String;)F
/*     */     //   924: fstore #5
/*     */     //   926: aload_2
/*     */     //   927: getstatic com/prineside/tdi2/utils/PackColor.f : [F
/*     */     //   930: invokevirtual toHsv : ([F)[F
/*     */     //   933: pop
/*     */     //   934: aload #4
/*     */     //   936: iconst_1
/*     */     //   937: invokevirtual charAt : (I)C
/*     */     //   940: tableswitch default -> 1029, 42 -> 1006, 43 -> 980, 44 -> 1029, 45 -> 993, 46 -> 1029, 47 -> 1019
/*     */     //   980: getstatic com/prineside/tdi2/utils/PackColor.f : [F
/*     */     //   983: iconst_1
/*     */     //   984: dup2
/*     */     //   985: faload
/*     */     //   986: fload #5
/*     */     //   988: fadd
/*     */     //   989: fastore
/*     */     //   990: goto -> 1029
/*     */     //   993: getstatic com/prineside/tdi2/utils/PackColor.f : [F
/*     */     //   996: iconst_1
/*     */     //   997: dup2
/*     */     //   998: faload
/*     */     //   999: fload #5
/*     */     //   1001: fsub
/*     */     //   1002: fastore
/*     */     //   1003: goto -> 1029
/*     */     //   1006: getstatic com/prineside/tdi2/utils/PackColor.f : [F
/*     */     //   1009: iconst_1
/*     */     //   1010: dup2
/*     */     //   1011: faload
/*     */     //   1012: fload #5
/*     */     //   1014: fmul
/*     */     //   1015: fastore
/*     */     //   1016: goto -> 1029
/*     */     //   1019: getstatic com/prineside/tdi2/utils/PackColor.f : [F
/*     */     //   1022: iconst_1
/*     */     //   1023: dup2
/*     */     //   1024: faload
/*     */     //   1025: fload #5
/*     */     //   1027: fdiv
/*     */     //   1028: fastore
/*     */     //   1029: getstatic com/prineside/tdi2/utils/PackColor.f : [F
/*     */     //   1032: iconst_1
/*     */     //   1033: getstatic com/prineside/tdi2/utils/PackColor.f : [F
/*     */     //   1036: iconst_1
/*     */     //   1037: faload
/*     */     //   1038: fconst_0
/*     */     //   1039: fconst_1
/*     */     //   1040: invokestatic clamp : (FFF)F
/*     */     //   1043: fastore
/*     */     //   1044: aload_2
/*     */     //   1045: getstatic com/prineside/tdi2/utils/PackColor.f : [F
/*     */     //   1048: invokevirtual fromHsv : ([F)Lcom/badlogic/gdx/graphics/Color;
/*     */     //   1051: pop
/*     */     //   1052: goto -> 1265
/*     */     //   1055: aload #4
/*     */     //   1057: iconst_0
/*     */     //   1058: invokevirtual charAt : (I)C
/*     */     //   1061: bipush #118
/*     */     //   1063: if_icmpeq -> 1077
/*     */     //   1066: aload #4
/*     */     //   1068: iconst_0
/*     */     //   1069: invokevirtual charAt : (I)C
/*     */     //   1072: bipush #86
/*     */     //   1074: if_icmpne -> 1255
/*     */     //   1077: aload #4
/*     */     //   1079: iconst_1
/*     */     //   1080: invokevirtual charAt : (I)C
/*     */     //   1083: bipush #43
/*     */     //   1085: if_icmpeq -> 1121
/*     */     //   1088: aload #4
/*     */     //   1090: iconst_1
/*     */     //   1091: invokevirtual charAt : (I)C
/*     */     //   1094: bipush #45
/*     */     //   1096: if_icmpeq -> 1121
/*     */     //   1099: aload #4
/*     */     //   1101: iconst_1
/*     */     //   1102: invokevirtual charAt : (I)C
/*     */     //   1105: bipush #42
/*     */     //   1107: if_icmpeq -> 1121
/*     */     //   1110: aload #4
/*     */     //   1112: iconst_1
/*     */     //   1113: invokevirtual charAt : (I)C
/*     */     //   1116: bipush #47
/*     */     //   1118: if_icmpne -> 1255
/*     */     //   1121: aload #5
/*     */     //   1123: invokestatic parseFloat : (Ljava/lang/String;)F
/*     */     //   1126: fstore #5
/*     */     //   1128: aload_2
/*     */     //   1129: getstatic com/prineside/tdi2/utils/PackColor.f : [F
/*     */     //   1132: invokevirtual toHsv : ([F)[F
/*     */     //   1135: pop
/*     */     //   1136: aload #4
/*     */     //   1138: iconst_1
/*     */     //   1139: invokevirtual charAt : (I)C
/*     */     //   1142: tableswitch default -> 1229, 42 -> 1206, 43 -> 1180, 44 -> 1229, 45 -> 1193, 46 -> 1229, 47 -> 1219
/*     */     //   1180: getstatic com/prineside/tdi2/utils/PackColor.f : [F
/*     */     //   1183: iconst_2
/*     */     //   1184: dup2
/*     */     //   1185: faload
/*     */     //   1186: fload #5
/*     */     //   1188: fadd
/*     */     //   1189: fastore
/*     */     //   1190: goto -> 1229
/*     */     //   1193: getstatic com/prineside/tdi2/utils/PackColor.f : [F
/*     */     //   1196: iconst_2
/*     */     //   1197: dup2
/*     */     //   1198: faload
/*     */     //   1199: fload #5
/*     */     //   1201: fsub
/*     */     //   1202: fastore
/*     */     //   1203: goto -> 1229
/*     */     //   1206: getstatic com/prineside/tdi2/utils/PackColor.f : [F
/*     */     //   1209: iconst_2
/*     */     //   1210: dup2
/*     */     //   1211: faload
/*     */     //   1212: fload #5
/*     */     //   1214: fmul
/*     */     //   1215: fastore
/*     */     //   1216: goto -> 1229
/*     */     //   1219: getstatic com/prineside/tdi2/utils/PackColor.f : [F
/*     */     //   1222: iconst_2
/*     */     //   1223: dup2
/*     */     //   1224: faload
/*     */     //   1225: fload #5
/*     */     //   1227: fdiv
/*     */     //   1228: fastore
/*     */     //   1229: getstatic com/prineside/tdi2/utils/PackColor.f : [F
/*     */     //   1232: iconst_2
/*     */     //   1233: getstatic com/prineside/tdi2/utils/PackColor.f : [F
/*     */     //   1236: iconst_2
/*     */     //   1237: faload
/*     */     //   1238: fconst_0
/*     */     //   1239: fconst_1
/*     */     //   1240: invokestatic clamp : (FFF)F
/*     */     //   1243: fastore
/*     */     //   1244: aload_2
/*     */     //   1245: getstatic com/prineside/tdi2/utils/PackColor.f : [F
/*     */     //   1248: invokevirtual fromHsv : ([F)Lcom/badlogic/gdx/graphics/Color;
/*     */     //   1251: pop
/*     */     //   1252: goto -> 1265
/*     */     //   1255: new com/prineside/tdi2/utils/PackColor$ColorConfigFormatException
/*     */     //   1258: dup
/*     */     //   1259: ldc 'unknown filter type'
/*     */     //   1261: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1264: athrow
/*     */     //   1265: aload_2
/*     */     //   1266: invokevirtual clamp : ()Lcom/badlogic/gdx/graphics/Color;
/*     */     //   1269: pop
/*     */     //   1270: goto -> 1307
/*     */     //   1273: astore #5
/*     */     //   1275: new com/prineside/tdi2/utils/PackColor$ColorConfigFormatException
/*     */     //   1278: dup
/*     */     //   1279: new java/lang/StringBuilder
/*     */     //   1282: dup
/*     */     //   1283: ldc 'failed to parse color filter ''
/*     */     //   1285: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1288: aload #4
/*     */     //   1290: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1293: ldc '''
/*     */     //   1295: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1298: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1301: aload #5
/*     */     //   1303: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   1306: athrow
/*     */     //   1307: iinc #3, 1
/*     */     //   1310: goto -> 29
/*     */     //   1313: new com/prineside/tdi2/utils/PackColor
/*     */     //   1316: dup
/*     */     //   1317: aload_2
/*     */     //   1318: invokespecial <init> : (Lcom/badlogic/gdx/graphics/Color;)V
/*     */     //   1321: areturn
/*     */     //   1322: new com/prineside/tdi2/utils/PackColor
/*     */     //   1325: dup
/*     */     //   1326: aload_0
/*     */     //   1327: aload_1
/*     */     //   1328: invokestatic parseColorValue : (Ljava/lang/String;Lcom/badlogic/gdx/utils/ObjectMap;)Lcom/badlogic/gdx/graphics/Color;
/*     */     //   1331: invokespecial <init> : (Lcom/badlogic/gdx/graphics/Color;)V
/*     */     //   1334: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #165	-> 0
/*     */     //   #167	-> 9
/*     */     //   #168	-> 16
/*     */     //   #171	-> 27
/*     */     //   #172	-> 35
/*     */     //   #174	-> 43
/*     */     //   #175	-> 65
/*     */     //   #176	-> 76
/*     */     //   #178	-> 86
/*     */     //   #179	-> 95
/*     */     //   #180	-> 104
/*     */     //   #181	-> 117
/*     */     //   #182	-> 144
/*     */     //   #183	-> 158
/*     */     //   #184	-> 172
/*     */     //   #185	-> 186
/*     */     //   #179	-> 197
/*     */     //   #188	-> 203
/*     */     //   #190	-> 206
/*     */     //   #191	-> 216
/*     */     //   #192	-> 227
/*     */     //   #193	-> 230
/*     */     //   #194	-> 241
/*     */     //   #196	-> 251
/*     */     //   #197	-> 260
/*     */     //   #198	-> 269
/*     */     //   #199	-> 282
/*     */     //   #200	-> 312
/*     */     //   #201	-> 326
/*     */     //   #202	-> 340
/*     */     //   #203	-> 354
/*     */     //   #197	-> 365
/*     */     //   #206	-> 371
/*     */     //   #208	-> 374
/*     */     //   #209	-> 384
/*     */     //   #210	-> 395
/*     */     //   #211	-> 398
/*     */     //   #212	-> 409
/*     */     //   #214	-> 419
/*     */     //   #215	-> 428
/*     */     //   #216	-> 437
/*     */     //   #217	-> 450
/*     */     //   #218	-> 480
/*     */     //   #219	-> 494
/*     */     //   #220	-> 508
/*     */     //   #221	-> 522
/*     */     //   #215	-> 533
/*     */     //   #224	-> 539
/*     */     //   #226	-> 542
/*     */     //   #228	-> 558
/*     */     //   #230	-> 580
/*     */     //   #231	-> 591
/*     */     //   #232	-> 600
/*     */     //   #233	-> 613
/*     */     //   #234	-> 620
/*     */     //   #236	-> 627
/*     */     //   #237	-> 660
/*     */     //   #238	-> 685
/*     */     //   #239	-> 697
/*     */     //   #240	-> 719
/*     */     //   #241	-> 731
/*     */     //   #242	-> 753
/*     */     //   #243	-> 765
/*     */     //   #244	-> 787
/*     */     //   #245	-> 799
/*     */     //   #246	-> 821
/*     */     //   #247	-> 829
/*     */     //   #248	-> 842
/*     */     //   #249	-> 853
/*     */     //   #250	-> 856
/*     */     //   #251	-> 878
/*     */     //   #253	-> 919
/*     */     //   #254	-> 926
/*     */     //   #255	-> 934
/*     */     //   #257	-> 980
/*     */     //   #258	-> 990
/*     */     //   #261	-> 993
/*     */     //   #262	-> 1003
/*     */     //   #265	-> 1006
/*     */     //   #266	-> 1016
/*     */     //   #269	-> 1019
/*     */     //   #273	-> 1029
/*     */     //   #274	-> 1044
/*     */     //   #275	-> 1052
/*     */     //   #276	-> 1058
/*     */     //   #277	-> 1080
/*     */     //   #279	-> 1121
/*     */     //   #280	-> 1128
/*     */     //   #281	-> 1136
/*     */     //   #283	-> 1180
/*     */     //   #284	-> 1190
/*     */     //   #287	-> 1193
/*     */     //   #288	-> 1203
/*     */     //   #291	-> 1206
/*     */     //   #292	-> 1216
/*     */     //   #295	-> 1219
/*     */     //   #299	-> 1229
/*     */     //   #300	-> 1244
/*     */     //   #301	-> 1252
/*     */     //   #302	-> 1255
/*     */     //   #304	-> 1265
/*     */     //   #307	-> 1270
/*     */     //   #305	-> 1273
/*     */     //   #306	-> 1275
/*     */     //   #171	-> 1307
/*     */     //   #310	-> 1313
/*     */     //   #313	-> 1322
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   43	626	1273	java/lang/Exception
/*     */     //   627	1270	1273	java/lang/Exception
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Color parseColorValue(String paramString, ObjectMap<String, PackColor> paramObjectMap) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: ldc '$'
/*     */     //   3: invokevirtual startsWith : (Ljava/lang/String;)Z
/*     */     //   6: ifeq -> 88
/*     */     //   9: aload_1
/*     */     //   10: ifnonnull -> 37
/*     */     //   13: new com/prineside/tdi2/utils/PackColor$ColorConfigFormatException
/*     */     //   16: dup
/*     */     //   17: new java/lang/StringBuilder
/*     */     //   20: dup
/*     */     //   21: ldc 'No variable map provided but variable notation used: '
/*     */     //   23: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   26: aload_0
/*     */     //   27: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   30: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   33: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   36: athrow
/*     */     //   37: aload_1
/*     */     //   38: aload_0
/*     */     //   39: iconst_1
/*     */     //   40: invokevirtual substring : (I)Ljava/lang/String;
/*     */     //   43: aconst_null
/*     */     //   44: invokevirtual get : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   47: checkcast com/prineside/tdi2/utils/PackColor
/*     */     //   50: dup
/*     */     //   51: astore_1
/*     */     //   52: ifnonnull -> 79
/*     */     //   55: new com/prineside/tdi2/utils/PackColor$ColorConfigFormatException
/*     */     //   58: dup
/*     */     //   59: new java/lang/StringBuilder
/*     */     //   62: dup
/*     */     //   63: ldc 'Color variable not found: '
/*     */     //   65: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   68: aload_0
/*     */     //   69: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   72: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   75: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   78: athrow
/*     */     //   79: new com/prineside/tdi2/utils/PackColor
/*     */     //   82: dup
/*     */     //   83: aload_1
/*     */     //   84: invokespecial <init> : (Lcom/badlogic/gdx/graphics/Color;)V
/*     */     //   87: areturn
/*     */     //   88: aload_0
/*     */     //   89: ldc '!'
/*     */     //   91: invokevirtual startsWith : (Ljava/lang/String;)Z
/*     */     //   94: ifeq -> 392
/*     */     //   97: aload_0
/*     */     //   98: iconst_1
/*     */     //   99: invokevirtual substring : (I)Ljava/lang/String;
/*     */     //   102: ldc '\.'
/*     */     //   104: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
/*     */     //   107: dup
/*     */     //   108: astore_1
/*     */     //   109: arraylength
/*     */     //   110: iconst_1
/*     */     //   111: if_icmpne -> 313
/*     */     //   114: aload_1
/*     */     //   115: iconst_0
/*     */     //   116: aaload
/*     */     //   117: astore_2
/*     */     //   118: iconst_m1
/*     */     //   119: istore_3
/*     */     //   120: aload_2
/*     */     //   121: invokevirtual hashCode : ()I
/*     */     //   124: lookupswitch default -> 199, 63281119 -> 174, 82564105 -> 160, 426766642 -> 188
/*     */     //   160: aload_2
/*     */     //   161: ldc 'WHITE'
/*     */     //   163: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   166: ifeq -> 199
/*     */     //   169: iconst_0
/*     */     //   170: istore_3
/*     */     //   171: goto -> 199
/*     */     //   174: aload_2
/*     */     //   175: ldc 'BLACK'
/*     */     //   177: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   180: ifeq -> 199
/*     */     //   183: iconst_1
/*     */     //   184: istore_3
/*     */     //   185: goto -> 199
/*     */     //   188: aload_2
/*     */     //   189: ldc 'TRANSPARENT'
/*     */     //   191: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   194: ifeq -> 199
/*     */     //   197: iconst_2
/*     */     //   198: istore_3
/*     */     //   199: iload_3
/*     */     //   200: tableswitch default -> 250, 0 -> 228, 1 -> 235, 2 -> 242
/*     */     //   228: getstatic com/badlogic/gdx/graphics/Color.WHITE : Lcom/badlogic/gdx/graphics/Color;
/*     */     //   231: invokevirtual cpy : ()Lcom/badlogic/gdx/graphics/Color;
/*     */     //   234: areturn
/*     */     //   235: getstatic com/badlogic/gdx/graphics/Color.BLACK : Lcom/badlogic/gdx/graphics/Color;
/*     */     //   238: invokevirtual cpy : ()Lcom/badlogic/gdx/graphics/Color;
/*     */     //   241: areturn
/*     */     //   242: new com/badlogic/gdx/graphics/Color
/*     */     //   245: dup
/*     */     //   246: invokespecial <init> : ()V
/*     */     //   249: areturn
/*     */     //   250: aload_1
/*     */     //   251: iconst_0
/*     */     //   252: aaload
/*     */     //   253: invokestatic valueOf : (Ljava/lang/String;)Lcom/prineside/tdi2/utils/MaterialColor$Colors;
/*     */     //   256: astore_2
/*     */     //   257: getstatic com/prineside/tdi2/utils/MaterialColor.allColors : [[Lcom/badlogic/gdx/graphics/Color;
/*     */     //   260: aload_2
/*     */     //   261: invokevirtual ordinal : ()I
/*     */     //   264: aaload
/*     */     //   265: getstatic com/prineside/tdi2/utils/MaterialColor$Variants.P500 : Lcom/prineside/tdi2/utils/MaterialColor$Variants;
/*     */     //   268: invokevirtual ordinal : ()I
/*     */     //   271: aaload
/*     */     //   272: invokevirtual cpy : ()Lcom/badlogic/gdx/graphics/Color;
/*     */     //   275: areturn
/*     */     //   276: astore_2
/*     */     //   277: new com/prineside/tdi2/utils/PackColor$ColorConfigFormatException
/*     */     //   280: dup
/*     */     //   281: new java/lang/StringBuilder
/*     */     //   284: dup
/*     */     //   285: ldc 'Palette color '
/*     */     //   287: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   290: aload_1
/*     */     //   291: iconst_0
/*     */     //   292: aaload
/*     */     //   293: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   296: ldc ' not found for variant P500: '
/*     */     //   298: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   301: aload_0
/*     */     //   302: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   305: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   308: aload_2
/*     */     //   309: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   312: athrow
/*     */     //   313: aload_1
/*     */     //   314: iconst_0
/*     */     //   315: aaload
/*     */     //   316: invokestatic valueOf : (Ljava/lang/String;)Lcom/prineside/tdi2/utils/MaterialColor$Colors;
/*     */     //   319: astore_2
/*     */     //   320: aload_1
/*     */     //   321: iconst_1
/*     */     //   322: aaload
/*     */     //   323: invokestatic valueOf : (Ljava/lang/String;)Lcom/prineside/tdi2/utils/MaterialColor$Variants;
/*     */     //   326: astore_3
/*     */     //   327: getstatic com/prineside/tdi2/utils/MaterialColor.allColors : [[Lcom/badlogic/gdx/graphics/Color;
/*     */     //   330: aload_2
/*     */     //   331: invokevirtual ordinal : ()I
/*     */     //   334: aaload
/*     */     //   335: aload_3
/*     */     //   336: invokevirtual ordinal : ()I
/*     */     //   339: aaload
/*     */     //   340: invokevirtual cpy : ()Lcom/badlogic/gdx/graphics/Color;
/*     */     //   343: areturn
/*     */     //   344: astore_2
/*     */     //   345: new com/prineside/tdi2/utils/PackColor$ColorConfigFormatException
/*     */     //   348: dup
/*     */     //   349: new java/lang/StringBuilder
/*     */     //   352: dup
/*     */     //   353: ldc 'Palette color '
/*     */     //   355: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   358: aload_1
/*     */     //   359: iconst_0
/*     */     //   360: aaload
/*     */     //   361: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   364: ldc ' or its variant '
/*     */     //   366: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   369: aload_1
/*     */     //   370: iconst_1
/*     */     //   371: aaload
/*     */     //   372: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   375: ldc ' not found: '
/*     */     //   377: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   380: aload_0
/*     */     //   381: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   384: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   387: aload_2
/*     */     //   388: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   391: athrow
/*     */     //   392: aload_0
/*     */     //   393: ldc '#'
/*     */     //   395: invokevirtual startsWith : (Ljava/lang/String;)Z
/*     */     //   398: ifeq -> 591
/*     */     //   401: aload_0
/*     */     //   402: iconst_1
/*     */     //   403: invokevirtual substring : (I)Ljava/lang/String;
/*     */     //   406: invokevirtual toUpperCase : ()Ljava/lang/String;
/*     */     //   409: dup
/*     */     //   410: astore_1
/*     */     //   411: invokevirtual length : ()I
/*     */     //   414: bipush #6
/*     */     //   416: if_icmpne -> 474
/*     */     //   419: aload_1
/*     */     //   420: iconst_0
/*     */     //   421: iconst_2
/*     */     //   422: invokevirtual substring : (II)Ljava/lang/String;
/*     */     //   425: bipush #16
/*     */     //   427: invokestatic parseInt : (Ljava/lang/String;I)I
/*     */     //   430: i2f
/*     */     //   431: ldc 255.0
/*     */     //   433: fdiv
/*     */     //   434: fstore_2
/*     */     //   435: aload_1
/*     */     //   436: iconst_2
/*     */     //   437: iconst_4
/*     */     //   438: invokevirtual substring : (II)Ljava/lang/String;
/*     */     //   441: bipush #16
/*     */     //   443: invokestatic parseInt : (Ljava/lang/String;I)I
/*     */     //   446: i2f
/*     */     //   447: ldc 255.0
/*     */     //   449: fdiv
/*     */     //   450: fstore_3
/*     */     //   451: aload_1
/*     */     //   452: iconst_4
/*     */     //   453: bipush #6
/*     */     //   455: invokevirtual substring : (II)Ljava/lang/String;
/*     */     //   458: bipush #16
/*     */     //   460: invokestatic parseInt : (Ljava/lang/String;I)I
/*     */     //   463: i2f
/*     */     //   464: ldc 255.0
/*     */     //   466: fdiv
/*     */     //   467: fstore #4
/*     */     //   469: fconst_1
/*     */     //   470: fstore_1
/*     */     //   471: goto -> 578
/*     */     //   474: aload_1
/*     */     //   475: invokevirtual length : ()I
/*     */     //   478: bipush #8
/*     */     //   480: if_icmpne -> 554
/*     */     //   483: aload_1
/*     */     //   484: iconst_0
/*     */     //   485: iconst_2
/*     */     //   486: invokevirtual substring : (II)Ljava/lang/String;
/*     */     //   489: bipush #16
/*     */     //   491: invokestatic parseInt : (Ljava/lang/String;I)I
/*     */     //   494: i2f
/*     */     //   495: ldc 255.0
/*     */     //   497: fdiv
/*     */     //   498: fstore_2
/*     */     //   499: aload_1
/*     */     //   500: iconst_2
/*     */     //   501: iconst_4
/*     */     //   502: invokevirtual substring : (II)Ljava/lang/String;
/*     */     //   505: bipush #16
/*     */     //   507: invokestatic parseInt : (Ljava/lang/String;I)I
/*     */     //   510: i2f
/*     */     //   511: ldc 255.0
/*     */     //   513: fdiv
/*     */     //   514: fstore_3
/*     */     //   515: aload_1
/*     */     //   516: iconst_4
/*     */     //   517: bipush #6
/*     */     //   519: invokevirtual substring : (II)Ljava/lang/String;
/*     */     //   522: bipush #16
/*     */     //   524: invokestatic parseInt : (Ljava/lang/String;I)I
/*     */     //   527: i2f
/*     */     //   528: ldc 255.0
/*     */     //   530: fdiv
/*     */     //   531: fstore #4
/*     */     //   533: aload_1
/*     */     //   534: bipush #6
/*     */     //   536: bipush #8
/*     */     //   538: invokevirtual substring : (II)Ljava/lang/String;
/*     */     //   541: bipush #16
/*     */     //   543: invokestatic parseInt : (Ljava/lang/String;I)I
/*     */     //   546: i2f
/*     */     //   547: ldc 255.0
/*     */     //   549: fdiv
/*     */     //   550: fstore_1
/*     */     //   551: goto -> 578
/*     */     //   554: new com/prineside/tdi2/utils/PackColor$ColorConfigFormatException
/*     */     //   557: dup
/*     */     //   558: new java/lang/StringBuilder
/*     */     //   561: dup
/*     */     //   562: ldc 'Incorrect #RRGGBB / #RRGGBBAA notation: '
/*     */     //   564: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   567: aload_0
/*     */     //   568: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   571: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   574: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   577: athrow
/*     */     //   578: new com/badlogic/gdx/graphics/Color
/*     */     //   581: dup
/*     */     //   582: fload_2
/*     */     //   583: fload_3
/*     */     //   584: fload #4
/*     */     //   586: fload_1
/*     */     //   587: invokespecial <init> : (FFFF)V
/*     */     //   590: areturn
/*     */     //   591: aload_0
/*     */     //   592: ldc 'hsv('
/*     */     //   594: invokevirtual startsWith : (Ljava/lang/String;)Z
/*     */     //   597: ifeq -> 749
/*     */     //   600: aload_0
/*     */     //   601: iconst_4
/*     */     //   602: aload_0
/*     */     //   603: invokevirtual length : ()I
/*     */     //   606: iconst_1
/*     */     //   607: isub
/*     */     //   608: invokevirtual substring : (II)Ljava/lang/String;
/*     */     //   611: dup
/*     */     //   612: astore_1
/*     */     //   613: ldc ','
/*     */     //   615: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
/*     */     //   618: dup
/*     */     //   619: astore_2
/*     */     //   620: arraylength
/*     */     //   621: iconst_3
/*     */     //   622: if_icmpeq -> 631
/*     */     //   625: aload_2
/*     */     //   626: arraylength
/*     */     //   627: iconst_4
/*     */     //   628: if_icmpne -> 725
/*     */     //   631: aload_2
/*     */     //   632: iconst_0
/*     */     //   633: aaload
/*     */     //   634: invokestatic parseFloat : (Ljava/lang/String;)F
/*     */     //   637: fstore_3
/*     */     //   638: aload_2
/*     */     //   639: iconst_1
/*     */     //   640: aaload
/*     */     //   641: invokestatic parseFloat : (Ljava/lang/String;)F
/*     */     //   644: fstore #4
/*     */     //   646: aload_2
/*     */     //   647: iconst_2
/*     */     //   648: aaload
/*     */     //   649: invokestatic parseFloat : (Ljava/lang/String;)F
/*     */     //   652: fstore_1
/*     */     //   653: fconst_1
/*     */     //   654: fstore #5
/*     */     //   656: aload_2
/*     */     //   657: arraylength
/*     */     //   658: iconst_4
/*     */     //   659: if_icmpne -> 670
/*     */     //   662: aload_2
/*     */     //   663: iconst_3
/*     */     //   664: aaload
/*     */     //   665: invokestatic parseFloat : (Ljava/lang/String;)F
/*     */     //   668: fstore #5
/*     */     //   670: new com/badlogic/gdx/graphics/Color
/*     */     //   673: dup
/*     */     //   674: fconst_1
/*     */     //   675: fconst_1
/*     */     //   676: fconst_1
/*     */     //   677: fconst_1
/*     */     //   678: invokespecial <init> : (FFFF)V
/*     */     //   681: dup
/*     */     //   682: astore_2
/*     */     //   683: fload_3
/*     */     //   684: fload #4
/*     */     //   686: fload_1
/*     */     //   687: invokevirtual fromHsv : (FFF)Lcom/badlogic/gdx/graphics/Color;
/*     */     //   690: pop
/*     */     //   691: aload_2
/*     */     //   692: fload #5
/*     */     //   694: putfield a : F
/*     */     //   697: aload_2
/*     */     //   698: areturn
/*     */     //   699: astore_3
/*     */     //   700: new com/prineside/tdi2/utils/PackColor$ColorConfigFormatException
/*     */     //   703: dup
/*     */     //   704: new java/lang/StringBuilder
/*     */     //   707: dup
/*     */     //   708: ldc 'Failed to parse hsv(h,s,v) / hsv(h,s,v,a) notation: '
/*     */     //   710: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   713: aload_0
/*     */     //   714: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   717: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   720: aload_3
/*     */     //   721: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   724: athrow
/*     */     //   725: new com/prineside/tdi2/utils/PackColor$ColorConfigFormatException
/*     */     //   728: dup
/*     */     //   729: new java/lang/StringBuilder
/*     */     //   732: dup
/*     */     //   733: ldc 'Incorrect hsv(h,s,v) / hsv(h,s,v,a) notation (should contain 3 or 4 comma separated values): '
/*     */     //   735: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   738: aload_0
/*     */     //   739: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   742: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   745: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   748: athrow
/*     */     //   749: aload_0
/*     */     //   750: ldc 'raw('
/*     */     //   752: invokevirtual startsWith : (Ljava/lang/String;)Z
/*     */     //   755: ifeq -> 892
/*     */     //   758: aload_0
/*     */     //   759: iconst_4
/*     */     //   760: aload_0
/*     */     //   761: invokevirtual length : ()I
/*     */     //   764: iconst_1
/*     */     //   765: isub
/*     */     //   766: invokevirtual substring : (II)Ljava/lang/String;
/*     */     //   769: dup
/*     */     //   770: astore_1
/*     */     //   771: ldc ','
/*     */     //   773: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
/*     */     //   776: dup
/*     */     //   777: astore_2
/*     */     //   778: arraylength
/*     */     //   779: iconst_3
/*     */     //   780: if_icmpeq -> 789
/*     */     //   783: aload_2
/*     */     //   784: arraylength
/*     */     //   785: iconst_4
/*     */     //   786: if_icmpne -> 868
/*     */     //   789: aload_2
/*     */     //   790: iconst_0
/*     */     //   791: aaload
/*     */     //   792: invokestatic parseFloat : (Ljava/lang/String;)F
/*     */     //   795: fstore_3
/*     */     //   796: aload_2
/*     */     //   797: iconst_1
/*     */     //   798: aaload
/*     */     //   799: invokestatic parseFloat : (Ljava/lang/String;)F
/*     */     //   802: fstore #4
/*     */     //   804: aload_2
/*     */     //   805: iconst_2
/*     */     //   806: aaload
/*     */     //   807: invokestatic parseFloat : (Ljava/lang/String;)F
/*     */     //   810: fstore_1
/*     */     //   811: fconst_1
/*     */     //   812: fstore #5
/*     */     //   814: aload_2
/*     */     //   815: arraylength
/*     */     //   816: iconst_4
/*     */     //   817: if_icmpne -> 828
/*     */     //   820: aload_2
/*     */     //   821: iconst_3
/*     */     //   822: aaload
/*     */     //   823: invokestatic parseFloat : (Ljava/lang/String;)F
/*     */     //   826: fstore #5
/*     */     //   828: new com/badlogic/gdx/graphics/Color
/*     */     //   831: dup
/*     */     //   832: fload_3
/*     */     //   833: fload #4
/*     */     //   835: fload_1
/*     */     //   836: fload #5
/*     */     //   838: invokespecial <init> : (FFFF)V
/*     */     //   841: areturn
/*     */     //   842: astore_3
/*     */     //   843: new com/prineside/tdi2/utils/PackColor$ColorConfigFormatException
/*     */     //   846: dup
/*     */     //   847: new java/lang/StringBuilder
/*     */     //   850: dup
/*     */     //   851: ldc 'Failed to parse raw(r,g,b) / raw(r,g,b,a) notation: '
/*     */     //   853: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   856: aload_0
/*     */     //   857: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   860: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   863: aload_3
/*     */     //   864: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   867: athrow
/*     */     //   868: new com/prineside/tdi2/utils/PackColor$ColorConfigFormatException
/*     */     //   871: dup
/*     */     //   872: new java/lang/StringBuilder
/*     */     //   875: dup
/*     */     //   876: ldc 'Incorrect raw(r,g,b) / raw(r,g,b,a) notation (should contain 3 or 4 comma separated values): '
/*     */     //   878: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   881: aload_0
/*     */     //   882: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   885: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   888: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   891: athrow
/*     */     //   892: aload_0
/*     */     //   893: ldc 'rgb('
/*     */     //   895: invokevirtual startsWith : (Ljava/lang/String;)Z
/*     */     //   898: ifeq -> 1044
/*     */     //   901: aload_0
/*     */     //   902: iconst_4
/*     */     //   903: aload_0
/*     */     //   904: invokevirtual length : ()I
/*     */     //   907: iconst_1
/*     */     //   908: isub
/*     */     //   909: invokevirtual substring : (II)Ljava/lang/String;
/*     */     //   912: dup
/*     */     //   913: astore_1
/*     */     //   914: ldc ','
/*     */     //   916: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
/*     */     //   919: dup
/*     */     //   920: astore_2
/*     */     //   921: arraylength
/*     */     //   922: iconst_3
/*     */     //   923: if_icmpeq -> 932
/*     */     //   926: aload_2
/*     */     //   927: arraylength
/*     */     //   928: iconst_4
/*     */     //   929: if_icmpne -> 1020
/*     */     //   932: aload_2
/*     */     //   933: iconst_0
/*     */     //   934: aaload
/*     */     //   935: invokestatic parseFloat : (Ljava/lang/String;)F
/*     */     //   938: fstore_3
/*     */     //   939: aload_2
/*     */     //   940: iconst_1
/*     */     //   941: aaload
/*     */     //   942: invokestatic parseFloat : (Ljava/lang/String;)F
/*     */     //   945: fstore #4
/*     */     //   947: aload_2
/*     */     //   948: iconst_2
/*     */     //   949: aaload
/*     */     //   950: invokestatic parseFloat : (Ljava/lang/String;)F
/*     */     //   953: fstore_1
/*     */     //   954: fconst_1
/*     */     //   955: fstore #5
/*     */     //   957: aload_2
/*     */     //   958: arraylength
/*     */     //   959: iconst_4
/*     */     //   960: if_icmpne -> 971
/*     */     //   963: aload_2
/*     */     //   964: iconst_3
/*     */     //   965: aaload
/*     */     //   966: invokestatic parseFloat : (Ljava/lang/String;)F
/*     */     //   969: fstore #5
/*     */     //   971: new com/badlogic/gdx/graphics/Color
/*     */     //   974: dup
/*     */     //   975: fload_3
/*     */     //   976: ldc 255.0
/*     */     //   978: fdiv
/*     */     //   979: fload #4
/*     */     //   981: ldc 255.0
/*     */     //   983: fdiv
/*     */     //   984: fload_1
/*     */     //   985: ldc 255.0
/*     */     //   987: fdiv
/*     */     //   988: fload #5
/*     */     //   990: invokespecial <init> : (FFFF)V
/*     */     //   993: areturn
/*     */     //   994: astore_3
/*     */     //   995: new com/prineside/tdi2/utils/PackColor$ColorConfigFormatException
/*     */     //   998: dup
/*     */     //   999: new java/lang/StringBuilder
/*     */     //   1002: dup
/*     */     //   1003: ldc 'Failed to parse rgb(r,g,b) / rgb(r,g,b,a) notation: '
/*     */     //   1005: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1008: aload_0
/*     */     //   1009: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1012: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1015: aload_3
/*     */     //   1016: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   1019: athrow
/*     */     //   1020: new com/prineside/tdi2/utils/PackColor$ColorConfigFormatException
/*     */     //   1023: dup
/*     */     //   1024: new java/lang/StringBuilder
/*     */     //   1027: dup
/*     */     //   1028: ldc 'Incorrect rgb(r,g,b) / rgb(r,g,b,a) notation (should contain 3 or 4 comma separated values): '
/*     */     //   1030: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1033: aload_0
/*     */     //   1034: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1037: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1040: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1043: athrow
/*     */     //   1044: new com/prineside/tdi2/utils/PackColor$ColorConfigFormatException
/*     */     //   1047: dup
/*     */     //   1048: new java/lang/StringBuilder
/*     */     //   1051: dup
/*     */     //   1052: ldc 'Color notation not recognized: '
/*     */     //   1054: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1057: aload_0
/*     */     //   1058: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1061: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1064: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1067: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #330	-> 0
/*     */     //   #332	-> 9
/*     */     //   #333	-> 13
/*     */     //   #336	-> 37
/*     */     //   #337	-> 51
/*     */     //   #338	-> 55
/*     */     //   #341	-> 79
/*     */     //   #342	-> 88
/*     */     //   #344	-> 97
/*     */     //   #345	-> 108
/*     */     //   #346	-> 114
/*     */     //   #347	-> 228
/*     */     //   #348	-> 235
/*     */     //   #349	-> 242
/*     */     //   #354	-> 250
/*     */     //   #355	-> 257
/*     */     //   #356	-> 276
/*     */     //   #357	-> 277
/*     */     //   #362	-> 313
/*     */     //   #363	-> 320
/*     */     //   #365	-> 327
/*     */     //   #366	-> 344
/*     */     //   #367	-> 345
/*     */     //   #369	-> 392
/*     */     //   #371	-> 401
/*     */     //   #373	-> 410
/*     */     //   #375	-> 419
/*     */     //   #376	-> 435
/*     */     //   #377	-> 451
/*     */     //   #378	-> 469
/*     */     //   #379	-> 474
/*     */     //   #381	-> 483
/*     */     //   #382	-> 499
/*     */     //   #383	-> 515
/*     */     //   #384	-> 533
/*     */     //   #386	-> 554
/*     */     //   #389	-> 578
/*     */     //   #390	-> 591
/*     */     //   #392	-> 600
/*     */     //   #393	-> 612
/*     */     //   #394	-> 619
/*     */     //   #396	-> 631
/*     */     //   #397	-> 638
/*     */     //   #398	-> 646
/*     */     //   #399	-> 653
/*     */     //   #400	-> 656
/*     */     //   #401	-> 662
/*     */     //   #404	-> 670
/*     */     //   #405	-> 682
/*     */     //   #406	-> 691
/*     */     //   #407	-> 697
/*     */     //   #408	-> 699
/*     */     //   #409	-> 700
/*     */     //   #412	-> 725
/*     */     //   #414	-> 749
/*     */     //   #416	-> 758
/*     */     //   #417	-> 770
/*     */     //   #418	-> 777
/*     */     //   #420	-> 789
/*     */     //   #421	-> 796
/*     */     //   #422	-> 804
/*     */     //   #423	-> 811
/*     */     //   #424	-> 814
/*     */     //   #425	-> 820
/*     */     //   #428	-> 828
/*     */     //   #429	-> 842
/*     */     //   #430	-> 843
/*     */     //   #433	-> 868
/*     */     //   #435	-> 892
/*     */     //   #437	-> 901
/*     */     //   #438	-> 913
/*     */     //   #439	-> 920
/*     */     //   #441	-> 932
/*     */     //   #442	-> 939
/*     */     //   #443	-> 947
/*     */     //   #444	-> 954
/*     */     //   #445	-> 957
/*     */     //   #446	-> 963
/*     */     //   #449	-> 971
/*     */     //   #450	-> 994
/*     */     //   #451	-> 995
/*     */     //   #454	-> 1020
/*     */     //   #457	-> 1044
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   250	275	276	java/lang/Exception
/*     */     //   313	343	344	java/lang/Exception
/*     */     //   631	698	699	java/lang/Exception
/*     */     //   789	841	842	java/lang/Exception
/*     */     //   932	993	994	java/lang/Exception
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isLooksLikeColorValue(String paramString) {
/*     */     char c;
/* 467 */     if ((c = paramString.charAt(0)) == '$' || c == '!' || c == '#' || (c == 'h' && paramString
/*     */ 
/*     */ 
/*     */       
/* 471 */       .startsWith("hsv(")) || (c == 'r' && (paramString
/* 472 */       .startsWith("raw(") || paramString.startsWith("rgb(")))) return true; 
/*     */     return false;
/*     */   }
/*     */   
/*     */   public static class ColorConfigFormatException extends IllegalArgumentException {
/*     */     ColorConfigFormatException(String param1String) {
/* 478 */       super(param1String);
/*     */     }
/*     */     
/*     */     ColorConfigFormatException(String param1String, Throwable param1Throwable) {
/* 482 */       super(param1String, param1Throwable);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\PackColor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */