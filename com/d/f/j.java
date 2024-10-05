/*     */ package com.d.f;
/*     */ 
/*     */ import com.d.c.f.d;
/*     */ import com.d.e.v;
/*     */ import com.d.i.ab;
/*     */ import com.d.i.c;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class j
/*     */   extends c
/*     */ {
/*  31 */   private List a = new ArrayList();
/*     */   
/*     */   private boolean b;
/*     */   
/*     */   private boolean c;
/*     */   
/*     */   private boolean d;
/*     */   
/*     */   private boolean e;
/*     */   
/*     */   private boolean f;
/*     */   
/*     */   private int g;
/*     */   
/*     */   public final c c() {
/*     */     j j1;
/*  47 */     (j1 = new j()).a(a());
/*  48 */     j1.a(ai());
/*     */     
/*  50 */     return j1;
/*     */   }
/*     */   
/*     */   public final List d() {
/*  54 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(int paramInt) {
/*  62 */     for (Iterator<c> iterator = this.a.iterator(); iterator.hasNext();)
/*     */     {
/*  64 */       (c1 = iterator.next()).a(paramInt);
/*     */     }
/*     */   }
/*     */   
/*     */   public final void b(int paramInt) {
/*  69 */     for (Iterator<c> iterator = this.a.iterator(); iterator.hasNext();)
/*     */     {
/*  71 */       (c1 = iterator.next()).b(paramInt);
/*     */     }
/*     */   }
/*     */   
/*     */   public final void e(v paramv) {
/*  76 */     byte b = 0;
/*  77 */     this.a.clear();
/*  78 */     l(paramv);
/*  79 */     for (Iterator<i> iterator = W(); iterator.hasNext(); b++) {
/*     */       i i;
/*  81 */       (i = iterator.next()).l(paramv);
/*  82 */       for (Iterator<f> iterator1 = i.W(); iterator1.hasNext(); ) {
/*  83 */         f f = iterator1.next();
/*  84 */         a(f, b);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void f(v paramv) {
/*  90 */     l(paramv);
/*  91 */     for (Iterator<i> iterator = W(); iterator.hasNext(); ) {
/*     */       i i;
/*  93 */       (i = iterator.next()).l(paramv);
/*  94 */       for (Iterator<f> iterator1 = i.W(); iterator1.hasNext();)
/*     */       {
/*  96 */         (f = iterator1.next()).c((d)paramv);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public final f a(int paramInt1, int paramInt2) {
/* 102 */     if (paramInt1 >= this.a.size()) return null; 
/* 103 */     c c1 = this.a.get(paramInt1);
/* 104 */     if (paramInt2 >= c1.a().size()) return null; 
/* 105 */     return c1.a().get(paramInt2);
/*     */   }
/*     */   
/*     */   private void a(int paramInt1, int paramInt2, f paramf) {
/* 109 */     ((c)this.a.get(paramInt1)).a().set(paramInt2, paramf);
/*     */   }
/*     */   
/*     */   private void d(int paramInt) {
/* 113 */     int i = this.a.size();
/* 114 */     int k = f().f();
/*     */     
/* 116 */     while (i < paramInt) {
/*     */       c c1;
/* 118 */       (c1 = new c()).a(k);
/* 119 */       this.a.add(c1);
/* 120 */       i++;
/*     */     } 
/*     */   }
/*     */   
/*     */   public final d f() {
/* 125 */     return (d)U();
/*     */   }
/*     */   
/*     */   protected final void a(v paramv, int paramInt) {
/* 129 */     if (t()) {
/* 130 */       e(paramv);
/* 131 */       j(false);
/*     */     } 
/*     */     
/* 134 */     if (o()) {
/* 135 */       g(paramv);
/* 136 */       a(false);
/*     */     } 
/*     */     
/* 139 */     super.a(paramv, paramInt);
/*     */   }
/*     */   
/*     */   private void a(f paramf, int paramInt) {
/* 143 */     int i = paramf.a().an();
/* 144 */     int k = paramf.a().ao();
/*     */     
/*     */     List<?> list;
/* 147 */     int m = (list = f().g()).size();
/* 148 */     byte b = 0;
/*     */     
/* 150 */     d(paramInt + i);
/*     */     
/* 152 */     while (b < m && a(paramInt, b) != null) {
/* 153 */       b++;
/*     */     }
/*     */     
/* 156 */     m = b;
/* 157 */     f f1 = paramf;
/* 158 */     while (k > 0) {
/*     */       
/* 160 */       while (b >= f().g().size()) {
/* 161 */         f().d(1);
/*     */       }
/* 163 */       b b1 = (b)list.get(b);
/* 164 */       if (k < b1.a()) {
/* 165 */         f().a(b, k);
/*     */       }
/*     */       
/* 168 */       int n = (b1 = (b)list.get(b)).a();
/*     */       
/* 170 */       byte b2 = 0;
/* 171 */       while (b2 < i) {
/* 172 */         if (a(paramInt + b2, b) == null) {
/* 173 */           a(paramInt + b2, b, f1);
/*     */         }
/* 175 */         b2++;
/*     */       } 
/* 177 */       b++;
/* 178 */       k -= n;
/* 179 */       f1 = f.a;
/*     */     } 
/*     */     
/* 182 */     paramf.b(paramInt);
/* 183 */     paramf.a(f().c(m));
/*     */   }
/*     */   
/*     */   public final void c(v paramv) {
/* 187 */     super.c(paramv);
/* 188 */     this.a.clear();
/* 189 */     a(true);
/* 190 */     j(true);
/* 191 */     d(false);
/*     */   }
/*     */ 
/*     */   
/*     */   final void g(v paramv) {
/* 196 */     int[] arrayOfInt = f().e();
/*     */     
/* 198 */     for (Iterator<c> iterator = this.a.iterator(); iterator.hasNext(); ) {
/*     */       c c1;
/* 200 */       List<f> list = (c1 = iterator.next()).a();
/* 201 */       int i = f().a().f((d)paramv);
/* 202 */       for (byte b = 0; b < list.size(); b++) {
/*     */         f f;
/*     */         
/* 205 */         if ((f = list.get(b)) != null && f != f.a) {
/*     */ 
/*     */ 
/*     */           
/* 209 */           int k = b;
/* 210 */           int m = f.a().ao();
/* 211 */           while (m > 0 && k < list.size()) {
/* 212 */             m -= f().a(k);
/* 213 */             k++;
/*     */           } 
/*     */           
/* 216 */           k = arrayOfInt[k] - arrayOfInt[b] - i;
/* 217 */           f.b(paramv, k);
/* 218 */           f.n(arrayOfInt[b] + i);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public final boolean b_() {
/* 225 */     return true;
/*     */   }
/*     */   
/*     */   public final int g() {
/* 229 */     return this.a.size();
/*     */   }
/*     */   
/*     */   protected final boolean n() {
/* 233 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void c(ab paramab) {}
/*     */ 
/*     */   
/*     */   public final void b(ab paramab) {}
/*     */ 
/*     */   
/*     */   public final i j() {
/* 245 */     if (V() > 0) {
/* 246 */       return (i)k(V() - 1);
/*     */     }
/* 248 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   final boolean o() {
/* 253 */     return this.b;
/*     */   }
/*     */   
/*     */   final void a(boolean paramBoolean) {
/* 257 */     this.b = paramBoolean;
/*     */   }
/*     */   
/*     */   private boolean t() {
/* 261 */     return this.c;
/*     */   }
/*     */   
/*     */   private void j(boolean paramBoolean) {
/* 265 */     this.c = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a_(v paramv, int paramInt) {
/*     */     boolean bool;
/* 271 */     if (bool = (paramv.r() && (q() || p()) && f().a().as()) ? true : false) {
/* 272 */       paramv.c(paramv.C() + 1);
/*     */     }
/*     */     
/* 275 */     super.a_(paramv, paramInt);
/*     */     
/* 277 */     if (bool) {
/* 278 */       paramv.c(paramv.C() - 1);
/*     */     }
/*     */   }
/*     */   
/*     */   public final boolean p() {
/* 283 */     return this.d;
/*     */   }
/*     */   
/*     */   public final void b(boolean paramBoolean) {
/* 287 */     this.d = true;
/*     */   }
/*     */   
/*     */   public final boolean q() {
/* 291 */     return this.e;
/*     */   }
/*     */   
/*     */   public final void c(boolean paramBoolean) {
/* 295 */     this.e = true;
/*     */   }
/*     */   
/*     */   public final boolean r() {
/* 299 */     return this.f;
/*     */   }
/*     */   
/*     */   public final void d(boolean paramBoolean) {
/* 303 */     this.f = paramBoolean;
/*     */   }
/*     */   
/*     */   public final int s() {
/* 307 */     return this.g;
/*     */   }
/*     */   
/*     */   public final void c(int paramInt) {
/* 311 */     this.g = paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\f\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */