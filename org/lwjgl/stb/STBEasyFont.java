/*     */ package org.lwjgl.stb;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
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
/*     */ public class STBEasyFont
/*     */ {
/*     */   static {
/*  56 */     LibSTB.initialize();
/*     */   }
/*     */   protected STBEasyFont() {
/*  59 */     throw new UnsupportedOperationException();
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
/*     */   public static int stb_easy_font_width(@NativeType("char *") ByteBuffer paramByteBuffer) {
/*  75 */     if (Checks.CHECKS) {
/*  76 */       Checks.checkNT1(paramByteBuffer);
/*     */     }
/*  78 */     return nstb_easy_font_width(MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_easy_font_width(@NativeType("char *") CharSequence paramCharSequence) {
/*     */     MemoryStack memoryStack;
/*  89 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/*  91 */       memoryStack.nASCII(paramCharSequence, true);
/*     */       long l;
/*  93 */       return nstb_easy_font_width(l = memoryStack.getPointerAddress());
/*     */     } finally {
/*  95 */       memoryStack.setPointer(i);
/*     */     } 
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
/*     */   public static int stb_easy_font_height(@NativeType("char *") ByteBuffer paramByteBuffer) {
/* 112 */     if (Checks.CHECKS) {
/* 113 */       Checks.checkNT1(paramByteBuffer);
/*     */     }
/* 115 */     return nstb_easy_font_height(MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stb_easy_font_height(@NativeType("char *") CharSequence paramCharSequence) {
/*     */     MemoryStack memoryStack;
/* 126 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 128 */       memoryStack.nASCII(paramCharSequence, true);
/*     */       long l;
/* 130 */       return nstb_easy_font_height(l = memoryStack.getPointerAddress());
/*     */     } finally {
/* 132 */       memoryStack.setPointer(i);
/*     */     } 
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
/*     */   public static int stb_easy_font_print(float paramFloat1, float paramFloat2, @NativeType("char *") ByteBuffer paramByteBuffer1, @NativeType("unsigned char *") ByteBuffer paramByteBuffer2, @NativeType("void *") ByteBuffer paramByteBuffer3) {
/* 177 */     if (Checks.CHECKS) {
/* 178 */       Checks.checkNT1(paramByteBuffer1);
/* 179 */       Checks.checkSafe(paramByteBuffer2, 4);
/*     */     } 
/* 181 */     return nstb_easy_font_print(paramFloat1, paramFloat2, MemoryUtil.memAddress(paramByteBuffer1), MemoryUtil.memAddressSafe(paramByteBuffer2), MemoryUtil.memAddress(paramByteBuffer3), paramByteBuffer3.remaining());
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
/*     */   public static int stb_easy_font_print(float paramFloat1, float paramFloat2, @NativeType("char *") CharSequence paramCharSequence, @NativeType("unsigned char *") ByteBuffer paramByteBuffer1, @NativeType("void *") ByteBuffer paramByteBuffer2) {
/* 216 */     if (Checks.CHECKS)
/* 217 */       Checks.checkSafe(paramByteBuffer1, 4); 
/*     */     MemoryStack memoryStack;
/* 219 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 221 */       memoryStack.nASCII(paramCharSequence, true);
/* 222 */       long l = memoryStack.getPointerAddress();
/* 223 */       return nstb_easy_font_print(paramFloat1, paramFloat2, l, MemoryUtil.memAddressSafe(paramByteBuffer1), MemoryUtil.memAddress(paramByteBuffer2), paramByteBuffer2.remaining());
/*     */     } finally {
/* 225 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static native int nstb_easy_font_width(long paramLong);
/*     */   
/*     */   public static native int nstb_easy_font_height(long paramLong);
/*     */   
/*     */   public static native int nstb_easy_font_print(float paramFloat1, float paramFloat2, long paramLong1, long paramLong2, long paramLong3, int paramInt);
/*     */   
/*     */   public static native void stb_easy_font_spacing(float paramFloat);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\stb\STBEasyFont.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */