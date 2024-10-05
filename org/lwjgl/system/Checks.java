/*     */ package org.lwjgl.system;
/*     */ 
/*     */ import java.nio.Buffer;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.LongBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Checks
/*     */ {
/*  37 */   public static final boolean CHECKS = !((Boolean)Configuration.DISABLE_CHECKS.get(Boolean.FALSE)).booleanValue();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  48 */   public static final boolean DEBUG = ((Boolean)Configuration.DEBUG.get(Boolean.FALSE)).booleanValue();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final boolean DEBUG_FUNCTIONS;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*  60 */     if ((DEBUG_FUNCTIONS = ((Boolean)Configuration.DEBUG_FUNCTIONS.get(Boolean.FALSE)).booleanValue()) && !DEBUG) {
/*  61 */       APIUtil.DEBUG_STREAM.println("[LWJGL] The DEBUG_FUNCTIONS option requires DEBUG to produce output.");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int lengthSafe(short[] paramArrayOfshort) {
/*  68 */     return (paramArrayOfshort == null) ? 0 : paramArrayOfshort.length;
/*  69 */   } public static int lengthSafe(int[] paramArrayOfint) { return (paramArrayOfint == null) ? 0 : paramArrayOfint.length; }
/*  70 */   public static int lengthSafe(long[] paramArrayOflong) { return (paramArrayOflong == null) ? 0 : paramArrayOflong.length; }
/*  71 */   public static int lengthSafe(float[] paramArrayOffloat) { return (paramArrayOffloat == null) ? 0 : paramArrayOffloat.length; }
/*  72 */   public static int lengthSafe(double[] paramArrayOfdouble) { return (paramArrayOfdouble == null) ? 0 : paramArrayOfdouble.length; }
/*  73 */   public static int remainingSafe(Buffer paramBuffer) { return (paramBuffer == null) ? 0 : paramBuffer.remaining(); } public static int remainingSafe(CustomBuffer<?> paramCustomBuffer) {
/*  74 */     return (paramCustomBuffer == null) ? 0 : paramCustomBuffer.remaining();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean checkFunctions(long... paramVarArgs) {
/*     */     int i;
/*     */     byte b;
/*  84 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; b++) {
/*  85 */       long l; if ((l = paramVarArgs[b]) == 0L) {
/*  86 */         return false;
/*     */       }
/*     */     } 
/*  89 */     return true;
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
/*     */   public static boolean checkFunctions(FunctionProvider paramFunctionProvider, PointerBuffer paramPointerBuffer, int[] paramArrayOfint, String... paramVarArgs) {
/* 103 */     boolean bool = true;
/* 104 */     for (byte b = 0; b < paramArrayOfint.length; b++) {
/*     */       int i;
/* 106 */       if ((i = paramArrayOfint[b]) >= 0 && paramPointerBuffer.get(i) == 0L) {
/*     */         long l;
/*     */ 
/*     */         
/* 110 */         if ((l = paramFunctionProvider.getFunctionAddress(paramVarArgs[b])) == 0L)
/* 111 */         { bool = false; }
/*     */         else
/*     */         
/* 114 */         { paramPointerBuffer.put(i, l); } 
/*     */       } 
/* 116 */     }  return bool;
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
/*     */   public static boolean checkFunctions(FunctionProviderLocal paramFunctionProviderLocal, long paramLong, PointerBuffer paramPointerBuffer, int[] paramArrayOfint, String... paramVarArgs) {
/* 131 */     boolean bool = true;
/* 132 */     for (byte b = 0; b < paramArrayOfint.length; b++) {
/*     */       int i;
/* 134 */       if ((i = paramArrayOfint[b]) >= 0 && paramPointerBuffer.get(i) == 0L) {
/*     */         long l;
/*     */ 
/*     */         
/* 138 */         if ((l = paramFunctionProviderLocal.getFunctionAddress(paramLong, paramVarArgs[b])) != 0L)
/* 139 */         { paramPointerBuffer.put(i, l); }
/*     */         else
/*     */         
/* 142 */         { bool = false; } 
/*     */       } 
/* 144 */     }  return bool;
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
/*     */   public static boolean checkFunctions(FunctionProvider paramFunctionProvider, long[] paramArrayOflong, int[] paramArrayOfint, String... paramVarArgs) {
/* 158 */     boolean bool = true;
/* 159 */     for (byte b = 0; b < paramArrayOfint.length; b++) {
/*     */       int i;
/* 161 */       if ((i = paramArrayOfint[b]) >= 0 && paramArrayOflong[i] == 0L) {
/*     */         long l;
/*     */ 
/*     */         
/* 165 */         if ((l = paramFunctionProvider.getFunctionAddress(paramVarArgs[b])) == 0L)
/* 166 */         { bool = false; }
/*     */         else
/*     */         
/* 169 */         { paramArrayOflong[i] = l; } 
/*     */       } 
/* 171 */     }  return bool;
/*     */   }
/*     */   
/*     */   public static boolean reportMissing(String paramString1, String paramString2) {
/* 175 */     APIUtil.apiLog("[" + paramString1 + "] " + paramString2 + " was reported as available but an entry point is missing.");
/* 176 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long check(long paramLong) {
/* 187 */     if (paramLong == 0L) {
/* 188 */       throw new NullPointerException();
/*     */     }
/*     */     
/* 191 */     return paramLong;
/*     */   }
/*     */   
/*     */   private static void assertNT(boolean paramBoolean) {
/* 195 */     if (!paramBoolean) {
/* 196 */       throw new IllegalArgumentException("Missing termination");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static void checkNT(int[] paramArrayOfint) {
/* 202 */     checkBuffer(paramArrayOfint.length, 1);
/* 203 */     assertNT((paramArrayOfint[paramArrayOfint.length - 1] == 0));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void checkNT(int[] paramArrayOfint, int paramInt) {
/* 208 */     checkBuffer(paramArrayOfint.length, 1);
/* 209 */     assertNT((paramArrayOfint[paramArrayOfint.length - 1] == paramInt));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void checkNT(long[] paramArrayOflong) {
/* 214 */     checkBuffer(paramArrayOflong.length, 1);
/* 215 */     assertNT((paramArrayOflong[paramArrayOflong.length - 1] == 0L));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void checkNT(float[] paramArrayOffloat) {
/* 220 */     checkBuffer(paramArrayOffloat.length, 1);
/* 221 */     assertNT((paramArrayOffloat[paramArrayOffloat.length - 1] == 0.0F));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void checkNT1(ByteBuffer paramByteBuffer) {
/* 226 */     checkBuffer(paramByteBuffer.remaining(), 1);
/* 227 */     assertNT((paramByteBuffer.get(paramByteBuffer.limit() - 1) == 0));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void checkNT2(ByteBuffer paramByteBuffer) {
/* 232 */     checkBuffer(paramByteBuffer.remaining(), 2);
/* 233 */     assertNT((paramByteBuffer.get(paramByteBuffer.limit() - 2) == 0));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void checkNT(IntBuffer paramIntBuffer) {
/* 238 */     checkBuffer(paramIntBuffer.remaining(), 1);
/* 239 */     assertNT((paramIntBuffer.get(paramIntBuffer.limit() - 1) == 0));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void checkNT(IntBuffer paramIntBuffer, int paramInt) {
/* 244 */     checkBuffer(paramIntBuffer.remaining(), 1);
/* 245 */     assertNT((paramIntBuffer.get(paramIntBuffer.limit() - 1) == paramInt));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void checkNT(LongBuffer paramLongBuffer) {
/* 250 */     checkBuffer(paramLongBuffer.remaining(), 1);
/* 251 */     assertNT((paramLongBuffer.get(paramLongBuffer.limit() - 1) == 0L));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void checkNT(FloatBuffer paramFloatBuffer) {
/* 256 */     checkBuffer(paramFloatBuffer.remaining(), 1);
/* 257 */     assertNT((paramFloatBuffer.get(paramFloatBuffer.limit() - 1) == 0.0F));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void checkNT(PointerBuffer paramPointerBuffer) {
/* 262 */     checkBuffer(paramPointerBuffer.remaining(), 1);
/* 263 */     assertNT((paramPointerBuffer.get(paramPointerBuffer.limit() - 1) == 0L));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void checkNT(PointerBuffer paramPointerBuffer, long paramLong) {
/* 268 */     checkBuffer(paramPointerBuffer.remaining(), 1);
/* 269 */     assertNT((paramPointerBuffer.get(paramPointerBuffer.limit() - 1) == paramLong));
/*     */   }
/*     */   
/*     */   public static void checkNTSafe(int[] paramArrayOfint) {
/* 273 */     if (paramArrayOfint != null) {
/* 274 */       checkBuffer(paramArrayOfint.length, 1);
/* 275 */       assertNT((paramArrayOfint[paramArrayOfint.length - 1] == 0));
/*     */     } 
/*     */   }
/*     */   public static void checkNTSafe(int[] paramArrayOfint, int paramInt) {
/* 279 */     if (paramArrayOfint != null) {
/* 280 */       checkBuffer(paramArrayOfint.length, 1);
/* 281 */       assertNT((paramArrayOfint[paramArrayOfint.length - 1] == paramInt));
/*     */     } 
/*     */   }
/*     */   public static void checkNTSafe(long[] paramArrayOflong) {
/* 285 */     if (paramArrayOflong != null) {
/* 286 */       checkBuffer(paramArrayOflong.length, 1);
/* 287 */       assertNT((paramArrayOflong[paramArrayOflong.length - 1] == 0L));
/*     */     } 
/*     */   }
/*     */   public static void checkNTSafe(float[] paramArrayOffloat) {
/* 291 */     if (paramArrayOffloat != null) {
/* 292 */       checkBuffer(paramArrayOffloat.length, 1);
/* 293 */       assertNT((paramArrayOffloat[paramArrayOffloat.length - 1] == 0.0F));
/*     */     } 
/*     */   }
/*     */   public static void checkNT1Safe(ByteBuffer paramByteBuffer) {
/* 297 */     if (paramByteBuffer != null) {
/* 298 */       checkBuffer(paramByteBuffer.remaining(), 1);
/* 299 */       assertNT((paramByteBuffer.get(paramByteBuffer.limit() - 1) == 0));
/*     */     } 
/*     */   }
/*     */   public static void checkNT2Safe(ByteBuffer paramByteBuffer) {
/* 303 */     if (paramByteBuffer != null) {
/* 304 */       checkBuffer(paramByteBuffer.remaining(), 2);
/* 305 */       assertNT((paramByteBuffer.get(paramByteBuffer.limit() - 2) == 0));
/*     */     } 
/*     */   }
/*     */   public static void checkNTSafe(IntBuffer paramIntBuffer) {
/* 309 */     if (paramIntBuffer != null) {
/* 310 */       checkBuffer(paramIntBuffer.remaining(), 1);
/* 311 */       assertNT((paramIntBuffer.get(paramIntBuffer.limit() - 1) == 0));
/*     */     } 
/*     */   }
/*     */   public static void checkNTSafe(IntBuffer paramIntBuffer, int paramInt) {
/* 315 */     if (paramIntBuffer != null) {
/* 316 */       checkBuffer(paramIntBuffer.remaining(), 1);
/* 317 */       assertNT((paramIntBuffer.get(paramIntBuffer.limit() - 1) == paramInt));
/*     */     } 
/*     */   }
/*     */   public static void checkNTSafe(LongBuffer paramLongBuffer) {
/* 321 */     if (paramLongBuffer != null) {
/* 322 */       checkBuffer(paramLongBuffer.remaining(), 1);
/* 323 */       assertNT((paramLongBuffer.get(paramLongBuffer.limit() - 1) == 0L));
/*     */     } 
/*     */   }
/*     */   public static void checkNTSafe(FloatBuffer paramFloatBuffer) {
/* 327 */     if (paramFloatBuffer != null) {
/* 328 */       checkBuffer(paramFloatBuffer.remaining(), 1);
/* 329 */       assertNT((paramFloatBuffer.get(paramFloatBuffer.limit() - 1) == 0.0F));
/*     */     } 
/*     */   }
/*     */   public static void checkNTSafe(PointerBuffer paramPointerBuffer) {
/* 333 */     if (paramPointerBuffer != null) {
/* 334 */       checkBuffer(paramPointerBuffer.remaining(), 1);
/* 335 */       assertNT((paramPointerBuffer.get(paramPointerBuffer.limit() - 1) == 0L));
/*     */     } 
/*     */   }
/*     */   public static void checkNTSafe(PointerBuffer paramPointerBuffer, long paramLong) {
/* 339 */     if (paramPointerBuffer != null) {
/* 340 */       checkBuffer(paramPointerBuffer.remaining(), 1);
/* 341 */       assertNT((paramPointerBuffer.get(paramPointerBuffer.limit() - 1) == paramLong));
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void checkBuffer(int paramInt1, int paramInt2) {
/* 346 */     if (paramInt1 < paramInt2) {
/* 347 */       throwIAE(paramInt1, paramInt2);
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
/*     */   public static void check(byte[] paramArrayOfbyte, int paramInt) {
/* 360 */     checkBuffer(paramArrayOfbyte.length, paramInt);
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
/*     */   public static void check(short[] paramArrayOfshort, int paramInt) {
/* 372 */     checkBuffer(paramArrayOfshort.length, paramInt);
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
/*     */   public static void check(int[] paramArrayOfint, int paramInt) {
/* 384 */     checkBuffer(paramArrayOfint.length, paramInt);
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
/*     */   public static void check(long[] paramArrayOflong, int paramInt) {
/* 396 */     checkBuffer(paramArrayOflong.length, paramInt);
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
/*     */   public static void check(float[] paramArrayOffloat, int paramInt) {
/* 408 */     checkBuffer(paramArrayOffloat.length, paramInt);
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
/*     */   public static void check(double[] paramArrayOfdouble, int paramInt) {
/* 420 */     checkBuffer(paramArrayOfdouble.length, paramInt);
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
/*     */   public static void check(CharSequence paramCharSequence, int paramInt) {
/* 432 */     checkBuffer(paramCharSequence.length(), paramInt);
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
/*     */   public static void check(Buffer paramBuffer, int paramInt) {
/* 444 */     checkBuffer(paramBuffer.remaining(), paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void check(Buffer paramBuffer, long paramLong) {
/* 449 */     checkBuffer(paramBuffer.remaining(), (int)paramLong);
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
/*     */   public static void check(CustomBuffer<?> paramCustomBuffer, int paramInt) {
/* 461 */     checkBuffer(paramCustomBuffer.remaining(), paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void check(CustomBuffer<?> paramCustomBuffer, long paramLong) {
/* 466 */     checkBuffer(paramCustomBuffer.remaining(), (int)paramLong);
/*     */   }
/*     */   
/*     */   public static void checkSafe(short[] paramArrayOfshort, int paramInt) {
/* 470 */     if (paramArrayOfshort != null)
/* 471 */       checkBuffer(paramArrayOfshort.length, paramInt); 
/*     */   }
/*     */   
/*     */   public static void checkSafe(int[] paramArrayOfint, int paramInt) {
/* 475 */     if (paramArrayOfint != null)
/* 476 */       checkBuffer(paramArrayOfint.length, paramInt); 
/*     */   }
/*     */   
/*     */   public static void checkSafe(long[] paramArrayOflong, int paramInt) {
/* 480 */     if (paramArrayOflong != null)
/* 481 */       checkBuffer(paramArrayOflong.length, paramInt); 
/*     */   }
/*     */   
/*     */   public static void checkSafe(float[] paramArrayOffloat, int paramInt) {
/* 485 */     if (paramArrayOffloat != null)
/* 486 */       checkBuffer(paramArrayOffloat.length, paramInt); 
/*     */   }
/*     */   
/*     */   public static void checkSafe(double[] paramArrayOfdouble, int paramInt) {
/* 490 */     if (paramArrayOfdouble != null)
/* 491 */       checkBuffer(paramArrayOfdouble.length, paramInt); 
/*     */   }
/*     */   
/*     */   public static void checkSafe(Buffer paramBuffer, int paramInt) {
/* 495 */     if (paramBuffer != null)
/* 496 */       checkBuffer(paramBuffer.remaining(), paramInt); 
/*     */   }
/*     */   
/*     */   public static void checkSafe(Buffer paramBuffer, long paramLong) {
/* 500 */     if (paramBuffer != null)
/* 501 */       checkBuffer(paramBuffer.remaining(), (int)paramLong); 
/*     */   }
/*     */   
/*     */   public static void checkSafe(CustomBuffer<?> paramCustomBuffer, int paramInt) {
/* 505 */     if (paramCustomBuffer != null)
/* 506 */       checkBuffer(paramCustomBuffer.remaining(), paramInt); 
/*     */   }
/*     */   
/*     */   public static void checkSafe(CustomBuffer<?> paramCustomBuffer, long paramLong) {
/* 510 */     if (paramCustomBuffer != null) {
/* 511 */       checkBuffer(paramCustomBuffer.remaining(), (int)paramLong);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void check(Object[] paramArrayOfObject, int paramInt) {
/* 516 */     checkBuffer(paramArrayOfObject.length, paramInt);
/*     */   }
/*     */   
/*     */   private static void checkBufferGT(int paramInt1, int paramInt2) {
/* 520 */     if (paramInt2 < paramInt1) {
/* 521 */       throwIAEGT(paramInt1, paramInt2);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void checkGT(Buffer paramBuffer, int paramInt) {
/* 526 */     checkBufferGT(paramBuffer.remaining(), paramInt);
/*     */   }
/*     */   
/*     */   public static void checkGT(CustomBuffer<?> paramCustomBuffer, int paramInt) {
/* 530 */     checkBufferGT(paramCustomBuffer.remaining(), paramInt);
/*     */   }
/*     */   
/*     */   public static long check(int paramInt1, int paramInt2) {
/* 534 */     if (CHECKS) {
/* 535 */       CheckIntrinsics.checkIndex(paramInt1, paramInt2);
/*     */     }
/*     */ 
/*     */     
/* 539 */     return Integer.toUnsignedLong(paramInt1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void throwIAE(int paramInt1, int paramInt2) {
/* 545 */     throw new IllegalArgumentException("Number of remaining elements is " + paramInt1 + ", must be at least " + paramInt2);
/*     */   }
/*     */   
/*     */   private static void throwIAEGT(int paramInt1, int paramInt2) {
/* 549 */     throw new IllegalArgumentException("Number of remaining buffer elements is " + paramInt1 + ", must be at most " + paramInt2);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\Checks.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */