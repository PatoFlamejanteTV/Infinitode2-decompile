/*     */ package org.a.b.f;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.EOFException;
/*     */ import java.io.InputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class x
/*     */   extends ak
/*     */ {
/*  33 */   private byte[] a = null;
/*  34 */   private int b = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   x(InputStream paramInputStream) {
/*     */     try {
/*  45 */       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(paramInputStream.available());
/*  46 */       byte[] arrayOfByte = new byte[1024];
/*     */       int i;
/*  48 */       while ((i = paramInputStream.read(arrayOfByte)) != -1)
/*     */       {
/*  50 */         byteArrayOutputStream.write(arrayOfByte, 0, i);
/*     */       }
/*  52 */       this.a = byteArrayOutputStream.toByteArray();
/*     */       
/*     */       return;
/*     */     } finally {
/*  56 */       paramInputStream.close();
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
/*     */   public final long a() {
/*  68 */     return (n() << 32L) + (n() & 0xFFFFFFFFL);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int n() {
/*  79 */     int i = b();
/*  80 */     int j = b();
/*  81 */     int k = b();
/*  82 */     int m = b();
/*  83 */     if ((i | j | k | m) < 0)
/*     */     {
/*  85 */       throw new EOFException();
/*     */     }
/*  87 */     return (i << 24) + (j << 16) + (k << 8) + m;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int b() {
/*  98 */     if (this.b >= this.a.length)
/*     */     {
/* 100 */       return -1;
/*     */     }
/* 102 */     byte b = this.a[this.b];
/* 103 */     this.b++;
/* 104 */     return (b + 256) % 256;
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
/*     */   public final int c() {
/* 116 */     int i = b();
/* 117 */     int j = b();
/* 118 */     if ((i | j) < 0)
/*     */     {
/* 120 */       throw new EOFException();
/*     */     }
/* 122 */     return (i << 8) + j;
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
/*     */   public final short d() {
/* 134 */     int i = b();
/* 135 */     int j = b();
/* 136 */     if ((i | j) < 0)
/*     */     {
/* 138 */       throw new EOFException();
/*     */     }
/* 140 */     return (short)((i << 8) + j);
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
/*     */   public final void close() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(long paramLong) {
/* 162 */     this.b = (int)paramLong;
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
/*     */   public final int a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 182 */     if (this.b < this.a.length) {
/*     */       
/* 184 */       paramInt2 = Math.min(paramInt2, this.a.length - this.b);
/* 185 */       System.arraycopy(this.a, this.b, paramArrayOfbyte, paramInt1, paramInt2);
/* 186 */       this.b += paramInt2;
/* 187 */       return paramInt2;
/*     */     } 
/*     */ 
/*     */     
/* 191 */     return -1;
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
/*     */   public final long e() {
/* 203 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final InputStream f() {
/* 212 */     return new ByteArrayInputStream(this.a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final long g() {
/* 221 */     return this.a.length;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\f\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */