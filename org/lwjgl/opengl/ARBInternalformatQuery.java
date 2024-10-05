/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.IntBuffer;
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
/*    */ public class ARBInternalformatQuery
/*    */ {
/*    */   public static final int GL_NUM_SAMPLE_COUNTS = 37760;
/*    */   
/*    */   static {
/* 25 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected ARBInternalformatQuery() {
/* 31 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void nglGetInternalformativ(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong) {
/* 42 */     GL42C.nglGetInternalformativ(paramInt1, paramInt2, paramInt3, paramInt4, paramLong);
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
/*    */   public static void glGetInternalformativ(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 54 */     GL42C.glGetInternalformativ(paramInt1, paramInt2, paramInt3, paramIntBuffer);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("void")
/*    */   public static int glGetInternalformati(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3) {
/* 66 */     return GL42C.glGetInternalformati(paramInt1, paramInt2, paramInt3);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glGetInternalformativ(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 71 */     GL42C.glGetInternalformativ(paramInt1, paramInt2, paramInt3, paramArrayOfint);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBInternalformatQuery.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */