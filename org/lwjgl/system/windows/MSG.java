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
/*     */ public class MSG
/*     */   extends Struct<MSG>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int HWND;
/*     */   public static final int MESSAGE;
/*     */   public static final int WPARAM;
/*     */   public static final int LPARAM;
/*     */   public static final int TIME;
/*     */   public static final int PT;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  60 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(POINTER_SIZE), __member(4), __member(POINTER_SIZE), __member(POINTER_SIZE), __member(4), __member(POINT.SIZEOF, POINT.ALIGNOF) })).getSize();
/*  61 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  63 */     HWND = layout.offsetof(0);
/*  64 */     MESSAGE = layout.offsetof(1);
/*  65 */     WPARAM = layout.offsetof(2);
/*  66 */     LPARAM = layout.offsetof(3);
/*  67 */     TIME = layout.offsetof(4);
/*  68 */     PT = layout.offsetof(5);
/*     */   }
/*     */   
/*     */   protected MSG(long paramLong, ByteBuffer paramByteBuffer) {
/*  72 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected MSG create(long paramLong, ByteBuffer paramByteBuffer) {
/*  77 */     return new MSG(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MSG(ByteBuffer paramByteBuffer) {
/*  87 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  91 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("HWND")
/*     */   public long hwnd() {
/*  95 */     return nhwnd(address());
/*     */   } @NativeType("UINT")
/*     */   public int message() {
/*  98 */     return nmessage(address());
/*     */   } @NativeType("WPARAM")
/*     */   public long wParam() {
/* 101 */     return nwParam(address());
/*     */   } @NativeType("LPARAM")
/*     */   public long lParam() {
/* 104 */     return nlParam(address());
/*     */   } @NativeType("DWORD")
/*     */   public int time() {
/* 107 */     return ntime(address());
/*     */   } public POINT pt() {
/* 109 */     return npt(address());
/*     */   }
/*     */   public MSG hwnd(@NativeType("HWND") long paramLong) {
/* 112 */     nhwnd(address(), paramLong); return this;
/*     */   } public MSG message(@NativeType("UINT") int paramInt) {
/* 114 */     nmessage(address(), paramInt); return this;
/*     */   } public MSG wParam(@NativeType("WPARAM") long paramLong) {
/* 116 */     nwParam(address(), paramLong); return this;
/*     */   } public MSG lParam(@NativeType("LPARAM") long paramLong) {
/* 118 */     nlParam(address(), paramLong); return this;
/*     */   } public MSG time(@NativeType("DWORD") int paramInt) {
/* 120 */     ntime(address(), paramInt); return this;
/*     */   } public MSG pt(POINT paramPOINT) {
/* 122 */     npt(address(), paramPOINT); return this;
/*     */   } public MSG pt(Consumer<POINT> paramConsumer) {
/* 124 */     paramConsumer.accept(pt()); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MSG set(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2, POINT paramPOINT) {
/* 135 */     hwnd(paramLong1);
/* 136 */     message(paramInt1);
/* 137 */     wParam(paramLong2);
/* 138 */     lParam(paramLong3);
/* 139 */     time(paramInt2);
/* 140 */     pt(paramPOINT);
/*     */     
/* 142 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MSG set(MSG paramMSG) {
/* 153 */     MemoryUtil.memCopy(paramMSG.address(), address(), SIZEOF);
/* 154 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static MSG malloc() {
/* 161 */     return new MSG(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static MSG calloc() {
/* 166 */     return new MSG(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static MSG create() {
/* 171 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 172 */     return new MSG(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static MSG create(long paramLong) {
/* 177 */     return new MSG(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static MSG createSafe(long paramLong) {
/* 183 */     return (paramLong == 0L) ? null : new MSG(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 192 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 201 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 210 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 211 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 221 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 227 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static MSG mallocStack() {
/* 233 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 235 */   public static MSG callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 237 */   public static MSG mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 239 */   public static MSG callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 241 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 243 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 245 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 247 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static MSG malloc(MemoryStack paramMemoryStack) {
/* 255 */     return new MSG(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static MSG calloc(MemoryStack paramMemoryStack) {
/* 264 */     return new MSG(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 274 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 284 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nhwnd(long paramLong) {
/* 290 */     return MemoryUtil.memGetAddress(paramLong + HWND);
/*     */   } public static int nmessage(long paramLong) {
/* 292 */     return UNSAFE.getInt(null, paramLong + MESSAGE);
/*     */   } public static long nwParam(long paramLong) {
/* 294 */     return MemoryUtil.memGetAddress(paramLong + WPARAM);
/*     */   } public static long nlParam(long paramLong) {
/* 296 */     return MemoryUtil.memGetAddress(paramLong + LPARAM);
/*     */   } public static int ntime(long paramLong) {
/* 298 */     return UNSAFE.getInt(null, paramLong + TIME);
/*     */   } public static POINT npt(long paramLong) {
/* 300 */     return POINT.create(paramLong + PT);
/*     */   }
/*     */   public static void nhwnd(long paramLong1, long paramLong2) {
/* 303 */     MemoryUtil.memPutAddress(paramLong1 + HWND, paramLong2);
/*     */   } public static void nmessage(long paramLong, int paramInt) {
/* 305 */     UNSAFE.putInt(null, paramLong + MESSAGE, paramInt);
/*     */   } public static void nwParam(long paramLong1, long paramLong2) {
/* 307 */     MemoryUtil.memPutAddress(paramLong1 + WPARAM, paramLong2);
/*     */   } public static void nlParam(long paramLong1, long paramLong2) {
/* 309 */     MemoryUtil.memPutAddress(paramLong1 + LPARAM, paramLong2);
/*     */   } public static void ntime(long paramLong, int paramInt) {
/* 311 */     UNSAFE.putInt(null, paramLong + TIME, paramInt);
/*     */   } public static void npt(long paramLong, POINT paramPOINT) {
/* 313 */     MemoryUtil.memCopy(paramPOINT.address(), paramLong + PT, POINT.SIZEOF);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<MSG, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 320 */     private static final MSG ELEMENT_FACTORY = MSG.create(-1L);
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
/* 332 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / MSG.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 336 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 340 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 345 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected MSG getElementFactory() {
/* 350 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("HWND")
/*     */     public long hwnd() {
/* 355 */       return MSG.nhwnd(address());
/*     */     } @NativeType("UINT")
/*     */     public int message() {
/* 358 */       return MSG.nmessage(address());
/*     */     } @NativeType("WPARAM")
/*     */     public long wParam() {
/* 361 */       return MSG.nwParam(address());
/*     */     } @NativeType("LPARAM")
/*     */     public long lParam() {
/* 364 */       return MSG.nlParam(address());
/*     */     } @NativeType("DWORD")
/*     */     public int time() {
/* 367 */       return MSG.ntime(address());
/*     */     } public POINT pt() {
/* 369 */       return MSG.npt(address());
/*     */     }
/*     */     public Buffer hwnd(@NativeType("HWND") long param1Long) {
/* 372 */       MSG.nhwnd(address(), param1Long); return this;
/*     */     } public Buffer message(@NativeType("UINT") int param1Int) {
/* 374 */       MSG.nmessage(address(), param1Int); return this;
/*     */     } public Buffer wParam(@NativeType("WPARAM") long param1Long) {
/* 376 */       MSG.nwParam(address(), param1Long); return this;
/*     */     } public Buffer lParam(@NativeType("LPARAM") long param1Long) {
/* 378 */       MSG.nlParam(address(), param1Long); return this;
/*     */     } public Buffer time(@NativeType("DWORD") int param1Int) {
/* 380 */       MSG.ntime(address(), param1Int); return this;
/*     */     } public Buffer pt(POINT param1POINT) {
/* 382 */       MSG.npt(address(), param1POINT); return this;
/*     */     } public Buffer pt(Consumer<POINT> param1Consumer) {
/* 384 */       param1Consumer.accept(pt()); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\windows\MSG.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */