/*     */ package com.d.e;
/*     */ 
/*     */ import com.d.c.a.c;
/*     */ import com.d.i.f;
/*     */ import com.d.i.r;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class af
/*     */ {
/*  39 */   private List a = new ArrayList();
/*     */   
/*     */   private int b;
/*     */   
/*     */   private boolean c = false;
/*     */   
/*     */   private int d;
/*     */   
/*     */   private boolean e = false;
/*     */   
/*     */   private int f;
/*     */   private boolean g = false;
/*     */   private int h;
/*     */   private boolean i = false;
/*  53 */   private List j = new ArrayList();
/*     */   
/*  55 */   private af k = null;
/*     */   
/*     */   private void e(int paramInt) {
/*  58 */     if (this.c) {
/*  59 */       this.b += paramInt;
/*     */     }
/*     */     
/*  62 */     if (this.e) {
/*  63 */       this.d += paramInt;
/*     */     }
/*     */     
/*  66 */     if (this.g) {
/*  67 */       this.f += paramInt;
/*     */     }
/*     */     
/*  70 */     if (this.i) {
/*  71 */       this.h += paramInt;
/*     */     }
/*     */   }
/*     */   
/*     */   public final int a() {
/*  76 */     return this.d;
/*     */   }
/*     */   
/*     */   public final int b() {
/*  80 */     return this.b;
/*     */   }
/*     */   
/*     */   public final void a(int paramInt) {
/*  84 */     if (!this.c || paramInt < this.b) {
/*  85 */       this.b = paramInt;
/*  86 */       this.c = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void b(int paramInt) {
/*  91 */     if (!this.g || paramInt < this.f) {
/*  92 */       this.f = paramInt;
/*  93 */       this.g = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void c(int paramInt) {
/*  98 */     if (!this.e || paramInt > this.d) {
/*  99 */       this.d = paramInt;
/* 100 */       this.e = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void d(int paramInt) {
/* 105 */     if (!this.i || paramInt > this.h) {
/* 106 */       this.h = paramInt;
/* 107 */       this.i = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public final int c() {
/* 112 */     return this.d - this.b;
/*     */   }
/*     */   
/*     */   public final void a(p paramp) {
/* 116 */     this.a.add(paramp);
/*     */     
/* 118 */     a(paramp.c());
/* 119 */     c(paramp.b());
/*     */     
/* 121 */     b(paramp.g());
/* 122 */     d(paramp.f());
/*     */   }
/*     */   
/*     */   public final p d() {
/* 126 */     return this.a.get(this.a.size() - 1);
/*     */   }
/*     */   
/*     */   public final void e() {
/* 130 */     this.a.remove(this.a.size() - 1);
/*     */   }
/*     */   
/*     */   public final int f() {
/* 134 */     return this.h;
/*     */   }
/*     */   
/*     */   public final int g() {
/* 138 */     return this.f;
/*     */   }
/*     */   
/*     */   public final af a(f paramf) {
/* 142 */     af af1 = new af();
/*     */     
/* 144 */     af af2 = k();
/*     */     
/* 146 */     af1.b(af2);
/*     */     
/* 148 */     p p = af2.a.get(0);
/* 149 */     af1.a(p);
/*     */     
/* 151 */     if (af2.j == null) {
/* 152 */       af2.j = new ArrayList();
/*     */     }
/*     */     
/* 155 */     af2.j.add(new a(paramf, af1));
/*     */     
/* 157 */     return af1;
/*     */   }
/*     */   
/*     */   private List i() {
/* 161 */     return (this.j == null) ? Collections.EMPTY_LIST : this.j;
/*     */   }
/*     */   
/*     */   private af j() {
/* 165 */     return this.k;
/*     */   }
/*     */   
/*     */   private void b(af paramaf) {
/* 169 */     this.k = paramaf;
/*     */   }
/*     */   
/*     */   private af k() {
/*     */     af af1;
/* 174 */     return ((af1 = this).j() != null) ? af1.j() : this;
/*     */   }
/*     */   
/*     */   private void c(af paramaf) {
/* 178 */     c(paramaf.a());
/* 179 */     a(paramaf.b());
/*     */     
/* 181 */     d(paramaf.f());
/* 182 */     b(paramaf.g());
/*     */   }
/*     */   
/*     */   public final void h() {
/* 186 */     List<a> list = i();
/* 187 */     for (byte b = 0; b < list.size(); b++) {
/*     */       a a;
/* 189 */       (a = list.get(b)).b();
/* 190 */       c(a.a());
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void b(p paramp) {
/* 195 */     this.a.add(paramp);
/*     */   }
/*     */ 
/*     */   
/*     */   static final class a
/*     */   {
/*     */     private f a;
/*     */     private af b;
/*     */     
/*     */     public a() {}
/*     */     
/*     */     public a(f param1f, af param1af) {
/* 207 */       this.a = param1f;
/* 208 */       this.b = param1af;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final af a() {
/* 220 */       return this.b;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void a(int param1Int) {
/* 228 */       a(this.a, param1Int);
/*     */     }
/*     */     
/*     */     private void a(f param1f, int param1Int) {
/* 232 */       if (a(param1f)) {
/* 233 */         param1f.o(param1f.an() + param1Int);
/* 234 */         if (param1f instanceof r) {
/* 235 */           r r = (r)param1f;
/* 236 */           for (byte b = 0; b < r.e(); b++) {
/*     */             Object object;
/* 238 */             if (object = r.b(b) instanceof f) {
/* 239 */               a((f)object, param1Int);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/*     */     private boolean a(f param1f) {
/* 247 */       c c = param1f.a().e(com.d.c.a.a.as);
/* 248 */       return (param1f == this.a || (c != c.bi && c != c.l));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final void b() {
/*     */       int i;
/*     */       c c;
/* 256 */       if ((c = this.a.a().e(com.d.c.a.a.as)) == c.bi) {
/*     */         
/* 258 */         i = af.a(this.b).b() - this.b.b();
/* 259 */       } else if (i == c.l) {
/*     */         
/* 261 */         i = af.a(this.b).a() - this.b.a();
/*     */       } else {
/* 263 */         throw new RuntimeException("internal error");
/*     */       } 
/*     */       
/* 266 */       af.a(this.b, i);
/* 267 */       a(i);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\e\af.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */