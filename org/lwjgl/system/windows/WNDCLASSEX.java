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
/*     */ public class WNDCLASSEX
/*     */   extends Struct<WNDCLASSEX>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int CBSIZE;
/*     */   public static final int STYLE;
/*     */   public static final int LPFNWNDPROC;
/*     */   public static final int CBCLSEXTRA;
/*     */   public static final int CBWNDEXTRA;
/*     */   public static final int HINSTANCE;
/*     */   public static final int HICON;
/*     */   public static final int HCURSOR;
/*     */   public static final int HBRBACKGROUND;
/*     */   public static final int LPSZMENUNAME;
/*     */   public static final int LPSZCLASSNAME;
/*     */   public static final int HICONSM;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  79 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(4), __member(POINTER_SIZE), __member(4), __member(4), __member(POINTER_SIZE), __member(POINTER_SIZE), __member(POINTER_SIZE), __member(POINTER_SIZE), __member(POINTER_SIZE), __member(POINTER_SIZE), __member(POINTER_SIZE) })).getSize();
/*  80 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  82 */     CBSIZE = layout.offsetof(0);
/*  83 */     STYLE = layout.offsetof(1);
/*  84 */     LPFNWNDPROC = layout.offsetof(2);
/*  85 */     CBCLSEXTRA = layout.offsetof(3);
/*  86 */     CBWNDEXTRA = layout.offsetof(4);
/*  87 */     HINSTANCE = layout.offsetof(5);
/*  88 */     HICON = layout.offsetof(6);
/*  89 */     HCURSOR = layout.offsetof(7);
/*  90 */     HBRBACKGROUND = layout.offsetof(8);
/*  91 */     LPSZMENUNAME = layout.offsetof(9);
/*  92 */     LPSZCLASSNAME = layout.offsetof(10);
/*  93 */     HICONSM = layout.offsetof(11);
/*     */   }
/*     */   
/*     */   protected WNDCLASSEX(long paramLong, ByteBuffer paramByteBuffer) {
/*  97 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected WNDCLASSEX create(long paramLong, ByteBuffer paramByteBuffer) {
/* 102 */     return new WNDCLASSEX(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WNDCLASSEX(ByteBuffer paramByteBuffer) {
/* 112 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 116 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("UINT")
/*     */   public int cbSize() {
/* 120 */     return ncbSize(address());
/*     */   } @NativeType("UINT")
/*     */   public int style() {
/* 123 */     return nstyle(address());
/*     */   } @NativeType("WNDPROC")
/*     */   public WindowProc lpfnWndProc() {
/* 126 */     return nlpfnWndProc(address());
/*     */   } public int cbClsExtra() {
/* 128 */     return ncbClsExtra(address());
/*     */   } public int cbWndExtra() {
/* 130 */     return ncbWndExtra(address());
/*     */   } @NativeType("HINSTANCE")
/*     */   public long hInstance() {
/* 133 */     return nhInstance(address());
/*     */   } @NativeType("HICON")
/*     */   public long hIcon() {
/* 136 */     return nhIcon(address());
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("HCURSOR")
/*     */   public long hCursor() {
/* 142 */     return nhCursor(address());
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("HBRUSH")
/*     */   public long hbrBackground() {
/* 148 */     return nhbrBackground(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("LPCTSTR")
/*     */   public ByteBuffer lpszMenuName() {
/* 155 */     return nlpszMenuName(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("LPCTSTR")
/*     */   public String lpszMenuNameString() {
/* 162 */     return nlpszMenuNameString(address());
/*     */   } @NativeType("LPCTSTR")
/*     */   public ByteBuffer lpszClassName() {
/* 165 */     return nlpszClassName(address());
/*     */   } @NativeType("LPCTSTR")
/*     */   public String lpszClassNameString() {
/* 168 */     return nlpszClassNameString(address());
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("HICON")
/*     */   public long hIconSm() {
/* 174 */     return nhIconSm(address());
/*     */   }
/*     */   public WNDCLASSEX cbSize(@NativeType("UINT") int paramInt) {
/* 177 */     ncbSize(address(), paramInt); return this;
/*     */   } public WNDCLASSEX style(@NativeType("UINT") int paramInt) {
/* 179 */     nstyle(address(), paramInt); return this;
/*     */   } public WNDCLASSEX lpfnWndProc(@NativeType("WNDPROC") WindowProcI paramWindowProcI) {
/* 181 */     nlpfnWndProc(address(), paramWindowProcI); return this;
/*     */   } public WNDCLASSEX cbClsExtra(int paramInt) {
/* 183 */     ncbClsExtra(address(), paramInt); return this;
/*     */   } public WNDCLASSEX cbWndExtra(int paramInt) {
/* 185 */     ncbWndExtra(address(), paramInt); return this;
/*     */   } public WNDCLASSEX hInstance(@NativeType("HINSTANCE") long paramLong) {
/* 187 */     nhInstance(address(), paramLong); return this;
/*     */   } public WNDCLASSEX hIcon(@NativeType("HICON") long paramLong) {
/* 189 */     nhIcon(address(), paramLong); return this;
/*     */   } public WNDCLASSEX hCursor(@NativeType("HCURSOR") long paramLong) {
/* 191 */     nhCursor(address(), paramLong); return this;
/*     */   } public WNDCLASSEX hbrBackground(@NativeType("HBRUSH") long paramLong) {
/* 193 */     nhbrBackground(address(), paramLong); return this;
/*     */   } public WNDCLASSEX lpszMenuName(@NativeType("LPCTSTR") ByteBuffer paramByteBuffer) {
/* 195 */     nlpszMenuName(address(), paramByteBuffer); return this;
/*     */   } public WNDCLASSEX lpszClassName(@NativeType("LPCTSTR") ByteBuffer paramByteBuffer) {
/* 197 */     nlpszClassName(address(), paramByteBuffer); return this;
/*     */   } public WNDCLASSEX hIconSm(@NativeType("HICON") long paramLong) {
/* 199 */     nhIconSm(address(), paramLong); return this;
/*     */   }
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
/*     */   public WNDCLASSEX set(int paramInt1, int paramInt2, WindowProcI paramWindowProcI, int paramInt3, int paramInt4, long paramLong1, long paramLong2, long paramLong3, long paramLong4, ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, long paramLong5) {
/* 216 */     cbSize(paramInt1);
/* 217 */     style(paramInt2);
/* 218 */     lpfnWndProc(paramWindowProcI);
/* 219 */     cbClsExtra(paramInt3);
/* 220 */     cbWndExtra(paramInt4);
/* 221 */     hInstance(paramLong1);
/* 222 */     hIcon(paramLong2);
/* 223 */     hCursor(paramLong3);
/* 224 */     hbrBackground(paramLong4);
/* 225 */     lpszMenuName(paramByteBuffer1);
/* 226 */     lpszClassName(paramByteBuffer2);
/* 227 */     hIconSm(paramLong5);
/*     */     
/* 229 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WNDCLASSEX set(WNDCLASSEX paramWNDCLASSEX) {
/* 240 */     MemoryUtil.memCopy(paramWNDCLASSEX.address(), address(), SIZEOF);
/* 241 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static WNDCLASSEX malloc() {
/* 248 */     return new WNDCLASSEX(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static WNDCLASSEX calloc() {
/* 253 */     return new WNDCLASSEX(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static WNDCLASSEX create() {
/* 258 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 259 */     return new WNDCLASSEX(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static WNDCLASSEX create(long paramLong) {
/* 264 */     return new WNDCLASSEX(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static WNDCLASSEX createSafe(long paramLong) {
/* 270 */     return (paramLong == 0L) ? null : new WNDCLASSEX(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 279 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 288 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 297 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 298 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 308 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 314 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static WNDCLASSEX mallocStack() {
/* 320 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 322 */   public static WNDCLASSEX callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 324 */   public static WNDCLASSEX mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 326 */   public static WNDCLASSEX callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 328 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 330 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 332 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 334 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static WNDCLASSEX malloc(MemoryStack paramMemoryStack) {
/* 342 */     return new WNDCLASSEX(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static WNDCLASSEX calloc(MemoryStack paramMemoryStack) {
/* 351 */     return new WNDCLASSEX(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 361 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 371 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ncbSize(long paramLong) {
/* 377 */     return UNSAFE.getInt(null, paramLong + CBSIZE);
/*     */   } public static int nstyle(long paramLong) {
/* 379 */     return UNSAFE.getInt(null, paramLong + STYLE);
/*     */   } public static WindowProc nlpfnWndProc(long paramLong) {
/* 381 */     return WindowProc.create(MemoryUtil.memGetAddress(paramLong + LPFNWNDPROC));
/*     */   } public static int ncbClsExtra(long paramLong) {
/* 383 */     return UNSAFE.getInt(null, paramLong + CBCLSEXTRA);
/*     */   } public static int ncbWndExtra(long paramLong) {
/* 385 */     return UNSAFE.getInt(null, paramLong + CBWNDEXTRA);
/*     */   } public static long nhInstance(long paramLong) {
/* 387 */     return MemoryUtil.memGetAddress(paramLong + HINSTANCE);
/*     */   } public static long nhIcon(long paramLong) {
/* 389 */     return MemoryUtil.memGetAddress(paramLong + HICON);
/*     */   } public static long nhCursor(long paramLong) {
/* 391 */     return MemoryUtil.memGetAddress(paramLong + HCURSOR);
/*     */   } public static long nhbrBackground(long paramLong) {
/* 393 */     return MemoryUtil.memGetAddress(paramLong + HBRBACKGROUND);
/*     */   } public static ByteBuffer nlpszMenuName(long paramLong) {
/* 395 */     return MemoryUtil.memByteBufferNT2Safe(MemoryUtil.memGetAddress(paramLong + LPSZMENUNAME));
/*     */   } public static String nlpszMenuNameString(long paramLong) {
/* 397 */     return MemoryUtil.memUTF16Safe(MemoryUtil.memGetAddress(paramLong + LPSZMENUNAME));
/*     */   } public static ByteBuffer nlpszClassName(long paramLong) {
/* 399 */     return MemoryUtil.memByteBufferNT2(MemoryUtil.memGetAddress(paramLong + LPSZCLASSNAME));
/*     */   } public static String nlpszClassNameString(long paramLong) {
/* 401 */     return MemoryUtil.memUTF16(MemoryUtil.memGetAddress(paramLong + LPSZCLASSNAME));
/*     */   } public static long nhIconSm(long paramLong) {
/* 403 */     return MemoryUtil.memGetAddress(paramLong + HICONSM);
/*     */   }
/*     */   public static void ncbSize(long paramLong, int paramInt) {
/* 406 */     UNSAFE.putInt(null, paramLong + CBSIZE, paramInt);
/*     */   } public static void nstyle(long paramLong, int paramInt) {
/* 408 */     UNSAFE.putInt(null, paramLong + STYLE, paramInt);
/*     */   } public static void nlpfnWndProc(long paramLong, WindowProcI paramWindowProcI) {
/* 410 */     MemoryUtil.memPutAddress(paramLong + LPFNWNDPROC, paramWindowProcI.address());
/*     */   } public static void ncbClsExtra(long paramLong, int paramInt) {
/* 412 */     UNSAFE.putInt(null, paramLong + CBCLSEXTRA, paramInt);
/*     */   } public static void ncbWndExtra(long paramLong, int paramInt) {
/* 414 */     UNSAFE.putInt(null, paramLong + CBWNDEXTRA, paramInt);
/*     */   } public static void nhInstance(long paramLong1, long paramLong2) {
/* 416 */     MemoryUtil.memPutAddress(paramLong1 + HINSTANCE, paramLong2);
/*     */   } public static void nhIcon(long paramLong1, long paramLong2) {
/* 418 */     MemoryUtil.memPutAddress(paramLong1 + HICON, paramLong2);
/*     */   } public static void nhCursor(long paramLong1, long paramLong2) {
/* 420 */     MemoryUtil.memPutAddress(paramLong1 + HCURSOR, paramLong2);
/*     */   } public static void nhbrBackground(long paramLong1, long paramLong2) {
/* 422 */     MemoryUtil.memPutAddress(paramLong1 + HBRBACKGROUND, paramLong2);
/*     */   }
/*     */   public static void nlpszMenuName(long paramLong, ByteBuffer paramByteBuffer) {
/* 425 */     if (Checks.CHECKS) Checks.checkNT2Safe(paramByteBuffer); 
/* 426 */     MemoryUtil.memPutAddress(paramLong + LPSZMENUNAME, MemoryUtil.memAddressSafe(paramByteBuffer));
/*     */   }
/*     */   
/*     */   public static void nlpszClassName(long paramLong, ByteBuffer paramByteBuffer) {
/* 430 */     if (Checks.CHECKS) Checks.checkNT2(paramByteBuffer); 
/* 431 */     MemoryUtil.memPutAddress(paramLong + LPSZCLASSNAME, MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */   public static void nhIconSm(long paramLong1, long paramLong2) {
/* 434 */     MemoryUtil.memPutAddress(paramLong1 + HICONSM, paramLong2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 442 */     Checks.check(MemoryUtil.memGetAddress(paramLong + LPFNWNDPROC));
/* 443 */     Checks.check(MemoryUtil.memGetAddress(paramLong + LPSZCLASSNAME));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<WNDCLASSEX, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 451 */     private static final WNDCLASSEX ELEMENT_FACTORY = WNDCLASSEX.create(-1L);
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
/* 463 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / WNDCLASSEX.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 467 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 471 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 476 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected WNDCLASSEX getElementFactory() {
/* 481 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("UINT")
/*     */     public int cbSize() {
/* 486 */       return WNDCLASSEX.ncbSize(address());
/*     */     } @NativeType("UINT")
/*     */     public int style() {
/* 489 */       return WNDCLASSEX.nstyle(address());
/*     */     } @NativeType("WNDPROC")
/*     */     public WindowProc lpfnWndProc() {
/* 492 */       return WNDCLASSEX.nlpfnWndProc(address());
/*     */     } public int cbClsExtra() {
/* 494 */       return WNDCLASSEX.ncbClsExtra(address());
/*     */     } public int cbWndExtra() {
/* 496 */       return WNDCLASSEX.ncbWndExtra(address());
/*     */     } @NativeType("HINSTANCE")
/*     */     public long hInstance() {
/* 499 */       return WNDCLASSEX.nhInstance(address());
/*     */     } @NativeType("HICON")
/*     */     public long hIcon() {
/* 502 */       return WNDCLASSEX.nhIcon(address());
/*     */     } @NativeType("HCURSOR")
/*     */     public long hCursor() {
/* 505 */       return WNDCLASSEX.nhCursor(address());
/*     */     } @NativeType("HBRUSH")
/*     */     public long hbrBackground() {
/* 508 */       return WNDCLASSEX.nhbrBackground(address());
/*     */     }
/*     */     @NativeType("LPCTSTR")
/*     */     public ByteBuffer lpszMenuName() {
/* 512 */       return WNDCLASSEX.nlpszMenuName(address());
/*     */     }
/*     */     @NativeType("LPCTSTR")
/*     */     public String lpszMenuNameString() {
/* 516 */       return WNDCLASSEX.nlpszMenuNameString(address());
/*     */     } @NativeType("LPCTSTR")
/*     */     public ByteBuffer lpszClassName() {
/* 519 */       return WNDCLASSEX.nlpszClassName(address());
/*     */     } @NativeType("LPCTSTR")
/*     */     public String lpszClassNameString() {
/* 522 */       return WNDCLASSEX.nlpszClassNameString(address());
/*     */     } @NativeType("HICON")
/*     */     public long hIconSm() {
/* 525 */       return WNDCLASSEX.nhIconSm(address());
/*     */     }
/*     */     public Buffer cbSize(@NativeType("UINT") int param1Int) {
/* 528 */       WNDCLASSEX.ncbSize(address(), param1Int); return this;
/*     */     } public Buffer style(@NativeType("UINT") int param1Int) {
/* 530 */       WNDCLASSEX.nstyle(address(), param1Int); return this;
/*     */     } public Buffer lpfnWndProc(@NativeType("WNDPROC") WindowProcI param1WindowProcI) {
/* 532 */       WNDCLASSEX.nlpfnWndProc(address(), param1WindowProcI); return this;
/*     */     } public Buffer cbClsExtra(int param1Int) {
/* 534 */       WNDCLASSEX.ncbClsExtra(address(), param1Int); return this;
/*     */     } public Buffer cbWndExtra(int param1Int) {
/* 536 */       WNDCLASSEX.ncbWndExtra(address(), param1Int); return this;
/*     */     } public Buffer hInstance(@NativeType("HINSTANCE") long param1Long) {
/* 538 */       WNDCLASSEX.nhInstance(address(), param1Long); return this;
/*     */     } public Buffer hIcon(@NativeType("HICON") long param1Long) {
/* 540 */       WNDCLASSEX.nhIcon(address(), param1Long); return this;
/*     */     } public Buffer hCursor(@NativeType("HCURSOR") long param1Long) {
/* 542 */       WNDCLASSEX.nhCursor(address(), param1Long); return this;
/*     */     } public Buffer hbrBackground(@NativeType("HBRUSH") long param1Long) {
/* 544 */       WNDCLASSEX.nhbrBackground(address(), param1Long); return this;
/*     */     } public Buffer lpszMenuName(@NativeType("LPCTSTR") ByteBuffer param1ByteBuffer) {
/* 546 */       WNDCLASSEX.nlpszMenuName(address(), param1ByteBuffer); return this;
/*     */     } public Buffer lpszClassName(@NativeType("LPCTSTR") ByteBuffer param1ByteBuffer) {
/* 548 */       WNDCLASSEX.nlpszClassName(address(), param1ByteBuffer); return this;
/*     */     } public Buffer hIconSm(@NativeType("HICON") long param1Long) {
/* 550 */       WNDCLASSEX.nhIconSm(address(), param1Long); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\windows\WNDCLASSEX.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */