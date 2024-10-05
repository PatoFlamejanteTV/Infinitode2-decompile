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
/*    */ 
/*    */ 
/*    */ public class ARBColorBufferFloat
/*    */ {
/*    */   public static final int GL_RGBA_FLOAT_MODE_ARB = 34848;
/*    */   public static final int GL_CLAMP_VERTEX_COLOR_ARB = 35098;
/*    */   public static final int GL_CLAMP_FRAGMENT_COLOR_ARB = 35099;
/*    */   public static final int GL_CLAMP_READ_COLOR_ARB = 35100;
/*    */   public static final int GL_FIXED_ONLY_ARB = 35101;
/*    */   
/*    */   static {
/* 34 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static native void glClampColorARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected ARBColorBufferFloat() {
/* 49 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBColorBufferFloat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */