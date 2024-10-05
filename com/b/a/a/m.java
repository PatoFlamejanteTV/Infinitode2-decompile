/*     */ package com.b.a.a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class m
/*     */ {
/*     */   public final o a;
/*     */   private a c;
/*     */   public final b b;
/*     */   
/*     */   public static final class g
/*     */     extends com.b.a.c.h
/*     */   {
/*     */     public final boolean b(int param1Int) {
/*  77 */       return true;
/*     */     } }
/*     */   
/*     */   public static abstract class i extends com.b.a.c.h {
/*     */     public final o a;
/*     */     
/*     */     public i(o param1o) {
/*  84 */       this.a = param1o;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final int c(int param1Int) {
/* 147 */       return this.a.e(this.a.a(param1Int));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public abstract int a(int param1Int);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class b
/*     */     extends i
/*     */   {
/*     */     public b(o param1o) {
/* 167 */       super(param1o);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final int a(int param1Int) {
/* 185 */       return this.a.d(this.a.a(param1Int)) ? 1 : 0;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean b(int param1Int) {
/* 192 */       return this.a.j(param1Int);
/*     */     } }
/*     */   
/*     */   public static final class a extends i {
/*     */     public a(o param1o, boolean param1Boolean) {
/* 197 */       super(param1o);
/* 198 */       this.b = param1Boolean;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final boolean b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final int a(int param1Int) {
/* 235 */       return this.a.b(this.a.a(param1Int));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean b(int param1Int) {
/* 245 */       return this.a.a(param1Int, this.b, true);
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class c
/*     */     extends i
/*     */   {
/*     */     public c(o param1o) {
/* 253 */       super(param1o);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final int a(int param1Int) {
/* 271 */       return this.a.d(this.a.a(param1Int)) ? 1 : 0;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean b(int param1Int) {
/* 278 */       return this.a.k(param1Int);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private m(o paramo) {
/* 284 */     this.a = paramo;
/* 285 */     this.c = new a(paramo, false);
/* 286 */     this.b = new b(paramo);
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
/*     */   private static m a(h paramh) {
/* 298 */     if (h.a(paramh) != null) {
/* 299 */       throw h.a(paramh);
/*     */     }
/* 301 */     return h.b(paramh);
/*     */   }
/*     */   public static m a() {
/* 304 */     return a(d.a());
/*     */   }
/*     */   private static m c() {
/* 307 */     return a(e.a());
/*     */   }
/*     */   public static m b() {
/* 310 */     return a(f.a());
/*     */   }
/*     */   
/*     */   public static i a(int paramInt) {
/* 314 */     switch (paramInt) { case 0:
/* 315 */         return (a()).b;
/* 316 */       case 1: return (c()).b;
/* 317 */       case 2: return (a()).c;
/* 318 */       case 3: return (c()).c; }
/* 319 */      return null;
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
/*     */   static final class h
/*     */   {
/*     */     private m a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private RuntimeException b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private h(String param1String) {
/*     */       try {
/* 369 */         o o = (new o()).a(param1String + ".nrm");
/* 370 */         this.a = new m(o, (byte)0); return;
/* 371 */       } catch (RuntimeException runtimeException) {
/* 372 */         this.b = runtimeException;
/*     */         return;
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   static final class d
/*     */   {
/* 380 */     private static final m.h a = new m.h("nfc", (byte)0);
/*     */   }
/*     */   
/* 383 */   static final class e { private static final m.h a = new m.h("nfkc", (byte)0); }
/*     */   
/*     */   static final class f {
/* 386 */     private static final m.h a = new m.h("nfkc_cf", (byte)0);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\b\a\a\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */