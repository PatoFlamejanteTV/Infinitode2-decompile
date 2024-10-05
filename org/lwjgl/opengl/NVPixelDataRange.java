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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NVPixelDataRange
/*    */ {
/*    */   public static final int GL_WRITE_PIXEL_DATA_RANGE_NV = 34936;
/*    */   public static final int GL_READ_PIXEL_DATA_RANGE_NV = 34937;
/*    */   public static final int GL_WRITE_PIXEL_DATA_RANGE_LENGTH_NV = 34938;
/*    */   public static final int GL_READ_PIXEL_DATA_RANGE_LENGTH_NV = 34939;
/*    */   public static final int GL_WRITE_PIXEL_DATA_RANGE_POINTER_NV = 34940;
/*    */   public static final int GL_READ_PIXEL_DATA_RANGE_POINTER_NV = 34941;
/*    */   
/*    */   static {
/* 51 */     GL.initialize();
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
/*    */   protected NVPixelDataRange() {
/* 72 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glPixelDataRangeNV(@NativeType("GLenum") int paramInt, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 80 */     nglPixelDataRangeNV(paramInt, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*    */   }
/*    */   
/*    */   public static native void nglPixelDataRangeNV(int paramInt1, int paramInt2, long paramLong);
/*    */   
/*    */   public static native void glFlushPixelDataRangeNV(@NativeType("GLenum") int paramInt);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVPixelDataRange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */