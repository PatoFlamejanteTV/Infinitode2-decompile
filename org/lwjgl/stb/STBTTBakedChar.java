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
/*     */ @NativeType("struct stbtt_bakedchar")
/*     */ public class STBTTBakedChar
/*     */   extends Struct<STBTTBakedChar>
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
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  64 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(2), __member(2), __member(2), __member(2), __member(4), __member(4), __member(4) })).getSize();
/*  65 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  67 */     X0 = layout.offsetof(0);
/*  68 */     Y0 = layout.offsetof(1);
/*  69 */     X1 = layout.offsetof(2);
/*  70 */     Y1 = layout.offsetof(3);
/*  71 */     XOFF = layout.offsetof(4);
/*  72 */     YOFF = layout.offsetof(5);
/*  73 */     XADVANCE = layout.offsetof(6);
/*     */   }
/*     */   
/*     */   protected STBTTBakedChar(long paramLong, ByteBuffer paramByteBuffer) {
/*  77 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected STBTTBakedChar create(long paramLong, ByteBuffer paramByteBuffer) {
/*  82 */     return new STBTTBakedChar(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBTTBakedChar(ByteBuffer paramByteBuffer) {
/*  92 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  96 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("unsigned short")
/*     */   public short x0() {
/* 100 */     return nx0(address());
/*     */   } @NativeType("unsigned short")
/*     */   public short y0() {
/* 103 */     return ny0(address());
/*     */   } @NativeType("unsigned short")
/*     */   public short x1() {
/* 106 */     return nx1(address());
/*     */   } @NativeType("unsigned short")
/*     */   public short y1() {
/* 109 */     return ny1(address());
/*     */   } public float xoff() {
/* 111 */     return nxoff(address());
/*     */   } public float yoff() {
/* 113 */     return nyoff(address());
/*     */   } public float xadvance() {
/* 115 */     return nxadvance(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTBakedChar malloc() {
/* 121 */     return new STBTTBakedChar(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTBakedChar calloc() {
/* 126 */     return new STBTTBakedChar(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTBakedChar create() {
/* 131 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 132 */     return new STBTTBakedChar(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTBakedChar create(long paramLong) {
/* 137 */     return new STBTTBakedChar(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTBakedChar createSafe(long paramLong) {
/* 143 */     return (paramLong == 0L) ? null : new STBTTBakedChar(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 152 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 161 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 170 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 171 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 181 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 187 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static STBTTBakedChar mallocStack() {
/* 193 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 195 */   public static STBTTBakedChar callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 197 */   public static STBTTBakedChar mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 199 */   public static STBTTBakedChar callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 201 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 203 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 205 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 207 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTBakedChar malloc(MemoryStack paramMemoryStack) {
/* 215 */     return new STBTTBakedChar(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTBakedChar calloc(MemoryStack paramMemoryStack) {
/* 224 */     return new STBTTBakedChar(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 234 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 244 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static short nx0(long paramLong) {
/* 250 */     return UNSAFE.getShort(null, paramLong + X0);
/*     */   } public static short ny0(long paramLong) {
/* 252 */     return UNSAFE.getShort(null, paramLong + Y0);
/*     */   } public static short nx1(long paramLong) {
/* 254 */     return UNSAFE.getShort(null, paramLong + X1);
/*     */   } public static short ny1(long paramLong) {
/* 256 */     return UNSAFE.getShort(null, paramLong + Y1);
/*     */   } public static float nxoff(long paramLong) {
/* 258 */     return UNSAFE.getFloat(null, paramLong + XOFF);
/*     */   } public static float nyoff(long paramLong) {
/* 260 */     return UNSAFE.getFloat(null, paramLong + YOFF);
/*     */   } public static float nxadvance(long paramLong) {
/* 262 */     return UNSAFE.getFloat(null, paramLong + XADVANCE);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<STBTTBakedChar, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 269 */     private static final STBTTBakedChar ELEMENT_FACTORY = STBTTBakedChar.create(-1L);
/*     */ 
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
/* 281 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / STBTTBakedChar.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 285 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 289 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 294 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected STBTTBakedChar getElementFactory() {
/* 299 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("unsigned short")
/*     */     public short x0() {
/* 304 */       return STBTTBakedChar.nx0(address());
/*     */     } @NativeType("unsigned short")
/*     */     public short y0() {
/* 307 */       return STBTTBakedChar.ny0(address());
/*     */     } @NativeType("unsigned short")
/*     */     public short x1() {
/* 310 */       return STBTTBakedChar.nx1(address());
/*     */     } @NativeType("unsigned short")
/*     */     public short y1() {
/* 313 */       return STBTTBakedChar.ny1(address());
/*     */     } public float xoff() {
/* 315 */       return STBTTBakedChar.nxoff(address());
/*     */     } public float yoff() {
/* 317 */       return STBTTBakedChar.nyoff(address());
/*     */     } public float xadvance() {
/* 319 */       return STBTTBakedChar.nxadvance(address());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\stb\STBTTBakedChar.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */