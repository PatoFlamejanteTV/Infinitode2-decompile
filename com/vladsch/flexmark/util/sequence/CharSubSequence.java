/*     */ package com.vladsch.flexmark.util.sequence;
/*     */ 
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.data.DataKeyBase;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class CharSubSequence
/*     */   extends BasedSequenceImpl
/*     */ {
/*     */   private final char[] baseChars;
/*     */   private final CharSubSequence base;
/*     */   private final int startOffset;
/*     */   private final int endOffset;
/*     */   
/*     */   private CharSubSequence(char[] paramArrayOfchar, int paramInt) {
/*  21 */     super(paramInt);
/*     */ 
/*     */     
/*  24 */     this.base = this;
/*  25 */     this.baseChars = paramArrayOfchar;
/*  26 */     this.startOffset = 0;
/*  27 */     this.endOffset = this.baseChars.length;
/*     */   }
/*     */   
/*     */   private CharSubSequence(CharSubSequence paramCharSubSequence, int paramInt1, int paramInt2) {
/*  31 */     super(0);
/*     */     
/*  33 */     assert paramInt1 >= 0 && paramInt2 >= paramInt1 && paramInt2 <= paramCharSubSequence.baseChars.length : String.format("CharSubSequence must have (startIndex > 0 || endIndex < %d) && endIndex >= startIndex, got startIndex:%d, endIndex: %d", new Object[] { Integer.valueOf(paramCharSubSequence.baseChars.length), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
/*  34 */     assert paramInt1 > 0 || paramInt2 < paramCharSubSequence.baseChars.length : String.format("CharSubSequence must be proper subsequences [1, %d) got startIndex:%d, endIndex: %d", new Object[] { Integer.valueOf(Math.max(false, paramCharSubSequence.baseChars.length - true)), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
/*     */     
/*  36 */     this.base = paramCharSubSequence;
/*  37 */     this.baseChars = paramCharSubSequence.baseChars;
/*  38 */     this.base.startOffset += paramInt1;
/*  39 */     this.endOffset = this.base.startOffset + paramInt2;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getOptionFlags() {
/*  44 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean allOptions(int paramInt) {
/*  49 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean anyOptions(int paramInt) {
/*  54 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final <T> T getOption(DataKeyBase<T> paramDataKeyBase) {
/*  59 */     return (T)paramDataKeyBase.get(null);
/*     */   }
/*     */ 
/*     */   
/*     */   public final DataHolder getOptions() {
/*  64 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final CharSubSequence getBaseSequence() {
/*  70 */     return this.base;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final char[] getBase() {
/*  76 */     return this.baseChars;
/*     */   }
/*     */   
/*     */   public final int getStartOffset() {
/*  80 */     return this.startOffset;
/*     */   }
/*     */   
/*     */   public final int getEndOffset() {
/*  84 */     return this.endOffset;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int length() {
/*  89 */     return this.endOffset - this.startOffset;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Range getSourceRange() {
/*  95 */     return Range.of(this.startOffset, this.endOffset);
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getIndexOffset(int paramInt) {
/* 100 */     SequenceUtils.validateIndexInclusiveEnd(paramInt, length());
/* 101 */     return this.startOffset + paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public final char charAt(int paramInt) {
/* 106 */     SequenceUtils.validateIndex(paramInt, length());
/*     */     
/* 108 */     return ((paramInt = this.baseChars[paramInt + this.startOffset]) == 0) ? '�' : paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final CharSubSequence subSequence(int paramInt1, int paramInt2) {
/* 114 */     SequenceUtils.validateStartEnd(paramInt1, paramInt2, length());
/* 115 */     return this.base.baseSubSequence(this.startOffset + paramInt1, this.startOffset + paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final CharSubSequence baseSubSequence(int paramInt1, int paramInt2) {
/* 121 */     SequenceUtils.validateStartEnd(paramInt1, paramInt2, this.baseChars.length);
/* 122 */     return (paramInt1 == this.startOffset && paramInt2 == this.endOffset) ? this : ((this.base != this) ? this.base.baseSubSequence(paramInt1, paramInt2) : new CharSubSequence(this.base, paramInt1, paramInt2));
/*     */   }
/*     */   
/*     */   public static CharSubSequence of(CharSequence paramCharSequence) {
/* 126 */     return of(paramCharSequence, 0, paramCharSequence.length());
/*     */   }
/*     */   
/*     */   public static CharSubSequence of(CharSequence paramCharSequence, int paramInt) {
/* 130 */     assert paramInt <= paramCharSequence.length();
/* 131 */     return of(paramCharSequence, paramInt, paramCharSequence.length());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static CharSubSequence of(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 143 */     assert paramInt1 >= 0 && paramInt1 <= paramInt2 && paramInt2 <= paramArrayOfchar.length;
/*     */     
/* 145 */     char[] arrayOfChar = new char[paramArrayOfchar.length];
/* 146 */     System.arraycopy(paramArrayOfchar, 0, arrayOfChar, 0, paramArrayOfchar.length);
/* 147 */     return (paramInt1 == 0 && paramInt2 == paramArrayOfchar.length) ? new CharSubSequence(arrayOfChar, 0) : (new CharSubSequence(arrayOfChar, 0)).subSequence(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static CharSubSequence of(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/*     */     CharSubSequence charSubSequence;
/* 159 */     assert paramInt1 >= 0 && paramInt1 <= paramInt2 && paramInt2 <= paramCharSequence.length();
/*     */ 
/*     */ 
/*     */     
/* 163 */     if (paramCharSequence instanceof CharSubSequence) {
/* 164 */       charSubSequence = (CharSubSequence)paramCharSequence;
/* 165 */     } else if (paramCharSequence instanceof String) {
/* 166 */       charSubSequence = new CharSubSequence(((String)paramCharSequence).toCharArray(), ((String)paramCharSequence).hashCode());
/* 167 */     } else if (paramCharSequence instanceof StringBuilder) {
/* 168 */       char[] arrayOfChar = new char[paramCharSequence.length()];
/* 169 */       ((StringBuilder)paramCharSequence).getChars(0, paramCharSequence.length(), arrayOfChar, 0);
/* 170 */       charSubSequence = new CharSubSequence(arrayOfChar, 0);
/*     */     } else {
/* 172 */       charSubSequence = new CharSubSequence(paramCharSequence.toString().toCharArray(), 0);
/*     */     } 
/*     */     
/* 175 */     if (paramInt1 == 0 && paramInt2 == paramCharSequence.length()) {
/* 176 */       return charSubSequence;
/*     */     }
/* 178 */     return charSubSequence.subSequence(paramInt1, paramInt2);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\CharSubSequence.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */