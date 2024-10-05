/*     */ package com.d.h;
/*     */ 
/*     */ import com.d.c.f.g;
/*     */ import com.d.d.k;
/*     */ import com.d.e.aa;
/*     */ import com.d.g.a.d;
/*     */ import com.d.i.k;
/*     */ import com.d.m.l;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.logging.Level;
/*     */ import org.a.b.f.ao;
/*     */ import org.a.b.f.ap;
/*     */ import org.a.c.h.e.ac;
/*     */ import org.a.c.h.e.ae;
/*     */ import org.a.c.h.e.u;
/*     */ import org.a.c.h.e.v;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class f
/*     */   implements k
/*     */ {
/*     */   private Map<String, d<b>> a;
/*     */   
/*     */   static {
/*  61 */     f.class.desiredAssertionStatus();
/*     */   }
/*  63 */   private Map<String, b> b = new HashMap<>();
/*     */   private final org.a.c.h.b c;
/*     */   private final aa d;
/*  66 */   private final List<ao> e = new ArrayList<>();
/*     */   private final com.d.d.a<String, com.d.d.b> f;
/*     */   private final x.c g;
/*     */   private final boolean h;
/*     */   
/*     */   public f(aa paramaa, org.a.c.h.b paramb, com.d.d.a<String, com.d.d.b> parama, x.c paramc, boolean paramBoolean) {
/*  72 */     this.d = paramaa;
/*  73 */     this.c = paramb;
/*  74 */     this.f = parama;
/*  75 */     this.g = paramc;
/*  76 */     this.h = paramBoolean;
/*     */ 
/*     */     
/*  79 */     this.a = (this.g == x.c.a && !paramBoolean) ? c() : new HashMap<>();
/*     */   }
/*     */ 
/*     */   
/*     */   public final k a(aa paramaa, com.d.c.g.a parama) {
/*  84 */     return a(paramaa, parama.c, parama.a, parama.b, parama.d, parama.e);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a() {
/*  92 */     this.b.clear();
/*     */ 
/*     */     
/*  95 */     for (ao ao : this.e) {
/*     */       try {
/*  97 */         ao.close();
/*  98 */       } catch (IOException iOException) {}
/*     */     } 
/*     */ 
/*     */     
/* 102 */     this.e.clear();
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
/*     */   @Deprecated
/*     */   public final void b() {
/* 115 */     this.b = new HashMap<>();
/*     */     
/* 117 */     for (Iterator<d> iterator = this.a.values().iterator(); iterator.hasNext(); ) {
/*     */       d d;
/* 119 */       for (Iterator<b> iterator1 = (d = iterator.next()).a().iterator(); iterator1.hasNext();) {
/*     */         
/* 121 */         if ((b1 = iterator1.next()).d()) {
/* 122 */           iterator1.remove();
/*     */         }
/*     */       } 
/* 125 */       if (d.a().size() == 0) {
/* 126 */         iterator.remove();
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void a(List<com.d.c.e.a> paramList) {
/* 132 */     for (Iterator<com.d.c.e.a> iterator = paramList.iterator(); iterator.hasNext();) {
/*     */ 
/*     */ 
/*     */       
/* 136 */       if ((g = (c1 = (a1 = iterator.next()).b()).i(com.d.c.a.a.ak)) != com.d.c.a.c.ap) {
/*     */         String str;
/*     */ 
/*     */         
/* 140 */         boolean bool = c1.a(com.d.c.a.a.m, com.d.c.a.c.bQ);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 145 */         com.d.c.a.c c2 = null;
/* 146 */         com.d.c.a.c c3 = null;
/*     */         
/* 148 */         if (a1.c()) {
/* 149 */           str = c1.i(com.d.c.a.a.O).d();
/*     */         } else {
/* 151 */           l.a(Level.WARNING, "Must provide at least a font-family and src in @font-face rule");
/*     */           
/*     */           continue;
/*     */         } 
/* 155 */         if (a1.d()) {
/* 156 */           c2 = c1.e(com.d.c.a.a.L);
/*     */         }
/*     */         
/* 159 */         if (a1.e()) {
/* 160 */           c3 = c1.e(com.d.c.a.a.J);
/*     */         }
/*     */         
/* 163 */         a(str, c2, c3, g.d(), !bool);
/*     */       } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(ap paramap, String paramString, Integer paramInteger, com.d.c.a.c paramc, boolean paramBoolean) {
/* 194 */     ac ac = ac.a(this.c, paramap, paramBoolean);
/*     */     
/* 196 */     b(new c((u)ac), paramString, paramInteger, paramc, paramBoolean);
/*     */   }
/*     */   
/*     */   private static class c implements com.d.d.f<u> {
/*     */     private final u a;
/*     */     
/*     */     c(u param1u) {
/* 203 */       this.a = param1u;
/*     */     }
/*     */ 
/*     */     
/*     */     private u b() {
/* 208 */       return this.a;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(com.d.d.f<u> paramf, String paramString, Integer paramInteger, com.d.c.a.c paramc, boolean paramBoolean) {
/* 216 */     d<b> d = a(paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 221 */     b b1 = new b(this.c, paramf, b(paramc), a(paramInteger), paramString, false, paramBoolean, this.f, (byte)0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 227 */     if (paramBoolean || 
/* 228 */       b.a(b1))
/*     */     {
/*     */ 
/*     */       
/* 232 */       d.a(b1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(ao paramao, String paramString, Integer paramInteger, com.d.c.a.c paramc, boolean paramBoolean) {
/* 242 */     paramao.a(new g(this, paramString, paramInteger, paramc, paramBoolean));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 248 */     this.e.add(paramao);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(File paramFile, String paramString, Integer paramInteger, com.d.c.a.c paramc, boolean paramBoolean) {
/* 272 */     ao ao = new ao(paramFile);
/* 273 */     a(ao, paramString, paramInteger, paramc, paramBoolean);
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
/*     */   public final void a(File paramFile, String paramString, Integer paramInteger, com.d.c.a.c paramc, boolean paramBoolean) {
/* 285 */     if (paramFile.getName().toLowerCase(Locale.US).endsWith(".ttc")) {
/* 286 */       b(paramFile, paramString, paramInteger, paramc, paramBoolean);
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */     
/* 293 */     b(new a(paramFile, this.c), paramString, paramInteger, paramc, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   private static class a
/*     */     implements com.d.d.f<u>
/*     */   {
/*     */     private final File a;
/*     */     private final org.a.c.h.b b;
/*     */     
/*     */     a(File param1File, org.a.c.h.b param1b) {
/* 304 */       this.a = param1File;
/* 305 */       this.b = param1b;
/*     */     }
/*     */ 
/*     */     
/*     */     private u b() {
/*     */       try {
/* 311 */         return (u)ac.a(this.b, this.a);
/* 312 */       } catch (IOException iOException) {
/* 313 */         l.a("Couldn't load font (" + this.a.getAbsolutePath() + "). Please check that it is a valid truetype font.", iOException);
/* 314 */         return null;
/*     */       } 
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
/*     */   public final void a(com.d.d.f<InputStream> paramf, String paramString, Integer paramInteger, com.d.c.a.c paramc, boolean paramBoolean) {
/* 327 */     d<b> d = a(paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 333 */     b b1 = new b(this.c, paramf, a(paramInteger), b(paramc), paramString, false, paramBoolean, this.f, (byte)0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 339 */     if (paramBoolean || 
/* 340 */       b.a(b1))
/*     */     {
/*     */ 
/*     */       
/* 344 */       d.a(b1);
/*     */     }
/*     */   }
/*     */   
/*     */   private static int a(com.d.c.a.c paramc) {
/* 349 */     return (paramc != null) ? com.a.a.b.c.a.a(paramc) : 400;
/*     */   }
/*     */   
/*     */   private static int a(Integer paramInteger) {
/* 353 */     return (paramInteger != null) ? paramInteger.intValue() : 400;
/*     */   }
/*     */   
/*     */   private static com.d.c.a.c b(com.d.c.a.c paramc) {
/* 357 */     return (paramc != null) ? paramc : com.d.c.a.c.aq;
/*     */   }
/*     */   
/*     */   private void a(String paramString1, com.d.c.a.c paramc1, com.d.c.a.c paramc2, String paramString2, boolean paramBoolean) {
/* 361 */     com.d.g.a.c c1 = new com.d.g.a.c(this.d, paramString2);
/* 362 */     d<b> d = a(paramString1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 368 */     b b1 = new b(this.c, (com.d.d.f)c1, a(paramc1), b(paramc2), paramString1, true, paramBoolean, this.f, (byte)0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 374 */     if (paramBoolean || 
/* 375 */       b.a(b1))
/*     */     {
/*     */ 
/*     */       
/* 379 */       d.a(b1);
/*     */     }
/*     */   }
/*     */   
/*     */   private d<b> a(String paramString) {
/*     */     d<b> d;
/* 385 */     if ((d = this.a.get(paramString)) == null) {
/* 386 */       d = new d();
/* 387 */       this.a.put(paramString, d);
/*     */     } 
/* 389 */     return d;
/*     */   }
/*     */   
/*     */   private k a(aa paramaa, String[] paramArrayOfString, float paramFloat, com.d.c.a.c paramc1, com.d.c.a.c paramc2, com.d.c.a.c paramc3) {
/* 393 */     if (paramc2 != com.d.c.a.c.aq && paramc2 != com.d.c.a.c.at && paramc2 != com.d.c.a.c.W) {
/* 394 */       paramc2 = com.d.c.a.c.aq;
/*     */     }
/*     */     
/* 397 */     ArrayList<b> arrayList = new ArrayList(3);
/*     */     
/* 399 */     if (paramArrayOfString != null) {
/* 400 */       for (byte b1 = 0; b1 < paramArrayOfString.length; b1++) {
/*     */         b b2;
/* 402 */         if ((b2 = a(paramArrayOfString[b1], paramc1, paramc2)) != null) {
/* 403 */           arrayList.add(b2);
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 408 */     if (this.g == x.c.a && !this.h)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 416 */       arrayList.add(a("Serif", paramc1, paramc2));
/*     */     }
/*     */     
/* 419 */     return new b(arrayList, paramFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static String b(String paramString) {
/* 425 */     if ((paramString = paramString).startsWith("\"")) {
/* 426 */       paramString = paramString.substring(1);
/*     */     }
/* 428 */     if (paramString.endsWith("\"")) {
/* 429 */       paramString = paramString.substring(0, paramString.length() - 1);
/*     */     }
/*     */ 
/*     */     
/* 433 */     if (paramString.equalsIgnoreCase("serif")) {
/* 434 */       paramString = "Serif";
/*     */     }
/* 436 */     else if (paramString.equalsIgnoreCase("sans-serif")) {
/* 437 */       paramString = "SansSerif";
/*     */     }
/* 439 */     else if (paramString.equalsIgnoreCase("monospace")) {
/* 440 */       paramString = "Monospaced";
/*     */     } 
/*     */     
/* 443 */     return paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   private b a(String paramString, com.d.c.a.c paramc1, com.d.c.a.c paramc2) {
/* 448 */     String str = b(paramString = b(paramString), paramc1, paramc2);
/*     */     
/*     */     b b1;
/* 451 */     if ((b1 = this.b.get(str)) != null) {
/* 452 */       return b1;
/*     */     }
/*     */     
/*     */     d d;
/*     */     
/* 457 */     if ((d = this.a.get(paramString)) != null && (
/*     */ 
/*     */       
/* 460 */       b1 = (b)d.a(com.a.a.b.c.a.a(paramc1), paramc2)) != null) {
/* 461 */       this.b.put(str, b1);
/* 462 */       return b1;
/*     */     } 
/*     */ 
/*     */     
/* 466 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private static String b(String paramString, com.d.c.a.c paramc1, com.d.c.a.c paramc2) {
/* 471 */     return paramString + "-" + paramc1 + "-" + paramc2;
/*     */   }
/*     */   
/*     */   private static Map<String, d<b>> c() {
/* 475 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */     
/*     */     try {
/* 478 */       a((HashMap)hashMap);
/* 479 */       b((HashMap)hashMap);
/* 480 */       c((HashMap)hashMap);
/* 481 */       a((Map)hashMap);
/* 482 */       b((Map)hashMap);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 488 */     catch (IOException iOException) {
/* 489 */       throw new RuntimeException(iOException.getMessage(), iOException);
/*     */     } 
/*     */     
/* 492 */     return (Map<String, d<b>>)iOException;
/*     */   }
/*     */   
/*     */   private static u a(u paramu) {
/* 496 */     return paramu;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(HashMap<String, d<b>> paramHashMap) {
/*     */     d<b> d;
/* 503 */     (d = new d()).a(new b(
/* 504 */           a((u)ae.p), com.d.c.a.c.at, 700, (byte)0));
/* 505 */     d.a(new b(
/* 506 */           a((u)ae.o), com.d.c.a.c.at, 400, (byte)0));
/* 507 */     d.a(new b(
/* 508 */           a((u)ae.n), com.d.c.a.c.aq, 700, (byte)0));
/* 509 */     d.a(new b(
/* 510 */           a((u)ae.m), com.d.c.a.c.aq, 400, (byte)0));
/*     */     
/* 512 */     paramHashMap.put("DialogInput", d);
/* 513 */     paramHashMap.put("Monospaced", d);
/* 514 */     paramHashMap.put("Courier", d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void b(HashMap<String, d<b>> paramHashMap) {
/*     */     d<b> d;
/* 521 */     (d = new d()).a(new b(
/* 522 */           a((u)ae.h), com.d.c.a.c.W, 700, (byte)0));
/* 523 */     d.a(new b(
/* 524 */           a((u)ae.g), com.d.c.a.c.W, 400, (byte)0));
/* 525 */     d.a(new b(
/* 526 */           a((u)ae.f), com.d.c.a.c.aq, 700, (byte)0));
/* 527 */     d.a(new b(
/* 528 */           a((u)ae.e), com.d.c.a.c.aq, 400, (byte)0));
/*     */     
/* 530 */     paramHashMap.put("Serif", d);
/* 531 */     paramHashMap.put("TimesRoman", d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void c(HashMap<String, d<b>> paramHashMap) {
/*     */     d<b> d;
/* 538 */     (d = new d()).a(new b(
/* 539 */           a((u)ae.l), com.d.c.a.c.at, 700, (byte)0));
/* 540 */     d.a(new b(
/* 541 */           a((u)ae.k), com.d.c.a.c.at, 400, (byte)0));
/* 542 */     d.a(new b(
/* 543 */           a((u)ae.j), com.d.c.a.c.aq, 700, (byte)0));
/* 544 */     d.a(new b(
/* 545 */           a((u)ae.i), com.d.c.a.c.aq, 400, (byte)0));
/*     */     
/* 547 */     paramHashMap.put("Dialog", d);
/* 548 */     paramHashMap.put("SansSerif", d);
/* 549 */     paramHashMap.put("Helvetica", d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(Map<String, d<b>> paramMap) {
/*     */     d<b> d;
/* 556 */     (d = new d()).a(new b(a((u)ae.q), com.d.c.a.c.aq, 400, (byte)0));
/*     */     
/* 558 */     paramMap.put("Symbol", d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void b(Map<String, d<b>> paramMap) {
/*     */     d<b> d;
/* 565 */     (d = new d()).a(new b(a((u)ae.r), com.d.c.a.c.aq, 400, (byte)0));
/*     */     
/* 567 */     paramMap.put("ZapfDingbats", d);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class b
/*     */     implements com.d.g.a.f
/*     */   {
/*     */     private final com.d.c.a.c a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final int b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final String c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final org.a.c.h.b d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private com.d.d.f<InputStream> e;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private com.d.d.f<u> f;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private u g;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final boolean h;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final boolean i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private p j;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final com.d.d.a<String, com.d.d.b> k;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private b(u param1u, com.d.c.a.c param1c, int param1Int) {
/* 646 */       this((org.a.c.h.b)null, param1u, param1c, param1Int);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private b(org.a.c.h.b param1b, com.d.d.f<InputStream> param1f, int param1Int, com.d.c.a.c param1c, String param1String, boolean param1Boolean1, boolean param1Boolean2, com.d.d.a<String, com.d.d.b> param1a) {
/* 659 */       this.e = param1f;
/* 660 */       this.b = param1Int;
/* 661 */       this.a = param1c;
/* 662 */       this.d = param1b;
/* 663 */       this.c = param1String;
/* 664 */       this.h = param1Boolean1;
/* 665 */       this.i = param1Boolean2;
/* 666 */       this.k = param1a;
/* 667 */       this.j = b(param1String, param1Int, param1c);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private b(org.a.c.h.b param1b, u param1u, com.d.c.a.c param1c, int param1Int) {
/* 675 */       this.g = param1u;
/* 676 */       this.a = param1c;
/* 677 */       this.b = param1Int;
/* 678 */       this.e = null;
/* 679 */       this.d = param1b;
/* 680 */       this.k = null;
/* 681 */       this.c = null;
/* 682 */       this.h = false;
/* 683 */       this.i = false;
/* 684 */       v v = param1u.b();
/*     */       
/*     */       try {
/* 687 */         this.j = p.a(param1u, v); return;
/* 688 */       } catch (IOException iOException) {
/* 689 */         l.a("Couldn't load font metrics.", iOException);
/*     */         return;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private b(org.a.c.h.b param1b, com.d.d.f<u> param1f, com.d.c.a.c param1c, int param1Int, String param1String, boolean param1Boolean1, boolean param1Boolean2, com.d.d.a<String, com.d.d.b> param1a) {
/* 702 */       this.f = param1f;
/* 703 */       this.a = param1c;
/* 704 */       this.b = param1Int;
/* 705 */       this.e = null;
/* 706 */       this.d = param1b;
/* 707 */       this.c = param1String;
/* 708 */       this.h = param1Boolean1;
/* 709 */       this.i = param1Boolean2;
/* 710 */       this.k = param1a;
/* 711 */       this.j = b(param1String, param1Int, param1c);
/*     */     }
/*     */     
/*     */     private static String a(String param1String, int param1Int, com.d.c.a.c param1c) {
/* 715 */       return "font-metrics:" + param1String + ":" + param1Int + ":" + param1c.toString();
/*     */     }
/*     */     
/*     */     private p b(String param1String, int param1Int, com.d.c.a.c param1c) {
/* 719 */       return (p)this.k.a(a(param1String, param1Int, param1c));
/*     */     }
/*     */     
/*     */     private void a(String param1String, int param1Int, com.d.c.a.c param1c, p param1p) {
/* 723 */       a(param1String, param1Int, param1c);
/*     */     }
/*     */     
/*     */     private boolean f() {
/*     */       try {
/* 728 */         v v = this.g.b();
/* 729 */         this.j = p.a(this.g, v);
/* 730 */         a(this.c, this.b, this.a, this.j);
/* 731 */         return true;
/* 732 */       } catch (IOException iOException) {
/* 733 */         l.c("Couldn't load font. Please check that it is a valid truetype font.");
/*     */         
/* 735 */         return false;
/*     */       } 
/*     */     }
/*     */     
/*     */     private boolean g() {
/* 740 */       if (this.g == null && this.f != null) {
/* 741 */         l.e(Level.INFO, "Loading font(" + this.c + ") from PDFont supplier now.");
/*     */         
/* 743 */         this.g = (u)this.f.a();
/* 744 */         this.f = null;
/*     */         
/* 746 */         if (!h())
/*     */         {
/* 748 */           return f();
/*     */         }
/*     */       } 
/*     */       
/* 752 */       if (this.g == null && this.e != null) {
/* 753 */         l.e(Level.INFO, "Loading font(" + this.c + ") from InputStream supplier now.");
/*     */         
/* 755 */         InputStream inputStream = (InputStream)this.e.a();
/* 756 */         this.e = null;
/*     */         
/* 758 */         if (inputStream == null) {
/* 759 */           return false;
/*     */         }
/*     */         
/*     */         try {
/* 763 */           this.g = (u)ac.a(this.d, inputStream, this.i);
/*     */           
/* 765 */           if (!h()) {
/* 766 */             return f();
/*     */           }
/* 768 */         } catch (IOException iOException) {
/* 769 */           l.c("Couldn't load font. Please check that it is a valid truetype font.");
/* 770 */           return false;
/*     */         } finally {
/*     */           try {
/* 773 */             inputStream.close();
/* 774 */           } catch (IOException iOException) {}
/*     */         } 
/*     */       } 
/*     */       
/* 778 */       return (this.g != null);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final u c() {
/* 794 */       g();
/* 795 */       return this.g;
/*     */     }
/*     */ 
/*     */     
/*     */     public final int a() {
/* 800 */       return this.b;
/*     */     }
/*     */ 
/*     */     
/*     */     public final com.d.c.a.c b() {
/* 805 */       return this.a;
/*     */     }
/*     */     
/*     */     public final boolean d() {
/* 809 */       return this.h;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private boolean h() {
/* 817 */       return (this.j != null);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final p e() {
/* 827 */       if (!h()) {
/* 828 */         g();
/*     */       }
/*     */       
/* 831 */       return this.j;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\h\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */