/*     */ package org.lwjgl.system.jni;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeResource;
/*     */ import org.lwjgl.system.NativeType;
/*     */ import org.lwjgl.system.Struct;
/*     */ import org.lwjgl.system.StructBuffer;
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
/*     */ public class JNINativeMethod
/*     */   extends Struct<JNINativeMethod>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int NAME;
/*     */   public static final int SIGNATURE;
/*     */   public static final int FNPTR;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  50 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(POINTER_SIZE), __member(POINTER_SIZE), __member(POINTER_SIZE) })).getSize();
/*  51 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  53 */     NAME = layout.offsetof(0);
/*  54 */     SIGNATURE = layout.offsetof(1);
/*  55 */     FNPTR = layout.offsetof(2);
/*     */   }
/*     */   
/*     */   protected JNINativeMethod(long paramLong, ByteBuffer paramByteBuffer) {
/*  59 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected JNINativeMethod create(long paramLong, ByteBuffer paramByteBuffer) {
/*  64 */     return new JNINativeMethod(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JNINativeMethod(ByteBuffer paramByteBuffer) {
/*  74 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  78 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("char *")
/*     */   public ByteBuffer name() {
/*  82 */     return nname(address());
/*     */   } @NativeType("char *")
/*     */   public String nameString() {
/*  85 */     return nnameString(address());
/*     */   } @NativeType("char *")
/*     */   public ByteBuffer signature() {
/*  88 */     return nsignature(address());
/*     */   } @NativeType("char *")
/*     */   public String signatureString() {
/*  91 */     return nsignatureString(address());
/*     */   } @NativeType("void *")
/*     */   public long fnPtr() {
/*  94 */     return nfnPtr(address());
/*     */   }
/*     */   public JNINativeMethod name(@NativeType("char *") ByteBuffer paramByteBuffer) {
/*  97 */     nname(address(), paramByteBuffer); return this;
/*     */   } public JNINativeMethod signature(@NativeType("char *") ByteBuffer paramByteBuffer) {
/*  99 */     nsignature(address(), paramByteBuffer); return this;
/*     */   } public JNINativeMethod fnPtr(@NativeType("void *") long paramLong) {
/* 101 */     nfnPtr(address(), paramLong); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JNINativeMethod set(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, long paramLong) {
/* 109 */     name(paramByteBuffer1);
/* 110 */     signature(paramByteBuffer2);
/* 111 */     fnPtr(paramLong);
/*     */     
/* 113 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JNINativeMethod set(JNINativeMethod paramJNINativeMethod) {
/* 124 */     MemoryUtil.memCopy(paramJNINativeMethod.address(), address(), SIZEOF);
/* 125 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JNINativeMethod malloc() {
/* 132 */     return new JNINativeMethod(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static JNINativeMethod calloc() {
/* 137 */     return new JNINativeMethod(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static JNINativeMethod create() {
/* 142 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 143 */     return new JNINativeMethod(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static JNINativeMethod create(long paramLong) {
/* 148 */     return new JNINativeMethod(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static JNINativeMethod createSafe(long paramLong) {
/* 154 */     return (paramLong == 0L) ? null : new JNINativeMethod(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 163 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 172 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 181 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 182 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 192 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 198 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static JNINativeMethod mallocStack() {
/* 204 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 206 */   public static JNINativeMethod callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 208 */   public static JNINativeMethod mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 210 */   public static JNINativeMethod callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 212 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 214 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 216 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 218 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JNINativeMethod malloc(MemoryStack paramMemoryStack) {
/* 226 */     return new JNINativeMethod(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JNINativeMethod calloc(MemoryStack paramMemoryStack) {
/* 235 */     return new JNINativeMethod(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 245 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 255 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static ByteBuffer nname(long paramLong) {
/* 261 */     return MemoryUtil.memByteBufferNT1(MemoryUtil.memGetAddress(paramLong + NAME));
/*     */   } public static String nnameString(long paramLong) {
/* 263 */     return MemoryUtil.memUTF8(MemoryUtil.memGetAddress(paramLong + NAME));
/*     */   } public static ByteBuffer nsignature(long paramLong) {
/* 265 */     return MemoryUtil.memByteBufferNT1(MemoryUtil.memGetAddress(paramLong + SIGNATURE));
/*     */   } public static String nsignatureString(long paramLong) {
/* 267 */     return MemoryUtil.memUTF8(MemoryUtil.memGetAddress(paramLong + SIGNATURE));
/*     */   } public static long nfnPtr(long paramLong) {
/* 269 */     return MemoryUtil.memGetAddress(paramLong + FNPTR);
/*     */   }
/*     */   
/*     */   public static void nname(long paramLong, ByteBuffer paramByteBuffer) {
/* 273 */     if (Checks.CHECKS) Checks.checkNT1(paramByteBuffer); 
/* 274 */     MemoryUtil.memPutAddress(paramLong + NAME, MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */   
/*     */   public static void nsignature(long paramLong, ByteBuffer paramByteBuffer) {
/* 278 */     if (Checks.CHECKS) Checks.checkNT1(paramByteBuffer); 
/* 279 */     MemoryUtil.memPutAddress(paramLong + SIGNATURE, MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */   public static void nfnPtr(long paramLong1, long paramLong2) {
/* 282 */     MemoryUtil.memPutAddress(paramLong1 + FNPTR, Checks.check(paramLong2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 290 */     Checks.check(MemoryUtil.memGetAddress(paramLong + NAME));
/* 291 */     Checks.check(MemoryUtil.memGetAddress(paramLong + SIGNATURE));
/* 292 */     Checks.check(MemoryUtil.memGetAddress(paramLong + FNPTR));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<JNINativeMethod, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 300 */     private static final JNINativeMethod ELEMENT_FACTORY = JNINativeMethod.create(-1L);
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
/*     */     public Buffer(ByteBuffer param1ByteBuffer) {
/* 312 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / JNINativeMethod.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 316 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 320 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 325 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected JNINativeMethod getElementFactory() {
/* 330 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("char *")
/*     */     public ByteBuffer name() {
/* 335 */       return JNINativeMethod.nname(address());
/*     */     } @NativeType("char *")
/*     */     public String nameString() {
/* 338 */       return JNINativeMethod.nnameString(address());
/*     */     } @NativeType("char *")
/*     */     public ByteBuffer signature() {
/* 341 */       return JNINativeMethod.nsignature(address());
/*     */     } @NativeType("char *")
/*     */     public String signatureString() {
/* 344 */       return JNINativeMethod.nsignatureString(address());
/*     */     } @NativeType("void *")
/*     */     public long fnPtr() {
/* 347 */       return JNINativeMethod.nfnPtr(address());
/*     */     }
/*     */     public Buffer name(@NativeType("char *") ByteBuffer param1ByteBuffer) {
/* 350 */       JNINativeMethod.nname(address(), param1ByteBuffer); return this;
/*     */     } public Buffer signature(@NativeType("char *") ByteBuffer param1ByteBuffer) {
/* 352 */       JNINativeMethod.nsignature(address(), param1ByteBuffer); return this;
/*     */     } public Buffer fnPtr(@NativeType("void *") long param1Long) {
/* 354 */       JNINativeMethod.nfnPtr(address(), param1Long); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\jni\JNINativeMethod.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */