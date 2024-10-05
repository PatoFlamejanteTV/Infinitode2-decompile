/*     */ package org.a.c.h.g.d.b;
/*     */ 
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.h.a.e;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class c
/*     */   extends e
/*     */ {
/*     */   public c() {}
/*     */   
/*     */   public c(d paramd) {
/*  47 */     super(paramd);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private c c() {
/*     */     b b;
/*  56 */     if (b = a().a(j.cN) instanceof d) {
/*     */       
/*  58 */       d d = (d)b;
/*  59 */       if (j.cE.equals(d.b(j.dN)))
/*     */       {
/*  61 */         return new a(d);
/*     */       }
/*  63 */       return new b(d);
/*     */     } 
/*  65 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   final void c(c paramc) {
/*  70 */     a().a(j.cN, (org.a.c.h.a.c)paramc);
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
/*     */   public final void a(b paramb) {
/*  82 */     b(paramb);
/*  83 */     c(paramb);
/*  84 */     d(paramb);
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
/*     */   private static void b(b paramb) {
/* 108 */     if (paramb.d() != null || paramb.c() != null)
/*     */     {
/* 110 */       throw new IllegalArgumentException("A single node with no siblings is required");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void c(b paramb) {
/* 122 */     paramb.c(this);
/* 123 */     if (!d()) {
/*     */       
/* 125 */       a(paramb);
/*     */     } else {
/*     */       b b1;
/*     */ 
/*     */       
/* 130 */       (b1 = h()).b(paramb);
/* 131 */       paramb.a(b1);
/*     */     } 
/* 133 */     b(paramb);
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
/*     */   private static void d(b paramb) {
/* 160 */     int i = 1;
/* 161 */     if (paramb.b())
/*     */     {
/* 163 */       i = 1 + paramb.e();
/*     */     }
/* 165 */     paramb.a(i);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean d() {
/* 173 */     return (g() != null);
/*     */   }
/*     */ 
/*     */   
/*     */   final b a(j paramj) {
/*     */     b b;
/* 179 */     if (b = a().a(paramj) instanceof d)
/*     */     {
/* 181 */       return new b((d)b);
/*     */     }
/* 183 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private b g() {
/* 191 */     return a(j.aZ);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(c paramc) {
/* 201 */     a().a(j.aZ, (org.a.c.h.a.c)paramc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private b h() {
/* 209 */     return a(j.bV);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(c paramc) {
/* 219 */     a().a(j.bV, (org.a.c.h.a.c)paramc);
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
/*     */   public final int e() {
/* 231 */     return a().b(j.ag, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(int paramInt) {
/* 241 */     a().a(j.ag, paramInt);
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
/*     */   public boolean b() {
/* 281 */     return (e() > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final void a(int paramInt) {
/*     */     c c1;
/* 292 */     if ((c1 = c()) != null) {
/*     */       
/* 294 */       if (c1.b()) {
/*     */         
/* 296 */         c1.b(c1.e() + paramInt);
/* 297 */         c1.a(paramInt);
/*     */         
/*     */         return;
/*     */       } 
/* 301 */       c1.b(c1.e() - paramInt);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\g\d\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */