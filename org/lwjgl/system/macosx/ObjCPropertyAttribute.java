/*     */ package org.lwjgl.system.macosx;
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
/*     */ @NativeType("struct objc_property_attribute_t")
/*     */ public class ObjCPropertyAttribute
/*     */   extends Struct<ObjCPropertyAttribute>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int NAME;
/*     */   public static final int VALUE;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  50 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(POINTER_SIZE), __member(POINTER_SIZE) })).getSize();
/*  51 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  53 */     NAME = layout.offsetof(0);
/*  54 */     VALUE = layout.offsetof(1);
/*     */   }
/*     */   
/*     */   protected ObjCPropertyAttribute(long paramLong, ByteBuffer paramByteBuffer) {
/*  58 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected ObjCPropertyAttribute create(long paramLong, ByteBuffer paramByteBuffer) {
/*  63 */     return new ObjCPropertyAttribute(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ObjCPropertyAttribute(ByteBuffer paramByteBuffer) {
/*  73 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  77 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("char *")
/*     */   public ByteBuffer name() {
/*  81 */     return nname(address());
/*     */   } @NativeType("char *")
/*     */   public String nameString() {
/*  84 */     return nnameString(address());
/*     */   } @NativeType("char *")
/*     */   public ByteBuffer value() {
/*  87 */     return nvalue(address());
/*     */   } @NativeType("char *")
/*     */   public String valueString() {
/*  90 */     return nvalueString(address());
/*     */   }
/*     */   public ObjCPropertyAttribute name(@NativeType("char *") ByteBuffer paramByteBuffer) {
/*  93 */     nname(address(), paramByteBuffer); return this;
/*     */   } public ObjCPropertyAttribute value(@NativeType("char *") ByteBuffer paramByteBuffer) {
/*  95 */     nvalue(address(), paramByteBuffer); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ObjCPropertyAttribute set(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2) {
/* 102 */     name(paramByteBuffer1);
/* 103 */     value(paramByteBuffer2);
/*     */     
/* 105 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ObjCPropertyAttribute set(ObjCPropertyAttribute paramObjCPropertyAttribute) {
/* 116 */     MemoryUtil.memCopy(paramObjCPropertyAttribute.address(), address(), SIZEOF);
/* 117 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ObjCPropertyAttribute malloc() {
/* 124 */     return new ObjCPropertyAttribute(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static ObjCPropertyAttribute calloc() {
/* 129 */     return new ObjCPropertyAttribute(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static ObjCPropertyAttribute create() {
/* 134 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 135 */     return new ObjCPropertyAttribute(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static ObjCPropertyAttribute create(long paramLong) {
/* 140 */     return new ObjCPropertyAttribute(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static ObjCPropertyAttribute createSafe(long paramLong) {
/* 146 */     return (paramLong == 0L) ? null : new ObjCPropertyAttribute(paramLong, null);
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
/*     */   public static ObjCPropertyAttribute mallocStack() {
/* 196 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 198 */   public static ObjCPropertyAttribute callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 200 */   public static ObjCPropertyAttribute mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 202 */   public static ObjCPropertyAttribute callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
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
/*     */   public static ObjCPropertyAttribute malloc(MemoryStack paramMemoryStack) {
/* 218 */     return new ObjCPropertyAttribute(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ObjCPropertyAttribute calloc(MemoryStack paramMemoryStack) {
/* 227 */     return new ObjCPropertyAttribute(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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
/*     */   public static ByteBuffer nname(long paramLong) {
/* 253 */     return MemoryUtil.memByteBufferNT1(MemoryUtil.memGetAddress(paramLong + NAME));
/*     */   } public static String nnameString(long paramLong) {
/* 255 */     return MemoryUtil.memUTF8(MemoryUtil.memGetAddress(paramLong + NAME));
/*     */   } public static ByteBuffer nvalue(long paramLong) {
/* 257 */     return MemoryUtil.memByteBufferNT1(MemoryUtil.memGetAddress(paramLong + VALUE));
/*     */   } public static String nvalueString(long paramLong) {
/* 259 */     return MemoryUtil.memUTF8(MemoryUtil.memGetAddress(paramLong + VALUE));
/*     */   }
/*     */   
/*     */   public static void nname(long paramLong, ByteBuffer paramByteBuffer) {
/* 263 */     if (Checks.CHECKS) Checks.checkNT1(paramByteBuffer); 
/* 264 */     MemoryUtil.memPutAddress(paramLong + NAME, MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */   
/*     */   public static void nvalue(long paramLong, ByteBuffer paramByteBuffer) {
/* 268 */     if (Checks.CHECKS) Checks.checkNT1(paramByteBuffer); 
/* 269 */     MemoryUtil.memPutAddress(paramLong + VALUE, MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 278 */     Checks.check(MemoryUtil.memGetAddress(paramLong + NAME));
/* 279 */     Checks.check(MemoryUtil.memGetAddress(paramLong + VALUE));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<ObjCPropertyAttribute, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 287 */     private static final ObjCPropertyAttribute ELEMENT_FACTORY = ObjCPropertyAttribute.create(-1L);
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
/* 299 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / ObjCPropertyAttribute.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 303 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 307 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 312 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected ObjCPropertyAttribute getElementFactory() {
/* 317 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("char *")
/*     */     public ByteBuffer name() {
/* 322 */       return ObjCPropertyAttribute.nname(address());
/*     */     } @NativeType("char *")
/*     */     public String nameString() {
/* 325 */       return ObjCPropertyAttribute.nnameString(address());
/*     */     } @NativeType("char *")
/*     */     public ByteBuffer value() {
/* 328 */       return ObjCPropertyAttribute.nvalue(address());
/*     */     } @NativeType("char *")
/*     */     public String valueString() {
/* 331 */       return ObjCPropertyAttribute.nvalueString(address());
/*     */     }
/*     */     public Buffer name(@NativeType("char *") ByteBuffer param1ByteBuffer) {
/* 334 */       ObjCPropertyAttribute.nname(address(), param1ByteBuffer); return this;
/*     */     } public Buffer value(@NativeType("char *") ByteBuffer param1ByteBuffer) {
/* 336 */       ObjCPropertyAttribute.nvalue(address(), param1ByteBuffer); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\macosx\ObjCPropertyAttribute.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */