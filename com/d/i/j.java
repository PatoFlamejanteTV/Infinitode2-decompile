/*     */ package com.d.i;
/*     */ 
/*     */ import com.d.c.f.d;
/*     */ import com.d.e.v;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class j
/*     */ {
/*     */   private j a;
/*     */   private int b;
/*  31 */   private List c = new ArrayList();
/*     */   
/*     */   private aa d;
/*     */   
/*     */   public j(v paramv, int paramInt) {
/*  36 */     this.b = c(paramv, paramInt).i();
/*     */   }
/*     */   
/*     */   public final int a() {
/*  40 */     return this.b;
/*     */   }
/*     */   
/*     */   public final int b() {
/*  44 */     return this.b + this.c.size() - 1;
/*     */   }
/*     */   
/*     */   public final i a(int paramInt) {
/*  48 */     return a(paramInt, false);
/*     */   }
/*     */   
/*     */   private i a(int paramInt, boolean paramBoolean) {
/*  52 */     if (paramBoolean) {
/*  53 */       while (this.c.size() < paramInt - this.b + 1) {
/*  54 */         this.c.add(new i());
/*     */       }
/*     */     }
/*     */     
/*     */     int i;
/*  59 */     if ((i = paramInt - this.b) >= 0 && i < this.c.size()) {
/*  60 */       return this.c.get(paramInt - this.b);
/*     */     }
/*  62 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(v paramv, int paramInt) {
/*  67 */     aa aa1 = c(paramv, paramInt);
/*     */     
/*  69 */     a(aa1.i(), true).a(paramInt);
/*     */     
/*     */     j j1;
/*  72 */     if ((j1 = e()) != null) {
/*  73 */       j1.a(paramv, paramInt);
/*     */     }
/*     */   }
/*     */   
/*     */   public final void b(v paramv, int paramInt) {
/*  78 */     aa aa1 = c(paramv, paramInt);
/*     */     
/*  80 */     a(aa1.i(), true).b(paramInt);
/*     */     
/*     */     j j1;
/*  83 */     if ((j1 = e()) != null) {
/*  84 */       j1.b(paramv, paramInt);
/*     */     }
/*     */   }
/*     */   
/*     */   private aa c(v paramv, int paramInt) {
/*     */     aa aa1;
/*     */     aa aa2;
/*  91 */     if ((aa2 = d()) != null && paramInt >= aa2.b() && paramInt < aa2.a()) {
/*  92 */       aa1 = aa2;
/*     */     } else {
/*  94 */       aa1 = aa1.p().a((d)aa1, paramInt);
/*  95 */       a(aa1);
/*     */     } 
/*  97 */     return aa1;
/*     */   }
/*     */   
/*     */   private aa d() {
/* 101 */     j j1 = this;
/* 102 */     while (j1.e() != null) {
/* 103 */       j1 = j1.e();
/*     */     }
/* 105 */     return j1.d;
/*     */   }
/*     */   
/*     */   private void a(aa paramaa) {
/* 109 */     j j1 = this;
/* 110 */     while (j1.e() != null) {
/* 111 */       j1 = j1.e();
/*     */     }
/* 113 */     j1.d = paramaa;
/*     */   }
/*     */   
/*     */   private j e() {
/* 117 */     return this.a;
/*     */   }
/*     */   
/*     */   public final void a(j paramj) {
/* 121 */     this.a = paramj;
/*     */   }
/*     */   
/*     */   public final boolean c() {
/* 125 */     return (this.c.size() > 1);
/*     */   }
/*     */   
/*     */   public final String toString() {
/* 129 */     return "[initialPageNo=" + this.b + ", limits=" + this.c + "]";
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\i\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */