/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.LongBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NVCommandList
/*     */ {
/*     */   public static final int GL_TERMINATE_SEQUENCE_COMMAND_NV = 0;
/*     */   public static final int GL_NOP_COMMAND_NV = 1;
/*     */   public static final int GL_DRAW_ELEMENTS_COMMAND_NV = 2;
/*     */   public static final int GL_DRAW_ARRAYS_COMMAND_NV = 3;
/*     */   public static final int GL_DRAW_ELEMENTS_STRIP_COMMAND_NV = 4;
/*     */   public static final int GL_DRAW_ARRAYS_STRIP_COMMAND_NV = 5;
/*     */   public static final int GL_DRAW_ELEMENTS_INSTANCED_COMMAND_NV = 6;
/*     */   public static final int GL_DRAW_ARRAYS_INSTANCED_COMMAND_NV = 7;
/*     */   public static final int GL_ELEMENT_ADDRESS_COMMAND_NV = 8;
/*     */   public static final int GL_ATTRIBUTE_ADDRESS_COMMAND_NV = 9;
/*     */   public static final int GL_UNIFORM_ADDRESS_COMMAND_NV = 10;
/*     */   public static final int GL_BLEND_COLOR_COMMAND_NV = 11;
/*     */   public static final int GL_STENCIL_REF_COMMAND_NV = 12;
/*     */   public static final int GL_LINE_WIDTH_COMMAND_NV = 13;
/*     */   public static final int GL_POLYGON_OFFSET_COMMAND_NV = 14;
/*     */   public static final int GL_ALPHA_REF_COMMAND_NV = 15;
/*     */   public static final int GL_VIEWPORT_COMMAND_NV = 16;
/*     */   public static final int GL_SCISSOR_COMMAND_NV = 17;
/*     */   public static final int GL_FRONT_FACE_COMMAND_NV = 18;
/*     */   
/*     */   static {
/* 159 */     GL.initialize();
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
/*     */   protected NVCommandList() {
/* 184 */     throw new UnsupportedOperationException();
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
/*     */   public static void glCreateStatesNV(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 202 */     nglCreateStatesNV(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glCreateStatesNV() {
/*     */     MemoryStack memoryStack;
/* 208 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 210 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 211 */       nglCreateStatesNV(1, MemoryUtil.memAddress(intBuffer));
/* 212 */       return intBuffer.get(0);
/*     */     } finally {
/* 214 */       memoryStack.setPointer(i);
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
/*     */   public static void glDeleteStatesNV(@NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 234 */     nglDeleteStatesNV(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDeleteStatesNV(@NativeType("GLuint const *") int paramInt) {
/*     */     MemoryStack memoryStack;
/* 242 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 244 */       IntBuffer intBuffer = memoryStack.ints(paramInt);
/* 245 */       nglDeleteStatesNV(1, MemoryUtil.memAddress(intBuffer)); return;
/*     */     } finally {
/* 247 */       memoryStack.setPointer(i);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDrawCommandsNV(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLintptr const *") PointerBuffer paramPointerBuffer, @NativeType("GLsizei const *") IntBuffer paramIntBuffer) {
/* 330 */     if (Checks.CHECKS) {
/* 331 */       Checks.check(paramIntBuffer, paramPointerBuffer.remaining());
/*     */     }
/* 333 */     nglDrawCommandsNV(paramInt1, paramInt2, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), MemoryUtil.memAddress(paramIntBuffer), paramPointerBuffer.remaining());
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
/*     */   public static void glDrawCommandsAddressNV(@NativeType("GLenum") int paramInt, @NativeType("GLuint64 const *") LongBuffer paramLongBuffer, @NativeType("GLsizei const *") IntBuffer paramIntBuffer) {
/* 354 */     if (Checks.CHECKS) {
/* 355 */       Checks.check(paramIntBuffer, paramLongBuffer.remaining());
/*     */     }
/* 357 */     nglDrawCommandsAddressNV(paramInt, MemoryUtil.memAddress(paramLongBuffer), MemoryUtil.memAddress(paramIntBuffer), paramLongBuffer.remaining());
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
/*     */   public static void glDrawCommandsStatesNV(@NativeType("GLuint") int paramInt, @NativeType("GLintptr const *") PointerBuffer paramPointerBuffer, @NativeType("GLsizei const *") IntBuffer paramIntBuffer1, @NativeType("GLuint const *") IntBuffer paramIntBuffer2, @NativeType("GLuint const *") IntBuffer paramIntBuffer3) {
/* 382 */     if (Checks.CHECKS) {
/* 383 */       Checks.check(paramIntBuffer1, paramPointerBuffer.remaining());
/* 384 */       Checks.check(paramIntBuffer2, paramPointerBuffer.remaining());
/* 385 */       Checks.check(paramIntBuffer3, paramPointerBuffer.remaining());
/*     */     } 
/* 387 */     nglDrawCommandsStatesNV(paramInt, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramIntBuffer3), paramPointerBuffer.remaining());
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
/*     */   public static void glDrawCommandsStatesAddressNV(@NativeType("GLuint64 const *") LongBuffer paramLongBuffer, @NativeType("GLsizei const *") IntBuffer paramIntBuffer1, @NativeType("GLuint const *") IntBuffer paramIntBuffer2, @NativeType("GLuint const *") IntBuffer paramIntBuffer3) {
/* 411 */     if (Checks.CHECKS) {
/* 412 */       Checks.check(paramIntBuffer1, paramLongBuffer.remaining());
/* 413 */       Checks.check(paramIntBuffer2, paramLongBuffer.remaining());
/* 414 */       Checks.check(paramIntBuffer3, paramLongBuffer.remaining());
/*     */     } 
/* 416 */     nglDrawCommandsStatesAddressNV(MemoryUtil.memAddress(paramLongBuffer), MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramIntBuffer3), paramLongBuffer.remaining());
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
/*     */   public static void glCreateCommandListsNV(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 434 */     nglCreateCommandListsNV(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glCreateCommandListsNV() {
/*     */     MemoryStack memoryStack;
/* 440 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 442 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 443 */       nglCreateCommandListsNV(1, MemoryUtil.memAddress(intBuffer));
/* 444 */       return intBuffer.get(0);
/*     */     } finally {
/* 446 */       memoryStack.setPointer(i);
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
/*     */   public static void glDeleteCommandListsNV(@NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 466 */     nglDeleteCommandListsNV(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDeleteCommandListsNV(@NativeType("GLuint const *") int paramInt) {
/*     */     MemoryStack memoryStack;
/* 474 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 476 */       IntBuffer intBuffer = memoryStack.ints(paramInt);
/* 477 */       nglDeleteCommandListsNV(1, MemoryUtil.memAddress(intBuffer)); return;
/*     */     } finally {
/* 479 */       memoryStack.setPointer(i);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glListDrawCommandsStatesClientNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("void const **") PointerBuffer paramPointerBuffer, @NativeType("GLsizei const *") IntBuffer paramIntBuffer1, @NativeType("GLuint const *") IntBuffer paramIntBuffer2, @NativeType("GLuint const *") IntBuffer paramIntBuffer3) {
/* 527 */     if (Checks.CHECKS) {
/* 528 */       Checks.check(paramIntBuffer1, paramPointerBuffer.remaining());
/* 529 */       Checks.check(paramIntBuffer2, paramPointerBuffer.remaining());
/* 530 */       Checks.check(paramIntBuffer3, paramPointerBuffer.remaining());
/*     */     } 
/* 532 */     nglListDrawCommandsStatesClientNV(paramInt1, paramInt2, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramIntBuffer3), paramPointerBuffer.remaining());
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
/*     */   public static void glCreateStatesNV(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 569 */     long l = (GL.getICD()).glCreateStatesNV;
/* 570 */     if (Checks.CHECKS) {
/* 571 */       Checks.check(l);
/*     */     }
/* 573 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteStatesNV(@NativeType("GLuint const *") int[] paramArrayOfint) {
/* 578 */     long l = (GL.getICD()).glDeleteStatesNV;
/* 579 */     if (Checks.CHECKS) {
/* 580 */       Checks.check(l);
/*     */     }
/* 582 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawCommandsNV(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLintptr const *") PointerBuffer paramPointerBuffer, @NativeType("GLsizei const *") int[] paramArrayOfint) {
/* 587 */     long l = (GL.getICD()).glDrawCommandsNV;
/* 588 */     if (Checks.CHECKS) {
/* 589 */       Checks.check(l);
/* 590 */       Checks.check(paramArrayOfint, paramPointerBuffer.remaining());
/*     */     } 
/* 592 */     JNI.callPPV(paramInt1, paramInt2, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), paramArrayOfint, paramPointerBuffer.remaining(), l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawCommandsAddressNV(@NativeType("GLenum") int paramInt, @NativeType("GLuint64 const *") long[] paramArrayOflong, @NativeType("GLsizei const *") int[] paramArrayOfint) {
/* 597 */     long l = (GL.getICD()).glDrawCommandsAddressNV;
/* 598 */     if (Checks.CHECKS) {
/* 599 */       Checks.check(l);
/* 600 */       Checks.check(paramArrayOfint, paramArrayOflong.length);
/*     */     } 
/* 602 */     JNI.callPPV(paramInt, paramArrayOflong, paramArrayOfint, paramArrayOflong.length, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawCommandsStatesNV(@NativeType("GLuint") int paramInt, @NativeType("GLintptr const *") PointerBuffer paramPointerBuffer, @NativeType("GLsizei const *") int[] paramArrayOfint1, @NativeType("GLuint const *") int[] paramArrayOfint2, @NativeType("GLuint const *") int[] paramArrayOfint3) {
/* 607 */     long l = (GL.getICD()).glDrawCommandsStatesNV;
/* 608 */     if (Checks.CHECKS) {
/* 609 */       Checks.check(l);
/* 610 */       Checks.check(paramArrayOfint1, paramPointerBuffer.remaining());
/* 611 */       Checks.check(paramArrayOfint2, paramPointerBuffer.remaining());
/* 612 */       Checks.check(paramArrayOfint3, paramPointerBuffer.remaining());
/*     */     } 
/* 614 */     JNI.callPPPPV(paramInt, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramPointerBuffer.remaining(), l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawCommandsStatesAddressNV(@NativeType("GLuint64 const *") long[] paramArrayOflong, @NativeType("GLsizei const *") int[] paramArrayOfint1, @NativeType("GLuint const *") int[] paramArrayOfint2, @NativeType("GLuint const *") int[] paramArrayOfint3) {
/* 619 */     long l = (GL.getICD()).glDrawCommandsStatesAddressNV;
/* 620 */     if (Checks.CHECKS) {
/* 621 */       Checks.check(l);
/* 622 */       Checks.check(paramArrayOfint1, paramArrayOflong.length);
/* 623 */       Checks.check(paramArrayOfint2, paramArrayOflong.length);
/* 624 */       Checks.check(paramArrayOfint3, paramArrayOflong.length);
/*     */     } 
/* 626 */     JNI.callPPPPV(paramArrayOflong, paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramArrayOflong.length, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glCreateCommandListsNV(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 631 */     long l = (GL.getICD()).glCreateCommandListsNV;
/* 632 */     if (Checks.CHECKS) {
/* 633 */       Checks.check(l);
/*     */     }
/* 635 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteCommandListsNV(@NativeType("GLuint const *") int[] paramArrayOfint) {
/* 640 */     long l = (GL.getICD()).glDeleteCommandListsNV;
/* 641 */     if (Checks.CHECKS) {
/* 642 */       Checks.check(l);
/*     */     }
/* 644 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glListDrawCommandsStatesClientNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("void const **") PointerBuffer paramPointerBuffer, @NativeType("GLsizei const *") int[] paramArrayOfint1, @NativeType("GLuint const *") int[] paramArrayOfint2, @NativeType("GLuint const *") int[] paramArrayOfint3) {
/* 649 */     long l = (GL.getICD()).glListDrawCommandsStatesClientNV;
/* 650 */     if (Checks.CHECKS) {
/* 651 */       Checks.check(l);
/* 652 */       Checks.check(paramArrayOfint1, paramPointerBuffer.remaining());
/* 653 */       Checks.check(paramArrayOfint2, paramPointerBuffer.remaining());
/* 654 */       Checks.check(paramArrayOfint3, paramPointerBuffer.remaining());
/*     */     } 
/* 656 */     JNI.callPPPPV(paramInt1, paramInt2, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramPointerBuffer.remaining(), l);
/*     */   }
/*     */   
/*     */   public static native void nglCreateStatesNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglDeleteStatesNV(int paramInt, long paramLong);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glIsStateNV(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void glStateCaptureNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*     */   
/*     */   @NativeType("GLuint")
/*     */   public static native int glGetCommandHeaderNV(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   @NativeType("GLushort")
/*     */   public static native short glGetStageIndexNV(@NativeType("GLenum") int paramInt);
/*     */   
/*     */   public static native void nglDrawCommandsNV(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3);
/*     */   
/*     */   public static native void nglDrawCommandsAddressNV(int paramInt1, long paramLong1, long paramLong2, int paramInt2);
/*     */   
/*     */   public static native void nglDrawCommandsStatesNV(int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt2);
/*     */   
/*     */   public static native void nglDrawCommandsStatesAddressNV(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt);
/*     */   
/*     */   public static native void nglCreateCommandListsNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglDeleteCommandListsNV(int paramInt, long paramLong);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glIsCommandListNV(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void nglListDrawCommandsStatesClientNV(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt3);
/*     */   
/*     */   public static native void glCommandListSegmentsNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   public static native void glCompileCommandListNV(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void glCallCommandListNV(@NativeType("GLuint") int paramInt);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVCommandList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */