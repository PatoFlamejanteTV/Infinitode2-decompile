/*     */ package org.lwjgl.openal;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SOFTBufferSamples
/*     */ {
/*     */   public static final int AL_MONO8_SOFT = 4352;
/*     */   public static final int AL_MONO16_SOFT = 4353;
/*     */   public static final int AL_MONO32F_SOFT = 65552;
/*     */   public static final int AL_STEREO8_SOFT = 4354;
/*     */   public static final int AL_STEREO16_SOFT = 4355;
/*     */   public static final int AL_STEREO32F_SOFT = 65553;
/*     */   public static final int AL_QUAD8_SOFT = 4612;
/*     */   public static final int AL_QUAD16_SOFT = 4613;
/*     */   public static final int AL_QUAD32F_SOFT = 4614;
/*     */   public static final int AL_REAR8_SOFT = 4615;
/*     */   public static final int AL_REAR16_SOFT = 4616;
/*     */   public static final int AL_REAR32F_SOFT = 4617;
/*     */   public static final int AL_5POINT1_8_SOFT = 4618;
/*     */   public static final int AL_5POINT1_16_SOFT = 4619;
/*     */   public static final int AL_5POINT1_32F_SOFT = 4620;
/*     */   public static final int AL_6POINT1_8_SOFT = 4621;
/*     */   public static final int AL_6POINT1_16_SOFT = 4622;
/*     */   public static final int AL_6POINT1_32F_SOFT = 4623;
/*     */   public static final int AL_7POINT1_8_SOFT = 4624;
/*     */   public static final int AL_7POINT1_16_SOFT = 4625;
/*     */   public static final int AL_7POINT1_32F_SOFT = 4626;
/*     */   public static final int AL_MONO_SOFT = 5376;
/*     */   public static final int AL_STEREO_SOFT = 5377;
/*     */   public static final int AL_QUAD_SOFT = 5378;
/*     */   public static final int AL_REAR_SOFT = 5379;
/*     */   public static final int AL_5POINT1_SOFT = 5380;
/*     */   public static final int AL_6POINT1_SOFT = 5381;
/*     */   public static final int AL_7POINT1_SOFT = 5382;
/*     */   public static final int AL_BYTE_SOFT = 5120;
/*     */   public static final int AL_UNSIGNED_BYTE_SOFT = 5121;
/*     */   public static final int AL_SHORT_SOFT = 5122;
/*     */   public static final int AL_UNSIGNED_SHORT_SOFT = 5123;
/*     */   public static final int AL_INT_SOFT = 5124;
/*     */   public static final int AL_UNSIGNED_INT_SOFT = 5125;
/*     */   public static final int AL_FLOAT_SOFT = 5126;
/*     */   public static final int AL_DOUBLE_SOFT = 5127;
/*     */   public static final int AL_BYTE3_SOFT = 5128;
/*     */   public static final int AL_UNSIGNED_BYTE3_SOFT = 5129;
/*     */   public static final int AL_INTERNAL_FORMAT_SOFT = 8200;
/*     */   public static final int AL_BYTE_LENGTH_SOFT = 8201;
/*     */   public static final int AL_SAMPLE_LENGTH_SOFT = 8202;
/*     */   public static final int AL_SEC_LENGTH_SOFT = 8203;
/*     */   public static final int AL_BYTE_RW_OFFSETS_SOFT = 4145;
/*     */   public static final int AL_SAMPLE_RW_OFFSETS_SOFT = 4146;
/*     */   
/*     */   protected SOFTBufferSamples() {
/* 103 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalBufferSamplesSOFT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong) {
/* 110 */     long l = (AL.getICD()).alBufferSamplesSOFT;
/* 111 */     if (Checks.CHECKS) {
/* 112 */       Checks.check(l);
/*     */     }
/* 114 */     JNI.invokePV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void alBufferSamplesSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALuint") int paramInt2, @NativeType("ALenum") int paramInt3, @NativeType("ALsizei") int paramInt4, @NativeType("ALenum") int paramInt5, @NativeType("ALenum") int paramInt6, @NativeType("ALvoid const *") ByteBuffer paramByteBuffer) {
/* 123 */     nalBufferSamplesSOFT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void alBufferSamplesSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALuint") int paramInt2, @NativeType("ALenum") int paramInt3, @NativeType("ALsizei") int paramInt4, @NativeType("ALenum") int paramInt5, @NativeType("ALenum") int paramInt6, @NativeType("ALvoid const *") ShortBuffer paramShortBuffer) {
/* 132 */     nalBufferSamplesSOFT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, MemoryUtil.memAddress(paramShortBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void alBufferSamplesSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALuint") int paramInt2, @NativeType("ALenum") int paramInt3, @NativeType("ALsizei") int paramInt4, @NativeType("ALenum") int paramInt5, @NativeType("ALenum") int paramInt6, @NativeType("ALvoid const *") IntBuffer paramIntBuffer) {
/* 141 */     nalBufferSamplesSOFT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void alBufferSamplesSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALuint") int paramInt2, @NativeType("ALenum") int paramInt3, @NativeType("ALsizei") int paramInt4, @NativeType("ALenum") int paramInt5, @NativeType("ALenum") int paramInt6, @NativeType("ALvoid const *") FloatBuffer paramFloatBuffer) {
/* 150 */     nalBufferSamplesSOFT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, MemoryUtil.memAddress(paramFloatBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void alBufferSamplesSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALuint") int paramInt2, @NativeType("ALenum") int paramInt3, @NativeType("ALsizei") int paramInt4, @NativeType("ALenum") int paramInt5, @NativeType("ALenum") int paramInt6, @NativeType("ALvoid const *") DoubleBuffer paramDoubleBuffer) {
/* 159 */     nalBufferSamplesSOFT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, MemoryUtil.memAddress(paramDoubleBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalBufferSubSamplesSOFT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong) {
/* 166 */     long l = (AL.getICD()).alBufferSubSamplesSOFT;
/* 167 */     if (Checks.CHECKS) {
/* 168 */       Checks.check(l);
/*     */     }
/* 170 */     JNI.invokePV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void alBufferSubSamplesSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALsizei") int paramInt2, @NativeType("ALsizei") int paramInt3, @NativeType("ALenum") int paramInt4, @NativeType("ALenum") int paramInt5, @NativeType("ALvoid const *") ByteBuffer paramByteBuffer) {
/* 178 */     nalBufferSubSamplesSOFT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void alBufferSubSamplesSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALsizei") int paramInt2, @NativeType("ALsizei") int paramInt3, @NativeType("ALenum") int paramInt4, @NativeType("ALenum") int paramInt5, @NativeType("ALvoid const *") ShortBuffer paramShortBuffer) {
/* 186 */     nalBufferSubSamplesSOFT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, MemoryUtil.memAddress(paramShortBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void alBufferSubSamplesSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALsizei") int paramInt2, @NativeType("ALsizei") int paramInt3, @NativeType("ALenum") int paramInt4, @NativeType("ALenum") int paramInt5, @NativeType("ALvoid const *") IntBuffer paramIntBuffer) {
/* 194 */     nalBufferSubSamplesSOFT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void alBufferSubSamplesSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALsizei") int paramInt2, @NativeType("ALsizei") int paramInt3, @NativeType("ALenum") int paramInt4, @NativeType("ALenum") int paramInt5, @NativeType("ALvoid const *") FloatBuffer paramFloatBuffer) {
/* 202 */     nalBufferSubSamplesSOFT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, MemoryUtil.memAddress(paramFloatBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void alBufferSubSamplesSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALsizei") int paramInt2, @NativeType("ALsizei") int paramInt3, @NativeType("ALenum") int paramInt4, @NativeType("ALenum") int paramInt5, @NativeType("ALvoid const *") DoubleBuffer paramDoubleBuffer) {
/* 210 */     nalBufferSubSamplesSOFT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, MemoryUtil.memAddress(paramDoubleBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetBufferSamplesSOFT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong) {
/* 217 */     long l = (AL.getICD()).alGetBufferSamplesSOFT;
/* 218 */     if (Checks.CHECKS) {
/* 219 */       Checks.check(l);
/*     */     }
/* 221 */     JNI.invokePV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void alGetBufferSamplesSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALsizei") int paramInt2, @NativeType("ALsizei") int paramInt3, @NativeType("ALenum") int paramInt4, @NativeType("ALenum") int paramInt5, @NativeType("ALvoid *") ByteBuffer paramByteBuffer) {
/* 229 */     nalGetBufferSamplesSOFT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void alGetBufferSamplesSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALsizei") int paramInt2, @NativeType("ALsizei") int paramInt3, @NativeType("ALenum") int paramInt4, @NativeType("ALenum") int paramInt5, @NativeType("ALvoid *") ShortBuffer paramShortBuffer) {
/* 237 */     nalGetBufferSamplesSOFT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, MemoryUtil.memAddress(paramShortBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void alGetBufferSamplesSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALsizei") int paramInt2, @NativeType("ALsizei") int paramInt3, @NativeType("ALenum") int paramInt4, @NativeType("ALenum") int paramInt5, @NativeType("ALvoid *") IntBuffer paramIntBuffer) {
/* 245 */     nalGetBufferSamplesSOFT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void alGetBufferSamplesSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALsizei") int paramInt2, @NativeType("ALsizei") int paramInt3, @NativeType("ALenum") int paramInt4, @NativeType("ALenum") int paramInt5, @NativeType("ALvoid *") FloatBuffer paramFloatBuffer) {
/* 253 */     nalGetBufferSamplesSOFT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, MemoryUtil.memAddress(paramFloatBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void alGetBufferSamplesSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALsizei") int paramInt2, @NativeType("ALsizei") int paramInt3, @NativeType("ALenum") int paramInt4, @NativeType("ALenum") int paramInt5, @NativeType("ALvoid *") DoubleBuffer paramDoubleBuffer) {
/* 261 */     nalGetBufferSamplesSOFT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, MemoryUtil.memAddress(paramDoubleBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALboolean")
/*     */   public static boolean alIsBufferFormatSupportedSOFT(@NativeType("ALenum") int paramInt) {
/* 268 */     long l = (AL.getICD()).alIsBufferFormatSupportedSOFT;
/* 269 */     if (Checks.CHECKS) {
/* 270 */       Checks.check(l);
/*     */     }
/* 272 */     return JNI.invokeZ(paramInt, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alBufferSamplesSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALuint") int paramInt2, @NativeType("ALenum") int paramInt3, @NativeType("ALsizei") int paramInt4, @NativeType("ALenum") int paramInt5, @NativeType("ALenum") int paramInt6, @NativeType("ALvoid const *") short[] paramArrayOfshort) {
/* 277 */     long l = (AL.getICD()).alBufferSamplesSOFT;
/* 278 */     if (Checks.CHECKS) {
/* 279 */       Checks.check(l);
/*     */     }
/* 281 */     JNI.invokePV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alBufferSamplesSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALuint") int paramInt2, @NativeType("ALenum") int paramInt3, @NativeType("ALsizei") int paramInt4, @NativeType("ALenum") int paramInt5, @NativeType("ALenum") int paramInt6, @NativeType("ALvoid const *") int[] paramArrayOfint) {
/* 286 */     long l = (AL.getICD()).alBufferSamplesSOFT;
/* 287 */     if (Checks.CHECKS) {
/* 288 */       Checks.check(l);
/*     */     }
/* 290 */     JNI.invokePV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alBufferSamplesSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALuint") int paramInt2, @NativeType("ALenum") int paramInt3, @NativeType("ALsizei") int paramInt4, @NativeType("ALenum") int paramInt5, @NativeType("ALenum") int paramInt6, @NativeType("ALvoid const *") float[] paramArrayOffloat) {
/* 295 */     long l = (AL.getICD()).alBufferSamplesSOFT;
/* 296 */     if (Checks.CHECKS) {
/* 297 */       Checks.check(l);
/*     */     }
/* 299 */     JNI.invokePV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOffloat, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alBufferSamplesSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALuint") int paramInt2, @NativeType("ALenum") int paramInt3, @NativeType("ALsizei") int paramInt4, @NativeType("ALenum") int paramInt5, @NativeType("ALenum") int paramInt6, @NativeType("ALvoid const *") double[] paramArrayOfdouble) {
/* 304 */     long l = (AL.getICD()).alBufferSamplesSOFT;
/* 305 */     if (Checks.CHECKS) {
/* 306 */       Checks.check(l);
/*     */     }
/* 308 */     JNI.invokePV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOfdouble, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alBufferSubSamplesSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALsizei") int paramInt2, @NativeType("ALsizei") int paramInt3, @NativeType("ALenum") int paramInt4, @NativeType("ALenum") int paramInt5, @NativeType("ALvoid const *") short[] paramArrayOfshort) {
/* 313 */     long l = (AL.getICD()).alBufferSubSamplesSOFT;
/* 314 */     if (Checks.CHECKS) {
/* 315 */       Checks.check(l);
/*     */     }
/* 317 */     JNI.invokePV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alBufferSubSamplesSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALsizei") int paramInt2, @NativeType("ALsizei") int paramInt3, @NativeType("ALenum") int paramInt4, @NativeType("ALenum") int paramInt5, @NativeType("ALvoid const *") int[] paramArrayOfint) {
/* 322 */     long l = (AL.getICD()).alBufferSubSamplesSOFT;
/* 323 */     if (Checks.CHECKS) {
/* 324 */       Checks.check(l);
/*     */     }
/* 326 */     JNI.invokePV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alBufferSubSamplesSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALsizei") int paramInt2, @NativeType("ALsizei") int paramInt3, @NativeType("ALenum") int paramInt4, @NativeType("ALenum") int paramInt5, @NativeType("ALvoid const *") float[] paramArrayOffloat) {
/* 331 */     long l = (AL.getICD()).alBufferSubSamplesSOFT;
/* 332 */     if (Checks.CHECKS) {
/* 333 */       Checks.check(l);
/*     */     }
/* 335 */     JNI.invokePV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramArrayOffloat, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alBufferSubSamplesSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALsizei") int paramInt2, @NativeType("ALsizei") int paramInt3, @NativeType("ALenum") int paramInt4, @NativeType("ALenum") int paramInt5, @NativeType("ALvoid const *") double[] paramArrayOfdouble) {
/* 340 */     long l = (AL.getICD()).alBufferSubSamplesSOFT;
/* 341 */     if (Checks.CHECKS) {
/* 342 */       Checks.check(l);
/*     */     }
/* 344 */     JNI.invokePV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramArrayOfdouble, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alGetBufferSamplesSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALsizei") int paramInt2, @NativeType("ALsizei") int paramInt3, @NativeType("ALenum") int paramInt4, @NativeType("ALenum") int paramInt5, @NativeType("ALvoid *") short[] paramArrayOfshort) {
/* 349 */     long l = (AL.getICD()).alGetBufferSamplesSOFT;
/* 350 */     if (Checks.CHECKS) {
/* 351 */       Checks.check(l);
/*     */     }
/* 353 */     JNI.invokePV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alGetBufferSamplesSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALsizei") int paramInt2, @NativeType("ALsizei") int paramInt3, @NativeType("ALenum") int paramInt4, @NativeType("ALenum") int paramInt5, @NativeType("ALvoid *") int[] paramArrayOfint) {
/* 358 */     long l = (AL.getICD()).alGetBufferSamplesSOFT;
/* 359 */     if (Checks.CHECKS) {
/* 360 */       Checks.check(l);
/*     */     }
/* 362 */     JNI.invokePV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alGetBufferSamplesSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALsizei") int paramInt2, @NativeType("ALsizei") int paramInt3, @NativeType("ALenum") int paramInt4, @NativeType("ALenum") int paramInt5, @NativeType("ALvoid *") float[] paramArrayOffloat) {
/* 367 */     long l = (AL.getICD()).alGetBufferSamplesSOFT;
/* 368 */     if (Checks.CHECKS) {
/* 369 */       Checks.check(l);
/*     */     }
/* 371 */     JNI.invokePV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramArrayOffloat, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alGetBufferSamplesSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALsizei") int paramInt2, @NativeType("ALsizei") int paramInt3, @NativeType("ALenum") int paramInt4, @NativeType("ALenum") int paramInt5, @NativeType("ALvoid *") double[] paramArrayOfdouble) {
/* 376 */     long l = (AL.getICD()).alGetBufferSamplesSOFT;
/* 377 */     if (Checks.CHECKS) {
/* 378 */       Checks.check(l);
/*     */     }
/* 380 */     JNI.invokePV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramArrayOfdouble, l);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\openal\SOFTBufferSamples.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */