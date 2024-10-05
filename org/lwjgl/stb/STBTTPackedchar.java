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
/*     */ @NativeType("struct stbtt_packedchar")
/*     */ public class STBTTPackedchar
/*     */   extends Struct<STBTTPackedchar>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int X0;
/*     */   public static final int Y0;
/*     */   public static final int X1;
/*     */   public static final int Y1;
/*     */   public static final int XOFF;
/*     */   public static final int YOFF;
/*     */   public static final int XADVANCE;
/*     */   public static final int XOFF2;
/*     */   public static final int YOFF2;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  70 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(2), __member(2), __member(2), __member(2), __member(4), __member(4), __member(4), __member(4), __member(4) })).getSize();
/*  71 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  73 */     X0 = layout.offsetof(0);
/*  74 */     Y0 = layout.offsetof(1);
/*  75 */     X1 = layout.offsetof(2);
/*  76 */     Y1 = layout.offsetof(3);
/*  77 */     XOFF = layout.offsetof(4);
/*  78 */     YOFF = layout.offsetof(5);
/*  79 */     XADVANCE = layout.offsetof(6);
/*  80 */     XOFF2 = layout.offsetof(7);
/*  81 */     YOFF2 = layout.offsetof(8);
/*     */   }
/*     */   
/*     */   protected STBTTPackedchar(long paramLong, ByteBuffer paramByteBuffer) {
/*  85 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected STBTTPackedchar create(long paramLong, ByteBuffer paramByteBuffer) {
/*  90 */     return new STBTTPackedchar(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBTTPackedchar(ByteBuffer paramByteBuffer) {
/* 100 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 104 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("unsigned short")
/*     */   public short x0() {
/* 108 */     return nx0(address());
/*     */   } @NativeType("unsigned short")
/*     */   public short y0() {
/* 111 */     return ny0(address());
/*     */   } @NativeType("unsigned short")
/*     */   public short x1() {
/* 114 */     return nx1(address());
/*     */   } @NativeType("unsigned short")
/*     */   public short y1() {
/* 117 */     return ny1(address());
/*     */   } public float xoff() {
/* 119 */     return nxoff(address());
/*     */   } public float yoff() {
/* 121 */     return nyoff(address());
/*     */   } public float xadvance() {
/* 123 */     return nxadvance(address());
/*     */   } public float xoff2() {
/* 125 */     return nxoff2(address());
/*     */   } public float yoff2() {
/* 127 */     return nyoff2(address());
/*     */   }
/*     */   public STBTTPackedchar x0(@NativeType("unsigned short") short paramShort) {
/* 130 */     nx0(address(), paramShort); return this;
/*     */   } public STBTTPackedchar y0(@NativeType("unsigned short") short paramShort) {
/* 132 */     ny0(address(), paramShort); return this;
/*     */   } public STBTTPackedchar x1(@NativeType("unsigned short") short paramShort) {
/* 134 */     nx1(address(), paramShort); return this;
/*     */   } public STBTTPackedchar y1(@NativeType("unsigned short") short paramShort) {
/* 136 */     ny1(address(), paramShort); return this;
/*     */   } public STBTTPackedchar xoff(float paramFloat) {
/* 138 */     nxoff(address(), paramFloat); return this;
/*     */   } public STBTTPackedchar yoff(float paramFloat) {
/* 140 */     nyoff(address(), paramFloat); return this;
/*     */   } public STBTTPackedchar xadvance(float paramFloat) {
/* 142 */     nxadvance(address(), paramFloat); return this;
/*     */   } public STBTTPackedchar xoff2(float paramFloat) {
/* 144 */     nxoff2(address(), paramFloat); return this;
/*     */   } public STBTTPackedchar yoff2(float paramFloat) {
/* 146 */     nyoff2(address(), paramFloat); return this;
/*     */   }
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
/*     */   public STBTTPackedchar set(short paramShort1, short paramShort2, short paramShort3, short paramShort4, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5) {
/* 160 */     x0(paramShort1);
/* 161 */     y0(paramShort2);
/* 162 */     x1(paramShort3);
/* 163 */     y1(paramShort4);
/* 164 */     xoff(paramFloat1);
/* 165 */     yoff(paramFloat2);
/* 166 */     xadvance(paramFloat3);
/* 167 */     xoff2(paramFloat4);
/* 168 */     yoff2(paramFloat5);
/*     */     
/* 170 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBTTPackedchar set(STBTTPackedchar paramSTBTTPackedchar) {
/* 181 */     MemoryUtil.memCopy(paramSTBTTPackedchar.address(), address(), SIZEOF);
/* 182 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTPackedchar malloc() {
/* 189 */     return new STBTTPackedchar(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTPackedchar calloc() {
/* 194 */     return new STBTTPackedchar(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTPackedchar create() {
/* 199 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 200 */     return new STBTTPackedchar(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTPackedchar create(long paramLong) {
/* 205 */     return new STBTTPackedchar(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTPackedchar createSafe(long paramLong) {
/* 211 */     return (paramLong == 0L) ? null : new STBTTPackedchar(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 220 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 229 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 238 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 239 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 249 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 255 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static STBTTPackedchar mallocStack() {
/* 261 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 263 */   public static STBTTPackedchar callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 265 */   public static STBTTPackedchar mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 267 */   public static STBTTPackedchar callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 269 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 271 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 273 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 275 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTPackedchar malloc(MemoryStack paramMemoryStack) {
/* 283 */     return new STBTTPackedchar(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTPackedchar calloc(MemoryStack paramMemoryStack) {
/* 292 */     return new STBTTPackedchar(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 302 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 312 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static short nx0(long paramLong) {
/* 318 */     return UNSAFE.getShort(null, paramLong + X0);
/*     */   } public static short ny0(long paramLong) {
/* 320 */     return UNSAFE.getShort(null, paramLong + Y0);
/*     */   } public static short nx1(long paramLong) {
/* 322 */     return UNSAFE.getShort(null, paramLong + X1);
/*     */   } public static short ny1(long paramLong) {
/* 324 */     return UNSAFE.getShort(null, paramLong + Y1);
/*     */   } public static float nxoff(long paramLong) {
/* 326 */     return UNSAFE.getFloat(null, paramLong + XOFF);
/*     */   } public static float nyoff(long paramLong) {
/* 328 */     return UNSAFE.getFloat(null, paramLong + YOFF);
/*     */   } public static float nxadvance(long paramLong) {
/* 330 */     return UNSAFE.getFloat(null, paramLong + XADVANCE);
/*     */   } public static float nxoff2(long paramLong) {
/* 332 */     return UNSAFE.getFloat(null, paramLong + XOFF2);
/*     */   } public static float nyoff2(long paramLong) {
/* 334 */     return UNSAFE.getFloat(null, paramLong + YOFF2);
/*     */   }
/*     */   public static void nx0(long paramLong, short paramShort) {
/* 337 */     UNSAFE.putShort(null, paramLong + X0, paramShort);
/*     */   } public static void ny0(long paramLong, short paramShort) {
/* 339 */     UNSAFE.putShort(null, paramLong + Y0, paramShort);
/*     */   } public static void nx1(long paramLong, short paramShort) {
/* 341 */     UNSAFE.putShort(null, paramLong + X1, paramShort);
/*     */   } public static void ny1(long paramLong, short paramShort) {
/* 343 */     UNSAFE.putShort(null, paramLong + Y1, paramShort);
/*     */   } public static void nxoff(long paramLong, float paramFloat) {
/* 345 */     UNSAFE.putFloat(null, paramLong + XOFF, paramFloat);
/*     */   } public static void nyoff(long paramLong, float paramFloat) {
/* 347 */     UNSAFE.putFloat(null, paramLong + YOFF, paramFloat);
/*     */   } public static void nxadvance(long paramLong, float paramFloat) {
/* 349 */     UNSAFE.putFloat(null, paramLong + XADVANCE, paramFloat);
/*     */   } public static void nxoff2(long paramLong, float paramFloat) {
/* 351 */     UNSAFE.putFloat(null, paramLong + XOFF2, paramFloat);
/*     */   } public static void nyoff2(long paramLong, float paramFloat) {
/* 353 */     UNSAFE.putFloat(null, paramLong + YOFF2, paramFloat);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<STBTTPackedchar, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 360 */     private static final STBTTPackedchar ELEMENT_FACTORY = STBTTPackedchar.create(-1L);
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
/* 372 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / STBTTPackedchar.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 376 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 380 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 385 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected STBTTPackedchar getElementFactory() {
/* 390 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("unsigned short")
/*     */     public short x0() {
/* 395 */       return STBTTPackedchar.nx0(address());
/*     */     } @NativeType("unsigned short")
/*     */     public short y0() {
/* 398 */       return STBTTPackedchar.ny0(address());
/*     */     } @NativeType("unsigned short")
/*     */     public short x1() {
/* 401 */       return STBTTPackedchar.nx1(address());
/*     */     } @NativeType("unsigned short")
/*     */     public short y1() {
/* 404 */       return STBTTPackedchar.ny1(address());
/*     */     } public float xoff() {
/* 406 */       return STBTTPackedchar.nxoff(address());
/*     */     } public float yoff() {
/* 408 */       return STBTTPackedchar.nyoff(address());
/*     */     } public float xadvance() {
/* 410 */       return STBTTPackedchar.nxadvance(address());
/*     */     } public float xoff2() {
/* 412 */       return STBTTPackedchar.nxoff2(address());
/*     */     } public float yoff2() {
/* 414 */       return STBTTPackedchar.nyoff2(address());
/*     */     }
/*     */     public Buffer x0(@NativeType("unsigned short") short param1Short) {
/* 417 */       STBTTPackedchar.nx0(address(), param1Short); return this;
/*     */     } public Buffer y0(@NativeType("unsigned short") short param1Short) {
/* 419 */       STBTTPackedchar.ny0(address(), param1Short); return this;
/*     */     } public Buffer x1(@NativeType("unsigned short") short param1Short) {
/* 421 */       STBTTPackedchar.nx1(address(), param1Short); return this;
/*     */     } public Buffer y1(@NativeType("unsigned short") short param1Short) {
/* 423 */       STBTTPackedchar.ny1(address(), param1Short); return this;
/*     */     } public Buffer xoff(float param1Float) {
/* 425 */       STBTTPackedchar.nxoff(address(), param1Float); return this;
/*     */     } public Buffer yoff(float param1Float) {
/* 427 */       STBTTPackedchar.nyoff(address(), param1Float); return this;
/*     */     } public Buffer xadvance(float param1Float) {
/* 429 */       STBTTPackedchar.nxadvance(address(), param1Float); return this;
/*     */     } public Buffer xoff2(float param1Float) {
/* 431 */       STBTTPackedchar.nxoff2(address(), param1Float); return this;
/*     */     } public Buffer yoff2(float param1Float) {
/* 433 */       STBTTPackedchar.nyoff2(address(), param1Float); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\stb\STBTTPackedchar.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */