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
/*     */ @NativeType("struct stbtt_vertex")
/*     */ public class STBTTVertex
/*     */   extends Struct<STBTTVertex>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int X;
/*     */   public static final int Y;
/*     */   public static final int CX;
/*     */   public static final int CY;
/*     */   public static final int CX1;
/*     */   public static final int CY1;
/*     */   public static final int TYPE;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  64 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(2), __member(2), __member(2), __member(2), __member(2), __member(2), __member(1) })).getSize();
/*  65 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  67 */     X = layout.offsetof(0);
/*  68 */     Y = layout.offsetof(1);
/*  69 */     CX = layout.offsetof(2);
/*  70 */     CY = layout.offsetof(3);
/*  71 */     CX1 = layout.offsetof(4);
/*  72 */     CY1 = layout.offsetof(5);
/*  73 */     TYPE = layout.offsetof(6);
/*     */   }
/*     */   
/*     */   protected STBTTVertex(long paramLong, ByteBuffer paramByteBuffer) {
/*  77 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected STBTTVertex create(long paramLong, ByteBuffer paramByteBuffer) {
/*  82 */     return new STBTTVertex(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBTTVertex(ByteBuffer paramByteBuffer) {
/*  92 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  96 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("stbtt_vertex_type")
/*     */   public short x() {
/* 100 */     return nx(address());
/*     */   } @NativeType("stbtt_vertex_type")
/*     */   public short y() {
/* 103 */     return ny(address());
/*     */   } @NativeType("stbtt_vertex_type")
/*     */   public short cx() {
/* 106 */     return ncx(address());
/*     */   } @NativeType("stbtt_vertex_type")
/*     */   public short cy() {
/* 109 */     return ncy(address());
/*     */   } @NativeType("stbtt_vertex_type")
/*     */   public short cx1() {
/* 112 */     return ncx1(address());
/*     */   } @NativeType("stbtt_vertex_type")
/*     */   public short cy1() {
/* 115 */     return ncy1(address());
/*     */   } @NativeType("unsigned char")
/*     */   public byte type() {
/* 118 */     return ntype(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTVertex malloc() {
/* 124 */     return new STBTTVertex(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTVertex calloc() {
/* 129 */     return new STBTTVertex(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTVertex create() {
/* 134 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 135 */     return new STBTTVertex(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTVertex create(long paramLong) {
/* 140 */     return new STBTTVertex(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTVertex createSafe(long paramLong) {
/* 146 */     return (paramLong == 0L) ? null : new STBTTVertex(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 155 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 164 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 173 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 174 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 184 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 190 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static STBTTVertex mallocStack() {
/* 196 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 198 */   public static STBTTVertex callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 200 */   public static STBTTVertex mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 202 */   public static STBTTVertex callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 204 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 206 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 208 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 210 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTVertex malloc(MemoryStack paramMemoryStack) {
/* 218 */     return new STBTTVertex(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTVertex calloc(MemoryStack paramMemoryStack) {
/* 227 */     return new STBTTVertex(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 237 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 247 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static short nx(long paramLong) {
/* 253 */     return UNSAFE.getShort(null, paramLong + X);
/*     */   } public static short ny(long paramLong) {
/* 255 */     return UNSAFE.getShort(null, paramLong + Y);
/*     */   } public static short ncx(long paramLong) {
/* 257 */     return UNSAFE.getShort(null, paramLong + CX);
/*     */   } public static short ncy(long paramLong) {
/* 259 */     return UNSAFE.getShort(null, paramLong + CY);
/*     */   } public static short ncx1(long paramLong) {
/* 261 */     return UNSAFE.getShort(null, paramLong + CX1);
/*     */   } public static short ncy1(long paramLong) {
/* 263 */     return UNSAFE.getShort(null, paramLong + CY1);
/*     */   } public static byte ntype(long paramLong) {
/* 265 */     return UNSAFE.getByte(null, paramLong + TYPE);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<STBTTVertex, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 272 */     private static final STBTTVertex ELEMENT_FACTORY = STBTTVertex.create(-1L);
/*     */ 
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
/* 284 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / STBTTVertex.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 288 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 292 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 297 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected STBTTVertex getElementFactory() {
/* 302 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("stbtt_vertex_type")
/*     */     public short x() {
/* 307 */       return STBTTVertex.nx(address());
/*     */     } @NativeType("stbtt_vertex_type")
/*     */     public short y() {
/* 310 */       return STBTTVertex.ny(address());
/*     */     } @NativeType("stbtt_vertex_type")
/*     */     public short cx() {
/* 313 */       return STBTTVertex.ncx(address());
/*     */     } @NativeType("stbtt_vertex_type")
/*     */     public short cy() {
/* 316 */       return STBTTVertex.ncy(address());
/*     */     } @NativeType("stbtt_vertex_type")
/*     */     public short cx1() {
/* 319 */       return STBTTVertex.ncx1(address());
/*     */     } @NativeType("stbtt_vertex_type")
/*     */     public short cy1() {
/* 322 */       return STBTTVertex.ncy1(address());
/*     */     } @NativeType("unsigned char")
/*     */     public byte type() {
/* 325 */       return STBTTVertex.ntype(address());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\stb\STBTTVertex.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */