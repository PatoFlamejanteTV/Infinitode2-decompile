/*     */ package org.a.c.h.c;
/*     */ 
/*     */ import java.io.InputStream;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ final class i
/*     */ {
/*  39 */   private final int[] a = new int[256];
/*     */ 
/*     */   
/*     */   private int b;
/*     */ 
/*     */   
/*     */   private int c;
/*     */ 
/*     */   
/*     */   public final void a(byte[] paramArrayOfbyte) {
/*  49 */     this.b = 0;
/*  50 */     this.c = 0;
/*     */     
/*  52 */     if (paramArrayOfbyte.length <= 0 || paramArrayOfbyte.length > 32)
/*     */     {
/*  54 */       throw new IllegalArgumentException("number of bytes must be between 1 and 32"); } 
/*     */     int j;
/*  56 */     for (j = 0; j < this.a.length; j++)
/*     */     {
/*  58 */       this.a[j] = j;
/*     */     }
/*     */     
/*  61 */     j = 0;
/*  62 */     int k = 0;
/*  63 */     for (byte b = 0; b < this.a.length; b++) {
/*     */       
/*  65 */       k = (a(paramArrayOfbyte[j]) + this.a[b] + k) % 256;
/*  66 */       a(this.a, b, k);
/*  67 */       j = (j + 1) % paramArrayOfbyte.length;
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
/*     */   private static int a(byte paramByte) {
/*  81 */     return (paramByte < 0) ? (paramByte + 256) : paramByte;
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
/*     */   private static void a(int[] paramArrayOfint, int paramInt1, int paramInt2) {
/*  93 */     int j = paramArrayOfint[paramInt1];
/*  94 */     paramArrayOfint[paramInt1] = paramArrayOfint[paramInt2];
/*  95 */     paramArrayOfint[paramInt2] = j;
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
/*     */   private void a(byte paramByte, OutputStream paramOutputStream) {
/* 108 */     this.b = (this.b + 1) % 256;
/* 109 */     this.c = (this.a[this.b] + this.c) % 256;
/* 110 */     a(this.a, this.b, this.c);
/* 111 */     int j = (this.a[this.b] + this.a[this.c]) % 256;
/* 112 */     paramOutputStream.write(paramByte ^ (byte)this.a[j]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(byte[] paramArrayOfbyte, OutputStream paramOutputStream) {
/*     */     int j;
/*     */     byte b;
/* 125 */     for (j = (paramArrayOfbyte = paramArrayOfbyte).length, b = 0; b < j; ) { byte b1 = paramArrayOfbyte[b];
/*     */       
/* 127 */       a(b1, paramOutputStream);
/*     */       b++; }
/*     */   
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
/*     */   public final void a(InputStream paramInputStream, OutputStream paramOutputStream) {
/* 141 */     byte[] arrayOfByte = new byte[1024];
/*     */     int j;
/* 143 */     while ((j = paramInputStream.read(arrayOfByte)) != -1)
/*     */     {
/* 145 */       a(arrayOfByte, 0, j, paramOutputStream);
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
/*     */   private void a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, OutputStream paramOutputStream) {
/* 161 */     for (paramInt1 = 0; paramInt1 < paramInt2 + 0; paramInt1++)
/*     */     {
/* 163 */       a(paramArrayOfbyte[paramInt1], paramOutputStream);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\c\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */