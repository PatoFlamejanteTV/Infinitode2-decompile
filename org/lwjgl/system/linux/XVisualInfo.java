/*     */ package org.lwjgl.system.linux;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XVisualInfo
/*     */   extends Struct<XVisualInfo>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int VISUAL;
/*     */   public static final int VISUALID;
/*     */   public static final int SCREEN;
/*     */   public static final int DEPTH;
/*     */   public static final int CLASS;
/*     */   public static final int RED_MASK;
/*     */   public static final int GREEN_MASK;
/*     */   public static final int BLUE_MASK;
/*     */   public static final int COLORMAP_SIZE;
/*     */   public static final int BITS_PER_RGB;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  73 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(POINTER_SIZE), __member(CLONG_SIZE), __member(4), __member(4), __member(4), __member(CLONG_SIZE), __member(CLONG_SIZE), __member(CLONG_SIZE), __member(4), __member(4) })).getSize();
/*  74 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  76 */     VISUAL = layout.offsetof(0);
/*  77 */     VISUALID = layout.offsetof(1);
/*  78 */     SCREEN = layout.offsetof(2);
/*  79 */     DEPTH = layout.offsetof(3);
/*  80 */     CLASS = layout.offsetof(4);
/*  81 */     RED_MASK = layout.offsetof(5);
/*  82 */     GREEN_MASK = layout.offsetof(6);
/*  83 */     BLUE_MASK = layout.offsetof(7);
/*  84 */     COLORMAP_SIZE = layout.offsetof(8);
/*  85 */     BITS_PER_RGB = layout.offsetof(9);
/*     */   }
/*     */   
/*     */   protected XVisualInfo(long paramLong, ByteBuffer paramByteBuffer) {
/*  89 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XVisualInfo create(long paramLong, ByteBuffer paramByteBuffer) {
/*  94 */     return new XVisualInfo(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XVisualInfo(ByteBuffer paramByteBuffer) {
/* 104 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 108 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("Visual *")
/*     */   public Visual visual() {
/* 112 */     return nvisual(address());
/*     */   } @NativeType("VisualID")
/*     */   public long visualid() {
/* 115 */     return nvisualid(address());
/*     */   } public int screen() {
/* 117 */     return nscreen(address());
/*     */   } public int depth() {
/* 119 */     return ndepth(address());
/*     */   } public int class$() {
/* 121 */     return nclass$(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long red_mask() {
/* 124 */     return nred_mask(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long green_mask() {
/* 127 */     return ngreen_mask(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long blue_mask() {
/* 130 */     return nblue_mask(address());
/*     */   } public int colormap_size() {
/* 132 */     return ncolormap_size(address());
/*     */   } public int bits_per_rgb() {
/* 134 */     return nbits_per_rgb(address());
/*     */   }
/*     */   public XVisualInfo visual(@NativeType("Visual *") Visual paramVisual) {
/* 137 */     nvisual(address(), paramVisual); return this;
/*     */   } public XVisualInfo visualid(@NativeType("VisualID") long paramLong) {
/* 139 */     nvisualid(address(), paramLong); return this;
/*     */   } public XVisualInfo screen(int paramInt) {
/* 141 */     nscreen(address(), paramInt); return this;
/*     */   } public XVisualInfo depth(int paramInt) {
/* 143 */     ndepth(address(), paramInt); return this;
/*     */   } public XVisualInfo class$(int paramInt) {
/* 145 */     nclass$(address(), paramInt); return this;
/*     */   } public XVisualInfo red_mask(@NativeType("unsigned long") long paramLong) {
/* 147 */     nred_mask(address(), paramLong); return this;
/*     */   } public XVisualInfo green_mask(@NativeType("unsigned long") long paramLong) {
/* 149 */     ngreen_mask(address(), paramLong); return this;
/*     */   } public XVisualInfo blue_mask(@NativeType("unsigned long") long paramLong) {
/* 151 */     nblue_mask(address(), paramLong); return this;
/*     */   } public XVisualInfo colormap_size(int paramInt) {
/* 153 */     ncolormap_size(address(), paramInt); return this;
/*     */   } public XVisualInfo bits_per_rgb(int paramInt) {
/* 155 */     nbits_per_rgb(address(), paramInt); return this;
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
/*     */   public XVisualInfo set(Visual paramVisual, long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, long paramLong3, long paramLong4, int paramInt4, int paramInt5) {
/* 170 */     visual(paramVisual);
/* 171 */     visualid(paramLong1);
/* 172 */     screen(paramInt1);
/* 173 */     depth(paramInt2);
/* 174 */     class$(paramInt3);
/* 175 */     red_mask(paramLong2);
/* 176 */     green_mask(paramLong3);
/* 177 */     blue_mask(paramLong4);
/* 178 */     colormap_size(paramInt4);
/* 179 */     bits_per_rgb(paramInt5);
/*     */     
/* 181 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XVisualInfo set(XVisualInfo paramXVisualInfo) {
/* 192 */     MemoryUtil.memCopy(paramXVisualInfo.address(), address(), SIZEOF);
/* 193 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XVisualInfo malloc() {
/* 200 */     return new XVisualInfo(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XVisualInfo calloc() {
/* 205 */     return new XVisualInfo(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XVisualInfo create() {
/* 210 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 211 */     return new XVisualInfo(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XVisualInfo create(long paramLong) {
/* 216 */     return new XVisualInfo(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static XVisualInfo createSafe(long paramLong) {
/* 222 */     return (paramLong == 0L) ? null : new XVisualInfo(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 231 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 240 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 249 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 250 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 260 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 266 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static XVisualInfo mallocStack() {
/* 272 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 274 */   public static XVisualInfo callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 276 */   public static XVisualInfo mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 278 */   public static XVisualInfo callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 280 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 282 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 284 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 286 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XVisualInfo malloc(MemoryStack paramMemoryStack) {
/* 294 */     return new XVisualInfo(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XVisualInfo calloc(MemoryStack paramMemoryStack) {
/* 303 */     return new XVisualInfo(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 313 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 323 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Visual nvisual(long paramLong) {
/* 329 */     return Visual.create(MemoryUtil.memGetAddress(paramLong + VISUAL));
/*     */   } public static long nvisualid(long paramLong) {
/* 331 */     return MemoryUtil.memGetCLong(paramLong + VISUALID);
/*     */   } public static int nscreen(long paramLong) {
/* 333 */     return UNSAFE.getInt(null, paramLong + SCREEN);
/*     */   } public static int ndepth(long paramLong) {
/* 335 */     return UNSAFE.getInt(null, paramLong + DEPTH);
/*     */   } public static int nclass$(long paramLong) {
/* 337 */     return UNSAFE.getInt(null, paramLong + CLASS);
/*     */   } public static long nred_mask(long paramLong) {
/* 339 */     return MemoryUtil.memGetCLong(paramLong + RED_MASK);
/*     */   } public static long ngreen_mask(long paramLong) {
/* 341 */     return MemoryUtil.memGetCLong(paramLong + GREEN_MASK);
/*     */   } public static long nblue_mask(long paramLong) {
/* 343 */     return MemoryUtil.memGetCLong(paramLong + BLUE_MASK);
/*     */   } public static int ncolormap_size(long paramLong) {
/* 345 */     return UNSAFE.getInt(null, paramLong + COLORMAP_SIZE);
/*     */   } public static int nbits_per_rgb(long paramLong) {
/* 347 */     return UNSAFE.getInt(null, paramLong + BITS_PER_RGB);
/*     */   }
/*     */   public static void nvisual(long paramLong, Visual paramVisual) {
/* 350 */     MemoryUtil.memPutAddress(paramLong + VISUAL, paramVisual.address());
/*     */   } public static void nvisualid(long paramLong1, long paramLong2) {
/* 352 */     MemoryUtil.memPutCLong(paramLong1 + VISUALID, paramLong2);
/*     */   } public static void nscreen(long paramLong, int paramInt) {
/* 354 */     UNSAFE.putInt(null, paramLong + SCREEN, paramInt);
/*     */   } public static void ndepth(long paramLong, int paramInt) {
/* 356 */     UNSAFE.putInt(null, paramLong + DEPTH, paramInt);
/*     */   } public static void nclass$(long paramLong, int paramInt) {
/* 358 */     UNSAFE.putInt(null, paramLong + CLASS, paramInt);
/*     */   } public static void nred_mask(long paramLong1, long paramLong2) {
/* 360 */     MemoryUtil.memPutCLong(paramLong1 + RED_MASK, paramLong2);
/*     */   } public static void ngreen_mask(long paramLong1, long paramLong2) {
/* 362 */     MemoryUtil.memPutCLong(paramLong1 + GREEN_MASK, paramLong2);
/*     */   } public static void nblue_mask(long paramLong1, long paramLong2) {
/* 364 */     MemoryUtil.memPutCLong(paramLong1 + BLUE_MASK, paramLong2);
/*     */   } public static void ncolormap_size(long paramLong, int paramInt) {
/* 366 */     UNSAFE.putInt(null, paramLong + COLORMAP_SIZE, paramInt);
/*     */   } public static void nbits_per_rgb(long paramLong, int paramInt) {
/* 368 */     UNSAFE.putInt(null, paramLong + BITS_PER_RGB, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 376 */     Checks.check(MemoryUtil.memGetAddress(paramLong + VISUAL));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XVisualInfo, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 384 */     private static final XVisualInfo ELEMENT_FACTORY = XVisualInfo.create(-1L);
/*     */ 
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
/* 396 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / XVisualInfo.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 400 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 404 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 409 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected XVisualInfo getElementFactory() {
/* 414 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("Visual *")
/*     */     public Visual visual() {
/* 419 */       return XVisualInfo.nvisual(address());
/*     */     } @NativeType("VisualID")
/*     */     public long visualid() {
/* 422 */       return XVisualInfo.nvisualid(address());
/*     */     } public int screen() {
/* 424 */       return XVisualInfo.nscreen(address());
/*     */     } public int depth() {
/* 426 */       return XVisualInfo.ndepth(address());
/*     */     } public int class$() {
/* 428 */       return XVisualInfo.nclass$(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long red_mask() {
/* 431 */       return XVisualInfo.nred_mask(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long green_mask() {
/* 434 */       return XVisualInfo.ngreen_mask(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long blue_mask() {
/* 437 */       return XVisualInfo.nblue_mask(address());
/*     */     } public int colormap_size() {
/* 439 */       return XVisualInfo.ncolormap_size(address());
/*     */     } public int bits_per_rgb() {
/* 441 */       return XVisualInfo.nbits_per_rgb(address());
/*     */     }
/*     */     public Buffer visual(@NativeType("Visual *") Visual param1Visual) {
/* 444 */       XVisualInfo.nvisual(address(), param1Visual); return this;
/*     */     } public Buffer visualid(@NativeType("VisualID") long param1Long) {
/* 446 */       XVisualInfo.nvisualid(address(), param1Long); return this;
/*     */     } public Buffer screen(int param1Int) {
/* 448 */       XVisualInfo.nscreen(address(), param1Int); return this;
/*     */     } public Buffer depth(int param1Int) {
/* 450 */       XVisualInfo.ndepth(address(), param1Int); return this;
/*     */     } public Buffer class$(int param1Int) {
/* 452 */       XVisualInfo.nclass$(address(), param1Int); return this;
/*     */     } public Buffer red_mask(@NativeType("unsigned long") long param1Long) {
/* 454 */       XVisualInfo.nred_mask(address(), param1Long); return this;
/*     */     } public Buffer green_mask(@NativeType("unsigned long") long param1Long) {
/* 456 */       XVisualInfo.ngreen_mask(address(), param1Long); return this;
/*     */     } public Buffer blue_mask(@NativeType("unsigned long") long param1Long) {
/* 458 */       XVisualInfo.nblue_mask(address(), param1Long); return this;
/*     */     } public Buffer colormap_size(int param1Int) {
/* 460 */       XVisualInfo.ncolormap_size(address(), param1Int); return this;
/*     */     } public Buffer bits_per_rgb(int param1Int) {
/* 462 */       XVisualInfo.nbits_per_rgb(address(), param1Int); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\XVisualInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */