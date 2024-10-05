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
/*     */ public class c
/*     */ {
/*  30 */   private static int[] g = new int[256]; public byte[] a; public int b; public int c;
/*     */   static {
/*  32 */     for (byte b = 0; b < g.length; b++)
/*  33 */       g[b] = a(b); 
/*     */   }
/*     */   public byte[] d; public int e; public int f;
/*     */   
/*     */   private static int a(int paramInt) {
/*  38 */     paramInt <<= 24;
/*  39 */     for (byte b = 0; b < 8; b++) {
/*  40 */       if ((paramInt & Integer.MIN_VALUE) != 0) {
/*  41 */         paramInt = paramInt << 1 ^ 0x4C11DB7;
/*     */       
/*     */       }
/*     */       else {
/*     */ 
/*     */         
/*  47 */         paramInt <<= 1;
/*     */       } 
/*     */     } 
/*  50 */     return paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final int a() {
/*  61 */     return this.a[this.b + 4] & 0xFF;
/*     */   }
/*     */   
/*     */   final int b() {
/*  65 */     return this.a[this.b + 5] & 0x1;
/*     */   }
/*     */   
/*     */   public final int c() {
/*  69 */     return this.a[this.b + 5] & 0x2;
/*     */   }
/*     */   
/*     */   public final int d() {
/*  73 */     return this.a[this.b + 5] & 0x4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final long e() {
/*     */     long l;
/*  85 */     return l = (l = (l = (l = (l = (l = (l = (l = (this.a[this.b + 13] & 0xFF)) << 8L | (this.a[this.b + 12] & 0xFF)) << 8L | (this.a[this.b + 11] & 0xFF)) << 8L | (this.a[this.b + 10] & 0xFF)) << 8L | (this.a[this.b + 9] & 0xFF)) << 8L | (this.a[this.b + 8] & 0xFF)) << 8L | (this.a[this.b + 7] & 0xFF)) << 8L | (this.a[this.b + 6] & 0xFF);
/*     */   }
/*     */   
/*     */   public final int f() {
/*  89 */     return this.a[this.b + 14] & 0xFF | (this.a[this.b + 15] & 0xFF) << 8 | (this.a[this.b + 16] & 0xFF) << 16 | (this.a[this.b + 17] & 0xFF) << 24;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   final int g() {
/*  95 */     return this.a[this.b + 18] & 0xFF | (this.a[this.b + 19] & 0xFF) << 8 | (this.a[this.b + 20] & 0xFF) << 16 | (this.a[this.b + 21] & 0xFF) << 24;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   final void h() {
/* 101 */     int i = 0;
/*     */     byte b;
/* 103 */     for (b = 0; b < this.c; b++) {
/* 104 */       i = i << 8 ^ g[i >>> 24 ^ this.a[this.b + b] & 0xFF];
/*     */     }
/*     */     
/* 107 */     for (b = 0; b < this.f; b++) {
/* 108 */       i = i << 8 ^ g[i >>> 24 ^ this.d[this.e + b] & 0xFF];
/*     */     }
/*     */     
/* 111 */     this.a[this.b + 22] = (byte)i;
/* 112 */     this.a[this.b + 23] = (byte)(i >>> 8);
/* 113 */     this.a[this.b + 24] = (byte)(i >>> 16);
/* 114 */     this.a[this.b + 25] = (byte)(i >>> 24);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\c\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */