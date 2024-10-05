/*     */ package org.a.c.f;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import org.a.c.b.a;
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.e;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.b.n;
/*     */ import org.a.c.b.p;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class i
/*     */   extends a
/*     */ {
/*     */   private final p c;
/*     */   private final l d;
/*     */   
/*     */   public i(p paramp, e parame, l paraml) {
/*  56 */     super(new d((InputStream)paramp.k()));
/*  57 */     this.c = paramp;
/*  58 */     this.b = parame;
/*  59 */     this.d = paraml;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void p() {
/*     */     a a2;
/*     */     b b1;
/*  69 */     if (!(b1 = this.c.a(j.dX) instanceof a))
/*     */     {
/*  71 */       throw new IOException("/W array is missing in Xref stream");
/*     */     }
/*  73 */     a a1 = (a)b1;
/*     */     
/*     */     b b2;
/*     */     
/*  77 */     if (b2 = this.c.a(j.bG) instanceof a) {
/*     */       
/*  79 */       a2 = (a)b2;
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */       
/*  85 */       (a2 = new a()).a((b)org.a.c.b.i.a);
/*  86 */       a2.a((b)org.a.c.b.i.a(this.c.b(j.dr, 0)));
/*     */     } 
/*     */     
/*  89 */     ArrayList<Long> arrayList = new ArrayList();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  94 */     Iterator<b> iterator = a2.iterator();
/*  95 */     while (iterator.hasNext()) {
/*     */       b b;
/*     */       
/*  98 */       if (!(b = iterator.next() instanceof org.a.c.b.i))
/*     */       {
/* 100 */         throw new IOException("Xref stream must have integer in /Index array");
/*     */       }
/* 102 */       long l1 = ((org.a.c.b.i)b).b();
/* 103 */       if (iterator.hasNext()) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 108 */         if (!(b = iterator.next() instanceof org.a.c.b.i))
/*     */         {
/* 110 */           throw new IOException("Xref stream must have integer in /Index array");
/*     */         }
/* 112 */         int i1 = ((org.a.c.b.i)b).c();
/* 113 */         for (byte b3 = 0; b3 < i1; b3++)
/*     */         {
/* 115 */           arrayList.add(Long.valueOf(l1 + b3)); } 
/*     */       } 
/*     */     } 
/* 118 */     Iterator<Long> iterator1 = arrayList.iterator();
/*     */ 
/*     */ 
/*     */     
/* 122 */     int n = a1.a(0, 0);
/* 123 */     int k = a1.a(1, 0);
/* 124 */     int m = a1.a(2, 0);
/* 125 */     int j = n + k + m;
/*     */     
/* 127 */     while (!this.a.d() && iterator1.hasNext()) {
/*     */       int i1, i2; byte b; n n1;
/* 129 */       byte[] arrayOfByte = new byte[j];
/* 130 */       this.a.a(arrayOfByte);
/*     */ 
/*     */       
/* 133 */       if (n == 0) {
/*     */ 
/*     */ 
/*     */         
/* 137 */         i1 = 1;
/*     */       }
/*     */       else {
/*     */         
/* 141 */         i1 = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 146 */         for (byte b3 = 0; b3 < n; b3++)
/*     */         {
/* 148 */           i1 += (arrayOfByte[b3] & 0xFF) << n - b3 - 1 << 3;
/*     */         }
/*     */       } 
/*     */       
/* 152 */       Long long_ = iterator1.next();
/*     */ 
/*     */ 
/*     */       
/* 156 */       switch (i1) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         case 1:
/* 164 */           i1 = 0;
/* 165 */           for (i2 = 0; i2 < k; i2++)
/*     */           {
/* 167 */             i1 += (arrayOfByte[i2 + n] & 0xFF) << k - i2 - 1 << 3;
/*     */           }
/* 169 */           i2 = 0;
/* 170 */           for (b = 0; b < m; b++)
/*     */           {
/* 172 */             i2 += (arrayOfByte[b + n + k] & 0xFF) << m - b - 1 << 3;
/*     */           }
/* 174 */           n1 = new n(long_.longValue(), i2);
/* 175 */           this.d.a(n1, i1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         case 2:
/* 193 */           i1 = 0;
/* 194 */           for (i2 = 0; i2 < k; i2++)
/*     */           {
/* 196 */             i1 += (arrayOfByte[i2 + n] & 0xFF) << k - i2 - 1 << 3;
/*     */           }
/* 198 */           n1 = new n(long_.longValue(), 0);
/* 199 */           this.d.a(n1, -i1);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\f\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */