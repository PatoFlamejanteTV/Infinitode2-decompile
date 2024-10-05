/*     */ package com.vladsch.flexmark.util.sequence.builder;
/*     */ 
/*     */ import com.vladsch.flexmark.util.misc.Utils;
/*     */ import com.vladsch.flexmark.util.sequence.Range;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Seg
/*     */ {
/*  15 */   public static final Seg NULL = new Seg(Range.NULL.getStart(), Range.NULL.getEnd());
/*  16 */   public static final Seg ANCHOR_0 = new Seg(0, 0);
/*     */   
/*     */   public static final int MAX_TEXT_OFFSET = 1073741823;
/*     */   public static final int F_TEXT_OPTION = 1073741824;
/*     */   private final int start;
/*     */   private final int end;
/*     */   
/*     */   private Seg(int paramInt1, int paramInt2) {
/*  24 */     this.start = paramInt1;
/*  25 */     this.end = paramInt2;
/*     */   }
/*     */   
/*     */   public int getStart() {
/*  29 */     return this.start;
/*     */   }
/*     */   
/*     */   public int getEnd() {
/*  33 */     return this.end;
/*     */   }
/*     */   
/*     */   public int getSegStart() {
/*  37 */     return isText() ? getTextStart() : this.start;
/*     */   }
/*     */   
/*     */   public int getSegEnd() {
/*  41 */     return isText() ? getTextEnd() : this.end;
/*     */   }
/*     */   
/*     */   public int getTextStart() {
/*  45 */     return getTextOffset(this.start);
/*     */   }
/*     */   
/*     */   public static int getTextOffset(int paramInt) {
/*  49 */     return -paramInt - 1 & 0x3FFFFFFF;
/*     */   }
/*     */   
/*     */   public int getTextEnd() {
/*  53 */     return getTextOffset(this.end);
/*     */   }
/*     */   
/*     */   public boolean isFirst256Start() {
/*  57 */     return isFirst256Start(this.start);
/*     */   }
/*     */   
/*     */   public static boolean isFirst256Start(int paramInt) {
/*  61 */     return ((-paramInt - 1 & 0x40000000) != 0);
/*     */   }
/*     */   
/*     */   public boolean isRepeatedTextEnd() {
/*  65 */     return isRepeatedTextEnd(this.end);
/*     */   }
/*     */   
/*     */   public static boolean isRepeatedTextEnd(int paramInt) {
/*  69 */     return ((-paramInt - 1 & 0x40000000) != 0);
/*     */   }
/*     */   
/*     */   public boolean isText() {
/*  73 */     return (this.start < 0 && this.end < 0 && (this.start & 0x3FFFFFFF) > (this.end & 0x3FFFFFFF));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBase() {
/*  82 */     return (this.start >= 0 && this.end >= 0 && this.start <= this.end);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAnchor() {
/*  91 */     return (this.start >= 0 && this.end >= 0 && this.start == this.end);
/*     */   }
/*     */   
/*     */   public boolean isNull() {
/*  95 */     return (!isBase() && !isText());
/*     */   }
/*     */ 
/*     */   
/*     */   public Range getRange() {
/* 100 */     assert isBase();
/* 101 */     return Range.of(this.start, this.end);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int length() {
/* 110 */     return isBase() ? (this.end - this.start) : (isText() ? ((this.start & 0x3FFFFFFF) - (this.end & 0x3FFFFFFF)) : 0);
/*     */   }
/*     */   
/*     */   public String toString(CharSequence paramCharSequence) {
/* 114 */     if (isNull())
/* 115 */       return "NULL"; 
/* 116 */     if (isBase()) {
/* 117 */       if (this.start == this.end) {
/* 118 */         return "[" + this.start + ")";
/*     */       }
/* 120 */       return "[" + this.start + ", " + this.end + ")";
/*     */     } 
/*     */     
/* 123 */     paramCharSequence = paramCharSequence.subSequence(getTextStart(), getTextEnd());
/*     */     
/* 125 */     if (isRepeatedTextEnd() && length() > 1) {
/* 126 */       if (isFirst256Start()) {
/* 127 */         return "a:" + length() + "x'" + Utils.escapeJavaString(paramCharSequence.subSequence(0, 1)) + "'";
/*     */       }
/* 129 */       return length() + "x'" + Utils.escapeJavaString(paramCharSequence.subSequence(0, 1)) + "'";
/*     */     } 
/*     */     
/* 132 */     paramCharSequence = (length() <= 20) ? paramCharSequence.toString() : (paramCharSequence.subSequence(0, 10).toString() + "…" + paramCharSequence.subSequence(length() - 10, length()).toString());
/* 133 */     if (isFirst256Start()) {
/* 134 */       return "a:'" + Utils.escapeJavaString(paramCharSequence) + "'";
/*     */     }
/* 136 */     return "'" + Utils.escapeJavaString(paramCharSequence) + "'";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 144 */     if (isNull())
/* 145 */       return "NULL"; 
/* 146 */     if (isBase()) {
/* 147 */       if (this.start == this.end) {
/* 148 */         return "BASE[" + this.start + ")";
/*     */       }
/* 150 */       return "BASE[" + this.start + ", " + this.end + ")";
/*     */     } 
/*     */     
/* 153 */     return "TEXT[" + getTextStart() + ", " + getTextEnd() + ")";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Seg segOf(int paramInt1, int paramInt2) {
/* 159 */     return (paramInt1 == 0 && paramInt2 == 0) ? ANCHOR_0 : new Seg(paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public static int getTextStart(int paramInt, boolean paramBoolean) {
/* 163 */     assert paramInt < 1073741823;
/* 164 */     return -(paramBoolean ? (paramInt | 0x40000000) : paramInt) - 1;
/*     */   }
/*     */   
/*     */   public static int getTextEnd(int paramInt, boolean paramBoolean) {
/* 168 */     assert paramInt < 1073741823;
/* 169 */     return -(paramBoolean ? (paramInt | 0x40000000) : paramInt) - 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Seg textOf(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
/* 174 */     return new Seg(getTextStart(paramInt1, paramBoolean1), getTextEnd(paramInt2, paramBoolean2));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\builder\Seg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */