/*     */ package com.d.c.c;
/*     */ 
/*     */ import com.d.c.b.a;
/*     */ import com.d.c.b.d;
/*     */ import com.d.c.e.d;
/*     */ import com.d.m.l;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.logging.Level;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class f
/*     */ {
/*     */   private d a;
/*  38 */   private f b = null;
/*  39 */   private f c = null;
/*     */   
/*     */   private int d;
/*     */   private String e;
/*     */   private String f;
/*  44 */   private int g = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   private String h;
/*     */ 
/*     */   
/*     */   private int i;
/*     */ 
/*     */   
/*     */   private int j;
/*     */ 
/*     */   
/*     */   private int k;
/*     */ 
/*     */   
/*     */   private int l;
/*     */ 
/*     */   
/*     */   private List<b> m;
/*     */ 
/*     */   
/*     */   private int n;
/*     */ 
/*     */   
/*  69 */   private static int o = 0;
/*     */   
/*     */   public f() {
/*  72 */     this.n = o++;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean a(Object paramObject, a parama, d paramd) {
/*  80 */     if (this.c != null) {
/*     */       Object object;
/*  82 */       if ((object = this.c.a(paramObject, paramd)) == null) {
/*  83 */         return false;
/*     */       }
/*  85 */       if (!this.c.a(object, parama, paramd)) {
/*  86 */         return false;
/*     */       }
/*     */     } 
/*  89 */     if (this.e == null || paramd.a(paramObject, this.f, this.e)) {
/*  90 */       if (this.m != null)
/*     */       {
/*  92 */         for (Iterator<b> iterator = this.m.iterator(); iterator.hasNext();) {
/*  93 */           if (!(b = iterator.next()).a(paramObject, parama, paramd)) {
/*  94 */             return false;
/*     */           }
/*     */         } 
/*     */       }
/*  98 */       return true;
/*     */     } 
/* 100 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean b(Object paramObject, a parama, d paramd) {
/* 108 */     if (this.c != null) {
/*     */       Object object;
/* 110 */       if ((object = this.c.a(paramObject, paramd)) == null) {
/* 111 */         return false;
/*     */       }
/* 113 */       if (!this.c.b(object, parama, paramd)) {
/* 114 */         return false;
/*     */       }
/*     */     } 
/* 117 */     if (b(2) && (
/* 118 */       parama == null || !parama.g(paramObject))) {
/* 119 */       return false;
/*     */     }
/*     */     
/* 122 */     if (b(8) && (
/* 123 */       parama == null || !parama.i(paramObject))) {
/* 124 */       return false;
/*     */     }
/*     */     
/* 127 */     if (b(4) && (
/* 128 */       parama == null || !parama.h(paramObject))) {
/* 129 */       return false;
/*     */     }
/*     */     
/* 132 */     if (b(16) && (
/* 133 */       parama == null || !parama.j(paramObject))) {
/* 134 */       return false;
/*     */     }
/*     */     
/* 137 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void o() {
/* 144 */     a(b.f());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a() {
/* 151 */     this.j++;
/* 152 */     a(b.e());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void b() {
/* 159 */     this.j++;
/* 160 */     a(b.a());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void c() {
/* 167 */     this.j++;
/* 168 */     a(b.b());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(String paramString) {
/* 175 */     this.j++;
/* 176 */     a(b.d(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void d() {
/* 183 */     this.j++;
/* 184 */     a(b.c());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void e() {
/* 191 */     this.j++;
/* 192 */     a(b.d());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void b(String paramString) {
/* 199 */     this.j++;
/* 200 */     a(b.c(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void c(String paramString) {
/* 207 */     this.i++;
/* 208 */     a(b.b(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void d(String paramString) {
/* 215 */     this.j++;
/* 216 */     a(b.a(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(String paramString1, String paramString2) {
/* 223 */     this.j++;
/* 224 */     a(b.a(paramString1, paramString2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(String paramString1, String paramString2, String paramString3) {
/* 231 */     this.j++;
/* 232 */     a(b.d(paramString1, paramString2, paramString3));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void b(String paramString1, String paramString2, String paramString3) {
/* 239 */     this.j++;
/* 240 */     a(b.a(paramString1, paramString2, paramString3));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void c(String paramString1, String paramString2, String paramString3) {
/* 247 */     this.j++;
/* 248 */     a(b.b(paramString1, paramString2, paramString3));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void d(String paramString1, String paramString2, String paramString3) {
/* 255 */     this.j++;
/* 256 */     a(b.c(paramString1, paramString2, paramString3));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void e(String paramString1, String paramString2, String paramString3) {
/* 263 */     this.j++;
/* 264 */     a(b.e(paramString1, paramString2, paramString3));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void f(String paramString1, String paramString2, String paramString3) {
/* 271 */     this.j++;
/* 272 */     a(b.f(paramString1, paramString2, paramString3));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(int paramInt) {
/* 283 */     if (!b(paramInt)) {
/* 284 */       this.j++;
/*     */     }
/* 286 */     this.g |= paramInt;
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
/*     */   public final void e(String paramString) {
/* 300 */     if (this.h != null) {
/* 301 */       o();
/* 302 */       l.f(Level.WARNING, "Trying to set more than one pseudo-element"); return;
/*     */     } 
/* 304 */     this.k++;
/* 305 */     this.h = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean b(int paramInt) {
/* 316 */     return ((this.g & paramInt) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String f() {
/* 325 */     return this.h;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final f g() {
/* 335 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final d h() {
/* 344 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int i() {
/* 353 */     return this.d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int j() {
/* 361 */     return this.i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int k() {
/* 369 */     return this.k;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int l() {
/* 377 */     return this.j;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final String m() {
/* 387 */     if (this.b != null) {
/* 388 */       return this.b.m();
/*     */     }
/* 390 */     String str1 = "000" + j();
/* 391 */     String str2 = "000" + l();
/* 392 */     String str3 = "000" + k();
/* 393 */     String str4 = "00000" + this.l;
/* 394 */     return "0" + str1.substring(str1.length() - 3) + str2.substring(str2.length() - 3) + str3.substring(str3.length() - 3) + str4.substring(str4.length() - 5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Object a(Object paramObject, d paramd) {
/* 405 */     Object object = null;
/* 406 */     switch (this.d)
/*     */     { case 2:
/* 408 */         object = paramd.b(paramObject);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 413 */         return object; }  l.c("Bad sibling axis"); return object;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(b paramb) {
/* 422 */     if (this.m == null) {
/* 423 */       this.m = new ArrayList<>();
/*     */     }
/* 425 */     if (this.h != null) {
/* 426 */       this.m.add(b.f());
/* 427 */       l.f(Level.WARNING, "Trying to append conditions to pseudoElement " + this.h);
/*     */     } 
/* 429 */     this.m.add(paramb);
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
/*     */   public final int n() {
/* 442 */     return this.n;
/*     */   }
/*     */   
/*     */   public final void f(String paramString) {
/* 446 */     this.e = paramString;
/* 447 */     this.k++;
/*     */   }
/*     */   
/*     */   public final void c(int paramInt) {
/* 451 */     this.l = paramInt;
/* 452 */     if (this.c != null) {
/* 453 */       this.c.c(paramInt);
/*     */     }
/* 455 */     if (this.b != null) {
/* 456 */       this.b.c(paramInt);
/*     */     }
/*     */   }
/*     */   
/*     */   public final void a(d paramd) {
/* 461 */     this.a = paramd;
/*     */   }
/*     */   
/*     */   public final void d(int paramInt) {
/* 465 */     this.d = paramInt;
/*     */   }
/*     */   
/*     */   public final void e(int paramInt) {
/* 469 */     this.i = paramInt;
/*     */   }
/*     */   
/*     */   public final void f(int paramInt) {
/* 473 */     this.j = paramInt;
/*     */   }
/*     */   
/*     */   public final void g(int paramInt) {
/* 477 */     this.k = paramInt;
/*     */   }
/*     */   
/*     */   public final void a(f paramf) {
/* 481 */     this.b = paramf;
/*     */   }
/*     */   
/*     */   public final void b(f paramf) {
/* 485 */     this.c = paramf;
/*     */   }
/*     */   
/*     */   public final void g(String paramString) {
/* 489 */     this.f = paramString;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\c\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */