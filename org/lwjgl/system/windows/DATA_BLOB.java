/*     */ package org.lwjgl.system.windows;
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
/*     */ public class DATA_BLOB
/*     */   extends Struct<DATA_BLOB>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int CBDATA;
/*     */   public static final int PBDATA;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  49 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(POINTER_SIZE) })).getSize();
/*  50 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  52 */     CBDATA = layout.offsetof(0);
/*  53 */     PBDATA = layout.offsetof(1);
/*     */   }
/*     */   
/*     */   protected DATA_BLOB(long paramLong, ByteBuffer paramByteBuffer) {
/*  57 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected DATA_BLOB create(long paramLong, ByteBuffer paramByteBuffer) {
/*  62 */     return new DATA_BLOB(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DATA_BLOB(ByteBuffer paramByteBuffer) {
/*  72 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  76 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("DWORD")
/*     */   public int cbData() {
/*  80 */     return ncbData(address());
/*     */   } @NativeType("BYTE *")
/*     */   public ByteBuffer pbData() {
/*  83 */     return npbData(address());
/*     */   }
/*     */   public DATA_BLOB pbData(@NativeType("BYTE *") ByteBuffer paramByteBuffer) {
/*  86 */     npbData(address(), paramByteBuffer); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DATA_BLOB set(DATA_BLOB paramDATA_BLOB) {
/*  96 */     MemoryUtil.memCopy(paramDATA_BLOB.address(), address(), SIZEOF);
/*  97 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DATA_BLOB malloc() {
/* 104 */     return new DATA_BLOB(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static DATA_BLOB calloc() {
/* 109 */     return new DATA_BLOB(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static DATA_BLOB create() {
/* 114 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 115 */     return new DATA_BLOB(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static DATA_BLOB create(long paramLong) {
/* 120 */     return new DATA_BLOB(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static DATA_BLOB createSafe(long paramLong) {
/* 126 */     return (paramLong == 0L) ? null : new DATA_BLOB(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 135 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 144 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 153 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 154 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 164 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 170 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DATA_BLOB malloc(MemoryStack paramMemoryStack) {
/* 179 */     return new DATA_BLOB(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DATA_BLOB calloc(MemoryStack paramMemoryStack) {
/* 188 */     return new DATA_BLOB(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 198 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 208 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ncbData(long paramLong) {
/* 214 */     return UNSAFE.getInt(null, paramLong + CBDATA);
/*     */   } public static ByteBuffer npbData(long paramLong) {
/* 216 */     return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(paramLong + PBDATA), ncbData(paramLong));
/*     */   }
/*     */   public static void ncbData(long paramLong, int paramInt) {
/* 219 */     UNSAFE.putInt(null, paramLong + CBDATA, paramInt);
/*     */   } public static void npbData(long paramLong, ByteBuffer paramByteBuffer) {
/* 221 */     MemoryUtil.memPutAddress(paramLong + PBDATA, MemoryUtil.memAddress(paramByteBuffer)); ncbData(paramLong, paramByteBuffer.remaining());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 229 */     Checks.check(MemoryUtil.memGetAddress(paramLong + PBDATA));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<DATA_BLOB, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 237 */     private static final DATA_BLOB ELEMENT_FACTORY = DATA_BLOB.create(-1L);
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
/* 249 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / DATA_BLOB.SIZEOF);
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
/*     */     protected DATA_BLOB getElementFactory() {
/* 267 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("DWORD")
/*     */     public int cbData() {
/* 272 */       return DATA_BLOB.ncbData(address());
/*     */     } @NativeType("BYTE *")
/*     */     public ByteBuffer pbData() {
/* 275 */       return DATA_BLOB.npbData(address());
/*     */     }
/*     */     public Buffer pbData(@NativeType("BYTE *") ByteBuffer param1ByteBuffer) {
/* 278 */       DATA_BLOB.npbData(address(), param1ByteBuffer); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\windows\DATA_BLOB.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */