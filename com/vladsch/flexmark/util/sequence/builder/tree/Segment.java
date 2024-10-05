/*     */ package com.vladsch.flexmark.util.sequence.builder.tree;
/*     */ 
/*     */ import com.vladsch.flexmark.util.misc.Utils;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.builder.Seg;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Segment
/*     */ {
/*     */   static final int TYPE_MASK = 224;
/*     */   static final int TYPE_NO_SIZE_BYTES = 16;
/*     */   static final int TYPE_START_BYTES = 3;
/*     */   static final int TYPE_LENGTH_BYTES = 12;
/*     */   static final int TYPE_ANCHOR = 0;
/*     */   static final int TYPE_BASE = 32;
/*     */   static final int TYPE_TEXT = 64;
/*     */   static final int TYPE_REPEATED_TEXT = 96;
/*     */   static final int TYPE_TEXT_ASCII = 128;
/*     */   static final int TYPE_REPEATED_ASCII = 160;
/*     */   static final int TYPE_REPEATED_SPACE = 192;
/*     */   static final int TYPE_REPEATED_EOL = 224;
/*     */   static final int TYPE_HAS_OFFSET = 256;
/*     */   static final int TYPE_HAS_LENGTH = 512;
/*     */   static final int TYPE_HAS_BOTH = 768;
/*     */   static final int TYPE_HAS_CHAR = 1024;
/*     */   static final int TYPE_HAS_CHARS = 2048;
/*     */   static final int TYPE_HAS_BYTE = 4096;
/*     */   static final int TYPE_HAS_BYTES = 8192;
/*     */   protected final int pos;
/*     */   protected final byte[] bytes;
/*     */   protected final int byteOffset;
/*     */   protected final int startIndex;
/*     */   
/*     */   public enum SegType
/*     */   {
/*  40 */     ANCHOR(256),
/*  41 */     BASE(800),
/*  42 */     TEXT(2624),
/*  43 */     REPEATED_TEXT(1632),
/*  44 */     TEXT_ASCII(8832),
/*  45 */     REPEATED_ASCII(4768),
/*  46 */     REPEATED_SPACE(704),
/*  47 */     REPEATED_EOL(736);
/*     */     
/*     */     public final int flags;
/*     */ 
/*     */     
/*     */     SegType(int param1Int1) {
/*  53 */       this.flags = param1Int1;
/*     */     }
/*     */     
/*     */     public final boolean hasAll(int param1Int) {
/*  57 */       return ((this.flags & param1Int) == param1Int);
/*     */     }
/*     */     
/*     */     public final boolean hasLength() {
/*  61 */       return hasAll(512);
/*     */     }
/*     */     
/*     */     public final boolean hasOffset() {
/*  65 */       return hasAll(256);
/*     */     }
/*     */     
/*     */     public final boolean hasBoth() {
/*  69 */       return hasAll(768);
/*     */     }
/*     */     
/*     */     public final boolean hasChar() {
/*  73 */       return hasAll(1024);
/*     */     }
/*     */     
/*     */     public final boolean hasChars() {
/*  77 */       return hasAll(2048);
/*     */     }
/*     */     
/*     */     public final boolean hasByte() {
/*  81 */       return hasAll(4096);
/*     */     }
/*     */     
/*     */     public final boolean hasBytes() {
/*  85 */       return hasAll(8192);
/*     */     }
/*     */     
/*     */     public static SegType fromTypeMask(int param1Int) {
/*  89 */       switch (param1Int & 0xE0) {
/*     */         case 0:
/*  91 */           return ANCHOR;
/*  92 */         case 32: return BASE;
/*  93 */         case 64: return TEXT;
/*  94 */         case 128: return TEXT_ASCII;
/*  95 */         case 96: return REPEATED_TEXT;
/*  96 */         case 160: return REPEATED_ASCII;
/*  97 */         case 192: return REPEATED_SPACE;
/*  98 */         case 224: return REPEATED_EOL;
/*     */       } 
/*     */ 
/*     */       
/* 102 */       throw new IllegalStateException(String.format("Invalid text type %02x", new Object[] { Integer.valueOf(param1Int) }));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasAll(int paramInt1, int paramInt2) {
/* 108 */     return ((paramInt1 & paramInt2) == paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Segment(int paramInt1, byte[] paramArrayOfbyte, int paramInt2, int paramInt3) {
/* 117 */     this.pos = paramInt1;
/* 118 */     this.bytes = paramArrayOfbyte;
/* 119 */     this.byteOffset = paramInt2;
/* 120 */     this.startIndex = paramInt3;
/*     */   }
/*     */   
/*     */   public int getPos() {
/* 124 */     return this.pos;
/*     */   }
/*     */   
/*     */   public byte[] getBytes() {
/* 128 */     return this.bytes;
/*     */   }
/*     */   
/*     */   public final int getByteOffset() {
/* 132 */     return this.byteOffset;
/*     */   }
/*     */   
/*     */   public final int getStartIndex() {
/* 136 */     return this.startIndex;
/*     */   }
/*     */   
/*     */   public final int getEndIndex() {
/* 140 */     return this.startIndex + length();
/*     */   }
/*     */   
/*     */   public boolean notInSegment(int paramInt) {
/* 144 */     return (paramInt < this.startIndex || paramInt >= this.startIndex + length());
/*     */   }
/*     */   
/*     */   public boolean offsetNotInSegment(int paramInt) {
/* 148 */     return (paramInt < getStartOffset() || paramInt >= getEndOffset());
/*     */   }
/*     */   
/*     */   public final SegType getType() {
/* 152 */     return SegType.fromTypeMask(this.bytes[this.byteOffset]);
/*     */   }
/*     */   
/*     */   public final int getByteLength() {
/* 156 */     return getSegByteLength(getType(), getStartOffset(), length());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract int length();
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean isBase();
/*     */ 
/*     */   
/*     */   public abstract boolean isAnchor();
/*     */ 
/*     */   
/*     */   public abstract boolean isText();
/*     */ 
/*     */   
/*     */   public abstract boolean isFirst256Start();
/*     */ 
/*     */   
/*     */   public String toString() {
/* 178 */     if (isBase()) {
/* 179 */       if (isAnchor()) {
/* 180 */         return "[" + getStartOffset() + ")";
/*     */       }
/* 182 */       return "[" + getStartOffset() + ", " + getEndOffset() + ")";
/*     */     } 
/*     */     
/* 185 */     CharSequence charSequence = getCharSequence();
/* 186 */     if (isRepeatedTextEnd() && length() > 1) {
/* 187 */       if (isFirst256Start()) {
/* 188 */         return "a:" + length() + "x'" + Utils.escapeJavaString(charSequence.subSequence(0, 1)) + "'";
/*     */       }
/* 190 */       return length() + "x'" + Utils.escapeJavaString(charSequence.subSequence(0, 1)) + "'";
/*     */     } 
/*     */     
/*     */     int i;
/* 194 */     charSequence = ((i = charSequence.length()) <= 20) ? charSequence.toString() : (charSequence.subSequence(0, 10).toString() + "…" + charSequence.subSequence(i - 10, i).toString());
/* 195 */     if (isFirst256Start()) {
/* 196 */       return "a:'" + Utils.escapeJavaString(charSequence) + "'";
/*     */     }
/* 198 */     return "'" + Utils.escapeJavaString(charSequence) + "'";
/*     */   }
/*     */   public abstract boolean isRepeatedTextEnd();
/*     */   public abstract int getStartOffset();
/*     */   public abstract int getEndOffset();
/*     */   public abstract CharSequence getCharSequence();
/*     */   public abstract char charAt(int paramInt);
/*     */   static class Base extends Segment { protected final int startOffset;
/*     */     protected final int endOffset;
/*     */     protected final BasedSequence baseSeq;
/*     */     
/*     */     public Base(int param1Int1, byte[] param1ArrayOfbyte, int param1Int2, int param1Int3, BasedSequence param1BasedSequence) {
/* 210 */       super(param1Int1, param1ArrayOfbyte, param1Int2, param1Int3);
/*     */       
/* 212 */       this.baseSeq = param1BasedSequence;
/*     */ 
/*     */       
/* 215 */       if (((param1Int1 = param1ArrayOfbyte[param1Int2++] & 0xFF) & 0xE0) == 0) {
/* 216 */         if (hasAll(param1Int1, 16)) {
/* 217 */           this.endOffset = this.startOffset = param1Int1 & 0xF; return;
/*     */         } 
/* 219 */         param1Int3 = param1Int1 & 0x3;
/* 220 */         this.endOffset = this.startOffset = getInt(param1ArrayOfbyte, param1Int2, param1Int3 + 1);
/*     */         return;
/*     */       } 
/* 223 */       assert !hasAll(param1Int1, 16);
/*     */       
/* 225 */       param1Int3 = param1Int1 & 0x3;
/* 226 */       this.startOffset = getInt(param1ArrayOfbyte, param1Int2, param1Int3 + 1);
/* 227 */       param1Int2 += param1Int3 + 1;
/*     */       
/* 229 */       param1Int1 = (param1Int1 & 0xC) >> 2;
/* 230 */       this.endOffset = this.startOffset + getInt(param1ArrayOfbyte, param1Int2, param1Int1 + 1);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int length() {
/* 236 */       return this.endOffset - this.startOffset;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isBase() {
/* 241 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isAnchor() {
/* 246 */       return (this.startOffset == this.endOffset);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isText() {
/* 251 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isFirst256Start() {
/* 256 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isRepeatedTextEnd() {
/* 261 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getStartOffset() {
/* 266 */       return this.startOffset;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getEndOffset() {
/* 271 */       return this.endOffset;
/*     */     }
/*     */ 
/*     */     
/*     */     public char charAt(int param1Int) {
/* 276 */       if (param1Int < this.startIndex || param1Int - this.startIndex >= length()) {
/* 277 */         throw new IndexOutOfBoundsException("index " + param1Int + " out of bounds [" + this.startIndex + ", " + this.startIndex + length() + ")");
/*     */       }
/* 279 */       return this.baseSeq.charAt(this.startOffset + param1Int - this.startIndex);
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence getCharSequence() {
/* 284 */       return (CharSequence)this.baseSeq.subSequence(this.startOffset, this.endOffset);
/*     */     } }
/*     */ 
/*     */   
/*     */   static abstract class TextCharSequenceBase implements CharSequence {
/*     */     protected final byte[] bytes;
/*     */     protected final int byteOffset;
/*     */     protected final int startOffset;
/*     */     protected final int length;
/*     */     
/*     */     public TextCharSequenceBase(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2, int param1Int3) {
/* 295 */       this.bytes = param1ArrayOfbyte;
/* 296 */       this.byteOffset = param1Int1;
/* 297 */       this.startOffset = param1Int2;
/* 298 */       this.length = param1Int3;
/*     */     }
/*     */ 
/*     */     
/*     */     public int length() {
/* 303 */       return this.length;
/*     */     }
/*     */ 
/*     */     
/*     */     public abstract char charAt(int param1Int);
/*     */ 
/*     */     
/*     */     abstract CharSequence create(int param1Int1, int param1Int2);
/*     */     
/*     */     public CharSequence subSequence(int param1Int1, int param1Int2) {
/* 313 */       if (param1Int1 < 0 || param1Int1 > param1Int2 || param1Int2 > this.length) {
/* 314 */         throw new IndexOutOfBoundsException("Invalid index range [" + param1Int1 + ", " + param1Int2 + "] out of bounds [0, " + length() + ")");
/*     */       }
/* 316 */       return create(this.startOffset + param1Int1, param1Int2 - param1Int1);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 322 */       StringBuilder stringBuilder = new StringBuilder();
/* 323 */       for (byte b = 0; b < this.length; b++) {
/* 324 */         stringBuilder.append(charAt(b));
/*     */       }
/* 326 */       return stringBuilder.toString();
/*     */     }
/*     */   }
/*     */   
/*     */   static class TextCharSequence extends TextCharSequenceBase {
/*     */     public TextCharSequence(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2, int param1Int3) {
/* 332 */       super(param1ArrayOfbyte, param1Int1, param1Int2, param1Int3);
/*     */     }
/*     */ 
/*     */     
/*     */     public char charAt(int param1Int) {
/* 337 */       if (param1Int < 0 || param1Int >= this.length) {
/* 338 */         throw new IndexOutOfBoundsException("index " + param1Int + " out of bounds [0, " + this.length + ")");
/*     */       }
/* 340 */       return Segment.getChar(this.bytes, this.byteOffset + (this.startOffset + param1Int << 1));
/*     */     }
/*     */ 
/*     */     
/*     */     CharSequence create(int param1Int1, int param1Int2) {
/* 345 */       return new TextCharSequence(this.bytes, this.byteOffset, param1Int1, param1Int2);
/*     */     }
/*     */   }
/*     */   
/*     */   static class TextAsciiCharSequence extends TextCharSequenceBase {
/*     */     public TextAsciiCharSequence(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2, int param1Int3) {
/* 351 */       super(param1ArrayOfbyte, param1Int1, param1Int2, param1Int3);
/*     */     }
/*     */ 
/*     */     
/*     */     public char charAt(int param1Int) {
/* 356 */       if (param1Int < 0 || param1Int >= this.length) {
/* 357 */         throw new IndexOutOfBoundsException("index " + param1Int + " out of bounds [0, " + this.length + ")");
/*     */       }
/*     */       
/* 360 */       return (char)(0xFF & this.bytes[this.byteOffset + this.startOffset + param1Int]);
/*     */     }
/*     */ 
/*     */     
/*     */     CharSequence create(int param1Int1, int param1Int2) {
/* 365 */       return new TextAsciiCharSequence(this.bytes, this.byteOffset, param1Int1, param1Int2);
/*     */     }
/*     */   }
/*     */   
/*     */   static class TextRepeatedSequence implements CharSequence {
/*     */     protected final char c;
/*     */     protected final int length;
/*     */     
/*     */     public TextRepeatedSequence(char param1Char, int param1Int) {
/* 374 */       this.c = param1Char;
/* 375 */       this.length = param1Int;
/*     */     }
/*     */ 
/*     */     
/*     */     public int length() {
/* 380 */       return this.length;
/*     */     }
/*     */ 
/*     */     
/*     */     public char charAt(int param1Int) {
/* 385 */       if (param1Int < 0 || param1Int >= this.length) {
/* 386 */         throw new IndexOutOfBoundsException("index " + param1Int + " out of bounds [0, " + this.length + ")");
/*     */       }
/* 388 */       return this.c;
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence subSequence(int param1Int1, int param1Int2) {
/* 393 */       if (param1Int1 < 0 || param1Int1 > param1Int2 || param1Int2 > this.length) {
/* 394 */         throw new IndexOutOfBoundsException("Invalid index range [" + param1Int1 + ", " + param1Int2 + "] out of bounds [0, " + length() + ")");
/*     */       }
/* 396 */       return new TextRepeatedSequence(this.c, param1Int2 - param1Int1);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 402 */       StringBuilder stringBuilder = new StringBuilder();
/* 403 */       for (byte b = 0; b < this.length; b++) {
/* 404 */         stringBuilder.append(this.c);
/*     */       }
/* 406 */       return stringBuilder.toString();
/*     */     }
/*     */   }
/*     */   
/*     */   static class Text extends Segment {
/*     */     protected final CharSequence chars;
/*     */     
/*     */     public Text(int param1Int1, byte[] param1ArrayOfbyte, int param1Int2, int param1Int3) {
/* 414 */       super(param1Int1, param1ArrayOfbyte, param1Int2, param1Int3);
/*     */       
/* 416 */       param1Int3 = (param1Int1 = param1ArrayOfbyte[param1Int2++] & 0xFF) & 0xE0;
/*     */ 
/*     */ 
/*     */       
/* 420 */       if (hasAll(param1Int1, 16)) {
/* 421 */         param1Int1 &= 0xF;
/*     */       } else {
/* 423 */         int i = (param1Int1 & 0xC) >> 2;
/* 424 */         param1Int1 = getInt(param1ArrayOfbyte, param1Int2, i + 1);
/* 425 */         param1Int2 += i + 1;
/*     */       } 
/*     */       
/* 428 */       switch (param1Int3) {
/*     */         case 64:
/* 430 */           this.chars = new Segment.TextCharSequence(param1ArrayOfbyte, param1Int2, 0, param1Int1);
/*     */           return;
/*     */         
/*     */         case 128:
/* 434 */           this.chars = new Segment.TextAsciiCharSequence(param1ArrayOfbyte, param1Int2, 0, param1Int1);
/*     */           return;
/*     */         
/*     */         case 96:
/* 438 */           this.chars = new Segment.TextRepeatedSequence(getChar(param1ArrayOfbyte, param1Int2), param1Int1);
/*     */           return;
/*     */         
/*     */         case 160:
/* 442 */           this.chars = new Segment.TextRepeatedSequence((char)(0xFF & param1ArrayOfbyte[param1Int2]), param1Int1);
/*     */           return;
/*     */         
/*     */         case 192:
/* 446 */           this.chars = new Segment.TextRepeatedSequence(' ', param1Int1);
/*     */           return;
/*     */         
/*     */         case 224:
/* 450 */           this.chars = new Segment.TextRepeatedSequence('\n', param1Int1);
/*     */           return;
/*     */       } 
/*     */       
/* 454 */       throw new IllegalStateException("Invalid text type " + param1Int3);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int length() {
/* 460 */       return this.chars.length();
/*     */     }
/*     */ 
/*     */     
/*     */     public char charAt(int param1Int) {
/* 465 */       if (param1Int < this.startIndex || param1Int - this.startIndex >= this.chars.length()) {
/* 466 */         throw new IndexOutOfBoundsException("index " + param1Int + " out of bounds [" + this.startIndex + ", " + this.startIndex + this.chars.length() + ")");
/*     */       }
/* 468 */       return this.chars.charAt(param1Int - this.startIndex);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isBase() {
/* 473 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isAnchor() {
/* 478 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isText() {
/* 483 */       return true;
/*     */     }
/*     */     
/*     */     int textType() {
/* 487 */       return this.bytes[this.byteOffset] & 0xE0;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isFirst256Start() {
/*     */       int i;
/* 493 */       if ((i = textType()) == 128 || i == 160 || i == 192 || i == 224) return true;  return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isRepeatedTextEnd() {
/*     */       int i;
/* 499 */       if ((i = textType()) == 96 || i == 160 || i == 192 || i == 224) return true;  return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getStartOffset() {
/* 504 */       return -1;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getEndOffset() {
/* 509 */       return -1;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public CharSequence getCharSequence() {
/* 515 */       return this.chars;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static Segment getSegment(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, BasedSequence paramBasedSequence) {
/*     */     int i;
/* 522 */     switch (i = paramArrayOfbyte[paramInt1] & 0xE0) {
/*     */       case 0:
/*     */       case 32:
/* 525 */         return new Base(paramInt2, paramArrayOfbyte, paramInt1, paramInt3, paramBasedSequence);
/*     */       
/*     */       case 64:
/*     */       case 96:
/*     */       case 128:
/*     */       case 160:
/*     */       case 192:
/*     */       case 224:
/* 533 */         return new Text(paramInt2, paramArrayOfbyte, paramInt1, paramInt3);
/*     */     } 
/*     */     
/* 536 */     throw new IllegalStateException("Invalid text type " + i);
/*     */   }
/*     */   
/*     */   public static SegType getSegType(Seg paramSeg, CharSequence paramCharSequence) {
/*     */     char c;
/* 541 */     if (paramSeg.isBase())
/* 542 */       return paramSeg.isAnchor() ? SegType.ANCHOR : SegType.BASE; 
/* 543 */     if (paramSeg.isText()) {
/* 544 */       boolean bool1 = paramSeg.isFirst256Start();
/* 545 */       boolean bool2 = paramSeg.isRepeatedTextEnd();
/*     */       
/* 547 */       if (bool1) {
/*     */         
/* 549 */         if (bool2) {
/*     */ 
/*     */           
/* 552 */           if ((c = paramCharSequence.charAt(paramSeg.getTextStart())) == ' ') return SegType.REPEATED_SPACE; 
/* 553 */           if (c == '\n') return SegType.REPEATED_EOL; 
/* 554 */           return SegType.REPEATED_ASCII;
/*     */         } 
/* 556 */         return SegType.TEXT_ASCII;
/*     */       } 
/*     */       
/* 559 */       return bool2 ? SegType.REPEATED_TEXT : SegType.TEXT;
/*     */     } 
/*     */     
/* 562 */     throw new IllegalStateException("Unknown seg type " + c);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getOffsetBytes(int paramInt) {
/* 567 */     return (paramInt < 16) ? 0 : ((paramInt < 256) ? 1 : ((paramInt < 65536) ? 2 : ((paramInt < 16777216) ? 3 : 4)));
/*     */   }
/*     */   
/*     */   public static int getLengthBytes(int paramInt) {
/* 571 */     return (paramInt < 16) ? 0 : ((paramInt < 256) ? 1 : ((paramInt < 65536) ? 2 : ((paramInt < 16777216) ? 3 : 4)));
/*     */   }
/*     */   
/*     */   public static int getIntBytes(int paramInt) {
/* 575 */     return (paramInt < 256) ? 1 : ((paramInt < 65536) ? 2 : ((paramInt < 16777216) ? 3 : 4));
/*     */   }
/*     */   
/*     */   public static int getSegByteLength(SegType paramSegType, int paramInt1, int paramInt2) {
/* 579 */     int i = 1;
/*     */     
/* 581 */     if (paramSegType.hasBoth()) {
/* 582 */       i = 1 + getIntBytes(paramInt1) + getIntBytes(paramInt2);
/* 583 */     } else if (paramSegType.hasOffset()) {
/* 584 */       i = 1 + getOffsetBytes(paramInt1);
/* 585 */     } else if (paramSegType.hasLength()) {
/* 586 */       i = 1 + getLengthBytes(paramInt2);
/*     */     } 
/*     */     
/* 589 */     if (paramSegType.hasChar()) { i += 2; }
/* 590 */     else if (paramSegType.hasChars()) { i += 2 * paramInt2; }
/* 591 */     else if (paramSegType.hasByte()) { i++; }
/* 592 */     else if (paramSegType.hasBytes()) { i += paramInt2; }
/*     */     
/* 594 */     return i;
/*     */   }
/*     */   
/*     */   public static int getSegByteLength(Seg paramSeg, CharSequence paramCharSequence) {
/*     */     SegType segType;
/* 599 */     return getSegByteLength(segType = getSegType(paramSeg, paramCharSequence), paramSeg.getSegStart(), paramSeg.length());
/*     */   }
/*     */   
/*     */   public static int addIntBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
/* 603 */     switch (paramInt3) {
/*     */       case 4:
/* 605 */         paramArrayOfbyte[paramInt1++] = (byte)(paramInt2 >> 24);
/*     */       case 3:
/* 607 */         paramArrayOfbyte[paramInt1++] = (byte)(paramInt2 >> 16 & 0xFF);
/*     */       case 2:
/* 609 */         paramArrayOfbyte[paramInt1++] = (byte)(paramInt2 >> 8 & 0xFF);
/*     */       case 1:
/* 611 */         paramArrayOfbyte[paramInt1++] = (byte)paramInt2; break;
/*     */     } 
/* 613 */     return paramInt1;
/*     */   }
/*     */   
/*     */   public static int getInt(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 617 */     int i = 0;
/*     */     
/* 619 */     switch (paramInt2) {
/*     */       case 4:
/* 621 */         i = 0x0 | (0xFF & paramArrayOfbyte[paramInt1++]) << 24;
/*     */       case 3:
/* 623 */         i |= (0xFF & paramArrayOfbyte[paramInt1++]) << 16;
/*     */       case 2:
/* 625 */         i |= (0xFF & paramArrayOfbyte[paramInt1++]) << 8;
/*     */       case 1:
/* 627 */         i |= 0xFF & paramArrayOfbyte[paramInt1]; break;
/*     */     } 
/* 629 */     return i;
/*     */   }
/*     */   
/*     */   public static int addChar(byte[] paramArrayOfbyte, int paramInt, char paramChar) {
/* 633 */     paramArrayOfbyte[paramInt++] = (byte)(paramChar >> 8 & 0xFF);
/* 634 */     paramArrayOfbyte[paramInt++] = (byte)paramChar;
/* 635 */     return paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public static char getChar(byte[] paramArrayOfbyte, int paramInt) {
/*     */     char c;
/* 641 */     return c = (char)((c = (char)((0xFF & paramArrayOfbyte[paramInt++]) << 8)) | 0xFF & paramArrayOfbyte[paramInt]);
/*     */   }
/*     */   
/*     */   public static int addChars(byte[] paramArrayOfbyte, int paramInt1, CharSequence paramCharSequence, int paramInt2, int paramInt3) {
/* 645 */     for (paramInt2 = paramInt2; paramInt2 < paramInt3; paramInt2++) {
/* 646 */       char c = paramCharSequence.charAt(paramInt2);
/* 647 */       paramArrayOfbyte[paramInt1++] = (byte)(c >> 8 & 0xFF);
/* 648 */       paramArrayOfbyte[paramInt1++] = (byte)c;
/*     */     } 
/* 650 */     return paramInt1;
/*     */   }
/*     */   
/*     */   public static int addCharAscii(byte[] paramArrayOfbyte, int paramInt, char paramChar) {
/* 654 */     assert paramChar < 'Ā';
/* 655 */     paramArrayOfbyte[paramInt++] = (byte)paramChar;
/* 656 */     return paramInt;
/*     */   }
/*     */   
/*     */   public static int addCharsAscii(byte[] paramArrayOfbyte, int paramInt1, CharSequence paramCharSequence, int paramInt2, int paramInt3) {
/* 660 */     for (paramInt2 = paramInt2; paramInt2 < paramInt3; paramInt2++) {
/* 661 */       char c = paramCharSequence.charAt(paramInt2);
/* 662 */       assert c < 'Ā';
/* 663 */       paramArrayOfbyte[paramInt1++] = (byte)c;
/*     */     } 
/* 665 */     return paramInt1;
/*     */   }
/*     */   
/*     */   public static char getCharAscii(byte[] paramArrayOfbyte, int paramInt) {
/* 669 */     return (char)(0xFF & paramArrayOfbyte[paramInt]);
/*     */   }
/*     */   
/*     */   public static int addSegBytes(byte[] paramArrayOfbyte, int paramInt, Seg paramSeg, CharSequence paramCharSequence) {
/* 673 */     SegType segType = getSegType(paramSeg, paramCharSequence);
/* 674 */     int i = paramSeg.length();
/*     */     
/* 676 */     if (segType.hasOffset()) {
/* 677 */       int j = paramSeg.getStart();
/*     */       
/* 679 */       if (segType.hasLength()) {
/* 680 */         int k = getIntBytes(j);
/* 681 */         int m = getIntBytes(i);
/*     */         
/* 683 */         paramArrayOfbyte[paramInt++] = (byte)(segType.flags | k - 1 | m - 1 << 2);
/* 684 */         paramInt = addIntBytes(paramArrayOfbyte, paramInt, j, k);
/* 685 */         paramInt = addIntBytes(paramArrayOfbyte, paramInt, i, m);
/*     */       } else {
/*     */         int k;
/* 688 */         if ((k = getOffsetBytes(j)) == 0) {
/* 689 */           assert j < 16;
/* 690 */           paramArrayOfbyte[paramInt++] = (byte)(segType.flags | 0x10 | j);
/*     */         } else {
/* 692 */           paramArrayOfbyte[paramInt++] = (byte)(segType.flags | k - 1);
/* 693 */           paramInt = addIntBytes(paramArrayOfbyte, paramInt, j, k);
/*     */         } 
/*     */       } 
/* 696 */     } else if (segType.hasLength()) {
/*     */       int j;
/* 698 */       if ((j = getLengthBytes(i)) == 0) {
/* 699 */         assert i < 16;
/* 700 */         paramArrayOfbyte[paramInt++] = (byte)(segType.flags | 0x10 | i);
/*     */       } else {
/* 702 */         paramArrayOfbyte[paramInt++] = (byte)(segType.flags | j - 1 << 2);
/* 703 */         paramInt = addIntBytes(paramArrayOfbyte, paramInt, i, j);
/*     */       } 
/*     */     } 
/*     */     
/* 707 */     if (segType.hasChar()) { paramInt = addChar(paramArrayOfbyte, paramInt, paramCharSequence.charAt(paramSeg.getTextStart())); }
/* 708 */     else if (segType.hasChars()) { paramInt = addChars(paramArrayOfbyte, paramInt, paramCharSequence, paramSeg.getTextStart(), paramSeg.getTextEnd()); }
/* 709 */     else if (segType.hasByte()) { paramInt = addCharAscii(paramArrayOfbyte, paramInt, paramCharSequence.charAt(paramSeg.getTextStart())); }
/* 710 */     else if (segType.hasBytes()) { paramInt = addCharsAscii(paramArrayOfbyte, paramInt, paramCharSequence, paramSeg.getTextStart(), paramSeg.getTextEnd()); }
/*     */     
/* 712 */     return paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\builder\tree\Segment.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */