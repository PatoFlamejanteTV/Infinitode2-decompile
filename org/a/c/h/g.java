/*      */ package org.a.c.h;
/*      */ 
/*      */ import java.awt.geom.AffineTransform;
/*      */ import java.io.Closeable;
/*      */ import java.io.OutputStream;
/*      */ import java.text.NumberFormat;
/*      */ import java.util.Locale;
/*      */ import java.util.Stack;
/*      */ import org.a.a.a.c;
/*      */ import org.a.c.b.b;
/*      */ import org.a.c.b.j;
/*      */ import org.a.c.g.b;
/*      */ import org.a.c.h.a.c;
/*      */ import org.a.c.h.a.i;
/*      */ import org.a.c.h.e.u;
/*      */ import org.a.c.h.f.a.e;
/*      */ import org.a.c.h.f.a.f;
/*      */ import org.a.c.h.f.a.g;
/*      */ import org.a.c.h.f.a.i;
/*      */ import org.a.c.h.f.a.m;
/*      */ import org.a.c.h.f.c.b;
/*      */ import org.a.c.h.f.e.a;
/*      */ import org.a.c.h.g.b.q;
/*      */ import org.a.c.i.d;
/*      */ import org.a.c.i.e;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class g
/*      */   implements Closeable
/*      */ {
/*      */   public enum a
/*      */   {
/*   77 */     b,
/*      */ 
/*      */ 
/*      */     
/*   81 */     a,
/*      */ 
/*      */ 
/*      */     
/*   85 */     c;
/*      */ 
/*      */     
/*      */     public final boolean a() {
/*   89 */       return (this == b);
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean b() {
/*   94 */       return (this == c);
/*      */     }
/*      */   }
/*      */   
/*   98 */   private static final org.a.a.a.a a = c.a(g.class);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final b b;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private OutputStream c;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private j d;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean e;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final Stack<u> f;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final Stack<f> g;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final Stack<f> h;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final NumberFormat i;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final byte[] j;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public g(b paramb, e parame, a parama, boolean paramBoolean) {
/*  160 */     this(paramb, parame, parama, paramBoolean, false);
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
/*      */   private g(b paramb, e parame, a parama, boolean paramBoolean1, boolean paramBoolean2) {
/*      */     i i;
/*      */     this.e = false;
/*      */     this.f = new Stack<u>();
/*      */     this.g = new Stack<f>();
/*      */     this.h = new Stack<f>();
/*      */     this.i = NumberFormat.getNumberInstance(Locale.US);
/*      */     this.j = new byte[32];
/*  200 */     this.b = paramb;
/*  201 */     j j1 = paramBoolean1 ? j.bc : null;
/*      */ 
/*      */     
/*  204 */     if (!parama.a() && parame.c()) {
/*      */       org.a.c.b.a a1;
/*      */       
/*  207 */       i = new i(paramb);
/*      */ 
/*      */       
/*      */       b b1;
/*      */       
/*  212 */       if (b1 = parame.b().a(j.af) instanceof org.a.c.b.a) {
/*      */ 
/*      */         
/*  215 */         a1 = (org.a.c.b.a)b1;
/*      */       
/*      */       }
/*      */       else {
/*      */ 
/*      */         
/*  221 */         (a1 = new org.a.c.b.a()).a(b1);
/*      */       } 
/*  223 */       if (parama.b()) {
/*      */         
/*  225 */         a1.a(0, (b)i.a());
/*      */       }
/*      */       else {
/*      */         
/*  229 */         a1.a((c)i);
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  248 */       parame.b().a(j.af, (b)a1);
/*  249 */       this.c = i.a(j1);
/*      */ 
/*      */ 
/*      */     
/*      */     }
/*      */     else {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  259 */       parame.c();
/*      */ 
/*      */ 
/*      */       
/*  263 */       i = new i((b)i);
/*  264 */       parame.a(i);
/*  265 */       this.c = i.a(j1);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  270 */     this.d = parame.d();
/*  271 */     if (this.d == null) {
/*      */       
/*  273 */       this.d = new j();
/*  274 */       parame.a(this.d);
/*      */     } 
/*      */ 
/*      */     
/*  278 */     this.i.setMaximumFractionDigits(5);
/*  279 */     this.i.setGroupingUsed(false);
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
/*      */   public g(b paramb, q paramq, OutputStream paramOutputStream) {
/*      */     this.e = false;
/*      */     this.f = new Stack<u>();
/*      */     this.g = new Stack<f>();
/*      */     this.h = new Stack<f>();
/*      */     this.i = NumberFormat.getNumberInstance(Locale.US);
/*      */     this.j = new byte[32];
/*  305 */     this.b = paramb;
/*      */     
/*  307 */     this.c = paramOutputStream;
/*  308 */     this.d = paramq.e();
/*      */     
/*  310 */     this.i.setMaximumFractionDigits(4);
/*  311 */     this.i.setGroupingUsed(false);
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
/*      */   public final void a() {
/*  363 */     if (this.e)
/*      */     {
/*  365 */       throw new IllegalStateException("Error: Nested beginText() calls are not allowed.");
/*      */     }
/*  367 */     c("BT");
/*  368 */     this.e = true;
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
/*      */   public final void b() {
/*  380 */     if (!this.e)
/*      */     {
/*  382 */       throw new IllegalStateException("Error: You must call beginText() before calling endText.");
/*      */     }
/*  384 */     c("ET");
/*  385 */     this.e = false;
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
/*      */   public final void a(u paramu, float paramFloat) {
/*  397 */     if (this.f.isEmpty()) {
/*      */       
/*  399 */       this.f.add(paramu);
/*      */     }
/*      */     else {
/*      */       
/*  403 */       this.f.setElementAt(paramu, this.f.size() - 1);
/*      */     } 
/*      */     
/*  406 */     if (paramu.k())
/*      */     {
/*  408 */       this.b.e().add(paramu);
/*      */     }
/*      */     
/*  411 */     a(this.d.a(paramu));
/*  412 */     d(paramFloat);
/*  413 */     c("Tf");
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
/*      */   public final void a(Object[] paramArrayOfObject) {
/*  444 */     d("["); int i; byte b1;
/*  445 */     for (i = (paramArrayOfObject = paramArrayOfObject).length, b1 = 0; b1 < i; b1++) {
/*      */       Object object;
/*  447 */       if (object = paramArrayOfObject[b1] instanceof String) {
/*      */         
/*  449 */         b((String)object);
/*      */       }
/*  451 */       else if (object instanceof Float) {
/*      */         
/*  453 */         d(((Float)object).floatValue());
/*      */       }
/*      */       else {
/*      */         
/*  457 */         throw new IllegalArgumentException("Argument must consist of array of Float and String types");
/*      */       } 
/*      */     } 
/*  460 */     d("] ");
/*  461 */     c("TJ");
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
/*      */   public final void a(String paramString) {
/*  473 */     b(paramString);
/*  474 */     d(" ");
/*  475 */     c("Tj");
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
/*      */   private void b(String paramString) {
/*  487 */     if (!this.e)
/*      */     {
/*  489 */       throw new IllegalStateException("Must call beginText() before showText()");
/*      */     }
/*      */     
/*  492 */     if (this.f.isEmpty())
/*      */     {
/*  494 */       throw new IllegalStateException("Must call setFont() before showText()");
/*      */     }
/*      */ 
/*      */     
/*      */     u u;
/*      */     
/*  500 */     if ((u = this.f.peek()).k()) {
/*      */       
/*  502 */       int i = 0;
/*  503 */       while (i < paramString.length()) {
/*      */         
/*  505 */         int k = paramString.codePointAt(i);
/*  506 */         u.f(k);
/*  507 */         i += Character.charCount(k);
/*      */       } 
/*      */     } 
/*      */     
/*  511 */     b.a(u.a(paramString), this.c);
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
/*      */   public final void a(float paramFloat1, float paramFloat2) {
/*  579 */     if (!this.e)
/*      */     {
/*  581 */       throw new IllegalStateException("Error: must call beginText() before newLineAtOffset()");
/*      */     }
/*  583 */     d(paramFloat1);
/*  584 */     d(paramFloat2);
/*  585 */     c("Td");
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
/*      */   public final void a(d paramd) {
/*  629 */     if (!this.e)
/*      */     {
/*  631 */       throw new IllegalStateException("Error: must call beginText() before setTextMatrix");
/*      */     }
/*  633 */     a(paramd.a());
/*  634 */     c("Tm");
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
/*      */   public final void a(b paramb, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  710 */     if (this.e)
/*      */     {
/*  712 */       throw new IllegalStateException("Error: drawImage is not allowed within a text block.");
/*      */     }
/*      */     
/*  715 */     c();
/*      */     
/*  717 */     AffineTransform affineTransform = new AffineTransform(paramFloat3, 0.0F, 0.0F, paramFloat4, paramFloat1, paramFloat2);
/*  718 */     b(new d(affineTransform));
/*      */     
/*  720 */     a(this.d.a(paramb));
/*  721 */     c("Do");
/*      */     
/*  723 */     d();
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
/*      */   public final void b(d paramd) {
/*  990 */     a(paramd.a());
/*  991 */     c("cm");
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
/*      */   public final void c() {
/* 1005 */     if (!this.f.isEmpty())
/*      */     {
/* 1007 */       this.f.push(this.f.peek());
/*      */     }
/* 1009 */     if (!this.h.isEmpty())
/*      */     {
/* 1011 */       this.h.push(this.h.peek());
/*      */     }
/* 1013 */     if (!this.g.isEmpty())
/*      */     {
/* 1015 */       this.g.push(this.g.peek());
/*      */     }
/* 1017 */     c("q");
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
/*      */   public final void d() {
/* 1031 */     if (!this.f.isEmpty())
/*      */     {
/* 1033 */       this.f.pop();
/*      */     }
/* 1035 */     if (!this.h.isEmpty())
/*      */     {
/* 1037 */       this.h.pop();
/*      */     }
/* 1039 */     if (!this.g.isEmpty())
/*      */     {
/* 1041 */       this.g.pop();
/*      */     }
/* 1043 */     c("Q");
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
/*      */   private j a(f paramf) {
/* 1080 */     if (paramf instanceof i || paramf instanceof m || paramf instanceof g)
/*      */     {
/*      */ 
/*      */       
/* 1084 */       return j.a(paramf.a());
/*      */     }
/*      */ 
/*      */     
/* 1088 */     return this.d.a(paramf);
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
/*      */   public final void a(e parame) {
/* 1100 */     if (this.h.isEmpty() || this.h
/* 1101 */       .peek() != parame.c()) {
/*      */       
/* 1103 */       a(a(parame.c()));
/* 1104 */       c("CS");
/* 1105 */       b(parame.c());
/*      */     }  float[] arrayOfFloat; int i;
/*      */     byte b1;
/* 1108 */     for (i = (arrayOfFloat = parame.a()).length, b1 = 0; b1 < i; ) { float f = arrayOfFloat[b1];
/*      */       
/* 1110 */       d(f);
/*      */       b1++; }
/*      */     
/* 1113 */     if (parame.c() instanceof org.a.c.h.f.a.t)
/*      */     {
/* 1115 */       a(parame.b());
/*      */     }
/*      */     
/* 1118 */     if (parame.c() instanceof org.a.c.h.f.a.t || parame
/* 1119 */       .c() instanceof org.a.c.h.f.a.u || parame
/* 1120 */       .c() instanceof org.a.c.h.f.a.j || parame
/* 1121 */       .c() instanceof org.a.c.h.f.a.o) {
/*      */       
/* 1123 */       c("SCN");
/*      */       
/*      */       return;
/*      */     } 
/* 1127 */     c("SC");
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
/*      */   public final void a(int paramInt1, int paramInt2, int paramInt3) {
/* 1190 */     if (e(paramInt1) || e(paramInt2) || e(paramInt3))
/*      */     {
/* 1192 */       throw new IllegalArgumentException("Parameters must be within 0..255, but are " + 
/* 1193 */           String.format("(%d,%d,%d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
/*      */     }
/* 1195 */     d(paramInt1 / 255.0F);
/* 1196 */     d(paramInt2 / 255.0F);
/* 1197 */     d(paramInt3 / 255.0F);
/* 1198 */     c("RG");
/* 1199 */     b((f)m.a);
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
/*      */   public final void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 1236 */     if (a(paramFloat1) || a(paramFloat2) || a(paramFloat3) || a(paramFloat4))
/*      */     {
/* 1238 */       throw new IllegalArgumentException("Parameters must be within 0..1, but are " + 
/* 1239 */           String.format("(%.2f,%.2f,%.2f,%.2f)", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3), Float.valueOf(paramFloat4) }));
/*      */     }
/* 1241 */     d(paramFloat1);
/* 1242 */     d(paramFloat2);
/* 1243 */     d(paramFloat3);
/* 1244 */     d(paramFloat4);
/* 1245 */     c("K");
/* 1246 */     b((f)g.a);
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
/*      */   public final void b(e parame) {
/* 1307 */     if (this.g.isEmpty() || this.g
/* 1308 */       .peek() != parame.c()) {
/*      */       
/* 1310 */       a(a(parame.c()));
/* 1311 */       c("cs");
/* 1312 */       c(parame.c());
/*      */     }  float[] arrayOfFloat; int i;
/*      */     byte b1;
/* 1315 */     for (i = (arrayOfFloat = parame.a()).length, b1 = 0; b1 < i; ) { float f = arrayOfFloat[b1];
/*      */       
/* 1317 */       d(f);
/*      */       b1++; }
/*      */     
/* 1320 */     if (parame.c() instanceof org.a.c.h.f.a.t)
/*      */     {
/* 1322 */       a(parame.b());
/*      */     }
/*      */     
/* 1325 */     if (parame.c() instanceof org.a.c.h.f.a.t || parame
/* 1326 */       .c() instanceof org.a.c.h.f.a.u || parame
/* 1327 */       .c() instanceof org.a.c.h.f.a.j || parame
/* 1328 */       .c() instanceof org.a.c.h.f.a.o) {
/*      */       
/* 1330 */       c("scn");
/*      */       
/*      */       return;
/*      */     } 
/* 1334 */     c("sc");
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
/*      */   public final void b(int paramInt1, int paramInt2, int paramInt3) {
/* 1397 */     if (e(paramInt1) || e(paramInt2) || e(paramInt3))
/*      */     {
/* 1399 */       throw new IllegalArgumentException("Parameters must be within 0..255, but are " + 
/* 1400 */           String.format("(%d,%d,%d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
/*      */     }
/* 1402 */     d(paramInt1 / 255.0F);
/* 1403 */     d(paramInt2 / 255.0F);
/* 1404 */     d(paramInt3 / 255.0F);
/* 1405 */     c("rg");
/* 1406 */     c((f)m.a);
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
/*      */   public final void b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 1457 */     if (a(paramFloat1) || a(paramFloat2) || a(paramFloat3) || a(paramFloat4))
/*      */     {
/* 1459 */       throw new IllegalArgumentException("Parameters must be within 0..1, but are " + 
/* 1460 */           String.format("(%.2f,%.2f,%.2f,%.2f)", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3), Float.valueOf(paramFloat4) }));
/*      */     }
/* 1462 */     d(paramFloat1);
/* 1463 */     d(paramFloat2);
/* 1464 */     d(paramFloat3);
/* 1465 */     d(paramFloat4);
/* 1466 */     c("k");
/* 1467 */     c((f)g.a);
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
/*      */   public final void a(int paramInt) {
/* 1479 */     if (e(0))
/*      */     {
/* 1481 */       throw new IllegalArgumentException("Parameter must be within 0..255, but is " + Character.MIN_VALUE);
/*      */     }
/* 1483 */     c(0.0F);
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
/*      */   private void c(float paramFloat) {
/* 1509 */     if (a(paramFloat))
/*      */     {
/* 1511 */       throw new IllegalArgumentException("Parameter must be within 0..1, but is " + paramFloat);
/*      */     }
/* 1513 */     d(paramFloat);
/* 1514 */     c("g");
/* 1515 */     c((f)i.a);
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
/*      */   public final void c(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 1530 */     if (this.e)
/*      */     {
/* 1532 */       throw new IllegalStateException("Error: addRect is not allowed within a text block.");
/*      */     }
/* 1534 */     d(paramFloat1);
/* 1535 */     d(paramFloat2);
/* 1536 */     d(paramFloat3);
/* 1537 */     d(paramFloat4);
/* 1538 */     c("re");
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
/*      */   public final void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/* 1596 */     if (this.e)
/*      */     {
/* 1598 */       throw new IllegalStateException("Error: curveTo is not allowed within a text block.");
/*      */     }
/* 1600 */     d(paramFloat1);
/* 1601 */     d(paramFloat2);
/* 1602 */     d(paramFloat3);
/* 1603 */     d(paramFloat4);
/* 1604 */     d(paramFloat5);
/* 1605 */     d(paramFloat6);
/* 1606 */     c("c");
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
/*      */   public final void d(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 1680 */     if (this.e)
/*      */     {
/* 1682 */       throw new IllegalStateException("Error: curveTo1 is not allowed within a text block.");
/*      */     }
/* 1684 */     d(paramFloat1);
/* 1685 */     d(paramFloat2);
/* 1686 */     d(paramFloat3);
/* 1687 */     d(paramFloat4);
/* 1688 */     c("y");
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
/*      */   public final void b(float paramFloat1, float paramFloat2) {
/* 1701 */     if (this.e)
/*      */     {
/* 1703 */       throw new IllegalStateException("Error: moveTo is not allowed within a text block.");
/*      */     }
/* 1705 */     d(paramFloat1);
/* 1706 */     d(paramFloat2);
/* 1707 */     c("m");
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
/*      */   public final void c(float paramFloat1, float paramFloat2) {
/* 1720 */     if (this.e)
/*      */     {
/* 1722 */       throw new IllegalStateException("Error: lineTo is not allowed within a text block.");
/*      */     }
/* 1724 */     d(paramFloat1);
/* 1725 */     d(paramFloat2);
/* 1726 */     c("l");
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
/*      */   public final void e() {
/* 1856 */     if (this.e)
/*      */     {
/* 1858 */       throw new IllegalStateException("Error: stroke is not allowed within a text block.");
/*      */     }
/* 1860 */     c("S");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void f() {
/* 1871 */     if (this.e)
/*      */     {
/* 1873 */       throw new IllegalStateException("Error: closeAndStroke is not allowed within a text block.");
/*      */     }
/* 1875 */     c("s");
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
/*      */   public final void g() {
/* 1911 */     if (this.e)
/*      */     {
/* 1913 */       throw new IllegalStateException("Error: fill is not allowed within a text block.");
/*      */     }
/* 1915 */     c("f");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void h() {
/* 1926 */     if (this.e)
/*      */     {
/* 1928 */       throw new IllegalStateException("Error: fillEvenOdd is not allowed within a text block.");
/*      */     }
/* 1930 */     c("f*");
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
/*      */   public final void i() {
/* 2039 */     if (this.e)
/*      */     {
/* 2041 */       throw new IllegalStateException("Error: closePath is not allowed within a text block.");
/*      */     }
/* 2043 */     c("h");
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
/*      */   public final void j() {
/* 2084 */     if (this.e)
/*      */     {
/* 2086 */       throw new IllegalStateException("Error: clip is not allowed within a text block.");
/*      */     }
/* 2088 */     c("W");
/*      */ 
/*      */     
/* 2091 */     c("n");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void k() {
/* 2102 */     if (this.e)
/*      */     {
/* 2104 */       throw new IllegalStateException("Error: clipEvenOdd is not allowed within a text block.");
/*      */     }
/* 2106 */     c("W*");
/*      */ 
/*      */     
/* 2109 */     c("n");
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
/*      */   public final void a(float paramFloat) {
/* 2121 */     if (this.e)
/*      */     {
/* 2123 */       throw new IllegalStateException("Error: setLineWidth is not allowed within a text block.");
/*      */     }
/* 2125 */     d(paramFloat);
/* 2126 */     c("w");
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
/*      */   public final void b(int paramInt) {
/* 2139 */     if (this.e)
/*      */     {
/* 2141 */       throw new IllegalStateException("Error: setLineJoinStyle is not allowed within a text block.");
/*      */     }
/* 2143 */     if (paramInt >= 0 && paramInt <= 2) {
/*      */       
/* 2145 */       d(paramInt);
/* 2146 */       c("j");
/*      */       
/*      */       return;
/*      */     } 
/* 2150 */     throw new IllegalArgumentException("Error: unknown value for line join style");
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
/*      */   public final void c(int paramInt) {
/* 2164 */     if (this.e)
/*      */     {
/* 2166 */       throw new IllegalStateException("Error: setLineCapStyle is not allowed within a text block.");
/*      */     }
/* 2168 */     if (paramInt >= 0 && paramInt <= 2) {
/*      */       
/* 2170 */       d(paramInt);
/* 2171 */       c("J");
/*      */       
/*      */       return;
/*      */     } 
/* 2175 */     throw new IllegalArgumentException("Error: unknown value for line cap style");
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
/*      */   public final void a(float[] paramArrayOffloat, float paramFloat) {
/* 2189 */     if (this.e)
/*      */     {
/* 2191 */       throw new IllegalStateException("Error: setLineDashPattern is not allowed within a text block.");
/*      */     }
/* 2193 */     d("["); int i; byte b1;
/* 2194 */     for (i = (paramArrayOffloat = paramArrayOffloat).length, b1 = 0; b1 < i; ) { float f = paramArrayOffloat[b1];
/*      */       
/* 2196 */       d(f); b1++; }
/*      */     
/* 2198 */     d("] ");
/* 2199 */     d(paramFloat);
/* 2200 */     c("d");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void b(float paramFloat) {
/* 2211 */     if (this.e)
/*      */     {
/* 2213 */       throw new IllegalStateException("Error: setMiterLimit is not allowed within a text block.");
/*      */     }
/* 2215 */     if (paramFloat <= 0.0D)
/*      */     {
/* 2217 */       throw new IllegalArgumentException("A miter limit <= 0 is invalid and will not render in Acrobat Reader");
/*      */     }
/* 2219 */     d(paramFloat);
/* 2220 */     c("M");
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
/*      */   private void d(float paramFloat) {
/*      */     int i;
/* 2423 */     if ((i = e.a(paramFloat, this.i.getMaximumFractionDigits(), this.j)) == -1) {
/*      */ 
/*      */       
/* 2426 */       d(this.i.format(paramFloat));
/*      */     }
/*      */     else {
/*      */       
/* 2430 */       this.c.write(this.j, 0, i);
/*      */     } 
/* 2432 */     this.c.write(32);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void d(int paramInt) {
/* 2440 */     d(this.i.format(paramInt));
/* 2441 */     this.c.write(32);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(j paramj) {
/* 2449 */     paramj.a(this.c);
/* 2450 */     this.c.write(32);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void c(String paramString) {
/* 2458 */     this.c.write(paramString.getBytes(org.a.c.i.a.a));
/* 2459 */     this.c.write(10);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void d(String paramString) {
/* 2467 */     this.c.write(paramString.getBytes(org.a.c.i.a.a));
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
/*      */   private void a(AffineTransform paramAffineTransform) {
/* 2491 */     double[] arrayOfDouble2 = new double[6];
/* 2492 */     paramAffineTransform.getMatrix(arrayOfDouble2); double[] arrayOfDouble1; byte b1;
/* 2493 */     for (arrayOfDouble1 = arrayOfDouble2, b1 = 0; b1 < 6; ) { double d = arrayOfDouble1[b1];
/*      */       
/* 2495 */       d((float)d);
/*      */       b1++; }
/*      */   
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
/*      */   public final void close() {
/* 2511 */     if (this.c != null) {
/*      */       
/* 2513 */       this.c.close();
/* 2514 */       this.c = null;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean e(int paramInt) {
/* 2520 */     return (paramInt < 0 || paramInt > 255);
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean a(double paramDouble) {
/* 2525 */     return (paramDouble < 0.0D || paramDouble > 1.0D);
/*      */   }
/*      */ 
/*      */   
/*      */   private void b(f paramf) {
/* 2530 */     if (this.h.isEmpty()) {
/*      */       
/* 2532 */       this.h.add(paramf);
/*      */       
/*      */       return;
/*      */     } 
/* 2536 */     this.h.setElementAt(paramf, this.h.size() - 1);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void c(f paramf) {
/* 2542 */     if (this.g.isEmpty()) {
/*      */       
/* 2544 */       this.g.add(paramf);
/*      */       
/*      */       return;
/*      */     } 
/* 2548 */     this.g.setElementAt(paramf, this.g.size() - 1);
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
/*      */   public final void a(a parama) {
/* 2561 */     d(parama.a());
/* 2562 */     c("Tr");
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */