/*     */ package org.lwjgl.openal;
/*     */ 
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
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
/*     */ public class AL11
/*     */   extends AL10
/*     */ {
/*     */   public static final int AL_SEC_OFFSET = 4132;
/*     */   public static final int AL_SAMPLE_OFFSET = 4133;
/*     */   public static final int AL_BYTE_OFFSET = 4134;
/*     */   public static final int AL_STATIC = 4136;
/*     */   public static final int AL_STREAMING = 4137;
/*     */   public static final int AL_UNDETERMINED = 4144;
/*     */   public static final int AL_ILLEGAL_COMMAND = 40964;
/*     */   public static final int AL_SPEED_OF_SOUND = 49155;
/*     */   public static final int AL_LINEAR_DISTANCE = 53251;
/*     */   public static final int AL_LINEAR_DISTANCE_CLAMPED = 53252;
/*     */   public static final int AL_EXPONENT_DISTANCE = 53253;
/*     */   public static final int AL_EXPONENT_DISTANCE_CLAMPED = 53254;
/*     */   
/*     */   protected AL11() {
/*  35 */     throw new UnsupportedOperationException();
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
/*     */   @NativeType("ALvoid")
/*     */   public static void alListener3i(@NativeType("ALenum") int paramInt1, @NativeType("ALint") int paramInt2, @NativeType("ALint") int paramInt3, @NativeType("ALint") int paramInt4) {
/*  50 */     long l = (AL.getICD()).alListener3i;
/*  51 */     if (Checks.CHECKS) {
/*  52 */       Checks.check(l);
/*     */     }
/*  54 */     JNI.invokeV(paramInt1, paramInt2, paramInt3, paramInt4, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetListeneriv(int paramInt, long paramLong) {
/*  61 */     long l = (AL.getICD()).alGetListeneriv;
/*  62 */     if (Checks.CHECKS) {
/*  63 */       Checks.check(l);
/*     */     }
/*  65 */     JNI.invokePV(paramInt, paramLong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetListeneriv(@NativeType("ALenum") int paramInt, @NativeType("ALint *") IntBuffer paramIntBuffer) {
/*  76 */     if (Checks.CHECKS) {
/*  77 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/*  79 */     nalGetListeneriv(paramInt, MemoryUtil.memAddress(paramIntBuffer));
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
/*     */   public static void alSource3i(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint") int paramInt3, @NativeType("ALint") int paramInt4, @NativeType("ALint") int paramInt5) {
/*  95 */     long l = (AL.getICD()).alSource3i;
/*  96 */     if (Checks.CHECKS) {
/*  97 */       Checks.check(l);
/*     */     }
/*  99 */     JNI.invokeV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalListeneriv(int paramInt, long paramLong) {
/* 106 */     long l = (AL.getICD()).alListeneriv;
/* 107 */     if (Checks.CHECKS) {
/* 108 */       Checks.check(l);
/*     */     }
/* 110 */     JNI.invokePV(paramInt, paramLong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alListeneriv(@NativeType("ALenum") int paramInt, @NativeType("ALint const *") IntBuffer paramIntBuffer) {
/* 121 */     if (Checks.CHECKS) {
/* 122 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 124 */     nalListeneriv(paramInt, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalSourceiv(int paramInt1, int paramInt2, long paramLong) {
/* 131 */     long l = (AL.getICD()).alSourceiv;
/* 132 */     if (Checks.CHECKS) {
/* 133 */       Checks.check(l);
/*     */     }
/* 135 */     JNI.invokePV(paramInt1, paramInt2, paramLong, l);
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
/*     */   public static void alSourceiv(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint const *") IntBuffer paramIntBuffer) {
/* 147 */     if (Checks.CHECKS) {
/* 148 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 150 */     nalSourceiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
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
/*     */   public static void alBufferf(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALfloat") float paramFloat) {
/* 164 */     long l = (AL.getICD()).alBufferf;
/* 165 */     if (Checks.CHECKS) {
/* 166 */       Checks.check(l);
/*     */     }
/* 168 */     JNI.invokeV(paramInt1, paramInt2, paramFloat, l);
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
/*     */   public static void alBuffer3f(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALfloat") float paramFloat1, @NativeType("ALfloat") float paramFloat2, @NativeType("ALfloat") float paramFloat3) {
/* 184 */     long l = (AL.getICD()).alBuffer3f;
/* 185 */     if (Checks.CHECKS) {
/* 186 */       Checks.check(l);
/*     */     }
/* 188 */     JNI.invokeV(paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalBufferfv(int paramInt1, int paramInt2, long paramLong) {
/* 195 */     long l = (AL.getICD()).alBufferfv;
/* 196 */     if (Checks.CHECKS) {
/* 197 */       Checks.check(l);
/*     */     }
/* 199 */     JNI.invokePV(paramInt1, paramInt2, paramLong, l);
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
/*     */   public static void alBufferfv(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALfloat const *") FloatBuffer paramFloatBuffer) {
/* 211 */     if (Checks.CHECKS) {
/* 212 */       Checks.check(paramFloatBuffer, 1);
/*     */     }
/* 214 */     nalBufferfv(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
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
/*     */   public static void alBufferi(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint") int paramInt3) {
/* 228 */     long l = (AL.getICD()).alBufferi;
/* 229 */     if (Checks.CHECKS) {
/* 230 */       Checks.check(l);
/*     */     }
/* 232 */     JNI.invokeV(paramInt1, paramInt2, paramInt3, l);
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
/*     */   public static void alBuffer3i(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint") int paramInt3, @NativeType("ALint") int paramInt4, @NativeType("ALint") int paramInt5) {
/* 248 */     long l = (AL.getICD()).alBuffer3i;
/* 249 */     if (Checks.CHECKS) {
/* 250 */       Checks.check(l);
/*     */     }
/* 252 */     JNI.invokeV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalBufferiv(int paramInt1, int paramInt2, long paramLong) {
/* 259 */     long l = (AL.getICD()).alBufferiv;
/* 260 */     if (Checks.CHECKS) {
/* 261 */       Checks.check(l);
/*     */     }
/* 263 */     JNI.invokePV(paramInt1, paramInt2, paramLong, l);
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
/*     */   public static void alBufferiv(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint const *") IntBuffer paramIntBuffer) {
/* 275 */     if (Checks.CHECKS) {
/* 276 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 278 */     nalBufferiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetBufferiv(int paramInt1, int paramInt2, long paramLong) {
/* 285 */     long l = (AL.getICD()).alGetBufferiv;
/* 286 */     if (Checks.CHECKS) {
/* 287 */       Checks.check(l);
/*     */     }
/* 289 */     JNI.invokePV(paramInt1, paramInt2, paramLong, l);
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
/*     */   public static void alGetBufferiv(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint *") IntBuffer paramIntBuffer) {
/* 301 */     if (Checks.CHECKS) {
/* 302 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 304 */     nalGetBufferiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetBufferfv(int paramInt1, int paramInt2, long paramLong) {
/* 311 */     long l = (AL.getICD()).alGetBufferfv;
/* 312 */     if (Checks.CHECKS) {
/* 313 */       Checks.check(l);
/*     */     }
/* 315 */     JNI.invokePV(paramInt1, paramInt2, paramLong, l);
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
/*     */   public static void alGetBufferfv(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALfloat *") FloatBuffer paramFloatBuffer) {
/* 327 */     if (Checks.CHECKS) {
/* 328 */       Checks.check(paramFloatBuffer, 1);
/*     */     }
/* 330 */     nalGetBufferfv(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
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
/*     */   public static void alSpeedOfSound(@NativeType("ALfloat") float paramFloat) {
/* 342 */     long l = (AL.getICD()).alSpeedOfSound;
/* 343 */     if (Checks.CHECKS) {
/* 344 */       Checks.check(l);
/*     */     }
/* 346 */     JNI.invokeV(paramFloat, l);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetListeneriv(@NativeType("ALenum") int paramInt, @NativeType("ALint *") int[] paramArrayOfint) {
/* 352 */     long l = (AL.getICD()).alGetListeneriv;
/* 353 */     if (Checks.CHECKS) {
/* 354 */       Checks.check(l);
/* 355 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 357 */     JNI.invokePV(paramInt, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alListeneriv(@NativeType("ALenum") int paramInt, @NativeType("ALint const *") int[] paramArrayOfint) {
/* 363 */     long l = (AL.getICD()).alListeneriv;
/* 364 */     if (Checks.CHECKS) {
/* 365 */       Checks.check(l);
/* 366 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 368 */     JNI.invokePV(paramInt, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alSourceiv(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint const *") int[] paramArrayOfint) {
/* 374 */     long l = (AL.getICD()).alSourceiv;
/* 375 */     if (Checks.CHECKS) {
/* 376 */       Checks.check(l);
/* 377 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 379 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alBufferfv(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALfloat const *") float[] paramArrayOffloat) {
/* 385 */     long l = (AL.getICD()).alBufferfv;
/* 386 */     if (Checks.CHECKS) {
/* 387 */       Checks.check(l);
/* 388 */       Checks.check(paramArrayOffloat, 1);
/*     */     } 
/* 390 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOffloat, l);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alBufferiv(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint const *") int[] paramArrayOfint) {
/* 396 */     long l = (AL.getICD()).alBufferiv;
/* 397 */     if (Checks.CHECKS) {
/* 398 */       Checks.check(l);
/* 399 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 401 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetBufferiv(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint *") int[] paramArrayOfint) {
/* 407 */     long l = (AL.getICD()).alGetBufferiv;
/* 408 */     if (Checks.CHECKS) {
/* 409 */       Checks.check(l);
/* 410 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 412 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetBufferfv(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALfloat *") float[] paramArrayOffloat) {
/* 418 */     long l = (AL.getICD()).alGetBufferfv;
/* 419 */     if (Checks.CHECKS) {
/* 420 */       Checks.check(l);
/* 421 */       Checks.check(paramArrayOffloat, 1);
/*     */     } 
/* 423 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOffloat, l);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\openal\AL11.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */