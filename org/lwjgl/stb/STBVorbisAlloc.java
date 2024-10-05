/*     */ package org.lwjgl.stb;
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
/*     */ @NativeType("struct stb_vorbis_alloc")
/*     */ public class STBVorbisAlloc
/*     */   extends Struct<STBVorbisAlloc>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int ALLOC_BUFFER;
/*     */   public static final int ALLOC_BUFFER_LENGTH_IN_BYTES;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  50 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(POINTER_SIZE), __member(4) })).getSize();
/*  51 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  53 */     ALLOC_BUFFER = layout.offsetof(0);
/*  54 */     ALLOC_BUFFER_LENGTH_IN_BYTES = layout.offsetof(1);
/*     */   }
/*     */   
/*     */   protected STBVorbisAlloc(long paramLong, ByteBuffer paramByteBuffer) {
/*  58 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected STBVorbisAlloc create(long paramLong, ByteBuffer paramByteBuffer) {
/*  63 */     return new STBVorbisAlloc(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBVorbisAlloc(ByteBuffer paramByteBuffer) {
/*  73 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  77 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("char *")
/*     */   public ByteBuffer alloc_buffer() {
/*  81 */     return nalloc_buffer(address());
/*     */   } public int alloc_buffer_length_in_bytes() {
/*  83 */     return nalloc_buffer_length_in_bytes(address());
/*     */   }
/*     */   public STBVorbisAlloc alloc_buffer(@NativeType("char *") ByteBuffer paramByteBuffer) {
/*  86 */     nalloc_buffer(address(), paramByteBuffer); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBVorbisAlloc set(STBVorbisAlloc paramSTBVorbisAlloc) {
/*  96 */     MemoryUtil.memCopy(paramSTBVorbisAlloc.address(), address(), SIZEOF);
/*  97 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBVorbisAlloc malloc() {
/* 104 */     return new STBVorbisAlloc(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBVorbisAlloc calloc() {
/* 109 */     return new STBVorbisAlloc(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBVorbisAlloc create() {
/* 114 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 115 */     return new STBVorbisAlloc(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBVorbisAlloc create(long paramLong) {
/* 120 */     return new STBVorbisAlloc(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBVorbisAlloc createSafe(long paramLong) {
/* 126 */     return (paramLong == 0L) ? null : new STBVorbisAlloc(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 135 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 144 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 153 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 154 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 164 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 170 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static STBVorbisAlloc mallocStack() {
/* 176 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 178 */   public static STBVorbisAlloc callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 180 */   public static STBVorbisAlloc mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 182 */   public static STBVorbisAlloc callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 184 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 186 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 188 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 190 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBVorbisAlloc malloc(MemoryStack paramMemoryStack) {
/* 198 */     return new STBVorbisAlloc(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBVorbisAlloc calloc(MemoryStack paramMemoryStack) {
/* 207 */     return new STBVorbisAlloc(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 217 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 227 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static ByteBuffer nalloc_buffer(long paramLong) {
/* 233 */     return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(paramLong + ALLOC_BUFFER), nalloc_buffer_length_in_bytes(paramLong));
/*     */   } public static int nalloc_buffer_length_in_bytes(long paramLong) {
/* 235 */     return UNSAFE.getInt(null, paramLong + ALLOC_BUFFER_LENGTH_IN_BYTES);
/*     */   }
/*     */   public static void nalloc_buffer(long paramLong, ByteBuffer paramByteBuffer) {
/* 238 */     MemoryUtil.memPutAddress(paramLong + ALLOC_BUFFER, MemoryUtil.memAddress(paramByteBuffer)); nalloc_buffer_length_in_bytes(paramLong, paramByteBuffer.remaining());
/*     */   } public static void nalloc_buffer_length_in_bytes(long paramLong, int paramInt) {
/* 240 */     UNSAFE.putInt(null, paramLong + ALLOC_BUFFER_LENGTH_IN_BYTES, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 248 */     Checks.check(MemoryUtil.memGetAddress(paramLong + ALLOC_BUFFER));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<STBVorbisAlloc, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 256 */     private static final STBVorbisAlloc ELEMENT_FACTORY = STBVorbisAlloc.create(-1L);
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
/* 268 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / STBVorbisAlloc.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 272 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 276 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 281 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected STBVorbisAlloc getElementFactory() {
/* 286 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("char *")
/*     */     public ByteBuffer alloc_buffer() {
/* 291 */       return STBVorbisAlloc.nalloc_buffer(address());
/*     */     } public int alloc_buffer_length_in_bytes() {
/* 293 */       return STBVorbisAlloc.nalloc_buffer_length_in_bytes(address());
/*     */     }
/*     */     public Buffer alloc_buffer(@NativeType("char *") ByteBuffer param1ByteBuffer) {
/* 296 */       STBVorbisAlloc.nalloc_buffer(address(), param1ByteBuffer); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\stb\STBVorbisAlloc.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */