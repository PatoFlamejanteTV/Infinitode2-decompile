/*     */ package org.lwjgl.system.macosx;
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
/*     */ @NativeType("struct objc_method_description")
/*     */ public class ObjCMethodDescription
/*     */   extends Struct<ObjCMethodDescription>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int NAME;
/*     */   public static final int TYPES;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  49 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(POINTER_SIZE), __member(POINTER_SIZE) })).getSize();
/*  50 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  52 */     NAME = layout.offsetof(0);
/*  53 */     TYPES = layout.offsetof(1);
/*     */   }
/*     */   
/*     */   protected ObjCMethodDescription(long paramLong, ByteBuffer paramByteBuffer) {
/*  57 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected ObjCMethodDescription create(long paramLong, ByteBuffer paramByteBuffer) {
/*  62 */     return new ObjCMethodDescription(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ObjCMethodDescription(ByteBuffer paramByteBuffer) {
/*  72 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  76 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("SEL")
/*     */   public long name() {
/*  80 */     return nname(address());
/*     */   } @NativeType("char *")
/*     */   public ByteBuffer types() {
/*  83 */     return ntypes(address());
/*     */   } @NativeType("char *")
/*     */   public String typesString() {
/*  86 */     return ntypesString(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static ObjCMethodDescription malloc() {
/*  92 */     return new ObjCMethodDescription(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static ObjCMethodDescription calloc() {
/*  97 */     return new ObjCMethodDescription(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static ObjCMethodDescription create() {
/* 102 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 103 */     return new ObjCMethodDescription(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static ObjCMethodDescription create(long paramLong) {
/* 108 */     return new ObjCMethodDescription(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static ObjCMethodDescription createSafe(long paramLong) {
/* 114 */     return (paramLong == 0L) ? null : new ObjCMethodDescription(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 123 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 132 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 141 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 142 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 152 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 158 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static ObjCMethodDescription mallocStack() {
/* 164 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 166 */   public static ObjCMethodDescription callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 168 */   public static ObjCMethodDescription mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 170 */   public static ObjCMethodDescription callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 172 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 174 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 176 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 178 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ObjCMethodDescription malloc(MemoryStack paramMemoryStack) {
/* 186 */     return new ObjCMethodDescription(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ObjCMethodDescription calloc(MemoryStack paramMemoryStack) {
/* 195 */     return new ObjCMethodDescription(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 205 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 215 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nname(long paramLong) {
/* 221 */     return MemoryUtil.memGetAddress(paramLong + NAME);
/*     */   } public static ByteBuffer ntypes(long paramLong) {
/* 223 */     return MemoryUtil.memByteBufferNT1(MemoryUtil.memGetAddress(paramLong + TYPES));
/*     */   } public static String ntypesString(long paramLong) {
/* 225 */     return MemoryUtil.memUTF8(MemoryUtil.memGetAddress(paramLong + TYPES));
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<ObjCMethodDescription, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 232 */     private static final ObjCMethodDescription ELEMENT_FACTORY = ObjCMethodDescription.create(-1L);
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
/* 244 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / ObjCMethodDescription.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 248 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 252 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 257 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected ObjCMethodDescription getElementFactory() {
/* 262 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("SEL")
/*     */     public long name() {
/* 267 */       return ObjCMethodDescription.nname(address());
/*     */     } @NativeType("char *")
/*     */     public ByteBuffer types() {
/* 270 */       return ObjCMethodDescription.ntypes(address());
/*     */     } @NativeType("char *")
/*     */     public String typesString() {
/* 273 */       return ObjCMethodDescription.ntypesString(address());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\macosx\ObjCMethodDescription.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */