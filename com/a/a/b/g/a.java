/*     */ package com.a.a.b.g;
/*     */ 
/*     */ import java.util.concurrent.atomic.AtomicReferenceArray;
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
/*     */ public final class a
/*     */ {
/*  76 */   private static final int[] a = new int[] { 8000, 8000, 2000, 2000 };
/*  77 */   private static final int[] b = new int[] { 4000, 4000, 200, 200 };
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
/*     */   public a() {
/*  96 */     this(4, 4);
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
/* 109 */   private AtomicReferenceArray<byte[]> c = (AtomicReferenceArray)new AtomicReferenceArray<>(4);
/* 110 */   private AtomicReferenceArray<char[]> d = (AtomicReferenceArray)new AtomicReferenceArray<>(4);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private a(int paramInt1, int paramInt2) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final byte[] a(int paramInt) {
/* 125 */     return b(paramInt, 0);
/*     */   }
/*     */   
/*     */   private byte[] b(int paramInt1, int paramInt2) {
/* 129 */     int i = c(paramInt1);
/* 130 */     if (i > 0) {
/* 131 */       paramInt2 = i;
/*     */     }
/*     */     byte[] arrayOfByte;
/* 134 */     if ((arrayOfByte = this.c.getAndSet(paramInt1, null)) == null || arrayOfByte.length < paramInt2) {
/* 135 */       arrayOfByte = e(paramInt2);
/*     */     }
/* 137 */     return arrayOfByte;
/*     */   }
/*     */   
/*     */   public final void a(int paramInt, byte[] paramArrayOfbyte) {
/* 141 */     this.c.set(paramInt, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final char[] b(int paramInt) {
/* 151 */     return a(paramInt, 0);
/*     */   }
/*     */   
/*     */   public final char[] a(int paramInt1, int paramInt2) {
/* 155 */     int i = d(paramInt1);
/* 156 */     if (paramInt2 < i) {
/* 157 */       paramInt2 = i;
/*     */     }
/*     */     char[] arrayOfChar;
/* 160 */     if ((arrayOfChar = this.d.getAndSet(paramInt1, null)) == null || arrayOfChar.length < paramInt2) {
/* 161 */       arrayOfChar = f(paramInt2);
/*     */     }
/* 163 */     return arrayOfChar;
/*     */   }
/*     */   
/*     */   public final void a(int paramInt, char[] paramArrayOfchar) {
/* 167 */     this.d.set(paramInt, paramArrayOfchar);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int c(int paramInt) {
/* 177 */     return a[paramInt];
/*     */   }
/*     */   
/*     */   private static int d(int paramInt) {
/* 181 */     return b[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static byte[] e(int paramInt) {
/* 190 */     return new byte[paramInt]; } private static char[] f(int paramInt) {
/* 191 */     return new char[paramInt];
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\g\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */