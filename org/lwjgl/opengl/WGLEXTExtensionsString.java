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
/*    */ public class WGLEXTExtensionsString
/*    */ {
/*    */   protected WGLEXTExtensionsString() {
/* 20 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static long nwglGetExtensionsStringEXT() {
/* 27 */     long l = (GL.getCapabilitiesWGL()).wglGetExtensionsStringEXT;
/* 28 */     if (Checks.CHECKS) {
/* 29 */       Checks.check(l);
/*    */     }
/* 31 */     return JNI.callP(l);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("char const *")
/*    */   public static String wglGetExtensionsStringEXT() {
/*    */     long l;
/* 43 */     return MemoryUtil.memASCIISafe(l = nwglGetExtensionsStringEXT());
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\WGLEXTExtensionsString.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */