/*      */ package org.lwjgl.system.jni;
/*      */ 
/*      */ import java.lang.reflect.Field;
/*      */ import java.lang.reflect.Method;
/*      */ import java.nio.Buffer;
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.DoubleBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.LongBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.CustomBuffer;
/*      */ import org.lwjgl.system.Library;
/*      */ import org.lwjgl.system.MemoryUtil;
/*      */ import org.lwjgl.system.NativeType;
/*      */ import org.lwjgl.system.Struct;
/*      */ 
/*      */ public class JNINativeInterface {
/*      */   public static final int JNI_VERSION_1_1 = 65537;
/*      */   public static final int JNI_VERSION_1_2 = 65538;
/*      */   public static final int JNI_VERSION_1_4 = 65540;
/*      */   public static final int JNI_VERSION_1_6 = 65542;
/*      */   public static final int JNI_VERSION_1_8 = 65544;
/*      */   public static final int JNI_VERSION_9 = 589824;
/*      */   public static final int JNI_VERSION_10 = 655360;
/*      */   public static final int JNI_VERSION_19 = 1245184;
/*      */   public static final int JNI_VERSION_20 = 1310720;
/*      */   public static final int JNI_VERSION_21 = 1376256;
/*      */   public static final int JNIInvalidRefType = 0;
/*      */   public static final int JNILocalRefType = 1;
/*      */   
/*      */   static {
/*   35 */     Library.initialize();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int JNIGlobalRefType = 2;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int JNIWeakGlobalRefType = 3;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int JNI_FALSE = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int JNI_TRUE = 1;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int JNI_OK = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int JNI_ERR = -1;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int JNI_EDETACHED = -2;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int JNI_EVERSION = -3;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int JNI_ENOMEM = -4;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int JNI_EEXIST = -5;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int JNI_EINVAL = -6;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int JNI_COMMIT = 1;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int JNI_ABORT = 2;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected JNINativeInterface() {
/*  103 */     throw new UnsupportedOperationException();
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
/*      */   @NativeType("jobject")
/*      */   public static Method ToReflectedMethod(@NativeType("jclass") Class<?> paramClass, @NativeType("jmethodID") long paramLong, @NativeType("jboolean") boolean paramBoolean) {
/*  142 */     if (Checks.CHECKS) {
/*  143 */       Checks.check(paramLong);
/*      */     }
/*  145 */     return nToReflectedMethod(paramClass, paramLong, paramBoolean);
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
/*      */   @NativeType("jobject")
/*      */   public static Field ToReflectedField(@NativeType("jclass") Class<?> paramClass, @NativeType("jfieldID") long paramLong, @NativeType("jboolean") boolean paramBoolean) {
/*  162 */     if (Checks.CHECKS) {
/*  163 */       Checks.check(paramLong);
/*      */     }
/*  165 */     return nToReflectedField(paramClass, paramLong, paramBoolean);
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
/*      */   public static void DeleteGlobalRef(@NativeType("void *") long paramLong) {
/*  192 */     if (Checks.CHECKS) {
/*  193 */       Checks.check(paramLong);
/*      */     }
/*  195 */     nDeleteGlobalRef(paramLong);
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
/*      */   @NativeType("jboolean *")
/*      */   public static ByteBuffer GetBooleanArrayElements(@NativeType("jbooleanArray") byte[] paramArrayOfbyte, @NativeType("jboolean *") ByteBuffer paramByteBuffer) {
/*  218 */     if (Checks.CHECKS) {
/*  219 */       Checks.checkSafe(paramByteBuffer, 1);
/*      */     }
/*      */     long l;
/*  222 */     return MemoryUtil.memByteBufferSafe(l = nGetBooleanArrayElements(paramArrayOfbyte, MemoryUtil.memAddressSafe(paramByteBuffer)), paramArrayOfbyte.length);
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
/*      */   public static void ReleaseBooleanArrayElements(@NativeType("jbooleanArray") byte[] paramArrayOfbyte, @NativeType("jboolean *") ByteBuffer paramByteBuffer, @NativeType("jint") int paramInt) {
/*  252 */     nReleaseBooleanArrayElements(paramArrayOfbyte, MemoryUtil.memAddress(paramByteBuffer), paramInt);
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
/*      */   @NativeType("jbyte *")
/*      */   public static ByteBuffer GetByteArrayElements(@NativeType("jbyteArray") byte[] paramArrayOfbyte, @NativeType("jboolean *") ByteBuffer paramByteBuffer) {
/*  275 */     if (Checks.CHECKS) {
/*  276 */       Checks.checkSafe(paramByteBuffer, 1);
/*      */     }
/*      */     long l;
/*  279 */     return MemoryUtil.memByteBufferSafe(l = nGetByteArrayElements(paramArrayOfbyte, MemoryUtil.memAddressSafe(paramByteBuffer)), paramArrayOfbyte.length);
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
/*      */   public static void ReleaseByteArrayElements(@NativeType("jbyteArray") byte[] paramArrayOfbyte, @NativeType("jbyte *") ByteBuffer paramByteBuffer, @NativeType("jint") int paramInt) {
/*  309 */     nReleaseByteArrayElements(paramArrayOfbyte, MemoryUtil.memAddress(paramByteBuffer), paramInt);
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
/*      */   @NativeType("jchar *")
/*      */   public static ShortBuffer GetCharArrayElements(@NativeType("jcharArray") char[] paramArrayOfchar, @NativeType("jboolean *") ByteBuffer paramByteBuffer) {
/*  332 */     if (Checks.CHECKS) {
/*  333 */       Checks.checkSafe(paramByteBuffer, 1);
/*      */     }
/*      */     long l;
/*  336 */     return MemoryUtil.memShortBufferSafe(l = nGetCharArrayElements(paramArrayOfchar, MemoryUtil.memAddressSafe(paramByteBuffer)), paramArrayOfchar.length);
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
/*      */   public static void ReleaseCharArrayElements(@NativeType("jcharArray") char[] paramArrayOfchar, @NativeType("jchar *") ShortBuffer paramShortBuffer, @NativeType("jint") int paramInt) {
/*  366 */     nReleaseCharArrayElements(paramArrayOfchar, MemoryUtil.memAddress(paramShortBuffer), paramInt);
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
/*      */   @NativeType("jshort *")
/*      */   public static ShortBuffer GetShortArrayElements(@NativeType("jshortArray") short[] paramArrayOfshort, @NativeType("jboolean *") ByteBuffer paramByteBuffer) {
/*  389 */     if (Checks.CHECKS) {
/*  390 */       Checks.checkSafe(paramByteBuffer, 1);
/*      */     }
/*      */     long l;
/*  393 */     return MemoryUtil.memShortBufferSafe(l = nGetShortArrayElements(paramArrayOfshort, MemoryUtil.memAddressSafe(paramByteBuffer)), paramArrayOfshort.length);
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
/*      */   public static void ReleaseShortArrayElements(@NativeType("jshortArray") short[] paramArrayOfshort, @NativeType("jshort *") ShortBuffer paramShortBuffer, @NativeType("jint") int paramInt) {
/*  423 */     nReleaseShortArrayElements(paramArrayOfshort, MemoryUtil.memAddress(paramShortBuffer), paramInt);
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
/*      */   @NativeType("jint *")
/*      */   public static IntBuffer GetIntArrayElements(@NativeType("jintArray") int[] paramArrayOfint, @NativeType("jboolean *") ByteBuffer paramByteBuffer) {
/*  446 */     if (Checks.CHECKS) {
/*  447 */       Checks.checkSafe(paramByteBuffer, 1);
/*      */     }
/*      */     long l;
/*  450 */     return MemoryUtil.memIntBufferSafe(l = nGetIntArrayElements(paramArrayOfint, MemoryUtil.memAddressSafe(paramByteBuffer)), paramArrayOfint.length);
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
/*      */   public static void ReleaseIntArrayElements(@NativeType("jintArray") int[] paramArrayOfint, @NativeType("jint *") IntBuffer paramIntBuffer, @NativeType("jint") int paramInt) {
/*  480 */     nReleaseIntArrayElements(paramArrayOfint, MemoryUtil.memAddress(paramIntBuffer), paramInt);
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
/*      */   @NativeType("jlong *")
/*      */   public static LongBuffer GetLongArrayElements(@NativeType("jlongArray") long[] paramArrayOflong, @NativeType("jboolean *") ByteBuffer paramByteBuffer) {
/*  503 */     if (Checks.CHECKS) {
/*  504 */       Checks.checkSafe(paramByteBuffer, 1);
/*      */     }
/*      */     long l;
/*  507 */     return MemoryUtil.memLongBufferSafe(l = nGetLongArrayElements(paramArrayOflong, MemoryUtil.memAddressSafe(paramByteBuffer)), paramArrayOflong.length);
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
/*      */   public static void ReleaseLongArrayElements(@NativeType("jlongArray") long[] paramArrayOflong, @NativeType("jlong *") LongBuffer paramLongBuffer, @NativeType("jint") int paramInt) {
/*  537 */     nReleaseLongArrayElements(paramArrayOflong, MemoryUtil.memAddress(paramLongBuffer), paramInt);
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
/*      */   @NativeType("jfloat *")
/*      */   public static FloatBuffer GetFloatArrayElements(@NativeType("jfloatArray") float[] paramArrayOffloat, @NativeType("jboolean *") ByteBuffer paramByteBuffer) {
/*  560 */     if (Checks.CHECKS) {
/*  561 */       Checks.checkSafe(paramByteBuffer, 1);
/*      */     }
/*      */     long l;
/*  564 */     return MemoryUtil.memFloatBufferSafe(l = nGetFloatArrayElements(paramArrayOffloat, MemoryUtil.memAddressSafe(paramByteBuffer)), paramArrayOffloat.length);
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
/*      */   public static void ReleaseFloatArrayElements(@NativeType("jfloatArray") float[] paramArrayOffloat, @NativeType("jfloat *") FloatBuffer paramFloatBuffer, @NativeType("jint") int paramInt) {
/*  594 */     nReleaseFloatArrayElements(paramArrayOffloat, MemoryUtil.memAddress(paramFloatBuffer), paramInt);
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
/*      */   @NativeType("jdouble *")
/*      */   public static DoubleBuffer GetDoubleArrayElements(@NativeType("jdoubleArray") double[] paramArrayOfdouble, @NativeType("jboolean *") ByteBuffer paramByteBuffer) {
/*  617 */     if (Checks.CHECKS) {
/*  618 */       Checks.checkSafe(paramByteBuffer, 1);
/*      */     }
/*      */     long l;
/*  621 */     return MemoryUtil.memDoubleBufferSafe(l = nGetDoubleArrayElements(paramArrayOfdouble, MemoryUtil.memAddressSafe(paramByteBuffer)), paramArrayOfdouble.length);
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
/*      */   public static void ReleaseDoubleArrayElements(@NativeType("jdoubleArray") double[] paramArrayOfdouble, @NativeType("jdouble *") DoubleBuffer paramDoubleBuffer, @NativeType("jint") int paramInt) {
/*  651 */     nReleaseDoubleArrayElements(paramArrayOfdouble, MemoryUtil.memAddress(paramDoubleBuffer), paramInt);
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
/*      */   public static void GetBooleanArrayRegion(@NativeType("jbooleanArray") byte[] paramArrayOfbyte, @NativeType("jsize") int paramInt, @NativeType("jboolean *") ByteBuffer paramByteBuffer) {
/*  671 */     nGetBooleanArrayRegion(paramArrayOfbyte, paramInt, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   public static void SetBooleanArrayRegion(@NativeType("jbooleanArray") byte[] paramArrayOfbyte, @NativeType("jsize") int paramInt, @NativeType("jboolean const *") ByteBuffer paramByteBuffer) {
/*  691 */     nSetBooleanArrayRegion(paramArrayOfbyte, paramInt, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   public static void GetByteArrayRegion(@NativeType("jbyteArray") byte[] paramArrayOfbyte, @NativeType("jsize") int paramInt, @NativeType("jbyte *") ByteBuffer paramByteBuffer) {
/*  711 */     nGetByteArrayRegion(paramArrayOfbyte, paramInt, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   public static void SetByteArrayRegion(@NativeType("jbyteArray") byte[] paramArrayOfbyte, @NativeType("jsize") int paramInt, @NativeType("jbyte const *") ByteBuffer paramByteBuffer) {
/*  731 */     nSetByteArrayRegion(paramArrayOfbyte, paramInt, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   public static void GetCharArrayRegion(@NativeType("jcharArray") char[] paramArrayOfchar, @NativeType("jsize") int paramInt, @NativeType("jchar *") ShortBuffer paramShortBuffer) {
/*  751 */     nGetCharArrayRegion(paramArrayOfchar, paramInt, paramShortBuffer.remaining(), MemoryUtil.memAddress(paramShortBuffer));
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
/*      */   public static void SetCharArrayRegion(@NativeType("jcharArray") char[] paramArrayOfchar, @NativeType("jsize") int paramInt, @NativeType("jchar const *") ShortBuffer paramShortBuffer) {
/*  771 */     nSetCharArrayRegion(paramArrayOfchar, paramInt, paramShortBuffer.remaining(), MemoryUtil.memAddress(paramShortBuffer));
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
/*      */   public static void GetShortArrayRegion(@NativeType("jshortArray") short[] paramArrayOfshort, @NativeType("jsize") int paramInt, @NativeType("jshort *") ShortBuffer paramShortBuffer) {
/*  791 */     nGetShortArrayRegion(paramArrayOfshort, paramInt, paramShortBuffer.remaining(), MemoryUtil.memAddress(paramShortBuffer));
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
/*      */   public static void SetShortArrayRegion(@NativeType("jshortArray") short[] paramArrayOfshort, @NativeType("jsize") int paramInt, @NativeType("jshort const *") ShortBuffer paramShortBuffer) {
/*  811 */     nSetShortArrayRegion(paramArrayOfshort, paramInt, paramShortBuffer.remaining(), MemoryUtil.memAddress(paramShortBuffer));
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
/*      */   public static void GetIntArrayRegion(@NativeType("jintArray") int[] paramArrayOfint, @NativeType("jsize") int paramInt, @NativeType("jint *") IntBuffer paramIntBuffer) {
/*  831 */     nGetIntArrayRegion(paramArrayOfint, paramInt, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void SetIntArrayRegion(@NativeType("jintArray") int[] paramArrayOfint, @NativeType("jsize") int paramInt, @NativeType("jint const *") IntBuffer paramIntBuffer) {
/*  851 */     nSetIntArrayRegion(paramArrayOfint, paramInt, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static void GetLongArrayRegion(@NativeType("jlongArray") long[] paramArrayOflong, @NativeType("jsize") int paramInt, @NativeType("jlong *") LongBuffer paramLongBuffer) {
/*  871 */     nGetLongArrayRegion(paramArrayOflong, paramInt, paramLongBuffer.remaining(), MemoryUtil.memAddress(paramLongBuffer));
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
/*      */   public static void SetLongArrayRegion(@NativeType("jlongArray") long[] paramArrayOflong, @NativeType("jsize") int paramInt, @NativeType("jlong const *") LongBuffer paramLongBuffer) {
/*  891 */     nSetLongArrayRegion(paramArrayOflong, paramInt, paramLongBuffer.remaining(), MemoryUtil.memAddress(paramLongBuffer));
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
/*      */   public static void GetFloatArrayRegion(@NativeType("jfloatArray") float[] paramArrayOffloat, @NativeType("jsize") int paramInt, @NativeType("jfloat *") FloatBuffer paramFloatBuffer) {
/*  911 */     nGetFloatArrayRegion(paramArrayOffloat, paramInt, paramFloatBuffer.remaining(), MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void SetFloatArrayRegion(@NativeType("jfloatArray") float[] paramArrayOffloat, @NativeType("jsize") int paramInt, @NativeType("jfloat const *") FloatBuffer paramFloatBuffer) {
/*  931 */     nSetFloatArrayRegion(paramArrayOffloat, paramInt, paramFloatBuffer.remaining(), MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static void GetDoubleArrayRegion(@NativeType("jdoubleArray") double[] paramArrayOfdouble, @NativeType("jsize") int paramInt, @NativeType("jdouble *") DoubleBuffer paramDoubleBuffer) {
/*  951 */     nGetDoubleArrayRegion(paramArrayOfdouble, paramInt, paramDoubleBuffer.remaining(), MemoryUtil.memAddress(paramDoubleBuffer));
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
/*      */   public static void SetDoubleArrayRegion(@NativeType("jdoubleArray") double[] paramArrayOfdouble, @NativeType("jsize") int paramInt, @NativeType("jdouble const *") DoubleBuffer paramDoubleBuffer) {
/*  971 */     nSetDoubleArrayRegion(paramArrayOfdouble, paramInt, paramDoubleBuffer.remaining(), MemoryUtil.memAddress(paramDoubleBuffer));
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
/*      */   @NativeType("jint")
/*      */   public static int RegisterNatives(@NativeType("jclass") Class<?> paramClass, @NativeType("JNINativeMethod const *") JNINativeMethod.Buffer paramBuffer) {
/*  994 */     if (Checks.CHECKS) {
/*  995 */       Struct.validate(paramBuffer.address(), paramBuffer.remaining(), JNINativeMethod.SIZEOF, JNINativeMethod::validate);
/*      */     }
/*  997 */     return nRegisterNatives(paramClass, paramBuffer.address(), paramBuffer.remaining());
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
/*      */   @NativeType("jint")
/*      */   public static int GetJavaVM(@NativeType("JavaVM **") PointerBuffer paramPointerBuffer) {
/* 1027 */     if (Checks.CHECKS) {
/* 1028 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*      */     }
/* 1030 */     return nGetJavaVM(MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void GetStringRegion(@NativeType("jstring") String paramString, @NativeType("jsize") int paramInt, @NativeType("jchar *") ByteBuffer paramByteBuffer) {
/* 1040 */     nGetStringRegion(paramString, paramInt, paramByteBuffer.remaining() >> 1, MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   public static void GetStringUTFRegion(@NativeType("jstring") String paramString, @NativeType("jsize") int paramInt1, @NativeType("jsize") int paramInt2, @NativeType("char *") ByteBuffer paramByteBuffer) {
/* 1053 */     if (Checks.CHECKS) {
/* 1054 */       Checks.check(paramByteBuffer, paramInt2);
/*      */     }
/* 1056 */     nGetStringUTFRegion(paramString, paramInt1, paramInt2, MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   public static void DeleteWeakGlobalRef(@NativeType("void *") long paramLong) {
/* 1075 */     if (Checks.CHECKS) {
/* 1076 */       Checks.check(paramLong);
/*      */     }
/* 1078 */     nDeleteWeakGlobalRef(paramLong);
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
/*      */   @NativeType("jobject")
/*      */   public static ByteBuffer NewDirectByteBuffer(@NativeType("void *") long paramLong1, @NativeType("jlong") long paramLong2) {
/* 1104 */     if (Checks.CHECKS) {
/* 1105 */       Checks.check(paramLong1);
/*      */     }
/* 1107 */     return nNewDirectByteBuffer(paramLong1, paramLong2);
/*      */   }
/*      */   
/*      */   @NativeType("jint")
/*      */   public static native int GetVersion();
/*      */   
/*      */   @NativeType("jmethodID")
/*      */   public static native long FromReflectedMethod(@NativeType("jobject") Method paramMethod);
/*      */   
/*      */   @NativeType("jfieldID")
/*      */   public static native long FromReflectedField(@NativeType("jobject") Field paramField);
/*      */   
/*      */   public static native Method nToReflectedMethod(Class<?> paramClass, long paramLong, boolean paramBoolean);
/*      */   
/*      */   public static native Field nToReflectedField(Class<?> paramClass, long paramLong, boolean paramBoolean);
/*      */   
/*      */   @NativeType("void *")
/*      */   public static native long NewGlobalRef(@NativeType("jobject") Object paramObject);
/*      */   
/*      */   public static native void nDeleteGlobalRef(long paramLong);
/*      */   
/*      */   public static native long nGetBooleanArrayElements(byte[] paramArrayOfbyte, long paramLong);
/*      */   
/*      */   public static native void nReleaseBooleanArrayElements(byte[] paramArrayOfbyte, long paramLong, int paramInt);
/*      */   
/*      */   public static native long nGetByteArrayElements(byte[] paramArrayOfbyte, long paramLong);
/*      */   
/*      */   public static native void nReleaseByteArrayElements(byte[] paramArrayOfbyte, long paramLong, int paramInt);
/*      */   
/*      */   public static native long nGetCharArrayElements(char[] paramArrayOfchar, long paramLong);
/*      */   
/*      */   public static native void nReleaseCharArrayElements(char[] paramArrayOfchar, long paramLong, int paramInt);
/*      */   
/*      */   public static native long nGetShortArrayElements(short[] paramArrayOfshort, long paramLong);
/*      */   
/*      */   public static native void nReleaseShortArrayElements(short[] paramArrayOfshort, long paramLong, int paramInt);
/*      */   
/*      */   public static native long nGetIntArrayElements(int[] paramArrayOfint, long paramLong);
/*      */   
/*      */   public static native void nReleaseIntArrayElements(int[] paramArrayOfint, long paramLong, int paramInt);
/*      */   
/*      */   public static native long nGetLongArrayElements(long[] paramArrayOflong, long paramLong);
/*      */   
/*      */   public static native void nReleaseLongArrayElements(long[] paramArrayOflong, long paramLong, int paramInt);
/*      */   
/*      */   public static native long nGetFloatArrayElements(float[] paramArrayOffloat, long paramLong);
/*      */   
/*      */   public static native void nReleaseFloatArrayElements(float[] paramArrayOffloat, long paramLong, int paramInt);
/*      */   
/*      */   public static native long nGetDoubleArrayElements(double[] paramArrayOfdouble, long paramLong);
/*      */   
/*      */   public static native void nReleaseDoubleArrayElements(double[] paramArrayOfdouble, long paramLong, int paramInt);
/*      */   
/*      */   public static native void nGetBooleanArrayRegion(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nSetBooleanArrayRegion(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nGetByteArrayRegion(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nSetByteArrayRegion(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nGetCharArrayRegion(char[] paramArrayOfchar, int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nSetCharArrayRegion(char[] paramArrayOfchar, int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nGetShortArrayRegion(short[] paramArrayOfshort, int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nSetShortArrayRegion(short[] paramArrayOfshort, int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nGetIntArrayRegion(int[] paramArrayOfint, int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nSetIntArrayRegion(int[] paramArrayOfint, int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nGetLongArrayRegion(long[] paramArrayOflong, int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nSetLongArrayRegion(long[] paramArrayOflong, int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nGetFloatArrayRegion(float[] paramArrayOffloat, int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nSetFloatArrayRegion(float[] paramArrayOffloat, int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nGetDoubleArrayRegion(double[] paramArrayOfdouble, int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nSetDoubleArrayRegion(double[] paramArrayOfdouble, int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native int nRegisterNatives(Class<?> paramClass, long paramLong, int paramInt);
/*      */   
/*      */   @NativeType("jint")
/*      */   public static native int UnregisterNatives(@NativeType("jclass") Class<?> paramClass);
/*      */   
/*      */   public static native int nGetJavaVM(long paramLong);
/*      */   
/*      */   public static native void nGetStringRegion(String paramString, int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nGetStringUTFRegion(String paramString, int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   @NativeType("void *")
/*      */   public static native long NewWeakGlobalRef(@NativeType("jobject") Object paramObject);
/*      */   
/*      */   public static native void nDeleteWeakGlobalRef(long paramLong);
/*      */   
/*      */   public static native ByteBuffer nNewDirectByteBuffer(long paramLong1, long paramLong2);
/*      */   
/*      */   @NativeType("void *")
/*      */   public static native long GetDirectBufferAddress(@NativeType("jobject") Buffer paramBuffer);
/*      */   
/*      */   @NativeType("jobjectRefType")
/*      */   public static native int GetObjectRefType(@NativeType("jobject") Object paramObject);
/*      */   
/*      */   public static native void noop();
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\jni\JNINativeInterface.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */