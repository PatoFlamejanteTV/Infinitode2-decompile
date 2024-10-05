/*     */ package com.a.a.c.c.b;
/*     */ 
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.b.s;
/*     */ import com.a.a.c.b.k;
/*     */ import com.a.a.c.b.o;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.c.k;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.i;
/*     */ import com.a.a.c.i.e;
/*     */ import com.a.a.c.j.e;
/*     */ import com.a.a.c.j.l;
/*     */ import com.a.a.c.j.p;
/*     */ import com.a.a.c.j.r;
/*     */ import com.a.a.c.j.t;
/*     */ import com.a.a.c.k;
/*     */ import com.a.a.c.m;
/*     */ import com.a.a.c.m.y;
/*     */ import java.util.Arrays;
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
/*     */ abstract class f<T extends m>
/*     */   extends ae<T>
/*     */   implements k
/*     */ {
/*     */   protected final Boolean a;
/*     */   private boolean b;
/*     */   private boolean c;
/*     */   
/*     */   public f(Class<T> paramClass, Boolean paramBoolean) {
/* 255 */     super(paramClass);
/* 256 */     this.a = paramBoolean;
/* 257 */     this.b = true;
/* 258 */     this.c = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected f(f<?> paramf, boolean paramBoolean1, boolean paramBoolean2) {
/* 264 */     super(paramf);
/* 265 */     this.a = paramf.a;
/* 266 */     this.b = paramBoolean1;
/* 267 */     this.c = paramBoolean2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object a(l paraml, g paramg, e parame) {
/* 276 */     return parame.d(paraml, paramg);
/*     */   }
/*     */ 
/*     */   
/*     */   public com.a.a.c.l.f b() {
/* 281 */     return com.a.a.c.l.f.e;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean c() {
/* 288 */     return true;
/*     */   }
/*     */   
/*     */   public Boolean a(com.a.a.c.f paramf) {
/* 292 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public k<?> a(g paramg, c paramc) {
/*     */     com.a.a.c.f f1;
/* 303 */     Boolean bool4 = (f1 = paramg.c()).g(com.a.a.c.j.a.class);
/* 304 */     Boolean bool5 = f1.g(r.class);
/* 305 */     Boolean bool2 = f1.g(m.class);
/*     */     
/* 307 */     boolean bool3 = a(bool4, bool2);
/* 308 */     boolean bool1 = a(bool5, bool2);
/*     */     
/* 310 */     if (bool3 != this.b || bool1 != this.c)
/*     */     {
/* 312 */       return a(bool3, bool1);
/*     */     }
/*     */     
/* 315 */     return this;
/*     */   }
/*     */   
/*     */   private static boolean a(Boolean paramBoolean1, Boolean paramBoolean2) {
/* 319 */     if (paramBoolean1 != null) {
/* 320 */       return paramBoolean1.booleanValue();
/*     */     }
/* 322 */     if (paramBoolean2 != null) {
/* 323 */       return paramBoolean2.booleanValue();
/*     */     }
/* 325 */     return true;
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
/*     */   protected abstract k<?> a(boolean paramBoolean1, boolean paramBoolean2);
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
/*     */   private static void a(g paramg, l paraml, String paramString, r paramr, m paramm1, m paramm2) {
/* 358 */     if (paramg.a(i.i))
/*     */     {
/*     */ 
/*     */       
/* 362 */       paramg.a(m.class, "Duplicate field '%s' for `ObjectNode`: not allowed when `DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY` enabled", new Object[] { paramString });
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 367 */     if (paramg.a(s.a)) {
/*     */ 
/*     */       
/* 370 */       if (paramm1.b()) {
/* 371 */         ((com.a.a.c.j.a)paramm1).a(paramm2);
/* 372 */         paramr.b(paramString, paramm1); return;
/*     */       } 
/*     */       com.a.a.c.j.a a;
/* 375 */       (a = paraml.c()).a(paramm1);
/* 376 */       a.a(paramm2);
/* 377 */       paramr.b(paramString, (m)a);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final r a(l paraml, g paramg, l paraml1, a parama) {
/* 395 */     r r = paraml1.d();
/* 396 */     String str = paraml.v();
/* 397 */     for (; str != null; str = paraml.h()) {
/*     */       com.a.a.c.j.f<?> f1; m m1;
/*     */       o o;
/* 400 */       if ((o = paraml.g()) == null) {
/* 401 */         o = o.a;
/*     */       }
/* 403 */       switch (o.a()) {
/*     */         case 1:
/* 405 */           f1 = a(paraml, paramg, paraml1, parama, (com.a.a.c.j.f<?>)paraml1
/* 406 */               .d());
/*     */           break;
/*     */         case 3:
/* 409 */           f1 = a(paraml, paramg, paraml1, parama, (com.a.a.c.j.f<?>)paraml1
/* 410 */               .c());
/*     */           break;
/*     */         default:
/* 413 */           m1 = b(paraml, paramg); break;
/*     */       } 
/*     */       m m2;
/* 416 */       if ((m2 = r.b(str, m1)) != null) {
/* 417 */         a(paramg, paraml1, str, r, m2, m1);
/*     */       }
/*     */     } 
/*     */     
/* 421 */     return r;
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
/*     */   protected final m a(l paraml, g paramg, r paramr, a parama) {
/* 434 */     if (paraml.q()) {
/* 435 */       str = paraml.h();
/*     */     } else {
/* 437 */       if (!paraml.a(o.f)) {
/* 438 */         return (m)a(paraml, paramg);
/*     */       }
/* 440 */       str = paraml.v();
/*     */     } 
/* 442 */     l l1 = paramg.l(); String str;
/* 443 */     for (; str != null; str = paraml.h()) {
/*     */       m m3; o o1; com.a.a.c.j.f<?> f1; t t; m m2; e e; p p; m m1;
/* 445 */       o o2 = paraml.g();
/*     */       
/*     */       m m4;
/*     */       
/* 449 */       if ((m4 = paramr.a(str)) != null) {
/* 450 */         if (m4 instanceof r) {
/*     */ 
/*     */           
/* 453 */           if (o2 == o.b && this.c) {
/*     */             
/* 455 */             if ((m3 = a(paraml, paramg, (r)m4, parama)) != m4) {
/* 456 */               paramr.a(str, m3);
/*     */             }
/*     */             continue;
/*     */           } 
/* 460 */         } else if (m4 instanceof com.a.a.c.j.a) {
/*     */ 
/*     */           
/* 463 */           if (m3 == o.d && this.b) {
/*     */ 
/*     */             
/* 466 */             a(paraml, paramg, l1, parama, (com.a.a.c.j.f<?>)m4);
/*     */             
/*     */             continue;
/*     */           } 
/*     */         } 
/*     */       }
/* 472 */       if (m3 == null) {
/* 473 */         o1 = o.a;
/*     */       }
/*     */       
/* 476 */       switch (o1.a()) {
/*     */         case 1:
/* 478 */           f1 = a(paraml, paramg, l1, parama, (com.a.a.c.j.f<?>)l1
/* 479 */               .d());
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
/* 516 */           paramr.a(str, (m)f1); break;case 3: f1 = a(paraml, paramg, l1, parama, (com.a.a.c.j.f<?>)l1.c()); paramr.a(str, (m)f1); break;case 6: t = l.a(paraml.w()); paramr.a(str, (m)t); break;case 7: m2 = a(paraml, paramg, l1); paramr.a(str, m2); break;case 9: e = l.a(true); paramr.a(str, (m)e); break;case 10: e = l.a(false); paramr.a(str, (m)e); break;case 11: if (paramg.a((k)o.a)) { p = l.a(); } else { break; }  paramr.a(str, (m)p); break;default: m1 = c(paraml, paramg); paramr.a(str, m1); break;
/*     */       }  continue;
/* 518 */     }  return (m)paramr;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final com.a.a.c.j.f<?> a(l paraml, g paramg, l paraml1, a parama, com.a.a.c.j.f<?> paramf) {
/* 527 */     com.a.a.c.j.f<?> f1 = paramf;
/* 528 */     int i = paramg.i() & r;
/*     */     
/*     */     label69: while (true) {
/*     */       com.a.a.c.j.a a1;
/* 532 */       if (f1 instanceof r)
/* 533 */       { r r = (r)f1;
/* 534 */         String str = paraml.h();
/*     */         
/*     */         while (true)
/* 537 */         { if (str != null) {
/*     */             r r1; m m3; t t; m m2; e e; p p; m m1; r r2; com.a.a.c.j.a a2; m m4;
/*     */             o o;
/* 540 */             if ((o = paraml.g()) == null) {
/* 541 */               o = o.a;
/*     */             }
/* 543 */             switch (o.a()) {
/*     */               
/*     */               case 1:
/* 546 */                 r2 = paraml1.d();
/*     */                 
/* 548 */                 if ((m3 = r.b(str, (m)r2)) != null) {
/* 549 */                   a(paramg, paraml1, str, r, m3, (m)r2);
/*     */                 }
/*     */                 
/* 552 */                 parama.a(f1);
/* 553 */                 r1 = r = r2;
/*     */                 break;
/*     */ 
/*     */ 
/*     */               
/*     */               case 3:
/* 559 */                 a2 = paraml1.c();
/*     */                 
/* 561 */                 if ((m3 = r.b(str, (m)a2)) != null) {
/* 562 */                   a(paramg, paraml1, str, r, m3, (m)a2);
/*     */                 }
/*     */                 
/* 565 */                 parama.a((com.a.a.c.j.f)r1);
/* 566 */                 a1 = a2;
/*     */                 break;
/*     */               
/*     */               case 6:
/* 570 */                 t = l.a(paraml.w());
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
/* 595 */                 if ((m4 = r.b(str, (m)t)) != null)
/* 596 */                   a(paramg, paraml1, str, r, m4, (m)t);  break;case 7: m2 = a(paraml, i, paraml1); if ((m4 = r.b(str, m2)) != null) a(paramg, paraml1, str, r, m4, m2);  break;case 8: m2 = b(paraml, paramg, paraml1); if ((m4 = r.b(str, m2)) != null) a(paramg, paraml1, str, r, m4, m2);  break;case 9: e = l.a(true); if ((m4 = r.b(str, (m)e)) != null) a(paramg, paraml1, str, r, m4, (m)e);  break;case 10: e = l.a(false); if ((m4 = r.b(str, (m)e)) != null) a(paramg, paraml1, str, r, m4, (m)e);  break;case 11: if (paramg.a((k)o.a)) { p = l.a(); } else { break; }  if ((m4 = r.b(str, (m)p)) != null) a(paramg, paraml1, str, r, m4, (m)p);  break;default: m1 = c(paraml, paramg); if ((m4 = r.b(str, m1)) != null) a(paramg, paraml1, str, r, m4, m1);
/*     */                 
/*     */                 break;
/*     */             } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             str = paraml.h();
/*     */             continue;
/*     */           } 
/* 651 */           f1 = parama.a(); break; }  } else { com.a.a.c.j.a a2 = (com.a.a.c.j.a)f1; while (true) { r r; o o; if ((o = paraml.g()) == null)
/* 652 */             o = o.a;  switch (o.a()) { case 1: parama.a(f1); r = paraml1.d(); a2.a((m)r); break;case 3: parama.a((com.a.a.c.j.f)r); a1 = paraml1.c(); a2.a((m)a1); break;case 4: continue label69;case 6: a2.a((m)l.a(paraml.w())); continue;case 7: a2.a(a(paraml, i, paraml1)); continue;case 8: a2.a(b(paraml, paramg, paraml1)); continue;case 9: a2.a((m)l.a(true)); continue;case 10: a2.a((m)l.a(false)); continue;case 11: a2.a((m)l.a()); continue; }  a2.a(c(paraml, paramg)); }  }  if (a1 == null) {
/* 653 */         return paramf;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected final m b(l paraml, g paramg) {
/* 660 */     l l1 = paramg.l();
/* 661 */     switch (paraml.l()) {
/*     */       case 2:
/* 663 */         return (m)l1.d();
/*     */       case 6:
/* 665 */         return (m)l.a(paraml.w());
/*     */       case 7:
/* 667 */         return a(paraml, paramg, l1);
/*     */       case 8:
/* 669 */         return b(paraml, paramg, l1);
/*     */       case 9:
/* 671 */         return (m)l.a(true);
/*     */       case 10:
/* 673 */         return (m)l.a(false);
/*     */       case 11:
/* 675 */         return (m)l.a();
/*     */       case 12:
/* 677 */         return e(paraml, paramg);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 682 */     return (m)paramg.a(a(), paraml);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private m c(l paraml, g paramg) {
/* 689 */     switch (paraml.l()) {
/*     */       case 2:
/* 691 */         return (m)paramg.l().d();
/*     */       case 8:
/* 693 */         return b(paraml, paramg, paramg.l());
/*     */       case 12:
/* 695 */         return e(paraml, paramg);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 700 */     return (m)paramg.a(a(), paraml);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static m a(l paraml, int paramInt, l paraml1) {
/* 706 */     if (paramInt != 0) {
/* 707 */       if (i.b.a(paramInt)) {
/* 708 */         return (m)paraml1.a(paraml.I());
/*     */       }
/* 710 */       return (m)l.a(paraml.H());
/*     */     } 
/*     */     l.b b;
/* 713 */     if ((b = paraml.D()) == l.b.a) {
/* 714 */       return (m)l.a(paraml.G());
/*     */     }
/* 716 */     if (b == l.b.b) {
/* 717 */       return (m)l.a(paraml.H());
/*     */     }
/* 719 */     return (m)paraml1.a(paraml.I());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static m a(l paraml, g paramg, l paraml1) {
/*     */     l.b b;
/*     */     int i;
/* 727 */     if (((i = paramg.i()) & r) != 0) {
/* 728 */       if (i.b.a(i)) {
/* 729 */         b = l.b.c;
/* 730 */       } else if (i.c.a(b)) {
/* 731 */         b = l.b.b;
/*     */       } else {
/* 733 */         b = paraml.D();
/*     */       } 
/*     */     } else {
/* 736 */       b = paraml.D();
/*     */     } 
/* 738 */     if (b == l.b.a) {
/* 739 */       return (m)l.a(paraml.G());
/*     */     }
/* 741 */     if (b == l.b.b) {
/* 742 */       return (m)l.a(paraml.H());
/*     */     }
/* 744 */     return (m)paraml1.a(paraml.I());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static m b(l paraml, g paramg, l paraml1) {
/*     */     l.b b;
/* 752 */     if ((b = paraml.D()) == l.b.f) {
/* 753 */       return (m)paraml1.a(paraml.L());
/*     */     }
/* 755 */     if (paramg.a(i.a)) {
/*     */ 
/*     */       
/* 758 */       if (paraml.s()) {
/* 759 */         return (m)l.a(paraml.K());
/*     */       }
/* 761 */       return (m)paraml1.a(paraml.L());
/*     */     } 
/* 763 */     if (b == l.b.d) {
/* 764 */       return (m)l.a(paraml.J());
/*     */     }
/* 766 */     return (m)l.a(paraml.K());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static m e(l paraml, g paramg) {
/* 772 */     paramg.l();
/*     */     
/*     */     Object object;
/* 775 */     if ((object = paraml.N()) == null) {
/* 776 */       return (m)l.a();
/*     */     }
/*     */     Class<?> clazz;
/* 779 */     if ((clazz = object.getClass()) == byte[].class) {
/* 780 */       return (m)l.a((byte[])object);
/*     */     }
/*     */     
/* 783 */     if (object instanceof y) {
/* 784 */       return (m)l.a((y)object);
/*     */     }
/* 786 */     if (object instanceof m)
/*     */     {
/* 788 */       return (m)object;
/*     */     }
/*     */     
/* 791 */     return (m)l.a(object);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final class a
/*     */   {
/*     */     private com.a.a.c.j.f[] a;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private int b;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private int c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void a(com.a.a.c.j.f param1f) {
/* 818 */       if (this.b < this.c) {
/* 819 */         this.a[this.b++] = param1f;
/*     */         return;
/*     */       } 
/* 822 */       if (this.a == null) {
/* 823 */         this.c = 10;
/* 824 */         this.a = new com.a.a.c.j.f[this.c];
/*     */       } else {
/*     */         
/* 827 */         this.c += Math.min(4000, Math.max(20, this.c >> 1));
/* 828 */         this.a = Arrays.<com.a.a.c.j.f>copyOf(this.a, this.c);
/*     */       } 
/* 830 */       this.a[this.b++] = param1f;
/*     */     }
/*     */     
/*     */     public final com.a.a.c.j.f a() {
/* 834 */       if (this.b == 0) {
/* 835 */         return null;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 840 */       return this.a[--this.b];
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\b\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */