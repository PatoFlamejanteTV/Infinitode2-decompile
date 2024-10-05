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
/*     */ public class ARBVertexType2_10_10_10_REV
/*     */ {
/*     */   public static final int GL_INT_2_10_10_10_REV = 36255;
/*     */   
/*     */   static {
/*  23 */     GL.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ARBVertexType2_10_10_10_REV() {
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
/*     */   
/*     */   public static void glVertexP2ui(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/*  44 */     GL33.glVertexP2ui(paramInt1, paramInt2);
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
/*     */   public static void glVertexP3ui(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/*  56 */     GL33.glVertexP3ui(paramInt1, paramInt2);
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
/*     */   public static void glVertexP4ui(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/*  68 */     GL33.glVertexP4ui(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglVertexP2uiv(int paramInt, long paramLong) {
/*  75 */     GL33.nglVertexP2uiv(paramInt, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexP2uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  85 */     GL33.glVertexP2uiv(paramInt, paramIntBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglVertexP3uiv(int paramInt, long paramLong) {
/*  92 */     GL33.nglVertexP3uiv(paramInt, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexP3uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 102 */     GL33.glVertexP3uiv(paramInt, paramIntBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglVertexP4uiv(int paramInt, long paramLong) {
/* 109 */     GL33.nglVertexP4uiv(paramInt, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexP4uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 119 */     GL33.glVertexP4uiv(paramInt, paramIntBuffer);
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
/*     */   public static void glTexCoordP1ui(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 131 */     GL33.glTexCoordP1ui(paramInt1, paramInt2);
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
/*     */   public static void glTexCoordP2ui(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 143 */     GL33.glTexCoordP2ui(paramInt1, paramInt2);
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
/*     */   public static void glTexCoordP3ui(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 155 */     GL33.glTexCoordP3ui(paramInt1, paramInt2);
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
/*     */   public static void glTexCoordP4ui(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 167 */     GL33.glTexCoordP4ui(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglTexCoordP1uiv(int paramInt, long paramLong) {
/* 174 */     GL33.nglTexCoordP1uiv(paramInt, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glTexCoordP1uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 184 */     GL33.glTexCoordP1uiv(paramInt, paramIntBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglTexCoordP2uiv(int paramInt, long paramLong) {
/* 191 */     GL33.nglTexCoordP2uiv(paramInt, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glTexCoordP2uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 201 */     GL33.glTexCoordP2uiv(paramInt, paramIntBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglTexCoordP3uiv(int paramInt, long paramLong) {
/* 208 */     GL33.nglTexCoordP3uiv(paramInt, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glTexCoordP3uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 218 */     GL33.glTexCoordP3uiv(paramInt, paramIntBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglTexCoordP4uiv(int paramInt, long paramLong) {
/* 225 */     GL33.nglTexCoordP4uiv(paramInt, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glTexCoordP4uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 235 */     GL33.glTexCoordP4uiv(paramInt, paramIntBuffer);
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
/*     */   public static void glMultiTexCoordP1ui(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3) {
/* 248 */     GL33.glMultiTexCoordP1ui(paramInt1, paramInt2, paramInt3);
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
/*     */   public static void glMultiTexCoordP2ui(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3) {
/* 261 */     GL33.glMultiTexCoordP2ui(paramInt1, paramInt2, paramInt3);
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
/*     */   public static void glMultiTexCoordP3ui(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3) {
/* 274 */     GL33.glMultiTexCoordP3ui(paramInt1, paramInt2, paramInt3);
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
/*     */   public static void glMultiTexCoordP4ui(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3) {
/* 287 */     GL33.glMultiTexCoordP4ui(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglMultiTexCoordP1uiv(int paramInt1, int paramInt2, long paramLong) {
/* 294 */     GL33.nglMultiTexCoordP1uiv(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoordP1uiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 305 */     GL33.glMultiTexCoordP1uiv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglMultiTexCoordP2uiv(int paramInt1, int paramInt2, long paramLong) {
/* 312 */     GL33.nglMultiTexCoordP2uiv(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoordP2uiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 323 */     GL33.glMultiTexCoordP2uiv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglMultiTexCoordP3uiv(int paramInt1, int paramInt2, long paramLong) {
/* 330 */     GL33.nglMultiTexCoordP3uiv(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoordP3uiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 341 */     GL33.glMultiTexCoordP3uiv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglMultiTexCoordP4uiv(int paramInt1, int paramInt2, long paramLong) {
/* 348 */     GL33.nglMultiTexCoordP4uiv(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoordP4uiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 359 */     GL33.glMultiTexCoordP4uiv(paramInt1, paramInt2, paramIntBuffer);
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
/*     */   public static void glNormalP3ui(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 371 */     GL33.glNormalP3ui(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglNormalP3uiv(int paramInt, long paramLong) {
/* 378 */     GL33.nglNormalP3uiv(paramInt, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glNormalP3uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 388 */     GL33.glNormalP3uiv(paramInt, paramIntBuffer);
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
/*     */   public static void glColorP3ui(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 400 */     GL33.glColorP3ui(paramInt1, paramInt2);
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
/*     */   public static void glColorP4ui(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 412 */     GL33.glColorP4ui(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglColorP3uiv(int paramInt, long paramLong) {
/* 419 */     GL33.nglColorP3uiv(paramInt, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glColorP3uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 429 */     GL33.glColorP3uiv(paramInt, paramIntBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglColorP4uiv(int paramInt, long paramLong) {
/* 436 */     GL33.nglColorP4uiv(paramInt, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glColorP4uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 446 */     GL33.glColorP4uiv(paramInt, paramIntBuffer);
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
/*     */   public static void glSecondaryColorP3ui(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 458 */     GL33.glSecondaryColorP3ui(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglSecondaryColorP3uiv(int paramInt, long paramLong) {
/* 465 */     GL33.nglSecondaryColorP3uiv(paramInt, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSecondaryColorP3uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 475 */     GL33.glSecondaryColorP3uiv(paramInt, paramIntBuffer);
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
/*     */   public static void glVertexAttribP1ui(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint") int paramInt3) {
/* 489 */     GL33C.glVertexAttribP1ui(paramInt1, paramInt2, paramBoolean, paramInt3);
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
/*     */   public static void glVertexAttribP2ui(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint") int paramInt3) {
/* 503 */     GL33C.glVertexAttribP2ui(paramInt1, paramInt2, paramBoolean, paramInt3);
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
/*     */   public static void glVertexAttribP3ui(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint") int paramInt3) {
/* 517 */     GL33C.glVertexAttribP3ui(paramInt1, paramInt2, paramBoolean, paramInt3);
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
/*     */   public static void glVertexAttribP4ui(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint") int paramInt3) {
/* 531 */     GL33C.glVertexAttribP4ui(paramInt1, paramInt2, paramBoolean, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglVertexAttribP1uiv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong) {
/* 538 */     GL33C.nglVertexAttribP1uiv(paramInt1, paramInt2, paramBoolean, paramLong);
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
/*     */   public static void glVertexAttribP1uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 550 */     GL33C.glVertexAttribP1uiv(paramInt1, paramInt2, paramBoolean, paramIntBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglVertexAttribP2uiv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong) {
/* 557 */     GL33C.nglVertexAttribP2uiv(paramInt1, paramInt2, paramBoolean, paramLong);
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
/*     */   public static void glVertexAttribP2uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 569 */     GL33C.glVertexAttribP2uiv(paramInt1, paramInt2, paramBoolean, paramIntBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglVertexAttribP3uiv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong) {
/* 576 */     GL33C.nglVertexAttribP3uiv(paramInt1, paramInt2, paramBoolean, paramLong);
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
/*     */   public static void glVertexAttribP3uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 588 */     GL33C.glVertexAttribP3uiv(paramInt1, paramInt2, paramBoolean, paramIntBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglVertexAttribP4uiv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong) {
/* 595 */     GL33C.nglVertexAttribP4uiv(paramInt1, paramInt2, paramBoolean, paramLong);
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
/*     */   public static void glVertexAttribP4uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 607 */     GL33C.glVertexAttribP4uiv(paramInt1, paramInt2, paramBoolean, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexP2uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 612 */     GL33.glVertexP2uiv(paramInt, paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexP3uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 617 */     GL33.glVertexP3uiv(paramInt, paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexP4uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 622 */     GL33.glVertexP4uiv(paramInt, paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexCoordP1uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 627 */     GL33.glTexCoordP1uiv(paramInt, paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexCoordP2uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 632 */     GL33.glTexCoordP2uiv(paramInt, paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexCoordP3uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 637 */     GL33.glTexCoordP3uiv(paramInt, paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexCoordP4uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 642 */     GL33.glTexCoordP4uiv(paramInt, paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoordP1uiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 647 */     GL33.glMultiTexCoordP1uiv(paramInt1, paramInt2, paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoordP2uiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 652 */     GL33.glMultiTexCoordP2uiv(paramInt1, paramInt2, paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoordP3uiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 657 */     GL33.glMultiTexCoordP3uiv(paramInt1, paramInt2, paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoordP4uiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 662 */     GL33.glMultiTexCoordP4uiv(paramInt1, paramInt2, paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glNormalP3uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 667 */     GL33.glNormalP3uiv(paramInt, paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glColorP3uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 672 */     GL33.glColorP3uiv(paramInt, paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glColorP4uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 677 */     GL33.glColorP4uiv(paramInt, paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSecondaryColorP3uiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 682 */     GL33.glSecondaryColorP3uiv(paramInt, paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribP1uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 687 */     GL33C.glVertexAttribP1uiv(paramInt1, paramInt2, paramBoolean, paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribP2uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 692 */     GL33C.glVertexAttribP2uiv(paramInt1, paramInt2, paramBoolean, paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribP3uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 697 */     GL33C.glVertexAttribP3uiv(paramInt1, paramInt2, paramBoolean, paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribP4uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 702 */     GL33C.glVertexAttribP4uiv(paramInt1, paramInt2, paramBoolean, paramArrayOfint);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBVertexType2_10_10_10_REV.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */