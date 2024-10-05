/*     */ package com.c.b;
/*     */ 
/*     */ import com.c.a.a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   private byte[][] b;
/*     */   private int[] c;
/*     */   private int d;
/*     */   public byte[] a;
/*     */   
/*     */   static {
/*  34 */     "vorbis".getBytes();
/*  35 */     "Xiphophorus libVorbis I 20000508".getBytes();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a() {
/*  46 */     this.b = (byte[][])null;
/*  47 */     this.d = 0;
/*  48 */     this.a = null;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final int a(a parama) {
/*     */     int i;
/* 142 */     if ((i = parama.c(32)) < 0) {
/* 143 */       b();
/* 144 */       return -1;
/*     */     } 
/* 146 */     this.a = new byte[i + 1];
/* 147 */     parama.a(this.a, i);
/* 148 */     this.d = parama.c(32);
/* 149 */     if (this.d < 0) {
/* 150 */       b();
/* 151 */       return -1;
/*     */     } 
/* 153 */     this.b = new byte[this.d + 1][];
/* 154 */     this.c = new int[this.d + 1];
/*     */     
/* 156 */     for (i = 0; i < this.d; i++) {
/*     */       int j;
/* 158 */       if ((j = parama.c(32)) < 0) {
/* 159 */         b();
/* 160 */         return -1;
/*     */       } 
/* 162 */       this.c[i] = j;
/* 163 */       this.b[i] = new byte[j + 1];
/* 164 */       parama.a(this.b[i], j);
/*     */     } 
/* 166 */     if (parama.c(1) != 1) {
/* 167 */       b();
/* 168 */       return -1;
/*     */     } 
/*     */     
/* 171 */     return 0;
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
/*     */   private void b() {
/* 218 */     for (byte b = 0; b < this.d; b++)
/* 219 */       this.b[b] = null; 
/* 220 */     this.b = (byte[][])null;
/* 221 */     this.a = null;
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
/*     */   public String toString() {
/* 235 */     String str = "Vendor: " + new String(this.a, 0, this.a.length - 1);
/* 236 */     for (byte b = 0; b < this.d; b++) {
/* 237 */       str = str + "\nComment: " + new String(this.b[b], 0, (this.b[b]).length - 1);
/*     */     }
/*     */ 
/*     */     
/* 241 */     return str = str + "\n";
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\c\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */