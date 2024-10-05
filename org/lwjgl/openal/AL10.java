/*      */ package org.lwjgl.openal;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.DoubleBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.JNI;
/*      */ import org.lwjgl.system.MemoryStack;
/*      */ import org.lwjgl.system.MemoryUtil;
/*      */ import org.lwjgl.system.NativeType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class AL10
/*      */ {
/*      */   public static final int AL_INVALID = -1;
/*      */   public static final int AL_NONE = 0;
/*      */   public static final int AL_FALSE = 0;
/*      */   public static final int AL_TRUE = 1;
/*      */   public static final int AL_NO_ERROR = 0;
/*      */   public static final int AL_INVALID_NAME = 40961;
/*      */   public static final int AL_INVALID_ENUM = 40962;
/*      */   public static final int AL_INVALID_VALUE = 40963;
/*      */   public static final int AL_INVALID_OPERATION = 40964;
/*      */   public static final int AL_OUT_OF_MEMORY = 40965;
/*      */   public static final int AL_DOPPLER_FACTOR = 49152;
/*      */   public static final int AL_DISTANCE_MODEL = 53248;
/*      */   public static final int AL_VENDOR = 45057;
/*      */   public static final int AL_VERSION = 45058;
/*      */   public static final int AL_RENDERER = 45059;
/*      */   public static final int AL_EXTENSIONS = 45060;
/*      */   public static final int AL_INVERSE_DISTANCE = 53249;
/*      */   public static final int AL_INVERSE_DISTANCE_CLAMPED = 53250;
/*      */   public static final int AL_SOURCE_ABSOLUTE = 513;
/*      */   public static final int AL_SOURCE_RELATIVE = 514;
/*      */   public static final int AL_POSITION = 4100;
/*      */   public static final int AL_VELOCITY = 4102;
/*      */   public static final int AL_GAIN = 4106;
/*      */   public static final int AL_CONE_INNER_ANGLE = 4097;
/*      */   public static final int AL_CONE_OUTER_ANGLE = 4098;
/*      */   public static final int AL_PITCH = 4099;
/*      */   public static final int AL_DIRECTION = 4101;
/*      */   public static final int AL_LOOPING = 4103;
/*      */   public static final int AL_BUFFER = 4105;
/*      */   public static final int AL_SOURCE_STATE = 4112;
/*      */   public static final int AL_CONE_OUTER_GAIN = 4130;
/*      */   public static final int AL_SOURCE_TYPE = 4135;
/*      */   public static final int AL_INITIAL = 4113;
/*      */   public static final int AL_PLAYING = 4114;
/*      */   public static final int AL_PAUSED = 4115;
/*      */   public static final int AL_STOPPED = 4116;
/*      */   public static final int AL_ORIENTATION = 4111;
/*      */   public static final int AL_BUFFERS_QUEUED = 4117;
/*      */   public static final int AL_BUFFERS_PROCESSED = 4118;
/*      */   public static final int AL_MIN_GAIN = 4109;
/*      */   public static final int AL_MAX_GAIN = 4110;
/*      */   public static final int AL_REFERENCE_DISTANCE = 4128;
/*      */   public static final int AL_ROLLOFF_FACTOR = 4129;
/*      */   public static final int AL_MAX_DISTANCE = 4131;
/*      */   public static final int AL_FREQUENCY = 8193;
/*      */   public static final int AL_BITS = 8194;
/*      */   public static final int AL_CHANNELS = 8195;
/*      */   public static final int AL_SIZE = 8196;
/*      */   public static final int AL_FORMAT_MONO8 = 4352;
/*      */   public static final int AL_FORMAT_MONO16 = 4353;
/*      */   public static final int AL_FORMAT_STEREO8 = 4354;
/*      */   public static final int AL_FORMAT_STEREO16 = 4355;
/*      */   public static final int AL_UNUSED = 8208;
/*      */   public static final int AL_PENDING = 8209;
/*      */   public static final int AL_PROCESSED = 8210;
/*      */   
/*      */   protected AL10() {
/*  125 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALenum")
/*      */   public static int alGetError() {
/*      */     long l;
/*  144 */     return JNI.invokeI(l = (AL.getICD()).alGetError);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alEnable(@NativeType("ALenum") int paramInt) {
/*  156 */     long l = (AL.getICD()).alEnable;
/*  157 */     JNI.invokeV(paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDisable(@NativeType("ALenum") int paramInt) {
/*  169 */     long l = (AL.getICD()).alDisable;
/*  170 */     JNI.invokeV(paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALboolean")
/*      */   public static boolean alIsEnabled(@NativeType("ALenum") int paramInt) {
/*  182 */     long l = (AL.getICD()).alIsEnabled;
/*  183 */     return JNI.invokeZ(paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALboolean")
/*      */   public static boolean alGetBoolean(@NativeType("ALenum") int paramInt) {
/*  195 */     long l = (AL.getICD()).alGetBoolean;
/*  196 */     return JNI.invokeZ(paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALint")
/*      */   public static int alGetInteger(@NativeType("ALenum") int paramInt) {
/*  208 */     long l = (AL.getICD()).alGetInteger;
/*  209 */     return JNI.invokeI(paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALfloat")
/*      */   public static float alGetFloat(@NativeType("ALenum") int paramInt) {
/*  221 */     long l = (AL.getICD()).alGetFloat;
/*  222 */     return JNI.invokeF(paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALdouble")
/*      */   public static double alGetDouble(@NativeType("ALenum") int paramInt) {
/*  234 */     long l = (AL.getICD()).alGetDouble;
/*  235 */     return JNI.invokeD(paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetBooleanv(int paramInt, long paramLong) {
/*  242 */     long l = (AL.getICD()).alGetBooleanv;
/*  243 */     JNI.invokePV(paramInt, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetBooleanv(@NativeType("ALenum") int paramInt, @NativeType("ALboolean *") ByteBuffer paramByteBuffer) {
/*  254 */     if (Checks.CHECKS) {
/*  255 */       Checks.check(paramByteBuffer, 1);
/*      */     }
/*  257 */     nalGetBooleanv(paramInt, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetIntegerv(int paramInt, long paramLong) {
/*  264 */     long l = (AL.getICD()).alGetIntegerv;
/*  265 */     JNI.invokePV(paramInt, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetIntegerv(@NativeType("ALenum") int paramInt, @NativeType("ALint *") IntBuffer paramIntBuffer) {
/*  276 */     if (Checks.CHECKS) {
/*  277 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  279 */     nalGetIntegerv(paramInt, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetFloatv(int paramInt, long paramLong) {
/*  286 */     long l = (AL.getICD()).alGetFloatv;
/*  287 */     JNI.invokePV(paramInt, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetFloatv(@NativeType("ALenum") int paramInt, @NativeType("ALfloat *") FloatBuffer paramFloatBuffer) {
/*  298 */     if (Checks.CHECKS) {
/*  299 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/*  301 */     nalGetFloatv(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetDoublev(int paramInt, long paramLong) {
/*  308 */     long l = (AL.getICD()).alGetDoublev;
/*  309 */     JNI.invokePV(paramInt, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetDoublev(@NativeType("ALenum") int paramInt, @NativeType("ALdouble *") DoubleBuffer paramDoubleBuffer) {
/*  320 */     if (Checks.CHECKS) {
/*  321 */       Checks.check(paramDoubleBuffer, 1);
/*      */     }
/*  323 */     nalGetDoublev(paramInt, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nalGetString(int paramInt) {
/*  330 */     long l = (AL.getICD()).alGetString;
/*  331 */     return JNI.invokeP(paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALchar const *")
/*      */   public static String alGetString(@NativeType("ALenum") int paramInt) {
/*      */     long l;
/*  343 */     return MemoryUtil.memUTF8Safe(l = nalGetString(paramInt));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDistanceModel(@NativeType("ALenum") int paramInt) {
/*  365 */     long l = (AL.getICD()).alDistanceModel;
/*  366 */     JNI.invokeV(paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDopplerFactor(@NativeType("ALfloat") float paramFloat) {
/*  413 */     long l = (AL.getICD()).alDopplerFactor;
/*  414 */     JNI.invokeV(paramFloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDopplerVelocity(@NativeType("ALfloat") float paramFloat) {
/*  439 */     long l = (AL.getICD()).alDopplerVelocity;
/*  440 */     JNI.invokeV(paramFloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alListenerf(@NativeType("ALenum") int paramInt, @NativeType("ALfloat") float paramFloat) {
/*  453 */     long l = (AL.getICD()).alListenerf;
/*  454 */     JNI.invokeV(paramInt, paramFloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alListeneri(@NativeType("ALenum") int paramInt1, @NativeType("ALint") int paramInt2) {
/*  467 */     long l = (AL.getICD()).alListeneri;
/*  468 */     JNI.invokeV(paramInt1, paramInt2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alListener3f(@NativeType("ALenum") int paramInt, @NativeType("ALfloat") float paramFloat1, @NativeType("ALfloat") float paramFloat2, @NativeType("ALfloat") float paramFloat3) {
/*  483 */     long l = (AL.getICD()).alListener3f;
/*  484 */     JNI.invokeV(paramInt, paramFloat1, paramFloat2, paramFloat3, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalListenerfv(int paramInt, long paramLong) {
/*  491 */     long l = (AL.getICD()).alListenerfv;
/*  492 */     JNI.invokePV(paramInt, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alListenerfv(@NativeType("ALenum") int paramInt, @NativeType("ALfloat const *") FloatBuffer paramFloatBuffer) {
/*  503 */     if (Checks.CHECKS) {
/*  504 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/*  506 */     nalListenerfv(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetListenerf(int paramInt, long paramLong) {
/*  513 */     long l = (AL.getICD()).alGetListenerf;
/*  514 */     JNI.invokePV(paramInt, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetListenerf(@NativeType("ALenum") int paramInt, @NativeType("ALfloat *") FloatBuffer paramFloatBuffer) {
/*  525 */     if (Checks.CHECKS) {
/*  526 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/*  528 */     nalGetListenerf(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static float alGetListenerf(@NativeType("ALenum") int paramInt) {
/*      */     MemoryStack memoryStack;
/*  538 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  540 */       FloatBuffer floatBuffer = memoryStack.callocFloat(1);
/*  541 */       nalGetListenerf(paramInt, MemoryUtil.memAddress(floatBuffer));
/*  542 */       return floatBuffer.get(0);
/*      */     } finally {
/*  544 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetListeneri(int paramInt, long paramLong) {
/*  552 */     long l = (AL.getICD()).alGetListeneri;
/*  553 */     JNI.invokePV(paramInt, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetListeneri(@NativeType("ALenum") int paramInt, @NativeType("ALint *") IntBuffer paramIntBuffer) {
/*  564 */     if (Checks.CHECKS) {
/*  565 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  567 */     nalGetListeneri(paramInt, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static int alGetListeneri(@NativeType("ALenum") int paramInt) {
/*      */     MemoryStack memoryStack;
/*  577 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  579 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  580 */       nalGetListeneri(paramInt, MemoryUtil.memAddress(intBuffer));
/*  581 */       paramInt = intBuffer.get(0); return paramInt;
/*      */     } finally {
/*  583 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetListener3f(int paramInt, long paramLong1, long paramLong2, long paramLong3) {
/*  591 */     long l = (AL.getICD()).alGetListener3f;
/*  592 */     JNI.invokePPPV(paramInt, paramLong1, paramLong2, paramLong3, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetListener3f(@NativeType("ALenum") int paramInt, @NativeType("ALfloat *") FloatBuffer paramFloatBuffer1, @NativeType("ALfloat *") FloatBuffer paramFloatBuffer2, @NativeType("ALfloat *") FloatBuffer paramFloatBuffer3) {
/*  605 */     if (Checks.CHECKS) {
/*  606 */       Checks.check(paramFloatBuffer1, 1);
/*  607 */       Checks.check(paramFloatBuffer2, 1);
/*  608 */       Checks.check(paramFloatBuffer3, 1);
/*      */     } 
/*  610 */     nalGetListener3f(paramInt, MemoryUtil.memAddress(paramFloatBuffer1), MemoryUtil.memAddress(paramFloatBuffer2), MemoryUtil.memAddress(paramFloatBuffer3));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetListenerfv(int paramInt, long paramLong) {
/*  617 */     long l = (AL.getICD()).alGetListenerfv;
/*  618 */     JNI.invokePV(paramInt, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetListenerfv(@NativeType("ALenum") int paramInt, @NativeType("ALfloat *") FloatBuffer paramFloatBuffer) {
/*  629 */     if (Checks.CHECKS) {
/*  630 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/*  632 */     nalGetListenerfv(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGenSources(int paramInt, long paramLong) {
/*  643 */     long l = (AL.getICD()).alGenSources;
/*  644 */     JNI.invokePV(paramInt, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGenSources(@NativeType("ALuint *") IntBuffer paramIntBuffer) {
/*  654 */     nalGenSources(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static int alGenSources() {
/*      */     MemoryStack memoryStack;
/*  660 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  662 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  663 */       nalGenSources(1, MemoryUtil.memAddress(intBuffer));
/*  664 */       return intBuffer.get(0);
/*      */     } finally {
/*  666 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalDeleteSources(int paramInt, long paramLong) {
/*  678 */     long l = (AL.getICD()).alDeleteSources;
/*  679 */     JNI.invokePV(paramInt, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteSources(@NativeType("ALuint *") IntBuffer paramIntBuffer) {
/*  689 */     nalDeleteSources(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteSources(@NativeType("ALuint *") int paramInt) {
/*      */     MemoryStack memoryStack;
/*  695 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  697 */       IntBuffer intBuffer = memoryStack.ints(paramInt);
/*  698 */       nalDeleteSources(1, MemoryUtil.memAddress(intBuffer)); return;
/*      */     } finally {
/*  700 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALboolean")
/*      */   public static boolean alIsSource(@NativeType("ALuint") int paramInt) {
/*  713 */     long l = (AL.getICD()).alIsSource;
/*  714 */     return JNI.invokeZ(paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourcef(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALfloat") float paramFloat) {
/*  728 */     long l = (AL.getICD()).alSourcef;
/*  729 */     JNI.invokeV(paramInt1, paramInt2, paramFloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSource3f(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALfloat") float paramFloat1, @NativeType("ALfloat") float paramFloat2, @NativeType("ALfloat") float paramFloat3) {
/*  745 */     long l = (AL.getICD()).alSource3f;
/*  746 */     JNI.invokeV(paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalSourcefv(int paramInt1, int paramInt2, long paramLong) {
/*  753 */     long l = (AL.getICD()).alSourcefv;
/*  754 */     JNI.invokePV(paramInt1, paramInt2, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourcefv(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALfloat const *") FloatBuffer paramFloatBuffer) {
/*  766 */     if (Checks.CHECKS) {
/*  767 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/*  769 */     nalSourcefv(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourcei(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint") int paramInt3) {
/*  783 */     long l = (AL.getICD()).alSourcei;
/*  784 */     JNI.invokeV(paramInt1, paramInt2, paramInt3, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetSourcef(int paramInt1, int paramInt2, long paramLong) {
/*  791 */     long l = (AL.getICD()).alGetSourcef;
/*  792 */     JNI.invokePV(paramInt1, paramInt2, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetSourcef(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALfloat *") FloatBuffer paramFloatBuffer) {
/*  804 */     if (Checks.CHECKS) {
/*  805 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/*  807 */     nalGetSourcef(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static float alGetSourcef(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/*  818 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  820 */       FloatBuffer floatBuffer = memoryStack.callocFloat(1);
/*  821 */       nalGetSourcef(paramInt1, paramInt2, MemoryUtil.memAddress(floatBuffer));
/*  822 */       return floatBuffer.get(0);
/*      */     } finally {
/*  824 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetSource3f(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3) {
/*  832 */     long l = (AL.getICD()).alGetSource3f;
/*  833 */     JNI.invokePPPV(paramInt1, paramInt2, paramLong1, paramLong2, paramLong3, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetSource3f(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALfloat *") FloatBuffer paramFloatBuffer1, @NativeType("ALfloat *") FloatBuffer paramFloatBuffer2, @NativeType("ALfloat *") FloatBuffer paramFloatBuffer3) {
/*  847 */     if (Checks.CHECKS) {
/*  848 */       Checks.check(paramFloatBuffer1, 1);
/*  849 */       Checks.check(paramFloatBuffer2, 1);
/*  850 */       Checks.check(paramFloatBuffer3, 1);
/*      */     } 
/*  852 */     nalGetSource3f(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer1), MemoryUtil.memAddress(paramFloatBuffer2), MemoryUtil.memAddress(paramFloatBuffer3));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetSourcefv(int paramInt1, int paramInt2, long paramLong) {
/*  859 */     long l = (AL.getICD()).alGetSourcefv;
/*  860 */     JNI.invokePV(paramInt1, paramInt2, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetSourcefv(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALfloat *") FloatBuffer paramFloatBuffer) {
/*  872 */     if (Checks.CHECKS) {
/*  873 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/*  875 */     nalGetSourcefv(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetSourcei(int paramInt1, int paramInt2, long paramLong) {
/*  882 */     long l = (AL.getICD()).alGetSourcei;
/*  883 */     JNI.invokePV(paramInt1, paramInt2, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetSourcei(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint *") IntBuffer paramIntBuffer) {
/*  895 */     if (Checks.CHECKS) {
/*  896 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  898 */     nalGetSourcei(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static int alGetSourcei(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/*  909 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  911 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  912 */       nalGetSourcei(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/*  913 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/*  915 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetSourceiv(int paramInt1, int paramInt2, long paramLong) {
/*  923 */     long l = (AL.getICD()).alGetSourceiv;
/*  924 */     JNI.invokePV(paramInt1, paramInt2, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetSourceiv(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint *") IntBuffer paramIntBuffer) {
/*  936 */     if (Checks.CHECKS) {
/*  937 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  939 */     nalGetSourceiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalSourceQueueBuffers(int paramInt1, int paramInt2, long paramLong) {
/*  950 */     long l = (AL.getICD()).alSourceQueueBuffers;
/*  951 */     JNI.invokePV(paramInt1, paramInt2, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourceQueueBuffers(@NativeType("ALuint") int paramInt, @NativeType("ALuint *") IntBuffer paramIntBuffer) {
/*  966 */     nalSourceQueueBuffers(paramInt, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourceQueueBuffers(@NativeType("ALuint") int paramInt1, @NativeType("ALuint *") int paramInt2) {
/*      */     MemoryStack memoryStack;
/*  980 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  982 */       IntBuffer intBuffer = memoryStack.ints(paramInt2);
/*  983 */       nalSourceQueueBuffers(paramInt1, 1, MemoryUtil.memAddress(intBuffer)); return;
/*      */     } finally {
/*  985 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalSourceUnqueueBuffers(int paramInt1, int paramInt2, long paramLong) {
/*  997 */     long l = (AL.getICD()).alSourceUnqueueBuffers;
/*  998 */     JNI.invokePV(paramInt1, paramInt2, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourceUnqueueBuffers(@NativeType("ALuint") int paramInt, @NativeType("ALuint *") IntBuffer paramIntBuffer) {
/* 1014 */     nalSourceUnqueueBuffers(paramInt, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static int alSourceUnqueueBuffers(@NativeType("ALuint") int paramInt) {
/*      */     MemoryStack memoryStack;
/* 1029 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1031 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1032 */       nalSourceUnqueueBuffers(paramInt, 1, MemoryUtil.memAddress(intBuffer));
/* 1033 */       paramInt = intBuffer.get(0); return paramInt;
/*      */     } finally {
/* 1035 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourcePlay(@NativeType("ALuint") int paramInt) {
/* 1054 */     long l = (AL.getICD()).alSourcePlay;
/* 1055 */     JNI.invokeV(paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourcePause(@NativeType("ALuint") int paramInt) {
/* 1071 */     long l = (AL.getICD()).alSourcePause;
/* 1072 */     JNI.invokeV(paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourceStop(@NativeType("ALuint") int paramInt) {
/* 1088 */     long l = (AL.getICD()).alSourceStop;
/* 1089 */     JNI.invokeV(paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourceRewind(@NativeType("ALuint") int paramInt) {
/* 1106 */     long l = (AL.getICD()).alSourceRewind;
/* 1107 */     JNI.invokeV(paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalSourcePlayv(int paramInt, long paramLong) {
/* 1118 */     long l = (AL.getICD()).alSourcePlayv;
/* 1119 */     JNI.invokePV(paramInt, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourcePlayv(@NativeType("ALuint const *") IntBuffer paramIntBuffer) {
/* 1129 */     nalSourcePlayv(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalSourcePausev(int paramInt, long paramLong) {
/* 1140 */     long l = (AL.getICD()).alSourcePausev;
/* 1141 */     JNI.invokePV(paramInt, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourcePausev(@NativeType("ALuint const *") IntBuffer paramIntBuffer) {
/* 1151 */     nalSourcePausev(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalSourceStopv(int paramInt, long paramLong) {
/* 1162 */     long l = (AL.getICD()).alSourceStopv;
/* 1163 */     JNI.invokePV(paramInt, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourceStopv(@NativeType("ALuint const *") IntBuffer paramIntBuffer) {
/* 1173 */     nalSourceStopv(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalSourceRewindv(int paramInt, long paramLong) {
/* 1184 */     long l = (AL.getICD()).alSourceRewindv;
/* 1185 */     JNI.invokePV(paramInt, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourceRewindv(@NativeType("ALuint const *") IntBuffer paramIntBuffer) {
/* 1195 */     nalSourceRewindv(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGenBuffers(int paramInt, long paramLong) {
/* 1206 */     long l = (AL.getICD()).alGenBuffers;
/* 1207 */     JNI.invokePV(paramInt, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGenBuffers(@NativeType("ALuint *") IntBuffer paramIntBuffer) {
/* 1217 */     nalGenBuffers(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static int alGenBuffers() {
/*      */     MemoryStack memoryStack;
/* 1223 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1225 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1226 */       nalGenBuffers(1, MemoryUtil.memAddress(intBuffer));
/* 1227 */       return intBuffer.get(0);
/*      */     } finally {
/* 1229 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalDeleteBuffers(int paramInt, long paramLong) {
/* 1241 */     long l = (AL.getICD()).alDeleteBuffers;
/* 1242 */     JNI.invokePV(paramInt, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteBuffers(@NativeType("ALuint const *") IntBuffer paramIntBuffer) {
/* 1252 */     nalDeleteBuffers(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteBuffers(@NativeType("ALuint const *") int paramInt) {
/*      */     MemoryStack memoryStack;
/* 1258 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1260 */       IntBuffer intBuffer = memoryStack.ints(paramInt);
/* 1261 */       nalDeleteBuffers(1, MemoryUtil.memAddress(intBuffer)); return;
/*      */     } finally {
/* 1263 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALboolean")
/*      */   public static boolean alIsBuffer(@NativeType("ALuint") int paramInt) {
/* 1276 */     long l = (AL.getICD()).alIsBuffer;
/* 1277 */     return JNI.invokeZ(paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetBufferf(int paramInt1, int paramInt2, long paramLong) {
/* 1284 */     long l = (AL.getICD()).alGetBufferf;
/* 1285 */     JNI.invokePV(paramInt1, paramInt2, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetBufferf(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALfloat *") FloatBuffer paramFloatBuffer) {
/* 1297 */     if (Checks.CHECKS) {
/* 1298 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/* 1300 */     nalGetBufferf(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static float alGetBufferf(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1311 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1313 */       FloatBuffer floatBuffer = memoryStack.callocFloat(1);
/* 1314 */       nalGetBufferf(paramInt1, paramInt2, MemoryUtil.memAddress(floatBuffer));
/* 1315 */       return floatBuffer.get(0);
/*      */     } finally {
/* 1317 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetBufferi(int paramInt1, int paramInt2, long paramLong) {
/* 1325 */     long l = (AL.getICD()).alGetBufferi;
/* 1326 */     JNI.invokePV(paramInt1, paramInt2, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetBufferi(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint *") IntBuffer paramIntBuffer) {
/* 1338 */     if (Checks.CHECKS) {
/* 1339 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1341 */     nalGetBufferi(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static int alGetBufferi(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1352 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1354 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1355 */       nalGetBufferi(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 1356 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 1358 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalBufferData(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4) {
/* 1370 */     long l = (AL.getICD()).alBufferData;
/* 1371 */     JNI.invokePV(paramInt1, paramInt2, paramLong, paramInt3, paramInt4, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alBufferData(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALvoid const *") ByteBuffer paramByteBuffer, @NativeType("ALsizei") int paramInt3) {
/* 1397 */     nalBufferData(paramInt1, paramInt2, MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alBufferData(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALvoid const *") ShortBuffer paramShortBuffer, @NativeType("ALsizei") int paramInt3) {
/* 1423 */     nalBufferData(paramInt1, paramInt2, MemoryUtil.memAddress(paramShortBuffer), paramShortBuffer.remaining() << 1, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alBufferData(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALvoid const *") IntBuffer paramIntBuffer, @NativeType("ALsizei") int paramInt3) {
/* 1449 */     nalBufferData(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer), paramIntBuffer.remaining() << 2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alBufferData(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALvoid const *") FloatBuffer paramFloatBuffer, @NativeType("ALsizei") int paramInt3) {
/* 1475 */     nalBufferData(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer), paramFloatBuffer.remaining() << 2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nalGetEnumValue(long paramLong) {
/* 1482 */     long l = (AL.getICD()).alGetEnumValue;
/* 1483 */     return JNI.invokePI(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALuint")
/*      */   public static int alGetEnumValue(@NativeType("ALchar const *") ByteBuffer paramByteBuffer) {
/* 1493 */     if (Checks.CHECKS) {
/* 1494 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 1496 */     return nalGetEnumValue(MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALuint")
/*      */   public static int alGetEnumValue(@NativeType("ALchar const *") CharSequence paramCharSequence) {
/*      */     MemoryStack memoryStack;
/* 1506 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1508 */       memoryStack.nASCII(paramCharSequence, true);
/*      */       long l;
/* 1510 */       return nalGetEnumValue(l = memoryStack.getPointerAddress());
/*      */     } finally {
/* 1512 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nalGetProcAddress(long paramLong) {
/* 1520 */     long l = (AL.getICD()).alGetProcAddress;
/* 1521 */     return JNI.invokePP(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static long alGetProcAddress(@NativeType("ALchar const *") ByteBuffer paramByteBuffer) {
/* 1537 */     if (Checks.CHECKS) {
/* 1538 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 1540 */     return nalGetProcAddress(MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static long alGetProcAddress(@NativeType("ALchar const *") CharSequence paramCharSequence) {
/*      */     MemoryStack memoryStack;
/* 1556 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1558 */       memoryStack.nASCII(paramCharSequence, true);
/*      */       long l;
/* 1560 */       return nalGetProcAddress(l = memoryStack.getPointerAddress());
/*      */     } finally {
/* 1562 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean nalIsExtensionPresent(long paramLong) {
/* 1570 */     long l = (AL.getICD()).alIsExtensionPresent;
/* 1571 */     return JNI.invokePZ(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALCboolean")
/*      */   public static boolean alIsExtensionPresent(@NativeType("ALchar const *") ByteBuffer paramByteBuffer) {
/* 1584 */     if (Checks.CHECKS) {
/* 1585 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 1587 */     return nalIsExtensionPresent(MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALCboolean")
/*      */   public static boolean alIsExtensionPresent(@NativeType("ALchar const *") CharSequence paramCharSequence) {
/*      */     MemoryStack memoryStack;
/* 1600 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1602 */       memoryStack.nASCII(paramCharSequence, true);
/*      */       long l;
/* 1604 */       return nalIsExtensionPresent(l = memoryStack.getPointerAddress());
/*      */     } finally {
/* 1606 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetIntegerv(@NativeType("ALenum") int paramInt, @NativeType("ALint *") int[] paramArrayOfint) {
/* 1613 */     long l = (AL.getICD()).alGetIntegerv;
/* 1614 */     if (Checks.CHECKS) {
/* 1615 */       Checks.check(paramArrayOfint, 1);
/*      */     }
/* 1617 */     JNI.invokePV(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetFloatv(@NativeType("ALenum") int paramInt, @NativeType("ALfloat *") float[] paramArrayOffloat) {
/* 1623 */     long l = (AL.getICD()).alGetFloatv;
/* 1624 */     if (Checks.CHECKS) {
/* 1625 */       Checks.check(paramArrayOffloat, 1);
/*      */     }
/* 1627 */     JNI.invokePV(paramInt, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetDoublev(@NativeType("ALenum") int paramInt, @NativeType("ALdouble *") double[] paramArrayOfdouble) {
/* 1633 */     long l = (AL.getICD()).alGetDoublev;
/* 1634 */     if (Checks.CHECKS) {
/* 1635 */       Checks.check(paramArrayOfdouble, 1);
/*      */     }
/* 1637 */     JNI.invokePV(paramInt, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alListenerfv(@NativeType("ALenum") int paramInt, @NativeType("ALfloat const *") float[] paramArrayOffloat) {
/* 1643 */     long l = (AL.getICD()).alListenerfv;
/* 1644 */     if (Checks.CHECKS) {
/* 1645 */       Checks.check(paramArrayOffloat, 1);
/*      */     }
/* 1647 */     JNI.invokePV(paramInt, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetListenerf(@NativeType("ALenum") int paramInt, @NativeType("ALfloat *") float[] paramArrayOffloat) {
/* 1653 */     long l = (AL.getICD()).alGetListenerf;
/* 1654 */     if (Checks.CHECKS) {
/* 1655 */       Checks.check(paramArrayOffloat, 1);
/*      */     }
/* 1657 */     JNI.invokePV(paramInt, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetListeneri(@NativeType("ALenum") int paramInt, @NativeType("ALint *") int[] paramArrayOfint) {
/* 1663 */     long l = (AL.getICD()).alGetListeneri;
/* 1664 */     if (Checks.CHECKS) {
/* 1665 */       Checks.check(paramArrayOfint, 1);
/*      */     }
/* 1667 */     JNI.invokePV(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetListener3f(@NativeType("ALenum") int paramInt, @NativeType("ALfloat *") float[] paramArrayOffloat1, @NativeType("ALfloat *") float[] paramArrayOffloat2, @NativeType("ALfloat *") float[] paramArrayOffloat3) {
/* 1673 */     long l = (AL.getICD()).alGetListener3f;
/* 1674 */     if (Checks.CHECKS) {
/* 1675 */       Checks.check(paramArrayOffloat1, 1);
/* 1676 */       Checks.check(paramArrayOffloat2, 1);
/* 1677 */       Checks.check(paramArrayOffloat3, 1);
/*      */     } 
/* 1679 */     JNI.invokePPPV(paramInt, paramArrayOffloat1, paramArrayOffloat2, paramArrayOffloat3, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetListenerfv(@NativeType("ALenum") int paramInt, @NativeType("ALfloat *") float[] paramArrayOffloat) {
/* 1685 */     long l = (AL.getICD()).alGetListenerfv;
/* 1686 */     if (Checks.CHECKS) {
/* 1687 */       Checks.check(paramArrayOffloat, 1);
/*      */     }
/* 1689 */     JNI.invokePV(paramInt, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGenSources(@NativeType("ALuint *") int[] paramArrayOfint) {
/* 1695 */     long l = (AL.getICD()).alGenSources;
/* 1696 */     JNI.invokePV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteSources(@NativeType("ALuint *") int[] paramArrayOfint) {
/* 1702 */     long l = (AL.getICD()).alDeleteSources;
/* 1703 */     JNI.invokePV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourcefv(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALfloat const *") float[] paramArrayOffloat) {
/* 1709 */     long l = (AL.getICD()).alSourcefv;
/* 1710 */     if (Checks.CHECKS) {
/* 1711 */       Checks.check(paramArrayOffloat, 1);
/*      */     }
/* 1713 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetSourcef(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALfloat *") float[] paramArrayOffloat) {
/* 1719 */     long l = (AL.getICD()).alGetSourcef;
/* 1720 */     if (Checks.CHECKS) {
/* 1721 */       Checks.check(paramArrayOffloat, 1);
/*      */     }
/* 1723 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetSource3f(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALfloat *") float[] paramArrayOffloat1, @NativeType("ALfloat *") float[] paramArrayOffloat2, @NativeType("ALfloat *") float[] paramArrayOffloat3) {
/* 1729 */     long l = (AL.getICD()).alGetSource3f;
/* 1730 */     if (Checks.CHECKS) {
/* 1731 */       Checks.check(paramArrayOffloat1, 1);
/* 1732 */       Checks.check(paramArrayOffloat2, 1);
/* 1733 */       Checks.check(paramArrayOffloat3, 1);
/*      */     } 
/* 1735 */     JNI.invokePPPV(paramInt1, paramInt2, paramArrayOffloat1, paramArrayOffloat2, paramArrayOffloat3, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetSourcefv(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALfloat *") float[] paramArrayOffloat) {
/* 1741 */     long l = (AL.getICD()).alGetSourcefv;
/* 1742 */     if (Checks.CHECKS) {
/* 1743 */       Checks.check(paramArrayOffloat, 1);
/*      */     }
/* 1745 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetSourcei(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint *") int[] paramArrayOfint) {
/* 1751 */     long l = (AL.getICD()).alGetSourcei;
/* 1752 */     if (Checks.CHECKS) {
/* 1753 */       Checks.check(paramArrayOfint, 1);
/*      */     }
/* 1755 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetSourceiv(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint *") int[] paramArrayOfint) {
/* 1761 */     long l = (AL.getICD()).alGetSourceiv;
/* 1762 */     if (Checks.CHECKS) {
/* 1763 */       Checks.check(paramArrayOfint, 1);
/*      */     }
/* 1765 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourceQueueBuffers(@NativeType("ALuint") int paramInt, @NativeType("ALuint *") int[] paramArrayOfint) {
/* 1771 */     long l = (AL.getICD()).alSourceQueueBuffers;
/* 1772 */     JNI.invokePV(paramInt, paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourceUnqueueBuffers(@NativeType("ALuint") int paramInt, @NativeType("ALuint *") int[] paramArrayOfint) {
/* 1778 */     long l = (AL.getICD()).alSourceUnqueueBuffers;
/* 1779 */     JNI.invokePV(paramInt, paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourcePlayv(@NativeType("ALuint const *") int[] paramArrayOfint) {
/* 1785 */     long l = (AL.getICD()).alSourcePlayv;
/* 1786 */     JNI.invokePV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourcePausev(@NativeType("ALuint const *") int[] paramArrayOfint) {
/* 1792 */     long l = (AL.getICD()).alSourcePausev;
/* 1793 */     JNI.invokePV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourceStopv(@NativeType("ALuint const *") int[] paramArrayOfint) {
/* 1799 */     long l = (AL.getICD()).alSourceStopv;
/* 1800 */     JNI.invokePV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourceRewindv(@NativeType("ALuint const *") int[] paramArrayOfint) {
/* 1806 */     long l = (AL.getICD()).alSourceRewindv;
/* 1807 */     JNI.invokePV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGenBuffers(@NativeType("ALuint *") int[] paramArrayOfint) {
/* 1813 */     long l = (AL.getICD()).alGenBuffers;
/* 1814 */     JNI.invokePV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteBuffers(@NativeType("ALuint const *") int[] paramArrayOfint) {
/* 1820 */     long l = (AL.getICD()).alDeleteBuffers;
/* 1821 */     JNI.invokePV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetBufferf(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALfloat *") float[] paramArrayOffloat) {
/* 1827 */     long l = (AL.getICD()).alGetBufferf;
/* 1828 */     if (Checks.CHECKS) {
/* 1829 */       Checks.check(paramArrayOffloat, 1);
/*      */     }
/* 1831 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetBufferi(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint *") int[] paramArrayOfint) {
/* 1837 */     long l = (AL.getICD()).alGetBufferi;
/* 1838 */     if (Checks.CHECKS) {
/* 1839 */       Checks.check(paramArrayOfint, 1);
/*      */     }
/* 1841 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alBufferData(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALvoid const *") short[] paramArrayOfshort, @NativeType("ALsizei") int paramInt3) {
/* 1847 */     long l = (AL.getICD()).alBufferData;
/* 1848 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOfshort, paramArrayOfshort.length << 1, paramInt3, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alBufferData(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALvoid const *") int[] paramArrayOfint, @NativeType("ALsizei") int paramInt3) {
/* 1854 */     long l = (AL.getICD()).alBufferData;
/* 1855 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOfint, paramArrayOfint.length << 2, paramInt3, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alBufferData(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALvoid const *") float[] paramArrayOffloat, @NativeType("ALsizei") int paramInt3) {
/* 1861 */     long l = (AL.getICD()).alBufferData;
/* 1862 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOffloat, paramArrayOffloat.length << 2, paramInt3, l);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\openal\AL10.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */