/*     */ package com.a.a.b.c;
/*     */ 
/*     */ import java.io.CharConversionException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class l
/*     */   extends Reader
/*     */ {
/*     */   private a a;
/*     */   private InputStream b;
/*     */   private byte[] c;
/*     */   private int d;
/*     */   private int e;
/*     */   private boolean f;
/*  37 */   private char g = Character.MIN_VALUE;
/*     */ 
/*     */ 
/*     */   
/*     */   private int h;
/*     */ 
/*     */ 
/*     */   
/*     */   private int i;
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean j;
/*     */ 
/*     */ 
/*     */   
/*     */   private char[] k;
/*     */ 
/*     */ 
/*     */   
/*     */   public l(a parama, InputStream paramInputStream, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, boolean paramBoolean) {
/*  58 */     this.a = parama;
/*  59 */     this.b = paramInputStream;
/*  60 */     this.c = paramArrayOfbyte;
/*  61 */     this.d = paramInt1;
/*  62 */     this.e = paramInt2;
/*  63 */     this.f = paramBoolean;
/*  64 */     this.j = (paramInputStream != null);
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
/*     */   public final void close() {
/*     */     InputStream inputStream;
/*  77 */     if ((inputStream = this.b) != null) {
/*  78 */       this.b = null;
/*  79 */       a();
/*  80 */       inputStream.close();
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
/*     */   public final int read() {
/*  93 */     if (this.k == null) {
/*  94 */       this.k = new char[1];
/*     */     }
/*  96 */     if (read(this.k, 0, 1) <= 0) {
/*  97 */       return -1;
/*     */     }
/*  99 */     return this.k[0];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int read(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 106 */     if (this.c == null) return -1; 
/* 107 */     if (paramInt2 <= 0) return paramInt2;
/*     */     
/* 109 */     if (paramInt1 < 0 || paramInt1 + paramInt2 > paramArrayOfchar.length) {
/* 110 */       a(paramArrayOfchar, paramInt1, paramInt2);
/*     */     }
/*     */     
/* 113 */     int i = paramInt1;
/* 114 */     paramInt2 += paramInt1;
/*     */ 
/*     */     
/* 117 */     if (this.g != '\000') {
/* 118 */       i++; paramArrayOfchar[paramInt1] = this.g;
/* 119 */       this.g = Character.MIN_VALUE;
/*     */     } else {
/*     */       int m;
/*     */ 
/*     */ 
/*     */       
/* 125 */       if ((m = this.e - this.d) < 4 && 
/* 126 */         !a(m)) {
/*     */         
/* 128 */         if (m == 0) {
/* 129 */           return -1;
/*     */         }
/* 131 */         a(this.e - this.d, 4);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 137 */     int j = this.e - 4;
/*     */ 
/*     */     
/* 140 */     while (i < paramInt2 && this.d <= j) {
/* 141 */       int n, i1, m = this.d;
/*     */ 
/*     */       
/* 144 */       if (this.f) {
/* 145 */         n = this.c[m] << 8 | this.c[m + 1] & 0xFF;
/* 146 */         i1 = (this.c[m + 2] & 0xFF) << 8 | this.c[m + 3] & 0xFF;
/*     */       } else {
/* 148 */         i1 = this.c[m] & 0xFF | (this.c[m + 1] & 0xFF) << 8;
/* 149 */         n = this.c[m + 2] & 0xFF | this.c[m + 3] << 8;
/*     */       } 
/* 151 */       this.d += 4;
/*     */ 
/*     */ 
/*     */       
/* 155 */       if (n != 0) {
/*     */         
/* 157 */         m = (n = n & 0xFFFF) - 1 << 16 | i1;
/* 158 */         if (n > 16) {
/* 159 */           a(m, i - paramInt1, 
/* 160 */               String.format(" (above 0x%08x)", new Object[] { Integer.valueOf(1114111) }));
/*     */         }
/* 162 */         paramArrayOfchar[i++] = (char)(55296 + (m >> 10));
/*     */         
/* 164 */         i1 = 0xDC00 | m & 0x3FF;
/*     */         
/* 166 */         if (i >= paramInt2) {
/* 167 */           this.g = (char)m;
/*     */           break;
/*     */         } 
/*     */       } 
/* 171 */       paramArrayOfchar[i++] = (char)i1;
/*     */     } 
/* 173 */     int k = i - paramInt1;
/* 174 */     this.h += k;
/* 175 */     return k;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(int paramInt1, int paramInt2) {
/* 185 */     paramInt2 = this.i + paramInt1; int i = this.h;
/*     */     
/* 187 */     throw new CharConversionException("Unexpected EOF in the middle of a 4-byte UTF-32 char: got " + paramInt1 + ", needed 4" + ", at char #" + i + ", byte #" + paramInt2 + ")");
/*     */   }
/*     */   
/*     */   private void a(int paramInt1, int paramInt2, String paramString) {
/* 191 */     int i = this.i + this.d - 1; paramInt2 = this.h + paramInt2;
/*     */     
/* 193 */     throw new CharConversionException("Invalid UTF-32 character 0x" + Integer.toHexString(paramInt1) + paramString + " at char #" + paramInt2 + ", byte #" + i + ")");
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
/*     */   private boolean a(int paramInt) {
/* 208 */     if (this.b == null || this.c == null) {
/* 209 */       return false;
/*     */     }
/*     */     
/* 212 */     this.i += this.e - paramInt;
/*     */ 
/*     */     
/* 215 */     if (paramInt > 0) {
/* 216 */       if (this.d > 0) {
/* 217 */         System.arraycopy(this.c, this.d, this.c, 0, paramInt);
/* 218 */         this.d = 0;
/*     */       } 
/* 220 */       this.e = paramInt;
/*     */     }
/*     */     else {
/*     */       
/* 224 */       this.d = 0;
/*     */       
/* 226 */       if ((paramInt = this.b.read(this.c)) <= 0) {
/* 227 */         this.e = 0;
/* 228 */         if (paramInt < 0) {
/* 229 */           if (this.j) {
/* 230 */             a();
/*     */           }
/* 232 */           return false;
/*     */         } 
/*     */         
/* 235 */         b();
/*     */       } 
/* 237 */       this.e = paramInt;
/*     */     } 
/*     */ 
/*     */     
/* 241 */     while (this.e < 4) {
/*     */       
/* 243 */       if ((paramInt = this.b.read(this.c, this.e, this.c.length - this.e)) <= 0) {
/* 244 */         if (paramInt < 0) {
/* 245 */           if (this.j) {
/* 246 */             a();
/*     */           }
/* 248 */           a(this.e, 4);
/*     */         } 
/*     */         
/* 251 */         b();
/*     */       } 
/* 253 */       this.e += paramInt;
/*     */     } 
/* 255 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a() {
/*     */     byte[] arrayOfByte;
/* 265 */     if ((arrayOfByte = this.c) != null) {
/* 266 */       this.c = null;
/* 267 */       if (this.a != null) {
/* 268 */         this.a.a(arrayOfByte);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void a(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 274 */     throw new ArrayIndexOutOfBoundsException(String.format("read(buf,%d,%d), cbuf[%d]", new Object[] {
/*     */             
/* 276 */             Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramArrayOfchar.length) }));
/*     */   }
/*     */   
/*     */   private static void b() {
/* 280 */     throw new IOException("Strange I/O stream, returned 0 bytes on read");
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\c\l.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */