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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ARBVertexAttribBinding
/*     */ {
/*     */   public static final int GL_VERTEX_ATTRIB_BINDING = 33492;
/*     */   public static final int GL_VERTEX_ATTRIB_RELATIVE_OFFSET = 33493;
/*     */   public static final int GL_VERTEX_BINDING_DIVISOR = 33494;
/*     */   public static final int GL_VERTEX_BINDING_OFFSET = 33495;
/*     */   public static final int GL_VERTEX_BINDING_STRIDE = 33496;
/*     */   public static final int GL_VERTEX_BINDING_BUFFER = 36687;
/*     */   public static final int GL_MAX_VERTEX_ATTRIB_RELATIVE_OFFSET = 33497;
/*     */   public static final int GL_MAX_VERTEX_ATTRIB_BINDINGS = 33498;
/*     */   
/*     */   static {
/*  44 */     GL.initialize();
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
/*     */   protected ARBVertexAttribBinding() {
/*  64 */     throw new UnsupportedOperationException();
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
/*     */   public static void glBindVertexBuffer(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLintptr") long paramLong, @NativeType("GLsizei") int paramInt3) {
/*  78 */     GL43C.glBindVertexBuffer(paramInt1, paramInt2, paramLong, paramInt3);
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
/*     */   public static void glVertexAttribFormat(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint") int paramInt4) {
/*  94 */     GL43C.glVertexAttribFormat(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4);
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
/*     */   public static void glVertexAttribIFormat(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4) {
/* 108 */     GL43C.glVertexAttribIFormat(paramInt1, paramInt2, paramInt3, paramInt4);
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
/*     */   public static void glVertexAttribLFormat(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4) {
/* 122 */     GL43C.glVertexAttribLFormat(paramInt1, paramInt2, paramInt3, paramInt4);
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
/*     */   public static void glVertexAttribBinding(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 134 */     GL43C.glVertexAttribBinding(paramInt1, paramInt2);
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
/*     */   public static void glVertexBindingDivisor(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 146 */     GL43C.glVertexBindingDivisor(paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public static native void glVertexArrayBindVertexBufferEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLintptr") long paramLong, @NativeType("GLsizei") int paramInt4);
/*     */   
/*     */   public static native void glVertexArrayVertexAttribFormatEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint") int paramInt5);
/*     */   
/*     */   public static native void glVertexArrayVertexAttribIFormatEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLuint") int paramInt5);
/*     */   
/*     */   public static native void glVertexArrayVertexAttribLFormatEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLuint") int paramInt5);
/*     */   
/*     */   public static native void glVertexArrayVertexAttribBindingEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*     */   
/*     */   public static native void glVertexArrayVertexBindingDivisorEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBVertexAttribBinding.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */