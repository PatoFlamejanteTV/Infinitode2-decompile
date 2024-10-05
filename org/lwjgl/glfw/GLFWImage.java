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
/*     */ @NativeType("struct GLFWimage")
/*     */ public class GLFWImage
/*     */   extends Struct<GLFWImage>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int WIDTH;
/*     */   public static final int HEIGHT;
/*     */   public static final int PIXELS;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  57 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(4), __member(POINTER_SIZE) })).getSize();
/*  58 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  60 */     WIDTH = layout.offsetof(0);
/*  61 */     HEIGHT = layout.offsetof(1);
/*  62 */     PIXELS = layout.offsetof(2);
/*     */   }
/*     */   
/*     */   protected GLFWImage(long paramLong, ByteBuffer paramByteBuffer) {
/*  66 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected GLFWImage create(long paramLong, ByteBuffer paramByteBuffer) {
/*  71 */     return new GLFWImage(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GLFWImage(ByteBuffer paramByteBuffer) {
/*  81 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  85 */     return SIZEOF;
/*     */   }
/*     */   public int width() {
/*  88 */     return nwidth(address());
/*     */   } public int height() {
/*  90 */     return nheight(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("unsigned char *")
/*     */   public ByteBuffer pixels(int paramInt) {
/*  97 */     return npixels(address(), paramInt);
/*     */   }
/*     */   public GLFWImage width(int paramInt) {
/* 100 */     nwidth(address(), paramInt); return this;
/*     */   } public GLFWImage height(int paramInt) {
/* 102 */     nheight(address(), paramInt); return this;
/*     */   } public GLFWImage pixels(@NativeType("unsigned char *") ByteBuffer paramByteBuffer) {
/* 104 */     npixels(address(), paramByteBuffer); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GLFWImage set(int paramInt1, int paramInt2, ByteBuffer paramByteBuffer) {
/* 112 */     width(paramInt1);
/* 113 */     height(paramInt2);
/* 114 */     pixels(paramByteBuffer);
/*     */     
/* 116 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GLFWImage set(GLFWImage paramGLFWImage) {
/* 127 */     MemoryUtil.memCopy(paramGLFWImage.address(), address(), SIZEOF);
/* 128 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLFWImage malloc() {
/* 135 */     return new GLFWImage(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GLFWImage calloc() {
/* 140 */     return new GLFWImage(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GLFWImage create() {
/* 145 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 146 */     return new GLFWImage(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GLFWImage create(long paramLong) {
/* 151 */     return new GLFWImage(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLFWImage createSafe(long paramLong) {
/* 157 */     return (paramLong == 0L) ? null : new GLFWImage(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 166 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 175 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 184 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 185 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 195 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 201 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static GLFWImage mallocStack() {
/* 207 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 209 */   public static GLFWImage callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 211 */   public static GLFWImage mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 213 */   public static GLFWImage callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 215 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 217 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 219 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 221 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLFWImage malloc(MemoryStack paramMemoryStack) {
/* 229 */     return new GLFWImage(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLFWImage calloc(MemoryStack paramMemoryStack) {
/* 238 */     return new GLFWImage(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 248 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 258 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nwidth(long paramLong) {
/* 264 */     return UNSAFE.getInt(null, paramLong + WIDTH);
/*     */   } public static int nheight(long paramLong) {
/* 266 */     return UNSAFE.getInt(null, paramLong + HEIGHT);
/*     */   } public static ByteBuffer npixels(long paramLong, int paramInt) {
/* 268 */     return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(paramLong + PIXELS), paramInt);
/*     */   }
/*     */   public static void nwidth(long paramLong, int paramInt) {
/* 271 */     UNSAFE.putInt(null, paramLong + WIDTH, paramInt);
/*     */   } public static void nheight(long paramLong, int paramInt) {
/* 273 */     UNSAFE.putInt(null, paramLong + HEIGHT, paramInt);
/*     */   } public static void npixels(long paramLong, ByteBuffer paramByteBuffer) {
/* 275 */     MemoryUtil.memPutAddress(paramLong + PIXELS, MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 283 */     Checks.check(MemoryUtil.memGetAddress(paramLong + PIXELS));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<GLFWImage, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 291 */     private static final GLFWImage ELEMENT_FACTORY = GLFWImage.create(-1L);
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
/* 303 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / GLFWImage.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 307 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 311 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 316 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected GLFWImage getElementFactory() {
/* 321 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int width() {
/* 325 */       return GLFWImage.nwidth(address());
/*     */     } public int height() {
/* 327 */       return GLFWImage.nheight(address());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     @NativeType("unsigned char *")
/*     */     public ByteBuffer pixels(int param1Int) {
/* 334 */       return GLFWImage.npixels(address(), param1Int);
/*     */     }
/*     */     public Buffer width(int param1Int) {
/* 337 */       GLFWImage.nwidth(address(), param1Int); return this;
/*     */     } public Buffer height(int param1Int) {
/* 339 */       GLFWImage.nheight(address(), param1Int); return this;
/*     */     } public Buffer pixels(@NativeType("unsigned char *") ByteBuffer param1ByteBuffer) {
/* 341 */       GLFWImage.npixels(address(), param1ByteBuffer); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFWImage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */