/*      */ package org.jsoup.parser;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ enum TokeniserState
/*      */ {
/*    9 */   Data
/*      */   {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*   12 */       switch (param1CharacterReader.current()) {
/*      */         case '&':
/*   14 */           param1Tokeniser.advanceTransition(CharacterReferenceInData);
/*      */           return;
/*      */         case '<':
/*   17 */           param1Tokeniser.advanceTransition(TagOpen);
/*      */           return;
/*      */         case '\000':
/*   20 */           param1Tokeniser.error(this);
/*   21 */           param1Tokeniser.emit(param1CharacterReader.consume());
/*      */           return;
/*      */         case '￿':
/*   24 */           param1Tokeniser.emit(new Token.EOF());
/*      */           return;
/*      */       } 
/*   27 */       String str = param1CharacterReader.consumeData();
/*   28 */       param1Tokeniser.emit(str);
/*      */     }
/*      */   },
/*      */ 
/*      */   
/*   33 */   CharacterReferenceInData
/*      */   {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*   36 */       readCharRef(param1Tokeniser, Data);
/*      */     }
/*      */   },
/*   39 */   Rcdata
/*      */   {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*   42 */       switch (param1CharacterReader.current()) {
/*      */         case '&':
/*   44 */           param1Tokeniser.advanceTransition(CharacterReferenceInRcdata);
/*      */           return;
/*      */         case '<':
/*   47 */           param1Tokeniser.advanceTransition(RcdataLessthanSign);
/*      */           return;
/*      */         case '\000':
/*   50 */           param1Tokeniser.error(this);
/*   51 */           param1CharacterReader.advance();
/*   52 */           param1Tokeniser.emit('�');
/*      */           return;
/*      */         case '￿':
/*   55 */           param1Tokeniser.emit(new Token.EOF());
/*      */           return;
/*      */       } 
/*   58 */       String str = param1CharacterReader.consumeData();
/*   59 */       param1Tokeniser.emit(str);
/*      */     }
/*      */   },
/*      */ 
/*      */   
/*   64 */   CharacterReferenceInRcdata {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*   66 */       readCharRef(param1Tokeniser, Rcdata);
/*      */     }
/*      */   },
/*   69 */   Rawtext {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*   71 */       readRawData(param1Tokeniser, param1CharacterReader, this, RawtextLessthanSign);
/*      */     }
/*      */   },
/*   74 */   ScriptData {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*   76 */       readRawData(param1Tokeniser, param1CharacterReader, this, ScriptDataLessthanSign);
/*      */     }
/*      */   },
/*   79 */   PLAINTEXT {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*   81 */       switch (param1CharacterReader.current()) {
/*      */         case '\000':
/*   83 */           param1Tokeniser.error(this);
/*   84 */           param1CharacterReader.advance();
/*   85 */           param1Tokeniser.emit('�');
/*      */           return;
/*      */         case '￿':
/*   88 */           param1Tokeniser.emit(new Token.EOF());
/*      */           return;
/*      */       } 
/*   91 */       String str = param1CharacterReader.consumeTo(false);
/*   92 */       param1Tokeniser.emit(str);
/*      */     }
/*      */   },
/*      */ 
/*      */   
/*   97 */   TagOpen
/*      */   {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  100 */       switch (param1CharacterReader.current()) {
/*      */         case '!':
/*  102 */           param1Tokeniser.advanceTransition(MarkupDeclarationOpen);
/*      */           return;
/*      */         case '/':
/*  105 */           param1Tokeniser.advanceTransition(EndTagOpen);
/*      */           return;
/*      */         case '?':
/*  108 */           param1Tokeniser.createBogusCommentPending();
/*  109 */           param1Tokeniser.transition(BogusComment);
/*      */           return;
/*      */       } 
/*  112 */       if (param1CharacterReader.matchesAsciiAlpha()) {
/*  113 */         param1Tokeniser.createTagPending(true);
/*  114 */         param1Tokeniser.transition(TagName); return;
/*      */       } 
/*  116 */       param1Tokeniser.error(this);
/*  117 */       param1Tokeniser.emit('<');
/*  118 */       param1Tokeniser.transition(Data);
/*      */     }
/*      */   },
/*      */ 
/*      */ 
/*      */   
/*  124 */   EndTagOpen {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  126 */       if (param1CharacterReader.isEmpty()) {
/*  127 */         param1Tokeniser.eofError(this);
/*  128 */         param1Tokeniser.emit("</");
/*  129 */         param1Tokeniser.transition(Data); return;
/*  130 */       }  if (param1CharacterReader.matchesAsciiAlpha()) {
/*  131 */         param1Tokeniser.createTagPending(false);
/*  132 */         param1Tokeniser.transition(TagName); return;
/*  133 */       }  if (param1CharacterReader.matches('>')) {
/*  134 */         param1Tokeniser.error(this);
/*  135 */         param1Tokeniser.advanceTransition(Data); return;
/*      */       } 
/*  137 */       param1Tokeniser.error(this);
/*  138 */       param1Tokeniser.createBogusCommentPending();
/*  139 */       param1Tokeniser.commentPending.append('/');
/*  140 */       param1Tokeniser.transition(BogusComment);
/*      */     }
/*      */   },
/*      */   
/*  144 */   TagName
/*      */   {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader)
/*      */     {
/*  148 */       String str = param1CharacterReader.consumeTagName();
/*  149 */       param1Tokeniser.tagPending.appendTagName(str);
/*      */       
/*      */       char c;
/*  152 */       switch (c = param1CharacterReader.consume()) {
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\f':
/*      */         case '\r':
/*      */         case ' ':
/*  158 */           param1Tokeniser.transition(BeforeAttributeName);
/*      */           return;
/*      */         case '/':
/*  161 */           param1Tokeniser.transition(SelfClosingStartTag);
/*      */           return;
/*      */         case '<':
/*  164 */           param1CharacterReader.unconsume();
/*  165 */           param1Tokeniser.error(this);
/*      */         
/*      */         case '>':
/*  168 */           param1Tokeniser.emitTagPending();
/*  169 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '\000':
/*  172 */           param1Tokeniser.tagPending.appendTagName(TokeniserState.replacementStr);
/*      */           return;
/*      */         case '￿':
/*  175 */           param1Tokeniser.eofError(this);
/*  176 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/*  179 */       param1Tokeniser.tagPending.appendTagName(c);
/*      */     }
/*      */   },
/*      */   
/*  183 */   RcdataLessthanSign
/*      */   {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  186 */       if (param1CharacterReader.matches('/')) {
/*  187 */         param1Tokeniser.createTempBuffer();
/*  188 */         param1Tokeniser.advanceTransition(RCDATAEndTagOpen); return;
/*  189 */       }  if (param1CharacterReader.readFully() && param1CharacterReader.matchesAsciiAlpha() && param1Tokeniser.appropriateEndTagName() != null && !param1CharacterReader.containsIgnoreCase(param1Tokeniser.appropriateEndTagSeq())) {
/*      */ 
/*      */         
/*  192 */         param1Tokeniser.tagPending = param1Tokeniser.createTagPending(false).name(param1Tokeniser.appropriateEndTagName());
/*  193 */         param1Tokeniser.emitTagPending();
/*  194 */         param1Tokeniser.transition(TagOpen); return;
/*      */       } 
/*  196 */       param1Tokeniser.emit("<");
/*  197 */       param1Tokeniser.transition(Rcdata);
/*      */     }
/*      */   },
/*      */   
/*  201 */   RCDATAEndTagOpen {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  203 */       if (param1CharacterReader.matchesAsciiAlpha()) {
/*  204 */         param1Tokeniser.createTagPending(false);
/*  205 */         param1Tokeniser.tagPending.appendTagName(param1CharacterReader.current());
/*  206 */         param1Tokeniser.dataBuffer.append(param1CharacterReader.current());
/*  207 */         param1Tokeniser.advanceTransition(RCDATAEndTagName); return;
/*      */       } 
/*  209 */       param1Tokeniser.emit("</");
/*  210 */       param1Tokeniser.transition(Rcdata);
/*      */     }
/*      */   },
/*      */   
/*  214 */   RCDATAEndTagName {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  216 */       if (param1CharacterReader.matchesAsciiAlpha()) {
/*  217 */         String str = param1CharacterReader.consumeLetterSequence();
/*  218 */         param1Tokeniser.tagPending.appendTagName(str);
/*  219 */         param1Tokeniser.dataBuffer.append(str);
/*      */         
/*      */         return;
/*      */       } 
/*      */       char c;
/*  224 */       switch (c = param1CharacterReader.consume()) {
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\f':
/*      */         case '\r':
/*      */         case ' ':
/*  230 */           if (param1Tokeniser.isAppropriateEndTagToken()) {
/*  231 */             param1Tokeniser.transition(BeforeAttributeName); return;
/*      */           } 
/*  233 */           anythingElse(param1Tokeniser, param1CharacterReader);
/*      */           return;
/*      */         case '/':
/*  236 */           if (param1Tokeniser.isAppropriateEndTagToken()) {
/*  237 */             param1Tokeniser.transition(SelfClosingStartTag); return;
/*      */           } 
/*  239 */           anythingElse(param1Tokeniser, param1CharacterReader);
/*      */           return;
/*      */         case '>':
/*  242 */           if (param1Tokeniser.isAppropriateEndTagToken()) {
/*  243 */             param1Tokeniser.emitTagPending();
/*  244 */             param1Tokeniser.transition(Data);
/*      */             return;
/*      */           } 
/*  247 */           anythingElse(param1Tokeniser, param1CharacterReader);
/*      */           return;
/*      */       } 
/*  250 */       anythingElse(param1Tokeniser, param1CharacterReader);
/*      */     }
/*      */ 
/*      */     
/*      */     private void anythingElse(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  255 */       param1Tokeniser.emit("</");
/*  256 */       param1Tokeniser.emit(param1Tokeniser.dataBuffer);
/*  257 */       param1CharacterReader.unconsume();
/*  258 */       param1Tokeniser.transition(Rcdata);
/*      */     }
/*      */   },
/*  261 */   RawtextLessthanSign {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  263 */       if (param1CharacterReader.matches('/')) {
/*  264 */         param1Tokeniser.createTempBuffer();
/*  265 */         param1Tokeniser.advanceTransition(RawtextEndTagOpen); return;
/*      */       } 
/*  267 */       param1Tokeniser.emit('<');
/*  268 */       param1Tokeniser.transition(Rawtext);
/*      */     }
/*      */   },
/*      */   
/*  272 */   RawtextEndTagOpen {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  274 */       readEndTag(param1Tokeniser, param1CharacterReader, RawtextEndTagName, Rawtext);
/*      */     }
/*      */   },
/*  277 */   RawtextEndTagName {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  279 */       handleDataEndTag(param1Tokeniser, param1CharacterReader, Rawtext);
/*      */     }
/*      */   },
/*  282 */   ScriptDataLessthanSign {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  284 */       switch (param1CharacterReader.consume()) {
/*      */         case '/':
/*  286 */           param1Tokeniser.createTempBuffer();
/*  287 */           param1Tokeniser.transition(ScriptDataEndTagOpen);
/*      */           return;
/*      */         case '!':
/*  290 */           param1Tokeniser.emit("<!");
/*  291 */           param1Tokeniser.transition(ScriptDataEscapeStart);
/*      */           return;
/*      */         case '￿':
/*  294 */           param1Tokeniser.emit("<");
/*  295 */           param1Tokeniser.eofError(this);
/*  296 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/*  299 */       param1Tokeniser.emit("<");
/*  300 */       param1CharacterReader.unconsume();
/*  301 */       param1Tokeniser.transition(ScriptData);
/*      */     }
/*      */   },
/*      */   
/*  305 */   ScriptDataEndTagOpen {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  307 */       readEndTag(param1Tokeniser, param1CharacterReader, ScriptDataEndTagName, ScriptData);
/*      */     }
/*      */   },
/*  310 */   ScriptDataEndTagName {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  312 */       handleDataEndTag(param1Tokeniser, param1CharacterReader, ScriptData);
/*      */     }
/*      */   },
/*  315 */   ScriptDataEscapeStart {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  317 */       if (param1CharacterReader.matches('-')) {
/*  318 */         param1Tokeniser.emit('-');
/*  319 */         param1Tokeniser.advanceTransition(ScriptDataEscapeStartDash); return;
/*      */       } 
/*  321 */       param1Tokeniser.transition(ScriptData);
/*      */     }
/*      */   },
/*      */   
/*  325 */   ScriptDataEscapeStartDash {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  327 */       if (param1CharacterReader.matches('-')) {
/*  328 */         param1Tokeniser.emit('-');
/*  329 */         param1Tokeniser.advanceTransition(ScriptDataEscapedDashDash); return;
/*      */       } 
/*  331 */       param1Tokeniser.transition(ScriptData);
/*      */     }
/*      */   },
/*      */   
/*  335 */   ScriptDataEscaped {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  337 */       if (param1CharacterReader.isEmpty()) {
/*  338 */         param1Tokeniser.eofError(this);
/*  339 */         param1Tokeniser.transition(Data);
/*      */         
/*      */         return;
/*      */       } 
/*  343 */       switch (param1CharacterReader.current()) {
/*      */         case '-':
/*  345 */           param1Tokeniser.emit('-');
/*  346 */           param1Tokeniser.advanceTransition(ScriptDataEscapedDash);
/*      */           return;
/*      */         case '<':
/*  349 */           param1Tokeniser.advanceTransition(ScriptDataEscapedLessthanSign);
/*      */           return;
/*      */         case '\000':
/*  352 */           param1Tokeniser.error(this);
/*  353 */           param1CharacterReader.advance();
/*  354 */           param1Tokeniser.emit('�');
/*      */           return;
/*      */       } 
/*  357 */       String str = param1CharacterReader.consumeToAny(new char[] { '-', '<', Character.MIN_VALUE });
/*  358 */       param1Tokeniser.emit(str);
/*      */     }
/*      */   },
/*      */   
/*  362 */   ScriptDataEscapedDash {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  364 */       if (param1CharacterReader.isEmpty()) {
/*  365 */         param1Tokeniser.eofError(this);
/*  366 */         param1Tokeniser.transition(Data);
/*      */         
/*      */         return;
/*      */       } 
/*      */       char c;
/*  371 */       switch (c = param1CharacterReader.consume()) {
/*      */         case '-':
/*  373 */           param1Tokeniser.emit(c);
/*  374 */           param1Tokeniser.transition(ScriptDataEscapedDashDash);
/*      */           return;
/*      */         case '<':
/*  377 */           param1Tokeniser.transition(ScriptDataEscapedLessthanSign);
/*      */           return;
/*      */         case '\000':
/*  380 */           param1Tokeniser.error(this);
/*  381 */           param1Tokeniser.emit('�');
/*  382 */           param1Tokeniser.transition(ScriptDataEscaped);
/*      */           return;
/*      */       } 
/*  385 */       param1Tokeniser.emit(c);
/*  386 */       param1Tokeniser.transition(ScriptDataEscaped);
/*      */     }
/*      */   },
/*      */   
/*  390 */   ScriptDataEscapedDashDash {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  392 */       if (param1CharacterReader.isEmpty()) {
/*  393 */         param1Tokeniser.eofError(this);
/*  394 */         param1Tokeniser.transition(Data);
/*      */         
/*      */         return;
/*      */       } 
/*      */       char c;
/*  399 */       switch (c = param1CharacterReader.consume()) {
/*      */         case '-':
/*  401 */           param1Tokeniser.emit(c);
/*      */           return;
/*      */         case '<':
/*  404 */           param1Tokeniser.transition(ScriptDataEscapedLessthanSign);
/*      */           return;
/*      */         case '>':
/*  407 */           param1Tokeniser.emit(c);
/*  408 */           param1Tokeniser.transition(ScriptData);
/*      */           return;
/*      */         case '\000':
/*  411 */           param1Tokeniser.error(this);
/*  412 */           param1Tokeniser.emit('�');
/*  413 */           param1Tokeniser.transition(ScriptDataEscaped);
/*      */           return;
/*      */       } 
/*  416 */       param1Tokeniser.emit(c);
/*  417 */       param1Tokeniser.transition(ScriptDataEscaped);
/*      */     }
/*      */   },
/*      */   
/*  421 */   ScriptDataEscapedLessthanSign {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  423 */       if (param1CharacterReader.matchesAsciiAlpha()) {
/*  424 */         param1Tokeniser.createTempBuffer();
/*  425 */         param1Tokeniser.dataBuffer.append(param1CharacterReader.current());
/*  426 */         param1Tokeniser.emit("<");
/*  427 */         param1Tokeniser.emit(param1CharacterReader.current());
/*  428 */         param1Tokeniser.advanceTransition(ScriptDataDoubleEscapeStart); return;
/*  429 */       }  if (param1CharacterReader.matches('/')) {
/*  430 */         param1Tokeniser.createTempBuffer();
/*  431 */         param1Tokeniser.advanceTransition(ScriptDataEscapedEndTagOpen); return;
/*      */       } 
/*  433 */       param1Tokeniser.emit('<');
/*  434 */       param1Tokeniser.transition(ScriptDataEscaped);
/*      */     }
/*      */   },
/*      */   
/*  438 */   ScriptDataEscapedEndTagOpen {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  440 */       if (param1CharacterReader.matchesAsciiAlpha()) {
/*  441 */         param1Tokeniser.createTagPending(false);
/*  442 */         param1Tokeniser.tagPending.appendTagName(param1CharacterReader.current());
/*  443 */         param1Tokeniser.dataBuffer.append(param1CharacterReader.current());
/*  444 */         param1Tokeniser.advanceTransition(ScriptDataEscapedEndTagName); return;
/*      */       } 
/*  446 */       param1Tokeniser.emit("</");
/*  447 */       param1Tokeniser.transition(ScriptDataEscaped);
/*      */     }
/*      */   },
/*      */   
/*  451 */   ScriptDataEscapedEndTagName {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  453 */       handleDataEndTag(param1Tokeniser, param1CharacterReader, ScriptDataEscaped);
/*      */     }
/*      */   },
/*  456 */   ScriptDataDoubleEscapeStart {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  458 */       handleDataDoubleEscapeTag(param1Tokeniser, param1CharacterReader, ScriptDataDoubleEscaped, ScriptDataEscaped);
/*      */     }
/*      */   },
/*  461 */   ScriptDataDoubleEscaped {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*      */       char c;
/*  464 */       switch (c = param1CharacterReader.current()) {
/*      */         case '-':
/*  466 */           param1Tokeniser.emit(c);
/*  467 */           param1Tokeniser.advanceTransition(ScriptDataDoubleEscapedDash);
/*      */           return;
/*      */         case '<':
/*  470 */           param1Tokeniser.emit(c);
/*  471 */           param1Tokeniser.advanceTransition(ScriptDataDoubleEscapedLessthanSign);
/*      */           return;
/*      */         case '\000':
/*  474 */           param1Tokeniser.error(this);
/*  475 */           param1CharacterReader.advance();
/*  476 */           param1Tokeniser.emit('�');
/*      */           return;
/*      */         case '￿':
/*  479 */           param1Tokeniser.eofError(this);
/*  480 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/*  483 */       String str = param1CharacterReader.consumeToAny(new char[] { '-', '<', Character.MIN_VALUE });
/*  484 */       param1Tokeniser.emit(str);
/*      */     }
/*      */   },
/*      */   
/*  488 */   ScriptDataDoubleEscapedDash {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*      */       char c;
/*  491 */       switch (c = param1CharacterReader.consume()) {
/*      */         case '-':
/*  493 */           param1Tokeniser.emit(c);
/*  494 */           param1Tokeniser.transition(ScriptDataDoubleEscapedDashDash);
/*      */           return;
/*      */         case '<':
/*  497 */           param1Tokeniser.emit(c);
/*  498 */           param1Tokeniser.transition(ScriptDataDoubleEscapedLessthanSign);
/*      */           return;
/*      */         case '\000':
/*  501 */           param1Tokeniser.error(this);
/*  502 */           param1Tokeniser.emit('�');
/*  503 */           param1Tokeniser.transition(ScriptDataDoubleEscaped);
/*      */           return;
/*      */         case '￿':
/*  506 */           param1Tokeniser.eofError(this);
/*  507 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/*  510 */       param1Tokeniser.emit(c);
/*  511 */       param1Tokeniser.transition(ScriptDataDoubleEscaped);
/*      */     }
/*      */   },
/*      */   
/*  515 */   ScriptDataDoubleEscapedDashDash {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*      */       char c;
/*  518 */       switch (c = param1CharacterReader.consume()) {
/*      */         case '-':
/*  520 */           param1Tokeniser.emit(c);
/*      */           return;
/*      */         case '<':
/*  523 */           param1Tokeniser.emit(c);
/*  524 */           param1Tokeniser.transition(ScriptDataDoubleEscapedLessthanSign);
/*      */           return;
/*      */         case '>':
/*  527 */           param1Tokeniser.emit(c);
/*  528 */           param1Tokeniser.transition(ScriptData);
/*      */           return;
/*      */         case '\000':
/*  531 */           param1Tokeniser.error(this);
/*  532 */           param1Tokeniser.emit('�');
/*  533 */           param1Tokeniser.transition(ScriptDataDoubleEscaped);
/*      */           return;
/*      */         case '￿':
/*  536 */           param1Tokeniser.eofError(this);
/*  537 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/*  540 */       param1Tokeniser.emit(c);
/*  541 */       param1Tokeniser.transition(ScriptDataDoubleEscaped);
/*      */     }
/*      */   },
/*      */   
/*  545 */   ScriptDataDoubleEscapedLessthanSign {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  547 */       if (param1CharacterReader.matches('/')) {
/*  548 */         param1Tokeniser.emit('/');
/*  549 */         param1Tokeniser.createTempBuffer();
/*  550 */         param1Tokeniser.advanceTransition(ScriptDataDoubleEscapeEnd); return;
/*      */       } 
/*  552 */       param1Tokeniser.transition(ScriptDataDoubleEscaped);
/*      */     }
/*      */   },
/*      */   
/*  556 */   ScriptDataDoubleEscapeEnd {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  558 */       handleDataDoubleEscapeTag(param1Tokeniser, param1CharacterReader, ScriptDataEscaped, ScriptDataDoubleEscaped);
/*      */     }
/*      */   },
/*  561 */   BeforeAttributeName
/*      */   {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*      */       char c;
/*  565 */       switch (c = param1CharacterReader.consume()) {
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\f':
/*      */         case '\r':
/*      */         case ' ':
/*      */           return;
/*      */         case '/':
/*  573 */           param1Tokeniser.transition(SelfClosingStartTag);
/*      */           return;
/*      */         case '<':
/*  576 */           param1CharacterReader.unconsume();
/*  577 */           param1Tokeniser.error(this);
/*      */         
/*      */         case '>':
/*  580 */           param1Tokeniser.emitTagPending();
/*  581 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '\000':
/*  584 */           param1CharacterReader.unconsume();
/*  585 */           param1Tokeniser.error(this);
/*  586 */           param1Tokeniser.tagPending.newAttribute();
/*  587 */           param1Tokeniser.transition(AttributeName);
/*      */           return;
/*      */         case '￿':
/*  590 */           param1Tokeniser.eofError(this);
/*  591 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '"':
/*      */         case '\'':
/*      */         case '=':
/*  596 */           param1Tokeniser.error(this);
/*  597 */           param1Tokeniser.tagPending.newAttribute();
/*  598 */           param1Tokeniser.tagPending.appendAttributeName(c, param1CharacterReader.pos() - 1, param1CharacterReader.pos());
/*  599 */           param1Tokeniser.transition(AttributeName);
/*      */           return;
/*      */       } 
/*  602 */       param1Tokeniser.tagPending.newAttribute();
/*  603 */       param1CharacterReader.unconsume();
/*  604 */       param1Tokeniser.transition(AttributeName);
/*      */     }
/*      */   },
/*      */   
/*  608 */   AttributeName
/*      */   {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  611 */       int i = param1CharacterReader.pos();
/*  612 */       String str = param1CharacterReader.consumeToAnySorted(attributeNameCharsSorted);
/*  613 */       param1Tokeniser.tagPending.appendAttributeName(str, i, param1CharacterReader.pos());
/*      */       
/*  615 */       i = param1CharacterReader.pos();
/*      */       char c;
/*  617 */       switch (c = param1CharacterReader.consume()) {
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\f':
/*      */         case '\r':
/*      */         case ' ':
/*  623 */           param1Tokeniser.transition(AfterAttributeName);
/*      */           return;
/*      */         case '/':
/*  626 */           param1Tokeniser.transition(SelfClosingStartTag);
/*      */           return;
/*      */         case '=':
/*  629 */           param1Tokeniser.transition(BeforeAttributeValue);
/*      */           return;
/*      */         case '>':
/*  632 */           param1Tokeniser.emitTagPending();
/*  633 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '￿':
/*  636 */           param1Tokeniser.eofError(this);
/*  637 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '"':
/*      */         case '\'':
/*      */         case '<':
/*  642 */           param1Tokeniser.error(this);
/*      */           break;
/*      */       } 
/*      */       
/*  646 */       param1Tokeniser.tagPending.appendAttributeName(c, i, param1CharacterReader.pos());
/*      */     }
/*      */   },
/*      */   
/*  650 */   AfterAttributeName {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*      */       char c;
/*  653 */       switch (c = param1CharacterReader.consume()) {
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\f':
/*      */         case '\r':
/*      */         case ' ':
/*      */           return;
/*      */         
/*      */         case '/':
/*  662 */           param1Tokeniser.transition(SelfClosingStartTag);
/*      */           return;
/*      */         case '=':
/*  665 */           param1Tokeniser.transition(BeforeAttributeValue);
/*      */           return;
/*      */         case '>':
/*  668 */           param1Tokeniser.emitTagPending();
/*  669 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '\000':
/*  672 */           param1Tokeniser.error(this);
/*  673 */           param1Tokeniser.tagPending.appendAttributeName('�', param1CharacterReader.pos() - 1, param1CharacterReader.pos());
/*  674 */           param1Tokeniser.transition(AttributeName);
/*      */           return;
/*      */         case '￿':
/*  677 */           param1Tokeniser.eofError(this);
/*  678 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '"':
/*      */         case '\'':
/*      */         case '<':
/*  683 */           param1Tokeniser.error(this);
/*  684 */           param1Tokeniser.tagPending.newAttribute();
/*  685 */           param1Tokeniser.tagPending.appendAttributeName(c, param1CharacterReader.pos() - 1, param1CharacterReader.pos());
/*  686 */           param1Tokeniser.transition(AttributeName);
/*      */           return;
/*      */       } 
/*  689 */       param1Tokeniser.tagPending.newAttribute();
/*  690 */       param1CharacterReader.unconsume();
/*  691 */       param1Tokeniser.transition(AttributeName);
/*      */     }
/*      */   },
/*      */   
/*  695 */   BeforeAttributeValue {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*      */       char c;
/*  698 */       switch (c = param1CharacterReader.consume()) {
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\f':
/*      */         case '\r':
/*      */         case ' ':
/*      */           return;
/*      */         
/*      */         case '"':
/*  707 */           param1Tokeniser.transition(AttributeValue_doubleQuoted);
/*      */           return;
/*      */         case '&':
/*  710 */           param1CharacterReader.unconsume();
/*  711 */           param1Tokeniser.transition(AttributeValue_unquoted);
/*      */           return;
/*      */         case '\'':
/*  714 */           param1Tokeniser.transition(AttributeValue_singleQuoted);
/*      */           return;
/*      */         case '\000':
/*  717 */           param1Tokeniser.error(this);
/*  718 */           param1Tokeniser.tagPending.appendAttributeValue('�', param1CharacterReader.pos() - 1, param1CharacterReader.pos());
/*  719 */           param1Tokeniser.transition(AttributeValue_unquoted);
/*      */           return;
/*      */         case '￿':
/*  722 */           param1Tokeniser.eofError(this);
/*  723 */           param1Tokeniser.emitTagPending();
/*  724 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '>':
/*  727 */           param1Tokeniser.error(this);
/*  728 */           param1Tokeniser.emitTagPending();
/*  729 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '<':
/*      */         case '=':
/*      */         case '`':
/*  734 */           param1Tokeniser.error(this);
/*  735 */           param1Tokeniser.tagPending.appendAttributeValue(c, param1CharacterReader.pos() - 1, param1CharacterReader.pos());
/*  736 */           param1Tokeniser.transition(AttributeValue_unquoted);
/*      */           return;
/*      */       } 
/*  739 */       param1CharacterReader.unconsume();
/*  740 */       param1Tokeniser.transition(AttributeValue_unquoted);
/*      */     }
/*      */   },
/*      */   
/*  744 */   AttributeValue_doubleQuoted {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  746 */       int arrayOfInt[], i = param1CharacterReader.pos();
/*      */       String str;
/*  748 */       if ((str = param1CharacterReader.consumeAttributeQuoted(false)).length() > 0) {
/*  749 */         param1Tokeniser.tagPending.appendAttributeValue(str, i, param1CharacterReader.pos());
/*      */       } else {
/*  751 */         param1Tokeniser.tagPending.setEmptyAttributeValue();
/*      */       } 
/*  753 */       i = param1CharacterReader.pos();
/*      */       char c;
/*  755 */       switch (c = param1CharacterReader.consume()) {
/*      */         case '"':
/*  757 */           param1Tokeniser.transition(AfterAttributeValue_quoted);
/*      */           return;
/*      */         
/*      */         case '&':
/*  761 */           if ((arrayOfInt = param1Tokeniser.consumeCharacterReference(Character.valueOf('"'), true)) != null) {
/*  762 */             param1Tokeniser.tagPending.appendAttributeValue(arrayOfInt, i, param1CharacterReader.pos()); return;
/*      */           } 
/*  764 */           param1Tokeniser.tagPending.appendAttributeValue('&', i, param1CharacterReader.pos());
/*      */           return;
/*      */         case '\000':
/*  767 */           param1Tokeniser.error(this);
/*  768 */           param1Tokeniser.tagPending.appendAttributeValue('�', i, param1CharacterReader.pos());
/*      */           return;
/*      */         case '￿':
/*  771 */           param1Tokeniser.eofError(this);
/*  772 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/*  775 */       param1Tokeniser.tagPending.appendAttributeValue(arrayOfInt, i, param1CharacterReader.pos());
/*      */     }
/*      */   },
/*      */   
/*  779 */   AttributeValue_singleQuoted {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  781 */       int arrayOfInt[], i = param1CharacterReader.pos();
/*      */       String str;
/*  783 */       if ((str = param1CharacterReader.consumeAttributeQuoted(true)).length() > 0) {
/*  784 */         param1Tokeniser.tagPending.appendAttributeValue(str, i, param1CharacterReader.pos());
/*      */       } else {
/*  786 */         param1Tokeniser.tagPending.setEmptyAttributeValue();
/*      */       } 
/*  788 */       i = param1CharacterReader.pos();
/*      */       char c;
/*  790 */       switch (c = param1CharacterReader.consume()) {
/*      */         case '\'':
/*  792 */           param1Tokeniser.transition(AfterAttributeValue_quoted);
/*      */           return;
/*      */         
/*      */         case '&':
/*  796 */           if ((arrayOfInt = param1Tokeniser.consumeCharacterReference(Character.valueOf('\''), true)) != null) {
/*  797 */             param1Tokeniser.tagPending.appendAttributeValue(arrayOfInt, i, param1CharacterReader.pos()); return;
/*      */           } 
/*  799 */           param1Tokeniser.tagPending.appendAttributeValue('&', i, param1CharacterReader.pos());
/*      */           return;
/*      */         case '\000':
/*  802 */           param1Tokeniser.error(this);
/*  803 */           param1Tokeniser.tagPending.appendAttributeValue('�', i, param1CharacterReader.pos());
/*      */           return;
/*      */         case '￿':
/*  806 */           param1Tokeniser.eofError(this);
/*  807 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/*  810 */       param1Tokeniser.tagPending.appendAttributeValue(arrayOfInt, i, param1CharacterReader.pos());
/*      */     }
/*      */   },
/*      */   
/*  814 */   AttributeValue_unquoted {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  816 */       int arrayOfInt[], i = param1CharacterReader.pos();
/*      */       String str;
/*  818 */       if ((str = param1CharacterReader.consumeToAnySorted(attributeValueUnquoted)).length() > 0) {
/*  819 */         param1Tokeniser.tagPending.appendAttributeValue(str, i, param1CharacterReader.pos());
/*      */       }
/*  821 */       i = param1CharacterReader.pos();
/*      */       char c;
/*  823 */       switch (c = param1CharacterReader.consume()) {
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\f':
/*      */         case '\r':
/*      */         case ' ':
/*  829 */           param1Tokeniser.transition(BeforeAttributeName);
/*      */           return;
/*      */         
/*      */         case '&':
/*  833 */           if ((arrayOfInt = param1Tokeniser.consumeCharacterReference(Character.valueOf('>'), true)) != null) {
/*  834 */             param1Tokeniser.tagPending.appendAttributeValue(arrayOfInt, i, param1CharacterReader.pos()); return;
/*      */           } 
/*  836 */           param1Tokeniser.tagPending.appendAttributeValue('&', i, param1CharacterReader.pos());
/*      */           return;
/*      */         case '>':
/*  839 */           param1Tokeniser.emitTagPending();
/*  840 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '\000':
/*  843 */           param1Tokeniser.error(this);
/*  844 */           param1Tokeniser.tagPending.appendAttributeValue('�', i, param1CharacterReader.pos());
/*      */           return;
/*      */         case '￿':
/*  847 */           param1Tokeniser.eofError(this);
/*  848 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '"':
/*      */         case '\'':
/*      */         case '<':
/*      */         case '=':
/*      */         case '`':
/*  855 */           param1Tokeniser.error(this);
/*      */           break;
/*      */       } 
/*      */       
/*  859 */       param1Tokeniser.tagPending.appendAttributeValue(arrayOfInt, i, param1CharacterReader.pos());
/*      */     }
/*      */   },
/*      */ 
/*      */ 
/*      */   
/*  865 */   AfterAttributeValue_quoted {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*      */       char c;
/*  868 */       switch (c = param1CharacterReader.consume()) {
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\f':
/*      */         case '\r':
/*      */         case ' ':
/*  874 */           param1Tokeniser.transition(BeforeAttributeName);
/*      */           return;
/*      */         case '/':
/*  877 */           param1Tokeniser.transition(SelfClosingStartTag);
/*      */           return;
/*      */         case '>':
/*  880 */           param1Tokeniser.emitTagPending();
/*  881 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '￿':
/*  884 */           param1Tokeniser.eofError(this);
/*  885 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/*  888 */       param1CharacterReader.unconsume();
/*  889 */       param1Tokeniser.error(this);
/*  890 */       param1Tokeniser.transition(BeforeAttributeName);
/*      */     }
/*      */   },
/*      */ 
/*      */   
/*  895 */   SelfClosingStartTag {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*      */       char c;
/*  898 */       switch (c = param1CharacterReader.consume()) {
/*      */         case '>':
/*  900 */           param1Tokeniser.tagPending.selfClosing = true;
/*  901 */           param1Tokeniser.emitTagPending();
/*  902 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '￿':
/*  905 */           param1Tokeniser.eofError(this);
/*  906 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/*  909 */       param1CharacterReader.unconsume();
/*  910 */       param1Tokeniser.error(this);
/*  911 */       param1Tokeniser.transition(BeforeAttributeName);
/*      */     }
/*      */   },
/*      */   
/*  915 */   BogusComment
/*      */   {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  918 */       param1Tokeniser.commentPending.append(param1CharacterReader.consumeTo('>'));
/*      */       
/*      */       char c;
/*  921 */       if ((c = param1CharacterReader.current()) == '>' || c == Character.MAX_VALUE) {
/*  922 */         param1CharacterReader.consume();
/*  923 */         param1Tokeniser.emitCommentPending();
/*  924 */         param1Tokeniser.transition(Data);
/*      */       } 
/*      */     }
/*      */   },
/*  928 */   MarkupDeclarationOpen {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  930 */       if (param1CharacterReader.matchConsume("--")) {
/*  931 */         param1Tokeniser.createCommentPending();
/*  932 */         param1Tokeniser.transition(CommentStart); return;
/*  933 */       }  if (param1CharacterReader.matchConsumeIgnoreCase("DOCTYPE")) {
/*  934 */         param1Tokeniser.transition(Doctype); return;
/*  935 */       }  if (param1CharacterReader.matchConsume("[CDATA[")) {
/*      */ 
/*      */ 
/*      */         
/*  939 */         param1Tokeniser.createTempBuffer();
/*  940 */         param1Tokeniser.transition(CdataSection); return;
/*      */       } 
/*  942 */       param1Tokeniser.error(this);
/*  943 */       param1Tokeniser.createBogusCommentPending();
/*  944 */       param1Tokeniser.transition(BogusComment);
/*      */     }
/*      */   },
/*      */   
/*  948 */   CommentStart {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*      */       char c;
/*  951 */       switch (c = param1CharacterReader.consume()) {
/*      */         case '-':
/*  953 */           param1Tokeniser.transition(CommentStartDash);
/*      */           return;
/*      */         case '\000':
/*  956 */           param1Tokeniser.error(this);
/*  957 */           param1Tokeniser.commentPending.append('�');
/*  958 */           param1Tokeniser.transition(Comment);
/*      */           return;
/*      */         case '>':
/*  961 */           param1Tokeniser.error(this);
/*  962 */           param1Tokeniser.emitCommentPending();
/*  963 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '￿':
/*  966 */           param1Tokeniser.eofError(this);
/*  967 */           param1Tokeniser.emitCommentPending();
/*  968 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/*  971 */       param1CharacterReader.unconsume();
/*  972 */       param1Tokeniser.transition(Comment);
/*      */     }
/*      */   },
/*      */   
/*  976 */   CommentStartDash {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*      */       char c;
/*  979 */       switch (c = param1CharacterReader.consume()) {
/*      */         case '-':
/*  981 */           param1Tokeniser.transition(CommentEnd);
/*      */           return;
/*      */         case '\000':
/*  984 */           param1Tokeniser.error(this);
/*  985 */           param1Tokeniser.commentPending.append('�');
/*  986 */           param1Tokeniser.transition(Comment);
/*      */           return;
/*      */         case '>':
/*  989 */           param1Tokeniser.error(this);
/*  990 */           param1Tokeniser.emitCommentPending();
/*  991 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '￿':
/*  994 */           param1Tokeniser.eofError(this);
/*  995 */           param1Tokeniser.emitCommentPending();
/*  996 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/*  999 */       param1Tokeniser.commentPending.append(c);
/* 1000 */       param1Tokeniser.transition(Comment);
/*      */     }
/*      */   },
/*      */   
/* 1004 */   Comment {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*      */       char c;
/* 1007 */       switch (c = param1CharacterReader.current()) {
/*      */         case '-':
/* 1009 */           param1Tokeniser.advanceTransition(CommentEndDash);
/*      */           return;
/*      */         case '\000':
/* 1012 */           param1Tokeniser.error(this);
/* 1013 */           param1CharacterReader.advance();
/* 1014 */           param1Tokeniser.commentPending.append('�');
/*      */           return;
/*      */         case '￿':
/* 1017 */           param1Tokeniser.eofError(this);
/* 1018 */           param1Tokeniser.emitCommentPending();
/* 1019 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/* 1022 */       param1Tokeniser.commentPending.append(param1CharacterReader.consumeToAny(new char[] { '-', Character.MIN_VALUE
/*      */             }));
/*      */     }
/*      */   },
/* 1026 */   CommentEndDash {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*      */       char c;
/* 1029 */       switch (c = param1CharacterReader.consume()) {
/*      */         case '-':
/* 1031 */           param1Tokeniser.transition(CommentEnd);
/*      */           return;
/*      */         case '\000':
/* 1034 */           param1Tokeniser.error(this);
/* 1035 */           param1Tokeniser.commentPending.append('-').append('�');
/* 1036 */           param1Tokeniser.transition(Comment);
/*      */           return;
/*      */         case '￿':
/* 1039 */           param1Tokeniser.eofError(this);
/* 1040 */           param1Tokeniser.emitCommentPending();
/* 1041 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/* 1044 */       param1Tokeniser.commentPending.append('-').append(c);
/* 1045 */       param1Tokeniser.transition(Comment);
/*      */     }
/*      */   },
/*      */   
/* 1049 */   CommentEnd {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*      */       char c;
/* 1052 */       switch (c = param1CharacterReader.consume()) {
/*      */         case '>':
/* 1054 */           param1Tokeniser.emitCommentPending();
/* 1055 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '\000':
/* 1058 */           param1Tokeniser.error(this);
/* 1059 */           param1Tokeniser.commentPending.append("--").append('�');
/* 1060 */           param1Tokeniser.transition(Comment);
/*      */           return;
/*      */         case '!':
/* 1063 */           param1Tokeniser.transition(CommentEndBang);
/*      */           return;
/*      */         case '-':
/* 1066 */           param1Tokeniser.commentPending.append('-');
/*      */           return;
/*      */         case '￿':
/* 1069 */           param1Tokeniser.eofError(this);
/* 1070 */           param1Tokeniser.emitCommentPending();
/* 1071 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/* 1074 */       param1Tokeniser.commentPending.append("--").append(c);
/* 1075 */       param1Tokeniser.transition(Comment);
/*      */     }
/*      */   },
/*      */   
/* 1079 */   CommentEndBang {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*      */       char c;
/* 1082 */       switch (c = param1CharacterReader.consume()) {
/*      */         case '-':
/* 1084 */           param1Tokeniser.commentPending.append("--!");
/* 1085 */           param1Tokeniser.transition(CommentEndDash);
/*      */           return;
/*      */         case '>':
/* 1088 */           param1Tokeniser.emitCommentPending();
/* 1089 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '\000':
/* 1092 */           param1Tokeniser.error(this);
/* 1093 */           param1Tokeniser.commentPending.append("--!").append('�');
/* 1094 */           param1Tokeniser.transition(Comment);
/*      */           return;
/*      */         case '￿':
/* 1097 */           param1Tokeniser.eofError(this);
/* 1098 */           param1Tokeniser.emitCommentPending();
/* 1099 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/* 1102 */       param1Tokeniser.commentPending.append("--!").append(c);
/* 1103 */       param1Tokeniser.transition(Comment);
/*      */     }
/*      */   },
/*      */   
/* 1107 */   Doctype {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*      */       char c;
/* 1110 */       switch (c = param1CharacterReader.consume()) {
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\f':
/*      */         case '\r':
/*      */         case ' ':
/* 1116 */           param1Tokeniser.transition(BeforeDoctypeName);
/*      */           return;
/*      */         case '￿':
/* 1119 */           param1Tokeniser.eofError(this);
/*      */         
/*      */         case '>':
/* 1122 */           param1Tokeniser.error(this);
/* 1123 */           param1Tokeniser.createDoctypePending();
/* 1124 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1125 */           param1Tokeniser.emitDoctypePending();
/* 1126 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/* 1129 */       param1Tokeniser.error(this);
/* 1130 */       param1Tokeniser.transition(BeforeDoctypeName);
/*      */     }
/*      */   },
/*      */   
/* 1134 */   BeforeDoctypeName {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/* 1136 */       if (param1CharacterReader.matchesAsciiAlpha()) {
/* 1137 */         param1Tokeniser.createDoctypePending();
/* 1138 */         param1Tokeniser.transition(DoctypeName);
/*      */         return;
/*      */       } 
/*      */       char c;
/* 1142 */       switch (c = param1CharacterReader.consume()) {
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\f':
/*      */         case '\r':
/*      */         case ' ':
/*      */           return;
/*      */         case '\000':
/* 1150 */           param1Tokeniser.error(this);
/* 1151 */           param1Tokeniser.createDoctypePending();
/* 1152 */           param1Tokeniser.doctypePending.name.append('�');
/* 1153 */           param1Tokeniser.transition(DoctypeName);
/*      */           return;
/*      */         case '￿':
/* 1156 */           param1Tokeniser.eofError(this);
/* 1157 */           param1Tokeniser.createDoctypePending();
/* 1158 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1159 */           param1Tokeniser.emitDoctypePending();
/* 1160 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/* 1163 */       param1Tokeniser.createDoctypePending();
/* 1164 */       param1Tokeniser.doctypePending.name.append(c);
/* 1165 */       param1Tokeniser.transition(DoctypeName);
/*      */     }
/*      */   },
/*      */   
/* 1169 */   DoctypeName { final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*      */       String str;
/* 1171 */       if (param1CharacterReader.matchesLetter()) {
/* 1172 */         str = param1CharacterReader.consumeLetterSequence();
/* 1173 */         param1Tokeniser.doctypePending.name.append(str);
/*      */         return;
/*      */       } 
/*      */       char c;
/* 1177 */       switch (c = str.consume()) {
/*      */         case '>':
/* 1179 */           param1Tokeniser.emitDoctypePending();
/* 1180 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\f':
/*      */         case '\r':
/*      */         case ' ':
/* 1187 */           param1Tokeniser.transition(AfterDoctypeName);
/*      */           return;
/*      */         case '\000':
/* 1190 */           param1Tokeniser.error(this);
/* 1191 */           param1Tokeniser.doctypePending.name.append('�');
/*      */           return;
/*      */         case '￿':
/* 1194 */           param1Tokeniser.eofError(this);
/* 1195 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1196 */           param1Tokeniser.emitDoctypePending();
/* 1197 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/* 1200 */       param1Tokeniser.doctypePending.name.append(c);
/*      */     } }
/*      */   ,
/*      */   
/* 1204 */   AfterDoctypeName {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/* 1206 */       if (param1CharacterReader.isEmpty()) {
/* 1207 */         param1Tokeniser.eofError(this);
/* 1208 */         param1Tokeniser.doctypePending.forceQuirks = true;
/* 1209 */         param1Tokeniser.emitDoctypePending();
/* 1210 */         param1Tokeniser.transition(Data);
/*      */         return;
/*      */       } 
/* 1213 */       if (param1CharacterReader.matchesAny(new char[] { '\t', '\n', '\r', '\f', ' ' })) {
/* 1214 */         param1CharacterReader.advance(); return;
/* 1215 */       }  if (param1CharacterReader.matches('>')) {
/* 1216 */         param1Tokeniser.emitDoctypePending();
/* 1217 */         param1Tokeniser.advanceTransition(Data); return;
/* 1218 */       }  if (param1CharacterReader.matchConsumeIgnoreCase("PUBLIC")) {
/* 1219 */         param1Tokeniser.doctypePending.pubSysKey = "PUBLIC";
/* 1220 */         param1Tokeniser.transition(AfterDoctypePublicKeyword); return;
/* 1221 */       }  if (param1CharacterReader.matchConsumeIgnoreCase("SYSTEM")) {
/* 1222 */         param1Tokeniser.doctypePending.pubSysKey = "SYSTEM";
/* 1223 */         param1Tokeniser.transition(AfterDoctypeSystemKeyword); return;
/*      */       } 
/* 1225 */       param1Tokeniser.error(this);
/* 1226 */       param1Tokeniser.doctypePending.forceQuirks = true;
/* 1227 */       param1Tokeniser.advanceTransition(BogusDoctype);
/*      */     }
/*      */   },
/*      */ 
/*      */   
/* 1232 */   AfterDoctypePublicKeyword {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*      */       char c;
/* 1235 */       switch (c = param1CharacterReader.consume()) {
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\f':
/*      */         case '\r':
/*      */         case ' ':
/* 1241 */           param1Tokeniser.transition(BeforeDoctypePublicIdentifier);
/*      */           return;
/*      */         case '"':
/* 1244 */           param1Tokeniser.error(this);
/*      */           
/* 1246 */           param1Tokeniser.transition(DoctypePublicIdentifier_doubleQuoted);
/*      */           return;
/*      */         case '\'':
/* 1249 */           param1Tokeniser.error(this);
/*      */           
/* 1251 */           param1Tokeniser.transition(DoctypePublicIdentifier_singleQuoted);
/*      */           return;
/*      */         case '>':
/* 1254 */           param1Tokeniser.error(this);
/* 1255 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1256 */           param1Tokeniser.emitDoctypePending();
/* 1257 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '￿':
/* 1260 */           param1Tokeniser.eofError(this);
/* 1261 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1262 */           param1Tokeniser.emitDoctypePending();
/* 1263 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/* 1266 */       param1Tokeniser.error(this);
/* 1267 */       param1Tokeniser.doctypePending.forceQuirks = true;
/* 1268 */       param1Tokeniser.transition(BogusDoctype);
/*      */     }
/*      */   },
/*      */   
/* 1272 */   BeforeDoctypePublicIdentifier {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*      */       char c;
/* 1275 */       switch (c = param1CharacterReader.consume()) {
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\f':
/*      */         case '\r':
/*      */         case ' ':
/*      */           return;
/*      */         
/*      */         case '"':
/* 1284 */           param1Tokeniser.transition(DoctypePublicIdentifier_doubleQuoted);
/*      */           return;
/*      */         
/*      */         case '\'':
/* 1288 */           param1Tokeniser.transition(DoctypePublicIdentifier_singleQuoted);
/*      */           return;
/*      */         case '>':
/* 1291 */           param1Tokeniser.error(this);
/* 1292 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1293 */           param1Tokeniser.emitDoctypePending();
/* 1294 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '￿':
/* 1297 */           param1Tokeniser.eofError(this);
/* 1298 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1299 */           param1Tokeniser.emitDoctypePending();
/* 1300 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/* 1303 */       param1Tokeniser.error(this);
/* 1304 */       param1Tokeniser.doctypePending.forceQuirks = true;
/* 1305 */       param1Tokeniser.transition(BogusDoctype);
/*      */     }
/*      */   },
/*      */   
/* 1309 */   DoctypePublicIdentifier_doubleQuoted {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*      */       char c;
/* 1312 */       switch (c = param1CharacterReader.consume()) {
/*      */         case '"':
/* 1314 */           param1Tokeniser.transition(AfterDoctypePublicIdentifier);
/*      */           return;
/*      */         case '\000':
/* 1317 */           param1Tokeniser.error(this);
/* 1318 */           param1Tokeniser.doctypePending.publicIdentifier.append('�');
/*      */           return;
/*      */         case '>':
/* 1321 */           param1Tokeniser.error(this);
/* 1322 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1323 */           param1Tokeniser.emitDoctypePending();
/* 1324 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '￿':
/* 1327 */           param1Tokeniser.eofError(this);
/* 1328 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1329 */           param1Tokeniser.emitDoctypePending();
/* 1330 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/* 1333 */       param1Tokeniser.doctypePending.publicIdentifier.append(c);
/*      */     }
/*      */   },
/*      */   
/* 1337 */   DoctypePublicIdentifier_singleQuoted {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*      */       char c;
/* 1340 */       switch (c = param1CharacterReader.consume()) {
/*      */         case '\'':
/* 1342 */           param1Tokeniser.transition(AfterDoctypePublicIdentifier);
/*      */           return;
/*      */         case '\000':
/* 1345 */           param1Tokeniser.error(this);
/* 1346 */           param1Tokeniser.doctypePending.publicIdentifier.append('�');
/*      */           return;
/*      */         case '>':
/* 1349 */           param1Tokeniser.error(this);
/* 1350 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1351 */           param1Tokeniser.emitDoctypePending();
/* 1352 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '￿':
/* 1355 */           param1Tokeniser.eofError(this);
/* 1356 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1357 */           param1Tokeniser.emitDoctypePending();
/* 1358 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/* 1361 */       param1Tokeniser.doctypePending.publicIdentifier.append(c);
/*      */     }
/*      */   },
/*      */   
/* 1365 */   AfterDoctypePublicIdentifier {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*      */       char c;
/* 1368 */       switch (c = param1CharacterReader.consume()) {
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\f':
/*      */         case '\r':
/*      */         case ' ':
/* 1374 */           param1Tokeniser.transition(BetweenDoctypePublicAndSystemIdentifiers);
/*      */           return;
/*      */         case '>':
/* 1377 */           param1Tokeniser.emitDoctypePending();
/* 1378 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '"':
/* 1381 */           param1Tokeniser.error(this);
/*      */           
/* 1383 */           param1Tokeniser.transition(DoctypeSystemIdentifier_doubleQuoted);
/*      */           return;
/*      */         case '\'':
/* 1386 */           param1Tokeniser.error(this);
/*      */           
/* 1388 */           param1Tokeniser.transition(DoctypeSystemIdentifier_singleQuoted);
/*      */           return;
/*      */         case '￿':
/* 1391 */           param1Tokeniser.eofError(this);
/* 1392 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1393 */           param1Tokeniser.emitDoctypePending();
/* 1394 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/* 1397 */       param1Tokeniser.error(this);
/* 1398 */       param1Tokeniser.doctypePending.forceQuirks = true;
/* 1399 */       param1Tokeniser.transition(BogusDoctype);
/*      */     }
/*      */   },
/*      */   
/* 1403 */   BetweenDoctypePublicAndSystemIdentifiers {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*      */       char c;
/* 1406 */       switch (c = param1CharacterReader.consume()) {
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\f':
/*      */         case '\r':
/*      */         case ' ':
/*      */           return;
/*      */         case '>':
/* 1414 */           param1Tokeniser.emitDoctypePending();
/* 1415 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '"':
/* 1418 */           param1Tokeniser.error(this);
/*      */           
/* 1420 */           param1Tokeniser.transition(DoctypeSystemIdentifier_doubleQuoted);
/*      */           return;
/*      */         case '\'':
/* 1423 */           param1Tokeniser.error(this);
/*      */           
/* 1425 */           param1Tokeniser.transition(DoctypeSystemIdentifier_singleQuoted);
/*      */           return;
/*      */         case '￿':
/* 1428 */           param1Tokeniser.eofError(this);
/* 1429 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1430 */           param1Tokeniser.emitDoctypePending();
/* 1431 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/* 1434 */       param1Tokeniser.error(this);
/* 1435 */       param1Tokeniser.doctypePending.forceQuirks = true;
/* 1436 */       param1Tokeniser.transition(BogusDoctype);
/*      */     }
/*      */   },
/*      */   
/* 1440 */   AfterDoctypeSystemKeyword {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*      */       char c;
/* 1443 */       switch (c = param1CharacterReader.consume()) {
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\f':
/*      */         case '\r':
/*      */         case ' ':
/* 1449 */           param1Tokeniser.transition(BeforeDoctypeSystemIdentifier);
/*      */           return;
/*      */         case '>':
/* 1452 */           param1Tokeniser.error(this);
/* 1453 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1454 */           param1Tokeniser.emitDoctypePending();
/* 1455 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '"':
/* 1458 */           param1Tokeniser.error(this);
/*      */           
/* 1460 */           param1Tokeniser.transition(DoctypeSystemIdentifier_doubleQuoted);
/*      */           return;
/*      */         case '\'':
/* 1463 */           param1Tokeniser.error(this);
/*      */           
/* 1465 */           param1Tokeniser.transition(DoctypeSystemIdentifier_singleQuoted);
/*      */           return;
/*      */         case '￿':
/* 1468 */           param1Tokeniser.eofError(this);
/* 1469 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1470 */           param1Tokeniser.emitDoctypePending();
/* 1471 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/* 1474 */       param1Tokeniser.error(this);
/* 1475 */       param1Tokeniser.doctypePending.forceQuirks = true;
/* 1476 */       param1Tokeniser.emitDoctypePending();
/*      */     }
/*      */   },
/*      */   
/* 1480 */   BeforeDoctypeSystemIdentifier {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*      */       char c;
/* 1483 */       switch (c = param1CharacterReader.consume()) {
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\f':
/*      */         case '\r':
/*      */         case ' ':
/*      */           return;
/*      */         
/*      */         case '"':
/* 1492 */           param1Tokeniser.transition(DoctypeSystemIdentifier_doubleQuoted);
/*      */           return;
/*      */         
/*      */         case '\'':
/* 1496 */           param1Tokeniser.transition(DoctypeSystemIdentifier_singleQuoted);
/*      */           return;
/*      */         case '>':
/* 1499 */           param1Tokeniser.error(this);
/* 1500 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1501 */           param1Tokeniser.emitDoctypePending();
/* 1502 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '￿':
/* 1505 */           param1Tokeniser.eofError(this);
/* 1506 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1507 */           param1Tokeniser.emitDoctypePending();
/* 1508 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/* 1511 */       param1Tokeniser.error(this);
/* 1512 */       param1Tokeniser.doctypePending.forceQuirks = true;
/* 1513 */       param1Tokeniser.transition(BogusDoctype);
/*      */     }
/*      */   },
/*      */   
/* 1517 */   DoctypeSystemIdentifier_doubleQuoted {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*      */       char c;
/* 1520 */       switch (c = param1CharacterReader.consume()) {
/*      */         case '"':
/* 1522 */           param1Tokeniser.transition(AfterDoctypeSystemIdentifier);
/*      */           return;
/*      */         case '\000':
/* 1525 */           param1Tokeniser.error(this);
/* 1526 */           param1Tokeniser.doctypePending.systemIdentifier.append('�');
/*      */           return;
/*      */         case '>':
/* 1529 */           param1Tokeniser.error(this);
/* 1530 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1531 */           param1Tokeniser.emitDoctypePending();
/* 1532 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '￿':
/* 1535 */           param1Tokeniser.eofError(this);
/* 1536 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1537 */           param1Tokeniser.emitDoctypePending();
/* 1538 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/* 1541 */       param1Tokeniser.doctypePending.systemIdentifier.append(c);
/*      */     }
/*      */   },
/*      */   
/* 1545 */   DoctypeSystemIdentifier_singleQuoted {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*      */       char c;
/* 1548 */       switch (c = param1CharacterReader.consume()) {
/*      */         case '\'':
/* 1550 */           param1Tokeniser.transition(AfterDoctypeSystemIdentifier);
/*      */           return;
/*      */         case '\000':
/* 1553 */           param1Tokeniser.error(this);
/* 1554 */           param1Tokeniser.doctypePending.systemIdentifier.append('�');
/*      */           return;
/*      */         case '>':
/* 1557 */           param1Tokeniser.error(this);
/* 1558 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1559 */           param1Tokeniser.emitDoctypePending();
/* 1560 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '￿':
/* 1563 */           param1Tokeniser.eofError(this);
/* 1564 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1565 */           param1Tokeniser.emitDoctypePending();
/* 1566 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/* 1569 */       param1Tokeniser.doctypePending.systemIdentifier.append(c);
/*      */     }
/*      */   },
/*      */   
/* 1573 */   AfterDoctypeSystemIdentifier {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*      */       char c;
/* 1576 */       switch (c = param1CharacterReader.consume()) {
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\f':
/*      */         case '\r':
/*      */         case ' ':
/*      */           return;
/*      */         case '>':
/* 1584 */           param1Tokeniser.emitDoctypePending();
/* 1585 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '￿':
/* 1588 */           param1Tokeniser.eofError(this);
/* 1589 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1590 */           param1Tokeniser.emitDoctypePending();
/* 1591 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/* 1594 */       param1Tokeniser.error(this);
/* 1595 */       param1Tokeniser.transition(BogusDoctype);
/*      */     }
/*      */   },
/*      */ 
/*      */   
/* 1600 */   BogusDoctype {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*      */       char c;
/* 1603 */       switch (c = param1CharacterReader.consume()) {
/*      */         case '>':
/* 1605 */           param1Tokeniser.emitDoctypePending();
/* 1606 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '￿':
/* 1609 */           param1Tokeniser.emitDoctypePending();
/* 1610 */           param1Tokeniser.transition(Data);
/*      */           break;
/*      */       } 
/*      */ 
/*      */ 
/*      */     
/*      */     }
/*      */   },
/* 1618 */   CdataSection {
/*      */     final void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/* 1620 */       String str = param1CharacterReader.consumeTo("]]>");
/* 1621 */       param1Tokeniser.dataBuffer.append(str);
/* 1622 */       if (param1CharacterReader.matchConsume("]]>") || param1CharacterReader.isEmpty()) {
/* 1623 */         param1Tokeniser.emit(new Token.CData(param1Tokeniser.dataBuffer.toString()));
/* 1624 */         param1Tokeniser.transition(Data);
/*      */       } 
/*      */     }
/*      */   };
/*      */   
/*      */   static final char nullChar = '\000';
/*      */   static final char[] attributeNameCharsSorted;
/*      */   static final char[] attributeValueUnquoted;
/*      */   
/*      */   static {
/* 1634 */     attributeNameCharsSorted = new char[] { '\t', '\n', '\f', '\r', ' ', '"', '\'', '/', '<', '=', '>' };
/* 1635 */     attributeValueUnquoted = new char[] { Character.MIN_VALUE, '\t', '\n', '\f', '\r', ' ', '"', '&', '\'', '<', '=', '>', '`' };
/*      */ 
/*      */     
/* 1638 */     replacementStr = "�";
/*      */   }
/*      */   
/*      */   private static final char replacementChar = '�';
/*      */   private static final String replacementStr;
/*      */   private static final char eof = '￿';
/*      */   
/*      */   private static void handleDataEndTag(Tokeniser paramTokeniser, CharacterReader paramCharacterReader, TokeniserState paramTokeniserState) {
/* 1646 */     if (paramCharacterReader.matchesLetter()) {
/* 1647 */       String str = paramCharacterReader.consumeLetterSequence();
/* 1648 */       paramTokeniser.tagPending.appendTagName(str);
/* 1649 */       paramTokeniser.dataBuffer.append(str);
/*      */       
/*      */       return;
/*      */     } 
/* 1653 */     boolean bool = false;
/* 1654 */     if (paramTokeniser.isAppropriateEndTagToken() && !paramCharacterReader.isEmpty()) {
/*      */       char c;
/* 1656 */       switch (c = paramCharacterReader.consume()) {
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\f':
/*      */         case '\r':
/*      */         case ' ':
/* 1662 */           paramTokeniser.transition(BeforeAttributeName);
/*      */           break;
/*      */         case '/':
/* 1665 */           paramTokeniser.transition(SelfClosingStartTag);
/*      */           break;
/*      */         case '>':
/* 1668 */           paramTokeniser.emitTagPending();
/* 1669 */           paramTokeniser.transition(Data);
/*      */           break;
/*      */         default:
/* 1672 */           paramTokeniser.dataBuffer.append(c);
/* 1673 */           bool = true; break;
/*      */       } 
/*      */     } else {
/* 1676 */       bool = true;
/*      */     } 
/*      */     
/* 1679 */     if (bool) {
/* 1680 */       paramTokeniser.emit("</");
/* 1681 */       paramTokeniser.emit(paramTokeniser.dataBuffer);
/* 1682 */       paramTokeniser.transition(paramTokeniserState);
/*      */     } 
/*      */   }
/*      */   
/*      */   private static void readRawData(Tokeniser paramTokeniser, CharacterReader paramCharacterReader, TokeniserState paramTokeniserState1, TokeniserState paramTokeniserState2) {
/* 1687 */     switch (paramCharacterReader.current()) {
/*      */       case '<':
/* 1689 */         paramTokeniser.advanceTransition(paramTokeniserState2);
/*      */         return;
/*      */       case '\000':
/* 1692 */         paramTokeniser.error(paramTokeniserState1);
/* 1693 */         paramCharacterReader.advance();
/* 1694 */         paramTokeniser.emit('�');
/*      */         return;
/*      */       case '￿':
/* 1697 */         paramTokeniser.emit(new Token.EOF());
/*      */         return;
/*      */     } 
/* 1700 */     String str = paramCharacterReader.consumeRawData();
/* 1701 */     paramTokeniser.emit(str);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static void readCharRef(Tokeniser paramTokeniser, TokeniserState paramTokeniserState) {
/*      */     int[] arrayOfInt;
/* 1708 */     if ((arrayOfInt = paramTokeniser.consumeCharacterReference(null, false)) == null) {
/* 1709 */       paramTokeniser.emit('&');
/*      */     } else {
/* 1711 */       paramTokeniser.emit(arrayOfInt);
/* 1712 */     }  paramTokeniser.transition(paramTokeniserState);
/*      */   }
/*      */   
/*      */   private static void readEndTag(Tokeniser paramTokeniser, CharacterReader paramCharacterReader, TokeniserState paramTokeniserState1, TokeniserState paramTokeniserState2) {
/* 1716 */     if (paramCharacterReader.matchesAsciiAlpha()) {
/* 1717 */       paramTokeniser.createTagPending(false);
/* 1718 */       paramTokeniser.transition(paramTokeniserState1); return;
/*      */     } 
/* 1720 */     paramTokeniser.emit("</");
/* 1721 */     paramTokeniser.transition(paramTokeniserState2);
/*      */   }
/*      */ 
/*      */   
/*      */   private static void handleDataDoubleEscapeTag(Tokeniser paramTokeniser, CharacterReader paramCharacterReader, TokeniserState paramTokeniserState1, TokeniserState paramTokeniserState2) {
/* 1726 */     if (paramCharacterReader.matchesLetter()) {
/* 1727 */       String str = paramCharacterReader.consumeLetterSequence();
/* 1728 */       paramTokeniser.dataBuffer.append(str);
/* 1729 */       paramTokeniser.emit(str);
/*      */       
/*      */       return;
/*      */     } 
/*      */     char c;
/* 1734 */     switch (c = paramCharacterReader.consume()) {
/*      */       case '\t':
/*      */       case '\n':
/*      */       case '\f':
/*      */       case '\r':
/*      */       case ' ':
/*      */       case '/':
/*      */       case '>':
/* 1742 */         if (paramTokeniser.dataBuffer.toString().equals("script")) {
/* 1743 */           paramTokeniser.transition(paramTokeniserState1);
/*      */         } else {
/* 1745 */           paramTokeniser.transition(paramTokeniserState2);
/* 1746 */         }  paramTokeniser.emit(c);
/*      */         return;
/*      */     } 
/* 1749 */     paramCharacterReader.unconsume();
/* 1750 */     paramTokeniser.transition(paramTokeniserState2);
/*      */   }
/*      */   
/*      */   abstract void read(Tokeniser paramTokeniser, CharacterReader paramCharacterReader);
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\parser\TokeniserState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */