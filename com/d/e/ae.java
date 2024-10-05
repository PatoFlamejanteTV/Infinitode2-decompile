/*     */ package com.d.e;
/*     */ 
/*     */ import com.d.d.g;
/*     */ import java.text.BreakIterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ae
/*     */   implements g
/*     */ {
/*     */   private final BreakIterator a;
/*     */   private String b;
/*     */   private a c;
/*     */   
/*     */   public ae(BreakIterator paramBreakIterator) {
/*  20 */     this.a = paramBreakIterator;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int a() {
/*  25 */     b();
/*     */     
/*  27 */     a a1 = this.c;
/*     */     
/*  29 */     if (c()) {
/*     */       boolean bool;
/*  31 */       if (bool = d()) {
/*  32 */         return -1;
/*     */       }
/*     */       
/*  35 */       if ("://".equals(c(new a(this.c.d(), -1, 2)))) {
/*  36 */         a1 = a1.a(this.c.d() + 2);
/*  37 */         d();
/*     */       } 
/*     */     } 
/*  40 */     a1 = a1.b(this.c.d());
/*     */     
/*  42 */     a1 = a(a1);
/*  43 */     int i = b(a1);
/*  44 */     this.c = this.c.a((i >= 0) ? i : this.a.current());
/*     */     
/*  46 */     return this.c.c();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private a a(a parama) {
/*  52 */     while (parama.c() < this.c.d() && ".,:;!?- \n\r\t/".indexOf(this.b.charAt(parama.c())) >= 0) {
/*  53 */       parama = parama.a();
/*     */     }
/*     */ 
/*     */     
/*  57 */     while (parama.d() > parama.c() && ".,:;!?- \n\r\t/".indexOf(this.b.charAt(parama.d() - 1)) >= 0) {
/*  58 */       parama = parama.b();
/*     */     }
/*     */     
/*  61 */     return parama;
/*     */   }
/*     */ 
/*     */   
/*     */   private int b(a parama) {
/*     */     int i;
/*  67 */     return ((i = this.b.indexOf('/', parama.c())) < parama.d()) ? i : -1;
/*     */   }
/*     */ 
/*     */   
/*     */   private String c(a parama) {
/*  72 */     return this.b.substring(Math.max(0, parama.c()), Math.min(this.b.length(), parama.d()));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void b() {
/*  78 */     if (this.c.c() > this.a.current()) {
/*  79 */       throw new IllegalStateException("Iterator ahead of delegate.");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean c() {
/*  85 */     return (this.c.c() == this.a.current());
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean d() {
/*  90 */     int i = this.a.next();
/*  91 */     this.c = this.c.b(i);
/*  92 */     return (i == -1);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(String paramString) {
/*  97 */     this.a.setText(paramString);
/*  98 */     this.b = paramString;
/*  99 */     this.c = new a(this.a.current(), this.a.current());
/*     */   }
/*     */ 
/*     */   
/*     */   static class a
/*     */   {
/*     */     private final int a;
/*     */     private final int b;
/*     */     
/*     */     public a(int param1Int1, int param1Int2) {
/* 109 */       this.a = param1Int1;
/* 110 */       this.b = Math.max(param1Int1, param1Int2);
/*     */     }
/*     */     
/*     */     public a(int param1Int1, int param1Int2, int param1Int3) {
/* 114 */       this(param1Int1 + -1, param1Int1 + 2);
/*     */     }
/*     */     
/*     */     public final a a(int param1Int) {
/* 118 */       return new a(param1Int, this.b);
/*     */     }
/*     */     
/*     */     public final a b(int param1Int) {
/* 122 */       return new a(this.a, param1Int);
/*     */     }
/*     */     
/*     */     public final a a() {
/* 126 */       int i = this.a + 1;
/* 127 */       return new a(i, Math.max(i, this.b));
/*     */     }
/*     */     
/*     */     public final a b() {
/* 131 */       int i = this.b + -1;
/* 132 */       return new a(Math.min(this.a, i), i);
/*     */     }
/*     */     
/*     */     public final int c() {
/* 136 */       return this.a;
/*     */     }
/*     */     
/*     */     public final int d() {
/* 140 */       return this.b;
/*     */     }
/*     */     
/*     */     public final String toString() {
/* 144 */       return "[" + this.a + ", " + this.b + ")";
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\e\ae.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */