/*     */ package com.c.a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class e
/*     */ {
/*     */   public byte[] a;
/*     */   private int b;
/*     */   private int c;
/*     */   private int d;
/*     */   private int e;
/*     */   private int f;
/*     */   private int g;
/*     */   
/*     */   public final int a() {
/*  57 */     this.a = null;
/*  58 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int a(int paramInt) {
/*  63 */     if (this.d != 0) {
/*  64 */       this.c -= this.d;
/*  65 */       if (this.c > 0) {
/*  66 */         System.arraycopy(this.a, this.d, this.a, 0, this.c);
/*     */       }
/*  68 */       this.d = 0;
/*     */     } 
/*     */     
/*  71 */     if (512 > this.b - this.c) {
/*     */       
/*  73 */       paramInt = 512 + this.c + 4096;
/*  74 */       if (this.a != null) {
/*  75 */         byte[] arrayOfByte = new byte[paramInt];
/*  76 */         System.arraycopy(this.a, 0, arrayOfByte, 0, this.a.length);
/*  77 */         this.a = arrayOfByte;
/*     */       } else {
/*     */         
/*  80 */         this.a = new byte[paramInt];
/*     */       } 
/*  82 */       this.b = paramInt;
/*     */     } 
/*     */     
/*  85 */     return this.c;
/*     */   }
/*     */   
/*     */   public final int b(int paramInt) {
/*  89 */     if (this.c + paramInt > this.b)
/*  90 */       return -1; 
/*  91 */     this.c += paramInt;
/*  92 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 102 */   private c h = new c();
/* 103 */   private byte[] i = new byte[4];
/*     */   
/*     */   private int b(c paramc) {
/* 106 */     int i = this.d;
/*     */     
/* 108 */     int j = this.c - this.d;
/*     */     
/* 110 */     if (this.f == 0) {
/*     */       
/* 112 */       if (j < 27) {
/* 113 */         return 0;
/*     */       }
/*     */       
/* 116 */       if (this.a[i] != 79 || this.a[i + 1] != 103 || this.a[i + 2] != 103 || this.a[i + 3] != 83) {
/*     */         
/* 118 */         this.f = 0;
/* 119 */         this.g = 0;
/*     */ 
/*     */         
/* 122 */         int m = 0;
/* 123 */         for (byte b1 = 0; b1 < j - 1; b1++) {
/* 124 */           if (this.a[i + 1 + b1] == 79) {
/* 125 */             m = i + 1 + b1;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/* 130 */         if (m == 0) {
/* 131 */           m = this.c;
/*     */         }
/* 133 */         this.d = m;
/* 134 */         return -(m - i);
/*     */       } 
/* 136 */       int k = (this.a[i + 26] & 0xFF) + 27;
/* 137 */       if (j < k) {
/* 138 */         return 0;
/*     */       }
/*     */ 
/*     */       
/* 142 */       for (byte b = 0; b < (this.a[i + 26] & 0xFF); b++) {
/* 143 */         this.g += this.a[i + 27 + b] & 0xFF;
/*     */       }
/* 145 */       this.f = k;
/*     */     } 
/*     */     
/* 148 */     if (this.g + this.f > j) {
/* 149 */       return 0;
/*     */     }
/*     */     
/* 152 */     synchronized (this.i) {
/*     */ 
/*     */       
/* 155 */       System.arraycopy(this.a, i + 22, this.i, 0, 4);
/* 156 */       this.a[i + 22] = 0;
/* 157 */       this.a[i + 23] = 0;
/* 158 */       this.a[i + 24] = 0;
/* 159 */       this.a[i + 25] = 0;
/*     */       
/*     */       c c1;
/*     */       
/* 163 */       (c1 = this.h).a = this.a;
/* 164 */       c1.b = i;
/* 165 */       c1.c = this.f;
/*     */       
/* 167 */       c1.d = this.a;
/* 168 */       c1.e = i + this.f;
/* 169 */       c1.f = this.g;
/* 170 */       c1.h();
/*     */ 
/*     */       
/* 173 */       if (this.i[0] != this.a[i + 22] || this.i[1] != this.a[i + 23] || this.i[2] != this.a[i + 24] || this.i[3] != this.a[i + 25]) {
/*     */ 
/*     */ 
/*     */         
/* 177 */         System.arraycopy(this.i, 0, this.a, i + 22, 4);
/*     */ 
/*     */         
/* 180 */         this.f = 0;
/* 181 */         this.g = 0;
/*     */         
/* 183 */         int k = 0;
/* 184 */         for (byte b = 0; b < j - 1; b++) {
/* 185 */           if (this.a[i + 1 + b] == 79) {
/* 186 */             k = i + 1 + b;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/* 191 */         if (k == 0)
/* 192 */           k = this.c; 
/* 193 */         this.d = k;
/* 194 */         return -(k - i);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 200 */     i = this.d;
/*     */     
/* 202 */     if (paramc != null) {
/* 203 */       paramc.a = this.a;
/* 204 */       paramc.b = i;
/* 205 */       paramc.c = this.f;
/* 206 */       paramc.d = this.a;
/* 207 */       paramc.e = i + this.f;
/* 208 */       paramc.f = this.g;
/*     */     } 
/*     */     
/* 211 */     this.e = 0;
/* 212 */     this.d += j = this.f + this.g;
/* 213 */     this.f = 0;
/* 214 */     this.g = 0;
/* 215 */     return j;
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
/*     */   public final int a(c paramc) {
/*     */     while (true) {
/*     */       int i;
/* 237 */       if ((i = b(paramc)) > 0)
/*     */       {
/* 239 */         return 1;
/*     */       }
/* 241 */       if (i == 0)
/*     */       {
/* 243 */         return 0;
/*     */       }
/*     */ 
/*     */       
/* 247 */       if (this.e == 0) {
/* 248 */         this.e = 1;
/* 249 */         return -1;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\c\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */