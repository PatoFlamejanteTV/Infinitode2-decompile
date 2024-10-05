/*     */ package org.lwjgl.system.linux;
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
/*     */ @NativeType("union epoll_data_t")
/*     */ public class EpollData
/*     */   extends Struct<EpollData>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int PTR;
/*     */   public static final int FD;
/*     */   public static final int U32;
/*     */   public static final int U64;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  54 */     SIZEOF = (layout = __union(new Struct.Member[] { __member(POINTER_SIZE), __member(4), __member(4), __member(8) })).getSize();
/*  55 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  57 */     PTR = layout.offsetof(0);
/*  58 */     FD = layout.offsetof(1);
/*  59 */     U32 = layout.offsetof(2);
/*  60 */     U64 = layout.offsetof(3);
/*     */   }
/*     */   
/*     */   protected EpollData(long paramLong, ByteBuffer paramByteBuffer) {
/*  64 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected EpollData create(long paramLong, ByteBuffer paramByteBuffer) {
/*  69 */     return new EpollData(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EpollData(ByteBuffer paramByteBuffer) {
/*  79 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  83 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("void *")
/*     */   public long ptr() {
/*  87 */     return nptr(address());
/*     */   } public int fd() {
/*  89 */     return nfd(address());
/*     */   } @NativeType("uint32_t")
/*     */   public int u32() {
/*  92 */     return nu32(address());
/*     */   } @NativeType("uint64_t")
/*     */   public long u64() {
/*  95 */     return nu64(address());
/*     */   }
/*     */   public EpollData ptr(@NativeType("void *") long paramLong) {
/*  98 */     nptr(address(), paramLong); return this;
/*     */   } public EpollData fd(int paramInt) {
/* 100 */     nfd(address(), paramInt); return this;
/*     */   } public EpollData u32(@NativeType("uint32_t") int paramInt) {
/* 102 */     nu32(address(), paramInt); return this;
/*     */   } public EpollData u64(@NativeType("uint64_t") long paramLong) {
/* 104 */     nu64(address(), paramLong); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EpollData set(EpollData paramEpollData) {
/* 114 */     MemoryUtil.memCopy(paramEpollData.address(), address(), SIZEOF);
/* 115 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static EpollData malloc() {
/* 122 */     return new EpollData(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static EpollData calloc() {
/* 127 */     return new EpollData(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static EpollData create() {
/* 132 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 133 */     return new EpollData(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static EpollData create(long paramLong) {
/* 138 */     return new EpollData(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static EpollData createSafe(long paramLong) {
/* 144 */     return (paramLong == 0L) ? null : new EpollData(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 153 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 162 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 171 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 172 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 182 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 188 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static EpollData malloc(MemoryStack paramMemoryStack) {
/* 197 */     return new EpollData(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static EpollData calloc(MemoryStack paramMemoryStack) {
/* 206 */     return new EpollData(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 216 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 226 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nptr(long paramLong) {
/* 232 */     return MemoryUtil.memGetAddress(paramLong + PTR);
/*     */   } public static int nfd(long paramLong) {
/* 234 */     return UNSAFE.getInt(null, paramLong + FD);
/*     */   } public static int nu32(long paramLong) {
/* 236 */     return UNSAFE.getInt(null, paramLong + U32);
/*     */   } public static long nu64(long paramLong) {
/* 238 */     return UNSAFE.getLong(null, paramLong + U64);
/*     */   }
/*     */   public static void nptr(long paramLong1, long paramLong2) {
/* 241 */     MemoryUtil.memPutAddress(paramLong1 + PTR, Checks.check(paramLong2));
/*     */   } public static void nfd(long paramLong, int paramInt) {
/* 243 */     UNSAFE.putInt(null, paramLong + FD, paramInt);
/*     */   } public static void nu32(long paramLong, int paramInt) {
/* 245 */     UNSAFE.putInt(null, paramLong + U32, paramInt);
/*     */   } public static void nu64(long paramLong1, long paramLong2) {
/* 247 */     UNSAFE.putLong(null, paramLong1 + U64, paramLong2);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<EpollData, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 254 */     private static final EpollData ELEMENT_FACTORY = EpollData.create(-1L);
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
/* 266 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / EpollData.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 270 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 274 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 279 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected EpollData getElementFactory() {
/* 284 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("void *")
/*     */     public long ptr() {
/* 289 */       return EpollData.nptr(address());
/*     */     } public int fd() {
/* 291 */       return EpollData.nfd(address());
/*     */     } @NativeType("uint32_t")
/*     */     public int u32() {
/* 294 */       return EpollData.nu32(address());
/*     */     } @NativeType("uint64_t")
/*     */     public long u64() {
/* 297 */       return EpollData.nu64(address());
/*     */     }
/*     */     public Buffer ptr(@NativeType("void *") long param1Long) {
/* 300 */       EpollData.nptr(address(), param1Long); return this;
/*     */     } public Buffer fd(int param1Int) {
/* 302 */       EpollData.nfd(address(), param1Int); return this;
/*     */     } public Buffer u32(@NativeType("uint32_t") int param1Int) {
/* 304 */       EpollData.nu32(address(), param1Int); return this;
/*     */     } public Buffer u64(@NativeType("uint64_t") long param1Long) {
/* 306 */       EpollData.nu64(address(), param1Long); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\EpollData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */