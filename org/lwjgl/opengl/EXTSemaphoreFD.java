/*    */ package org.lwjgl.opengl;
/*    */ 
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
/*    */ public class EXTSemaphoreFD
/*    */ {
/*    */   public static final int GL_HANDLE_TYPE_OPAQUE_FD_EXT = 38278;
/*    */   
/*    */   static {
/* 20 */     GL.initialize();
/*    */   }
/*    */   
/*    */   public static native void glImportSemaphoreFdEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3);
/*    */   
/*    */   protected EXTSemaphoreFD() {
/* 26 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\EXTSemaphoreFD.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */