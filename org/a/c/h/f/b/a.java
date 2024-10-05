/*     */ package org.a.c.h.f.b;
/*     */ 
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.io.InputStream;
/*     */ import org.a.c.a.a;
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.b.f;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.b.p;
/*     */ import org.a.c.h.a.c;
/*     */ import org.a.c.h.a.h;
/*     */ import org.a.c.h.a.i;
/*     */ import org.a.c.h.b;
/*     */ import org.a.c.h.f.a;
/*     */ import org.a.c.h.j;
/*     */ import org.a.c.h.k;
/*     */ import org.a.c.i.d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class a
/*     */   extends a
/*     */   implements a
/*     */ {
/*     */   private final k a;
/*     */   
/*     */   public a(i parami) {
/*  66 */     super(parami, j.bo);
/*  67 */     this.a = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public a(p paramp) {
/*  76 */     super(paramp, j.bo);
/*  77 */     this.a = null;
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
/*     */   public a(b paramb) {
/*  96 */     super(paramb, j.bo);
/*  97 */     this.a = null;
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
/*     */   public final void a(int paramInt) {
/* 115 */     b().a(j.bp, 1);
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
/*     */   public final i d() {
/* 138 */     return new i(b());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final InputStream a() {
/* 144 */     return (InputStream)b().k();
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
/*     */   public final j e() {
/*     */     d d;
/* 157 */     if ((d = b().d(j.dg)) != null)
/*     */     {
/* 159 */       return new j(d, this.a);
/*     */     }
/* 161 */     if (b().o(j.dg))
/*     */     {
/*     */ 
/*     */ 
/*     */       
/* 166 */       return new j();
/*     */     }
/* 168 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(j paramj) {
/* 177 */     b().a(j.dg, (c)paramj);
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
/*     */   public final h g() {
/* 190 */     h h = null;
/*     */     org.a.c.b.a a1;
/* 192 */     if ((a1 = (org.a.c.b.a)b().a(j.w)) != null)
/*     */     {
/* 194 */       h = new h(a1);
/*     */     }
/* 196 */     return h;
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
/*     */   public final void a(h paramh) {
/* 211 */     b().a(j.w, (b)paramh.b());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final d h() {
/* 222 */     return d.a(b().a(j.cf));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(AffineTransform paramAffineTransform) {
/* 231 */     org.a.c.b.a a1 = new org.a.c.b.a();
/* 232 */     double[] arrayOfDouble2 = new double[6];
/* 233 */     paramAffineTransform.getMatrix(arrayOfDouble2); double[] arrayOfDouble1; byte b;
/* 234 */     for (arrayOfDouble1 = arrayOfDouble2, b = 0; b < 6; ) { double d = arrayOfDouble1[b];
/*     */       
/* 236 */       a1.a((b)new f((float)d)); b++; }
/*     */     
/* 238 */     b().a(j.cf, (b)a1);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\f\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */