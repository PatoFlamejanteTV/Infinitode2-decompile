/*     */ package org.lwjgl.system.libffi;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeResource;
/*     */ import org.lwjgl.system.NativeType;
/*     */ import org.lwjgl.system.Pointer;
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
/*     */ @NativeType("struct ffi_type")
/*     */ public class FFIType
/*     */   extends Struct<FFIType>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int SIZE;
/*     */   public static final int ALIGNMENT;
/*     */   public static final int TYPE;
/*     */   public static final int ELEMENTS;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  55 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(POINTER_SIZE), __member(2), __member(2), __member(POINTER_SIZE) })).getSize();
/*  56 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  58 */     SIZE = layout.offsetof(0);
/*  59 */     ALIGNMENT = layout.offsetof(1);
/*  60 */     TYPE = layout.offsetof(2);
/*  61 */     ELEMENTS = layout.offsetof(3);
/*     */   }
/*     */   
/*     */   protected FFIType(long paramLong, ByteBuffer paramByteBuffer) {
/*  65 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected FFIType create(long paramLong, ByteBuffer paramByteBuffer) {
/*  70 */     return new FFIType(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FFIType(ByteBuffer paramByteBuffer) {
/*  80 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  84 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("size_t")
/*     */   public long size() {
/*  88 */     return nsize(address());
/*     */   } @NativeType("unsigned short")
/*     */   public short alignment() {
/*  91 */     return nalignment(address());
/*     */   } @NativeType("unsigned short")
/*     */   public short type() {
/*  94 */     return ntype(address());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   public PointerBuffer elements(int paramInt) {
/* 102 */     return nelements(address(), paramInt);
/*     */   }
/*     */   public FFIType size(@NativeType("size_t") long paramLong) {
/* 105 */     nsize(address(), paramLong); return this;
/*     */   } public FFIType alignment(@NativeType("unsigned short") short paramShort) {
/* 107 */     nalignment(address(), paramShort); return this;
/*     */   } public FFIType type(@NativeType("unsigned short") short paramShort) {
/* 109 */     ntype(address(), paramShort); return this;
/*     */   } public FFIType elements(@NativeType("ffi_type *") PointerBuffer paramPointerBuffer) {
/* 111 */     nelements(address(), paramPointerBuffer); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FFIType set(long paramLong, short paramShort1, short paramShort2, PointerBuffer paramPointerBuffer) {
/* 120 */     size(paramLong);
/* 121 */     alignment(paramShort1);
/* 122 */     type(paramShort2);
/* 123 */     elements(paramPointerBuffer);
/*     */     
/* 125 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FFIType set(FFIType paramFFIType) {
/* 136 */     MemoryUtil.memCopy(paramFFIType.address(), address(), SIZEOF);
/* 137 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FFIType malloc() {
/* 144 */     return new FFIType(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static FFIType calloc() {
/* 149 */     return new FFIType(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static FFIType create() {
/* 154 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 155 */     return new FFIType(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static FFIType create(long paramLong) {
/* 160 */     return new FFIType(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static FFIType createSafe(long paramLong) {
/* 166 */     return (paramLong == 0L) ? null : new FFIType(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 175 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 184 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 193 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 194 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 204 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 210 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FFIType malloc(MemoryStack paramMemoryStack) {
/* 219 */     return new FFIType(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FFIType calloc(MemoryStack paramMemoryStack) {
/* 228 */     return new FFIType(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 238 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 248 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nsize(long paramLong) {
/* 254 */     return MemoryUtil.memGetAddress(paramLong + SIZE);
/*     */   } public static short nalignment(long paramLong) {
/* 256 */     return UNSAFE.getShort(null, paramLong + ALIGNMENT);
/*     */   } public static short ntype(long paramLong) {
/* 258 */     return UNSAFE.getShort(null, paramLong + TYPE);
/*     */   } public static PointerBuffer nelements(long paramLong, int paramInt) {
/* 260 */     return MemoryUtil.memPointerBufferSafe(MemoryUtil.memGetAddress(paramLong + ELEMENTS), paramInt);
/*     */   }
/*     */   public static void nsize(long paramLong1, long paramLong2) {
/* 263 */     MemoryUtil.memPutAddress(paramLong1 + SIZE, paramLong2);
/*     */   } public static void nalignment(long paramLong, short paramShort) {
/* 265 */     UNSAFE.putShort(null, paramLong + ALIGNMENT, paramShort);
/*     */   } public static void ntype(long paramLong, short paramShort) {
/* 267 */     UNSAFE.putShort(null, paramLong + TYPE, paramShort);
/*     */   } public static void nelements(long paramLong, PointerBuffer paramPointerBuffer) {
/* 269 */     MemoryUtil.memPutAddress(paramLong + ELEMENTS, MemoryUtil.memAddressSafe((Pointer)paramPointerBuffer));
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<FFIType, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 276 */     private static final FFIType ELEMENT_FACTORY = FFIType.create(-1L);
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
/* 288 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / FFIType.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 292 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 296 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 301 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected FFIType getElementFactory() {
/* 306 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("size_t")
/*     */     public long size() {
/* 311 */       return FFIType.nsize(address());
/*     */     } @NativeType("unsigned short")
/*     */     public short alignment() {
/* 314 */       return FFIType.nalignment(address());
/*     */     } @NativeType("unsigned short")
/*     */     public short type() {
/* 317 */       return FFIType.ntype(address());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @NativeType("ffi_type *")
/*     */     public PointerBuffer elements(int param1Int) {
/* 325 */       return FFIType.nelements(address(), param1Int);
/*     */     }
/*     */     public Buffer size(@NativeType("size_t") long param1Long) {
/* 328 */       FFIType.nsize(address(), param1Long); return this;
/*     */     } public Buffer alignment(@NativeType("unsigned short") short param1Short) {
/* 330 */       FFIType.nalignment(address(), param1Short); return this;
/*     */     } public Buffer type(@NativeType("unsigned short") short param1Short) {
/* 332 */       FFIType.ntype(address(), param1Short); return this;
/*     */     } public Buffer elements(@NativeType("ffi_type *") PointerBuffer param1PointerBuffer) {
/* 334 */       FFIType.nelements(address(), param1PointerBuffer); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\libffi\FFIType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */