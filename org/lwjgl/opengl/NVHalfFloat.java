/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.system.Checks;
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
/*     */ public class NVHalfFloat
/*     */ {
/*     */   public static final int GL_HALF_FLOAT_NV = 5131;
/*     */   
/*     */   static {
/*  30 */     GL.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected NVHalfFloat() {
/*  40 */     throw new UnsupportedOperationException();
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
/*     */   public static void glVertex2hvNV(@NativeType("GLhalfNV const *") ShortBuffer paramShortBuffer) {
/*  52 */     if (Checks.CHECKS) {
/*  53 */       Checks.check(paramShortBuffer, 2);
/*     */     }
/*  55 */     nglVertex2hvNV(MemoryUtil.memAddress(paramShortBuffer));
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
/*     */   public static void glVertex3hvNV(@NativeType("GLhalfNV const *") ShortBuffer paramShortBuffer) {
/*  67 */     if (Checks.CHECKS) {
/*  68 */       Checks.check(paramShortBuffer, 3);
/*     */     }
/*  70 */     nglVertex3hvNV(MemoryUtil.memAddress(paramShortBuffer));
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
/*     */   public static void glVertex4hvNV(@NativeType("GLhalfNV const *") ShortBuffer paramShortBuffer) {
/*  82 */     if (Checks.CHECKS) {
/*  83 */       Checks.check(paramShortBuffer, 4);
/*     */     }
/*  85 */     nglVertex4hvNV(MemoryUtil.memAddress(paramShortBuffer));
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
/*     */   public static void glNormal3hvNV(@NativeType("GLhalfNV const *") ShortBuffer paramShortBuffer) {
/*  97 */     if (Checks.CHECKS) {
/*  98 */       Checks.check(paramShortBuffer, 3);
/*     */     }
/* 100 */     nglNormal3hvNV(MemoryUtil.memAddress(paramShortBuffer));
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
/*     */   public static void glColor3hvNV(@NativeType("GLhalfNV const *") ShortBuffer paramShortBuffer) {
/* 112 */     if (Checks.CHECKS) {
/* 113 */       Checks.check(paramShortBuffer, 3);
/*     */     }
/* 115 */     nglColor3hvNV(MemoryUtil.memAddress(paramShortBuffer));
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
/*     */   public static void glColor4hvNV(@NativeType("GLhalfNV const *") ShortBuffer paramShortBuffer) {
/* 127 */     if (Checks.CHECKS) {
/* 128 */       Checks.check(paramShortBuffer, 4);
/*     */     }
/* 130 */     nglColor4hvNV(MemoryUtil.memAddress(paramShortBuffer));
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
/*     */   public static void glTexCoord1hvNV(@NativeType("GLhalfNV const *") ShortBuffer paramShortBuffer) {
/* 142 */     if (Checks.CHECKS) {
/* 143 */       Checks.check(paramShortBuffer, 1);
/*     */     }
/* 145 */     nglTexCoord1hvNV(MemoryUtil.memAddress(paramShortBuffer));
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
/*     */   public static void glTexCoord2hvNV(@NativeType("GLhalfNV const *") ShortBuffer paramShortBuffer) {
/* 157 */     if (Checks.CHECKS) {
/* 158 */       Checks.check(paramShortBuffer, 2);
/*     */     }
/* 160 */     nglTexCoord2hvNV(MemoryUtil.memAddress(paramShortBuffer));
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
/*     */   public static void glTexCoord3hvNV(@NativeType("GLhalfNV const *") ShortBuffer paramShortBuffer) {
/* 172 */     if (Checks.CHECKS) {
/* 173 */       Checks.check(paramShortBuffer, 3);
/*     */     }
/* 175 */     nglTexCoord3hvNV(MemoryUtil.memAddress(paramShortBuffer));
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
/*     */   public static void glTexCoord4hvNV(@NativeType("GLhalfNV const *") ShortBuffer paramShortBuffer) {
/* 187 */     if (Checks.CHECKS) {
/* 188 */       Checks.check(paramShortBuffer, 4);
/*     */     }
/* 190 */     nglTexCoord4hvNV(MemoryUtil.memAddress(paramShortBuffer));
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
/*     */   public static void glMultiTexCoord1hvNV(@NativeType("GLenum") int paramInt, @NativeType("GLhalfNV const *") ShortBuffer paramShortBuffer) {
/* 202 */     if (Checks.CHECKS) {
/* 203 */       Checks.check(paramShortBuffer, 1);
/*     */     }
/* 205 */     nglMultiTexCoord1hvNV(paramInt, MemoryUtil.memAddress(paramShortBuffer));
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
/*     */   public static void glMultiTexCoord2hvNV(@NativeType("GLenum") int paramInt, @NativeType("GLhalfNV const *") ShortBuffer paramShortBuffer) {
/* 217 */     if (Checks.CHECKS) {
/* 218 */       Checks.check(paramShortBuffer, 2);
/*     */     }
/* 220 */     nglMultiTexCoord2hvNV(paramInt, MemoryUtil.memAddress(paramShortBuffer));
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
/*     */   public static void glMultiTexCoord3hvNV(@NativeType("GLenum") int paramInt, @NativeType("GLhalfNV const *") ShortBuffer paramShortBuffer) {
/* 232 */     if (Checks.CHECKS) {
/* 233 */       Checks.check(paramShortBuffer, 3);
/*     */     }
/* 235 */     nglMultiTexCoord3hvNV(paramInt, MemoryUtil.memAddress(paramShortBuffer));
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
/*     */   public static void glMultiTexCoord4hvNV(@NativeType("GLenum") int paramInt, @NativeType("GLhalfNV const *") ShortBuffer paramShortBuffer) {
/* 247 */     if (Checks.CHECKS) {
/* 248 */       Checks.check(paramShortBuffer, 4);
/*     */     }
/* 250 */     nglMultiTexCoord4hvNV(paramInt, MemoryUtil.memAddress(paramShortBuffer));
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
/*     */   public static void glFogCoordhvNV(@NativeType("GLhalfNV const *") ShortBuffer paramShortBuffer) {
/* 262 */     if (Checks.CHECKS) {
/* 263 */       Checks.check(paramShortBuffer, 1);
/*     */     }
/* 265 */     nglFogCoordhvNV(MemoryUtil.memAddress(paramShortBuffer));
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
/*     */   public static void glSecondaryColor3hvNV(@NativeType("GLhalfNV const *") ShortBuffer paramShortBuffer) {
/* 277 */     if (Checks.CHECKS) {
/* 278 */       Checks.check(paramShortBuffer, 3);
/*     */     }
/* 280 */     nglSecondaryColor3hvNV(MemoryUtil.memAddress(paramShortBuffer));
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
/*     */   public static void glVertexWeighthvNV(@NativeType("GLhalfNV const *") ShortBuffer paramShortBuffer) {
/* 292 */     if (Checks.CHECKS) {
/* 293 */       Checks.check(paramShortBuffer, 1);
/*     */     }
/* 295 */     nglVertexWeighthvNV(MemoryUtil.memAddress(paramShortBuffer));
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
/*     */   public static void glVertexAttrib1hvNV(@NativeType("GLuint") int paramInt, @NativeType("GLhalfNV const *") ShortBuffer paramShortBuffer) {
/* 307 */     if (Checks.CHECKS) {
/* 308 */       Checks.check(paramShortBuffer, 1);
/*     */     }
/* 310 */     nglVertexAttrib1hvNV(paramInt, MemoryUtil.memAddress(paramShortBuffer));
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
/*     */   public static void glVertexAttrib2hvNV(@NativeType("GLuint") int paramInt, @NativeType("GLhalfNV const *") ShortBuffer paramShortBuffer) {
/* 322 */     if (Checks.CHECKS) {
/* 323 */       Checks.check(paramShortBuffer, 2);
/*     */     }
/* 325 */     nglVertexAttrib2hvNV(paramInt, MemoryUtil.memAddress(paramShortBuffer));
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
/*     */   public static void glVertexAttrib3hvNV(@NativeType("GLuint") int paramInt, @NativeType("GLhalfNV const *") ShortBuffer paramShortBuffer) {
/* 337 */     if (Checks.CHECKS) {
/* 338 */       Checks.check(paramShortBuffer, 3);
/*     */     }
/* 340 */     nglVertexAttrib3hvNV(paramInt, MemoryUtil.memAddress(paramShortBuffer));
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
/*     */   public static void glVertexAttrib4hvNV(@NativeType("GLuint") int paramInt, @NativeType("GLhalfNV const *") ShortBuffer paramShortBuffer) {
/* 352 */     if (Checks.CHECKS) {
/* 353 */       Checks.check(paramShortBuffer, 4);
/*     */     }
/* 355 */     nglVertexAttrib4hvNV(paramInt, MemoryUtil.memAddress(paramShortBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribs1hvNV(@NativeType("GLuint") int paramInt, @NativeType("GLhalfNV const *") ShortBuffer paramShortBuffer) {
/* 363 */     nglVertexAttribs1hvNV(paramInt, paramShortBuffer.remaining(), MemoryUtil.memAddress(paramShortBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribs2hvNV(@NativeType("GLuint") int paramInt, @NativeType("GLhalfNV const *") ShortBuffer paramShortBuffer) {
/* 371 */     nglVertexAttribs2hvNV(paramInt, paramShortBuffer.remaining() >> 1, MemoryUtil.memAddress(paramShortBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribs3hvNV(@NativeType("GLuint") int paramInt, @NativeType("GLhalfNV const *") ShortBuffer paramShortBuffer) {
/* 379 */     nglVertexAttribs3hvNV(paramInt, paramShortBuffer.remaining() / 3, MemoryUtil.memAddress(paramShortBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribs4hvNV(@NativeType("GLuint") int paramInt, @NativeType("GLhalfNV const *") ShortBuffer paramShortBuffer) {
/* 387 */     nglVertexAttribs4hvNV(paramInt, paramShortBuffer.remaining() >> 2, MemoryUtil.memAddress(paramShortBuffer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertex2hvNV(@NativeType("GLhalfNV const *") short[] paramArrayOfshort) {
/* 392 */     long l = (GL.getICD()).glVertex2hvNV;
/* 393 */     if (Checks.CHECKS) {
/* 394 */       Checks.check(l);
/* 395 */       Checks.check(paramArrayOfshort, 2);
/*     */     } 
/* 397 */     JNI.callPV(paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertex3hvNV(@NativeType("GLhalfNV const *") short[] paramArrayOfshort) {
/* 402 */     long l = (GL.getICD()).glVertex3hvNV;
/* 403 */     if (Checks.CHECKS) {
/* 404 */       Checks.check(l);
/* 405 */       Checks.check(paramArrayOfshort, 3);
/*     */     } 
/* 407 */     JNI.callPV(paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertex4hvNV(@NativeType("GLhalfNV const *") short[] paramArrayOfshort) {
/* 412 */     long l = (GL.getICD()).glVertex4hvNV;
/* 413 */     if (Checks.CHECKS) {
/* 414 */       Checks.check(l);
/* 415 */       Checks.check(paramArrayOfshort, 4);
/*     */     } 
/* 417 */     JNI.callPV(paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glNormal3hvNV(@NativeType("GLhalfNV const *") short[] paramArrayOfshort) {
/* 422 */     long l = (GL.getICD()).glNormal3hvNV;
/* 423 */     if (Checks.CHECKS) {
/* 424 */       Checks.check(l);
/* 425 */       Checks.check(paramArrayOfshort, 3);
/*     */     } 
/* 427 */     JNI.callPV(paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glColor3hvNV(@NativeType("GLhalfNV const *") short[] paramArrayOfshort) {
/* 432 */     long l = (GL.getICD()).glColor3hvNV;
/* 433 */     if (Checks.CHECKS) {
/* 434 */       Checks.check(l);
/* 435 */       Checks.check(paramArrayOfshort, 3);
/*     */     } 
/* 437 */     JNI.callPV(paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glColor4hvNV(@NativeType("GLhalfNV const *") short[] paramArrayOfshort) {
/* 442 */     long l = (GL.getICD()).glColor4hvNV;
/* 443 */     if (Checks.CHECKS) {
/* 444 */       Checks.check(l);
/* 445 */       Checks.check(paramArrayOfshort, 4);
/*     */     } 
/* 447 */     JNI.callPV(paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexCoord1hvNV(@NativeType("GLhalfNV const *") short[] paramArrayOfshort) {
/* 452 */     long l = (GL.getICD()).glTexCoord1hvNV;
/* 453 */     if (Checks.CHECKS) {
/* 454 */       Checks.check(l);
/* 455 */       Checks.check(paramArrayOfshort, 1);
/*     */     } 
/* 457 */     JNI.callPV(paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexCoord2hvNV(@NativeType("GLhalfNV const *") short[] paramArrayOfshort) {
/* 462 */     long l = (GL.getICD()).glTexCoord2hvNV;
/* 463 */     if (Checks.CHECKS) {
/* 464 */       Checks.check(l);
/* 465 */       Checks.check(paramArrayOfshort, 2);
/*     */     } 
/* 467 */     JNI.callPV(paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexCoord3hvNV(@NativeType("GLhalfNV const *") short[] paramArrayOfshort) {
/* 472 */     long l = (GL.getICD()).glTexCoord3hvNV;
/* 473 */     if (Checks.CHECKS) {
/* 474 */       Checks.check(l);
/* 475 */       Checks.check(paramArrayOfshort, 3);
/*     */     } 
/* 477 */     JNI.callPV(paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexCoord4hvNV(@NativeType("GLhalfNV const *") short[] paramArrayOfshort) {
/* 482 */     long l = (GL.getICD()).glTexCoord4hvNV;
/* 483 */     if (Checks.CHECKS) {
/* 484 */       Checks.check(l);
/* 485 */       Checks.check(paramArrayOfshort, 4);
/*     */     } 
/* 487 */     JNI.callPV(paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord1hvNV(@NativeType("GLenum") int paramInt, @NativeType("GLhalfNV const *") short[] paramArrayOfshort) {
/* 492 */     long l = (GL.getICD()).glMultiTexCoord1hvNV;
/* 493 */     if (Checks.CHECKS) {
/* 494 */       Checks.check(l);
/* 495 */       Checks.check(paramArrayOfshort, 1);
/*     */     } 
/* 497 */     JNI.callPV(paramInt, paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord2hvNV(@NativeType("GLenum") int paramInt, @NativeType("GLhalfNV const *") short[] paramArrayOfshort) {
/* 502 */     long l = (GL.getICD()).glMultiTexCoord2hvNV;
/* 503 */     if (Checks.CHECKS) {
/* 504 */       Checks.check(l);
/* 505 */       Checks.check(paramArrayOfshort, 2);
/*     */     } 
/* 507 */     JNI.callPV(paramInt, paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord3hvNV(@NativeType("GLenum") int paramInt, @NativeType("GLhalfNV const *") short[] paramArrayOfshort) {
/* 512 */     long l = (GL.getICD()).glMultiTexCoord3hvNV;
/* 513 */     if (Checks.CHECKS) {
/* 514 */       Checks.check(l);
/* 515 */       Checks.check(paramArrayOfshort, 3);
/*     */     } 
/* 517 */     JNI.callPV(paramInt, paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord4hvNV(@NativeType("GLenum") int paramInt, @NativeType("GLhalfNV const *") short[] paramArrayOfshort) {
/* 522 */     long l = (GL.getICD()).glMultiTexCoord4hvNV;
/* 523 */     if (Checks.CHECKS) {
/* 524 */       Checks.check(l);
/* 525 */       Checks.check(paramArrayOfshort, 4);
/*     */     } 
/* 527 */     JNI.callPV(paramInt, paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glFogCoordhvNV(@NativeType("GLhalfNV const *") short[] paramArrayOfshort) {
/* 532 */     long l = (GL.getICD()).glFogCoordhvNV;
/* 533 */     if (Checks.CHECKS) {
/* 534 */       Checks.check(l);
/* 535 */       Checks.check(paramArrayOfshort, 1);
/*     */     } 
/* 537 */     JNI.callPV(paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSecondaryColor3hvNV(@NativeType("GLhalfNV const *") short[] paramArrayOfshort) {
/* 542 */     long l = (GL.getICD()).glSecondaryColor3hvNV;
/* 543 */     if (Checks.CHECKS) {
/* 544 */       Checks.check(l);
/* 545 */       Checks.check(paramArrayOfshort, 3);
/*     */     } 
/* 547 */     JNI.callPV(paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexWeighthvNV(@NativeType("GLhalfNV const *") short[] paramArrayOfshort) {
/* 552 */     long l = (GL.getICD()).glVertexWeighthvNV;
/* 553 */     if (Checks.CHECKS) {
/* 554 */       Checks.check(l);
/* 555 */       Checks.check(paramArrayOfshort, 1);
/*     */     } 
/* 557 */     JNI.callPV(paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib1hvNV(@NativeType("GLuint") int paramInt, @NativeType("GLhalfNV const *") short[] paramArrayOfshort) {
/* 562 */     long l = (GL.getICD()).glVertexAttrib1hvNV;
/* 563 */     if (Checks.CHECKS) {
/* 564 */       Checks.check(l);
/* 565 */       Checks.check(paramArrayOfshort, 1);
/*     */     } 
/* 567 */     JNI.callPV(paramInt, paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib2hvNV(@NativeType("GLuint") int paramInt, @NativeType("GLhalfNV const *") short[] paramArrayOfshort) {
/* 572 */     long l = (GL.getICD()).glVertexAttrib2hvNV;
/* 573 */     if (Checks.CHECKS) {
/* 574 */       Checks.check(l);
/* 575 */       Checks.check(paramArrayOfshort, 2);
/*     */     } 
/* 577 */     JNI.callPV(paramInt, paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib3hvNV(@NativeType("GLuint") int paramInt, @NativeType("GLhalfNV const *") short[] paramArrayOfshort) {
/* 582 */     long l = (GL.getICD()).glVertexAttrib3hvNV;
/* 583 */     if (Checks.CHECKS) {
/* 584 */       Checks.check(l);
/* 585 */       Checks.check(paramArrayOfshort, 3);
/*     */     } 
/* 587 */     JNI.callPV(paramInt, paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib4hvNV(@NativeType("GLuint") int paramInt, @NativeType("GLhalfNV const *") short[] paramArrayOfshort) {
/* 592 */     long l = (GL.getICD()).glVertexAttrib4hvNV;
/* 593 */     if (Checks.CHECKS) {
/* 594 */       Checks.check(l);
/* 595 */       Checks.check(paramArrayOfshort, 4);
/*     */     } 
/* 597 */     JNI.callPV(paramInt, paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribs1hvNV(@NativeType("GLuint") int paramInt, @NativeType("GLhalfNV const *") short[] paramArrayOfshort) {
/* 602 */     long l = (GL.getICD()).glVertexAttribs1hvNV;
/* 603 */     if (Checks.CHECKS) {
/* 604 */       Checks.check(l);
/*     */     }
/* 606 */     JNI.callPV(paramInt, paramArrayOfshort.length, paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribs2hvNV(@NativeType("GLuint") int paramInt, @NativeType("GLhalfNV const *") short[] paramArrayOfshort) {
/* 611 */     long l = (GL.getICD()).glVertexAttribs2hvNV;
/* 612 */     if (Checks.CHECKS) {
/* 613 */       Checks.check(l);
/*     */     }
/* 615 */     JNI.callPV(paramInt, paramArrayOfshort.length >> 1, paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribs3hvNV(@NativeType("GLuint") int paramInt, @NativeType("GLhalfNV const *") short[] paramArrayOfshort) {
/* 620 */     long l = (GL.getICD()).glVertexAttribs3hvNV;
/* 621 */     if (Checks.CHECKS) {
/* 622 */       Checks.check(l);
/*     */     }
/* 624 */     JNI.callPV(paramInt, paramArrayOfshort.length / 3, paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribs4hvNV(@NativeType("GLuint") int paramInt, @NativeType("GLhalfNV const *") short[] paramArrayOfshort) {
/* 629 */     long l = (GL.getICD()).glVertexAttribs4hvNV;
/* 630 */     if (Checks.CHECKS) {
/* 631 */       Checks.check(l);
/*     */     }
/* 633 */     JNI.callPV(paramInt, paramArrayOfshort.length >> 2, paramArrayOfshort, l);
/*     */   }
/*     */   
/*     */   public static native void glVertex2hNV(@NativeType("GLhalfNV") short paramShort1, @NativeType("GLhalfNV") short paramShort2);
/*     */   
/*     */   public static native void nglVertex2hvNV(long paramLong);
/*     */   
/*     */   public static native void glVertex3hNV(@NativeType("GLhalfNV") short paramShort1, @NativeType("GLhalfNV") short paramShort2, @NativeType("GLhalfNV") short paramShort3);
/*     */   
/*     */   public static native void nglVertex3hvNV(long paramLong);
/*     */   
/*     */   public static native void glVertex4hNV(@NativeType("GLhalfNV") short paramShort1, @NativeType("GLhalfNV") short paramShort2, @NativeType("GLhalfNV") short paramShort3, @NativeType("GLhalfNV") short paramShort4);
/*     */   
/*     */   public static native void nglVertex4hvNV(long paramLong);
/*     */   
/*     */   public static native void glNormal3hNV(@NativeType("GLhalfNV") short paramShort1, @NativeType("GLhalfNV") short paramShort2, @NativeType("GLhalfNV") short paramShort3);
/*     */   
/*     */   public static native void nglNormal3hvNV(long paramLong);
/*     */   
/*     */   public static native void glColor3hNV(@NativeType("GLhalfNV") short paramShort1, @NativeType("GLhalfNV") short paramShort2, @NativeType("GLhalfNV") short paramShort3);
/*     */   
/*     */   public static native void nglColor3hvNV(long paramLong);
/*     */   
/*     */   public static native void glColor4hNV(@NativeType("GLhalfNV") short paramShort1, @NativeType("GLhalfNV") short paramShort2, @NativeType("GLhalfNV") short paramShort3, @NativeType("GLhalfNV") short paramShort4);
/*     */   
/*     */   public static native void nglColor4hvNV(long paramLong);
/*     */   
/*     */   public static native void glTexCoord1hNV(@NativeType("GLhalfNV") short paramShort);
/*     */   
/*     */   public static native void nglTexCoord1hvNV(long paramLong);
/*     */   
/*     */   public static native void glTexCoord2hNV(@NativeType("GLhalfNV") short paramShort1, @NativeType("GLhalfNV") short paramShort2);
/*     */   
/*     */   public static native void nglTexCoord2hvNV(long paramLong);
/*     */   
/*     */   public static native void glTexCoord3hNV(@NativeType("GLhalfNV") short paramShort1, @NativeType("GLhalfNV") short paramShort2, @NativeType("GLhalfNV") short paramShort3);
/*     */   
/*     */   public static native void nglTexCoord3hvNV(long paramLong);
/*     */   
/*     */   public static native void glTexCoord4hNV(@NativeType("GLhalfNV") short paramShort1, @NativeType("GLhalfNV") short paramShort2, @NativeType("GLhalfNV") short paramShort3, @NativeType("GLhalfNV") short paramShort4);
/*     */   
/*     */   public static native void nglTexCoord4hvNV(long paramLong);
/*     */   
/*     */   public static native void glMultiTexCoord1hNV(@NativeType("GLenum") int paramInt, @NativeType("GLhalfNV") short paramShort);
/*     */   
/*     */   public static native void nglMultiTexCoord1hvNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glMultiTexCoord2hNV(@NativeType("GLenum") int paramInt, @NativeType("GLhalfNV") short paramShort1, @NativeType("GLhalfNV") short paramShort2);
/*     */   
/*     */   public static native void nglMultiTexCoord2hvNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glMultiTexCoord3hNV(@NativeType("GLenum") int paramInt, @NativeType("GLhalfNV") short paramShort1, @NativeType("GLhalfNV") short paramShort2, @NativeType("GLhalfNV") short paramShort3);
/*     */   
/*     */   public static native void nglMultiTexCoord3hvNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glMultiTexCoord4hNV(@NativeType("GLenum") int paramInt, @NativeType("GLhalfNV") short paramShort1, @NativeType("GLhalfNV") short paramShort2, @NativeType("GLhalfNV") short paramShort3, @NativeType("GLhalfNV") short paramShort4);
/*     */   
/*     */   public static native void nglMultiTexCoord4hvNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glFogCoordhNV(@NativeType("GLhalfNV") short paramShort);
/*     */   
/*     */   public static native void nglFogCoordhvNV(long paramLong);
/*     */   
/*     */   public static native void glSecondaryColor3hNV(@NativeType("GLhalfNV") short paramShort1, @NativeType("GLhalfNV") short paramShort2, @NativeType("GLhalfNV") short paramShort3);
/*     */   
/*     */   public static native void nglSecondaryColor3hvNV(long paramLong);
/*     */   
/*     */   public static native void glVertexWeighthNV(@NativeType("GLhalfNV") short paramShort);
/*     */   
/*     */   public static native void nglVertexWeighthvNV(long paramLong);
/*     */   
/*     */   public static native void glVertexAttrib1hNV(@NativeType("GLuint") int paramInt, @NativeType("GLhalfNV") short paramShort);
/*     */   
/*     */   public static native void nglVertexAttrib1hvNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glVertexAttrib2hNV(@NativeType("GLuint") int paramInt, @NativeType("GLhalfNV") short paramShort1, @NativeType("GLhalfNV") short paramShort2);
/*     */   
/*     */   public static native void nglVertexAttrib2hvNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glVertexAttrib3hNV(@NativeType("GLuint") int paramInt, @NativeType("GLhalfNV") short paramShort1, @NativeType("GLhalfNV") short paramShort2, @NativeType("GLhalfNV") short paramShort3);
/*     */   
/*     */   public static native void nglVertexAttrib3hvNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glVertexAttrib4hNV(@NativeType("GLuint") int paramInt, @NativeType("GLhalfNV") short paramShort1, @NativeType("GLhalfNV") short paramShort2, @NativeType("GLhalfNV") short paramShort3, @NativeType("GLhalfNV") short paramShort4);
/*     */   
/*     */   public static native void nglVertexAttrib4hvNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribs1hvNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribs2hvNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribs3hvNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribs4hvNV(int paramInt1, int paramInt2, long paramLong);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVHalfFloat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */