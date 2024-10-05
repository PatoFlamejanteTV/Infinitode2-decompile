/*     */ package org.lwjgl.glfw;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
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
/*     */ @NativeType("struct GLFWgamepadstate")
/*     */ public class GLFWGamepadState
/*     */   extends Struct<GLFWGamepadState>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int BUTTONS;
/*     */   public static final int AXES;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  52 */     SIZEOF = (layout = __struct(new Struct.Member[] { __array(1, 15), __array(4, 6) })).getSize();
/*  53 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  55 */     BUTTONS = layout.offsetof(0);
/*  56 */     AXES = layout.offsetof(1);
/*     */   }
/*     */   
/*     */   protected GLFWGamepadState(long paramLong, ByteBuffer paramByteBuffer) {
/*  60 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected GLFWGamepadState create(long paramLong, ByteBuffer paramByteBuffer) {
/*  65 */     return new GLFWGamepadState(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GLFWGamepadState(ByteBuffer paramByteBuffer) {
/*  75 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  79 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("unsigned char[15]")
/*     */   public ByteBuffer buttons() {
/*  83 */     return nbuttons(address());
/*     */   } @NativeType("unsigned char")
/*     */   public byte buttons(int paramInt) {
/*  86 */     return nbuttons(address(), paramInt);
/*     */   } @NativeType("float[6]")
/*     */   public FloatBuffer axes() {
/*  89 */     return naxes(address());
/*     */   } public float axes(int paramInt) {
/*  91 */     return naxes(address(), paramInt);
/*     */   }
/*     */   public GLFWGamepadState buttons(@NativeType("unsigned char[15]") ByteBuffer paramByteBuffer) {
/*  94 */     nbuttons(address(), paramByteBuffer); return this;
/*     */   } public GLFWGamepadState buttons(int paramInt, @NativeType("unsigned char") byte paramByte) {
/*  96 */     nbuttons(address(), paramInt, paramByte); return this;
/*     */   } public GLFWGamepadState axes(@NativeType("float[6]") FloatBuffer paramFloatBuffer) {
/*  98 */     naxes(address(), paramFloatBuffer); return this;
/*     */   } public GLFWGamepadState axes(int paramInt, float paramFloat) {
/* 100 */     naxes(address(), paramInt, paramFloat); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GLFWGamepadState set(ByteBuffer paramByteBuffer, FloatBuffer paramFloatBuffer) {
/* 107 */     buttons(paramByteBuffer);
/* 108 */     axes(paramFloatBuffer);
/*     */     
/* 110 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GLFWGamepadState set(GLFWGamepadState paramGLFWGamepadState) {
/* 121 */     MemoryUtil.memCopy(paramGLFWGamepadState.address(), address(), SIZEOF);
/* 122 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLFWGamepadState malloc() {
/* 129 */     return new GLFWGamepadState(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GLFWGamepadState calloc() {
/* 134 */     return new GLFWGamepadState(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GLFWGamepadState create() {
/* 139 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 140 */     return new GLFWGamepadState(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GLFWGamepadState create(long paramLong) {
/* 145 */     return new GLFWGamepadState(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLFWGamepadState createSafe(long paramLong) {
/* 151 */     return (paramLong == 0L) ? null : new GLFWGamepadState(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 160 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 169 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 178 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 179 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 189 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 195 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static GLFWGamepadState mallocStack() {
/* 201 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 203 */   public static GLFWGamepadState callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 205 */   public static GLFWGamepadState mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 207 */   public static GLFWGamepadState callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 209 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 211 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 213 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 215 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLFWGamepadState malloc(MemoryStack paramMemoryStack) {
/* 223 */     return new GLFWGamepadState(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLFWGamepadState calloc(MemoryStack paramMemoryStack) {
/* 232 */     return new GLFWGamepadState(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 242 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 252 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static ByteBuffer nbuttons(long paramLong) {
/* 258 */     return MemoryUtil.memByteBuffer(paramLong + BUTTONS, 15);
/*     */   }
/*     */   public static byte nbuttons(long paramLong, int paramInt) {
/* 261 */     return UNSAFE.getByte(null, paramLong + BUTTONS + Checks.check(paramInt, 15));
/*     */   }
/*     */   public static FloatBuffer naxes(long paramLong) {
/* 264 */     return MemoryUtil.memFloatBuffer(paramLong + AXES, 6);
/*     */   }
/*     */   public static float naxes(long paramLong, int paramInt) {
/* 267 */     return UNSAFE.getFloat(null, paramLong + AXES + (Checks.check(paramInt, 6) << 2L));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void nbuttons(long paramLong, ByteBuffer paramByteBuffer) {
/* 272 */     if (Checks.CHECKS) Checks.checkGT(paramByteBuffer, 15); 
/* 273 */     MemoryUtil.memCopy(MemoryUtil.memAddress(paramByteBuffer), paramLong + BUTTONS, paramByteBuffer.remaining());
/*     */   }
/*     */   
/*     */   public static void nbuttons(long paramLong, int paramInt, byte paramByte) {
/* 277 */     UNSAFE.putByte(null, paramLong + BUTTONS + Checks.check(paramInt, 15), paramByte);
/*     */   }
/*     */   
/*     */   public static void naxes(long paramLong, FloatBuffer paramFloatBuffer) {
/* 281 */     if (Checks.CHECKS) Checks.checkGT(paramFloatBuffer, 6); 
/* 282 */     MemoryUtil.memCopy(MemoryUtil.memAddress(paramFloatBuffer), paramLong + AXES, (paramFloatBuffer.remaining() << 2));
/*     */   }
/*     */   
/*     */   public static void naxes(long paramLong, int paramInt, float paramFloat) {
/* 286 */     UNSAFE.putFloat(null, paramLong + AXES + (Checks.check(paramInt, 6) << 2L), paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<GLFWGamepadState, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 294 */     private static final GLFWGamepadState ELEMENT_FACTORY = GLFWGamepadState.create(-1L);
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
/* 306 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / GLFWGamepadState.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 310 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 314 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 319 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected GLFWGamepadState getElementFactory() {
/* 324 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("unsigned char[15]")
/*     */     public ByteBuffer buttons() {
/* 329 */       return GLFWGamepadState.nbuttons(address());
/*     */     } @NativeType("unsigned char")
/*     */     public byte buttons(int param1Int) {
/* 332 */       return GLFWGamepadState.nbuttons(address(), param1Int);
/*     */     } @NativeType("float[6]")
/*     */     public FloatBuffer axes() {
/* 335 */       return GLFWGamepadState.naxes(address());
/*     */     } public float axes(int param1Int) {
/* 337 */       return GLFWGamepadState.naxes(address(), param1Int);
/*     */     }
/*     */     public Buffer buttons(@NativeType("unsigned char[15]") ByteBuffer param1ByteBuffer) {
/* 340 */       GLFWGamepadState.nbuttons(address(), param1ByteBuffer); return this;
/*     */     } public Buffer buttons(int param1Int, @NativeType("unsigned char") byte param1Byte) {
/* 342 */       GLFWGamepadState.nbuttons(address(), param1Int, param1Byte); return this;
/*     */     } public Buffer axes(@NativeType("float[6]") FloatBuffer param1FloatBuffer) {
/* 344 */       GLFWGamepadState.naxes(address(), param1FloatBuffer); return this;
/*     */     } public Buffer axes(int param1Int, float param1Float) {
/* 346 */       GLFWGamepadState.naxes(address(), param1Int, param1Float); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFWGamepadState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */