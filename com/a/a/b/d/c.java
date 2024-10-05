/*     */ package com.a.a.b.d;
/*     */ 
/*     */ import com.a.a.b.a.a;
/*     */ import com.a.a.b.c.a;
/*     */ import com.a.a.b.c.b;
/*     */ import com.a.a.b.g.e;
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.b.p;
/*     */ import com.a.a.b.r;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class c
/*     */   extends a
/*     */ {
/*  32 */   private static int[] l = b.f();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final a e;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  63 */   protected int[] f = l;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int g;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected com.a.a.b.c.c h;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  94 */   protected r i = (r)e.c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean j;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean k;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public c(a parama, int paramInt, p paramp) {
/* 122 */     super(paramInt, paramp);
/* 123 */     this.e = parama;
/* 124 */     if (h.a.f.a(paramInt))
/*     */     {
/* 126 */       this.g = 127;
/*     */     }
/* 128 */     this.k = h.a.k.a(paramInt);
/* 129 */     this.j = !h.a.d.a(paramInt);
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
/*     */   public final h a(h.a parama) {
/* 164 */     super.a(parama);
/* 165 */     if (parama == h.a.d) {
/* 166 */       this.j = true;
/* 167 */     } else if (parama == h.a.k) {
/* 168 */       this.k = false;
/*     */     } 
/* 170 */     return (h)this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void b(int paramInt1, int paramInt2) {
/* 176 */     super.b(paramInt1, paramInt2);
/* 177 */     this.j = !h.a.d.a(paramInt1);
/* 178 */     this.k = h.a.k.a(paramInt1);
/*     */   }
/*     */ 
/*     */   
/*     */   public final h b(int paramInt) {
/* 183 */     this.g = (paramInt < 0) ? 0 : paramInt;
/* 184 */     return (h)this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final h a(com.a.a.b.c.c paramc) {
/* 195 */     this.h = paramc;
/* 196 */     if (paramc == null) {
/* 197 */       this.f = l;
/*     */     } else {
/* 199 */       throw null;
/*     */     } 
/* 201 */     return (h)this;
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
/*     */   public final h a(r paramr) {
/* 215 */     this.i = paramr;
/* 216 */     return (h)this;
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
/*     */   protected final void a(String paramString, int paramInt) {
/* 233 */     switch (paramInt) {
/*     */       case 1:
/* 235 */         this.b.f((h)this);
/*     */         return;
/*     */       case 2:
/* 238 */         this.b.d((h)this);
/*     */         return;
/*     */       case 3:
/* 241 */         this.b.a((h)this);
/*     */         return;
/*     */       
/*     */       case 0:
/* 245 */         if (this.d.b()) {
/* 246 */           this.b.g((h)this); return;
/* 247 */         }  if (this.d.d()) {
/* 248 */           this.b.h((h)this); return;
/*     */         } 
/*     */         return;
/*     */       case 5:
/* 252 */         h(paramString);
/*     */         return;
/*     */     } 
/* 255 */     m();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void h(String paramString) {
/* 262 */     f(String.format("Can not %s, expecting field name (context: %s)", new Object[] { paramString, this.d
/* 263 */             .e() }));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\d\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */