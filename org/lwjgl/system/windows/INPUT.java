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
/*     */ public class INPUT
/*     */   extends Struct<INPUT>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int DUMMYUNIONNAME;
/*     */   public static final int DUMMYUNIONNAME_MI;
/*     */   public static final int DUMMYUNIONNAME_KI;
/*     */   public static final int DUMMYUNIONNAME_HI;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  59 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), (Struct.Member)__union(new Struct.Member[] { __member(MOUSEINPUT.SIZEOF, MOUSEINPUT.ALIGNOF), __member(KEYBDINPUT.SIZEOF, KEYBDINPUT.ALIGNOF), __member(HARDWAREINPUT.SIZEOF, HARDWAREINPUT.ALIGNOF) }) })).getSize();
/*  60 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  62 */     TYPE = layout.offsetof(0);
/*  63 */     DUMMYUNIONNAME = layout.offsetof(1);
/*  64 */     DUMMYUNIONNAME_MI = layout.offsetof(2);
/*  65 */     DUMMYUNIONNAME_KI = layout.offsetof(3);
/*  66 */     DUMMYUNIONNAME_HI = layout.offsetof(4);
/*     */   }
/*     */   
/*     */   protected INPUT(long paramLong, ByteBuffer paramByteBuffer) {
/*  70 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected INPUT create(long paramLong, ByteBuffer paramByteBuffer) {
/*  75 */     return new INPUT(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public INPUT(ByteBuffer paramByteBuffer) {
/*  85 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  89 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("DWORD")
/*     */   public int type() {
/*  93 */     return ntype(address());
/*     */   } public MOUSEINPUT DUMMYUNIONNAME_mi() {
/*  95 */     return nDUMMYUNIONNAME_mi(address());
/*     */   } public KEYBDINPUT DUMMYUNIONNAME_ki() {
/*  97 */     return nDUMMYUNIONNAME_ki(address());
/*     */   } public HARDWAREINPUT DUMMYUNIONNAME_hi() {
/*  99 */     return nDUMMYUNIONNAME_hi(address());
/*     */   }
/*     */   public INPUT type(@NativeType("DWORD") int paramInt) {
/* 102 */     ntype(address(), paramInt); return this;
/*     */   } public INPUT DUMMYUNIONNAME_mi(MOUSEINPUT paramMOUSEINPUT) {
/* 104 */     nDUMMYUNIONNAME_mi(address(), paramMOUSEINPUT); return this;
/*     */   } public INPUT DUMMYUNIONNAME_mi(Consumer<MOUSEINPUT> paramConsumer) {
/* 106 */     paramConsumer.accept(DUMMYUNIONNAME_mi()); return this;
/*     */   } public INPUT DUMMYUNIONNAME_ki(KEYBDINPUT paramKEYBDINPUT) {
/* 108 */     nDUMMYUNIONNAME_ki(address(), paramKEYBDINPUT); return this;
/*     */   } public INPUT DUMMYUNIONNAME_ki(Consumer<KEYBDINPUT> paramConsumer) {
/* 110 */     paramConsumer.accept(DUMMYUNIONNAME_ki()); return this;
/*     */   } public INPUT DUMMYUNIONNAME_hi(HARDWAREINPUT paramHARDWAREINPUT) {
/* 112 */     nDUMMYUNIONNAME_hi(address(), paramHARDWAREINPUT); return this;
/*     */   } public INPUT DUMMYUNIONNAME_hi(Consumer<HARDWAREINPUT> paramConsumer) {
/* 114 */     paramConsumer.accept(DUMMYUNIONNAME_hi()); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public INPUT set(INPUT paramINPUT) {
/* 124 */     MemoryUtil.memCopy(paramINPUT.address(), address(), SIZEOF);
/* 125 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static INPUT malloc() {
/* 132 */     return new INPUT(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static INPUT calloc() {
/* 137 */     return new INPUT(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static INPUT create() {
/* 142 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 143 */     return new INPUT(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static INPUT create(long paramLong) {
/* 148 */     return new INPUT(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static INPUT createSafe(long paramLong) {
/* 154 */     return (paramLong == 0L) ? null : new INPUT(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 163 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 172 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 181 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 182 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 192 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 198 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static INPUT mallocStack() {
/* 204 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 206 */   public static INPUT callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 208 */   public static INPUT mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 210 */   public static INPUT callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 212 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 214 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 216 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 218 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static INPUT malloc(MemoryStack paramMemoryStack) {
/* 226 */     return new INPUT(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static INPUT calloc(MemoryStack paramMemoryStack) {
/* 235 */     return new INPUT(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 245 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 255 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long paramLong) {
/* 261 */     return UNSAFE.getInt(null, paramLong + TYPE);
/*     */   } public static MOUSEINPUT nDUMMYUNIONNAME_mi(long paramLong) {
/* 263 */     return MOUSEINPUT.create(paramLong + DUMMYUNIONNAME_MI);
/*     */   } public static KEYBDINPUT nDUMMYUNIONNAME_ki(long paramLong) {
/* 265 */     return KEYBDINPUT.create(paramLong + DUMMYUNIONNAME_KI);
/*     */   } public static HARDWAREINPUT nDUMMYUNIONNAME_hi(long paramLong) {
/* 267 */     return HARDWAREINPUT.create(paramLong + DUMMYUNIONNAME_HI);
/*     */   }
/*     */   public static void ntype(long paramLong, int paramInt) {
/* 270 */     UNSAFE.putInt(null, paramLong + TYPE, paramInt);
/*     */   } public static void nDUMMYUNIONNAME_mi(long paramLong, MOUSEINPUT paramMOUSEINPUT) {
/* 272 */     MemoryUtil.memCopy(paramMOUSEINPUT.address(), paramLong + DUMMYUNIONNAME_MI, MOUSEINPUT.SIZEOF);
/*     */   } public static void nDUMMYUNIONNAME_ki(long paramLong, KEYBDINPUT paramKEYBDINPUT) {
/* 274 */     MemoryUtil.memCopy(paramKEYBDINPUT.address(), paramLong + DUMMYUNIONNAME_KI, KEYBDINPUT.SIZEOF);
/*     */   } public static void nDUMMYUNIONNAME_hi(long paramLong, HARDWAREINPUT paramHARDWAREINPUT) {
/* 276 */     MemoryUtil.memCopy(paramHARDWAREINPUT.address(), paramLong + DUMMYUNIONNAME_HI, HARDWAREINPUT.SIZEOF);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<INPUT, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 283 */     private static final INPUT ELEMENT_FACTORY = INPUT.create(-1L);
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
/* 295 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / INPUT.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 299 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 303 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 308 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected INPUT getElementFactory() {
/* 313 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("DWORD")
/*     */     public int type() {
/* 318 */       return INPUT.ntype(address());
/*     */     } public MOUSEINPUT DUMMYUNIONNAME_mi() {
/* 320 */       return INPUT.nDUMMYUNIONNAME_mi(address());
/*     */     } public KEYBDINPUT DUMMYUNIONNAME_ki() {
/* 322 */       return INPUT.nDUMMYUNIONNAME_ki(address());
/*     */     } public HARDWAREINPUT DUMMYUNIONNAME_hi() {
/* 324 */       return INPUT.nDUMMYUNIONNAME_hi(address());
/*     */     }
/*     */     public Buffer type(@NativeType("DWORD") int param1Int) {
/* 327 */       INPUT.ntype(address(), param1Int); return this;
/*     */     } public Buffer DUMMYUNIONNAME_mi(MOUSEINPUT param1MOUSEINPUT) {
/* 329 */       INPUT.nDUMMYUNIONNAME_mi(address(), param1MOUSEINPUT); return this;
/*     */     } public Buffer DUMMYUNIONNAME_mi(Consumer<MOUSEINPUT> param1Consumer) {
/* 331 */       param1Consumer.accept(DUMMYUNIONNAME_mi()); return this;
/*     */     } public Buffer DUMMYUNIONNAME_ki(KEYBDINPUT param1KEYBDINPUT) {
/* 333 */       INPUT.nDUMMYUNIONNAME_ki(address(), param1KEYBDINPUT); return this;
/*     */     } public Buffer DUMMYUNIONNAME_ki(Consumer<KEYBDINPUT> param1Consumer) {
/* 335 */       param1Consumer.accept(DUMMYUNIONNAME_ki()); return this;
/*     */     } public Buffer DUMMYUNIONNAME_hi(HARDWAREINPUT param1HARDWAREINPUT) {
/* 337 */       INPUT.nDUMMYUNIONNAME_hi(address(), param1HARDWAREINPUT); return this;
/*     */     } public Buffer DUMMYUNIONNAME_hi(Consumer<HARDWAREINPUT> param1Consumer) {
/* 339 */       param1Consumer.accept(DUMMYUNIONNAME_hi()); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\windows\INPUT.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */