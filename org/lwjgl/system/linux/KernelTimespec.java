/*     */ package org.lwjgl.system.linux;
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
/*     */ @NativeType("struct __kernel_timespec")
/*     */ public class KernelTimespec
/*     */   extends Struct<KernelTimespec>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TV_SEC;
/*     */   public static final int TV_NSEC;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  47 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(8), __member(8) })).getSize();
/*  48 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  50 */     TV_SEC = layout.offsetof(0);
/*  51 */     TV_NSEC = layout.offsetof(1);
/*     */   }
/*     */   
/*     */   protected KernelTimespec(long paramLong, ByteBuffer paramByteBuffer) {
/*  55 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected KernelTimespec create(long paramLong, ByteBuffer paramByteBuffer) {
/*  60 */     return new KernelTimespec(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public KernelTimespec(ByteBuffer paramByteBuffer) {
/*  70 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  74 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("int64_t")
/*     */   public long tv_sec() {
/*  78 */     return ntv_sec(address());
/*     */   } @NativeType("long long")
/*     */   public long tv_nsec() {
/*  81 */     return ntv_nsec(address());
/*     */   }
/*     */   public KernelTimespec tv_sec(@NativeType("int64_t") long paramLong) {
/*  84 */     ntv_sec(address(), paramLong); return this;
/*     */   } public KernelTimespec tv_nsec(@NativeType("long long") long paramLong) {
/*  86 */     ntv_nsec(address(), paramLong); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public KernelTimespec set(long paramLong1, long paramLong2) {
/*  93 */     tv_sec(paramLong1);
/*  94 */     tv_nsec(paramLong2);
/*     */     
/*  96 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public KernelTimespec set(KernelTimespec paramKernelTimespec) {
/* 107 */     MemoryUtil.memCopy(paramKernelTimespec.address(), address(), SIZEOF);
/* 108 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static KernelTimespec malloc() {
/* 115 */     return new KernelTimespec(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static KernelTimespec calloc() {
/* 120 */     return new KernelTimespec(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static KernelTimespec create() {
/* 125 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 126 */     return new KernelTimespec(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static KernelTimespec create(long paramLong) {
/* 131 */     return new KernelTimespec(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static KernelTimespec createSafe(long paramLong) {
/* 137 */     return (paramLong == 0L) ? null : new KernelTimespec(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 146 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 155 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 164 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 165 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 175 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 181 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static KernelTimespec malloc(MemoryStack paramMemoryStack) {
/* 190 */     return new KernelTimespec(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static KernelTimespec calloc(MemoryStack paramMemoryStack) {
/* 199 */     return new KernelTimespec(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 209 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 219 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long ntv_sec(long paramLong) {
/* 225 */     return UNSAFE.getLong(null, paramLong + TV_SEC);
/*     */   } public static long ntv_nsec(long paramLong) {
/* 227 */     return UNSAFE.getLong(null, paramLong + TV_NSEC);
/*     */   }
/*     */   public static void ntv_sec(long paramLong1, long paramLong2) {
/* 230 */     UNSAFE.putLong(null, paramLong1 + TV_SEC, paramLong2);
/*     */   } public static void ntv_nsec(long paramLong1, long paramLong2) {
/* 232 */     UNSAFE.putLong(null, paramLong1 + TV_NSEC, paramLong2);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<KernelTimespec, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 239 */     private static final KernelTimespec ELEMENT_FACTORY = KernelTimespec.create(-1L);
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
/* 251 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / KernelTimespec.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 255 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 259 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 264 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected KernelTimespec getElementFactory() {
/* 269 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("int64_t")
/*     */     public long tv_sec() {
/* 274 */       return KernelTimespec.ntv_sec(address());
/*     */     } @NativeType("long long")
/*     */     public long tv_nsec() {
/* 277 */       return KernelTimespec.ntv_nsec(address());
/*     */     }
/*     */     public Buffer tv_sec(@NativeType("int64_t") long param1Long) {
/* 280 */       KernelTimespec.ntv_sec(address(), param1Long); return this;
/*     */     } public Buffer tv_nsec(@NativeType("long long") long param1Long) {
/* 282 */       KernelTimespec.ntv_nsec(address(), param1Long); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\KernelTimespec.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */