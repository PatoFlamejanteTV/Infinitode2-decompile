/*     */ package org.a.c.i;
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
/*     */ public final class e
/*     */ {
/*     */   private static final long[] a;
/*     */   private static final int[] b;
/*     */   
/*     */   static {
/*  39 */     (a = new long[19])[0] = 1L;
/*     */     byte b;
/*  41 */     for (b = 1; b < a.length; b++)
/*     */     {
/*  43 */       a[b] = a[b - 1] * 10L;
/*     */     }
/*     */ 
/*     */     
/*  47 */     (b = new int[10])[0] = 1;
/*     */     
/*  49 */     for (b = 1; b < b.length; b++)
/*     */     {
/*  51 */       b[b] = b[b - 1] * 10;
/*     */     }
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
/*     */   public static int a(float paramFloat, int paramInt, byte[] paramArrayOfbyte) {
/*  77 */     if (Float.isNaN(paramFloat) || 
/*  78 */       Float.isInfinite(paramFloat) || paramFloat > 9.223372E18F || paramFloat <= -9.223372E18F || paramInt > 5)
/*     */     {
/*     */ 
/*     */ 
/*     */       
/*  83 */       return -1;
/*     */     }
/*     */     
/*  86 */     int i = 0;
/*  87 */     long l1 = (long)paramFloat;
/*     */ 
/*     */     
/*  90 */     if (paramFloat < 0.0F) {
/*     */       
/*  92 */       i++; paramArrayOfbyte[0] = 45;
/*  93 */       l1 = -l1;
/*     */     } 
/*     */ 
/*     */     
/*     */     long l2;
/*     */ 
/*     */     
/* 100 */     if ((l2 = (long)((Math.abs(paramFloat) - l1) * a[paramInt] + 0.5D)) >= a[paramInt]) {
/* 101 */       l1++;
/* 102 */       l2 -= a[paramInt];
/*     */     } 
/*     */ 
/*     */     
/* 106 */     i = a(l1, a(l1), false, paramArrayOfbyte, i);
/*     */     
/* 108 */     if (l2 > 0L && paramInt > 0) {
/*     */       
/* 110 */       paramArrayOfbyte[i++] = 46;
/* 111 */       i = a(l2, paramInt - 1, true, paramArrayOfbyte, i);
/*     */     } 
/*     */     
/* 114 */     return i;
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
/*     */   private static int a(long paramLong, int paramInt1, boolean paramBoolean, byte[] paramArrayOfbyte, int paramInt2) {
/* 132 */     paramInt2 = paramInt2;
/* 133 */     long l = paramLong;
/*     */     
/* 135 */     while (l > 2147483647L && (!paramBoolean || l > 0L)) {
/*     */       
/* 137 */       long l1 = l / a[paramInt1];
/* 138 */       l -= l1 * a[paramInt1];
/*     */       
/* 140 */       paramArrayOfbyte[paramInt2++] = (byte)(int)(l1 + 48L);
/* 141 */       paramInt1--;
/*     */     } 
/*     */ 
/*     */     
/* 145 */     int i = (int)l;
/* 146 */     while (paramInt1 >= 0 && (!paramBoolean || i > 0)) {
/*     */       
/* 148 */       int j = i / b[paramInt1];
/* 149 */       i -= j * b[paramInt1];
/*     */       
/* 151 */       paramArrayOfbyte[paramInt2++] = (byte)(j + 48);
/* 152 */       paramInt1--;
/*     */     } 
/*     */     
/* 155 */     return paramInt2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int a(long paramLong) {
/* 163 */     for (byte b = 0; b < a.length - 1; b++) {
/*     */       
/* 165 */       if (paramLong < a[b + 1])
/*     */       {
/* 167 */         return b;
/*     */       }
/*     */     } 
/*     */     
/* 171 */     return a.length - 1;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\i\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */