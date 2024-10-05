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
/*     */ @NativeType("struct stbtt_kerningentry")
/*     */ public class STBTTKerningentry
/*     */   extends Struct<STBTTKerningentry>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int GLYPH1;
/*     */   public static final int GLYPH2;
/*     */   public static final int ADVANCE;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  50 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(4), __member(4) })).getSize();
/*  51 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  53 */     GLYPH1 = layout.offsetof(0);
/*  54 */     GLYPH2 = layout.offsetof(1);
/*  55 */     ADVANCE = layout.offsetof(2);
/*     */   }
/*     */   
/*     */   protected STBTTKerningentry(long paramLong, ByteBuffer paramByteBuffer) {
/*  59 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected STBTTKerningentry create(long paramLong, ByteBuffer paramByteBuffer) {
/*  64 */     return new STBTTKerningentry(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBTTKerningentry(ByteBuffer paramByteBuffer) {
/*  74 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  78 */     return SIZEOF;
/*     */   }
/*     */   public int glyph1() {
/*  81 */     return nglyph1(address());
/*     */   } public int glyph2() {
/*  83 */     return nglyph2(address());
/*     */   } public int advance() {
/*  85 */     return nadvance(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTKerningentry malloc() {
/*  91 */     return new STBTTKerningentry(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTKerningentry calloc() {
/*  96 */     return new STBTTKerningentry(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTKerningentry create() {
/* 101 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 102 */     return new STBTTKerningentry(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTKerningentry create(long paramLong) {
/* 107 */     return new STBTTKerningentry(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTKerningentry createSafe(long paramLong) {
/* 113 */     return (paramLong == 0L) ? null : new STBTTKerningentry(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 122 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 131 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 140 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 141 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 151 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 157 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTKerningentry malloc(MemoryStack paramMemoryStack) {
/* 166 */     return new STBTTKerningentry(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTKerningentry calloc(MemoryStack paramMemoryStack) {
/* 175 */     return new STBTTKerningentry(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 185 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 195 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglyph1(long paramLong) {
/* 201 */     return UNSAFE.getInt(null, paramLong + GLYPH1);
/*     */   } public static int nglyph2(long paramLong) {
/* 203 */     return UNSAFE.getInt(null, paramLong + GLYPH2);
/*     */   } public static int nadvance(long paramLong) {
/* 205 */     return UNSAFE.getInt(null, paramLong + ADVANCE);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<STBTTKerningentry, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 212 */     private static final STBTTKerningentry ELEMENT_FACTORY = STBTTKerningentry.create(-1L);
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
/* 224 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / STBTTKerningentry.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 228 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 232 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 237 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected STBTTKerningentry getElementFactory() {
/* 242 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int glyph1() {
/* 246 */       return STBTTKerningentry.nglyph1(address());
/*     */     } public int glyph2() {
/* 248 */       return STBTTKerningentry.nglyph2(address());
/*     */     } public int advance() {
/* 250 */       return STBTTKerningentry.nadvance(address());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\stb\STBTTKerningentry.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */