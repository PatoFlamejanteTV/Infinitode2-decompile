/*      */ package com.d.c.d;
/*      */ 
/*      */ import com.d.c.a.d;
/*      */ import com.d.c.c.f;
/*      */ import com.d.c.d.a.m;
/*      */ import com.d.c.e.b;
/*      */ import com.d.c.e.d;
/*      */ import com.d.c.e.e;
/*      */ import com.d.i.a.r;
/*      */ import com.d.i.e;
/*      */ import com.d.i.v;
/*      */ import com.d.l.b;
/*      */ import com.d.m.i;
/*      */ import com.d.m.l;
/*      */ import java.io.IOException;
/*      */ import java.io.Reader;
/*      */ import java.io.StringReader;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.logging.Level;
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
/*      */ public final class c
/*      */ {
/*      */   private static final Set a;
/*      */   private static final Set b;
/*      */   private k c;
/*      */   private i d;
/*      */   private a e;
/*      */   private String f;
/*      */   
/*      */   static {
/*   45 */     (a = new HashSet<>()).add("first-line");
/*   46 */     a.add("first-letter");
/*   47 */     a.add("before");
/*   48 */     a.add("after");
/*      */ 
/*      */     
/*   51 */     (b = new HashSet<>()).add("first-line");
/*   52 */     b.add("first-letter");
/*   53 */     b.add("before");
/*   54 */     b.add("after");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   63 */   private Map g = new HashMap<>();
/*      */   private boolean h;
/*      */   
/*      */   public c(a parama) {
/*   67 */     this.d = new i(new StringReader(""));
/*   68 */     this.e = parama;
/*      */   }
/*      */ 
/*      */   
/*      */   public final r a(String paramString, int paramInt, Reader paramReader) {
/*   73 */     this.f = paramString;
/*   74 */     a(paramReader);
/*      */     
/*   76 */     r r = new r(paramString, paramInt);
/*   77 */     a(r);
/*      */     
/*   79 */     return r;
/*      */   }
/*      */   
/*      */   public final d a(int paramInt, String paramString) {
/*      */     try {
/*   84 */       this.f = i.a().a().p();
/*   85 */       a(new StringReader(paramString));
/*      */       
/*   87 */       k();
/*      */       
/*   89 */       d d = new d(paramInt);
/*      */       
/*      */       try {
/*   92 */         a(d, true, false, false);
/*   93 */       } catch (b b) {}
/*      */ 
/*      */ 
/*      */       
/*   97 */       return d;
/*   98 */     } catch (IOException iOException) {
/*      */       
/*  100 */       throw new RuntimeException(iOException.getMessage(), iOException);
/*      */     } 
/*      */   }
/*      */   
/*      */   public final j a(com.d.c.a.a<v> parama, int paramInt, String paramString) {
/*  105 */     this.f = parama + " property value";
/*      */     try {
/*  107 */       a(new StringReader(paramString));
/*  108 */       List list = c((parama == com.d.c.a.a.O || parama == com.d.c.a.a.bg || parama == com.d.c.a.a.s));
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  113 */       m m = com.d.c.a.a.e(parama);
/*      */       
/*      */       try {
/*  116 */         List list1 = m.a(parama, list, 0, false);
/*  117 */       } catch (b b) {
/*  118 */         (parama = null).a(p());
/*  119 */         throw parama;
/*      */       } 
/*      */       
/*  122 */       if (parama.size() != 1) {
/*  123 */         throw new b("Builder created " + parama
/*  124 */             .size() + "properties, expected 1", p());
/*      */       }
/*      */       
/*      */       v v;
/*      */       
/*  129 */       return (j)(v = parama.get(0)).e();
/*  130 */     } catch (IOException iOException) {
/*      */       
/*  132 */       throw new RuntimeException(iOException.getMessage(), iOException);
/*  133 */     } catch (b b) {
/*  134 */       a(b, "property value", false);
/*  135 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(r paramr) {
/*  146 */     k k1 = n();
/*      */     try {
/*  148 */       if (k1 == k.t) {
/*      */         try {
/*  150 */           m();
/*  151 */           k();
/*      */           
/*  153 */           if ((k1 = m()) == k.m) {
/*      */ 
/*      */             
/*  156 */             k();
/*      */             
/*  158 */             if ((k1 = m()) != k.P) {
/*  159 */               c(k1);
/*  160 */               throw new b(k1, k.P, p());
/*      */             }
/*      */           
/*      */           } else {
/*      */             
/*  165 */             c(k1);
/*  166 */             throw new b(k1, k.m, p());
/*      */           } 
/*  168 */         } catch (b b) {
/*  169 */           a(b, "@charset rule", true);
/*  170 */           a(false, false);
/*      */         } 
/*      */       }
/*  173 */       l();
/*      */ 
/*      */       
/*  176 */       while ((k1 = n()) == k.q) {
/*  177 */         b(paramr);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  185 */       while ((k1 = n()) == k.u) {
/*  186 */         a();
/*  187 */         l();
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  194 */       while ((k1 = n()) != k.aa) {
/*      */ 
/*      */         
/*  197 */         switch (k1.a()) {
/*      */           case 18:
/*  199 */             e(paramr);
/*      */             break;
/*      */           case 19:
/*  202 */             c(paramr);
/*      */             break;
/*      */           case 22:
/*  205 */             d(paramr);
/*      */             break;
/*      */           case 17:
/*  208 */             m();
/*  209 */             a(new b("@import not allowed here", p()), "@import rule", true);
/*      */             
/*  211 */             a(false, false);
/*      */             break;
/*      */           case 21:
/*  214 */             m();
/*  215 */             a(new b("@namespace not allowed here", p()), "@namespace rule", true);
/*      */             
/*  217 */             a(false, false);
/*      */             break;
/*      */           case 23:
/*  220 */             m();
/*  221 */             a(new b("Invalid at-rule", 
/*  222 */                   p()), "at-rule", true);
/*  223 */             a(false, false);
/*      */           
/*      */           default:
/*  226 */             a((e)paramr); break;
/*      */         } 
/*  228 */         l();
/*      */       }  return;
/*  230 */     } catch (b b) {
/*      */       
/*  232 */       if (!(k1 = null).b()) {
/*  233 */         a((b)k1, "stylesheet", false);
/*      */       }
/*      */       return;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void b(r paramr) {
/*      */     try {
/*      */       k k1;
/*  246 */       if ((k1 = m()) == k.q) {
/*      */         String str1, str2; b b;
/*  248 */         (b = new b()).a(paramr.a());
/*      */ 
/*      */         
/*  251 */         k();
/*      */         
/*  253 */         switch ((k1 = m()).a()) {
/*      */           case 13:
/*      */           case 39:
/*  256 */             str1 = d(k1);
/*  257 */             str2 = paramr.b();
/*      */ 
/*      */ 
/*      */             
/*  261 */             if ((str2 = i.a().a().n().a(str2, str1)) == null) {
/*  262 */               l.e(Level.INFO, "URI resolver rejected resolving CSS import at (" + str1 + ")");
/*      */             }
/*      */             
/*  265 */             b.b(str2);
/*      */             
/*  267 */             k();
/*      */             
/*  269 */             if ((k1 = n()) == k.o) {
/*  270 */               b.d(b());
/*      */ 
/*      */               
/*  273 */               while ((k1 = n()) == k.l) {
/*  274 */                 m();
/*  275 */                 k();
/*      */                 
/*  277 */                 if ((k1 = n()) == k.o) {
/*  278 */                   b.d(b()); continue;
/*      */                 } 
/*  280 */                 throw new b(k1, k.o, 
/*  281 */                     p());
/*      */               } 
/*      */             } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  289 */             if ((k1 = m()) == k.P) {
/*  290 */               k(); break;
/*      */             } 
/*  292 */             c(k1);
/*  293 */             throw new b(k1, k.P, 
/*  294 */                 p());
/*      */ 
/*      */           
/*      */           default:
/*  298 */             c(k1);
/*  299 */             throw new b(k1, new k[] { k.m, k.M
/*  300 */                 }, p());
/*      */         } 
/*      */         
/*  303 */         if (b.b().size() == 0) {
/*  304 */           b.d("all");
/*      */         }
/*  306 */         paramr.a(b);
/*      */       } else {
/*  308 */         c(k1);
/*  309 */         throw new b(k1, k.q, 
/*  310 */             p());
/*      */       } 
/*  312 */     } catch (b b) {
/*  313 */       a(b, "@import rule", true);
/*  314 */       a(false, false);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a() {
/*      */     try {
/*      */       k k1;
/*  327 */       if ((k1 = m()) == k.u) {
/*  328 */         String str2, str1 = null;
/*      */ 
/*      */         
/*  331 */         k();
/*      */ 
/*      */         
/*  334 */         if ((k1 = m()) == k.o) {
/*  335 */           str1 = d(k1);
/*  336 */           k();
/*  337 */           k1 = m();
/*      */         } 
/*      */         
/*  340 */         if (k1 == k.m || k1 == k.M) {
/*  341 */           str2 = d(k1);
/*      */         } else {
/*  343 */           throw new b(k1, new k[] { k.m, k.M
/*  344 */               }, p());
/*      */         } 
/*      */         
/*  347 */         k();
/*      */ 
/*      */         
/*  350 */         if ((k1 = m()) == k.P) {
/*  351 */           k();
/*      */           
/*  353 */           this.g.put(str1, str2);
/*      */         } else {
/*  355 */           throw new b(k1, k.P, 
/*  356 */               p());
/*      */         } 
/*      */       } else {
/*  359 */         throw new b(k1, k.u, p());
/*      */       }  return;
/*  361 */     } catch (b b) {
/*  362 */       a(b, "@namespace rule", true);
/*  363 */       a(false, false);
/*      */       return;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void c(r paramr) {
/*  372 */     k k1 = m();
/*      */     try {
/*  374 */       if (k1 == k.s) {
/*  375 */         b b = new b(paramr.a());
/*  376 */         k();
/*      */         
/*  378 */         if ((k1 = n()) == k.o) {
/*  379 */           b.a(b());
/*      */ 
/*      */           
/*  382 */           while ((k1 = n()) == k.l) {
/*  383 */             m();
/*  384 */             k();
/*      */             
/*  386 */             if ((k1 = n()) == k.o) {
/*  387 */               b.a(b()); continue;
/*      */             } 
/*  389 */             throw new b(k1, k.o, p());
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  396 */           if ((k1 = m()) == k.i) {
/*  397 */             k();
/*      */ 
/*      */ 
/*      */             
/*  401 */             while ((k1 = n()) != null) {
/*      */ 
/*      */               
/*  404 */               switch (k1.a()) {
/*      */                 case 42:
/*  406 */                   m();
/*      */                   break;
/*      */               } 
/*  409 */               a((e)b);
/*      */             } 
/*      */             
/*  412 */             k();
/*      */           } else {
/*  414 */             c(k1);
/*  415 */             throw new b(k1, k.i, p());
/*      */           } 
/*      */         } else {
/*  418 */           throw new b(k1, k.o, p());
/*      */         } 
/*      */         
/*  421 */         paramr.a(b);
/*      */       } else {
/*  423 */         c(k1);
/*  424 */         throw new b(k1, k.s, p());
/*      */       } 
/*  426 */     } catch (b b) {
/*  427 */       a(b, "@media rule", true);
/*  428 */       a(false, false);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String b() {
/*      */     String str;
/*      */     k k1;
/*  439 */     if ((k1 = m()) == k.o) {
/*  440 */       str = d(k1);
/*  441 */       k();
/*      */     } else {
/*  443 */       c((k)str);
/*  444 */       throw new b(str, k.o, p());
/*      */     } 
/*  446 */     return str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void d(r paramr) {
/*  455 */     k k1 = m();
/*      */     try {
/*  457 */       com.d.c.e.a a1 = new com.d.c.e.a(paramr.a());
/*  458 */       if (k1 == k.v) {
/*  459 */         k();
/*      */         
/*  461 */         d d = new d(paramr.a());
/*      */         
/*  463 */         k();
/*      */         
/*  465 */         if ((k1 = m()) == k.i) {
/*      */ 
/*      */           
/*  468 */           byte b = 0;
/*      */           
/*      */           while (true) {
/*  471 */             if (++b >= 1048576)
/*  472 */               throw new b(k1, k.O, p()); 
/*  473 */             k();
/*      */             
/*  475 */             if ((k1 = n()) == k.O) {
/*  476 */               m();
/*  477 */               k();
/*      */               break;
/*      */             } 
/*  480 */             a(d, false, true, true);
/*      */           } 
/*      */         } else {
/*      */           
/*  484 */           c(k1);
/*  485 */           throw new b(k1, k.i, p());
/*      */         } 
/*      */         
/*  488 */         a1.a(d);
/*  489 */         paramr.a(a1);
/*      */       } else {
/*  491 */         c(k1);
/*  492 */         throw new b(k1, k.v, p());
/*      */       } 
/*  494 */     } catch (b b) {
/*  495 */       a(b, "@font-face rule", true);
/*  496 */       a(false, false);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void e(r paramr) {
/*  506 */     k k1 = m();
/*      */     try {
/*  508 */       com.d.c.e.c c1 = new com.d.c.e.c(paramr.a());
/*  509 */       if (k1 == k.r) {
/*  510 */         k();
/*      */         
/*  512 */         if ((k1 = n()) == k.o) {
/*      */           String str;
/*  514 */           if ((str = d(k1)).equals("auto")) {
/*  515 */             throw new b("page name may not be auto", p());
/*      */           }
/*  517 */           m();
/*  518 */           c1.b(str);
/*  519 */           k1 = n();
/*      */         } 
/*  521 */         if (k1 == k.R) {
/*  522 */           c1.a(c());
/*      */         }
/*  524 */         d d = new d(paramr.a());
/*      */         
/*  526 */         k();
/*      */         
/*  528 */         if ((k1 = m()) == k.i) {
/*      */           
/*      */           while (true) {
/*  531 */             k();
/*      */             
/*  533 */             if ((k1 = n()) == k.O) {
/*  534 */               m();
/*  535 */               k(); break;
/*      */             } 
/*  537 */             if (k1 == k.w) {
/*  538 */               a(paramr, c1); continue;
/*      */             } 
/*  540 */             a(d, false, true, false);
/*      */           } 
/*      */         } else {
/*      */           
/*  544 */           c(k1);
/*  545 */           throw new b(k1, k.i, p());
/*      */         } 
/*      */         
/*  548 */         c1.a(d);
/*  549 */         paramr.a(c1);
/*      */       } else {
/*  551 */         c(k1);
/*  552 */         throw new b(k1, k.r, p());
/*      */       } 
/*  554 */     } catch (b b) {
/*  555 */       a(b, "@page rule", true);
/*  556 */       a(false, false);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(r paramr, com.d.c.e.c paramc) {
/*      */     k k1;
/*  565 */     if ((k1 = m()) != k.w) {
/*  566 */       a(new b(k1, k.w, p()), "at rule", true);
/*  567 */       a(true, false);
/*      */       return;
/*      */     } 
/*      */     String str;
/*      */     d d;
/*  572 */     if ((d = d.a(str = d(k1))) == null) {
/*  573 */       a(new b(str + " is not a valid margin box name", p()), "at rule", true);
/*  574 */       a(true, false);
/*      */       
/*      */       return;
/*      */     } 
/*  578 */     k();
/*      */     try {
/*      */       k k2;
/*  581 */       if ((k2 = m()) == k.i) {
/*  582 */         k();
/*  583 */         d d1 = new d(paramr.a());
/*  584 */         a(d1, false, false, false);
/*      */         
/*  586 */         if ((k2 = m()) != k.O) {
/*  587 */           c(k2);
/*  588 */           throw new b(k2, k.O, p());
/*      */         } 
/*  590 */         paramc.a(d, d1.a());
/*      */       } else {
/*  592 */         c(k2);
/*  593 */         throw new b(k2, k.i, p());
/*      */       } 
/*  595 */     } catch (b b) {
/*  596 */       a(b, "margin box", true);
/*  597 */       a(false, false);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String c() {
/*      */     String str;
/*      */     k k1;
/*  609 */     if ((k1 = m()) == k.R) {
/*      */       
/*  611 */       if ((k1 = m()) == k.o) {
/*      */         
/*  613 */         if (!(str = d(k1)).equals("first") && !str.equals("left") && !str.equals("right")) {
/*  614 */           throw new b("Pseudo page must be one of first, left, or right", p());
/*      */         }
/*      */       } else {
/*  617 */         c((k)str);
/*  618 */         throw new b(str, k.o, p());
/*      */       } 
/*      */     } else {
/*  621 */       c((k)str);
/*  622 */       throw new b(str, k.R, p());
/*      */     } 
/*  624 */     return str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void d() {
/*      */     k k1;
/*  632 */     switch ((k1 = n()).a()) {
/*      */       case 12:
/*      */       case 44:
/*  635 */         m();
/*  636 */         k();
/*      */         break;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private k e() {
/*      */     k k1;
/*  649 */     if ((k1 = m()) == k.j || k1 == k.k) {
/*  650 */       k();
/*  651 */     } else if (k1 != k.a) {
/*  652 */       c(k1);
/*  653 */       throw new b(k1, new k[] { k.j, k.k, k.a
/*      */           },
/*      */           
/*  656 */           p());
/*      */     } 
/*  658 */     return k1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int f() {
/*      */     k k1;
/*  667 */     if ((k1 = m()) != k.S && k1 != k.j) {
/*  668 */       c(k1);
/*  669 */       throw new b(k1, new k[] { k.S, k.j
/*  670 */           }, p());
/*      */     } 
/*  672 */     if (k1 == k.S) {
/*  673 */       return -1;
/*      */     }
/*  675 */     return 1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String g() {
/*      */     String str;
/*      */     k k1;
/*  686 */     if ((k1 = m()) == k.o) {
/*  687 */       str = d(k1);
/*  688 */       k();
/*      */     } else {
/*  690 */       c((k)str);
/*  691 */       throw new b(str, k.o, 
/*  692 */           p());
/*      */     } 
/*      */     
/*  695 */     return str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(d paramd, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/*      */     while (true) {
/*      */       k k1;
/*  707 */       switch ((k1 = n()).a()) {
/*      */         case 43:
/*  709 */           m();
/*  710 */           k();
/*      */           continue;
/*      */         case 42:
/*      */           return;
/*      */         case 23:
/*  715 */           if (!paramBoolean2)
/*      */           
/*      */           { 
/*  718 */             a(paramd, paramBoolean3); }
/*      */           else { break; }
/*      */         
/*      */         case 54:
/*  722 */           if (!paramBoolean1) {
/*      */             break;
/*      */           }
/*      */           break;
/*      */       } 
/*  727 */       a(paramd, paramBoolean3);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(e parame) {
/*      */     try {
/*  739 */       d d = new d(parame.a());
/*      */       
/*  741 */       a(d);
/*      */       
/*      */       k k1;
/*      */       
/*  745 */       while ((k1 = n()) == k.l) {
/*  746 */         m();
/*  747 */         k();
/*  748 */         a(d);
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  754 */       if ((k1 = m()) == k.i) {
/*  755 */         k();
/*  756 */         a(d, false, false, false);
/*      */         
/*  758 */         if ((k1 = m()) == k.O) {
/*  759 */           k();
/*      */         } else {
/*  761 */           c(k1);
/*  762 */           throw new b(k1, k.O, p());
/*      */         } 
/*      */       } else {
/*  765 */         c(k1);
/*  766 */         throw new b(k1, new k[] { k.l, k.i
/*  767 */             }, p());
/*      */       } 
/*      */       
/*  770 */       if (d.a().size() > 0)
/*  771 */         parame.a(d); 
/*      */       return;
/*  773 */     } catch (b b) {
/*  774 */       a(b, "ruleset", true);
/*  775 */       a(true, false);
/*      */       return;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(d paramd) {
/*  784 */     ArrayList<f> arrayList = new ArrayList();
/*  785 */     ArrayList<k> arrayList1 = new ArrayList();
/*  786 */     arrayList.add(b(paramd));
/*      */     
/*      */     while (true) {
/*      */       k k1;
/*  790 */       switch ((k1 = n()).a()) {
/*      */         case 1:
/*      */         case 10:
/*      */         case 11:
/*  794 */           arrayList1.add(e());
/*      */           
/*  796 */           switch ((k1 = n()).a()) {
/*      */             case 15:
/*      */             case 16:
/*      */             case 45:
/*      */             case 48:
/*      */             case 50:
/*      */             case 52:
/*  803 */               arrayList.add(b(paramd));
/*      */               continue;
/*      */           } 
/*  806 */           throw new b(k1, new k[] { k.o, k.Y, k.p, k.W, k.U, k.R
/*      */               },
/*  808 */               p());
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*      */       break;
/*      */     } 
/*  815 */     paramd.a(a(arrayList, arrayList1));
/*      */   }
/*      */   
/*      */   private f a(List<f> paramList1, List<k> paramList2) {
/*      */     int j;
/*  820 */     if ((j = paramList1.size()) == 1) {
/*  821 */       return paramList1.get(0);
/*      */     }
/*      */     
/*  824 */     boolean bool = false;
/*  825 */     f f = null;
/*  826 */     for (byte b = 0; b < j - 1; b++) {
/*  827 */       f f1 = paramList1.get(b);
/*  828 */       f f2 = paramList1.get(b + 1);
/*  829 */       k k1 = paramList2.get(b);
/*      */       
/*  831 */       if (f1.f() != null) {
/*  832 */         throw new b("A simple selector with a pseudo element cannot be combined with another simple selector", 
/*      */             
/*  834 */             p());
/*      */       }
/*      */       
/*  837 */       boolean bool1 = false;
/*  838 */       if (k1 == k.a) {
/*  839 */         f2.d(0);
/*  840 */         bool = false;
/*  841 */       } else if (k1 == k.k) {
/*  842 */         f2.d(1);
/*  843 */         bool = true;
/*  844 */       } else if (k1 == k.j) {
/*  845 */         f1.d(2);
/*  846 */         bool1 = true;
/*      */       } 
/*      */       
/*  849 */       f2.e(f2.j() + f1.j());
/*  850 */       f2.f(f2.l() + f1.l());
/*  851 */       f2.g(f2.k() + f1.k());
/*      */       
/*  853 */       if (!bool1) {
/*  854 */         if (f == null) {
/*  855 */           f = f1;
/*      */         }
/*  857 */         f1.a(f2);
/*      */       } else {
/*  859 */         f2.b(f1);
/*  860 */         if (f == null || f == f1) {
/*  861 */           f = f2;
/*      */         }
/*  863 */         if (b > 0) {
/*  864 */           for (int m = b - 1; m >= 0; m--) {
/*      */             f f3;
/*  866 */             if ((f3 = paramList1.get(m)).g() == f1) {
/*  867 */               f3.a(f2);
/*  868 */               f2.d(bool);
/*      */               
/*      */               break;
/*      */             } 
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/*  876 */     return f;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private f b(d paramd) {
/*      */     a a1;
/*      */     k k1;
/*      */     f f;
/*  886 */     (f = new f()).a(paramd);
/*      */     k k2;
/*  888 */     switch ((k2 = n()).a())
/*      */     { case 15:
/*      */       case 52:
/*      */       case 53:
/*  892 */         a1 = b(false);
/*  893 */         f.g(a1.a());
/*  894 */         f.f(a1.b());
/*      */ 
/*      */         
/*      */         while (true) {
/*  898 */           switch ((k1 = n()).a()) {
/*      */             case 16:
/*  900 */               k1 = m();
/*  901 */               f.c(a(k1, true));
/*      */               continue;
/*      */             case 50:
/*  904 */               a(f);
/*      */               continue;
/*      */             case 48:
/*  907 */               b(f);
/*      */               continue;
/*      */             case 45:
/*  910 */               c(f);
/*      */               continue;
/*      */           } 
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
/*      */           break;
/*      */         } 
/*  949 */         return f; }  boolean bool = false; while (true) { switch ((k1 = n()).a()) { case 16: k1 = m(); f.c(a(k1, true)); bool = true; continue;case 50: a(f); bool = true; continue;case 48: b(f); bool = true; continue;case 45: c(f); bool = true; continue; }  break; }  if (!bool) throw new b(k1, new k[] { k.p, k.W, k.U, k.R }, p());  return f;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private a b(boolean paramBoolean) {
/*  959 */     String str3, str1 = null;
/*  960 */     String str2 = null;
/*      */     
/*      */     k k1;
/*  963 */     if ((k1 = n()) == k.Y || k1 == k.o) {
/*  964 */       m();
/*  965 */       if (k1 == k.o) {
/*  966 */         str2 = a(k1, true);
/*      */       }
/*  968 */       k1 = n();
/*  969 */     } else if (k1 == k.Z) {
/*  970 */       str1 = "";
/*      */     } else {
/*  972 */       throw new b(k1, new k[] { k.Y, k.o, k.Z
/*      */           },
/*  974 */           p());
/*      */     } 
/*      */     
/*  977 */     if (k1 == k.Z) {
/*  978 */       m();
/*      */       
/*  980 */       if ((k1 = m()) == k.Y || k1 == k.o) {
/*  981 */         if (str1 == null) {
/*  982 */           str1 = str2;
/*      */         }
/*  984 */         if (k1 == k.o) {
/*  985 */           str2 = a(k1, true);
/*      */         }
/*      */       } else {
/*  988 */         throw new b(k1, new k[] { k.Y, k.o
/*  989 */             }, p());
/*      */       } 
/*      */     } 
/*      */     
/*  993 */     k1 = null;
/*  994 */     if (str1 != null && str1 != "") {
/*      */       
/*  996 */       if ((str3 = (String)this.g.get(str1.toLowerCase())) == null) {
/*  997 */         throw new b("There is no namespace with prefix " + str1 + " defined", 
/*  998 */             p());
/*      */       }
/* 1000 */     } else if (str1 == null && !paramBoolean) {
/* 1001 */       str3 = (String)this.g.get(null);
/*      */     } 
/*      */     
/* 1004 */     if (paramBoolean && str2 == null) {
/* 1005 */       throw new b("An attribute name is required", p());
/*      */     }
/*      */     
/* 1008 */     return new a(str3, str2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(f paramf) {
/*      */     k k1;
/* 1017 */     if ((k1 = m()) == k.W) {
/*      */       
/* 1019 */       if ((k1 = m()) == k.o) {
/* 1020 */         paramf.d(a(k1, true)); return;
/*      */       } 
/* 1022 */       c(k1);
/* 1023 */       throw new b(k1, k.o, p());
/*      */     } 
/*      */     
/* 1026 */     c(k1);
/* 1027 */     throw new b(k1, k.W, p());
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
/*      */   private void b(f paramf) {
/*      */     k k1;
/* 1061 */     if ((k1 = m()) == k.U) {
/* 1062 */       k();
/*      */       
/* 1064 */       if ((k1 = n()) == k.o || k1 == k.Y || k1 == k.Z) {
/* 1065 */         String str1; k k3; boolean bool = true;
/*      */         a a1;
/* 1067 */         String str2 = (a1 = b(true)).a();
/* 1068 */         String str3 = a1.b();
/* 1069 */         k();
/*      */         k k2;
/* 1071 */         switch ((k2 = n()).a()) {
/*      */           case 4:
/*      */           case 5:
/*      */           case 6:
/*      */           case 7:
/*      */           case 8:
/*      */           case 51:
/* 1078 */             bool = false;
/* 1079 */             k3 = m();
/* 1080 */             k();
/*      */             
/* 1082 */             if ((k2 = m()) == k.o || k2 == k.m) {
/* 1083 */               str1 = a(k2, true);
/* 1084 */               switch (k3.a()) {
/*      */                 case 51:
/* 1086 */                   paramf.a(str2, str3, str1);
/*      */                   break;
/*      */                 case 5:
/* 1089 */                   paramf.f(str2, str3, str1);
/*      */                   break;
/*      */                 case 4:
/* 1092 */                   paramf.e(str2, str3, str1);
/*      */                   break;
/*      */                 case 6:
/* 1095 */                   paramf.b(str2, str3, str1);
/*      */                   break;
/*      */                 case 7:
/* 1098 */                   paramf.c(str2, str3, str1);
/*      */                   break;
/*      */                 case 8:
/* 1101 */                   paramf.d(str2, str3, str1);
/*      */                   break;
/*      */               } 
/* 1104 */               k();
/*      */             } else {
/* 1106 */               c((k)str1);
/* 1107 */               throw new b(str1, new k[] { k.o, k.m
/*      */                   },
/* 1109 */                   p());
/*      */             } 
/* 1111 */             k();
/* 1112 */             k1 = n();
/*      */             break;
/*      */         } 
/* 1115 */         if (bool) {
/* 1116 */           paramf.a(str2, str3);
/*      */         }
/* 1118 */         if (k1 == k.V) {
/* 1119 */           m();
/*      */         } else {
/* 1121 */           throw new b(k1, new k[] { k.X, k.d, k.e, k.f, k.g, k.h, k.V
/*      */               },
/*      */               
/* 1124 */               p());
/*      */         } 
/*      */       } else {
/* 1127 */         throw new b(k1, new k[] { k.o, k.Y
/* 1128 */             }, p());
/*      */       } 
/*      */     } else {
/* 1131 */       c(k1);
/* 1132 */       throw new b(k1, k.U, p());
/*      */     } 
/*      */   }
/*      */   
/*      */   private void a(k paramk, f paramf) {
/*      */     String str;
/* 1138 */     if ((str = d(paramk)).equals("link")) {
/* 1139 */       paramf.a(); return;
/* 1140 */     }  if (str.equals("visited")) {
/* 1141 */       paramf.a(2); return;
/* 1142 */     }  if (str.equals("hover")) {
/* 1143 */       paramf.a(4); return;
/* 1144 */     }  if (str.equals("focus")) {
/* 1145 */       paramf.a(16); return;
/* 1146 */     }  if (str.equals("active")) {
/* 1147 */       paramf.a(8); return;
/* 1148 */     }  if (str.equals("first-child")) {
/* 1149 */       paramf.b(); return;
/* 1150 */     }  if (str.equals("even")) {
/* 1151 */       paramf.d(); return;
/* 1152 */     }  if (str.equals("odd")) {
/* 1153 */       paramf.e(); return;
/* 1154 */     }  if (str.equals("last-child")) {
/* 1155 */       paramf.c(); return;
/* 1156 */     }  if (b.contains(str)) {
/* 1157 */       paramf.e(str); return;
/*      */     } 
/* 1159 */     throw new b(str + " is not a recognized pseudo-class", p());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void b(k paramk, f paramf) {
/*      */     String str;
/* 1167 */     if ((str = (str = d(paramk)).substring(0, str.length() - 1)).equals("lang"))
/* 1168 */     { k();
/*      */       
/* 1170 */       if ((paramk = m()) == k.o) {
/* 1171 */         str = d(paramk);
/* 1172 */         paramf.b(str);
/* 1173 */         k();
/* 1174 */         paramk = m();
/*      */       } else {
/* 1176 */         c(paramk);
/* 1177 */         throw new b(paramk, k.o, p());
/*      */       }  }
/* 1179 */     else { StringBuilder stringBuilder; if (str.equals("nth-child")) {
/* 1180 */         stringBuilder = new StringBuilder();
/* 1181 */         while ((paramk = m()) != null && (paramk == k.o || paramk == k.a || paramk == k.L || paramk == k.J || paramk == k.j || paramk == k.S)) {
/* 1182 */           stringBuilder.append(d(paramk));
/*      */         }
/*      */         
/*      */         try {
/* 1186 */           paramf.a(stringBuilder.toString());
/* 1187 */         } catch (b b) {
/* 1188 */           (paramf = null).a(p());
/* 1189 */           c(paramk);
/* 1190 */           throw paramf;
/*      */         } 
/*      */       } else {
/* 1193 */         c(paramk);
/* 1194 */         throw new b(stringBuilder + " is not a valid function in this context", p());
/*      */       }  }
/*      */     
/* 1197 */     if (paramk != k.T) {
/* 1198 */       c(paramk);
/* 1199 */       throw new b(paramk, k.T, p());
/*      */     } 
/*      */   }
/*      */   
/*      */   private void c(k paramk, f paramf) {
/* 1204 */     String str = d(paramk);
/* 1205 */     if (a.contains(str)) {
/* 1206 */       paramf.e(str); return;
/*      */     } 
/* 1208 */     throw new b(str + " is not a recognized psuedo-element", p());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void c(f paramf) {
/*      */     k k1;
/* 1218 */     if ((k1 = m()) == k.R) {
/*      */       
/* 1220 */       switch ((k1 = m()).a()) {
/*      */         case 45:
/* 1222 */           k1 = m();
/* 1223 */           c(k1, paramf);
/*      */           return;
/*      */         case 15:
/* 1226 */           a(k1, paramf);
/*      */           return;
/*      */         case 40:
/* 1229 */           b(k1, paramf);
/*      */           return;
/*      */       } 
/* 1232 */       c(k1);
/* 1233 */       throw new b(k1, new k[] { k.o, k.N
/* 1234 */           }, p());
/*      */     } 
/*      */     
/* 1237 */     c(k1);
/* 1238 */     throw new b(k1, k.R, p());
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean a(com.d.c.a.a parama, String paramString) {
/* 1243 */     if (parama == null) {
/* 1244 */       this.e.a(this.f, paramString + " is an unrecognized CSS property at line " + 
/*      */ 
/*      */           
/* 1247 */           p() + ". Ignoring declaration.");
/* 1248 */       return false;
/*      */     } 
/*      */     
/* 1251 */     if (!com.d.c.a.a.d(parama)) {
/* 1252 */       this.e.a(this.f, paramString + " is not implemented at line " + 
/*      */ 
/*      */           
/* 1255 */           p() + ". Ignoring declaration.");
/* 1256 */       return false;
/*      */     } 
/*      */     
/*      */     m m;
/* 1260 */     if ((m = com.d.c.a.a.e(parama)) == null) {
/* 1261 */       this.e.a(this.f, "(bug) No property builder defined for " + paramString + " at line " + 
/*      */ 
/*      */           
/* 1264 */           p() + ". Ignoring declaration.");
/* 1265 */       return false;
/*      */     } 
/*      */     
/* 1268 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(d paramd, boolean paramBoolean) {
/*      */     try {
/*      */       k k1;
/* 1278 */       if ((k1 = n()) == k.o) {
/*      */         String str;
/* 1280 */         com.d.c.a.a a1 = com.d.c.a.a.a(str = g());
/*      */         
/* 1282 */         boolean bool = a(a1, str);
/*      */ 
/*      */         
/* 1285 */         if ((k1 = m()) == k.R)
/* 1286 */         { k();
/*      */           
/* 1288 */           List list = c((a1 == com.d.c.a.a.O || a1 == com.d.c.a.a.bg || a1 == com.d.c.a.a.s));
/*      */ 
/*      */ 
/*      */           
/* 1292 */           boolean bool1 = false;
/*      */ 
/*      */           
/* 1295 */           if ((k1 = n()) == k.x) {
/* 1296 */             h();
/* 1297 */             bool1 = true;
/*      */           } 
/*      */ 
/*      */           
/* 1301 */           if ((k1 = n()) != k.P && k1 != k.O && k1 != k.aa) {
/* 1302 */             throw new b(k1, new k[] { k.P, k.O
/*      */                 },
/*      */                 
/* 1305 */                 p());
/*      */           }
/*      */           
/* 1308 */           if (bool)
/*      */           { try {
/* 1310 */               m m = com.d.c.a.a.e(a1);
/* 1311 */               paramd.a(m.a(a1, list, paramd
/* 1312 */                     .c(), bool1, !paramBoolean));
/* 1313 */             } catch (b b) {
/* 1314 */               (k1 = null).a(p());
/* 1315 */               a((b)k1, "declaration", true); return;
/*      */             }  }
/*      */           else { return; }
/*      */            }
/* 1319 */         else { c(k1);
/* 1320 */           throw new b(k1, k.R, p()); }
/*      */       
/*      */       } else {
/* 1323 */         throw new b(k1, k.o, p());
/*      */       } 
/* 1325 */     } catch (b b) {
/* 1326 */       a(b, "declaration", true);
/* 1327 */       a(false, true);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void h() {
/*      */     k k1;
/* 1337 */     if ((k1 = m()) == k.x) {
/* 1338 */       k(); return;
/*      */     } 
/* 1340 */     c(k1);
/* 1341 */     throw new b(k1, k.x, p());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private List c(boolean paramBoolean) {
/*      */     j j;
/*      */     boolean bool;
/*      */     ArrayList<j> arrayList;
/* 1351 */     (arrayList = new ArrayList<>(10)).add(d(paramBoolean));
/*      */     while (true) {
/* 1353 */       k k1 = n();
/* 1354 */       bool = false;
/* 1355 */       k k2 = null;
/* 1356 */       switch (k1.a()) {
/*      */         case 12:
/*      */         case 44:
/* 1359 */           k2 = k1;
/* 1360 */           d();
/* 1361 */           k1 = n();
/* 1362 */           bool = true;
/*      */           break;
/*      */       } 
/* 1365 */       switch (k1.a()) {
/*      */         case 10:
/*      */         case 13:
/*      */         case 15:
/*      */         case 16:
/*      */         case 25:
/*      */         case 26:
/*      */         case 27:
/*      */         case 28:
/*      */         case 29:
/*      */         case 30:
/*      */         case 31:
/*      */         case 32:
/*      */         case 33:
/*      */         case 34:
/*      */         case 35:
/*      */         case 37:
/*      */         case 38:
/*      */         case 39:
/*      */         case 40:
/*      */         case 46:
/* 1386 */           j = d(paramBoolean);
/* 1387 */           if (k2 != null) {
/* 1388 */             j.a(k2);
/*      */           }
/* 1390 */           arrayList.add(j); continue;
/*      */       }  break;
/*      */     } 
/* 1393 */     if (bool) {
/* 1394 */       throw new b(j, new k[] { k.L, k.j, k.S, k.K, k.A, k.y, k.z, k.F, k.C, k.B, k.D, k.E, k.G, k.H, k.I, k.m, k.o, k.M, k.p, k.N
/*      */           },
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1400 */           p());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1407 */     return arrayList;
/*      */   }
/*      */   
/*      */   private String a(k paramk) {
/* 1411 */     String str = d(paramk);
/*      */     
/* 1413 */     byte b1 = 0;
/* 1414 */     char[] arrayOfChar = str.toCharArray(); byte b2; char c1;
/* 1415 */     for (b2 = 0; b2 < arrayOfChar.length && (
/*      */       
/* 1417 */       c1 = arrayOfChar[b2]) >= '0' && c1 <= '9'; b2++)
/*      */     {
/*      */       
/* 1420 */       b1++;
/*      */     }
/* 1422 */     if (arrayOfChar[b1] == '.')
/*      */     {
/*      */       
/* 1425 */       for (b2 = ++b1; b2 < arrayOfChar.length && (
/*      */         
/* 1427 */         c1 = arrayOfChar[b2]) >= '0' && c1 <= '9'; b2++)
/*      */       {
/*      */         
/* 1430 */         b1++;
/*      */       }
/*      */     }
/*      */     
/* 1434 */     return str.substring(0, b1);
/*      */   }
/*      */   
/*      */   private String b(k paramk) {
/* 1438 */     String str = a(paramk);
/* 1439 */     return d(paramk).substring(str.length());
/*      */   }
/*      */   
/*      */   private static String a(float paramFloat) {
/* 1443 */     return (paramFloat == -1.0F) ? "-" : "";
/*      */   }
/*      */   private j d(boolean paramBoolean) {
/*      */     j j4;
/*      */     String str3;
/*      */     j j3;
/*      */     String str2;
/*      */     j j2;
/*      */     String str1;
/*      */     j j1;
/*      */     byte b;
/* 1454 */     float f = 1.0F;
/*      */     k k1;
/* 1456 */     if ((k1 = n()) == k.j || k1 == k.S) {
/* 1457 */       f = f();
/* 1458 */       k1 = n();
/*      */     } 
/*      */     
/* 1461 */     switch (k1.a()) {
/*      */       case 34:
/*      */       case 35:
/*      */       case 36:
/* 1465 */         throw new b("Unsupported CSS unit " + b(k1), p());
/*      */ 
/*      */ 
/*      */       
/*      */       case 38:
/* 1470 */         j4 = new j((short)1, f * Float.parseFloat(d(k1)), a(f) + d(k1));
/* 1471 */         m();
/* 1472 */         k();
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
/* 1604 */         return j4;case 33: str3 = b(k1); b = 0; if ("deg".equals(str3)) { b = 11; } else if ("rad".equals(str3)) { b = 12; } else if ("grad".equals(str3)) { b = 13; }  j3 = new j(b, f * Float.parseFloat(a(k1)), a(f) + d(k1)); m(); k(); return j3;case 37: j3 = new j((short)2, f * Float.parseFloat(a(k1)), a(f) + d(k1)); m(); k(); return j3;case 25: j3 = new j((short)3, f * Float.parseFloat(a(k1)), a(f) + d(k1)); m(); k(); return j3;case 26: j3 = new j((short)4, f * Float.parseFloat(a(k1)), a(f) + d(k1)); m(); k(); return j3;case 27: j3 = new j((short)5, f * Float.parseFloat(a(k1)), a(f) + d(k1)); m(); k(); return j3;case 28: j3 = new j((short)6, f * Float.parseFloat(a(k1)), a(f) + d(k1)); m(); k(); return j3;case 29: j3 = new j((short)7, f * Float.parseFloat(a(k1)), a(f) + d(k1)); m(); k(); return j3;case 30: j3 = new j((short)8, f * Float.parseFloat(a(k1)), a(f) + d(k1)); m(); k(); return j3;case 31: j3 = new j((short)9, f * Float.parseFloat(a(k1)), a(f) + d(k1)); m(); k(); return j3;case 32: j3 = new j((short)10, f * Float.parseFloat(a(k1)), a(f) + d(k1)); m(); k(); return j3;case 13: str2 = d(k1); j2 = new j((short)19, str2, o()); m(); k(); return j2;case 15: str1 = a(k1, j2); j1 = new j((short)21, str1, str1); m(); k(); return j1;case 39: j1 = new j((short)20, d(k1), o()); m(); k(); return j1;case 16: j1 = j(); return j1;case 40: j1 = i(); return j1;
/*      */     } 
/*      */     throw new b(k1, new k[] { 
/*      */           k.L, k.K, k.A, k.y, k.z, k.F, k.C, k.B, k.D, k.E, 
/*      */           k.G, k.H, k.I, k.m, k.o, k.M, k.p, k.N }, p());
/*      */   }
/*      */   
/*      */   private j i() {
/*      */     j j;
/*      */     k k1;
/* 1614 */     if ((k1 = m()) == k.N) {
/* 1615 */       String str = d(k1);
/* 1616 */       k();
/* 1617 */       List list = c(false);
/*      */       
/* 1619 */       if ((k1 = m()) != k.T) {
/* 1620 */         c(k1);
/* 1621 */         throw new b(k1, k.T, p());
/*      */       } 
/*      */       
/* 1624 */       if (str.equals("rgb(")) {
/* 1625 */         j = new j(b(list));
/* 1626 */       } else if (str.equals("cmyk(")) {
/* 1627 */         if (!q()) {
/* 1628 */           throw new b("The current output device does not support CMYK colors", 
/* 1629 */               p());
/*      */         }
/*      */         
/* 1632 */         j = new j(a(list));
/*      */       } else {
/* 1634 */         j = new j(new e(str.substring(0, str.length() - 1), list));
/*      */       } 
/*      */       
/* 1637 */       k();
/*      */     } else {
/* 1639 */       c((k)j);
/* 1640 */       throw new b(j, k.N, p());
/*      */     } 
/*      */     
/* 1643 */     return j;
/*      */   }
/*      */   
/*      */   private f a(List paramList) {
/* 1647 */     if (paramList.size() != 4) {
/* 1648 */       throw new b("The cmyk() function must have exactly four parameters", 
/*      */           
/* 1650 */           p());
/*      */     }
/*      */     
/* 1653 */     float[] arrayOfFloat = new float[4];
/*      */     
/* 1655 */     for (byte b = 0; b < paramList.size(); b++) {
/* 1656 */       arrayOfFloat[b] = a((j)paramList.get(b), b + 1);
/*      */     }
/*      */     
/* 1659 */     return new f(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3]);
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
/*      */   private float a(j paramj, int paramInt) {
/*      */     // Byte code:
/*      */     //   0: aload_1
/*      */     //   1: invokevirtual a : ()S
/*      */     //   4: dup
/*      */     //   5: istore_3
/*      */     //   6: iconst_1
/*      */     //   7: if_icmpne -> 18
/*      */     //   10: aload_1
/*      */     //   11: invokevirtual f : ()F
/*      */     //   14: fstore_1
/*      */     //   15: goto -> 67
/*      */     //   18: iload_3
/*      */     //   19: iconst_2
/*      */     //   20: if_icmpne -> 34
/*      */     //   23: aload_1
/*      */     //   24: invokevirtual f : ()F
/*      */     //   27: ldc 100.0
/*      */     //   29: fdiv
/*      */     //   30: fstore_1
/*      */     //   31: goto -> 67
/*      */     //   34: new com/d/c/d/b
/*      */     //   37: dup
/*      */     //   38: new java/lang/StringBuilder
/*      */     //   41: dup
/*      */     //   42: ldc 'Parameter '
/*      */     //   44: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   47: iload_2
/*      */     //   48: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*      */     //   51: ldc ' to the cmyk() function is not a number or a percentage'
/*      */     //   53: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   56: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   59: aload_0
/*      */     //   60: invokespecial p : ()I
/*      */     //   63: invokespecial <init> : (Ljava/lang/String;I)V
/*      */     //   66: athrow
/*      */     //   67: fload_1
/*      */     //   68: fconst_0
/*      */     //   69: fcmpg
/*      */     //   70: iflt -> 79
/*      */     //   73: fload_1
/*      */     //   74: fconst_1
/*      */     //   75: fcmpl
/*      */     //   76: ifle -> 112
/*      */     //   79: new com/d/c/d/b
/*      */     //   82: dup
/*      */     //   83: new java/lang/StringBuilder
/*      */     //   86: dup
/*      */     //   87: ldc 'Parameter '
/*      */     //   89: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   92: iload_2
/*      */     //   93: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*      */     //   96: ldc ' to the cmyk() function must be between zero and one'
/*      */     //   98: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   101: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   104: aload_0
/*      */     //   105: invokespecial p : ()I
/*      */     //   108: invokespecial <init> : (Ljava/lang/String;I)V
/*      */     //   111: athrow
/*      */     //   112: fload_1
/*      */     //   113: freturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #1664	-> 0
/*      */     //   #1666	-> 5
/*      */     //   #1667	-> 10
/*      */     //   #1668	-> 18
/*      */     //   #1669	-> 23
/*      */     //   #1671	-> 34
/*      */     //   #1673	-> 60
/*      */     //   #1676	-> 67
/*      */     //   #1677	-> 79
/*      */     //   #1678	-> 105
/*      */     //   #1681	-> 112
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
/*      */   private h b(List<j> paramList) {
/* 1685 */     if (paramList.size() != 3) {
/* 1686 */       throw new b("The rgb() function must have exactly three parameters", 
/*      */           
/* 1688 */           p());
/*      */     }
/*      */     
/* 1691 */     int j = 0;
/* 1692 */     int m = 0;
/* 1693 */     int n = 0;
/* 1694 */     for (byte b = 0; b < paramList.size(); b++) {
/*      */       j j1;
/*      */       short s;
/* 1697 */       if ((s = (j1 = paramList.get(b)).a()) != 2 && s != 1)
/*      */       {
/* 1699 */         throw new b("Parameter " + (b + 1) + " to the rgb() function is not a number or percentage", 
/*      */             
/* 1701 */             p());
/*      */       }
/*      */       
/* 1704 */       float f = j1.f();
/* 1705 */       if (s == 2) {
/* 1706 */         f = f / 100.0F * 255.0F;
/*      */       }
/* 1708 */       if (f < 0.0F) {
/* 1709 */         f = 0.0F;
/* 1710 */       } else if (f > 255.0F) {
/* 1711 */         f = 255.0F;
/*      */       } 
/*      */       
/* 1714 */       switch (b) {
/*      */         case 0:
/* 1716 */           j = (int)f;
/*      */           break;
/*      */         case 1:
/* 1719 */           m = (int)f;
/*      */           break;
/*      */         case 2:
/* 1722 */           n = (int)f;
/*      */           break;
/*      */       } 
/*      */     
/*      */     } 
/* 1727 */     return new h(j, m, n);
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
/*      */   private j j() {
/*      */     j j;
/*      */     k k1;
/* 1742 */     if ((k1 = m()) == k.p) {
/*      */       h h; String str;
/* 1744 */       if (((str = d(k1)).length() != 3 && str.length() != 6) || !a(str)) {
/* 1745 */         c(k1);
/* 1746 */         throw new b("#" + str + " is not a valid color definition", p());
/*      */       } 
/*      */       
/* 1749 */       if (str.length() == 3) {
/*      */ 
/*      */ 
/*      */         
/* 1753 */         h = new h(a(str.charAt(0), str.charAt(0)), a(str.charAt(1), str.charAt(1)), a(str.charAt(2), str.charAt(2)));
/*      */       
/*      */       }
/*      */       else {
/*      */         
/* 1758 */         h = new h(a(str.charAt(0), str.charAt(1)), a(str.charAt(2), str.charAt(3)), a(str.charAt(4), str.charAt(5)));
/*      */       } 
/* 1760 */       j = new j(h);
/* 1761 */       k();
/*      */     } else {
/* 1763 */       c((k)j);
/* 1764 */       throw new b(j, k.p, p());
/*      */     } 
/*      */     
/* 1767 */     return j;
/*      */   }
/*      */   
/*      */   private static boolean a(String paramString) {
/* 1771 */     for (byte b = 0; b < paramString.length(); b++) {
/* 1772 */       if (!b(paramString.charAt(b))) {
/* 1773 */         return false;
/*      */       }
/*      */     } 
/* 1776 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private int a(char paramChar1, char paramChar2) {
/*      */     int j;
/* 1783 */     return j = (j = (j = a(paramChar1)) << 4) | a(paramChar2);
/*      */   }
/*      */   
/*      */   private static int a(char paramChar) {
/* 1787 */     if (paramChar >= '0' && paramChar <= '9')
/* 1788 */       return paramChar - 48; 
/* 1789 */     if (paramChar >= 'a' && paramChar <= 'f') {
/* 1790 */       return paramChar - 97 + 10;
/*      */     }
/* 1792 */     return paramChar - 65 + 10;
/*      */   }
/*      */   private void k() {
/*      */     k k1;
/*      */     do {
/*      */     
/* 1798 */     } while ((k1 = m()) == k.a);
/*      */ 
/*      */     
/* 1801 */     c(k1);
/*      */   }
/*      */   
/*      */   private void l() {
/*      */     k k1;
/*      */     do {
/*      */     
/* 1808 */     } while ((k1 = m()) == k.a || k1 == k.b || k1 == k.c);
/*      */ 
/*      */ 
/*      */     
/* 1812 */     c(k1);
/*      */   }
/*      */   
/*      */   private k m() {
/* 1816 */     if (this.c != null) {
/* 1817 */       k k1 = this.c;
/* 1818 */       this.c = null;
/* 1819 */       return k1;
/*      */     } 
/* 1821 */     return this.d.d();
/*      */   }
/*      */ 
/*      */   
/*      */   private void c(k paramk) {
/* 1826 */     if (this.c != null) {
/* 1827 */       throw new RuntimeException("saved must be null");
/*      */     }
/* 1829 */     this.c = paramk;
/*      */   }
/*      */   
/*      */   private k n() {
/* 1833 */     k k1 = m();
/* 1834 */     c(k1);
/* 1835 */     return k1;
/*      */   }
/*      */   
/*      */   private void a(b paramb, String paramString, boolean paramBoolean) {
/* 1839 */     if (!paramb.b()) {
/* 1840 */       paramString = paramb.getMessage() + " Skipping " + paramString + ".";
/* 1841 */       this.e.a(this.f, paramString);
/*      */     } 
/* 1843 */     paramb.a(true);
/* 1844 */     if (paramb.a() && paramBoolean) {
/* 1845 */       throw paramb;
/*      */     }
/*      */   }
/*      */   
/*      */   private void a(boolean paramBoolean1, boolean paramBoolean2) {
/* 1850 */     byte b = 0;
/* 1851 */     boolean bool = false;
/*      */     
/*      */     while (true) {
/*      */       k k1;
/* 1855 */       if ((k1 = m()) == k.aa) {
/*      */         return;
/*      */       }
/* 1858 */       switch (k1.a()) {
/*      */         case 9:
/* 1860 */           bool = true;
/* 1861 */           b++;
/*      */         
/*      */         case 42:
/* 1864 */           if (b == 0) {
/* 1865 */             if (paramBoolean2) {
/* 1866 */               c(k1); break;
/*      */             } 
/*      */             continue;
/*      */           } 
/* 1870 */           b--;
/* 1871 */           if (b == 0) {
/*      */             break;
/*      */           }
/*      */ 
/*      */         
/*      */         case 43:
/* 1877 */           if (b != 0 || (paramBoolean1 && !bool)) {
/*      */             continue;
/*      */           }
/*      */           break;
/*      */       } 
/*      */     } 
/* 1883 */     k();
/*      */   }
/*      */   
/*      */   private void a(Reader paramReader) {
/* 1887 */     this.c = null;
/* 1888 */     this.g.clear();
/* 1889 */     this.d.a(paramReader);
/* 1890 */     this.d.a(0);
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
/*      */   private String o() {
/* 1902 */     return this.d.b();
/*      */   }
/*      */   
/*      */   private String d(k paramk) {
/* 1906 */     return a(paramk, false); } private String a(k paramk, boolean paramBoolean) { char[] arrayOfChar;
/*      */     String str1;
/*      */     int j;
/*      */     String str2;
/*      */     byte b;
/*      */     int m;
/* 1912 */     switch (paramk.a()) {
/*      */       case 13:
/* 1914 */         m = this.d.c();
/* 1915 */         return a(this.d.b().toCharArray(), 1, m - 1);
/*      */       case 16:
/* 1917 */         m = this.d.c();
/* 1918 */         return a(this.d.b().toCharArray(), 1, m);
/*      */       case 39:
/* 1920 */         arrayOfChar = this.d.b().toCharArray();
/* 1921 */         b = 4;
/* 1922 */         while (arrayOfChar[b] == '\t' || arrayOfChar[b] == '\r' || arrayOfChar[b] == '\n' || arrayOfChar[b] == '\f')
/*      */         {
/* 1924 */           b++;
/*      */         }
/* 1926 */         if (arrayOfChar[b] == '\'' || arrayOfChar[b] == '"') {
/* 1927 */           b++;
/*      */         }
/* 1929 */         j = arrayOfChar.length - 2;
/* 1930 */         while (arrayOfChar[j] == '\t' || arrayOfChar[j] == '\r' || arrayOfChar[j] == '\n' || arrayOfChar[j] == '\f')
/*      */         {
/* 1932 */           j--;
/*      */         }
/* 1934 */         if (arrayOfChar[j] == '\'' || arrayOfChar[j] == '"') {
/* 1935 */           j--;
/*      */         }
/*      */         
/* 1938 */         str1 = a(arrayOfChar, b, j + 1);
/*      */ 
/*      */         
/* 1941 */         if ((str2 = i.a().a().n().a(this.f, str1)) == null) {
/* 1942 */           l.e(Level.INFO, "URI resolver rejected resolving URI at (" + str1 + ") in CSS stylehseet");
/*      */         }
/*      */         
/* 1945 */         return (str2 == null) ? "" : str2;
/*      */       case 15:
/*      */       case 23:
/*      */       case 40:
/* 1949 */         b = 0;
/* 1950 */         m = this.d.c();
/* 1951 */         if (str1.a() == 23) {
/* 1952 */           b++;
/*      */         }
/* 1954 */         str1 = a(this.d.b().toCharArray(), b, m);
/* 1955 */         if (str2 == null) {
/* 1956 */           str1 = str1.toLowerCase();
/*      */         }
/* 1958 */         return str1;
/*      */     } 
/* 1960 */     return this.d.b(); }
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
/*      */   private int p() {
/* 1973 */     return this.d.a();
/*      */   }
/*      */   
/*      */   private static boolean b(char paramChar) {
/* 1977 */     return ((paramChar >= '0' && paramChar <= '9') || (paramChar >= 'A' && paramChar <= 'F') || (paramChar >= 'a' && paramChar <= 'f'));
/*      */   }
/*      */   
/*      */   private static String a(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 1981 */     StringBuilder stringBuilder = new StringBuilder(paramArrayOfchar.length + 10);
/*      */     
/* 1983 */     for (paramInt1 = paramInt1; paramInt1 < paramInt2; paramInt1++) {
/*      */       int j;
/*      */       
/* 1986 */       if ((j = paramArrayOfchar[paramInt1]) == '\\')
/*      */       
/* 1988 */       { if (paramInt1 < paramInt2 - 2 && paramArrayOfchar[paramInt1 + 1] == '\r' && paramArrayOfchar[paramInt1 + 2] == '\n') {
/* 1989 */           paramInt1 += 2;
/*      */         
/*      */         }
/* 1992 */         else if (paramInt1 + 1 < paramArrayOfchar.length && (paramArrayOfchar[paramInt1 + 1] == '\n' || paramArrayOfchar[paramInt1 + 1] == '\r' || paramArrayOfchar[paramInt1 + 1] == '\f')) {
/* 1993 */           paramInt1++;
/*      */         }
/* 1995 */         else if (paramInt1 + 1 >= paramArrayOfchar.length) {
/*      */           
/* 1997 */           stringBuilder.append(j);
/*      */         }
/* 1999 */         else if (b(paramArrayOfchar[paramInt1 + 1])) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2005 */           j = ++paramInt1;
/* 2006 */           while (paramInt1 < paramInt2 && b(paramArrayOfchar[paramInt1]) && paramInt1 - j < 6) {
/* 2007 */             paramInt1++;
/*      */           }
/*      */ 
/*      */           
/* 2011 */           if ((j = Integer.parseInt(new String(paramArrayOfchar, j, paramInt1 - j), 16)) < 65535) {
/* 2012 */             stringBuilder.append((char)j);
/*      */           }
/*      */           
/* 2015 */           paramInt1--;
/*      */           
/* 2017 */           if (paramInt1 < paramInt2 - 2 && paramArrayOfchar[paramInt1 + 1] == '\r' && paramArrayOfchar[paramInt1 + 2] == '\n') {
/* 2018 */             paramInt1 += 2;
/* 2019 */           } else if (paramInt1 < paramInt2 - 1 && (paramArrayOfchar[paramInt1 + 1] == ' ' || paramArrayOfchar[paramInt1 + 1] == '\t' || paramArrayOfchar[paramInt1 + 1] == '\n' || paramArrayOfchar[paramInt1 + 1] == '\r' || paramArrayOfchar[paramInt1 + 1] == '\f')) {
/*      */ 
/*      */ 
/*      */             
/* 2023 */             paramInt1++;
/*      */           } 
/*      */         }  }
/* 2026 */       else { stringBuilder.append(j); }
/*      */     
/*      */     } 
/*      */     
/* 2030 */     return stringBuilder.toString();
/*      */   }
/*      */   
/*      */   private boolean q() {
/* 2034 */     return this.h;
/*      */   }
/*      */   
/*      */   public final void a(boolean paramBoolean) {
/* 2038 */     this.h = paramBoolean;
/*      */   }
/*      */   
/*      */   static class a {
/*      */     private final String a;
/*      */     private final String b;
/*      */     
/*      */     public a(String param1String1, String param1String2) {
/* 2046 */       this.a = param1String1;
/* 2047 */       this.b = param1String2;
/*      */     }
/*      */     
/*      */     public final String a() {
/* 2051 */       return this.a;
/*      */     }
/*      */     
/*      */     public final String b() {
/* 2055 */       return this.b;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\d\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */