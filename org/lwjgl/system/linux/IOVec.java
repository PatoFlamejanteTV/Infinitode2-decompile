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
/*     */ @NativeType("struct iovec")
/*     */ public class IOVec
/*     */   extends Struct<IOVec>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int IOV_BASE;
/*     */   public static final int IOV_LEN;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  47 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(POINTER_SIZE), __member(POINTER_SIZE) })).getSize();
/*  48 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  50 */     IOV_BASE = layout.offsetof(0);
/*  51 */     IOV_LEN = layout.offsetof(1);
/*     */   }
/*     */   
/*     */   protected IOVec(long paramLong, ByteBuffer paramByteBuffer) {
/*  55 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOVec create(long paramLong, ByteBuffer paramByteBuffer) {
/*  60 */     return new IOVec(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOVec(ByteBuffer paramByteBuffer) {
/*  70 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  74 */     return SIZEOF;
/*     */   }
/*     */   
/*     */   @NativeType("void *")
/*     */   public ByteBuffer iov_base() {
/*  79 */     return niov_base(address());
/*     */   } @NativeType("size_t")
/*     */   public long iov_len() {
/*  82 */     return niov_len(address());
/*     */   }
/*     */   public IOVec iov_base(@NativeType("void *") ByteBuffer paramByteBuffer) {
/*  85 */     niov_base(address(), paramByteBuffer); return this;
/*     */   } public IOVec iov_len(@NativeType("size_t") long paramLong) {
/*  87 */     niov_len(address(), paramLong); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOVec set(ByteBuffer paramByteBuffer, long paramLong) {
/*  94 */     iov_base(paramByteBuffer);
/*  95 */     iov_len(paramLong);
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
/*     */   public IOVec set(IOVec paramIOVec) {
/* 108 */     MemoryUtil.memCopy(paramIOVec.address(), address(), SIZEOF);
/* 109 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOVec malloc() {
/* 116 */     return new IOVec(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOVec calloc() {
/* 121 */     return new IOVec(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOVec create() {
/* 126 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 127 */     return new IOVec(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOVec create(long paramLong) {
/* 132 */     return new IOVec(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOVec createSafe(long paramLong) {
/* 138 */     return (paramLong == 0L) ? null : new IOVec(paramLong, null);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOVec malloc(MemoryStack paramMemoryStack) {
/* 191 */     return new IOVec(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOVec calloc(MemoryStack paramMemoryStack) {
/* 200 */     return new IOVec(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 210 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 220 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static ByteBuffer niov_base(long paramLong) {
/* 226 */     return MemoryUtil.memByteBufferSafe(MemoryUtil.memGetAddress(paramLong + IOV_BASE), (int)niov_len(paramLong));
/*     */   } public static long niov_len(long paramLong) {
/* 228 */     return MemoryUtil.memGetAddress(paramLong + IOV_LEN);
/*     */   }
/*     */   public static void niov_base(long paramLong, ByteBuffer paramByteBuffer) {
/* 231 */     MemoryUtil.memPutAddress(paramLong + IOV_BASE, MemoryUtil.memAddressSafe(paramByteBuffer));
/*     */   } public static void niov_len(long paramLong1, long paramLong2) {
/* 233 */     MemoryUtil.memPutAddress(paramLong1 + IOV_LEN, paramLong2);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOVec, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 240 */     private static final IOVec ELEMENT_FACTORY = IOVec.create(-1L);
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
/* 252 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / IOVec.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 256 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 260 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 265 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOVec getElementFactory() {
/* 270 */       return ELEMENT_FACTORY;
/*     */     }
/*     */ 
/*     */     
/*     */     @NativeType("void *")
/*     */     public ByteBuffer iov_base() {
/* 276 */       return IOVec.niov_base(address());
/*     */     } @NativeType("size_t")
/*     */     public long iov_len() {
/* 279 */       return IOVec.niov_len(address());
/*     */     }
/*     */     public Buffer iov_base(@NativeType("void *") ByteBuffer param1ByteBuffer) {
/* 282 */       IOVec.niov_base(address(), param1ByteBuffer); return this;
/*     */     } public Buffer iov_len(@NativeType("size_t") long param1Long) {
/* 284 */       IOVec.niov_len(address(), param1Long); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\IOVec.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */