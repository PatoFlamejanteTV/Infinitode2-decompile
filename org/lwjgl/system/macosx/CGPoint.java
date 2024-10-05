/*     */ package org.lwjgl.system.macosx;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.BufferUtils;
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
/*     */ public class CGPoint
/*     */   extends Struct<CGPoint>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int X;
/*     */   public static final int Y;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  48 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(8), __member(8) })).getSize();
/*  49 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  51 */     X = layout.offsetof(0);
/*  52 */     Y = layout.offsetof(1);
/*     */   }
/*     */   
/*     */   protected CGPoint(long paramLong, ByteBuffer paramByteBuffer) {
/*  56 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected CGPoint create(long paramLong, ByteBuffer paramByteBuffer) {
/*  61 */     return new CGPoint(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CGPoint(ByteBuffer paramByteBuffer) {
/*  71 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  75 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("CGFloat")
/*     */   public double x() {
/*  79 */     return nx(address());
/*     */   } @NativeType("CGFloat")
/*     */   public double y() {
/*  82 */     return ny(address());
/*     */   }
/*     */   public CGPoint x(@NativeType("CGFloat") double paramDouble) {
/*  85 */     nx(address(), paramDouble); return this;
/*     */   } public CGPoint y(@NativeType("CGFloat") double paramDouble) {
/*  87 */     ny(address(), paramDouble); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CGPoint set(double paramDouble1, double paramDouble2) {
/*  94 */     x(paramDouble1);
/*  95 */     y(paramDouble2);
/*     */     
/*  97 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CGPoint set(CGPoint paramCGPoint) {
/* 108 */     MemoryUtil.memCopy(paramCGPoint.address(), address(), SIZEOF);
/* 109 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CGPoint malloc() {
/* 116 */     return new CGPoint(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static CGPoint calloc() {
/* 121 */     return new CGPoint(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static CGPoint create() {
/* 126 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 127 */     return new CGPoint(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static CGPoint create(long paramLong) {
/* 132 */     return new CGPoint(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static CGPoint createSafe(long paramLong) {
/* 138 */     return (paramLong == 0L) ? null : new CGPoint(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 147 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 156 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 165 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 166 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 176 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 182 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static CGPoint mallocStack() {
/* 188 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 190 */   public static CGPoint callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 192 */   public static CGPoint mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 194 */   public static CGPoint callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 196 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 198 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 200 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 202 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CGPoint malloc(MemoryStack paramMemoryStack) {
/* 210 */     return new CGPoint(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CGPoint calloc(MemoryStack paramMemoryStack) {
/* 219 */     return new CGPoint(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 229 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 239 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static double nx(long paramLong) {
/* 245 */     return UNSAFE.getDouble(null, paramLong + X);
/*     */   } public static double ny(long paramLong) {
/* 247 */     return UNSAFE.getDouble(null, paramLong + Y);
/*     */   }
/*     */   public static void nx(long paramLong, double paramDouble) {
/* 250 */     UNSAFE.putDouble(null, paramLong + X, paramDouble);
/*     */   } public static void ny(long paramLong, double paramDouble) {
/* 252 */     UNSAFE.putDouble(null, paramLong + Y, paramDouble);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<CGPoint, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 259 */     private static final CGPoint ELEMENT_FACTORY = CGPoint.create(-1L);
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
/* 271 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / CGPoint.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 275 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 279 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 284 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected CGPoint getElementFactory() {
/* 289 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("CGFloat")
/*     */     public double x() {
/* 294 */       return CGPoint.nx(address());
/*     */     } @NativeType("CGFloat")
/*     */     public double y() {
/* 297 */       return CGPoint.ny(address());
/*     */     }
/*     */     public Buffer x(@NativeType("CGFloat") double param1Double) {
/* 300 */       CGPoint.nx(address(), param1Double); return this;
/*     */     } public Buffer y(@NativeType("CGFloat") double param1Double) {
/* 302 */       CGPoint.ny(address(), param1Double); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\macosx\CGPoint.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */