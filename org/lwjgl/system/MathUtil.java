/*     */ package org.lwjgl.system;
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
/*     */ public final class MathUtil
/*     */ {
/*     */   public static boolean mathIsPoT(int paramInt) {
/*  28 */     return (Integer.bitCount(paramInt) == 1);
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
/*     */   public static int mathRoundPoT(int paramInt) {
/*  42 */     return 1 << 32 - Integer.numberOfLeadingZeros(paramInt - 1);
/*     */   }
/*     */   
/*     */   public static boolean mathHasZeroByte(int paramInt) {
/*  46 */     return ((paramInt - 16843009 & (paramInt ^ 0xFFFFFFFF) & 0x80808080) != 0);
/*     */   }
/*     */   
/*     */   public static boolean mathHasZeroByte(long paramLong) {
/*  50 */     return ((paramLong - 72340172838076673L & (paramLong ^ 0xFFFFFFFFFFFFFFFFL) & 0x8080808080808080L) != 0L);
/*     */   }
/*     */   
/*     */   public static boolean mathHasZeroShort(int paramInt) {
/*  54 */     return ((paramInt - 65537 & (paramInt ^ 0xFFFFFFFF) & 0x80008000) != 0);
/*     */   }
/*     */   
/*     */   public static boolean mathHasZeroShort(long paramLong) {
/*  58 */     return ((paramLong - 281479271743489L & (paramLong ^ 0xFFFFFFFFFFFFFFFFL) & 0x8000800080008000L) != 0L);
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
/*     */   public static long mathMultiplyHighU64(long paramLong1, long paramLong2) {
/*  70 */     long l1 = paramLong1 & 0xFFFFFFFFL;
/*  71 */     long l2 = paramLong1 >>> 32L;
/*  72 */     long l3 = paramLong2 & 0xFFFFFFFFL;
/*  73 */     long l4 = paramLong2 >>> 32L;
/*     */     
/*  75 */     long l5 = l2 * l3 + (l1 * l3 >>> 32L);
/*     */     
/*  77 */     return l2 * l4 + (l5 >>> 32L) + ((l5 & 0xFFFFFFFFL) + l1 * l4 >>> 32L);
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
/*     */   public static long mathMultiplyHighS64(long paramLong1, long paramLong2) {
/*  89 */     long l1 = paramLong1 & 0xFFFFFFFFL;
/*  90 */     long l2 = paramLong1 >> 32L;
/*  91 */     long l3 = paramLong2 & 0xFFFFFFFFL;
/*  92 */     long l4 = paramLong2 >> 32L;
/*     */     
/*  94 */     long l5 = l2 * l3 + (l1 * l3 >>> 32L);
/*     */     
/*  96 */     return l2 * l4 + (l5 >> 32L) + ((l5 & 0xFFFFFFFFL) + l1 * l4 >> 32L);
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
/*     */   public static long mathDivideUnsigned(long paramLong1, long paramLong2) {
/* 111 */     if (0L <= paramLong2) {
/* 112 */       return (0L <= paramLong1) ? (paramLong1 / paramLong2) : 
/*     */         
/* 114 */         udivdi3(paramLong1, paramLong2);
/*     */     }
/* 116 */     return (Long.compareUnsigned(paramLong1, paramLong2) < 0) ? 0L : 1L;
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
/*     */   public static long mathRemainderUnsigned(long paramLong1, long paramLong2) {
/* 132 */     if (0L < paramLong1 && 0L < paramLong2) {
/* 133 */       return paramLong1 % paramLong2;
/*     */     }
/* 135 */     return (Long.compareUnsigned(paramLong1, paramLong2) < 0) ? paramLong1 : (paramLong1 - paramLong2 * 
/*     */       
/* 137 */       udivdi3(paramLong1, paramLong2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static long udivdi3(long paramLong1, long paramLong2) {
/* 144 */     if (paramLong2 >>> 32L == 0L) {
/*     */       
/* 146 */       if (paramLong1 >>> 32L < paramLong2) {
/* 147 */         long l4 = (paramLong1 >>> 1L) / paramLong2 << Long.numberOfLeadingZeros(paramLong2) >>> 31L;
/* 148 */         if (paramLong1 - l4 * paramLong2 >= paramLong2) {
/* 149 */           l4++;
/*     */         }
/* 151 */         return l4;
/*     */       } 
/*     */       
/* 154 */       long l1, l2 = (l1 = paramLong1 >>> 32L) / paramLong2;
/* 155 */       long l3 = (l1 - l2 * paramLong2 << 32L | paramLong1 & 0xFFFFFFFFL) / paramLong2;
/* 156 */       return l2 << 32L | l3;
/*     */     } 
/*     */ 
/*     */     
/* 160 */     int i = Long.numberOfLeadingZeros(paramLong2);
/*     */     long l;
/* 162 */     if ((l = (paramLong1 >>> 1L) / (paramLong2 << i >>> 32L) << i >>> 31L) != 0L) {
/* 163 */       l--;
/*     */     }
/* 165 */     if (Long.compareUnsigned(paramLong1 - l * paramLong2, paramLong2) >= 0) {
/* 166 */       l++;
/*     */     }
/* 168 */     return l;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\MathUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */