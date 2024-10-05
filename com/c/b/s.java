/*     */ package com.c.b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class s
/*     */   extends j
/*     */ {
/*     */   final Object a(l paraml, com.c.a.a parama) {
/*  65 */     int i = 0;
/*     */     a a1;
/*  67 */     (a1 = new a(this)).a = parama.c(24);
/*  68 */     a1.b = parama.c(24);
/*  69 */     a1.c = parama.c(24) + 1;
/*  70 */     a1.d = parama.c(6) + 1;
/*  71 */     a1.e = parama.c(8);
/*     */     byte b;
/*  73 */     for (b = 0; b < a1.d; b++) {
/*  74 */       int k = parama.c(3);
/*  75 */       if (parama.c(1) != 0) {
/*  76 */         k |= parama.c(5) << 3;
/*     */       }
/*  78 */       a1.f[b] = k;
/*  79 */       i += o.c(k);
/*     */     } 
/*     */     
/*  82 */     for (b = 0; b < i; b++) {
/*  83 */       a1.g[b] = parama.c(8);
/*     */     }
/*     */     
/*  86 */     if (a1.e >= paraml.h)
/*     */     {
/*  88 */       return null;
/*     */     }
/*     */     
/*  91 */     for (b = 0; b < i; b++) {
/*  92 */       if (a1.g[b] >= paraml.h)
/*     */       {
/*  94 */         return null;
/*     */       }
/*     */     } 
/*  97 */     return a1;
/*     */   }
/*     */   
/*     */   final Object a(e parame, o paramo, Object paramObject) {
/* 101 */     a a = (a)paramObject;
/* 102 */     paramObject = new b(this);
/* 103 */     byte b1 = 0;
/*     */     
/* 105 */     int k = 0;
/* 106 */     ((b)paramObject).a = a;
/*     */ 
/*     */     
/* 109 */     ((b)paramObject).b = a.d;
/* 110 */     ((b)paramObject).d = parame.e;
/* 111 */     ((b)paramObject).e = parame.e[a.e];
/*     */     
/* 113 */     int i = ((b)paramObject).e.a;
/*     */     
/* 115 */     ((b)paramObject).f = new int[((b)paramObject).b][];
/*     */     byte b2;
/* 117 */     for (b2 = 0; b2 < ((b)paramObject).b; b2++) {
/*     */       int m;
/*     */       int n;
/* 120 */       if ((n = o.a(m = a.f[b2])) != 0) {
/* 121 */         if (n > k)
/* 122 */           k = n; 
/* 123 */         ((b)paramObject).f[b2] = new int[n];
/* 124 */         for (byte b = 0; b < n; b++) {
/* 125 */           if ((m & 1 << b) != 0) {
/* 126 */             ((b)paramObject).f[b2][b] = a.g[b1++];
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 132 */     ((b)paramObject).g = (int)Math.rint(Math.pow(((b)paramObject).b, i));
/* 133 */     ((b)paramObject).c = k;
/* 134 */     ((b)paramObject).h = new int[((b)paramObject).g][];
/* 135 */     for (b2 = 0; b2 < ((b)paramObject).g; b2++) {
/* 136 */       int m = b2;
/* 137 */       int n = ((b)paramObject).g / ((b)paramObject).b;
/* 138 */       ((b)paramObject).h[b2] = new int[i];
/*     */       
/* 140 */       for (byte b = 0; b < i; b++) {
/* 141 */         int i1 = m / n;
/* 142 */         m -= i1 * n;
/* 143 */         n /= ((b)paramObject).b;
/* 144 */         ((b)paramObject).h[b2][b] = i1;
/*     */       } 
/*     */     } 
/* 147 */     return paramObject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 156 */   private static int[][][] b = new int[2][][];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static synchronized int a(a parama, Object paramObject, float[][] paramArrayOffloat, int paramInt1, int paramInt2) {
/*     */     b b;
/*     */     a a1;
/* 166 */     int k = (a1 = (b = (b)paramObject).a).c;
/* 167 */     int m = b.e.a;
/*     */ 
/*     */ 
/*     */     
/* 171 */     int n, i = ((n = (i = a1.b - a1.a) / k) + m - 1) / m;
/*     */     
/* 173 */     if (b.length < paramInt1) {
/* 174 */       b = new int[paramInt1][][];
/*     */     }
/*     */     byte b1;
/* 177 */     for (b1 = 0; b1 < paramInt1; b1++) {
/* 178 */       if (b[b1] == null || (b[b1]).length < i) {
/* 179 */         b[b1] = new int[i][];
/*     */       }
/*     */     } 
/*     */     
/* 183 */     for (byte b2 = 0; b2 < b.c; b2++) {
/*     */       byte b3;
/*     */       
/* 186 */       for (i = 0, b3 = 0; i < n; b3++) {
/* 187 */         if (b2 == 0)
/*     */         {
/* 189 */           for (b1 = 0; b1 < paramInt1; b1++) {
/*     */             int i1;
/* 191 */             if ((i1 = b.e.a(parama.b)) == -1) {
/* 192 */               return 0;
/*     */             }
/* 194 */             b[b1][b3] = b.h[i1];
/* 195 */             if (b[b1][b3] == null) {
/* 196 */               return 0;
/*     */             }
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/* 202 */         for (byte b4 = 0; b4 < m && i < n; b4++, i++) {
/* 203 */           for (b1 = 0; b1 < paramInt1; b1++) {
/* 204 */             int i1 = a1.a + i * k;
/* 205 */             int i2 = b[b1][b3][b4]; b b5;
/* 206 */             if ((a1.f[i2] & 1 << b2) != 0 && (
/*     */               
/* 208 */               b5 = b.d[b.f[i2][b2]]) != null) {
/* 209 */               if (paramInt2 == 0) {
/* 210 */                 if (b5.a(paramArrayOffloat[b1], i1, parama.b, k) == -1)
/*     */                 {
/* 212 */                   return 0;
/*     */                 }
/*     */               }
/* 215 */               else if (paramInt2 == 1 && 
/* 216 */                 b5.b(paramArrayOffloat[b1], i1, parama.b, k) == -1) {
/*     */                 
/* 218 */                 return 0;
/*     */               } 
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 226 */     return 0;
/*     */   }
/*     */   
/* 229 */   private static int[][] c = (int[][])null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static synchronized int a(a parama, Object paramObject, float[][] paramArrayOffloat, int paramInt) {
/*     */     b b1;
/*     */     a a1;
/* 237 */     int k = (a1 = (b1 = (b)paramObject).a).c;
/* 238 */     int m = b1.e.a;
/*     */ 
/*     */ 
/*     */     
/* 242 */     int n, i = ((n = (i = a1.b - a1.a) / k) + m - 1) / m;
/*     */     
/* 244 */     if (c == null || c.length < i) {
/* 245 */       c = new int[i][];
/*     */     }
/* 247 */     for (byte b = 0; b < b1.c; b++) {
/* 248 */       byte b2; for (i = 0, b2 = 0; i < n; b2++) {
/* 249 */         if (b == 0) {
/*     */           int i1;
/*     */           
/* 252 */           if ((i1 = b1.e.a(parama.b)) == -1) {
/* 253 */             return 0;
/*     */           }
/* 255 */           c[b2] = b1.h[i1];
/* 256 */           if (c[b2] == null) {
/* 257 */             return 0;
/*     */           }
/*     */         } 
/*     */ 
/*     */         
/* 262 */         for (byte b3 = 0; b3 < m && i < n; b3++, i++) {
/* 263 */           int i1 = a1.a + i * k;
/* 264 */           int i2 = c[b2][b3]; b b4;
/* 265 */           if ((a1.f[i2] & 1 << b) != 0 && (
/*     */             
/* 267 */             b4 = b1.d[b1.f[i2][b]]) != null && 
/* 268 */             b4.a(paramArrayOffloat, i1, paramInt, parama.b, k) == -1)
/*     */           {
/* 270 */             return 0;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 277 */     return 0;
/*     */   }
/*     */   
/*     */   int a(a parama, Object paramObject, float[][] paramArrayOffloat, int[] paramArrayOfint, int paramInt) {
/* 281 */     byte b1 = 0;
/* 282 */     for (byte b2 = 0; b2 < paramInt; b2++) {
/* 283 */       if (paramArrayOfint[b2] != 0) {
/* 284 */         paramArrayOffloat[b1++] = paramArrayOffloat[b2];
/*     */       }
/*     */     } 
/* 287 */     if (b1 != 0) {
/* 288 */       return a(parama, paramObject, paramArrayOffloat, b1, 0);
/*     */     }
/* 290 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   class b
/*     */   {
/*     */     s.a a;
/*     */     
/*     */     int b;
/*     */     
/*     */     int c;
/*     */     
/*     */     b[] d;
/*     */     
/*     */     b e;
/*     */     
/*     */     int[][] f;
/*     */     int g;
/*     */     int[][] h;
/*     */     
/*     */     b(s this$0) {}
/*     */   }
/*     */   
/*     */   class a
/*     */   {
/*     */     int a;
/*     */     int b;
/*     */     int c;
/*     */     int d;
/*     */     int e;
/* 320 */     int[] f = new int[64];
/* 321 */     int[] g = new int[256];
/*     */     
/*     */     a(s this$0) {}
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\c\b\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */