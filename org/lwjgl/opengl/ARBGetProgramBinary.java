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
/*     */ public class ARBGetProgramBinary
/*     */ {
/*     */   public static final int GL_PROGRAM_BINARY_RETRIEVABLE_HINT = 33367;
/*     */   public static final int GL_PROGRAM_BINARY_LENGTH = 34625;
/*     */   public static final int GL_NUM_PROGRAM_BINARY_FORMATS = 34814;
/*     */   public static final int GL_PROGRAM_BINARY_FORMATS = 34815;
/*     */   
/*     */   static {
/*  33 */     GL.initialize();
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
/*     */   protected ARBGetProgramBinary() {
/*  47 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetProgramBinary(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3) {
/*  58 */     GL41C.nglGetProgramBinary(paramInt1, paramInt2, paramLong1, paramLong2, paramLong3);
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
/*     */   public static void glGetProgramBinary(@NativeType("GLuint") int paramInt, @NativeType("GLsizei *") IntBuffer paramIntBuffer1, @NativeType("GLenum *") IntBuffer paramIntBuffer2, @NativeType("void *") ByteBuffer paramByteBuffer) {
/*  70 */     GL41C.glGetProgramBinary(paramInt, paramIntBuffer1, paramIntBuffer2, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramBinary(int paramInt1, int paramInt2, long paramLong, int paramInt3) {
/*  81 */     GL41C.nglProgramBinary(paramInt1, paramInt2, paramLong, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramBinary(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  92 */     GL41C.glProgramBinary(paramInt1, paramInt2, paramByteBuffer);
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
/*     */   public static void glProgramParameteri(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3) {
/* 105 */     GL41C.glProgramParameteri(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetProgramBinary(@NativeType("GLuint") int paramInt, @NativeType("GLsizei *") int[] paramArrayOfint1, @NativeType("GLenum *") int[] paramArrayOfint2, @NativeType("void *") ByteBuffer paramByteBuffer) {
/* 110 */     GL41C.glGetProgramBinary(paramInt, paramArrayOfint1, paramArrayOfint2, paramByteBuffer);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBGetProgramBinary.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */