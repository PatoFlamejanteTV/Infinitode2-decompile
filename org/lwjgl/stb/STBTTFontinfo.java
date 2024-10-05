/*     */ package org.lwjgl.stb;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
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
/*     */ @NativeType("struct stbtt_fontinfo")
/*     */ public class STBTTFontinfo
/*     */   extends Struct<STBTTFontinfo>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   
/*     */   static {
/*  29 */     LibSTB.initialize();
/*     */     
/*  31 */     MemoryStack memoryStack = MemoryStack.stackPush(); Throwable throwable = null; 
/*     */     try { IntBuffer intBuffer;
/*  33 */       SIZEOF = offsets(MemoryUtil.memAddress(intBuffer = memoryStack.mallocInt(1)));
/*  34 */       ALIGNOF = intBuffer.get(0); } catch (Throwable throwable2) { Throwable throwable1 = null; throw throwable1; }
/*  35 */     finally { if (memoryStack != null) if (throwable != null) { try { memoryStack.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  } else { throwable1.close(); }
/*     */           }
/*     */   
/*     */   }
/*     */   
/*     */   protected STBTTFontinfo(long paramLong, ByteBuffer paramByteBuffer) {
/*  41 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected STBTTFontinfo create(long paramLong, ByteBuffer paramByteBuffer) {
/*  46 */     return new STBTTFontinfo(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBTTFontinfo(ByteBuffer paramByteBuffer) {
/*  56 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  60 */     return SIZEOF;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTFontinfo malloc() {
/*  66 */     return new STBTTFontinfo(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTFontinfo calloc() {
/*  71 */     return new STBTTFontinfo(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTFontinfo create() {
/*  76 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/*  77 */     return new STBTTFontinfo(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTFontinfo create(long paramLong) {
/*  82 */     return new STBTTFontinfo(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTFontinfo createSafe(long paramLong) {
/*  88 */     return (paramLong == 0L) ? null : new STBTTFontinfo(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/*  97 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 106 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 115 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 116 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 126 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 132 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static STBTTFontinfo mallocStack() {
/* 138 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 140 */   public static STBTTFontinfo callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 142 */   public static STBTTFontinfo mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 144 */   public static STBTTFontinfo callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 146 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 148 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 150 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 152 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTFontinfo malloc(MemoryStack paramMemoryStack) {
/* 160 */     return new STBTTFontinfo(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTFontinfo calloc(MemoryStack paramMemoryStack) {
/* 169 */     return new STBTTFontinfo(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 179 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 189 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   private static native int offsets(long paramLong);
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<STBTTFontinfo, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 199 */     private static final STBTTFontinfo ELEMENT_FACTORY = STBTTFontinfo.create(-1L);
/*     */ 
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
/* 211 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / STBTTFontinfo.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 215 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 219 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 224 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected STBTTFontinfo getElementFactory() {
/* 229 */       return ELEMENT_FACTORY;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\stb\STBTTFontinfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */