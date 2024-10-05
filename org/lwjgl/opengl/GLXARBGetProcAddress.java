/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
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
/*     */ public class GLXARBGetProcAddress
/*     */ {
/*     */   protected GLXARBGetProcAddress() {
/*  27 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglXGetProcAddressARB(long paramLong) {
/*  34 */     long l = (GL.getCapabilitiesGLXClient()).glXGetProcAddressARB;
/*  35 */     if (Checks.CHECKS) {
/*  36 */       Checks.check(l);
/*     */     }
/*  38 */     return JNI.callPP(paramLong, l);
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
/*     */   @NativeType("void *")
/*     */   public static long glXGetProcAddressARB(@NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/*  65 */     if (Checks.CHECKS) {
/*  66 */       Checks.checkNT1(paramByteBuffer);
/*     */     }
/*  68 */     return nglXGetProcAddressARB(MemoryUtil.memAddress(paramByteBuffer));
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
/*     */   @NativeType("void *")
/*     */   public static long glXGetProcAddressARB(@NativeType("GLchar const *") CharSequence paramCharSequence) {
/*     */     MemoryStack memoryStack;
/*  95 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/*  97 */       memoryStack.nASCII(paramCharSequence, true);
/*     */       long l;
/*  99 */       return nglXGetProcAddressARB(l = memoryStack.getPointerAddress());
/*     */     } finally {
/* 101 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GLXARBGetProcAddress.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */