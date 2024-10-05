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
/*    */ public class NVConditionalRender
/*    */ {
/*    */   public static final int GL_QUERY_WAIT_NV = 36371;
/*    */   public static final int GL_QUERY_NO_WAIT_NV = 36372;
/*    */   public static final int GL_QUERY_BY_REGION_WAIT_NV = 36373;
/*    */   public static final int GL_QUERY_BY_REGION_NO_WAIT_NV = 36374;
/*    */   
/*    */   static {
/* 30 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   public static native void glEndConditionalRenderNV();
/*    */ 
/*    */   
/*    */   public static native void glBeginConditionalRenderNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*    */   
/*    */   protected NVConditionalRender() {
/* 40 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVConditionalRender.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */