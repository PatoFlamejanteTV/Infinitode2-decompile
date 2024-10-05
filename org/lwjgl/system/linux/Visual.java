/*     */ package org.lwjgl.system.linux;
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
/*     */ public class Visual
/*     */   extends Struct<Visual>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int EXT_DATA;
/*     */   public static final int VISUALID;
/*     */   public static final int CLASS;
/*     */   public static final int RED_MASK;
/*     */   public static final int GREEN_MASK;
/*     */   public static final int BLUE_MASK;
/*     */   public static final int BITS_PER_RGB;
/*     */   public static final int MAP_ENTRIES;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  66 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(POINTER_SIZE), __member(CLONG_SIZE), __member(4), __member(CLONG_SIZE), __member(CLONG_SIZE), __member(CLONG_SIZE), __member(4), __member(4) })).getSize();
/*  67 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  69 */     EXT_DATA = layout.offsetof(0);
/*  70 */     VISUALID = layout.offsetof(1);
/*  71 */     CLASS = layout.offsetof(2);
/*  72 */     RED_MASK = layout.offsetof(3);
/*  73 */     GREEN_MASK = layout.offsetof(4);
/*  74 */     BLUE_MASK = layout.offsetof(5);
/*  75 */     BITS_PER_RGB = layout.offsetof(6);
/*  76 */     MAP_ENTRIES = layout.offsetof(7);
/*     */   }
/*     */   
/*     */   protected Visual(long paramLong, ByteBuffer paramByteBuffer) {
/*  80 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Visual create(long paramLong, ByteBuffer paramByteBuffer) {
/*  85 */     return new Visual(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Visual(ByteBuffer paramByteBuffer) {
/*  95 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  99 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("void *")
/*     */   public long ext_data() {
/* 103 */     return next_data(address());
/*     */   } @NativeType("VisualID")
/*     */   public long visualid() {
/* 106 */     return nvisualid(address());
/*     */   } public int class$() {
/* 108 */     return nclass$(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long red_mask() {
/* 111 */     return nred_mask(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long green_mask() {
/* 114 */     return ngreen_mask(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long blue_mask() {
/* 117 */     return nblue_mask(address());
/*     */   } public int bits_per_rgb() {
/* 119 */     return nbits_per_rgb(address());
/*     */   } public int map_entries() {
/* 121 */     return nmap_entries(address());
/*     */   }
/*     */   public Visual ext_data(@NativeType("void *") long paramLong) {
/* 124 */     next_data(address(), paramLong); return this;
/*     */   } public Visual visualid(@NativeType("VisualID") long paramLong) {
/* 126 */     nvisualid(address(), paramLong); return this;
/*     */   } public Visual class$(int paramInt) {
/* 128 */     nclass$(address(), paramInt); return this;
/*     */   } public Visual red_mask(@NativeType("unsigned long") long paramLong) {
/* 130 */     nred_mask(address(), paramLong); return this;
/*     */   } public Visual green_mask(@NativeType("unsigned long") long paramLong) {
/* 132 */     ngreen_mask(address(), paramLong); return this;
/*     */   } public Visual blue_mask(@NativeType("unsigned long") long paramLong) {
/* 134 */     nblue_mask(address(), paramLong); return this;
/*     */   } public Visual bits_per_rgb(int paramInt) {
/* 136 */     nbits_per_rgb(address(), paramInt); return this;
/*     */   } public Visual map_entries(int paramInt) {
/* 138 */     nmap_entries(address(), paramInt); return this;
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
/*     */   public Visual set(long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, long paramLong5, int paramInt2, int paramInt3) {
/* 151 */     ext_data(paramLong1);
/* 152 */     visualid(paramLong2);
/* 153 */     class$(paramInt1);
/* 154 */     red_mask(paramLong3);
/* 155 */     green_mask(paramLong4);
/* 156 */     blue_mask(paramLong5);
/* 157 */     bits_per_rgb(paramInt2);
/* 158 */     map_entries(paramInt3);
/*     */     
/* 160 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Visual set(Visual paramVisual) {
/* 171 */     MemoryUtil.memCopy(paramVisual.address(), address(), SIZEOF);
/* 172 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Visual malloc() {
/* 179 */     return new Visual(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Visual calloc() {
/* 184 */     return new Visual(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Visual create() {
/* 189 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 190 */     return new Visual(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Visual create(long paramLong) {
/* 195 */     return new Visual(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Visual createSafe(long paramLong) {
/* 201 */     return (paramLong == 0L) ? null : new Visual(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 210 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 219 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 228 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 229 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 239 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 245 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static Visual mallocStack() {
/* 251 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 253 */   public static Visual callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 255 */   public static Visual mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 257 */   public static Visual callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 259 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 261 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 263 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 265 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Visual malloc(MemoryStack paramMemoryStack) {
/* 273 */     return new Visual(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Visual calloc(MemoryStack paramMemoryStack) {
/* 282 */     return new Visual(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 292 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 302 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long next_data(long paramLong) {
/* 308 */     return MemoryUtil.memGetAddress(paramLong + EXT_DATA);
/*     */   } public static long nvisualid(long paramLong) {
/* 310 */     return MemoryUtil.memGetCLong(paramLong + VISUALID);
/*     */   } public static int nclass$(long paramLong) {
/* 312 */     return UNSAFE.getInt(null, paramLong + CLASS);
/*     */   } public static long nred_mask(long paramLong) {
/* 314 */     return MemoryUtil.memGetCLong(paramLong + RED_MASK);
/*     */   } public static long ngreen_mask(long paramLong) {
/* 316 */     return MemoryUtil.memGetCLong(paramLong + GREEN_MASK);
/*     */   } public static long nblue_mask(long paramLong) {
/* 318 */     return MemoryUtil.memGetCLong(paramLong + BLUE_MASK);
/*     */   } public static int nbits_per_rgb(long paramLong) {
/* 320 */     return UNSAFE.getInt(null, paramLong + BITS_PER_RGB);
/*     */   } public static int nmap_entries(long paramLong) {
/* 322 */     return UNSAFE.getInt(null, paramLong + MAP_ENTRIES);
/*     */   }
/*     */   public static void next_data(long paramLong1, long paramLong2) {
/* 325 */     MemoryUtil.memPutAddress(paramLong1 + EXT_DATA, paramLong2);
/*     */   } public static void nvisualid(long paramLong1, long paramLong2) {
/* 327 */     MemoryUtil.memPutCLong(paramLong1 + VISUALID, paramLong2);
/*     */   } public static void nclass$(long paramLong, int paramInt) {
/* 329 */     UNSAFE.putInt(null, paramLong + CLASS, paramInt);
/*     */   } public static void nred_mask(long paramLong1, long paramLong2) {
/* 331 */     MemoryUtil.memPutCLong(paramLong1 + RED_MASK, paramLong2);
/*     */   } public static void ngreen_mask(long paramLong1, long paramLong2) {
/* 333 */     MemoryUtil.memPutCLong(paramLong1 + GREEN_MASK, paramLong2);
/*     */   } public static void nblue_mask(long paramLong1, long paramLong2) {
/* 335 */     MemoryUtil.memPutCLong(paramLong1 + BLUE_MASK, paramLong2);
/*     */   } public static void nbits_per_rgb(long paramLong, int paramInt) {
/* 337 */     UNSAFE.putInt(null, paramLong + BITS_PER_RGB, paramInt);
/*     */   } public static void nmap_entries(long paramLong, int paramInt) {
/* 339 */     UNSAFE.putInt(null, paramLong + MAP_ENTRIES, paramInt);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<Visual, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 346 */     private static final Visual ELEMENT_FACTORY = Visual.create(-1L);
/*     */ 
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
/* 358 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / Visual.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 362 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 366 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 371 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Visual getElementFactory() {
/* 376 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("void *")
/*     */     public long ext_data() {
/* 381 */       return Visual.next_data(address());
/*     */     } @NativeType("VisualID")
/*     */     public long visualid() {
/* 384 */       return Visual.nvisualid(address());
/*     */     } public int class$() {
/* 386 */       return Visual.nclass$(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long red_mask() {
/* 389 */       return Visual.nred_mask(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long green_mask() {
/* 392 */       return Visual.ngreen_mask(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long blue_mask() {
/* 395 */       return Visual.nblue_mask(address());
/*     */     } public int bits_per_rgb() {
/* 397 */       return Visual.nbits_per_rgb(address());
/*     */     } public int map_entries() {
/* 399 */       return Visual.nmap_entries(address());
/*     */     }
/*     */     public Buffer ext_data(@NativeType("void *") long param1Long) {
/* 402 */       Visual.next_data(address(), param1Long); return this;
/*     */     } public Buffer visualid(@NativeType("VisualID") long param1Long) {
/* 404 */       Visual.nvisualid(address(), param1Long); return this;
/*     */     } public Buffer class$(int param1Int) {
/* 406 */       Visual.nclass$(address(), param1Int); return this;
/*     */     } public Buffer red_mask(@NativeType("unsigned long") long param1Long) {
/* 408 */       Visual.nred_mask(address(), param1Long); return this;
/*     */     } public Buffer green_mask(@NativeType("unsigned long") long param1Long) {
/* 410 */       Visual.ngreen_mask(address(), param1Long); return this;
/*     */     } public Buffer blue_mask(@NativeType("unsigned long") long param1Long) {
/* 412 */       Visual.nblue_mask(address(), param1Long); return this;
/*     */     } public Buffer bits_per_rgb(int param1Int) {
/* 414 */       Visual.nbits_per_rgb(address(), param1Int); return this;
/*     */     } public Buffer map_entries(int param1Int) {
/* 416 */       Visual.nmap_entries(address(), param1Int); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\Visual.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */