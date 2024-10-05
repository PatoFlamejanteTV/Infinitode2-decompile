/*     */ package com.google.common.base;
/*     */ 
/*     */ import java.util.BitSet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ElementTypesAreNonnullByDefault
/*     */ final class SmallCharMatcher
/*     */   extends CharMatcher.NamedFastMatcher
/*     */ {
/*     */   static final int MAX_SIZE = 1023;
/*     */   private final char[] table;
/*     */   private final boolean containsZero;
/*     */   private final long filter;
/*     */   private static final int C1 = -862048943;
/*     */   private static final int C2 = 461845907;
/*     */   private static final double DESIRED_LOAD_FACTOR = 0.5D;
/*     */   
/*     */   private SmallCharMatcher(char[] paramArrayOfchar, long paramLong, boolean paramBoolean, String paramString) {
/*  37 */     super(paramString);
/*  38 */     this.table = paramArrayOfchar;
/*  39 */     this.filter = paramLong;
/*  40 */     this.containsZero = paramBoolean;
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
/*     */   static int smear(int paramInt) {
/*  55 */     return 461845907 * Integer.rotateLeft(paramInt * -862048943, 15);
/*     */   }
/*     */   
/*     */   private boolean checkFilter(int paramInt) {
/*  59 */     return (1L == (0x1L & this.filter >> paramInt));
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
/*     */   static int chooseTableSize(int paramInt) {
/*  75 */     if (paramInt == 1) {
/*  76 */       return 2;
/*     */     }
/*     */ 
/*     */     
/*  80 */     int i = Integer.highestOneBit(paramInt - 1) << 1;
/*  81 */     while (i * 0.5D < paramInt) {
/*  82 */       i <<= 1;
/*     */     }
/*  84 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   static CharMatcher from(BitSet paramBitSet, String paramString) {
/*  89 */     long l = 0L;
/*  90 */     int i = paramBitSet.cardinality();
/*  91 */     boolean bool = paramBitSet.get(0);
/*     */     
/*     */     char[] arrayOfChar;
/*  94 */     int j = (arrayOfChar = new char[chooseTableSize(i)]).length - 1; int k;
/*  95 */     for (k = paramBitSet.nextSetBit(0); k != -1; ) {
/*     */       
/*  97 */       l |= 1L << k;
/*  98 */       int m = smear(k) & j;
/*     */       
/*     */       for (;; k = paramBitSet.nextSetBit(k + 1)) {
/* 101 */         if (arrayOfChar[m] == '\000') {
/* 102 */           arrayOfChar[m] = (char)k;
/*     */         }
/*     */         else {
/*     */           
/* 106 */           m = m + 1 & j; continue;
/*     */         } 
/*     */       } 
/* 109 */     }  return new SmallCharMatcher(arrayOfChar, l, bool, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean matches(char paramChar) {
/* 114 */     if (paramChar == '\000') {
/* 115 */       return this.containsZero;
/*     */     }
/* 117 */     if (!checkFilter(paramChar)) {
/* 118 */       return false;
/*     */     }
/* 120 */     int i = this.table.length - 1;
/*     */     
/* 122 */     int j = smear(paramChar) & i, k = j;
/*     */     while (true) {
/* 124 */       if (this.table[k] == '\000')
/* 125 */         return false; 
/* 126 */       if (this.table[k] == paramChar) {
/* 127 */         return true;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 132 */       if ((k = k + 1 & i) == j)
/* 133 */         return false; 
/*     */     } 
/*     */   }
/*     */   
/*     */   final void setBits(BitSet paramBitSet) {
/* 138 */     if (this.containsZero)
/* 139 */       paramBitSet.set(0);  char[] arrayOfChar; int i;
/*     */     byte b;
/* 141 */     for (i = (arrayOfChar = this.table).length, b = 0; b < i; b++) {
/* 142 */       char c; if ((c = arrayOfChar[b]) != '\000')
/* 143 */         paramBitSet.set(c); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\google\common\base\SmallCharMatcher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */