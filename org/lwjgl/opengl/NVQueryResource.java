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
/*    */ public class NVQueryResource
/*    */ {
/*    */   public static final int GL_QUERY_RESOURCE_TYPE_VIDMEM_ALLOC_NV = 38208;
/*    */   public static final int GL_QUERY_RESOURCE_MEMTYPE_VIDMEM_NV = 38210;
/*    */   public static final int GL_QUERY_RESOURCE_SYS_RESERVED_NV = 38212;
/*    */   public static final int GL_QUERY_RESOURCE_TEXTURE_NV = 38213;
/*    */   public static final int GL_QUERY_RESOURCE_RENDERBUFFER_NV = 38214;
/*    */   public static final int GL_QUERY_RESOURCE_BUFFEROBJECT_NV = 38215;
/*    */   
/*    */   static {
/* 35 */     GL.initialize();
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
/*    */   protected NVQueryResource() {
/* 49 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("GLint")
/*    */   public static int glQueryResourceNV(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 60 */     return nglQueryResourceNV(paramInt1, paramInt2, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("GLint")
/*    */   public static int glQueryResourceNV(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 66 */     long l = (GL.getICD()).glQueryResourceNV;
/* 67 */     if (Checks.CHECKS) {
/* 68 */       Checks.check(l);
/*    */     }
/* 70 */     return JNI.callPI(paramInt1, paramInt2, paramArrayOfint.length, paramArrayOfint, l);
/*    */   }
/*    */   
/*    */   public static native int nglQueryResourceNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVQueryResource.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */