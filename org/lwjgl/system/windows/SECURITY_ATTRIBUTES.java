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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SECURITY_ATTRIBUTES
/*     */   extends Struct<SECURITY_ATTRIBUTES>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int NLENGTH;
/*     */   public static final int LPSECURITYDESCRIPTOR;
/*     */   public static final int BINHERITHANDLE;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  54 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(POINTER_SIZE), __member(4) })).getSize();
/*  55 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  57 */     NLENGTH = layout.offsetof(0);
/*  58 */     LPSECURITYDESCRIPTOR = layout.offsetof(1);
/*  59 */     BINHERITHANDLE = layout.offsetof(2);
/*     */   }
/*     */   
/*     */   protected SECURITY_ATTRIBUTES(long paramLong, ByteBuffer paramByteBuffer) {
/*  63 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected SECURITY_ATTRIBUTES create(long paramLong, ByteBuffer paramByteBuffer) {
/*  68 */     return new SECURITY_ATTRIBUTES(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SECURITY_ATTRIBUTES(ByteBuffer paramByteBuffer) {
/*  78 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  82 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("DWORD")
/*     */   public int nLength() {
/*  86 */     return nnLength(address());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("LPVOID")
/*     */   public long lpSecurityDescriptor() {
/*  94 */     return nlpSecurityDescriptor(address());
/*     */   } @NativeType("BOOL")
/*     */   public boolean bInheritHandle() {
/*  97 */     return (nbInheritHandle(address()) != 0);
/*     */   }
/*     */   public SECURITY_ATTRIBUTES nLength(@NativeType("DWORD") int paramInt) {
/* 100 */     nnLength(address(), paramInt); return this;
/*     */   } public SECURITY_ATTRIBUTES lpSecurityDescriptor(@NativeType("LPVOID") long paramLong) {
/* 102 */     nlpSecurityDescriptor(address(), paramLong); return this;
/*     */   } public SECURITY_ATTRIBUTES bInheritHandle(@NativeType("BOOL") boolean paramBoolean) {
/* 104 */     nbInheritHandle(address(), paramBoolean ? 1 : 0); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SECURITY_ATTRIBUTES set(int paramInt, long paramLong, boolean paramBoolean) {
/* 112 */     nLength(paramInt);
/* 113 */     lpSecurityDescriptor(paramLong);
/* 114 */     bInheritHandle(paramBoolean);
/*     */     
/* 116 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SECURITY_ATTRIBUTES set(SECURITY_ATTRIBUTES paramSECURITY_ATTRIBUTES) {
/* 127 */     MemoryUtil.memCopy(paramSECURITY_ATTRIBUTES.address(), address(), SIZEOF);
/* 128 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SECURITY_ATTRIBUTES malloc() {
/* 135 */     return new SECURITY_ATTRIBUTES(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static SECURITY_ATTRIBUTES calloc() {
/* 140 */     return new SECURITY_ATTRIBUTES(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static SECURITY_ATTRIBUTES create() {
/* 145 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 146 */     return new SECURITY_ATTRIBUTES(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static SECURITY_ATTRIBUTES create(long paramLong) {
/* 151 */     return new SECURITY_ATTRIBUTES(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static SECURITY_ATTRIBUTES createSafe(long paramLong) {
/* 157 */     return (paramLong == 0L) ? null : new SECURITY_ATTRIBUTES(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 166 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 175 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 184 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 185 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 195 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 201 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static SECURITY_ATTRIBUTES mallocStack() {
/* 207 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 209 */   public static SECURITY_ATTRIBUTES callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 211 */   public static SECURITY_ATTRIBUTES mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 213 */   public static SECURITY_ATTRIBUTES callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 215 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 217 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 219 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 221 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SECURITY_ATTRIBUTES malloc(MemoryStack paramMemoryStack) {
/* 229 */     return new SECURITY_ATTRIBUTES(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SECURITY_ATTRIBUTES calloc(MemoryStack paramMemoryStack) {
/* 238 */     return new SECURITY_ATTRIBUTES(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 248 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 258 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nnLength(long paramLong) {
/* 264 */     return UNSAFE.getInt(null, paramLong + NLENGTH);
/*     */   } public static long nlpSecurityDescriptor(long paramLong) {
/* 266 */     return MemoryUtil.memGetAddress(paramLong + LPSECURITYDESCRIPTOR);
/*     */   } public static int nbInheritHandle(long paramLong) {
/* 268 */     return UNSAFE.getInt(null, paramLong + BINHERITHANDLE);
/*     */   }
/*     */   public static void nnLength(long paramLong, int paramInt) {
/* 271 */     UNSAFE.putInt(null, paramLong + NLENGTH, paramInt);
/*     */   } public static void nlpSecurityDescriptor(long paramLong1, long paramLong2) {
/* 273 */     MemoryUtil.memPutAddress(paramLong1 + LPSECURITYDESCRIPTOR, Checks.check(paramLong2));
/*     */   } public static void nbInheritHandle(long paramLong, int paramInt) {
/* 275 */     UNSAFE.putInt(null, paramLong + BINHERITHANDLE, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 283 */     Checks.check(MemoryUtil.memGetAddress(paramLong + LPSECURITYDESCRIPTOR));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<SECURITY_ATTRIBUTES, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 291 */     private static final SECURITY_ATTRIBUTES ELEMENT_FACTORY = SECURITY_ATTRIBUTES.create(-1L);
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
/* 303 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / SECURITY_ATTRIBUTES.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 307 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 311 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 316 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected SECURITY_ATTRIBUTES getElementFactory() {
/* 321 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("DWORD")
/*     */     public int nLength() {
/* 326 */       return SECURITY_ATTRIBUTES.nnLength(address());
/*     */     } @NativeType("LPVOID")
/*     */     public long lpSecurityDescriptor() {
/* 329 */       return SECURITY_ATTRIBUTES.nlpSecurityDescriptor(address());
/*     */     } @NativeType("BOOL")
/*     */     public boolean bInheritHandle() {
/* 332 */       return (SECURITY_ATTRIBUTES.nbInheritHandle(address()) != 0);
/*     */     }
/*     */     public Buffer nLength(@NativeType("DWORD") int param1Int) {
/* 335 */       SECURITY_ATTRIBUTES.nnLength(address(), param1Int); return this;
/*     */     } public Buffer lpSecurityDescriptor(@NativeType("LPVOID") long param1Long) {
/* 337 */       SECURITY_ATTRIBUTES.nlpSecurityDescriptor(address(), param1Long); return this;
/*     */     } public Buffer bInheritHandle(@NativeType("BOOL") boolean param1Boolean) {
/* 339 */       SECURITY_ATTRIBUTES.nbInheritHandle(address(), param1Boolean ? 1 : 0); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\windows\SECURITY_ATTRIBUTES.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */