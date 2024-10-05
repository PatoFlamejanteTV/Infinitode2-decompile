/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ import org.lwjgl.system.APIUtil;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.CustomBuffer;
/*      */ import org.lwjgl.system.JNI;
/*      */ import org.lwjgl.system.MemoryStack;
/*      */ import org.lwjgl.system.MemoryUtil;
/*      */ import org.lwjgl.system.NativeType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ARBShaderObjects
/*      */ {
/*      */   public static final int GL_PROGRAM_OBJECT_ARB = 35648;
/*      */   public static final int GL_OBJECT_TYPE_ARB = 35662;
/*      */   public static final int GL_OBJECT_SUBTYPE_ARB = 35663;
/*      */   public static final int GL_OBJECT_DELETE_STATUS_ARB = 35712;
/*      */   public static final int GL_OBJECT_COMPILE_STATUS_ARB = 35713;
/*      */   public static final int GL_OBJECT_LINK_STATUS_ARB = 35714;
/*      */   public static final int GL_OBJECT_VALIDATE_STATUS_ARB = 35715;
/*      */   public static final int GL_OBJECT_INFO_LOG_LENGTH_ARB = 35716;
/*      */   public static final int GL_OBJECT_ATTACHED_OBJECTS_ARB = 35717;
/*      */   public static final int GL_OBJECT_ACTIVE_UNIFORMS_ARB = 35718;
/*      */   public static final int GL_OBJECT_ACTIVE_UNIFORM_MAX_LENGTH_ARB = 35719;
/*      */   public static final int GL_OBJECT_SHADER_SOURCE_LENGTH_ARB = 35720;
/*      */   public static final int GL_SHADER_OBJECT_ARB = 35656;
/*      */   public static final int GL_FLOAT_VEC2_ARB = 35664;
/*      */   public static final int GL_FLOAT_VEC3_ARB = 35665;
/*      */   public static final int GL_FLOAT_VEC4_ARB = 35666;
/*      */   public static final int GL_INT_VEC2_ARB = 35667;
/*      */   
/*      */   static {
/*   45 */     GL.initialize();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_INT_VEC3_ARB = 35668;
/*      */ 
/*      */   
/*      */   public static final int GL_INT_VEC4_ARB = 35669;
/*      */ 
/*      */   
/*      */   public static final int GL_BOOL_ARB = 35670;
/*      */ 
/*      */   
/*      */   public static final int GL_BOOL_VEC2_ARB = 35671;
/*      */ 
/*      */   
/*      */   public static final int GL_BOOL_VEC3_ARB = 35672;
/*      */ 
/*      */   
/*      */   public static final int GL_BOOL_VEC4_ARB = 35673;
/*      */ 
/*      */   
/*      */   public static final int GL_FLOAT_MAT2_ARB = 35674;
/*      */   
/*      */   public static final int GL_FLOAT_MAT3_ARB = 35675;
/*      */   
/*      */   public static final int GL_FLOAT_MAT4_ARB = 35676;
/*      */   
/*      */   public static final int GL_SAMPLER_1D_ARB = 35677;
/*      */   
/*      */   public static final int GL_SAMPLER_2D_ARB = 35678;
/*      */   
/*      */   public static final int GL_SAMPLER_3D_ARB = 35679;
/*      */   
/*      */   public static final int GL_SAMPLER_CUBE_ARB = 35680;
/*      */   
/*      */   public static final int GL_SAMPLER_1D_SHADOW_ARB = 35681;
/*      */   
/*      */   public static final int GL_SAMPLER_2D_SHADOW_ARB = 35682;
/*      */   
/*      */   public static final int GL_SAMPLER_2D_RECT_ARB = 35683;
/*      */   
/*      */   public static final int GL_SAMPLER_2D_RECT_SHADOW_ARB = 35684;
/*      */ 
/*      */   
/*      */   protected ARBShaderObjects() {
/*   92 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glShaderSourceARB(@NativeType("GLhandleARB") int paramInt, @NativeType("GLcharARB const **") PointerBuffer paramPointerBuffer, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  167 */     if (Checks.CHECKS) {
/*  168 */       Checks.checkSafe(paramIntBuffer, paramPointerBuffer.remaining());
/*      */     }
/*  170 */     nglShaderSourceARB(paramInt, paramPointerBuffer.remaining(), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), MemoryUtil.memAddressSafe(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glShaderSourceARB(@NativeType("GLhandleARB") int paramInt, @NativeType("GLcharARB const **") CharSequence... paramVarArgs) {
/*      */     MemoryStack memoryStack;
/*  184 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  186 */       long l = APIUtil.apiArrayi(memoryStack, MemoryUtil::memUTF8, paramVarArgs);
/*  187 */       nglShaderSourceARB(paramInt, paramVarArgs.length, l, l - (paramVarArgs.length << 2));
/*  188 */       APIUtil.apiArrayFree(l, paramVarArgs.length); return;
/*      */     } finally {
/*  190 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glShaderSourceARB(@NativeType("GLhandleARB") int paramInt, @NativeType("GLcharARB const **") CharSequence paramCharSequence) {
/*      */     MemoryStack memoryStack;
/*  205 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  207 */       long l = APIUtil.apiArrayi(memoryStack, MemoryUtil::memUTF8, new CharSequence[] { paramCharSequence });
/*  208 */       nglShaderSourceARB(paramInt, 1, l, l - 4L);
/*  209 */       APIUtil.apiArrayFree(l, 1); return;
/*      */     } finally {
/*  211 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform1fvARB(@NativeType("GLint") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  424 */     nglUniform1fvARB(paramInt, paramFloatBuffer.remaining(), MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform2fvARB(@NativeType("GLint") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  443 */     nglUniform2fvARB(paramInt, paramFloatBuffer.remaining() >> 1, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform3fvARB(@NativeType("GLint") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  462 */     nglUniform3fvARB(paramInt, paramFloatBuffer.remaining() / 3, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform4fvARB(@NativeType("GLint") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  481 */     nglUniform4fvARB(paramInt, paramFloatBuffer.remaining() >> 2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform1ivARB(@NativeType("GLint") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  500 */     nglUniform1ivARB(paramInt, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform2ivARB(@NativeType("GLint") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  519 */     nglUniform2ivARB(paramInt, paramIntBuffer.remaining() >> 1, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform3ivARB(@NativeType("GLint") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  538 */     nglUniform3ivARB(paramInt, paramIntBuffer.remaining() / 3, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform4ivARB(@NativeType("GLint") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  557 */     nglUniform4ivARB(paramInt, paramIntBuffer.remaining() >> 2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix2fvARB(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  577 */     nglUniformMatrix2fvARB(paramInt, paramFloatBuffer.remaining() >> 2, paramBoolean, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix3fvARB(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  597 */     nglUniformMatrix3fvARB(paramInt, paramFloatBuffer.remaining() / 9, paramBoolean, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix4fvARB(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  617 */     nglUniformMatrix4fvARB(paramInt, paramFloatBuffer.remaining() >> 4, paramBoolean, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetObjectParameterfvARB(@NativeType("GLhandleARB") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/*  633 */     if (Checks.CHECKS) {
/*  634 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/*  636 */     nglGetObjectParameterfvARB(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetObjectParameterivARB(@NativeType("GLhandleARB") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  652 */     if (Checks.CHECKS) {
/*  653 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  655 */     nglGetObjectParameterivARB(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetObjectParameteriARB(@NativeType("GLhandleARB") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/*  666 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  668 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  669 */       nglGetObjectParameterivARB(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/*  670 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/*  672 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetInfoLogARB(@NativeType("GLhandleARB") int paramInt, @NativeType("GLsizei *") IntBuffer paramIntBuffer, @NativeType("GLcharARB *") ByteBuffer paramByteBuffer) {
/*  705 */     if (Checks.CHECKS) {
/*  706 */       Checks.checkSafe(paramIntBuffer, 1);
/*      */     }
/*  708 */     nglGetInfoLogARB(paramInt, paramByteBuffer.remaining(), MemoryUtil.memAddressSafe(paramIntBuffer), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetInfoLogARB(@NativeType("GLhandleARB") int paramInt1, @NativeType("GLsizei") int paramInt2) {
/*      */     MemoryStack memoryStack;
/*  730 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*  731 */     ByteBuffer byteBuffer = MemoryUtil.memAlloc(paramInt2);
/*      */     try {
/*  733 */       IntBuffer intBuffer = memoryStack.ints(0);
/*  734 */       nglGetInfoLogARB(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(byteBuffer));
/*  735 */       return MemoryUtil.memUTF8(byteBuffer, intBuffer.get(0));
/*      */     } finally {
/*  737 */       MemoryUtil.memFree(byteBuffer);
/*  738 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetInfoLogARB(@NativeType("GLhandleARB") int paramInt) {
/*  760 */     return glGetInfoLogARB(paramInt, glGetObjectParameteriARB(paramInt, 35716));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetAttachedObjectsARB(@NativeType("GLhandleARB") int paramInt, @NativeType("GLsizei *") IntBuffer paramIntBuffer1, @NativeType("GLhandleARB *") IntBuffer paramIntBuffer2) {
/*  782 */     if (Checks.CHECKS) {
/*  783 */       Checks.checkSafe(paramIntBuffer1, 1);
/*      */     }
/*  785 */     nglGetAttachedObjectsARB(paramInt, paramIntBuffer2.remaining(), MemoryUtil.memAddressSafe(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLint")
/*      */   public static int glGetUniformLocationARB(@NativeType("GLhandleARB") int paramInt, @NativeType("GLcharARB const *") ByteBuffer paramByteBuffer) {
/*  811 */     if (Checks.CHECKS) {
/*  812 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/*  814 */     return nglGetUniformLocationARB(paramInt, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLint")
/*      */   public static int glGetUniformLocationARB(@NativeType("GLhandleARB") int paramInt, @NativeType("GLcharARB const *") CharSequence paramCharSequence) {
/*      */     MemoryStack memoryStack;
/*  835 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  837 */       memoryStack.nUTF8(paramCharSequence, true);
/*  838 */       long l = memoryStack.getPointerAddress();
/*  839 */       paramInt = nglGetUniformLocationARB(paramInt, l); return paramInt;
/*      */     } finally {
/*  841 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetActiveUniformARB(@NativeType("GLhandleARB") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") IntBuffer paramIntBuffer1, @NativeType("GLint *") IntBuffer paramIntBuffer2, @NativeType("GLenum *") IntBuffer paramIntBuffer3, @NativeType("GLcharARB *") ByteBuffer paramByteBuffer) {
/*  887 */     if (Checks.CHECKS) {
/*  888 */       Checks.checkSafe(paramIntBuffer1, 1);
/*  889 */       Checks.check(paramIntBuffer2, 1);
/*  890 */       Checks.check(paramIntBuffer3, 1);
/*      */     } 
/*  892 */     nglGetActiveUniformARB(paramInt1, paramInt2, paramByteBuffer.remaining(), MemoryUtil.memAddressSafe(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramIntBuffer3), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetActiveUniformARB(@NativeType("GLhandleARB") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer1, @NativeType("GLenum *") IntBuffer paramIntBuffer2) {
/*  927 */     if (Checks.CHECKS) {
/*  928 */       Checks.check(paramIntBuffer1, 1);
/*  929 */       Checks.check(paramIntBuffer2, 1);
/*      */     }  MemoryStack memoryStack;
/*  931 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  933 */       IntBuffer intBuffer = memoryStack.ints(0);
/*  934 */       ByteBuffer byteBuffer = memoryStack.malloc(paramInt3);
/*  935 */       nglGetActiveUniformARB(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(byteBuffer));
/*  936 */       return MemoryUtil.memUTF8(byteBuffer, intBuffer.get(0));
/*      */     } finally {
/*  938 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetActiveUniformARB(@NativeType("GLhandleARB") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer1, @NativeType("GLenum *") IntBuffer paramIntBuffer2) {
/*  973 */     return glGetActiveUniformARB(paramInt1, paramInt2, glGetObjectParameteriARB(paramInt1, 35719), paramIntBuffer1, paramIntBuffer2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetUniformfvARB(@NativeType("GLhandleARB") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/*  989 */     if (Checks.CHECKS) {
/*  990 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/*  992 */     nglGetUniformfvARB(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetUniformfARB(@NativeType("GLhandleARB") int paramInt1, @NativeType("GLint") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1003 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1005 */       FloatBuffer floatBuffer = memoryStack.callocFloat(1);
/* 1006 */       nglGetUniformfvARB(paramInt1, paramInt2, MemoryUtil.memAddress(floatBuffer));
/* 1007 */       return floatBuffer.get(0);
/*      */     } finally {
/* 1009 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetUniformivARB(@NativeType("GLhandleARB") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 1026 */     if (Checks.CHECKS) {
/* 1027 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1029 */     nglGetUniformivARB(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetUniformiARB(@NativeType("GLhandleARB") int paramInt1, @NativeType("GLint") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1040 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1042 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1043 */       nglGetUniformivARB(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 1044 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 1046 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetShaderSourceARB(@NativeType("GLhandleARB") int paramInt, @NativeType("GLsizei *") IntBuffer paramIntBuffer, @NativeType("GLcharARB *") ByteBuffer paramByteBuffer) {
/* 1072 */     if (Checks.CHECKS) {
/* 1073 */       Checks.checkSafe(paramIntBuffer, 1);
/*      */     }
/* 1075 */     nglGetShaderSourceARB(paramInt, paramByteBuffer.remaining(), MemoryUtil.memAddressSafe(paramIntBuffer), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetShaderSourceARB(@NativeType("GLhandleARB") int paramInt1, @NativeType("GLsizei") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1090 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/* 1091 */     ByteBuffer byteBuffer = MemoryUtil.memAlloc(paramInt2);
/*      */     try {
/* 1093 */       IntBuffer intBuffer = memoryStack.ints(0);
/* 1094 */       nglGetShaderSourceARB(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(byteBuffer));
/* 1095 */       return MemoryUtil.memUTF8(byteBuffer, intBuffer.get(0));
/*      */     } finally {
/* 1097 */       MemoryUtil.memFree(byteBuffer);
/* 1098 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetShaderSourceARB(@NativeType("GLhandleARB") int paramInt) {
/* 1113 */     return glGetShaderSourceARB(paramInt, glGetObjectParameteriARB(paramInt, 35720));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glShaderSourceARB(@NativeType("GLhandleARB") int paramInt, @NativeType("GLcharARB const **") PointerBuffer paramPointerBuffer, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 1118 */     long l = (GL.getICD()).glShaderSourceARB;
/* 1119 */     if (Checks.CHECKS) {
/* 1120 */       Checks.check(l);
/* 1121 */       Checks.checkSafe(paramArrayOfint, paramPointerBuffer.remaining());
/*      */     } 
/* 1123 */     JNI.callPPV(paramInt, paramPointerBuffer.remaining(), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniform1fvARB(@NativeType("GLint") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1128 */     long l = (GL.getICD()).glUniform1fvARB;
/* 1129 */     if (Checks.CHECKS) {
/* 1130 */       Checks.check(l);
/*      */     }
/* 1132 */     JNI.callPV(paramInt, paramArrayOffloat.length, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniform2fvARB(@NativeType("GLint") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1137 */     long l = (GL.getICD()).glUniform2fvARB;
/* 1138 */     if (Checks.CHECKS) {
/* 1139 */       Checks.check(l);
/*      */     }
/* 1141 */     JNI.callPV(paramInt, paramArrayOffloat.length >> 1, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniform3fvARB(@NativeType("GLint") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1146 */     long l = (GL.getICD()).glUniform3fvARB;
/* 1147 */     if (Checks.CHECKS) {
/* 1148 */       Checks.check(l);
/*      */     }
/* 1150 */     JNI.callPV(paramInt, paramArrayOffloat.length / 3, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniform4fvARB(@NativeType("GLint") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1155 */     long l = (GL.getICD()).glUniform4fvARB;
/* 1156 */     if (Checks.CHECKS) {
/* 1157 */       Checks.check(l);
/*      */     }
/* 1159 */     JNI.callPV(paramInt, paramArrayOffloat.length >> 2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniform1ivARB(@NativeType("GLint") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 1164 */     long l = (GL.getICD()).glUniform1ivARB;
/* 1165 */     if (Checks.CHECKS) {
/* 1166 */       Checks.check(l);
/*      */     }
/* 1168 */     JNI.callPV(paramInt, paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniform2ivARB(@NativeType("GLint") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 1173 */     long l = (GL.getICD()).glUniform2ivARB;
/* 1174 */     if (Checks.CHECKS) {
/* 1175 */       Checks.check(l);
/*      */     }
/* 1177 */     JNI.callPV(paramInt, paramArrayOfint.length >> 1, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniform3ivARB(@NativeType("GLint") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 1182 */     long l = (GL.getICD()).glUniform3ivARB;
/* 1183 */     if (Checks.CHECKS) {
/* 1184 */       Checks.check(l);
/*      */     }
/* 1186 */     JNI.callPV(paramInt, paramArrayOfint.length / 3, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniform4ivARB(@NativeType("GLint") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 1191 */     long l = (GL.getICD()).glUniform4ivARB;
/* 1192 */     if (Checks.CHECKS) {
/* 1193 */       Checks.check(l);
/*      */     }
/* 1195 */     JNI.callPV(paramInt, paramArrayOfint.length >> 2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix2fvARB(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1200 */     long l = (GL.getICD()).glUniformMatrix2fvARB;
/* 1201 */     if (Checks.CHECKS) {
/* 1202 */       Checks.check(l);
/*      */     }
/* 1204 */     JNI.callPV(paramInt, paramArrayOffloat.length >> 2, paramBoolean, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix3fvARB(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1209 */     long l = (GL.getICD()).glUniformMatrix3fvARB;
/* 1210 */     if (Checks.CHECKS) {
/* 1211 */       Checks.check(l);
/*      */     }
/* 1213 */     JNI.callPV(paramInt, paramArrayOffloat.length / 9, paramBoolean, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix4fvARB(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1218 */     long l = (GL.getICD()).glUniformMatrix4fvARB;
/* 1219 */     if (Checks.CHECKS) {
/* 1220 */       Checks.check(l);
/*      */     }
/* 1222 */     JNI.callPV(paramInt, paramArrayOffloat.length >> 4, paramBoolean, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetObjectParameterfvARB(@NativeType("GLhandleARB") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 1227 */     long l = (GL.getICD()).glGetObjectParameterfvARB;
/* 1228 */     if (Checks.CHECKS) {
/* 1229 */       Checks.check(l);
/* 1230 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 1232 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetObjectParameterivARB(@NativeType("GLhandleARB") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 1237 */     long l = (GL.getICD()).glGetObjectParameterivARB;
/* 1238 */     if (Checks.CHECKS) {
/* 1239 */       Checks.check(l);
/* 1240 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1242 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetInfoLogARB(@NativeType("GLhandleARB") int paramInt, @NativeType("GLsizei *") int[] paramArrayOfint, @NativeType("GLcharARB *") ByteBuffer paramByteBuffer) {
/* 1247 */     long l = (GL.getICD()).glGetInfoLogARB;
/* 1248 */     if (Checks.CHECKS) {
/* 1249 */       Checks.check(l);
/* 1250 */       Checks.checkSafe(paramArrayOfint, 1);
/*      */     } 
/* 1252 */     JNI.callPPV(paramInt, paramByteBuffer.remaining(), paramArrayOfint, MemoryUtil.memAddress(paramByteBuffer), l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetAttachedObjectsARB(@NativeType("GLhandleARB") int paramInt, @NativeType("GLsizei *") int[] paramArrayOfint1, @NativeType("GLhandleARB *") int[] paramArrayOfint2) {
/* 1257 */     long l = (GL.getICD()).glGetAttachedObjectsARB;
/* 1258 */     if (Checks.CHECKS) {
/* 1259 */       Checks.check(l);
/* 1260 */       Checks.checkSafe(paramArrayOfint1, 1);
/*      */     } 
/* 1262 */     JNI.callPPV(paramInt, paramArrayOfint2.length, paramArrayOfint1, paramArrayOfint2, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetActiveUniformARB(@NativeType("GLhandleARB") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") int[] paramArrayOfint1, @NativeType("GLint *") int[] paramArrayOfint2, @NativeType("GLenum *") int[] paramArrayOfint3, @NativeType("GLcharARB *") ByteBuffer paramByteBuffer) {
/* 1267 */     long l = (GL.getICD()).glGetActiveUniformARB;
/* 1268 */     if (Checks.CHECKS) {
/* 1269 */       Checks.check(l);
/* 1270 */       Checks.checkSafe(paramArrayOfint1, 1);
/* 1271 */       Checks.check(paramArrayOfint2, 1);
/* 1272 */       Checks.check(paramArrayOfint3, 1);
/*      */     } 
/* 1274 */     JNI.callPPPPV(paramInt1, paramInt2, paramByteBuffer.remaining(), paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, MemoryUtil.memAddress(paramByteBuffer), l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetUniformfvARB(@NativeType("GLhandleARB") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 1279 */     long l = (GL.getICD()).glGetUniformfvARB;
/* 1280 */     if (Checks.CHECKS) {
/* 1281 */       Checks.check(l);
/* 1282 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 1284 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetUniformivARB(@NativeType("GLhandleARB") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 1289 */     long l = (GL.getICD()).glGetUniformivARB;
/* 1290 */     if (Checks.CHECKS) {
/* 1291 */       Checks.check(l);
/* 1292 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1294 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetShaderSourceARB(@NativeType("GLhandleARB") int paramInt, @NativeType("GLsizei *") int[] paramArrayOfint, @NativeType("GLcharARB *") ByteBuffer paramByteBuffer) {
/* 1299 */     long l = (GL.getICD()).glGetShaderSourceARB;
/* 1300 */     if (Checks.CHECKS) {
/* 1301 */       Checks.check(l);
/* 1302 */       Checks.checkSafe(paramArrayOfint, 1);
/*      */     } 
/* 1304 */     JNI.callPPV(paramInt, paramByteBuffer.remaining(), paramArrayOfint, MemoryUtil.memAddress(paramByteBuffer), l);
/*      */   }
/*      */   
/*      */   public static native void glDeleteObjectARB(@NativeType("GLhandleARB") int paramInt);
/*      */   
/*      */   @NativeType("GLhandleARB")
/*      */   public static native int glGetHandleARB(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void glDetachObjectARB(@NativeType("GLhandleARB") int paramInt1, @NativeType("GLhandleARB") int paramInt2);
/*      */   
/*      */   @NativeType("GLhandleARB")
/*      */   public static native int glCreateShaderObjectARB(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void nglShaderSourceARB(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void glCompileShaderARB(@NativeType("GLhandleARB") int paramInt);
/*      */   
/*      */   @NativeType("GLhandleARB")
/*      */   public static native int glCreateProgramObjectARB();
/*      */   
/*      */   public static native void glAttachObjectARB(@NativeType("GLhandleARB") int paramInt1, @NativeType("GLhandleARB") int paramInt2);
/*      */   
/*      */   public static native void glLinkProgramARB(@NativeType("GLhandleARB") int paramInt);
/*      */   
/*      */   public static native void glUseProgramObjectARB(@NativeType("GLhandleARB") int paramInt);
/*      */   
/*      */   public static native void glValidateProgramARB(@NativeType("GLhandleARB") int paramInt);
/*      */   
/*      */   public static native void glUniform1fARB(@NativeType("GLint") int paramInt, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void glUniform2fARB(@NativeType("GLint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*      */   
/*      */   public static native void glUniform3fARB(@NativeType("GLint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*      */   
/*      */   public static native void glUniform4fARB(@NativeType("GLint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*      */   
/*      */   public static native void glUniform1iARB(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2);
/*      */   
/*      */   public static native void glUniform2iARB(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void glUniform3iARB(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4);
/*      */   
/*      */   public static native void glUniform4iARB(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5);
/*      */   
/*      */   public static native void nglUniform1fvARB(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglUniform2fvARB(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglUniform3fvARB(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglUniform4fvARB(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglUniform1ivARB(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglUniform2ivARB(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglUniform3ivARB(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglUniform4ivARB(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglUniformMatrix2fvARB(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglUniformMatrix3fvARB(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglUniformMatrix4fvARB(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglGetObjectParameterfvARB(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetObjectParameterivARB(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetInfoLogARB(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void nglGetAttachedObjectsARB(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native int nglGetUniformLocationARB(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGetActiveUniformARB(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*      */   
/*      */   public static native void nglGetUniformfvARB(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetUniformivARB(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetShaderSourceARB(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBShaderObjects.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */