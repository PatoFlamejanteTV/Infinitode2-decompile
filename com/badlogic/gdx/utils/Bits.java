/*     */ package com.badlogic.gdx.utils;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Bits
/*     */ {
/*  27 */   long[] bits = new long[] { 0L };
/*     */ 
/*     */ 
/*     */   
/*     */   public Bits() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public Bits(int paramInt) {
/*  36 */     checkCapacity(paramInt >>> 6);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Bits(Bits paramBits) {
/*  42 */     this.bits = new long[paramBits.bits.length];
/*  43 */     System.arraycopy(paramBits.bits, 0, this.bits, 0, paramBits.bits.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean get(int paramInt) {
/*     */     int i;
/*  51 */     if ((i = paramInt >>> 6) >= this.bits.length) return false; 
/*  52 */     return ((this.bits[i] & 1L << (paramInt & 0x3F)) != 0L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getAndClear(int paramInt) {
/*     */     int i;
/*  61 */     if ((i = paramInt >>> 6) >= this.bits.length) return false; 
/*  62 */     long l = this.bits[i];
/*  63 */     this.bits[i] = this.bits[i] & (1L << (paramInt & 0x3F) ^ 0xFFFFFFFFFFFFFFFFL);
/*  64 */     return (this.bits[i] != l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getAndSet(int paramInt) {
/*  72 */     int i = paramInt >>> 6;
/*  73 */     checkCapacity(i);
/*  74 */     long l = this.bits[i];
/*  75 */     this.bits[i] = this.bits[i] | 1L << (paramInt & 0x3F);
/*  76 */     return (this.bits[i] == l);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(int paramInt) {
/*  82 */     int i = paramInt >>> 6;
/*  83 */     checkCapacity(i);
/*  84 */     this.bits[i] = this.bits[i] | 1L << (paramInt & 0x3F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void flip(int paramInt) {
/*  89 */     int i = paramInt >>> 6;
/*  90 */     checkCapacity(i);
/*  91 */     this.bits[i] = this.bits[i] ^ 1L << (paramInt & 0x3F);
/*     */   }
/*     */   
/*     */   private void checkCapacity(int paramInt) {
/*  95 */     if (paramInt >= this.bits.length) {
/*  96 */       long[] arrayOfLong = new long[paramInt + 1];
/*  97 */       System.arraycopy(this.bits, 0, arrayOfLong, 0, this.bits.length);
/*  98 */       this.bits = arrayOfLong;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear(int paramInt) {
/*     */     int i;
/* 106 */     if ((i = paramInt >>> 6) >= this.bits.length)
/* 107 */       return;  this.bits[i] = this.bits[i] & (1L << (paramInt & 0x3F) ^ 0xFFFFFFFFFFFFFFFFL);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 112 */     Arrays.fill(this.bits, 0L);
/*     */   }
/*     */ 
/*     */   
/*     */   public int numBits() {
/* 117 */     return this.bits.length << 6;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int length() {
/*     */     long[] arrayOfLong;
/* 126 */     for (int i = (arrayOfLong = this.bits).length - 1; i >= 0; i--) {
/*     */       long l;
/* 128 */       if ((l = arrayOfLong[i]) != 0L) {
/* 129 */         for (byte b = 63; b >= 0; b--) {
/* 130 */           if ((l & 1L << (b & 0x3F)) != 0L) {
/* 131 */             return (i << 6) + b + 1;
/*     */           }
/*     */         } 
/*     */       }
/*     */     } 
/* 136 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean notEmpty() {
/* 141 */     return !isEmpty();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/*     */     long[] arrayOfLong;
/* 147 */     int i = (arrayOfLong = this.bits).length;
/* 148 */     for (byte b = 0; b < i; b++) {
/* 149 */       if (arrayOfLong[b] != 0L) {
/* 150 */         return false;
/*     */       }
/*     */     } 
/* 153 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int nextSetBit(int paramInt) {
/* 159 */     long[] arrayOfLong = this.bits;
/* 160 */     int i = paramInt >>> 6;
/* 161 */     int j = arrayOfLong.length;
/* 162 */     if (i >= j) return -1; 
/*     */     long l;
/* 164 */     if ((l = arrayOfLong[i]) != 0L) {
/* 165 */       for (paramInt &= 0x3F; paramInt < 64; paramInt++) {
/* 166 */         if ((l & 1L << (paramInt & 0x3F)) != 0L) {
/* 167 */           return (i << 6) + paramInt;
/*     */         }
/*     */       } 
/*     */     }
/* 171 */     for (; ++i < j; i++) {
/* 172 */       if (i != 0 && (
/*     */         
/* 174 */         l = arrayOfLong[i]) != 0L) {
/* 175 */         for (paramInt = 0; paramInt < 64; paramInt++) {
/* 176 */           if ((l & 1L << (paramInt & 0x3F)) != 0L) {
/* 177 */             return (i << 6) + paramInt;
/*     */           }
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 183 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public int nextClearBit(int paramInt) {
/* 188 */     long[] arrayOfLong = this.bits;
/* 189 */     int i = paramInt >>> 6;
/* 190 */     int j = arrayOfLong.length;
/* 191 */     if (i >= j) return arrayOfLong.length << 6; 
/* 192 */     long l = arrayOfLong[i];
/* 193 */     for (paramInt &= 0x3F; paramInt < 64; paramInt++) {
/* 194 */       if ((l & 1L << (paramInt & 0x3F)) == 0L) {
/* 195 */         return (i << 6) + paramInt;
/*     */       }
/*     */     } 
/* 198 */     for (; ++i < j; i++) {
/* 199 */       if (i == 0) {
/* 200 */         return i << 6;
/*     */       }
/* 202 */       l = arrayOfLong[i];
/* 203 */       for (paramInt = 0; paramInt < 64; paramInt++) {
/* 204 */         if ((l & 1L << (paramInt & 0x3F)) == 0L) {
/* 205 */           return (i << 6) + paramInt;
/*     */         }
/*     */       } 
/*     */     } 
/* 209 */     return arrayOfLong.length << 6;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void and(Bits paramBits) {
/* 217 */     int i = Math.min(this.bits.length, paramBits.bits.length); int j;
/* 218 */     for (j = 0; i > j; j++) {
/* 219 */       this.bits[j] = this.bits[j] & paramBits.bits[j];
/*     */     }
/*     */     
/* 222 */     if (this.bits.length > i) {
/* 223 */       int k; for (j = i, k = this.bits.length; k > j; j++) {
/* 224 */         this.bits[j] = 0L;
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void andNot(Bits paramBits) {
/*     */     byte b;
/*     */     int i;
/*     */     int j;
/* 233 */     for (b = 0, i = this.bits.length, j = paramBits.bits.length; b < i && b < j; b++) {
/* 234 */       this.bits[b] = this.bits[b] & (paramBits.bits[b] ^ 0xFFFFFFFFFFFFFFFFL);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void or(Bits paramBits) {
/* 243 */     int i = Math.min(this.bits.length, paramBits.bits.length); int j;
/* 244 */     for (j = 0; i > j; j++) {
/* 245 */       this.bits[j] = this.bits[j] | paramBits.bits[j];
/*     */     }
/*     */     
/* 248 */     if (i < paramBits.bits.length) {
/* 249 */       checkCapacity(paramBits.bits.length);
/* 250 */       for (j = i, i = paramBits.bits.length; i > j; j++) {
/* 251 */         this.bits[j] = paramBits.bits[j];
/*     */       }
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
/*     */   public void xor(Bits paramBits) {
/* 264 */     int i = Math.min(this.bits.length, paramBits.bits.length);
/*     */     int j;
/* 266 */     for (j = 0; i > j; j++) {
/* 267 */       this.bits[j] = this.bits[j] ^ paramBits.bits[j];
/*     */     }
/*     */     
/* 270 */     if (i < paramBits.bits.length) {
/* 271 */       checkCapacity(paramBits.bits.length);
/* 272 */       for (j = i, i = paramBits.bits.length; i > j; j++) {
/* 273 */         this.bits[j] = paramBits.bits[j];
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean intersects(Bits paramBits) {
/* 283 */     long[] arrayOfLong2 = this.bits;
/* 284 */     long[] arrayOfLong1 = paramBits.bits;
/* 285 */     for (int i = Math.min(arrayOfLong2.length, arrayOfLong1.length) - 1; i >= 0; i--) {
/* 286 */       if ((arrayOfLong2[i] & arrayOfLong1[i]) != 0L) {
/* 287 */         return true;
/*     */       }
/*     */     } 
/* 290 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsAll(Bits paramBits) {
/* 299 */     long[] arrayOfLong2 = this.bits;
/*     */     long[] arrayOfLong1;
/* 301 */     int i = (arrayOfLong1 = paramBits.bits).length;
/*     */     
/*     */     int j, k;
/* 304 */     for (k = j = arrayOfLong2.length; k < i; k++) {
/* 305 */       if (arrayOfLong1[k] != 0L) {
/* 306 */         return false;
/*     */       }
/*     */     } 
/* 309 */     for (k = Math.min(j, i) - 1; k >= 0; k--) {
/* 310 */       if ((arrayOfLong2[k] & arrayOfLong1[k]) != arrayOfLong1[k]) {
/* 311 */         return false;
/*     */       }
/*     */     } 
/* 314 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 319 */     int i = length() >>> 6;
/* 320 */     int j = 0;
/* 321 */     for (byte b = 0; i >= b; b++) {
/* 322 */       j = j * 127 + (int)(this.bits[b] ^ this.bits[b] >>> 32L);
/*     */     }
/* 324 */     return j;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 329 */     if (this == paramObject) return true; 
/* 330 */     if (paramObject == null) return false; 
/* 331 */     if (getClass() != paramObject.getClass()) return false;
/*     */ 
/*     */     
/* 334 */     long[] arrayOfLong = ((Bits)(paramObject = paramObject)).bits;
/*     */     
/* 336 */     int i = Math.min(this.bits.length, arrayOfLong.length);
/* 337 */     for (byte b = 0; i > b; b++) {
/* 338 */       if (this.bits[b] != arrayOfLong[b]) return false;
/*     */     
/*     */     } 
/* 341 */     if (this.bits.length == arrayOfLong.length) return true;
/*     */     
/* 343 */     return (length() == paramObject.length());
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\Bits.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */