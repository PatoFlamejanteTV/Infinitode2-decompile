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
/*     */ @NativeType("struct io_uring_rsrc_update")
/*     */ public class IOURingRSRCUpdate
/*     */   extends Struct<IOURingRSRCUpdate>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int OFFSET;
/*     */   public static final int RESV;
/*     */   public static final int DATA;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  50 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(4), __member(8) })).getSize();
/*  51 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  53 */     OFFSET = layout.offsetof(0);
/*  54 */     RESV = layout.offsetof(1);
/*  55 */     DATA = layout.offsetof(2);
/*     */   }
/*     */   
/*     */   protected IOURingRSRCUpdate(long paramLong, ByteBuffer paramByteBuffer) {
/*  59 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingRSRCUpdate create(long paramLong, ByteBuffer paramByteBuffer) {
/*  64 */     return new IOURingRSRCUpdate(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingRSRCUpdate(ByteBuffer paramByteBuffer) {
/*  74 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  78 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u32")
/*     */   public int offset() {
/*  82 */     return noffset(address());
/*     */   } @NativeType("__u32")
/*     */   public int resv() {
/*  85 */     return nresv(address());
/*     */   } @NativeType("__u64")
/*     */   public long data() {
/*  88 */     return ndata(address());
/*     */   }
/*     */   public IOURingRSRCUpdate offset(@NativeType("__u32") int paramInt) {
/*  91 */     noffset(address(), paramInt); return this;
/*     */   } public IOURingRSRCUpdate resv(@NativeType("__u32") int paramInt) {
/*  93 */     nresv(address(), paramInt); return this;
/*     */   } public IOURingRSRCUpdate data(@NativeType("__u64") long paramLong) {
/*  95 */     ndata(address(), paramLong); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingRSRCUpdate set(int paramInt1, int paramInt2, long paramLong) {
/* 103 */     offset(paramInt1);
/* 104 */     resv(paramInt2);
/* 105 */     data(paramLong);
/*     */     
/* 107 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingRSRCUpdate set(IOURingRSRCUpdate paramIOURingRSRCUpdate) {
/* 118 */     MemoryUtil.memCopy(paramIOURingRSRCUpdate.address(), address(), SIZEOF);
/* 119 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingRSRCUpdate malloc() {
/* 126 */     return new IOURingRSRCUpdate(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingRSRCUpdate calloc() {
/* 131 */     return new IOURingRSRCUpdate(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingRSRCUpdate create() {
/* 136 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 137 */     return new IOURingRSRCUpdate(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingRSRCUpdate create(long paramLong) {
/* 142 */     return new IOURingRSRCUpdate(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingRSRCUpdate createSafe(long paramLong) {
/* 148 */     return (paramLong == 0L) ? null : new IOURingRSRCUpdate(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 157 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 166 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 175 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 176 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 186 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 192 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingRSRCUpdate malloc(MemoryStack paramMemoryStack) {
/* 201 */     return new IOURingRSRCUpdate(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingRSRCUpdate calloc(MemoryStack paramMemoryStack) {
/* 210 */     return new IOURingRSRCUpdate(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 220 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 230 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int noffset(long paramLong) {
/* 236 */     return UNSAFE.getInt(null, paramLong + OFFSET);
/*     */   } public static int nresv(long paramLong) {
/* 238 */     return UNSAFE.getInt(null, paramLong + RESV);
/*     */   } public static long ndata(long paramLong) {
/* 240 */     return UNSAFE.getLong(null, paramLong + DATA);
/*     */   }
/*     */   public static void noffset(long paramLong, int paramInt) {
/* 243 */     UNSAFE.putInt(null, paramLong + OFFSET, paramInt);
/*     */   } public static void nresv(long paramLong, int paramInt) {
/* 245 */     UNSAFE.putInt(null, paramLong + RESV, paramInt);
/*     */   } public static void ndata(long paramLong1, long paramLong2) {
/* 247 */     UNSAFE.putLong(null, paramLong1 + DATA, paramLong2);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingRSRCUpdate, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 254 */     private static final IOURingRSRCUpdate ELEMENT_FACTORY = IOURingRSRCUpdate.create(-1L);
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
/* 266 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / IOURingRSRCUpdate.SIZEOF);
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
/*     */     protected IOURingRSRCUpdate getElementFactory() {
/* 284 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u32")
/*     */     public int offset() {
/* 289 */       return IOURingRSRCUpdate.noffset(address());
/*     */     } @NativeType("__u32")
/*     */     public int resv() {
/* 292 */       return IOURingRSRCUpdate.nresv(address());
/*     */     } @NativeType("__u64")
/*     */     public long data() {
/* 295 */       return IOURingRSRCUpdate.ndata(address());
/*     */     }
/*     */     public Buffer offset(@NativeType("__u32") int param1Int) {
/* 298 */       IOURingRSRCUpdate.noffset(address(), param1Int); return this;
/*     */     } public Buffer resv(@NativeType("__u32") int param1Int) {
/* 300 */       IOURingRSRCUpdate.nresv(address(), param1Int); return this;
/*     */     } public Buffer data(@NativeType("__u64") long param1Long) {
/* 302 */       IOURingRSRCUpdate.ndata(address(), param1Long); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\liburing\IOURingRSRCUpdate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */