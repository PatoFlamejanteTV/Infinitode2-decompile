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
/*     */ public final class a
/*     */ {
/*  32 */   private static final int[] a = new int[] { 0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  39 */   private int b = 0;
/*  40 */   private byte[] c = null;
/*  41 */   private int d = 0;
/*  42 */   private int e = 0;
/*  43 */   private int f = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(byte[] paramArrayOfbyte, int paramInt) {
/*  61 */     byte b = 0;
/*  62 */     while (paramInt-- != 0) {
/*  63 */       paramArrayOfbyte[b++] = (byte)c(8);
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
/*     */   public final void a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  82 */     this.b = paramInt1;
/*  83 */     this.c = paramArrayOfbyte;
/*  84 */     this.d = this.e = 0;
/*  85 */     this.f = paramInt2;
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
/*     */   public final int a(int paramInt) {
/* 123 */     int j = a[paramInt];
/*     */     
/* 125 */     paramInt += this.d;
/*     */     
/* 127 */     if (this.e + 4 >= this.f && 
/* 128 */       this.e + (paramInt - 1) / 8 >= this.f) {
/* 129 */       return -1;
/*     */     }
/*     */     
/* 132 */     int i = (this.c[this.b] & 0xFF) >>> this.d;
/* 133 */     if (paramInt > 8) {
/* 134 */       i |= (this.c[this.b + 1] & 0xFF) << 8 - this.d;
/* 135 */       if (paramInt > 16) {
/* 136 */         i |= (this.c[this.b + 2] & 0xFF) << 16 - this.d;
/* 137 */         if (paramInt > 24) {
/* 138 */           i |= (this.c[this.b + 3] & 0xFF) << 24 - this.d;
/* 139 */           if (paramInt > 32 && this.d != 0) {
/* 140 */             i |= (this.c[this.b + 4] & 0xFF) << 32 - this.d;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 145 */     return j & i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void b(int paramInt) {
/* 155 */     paramInt += this.d;
/* 156 */     this.b += paramInt / 8;
/* 157 */     this.e += paramInt / 8;
/* 158 */     this.d = paramInt & 0x7;
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
/*     */   public final int c(int paramInt) {
/* 172 */     int j = a[paramInt];
/*     */     
/* 174 */     paramInt += this.d;
/*     */     
/* 176 */     if (this.e + 4 >= this.f)
/*     */     {
/* 178 */       if (this.e + (paramInt - 1) / 8 >= this.f) {
/* 179 */         this.b += paramInt / 8;
/* 180 */         this.e += paramInt / 8;
/* 181 */         this.d = paramInt & 0x7;
/* 182 */         return -1;
/*     */       } 
/*     */     }
/*     */     
/* 186 */     int i = (this.c[this.b] & 0xFF) >>> this.d;
/* 187 */     if (paramInt > 8) {
/* 188 */       i |= (this.c[this.b + 1] & 0xFF) << 8 - this.d;
/* 189 */       if (paramInt > 16) {
/* 190 */         i |= (this.c[this.b + 2] & 0xFF) << 16 - this.d;
/* 191 */         if (paramInt > 24) {
/* 192 */           i |= (this.c[this.b + 3] & 0xFF) << 24 - this.d;
/* 193 */           if (paramInt > 32 && this.d != 0) {
/* 194 */             i |= (this.c[this.b + 4] & 0xFF) << 32 - this.d;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 200 */     i &= j;
/*     */     
/* 202 */     this.b += paramInt / 8;
/* 203 */     this.e += paramInt / 8;
/* 204 */     this.d = paramInt & 0x7;
/* 205 */     return i;
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
/*     */   public final int a() {
/* 247 */     if (this.e >= this.f) {
/*     */       
/* 249 */       this.d++;
/* 250 */       if (this.d > 7) {
/* 251 */         this.d = 0;
/* 252 */         this.b++;
/* 253 */         this.e++;
/*     */       } 
/* 255 */       return -1;
/*     */     } 
/*     */     
/* 258 */     int i = this.c[this.b] >> this.d & 0x1;
/*     */     
/* 260 */     this.d++;
/* 261 */     if (this.d > 7) {
/* 262 */       this.d = 0;
/* 263 */       this.b++;
/* 264 */       this.e++;
/*     */     } 
/* 266 */     return i;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\c\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */