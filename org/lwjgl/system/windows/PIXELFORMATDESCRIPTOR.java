/*     */ package org.lwjgl.system.windows;
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
/*     */ public class PIXELFORMATDESCRIPTOR
/*     */   extends Struct<PIXELFORMATDESCRIPTOR>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int NSIZE;
/*     */   public static final int NVERSION;
/*     */   public static final int DWFLAGS;
/*     */   public static final int IPIXELTYPE;
/*     */   public static final int CCOLORBITS;
/*     */   public static final int CREDBITS;
/*     */   public static final int CREDSHIFT;
/*     */   public static final int CGREENBITS;
/*     */   public static final int CGREENSHIFT;
/*     */   public static final int CBLUEBITS;
/*     */   public static final int CBLUESHIFT;
/*     */   public static final int CALPHABITS;
/*     */   public static final int CALPHASHIFT;
/*     */   public static final int CACCUMBITS;
/*     */   public static final int CACCUMREDBITS;
/*     */   public static final int CACCUMGREENBITS;
/*     */   public static final int CACCUMBLUEBITS;
/*     */   public static final int CACCUMALPHABITS;
/*     */   public static final int CDEPTHBITS;
/*     */   public static final int CSTENCILBITS;
/*     */   public static final int CAUXBUFFERS;
/*     */   public static final int ILAYERTYPE;
/*     */   public static final int BRESERVED;
/*     */   public static final int DWLAYERMASK;
/*     */   public static final int DWVISIBLEMASK;
/*     */   public static final int DWDAMAGEMASK;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/* 120 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(2), __member(2), __member(4), __member(1), __member(1), __member(1), __member(1), __member(1), __member(1), __member(1), __member(1), __member(1), __member(1), __member(1), __member(1), __member(1), __member(1), __member(1), __member(1), __member(1), __member(1), __member(1), __member(1), __member(4), __member(4), __member(4) })).getSize();
/* 121 */     ALIGNOF = layout.getAlignment();
/*     */     
/* 123 */     NSIZE = layout.offsetof(0);
/* 124 */     NVERSION = layout.offsetof(1);
/* 125 */     DWFLAGS = layout.offsetof(2);
/* 126 */     IPIXELTYPE = layout.offsetof(3);
/* 127 */     CCOLORBITS = layout.offsetof(4);
/* 128 */     CREDBITS = layout.offsetof(5);
/* 129 */     CREDSHIFT = layout.offsetof(6);
/* 130 */     CGREENBITS = layout.offsetof(7);
/* 131 */     CGREENSHIFT = layout.offsetof(8);
/* 132 */     CBLUEBITS = layout.offsetof(9);
/* 133 */     CBLUESHIFT = layout.offsetof(10);
/* 134 */     CALPHABITS = layout.offsetof(11);
/* 135 */     CALPHASHIFT = layout.offsetof(12);
/* 136 */     CACCUMBITS = layout.offsetof(13);
/* 137 */     CACCUMREDBITS = layout.offsetof(14);
/* 138 */     CACCUMGREENBITS = layout.offsetof(15);
/* 139 */     CACCUMBLUEBITS = layout.offsetof(16);
/* 140 */     CACCUMALPHABITS = layout.offsetof(17);
/* 141 */     CDEPTHBITS = layout.offsetof(18);
/* 142 */     CSTENCILBITS = layout.offsetof(19);
/* 143 */     CAUXBUFFERS = layout.offsetof(20);
/* 144 */     ILAYERTYPE = layout.offsetof(21);
/* 145 */     BRESERVED = layout.offsetof(22);
/* 146 */     DWLAYERMASK = layout.offsetof(23);
/* 147 */     DWVISIBLEMASK = layout.offsetof(24);
/* 148 */     DWDAMAGEMASK = layout.offsetof(25);
/*     */   }
/*     */   
/*     */   protected PIXELFORMATDESCRIPTOR(long paramLong, ByteBuffer paramByteBuffer) {
/* 152 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected PIXELFORMATDESCRIPTOR create(long paramLong, ByteBuffer paramByteBuffer) {
/* 157 */     return new PIXELFORMATDESCRIPTOR(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PIXELFORMATDESCRIPTOR(ByteBuffer paramByteBuffer) {
/* 167 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 171 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("WORD")
/*     */   public short nSize() {
/* 175 */     return nnSize(address());
/*     */   } @NativeType("WORD")
/*     */   public short nVersion() {
/* 178 */     return nnVersion(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dwFlags() {
/* 181 */     return ndwFlags(address());
/*     */   } @NativeType("BYTE")
/*     */   public byte iPixelType() {
/* 184 */     return niPixelType(address());
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BYTE")
/*     */   public byte cColorBits() {
/* 190 */     return ncColorBits(address());
/*     */   } @NativeType("BYTE")
/*     */   public byte cRedBits() {
/* 193 */     return ncRedBits(address());
/*     */   } @NativeType("BYTE")
/*     */   public byte cRedShift() {
/* 196 */     return ncRedShift(address());
/*     */   } @NativeType("BYTE")
/*     */   public byte cGreenBits() {
/* 199 */     return ncGreenBits(address());
/*     */   } @NativeType("BYTE")
/*     */   public byte cGreenShift() {
/* 202 */     return ncGreenShift(address());
/*     */   } @NativeType("BYTE")
/*     */   public byte cBlueBits() {
/* 205 */     return ncBlueBits(address());
/*     */   } @NativeType("BYTE")
/*     */   public byte cBlueShift() {
/* 208 */     return ncBlueShift(address());
/*     */   } @NativeType("BYTE")
/*     */   public byte cAlphaBits() {
/* 211 */     return ncAlphaBits(address());
/*     */   } @NativeType("BYTE")
/*     */   public byte cAlphaShift() {
/* 214 */     return ncAlphaShift(address());
/*     */   } @NativeType("BYTE")
/*     */   public byte cAccumBits() {
/* 217 */     return ncAccumBits(address());
/*     */   } @NativeType("BYTE")
/*     */   public byte cAccumRedBits() {
/* 220 */     return ncAccumRedBits(address());
/*     */   } @NativeType("BYTE")
/*     */   public byte cAccumGreenBits() {
/* 223 */     return ncAccumGreenBits(address());
/*     */   } @NativeType("BYTE")
/*     */   public byte cAccumBlueBits() {
/* 226 */     return ncAccumBlueBits(address());
/*     */   } @NativeType("BYTE")
/*     */   public byte cAccumAlphaBits() {
/* 229 */     return ncAccumAlphaBits(address());
/*     */   } @NativeType("BYTE")
/*     */   public byte cDepthBits() {
/* 232 */     return ncDepthBits(address());
/*     */   } @NativeType("BYTE")
/*     */   public byte cStencilBits() {
/* 235 */     return ncStencilBits(address());
/*     */   } @NativeType("BYTE")
/*     */   public byte cAuxBuffers() {
/* 238 */     return ncAuxBuffers(address());
/*     */   } @NativeType("BYTE")
/*     */   public byte iLayerType() {
/* 241 */     return niLayerType(address());
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BYTE")
/*     */   public byte bReserved() {
/* 247 */     return nbReserved(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dwLayerMask() {
/* 250 */     return ndwLayerMask(address());
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("DWORD")
/*     */   public int dwVisibleMask() {
/* 256 */     return ndwVisibleMask(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dwDamageMask() {
/* 259 */     return ndwDamageMask(address());
/*     */   }
/*     */   public PIXELFORMATDESCRIPTOR nSize(@NativeType("WORD") short paramShort) {
/* 262 */     nnSize(address(), paramShort); return this;
/*     */   } public PIXELFORMATDESCRIPTOR nVersion(@NativeType("WORD") short paramShort) {
/* 264 */     nnVersion(address(), paramShort); return this;
/*     */   } public PIXELFORMATDESCRIPTOR dwFlags(@NativeType("DWORD") int paramInt) {
/* 266 */     ndwFlags(address(), paramInt); return this;
/*     */   } public PIXELFORMATDESCRIPTOR iPixelType(@NativeType("BYTE") byte paramByte) {
/* 268 */     niPixelType(address(), paramByte); return this;
/*     */   } public PIXELFORMATDESCRIPTOR cColorBits(@NativeType("BYTE") byte paramByte) {
/* 270 */     ncColorBits(address(), paramByte); return this;
/*     */   } public PIXELFORMATDESCRIPTOR cRedBits(@NativeType("BYTE") byte paramByte) {
/* 272 */     ncRedBits(address(), paramByte); return this;
/*     */   } public PIXELFORMATDESCRIPTOR cRedShift(@NativeType("BYTE") byte paramByte) {
/* 274 */     ncRedShift(address(), paramByte); return this;
/*     */   } public PIXELFORMATDESCRIPTOR cGreenBits(@NativeType("BYTE") byte paramByte) {
/* 276 */     ncGreenBits(address(), paramByte); return this;
/*     */   } public PIXELFORMATDESCRIPTOR cGreenShift(@NativeType("BYTE") byte paramByte) {
/* 278 */     ncGreenShift(address(), paramByte); return this;
/*     */   } public PIXELFORMATDESCRIPTOR cBlueBits(@NativeType("BYTE") byte paramByte) {
/* 280 */     ncBlueBits(address(), paramByte); return this;
/*     */   } public PIXELFORMATDESCRIPTOR cBlueShift(@NativeType("BYTE") byte paramByte) {
/* 282 */     ncBlueShift(address(), paramByte); return this;
/*     */   } public PIXELFORMATDESCRIPTOR cAlphaBits(@NativeType("BYTE") byte paramByte) {
/* 284 */     ncAlphaBits(address(), paramByte); return this;
/*     */   } public PIXELFORMATDESCRIPTOR cAlphaShift(@NativeType("BYTE") byte paramByte) {
/* 286 */     ncAlphaShift(address(), paramByte); return this;
/*     */   } public PIXELFORMATDESCRIPTOR cAccumBits(@NativeType("BYTE") byte paramByte) {
/* 288 */     ncAccumBits(address(), paramByte); return this;
/*     */   } public PIXELFORMATDESCRIPTOR cAccumRedBits(@NativeType("BYTE") byte paramByte) {
/* 290 */     ncAccumRedBits(address(), paramByte); return this;
/*     */   } public PIXELFORMATDESCRIPTOR cAccumGreenBits(@NativeType("BYTE") byte paramByte) {
/* 292 */     ncAccumGreenBits(address(), paramByte); return this;
/*     */   } public PIXELFORMATDESCRIPTOR cAccumBlueBits(@NativeType("BYTE") byte paramByte) {
/* 294 */     ncAccumBlueBits(address(), paramByte); return this;
/*     */   } public PIXELFORMATDESCRIPTOR cAccumAlphaBits(@NativeType("BYTE") byte paramByte) {
/* 296 */     ncAccumAlphaBits(address(), paramByte); return this;
/*     */   } public PIXELFORMATDESCRIPTOR cDepthBits(@NativeType("BYTE") byte paramByte) {
/* 298 */     ncDepthBits(address(), paramByte); return this;
/*     */   } public PIXELFORMATDESCRIPTOR cStencilBits(@NativeType("BYTE") byte paramByte) {
/* 300 */     ncStencilBits(address(), paramByte); return this;
/*     */   } public PIXELFORMATDESCRIPTOR cAuxBuffers(@NativeType("BYTE") byte paramByte) {
/* 302 */     ncAuxBuffers(address(), paramByte); return this;
/*     */   } public PIXELFORMATDESCRIPTOR iLayerType(@NativeType("BYTE") byte paramByte) {
/* 304 */     niLayerType(address(), paramByte); return this;
/*     */   } public PIXELFORMATDESCRIPTOR bReserved(@NativeType("BYTE") byte paramByte) {
/* 306 */     nbReserved(address(), paramByte); return this;
/*     */   } public PIXELFORMATDESCRIPTOR dwLayerMask(@NativeType("DWORD") int paramInt) {
/* 308 */     ndwLayerMask(address(), paramInt); return this;
/*     */   } public PIXELFORMATDESCRIPTOR dwVisibleMask(@NativeType("DWORD") int paramInt) {
/* 310 */     ndwVisibleMask(address(), paramInt); return this;
/*     */   } public PIXELFORMATDESCRIPTOR dwDamageMask(@NativeType("DWORD") int paramInt) {
/* 312 */     ndwDamageMask(address(), paramInt); return this;
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
/*     */   public PIXELFORMATDESCRIPTOR set(short paramShort1, short paramShort2, int paramInt1, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5, byte paramByte6, byte paramByte7, byte paramByte8, byte paramByte9, byte paramByte10, byte paramByte11, byte paramByte12, byte paramByte13, byte paramByte14, byte paramByte15, byte paramByte16, byte paramByte17, byte paramByte18, byte paramByte19, byte paramByte20, int paramInt2, int paramInt3, int paramInt4) {
/* 343 */     nSize(paramShort1);
/* 344 */     nVersion(paramShort2);
/* 345 */     dwFlags(paramInt1);
/* 346 */     iPixelType(paramByte1);
/* 347 */     cColorBits(paramByte2);
/* 348 */     cRedBits(paramByte3);
/* 349 */     cRedShift(paramByte4);
/* 350 */     cGreenBits(paramByte5);
/* 351 */     cGreenShift(paramByte6);
/* 352 */     cBlueBits(paramByte7);
/* 353 */     cBlueShift(paramByte8);
/* 354 */     cAlphaBits(paramByte9);
/* 355 */     cAlphaShift(paramByte10);
/* 356 */     cAccumBits(paramByte11);
/* 357 */     cAccumRedBits(paramByte12);
/* 358 */     cAccumGreenBits(paramByte13);
/* 359 */     cAccumBlueBits(paramByte14);
/* 360 */     cAccumAlphaBits(paramByte15);
/* 361 */     cDepthBits(paramByte16);
/* 362 */     cStencilBits(paramByte17);
/* 363 */     cAuxBuffers(paramByte18);
/* 364 */     iLayerType(paramByte19);
/* 365 */     bReserved(paramByte20);
/* 366 */     dwLayerMask(paramInt2);
/* 367 */     dwVisibleMask(paramInt3);
/* 368 */     dwDamageMask(paramInt4);
/*     */     
/* 370 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PIXELFORMATDESCRIPTOR set(PIXELFORMATDESCRIPTOR paramPIXELFORMATDESCRIPTOR) {
/* 381 */     MemoryUtil.memCopy(paramPIXELFORMATDESCRIPTOR.address(), address(), SIZEOF);
/* 382 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static PIXELFORMATDESCRIPTOR malloc() {
/* 389 */     return new PIXELFORMATDESCRIPTOR(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static PIXELFORMATDESCRIPTOR calloc() {
/* 394 */     return new PIXELFORMATDESCRIPTOR(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static PIXELFORMATDESCRIPTOR create() {
/* 399 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 400 */     return new PIXELFORMATDESCRIPTOR(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static PIXELFORMATDESCRIPTOR create(long paramLong) {
/* 405 */     return new PIXELFORMATDESCRIPTOR(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static PIXELFORMATDESCRIPTOR createSafe(long paramLong) {
/* 411 */     return (paramLong == 0L) ? null : new PIXELFORMATDESCRIPTOR(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 420 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 429 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 438 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 439 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 449 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 455 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static PIXELFORMATDESCRIPTOR mallocStack() {
/* 461 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 463 */   public static PIXELFORMATDESCRIPTOR callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 465 */   public static PIXELFORMATDESCRIPTOR mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 467 */   public static PIXELFORMATDESCRIPTOR callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 469 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 471 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 473 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 475 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static PIXELFORMATDESCRIPTOR malloc(MemoryStack paramMemoryStack) {
/* 483 */     return new PIXELFORMATDESCRIPTOR(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static PIXELFORMATDESCRIPTOR calloc(MemoryStack paramMemoryStack) {
/* 492 */     return new PIXELFORMATDESCRIPTOR(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 502 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 512 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static short nnSize(long paramLong) {
/* 518 */     return UNSAFE.getShort(null, paramLong + NSIZE);
/*     */   } public static short nnVersion(long paramLong) {
/* 520 */     return UNSAFE.getShort(null, paramLong + NVERSION);
/*     */   } public static int ndwFlags(long paramLong) {
/* 522 */     return UNSAFE.getInt(null, paramLong + DWFLAGS);
/*     */   } public static byte niPixelType(long paramLong) {
/* 524 */     return UNSAFE.getByte(null, paramLong + IPIXELTYPE);
/*     */   } public static byte ncColorBits(long paramLong) {
/* 526 */     return UNSAFE.getByte(null, paramLong + CCOLORBITS);
/*     */   } public static byte ncRedBits(long paramLong) {
/* 528 */     return UNSAFE.getByte(null, paramLong + CREDBITS);
/*     */   } public static byte ncRedShift(long paramLong) {
/* 530 */     return UNSAFE.getByte(null, paramLong + CREDSHIFT);
/*     */   } public static byte ncGreenBits(long paramLong) {
/* 532 */     return UNSAFE.getByte(null, paramLong + CGREENBITS);
/*     */   } public static byte ncGreenShift(long paramLong) {
/* 534 */     return UNSAFE.getByte(null, paramLong + CGREENSHIFT);
/*     */   } public static byte ncBlueBits(long paramLong) {
/* 536 */     return UNSAFE.getByte(null, paramLong + CBLUEBITS);
/*     */   } public static byte ncBlueShift(long paramLong) {
/* 538 */     return UNSAFE.getByte(null, paramLong + CBLUESHIFT);
/*     */   } public static byte ncAlphaBits(long paramLong) {
/* 540 */     return UNSAFE.getByte(null, paramLong + CALPHABITS);
/*     */   } public static byte ncAlphaShift(long paramLong) {
/* 542 */     return UNSAFE.getByte(null, paramLong + CALPHASHIFT);
/*     */   } public static byte ncAccumBits(long paramLong) {
/* 544 */     return UNSAFE.getByte(null, paramLong + CACCUMBITS);
/*     */   } public static byte ncAccumRedBits(long paramLong) {
/* 546 */     return UNSAFE.getByte(null, paramLong + CACCUMREDBITS);
/*     */   } public static byte ncAccumGreenBits(long paramLong) {
/* 548 */     return UNSAFE.getByte(null, paramLong + CACCUMGREENBITS);
/*     */   } public static byte ncAccumBlueBits(long paramLong) {
/* 550 */     return UNSAFE.getByte(null, paramLong + CACCUMBLUEBITS);
/*     */   } public static byte ncAccumAlphaBits(long paramLong) {
/* 552 */     return UNSAFE.getByte(null, paramLong + CACCUMALPHABITS);
/*     */   } public static byte ncDepthBits(long paramLong) {
/* 554 */     return UNSAFE.getByte(null, paramLong + CDEPTHBITS);
/*     */   } public static byte ncStencilBits(long paramLong) {
/* 556 */     return UNSAFE.getByte(null, paramLong + CSTENCILBITS);
/*     */   } public static byte ncAuxBuffers(long paramLong) {
/* 558 */     return UNSAFE.getByte(null, paramLong + CAUXBUFFERS);
/*     */   } public static byte niLayerType(long paramLong) {
/* 560 */     return UNSAFE.getByte(null, paramLong + ILAYERTYPE);
/*     */   } public static byte nbReserved(long paramLong) {
/* 562 */     return UNSAFE.getByte(null, paramLong + BRESERVED);
/*     */   } public static int ndwLayerMask(long paramLong) {
/* 564 */     return UNSAFE.getInt(null, paramLong + DWLAYERMASK);
/*     */   } public static int ndwVisibleMask(long paramLong) {
/* 566 */     return UNSAFE.getInt(null, paramLong + DWVISIBLEMASK);
/*     */   } public static int ndwDamageMask(long paramLong) {
/* 568 */     return UNSAFE.getInt(null, paramLong + DWDAMAGEMASK);
/*     */   }
/*     */   public static void nnSize(long paramLong, short paramShort) {
/* 571 */     UNSAFE.putShort(null, paramLong + NSIZE, paramShort);
/*     */   } public static void nnVersion(long paramLong, short paramShort) {
/* 573 */     UNSAFE.putShort(null, paramLong + NVERSION, paramShort);
/*     */   } public static void ndwFlags(long paramLong, int paramInt) {
/* 575 */     UNSAFE.putInt(null, paramLong + DWFLAGS, paramInt);
/*     */   } public static void niPixelType(long paramLong, byte paramByte) {
/* 577 */     UNSAFE.putByte(null, paramLong + IPIXELTYPE, paramByte);
/*     */   } public static void ncColorBits(long paramLong, byte paramByte) {
/* 579 */     UNSAFE.putByte(null, paramLong + CCOLORBITS, paramByte);
/*     */   } public static void ncRedBits(long paramLong, byte paramByte) {
/* 581 */     UNSAFE.putByte(null, paramLong + CREDBITS, paramByte);
/*     */   } public static void ncRedShift(long paramLong, byte paramByte) {
/* 583 */     UNSAFE.putByte(null, paramLong + CREDSHIFT, paramByte);
/*     */   } public static void ncGreenBits(long paramLong, byte paramByte) {
/* 585 */     UNSAFE.putByte(null, paramLong + CGREENBITS, paramByte);
/*     */   } public static void ncGreenShift(long paramLong, byte paramByte) {
/* 587 */     UNSAFE.putByte(null, paramLong + CGREENSHIFT, paramByte);
/*     */   } public static void ncBlueBits(long paramLong, byte paramByte) {
/* 589 */     UNSAFE.putByte(null, paramLong + CBLUEBITS, paramByte);
/*     */   } public static void ncBlueShift(long paramLong, byte paramByte) {
/* 591 */     UNSAFE.putByte(null, paramLong + CBLUESHIFT, paramByte);
/*     */   } public static void ncAlphaBits(long paramLong, byte paramByte) {
/* 593 */     UNSAFE.putByte(null, paramLong + CALPHABITS, paramByte);
/*     */   } public static void ncAlphaShift(long paramLong, byte paramByte) {
/* 595 */     UNSAFE.putByte(null, paramLong + CALPHASHIFT, paramByte);
/*     */   } public static void ncAccumBits(long paramLong, byte paramByte) {
/* 597 */     UNSAFE.putByte(null, paramLong + CACCUMBITS, paramByte);
/*     */   } public static void ncAccumRedBits(long paramLong, byte paramByte) {
/* 599 */     UNSAFE.putByte(null, paramLong + CACCUMREDBITS, paramByte);
/*     */   } public static void ncAccumGreenBits(long paramLong, byte paramByte) {
/* 601 */     UNSAFE.putByte(null, paramLong + CACCUMGREENBITS, paramByte);
/*     */   } public static void ncAccumBlueBits(long paramLong, byte paramByte) {
/* 603 */     UNSAFE.putByte(null, paramLong + CACCUMBLUEBITS, paramByte);
/*     */   } public static void ncAccumAlphaBits(long paramLong, byte paramByte) {
/* 605 */     UNSAFE.putByte(null, paramLong + CACCUMALPHABITS, paramByte);
/*     */   } public static void ncDepthBits(long paramLong, byte paramByte) {
/* 607 */     UNSAFE.putByte(null, paramLong + CDEPTHBITS, paramByte);
/*     */   } public static void ncStencilBits(long paramLong, byte paramByte) {
/* 609 */     UNSAFE.putByte(null, paramLong + CSTENCILBITS, paramByte);
/*     */   } public static void ncAuxBuffers(long paramLong, byte paramByte) {
/* 611 */     UNSAFE.putByte(null, paramLong + CAUXBUFFERS, paramByte);
/*     */   } public static void niLayerType(long paramLong, byte paramByte) {
/* 613 */     UNSAFE.putByte(null, paramLong + ILAYERTYPE, paramByte);
/*     */   } public static void nbReserved(long paramLong, byte paramByte) {
/* 615 */     UNSAFE.putByte(null, paramLong + BRESERVED, paramByte);
/*     */   } public static void ndwLayerMask(long paramLong, int paramInt) {
/* 617 */     UNSAFE.putInt(null, paramLong + DWLAYERMASK, paramInt);
/*     */   } public static void ndwVisibleMask(long paramLong, int paramInt) {
/* 619 */     UNSAFE.putInt(null, paramLong + DWVISIBLEMASK, paramInt);
/*     */   } public static void ndwDamageMask(long paramLong, int paramInt) {
/* 621 */     UNSAFE.putInt(null, paramLong + DWDAMAGEMASK, paramInt);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<PIXELFORMATDESCRIPTOR, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 628 */     private static final PIXELFORMATDESCRIPTOR ELEMENT_FACTORY = PIXELFORMATDESCRIPTOR.create(-1L);
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
/* 640 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / PIXELFORMATDESCRIPTOR.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 644 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 648 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 653 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected PIXELFORMATDESCRIPTOR getElementFactory() {
/* 658 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("WORD")
/*     */     public short nSize() {
/* 663 */       return PIXELFORMATDESCRIPTOR.nnSize(address());
/*     */     } @NativeType("WORD")
/*     */     public short nVersion() {
/* 666 */       return PIXELFORMATDESCRIPTOR.nnVersion(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dwFlags() {
/* 669 */       return PIXELFORMATDESCRIPTOR.ndwFlags(address());
/*     */     } @NativeType("BYTE")
/*     */     public byte iPixelType() {
/* 672 */       return PIXELFORMATDESCRIPTOR.niPixelType(address());
/*     */     } @NativeType("BYTE")
/*     */     public byte cColorBits() {
/* 675 */       return PIXELFORMATDESCRIPTOR.ncColorBits(address());
/*     */     } @NativeType("BYTE")
/*     */     public byte cRedBits() {
/* 678 */       return PIXELFORMATDESCRIPTOR.ncRedBits(address());
/*     */     } @NativeType("BYTE")
/*     */     public byte cRedShift() {
/* 681 */       return PIXELFORMATDESCRIPTOR.ncRedShift(address());
/*     */     } @NativeType("BYTE")
/*     */     public byte cGreenBits() {
/* 684 */       return PIXELFORMATDESCRIPTOR.ncGreenBits(address());
/*     */     } @NativeType("BYTE")
/*     */     public byte cGreenShift() {
/* 687 */       return PIXELFORMATDESCRIPTOR.ncGreenShift(address());
/*     */     } @NativeType("BYTE")
/*     */     public byte cBlueBits() {
/* 690 */       return PIXELFORMATDESCRIPTOR.ncBlueBits(address());
/*     */     } @NativeType("BYTE")
/*     */     public byte cBlueShift() {
/* 693 */       return PIXELFORMATDESCRIPTOR.ncBlueShift(address());
/*     */     } @NativeType("BYTE")
/*     */     public byte cAlphaBits() {
/* 696 */       return PIXELFORMATDESCRIPTOR.ncAlphaBits(address());
/*     */     } @NativeType("BYTE")
/*     */     public byte cAlphaShift() {
/* 699 */       return PIXELFORMATDESCRIPTOR.ncAlphaShift(address());
/*     */     } @NativeType("BYTE")
/*     */     public byte cAccumBits() {
/* 702 */       return PIXELFORMATDESCRIPTOR.ncAccumBits(address());
/*     */     } @NativeType("BYTE")
/*     */     public byte cAccumRedBits() {
/* 705 */       return PIXELFORMATDESCRIPTOR.ncAccumRedBits(address());
/*     */     } @NativeType("BYTE")
/*     */     public byte cAccumGreenBits() {
/* 708 */       return PIXELFORMATDESCRIPTOR.ncAccumGreenBits(address());
/*     */     } @NativeType("BYTE")
/*     */     public byte cAccumBlueBits() {
/* 711 */       return PIXELFORMATDESCRIPTOR.ncAccumBlueBits(address());
/*     */     } @NativeType("BYTE")
/*     */     public byte cAccumAlphaBits() {
/* 714 */       return PIXELFORMATDESCRIPTOR.ncAccumAlphaBits(address());
/*     */     } @NativeType("BYTE")
/*     */     public byte cDepthBits() {
/* 717 */       return PIXELFORMATDESCRIPTOR.ncDepthBits(address());
/*     */     } @NativeType("BYTE")
/*     */     public byte cStencilBits() {
/* 720 */       return PIXELFORMATDESCRIPTOR.ncStencilBits(address());
/*     */     } @NativeType("BYTE")
/*     */     public byte cAuxBuffers() {
/* 723 */       return PIXELFORMATDESCRIPTOR.ncAuxBuffers(address());
/*     */     } @NativeType("BYTE")
/*     */     public byte iLayerType() {
/* 726 */       return PIXELFORMATDESCRIPTOR.niLayerType(address());
/*     */     } @NativeType("BYTE")
/*     */     public byte bReserved() {
/* 729 */       return PIXELFORMATDESCRIPTOR.nbReserved(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dwLayerMask() {
/* 732 */       return PIXELFORMATDESCRIPTOR.ndwLayerMask(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dwVisibleMask() {
/* 735 */       return PIXELFORMATDESCRIPTOR.ndwVisibleMask(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dwDamageMask() {
/* 738 */       return PIXELFORMATDESCRIPTOR.ndwDamageMask(address());
/*     */     }
/*     */     public Buffer nSize(@NativeType("WORD") short param1Short) {
/* 741 */       PIXELFORMATDESCRIPTOR.nnSize(address(), param1Short); return this;
/*     */     } public Buffer nVersion(@NativeType("WORD") short param1Short) {
/* 743 */       PIXELFORMATDESCRIPTOR.nnVersion(address(), param1Short); return this;
/*     */     } public Buffer dwFlags(@NativeType("DWORD") int param1Int) {
/* 745 */       PIXELFORMATDESCRIPTOR.ndwFlags(address(), param1Int); return this;
/*     */     } public Buffer iPixelType(@NativeType("BYTE") byte param1Byte) {
/* 747 */       PIXELFORMATDESCRIPTOR.niPixelType(address(), param1Byte); return this;
/*     */     } public Buffer cColorBits(@NativeType("BYTE") byte param1Byte) {
/* 749 */       PIXELFORMATDESCRIPTOR.ncColorBits(address(), param1Byte); return this;
/*     */     } public Buffer cRedBits(@NativeType("BYTE") byte param1Byte) {
/* 751 */       PIXELFORMATDESCRIPTOR.ncRedBits(address(), param1Byte); return this;
/*     */     } public Buffer cRedShift(@NativeType("BYTE") byte param1Byte) {
/* 753 */       PIXELFORMATDESCRIPTOR.ncRedShift(address(), param1Byte); return this;
/*     */     } public Buffer cGreenBits(@NativeType("BYTE") byte param1Byte) {
/* 755 */       PIXELFORMATDESCRIPTOR.ncGreenBits(address(), param1Byte); return this;
/*     */     } public Buffer cGreenShift(@NativeType("BYTE") byte param1Byte) {
/* 757 */       PIXELFORMATDESCRIPTOR.ncGreenShift(address(), param1Byte); return this;
/*     */     } public Buffer cBlueBits(@NativeType("BYTE") byte param1Byte) {
/* 759 */       PIXELFORMATDESCRIPTOR.ncBlueBits(address(), param1Byte); return this;
/*     */     } public Buffer cBlueShift(@NativeType("BYTE") byte param1Byte) {
/* 761 */       PIXELFORMATDESCRIPTOR.ncBlueShift(address(), param1Byte); return this;
/*     */     } public Buffer cAlphaBits(@NativeType("BYTE") byte param1Byte) {
/* 763 */       PIXELFORMATDESCRIPTOR.ncAlphaBits(address(), param1Byte); return this;
/*     */     } public Buffer cAlphaShift(@NativeType("BYTE") byte param1Byte) {
/* 765 */       PIXELFORMATDESCRIPTOR.ncAlphaShift(address(), param1Byte); return this;
/*     */     } public Buffer cAccumBits(@NativeType("BYTE") byte param1Byte) {
/* 767 */       PIXELFORMATDESCRIPTOR.ncAccumBits(address(), param1Byte); return this;
/*     */     } public Buffer cAccumRedBits(@NativeType("BYTE") byte param1Byte) {
/* 769 */       PIXELFORMATDESCRIPTOR.ncAccumRedBits(address(), param1Byte); return this;
/*     */     } public Buffer cAccumGreenBits(@NativeType("BYTE") byte param1Byte) {
/* 771 */       PIXELFORMATDESCRIPTOR.ncAccumGreenBits(address(), param1Byte); return this;
/*     */     } public Buffer cAccumBlueBits(@NativeType("BYTE") byte param1Byte) {
/* 773 */       PIXELFORMATDESCRIPTOR.ncAccumBlueBits(address(), param1Byte); return this;
/*     */     } public Buffer cAccumAlphaBits(@NativeType("BYTE") byte param1Byte) {
/* 775 */       PIXELFORMATDESCRIPTOR.ncAccumAlphaBits(address(), param1Byte); return this;
/*     */     } public Buffer cDepthBits(@NativeType("BYTE") byte param1Byte) {
/* 777 */       PIXELFORMATDESCRIPTOR.ncDepthBits(address(), param1Byte); return this;
/*     */     } public Buffer cStencilBits(@NativeType("BYTE") byte param1Byte) {
/* 779 */       PIXELFORMATDESCRIPTOR.ncStencilBits(address(), param1Byte); return this;
/*     */     } public Buffer cAuxBuffers(@NativeType("BYTE") byte param1Byte) {
/* 781 */       PIXELFORMATDESCRIPTOR.ncAuxBuffers(address(), param1Byte); return this;
/*     */     } public Buffer iLayerType(@NativeType("BYTE") byte param1Byte) {
/* 783 */       PIXELFORMATDESCRIPTOR.niLayerType(address(), param1Byte); return this;
/*     */     } public Buffer bReserved(@NativeType("BYTE") byte param1Byte) {
/* 785 */       PIXELFORMATDESCRIPTOR.nbReserved(address(), param1Byte); return this;
/*     */     } public Buffer dwLayerMask(@NativeType("DWORD") int param1Int) {
/* 787 */       PIXELFORMATDESCRIPTOR.ndwLayerMask(address(), param1Int); return this;
/*     */     } public Buffer dwVisibleMask(@NativeType("DWORD") int param1Int) {
/* 789 */       PIXELFORMATDESCRIPTOR.ndwVisibleMask(address(), param1Int); return this;
/*     */     } public Buffer dwDamageMask(@NativeType("DWORD") int param1Int) {
/* 791 */       PIXELFORMATDESCRIPTOR.ndwDamageMask(address(), param1Int); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\windows\PIXELFORMATDESCRIPTOR.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */