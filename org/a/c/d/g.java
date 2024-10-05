/*     */ package org.a.c.d;
/*     */ 
/*     */ import java.io.Closeable;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.RandomAccessFile;
/*     */ import java.util.BitSet;
/*     */ import org.a.a.a.a;
/*     */ import org.a.a.a.c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class g
/*     */   implements Closeable
/*     */ {
/*  53 */   private static final a a = c.a(g.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  62 */   private final Object b = new Object();
/*     */   
/*     */   private final File c;
/*     */   
/*     */   private File d;
/*     */   private RandomAccessFile e;
/*  68 */   private volatile int f = 0;
/*  69 */   private final BitSet g = new BitSet();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private volatile byte[][] h;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int j;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean k;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean l;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private volatile boolean m = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public g(a parama) {
/* 110 */     this.l = (!parama.b() || parama.d());
/* 111 */     this.k = this.l ? parama.c() : false;
/* 112 */     this.c = this.k ? parama.h() : null;
/*     */     
/* 114 */     if (this.c != null && !this.c.isDirectory())
/*     */     {
/* 116 */       throw new IOException("Scratch file directory does not exist: " + this.c);
/*     */     }
/*     */     
/* 119 */     this
/* 120 */       .j = parama.e() ? (int)Math.min(2147483647L, parama.g() / 4096L) : Integer.MAX_VALUE;
/*     */ 
/*     */     
/* 123 */     this
/*     */       
/* 125 */       .i = parama.b() ? (parama.d() ? (int)Math.min(2147483647L, parama.f() / 4096L) : Integer.MAX_VALUE) : 0;
/*     */ 
/*     */     
/* 128 */     this.h = new byte[this.l ? this.i : 100000][];
/*     */     
/* 130 */     this.g.set(0, this.h.length);
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
/*     */   public static g a() {
/*     */     try {
/* 143 */       return new g(a.a());
/*     */     }
/* 145 */     catch (IOException iOException) {
/*     */ 
/*     */       
/* 148 */       (new StringBuilder("Unexpected exception occurred creating main memory scratch file instance: ")).append(iOException.getMessage());
/* 149 */       return null;
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
/*     */   final int b() {
/* 161 */     synchronized (this.g) {
/*     */       int i;
/*     */ 
/*     */       
/* 165 */       if ((i = this.g.nextSetBit(0)) < 0) {
/*     */         
/* 167 */         e();
/*     */ 
/*     */         
/* 170 */         if ((i = this.g.nextSetBit(0)) < 0)
/*     */         {
/* 172 */           throw new IOException("Maximum allowed scratch file memory exceeded.");
/*     */         }
/*     */       } 
/*     */       
/* 176 */       this.g.clear(i);
/*     */       
/* 178 */       if (i >= this.f)
/*     */       {
/* 180 */         this.f = i + 1;
/*     */       }
/*     */       
/* 183 */       return i;
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
/*     */   private void e() {
/* 203 */     synchronized (this.b) {
/*     */       
/* 205 */       c();
/*     */       
/* 207 */       if (this.f >= this.j) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/* 212 */       if (this.k) {
/*     */ 
/*     */         
/* 215 */         if (this.e == null) {
/*     */           
/* 217 */           this.d = File.createTempFile("PDFBox", ".tmp", this.c);
/*     */           
/*     */           try {
/* 220 */             this.e = new RandomAccessFile(this.d, "rw");
/*     */           }
/* 222 */           catch (IOException iOException) {
/*     */             
/* 224 */             if (!this.d.delete())
/*     */             {
/* 226 */               (new StringBuilder("Error deleting scratch file: ")).append(this.d.getAbsolutePath());
/*     */             }
/* 228 */             throw iOException;
/*     */           } 
/*     */         } 
/*     */         
/* 232 */         long l1 = this.e.length();
/*     */         
/*     */         long l2;
/* 235 */         if ((l2 = this.f - this.i << 12L) != l1)
/*     */         {
/* 237 */           throw new IOException("Expected scratch file size of " + l2 + " but found " + l1);
/*     */         }
/*     */ 
/*     */         
/* 241 */         if (this.f + 16 > this.f)
/*     */         {
/* 243 */           l1 += 65536L;
/*     */           
/* 245 */           this.e.setLength(l1);
/*     */           
/* 247 */           this.g.set(this.f, this.f + 16);
/*     */         }
/*     */       
/* 250 */       } else if (!this.l) {
/*     */         int i;
/*     */         
/*     */         int j;
/*     */         
/* 255 */         if ((j = (int)Math.min((i = this.h.length) << 1L, 2147483647L)) > i) {
/*     */           
/* 257 */           byte[][] arrayOfByte = new byte[j][];
/* 258 */           System.arraycopy(this.h, 0, arrayOfByte, 0, i);
/* 259 */           this.h = arrayOfByte;
/*     */           
/* 261 */           this.g.set(i, j);
/*     */         } 
/*     */       } 
/*     */       return;
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
/*     */   final byte[] a(int paramInt) {
/* 288 */     if (paramInt < 0 || paramInt >= this.f) {
/*     */       
/* 290 */       c();
/* 291 */       throw new IOException("Page index out of range: " + paramInt + ". Max value: " + (this.f - 1));
/*     */     } 
/*     */ 
/*     */     
/* 295 */     if (paramInt < this.i) {
/*     */       byte[] arrayOfByte;
/*     */ 
/*     */ 
/*     */       
/* 300 */       if ((arrayOfByte = this.h[paramInt]) == null) {
/*     */         
/* 302 */         c();
/* 303 */         throw new IOException("Requested page with index " + paramInt + " was not written before.");
/*     */       } 
/*     */       
/* 306 */       return arrayOfByte;
/*     */     } 
/*     */     
/* 309 */     synchronized (this.b) {
/*     */       
/* 311 */       if (this.e == null) {
/*     */         
/* 313 */         c();
/* 314 */         throw new IOException("Missing scratch file to read page with index " + paramInt + " from.");
/*     */       } 
/*     */       
/* 317 */       byte[] arrayOfByte = new byte[4096];
/* 318 */       this.e.seek(paramInt - this.i << 12L);
/* 319 */       this.e.readFully(arrayOfByte);
/*     */       
/* 321 */       return arrayOfByte;
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
/*     */   final void a(int paramInt, byte[] paramArrayOfbyte) {
/* 340 */     if (paramInt < 0 || paramInt >= this.f) {
/*     */       
/* 342 */       c();
/* 343 */       throw new IOException("Page index out of range: " + paramInt + ". Max value: " + (this.f - 1));
/*     */     } 
/*     */     
/* 346 */     if (paramArrayOfbyte.length != 4096)
/*     */     {
/* 348 */       throw new IOException("Wrong page size to write: " + paramArrayOfbyte.length + ". Expected: 4096");
/*     */     }
/*     */     
/* 351 */     if (paramInt < this.i) {
/*     */       
/* 353 */       if (this.l) {
/*     */         
/* 355 */         this.h[paramInt] = paramArrayOfbyte;
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 360 */         synchronized (this.b) {
/*     */           
/* 362 */           this.h[paramInt] = paramArrayOfbyte;
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 367 */       c();
/*     */       
/*     */       return;
/*     */     } 
/* 371 */     synchronized (this.b) {
/*     */       
/* 373 */       c();
/* 374 */       this.e.seek(paramInt - this.i << 12L);
/* 375 */       this.e.write(paramArrayOfbyte);
/*     */       return;
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
/*     */   final void c() {
/* 388 */     if (this.m)
/*     */     {
/* 390 */       throw new IOException("Scratch file already closed");
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
/*     */   public final e d() {
/* 403 */     return new h(this);
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
/*     */   final void a(int[] paramArrayOfint, int paramInt1, int paramInt2) {
/* 439 */     synchronized (this.g) {
/*     */       
/* 441 */       for (byte b = 0; b < paramInt2; b++) {
/*     */         int i;
/*     */         
/* 444 */         if ((i = paramArrayOfint[b]) >= 0 && i < this.f && !this.g.get(i)) {
/*     */           
/* 446 */           this.g.set(i);
/* 447 */           if (i < this.i)
/*     */           {
/* 449 */             this.h[i] = null;
/*     */           }
/*     */         } 
/*     */       } 
/*     */       return;
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
/*     */   public void close() {
/* 468 */     null = null;
/*     */     
/* 470 */     synchronized (this.b) {
/*     */       
/* 472 */       if (this.m) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/* 477 */       this.m = true;
/*     */       
/* 479 */       if (this.e != null) {
/*     */         
/*     */         try {
/*     */           
/* 483 */           this.e.close();
/*     */         }
/* 485 */         catch (IOException iOException) {
/*     */           
/* 487 */           null = null = null;
/*     */         } 
/*     */       }
/*     */       
/* 491 */       if (this.d != null)
/*     */       {
/* 493 */         if (!this.d.delete())
/*     */         {
/* 495 */           if (this.d.exists() && null == null)
/*     */           {
/* 497 */             null = new IOException("Error deleting scratch file: " + this.d.getAbsolutePath());
/*     */           }
/*     */         }
/*     */       }
/*     */     } 
/*     */     
/* 503 */     synchronized (this.g) {
/*     */       
/* 505 */       this.g.clear();
/* 506 */       this.f = 0;
/*     */     } 
/*     */     
/* 509 */     if (SYNTHETIC_LOCAL_VARIABLE_1 != null)
/*     */     {
/* 511 */       throw SYNTHETIC_LOCAL_VARIABLE_1;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\d\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */