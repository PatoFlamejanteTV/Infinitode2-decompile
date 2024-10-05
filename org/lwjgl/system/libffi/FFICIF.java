/*     */ package org.lwjgl.system.libffi;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.PointerBuffer;
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
/*     */ @NativeType("struct ffi_cif")
/*     */ public class FFICIF
/*     */   extends Struct<FFICIF>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int ABI;
/*     */   public static final int NARGS;
/*     */   public static final int ARG_TYPES;
/*     */   public static final int RTYPE;
/*     */   public static final int BYTES;
/*     */   public static final int FLAGS;
/*     */   
/*     */   static {
/*  52 */     MemoryStack memoryStack = MemoryStack.stackPush(); Throwable throwable = null; 
/*     */     try { IntBuffer intBuffer;
/*  54 */       SIZEOF = offsets(MemoryUtil.memAddress(intBuffer = memoryStack.mallocInt(7)));
/*     */       
/*  56 */       ABI = intBuffer.get(0);
/*  57 */       NARGS = intBuffer.get(1);
/*  58 */       ARG_TYPES = intBuffer.get(2);
/*  59 */       RTYPE = intBuffer.get(3);
/*  60 */       BYTES = intBuffer.get(4);
/*  61 */       FLAGS = intBuffer.get(5);
/*     */       
/*  63 */       ALIGNOF = intBuffer.get(6); } catch (Throwable throwable2) { Throwable throwable1 = null; throw throwable1; }
/*  64 */     finally { if (memoryStack != null) if (throwable != null) { try { memoryStack.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  } else { throwable1.close(); }
/*     */           }
/*     */   
/*     */   }
/*     */   
/*     */   protected FFICIF(long paramLong, ByteBuffer paramByteBuffer) {
/*  70 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected FFICIF create(long paramLong, ByteBuffer paramByteBuffer) {
/*  75 */     return new FFICIF(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FFICIF(ByteBuffer paramByteBuffer) {
/*  85 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  89 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("ffi_abi")
/*     */   public int abi() {
/*  93 */     return nabi(address());
/*     */   } @NativeType("unsigned")
/*     */   public int nargs() {
/*  96 */     return nnargs(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type **")
/*     */   public PointerBuffer arg_types(int paramInt) {
/* 103 */     return narg_types(address(), paramInt);
/*     */   } @NativeType("ffi_type *")
/*     */   public FFIType rtype() {
/* 106 */     return nrtype(address());
/*     */   } @NativeType("unsigned")
/*     */   public int bytes() {
/* 109 */     return nbytes(address());
/*     */   } @NativeType("unsigned")
/*     */   public int flags() {
/* 112 */     return nflags(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static FFICIF malloc() {
/* 118 */     return new FFICIF(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static FFICIF calloc() {
/* 123 */     return new FFICIF(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static FFICIF create() {
/* 128 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 129 */     return new FFICIF(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static FFICIF create(long paramLong) {
/* 134 */     return new FFICIF(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static FFICIF createSafe(long paramLong) {
/* 140 */     return (paramLong == 0L) ? null : new FFICIF(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 149 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 158 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 167 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 168 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 178 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 184 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FFICIF malloc(MemoryStack paramMemoryStack) {
/* 193 */     return new FFICIF(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FFICIF calloc(MemoryStack paramMemoryStack) {
/* 202 */     return new FFICIF(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 212 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 222 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nabi(long paramLong) {
/* 228 */     return UNSAFE.getInt(null, paramLong + ABI);
/*     */   } public static int nnargs(long paramLong) {
/* 230 */     return UNSAFE.getInt(null, paramLong + NARGS);
/*     */   } public static PointerBuffer narg_types(long paramLong, int paramInt) {
/* 232 */     return MemoryUtil.memPointerBuffer(MemoryUtil.memGetAddress(paramLong + ARG_TYPES), paramInt);
/*     */   } public static FFIType nrtype(long paramLong) {
/* 234 */     return FFIType.create(MemoryUtil.memGetAddress(paramLong + RTYPE));
/*     */   } public static int nbytes(long paramLong) {
/* 236 */     return UNSAFE.getInt(null, paramLong + BYTES);
/*     */   } public static int nflags(long paramLong) {
/* 238 */     return UNSAFE.getInt(null, paramLong + FLAGS);
/*     */   }
/*     */   
/*     */   private static native int offsets(long paramLong);
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<FFICIF, Buffer> implements NativeResource {
/* 245 */     private static final FFICIF ELEMENT_FACTORY = FFICIF.create(-1L);
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
/* 257 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / FFICIF.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 261 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 265 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 270 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected FFICIF getElementFactory() {
/* 275 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("ffi_abi")
/*     */     public int abi() {
/* 280 */       return FFICIF.nabi(address());
/*     */     } @NativeType("unsigned")
/*     */     public int nargs() {
/* 283 */       return FFICIF.nnargs(address());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     @NativeType("ffi_type **")
/*     */     public PointerBuffer arg_types(int param1Int) {
/* 290 */       return FFICIF.narg_types(address(), param1Int);
/*     */     } @NativeType("ffi_type *")
/*     */     public FFIType rtype() {
/* 293 */       return FFICIF.nrtype(address());
/*     */     } @NativeType("unsigned")
/*     */     public int bytes() {
/* 296 */       return FFICIF.nbytes(address());
/*     */     } @NativeType("unsigned")
/*     */     public int flags() {
/* 299 */       return FFICIF.nflags(address());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\libffi\FFICIF.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */