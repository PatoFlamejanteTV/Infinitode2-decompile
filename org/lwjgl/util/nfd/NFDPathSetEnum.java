/*     */ package org.lwjgl.util.nfd;
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
/*     */ @NativeType("struct nfdpathsetenum_t")
/*     */ public class NFDPathSetEnum
/*     */   extends Struct<NFDPathSetEnum>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   
/*     */   static {
/*  29 */     LibNFD.initialize();
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
/*     */   protected NFDPathSetEnum(long paramLong, ByteBuffer paramByteBuffer) {
/*  41 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected NFDPathSetEnum create(long paramLong, ByteBuffer paramByteBuffer) {
/*  46 */     return new NFDPathSetEnum(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NFDPathSetEnum(ByteBuffer paramByteBuffer) {
/*  56 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  60 */     return SIZEOF;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static NFDPathSetEnum malloc() {
/*  66 */     return new NFDPathSetEnum(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static NFDPathSetEnum calloc() {
/*  71 */     return new NFDPathSetEnum(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static NFDPathSetEnum create() {
/*  76 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/*  77 */     return new NFDPathSetEnum(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static NFDPathSetEnum create(long paramLong) {
/*  82 */     return new NFDPathSetEnum(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static NFDPathSetEnum createSafe(long paramLong) {
/*  88 */     return (paramLong == 0L) ? null : new NFDPathSetEnum(paramLong, null);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static NFDPathSetEnum malloc(MemoryStack paramMemoryStack) {
/* 141 */     return new NFDPathSetEnum(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static NFDPathSetEnum calloc(MemoryStack paramMemoryStack) {
/* 150 */     return new NFDPathSetEnum(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 160 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 170 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   private static native int offsets(long paramLong);
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<NFDPathSetEnum, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 180 */     private static final NFDPathSetEnum ELEMENT_FACTORY = NFDPathSetEnum.create(-1L);
/*     */ 
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
/* 192 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / NFDPathSetEnum.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 196 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 200 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 205 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected NFDPathSetEnum getElementFactory() {
/* 210 */       return ELEMENT_FACTORY;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjg\\util\nfd\NFDPathSetEnum.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */