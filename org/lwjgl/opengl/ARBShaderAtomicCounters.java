/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ARBShaderAtomicCounters
/*     */ {
/*     */   public static final int GL_ATOMIC_COUNTER_BUFFER = 37568;
/*     */   public static final int GL_ATOMIC_COUNTER_BUFFER_BINDING = 37569;
/*     */   public static final int GL_ATOMIC_COUNTER_BUFFER_START = 37570;
/*     */   public static final int GL_ATOMIC_COUNTER_BUFFER_SIZE = 37571;
/*     */   public static final int GL_ATOMIC_COUNTER_BUFFER_DATA_SIZE = 37572;
/*     */   public static final int GL_ATOMIC_COUNTER_BUFFER_ACTIVE_ATOMIC_COUNTERS = 37573;
/*     */   public static final int GL_ATOMIC_COUNTER_BUFFER_ACTIVE_ATOMIC_COUNTER_INDICES = 37574;
/*     */   public static final int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_VERTEX_SHADER = 37575;
/*     */   public static final int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_TESS_CONTROL_SHADER = 37576;
/*     */   public static final int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_TESS_EVALUATION_SHADER = 37577;
/*     */   public static final int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_GEOMETRY_SHADER = 37578;
/*     */   public static final int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_FRAGMENT_SHADER = 37579;
/*     */   public static final int GL_MAX_VERTEX_ATOMIC_COUNTER_BUFFERS = 37580;
/*     */   public static final int GL_MAX_TESS_CONTROL_ATOMIC_COUNTER_BUFFERS = 37581;
/*     */   public static final int GL_MAX_TESS_EVALUATION_ATOMIC_COUNTER_BUFFERS = 37582;
/*     */   public static final int GL_MAX_GEOMETRY_ATOMIC_COUNTER_BUFFERS = 37583;
/*     */   public static final int GL_MAX_FRAGMENT_ATOMIC_COUNTER_BUFFERS = 37584;
/*     */   public static final int GL_MAX_COMBINED_ATOMIC_COUNTER_BUFFERS = 37585;
/*     */   public static final int GL_MAX_VERTEX_ATOMIC_COUNTERS = 37586;
/*     */   public static final int GL_MAX_TESS_CONTROL_ATOMIC_COUNTERS = 37587;
/*     */   public static final int GL_MAX_TESS_EVALUATION_ATOMIC_COUNTERS = 37588;
/*     */   public static final int GL_MAX_GEOMETRY_ATOMIC_COUNTERS = 37589;
/*     */   public static final int GL_MAX_FRAGMENT_ATOMIC_COUNTERS = 37590;
/*     */   public static final int GL_MAX_COMBINED_ATOMIC_COUNTERS = 37591;
/*     */   public static final int GL_MAX_ATOMIC_COUNTER_BUFFER_SIZE = 37592;
/*     */   public static final int GL_MAX_ATOMIC_COUNTER_BUFFER_BINDINGS = 37596;
/*     */   public static final int GL_ACTIVE_ATOMIC_COUNTER_BUFFERS = 37593;
/*     */   public static final int GL_UNIFORM_ATOMIC_COUNTER_BUFFER_INDEX = 37594;
/*     */   public static final int GL_UNSIGNED_INT_ATOMIC_COUNTER = 37595;
/*     */   
/*     */   static {
/*  43 */     GL.initialize();
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
/*     */   protected ARBShaderAtomicCounters() {
/*  97 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetActiveAtomicCounterBufferiv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 104 */     GL42C.nglGetActiveAtomicCounterBufferiv(paramInt1, paramInt2, paramInt3, paramLong);
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
/*     */   public static void glGetActiveAtomicCounterBufferiv(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 116 */     GL42C.glGetActiveAtomicCounterBufferiv(paramInt1, paramInt2, paramInt3, paramIntBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetActiveAtomicCounterBufferi(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3) {
/* 128 */     return GL42C.glGetActiveAtomicCounterBufferi(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetActiveAtomicCounterBufferiv(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 133 */     GL42C.glGetActiveAtomicCounterBufferiv(paramInt1, paramInt2, paramInt3, paramArrayOfint);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBShaderAtomicCounters.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */