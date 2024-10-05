/*     */ package com.a.a.b.c.a;
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
/*     */ final class f
/*     */ {
/*  41 */   private static final float[] a = new float[] { 1.0F, 10.0F, 100.0F, 1000.0F, 10000.0F, 100000.0F, 1000000.0F, 1.0E7F, 1.0E8F, 1.0E9F, 1.0E10F };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static float a(boolean paramBoolean1, long paramLong, int paramInt1, boolean paramBoolean2, int paramInt2) {
/*     */     float f1;
/*     */     float f2;
/*  54 */     if (paramLong == 0L) {
/*  55 */       return paramBoolean1 ? -0.0F : 0.0F;
/*     */     }
/*     */ 
/*     */     
/*  59 */     if (paramBoolean2) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  65 */       if (-45 <= paramInt2 && paramInt2 <= 38) {
/*     */         
/*  67 */         f2 = a(paramBoolean1, paramLong, paramInt2);
/*  68 */         float f3 = a(paramBoolean1, paramLong + 1L, paramInt2);
/*  69 */         if (!Float.isNaN(f2) && f3 == f2) {
/*  70 */           return f2;
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/*  76 */       f1 = Float.NaN;
/*     */     
/*     */     }
/*  79 */     else if (-45 <= f2 && f2 <= 38) {
/*  80 */       f1 = a(f1, paramLong, f2);
/*     */     } else {
/*  82 */       f1 = Float.NaN;
/*     */     } 
/*  84 */     return f1;
/*     */   }
/*     */   
/*     */   static float b(boolean paramBoolean1, long paramLong, int paramInt1, boolean paramBoolean2, int paramInt2) {
/*     */     float f1;
/*     */     float f2;
/*  90 */     if (paramLong == 0L) {
/*  91 */       return paramBoolean1 ? -0.0F : 0.0F;
/*     */     }
/*     */     
/*  94 */     if (paramBoolean2) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 100 */       if (-126 <= paramInt2 && paramInt2 <= 127) {
/* 101 */         f2 = b(paramBoolean1, paramLong, paramInt2);
/* 102 */         float f3 = b(paramBoolean1, paramLong + 1L, paramInt2);
/* 103 */         if (!Double.isNaN(f2) && f3 == f2) {
/* 104 */           return f2;
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 109 */       f1 = Float.NaN;
/*     */     }
/* 111 */     else if (-126 <= f2 && f2 <= 127) {
/* 112 */       f1 = b(f1, paramLong, f2);
/*     */     } else {
/* 114 */       f1 = Float.NaN;
/*     */     } 
/* 116 */     return f1;
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
/*     */   private static float a(boolean paramBoolean, long paramLong, int paramInt) {
/* 138 */     if (-10 <= paramInt && paramInt <= 10 && Long.compareUnsigned(paramLong, 16777215L) <= 0) {
/*     */ 
/*     */       
/* 141 */       float f1 = (float)paramLong;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 149 */       if (paramInt < 0) {
/* 150 */         f1 /= a[-paramInt];
/*     */       } else {
/* 152 */         f1 *= a[paramInt];
/*     */       } 
/* 154 */       return paramBoolean ? -f1 : f1;
/*     */     } 
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
/* 167 */     long l1 = d.a[paramInt - -325];
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
/* 197 */     long l2 = (217706L * paramInt >> 16L) + 127L + 64L;
/*     */     
/* 199 */     int i = Long.numberOfLeadingZeros(paramLong);
/*     */ 
/*     */     
/*     */     d.a a;
/*     */ 
/*     */     
/* 205 */     long l3 = (a = d.a(paramLong = paramLong << i, l1)).b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     long l4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 221 */     if (((l4 = a.a) & 0x3FFFFFFFFFL) == 274877906943L && Long.compareUnsigned(l3 + paramLong, l3) < 0) {
/* 222 */       long l8 = d.b[paramInt - -325];
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 227 */       long l9 = (a = d.a(paramLong, l8)).b;
/* 228 */       long l10 = a.a;
/* 229 */       long l11 = l3;
/* 230 */       long l12 = l4;
/*     */       long l13;
/* 232 */       if (Long.compareUnsigned(l13 = l11 + l10, l11) < 0) {
/* 233 */         l12++;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 239 */       if (l13 + 1L == 0L && (l12 & 0x7FFFFFFFFFL) == 549755813887L && l9 + 
/* 240 */         Long.compareUnsigned(paramLong, l9) < 0L) {
/* 241 */         return Float.NaN;
/*     */       }
/* 243 */       l4 = l12;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 249 */     long l5 = l4 >>> 63L;
/* 250 */     long l6 = l4 >>> (int)(l5 + 38L);
/* 251 */     i += (int)(0x1L ^ l5);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 260 */     if ((l4 & 0x3FFFFFFFFFL) == 274877906943L || ((l4 & 0x3FFFFFFFFFL) == 0L && (l6 & 0x3L) == 1L))
/*     */     {
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
/* 279 */       return Float.NaN;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 286 */     if ((l6 = (l6 = l6 + 1L) >>> 1L) >= 16777216L) {
/*     */       
/* 288 */       l6 = 8388608L;
/* 289 */       i--;
/*     */     } 
/*     */     
/* 292 */     l6 &= 0xFFFFFFFFFF7FFFFFL;
/*     */ 
/*     */     
/*     */     long l7;
/*     */     
/* 297 */     if ((l7 = l2 - i) < 1L || l7 > 254L) {
/* 298 */       return Float.NaN;
/*     */     }
/*     */     
/*     */     int j;
/*     */     
/* 303 */     return Float.intBitsToFloat(j = (int)(l6 | l7 << 23L | (paramBoolean ? 2147483648L : 0L)));
/*     */   }
/*     */   
/*     */   private static float b(boolean paramBoolean, long paramLong, int paramInt) {
/* 307 */     if (paramLong == 0L || paramInt < -180) {
/* 308 */       return paramBoolean ? -0.0F : 0.0F;
/*     */     }
/* 310 */     if (paramInt > 127) {
/* 311 */       return paramBoolean ? Float.NEGATIVE_INFINITY : Float.POSITIVE_INFINITY;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 318 */     if (Long.compareUnsigned(paramLong, 9007199254740991L) <= 0) {
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
/* 330 */       float f1 = (f1 = (float)paramLong) * Math.scalb(1.0F, paramInt);
/* 331 */       if (paramBoolean) {
/* 332 */         f1 = -f1;
/*     */       }
/* 334 */       return f1;
/*     */     } 
/*     */ 
/*     */     
/* 338 */     return Float.NaN;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\c\a\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */