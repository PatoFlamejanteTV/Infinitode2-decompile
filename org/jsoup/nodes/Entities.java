/*     */ package org.jsoup.nodes;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.nio.charset.CharsetEncoder;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import org.jsoup.SerializationException;
/*     */ import org.jsoup.helper.Validate;
/*     */ import org.jsoup.internal.StringUtil;
/*     */ import org.jsoup.parser.CharacterReader;
/*     */ import org.jsoup.parser.Parser;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Entities
/*     */ {
/*     */   private static final int empty = -1;
/*     */   private static final String emptyName = "";
/*     */   static final int codepointRadix = 36;
/*  28 */   private static final char[] codeDelims = new char[] { ',', ';' };
/*  29 */   private static final HashMap<String, String> multipoints = new HashMap<>();
/*     */   
/*     */   private static Document.OutputSettings DefaultOutput;
/*     */   
/*     */   public enum EscapeMode
/*     */   {
/*  35 */     xhtml(EntitiesData.xmlPoints, 4),
/*     */ 
/*     */ 
/*     */     
/*  39 */     base(EntitiesData.basePoints, 106),
/*     */ 
/*     */ 
/*     */     
/*  43 */     extended(EntitiesData.fullPoints, 2125);
/*     */     
/*     */     private String[] nameKeys;
/*     */     
/*     */     private int[] codeVals;
/*     */     
/*     */     private int[] codeKeys;
/*     */     
/*     */     private String[] nameVals;
/*     */     
/*     */     EscapeMode(String param1String1, int param1Int1) {
/*  54 */       Entities.load(this, param1String1, param1Int1);
/*     */     }
/*     */     
/*     */     final int codepointForName(String param1String) {
/*     */       int i;
/*  59 */       return ((i = Arrays.binarySearch((Object[])this.nameKeys, param1String)) >= 0) ? this.codeVals[i] : -1;
/*     */     }
/*     */     
/*     */     final String nameForCodepoint(int param1Int) {
/*     */       int i;
/*  64 */       if ((i = Arrays.binarySearch(this.codeKeys, param1Int)) >= 0) {
/*     */ 
/*     */         
/*  67 */         if (i < this.nameVals.length - 1 && this.codeKeys[i + 1] == param1Int)
/*  68 */           return this.nameVals[i + 1];  return this.nameVals[i];
/*     */       } 
/*  70 */       return "";
/*     */     }
/*     */     
/*     */     private int size() {
/*  74 */       return this.nameKeys.length;
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
/*     */   public static boolean isNamedEntity(String paramString) {
/*  88 */     return (EscapeMode.extended.codepointForName(paramString) != -1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isBaseNamedEntity(String paramString) {
/*  99 */     return (EscapeMode.base.codepointForName(paramString) != -1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getByName(String paramString) {
/*     */     String str;
/* 110 */     if ((str = multipoints.get(paramString)) != null)
/* 111 */       return str; 
/*     */     int i;
/* 113 */     if ((i = EscapeMode.extended.codepointForName(paramString)) != -1)
/* 114 */       return new String(new int[] { i }, 0, 1); 
/* 115 */     return "";
/*     */   }
/*     */   
/*     */   public static int codepointsForName(String paramString, int[] paramArrayOfint) {
/*     */     String str;
/* 120 */     if ((str = multipoints.get(paramString)) != null) {
/* 121 */       paramArrayOfint[0] = str.codePointAt(0);
/* 122 */       paramArrayOfint[1] = str.codePointAt(1);
/* 123 */       return 2;
/*     */     } 
/*     */     int i;
/* 126 */     if ((i = EscapeMode.extended.codepointForName(paramString)) != -1) {
/* 127 */       paramArrayOfint[0] = i;
/* 128 */       return 1;
/*     */     } 
/* 130 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String escape(String paramString, Document.OutputSettings paramOutputSettings) {
/* 141 */     if (paramString == null)
/* 142 */       return ""; 
/* 143 */     StringBuilder stringBuilder = StringUtil.borrowBuilder();
/*     */     try {
/* 145 */       escape(stringBuilder, paramString, paramOutputSettings, false, false, false, false);
/* 146 */     } catch (IOException iOException) {
/* 147 */       throw new SerializationException(iOException);
/*     */     } 
/* 149 */     return StringUtil.releaseBuilder(stringBuilder);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String escape(String paramString) {
/* 160 */     if (DefaultOutput == null)
/* 161 */       DefaultOutput = new Document.OutputSettings(); 
/* 162 */     return escape(paramString, DefaultOutput);
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
/*     */   static void escape(Appendable paramAppendable, String paramString, Document.OutputSettings paramOutputSettings, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
/*     */     // Byte code:
/*     */     //   0: iconst_0
/*     */     //   1: istore #7
/*     */     //   3: iconst_0
/*     */     //   4: istore #8
/*     */     //   6: aload_2
/*     */     //   7: invokevirtual escapeMode : ()Lorg/jsoup/nodes/Entities$EscapeMode;
/*     */     //   10: astore #9
/*     */     //   12: aload_2
/*     */     //   13: invokevirtual encoder : ()Ljava/nio/charset/CharsetEncoder;
/*     */     //   16: astore #10
/*     */     //   18: aload_2
/*     */     //   19: getfield coreCharset : Lorg/jsoup/nodes/Entities$CoreCharset;
/*     */     //   22: astore #11
/*     */     //   24: aload_1
/*     */     //   25: invokevirtual length : ()I
/*     */     //   28: istore #12
/*     */     //   30: iconst_0
/*     */     //   31: istore #14
/*     */     //   33: iconst_0
/*     */     //   34: istore #15
/*     */     //   36: iload #15
/*     */     //   38: iload #12
/*     */     //   40: if_icmpge -> 473
/*     */     //   43: aload_1
/*     */     //   44: iload #15
/*     */     //   46: invokevirtual codePointAt : (I)I
/*     */     //   49: istore #13
/*     */     //   51: iload #4
/*     */     //   53: ifeq -> 128
/*     */     //   56: iload #13
/*     */     //   58: invokestatic isWhitespace : (I)Z
/*     */     //   61: ifeq -> 105
/*     */     //   64: iload #5
/*     */     //   66: ifeq -> 74
/*     */     //   69: iload #8
/*     */     //   71: ifeq -> 460
/*     */     //   74: iload #7
/*     */     //   76: ifne -> 460
/*     */     //   79: iload #6
/*     */     //   81: ifeq -> 90
/*     */     //   84: iconst_1
/*     */     //   85: istore #14
/*     */     //   87: goto -> 460
/*     */     //   90: aload_0
/*     */     //   91: bipush #32
/*     */     //   93: invokeinterface append : (C)Ljava/lang/Appendable;
/*     */     //   98: pop
/*     */     //   99: iconst_1
/*     */     //   100: istore #7
/*     */     //   102: goto -> 460
/*     */     //   105: iconst_0
/*     */     //   106: istore #7
/*     */     //   108: iconst_1
/*     */     //   109: istore #8
/*     */     //   111: iload #14
/*     */     //   113: ifeq -> 128
/*     */     //   116: aload_0
/*     */     //   117: bipush #32
/*     */     //   119: invokeinterface append : (C)Ljava/lang/Appendable;
/*     */     //   124: pop
/*     */     //   125: iconst_0
/*     */     //   126: istore #14
/*     */     //   128: iload #13
/*     */     //   130: ldc 65536
/*     */     //   132: if_icmpge -> 416
/*     */     //   135: iload #13
/*     */     //   137: i2c
/*     */     //   138: dup
/*     */     //   139: istore #16
/*     */     //   141: lookupswitch default -> 374, 9 -> 362, 10 -> 362, 13 -> 362, 34 -> 334, 38 -> 216, 60 -> 260, 62 -> 306, 160 -> 228
/*     */     //   216: aload_0
/*     */     //   217: ldc '&amp;'
/*     */     //   219: invokeinterface append : (Ljava/lang/CharSequence;)Ljava/lang/Appendable;
/*     */     //   224: pop
/*     */     //   225: goto -> 460
/*     */     //   228: aload #9
/*     */     //   230: getstatic org/jsoup/nodes/Entities$EscapeMode.xhtml : Lorg/jsoup/nodes/Entities$EscapeMode;
/*     */     //   233: if_acmpeq -> 248
/*     */     //   236: aload_0
/*     */     //   237: ldc '&nbsp;'
/*     */     //   239: invokeinterface append : (Ljava/lang/CharSequence;)Ljava/lang/Appendable;
/*     */     //   244: pop
/*     */     //   245: goto -> 460
/*     */     //   248: aload_0
/*     */     //   249: ldc '&#xa0;'
/*     */     //   251: invokeinterface append : (Ljava/lang/CharSequence;)Ljava/lang/Appendable;
/*     */     //   256: pop
/*     */     //   257: goto -> 460
/*     */     //   260: iload_3
/*     */     //   261: ifeq -> 282
/*     */     //   264: aload #9
/*     */     //   266: getstatic org/jsoup/nodes/Entities$EscapeMode.xhtml : Lorg/jsoup/nodes/Entities$EscapeMode;
/*     */     //   269: if_acmpeq -> 282
/*     */     //   272: aload_2
/*     */     //   273: invokevirtual syntax : ()Lorg/jsoup/nodes/Document$OutputSettings$Syntax;
/*     */     //   276: getstatic org/jsoup/nodes/Document$OutputSettings$Syntax.xml : Lorg/jsoup/nodes/Document$OutputSettings$Syntax;
/*     */     //   279: if_acmpne -> 294
/*     */     //   282: aload_0
/*     */     //   283: ldc '&lt;'
/*     */     //   285: invokeinterface append : (Ljava/lang/CharSequence;)Ljava/lang/Appendable;
/*     */     //   290: pop
/*     */     //   291: goto -> 460
/*     */     //   294: aload_0
/*     */     //   295: iload #16
/*     */     //   297: invokeinterface append : (C)Ljava/lang/Appendable;
/*     */     //   302: pop
/*     */     //   303: goto -> 460
/*     */     //   306: iload_3
/*     */     //   307: ifne -> 322
/*     */     //   310: aload_0
/*     */     //   311: ldc '&gt;'
/*     */     //   313: invokeinterface append : (Ljava/lang/CharSequence;)Ljava/lang/Appendable;
/*     */     //   318: pop
/*     */     //   319: goto -> 460
/*     */     //   322: aload_0
/*     */     //   323: iload #16
/*     */     //   325: invokeinterface append : (C)Ljava/lang/Appendable;
/*     */     //   330: pop
/*     */     //   331: goto -> 460
/*     */     //   334: iload_3
/*     */     //   335: ifeq -> 350
/*     */     //   338: aload_0
/*     */     //   339: ldc '&quot;'
/*     */     //   341: invokeinterface append : (Ljava/lang/CharSequence;)Ljava/lang/Appendable;
/*     */     //   346: pop
/*     */     //   347: goto -> 460
/*     */     //   350: aload_0
/*     */     //   351: iload #16
/*     */     //   353: invokeinterface append : (C)Ljava/lang/Appendable;
/*     */     //   358: pop
/*     */     //   359: goto -> 460
/*     */     //   362: aload_0
/*     */     //   363: iload #16
/*     */     //   365: invokeinterface append : (C)Ljava/lang/Appendable;
/*     */     //   370: pop
/*     */     //   371: goto -> 460
/*     */     //   374: iload #16
/*     */     //   376: bipush #32
/*     */     //   378: if_icmplt -> 393
/*     */     //   381: aload #11
/*     */     //   383: iload #16
/*     */     //   385: aload #10
/*     */     //   387: invokestatic canEncode : (Lorg/jsoup/nodes/Entities$CoreCharset;CLjava/nio/charset/CharsetEncoder;)Z
/*     */     //   390: ifne -> 404
/*     */     //   393: aload_0
/*     */     //   394: aload #9
/*     */     //   396: iload #13
/*     */     //   398: invokestatic appendEncoded : (Ljava/lang/Appendable;Lorg/jsoup/nodes/Entities$EscapeMode;I)V
/*     */     //   401: goto -> 460
/*     */     //   404: aload_0
/*     */     //   405: iload #16
/*     */     //   407: invokeinterface append : (C)Ljava/lang/Appendable;
/*     */     //   412: pop
/*     */     //   413: goto -> 460
/*     */     //   416: new java/lang/String
/*     */     //   419: dup
/*     */     //   420: iload #13
/*     */     //   422: invokestatic toChars : (I)[C
/*     */     //   425: invokespecial <init> : ([C)V
/*     */     //   428: astore #16
/*     */     //   430: aload #10
/*     */     //   432: aload #16
/*     */     //   434: invokevirtual canEncode : (Ljava/lang/CharSequence;)Z
/*     */     //   437: ifeq -> 452
/*     */     //   440: aload_0
/*     */     //   441: aload #16
/*     */     //   443: invokeinterface append : (Ljava/lang/CharSequence;)Ljava/lang/Appendable;
/*     */     //   448: pop
/*     */     //   449: goto -> 460
/*     */     //   452: aload_0
/*     */     //   453: aload #9
/*     */     //   455: iload #13
/*     */     //   457: invokestatic appendEncoded : (Ljava/lang/Appendable;Lorg/jsoup/nodes/Entities$EscapeMode;I)V
/*     */     //   460: iload #15
/*     */     //   462: iload #13
/*     */     //   464: invokestatic charCount : (I)I
/*     */     //   467: iadd
/*     */     //   468: istore #15
/*     */     //   470: goto -> 36
/*     */     //   473: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #170	-> 0
/*     */     //   #171	-> 3
/*     */     //   #172	-> 6
/*     */     //   #173	-> 12
/*     */     //   #174	-> 18
/*     */     //   #175	-> 24
/*     */     //   #178	-> 30
/*     */     //   #179	-> 33
/*     */     //   #180	-> 43
/*     */     //   #182	-> 51
/*     */     //   #183	-> 56
/*     */     //   #184	-> 64
/*     */     //   #185	-> 74
/*     */     //   #186	-> 79
/*     */     //   #187	-> 84
/*     */     //   #188	-> 87
/*     */     //   #190	-> 90
/*     */     //   #191	-> 99
/*     */     //   #192	-> 102
/*     */     //   #194	-> 105
/*     */     //   #195	-> 108
/*     */     //   #196	-> 111
/*     */     //   #197	-> 116
/*     */     //   #198	-> 125
/*     */     //   #203	-> 128
/*     */     //   #204	-> 135
/*     */     //   #206	-> 139
/*     */     //   #208	-> 216
/*     */     //   #209	-> 225
/*     */     //   #211	-> 228
/*     */     //   #212	-> 236
/*     */     //   #214	-> 248
/*     */     //   #215	-> 257
/*     */     //   #218	-> 260
/*     */     //   #219	-> 282
/*     */     //   #221	-> 294
/*     */     //   #222	-> 303
/*     */     //   #224	-> 306
/*     */     //   #225	-> 310
/*     */     //   #227	-> 322
/*     */     //   #228	-> 331
/*     */     //   #230	-> 334
/*     */     //   #231	-> 338
/*     */     //   #233	-> 350
/*     */     //   #234	-> 359
/*     */     //   #239	-> 362
/*     */     //   #240	-> 371
/*     */     //   #242	-> 374
/*     */     //   #243	-> 393
/*     */     //   #245	-> 404
/*     */     //   #247	-> 413
/*     */     //   #248	-> 416
/*     */     //   #249	-> 430
/*     */     //   #250	-> 440
/*     */     //   #252	-> 452
/*     */     //   #179	-> 460
/*     */     //   #255	-> 473
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
/*     */   private static void appendEncoded(Appendable paramAppendable, EscapeMode paramEscapeMode, int paramInt) {
/* 258 */     String str = paramEscapeMode.nameForCodepoint(paramInt);
/* 259 */     if (!"".equals(str)) {
/* 260 */       paramAppendable.append('&').append(str).append(';'); return;
/*     */     } 
/* 262 */     paramAppendable.append("&#x").append(Integer.toHexString(paramInt)).append(';');
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String unescape(String paramString) {
/* 272 */     return unescape(paramString, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static String unescape(String paramString, boolean paramBoolean) {
/* 283 */     return Parser.unescapeEntities(paramString, paramBoolean);
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
/*     */   private static boolean canEncode(CoreCharset paramCoreCharset, char paramChar, CharsetEncoder paramCharsetEncoder) {
/* 301 */     switch (paramCoreCharset) {
/*     */       case ascii:
/* 303 */         return (paramChar < '');
/*     */       case utf:
/* 305 */         return true;
/*     */     } 
/* 307 */     return paramCharsetEncoder.canEncode(paramChar);
/*     */   }
/*     */   
/*     */   enum CoreCharset
/*     */   {
/* 312 */     ascii, utf, fallback;
/*     */     
/*     */     static CoreCharset byName(String param1String) {
/* 315 */       if (param1String.equals("US-ASCII"))
/* 316 */         return ascii; 
/* 317 */       if (param1String.startsWith("UTF-"))
/* 318 */         return utf; 
/* 319 */       return fallback;
/*     */     }
/*     */   }
/*     */   
/*     */   private static void load(EscapeMode paramEscapeMode, String paramString, int paramInt) {
/* 324 */     paramEscapeMode.nameKeys = new String[paramInt];
/* 325 */     paramEscapeMode.codeVals = new int[paramInt];
/* 326 */     paramEscapeMode.codeKeys = new int[paramInt];
/* 327 */     paramEscapeMode.nameVals = new String[paramInt];
/*     */     
/* 329 */     byte b = 0;
/* 330 */     CharacterReader characterReader = new CharacterReader(paramString);
/*     */     try {
/* 332 */       while (!characterReader.isEmpty()) {
/*     */ 
/*     */         
/* 335 */         String str1 = characterReader.consumeTo('=');
/* 336 */         characterReader.advance();
/* 337 */         int i = Integer.parseInt(characterReader.consumeToAny(codeDelims), 36);
/* 338 */         byte b1 = characterReader.current();
/* 339 */         characterReader.advance();
/*     */         
/* 341 */         if (b1 == 44) {
/* 342 */           int k = Integer.parseInt(characterReader.consumeTo(';'), 36);
/* 343 */           characterReader.advance();
/*     */         } else {
/* 345 */           b1 = -1;
/*     */         } 
/*     */         String str2;
/* 348 */         int j = Integer.parseInt(str2 = characterReader.consumeTo('&'), 36);
/* 349 */         characterReader.advance();
/*     */         
/* 351 */         paramEscapeMode.nameKeys[b] = str1;
/* 352 */         paramEscapeMode.codeVals[b] = i;
/* 353 */         paramEscapeMode.codeKeys[j] = i;
/* 354 */         paramEscapeMode.nameVals[j] = str1;
/*     */         
/* 356 */         if (b1 != -1) {
/* 357 */           multipoints.put(str1, new String(new int[] { i, b1 }, 0, 2));
/*     */         }
/* 359 */         b++;
/*     */       } 
/*     */       
/* 362 */       Validate.isTrue((b == paramInt), "Unexpected count of entities loaded"); return;
/*     */     } finally {
/* 364 */       characterReader.close();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\nodes\Entities.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */