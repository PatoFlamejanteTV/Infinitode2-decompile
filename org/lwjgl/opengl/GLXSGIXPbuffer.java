/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.CLongBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.JNI;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GLXSGIXPbuffer
/*     */ {
/*     */   public static final int GLX_MAX_PBUFFER_WIDTH_SGIX = 32790;
/*     */   public static final int GLX_MAX_PBUFFER_HEIGHT_SGIX = 32791;
/*     */   public static final int GLX_MAX_PBUFFER_PIXELS_SGIX = 32792;
/*     */   public static final int GLX_OPTIMAL_PBUFFER_WIDTH_SGIX = 32793;
/*     */   public static final int GLX_OPTIMAL_PBUFFER_HEIGHT_SGIX = 32794;
/*     */   public static final int GLX_PBUFFER_BIT_SGIX = 4;
/*     */   public static final int GLX_PRESERVED_CONTENTS_SGIX = 32795;
/*     */   public static final int GLX_LARGEST_PBUFFER_SGIX = 32796;
/*     */   public static final int GLX_WIDTH_SGIX = 32797;
/*     */   public static final int GLX_HEIGHT_SGIX = 32798;
/*     */   public static final int GLX_EVENT_MASK_SGIX = 32799;
/*     */   public static final int GLX_BUFFER_CLOBBER_MASK_SGIX = 134217728;
/*     */   public static final int GLX_DAMAGED_SGIX = 32800;
/*     */   public static final int GLX_SAVED_SGIX = 32801;
/*     */   public static final int GLX_WINDOW_SGIX = 32802;
/*     */   public static final int GLX_PBUFFER_SGIX = 32803;
/*     */   public static final int GLX_FRONT_LEFT_BUFFER_BIT_SGIX = 1;
/*     */   public static final int GLX_FRONT_RIGHT_BUFFER_BIT_SGIX = 2;
/*     */   public static final int GLX_BACK_LEFT_BUFFER_BIT_SGIX = 4;
/*     */   public static final int GLX_BACK_RIGHT_BUFFER_BIT_SGIX = 8;
/*     */   public static final int GLX_AUX_BUFFERS_BIT_SGIX = 16;
/*     */   public static final int GLX_DEPTH_BUFFER_BIT_SGIX = 32;
/*     */   public static final int GLX_STENCIL_BUFFER_BIT_SGIX = 64;
/*     */   public static final int GLX_ACCUM_BUFFER_BIT_SGIX = 128;
/*     */   public static final int GLX_SAMPLE_BUFFERS_BIT_SGIX = 256;
/*     */   
/*     */   protected GLXSGIXPbuffer() {
/*  80 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglXCreateGLXPbufferSGIX(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3) {
/*  87 */     long l = (GL.getCapabilitiesGLXClient()).glXCreateGLXPbufferSGIX;
/*  88 */     if (Checks.CHECKS) {
/*  89 */       Checks.check(l);
/*  90 */       Checks.check(paramLong1);
/*  91 */       Checks.check(paramLong2);
/*     */     } 
/*  93 */     return JNI.callPPPP(paramLong1, paramLong2, paramInt1, paramInt2, paramLong3, l);
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
/*     */   @NativeType("GLXPbuffer")
/*     */   public static long glXCreateGLXPbufferSGIX(@NativeType("Display *") long paramLong1, @NativeType("GLXFBConfig") long paramLong2, @NativeType("unsigned int") int paramInt1, @NativeType("unsigned int") int paramInt2, @NativeType("int *") IntBuffer paramIntBuffer) {
/* 107 */     if (Checks.CHECKS) {
/* 108 */       Checks.checkNTSafe(paramIntBuffer);
/*     */     }
/* 110 */     return nglXCreateGLXPbufferSGIX(paramLong1, paramLong2, paramInt1, paramInt2, MemoryUtil.memAddressSafe(paramIntBuffer));
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
/*     */   public static void glXDestroyGLXPbufferSGIX(@NativeType("Display *") long paramLong1, @NativeType("GLXPbuffer") long paramLong2) {
/* 122 */     long l = (GL.getCapabilitiesGLXClient()).glXDestroyGLXPbufferSGIX;
/* 123 */     if (Checks.CHECKS) {
/* 124 */       Checks.check(l);
/* 125 */       Checks.check(paramLong1);
/* 126 */       Checks.check(paramLong2);
/*     */     } 
/* 128 */     JNI.callPPV(paramLong1, paramLong2, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglXQueryGLXPbufferSGIX(long paramLong1, long paramLong2, int paramInt, long paramLong3) {
/* 135 */     long l = (GL.getCapabilitiesGLXClient()).glXQueryGLXPbufferSGIX;
/* 136 */     if (Checks.CHECKS) {
/* 137 */       Checks.check(l);
/* 138 */       Checks.check(paramLong1);
/* 139 */       Checks.check(paramLong2);
/*     */     } 
/* 141 */     JNI.callPPPV(paramLong1, paramLong2, paramInt, paramLong3, l);
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
/*     */   public static void glXQueryGLXPbufferSGIX(@NativeType("Display *") long paramLong1, @NativeType("GLXPbuffer") long paramLong2, int paramInt, @NativeType("unsigned int *") IntBuffer paramIntBuffer) {
/* 153 */     if (Checks.CHECKS) {
/* 154 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 156 */     nglXQueryGLXPbufferSGIX(paramLong1, paramLong2, paramInt, MemoryUtil.memAddress(paramIntBuffer));
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
/*     */   public static void glXSelectEventSGIX(@NativeType("Display *") long paramLong1, @NativeType("GLXDrawable") long paramLong2, @NativeType("unsigned long") long paramLong3) {
/* 169 */     long l = (GL.getCapabilitiesGLXClient()).glXSelectEventSGIX;
/* 170 */     if (Checks.CHECKS) {
/* 171 */       Checks.check(l);
/* 172 */       Checks.check(paramLong1);
/* 173 */       Checks.check(paramLong2);
/*     */     } 
/* 175 */     JNI.callPPNV(paramLong1, paramLong2, paramLong3, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglXGetSelectedEventSGIX(long paramLong1, long paramLong2, long paramLong3) {
/* 182 */     long l = (GL.getCapabilitiesGLXClient()).glXGetSelectedEventSGIX;
/* 183 */     if (Checks.CHECKS) {
/* 184 */       Checks.check(l);
/* 185 */       Checks.check(paramLong1);
/* 186 */       Checks.check(paramLong2);
/*     */     } 
/* 188 */     JNI.callPPPV(paramLong1, paramLong2, paramLong3, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glXGetSelectedEventSGIX(@NativeType("Display *") long paramLong1, @NativeType("GLXDrawable") long paramLong2, @NativeType("unsigned long *") CLongBuffer paramCLongBuffer) {
/* 199 */     if (Checks.CHECKS) {
/* 200 */       Checks.check((CustomBuffer)paramCLongBuffer, 1);
/*     */     }
/* 202 */     nglXGetSelectedEventSGIX(paramLong1, paramLong2, MemoryUtil.memAddress((CustomBuffer)paramCLongBuffer));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLXPbuffer")
/*     */   public static long glXCreateGLXPbufferSGIX(@NativeType("Display *") long paramLong1, @NativeType("GLXFBConfig") long paramLong2, @NativeType("unsigned int") int paramInt1, @NativeType("unsigned int") int paramInt2, @NativeType("int *") int[] paramArrayOfint) {
/* 208 */     long l = (GL.getCapabilitiesGLXClient()).glXCreateGLXPbufferSGIX;
/* 209 */     if (Checks.CHECKS) {
/* 210 */       Checks.check(l);
/* 211 */       Checks.check(paramLong1);
/* 212 */       Checks.check(paramLong2);
/* 213 */       Checks.checkNTSafe(paramArrayOfint);
/*     */     } 
/* 215 */     return JNI.callPPPP(paramLong1, paramLong2, paramInt1, paramInt2, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glXQueryGLXPbufferSGIX(@NativeType("Display *") long paramLong1, @NativeType("GLXPbuffer") long paramLong2, int paramInt, @NativeType("unsigned int *") int[] paramArrayOfint) {
/* 220 */     long l = (GL.getCapabilitiesGLXClient()).glXQueryGLXPbufferSGIX;
/* 221 */     if (Checks.CHECKS) {
/* 222 */       Checks.check(l);
/* 223 */       Checks.check(paramLong1);
/* 224 */       Checks.check(paramLong2);
/* 225 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 227 */     JNI.callPPPV(paramLong1, paramLong2, paramInt, paramArrayOfint, l);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GLXSGIXPbuffer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */