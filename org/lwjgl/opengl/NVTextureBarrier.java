/*    */ package org.lwjgl.opengl;
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
/*    */ public class NVTextureBarrier
/*    */ {
/*    */   static {
/* 17 */     GL.initialize();
/*    */   }
/*    */   protected NVTextureBarrier() {
/* 20 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */   public static native void glTextureBarrierNV();
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVTextureBarrier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */