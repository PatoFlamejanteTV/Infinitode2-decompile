/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ public class ARBMultitexture
/*     */ {
/*     */   public static final int GL_TEXTURE0_ARB = 33984;
/*     */   public static final int GL_TEXTURE1_ARB = 33985;
/*     */   public static final int GL_TEXTURE2_ARB = 33986;
/*     */   public static final int GL_TEXTURE3_ARB = 33987;
/*     */   public static final int GL_TEXTURE4_ARB = 33988;
/*     */   public static final int GL_TEXTURE5_ARB = 33989;
/*     */   public static final int GL_TEXTURE6_ARB = 33990;
/*     */   public static final int GL_TEXTURE7_ARB = 33991;
/*     */   
/*     */   static {
/*  25 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_TEXTURE8_ARB = 33992;
/*     */   
/*     */   public static final int GL_TEXTURE9_ARB = 33993;
/*     */   
/*     */   public static final int GL_TEXTURE10_ARB = 33994;
/*     */   
/*     */   public static final int GL_TEXTURE11_ARB = 33995;
/*     */   
/*     */   public static final int GL_TEXTURE12_ARB = 33996;
/*     */   
/*     */   public static final int GL_TEXTURE13_ARB = 33997;
/*     */   
/*     */   public static final int GL_TEXTURE14_ARB = 33998;
/*     */   
/*     */   public static final int GL_TEXTURE15_ARB = 33999;
/*     */   
/*     */   public static final int GL_TEXTURE16_ARB = 34000;
/*     */   
/*     */   public static final int GL_TEXTURE17_ARB = 34001;
/*     */   
/*     */   public static final int GL_TEXTURE18_ARB = 34002;
/*     */   
/*     */   public static final int GL_TEXTURE19_ARB = 34003;
/*     */   public static final int GL_TEXTURE20_ARB = 34004;
/*     */   public static final int GL_TEXTURE21_ARB = 34005;
/*     */   public static final int GL_TEXTURE22_ARB = 34006;
/*     */   public static final int GL_TEXTURE23_ARB = 34007;
/*     */   public static final int GL_TEXTURE24_ARB = 34008;
/*     */   public static final int GL_TEXTURE25_ARB = 34009;
/*     */   public static final int GL_TEXTURE26_ARB = 34010;
/*     */   public static final int GL_TEXTURE27_ARB = 34011;
/*     */   public static final int GL_TEXTURE28_ARB = 34012;
/*     */   public static final int GL_TEXTURE29_ARB = 34013;
/*     */   public static final int GL_TEXTURE30_ARB = 34014;
/*     */   public static final int GL_TEXTURE31_ARB = 34015;
/*     */   public static final int GL_ACTIVE_TEXTURE_ARB = 34016;
/*     */   public static final int GL_CLIENT_ACTIVE_TEXTURE_ARB = 34017;
/*     */   public static final int GL_MAX_TEXTURE_UNITS_ARB = 34018;
/*     */   
/*     */   protected ARBMultitexture() {
/*  69 */     throw new UnsupportedOperationException();
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
/*     */   public static void glMultiTexCoord1fvARB(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 144 */     if (Checks.CHECKS) {
/* 145 */       Checks.check(paramFloatBuffer, 1);
/*     */     }
/* 147 */     nglMultiTexCoord1fvARB(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
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
/*     */   public static void glMultiTexCoord1svARB(@NativeType("GLenum") int paramInt, @NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/* 162 */     if (Checks.CHECKS) {
/* 163 */       Checks.check(paramShortBuffer, 1);
/*     */     }
/* 165 */     nglMultiTexCoord1svARB(paramInt, MemoryUtil.memAddress(paramShortBuffer));
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
/*     */   public static void glMultiTexCoord1ivARB(@NativeType("GLenum") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 180 */     if (Checks.CHECKS) {
/* 181 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 183 */     nglMultiTexCoord1ivARB(paramInt, MemoryUtil.memAddress(paramIntBuffer));
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
/*     */   public static void glMultiTexCoord1dvARB(@NativeType("GLenum") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 198 */     if (Checks.CHECKS) {
/* 199 */       Checks.check(paramDoubleBuffer, 1);
/*     */     }
/* 201 */     nglMultiTexCoord1dvARB(paramInt, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*     */   public static void glMultiTexCoord2fvARB(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 260 */     if (Checks.CHECKS) {
/* 261 */       Checks.check(paramFloatBuffer, 2);
/*     */     }
/* 263 */     nglMultiTexCoord2fvARB(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
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
/*     */   public static void glMultiTexCoord2svARB(@NativeType("GLenum") int paramInt, @NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/* 278 */     if (Checks.CHECKS) {
/* 279 */       Checks.check(paramShortBuffer, 2);
/*     */     }
/* 281 */     nglMultiTexCoord2svARB(paramInt, MemoryUtil.memAddress(paramShortBuffer));
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
/*     */   public static void glMultiTexCoord2ivARB(@NativeType("GLenum") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 296 */     if (Checks.CHECKS) {
/* 297 */       Checks.check(paramIntBuffer, 2);
/*     */     }
/* 299 */     nglMultiTexCoord2ivARB(paramInt, MemoryUtil.memAddress(paramIntBuffer));
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
/*     */   public static void glMultiTexCoord2dvARB(@NativeType("GLenum") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 314 */     if (Checks.CHECKS) {
/* 315 */       Checks.check(paramDoubleBuffer, 2);
/*     */     }
/* 317 */     nglMultiTexCoord2dvARB(paramInt, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*     */   public static void glMultiTexCoord3fvARB(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 380 */     if (Checks.CHECKS) {
/* 381 */       Checks.check(paramFloatBuffer, 3);
/*     */     }
/* 383 */     nglMultiTexCoord3fvARB(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
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
/*     */   public static void glMultiTexCoord3svARB(@NativeType("GLenum") int paramInt, @NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/* 398 */     if (Checks.CHECKS) {
/* 399 */       Checks.check(paramShortBuffer, 3);
/*     */     }
/* 401 */     nglMultiTexCoord3svARB(paramInt, MemoryUtil.memAddress(paramShortBuffer));
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
/*     */   public static void glMultiTexCoord3ivARB(@NativeType("GLenum") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 416 */     if (Checks.CHECKS) {
/* 417 */       Checks.check(paramIntBuffer, 3);
/*     */     }
/* 419 */     nglMultiTexCoord3ivARB(paramInt, MemoryUtil.memAddress(paramIntBuffer));
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
/*     */   public static void glMultiTexCoord3dvARB(@NativeType("GLenum") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 434 */     if (Checks.CHECKS) {
/* 435 */       Checks.check(paramDoubleBuffer, 3);
/*     */     }
/* 437 */     nglMultiTexCoord3dvARB(paramInt, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*     */   public static void glMultiTexCoord4fvARB(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 504 */     if (Checks.CHECKS) {
/* 505 */       Checks.check(paramFloatBuffer, 4);
/*     */     }
/* 507 */     nglMultiTexCoord4fvARB(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
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
/*     */   public static void glMultiTexCoord4svARB(@NativeType("GLenum") int paramInt, @NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/* 522 */     if (Checks.CHECKS) {
/* 523 */       Checks.check(paramShortBuffer, 4);
/*     */     }
/* 525 */     nglMultiTexCoord4svARB(paramInt, MemoryUtil.memAddress(paramShortBuffer));
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
/*     */   public static void glMultiTexCoord4ivARB(@NativeType("GLenum") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 540 */     if (Checks.CHECKS) {
/* 541 */       Checks.check(paramIntBuffer, 4);
/*     */     }
/* 543 */     nglMultiTexCoord4ivARB(paramInt, MemoryUtil.memAddress(paramIntBuffer));
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
/*     */   public static void glMultiTexCoord4dvARB(@NativeType("GLenum") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 558 */     if (Checks.CHECKS) {
/* 559 */       Checks.check(paramDoubleBuffer, 4);
/*     */     }
/* 561 */     nglMultiTexCoord4dvARB(paramInt, MemoryUtil.memAddress(paramDoubleBuffer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord1fvARB(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 566 */     long l = (GL.getICD()).glMultiTexCoord1fvARB;
/* 567 */     if (Checks.CHECKS) {
/* 568 */       Checks.check(l);
/* 569 */       Checks.check(paramArrayOffloat, 1);
/*     */     } 
/* 571 */     JNI.callPV(paramInt, paramArrayOffloat, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord1svARB(@NativeType("GLenum") int paramInt, @NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 576 */     long l = (GL.getICD()).glMultiTexCoord1svARB;
/* 577 */     if (Checks.CHECKS) {
/* 578 */       Checks.check(l);
/* 579 */       Checks.check(paramArrayOfshort, 1);
/*     */     } 
/* 581 */     JNI.callPV(paramInt, paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord1ivARB(@NativeType("GLenum") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 586 */     long l = (GL.getICD()).glMultiTexCoord1ivARB;
/* 587 */     if (Checks.CHECKS) {
/* 588 */       Checks.check(l);
/* 589 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 591 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord1dvARB(@NativeType("GLenum") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 596 */     long l = (GL.getICD()).glMultiTexCoord1dvARB;
/* 597 */     if (Checks.CHECKS) {
/* 598 */       Checks.check(l);
/* 599 */       Checks.check(paramArrayOfdouble, 1);
/*     */     } 
/* 601 */     JNI.callPV(paramInt, paramArrayOfdouble, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord2fvARB(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 606 */     long l = (GL.getICD()).glMultiTexCoord2fvARB;
/* 607 */     if (Checks.CHECKS) {
/* 608 */       Checks.check(l);
/* 609 */       Checks.check(paramArrayOffloat, 2);
/*     */     } 
/* 611 */     JNI.callPV(paramInt, paramArrayOffloat, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord2svARB(@NativeType("GLenum") int paramInt, @NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 616 */     long l = (GL.getICD()).glMultiTexCoord2svARB;
/* 617 */     if (Checks.CHECKS) {
/* 618 */       Checks.check(l);
/* 619 */       Checks.check(paramArrayOfshort, 2);
/*     */     } 
/* 621 */     JNI.callPV(paramInt, paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord2ivARB(@NativeType("GLenum") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 626 */     long l = (GL.getICD()).glMultiTexCoord2ivARB;
/* 627 */     if (Checks.CHECKS) {
/* 628 */       Checks.check(l);
/* 629 */       Checks.check(paramArrayOfint, 2);
/*     */     } 
/* 631 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord2dvARB(@NativeType("GLenum") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 636 */     long l = (GL.getICD()).glMultiTexCoord2dvARB;
/* 637 */     if (Checks.CHECKS) {
/* 638 */       Checks.check(l);
/* 639 */       Checks.check(paramArrayOfdouble, 2);
/*     */     } 
/* 641 */     JNI.callPV(paramInt, paramArrayOfdouble, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord3fvARB(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 646 */     long l = (GL.getICD()).glMultiTexCoord3fvARB;
/* 647 */     if (Checks.CHECKS) {
/* 648 */       Checks.check(l);
/* 649 */       Checks.check(paramArrayOffloat, 3);
/*     */     } 
/* 651 */     JNI.callPV(paramInt, paramArrayOffloat, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord3svARB(@NativeType("GLenum") int paramInt, @NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 656 */     long l = (GL.getICD()).glMultiTexCoord3svARB;
/* 657 */     if (Checks.CHECKS) {
/* 658 */       Checks.check(l);
/* 659 */       Checks.check(paramArrayOfshort, 3);
/*     */     } 
/* 661 */     JNI.callPV(paramInt, paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord3ivARB(@NativeType("GLenum") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 666 */     long l = (GL.getICD()).glMultiTexCoord3ivARB;
/* 667 */     if (Checks.CHECKS) {
/* 668 */       Checks.check(l);
/* 669 */       Checks.check(paramArrayOfint, 3);
/*     */     } 
/* 671 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord3dvARB(@NativeType("GLenum") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 676 */     long l = (GL.getICD()).glMultiTexCoord3dvARB;
/* 677 */     if (Checks.CHECKS) {
/* 678 */       Checks.check(l);
/* 679 */       Checks.check(paramArrayOfdouble, 3);
/*     */     } 
/* 681 */     JNI.callPV(paramInt, paramArrayOfdouble, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord4fvARB(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 686 */     long l = (GL.getICD()).glMultiTexCoord4fvARB;
/* 687 */     if (Checks.CHECKS) {
/* 688 */       Checks.check(l);
/* 689 */       Checks.check(paramArrayOffloat, 4);
/*     */     } 
/* 691 */     JNI.callPV(paramInt, paramArrayOffloat, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord4svARB(@NativeType("GLenum") int paramInt, @NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 696 */     long l = (GL.getICD()).glMultiTexCoord4svARB;
/* 697 */     if (Checks.CHECKS) {
/* 698 */       Checks.check(l);
/* 699 */       Checks.check(paramArrayOfshort, 4);
/*     */     } 
/* 701 */     JNI.callPV(paramInt, paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord4ivARB(@NativeType("GLenum") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 706 */     long l = (GL.getICD()).glMultiTexCoord4ivARB;
/* 707 */     if (Checks.CHECKS) {
/* 708 */       Checks.check(l);
/* 709 */       Checks.check(paramArrayOfint, 4);
/*     */     } 
/* 711 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord4dvARB(@NativeType("GLenum") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 716 */     long l = (GL.getICD()).glMultiTexCoord4dvARB;
/* 717 */     if (Checks.CHECKS) {
/* 718 */       Checks.check(l);
/* 719 */       Checks.check(paramArrayOfdouble, 4);
/*     */     } 
/* 721 */     JNI.callPV(paramInt, paramArrayOfdouble, l);
/*     */   }
/*     */   
/*     */   public static native void glActiveTextureARB(@NativeType("GLenum") int paramInt);
/*     */   
/*     */   public static native void glClientActiveTextureARB(@NativeType("GLenum") int paramInt);
/*     */   
/*     */   public static native void glMultiTexCoord1fARB(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat);
/*     */   
/*     */   public static native void glMultiTexCoord1sARB(@NativeType("GLenum") int paramInt, @NativeType("GLshort") short paramShort);
/*     */   
/*     */   public static native void glMultiTexCoord1iARB(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2);
/*     */   
/*     */   public static native void glMultiTexCoord1dARB(@NativeType("GLenum") int paramInt, @NativeType("GLdouble") double paramDouble);
/*     */   
/*     */   public static native void nglMultiTexCoord1fvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMultiTexCoord1svARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMultiTexCoord1ivARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMultiTexCoord1dvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glMultiTexCoord2fARB(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*     */   
/*     */   public static native void glMultiTexCoord2sARB(@NativeType("GLenum") int paramInt, @NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2);
/*     */   
/*     */   public static native void glMultiTexCoord2iARB(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*     */   
/*     */   public static native void glMultiTexCoord2dARB(@NativeType("GLenum") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2);
/*     */   
/*     */   public static native void nglMultiTexCoord2fvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMultiTexCoord2svARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMultiTexCoord2ivARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMultiTexCoord2dvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glMultiTexCoord3fARB(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*     */   
/*     */   public static native void glMultiTexCoord3sARB(@NativeType("GLenum") int paramInt, @NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3);
/*     */   
/*     */   public static native void glMultiTexCoord3iARB(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4);
/*     */   
/*     */   public static native void glMultiTexCoord3dARB(@NativeType("GLenum") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*     */   
/*     */   public static native void nglMultiTexCoord3fvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMultiTexCoord3svARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMultiTexCoord3ivARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMultiTexCoord3dvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glMultiTexCoord4fARB(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*     */   
/*     */   public static native void glMultiTexCoord4sARB(@NativeType("GLenum") int paramInt, @NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3, @NativeType("GLshort") short paramShort4);
/*     */   
/*     */   public static native void glMultiTexCoord4iARB(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5);
/*     */   
/*     */   public static native void glMultiTexCoord4dARB(@NativeType("GLenum") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4);
/*     */   
/*     */   public static native void nglMultiTexCoord4fvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMultiTexCoord4svARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMultiTexCoord4ivARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMultiTexCoord4dvARB(int paramInt, long paramLong);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBMultitexture.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */