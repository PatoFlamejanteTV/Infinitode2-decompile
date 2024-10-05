/*     */ package org.a.c.f;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.io.PushbackInputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class d
/*     */   implements k
/*     */ {
/*     */   private final PushbackInputStream a;
/*     */   private int b;
/*     */   
/*     */   d(InputStream paramInputStream) {
/*  39 */     this.a = new PushbackInputStream(paramInputStream, 32767);
/*  40 */     this.b = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int a() {
/*  46 */     int i = this.a.read();
/*  47 */     this.b++;
/*  48 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int a(byte[] paramArrayOfbyte) {
/*     */     int i;
/*  55 */     if ((i = this.a.read(paramArrayOfbyte)) > 0) {
/*     */       
/*  57 */       this.b += i;
/*  58 */       return i;
/*     */     } 
/*     */ 
/*     */     
/*  62 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*     */     int i;
/*  70 */     if ((i = this.a.read(paramArrayOfbyte, paramInt1, paramInt2)) > 0) {
/*     */       
/*  72 */       this.b += i;
/*  73 */       return i;
/*     */     } 
/*     */ 
/*     */     
/*  77 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final long b() {
/*  84 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int c() {
/*     */     int i;
/*  91 */     if ((i = this.a.read()) != -1)
/*     */     {
/*  93 */       this.a.unread(i);
/*     */     }
/*  95 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(int paramInt) {
/* 101 */     this.a.unread(paramInt);
/* 102 */     this.b--;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void b(byte[] paramArrayOfbyte) {
/* 108 */     this.a.unread(paramArrayOfbyte);
/* 109 */     this.b -= paramArrayOfbyte.length;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void b(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 115 */     this.a.unread(paramArrayOfbyte, 0, paramInt2);
/* 116 */     this.b -= paramInt2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final byte[] b(int paramInt) {
/* 122 */     byte[] arrayOfByte = new byte[paramInt];
/* 123 */     int i = 0;
/* 124 */     paramInt = paramInt;
/* 125 */     while (paramInt > 0) {
/*     */       int j;
/*     */       
/* 128 */       if ((j = a(arrayOfByte, i, paramInt)) > 0) {
/*     */         
/* 130 */         i += j;
/* 131 */         paramInt -= j;
/* 132 */         this.b += j;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 139 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean d() {
/* 145 */     return (c() == -1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void close() {
/* 151 */     this.a.close();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\f\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */