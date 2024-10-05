/*     */ package org.a.b.f;
/*     */ 
/*     */ import java.awt.geom.GeneralPath;
/*     */ import java.io.Closeable;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.a.b.b;
/*     */ import org.a.b.h.a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ap
/*     */   implements Closeable, b
/*     */ {
/*  41 */   private int b = -1;
/*  42 */   private int c = -1;
/*  43 */   protected Map<String, an> a = new HashMap<String, an>();
/*     */   private final ak d;
/*     */   private Map<String, Integer> e;
/*  46 */   private final List<String> f = new ArrayList<String>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ap(ak paramak) {
/*  55 */     this.d = paramak;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/*  61 */     this.d.close();
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
/*     */   void a(float paramFloat) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final void a(an paraman) {
/*  88 */     this.a.put(paraman.E(), paraman);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Collection<an> h() {
/*  98 */     return this.a.values();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Map<String, an> i() {
/* 108 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final synchronized byte[] b(an paraman) {
/* 119 */     long l = this.d.e();
/* 120 */     this.d.a(paraman.D());
/*     */ 
/*     */     
/* 123 */     byte[] arrayOfByte = this.d.d((int)paraman.C());
/*     */ 
/*     */     
/* 126 */     this.d.a(l);
/* 127 */     return arrayOfByte;
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
/*     */   protected final synchronized an d(String paramString) {
/*     */     an an;
/* 140 */     if ((an = this.a.get(paramString)) != null && !an.F())
/*     */     {
/* 142 */       c(an);
/*     */     }
/* 144 */     return an;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final z j() {
/* 155 */     return (z)d("name");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final ag k() {
/* 166 */     return (ag)d("post");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final aa l() {
/* 177 */     return (aa)d("OS/2");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final w m() {
/* 188 */     return (w)d("maxp");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final q n() {
/* 199 */     return (q)d("head");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final r o() {
/* 210 */     return (r)d("hhea");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final s p() {
/* 221 */     return (s)d("hmtx");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final t q() {
/* 232 */     return (t)d("loca");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public p e() {
/* 243 */     return (p)d("glyf");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final f r() {
/* 254 */     return (f)d("cmap");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final aq s() {
/* 265 */     return (aq)d("vhea");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final ar t() {
/* 276 */     return (ar)d("vmtx");
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private n a() {
/* 309 */     return (n)d("GSUB");
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
/*     */   public final InputStream u() {
/* 323 */     return this.d.f();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final long v() {
/* 334 */     return this.d.g();
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
/*     */   final void c(an paraman) {
/* 348 */     synchronized (this.d) {
/*     */ 
/*     */       
/* 351 */       long l = this.d.e();
/* 352 */       this.d.a(paraman.D());
/* 353 */       paraman.a(this, this.d);
/*     */       
/* 355 */       this.d.a(l);
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int w() {
/* 367 */     if (this.b == -1) {
/*     */       w w;
/*     */       
/* 370 */       if ((w = m()) != null) {
/*     */         
/* 372 */         this.b = w.n();
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 377 */         this.b = 0;
/*     */       } 
/*     */     } 
/* 380 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int x() {
/* 391 */     if (this.c == -1) {
/*     */       q q;
/*     */       
/* 394 */       if ((q = n()) != null) {
/*     */         
/* 396 */         this.c = q.k();
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 401 */         this.c = 0;
/*     */       } 
/*     */     } 
/* 404 */     return this.c;
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
/*     */   public final int a(int paramInt) {
/*     */     s s;
/* 417 */     if ((s = p()) != null)
/*     */     {
/* 419 */       return s.a(paramInt);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 424 */     return 250;
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
/*     */   public final String b() {
/* 452 */     if (j() != null)
/*     */     {
/* 454 */       return j().d();
/*     */     }
/*     */ 
/*     */     
/* 458 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private synchronized void f() {
/* 464 */     if (this.e == null && k() != null) {
/*     */       String[] arrayOfString;
/*     */       
/* 467 */       if ((arrayOfString = k().i()) != null) {
/*     */         
/* 469 */         this.e = new HashMap<String, Integer>(arrayOfString.length);
/* 470 */         for (byte b1 = 0; b1 < arrayOfString.length; b1++)
/*     */         {
/* 472 */           this.e.put(arrayOfString[b1], Integer.valueOf(b1));
/*     */         }
/*     */         
/*     */         return;
/*     */       } 
/* 477 */       this.e = new HashMap<String, Integer>();
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
/*     */   @Deprecated
/*     */   public final d y() {
/* 492 */     return b(true);
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
/*     */   @Deprecated
/*     */   private d b(boolean paramBoolean) {
/* 506 */     return c(true);
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
/*     */   public final c z() {
/* 519 */     return a(true);
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
/*     */   public final c a(boolean paramBoolean) {
/* 533 */     d d = c(paramBoolean);
/* 534 */     if (!this.f.isEmpty()) {
/*     */       n n;
/*     */       
/* 537 */       if ((n = a()) != null)
/*     */       {
/* 539 */         return new ai(d, n, 
/* 540 */             Collections.unmodifiableList(this.f));
/*     */       }
/*     */     } 
/* 543 */     return d;
/*     */   }
/*     */ 
/*     */   
/*     */   private d c(boolean paramBoolean) {
/*     */     f f;
/* 549 */     if ((f = r()) == null) {
/*     */       
/* 551 */       if (paramBoolean)
/*     */       {
/* 553 */         throw new IOException("The TrueType font " + b() + " does not contain a 'cmap' table");
/*     */       }
/*     */ 
/*     */       
/* 557 */       return null;
/*     */     } 
/*     */ 
/*     */     
/*     */     d d;
/*     */     
/* 563 */     if ((d = f.a(0, 4)) == null)
/*     */     {
/* 565 */       d = f.a(3, 10);
/*     */     }
/*     */     
/* 568 */     if (d == null)
/*     */     {
/* 570 */       d = f.a(0, 3);
/*     */     }
/*     */     
/* 573 */     if (d == null)
/*     */     {
/* 575 */       d = f.a(3, 1);
/*     */     }
/*     */     
/* 578 */     if (d == null)
/*     */     {
/*     */ 
/*     */       
/* 582 */       d = f.a(3, 0);
/*     */     }
/*     */     
/* 585 */     if (d == null) {
/*     */       
/* 587 */       if (paramBoolean)
/*     */       {
/* 589 */         throw new IOException("The TrueType font does not contain a Unicode cmap");
/*     */       }
/* 591 */       if ((f.a()).length > 0)
/*     */       {
/*     */         
/* 594 */         d = f.a()[0];
/*     */       }
/*     */     } 
/* 597 */     return d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int e(String paramString) {
/* 607 */     f();
/* 608 */     if (this.e != null) {
/*     */       Integer integer;
/*     */       
/* 611 */       if ((integer = this.e.get(paramString)) != null && integer.intValue() > 0 && integer.intValue() < m().n())
/*     */       {
/* 613 */         return integer.intValue();
/*     */       }
/*     */     } 
/*     */     
/*     */     int i;
/*     */     
/* 619 */     if ((i = f(paramString)) >= 0) {
/*     */       c c;
/*     */       
/* 622 */       return (c = a(false)).a(i);
/*     */     } 
/*     */     
/* 625 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int f(String paramString) {
/* 633 */     if (paramString.startsWith("uni") && paramString.length() == 7) {
/*     */       
/* 635 */       int i = paramString.length();
/* 636 */       StringBuilder stringBuilder = new StringBuilder();
/*     */       
/*     */       try {
/* 639 */         for (byte b1 = 3; b1 + 4 <= i; b1 += 4) {
/*     */           int j;
/*     */           
/* 642 */           if ((j = Integer.parseInt(paramString.substring(b1, b1 + 4), 16)) <= 55295 || j >= 57344)
/*     */           {
/* 644 */             stringBuilder.append((char)j);
/*     */           }
/*     */         } 
/*     */         String str;
/* 648 */         if ((str = stringBuilder.toString()).length() == 0)
/*     */         {
/* 650 */           return -1;
/*     */         }
/* 652 */         return str.codePointAt(0);
/*     */       }
/* 654 */       catch (NumberFormatException numberFormatException) {
/*     */         
/* 656 */         return -1;
/*     */       } 
/*     */     } 
/* 659 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public GeneralPath c(String paramString) {
/* 665 */     int i = e(paramString);
/*     */     
/*     */     k k;
/*     */     
/* 669 */     if ((k = e().a(i)) == null)
/*     */     {
/* 671 */       return new GeneralPath();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 676 */     return k.b();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float a(String paramString) {
/* 683 */     Integer integer = Integer.valueOf(e(paramString));
/* 684 */     return a(integer.intValue());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean b(String paramString) {
/* 690 */     return (e(paramString) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final a c() {
/* 696 */     short s1 = n().n();
/* 697 */     short s2 = n().m();
/* 698 */     short s3 = n().p();
/* 699 */     short s4 = n().o();
/* 700 */     float f = 1000.0F / x();
/* 701 */     return new a(s1 * f, s3 * f, s2 * f, s4 * f);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final List<Number> d() {
/* 707 */     float f = 1000.0F / x();
/* 708 */     return Arrays.asList(new Number[] { Float.valueOf(0.001F * f), Integer.valueOf(0), Integer.valueOf(0), Float.valueOf(0.001F * f), Integer.valueOf(0), Integer.valueOf(0) });
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*     */     try {
/* 746 */       if (j() != null)
/*     */       {
/* 748 */         return j().d();
/*     */       }
/*     */ 
/*     */       
/* 752 */       return "(null)";
/*     */     
/*     */     }
/* 755 */     catch (IOException iOException) {
/*     */       
/* 757 */       return "(null - " + iOException.getMessage() + ")";
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\f\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */