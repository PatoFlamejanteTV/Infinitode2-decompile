/*      */ package com.d.e;
/*      */ 
/*      */ import com.a.a.c.k.b.aa;
/*      */ import com.d.a.d;
/*      */ import com.d.c.a.d;
/*      */ import com.d.c.a.e;
/*      */ import com.d.c.b.b;
/*      */ import com.d.c.c.e;
/*      */ import com.d.c.d.d;
/*      */ import com.d.c.d.j;
/*      */ import com.d.c.f.f;
/*      */ import com.d.c.f.g;
/*      */ import com.d.f.d;
/*      */ import com.d.f.f;
/*      */ import com.d.f.h;
/*      */ import com.d.f.i;
/*      */ import com.d.f.j;
/*      */ import com.d.i.b;
/*      */ import com.d.i.e;
/*      */ import com.d.i.f;
/*      */ import com.d.i.n;
/*      */ import com.d.i.o;
/*      */ import com.d.i.p;
/*      */ import com.d.i.q;
/*      */ import com.d.i.v;
/*      */ import java.util.ArrayDeque;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import org.w3c.dom.Document;
/*      */ import org.w3c.dom.Element;
/*      */ import org.w3c.dom.Node;
/*      */ import org.w3c.dom.Text;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class c
/*      */ {
/*      */   private static void b(v paramv, Document paramDocument) {
/*   94 */     paramv.f().a(paramv, paramDocument);
/*   95 */     paramv.f().a(paramv);
/*      */   }
/*      */   public static com.d.i.c a(v paramv, Document paramDocument) {
/*      */     com.d.i.c c2;
/*   99 */     b(paramv, paramDocument);
/*      */     
/*  101 */     Element element = paramDocument.getDocumentElement();
/*      */ 
/*      */     
/*      */     com.d.c.f.c c1;
/*      */     
/*  106 */     if ((c1 = paramv.y().a(element)).q() || c1.r()) {
/*  107 */       d d = new d();
/*      */     } else {
/*  109 */       c2 = new com.d.i.c();
/*      */     } 
/*      */     
/*  112 */     c2.a(c1);
/*  113 */     c2.a(element);
/*      */     
/*  115 */     paramv.a(c1);
/*      */     
/*  117 */     return c2;
/*      */   }
/*      */   
/*      */   public static void a(v paramv, com.d.i.c paramc) {
/*  121 */     if (paramc.z()) {
/*  122 */       paramc.g(4);
/*      */       
/*      */       return;
/*      */     } 
/*  126 */     ArrayList<ac> arrayList = new ArrayList();
/*      */     
/*  128 */     a a = new a();
/*      */     
/*  130 */     a(paramv, paramc, paramc.ai(), arrayList, a, false);
/*      */ 
/*      */     
/*      */     boolean bool;
/*      */     
/*  135 */     if (!(bool = c(paramc.a().e(com.d.c.a.a.G))) && !a.b()) {
/*  136 */       a(paramv, paramc, arrayList, a); return;
/*      */     } 
/*  138 */     b(arrayList);
/*  139 */     if (bool) {
/*  140 */       b(paramv, paramc, arrayList, a); return;
/*      */     } 
/*  142 */     a(paramv, paramc, arrayList, a, com.d.c.a.c.aX);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static d a(v paramv, e parame, d[] paramArrayOfd, int paramInt1, int paramInt2) {
/*  154 */     if (!parame.a(paramArrayOfd)) {
/*  155 */       return null;
/*      */     }
/*      */     
/*  158 */     Element element = paramv.p().f().ai();
/*      */     
/*  160 */     a a = new a();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     com.d.c.f.c c1, c2;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     d d1;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  177 */     (d1 = (d)a(c2 = (c1 = (new f()).a(parame.a())).a(com.d.c.c.a.a(new v[] { new v(com.d.c.a.a.G, (d)new j(com.d.c.a.c.aV), true, 1), new v(com.d.c.a.a.ax, (d)new j((short)2, 100.0F, "100%"), true, 1) })), a, false)).a(true);
/*  178 */     d1.a(c2);
/*  179 */     d1.a(element);
/*  180 */     d1.i(true);
/*  181 */     d1.g(2);
/*      */     
/*      */     j j;
/*      */     
/*  185 */     (j = (j)a(c2 = c1.a(com.d.c.a.c.bd), a, false)).a(c2);
/*  186 */     j.a(element);
/*  187 */     j.i(true);
/*  188 */     j.g(2);
/*      */     
/*  190 */     d1.b((f)j);
/*      */     
/*  192 */     c2 = null;
/*  193 */     if (paramInt2 == 2) {
/*      */       i i1;
/*      */       com.d.c.f.c c3;
/*  196 */       (i1 = (i)a(c3 = c1.a(com.d.c.a.c.bc), a, false)).a(c3);
/*  197 */       i1.a(element);
/*  198 */       i1.i(true);
/*  199 */       i1.g(2);
/*      */       
/*  201 */       i1.a(paramInt1);
/*      */       
/*  203 */       j.b((f)i1);
/*      */     } 
/*      */     
/*  206 */     byte b = 0;
/*  207 */     boolean bool = (paramArrayOfd.length > 1 && paramInt2 == 2) ? true : false;
/*      */     int i;
/*  209 */     for (i = 0; i < paramArrayOfd.length; i++) {
/*      */       com.d.c.c.a a1; f f;
/*  211 */       if ((a1 = parame.a(paramArrayOfd[i], bool)) != null && (
/*      */         
/*  213 */         f = a(paramv, a1, bool)) != null) {
/*  214 */         i i1; if (paramInt2 == 1) {
/*      */           com.d.c.f.c c3;
/*      */           
/*  217 */           (i1 = (i)a(c3 = c1.a(com.d.c.a.c.bc), a, false)).a(c3);
/*  218 */           i1.a(element);
/*  219 */           i1.i(true);
/*  220 */           i1.g(2);
/*      */           
/*  222 */           i1.a(paramInt1);
/*      */           
/*  224 */           j.b((f)i1);
/*      */         } 
/*  226 */         i1.b((f)f);
/*  227 */         b++;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  232 */     if (paramInt2 == 1 && b > 0) {
/*  233 */       i = 0; Iterator<i> iterator;
/*  234 */       for (iterator = j.W(); iterator.hasNext(); ) {
/*      */         i i1;
/*  236 */         (i1 = iterator.next()).a(paramInt1 / b);
/*  237 */         i += i1.f();
/*      */       } 
/*      */       
/*  240 */       for (iterator = j.W(); iterator.hasNext() && i < paramInt1; ) {
/*      */         i i1;
/*  242 */         (i1 = iterator.next()).a(i1.f() + 1);
/*  243 */         i++;
/*      */       } 
/*      */     } 
/*      */     
/*  247 */     return (b > 0) ? d1 : null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static f a(v paramv, com.d.c.c.a parama, boolean paramBoolean) {
/*  254 */     boolean bool = true;
/*      */     
/*  256 */     v v1 = parama.a(com.d.c.a.a.C);
/*      */     
/*      */     com.d.c.f.c c1;
/*      */     
/*  260 */     if ((c1 = (new f()).a(parama)).w() && !paramBoolean) {
/*  261 */       return null;
/*      */     }
/*      */     
/*  264 */     if (c1.a(com.d.c.a.a.C, com.d.c.a.c.ap) || c1
/*  265 */       .a(com.d.c.a.a.C, com.d.c.a.c.aq)) {
/*  266 */       bool = false;
/*      */     }
/*      */     
/*  269 */     if (c1.H() && !paramBoolean && !bool) {
/*  270 */       return null;
/*      */     }
/*      */     
/*  273 */     ArrayList<ac> arrayList = new ArrayList();
/*      */     
/*      */     a a1;
/*  276 */     (a1 = new a()).b(true);
/*  277 */     a1.c(true);
/*      */     
/*      */     f f;
/*  280 */     (f = new f()).i(true);
/*  281 */     f.a(c1);
/*  282 */     f.a(paramv.p().f().ai());
/*      */     
/*  284 */     if (bool && !c1.w()) {
/*  285 */       arrayList.addAll(a(paramv, paramv
/*      */             
/*  287 */             .p().f().ai(), (j)v1
/*  288 */             .e(), c1, a1));
/*      */ 
/*      */ 
/*      */       
/*  292 */       b(arrayList);
/*      */     } 
/*      */     
/*  295 */     a(paramv, (com.d.i.c)f, arrayList, a1, com.d.c.a.c.aX);
/*      */     
/*  297 */     return f;
/*      */   }
/*      */ 
/*      */   
/*      */   private static void a(v paramv, com.d.i.c paramc, List<ac> paramList, a parama) {
/*  302 */     if (paramList.size() > 0) {
/*  303 */       if (parama.a()) {
/*  304 */         a(paramv
/*  305 */             .y(), (f)paramc, paramList, parama.c());
/*  306 */         paramc.g(2); return;
/*      */       } 
/*  308 */       ag.a(paramList);
/*  309 */       if (paramList.size() > 0) {
/*  310 */         paramc.b(paramList);
/*  311 */         paramc.g(1); return;
/*      */       } 
/*  313 */       paramc.g(4);
/*      */       
/*      */       return;
/*      */     } 
/*  317 */     paramc.g(4);
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean a(com.d.c.a.c paramc, List<ac> paramList) {
/*  322 */     return paramList.stream().allMatch(paramac -> b(paramc, paramac.a().e(com.d.c.a.a.G)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void a(v paramv, com.d.i.c paramc, List<ac> paramList, a parama, com.d.c.a.c paramc1) {
/*  336 */     ArrayList<ac> arrayList1 = new ArrayList();
/*  337 */     ArrayList<ac> arrayList2 = new ArrayList();
/*      */     
/*  339 */     com.d.c.a.c c1 = b(paramc1);
/*      */     
/*  341 */     for (ac ac : paramList) {
/*  342 */       if (a(paramc1, ac.a().e(com.d.c.a.a.G))) {
/*  343 */         arrayList1.add(ac); continue;
/*      */       } 
/*  345 */       if (arrayList1.size() > 0) {
/*  346 */         a(paramv, (com.d.i.c)arrayList1.get(0), c1, arrayList1, arrayList2);
/*      */ 
/*      */         
/*  349 */         arrayList1 = new ArrayList<>();
/*      */       } 
/*  351 */       arrayList2.add(ac);
/*      */     } 
/*      */ 
/*      */     
/*  355 */     if (arrayList1.size() > 0) {
/*  356 */       a(paramv, (com.d.i.c)arrayList1.get(0), c1, arrayList1, arrayList2);
/*      */     }
/*      */ 
/*      */     
/*  360 */     if (c1 == com.d.c.a.c.aV) {
/*  361 */       a(arrayList2);
/*  362 */       parama.a(true);
/*  363 */       a(paramv, paramc, arrayList2, parama); return;
/*      */     } 
/*  365 */     a(paramv, paramc, arrayList2, parama, c1);
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean a(com.d.c.a.c paramc1, com.d.c.a.c paramc2) {
/*  370 */     if (paramc1 == com.d.c.a.c.bd) {
/*  371 */       return (paramc2 == com.d.c.a.c.bd || paramc2 == com.d.c.a.c.bb || paramc2 == com.d.c.a.c.ba || paramc2 == com.d.c.a.c.aW);
/*      */     }
/*      */     
/*  374 */     return (paramc1 == paramc2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void a(List<ac> paramList) {
/*  385 */     HashMap<Object, Object> hashMap = new HashMap<>(); Iterator<ac> iterator;
/*  386 */     for (iterator = paramList.iterator(); iterator.hasNext();) {
/*  387 */       if (ac = iterator.next() instanceof q) {
/*      */         q q;
/*  389 */         Element element = (q = (q)ac).h();
/*      */         
/*  391 */         if (!hashMap.containsKey(element)) {
/*  392 */           q.c(true);
/*      */         }
/*      */         
/*  395 */         hashMap.put(element, q);
/*      */       } 
/*      */     } 
/*      */     
/*  399 */     for (iterator = hashMap.values().iterator(); iterator.hasNext();) {
/*  400 */       (q = (q)iterator.next()).b(true);
/*      */     }
/*      */   }
/*      */   
/*      */   private static void b(List<ac> paramList) {
/*  405 */     int i = 0;
/*      */     
/*  407 */     int k = 0; int j;
/*  408 */     for (j = 0; j < paramList.size(); j++) {
/*      */       ac ac;
/*  410 */       if (!(ac = paramList.get(j)).a().y()) {
/*  411 */         if (k) {
/*  412 */           k = paramList.size();
/*  413 */           ag.a(paramList.subList(i, j));
/*  414 */           int m = paramList.size();
/*  415 */           j -= k - m;
/*      */         } 
/*  417 */         k = 0;
/*      */       }
/*  419 */       else if (k == 0) {
/*  420 */         k = 1;
/*  421 */         i = j;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  426 */     if (k != 0) {
/*  427 */       ag.a(paramList.subList(i, j));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void b(v paramv, com.d.i.c paramc, List<ac> paramList, a parama) {
/*      */     com.d.c.a.c c1, c2;
/*  441 */     if ((c2 = a(c1 = paramc.a().e(com.d.c.a.a.G))) == null && paramc.au() && c(paramList)) {
/*  442 */       a(paramv, paramc, paramList, parama, com.d.c.a.c.aX); return;
/*  443 */     }  if (c2 == null || a(c1, paramList)) {
/*  444 */       if (paramc.au()) {
/*  445 */         a(paramList);
/*      */       }
/*  447 */       a(paramv, paramc, paramList, parama); return;
/*      */     } 
/*  449 */     ArrayList<ac> arrayList1 = new ArrayList();
/*  450 */     ArrayList<ac> arrayList2 = new ArrayList();
/*      */     
/*  452 */     for (Iterator<ac> iterator = paramList.iterator(); iterator.hasNext(); ) {
/*  453 */       ac ac; com.d.c.a.c c3 = (ac = iterator.next()).a().e(com.d.c.a.a.G);
/*      */       
/*  455 */       if (b(c1, c3)) {
/*  456 */         if (arrayList1.size() > 0) {
/*  457 */           a(paramv, paramc, c2, arrayList1, arrayList2);
/*      */ 
/*      */           
/*  460 */           arrayList1 = new ArrayList<>();
/*      */         } 
/*  462 */         arrayList2.add(ac); continue;
/*      */       } 
/*  464 */       arrayList1.add(ac);
/*      */     } 
/*      */ 
/*      */     
/*  468 */     if (arrayList1.size() > 0) {
/*  469 */       a(paramv, paramc, c2, arrayList1, arrayList2);
/*      */     }
/*      */ 
/*      */     
/*  473 */     parama.a(true);
/*  474 */     a(paramv, paramc, arrayList2, parama);
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean a(ac paramac) {
/*      */     com.d.c.a.c c1;
/*  480 */     if ((c1 = paramac.a().e(com.d.c.a.a.G)) == com.d.c.a.c.bb || c1 == com.d.c.a.c.bd || c1 == com.d.c.a.c.ba || c1 == com.d.c.a.c.bc) return true;  return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean c(List<ac> paramList) {
/*  487 */     return paramList.stream().anyMatch(c::a);
/*      */   }
/*      */   
/*      */   private static boolean a(com.d.i.c paramc) {
/*      */     com.d.c.f.c c1;
/*  492 */     if ((c1 = paramc.a().a()) != null && c1.o()) return true;  return false;
/*      */   }
/*      */   
/*      */   private static void a(v paramv, com.d.i.c paramc, com.d.c.a.c paramc1, List<ac> paramList1, List<ac> paramList2) {
/*      */     com.d.c.a.c c2;
/*  497 */     a a = d(paramList1);
/*      */     
/*  499 */     if (a(paramc) && paramc1 == com.d.c.a.c.aV) {
/*  500 */       c2 = com.d.c.a.c.T;
/*      */     } else {
/*  502 */       c2 = paramc1;
/*      */     } 
/*      */     com.d.c.f.c c1;
/*      */     com.d.i.c c3;
/*  506 */     (c3 = a(c1 = paramc.a().a(c2), a, false)).a(c1);
/*  507 */     c3.i(true);
/*      */     
/*  509 */     c3.a(paramc.ai());
/*  510 */     b(paramv, c3, paramList1, a);
/*      */     
/*  512 */     if (paramc1 == com.d.c.a.c.aV) {
/*  513 */       paramList2.add(a(paramv, (d)c3)); return;
/*      */     } 
/*  515 */     paramList2.add(c3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static com.d.i.c a(v paramv, d paramd) {
/*      */     com.d.c.f.c c1;
/*  526 */     ArrayList<f> arrayList1 = new ArrayList();
/*  527 */     f f1 = null;
/*  528 */     ArrayList<f> arrayList2 = new ArrayList();
/*  529 */     f f2 = null;
/*  530 */     ArrayList<f> arrayList3 = new ArrayList();
/*      */     
/*  532 */     for (Iterator<f> iterator = paramd.X().iterator(); iterator.hasNext(); ) {
/*      */       f f;
/*      */       com.d.c.a.c c3;
/*  535 */       if ((c3 = (f = iterator.next()).a().e(com.d.c.a.a.G)) == com.d.c.a.c.aW) {
/*      */         
/*  537 */         if ((c3 = f.a().e(com.d.c.a.a.y)) == com.d.c.a.c.l) {
/*  538 */           arrayList3.add(f); continue;
/*      */         } 
/*  540 */         arrayList1.add(f); continue;
/*      */       } 
/*  542 */       if (c3 == com.d.c.a.c.bb && f1 == null) {
/*  543 */         f1 = f; continue;
/*  544 */       }  if (c3 == com.d.c.a.c.ba && f2 == null) {
/*  545 */         f2 = f; continue;
/*      */       } 
/*  547 */       arrayList2.add(f);
/*      */     } 
/*      */ 
/*      */     
/*  551 */     paramd.R();
/*  552 */     if (f1 != null) {
/*  553 */       ((j)f1).c(true);
/*  554 */       paramd.b(f1);
/*      */     } 
/*  556 */     paramd.c(arrayList2);
/*  557 */     if (f2 != null) {
/*  558 */       ((j)f2).b(true);
/*  559 */       paramd.b(f2);
/*      */     } 
/*      */     
/*  562 */     if (arrayList1.size() == 0 && arrayList3.size() == 0) {
/*  563 */       return (com.d.i.c)paramd;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  568 */     if (paramd.a().C()) {
/*  569 */       com.d.c.c.a a = com.d.c.c.a.a(new v[] {
/*      */             
/*  571 */             com.d.c.c.a.a(com.d.c.a.a.G, com.d.c.a.c.h), 
/*      */             
/*  573 */             com.d.c.c.a.a(com.d.c.a.a.I, paramd
/*  574 */               .a().e(com.d.c.a.a.I))
/*      */           });
/*  576 */       c1 = paramd.a().a(a);
/*      */     } else {
/*  578 */       c1 = paramd.a().a(com.d.c.a.c.h);
/*      */     } 
/*      */     
/*      */     com.d.i.c c2;
/*  582 */     (c2 = new com.d.i.c()).a(c1);
/*  583 */     c2.i(true);
/*  584 */     c2.h(true);
/*  585 */     c2.a(paramd.ai());
/*      */     
/*  587 */     c2.g(2);
/*  588 */     c2.c(arrayList1);
/*  589 */     c2.b((f)paramd);
/*  590 */     c2.c(arrayList3);
/*      */     
/*  592 */     if (paramd.a().C()) {
/*  593 */       c2.a(new n());
/*  594 */       paramd.a(null);
/*      */ 
/*      */ 
/*      */       
/*  598 */       com.d.c.c.a a = com.d.c.c.a.a(a = paramv.y().j().a(paramd.ai(), false), new v[] {
/*      */ 
/*      */             
/*  601 */             com.d.c.c.a.a(com.d.c.a.a.I, com.d.c.a.c.ap)
/*      */           });
/*      */       
/*  604 */       paramd.a(paramd.a().a().a(a));
/*      */     } 
/*      */     
/*  607 */     return c2;
/*      */   }
/*      */ 
/*      */   
/*      */   private static a d(List<ac> paramList) {
/*  612 */     a a = new a();
/*      */     
/*  614 */     if (paramList.stream().anyMatch(paramac -> !paramac.a().y())) {
/*  615 */       a.a(true);
/*      */     }
/*      */     
/*  618 */     return a;
/*      */   }
/*      */   
/*      */   private static com.d.c.a.c a(com.d.c.a.c paramc) {
/*  622 */     if (paramc == com.d.c.a.c.aV || paramc == com.d.c.a.c.T)
/*  623 */       return com.d.c.a.c.bd; 
/*  624 */     if (paramc == com.d.c.a.c.bb || paramc == com.d.c.a.c.bd || paramc == com.d.c.a.c.ba)
/*      */     {
/*      */       
/*  627 */       return com.d.c.a.c.bc; } 
/*  628 */     if (paramc == com.d.c.a.c.bc) {
/*  629 */       return com.d.c.a.c.aX;
/*      */     }
/*  631 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   private static com.d.c.a.c b(com.d.c.a.c paramc) {
/*  636 */     if (paramc == com.d.c.a.c.aX)
/*  637 */       return com.d.c.a.c.bc; 
/*  638 */     if (paramc == com.d.c.a.c.bc)
/*  639 */       return com.d.c.a.c.bd; 
/*  640 */     if (paramc == com.d.c.a.c.bb || paramc == com.d.c.a.c.bd || paramc == com.d.c.a.c.ba)
/*      */     {
/*      */       
/*  643 */       return com.d.c.a.c.aV;
/*      */     }
/*  645 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean b(com.d.c.a.c paramc1, com.d.c.a.c paramc2) {
/*  650 */     return ((paramc1 == com.d.c.a.c.aV && (paramc2 == com.d.c.a.c.bb || paramc2 == com.d.c.a.c.bd || paramc2 == com.d.c.a.c.ba || paramc2 == com.d.c.a.c.aW)) || ((paramc1 == com.d.c.a.c.bb || paramc1 == com.d.c.a.c.bd || paramc1 == com.d.c.a.c.ba) && paramc2 == com.d.c.a.c.bc) || (paramc1 == com.d.c.a.c.bc && paramc2 == com.d.c.a.c.aX) || (paramc1 == com.d.c.a.c.T && (paramc2 == com.d.c.a.c.bb || paramc2 == com.d.c.a.c.bd || paramc2 == com.d.c.a.c.ba)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean c(com.d.c.a.c paramc) {
/*  666 */     return (paramc == com.d.c.a.c.aV || paramc == com.d.c.a.c.T || paramc == com.d.c.a.c.bb || paramc == com.d.c.a.c.bd || paramc == com.d.c.a.c.ba || paramc == com.d.c.a.c.bc);
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean b(e parame) {
/*      */     List<?> list;
/*  672 */     if (parame.a().equals("attr") && (
/*      */       
/*  674 */       list = parame.b()).size() == 1) {
/*      */       j j;
/*  676 */       return ((j = (j)list.get(0)).a() == 21);
/*      */     } 
/*      */ 
/*      */     
/*  680 */     return false;
/*      */   }
/*      */   
/*      */   public static boolean a(e parame) {
/*  684 */     if (parame.a().equals("element")) {
/*      */       List<?> list;
/*  686 */       if ((list = parame.b()).size() <= 0 || list.size() > 2) {
/*  687 */         return false;
/*      */       }
/*      */       
/*      */       boolean bool;
/*      */       j j;
/*  692 */       if ((bool = ((j = (j)list.get(0)).a() == 21) ? true : false) && list.size() == 2) {
/*      */         j j1;
/*  694 */         bool = ((j1 = (j)list.get(1)).a() == 21) ? true : false;
/*      */       } 
/*      */       
/*  697 */       return bool;
/*      */     } 
/*      */     
/*  700 */     return false;
/*      */   }
/*      */   private static l a(e parame, v paramv, com.d.c.f.c paramc) {
/*      */     int i;
/*  704 */     if (parame.a().equals("counter")) {
/*      */       List<?> list;
/*  706 */       if ((list = parame.b()).size() <= 0 || list.size() > 2) {
/*  707 */         return null;
/*      */       }
/*      */       
/*      */       j j;
/*  711 */       if ((j = (j)list.get(0)).a() != 21) {
/*  712 */         return null;
/*      */       }
/*      */       
/*      */       String str1;
/*      */       
/*  717 */       if ((str1 = j.c()).equals("page") || str1.equals("pages")) {
/*  718 */         return null;
/*      */       }
/*      */       
/*  721 */       String str2 = j.c();
/*  722 */       com.d.c.a.c c1 = com.d.c.a.c.v;
/*  723 */       if (list.size() == 2) {
/*      */         
/*  725 */         if ((j = (j)list.get(1)).a() != 21) {
/*  726 */           return null;
/*      */         }
/*      */         
/*      */         com.d.c.a.c c2;
/*  730 */         if ((c2 = com.d.c.a.c.b(j.c())) != null) {
/*  731 */           j.a(c2);
/*  732 */           c1 = c2;
/*      */         } 
/*      */       } 
/*      */       
/*  736 */       i = paramv.b(paramc).a(str2);
/*      */       
/*  738 */       return new l(i, c1);
/*  739 */     }  if (i.a().equals("counters")) {
/*      */       List<j> list;
/*  741 */       if ((list = i.b()).size() < 2 || list.size() > 3) {
/*  742 */         return null;
/*      */       }
/*      */       
/*      */       j j;
/*  746 */       if ((j = list.get(0)).a() != 21) {
/*  747 */         return null;
/*      */       }
/*      */       
/*  750 */       String str1 = j.c();
/*      */ 
/*      */       
/*  753 */       if ((j = list.get(1)).a() != 19) {
/*  754 */         return null;
/*      */       }
/*      */       
/*  757 */       String str2 = j.c();
/*      */       
/*  759 */       com.d.c.a.c c1 = com.d.c.a.c.v;
/*  760 */       if (list.size() == 3) {
/*      */         
/*  762 */         if ((j = list.get(2)).a() != 21) {
/*  763 */           return null;
/*      */         }
/*      */         
/*      */         com.d.c.a.c c2;
/*  767 */         if ((c2 = com.d.c.a.c.b(j.c())) != null) {
/*  768 */           j.a(c2);
/*  769 */           c1 = c2;
/*      */         } 
/*      */       } 
/*      */       
/*  773 */       list = (List)paramv.b(paramc).b(str1);
/*      */       
/*  775 */       return new l(list, str2, c1);
/*      */     } 
/*  777 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   private static String a(e parame, Element paramElement) {
/*  782 */     j j = parame.b().get(0);
/*  783 */     return paramElement.getAttribute(j.c());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static List<ac> a(v paramv, Element paramElement, j paramj, String paramString, com.d.c.f.c paramc, int paramInt, a parama) {
/*  789 */     List list = paramj.l();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  796 */     ArrayList<com.d.i.c> arrayList = new ArrayList(list.size());
/*      */     
/*  798 */     for (j j1 : list) {
/*  799 */       b b = null;
/*  800 */       e e = null;
/*      */       
/*  802 */       String str = null;
/*      */       
/*      */       short s;
/*  805 */       if ((s = j1.a()) == 19)
/*  806 */       { str = j1.c(); }
/*  807 */       else { com.d.i.c c1; l l; if (j1.i() == 7) {
/*  808 */           if (paramInt == 1 && b(j1.n())) {
/*  809 */             str = a(j1.n(), paramElement);
/*      */           } else {
/*  811 */             l = null;
/*      */             
/*  813 */             if (paramInt == 1) {
/*  814 */               l = a(j1.n(), paramv, paramc);
/*      */             }
/*      */             
/*  817 */             if (l != null) {
/*      */               
/*  819 */               str = l.a();
/*  820 */               b = null;
/*  821 */               e = null;
/*  822 */             } else if (paramInt == 2 && a(j1.n())) {
/*      */               
/*  824 */               if ((c1 = a(paramv, j1)) != null) {
/*  825 */                 arrayList.add(c1.c());
/*  826 */                 parama.a(true);
/*      */               
/*      */               }
/*      */             
/*      */             }
/*  831 */             else if ((b = paramv.x().a(paramv, c1.n())) != null) {
/*  832 */               e = c1.n();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*  839 */               str = b.a();
/*      */             } 
/*      */           } 
/*      */         } else {
/*      */           g g;
/*  844 */           if (l == 21 && (
/*      */ 
/*      */             
/*  847 */             g = paramc.i(com.d.c.a.a.ai)) != com.d.c.a.c.ap) {
/*      */             String[] arrayOfString;
/*      */             com.d.c.a.c c2;
/*  850 */             if ((c2 = c1.h()) == com.d.c.a.c.au) {
/*      */               
/*  852 */               str = (arrayOfString = paramc.c(com.d.c.a.a.ai))[0];
/*  853 */             } else if (arrayOfString == com.d.c.a.c.p) {
/*      */               
/*  855 */               str = (arrayOfString = paramc.c(com.d.c.a.a.ai))[1];
/*      */             } 
/*      */           } 
/*      */         }  }
/*      */       
/*  860 */       if (str != null) {
/*      */         q q;
/*  862 */         (q = new q(str, null)).a(b);
/*  863 */         q.a(e);
/*  864 */         q.a(paramElement);
/*  865 */         q.b(paramString);
/*  866 */         q.c(true);
/*  867 */         q.b(true);
/*      */         
/*  869 */         arrayList.add(q);
/*      */       } 
/*      */     } 
/*      */     
/*  873 */     return (List)arrayList;
/*      */   }
/*      */   
/*      */   public static com.d.i.c a(v paramv, j paramj) {
/*      */     List<j> list;
/*  878 */     String str = ((j)(list = paramj.n().b()).get(0)).c();
/*  879 */     e e = null;
/*  880 */     if (list.size() == 2) {
/*  881 */       e = e.a(((j)list
/*  882 */           .get(1)).c());
/*      */     }
/*  884 */     if (e == null) {
/*  885 */       e = e.b;
/*      */     }
/*      */     com.d.i.c c1;
/*  888 */     return c1 = paramv.F().a(str, paramv.G(), e);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static void a(v paramv, Element paramElement, com.d.c.f.c paramc, String paramString, List<ac> paramList, a parama) {
/*      */     com.d.c.c.a a1;
/*  895 */     if ((a1 = paramv.c().a(paramElement, paramString)) != null) {
/*  896 */       v v1 = a1.a(com.d.c.a.a.C);
/*  897 */       v v2 = a1.a(com.d.c.a.a.E);
/*  898 */       v v3 = a1.a(com.d.c.a.a.D);
/*      */       
/*  900 */       com.d.c.f.c c1 = null;
/*  901 */       if (v1 != null || v2 != null || v3 != null) {
/*      */         
/*  903 */         if ((c1 = paramc.a(a1)).w())
/*  904 */           return;  if (c1.a(com.d.c.a.a.C, com.d.c.a.c.ap))
/*  905 */           return;  if (c1.a(com.d.c.a.a.C, com.d.c.a.c.aq) && (paramString.equals("before") || paramString.equals("after"))) {
/*      */           return;
/*      */         }
/*  908 */         if (c1.q() || c1.v() || c1.t()) {
/*      */           
/*  910 */           a1 = com.d.c.c.a.a(a1, new v[] {
/*  911 */                 com.d.c.c.a.a(com.d.c.a.a.G, com.d.c.a.c.h)
/*      */               });
/*      */ 
/*      */           
/*  915 */           c1 = paramc.a(a1);
/*      */         } 
/*  917 */         paramv.a(c1);
/*      */       } 
/*      */       
/*  920 */       if (v1 != null) {
/*  921 */         d d = v1.e();
/*  922 */         paramList.addAll(a(paramv, paramElement, paramString, c1, (j)d, parama));
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static List<ac> a(v paramv, Element paramElement, String paramString, com.d.c.f.c paramc, j paramj, a parama) {
/*  931 */     if (paramc.w() || paramc.a(com.d.c.a.a.G, com.d.c.a.c.aY) || paramc
/*  932 */       .a(com.d.c.a.a.G, com.d.c.a.c.aZ)) {
/*  933 */       return Collections.emptyList();
/*      */     }
/*      */     
/*  936 */     List<ac> list = a(paramv, paramElement, paramj, paramString, paramc, 1, null);
/*      */ 
/*      */     
/*  939 */     if (paramc.o()) {
/*  940 */       for (Iterator<ac> iterator1 = list.iterator(); iterator1.hasNext(); ) {
/*      */         q q;
/*  942 */         (q = (q)iterator1.next()).a(paramc);
/*  943 */         q.d();
/*      */       } 
/*  945 */       return list;
/*      */     } 
/*  947 */     com.d.c.f.c c1 = paramc.a(com.d.c.a.c.R);
/*  948 */     for (Iterator<ac> iterator = list.iterator(); iterator.hasNext(); ) {
/*      */       q q;
/*  950 */       (q = (q)iterator.next()).a(c1);
/*  951 */       q.d();
/*  952 */       q.a(null);
/*      */     } 
/*      */     
/*      */     com.d.i.c c2;
/*  956 */     (c2 = a(paramc, parama, true)).a(paramc);
/*  957 */     c2.b(list);
/*  958 */     c2.a(paramElement);
/*  959 */     c2.g(1);
/*  960 */     c2.a(paramString);
/*      */     
/*  962 */     if (!paramc.y()) {
/*  963 */       parama.a(true);
/*      */     }
/*      */     
/*  966 */     return new ArrayList<>((Collection)Collections.singletonList(c2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static List<ac> a(v paramv, Element paramElement, j paramj, com.d.c.f.c paramc, a parama) {
/*  974 */     List<ac> list = a(paramv, paramElement, paramj, null, paramc, 2, parama);
/*      */ 
/*      */     
/*  977 */     com.d.c.f.c c1 = paramc.a(com.d.c.a.c.R);
/*  978 */     for (Iterator<ac> iterator = list.iterator(); iterator.hasNext();) {
/*  979 */       if (ac = iterator.next() instanceof q) {
/*      */         q q;
/*  981 */         (q = (q)ac).a(null);
/*  982 */         q.a(c1);
/*  983 */         q.d();
/*      */       } 
/*      */     } 
/*      */     
/*  987 */     return list;
/*      */   }
/*      */   
/*      */   private static com.d.i.c a(com.d.c.f.c paramc, a parama, boolean paramBoolean) {
/*      */     com.d.i.c c1;
/*  992 */     if (paramc.C() && !paramc.A() && !paramc.B()) {
/*      */       
/*  994 */       if (paramc.q() || paramc.r()) {
/*  995 */         d d = new d();
/*      */       } else {
/*  997 */         c1 = new com.d.i.c();
/*      */       } 
/*  999 */       c1.a(new n());
/* 1000 */       return c1;
/* 1001 */     }  if (c1.x())
/* 1002 */       return new com.d.i.c(); 
/* 1003 */     if (!paramBoolean && (c1.q() || c1.r()))
/* 1004 */       return (com.d.i.c)new d(); 
/* 1005 */     if (c1.s()) {
/* 1006 */       parama.b(true);
/* 1007 */       return (com.d.i.c)new f();
/* 1008 */     }  if (!paramBoolean && c1.v()) {
/* 1009 */       parama.b(true);
/* 1010 */       return (com.d.i.c)new i();
/* 1011 */     }  if (!paramBoolean && c1.t()) {
/* 1012 */       parama.b(true);
/* 1013 */       return (com.d.i.c)new j();
/* 1014 */     }  if (c1.u()) {
/* 1015 */       parama.b(true);
/* 1016 */       return new com.d.i.c();
/*      */     } 
/* 1018 */     return new com.d.i.c();
/*      */   }
/*      */ 
/*      */   
/*      */   private static void a(v paramv, d paramd, h paramh) {
/* 1023 */     aa aa = paramv.y();
/*      */     
/* 1025 */     Node node = paramh.b().getFirstChild();
/* 1026 */     boolean bool = false;
/* 1027 */     while (node != null) {
/*      */       
/* 1029 */       Element element = (Element)node;
/*      */       
/*      */       com.d.c.f.c c1;
/* 1032 */       if (node.getNodeType() == 1 && (c1 = aa.a(element)).a(com.d.c.a.a.G, com.d.c.a.c.aY)) {
/* 1033 */         bool = true;
/*      */         h h1;
/* 1035 */         (h1 = new h(element, c1)).a(paramh);
/* 1036 */         paramd.a(h1);
/*      */       } 
/*      */       
/* 1039 */       node = node.getNextSibling();
/*      */     } 
/* 1041 */     if (!bool) {
/* 1042 */       paramd.a(paramh);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static void a(v paramv, d paramd, Element paramElement, com.d.c.f.c paramc) {
/* 1048 */     if (paramc.a(com.d.c.a.a.G, com.d.c.a.c.aY)) {
/* 1049 */       paramd.a(new h(paramElement, paramc)); return;
/*      */     } 
/* 1051 */     a(paramv, paramd, new h(paramElement, paramc));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static q a(String paramString, Element paramElement, com.d.c.f.c paramc, Text paramText) {
/* 1057 */     q q = new q(paramString, paramText);
/*      */     
/* 1059 */     if (paramc.o() && !(paramElement.getParentNode() instanceof Document)) {
/* 1060 */       q.a(paramc);
/* 1061 */       q.a(paramElement);
/*      */     } else {
/* 1063 */       q.a(paramc.a(com.d.c.a.c.R));
/*      */     } 
/*      */     
/* 1066 */     q.d();
/*      */     
/* 1068 */     return q;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void a(v paramv, com.d.i.c paramc, Element paramElement, List<ac> paramList, a parama, boolean paramBoolean) {
/*      */     aa aa;
/* 1076 */     com.d.c.f.c c1 = (aa = paramv.y()).a(paramElement);
/*      */     
/* 1078 */     a(paramv, paramElement, c1, "before", paramList, parama);
/*      */     
/* 1080 */     Node node = paramElement.getFirstChild();
/* 1081 */     boolean bool1 = paramBoolean;
/* 1082 */     boolean bool2 = paramBoolean;
/* 1083 */     if (node != null) {
/* 1084 */       q q = null; do {
/*      */         Element element;
/* 1086 */         p p = null;
/*      */         short s;
/* 1088 */         if ((s = node.getNodeType()) == 1)
/* 1089 */         { element = (Element)node;
/*      */           
/*      */           com.d.c.f.c c2;
/* 1092 */           if (!(c2 = aa.a(element)).w())
/*      */           
/*      */           { 
/*      */             
/* 1096 */             Integer integer = null;
/* 1097 */             if ("ol".equals(node.getNodeName())) {
/*      */               Node node1;
/* 1099 */               if ((node1 = node.getAttributes().getNamedItem("start")) != null) {
/*      */                 try {
/* 1101 */                   integer = new Integer(Integer.parseInt(node1.getNodeValue()) - 1);
/* 1102 */                 } catch (NumberFormatException numberFormatException) {}
/*      */               }
/*      */             } else {
/*      */               Node node1;
/* 1106 */               if ("li".equals(node.getNodeName()) && (
/*      */                 
/* 1108 */                 node1 = node.getAttributes().getNamedItem("value")) != null) {
/*      */                 try {
/* 1110 */                   integer = new Integer(Integer.parseInt(node1.getNodeValue()) - 1);
/* 1111 */                 } catch (NumberFormatException numberFormatException) {}
/*      */               }
/*      */             } 
/*      */ 
/*      */ 
/*      */             
/* 1117 */             paramv.a(c2, integer);
/*      */             
/* 1119 */             if (c2.a(com.d.c.a.a.G, com.d.c.a.c.aY) || c2
/* 1120 */               .a(com.d.c.a.a.G, com.d.c.a.c.aZ))
/* 1121 */             { if (paramc != null && (paramc
/* 1122 */                 .a().q() || paramc.a().r())) {
/* 1123 */                 d d = (d)paramc;
/* 1124 */                 a(paramv, d, element, c2);
/*      */               }  }
/*      */             else
/*      */             { com.d.i.c c3;
/*      */ 
/*      */               
/* 1130 */               if (c2.o()) {
/* 1131 */                 if (bool1) {
/* 1132 */                   bool1 = false;
/*      */                   q q1;
/* 1134 */                   (q1 = a("", paramElement, c1, (Text)null)).c(true);
/* 1135 */                   q1.b(false);
/* 1136 */                   paramList.add(q1);
/* 1137 */                   q = q1;
/*      */                 } 
/* 1139 */                 a(paramv, (com.d.i.c)null, element, paramList, parama, true);
/* 1140 */                 if (paramBoolean) {
/* 1141 */                   if (q != null) {
/* 1142 */                     q.b(false);
/*      */                   }
/* 1144 */                   bool2 = true;
/*      */                 } 
/*      */               } else {
/* 1147 */                 if (c2.Y() && paramv.r()) {
/* 1148 */                   p = new p();
/*      */                 } else {
/* 1150 */                   c3 = a(c2, parama, false);
/*      */                 } 
/*      */                 
/* 1153 */                 c3.a(c2);
/* 1154 */                 c3.a(element);
/*      */                 
/* 1156 */                 if (c2.Y() && paramv.r()) {
/*      */                   p p1;
/* 1158 */                   (p1 = (p)c3).a(new o((f)p1));
/* 1159 */                   p1.f().a(c2.a(com.d.c.a.c.h));
/* 1160 */                   p1.f().a(element);
/* 1161 */                   p1.f().l(paramv);
/*      */                 } 
/*      */                 
/* 1164 */                 if (c2.X()) {
/*      */                   com.d.i.c c5;
/* 1166 */                   (c5 = c3).f(paramv.b(c2).a("list-item"));
/*      */                 } 
/*      */                 
/* 1169 */                 if (c2.q() || c2.r()) {
/*      */                   d d;
/* 1171 */                   (d = (d)c3).l(paramv);
/*      */                   
/* 1173 */                   c3 = a(paramv, d);
/*      */                 } 
/*      */                 
/* 1176 */                 if (!parama.a() && 
/* 1177 */                   !c2.y()) {
/* 1178 */                   parama.a(true);
/*      */                 }
/*      */                 
/*      */                 com.d.i.c c4;
/* 1182 */                 if ((c4 = c3).a().ae()) {
/* 1183 */                   c4.b(paramv.c().a(element, "first-line"));
/*      */                 }
/*      */                 
/* 1186 */                 if (c4.a().af()) {
/* 1187 */                   c4.a(paramv.c().a(element, "first-letter"));
/*      */                 }
/*      */ 
/*      */                 
/* 1191 */                 c4.l(paramv);
/*      */               } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1206 */               if (c3 != null)
/* 1207 */                 paramList.add(c3);  }  }  } else { if (element == 3 || element == 4) { bool1 = false; bool2 = false; Text text; if (!(text = (Text)node).getParentNode().getNodeName().equals("textarea")) q = a(paramv, text, paramElement, c1, q, paramList);  p = null; }  if (p != null) paramList.add(p);  }
/*      */       
/* 1209 */       } while ((node = node.getNextSibling()) != null);
/*      */     } 
/* 1211 */     if (bool1 || bool2) {
/*      */       q q;
/* 1213 */       (q = a("", paramElement, c1, (Text)null)).c(bool1);
/* 1214 */       q.b(bool2);
/* 1215 */       paramList.add(q);
/*      */     } 
/* 1217 */     a(paramv, paramElement, c1, "after", paramList, parama);
/*      */   }
/*      */   
/*      */   private static q a(q paramq1, q paramq2) {
/* 1221 */     paramq1.b(true);
/*      */     
/* 1223 */     if (paramq2 == null) {
/* 1224 */       paramq1.c(true);
/*      */     } else {
/* 1226 */       paramq2.b(false);
/*      */     } 
/*      */     
/* 1229 */     return paramq1;
/*      */   }
/*      */   
/*      */   private static q a(Text paramText, Element paramElement, com.d.c.f.c paramc, q paramq, List<ac> paramList) {
/*      */     q q1;
/*      */     String str;
/* 1235 */     (q1 = a(str = paramText.getData(), paramElement, paramc, paramText)).a((byte)0);
/* 1236 */     paramq = a(q1, paramq);
/* 1237 */     paramList.add(q1);
/* 1238 */     return paramq;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static q a(v paramv, Text paramText, Element paramElement, com.d.c.f.c paramc, q paramq, List<ac> paramList) {
/*      */     String str;
/*      */     d.b b;
/* 1253 */     if ((b = paramv.f().a(paramText)) == null)
/*      */     {
/* 1255 */       return a(paramText, paramElement, paramc, paramq, paramList);
/*      */     }
/*      */     
/*      */     int i;
/*      */     
/* 1260 */     if ((i = b.a(paramText)) < 0)
/*      */     {
/* 1262 */       return a(paramText, paramElement, paramc, paramq, paramList);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1268 */     aa aa = b.b(i);
/*      */     
/* 1270 */     if (!a && aa == null) throw new AssertionError(); 
/* 1271 */     if (!a && aa.a() > i) throw new AssertionError();
/*      */ 
/*      */ 
/*      */     
/* 1275 */     int j, k = Math.min(j = aa.b() - i - aa.a(), paramText.getLength());
/*      */ 
/*      */     
/* 1278 */     j = k + 0;
/* 1279 */     i += k;
/*      */     
/* 1281 */     if (!a && aa.c() != 0 && aa.c() != 1) throw new AssertionError();
/*      */     
/* 1283 */     if (k == paramText.getLength()) {
/*      */       
/* 1285 */       str = paramText.getData();
/*      */     }
/*      */     else {
/*      */       
/* 1289 */       str = paramText.getData().substring(0, j);
/*      */     } 
/*      */ 
/*      */     
/* 1293 */     if (aa.c() == 1) {
/* 1294 */       str = paramv.g().b(str);
/*      */     }
/*      */     
/*      */     q q1;
/* 1298 */     (q1 = a(str, paramElement, paramc, paramText)).a(aa.c());
/* 1299 */     paramq = a(q1, paramq);
/* 1300 */     paramList.add(q1);
/*      */     
/* 1302 */     if (k != paramText.getLength()) {
/*      */       
/*      */       do {
/*      */         
/* 1306 */         aa = b.a(i);
/* 1307 */         if (!a && aa == null) throw new AssertionError();
/*      */ 
/*      */ 
/*      */         
/* 1311 */         if (aa != null) {
/*      */           int m;
/*      */           
/* 1314 */           k = Math.min(m = aa.b() - i - aa.a(), paramText.getLength() - j);
/*      */           
/* 1316 */           String str1 = paramText.getData().substring(j, j + k);
/*      */ 
/*      */           
/* 1319 */           if (aa.c() == 1) {
/* 1320 */             str1 = paramv.g().b(str1);
/*      */           }
/*      */           
/* 1323 */           i += k;
/* 1324 */           j += k;
/*      */           
/*      */           q q2;
/* 1327 */           (q2 = a(str1, paramElement, paramc, paramText)).a(aa.c());
/* 1328 */           paramq = a(q2, paramq);
/* 1329 */           paramList.add(q2);
/*      */         
/*      */         }
/*      */         else {
/*      */           
/* 1334 */           k = paramText.getLength() - j;
/*      */           
/*      */           q q2;
/*      */           String str1;
/* 1338 */           (q2 = a(str1 = paramText.getData().substring(j, k), paramElement, paramc, paramText)).a(paramv.i());
/* 1339 */           paramq = a(q2, paramq);
/* 1340 */           paramList.add(q2);
/*      */           
/* 1342 */           i += k;
/* 1343 */           j += k;
/*      */         } 
/* 1345 */       } while (j < paramText.getLength());
/*      */     }
/*      */     
/* 1348 */     return paramq;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static void a(aa paramaa, f paramf, List<ac> paramList, boolean paramBoolean) {
/* 1354 */     ArrayList<ac> arrayList = new ArrayList();
/* 1355 */     ArrayDeque<q> arrayDeque = new ArrayDeque();
/* 1356 */     List<q> list = null;
/*      */     
/* 1358 */     for (Iterator<ac> iterator = paramList.iterator(); iterator.hasNext(); ) {
/* 1359 */       q q; ac ac; if ((ac = iterator.next()).a().y() && (!paramBoolean || 
/* 1360 */         !ac.a().P())) {
/* 1361 */         arrayList.add(ac);
/*      */         
/* 1363 */         if (ac.a().o()) {
/*      */           
/* 1365 */           if ((q = (q)ac).g()) {
/* 1366 */             arrayDeque.add(q);
/*      */           }
/* 1368 */           if (q.f())
/* 1369 */             arrayDeque.removeLast(); 
/*      */         } 
/*      */         continue;
/*      */       } 
/* 1373 */       if (arrayList.size() > 0) {
/* 1374 */         a(paramf, arrayList, list);
/* 1375 */         arrayList = new ArrayList<>();
/* 1376 */         list = new ArrayList<>(arrayDeque);
/*      */       } 
/* 1378 */       paramf.b((f)q);
/*      */     } 
/*      */ 
/*      */     
/* 1382 */     a(paramf, arrayList, list);
/*      */   }
/*      */   
/*      */   private static void a(f paramf, List<ac> paramList, List<q> paramList1) {
/* 1386 */     ag.a(paramList);
/* 1387 */     if (paramList.size() > 0) {
/*      */       b b;
/* 1389 */       (b = new b(paramf.ai())).a(paramf.a().a(com.d.c.a.c.h));
/* 1390 */       b.i(true);
/* 1391 */       if (paramList1 != null && paramList1.size() > 0) {
/* 1392 */         b.a(paramList1);
/*      */       }
/* 1394 */       paramf.b((f)b);
/* 1395 */       b.g(1);
/* 1396 */       b.b(paramList);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private static class a
/*      */   {
/*      */     private boolean a;
/*      */     
/*      */     private boolean b;
/*      */     private boolean c;
/*      */     
/*      */     public final boolean a() {
/* 1409 */       return this.a;
/*      */     }
/*      */     
/*      */     public final void a(boolean param1Boolean) {
/* 1413 */       this.a = true;
/*      */     }
/*      */     
/*      */     public final boolean b() {
/* 1417 */       return this.b;
/*      */     }
/*      */     
/*      */     public final void b(boolean param1Boolean) {
/* 1421 */       this.b = true;
/*      */     }
/*      */     
/*      */     public final boolean c() {
/* 1425 */       return this.c;
/*      */     }
/*      */     
/*      */     public final void c(boolean param1Boolean) {
/* 1429 */       this.c = true;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\e\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */