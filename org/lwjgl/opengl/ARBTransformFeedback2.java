/*     */ package org.lwjgl.opengl;
/*     */ 
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
/*     */ public class ARBTransformFeedback2
/*     */ {
/*     */   public static final int GL_TRANSFORM_FEEDBACK = 36386;
/*     */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER_PAUSED = 36387;
/*     */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER_ACTIVE = 36388;
/*     */   public static final int GL_TRANSFORM_FEEDBACK_BINDING = 36389;
/*     */   
/*     */   static {
/*  34 */     GL.initialize();
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
/*     */   protected ARBTransformFeedback2() {
/*  46 */     throw new UnsupportedOperationException();
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
/*     */   public static void glBindTransformFeedback(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/*  58 */     GL40C.glBindTransformFeedback(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglDeleteTransformFeedbacks(int paramInt, long paramLong) {
/*  69 */     GL40C.nglDeleteTransformFeedbacks(paramInt, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDeleteTransformFeedbacks(@NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  78 */     GL40C.glDeleteTransformFeedbacks(paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteTransformFeedbacks(@NativeType("GLuint const *") int paramInt) {
/*  83 */     GL40C.glDeleteTransformFeedbacks(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGenTransformFeedbacks(int paramInt, long paramLong) {
/*  94 */     GL40C.nglGenTransformFeedbacks(paramInt, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGenTransformFeedbacks(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 103 */     GL40C.glGenTransformFeedbacks(paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGenTransformFeedbacks() {
/* 109 */     return GL40C.glGenTransformFeedbacks();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static boolean glIsTransformFeedback(@NativeType("GLuint") int paramInt) {
/* 121 */     return GL40C.glIsTransformFeedback(paramInt);
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
/*     */   public static void glPauseTransformFeedback() {
/* 140 */     GL40C.glPauseTransformFeedback();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glResumeTransformFeedback() {
/* 151 */     GL40C.glResumeTransformFeedback();
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
/*     */   public static void glDrawTransformFeedback(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 163 */     GL40C.glDrawTransformFeedback(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteTransformFeedbacks(@NativeType("GLuint const *") int[] paramArrayOfint) {
/* 168 */     GL40C.glDeleteTransformFeedbacks(paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenTransformFeedbacks(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 173 */     GL40C.glGenTransformFeedbacks(paramArrayOfint);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBTransformFeedback2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */