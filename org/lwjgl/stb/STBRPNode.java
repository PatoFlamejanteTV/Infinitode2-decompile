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
/*     */ @NativeType("struct stbrp_node")
/*     */ public class STBRPNode
/*     */   extends Struct<STBRPNode>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int X;
/*     */   public static final int Y;
/*     */   public static final int NEXT;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  52 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(4), __member(POINTER_SIZE) })).getSize();
/*  53 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  55 */     X = layout.offsetof(0);
/*  56 */     Y = layout.offsetof(1);
/*  57 */     NEXT = layout.offsetof(2);
/*     */   }
/*     */   
/*     */   protected STBRPNode(long paramLong, ByteBuffer paramByteBuffer) {
/*  61 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected STBRPNode create(long paramLong, ByteBuffer paramByteBuffer) {
/*  66 */     return new STBRPNode(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBRPNode(ByteBuffer paramByteBuffer) {
/*  76 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  80 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("stbrp_coord")
/*     */   public int x() {
/*  84 */     return nx(address());
/*     */   } @NativeType("stbrp_coord")
/*     */   public int y() {
/*  87 */     return ny(address());
/*     */   }
/*     */   @NativeType("stbrp_node *")
/*     */   public STBRPNode next() {
/*  91 */     return nnext(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBRPNode malloc() {
/*  97 */     return new STBRPNode(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBRPNode calloc() {
/* 102 */     return new STBRPNode(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBRPNode create() {
/* 107 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 108 */     return new STBRPNode(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBRPNode create(long paramLong) {
/* 113 */     return new STBRPNode(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBRPNode createSafe(long paramLong) {
/* 119 */     return (paramLong == 0L) ? null : new STBRPNode(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 128 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 137 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 146 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 147 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 157 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 163 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static STBRPNode mallocStack() {
/* 169 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 171 */   public static STBRPNode callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 173 */   public static STBRPNode mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 175 */   public static STBRPNode callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 177 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 179 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 181 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 183 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBRPNode malloc(MemoryStack paramMemoryStack) {
/* 191 */     return new STBRPNode(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBRPNode calloc(MemoryStack paramMemoryStack) {
/* 200 */     return new STBRPNode(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 210 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 220 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nx(long paramLong) {
/* 226 */     return UNSAFE.getInt(null, paramLong + X);
/*     */   } public static int ny(long paramLong) {
/* 228 */     return UNSAFE.getInt(null, paramLong + Y);
/*     */   } public static STBRPNode nnext(long paramLong) {
/* 230 */     return createSafe(MemoryUtil.memGetAddress(paramLong + NEXT));
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<STBRPNode, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 237 */     private static final STBRPNode ELEMENT_FACTORY = STBRPNode.create(-1L);
/*     */ 
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
/* 249 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / STBRPNode.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 253 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 257 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 262 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected STBRPNode getElementFactory() {
/* 267 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("stbrp_coord")
/*     */     public int x() {
/* 272 */       return STBRPNode.nx(address());
/*     */     } @NativeType("stbrp_coord")
/*     */     public int y() {
/* 275 */       return STBRPNode.ny(address());
/*     */     }
/*     */     @NativeType("stbrp_node *")
/*     */     public STBRPNode next() {
/* 279 */       return STBRPNode.nnext(address());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\stb\STBRPNode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */