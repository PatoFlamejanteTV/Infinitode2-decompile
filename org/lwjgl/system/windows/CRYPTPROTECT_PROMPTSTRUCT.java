/*     */ package org.lwjgl.system.windows;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeResource;
/*     */ import org.lwjgl.system.NativeType;
/*     */ import org.lwjgl.system.Struct;
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
/*     */ public class CRYPTPROTECT_PROMPTSTRUCT
/*     */   extends Struct<CRYPTPROTECT_PROMPTSTRUCT>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int CBSIZE;
/*     */   public static final int DWPROMPTFLAGS;
/*     */   public static final int HWNDAPP;
/*     */   public static final int SZPROMPT;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  56 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(4), __member(POINTER_SIZE), __member(POINTER_SIZE) })).getSize();
/*  57 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  59 */     CBSIZE = layout.offsetof(0);
/*  60 */     DWPROMPTFLAGS = layout.offsetof(1);
/*  61 */     HWNDAPP = layout.offsetof(2);
/*  62 */     SZPROMPT = layout.offsetof(3);
/*     */   }
/*     */   
/*     */   protected CRYPTPROTECT_PROMPTSTRUCT(long paramLong, ByteBuffer paramByteBuffer) {
/*  66 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected CRYPTPROTECT_PROMPTSTRUCT create(long paramLong, ByteBuffer paramByteBuffer) {
/*  71 */     return new CRYPTPROTECT_PROMPTSTRUCT(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CRYPTPROTECT_PROMPTSTRUCT(ByteBuffer paramByteBuffer) {
/*  81 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  85 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("DWORD")
/*     */   public int cbSize() {
/*  89 */     return ncbSize(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dwPromptFlags() {
/*  92 */     return ndwPromptFlags(address());
/*     */   } @NativeType("HWND")
/*     */   public long hwndApp() {
/*  95 */     return nhwndApp(address());
/*     */   } @NativeType("LPCWSTR")
/*     */   public ByteBuffer szPrompt() {
/*  98 */     return nszPrompt(address());
/*     */   } @NativeType("LPCWSTR")
/*     */   public String szPromptString() {
/* 101 */     return nszPromptString(address());
/*     */   }
/*     */   public CRYPTPROTECT_PROMPTSTRUCT cbSize(@NativeType("DWORD") int paramInt) {
/* 104 */     ncbSize(address(), paramInt); return this;
/*     */   } public CRYPTPROTECT_PROMPTSTRUCT cbSize$Default() {
/* 106 */     return cbSize(SIZEOF);
/*     */   } public CRYPTPROTECT_PROMPTSTRUCT dwPromptFlags(@NativeType("DWORD") int paramInt) {
/* 108 */     ndwPromptFlags(address(), paramInt); return this;
/*     */   } public CRYPTPROTECT_PROMPTSTRUCT hwndApp(@NativeType("HWND") long paramLong) {
/* 110 */     nhwndApp(address(), paramLong); return this;
/*     */   } public CRYPTPROTECT_PROMPTSTRUCT szPrompt(@NativeType("LPCWSTR") ByteBuffer paramByteBuffer) {
/* 112 */     nszPrompt(address(), paramByteBuffer); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CRYPTPROTECT_PROMPTSTRUCT set(int paramInt1, int paramInt2, long paramLong, ByteBuffer paramByteBuffer) {
/* 121 */     cbSize(paramInt1);
/* 122 */     dwPromptFlags(paramInt2);
/* 123 */     hwndApp(paramLong);
/* 124 */     szPrompt(paramByteBuffer);
/*     */     
/* 126 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CRYPTPROTECT_PROMPTSTRUCT set(CRYPTPROTECT_PROMPTSTRUCT paramCRYPTPROTECT_PROMPTSTRUCT) {
/* 137 */     MemoryUtil.memCopy(paramCRYPTPROTECT_PROMPTSTRUCT.address(), address(), SIZEOF);
/* 138 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CRYPTPROTECT_PROMPTSTRUCT malloc() {
/* 145 */     return new CRYPTPROTECT_PROMPTSTRUCT(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static CRYPTPROTECT_PROMPTSTRUCT calloc() {
/* 150 */     return new CRYPTPROTECT_PROMPTSTRUCT(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static CRYPTPROTECT_PROMPTSTRUCT create() {
/* 155 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 156 */     return new CRYPTPROTECT_PROMPTSTRUCT(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static CRYPTPROTECT_PROMPTSTRUCT create(long paramLong) {
/* 161 */     return new CRYPTPROTECT_PROMPTSTRUCT(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static CRYPTPROTECT_PROMPTSTRUCT createSafe(long paramLong) {
/* 167 */     return (paramLong == 0L) ? null : new CRYPTPROTECT_PROMPTSTRUCT(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CRYPTPROTECT_PROMPTSTRUCT malloc(MemoryStack paramMemoryStack) {
/* 176 */     return new CRYPTPROTECT_PROMPTSTRUCT(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CRYPTPROTECT_PROMPTSTRUCT calloc(MemoryStack paramMemoryStack) {
/* 185 */     return new CRYPTPROTECT_PROMPTSTRUCT(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ncbSize(long paramLong) {
/* 191 */     return UNSAFE.getInt(null, paramLong + CBSIZE);
/*     */   } public static int ndwPromptFlags(long paramLong) {
/* 193 */     return UNSAFE.getInt(null, paramLong + DWPROMPTFLAGS);
/*     */   } public static long nhwndApp(long paramLong) {
/* 195 */     return MemoryUtil.memGetAddress(paramLong + HWNDAPP);
/*     */   } public static ByteBuffer nszPrompt(long paramLong) {
/* 197 */     return MemoryUtil.memByteBufferNT2(MemoryUtil.memGetAddress(paramLong + SZPROMPT));
/*     */   } public static String nszPromptString(long paramLong) {
/* 199 */     return MemoryUtil.memUTF16(MemoryUtil.memGetAddress(paramLong + SZPROMPT));
/*     */   }
/*     */   public static void ncbSize(long paramLong, int paramInt) {
/* 202 */     UNSAFE.putInt(null, paramLong + CBSIZE, paramInt);
/*     */   } public static void ndwPromptFlags(long paramLong, int paramInt) {
/* 204 */     UNSAFE.putInt(null, paramLong + DWPROMPTFLAGS, paramInt);
/*     */   } public static void nhwndApp(long paramLong1, long paramLong2) {
/* 206 */     MemoryUtil.memPutAddress(paramLong1 + HWNDAPP, Checks.check(paramLong2));
/*     */   }
/*     */   public static void nszPrompt(long paramLong, ByteBuffer paramByteBuffer) {
/* 209 */     if (Checks.CHECKS) Checks.checkNT2(paramByteBuffer); 
/* 210 */     MemoryUtil.memPutAddress(paramLong + SZPROMPT, MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 219 */     Checks.check(MemoryUtil.memGetAddress(paramLong + HWNDAPP));
/* 220 */     Checks.check(MemoryUtil.memGetAddress(paramLong + SZPROMPT));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\windows\CRYPTPROTECT_PROMPTSTRUCT.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */