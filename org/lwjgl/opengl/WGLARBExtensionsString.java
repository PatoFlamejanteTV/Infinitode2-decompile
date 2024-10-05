/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.JNI;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WGLARBExtensionsString
/*    */ {
/*    */   protected WGLARBExtensionsString() {
/* 25 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static long nwglGetExtensionsStringARB(long paramLong) {
/* 32 */     long l = (GL.getCapabilitiesWGL()).wglGetExtensionsStringARB;
/* 33 */     if (Checks.CHECKS) {
/* 34 */       Checks.check(l);
/* 35 */       Checks.check(paramLong);
/*    */     } 
/* 37 */     return JNI.callPP(paramLong, l);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("char const *")
/*    */   public static String wglGetExtensionsStringARB(@NativeType("HDC") long paramLong) {
/*    */     long l;
/* 51 */     return MemoryUtil.memASCIISafe(l = nwglGetExtensionsStringARB(paramLong));
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\WGLARBExtensionsString.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */