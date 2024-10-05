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
/*    */ public class NVXConditionalRender
/*    */ {
/*    */   static {
/* 24 */     GL.initialize();
/*    */   }
/*    */   protected NVXConditionalRender() {
/* 27 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */   public static native void glEndConditionalRenderNVX();
/*    */   
/*    */   public static native void glBeginConditionalRenderNVX(@NativeType("GLuint") int paramInt);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVXConditionalRender.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */