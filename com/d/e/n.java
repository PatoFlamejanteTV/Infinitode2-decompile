/*     */ package com.d.e;
/*     */ 
/*     */ import com.d.c.f.d;
/*     */ import com.d.i.f;
/*     */ import com.d.i.u;
/*     */ import java.awt.Point;
/*     */ import java.awt.Rectangle;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
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
/*     */ public final class n
/*     */ {
/*  44 */   private List<b> a = Collections.emptyList();
/*  45 */   private List<b> b = Collections.emptyList();
/*     */   
/*     */   private final f c;
/*     */   
/*     */   public n(f paramf) {
/*  50 */     this.c = paramf;
/*     */   }
/*     */   
/*     */   private List<b> a(int paramInt) {
/*  54 */     if (b(paramInt).isEmpty()) {
/*  55 */       a(paramInt, new ArrayList<>());
/*     */     }
/*     */     
/*  58 */     return b(paramInt);
/*     */   }
/*     */   
/*     */   private void a(int paramInt, List<b> paramList) {
/*  62 */     if (paramInt == 1) {
/*  63 */       this.a = paramList; return;
/*     */     } 
/*  65 */     this.b = paramList;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(v paramv, t paramt, b paramb, com.d.i.c paramc) {
/*  70 */     if (paramc.a().D()) {
/*  71 */       a(paramv, paramb, paramc, 1);
/*  72 */       a(paramc, paramt, paramb, 1); return;
/*  73 */     }  if (paramc.a().E()) {
/*  74 */       a(paramv, paramb, paramc, 2);
/*  75 */       a(paramc, paramt, paramb, 2);
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void a(d paramd, b paramb, f paramf) {
/*  80 */     if (paramf.a().k()) {
/*  81 */       b(paramd, paramb, paramf, b(1));
/*     */     }
/*  83 */     if (paramf.a().l()) {
/*  84 */       b(paramd, paramb, paramf, b(2));
/*     */     }
/*     */   }
/*     */   
/*     */   private void a(com.d.i.c paramc, t paramt, b paramb, int paramInt) {
/*  89 */     Point point = paramb.a();
/*  90 */     a(paramInt).add(new b(paramc, point.x, point.y));
/*  91 */     paramt.b(paramc);
/*     */     
/*  93 */     paramc.L().a(this);
/*  94 */     paramc.B();
/*  95 */     paramc.C();
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(d paramd, b paramb, com.d.i.c paramc, int paramInt) {
/* 100 */     a(paramc, paramInt);
/*     */     
/* 102 */     c(paramd, paramb, paramc, paramInt);
/* 103 */     b(paramd, paramb, paramc, paramInt);
/*     */     
/* 105 */     if (!c(paramc) || 
/* 106 */       a(paramd, paramb, paramc, b(paramInt))) {
/* 107 */       a(paramc, paramInt);
/* 108 */       a(paramd, paramb, (f)paramc, b(paramInt));
/*     */     } 
/*     */     
/* 111 */     if (a(paramd, paramb, paramc, c(paramInt))) {
/* 112 */       a(paramc, paramInt);
/* 113 */       a(paramd, paramb, (f)paramc, b(paramInt));
/* 114 */       a(paramd, paramb, (f)paramc, c(paramInt));
/*     */     } 
/*     */     
/* 117 */     if (paramc.a().m()) {
/* 118 */       if (paramc.a().k() && paramInt == 1) {
/* 119 */         a(paramc, 1);
/* 120 */       } else if (paramc.a().l() && paramInt == 2) {
/* 121 */         a(paramc, 2);
/*     */       } 
/* 123 */       a(paramd, paramb, (f)paramc, b(paramInt));
/*     */     } 
/*     */   }
/*     */   
/*     */   private List<b> b(int paramInt) {
/* 128 */     return (paramInt == 1) ? this.a : this.b;
/*     */   }
/*     */   
/*     */   private List<b> c(int paramInt) {
/* 132 */     return (paramInt == 1) ? this.b : this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(d paramd, b paramb, com.d.i.c paramc, int paramInt) {
/*     */     List<b> list;
/* 139 */     if ((list = b(paramInt)).size() > 0) {
/* 140 */       Point point = paramb.a();
/*     */       b b1;
/* 142 */       com.d.i.c c1 = (b1 = list.get(list.size() - 1)).a();
/*     */       
/* 144 */       Rectangle rectangle2 = paramc.a(paramd, -point.x, -point.y);
/*     */       
/* 146 */       Rectangle rectangle1 = c1.a(paramd, -b1.b(), -b1.c());
/*     */       
/* 148 */       boolean bool = false;
/*     */       
/* 150 */       if (rectangle2.y < rectangle1.y) {
/* 151 */         rectangle2.translate(0, rectangle1.y - rectangle2.y);
/* 152 */         bool = true;
/*     */       } 
/*     */       
/* 155 */       if (rectangle2.y >= rectangle1.y && rectangle2.y < rectangle1.y + rectangle1.height) {
/* 156 */         bool = true;
/*     */       }
/*     */       
/* 159 */       if (bool) {
/* 160 */         if (paramInt == 1) {
/* 161 */           rectangle1.x += c1.Q();
/* 162 */         } else if (paramInt == 2) {
/* 163 */           rectangle1.x -= paramc.Q();
/*     */         } 
/*     */         
/* 166 */         rectangle2.translate(point.x, point.y);
/*     */         
/* 168 */         paramc.n(rectangle2.x);
/* 169 */         paramc.o(rectangle2.y);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void c(d paramd, b paramb, com.d.i.c paramc, int paramInt) {
/*     */     List<b> list;
/* 178 */     if ((list = c(paramInt)).size() > 0) {
/* 179 */       Point point = paramb.a();
/* 180 */       b b1 = list.get(list.size() - 1);
/*     */       
/* 182 */       Rectangle rectangle2 = paramc.a(paramd, -point.x, -point.y);
/*     */       
/* 184 */       Rectangle rectangle1 = b1.a().a(paramd, 
/* 185 */           -b1.b(), -b1.c());
/*     */       
/* 187 */       if (rectangle2.y < rectangle1.y) {
/* 188 */         rectangle2.translate(0, rectangle1.y - rectangle2.y);
/*     */         
/* 190 */         rectangle2.translate(point.x, point.y);
/*     */         
/* 192 */         paramc.o(rectangle2.y);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void a(com.d.i.c paramc, int paramInt) {
/* 198 */     if (paramInt == 1) {
/* 199 */       paramc.n(0); return;
/* 200 */     }  if (paramInt == 2) {
/* 201 */       paramc.n(paramc.Y().d_() - paramc.Q());
/*     */     }
/*     */   }
/*     */   
/*     */   private static boolean c(com.d.i.c paramc) {
/* 206 */     if (paramc.am() >= 0 && paramc
/* 207 */       .am() + paramc.Q() <= paramc.Y().d_()) return true; 
/*     */     return false;
/*     */   }
/*     */   private static int a(d paramd, List<b> paramList) {
/* 211 */     int i = 0;
/*     */     
/* 213 */     for (Iterator<b> iterator = paramList.iterator(); iterator.hasNext();) {
/*     */ 
/*     */       
/* 216 */       if ((rectangle = (b = iterator.next()).a().a(paramd, -b.b(), -b.c())).y + rectangle.height > i) {
/* 217 */         i = rectangle.y + rectangle.height;
/*     */       }
/*     */     } 
/*     */     
/* 221 */     return i;
/*     */   }
/*     */   
/*     */   public final int a(d paramd, int paramInt) {
/* 225 */     int j = a(paramd, b(1));
/* 226 */     int i = a(paramd, b(2));
/*     */ 
/*     */ 
/*     */     
/* 230 */     return (i = Math.max(j, i)) - paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean a(d paramd, b paramb, com.d.i.c paramc, List<b> paramList) {
/* 235 */     Point point = paramb.a();
/* 236 */     Rectangle rectangle = paramc.a(paramd, -point.x, -point.y);
/*     */     
/* 238 */     for (Iterator<b> iterator = paramList.iterator(); iterator.hasNext();) {
/*     */ 
/*     */ 
/*     */       
/* 242 */       if ((rectangle1 = (b1 = iterator.next()).a().a(paramd, -b1.b(), -b1.c())).intersects(rectangle)) {
/* 243 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 247 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(d paramd, b paramb, f paramf, List<b> paramList) {
/* 252 */     if (paramList.size() == 0) {
/*     */       return;
/*     */     }
/*     */     
/* 256 */     Point point = paramb.a();
/* 257 */     int j = paramf.an() - point.y;
/*     */     
/*     */     int i;
/* 260 */     if ((i = a(paramd, paramList)) - j > 0) {
/* 261 */       paramf.o(paramf.an() + i - j);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void b(d paramd, b paramb, f paramf, List<b> paramList) {
/* 267 */     if (paramList.size() == 0) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 272 */     Point point = paramb.a();
/* 273 */     Rectangle rectangle = paramf.a(paramf
/* 274 */         .am() - point.x, paramf.an() - point.y, paramd);
/*     */     
/* 276 */     int i = a(paramd, paramList);
/*     */     
/* 278 */     if (rectangle.y < i) {
/*     */ 
/*     */       
/* 281 */       rectangle.y = i;
/*     */       
/* 283 */       rectangle.translate(point.x, point.y);
/*     */       
/* 285 */       paramf.o(rectangle.y - (int)paramf.n(paramd).t());
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void a(com.d.i.c paramc) {
/* 290 */     a(paramc, b(1));
/* 291 */     a(paramc, b(2));
/*     */   }
/*     */   
/*     */   private static void a(com.d.i.c paramc, List<b> paramList) {
/* 295 */     for (Iterator<b> iterator = paramList.iterator(); iterator.hasNext();) {
/*     */       
/* 297 */       if ((b = iterator.next()).a().equals(paramc)) {
/* 298 */         iterator.remove();
/* 299 */         paramc.L().a(null);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void a() {
/* 305 */     a(b(1));
/* 306 */     a(b(2));
/*     */   }
/*     */   
/*     */   private static void a(List<b> paramList) {
/* 310 */     for (Iterator<b> iterator = paramList.iterator(); iterator.hasNext(); ) {
/* 311 */       b b; (b = iterator.next()).a().B();
/* 312 */       b.a().C();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(d paramd, f paramf, Rectangle paramRectangle) {
/* 320 */     if (paramf.as() == 0) {
/* 321 */       paramRectangle.height = (int)paramf.a().c(paramd);
/*     */     }
/*     */   }
/*     */   
/*     */   public final int a(d paramd, b paramb, u paramu, int paramInt) {
/*     */     boolean bool;
/* 327 */     a a2 = a(paramd, paramb, paramu, paramInt, b(1), 1);
/* 328 */     a a1 = a(paramd, paramb, paramu, paramInt, b(2), 2);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 333 */     if (a2.a() != null) {
/* 334 */       paramInt = a(paramd, paramu, a2);
/*     */     } else {
/* 336 */       paramInt = 0;
/*     */     } 
/*     */     
/* 339 */     if (a1.a() != null) {
/* 340 */       bool = a(paramd, paramu, a1);
/*     */     } else {
/* 342 */       bool = false;
/*     */     } 
/*     */     
/* 345 */     return Math.max(paramInt, bool);
/*     */   }
/*     */   
/*     */   private static int a(d paramd, u paramu, a parama) {
/*     */     Rectangle rectangle;
/*     */     int i;
/*     */     com.d.i.c c;
/* 352 */     return (i = (rectangle = (c = parama.a()).a(c.ab(), c.aa(), paramd)).y + rectangle.height) - paramu.aa();
/*     */   }
/*     */ 
/*     */   
/*     */   public final int b(d paramd, b paramb, u paramu, int paramInt) {
/* 357 */     return a(paramd, paramb, paramu, paramInt, b(1), 1).b();
/*     */   }
/*     */ 
/*     */   
/*     */   public final int c(d paramd, b paramb, u paramu, int paramInt) {
/* 362 */     return a(paramd, paramb, paramu, paramInt, b(2), 2).b();
/*     */   }
/*     */ 
/*     */   
/*     */   private a a(d paramd, b paramb, u paramu, int paramInt1, List<b> paramList, int paramInt2) {
/*     */     com.d.i.c c;
/* 368 */     if (paramList.size() == 0) {
/* 369 */       return new a(null, 0);
/*     */     }
/*     */     
/* 372 */     Point point = paramb.a();
/*     */     Rectangle rectangle;
/* 374 */     (rectangle = paramu.a(paramd, -point.x, -point.y)).width = paramInt1;
/*     */     
/* 376 */     paramInt1 = (paramInt2 == 1) ? rectangle.x : (rectangle.x + rectangle.width);
/*     */     
/* 378 */     a(paramd, (f)paramu, rectangle);
/* 379 */     paramu = null;
/* 380 */     for (byte b1 = 0; b1 < paramList.size(); b1++) {
/*     */       b b2;
/* 382 */       Rectangle rectangle1 = (b2 = paramList.get(b1)).a().a(paramd, -b2.b(), -b2.c());
/* 383 */       if (rectangle.intersects(rectangle1)) {
/* 384 */         if (paramInt2 == 1 && rectangle1.x + rectangle1.width > paramInt1) {
/* 385 */           paramInt1 = rectangle1.x + rectangle1.width;
/* 386 */         } else if (paramInt2 == 2 && rectangle1.x < paramInt1) {
/* 387 */           paramInt1 = rectangle1.x;
/*     */         } 
/* 389 */         c = b2.a();
/*     */       } 
/*     */     } 
/*     */     
/* 393 */     if (paramInt2 == 1) {
/* 394 */       return new a(c, paramInt1 - rectangle.x);
/*     */     }
/* 396 */     return new a(c, rectangle.x + rectangle.width - paramInt1);
/*     */   }
/*     */ 
/*     */   
/*     */   public final f b() {
/* 401 */     return this.c;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Point b(com.d.i.c paramc) {
/* 406 */     return b(paramc, 
/* 407 */         paramc.a().D() ? b(1) : b(2));
/*     */   }
/*     */   
/*     */   private static Point b(com.d.i.c paramc, List<b> paramList) {
/* 411 */     for (Iterator<b> iterator = paramList.iterator(); iterator.hasNext();) {
/*     */ 
/*     */       
/* 414 */       if ((c1 = (b = iterator.next()).a()).equals(paramc)) {
/* 415 */         return new Point(b.b(), b.c());
/*     */       }
/*     */     } 
/*     */     
/* 419 */     return null;
/*     */   }
/*     */   
/*     */   private void a(c paramc, List<b> paramList) {
/* 423 */     for (Iterator<b> iterator = paramList.iterator(); iterator.hasNext(); ) {
/*     */       b b;
/*     */       com.d.i.c c1;
/* 426 */       (c1 = (b = iterator.next()).a()).m(c1.am() + b().ab() - b.b());
/* 427 */       c1.l(c1.an() + b().aa() - b.c());
/*     */       
/* 429 */       paramc.a((f)c1);
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void a(c paramc) {
/* 434 */     a(paramc, b(1));
/* 435 */     a(paramc, b(2));
/*     */   }
/*     */   
/*     */   static class b {
/*     */     private com.d.i.c a;
/*     */     private int b;
/*     */     private int c;
/*     */     
/*     */     public b(com.d.i.c param1c, int param1Int1, int param1Int2) {
/* 444 */       this.a = param1c;
/* 445 */       this.b = param1Int1;
/* 446 */       this.c = param1Int2;
/*     */     }
/*     */     
/*     */     public final com.d.i.c a() {
/* 450 */       return this.a;
/*     */     }
/*     */     
/*     */     public final int b() {
/* 454 */       return this.b;
/*     */     }
/*     */     
/*     */     public final int c() {
/* 458 */       return this.c;
/*     */     }
/*     */   }
/*     */   
/*     */   static class a {
/*     */     private com.d.i.c a;
/*     */     private int b;
/*     */     
/*     */     public a(com.d.i.c param1c, int param1Int) {
/* 467 */       this.a = param1c;
/* 468 */       this.b = param1Int;
/*     */     }
/*     */     
/*     */     final com.d.i.c a() {
/* 472 */       return this.a;
/*     */     }
/*     */     
/*     */     final int b() {
/* 476 */       return this.b;
/*     */     }
/*     */   }
/*     */   
/*     */   public static interface c {
/*     */     void a(f param1f);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\e\n.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */