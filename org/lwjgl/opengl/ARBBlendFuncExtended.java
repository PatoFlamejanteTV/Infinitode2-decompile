/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
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
/*     */ public class ARBBlendFuncExtended
/*     */ {
/*     */   public static final int GL_SRC1_COLOR = 35065;
/*     */   public static final int GL_ONE_MINUS_SRC1_COLOR = 35066;
/*     */   public static final int GL_ONE_MINUS_SRC1_ALPHA = 35067;
/*     */   public static final int GL_MAX_DUAL_SOURCE_DRAW_BUFFERS = 35068;
/*     */   
/*     */   static {
/*  28 */     GL.initialize();
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
/*     */   protected ARBBlendFuncExtended() {
/*  43 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglBindFragDataLocationIndexed(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/*  50 */     GL33C.nglBindFragDataLocationIndexed(paramInt1, paramInt2, paramInt3, paramLong);
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
/*     */   public static void glBindFragDataLocationIndexed(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/*  62 */     GL33C.glBindFragDataLocationIndexed(paramInt1, paramInt2, paramInt3, paramByteBuffer);
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
/*     */   public static void glBindFragDataLocationIndexed(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/*  74 */     GL33C.glBindFragDataLocationIndexed(paramInt1, paramInt2, paramInt3, paramCharSequence);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglGetFragDataIndex(int paramInt, long paramLong) {
/*  81 */     return GL33C.nglGetFragDataIndex(paramInt, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLint")
/*     */   public static int glGetFragDataIndex(@NativeType("GLuint") int paramInt, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/*  92 */     return GL33C.glGetFragDataIndex(paramInt, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLint")
/*     */   public static int glGetFragDataIndex(@NativeType("GLuint") int paramInt, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/* 103 */     return GL33C.glGetFragDataIndex(paramInt, paramCharSequence);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBBlendFuncExtended.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */