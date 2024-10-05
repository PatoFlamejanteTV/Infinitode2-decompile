/*     */ package org.lwjgl.system.windows;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.function.Consumer;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WINDOWPLACEMENT
/*     */   extends Struct<WINDOWPLACEMENT>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int LENGTH;
/*     */   public static final int FLAGS;
/*     */   public static final int SHOWCMD;
/*     */   public static final int PTMINPOSITION;
/*     */   public static final int PTMAXPOSITION;
/*     */   public static final int RCNORMALPOSITION;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  60 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(4), __member(4), __member(POINT.SIZEOF, POINT.ALIGNOF), __member(POINT.SIZEOF, POINT.ALIGNOF), __member(RECT.SIZEOF, RECT.ALIGNOF) })).getSize();
/*  61 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  63 */     LENGTH = layout.offsetof(0);
/*  64 */     FLAGS = layout.offsetof(1);
/*  65 */     SHOWCMD = layout.offsetof(2);
/*  66 */     PTMINPOSITION = layout.offsetof(3);
/*  67 */     PTMAXPOSITION = layout.offsetof(4);
/*  68 */     RCNORMALPOSITION = layout.offsetof(5);
/*     */   }
/*     */   
/*     */   protected WINDOWPLACEMENT(long paramLong, ByteBuffer paramByteBuffer) {
/*  72 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected WINDOWPLACEMENT create(long paramLong, ByteBuffer paramByteBuffer) {
/*  77 */     return new WINDOWPLACEMENT(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WINDOWPLACEMENT(ByteBuffer paramByteBuffer) {
/*  87 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  91 */     return SIZEOF;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("UINT")
/*     */   public int length() {
/*  98 */     return nlength(address());
/*     */   } @NativeType("UINT")
/*     */   public int flags() {
/* 101 */     return nflags(address());
/*     */   } @NativeType("UINT")
/*     */   public int showCmd() {
/* 104 */     return nshowCmd(address());
/*     */   } public POINT ptMinPosition() {
/* 106 */     return nptMinPosition(address());
/*     */   } public POINT ptMaxPosition() {
/* 108 */     return nptMaxPosition(address());
/*     */   } public RECT rcNormalPosition() {
/* 110 */     return nrcNormalPosition(address());
/*     */   }
/*     */   public WINDOWPLACEMENT length(@NativeType("UINT") int paramInt) {
/* 113 */     nlength(address(), paramInt); return this;
/*     */   } public WINDOWPLACEMENT flags(@NativeType("UINT") int paramInt) {
/* 115 */     nflags(address(), paramInt); return this;
/*     */   } public WINDOWPLACEMENT showCmd(@NativeType("UINT") int paramInt) {
/* 117 */     nshowCmd(address(), paramInt); return this;
/*     */   } public WINDOWPLACEMENT ptMinPosition(POINT paramPOINT) {
/* 119 */     nptMinPosition(address(), paramPOINT); return this;
/*     */   } public WINDOWPLACEMENT ptMinPosition(Consumer<POINT> paramConsumer) {
/* 121 */     paramConsumer.accept(ptMinPosition()); return this;
/*     */   } public WINDOWPLACEMENT ptMaxPosition(POINT paramPOINT) {
/* 123 */     nptMaxPosition(address(), paramPOINT); return this;
/*     */   } public WINDOWPLACEMENT ptMaxPosition(Consumer<POINT> paramConsumer) {
/* 125 */     paramConsumer.accept(ptMaxPosition()); return this;
/*     */   } public WINDOWPLACEMENT rcNormalPosition(RECT paramRECT) {
/* 127 */     nrcNormalPosition(address(), paramRECT); return this;
/*     */   } public WINDOWPLACEMENT rcNormalPosition(Consumer<RECT> paramConsumer) {
/* 129 */     paramConsumer.accept(rcNormalPosition()); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WINDOWPLACEMENT set(int paramInt1, int paramInt2, int paramInt3, POINT paramPOINT1, POINT paramPOINT2, RECT paramRECT) {
/* 140 */     length(paramInt1);
/* 141 */     flags(paramInt2);
/* 142 */     showCmd(paramInt3);
/* 143 */     ptMinPosition(paramPOINT1);
/* 144 */     ptMaxPosition(paramPOINT2);
/* 145 */     rcNormalPosition(paramRECT);
/*     */     
/* 147 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WINDOWPLACEMENT set(WINDOWPLACEMENT paramWINDOWPLACEMENT) {
/* 158 */     MemoryUtil.memCopy(paramWINDOWPLACEMENT.address(), address(), SIZEOF);
/* 159 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static WINDOWPLACEMENT malloc() {
/* 166 */     return new WINDOWPLACEMENT(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static WINDOWPLACEMENT calloc() {
/* 171 */     return new WINDOWPLACEMENT(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static WINDOWPLACEMENT create() {
/* 176 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 177 */     return new WINDOWPLACEMENT(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static WINDOWPLACEMENT create(long paramLong) {
/* 182 */     return new WINDOWPLACEMENT(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static WINDOWPLACEMENT createSafe(long paramLong) {
/* 188 */     return (paramLong == 0L) ? null : new WINDOWPLACEMENT(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 197 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 206 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 215 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 216 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 226 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 232 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static WINDOWPLACEMENT mallocStack() {
/* 238 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 240 */   public static WINDOWPLACEMENT callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 242 */   public static WINDOWPLACEMENT mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 244 */   public static WINDOWPLACEMENT callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 246 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 248 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 250 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 252 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static WINDOWPLACEMENT malloc(MemoryStack paramMemoryStack) {
/* 260 */     return new WINDOWPLACEMENT(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static WINDOWPLACEMENT calloc(MemoryStack paramMemoryStack) {
/* 269 */     return new WINDOWPLACEMENT(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 279 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 289 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nlength(long paramLong) {
/* 295 */     return UNSAFE.getInt(null, paramLong + LENGTH);
/*     */   } public static int nflags(long paramLong) {
/* 297 */     return UNSAFE.getInt(null, paramLong + FLAGS);
/*     */   } public static int nshowCmd(long paramLong) {
/* 299 */     return UNSAFE.getInt(null, paramLong + SHOWCMD);
/*     */   } public static POINT nptMinPosition(long paramLong) {
/* 301 */     return POINT.create(paramLong + PTMINPOSITION);
/*     */   } public static POINT nptMaxPosition(long paramLong) {
/* 303 */     return POINT.create(paramLong + PTMAXPOSITION);
/*     */   } public static RECT nrcNormalPosition(long paramLong) {
/* 305 */     return RECT.create(paramLong + RCNORMALPOSITION);
/*     */   }
/*     */   public static void nlength(long paramLong, int paramInt) {
/* 308 */     UNSAFE.putInt(null, paramLong + LENGTH, paramInt);
/*     */   } public static void nflags(long paramLong, int paramInt) {
/* 310 */     UNSAFE.putInt(null, paramLong + FLAGS, paramInt);
/*     */   } public static void nshowCmd(long paramLong, int paramInt) {
/* 312 */     UNSAFE.putInt(null, paramLong + SHOWCMD, paramInt);
/*     */   } public static void nptMinPosition(long paramLong, POINT paramPOINT) {
/* 314 */     MemoryUtil.memCopy(paramPOINT.address(), paramLong + PTMINPOSITION, POINT.SIZEOF);
/*     */   } public static void nptMaxPosition(long paramLong, POINT paramPOINT) {
/* 316 */     MemoryUtil.memCopy(paramPOINT.address(), paramLong + PTMAXPOSITION, POINT.SIZEOF);
/*     */   } public static void nrcNormalPosition(long paramLong, RECT paramRECT) {
/* 318 */     MemoryUtil.memCopy(paramRECT.address(), paramLong + RCNORMALPOSITION, RECT.SIZEOF);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<WINDOWPLACEMENT, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 325 */     private static final WINDOWPLACEMENT ELEMENT_FACTORY = WINDOWPLACEMENT.create(-1L);
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
/* 337 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / WINDOWPLACEMENT.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 341 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 345 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 350 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected WINDOWPLACEMENT getElementFactory() {
/* 355 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("UINT")
/*     */     public int length() {
/* 360 */       return WINDOWPLACEMENT.nlength(address());
/*     */     } @NativeType("UINT")
/*     */     public int flags() {
/* 363 */       return WINDOWPLACEMENT.nflags(address());
/*     */     } @NativeType("UINT")
/*     */     public int showCmd() {
/* 366 */       return WINDOWPLACEMENT.nshowCmd(address());
/*     */     } public POINT ptMinPosition() {
/* 368 */       return WINDOWPLACEMENT.nptMinPosition(address());
/*     */     } public POINT ptMaxPosition() {
/* 370 */       return WINDOWPLACEMENT.nptMaxPosition(address());
/*     */     } public RECT rcNormalPosition() {
/* 372 */       return WINDOWPLACEMENT.nrcNormalPosition(address());
/*     */     }
/*     */     public Buffer length(@NativeType("UINT") int param1Int) {
/* 375 */       WINDOWPLACEMENT.nlength(address(), param1Int); return this;
/*     */     } public Buffer flags(@NativeType("UINT") int param1Int) {
/* 377 */       WINDOWPLACEMENT.nflags(address(), param1Int); return this;
/*     */     } public Buffer showCmd(@NativeType("UINT") int param1Int) {
/* 379 */       WINDOWPLACEMENT.nshowCmd(address(), param1Int); return this;
/*     */     } public Buffer ptMinPosition(POINT param1POINT) {
/* 381 */       WINDOWPLACEMENT.nptMinPosition(address(), param1POINT); return this;
/*     */     } public Buffer ptMinPosition(Consumer<POINT> param1Consumer) {
/* 383 */       param1Consumer.accept(ptMinPosition()); return this;
/*     */     } public Buffer ptMaxPosition(POINT param1POINT) {
/* 385 */       WINDOWPLACEMENT.nptMaxPosition(address(), param1POINT); return this;
/*     */     } public Buffer ptMaxPosition(Consumer<POINT> param1Consumer) {
/* 387 */       param1Consumer.accept(ptMaxPosition()); return this;
/*     */     } public Buffer rcNormalPosition(RECT param1RECT) {
/* 389 */       WINDOWPLACEMENT.nrcNormalPosition(address(), param1RECT); return this;
/*     */     } public Buffer rcNormalPosition(Consumer<RECT> param1Consumer) {
/* 391 */       param1Consumer.accept(rcNormalPosition()); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\windows\WINDOWPLACEMENT.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */