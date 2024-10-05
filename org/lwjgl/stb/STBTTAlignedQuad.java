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
/*     */ @NativeType("struct stbtt_aligned_quad")
/*     */ public class STBTTAlignedQuad
/*     */   extends Struct<STBTTAlignedQuad>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int X0;
/*     */   public static final int Y0;
/*     */   public static final int S0;
/*     */   public static final int T0;
/*     */   public static final int X1;
/*     */   public static final int Y1;
/*     */   public static final int S1;
/*     */   public static final int T1;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  67 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(4), __member(4), __member(4), __member(4), __member(4), __member(4), __member(4) })).getSize();
/*  68 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  70 */     X0 = layout.offsetof(0);
/*  71 */     Y0 = layout.offsetof(1);
/*  72 */     S0 = layout.offsetof(2);
/*  73 */     T0 = layout.offsetof(3);
/*  74 */     X1 = layout.offsetof(4);
/*  75 */     Y1 = layout.offsetof(5);
/*  76 */     S1 = layout.offsetof(6);
/*  77 */     T1 = layout.offsetof(7);
/*     */   }
/*     */   
/*     */   protected STBTTAlignedQuad(long paramLong, ByteBuffer paramByteBuffer) {
/*  81 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected STBTTAlignedQuad create(long paramLong, ByteBuffer paramByteBuffer) {
/*  86 */     return new STBTTAlignedQuad(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBTTAlignedQuad(ByteBuffer paramByteBuffer) {
/*  96 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 100 */     return SIZEOF;
/*     */   }
/*     */   public float x0() {
/* 103 */     return nx0(address());
/*     */   } public float y0() {
/* 105 */     return ny0(address());
/*     */   } public float s0() {
/* 107 */     return ns0(address());
/*     */   } public float t0() {
/* 109 */     return nt0(address());
/*     */   } public float x1() {
/* 111 */     return nx1(address());
/*     */   } public float y1() {
/* 113 */     return ny1(address());
/*     */   } public float s1() {
/* 115 */     return ns1(address());
/*     */   } public float t1() {
/* 117 */     return nt1(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTAlignedQuad malloc() {
/* 123 */     return new STBTTAlignedQuad(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTAlignedQuad calloc() {
/* 128 */     return new STBTTAlignedQuad(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTAlignedQuad create() {
/* 133 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 134 */     return new STBTTAlignedQuad(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTAlignedQuad create(long paramLong) {
/* 139 */     return new STBTTAlignedQuad(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTAlignedQuad createSafe(long paramLong) {
/* 145 */     return (paramLong == 0L) ? null : new STBTTAlignedQuad(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 154 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 163 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 172 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 173 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 183 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 189 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static STBTTAlignedQuad mallocStack() {
/* 195 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 197 */   public static STBTTAlignedQuad callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 199 */   public static STBTTAlignedQuad mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 201 */   public static STBTTAlignedQuad callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 203 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 205 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 207 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 209 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTAlignedQuad malloc(MemoryStack paramMemoryStack) {
/* 217 */     return new STBTTAlignedQuad(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTAlignedQuad calloc(MemoryStack paramMemoryStack) {
/* 226 */     return new STBTTAlignedQuad(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 236 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 246 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static float nx0(long paramLong) {
/* 252 */     return UNSAFE.getFloat(null, paramLong + X0);
/*     */   } public static float ny0(long paramLong) {
/* 254 */     return UNSAFE.getFloat(null, paramLong + Y0);
/*     */   } public static float ns0(long paramLong) {
/* 256 */     return UNSAFE.getFloat(null, paramLong + S0);
/*     */   } public static float nt0(long paramLong) {
/* 258 */     return UNSAFE.getFloat(null, paramLong + T0);
/*     */   } public static float nx1(long paramLong) {
/* 260 */     return UNSAFE.getFloat(null, paramLong + X1);
/*     */   } public static float ny1(long paramLong) {
/* 262 */     return UNSAFE.getFloat(null, paramLong + Y1);
/*     */   } public static float ns1(long paramLong) {
/* 264 */     return UNSAFE.getFloat(null, paramLong + S1);
/*     */   } public static float nt1(long paramLong) {
/* 266 */     return UNSAFE.getFloat(null, paramLong + T1);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<STBTTAlignedQuad, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 273 */     private static final STBTTAlignedQuad ELEMENT_FACTORY = STBTTAlignedQuad.create(-1L);
/*     */ 
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
/* 285 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / STBTTAlignedQuad.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 289 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 293 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 298 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected STBTTAlignedQuad getElementFactory() {
/* 303 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public float x0() {
/* 307 */       return STBTTAlignedQuad.nx0(address());
/*     */     } public float y0() {
/* 309 */       return STBTTAlignedQuad.ny0(address());
/*     */     } public float s0() {
/* 311 */       return STBTTAlignedQuad.ns0(address());
/*     */     } public float t0() {
/* 313 */       return STBTTAlignedQuad.nt0(address());
/*     */     } public float x1() {
/* 315 */       return STBTTAlignedQuad.nx1(address());
/*     */     } public float y1() {
/* 317 */       return STBTTAlignedQuad.ny1(address());
/*     */     } public float s1() {
/* 319 */       return STBTTAlignedQuad.ns1(address());
/*     */     } public float t1() {
/* 321 */       return STBTTAlignedQuad.nt1(address());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\stb\STBTTAlignedQuad.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */