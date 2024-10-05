/*     */ package com.c.b;
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
/*     */ final class d
/*     */ {
/*     */   private float[] a;
/*     */   private int[] b;
/*     */   
/*     */   final void a(int paramInt) {
/*  42 */     this.a = new float[3 * paramInt];
/*  43 */     this.b = new int[32];
/*  44 */     a(paramInt, this.a, this.b);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  54 */   private static int[] c = new int[] { 4, 2, 3, 5 };
/*  55 */   private static float d = 6.2831855F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(int paramInt1, float[] paramArrayOffloat, int paramInt2, int[] paramArrayOfint) {
/*  63 */     int i = 0; byte b = -1;
/*     */ 
/*     */ 
/*     */     
/*  67 */     int k = paramInt1;
/*  68 */     byte b1 = 0;
/*     */     
/*  70 */     int j = 101; while (true) {
/*     */       int i2;
/*     */       byte b2;
/*  73 */       switch (j) {
/*     */         case 101:
/*  75 */           b++;
/*  76 */           if (b < 4)
/*  77 */           { i = c[b]; }
/*     */           else
/*  79 */           { i += 2; } 
/*     */         case 104:
/*  81 */           j = k / i;
/*     */           
/*  83 */           if ((i2 = k - i * j) != 0) {
/*  84 */             j = 101;
/*     */             continue;
/*     */           } 
/*  87 */           b1++;
/*  88 */           paramArrayOfint[b1 + 1] = i;
/*  89 */           k = j;
/*  90 */           if (i != 2) {
/*  91 */             j = 107;
/*     */             continue;
/*     */           } 
/*  94 */           if (b1 == 1) {
/*  95 */             j = 107;
/*     */             
/*     */             continue;
/*     */           } 
/*  99 */           for (b2 = 1; b2 < b1; b2++) {
/* 100 */             j = b1 - b2 + 1;
/* 101 */             paramArrayOfint[j + 1] = paramArrayOfint[j];
/*     */           } 
/* 103 */           paramArrayOfint[2] = 2;
/*     */         case 107:
/* 105 */           if (k != 1) {
/* 106 */             j = 104; continue;
/*     */           }  break;
/*     */       } 
/* 109 */     }  paramArrayOfint[0] = paramInt1;
/* 110 */     paramArrayOfint[1] = b1;
/* 111 */     float f = d / paramInt1;
/* 112 */     int n = 0;
/* 113 */     int i1 = b1 - 1;
/* 114 */     int m = 1;
/*     */     
/* 116 */     if (i1 == 0) {
/*     */       return;
/*     */     }
/* 119 */     for (b1 = 0; b1 < i1; b1++) {
/* 120 */       i = paramArrayOfint[b1 + 2];
/* 121 */       int i3 = 0;
/* 122 */       int i2 = m * i;
/* 123 */       int i4 = paramInt1 / i2;
/* 124 */       int i5 = i - 1;
/*     */       
/* 126 */       for (b = 0; b < i5; b++) {
/* 127 */         i3 += m;
/* 128 */         int i6 = n;
/* 129 */         float f1 = i3 * f;
/* 130 */         float f2 = 0.0F;
/* 131 */         for (byte b2 = 2; b2 < i4; b2 += 2) {
/*     */           
/* 133 */           float f3 = (f2 = f2 + 1.0F) * f1;
/* 134 */           paramArrayOffloat[paramInt2 + i6++] = (float)Math.cos(f3);
/* 135 */           paramArrayOffloat[paramInt2 + i6++] = (float)Math.sin(f3);
/*     */         } 
/* 137 */         n += i4;
/*     */       } 
/* 139 */       m = i2;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(int paramInt, float[] paramArrayOffloat, int[] paramArrayOfint) {
/* 147 */     if (paramInt == 1)
/*     */       return; 
/* 149 */     a(paramInt, paramArrayOffloat, paramInt, paramArrayOfint);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\c\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */