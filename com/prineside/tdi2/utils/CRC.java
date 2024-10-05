/*     */ package com.prineside.tdi2.utils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class CRC
/*     */ {
/*     */   private Parameters a;
/*     */   private long b;
/*     */   private long[] c;
/*     */   private long d;
/*     */   
/*     */   public static final class Parameters
/*     */   {
/*     */     private int a;
/*     */     private long b;
/*     */     private boolean c;
/*     */     private boolean d;
/*     */     private long e;
/*     */     private long f;
/*     */     
/*     */     public Parameters(int param1Int, long param1Long1, long param1Long2, boolean param1Boolean1, boolean param1Boolean2, long param1Long3) {
/*  77 */       this.a = param1Int;
/*  78 */       this.b = param1Long1;
/*  79 */       this.c = param1Boolean1;
/*  80 */       this.d = param1Boolean2;
/*  81 */       this.e = param1Long2;
/*  82 */       this.f = param1Long3;
/*     */     }
/*     */ 
/*     */     
/*     */     public Parameters(Parameters param1Parameters) {
/*  87 */       this.a = param1Parameters.a;
/*  88 */       this.b = param1Parameters.b;
/*  89 */       this.c = param1Parameters.c;
/*  90 */       this.d = param1Parameters.d;
/*  91 */       this.e = param1Parameters.e;
/*  92 */       this.f = param1Parameters.f;
/*     */     }
/*     */ 
/*     */     
/*     */     public final int getWidth() {
/*  97 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public final long getPolynomial() {
/* 102 */       return this.b;
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean isReflectIn() {
/* 107 */       return this.c;
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean isReflectOut() {
/* 112 */       return this.d;
/*     */     }
/*     */ 
/*     */     
/*     */     public final long getInit() {
/* 117 */       return this.e;
/*     */     }
/*     */ 
/*     */     
/*     */     public final long getFinalXor() {
/* 122 */       return this.f;
/*     */     }
/*     */ 
/*     */     
/* 126 */     public static final Parameters CCITT = new Parameters(16, 4129L, 65535L, false, false, 0L);
/*     */     
/* 128 */     public static final Parameters CRC16 = new Parameters(16, 32773L, 0L, true, true, 0L);
/*     */     
/* 130 */     public static final Parameters XMODEM = new Parameters(16, 4129L, 0L, false, false, 0L);
/*     */     
/* 132 */     public static final Parameters XMODEM2 = new Parameters(16, 33800L, 0L, true, true, 0L);
/*     */ 
/*     */     
/*     */     public static final Parameters CRC32;
/*     */     
/* 137 */     public static final Parameters IEEE = CRC32 = new Parameters(32, 79764919L, 4294967295L, true, true, 4294967295L);
/*     */     
/*     */     public static final Parameters Castagnoli;
/*     */     
/* 141 */     public static final Parameters CRC32C = Castagnoli = new Parameters(32, 517762881L, 4294967295L, true, true, 4294967295L);
/*     */     
/* 143 */     public static final Parameters Koopman = new Parameters(32, 1947962583L, 4294967295L, true, true, 4294967295L);
/*     */ 
/*     */     
/* 146 */     public static final Parameters CRC64ISO = new Parameters(64, 27L, -1L, true, true, -1L);
/*     */     
/* 148 */     public static final Parameters CRC64ECMA = new Parameters(64, 4823603603198064275L, -1L, true, true, -1L);
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
/*     */   private static long a(long paramLong, int paramInt) {
/* 160 */     long l = paramLong;
/* 161 */     for (byte b = 0; b < paramInt; b++) {
/*     */       
/* 163 */       long l1 = 1L << b;
/* 164 */       long l2 = 1L << paramInt - b - 1;
/* 165 */       if ((paramLong & l1) != 0L) {
/*     */         
/* 167 */         l |= l2;
/*     */       }
/*     */       else {
/*     */         
/* 171 */         l &= l2 ^ 0xFFFFFFFFFFFFFFFFL;
/*     */       } 
/*     */     } 
/* 174 */     return l;
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
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public static long calculateCRC(Parameters paramParameters, byte[] paramArrayOfbyte) {
/* 195 */     return calculateCRC(paramParameters, paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public static long calculateCRC(Parameters paramParameters, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 201 */     long l1 = Parameters.a(paramParameters);
/*     */     
/* 203 */     long l2, l3 = ((l2 = 1L << Parameters.b(paramParameters) - 1) << 1L) - 1L;
/* 204 */     paramInt2 = paramInt1 + paramInt2;
/*     */     
/* 206 */     for (paramInt1 = paramInt1; paramInt1 < paramInt2; paramInt1++) {
/*     */       
/* 208 */       long l = paramArrayOfbyte[paramInt1] & 0xFFL;
/* 209 */       if (Parameters.c(paramParameters))
/*     */       {
/* 211 */         l = a(l, 8);
/*     */       }
/*     */       int i;
/* 214 */       for (i = 128; i != 0; i >>= 1) {
/*     */         
/* 216 */         long l4 = l1 & l2;
/* 217 */         l1 <<= 1L;
/*     */         
/* 219 */         if ((l & i) != 0L)
/*     */         {
/* 221 */           l4 ^= l2;
/*     */         }
/*     */         
/* 224 */         if (l4 != 0L)
/*     */         {
/* 226 */           l1 ^= Parameters.d(paramParameters);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 232 */     if (Parameters.e(paramParameters))
/*     */     {
/* 234 */       l1 = a(l1, Parameters.b(paramParameters));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 239 */     return (l1 = l1 ^ Parameters.f(paramParameters)) & l3;
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
/*     */   public final long init() {
/* 255 */     return this.b;
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
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public final long update(long paramLong, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 271 */     if (Parameters.c(this.a)) {
/*     */       
/* 273 */       for (byte b = 0; b < paramInt2; b++)
/*     */       {
/* 275 */         byte b1 = paramArrayOfbyte[paramInt1 + b];
/* 276 */         paramLong = this.c[((byte)(int)paramLong ^ b1) & 0xFF] ^ paramLong >>> 8L;
/*     */       }
/*     */     
/* 279 */     } else if (Parameters.b(this.a) < 8) {
/*     */       
/* 281 */       for (byte b = 0; b < paramInt2; b++)
/*     */       {
/* 283 */         byte b1 = paramArrayOfbyte[paramInt1 + b];
/* 284 */         paramLong = this.c[((byte)(int)(paramLong << 8 - Parameters.b(this.a)) ^ b1) & 0xFF] ^ paramLong << 8L;
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 289 */       for (byte b = 0; b < paramInt2; b++) {
/*     */         
/* 291 */         byte b1 = paramArrayOfbyte[paramInt1 + b];
/* 292 */         paramLong = this.c[((byte)(int)(paramLong >>> Parameters.b(this.a) - 8) ^ b1) & 0xFF] ^ paramLong << 8L;
/*     */       } 
/*     */     } 
/*     */     
/* 296 */     return paramLong;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public final long update(long paramLong, byte[] paramArrayOfbyte) {
/* 308 */     return update(paramLong, paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public final long finalCRC(long paramLong) {
/* 319 */     long l = paramLong;
/* 320 */     if (Parameters.e(this.a) != Parameters.c(this.a))
/*     */     {
/* 322 */       l = a(paramLong, Parameters.b(this.a));
/*     */     }
/* 324 */     return (l ^ Parameters.f(this.a)) & this.d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public final long calculateCRC(byte[] paramArrayOfbyte) {
/* 335 */     return calculateCRC(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public final long calculateCRC(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 341 */     long l = init();
/* 342 */     l = update(l, paramArrayOfbyte, paramInt1, paramInt2);
/* 343 */     return finalCRC(l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CRC(Parameters paramParameters) {
/* 354 */     this.a = new Parameters(paramParameters);
/*     */     
/* 356 */     this.b = Parameters.c(paramParameters) ? a(Parameters.a(paramParameters), Parameters.b(paramParameters)) : Parameters.a(paramParameters);
/* 357 */     this.d = ((Parameters.b(paramParameters) >= 64) ? 0L : (1L << Parameters.b(paramParameters))) - 1L;
/* 358 */     this.c = new long[256];
/*     */     
/* 360 */     byte[] arrayOfByte = new byte[1];
/*     */ 
/*     */ 
/*     */     
/* 364 */     Parameters.a(paramParameters = new Parameters(paramParameters), 0L);
/* 365 */     Parameters.a(paramParameters, Parameters.c(paramParameters));
/* 366 */     Parameters.b(paramParameters, 0L);
/* 367 */     for (byte b = 0; b < 'Ā'; b++) {
/*     */       
/* 369 */       arrayOfByte[0] = (byte)b;
/* 370 */       this.c[b] = calculateCRC(paramParameters, arrayOfByte);
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
/*     */   public final byte finalCRC8(long paramLong) {
/* 383 */     if (Parameters.b(this.a) != 8)
/* 384 */       throw new RuntimeException("CRC width mismatch"); 
/* 385 */     return (byte)(int)finalCRC(paramLong);
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
/*     */   public final short finalCRC16(long paramLong) {
/* 397 */     if (Parameters.b(this.a) != 16)
/* 398 */       throw new RuntimeException("CRC width mismatch"); 
/* 399 */     return (short)(int)finalCRC(paramLong);
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
/*     */   public final int finalCRC32(long paramLong) {
/* 411 */     if (Parameters.b(this.a) != 32)
/* 412 */       throw new RuntimeException("CRC width mismatch"); 
/* 413 */     return (int)finalCRC(paramLong);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\CRC.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */