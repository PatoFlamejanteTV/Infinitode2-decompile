/*     */ package org.lwjgl.system.windows;
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
/*     */ 
/*     */ 
/*     */ public class HARDWAREINPUT
/*     */   extends Struct<HARDWAREINPUT>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int UMSG;
/*     */   public static final int WPARAML;
/*     */   public static final int WPARAMH;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  51 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(2), __member(2) })).getSize();
/*  52 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  54 */     UMSG = layout.offsetof(0);
/*  55 */     WPARAML = layout.offsetof(1);
/*  56 */     WPARAMH = layout.offsetof(2);
/*     */   }
/*     */   
/*     */   protected HARDWAREINPUT(long paramLong, ByteBuffer paramByteBuffer) {
/*  60 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected HARDWAREINPUT create(long paramLong, ByteBuffer paramByteBuffer) {
/*  65 */     return new HARDWAREINPUT(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HARDWAREINPUT(ByteBuffer paramByteBuffer) {
/*  75 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  79 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("DWORD")
/*     */   public int uMsg() {
/*  83 */     return nuMsg(address());
/*     */   } @NativeType("WORD")
/*     */   public short wParamL() {
/*  86 */     return nwParamL(address());
/*     */   } @NativeType("WORD")
/*     */   public short wParamH() {
/*  89 */     return nwParamH(address());
/*     */   }
/*     */   public HARDWAREINPUT uMsg(@NativeType("DWORD") int paramInt) {
/*  92 */     nuMsg(address(), paramInt); return this;
/*     */   } public HARDWAREINPUT wParamL(@NativeType("WORD") short paramShort) {
/*  94 */     nwParamL(address(), paramShort); return this;
/*     */   } public HARDWAREINPUT wParamH(@NativeType("WORD") short paramShort) {
/*  96 */     nwParamH(address(), paramShort); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HARDWAREINPUT set(int paramInt, short paramShort1, short paramShort2) {
/* 104 */     uMsg(paramInt);
/* 105 */     wParamL(paramShort1);
/* 106 */     wParamH(paramShort2);
/*     */     
/* 108 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HARDWAREINPUT set(HARDWAREINPUT paramHARDWAREINPUT) {
/* 119 */     MemoryUtil.memCopy(paramHARDWAREINPUT.address(), address(), SIZEOF);
/* 120 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static HARDWAREINPUT malloc() {
/* 127 */     return new HARDWAREINPUT(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static HARDWAREINPUT calloc() {
/* 132 */     return new HARDWAREINPUT(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static HARDWAREINPUT create() {
/* 137 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 138 */     return new HARDWAREINPUT(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static HARDWAREINPUT create(long paramLong) {
/* 143 */     return new HARDWAREINPUT(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static HARDWAREINPUT createSafe(long paramLong) {
/* 149 */     return (paramLong == 0L) ? null : new HARDWAREINPUT(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 158 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 167 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 176 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 177 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 187 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 193 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static HARDWAREINPUT mallocStack() {
/* 199 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 201 */   public static HARDWAREINPUT callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 203 */   public static HARDWAREINPUT mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 205 */   public static HARDWAREINPUT callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 207 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 209 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 211 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 213 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static HARDWAREINPUT malloc(MemoryStack paramMemoryStack) {
/* 221 */     return new HARDWAREINPUT(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static HARDWAREINPUT calloc(MemoryStack paramMemoryStack) {
/* 230 */     return new HARDWAREINPUT(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 240 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 250 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nuMsg(long paramLong) {
/* 256 */     return UNSAFE.getInt(null, paramLong + UMSG);
/*     */   } public static short nwParamL(long paramLong) {
/* 258 */     return UNSAFE.getShort(null, paramLong + WPARAML);
/*     */   } public static short nwParamH(long paramLong) {
/* 260 */     return UNSAFE.getShort(null, paramLong + WPARAMH);
/*     */   }
/*     */   public static void nuMsg(long paramLong, int paramInt) {
/* 263 */     UNSAFE.putInt(null, paramLong + UMSG, paramInt);
/*     */   } public static void nwParamL(long paramLong, short paramShort) {
/* 265 */     UNSAFE.putShort(null, paramLong + WPARAML, paramShort);
/*     */   } public static void nwParamH(long paramLong, short paramShort) {
/* 267 */     UNSAFE.putShort(null, paramLong + WPARAMH, paramShort);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<HARDWAREINPUT, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 274 */     private static final HARDWAREINPUT ELEMENT_FACTORY = HARDWAREINPUT.create(-1L);
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
/* 286 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / HARDWAREINPUT.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 290 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 294 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 299 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected HARDWAREINPUT getElementFactory() {
/* 304 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("DWORD")
/*     */     public int uMsg() {
/* 309 */       return HARDWAREINPUT.nuMsg(address());
/*     */     } @NativeType("WORD")
/*     */     public short wParamL() {
/* 312 */       return HARDWAREINPUT.nwParamL(address());
/*     */     } @NativeType("WORD")
/*     */     public short wParamH() {
/* 315 */       return HARDWAREINPUT.nwParamH(address());
/*     */     }
/*     */     public Buffer uMsg(@NativeType("DWORD") int param1Int) {
/* 318 */       HARDWAREINPUT.nuMsg(address(), param1Int); return this;
/*     */     } public Buffer wParamL(@NativeType("WORD") short param1Short) {
/* 320 */       HARDWAREINPUT.nwParamL(address(), param1Short); return this;
/*     */     } public Buffer wParamH(@NativeType("WORD") short param1Short) {
/* 322 */       HARDWAREINPUT.nwParamH(address(), param1Short); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\windows\HARDWAREINPUT.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */