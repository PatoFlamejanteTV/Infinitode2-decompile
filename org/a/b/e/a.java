/*     */ package org.a.b.e;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.EOFException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ {
/*  61 */   private static final int[] a = new int[] { 1, 2, 1 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private byte[] b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int[] c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public a(InputStream paramInputStream) {
/* 101 */     byte[] arrayOfByte = a(paramInputStream);
/* 102 */     a(arrayOfByte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public a(byte[] paramArrayOfbyte) {
/* 112 */     a(paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(byte[] paramArrayOfbyte) {
/* 123 */     ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(paramArrayOfbyte);
/* 124 */     this.b = new byte[paramArrayOfbyte.length - 18];
/* 125 */     this.c = new int[a.length];
/* 126 */     int i = 0;
/* 127 */     for (byte b = 0; b < a.length; b++) {
/*     */       
/* 129 */       if (byteArrayInputStream.read() != 128)
/*     */       {
/* 131 */         throw new IOException("Start marker missing");
/*     */       }
/*     */       
/* 134 */       if (byteArrayInputStream.read() != a[b])
/*     */       {
/* 136 */         throw new IOException("Incorrect record type");
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 142 */       int j = (j = (j = (j = byteArrayInputStream.read()) + (byteArrayInputStream.read() << 8)) + (byteArrayInputStream.read() << 16)) + (byteArrayInputStream.read() << 24);
/* 143 */       this.c[b] = j;
/* 144 */       if (i >= this.b.length)
/*     */       {
/* 146 */         throw new EOFException("attempted to read past EOF");
/*     */       }
/*     */       
/* 149 */       if ((j = byteArrayInputStream.read(this.b, i, j)) < 0)
/*     */       {
/* 151 */         throw new EOFException();
/*     */       }
/* 153 */       i += j;
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
/*     */   private static byte[] a(InputStream paramInputStream) {
/* 166 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 167 */     byte[] arrayOfByte = new byte[65535];
/*     */     int i;
/* 169 */     while ((i = paramInputStream.read(arrayOfByte)) != -1)
/*     */     {
/* 171 */       byteArrayOutputStream.write(arrayOfByte, 0, i);
/*     */     }
/* 173 */     return byteArrayOutputStream.toByteArray();
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
/*     */   public final byte[] a() {
/* 218 */     return Arrays.copyOfRange(this.b, 0, this.c[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final byte[] b() {
/* 227 */     return Arrays.copyOfRange(this.b, this.c[0], this.c[0] + this.c[1]);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */