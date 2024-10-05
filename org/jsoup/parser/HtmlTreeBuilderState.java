/*      */ package org.jsoup.parser;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Iterator;
/*      */ import org.jsoup.internal.StringUtil;
/*      */ import org.jsoup.nodes.Attribute;
/*      */ import org.jsoup.nodes.Attributes;
/*      */ import org.jsoup.nodes.Document;
/*      */ import org.jsoup.nodes.DocumentType;
/*      */ import org.jsoup.nodes.Element;
/*      */ import org.jsoup.nodes.FormElement;
/*      */ import org.jsoup.nodes.Node;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ enum HtmlTreeBuilderState
/*      */ {
/*   20 */   Initial {
/*      */     final boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/*   22 */       if (isWhitespace(param1Token))
/*   23 */         return true; 
/*   24 */       if (param1Token.isComment()) {
/*   25 */         param1HtmlTreeBuilder.insertCommentNode(param1Token.asComment());
/*   26 */       } else if (param1Token.isDoctype()) {
/*      */ 
/*      */         
/*   29 */         param1Token = param1Token.asDoctype();
/*      */         
/*      */         DocumentType documentType;
/*   32 */         (documentType = new DocumentType(param1HtmlTreeBuilder.settings.normalizeTag(param1Token.getName()), param1Token.getPublicIdentifier(), param1Token.getSystemIdentifier())).setPubSysKey(param1Token.getPubSysKey());
/*   33 */         param1HtmlTreeBuilder.getDocument().appendChild((Node)documentType);
/*   34 */         param1HtmlTreeBuilder.onNodeInserted((Node)documentType);
/*   35 */         if (param1Token.isForceQuirks())
/*   36 */           param1HtmlTreeBuilder.getDocument().quirksMode(Document.QuirksMode.quirks); 
/*   37 */         param1HtmlTreeBuilder.transition(BeforeHtml);
/*      */       } else {
/*      */         
/*   40 */         param1HtmlTreeBuilder.transition(BeforeHtml);
/*   41 */         return param1HtmlTreeBuilder.process(param1Token);
/*      */       } 
/*   43 */       return true;
/*      */     }
/*      */   },
/*   46 */   BeforeHtml {
/*      */     final boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/*   48 */       if (param1Token.isDoctype()) {
/*   49 */         param1HtmlTreeBuilder.error(this);
/*   50 */         return false;
/*   51 */       }  if (param1Token.isComment())
/*   52 */       { param1HtmlTreeBuilder.insertCommentNode(param1Token.asComment()); }
/*   53 */       else if (isWhitespace(param1Token))
/*   54 */       { param1HtmlTreeBuilder.insertCharacterNode(param1Token.asCharacter()); }
/*   55 */       else if (param1Token.isStartTag() && param1Token.asStartTag().normalName().equals("html"))
/*   56 */       { param1HtmlTreeBuilder.insertElementFor(param1Token.asStartTag());
/*   57 */         param1HtmlTreeBuilder.transition(BeforeHead); }
/*   58 */       else { if (param1Token.isEndTag() && StringUtil.inSorted(param1Token.asEndTag().normalName(), Constants.BeforeHtmlToHead))
/*   59 */           return anythingElse(param1Token, param1HtmlTreeBuilder); 
/*   60 */         if (param1Token.isEndTag()) {
/*   61 */           param1HtmlTreeBuilder.error(this);
/*   62 */           return false;
/*      */         } 
/*   64 */         return anythingElse(param1Token, param1HtmlTreeBuilder); }
/*      */       
/*   66 */       return true;
/*      */     }
/*      */     
/*      */     private boolean anythingElse(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/*   70 */       param1HtmlTreeBuilder.processStartTag("html");
/*   71 */       param1HtmlTreeBuilder.transition(BeforeHead);
/*   72 */       return param1HtmlTreeBuilder.process(param1Token);
/*      */     }
/*      */   },
/*   75 */   BeforeHead {
/*      */     final boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/*   77 */       if (isWhitespace(param1Token))
/*   78 */       { param1HtmlTreeBuilder.insertCharacterNode(param1Token.asCharacter()); }
/*   79 */       else if (param1Token.isComment())
/*   80 */       { param1HtmlTreeBuilder.insertCommentNode(param1Token.asComment()); }
/*   81 */       else { Element element; if (param1Token.isDoctype()) {
/*   82 */           param1HtmlTreeBuilder.error(this);
/*   83 */           return false;
/*   84 */         }  if (param1Token.isStartTag() && param1Token.asStartTag().normalName().equals("html"))
/*   85 */           return InBody.process(param1Token, param1HtmlTreeBuilder); 
/*   86 */         if (param1Token.isStartTag() && param1Token.asStartTag().normalName().equals("head"))
/*   87 */         { element = param1HtmlTreeBuilder.insertElementFor(param1Token.asStartTag());
/*   88 */           param1HtmlTreeBuilder.setHeadElement(element);
/*   89 */           param1HtmlTreeBuilder.transition(InHead); }
/*   90 */         else { if (element.isEndTag() && StringUtil.inSorted(element.asEndTag().normalName(), Constants.BeforeHtmlToHead)) {
/*   91 */             param1HtmlTreeBuilder.processStartTag("head");
/*   92 */             return param1HtmlTreeBuilder.process((Token)element);
/*   93 */           }  if (element.isEndTag()) {
/*   94 */             param1HtmlTreeBuilder.error(this);
/*   95 */             return false;
/*      */           } 
/*   97 */           param1HtmlTreeBuilder.processStartTag("head");
/*   98 */           return param1HtmlTreeBuilder.process((Token)element); }
/*      */          }
/*  100 */        return true;
/*      */     }
/*      */   },
/*  103 */   InHead
/*      */   {
/*      */     final boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/*      */       // Byte code:
/*      */       //   0: aload_1
/*      */       //   1: invokestatic access$100 : (Lorg/jsoup/parser/Token;)Z
/*      */       //   4: ifeq -> 17
/*      */       //   7: aload_2
/*      */       //   8: aload_1
/*      */       //   9: invokevirtual asCharacter : ()Lorg/jsoup/parser/Token$Character;
/*      */       //   12: invokevirtual insertCharacterNode : (Lorg/jsoup/parser/Token$Character;)V
/*      */       //   15: iconst_1
/*      */       //   16: ireturn
/*      */       //   17: getstatic org/jsoup/parser/HtmlTreeBuilderState$25.$SwitchMap$org$jsoup$parser$Token$TokenType : [I
/*      */       //   20: aload_1
/*      */       //   21: getfield type : Lorg/jsoup/parser/Token$TokenType;
/*      */       //   24: invokevirtual ordinal : ()I
/*      */       //   27: iaload
/*      */       //   28: tableswitch default -> 469, 1 -> 60, 2 -> 71, 3 -> 78, 4 -> 339
/*      */       //   60: aload_2
/*      */       //   61: aload_1
/*      */       //   62: invokevirtual asComment : ()Lorg/jsoup/parser/Token$Comment;
/*      */       //   65: invokevirtual insertCommentNode : (Lorg/jsoup/parser/Token$Comment;)V
/*      */       //   68: goto -> 476
/*      */       //   71: aload_2
/*      */       //   72: aload_0
/*      */       //   73: invokevirtual error : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   76: iconst_0
/*      */       //   77: ireturn
/*      */       //   78: aload_1
/*      */       //   79: invokevirtual asStartTag : ()Lorg/jsoup/parser/Token$StartTag;
/*      */       //   82: dup
/*      */       //   83: astore_3
/*      */       //   84: invokevirtual normalName : ()Ljava/lang/String;
/*      */       //   87: dup
/*      */       //   88: astore #4
/*      */       //   90: ldc 'html'
/*      */       //   92: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */       //   95: ifeq -> 107
/*      */       //   98: getstatic org/jsoup/parser/HtmlTreeBuilderState$4.InBody : Lorg/jsoup/parser/HtmlTreeBuilderState;
/*      */       //   101: aload_1
/*      */       //   102: aload_2
/*      */       //   103: invokevirtual process : (Lorg/jsoup/parser/Token;Lorg/jsoup/parser/HtmlTreeBuilder;)Z
/*      */       //   106: ireturn
/*      */       //   107: aload #4
/*      */       //   109: getstatic org/jsoup/parser/HtmlTreeBuilderState$Constants.InHeadEmpty : [Ljava/lang/String;
/*      */       //   112: invokestatic inSorted : (Ljava/lang/String;[Ljava/lang/String;)Z
/*      */       //   115: ifeq -> 151
/*      */       //   118: aload_2
/*      */       //   119: aload_3
/*      */       //   120: invokevirtual insertEmptyElementFor : (Lorg/jsoup/parser/Token$StartTag;)Lorg/jsoup/nodes/Element;
/*      */       //   123: astore_3
/*      */       //   124: aload #4
/*      */       //   126: ldc 'base'
/*      */       //   128: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */       //   131: ifeq -> 148
/*      */       //   134: aload_3
/*      */       //   135: ldc 'href'
/*      */       //   137: invokevirtual hasAttr : (Ljava/lang/String;)Z
/*      */       //   140: ifeq -> 148
/*      */       //   143: aload_2
/*      */       //   144: aload_3
/*      */       //   145: invokevirtual maybeSetBaseUri : (Lorg/jsoup/nodes/Element;)V
/*      */       //   148: goto -> 476
/*      */       //   151: aload #4
/*      */       //   153: ldc 'meta'
/*      */       //   155: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */       //   158: ifeq -> 170
/*      */       //   161: aload_2
/*      */       //   162: aload_3
/*      */       //   163: invokevirtual insertEmptyElementFor : (Lorg/jsoup/parser/Token$StartTag;)Lorg/jsoup/nodes/Element;
/*      */       //   166: pop
/*      */       //   167: goto -> 476
/*      */       //   170: aload #4
/*      */       //   172: ldc 'title'
/*      */       //   174: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */       //   177: ifeq -> 188
/*      */       //   180: aload_3
/*      */       //   181: aload_2
/*      */       //   182: invokestatic access$200 : (Lorg/jsoup/parser/Token$StartTag;Lorg/jsoup/parser/HtmlTreeBuilder;)V
/*      */       //   185: goto -> 476
/*      */       //   188: aload #4
/*      */       //   190: getstatic org/jsoup/parser/HtmlTreeBuilderState$Constants.InHeadRaw : [Ljava/lang/String;
/*      */       //   193: invokestatic inSorted : (Ljava/lang/String;[Ljava/lang/String;)Z
/*      */       //   196: ifeq -> 207
/*      */       //   199: aload_3
/*      */       //   200: aload_2
/*      */       //   201: invokestatic access$300 : (Lorg/jsoup/parser/Token$StartTag;Lorg/jsoup/parser/HtmlTreeBuilder;)V
/*      */       //   204: goto -> 476
/*      */       //   207: aload #4
/*      */       //   209: ldc 'noscript'
/*      */       //   211: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */       //   214: ifeq -> 233
/*      */       //   217: aload_2
/*      */       //   218: aload_3
/*      */       //   219: invokevirtual insertElementFor : (Lorg/jsoup/parser/Token$StartTag;)Lorg/jsoup/nodes/Element;
/*      */       //   222: pop
/*      */       //   223: aload_2
/*      */       //   224: getstatic org/jsoup/parser/HtmlTreeBuilderState$4.InHeadNoscript : Lorg/jsoup/parser/HtmlTreeBuilderState;
/*      */       //   227: invokevirtual transition : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   230: goto -> 476
/*      */       //   233: aload #4
/*      */       //   235: ldc 'script'
/*      */       //   237: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */       //   240: ifeq -> 273
/*      */       //   243: aload_2
/*      */       //   244: getfield tokeniser : Lorg/jsoup/parser/Tokeniser;
/*      */       //   247: getstatic org/jsoup/parser/TokeniserState.ScriptData : Lorg/jsoup/parser/TokeniserState;
/*      */       //   250: invokevirtual transition : (Lorg/jsoup/parser/TokeniserState;)V
/*      */       //   253: aload_2
/*      */       //   254: invokevirtual markInsertionMode : ()V
/*      */       //   257: aload_2
/*      */       //   258: getstatic org/jsoup/parser/HtmlTreeBuilderState$4.Text : Lorg/jsoup/parser/HtmlTreeBuilderState;
/*      */       //   261: invokevirtual transition : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   264: aload_2
/*      */       //   265: aload_3
/*      */       //   266: invokevirtual insertElementFor : (Lorg/jsoup/parser/Token$StartTag;)Lorg/jsoup/nodes/Element;
/*      */       //   269: pop
/*      */       //   270: goto -> 476
/*      */       //   273: aload #4
/*      */       //   275: ldc 'head'
/*      */       //   277: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */       //   280: ifeq -> 290
/*      */       //   283: aload_2
/*      */       //   284: aload_0
/*      */       //   285: invokevirtual error : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   288: iconst_0
/*      */       //   289: ireturn
/*      */       //   290: aload #4
/*      */       //   292: ldc 'template'
/*      */       //   294: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */       //   297: ifeq -> 332
/*      */       //   300: aload_2
/*      */       //   301: aload_3
/*      */       //   302: invokevirtual insertElementFor : (Lorg/jsoup/parser/Token$StartTag;)Lorg/jsoup/nodes/Element;
/*      */       //   305: pop
/*      */       //   306: aload_2
/*      */       //   307: invokevirtual insertMarkerToFormattingElements : ()V
/*      */       //   310: aload_2
/*      */       //   311: iconst_0
/*      */       //   312: invokevirtual framesetOk : (Z)V
/*      */       //   315: aload_2
/*      */       //   316: getstatic org/jsoup/parser/HtmlTreeBuilderState$4.InTemplate : Lorg/jsoup/parser/HtmlTreeBuilderState;
/*      */       //   319: invokevirtual transition : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   322: aload_2
/*      */       //   323: getstatic org/jsoup/parser/HtmlTreeBuilderState$4.InTemplate : Lorg/jsoup/parser/HtmlTreeBuilderState;
/*      */       //   326: invokevirtual pushTemplateMode : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   329: goto -> 476
/*      */       //   332: aload_0
/*      */       //   333: aload_1
/*      */       //   334: aload_2
/*      */       //   335: invokespecial anythingElse : (Lorg/jsoup/parser/Token;Lorg/jsoup/parser/TreeBuilder;)Z
/*      */       //   338: ireturn
/*      */       //   339: aload_1
/*      */       //   340: invokevirtual asEndTag : ()Lorg/jsoup/parser/Token$EndTag;
/*      */       //   343: dup
/*      */       //   344: astore_3
/*      */       //   345: invokevirtual normalName : ()Ljava/lang/String;
/*      */       //   348: dup
/*      */       //   349: astore #4
/*      */       //   351: ldc 'head'
/*      */       //   353: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */       //   356: ifeq -> 374
/*      */       //   359: aload_2
/*      */       //   360: invokevirtual pop : ()Lorg/jsoup/nodes/Element;
/*      */       //   363: pop
/*      */       //   364: aload_2
/*      */       //   365: getstatic org/jsoup/parser/HtmlTreeBuilderState$4.AfterHead : Lorg/jsoup/parser/HtmlTreeBuilderState;
/*      */       //   368: invokevirtual transition : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   371: goto -> 476
/*      */       //   374: aload #4
/*      */       //   376: getstatic org/jsoup/parser/HtmlTreeBuilderState$Constants.InHeadEnd : [Ljava/lang/String;
/*      */       //   379: invokestatic inSorted : (Ljava/lang/String;[Ljava/lang/String;)Z
/*      */       //   382: ifeq -> 392
/*      */       //   385: aload_0
/*      */       //   386: aload_1
/*      */       //   387: aload_2
/*      */       //   388: invokespecial anythingElse : (Lorg/jsoup/parser/Token;Lorg/jsoup/parser/TreeBuilder;)Z
/*      */       //   391: ireturn
/*      */       //   392: aload #4
/*      */       //   394: ldc 'template'
/*      */       //   396: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */       //   399: ifeq -> 462
/*      */       //   402: aload_2
/*      */       //   403: aload #4
/*      */       //   405: invokevirtual onStack : (Ljava/lang/String;)Z
/*      */       //   408: ifne -> 419
/*      */       //   411: aload_2
/*      */       //   412: aload_0
/*      */       //   413: invokevirtual error : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   416: goto -> 476
/*      */       //   419: aload_2
/*      */       //   420: iconst_1
/*      */       //   421: invokevirtual generateImpliedEndTags : (Z)V
/*      */       //   424: aload_2
/*      */       //   425: aload #4
/*      */       //   427: invokevirtual currentElementIs : (Ljava/lang/String;)Z
/*      */       //   430: ifne -> 438
/*      */       //   433: aload_2
/*      */       //   434: aload_0
/*      */       //   435: invokevirtual error : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   438: aload_2
/*      */       //   439: aload #4
/*      */       //   441: invokevirtual popStackToClose : (Ljava/lang/String;)Lorg/jsoup/nodes/Element;
/*      */       //   444: pop
/*      */       //   445: aload_2
/*      */       //   446: invokevirtual clearFormattingElementsToLastMarker : ()V
/*      */       //   449: aload_2
/*      */       //   450: invokevirtual popTemplateMode : ()Lorg/jsoup/parser/HtmlTreeBuilderState;
/*      */       //   453: pop
/*      */       //   454: aload_2
/*      */       //   455: invokevirtual resetInsertionMode : ()Z
/*      */       //   458: pop
/*      */       //   459: goto -> 476
/*      */       //   462: aload_2
/*      */       //   463: aload_0
/*      */       //   464: invokevirtual error : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   467: iconst_0
/*      */       //   468: ireturn
/*      */       //   469: aload_0
/*      */       //   470: aload_1
/*      */       //   471: aload_2
/*      */       //   472: invokespecial anythingElse : (Lorg/jsoup/parser/Token;Lorg/jsoup/parser/TreeBuilder;)Z
/*      */       //   475: ireturn
/*      */       //   476: iconst_1
/*      */       //   477: ireturn
/*      */       // Line number table:
/*      */       //   Java source line number -> byte code offset
/*      */       //   #105	-> 0
/*      */       //   #106	-> 7
/*      */       //   #107	-> 15
/*      */       //   #109	-> 17
/*      */       //   #111	-> 60
/*      */       //   #112	-> 68
/*      */       //   #114	-> 71
/*      */       //   #115	-> 76
/*      */       //   #117	-> 78
/*      */       //   #118	-> 83
/*      */       //   #119	-> 88
/*      */       //   #120	-> 98
/*      */       //   #121	-> 107
/*      */       //   #122	-> 118
/*      */       //   #124	-> 124
/*      */       //   #125	-> 143
/*      */       //   #126	-> 148
/*      */       //   #127	-> 161
/*      */       //   #129	-> 170
/*      */       //   #130	-> 180
/*      */       //   #131	-> 188
/*      */       //   #132	-> 199
/*      */       //   #133	-> 207
/*      */       //   #135	-> 217
/*      */       //   #136	-> 223
/*      */       //   #137	-> 233
/*      */       //   #139	-> 243
/*      */       //   #140	-> 253
/*      */       //   #141	-> 257
/*      */       //   #142	-> 264
/*      */       //   #143	-> 273
/*      */       //   #144	-> 283
/*      */       //   #145	-> 288
/*      */       //   #146	-> 290
/*      */       //   #147	-> 300
/*      */       //   #148	-> 306
/*      */       //   #149	-> 310
/*      */       //   #150	-> 315
/*      */       //   #151	-> 322
/*      */       //   #153	-> 332
/*      */       //   #157	-> 339
/*      */       //   #158	-> 344
/*      */       //   #159	-> 349
/*      */       //   #160	-> 359
/*      */       //   #161	-> 364
/*      */       //   #162	-> 374
/*      */       //   #163	-> 385
/*      */       //   #164	-> 392
/*      */       //   #165	-> 402
/*      */       //   #166	-> 411
/*      */       //   #168	-> 419
/*      */       //   #169	-> 424
/*      */       //   #170	-> 438
/*      */       //   #171	-> 445
/*      */       //   #172	-> 449
/*      */       //   #173	-> 454
/*      */       //   #177	-> 462
/*      */       //   #178	-> 467
/*      */       //   #182	-> 469
/*      */       //   #184	-> 476
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private boolean anythingElse(Token param1Token, TreeBuilder param1TreeBuilder) {
/*  188 */       param1TreeBuilder.processEndTag("head");
/*  189 */       return param1TreeBuilder.process(param1Token);
/*      */     }
/*      */   },
/*  192 */   InHeadNoscript {
/*      */     final boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/*  194 */       if (param1Token.isDoctype())
/*  195 */       { param1HtmlTreeBuilder.error(this); }
/*  196 */       else { if (param1Token.isStartTag() && param1Token.asStartTag().normalName().equals("html"))
/*  197 */           return param1HtmlTreeBuilder.process(param1Token, InBody); 
/*  198 */         if (param1Token.isEndTag() && param1Token.asEndTag().normalName().equals("noscript"))
/*  199 */         { param1HtmlTreeBuilder.pop();
/*  200 */           param1HtmlTreeBuilder.transition(InHead); }
/*  201 */         else { if (isWhitespace(param1Token) || param1Token.isComment() || (param1Token.isStartTag() && StringUtil.inSorted(param1Token.asStartTag().normalName(), Constants.InHeadNoScriptHead)))
/*      */           {
/*  203 */             return param1HtmlTreeBuilder.process(param1Token, InHead); } 
/*  204 */           if (param1Token.isEndTag() && param1Token.asEndTag().normalName().equals("br"))
/*  205 */             return anythingElse(param1Token, param1HtmlTreeBuilder); 
/*  206 */           if ((param1Token.isStartTag() && StringUtil.inSorted(param1Token.asStartTag().normalName(), Constants.InHeadNoscriptIgnore)) || param1Token.isEndTag()) {
/*  207 */             param1HtmlTreeBuilder.error(this);
/*  208 */             return false;
/*      */           } 
/*  210 */           return anythingElse(param1Token, param1HtmlTreeBuilder); }
/*      */          }
/*  212 */        return true;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private boolean anythingElse(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/*  219 */       param1HtmlTreeBuilder.error(this);
/*  220 */       param1HtmlTreeBuilder.insertCharacterNode((new Token.Character()).data(param1Token.toString()));
/*  221 */       return true;
/*      */     }
/*      */   },
/*  224 */   AfterHead {
/*      */     final boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/*  226 */       if (isWhitespace(param1Token)) {
/*  227 */         param1HtmlTreeBuilder.insertCharacterNode(param1Token.asCharacter());
/*  228 */       } else if (param1Token.isComment()) {
/*  229 */         param1HtmlTreeBuilder.insertCommentNode(param1Token.asComment());
/*  230 */       } else if (param1Token.isDoctype()) {
/*  231 */         param1HtmlTreeBuilder.error(this);
/*  232 */       } else if (param1Token.isStartTag()) {
/*      */         Token.StartTag startTag;
/*      */         String str;
/*  235 */         if ((str = (startTag = param1Token.asStartTag()).normalName()).equals("html"))
/*  236 */           return param1HtmlTreeBuilder.process(param1Token, InBody); 
/*  237 */         if (str.equals("body"))
/*  238 */         { param1HtmlTreeBuilder.insertElementFor(startTag);
/*  239 */           param1HtmlTreeBuilder.framesetOk(false);
/*  240 */           param1HtmlTreeBuilder.transition(InBody); }
/*  241 */         else if (str.equals("frameset"))
/*  242 */         { param1HtmlTreeBuilder.insertElementFor(startTag);
/*  243 */           param1HtmlTreeBuilder.transition(InFrameset); }
/*  244 */         else if (StringUtil.inSorted(str, Constants.InBodyStartToHead))
/*  245 */         { param1HtmlTreeBuilder.error(this);
/*  246 */           Element element = param1HtmlTreeBuilder.getHeadElement();
/*  247 */           param1HtmlTreeBuilder.push(element);
/*  248 */           param1HtmlTreeBuilder.process(param1Token, InHead);
/*  249 */           param1HtmlTreeBuilder.removeFromStack(element); }
/*  250 */         else { if (str.equals("head")) {
/*  251 */             param1HtmlTreeBuilder.error(this);
/*  252 */             return false;
/*      */           } 
/*  254 */           anythingElse(param1Token, param1HtmlTreeBuilder); }
/*      */       
/*  256 */       } else if (param1Token.isEndTag()) {
/*      */         String str;
/*  258 */         if (StringUtil.inSorted(str = param1Token.asEndTag().normalName(), Constants.AfterHeadBody)) {
/*  259 */           anythingElse(param1Token, param1HtmlTreeBuilder);
/*  260 */         } else if (str.equals("template")) {
/*  261 */           param1HtmlTreeBuilder.process(param1Token, InHead);
/*      */         } else {
/*      */           
/*  264 */           param1HtmlTreeBuilder.error(this);
/*  265 */           return false;
/*      */         } 
/*      */       } else {
/*  268 */         anythingElse(param1Token, param1HtmlTreeBuilder);
/*      */       } 
/*  270 */       return true;
/*      */     }
/*      */     
/*      */     private boolean anythingElse(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/*  274 */       param1HtmlTreeBuilder.processStartTag("body");
/*  275 */       param1HtmlTreeBuilder.framesetOk(true);
/*  276 */       return param1HtmlTreeBuilder.process(param1Token);
/*      */     }
/*      */   },
/*  279 */   InBody
/*      */   {
/*      */     private static final int MaxStackScan = 24;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     final boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/*      */       // Byte code:
/*      */       //   0: getstatic org/jsoup/parser/HtmlTreeBuilderState$25.$SwitchMap$org$jsoup$parser$Token$TokenType : [I
/*      */       //   3: aload_1
/*      */       //   4: getfield type : Lorg/jsoup/parser/Token$TokenType;
/*      */       //   7: invokevirtual ordinal : ()I
/*      */       //   10: iaload
/*      */       //   11: tableswitch default -> 179, 1 -> 116, 2 -> 127, 3 -> 134, 4 -> 141, 5 -> 48, 6 -> 148
/*      */       //   48: aload_1
/*      */       //   49: invokevirtual asCharacter : ()Lorg/jsoup/parser/Token$Character;
/*      */       //   52: dup
/*      */       //   53: astore_1
/*      */       //   54: invokevirtual getData : ()Ljava/lang/String;
/*      */       //   57: invokestatic access$400 : ()Ljava/lang/String;
/*      */       //   60: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */       //   63: ifeq -> 73
/*      */       //   66: aload_2
/*      */       //   67: aload_0
/*      */       //   68: invokevirtual error : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   71: iconst_0
/*      */       //   72: ireturn
/*      */       //   73: aload_2
/*      */       //   74: invokevirtual framesetOk : ()Z
/*      */       //   77: ifeq -> 99
/*      */       //   80: aload_1
/*      */       //   81: invokestatic access$100 : (Lorg/jsoup/parser/Token;)Z
/*      */       //   84: ifeq -> 99
/*      */       //   87: aload_2
/*      */       //   88: invokevirtual reconstructFormattingElements : ()V
/*      */       //   91: aload_2
/*      */       //   92: aload_1
/*      */       //   93: invokevirtual insertCharacterNode : (Lorg/jsoup/parser/Token$Character;)V
/*      */       //   96: goto -> 179
/*      */       //   99: aload_2
/*      */       //   100: invokevirtual reconstructFormattingElements : ()V
/*      */       //   103: aload_2
/*      */       //   104: aload_1
/*      */       //   105: invokevirtual insertCharacterNode : (Lorg/jsoup/parser/Token$Character;)V
/*      */       //   108: aload_2
/*      */       //   109: iconst_0
/*      */       //   110: invokevirtual framesetOk : (Z)V
/*      */       //   113: goto -> 179
/*      */       //   116: aload_2
/*      */       //   117: aload_1
/*      */       //   118: invokevirtual asComment : ()Lorg/jsoup/parser/Token$Comment;
/*      */       //   121: invokevirtual insertCommentNode : (Lorg/jsoup/parser/Token$Comment;)V
/*      */       //   124: goto -> 179
/*      */       //   127: aload_2
/*      */       //   128: aload_0
/*      */       //   129: invokevirtual error : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   132: iconst_0
/*      */       //   133: ireturn
/*      */       //   134: aload_0
/*      */       //   135: aload_1
/*      */       //   136: aload_2
/*      */       //   137: invokespecial inBodyStartTag : (Lorg/jsoup/parser/Token;Lorg/jsoup/parser/HtmlTreeBuilder;)Z
/*      */       //   140: ireturn
/*      */       //   141: aload_0
/*      */       //   142: aload_1
/*      */       //   143: aload_2
/*      */       //   144: invokespecial inBodyEndTag : (Lorg/jsoup/parser/Token;Lorg/jsoup/parser/HtmlTreeBuilder;)Z
/*      */       //   147: ireturn
/*      */       //   148: aload_2
/*      */       //   149: invokevirtual templateModeSize : ()I
/*      */       //   152: ifle -> 164
/*      */       //   155: aload_2
/*      */       //   156: aload_1
/*      */       //   157: getstatic org/jsoup/parser/HtmlTreeBuilderState$7.InTemplate : Lorg/jsoup/parser/HtmlTreeBuilderState;
/*      */       //   160: invokevirtual process : (Lorg/jsoup/parser/Token;Lorg/jsoup/parser/HtmlTreeBuilderState;)Z
/*      */       //   163: ireturn
/*      */       //   164: aload_2
/*      */       //   165: getstatic org/jsoup/parser/HtmlTreeBuilderState$Constants.InBodyEndOtherErrors : [Ljava/lang/String;
/*      */       //   168: invokevirtual onStackNot : ([Ljava/lang/String;)Z
/*      */       //   171: ifeq -> 179
/*      */       //   174: aload_2
/*      */       //   175: aload_0
/*      */       //   176: invokevirtual error : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   179: iconst_1
/*      */       //   180: ireturn
/*      */       // Line number table:
/*      */       //   Java source line number -> byte code offset
/*      */       //   #281	-> 0
/*      */       //   #283	-> 48
/*      */       //   #284	-> 53
/*      */       //   #286	-> 66
/*      */       //   #287	-> 71
/*      */       //   #288	-> 73
/*      */       //   #289	-> 87
/*      */       //   #290	-> 91
/*      */       //   #292	-> 99
/*      */       //   #293	-> 103
/*      */       //   #294	-> 108
/*      */       //   #296	-> 113
/*      */       //   #299	-> 116
/*      */       //   #300	-> 124
/*      */       //   #303	-> 127
/*      */       //   #304	-> 132
/*      */       //   #307	-> 134
/*      */       //   #309	-> 141
/*      */       //   #311	-> 148
/*      */       //   #312	-> 155
/*      */       //   #313	-> 164
/*      */       //   #314	-> 174
/*      */       //   #318	-> 179
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private boolean inBodyStartTag(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/*      */       ArrayList<Element> arrayList2;
/*      */       Attributes attributes;
/*      */       ArrayList<Element> arrayList1;
/*      */       Iterator<Attribute> iterator;
/*      */       HtmlTreeBuilderState htmlTreeBuilderState;
/*      */       Element element2;
/*      */       int i;
/*      */       Element element1;
/*      */       String str3;
/*      */       Element element4;
/*      */       int j;
/*      */       Element element3;
/*      */       FormElement formElement;
/*      */       String str2;
/*      */       byte b;
/*      */       Token.StartTag startTag;
/*      */       String str1;
/*  327 */       switch (str1 = (startTag = param1Token.asStartTag()).normalName())
/*      */       
/*      */       { case "a":
/*  330 */           param1HtmlTreeBuilder.error(this);
/*  331 */           param1HtmlTreeBuilder.processEndTag("a");
/*      */ 
/*      */ 
/*      */           
/*  335 */           if (param1HtmlTreeBuilder.getActiveFormattingElement("a") != null && (element4 = param1HtmlTreeBuilder.getFromStack("a")) != null) {
/*  336 */             param1HtmlTreeBuilder.removeFromActiveFormattingElements(element4);
/*  337 */             param1HtmlTreeBuilder.removeFromStack(element4);
/*      */           } 
/*      */           
/*  340 */           param1HtmlTreeBuilder.reconstructFormattingElements();
/*  341 */           element2 = param1HtmlTreeBuilder.insertElementFor(startTag);
/*  342 */           param1HtmlTreeBuilder.pushActiveFormattingElements(element2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  696 */           return true;case "span": param1HtmlTreeBuilder.reconstructFormattingElements(); param1HtmlTreeBuilder.insertElementFor(startTag); return true;case "li": param1HtmlTreeBuilder.framesetOk(false); for (j = (arrayList2 = param1HtmlTreeBuilder.getStack()).size() - 1; j > 0; ) { if ((element2 = arrayList2.get(j)).nameIs("li")) { param1HtmlTreeBuilder.processEndTag("li"); break; }  if (!HtmlTreeBuilder.isSpecial(element2) || StringUtil.inSorted(element2.normalName(), Constants.InBodyStartLiBreakers)) j--;  }  if (param1HtmlTreeBuilder.inButtonScope("p")) param1HtmlTreeBuilder.processEndTag("p");  param1HtmlTreeBuilder.insertElementFor(startTag); return true;case "html": param1HtmlTreeBuilder.error(this); if (param1HtmlTreeBuilder.onStack("template")) return false;  if ((arrayList2 = param1HtmlTreeBuilder.getStack()).size() > 0) { Element element = param1HtmlTreeBuilder.getStack().get(0); if (startTag.hasAttributes()) for (Attribute attribute : startTag.attributes) { if (!element.hasAttr(attribute.getKey())) element.attributes().put(attribute);  }   }  return true;case "body": param1HtmlTreeBuilder.error(this); if ((arrayList2 = param1HtmlTreeBuilder.getStack()).size() == 1 || (arrayList2.size() > 2 && !((Element)arrayList2.get(1)).nameIs("body")) || param1HtmlTreeBuilder.onStack("template")) return false;  param1HtmlTreeBuilder.framesetOk(false); if (attribute.hasAttributes() && (element3 = param1HtmlTreeBuilder.getFromStack("body")) != null) for (Attribute attribute : ((Token.StartTag)attribute).attributes) { if (!element3.hasAttr(attribute.getKey())) element3.attributes().put(attribute);  }   return true;case "frameset": param1HtmlTreeBuilder.error(this); if ((arrayList2 = param1HtmlTreeBuilder.getStack()).size() == 1 || (arrayList2.size() > 2 && !((Element)arrayList2.get(1)).nameIs("body"))) return false;  if (!param1HtmlTreeBuilder.framesetOk()) return false;  if ((element3 = arrayList2.get(1)).parent() != null) element3.remove();  while (arrayList2.size() > 1) arrayList2.remove(arrayList2.size() - 1);  param1HtmlTreeBuilder.insertElementFor((Token.StartTag)attribute); param1HtmlTreeBuilder.transition(InFrameset); return true;case "form": if (param1HtmlTreeBuilder.getFormElement() != null && !param1HtmlTreeBuilder.onStack("template")) { param1HtmlTreeBuilder.error(this); return false; }  if (param1HtmlTreeBuilder.inButtonScope("p")) param1HtmlTreeBuilder.closeElement("p");  param1HtmlTreeBuilder.insertFormElement((Token.StartTag)attribute, true, true); return true;case "plaintext": if (param1HtmlTreeBuilder.inButtonScope("p")) param1HtmlTreeBuilder.processEndTag("p");  param1HtmlTreeBuilder.insertElementFor((Token.StartTag)attribute); param1HtmlTreeBuilder.tokeniser.transition(TokeniserState.PLAINTEXT); return true;case "button": if (param1HtmlTreeBuilder.inButtonScope("button")) { param1HtmlTreeBuilder.error(this); param1HtmlTreeBuilder.processEndTag("button"); param1HtmlTreeBuilder.process((Token)attribute); } else { param1HtmlTreeBuilder.reconstructFormattingElements(); param1HtmlTreeBuilder.insertElementFor((Token.StartTag)attribute); param1HtmlTreeBuilder.framesetOk(false); }  return true;case "nobr": param1HtmlTreeBuilder.reconstructFormattingElements(); if (param1HtmlTreeBuilder.inScope("nobr")) { param1HtmlTreeBuilder.error(this); param1HtmlTreeBuilder.processEndTag("nobr"); param1HtmlTreeBuilder.reconstructFormattingElements(); }  element2 = param1HtmlTreeBuilder.insertElementFor((Token.StartTag)attribute); param1HtmlTreeBuilder.pushActiveFormattingElements(element2); return true;case "table": if (param1HtmlTreeBuilder.getDocument().quirksMode() != Document.QuirksMode.quirks && param1HtmlTreeBuilder.inButtonScope("p")) param1HtmlTreeBuilder.processEndTag("p");  param1HtmlTreeBuilder.insertElementFor((Token.StartTag)attribute); param1HtmlTreeBuilder.framesetOk(false); param1HtmlTreeBuilder.transition(InTable); return true;case "input": param1HtmlTreeBuilder.reconstructFormattingElements(); if (!(element2 = param1HtmlTreeBuilder.insertEmptyElementFor((Token.StartTag)attribute)).attr("type").equalsIgnoreCase("hidden")) param1HtmlTreeBuilder.framesetOk(false);  return true;case "hr": if (param1HtmlTreeBuilder.inButtonScope("p")) param1HtmlTreeBuilder.processEndTag("p");  param1HtmlTreeBuilder.insertEmptyElementFor((Token.StartTag)attribute); param1HtmlTreeBuilder.framesetOk(false); return true;case "image": if (param1HtmlTreeBuilder.getFromStack("svg") == null) return param1HtmlTreeBuilder.process(attribute.name("img"));  param1HtmlTreeBuilder.insertElementFor((Token.StartTag)attribute); return true;case "isindex": param1HtmlTreeBuilder.error(this); if (param1HtmlTreeBuilder.getFormElement() != null) return false;  param1HtmlTreeBuilder.processStartTag("form"); if (attribute.hasAttribute("action") && (formElement = param1HtmlTreeBuilder.getFormElement()) != null && attribute.hasAttribute("action")) { String str = ((Token.StartTag)attribute).attributes.get("action"); formElement.attributes().put("action", str); }  param1HtmlTreeBuilder.processStartTag("hr"); param1HtmlTreeBuilder.processStartTag("label"); str2 = attribute.hasAttribute("prompt") ? ((Token.StartTag)attribute).attributes.get("prompt") : "This is a searchable index. Enter search keywords: "; param1HtmlTreeBuilder.process((new Token.Character()).data(str2)); attributes = new Attributes(); if (attribute.hasAttributes()) for (iterator = ((Token.StartTag)attribute).attributes.iterator(); iterator.hasNext();) { if (!StringUtil.inSorted((attribute1 = iterator.next()).getKey(), Constants.InBodyStartInputAttribs)) attributes.put(attribute1);  }   attributes.put("name", "isindex"); param1HtmlTreeBuilder.processStartTag("input", attributes); param1HtmlTreeBuilder.processEndTag("label"); param1HtmlTreeBuilder.processStartTag("hr"); param1HtmlTreeBuilder.processEndTag("form"); return true;case "textarea": param1HtmlTreeBuilder.insertElementFor((Token.StartTag)iterator); if (!iterator.isSelfClosing()) { param1HtmlTreeBuilder.tokeniser.transition(TokeniserState.Rcdata); param1HtmlTreeBuilder.markInsertionMode(); param1HtmlTreeBuilder.framesetOk(false); param1HtmlTreeBuilder.transition(Text); }  return true;case "xmp": if (param1HtmlTreeBuilder.inButtonScope("p")) param1HtmlTreeBuilder.processEndTag("p");  param1HtmlTreeBuilder.reconstructFormattingElements(); param1HtmlTreeBuilder.framesetOk(false); handleRawtext((Token.StartTag)iterator, param1HtmlTreeBuilder); return true;case "iframe": param1HtmlTreeBuilder.framesetOk(false); handleRawtext((Token.StartTag)iterator, param1HtmlTreeBuilder); return true;case "noembed": handleRawtext((Token.StartTag)iterator, param1HtmlTreeBuilder); return true;case "select": param1HtmlTreeBuilder.reconstructFormattingElements(); param1HtmlTreeBuilder.insertElementFor((Token.StartTag)iterator); param1HtmlTreeBuilder.framesetOk(false); if (!((Token.StartTag)iterator).selfClosing) if ((htmlTreeBuilderState = param1HtmlTreeBuilder.state()).equals(InTable) || htmlTreeBuilderState.equals(InCaption) || htmlTreeBuilderState.equals(InTableBody) || htmlTreeBuilderState.equals(InRow) || htmlTreeBuilderState.equals(InCell)) { param1HtmlTreeBuilder.transition(InSelectInTable); } else { param1HtmlTreeBuilder.transition(InSelect); }   return true;case "math": param1HtmlTreeBuilder.reconstructFormattingElements(); param1HtmlTreeBuilder.insertForeignElementFor((Token.StartTag)htmlTreeBuilderState, "http://www.w3.org/1998/Math/MathML"); return true;case "svg": param1HtmlTreeBuilder.reconstructFormattingElements(); param1HtmlTreeBuilder.insertForeignElementFor((Token.StartTag)htmlTreeBuilderState, "http://www.w3.org/2000/svg"); return true;case "h1": case "h2": case "h3": case "h4": case "h5": case "h6": if (param1HtmlTreeBuilder.inButtonScope("p")) param1HtmlTreeBuilder.processEndTag("p");  if (StringUtil.inSorted(param1HtmlTreeBuilder.currentElement().normalName(), Constants.Headings)) { param1HtmlTreeBuilder.error(this); param1HtmlTreeBuilder.pop(); }  param1HtmlTreeBuilder.insertElementFor((Token.StartTag)htmlTreeBuilderState); return true;case "pre": case "listing": if (param1HtmlTreeBuilder.inButtonScope("p")) param1HtmlTreeBuilder.processEndTag("p");  param1HtmlTreeBuilder.insertElementFor((Token.StartTag)htmlTreeBuilderState); param1HtmlTreeBuilder.reader.matchConsume("\n"); param1HtmlTreeBuilder.framesetOk(false); return true;case "dd": case "dt": param1HtmlTreeBuilder.framesetOk(false); b = ((i = (arrayList1 = param1HtmlTreeBuilder.getStack()).size() - 1) >= 24) ? (i - 24) : 0; for (null = i; null >= b; ) { Element element; if (StringUtil.inSorted((element = arrayList1.get(null)).normalName(), Constants.DdDt)) { param1HtmlTreeBuilder.processEndTag(element.normalName()); break; }  if (!HtmlTreeBuilder.isSpecial(element) || StringUtil.inSorted(element.normalName(), Constants.InBodyStartLiBreakers)) null--;  }  if (param1HtmlTreeBuilder.inButtonScope("p")) param1HtmlTreeBuilder.processEndTag("p");  param1HtmlTreeBuilder.insertElementFor((Token.StartTag)htmlTreeBuilderState); return true;case "optgroup": case "option": if (param1HtmlTreeBuilder.currentElementIs("option")) param1HtmlTreeBuilder.processEndTag("option");  param1HtmlTreeBuilder.reconstructFormattingElements(); param1HtmlTreeBuilder.insertElementFor((Token.StartTag)htmlTreeBuilderState); return true;case "rb": case "rtc": if (param1HtmlTreeBuilder.inScope("ruby")) { param1HtmlTreeBuilder.generateImpliedEndTags(); if (!param1HtmlTreeBuilder.currentElementIs("ruby")) param1HtmlTreeBuilder.error(this);  }  param1HtmlTreeBuilder.insertElementFor((Token.StartTag)htmlTreeBuilderState); return true;case "rp": case "rt": if (param1HtmlTreeBuilder.inScope("ruby")) { param1HtmlTreeBuilder.generateImpliedEndTags("rtc"); if (!param1HtmlTreeBuilder.currentElementIs("rtc") && !param1HtmlTreeBuilder.currentElementIs("ruby")) param1HtmlTreeBuilder.error(this);  }  param1HtmlTreeBuilder.insertElementFor((Token.StartTag)htmlTreeBuilderState); return true;case "area": case "br": case "embed": case "img": case "keygen": case "wbr": param1HtmlTreeBuilder.reconstructFormattingElements(); param1HtmlTreeBuilder.insertEmptyElementFor((Token.StartTag)htmlTreeBuilderState); param1HtmlTreeBuilder.framesetOk(false); return true;case "b": case "big": case "code": case "em": case "font": case "i": case "s": case "small": case "strike": case "strong": case "tt": case "u": param1HtmlTreeBuilder.reconstructFormattingElements(); element1 = param1HtmlTreeBuilder.insertElementFor((Token.StartTag)htmlTreeBuilderState); param1HtmlTreeBuilder.pushActiveFormattingElements(element1); return true; }  if (!Tag.isKnownTag((String)element1)) { param1HtmlTreeBuilder.insertElementFor((Token.StartTag)htmlTreeBuilderState); } else if (StringUtil.inSorted((String)element1, Constants.InBodyStartPClosers)) { if (param1HtmlTreeBuilder.inButtonScope("p")) param1HtmlTreeBuilder.processEndTag("p");  param1HtmlTreeBuilder.insertElementFor((Token.StartTag)htmlTreeBuilderState); } else { if (StringUtil.inSorted((String)element1, Constants.InBodyStartToHead)) return param1HtmlTreeBuilder.process((Token)arrayList1, InHead);  if (StringUtil.inSorted((String)element1, Constants.InBodyStartApplets)) { param1HtmlTreeBuilder.reconstructFormattingElements(); param1HtmlTreeBuilder.insertElementFor((Token.StartTag)htmlTreeBuilderState); param1HtmlTreeBuilder.insertMarkerToFormattingElements(); param1HtmlTreeBuilder.framesetOk(false); } else if (StringUtil.inSorted((String)element1, Constants.InBodyStartMedia)) { param1HtmlTreeBuilder.insertEmptyElementFor((Token.StartTag)htmlTreeBuilderState); } else { if (StringUtil.inSorted((String)element1, Constants.InBodyStartDrop)) { param1HtmlTreeBuilder.error(this); return false; }  param1HtmlTreeBuilder.reconstructFormattingElements(); param1HtmlTreeBuilder.insertElementFor((Token.StartTag)htmlTreeBuilderState); }  }  return true;
/*      */     }
/*      */ 
/*      */     
/*      */     private boolean inBodyEndTag(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/*      */       FormElement formElement;
/*      */       Token.EndTag endTag;
/*      */       String str;
/*  704 */       switch (str = (endTag = param1Token.asEndTag()).normalName())
/*      */       { case "template":
/*  706 */           param1HtmlTreeBuilder.process(param1Token, InHead);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  843 */           return true;case "sarcasm": case "span": return anyOtherEndTag(param1Token, param1HtmlTreeBuilder);case "li": if (!param1HtmlTreeBuilder.inListItemScope(str)) { param1HtmlTreeBuilder.error(this); return false; }  param1HtmlTreeBuilder.generateImpliedEndTags(str); if (!param1HtmlTreeBuilder.currentElementIs(str)) param1HtmlTreeBuilder.error(this);  param1HtmlTreeBuilder.popStackToClose(str); return true;case "body": if (!param1HtmlTreeBuilder.inScope("body")) { param1HtmlTreeBuilder.error(this); return false; }  if (param1HtmlTreeBuilder.onStackNot(Constants.InBodyEndOtherErrors)) param1HtmlTreeBuilder.error(this);  param1HtmlTreeBuilder.onNodeClosed((Node)param1HtmlTreeBuilder.getFromStack("body")); param1HtmlTreeBuilder.transition(AfterBody); return true;case "html": if (!param1HtmlTreeBuilder.onStack("body")) { param1HtmlTreeBuilder.error(this); return false; }  if (param1HtmlTreeBuilder.onStackNot(Constants.InBodyEndOtherErrors)) param1HtmlTreeBuilder.error(this);  param1HtmlTreeBuilder.transition(AfterBody); return param1HtmlTreeBuilder.process(param1Token);case "form": if (!param1HtmlTreeBuilder.onStack("template")) { formElement = param1HtmlTreeBuilder.getFormElement(); param1HtmlTreeBuilder.setFormElement((FormElement)null); if (formElement == null || !param1HtmlTreeBuilder.inScope(str)) { param1HtmlTreeBuilder.error(this); return false; }  param1HtmlTreeBuilder.generateImpliedEndTags(); if (!param1HtmlTreeBuilder.currentElementIs(str)) param1HtmlTreeBuilder.error(this);  param1HtmlTreeBuilder.removeFromStack((Element)formElement); } else { if (!param1HtmlTreeBuilder.inScope(str)) { param1HtmlTreeBuilder.error(this); return false; }  param1HtmlTreeBuilder.generateImpliedEndTags(); if (!param1HtmlTreeBuilder.currentElementIs(str)) param1HtmlTreeBuilder.error(this);  param1HtmlTreeBuilder.popStackToClose(str); }  return true;case "p": if (!param1HtmlTreeBuilder.inButtonScope(str)) { param1HtmlTreeBuilder.error(this); param1HtmlTreeBuilder.processStartTag(str); return param1HtmlTreeBuilder.process(endTag); }  param1HtmlTreeBuilder.generateImpliedEndTags(str); if (!param1HtmlTreeBuilder.currentElementIs(str)) param1HtmlTreeBuilder.error(this);  param1HtmlTreeBuilder.popStackToClose(str); return true;case "dd": case "dt": if (!param1HtmlTreeBuilder.inScope(str)) { param1HtmlTreeBuilder.error(this); return false; }  param1HtmlTreeBuilder.generateImpliedEndTags(str); if (!param1HtmlTreeBuilder.currentElementIs(str)) param1HtmlTreeBuilder.error(this);  param1HtmlTreeBuilder.popStackToClose(str); return true;case "h1": case "h2": case "h3": case "h4": case "h5": case "h6": if (!param1HtmlTreeBuilder.inScope(Constants.Headings)) { param1HtmlTreeBuilder.error(this); return false; }  param1HtmlTreeBuilder.generateImpliedEndTags(str); if (!param1HtmlTreeBuilder.currentElementIs(str)) param1HtmlTreeBuilder.error(this);  param1HtmlTreeBuilder.popStackToClose(Constants.Headings); return true;case "br": param1HtmlTreeBuilder.error(this); param1HtmlTreeBuilder.processStartTag("br"); return false; }  if (StringUtil.inSorted(str, Constants.InBodyEndAdoptionFormatters)) return inBodyEndTagAdoption((Token)formElement, param1HtmlTreeBuilder);  if (StringUtil.inSorted(str, Constants.InBodyEndClosers)) { if (!param1HtmlTreeBuilder.inScope(str)) { param1HtmlTreeBuilder.error(this); return false; }  param1HtmlTreeBuilder.generateImpliedEndTags(); if (!param1HtmlTreeBuilder.currentElementIs(str)) param1HtmlTreeBuilder.error(this);  param1HtmlTreeBuilder.popStackToClose(str); } else if (StringUtil.inSorted(str, Constants.InBodyStartApplets)) { if (!param1HtmlTreeBuilder.inScope("name")) { if (!param1HtmlTreeBuilder.inScope(str)) { param1HtmlTreeBuilder.error(this); return false; }  param1HtmlTreeBuilder.generateImpliedEndTags(); if (!param1HtmlTreeBuilder.currentElementIs(str)) param1HtmlTreeBuilder.error(this);  param1HtmlTreeBuilder.popStackToClose(str); param1HtmlTreeBuilder.clearFormattingElementsToLastMarker(); }  } else { return anyOtherEndTag((Token)formElement, param1HtmlTreeBuilder); }  return true;
/*      */     }
/*      */     
/*      */     final boolean anyOtherEndTag(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/*  847 */       String str = (param1Token.asEndTag()).normalName;
/*  848 */       ArrayList<Element> arrayList = param1HtmlTreeBuilder.getStack();
/*      */       
/*      */       Element element;
/*      */       
/*  852 */       if ((element = param1HtmlTreeBuilder.getFromStack(str)) == null) {
/*  853 */         param1HtmlTreeBuilder.error(this);
/*  854 */         return false;
/*      */       } 
/*      */       
/*  857 */       for (int i = arrayList.size() - 1; i >= 0; i--) {
/*      */         Element element1;
/*  859 */         if ((element1 = arrayList.get(i)).nameIs(str)) {
/*  860 */           param1HtmlTreeBuilder.generateImpliedEndTags(str);
/*  861 */           if (!param1HtmlTreeBuilder.currentElementIs(str))
/*  862 */             param1HtmlTreeBuilder.error(this); 
/*  863 */           param1HtmlTreeBuilder.popStackToClose(str);
/*      */           break;
/*      */         } 
/*  866 */         if (HtmlTreeBuilder.isSpecial(element1)) {
/*  867 */           param1HtmlTreeBuilder.error(this);
/*  868 */           return false;
/*      */         } 
/*      */       } 
/*      */       
/*  872 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     private boolean inBodyEndTagAdoption(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/*      */       Token.EndTag endTag;
/*  878 */       String str = (endTag = param1Token.asEndTag()).normalName();
/*      */       
/*  880 */       ArrayList<Element> arrayList = param1HtmlTreeBuilder.getStack();
/*      */       
/*  882 */       for (byte b = 0; b < 8; b++) {
/*      */         Element element2;
/*  884 */         if ((element2 = param1HtmlTreeBuilder.getActiveFormattingElement(str)) == null)
/*  885 */           return anyOtherEndTag(param1Token, param1HtmlTreeBuilder); 
/*  886 */         if (!param1HtmlTreeBuilder.onStack(element2)) {
/*  887 */           param1HtmlTreeBuilder.error(this);
/*  888 */           param1HtmlTreeBuilder.removeFromActiveFormattingElements(element2);
/*  889 */           return true;
/*  890 */         }  if (!param1HtmlTreeBuilder.inScope(element2.normalName())) {
/*  891 */           param1HtmlTreeBuilder.error(this);
/*  892 */           return false;
/*  893 */         }  if (param1HtmlTreeBuilder.currentElement() != element2) {
/*  894 */           param1HtmlTreeBuilder.error(this);
/*      */         }
/*  896 */         Element element3 = null;
/*  897 */         Element element4 = null;
/*  898 */         byte b1 = 0;
/*      */         
/*  900 */         int i = arrayList.size();
/*  901 */         int j = -1;
/*  902 */         for (byte b2 = 1; b2 < i && b2 < 64; b2++) {
/*      */           Element element;
/*      */           
/*  905 */           if ((element = arrayList.get(b2)) == element2) {
/*  906 */             element4 = arrayList.get(b2 - 1);
/*  907 */             b1 = 1;
/*      */             
/*  909 */             j = param1HtmlTreeBuilder.positionOfElement(element);
/*  910 */           } else if (b1 && HtmlTreeBuilder.isSpecial(element)) {
/*  911 */             element3 = element;
/*      */             break;
/*      */           } 
/*      */         } 
/*  915 */         if (element3 == null) {
/*  916 */           param1HtmlTreeBuilder.popStackToClose(element2.normalName());
/*  917 */           param1HtmlTreeBuilder.removeFromActiveFormattingElements(element2);
/*  918 */           return true;
/*      */         } 
/*      */         
/*  921 */         Element element6 = element3;
/*  922 */         Element element1 = element3;
/*  923 */         for (b1 = 0; b1 < 3; b1++) {
/*  924 */           if (param1HtmlTreeBuilder.onStack(element6))
/*  925 */             element6 = param1HtmlTreeBuilder.aboveOnStack(element6); 
/*  926 */           if (!param1HtmlTreeBuilder.isInActiveFormattingElements(element6))
/*  927 */           { param1HtmlTreeBuilder.removeFromStack(element6); }
/*      */           
/*  929 */           else if (element6 != element2)
/*      */           
/*      */           { 
/*  932 */             Element element = new Element(param1HtmlTreeBuilder.tagFor(element6.nodeName(), ParseSettings.preserveCase), param1HtmlTreeBuilder.getBaseUri());
/*      */             
/*  934 */             param1HtmlTreeBuilder.replaceActiveFormattingElement(element6, element);
/*  935 */             param1HtmlTreeBuilder.replaceOnStack(element6, element);
/*  936 */             element6 = element;
/*      */             
/*  938 */             if (element1 == element3)
/*      */             {
/*      */               
/*  941 */               j = param1HtmlTreeBuilder.positionOfElement(element6) + 1;
/*      */             }
/*  943 */             if (element1.parent() != null)
/*  944 */               element1.remove(); 
/*  945 */             element6.appendChild((Node)element1);
/*      */             
/*  947 */             element1 = element6; }
/*      */           else { break; }
/*      */         
/*  950 */         }  if (element4 != null) {
/*  951 */           if (StringUtil.inSorted(element4.normalName(), Constants.InBodyEndTableFosters)) {
/*  952 */             if (element1.parent() != null)
/*  953 */               element1.remove(); 
/*  954 */             param1HtmlTreeBuilder.insertInFosterParent((Node)element1);
/*      */           } else {
/*  956 */             if (element1.parent() != null)
/*  957 */               element1.remove(); 
/*  958 */             element4.appendChild((Node)element1);
/*      */           } 
/*      */         }
/*      */         
/*      */         Element element5;
/*  963 */         (element5 = new Element(element2.tag(), param1HtmlTreeBuilder.getBaseUri())).attributes().addAll(element2.attributes());
/*  964 */         element5.appendChildren(element3.childNodes());
/*  965 */         element3.appendChild((Node)element5);
/*  966 */         param1HtmlTreeBuilder.removeFromActiveFormattingElements(element2);
/*      */         
/*  968 */         param1HtmlTreeBuilder.pushWithBookmark(element5, j);
/*  969 */         param1HtmlTreeBuilder.removeFromStack(element2);
/*  970 */         param1HtmlTreeBuilder.insertOnStackAfter(element3, element5);
/*      */       } 
/*  972 */       return true;
/*      */     }
/*      */   },
/*  975 */   Text
/*      */   {
/*      */     final boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/*  978 */       if (param1Token.isCharacter())
/*  979 */       { param1HtmlTreeBuilder.insertCharacterNode(param1Token.asCharacter()); }
/*  980 */       else { if (param1Token.isEOF()) {
/*  981 */           param1HtmlTreeBuilder.error(this);
/*      */           
/*  983 */           param1HtmlTreeBuilder.pop();
/*  984 */           param1HtmlTreeBuilder.transition(param1HtmlTreeBuilder.originalState());
/*  985 */           return param1HtmlTreeBuilder.process(param1Token);
/*  986 */         }  if (param1Token.isEndTag()) {
/*      */           
/*  988 */           param1HtmlTreeBuilder.pop();
/*  989 */           param1HtmlTreeBuilder.transition(param1HtmlTreeBuilder.originalState());
/*      */         }  }
/*  991 */        return true;
/*      */     }
/*      */   },
/*  994 */   InTable {
/*      */     final boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/*  996 */       if (param1Token.isCharacter() && StringUtil.inSorted(param1HtmlTreeBuilder.currentElement().normalName(), Constants.InTableFoster)) {
/*  997 */         param1HtmlTreeBuilder.resetPendingTableCharacters();
/*  998 */         param1HtmlTreeBuilder.markInsertionMode();
/*  999 */         param1HtmlTreeBuilder.transition(InTableText);
/* 1000 */         return param1HtmlTreeBuilder.process(param1Token);
/* 1001 */       }  if (param1Token.isComment()) {
/* 1002 */         param1HtmlTreeBuilder.insertCommentNode(param1Token.asComment());
/* 1003 */         return true;
/* 1004 */       }  if (param1Token.isDoctype()) {
/* 1005 */         param1HtmlTreeBuilder.error(this);
/* 1006 */         return false;
/* 1007 */       }  if (param1Token.isStartTag()) {
/*      */         Token.StartTag startTag;
/*      */         String str;
/* 1010 */         if ((str = (startTag = param1Token.asStartTag()).normalName()).equals("caption"))
/* 1011 */         { param1HtmlTreeBuilder.clearStackToTableContext();
/* 1012 */           param1HtmlTreeBuilder.insertMarkerToFormattingElements();
/* 1013 */           param1HtmlTreeBuilder.insertElementFor(startTag);
/* 1014 */           param1HtmlTreeBuilder.transition(InCaption); }
/* 1015 */         else if (str.equals("colgroup"))
/* 1016 */         { param1HtmlTreeBuilder.clearStackToTableContext();
/* 1017 */           param1HtmlTreeBuilder.insertElementFor(startTag);
/* 1018 */           param1HtmlTreeBuilder.transition(InColumnGroup); }
/* 1019 */         else { if (str.equals("col")) {
/* 1020 */             param1HtmlTreeBuilder.clearStackToTableContext();
/* 1021 */             param1HtmlTreeBuilder.processStartTag("colgroup");
/* 1022 */             return param1HtmlTreeBuilder.process(param1Token);
/* 1023 */           }  if (StringUtil.inSorted(str, Constants.InTableToBody))
/* 1024 */           { param1HtmlTreeBuilder.clearStackToTableContext();
/* 1025 */             param1HtmlTreeBuilder.insertElementFor(startTag);
/* 1026 */             param1HtmlTreeBuilder.transition(InTableBody); }
/* 1027 */           else { if (StringUtil.inSorted(str, Constants.InTableAddBody)) {
/* 1028 */               param1HtmlTreeBuilder.clearStackToTableContext();
/* 1029 */               param1HtmlTreeBuilder.processStartTag("tbody");
/* 1030 */               return param1HtmlTreeBuilder.process(param1Token);
/* 1031 */             }  if (str.equals("table")) {
/* 1032 */               param1HtmlTreeBuilder.error(this);
/* 1033 */               if (!param1HtmlTreeBuilder.inTableScope(str)) {
/* 1034 */                 return false;
/*      */               }
/* 1036 */               param1HtmlTreeBuilder.popStackToClose(str);
/* 1037 */               if (!param1HtmlTreeBuilder.resetInsertionMode()) {
/*      */                 
/* 1039 */                 param1HtmlTreeBuilder.insertElementFor(startTag);
/* 1040 */                 return true;
/*      */               } 
/* 1042 */               return param1HtmlTreeBuilder.process(param1Token);
/*      */             } 
/* 1044 */             if (StringUtil.inSorted(str, Constants.InTableToHead))
/* 1045 */               return param1HtmlTreeBuilder.process(param1Token, InHead); 
/* 1046 */             if (str.equals("input"))
/* 1047 */             { if (!startTag.hasAttributes() || !startTag.attributes.get("type").equalsIgnoreCase("hidden")) {
/* 1048 */                 return anythingElse(param1Token, param1HtmlTreeBuilder);
/*      */               }
/* 1050 */               param1HtmlTreeBuilder.insertEmptyElementFor(startTag); }
/*      */             
/* 1052 */             else if (str.equals("form"))
/* 1053 */             { param1HtmlTreeBuilder.error(this);
/* 1054 */               if (param1HtmlTreeBuilder.getFormElement() != null || param1HtmlTreeBuilder.onStack("template")) {
/* 1055 */                 return false;
/*      */               }
/* 1057 */               param1HtmlTreeBuilder.insertFormElement(startTag, false, false); }
/*      */             else
/*      */             
/* 1060 */             { return anythingElse(param1Token, param1HtmlTreeBuilder); }  }
/*      */            }
/* 1062 */          return true;
/* 1063 */       }  if (param1Token.isEndTag()) {
/*      */         Token.EndTag endTag;
/*      */         
/*      */         String str;
/* 1067 */         if ((str = (endTag = param1Token.asEndTag()).normalName()).equals("table")) {
/* 1068 */           if (!param1HtmlTreeBuilder.inTableScope(str)) {
/* 1069 */             param1HtmlTreeBuilder.error(this);
/* 1070 */             return false;
/*      */           } 
/* 1072 */           param1HtmlTreeBuilder.popStackToClose("table");
/* 1073 */           param1HtmlTreeBuilder.resetInsertionMode();
/*      */         } else {
/* 1075 */           if (StringUtil.inSorted(str, Constants.InTableEndErr)) {
/* 1076 */             param1HtmlTreeBuilder.error(this);
/* 1077 */             return false;
/* 1078 */           }  if (str.equals("template")) {
/* 1079 */             param1HtmlTreeBuilder.process(param1Token, InHead);
/*      */           } else {
/* 1081 */             return anythingElse(param1Token, param1HtmlTreeBuilder);
/*      */           } 
/* 1083 */         }  return true;
/* 1084 */       }  if (param1Token.isEOF()) {
/* 1085 */         if (param1HtmlTreeBuilder.currentElementIs("html"))
/* 1086 */           param1HtmlTreeBuilder.error(this); 
/* 1087 */         return true;
/*      */       } 
/* 1089 */       return anythingElse(param1Token, param1HtmlTreeBuilder);
/*      */     }
/*      */     
/*      */     final boolean anythingElse(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/* 1093 */       param1HtmlTreeBuilder.error(this);
/* 1094 */       param1HtmlTreeBuilder.setFosterInserts(true);
/* 1095 */       param1HtmlTreeBuilder.process(param1Token, InBody);
/* 1096 */       param1HtmlTreeBuilder.setFosterInserts(false);
/* 1097 */       return true;
/*      */     }
/*      */   },
/* 1100 */   InTableText {
/*      */     final boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/* 1102 */       if (param1Token.type == Token.TokenType.Character) {
/*      */         Token.Character character;
/* 1104 */         if ((character = param1Token.asCharacter()).getData().equals(HtmlTreeBuilderState.nullString)) {
/* 1105 */           param1HtmlTreeBuilder.error(this);
/* 1106 */           return false;
/*      */         } 
/* 1108 */         param1HtmlTreeBuilder.addPendingTableCharacters(character);
/*      */       }
/*      */       else {
/*      */         
/* 1112 */         if (param1HtmlTreeBuilder.getPendingTableCharacters().size() > 0) {
/* 1113 */           Token token = param1HtmlTreeBuilder.currentToken;
/* 1114 */           for (Token.Character character : param1HtmlTreeBuilder.getPendingTableCharacters()) {
/* 1115 */             param1HtmlTreeBuilder.currentToken = character;
/* 1116 */             if (!isWhitespace(character)) {
/*      */               
/* 1118 */               param1HtmlTreeBuilder.error(this);
/* 1119 */               if (StringUtil.inSorted(param1HtmlTreeBuilder.currentElement().normalName(), Constants.InTableFoster)) {
/* 1120 */                 param1HtmlTreeBuilder.setFosterInserts(true);
/* 1121 */                 param1HtmlTreeBuilder.process(character, InBody);
/* 1122 */                 param1HtmlTreeBuilder.setFosterInserts(false); continue;
/*      */               } 
/* 1124 */               param1HtmlTreeBuilder.process(character, InBody);
/*      */               continue;
/*      */             } 
/* 1127 */             param1HtmlTreeBuilder.insertCharacterNode(character);
/*      */           } 
/* 1129 */           param1HtmlTreeBuilder.currentToken = token;
/* 1130 */           param1HtmlTreeBuilder.resetPendingTableCharacters();
/*      */         } 
/* 1132 */         param1HtmlTreeBuilder.transition(param1HtmlTreeBuilder.originalState());
/* 1133 */         return param1HtmlTreeBuilder.process(param1Token);
/*      */       } 
/* 1135 */       return true;
/*      */     }
/*      */   },
/* 1138 */   InCaption {
/*      */     final boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/* 1140 */       if (param1Token.isEndTag() && param1Token.asEndTag().normalName().equals("caption"))
/* 1141 */       { if (!param1HtmlTreeBuilder.inTableScope("caption")) {
/* 1142 */           param1HtmlTreeBuilder.error(this);
/* 1143 */           return false;
/*      */         } 
/* 1145 */         param1HtmlTreeBuilder.generateImpliedEndTags();
/* 1146 */         if (!param1HtmlTreeBuilder.currentElementIs("caption")) param1HtmlTreeBuilder.error(this); 
/* 1147 */         param1HtmlTreeBuilder.popStackToClose("caption");
/* 1148 */         param1HtmlTreeBuilder.clearFormattingElementsToLastMarker();
/* 1149 */         param1HtmlTreeBuilder.transition(InTable); }
/*      */       
/* 1151 */       else if ((param1Token
/* 1152 */         .isStartTag() && StringUtil.inSorted(param1Token.asStartTag().normalName(), Constants.InCellCol)) || (param1Token
/* 1153 */         .isEndTag() && param1Token.asEndTag().normalName().equals("table")))
/*      */       
/*      */       { 
/* 1156 */         if (!param1HtmlTreeBuilder.inTableScope("caption")) {
/* 1157 */           param1HtmlTreeBuilder.error(this);
/* 1158 */           return false;
/*      */         } 
/* 1160 */         param1HtmlTreeBuilder.generateImpliedEndTags(false);
/* 1161 */         if (!param1HtmlTreeBuilder.currentElementIs("caption")) param1HtmlTreeBuilder.error(this); 
/* 1162 */         param1HtmlTreeBuilder.popStackToClose("caption");
/* 1163 */         param1HtmlTreeBuilder.clearFormattingElementsToLastMarker();
/* 1164 */         param1HtmlTreeBuilder.transition(InTable);
/* 1165 */         InTable.process(param1Token, param1HtmlTreeBuilder); }
/* 1166 */       else { if (param1Token.isEndTag() && StringUtil.inSorted(param1Token.asEndTag().normalName(), Constants.InCaptionIgnore)) {
/* 1167 */           param1HtmlTreeBuilder.error(this);
/* 1168 */           return false;
/*      */         } 
/* 1170 */         return param1HtmlTreeBuilder.process(param1Token, InBody); }
/*      */       
/* 1172 */       return true;
/*      */     }
/*      */   },
/* 1175 */   InColumnGroup
/*      */   {
/*      */     final boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/*      */       // Byte code:
/*      */       //   0: aload_1
/*      */       //   1: invokestatic access$100 : (Lorg/jsoup/parser/Token;)Z
/*      */       //   4: ifeq -> 17
/*      */       //   7: aload_2
/*      */       //   8: aload_1
/*      */       //   9: invokevirtual asCharacter : ()Lorg/jsoup/parser/Token$Character;
/*      */       //   12: invokevirtual insertCharacterNode : (Lorg/jsoup/parser/Token$Character;)V
/*      */       //   15: iconst_1
/*      */       //   16: ireturn
/*      */       //   17: getstatic org/jsoup/parser/HtmlTreeBuilderState$25.$SwitchMap$org$jsoup$parser$Token$TokenType : [I
/*      */       //   20: aload_1
/*      */       //   21: getfield type : Lorg/jsoup/parser/Token$TokenType;
/*      */       //   24: invokevirtual ordinal : ()I
/*      */       //   27: iaload
/*      */       //   28: tableswitch default -> 420, 1 -> 68, 2 -> 79, 3 -> 87, 4 -> 249, 5 -> 420, 6 -> 402
/*      */       //   68: aload_2
/*      */       //   69: aload_1
/*      */       //   70: invokevirtual asComment : ()Lorg/jsoup/parser/Token$Comment;
/*      */       //   73: invokevirtual insertCommentNode : (Lorg/jsoup/parser/Token$Comment;)V
/*      */       //   76: goto -> 427
/*      */       //   79: aload_2
/*      */       //   80: aload_0
/*      */       //   81: invokevirtual error : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   84: goto -> 427
/*      */       //   87: aload_1
/*      */       //   88: invokevirtual asStartTag : ()Lorg/jsoup/parser/Token$StartTag;
/*      */       //   91: dup
/*      */       //   92: astore_3
/*      */       //   93: invokevirtual normalName : ()Ljava/lang/String;
/*      */       //   96: astore #4
/*      */       //   98: iconst_m1
/*      */       //   99: istore #5
/*      */       //   101: aload #4
/*      */       //   103: invokevirtual hashCode : ()I
/*      */       //   106: lookupswitch default -> 185, -1321546630 -> 172, 98688 -> 156, 3213227 -> 140
/*      */       //   140: aload #4
/*      */       //   142: ldc 'html'
/*      */       //   144: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */       //   147: ifeq -> 185
/*      */       //   150: iconst_0
/*      */       //   151: istore #5
/*      */       //   153: goto -> 185
/*      */       //   156: aload #4
/*      */       //   158: ldc 'col'
/*      */       //   160: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */       //   163: ifeq -> 185
/*      */       //   166: iconst_1
/*      */       //   167: istore #5
/*      */       //   169: goto -> 185
/*      */       //   172: aload #4
/*      */       //   174: ldc 'template'
/*      */       //   176: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */       //   179: ifeq -> 185
/*      */       //   182: iconst_2
/*      */       //   183: istore #5
/*      */       //   185: iload #5
/*      */       //   187: tableswitch default -> 242, 0 -> 212, 1 -> 221, 2 -> 230
/*      */       //   212: aload_2
/*      */       //   213: aload_1
/*      */       //   214: getstatic org/jsoup/parser/HtmlTreeBuilderState$12.InBody : Lorg/jsoup/parser/HtmlTreeBuilderState;
/*      */       //   217: invokevirtual process : (Lorg/jsoup/parser/Token;Lorg/jsoup/parser/HtmlTreeBuilderState;)Z
/*      */       //   220: ireturn
/*      */       //   221: aload_2
/*      */       //   222: aload_3
/*      */       //   223: invokevirtual insertEmptyElementFor : (Lorg/jsoup/parser/Token$StartTag;)Lorg/jsoup/nodes/Element;
/*      */       //   226: pop
/*      */       //   227: goto -> 427
/*      */       //   230: aload_2
/*      */       //   231: aload_1
/*      */       //   232: getstatic org/jsoup/parser/HtmlTreeBuilderState$12.InHead : Lorg/jsoup/parser/HtmlTreeBuilderState;
/*      */       //   235: invokevirtual process : (Lorg/jsoup/parser/Token;Lorg/jsoup/parser/HtmlTreeBuilderState;)Z
/*      */       //   238: pop
/*      */       //   239: goto -> 427
/*      */       //   242: aload_0
/*      */       //   243: aload_1
/*      */       //   244: aload_2
/*      */       //   245: invokespecial anythingElse : (Lorg/jsoup/parser/Token;Lorg/jsoup/parser/HtmlTreeBuilder;)Z
/*      */       //   248: ireturn
/*      */       //   249: aload_1
/*      */       //   250: invokevirtual asEndTag : ()Lorg/jsoup/parser/Token$EndTag;
/*      */       //   253: dup
/*      */       //   254: astore #4
/*      */       //   256: invokevirtual normalName : ()Ljava/lang/String;
/*      */       //   259: dup
/*      */       //   260: astore #5
/*      */       //   262: astore_3
/*      */       //   263: iconst_m1
/*      */       //   264: istore #4
/*      */       //   266: aload_3
/*      */       //   267: invokevirtual hashCode : ()I
/*      */       //   270: lookupswitch default -> 323, -1321546630 -> 311, -636197633 -> 296
/*      */       //   296: aload_3
/*      */       //   297: ldc 'colgroup'
/*      */       //   299: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */       //   302: ifeq -> 323
/*      */       //   305: iconst_0
/*      */       //   306: istore #4
/*      */       //   308: goto -> 323
/*      */       //   311: aload_3
/*      */       //   312: ldc 'template'
/*      */       //   314: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */       //   317: ifeq -> 323
/*      */       //   320: iconst_1
/*      */       //   321: istore #4
/*      */       //   323: iload #4
/*      */       //   325: lookupswitch default -> 395, 0 -> 352, 1 -> 383
/*      */       //   352: aload_2
/*      */       //   353: aload #5
/*      */       //   355: invokevirtual currentElementIs : (Ljava/lang/String;)Z
/*      */       //   358: ifne -> 368
/*      */       //   361: aload_2
/*      */       //   362: aload_0
/*      */       //   363: invokevirtual error : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   366: iconst_0
/*      */       //   367: ireturn
/*      */       //   368: aload_2
/*      */       //   369: invokevirtual pop : ()Lorg/jsoup/nodes/Element;
/*      */       //   372: pop
/*      */       //   373: aload_2
/*      */       //   374: getstatic org/jsoup/parser/HtmlTreeBuilderState$12.InTable : Lorg/jsoup/parser/HtmlTreeBuilderState;
/*      */       //   377: invokevirtual transition : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   380: goto -> 427
/*      */       //   383: aload_2
/*      */       //   384: aload_1
/*      */       //   385: getstatic org/jsoup/parser/HtmlTreeBuilderState$12.InHead : Lorg/jsoup/parser/HtmlTreeBuilderState;
/*      */       //   388: invokevirtual process : (Lorg/jsoup/parser/Token;Lorg/jsoup/parser/HtmlTreeBuilderState;)Z
/*      */       //   391: pop
/*      */       //   392: goto -> 427
/*      */       //   395: aload_0
/*      */       //   396: aload_1
/*      */       //   397: aload_2
/*      */       //   398: invokespecial anythingElse : (Lorg/jsoup/parser/Token;Lorg/jsoup/parser/HtmlTreeBuilder;)Z
/*      */       //   401: ireturn
/*      */       //   402: aload_2
/*      */       //   403: ldc 'html'
/*      */       //   405: invokevirtual currentElementIs : (Ljava/lang/String;)Z
/*      */       //   408: ifeq -> 413
/*      */       //   411: iconst_1
/*      */       //   412: ireturn
/*      */       //   413: aload_0
/*      */       //   414: aload_1
/*      */       //   415: aload_2
/*      */       //   416: invokespecial anythingElse : (Lorg/jsoup/parser/Token;Lorg/jsoup/parser/HtmlTreeBuilder;)Z
/*      */       //   419: ireturn
/*      */       //   420: aload_0
/*      */       //   421: aload_1
/*      */       //   422: aload_2
/*      */       //   423: invokespecial anythingElse : (Lorg/jsoup/parser/Token;Lorg/jsoup/parser/HtmlTreeBuilder;)Z
/*      */       //   426: ireturn
/*      */       //   427: iconst_1
/*      */       //   428: ireturn
/*      */       // Line number table:
/*      */       //   Java source line number -> byte code offset
/*      */       //   #1177	-> 0
/*      */       //   #1178	-> 7
/*      */       //   #1179	-> 15
/*      */       //   #1181	-> 17
/*      */       //   #1183	-> 68
/*      */       //   #1184	-> 76
/*      */       //   #1186	-> 79
/*      */       //   #1187	-> 84
/*      */       //   #1189	-> 87
/*      */       //   #1190	-> 92
/*      */       //   #1192	-> 212
/*      */       //   #1194	-> 221
/*      */       //   #1195	-> 227
/*      */       //   #1197	-> 230
/*      */       //   #1198	-> 239
/*      */       //   #1200	-> 242
/*      */       //   #1204	-> 249
/*      */       //   #1205	-> 254
/*      */       //   #1206	-> 260
/*      */       //   #1208	-> 352
/*      */       //   #1209	-> 361
/*      */       //   #1210	-> 366
/*      */       //   #1212	-> 368
/*      */       //   #1213	-> 373
/*      */       //   #1215	-> 380
/*      */       //   #1217	-> 383
/*      */       //   #1218	-> 392
/*      */       //   #1220	-> 395
/*      */       //   #1224	-> 402
/*      */       //   #1225	-> 411
/*      */       //   #1227	-> 413
/*      */       //   #1229	-> 420
/*      */       //   #1231	-> 427
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private boolean anythingElse(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/* 1235 */       if (!param1HtmlTreeBuilder.currentElementIs("colgroup")) {
/* 1236 */         param1HtmlTreeBuilder.error(this);
/* 1237 */         return false;
/*      */       } 
/* 1239 */       param1HtmlTreeBuilder.pop();
/* 1240 */       param1HtmlTreeBuilder.transition(InTable);
/* 1241 */       param1HtmlTreeBuilder.process(param1Token);
/* 1242 */       return true;
/*      */     }
/*      */   },
/* 1245 */   InTableBody
/*      */   {
/*      */     final boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/*      */       // Byte code:
/*      */       //   0: getstatic org/jsoup/parser/HtmlTreeBuilderState$25.$SwitchMap$org$jsoup$parser$Token$TokenType : [I
/*      */       //   3: aload_1
/*      */       //   4: getfield type : Lorg/jsoup/parser/Token$TokenType;
/*      */       //   7: invokevirtual ordinal : ()I
/*      */       //   10: iaload
/*      */       //   11: lookupswitch default -> 228, 3 -> 36, 4 -> 130
/*      */       //   36: aload_1
/*      */       //   37: invokevirtual asStartTag : ()Lorg/jsoup/parser/Token$StartTag;
/*      */       //   40: dup
/*      */       //   41: astore_3
/*      */       //   42: invokevirtual normalName : ()Ljava/lang/String;
/*      */       //   45: dup
/*      */       //   46: astore #4
/*      */       //   48: ldc 'tr'
/*      */       //   50: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */       //   53: ifeq -> 76
/*      */       //   56: aload_2
/*      */       //   57: invokevirtual clearStackToTableBodyContext : ()V
/*      */       //   60: aload_2
/*      */       //   61: aload_3
/*      */       //   62: invokevirtual insertElementFor : (Lorg/jsoup/parser/Token$StartTag;)Lorg/jsoup/nodes/Element;
/*      */       //   65: pop
/*      */       //   66: aload_2
/*      */       //   67: getstatic org/jsoup/parser/HtmlTreeBuilderState$13.InRow : Lorg/jsoup/parser/HtmlTreeBuilderState;
/*      */       //   70: invokevirtual transition : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   73: goto -> 235
/*      */       //   76: aload #4
/*      */       //   78: getstatic org/jsoup/parser/HtmlTreeBuilderState$Constants.InCellNames : [Ljava/lang/String;
/*      */       //   81: invokestatic inSorted : (Ljava/lang/String;[Ljava/lang/String;)Z
/*      */       //   84: ifeq -> 105
/*      */       //   87: aload_2
/*      */       //   88: aload_0
/*      */       //   89: invokevirtual error : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   92: aload_2
/*      */       //   93: ldc 'tr'
/*      */       //   95: invokevirtual processStartTag : (Ljava/lang/String;)Z
/*      */       //   98: pop
/*      */       //   99: aload_2
/*      */       //   100: aload_3
/*      */       //   101: invokevirtual process : (Lorg/jsoup/parser/Token;)Z
/*      */       //   104: ireturn
/*      */       //   105: aload #4
/*      */       //   107: getstatic org/jsoup/parser/HtmlTreeBuilderState$Constants.InTableBodyExit : [Ljava/lang/String;
/*      */       //   110: invokestatic inSorted : (Ljava/lang/String;[Ljava/lang/String;)Z
/*      */       //   113: ifeq -> 123
/*      */       //   116: aload_0
/*      */       //   117: aload_1
/*      */       //   118: aload_2
/*      */       //   119: invokespecial exitTableBody : (Lorg/jsoup/parser/Token;Lorg/jsoup/parser/HtmlTreeBuilder;)Z
/*      */       //   122: ireturn
/*      */       //   123: aload_0
/*      */       //   124: aload_1
/*      */       //   125: aload_2
/*      */       //   126: invokespecial anythingElse : (Lorg/jsoup/parser/Token;Lorg/jsoup/parser/HtmlTreeBuilder;)Z
/*      */       //   129: ireturn
/*      */       //   130: aload_1
/*      */       //   131: invokevirtual asEndTag : ()Lorg/jsoup/parser/Token$EndTag;
/*      */       //   134: dup
/*      */       //   135: astore_3
/*      */       //   136: invokevirtual normalName : ()Ljava/lang/String;
/*      */       //   139: dup
/*      */       //   140: astore #4
/*      */       //   142: getstatic org/jsoup/parser/HtmlTreeBuilderState$Constants.InTableEndIgnore : [Ljava/lang/String;
/*      */       //   145: invokestatic inSorted : (Ljava/lang/String;[Ljava/lang/String;)Z
/*      */       //   148: ifeq -> 186
/*      */       //   151: aload_2
/*      */       //   152: aload #4
/*      */       //   154: invokevirtual inTableScope : (Ljava/lang/String;)Z
/*      */       //   157: ifne -> 167
/*      */       //   160: aload_2
/*      */       //   161: aload_0
/*      */       //   162: invokevirtual error : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   165: iconst_0
/*      */       //   166: ireturn
/*      */       //   167: aload_2
/*      */       //   168: invokevirtual clearStackToTableBodyContext : ()V
/*      */       //   171: aload_2
/*      */       //   172: invokevirtual pop : ()Lorg/jsoup/nodes/Element;
/*      */       //   175: pop
/*      */       //   176: aload_2
/*      */       //   177: getstatic org/jsoup/parser/HtmlTreeBuilderState$13.InTable : Lorg/jsoup/parser/HtmlTreeBuilderState;
/*      */       //   180: invokevirtual transition : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   183: goto -> 235
/*      */       //   186: aload #4
/*      */       //   188: ldc 'table'
/*      */       //   190: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */       //   193: ifeq -> 203
/*      */       //   196: aload_0
/*      */       //   197: aload_1
/*      */       //   198: aload_2
/*      */       //   199: invokespecial exitTableBody : (Lorg/jsoup/parser/Token;Lorg/jsoup/parser/HtmlTreeBuilder;)Z
/*      */       //   202: ireturn
/*      */       //   203: aload #4
/*      */       //   205: getstatic org/jsoup/parser/HtmlTreeBuilderState$Constants.InTableBodyEndIgnore : [Ljava/lang/String;
/*      */       //   208: invokestatic inSorted : (Ljava/lang/String;[Ljava/lang/String;)Z
/*      */       //   211: ifeq -> 221
/*      */       //   214: aload_2
/*      */       //   215: aload_0
/*      */       //   216: invokevirtual error : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   219: iconst_0
/*      */       //   220: ireturn
/*      */       //   221: aload_0
/*      */       //   222: aload_1
/*      */       //   223: aload_2
/*      */       //   224: invokespecial anythingElse : (Lorg/jsoup/parser/Token;Lorg/jsoup/parser/HtmlTreeBuilder;)Z
/*      */       //   227: ireturn
/*      */       //   228: aload_0
/*      */       //   229: aload_1
/*      */       //   230: aload_2
/*      */       //   231: invokespecial anythingElse : (Lorg/jsoup/parser/Token;Lorg/jsoup/parser/HtmlTreeBuilder;)Z
/*      */       //   234: ireturn
/*      */       //   235: iconst_1
/*      */       //   236: ireturn
/*      */       // Line number table:
/*      */       //   Java source line number -> byte code offset
/*      */       //   #1247	-> 0
/*      */       //   #1249	-> 36
/*      */       //   #1250	-> 41
/*      */       //   #1251	-> 46
/*      */       //   #1252	-> 56
/*      */       //   #1253	-> 60
/*      */       //   #1254	-> 66
/*      */       //   #1255	-> 76
/*      */       //   #1256	-> 87
/*      */       //   #1257	-> 92
/*      */       //   #1258	-> 99
/*      */       //   #1259	-> 105
/*      */       //   #1260	-> 116
/*      */       //   #1262	-> 123
/*      */       //   #1265	-> 130
/*      */       //   #1266	-> 135
/*      */       //   #1267	-> 140
/*      */       //   #1268	-> 151
/*      */       //   #1269	-> 160
/*      */       //   #1270	-> 165
/*      */       //   #1272	-> 167
/*      */       //   #1273	-> 171
/*      */       //   #1274	-> 176
/*      */       //   #1276	-> 186
/*      */       //   #1277	-> 196
/*      */       //   #1278	-> 203
/*      */       //   #1279	-> 214
/*      */       //   #1280	-> 219
/*      */       //   #1282	-> 221
/*      */       //   #1285	-> 228
/*      */       //   #1287	-> 235
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private boolean exitTableBody(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/* 1291 */       if (!param1HtmlTreeBuilder.inTableScope("tbody") && !param1HtmlTreeBuilder.inTableScope("thead") && !param1HtmlTreeBuilder.inScope("tfoot")) {
/*      */         
/* 1293 */         param1HtmlTreeBuilder.error(this);
/* 1294 */         return false;
/*      */       } 
/* 1296 */       param1HtmlTreeBuilder.clearStackToTableBodyContext();
/* 1297 */       param1HtmlTreeBuilder.processEndTag(param1HtmlTreeBuilder.currentElement().normalName());
/* 1298 */       return param1HtmlTreeBuilder.process(param1Token);
/*      */     }
/*      */     
/*      */     private boolean anythingElse(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/* 1302 */       return param1HtmlTreeBuilder.process(param1Token, InTable);
/*      */     }
/*      */   },
/* 1305 */   InRow {
/*      */     final boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/* 1307 */       if (param1Token.isStartTag()) {
/*      */         Token.StartTag startTag;
/*      */         
/*      */         String str;
/* 1311 */         if (StringUtil.inSorted(str = (startTag = param1Token.asStartTag()).normalName(), Constants.InCellNames))
/* 1312 */         { param1HtmlTreeBuilder.clearStackToTableRowContext();
/* 1313 */           param1HtmlTreeBuilder.insertElementFor(startTag);
/* 1314 */           param1HtmlTreeBuilder.transition(InCell);
/* 1315 */           param1HtmlTreeBuilder.insertMarkerToFormattingElements(); }
/* 1316 */         else { if (StringUtil.inSorted(str, Constants.InRowMissing)) {
/* 1317 */             if (!param1HtmlTreeBuilder.inTableScope("tr")) {
/* 1318 */               param1HtmlTreeBuilder.error(this);
/* 1319 */               return false;
/*      */             } 
/* 1321 */             param1HtmlTreeBuilder.clearStackToTableRowContext();
/* 1322 */             param1HtmlTreeBuilder.pop();
/* 1323 */             param1HtmlTreeBuilder.transition(InTableBody);
/* 1324 */             return param1HtmlTreeBuilder.process(param1Token);
/*      */           } 
/* 1326 */           return anythingElse(param1Token, param1HtmlTreeBuilder); }
/*      */       
/* 1328 */       } else if (param1Token.isEndTag()) {
/*      */         Token.EndTag endTag;
/*      */         
/*      */         String str;
/* 1332 */         if ((str = (endTag = param1Token.asEndTag()).normalName()).equals("tr"))
/* 1333 */         { if (!param1HtmlTreeBuilder.inTableScope(str)) {
/* 1334 */             param1HtmlTreeBuilder.error(this);
/* 1335 */             return false;
/*      */           } 
/* 1337 */           param1HtmlTreeBuilder.clearStackToTableRowContext();
/* 1338 */           param1HtmlTreeBuilder.pop();
/* 1339 */           param1HtmlTreeBuilder.transition(InTableBody); }
/* 1340 */         else { if (str.equals("table")) {
/* 1341 */             if (!param1HtmlTreeBuilder.inTableScope("tr")) {
/* 1342 */               param1HtmlTreeBuilder.error(this);
/* 1343 */               return false;
/*      */             } 
/* 1345 */             param1HtmlTreeBuilder.clearStackToTableRowContext();
/* 1346 */             param1HtmlTreeBuilder.pop();
/* 1347 */             param1HtmlTreeBuilder.transition(InTableBody);
/* 1348 */             return param1HtmlTreeBuilder.process(param1Token);
/* 1349 */           }  if (StringUtil.inSorted(str, Constants.InTableToBody)) {
/* 1350 */             if (!param1HtmlTreeBuilder.inTableScope(str)) {
/* 1351 */               param1HtmlTreeBuilder.error(this);
/* 1352 */               return false;
/*      */             } 
/* 1354 */             if (!param1HtmlTreeBuilder.inTableScope("tr"))
/*      */             {
/* 1356 */               return false;
/*      */             }
/* 1358 */             param1HtmlTreeBuilder.clearStackToTableRowContext();
/* 1359 */             param1HtmlTreeBuilder.pop();
/* 1360 */             param1HtmlTreeBuilder.transition(InTableBody);
/* 1361 */             return param1HtmlTreeBuilder.process(param1Token);
/* 1362 */           }  if (StringUtil.inSorted(str, Constants.InRowIgnore)) {
/* 1363 */             param1HtmlTreeBuilder.error(this);
/* 1364 */             return false;
/*      */           } 
/* 1366 */           return anythingElse(param1Token, param1HtmlTreeBuilder); }
/*      */       
/*      */       } else {
/* 1369 */         return anythingElse(param1Token, param1HtmlTreeBuilder);
/*      */       } 
/* 1371 */       return true;
/*      */     }
/*      */     
/*      */     private boolean anythingElse(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/* 1375 */       return param1HtmlTreeBuilder.process(param1Token, InTable);
/*      */     }
/*      */   },
/* 1378 */   InCell {
/*      */     final boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/* 1380 */       if (param1Token.isEndTag())
/*      */       { String str;
/*      */         
/*      */         Token.EndTag endTag;
/* 1384 */         if (StringUtil.inSorted(str = (endTag = param1Token.asEndTag()).normalName(), Constants.InCellNames))
/* 1385 */         { if (!param1HtmlTreeBuilder.inTableScope(str)) {
/* 1386 */             param1HtmlTreeBuilder.error(this);
/* 1387 */             param1HtmlTreeBuilder.transition(InRow);
/* 1388 */             return false;
/*      */           } 
/* 1390 */           param1HtmlTreeBuilder.generateImpliedEndTags();
/* 1391 */           if (!param1HtmlTreeBuilder.currentElementIs(str))
/* 1392 */             param1HtmlTreeBuilder.error(this); 
/* 1393 */           param1HtmlTreeBuilder.popStackToClose(str);
/* 1394 */           param1HtmlTreeBuilder.clearFormattingElementsToLastMarker();
/* 1395 */           param1HtmlTreeBuilder.transition(InRow); }
/* 1396 */         else { if (StringUtil.inSorted(str, Constants.InCellBody)) {
/* 1397 */             param1HtmlTreeBuilder.error(this);
/* 1398 */             return false;
/* 1399 */           }  if (StringUtil.inSorted(str, Constants.InCellTable)) {
/* 1400 */             if (!param1HtmlTreeBuilder.inTableScope(str)) {
/* 1401 */               param1HtmlTreeBuilder.error(this);
/* 1402 */               return false;
/*      */             } 
/* 1404 */             closeCell(param1HtmlTreeBuilder);
/* 1405 */             return param1HtmlTreeBuilder.process(param1Token);
/*      */           } 
/* 1407 */           return anythingElse(param1Token, param1HtmlTreeBuilder); }
/*      */          }
/* 1409 */       else { if (param1Token.isStartTag() && 
/* 1410 */           StringUtil.inSorted(param1Token.asStartTag().normalName(), Constants.InCellCol)) {
/* 1411 */           if (!param1HtmlTreeBuilder.inTableScope("td") && !param1HtmlTreeBuilder.inTableScope("th")) {
/* 1412 */             param1HtmlTreeBuilder.error(this);
/* 1413 */             return false;
/*      */           } 
/* 1415 */           closeCell(param1HtmlTreeBuilder);
/* 1416 */           return param1HtmlTreeBuilder.process(param1Token);
/*      */         } 
/* 1418 */         return anythingElse(param1Token, param1HtmlTreeBuilder); }
/*      */       
/* 1420 */       return true;
/*      */     }
/*      */     
/*      */     private boolean anythingElse(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/* 1424 */       return param1HtmlTreeBuilder.process(param1Token, InBody);
/*      */     }
/*      */     
/*      */     private void closeCell(HtmlTreeBuilder param1HtmlTreeBuilder) {
/* 1428 */       if (param1HtmlTreeBuilder.inTableScope("td")) {
/* 1429 */         param1HtmlTreeBuilder.processEndTag("td"); return;
/*      */       } 
/* 1431 */       param1HtmlTreeBuilder.processEndTag("th");
/*      */     }
/*      */   },
/* 1434 */   InSelect
/*      */   {
/*      */     final boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/*      */       // Byte code:
/*      */       //   0: getstatic org/jsoup/parser/HtmlTreeBuilderState$25.$SwitchMap$org$jsoup$parser$Token$TokenType : [I
/*      */       //   3: aload_1
/*      */       //   4: getfield type : Lorg/jsoup/parser/Token$TokenType;
/*      */       //   7: invokevirtual ordinal : ()I
/*      */       //   10: iaload
/*      */       //   11: tableswitch default -> 621, 1 -> 81, 2 -> 92, 3 -> 99, 4 -> 312, 5 -> 48, 6 -> 604
/*      */       //   48: aload_1
/*      */       //   49: invokevirtual asCharacter : ()Lorg/jsoup/parser/Token$Character;
/*      */       //   52: dup
/*      */       //   53: astore_1
/*      */       //   54: invokevirtual getData : ()Ljava/lang/String;
/*      */       //   57: invokestatic access$400 : ()Ljava/lang/String;
/*      */       //   60: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */       //   63: ifeq -> 73
/*      */       //   66: aload_2
/*      */       //   67: aload_0
/*      */       //   68: invokevirtual error : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   71: iconst_0
/*      */       //   72: ireturn
/*      */       //   73: aload_2
/*      */       //   74: aload_1
/*      */       //   75: invokevirtual insertCharacterNode : (Lorg/jsoup/parser/Token$Character;)V
/*      */       //   78: goto -> 628
/*      */       //   81: aload_2
/*      */       //   82: aload_1
/*      */       //   83: invokevirtual asComment : ()Lorg/jsoup/parser/Token$Comment;
/*      */       //   86: invokevirtual insertCommentNode : (Lorg/jsoup/parser/Token$Comment;)V
/*      */       //   89: goto -> 628
/*      */       //   92: aload_2
/*      */       //   93: aload_0
/*      */       //   94: invokevirtual error : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   97: iconst_0
/*      */       //   98: ireturn
/*      */       //   99: aload_1
/*      */       //   100: invokevirtual asStartTag : ()Lorg/jsoup/parser/Token$StartTag;
/*      */       //   103: dup
/*      */       //   104: astore_3
/*      */       //   105: invokevirtual normalName : ()Ljava/lang/String;
/*      */       //   108: dup
/*      */       //   109: astore #4
/*      */       //   111: ldc 'html'
/*      */       //   113: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */       //   116: ifeq -> 128
/*      */       //   119: aload_2
/*      */       //   120: aload_3
/*      */       //   121: getstatic org/jsoup/parser/HtmlTreeBuilderState$16.InBody : Lorg/jsoup/parser/HtmlTreeBuilderState;
/*      */       //   124: invokevirtual process : (Lorg/jsoup/parser/Token;Lorg/jsoup/parser/HtmlTreeBuilderState;)Z
/*      */       //   127: ireturn
/*      */       //   128: aload #4
/*      */       //   130: ldc 'option'
/*      */       //   132: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */       //   135: ifeq -> 163
/*      */       //   138: aload_2
/*      */       //   139: ldc 'option'
/*      */       //   141: invokevirtual currentElementIs : (Ljava/lang/String;)Z
/*      */       //   144: ifeq -> 154
/*      */       //   147: aload_2
/*      */       //   148: ldc 'option'
/*      */       //   150: invokevirtual processEndTag : (Ljava/lang/String;)Z
/*      */       //   153: pop
/*      */       //   154: aload_2
/*      */       //   155: aload_3
/*      */       //   156: invokevirtual insertElementFor : (Lorg/jsoup/parser/Token$StartTag;)Lorg/jsoup/nodes/Element;
/*      */       //   159: pop
/*      */       //   160: goto -> 628
/*      */       //   163: aload #4
/*      */       //   165: ldc 'optgroup'
/*      */       //   167: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */       //   170: ifeq -> 214
/*      */       //   173: aload_2
/*      */       //   174: ldc 'option'
/*      */       //   176: invokevirtual currentElementIs : (Ljava/lang/String;)Z
/*      */       //   179: ifeq -> 189
/*      */       //   182: aload_2
/*      */       //   183: ldc 'option'
/*      */       //   185: invokevirtual processEndTag : (Ljava/lang/String;)Z
/*      */       //   188: pop
/*      */       //   189: aload_2
/*      */       //   190: ldc 'optgroup'
/*      */       //   192: invokevirtual currentElementIs : (Ljava/lang/String;)Z
/*      */       //   195: ifeq -> 205
/*      */       //   198: aload_2
/*      */       //   199: ldc 'optgroup'
/*      */       //   201: invokevirtual processEndTag : (Ljava/lang/String;)Z
/*      */       //   204: pop
/*      */       //   205: aload_2
/*      */       //   206: aload_3
/*      */       //   207: invokevirtual insertElementFor : (Lorg/jsoup/parser/Token$StartTag;)Lorg/jsoup/nodes/Element;
/*      */       //   210: pop
/*      */       //   211: goto -> 628
/*      */       //   214: aload #4
/*      */       //   216: ldc 'select'
/*      */       //   218: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */       //   221: ifeq -> 236
/*      */       //   224: aload_2
/*      */       //   225: aload_0
/*      */       //   226: invokevirtual error : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   229: aload_2
/*      */       //   230: ldc 'select'
/*      */       //   232: invokevirtual processEndTag : (Ljava/lang/String;)Z
/*      */       //   235: ireturn
/*      */       //   236: aload #4
/*      */       //   238: getstatic org/jsoup/parser/HtmlTreeBuilderState$Constants.InSelectEnd : [Ljava/lang/String;
/*      */       //   241: invokestatic inSorted : (Ljava/lang/String;[Ljava/lang/String;)Z
/*      */       //   244: ifeq -> 276
/*      */       //   247: aload_2
/*      */       //   248: aload_0
/*      */       //   249: invokevirtual error : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   252: aload_2
/*      */       //   253: ldc 'select'
/*      */       //   255: invokevirtual inSelectScope : (Ljava/lang/String;)Z
/*      */       //   258: ifne -> 263
/*      */       //   261: iconst_0
/*      */       //   262: ireturn
/*      */       //   263: aload_2
/*      */       //   264: ldc 'select'
/*      */       //   266: invokevirtual processEndTag : (Ljava/lang/String;)Z
/*      */       //   269: pop
/*      */       //   270: aload_2
/*      */       //   271: aload_3
/*      */       //   272: invokevirtual process : (Lorg/jsoup/parser/Token;)Z
/*      */       //   275: ireturn
/*      */       //   276: aload #4
/*      */       //   278: ldc 'script'
/*      */       //   280: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */       //   283: ifne -> 296
/*      */       //   286: aload #4
/*      */       //   288: ldc 'template'
/*      */       //   290: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */       //   293: ifeq -> 305
/*      */       //   296: aload_2
/*      */       //   297: aload_1
/*      */       //   298: getstatic org/jsoup/parser/HtmlTreeBuilderState$16.InHead : Lorg/jsoup/parser/HtmlTreeBuilderState;
/*      */       //   301: invokevirtual process : (Lorg/jsoup/parser/Token;Lorg/jsoup/parser/HtmlTreeBuilderState;)Z
/*      */       //   304: ireturn
/*      */       //   305: aload_0
/*      */       //   306: aload_1
/*      */       //   307: aload_2
/*      */       //   308: invokespecial anythingElse : (Lorg/jsoup/parser/Token;Lorg/jsoup/parser/HtmlTreeBuilder;)Z
/*      */       //   311: ireturn
/*      */       //   312: aload_1
/*      */       //   313: invokevirtual asEndTag : ()Lorg/jsoup/parser/Token$EndTag;
/*      */       //   316: dup
/*      */       //   317: astore_3
/*      */       //   318: invokevirtual normalName : ()Ljava/lang/String;
/*      */       //   321: dup
/*      */       //   322: astore #4
/*      */       //   324: astore_3
/*      */       //   325: iconst_m1
/*      */       //   326: istore #5
/*      */       //   328: aload_3
/*      */       //   329: invokevirtual hashCode : ()I
/*      */       //   332: lookupswitch default -> 433, -1321546630 -> 421, -1010136971 -> 391, -906021636 -> 406, -80773204 -> 376
/*      */       //   376: aload_3
/*      */       //   377: ldc 'optgroup'
/*      */       //   379: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */       //   382: ifeq -> 433
/*      */       //   385: iconst_0
/*      */       //   386: istore #5
/*      */       //   388: goto -> 433
/*      */       //   391: aload_3
/*      */       //   392: ldc 'option'
/*      */       //   394: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */       //   397: ifeq -> 433
/*      */       //   400: iconst_1
/*      */       //   401: istore #5
/*      */       //   403: goto -> 433
/*      */       //   406: aload_3
/*      */       //   407: ldc 'select'
/*      */       //   409: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */       //   412: ifeq -> 433
/*      */       //   415: iconst_2
/*      */       //   416: istore #5
/*      */       //   418: goto -> 433
/*      */       //   421: aload_3
/*      */       //   422: ldc 'template'
/*      */       //   424: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */       //   427: ifeq -> 433
/*      */       //   430: iconst_3
/*      */       //   431: istore #5
/*      */       //   433: iload #5
/*      */       //   435: tableswitch default -> 597, 0 -> 464, 1 -> 532, 2 -> 557, 3 -> 588
/*      */       //   464: aload_2
/*      */       //   465: ldc 'option'
/*      */       //   467: invokevirtual currentElementIs : (Ljava/lang/String;)Z
/*      */       //   470: ifeq -> 507
/*      */       //   473: aload_2
/*      */       //   474: dup
/*      */       //   475: invokevirtual currentElement : ()Lorg/jsoup/nodes/Element;
/*      */       //   478: invokevirtual aboveOnStack : (Lorg/jsoup/nodes/Element;)Lorg/jsoup/nodes/Element;
/*      */       //   481: ifnull -> 507
/*      */       //   484: aload_2
/*      */       //   485: dup
/*      */       //   486: invokevirtual currentElement : ()Lorg/jsoup/nodes/Element;
/*      */       //   489: invokevirtual aboveOnStack : (Lorg/jsoup/nodes/Element;)Lorg/jsoup/nodes/Element;
/*      */       //   492: ldc 'optgroup'
/*      */       //   494: invokevirtual nameIs : (Ljava/lang/String;)Z
/*      */       //   497: ifeq -> 507
/*      */       //   500: aload_2
/*      */       //   501: ldc 'option'
/*      */       //   503: invokevirtual processEndTag : (Ljava/lang/String;)Z
/*      */       //   506: pop
/*      */       //   507: aload_2
/*      */       //   508: ldc 'optgroup'
/*      */       //   510: invokevirtual currentElementIs : (Ljava/lang/String;)Z
/*      */       //   513: ifeq -> 524
/*      */       //   516: aload_2
/*      */       //   517: invokevirtual pop : ()Lorg/jsoup/nodes/Element;
/*      */       //   520: pop
/*      */       //   521: goto -> 628
/*      */       //   524: aload_2
/*      */       //   525: aload_0
/*      */       //   526: invokevirtual error : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   529: goto -> 628
/*      */       //   532: aload_2
/*      */       //   533: ldc 'option'
/*      */       //   535: invokevirtual currentElementIs : (Ljava/lang/String;)Z
/*      */       //   538: ifeq -> 549
/*      */       //   541: aload_2
/*      */       //   542: invokevirtual pop : ()Lorg/jsoup/nodes/Element;
/*      */       //   545: pop
/*      */       //   546: goto -> 628
/*      */       //   549: aload_2
/*      */       //   550: aload_0
/*      */       //   551: invokevirtual error : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   554: goto -> 628
/*      */       //   557: aload_2
/*      */       //   558: aload #4
/*      */       //   560: invokevirtual inSelectScope : (Ljava/lang/String;)Z
/*      */       //   563: ifne -> 573
/*      */       //   566: aload_2
/*      */       //   567: aload_0
/*      */       //   568: invokevirtual error : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   571: iconst_0
/*      */       //   572: ireturn
/*      */       //   573: aload_2
/*      */       //   574: aload #4
/*      */       //   576: invokevirtual popStackToClose : (Ljava/lang/String;)Lorg/jsoup/nodes/Element;
/*      */       //   579: pop
/*      */       //   580: aload_2
/*      */       //   581: invokevirtual resetInsertionMode : ()Z
/*      */       //   584: pop
/*      */       //   585: goto -> 628
/*      */       //   588: aload_2
/*      */       //   589: aload_1
/*      */       //   590: getstatic org/jsoup/parser/HtmlTreeBuilderState$16.InHead : Lorg/jsoup/parser/HtmlTreeBuilderState;
/*      */       //   593: invokevirtual process : (Lorg/jsoup/parser/Token;Lorg/jsoup/parser/HtmlTreeBuilderState;)Z
/*      */       //   596: ireturn
/*      */       //   597: aload_0
/*      */       //   598: aload_1
/*      */       //   599: aload_2
/*      */       //   600: invokespecial anythingElse : (Lorg/jsoup/parser/Token;Lorg/jsoup/parser/HtmlTreeBuilder;)Z
/*      */       //   603: ireturn
/*      */       //   604: aload_2
/*      */       //   605: ldc 'html'
/*      */       //   607: invokevirtual currentElementIs : (Ljava/lang/String;)Z
/*      */       //   610: ifne -> 628
/*      */       //   613: aload_2
/*      */       //   614: aload_0
/*      */       //   615: invokevirtual error : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   618: goto -> 628
/*      */       //   621: aload_0
/*      */       //   622: aload_1
/*      */       //   623: aload_2
/*      */       //   624: invokespecial anythingElse : (Lorg/jsoup/parser/Token;Lorg/jsoup/parser/HtmlTreeBuilder;)Z
/*      */       //   627: ireturn
/*      */       //   628: iconst_1
/*      */       //   629: ireturn
/*      */       // Line number table:
/*      */       //   Java source line number -> byte code offset
/*      */       //   #1436	-> 0
/*      */       //   #1438	-> 48
/*      */       //   #1439	-> 53
/*      */       //   #1440	-> 66
/*      */       //   #1441	-> 71
/*      */       //   #1443	-> 73
/*      */       //   #1445	-> 78
/*      */       //   #1447	-> 81
/*      */       //   #1448	-> 89
/*      */       //   #1450	-> 92
/*      */       //   #1451	-> 97
/*      */       //   #1453	-> 99
/*      */       //   #1454	-> 104
/*      */       //   #1455	-> 109
/*      */       //   #1456	-> 119
/*      */       //   #1457	-> 128
/*      */       //   #1458	-> 138
/*      */       //   #1459	-> 147
/*      */       //   #1460	-> 154
/*      */       //   #1461	-> 163
/*      */       //   #1462	-> 173
/*      */       //   #1463	-> 182
/*      */       //   #1464	-> 189
/*      */       //   #1465	-> 198
/*      */       //   #1466	-> 205
/*      */       //   #1467	-> 214
/*      */       //   #1468	-> 224
/*      */       //   #1469	-> 229
/*      */       //   #1470	-> 236
/*      */       //   #1471	-> 247
/*      */       //   #1472	-> 252
/*      */       //   #1473	-> 261
/*      */       //   #1474	-> 263
/*      */       //   #1475	-> 270
/*      */       //   #1476	-> 276
/*      */       //   #1477	-> 296
/*      */       //   #1479	-> 305
/*      */       //   #1483	-> 312
/*      */       //   #1484	-> 317
/*      */       //   #1485	-> 322
/*      */       //   #1487	-> 464
/*      */       //   #1488	-> 500
/*      */       //   #1489	-> 507
/*      */       //   #1490	-> 516
/*      */       //   #1492	-> 524
/*      */       //   #1493	-> 529
/*      */       //   #1495	-> 532
/*      */       //   #1496	-> 541
/*      */       //   #1498	-> 549
/*      */       //   #1499	-> 554
/*      */       //   #1501	-> 557
/*      */       //   #1502	-> 566
/*      */       //   #1503	-> 571
/*      */       //   #1505	-> 573
/*      */       //   #1506	-> 580
/*      */       //   #1508	-> 585
/*      */       //   #1510	-> 588
/*      */       //   #1512	-> 597
/*      */       //   #1516	-> 604
/*      */       //   #1517	-> 613
/*      */       //   #1520	-> 621
/*      */       //   #1522	-> 628
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private boolean anythingElse(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/* 1526 */       param1HtmlTreeBuilder.error(this);
/* 1527 */       return false;
/*      */     }
/*      */   },
/* 1530 */   InSelectInTable {
/*      */     final boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/* 1532 */       if (param1Token.isStartTag() && StringUtil.inSorted(param1Token.asStartTag().normalName(), Constants.InSelectTableEnd)) {
/* 1533 */         param1HtmlTreeBuilder.error(this);
/* 1534 */         param1HtmlTreeBuilder.popStackToClose("select");
/* 1535 */         param1HtmlTreeBuilder.resetInsertionMode();
/* 1536 */         return param1HtmlTreeBuilder.process(param1Token);
/* 1537 */       }  if (param1Token.isEndTag() && StringUtil.inSorted(param1Token.asEndTag().normalName(), Constants.InSelectTableEnd)) {
/* 1538 */         param1HtmlTreeBuilder.error(this);
/* 1539 */         if (param1HtmlTreeBuilder.inTableScope(param1Token.asEndTag().normalName())) {
/* 1540 */           param1HtmlTreeBuilder.popStackToClose("select");
/* 1541 */           param1HtmlTreeBuilder.resetInsertionMode();
/* 1542 */           return param1HtmlTreeBuilder.process(param1Token);
/*      */         } 
/* 1544 */         return false;
/*      */       } 
/* 1546 */       return param1HtmlTreeBuilder.process(param1Token, InSelect);
/*      */     }
/*      */   },
/*      */   
/* 1550 */   InTemplate
/*      */   {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     final boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder)
/*      */     {
/*      */       // Byte code:
/*      */       //   0: getstatic org/jsoup/parser/HtmlTreeBuilderState$25.$SwitchMap$org$jsoup$parser$Token$TokenType : [I
/*      */       //   3: aload_1
/*      */       //   4: getfield type : Lorg/jsoup/parser/Token$TokenType;
/*      */       //   7: invokevirtual ordinal : ()I
/*      */       //   10: iaload
/*      */       //   11: tableswitch default -> 361, 1 -> 48, 2 -> 48, 3 -> 60, 4 -> 261, 5 -> 48, 6 -> 297
/*      */       //   48: aload_2
/*      */       //   49: aload_1
/*      */       //   50: getstatic org/jsoup/parser/HtmlTreeBuilderState$18.InBody : Lorg/jsoup/parser/HtmlTreeBuilderState;
/*      */       //   53: invokevirtual process : (Lorg/jsoup/parser/Token;Lorg/jsoup/parser/HtmlTreeBuilderState;)Z
/*      */       //   56: pop
/*      */       //   57: goto -> 361
/*      */       //   60: aload_1
/*      */       //   61: invokevirtual asStartTag : ()Lorg/jsoup/parser/Token$StartTag;
/*      */       //   64: invokevirtual normalName : ()Ljava/lang/String;
/*      */       //   67: dup
/*      */       //   68: astore_3
/*      */       //   69: getstatic org/jsoup/parser/HtmlTreeBuilderState$Constants.InTemplateToHead : [Ljava/lang/String;
/*      */       //   72: invokestatic inSorted : (Ljava/lang/String;[Ljava/lang/String;)Z
/*      */       //   75: ifeq -> 90
/*      */       //   78: aload_2
/*      */       //   79: aload_1
/*      */       //   80: getstatic org/jsoup/parser/HtmlTreeBuilderState$18.InHead : Lorg/jsoup/parser/HtmlTreeBuilderState;
/*      */       //   83: invokevirtual process : (Lorg/jsoup/parser/Token;Lorg/jsoup/parser/HtmlTreeBuilderState;)Z
/*      */       //   86: pop
/*      */       //   87: goto -> 361
/*      */       //   90: aload_3
/*      */       //   91: getstatic org/jsoup/parser/HtmlTreeBuilderState$Constants.InTemplateToTable : [Ljava/lang/String;
/*      */       //   94: invokestatic inSorted : (Ljava/lang/String;[Ljava/lang/String;)Z
/*      */       //   97: ifeq -> 125
/*      */       //   100: aload_2
/*      */       //   101: invokevirtual popTemplateMode : ()Lorg/jsoup/parser/HtmlTreeBuilderState;
/*      */       //   104: pop
/*      */       //   105: aload_2
/*      */       //   106: getstatic org/jsoup/parser/HtmlTreeBuilderState$18.InTable : Lorg/jsoup/parser/HtmlTreeBuilderState;
/*      */       //   109: invokevirtual pushTemplateMode : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   112: aload_2
/*      */       //   113: getstatic org/jsoup/parser/HtmlTreeBuilderState$18.InTable : Lorg/jsoup/parser/HtmlTreeBuilderState;
/*      */       //   116: invokevirtual transition : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   119: aload_2
/*      */       //   120: aload_1
/*      */       //   121: invokevirtual process : (Lorg/jsoup/parser/Token;)Z
/*      */       //   124: ireturn
/*      */       //   125: aload_3
/*      */       //   126: ldc 'col'
/*      */       //   128: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */       //   131: ifeq -> 159
/*      */       //   134: aload_2
/*      */       //   135: invokevirtual popTemplateMode : ()Lorg/jsoup/parser/HtmlTreeBuilderState;
/*      */       //   138: pop
/*      */       //   139: aload_2
/*      */       //   140: getstatic org/jsoup/parser/HtmlTreeBuilderState$18.InColumnGroup : Lorg/jsoup/parser/HtmlTreeBuilderState;
/*      */       //   143: invokevirtual pushTemplateMode : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   146: aload_2
/*      */       //   147: getstatic org/jsoup/parser/HtmlTreeBuilderState$18.InColumnGroup : Lorg/jsoup/parser/HtmlTreeBuilderState;
/*      */       //   150: invokevirtual transition : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   153: aload_2
/*      */       //   154: aload_1
/*      */       //   155: invokevirtual process : (Lorg/jsoup/parser/Token;)Z
/*      */       //   158: ireturn
/*      */       //   159: aload_3
/*      */       //   160: ldc 'tr'
/*      */       //   162: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */       //   165: ifeq -> 193
/*      */       //   168: aload_2
/*      */       //   169: invokevirtual popTemplateMode : ()Lorg/jsoup/parser/HtmlTreeBuilderState;
/*      */       //   172: pop
/*      */       //   173: aload_2
/*      */       //   174: getstatic org/jsoup/parser/HtmlTreeBuilderState$18.InTableBody : Lorg/jsoup/parser/HtmlTreeBuilderState;
/*      */       //   177: invokevirtual pushTemplateMode : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   180: aload_2
/*      */       //   181: getstatic org/jsoup/parser/HtmlTreeBuilderState$18.InTableBody : Lorg/jsoup/parser/HtmlTreeBuilderState;
/*      */       //   184: invokevirtual transition : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   187: aload_2
/*      */       //   188: aload_1
/*      */       //   189: invokevirtual process : (Lorg/jsoup/parser/Token;)Z
/*      */       //   192: ireturn
/*      */       //   193: aload_3
/*      */       //   194: ldc 'td'
/*      */       //   196: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */       //   199: ifne -> 211
/*      */       //   202: aload_3
/*      */       //   203: ldc 'th'
/*      */       //   205: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */       //   208: ifeq -> 236
/*      */       //   211: aload_2
/*      */       //   212: invokevirtual popTemplateMode : ()Lorg/jsoup/parser/HtmlTreeBuilderState;
/*      */       //   215: pop
/*      */       //   216: aload_2
/*      */       //   217: getstatic org/jsoup/parser/HtmlTreeBuilderState$18.InRow : Lorg/jsoup/parser/HtmlTreeBuilderState;
/*      */       //   220: invokevirtual pushTemplateMode : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   223: aload_2
/*      */       //   224: getstatic org/jsoup/parser/HtmlTreeBuilderState$18.InRow : Lorg/jsoup/parser/HtmlTreeBuilderState;
/*      */       //   227: invokevirtual transition : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   230: aload_2
/*      */       //   231: aload_1
/*      */       //   232: invokevirtual process : (Lorg/jsoup/parser/Token;)Z
/*      */       //   235: ireturn
/*      */       //   236: aload_2
/*      */       //   237: invokevirtual popTemplateMode : ()Lorg/jsoup/parser/HtmlTreeBuilderState;
/*      */       //   240: pop
/*      */       //   241: aload_2
/*      */       //   242: getstatic org/jsoup/parser/HtmlTreeBuilderState$18.InBody : Lorg/jsoup/parser/HtmlTreeBuilderState;
/*      */       //   245: invokevirtual pushTemplateMode : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   248: aload_2
/*      */       //   249: getstatic org/jsoup/parser/HtmlTreeBuilderState$18.InBody : Lorg/jsoup/parser/HtmlTreeBuilderState;
/*      */       //   252: invokevirtual transition : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   255: aload_2
/*      */       //   256: aload_1
/*      */       //   257: invokevirtual process : (Lorg/jsoup/parser/Token;)Z
/*      */       //   260: ireturn
/*      */       //   261: aload_1
/*      */       //   262: invokevirtual asEndTag : ()Lorg/jsoup/parser/Token$EndTag;
/*      */       //   265: invokevirtual normalName : ()Ljava/lang/String;
/*      */       //   268: dup
/*      */       //   269: astore_3
/*      */       //   270: ldc 'template'
/*      */       //   272: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */       //   275: ifeq -> 290
/*      */       //   278: aload_2
/*      */       //   279: aload_1
/*      */       //   280: getstatic org/jsoup/parser/HtmlTreeBuilderState$18.InHead : Lorg/jsoup/parser/HtmlTreeBuilderState;
/*      */       //   283: invokevirtual process : (Lorg/jsoup/parser/Token;Lorg/jsoup/parser/HtmlTreeBuilderState;)Z
/*      */       //   286: pop
/*      */       //   287: goto -> 361
/*      */       //   290: aload_2
/*      */       //   291: aload_0
/*      */       //   292: invokevirtual error : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   295: iconst_0
/*      */       //   296: ireturn
/*      */       //   297: aload_2
/*      */       //   298: ldc 'template'
/*      */       //   300: invokevirtual onStack : (Ljava/lang/String;)Z
/*      */       //   303: ifne -> 308
/*      */       //   306: iconst_1
/*      */       //   307: ireturn
/*      */       //   308: aload_2
/*      */       //   309: aload_0
/*      */       //   310: invokevirtual error : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   313: aload_2
/*      */       //   314: ldc 'template'
/*      */       //   316: invokevirtual popStackToClose : (Ljava/lang/String;)Lorg/jsoup/nodes/Element;
/*      */       //   319: pop
/*      */       //   320: aload_2
/*      */       //   321: invokevirtual clearFormattingElementsToLastMarker : ()V
/*      */       //   324: aload_2
/*      */       //   325: invokevirtual popTemplateMode : ()Lorg/jsoup/parser/HtmlTreeBuilderState;
/*      */       //   328: pop
/*      */       //   329: aload_2
/*      */       //   330: invokevirtual resetInsertionMode : ()Z
/*      */       //   333: pop
/*      */       //   334: aload_2
/*      */       //   335: invokevirtual state : ()Lorg/jsoup/parser/HtmlTreeBuilderState;
/*      */       //   338: getstatic org/jsoup/parser/HtmlTreeBuilderState$18.InTemplate : Lorg/jsoup/parser/HtmlTreeBuilderState;
/*      */       //   341: if_acmpeq -> 359
/*      */       //   344: aload_2
/*      */       //   345: invokevirtual templateModeSize : ()I
/*      */       //   348: bipush #12
/*      */       //   350: if_icmpge -> 359
/*      */       //   353: aload_2
/*      */       //   354: aload_1
/*      */       //   355: invokevirtual process : (Lorg/jsoup/parser/Token;)Z
/*      */       //   358: ireturn
/*      */       //   359: iconst_1
/*      */       //   360: ireturn
/*      */       //   361: iconst_1
/*      */       //   362: ireturn
/*      */       // Line number table:
/*      */       //   Java source line number -> byte code offset
/*      */       //   #1553	-> 0
/*      */       //   #1557	-> 48
/*      */       //   #1558	-> 57
/*      */       //   #1560	-> 60
/*      */       //   #1561	-> 68
/*      */       //   #1562	-> 78
/*      */       //   #1563	-> 90
/*      */       //   #1564	-> 100
/*      */       //   #1565	-> 105
/*      */       //   #1566	-> 112
/*      */       //   #1567	-> 119
/*      */       //   #1569	-> 125
/*      */       //   #1570	-> 134
/*      */       //   #1571	-> 139
/*      */       //   #1572	-> 146
/*      */       //   #1573	-> 153
/*      */       //   #1574	-> 159
/*      */       //   #1575	-> 168
/*      */       //   #1576	-> 173
/*      */       //   #1577	-> 180
/*      */       //   #1578	-> 187
/*      */       //   #1579	-> 193
/*      */       //   #1580	-> 211
/*      */       //   #1581	-> 216
/*      */       //   #1582	-> 223
/*      */       //   #1583	-> 230
/*      */       //   #1585	-> 236
/*      */       //   #1586	-> 241
/*      */       //   #1587	-> 248
/*      */       //   #1588	-> 255
/*      */       //   #1593	-> 261
/*      */       //   #1594	-> 269
/*      */       //   #1595	-> 278
/*      */       //   #1597	-> 290
/*      */       //   #1598	-> 295
/*      */       //   #1602	-> 297
/*      */       //   #1603	-> 306
/*      */       //   #1605	-> 308
/*      */       //   #1606	-> 313
/*      */       //   #1607	-> 320
/*      */       //   #1608	-> 324
/*      */       //   #1609	-> 329
/*      */       //   #1612	-> 334
/*      */       //   #1613	-> 353
/*      */       //   #1614	-> 359
/*      */       //   #1616	-> 361
/*      */     }
/*      */   },
/* 1619 */   AfterBody {
/*      */     final boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/* 1621 */       Element element = param1HtmlTreeBuilder.getFromStack("html");
/* 1622 */       if (isWhitespace(param1Token))
/*      */       
/* 1624 */       { if (element != null)
/* 1625 */         { param1HtmlTreeBuilder.insertCharacterToElement(param1Token.asCharacter(), element); }
/*      */         else
/* 1627 */         { param1HtmlTreeBuilder.process(param1Token, InBody); }  }
/* 1628 */       else if (param1Token.isComment())
/* 1629 */       { param1HtmlTreeBuilder.insertCommentNode(param1Token.asComment()); }
/* 1630 */       else { if (param1Token.isDoctype()) {
/* 1631 */           param1HtmlTreeBuilder.error(this);
/* 1632 */           return false;
/* 1633 */         }  if (param1Token.isStartTag() && param1Token.asStartTag().normalName().equals("html"))
/* 1634 */           return param1HtmlTreeBuilder.process(param1Token, InBody); 
/* 1635 */         if (param1Token.isEndTag() && param1Token.asEndTag().normalName().equals("html")) {
/* 1636 */           if (param1HtmlTreeBuilder.isFragmentParsing()) {
/* 1637 */             param1HtmlTreeBuilder.error(this);
/* 1638 */             return false;
/*      */           } 
/* 1640 */           if (element != null) param1HtmlTreeBuilder.onNodeClosed((Node)element); 
/* 1641 */           param1HtmlTreeBuilder.transition(AfterAfterBody);
/*      */         }
/* 1643 */         else if (!param1Token.isEOF()) {
/*      */ 
/*      */           
/* 1646 */           param1HtmlTreeBuilder.error(this);
/* 1647 */           param1HtmlTreeBuilder.resetBody();
/* 1648 */           return param1HtmlTreeBuilder.process(param1Token);
/*      */         }  }
/* 1650 */        return true;
/*      */     }
/*      */   },
/* 1653 */   InFrameset {
/*      */     final boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/* 1655 */       if (isWhitespace(param1Token))
/* 1656 */       { param1HtmlTreeBuilder.insertCharacterNode(param1Token.asCharacter()); }
/* 1657 */       else if (param1Token.isComment())
/* 1658 */       { param1HtmlTreeBuilder.insertCommentNode(param1Token.asComment()); }
/* 1659 */       else { if (param1Token.isDoctype()) {
/* 1660 */           param1HtmlTreeBuilder.error(this);
/* 1661 */           return false;
/* 1662 */         }  if (param1Token.isStartTag())
/*      */         
/* 1664 */         { switch ((param1Token = param1Token.asStartTag()).normalName())
/*      */           { case "html":
/* 1666 */               return param1HtmlTreeBuilder.process(param1Token, InBody);
/*      */             case "frameset":
/* 1668 */               param1HtmlTreeBuilder.insertElementFor((Token.StartTag)param1Token);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1698 */               return true;case "frame": param1HtmlTreeBuilder.insertEmptyElementFor((Token.StartTag)param1Token); return true;case "noframes": return param1HtmlTreeBuilder.process(param1Token, InHead); }  param1HtmlTreeBuilder.error(this); return false; }  if (param1Token.isEndTag() && param1Token.asEndTag().normalName().equals("frameset")) { if (param1HtmlTreeBuilder.currentElementIs("html")) { param1HtmlTreeBuilder.error(this); return false; }  param1HtmlTreeBuilder.pop(); if (!param1HtmlTreeBuilder.isFragmentParsing() && !param1HtmlTreeBuilder.currentElementIs("frameset")) param1HtmlTreeBuilder.transition(AfterFrameset);  } else if (param1Token.isEOF()) { if (!param1HtmlTreeBuilder.currentElementIs("html")) { param1HtmlTreeBuilder.error(this); return true; }  } else { param1HtmlTreeBuilder.error(this); return false; }  }  return true;
/*      */     }
/*      */   },
/* 1701 */   AfterFrameset {
/*      */     final boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/* 1703 */       if (isWhitespace(param1Token))
/* 1704 */       { param1HtmlTreeBuilder.insertCharacterNode(param1Token.asCharacter()); }
/* 1705 */       else if (param1Token.isComment())
/* 1706 */       { param1HtmlTreeBuilder.insertCommentNode(param1Token.asComment()); }
/* 1707 */       else { if (param1Token.isDoctype()) {
/* 1708 */           param1HtmlTreeBuilder.error(this);
/* 1709 */           return false;
/* 1710 */         }  if (param1Token.isStartTag() && param1Token.asStartTag().normalName().equals("html"))
/* 1711 */           return param1HtmlTreeBuilder.process(param1Token, InBody); 
/* 1712 */         if (param1Token.isEndTag() && param1Token.asEndTag().normalName().equals("html"))
/* 1713 */         { param1HtmlTreeBuilder.transition(AfterAfterFrameset); }
/* 1714 */         else { if (param1Token.isStartTag() && param1Token.asStartTag().normalName().equals("noframes"))
/* 1715 */             return param1HtmlTreeBuilder.process(param1Token, InHead); 
/* 1716 */           if (!param1Token.isEOF())
/*      */           
/*      */           { 
/* 1719 */             param1HtmlTreeBuilder.error(this);
/* 1720 */             return false; }  }
/*      */          }
/* 1722 */        return true;
/*      */     }
/*      */   },
/* 1725 */   AfterAfterBody {
/*      */     final boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/* 1727 */       if (param1Token.isComment())
/* 1728 */       { param1HtmlTreeBuilder.insertCommentNode(param1Token.asComment()); }
/* 1729 */       else { if (param1Token.isDoctype() || (param1Token.isStartTag() && param1Token.asStartTag().normalName().equals("html")))
/* 1730 */           return param1HtmlTreeBuilder.process(param1Token, InBody); 
/* 1731 */         if (isWhitespace(param1Token)) {
/*      */           
/* 1733 */           Document document = param1HtmlTreeBuilder.getDocument();
/* 1734 */           param1HtmlTreeBuilder.insertCharacterToElement(param1Token.asCharacter(), (Element)document);
/* 1735 */         } else if (!param1Token.isEOF()) {
/*      */ 
/*      */           
/* 1738 */           param1HtmlTreeBuilder.error(this);
/* 1739 */           param1HtmlTreeBuilder.resetBody();
/* 1740 */           return param1HtmlTreeBuilder.process(param1Token);
/*      */         }  }
/* 1742 */        return true;
/*      */     }
/*      */   },
/* 1745 */   AfterAfterFrameset {
/*      */     final boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/* 1747 */       if (param1Token.isComment())
/* 1748 */       { param1HtmlTreeBuilder.insertCommentNode(param1Token.asComment()); }
/* 1749 */       else { if (param1Token.isDoctype() || isWhitespace(param1Token) || (param1Token.isStartTag() && param1Token.asStartTag().normalName().equals("html")))
/* 1750 */           return param1HtmlTreeBuilder.process(param1Token, InBody); 
/* 1751 */         if (!param1Token.isEOF()) {
/*      */           
/* 1753 */           if (param1Token.isStartTag() && param1Token.asStartTag().normalName().equals("noframes")) {
/* 1754 */             return param1HtmlTreeBuilder.process(param1Token, InHead);
/*      */           }
/* 1756 */           param1HtmlTreeBuilder.error(this);
/* 1757 */           return false;
/*      */         }  }
/* 1759 */        return true;
/*      */     }
/*      */   },
/* 1762 */   ForeignContent
/*      */   {
/*      */     final boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/*      */       // Byte code:
/*      */       //   0: getstatic org/jsoup/parser/HtmlTreeBuilderState$25.$SwitchMap$org$jsoup$parser$Token$TokenType : [I
/*      */       //   3: aload_1
/*      */       //   4: getfield type : Lorg/jsoup/parser/Token$TokenType;
/*      */       //   7: invokevirtual ordinal : ()I
/*      */       //   10: iaload
/*      */       //   11: tableswitch default -> 394, 1 -> 98, 2 -> 109, 3 -> 117, 4 -> 207, 5 -> 44
/*      */       //   44: aload_1
/*      */       //   45: invokevirtual asCharacter : ()Lorg/jsoup/parser/Token$Character;
/*      */       //   48: dup
/*      */       //   49: astore_1
/*      */       //   50: invokevirtual getData : ()Ljava/lang/String;
/*      */       //   53: invokestatic access$400 : ()Ljava/lang/String;
/*      */       //   56: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */       //   59: ifeq -> 70
/*      */       //   62: aload_2
/*      */       //   63: aload_0
/*      */       //   64: invokevirtual error : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   67: goto -> 394
/*      */       //   70: aload_1
/*      */       //   71: invokestatic access$100 : (Lorg/jsoup/parser/Token;)Z
/*      */       //   74: ifeq -> 85
/*      */       //   77: aload_2
/*      */       //   78: aload_1
/*      */       //   79: invokevirtual insertCharacterNode : (Lorg/jsoup/parser/Token$Character;)V
/*      */       //   82: goto -> 394
/*      */       //   85: aload_2
/*      */       //   86: aload_1
/*      */       //   87: invokevirtual insertCharacterNode : (Lorg/jsoup/parser/Token$Character;)V
/*      */       //   90: aload_2
/*      */       //   91: iconst_0
/*      */       //   92: invokevirtual framesetOk : (Z)V
/*      */       //   95: goto -> 394
/*      */       //   98: aload_2
/*      */       //   99: aload_1
/*      */       //   100: invokevirtual asComment : ()Lorg/jsoup/parser/Token$Comment;
/*      */       //   103: invokevirtual insertCommentNode : (Lorg/jsoup/parser/Token$Comment;)V
/*      */       //   106: goto -> 394
/*      */       //   109: aload_2
/*      */       //   110: aload_0
/*      */       //   111: invokevirtual error : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   114: goto -> 394
/*      */       //   117: aload_1
/*      */       //   118: invokevirtual asStartTag : ()Lorg/jsoup/parser/Token$StartTag;
/*      */       //   121: dup
/*      */       //   122: astore_3
/*      */       //   123: getfield normalName : Ljava/lang/String;
/*      */       //   126: getstatic org/jsoup/parser/HtmlTreeBuilderState$Constants.InForeignToHtml : [Ljava/lang/String;
/*      */       //   129: invokestatic in : (Ljava/lang/String;[Ljava/lang/String;)Z
/*      */       //   132: ifeq -> 142
/*      */       //   135: aload_0
/*      */       //   136: aload_1
/*      */       //   137: aload_2
/*      */       //   138: invokevirtual processAsHtml : (Lorg/jsoup/parser/Token;Lorg/jsoup/parser/HtmlTreeBuilder;)Z
/*      */       //   141: ireturn
/*      */       //   142: aload_3
/*      */       //   143: getfield normalName : Ljava/lang/String;
/*      */       //   146: ldc 'font'
/*      */       //   148: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */       //   151: ifeq -> 188
/*      */       //   154: aload_3
/*      */       //   155: ldc 'color'
/*      */       //   157: invokevirtual hasAttributeIgnoreCase : (Ljava/lang/String;)Z
/*      */       //   160: ifne -> 181
/*      */       //   163: aload_3
/*      */       //   164: ldc 'face'
/*      */       //   166: invokevirtual hasAttributeIgnoreCase : (Ljava/lang/String;)Z
/*      */       //   169: ifne -> 181
/*      */       //   172: aload_3
/*      */       //   173: ldc 'size'
/*      */       //   175: invokevirtual hasAttributeIgnoreCase : (Ljava/lang/String;)Z
/*      */       //   178: ifeq -> 188
/*      */       //   181: aload_0
/*      */       //   182: aload_1
/*      */       //   183: aload_2
/*      */       //   184: invokevirtual processAsHtml : (Lorg/jsoup/parser/Token;Lorg/jsoup/parser/HtmlTreeBuilder;)Z
/*      */       //   187: ireturn
/*      */       //   188: aload_2
/*      */       //   189: aload_3
/*      */       //   190: aload_2
/*      */       //   191: invokevirtual currentElement : ()Lorg/jsoup/nodes/Element;
/*      */       //   194: invokevirtual tag : ()Lorg/jsoup/parser/Tag;
/*      */       //   197: invokevirtual namespace : ()Ljava/lang/String;
/*      */       //   200: invokevirtual insertForeignElementFor : (Lorg/jsoup/parser/Token$StartTag;Ljava/lang/String;)Lorg/jsoup/nodes/Element;
/*      */       //   203: pop
/*      */       //   204: goto -> 394
/*      */       //   207: aload_1
/*      */       //   208: invokevirtual asEndTag : ()Lorg/jsoup/parser/Token$EndTag;
/*      */       //   211: dup
/*      */       //   212: astore_3
/*      */       //   213: getfield normalName : Ljava/lang/String;
/*      */       //   216: ldc 'br'
/*      */       //   218: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */       //   221: ifne -> 236
/*      */       //   224: aload_3
/*      */       //   225: getfield normalName : Ljava/lang/String;
/*      */       //   228: ldc 'p'
/*      */       //   230: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */       //   233: ifeq -> 243
/*      */       //   236: aload_0
/*      */       //   237: aload_1
/*      */       //   238: aload_2
/*      */       //   239: invokevirtual processAsHtml : (Lorg/jsoup/parser/Token;Lorg/jsoup/parser/HtmlTreeBuilder;)Z
/*      */       //   242: ireturn
/*      */       //   243: aload_3
/*      */       //   244: getfield normalName : Ljava/lang/String;
/*      */       //   247: ldc 'script'
/*      */       //   249: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */       //   252: ifeq -> 273
/*      */       //   255: aload_2
/*      */       //   256: ldc 'script'
/*      */       //   258: ldc 'http://www.w3.org/2000/svg'
/*      */       //   260: invokevirtual currentElementIs : (Ljava/lang/String;Ljava/lang/String;)Z
/*      */       //   263: ifeq -> 273
/*      */       //   266: aload_2
/*      */       //   267: invokevirtual pop : ()Lorg/jsoup/nodes/Element;
/*      */       //   270: pop
/*      */       //   271: iconst_1
/*      */       //   272: ireturn
/*      */       //   273: aload_2
/*      */       //   274: invokevirtual getStack : ()Ljava/util/ArrayList;
/*      */       //   277: dup
/*      */       //   278: astore #4
/*      */       //   280: invokevirtual isEmpty : ()Z
/*      */       //   283: ifeq -> 291
/*      */       //   286: ldc 'Stack unexpectedly empty'
/*      */       //   288: invokestatic wtf : (Ljava/lang/String;)V
/*      */       //   291: aload #4
/*      */       //   293: invokevirtual size : ()I
/*      */       //   296: iconst_1
/*      */       //   297: isub
/*      */       //   298: istore #5
/*      */       //   300: aload #4
/*      */       //   302: iload #5
/*      */       //   304: invokevirtual get : (I)Ljava/lang/Object;
/*      */       //   307: checkcast org/jsoup/nodes/Element
/*      */       //   310: dup
/*      */       //   311: astore #6
/*      */       //   313: aload_3
/*      */       //   314: getfield normalName : Ljava/lang/String;
/*      */       //   317: invokevirtual nameIs : (Ljava/lang/String;)Z
/*      */       //   320: ifne -> 328
/*      */       //   323: aload_2
/*      */       //   324: aload_0
/*      */       //   325: invokevirtual error : (Lorg/jsoup/parser/HtmlTreeBuilderState;)V
/*      */       //   328: iload #5
/*      */       //   330: ifeq -> 394
/*      */       //   333: aload #6
/*      */       //   335: aload_3
/*      */       //   336: getfield normalName : Ljava/lang/String;
/*      */       //   339: invokevirtual nameIs : (Ljava/lang/String;)Z
/*      */       //   342: ifeq -> 357
/*      */       //   345: aload_2
/*      */       //   346: aload #6
/*      */       //   348: invokevirtual normalName : ()Ljava/lang/String;
/*      */       //   351: invokevirtual popStackToCloseAnyNamespace : (Ljava/lang/String;)Lorg/jsoup/nodes/Element;
/*      */       //   354: pop
/*      */       //   355: iconst_1
/*      */       //   356: ireturn
/*      */       //   357: iinc #5, -1
/*      */       //   360: aload #4
/*      */       //   362: iload #5
/*      */       //   364: invokevirtual get : (I)Ljava/lang/Object;
/*      */       //   367: checkcast org/jsoup/nodes/Element
/*      */       //   370: dup
/*      */       //   371: astore #6
/*      */       //   373: invokevirtual tag : ()Lorg/jsoup/parser/Tag;
/*      */       //   376: invokevirtual namespace : ()Ljava/lang/String;
/*      */       //   379: ldc 'http://www.w3.org/1999/xhtml'
/*      */       //   381: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */       //   384: ifeq -> 328
/*      */       //   387: aload_0
/*      */       //   388: aload_1
/*      */       //   389: aload_2
/*      */       //   390: invokevirtual processAsHtml : (Lorg/jsoup/parser/Token;Lorg/jsoup/parser/HtmlTreeBuilder;)Z
/*      */       //   393: ireturn
/*      */       //   394: iconst_1
/*      */       //   395: ireturn
/*      */       // Line number table:
/*      */       //   Java source line number -> byte code offset
/*      */       //   #1765	-> 0
/*      */       //   #1767	-> 44
/*      */       //   #1768	-> 49
/*      */       //   #1769	-> 62
/*      */       //   #1770	-> 70
/*      */       //   #1771	-> 77
/*      */       //   #1773	-> 85
/*      */       //   #1774	-> 90
/*      */       //   #1776	-> 95
/*      */       //   #1778	-> 98
/*      */       //   #1779	-> 106
/*      */       //   #1781	-> 109
/*      */       //   #1782	-> 114
/*      */       //   #1784	-> 117
/*      */       //   #1785	-> 122
/*      */       //   #1786	-> 135
/*      */       //   #1787	-> 142
/*      */       //   #1788	-> 157
/*      */       //   #1789	-> 166
/*      */       //   #1790	-> 175
/*      */       //   #1791	-> 181
/*      */       //   #1795	-> 188
/*      */       //   #1798	-> 204
/*      */       //   #1801	-> 207
/*      */       //   #1802	-> 212
/*      */       //   #1803	-> 236
/*      */       //   #1804	-> 243
/*      */       //   #1806	-> 266
/*      */       //   #1807	-> 271
/*      */       //   #1811	-> 273
/*      */       //   #1812	-> 278
/*      */       //   #1813	-> 286
/*      */       //   #1814	-> 291
/*      */       //   #1815	-> 300
/*      */       //   #1816	-> 311
/*      */       //   #1817	-> 323
/*      */       //   #1818	-> 328
/*      */       //   #1819	-> 333
/*      */       //   #1820	-> 345
/*      */       //   #1821	-> 355
/*      */       //   #1823	-> 357
/*      */       //   #1824	-> 360
/*      */       //   #1825	-> 371
/*      */       //   #1826	-> 387
/*      */       //   #1835	-> 394
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     final boolean processAsHtml(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/* 1839 */       return param1HtmlTreeBuilder.state().process(param1Token, param1HtmlTreeBuilder);
/*      */     } };
/*      */   private static final String nullString;
/*      */   static {
/* 1843 */     nullString = "\000";
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean isWhitespace(Token paramToken) {
/* 1848 */     if (paramToken.isCharacter()) {
/*      */       String str;
/* 1850 */       return StringUtil.isBlank(str = paramToken.asCharacter().getData());
/*      */     } 
/* 1852 */     return false;
/*      */   }
/*      */   
/*      */   private static void handleRcData(Token.StartTag paramStartTag, HtmlTreeBuilder paramHtmlTreeBuilder) {
/* 1856 */     paramHtmlTreeBuilder.tokeniser.transition(TokeniserState.Rcdata);
/* 1857 */     paramHtmlTreeBuilder.markInsertionMode();
/* 1858 */     paramHtmlTreeBuilder.transition(Text);
/* 1859 */     paramHtmlTreeBuilder.insertElementFor(paramStartTag);
/*      */   }
/*      */   
/*      */   private static void handleRawtext(Token.StartTag paramStartTag, HtmlTreeBuilder paramHtmlTreeBuilder) {
/* 1863 */     paramHtmlTreeBuilder.tokeniser.transition(TokeniserState.Rawtext);
/* 1864 */     paramHtmlTreeBuilder.markInsertionMode();
/* 1865 */     paramHtmlTreeBuilder.transition(Text);
/* 1866 */     paramHtmlTreeBuilder.insertElementFor(paramStartTag);
/*      */   }
/*      */   
/*      */   abstract boolean process(Token paramToken, HtmlTreeBuilder paramHtmlTreeBuilder);
/*      */   
/* 1871 */   static final class Constants { static final String[] InHeadEmpty = new String[] { "base", "basefont", "bgsound", "command", "link" };
/* 1872 */     static final String[] InHeadRaw = new String[] { "noframes", "style" };
/* 1873 */     static final String[] InHeadEnd = new String[] { "body", "br", "html" };
/* 1874 */     static final String[] AfterHeadBody = new String[] { "body", "br", "html" };
/* 1875 */     static final String[] BeforeHtmlToHead = new String[] { "body", "br", "head", "html" };
/* 1876 */     static final String[] InHeadNoScriptHead = new String[] { "basefont", "bgsound", "link", "meta", "noframes", "style" };
/* 1877 */     static final String[] InBodyStartToHead = new String[] { "base", "basefont", "bgsound", "command", "link", "meta", "noframes", "script", "style", "template", "title" };
/* 1878 */     static final String[] InBodyStartPClosers = new String[] { "address", "article", "aside", "blockquote", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "menu", "nav", "ol", "p", "section", "summary", "ul" };
/*      */ 
/*      */     
/* 1881 */     static final String[] Headings = new String[] { "h1", "h2", "h3", "h4", "h5", "h6" };
/* 1882 */     static final String[] InBodyStartLiBreakers = new String[] { "address", "div", "p" };
/* 1883 */     static final String[] DdDt = new String[] { "dd", "dt" };
/* 1884 */     static final String[] InBodyStartApplets = new String[] { "applet", "marquee", "object" };
/* 1885 */     static final String[] InBodyStartMedia = new String[] { "param", "source", "track" };
/* 1886 */     static final String[] InBodyStartInputAttribs = new String[] { "action", "name", "prompt" };
/* 1887 */     static final String[] InBodyStartDrop = new String[] { "caption", "col", "colgroup", "frame", "head", "tbody", "td", "tfoot", "th", "thead", "tr" };
/* 1888 */     static final String[] InBodyEndClosers = new String[] { "address", "article", "aside", "blockquote", "button", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "listing", "menu", "nav", "ol", "pre", "section", "summary", "ul" };
/*      */ 
/*      */     
/* 1891 */     static final String[] InBodyEndOtherErrors = new String[] { "body", "dd", "dt", "html", "li", "optgroup", "option", "p", "rb", "rp", "rt", "rtc", "tbody", "td", "tfoot", "th", "thead", "tr" };
/* 1892 */     static final String[] InBodyEndAdoptionFormatters = new String[] { "a", "b", "big", "code", "em", "font", "i", "nobr", "s", "small", "strike", "strong", "tt", "u" };
/* 1893 */     static final String[] InBodyEndTableFosters = new String[] { "table", "tbody", "tfoot", "thead", "tr" };
/* 1894 */     static final String[] InTableToBody = new String[] { "tbody", "tfoot", "thead" };
/* 1895 */     static final String[] InTableAddBody = new String[] { "td", "th", "tr" };
/* 1896 */     static final String[] InTableToHead = new String[] { "script", "style", "template" };
/* 1897 */     static final String[] InCellNames = new String[] { "td", "th" };
/* 1898 */     static final String[] InCellBody = new String[] { "body", "caption", "col", "colgroup", "html" };
/* 1899 */     static final String[] InCellTable = new String[] { "table", "tbody", "tfoot", "thead", "tr" };
/* 1900 */     static final String[] InCellCol = new String[] { "caption", "col", "colgroup", "tbody", "td", "tfoot", "th", "thead", "tr" };
/* 1901 */     static final String[] InTableEndErr = new String[] { "body", "caption", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr" };
/* 1902 */     static final String[] InTableFoster = new String[] { "table", "tbody", "tfoot", "thead", "tr" };
/* 1903 */     static final String[] InTableBodyExit = new String[] { "caption", "col", "colgroup", "tbody", "tfoot", "thead" };
/* 1904 */     static final String[] InTableBodyEndIgnore = new String[] { "body", "caption", "col", "colgroup", "html", "td", "th", "tr" };
/* 1905 */     static final String[] InRowMissing = new String[] { "caption", "col", "colgroup", "tbody", "tfoot", "thead", "tr" };
/* 1906 */     static final String[] InRowIgnore = new String[] { "body", "caption", "col", "colgroup", "html", "td", "th" };
/* 1907 */     static final String[] InSelectEnd = new String[] { "input", "keygen", "textarea" };
/* 1908 */     static final String[] InSelectTableEnd = new String[] { "caption", "table", "tbody", "td", "tfoot", "th", "thead", "tr" };
/* 1909 */     static final String[] InTableEndIgnore = new String[] { "tbody", "tfoot", "thead" };
/* 1910 */     static final String[] InHeadNoscriptIgnore = new String[] { "head", "noscript" };
/* 1911 */     static final String[] InCaptionIgnore = new String[] { "body", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr" };
/* 1912 */     static final String[] InTemplateToHead = new String[] { "base", "basefont", "bgsound", "link", "meta", "noframes", "script", "style", "template", "title" };
/* 1913 */     static final String[] InTemplateToTable = new String[] { "caption", "colgroup", "tbody", "tfoot", "thead" };
/* 1914 */     static final String[] InForeignToHtml = new String[] { "b", "big", "blockquote", "body", "br", "center", "code", "dd", "div", "dl", "dt", "em", "embed", "h1", "h2", "h3", "h4", "h5", "h6", "head", "hr", "i", "img", "li", "listing", "menu", "meta", "nobr", "ol", "p", "pre", "ruby", "s", "small", "span", "strike", "strong", "sub", "sup", "table", "tt", "u", "ul", "var" }; }
/*      */ 
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\parser\HtmlTreeBuilderState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */