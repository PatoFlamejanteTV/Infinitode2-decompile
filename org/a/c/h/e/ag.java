/*     */ package org.a.c.h.e;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import org.a.a.a.a;
/*     */ import org.a.a.a.c;
/*     */ import org.a.b.h.a;
/*     */ import org.a.c.b.a;
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.b.p;
/*     */ import org.a.c.h.a.h;
/*     */ import org.a.c.h.e.a.b;
/*     */ import org.a.c.h.e.a.c;
/*     */ import org.a.c.h.e.a.d;
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
/*     */ public class ag
/*     */   extends aa
/*     */ {
/*  50 */   private static final a e = c.a(ag.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private d f;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private d g;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private a h;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ag(d paramd, k paramk) {
/*  76 */     super(paramd);
/*     */     
/*  78 */     l();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String d() {
/*  84 */     return this.b.g(j.cp);
/*     */   }
/*     */ 
/*     */   
/*     */   protected final void l() {
/*     */     j j;
/*     */     b b;
/*  91 */     if (b = this.b.a(j.aR) instanceof j) {
/*     */       
/*  93 */       j = (j)b;
/*  94 */       this.c = c.a(j);
/*  95 */       if (this.c == null)
/*     */       {
/*  97 */         (new StringBuilder("Unknown encoding: ")).append(j.a());
/*     */       }
/*     */     }
/* 100 */     else if (j instanceof d) {
/*     */       
/* 102 */       this.c = (c)new b((d)j);
/*     */     } 
/* 104 */     this.d = d.a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final c m() {
/* 111 */     throw new UnsupportedOperationException("not supported for Type 3 fonts");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected final Boolean q() {
/* 117 */     return Boolean.FALSE;
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
/*     */   public final float a(int paramInt) {
/* 150 */     int i = this.b.b(j.ba, -1);
/* 151 */     int j = this.b.b(j.bW, -1);
/* 152 */     if (!g().isEmpty() && paramInt >= i && paramInt <= j) {
/*     */       Float float_;
/*     */       
/* 155 */       return ((float_ = g().get(paramInt - i)) == null) ? 0.0F : float_.floatValue();
/*     */     } 
/*     */     
/*     */     v v;
/*     */     
/* 160 */     if ((v = b()) != null)
/*     */     {
/* 162 */       return v.n();
/*     */     }
/*     */ 
/*     */     
/* 166 */     return c(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float c(int paramInt) {
/*     */     af af;
/* 175 */     if ((af = g(paramInt)) != null) { af.b(); if (af
/* 176 */         .b().d() != 0)
/*     */       {
/*     */ 
/*     */         
/* 180 */         return af.d(); }  }
/*     */     
/*     */     return 0.0F;
/*     */   }
/*     */   
/*     */   public final boolean c() {
/* 186 */     return true;
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
/*     */   protected final byte[] d(int paramInt) {
/* 228 */     throw new UnsupportedOperationException("Not implemented: Type3");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int a(InputStream paramInputStream) {
/* 234 */     return paramInputStream.read();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final d h() {
/* 240 */     if (this.g == null) {
/*     */       b b;
/*     */       
/* 243 */       if (b = this.b.a(j.bl) instanceof a) {
/*     */         
/* 245 */         this.g = new d((a)b);
/*     */       }
/*     */       else {
/*     */         
/* 249 */         return super.h();
/*     */       } 
/*     */     } 
/* 252 */     return this.g;
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
/*     */   private h s() {
/* 287 */     b b = this.b.a(j.bf);
/* 288 */     h h = null;
/* 289 */     if (b instanceof a)
/*     */     {
/* 291 */       h = new h((a)b);
/*     */     }
/* 293 */     return h;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final a e() {
/* 299 */     if (this.h == null)
/*     */     {
/* 301 */       this.h = t();
/*     */     }
/* 303 */     return this.h;
/*     */   }
/*     */ 
/*     */   
/*     */   private a t() {
/*     */     h h;
/* 309 */     if ((h = s()).c() == 0.0F && h.d() == 0.0F && h
/* 310 */       .e() == 0.0F && h.g() == 0.0F) {
/*     */       d d1;
/*     */ 
/*     */       
/* 314 */       for (j j : (d1 = u()).d()) {
/*     */         b b;
/*     */         
/* 317 */         if (b = d1.a(j) instanceof p) {
/*     */           
/* 319 */           af af = new af(this, (p)b);
/*     */           
/*     */           try {
/*     */             h h1;
/* 323 */             if ((h1 = af.c()) == null) {
/*     */               continue;
/*     */             }
/*     */             
/* 327 */             h.a(Math.min(h.c(), h1.c()));
/* 328 */             h.b(Math.min(h.d(), h1.d()));
/* 329 */             h.c(Math.max(h.e(), h1.e()));
/* 330 */             h.d(Math.max(h.g(), h1.g()));
/*     */           }
/* 332 */           catch (IOException iOException) {}
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 339 */     return new a(h.c(), h.d(), h
/* 340 */         .e(), h.g());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private d u() {
/* 350 */     if (this.f == null)
/*     */     {
/* 352 */       this.f = (d)this.b.a(j.T);
/*     */     }
/* 354 */     return this.f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private af g(int paramInt) {
/* 365 */     String str = n().a(paramInt);
/*     */     b b;
/* 367 */     if (b = u().a(j.a(str)) instanceof p)
/*     */     {
/* 369 */       return new af(this, (p)b);
/*     */     }
/* 371 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\e\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */