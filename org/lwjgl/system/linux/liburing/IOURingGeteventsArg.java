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
/*     */ @NativeType("struct io_uring_getevents_arg")
/*     */ public class IOURingGeteventsArg
/*     */   extends Struct<IOURingGeteventsArg>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int SIGMASK;
/*     */   public static final int SIGMASK_SZ;
/*     */   public static final int PAD;
/*     */   public static final int TS;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  53 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(8), __member(4), __member(4), __member(8) })).getSize();
/*  54 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  56 */     SIGMASK = layout.offsetof(0);
/*  57 */     SIGMASK_SZ = layout.offsetof(1);
/*  58 */     PAD = layout.offsetof(2);
/*  59 */     TS = layout.offsetof(3);
/*     */   }
/*     */   
/*     */   protected IOURingGeteventsArg(long paramLong, ByteBuffer paramByteBuffer) {
/*  63 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingGeteventsArg create(long paramLong, ByteBuffer paramByteBuffer) {
/*  68 */     return new IOURingGeteventsArg(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingGeteventsArg(ByteBuffer paramByteBuffer) {
/*  78 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  82 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u64")
/*     */   public long sigmask() {
/*  86 */     return nsigmask(address());
/*     */   } @NativeType("__u32")
/*     */   public int sigmask_sz() {
/*  89 */     return nsigmask_sz(address());
/*     */   } @NativeType("__u32")
/*     */   public int pad() {
/*  92 */     return npad(address());
/*     */   } @NativeType("__u64")
/*     */   public long ts() {
/*  95 */     return nts(address());
/*     */   }
/*     */   public IOURingGeteventsArg sigmask(@NativeType("__u64") long paramLong) {
/*  98 */     nsigmask(address(), paramLong); return this;
/*     */   } public IOURingGeteventsArg sigmask_sz(@NativeType("__u32") int paramInt) {
/* 100 */     nsigmask_sz(address(), paramInt); return this;
/*     */   } public IOURingGeteventsArg pad(@NativeType("__u32") int paramInt) {
/* 102 */     npad(address(), paramInt); return this;
/*     */   } public IOURingGeteventsArg ts(@NativeType("__u64") long paramLong) {
/* 104 */     nts(address(), paramLong); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingGeteventsArg set(long paramLong1, int paramInt1, int paramInt2, long paramLong2) {
/* 113 */     sigmask(paramLong1);
/* 114 */     sigmask_sz(paramInt1);
/* 115 */     pad(paramInt2);
/* 116 */     ts(paramLong2);
/*     */     
/* 118 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingGeteventsArg set(IOURingGeteventsArg paramIOURingGeteventsArg) {
/* 129 */     MemoryUtil.memCopy(paramIOURingGeteventsArg.address(), address(), SIZEOF);
/* 130 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingGeteventsArg malloc() {
/* 137 */     return new IOURingGeteventsArg(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingGeteventsArg calloc() {
/* 142 */     return new IOURingGeteventsArg(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingGeteventsArg create() {
/* 147 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 148 */     return new IOURingGeteventsArg(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingGeteventsArg create(long paramLong) {
/* 153 */     return new IOURingGeteventsArg(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingGeteventsArg createSafe(long paramLong) {
/* 159 */     return (paramLong == 0L) ? null : new IOURingGeteventsArg(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 168 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 177 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 186 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 187 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 197 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 203 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingGeteventsArg malloc(MemoryStack paramMemoryStack) {
/* 212 */     return new IOURingGeteventsArg(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingGeteventsArg calloc(MemoryStack paramMemoryStack) {
/* 221 */     return new IOURingGeteventsArg(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 231 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 241 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nsigmask(long paramLong) {
/* 247 */     return UNSAFE.getLong(null, paramLong + SIGMASK);
/*     */   } public static int nsigmask_sz(long paramLong) {
/* 249 */     return UNSAFE.getInt(null, paramLong + SIGMASK_SZ);
/*     */   } public static int npad(long paramLong) {
/* 251 */     return UNSAFE.getInt(null, paramLong + PAD);
/*     */   } public static long nts(long paramLong) {
/* 253 */     return UNSAFE.getLong(null, paramLong + TS);
/*     */   }
/*     */   public static void nsigmask(long paramLong1, long paramLong2) {
/* 256 */     UNSAFE.putLong(null, paramLong1 + SIGMASK, paramLong2);
/*     */   } public static void nsigmask_sz(long paramLong, int paramInt) {
/* 258 */     UNSAFE.putInt(null, paramLong + SIGMASK_SZ, paramInt);
/*     */   } public static void npad(long paramLong, int paramInt) {
/* 260 */     UNSAFE.putInt(null, paramLong + PAD, paramInt);
/*     */   } public static void nts(long paramLong1, long paramLong2) {
/* 262 */     UNSAFE.putLong(null, paramLong1 + TS, paramLong2);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingGeteventsArg, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 269 */     private static final IOURingGeteventsArg ELEMENT_FACTORY = IOURingGeteventsArg.create(-1L);
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
/* 281 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / IOURingGeteventsArg.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 285 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 289 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 294 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingGeteventsArg getElementFactory() {
/* 299 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u64")
/*     */     public long sigmask() {
/* 304 */       return IOURingGeteventsArg.nsigmask(address());
/*     */     } @NativeType("__u32")
/*     */     public int sigmask_sz() {
/* 307 */       return IOURingGeteventsArg.nsigmask_sz(address());
/*     */     } @NativeType("__u32")
/*     */     public int pad() {
/* 310 */       return IOURingGeteventsArg.npad(address());
/*     */     } @NativeType("__u64")
/*     */     public long ts() {
/* 313 */       return IOURingGeteventsArg.nts(address());
/*     */     }
/*     */     public Buffer sigmask(@NativeType("__u64") long param1Long) {
/* 316 */       IOURingGeteventsArg.nsigmask(address(), param1Long); return this;
/*     */     } public Buffer sigmask_sz(@NativeType("__u32") int param1Int) {
/* 318 */       IOURingGeteventsArg.nsigmask_sz(address(), param1Int); return this;
/*     */     } public Buffer pad(@NativeType("__u32") int param1Int) {
/* 320 */       IOURingGeteventsArg.npad(address(), param1Int); return this;
/*     */     } public Buffer ts(@NativeType("__u64") long param1Long) {
/* 322 */       IOURingGeteventsArg.nts(address(), param1Long); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\liburing\IOURingGeteventsArg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */