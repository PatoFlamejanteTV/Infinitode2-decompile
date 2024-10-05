/*     */ package com.b.a.a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class y
/*     */   extends s
/*     */ {
/*     */   public final int a(int paramInt) {
/*  71 */     if (paramInt >= 0) {
/*  72 */       if (paramInt < 55296 || (paramInt > 56319 && paramInt <= 65535)) {
/*     */         char c;
/*     */ 
/*     */ 
/*     */         
/*  77 */         int i = ((c = this.b[paramInt >> 5]) << 2) + (paramInt & 0x1F);
/*     */         
/*  79 */         return paramInt = this.d[i];
/*     */       } 
/*  81 */       if (paramInt <= 65535) {
/*     */         char c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  89 */         int i = ((c = this.b[2048 + (paramInt - 55296 >> 5)]) << 2) + (paramInt & 0x1F);
/*     */         
/*  91 */         return paramInt = this.d[i];
/*     */       } 
/*  93 */       if (paramInt < this.j) {
/*     */         
/*  95 */         int i = 2080 + (paramInt >> 11);
/*     */         
/*  97 */         i = (i = this.b[i]) + (paramInt >> 5 & 0x3F);
/*     */         
/*  99 */         i = ((i = this.b[i]) << 2) + (paramInt & 0x1F);
/*     */         
/* 101 */         return paramInt = this.d[i];
/*     */       } 
/* 103 */       if (paramInt <= 1114111)
/*     */       {
/* 105 */         return paramInt = this.d[this.k];
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 110 */     return this.i;
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
/*     */   public final int a(char paramChar) {
/*     */     char c;
/* 133 */     int j = ((c = this.b[paramChar >> 5]) << 2) + (paramChar & 0x1F);
/*     */     int i;
/* 135 */     return i = this.d[j];
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
/*     */   final int a(int paramInt1, int paramInt2, int paramInt3) {
/* 180 */     paramInt1 = paramInt1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 191 */     label39: while (paramInt1 < paramInt2) {
/*     */       int i;
/*     */       
/* 194 */       if (paramInt1 < 55296 || (paramInt1 > 56319 && paramInt1 <= 65535)) {
/*     */ 
/*     */ 
/*     */         
/* 198 */         j = 0;
/* 199 */         i = this.b[paramInt1 >> 5] << 2;
/* 200 */       } else if (paramInt1 < 65535) {
/*     */         
/* 202 */         j = 2048;
/* 203 */         i = this.b[2048 + (paramInt1 - 55296 >> 5)] << 2;
/* 204 */       } else if (paramInt1 < this.j) {
/*     */         
/* 206 */         j = 2080 + (paramInt1 >> 11);
/* 207 */         j = this.b[j];
/* 208 */         i = this.b[j + (paramInt1 >> 5 & 0x3F)] << 2;
/*     */       } else {
/*     */         
/* 211 */         if (paramInt3 == this.d[this.k]) {
/* 212 */           paramInt1 = paramInt2;
/*     */         }
/*     */         
/*     */         break;
/*     */       } 
/* 217 */       if (j == this.g) {
/* 218 */         if (paramInt3 == this.h)
/*     */         
/*     */         { 
/* 221 */           paramInt1 += 2048; continue; }  break;
/* 222 */       }  if (i == this.l) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 227 */         if (paramInt3 == this.h) {
/*     */ 
/*     */           
/* 230 */           paramInt1 += 32; continue;
/*     */         } 
/*     */         break;
/*     */       } 
/* 234 */       int j = i + (paramInt1 & 0x1F);
/* 235 */       i += 32;
/* 236 */       for (int k = j; k < i; k++) {
/* 237 */         if (this.d[k] != paramInt3) {
/*     */ 
/*     */           
/* 240 */           paramInt1 += k - j;
/*     */           
/*     */           break label39;
/*     */         } 
/*     */       } 
/*     */       
/* 246 */       paramInt1 += i - j;
/*     */     } 
/*     */     
/* 249 */     if (paramInt1 > paramInt2) {
/* 250 */       paramInt1 = paramInt2;
/*     */     }
/*     */     
/* 253 */     return paramInt1 - 1;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\b\a\a\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */