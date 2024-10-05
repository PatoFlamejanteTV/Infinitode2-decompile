/*      */ package com.d.e;
/*      */ 
/*      */ import com.d.c.c.e;
/*      */ import com.d.d.l;
/*      */ import com.d.d.s;
/*      */ import com.d.d.t;
/*      */ import com.d.i.a.r;
/*      */ import com.d.i.aa;
/*      */ import com.d.i.f;
/*      */ import com.d.i.u;
/*      */ import com.d.m.l;
/*      */ import java.awt.Dimension;
/*      */ import java.io.StringReader;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.logging.Level;
/*      */ import org.w3c.dom.Document;
/*      */ import org.w3c.dom.Element;
/*      */ import org.w3c.dom.Node;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class a
/*      */ {
/*      */   private aa a;
/*      */   private l b;
/*      */   private Document c;
/*      */   private final com.d.b.c d;
/*      */   private com.d.c.c.c e;
/*      */   private s f;
/*      */   
/*      */   public static void a(v paramv, com.d.i.c paramc, int paramInt) {
/*   52 */     byte b = -1;
/*      */     
/*   54 */     List<?> list = paramc.X();
/*   55 */     if (paramv.r() && !(list instanceof java.util.RandomAccess)) {
/*   56 */       list = new ArrayList(list);
/*      */     }
/*      */     
/*   59 */     paramInt = paramc.as() + paramInt;
/*      */     
/*   61 */     b b1 = null;
/*   62 */     if (paramv.r()) {
/*   63 */       b1 = new b(list.size());
/*      */     }
/*      */     
/*   66 */     int i = -1;
/*   67 */     com.d.i.c c1 = null;
/*   68 */     for (com.d.i.c c2 : list) {
/*      */       
/*   70 */       b++;
/*      */       
/*   72 */       a a1 = null;
/*      */       
/*   74 */       boolean bool = false;
/*   75 */       if (paramv.r()) {
/*      */         
/*   77 */         (a1 = b1.a(b)).a(paramv.k());
/*   78 */         a1.a(paramInt);
/*   79 */         i = paramv.p().k().size();
/*      */         
/*   81 */         c2.e(false);
/*      */         
/*   83 */         if ((c2.a().ad() || c2.a().av()) && paramv
/*   84 */           .H()) {
/*   85 */           bool = true;
/*   86 */           paramv.b(false);
/*      */         } 
/*      */       } 
/*      */       
/*   90 */       a(paramv, paramc, c2, false, paramInt, -1, 
/*      */           
/*   92 */           (a1 == null) ? null : a1.c());
/*      */       
/*   94 */       if (paramv.r()) {
/*      */         boolean bool1;
/*   96 */         if ((bool1 = c2.D()) || bool) {
/*   97 */           paramv.b(bool);
/*   98 */           bool = (c2.a().ad() && c2.u(paramv)) ? true : false;
/*   99 */           boolean bool2 = c2.p(paramv);
/*  100 */           if (bool || bool1 || bool2) {
/*  101 */             paramv.b(a1.c());
/*  102 */             c2.c(paramv);
/*  103 */             a(paramv, paramc, c2, true, paramInt, i, a1
/*  104 */                 .c());
/*      */             
/*  106 */             if (bool && c2.u(paramv) && !bool2) {
/*  107 */               paramv.b(a1.c());
/*  108 */               c2.c(paramv);
/*  109 */               a(paramv, paramc, c2, false, paramInt, i, a1
/*  110 */                   .c());
/*      */             } 
/*      */           } 
/*      */         } 
/*  114 */         paramv.p().c(paramv, (f)c2);
/*      */       } 
/*      */       
/*      */       Dimension dimension;
/*  118 */       if ((dimension = c2.ag()) == null) {
/*  119 */         paramInt = c2.an() + c2.as();
/*      */       
/*      */       }
/*      */       else {
/*      */         
/*  124 */         paramInt = c2.an() - dimension.height + c2.as();
/*      */       } 
/*      */       
/*  127 */       if (paramInt > paramc.as()) {
/*  128 */         paramc.t(paramInt);
/*      */       }
/*      */       
/*  131 */       if (paramv.r()) {
/*  132 */         if (c2.a().ac()) {
/*  133 */           paramc.a(paramv, c2.a().e(com.d.c.a.a.ae));
/*  134 */           paramInt = paramc.as();
/*      */         } 
/*      */         
/*  137 */         if (c1 != null) {
/*  138 */           b1.a(b, c1, c2);
/*      */         }
/*      */ 
/*      */         
/*      */         c c3;
/*      */         
/*  144 */         if ((c3 = a(paramv, paramc, list, b, b1, a1)).a() && (
/*      */           
/*  146 */           paramInt = c3.b()) > paramc.as()) {
/*  147 */           paramc.t(paramInt);
/*      */         }
/*      */       } 
/*      */ 
/*      */       
/*  152 */       c1 = c2;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static c a(v paramv, com.d.i.c paramc, List paramList, int paramInt, b paramb, a parama) {
/*  160 */     c c1 = new c((byte)0);
/*  161 */     if (paramInt > 0) {
/*  162 */       boolean bool = false;
/*  163 */       int j = 0;
/*  164 */       if (paramInt == paramList.size() - 1 && parama.a()) {
/*  165 */         bool = true;
/*  166 */         j = paramInt;
/*  167 */       } else if (paramInt > 0 && (
/*      */         
/*  169 */         parama = paramb.a(paramInt - 1)).a()) {
/*  170 */         bool = true;
/*  171 */         j = paramInt - 1;
/*      */       } 
/*      */       int i;
/*  174 */       if (bool && 
/*      */         
/*  176 */         a(i = paramb.b(j), j, paramv, paramc)) {
/*  177 */         c1.a(true);
/*  178 */         paramc.a(paramv, i, paramInt);
/*  179 */         c1.a(a(paramv, paramList, paramc, paramb, i, paramInt, true));
/*      */         
/*  181 */         if (a(i, j, paramv, paramc)) {
/*  182 */           paramc.a(paramv, i, paramInt);
/*  183 */           c1.a(a(paramv, paramList, paramc, paramb, i, paramInt, false));
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  189 */     return c1;
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean a(int paramInt1, int paramInt2, v paramv, com.d.i.c paramc) {
/*  194 */     for (paramInt1 = paramInt1; paramInt1 < paramInt2; paramInt1++) {
/*  195 */       f f1 = paramc.k(paramInt1);
/*      */ 
/*      */ 
/*      */       
/*  199 */       f f2 = (a(f2 = paramc.k(paramInt1 + 1)) == null) ? f2 : (f)a(f2);
/*  200 */       int i = f1.aa() + f1.as();
/*  201 */       int j = f2.aa() + f2.as();
/*  202 */       if (paramv.p().a(paramv, i, j)) {
/*  203 */         return true;
/*      */       }
/*      */     } 
/*  206 */     return false;
/*      */   }
/*      */   
/*      */   private static u a(f paramf) {
/*  210 */     for (paramf = paramf; paramf.V() > 0; paramf = paramf.k(0)) {
/*  211 */       if (paramf instanceof u) {
/*  212 */         return (u)paramf;
/*      */       }
/*      */     } 
/*  215 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static int a(v paramv, List<f> paramList, com.d.i.c paramc, b paramb, int paramInt1, int paramInt2, boolean paramBoolean) {
/*  221 */     int j = paramb.a(paramInt1).e();
/*      */     
/*  223 */     if (paramBoolean) {
/*  224 */       f f = paramList.get(paramInt1);
/*  225 */       aa aa1 = paramv.p().a(paramv, f);
/*  226 */       j += aa1.a() - f.aa();
/*      */     } 
/*      */ 
/*      */     
/*  230 */     paramc.t(j);
/*      */ 
/*      */     
/*  233 */     for (int i = paramInt1; i <= paramInt2; i++) {
/*  234 */       com.d.i.c c1 = (com.d.i.c)paramList.get(i);
/*      */       
/*  236 */       a a1 = paramb.a(i);
/*      */       
/*  238 */       int k = paramv.p().k().size();
/*      */ 
/*      */ 
/*      */       
/*  242 */       paramv.b(a1.c());
/*  243 */       a1.a(j);
/*  244 */       boolean bool = false;
/*  245 */       if ((c1.a().ad() || c1.a().av()) && paramv
/*  246 */         .H()) {
/*  247 */         bool = true;
/*  248 */         paramv.b(false);
/*      */       } 
/*  250 */       a(paramv, paramc, c1, false, j, -1, a1
/*  251 */           .c());
/*      */       
/*  253 */       if (bool) {
/*  254 */         paramv.b(true);
/*      */         
/*  256 */         bool = (c1.a().ad() && c1.u(paramv)) ? true : false;
/*  257 */         boolean bool1 = c1.D();
/*  258 */         boolean bool2 = c1.p(paramv);
/*  259 */         if (bool || bool1 || bool2) {
/*  260 */           paramv.b(a1.c());
/*  261 */           c1.c(paramv);
/*  262 */           a(paramv, paramc, c1, true, j, k, a1
/*  263 */               .c());
/*      */           
/*  265 */           if (bool && c1.u(paramv) && !bool2) {
/*  266 */             paramv.b(a1.c());
/*  267 */             c1.c(paramv);
/*  268 */             a(paramv, paramc, c1, false, j, k, a1
/*  269 */                 .c());
/*      */           } 
/*      */         } 
/*      */       } 
/*      */       
/*  274 */       paramv.p().c(paramv, (f)c1);
/*      */       
/*      */       Dimension dimension;
/*  277 */       if ((dimension = c1.ag()) == null) {
/*  278 */         j = c1.an() + c1.as();
/*      */       } else {
/*  280 */         j = c1.an() - dimension.height + c1.as();
/*      */       } 
/*      */       
/*  283 */       if (j > paramc.as()) {
/*  284 */         paramc.t(j);
/*      */       }
/*      */       
/*  287 */       if (c1.a().ac()) {
/*  288 */         paramc.a(paramv, c1.a().e(com.d.c.a.a.ae));
/*  289 */         j = paramc.as();
/*      */       } 
/*      */     } 
/*      */     
/*  293 */     return j;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static void a(v paramv, com.d.i.c paramc1, com.d.i.c paramc2, boolean paramBoolean, int paramInt1, int paramInt2, w paramw) {
/*  299 */     a(paramv, paramc1, paramc2, paramBoolean, paramInt1, paramInt2);
/*      */     i i;
/*  301 */     if ((i = paramc2.o(paramv)) != null) {
/*  302 */       paramv.a(i);
/*  303 */       paramv.b(paramw);
/*  304 */       paramc2.c(paramv);
/*  305 */       a(paramv, paramc1, paramc2, paramBoolean, paramInt1, paramInt2);
/*  306 */       paramv.a((i)null);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private static void a(v paramv, com.d.i.c paramc1, com.d.i.c paramc2, boolean paramBoolean, int paramInt1, int paramInt2) {
/*  312 */     paramc2.e(paramBoolean);
/*      */     
/*  314 */     paramc2.a(paramv, paramc1, paramInt1);
/*      */     
/*  316 */     paramc2.r(paramv);
/*  317 */     paramc2.B();
/*      */     
/*  319 */     paramv.a(0, paramInt1);
/*  320 */     b(paramv, paramc2, paramInt2);
/*  321 */     paramc2.b(paramv);
/*  322 */     paramv.a(-paramc2.am(), -paramc2.an());
/*      */   }
/*      */   
/*      */   private static void b(v paramv, com.d.i.c paramc, int paramInt) {
/*  326 */     boolean bool = false;
/*  327 */     if (paramc.a().F()) {
/*  328 */       Dimension dimension = paramc.m(paramv);
/*  329 */       paramv.a(dimension.width, dimension.height);
/*  330 */       bool = true;
/*      */     } 
/*  332 */     if (paramv.r()) {
/*      */ 
/*      */       
/*  335 */       boolean bool1 = (paramc.D() || paramc.a().ab() || paramc.i(paramv)) ? true : false;
/*      */       
/*      */       boolean bool2;
/*  338 */       if ((bool2 = paramc.q(paramv)) && paramInt != -1) {
/*  339 */         paramv.p().d(paramInt);
/*      */       }
/*      */       
/*  342 */       if (bool1 || bool2) {
/*  343 */         paramInt = paramc.a(paramv, paramc
/*      */             
/*  345 */             .a().e(com.d.c.a.a.af), bool2);
/*      */         
/*  347 */         paramv.a(0, paramInt);
/*  348 */         bool = true;
/*  349 */         paramc.e(false);
/*      */       } 
/*      */     } 
/*  352 */     if (bool)
/*  353 */       paramc.B(); 
/*      */   }
/*      */   
/*      */   static class b
/*      */   {
/*      */     private List a;
/*      */     
/*      */     public b(int param1Int) {
/*  361 */       this.a = new ArrayList(param1Int);
/*  362 */       for (byte b1 = 0; b1 < param1Int; b1++) {
/*  363 */         this.a.add(new a.a());
/*      */       }
/*      */     }
/*      */     
/*      */     public final a.a a(int param1Int) {
/*  368 */       return this.a.get(param1Int);
/*      */     }
/*      */     
/*      */     public final void a(int param1Int, com.d.i.c param1c1, com.d.i.c param1c2) {
/*  372 */       a.a a1 = a(param1Int - 1);
/*  373 */       a.a a2 = a(param1Int);
/*      */ 
/*      */       
/*  376 */       com.d.c.a.c c1 = param1c1.a().e(com.d.c.a.a.ae);
/*      */       
/*  378 */       com.d.c.a.c c2 = param1c2.a().e(com.d.c.a.a.af);
/*      */       
/*  380 */       if ((c1 == com.d.c.a.c.f && c2 == com.d.c.a.c.e) || (c1 == com.d.c.a.c.e && c2 == com.d.c.a.c.f) || (c1 == com.d.c.a.c.f && c2 == com.d.c.a.c.f)) {
/*      */ 
/*      */         
/*  383 */         if (!a1.b()) {
/*  384 */           a1.c(true);
/*      */         }
/*  386 */         a1.b(true);
/*  387 */         a2.b(true);
/*      */         
/*  389 */         if (param1Int == this.a.size() - 1) {
/*  390 */           a2.a(true);
/*      */           return;
/*      */         } 
/*  393 */       } else if (a1.b()) {
/*  394 */         a1.a(true);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public final int b(int param1Int) {
/*  400 */       param1Int = param1Int;
/*      */       a.a a;
/*  402 */       if (!(a = a(param1Int)).a()) {
/*  403 */         throw new RuntimeException("Not the end of a run");
/*      */       }
/*  405 */       while (!a.d()) {
/*  406 */         a = a(--param1Int);
/*      */       }
/*  408 */       return param1Int;
/*      */     } }
/*      */   
/*      */   static class c { private boolean a;
/*      */     private int b;
/*      */     
/*      */     private c() {}
/*      */     
/*      */     public final boolean a() {
/*  417 */       return this.a;
/*      */     }
/*      */     
/*      */     public final void a(boolean param1Boolean) {
/*  421 */       this.a = true;
/*      */     }
/*      */     
/*      */     public final int b() {
/*  425 */       return this.b;
/*      */     }
/*      */     
/*      */     public final void a(int param1Int) {
/*  429 */       this.b = param1Int;
/*      */     } }
/*      */ 
/*      */ 
/*      */   
/*      */   static class a
/*      */   {
/*      */     private w a;
/*      */     
/*      */     private boolean b;
/*      */     
/*      */     private boolean c;
/*      */     
/*      */     private boolean d;
/*      */     
/*      */     private int e;
/*      */     
/*      */     public final boolean a() {
/*  447 */       return this.c;
/*      */     }
/*      */     
/*      */     public final void a(boolean param1Boolean) {
/*  451 */       this.c = true;
/*      */     }
/*      */     
/*      */     public final boolean b() {
/*  455 */       return this.d;
/*      */     }
/*      */     
/*      */     public final void b(boolean param1Boolean) {
/*  459 */       this.d = true;
/*      */     }
/*      */     
/*      */     public final w c() {
/*  463 */       return this.a;
/*      */     }
/*      */     
/*      */     public final void a(w param1w) {
/*  467 */       this.a = param1w;
/*      */     }
/*      */     
/*      */     public final boolean d() {
/*  471 */       return this.b;
/*      */     }
/*      */     
/*      */     public final void c(boolean param1Boolean) {
/*  475 */       this.b = true;
/*      */     }
/*      */     
/*      */     public final int e() {
/*  479 */       return this.e;
/*      */     }
/*      */     
/*      */     public final void a(int param1Int) {
/*  483 */       this.e = param1Int;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public a(s params) {
/* 1071 */     this.f = params;
/* 1072 */     this.d = new com.d.b.c(params);
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
/*      */   public void a(aa paramaa, l paraml, Document paramDocument, t paramt) {
/* 1084 */     this.a = paramaa;
/* 1085 */     this.b = paraml;
/* 1086 */     this.c = paramDocument;
/* 1087 */     com.d.b.b b = new com.d.b.b(this.b, this.f, paramt);
/*      */     
/* 1089 */     List<com.d.l.b> list = d();
/*      */     
/* 1091 */     l.f("media = " + this.a.d());
/*      */     
/* 1093 */     this
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1098 */       .e = new com.d.c.c.c(new q(), (com.d.c.b.a)b, (com.d.c.b.c)this.d, a(list, this.a.d()), this.a.d());
/*      */   }
/*      */   
/*      */   private List<r> a(List<com.d.l.b> paramList, String paramString) {
/* 1102 */     ArrayList<r> arrayList = new ArrayList(paramList.size() + 15);
/*      */     
/* 1104 */     for (Iterator<com.d.l.b> iterator = paramList.iterator(); iterator.hasNext();) {
/* 1105 */       if ((b = iterator.next()).a(paramString)) {
/*      */         r r;
/*      */         
/* 1108 */         if ((r = b.d()) == null) {
/* 1109 */           r = this.d.a(b);
/*      */         }
/*      */         
/* 1112 */         if (r != null) {
/* 1113 */           if (r.d().size() > 0) {
/* 1114 */             arrayList.addAll(a(r.d(), paramString));
/*      */           }
/*      */           
/* 1117 */           arrayList.add(r); continue;
/*      */         } 
/* 1119 */         l.e(Level.WARNING, "Unable to load CSS from " + b.a());
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1124 */     return arrayList;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public com.d.c.c.a a(Node paramNode, String paramString) {
/* 1166 */     if (paramNode.getNodeType() == 1) {
/* 1167 */       paramNode = paramNode;
/*      */     } else {
/* 1169 */       paramNode = paramNode.getParentNode();
/*      */     } 
/* 1171 */     return this.e.a(paramNode, paramString);
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
/*      */   public com.d.c.c.a a(Element paramElement, boolean paramBoolean) {
/* 1183 */     if (paramElement == null) return com.d.c.c.a.a; 
/* 1184 */     return this.e.a(paramElement, paramBoolean);
/*      */   }
/*      */   
/*      */   public e a(String paramString1, String paramString2) {
/* 1188 */     return this.e.a(paramString1, paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void a() {
/* 1197 */     String str = this.f.a();
/*      */     com.d.l.b b;
/* 1199 */     (b = new com.d.l.b()).b(str);
/* 1200 */     b.a(2);
/* 1201 */     if (this.d.a(str)) {
/* 1202 */       this.d.b(str);
/* 1203 */       l.a("Removing stylesheet '" + str + "' from cache by request."); return;
/*      */     } 
/* 1205 */     l.a("Requested removing stylesheet '" + str + "', but it's not in cache.");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void b() {
/* 1212 */     this.d.a();
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
/*      */   private List<com.d.l.b> d() {
/* 1224 */     ArrayList<com.d.l.b> arrayList = new ArrayList();
/* 1225 */     long l1 = System.currentTimeMillis();
/*      */     
/*      */     com.d.l.b b;
/* 1228 */     if ((b = this.b.a((com.d.c.b.c)this.d)) != null) {
/* 1229 */       arrayList.add(b);
/*      */     }
/*      */     
/* 1232 */     com.d.l.b[] arrayOfB = this.b.a(this.c);
/* 1233 */     byte b1 = 0;
/* 1234 */     if (arrayOfB != null) {
/* 1235 */       byte b2; com.d.l.b[] arrayOfB1; int i; for (i = (arrayOfB1 = arrayOfB).length, b2 = 0; b2 < i; b2++) {
/*      */         com.d.l.b b3;
/*      */         
/* 1238 */         if (!(b3 = arrayOfB1[b2]).f()) {
/* 1239 */           String str = this.f.f(b3.a());
/* 1240 */           b3.b(str);
/*      */         } else {
/* 1242 */           b3.b(this.f.a() + "#inline_style_" + ++b1);
/* 1243 */           r r = this.d.a(new StringReader(b3
/* 1244 */                 .e()), b3);
/* 1245 */           b3.a(r);
/* 1246 */           b3.b(null);
/*      */         } 
/*      */       } 
/* 1249 */       arrayList.addAll(Arrays.asList(arrayOfB));
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1254 */     long l2 = System.currentTimeMillis() - l1;
/* 1255 */     l.e("TIME: parse stylesheets  " + l2 + "ms");
/*      */     
/* 1257 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<com.d.c.e.a> c() {
/* 1268 */     return this.e.a();
/*      */   }
/*      */   
/*      */   public void a(s params) {
/* 1272 */     this.f = params;
/* 1273 */     this.d.a(params);
/*      */   }
/*      */   
/*      */   public void a(boolean paramBoolean) {
/* 1277 */     this.d.a(true);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\e\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */