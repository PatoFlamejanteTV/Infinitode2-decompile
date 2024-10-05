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
/*     */ @NativeType("struct stbrp_rect")
/*     */ public class STBRPRect
/*     */   extends Struct<STBRPRect>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int ID;
/*     */   public static final int W;
/*     */   public static final int H;
/*     */   public static final int X;
/*     */   public static final int Y;
/*     */   public static final int WAS_PACKED;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  61 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(4), __member(4), __member(4), __member(4), __member(4) })).getSize();
/*  62 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  64 */     ID = layout.offsetof(0);
/*  65 */     W = layout.offsetof(1);
/*  66 */     H = layout.offsetof(2);
/*  67 */     X = layout.offsetof(3);
/*  68 */     Y = layout.offsetof(4);
/*  69 */     WAS_PACKED = layout.offsetof(5);
/*     */   }
/*     */   
/*     */   protected STBRPRect(long paramLong, ByteBuffer paramByteBuffer) {
/*  73 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected STBRPRect create(long paramLong, ByteBuffer paramByteBuffer) {
/*  78 */     return new STBRPRect(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBRPRect(ByteBuffer paramByteBuffer) {
/*  88 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  92 */     return SIZEOF;
/*     */   }
/*     */   public int id() {
/*  95 */     return nid(address());
/*     */   } @NativeType("stbrp_coord")
/*     */   public int w() {
/*  98 */     return nw(address());
/*     */   } @NativeType("stbrp_coord")
/*     */   public int h() {
/* 101 */     return nh(address());
/*     */   } @NativeType("stbrp_coord")
/*     */   public int x() {
/* 104 */     return nx(address());
/*     */   } @NativeType("stbrp_coord")
/*     */   public int y() {
/* 107 */     return ny(address());
/*     */   } @NativeType("int")
/*     */   public boolean was_packed() {
/* 110 */     return (nwas_packed(address()) != 0);
/*     */   }
/*     */   public STBRPRect id(int paramInt) {
/* 113 */     nid(address(), paramInt); return this;
/*     */   } public STBRPRect w(@NativeType("stbrp_coord") int paramInt) {
/* 115 */     nw(address(), paramInt); return this;
/*     */   } public STBRPRect h(@NativeType("stbrp_coord") int paramInt) {
/* 117 */     nh(address(), paramInt); return this;
/*     */   } public STBRPRect x(@NativeType("stbrp_coord") int paramInt) {
/* 119 */     nx(address(), paramInt); return this;
/*     */   } public STBRPRect y(@NativeType("stbrp_coord") int paramInt) {
/* 121 */     ny(address(), paramInt); return this;
/*     */   } public STBRPRect was_packed(@NativeType("int") boolean paramBoolean) {
/* 123 */     nwas_packed(address(), paramBoolean ? 1 : 0); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBRPRect set(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean) {
/* 134 */     id(paramInt1);
/* 135 */     w(paramInt2);
/* 136 */     h(paramInt3);
/* 137 */     x(paramInt4);
/* 138 */     y(paramInt5);
/* 139 */     was_packed(paramBoolean);
/*     */     
/* 141 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBRPRect set(STBRPRect paramSTBRPRect) {
/* 152 */     MemoryUtil.memCopy(paramSTBRPRect.address(), address(), SIZEOF);
/* 153 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBRPRect malloc() {
/* 160 */     return new STBRPRect(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBRPRect calloc() {
/* 165 */     return new STBRPRect(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBRPRect create() {
/* 170 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 171 */     return new STBRPRect(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBRPRect create(long paramLong) {
/* 176 */     return new STBRPRect(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBRPRect createSafe(long paramLong) {
/* 182 */     return (paramLong == 0L) ? null : new STBRPRect(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 191 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 200 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 209 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 210 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 220 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 226 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static STBRPRect mallocStack() {
/* 232 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 234 */   public static STBRPRect callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 236 */   public static STBRPRect mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 238 */   public static STBRPRect callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 240 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 242 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 244 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 246 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBRPRect malloc(MemoryStack paramMemoryStack) {
/* 254 */     return new STBRPRect(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBRPRect calloc(MemoryStack paramMemoryStack) {
/* 263 */     return new STBRPRect(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 273 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 283 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nid(long paramLong) {
/* 289 */     return UNSAFE.getInt(null, paramLong + ID);
/*     */   } public static int nw(long paramLong) {
/* 291 */     return UNSAFE.getInt(null, paramLong + W);
/*     */   } public static int nh(long paramLong) {
/* 293 */     return UNSAFE.getInt(null, paramLong + H);
/*     */   } public static int nx(long paramLong) {
/* 295 */     return UNSAFE.getInt(null, paramLong + X);
/*     */   } public static int ny(long paramLong) {
/* 297 */     return UNSAFE.getInt(null, paramLong + Y);
/*     */   } public static int nwas_packed(long paramLong) {
/* 299 */     return UNSAFE.getInt(null, paramLong + WAS_PACKED);
/*     */   }
/*     */   public static void nid(long paramLong, int paramInt) {
/* 302 */     UNSAFE.putInt(null, paramLong + ID, paramInt);
/*     */   } public static void nw(long paramLong, int paramInt) {
/* 304 */     UNSAFE.putInt(null, paramLong + W, paramInt);
/*     */   } public static void nh(long paramLong, int paramInt) {
/* 306 */     UNSAFE.putInt(null, paramLong + H, paramInt);
/*     */   } public static void nx(long paramLong, int paramInt) {
/* 308 */     UNSAFE.putInt(null, paramLong + X, paramInt);
/*     */   } public static void ny(long paramLong, int paramInt) {
/* 310 */     UNSAFE.putInt(null, paramLong + Y, paramInt);
/*     */   } public static void nwas_packed(long paramLong, int paramInt) {
/* 312 */     UNSAFE.putInt(null, paramLong + WAS_PACKED, paramInt);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<STBRPRect, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 319 */     private static final STBRPRect ELEMENT_FACTORY = STBRPRect.create(-1L);
/*     */ 
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
/* 331 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / STBRPRect.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 335 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 339 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 344 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected STBRPRect getElementFactory() {
/* 349 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int id() {
/* 353 */       return STBRPRect.nid(address());
/*     */     } @NativeType("stbrp_coord")
/*     */     public int w() {
/* 356 */       return STBRPRect.nw(address());
/*     */     } @NativeType("stbrp_coord")
/*     */     public int h() {
/* 359 */       return STBRPRect.nh(address());
/*     */     } @NativeType("stbrp_coord")
/*     */     public int x() {
/* 362 */       return STBRPRect.nx(address());
/*     */     } @NativeType("stbrp_coord")
/*     */     public int y() {
/* 365 */       return STBRPRect.ny(address());
/*     */     } @NativeType("int")
/*     */     public boolean was_packed() {
/* 368 */       return (STBRPRect.nwas_packed(address()) != 0);
/*     */     }
/*     */     public Buffer id(int param1Int) {
/* 371 */       STBRPRect.nid(address(), param1Int); return this;
/*     */     } public Buffer w(@NativeType("stbrp_coord") int param1Int) {
/* 373 */       STBRPRect.nw(address(), param1Int); return this;
/*     */     } public Buffer h(@NativeType("stbrp_coord") int param1Int) {
/* 375 */       STBRPRect.nh(address(), param1Int); return this;
/*     */     } public Buffer x(@NativeType("stbrp_coord") int param1Int) {
/* 377 */       STBRPRect.nx(address(), param1Int); return this;
/*     */     } public Buffer y(@NativeType("stbrp_coord") int param1Int) {
/* 379 */       STBRPRect.ny(address(), param1Int); return this;
/*     */     } public Buffer was_packed(@NativeType("int") boolean param1Boolean) {
/* 381 */       STBRPRect.nwas_packed(address(), param1Boolean ? 1 : 0); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\stb\STBRPRect.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */