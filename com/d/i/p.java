/*     */ package com.d.i;
/*     */ 
/*     */ import com.d.c.a.c;
/*     */ import com.d.c.f.d;
/*     */ import com.d.e.v;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public final class p extends c {
/*     */   private o a;
/*     */   
/*     */   private static int a(List<aa> paramList, int paramInt) {
/*  14 */     byte b = 0;
/*  15 */     for (aa aa : paramList) {
/*  16 */       if (paramInt >= aa.b() && paramInt <= aa.a()) {
/*  17 */         return b;
/*     */       }
/*  19 */       b++;
/*     */     } 
/*  21 */     return b - 1;
/*     */   }
/*     */   
/*     */   static class a {
/*     */     private final int a;
/*     */     private final int b;
/*     */     private final int c;
/*     */     private final int d;
/*     */     
/*     */     private a(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/*  31 */       this.a = param1Int1;
/*  32 */       this.b = param1Int2;
/*  33 */       this.c = param1Int3;
/*  34 */       this.d = param1Int4;
/*     */     }
/*     */   }
/*     */   
/*     */   private int a(v paramv, f paramf, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  39 */     int i = aa();
/*     */     
/*     */     List<aa> list;
/*  42 */     int j = a(list = paramv.p().k(), i);
/*  43 */     int k = i;
/*  44 */     int m = ((aa)list.get(j)).a();
/*  45 */     byte b = 0;
/*  46 */     int n = 0;
/*     */     
/*     */     ArrayList<a> arrayList;
/*  49 */     (arrayList = new ArrayList<>()).add(new a(0, i, m, j, (byte)0));
/*     */     
/*  51 */     for (Iterator<f> iterator = paramf.X().iterator(); iterator.hasNext(); ) {
/*  52 */       f f1 = (f)(i = iterator.next());
/*     */       
/*  54 */       j = a.a(arrayList.get(b)) - a.b(arrayList.get(b));
/*     */ 
/*     */       
/*  57 */       if ((j = f1.an() + j) + f1.as() > a.c((a)arrayList.get(b))) {
/*     */ 
/*     */ 
/*     */         
/*  61 */         if ((m = ((j = b + 1) % paramInt3 == 0) ? (a.d(arrayList.get(b)) + 1) : a.d(arrayList.get(b))) >= list.size()) {
/*  62 */           paramv.p().b((d)paramv);
/*     */         }
/*     */         
/*  65 */         j = (j % paramInt3 == 0) ? ((aa)list.get(m)).b() : a.a(arrayList.get(b));
/*     */         
/*  67 */         arrayList.add(new a(f1.an(), j, ((aa)list.get(m)).a(), m, (byte)0));
/*  68 */         b++;
/*     */         
/*  70 */         j = a.a(arrayList.get(b)) - a.b(arrayList.get(b));
/*  71 */         j = f1.an() + j;
/*     */       } 
/*     */       
/*  74 */       f1.o(j - k);
/*  75 */       n = Math.max(j - k + f1.as(), n);
/*     */       
/*  77 */       j = b % paramInt3 * paramInt2 + b % paramInt3 * paramInt1;
/*  78 */       f1.n(f1.am() + j + paramInt4);
/*     */     } 
/*     */     
/*  81 */     return n;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a_(v paramv, int paramInt) {
/*  86 */     k(paramv);
/*     */ 
/*     */     
/*  89 */     int j, m = (j = a().Z()) - 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  95 */     float f2, f1 = (f2 = a().a(com.d.c.a.a.B, c.aq) ? a().c((d)paramv) : a().b(com.d.c.a.a.B, d_(), (d)paramv)) * m;
/*  96 */     int k = (int)((d_() - f1) / j);
/*     */     
/*  98 */     this.a.b(af());
/*  99 */     this.a.u(k);
/* 100 */     this.a.a(k);
/* 101 */     this.a.m(ab());
/* 102 */     this.a.l(aa());
/*     */     
/* 104 */     paramv.a(Boolean.FALSE);
/* 105 */     this.a.a_(paramv, paramInt);
/* 106 */     paramv.a(null);
/*     */     
/* 108 */     int i = a(paramv, this.a, (int)f2, k, j, ar() + am());
/* 109 */     this.a.t(0);
/* 110 */     t(i);
/* 111 */     this.a.C();
/*     */   }
/*     */   
/*     */   public final void a(o paramo) {
/* 115 */     this.a = paramo;
/* 116 */     b(paramo);
/*     */   }
/*     */   
/*     */   public final o f() {
/* 120 */     return this.a;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\i\p.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */