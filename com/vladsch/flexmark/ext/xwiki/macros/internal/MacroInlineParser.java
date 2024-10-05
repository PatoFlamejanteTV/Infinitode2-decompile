/*     */ package com.vladsch.flexmark.ext.xwiki.macros.internal;
/*     */ 
/*     */ import com.vladsch.flexmark.ext.xwiki.macros.Macro;
/*     */ import com.vladsch.flexmark.parser.InlineParser;
/*     */ import com.vladsch.flexmark.parser.InlineParserExtension;
/*     */ import com.vladsch.flexmark.parser.InlineParserExtensionFactory;
/*     */ import com.vladsch.flexmark.parser.LightInlineParser;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MacroInlineParser
/*     */   implements InlineParserExtension
/*     */ {
/*     */   private final MacroParsing parsing;
/*     */   private List<Macro> openMacros;
/*     */   
/*     */   public MacroInlineParser(LightInlineParser paramLightInlineParser) {
/*  24 */     this.parsing = new MacroParsing(paramLightInlineParser.getParsing());
/*  25 */     this.openMacros = new ArrayList<>();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void finalizeDocument(InlineParser paramInlineParser) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void finalizeBlock(InlineParser paramInlineParser) {
/*  35 */     for (int i = this.openMacros.size(); i-- > 0;) {
/*  36 */       paramInlineParser.moveNodes((Node)this.openMacros.get(i), paramInlineParser.getBlock().getLastChild());
/*     */     }
/*     */     
/*  39 */     this.openMacros.clear();
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
/*     */   public boolean parse(LightInlineParser paramLightInlineParser) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: iconst_1
/*     */     //   2: invokeinterface peek : (I)C
/*     */     //   7: bipush #123
/*     */     //   9: if_icmpne -> 749
/*     */     //   12: aload_1
/*     */     //   13: invokeinterface getInput : ()Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*     */     //   18: astore_2
/*     */     //   19: aload_1
/*     */     //   20: invokeinterface getIndex : ()I
/*     */     //   25: istore_3
/*     */     //   26: aload_1
/*     */     //   27: aload_0
/*     */     //   28: getfield parsing : Lcom/vladsch/flexmark/ext/xwiki/macros/internal/MacroParsing;
/*     */     //   31: getfield MACRO_TAG : Ljava/util/regex/Pattern;
/*     */     //   34: invokeinterface matcher : (Ljava/util/regex/Pattern;)Ljava/util/regex/Matcher;
/*     */     //   39: dup
/*     */     //   40: astore #4
/*     */     //   42: ifnull -> 749
/*     */     //   45: aload_2
/*     */     //   46: aload #4
/*     */     //   48: invokevirtual start : ()I
/*     */     //   51: aload #4
/*     */     //   53: invokevirtual end : ()I
/*     */     //   56: invokeinterface subSequence : (II)Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*     */     //   61: dup
/*     */     //   62: astore #5
/*     */     //   64: iconst_2
/*     */     //   65: invokeinterface charAt : (I)C
/*     */     //   70: bipush #47
/*     */     //   72: if_icmpne -> 292
/*     */     //   75: aload_2
/*     */     //   76: aload #4
/*     */     //   78: iconst_2
/*     */     //   79: invokevirtual start : (I)I
/*     */     //   82: aload #4
/*     */     //   84: iconst_2
/*     */     //   85: invokevirtual end : (I)I
/*     */     //   88: invokeinterface subSequence : (II)Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*     */     //   93: astore_2
/*     */     //   94: aload_0
/*     */     //   95: getfield openMacros : Ljava/util/List;
/*     */     //   98: invokeinterface size : ()I
/*     */     //   103: istore #4
/*     */     //   105: iload #4
/*     */     //   107: iinc #4, -1
/*     */     //   110: ifle -> 289
/*     */     //   113: aload_0
/*     */     //   114: getfield openMacros : Ljava/util/List;
/*     */     //   117: iload #4
/*     */     //   119: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   124: checkcast com/vladsch/flexmark/ext/xwiki/macros/Macro
/*     */     //   127: invokevirtual getName : ()Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*     */     //   130: aload_2
/*     */     //   131: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   134: ifeq -> 105
/*     */     //   137: aload_1
/*     */     //   138: invokeinterface flushTextNode : ()Z
/*     */     //   143: pop
/*     */     //   144: aload_0
/*     */     //   145: getfield openMacros : Ljava/util/List;
/*     */     //   148: invokeinterface size : ()I
/*     */     //   153: istore_3
/*     */     //   154: iload_3
/*     */     //   155: iinc #3, -1
/*     */     //   158: iload #4
/*     */     //   160: if_icmple -> 194
/*     */     //   163: aload_1
/*     */     //   164: aload_0
/*     */     //   165: getfield openMacros : Ljava/util/List;
/*     */     //   168: iload_3
/*     */     //   169: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   174: checkcast com/vladsch/flexmark/util/ast/Node
/*     */     //   177: aload_1
/*     */     //   178: invokeinterface getBlock : ()Lcom/vladsch/flexmark/util/ast/Node;
/*     */     //   183: invokevirtual getLastChild : ()Lcom/vladsch/flexmark/util/ast/Node;
/*     */     //   186: invokeinterface moveNodes : (Lcom/vladsch/flexmark/util/ast/Node;Lcom/vladsch/flexmark/util/ast/Node;)V
/*     */     //   191: goto -> 154
/*     */     //   194: new com/vladsch/flexmark/ext/xwiki/macros/MacroClose
/*     */     //   197: dup
/*     */     //   198: aload #5
/*     */     //   200: iconst_0
/*     */     //   201: iconst_3
/*     */     //   202: invokeinterface subSequence : (II)Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*     */     //   207: aload_2
/*     */     //   208: aload #5
/*     */     //   210: iconst_2
/*     */     //   211: invokeinterface endSequence : (I)Lcom/vladsch/flexmark/util/sequence/IRichSequence;
/*     */     //   216: checkcast com/vladsch/flexmark/util/sequence/BasedSequence
/*     */     //   219: invokespecial <init> : (Lcom/vladsch/flexmark/util/sequence/BasedSequence;Lcom/vladsch/flexmark/util/sequence/BasedSequence;Lcom/vladsch/flexmark/util/sequence/BasedSequence;)V
/*     */     //   222: astore_3
/*     */     //   223: aload_1
/*     */     //   224: invokeinterface getBlock : ()Lcom/vladsch/flexmark/util/ast/Node;
/*     */     //   229: aload_3
/*     */     //   230: invokevirtual appendChild : (Lcom/vladsch/flexmark/util/ast/Node;)V
/*     */     //   233: aload_1
/*     */     //   234: aload_0
/*     */     //   235: getfield openMacros : Ljava/util/List;
/*     */     //   238: iload #4
/*     */     //   240: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   245: checkcast com/vladsch/flexmark/util/ast/Node
/*     */     //   248: aload_3
/*     */     //   249: invokeinterface moveNodes : (Lcom/vladsch/flexmark/util/ast/Node;Lcom/vladsch/flexmark/util/ast/Node;)V
/*     */     //   254: iload #4
/*     */     //   256: ifne -> 271
/*     */     //   259: aload_0
/*     */     //   260: getfield openMacros : Ljava/util/List;
/*     */     //   263: invokeinterface clear : ()V
/*     */     //   268: goto -> 287
/*     */     //   271: aload_0
/*     */     //   272: dup
/*     */     //   273: getfield openMacros : Ljava/util/List;
/*     */     //   276: iconst_0
/*     */     //   277: iload #4
/*     */     //   279: invokeinterface subList : (II)Ljava/util/List;
/*     */     //   284: putfield openMacros : Ljava/util/List;
/*     */     //   287: iconst_1
/*     */     //   288: ireturn
/*     */     //   289: goto -> 742
/*     */     //   292: aload_2
/*     */     //   293: aload #4
/*     */     //   295: iconst_1
/*     */     //   296: invokevirtual start : (I)I
/*     */     //   299: aload #4
/*     */     //   301: iconst_1
/*     */     //   302: invokevirtual end : (I)I
/*     */     //   305: invokeinterface subSequence : (II)Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*     */     //   310: astore_2
/*     */     //   311: aload #5
/*     */     //   313: iconst_3
/*     */     //   314: invokeinterface endCharAt : (I)C
/*     */     //   319: bipush #47
/*     */     //   321: if_icmpne -> 328
/*     */     //   324: iconst_1
/*     */     //   325: goto -> 329
/*     */     //   328: iconst_0
/*     */     //   329: istore #4
/*     */     //   331: new com/vladsch/flexmark/ext/xwiki/macros/Macro
/*     */     //   334: dup
/*     */     //   335: aload #5
/*     */     //   337: iconst_0
/*     */     //   338: iconst_2
/*     */     //   339: invokeinterface subSequence : (II)Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*     */     //   344: aload_2
/*     */     //   345: aload #5
/*     */     //   347: iload #4
/*     */     //   349: ifeq -> 356
/*     */     //   352: iconst_3
/*     */     //   353: goto -> 357
/*     */     //   356: iconst_2
/*     */     //   357: invokeinterface endSequence : (I)Lcom/vladsch/flexmark/util/sequence/IRichSequence;
/*     */     //   362: checkcast com/vladsch/flexmark/util/sequence/BasedSequence
/*     */     //   365: invokespecial <init> : (Lcom/vladsch/flexmark/util/sequence/BasedSequence;Lcom/vladsch/flexmark/util/sequence/BasedSequence;Lcom/vladsch/flexmark/util/sequence/BasedSequence;)V
/*     */     //   368: dup
/*     */     //   369: astore_3
/*     */     //   370: invokevirtual setCharsFromContent : ()V
/*     */     //   373: aload_1
/*     */     //   374: invokeinterface flushTextNode : ()Z
/*     */     //   379: pop
/*     */     //   380: aload_1
/*     */     //   381: invokeinterface getBlock : ()Lcom/vladsch/flexmark/util/ast/Node;
/*     */     //   386: aload_3
/*     */     //   387: invokevirtual appendChild : (Lcom/vladsch/flexmark/util/ast/Node;)V
/*     */     //   390: iload #4
/*     */     //   392: ifne -> 406
/*     */     //   395: aload_0
/*     */     //   396: getfield openMacros : Ljava/util/List;
/*     */     //   399: aload_3
/*     */     //   400: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   405: pop
/*     */     //   406: aload #5
/*     */     //   408: aload_2
/*     */     //   409: invokeinterface getEndOffset : ()I
/*     */     //   414: aload_3
/*     */     //   415: invokevirtual getClosingMarker : ()Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*     */     //   418: invokeinterface getStartOffset : ()I
/*     */     //   423: invokeinterface baseSubSequence : (II)Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*     */     //   428: invokeinterface trim : ()Lcom/vladsch/flexmark/util/sequence/IRichSequence;
/*     */     //   433: checkcast com/vladsch/flexmark/util/sequence/BasedSequence
/*     */     //   436: dup
/*     */     //   437: astore_1
/*     */     //   438: invokeinterface isEmpty : ()Z
/*     */     //   443: ifne -> 740
/*     */     //   446: aload_3
/*     */     //   447: aload_1
/*     */     //   448: invokevirtual setAttributeText : (Lcom/vladsch/flexmark/util/sequence/BasedSequence;)V
/*     */     //   451: aload_0
/*     */     //   452: getfield parsing : Lcom/vladsch/flexmark/ext/xwiki/macros/internal/MacroParsing;
/*     */     //   455: getfield MACRO_ATTRIBUTE : Ljava/util/regex/Pattern;
/*     */     //   458: aload_1
/*     */     //   459: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
/*     */     //   462: astore_2
/*     */     //   463: aload_2
/*     */     //   464: invokevirtual find : ()Z
/*     */     //   467: ifeq -> 740
/*     */     //   470: aload_1
/*     */     //   471: aload_2
/*     */     //   472: iconst_1
/*     */     //   473: invokevirtual start : (I)I
/*     */     //   476: aload_2
/*     */     //   477: iconst_1
/*     */     //   478: invokevirtual end : (I)I
/*     */     //   481: invokeinterface subSequence : (II)Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*     */     //   486: astore #4
/*     */     //   488: aload_2
/*     */     //   489: invokevirtual groupCount : ()I
/*     */     //   492: iconst_1
/*     */     //   493: if_icmpeq -> 505
/*     */     //   496: aload_2
/*     */     //   497: iconst_2
/*     */     //   498: invokevirtual start : (I)I
/*     */     //   501: iconst_m1
/*     */     //   502: if_icmpne -> 511
/*     */     //   505: getstatic com/vladsch/flexmark/util/sequence/BasedSequence.NULL : Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*     */     //   508: goto -> 535
/*     */     //   511: aload_1
/*     */     //   512: aload_2
/*     */     //   513: iconst_1
/*     */     //   514: invokevirtual end : (I)I
/*     */     //   517: aload_2
/*     */     //   518: iconst_2
/*     */     //   519: invokevirtual start : (I)I
/*     */     //   522: invokeinterface subSequence : (II)Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*     */     //   527: invokeinterface trim : ()Lcom/vladsch/flexmark/util/sequence/IRichSequence;
/*     */     //   532: checkcast com/vladsch/flexmark/util/sequence/BasedSequence
/*     */     //   535: astore #5
/*     */     //   537: aload_2
/*     */     //   538: invokevirtual groupCount : ()I
/*     */     //   541: iconst_1
/*     */     //   542: if_icmpeq -> 554
/*     */     //   545: aload_2
/*     */     //   546: iconst_2
/*     */     //   547: invokevirtual start : (I)I
/*     */     //   550: iconst_m1
/*     */     //   551: if_icmpne -> 560
/*     */     //   554: getstatic com/vladsch/flexmark/util/sequence/BasedSequence.NULL : Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*     */     //   557: goto -> 576
/*     */     //   560: aload_1
/*     */     //   561: aload_2
/*     */     //   562: iconst_2
/*     */     //   563: invokevirtual start : (I)I
/*     */     //   566: aload_2
/*     */     //   567: iconst_2
/*     */     //   568: invokevirtual end : (I)I
/*     */     //   571: invokeinterface subSequence : (II)Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*     */     //   576: dup
/*     */     //   577: astore #6
/*     */     //   579: invokeinterface length : ()I
/*     */     //   584: iconst_2
/*     */     //   585: if_icmplt -> 644
/*     */     //   588: aload #6
/*     */     //   590: iconst_0
/*     */     //   591: invokeinterface charAt : (I)C
/*     */     //   596: bipush #34
/*     */     //   598: if_icmpne -> 614
/*     */     //   601: aload #6
/*     */     //   603: iconst_1
/*     */     //   604: invokeinterface endCharAt : (I)C
/*     */     //   609: bipush #34
/*     */     //   611: if_icmpeq -> 640
/*     */     //   614: aload #6
/*     */     //   616: iconst_0
/*     */     //   617: invokeinterface charAt : (I)C
/*     */     //   622: bipush #39
/*     */     //   624: if_icmpne -> 644
/*     */     //   627: aload #6
/*     */     //   629: iconst_1
/*     */     //   630: invokeinterface endCharAt : (I)C
/*     */     //   635: bipush #39
/*     */     //   637: if_icmpne -> 644
/*     */     //   640: iconst_1
/*     */     //   641: goto -> 645
/*     */     //   644: iconst_0
/*     */     //   645: dup
/*     */     //   646: istore #7
/*     */     //   648: ifne -> 657
/*     */     //   651: getstatic com/vladsch/flexmark/util/sequence/BasedSequence.NULL : Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*     */     //   654: goto -> 666
/*     */     //   657: aload #6
/*     */     //   659: iconst_0
/*     */     //   660: iconst_1
/*     */     //   661: invokeinterface subSequence : (II)Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*     */     //   666: astore #8
/*     */     //   668: iload #7
/*     */     //   670: ifne -> 679
/*     */     //   673: getstatic com/vladsch/flexmark/util/sequence/BasedSequence.NULL : Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*     */     //   676: goto -> 691
/*     */     //   679: aload #6
/*     */     //   681: iconst_1
/*     */     //   682: iconst_0
/*     */     //   683: invokeinterface endSequence : (II)Lcom/vladsch/flexmark/util/sequence/IRichSequence;
/*     */     //   688: checkcast com/vladsch/flexmark/util/sequence/BasedSequence
/*     */     //   691: astore #9
/*     */     //   693: iload #7
/*     */     //   695: ifeq -> 712
/*     */     //   698: aload #6
/*     */     //   700: iconst_1
/*     */     //   701: iconst_m1
/*     */     //   702: invokeinterface midSequence : (II)Lcom/vladsch/flexmark/util/sequence/IRichSequence;
/*     */     //   707: checkcast com/vladsch/flexmark/util/sequence/BasedSequence
/*     */     //   710: astore #6
/*     */     //   712: new com/vladsch/flexmark/ext/xwiki/macros/MacroAttribute
/*     */     //   715: dup
/*     */     //   716: aload #4
/*     */     //   718: aload #5
/*     */     //   720: aload #8
/*     */     //   722: aload #6
/*     */     //   724: aload #9
/*     */     //   726: invokespecial <init> : (Lcom/vladsch/flexmark/util/sequence/BasedSequence;Lcom/vladsch/flexmark/util/sequence/BasedSequence;Lcom/vladsch/flexmark/util/sequence/BasedSequence;Lcom/vladsch/flexmark/util/sequence/BasedSequence;Lcom/vladsch/flexmark/util/sequence/BasedSequence;)V
/*     */     //   729: astore #4
/*     */     //   731: aload_3
/*     */     //   732: aload #4
/*     */     //   734: invokevirtual appendChild : (Lcom/vladsch/flexmark/util/ast/Node;)V
/*     */     //   737: goto -> 463
/*     */     //   740: iconst_1
/*     */     //   741: ireturn
/*     */     //   742: aload_1
/*     */     //   743: iload_3
/*     */     //   744: invokeinterface setIndex : (I)V
/*     */     //   749: iconst_0
/*     */     //   750: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #44	-> 0
/*     */     //   #45	-> 12
/*     */     //   #46	-> 19
/*     */     //   #47	-> 26
/*     */     //   #48	-> 40
/*     */     //   #49	-> 45
/*     */     //   #52	-> 62
/*     */     //   #54	-> 75
/*     */     //   #55	-> 94
/*     */     //   #56	-> 113
/*     */     //   #58	-> 137
/*     */     //   #60	-> 144
/*     */     //   #61	-> 163
/*     */     //   #64	-> 194
/*     */     //   #65	-> 223
/*     */     //   #66	-> 233
/*     */     //   #68	-> 254
/*     */     //   #69	-> 259
/*     */     //   #71	-> 271
/*     */     //   #74	-> 287
/*     */     //   #77	-> 289
/*     */     //   #79	-> 292
/*     */     //   #80	-> 311
/*     */     //   #81	-> 331
/*     */     //   #82	-> 369
/*     */     //   #84	-> 373
/*     */     //   #85	-> 380
/*     */     //   #87	-> 390
/*     */     //   #88	-> 395
/*     */     //   #91	-> 406
/*     */     //   #92	-> 437
/*     */     //   #94	-> 446
/*     */     //   #97	-> 451
/*     */     //   #98	-> 463
/*     */     //   #99	-> 470
/*     */     //   #100	-> 488
/*     */     //   #101	-> 537
/*     */     //   #102	-> 577
/*     */     //   #103	-> 646
/*     */     //   #104	-> 668
/*     */     //   #106	-> 693
/*     */     //   #107	-> 698
/*     */     //   #110	-> 712
/*     */     //   #111	-> 731
/*     */     //   #112	-> 737
/*     */     //   #115	-> 740
/*     */     //   #119	-> 742
/*     */     //   #122	-> 749
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
/*     */   public static class Factory
/*     */     implements InlineParserExtensionFactory
/*     */   {
/*     */     public Set<Class<?>> getAfterDependents() {
/* 129 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public CharSequence getCharacters() {
/* 135 */       return "{";
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Set<Class<?>> getBeforeDependents() {
/* 141 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public InlineParserExtension apply(LightInlineParser param1LightInlineParser) {
/* 147 */       return new MacroInlineParser(param1LightInlineParser);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean affectsGlobalScope() {
/* 152 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\xwiki\macros\internal\MacroInlineParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */