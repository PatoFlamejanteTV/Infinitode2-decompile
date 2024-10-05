/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NVVertexArrayRange
/*    */ {
/*    */   public static final int GL_VERTEX_ARRAY_RANGE_NV = 34077;
/*    */   public static final int GL_VERTEX_ARRAY_RANGE_LENGTH_NV = 34078;
/*    */   public static final int GL_VERTEX_ARRAY_RANGE_VALID_NV = 34079;
/*    */   public static final int GL_MAX_VERTEX_ARRAY_RANGE_ELEMENT_NV = 34080;
/*    */   public static final int GL_VERTEX_ARRAY_RANGE_POINTER_NV = 34081;
/*    */   
/*    */   static {
/* 22 */     GL.initialize();
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
/*    */   protected NVVertexArrayRange() {
/* 37 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glVertexArrayRangeNV(@NativeType("void *") ByteBuffer paramByteBuffer) {
/* 45 */     nglVertexArrayRangeNV(paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*    */   }
/*    */   
/*    */   public static native void nglVertexArrayRangeNV(int paramInt, long paramLong);
/*    */   
/*    */   public static native void glFlushVertexArrayRangeNV();
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVVertexArrayRange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */