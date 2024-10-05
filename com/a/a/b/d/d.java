/*     */ package com.a.a.b.d;
/*     */ 
/*     */ import com.a.a.b.j;
/*     */ import com.a.a.b.k;
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.b.n;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class d
/*     */   extends n
/*     */ {
/*     */   private d c;
/*     */   private b d;
/*     */   private d e;
/*     */   private String f;
/*     */   private Object g;
/*     */   private int h;
/*     */   private int i;
/*     */   
/*     */   private d(d paramd, b paramb, int paramInt1, int paramInt2, int paramInt3) {
/*  58 */     this.c = paramd;
/*  59 */     this.d = paramb;
/*  60 */     this.a = paramInt1;
/*  61 */     this.h = paramInt2;
/*  62 */     this.i = paramInt3;
/*  63 */     this.b = -1;
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
/*     */   private void a(int paramInt1, int paramInt2, int paramInt3) {
/*  80 */     this.a = paramInt1;
/*  81 */     this.b = -1;
/*  82 */     this.h = paramInt2;
/*  83 */     this.i = paramInt3;
/*  84 */     this.f = null;
/*  85 */     this.g = null;
/*  86 */     if (this.d != null) {
/*  87 */       this.d.b();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final d a(b paramb) {
/*  98 */     this.d = paramb;
/*  99 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Object h() {
/* 104 */     return this.g;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(Object paramObject) {
/* 109 */     this.g = paramObject;
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
/*     */   public static d b(b paramb) {
/* 123 */     return new d(null, paramb, 0, 1, 0);
/*     */   }
/*     */   
/*     */   public final d a(int paramInt1, int paramInt2) {
/*     */     d d1;
/* 128 */     if ((d1 = this.e) == null) {
/* 129 */       this
/* 130 */         .e = d1 = new d(this, (this.d == null) ? null : this.d.a(), 1, paramInt1, paramInt2);
/*     */     } else {
/* 132 */       d1.a(1, paramInt1, paramInt2);
/*     */     } 
/* 134 */     return d1;
/*     */   }
/*     */   
/*     */   public final d b(int paramInt1, int paramInt2) {
/*     */     d d1;
/* 139 */     if ((d1 = this.e) == null) {
/* 140 */       this
/* 141 */         .e = d1 = new d(this, (this.d == null) ? null : this.d.a(), 2, paramInt1, paramInt2);
/* 142 */       return d1;
/*     */     } 
/* 144 */     d1.a(2, paramInt1, paramInt2);
/* 145 */     return d1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String g() {
/* 154 */     return this.f;
/*     */   }
/*     */ 
/*     */   
/*     */   public final d i() {
/* 159 */     return this.c;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final j a(com.a.a.b.c.d paramd) {
/* 165 */     return new j(paramd, -1L, this.h, this.i);
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
/*     */   public final d j() {
/* 193 */     this.g = null;
/*     */     
/* 195 */     return this.c;
/*     */   }
/*     */   
/*     */   public final b k() {
/* 199 */     return this.d;
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
/*     */   public final boolean l() {
/* 213 */     int i = ++this.b;
/* 214 */     return (this.a != 0 && i > 0);
/*     */   }
/*     */   
/*     */   public final void a(String paramString) {
/* 218 */     this.f = paramString;
/* 219 */     if (this.d != null) a(this.d, paramString); 
/*     */   }
/*     */   
/*     */   private static void a(b paramb, String paramString) {
/* 223 */     if (paramb.a(paramString)) {
/* 224 */       Object object = paramb.c();
/* 225 */       throw new k((object instanceof l) ? (l)object : null, "Duplicate field '" + paramString + "'");
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\d\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */