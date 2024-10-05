/*     */ package com.a.a.c.c.a;
/*     */ 
/*     */ import com.a.a.a.b;
/*     */ import com.a.a.c.f.j;
/*     */ import com.a.a.c.f.n;
/*     */ import com.a.a.c.f.o;
/*     */ import com.a.a.c.f.s;
/*     */ import com.a.a.c.w;
/*     */ 
/*     */ 
/*     */ public final class d
/*     */ {
/*     */   private com.a.a.c.a a;
/*     */   private o b;
/*     */   private int c;
/*     */   private a[] d;
/*     */   
/*     */   private d(com.a.a.c.a parama, o paramo, a[] paramArrayOfa, int paramInt) {
/*  19 */     this.a = parama;
/*  20 */     this.b = paramo;
/*  21 */     this.d = paramArrayOfa;
/*  22 */     this.c = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static d a(com.a.a.c.a parama, o paramo, s[] paramArrayOfs) {
/*     */     int i;
/*  29 */     a[] arrayOfA = new a[i = paramo.f()];
/*  30 */     for (byte b = 0; b < i; b++) {
/*  31 */       n n = paramo.c(b);
/*  32 */       b.a a1 = parama.e((j)n);
/*  33 */       arrayOfA[b] = new a(n, (paramArrayOfs == null) ? null : paramArrayOfs[b], a1);
/*     */     } 
/*  35 */     return new d(parama, paramo, arrayOfA, i);
/*     */   }
/*     */   
/*  38 */   public final o a() { return this.b; }
/*  39 */   public final int b() { return this.c; }
/*  40 */   public final b.a a(int paramInt) { return (this.d[paramInt]).c; }
/*  41 */   public final n b(int paramInt) { return (this.d[paramInt]).a; } public final s c(int paramInt) {
/*  42 */     return (this.d[paramInt]).b;
/*     */   }
/*     */   public final w d(int paramInt) {
/*     */     s s;
/*  46 */     if ((s = (this.d[paramInt]).b) != null) {
/*  47 */       return s.b();
/*     */     }
/*  49 */     return null;
/*     */   }
/*     */   
/*     */   public final w e(int paramInt) {
/*     */     s s;
/*  54 */     if ((s = (this.d[0]).b) != null && 
/*  55 */       s.e()) {
/*  56 */       return s.b();
/*     */     }
/*     */     
/*  59 */     return null;
/*     */   }
/*     */   
/*     */   public final w f(int paramInt) {
/*     */     String str;
/*  64 */     if ((str = this.a.g((j)(this.d[paramInt]).a)) != null && !str.isEmpty()) {
/*  65 */       return w.a(str);
/*     */     }
/*  67 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int c() {
/*  77 */     byte b = -1;
/*  78 */     for (byte b1 = 0; b1 < this.c; b1++) {
/*  79 */       if ((this.d[b1]).c == null) {
/*  80 */         if (b >= 0) {
/*  81 */           return -1;
/*     */         }
/*  83 */         b = b1;
/*     */       } 
/*     */     } 
/*  86 */     return b;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String toString() {
/*  91 */     return this.b.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class a
/*     */   {
/*     */     public final n a;
/*     */     public final s b;
/*     */     public final b.a c;
/*     */     
/*     */     public a(n param1n, s param1s, b.a param1a) {
/* 102 */       this.a = param1n;
/* 103 */       this.b = param1s;
/* 104 */       this.c = param1a;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\a\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */