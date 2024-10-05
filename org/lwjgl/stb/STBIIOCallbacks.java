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
/*     */ @NativeType("struct stbi_io_callbacks")
/*     */ public class STBIIOCallbacks
/*     */   extends Struct<STBIIOCallbacks>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int READ;
/*     */   public static final int SKIP;
/*     */   public static final int EOF;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  53 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(POINTER_SIZE), __member(POINTER_SIZE), __member(POINTER_SIZE) })).getSize();
/*  54 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  56 */     READ = layout.offsetof(0);
/*  57 */     SKIP = layout.offsetof(1);
/*  58 */     EOF = layout.offsetof(2);
/*     */   }
/*     */   
/*     */   protected STBIIOCallbacks(long paramLong, ByteBuffer paramByteBuffer) {
/*  62 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected STBIIOCallbacks create(long paramLong, ByteBuffer paramByteBuffer) {
/*  67 */     return new STBIIOCallbacks(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBIIOCallbacks(ByteBuffer paramByteBuffer) {
/*  77 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  81 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("int (*) (void *, char *, int)")
/*     */   public STBIReadCallback read() {
/*  85 */     return nread(address());
/*     */   } @NativeType("void (*) (void *, int)")
/*     */   public STBISkipCallback skip() {
/*  88 */     return nskip(address());
/*     */   } @NativeType("int (*) (void *)")
/*     */   public STBIEOFCallback eof() {
/*  91 */     return neof(address());
/*     */   }
/*     */   public STBIIOCallbacks read(@NativeType("int (*) (void *, char *, int)") STBIReadCallbackI paramSTBIReadCallbackI) {
/*  94 */     nread(address(), paramSTBIReadCallbackI); return this;
/*     */   } public STBIIOCallbacks skip(@NativeType("void (*) (void *, int)") STBISkipCallbackI paramSTBISkipCallbackI) {
/*  96 */     nskip(address(), paramSTBISkipCallbackI); return this;
/*     */   } public STBIIOCallbacks eof(@NativeType("int (*) (void *)") STBIEOFCallbackI paramSTBIEOFCallbackI) {
/*  98 */     neof(address(), paramSTBIEOFCallbackI); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBIIOCallbacks set(STBIReadCallbackI paramSTBIReadCallbackI, STBISkipCallbackI paramSTBISkipCallbackI, STBIEOFCallbackI paramSTBIEOFCallbackI) {
/* 106 */     read(paramSTBIReadCallbackI);
/* 107 */     skip(paramSTBISkipCallbackI);
/* 108 */     eof(paramSTBIEOFCallbackI);
/*     */     
/* 110 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBIIOCallbacks set(STBIIOCallbacks paramSTBIIOCallbacks) {
/* 121 */     MemoryUtil.memCopy(paramSTBIIOCallbacks.address(), address(), SIZEOF);
/* 122 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBIIOCallbacks malloc() {
/* 129 */     return new STBIIOCallbacks(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBIIOCallbacks calloc() {
/* 134 */     return new STBIIOCallbacks(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBIIOCallbacks create() {
/* 139 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 140 */     return new STBIIOCallbacks(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBIIOCallbacks create(long paramLong) {
/* 145 */     return new STBIIOCallbacks(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBIIOCallbacks createSafe(long paramLong) {
/* 151 */     return (paramLong == 0L) ? null : new STBIIOCallbacks(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 160 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 169 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 178 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 179 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 189 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 195 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static STBIIOCallbacks mallocStack() {
/* 201 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 203 */   public static STBIIOCallbacks callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 205 */   public static STBIIOCallbacks mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 207 */   public static STBIIOCallbacks callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 209 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 211 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 213 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 215 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBIIOCallbacks malloc(MemoryStack paramMemoryStack) {
/* 223 */     return new STBIIOCallbacks(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBIIOCallbacks calloc(MemoryStack paramMemoryStack) {
/* 232 */     return new STBIIOCallbacks(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 242 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 252 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBIReadCallback nread(long paramLong) {
/* 258 */     return STBIReadCallback.create(MemoryUtil.memGetAddress(paramLong + READ));
/*     */   } public static STBISkipCallback nskip(long paramLong) {
/* 260 */     return STBISkipCallback.create(MemoryUtil.memGetAddress(paramLong + SKIP));
/*     */   } public static STBIEOFCallback neof(long paramLong) {
/* 262 */     return STBIEOFCallback.create(MemoryUtil.memGetAddress(paramLong + EOF));
/*     */   }
/*     */   public static void nread(long paramLong, STBIReadCallbackI paramSTBIReadCallbackI) {
/* 265 */     MemoryUtil.memPutAddress(paramLong + READ, paramSTBIReadCallbackI.address());
/*     */   } public static void nskip(long paramLong, STBISkipCallbackI paramSTBISkipCallbackI) {
/* 267 */     MemoryUtil.memPutAddress(paramLong + SKIP, paramSTBISkipCallbackI.address());
/*     */   } public static void neof(long paramLong, STBIEOFCallbackI paramSTBIEOFCallbackI) {
/* 269 */     MemoryUtil.memPutAddress(paramLong + EOF, paramSTBIEOFCallbackI.address());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 277 */     Checks.check(MemoryUtil.memGetAddress(paramLong + READ));
/* 278 */     Checks.check(MemoryUtil.memGetAddress(paramLong + SKIP));
/* 279 */     Checks.check(MemoryUtil.memGetAddress(paramLong + EOF));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<STBIIOCallbacks, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 287 */     private static final STBIIOCallbacks ELEMENT_FACTORY = STBIIOCallbacks.create(-1L);
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
/* 299 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / STBIIOCallbacks.SIZEOF);
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
/*     */     protected STBIIOCallbacks getElementFactory() {
/* 317 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("int (*) (void *, char *, int)")
/*     */     public STBIReadCallback read() {
/* 322 */       return STBIIOCallbacks.nread(address());
/*     */     } @NativeType("void (*) (void *, int)")
/*     */     public STBISkipCallback skip() {
/* 325 */       return STBIIOCallbacks.nskip(address());
/*     */     } @NativeType("int (*) (void *)")
/*     */     public STBIEOFCallback eof() {
/* 328 */       return STBIIOCallbacks.neof(address());
/*     */     }
/*     */     public Buffer read(@NativeType("int (*) (void *, char *, int)") STBIReadCallbackI param1STBIReadCallbackI) {
/* 331 */       STBIIOCallbacks.nread(address(), param1STBIReadCallbackI); return this;
/*     */     } public Buffer skip(@NativeType("void (*) (void *, int)") STBISkipCallbackI param1STBISkipCallbackI) {
/* 333 */       STBIIOCallbacks.nskip(address(), param1STBISkipCallbackI); return this;
/*     */     } public Buffer eof(@NativeType("int (*) (void *)") STBIEOFCallbackI param1STBIEOFCallbackI) {
/* 335 */       STBIIOCallbacks.neof(address(), param1STBIEOFCallbackI); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\stb\STBIIOCallbacks.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */