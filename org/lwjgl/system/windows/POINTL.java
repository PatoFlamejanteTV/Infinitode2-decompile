/*     */ package org.lwjgl.system.windows;
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
/*     */ public class POINTL
/*     */   extends Struct<POINTL>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int X;
/*     */   public static final int Y;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  48 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(4) })).getSize();
/*  49 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  51 */     X = layout.offsetof(0);
/*  52 */     Y = layout.offsetof(1);
/*     */   }
/*     */   
/*     */   protected POINTL(long paramLong, ByteBuffer paramByteBuffer) {
/*  56 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected POINTL create(long paramLong, ByteBuffer paramByteBuffer) {
/*  61 */     return new POINTL(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public POINTL(ByteBuffer paramByteBuffer) {
/*  71 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  75 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("LONG")
/*     */   public int x() {
/*  79 */     return nx(address());
/*     */   } @NativeType("LONG")
/*     */   public int y() {
/*  82 */     return ny(address());
/*     */   }
/*     */   public POINTL x(@NativeType("LONG") int paramInt) {
/*  85 */     nx(address(), paramInt); return this;
/*     */   } public POINTL y(@NativeType("LONG") int paramInt) {
/*  87 */     ny(address(), paramInt); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public POINTL set(int paramInt1, int paramInt2) {
/*  94 */     x(paramInt1);
/*  95 */     y(paramInt2);
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
/*     */   public POINTL set(POINTL paramPOINTL) {
/* 108 */     MemoryUtil.memCopy(paramPOINTL.address(), address(), SIZEOF);
/* 109 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static POINTL malloc() {
/* 116 */     return new POINTL(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static POINTL calloc() {
/* 121 */     return new POINTL(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static POINTL create() {
/* 126 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 127 */     return new POINTL(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static POINTL create(long paramLong) {
/* 132 */     return new POINTL(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static POINTL createSafe(long paramLong) {
/* 138 */     return (paramLong == 0L) ? null : new POINTL(paramLong, null);
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
/*     */   public static POINTL mallocStack() {
/* 188 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 190 */   public static POINTL callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 192 */   public static POINTL mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 194 */   public static POINTL callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
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
/*     */   public static POINTL malloc(MemoryStack paramMemoryStack) {
/* 210 */     return new POINTL(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static POINTL calloc(MemoryStack paramMemoryStack) {
/* 219 */     return new POINTL(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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
/*     */   public static int nx(long paramLong) {
/* 245 */     return UNSAFE.getInt(null, paramLong + X);
/*     */   } public static int ny(long paramLong) {
/* 247 */     return UNSAFE.getInt(null, paramLong + Y);
/*     */   }
/*     */   public static void nx(long paramLong, int paramInt) {
/* 250 */     UNSAFE.putInt(null, paramLong + X, paramInt);
/*     */   } public static void ny(long paramLong, int paramInt) {
/* 252 */     UNSAFE.putInt(null, paramLong + Y, paramInt);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<POINTL, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 259 */     private static final POINTL ELEMENT_FACTORY = POINTL.create(-1L);
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
/* 271 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / POINTL.SIZEOF);
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
/*     */     protected POINTL getElementFactory() {
/* 289 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("LONG")
/*     */     public int x() {
/* 294 */       return POINTL.nx(address());
/*     */     } @NativeType("LONG")
/*     */     public int y() {
/* 297 */       return POINTL.ny(address());
/*     */     }
/*     */     public Buffer x(@NativeType("LONG") int param1Int) {
/* 300 */       POINTL.nx(address(), param1Int); return this;
/*     */     } public Buffer y(@NativeType("LONG") int param1Int) {
/* 302 */       POINTL.ny(address(), param1Int); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\windows\POINTL.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */