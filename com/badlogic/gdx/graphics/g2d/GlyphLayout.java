/*     */ package com.badlogic.gdx.graphics.g2d;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.Colors;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.FloatArray;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.Pool;
/*     */ import com.badlogic.gdx.utils.Pools;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GlyphLayout
/*     */   implements Pool.Poolable
/*     */ {
/*  48 */   private static final Pool<GlyphRun> glyphRunPool = Pools.get(GlyphRun.class);
/*  49 */   private static final IntArray colorStack = new IntArray(4);
/*     */ 
/*     */ 
/*     */   
/*     */   private static final float epsilon = 1.0E-4F;
/*     */ 
/*     */   
/*  56 */   public final Array<GlyphRun> runs = new Array(1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  65 */   public final IntArray colors = new IntArray(2);
/*     */   
/*     */   public int glyphCount;
/*     */   
/*     */   public float width;
/*     */   
/*     */   public float height;
/*     */ 
/*     */   
/*     */   public GlyphLayout() {}
/*     */ 
/*     */   
/*     */   public GlyphLayout(BitmapFont paramBitmapFont, CharSequence paramCharSequence) {
/*  78 */     setText(paramBitmapFont, paramCharSequence);
/*     */   }
/*     */ 
/*     */   
/*     */   public GlyphLayout(BitmapFont paramBitmapFont, CharSequence paramCharSequence, Color paramColor, float paramFloat, int paramInt, boolean paramBoolean) {
/*  83 */     setText(paramBitmapFont, paramCharSequence, paramColor, paramFloat, paramInt, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public GlyphLayout(BitmapFont paramBitmapFont, CharSequence paramCharSequence, int paramInt1, int paramInt2, Color paramColor, float paramFloat, int paramInt3, boolean paramBoolean, String paramString) {
/*  89 */     setText(paramBitmapFont, paramCharSequence, paramInt1, paramInt2, paramColor, paramFloat, paramInt3, paramBoolean, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setText(BitmapFont paramBitmapFont, CharSequence paramCharSequence) {
/*  95 */     setText(paramBitmapFont, paramCharSequence, 0, paramCharSequence.length(), paramBitmapFont.getColor(), 0.0F, 8, false, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setText(BitmapFont paramBitmapFont, CharSequence paramCharSequence, Color paramColor, float paramFloat, int paramInt, boolean paramBoolean) {
/* 101 */     setText(paramBitmapFont, paramCharSequence, 0, paramCharSequence.length(), paramColor, paramFloat, paramInt, paramBoolean, null);
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
/*     */   public void setText(BitmapFont paramBitmapFont, CharSequence paramCharSequence, int paramInt1, int paramInt2, Color paramColor, float paramFloat, int paramInt3, boolean paramBoolean, @Null String paramString) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokevirtual reset : ()V
/*     */     //   4: aload_1
/*     */     //   5: getfield data : Lcom/badlogic/gdx/graphics/g2d/BitmapFont$BitmapFontData;
/*     */     //   8: astore_1
/*     */     //   9: iload_3
/*     */     //   10: iload #4
/*     */     //   12: if_icmpne -> 24
/*     */     //   15: aload_0
/*     */     //   16: aload_1
/*     */     //   17: getfield capHeight : F
/*     */     //   20: putfield height : F
/*     */     //   23: return
/*     */     //   24: iload #8
/*     */     //   26: ifeq -> 43
/*     */     //   29: fload #6
/*     */     //   31: aload_1
/*     */     //   32: getfield spaceXadvance : F
/*     */     //   35: ldc 3.0
/*     */     //   37: fmul
/*     */     //   38: invokestatic max : (FF)F
/*     */     //   41: fstore #6
/*     */     //   43: iload #8
/*     */     //   45: ifne -> 53
/*     */     //   48: aload #9
/*     */     //   50: ifnull -> 57
/*     */     //   53: iconst_1
/*     */     //   54: goto -> 58
/*     */     //   57: iconst_0
/*     */     //   58: istore #8
/*     */     //   60: aload #5
/*     */     //   62: invokevirtual toIntBits : ()I
/*     */     //   65: dup
/*     */     //   66: istore #5
/*     */     //   68: istore #10
/*     */     //   70: aload_0
/*     */     //   71: getfield colors : Lcom/badlogic/gdx/utils/IntArray;
/*     */     //   74: iconst_0
/*     */     //   75: iload #5
/*     */     //   77: invokevirtual add : (II)V
/*     */     //   80: aload_1
/*     */     //   81: getfield markupEnabled : Z
/*     */     //   84: dup
/*     */     //   85: istore #11
/*     */     //   87: ifeq -> 98
/*     */     //   90: getstatic com/badlogic/gdx/graphics/g2d/GlyphLayout.colorStack : Lcom/badlogic/gdx/utils/IntArray;
/*     */     //   93: iload #5
/*     */     //   95: invokevirtual add : (I)V
/*     */     //   98: iconst_0
/*     */     //   99: istore #12
/*     */     //   101: fconst_0
/*     */     //   102: fstore #13
/*     */     //   104: aload_1
/*     */     //   105: getfield down : F
/*     */     //   108: fstore #14
/*     */     //   110: aconst_null
/*     */     //   111: astore #15
/*     */     //   113: aconst_null
/*     */     //   114: astore #16
/*     */     //   116: iload_3
/*     */     //   117: istore #17
/*     */     //   119: iconst_0
/*     */     //   120: istore #19
/*     */     //   122: iload_3
/*     */     //   123: iload #4
/*     */     //   125: if_icmpne -> 145
/*     */     //   128: iload #17
/*     */     //   130: iload #4
/*     */     //   132: if_icmpeq -> 790
/*     */     //   135: iload #4
/*     */     //   137: istore #18
/*     */     //   139: iconst_1
/*     */     //   140: istore #12
/*     */     //   142: goto -> 258
/*     */     //   145: aload_2
/*     */     //   146: iload_3
/*     */     //   147: iinc #3, 1
/*     */     //   150: invokeinterface charAt : (I)C
/*     */     //   155: lookupswitch default -> 255, 10 -> 180, 91 -> 191
/*     */     //   180: iload_3
/*     */     //   181: iconst_1
/*     */     //   182: isub
/*     */     //   183: istore #18
/*     */     //   185: iconst_1
/*     */     //   186: istore #19
/*     */     //   188: goto -> 258
/*     */     //   191: iload #11
/*     */     //   193: ifeq -> 255
/*     */     //   196: aload_0
/*     */     //   197: aload_2
/*     */     //   198: iload_3
/*     */     //   199: iload #4
/*     */     //   201: invokespecial parseColorMarkup : (Ljava/lang/CharSequence;II)I
/*     */     //   204: dup
/*     */     //   205: istore #20
/*     */     //   207: iflt -> 245
/*     */     //   210: iload_3
/*     */     //   211: iconst_1
/*     */     //   212: isub
/*     */     //   213: istore #18
/*     */     //   215: iload_3
/*     */     //   216: iload #20
/*     */     //   218: iconst_1
/*     */     //   219: iadd
/*     */     //   220: iadd
/*     */     //   221: dup
/*     */     //   222: istore_3
/*     */     //   223: iload #4
/*     */     //   225: if_icmpne -> 234
/*     */     //   228: iconst_1
/*     */     //   229: istore #12
/*     */     //   231: goto -> 258
/*     */     //   234: getstatic com/badlogic/gdx/graphics/g2d/GlyphLayout.colorStack : Lcom/badlogic/gdx/utils/IntArray;
/*     */     //   237: invokevirtual peek : ()I
/*     */     //   240: istore #10
/*     */     //   242: goto -> 258
/*     */     //   245: iload #20
/*     */     //   247: bipush #-2
/*     */     //   249: if_icmpne -> 255
/*     */     //   252: iinc #3, 1
/*     */     //   255: goto -> 119
/*     */     //   258: getstatic com/badlogic/gdx/graphics/g2d/GlyphLayout.glyphRunPool : Lcom/badlogic/gdx/utils/Pool;
/*     */     //   261: invokevirtual obtain : ()Ljava/lang/Object;
/*     */     //   264: checkcast com/badlogic/gdx/graphics/g2d/GlyphLayout$GlyphRun
/*     */     //   267: dup
/*     */     //   268: astore #20
/*     */     //   270: fconst_0
/*     */     //   271: putfield x : F
/*     */     //   274: aload #20
/*     */     //   276: fload #13
/*     */     //   278: putfield y : F
/*     */     //   281: aload_1
/*     */     //   282: aload #20
/*     */     //   284: aload_2
/*     */     //   285: iload #17
/*     */     //   287: iload #18
/*     */     //   289: aload #16
/*     */     //   291: invokevirtual getGlyphs : (Lcom/badlogic/gdx/graphics/g2d/GlyphLayout$GlyphRun;Ljava/lang/CharSequence;IILcom/badlogic/gdx/graphics/g2d/BitmapFont$Glyph;)V
/*     */     //   294: aload_0
/*     */     //   295: dup
/*     */     //   296: getfield glyphCount : I
/*     */     //   299: aload #20
/*     */     //   301: getfield glyphs : Lcom/badlogic/gdx/utils/Array;
/*     */     //   304: getfield size : I
/*     */     //   307: iadd
/*     */     //   308: putfield glyphCount : I
/*     */     //   311: iload #10
/*     */     //   313: iload #5
/*     */     //   315: if_icmpeq -> 386
/*     */     //   318: aload_0
/*     */     //   319: getfield colors : Lcom/badlogic/gdx/utils/IntArray;
/*     */     //   322: aload_0
/*     */     //   323: getfield colors : Lcom/badlogic/gdx/utils/IntArray;
/*     */     //   326: getfield size : I
/*     */     //   329: iconst_2
/*     */     //   330: isub
/*     */     //   331: invokevirtual get : (I)I
/*     */     //   334: aload_0
/*     */     //   335: getfield glyphCount : I
/*     */     //   338: if_icmpne -> 362
/*     */     //   341: aload_0
/*     */     //   342: getfield colors : Lcom/badlogic/gdx/utils/IntArray;
/*     */     //   345: aload_0
/*     */     //   346: getfield colors : Lcom/badlogic/gdx/utils/IntArray;
/*     */     //   349: getfield size : I
/*     */     //   352: iconst_1
/*     */     //   353: isub
/*     */     //   354: iload #10
/*     */     //   356: invokevirtual set : (II)V
/*     */     //   359: goto -> 382
/*     */     //   362: aload_0
/*     */     //   363: getfield colors : Lcom/badlogic/gdx/utils/IntArray;
/*     */     //   366: aload_0
/*     */     //   367: getfield glyphCount : I
/*     */     //   370: invokevirtual add : (I)V
/*     */     //   373: aload_0
/*     */     //   374: getfield colors : Lcom/badlogic/gdx/utils/IntArray;
/*     */     //   377: iload #10
/*     */     //   379: invokevirtual add : (I)V
/*     */     //   382: iload #10
/*     */     //   384: istore #5
/*     */     //   386: aload #20
/*     */     //   388: getfield glyphs : Lcom/badlogic/gdx/utils/Array;
/*     */     //   391: getfield size : I
/*     */     //   394: ifne -> 413
/*     */     //   397: getstatic com/badlogic/gdx/graphics/g2d/GlyphLayout.glyphRunPool : Lcom/badlogic/gdx/utils/Pool;
/*     */     //   400: aload #20
/*     */     //   402: invokevirtual free : (Ljava/lang/Object;)V
/*     */     //   405: aload #15
/*     */     //   407: ifnonnull -> 449
/*     */     //   410: goto -> 744
/*     */     //   413: aload #15
/*     */     //   415: ifnonnull -> 434
/*     */     //   418: aload #20
/*     */     //   420: astore #15
/*     */     //   422: aload_0
/*     */     //   423: getfield runs : Lcom/badlogic/gdx/utils/Array;
/*     */     //   426: aload #15
/*     */     //   428: invokevirtual add : (Ljava/lang/Object;)V
/*     */     //   431: goto -> 449
/*     */     //   434: aload #15
/*     */     //   436: aload #20
/*     */     //   438: invokevirtual appendRun : (Lcom/badlogic/gdx/graphics/g2d/GlyphLayout$GlyphRun;)V
/*     */     //   441: getstatic com/badlogic/gdx/graphics/g2d/GlyphLayout.glyphRunPool : Lcom/badlogic/gdx/utils/Pool;
/*     */     //   444: aload #20
/*     */     //   446: invokevirtual free : (Ljava/lang/Object;)V
/*     */     //   449: iload #19
/*     */     //   451: ifne -> 459
/*     */     //   454: iload #12
/*     */     //   456: ifeq -> 472
/*     */     //   459: aload_0
/*     */     //   460: aload_1
/*     */     //   461: aload #15
/*     */     //   463: invokespecial setLastGlyphXAdvance : (Lcom/badlogic/gdx/graphics/g2d/BitmapFont$BitmapFontData;Lcom/badlogic/gdx/graphics/g2d/GlyphLayout$GlyphRun;)V
/*     */     //   466: aconst_null
/*     */     //   467: astore #16
/*     */     //   469: goto -> 485
/*     */     //   472: aload #15
/*     */     //   474: getfield glyphs : Lcom/badlogic/gdx/utils/Array;
/*     */     //   477: invokevirtual peek : ()Ljava/lang/Object;
/*     */     //   480: checkcast com/badlogic/gdx/graphics/g2d/BitmapFont$Glyph
/*     */     //   483: astore #16
/*     */     //   485: iload #8
/*     */     //   487: ifeq -> 744
/*     */     //   490: aload #15
/*     */     //   492: getfield glyphs : Lcom/badlogic/gdx/utils/Array;
/*     */     //   495: getfield size : I
/*     */     //   498: ifeq -> 744
/*     */     //   501: iload #19
/*     */     //   503: ifne -> 511
/*     */     //   506: iload #12
/*     */     //   508: ifeq -> 744
/*     */     //   511: aload #15
/*     */     //   513: getfield xAdvances : Lcom/badlogic/gdx/utils/FloatArray;
/*     */     //   516: invokevirtual first : ()F
/*     */     //   519: aload #15
/*     */     //   521: getfield xAdvances : Lcom/badlogic/gdx/utils/FloatArray;
/*     */     //   524: iconst_1
/*     */     //   525: invokevirtual get : (I)F
/*     */     //   528: fadd
/*     */     //   529: fstore #20
/*     */     //   531: iconst_2
/*     */     //   532: istore #21
/*     */     //   534: iload #21
/*     */     //   536: aload #15
/*     */     //   538: getfield xAdvances : Lcom/badlogic/gdx/utils/FloatArray;
/*     */     //   541: getfield size : I
/*     */     //   544: if_icmpge -> 744
/*     */     //   547: aload #15
/*     */     //   549: getfield glyphs : Lcom/badlogic/gdx/utils/Array;
/*     */     //   552: iload #21
/*     */     //   554: iconst_1
/*     */     //   555: isub
/*     */     //   556: invokevirtual get : (I)Ljava/lang/Object;
/*     */     //   559: checkcast com/badlogic/gdx/graphics/g2d/BitmapFont$Glyph
/*     */     //   562: astore #22
/*     */     //   564: aload_0
/*     */     //   565: aload #22
/*     */     //   567: aload_1
/*     */     //   568: invokespecial getGlyphWidth : (Lcom/badlogic/gdx/graphics/g2d/BitmapFont$Glyph;Lcom/badlogic/gdx/graphics/g2d/BitmapFont$BitmapFontData;)F
/*     */     //   571: fstore #22
/*     */     //   573: fload #20
/*     */     //   575: fload #22
/*     */     //   577: fadd
/*     */     //   578: ldc 1.0E-4
/*     */     //   580: fsub
/*     */     //   581: fload #6
/*     */     //   583: fcmpg
/*     */     //   584: ifgt -> 606
/*     */     //   587: fload #20
/*     */     //   589: aload #15
/*     */     //   591: getfield xAdvances : Lcom/badlogic/gdx/utils/FloatArray;
/*     */     //   594: getfield items : [F
/*     */     //   597: iload #21
/*     */     //   599: faload
/*     */     //   600: fadd
/*     */     //   601: fstore #20
/*     */     //   603: goto -> 738
/*     */     //   606: aload #9
/*     */     //   608: ifnull -> 625
/*     */     //   611: aload_0
/*     */     //   612: aload_1
/*     */     //   613: aload #15
/*     */     //   615: fload #6
/*     */     //   617: aload #9
/*     */     //   619: invokespecial truncate : (Lcom/badlogic/gdx/graphics/g2d/BitmapFont$BitmapFontData;Lcom/badlogic/gdx/graphics/g2d/GlyphLayout$GlyphRun;FLjava/lang/String;)V
/*     */     //   622: goto -> 790
/*     */     //   625: aload_1
/*     */     //   626: aload #15
/*     */     //   628: getfield glyphs : Lcom/badlogic/gdx/utils/Array;
/*     */     //   631: iload #21
/*     */     //   633: invokevirtual getWrapIndex : (Lcom/badlogic/gdx/utils/Array;I)I
/*     */     //   636: dup
/*     */     //   637: istore #20
/*     */     //   639: ifne -> 652
/*     */     //   642: aload #15
/*     */     //   644: getfield x : F
/*     */     //   647: fconst_0
/*     */     //   648: fcmpl
/*     */     //   649: ifeq -> 665
/*     */     //   652: iload #20
/*     */     //   654: aload #15
/*     */     //   656: getfield glyphs : Lcom/badlogic/gdx/utils/Array;
/*     */     //   659: getfield size : I
/*     */     //   662: if_icmplt -> 671
/*     */     //   665: iload #21
/*     */     //   667: iconst_1
/*     */     //   668: isub
/*     */     //   669: istore #20
/*     */     //   671: aload_0
/*     */     //   672: aload_1
/*     */     //   673: aload #15
/*     */     //   675: iload #20
/*     */     //   677: invokespecial wrap : (Lcom/badlogic/gdx/graphics/g2d/BitmapFont$BitmapFontData;Lcom/badlogic/gdx/graphics/g2d/GlyphLayout$GlyphRun;I)Lcom/badlogic/gdx/graphics/g2d/GlyphLayout$GlyphRun;
/*     */     //   680: dup
/*     */     //   681: astore #15
/*     */     //   683: ifnull -> 744
/*     */     //   686: aload_0
/*     */     //   687: getfield runs : Lcom/badlogic/gdx/utils/Array;
/*     */     //   690: aload #15
/*     */     //   692: invokevirtual add : (Ljava/lang/Object;)V
/*     */     //   695: fload #13
/*     */     //   697: fload #14
/*     */     //   699: fadd
/*     */     //   700: fstore #13
/*     */     //   702: aload #15
/*     */     //   704: fconst_0
/*     */     //   705: putfield x : F
/*     */     //   708: aload #15
/*     */     //   710: fload #13
/*     */     //   712: putfield y : F
/*     */     //   715: aload #15
/*     */     //   717: getfield xAdvances : Lcom/badlogic/gdx/utils/FloatArray;
/*     */     //   720: invokevirtual first : ()F
/*     */     //   723: aload #15
/*     */     //   725: getfield xAdvances : Lcom/badlogic/gdx/utils/FloatArray;
/*     */     //   728: iconst_1
/*     */     //   729: invokevirtual get : (I)F
/*     */     //   732: fadd
/*     */     //   733: fstore #20
/*     */     //   735: iconst_1
/*     */     //   736: istore #21
/*     */     //   738: iinc #21, 1
/*     */     //   741: goto -> 534
/*     */     //   744: iload #19
/*     */     //   746: ifeq -> 784
/*     */     //   749: aconst_null
/*     */     //   750: astore #15
/*     */     //   752: aconst_null
/*     */     //   753: astore #16
/*     */     //   755: iload #18
/*     */     //   757: iload #17
/*     */     //   759: if_icmpne -> 777
/*     */     //   762: fload #13
/*     */     //   764: fload #14
/*     */     //   766: aload_1
/*     */     //   767: getfield blankLineScale : F
/*     */     //   770: fmul
/*     */     //   771: fadd
/*     */     //   772: fstore #13
/*     */     //   774: goto -> 784
/*     */     //   777: fload #13
/*     */     //   779: fload #14
/*     */     //   781: fadd
/*     */     //   782: fstore #13
/*     */     //   784: iload_3
/*     */     //   785: istore #17
/*     */     //   787: goto -> 119
/*     */     //   790: aload_0
/*     */     //   791: aload_1
/*     */     //   792: getfield capHeight : F
/*     */     //   795: fload #13
/*     */     //   797: invokestatic abs : (F)F
/*     */     //   800: fadd
/*     */     //   801: putfield height : F
/*     */     //   804: aload_0
/*     */     //   805: aload_1
/*     */     //   806: invokespecial calculateWidths : (Lcom/badlogic/gdx/graphics/g2d/BitmapFont$BitmapFontData;)V
/*     */     //   809: aload_0
/*     */     //   810: fload #6
/*     */     //   812: iload #7
/*     */     //   814: invokespecial alignRuns : (FI)V
/*     */     //   817: iload #11
/*     */     //   819: ifeq -> 828
/*     */     //   822: getstatic com/badlogic/gdx/graphics/g2d/GlyphLayout.colorStack : Lcom/badlogic/gdx/utils/IntArray;
/*     */     //   825: invokevirtual clear : ()V
/*     */     //   828: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #115	-> 0
/*     */     //   #117	-> 4
/*     */     //   #118	-> 9
/*     */     //   #119	-> 15
/*     */     //   #120	-> 23
/*     */     //   #124	-> 24
/*     */     //   #125	-> 43
/*     */     //   #127	-> 60
/*     */     //   #128	-> 70
/*     */     //   #129	-> 80
/*     */     //   #130	-> 85
/*     */     //   #132	-> 98
/*     */     //   #133	-> 101
/*     */     //   #134	-> 110
/*     */     //   #135	-> 113
/*     */     //   #136	-> 116
/*     */     //   #140	-> 119
/*     */     //   #141	-> 122
/*     */     //   #142	-> 128
/*     */     //   #143	-> 135
/*     */     //   #144	-> 139
/*     */     //   #147	-> 145
/*     */     //   #149	-> 180
/*     */     //   #150	-> 185
/*     */     //   #151	-> 188
/*     */     //   #153	-> 191
/*     */     //   #154	-> 196
/*     */     //   #155	-> 205
/*     */     //   #156	-> 210
/*     */     //   #157	-> 215
/*     */     //   #158	-> 222
/*     */     //   #159	-> 228
/*     */     //   #161	-> 234
/*     */     //   #162	-> 242
/*     */     //   #164	-> 245
/*     */     //   #168	-> 255
/*     */     //   #175	-> 258
/*     */     //   #176	-> 268
/*     */     //   #177	-> 274
/*     */     //   #178	-> 281
/*     */     //   #179	-> 294
/*     */     //   #181	-> 311
/*     */     //   #182	-> 318
/*     */     //   #184	-> 341
/*     */     //   #186	-> 362
/*     */     //   #187	-> 373
/*     */     //   #189	-> 382
/*     */     //   #192	-> 386
/*     */     //   #193	-> 397
/*     */     //   #194	-> 405
/*     */     //   #195	-> 413
/*     */     //   #196	-> 418
/*     */     //   #197	-> 422
/*     */     //   #199	-> 434
/*     */     //   #200	-> 441
/*     */     //   #203	-> 449
/*     */     //   #204	-> 459
/*     */     //   #205	-> 466
/*     */     //   #207	-> 472
/*     */     //   #209	-> 485
/*     */     //   #211	-> 501
/*     */     //   #213	-> 511
/*     */     //   #214	-> 531
/*     */     //   #215	-> 547
/*     */     //   #216	-> 564
/*     */     //   #217	-> 573
/*     */     //   #219	-> 587
/*     */     //   #220	-> 603
/*     */     //   #223	-> 606
/*     */     //   #225	-> 611
/*     */     //   #226	-> 622
/*     */     //   #230	-> 625
/*     */     //   #231	-> 637
/*     */     //   #233	-> 665
/*     */     //   #235	-> 671
/*     */     //   #236	-> 681
/*     */     //   #237	-> 686
/*     */     //   #239	-> 695
/*     */     //   #240	-> 702
/*     */     //   #241	-> 708
/*     */     //   #244	-> 715
/*     */     //   #245	-> 735
/*     */     //   #214	-> 738
/*     */     //   #250	-> 744
/*     */     //   #251	-> 749
/*     */     //   #252	-> 752
/*     */     //   #255	-> 755
/*     */     //   #256	-> 762
/*     */     //   #258	-> 777
/*     */     //   #261	-> 784
/*     */     //   #262	-> 787
/*     */     //   #264	-> 790
/*     */     //   #266	-> 804
/*     */     //   #268	-> 809
/*     */     //   #271	-> 817
/*     */     //   #272	-> 828
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
/*     */   private void calculateWidths(BitmapFont.BitmapFontData paramBitmapFontData) {
/* 276 */     float f = 0.0F;
/* 277 */     Object[] arrayOfObject = this.runs.items; byte b; int i;
/* 278 */     for (b = 0, i = this.runs.size; b < i; b++) {
/*     */       GlyphRun glyphRun;
/* 280 */       float[] arrayOfFloat = (glyphRun = (GlyphRun)arrayOfObject[b]).xAdvances.items;
/* 281 */       float f1 = glyphRun.x + arrayOfFloat[0], f2 = 0.0F;
/* 282 */       Object[] arrayOfObject1 = glyphRun.glyphs.items; byte b1; int j;
/* 283 */       for (b1 = 0, j = glyphRun.glyphs.size; b1 < j; ) {
/* 284 */         BitmapFont.Glyph glyph = (BitmapFont.Glyph)arrayOfObject1[b1];
/* 285 */         float f3 = getGlyphWidth(glyph, paramBitmapFontData);
/* 286 */         f2 = Math.max(f2, f1 + f3);
/* 287 */         b1++;
/* 288 */         f1 += arrayOfFloat[b1];
/*     */       } 
/* 290 */       glyphRun.width = Math.max(f1, f2) - glyphRun.x;
/* 291 */       f = Math.max(f, glyphRun.x + glyphRun.width);
/*     */     } 
/* 293 */     this.width = f;
/*     */   }
/*     */ 
/*     */   
/*     */   private void alignRuns(float paramFloat, int paramInt) {
/* 298 */     if ((paramInt & 0x8) == 0) {
/* 299 */       paramInt = ((paramInt & 0x1) != 0) ? 1 : 0;
/* 300 */       Object[] arrayOfObject = this.runs.items; byte b; int i;
/* 301 */       for (b = 0, i = this.runs.size; b < i; b++) {
/*     */         GlyphRun glyphRun;
/* 303 */         (glyphRun = (GlyphRun)arrayOfObject[b]).x += (paramInt != 0) ? (0.5F * (paramFloat - glyphRun.width)) : (paramFloat - glyphRun.width);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void truncate(BitmapFont.BitmapFontData paramBitmapFontData, GlyphRun paramGlyphRun, float paramFloat, String paramString) {
/* 310 */     int i = paramGlyphRun.glyphs.size;
/*     */ 
/*     */     
/* 313 */     GlyphRun glyphRun = (GlyphRun)glyphRunPool.obtain();
/* 314 */     paramBitmapFontData.getGlyphs(glyphRun, paramString, 0, paramString.length(), null);
/* 315 */     float f1 = 0.0F;
/* 316 */     if (glyphRun.xAdvances.size > 0) {
/* 317 */       setLastGlyphXAdvance(paramBitmapFontData, glyphRun);
/* 318 */       float[] arrayOfFloat1 = glyphRun.xAdvances.items; byte b1; int k;
/* 319 */       for (b1 = 1, k = glyphRun.xAdvances.size; b1 < k; b1++)
/* 320 */         f1 += arrayOfFloat1[b1]; 
/*     */     } 
/* 322 */     paramFloat -= f1;
/*     */ 
/*     */     
/* 325 */     byte b = 0;
/* 326 */     float f2 = paramGlyphRun.x;
/* 327 */     float[] arrayOfFloat = paramGlyphRun.xAdvances.items;
/*     */     
/* 329 */     f1 = arrayOfFloat[b];
/*     */     
/* 331 */     while (b < paramGlyphRun.xAdvances.size && (f2 = f2 + f1) <= paramFloat) {
/* 332 */       b++;
/*     */     }
/*     */     
/* 335 */     if (b > 1) {
/*     */       
/* 337 */       paramGlyphRun.glyphs.truncate(b - 1);
/* 338 */       paramGlyphRun.xAdvances.truncate(b);
/* 339 */       setLastGlyphXAdvance(paramBitmapFontData, paramGlyphRun);
/* 340 */       if (glyphRun.xAdvances.size > 0) paramGlyphRun.xAdvances.addAll(glyphRun.xAdvances, 1, glyphRun.xAdvances.size - 1);
/*     */     
/*     */     } else {
/* 343 */       paramGlyphRun.glyphs.clear();
/* 344 */       paramGlyphRun.xAdvances.clear();
/* 345 */       paramGlyphRun.xAdvances.addAll(glyphRun.xAdvances);
/*     */     } 
/*     */     
/*     */     int j;
/* 349 */     if ((j = i - paramGlyphRun.glyphs.size) > 0) {
/* 350 */       this.glyphCount -= j;
/* 351 */       if (paramBitmapFontData.markupEnabled) {
/* 352 */         while (this.colors.size > 2 && this.colors.get(this.colors.size - 2) >= this.glyphCount) {
/* 353 */           this.colors.size -= 2;
/*     */         }
/*     */       }
/*     */     } 
/* 357 */     paramGlyphRun.glyphs.addAll(glyphRun.glyphs);
/* 358 */     this.glyphCount += paramString.length();
/*     */     
/* 360 */     glyphRunPool.free(glyphRun);
/*     */   }
/*     */ 
/*     */   
/*     */   private GlyphRun wrap(BitmapFont.BitmapFontData paramBitmapFontData, GlyphRun paramGlyphRun, int paramInt) {
/*     */     int i, k;
/* 366 */     Array<BitmapFont.Glyph> array = paramGlyphRun.glyphs;
/* 367 */     int j = paramGlyphRun.glyphs.size;
/* 368 */     FloatArray floatArray = paramGlyphRun.xAdvances;
/*     */ 
/*     */     
/* 371 */     int m = paramInt;
/* 372 */     for (; m > 0 && 
/* 373 */       paramBitmapFontData.isWhitespace((char)((BitmapFont.Glyph)array.get(m - 1)).id); m--);
/*     */ 
/*     */     
/* 376 */     paramInt = paramInt;
/* 377 */     for (; paramInt < j && 
/* 378 */       paramBitmapFontData.isWhitespace((char)((BitmapFont.Glyph)array.get(paramInt)).id); paramInt++);
/*     */ 
/*     */ 
/*     */     
/* 382 */     GlyphRun glyphRun = null;
/* 383 */     if (paramInt < j) {
/*     */       Array<BitmapFont.Glyph> array1;
/*     */ 
/*     */       
/* 387 */       (array1 = (glyphRun = (GlyphRun)glyphRunPool.obtain()).glyphs).addAll(array, 0, m);
/* 388 */       array.removeRange(0, paramInt - 1);
/* 389 */       paramGlyphRun.glyphs = array1;
/* 390 */       glyphRun.glyphs = array;
/*     */       
/*     */       FloatArray floatArray1;
/* 393 */       (floatArray1 = glyphRun.xAdvances).addAll(floatArray, 0, m + 1);
/* 394 */       floatArray.removeRange(1, paramInt);
/* 395 */       floatArray.items[0] = getLineOffset(array, paramBitmapFontData);
/* 396 */       paramGlyphRun.xAdvances = floatArray1;
/* 397 */       glyphRun.xAdvances = floatArray;
/*     */       
/* 399 */       paramInt = paramGlyphRun.glyphs.size;
/* 400 */       i = glyphRun.glyphs.size;
/* 401 */       paramInt = j - paramInt - i;
/* 402 */       this.glyphCount -= paramInt;
/*     */       
/* 404 */       if (paramBitmapFontData.markupEnabled && paramInt > 0) {
/* 405 */         i = this.glyphCount - i;
/* 406 */         for (j = this.colors.size - 2; j >= 2 && (
/*     */           
/* 408 */           k = this.colors.get(j)) > i; j -= 2) {
/* 409 */           this.colors.set(j, k - paramInt);
/*     */         }
/*     */       } 
/*     */     } else {
/*     */       
/* 414 */       i.truncate(m);
/* 415 */       k.truncate(m + 1);
/*     */       
/*     */       int n;
/* 418 */       if ((n = paramInt - m) > 0) {
/* 419 */         this.glyphCount -= n;
/* 420 */         if (paramBitmapFontData.markupEnabled && this.colors.get(this.colors.size - 2) > this.glyphCount) {
/*     */           
/* 422 */           n = this.colors.peek();
/* 423 */           while (this.colors.get(this.colors.size - 2) > this.glyphCount)
/* 424 */             this.colors.size -= 2; 
/* 425 */           this.colors.set(this.colors.size - 2, this.glyphCount);
/* 426 */           this.colors.set(this.colors.size - 1, n);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 431 */     if (m == 0) {
/*     */       
/* 433 */       glyphRunPool.free(paramGlyphRun);
/* 434 */       this.runs.pop();
/*     */     } else {
/* 436 */       setLastGlyphXAdvance(paramBitmapFontData, paramGlyphRun);
/*     */     } 
/* 438 */     return glyphRun;
/*     */   }
/*     */ 
/*     */   
/*     */   private void setLastGlyphXAdvance(BitmapFont.BitmapFontData paramBitmapFontData, GlyphRun paramGlyphRun) {
/*     */     BitmapFont.Glyph glyph;
/* 444 */     if (!(glyph = (BitmapFont.Glyph)paramGlyphRun.glyphs.peek()).fixedWidth) paramGlyphRun.xAdvances.items[paramGlyphRun.xAdvances.size - 1] = getGlyphWidth(glyph, paramBitmapFontData);
/*     */   
/*     */   }
/*     */   
/*     */   private float getGlyphWidth(BitmapFont.Glyph paramGlyph, BitmapFont.BitmapFontData paramBitmapFontData) {
/* 449 */     return (paramGlyph.fixedWidth ? paramGlyph.xadvance : (paramGlyph.width + paramGlyph.xoffset)) * paramBitmapFontData.scaleX - paramBitmapFontData.padRight;
/*     */   }
/*     */ 
/*     */   
/*     */   private float getLineOffset(Array<BitmapFont.Glyph> paramArray, BitmapFont.BitmapFontData paramBitmapFontData) {
/*     */     BitmapFont.Glyph glyph;
/* 455 */     return ((glyph = (BitmapFont.Glyph)paramArray.first()).fixedWidth ? 0.0F : (-glyph.xoffset * paramBitmapFontData.scaleX)) - paramBitmapFontData.padLeft;
/*     */   }
/*     */   private int parseColorMarkup(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/*     */     int j;
/* 459 */     if (paramInt1 == paramInt2) return -1; 
/* 460 */     switch (paramCharSequence.charAt(paramInt1)) {
/*     */       
/*     */       case '#':
/* 463 */         i = 0;
/* 464 */         for (j = paramInt1 + 1; j < paramInt2; j++) {
/*     */           char c;
/* 466 */           if ((c = paramCharSequence.charAt(j)) == ']') {
/* 467 */             if (j >= paramInt1 + 2 && j <= paramInt1 + 9) {
/* 468 */               if (j - paramInt1 < 8) i = i << 9 - j - paramInt1 << 2 | 0xFF; 
/* 469 */               colorStack.add(Integer.reverseBytes(i));
/* 470 */               return j - paramInt1;
/*     */             }  break;
/* 472 */           }  i = (i << 4) + c;
/* 473 */           if (c >= '0' && c <= '9') {
/* 474 */             i -= 48;
/* 475 */           } else if (c >= 'A' && c <= 'F') {
/* 476 */             i -= 55;
/* 477 */           } else if (c >= 'a' && c <= 'f') {
/* 478 */             i -= 87;
/*     */           } else {
/*     */             break;
/*     */           } 
/* 482 */         }  return -1;
/*     */       case '[':
/* 484 */         return -2;
/*     */       case ']':
/* 486 */         if (colorStack.size > 1) colorStack.pop(); 
/* 487 */         return 0;
/*     */     } 
/*     */     
/* 490 */     for (int i = paramInt1 + 1; i < paramInt2; i++) {
/*     */       
/* 492 */       if ((j = paramCharSequence.charAt(i)) == 93) {
/*     */         Color color;
/* 494 */         if ((color = Colors.get(paramCharSequence.subSequence(paramInt1, i).toString())) == null) return -1; 
/* 495 */         colorStack.add(color.toIntBits());
/* 496 */         return i - paramInt1;
/*     */       } 
/* 498 */     }  return -1;
/*     */   }
/*     */   
/*     */   public void reset() {
/* 502 */     glyphRunPool.freeAll(this.runs);
/* 503 */     this.runs.clear();
/* 504 */     this.colors.clear();
/* 505 */     this.glyphCount = 0;
/* 506 */     this.width = 0.0F;
/* 507 */     this.height = 0.0F;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 511 */     if (this.runs.size == 0) return ""; 
/*     */     StringBuilder stringBuilder;
/* 513 */     (stringBuilder = new StringBuilder(128)).append(this.width);
/* 514 */     stringBuilder.append('x');
/* 515 */     stringBuilder.append(this.height);
/* 516 */     stringBuilder.append('\n'); byte b; int i;
/* 517 */     for (b = 0, i = this.runs.size; b < i; b++) {
/* 518 */       stringBuilder.append(((GlyphRun)this.runs.get(b)).toString());
/* 519 */       stringBuilder.append('\n');
/*     */     } 
/* 521 */     stringBuilder.setLength(stringBuilder.length() - 1);
/* 522 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public static class GlyphRun
/*     */     implements Pool.Poolable
/*     */   {
/* 528 */     public Array<BitmapFont.Glyph> glyphs = new Array();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 534 */     public FloatArray xAdvances = new FloatArray(); public float x;
/*     */     public float y;
/*     */     public float width;
/*     */     
/*     */     void appendRun(GlyphRun param1GlyphRun) {
/* 539 */       this.glyphs.addAll(param1GlyphRun.glyphs);
/*     */       
/* 541 */       if (this.xAdvances.notEmpty()) this.xAdvances.size--; 
/* 542 */       this.xAdvances.addAll(param1GlyphRun.xAdvances);
/*     */     }
/*     */     
/*     */     public void reset() {
/* 546 */       this.glyphs.clear();
/* 547 */       this.xAdvances.clear();
/*     */     }
/*     */     
/*     */     public String toString() {
/* 551 */       StringBuilder stringBuilder = new StringBuilder(this.glyphs.size + 32);
/* 552 */       Array<BitmapFont.Glyph> array = this.glyphs; byte b; int i;
/* 553 */       for (b = 0, i = array.size; b < i; b++) {
/* 554 */         BitmapFont.Glyph glyph = (BitmapFont.Glyph)array.get(b);
/* 555 */         stringBuilder.append((char)glyph.id);
/*     */       } 
/* 557 */       stringBuilder.append(", ");
/* 558 */       stringBuilder.append(this.x);
/* 559 */       stringBuilder.append(", ");
/* 560 */       stringBuilder.append(this.y);
/* 561 */       stringBuilder.append(", ");
/* 562 */       stringBuilder.append(this.width);
/* 563 */       return stringBuilder.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g2d\GlyphLayout.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */