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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NVPrimitiveRestart
/*    */ {
/*    */   public static final int GL_PRIMITIVE_RESTART_NV = 34136;
/*    */   public static final int GL_PRIMITIVE_RESTART_INDEX_NV = 34137;
/*    */   
/*    */   static {
/* 29 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static native void glPrimitiveRestartIndexNV(@NativeType("GLuint") int paramInt);
/*    */ 
/*    */   
/*    */   public static native void glPrimitiveRestartNV();
/*    */ 
/*    */   
/*    */   protected NVPrimitiveRestart() {
/* 41 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVPrimitiveRestart.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */