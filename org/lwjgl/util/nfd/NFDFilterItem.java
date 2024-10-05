/*     */ package org.lwjgl.util.nfd;
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
/*     */ @NativeType("struct nfdfilteritem_t")
/*     */ public class NFDFilterItem
/*     */   extends Struct<NFDFilterItem>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int NAME;
/*     */   public static final int SPEC;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  48 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(POINTER_SIZE), __member(POINTER_SIZE) })).getSize();
/*  49 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  51 */     NAME = layout.offsetof(0);
/*  52 */     SPEC = layout.offsetof(1);
/*     */   }
/*     */   
/*     */   protected NFDFilterItem(long paramLong, ByteBuffer paramByteBuffer) {
/*  56 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected NFDFilterItem create(long paramLong, ByteBuffer paramByteBuffer) {
/*  61 */     return new NFDFilterItem(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NFDFilterItem(ByteBuffer paramByteBuffer) {
/*  71 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  75 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("nfdchar_t const *")
/*     */   public ByteBuffer name() {
/*  79 */     return nname(address());
/*     */   } @NativeType("nfdchar_t const *")
/*     */   public String nameString() {
/*  82 */     return nnameString(address());
/*     */   } @NativeType("nfdchar_t const *")
/*     */   public ByteBuffer spec() {
/*  85 */     return nspec(address());
/*     */   } @NativeType("nfdchar_t const *")
/*     */   public String specString() {
/*  88 */     return nspecString(address());
/*     */   }
/*     */   public NFDFilterItem name(@NativeType("nfdchar_t const *") ByteBuffer paramByteBuffer) {
/*  91 */     nname(address(), paramByteBuffer); return this;
/*     */   } public NFDFilterItem spec(@NativeType("nfdchar_t const *") ByteBuffer paramByteBuffer) {
/*  93 */     nspec(address(), paramByteBuffer); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NFDFilterItem set(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2) {
/* 100 */     name(paramByteBuffer1);
/* 101 */     spec(paramByteBuffer2);
/*     */     
/* 103 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NFDFilterItem set(NFDFilterItem paramNFDFilterItem) {
/* 114 */     MemoryUtil.memCopy(paramNFDFilterItem.address(), address(), SIZEOF);
/* 115 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static NFDFilterItem malloc() {
/* 122 */     return new NFDFilterItem(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static NFDFilterItem calloc() {
/* 127 */     return new NFDFilterItem(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static NFDFilterItem create() {
/* 132 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 133 */     return new NFDFilterItem(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static NFDFilterItem create(long paramLong) {
/* 138 */     return new NFDFilterItem(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static NFDFilterItem createSafe(long paramLong) {
/* 144 */     return (paramLong == 0L) ? null : new NFDFilterItem(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 153 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 162 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 171 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 172 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 182 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 188 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static NFDFilterItem malloc(MemoryStack paramMemoryStack) {
/* 197 */     return new NFDFilterItem(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static NFDFilterItem calloc(MemoryStack paramMemoryStack) {
/* 206 */     return new NFDFilterItem(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 216 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 226 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static ByteBuffer nname(long paramLong) {
/* 232 */     return MemoryUtil.memByteBufferNT1(MemoryUtil.memGetAddress(paramLong + NAME));
/*     */   } public static String nnameString(long paramLong) {
/* 234 */     return MemoryUtil.memUTF8(MemoryUtil.memGetAddress(paramLong + NAME));
/*     */   } public static ByteBuffer nspec(long paramLong) {
/* 236 */     return MemoryUtil.memByteBufferNT1(MemoryUtil.memGetAddress(paramLong + SPEC));
/*     */   } public static String nspecString(long paramLong) {
/* 238 */     return MemoryUtil.memUTF8(MemoryUtil.memGetAddress(paramLong + SPEC));
/*     */   }
/*     */   
/*     */   public static void nname(long paramLong, ByteBuffer paramByteBuffer) {
/* 242 */     if (Checks.CHECKS) Checks.checkNT1(paramByteBuffer); 
/* 243 */     MemoryUtil.memPutAddress(paramLong + NAME, MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */   
/*     */   public static void nspec(long paramLong, ByteBuffer paramByteBuffer) {
/* 247 */     if (Checks.CHECKS) Checks.checkNT1(paramByteBuffer); 
/* 248 */     MemoryUtil.memPutAddress(paramLong + SPEC, MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 257 */     Checks.check(MemoryUtil.memGetAddress(paramLong + NAME));
/* 258 */     Checks.check(MemoryUtil.memGetAddress(paramLong + SPEC));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<NFDFilterItem, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 266 */     private static final NFDFilterItem ELEMENT_FACTORY = NFDFilterItem.create(-1L);
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
/* 278 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / NFDFilterItem.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 282 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 286 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 291 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected NFDFilterItem getElementFactory() {
/* 296 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("nfdchar_t const *")
/*     */     public ByteBuffer name() {
/* 301 */       return NFDFilterItem.nname(address());
/*     */     } @NativeType("nfdchar_t const *")
/*     */     public String nameString() {
/* 304 */       return NFDFilterItem.nnameString(address());
/*     */     } @NativeType("nfdchar_t const *")
/*     */     public ByteBuffer spec() {
/* 307 */       return NFDFilterItem.nspec(address());
/*     */     } @NativeType("nfdchar_t const *")
/*     */     public String specString() {
/* 310 */       return NFDFilterItem.nspecString(address());
/*     */     }
/*     */     public Buffer name(@NativeType("nfdchar_t const *") ByteBuffer param1ByteBuffer) {
/* 313 */       NFDFilterItem.nname(address(), param1ByteBuffer); return this;
/*     */     } public Buffer spec(@NativeType("nfdchar_t const *") ByteBuffer param1ByteBuffer) {
/* 315 */       NFDFilterItem.nspec(address(), param1ByteBuffer); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjg\\util\nfd\NFDFilterItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */