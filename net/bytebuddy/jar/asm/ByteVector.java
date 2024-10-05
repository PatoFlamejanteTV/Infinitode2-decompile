/*     */ package net.bytebuddy.jar.asm;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ByteVector
/*     */ {
/*     */   byte[] a;
/*     */   int b;
/*     */   
/*     */   public ByteVector() {
/*  46 */     this.a = new byte[64];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ByteVector(int paramInt) {
/*  55 */     this.a = new byte[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ByteVector(byte[] paramArrayOfbyte) {
/*  64 */     this.a = paramArrayOfbyte;
/*  65 */     this.b = paramArrayOfbyte.length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/*  74 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ByteVector putByte(int paramInt) {
/*     */     int i;
/*  85 */     if ((i = this.b) + 1 > this.a.length) {
/*  86 */       enlarge(1);
/*     */     }
/*  88 */     this.a[i++] = (byte)paramInt;
/*  89 */     this.b = i;
/*  90 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final ByteVector a(int paramInt1, int paramInt2) {
/*     */     int i;
/* 102 */     if ((i = this.b) + 2 > this.a.length) {
/* 103 */       enlarge(2);
/*     */     }
/*     */     byte[] arrayOfByte;
/* 106 */     (arrayOfByte = this.a)[i++] = (byte)paramInt1;
/* 107 */     arrayOfByte[i++] = (byte)paramInt2;
/* 108 */     this.b = i;
/* 109 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ByteVector putShort(int paramInt) {
/*     */     int i;
/* 120 */     if ((i = this.b) + 2 > this.a.length) {
/* 121 */       enlarge(2);
/*     */     }
/*     */     byte[] arrayOfByte;
/* 124 */     (arrayOfByte = this.a)[i++] = (byte)(paramInt >>> 8);
/* 125 */     arrayOfByte[i++] = (byte)paramInt;
/* 126 */     this.b = i;
/* 127 */     return this;
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
/*     */   final ByteVector b(int paramInt1, int paramInt2) {
/*     */     int i;
/* 140 */     if ((i = this.b) + 3 > this.a.length) {
/* 141 */       enlarge(3);
/*     */     }
/*     */     byte[] arrayOfByte;
/* 144 */     (arrayOfByte = this.a)[i++] = (byte)paramInt1;
/* 145 */     arrayOfByte[i++] = (byte)(paramInt2 >>> 8);
/* 146 */     arrayOfByte[i++] = (byte)paramInt2;
/* 147 */     this.b = i;
/* 148 */     return this;
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
/*     */   final ByteVector a(int paramInt1, int paramInt2, int paramInt3) {
/* 162 */     if ((paramInt1 = this.b) + 4 > this.a.length) {
/* 163 */       enlarge(4);
/*     */     }
/*     */     byte[] arrayOfByte;
/* 166 */     (arrayOfByte = this.a)[paramInt1++] = 15;
/* 167 */     arrayOfByte[paramInt1++] = (byte)paramInt2;
/* 168 */     arrayOfByte[paramInt1++] = (byte)(paramInt3 >>> 8);
/* 169 */     arrayOfByte[paramInt1++] = (byte)paramInt3;
/* 170 */     this.b = paramInt1;
/* 171 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ByteVector putInt(int paramInt) {
/*     */     int i;
/* 182 */     if ((i = this.b) + 4 > this.a.length) {
/* 183 */       enlarge(4);
/*     */     }
/*     */     byte[] arrayOfByte;
/* 186 */     (arrayOfByte = this.a)[i++] = (byte)(paramInt >>> 24);
/* 187 */     arrayOfByte[i++] = (byte)(paramInt >>> 16);
/* 188 */     arrayOfByte[i++] = (byte)(paramInt >>> 8);
/* 189 */     arrayOfByte[i++] = (byte)paramInt;
/* 190 */     this.b = i;
/* 191 */     return this;
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
/*     */   final ByteVector b(int paramInt1, int paramInt2, int paramInt3) {
/*     */     int i;
/* 205 */     if ((i = this.b) + 5 > this.a.length) {
/* 206 */       enlarge(5);
/*     */     }
/*     */     byte[] arrayOfByte;
/* 209 */     (arrayOfByte = this.a)[i++] = (byte)paramInt1;
/* 210 */     arrayOfByte[i++] = (byte)(paramInt2 >>> 8);
/* 211 */     arrayOfByte[i++] = (byte)paramInt2;
/* 212 */     arrayOfByte[i++] = (byte)(paramInt3 >>> 8);
/* 213 */     arrayOfByte[i++] = (byte)paramInt3;
/* 214 */     this.b = i;
/* 215 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ByteVector putLong(long paramLong) {
/*     */     int i;
/* 226 */     if ((i = this.b) + 8 > this.a.length) {
/* 227 */       enlarge(8);
/*     */     }
/* 229 */     byte[] arrayOfByte = this.a;
/* 230 */     int j = (int)(paramLong >>> 32L);
/* 231 */     arrayOfByte[i++] = (byte)(j >>> 24);
/* 232 */     arrayOfByte[i++] = (byte)(j >>> 16);
/* 233 */     arrayOfByte[i++] = (byte)(j >>> 8);
/* 234 */     arrayOfByte[i++] = (byte)j;
/* 235 */     j = (int)paramLong;
/* 236 */     arrayOfByte[i++] = (byte)(j >>> 24);
/* 237 */     arrayOfByte[i++] = (byte)(j >>> 16);
/* 238 */     arrayOfByte[i++] = (byte)(j >>> 8);
/* 239 */     arrayOfByte[i++] = (byte)j;
/* 240 */     this.b = i;
/* 241 */     return this;
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
/*     */   public ByteVector putUTF8(String paramString) {
/*     */     int i;
/* 254 */     if ((i = paramString.length()) > 65535) {
/* 255 */       throw new IllegalArgumentException("UTF8 string too large");
/*     */     }
/*     */     int j;
/* 258 */     if ((j = this.b) + 2 + i > this.a.length) {
/* 259 */       enlarge(i + 2);
/*     */     }
/*     */ 
/*     */     
/*     */     byte[] arrayOfByte;
/*     */ 
/*     */     
/* 266 */     (arrayOfByte = this.a)[j++] = (byte)(i >>> 8);
/* 267 */     arrayOfByte[j++] = (byte)i;
/* 268 */     for (byte b = 0; b < i; b++) {
/*     */       char c;
/* 270 */       if ((c = paramString.charAt(b)) > '\000' && c <= '') {
/* 271 */         arrayOfByte[j++] = (byte)c;
/*     */       } else {
/* 273 */         this.b = j;
/* 274 */         return a(paramString, b, 65535);
/*     */       } 
/*     */     } 
/* 277 */     this.b = j;
/* 278 */     return this;
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
/*     */   final ByteVector a(String paramString, int paramInt1, int paramInt2) {
/* 294 */     int i = paramString.length();
/* 295 */     int j = paramInt1; int k;
/* 296 */     for (k = paramInt1; k < i; k++) {
/*     */       char c;
/* 298 */       if ((c = paramString.charAt(k)) > '\000' && c <= '') {
/* 299 */         j++;
/* 300 */       } else if (c <= '߿') {
/* 301 */         j += 2;
/*     */       } else {
/* 303 */         j += 3;
/*     */       } 
/*     */     } 
/* 306 */     if (j > paramInt2) {
/* 307 */       throw new IllegalArgumentException("UTF8 string too large");
/*     */     }
/*     */ 
/*     */     
/* 311 */     if ((k = this.b - paramInt1 - 2) >= 0) {
/* 312 */       this.a[k] = (byte)(j >>> 8);
/* 313 */       this.a[k + 1] = (byte)j;
/*     */     } 
/* 315 */     if (this.b + j - paramInt1 > this.a.length) {
/* 316 */       enlarge(j - paramInt1);
/*     */     }
/* 318 */     int m = this.b;
/* 319 */     for (paramInt1 = paramInt1; paramInt1 < i; paramInt1++) {
/*     */       
/* 321 */       if ((paramInt2 = paramString.charAt(paramInt1)) > 0 && paramInt2 <= 127) {
/* 322 */         this.a[m++] = (byte)paramInt2;
/* 323 */       } else if (paramInt2 <= 2047) {
/* 324 */         this.a[m++] = (byte)(0xC0 | paramInt2 >> 6 & 0x1F);
/* 325 */         this.a[m++] = (byte)(0x80 | paramInt2 & 0x3F);
/*     */       } else {
/* 327 */         this.a[m++] = (byte)(0xE0 | paramInt2 >> 12 & 0xF);
/* 328 */         this.a[m++] = (byte)(0x80 | paramInt2 >> 6 & 0x3F);
/* 329 */         this.a[m++] = (byte)(0x80 | paramInt2 & 0x3F);
/*     */       } 
/*     */     } 
/* 332 */     this.b = m;
/* 333 */     return this;
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
/*     */   public ByteVector putByteArray(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 348 */     if (this.b + paramInt2 > this.a.length) {
/* 349 */       enlarge(paramInt2);
/*     */     }
/* 351 */     if (paramArrayOfbyte != null) {
/* 352 */       System.arraycopy(paramArrayOfbyte, paramInt1, this.a, this.b, paramInt2);
/*     */     }
/* 354 */     this.b += paramInt2;
/* 355 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void enlarge(int paramInt) {
/* 364 */     if (this.b > this.a.length) {
/* 365 */       throw new AssertionError("Internal error");
/*     */     }
/* 367 */     int i = 2 * this.a.length;
/* 368 */     paramInt = this.b + paramInt;
/* 369 */     byte[] arrayOfByte = new byte[(i > paramInt) ? i : paramInt];
/* 370 */     System.arraycopy(this.a, 0, arrayOfByte, 0, this.b);
/* 371 */     this.a = arrayOfByte;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\jar\asm\ByteVector.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */