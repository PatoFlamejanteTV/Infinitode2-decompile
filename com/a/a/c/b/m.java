/*     */ package com.a.a.c.b;
/*     */ 
/*     */ import com.a.a.c.c.b.ah;
/*     */ import com.a.a.c.c.r;
/*     */ import com.a.a.c.f.w;
/*     */ import com.a.a.c.k.a.d;
/*     */ import com.a.a.c.m.e;
/*     */ import com.d.c.d.a.j;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class m
/*     */   implements Serializable
/*     */ {
/*  17 */   private static w.a[] a = new w.a[0];
/*  18 */   private static j[] b = new j[0];
/*  19 */   private static d[] c = new d[0];
/*  20 */   private static w.a[] d = new w.a[0];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  28 */   private static r[] e = new r[] { (r)new ah() };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private w.a[] f;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private r[] g;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private j[] h;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private d[] i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private w.a[] j;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public m() {
/*  71 */     this(null, null, null, null, null);
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
/*     */   private m(w.a[] paramArrayOfa1, r[] paramArrayOfr, j[] paramArrayOfj, d[] paramArrayOfd, w.a[] paramArrayOfa2) {
/*  84 */     this.f = (paramArrayOfa1 == null) ? a : paramArrayOfa1;
/*     */     
/*  86 */     this.g = (paramArrayOfr == null) ? e : paramArrayOfr;
/*     */     
/*  88 */     this.h = (paramArrayOfj == null) ? b : paramArrayOfj;
/*  89 */     this.i = (paramArrayOfd == null) ? c : paramArrayOfd;
/*  90 */     this.j = (paramArrayOfa2 == null) ? d : paramArrayOfa2;
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
/*     */   public final boolean a() {
/* 180 */     return (this.g.length > 0);
/*     */   } public final boolean b() {
/* 182 */     return (this.h.length > 0);
/*     */   } public final boolean c() {
/* 184 */     return (this.i.length > 0);
/*     */   } public final boolean d() {
/* 186 */     return (this.j.length > 0);
/*     */   }
/*     */   public final Iterable<w.a> e() {
/* 189 */     return (Iterable<w.a>)new e((Object[])this.f);
/*     */   }
/*     */   
/*     */   public final Iterable<r> f() {
/* 193 */     return (Iterable<r>)new e((Object[])this.g);
/*     */   }
/*     */   
/*     */   public final Iterable<j> g() {
/* 197 */     return (Iterable<j>)new e((Object[])this.h);
/*     */   }
/*     */   
/*     */   public final Iterable<d> h() {
/* 201 */     return (Iterable<d>)new e((Object[])this.i);
/*     */   }
/*     */   
/*     */   public final Iterable<w.a> i() {
/* 205 */     return (Iterable<w.a>)new e((Object[])this.j);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\b\m.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */