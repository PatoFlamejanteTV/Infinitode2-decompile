/*     */ package org.a.c.h.g.b;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import org.a.a.a.a;
/*     */ import org.a.a.a.c;
/*     */ import org.a.c.b.a;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.h.a.c;
/*     */ import org.a.c.h.a.h;
/*     */ import org.a.c.h.e;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class b
/*     */   implements c
/*     */ {
/*  50 */   private static final a a = c.a(b.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final d b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static b a(org.a.c.b.b paramb) {
/*     */     l l;
/* 102 */     if (paramb instanceof d)
/*     */     { c c1;
/*     */       d d1;
/* 105 */       String str = (d1 = (d)paramb).g(j.dE);
/* 106 */       if ("FileAttachment".equals(str)) {
/*     */         
/* 108 */         c1 = new c(d1);
/*     */       } else {
/* 110 */         d d2; if ("Line".equals(str)) {
/*     */           
/* 112 */           d2 = new d((d)c1);
/*     */         } else {
/* 114 */           e e; if ("Link".equals(str)) {
/*     */             
/* 116 */             e = new e((d)d2);
/*     */           } else {
/* 118 */             g g; if ("Popup".equals(str)) {
/*     */               
/* 120 */               g = new g((d)e);
/*     */             } else {
/* 122 */               h h; if ("Stamp".equals(str))
/*     */               
/* 124 */               { h = new h((d)g); }
/*     */               else
/* 126 */               { i i; if ("Square".equals(str) || "Circle"
/* 127 */                   .equals(str))
/*     */                 
/* 129 */                 { i = new i((d)h); }
/*     */                 else
/* 131 */                 { j j; if ("Text".equals(str))
/*     */                   
/* 133 */                   { j = new j((d)i); }
/*     */                   else
/* 135 */                   { k k; if ("Highlight".equals(str) || "Underline"
/* 136 */                       .equals(str) || "Squiggly"
/* 137 */                       .equals(str) || "StrikeOut"
/* 138 */                       .equals(str))
/*     */                     
/*     */                     { 
/* 141 */                       k = new k((d)j); }
/*     */                     else
/* 143 */                     { m m; if ("Widget".equals(str))
/*     */                       
/* 145 */                       { m = new m((d)k); }
/*     */                       else
/* 147 */                       { f f; if ("FreeText".equals(str) || "Polygon"
/* 148 */                           .equals(str) || "PolyLine"
/* 149 */                           .equals(str) || "Caret"
/* 150 */                           .equals(str) || "Ink"
/* 151 */                           .equals(str) || "Sound"
/* 152 */                           .equals(str))
/*     */                         
/* 154 */                         { f = new f((d)m);
/*     */                            }
/*     */                         
/*     */                         else
/*     */                         
/*     */                         { 
/* 160 */                           l = new l((d)f);
/* 161 */                           (new StringBuilder("Unknown or unsupported annotation subtype ")).append(str); }  }  }  }  }  } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       }  }
/* 166 */     else { throw new IOException("Error: Unknown annotation type " + l); }
/*     */ 
/*     */     
/* 169 */     return l;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public b() {
/* 177 */     this.b = new d();
/* 178 */     this.b.a(j.dN, (org.a.c.b.b)j.h);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public b(d paramd) {
/* 188 */     this.b = paramd;
/* 189 */     this.b.a(j.dN, (org.a.c.b.b)j.h);
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
/*     */   public final h a() {
/* 201 */     a a1 = (a)this.b.a(j.dd);
/* 202 */     h h = null;
/* 203 */     if (a1 != null)
/*     */     {
/* 205 */       if (a1.b() == 4 && a1.a(0) instanceof org.a.c.b.l && a1
/* 206 */         .a(1) instanceof org.a.c.b.l && a1
/* 207 */         .a(2) instanceof org.a.c.b.l && a1
/* 208 */         .a(3) instanceof org.a.c.b.l) {
/*     */         
/* 210 */         h = new h(a1);
/*     */       }
/*     */       else {
/*     */         
/* 214 */         (new StringBuilder()).append(a1).append(" is not a rectangle array, returning null");
/*     */       } 
/*     */     }
/* 217 */     return h;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(h paramh) {
/* 227 */     this.b.a(j.dd, (org.a.c.b.b)paramh.b());
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
/*     */   public final d b() {
/* 258 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private j h() {
/* 267 */     return b().b(j.l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(String paramString) {
/* 277 */     b().a(j.l, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final o c() {
/*     */     org.a.c.b.b b1;
/* 288 */     if (b1 = this.b.a(j.j) instanceof d)
/*     */     {
/* 290 */       return new o((d)b1);
/*     */     }
/* 292 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(o paramo) {
/* 302 */     this.b.a(j.j, paramo);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final q d() {
/*     */     o o;
/* 312 */     if ((o = c()) == null)
/*     */     {
/* 314 */       return null;
/*     */     }
/*     */     
/*     */     p p;
/* 318 */     if ((p = o.b()) == null)
/*     */     {
/* 320 */       return null;
/*     */     }
/*     */     
/* 323 */     if (p.a()) {
/*     */       
/* 325 */       j j = h();
/* 326 */       return p.d().get(j);
/*     */     } 
/*     */ 
/*     */     
/* 330 */     return p.c();
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
/*     */   public final boolean e() {
/* 361 */     return b().c(j.aU, 2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(boolean paramBoolean) {
/* 371 */     b().a(j.aU, 2, true);
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
/*     */   public final void b(boolean paramBoolean) {
/* 391 */     b().a(j.aU, 4, true);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean g() {
/* 441 */     return b().c(j.aU, 32);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(e parame) {
/* 759 */     b().a(j.cJ, (c)parame);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\g\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */