/*     */ package com.badlogic.gdx.ai.utils;
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
/*     */ public final class ArithmeticUtils
/*     */ {
/*     */   public static float wrapAngleAroundZero(float paramFloat) {
/*  33 */     if (paramFloat >= 0.0F) {
/*     */       
/*  35 */       if ((paramFloat = paramFloat % 6.2831855F) > 3.1415927F) paramFloat -= 6.2831855F; 
/*  36 */       return paramFloat;
/*     */     } 
/*     */     
/*  39 */     if ((paramFloat = -paramFloat % 6.2831855F) > 3.1415927F) paramFloat -= 6.2831855F; 
/*  40 */     return -paramFloat;
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
/*     */   public static int gcdPositive(int paramInt1, int paramInt2) {
/*  58 */     if (paramInt1 == 0) return paramInt2;
/*     */     
/*  60 */     if (paramInt2 == 0) return paramInt1;
/*     */ 
/*     */     
/*  63 */     int i = Integer.numberOfTrailingZeros(paramInt1);
/*  64 */     paramInt1 >>= i;
/*  65 */     int j = Integer.numberOfTrailingZeros(paramInt2);
/*  66 */     paramInt2 >>= j;
/*  67 */     i = (i <= j) ? i : j;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  75 */     while (paramInt1 != paramInt2) {
/*  76 */       j = paramInt1 - paramInt2;
/*  77 */       paramInt2 = (paramInt1 <= paramInt2) ? paramInt1 : paramInt2;
/*     */ 
/*     */ 
/*     */       
/*  81 */       paramInt1 = (paramInt1 = (j < 0) ? -j : j) >> Integer.numberOfTrailingZeros(paramInt1);
/*     */     } 
/*     */ 
/*     */     
/*  85 */     return paramInt1 << i;
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
/*     */   public static int lcmPositive(int paramInt1, int paramInt2) {
/* 103 */     if (paramInt1 == 0 || paramInt2 == 0) return 0;
/*     */     
/*     */     int i;
/* 106 */     if ((i = Math.abs(mulAndCheck(paramInt1 / gcdPositive(paramInt1, paramInt2), paramInt2))) == Integer.MIN_VALUE) {
/* 107 */       throw new ArithmeticException("overflow: lcm(" + paramInt1 + ", " + paramInt2 + ") > 2^31");
/*     */     }
/* 109 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int gcdPositive(int... paramVarArgs) {
/* 118 */     if (paramVarArgs == null || paramVarArgs.length < 2) throw new IllegalArgumentException("gcdPositive requires at least two arguments"); 
/* 119 */     int i = paramVarArgs[0];
/* 120 */     int j = paramVarArgs.length;
/* 121 */     for (byte b = 1; b < j; b++) {
/* 122 */       i = gcdPositive(i, paramVarArgs[b]);
/*     */     }
/* 124 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int lcmPositive(int... paramVarArgs) {
/* 134 */     if (paramVarArgs == null || paramVarArgs.length < 2) throw new IllegalArgumentException("lcmPositive requires at least two arguments"); 
/* 135 */     int i = paramVarArgs[0];
/* 136 */     int j = paramVarArgs.length;
/* 137 */     for (byte b = 1; b < j; b++) {
/* 138 */       i = lcmPositive(i, paramVarArgs[b]);
/*     */     }
/* 140 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int mulAndCheck(int paramInt1, int paramInt2) {
/*     */     long l;
/* 151 */     if ((l = paramInt1 * paramInt2) < -2147483648L || l > 2147483647L) {
/* 152 */       throw new ArithmeticException();
/*     */     }
/* 154 */     return (int)l;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\a\\utils\ArithmeticUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */