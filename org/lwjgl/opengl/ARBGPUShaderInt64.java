/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.LongBuffer;
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
/*     */ public class ARBGPUShaderInt64
/*     */ {
/*     */   public static final int GL_INT64_ARB = 5134;
/*     */   public static final int GL_UNSIGNED_INT64_ARB = 5135;
/*     */   public static final int GL_INT64_VEC2_ARB = 36841;
/*     */   public static final int GL_INT64_VEC3_ARB = 36842;
/*     */   public static final int GL_INT64_VEC4_ARB = 36843;
/*     */   public static final int GL_UNSIGNED_INT64_VEC2_ARB = 36853;
/*     */   public static final int GL_UNSIGNED_INT64_VEC3_ARB = 36854;
/*     */   public static final int GL_UNSIGNED_INT64_VEC4_ARB = 36855;
/*     */   
/*     */   static {
/*  35 */     GL.initialize();
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
/*     */   protected ARBGPUShaderInt64() {
/*  49 */     throw new UnsupportedOperationException();
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
/*     */   public static void glUniform1i64vARB(@NativeType("GLint") int paramInt, @NativeType("GLint64 *") LongBuffer paramLongBuffer) {
/*  78 */     nglUniform1i64vARB(paramInt, paramLongBuffer.remaining(), MemoryUtil.memAddress(paramLongBuffer));
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
/*     */   public static void glProgramUniform1i64vARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64 *") LongBuffer paramLongBuffer) {
/* 109 */     nglProgramUniform1i64vARB(paramInt1, paramInt2, paramLongBuffer.remaining(), MemoryUtil.memAddress(paramLongBuffer));
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
/*     */   public static void glUniform2i64vARB(@NativeType("GLint") int paramInt, @NativeType("GLint64 *") LongBuffer paramLongBuffer) {
/* 139 */     nglUniform2i64vARB(paramInt, paramLongBuffer.remaining() >> 1, MemoryUtil.memAddress(paramLongBuffer));
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
/*     */   public static void glProgramUniform2i64vARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64 *") LongBuffer paramLongBuffer) {
/* 171 */     nglProgramUniform2i64vARB(paramInt1, paramInt2, paramLongBuffer.remaining() >> 1, MemoryUtil.memAddress(paramLongBuffer));
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
/*     */   public static void glUniform3i64vARB(@NativeType("GLint") int paramInt, @NativeType("GLint64 *") LongBuffer paramLongBuffer) {
/* 202 */     nglUniform3i64vARB(paramInt, paramLongBuffer.remaining() / 3, MemoryUtil.memAddress(paramLongBuffer));
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
/*     */   public static void glProgramUniform3i64vARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64 *") LongBuffer paramLongBuffer) {
/* 235 */     nglProgramUniform3i64vARB(paramInt1, paramInt2, paramLongBuffer.remaining() / 3, MemoryUtil.memAddress(paramLongBuffer));
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
/*     */   public static void glUniform4i64vARB(@NativeType("GLint") int paramInt, @NativeType("GLint64 *") LongBuffer paramLongBuffer) {
/* 267 */     nglUniform4i64vARB(paramInt, paramLongBuffer.remaining() >> 2, MemoryUtil.memAddress(paramLongBuffer));
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
/*     */   public static void glProgramUniform4i64vARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64 *") LongBuffer paramLongBuffer) {
/* 301 */     nglProgramUniform4i64vARB(paramInt1, paramInt2, paramLongBuffer.remaining() >> 2, MemoryUtil.memAddress(paramLongBuffer));
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
/*     */   public static void glUniform1ui64vARB(@NativeType("GLint") int paramInt, @NativeType("GLuint64 const *") LongBuffer paramLongBuffer) {
/* 330 */     nglUniform1ui64vARB(paramInt, paramLongBuffer.remaining(), MemoryUtil.memAddress(paramLongBuffer));
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
/*     */   public static void glProgramUniform1ui64vARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64 const *") LongBuffer paramLongBuffer) {
/* 361 */     nglProgramUniform1ui64vARB(paramInt1, paramInt2, paramLongBuffer.remaining(), MemoryUtil.memAddress(paramLongBuffer));
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
/*     */   public static void glUniform2ui64vARB(@NativeType("GLint") int paramInt, @NativeType("GLuint64 const *") LongBuffer paramLongBuffer) {
/* 391 */     nglUniform2ui64vARB(paramInt, paramLongBuffer.remaining() >> 1, MemoryUtil.memAddress(paramLongBuffer));
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
/*     */   public static void glProgramUniform2ui64vARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64 const *") LongBuffer paramLongBuffer) {
/* 423 */     nglProgramUniform2ui64vARB(paramInt1, paramInt2, paramLongBuffer.remaining() >> 1, MemoryUtil.memAddress(paramLongBuffer));
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
/*     */   public static void glUniform3ui64vARB(@NativeType("GLint") int paramInt, @NativeType("GLuint64 const *") LongBuffer paramLongBuffer) {
/* 454 */     nglUniform3ui64vARB(paramInt, paramLongBuffer.remaining() / 3, MemoryUtil.memAddress(paramLongBuffer));
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
/*     */   public static void glProgramUniform3ui64vARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64 const *") LongBuffer paramLongBuffer) {
/* 487 */     nglProgramUniform3ui64vARB(paramInt1, paramInt2, paramLongBuffer.remaining() / 3, MemoryUtil.memAddress(paramLongBuffer));
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
/*     */   public static void glUniform4ui64vARB(@NativeType("GLint") int paramInt, @NativeType("GLuint64 const *") LongBuffer paramLongBuffer) {
/* 519 */     nglUniform4ui64vARB(paramInt, paramLongBuffer.remaining() >> 2, MemoryUtil.memAddress(paramLongBuffer));
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
/*     */   public static void glProgramUniform4ui64vARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64 const *") LongBuffer paramLongBuffer) {
/* 553 */     nglProgramUniform4ui64vARB(paramInt1, paramInt2, paramLongBuffer.remaining() >> 2, MemoryUtil.memAddress(paramLongBuffer));
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
/*     */   public static void glGetUniformi64vARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64 *") LongBuffer paramLongBuffer) {
/* 569 */     if (Checks.CHECKS) {
/* 570 */       Checks.check(paramLongBuffer, 1);
/*     */     }
/* 572 */     nglGetUniformi64vARB(paramInt1, paramInt2, MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetUniformi64vARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2) {
/*     */     MemoryStack memoryStack;
/* 583 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 585 */       LongBuffer longBuffer = memoryStack.callocLong(1);
/* 586 */       nglGetUniformi64vARB(paramInt1, paramInt2, MemoryUtil.memAddress(longBuffer));
/* 587 */       return longBuffer.get(0);
/*     */     } finally {
/* 589 */       memoryStack.setPointer(i);
/*     */     } 
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
/*     */   public static void glGetUniformui64vARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64 *") LongBuffer paramLongBuffer) {
/* 606 */     if (Checks.CHECKS) {
/* 607 */       Checks.check(paramLongBuffer, 1);
/*     */     }
/* 609 */     nglGetUniformui64vARB(paramInt1, paramInt2, MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetUniformui64vARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2) {
/*     */     MemoryStack memoryStack;
/* 620 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 622 */       LongBuffer longBuffer = memoryStack.callocLong(1);
/* 623 */       nglGetUniformui64vARB(paramInt1, paramInt2, MemoryUtil.memAddress(longBuffer));
/* 624 */       return longBuffer.get(0);
/*     */     } finally {
/* 626 */       memoryStack.setPointer(i);
/*     */     } 
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
/*     */   public static void glGetnUniformi64vARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64 *") LongBuffer paramLongBuffer) {
/* 647 */     nglGetnUniformi64vARB(paramInt1, paramInt2, paramLongBuffer.remaining(), MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetnUniformi64vARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2) {
/*     */     MemoryStack memoryStack;
/* 658 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 660 */       LongBuffer longBuffer = memoryStack.callocLong(1);
/* 661 */       nglGetnUniformi64vARB(paramInt1, paramInt2, 1, MemoryUtil.memAddress(longBuffer));
/* 662 */       return longBuffer.get(0);
/*     */     } finally {
/* 664 */       memoryStack.setPointer(i);
/*     */     } 
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
/*     */   public static void glGetnUniformui64vARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64 *") LongBuffer paramLongBuffer) {
/* 685 */     nglGetnUniformui64vARB(paramInt1, paramInt2, paramLongBuffer.remaining(), MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetnUniformui64vARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2) {
/*     */     MemoryStack memoryStack;
/* 696 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 698 */       LongBuffer longBuffer = memoryStack.callocLong(1);
/* 699 */       nglGetnUniformui64vARB(paramInt1, paramInt2, 1, MemoryUtil.memAddress(longBuffer));
/* 700 */       return longBuffer.get(0);
/*     */     } finally {
/* 702 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform1i64vARB(@NativeType("GLint") int paramInt, @NativeType("GLint64 *") long[] paramArrayOflong) {
/* 708 */     long l = (GL.getICD()).glUniform1i64vARB;
/* 709 */     if (Checks.CHECKS) {
/* 710 */       Checks.check(l);
/*     */     }
/* 712 */     JNI.callPV(paramInt, paramArrayOflong.length, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform1i64vARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64 *") long[] paramArrayOflong) {
/* 717 */     long l = (GL.getICD()).glProgramUniform1i64vARB;
/* 718 */     if (Checks.CHECKS) {
/* 719 */       Checks.check(l);
/*     */     }
/* 721 */     JNI.callPV(paramInt1, paramInt2, paramArrayOflong.length, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform2i64vARB(@NativeType("GLint") int paramInt, @NativeType("GLint64 *") long[] paramArrayOflong) {
/* 726 */     long l = (GL.getICD()).glUniform2i64vARB;
/* 727 */     if (Checks.CHECKS) {
/* 728 */       Checks.check(l);
/*     */     }
/* 730 */     JNI.callPV(paramInt, paramArrayOflong.length >> 1, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform2i64vARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64 *") long[] paramArrayOflong) {
/* 735 */     long l = (GL.getICD()).glProgramUniform2i64vARB;
/* 736 */     if (Checks.CHECKS) {
/* 737 */       Checks.check(l);
/*     */     }
/* 739 */     JNI.callPV(paramInt1, paramInt2, paramArrayOflong.length >> 1, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform3i64vARB(@NativeType("GLint") int paramInt, @NativeType("GLint64 *") long[] paramArrayOflong) {
/* 744 */     long l = (GL.getICD()).glUniform3i64vARB;
/* 745 */     if (Checks.CHECKS) {
/* 746 */       Checks.check(l);
/*     */     }
/* 748 */     JNI.callPV(paramInt, paramArrayOflong.length / 3, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform3i64vARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64 *") long[] paramArrayOflong) {
/* 753 */     long l = (GL.getICD()).glProgramUniform3i64vARB;
/* 754 */     if (Checks.CHECKS) {
/* 755 */       Checks.check(l);
/*     */     }
/* 757 */     JNI.callPV(paramInt1, paramInt2, paramArrayOflong.length / 3, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform4i64vARB(@NativeType("GLint") int paramInt, @NativeType("GLint64 *") long[] paramArrayOflong) {
/* 762 */     long l = (GL.getICD()).glUniform4i64vARB;
/* 763 */     if (Checks.CHECKS) {
/* 764 */       Checks.check(l);
/*     */     }
/* 766 */     JNI.callPV(paramInt, paramArrayOflong.length >> 2, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform4i64vARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64 *") long[] paramArrayOflong) {
/* 771 */     long l = (GL.getICD()).glProgramUniform4i64vARB;
/* 772 */     if (Checks.CHECKS) {
/* 773 */       Checks.check(l);
/*     */     }
/* 775 */     JNI.callPV(paramInt1, paramInt2, paramArrayOflong.length >> 2, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform1ui64vARB(@NativeType("GLint") int paramInt, @NativeType("GLuint64 const *") long[] paramArrayOflong) {
/* 780 */     long l = (GL.getICD()).glUniform1ui64vARB;
/* 781 */     if (Checks.CHECKS) {
/* 782 */       Checks.check(l);
/*     */     }
/* 784 */     JNI.callPV(paramInt, paramArrayOflong.length, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform1ui64vARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64 const *") long[] paramArrayOflong) {
/* 789 */     long l = (GL.getICD()).glProgramUniform1ui64vARB;
/* 790 */     if (Checks.CHECKS) {
/* 791 */       Checks.check(l);
/*     */     }
/* 793 */     JNI.callPV(paramInt1, paramInt2, paramArrayOflong.length, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform2ui64vARB(@NativeType("GLint") int paramInt, @NativeType("GLuint64 const *") long[] paramArrayOflong) {
/* 798 */     long l = (GL.getICD()).glUniform2ui64vARB;
/* 799 */     if (Checks.CHECKS) {
/* 800 */       Checks.check(l);
/*     */     }
/* 802 */     JNI.callPV(paramInt, paramArrayOflong.length >> 1, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform2ui64vARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64 const *") long[] paramArrayOflong) {
/* 807 */     long l = (GL.getICD()).glProgramUniform2ui64vARB;
/* 808 */     if (Checks.CHECKS) {
/* 809 */       Checks.check(l);
/*     */     }
/* 811 */     JNI.callPV(paramInt1, paramInt2, paramArrayOflong.length >> 1, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform3ui64vARB(@NativeType("GLint") int paramInt, @NativeType("GLuint64 const *") long[] paramArrayOflong) {
/* 816 */     long l = (GL.getICD()).glUniform3ui64vARB;
/* 817 */     if (Checks.CHECKS) {
/* 818 */       Checks.check(l);
/*     */     }
/* 820 */     JNI.callPV(paramInt, paramArrayOflong.length / 3, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform3ui64vARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64 const *") long[] paramArrayOflong) {
/* 825 */     long l = (GL.getICD()).glProgramUniform3ui64vARB;
/* 826 */     if (Checks.CHECKS) {
/* 827 */       Checks.check(l);
/*     */     }
/* 829 */     JNI.callPV(paramInt1, paramInt2, paramArrayOflong.length / 3, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform4ui64vARB(@NativeType("GLint") int paramInt, @NativeType("GLuint64 const *") long[] paramArrayOflong) {
/* 834 */     long l = (GL.getICD()).glUniform4ui64vARB;
/* 835 */     if (Checks.CHECKS) {
/* 836 */       Checks.check(l);
/*     */     }
/* 838 */     JNI.callPV(paramInt, paramArrayOflong.length >> 2, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform4ui64vARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64 const *") long[] paramArrayOflong) {
/* 843 */     long l = (GL.getICD()).glProgramUniform4ui64vARB;
/* 844 */     if (Checks.CHECKS) {
/* 845 */       Checks.check(l);
/*     */     }
/* 847 */     JNI.callPV(paramInt1, paramInt2, paramArrayOflong.length >> 2, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetUniformi64vARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64 *") long[] paramArrayOflong) {
/* 852 */     long l = (GL.getICD()).glGetUniformi64vARB;
/* 853 */     if (Checks.CHECKS) {
/* 854 */       Checks.check(l);
/* 855 */       Checks.check(paramArrayOflong, 1);
/*     */     } 
/* 857 */     JNI.callPV(paramInt1, paramInt2, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetUniformui64vARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64 *") long[] paramArrayOflong) {
/* 862 */     long l = (GL.getICD()).glGetUniformui64vARB;
/* 863 */     if (Checks.CHECKS) {
/* 864 */       Checks.check(l);
/* 865 */       Checks.check(paramArrayOflong, 1);
/*     */     } 
/* 867 */     JNI.callPV(paramInt1, paramInt2, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnUniformi64vARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64 *") long[] paramArrayOflong) {
/* 872 */     long l = (GL.getICD()).glGetnUniformi64vARB;
/* 873 */     if (Checks.CHECKS) {
/* 874 */       Checks.check(l);
/*     */     }
/* 876 */     JNI.callPV(paramInt1, paramInt2, paramArrayOflong.length, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetnUniformui64vARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64 *") long[] paramArrayOflong) {
/* 881 */     long l = (GL.getICD()).glGetnUniformui64vARB;
/* 882 */     if (Checks.CHECKS) {
/* 883 */       Checks.check(l);
/*     */     }
/* 885 */     JNI.callPV(paramInt1, paramInt2, paramArrayOflong.length, paramArrayOflong, l);
/*     */   }
/*     */   
/*     */   public static native void glUniform1i64ARB(@NativeType("GLint") int paramInt, @NativeType("GLint64") long paramLong);
/*     */   
/*     */   public static native void nglUniform1i64vARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glProgramUniform1i64ARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64") long paramLong);
/*     */   
/*     */   public static native void nglProgramUniform1i64vARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void glUniform2i64ARB(@NativeType("GLint") int paramInt, @NativeType("GLint64") long paramLong1, @NativeType("GLint64") long paramLong2);
/*     */   
/*     */   public static native void nglUniform2i64vARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glProgramUniform2i64ARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64") long paramLong1, @NativeType("GLint64") long paramLong2);
/*     */   
/*     */   public static native void nglProgramUniform2i64vARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void glUniform3i64ARB(@NativeType("GLint") int paramInt, @NativeType("GLint64") long paramLong1, @NativeType("GLint64") long paramLong2, @NativeType("GLint64") long paramLong3);
/*     */   
/*     */   public static native void nglUniform3i64vARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glProgramUniform3i64ARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64") long paramLong1, @NativeType("GLint64") long paramLong2, @NativeType("GLint64") long paramLong3);
/*     */   
/*     */   public static native void nglProgramUniform3i64vARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void glUniform4i64ARB(@NativeType("GLint") int paramInt, @NativeType("GLint64") long paramLong1, @NativeType("GLint64") long paramLong2, @NativeType("GLint64") long paramLong3, @NativeType("GLint64") long paramLong4);
/*     */   
/*     */   public static native void nglUniform4i64vARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glProgramUniform4i64ARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64") long paramLong1, @NativeType("GLint64") long paramLong2, @NativeType("GLint64") long paramLong3, @NativeType("GLint64") long paramLong4);
/*     */   
/*     */   public static native void nglProgramUniform4i64vARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void glUniform1ui64ARB(@NativeType("GLint") int paramInt, @NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void nglUniform1ui64vARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glProgramUniform1ui64ARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void nglProgramUniform1ui64vARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void glUniform2ui64ARB(@NativeType("GLint") int paramInt, @NativeType("GLuint64") long paramLong1, @NativeType("GLuint64") long paramLong2);
/*     */   
/*     */   public static native void nglUniform2ui64vARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glProgramUniform2ui64ARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64") long paramLong1, @NativeType("GLuint64") long paramLong2);
/*     */   
/*     */   public static native void nglProgramUniform2ui64vARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void glUniform3ui64ARB(@NativeType("GLint") int paramInt, @NativeType("GLuint64") long paramLong1, @NativeType("GLuint64") long paramLong2, @NativeType("GLuint64") long paramLong3);
/*     */   
/*     */   public static native void nglUniform3ui64vARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glProgramUniform3ui64ARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64") long paramLong1, @NativeType("GLuint64") long paramLong2, @NativeType("GLuint64") long paramLong3);
/*     */   
/*     */   public static native void nglProgramUniform3ui64vARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void glUniform4ui64ARB(@NativeType("GLint") int paramInt, @NativeType("GLuint64") long paramLong1, @NativeType("GLuint64") long paramLong2, @NativeType("GLuint64") long paramLong3, @NativeType("GLuint64") long paramLong4);
/*     */   
/*     */   public static native void nglUniform4ui64vARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glProgramUniform4ui64ARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64") long paramLong1, @NativeType("GLuint64") long paramLong2, @NativeType("GLuint64") long paramLong3, @NativeType("GLuint64") long paramLong4);
/*     */   
/*     */   public static native void nglProgramUniform4ui64vARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglGetUniformi64vARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetUniformui64vARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetnUniformi64vARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglGetnUniformui64vARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBGPUShaderInt64.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */