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
/*     */ final class f
/*     */   extends h
/*     */ {
/*     */   final Object a(l paraml, com.c.a.a parama) {
/*     */     a a1;
/*  47 */     (a1 = new a(this)).a = parama.c(8);
/*  48 */     a1.b = parama.c(16);
/*  49 */     a1.c = parama.c(16);
/*  50 */     a1.d = parama.c(6);
/*  51 */     a1.e = parama.c(8);
/*  52 */     a1.f = parama.c(4) + 1;
/*     */     
/*  54 */     if (a1.a <= 0 || a1.b <= 0 || a1.c <= 0 || a1.f <= 0) {
/*  55 */       return null;
/*     */     }
/*     */     
/*  58 */     for (byte b = 0; b < a1.f; b++) {
/*  59 */       a1.g[b] = parama.c(8);
/*  60 */       if (a1.g[b] < 0 || a1.g[b] >= paraml.h) {
/*  61 */         return null;
/*     */       }
/*     */     } 
/*  64 */     return a1;
/*     */   }
/*     */ 
/*     */   
/*     */   final Object a(e parame, o paramo, Object paramObject) {
/*  69 */     l l = parame.a;
/*  70 */     paramObject = paramObject;
/*     */     b b1;
/*  72 */     (b1 = new b(this)).c = ((a)paramObject).a;
/*  73 */     b1.a = l.c[paramo.a] / 2;
/*  74 */     b1.b = ((a)paramObject).c;
/*  75 */     b1.e = (a)paramObject;
/*  76 */     b1.f.a(b1.b, b1.c);
/*     */ 
/*     */     
/*  79 */     float f1 = b1.b / a((float)(((a)paramObject).b / 2.0D));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  87 */     b1.d = new int[b1.a];
/*  88 */     for (byte b = 0; b < b1.a; b++) {
/*     */       int i;
/*  90 */       if ((i = (int)Math.floor((a((float)(((a)paramObject).b / 2.0D / b1.a * b)) * f1))) >= b1.b)
/*  91 */         i = b1.b; 
/*  92 */       b1.d[b] = i;
/*     */     } 
/*  94 */     return b1;
/*     */   }
/*     */   
/*     */   private static float a(float paramFloat) {
/*  98 */     return (float)(13.1D * Math.atan(7.4E-4D * paramFloat) + 2.24D * Math.atan((paramFloat * paramFloat) * 1.85E-8D) + 1.0E-4D * paramFloat);
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
/*     */   final Object a(a parama, Object paramObject1, Object paramObject2) {
/* 179 */     a a1 = ((b)(paramObject1 = paramObject1)).e;
/* 180 */     float[] arrayOfFloat = null;
/* 181 */     if (paramObject2 instanceof float[]) {
/* 182 */       arrayOfFloat = (float[])paramObject2;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 187 */     int j = (1 << a1.d) - 1;
/* 188 */     float f1 = i / j * a1.e;
/*     */     
/*     */     int i;
/* 191 */     if ((i = parama.b.c(a1.d)) > 0 && (j = parama.b.c(o.a(a1.f))) != -1 && j < a1.f) {
/* 192 */       b b = parama.k.e[a1.g[j]];
/* 193 */       float f2 = 0.0F;
/*     */       
/* 195 */       if (arrayOfFloat == null || arrayOfFloat.length < ((b)paramObject1).c + 1) {
/* 196 */         arrayOfFloat = new float[((b)paramObject1).c + 1];
/*     */       } else {
/*     */         
/* 199 */         for (byte b1 = 0; b1 < arrayOfFloat.length; b1++)
/* 200 */           arrayOfFloat[b1] = 0.0F; 
/*     */       } 
/*     */       int k;
/* 203 */       for (k = 0; k < ((b)paramObject1).c; k += b.a) {
/* 204 */         if (b.c(arrayOfFloat, k, parama.b, b.a) == -1) {
/* 205 */           return null;
/*     */         }
/*     */       } 
/*     */       
/* 209 */       for (k = 0; k < ((b)paramObject1).c; ) {
/* 210 */         for (byte b1 = 0; b1 < b.a; b1++, k++)
/* 211 */           arrayOfFloat[k] = arrayOfFloat[k] + f2; 
/* 212 */         f2 = arrayOfFloat[k - 1];
/*     */       } 
/* 214 */       arrayOfFloat[((b)paramObject1).c] = f1;
/* 215 */       return arrayOfFloat;
/*     */     } 
/*     */     
/* 218 */     return null;
/*     */   }
/*     */   
/*     */   final int a(a parama, Object paramObject1, Object paramObject2, float[] paramArrayOffloat) {
/*     */     b b;
/* 223 */     paramObject1 = (b = (b)paramObject1).e;
/*     */     
/* 225 */     if (paramObject2 != null) {
/*     */       
/* 227 */       Object object = (paramObject2 = paramObject2)[b.c];
/*     */       
/* 229 */       o.a(paramArrayOffloat, b.d, b.a, b.b, (float[])paramObject2, b.c, object, ((a)paramObject1).e);
/*     */       
/* 231 */       return 1;
/*     */     } 
/* 233 */     for (byte b1 = 0; b1 < b.a; b1++) {
/* 234 */       paramArrayOffloat[b1] = 0.0F;
/*     */     }
/* 236 */     return 0;
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
/*     */   class a
/*     */   {
/*     */     int a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int e;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int f;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 316 */     int[] g = new int[16];
/*     */     
/*     */     a(f this$0) {} }
/*     */   
/*     */   class b {
/*     */     int a;
/*     */     int b;
/*     */     int c;
/*     */     int[] d;
/*     */     f.a e;
/* 326 */     n f = new n();
/*     */     
/*     */     b(f this$0) {}
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\c\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */