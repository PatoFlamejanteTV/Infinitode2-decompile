/*     */ package com.a.a.b.g;
/*     */ 
/*     */ import java.io.OutputStream;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class c
/*     */   extends OutputStream
/*     */ {
/*  31 */   private static byte[] a = new byte[0];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  44 */   private final LinkedList<byte[]> b = (LinkedList)new LinkedList<>();
/*     */   
/*     */   private int c;
/*     */   private byte[] d;
/*     */   private int e;
/*     */   
/*     */   public c() {
/*  51 */     this((a)null); }
/*  52 */   private c(a parama) { this(parama, 500); } public c(int paramInt) {
/*  53 */     this(null, 100);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private c(a parama, int paramInt) {
/*  59 */     if (paramInt > 131072) {
/*  60 */       paramInt = 131072;
/*     */     }
/*  62 */     this.d = (parama == null) ? new byte[paramInt] : parama.a(2);
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
/*     */   public final void a() {
/*  76 */     this.c = 0;
/*  77 */     this.e = 0;
/*     */     
/*  79 */     if (!this.b.isEmpty()) {
/*  80 */       this.b.clear();
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
/*     */   public final void a(int paramInt) {
/* 107 */     if (this.e >= this.d.length) {
/* 108 */       c();
/*     */     }
/* 110 */     this.d[this.e++] = (byte)paramInt;
/*     */   }
/*     */   
/*     */   public final void b(int paramInt) {
/* 114 */     if (this.e + 1 < this.d.length) {
/* 115 */       this.d[this.e++] = (byte)(paramInt >> 8);
/* 116 */       this.d[this.e++] = (byte)paramInt; return;
/*     */     } 
/* 118 */     a(paramInt >> 8);
/* 119 */     a(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void c(int paramInt) {
/* 124 */     if (this.e + 2 < this.d.length) {
/* 125 */       this.d[this.e++] = (byte)(paramInt >> 16);
/* 126 */       this.d[this.e++] = (byte)(paramInt >> 8);
/* 127 */       this.d[this.e++] = (byte)paramInt; return;
/*     */     } 
/* 129 */     a(paramInt >> 16);
/* 130 */     a(paramInt >> 8);
/* 131 */     a(paramInt);
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
/*     */   public final byte[] b() {
/*     */     int i;
/* 160 */     if ((i = this.c + this.e) == 0) {
/* 161 */       return a;
/*     */     }
/* 163 */     byte[] arrayOfByte = new byte[i];
/* 164 */     int j = 0;
/*     */     
/* 166 */     for (Iterator<byte> iterator = this.b.iterator(); iterator.hasNext(); ) {
/* 167 */       byte[] arrayOfByte1; int k = (arrayOfByte1 = (byte[])iterator.next()).length;
/* 168 */       System.arraycopy(arrayOfByte1, 0, arrayOfByte, j, k);
/* 169 */       j += k;
/*     */     } 
/* 171 */     System.arraycopy(this.d, 0, arrayOfByte, j, this.e);
/*     */     
/* 173 */     if ((j = j + this.e) != i) {
/* 174 */       throw new RuntimeException("Internal error: total len assumed to be " + i + ", copied " + j + " bytes");
/*     */     }
/*     */     
/* 177 */     if (!this.b.isEmpty()) {
/* 178 */       a();
/*     */     }
/* 180 */     return arrayOfByte;
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
/*     */   public final void write(byte[] paramArrayOfbyte) {
/* 238 */     write(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*     */     while (true) {
/*     */       int i;
/* 247 */       if ((i = Math.min(i = this.d.length - this.e, paramInt2)) > 0) {
/* 248 */         System.arraycopy(paramArrayOfbyte, paramInt1, this.d, this.e, i);
/* 249 */         paramInt1 += i;
/* 250 */         this.e += i;
/* 251 */         paramInt2 -= i;
/*     */       } 
/* 253 */       if (paramInt2 > 0) {
/* 254 */         c();
/*     */         continue;
/*     */       } 
/*     */       break;
/*     */     } 
/*     */   } public final void write(int paramInt) {
/* 260 */     a(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void close() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void flush() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void c() {
/*     */     int i;
/* 278 */     if ((i = this.c + this.d.length) < 0) {
/* 279 */       throw new IllegalStateException("Maximum Java array size (2GB) exceeded by `ByteArrayBuilder`");
/*     */     }
/*     */     
/* 282 */     this.c = i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 292 */     if ((i = Math.max(this.c >> 1, 1000)) > 131072) {
/* 293 */       i = 131072;
/*     */     }
/* 295 */     this.b.add(this.d);
/* 296 */     this.d = new byte[i];
/* 297 */     this.e = 0;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\g\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */