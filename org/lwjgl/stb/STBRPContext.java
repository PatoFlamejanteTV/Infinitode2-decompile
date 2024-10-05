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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @NativeType("struct stbrp_context")
/*     */ public class STBRPContext
/*     */   extends Struct<STBRPContext>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int WIDTH;
/*     */   public static final int HEIGHT;
/*     */   public static final int ALIGN;
/*     */   public static final int INIT_MODE;
/*     */   public static final int HEURISTIC;
/*     */   public static final int NUM_NODES;
/*     */   public static final int ACTIVE_HEAD;
/*     */   public static final int FREE_HEAD;
/*     */   public static final int EXTRA;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  71 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(4), __member(4), __member(4), __member(4), __member(4), __member(POINTER_SIZE), __member(POINTER_SIZE), __array(STBRPNode.SIZEOF, STBRPNode.ALIGNOF, 2) })).getSize();
/*  72 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  74 */     WIDTH = layout.offsetof(0);
/*  75 */     HEIGHT = layout.offsetof(1);
/*  76 */     ALIGN = layout.offsetof(2);
/*  77 */     INIT_MODE = layout.offsetof(3);
/*  78 */     HEURISTIC = layout.offsetof(4);
/*  79 */     NUM_NODES = layout.offsetof(5);
/*  80 */     ACTIVE_HEAD = layout.offsetof(6);
/*  81 */     FREE_HEAD = layout.offsetof(7);
/*  82 */     EXTRA = layout.offsetof(8);
/*     */   }
/*     */   
/*     */   protected STBRPContext(long paramLong, ByteBuffer paramByteBuffer) {
/*  86 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected STBRPContext create(long paramLong, ByteBuffer paramByteBuffer) {
/*  91 */     return new STBRPContext(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBRPContext(ByteBuffer paramByteBuffer) {
/* 101 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 105 */     return SIZEOF;
/*     */   }
/*     */   public int width() {
/* 108 */     return nwidth(address());
/*     */   } public int height() {
/* 110 */     return nheight(address());
/*     */   } public int align() {
/* 112 */     return nalign(address());
/*     */   } public int init_mode() {
/* 114 */     return ninit_mode(address());
/*     */   } public int heuristic() {
/* 116 */     return nheuristic(address());
/*     */   } public int num_nodes() {
/* 118 */     return nnum_nodes(address());
/*     */   }
/*     */   @NativeType("stbrp_node *")
/*     */   public STBRPNode active_head() {
/* 122 */     return nactive_head(address());
/*     */   }
/*     */   @NativeType("stbrp_node *")
/*     */   public STBRPNode free_head() {
/* 126 */     return nfree_head(address());
/*     */   } @NativeType("stbrp_node[2]")
/*     */   public STBRPNode.Buffer extra() {
/* 129 */     return nextra(address());
/*     */   } @NativeType("stbrp_node")
/*     */   public STBRPNode extra(int paramInt) {
/* 132 */     return nextra(address(), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBRPContext malloc() {
/* 138 */     return new STBRPContext(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBRPContext calloc() {
/* 143 */     return new STBRPContext(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBRPContext create() {
/* 148 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 149 */     return new STBRPContext(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBRPContext create(long paramLong) {
/* 154 */     return new STBRPContext(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBRPContext createSafe(long paramLong) {
/* 160 */     return (paramLong == 0L) ? null : new STBRPContext(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 169 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 178 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 187 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 188 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 198 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 204 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static STBRPContext mallocStack() {
/* 210 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 212 */   public static STBRPContext callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 214 */   public static STBRPContext mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 216 */   public static STBRPContext callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 218 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 220 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 222 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 224 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBRPContext malloc(MemoryStack paramMemoryStack) {
/* 232 */     return new STBRPContext(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBRPContext calloc(MemoryStack paramMemoryStack) {
/* 241 */     return new STBRPContext(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 251 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 261 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nwidth(long paramLong) {
/* 267 */     return UNSAFE.getInt(null, paramLong + WIDTH);
/*     */   } public static int nheight(long paramLong) {
/* 269 */     return UNSAFE.getInt(null, paramLong + HEIGHT);
/*     */   } public static int nalign(long paramLong) {
/* 271 */     return UNSAFE.getInt(null, paramLong + ALIGN);
/*     */   } public static int ninit_mode(long paramLong) {
/* 273 */     return UNSAFE.getInt(null, paramLong + INIT_MODE);
/*     */   } public static int nheuristic(long paramLong) {
/* 275 */     return UNSAFE.getInt(null, paramLong + HEURISTIC);
/*     */   } public static int nnum_nodes(long paramLong) {
/* 277 */     return UNSAFE.getInt(null, paramLong + NUM_NODES);
/*     */   } public static STBRPNode nactive_head(long paramLong) {
/* 279 */     return STBRPNode.createSafe(MemoryUtil.memGetAddress(paramLong + ACTIVE_HEAD));
/*     */   } public static STBRPNode nfree_head(long paramLong) {
/* 281 */     return STBRPNode.createSafe(MemoryUtil.memGetAddress(paramLong + FREE_HEAD));
/*     */   } public static STBRPNode.Buffer nextra(long paramLong) {
/* 283 */     return STBRPNode.create(paramLong + EXTRA, 2);
/*     */   }
/*     */   public static STBRPNode nextra(long paramLong, int paramInt) {
/* 286 */     return STBRPNode.create(paramLong + EXTRA + Checks.check(paramInt, 2) * STBRPNode.SIZEOF);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<STBRPContext, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 294 */     private static final STBRPContext ELEMENT_FACTORY = STBRPContext.create(-1L);
/*     */ 
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
/* 306 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / STBRPContext.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 310 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 314 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 319 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected STBRPContext getElementFactory() {
/* 324 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int width() {
/* 328 */       return STBRPContext.nwidth(address());
/*     */     } public int height() {
/* 330 */       return STBRPContext.nheight(address());
/*     */     } public int align() {
/* 332 */       return STBRPContext.nalign(address());
/*     */     } public int init_mode() {
/* 334 */       return STBRPContext.ninit_mode(address());
/*     */     } public int heuristic() {
/* 336 */       return STBRPContext.nheuristic(address());
/*     */     } public int num_nodes() {
/* 338 */       return STBRPContext.nnum_nodes(address());
/*     */     }
/*     */     @NativeType("stbrp_node *")
/*     */     public STBRPNode active_head() {
/* 342 */       return STBRPContext.nactive_head(address());
/*     */     }
/*     */     @NativeType("stbrp_node *")
/*     */     public STBRPNode free_head() {
/* 346 */       return STBRPContext.nfree_head(address());
/*     */     } @NativeType("stbrp_node[2]")
/*     */     public STBRPNode.Buffer extra() {
/* 349 */       return STBRPContext.nextra(address());
/*     */     } @NativeType("stbrp_node")
/*     */     public STBRPNode extra(int param1Int) {
/* 352 */       return STBRPContext.nextra(address(), param1Int);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\stb\STBRPContext.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */