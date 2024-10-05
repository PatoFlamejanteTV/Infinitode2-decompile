/*     */ package org.a.c.g;
/*     */ 
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.n;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class c
/*     */   implements Comparable<c>
/*     */ {
/*     */   private long a;
/*     */   private n b;
/*     */   private boolean c = false;
/*     */   private static final c d;
/*     */   
/*     */   static {
/*  40 */     (d = new c(0L, null, new n(0L, 65535))).a(true);
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
/*     */   public c(long paramLong, b paramb, n paramn) {
/*  52 */     a(paramLong);
/*     */     
/*  54 */     a(paramn);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int a(c paramc) {
/*  63 */     if (paramc != null) {
/*     */       
/*  65 */       if (b().b() < paramc.b().b())
/*     */       {
/*  67 */         return -1;
/*     */       }
/*  69 */       if (b().b() > paramc.b().b())
/*     */       {
/*  71 */         return 1;
/*     */       }
/*  73 */       return 0;
/*     */     } 
/*  75 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static c a() {
/*  85 */     return d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final n b() {
/*  95 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final long c() {
/* 105 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean d() {
/* 115 */     return this.c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(boolean paramBoolean) {
/* 125 */     this.c = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(n paramn) {
/* 135 */     this.b = paramn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(long paramLong) {
/* 145 */     this.a = paramLong;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\g\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */