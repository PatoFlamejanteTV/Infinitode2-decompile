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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RECT
/*     */   extends Struct<RECT>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int LEFT;
/*     */   public static final int TOP;
/*     */   public static final int RIGHT;
/*     */   public static final int BOTTOM;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  54 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(4), __member(4), __member(4) })).getSize();
/*  55 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  57 */     LEFT = layout.offsetof(0);
/*  58 */     TOP = layout.offsetof(1);
/*  59 */     RIGHT = layout.offsetof(2);
/*  60 */     BOTTOM = layout.offsetof(3);
/*     */   }
/*     */   
/*     */   protected RECT(long paramLong, ByteBuffer paramByteBuffer) {
/*  64 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected RECT create(long paramLong, ByteBuffer paramByteBuffer) {
/*  69 */     return new RECT(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RECT(ByteBuffer paramByteBuffer) {
/*  79 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  83 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("LONG")
/*     */   public int left() {
/*  87 */     return nleft(address());
/*     */   } @NativeType("LONG")
/*     */   public int top() {
/*  90 */     return ntop(address());
/*     */   } @NativeType("LONG")
/*     */   public int right() {
/*  93 */     return nright(address());
/*     */   } @NativeType("LONG")
/*     */   public int bottom() {
/*  96 */     return nbottom(address());
/*     */   }
/*     */   public RECT left(@NativeType("LONG") int paramInt) {
/*  99 */     nleft(address(), paramInt); return this;
/*     */   } public RECT top(@NativeType("LONG") int paramInt) {
/* 101 */     ntop(address(), paramInt); return this;
/*     */   } public RECT right(@NativeType("LONG") int paramInt) {
/* 103 */     nright(address(), paramInt); return this;
/*     */   } public RECT bottom(@NativeType("LONG") int paramInt) {
/* 105 */     nbottom(address(), paramInt); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RECT set(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 114 */     left(paramInt1);
/* 115 */     top(paramInt2);
/* 116 */     right(paramInt3);
/* 117 */     bottom(paramInt4);
/*     */     
/* 119 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RECT set(RECT paramRECT) {
/* 130 */     MemoryUtil.memCopy(paramRECT.address(), address(), SIZEOF);
/* 131 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static RECT malloc() {
/* 138 */     return new RECT(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static RECT calloc() {
/* 143 */     return new RECT(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static RECT create() {
/* 148 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 149 */     return new RECT(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static RECT create(long paramLong) {
/* 154 */     return new RECT(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static RECT createSafe(long paramLong) {
/* 160 */     return (paramLong == 0L) ? null : new RECT(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 169 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 178 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 187 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 188 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 198 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 204 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static RECT mallocStack() {
/* 210 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 212 */   public static RECT callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 214 */   public static RECT mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 216 */   public static RECT callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 218 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 220 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 222 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 224 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static RECT malloc(MemoryStack paramMemoryStack) {
/* 232 */     return new RECT(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static RECT calloc(MemoryStack paramMemoryStack) {
/* 241 */     return new RECT(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 251 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 261 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nleft(long paramLong) {
/* 267 */     return UNSAFE.getInt(null, paramLong + LEFT);
/*     */   } public static int ntop(long paramLong) {
/* 269 */     return UNSAFE.getInt(null, paramLong + TOP);
/*     */   } public static int nright(long paramLong) {
/* 271 */     return UNSAFE.getInt(null, paramLong + RIGHT);
/*     */   } public static int nbottom(long paramLong) {
/* 273 */     return UNSAFE.getInt(null, paramLong + BOTTOM);
/*     */   }
/*     */   public static void nleft(long paramLong, int paramInt) {
/* 276 */     UNSAFE.putInt(null, paramLong + LEFT, paramInt);
/*     */   } public static void ntop(long paramLong, int paramInt) {
/* 278 */     UNSAFE.putInt(null, paramLong + TOP, paramInt);
/*     */   } public static void nright(long paramLong, int paramInt) {
/* 280 */     UNSAFE.putInt(null, paramLong + RIGHT, paramInt);
/*     */   } public static void nbottom(long paramLong, int paramInt) {
/* 282 */     UNSAFE.putInt(null, paramLong + BOTTOM, paramInt);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<RECT, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 289 */     private static final RECT ELEMENT_FACTORY = RECT.create(-1L);
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
/* 301 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / RECT.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 305 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 309 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 314 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected RECT getElementFactory() {
/* 319 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("LONG")
/*     */     public int left() {
/* 324 */       return RECT.nleft(address());
/*     */     } @NativeType("LONG")
/*     */     public int top() {
/* 327 */       return RECT.ntop(address());
/*     */     } @NativeType("LONG")
/*     */     public int right() {
/* 330 */       return RECT.nright(address());
/*     */     } @NativeType("LONG")
/*     */     public int bottom() {
/* 333 */       return RECT.nbottom(address());
/*     */     }
/*     */     public Buffer left(@NativeType("LONG") int param1Int) {
/* 336 */       RECT.nleft(address(), param1Int); return this;
/*     */     } public Buffer top(@NativeType("LONG") int param1Int) {
/* 338 */       RECT.ntop(address(), param1Int); return this;
/*     */     } public Buffer right(@NativeType("LONG") int param1Int) {
/* 340 */       RECT.nright(address(), param1Int); return this;
/*     */     } public Buffer bottom(@NativeType("LONG") int param1Int) {
/* 342 */       RECT.nbottom(address(), param1Int); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\windows\RECT.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */