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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @NativeType("struct stbtt__bitmap")
/*     */ public class STBTTBitmap
/*     */   extends Struct<STBTTBitmap>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int W;
/*     */   public static final int H;
/*     */   public static final int STRIDE;
/*     */   public static final int PIXELS;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  56 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(4), __member(4), __member(POINTER_SIZE) })).getSize();
/*  57 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  59 */     W = layout.offsetof(0);
/*  60 */     H = layout.offsetof(1);
/*  61 */     STRIDE = layout.offsetof(2);
/*  62 */     PIXELS = layout.offsetof(3);
/*     */   }
/*     */   
/*     */   protected STBTTBitmap(long paramLong, ByteBuffer paramByteBuffer) {
/*  66 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected STBTTBitmap create(long paramLong, ByteBuffer paramByteBuffer) {
/*  71 */     return new STBTTBitmap(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBTTBitmap(ByteBuffer paramByteBuffer) {
/*  81 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  85 */     return SIZEOF;
/*     */   }
/*     */   public int w() {
/*  88 */     return nw(address());
/*     */   } public int h() {
/*  90 */     return nh(address());
/*     */   } public int stride() {
/*  92 */     return nstride(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("unsigned char *")
/*     */   public ByteBuffer pixels(int paramInt) {
/*  99 */     return npixels(address(), paramInt);
/*     */   }
/*     */   public STBTTBitmap w(int paramInt) {
/* 102 */     nw(address(), paramInt); return this;
/*     */   } public STBTTBitmap h(int paramInt) {
/* 104 */     nh(address(), paramInt); return this;
/*     */   } public STBTTBitmap stride(int paramInt) {
/* 106 */     nstride(address(), paramInt); return this;
/*     */   } public STBTTBitmap pixels(@NativeType("unsigned char *") ByteBuffer paramByteBuffer) {
/* 108 */     npixels(address(), paramByteBuffer); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBTTBitmap set(int paramInt1, int paramInt2, int paramInt3, ByteBuffer paramByteBuffer) {
/* 117 */     w(paramInt1);
/* 118 */     h(paramInt2);
/* 119 */     stride(paramInt3);
/* 120 */     pixels(paramByteBuffer);
/*     */     
/* 122 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBTTBitmap set(STBTTBitmap paramSTBTTBitmap) {
/* 133 */     MemoryUtil.memCopy(paramSTBTTBitmap.address(), address(), SIZEOF);
/* 134 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTBitmap malloc() {
/* 141 */     return new STBTTBitmap(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTBitmap calloc() {
/* 146 */     return new STBTTBitmap(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTBitmap create() {
/* 151 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 152 */     return new STBTTBitmap(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTBitmap create(long paramLong) {
/* 157 */     return new STBTTBitmap(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTBitmap createSafe(long paramLong) {
/* 163 */     return (paramLong == 0L) ? null : new STBTTBitmap(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 172 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 181 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 190 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 191 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 201 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 207 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static STBTTBitmap mallocStack() {
/* 213 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 215 */   public static STBTTBitmap callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 217 */   public static STBTTBitmap mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 219 */   public static STBTTBitmap callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 221 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 223 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 225 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 227 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTBitmap malloc(MemoryStack paramMemoryStack) {
/* 235 */     return new STBTTBitmap(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTBitmap calloc(MemoryStack paramMemoryStack) {
/* 244 */     return new STBTTBitmap(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 254 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 264 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nw(long paramLong) {
/* 270 */     return UNSAFE.getInt(null, paramLong + W);
/*     */   } public static int nh(long paramLong) {
/* 272 */     return UNSAFE.getInt(null, paramLong + H);
/*     */   } public static int nstride(long paramLong) {
/* 274 */     return UNSAFE.getInt(null, paramLong + STRIDE);
/*     */   } public static ByteBuffer npixels(long paramLong, int paramInt) {
/* 276 */     return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(paramLong + PIXELS), paramInt);
/*     */   }
/*     */   public static void nw(long paramLong, int paramInt) {
/* 279 */     UNSAFE.putInt(null, paramLong + W, paramInt);
/*     */   } public static void nh(long paramLong, int paramInt) {
/* 281 */     UNSAFE.putInt(null, paramLong + H, paramInt);
/*     */   } public static void nstride(long paramLong, int paramInt) {
/* 283 */     UNSAFE.putInt(null, paramLong + STRIDE, paramInt);
/*     */   } public static void npixels(long paramLong, ByteBuffer paramByteBuffer) {
/* 285 */     MemoryUtil.memPutAddress(paramLong + PIXELS, MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 293 */     Checks.check(MemoryUtil.memGetAddress(paramLong + PIXELS));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<STBTTBitmap, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 301 */     private static final STBTTBitmap ELEMENT_FACTORY = STBTTBitmap.create(-1L);
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
/* 313 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / STBTTBitmap.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 317 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 321 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 326 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected STBTTBitmap getElementFactory() {
/* 331 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int w() {
/* 335 */       return STBTTBitmap.nw(address());
/*     */     } public int h() {
/* 337 */       return STBTTBitmap.nh(address());
/*     */     } public int stride() {
/* 339 */       return STBTTBitmap.nstride(address());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     @NativeType("unsigned char *")
/*     */     public ByteBuffer pixels(int param1Int) {
/* 346 */       return STBTTBitmap.npixels(address(), param1Int);
/*     */     }
/*     */     public Buffer w(int param1Int) {
/* 349 */       STBTTBitmap.nw(address(), param1Int); return this;
/*     */     } public Buffer h(int param1Int) {
/* 351 */       STBTTBitmap.nh(address(), param1Int); return this;
/*     */     } public Buffer stride(int param1Int) {
/* 353 */       STBTTBitmap.nstride(address(), param1Int); return this;
/*     */     } public Buffer pixels(@NativeType("unsigned char *") ByteBuffer param1ByteBuffer) {
/* 355 */       STBTTBitmap.npixels(address(), param1ByteBuffer); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\stb\STBTTBitmap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */