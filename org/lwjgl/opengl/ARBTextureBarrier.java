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
/*    */ 
/*    */ 
/*    */ public class ARBTextureBarrier
/*    */ {
/*    */   static {
/* 19 */     GL.initialize();
/*    */   }
/*    */   protected ARBTextureBarrier() {
/* 22 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glTextureBarrier() {
/* 29 */     GL45C.glTextureBarrier();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBTextureBarrier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */