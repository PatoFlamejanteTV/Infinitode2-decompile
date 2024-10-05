/*     */ package org.jsoup.parser;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.Reader;
/*     */ import java.io.StringReader;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import org.jsoup.UncheckedIOException;
/*     */ import org.jsoup.helper.Validate;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class CharacterReader
/*     */ {
/*     */   static final char EOF = '￿';
/*     */   private static final int maxStringCacheLen = 12;
/*     */   static final int maxBufferLen = 32768;
/*     */   static final int readAheadLimit = 24576;
/*     */   private static final int minReadAheadLen = 1024;
/*     */   private char[] charBuf;
/*     */   private Reader reader;
/*     */   private int bufLength;
/*     */   private int bufSplitPoint;
/*     */   private int bufPos;
/*     */   private int readerPos;
/*  31 */   private int bufMark = -1;
/*     */   private static final int stringCacheSize = 512;
/*  33 */   private String[] stringCache = new String[512];
/*     */   
/*  35 */   private ArrayList<Integer> newlinePositions = null;
/*  36 */   private int lineNumberOffset = 1; private boolean readFully;
/*     */   
/*     */   public CharacterReader(Reader paramReader, int paramInt) {
/*  39 */     Validate.notNull(paramReader);
/*  40 */     Validate.isTrue(paramReader.markSupported());
/*  41 */     this.reader = paramReader;
/*  42 */     this.charBuf = new char[Math.min(paramInt, 32768)];
/*  43 */     bufferUp();
/*     */   }
/*     */   private String lastIcSeq; private int lastIcIndex;
/*     */   public CharacterReader(Reader paramReader) {
/*  47 */     this(paramReader, 32768);
/*     */   }
/*     */   
/*     */   public CharacterReader(String paramString) {
/*  51 */     this(new StringReader(paramString), paramString.length());
/*     */   }
/*     */   
/*     */   public final void close() {
/*  55 */     if (this.reader == null)
/*     */       return; 
/*     */     
/*  58 */     try { this.reader.close(); return; }
/*  59 */     catch (IOException iOException) { return; }
/*     */     finally
/*  61 */     { this.reader = null;
/*  62 */       this.charBuf = null;
/*  63 */       this.stringCache = null; }
/*     */   
/*     */   }
/*     */   private void bufferUp() {
/*     */     int i;
/*     */     boolean bool;
/*  69 */     if (this.readFully || this.bufPos < this.bufSplitPoint) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/*  74 */     if (this.bufMark != -1) {
/*  75 */       i = this.bufMark;
/*  76 */       bool = this.bufPos - this.bufMark;
/*     */     } else {
/*  78 */       i = this.bufPos;
/*  79 */       bool = false;
/*     */     } 
/*     */     
/*     */     try {
/*  83 */       long l = this.reader.skip(i);
/*  84 */       this.reader.mark(32768);
/*  85 */       int j = 0;
/*  86 */       while (j <= 1024) {
/*     */         int k;
/*  88 */         if ((k = this.reader.read(this.charBuf, j, this.charBuf.length - j)) == -1)
/*  89 */           this.readFully = true; 
/*  90 */         if (k > 0)
/*     */         {
/*  92 */           j += k; } 
/*     */       } 
/*  94 */       this.reader.reset();
/*  95 */       if (j > 0) {
/*  96 */         Validate.isTrue((l == i));
/*  97 */         this.bufLength = j;
/*  98 */         this.readerPos += i;
/*  99 */         this.bufPos = bool;
/* 100 */         if (this.bufMark != -1)
/* 101 */           this.bufMark = 0; 
/* 102 */         this.bufSplitPoint = Math.min(this.bufLength, 24576);
/*     */       } 
/* 104 */     } catch (IOException iOException) {
/* 105 */       throw new UncheckedIOException(iOException);
/*     */     } 
/* 107 */     scanBufferForNewlines();
/* 108 */     this.lastIcSeq = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int pos() {
/* 116 */     return this.readerPos + this.bufPos;
/*     */   }
/*     */ 
/*     */   
/*     */   final boolean readFully() {
/* 121 */     return this.readFully;
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
/*     */   public final void trackNewlines(boolean paramBoolean) {
/* 133 */     if (paramBoolean && this.newlinePositions == null) {
/* 134 */       this.newlinePositions = new ArrayList<>(409);
/* 135 */       scanBufferForNewlines(); return;
/*     */     } 
/* 137 */     if (!paramBoolean) {
/* 138 */       this.newlinePositions = null;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isTrackNewlines() {
/* 147 */     return (this.newlinePositions != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int lineNumber() {
/* 157 */     return lineNumber(pos());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   final int lineNumber(int paramInt) {
/* 163 */     if (!isTrackNewlines()) {
/* 164 */       return 1;
/*     */     }
/*     */     
/* 167 */     if ((paramInt = lineNumIndex(paramInt)) == -1)
/* 168 */       return this.lineNumberOffset; 
/* 169 */     return paramInt + this.lineNumberOffset + 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int columnNumber() {
/* 179 */     return columnNumber(pos());
/*     */   }
/*     */   
/*     */   final int columnNumber(int paramInt) {
/* 183 */     if (!isTrackNewlines()) {
/* 184 */       return paramInt + 1;
/*     */     }
/*     */     int i;
/* 187 */     if ((i = lineNumIndex(paramInt)) == -1)
/* 188 */       return paramInt + 1; 
/* 189 */     return paramInt - ((Integer)this.newlinePositions.get(i)).intValue() + 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final String posLineCol() {
/* 200 */     return lineNumber() + ":" + columnNumber();
/*     */   }
/*     */   
/*     */   private int lineNumIndex(int paramInt) {
/* 204 */     if (!isTrackNewlines()) return 0;
/*     */     
/* 206 */     if ((paramInt = Collections.binarySearch((List)this.newlinePositions, Integer.valueOf(paramInt))) < -1) paramInt = Math.abs(paramInt) - 2; 
/* 207 */     return paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void scanBufferForNewlines() {
/* 214 */     if (!isTrackNewlines()) {
/*     */       return;
/*     */     }
/* 217 */     if (this.newlinePositions.size() > 0) {
/*     */       int j;
/*     */       
/* 220 */       if ((j = lineNumIndex(this.readerPos)) == -1) j = 0; 
/* 221 */       int k = ((Integer)this.newlinePositions.get(j)).intValue();
/* 222 */       this.lineNumberOffset += j;
/* 223 */       this.newlinePositions.clear();
/* 224 */       this.newlinePositions.add(Integer.valueOf(k));
/*     */     } 
/*     */     
/* 227 */     for (int i = this.bufPos; i < this.bufLength; i++) {
/* 228 */       if (this.charBuf[i] == '\n') {
/* 229 */         this.newlinePositions.add(Integer.valueOf(1 + this.readerPos + i));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isEmpty() {
/* 238 */     bufferUp();
/* 239 */     return (this.bufPos >= this.bufLength);
/*     */   }
/*     */   
/*     */   private boolean isEmptyNoBufferUp() {
/* 243 */     return (this.bufPos >= this.bufLength);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final char current() {
/* 251 */     bufferUp();
/* 252 */     return isEmptyNoBufferUp() ? Character.MAX_VALUE : this.charBuf[this.bufPos];
/*     */   }
/*     */   
/*     */   final char consume() {
/* 256 */     bufferUp();
/* 257 */     boolean bool = isEmptyNoBufferUp() ? true : this.charBuf[this.bufPos];
/* 258 */     this.bufPos++;
/* 259 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final void unconsume() {
/* 266 */     if (this.bufPos <= 0) {
/* 267 */       throw new UncheckedIOException(new IOException("WTF: No buffer left to unconsume."));
/*     */     }
/* 269 */     this.bufPos--;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void advance() {
/* 276 */     this.bufPos++;
/*     */   }
/*     */ 
/*     */   
/*     */   final void mark() {
/* 281 */     if (this.bufLength - this.bufPos < 1024) {
/* 282 */       this.bufSplitPoint = 0;
/*     */     }
/* 284 */     bufferUp();
/* 285 */     this.bufMark = this.bufPos;
/*     */   }
/*     */   
/*     */   final void unmark() {
/* 289 */     this.bufMark = -1;
/*     */   }
/*     */   
/*     */   final void rewindToMark() {
/* 293 */     if (this.bufMark == -1) {
/* 294 */       throw new UncheckedIOException(new IOException("Mark invalid"));
/*     */     }
/* 296 */     this.bufPos = this.bufMark;
/* 297 */     unmark();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final int nextIndexOf(char paramChar) {
/* 307 */     bufferUp();
/* 308 */     for (int i = this.bufPos; i < this.bufLength; i++) {
/* 309 */       if (paramChar == this.charBuf[i])
/* 310 */         return i - this.bufPos; 
/*     */     } 
/* 312 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final int nextIndexOf(CharSequence paramCharSequence) {
/* 322 */     bufferUp();
/*     */     
/* 324 */     char c = paramCharSequence.charAt(0);
/* 325 */     for (int i = this.bufPos; i < this.bufLength; i++) {
/*     */       
/* 327 */       if (c != this.charBuf[i]) {
/* 328 */         do {  } while (++i < this.bufLength && c != this.charBuf[i]);
/*     */       }
/* 330 */       int j, k = (j = i + 1) + paramCharSequence.length() - 1;
/* 331 */       if (i < this.bufLength && k <= this.bufLength) {
/* 332 */         for (byte b = 1; j < k && paramCharSequence.charAt(b) == this.charBuf[j]; ) { j++; b++; }
/* 333 */          if (j == k)
/* 334 */           return i - this.bufPos; 
/*     */       } 
/*     */     } 
/* 337 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String consumeTo(char paramChar) {
/*     */     int i;
/* 347 */     if ((i = nextIndexOf(paramChar)) != -1) {
/* 348 */       String str = cacheString(this.charBuf, this.stringCache, this.bufPos, i);
/* 349 */       this.bufPos += i;
/* 350 */       return str;
/*     */     } 
/* 352 */     return consumeToEnd();
/*     */   }
/*     */ 
/*     */   
/*     */   final String consumeTo(String paramString) {
/*     */     int j;
/* 358 */     if ((j = nextIndexOf(paramString)) != -1) {
/* 359 */       paramString = cacheString(this.charBuf, this.stringCache, this.bufPos, j);
/* 360 */       this.bufPos += j;
/* 361 */       return paramString;
/* 362 */     }  if (this.bufLength - this.bufPos < paramString.length())
/*     */     {
/* 364 */       return consumeToEnd();
/*     */     }
/*     */ 
/*     */     
/* 368 */     int i = this.bufLength - paramString.length() + 1;
/* 369 */     String str = cacheString(this.charBuf, this.stringCache, this.bufPos, i - this.bufPos);
/* 370 */     this.bufPos = i;
/* 371 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String consumeToAny(char... paramVarArgs) {
/* 381 */     bufferUp();
/*     */     
/* 383 */     int i = this.bufPos, j = i;
/* 384 */     int k = this.bufLength;
/* 385 */     char[] arrayOfChar = this.charBuf;
/* 386 */     int m = paramVarArgs.length;
/*     */ 
/*     */     
/* 389 */     label16: while (i < k) {
/* 390 */       for (byte b = 0; b < m; ) {
/* 391 */         if (arrayOfChar[i] != paramVarArgs[b]) {
/*     */           b++; continue;
/*     */         }  break label16;
/* 394 */       }  i++;
/*     */     } 
/*     */     
/* 397 */     this.bufPos = i;
/* 398 */     return (i > j) ? cacheString(this.charBuf, this.stringCache, j, i - j) : "";
/*     */   }
/*     */   
/*     */   final String consumeToAnySorted(char... paramVarArgs) {
/* 402 */     bufferUp();
/*     */     
/* 404 */     int i = this.bufPos, j = i;
/* 405 */     int k = this.bufLength;
/* 406 */     char[] arrayOfChar = this.charBuf;
/*     */     
/* 408 */     while (i < k && 
/* 409 */       Arrays.binarySearch(paramVarArgs, arrayOfChar[i]) < 0)
/*     */     {
/* 411 */       i++;
/*     */     }
/* 413 */     this.bufPos = i;
/* 414 */     return (this.bufPos > j) ? cacheString(this.charBuf, this.stringCache, j, i - j) : "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final String consumeData() {
/* 421 */     int i = this.bufPos, j = i;
/* 422 */     int k = this.bufLength;
/* 423 */     char[] arrayOfChar = this.charBuf;
/*     */     
/* 425 */     while (i < k) {
/* 426 */       switch (arrayOfChar[i]) {
/*     */         case '\000':
/*     */         case '&':
/*     */         case '<':
/*     */           break;
/*     */       } 
/* 432 */       i++;
/*     */     } 
/*     */     
/* 435 */     this.bufPos = i;
/* 436 */     return (i > j) ? cacheString(this.charBuf, this.stringCache, j, i - j) : "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final String consumeAttributeQuoted(boolean paramBoolean) {
/* 443 */     int i = this.bufPos, j = i;
/* 444 */     int k = this.bufLength;
/* 445 */     char[] arrayOfChar = this.charBuf;
/*     */     
/* 447 */     while (i < k) {
/* 448 */       switch (arrayOfChar[i]) {
/*     */         case '\000':
/*     */         case '&':
/*     */           break;
/*     */         case '\'':
/* 453 */           if (paramBoolean)
/*     */             break;  break;
/*     */         case '"':
/* 456 */           if (paramBoolean)
/*     */             break;  break;
/*     */       } 
/* 459 */       i++;
/*     */     } 
/* 461 */     this.bufPos = i;
/* 462 */     return (i > j) ? cacheString(this.charBuf, this.stringCache, j, i - j) : "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final String consumeRawData() {
/* 470 */     int i = this.bufPos, j = i;
/* 471 */     int k = this.bufLength;
/* 472 */     char[] arrayOfChar = this.charBuf;
/*     */     
/* 474 */     while (i < k) {
/* 475 */       switch (arrayOfChar[i]) {
/*     */         case '\000':
/*     */         case '<':
/*     */           break;
/*     */       } 
/* 480 */       i++;
/*     */     } 
/*     */     
/* 483 */     this.bufPos = i;
/* 484 */     return (i > j) ? cacheString(this.charBuf, this.stringCache, j, i - j) : "";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   final String consumeTagName() {
/* 490 */     bufferUp();
/*     */     
/* 492 */     int i = this.bufPos, j = i;
/* 493 */     int k = this.bufLength;
/* 494 */     char[] arrayOfChar = this.charBuf;
/*     */     
/* 496 */     while (i < k) {
/* 497 */       switch (arrayOfChar[i]) {
/*     */         case '\t':
/*     */         case '\n':
/*     */         case '\f':
/*     */         case '\r':
/*     */         case ' ':
/*     */         case '/':
/*     */         case '<':
/*     */         case '>':
/*     */           break;
/*     */       } 
/* 508 */       i++;
/*     */     } 
/*     */     
/* 511 */     this.bufPos = i;
/* 512 */     return (i > j) ? cacheString(this.charBuf, this.stringCache, j, i - j) : "";
/*     */   }
/*     */   
/*     */   final String consumeToEnd() {
/* 516 */     bufferUp();
/* 517 */     String str = cacheString(this.charBuf, this.stringCache, this.bufPos, this.bufLength - this.bufPos);
/* 518 */     this.bufPos = this.bufLength;
/* 519 */     return str;
/*     */   }
/*     */   
/*     */   final String consumeLetterSequence() {
/* 523 */     bufferUp();
/* 524 */     int i = this.bufPos; char c;
/* 525 */     while (this.bufPos < this.bufLength && (((
/*     */       
/* 527 */       c = this.charBuf[this.bufPos]) >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || Character.isLetter(c))) {
/* 528 */       this.bufPos++;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 533 */     return cacheString(this.charBuf, this.stringCache, i, this.bufPos - i);
/*     */   }
/*     */   
/*     */   final String consumeLetterThenDigitSequence() {
/* 537 */     bufferUp();
/* 538 */     int i = this.bufPos; char c;
/* 539 */     while (this.bufPos < this.bufLength && (((
/*     */       
/* 541 */       c = this.charBuf[this.bufPos]) >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || Character.isLetter(c))) {
/* 542 */       this.bufPos++;
/*     */     }
/*     */ 
/*     */     
/* 546 */     while (!isEmptyNoBufferUp() && (
/*     */       
/* 548 */       c = this.charBuf[this.bufPos]) >= '0' && c <= '9') {
/* 549 */       this.bufPos++;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 554 */     return cacheString(this.charBuf, this.stringCache, i, this.bufPos - i);
/*     */   }
/*     */   
/*     */   final String consumeHexSequence() {
/* 558 */     bufferUp();
/* 559 */     int i = this.bufPos; char c;
/* 560 */     while (this.bufPos < this.bufLength && (((
/*     */       
/* 562 */       c = this.charBuf[this.bufPos]) >= '0' && c <= '9') || (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f'))) {
/* 563 */       this.bufPos++;
/*     */     }
/*     */ 
/*     */     
/* 567 */     return cacheString(this.charBuf, this.stringCache, i, this.bufPos - i);
/*     */   }
/*     */   
/*     */   final String consumeDigitSequence() {
/* 571 */     bufferUp();
/* 572 */     int i = this.bufPos; char c;
/* 573 */     while (this.bufPos < this.bufLength && (
/*     */       
/* 575 */       c = this.charBuf[this.bufPos]) >= '0' && c <= '9') {
/* 576 */       this.bufPos++;
/*     */     }
/*     */ 
/*     */     
/* 580 */     return cacheString(this.charBuf, this.stringCache, i, this.bufPos - i);
/*     */   }
/*     */   
/*     */   final boolean matches(char paramChar) {
/* 584 */     return (!isEmpty() && this.charBuf[this.bufPos] == paramChar);
/*     */   }
/*     */ 
/*     */   
/*     */   final boolean matches(String paramString) {
/* 589 */     bufferUp();
/*     */     int i;
/* 591 */     if ((i = paramString.length()) > this.bufLength - this.bufPos) {
/* 592 */       return false;
/*     */     }
/* 594 */     for (byte b = 0; b < i; b++) {
/* 595 */       if (paramString.charAt(b) != this.charBuf[this.bufPos + b])
/* 596 */         return false; 
/* 597 */     }  return true;
/*     */   }
/*     */   
/*     */   final boolean matchesIgnoreCase(String paramString) {
/* 601 */     bufferUp();
/*     */     int i;
/* 603 */     if ((i = paramString.length()) > this.bufLength - this.bufPos) {
/* 604 */       return false;
/*     */     }
/* 606 */     for (byte b = 0; b < i; b++) {
/* 607 */       char c1 = Character.toUpperCase(paramString.charAt(b));
/* 608 */       char c2 = Character.toUpperCase(this.charBuf[this.bufPos + b]);
/* 609 */       if (c1 != c2)
/* 610 */         return false; 
/*     */     } 
/* 612 */     return true;
/*     */   }
/*     */   
/*     */   final boolean matchesAny(char... paramVarArgs) {
/* 616 */     if (isEmpty()) {
/* 617 */       return false;
/*     */     }
/* 619 */     bufferUp();
/* 620 */     char c = this.charBuf[this.bufPos]; int i; byte b;
/* 621 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; b++) {
/* 622 */       char c1; if ((c1 = paramVarArgs[b]) == c)
/* 623 */         return true; 
/*     */     } 
/* 625 */     return false;
/*     */   }
/*     */   
/*     */   final boolean matchesAnySorted(char[] paramArrayOfchar) {
/* 629 */     bufferUp();
/* 630 */     return (!isEmpty() && Arrays.binarySearch(paramArrayOfchar, this.charBuf[this.bufPos]) >= 0);
/*     */   }
/*     */   
/*     */   final boolean matchesLetter() {
/* 634 */     if (isEmpty())
/* 635 */       return false; 
/*     */     char c;
/* 637 */     if (((c = this.charBuf[this.bufPos]) >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || Character.isLetter(c)) return true;  return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final boolean matchesAsciiAlpha() {
/* 645 */     if (isEmpty())
/* 646 */       return false; 
/*     */     char c;
/* 648 */     if (((c = this.charBuf[this.bufPos]) >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) return true;  return false;
/*     */   }
/*     */   
/*     */   final boolean matchesDigit() {
/* 652 */     if (isEmpty())
/* 653 */       return false; 
/*     */     char c;
/* 655 */     if ((c = this.charBuf[this.bufPos]) >= '0' && c <= '9') return true;  return false;
/*     */   }
/*     */   
/*     */   final boolean matchConsume(String paramString) {
/* 659 */     bufferUp();
/* 660 */     if (matches(paramString)) {
/* 661 */       this.bufPos += paramString.length();
/* 662 */       return true;
/*     */     } 
/* 664 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   final boolean matchConsumeIgnoreCase(String paramString) {
/* 669 */     if (matchesIgnoreCase(paramString)) {
/* 670 */       this.bufPos += paramString.length();
/* 671 */       return true;
/*     */     } 
/* 673 */     return false;
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
/*     */   final boolean containsIgnoreCase(String paramString) {
/* 685 */     if (paramString.equals(this.lastIcSeq)) {
/* 686 */       if (this.lastIcIndex == -1) return false; 
/* 687 */       if (this.lastIcIndex >= this.bufPos) return true; 
/*     */     } 
/* 689 */     this.lastIcSeq = paramString;
/*     */     
/* 691 */     String str = paramString.toLowerCase(Locale.ENGLISH);
/*     */     int j;
/* 693 */     if ((j = nextIndexOf(str)) >= 0) {
/* 694 */       this.lastIcIndex = this.bufPos + j; return true;
/*     */     } 
/*     */     
/* 697 */     paramString = paramString.toUpperCase(Locale.ENGLISH);
/*     */     int i;
/* 699 */     j = ((i = nextIndexOf(paramString)) >= 0) ? 1 : 0;
/* 700 */     this.lastIcIndex = (j != 0) ? (this.bufPos + i) : -1;
/* 701 */     return j;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 706 */     if (this.bufLength - this.bufPos < 0)
/* 707 */       return ""; 
/* 708 */     return new String(this.charBuf, this.bufPos, this.bufLength - this.bufPos);
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
/*     */   private static String cacheString(char[] paramArrayOfchar, String[] paramArrayOfString, int paramInt1, int paramInt2) {
/* 720 */     if (paramInt2 > 12)
/* 721 */       return new String(paramArrayOfchar, paramInt1, paramInt2); 
/* 722 */     if (paramInt2 <= 0) {
/* 723 */       return "";
/*     */     }
/*     */     
/* 726 */     int i = 0; int j;
/* 727 */     for (j = 0; j < paramInt2; j++) {
/* 728 */       i = i * 31 + paramArrayOfchar[paramInt1 + j];
/*     */     }
/*     */ 
/*     */     
/* 732 */     j = i & 0x1FF;
/*     */     
/*     */     String str;
/* 735 */     if ((str = paramArrayOfString[j]) != null && rangeEquals(paramArrayOfchar, paramInt1, paramInt2, str)) {
/* 736 */       return str;
/*     */     }
/* 738 */     str = new String(paramArrayOfchar, paramInt1, paramInt2);
/* 739 */     paramArrayOfString[j] = str;
/*     */ 
/*     */     
/* 742 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean rangeEquals(char[] paramArrayOfchar, int paramInt1, int paramInt2, String paramString) {
/* 749 */     if (paramInt2 == paramString.length()) {
/* 750 */       paramInt1 = paramInt1;
/* 751 */       byte b = 0;
/* 752 */       while (paramInt2-- != 0) {
/* 753 */         if (paramArrayOfchar[paramInt1++] != paramString.charAt(b++))
/* 754 */           return false; 
/*     */       } 
/* 756 */       return true;
/*     */     } 
/* 758 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   final boolean rangeEquals(int paramInt1, int paramInt2, String paramString) {
/* 763 */     return rangeEquals(this.charBuf, paramInt1, paramInt2, paramString);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\parser\CharacterReader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */