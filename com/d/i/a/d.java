/*     */ package com.d.i.a;
/*     */ 
/*     */ import com.d.d.b;
/*     */ import com.d.d.q;
/*     */ import com.d.e.k;
/*     */ import com.d.e.s;
/*     */ import com.d.e.t;
/*     */ import com.d.f.f;
/*     */ import com.d.i.aa;
/*     */ import com.d.i.ab;
/*     */ import com.d.i.b.b;
/*     */ import com.d.i.c;
/*     */ import com.d.i.f;
/*     */ import com.d.i.y;
/*     */ import java.awt.Point;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.util.EnumSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
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
/*     */ {
/*     */   private void a(ab paramab, y paramy) {
/*  35 */     paramy.a();
/*  36 */     paramab.p().f(paramy.a());
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(ab paramab) {
/*  41 */     paramab.p().h();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(ab paramab, c paramc) {
/*     */     com.d.f.d d1;
/*  49 */     if (paramc.a().q() && (
/*     */       
/*  51 */       d1 = (com.d.f.d)paramc).m()) {
/*  52 */       d1.d(paramab);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(ab paramab, List<b> paramList, Map<f, List<k>> paramMap) {
/*  60 */     for (Iterator<b> iterator = paramList.iterator(); iterator.hasNext(); ) {
/*  61 */       y y; b b; if (b = iterator.next() instanceof y) {
/*  62 */         y = (y)b;
/*  63 */         a(paramab, y); continue;
/*  64 */       }  if (y instanceof com.d.i.z) {
/*     */         
/*  66 */         a(paramab); continue;
/*     */       } 
/*  68 */       c c = (c)y;
/*     */       
/*  70 */       Object object1 = paramab.p().a(q.f, (f)c);
/*  71 */       Object object2 = paramab.p().a(q.c, (f)c);
/*     */       
/*  73 */       a(paramab, c);
/*     */       
/*  75 */       c.b(paramab);
/*  76 */       c.c(paramab); f f;
/*     */       List list;
/*  78 */       if (paramMap != null && c instanceof f && (
/*     */ 
/*     */         
/*  81 */         f = (f)c).o() && (
/*     */ 
/*     */         
/*  84 */         list = paramMap.get(f)) != null) {
/*  85 */         for (Iterator<k> iterator1 = list.iterator(); iterator1.hasNext();) {
/*  86 */           (k = iterator1.next()).a().a(paramab, k.b());
/*     */         }
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*  92 */       paramab.p().a(object2);
/*  93 */       paramab.p().a(object1);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(ab paramab, List<b> paramList) {
/*  99 */     for (Iterator<b> iterator = paramList.iterator(); iterator.hasNext(); ) {
/* 100 */       b b; if (b = iterator.next() instanceof y) {
/* 101 */         y y = (y)b;
/* 102 */         a(paramab, y); continue;
/* 103 */       }  if (b instanceof com.d.i.z) {
/*     */         
/* 105 */         a(paramab); continue;
/*     */       } 
/* 107 */       Object object = paramab.p().a(q.i, (f)b);
/* 108 */       ((c)b).f(paramab);
/* 109 */       paramab.p().a(object);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void b(ab paramab, List<b> paramList) {
/* 115 */     for (Iterator<b> iterator = paramList.iterator(); iterator.hasNext(); ) {
/* 116 */       c.a a; b b; if (b = iterator.next() instanceof y) {
/* 117 */         y y = (y)b;
/* 118 */         a(paramab, y); continue;
/* 119 */       }  if (b instanceof com.d.i.z) {
/*     */         
/* 121 */         a(paramab); continue;
/* 122 */       }  if (b instanceof c) {
/*     */         c c;
/*     */         
/* 125 */         List<aa> list = (c = (c)b).af().k();
/*     */         
/* 127 */         EnumSet.noneOf(b.a.class); b b1; a = (b1 = new b(list)).a(paramab, c, paramab.w());
/*     */         
/* 129 */         a(paramab, a); continue;
/*     */       } 
/* 131 */       s s = (s)a;
/* 132 */       Object object = paramab.p().a(q.g, (f)a);
/* 133 */       s.a(paramab);
/* 134 */       paramab.p().a(object);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void c(ab paramab, List<b> paramList) {
/* 140 */     for (Iterator<b> iterator = paramList.iterator(); iterator.hasNext(); ) {
/* 141 */       y y; b b; if (b = iterator.next() instanceof y) {
/* 142 */         y = (y)b;
/* 143 */         a(paramab, y); continue;
/* 144 */       }  if (y instanceof com.d.i.z) {
/*     */         
/* 146 */         a(paramab); continue;
/*     */       } 
/* 148 */       c c = (c)y;
/* 149 */       b(paramab, c);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void b(ab paramab, c paramc) {
/* 156 */     Rectangle rectangle = paramc.c(paramc
/* 157 */         .ab(), paramc.aa(), (com.d.c.f.d)paramab);
/*     */ 
/*     */ 
/*     */     
/* 161 */     Point point = paramc.E().c();
/* 162 */     if (rectangle.x != point.x || rectangle.y != point.y) {
/* 163 */       paramc.E().a(rectangle.x, rectangle.y);
/*     */     }
/*     */     
/* 166 */     Object object = paramab.p().a(q.j, (f)paramc);
/* 167 */     paramab.p().a(paramab, paramc);
/* 168 */     paramab.p().a(object);
/*     */   }
/*     */   
/*     */   private void a(ab paramab, f paramf, int paramInt) {
/* 172 */     AffineTransform affineTransform = r.a(paramab, paramf, paramab.s(), paramInt);
/*     */     
/* 174 */     paramab.p().a(affineTransform);
/*     */   }
/*     */ 
/*     */   
/*     */   private void b(ab paramab) {
/* 179 */     paramab.p().g();
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(ab paramab, Rectangle paramRectangle) {
/* 184 */     paramab.p().f(paramRectangle);
/*     */   }
/*     */ 
/*     */   
/*     */   private void c(ab paramab) {
/* 189 */     paramab.p().h();
/*     */   }
/*     */   
/*     */   private static void a(ab paramab, t paramt) {
/* 193 */     paramt.b(paramab);
/*     */ 
/*     */     
/* 196 */     if (paramab.w() == -1) {
/*     */       b b1;
/*     */ 
/*     */ 
/*     */       
/* 201 */       (b1 = new b(paramab.s().d((com.d.c.f.d)paramab, 1), paramab.s().d((com.d.c.f.d)paramab, 3))).a(paramab, paramt); return;
/*     */     } 
/* 203 */     Rectangle rectangle = paramab.s().b((com.d.c.f.d)paramab, paramab.w());
/*     */     
/* 205 */     paramab.p().a(rectangle.x, 0.0D);
/*     */ 
/*     */     
/*     */     b b;
/*     */ 
/*     */     
/* 211 */     (b = new b(rectangle.x, paramab.s().d((com.d.c.f.d)paramab, 3))).a(paramab, paramt);
/*     */     
/* 213 */     paramab.p().a(-rectangle.x, 0.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(ab paramab, c.a parama) {
/* 218 */     for (Iterator<b> iterator = parama.b().iterator(); iterator.hasNext(); ) {
/*     */       b b;
/* 220 */       if (b = iterator.next() instanceof q) {
/*     */         
/* 222 */         b = b;
/*     */         
/* 224 */         Object object = paramab.p().a(q.c, b.a());
/* 225 */         b.a().h(paramab);
/* 226 */         paramab.p().a(object); continue;
/*     */       } 
/* 228 */       if (b instanceof i) {
/*     */         
/* 230 */         b = b;
/*     */         
/* 232 */         Object object1 = paramab.p().a(q.a, b.a());
/* 233 */         Object object2 = paramab.p().a(q.c, b.a());
/*     */         
/* 235 */         b.a().b(paramab);
/* 236 */         b.a().c(paramab);
/*     */         
/* 238 */         paramab.p().a(object2);
/* 239 */         paramab.p().a(object1); continue;
/*     */       } 
/* 241 */       if (b instanceof o) {
/*     */         
/* 243 */         b = b;
/* 244 */         b(paramab, b.a()); continue;
/*     */       } 
/* 246 */       if (b instanceof f) {
/*     */         
/* 248 */         b = b;
/* 249 */         a(paramab, b.a(), b.b());
/*     */         continue;
/*     */       } 
/* 252 */       if (b instanceof j) {
/*     */         
/* 254 */         b = b;
/* 255 */         a(paramab, b.a()); continue;
/*     */       } 
/* 257 */       if (b instanceof h) {
/*     */         
/* 259 */         b = b;
/* 260 */         b(paramab, b.a());
/*     */         continue;
/*     */       } 
/* 263 */       if (b instanceof p) {
/*     */         
/* 265 */         b = b;
/* 266 */         c(paramab, b.a()); continue;
/*     */       } 
/* 268 */       if (b instanceof n) {
/*     */         
/* 270 */         b = b;
/* 271 */         a(paramab, b.b(), b.a()); continue;
/*     */       } 
/* 273 */       if (b instanceof l) {
/*     */         
/* 275 */         b = b;
/* 276 */         b.a(); b(paramab); continue;
/*     */       } 
/* 278 */       if (b instanceof g) {
/*     */         
/* 280 */         b = b;
/* 281 */         Object object = paramab.p().a(q.b, b.a().f());
/* 282 */         a(paramab, b.a());
/* 283 */         paramab.p().a(object); continue;
/*     */       } 
/* 285 */       if (b instanceof m) {
/*     */         
/* 287 */         b = b;
/* 288 */         a(paramab, b.a()); continue;
/*     */       } 
/* 290 */       if (b instanceof k)
/*     */       {
/* 292 */         c(paramab);
/*     */       }
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\i\a\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */