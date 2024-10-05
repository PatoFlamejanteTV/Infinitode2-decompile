/*     */ package com.b.a.a;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class x
/*     */   extends s
/*     */ {
/*     */   public static x b(ByteBuffer paramByteBuffer) {
/*  58 */     return (x)s.a(paramByteBuffer);
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
/*     */   public final int a(int paramInt) {
/*  72 */     if (paramInt >= 0) {
/*  73 */       if (paramInt < 55296 || (paramInt > 56319 && paramInt <= 65535)) {
/*     */         char c;
/*     */ 
/*     */ 
/*     */         
/*  78 */         int i = ((c = this.b[paramInt >> 5]) << 2) + (paramInt & 0x1F);
/*     */         
/*  80 */         return paramInt = this.b[i];
/*     */       } 
/*  82 */       if (paramInt <= 65535) {
/*     */         char c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  90 */         int i = ((c = this.b[2048 + (paramInt - 55296 >> 5)]) << 2) + (paramInt & 0x1F);
/*     */         
/*  92 */         return paramInt = this.b[i];
/*     */       } 
/*  94 */       if (paramInt < this.j) {
/*     */         
/*  96 */         int i = 2080 + (paramInt >> 11);
/*     */         
/*  98 */         i = (i = this.b[i]) + (paramInt >> 5 & 0x3F);
/*     */         
/* 100 */         i = ((i = this.b[i]) << 2) + (paramInt & 0x1F);
/*     */         
/* 102 */         return paramInt = this.b[i];
/*     */       } 
/* 104 */       if (paramInt <= 1114111)
/*     */       {
/* 106 */         return paramInt = this.b[this.k];
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 111 */     return this.i;
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
/*     */   public final int a(char paramChar) {
/*     */     char c;
/* 136 */     int i = ((c = this.b[paramChar >> 5]) << 2) + (paramChar & 0x1F);
/*     */     
/* 138 */     return paramChar = this.b[i];
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
/*     */   public final int b() {
/* 169 */     return 16 + (this.a.c + this.f << 1);
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
/*     */   final int a(int paramInt1, int paramInt2, int paramInt3) {
/* 183 */     paramInt1 = paramInt1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 194 */     label39: while (paramInt1 < paramInt2) {
/*     */       int i;
/*     */       
/* 197 */       if (paramInt1 < 55296 || (paramInt1 > 56319 && paramInt1 <= 65535)) {
/*     */ 
/*     */ 
/*     */         
/* 201 */         j = 0;
/* 202 */         i = this.b[paramInt1 >> 5] << 2;
/* 203 */       } else if (paramInt1 < 65535) {
/*     */         
/* 205 */         j = 2048;
/* 206 */         i = this.b[2048 + (paramInt1 - 55296 >> 5)] << 2;
/* 207 */       } else if (paramInt1 < this.j) {
/*     */         
/* 209 */         j = 2080 + (paramInt1 >> 11);
/* 210 */         j = this.b[j];
/* 211 */         i = this.b[j + (paramInt1 >> 5 & 0x3F)] << 2;
/*     */       } else {
/*     */         
/* 214 */         if (paramInt3 == this.b[this.k]) {
/* 215 */           paramInt1 = paramInt2;
/*     */         }
/*     */         
/*     */         break;
/*     */       } 
/* 220 */       if (j == this.g) {
/* 221 */         if (paramInt3 == this.h)
/*     */         
/*     */         { 
/* 224 */           paramInt1 += 2048; continue; }  break;
/* 225 */       }  if (i == this.l) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 230 */         if (paramInt3 == this.h) {
/*     */ 
/*     */           
/* 233 */           paramInt1 += 32; continue;
/*     */         } 
/*     */         break;
/*     */       } 
/* 237 */       int j = i + (paramInt1 & 0x1F);
/* 238 */       i += 32;
/* 239 */       for (int k = j; k < i; k++) {
/* 240 */         if (this.b[k] != paramInt3) {
/*     */ 
/*     */           
/* 243 */           paramInt1 += k - j;
/*     */           
/*     */           break label39;
/*     */         } 
/*     */       } 
/*     */       
/* 249 */       paramInt1 += i - j;
/*     */     } 
/*     */     
/* 252 */     if (paramInt1 > paramInt2) {
/* 253 */       paramInt1 = paramInt2;
/*     */     }
/*     */     
/* 256 */     return paramInt1 - 1;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\b\a\a\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */