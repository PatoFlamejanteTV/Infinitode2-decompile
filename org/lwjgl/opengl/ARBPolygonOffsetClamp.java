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
/*    */ public class ARBPolygonOffsetClamp
/*    */ {
/*    */   public static final int GL_POLYGON_OFFSET_CLAMP = 36379;
/*    */   
/*    */   static {
/* 22 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected ARBPolygonOffsetClamp() {
/* 28 */     throw new UnsupportedOperationException();
/*    */   }
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
/*    */   public static void glPolygonOffsetClamp(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3) {
/* 49 */     GL46C.glPolygonOffsetClamp(paramFloat1, paramFloat2, paramFloat3);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBPolygonOffsetClamp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */