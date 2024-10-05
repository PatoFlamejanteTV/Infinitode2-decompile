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
/*    */ public class EXTPolygonOffsetClamp
/*    */ {
/*    */   public static final int GL_POLYGON_OFFSET_CLAMP_EXT = 36379;
/*    */   
/*    */   static {
/* 22 */     GL.initialize();
/*    */   }
/*    */   
/*    */   public static native void glPolygonOffsetClampEXT(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*    */   
/*    */   protected EXTPolygonOffsetClamp() {
/* 28 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\EXTPolygonOffsetClamp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */