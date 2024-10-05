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
/*    */ public class ARBProvokingVertex
/*    */ {
/*    */   public static final int GL_FIRST_VERTEX_CONVENTION = 36429;
/*    */   public static final int GL_LAST_VERTEX_CONVENTION = 36430;
/*    */   public static final int GL_PROVOKING_VERTEX = 36431;
/*    */   public static final int GL_QUADS_FOLLOW_PROVOKING_VERTEX_CONVENTION = 36428;
/*    */   
/*    */   static {
/* 33 */     GL.initialize();
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
/*    */   protected ARBProvokingVertex() {
/* 46 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glProvokingVertex(@NativeType("GLenum") int paramInt) {
/* 57 */     GL32C.glProvokingVertex(paramInt);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBProvokingVertex.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */