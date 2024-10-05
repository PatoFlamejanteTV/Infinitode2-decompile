/*     */ package com.d.i.a;
/*     */ 
/*     */ import com.d.c.f.d;
/*     */ import com.d.e.k;
/*     */ import com.d.e.t;
/*     */ import com.d.f.f;
/*     */ import com.d.i.aa;
/*     */ import com.d.i.ab;
/*     */ import com.d.i.c;
/*     */ import com.d.i.f;
/*     */ import java.awt.Rectangle;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.EnumSet;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ public final class b
/*     */ {
/*     */   private final List<aa> a;
/*     */   
/*     */   public enum a
/*     */   {
/*     */   
/*     */   }
/*     */   
/*     */   public b(List<aa> paramList) {
/*  33 */     this.a = paramList;
/*     */   }
/*     */   
/*     */   private void a(ab paramab, List<t> paramList, c paramc, Set<a> paramSet) {
/*  37 */     for (t t : paramList) {
/*  38 */       a(paramab, t, paramc, paramSet);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(com.d.d.b paramb, int paramInt1, int paramInt2, c paramc) {
/*  47 */     for (paramInt1 = paramInt1; paramInt1 <= paramInt2; paramInt1++) {
/*  48 */       paramc.a(paramInt1).a(paramb);
/*     */     }
/*     */   }
/*     */   
/*     */   private static void a(com.d.d.b paramb, List<e.g> paramList, c paramc) {
/*  53 */     for (Iterator<e.g> iterator = paramList.iterator(); iterator.hasNext(); ) {
/*  54 */       e.g g; if ((g = iterator.next()).b == -1) {
/*  55 */         paramc.a(g.a).a(paramb); continue;
/*     */       } 
/*  57 */       paramc.a(g.a).a(g.b).a(paramb);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void a(f paramf, List<e.g> paramList, c paramc) {
/*  63 */     for (Iterator<e.g> iterator = paramList.iterator(); iterator.hasNext(); ) {
/*  64 */       e.g g; if ((g = iterator.next()).b == -1) {
/*  65 */         paramc.a(g.a).a(new n(paramf, -1)); continue;
/*     */       } 
/*  67 */       paramc.a(g.a).a(g.b).a(new n(paramf, g.b));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final c a(ab paramab, t paramt) {
/*  77 */     if (!paramt.h()) {
/*  78 */       return null;
/*     */     }
/*     */ 
/*     */     
/*  82 */     paramt.a((d)paramab);
/*     */     
/*  84 */     a a = new a(0, this.a.size() - 1);
/*     */ 
/*     */ 
/*     */     
/*  88 */     a(paramab, paramt, a, EnumSet.noneOf(a.class));
/*     */     
/*  90 */     return a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(ab paramab, t paramt, c paramc, Set<a> paramSet) {
/*  97 */     if (paramt.f().a().B()) {
/*     */ 
/*     */ 
/*     */       
/* 101 */       g g = new g(paramt);
/* 102 */       for (int k = paramc.a(); k <= paramc.b(); k++) {
/*     */         c.a a;
/* 104 */         (a = paramc.a(k)).a(g);
/*     */         
/* 106 */         for (byte b1 = 0; b1 < a.a().size(); b1++)
/* 107 */           a.a(b1).a(g); 
/*     */       } 
/*     */       return;
/*     */     } 
/* 111 */     if (paramt.c()) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 117 */     List<e.g> list = e.a((d)paramab, paramt, this.a);
/* 118 */     int i = b(paramab, paramt);
/* 119 */     int j = c(paramab, paramt);
/* 120 */     boolean bool = false;
/*     */     
/*     */     Rectangle rectangle;
/*     */     
/* 124 */     if ((rectangle = paramt.f().a(paramab, paramt.d())) != null) {
/*     */       m m;
/*     */       
/* 127 */       a(m = new m(rectangle), list, paramc);
/* 128 */       bool = true;
/*     */     } 
/*     */     
/* 131 */     if (paramt.b()) {
/* 132 */       a(paramt.f(), list, paramc);
/*     */     }
/*     */     
/* 135 */     if (paramt.h() && paramt.f().ae()) {
/*     */       q q;
/*     */ 
/*     */ 
/*     */       
/* 140 */       a(q = new q(paramt.f()), paramc.a(), paramc.b(), paramc);
/*     */     } 
/*     */     
/* 143 */     if (!paramt.j() && ((c)paramt.f()).A()) {
/* 144 */       b(paramt, paramc, i, j);
/*     */     } else {
/*     */       e e;
/*     */ 
/*     */       
/* 149 */       (e = a(i, j)).b((d)paramab, paramt);
/* 150 */       e.a((d)paramab, paramt);
/*     */       
/* 152 */       if (!paramt.j() && paramt.f() instanceof c) {
/* 153 */         a(paramt, paramc, i, j);
/*     */       }
/*     */       
/* 156 */       if (paramt.h() || paramt.e()) {
/* 157 */         a(paramab, paramt.b(3), paramc, paramSet);
/*     */       }
/*     */       
/* 160 */       for (i = i; i <= j; i++) {
/* 161 */         e.h h = e.a(i);
/* 162 */         c.a a = paramc.a(i);
/*     */         
/* 164 */         a(paramab, paramt, h, a, true, i, -1);
/* 165 */         a(paramab, paramt, i, h, a, true);
/*     */       } 
/*     */       
/* 168 */       if (paramt.h() || paramt.e()) {
/* 169 */         a(paramab, paramt.a(4), paramc, paramSet);
/*     */         
/* 171 */         a(paramab, paramt.b(2), paramc, paramSet);
/* 172 */         a(paramab, paramt.b(1), paramc, paramSet);
/*     */       } 
/*     */     } 
/*     */     
/* 176 */     if (paramt.b()) {
/*     */       l l;
/* 178 */       a(l = new l(paramt.f()), list, paramc);
/*     */     } 
/*     */     
/* 181 */     if (bool) {
/*     */       k k;
/* 183 */       a(k = new k(), list, paramc);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(ab paramab, t paramt, e.h paramh, c.a parama, boolean paramBoolean, int paramInt1, int paramInt2) {
/* 192 */     if (!paramh.b().isEmpty()) {
/*     */       
/* 194 */       Map<f, List<k>> map = paramh.d().isEmpty() ? null : a(paramh.d());
/* 195 */       f f = new f(paramh.b(), map);
/* 196 */       parama.a(f);
/*     */     } 
/*     */     
/* 199 */     if (paramBoolean) {
/* 200 */       for (c c : paramh.a()) {
/* 201 */         a(paramab, paramt, c, parama, paramInt1, paramInt2);
/*     */       }
/*     */     }
/*     */     
/* 205 */     if (!paramh.f().isEmpty()) {
/* 206 */       j j = new j(paramh.f());
/* 207 */       parama.a(j);
/*     */     } 
/*     */     
/* 210 */     if (!paramh.c().isEmpty()) {
/* 211 */       h h1 = new h(paramh.c());
/* 212 */       parama.a(h1);
/*     */     } 
/*     */     
/* 215 */     if (!paramh.e().isEmpty()) {
/* 216 */       p p = new p(paramh.e());
/* 217 */       parama.a(p);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(ab paramab, t paramt, int paramInt, e.h paramh, c.a parama, boolean paramBoolean) {
/* 225 */     paramBoolean = false;
/* 226 */     for (e.h h1 : paramh.g()) {
/* 227 */       c.a a1 = parama.a(paramBoolean);
/* 228 */       a(paramab, paramt, h1, a1, true, paramInt, paramBoolean);
/* 229 */       paramBoolean++;
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
/*     */   
/*     */   private void a(ab paramab, t paramt, c paramc, c.a parama, int paramInt1, int paramInt2) {
/*     */     e e;
/* 243 */     (e = a(paramInt1, paramInt1)).a((d)paramab, paramt, (f)paramc, paramInt1, paramInt1, paramInt2);
/* 244 */     e.h h = e.a(paramInt1);
/*     */     
/* 246 */     if (paramInt2 >= 0 && h.a(paramInt2)) {
/* 247 */       h = h.g().get(paramInt2);
/* 248 */     } else if (paramInt2 >= 0) {
/*     */       return;
/*     */     } 
/*     */ 
/*     */     
/* 253 */     boolean bool = false;
/*     */     
/*     */     Rectangle rectangle;
/*     */     
/* 257 */     if ((rectangle = paramc.a(paramab, paramc.af())) != null) {
/*     */       
/* 259 */       m m = new m(rectangle);
/* 260 */       parama.a(m);
/* 261 */       bool = true;
/*     */     } 
/*     */     
/* 264 */     a(paramab, paramt, h, parama, false, paramInt1, paramInt2);
/*     */     
/* 266 */     if (bool) {
/* 267 */       k k = new k();
/* 268 */       parama.a(k);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(t paramt, c paramc, int paramInt1, int paramInt2) {
/*     */     i i;
/* 276 */     a(i = new i(paramt.f()), paramInt1, paramInt2, paramc);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(t paramt, c paramc, int paramInt1, int paramInt2) {
/*     */     i i;
/* 283 */     a(i = new i(paramt.f()), paramInt1, paramInt2, paramc);
/*     */     
/*     */     o o;
/* 286 */     a(o = new o((c)paramt.f()), paramInt1, paramInt2, paramc);
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
/*     */   public static Map<f, List<k>> a(List<f> paramList) {
/* 298 */     HashMap<Object, Object> hashMap2 = new HashMap<>();
/* 299 */     HashMap<Object, Object> hashMap3 = new HashMap<>();
/*     */     
/* 301 */     HashSet hashSet = new HashSet(0);
/*     */     
/* 303 */     for (f f : paramList) {
/*     */       List list;
/*     */       
/* 306 */       if ((list = (List)hashMap2.get(f.f())) == null) {
/* 307 */         list = new ArrayList();
/* 308 */         hashMap2.put(f.f(), list);
/*     */       } 
/*     */       
/* 311 */       hashMap3.put(f.f(), f);
/* 312 */       f.a(hashSet, list);
/*     */     } 
/*     */     
/* 315 */     if (hashMap3.isEmpty()) {
/* 316 */       return null;
/*     */     }
/*     */     
/* 319 */     HashMap<Object, Object> hashMap1 = new HashMap<>(hashMap3.size());
/*     */     
/* 321 */     for (f f : hashMap3.values()) {
/*     */       List<Comparable> list;
/* 323 */       Collections.sort(list = (List<Comparable>)hashMap2.get(f.f()));
/* 324 */       hashMap1.put(f, list);
/*     */     } 
/*     */     
/* 327 */     return (Map)hashMap1;
/*     */   }
/*     */ 
/*     */   
/*     */   public final c.a a(ab paramab, c paramc, int paramInt) {
/* 332 */     c.a a = new c.a(null);
/*     */     e e;
/* 334 */     (e = a(paramab.t(), paramab.t())).a((d)paramab, paramc.af(), (f)paramc, paramab.t(), paramab.t(), paramInt);
/*     */     
/* 336 */     e.h h = e.a(paramab.t());
/*     */     
/* 338 */     if (paramInt >= 0 && h.a(paramInt)) {
/* 339 */       a(paramab, paramc.af(), h.g().get(paramInt), a, false, paramab.t(), paramInt);
/* 340 */     } else if (paramInt < 0) {
/* 341 */       a(paramab, paramc.af(), h, a, false, paramab.t(), paramInt);
/*     */     } 
/*     */     
/* 344 */     return a;
/*     */   }
/*     */   
/*     */   private e a(int paramInt1, int paramInt2) {
/* 348 */     return new e(this.a, paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   private int b(ab paramab, t paramt) {
/* 352 */     int i = e.a((d)paramab, paramt.f(), this.a);
/*     */ 
/*     */     
/* 355 */     for (c c : paramt.g()) {
/* 356 */       i = Math.min(i, e.a((d)paramab, (f)c, this.a));
/*     */     }
/*     */     
/* 359 */     return i;
/*     */   }
/*     */   
/*     */   private int c(ab paramab, t paramt) {
/* 363 */     int i = e.b((d)paramab, paramt.f(), this.a);
/*     */ 
/*     */     
/* 366 */     for (c c : paramt.g()) {
/* 367 */       i = Math.max(i, e.b((d)paramab, (f)c, this.a));
/*     */     }
/*     */     
/* 370 */     return i;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\i\a\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */