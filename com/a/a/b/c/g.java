/*     */ package com.a.a.b.c;
/*     */ 
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
/*     */ public final class g
/*     */   extends InputStream
/*     */ {
/*     */   private final a a;
/*     */   private final InputStream b;
/*     */   private byte[] c;
/*     */   private int d;
/*     */   private final int e;
/*     */   
/*     */   public g(a parama, InputStream paramInputStream, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  26 */     this.a = parama;
/*  27 */     this.b = paramInputStream;
/*  28 */     this.c = paramArrayOfbyte;
/*  29 */     this.d = paramInt1;
/*  30 */     this.e = paramInt2;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int available() {
/*  35 */     if (this.c != null) {
/*  36 */       return this.e - this.d;
/*     */     }
/*  38 */     return this.b.available();
/*     */   }
/*     */   
/*     */   public final void close() {
/*  42 */     a();
/*  43 */     this.b.close();
/*     */   }
/*     */   
/*     */   public final synchronized void mark(int paramInt) {
/*  47 */     if (this.c == null) this.b.mark(paramInt);
/*     */   
/*     */   }
/*     */   
/*     */   public final boolean markSupported() {
/*  52 */     return (this.c == null && this.b.markSupported());
/*     */   }
/*     */   
/*     */   public final int read() {
/*  56 */     if (this.c != null) {
/*  57 */       int i = this.c[this.d++] & 0xFF;
/*  58 */       if (this.d >= this.e) {
/*  59 */         a();
/*     */       }
/*  61 */       return i;
/*     */     } 
/*  63 */     return this.b.read();
/*     */   }
/*     */   
/*     */   public final int read(byte[] paramArrayOfbyte) {
/*  67 */     return read(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */   
/*     */   public final int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  72 */     if (this.c != null) {
/*  73 */       int i = this.e - this.d;
/*  74 */       if (paramInt2 > i) {
/*  75 */         paramInt2 = i;
/*     */       }
/*  77 */       System.arraycopy(this.c, this.d, paramArrayOfbyte, paramInt1, paramInt2);
/*  78 */       this.d += paramInt2;
/*  79 */       if (this.d >= this.e) {
/*  80 */         a();
/*     */       }
/*  82 */       return paramInt2;
/*     */     } 
/*  84 */     return this.b.read(paramArrayOfbyte, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public final synchronized void reset() {
/*  89 */     if (this.c == null) this.b.reset();
/*     */   
/*     */   }
/*     */   
/*     */   public final long skip(long paramLong) {
/*  94 */     long l = 0L;
/*     */     
/*  96 */     if (this.c != null) {
/*     */       int i;
/*     */       
/*  99 */       if ((i = this.e - this.d) > paramLong) {
/* 100 */         this.d += (int)paramLong;
/* 101 */         return paramLong;
/*     */       } 
/* 103 */       a();
/* 104 */       l = 0L + i;
/* 105 */       paramLong -= i;
/*     */     } 
/*     */     
/* 108 */     if (paramLong > 0L) l += this.b.skip(paramLong); 
/* 109 */     return l;
/*     */   }
/*     */   
/*     */   private void a() {
/*     */     byte[] arrayOfByte;
/* 114 */     if ((arrayOfByte = this.c) != null) {
/* 115 */       this.c = null;
/* 116 */       if (this.a != null)
/* 117 */         this.a.a(arrayOfByte); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\c\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */