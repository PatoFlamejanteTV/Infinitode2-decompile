/*     */ package org.lwjgl.stb;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.PointerBuffer;
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
/*     */ @NativeType("struct stb_vorbis_comment")
/*     */ public class STBVorbisComment
/*     */   extends Struct<STBVorbisComment>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int VENDOR;
/*     */   public static final int COMMENT_LIST_LENGTH;
/*     */   public static final int COMMENT_LIST;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  50 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(POINTER_SIZE), __member(4), __member(POINTER_SIZE) })).getSize();
/*  51 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  53 */     VENDOR = layout.offsetof(0);
/*  54 */     COMMENT_LIST_LENGTH = layout.offsetof(1);
/*  55 */     COMMENT_LIST = layout.offsetof(2);
/*     */   }
/*     */   
/*     */   protected STBVorbisComment(long paramLong, ByteBuffer paramByteBuffer) {
/*  59 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected STBVorbisComment create(long paramLong, ByteBuffer paramByteBuffer) {
/*  64 */     return new STBVorbisComment(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBVorbisComment(ByteBuffer paramByteBuffer) {
/*  74 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  78 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("char *")
/*     */   public ByteBuffer vendor() {
/*  82 */     return nvendor(address());
/*     */   } @NativeType("char *")
/*     */   public String vendorString() {
/*  85 */     return nvendorString(address());
/*     */   } public int comment_list_length() {
/*  87 */     return ncomment_list_length(address());
/*     */   } @NativeType("char **")
/*     */   public PointerBuffer comment_list() {
/*  90 */     return ncomment_list(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBVorbisComment malloc() {
/*  96 */     return new STBVorbisComment(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBVorbisComment calloc() {
/* 101 */     return new STBVorbisComment(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBVorbisComment create() {
/* 106 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 107 */     return new STBVorbisComment(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBVorbisComment create(long paramLong) {
/* 112 */     return new STBVorbisComment(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBVorbisComment createSafe(long paramLong) {
/* 118 */     return (paramLong == 0L) ? null : new STBVorbisComment(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 127 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 136 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 145 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 146 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 156 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 162 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBVorbisComment malloc(MemoryStack paramMemoryStack) {
/* 171 */     return new STBVorbisComment(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBVorbisComment calloc(MemoryStack paramMemoryStack) {
/* 180 */     return new STBVorbisComment(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 190 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 200 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static ByteBuffer nvendor(long paramLong) {
/* 206 */     return MemoryUtil.memByteBufferNT1(MemoryUtil.memGetAddress(paramLong + VENDOR));
/*     */   } public static String nvendorString(long paramLong) {
/* 208 */     return MemoryUtil.memASCII(MemoryUtil.memGetAddress(paramLong + VENDOR));
/*     */   } public static int ncomment_list_length(long paramLong) {
/* 210 */     return UNSAFE.getInt(null, paramLong + COMMENT_LIST_LENGTH);
/*     */   } public static PointerBuffer ncomment_list(long paramLong) {
/* 212 */     return MemoryUtil.memPointerBuffer(MemoryUtil.memGetAddress(paramLong + COMMENT_LIST), ncomment_list_length(paramLong));
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<STBVorbisComment, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 219 */     private static final STBVorbisComment ELEMENT_FACTORY = STBVorbisComment.create(-1L);
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
/* 231 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / STBVorbisComment.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 235 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 239 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 244 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected STBVorbisComment getElementFactory() {
/* 249 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("char *")
/*     */     public ByteBuffer vendor() {
/* 254 */       return STBVorbisComment.nvendor(address());
/*     */     } @NativeType("char *")
/*     */     public String vendorString() {
/* 257 */       return STBVorbisComment.nvendorString(address());
/*     */     } public int comment_list_length() {
/* 259 */       return STBVorbisComment.ncomment_list_length(address());
/*     */     } @NativeType("char **")
/*     */     public PointerBuffer comment_list() {
/* 262 */       return STBVorbisComment.ncomment_list(address());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\stb\STBVorbisComment.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */