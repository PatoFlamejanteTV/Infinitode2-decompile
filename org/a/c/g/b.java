/*      */ package org.a.c.g;
/*      */ 
/*      */ import com.a.a.a.am;
/*      */ import com.b.a.a.aa;
/*      */ import java.io.Closeable;
/*      */ import java.io.InputStream;
/*      */ import java.io.OutputStream;
/*      */ import java.security.MessageDigest;
/*      */ import java.security.NoSuchAlgorithmException;
/*      */ import java.text.DecimalFormat;
/*      */ import java.text.DecimalFormatSymbols;
/*      */ import java.text.NumberFormat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.Deque;
/*      */ import java.util.HashSet;
/*      */ import java.util.Hashtable;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Locale;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import org.a.a.a.a;
/*      */ import org.a.a.a.c;
/*      */ import org.a.c.b.a;
/*      */ import org.a.c.b.c;
/*      */ import org.a.c.b.d;
/*      */ import org.a.c.b.e;
/*      */ import org.a.c.b.f;
/*      */ import org.a.c.b.i;
/*      */ import org.a.c.b.j;
/*      */ import org.a.c.b.k;
/*      */ import org.a.c.b.m;
/*      */ import org.a.c.b.n;
/*      */ import org.a.c.b.p;
/*      */ import org.a.c.b.s;
/*      */ import org.a.c.b.t;
/*      */ import org.a.c.b.u;
/*      */ import org.a.c.f.h;
/*      */ import org.a.c.h.c.k;
/*      */ import org.a.c.h.d.a;
/*      */ import org.a.c.i.a;
/*      */ import org.a.c.i.c;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class b
/*      */   implements Closeable, u
/*      */ {
/*   80 */   private static final a e = c.a(b.class);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   85 */   public static final byte[] a = "<<".getBytes(a.a);
/*      */ 
/*      */ 
/*      */   
/*   89 */   public static final byte[] b = ">>".getBytes(a.a);
/*      */ 
/*      */ 
/*      */   
/*   93 */   private static byte[] f = new byte[] { 32 };
/*      */ 
/*      */ 
/*      */   
/*   97 */   private static byte[] g = new byte[] { 37 };
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/*  102 */     "PDF-1.4".getBytes(a.a);
/*      */   }
/*      */ 
/*      */   
/*  106 */   private static byte[] h = new byte[] { -10, -28, -4, -33 };
/*      */ 
/*      */ 
/*      */   
/*  110 */   private static byte[] i = "%%EOF".getBytes(a.a);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  116 */   private static byte[] j = "R".getBytes(a.a);
/*      */ 
/*      */ 
/*      */   
/*  120 */   private static byte[] k = "xref".getBytes(a.a);
/*      */ 
/*      */ 
/*      */   
/*  124 */   private static byte[] l = "f".getBytes(a.a);
/*      */ 
/*      */ 
/*      */   
/*  128 */   private static byte[] m = "n".getBytes(a.a);
/*      */ 
/*      */ 
/*      */   
/*  132 */   private static byte[] n = "trailer".getBytes(a.a);
/*      */ 
/*      */ 
/*      */   
/*  136 */   private static byte[] o = "startxref".getBytes(a.a);
/*      */ 
/*      */ 
/*      */   
/*  140 */   private static byte[] p = "obj".getBytes(a.a);
/*      */ 
/*      */ 
/*      */   
/*  144 */   private static byte[] q = "endobj".getBytes(a.a);
/*      */ 
/*      */ 
/*      */   
/*  148 */   public static final byte[] c = "[".getBytes(a.a);
/*      */ 
/*      */ 
/*      */   
/*  152 */   public static final byte[] d = "]".getBytes(a.a);
/*      */ 
/*      */ 
/*      */   
/*  156 */   private static byte[] r = "stream".getBytes(a.a);
/*      */ 
/*      */ 
/*      */   
/*  160 */   private static byte[] s = "endstream".getBytes(a.a);
/*      */   
/*  162 */   private final NumberFormat t = new DecimalFormat("0000000000", 
/*  163 */       DecimalFormatSymbols.getInstance(Locale.US));
/*      */ 
/*      */   
/*  166 */   private final NumberFormat u = new DecimalFormat("00000", 
/*  167 */       DecimalFormatSymbols.getInstance(Locale.US));
/*      */ 
/*      */   
/*      */   private OutputStream v;
/*      */ 
/*      */   
/*      */   private a w;
/*      */ 
/*      */   
/*  176 */   private long x = 0L;
/*      */ 
/*      */   
/*  179 */   private long y = 0L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  185 */   private final Map<org.a.c.b.b, n> z = new Hashtable<org.a.c.b.b, n>();
/*  186 */   private final Map<n, org.a.c.b.b> A = new Hashtable<n, org.a.c.b.b>();
/*      */ 
/*      */   
/*  189 */   private final List<c> B = new ArrayList<c>();
/*  190 */   private final Set<org.a.c.b.b> C = new HashSet<org.a.c.b.b>();
/*      */ 
/*      */   
/*  193 */   private final Deque<org.a.c.b.b> D = new LinkedList<org.a.c.b.b>();
/*      */ 
/*      */   
/*  196 */   private final Set<org.a.c.b.b> E = new HashSet<org.a.c.b.b>();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  204 */   private final Set<org.a.c.b.b> F = new HashSet<org.a.c.b.b>();
/*      */   
/*  206 */   private n G = null;
/*  207 */   private org.a.c.h.b H = null;
/*  208 */   private a I = null;
/*      */   
/*      */   private boolean J = false;
/*      */   
/*      */   private boolean K = false;
/*      */   
/*      */   private boolean L = false;
/*      */   
/*      */   private long M;
/*      */   
/*      */   private long N;
/*      */   
/*      */   private long O;
/*      */   
/*      */   private long P;
/*      */   
/*      */   private OutputStream Q;
/*      */   
/*      */   private aa.a R;
/*      */   private a S;
/*      */   
/*      */   public b(OutputStream paramOutputStream) {
/*  230 */     a(paramOutputStream);
/*  231 */     a(new a(this.v));
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
/*      */   private void a(c paramc) {
/*  301 */     d().add(paramc);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void close() {
/*  312 */     if (b() != null)
/*      */     {
/*  314 */       b().close();
/*      */     }
/*  316 */     if (this.Q != null)
/*      */     {
/*  318 */       this.Q.close();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private long a() {
/*  329 */     return this.y;
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
/*      */   private a b() {
/*  359 */     return this.w;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private long c() {
/*  369 */     return this.x;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private List<c> d() {
/*  378 */     return this.B;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(long paramLong) {
/*  388 */     this.y = paramLong;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(OutputStream paramOutputStream) {
/*  398 */     this.v = paramOutputStream;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(a parama) {
/*  408 */     this.w = parama;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void b(long paramLong) {
/*  418 */     this.x = paramLong;
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
/*      */   private void b(e parame) {
/*  431 */     d d1, d2 = (d1 = parame.h()).d(j.di);
/*  432 */     d d3 = d1.d(j.bI);
/*  433 */     d1 = d1.d(j.aS);
/*  434 */     if (d2 != null)
/*      */     {
/*  436 */       a((org.a.c.b.b)d2);
/*      */     }
/*  438 */     if (d3 != null)
/*      */     {
/*  440 */       a((org.a.c.b.b)d3);
/*      */     }
/*      */     
/*  443 */     e();
/*  444 */     this.J = false;
/*  445 */     if (d1 != null)
/*      */     {
/*  447 */       a((org.a.c.b.b)d1);
/*      */     }
/*      */     
/*  450 */     e();
/*      */   }
/*      */ 
/*      */   
/*      */   private void e() {
/*  455 */     while (this.D.size() > 0) {
/*      */       
/*  457 */       org.a.c.b.b b1 = this.D.removeFirst();
/*  458 */       this.C.remove(b1);
/*  459 */       b(b1);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void a(org.a.c.b.b paramb) {
/*      */     org.a.c.b.b b1;
/*  466 */     if (b1 = paramb instanceof m)
/*      */     {
/*  468 */       b1 = ((m)b1).a();
/*      */     }
/*      */     
/*  471 */     if (!this.E.contains(paramb) && 
/*  472 */       !this.C.contains(paramb) && 
/*  473 */       !this.F.contains(b1)) {
/*      */       
/*  475 */       org.a.c.b.b b2 = null;
/*  476 */       n n1 = null;
/*  477 */       if (b1 != null)
/*      */       {
/*  479 */         n1 = this.z.get(b1);
/*      */       }
/*  481 */       if (n1 != null)
/*      */       {
/*  483 */         b2 = this.A.get(n1);
/*      */       }
/*  485 */       if (b1 != null && this.z.containsKey(b1) && paramb instanceof t && 
/*  486 */         !((t)paramb).c() && b2 instanceof t && 
/*  487 */         !((t)b2).c()) {
/*      */         return;
/*      */       }
/*      */       
/*  491 */       this.D.add(paramb);
/*  492 */       this.C.add(paramb);
/*  493 */       if (b1 != null)
/*      */       {
/*  495 */         this.F.add(b1);
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
/*      */   private void b(org.a.c.b.b paramb) {
/*  509 */     this.E.add(paramb);
/*      */     
/*  511 */     this.G = c(paramb);
/*      */     
/*  513 */     a(new c(b().a(), paramb, this.G));
/*      */     
/*  515 */     b().write(String.valueOf(this.G.b()).getBytes(a.d));
/*  516 */     b().write(f);
/*  517 */     b().write(String.valueOf(this.G.a()).getBytes(a.d));
/*  518 */     b().write(f);
/*  519 */     b().write(p);
/*  520 */     b().c();
/*  521 */     paramb.a(this);
/*  522 */     b().c();
/*  523 */     b().write(q);
/*  524 */     b().c();
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
/*      */   private void c(e parame) {
/*      */     String str;
/*  537 */     if (this.I != null) {
/*      */       
/*  539 */       str = "%FDF-" + Float.toString(parame.b());
/*      */     }
/*      */     else {
/*      */       
/*  543 */       str = "%PDF-" + Float.toString(str.b());
/*      */     } 
/*  545 */     b().write(str.getBytes(a.d));
/*      */     
/*  547 */     b().c();
/*  548 */     b().write(g);
/*  549 */     b().write(h);
/*  550 */     b().c();
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
/*      */   private void d(e parame) {
/*  563 */     b().write(n);
/*  564 */     b().c();
/*      */     
/*  566 */     d d = parame.h();
/*      */     
/*  568 */     Collections.sort(d());
/*  569 */     c c = d().get(d().size() - 1);
/*  570 */     d.a(j.dr, c.b().b() + 1L);
/*      */ 
/*      */ 
/*      */     
/*  574 */     d.m(j.cU);
/*      */     
/*  576 */     if (!parame.m())
/*      */     {
/*  578 */       d.m(j.eg);
/*      */     }
/*      */     
/*  581 */     d.m(j.aG);
/*      */     
/*      */     a a1;
/*  584 */     if ((a1 = d.f(j.bA)) != null)
/*      */     {
/*  586 */       a1.a(true);
/*      */     }
/*      */     
/*  589 */     d.a(this);
/*      */   }
/*      */ 
/*      */   
/*      */   private void a(e parame, long paramLong) {
/*  594 */     if (parame.m() || paramLong != -1L) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  601 */       h h = new h(parame);
/*      */       
/*      */       List<c> list;
/*      */       
/*  605 */       for (c c : list = d())
/*      */       {
/*  607 */         h.a(c);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       d d;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  618 */       (d = parame.h()).m(j.cU);
/*      */       
/*  620 */       h.a(d);
/*      */ 
/*      */       
/*  623 */       h.a(a() + 2L);
/*      */       
/*  625 */       b(b().a());
/*  626 */       p p = h.a();
/*  627 */       b((org.a.c.b.b)p);
/*      */     } 
/*      */     
/*  630 */     if (!parame.m() || paramLong != -1L) {
/*      */       d d;
/*      */       
/*  633 */       (d = parame.h()).a(j.cU, parame.l());
/*  634 */       if (paramLong != -1L) {
/*      */         
/*  636 */         j j = j.eg;
/*  637 */         d.m(j);
/*  638 */         d.a(j, c());
/*      */       } 
/*  640 */       f();
/*  641 */       d(parame);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void f() {
/*  648 */     a(c.a());
/*      */ 
/*      */     
/*  651 */     Collections.sort(d());
/*      */ 
/*      */     
/*  654 */     b(b().a());
/*      */     
/*  656 */     b().write(k);
/*  657 */     b().c();
/*      */ 
/*      */     
/*      */     Long[] arrayOfLong;
/*      */     
/*  662 */     int i = (arrayOfLong = a(d())).length;
/*  663 */     byte b1 = 0;
/*  664 */     byte b2 = 0;
/*  665 */     while (b1 < i && i % 2 == 0) {
/*      */       
/*  667 */       a(arrayOfLong[b1].longValue(), arrayOfLong[b1 + 1].longValue());
/*      */       
/*  669 */       for (byte b3 = 0; b3 < arrayOfLong[b1 + 1].longValue(); b3++)
/*      */       {
/*  671 */         b(this.B.get(b2++));
/*      */       }
/*  673 */       b1 += 2;
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
/*      */   private void a(long paramLong1, long paramLong2) {
/*  809 */     b().write(String.valueOf(paramLong1).getBytes(a.d));
/*  810 */     b().write(f);
/*  811 */     b().write(String.valueOf(paramLong2).getBytes(a.d));
/*  812 */     b().c();
/*      */   }
/*      */ 
/*      */   
/*      */   private void b(c paramc) {
/*  817 */     String str1 = this.t.format(paramc.c());
/*  818 */     String str2 = this.u.format(paramc.b().a());
/*  819 */     b().write(str1.getBytes(a.d));
/*  820 */     b().write(f);
/*  821 */     b().write(str2.getBytes(a.d));
/*  822 */     b().write(f);
/*  823 */     b().write(paramc.d() ? l : m);
/*  824 */     b().b();
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
/*      */   private static Long[] a(List<c> paramList) {
/*  847 */     long l1 = -2L;
/*  848 */     long l2 = 1L;
/*      */     
/*  850 */     ArrayList<Long> arrayList = new ArrayList();
/*  851 */     for (Iterator<c> iterator = paramList.iterator(); iterator.hasNext(); ) {
/*      */       c c;
/*      */       long l;
/*  854 */       if ((l = (int)((c)(c = (c)iterator.next())).b().b()) == l1 + 1L) {
/*      */         
/*  856 */         l2++;
/*  857 */         l1 = l; continue;
/*      */       } 
/*  859 */       if (l1 == -2L) {
/*      */         
/*  861 */         l1 = l;
/*      */         
/*      */         continue;
/*      */       } 
/*  865 */       arrayList.add(Long.valueOf(l1 - l2 + 1L));
/*  866 */       arrayList.add(Long.valueOf(l2));
/*  867 */       l1 = l;
/*  868 */       l2 = 1L;
/*      */     } 
/*      */ 
/*      */     
/*  872 */     if (paramList.size() > 0) {
/*      */       
/*  874 */       arrayList.add(Long.valueOf(l1 - l2 + 1L));
/*  875 */       arrayList.add(Long.valueOf(l2));
/*      */     } 
/*  877 */     return arrayList.<Long>toArray(new Long[arrayList.size()]);
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
/*      */   private n c(org.a.c.b.b paramb) {
/*      */     org.a.c.b.b b1;
/*  890 */     if (b1 = paramb instanceof m)
/*      */     {
/*  892 */       b1 = ((m)paramb).a();
/*      */     }
/*      */     
/*      */     n n1;
/*      */     
/*  897 */     if ((n1 = this.z.get(paramb)) == null && b1 != null)
/*      */     {
/*  899 */       n1 = this.z.get(b1);
/*      */     }
/*  901 */     if (n1 == null) {
/*      */       
/*  903 */       a(a() + 1L);
/*  904 */       n1 = new n(a(), 0);
/*  905 */       this.z.put(paramb, n1);
/*  906 */       if (b1 != null)
/*      */       {
/*  908 */         this.z.put(b1, n1);
/*      */       }
/*      */     } 
/*  911 */     return n1;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final Object a(a parama) {
/*  917 */     byte b1 = 0;
/*  918 */     b().write(c);
/*  919 */     for (Iterator<org.a.c.b.b> iterator = parama.iterator(); iterator.hasNext(); ) {
/*      */       org.a.c.b.b b2;
/*      */       
/*  922 */       if (b2 = iterator.next() instanceof d) {
/*      */         
/*  924 */         if (b2.g())
/*      */         {
/*  926 */           a((d)b2);
/*      */         }
/*      */         else
/*      */         {
/*  930 */           a(b2);
/*  931 */           d(b2);
/*      */         }
/*      */       
/*  934 */       } else if (b2 instanceof m) {
/*      */         
/*  936 */         org.a.c.b.b b3 = ((m)b2).a();
/*  937 */         if (this.J || b3 instanceof d || b3 == null)
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  943 */           a(b2);
/*  944 */           d(b2);
/*      */         }
/*      */         else
/*      */         {
/*  948 */           b3.a(this);
/*      */         }
/*      */       
/*  951 */       } else if (b2 == null) {
/*      */         
/*  953 */         k.a.a(this);
/*      */       }
/*      */       else {
/*      */         
/*  957 */         b2.a(this);
/*      */       } 
/*  959 */       b1++;
/*  960 */       if (iterator.hasNext()) {
/*      */         
/*  962 */         if (b1 % 10 == 0) {
/*      */           
/*  964 */           b().c();
/*      */           
/*      */           continue;
/*      */         } 
/*  968 */         b().write(f);
/*      */       } 
/*      */     } 
/*      */     
/*  972 */     b().write(d);
/*  973 */     b().c();
/*  974 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final Object a(c paramc) {
/*  980 */     paramc.a(b());
/*  981 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final Object a(d paramd) {
/*  987 */     if (!this.L) {
/*      */       
/*  989 */       org.a.c.b.b b1 = paramd.n(j.dN);
/*  990 */       if (j.dq.equals(b1) || j.aH.equals(b1))
/*      */       {
/*  992 */         this.L = true;
/*      */       }
/*      */     } 
/*  995 */     b().write(a);
/*  996 */     b().c();
/*  997 */     for (Iterator<Map.Entry> iterator = paramd.e().iterator(); iterator.hasNext();) {
/*      */ 
/*      */       
/* 1000 */       if ((b1 = (entry = iterator.next()).getValue()) != null) {
/*      */         
/* 1002 */         ((j)entry.getKey()).a(this);
/* 1003 */         b().write(f);
/* 1004 */         if (b1 instanceof d) {
/*      */           d d1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1013 */           if ((b1 = (d1 = (d)b1).n(j.ee)) != null && !j.ee.equals(entry.getKey()))
/*      */           {
/* 1015 */             b1.a(true);
/*      */           }
/*      */           
/* 1018 */           if ((b1 = d1.n(j.dg)) != null && !j.dg.equals(entry.getKey()))
/*      */           {
/* 1020 */             b1.a(true);
/*      */           }
/*      */ 
/*      */           
/* 1024 */           if (d1.g())
/*      */           {
/*      */ 
/*      */             
/* 1028 */             a(d1);
/*      */           }
/*      */           else
/*      */           {
/* 1032 */             a((org.a.c.b.b)d1);
/* 1033 */             d((org.a.c.b.b)d1);
/*      */           }
/*      */         
/* 1036 */         } else if (b1 instanceof m) {
/*      */           
/* 1038 */           org.a.c.b.b b2 = ((m)b1).a();
/* 1039 */           if (this.J || b2 instanceof d || b2 == null)
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 1045 */             a(b1);
/* 1046 */             d(b1);
/*      */           }
/*      */           else
/*      */           {
/* 1050 */             b2.a(this);
/*      */ 
/*      */           
/*      */           }
/*      */ 
/*      */         
/*      */         }
/* 1057 */         else if (this.L && j.af.equals(entry.getKey())) {
/*      */           
/* 1059 */           this.M = b().a();
/* 1060 */           b1.a(this);
/* 1061 */           this.N = b().a() - this.M;
/*      */         }
/* 1063 */         else if (this.L && j.G.equals(entry.getKey())) {
/*      */           
/* 1065 */           this.S = (a)entry.getValue();
/* 1066 */           this.O = b().a() + 1L;
/* 1067 */           b1.a(this);
/* 1068 */           this.P = b().a() - 1L - this.O;
/* 1069 */           this.L = false;
/*      */         }
/*      */         else {
/*      */           
/* 1073 */           b1.a(this);
/*      */         } 
/*      */         
/* 1076 */         b().c();
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1087 */     b().write(b);
/* 1088 */     b().c();
/* 1089 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Object a(e parame) {
/* 1097 */     c(parame);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1108 */     b(parame);
/*      */ 
/*      */     
/* 1111 */     d d = parame.h();
/* 1112 */     long l = -1L;
/*      */     
/* 1114 */     if (d != null)
/*      */     {
/* 1116 */       l = d.k(j.eg);
/*      */     }
/*      */     
/* 1119 */     if (parame.m()) {
/*      */       
/* 1121 */       a(parame, l);
/*      */     }
/*      */     else {
/*      */       
/* 1125 */       f();
/* 1126 */       d(parame);
/*      */     } 
/*      */ 
/*      */     
/* 1130 */     b().write(o);
/* 1131 */     b().c();
/* 1132 */     b().write(String.valueOf(c()).getBytes(a.d));
/* 1133 */     b().c();
/* 1134 */     b().write(i);
/* 1135 */     b().c();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1149 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final Object a(f paramf) {
/* 1155 */     paramf.a(b());
/* 1156 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final Object a(i parami) {
/* 1162 */     parami.a(b());
/* 1163 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final Object a(j paramj) {
/* 1169 */     paramj.a(b());
/* 1170 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final Object a(k paramk) {
/* 1176 */     k.a(b());
/* 1177 */     return null;
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
/*      */   private void d(org.a.c.b.b paramb) {
/* 1189 */     n n1 = c(paramb);
/* 1190 */     b().write(String.valueOf(n1.b()).getBytes(a.d));
/* 1191 */     b().write(f);
/* 1192 */     b().write(String.valueOf(n1.a()).getBytes(a.d));
/* 1193 */     b().write(f);
/* 1194 */     b().write(j);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final Object a(p paramp) {
/* 1200 */     if (this.J)
/*      */     {
/* 1202 */       this.H.d().a()
/* 1203 */         .a(paramp, this.G.b(), this.G.a());
/*      */     }
/*      */     
/* 1206 */     InputStream inputStream = null;
/*      */ 
/*      */     
/*      */     try {
/* 1210 */       a((d)paramp);
/* 1211 */       b().write(r);
/* 1212 */       b().b();
/*      */ 
/*      */       
/* 1215 */       am.a(inputStream = paramp.j(), b());
/*      */       
/* 1217 */       b().b();
/* 1218 */       b().write(s);
/* 1219 */       b().c();
/* 1220 */       paramp = null; return paramp;
/*      */     }
/*      */     finally {
/*      */       
/* 1224 */       if (inputStream != null)
/*      */       {
/* 1226 */         inputStream.close();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final Object a(s params) {
/* 1234 */     if (this.J)
/*      */     {
/* 1236 */       this.H.d().a().a(params, this.G
/*      */           
/* 1238 */           .b(), this.G
/* 1239 */           .a());
/*      */     }
/* 1241 */     a(params, b());
/* 1242 */     return null;
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
/*      */   public final void a(org.a.c.h.b paramb) {
/* 1268 */     a(paramb, (aa.a)null);
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
/*      */   private void a(org.a.c.h.b paramb, aa.a parama) {
/* 1286 */     Long long_ = Long.valueOf((paramb.h() == null) ? System.currentTimeMillis() : paramb
/* 1287 */         .h().longValue());
/*      */     
/* 1289 */     this.H = paramb;
/* 1290 */     this.R = parama;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1298 */     if (paramb.g()) {
/*      */       
/* 1300 */       this.J = false;
/*      */       
/*      */       e e1;
/*      */       
/*      */       d d1;
/* 1305 */       (d1 = (e1 = paramb.a()).h()).m(j.aS);
/*      */ 
/*      */     
/*      */     }
/* 1309 */     else if (this.H.d() != null) {
/*      */       k k;
/*      */ 
/*      */ 
/*      */       
/* 1314 */       if (!(k = this.H.d().a()).a())
/*      */       {
/* 1316 */         throw new IllegalStateException("PDF contains an encryption dictionary, please remove it with setAllSecurityToBeRemoved() or set a protection policy with protect()");
/*      */       }
/*      */       
/* 1319 */       k.a(this.H);
/*      */       
/* 1321 */       this.J = true;
/*      */     }
/*      */     else {
/*      */       
/* 1325 */       this.J = false;
/*      */     } 
/*      */     
/*      */     e e;
/*      */     
/* 1330 */     d d = (e = this.H.a()).h();
/* 1331 */     a a1 = null;
/* 1332 */     boolean bool = true;
/*      */     org.a.c.b.b b1;
/* 1334 */     if (b1 = d.a(j.bA) instanceof a)
/*      */     {
/*      */       
/* 1337 */       if ((a1 = (a)b1).b() == 2)
/*      */       {
/* 1339 */         bool = false;
/*      */       }
/*      */     }
/*      */     
/* 1343 */     if (a1 != null && a1.b() == 2)
/*      */     {
/* 1345 */       bool = false;
/*      */     }
/* 1347 */     if (bool) {
/*      */       MessageDigest messageDigest;
/*      */ 
/*      */       
/*      */       try {
/* 1352 */         messageDigest = MessageDigest.getInstance("MD5");
/*      */       }
/* 1354 */       catch (NoSuchAlgorithmException noSuchAlgorithmException) {
/*      */ 
/*      */         
/* 1357 */         throw new RuntimeException(noSuchAlgorithmException);
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 1362 */       messageDigest.update(Long.toString(noSuchAlgorithmException.longValue()).getBytes(a.d));
/*      */       
/*      */       d d1;
/* 1365 */       if ((d1 = d.d(j.bI)) != null)
/*      */       {
/* 1367 */         for (org.a.c.b.b b2 : d1.h())
/*      */         {
/* 1369 */           messageDigest.update(b2.toString().getBytes(a.d));
/*      */         }
/*      */       }
/*      */       
/* 1373 */       s s1 = bool ? new s(messageDigest.digest()) : (s)a1.b(0);
/*      */       
/* 1375 */       s s2 = bool ? s1 : new s(messageDigest.digest());
/*      */       
/* 1377 */       (a1 = new a()).a((org.a.c.b.b)s1);
/* 1378 */       a1.a((org.a.c.b.b)s2);
/* 1379 */       d.a(j.bA, (org.a.c.b.b)a1);
/*      */     } 
/* 1381 */     e.a(this);
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
/*      */   public static void a(s params, OutputStream paramOutputStream) {
/* 1407 */     a(params.c(), params.a(), paramOutputStream);
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
/*      */   public static void a(byte[] paramArrayOfbyte, OutputStream paramOutputStream) {
/* 1419 */     a(paramArrayOfbyte, false, paramOutputStream);
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
/*      */   private static void a(byte[] paramArrayOfbyte, boolean paramBoolean, OutputStream paramOutputStream) {
/* 1432 */     boolean bool = true;
/* 1433 */     if (!paramBoolean) {
/*      */       byte[] arrayOfByte; int i; byte b1;
/* 1435 */       for (i = (arrayOfByte = paramArrayOfbyte).length, b1 = 0; b1 < i; b1++) {
/*      */         byte b2;
/*      */         
/* 1438 */         if ((b2 = arrayOfByte[b1]) < 0) {
/*      */           
/* 1440 */           bool = false;
/*      */           
/*      */           break;
/*      */         } 
/* 1444 */         if (b2 == 13 || b2 == 10) {
/*      */           
/* 1446 */           bool = false;
/*      */           
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     } 
/* 1452 */     if (bool && !paramBoolean) {
/*      */ 
/*      */       
/* 1455 */       paramOutputStream.write(40); byte[] arrayOfByte; int i; byte b1;
/* 1456 */       for (i = (arrayOfByte = paramArrayOfbyte).length, b1 = 0; b1 < i; b1++) {
/*      */         byte b2;
/* 1458 */         switch (b2 = arrayOfByte[b1]) {
/*      */           
/*      */           case 40:
/*      */           case 41:
/*      */           case 92:
/* 1463 */             paramOutputStream.write(92);
/*      */             break;
/*      */         } 
/*      */         
/* 1467 */         paramOutputStream.write(b2);
/*      */       } 
/*      */ 
/*      */       
/* 1471 */       paramOutputStream.write(41);
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/* 1476 */     paramOutputStream.write(60);
/* 1477 */     c.a(paramArrayOfbyte, paramOutputStream);
/* 1478 */     paramOutputStream.write(62);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\g\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */