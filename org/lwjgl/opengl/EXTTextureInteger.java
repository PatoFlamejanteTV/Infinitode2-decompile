/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
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
/*     */ public class EXTTextureInteger
/*     */ {
/*     */   public static final int GL_RGBA_INTEGER_MODE_EXT = 36254;
/*     */   public static final int GL_RGBA32UI_EXT = 36208;
/*     */   public static final int GL_RGB32UI_EXT = 36209;
/*     */   public static final int GL_ALPHA32UI_EXT = 36210;
/*     */   public static final int GL_INTENSITY32UI_EXT = 36211;
/*     */   public static final int GL_LUMINANCE32UI_EXT = 36212;
/*     */   public static final int GL_LUMINANCE_ALPHA32UI_EXT = 36213;
/*     */   public static final int GL_RGBA16UI_EXT = 36214;
/*     */   public static final int GL_RGB16UI_EXT = 36215;
/*     */   public static final int GL_ALPHA16UI_EXT = 36216;
/*     */   public static final int GL_INTENSITY16UI_EXT = 36217;
/*     */   public static final int GL_LUMINANCE16UI_EXT = 36218;
/*     */   public static final int GL_LUMINANCE_ALPHA16UI_EXT = 36219;
/*     */   public static final int GL_RGBA8UI_EXT = 36220;
/*     */   public static final int GL_RGB8UI_EXT = 36221;
/*     */   public static final int GL_ALPHA8UI_EXT = 36222;
/*     */   public static final int GL_INTENSITY8UI_EXT = 36223;
/*     */   public static final int GL_LUMINANCE8UI_EXT = 36224;
/*     */   public static final int GL_LUMINANCE_ALPHA8UI_EXT = 36225;
/*     */   public static final int GL_RGBA32I_EXT = 36226;
/*     */   public static final int GL_RGB32I_EXT = 36227;
/*     */   public static final int GL_ALPHA32I_EXT = 36228;
/*     */   public static final int GL_INTENSITY32I_EXT = 36229;
/*     */   
/*     */   static {
/*  56 */     GL.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_LUMINANCE32I_EXT = 36230;
/*     */ 
/*     */   
/*     */   public static final int GL_LUMINANCE_ALPHA32I_EXT = 36231;
/*     */ 
/*     */   
/*     */   public static final int GL_RGBA16I_EXT = 36232;
/*     */ 
/*     */   
/*     */   public static final int GL_RGB16I_EXT = 36233;
/*     */   
/*     */   public static final int GL_ALPHA16I_EXT = 36234;
/*     */   
/*     */   public static final int GL_INTENSITY16I_EXT = 36235;
/*     */   
/*     */   public static final int GL_LUMINANCE16I_EXT = 36236;
/*     */   
/*     */   public static final int GL_LUMINANCE_ALPHA16I_EXT = 36237;
/*     */   
/*     */   public static final int GL_RGBA8I_EXT = 36238;
/*     */   
/*     */   public static final int GL_RGB8I_EXT = 36239;
/*     */   
/*     */   public static final int GL_ALPHA8I_EXT = 36240;
/*     */   
/*     */   public static final int GL_INTENSITY8I_EXT = 36241;
/*     */   
/*     */   public static final int GL_LUMINANCE8I_EXT = 36242;
/*     */   
/*     */   public static final int GL_LUMINANCE_ALPHA8I_EXT = 36243;
/*     */   
/*     */   public static final int GL_RED_INTEGER_EXT = 36244;
/*     */   
/*     */   public static final int GL_GREEN_INTEGER_EXT = 36245;
/*     */   
/*     */   public static final int GL_BLUE_INTEGER_EXT = 36246;
/*     */   
/*     */   public static final int GL_ALPHA_INTEGER_EXT = 36247;
/*     */   
/*     */   public static final int GL_RGB_INTEGER_EXT = 36248;
/*     */   
/*     */   public static final int GL_RGBA_INTEGER_EXT = 36249;
/*     */   
/*     */   public static final int GL_BGR_INTEGER_EXT = 36250;
/*     */   
/*     */   public static final int GL_BGRA_INTEGER_EXT = 36251;
/*     */   
/*     */   public static final int GL_LUMINANCE_INTEGER_EXT = 36252;
/*     */   
/*     */   public static final int GL_LUMINANCE_ALPHA_INTEGER_EXT = 36253;
/*     */ 
/*     */   
/*     */   protected EXTTextureInteger() {
/* 114 */     throw new UnsupportedOperationException();
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
/*     */   public static void glTexParameterIivEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 130 */     if (Checks.CHECKS) {
/* 131 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 133 */     nglTexParameterIivEXT(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   public static void glTexParameterIiEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int paramInt3) {
/*     */     MemoryStack memoryStack;
/* 137 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 139 */       IntBuffer intBuffer = memoryStack.ints(paramInt3);
/* 140 */       nglTexParameterIivEXT(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer)); return;
/*     */     } finally {
/* 142 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glTexParameterIuivEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 151 */     if (Checks.CHECKS) {
/* 152 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 154 */     nglTexParameterIuivEXT(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   public static void glTexParameterIuiEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint *") int paramInt3) {
/*     */     MemoryStack memoryStack;
/* 158 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 160 */       IntBuffer intBuffer = memoryStack.ints(paramInt3);
/* 161 */       nglTexParameterIuivEXT(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer)); return;
/*     */     } finally {
/* 163 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetTexParameterIivEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 172 */     if (Checks.CHECKS) {
/* 173 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 175 */     nglGetTexParameterIivEXT(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   @NativeType("void")
/*     */   public static int glGetTexParameterIiEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*     */     MemoryStack memoryStack;
/* 180 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 182 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 183 */       nglGetTexParameterIivEXT(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 184 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*     */     } finally {
/* 186 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetTexParameterIuivEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 195 */     if (Checks.CHECKS) {
/* 196 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 198 */     nglGetTexParameterIuivEXT(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   @NativeType("void")
/*     */   public static int glGetTexParameterIuiEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*     */     MemoryStack memoryStack;
/* 203 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 205 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 206 */       nglGetTexParameterIuivEXT(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 207 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*     */     } finally {
/* 209 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexParameterIivEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 215 */     long l = (GL.getICD()).glTexParameterIivEXT;
/* 216 */     if (Checks.CHECKS) {
/* 217 */       Checks.check(l);
/* 218 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 220 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexParameterIuivEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 225 */     long l = (GL.getICD()).glTexParameterIuivEXT;
/* 226 */     if (Checks.CHECKS) {
/* 227 */       Checks.check(l);
/* 228 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 230 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetTexParameterIivEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 235 */     long l = (GL.getICD()).glGetTexParameterIivEXT;
/* 236 */     if (Checks.CHECKS) {
/* 237 */       Checks.check(l);
/* 238 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 240 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetTexParameterIuivEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 245 */     long l = (GL.getICD()).glGetTexParameterIuivEXT;
/* 246 */     if (Checks.CHECKS) {
/* 247 */       Checks.check(l);
/* 248 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 250 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*     */   }
/*     */   
/*     */   public static native void glClearColorIiEXT(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4);
/*     */   
/*     */   public static native void glClearColorIuiEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint") int paramInt4);
/*     */   
/*     */   public static native void nglTexParameterIivEXT(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglTexParameterIuivEXT(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetTexParameterIivEXT(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetTexParameterIuivEXT(int paramInt1, int paramInt2, long paramLong);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\EXTTextureInteger.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */