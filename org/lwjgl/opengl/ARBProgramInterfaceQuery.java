/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ARBProgramInterfaceQuery
/*     */ {
/*     */   public static final int GL_UNIFORM = 37601;
/*     */   public static final int GL_UNIFORM_BLOCK = 37602;
/*     */   public static final int GL_PROGRAM_INPUT = 37603;
/*     */   public static final int GL_PROGRAM_OUTPUT = 37604;
/*     */   public static final int GL_BUFFER_VARIABLE = 37605;
/*     */   public static final int GL_SHADER_STORAGE_BLOCK = 37606;
/*     */   public static final int GL_VERTEX_SUBROUTINE = 37608;
/*     */   public static final int GL_TESS_CONTROL_SUBROUTINE = 37609;
/*     */   public static final int GL_TESS_EVALUATION_SUBROUTINE = 37610;
/*     */   public static final int GL_GEOMETRY_SUBROUTINE = 37611;
/*     */   public static final int GL_FRAGMENT_SUBROUTINE = 37612;
/*     */   public static final int GL_COMPUTE_SUBROUTINE = 37613;
/*     */   public static final int GL_VERTEX_SUBROUTINE_UNIFORM = 37614;
/*     */   public static final int GL_TESS_CONTROL_SUBROUTINE_UNIFORM = 37615;
/*     */   public static final int GL_TESS_EVALUATION_SUBROUTINE_UNIFORM = 37616;
/*     */   public static final int GL_GEOMETRY_SUBROUTINE_UNIFORM = 37617;
/*     */   public static final int GL_FRAGMENT_SUBROUTINE_UNIFORM = 37618;
/*     */   public static final int GL_COMPUTE_SUBROUTINE_UNIFORM = 37619;
/*     */   public static final int GL_TRANSFORM_FEEDBACK_VARYING = 37620;
/*     */   public static final int GL_ACTIVE_RESOURCES = 37621;
/*     */   public static final int GL_MAX_NAME_LENGTH = 37622;
/*     */   public static final int GL_MAX_NUM_ACTIVE_VARIABLES = 37623;
/*     */   public static final int GL_MAX_NUM_COMPATIBLE_SUBROUTINES = 37624;
/*     */   
/*     */   static {
/*  40 */     GL.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_NAME_LENGTH = 37625;
/*     */ 
/*     */   
/*     */   public static final int GL_TYPE = 37626;
/*     */ 
/*     */   
/*     */   public static final int GL_ARRAY_SIZE = 37627;
/*     */ 
/*     */   
/*     */   public static final int GL_OFFSET = 37628;
/*     */ 
/*     */   
/*     */   public static final int GL_BLOCK_INDEX = 37629;
/*     */ 
/*     */   
/*     */   public static final int GL_ARRAY_STRIDE = 37630;
/*     */ 
/*     */   
/*     */   public static final int GL_MATRIX_STRIDE = 37631;
/*     */ 
/*     */   
/*     */   public static final int GL_IS_ROW_MAJOR = 37632;
/*     */   
/*     */   public static final int GL_ATOMIC_COUNTER_BUFFER_INDEX = 37633;
/*     */   
/*     */   public static final int GL_BUFFER_BINDING = 37634;
/*     */   
/*     */   public static final int GL_BUFFER_DATA_SIZE = 37635;
/*     */   
/*     */   public static final int GL_NUM_ACTIVE_VARIABLES = 37636;
/*     */   
/*     */   public static final int GL_ACTIVE_VARIABLES = 37637;
/*     */   
/*     */   public static final int GL_REFERENCED_BY_VERTEX_SHADER = 37638;
/*     */   
/*     */   public static final int GL_REFERENCED_BY_TESS_CONTROL_SHADER = 37639;
/*     */   
/*     */   public static final int GL_REFERENCED_BY_TESS_EVALUATION_SHADER = 37640;
/*     */   
/*     */   public static final int GL_REFERENCED_BY_GEOMETRY_SHADER = 37641;
/*     */   
/*     */   public static final int GL_REFERENCED_BY_FRAGMENT_SHADER = 37642;
/*     */   
/*     */   public static final int GL_REFERENCED_BY_COMPUTE_SHADER = 37643;
/*     */   
/*     */   public static final int GL_TOP_LEVEL_ARRAY_SIZE = 37644;
/*     */   
/*     */   public static final int GL_TOP_LEVEL_ARRAY_STRIDE = 37645;
/*     */   
/*     */   public static final int GL_LOCATION = 37646;
/*     */   
/*     */   public static final int GL_LOCATION_INDEX = 37647;
/*     */   
/*     */   public static final int GL_IS_PER_PATCH = 37607;
/*     */ 
/*     */   
/*     */   protected ARBProgramInterfaceQuery() {
/* 102 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetProgramInterfaceiv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 109 */     GL43C.nglGetProgramInterfaceiv(paramInt1, paramInt2, paramInt3, paramLong);
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
/*     */   public static void glGetProgramInterfaceiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 121 */     GL43C.glGetProgramInterfaceiv(paramInt1, paramInt2, paramInt3, paramIntBuffer);
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
/*     */   public static int glGetProgramInterfacei(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3) {
/* 133 */     return GL43C.glGetProgramInterfacei(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglGetProgramResourceIndex(int paramInt1, int paramInt2, long paramLong) {
/* 140 */     return GL43C.nglGetProgramResourceIndex(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLuint")
/*     */   public static int glGetProgramResourceIndex(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/* 152 */     return GL43C.glGetProgramResourceIndex(paramInt1, paramInt2, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLuint")
/*     */   public static int glGetProgramResourceIndex(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/* 164 */     return GL43C.glGetProgramResourceIndex(paramInt1, paramInt2, paramCharSequence);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetProgramResourceName(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2) {
/* 175 */     GL43C.nglGetProgramResourceName(paramInt1, paramInt2, paramInt3, paramInt4, paramLong1, paramLong2);
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
/*     */   public static void glGetProgramResourceName(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLsizei *") IntBuffer paramIntBuffer, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 188 */     GL43C.glGetProgramResourceName(paramInt1, paramInt2, paramInt3, paramIntBuffer, paramByteBuffer);
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
/*     */   @NativeType("void")
/*     */   public static String glGetProgramResourceName(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLsizei") int paramInt4) {
/* 201 */     return GL43C.glGetProgramResourceName(paramInt1, paramInt2, paramInt3, paramInt4);
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
/*     */   public static String glGetProgramResourceName(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3) {
/* 213 */     return glGetProgramResourceName(paramInt1, paramInt2, paramInt3, glGetProgramInterfacei(paramInt1, paramInt2, 37622));
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
/*     */   public static void nglGetProgramResourceiv(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, int paramInt5, long paramLong2, long paramLong3) {
/* 225 */     GL43C.nglGetProgramResourceiv(paramInt1, paramInt2, paramInt3, paramInt4, paramLong1, paramInt5, paramLong2, paramLong3);
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
/*     */   public static void glGetProgramResourceiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLenum const *") IntBuffer paramIntBuffer1, @NativeType("GLsizei *") IntBuffer paramIntBuffer2, @NativeType("GLint *") IntBuffer paramIntBuffer3) {
/* 239 */     GL43C.glGetProgramResourceiv(paramInt1, paramInt2, paramInt3, paramIntBuffer1, paramIntBuffer2, paramIntBuffer3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglGetProgramResourceLocation(int paramInt1, int paramInt2, long paramLong) {
/* 246 */     return GL43C.nglGetProgramResourceLocation(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLint")
/*     */   public static int glGetProgramResourceLocation(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/* 258 */     return GL43C.glGetProgramResourceLocation(paramInt1, paramInt2, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLint")
/*     */   public static int glGetProgramResourceLocation(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/* 270 */     return GL43C.glGetProgramResourceLocation(paramInt1, paramInt2, paramCharSequence);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglGetProgramResourceLocationIndex(int paramInt1, int paramInt2, long paramLong) {
/* 277 */     return GL43C.nglGetProgramResourceLocationIndex(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLint")
/*     */   public static int glGetProgramResourceLocationIndex(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/* 289 */     return GL43C.glGetProgramResourceLocationIndex(paramInt1, paramInt2, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLint")
/*     */   public static int glGetProgramResourceLocationIndex(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/* 301 */     return GL43C.glGetProgramResourceLocationIndex(paramInt1, paramInt2, paramCharSequence);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetProgramInterfaceiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 306 */     GL43C.glGetProgramInterfaceiv(paramInt1, paramInt2, paramInt3, paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetProgramResourceName(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLsizei *") int[] paramArrayOfint, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 311 */     GL43C.glGetProgramResourceName(paramInt1, paramInt2, paramInt3, paramArrayOfint, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetProgramResourceiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLenum const *") int[] paramArrayOfint1, @NativeType("GLsizei *") int[] paramArrayOfint2, @NativeType("GLint *") int[] paramArrayOfint3) {
/* 316 */     GL43C.glGetProgramResourceiv(paramInt1, paramInt2, paramInt3, paramArrayOfint1, paramArrayOfint2, paramArrayOfint3);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBProgramInterfaceQuery.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */