/*     */ package org.a.c.f;
/*     */ 
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.OutputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class c
/*     */   extends BufferedOutputStream
/*     */ {
/*     */   private boolean a = false;
/*     */   private boolean b = false;
/*  39 */   private int c = 0;
/*     */   
/*     */   private boolean d = true;
/*     */   
/*     */   c(OutputStream paramOutputStream) {
/*  44 */     super(paramOutputStream);
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
/*     */   public final void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  60 */     if (this.c == 0 && paramInt2 > 10) {
/*     */ 
/*     */       
/*  63 */       this.d = false;
/*  64 */       for (byte b = 0; b < 10; b++) {
/*     */ 
/*     */         
/*  67 */         if (paramArrayOfbyte[b] < 9 || (paramArrayOfbyte[b] > 10 && paramArrayOfbyte[b] < 32 && paramArrayOfbyte[b] != 13)) {
/*     */ 
/*     */           
/*  70 */           this.d = true;
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/*  75 */     if (this.d) {
/*     */ 
/*     */       
/*  78 */       if (this.a) {
/*     */ 
/*     */         
/*  81 */         this.a = false;
/*  82 */         if (!this.b && paramInt2 == 1 && paramArrayOfbyte[paramInt1] == 10) {
/*     */           return;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  89 */         write(13);
/*     */       } 
/*  91 */       if (this.b) {
/*     */         
/*  93 */         write(10);
/*  94 */         this.b = false;
/*     */       } 
/*     */       
/*  97 */       if (paramInt2 > 0)
/*     */       {
/*  99 */         if (paramArrayOfbyte[paramInt1 + paramInt2 - 1] == 13) {
/*     */           
/* 101 */           this.a = true;
/* 102 */           paramInt2--;
/*     */         }
/* 104 */         else if (paramArrayOfbyte[paramInt1 + paramInt2 - 1] == 10) {
/*     */           
/* 106 */           this.b = true;
/* 107 */           paramInt2--;
/* 108 */           if (paramInt2 > 0 && paramArrayOfbyte[paramInt1 + paramInt2 - 1] == 13) {
/*     */             
/* 110 */             this.a = true;
/* 111 */             paramInt2--;
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/* 116 */     super.write(paramArrayOfbyte, paramInt1, paramInt2);
/* 117 */     this.c += paramInt2;
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
/*     */   public final void flush() {
/* 130 */     if (this.a && !this.b) {
/*     */       
/* 132 */       write(13);
/* 133 */       this.c++;
/*     */     } 
/* 135 */     this.a = false;
/* 136 */     this.b = false;
/* 137 */     super.flush();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\f\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */