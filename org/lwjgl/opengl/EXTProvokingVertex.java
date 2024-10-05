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
/*    */ public class EXTProvokingVertex
/*    */ {
/*    */   public static final int GL_FIRST_VERTEX_CONVENTION_EXT = 36429;
/*    */   public static final int GL_LAST_VERTEX_CONVENTION_EXT = 36430;
/*    */   public static final int GL_PROVOKING_VERTEX_EXT = 36431;
/*    */   public static final int GL_QUADS_FOLLOW_PROVOKING_VERTEX_CONVENTION_EXT = 36428;
/*    */   
/*    */   static {
/* 33 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static native void glProvokingVertexEXT(@NativeType("GLenum") int paramInt);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected EXTProvokingVertex() {
/* 46 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\EXTProvokingVertex.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */