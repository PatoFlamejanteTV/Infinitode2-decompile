/*     */ package org.lwjgl.system.libffi;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
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
/*     */ @NativeType("struct ffi_closure")
/*     */ public class FFIClosure
/*     */   extends Struct<FFIClosure>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int CIF;
/*     */   public static final int FUN;
/*     */   public static final int USER_DATA;
/*     */   
/*     */   static {
/*  46 */     MemoryStack memoryStack = MemoryStack.stackPush(); Throwable throwable = null; 
/*     */     try { IntBuffer intBuffer;
/*  48 */       SIZEOF = offsets(MemoryUtil.memAddress(intBuffer = memoryStack.mallocInt(4)));
/*     */       
/*  50 */       CIF = intBuffer.get(0);
/*  51 */       FUN = intBuffer.get(1);
/*  52 */       USER_DATA = intBuffer.get(2);
/*     */       
/*  54 */       ALIGNOF = intBuffer.get(3); } catch (Throwable throwable2) { Throwable throwable1 = null; throw throwable1; }
/*  55 */     finally { if (memoryStack != null) if (throwable != null) { try { memoryStack.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  } else { throwable1.close(); }
/*     */           }
/*     */   
/*     */   }
/*     */   
/*     */   protected FFIClosure(long paramLong, ByteBuffer paramByteBuffer) {
/*  61 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected FFIClosure create(long paramLong, ByteBuffer paramByteBuffer) {
/*  66 */     return new FFIClosure(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FFIClosure(ByteBuffer paramByteBuffer) {
/*  76 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  80 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("ffi_cif *")
/*     */   public FFICIF cif() {
/*  84 */     return ncif(address());
/*     */   } @NativeType("void (*)(ffi_cif*,void*,void**,void*)")
/*     */   public long fun() {
/*  87 */     return nfun(address());
/*     */   } @NativeType("void *")
/*     */   public long user_data() {
/*  90 */     return nuser_data(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static FFIClosure malloc() {
/*  96 */     return new FFIClosure(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static FFIClosure calloc() {
/* 101 */     return new FFIClosure(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static FFIClosure create() {
/* 106 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 107 */     return new FFIClosure(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static FFIClosure create(long paramLong) {
/* 112 */     return new FFIClosure(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static FFIClosure createSafe(long paramLong) {
/* 118 */     return (paramLong == 0L) ? null : new FFIClosure(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 127 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 136 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 145 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 146 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 156 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 162 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FFIClosure malloc(MemoryStack paramMemoryStack) {
/* 171 */     return new FFIClosure(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FFIClosure calloc(MemoryStack paramMemoryStack) {
/* 180 */     return new FFIClosure(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 190 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 200 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static FFICIF ncif(long paramLong) {
/* 206 */     return FFICIF.create(MemoryUtil.memGetAddress(paramLong + CIF));
/*     */   } public static long nfun(long paramLong) {
/* 208 */     return MemoryUtil.memGetAddress(paramLong + FUN);
/*     */   } public static long nuser_data(long paramLong) {
/* 210 */     return MemoryUtil.memGetAddress(paramLong + USER_DATA);
/*     */   }
/*     */   
/*     */   private static native int offsets(long paramLong);
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<FFIClosure, Buffer> implements NativeResource {
/* 217 */     private static final FFIClosure ELEMENT_FACTORY = FFIClosure.create(-1L);
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
/* 229 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / FFIClosure.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 233 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 237 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 242 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected FFIClosure getElementFactory() {
/* 247 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("ffi_cif *")
/*     */     public FFICIF cif() {
/* 252 */       return FFIClosure.ncif(address());
/*     */     } @NativeType("void (*)(ffi_cif*,void*,void**,void*)")
/*     */     public long fun() {
/* 255 */       return FFIClosure.nfun(address());
/*     */     } @NativeType("void *")
/*     */     public long user_data() {
/* 258 */       return FFIClosure.nuser_data(address());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\libffi\FFIClosure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */