/*     */ package org.lwjgl.openal;
/*     */ 
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.LongBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SOFTSourceLatency
/*     */ {
/*     */   public static final int AL_SAMPLE_OFFSET_LATENCY_SOFT = 4608;
/*     */   public static final int AL_SEC_OFFSET_LATENCY_SOFT = 4609;
/*     */   
/*     */   protected SOFTSourceLatency() {
/*  67 */     throw new UnsupportedOperationException();
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
/*     */   @NativeType("ALvoid")
/*     */   public static void alSourcedSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALdouble") double paramDouble) {
/*  81 */     long l = (AL.getICD()).alSourcedSOFT;
/*  82 */     if (Checks.CHECKS) {
/*  83 */       Checks.check(l);
/*     */     }
/*  85 */     JNI.invokeV(paramInt1, paramInt2, paramDouble, l);
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
/*     */   @NativeType("ALvoid")
/*     */   public static void alSource3dSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALdouble") double paramDouble1, @NativeType("ALdouble") double paramDouble2, @NativeType("ALdouble") double paramDouble3) {
/* 101 */     long l = (AL.getICD()).alSource3dSOFT;
/* 102 */     if (Checks.CHECKS) {
/* 103 */       Checks.check(l);
/*     */     }
/* 105 */     JNI.invokeV(paramInt1, paramInt2, paramDouble1, paramDouble2, paramDouble3, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalSourcedvSOFT(int paramInt1, int paramInt2, long paramLong) {
/* 112 */     long l = (AL.getICD()).alSourcedvSOFT;
/* 113 */     if (Checks.CHECKS) {
/* 114 */       Checks.check(l);
/*     */     }
/* 116 */     JNI.invokePV(paramInt1, paramInt2, paramLong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alSourcedvSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 128 */     if (Checks.CHECKS) {
/* 129 */       Checks.check(paramDoubleBuffer, 1);
/*     */     }
/* 131 */     nalSourcedvSOFT(paramInt1, paramInt2, MemoryUtil.memAddress(paramDoubleBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetSourcedSOFT(int paramInt1, int paramInt2, long paramLong) {
/* 138 */     long l = (AL.getICD()).alGetSourcedSOFT;
/* 139 */     if (Checks.CHECKS) {
/* 140 */       Checks.check(l);
/*     */     }
/* 142 */     JNI.invokePV(paramInt1, paramInt2, paramLong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetSourcedSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALdouble *") DoubleBuffer paramDoubleBuffer) {
/* 154 */     if (Checks.CHECKS) {
/* 155 */       Checks.check(paramDoubleBuffer, 1);
/*     */     }
/* 157 */     nalGetSourcedSOFT(paramInt1, paramInt2, MemoryUtil.memAddress(paramDoubleBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static double alGetSourcedSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2) {
/*     */     MemoryStack memoryStack;
/* 168 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 170 */       DoubleBuffer doubleBuffer = memoryStack.callocDouble(1);
/* 171 */       nalGetSourcedSOFT(paramInt1, paramInt2, MemoryUtil.memAddress(doubleBuffer));
/* 172 */       return doubleBuffer.get(0);
/*     */     } finally {
/* 174 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetSource3dSOFT(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3) {
/* 182 */     long l = (AL.getICD()).alGetSource3dSOFT;
/* 183 */     if (Checks.CHECKS) {
/* 184 */       Checks.check(l);
/*     */     }
/* 186 */     JNI.invokePPPV(paramInt1, paramInt2, paramLong1, paramLong2, paramLong3, l);
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
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetSource3dSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALdouble *") DoubleBuffer paramDoubleBuffer1, @NativeType("ALdouble *") DoubleBuffer paramDoubleBuffer2, @NativeType("ALdouble *") DoubleBuffer paramDoubleBuffer3) {
/* 200 */     if (Checks.CHECKS) {
/* 201 */       Checks.check(paramDoubleBuffer1, 1);
/* 202 */       Checks.check(paramDoubleBuffer2, 1);
/* 203 */       Checks.check(paramDoubleBuffer3, 1);
/*     */     } 
/* 205 */     nalGetSource3dSOFT(paramInt1, paramInt2, MemoryUtil.memAddress(paramDoubleBuffer1), MemoryUtil.memAddress(paramDoubleBuffer2), MemoryUtil.memAddress(paramDoubleBuffer3));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetSourcedvSOFT(int paramInt1, int paramInt2, long paramLong) {
/* 212 */     long l = (AL.getICD()).alGetSourcedvSOFT;
/* 213 */     if (Checks.CHECKS) {
/* 214 */       Checks.check(l);
/*     */     }
/* 216 */     JNI.invokePV(paramInt1, paramInt2, paramLong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetSourcedvSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALdouble *") DoubleBuffer paramDoubleBuffer) {
/* 228 */     if (Checks.CHECKS) {
/* 229 */       Checks.check(paramDoubleBuffer, 1);
/*     */     }
/* 231 */     nalGetSourcedvSOFT(paramInt1, paramInt2, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*     */   @NativeType("ALvoid")
/*     */   public static void alSourcei64SOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint64SOFT") long paramLong) {
/* 245 */     long l = (AL.getICD()).alSourcei64SOFT;
/* 246 */     if (Checks.CHECKS) {
/* 247 */       Checks.check(l);
/*     */     }
/* 249 */     JNI.invokeJV(paramInt1, paramInt2, paramLong, l);
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
/*     */   @NativeType("ALvoid")
/*     */   public static void alSource3i64SOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint64SOFT") long paramLong1, @NativeType("ALint64SOFT") long paramLong2, @NativeType("ALint64SOFT") long paramLong3) {
/* 265 */     long l = (AL.getICD()).alSource3i64SOFT;
/* 266 */     if (Checks.CHECKS) {
/* 267 */       Checks.check(l);
/*     */     }
/* 269 */     JNI.invokeJJJV(paramInt1, paramInt2, paramLong1, paramLong2, paramLong3, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalSourcei64vSOFT(int paramInt1, int paramInt2, long paramLong) {
/* 276 */     long l = (AL.getICD()).alSourcei64vSOFT;
/* 277 */     if (Checks.CHECKS) {
/* 278 */       Checks.check(l);
/*     */     }
/* 280 */     JNI.invokePV(paramInt1, paramInt2, paramLong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alSourcei64vSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint64SOFT const *") LongBuffer paramLongBuffer) {
/* 292 */     if (Checks.CHECKS) {
/* 293 */       Checks.check(paramLongBuffer, 1);
/*     */     }
/* 295 */     nalSourcei64vSOFT(paramInt1, paramInt2, MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetSourcei64SOFT(int paramInt1, int paramInt2, long paramLong) {
/* 302 */     long l = (AL.getICD()).alGetSourcei64SOFT;
/* 303 */     if (Checks.CHECKS) {
/* 304 */       Checks.check(l);
/*     */     }
/* 306 */     JNI.invokePV(paramInt1, paramInt2, paramLong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetSourcei64SOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint64SOFT *") LongBuffer paramLongBuffer) {
/* 318 */     if (Checks.CHECKS) {
/* 319 */       Checks.check(paramLongBuffer, 1);
/*     */     }
/* 321 */     nalGetSourcei64SOFT(paramInt1, paramInt2, MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static long alGetSourcei64SOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2) {
/*     */     MemoryStack memoryStack;
/* 332 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 334 */       LongBuffer longBuffer = memoryStack.callocLong(1);
/* 335 */       nalGetSourcei64SOFT(paramInt1, paramInt2, MemoryUtil.memAddress(longBuffer));
/* 336 */       return longBuffer.get(0);
/*     */     } finally {
/* 338 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetSource3i64SOFT(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3) {
/* 346 */     long l = (AL.getICD()).alGetSource3i64SOFT;
/* 347 */     if (Checks.CHECKS) {
/* 348 */       Checks.check(l);
/*     */     }
/* 350 */     JNI.invokePPPV(paramInt1, paramInt2, paramLong1, paramLong2, paramLong3, l);
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
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetSource3i64SOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint64SOFT *") LongBuffer paramLongBuffer1, @NativeType("ALint64SOFT *") LongBuffer paramLongBuffer2, @NativeType("ALint64SOFT *") LongBuffer paramLongBuffer3) {
/* 364 */     if (Checks.CHECKS) {
/* 365 */       Checks.check(paramLongBuffer1, 1);
/* 366 */       Checks.check(paramLongBuffer2, 1);
/* 367 */       Checks.check(paramLongBuffer3, 1);
/*     */     } 
/* 369 */     nalGetSource3i64SOFT(paramInt1, paramInt2, MemoryUtil.memAddress(paramLongBuffer1), MemoryUtil.memAddress(paramLongBuffer2), MemoryUtil.memAddress(paramLongBuffer3));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetSourcei64vSOFT(int paramInt1, int paramInt2, long paramLong) {
/* 376 */     long l = (AL.getICD()).alGetSourcei64vSOFT;
/* 377 */     if (Checks.CHECKS) {
/* 378 */       Checks.check(l);
/*     */     }
/* 380 */     JNI.invokePV(paramInt1, paramInt2, paramLong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetSourcei64vSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint64SOFT *") LongBuffer paramLongBuffer) {
/* 392 */     if (Checks.CHECKS) {
/* 393 */       Checks.check(paramLongBuffer, 1);
/*     */     }
/* 395 */     nalGetSourcei64vSOFT(paramInt1, paramInt2, MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alSourcedvSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALdouble const *") double[] paramArrayOfdouble) {
/* 401 */     long l = (AL.getICD()).alSourcedvSOFT;
/* 402 */     if (Checks.CHECKS) {
/* 403 */       Checks.check(l);
/* 404 */       Checks.check(paramArrayOfdouble, 1);
/*     */     } 
/* 406 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOfdouble, l);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetSourcedSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALdouble *") double[] paramArrayOfdouble) {
/* 412 */     long l = (AL.getICD()).alGetSourcedSOFT;
/* 413 */     if (Checks.CHECKS) {
/* 414 */       Checks.check(l);
/* 415 */       Checks.check(paramArrayOfdouble, 1);
/*     */     } 
/* 417 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOfdouble, l);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetSource3dSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALdouble *") double[] paramArrayOfdouble1, @NativeType("ALdouble *") double[] paramArrayOfdouble2, @NativeType("ALdouble *") double[] paramArrayOfdouble3) {
/* 423 */     long l = (AL.getICD()).alGetSource3dSOFT;
/* 424 */     if (Checks.CHECKS) {
/* 425 */       Checks.check(l);
/* 426 */       Checks.check(paramArrayOfdouble1, 1);
/* 427 */       Checks.check(paramArrayOfdouble2, 1);
/* 428 */       Checks.check(paramArrayOfdouble3, 1);
/*     */     } 
/* 430 */     JNI.invokePPPV(paramInt1, paramInt2, paramArrayOfdouble1, paramArrayOfdouble2, paramArrayOfdouble3, l);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetSourcedvSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALdouble *") double[] paramArrayOfdouble) {
/* 436 */     long l = (AL.getICD()).alGetSourcedvSOFT;
/* 437 */     if (Checks.CHECKS) {
/* 438 */       Checks.check(l);
/* 439 */       Checks.check(paramArrayOfdouble, 1);
/*     */     } 
/* 441 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOfdouble, l);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alSourcei64vSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint64SOFT const *") long[] paramArrayOflong) {
/* 447 */     long l = (AL.getICD()).alSourcei64vSOFT;
/* 448 */     if (Checks.CHECKS) {
/* 449 */       Checks.check(l);
/* 450 */       Checks.check(paramArrayOflong, 1);
/*     */     } 
/* 452 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetSourcei64SOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint64SOFT *") long[] paramArrayOflong) {
/* 458 */     long l = (AL.getICD()).alGetSourcei64SOFT;
/* 459 */     if (Checks.CHECKS) {
/* 460 */       Checks.check(l);
/* 461 */       Checks.check(paramArrayOflong, 1);
/*     */     } 
/* 463 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetSource3i64SOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint64SOFT *") long[] paramArrayOflong1, @NativeType("ALint64SOFT *") long[] paramArrayOflong2, @NativeType("ALint64SOFT *") long[] paramArrayOflong3) {
/* 469 */     long l = (AL.getICD()).alGetSource3i64SOFT;
/* 470 */     if (Checks.CHECKS) {
/* 471 */       Checks.check(l);
/* 472 */       Checks.check(paramArrayOflong1, 1);
/* 473 */       Checks.check(paramArrayOflong2, 1);
/* 474 */       Checks.check(paramArrayOflong3, 1);
/*     */     } 
/* 476 */     JNI.invokePPPV(paramInt1, paramInt2, paramArrayOflong1, paramArrayOflong2, paramArrayOflong3, l);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetSourcei64vSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint64SOFT *") long[] paramArrayOflong) {
/* 482 */     long l = (AL.getICD()).alGetSourcei64vSOFT;
/* 483 */     if (Checks.CHECKS) {
/* 484 */       Checks.check(l);
/* 485 */       Checks.check(paramArrayOflong, 1);
/*     */     } 
/* 487 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOflong, l);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\openal\SOFTSourceLatency.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */