/*     */ package org.lwjgl.stb;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @NativeType("struct stb_vorbis_info")
/*     */ public class STBVorbisInfo
/*     */   extends Struct<STBVorbisInfo>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int SAMPLE_RATE;
/*     */   public static final int CHANNELS;
/*     */   public static final int SETUP_MEMORY_REQUIRED;
/*     */   public static final int SETUP_TEMP_MEMORY_REQUIRED;
/*     */   public static final int TEMP_MEMORY_REQUIRED;
/*     */   public static final int MAX_FRAME_SIZE;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  61 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(4), __member(4), __member(4), __member(4), __member(4) })).getSize();
/*  62 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  64 */     SAMPLE_RATE = layout.offsetof(0);
/*  65 */     CHANNELS = layout.offsetof(1);
/*  66 */     SETUP_MEMORY_REQUIRED = layout.offsetof(2);
/*  67 */     SETUP_TEMP_MEMORY_REQUIRED = layout.offsetof(3);
/*  68 */     TEMP_MEMORY_REQUIRED = layout.offsetof(4);
/*  69 */     MAX_FRAME_SIZE = layout.offsetof(5);
/*     */   }
/*     */   
/*     */   protected STBVorbisInfo(long paramLong, ByteBuffer paramByteBuffer) {
/*  73 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected STBVorbisInfo create(long paramLong, ByteBuffer paramByteBuffer) {
/*  78 */     return new STBVorbisInfo(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBVorbisInfo(ByteBuffer paramByteBuffer) {
/*  88 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  92 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("unsigned int")
/*     */   public int sample_rate() {
/*  96 */     return nsample_rate(address());
/*     */   } public int channels() {
/*  98 */     return nchannels(address());
/*     */   } @NativeType("unsigned int")
/*     */   public int setup_memory_required() {
/* 101 */     return nsetup_memory_required(address());
/*     */   } @NativeType("unsigned int")
/*     */   public int setup_temp_memory_required() {
/* 104 */     return nsetup_temp_memory_required(address());
/*     */   } @NativeType("unsigned int")
/*     */   public int temp_memory_required() {
/* 107 */     return ntemp_memory_required(address());
/*     */   } public int max_frame_size() {
/* 109 */     return nmax_frame_size(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBVorbisInfo malloc() {
/* 115 */     return new STBVorbisInfo(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBVorbisInfo calloc() {
/* 120 */     return new STBVorbisInfo(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBVorbisInfo create() {
/* 125 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 126 */     return new STBVorbisInfo(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBVorbisInfo create(long paramLong) {
/* 131 */     return new STBVorbisInfo(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBVorbisInfo createSafe(long paramLong) {
/* 137 */     return (paramLong == 0L) ? null : new STBVorbisInfo(paramLong, null);
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
/*     */   @Deprecated
/*     */   public static STBVorbisInfo mallocStack() {
/* 187 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 189 */   public static STBVorbisInfo callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 191 */   public static STBVorbisInfo mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 193 */   public static STBVorbisInfo callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 195 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 197 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 199 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 201 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBVorbisInfo malloc(MemoryStack paramMemoryStack) {
/* 209 */     return new STBVorbisInfo(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBVorbisInfo calloc(MemoryStack paramMemoryStack) {
/* 218 */     return new STBVorbisInfo(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 228 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 238 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nsample_rate(long paramLong) {
/* 244 */     return UNSAFE.getInt(null, paramLong + SAMPLE_RATE);
/*     */   } public static int nchannels(long paramLong) {
/* 246 */     return UNSAFE.getInt(null, paramLong + CHANNELS);
/*     */   } public static int nsetup_memory_required(long paramLong) {
/* 248 */     return UNSAFE.getInt(null, paramLong + SETUP_MEMORY_REQUIRED);
/*     */   } public static int nsetup_temp_memory_required(long paramLong) {
/* 250 */     return UNSAFE.getInt(null, paramLong + SETUP_TEMP_MEMORY_REQUIRED);
/*     */   } public static int ntemp_memory_required(long paramLong) {
/* 252 */     return UNSAFE.getInt(null, paramLong + TEMP_MEMORY_REQUIRED);
/*     */   } public static int nmax_frame_size(long paramLong) {
/* 254 */     return UNSAFE.getInt(null, paramLong + MAX_FRAME_SIZE);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<STBVorbisInfo, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 261 */     private static final STBVorbisInfo ELEMENT_FACTORY = STBVorbisInfo.create(-1L);
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
/* 273 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / STBVorbisInfo.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 277 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 281 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 286 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected STBVorbisInfo getElementFactory() {
/* 291 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("unsigned int")
/*     */     public int sample_rate() {
/* 296 */       return STBVorbisInfo.nsample_rate(address());
/*     */     } public int channels() {
/* 298 */       return STBVorbisInfo.nchannels(address());
/*     */     } @NativeType("unsigned int")
/*     */     public int setup_memory_required() {
/* 301 */       return STBVorbisInfo.nsetup_memory_required(address());
/*     */     } @NativeType("unsigned int")
/*     */     public int setup_temp_memory_required() {
/* 304 */       return STBVorbisInfo.nsetup_temp_memory_required(address());
/*     */     } @NativeType("unsigned int")
/*     */     public int temp_memory_required() {
/* 307 */       return STBVorbisInfo.ntemp_memory_required(address());
/*     */     } public int max_frame_size() {
/* 309 */       return STBVorbisInfo.nmax_frame_size(address());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\stb\STBVorbisInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */