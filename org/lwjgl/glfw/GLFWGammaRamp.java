/*     */ package org.lwjgl.glfw;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ShortBuffer;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @NativeType("struct GLFWgammaramp")
/*     */ public class GLFWGammaRamp
/*     */   extends Struct<GLFWGammaRamp>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int RED;
/*     */   public static final int GREEN;
/*     */   public static final int BLUE;
/*     */   public static final int SIZE;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  58 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(POINTER_SIZE), __member(POINTER_SIZE), __member(POINTER_SIZE), __member(4) })).getSize();
/*  59 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  61 */     RED = layout.offsetof(0);
/*  62 */     GREEN = layout.offsetof(1);
/*  63 */     BLUE = layout.offsetof(2);
/*  64 */     SIZE = layout.offsetof(3);
/*     */   }
/*     */   
/*     */   protected GLFWGammaRamp(long paramLong, ByteBuffer paramByteBuffer) {
/*  68 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected GLFWGammaRamp create(long paramLong, ByteBuffer paramByteBuffer) {
/*  73 */     return new GLFWGammaRamp(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GLFWGammaRamp(ByteBuffer paramByteBuffer) {
/*  83 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  87 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("unsigned short *")
/*     */   public ShortBuffer red() {
/*  91 */     return nred(address());
/*     */   } @NativeType("unsigned short *")
/*     */   public ShortBuffer green() {
/*  94 */     return ngreen(address());
/*     */   } @NativeType("unsigned short *")
/*     */   public ShortBuffer blue() {
/*  97 */     return nblue(address());
/*     */   } @NativeType("unsigned int")
/*     */   public int size() {
/* 100 */     return nsize(address());
/*     */   }
/*     */   public GLFWGammaRamp red(@NativeType("unsigned short *") ShortBuffer paramShortBuffer) {
/* 103 */     nred(address(), paramShortBuffer); return this;
/*     */   } public GLFWGammaRamp green(@NativeType("unsigned short *") ShortBuffer paramShortBuffer) {
/* 105 */     ngreen(address(), paramShortBuffer); return this;
/*     */   } public GLFWGammaRamp blue(@NativeType("unsigned short *") ShortBuffer paramShortBuffer) {
/* 107 */     nblue(address(), paramShortBuffer); return this;
/*     */   } public GLFWGammaRamp size(@NativeType("unsigned int") int paramInt) {
/* 109 */     nsize(address(), paramInt); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GLFWGammaRamp set(ShortBuffer paramShortBuffer1, ShortBuffer paramShortBuffer2, ShortBuffer paramShortBuffer3, int paramInt) {
/* 118 */     red(paramShortBuffer1);
/* 119 */     green(paramShortBuffer2);
/* 120 */     blue(paramShortBuffer3);
/* 121 */     size(paramInt);
/*     */     
/* 123 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GLFWGammaRamp set(GLFWGammaRamp paramGLFWGammaRamp) {
/* 134 */     MemoryUtil.memCopy(paramGLFWGammaRamp.address(), address(), SIZEOF);
/* 135 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLFWGammaRamp malloc() {
/* 142 */     return new GLFWGammaRamp(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GLFWGammaRamp calloc() {
/* 147 */     return new GLFWGammaRamp(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GLFWGammaRamp create() {
/* 152 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 153 */     return new GLFWGammaRamp(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GLFWGammaRamp create(long paramLong) {
/* 158 */     return new GLFWGammaRamp(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLFWGammaRamp createSafe(long paramLong) {
/* 164 */     return (paramLong == 0L) ? null : new GLFWGammaRamp(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 173 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 182 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 191 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 192 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 202 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 208 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static GLFWGammaRamp mallocStack() {
/* 214 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 216 */   public static GLFWGammaRamp callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 218 */   public static GLFWGammaRamp mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 220 */   public static GLFWGammaRamp callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 222 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 224 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 226 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 228 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLFWGammaRamp malloc(MemoryStack paramMemoryStack) {
/* 236 */     return new GLFWGammaRamp(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLFWGammaRamp calloc(MemoryStack paramMemoryStack) {
/* 245 */     return new GLFWGammaRamp(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 255 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 265 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static ShortBuffer nred(long paramLong) {
/* 271 */     return MemoryUtil.memShortBuffer(MemoryUtil.memGetAddress(paramLong + RED), nsize(paramLong));
/*     */   } public static ShortBuffer ngreen(long paramLong) {
/* 273 */     return MemoryUtil.memShortBuffer(MemoryUtil.memGetAddress(paramLong + GREEN), nsize(paramLong));
/*     */   } public static ShortBuffer nblue(long paramLong) {
/* 275 */     return MemoryUtil.memShortBuffer(MemoryUtil.memGetAddress(paramLong + BLUE), nsize(paramLong));
/*     */   } public static int nsize(long paramLong) {
/* 277 */     return UNSAFE.getInt(null, paramLong + SIZE);
/*     */   }
/*     */   public static void nred(long paramLong, ShortBuffer paramShortBuffer) {
/* 280 */     MemoryUtil.memPutAddress(paramLong + RED, MemoryUtil.memAddress(paramShortBuffer));
/*     */   } public static void ngreen(long paramLong, ShortBuffer paramShortBuffer) {
/* 282 */     MemoryUtil.memPutAddress(paramLong + GREEN, MemoryUtil.memAddress(paramShortBuffer));
/*     */   } public static void nblue(long paramLong, ShortBuffer paramShortBuffer) {
/* 284 */     MemoryUtil.memPutAddress(paramLong + BLUE, MemoryUtil.memAddress(paramShortBuffer));
/*     */   } public static void nsize(long paramLong, int paramInt) {
/* 286 */     UNSAFE.putInt(null, paramLong + SIZE, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 294 */     Checks.check(MemoryUtil.memGetAddress(paramLong + RED));
/* 295 */     Checks.check(MemoryUtil.memGetAddress(paramLong + GREEN));
/* 296 */     Checks.check(MemoryUtil.memGetAddress(paramLong + BLUE));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<GLFWGammaRamp, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 304 */     private static final GLFWGammaRamp ELEMENT_FACTORY = GLFWGammaRamp.create(-1L);
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
/* 316 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / GLFWGammaRamp.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 320 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 324 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 329 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected GLFWGammaRamp getElementFactory() {
/* 334 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("unsigned short *")
/*     */     public ShortBuffer red() {
/* 339 */       return GLFWGammaRamp.nred(address());
/*     */     } @NativeType("unsigned short *")
/*     */     public ShortBuffer green() {
/* 342 */       return GLFWGammaRamp.ngreen(address());
/*     */     } @NativeType("unsigned short *")
/*     */     public ShortBuffer blue() {
/* 345 */       return GLFWGammaRamp.nblue(address());
/*     */     } @NativeType("unsigned int")
/*     */     public int size() {
/* 348 */       return GLFWGammaRamp.nsize(address());
/*     */     }
/*     */     public Buffer red(@NativeType("unsigned short *") ShortBuffer param1ShortBuffer) {
/* 351 */       GLFWGammaRamp.nred(address(), param1ShortBuffer); return this;
/*     */     } public Buffer green(@NativeType("unsigned short *") ShortBuffer param1ShortBuffer) {
/* 353 */       GLFWGammaRamp.ngreen(address(), param1ShortBuffer); return this;
/*     */     } public Buffer blue(@NativeType("unsigned short *") ShortBuffer param1ShortBuffer) {
/* 355 */       GLFWGammaRamp.nblue(address(), param1ShortBuffer); return this;
/*     */     } public Buffer size(@NativeType("unsigned int") int param1Int) {
/* 357 */       GLFWGammaRamp.nsize(address(), param1Int); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFWGammaRamp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */