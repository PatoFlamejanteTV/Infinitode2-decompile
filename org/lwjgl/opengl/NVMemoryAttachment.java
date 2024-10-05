/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.IntBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.JNI;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NVMemoryAttachment
/*    */ {
/*    */   public static final int GL_ATTACHED_MEMORY_OBJECT_NV = 38308;
/*    */   public static final int GL_ATTACHED_MEMORY_OFFSET_NV = 38309;
/*    */   public static final int GL_MEMORY_ATTACHABLE_ALIGNMENT_NV = 38310;
/*    */   public static final int GL_MEMORY_ATTACHABLE_SIZE_NV = 38311;
/*    */   public static final int GL_MEMORY_ATTACHABLE_NV = 38312;
/*    */   public static final int GL_DETACHED_MEMORY_INCARNATION_NV = 38313;
/*    */   public static final int GL_DETACHED_TEXTURES_NV = 38314;
/*    */   public static final int GL_DETACHED_BUFFERS_NV = 38315;
/*    */   public static final int GL_MAX_DETACHED_TEXTURES_NV = 38316;
/*    */   public static final int GL_MAX_DETACHED_BUFFERS_NV = 38317;
/*    */   
/*    */   static {
/* 27 */     GL.initialize();
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
/*    */   protected NVMemoryAttachment() {
/* 59 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glGetMemoryObjectDetachedResourcesuivNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 67 */     nglGetMemoryObjectDetachedResourcesuivNV(paramInt1, paramInt2, paramInt3, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
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
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glGetMemoryObjectDetachedResourcesuivNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 92 */     long l = (GL.getICD()).glGetMemoryObjectDetachedResourcesuivNV;
/* 93 */     if (Checks.CHECKS) {
/* 94 */       Checks.check(l);
/*    */     }
/* 96 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint.length, paramArrayOfint, l);
/*    */   }
/*    */   
/*    */   public static native void nglGetMemoryObjectDetachedResourcesuivNV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*    */   
/*    */   public static native void glResetMemoryObjectParameterNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*    */   
/*    */   public static native void glTexAttachMemoryNV(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint64") long paramLong);
/*    */   
/*    */   public static native void glBufferAttachMemoryNV(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint64") long paramLong);
/*    */   
/*    */   public static native void glTextureAttachMemoryNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint64") long paramLong);
/*    */   
/*    */   public static native void glNamedBufferAttachMemoryNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint64") long paramLong);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVMemoryAttachment.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */