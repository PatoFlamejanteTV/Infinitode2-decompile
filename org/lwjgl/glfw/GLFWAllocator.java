/*     */ package org.lwjgl.glfw;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @NativeType("struct GLFWallocator")
/*     */ public class GLFWAllocator
/*     */   extends Struct<GLFWAllocator>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int ALLOCATE;
/*     */   public static final int REALLOCATE;
/*     */   public static final int DEALLOCATE;
/*     */   public static final int USER;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  58 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(POINTER_SIZE), __member(POINTER_SIZE), __member(POINTER_SIZE), __member(POINTER_SIZE) })).getSize();
/*  59 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  61 */     ALLOCATE = layout.offsetof(0);
/*  62 */     REALLOCATE = layout.offsetof(1);
/*  63 */     DEALLOCATE = layout.offsetof(2);
/*  64 */     USER = layout.offsetof(3);
/*     */   }
/*     */   
/*     */   protected GLFWAllocator(long paramLong, ByteBuffer paramByteBuffer) {
/*  68 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected GLFWAllocator create(long paramLong, ByteBuffer paramByteBuffer) {
/*  73 */     return new GLFWAllocator(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GLFWAllocator(ByteBuffer paramByteBuffer) {
/*  83 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  87 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("GLFWallocatefun")
/*     */   public GLFWAllocateCallback allocate() {
/*  91 */     return nallocate(address());
/*     */   } @NativeType("GLFWreallocatefun")
/*     */   public GLFWReallocateCallback reallocate() {
/*  94 */     return nreallocate(address());
/*     */   } @NativeType("GLFWdeallocatefun")
/*     */   public GLFWDeallocateCallback deallocate() {
/*  97 */     return ndeallocate(address());
/*     */   } @NativeType("void *")
/*     */   public long user() {
/* 100 */     return nuser(address());
/*     */   }
/*     */   public GLFWAllocator allocate(@NativeType("GLFWallocatefun") GLFWAllocateCallbackI paramGLFWAllocateCallbackI) {
/* 103 */     nallocate(address(), paramGLFWAllocateCallbackI); return this;
/*     */   } public GLFWAllocator reallocate(@NativeType("GLFWreallocatefun") GLFWReallocateCallbackI paramGLFWReallocateCallbackI) {
/* 105 */     nreallocate(address(), paramGLFWReallocateCallbackI); return this;
/*     */   } public GLFWAllocator deallocate(@NativeType("GLFWdeallocatefun") GLFWDeallocateCallbackI paramGLFWDeallocateCallbackI) {
/* 107 */     ndeallocate(address(), paramGLFWDeallocateCallbackI); return this;
/*     */   } public GLFWAllocator user(@NativeType("void *") long paramLong) {
/* 109 */     nuser(address(), paramLong); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GLFWAllocator set(GLFWAllocateCallbackI paramGLFWAllocateCallbackI, GLFWReallocateCallbackI paramGLFWReallocateCallbackI, GLFWDeallocateCallbackI paramGLFWDeallocateCallbackI, long paramLong) {
/* 118 */     allocate(paramGLFWAllocateCallbackI);
/* 119 */     reallocate(paramGLFWReallocateCallbackI);
/* 120 */     deallocate(paramGLFWDeallocateCallbackI);
/* 121 */     user(paramLong);
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
/*     */   public GLFWAllocator set(GLFWAllocator paramGLFWAllocator) {
/* 134 */     MemoryUtil.memCopy(paramGLFWAllocator.address(), address(), SIZEOF);
/* 135 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLFWAllocator malloc() {
/* 142 */     return new GLFWAllocator(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GLFWAllocator calloc() {
/* 147 */     return new GLFWAllocator(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GLFWAllocator create() {
/* 152 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 153 */     return new GLFWAllocator(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GLFWAllocator create(long paramLong) {
/* 158 */     return new GLFWAllocator(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLFWAllocator createSafe(long paramLong) {
/* 164 */     return (paramLong == 0L) ? null : new GLFWAllocator(paramLong, null);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLFWAllocator malloc(MemoryStack paramMemoryStack) {
/* 217 */     return new GLFWAllocator(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLFWAllocator calloc(MemoryStack paramMemoryStack) {
/* 226 */     return new GLFWAllocator(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 236 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 246 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLFWAllocateCallback nallocate(long paramLong) {
/* 252 */     return GLFWAllocateCallback.create(MemoryUtil.memGetAddress(paramLong + ALLOCATE));
/*     */   } public static GLFWReallocateCallback nreallocate(long paramLong) {
/* 254 */     return GLFWReallocateCallback.create(MemoryUtil.memGetAddress(paramLong + REALLOCATE));
/*     */   } public static GLFWDeallocateCallback ndeallocate(long paramLong) {
/* 256 */     return GLFWDeallocateCallback.create(MemoryUtil.memGetAddress(paramLong + DEALLOCATE));
/*     */   } public static long nuser(long paramLong) {
/* 258 */     return MemoryUtil.memGetAddress(paramLong + USER);
/*     */   }
/*     */   public static void nallocate(long paramLong, GLFWAllocateCallbackI paramGLFWAllocateCallbackI) {
/* 261 */     MemoryUtil.memPutAddress(paramLong + ALLOCATE, paramGLFWAllocateCallbackI.address());
/*     */   } public static void nreallocate(long paramLong, GLFWReallocateCallbackI paramGLFWReallocateCallbackI) {
/* 263 */     MemoryUtil.memPutAddress(paramLong + REALLOCATE, paramGLFWReallocateCallbackI.address());
/*     */   } public static void ndeallocate(long paramLong, GLFWDeallocateCallbackI paramGLFWDeallocateCallbackI) {
/* 265 */     MemoryUtil.memPutAddress(paramLong + DEALLOCATE, paramGLFWDeallocateCallbackI.address());
/*     */   } public static void nuser(long paramLong1, long paramLong2) {
/* 267 */     MemoryUtil.memPutAddress(paramLong1 + USER, paramLong2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 275 */     Checks.check(MemoryUtil.memGetAddress(paramLong + ALLOCATE));
/* 276 */     Checks.check(MemoryUtil.memGetAddress(paramLong + REALLOCATE));
/* 277 */     Checks.check(MemoryUtil.memGetAddress(paramLong + DEALLOCATE));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<GLFWAllocator, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 285 */     private static final GLFWAllocator ELEMENT_FACTORY = GLFWAllocator.create(-1L);
/*     */ 
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
/* 297 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / GLFWAllocator.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 301 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 305 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 310 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected GLFWAllocator getElementFactory() {
/* 315 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("GLFWallocatefun")
/*     */     public GLFWAllocateCallback allocate() {
/* 320 */       return GLFWAllocator.nallocate(address());
/*     */     } @NativeType("GLFWreallocatefun")
/*     */     public GLFWReallocateCallback reallocate() {
/* 323 */       return GLFWAllocator.nreallocate(address());
/*     */     } @NativeType("GLFWdeallocatefun")
/*     */     public GLFWDeallocateCallback deallocate() {
/* 326 */       return GLFWAllocator.ndeallocate(address());
/*     */     } @NativeType("void *")
/*     */     public long user() {
/* 329 */       return GLFWAllocator.nuser(address());
/*     */     }
/*     */     public Buffer allocate(@NativeType("GLFWallocatefun") GLFWAllocateCallbackI param1GLFWAllocateCallbackI) {
/* 332 */       GLFWAllocator.nallocate(address(), param1GLFWAllocateCallbackI); return this;
/*     */     } public Buffer reallocate(@NativeType("GLFWreallocatefun") GLFWReallocateCallbackI param1GLFWReallocateCallbackI) {
/* 334 */       GLFWAllocator.nreallocate(address(), param1GLFWReallocateCallbackI); return this;
/*     */     } public Buffer deallocate(@NativeType("GLFWdeallocatefun") GLFWDeallocateCallbackI param1GLFWDeallocateCallbackI) {
/* 336 */       GLFWAllocator.ndeallocate(address(), param1GLFWDeallocateCallbackI); return this;
/*     */     } public Buffer user(@NativeType("void *") long param1Long) {
/* 338 */       GLFWAllocator.nuser(address(), param1Long); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFWAllocator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */