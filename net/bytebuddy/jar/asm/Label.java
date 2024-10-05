/*     */ package net.bytebuddy.jar.asm;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Label
/*     */ {
/* 130 */   static final Label a = new Label();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object info;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   short b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private short lineNumber;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int[] otherLineNumbers;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int[] forwardReferences;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   short d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   short e;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   short f;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   short g;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Frame h;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Label i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Edge j;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Label k;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getOffset() {
/* 302 */     if ((this.b & 0x4) == 0) {
/* 303 */       throw new IllegalStateException("Label offset position has not been resolved yet");
/*     */     }
/* 305 */     return this.c;
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
/*     */   final Label a() {
/* 322 */     return (this.h == null) ? this : this.h.a;
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
/*     */   final void a(int paramInt) {
/* 335 */     if (this.lineNumber == 0) {
/* 336 */       this.lineNumber = (short)paramInt; return;
/*     */     } 
/* 338 */     if (this.otherLineNumbers == null) {
/* 339 */       this.otherLineNumbers = new int[4];
/*     */     }
/* 341 */     this.otherLineNumbers[0] = this.otherLineNumbers[0] + 1; int i;
/* 342 */     if ((i = this.otherLineNumbers[0] + 1) >= this.otherLineNumbers.length) {
/* 343 */       int[] arrayOfInt = new int[this.otherLineNumbers.length + 4];
/* 344 */       System.arraycopy(this.otherLineNumbers, 0, arrayOfInt, 0, this.otherLineNumbers.length);
/* 345 */       this.otherLineNumbers = arrayOfInt;
/*     */     } 
/* 347 */     this.otherLineNumbers[i] = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final void a(MethodVisitor paramMethodVisitor, boolean paramBoolean) {
/* 358 */     paramMethodVisitor.visitLabel(this);
/* 359 */     if (paramBoolean && this.lineNumber != 0) {
/* 360 */       paramMethodVisitor.visitLineNumber(this.lineNumber & 0xFFFF, this);
/* 361 */       if (this.otherLineNumbers != null) {
/* 362 */         for (paramBoolean = true; paramBoolean <= this.otherLineNumbers[0]; paramBoolean++) {
/* 363 */           paramMethodVisitor.visitLineNumber(this.otherLineNumbers[paramBoolean], this);
/*     */         }
/*     */       }
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
/*     */   final void a(ByteVector paramByteVector, int paramInt, boolean paramBoolean) {
/* 386 */     if ((this.b & 0x4) == 0) {
/* 387 */       if (paramBoolean) {
/* 388 */         addForwardReference(paramInt, 536870912, paramByteVector.b);
/* 389 */         paramByteVector.putInt(-1); return;
/*     */       } 
/* 391 */       addForwardReference(paramInt, 268435456, paramByteVector.b);
/* 392 */       paramByteVector.putShort(-1);
/*     */       return;
/*     */     } 
/* 395 */     if (paramBoolean) {
/* 396 */       paramByteVector.putInt(this.c - paramInt); return;
/*     */     } 
/* 398 */     paramByteVector.putShort(this.c - paramInt);
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
/*     */   private void addForwardReference(int paramInt1, int paramInt2, int paramInt3) {
/* 417 */     if (this.forwardReferences == null) {
/* 418 */       this.forwardReferences = new int[6];
/*     */     }
/*     */     int i;
/* 421 */     if ((i = this.forwardReferences[0]) + 2 >= this.forwardReferences.length) {
/* 422 */       int[] arrayOfInt = new int[this.forwardReferences.length + 6];
/* 423 */       System.arraycopy(this.forwardReferences, 0, arrayOfInt, 0, this.forwardReferences.length);
/* 424 */       this.forwardReferences = arrayOfInt;
/*     */     } 
/* 426 */     this.forwardReferences[++i] = paramInt1;
/* 427 */     this.forwardReferences[++i] = paramInt2 | paramInt3;
/* 428 */     this.forwardReferences[0] = i;
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
/*     */   final boolean a(byte[] paramArrayOfbyte, int paramInt) {
/* 446 */     this.b = (short)(this.b | 0x4);
/* 447 */     this.c = paramInt;
/* 448 */     if (this.forwardReferences == null) {
/* 449 */       return false;
/*     */     }
/* 451 */     int i = 0;
/* 452 */     for (int j = this.forwardReferences[0]; j > 0; j -= 2) {
/* 453 */       int k = this.forwardReferences[j - 1];
/* 454 */       int m = this.forwardReferences[j];
/* 455 */       int n = paramInt - k;
/* 456 */       int i1 = m & 0xFFFFFFF;
/* 457 */       if ((m & 0xF0000000) == 268435456) {
/* 458 */         if (n < -32768 || n > 32767) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 464 */           if ((i = paramArrayOfbyte[k] & 0xFF) < 198) {
/*     */             
/* 466 */             paramArrayOfbyte[k] = (byte)(i + 49);
/*     */           } else {
/*     */             
/* 469 */             paramArrayOfbyte[k] = (byte)(i + 20);
/*     */           } 
/* 471 */           i = 1;
/*     */         } 
/* 473 */         paramArrayOfbyte[i1++] = (byte)(n >>> 8);
/* 474 */         paramArrayOfbyte[i1] = (byte)n;
/*     */       } else {
/* 476 */         paramArrayOfbyte[i1++] = (byte)(n >>> 24);
/* 477 */         paramArrayOfbyte[i1++] = (byte)(n >>> 16);
/* 478 */         paramArrayOfbyte[i1++] = (byte)(n >>> 8);
/* 479 */         paramArrayOfbyte[i1] = (byte)n;
/*     */       } 
/*     */     } 
/* 482 */     return i;
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
/*     */   final void a(short paramShort) {
/*     */     Label label;
/* 507 */     (label = this).k = a;
/* 508 */     while (label != a) {
/*     */       
/* 510 */       Label label1 = label;
/* 511 */       label = label.k;
/* 512 */       label1.k = null;
/*     */ 
/*     */ 
/*     */       
/* 516 */       if (label1.g == 0) {
/* 517 */         label1.g = paramShort;
/* 518 */         label = label1.pushSuccessors(label);
/*     */       } 
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
/*     */   final void a(Label paramLabel) {
/* 542 */     Label label1 = a;
/*     */     Label label2;
/* 544 */     (label2 = this).k = a;
/* 545 */     while (label2 != a) {
/*     */       Label label;
/*     */       
/* 548 */       label2 = (label = label2).k;
/* 549 */       label.k = label1;
/* 550 */       label1 = label;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 555 */       if ((label.b & 0x40) != 0 && label.g != paramLabel.g)
/*     */       {
/* 557 */         label.j = new Edge(label.e, paramLabel.j.b, label.j);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 570 */       label2 = label.pushSuccessors(label2);
/*     */     } 
/*     */ 
/*     */     
/* 574 */     while (label1 != a) {
/* 575 */       Label label = label1.k;
/* 576 */       label1.k = null;
/* 577 */       label1 = label;
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
/*     */   private Label pushSuccessors(Label paramLabel) {
/* 591 */     paramLabel = paramLabel;
/* 592 */     Edge edge = this.j;
/* 593 */     while (edge != null) {
/*     */       boolean bool;
/*     */ 
/*     */ 
/*     */       
/* 598 */       if (!(bool = ((this.b & 0x10) != 0 && edge == this.j.c) ? true : false) && edge.b.k == null) {
/*     */ 
/*     */         
/* 601 */         edge.b.k = paramLabel;
/* 602 */         paramLabel = edge.b;
/*     */       } 
/* 604 */       edge = edge.c;
/*     */     } 
/* 606 */     return paramLabel;
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
/*     */   public String toString() {
/* 620 */     return "L" + System.identityHashCode(this);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\jar\asm\Label.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */