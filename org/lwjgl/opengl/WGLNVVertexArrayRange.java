/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.JNI;
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
/*    */ public class WGLNVVertexArrayRange
/*    */ {
/*    */   protected WGLNVVertexArrayRange() {
/* 21 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static long nwglAllocateMemoryNV(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3) {
/* 27 */     long l = (GL.getCapabilitiesWGL()).wglAllocateMemoryNV;
/* 28 */     if (Checks.CHECKS) {
/* 29 */       Checks.check(l);
/*    */     }
/* 31 */     return JNI.callP(paramInt, paramFloat1, paramFloat2, paramFloat3, l);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("void *")
/*    */   public static ByteBuffer wglAllocateMemoryNV(@NativeType("GLsizei") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3) {
/*    */     long l;
/* 38 */     return MemoryUtil.memByteBufferSafe(l = nwglAllocateMemoryNV(paramInt, paramFloat1, paramFloat2, paramFloat3), paramInt);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void nwglFreeMemoryNV(long paramLong) {
/* 44 */     long l = (GL.getCapabilitiesWGL()).wglFreeMemoryNV;
/* 45 */     if (Checks.CHECKS) {
/* 46 */       Checks.check(l);
/*    */     }
/* 48 */     JNI.callPV(paramLong, l);
/*    */   }
/*    */   
/*    */   public static void wglFreeMemoryNV(@NativeType("void *") ByteBuffer paramByteBuffer) {
/* 52 */     nwglFreeMemoryNV(MemoryUtil.memAddress(paramByteBuffer));
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\WGLNVVertexArrayRange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */