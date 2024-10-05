/*     */ package org.lwjgl.openal;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
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
/*     */ public class ALC10
/*     */ {
/*     */   public static final int ALC_INVALID = -1;
/*     */   public static final int ALC_FALSE = 0;
/*     */   public static final int ALC_TRUE = 1;
/*     */   public static final int ALC_FREQUENCY = 4103;
/*     */   public static final int ALC_REFRESH = 4104;
/*     */   public static final int ALC_SYNC = 4105;
/*     */   public static final int ALC_NO_ERROR = 0;
/*     */   public static final int ALC_INVALID_DEVICE = 40961;
/*     */   public static final int ALC_INVALID_CONTEXT = 40962;
/*     */   public static final int ALC_INVALID_ENUM = 40963;
/*     */   public static final int ALC_INVALID_VALUE = 40964;
/*     */   public static final int ALC_OUT_OF_MEMORY = 40965;
/*     */   public static final int ALC_DEFAULT_DEVICE_SPECIFIER = 4100;
/*     */   public static final int ALC_DEVICE_SPECIFIER = 4101;
/*     */   public static final int ALC_EXTENSIONS = 4102;
/*     */   public static final int ALC_MAJOR_VERSION = 4096;
/*     */   public static final int ALC_MINOR_VERSION = 4097;
/*     */   public static final int ALC_ATTRIBUTES_SIZE = 4098;
/*     */   public static final int ALC_ALL_ATTRIBUTES = 4099;
/*     */   
/*     */   protected ALC10() {
/*  57 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nalcOpenDevice(long paramLong) {
/*  64 */     long l = (ALC.getICD()).alcOpenDevice;
/*  65 */     return JNI.invokePP(paramLong, l);
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
/*     */   @NativeType("ALCdevice *")
/*     */   public static long alcOpenDevice(@NativeType("ALCchar const *") ByteBuffer paramByteBuffer) {
/*  78 */     if (Checks.CHECKS) {
/*  79 */       Checks.checkNT1Safe(paramByteBuffer);
/*     */     }
/*  81 */     return nalcOpenDevice(MemoryUtil.memAddressSafe(paramByteBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALCdevice *")
/*     */   public static long alcOpenDevice(@NativeType("ALCchar const *") CharSequence paramCharSequence) {
/*     */     MemoryStack memoryStack;
/*  94 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/*  96 */       memoryStack.nUTF8Safe(paramCharSequence, true);
/*     */       long l;
/*  98 */       return nalcOpenDevice(l = (paramCharSequence == null) ? 0L : memoryStack.getPointerAddress());
/*     */     } finally {
/* 100 */       memoryStack.setPointer(i);
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
/*     */ 
/*     */   
/*     */   @NativeType("ALCboolean")
/*     */   public static boolean alcCloseDevice(@NativeType("ALCdevice const *") long paramLong) {
/* 116 */     long l = (ALC.getICD()).alcCloseDevice;
/* 117 */     if (Checks.CHECKS) {
/* 118 */       Checks.check(paramLong);
/*     */     }
/* 120 */     return JNI.invokePZ(paramLong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nalcCreateContext(long paramLong1, long paramLong2) {
/* 127 */     long l = (ALC.getICD()).alcCreateContext;
/* 128 */     if (Checks.CHECKS) {
/* 129 */       Checks.check(paramLong1);
/*     */     }
/* 131 */     return JNI.invokePPP(paramLong1, paramLong2, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALCcontext *")
/*     */   public static long alcCreateContext(@NativeType("ALCdevice const *") long paramLong, @NativeType("ALCint const *") IntBuffer paramIntBuffer) {
/* 142 */     if (Checks.CHECKS) {
/* 143 */       Checks.checkNTSafe(paramIntBuffer);
/*     */     }
/* 145 */     return nalcCreateContext(paramLong, MemoryUtil.memAddressSafe(paramIntBuffer));
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
/*     */   @NativeType("ALCboolean")
/*     */   public static boolean alcMakeContextCurrent(@NativeType("ALCcontext *") long paramLong) {
/* 163 */     long l = (ALC.getICD()).alcMakeContextCurrent;
/* 164 */     return JNI.invokePZ(paramLong, l);
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
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcProcessContext(@NativeType("ALCcontext *") long paramLong) {
/* 181 */     long l = (ALC.getICD()).alcProcessContext;
/* 182 */     if (Checks.CHECKS) {
/* 183 */       Checks.check(paramLong);
/*     */     }
/* 185 */     JNI.invokePV(paramLong, l);
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
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcSuspendContext(@NativeType("ALCcontext *") long paramLong) {
/* 200 */     long l = (ALC.getICD()).alcSuspendContext;
/* 201 */     if (Checks.CHECKS) {
/* 202 */       Checks.check(paramLong);
/*     */     }
/* 204 */     JNI.invokePV(paramLong, l);
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
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcDestroyContext(@NativeType("ALCcontext *") long paramLong) {
/* 220 */     long l = (ALC.getICD()).alcDestroyContext;
/* 221 */     if (Checks.CHECKS) {
/* 222 */       Checks.check(paramLong);
/*     */     }
/* 224 */     JNI.invokePV(paramLong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALCcontext *")
/*     */   public static long alcGetCurrentContext() {
/*     */     long l;
/* 233 */     return JNI.invokeP(l = (ALC.getICD()).alcGetCurrentContext);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALCdevice *")
/*     */   public static long alcGetContextsDevice(@NativeType("ALCcontext *") long paramLong) {
/* 245 */     long l = (ALC.getICD()).alcGetContextsDevice;
/* 246 */     if (Checks.CHECKS) {
/* 247 */       Checks.check(paramLong);
/*     */     }
/* 249 */     return JNI.invokePP(paramLong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean nalcIsExtensionPresent(long paramLong1, long paramLong2) {
/* 256 */     long l = (ALC.getICD()).alcIsExtensionPresent;
/* 257 */     return JNI.invokePPZ(paramLong1, paramLong2, l);
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
/*     */   @NativeType("ALCboolean")
/*     */   public static boolean alcIsExtensionPresent(@NativeType("ALCdevice const *") long paramLong, @NativeType("ALCchar const *") ByteBuffer paramByteBuffer) {
/* 271 */     if (Checks.CHECKS) {
/* 272 */       Checks.checkNT1(paramByteBuffer);
/*     */     }
/* 274 */     return nalcIsExtensionPresent(paramLong, MemoryUtil.memAddress(paramByteBuffer));
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
/*     */   @NativeType("ALCboolean")
/*     */   public static boolean alcIsExtensionPresent(@NativeType("ALCdevice const *") long paramLong, @NativeType("ALCchar const *") CharSequence paramCharSequence) {
/*     */     MemoryStack memoryStack;
/* 288 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 290 */       memoryStack.nASCII(paramCharSequence, true);
/* 291 */       long l = memoryStack.getPointerAddress();
/* 292 */       return nalcIsExtensionPresent(paramLong, l);
/*     */     } finally {
/* 294 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nalcGetProcAddress(long paramLong1, long paramLong2) {
/* 302 */     long l = (ALC.getICD()).alcGetProcAddress;
/* 303 */     return JNI.invokePPP(paramLong1, paramLong2, l);
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
/*     */   @NativeType("void *")
/*     */   public static long alcGetProcAddress(@NativeType("ALCdevice const *") long paramLong, @NativeType("ALchar const *") ByteBuffer paramByteBuffer) {
/* 320 */     if (Checks.CHECKS) {
/* 321 */       Checks.checkNT1(paramByteBuffer);
/*     */     }
/* 323 */     return nalcGetProcAddress(paramLong, MemoryUtil.memAddress(paramByteBuffer));
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
/*     */   @NativeType("void *")
/*     */   public static long alcGetProcAddress(@NativeType("ALCdevice const *") long paramLong, @NativeType("ALchar const *") CharSequence paramCharSequence) {
/*     */     MemoryStack memoryStack;
/* 340 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 342 */       memoryStack.nASCII(paramCharSequence, true);
/* 343 */       long l = memoryStack.getPointerAddress();
/* 344 */       return nalcGetProcAddress(paramLong, l);
/*     */     } finally {
/* 346 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nalcGetEnumValue(long paramLong1, long paramLong2) {
/* 354 */     long l = (ALC.getICD()).alcGetEnumValue;
/* 355 */     return JNI.invokePPI(paramLong1, paramLong2, l);
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
/*     */   @NativeType("ALCenum")
/*     */   public static int alcGetEnumValue(@NativeType("ALCdevice const *") long paramLong, @NativeType("ALCchar const *") ByteBuffer paramByteBuffer) {
/* 369 */     if (Checks.CHECKS) {
/* 370 */       Checks.checkNT1(paramByteBuffer);
/*     */     }
/* 372 */     return nalcGetEnumValue(paramLong, MemoryUtil.memAddress(paramByteBuffer));
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
/*     */   @NativeType("ALCenum")
/*     */   public static int alcGetEnumValue(@NativeType("ALCdevice const *") long paramLong, @NativeType("ALCchar const *") CharSequence paramCharSequence) {
/*     */     MemoryStack memoryStack;
/* 386 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 388 */       memoryStack.nASCII(paramCharSequence, true);
/* 389 */       long l = memoryStack.getPointerAddress();
/* 390 */       return nalcGetEnumValue(paramLong, l);
/*     */     } finally {
/* 392 */       memoryStack.setPointer(i);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALCenum")
/*     */   public static int alcGetError(@NativeType("ALCdevice *") long paramLong) {
/* 410 */     long l = (ALC.getICD()).alcGetError;
/* 411 */     return JNI.invokePI(paramLong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nalcGetString(long paramLong, int paramInt) {
/* 418 */     long l = (ALC.getICD()).alcGetString;
/* 419 */     return JNI.invokePP(paramLong, paramInt, l);
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
/*     */   @NativeType("ALCchar const *")
/*     */   public static String alcGetString(@NativeType("ALCdevice *") long paramLong, @NativeType("ALCenum") int paramInt) {
/*     */     long l;
/* 434 */     return MemoryUtil.memUTF8Safe(l = nalcGetString(paramLong, paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalcGetIntegerv(long paramLong1, int paramInt1, int paramInt2, long paramLong2) {
/* 445 */     long l = (ALC.getICD()).alcGetIntegerv;
/* 446 */     JNI.invokePPV(paramLong1, paramInt1, paramInt2, paramLong2, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcGetIntegerv(@NativeType("ALCdevice *") long paramLong, @NativeType("ALCenum") int paramInt, @NativeType("ALCint *") IntBuffer paramIntBuffer) {
/* 458 */     nalcGetIntegerv(paramLong, paramInt, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static int alcGetInteger(@NativeType("ALCdevice *") long paramLong, @NativeType("ALCenum") int paramInt) {
/*     */     MemoryStack memoryStack;
/* 469 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 471 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 472 */       nalcGetIntegerv(paramLong, paramInt, 1, MemoryUtil.memAddress(intBuffer));
/* 473 */       return intBuffer.get(0);
/*     */     } finally {
/* 475 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCcontext *")
/*     */   public static long alcCreateContext(@NativeType("ALCdevice const *") long paramLong, @NativeType("ALCint const *") int[] paramArrayOfint) {
/* 482 */     long l = (ALC.getICD()).alcCreateContext;
/* 483 */     if (Checks.CHECKS) {
/* 484 */       Checks.check(paramLong);
/* 485 */       Checks.checkNTSafe(paramArrayOfint);
/*     */     } 
/* 487 */     return JNI.invokePPP(paramLong, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcGetIntegerv(@NativeType("ALCdevice *") long paramLong, @NativeType("ALCenum") int paramInt, @NativeType("ALCint *") int[] paramArrayOfint) {
/* 493 */     long l = (ALC.getICD()).alcGetIntegerv;
/* 494 */     JNI.invokePPV(paramLong, paramInt, paramArrayOfint.length, paramArrayOfint, l);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\openal\ALC10.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */