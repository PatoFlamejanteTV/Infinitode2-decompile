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
/*     */ @NativeType("struct stbtt_pack_context")
/*     */ public class STBTTPackContext
/*     */   extends Struct<STBTTPackContext>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int USER_ALLOCATOR_CONTEXT;
/*     */   public static final int PACK_INFO;
/*     */   public static final int WIDTH;
/*     */   public static final int HEIGHT;
/*     */   public static final int STRIDE_IN_BYTES;
/*     */   public static final int PADDING;
/*     */   public static final int SKIP_MISSING;
/*     */   public static final int H_OVERSAMPLE;
/*     */   public static final int V_OVERSAMPLE;
/*     */   public static final int PIXELS;
/*     */   public static final int NODES;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  76 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(POINTER_SIZE), __member(POINTER_SIZE), __member(4), __member(4), __member(4), __member(4), __member(4), __member(4), __member(4), __member(POINTER_SIZE), __member(POINTER_SIZE) })).getSize();
/*  77 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  79 */     USER_ALLOCATOR_CONTEXT = layout.offsetof(0);
/*  80 */     PACK_INFO = layout.offsetof(1);
/*  81 */     WIDTH = layout.offsetof(2);
/*  82 */     HEIGHT = layout.offsetof(3);
/*  83 */     STRIDE_IN_BYTES = layout.offsetof(4);
/*  84 */     PADDING = layout.offsetof(5);
/*  85 */     SKIP_MISSING = layout.offsetof(6);
/*  86 */     H_OVERSAMPLE = layout.offsetof(7);
/*  87 */     V_OVERSAMPLE = layout.offsetof(8);
/*  88 */     PIXELS = layout.offsetof(9);
/*  89 */     NODES = layout.offsetof(10);
/*     */   }
/*     */   
/*     */   protected STBTTPackContext(long paramLong, ByteBuffer paramByteBuffer) {
/*  93 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected STBTTPackContext create(long paramLong, ByteBuffer paramByteBuffer) {
/*  98 */     return new STBTTPackContext(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBTTPackContext(ByteBuffer paramByteBuffer) {
/* 108 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 112 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("void *")
/*     */   public long user_allocator_context() {
/* 116 */     return nuser_allocator_context(address());
/*     */   } @NativeType("stbrp_context *")
/*     */   public STBRPContext pack_info() {
/* 119 */     return npack_info(address());
/*     */   } public int width() {
/* 121 */     return nwidth(address());
/*     */   } public int height() {
/* 123 */     return nheight(address());
/*     */   } public int stride_in_bytes() {
/* 125 */     return nstride_in_bytes(address());
/*     */   } public int padding() {
/* 127 */     return npadding(address());
/*     */   } @NativeType("int")
/*     */   public boolean skip_missing() {
/* 130 */     return (nskip_missing(address()) != 0);
/*     */   } @NativeType("unsigned int")
/*     */   public int h_oversample() {
/* 133 */     return nh_oversample(address());
/*     */   } @NativeType("unsigned int")
/*     */   public int v_oversample() {
/* 136 */     return nv_oversample(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("unsigned char *")
/*     */   public ByteBuffer pixels(int paramInt) {
/* 143 */     return npixels(address(), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("stbrp_node *")
/*     */   public STBRPNode.Buffer nodes(int paramInt) {
/* 150 */     return nnodes(address(), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTPackContext malloc() {
/* 156 */     return new STBTTPackContext(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTPackContext calloc() {
/* 161 */     return new STBTTPackContext(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTPackContext create() {
/* 166 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 167 */     return new STBTTPackContext(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTPackContext create(long paramLong) {
/* 172 */     return new STBTTPackContext(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTPackContext createSafe(long paramLong) {
/* 178 */     return (paramLong == 0L) ? null : new STBTTPackContext(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 187 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 196 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 205 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 206 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 216 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 222 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static STBTTPackContext mallocStack() {
/* 228 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 230 */   public static STBTTPackContext callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 232 */   public static STBTTPackContext mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 234 */   public static STBTTPackContext callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 236 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 238 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 240 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 242 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTPackContext malloc(MemoryStack paramMemoryStack) {
/* 250 */     return new STBTTPackContext(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTPackContext calloc(MemoryStack paramMemoryStack) {
/* 259 */     return new STBTTPackContext(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 269 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 279 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nuser_allocator_context(long paramLong) {
/* 285 */     return MemoryUtil.memGetAddress(paramLong + USER_ALLOCATOR_CONTEXT);
/*     */   } public static STBRPContext npack_info(long paramLong) {
/* 287 */     return STBRPContext.create(MemoryUtil.memGetAddress(paramLong + PACK_INFO));
/*     */   } public static int nwidth(long paramLong) {
/* 289 */     return UNSAFE.getInt(null, paramLong + WIDTH);
/*     */   } public static int nheight(long paramLong) {
/* 291 */     return UNSAFE.getInt(null, paramLong + HEIGHT);
/*     */   } public static int nstride_in_bytes(long paramLong) {
/* 293 */     return UNSAFE.getInt(null, paramLong + STRIDE_IN_BYTES);
/*     */   } public static int npadding(long paramLong) {
/* 295 */     return UNSAFE.getInt(null, paramLong + PADDING);
/*     */   } public static int nskip_missing(long paramLong) {
/* 297 */     return UNSAFE.getInt(null, paramLong + SKIP_MISSING);
/*     */   } public static int nh_oversample(long paramLong) {
/* 299 */     return UNSAFE.getInt(null, paramLong + H_OVERSAMPLE);
/*     */   } public static int nv_oversample(long paramLong) {
/* 301 */     return UNSAFE.getInt(null, paramLong + V_OVERSAMPLE);
/*     */   } public static ByteBuffer npixels(long paramLong, int paramInt) {
/* 303 */     return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(paramLong + PIXELS), paramInt);
/*     */   } public static STBRPNode.Buffer nnodes(long paramLong, int paramInt) {
/* 305 */     return STBRPNode.create(MemoryUtil.memGetAddress(paramLong + NODES), paramInt);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<STBTTPackContext, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 312 */     private static final STBTTPackContext ELEMENT_FACTORY = STBTTPackContext.create(-1L);
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
/* 324 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / STBTTPackContext.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 328 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 332 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 337 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected STBTTPackContext getElementFactory() {
/* 342 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("void *")
/*     */     public long user_allocator_context() {
/* 347 */       return STBTTPackContext.nuser_allocator_context(address());
/*     */     } @NativeType("stbrp_context *")
/*     */     public STBRPContext pack_info() {
/* 350 */       return STBTTPackContext.npack_info(address());
/*     */     } public int width() {
/* 352 */       return STBTTPackContext.nwidth(address());
/*     */     } public int height() {
/* 354 */       return STBTTPackContext.nheight(address());
/*     */     } public int stride_in_bytes() {
/* 356 */       return STBTTPackContext.nstride_in_bytes(address());
/*     */     } public int padding() {
/* 358 */       return STBTTPackContext.npadding(address());
/*     */     } @NativeType("int")
/*     */     public boolean skip_missing() {
/* 361 */       return (STBTTPackContext.nskip_missing(address()) != 0);
/*     */     } @NativeType("unsigned int")
/*     */     public int h_oversample() {
/* 364 */       return STBTTPackContext.nh_oversample(address());
/*     */     } @NativeType("unsigned int")
/*     */     public int v_oversample() {
/* 367 */       return STBTTPackContext.nv_oversample(address());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     @NativeType("unsigned char *")
/*     */     public ByteBuffer pixels(int param1Int) {
/* 374 */       return STBTTPackContext.npixels(address(), param1Int);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     @NativeType("stbrp_node *")
/*     */     public STBRPNode.Buffer nodes(int param1Int) {
/* 381 */       return STBTTPackContext.nnodes(address(), param1Int);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\stb\STBTTPackContext.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */