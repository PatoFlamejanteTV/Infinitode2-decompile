/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ARBComputeShader
/*     */ {
/*     */   public static final int GL_COMPUTE_SHADER = 37305;
/*     */   public static final int GL_MAX_COMPUTE_UNIFORM_BLOCKS = 37307;
/*     */   public static final int GL_MAX_COMPUTE_TEXTURE_IMAGE_UNITS = 37308;
/*     */   public static final int GL_MAX_COMPUTE_IMAGE_UNIFORMS = 37309;
/*     */   public static final int GL_MAX_COMPUTE_SHARED_MEMORY_SIZE = 33378;
/*     */   public static final int GL_MAX_COMPUTE_UNIFORM_COMPONENTS = 33379;
/*     */   public static final int GL_MAX_COMPUTE_ATOMIC_COUNTER_BUFFERS = 33380;
/*     */   public static final int GL_MAX_COMPUTE_ATOMIC_COUNTERS = 33381;
/*     */   public static final int GL_MAX_COMBINED_COMPUTE_UNIFORM_COMPONENTS = 33382;
/*     */   public static final int GL_MAX_COMPUTE_WORK_GROUP_INVOCATIONS = 37099;
/*     */   public static final int GL_MAX_COMPUTE_WORK_GROUP_COUNT = 37310;
/*     */   public static final int GL_MAX_COMPUTE_WORK_GROUP_SIZE = 37311;
/*     */   public static final int GL_COMPUTE_WORK_GROUP_SIZE = 33383;
/*     */   public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_COMPUTE_SHADER = 37100;
/*     */   public static final int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_COMPUTE_SHADER = 37101;
/*     */   public static final int GL_DISPATCH_INDIRECT_BUFFER = 37102;
/*     */   public static final int GL_DISPATCH_INDIRECT_BUFFER_BINDING = 37103;
/*     */   public static final int GL_COMPUTE_SHADER_BIT = 32;
/*     */   
/*     */   static {
/*  37 */     GL.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ARBComputeShader() {
/*  78 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDispatchCompute(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3) {
/*  91 */     GL43C.glDispatchCompute(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDispatchComputeIndirect(@NativeType("GLintptr") long paramLong) {
/* 118 */     GL43C.glDispatchComputeIndirect(paramLong);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBComputeShader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */