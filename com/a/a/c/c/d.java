/*      */ package com.a.a.c.c;
/*      */ 
/*      */ import com.a.a.b.l;
/*      */ import com.a.a.b.o;
/*      */ import com.a.a.c.b;
/*      */ import com.a.a.c.b.b;
/*      */ import com.a.a.c.c;
/*      */ import com.a.a.c.c.a.b;
/*      */ import com.a.a.c.c.a.c;
/*      */ import com.a.a.c.c.a.g;
/*      */ import com.a.a.c.c.a.s;
/*      */ import com.a.a.c.c.a.v;
/*      */ import com.a.a.c.c.a.y;
/*      */ import com.a.a.c.c.a.z;
/*      */ import com.a.a.c.g;
/*      */ import com.a.a.c.i;
/*      */ import com.a.a.c.j;
/*      */ import com.a.a.c.k;
/*      */ import com.a.a.c.m.ac;
/*      */ import com.a.a.c.m.i;
/*      */ import com.a.a.c.m.n;
/*      */ import com.a.a.c.m.r;
/*      */ import java.io.Serializable;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
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
/*      */ public class d
/*      */   extends f
/*      */   implements Serializable
/*      */ {
/*      */   private transient Exception t;
/*      */   private volatile transient r u;
/*      */   
/*      */   public d(g paramg, b paramb, c paramc, Map<String, v> paramMap, HashSet<String> paramHashSet, boolean paramBoolean1, Set<String> paramSet, boolean paramBoolean2) {
/*   73 */     super(paramg, paramb, paramc, paramMap, paramHashSet, paramBoolean1, paramSet, paramBoolean2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected d(f paramf) {
/*   82 */     super(paramf, paramf.m);
/*      */   }
/*      */   
/*      */   private d(f paramf, boolean paramBoolean) {
/*   86 */     super(paramf, paramBoolean);
/*      */   }
/*      */   
/*      */   protected d(f paramf, r paramr) {
/*   90 */     super(paramf, paramr);
/*      */   }
/*      */   
/*      */   private d(f paramf, s params) {
/*   94 */     super(paramf, params);
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
/*      */   private d(f paramf, Set<String> paramSet1, Set<String> paramSet2) {
/*  109 */     super(paramf, paramSet1, paramSet2);
/*      */   }
/*      */   
/*      */   private d(f paramf, c paramc) {
/*  113 */     super(paramf, paramc);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public k<Object> a(r paramr) {
/*  121 */     if (getClass() != d.class) {
/*  122 */       return (k<Object>)this;
/*      */     }
/*      */ 
/*      */     
/*  126 */     if (this.u == paramr) {
/*  127 */       return (k<Object>)this;
/*      */     }
/*  129 */     this.u = paramr;
/*      */     
/*  131 */     try { return (k<Object>)new d(this, paramr); }
/*  132 */     finally { this.u = null; }
/*      */   
/*      */   }
/*      */   
/*      */   private d b(s params) {
/*  137 */     return new d(this, params);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private d b(Set<String> paramSet1, Set<String> paramSet2) {
/*  143 */     return new d(this, paramSet1, paramSet2);
/*      */   }
/*      */ 
/*      */   
/*      */   public final f a(boolean paramBoolean) {
/*  148 */     return new d(this, paramBoolean);
/*      */   }
/*      */ 
/*      */   
/*      */   public final f a(c paramc) {
/*  153 */     return new d(this, paramc);
/*      */   }
/*      */ 
/*      */   
/*      */   protected final f g() {
/*  158 */     v[] arrayOfV = this.h.d();
/*  159 */     return (f)new b(this, arrayOfV);
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
/*      */   public final Object a(l paraml, g paramg) {
/*  175 */     if (paraml.q()) {
/*  176 */       if (this.g) {
/*  177 */         paraml.g(); return v(paraml, paramg);
/*      */       } 
/*      */ 
/*      */       
/*  181 */       paraml.g();
/*  182 */       if (this.q != null) {
/*  183 */         return e(paraml, paramg);
/*      */       }
/*  185 */       return b(paraml, paramg);
/*      */     } 
/*  187 */     return a(paraml, paramg, paraml.k());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Object a(l paraml, g paramg, o paramo) {
/*  194 */     if (paramo != null) {
/*  195 */       switch (e.a[paramo.ordinal()]) {
/*      */         case 1:
/*  197 */           return i(paraml, paramg);
/*      */         case 2:
/*  199 */           return h(paraml, paramg);
/*      */         case 3:
/*  201 */           return j(paraml, paramg);
/*      */         case 4:
/*  203 */           return l(paraml, paramg);
/*      */         case 5:
/*      */         case 6:
/*  206 */           return k(paraml, paramg);
/*      */         case 7:
/*  208 */           return w(paraml, paramg);
/*      */         
/*      */         case 8:
/*  211 */           return d(paraml, paramg);
/*      */         case 9:
/*      */         case 10:
/*  214 */           if (this.g) {
/*  215 */             return v(paraml, paramg);
/*      */           }
/*  217 */           if (this.q != null) {
/*  218 */             return e(paraml, paramg);
/*      */           }
/*  220 */           return b(paraml, paramg);
/*      */       } 
/*      */     
/*      */     }
/*  224 */     return paramg.a(e(paramg), paraml);
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
/*      */   public final Object a(l paraml, g paramg, Object paramObject) {
/*      */     String str;
/*  241 */     paraml.a(paramObject);
/*  242 */     if (this.i != null) {
/*  243 */       a(paramg, paramObject);
/*      */     }
/*  245 */     if (this.o != null) {
/*  246 */       return b(paraml, paramg, paramObject);
/*      */     }
/*  248 */     if (this.p != null) {
/*  249 */       return c(paraml, paramg, paramObject);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  254 */     if (paraml.q()) {
/*      */       
/*  256 */       if ((str = paraml.h()) == null) {
/*  257 */         return paramObject;
/*      */       }
/*      */     }
/*  260 */     else if (paraml.c(5)) {
/*  261 */       str = paraml.v();
/*      */     } else {
/*  263 */       return paramObject;
/*      */     } 
/*      */     Class<?> clazz;
/*  266 */     if (this.n && (
/*      */       
/*  268 */       clazz = paramg.d()) != null) {
/*  269 */       return a(paraml, paramg, paramObject, clazz);
/*      */     }
/*      */     
/*      */     while (true) {
/*  273 */       paraml.g();
/*      */       
/*      */       v v;
/*  276 */       if ((v = this.h.a(str)) != null) {
/*      */         try {
/*  278 */           v.a(paraml, paramg, paramObject);
/*  279 */         } catch (Exception exception) {
/*  280 */           a(exception, paramObject, str, paramg);
/*      */         } 
/*      */       } else {
/*      */         
/*  284 */         a(paraml, paramg, paramObject, str);
/*  285 */       }  if ((str = paraml.h()) == null) {
/*  286 */         return paramObject;
/*      */       }
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
/*      */ 
/*      */ 
/*      */   
/*      */   private final Object v(l paraml, g paramg) {
/*  303 */     Object object = this.b.a(paramg);
/*      */     
/*  305 */     paraml.a(object);
/*  306 */     if (paraml.c(5)) {
/*  307 */       String str = paraml.v();
/*      */       do {
/*  309 */         paraml.g();
/*      */         
/*      */         v v;
/*  312 */         if ((v = this.h.a(str)) != null)
/*      */         { try {
/*  314 */             v.a(paraml, paramg, object);
/*  315 */           } catch (Exception exception) {
/*  316 */             a(exception, object, str, paramg);
/*      */           }  }
/*      */         else
/*      */         
/*  320 */         { a(paraml, paramg, object, str); } 
/*  321 */       } while ((str = paraml.h()) != null);
/*      */     } 
/*  323 */     return object;
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
/*      */   public Object b(l paraml, g paramg) {
/*  339 */     if (this.q != null && this.q.c() && 
/*  340 */       paraml.c(5) && this.q
/*  341 */       .a(paraml.v(), paraml)) {
/*  342 */       return f(paraml, paramg);
/*      */     }
/*      */     
/*  345 */     if (this.f) {
/*  346 */       if (this.o != null) {
/*  347 */         return x(paraml, paramg);
/*      */       }
/*  349 */       if (this.p != null) {
/*  350 */         return z(paraml, paramg);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       Object object;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  365 */       return object = g(paraml, paramg);
/*      */     } 
/*  367 */     Object object1 = this.b.a(paramg);
/*      */     
/*  369 */     paraml.a(object1); Object object2;
/*  370 */     if (paraml.S() && (
/*      */       
/*  372 */       object2 = paraml.U()) != null) {
/*  373 */       a(paraml, paramg, object1, object2);
/*      */     }
/*      */     
/*  376 */     if (this.i != null) {
/*  377 */       a(paramg, object1);
/*      */     }
/*  379 */     if (this.n && (
/*      */       
/*  381 */       object2 = paramg.d()) != null) {
/*  382 */       return a(paraml, paramg, object1, (Class<?>)object2);
/*      */     }
/*      */     
/*  385 */     if (paraml.c(5)) {
/*  386 */       object2 = paraml.v();
/*      */       do {
/*  388 */         paraml.g();
/*      */         v v;
/*  390 */         if ((v = this.h.a((String)object2)) != null)
/*      */         { try {
/*  392 */             v.a(paraml, paramg, object1);
/*  393 */           } catch (Exception exception) {
/*  394 */             a(exception, object1, (String)object2, paramg);
/*      */           }  }
/*      */         else
/*      */         
/*  398 */         { a(paraml, paramg, object1, (String)object2); } 
/*  399 */       } while ((object2 = paraml.h()) != null);
/*      */     } 
/*  401 */     return object1;
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
/*      */   protected final Object c(l paraml, g paramg) {
/*      */     v v;
/*  417 */     y y = (v = this.e).a(paraml, paramg, this.q);
/*  418 */     ac ac = null;
/*  419 */     Class<?> clazz = this.n ? paramg.d() : null;
/*      */     
/*  421 */     o o = paraml.k();
/*  422 */     ArrayList<a> arrayList = null;
/*  423 */     for (; o == o.f; o1 = paraml.g()) {
/*  424 */       o o1; String str = paraml.v();
/*  425 */       paraml.g();
/*  426 */       v v1 = v.a(str);
/*      */       
/*  428 */       if (!y.a(str) || v1 != null)
/*      */       {
/*      */ 
/*      */         
/*  432 */         if (v1 != null) {
/*      */ 
/*      */           
/*  435 */           if (clazz != null && !v1.a(clazz)) {
/*  436 */             paraml.j();
/*      */           } else {
/*      */             
/*  439 */             Object object = a(paraml, paramg, v1);
/*  440 */             if (y.a(v1, object)) {
/*  441 */               Object object1; paraml.g();
/*      */               
/*      */               try {
/*  444 */                 object1 = v.a(paramg, y);
/*  445 */               } catch (Exception exception) {
/*  446 */                 object1 = a(exception, paramg);
/*      */               } 
/*  448 */               if (object1 == null) {
/*  449 */                 return paramg.a(a(), null, 
/*  450 */                     j());
/*      */               }
/*      */               
/*  453 */               paraml.a(object1);
/*      */ 
/*      */               
/*  456 */               if (object1.getClass() != this.a.b()) {
/*  457 */                 return a(paraml, paramg, object1, ac);
/*      */               }
/*  459 */               if (ac != null) {
/*  460 */                 object1 = a(paramg, object1, ac);
/*      */               }
/*      */               
/*  463 */               return a(paraml, paramg, object1);
/*      */             } 
/*      */           } 
/*      */         } else {
/*      */           a a;
/*      */           v v2;
/*  469 */           if ((v2 = this.h.a((String)exception)) != null) {
/*      */             try {
/*  471 */               y.b(v2, a(paraml, paramg, v2));
/*  472 */             } catch (w w) {
/*      */ 
/*      */ 
/*      */               
/*  476 */               a = a(paramg, v2, y, w);
/*      */               
/*  478 */               if (arrayList == null) {
/*  479 */                 arrayList = new ArrayList();
/*      */               }
/*  481 */               arrayList.add(a);
/*      */             
/*      */             }
/*      */           
/*      */           }
/*  486 */           else if (n.a(a, this.k, this.l)) {
/*  487 */             c(paraml, paramg, a(), (String)a);
/*      */ 
/*      */           
/*      */           }
/*  491 */           else if (this.j != null) {
/*      */             try {
/*  493 */               y.a(this.j, (String)a, this.j.a(paraml, paramg));
/*  494 */             } catch (Exception exception1) {
/*  495 */               a(exception1, this.a.b(), (String)a, paramg);
/*      */ 
/*      */             
/*      */             }
/*      */ 
/*      */ 
/*      */           
/*      */           }
/*  503 */           else if (this.m) {
/*      */             
/*  505 */             paraml.j();
/*      */           }
/*      */           else {
/*      */             
/*  509 */             if (ac == null) {
/*  510 */               ac = paramg.a(paraml);
/*      */             }
/*  512 */             ac.a((String)a);
/*  513 */             ac.b(paraml);
/*      */           } 
/*      */         } 
/*      */       }
/*      */     } 
/*      */     try {
/*  519 */       Object object = v.a(paramg, y);
/*  520 */     } catch (Exception exception) {
/*  521 */       a(exception, paramg);
/*  522 */       o = null;
/*      */     } 
/*      */     
/*  525 */     if (this.i != null) {
/*  526 */       a(paramg, o);
/*      */     }
/*      */     
/*  529 */     if (arrayList != null) {
/*  530 */       for (Iterator<a> iterator = arrayList.iterator(); iterator.hasNext();) {
/*  531 */         (a = iterator.next()).a(o);
/*      */       }
/*      */     }
/*  534 */     if (ac != null) {
/*      */       
/*  536 */       if (o.getClass() != this.a.b()) {
/*  537 */         return a((l)null, paramg, o, ac);
/*      */       }
/*      */       
/*  540 */       return a(paramg, o, ac);
/*      */     } 
/*  542 */     return o;
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
/*      */   private static a a(g paramg, v paramv, y paramy, w paramw) {
/*  554 */     a a = new a(paramg, paramw, paramv.c(), paramv);
/*  555 */     paramw.d().a(a);
/*  556 */     return a;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Object a(l paraml, g paramg, v paramv) {
/*      */     try {
/*  564 */       return paramv.a(paraml, paramg);
/*  565 */     } catch (Exception exception) {
/*  566 */       a(exception, this.a.b(), paramv.a(), paramg);
/*      */       
/*  568 */       return null;
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Object w(l paraml, g paramg) {
/*      */     Object object;
/*  586 */     if (paraml.b()) {
/*      */       ac ac;
/*      */       
/*  589 */       (ac = paramg.a(paraml)).j();
/*      */       
/*  591 */       (paraml = ac.c(paraml)).g();
/*      */ 
/*      */       
/*  594 */       object = this.g ? v(paraml, paramg) : b(paraml, paramg);
/*  595 */       paraml.close();
/*  596 */       return object;
/*      */     } 
/*  598 */     return object.a(e((g)object), paraml);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final Object d(l paraml, g paramg) {
/*      */     k<Object> k;
/*  607 */     if ((k = this.d) != null || (k = this.c) != null) {
/*  608 */       Object object = this.b.b(paramg, k
/*  609 */           .a(paraml, paramg));
/*  610 */       if (this.i != null) {
/*  611 */         a(paramg, object);
/*      */       }
/*  613 */       return object;
/*      */     } 
/*  615 */     b b = h(paramg);
/*      */     
/*      */     boolean bool;
/*  618 */     if ((bool = paramg.a(i.q)) || b != b.a) {
/*      */       o o;
/*  620 */       if ((o = paraml.g()) == o.e) {
/*  621 */         switch (e.b[b.ordinal()]) {
/*      */           case 1:
/*  623 */             return c(paramg);
/*      */           case 2:
/*      */           case 3:
/*  626 */             return a(paramg);
/*      */         } 
/*      */         
/*  629 */         return paramg.a(e(paramg), o.d, paraml, null, new Object[0]);
/*      */       } 
/*  631 */       if (bool) {
/*      */ 
/*      */         
/*  634 */         if (o == o.d) {
/*  635 */           j j = e(paramg);
/*  636 */           return paramg.a(j, o.d, paraml, "Cannot deserialize value of type %s from deeply-nested Array: only single wrapper allowed with `%s`", new Object[] {
/*      */                 
/*  638 */                 i.b(j), "DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS"
/*      */               });
/*      */         } 
/*  641 */         Object object = a(paraml, paramg);
/*  642 */         if (paraml.g() != o.e) {
/*  643 */           j(paramg);
/*      */         }
/*  645 */         return object;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  650 */     return paramg.a(e(paramg), paraml);
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
/*      */   private Object a(l paraml, g paramg, Object paramObject, Class<?> paramClass) {
/*  663 */     if (paraml.c(5)) {
/*  664 */       String str = paraml.v();
/*      */       do {
/*  666 */         paraml.g();
/*      */         
/*      */         v v;
/*  669 */         if ((v = this.h.a(str)) != null)
/*  670 */         { if (!v.a(paramClass)) {
/*  671 */             paraml.j();
/*      */           } else {
/*      */             
/*      */             try {
/*  675 */               v.a(paraml, paramg, paramObject);
/*  676 */             } catch (Exception exception) {
/*  677 */               a(exception, paramObject, str, paramg);
/*      */             } 
/*      */           }  }
/*      */         else
/*  681 */         { a(paraml, paramg, paramObject, str); } 
/*  682 */       } while ((str = paraml.h()) != null);
/*      */     } 
/*  684 */     return paramObject;
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
/*      */   private Object x(l paraml, g paramg) {
/*  701 */     if (this.c != null) {
/*  702 */       return this.b.a(paramg, this.c.a(paraml, paramg));
/*      */     }
/*  704 */     if (this.e != null) {
/*  705 */       return y(paraml, paramg);
/*      */     }
/*      */     ac ac;
/*  708 */     (ac = paramg.a(paraml)).i();
/*  709 */     Object object = this.b.a(paramg);
/*      */ 
/*      */     
/*  712 */     paraml.a(object);
/*      */     
/*  714 */     if (this.i != null) {
/*  715 */       a(paramg, object);
/*      */     }
/*  717 */     Class<?> clazz = this.n ? paramg.d() : null;
/*  718 */     String str = paraml.c(5) ? paraml.v() : null;
/*      */     
/*  720 */     for (; str != null; str = paraml.h()) {
/*  721 */       paraml.g();
/*      */       v v;
/*  723 */       if ((v = this.h.a(str)) != null) {
/*  724 */         if (clazz != null && !v.a(clazz)) {
/*  725 */           paraml.j();
/*      */         } else {
/*      */           
/*      */           try {
/*  729 */             v.a(paraml, paramg, object);
/*  730 */           } catch (Exception exception) {
/*  731 */             a(exception, object, str, paramg);
/*      */           }
/*      */         
/*      */         }
/*      */       
/*  736 */       } else if (n.a(str, this.k, this.l)) {
/*  737 */         c(paraml, paramg, object, str);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       }
/*  744 */       else if (this.j == null) {
/*      */         
/*  746 */         ac.a(str);
/*  747 */         ac.b(paraml);
/*      */       }
/*      */       else {
/*      */         
/*  751 */         ac ac1 = paramg.b(paraml);
/*  752 */         ac.a(str);
/*  753 */         ac.a(ac1);
/*      */         try {
/*  755 */           this.j.a(ac1.p(), paramg, object, str);
/*  756 */         } catch (Exception exception) {
/*  757 */           a(exception, object, str, paramg);
/*      */         } 
/*      */       } 
/*  760 */     }  ac.j();
/*  761 */     this.o.a(paramg, object, ac);
/*  762 */     return object;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Object b(l paraml, g paramg, Object paramObject) {
/*      */     o o;
/*  771 */     if ((o = paraml.k()) == o.b) {
/*  772 */       o = paraml.g();
/*      */     }
/*      */     ac ac;
/*  775 */     (ac = paramg.a(paraml)).i();
/*  776 */     Class<?> clazz = this.n ? paramg.d() : null;
/*  777 */     for (; o == o.f; o1 = paraml.g()) {
/*  778 */       o o1; String str = paraml.v();
/*  779 */       v v = this.h.a(str);
/*  780 */       paraml.g();
/*  781 */       if (v != null) {
/*  782 */         if (clazz != null && !v.a(clazz)) {
/*  783 */           paraml.j();
/*      */         } else {
/*      */           
/*      */           try {
/*  787 */             v.a(paraml, paramg, paramObject);
/*  788 */           } catch (Exception exception) {
/*  789 */             a(exception, paramObject, str, paramg);
/*      */           }
/*      */         
/*      */         } 
/*  793 */       } else if (n.a(str, this.k, this.l)) {
/*  794 */         c(paraml, paramg, paramObject, str);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       }
/*  801 */       else if (this.j == null) {
/*      */         
/*  803 */         ac.a(str);
/*  804 */         ac.b(paraml);
/*      */       } else {
/*      */         
/*  807 */         ac ac1 = paramg.b(paraml);
/*  808 */         ac.a(str);
/*  809 */         ac.a(ac1);
/*      */         try {
/*  811 */           this.j.a(ac1.p(), paramg, paramObject, str);
/*  812 */         } catch (Exception exception) {
/*  813 */           a(exception, paramObject, str, paramg);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  818 */     ac.j();
/*  819 */     this.o.a(paramg, paramObject, ac);
/*  820 */     return paramObject;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Object y(l paraml, g paramg) {
/*      */     v v;
/*  832 */     y y = (v = this.e).a(paraml, paramg, this.q);
/*      */     
/*      */     ac ac;
/*  835 */     (ac = paramg.a(paraml)).i();
/*      */     
/*  837 */     Object object = paraml.k();
/*  838 */     for (; object == o.f; o = paraml.g()) {
/*  839 */       o o; String str = paraml.v();
/*  840 */       paraml.g();
/*      */       
/*  842 */       v v1 = v.a(str);
/*      */       
/*  844 */       if (!y.a(str) || v1 != null) {
/*      */         o o1;
/*      */         
/*  847 */         if (v1 != null) {
/*      */           
/*  849 */           if (y.a(v1, 
/*  850 */               a(paraml, paramg, v1))) {
/*  851 */             Object object1; o1 = paraml.g();
/*      */             
/*      */             try {
/*  854 */               object1 = v.a(paramg, y);
/*  855 */             } catch (Exception exception) {
/*  856 */               object1 = a(exception, paramg);
/*      */             } 
/*      */             
/*  859 */             paraml.a(object1);
/*      */             
/*  861 */             while (o1 == o.f) {
/*      */               
/*  863 */               ac.b(paraml);
/*  864 */               o1 = paraml.g();
/*      */             } 
/*      */ 
/*      */             
/*  868 */             if (o1 != o.c)
/*  869 */               paramg.a((k)this, o.c, "Attempted to unwrap '%s' value", new Object[] {
/*      */                     
/*  871 */                     a().getName()
/*      */                   }); 
/*  873 */             ac.j();
/*  874 */             if (object1.getClass() != this.a.b()) {
/*      */ 
/*      */               
/*  877 */               paramg.a((c)v1, "Cannot create polymorphic instances with unwrapped values", new Object[0]);
/*      */               
/*  879 */               return null;
/*      */             } 
/*  881 */             return this.o.a(paramg, object1, ac);
/*      */           } 
/*      */         } else {
/*      */           v v2;
/*      */ 
/*      */           
/*  887 */           if ((v2 = this.h.a((String)o1)) != null) {
/*  888 */             y.b(v2, a(paraml, paramg, v2));
/*      */ 
/*      */           
/*      */           }
/*  892 */           else if (n.a(o1, this.k, this.l)) {
/*  893 */             c(paraml, paramg, a(), (String)o1);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           }
/*  900 */           else if (this.j == null) {
/*      */             
/*  902 */             ac.a((String)o1);
/*  903 */             ac.b(paraml);
/*      */           } else {
/*      */             
/*  906 */             ac ac1 = paramg.b(paraml);
/*  907 */             ac.a((String)o1);
/*  908 */             ac.a(ac1);
/*      */             try {
/*  910 */               y.a(this.j, (String)o1, this.j
/*  911 */                   .a(ac1.p(), paramg));
/*  912 */             } catch (Exception exception) {
/*  913 */               a(exception, this.a.b(), (String)o1, paramg);
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*      */     try {
/*  922 */       object = v.a(paramg, y);
/*  923 */     } catch (Exception exception) {
/*  924 */       a(exception, paramg);
/*  925 */       return null;
/*      */     } 
/*  927 */     return this.o.a(paramg, object, ac);
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
/*      */   private Object z(l paraml, g paramg) {
/*  940 */     if (this.e != null) {
/*  941 */       return A(paraml, paramg);
/*      */     }
/*  943 */     if (this.c != null)
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  949 */       return this.b.a(paramg, this.c
/*  950 */           .a(paraml, paramg));
/*      */     }
/*      */     
/*  953 */     return c(paraml, paramg, this.b.a(paramg));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Object c(l paraml, g paramg, Object paramObject) {
/*  960 */     return a(paraml, paramg, paramObject, this.p
/*  961 */         .a());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Object a(l paraml, g paramg, Object paramObject, g paramg1) {
/*  968 */     Class<?> clazz = this.n ? paramg.d() : null;
/*  969 */     for (o o = paraml.k(); o == o.f; o = paraml.g()) {
/*  970 */       String str = paraml.v();
/*  971 */       o = paraml.g();
/*      */       v v;
/*  973 */       if ((v = this.h.a(str)) != null) {
/*      */         
/*  975 */         if (o.g()) {
/*  976 */           paramg1.a(paraml, paramg, str, paramObject);
/*      */         }
/*  978 */         if (clazz != null && !v.a(clazz)) {
/*  979 */           paraml.j();
/*      */         } else {
/*      */           
/*      */           try {
/*  983 */             v.a(paraml, paramg, paramObject);
/*  984 */           } catch (Exception exception) {
/*  985 */             a(exception, paramObject, str, paramg);
/*      */           }
/*      */         
/*      */         }
/*      */       
/*  990 */       } else if (n.a(str, this.k, this.l)) {
/*  991 */         c(paraml, paramg, paramObject, str);
/*      */ 
/*      */       
/*      */       }
/*  995 */       else if (!paramg1.b(paraml, paramg, str, paramObject)) {
/*      */ 
/*      */ 
/*      */         
/*  999 */         if (this.j != null) {
/*      */           try {
/* 1001 */             this.j.a(paraml, paramg, paramObject, str);
/* 1002 */           } catch (Exception exception) {
/* 1003 */             a(exception, paramObject, str, paramg);
/*      */           }
/*      */         
/*      */         } else {
/*      */           
/* 1008 */           b(paraml, paramg, paramObject, str);
/*      */         } 
/*      */       } 
/* 1011 */     }  return paramg1.a(paraml, paramg, paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Object A(l paraml, g paramg) {
/* 1019 */     g g1 = this.p.a();
/*      */     v v;
/* 1021 */     y y = (v = this.e).a(paraml, paramg, this.q);
/* 1022 */     Class<?> clazz = this.n ? paramg.d() : null;
/*      */     
/* 1024 */     o o = paraml.k();
/* 1025 */     for (; o == o.f; o = paraml.g()) {
/* 1026 */       String str = paraml.v();
/* 1027 */       o = paraml.g();
/*      */       
/* 1029 */       v v1 = v.a(str);
/*      */       
/* 1031 */       if (!y.a(str) || v1 != null)
/*      */       {
/*      */         
/* 1034 */         if (v1 != null) {
/*      */ 
/*      */ 
/*      */           
/* 1038 */           if (!g1.b(paraml, paramg, str, null))
/*      */           {
/*      */ 
/*      */             
/* 1042 */             if (y.a(v1, 
/* 1043 */                 a(paraml, paramg, v1))) {
/* 1044 */               Object object; paraml.g();
/*      */               
/*      */               try {
/* 1047 */                 object = v.a(paramg, y);
/* 1048 */               } catch (Exception exception) {
/* 1049 */                 a(exception, this.a.b(), str, paramg);
/*      */               } 
/*      */               
/* 1052 */               if (object.getClass() != this.a.b())
/*      */               {
/*      */                 
/* 1055 */                 return paramg.a(this.a, String.format("Cannot create polymorphic instances with external type ids (%s -> %s)", new Object[] { this.a, object
/*      */                         
/* 1057 */                         .getClass() }));
/*      */               }
/* 1059 */               return a(paraml, paramg, object, g1);
/*      */             
/*      */             }
/*      */ 
/*      */           
/*      */           }
/*      */         }
/* 1066 */         else if ((v1 = this.h.a(str)) != null) {
/*      */           
/* 1068 */           if (exception.g()) {
/* 1069 */             g1.a(paraml, paramg, str, null);
/*      */           }
/*      */           
/* 1072 */           if (clazz != null && !v1.a(clazz)) {
/* 1073 */             paraml.j();
/*      */           } else {
/* 1075 */             y.b(v1, v1.a(paraml, paramg));
/*      */           
/*      */           }
/*      */         
/*      */         }
/* 1080 */         else if (!g1.b(paraml, paramg, str, null)) {
/*      */ 
/*      */ 
/*      */           
/* 1084 */           if (n.a(str, this.k, this.l)) {
/* 1085 */             c(paraml, paramg, a(), str);
/*      */ 
/*      */           
/*      */           }
/* 1089 */           else if (this.j != null) {
/* 1090 */             y.a(this.j, str, this.j
/* 1091 */                 .a(paraml, paramg));
/*      */           }
/*      */           else {
/*      */             
/* 1095 */             b(paraml, paramg, this.s, str);
/*      */           } 
/*      */         }  } 
/*      */     } 
/*      */     try {
/* 1100 */       return g1.a(paraml, paramg, y, v);
/* 1101 */     } catch (Exception exception) {
/* 1102 */       return a(exception, paramg);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Exception j() {
/* 1113 */     if (this.t == null) {
/* 1114 */       this.t = new NullPointerException("JSON Creator returned null");
/*      */     }
/* 1116 */     return this.t;
/*      */   }
/*      */ 
/*      */   
/*      */   static class a
/*      */     extends z.a
/*      */   {
/*      */     private final g a;
/*      */     
/*      */     private final v b;
/*      */     
/*      */     private Object c;
/*      */ 
/*      */     
/*      */     a(g param1g, w param1w, j param1j, v param1v) {
/* 1131 */       super(param1w, param1j);
/* 1132 */       this.a = param1g;
/* 1133 */       this.b = param1v;
/*      */     }
/*      */     
/*      */     public final void a(Object param1Object) {
/* 1137 */       this.c = param1Object;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final void a(Object param1Object1, Object param1Object2) {
/* 1143 */       if (this.c == null) {
/* 1144 */         this.a.a((c)this.b, "Cannot resolve ObjectId forward reference using property '%s' (of type %s): Bean not yet resolved", new Object[] { this.b
/*      */               
/* 1146 */               .a(), this.b.k().getName() });
/*      */       }
/* 1148 */       this.b.a(this.c, param1Object2);
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */