/*     */ package com.vladsch.flexmark.util.sequence;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RepeatedSequence
/*     */   implements CharSequence
/*     */ {
/*  13 */   public static RepeatedSequence NULL = new RepeatedSequence(BasedSequence.NULL, 0, 0);
/*     */   
/*     */   private final CharSequence chars;
/*     */   private final int startIndex;
/*     */   private final int endIndex;
/*     */   private int hashCode;
/*     */   
/*     */   private RepeatedSequence(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/*  21 */     this.chars = paramCharSequence;
/*  22 */     this.startIndex = paramInt1;
/*  23 */     this.endIndex = paramInt2;
/*     */   }
/*     */ 
/*     */   
/*     */   public int length() {
/*  28 */     return this.endIndex - this.startIndex;
/*     */   }
/*     */ 
/*     */   
/*     */   public char charAt(int paramInt) {
/*  33 */     if (paramInt < 0 || paramInt >= this.endIndex - this.startIndex) throw new IndexOutOfBoundsException(); 
/*  34 */     return this.chars.charAt((this.startIndex + paramInt) % this.chars.length());
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence subSequence(int paramInt1, int paramInt2) {
/*  39 */     if (paramInt1 >= 0 && paramInt1 <= paramInt2 && paramInt2 <= this.endIndex - this.startIndex) {
/*  40 */       return (paramInt1 == paramInt2) ? NULL : ((paramInt1 == this.startIndex && paramInt2 == this.endIndex) ? this : new RepeatedSequence(this.chars, this.startIndex + paramInt1, this.startIndex + paramInt2));
/*     */     }
/*     */     
/*  43 */     throw new IllegalArgumentException("subSequence($startIndex, $endIndex) in RepeatedCharSequence('', " + this.startIndex + ", " + this.endIndex + ")");
/*     */   }
/*     */   
/*     */   public RepeatedSequence repeat(int paramInt) {
/*  47 */     paramInt = this.startIndex + (this.endIndex - this.startIndex) * paramInt;
/*  48 */     return (this.startIndex >= this.endIndex) ? NULL : ((this.endIndex == paramInt) ? this : new RepeatedSequence(this.chars, this.startIndex, paramInt));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*     */     int i;
/*  54 */     if ((i = this.hashCode) == 0 && length() > 0) {
/*  55 */       for (byte b = 0; b < length(); b++) {
/*  56 */         i = i * 31 + charAt(b);
/*     */       }
/*  58 */       this.hashCode = i;
/*     */     } 
/*  60 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/*  65 */     return (paramObject == this || (paramObject instanceof CharSequence && toString().equals(paramObject.toString())));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*     */     StringBuilder stringBuilder;
/*  72 */     (stringBuilder = new StringBuilder()).append(this, 0, length());
/*  73 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public static CharSequence ofSpaces(int paramInt) {
/*  78 */     return new RepeatedSequence(" ", 0, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public static CharSequence repeatOf(char paramChar, int paramInt) {
/*  83 */     return new RepeatedSequence(String.valueOf(paramChar), 0, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public static CharSequence repeatOf(CharSequence paramCharSequence, int paramInt) {
/*  88 */     return new RepeatedSequence(paramCharSequence, 0, paramCharSequence.length() * paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public static CharSequence repeatOf(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/*  93 */     return new RepeatedSequence(paramCharSequence, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static CharSequence of(char paramChar, int paramInt) {
/*  99 */     return repeatOf(paramChar, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static CharSequence of(CharSequence paramCharSequence, int paramInt) {
/* 105 */     return repeatOf(paramCharSequence, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static CharSequence of(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/* 111 */     return repeatOf(paramCharSequence, paramInt1, paramInt2);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\RepeatedSequence.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */