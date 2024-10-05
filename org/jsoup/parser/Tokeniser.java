/*     */ package org.jsoup.parser;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import org.jsoup.helper.Validate;
/*     */ import org.jsoup.internal.StringUtil;
/*     */ import org.jsoup.nodes.Entities;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Tokeniser
/*     */ {
/*     */   static final char replacementChar = '�';
/*  15 */   private static final char[] notCharRefCharsSorted = new char[] { '\t', '\n', '\r', '\f', ' ', '<', '&' };
/*     */ 
/*     */   
/*     */   static final int win1252ExtensionsStart = 128;
/*     */   
/*  20 */   static final int[] win1252Extensions = new int[] { 8364, 129, 8218, 402, 8222, 8230, 8224, 8225, 710, 8240, 352, 8249, 338, 141, 381, 143, 144, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 732, 8482, 353, 8250, 339, 157, 382, 376 };
/*     */ 
/*     */   
/*     */   private final CharacterReader reader;
/*     */ 
/*     */   
/*     */   private final ParseErrorList errors;
/*     */ 
/*     */   
/*     */   static {
/*  30 */     Arrays.sort(notCharRefCharsSorted);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  36 */   private TokeniserState state = TokeniserState.Data;
/*  37 */   private Token emitPending = null;
/*     */   private boolean isEmitPending = false;
/*  39 */   private String charsString = null;
/*  40 */   private final StringBuilder charsBuilder = new StringBuilder(1024);
/*  41 */   final StringBuilder dataBuffer = new StringBuilder(1024);
/*     */   
/*     */   final Token.StartTag startPending;
/*     */   final Token.EndTag endPending;
/*     */   Token.Tag tagPending;
/*  46 */   final Token.Character charPending = new Token.Character();
/*  47 */   final Token.Doctype doctypePending = new Token.Doctype();
/*  48 */   final Token.Comment commentPending = new Token.Comment();
/*     */   private String lastStartTag;
/*     */   private String lastStartCloseSeq;
/*     */   private static final int Unset = -1;
/*     */   private int markupStartPos;
/*  53 */   private int charStartPos = -1;
/*     */ 
/*     */   
/*     */   private final int[] codepointHolder;
/*     */ 
/*     */   
/*     */   private final int[] multipointHolder;
/*     */ 
/*     */   
/*     */   final Token read() {
/*  63 */     while (!this.isEmitPending) {
/*  64 */       this.state.read(this, this.reader);
/*     */     }
/*     */     
/*     */     StringBuilder stringBuilder;
/*     */     
/*  69 */     if ((stringBuilder = this.charsBuilder).length() != 0) {
/*  70 */       String str = stringBuilder.toString();
/*  71 */       stringBuilder.delete(0, stringBuilder.length());
/*  72 */       Token.Character character = this.charPending.data(str);
/*  73 */       this.charsString = null;
/*  74 */       return character;
/*  75 */     }  if (this.charsString != null) {
/*  76 */       Token.Character character = this.charPending.data(this.charsString);
/*  77 */       this.charsString = null;
/*  78 */       return character;
/*     */     } 
/*  80 */     this.isEmitPending = false;
/*  81 */     assert this.emitPending != null;
/*  82 */     return this.emitPending;
/*     */   }
/*     */ 
/*     */   
/*     */   final void emit(Token paramToken) {
/*  87 */     Validate.isFalse(this.isEmitPending);
/*     */     
/*  89 */     this.emitPending = paramToken;
/*  90 */     this.isEmitPending = true;
/*  91 */     paramToken.startPos(this.markupStartPos);
/*  92 */     paramToken.endPos(this.reader.pos());
/*  93 */     this.charStartPos = -1;
/*     */     
/*  95 */     if (paramToken.type == Token.TokenType.StartTag) {
/*  96 */       paramToken = paramToken;
/*  97 */       this.lastStartTag = ((Token.StartTag)paramToken).tagName;
/*  98 */       this.lastStartCloseSeq = null; return;
/*  99 */     }  if (paramToken.type == Token.TokenType.EndTag && (
/*     */       
/* 101 */       paramToken = paramToken).hasAttributes()) {
/* 102 */       error("Attributes incorrectly present on end tag [/%s]", new Object[] { paramToken.normalName() });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   final void emit(String paramString) {
/* 109 */     if (this.charsString == null) {
/* 110 */       this.charsString = paramString;
/*     */     } else {
/* 112 */       if (this.charsBuilder.length() == 0) {
/* 113 */         this.charsBuilder.append(this.charsString);
/*     */       }
/* 115 */       this.charsBuilder.append(paramString);
/*     */     } 
/* 117 */     this.charPending.startPos(this.charStartPos);
/* 118 */     this.charPending.endPos(this.reader.pos());
/*     */   }
/*     */ 
/*     */   
/*     */   final void emit(StringBuilder paramStringBuilder) {
/* 123 */     if (this.charsString == null) {
/* 124 */       this.charsString = paramStringBuilder.toString();
/*     */     } else {
/* 126 */       if (this.charsBuilder.length() == 0) {
/* 127 */         this.charsBuilder.append(this.charsString);
/*     */       }
/* 129 */       this.charsBuilder.append(paramStringBuilder);
/*     */     } 
/* 131 */     this.charPending.startPos(this.charStartPos);
/* 132 */     this.charPending.endPos(this.reader.pos());
/*     */   }
/*     */   
/*     */   final void emit(char paramChar) {
/* 136 */     if (this.charsString == null) {
/* 137 */       this.charsString = String.valueOf(paramChar);
/*     */     } else {
/* 139 */       if (this.charsBuilder.length() == 0) {
/* 140 */         this.charsBuilder.append(this.charsString);
/*     */       }
/* 142 */       this.charsBuilder.append(paramChar);
/*     */     } 
/* 144 */     this.charPending.startPos(this.charStartPos);
/* 145 */     this.charPending.endPos(this.reader.pos());
/*     */   }
/*     */   
/*     */   final void emit(char[] paramArrayOfchar) {
/* 149 */     emit(String.valueOf(paramArrayOfchar));
/*     */   }
/*     */   
/*     */   final void emit(int[] paramArrayOfint) {
/* 153 */     emit(new String(paramArrayOfint, 0, paramArrayOfint.length));
/*     */   }
/*     */   
/*     */   final TokeniserState getState() {
/* 157 */     return this.state;
/*     */   }
/*     */ 
/*     */   
/*     */   final void transition(TokeniserState paramTokeniserState) {
/* 162 */     switch (paramTokeniserState) {
/*     */       case TagOpen:
/* 164 */         this.markupStartPos = this.reader.pos();
/*     */         break;
/*     */       case Data:
/* 167 */         if (this.charStartPos == -1)
/* 168 */           this.charStartPos = this.reader.pos(); 
/*     */         break;
/*     */     } 
/* 171 */     this.state = paramTokeniserState;
/*     */   }
/*     */   
/*     */   final void advanceTransition(TokeniserState paramTokeniserState) {
/* 175 */     transition(paramTokeniserState);
/* 176 */     this.reader.advance();
/*     */   }
/*     */   
/* 179 */   Tokeniser(TreeBuilder paramTreeBuilder) { this.codepointHolder = new int[1];
/* 180 */     this.multipointHolder = new int[2]; this.tagPending = this.startPending = new Token.StartTag(paramTreeBuilder); this.endPending = new Token.EndTag(paramTreeBuilder);
/*     */     this.reader = paramTreeBuilder.reader;
/* 182 */     this.errors = paramTreeBuilder.parser.getErrors(); } final int[] consumeCharacterReference(Character paramCharacter, boolean paramBoolean) { if (this.reader.isEmpty())
/* 183 */       return null; 
/* 184 */     if (paramCharacter != null && paramCharacter.charValue() == this.reader.current())
/* 185 */       return null; 
/* 186 */     if (this.reader.matchesAnySorted(notCharRefCharsSorted)) {
/* 187 */       return null;
/*     */     }
/* 189 */     int[] arrayOfInt = this.codepointHolder;
/* 190 */     this.reader.mark();
/* 191 */     if (this.reader.matchConsume("#")) {
/*     */       boolean bool2;
/*     */       String str1;
/* 194 */       if ((str1 = (bool2 = this.reader.matchConsumeIgnoreCase("X")) ? this.reader.consumeHexSequence() : this.reader.consumeDigitSequence()).length() == 0) {
/* 195 */         characterReferenceError("numeric reference with no numerals", new Object[0]);
/* 196 */         this.reader.rewindToMark();
/* 197 */         return null;
/*     */       } 
/*     */       
/* 200 */       this.reader.unmark();
/* 201 */       if (!this.reader.matchConsume(";"))
/* 202 */         characterReferenceError("missing semicolon on [&#%s]", new Object[] { str1 }); 
/* 203 */       int j = -1;
/*     */       try {
/* 205 */         i = bool2 ? 16 : 10;
/* 206 */         j = Integer.valueOf(str1, i).intValue();
/* 207 */       } catch (NumberFormatException numberFormatException) {}
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 212 */       if (j == -1 || j > 1114111) {
/* 213 */         characterReferenceError("character [%s] outside of valid range", new Object[] { Integer.valueOf(j) });
/* 214 */         arrayOfInt[0] = 65533;
/*     */       } else {
/*     */         
/* 217 */         if (j >= 128 && j < 128 + win1252Extensions.length) {
/* 218 */           characterReferenceError("character [%s] is not a valid unicode code point", new Object[] { Integer.valueOf(j) });
/* 219 */           j = win1252Extensions[j - 128];
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 224 */         arrayOfInt[0] = j;
/*     */       } 
/* 226 */       return arrayOfInt;
/*     */     } 
/*     */     
/* 229 */     String str = this.reader.consumeLetterThenDigitSequence();
/* 230 */     boolean bool = this.reader.matches(';');
/*     */     
/*     */     boolean bool1;
/*     */     
/* 234 */     if (!(bool1 = (Entities.isBaseNamedEntity(str) || (Entities.isNamedEntity(str) && bool)) ? true : false)) {
/* 235 */       this.reader.rewindToMark();
/* 236 */       if (bool)
/* 237 */         characterReferenceError("invalid named reference [%s]", new Object[] { str }); 
/* 238 */       return null;
/*     */     } 
/* 240 */     if (i != 0 && (this.reader.matchesLetter() || this.reader.matchesDigit() || this.reader.matchesAny(new char[] { '=', '-', '_' }))) {
/*     */       
/* 242 */       this.reader.rewindToMark();
/* 243 */       return null;
/*     */     } 
/*     */     
/* 246 */     this.reader.unmark();
/* 247 */     if (!this.reader.matchConsume(";"))
/* 248 */       characterReferenceError("missing semicolon on [&%s]", new Object[] { str }); 
/*     */     int i;
/* 250 */     if ((i = Entities.codepointsForName(str, this.multipointHolder)) == 1) {
/* 251 */       arrayOfInt[0] = this.multipointHolder[0];
/* 252 */       return arrayOfInt;
/* 253 */     }  if (i == 2) {
/* 254 */       return this.multipointHolder;
/*     */     }
/* 256 */     Validate.fail("Unexpected characters returned for " + str);
/* 257 */     return this.multipointHolder; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final Token.Tag createTagPending(boolean paramBoolean) {
/* 263 */     this.tagPending = paramBoolean ? this.startPending.reset() : this.endPending.reset();
/* 264 */     return this.tagPending;
/*     */   }
/*     */   
/*     */   final void emitTagPending() {
/* 268 */     this.tagPending.finaliseTag();
/* 269 */     emit(this.tagPending);
/*     */   }
/*     */   
/*     */   final void createCommentPending() {
/* 273 */     this.commentPending.reset();
/*     */   }
/*     */   
/*     */   final void emitCommentPending() {
/* 277 */     emit(this.commentPending);
/*     */   }
/*     */   
/*     */   final void createBogusCommentPending() {
/* 281 */     this.commentPending.reset();
/* 282 */     this.commentPending.bogus = true;
/*     */   }
/*     */   
/*     */   final void createDoctypePending() {
/* 286 */     this.doctypePending.reset();
/*     */   }
/*     */   
/*     */   final void emitDoctypePending() {
/* 290 */     emit(this.doctypePending);
/*     */   }
/*     */   
/*     */   final void createTempBuffer() {
/* 294 */     Token.reset(this.dataBuffer);
/*     */   }
/*     */   
/*     */   final boolean isAppropriateEndTagToken() {
/* 298 */     return (this.lastStartTag != null && this.tagPending.name().equalsIgnoreCase(this.lastStartTag));
/*     */   }
/*     */   
/*     */   final String appropriateEndTagName() {
/* 302 */     return this.lastStartTag;
/*     */   }
/*     */ 
/*     */   
/*     */   final String appropriateEndTagSeq() {
/* 307 */     if (this.lastStartCloseSeq == null)
/* 308 */       this.lastStartCloseSeq = "</" + this.lastStartTag; 
/* 309 */     return this.lastStartCloseSeq;
/*     */   }
/*     */   
/*     */   final void error(TokeniserState paramTokeniserState) {
/* 313 */     if (this.errors.canAddError())
/* 314 */       this.errors.add(new ParseError(this.reader, "Unexpected character '%s' in input state [%s]", new Object[] { Character.valueOf(this.reader.current()), paramTokeniserState })); 
/*     */   }
/*     */   
/*     */   final void eofError(TokeniserState paramTokeniserState) {
/* 318 */     if (this.errors.canAddError())
/* 319 */       this.errors.add(new ParseError(this.reader, "Unexpectedly reached end of file (EOF) in input state [%s]", new Object[] { paramTokeniserState })); 
/*     */   }
/*     */   
/*     */   private void characterReferenceError(String paramString, Object... paramVarArgs) {
/* 323 */     if (this.errors.canAddError())
/* 324 */       this.errors.add(new ParseError(this.reader, String.format("Invalid character reference: " + paramString, paramVarArgs))); 
/*     */   }
/*     */   
/*     */   final void error(String paramString) {
/* 328 */     if (this.errors.canAddError())
/* 329 */       this.errors.add(new ParseError(this.reader, paramString)); 
/*     */   }
/*     */   
/*     */   final void error(String paramString, Object... paramVarArgs) {
/* 333 */     if (this.errors.canAddError()) {
/* 334 */       this.errors.add(new ParseError(this.reader, paramString, paramVarArgs));
/*     */     }
/*     */   }
/*     */   
/*     */   static boolean currentNodeInHtmlNS() {
/* 339 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final String unescapeEntities(boolean paramBoolean) {
/* 350 */     StringBuilder stringBuilder = StringUtil.borrowBuilder();
/* 351 */     while (!this.reader.isEmpty()) {
/* 352 */       stringBuilder.append(this.reader.consumeTo('&'));
/* 353 */       if (this.reader.matches('&')) {
/* 354 */         this.reader.consume();
/*     */         int[] arrayOfInt;
/* 356 */         if ((arrayOfInt = consumeCharacterReference(null, paramBoolean)) == null || arrayOfInt.length == 0) {
/* 357 */           stringBuilder.append('&'); continue;
/*     */         } 
/* 359 */         stringBuilder.appendCodePoint(arrayOfInt[0]);
/* 360 */         if (arrayOfInt.length == 2) {
/* 361 */           stringBuilder.appendCodePoint(arrayOfInt[1]);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 366 */     return StringUtil.releaseBuilder(stringBuilder);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\parser\Tokeniser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */