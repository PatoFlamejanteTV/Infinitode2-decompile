/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.JNI;
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
/*    */ public class GLXNVCopyBuffer
/*    */ {
/*    */   protected GLXNVCopyBuffer() {
/* 21 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glXCopyBufferSubDataNV(@NativeType("Display *") long paramLong1, @NativeType("GLXContext") long paramLong2, @NativeType("GLXContext") long paramLong3, @NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong4, @NativeType("GLintptr") long paramLong5, @NativeType("GLsizeiptr") long paramLong6) {
/* 28 */     long l = (GL.getCapabilitiesGLXClient()).glXCopyBufferSubDataNV;
/* 29 */     if (Checks.CHECKS) {
/* 30 */       Checks.check(l);
/* 31 */       Checks.check(paramLong1);
/* 32 */       Checks.check(paramLong2);
/* 33 */       Checks.check(paramLong3);
/*    */     } 
/* 35 */     JNI.callPPPPPPV(paramLong1, paramLong2, paramLong3, paramInt1, paramInt2, paramLong4, paramLong5, paramLong6, l);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glXNamedCopyBufferSubDataNV(@NativeType("Display *") long paramLong1, @NativeType("GLXContext") long paramLong2, @NativeType("GLXContext") long paramLong3, @NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLintptr") long paramLong4, @NativeType("GLintptr") long paramLong5, @NativeType("GLsizeiptr") long paramLong6) {
/* 42 */     long l = (GL.getCapabilitiesGLXClient()).glXNamedCopyBufferSubDataNV;
/* 43 */     if (Checks.CHECKS) {
/* 44 */       Checks.check(l);
/* 45 */       Checks.check(paramLong1);
/* 46 */       Checks.check(paramLong2);
/* 47 */       Checks.check(paramLong3);
/*    */     } 
/* 49 */     JNI.callPPPPPPV(paramLong1, paramLong2, paramLong3, paramInt1, paramInt2, paramLong4, paramLong5, paramLong6, l);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GLXNVCopyBuffer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */