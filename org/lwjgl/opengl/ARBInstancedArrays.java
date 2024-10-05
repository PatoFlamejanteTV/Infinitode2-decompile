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
/*    */ 
/*    */ 
/*    */ public class ARBInstancedArrays
/*    */ {
/*    */   public static final int GL_VERTEX_ATTRIB_ARRAY_DIVISOR_ARB = 35070;
/*    */   
/*    */   static {
/* 32 */     GL.initialize();
/*    */   }
/*    */   
/*    */   public static native void glVertexArrayVertexAttribDivisorEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*    */   
/*    */   protected ARBInstancedArrays() {
/* 38 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */   public static native void glVertexAttribDivisorARB(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBInstancedArrays.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */