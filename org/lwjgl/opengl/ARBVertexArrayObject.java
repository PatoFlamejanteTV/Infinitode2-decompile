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
/*     */ public class ARBVertexArrayObject
/*     */ {
/*     */   public static final int GL_VERTEX_ARRAY_BINDING = 34229;
/*     */   
/*     */   static {
/*  26 */     GL.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected ARBVertexArrayObject() {
/*  32 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glBindVertexArray(@NativeType("GLuint") int paramInt) {
/*  43 */     GL30C.glBindVertexArray(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglDeleteVertexArrays(int paramInt, long paramLong) {
/*  54 */     GL30C.nglDeleteVertexArrays(paramInt, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDeleteVertexArrays(@NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  63 */     GL30C.glDeleteVertexArrays(paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteVertexArrays(@NativeType("GLuint const *") int paramInt) {
/*  68 */     GL30C.glDeleteVertexArrays(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGenVertexArrays(int paramInt, long paramLong) {
/*  79 */     GL30C.nglGenVertexArrays(paramInt, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGenVertexArrays(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/*  88 */     GL30C.glGenVertexArrays(paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGenVertexArrays() {
/*  94 */     return GL30C.glGenVertexArrays();
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
/*     */   public static boolean glIsVertexArray(@NativeType("GLuint") int paramInt) {
/* 106 */     return GL30C.glIsVertexArray(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteVertexArrays(@NativeType("GLuint const *") int[] paramArrayOfint) {
/* 111 */     GL30C.glDeleteVertexArrays(paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenVertexArrays(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 116 */     GL30C.glGenVertexArrays(paramArrayOfint);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBVertexArrayObject.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */