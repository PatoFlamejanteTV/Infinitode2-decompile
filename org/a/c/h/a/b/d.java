/*     */ package org.a.c.h.a.b;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import org.a.c.b.a;
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.h.a.g;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class d
/*     */   extends a
/*     */ {
/*  33 */   private a a = null;
/*  34 */   private a b = null;
/*  35 */   private a c = null;
/*  36 */   private a[] d = null;
/*  37 */   private float[] e = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public d(b paramb) {
/*  46 */     super(paramb);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int a() {
/*  55 */     return 3;
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
/*     */   public final float[] a(float[] paramArrayOffloat) {
/*  67 */     a a1 = null;
/*  68 */     float f = paramArrayOffloat[0];
/*  69 */     g g = b(0);
/*     */     
/*  71 */     f = a(f, g.a(), g.b());
/*     */     
/*  73 */     if (this.d == null) {
/*     */       
/*  75 */       a a2 = h();
/*  76 */       this.d = new a[a2.b()];
/*  77 */       for (byte b = 0; b < a2.b(); b++)
/*     */       {
/*  79 */         this.d[b] = a.a(a2.a(b));
/*     */       }
/*     */     } 
/*     */     
/*  83 */     if (this.d.length == 1) {
/*     */ 
/*     */       
/*  86 */       a1 = this.d[0];
/*  87 */       g g1 = c(0);
/*  88 */       f = a(f, g.a(), g.b(), g1.a(), g1.b());
/*     */     }
/*     */     else {
/*     */       
/*  92 */       if (this.e == null)
/*     */       {
/*  94 */         this.e = i().d();
/*     */       }
/*     */       
/*     */       int i;
/*     */       
/*     */       float[] arrayOfFloat;
/* 100 */       int j = (arrayOfFloat = new float[(i = this.e.length) + 2]).length;
/* 101 */       arrayOfFloat[0] = g.a();
/* 102 */       arrayOfFloat[j - 1] = g.b();
/* 103 */       System.arraycopy(this.e, 0, arrayOfFloat, 1, i);
/*     */       
/* 105 */       for (byte b = 0; b < j - 1; b++) {
/*     */         
/* 107 */         if (f >= arrayOfFloat[b] && (f < arrayOfFloat[b + 1] || (b == j - 2 && f == arrayOfFloat[b + 1]))) {
/*     */ 
/*     */           
/* 110 */           a1 = this.d[b];
/* 111 */           g g1 = c(b);
/* 112 */           f = a(f, arrayOfFloat[b], arrayOfFloat[b + 1], g1.a(), g1.b());
/*     */           break;
/*     */         } 
/*     */       } 
/* 116 */       if (a1 == null)
/*     */       {
/* 118 */         throw new IOException("partition not found in type 3 function");
/*     */       }
/*     */     } 
/* 121 */     float[] arrayOfFloat1 = { f };
/*     */     
/* 123 */     float[] arrayOfFloat2 = a1.a(arrayOfFloat1);
/*     */     
/* 125 */     return b(arrayOfFloat2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private a h() {
/* 135 */     if (this.a == null)
/*     */     {
/* 137 */       this.a = (a)b().a(j.bt);
/*     */     }
/* 139 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private a i() {
/* 149 */     if (this.c == null)
/*     */     {
/* 151 */       this.c = (a)b().a(j.C);
/*     */     }
/* 153 */     return this.c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private a j() {
/* 163 */     if (this.b == null)
/*     */     {
/* 165 */       this.b = (a)b().a(j.aP);
/*     */     }
/* 167 */     return this.b;
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
/*     */   private g c(int paramInt) {
/* 179 */     a a1 = j();
/* 180 */     return new g(a1, paramInt);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\a\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */