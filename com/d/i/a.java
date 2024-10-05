/*     */ package com.d.i;
/*     */ 
/*     */ import com.d.c.a.c;
/*     */ import com.d.c.d.g;
/*     */ import com.d.c.d.h;
/*     */ import com.d.c.d.j;
/*     */ import com.d.c.f.a.e;
/*     */ import com.d.c.f.c;
/*     */ import com.d.c.f.d;
/*     */ import com.d.d.c;
/*     */ import com.d.d.m;
/*     */ import com.d.m.b;
/*     */ import com.d.m.k;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.Shape;
/*     */ import java.awt.geom.Area;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class a
/*     */   implements m
/*     */ {
/*     */   private com.d.c.g.a a;
/*     */   
/*     */   protected abstract void e(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*     */   
/*     */   public final void a(ab paramab, s params) {
/*  66 */     r r = params.g();
/*  67 */     String str = params.d();
/*     */ 
/*     */     
/*  70 */     if (params.a() == 1) {
/*     */       com.d.a.a a1;
/*  72 */       str = (a1 = paramab.g()).a(str);
/*     */     } 
/*     */     
/*  75 */     if (str != null && str.length() > 0) {
/*  76 */       a(r.a().b());
/*  77 */       a(r.a().d(paramab));
/*  78 */       a(r.a().h());
/*  79 */       if (params.b() != 0.0F) {
/*     */         t t;
/*  81 */         (t = new t()).a(params.b());
/*  82 */         t.b(params.b());
/*  83 */         paramab.f().a(paramab
/*  84 */             .p(), str, (r
/*     */             
/*  86 */             .ab() + params.e()), (r.aa() + r.c()), t);
/*     */       }
/*  88 */       else if (params.g().a().at()) {
/*     */         t t;
/*     */ 
/*     */         
/*  92 */         if ((t = params.g().k().m()) != null) {
/*  93 */           paramab.f().a(paramab
/*  94 */               .p(), str, (r
/*     */               
/*  96 */               .ab() + params.e()), (r.aa() + r.c()), t);
/*     */         } else {
/*     */           
/*  99 */           paramab.f().a(paramab
/* 100 */               .p(), str, (r
/*     */               
/* 102 */               .ab() + params.e()), (r.aa() + r.c()));
/*     */         } 
/*     */       } else {
/* 105 */         paramab.f().a(paramab
/* 106 */             .p(), str, (r
/*     */             
/* 108 */             .ab() + params.e()), (r.aa() + r.c()));
/*     */       } 
/*     */     } 
/*     */     
/* 112 */     if (paramab.m()) {
/* 113 */       b(paramab, params);
/*     */     }
/*     */   }
/*     */   
/*     */   private void b(ab paramab, s params) {
/* 118 */     r r = params.g();
/* 119 */     String str = params.d();
/*     */     
/* 121 */     a((g)new h(255, 51, 255));
/*     */     
/* 123 */     l l = r.a().e(null);
/* 124 */     paramab
/* 125 */       .q(); int i = paramab.f().a(r
/* 126 */         .a().d(paramab), str);
/* 127 */     int j = r.ab() + params.e();
/* 128 */     int k = r.aa() + r.c();
/*     */     
/* 130 */     e(j, k, j + i, k);
/*     */     
/* 132 */     k += (int)Math.ceil(l.b());
/* 133 */     e(j, k, j + i, k);
/*     */ 
/*     */     
/* 136 */     k = (k = k - (int)Math.ceil(l.b())) - (int)Math.ceil(l.a());
/* 137 */     e(j, k, j + i, k);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(ab paramab, r paramr, ad paramad) {
/* 142 */     a(paramr.a().b());
/*     */     
/* 144 */     Rectangle rectangle = paramr.c(paramr.ab(), paramr.aa(), paramab);
/*     */     
/* 146 */     c(rectangle.x, paramr.aa() + paramad.a(), rectangle.width, paramad
/* 147 */         .b());
/*     */   }
/*     */   
/*     */   public final void a(u paramu) {
/* 151 */     a(paramu.a().b());
/* 152 */     f f = paramu.U();
/*     */     List<ad> list;
/* 154 */     for (ad ad : list = paramu.h()) {
/*     */       
/* 156 */       if (f.a().a(com.d.c.a.a.v, c.h)) {
/*     */         
/* 158 */         c(paramu
/* 159 */             .ab(), paramu
/* 160 */             .aa() + ad.a(), f
/* 161 */             .ab() + f.ap() + f.d_() - paramu.ab(), ad
/* 162 */             .b()); continue;
/*     */       } 
/* 164 */       c(paramu
/* 165 */           .ab(), paramu.aa() + ad.a(), paramu
/* 166 */           .d_(), ad
/* 167 */           .b());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(ab paramab, f paramf, g paramg) {
/* 173 */     a(paramg);
/*     */     Rectangle rectangle;
/* 175 */     (rectangle = paramf.a(paramf.ab(), paramf.aa(), paramab, 0, 0)).height--;
/* 176 */     rectangle.width--;
/* 177 */     a(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(ab paramab, com.d.c.f.a.a parama, Rectangle paramRectangle, int paramInt) {
/* 182 */     e.a(paramRectangle, paramInt, parama, paramab, 0, false);
/*     */   }
/*     */   
/*     */   public final void a(ab paramab, f paramf) {
/* 186 */     if (!paramf.a().a(paramab, paramf)) {
/*     */       return;
/*     */     }
/*     */     
/*     */     Rectangle rectangle;
/*     */     
/* 192 */     e.a(rectangle = paramf.j(paramab), paramf.ad(), paramf.b(paramab), paramab, 0, true);
/*     */   }
/*     */   
/*     */   public final void a(ab paramab, c paramc, Rectangle paramRectangle, int paramInt) {
/* 196 */     e.a(paramRectangle, paramInt, paramc.a(paramab), paramab, 0, true);
/*     */   }
/*     */   
/*     */   private static c a(ab paramab, c paramc) {
/* 200 */     if (!paramc.a(com.d.c.a.a.d, c.ap)) {
/* 201 */       String str = paramc.f(com.d.c.a.a.d);
/*     */       try {
/* 203 */         return paramab.e().b(str).d();
/* 204 */       } catch (Exception exception) {
/* 205 */         (paramab = null).printStackTrace();
/* 206 */         k.b(paramab);
/*     */       } 
/*     */     } 
/* 209 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(ab paramab, c paramc, Rectangle paramRectangle1, Rectangle paramRectangle2, com.d.c.f.a.a parama) {
/* 215 */     b(paramab, paramc, paramRectangle1, paramRectangle2, parama);
/*     */   }
/*     */   
/*     */   public void b(ab paramab, f paramf) {
/* 219 */     if (!paramf.a().a(paramab, paramf)) {
/*     */       return;
/*     */     }
/*     */     
/* 223 */     Rectangle rectangle = paramf.j(paramab);
/* 224 */     com.d.c.f.a.a a1 = paramf.a().a(paramab);
/* 225 */     b(paramab, paramf.a(), rectangle, rectangle, a1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(ab paramab, c paramc, Rectangle paramRectangle1, Rectangle paramRectangle2, com.d.c.f.a.a parama) {
/* 232 */     if (!b.a("xr.renderer.draw.backgrounds", true)) {
/*     */       return;
/*     */     }
/*     */     
/* 236 */     g g = paramc.c();
/*     */ 
/*     */     
/*     */     c c1;
/*     */     
/* 241 */     if ((c1 = a(paramab, paramc)) == null || c1.b() == 0 || c1.a() == 0) {
/* 242 */       c1 = null;
/*     */     }
/*     */     
/* 245 */     if ((g == null || g == h.a) && c1 == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 250 */     Area area = new Area(e.a(paramRectangle1, parama, true));
/*     */     
/* 252 */     Shape shape = null;
/*     */     
/* 254 */     if (!paramab.d()) {
/*     */       
/* 256 */       if ((shape = c()) != null)
/*     */       {
/* 258 */         area.intersect(new Area(shape));
/*     */       }
/* 260 */       e(area);
/* 261 */     } else if (c1 != null) {
/* 262 */       f(area);
/*     */     } 
/*     */     
/* 265 */     if (g != null && g != h.a) {
/* 266 */       a(g);
/* 267 */       c(area);
/*     */     } 
/*     */     
/* 270 */     if (c1 != null) {
/* 271 */       Rectangle rectangle; paramRectangle2 = paramRectangle2;
/* 272 */       if (paramc.n()) {
/* 273 */         paramRectangle2 = paramab.i();
/*     */       }
/*     */       
/* 276 */       int i = paramRectangle2.x;
/* 277 */       int j = paramRectangle2.y;
/*     */       
/* 279 */       if (parama != null) {
/* 280 */         i += (int)parama.w();
/* 281 */         j += (int)parama.t();
/*     */       } 
/*     */       
/* 284 */       a(paramab, paramc, paramRectangle2, c1);
/*     */       
/* 286 */       float f1 = c1.a();
/* 287 */       float f2 = c1.b();
/*     */       
/* 289 */       com.d.m.a a1 = paramc.e();
/* 290 */       i += a(paramab, paramc, a1
/* 291 */           .a(), paramRectangle2.width, f1);
/* 292 */       j += a(paramab, paramc, a1
/* 293 */           .b(), paramRectangle2.height, f2);
/*     */       
/* 295 */       boolean bool1 = paramc.T();
/* 296 */       boolean bool2 = paramc.U();
/*     */       
/* 298 */       if (!bool1 && !bool2) {
/*     */         
/* 300 */         if ((rectangle = new Rectangle(i, j, (int)f1, (int)f2)).intersects(paramRectangle1)) {
/* 301 */           a(c1, i, j, paramc.al());
/*     */         }
/* 303 */       } else if (rectangle != null && bool2) {
/* 304 */         a(c1, 
/*     */             
/* 306 */             a(paramRectangle1.x, i, (int)f1), 
/* 307 */             a(paramRectangle1.y, j, (int)f2), paramRectangle1.x + paramRectangle1.width, paramRectangle1.y + paramRectangle1.height, paramc
/*     */             
/* 309 */             .al());
/* 310 */       } else if (rectangle != null) {
/* 311 */         i = a(paramRectangle1.x, i, (int)f1);
/*     */         
/* 313 */         if ((rectangle = new Rectangle(i, j, (int)f1, (int)f2)).intersects(paramRectangle1)) {
/* 314 */           b(c1, i, j, paramRectangle1.x + paramRectangle1.width, paramc
/*     */ 
/*     */ 
/*     */               
/* 318 */               .al());
/*     */         }
/*     */       } else {
/* 321 */         j = a(paramRectangle1.y, j, (int)f2);
/*     */         
/* 323 */         if (bool2 && (rectangle = new Rectangle(i, j, (int)f1, (int)f2)).intersects(paramRectangle1)) {
/* 324 */           a(c1, i, j, paramRectangle1.y + paramRectangle1.height, paramc
/*     */ 
/*     */ 
/*     */               
/* 328 */               .al());
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 333 */     if (!paramab.d()) {
/* 334 */       e(shape); return;
/* 335 */     }  if (c1 != null) {
/* 336 */       h();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static int a(int paramInt1, int paramInt2, int paramInt3) {
/* 342 */     if ((paramInt2 = paramInt2) > paramInt1) {
/* 343 */       while (paramInt2 > paramInt1) {
/* 344 */         paramInt2 -= paramInt3;
/*     */       }
/* 346 */     } else if (paramInt2 < paramInt1) {
/* 347 */       while (paramInt2 < paramInt1) {
/* 348 */         paramInt2 += paramInt3;
/*     */       }
/* 350 */       if (paramInt2 != paramInt1) {
/* 351 */         paramInt2 -= paramInt3;
/*     */       }
/*     */     } 
/* 354 */     return paramInt2;
/*     */   }
/*     */   
/*     */   private void a(c paramc, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean) {
/* 358 */     int i = paramc.a();
/* 359 */     int j = paramc.b();
/*     */     
/* 361 */     for (paramInt1 = paramInt1; paramInt1 < paramInt3; paramInt1 += i) {
/* 362 */       int k; for (k = paramInt2; k < paramInt4; k += j) {
/* 363 */         a(paramc, paramInt1, k, paramBoolean);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void a(c paramc, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
/* 369 */     int i = paramc.b();
/*     */     
/* 371 */     for (paramInt2 = paramInt2; paramInt2 < paramInt3; paramInt2 += i) {
/* 372 */       a(paramc, paramInt1, paramInt2, paramBoolean);
/*     */     }
/*     */   }
/*     */   
/*     */   private void b(c paramc, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
/* 377 */     int i = paramc.a();
/*     */     
/* 379 */     for (paramInt1 = paramInt1; paramInt1 < paramInt3; paramInt1 += i)
/* 380 */       a(paramc, paramInt1, paramInt2, paramBoolean); 
/*     */   }
/*     */   
/*     */   private static int a(d paramd, c paramc, j paramj, float paramFloat1, float paramFloat2) {
/*     */     float f;
/* 385 */     if (paramj.a() == 2) {
/* 386 */       f = paramj.f() / 100.0F;
/* 387 */       return Math.round(paramFloat1 * f - paramFloat2 * f);
/*     */     } 
/* 389 */     return (int)e.a(paramc, com.d.c.a.a.g, paramj
/*     */ 
/*     */         
/* 392 */         .d(), paramj
/* 393 */         .f(), paramj
/* 394 */         .a(), 0.0F, f);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(d paramd, c paramc, Rectangle paramRectangle, c paramc1) {
/*     */     com.d.c.f.a a1;
/* 403 */     if (!(a1 = paramc.d()).c()) {
/* 404 */       if (a1.b() || a1.a()) {
/* 405 */         int k = (int)(paramc1.b() * paramRectangle.width / paramc1.a());
/* 406 */         if (a1.a())
/* 407 */         { if (k <= paramRectangle.height) {
/*     */ 
/*     */             
/* 410 */             paramc1.a(paramRectangle.width, -1); return;
/*     */           }  }
/* 412 */         else if (a1.b())
/* 413 */         { if (k > paramRectangle.height)
/* 414 */           { paramc1.a(paramRectangle.width, -1); return; }  }
/*     */         else { return; }
/* 416 */          paramc1.a(-1, paramRectangle.height);
/*     */         
/*     */         return;
/*     */       } 
/* 420 */       int j = a(paramd, paramc, a1.d(), paramRectangle.width);
/* 421 */       int i = a(paramd, paramc, a1.e(), paramRectangle.height);
/*     */       
/* 423 */       paramc1.a(j, i);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static int a(d paramd, c paramc, j paramj, float paramFloat) {
/*     */     float f;
/* 429 */     if (paramj.a() == 21)
/* 430 */       return -1; 
/* 431 */     if (paramj.a() == 2) {
/* 432 */       f = paramj.f() / 100.0F;
/* 433 */       return Math.round(paramFloat * f);
/*     */     } 
/* 435 */     return (int)e.a(paramc, com.d.c.a.a.h, paramj
/*     */ 
/*     */         
/* 438 */         .d(), paramj
/* 439 */         .f(), paramj
/* 440 */         .a(), 0.0F, f);
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
/*     */   public final com.d.c.g.a o() {
/* 452 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(com.d.c.g.a parama) {
/* 461 */     this.a = parama;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean f() {
/* 466 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\i\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */