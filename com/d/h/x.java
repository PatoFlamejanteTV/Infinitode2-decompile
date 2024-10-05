/*     */ package com.d.h;
/*     */ 
/*     */ import com.d.d.f;
/*     */ import com.d.g.a.b;
/*     */ import com.d.g.a.g;
/*     */ import com.d.g.a.h;
/*     */ import com.d.m.l;
/*     */ import java.io.File;
/*     */ import java.io.OutputStream;
/*     */ import java.util.logging.Level;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class x
/*     */   extends b<x, y>
/*     */ {
/*     */   public x() {
/*  21 */     super(new y()); b[] arrayOfB; int i;
/*     */     byte b1;
/*  23 */     for (i = (arrayOfB = b.values()).length, b1 = 0; b1 < i; ) { b b2 = arrayOfB[b1];
/*     */ 
/*     */       
/*  26 */       ((y)this.a).F.put(b2, com.d.d.a.a.a);
/*     */       b1++; }
/*     */   
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
/*     */   public final q a() {
/*  55 */     h h = new h(((y)this.a).p, ((y)this.a).o, ((y)this.a).j, ((y)this.a).m, ((y)this.a).l, ((y)this.a).n, ((y)this.a).q, ((y)this.a).k);
/*     */ 
/*     */ 
/*     */     
/*  59 */     g g = new g(((y)this.a).r, ((y)this.a).s, false);
/*     */     
/*  61 */     com.d.g.a.a a = new com.d.g.a.a(((y)this.a).e, ((y)this.a).d, ((y)this.a).f, ((y)this.a).u, ((y)this.a).t);
/*     */ 
/*     */ 
/*     */     
/*     */     q q;
/*     */ 
/*     */     
/*  68 */     f f = (q = new q(a, h, g, (y)this.a)).b();
/*  69 */     for (a a1 : ((y)this.a).A) {
/*  70 */       com.d.c.a.c c = null;
/*     */       
/*  72 */       if (a.a(a1) == b.b.a) {
/*  73 */         c = com.d.c.a.c.aq;
/*  74 */       } else if (a.a(a1) == b.b.b) {
/*  75 */         c = com.d.c.a.c.W;
/*  76 */       } else if (a.a(a1) == b.b.c) {
/*  77 */         c = com.d.c.a.c.at;
/*     */       } 
/*     */       
/*  80 */       if (a.b(a1) != null) {
/*  81 */         f.a(a.b(a1), a.c(a1), a.d(a1), c, a.e(a1)); continue;
/*     */       } 
/*     */       try {
/*  84 */         f.a(a.f(a1), a.c(a1), a.d(a1), c, a.e(a1));
/*  85 */       } catch (Exception exception) {
/*  86 */         l.d(Level.WARNING, "Font " + a.f(a1) + " could not be loaded", exception);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  91 */     return q;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final x a(OutputStream paramOutputStream) {
/* 102 */     ((y)this.a).B = paramOutputStream;
/* 103 */     return this;
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
/*     */   public enum b
/*     */   {
/* 253 */     a;
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
/*     */   static class a {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum c
/*     */   {
/* 304 */     a(-1, ""),
/* 305 */     b(1, "A"), c(1, "B"),
/* 306 */     d(2, "A"), e(2, "B"), f(2, "U"),
/* 307 */     g(3, "A"), h(3, "B"), i(3, "U"); private final int j; private final String k;
/*     */     
/*     */     c(int param1Int1, String param1String1) {
/* 310 */       this.j = param1Int1;
/* 311 */       this.k = param1String1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final String a() {
/* 318 */       return this.k;
/*     */     }
/*     */     
/*     */     public final int b() {
/* 322 */       return this.j;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\h\x.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */