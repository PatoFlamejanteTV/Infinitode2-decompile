/*     */ package org.lwjgl.system.linux.liburing;
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
/*     */ @NativeType("struct io_uring_file_index_range")
/*     */ public class IOURingFileIndexRange
/*     */   extends Struct<IOURingFileIndexRange>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int OFF;
/*     */   public static final int LEN;
/*     */   public static final int RESV;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  54 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(4), __member(8) })).getSize();
/*  55 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  57 */     OFF = layout.offsetof(0);
/*  58 */     LEN = layout.offsetof(1);
/*  59 */     RESV = layout.offsetof(2);
/*     */   }
/*     */   
/*     */   protected IOURingFileIndexRange(long paramLong, ByteBuffer paramByteBuffer) {
/*  63 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingFileIndexRange create(long paramLong, ByteBuffer paramByteBuffer) {
/*  68 */     return new IOURingFileIndexRange(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingFileIndexRange(ByteBuffer paramByteBuffer) {
/*  78 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  82 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u32")
/*     */   public int off() {
/*  86 */     return noff(address());
/*     */   } @NativeType("__u32")
/*     */   public int len() {
/*  89 */     return nlen(address());
/*     */   } @NativeType("__u64")
/*     */   public long resv() {
/*  92 */     return nresv(address());
/*     */   }
/*     */   public IOURingFileIndexRange off(@NativeType("__u32") int paramInt) {
/*  95 */     noff(address(), paramInt); return this;
/*     */   } public IOURingFileIndexRange len(@NativeType("__u32") int paramInt) {
/*  97 */     nlen(address(), paramInt); return this;
/*     */   } public IOURingFileIndexRange resv(@NativeType("__u64") long paramLong) {
/*  99 */     nresv(address(), paramLong); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingFileIndexRange set(int paramInt1, int paramInt2, long paramLong) {
/* 107 */     off(paramInt1);
/* 108 */     len(paramInt2);
/* 109 */     resv(paramLong);
/*     */     
/* 111 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingFileIndexRange set(IOURingFileIndexRange paramIOURingFileIndexRange) {
/* 122 */     MemoryUtil.memCopy(paramIOURingFileIndexRange.address(), address(), SIZEOF);
/* 123 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingFileIndexRange malloc() {
/* 130 */     return new IOURingFileIndexRange(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingFileIndexRange calloc() {
/* 135 */     return new IOURingFileIndexRange(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingFileIndexRange create() {
/* 140 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 141 */     return new IOURingFileIndexRange(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingFileIndexRange create(long paramLong) {
/* 146 */     return new IOURingFileIndexRange(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingFileIndexRange createSafe(long paramLong) {
/* 152 */     return (paramLong == 0L) ? null : new IOURingFileIndexRange(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 161 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 170 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 179 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 180 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 190 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 196 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingFileIndexRange malloc(MemoryStack paramMemoryStack) {
/* 205 */     return new IOURingFileIndexRange(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingFileIndexRange calloc(MemoryStack paramMemoryStack) {
/* 214 */     return new IOURingFileIndexRange(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 224 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 234 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int noff(long paramLong) {
/* 240 */     return UNSAFE.getInt(null, paramLong + OFF);
/*     */   } public static int nlen(long paramLong) {
/* 242 */     return UNSAFE.getInt(null, paramLong + LEN);
/*     */   } public static long nresv(long paramLong) {
/* 244 */     return UNSAFE.getLong(null, paramLong + RESV);
/*     */   }
/*     */   public static void noff(long paramLong, int paramInt) {
/* 247 */     UNSAFE.putInt(null, paramLong + OFF, paramInt);
/*     */   } public static void nlen(long paramLong, int paramInt) {
/* 249 */     UNSAFE.putInt(null, paramLong + LEN, paramInt);
/*     */   } public static void nresv(long paramLong1, long paramLong2) {
/* 251 */     UNSAFE.putLong(null, paramLong1 + RESV, paramLong2);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingFileIndexRange, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 258 */     private static final IOURingFileIndexRange ELEMENT_FACTORY = IOURingFileIndexRange.create(-1L);
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
/* 270 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / IOURingFileIndexRange.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 274 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 278 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 283 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingFileIndexRange getElementFactory() {
/* 288 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u32")
/*     */     public int off() {
/* 293 */       return IOURingFileIndexRange.noff(address());
/*     */     } @NativeType("__u32")
/*     */     public int len() {
/* 296 */       return IOURingFileIndexRange.nlen(address());
/*     */     } @NativeType("__u64")
/*     */     public long resv() {
/* 299 */       return IOURingFileIndexRange.nresv(address());
/*     */     }
/*     */     public Buffer off(@NativeType("__u32") int param1Int) {
/* 302 */       IOURingFileIndexRange.noff(address(), param1Int); return this;
/*     */     } public Buffer len(@NativeType("__u32") int param1Int) {
/* 304 */       IOURingFileIndexRange.nlen(address(), param1Int); return this;
/*     */     } public Buffer resv(@NativeType("__u64") long param1Long) {
/* 306 */       IOURingFileIndexRange.nresv(address(), param1Long); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\liburing\IOURingFileIndexRange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */