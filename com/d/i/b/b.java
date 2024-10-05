/*     */ package com.d.i.b;
/*     */ 
/*     */ import com.d.c.f.d;
/*     */ import com.d.e.k;
/*     */ import com.d.e.s;
/*     */ import com.d.e.t;
/*     */ import com.d.f.f;
/*     */ import com.d.i.a.r;
/*     */ import com.d.i.ab;
/*     */ import com.d.i.c;
/*     */ import com.d.i.f;
/*     */ import com.d.i.y;
/*     */ import java.awt.Point;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ public final class b
/*     */ {
/*     */   private final int a;
/*     */   private final int b;
/*     */   
/*     */   public b(int paramInt1, int paramInt2) {
/*  27 */     this.a = paramInt1;
/*  28 */     this.b = paramInt2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(ab paramab, t paramt) {
/*  36 */     f f = paramt.f();
/*     */     
/*     */     Rectangle rectangle;
/*  39 */     if ((rectangle = paramt.f().a(paramab, paramt.d())) != null) {
/*  40 */       paramab.p().f(rectangle);
/*     */     }
/*     */     
/*  43 */     if (paramt.b()) {
/*     */ 
/*     */       
/*  46 */       AffineTransform affineTransform = paramab.x() ? r.a(paramab, f, paramab.s(), this.a, this.b) : r.a(paramab, f, paramab.s(), paramab.w());
/*     */       
/*  48 */       paramab.p().a(affineTransform);
/*     */     } 
/*     */     
/*  51 */     if (!paramt.j() && ((c)f).A()) {
/*  52 */       a(paramab, f);
/*  53 */       a(paramab, (c)f);
/*     */     } else {
/*     */       a a;
/*  56 */       (a = new a()).a(paramab, paramt);
/*     */       
/*  58 */       if (!paramt.j() && f instanceof c) {
/*  59 */         a(paramab, f);
/*     */       }
/*     */       
/*  62 */       if (paramt.h() || paramt.e() || f.a().B()) {
/*  63 */         e(paramab, paramt.b(3));
/*     */       }
/*     */ 
/*     */       
/*  67 */       Map<f, List<k>> map = a.c().isEmpty() ? null : com.d.i.a.b.a(a.c());
/*     */       
/*  69 */       a(paramab, a.a(), map);
/*  70 */       d(paramab, paramt.g());
/*  71 */       a(paramab, a.e());
/*  72 */       b(paramab, a.b());
/*  73 */       c(paramab, a.d());
/*     */       
/*  75 */       if (paramt.h() || paramt.e() || f.a().B()) {
/*  76 */         e(paramab, paramt.a(4));
/*     */         
/*  78 */         e(paramab, paramt.b(2));
/*  79 */         e(paramab, paramt.b(1));
/*     */       } 
/*     */     } 
/*     */     
/*  83 */     if (paramt.b()) {
/*  84 */       paramab.p().g();
/*     */     }
/*     */     
/*  87 */     if (rectangle != null) {
/*  88 */       paramab.p().h();
/*     */     }
/*     */   }
/*     */   
/*     */   private static void a(ab paramab, f paramf) {
/*  93 */     paramf.b(paramab);
/*  94 */     paramf.c(paramab);
/*     */   }
/*     */   
/*     */   private void a(ab paramab, y paramy) {
/*  98 */     paramy.a();
/*  99 */     paramab.p().f(paramy.a());
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(ab paramab) {
/* 104 */     paramab.p().h();
/*     */   }
/*     */   
/*     */   private void a(ab paramab, List<com.d.d.b> paramList, Map<f, List<k>> paramMap) {
/* 108 */     for (Iterator<com.d.d.b> iterator = paramList.iterator(); iterator.hasNext(); ) {
/* 109 */       y y; com.d.d.b b1; if (b1 = iterator.next() instanceof y) {
/* 110 */         y = (y)b1;
/* 111 */         a(paramab, y); continue;
/* 112 */       }  if (y instanceof com.d.i.z) {
/*     */         
/* 114 */         a(paramab);
/*     */         
/*     */         continue;
/*     */       } 
/*     */       c c;
/* 119 */       (c = (c)y).b(paramab);
/* 120 */       c.c(paramab); List list;
/*     */       f f;
/* 122 */       if (paramMap != null && c instanceof f && (
/*     */ 
/*     */         
/* 125 */         f = (f)c).o() && (
/*     */ 
/*     */         
/* 128 */         list = paramMap.get(f)) != null) {
/* 129 */         for (Iterator<k> iterator1 = list.iterator(); iterator1.hasNext();) {
/* 130 */           (k = iterator1.next()).a().a(paramab, k.b());
/*     */         }
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(ab paramab, List<com.d.d.b> paramList) {
/* 141 */     for (Iterator<com.d.d.b> iterator = paramList.iterator(); iterator.hasNext(); ) {
/* 142 */       y y; com.d.d.b b1; if (b1 = iterator.next() instanceof y) {
/* 143 */         y = (y)b1;
/* 144 */         a(paramab, y); continue;
/* 145 */       }  if (y instanceof com.d.i.z) {
/*     */         
/* 147 */         a(paramab);
/*     */         continue;
/*     */       } 
/* 150 */       ((c)y).f(paramab);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void b(ab paramab, List<com.d.d.b> paramList) {
/* 156 */     for (Iterator<com.d.d.b> iterator = paramList.iterator(); iterator.hasNext(); ) {
/* 157 */       y y; c c; com.d.d.b b1; if (b1 = iterator.next() instanceof y) {
/* 158 */         y = (y)b1;
/* 159 */         a(paramab, y); continue;
/* 160 */       }  if (y instanceof com.d.i.z) {
/*     */         
/* 162 */         a(paramab); continue;
/* 163 */       }  if (y instanceof c) {
/*     */         
/* 165 */         c = (c)y;
/* 166 */         b(paramab, c);
/*     */         continue;
/*     */       } 
/*     */       s s;
/* 170 */       (s = (s)c).a(paramab);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(ab paramab, c paramc) {
/* 178 */     Rectangle rectangle = paramc.c(paramc
/* 179 */         .ab(), paramc.aa(), (d)paramab);
/*     */ 
/*     */ 
/*     */     
/* 183 */     Point point = paramc.E().c();
/* 184 */     if (rectangle.x != point.x || rectangle.y != point.y) {
/* 185 */       paramc.E().a(rectangle.x, rectangle.y);
/*     */     }
/*     */     
/* 188 */     paramab.p().a(paramab, paramc);
/*     */   }
/*     */   
/*     */   private void c(ab paramab, List<com.d.d.b> paramList) {
/* 192 */     for (Iterator<com.d.d.b> iterator = paramList.iterator(); iterator.hasNext(); ) {
/* 193 */       y y; com.d.d.b b1; if (b1 = iterator.next() instanceof y) {
/* 194 */         y = (y)b1;
/* 195 */         a(paramab, y); continue;
/* 196 */       }  if (y instanceof com.d.i.z) {
/*     */         
/* 198 */         a(paramab); continue;
/*     */       } 
/* 200 */       c c = (c)y;
/* 201 */       a(paramab, c);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void d(ab paramab, List<c> paramList) {
/* 207 */     for (int i = paramList.size() - 1; i >= 0; i--) {
/* 208 */       b(paramab, paramList.get(i));
/*     */     }
/*     */   }
/*     */   
/*     */   private void e(ab paramab, List<t> paramList) {
/* 213 */     for (t t : paramList) {
/* 214 */       a(paramab, t);
/*     */     }
/*     */   }
/*     */   
/*     */   private void b(ab paramab, c paramc) {
/* 219 */     if (paramc.a().O()) {
/*     */       return;
/*     */     }
/*     */     
/*     */     a a;
/* 224 */     (a = new a()).a(paramab, paramc.af(), (f)paramc);
/*     */     
/* 226 */     Map<f, List<k>> map = a.c().isEmpty() ? null : com.d.i.a.b.a(a.c());
/*     */     
/* 228 */     a(paramab, a.a(), map);
/* 229 */     a(paramab, a.e());
/* 230 */     b(paramab, a.b());
/* 231 */     c(paramab, a.d());
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\i\b\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */