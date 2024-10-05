/*     */ package org.a.c.c;
/*     */ 
/*     */ import java.io.FilterInputStream;
/*     */ import java.io.IOException;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class b
/*     */   extends FilterInputStream
/*     */ {
/*     */   private int a;
/*     */   private int b;
/*     */   private boolean c;
/*     */   private byte[] d;
/*     */   private byte[] e;
/*     */   
/*     */   b(InputStream paramInputStream) {
/*  53 */     super(paramInputStream);
/*  54 */     this.a = 0;
/*  55 */     this.b = 0;
/*  56 */     this.c = false;
/*  57 */     this.d = new byte[5];
/*  58 */     this.e = new byte[4];
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
/*     */   public final int read() {
/*  71 */     if (this.a >= this.b) {
/*     */       byte b2;
/*  73 */       if (this.c)
/*     */       {
/*  75 */         return -1;
/*     */       }
/*  77 */       this.a = 0;
/*     */ 
/*     */       
/*     */       byte b1;
/*     */       
/*     */       do {
/*  83 */         if ((b2 = (byte)this.in.read()) == -1)
/*     */         {
/*  85 */           this.c = true;
/*  86 */           return -1;
/*     */         }
/*     */       
/*  89 */       } while ((b1 = (byte)b2) == 10 || b1 == 13 || b1 == 32);
/*     */       
/*  91 */       if (b1 == 126) {
/*     */         
/*  93 */         this.c = true;
/*  94 */         this.d = this.e = null;
/*  95 */         this.b = 0;
/*  96 */         return -1;
/*     */       } 
/*  98 */       if (b1 == 122) {
/*     */         
/* 100 */         this.e[3] = 0; this.e[2] = 0; this.e[1] = 0; this.e[0] = 0;
/* 101 */         this.b = 4;
/*     */       }
/*     */       else {
/*     */         
/* 105 */         this.d[0] = b1; byte b3;
/* 106 */         for (b3 = 1; b3 < 5;) {
/*     */ 
/*     */           
/*     */           while (true) {
/*     */             
/* 111 */             if ((b2 = (byte)this.in.read()) == -1) {
/*     */               
/* 113 */               this.c = true;
/* 114 */               return -1;
/*     */             } 
/*     */             
/* 117 */             if ((b1 = (byte)b2) != 10 && b1 != 13 && b1 != 32) {
/* 118 */               this.d[b3] = b1;
/* 119 */               if (b1 == 126) {
/*     */ 
/*     */                 
/* 122 */                 this.d[b3] = 117; break;
/*     */               }  b3++;
/*     */             } 
/*     */           } 
/* 126 */         }  this.b = b3 - 1;
/* 127 */         if (this.b == 0) {
/*     */           
/* 129 */           this.c = true;
/* 130 */           this.d = null;
/* 131 */           this.e = null;
/* 132 */           return -1;
/*     */         } 
/* 134 */         if (b3 < 5) {
/*     */           
/* 136 */           for (; ++b3 < 5; b3++)
/*     */           {
/*     */             
/* 139 */             this.d[b3] = 117;
/*     */           }
/* 141 */           this.c = true;
/*     */         } 
/*     */         
/* 144 */         long l = 0L;
/* 145 */         for (b3 = 0; b3 < 5; b3++) {
/*     */ 
/*     */           
/* 148 */           if ((b1 = (byte)(this.d[b3] - 33)) < 0 || b1 > 93) {
/*     */             
/* 150 */             this.b = 0;
/* 151 */             this.c = true;
/* 152 */             this.d = null;
/* 153 */             this.e = null;
/* 154 */             throw new IOException("Invalid data in Ascii85 stream");
/*     */           } 
/* 156 */           l = l * 85L + b1;
/*     */         } 
/* 158 */         for (b3 = 3; b3 >= 0; b3--) {
/*     */           
/* 160 */           this.e[b3] = (byte)(int)(l & 0xFFL);
/* 161 */           l >>>= 8L;
/*     */         } 
/*     */       } 
/*     */     } 
/* 165 */     return this.e[this.a++] & 0xFF;
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
/*     */   public final int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 182 */     if (this.c && this.a >= this.b)
/*     */     {
/* 184 */       return -1;
/*     */     }
/* 186 */     for (byte b1 = 0; b1 < paramInt2; b1++) {
/*     */       
/* 188 */       if (this.a < this.b) {
/*     */         
/* 190 */         paramArrayOfbyte[b1 + paramInt1] = this.e[this.a++];
/*     */       } else {
/*     */         int i;
/*     */ 
/*     */         
/* 195 */         if ((i = read()) == -1)
/*     */         {
/* 197 */           return b1;
/*     */         }
/* 199 */         paramArrayOfbyte[b1 + paramInt1] = (byte)i;
/*     */       } 
/*     */     } 
/* 202 */     return paramInt2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void close() {
/* 213 */     this.d = null;
/* 214 */     this.c = true;
/* 215 */     this.e = null;
/* 216 */     super.close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean markSupported() {
/* 227 */     return false;
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
/*     */   public final long skip(long paramLong) {
/* 240 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int available() {
/* 251 */     return 0;
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
/*     */   public final void mark(int paramInt) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void reset() {
/* 272 */     throw new IOException("Reset is not supported");
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */