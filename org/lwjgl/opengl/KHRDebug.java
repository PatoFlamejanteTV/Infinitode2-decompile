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
/*     */ public class KHRDebug
/*     */ {
/*     */   public static final int GL_DEBUG_OUTPUT = 37600;
/*     */   public static final int GL_DEBUG_OUTPUT_SYNCHRONOUS = 33346;
/*     */   public static final int GL_CONTEXT_FLAG_DEBUG_BIT = 2;
/*     */   public static final int GL_MAX_DEBUG_MESSAGE_LENGTH = 37187;
/*     */   public static final int GL_MAX_DEBUG_LOGGED_MESSAGES = 37188;
/*     */   public static final int GL_DEBUG_LOGGED_MESSAGES = 37189;
/*     */   public static final int GL_DEBUG_NEXT_LOGGED_MESSAGE_LENGTH = 33347;
/*     */   public static final int GL_MAX_DEBUG_GROUP_STACK_DEPTH = 33388;
/*     */   public static final int GL_DEBUG_GROUP_STACK_DEPTH = 33389;
/*     */   public static final int GL_MAX_LABEL_LENGTH = 33512;
/*     */   public static final int GL_DEBUG_CALLBACK_FUNCTION = 33348;
/*     */   public static final int GL_DEBUG_CALLBACK_USER_PARAM = 33349;
/*     */   public static final int GL_DEBUG_SOURCE_API = 33350;
/*     */   public static final int GL_DEBUG_SOURCE_WINDOW_SYSTEM = 33351;
/*     */   public static final int GL_DEBUG_SOURCE_SHADER_COMPILER = 33352;
/*     */   public static final int GL_DEBUG_SOURCE_THIRD_PARTY = 33353;
/*     */   public static final int GL_DEBUG_SOURCE_APPLICATION = 33354;
/*     */   public static final int GL_DEBUG_SOURCE_OTHER = 33355;
/*     */   public static final int GL_DEBUG_TYPE_ERROR = 33356;
/*     */   public static final int GL_DEBUG_TYPE_DEPRECATED_BEHAVIOR = 33357;
/*     */   public static final int GL_DEBUG_TYPE_UNDEFINED_BEHAVIOR = 33358;
/*     */   public static final int GL_DEBUG_TYPE_PORTABILITY = 33359;
/*     */   public static final int GL_DEBUG_TYPE_PERFORMANCE = 33360;
/*     */   public static final int GL_DEBUG_TYPE_OTHER = 33361;
/*     */   public static final int GL_DEBUG_TYPE_MARKER = 33384;
/*     */   public static final int GL_DEBUG_TYPE_PUSH_GROUP = 33385;
/*     */   public static final int GL_DEBUG_TYPE_POP_GROUP = 33386;
/*     */   public static final int GL_DEBUG_SEVERITY_HIGH = 37190;
/*     */   public static final int GL_DEBUG_SEVERITY_MEDIUM = 37191;
/*     */   public static final int GL_DEBUG_SEVERITY_LOW = 37192;
/*     */   public static final int GL_DEBUG_SEVERITY_NOTIFICATION = 33387;
/*     */   public static final int GL_BUFFER = 33504;
/*     */   public static final int GL_SHADER = 33505;
/*     */   public static final int GL_PROGRAM = 33506;
/*     */   public static final int GL_QUERY = 33507;
/*     */   public static final int GL_PROGRAM_PIPELINE = 33508;
/*     */   public static final int GL_SAMPLER = 33510;
/*     */   public static final int GL_DISPLAY_LIST = 33511;
/*     */   
/*     */   static {
/*  85 */     GL.initialize();
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
/*     */   protected KHRDebug() {
/* 161 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglDebugMessageControl(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, boolean paramBoolean) {
/* 172 */     GL43C.nglDebugMessageControl(paramInt1, paramInt2, paramInt3, paramInt4, paramLong, paramBoolean);
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
/*     */   public static void glDebugMessageControl(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint const *") IntBuffer paramIntBuffer, @NativeType("GLboolean") boolean paramBoolean) {
/* 208 */     GL43C.glDebugMessageControl(paramInt1, paramInt2, paramInt3, paramIntBuffer, paramBoolean);
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
/*     */   public static void glDebugMessageControl(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint const *") int paramInt4, @NativeType("GLboolean") boolean paramBoolean) {
/* 243 */     GL43C.glDebugMessageControl(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglDebugMessageInsert(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong) {
/* 254 */     GL43C.nglDebugMessageInsert(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong);
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
/*     */   public static void glDebugMessageInsert(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/* 276 */     GL43C.glDebugMessageInsert(paramInt1, paramInt2, paramInt3, paramInt4, paramByteBuffer);
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
/*     */   public static void glDebugMessageInsert(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/* 298 */     GL43C.glDebugMessageInsert(paramInt1, paramInt2, paramInt3, paramInt4, paramCharSequence);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglDebugMessageCallback(long paramLong1, long paramLong2) {
/* 305 */     GL43C.nglDebugMessageCallback(paramLong1, paramLong2);
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
/*     */   public static void glDebugMessageCallback(@NativeType("GLDEBUGPROC") GLDebugMessageCallbackI paramGLDebugMessageCallbackI, @NativeType("void const *") long paramLong) {
/* 340 */     GL43C.glDebugMessageCallback(paramGLDebugMessageCallbackI, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglGetDebugMessageLog(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6) {
/* 351 */     return GL43C.nglGetDebugMessageLog(paramInt1, paramInt2, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6);
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
/*     */   @NativeType("GLuint")
/*     */   public static int glGetDebugMessageLog(@NativeType("GLuint") int paramInt, @NativeType("GLenum *") IntBuffer paramIntBuffer1, @NativeType("GLenum *") IntBuffer paramIntBuffer2, @NativeType("GLuint *") IntBuffer paramIntBuffer3, @NativeType("GLenum *") IntBuffer paramIntBuffer4, @NativeType("GLsizei *") IntBuffer paramIntBuffer5, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 389 */     return GL43C.glGetDebugMessageLog(paramInt, paramIntBuffer1, paramIntBuffer2, paramIntBuffer3, paramIntBuffer4, paramIntBuffer5, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglPushDebugGroup(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 400 */     GL43C.nglPushDebugGroup(paramInt1, paramInt2, paramInt3, paramLong);
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
/*     */   public static void glPushDebugGroup(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/* 420 */     GL43C.glPushDebugGroup(paramInt1, paramInt2, paramByteBuffer);
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
/*     */   public static void glPushDebugGroup(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/* 440 */     GL43C.glPushDebugGroup(paramInt1, paramInt2, paramCharSequence);
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
/*     */   public static void glPopDebugGroup() {
/* 455 */     GL43C.glPopDebugGroup();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglObjectLabel(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 466 */     GL43C.nglObjectLabel(paramInt1, paramInt2, paramInt3, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glObjectLabel(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/* 477 */     GL43C.glObjectLabel(paramInt1, paramInt2, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glObjectLabel(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/* 488 */     GL43C.glObjectLabel(paramInt1, paramInt2, paramCharSequence);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetObjectLabel(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2) {
/* 499 */     GL43C.nglGetObjectLabel(paramInt1, paramInt2, paramInt3, paramLong1, paramLong2);
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
/*     */   public static void glGetObjectLabel(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") IntBuffer paramIntBuffer, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 511 */     GL43C.glGetObjectLabel(paramInt1, paramInt2, paramIntBuffer, paramByteBuffer);
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
/*     */   public static String glGetObjectLabel(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei") int paramInt3) {
/* 523 */     return GL43C.glGetObjectLabel(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetObjectLabel(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 534 */     return glGetObjectLabel(paramInt1, paramInt2, GL11.glGetInteger(33512));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglObjectPtrLabel(long paramLong1, int paramInt, long paramLong2) {
/* 545 */     GL43C.nglObjectPtrLabel(paramLong1, paramInt, paramLong2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glObjectPtrLabel(@NativeType("void *") long paramLong, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/* 555 */     GL43C.glObjectPtrLabel(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glObjectPtrLabel(@NativeType("void *") long paramLong, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/* 565 */     GL43C.glObjectPtrLabel(paramLong, paramCharSequence);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetObjectPtrLabel(long paramLong1, int paramInt, long paramLong2, long paramLong3) {
/* 576 */     GL43C.nglGetObjectPtrLabel(paramLong1, paramInt, paramLong2, paramLong3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetObjectPtrLabel(@NativeType("void *") long paramLong, @NativeType("GLsizei *") IntBuffer paramIntBuffer, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 587 */     GL43C.glGetObjectPtrLabel(paramLong, paramIntBuffer, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetObjectPtrLabel(@NativeType("void *") long paramLong, @NativeType("GLsizei") int paramInt) {
/* 598 */     return GL43C.glGetObjectPtrLabel(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetObjectPtrLabel(@NativeType("void *") long paramLong) {
/* 608 */     return glGetObjectPtrLabel(paramLong, GL11.glGetInteger(33512));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDebugMessageControl(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint const *") int[] paramArrayOfint, @NativeType("GLboolean") boolean paramBoolean) {
/* 613 */     GL43C.glDebugMessageControl(paramInt1, paramInt2, paramInt3, paramArrayOfint, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLuint")
/*     */   public static int glGetDebugMessageLog(@NativeType("GLuint") int paramInt, @NativeType("GLenum *") int[] paramArrayOfint1, @NativeType("GLenum *") int[] paramArrayOfint2, @NativeType("GLuint *") int[] paramArrayOfint3, @NativeType("GLenum *") int[] paramArrayOfint4, @NativeType("GLsizei *") int[] paramArrayOfint5, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 619 */     return GL43C.glGetDebugMessageLog(paramInt, paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramArrayOfint4, paramArrayOfint5, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetObjectLabel(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") int[] paramArrayOfint, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 624 */     GL43C.glGetObjectLabel(paramInt1, paramInt2, paramArrayOfint, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetObjectPtrLabel(@NativeType("void *") long paramLong, @NativeType("GLsizei *") int[] paramArrayOfint, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 629 */     GL43C.glGetObjectPtrLabel(paramLong, paramArrayOfint, paramByteBuffer);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\KHRDebug.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */