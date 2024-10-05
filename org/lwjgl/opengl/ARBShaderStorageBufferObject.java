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
/*    */ public class ARBShaderStorageBufferObject
/*    */ {
/*    */   public static final int GL_SHADER_STORAGE_BUFFER = 37074;
/*    */   public static final int GL_SHADER_STORAGE_BUFFER_BINDING = 37075;
/*    */   public static final int GL_SHADER_STORAGE_BUFFER_START = 37076;
/*    */   public static final int GL_SHADER_STORAGE_BUFFER_SIZE = 37077;
/*    */   public static final int GL_MAX_VERTEX_SHADER_STORAGE_BLOCKS = 37078;
/*    */   public static final int GL_MAX_GEOMETRY_SHADER_STORAGE_BLOCKS = 37079;
/*    */   public static final int GL_MAX_TESS_CONTROL_SHADER_STORAGE_BLOCKS = 37080;
/*    */   public static final int GL_MAX_TESS_EVALUATION_SHADER_STORAGE_BLOCKS = 37081;
/*    */   public static final int GL_MAX_FRAGMENT_SHADER_STORAGE_BLOCKS = 37082;
/*    */   public static final int GL_MAX_COMPUTE_SHADER_STORAGE_BLOCKS = 37083;
/*    */   public static final int GL_MAX_COMBINED_SHADER_STORAGE_BLOCKS = 37084;
/*    */   public static final int GL_MAX_SHADER_STORAGE_BUFFER_BINDINGS = 37085;
/*    */   public static final int GL_MAX_SHADER_STORAGE_BLOCK_SIZE = 37086;
/*    */   public static final int GL_SHADER_STORAGE_BUFFER_OFFSET_ALIGNMENT = 37087;
/*    */   public static final int GL_SHADER_STORAGE_BARRIER_BIT = 8192;
/*    */   public static final int GL_MAX_COMBINED_SHADER_OUTPUT_RESOURCES = 36665;
/*    */   
/*    */   static {
/* 36 */     GL.initialize();
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
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected ARBShaderStorageBufferObject() {
/* 72 */     throw new UnsupportedOperationException();
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
/*    */   public static void glShaderStorageBlockBinding(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3) {
/* 85 */     GL43C.glShaderStorageBlockBinding(paramInt1, paramInt2, paramInt3);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBShaderStorageBufferObject.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */