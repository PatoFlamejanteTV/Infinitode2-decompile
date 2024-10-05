/*     */ package com.prineside.tdi2.utils;
/*     */ 
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ @REGS(serializer = BitVector.Serializer.class)
/*     */ public final class BitVector
/*     */ {
/*  11 */   public long[] words = new long[] { 0L };
/*     */   
/*     */   public static class Serializer
/*     */     extends com.esotericsoftware.kryo.Serializer<BitVector> {
/*     */     public void write(Kryo param1Kryo, Output param1Output, BitVector param1BitVector) {
/*  16 */       param1Kryo.writeObject(param1Output, param1BitVector.words);
/*     */     }
/*     */ 
/*     */     
/*     */     public BitVector read(Kryo param1Kryo, Input param1Input, Class<? extends BitVector> param1Class) {
/*  21 */       return new BitVector((long[])param1Kryo.readObject(param1Input, long[].class), (byte)0);
/*     */     }
/*     */   }
/*     */   
/*     */   private BitVector(long[] paramArrayOflong) {
/*  26 */     this.words = paramArrayOflong;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BitVector(int paramInt) {
/*  36 */     a(paramInt >>> 6);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BitVector(BitVector paramBitVector) {
/*  42 */     this.words = Arrays.copyOf(paramBitVector.words, paramBitVector.words.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean get(int paramInt) {
/*     */     int i;
/*  50 */     if ((i = paramInt >>> 6) < this.words.length && (this.words[i] & 1L << paramInt) != 0L) return true;  return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getCapacity() {
/*  55 */     return this.words.length << 6;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void set(int paramInt) {
/*  61 */     int i = paramInt >>> 6;
/*  62 */     a(i);
/*  63 */     this.words[i] = this.words[i] | 1L << paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setValue(int paramInt, boolean paramBoolean) {
/*  69 */     if (paramBoolean) {
/*  70 */       set(paramInt); return;
/*     */     } 
/*  72 */     clearAtIndex(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean unsafeGet(int paramInt) {
/*  80 */     return ((this.words[paramInt >>> 6] & 1L << paramInt) != 0L);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void unsafeSet(int paramInt) {
/*  86 */     this.words[paramInt >>> 6] = this.words[paramInt >>> 6] | 1L << paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void unsafeSetValue(int paramInt, boolean paramBoolean) {
/*  92 */     if (paramBoolean) {
/*  93 */       unsafeSet(paramInt); return;
/*     */     } 
/*  95 */     unsafeClear(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void flip(int paramInt) {
/* 101 */     int i = paramInt >>> 6;
/* 102 */     a(i);
/* 103 */     this.words[i] = this.words[i] ^ 1L << paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void ensureCapacity(int paramInt) {
/* 114 */     a(paramInt >>> 6);
/*     */   }
/*     */   
/*     */   private void a(int paramInt) {
/* 118 */     if (paramInt >= this.words.length) {
/* 119 */       long[] arrayOfLong = new long[paramInt + 1];
/* 120 */       System.arraycopy(this.words, 0, arrayOfLong, 0, this.words.length);
/* 121 */       this.words = arrayOfLong;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void clearAtIndex(int paramInt) {
/*     */     int i;
/* 129 */     if ((i = paramInt >>> 6) >= this.words.length)
/* 130 */       return;  this.words[i] = this.words[i] & (1L << paramInt ^ 0xFFFFFFFFFFFFFFFFL);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void unsafeClear(int paramInt) {
/* 136 */     this.words[paramInt >>> 6] = this.words[paramInt >>> 6] & (1L << paramInt ^ 0xFFFFFFFFFFFFFFFFL);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void clear() {
/* 141 */     Arrays.fill(this.words, 0L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int length() {
/*     */     long[] arrayOfLong;
/* 150 */     for (int i = (arrayOfLong = this.words).length - 1; i >= 0; i--) {
/*     */       long l;
/* 152 */       if ((l = arrayOfLong[i]) != 0L) {
/* 153 */         return (i << 6) + 64 - Long.numberOfLeadingZeros(l);
/*     */       }
/*     */     } 
/* 156 */     return 0;
/*     */   }
/*     */   public final boolean isEmpty() {
/*     */     long[] arrayOfLong;
/*     */     int i;
/*     */     byte b;
/* 162 */     for (i = (arrayOfLong = arrayOfLong = this.words).length, b = 0; b < i; b++) {
/* 163 */       long l; if ((l = arrayOfLong[b]) != 0L) {
/* 164 */         return false;
/*     */       }
/*     */     } 
/* 167 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int nextSetBit(int paramInt) {
/*     */     int i;
/* 174 */     if ((i = paramInt >>> 6) >= this.words.length) {
/* 175 */       return -1;
/*     */     }
/*     */     long l;
/* 178 */     if ((l = this.words[i] >>> paramInt) != 0L) {
/* 179 */       return paramInt + Long.numberOfTrailingZeros(l);
/*     */     }
/* 181 */     for (paramInt = i + 1; paramInt < this.words.length; paramInt++) {
/*     */       
/* 183 */       if ((l = this.words[paramInt]) != 0L) {
/* 184 */         return (paramInt << 6) + Long.numberOfTrailingZeros(l);
/*     */       }
/*     */     } 
/*     */     
/* 188 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int nextClearBit(int paramInt) {
/*     */     int i;
/* 194 */     if ((i = paramInt >>> 6) >= this.words.length) {
/* 195 */       return Math.min(paramInt, this.words.length << 6);
/*     */     }
/*     */     long l;
/* 198 */     if ((l = this.words[i] >>> paramInt ^ 0xFFFFFFFFFFFFFFFFL) != 0L) {
/* 199 */       return paramInt + Long.numberOfTrailingZeros(l);
/*     */     }
/* 201 */     for (; ++i < this.words.length; i++) {
/*     */       
/* 203 */       if ((l = this.words[i] ^ 0xFFFFFFFFFFFFFFFFL) != 0L) {
/* 204 */         return (i << 6) + Long.numberOfTrailingZeros(l);
/*     */       }
/*     */     } 
/*     */     
/* 208 */     return Math.min(paramInt, this.words.length << 6);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void and(BitVector paramBitVector) {
/* 216 */     int i = Math.min(this.words.length, paramBitVector.words.length); int j;
/* 217 */     for (j = 0; i > j; j++) {
/* 218 */       this.words[j] = this.words[j] & paramBitVector.words[j];
/*     */     }
/*     */     
/* 221 */     if (this.words.length > i) {
/* 222 */       int k; for (j = i, k = this.words.length; k > j; j++) {
/* 223 */         this.words[j] = 0L;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void andNot(BitVector paramBitVector) {
/* 232 */     int i = Math.min(this.words.length, paramBitVector.words.length);
/* 233 */     for (byte b = 0; i > b; b++) {
/* 234 */       this.words[b] = this.words[b] & (paramBitVector.words[b] ^ 0xFFFFFFFFFFFFFFFFL);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void or(BitVector paramBitVector) {
/* 243 */     int i = Math.min(this.words.length, paramBitVector.words.length); int j;
/* 244 */     for (j = 0; i > j; j++) {
/* 245 */       this.words[j] = this.words[j] | paramBitVector.words[j];
/*     */     }
/*     */     
/* 248 */     if (i < paramBitVector.words.length) {
/* 249 */       a(paramBitVector.words.length);
/* 250 */       for (j = i, i = paramBitVector.words.length; i > j; j++) {
/* 251 */         this.words[j] = paramBitVector.words[j];
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
/*     */   public final void xor(BitVector paramBitVector) {
/* 264 */     int i = Math.min(this.words.length, paramBitVector.words.length);
/*     */     int j;
/* 266 */     for (j = 0; i > j; j++) {
/* 267 */       this.words[j] = this.words[j] ^ paramBitVector.words[j];
/*     */     }
/*     */     
/* 270 */     if (i < paramBitVector.words.length) {
/* 271 */       a(paramBitVector.words.length);
/* 272 */       for (j = i, i = paramBitVector.words.length; i > j; j++) {
/* 273 */         this.words[j] = paramBitVector.words[j];
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean intersects(BitVector paramBitVector) {
/* 283 */     long[] arrayOfLong2 = this.words;
/* 284 */     long[] arrayOfLong1 = paramBitVector.words; byte b; int i;
/* 285 */     for (b = 0, i = Math.min(arrayOfLong2.length, arrayOfLong1.length); i > b; b++) {
/* 286 */       if ((arrayOfLong2[b] & arrayOfLong1[b]) != 0L) {
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
/*     */ 
/*     */   
/*     */   public final boolean containsAll(BitVector paramBitVector) {
/* 301 */     long[] arrayOfLong2 = this.words;
/*     */     long[] arrayOfLong1;
/* 303 */     int i = (arrayOfLong1 = paramBitVector.words).length;
/*     */     
/*     */     int j, k;
/* 306 */     for (k = j = arrayOfLong2.length; k < i; k++) {
/* 307 */       if (arrayOfLong1[k] != 0L) {
/* 308 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 312 */     for (k = 0, i = Math.min(j, i); i > k; k++) {
/* 313 */       if ((arrayOfLong2[k] & arrayOfLong1[k]) != arrayOfLong1[k]) {
/* 314 */         return false;
/*     */       }
/*     */     } 
/* 317 */     return true;
/*     */   }
/*     */   
/*     */   public final int cardinality() {
/* 321 */     int i = 0; long[] arrayOfLong; int j; byte b;
/* 322 */     for (j = (arrayOfLong = this.words).length, b = 0; b < j; ) { long l = arrayOfLong[b]; i += Long.bitCount(l); b++; }
/*     */     
/* 324 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/* 329 */     int i = length() >>> 6;
/* 330 */     int j = 0;
/* 331 */     for (byte b = 0; i >= b; b++) {
/* 332 */       j = j * 127 + (int)(this.words[b] ^ this.words[b] >>> 32L);
/*     */     }
/* 334 */     return j;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 339 */     if (this == paramObject)
/* 340 */       return true; 
/* 341 */     if (paramObject == null)
/* 342 */       return false; 
/* 343 */     if (getClass() != paramObject.getClass()) {
/* 344 */       return false;
/*     */     }
/*     */     
/* 347 */     long[] arrayOfLong = ((BitVector)(paramObject = paramObject)).words;
/*     */     
/* 349 */     int i = Math.min(this.words.length, arrayOfLong.length);
/* 350 */     for (byte b = 0; i > b; b++) {
/* 351 */       if (this.words[b] != arrayOfLong[b]) {
/* 352 */         return false;
/*     */       }
/*     */     } 
/* 355 */     if (this.words.length == arrayOfLong.length) {
/* 356 */       return true;
/*     */     }
/* 358 */     return (length() == paramObject.length());
/*     */   }
/*     */   
/*     */   public final boolean exactlyTheSame(BitVector paramBitVector) {
/* 362 */     long[] arrayOfLong = paramBitVector.words;
/* 363 */     for (byte b = 0; arrayOfLong.length > b; b++) {
/* 364 */       if (this.words[b] != arrayOfLong[b])
/* 365 */         return false; 
/*     */     } 
/* 367 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 372 */     int i = cardinality();
/* 373 */     int j = Math.min(128, i);
/* 374 */     byte b = 0;
/*     */     
/*     */     StringBuilder stringBuilder;
/* 377 */     (stringBuilder = new StringBuilder()).append("BitVector[").append(i);
/* 378 */     if (i > 0) {
/* 379 */       stringBuilder.append(": {"); int k;
/* 380 */       for (k = nextSetBit(0); j > b && k != -1; k = nextSetBit(k + 1)) {
/* 381 */         if (b != 0) {
/* 382 */           stringBuilder.append(", ");
/*     */         }
/* 384 */         stringBuilder.append(k);
/* 385 */         b++;
/*     */       } 
/*     */       
/* 388 */       if (i > j) {
/* 389 */         stringBuilder.append(" ...");
/*     */       }
/* 391 */       stringBuilder.append("}");
/*     */     } 
/* 393 */     stringBuilder.append("]");
/* 394 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public BitVector() {}
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\BitVector.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */