/*     */ package com.d.h;
/*     */ 
/*     */ import com.d.c.d.f;
/*     */ import com.d.c.d.g;
/*     */ import com.d.i.ab;
/*     */ import com.d.i.f;
/*     */ import com.d.m.l;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.logging.Level;
/*     */ import java.util.regex.Pattern;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.b.s;
/*     */ import org.a.c.h.e;
/*     */ import org.a.c.h.g.a.k;
/*     */ import org.a.c.h.g.a.m;
/*     */ import org.a.c.h.g.b.m;
/*     */ import org.a.c.h.g.b.n;
/*     */ import org.a.c.h.g.b.o;
/*     */ import org.a.c.h.g.b.q;
/*     */ import org.a.c.h.g.e.f;
/*     */ import org.a.c.h.g.e.j;
/*     */ import org.a.c.h.g.e.k;
/*     */ import org.a.c.h.g.e.l;
/*     */ import org.a.c.h.g.e.m;
/*     */ import org.a.c.h.g.e.n;
/*     */ import org.a.c.h.g.e.q;
/*     */ import org.a.c.h.j;
/*     */ import org.w3c.dom.Element;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class h
/*     */ {
/*     */   private final o a;
/*     */   private final m b;
/*     */   private final Element c;
/*  68 */   private final List<c> d = new ArrayList<>();
/*     */ 
/*     */   
/*  71 */   private final List<b> e = new ArrayList<>(2);
/*     */ 
/*     */   
/*  74 */   private final Map<String, List<b>> f = new LinkedHashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  82 */   private final Map<String, d> g = new HashMap<>();
/*     */   
/*     */   static class d
/*     */   {
/*     */     private j a;
/*     */     private String b;
/*     */     private String c;
/*     */     private boolean d;
/*     */     
/*     */     private d() {}
/*     */   }
/*     */   
/*     */   public static class b
/*     */   {
/*     */     public final f a;
/*     */     private final e b;
/*     */     private final AffineTransform c;
/*     */     private final ab d;
/*     */     private final float e;
/*     */     
/*     */     public b(f param1f, e param1e, AffineTransform param1AffineTransform, ab param1ab, float param1Float) {
/* 103 */       this.a = param1f;
/* 104 */       this.b = param1e;
/* 105 */       this.c = param1AffineTransform;
/* 106 */       this.d = param1ab;
/* 107 */       this.e = param1Float;
/*     */     }
/*     */   }
/*     */   
/*     */   static class c {
/*     */     private final String a;
/*     */     private final h.b b;
/*     */     
/*     */     private c(h.b param1b, String param1String) {
/* 116 */       this.b = param1b;
/* 117 */       this.a = param1String;
/*     */     }
/*     */   }
/*     */   
/*     */   private h(Element paramElement, o paramo, m paramm) {
/* 122 */     this.c = paramElement;
/* 123 */     this.b = paramm;
/* 124 */     this.a = paramo;
/*     */   }
/*     */   
/*     */   public static h a(Element paramElement, o paramo, m paramm) {
/* 128 */     return new h(paramElement, paramo, paramm);
/*     */   }
/*     */   
/*     */   public final void a(b paramb, String paramString) {
/* 132 */     this.d.add(new c(paramb, paramString, (byte)0));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a() {
/* 140 */     for (Iterator<c> iterator = this.d.iterator(); iterator.hasNext();) {
/* 141 */       if ((c.a(c = iterator.next())).a.ai().hasAttribute("name")) {
/*     */         String str;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 147 */         if (!(str = (c.a(c)).a.ai().getAttribute("name")).contains(".")) {
/*     */           d d;
/*     */           
/* 150 */           d.a(d = new d((byte)0), str);
/* 151 */           d.b(d, str);
/* 152 */           d.a(d, true);
/* 153 */           this.g.put(str, d); continue;
/*     */         } 
/* 155 */         String[] arrayOfString = str.split(Pattern.quote("."));
/*     */         
/* 157 */         for (byte b = 1; b <= arrayOfString.length; b++) {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 162 */           String[] arrayOfString1 = new String[b];
/* 163 */           System.arraycopy(arrayOfString, 0, arrayOfString1, 0, b);
/* 164 */           String str1 = com.d.m.a.a(arrayOfString1, ".");
/*     */           
/*     */           d d;
/* 167 */           if ((d = this.g.get(str1)) == null) {
/*     */             
/* 169 */             d.b(d = new d((byte)0), str1);
/* 170 */             d.a(d, arrayOfString1[b - 1]);
/* 171 */             d.a(d, (b == arrayOfString.length));
/* 172 */             this.g.put(str1, d);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(d paramd, org.a.c.h.g.e.d paramd1) {
/* 185 */     if (!d.a(paramd)) {
/* 186 */       org.a.c.b.a a = new org.a.c.b.a();
/*     */       
/* 188 */       for (Iterator<d> iterator = this.g.values().iterator(); iterator.hasNext();) {
/* 189 */         if (d.b(d1 = iterator.next()).indexOf(d.b(paramd)) == 0 && 
/* 190 */           d.b(d1).length() > d.b(paramd).length() + 1 && 
/* 191 */           !d.b(d1).substring(d.b(paramd).length() + 1).contains(".")) {
/*     */           
/* 193 */           a.a((org.a.c.b.b)d.c(d1).i());
/* 194 */           d.c(d1).i().a(j.cN, (org.a.c.b.b)d.c(paramd).i());
/* 195 */           a(d1, paramd1);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 200 */       d.c(paramd).i().a(j.bR, (org.a.c.b.b)a);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(org.a.c.h.g.e.d paramd) {
/*     */     Iterator<d> iterator;
/* 209 */     for (iterator = this.g.values().iterator(); iterator.hasNext();) {
/* 210 */       if (!d.a(d1 = iterator.next())) {
/*     */         l l;
/* 212 */         (l = new l(paramd)).c(d.d(d1));
/* 213 */         d.a(d1, (j)l);
/*     */       } 
/*     */     } 
/*     */     
/* 217 */     for (iterator = this.g.values().iterator(); iterator.hasNext();) {
/* 218 */       if (!d.b(d1 = iterator.next()).contains(".")) {
/* 219 */         a(d1, paramd);
/* 220 */         paramd.c().add(d.c(d1));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static String a(g paramg) {
/*     */     com.d.c.d.h h1;
/* 229 */     String str = "";
/*     */     
/* 231 */     if (paramg instanceof com.d.c.d.h) {
/*     */       
/* 233 */       float f1 = (h1 = (com.d.c.d.h)paramg).c() / 255.0F;
/* 234 */       float f2 = h1.b() / 255.0F;
/* 235 */       float f3 = h1.a() / 255.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 240 */       String str1 = String.format(Locale.US, "%.4f", new Object[] { Float.valueOf(f1) }) + ' ' + String.format(Locale.US, "%.4f", new Object[] { Float.valueOf(f2) }) + ' ' + String.format(Locale.US, "%.4f", new Object[] { Float.valueOf(f3) }) + ' ' + "rg";
/*     */     }
/* 242 */     else if (h1 instanceof f) {
/*     */       f f;
/* 244 */       float f2 = (f = (f)h1).a();
/* 245 */       float f3 = f.b();
/* 246 */       float f4 = f.c();
/* 247 */       float f1 = f.d();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 253 */       str = String.format(Locale.US, "%.4f", new Object[] { Float.valueOf(f2) }) + ' ' + String.format(Locale.US, "%.4f", new Object[] { Float.valueOf(f3) }) + ' ' + String.format(Locale.US, "%.4f", new Object[] { Float.valueOf(f4) }) + ' ' + String.format(Locale.US, "%.4f", new Object[] { Float.valueOf(f1) }) + ' ' + "k";
/*     */     } 
/*     */ 
/*     */     
/* 257 */     return str;
/*     */   }
/*     */   
/*     */   private static String a(Element paramElement) {
/* 261 */     return com.a.a.b.c.a.a(paramElement);
/*     */   }
/*     */   
/*     */   private static String a(Element paramElement, List<String> paramList1, List<String> paramList2, List<Integer> paramList) {
/* 265 */     List list = com.a.a.b.c.a.b(paramElement, "option");
/* 266 */     String str = "";
/* 267 */     byte b = 0;
/*     */     
/* 269 */     for (Iterator<Element> iterator = list.iterator(); iterator.hasNext(); ) {
/* 270 */       Element element; String str1 = com.a.a.b.c.a.a(element = iterator.next());
/* 271 */       paramList1.add(str1);
/*     */       
/* 273 */       if (element.hasAttribute("value")) {
/* 274 */         paramList2.add(element.getAttribute("value"));
/*     */       } else {
/* 276 */         paramList2.add(str1);
/*     */       } 
/*     */       
/* 279 */       if (str.isEmpty()) {
/* 280 */         str = str1;
/*     */       }
/*     */       
/* 283 */       if (element.hasAttribute("selected")) {
/* 284 */         str = str1;
/*     */       }
/*     */       
/* 287 */       if (element.hasAttribute("selected") && paramList != null) {
/* 288 */         paramList.add(Integer.valueOf(b));
/*     */       }
/*     */       
/* 291 */       b++;
/*     */     } 
/*     */     
/* 294 */     return str;
/*     */   }
/*     */   
/*     */   private void a(c paramc, b paramb, org.a.c.h.g.e.d paramd, f paramf) {
/* 298 */     k k = new k(paramd);
/*     */     
/*     */     d d1;
/* 301 */     d.a(d1 = this.g.get(paramb.a.ai().getAttribute("name")), (j)k);
/*     */     
/* 303 */     k.c(d.d(d1));
/* 304 */     k.a(true);
/*     */     
/* 306 */     ArrayList<String> arrayList1 = new ArrayList();
/* 307 */     ArrayList<String> arrayList2 = new ArrayList();
/* 308 */     ArrayList<Integer> arrayList = new ArrayList();
/* 309 */     a(paramb.a.ai(), arrayList1, arrayList2, arrayList);
/*     */     
/* 311 */     k.a(arrayList2, arrayList1);
/* 312 */     k.a(arrayList);
/*     */     
/*     */     g g;
/* 315 */     String str2 = a(g = paramb.a.a().b());
/*     */     
/* 317 */     String str1 = "/" + c.b(paramc) + " 0 Tf";
/* 318 */     k.e(str1 + ' ' + str2);
/*     */     
/* 320 */     if (paramb.a.ai().hasAttribute("required")) {
/* 321 */       k.e(true);
/*     */     }
/*     */     
/* 324 */     if (paramb.a.ai().hasAttribute("readonly")) {
/* 325 */       k.d(true);
/*     */     }
/*     */     
/* 328 */     if (paramb.a.ai().hasAttribute("title")) {
/* 329 */       k.d(paramb.a.ai().getAttribute("title"));
/*     */     }
/*     */     
/* 332 */     m m1 = k.l().get(0);
/*     */     
/* 334 */     Rectangle2D rectangle2D = k.a(b.a(paramb), paramb.a, b.b(paramb), b.c(paramb), this.b);
/* 335 */     org.a.c.h.a.h h1 = new org.a.c.h.a.h((float)rectangle2D.getMinX(), (float)rectangle2D.getMinY(), (float)rectangle2D.getWidth(), (float)rectangle2D.getHeight());
/*     */     
/* 337 */     m1.a(h1);
/* 338 */     m1.a(b.d(paramb));
/* 339 */     m1.b(true);
/*     */     
/* 341 */     b.d(paramb).i().add(m1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(c paramc, b paramb, org.a.c.h.g.e.d paramd, f paramf) {
/* 348 */     org.a.c.h.g.e.h h2 = new org.a.c.h.g.e.h(paramd);
/*     */     
/*     */     d d1;
/* 351 */     d.a(d1 = this.g.get(paramb.a.ai().getAttribute("name")), (j)h2);
/*     */     
/* 353 */     h2.c(d.d(d1));
/*     */     
/* 355 */     ArrayList<String> arrayList1 = new ArrayList();
/* 356 */     ArrayList<String> arrayList2 = new ArrayList();
/* 357 */     String str3 = a(paramb.a.ai(), arrayList1, arrayList2, (List<Integer>)null);
/*     */     
/* 359 */     h2.a(arrayList2, arrayList1);
/* 360 */     h2.a(str3);
/* 361 */     h2.b(str3);
/*     */     
/*     */     g g;
/* 364 */     String str2 = a(g = paramb.a.a().b());
/*     */     
/* 366 */     String str1 = "/" + c.b(paramc) + " 0 Tf";
/* 367 */     h2.e(str1 + ' ' + str2);
/*     */     
/* 369 */     if (paramb.a.ai().hasAttribute("required")) {
/* 370 */       h2.e(true);
/*     */     }
/*     */     
/* 373 */     if (paramb.a.ai().hasAttribute("readonly")) {
/* 374 */       h2.d(true);
/*     */     }
/*     */     
/* 377 */     if (paramb.a.ai().hasAttribute("title")) {
/* 378 */       h2.d(paramb.a.ai().getAttribute("title"));
/*     */     }
/*     */     
/* 381 */     if (paramb.a.ai().getNodeName().equals("openhtmltopdf-combo")) {
/* 382 */       h2.c(true);
/* 383 */       h2.b(true);
/*     */     } 
/*     */     
/* 386 */     m m1 = h2.l().get(0);
/*     */     
/* 388 */     Rectangle2D rectangle2D = k.a(b.a(paramb), paramb.a, b.b(paramb), b.c(paramb), this.b);
/* 389 */     org.a.c.h.a.h h1 = new org.a.c.h.a.h((float)rectangle2D.getMinX(), (float)rectangle2D.getMinY(), (float)rectangle2D.getWidth(), (float)rectangle2D.getHeight());
/*     */     
/* 391 */     m1.a(h1);
/* 392 */     m1.a(b.d(paramb));
/* 393 */     m1.b(true);
/*     */     
/* 395 */     b.d(paramb).i().add(m1);
/*     */   }
/*     */   
/*     */   private void a(b paramb, org.a.c.h.g.e.d paramd) {
/* 399 */     q q = new q(paramd);
/*     */     
/*     */     d d1;
/* 402 */     d.a(d1 = this.g.get(paramb.a.ai().getAttribute("name")), (j)q);
/*     */     
/* 404 */     q.c(d.d(d1));
/*     */     
/* 406 */     String str = paramb.a.ai().getAttribute("value");
/*     */     
/* 408 */     q.b(str);
/* 409 */     q.a(str);
/*     */     
/*     */     m m1;
/*     */     
/* 413 */     (m1 = q.l().get(0)).a(b.d(paramb));
/* 414 */     m1.a(true);
/* 415 */     m1.a(new org.a.c.h.a.h(0.0F, 0.0F, 1.0F, 1.0F));
/* 416 */     b.d(paramb).i().add(m1);
/*     */   }
/*     */   
/*     */   private void c(c paramc, b paramb, org.a.c.h.g.e.d paramd, f paramf) {
/* 420 */     q q = new q(paramd);
/*     */     
/*     */     d d1;
/* 423 */     d.a(d1 = this.g.get(paramb.a.ai().getAttribute("name")), (j)q);
/*     */     
/* 425 */     q.c(d.d(d1));
/*     */     
/*     */     g g;
/* 428 */     String str2 = a(g = paramb.a.a().b());
/*     */     
/* 430 */     String str1 = "/" + c.b(paramc) + " 0 Tf";
/* 431 */     q.e(str1 + ' ' + str2);
/*     */ 
/*     */ 
/*     */     
/* 435 */     str1 = paramb.a.ai().getNodeName().equals("textarea") ? a(paramb.a.ai()) : paramb.a.ai().getAttribute("value");
/*     */     
/* 437 */     q.b(str1);
/* 438 */     q.a(str1);
/*     */     
/* 440 */     if (com.a.a.b.c.a.b(paramb.a.ai().getAttribute("max-length")) != null) {
/* 441 */       q.a(com.a.a.b.c.a.b(paramb.a.ai().getAttribute("max-length")).intValue());
/*     */     }
/*     */     
/* 444 */     if (paramb.a.ai().hasAttribute("required")) {
/* 445 */       q.e(true);
/*     */     }
/*     */     
/* 448 */     if (paramb.a.ai().hasAttribute("readonly")) {
/* 449 */       q.d(true);
/*     */     }
/*     */     
/* 452 */     if (paramb.a.ai().getNodeName().equals("textarea")) {
/* 453 */       q.a(true);
/* 454 */     } else if (paramb.a.ai().getAttribute("type").equals("password")) {
/* 455 */       q.b(true);
/* 456 */     } else if (paramb.a.ai().getAttribute("type").equals("file")) {
/* 457 */       l.d(Level.WARNING, "Acrobat Reader does not support forms with file input controls");
/* 458 */       q.c(true);
/*     */     } 
/*     */     
/* 461 */     if (paramb.a.ai().hasAttribute("title")) {
/* 462 */       q.d(paramb.a.ai().getAttribute("title"));
/*     */     }
/*     */     
/* 465 */     m m1 = q.l().get(0);
/*     */     
/* 467 */     Rectangle2D rectangle2D = k.a(b.a(paramb), paramb.a, b.b(paramb), b.c(paramb), this.b);
/* 468 */     org.a.c.h.a.h h1 = new org.a.c.h.a.h((float)rectangle2D.getMinX(), (float)rectangle2D.getMinY(), (float)rectangle2D.getWidth(), (float)rectangle2D.getHeight());
/*     */     
/* 470 */     m1.a(h1);
/* 471 */     m1.a(b.d(paramb));
/* 472 */     m1.b(true);
/*     */     
/* 474 */     b.d(paramb).i().add(m1);
/*     */   }
/*     */   
/*     */   public enum a {
/* 478 */     b(52),
/*     */     
/* 480 */     c(53),
/*     */     
/* 482 */     a(117),
/*     */     
/* 484 */     d(108),
/*     */     
/* 486 */     e(72),
/*     */     
/* 488 */     f(110);
/*     */     
/*     */     private final int g;
/*     */     
/*     */     a(int param1Int1) {
/* 493 */       this.g = param1Int1;
/*     */     }
/*     */     
/*     */     public static a a(com.d.c.a.c param1c) {
/* 497 */       if (param1c == com.d.c.a.c.bU) {
/* 498 */         return b;
/*     */       }
/* 500 */       if (param1c == com.d.c.a.c.bV) {
/* 501 */         return c;
/*     */       }
/* 503 */       if (param1c == com.d.c.a.c.aR) {
/* 504 */         return f;
/*     */       }
/* 506 */       if (param1c == com.d.c.a.c.o) {
/* 507 */         return d;
/*     */       }
/* 509 */       if (param1c == com.d.c.a.c.bS) {
/* 510 */         return a;
/*     */       }
/* 512 */       if (param1c == com.d.c.a.c.bT) {
/* 513 */         return e;
/*     */       }
/* 515 */       return b;
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
/*     */   public static q a(a parama, org.a.c.h.b paramb, j paramj) {
/*     */     String str;
/* 532 */     return a(str = "q\nBT\n1 0 0 1 15 20 Tm\n/OpenHTMLZap 100 Tf\n(" + (char)a.a(parama) + ") Tj\nET\nQ\n", paramb, paramj);
/*     */   }
/*     */   
/*     */   public static q a(String paramString, org.a.c.h.b paramb, j paramj) {
/*     */     q q;
/* 537 */     (q = new q(paramb)).a(new org.a.c.h.a.h(100.0F, 100.0F));
/* 538 */     OutputStream outputStream = null;
/*     */     
/*     */     try {
/* 541 */       (outputStream = q.d().b()).write(paramString.getBytes("ASCII"));
/* 542 */     } catch (IOException iOException) {
/* 543 */       throw new w.a("createCheckboxAppearance", iOException);
/*     */     } finally {
/*     */       try {
/* 546 */         if (outputStream != null)
/* 547 */           outputStream.close(); 
/* 548 */       } catch (IOException iOException) {}
/*     */     } 
/*     */ 
/*     */     
/* 552 */     q.a(paramj);
/* 553 */     return q;
/*     */   }
/*     */ 
/*     */   
/*     */   private static s a(String paramString) {
/* 558 */     byte[] arrayOfByte = paramString.getBytes("UTF-16BE");
/*     */     ByteArrayOutputStream byteArrayOutputStream;
/* 560 */     (byteArrayOutputStream = new ByteArrayOutputStream(arrayOfByte.length + 2)).write(254);
/* 561 */     byteArrayOutputStream.write(255);
/*     */     
/*     */     try {
/* 564 */       byteArrayOutputStream.write(arrayOfByte);
/*     */     }
/* 566 */     catch (IOException iOException) {
/*     */ 
/*     */       
/* 569 */       throw new RuntimeException(iOException);
/*     */     } 
/* 571 */     arrayOfByte = byteArrayOutputStream.toByteArray();
/*     */     s s;
/* 573 */     return s = new s(arrayOfByte);
/*     */   }
/*     */   
/*     */   private void a(org.a.c.h.g.e.d paramd, b paramb, f paramf) {
/* 577 */     f f1 = new f(paramd);
/*     */     
/*     */     d d1;
/* 580 */     d.a(d1 = this.g.get(paramb.a.ai().getAttribute("name")), (j)f1);
/*     */     
/* 582 */     f1.c(d.d(d1));
/*     */     
/* 584 */     if (paramb.a.ai().hasAttribute("required")) {
/* 585 */       f1.e(true);
/*     */     }
/*     */     
/* 588 */     if (paramb.a.ai().hasAttribute("readonly")) {
/* 589 */       f1.d(true);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     org.a.c.b.a a;
/*     */ 
/*     */     
/* 597 */     (a = new org.a.c.b.a()).a((org.a.c.b.b)a(paramb.a.ai().getAttribute("value")));
/* 598 */     f1.i().a(j.cC, (org.a.c.b.b)a);
/*     */     
/* 600 */     if (paramb.a.ai().hasAttribute("title")) {
/* 601 */       f1.d(paramb.a.ai().getAttribute("title"));
/*     */     }
/*     */     
/* 604 */     j j = j.a("0");
/*     */     
/* 606 */     if (paramb.a.ai().hasAttribute("checked")) {
/* 607 */       f1.i().a(j.l, (org.a.c.b.b)j);
/* 608 */       f1.i().a(j.dU, (org.a.c.b.b)j);
/* 609 */       f1.i().a(j.aL, (org.a.c.b.b)j);
/*     */     } else {
/* 611 */       f1.i().a(j.l, (org.a.c.b.b)j.cB);
/* 612 */       f1.i().a(j.dU, (org.a.c.b.b)j.cB);
/* 613 */       f1.i().a(j.aL, (org.a.c.b.b)j.cB);
/*     */     } 
/*     */     
/* 616 */     Rectangle2D rectangle2D = k.a(b.a(paramb), paramb.a, b.b(paramb), b.c(paramb), this.b);
/* 617 */     org.a.c.h.a.h h1 = new org.a.c.h.a.h((float)rectangle2D.getMinX(), (float)rectangle2D.getMinY(), (float)rectangle2D.getWidth(), (float)rectangle2D.getHeight());
/*     */     
/*     */     m m1;
/* 620 */     (m1 = f1.l().get(0)).a(h1);
/* 621 */     m1.a(b.d(paramb));
/* 622 */     m1.b(true);
/*     */     
/* 624 */     a a1 = a.a(paramb.a.a().e(com.d.c.a.a.n));
/*     */     
/*     */     n n;
/* 627 */     (n = new n(new org.a.c.b.d())).a(String.valueOf((char)a.a(a1)));
/* 628 */     m1.a(n);
/*     */     
/*     */     org.a.c.b.d d2;
/* 631 */     (d2 = new org.a.c.b.d()).a(j, (org.a.c.h.a.c)this.a.a(a1));
/* 632 */     d2.a(j.cB, (org.a.c.h.a.c)this.a.a());
/*     */     o o1;
/* 634 */     (o1 = new o()).a().a(j.co, (org.a.c.b.b)d2);
/* 635 */     m1.a(o1);
/*     */     
/* 637 */     b.d(paramb).i().add(m1);
/*     */   }
/*     */   
/*     */   private void a(List<b> paramList, org.a.c.h.g.e.d paramd, f paramf) {
/* 641 */     String str = ((b)paramList.get(0)).a.ai().getAttribute("name");
/* 642 */     n n = new n(paramd);
/*     */     
/*     */     d d1;
/* 645 */     d.a(d1 = this.g.get(str), (j)n);
/*     */     
/* 647 */     n.c(d.d(d1));
/*     */     
/* 649 */     ArrayList<String> arrayList = new ArrayList(paramList.size());
/* 650 */     for (b b1 : paramList) {
/* 651 */       arrayList.add(b1.a.ai().getAttribute("value"));
/*     */     }
/* 653 */     n.a(arrayList);
/*     */     
/* 655 */     ArrayList<m> arrayList1 = new ArrayList(paramList.size());
/*     */     
/* 657 */     byte b = 0;
/*     */     Iterator<b> iterator;
/* 659 */     for (iterator = paramList.iterator(); iterator.hasNext(); ) {
/* 660 */       b b1; Rectangle2D rectangle2D = k.a(b.a(b1 = iterator.next()), b1.a, b.b(b1), b.c(b1), this.b);
/* 661 */       org.a.c.h.a.h h1 = new org.a.c.h.a.h((float)rectangle2D.getMinX(), (float)rectangle2D.getMinY(), (float)rectangle2D.getWidth(), (float)rectangle2D.getHeight());
/*     */       
/*     */       m m1;
/*     */       
/* 665 */       (m1 = new m()).a(h1);
/* 666 */       m1.a(b.d(b1));
/* 667 */       m1.b(true);
/*     */       
/*     */       org.a.c.b.d d2;
/* 670 */       (d2 = new org.a.c.b.d()).a(j.a(b), (org.a.c.h.a.c)this.a.c());
/* 671 */       d2.a(j.cB, (org.a.c.h.a.c)this.a.b());
/*     */       o o1;
/* 673 */       (o1 = new o()).a().a(j.co, (org.a.c.b.b)d2);
/*     */       
/* 675 */       if (b1.a.ai().hasAttribute("checked")) {
/* 676 */         m1.b().a(j.l, (org.a.c.b.b)j.a(b));
/*     */       } else {
/* 678 */         m1.b().a(j.l, (org.a.c.b.b)j.cB);
/*     */       } 
/*     */       
/* 681 */       m1.a(o1);
/*     */       
/* 683 */       arrayList1.add(m1);
/* 684 */       b.d(b1).i().add(m1);
/*     */       
/* 686 */       b++;
/*     */     } 
/*     */     
/* 689 */     n.b(arrayList1);
/*     */     
/* 691 */     for (iterator = paramList.iterator(); iterator.hasNext();) {
/* 692 */       if ((b1 = iterator.next()).a.ai().hasAttribute("checked")) {
/* 693 */         n.a(b1.a.ai().getAttribute("value"));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(org.a.c.h.g.e.d paramd, int paramInt, b paramb, f paramf) {
/*     */     m m1;
/* 703 */     (m1 = new m(paramd)).a(true);
/*     */     
/* 705 */     if (paramb.a.ai().hasAttribute("name")) {
/*     */       
/* 707 */       q q = new q(paramd);
/*     */       
/*     */       d d1;
/* 710 */       d.a(d1 = this.g.get(paramb.a.ai().getAttribute("name")), (j)q);
/*     */       
/* 712 */       q.c(d.d(d1));
/*     */       
/* 714 */       String str = paramb.a.ai().getAttribute("value");
/*     */       
/* 716 */       q.b(str);
/* 717 */       q.a(str);
/*     */       
/*     */       m m3;
/*     */       
/* 721 */       (m3 = q.l().get(0)).a(b.d(paramb));
/* 722 */       m3.a(true);
/* 723 */       m3.a(new org.a.c.h.a.h(0.0F, 0.0F, 1.0F, 1.0F));
/* 724 */       b.d(paramb).i().add(m3);
/*     */     } 
/*     */ 
/*     */     
/* 728 */     m1.c("OpenHTMLCtrl" + paramInt);
/*     */     
/* 730 */     m m2 = m1.l().get(0);
/*     */     
/* 732 */     Rectangle2D rectangle2D = k.a(b.a(paramb), paramb.a, b.b(paramb), b.c(paramb), this.b);
/* 733 */     org.a.c.h.a.h h1 = new org.a.c.h.a.h((float)rectangle2D.getMinX(), (float)rectangle2D.getMinY(), (float)rectangle2D.getWidth(), (float)rectangle2D.getHeight());
/*     */     
/* 735 */     m2.a(h1);
/* 736 */     m2.a(b.d(paramb));
/*     */     
/* 738 */     org.a.c.h.a.a a = new org.a.c.h.a.a();
/* 739 */     for (Iterator<d> iterator = this.g.values().iterator(); iterator.hasNext();) {
/* 740 */       if (d.a(d1 = iterator.next())) {
/* 741 */         a.add(d.b(d1));
/*     */       }
/*     */     } 
/*     */     
/* 745 */     if (paramb.a.ai().getAttribute("type").equals("reset")) {
/*     */       k k;
/* 747 */       (k = new k()).a(a.a());
/* 748 */       m2.a((org.a.c.h.g.a.a)k);
/*     */     } else {
/* 750 */       org.a.c.h.a.a.a a1 = org.a.c.h.a.a.a.a((org.a.c.b.b)new s(this.c.getAttribute("action")));
/*     */       
/*     */       m m3;
/* 753 */       (m3 = new m()).a(a.a());
/* 754 */       m3.a(a1);
/*     */       
/* 756 */       if (!this.c.getAttribute("method").equalsIgnoreCase("post")) {
/*     */         
/* 758 */         l.d(Level.WARNING, "Using GET request method for form. You probably meant to add a method=\"post\" attribute to your form");
/* 759 */         m3.a(12);
/*     */       } else {
/* 761 */         m3.a(4);
/*     */       } 
/*     */       
/* 764 */       m2.a((org.a.c.h.g.a.a)m3);
/*     */     } 
/*     */     
/* 767 */     paramd.c().add(m1);
/* 768 */     b.d(paramb).i().add(m2);
/*     */   }
/*     */   
/*     */   public final int a(org.a.c.h.g.e.d paramd, int paramInt, f paramf) {
/* 772 */     a();
/*     */     
/* 774 */     paramInt = paramInt;
/*     */     
/* 776 */     for (c c : this.d) {
/* 777 */       paramInt++;
/*     */       
/*     */       b b;
/*     */       
/*     */       Element element;
/* 782 */       if (((element = (b = c.a(c)).a.ai()).getNodeName().equals("input") && element
/* 783 */         .getAttribute("type").equals("text")) || element
/* 784 */         .getNodeName().equals("textarea") || (element
/* 785 */         .getNodeName().equals("input") && element
/* 786 */         .getAttribute("type").equals("password")) || (element
/* 787 */         .getNodeName().equals("input") && element
/* 788 */         .getAttribute("type").equals("file"))) {
/*     */ 
/*     */         
/* 791 */         c(c, b, paramd, paramf); continue;
/* 792 */       }  if ((element.getNodeName().equals("select") && 
/* 793 */         !element.hasAttribute("multiple")) || element
/* 794 */         .getNodeName().equals("openhtmltopdf-combo")) {
/*     */         
/* 796 */         b(c, b, paramd, paramf); continue;
/* 797 */       }  if (element.getNodeName().equals("select") && element
/* 798 */         .hasAttribute("multiple")) {
/*     */         
/* 800 */         a(c, b, paramd, paramf); continue;
/* 801 */       }  if (element.getNodeName().equals("input") && element
/* 802 */         .getAttribute("type").equals("checkbox")) {
/*     */         
/* 804 */         a(paramd, b, paramf); continue;
/* 805 */       }  if (element.getNodeName().equals("input") && element
/* 806 */         .getAttribute("type").equals("hidden")) {
/*     */         
/* 808 */         a(b, paramd); continue;
/* 809 */       }  if (element.getNodeName().equals("input") && element
/* 810 */         .getAttribute("type").equals("radio")) {
/*     */         List<b> list;
/*     */ 
/*     */         
/* 814 */         if ((list = this.f.get(element.getAttribute("name"))) == null) {
/* 815 */           list = new ArrayList();
/* 816 */           this.f.put(element.getAttribute("name"), list);
/*     */         } 
/*     */         
/* 819 */         list.add(b); continue;
/* 820 */       }  if ((element.getNodeName().equals("input") && element
/* 821 */         .getAttribute("type").equals("submit")) || (element
/* 822 */         .getNodeName().equals("button") && 
/* 823 */         !element.getAttribute("type").equals("button")) || (element
/* 824 */         .getNodeName().equals("input") && element
/* 825 */         .getAttribute("type").equals("reset")))
/*     */       {
/*     */         
/* 828 */         this.e.add(b);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 833 */     for (List<b> list : this.f.values()) {
/* 834 */       paramInt++;
/* 835 */       a(list, paramd, paramf);
/*     */     } 
/*     */ 
/*     */     
/* 839 */     for (b b : this.e) {
/* 840 */       paramInt++;
/* 841 */       a(paramd, paramInt, b, paramf);
/*     */     } 
/*     */     
/* 844 */     a(paramd);
/*     */     
/* 846 */     return paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\h\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */