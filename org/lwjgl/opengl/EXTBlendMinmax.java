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
/*    */ public class EXTBlendMinmax
/*    */ {
/*    */   public static final int GL_FUNC_ADD_EXT = 32774;
/*    */   public static final int GL_MIN_EXT = 32775;
/*    */   public static final int GL_MAX_EXT = 32776;
/*    */   public static final int GL_BLEND_EQUATION_EXT = 32777;
/*    */   
/*    */   static {
/* 23 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static native void glBlendEquationEXT(@NativeType("GLenum") int paramInt);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected EXTBlendMinmax() {
/* 35 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\EXTBlendMinmax.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */