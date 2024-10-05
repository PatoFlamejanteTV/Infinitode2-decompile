/*     */ package org.a.b.f;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.RandomAccessFile;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class a
/*     */   extends RandomAccessFile
/*     */ {
/*     */   private final byte[] a;
/*  40 */   private int b = 0;
/*  41 */   private int c = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  46 */   private long d = 0L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int e;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public a(File paramFile, String paramString, int paramInt) {
/*  88 */     super(paramFile, paramString);
/*  89 */     this.e = 16384;
/*  90 */     this.a = new byte[this.e];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int read() {
/*  99 */     if (this.c >= this.b && a() < 0)
/*     */     {
/* 101 */       return -1;
/*     */     }
/* 103 */     if (this.b == 0)
/*     */     {
/* 105 */       return -1;
/*     */     }
/*     */     
/* 108 */     return this.a[this.c++] + 256 & 0xFF;
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
/*     */   private int a() {
/*     */     int i;
/* 124 */     if ((i = super.read(this.a, 0, this.e)) >= 0) {
/*     */       
/* 126 */       this.d += i;
/* 127 */       this.b = i;
/* 128 */       this.c = 0;
/*     */     } 
/* 130 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void b() {
/* 140 */     this.b = 0;
/* 141 */     this.c = 0;
/* 142 */     this.d = super.getFilePointer();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 151 */     int i = this.b - this.c;
/* 152 */     if (paramInt2 <= i) {
/*     */       
/* 154 */       System.arraycopy(this.a, this.c, paramArrayOfbyte, paramInt1, paramInt2);
/* 155 */       this.c += paramInt2;
/* 156 */       return paramInt2;
/*     */     } 
/* 158 */     System.arraycopy(this.a, this.c, paramArrayOfbyte, paramInt1, i);
/* 159 */     this.c += i;
/* 160 */     if (a() > 0) {
/*     */       int j;
/*     */       
/* 163 */       if ((j = read(paramArrayOfbyte, paramInt1 + i, paramInt2 - i)) > 0)
/*     */       {
/* 165 */         i += j;
/*     */       }
/*     */     } 
/* 168 */     return (i > 0) ? i : -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final long getFilePointer() {
/* 177 */     return this.d - this.b + this.c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void seek(long paramLong) {
/*     */     int i;
/* 187 */     if ((i = (int)(this.d - paramLong)) >= 0 && i <= this.b) {
/*     */       
/* 189 */       this.c = this.b - i;
/*     */       
/*     */       return;
/*     */     } 
/* 193 */     super.seek(paramLong);
/* 194 */     b();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */