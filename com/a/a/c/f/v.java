/*     */ package com.a.a.c.f;
/*     */ 
/*     */ import com.a.a.a.l;
/*     */ import com.a.a.a.s;
/*     */ import com.a.a.c.a;
/*     */ import com.a.a.c.b.q;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.w;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collections;
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
/*     */ public abstract class v
/*     */   implements c, Serializable
/*     */ {
/*     */   private com.a.a.c.v b;
/*     */   private transient List<w> c;
/*     */   
/*     */   protected v(com.a.a.c.v paramv) {
/*  38 */     this.b = (paramv == null) ? com.a.a.c.v.c : paramv;
/*     */   }
/*     */   
/*     */   protected v(v paramv) {
/*  42 */     this.b = paramv.b;
/*     */   }
/*     */   
/*     */   public final boolean t() {
/*  46 */     return this.b.a();
/*     */   }
/*     */   public com.a.a.c.v d() {
/*  49 */     return this.b;
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
/*     */   public final l.d a(q<?> paramq, Class<?> paramClass) {
/*  73 */     l.d d1 = paramq.f(paramClass);
/*  74 */     l.d d2 = null; a a;
/*     */     j j;
/*  76 */     if ((a = paramq.j()) != null && (
/*     */       
/*  78 */       j = e()) != null) {
/*  79 */       d2 = a.h(j);
/*     */     }
/*     */     
/*  82 */     if (d1 == null) {
/*  83 */       return (d2 == null) ? a : d2;
/*     */     }
/*  85 */     return (d2 == null) ? d1 : d1.a(d2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final s.b b(q<?> paramq, Class<?> paramClass) {
/*  91 */     a a = paramq.j();
/*     */     j j;
/*  93 */     if ((j = e()) == null)
/*     */     {
/*  95 */       return b1 = paramq.e(paramClass);
/*     */     }
/*  97 */     s.b b1 = b1.a(paramClass, j.d());
/*  98 */     if (a == null) {
/*  99 */       return b1;
/*     */     }
/* 101 */     s.b b2 = a.t(j);
/* 102 */     if (b1 == null) {
/* 103 */       return b2;
/*     */     }
/* 105 */     return b1.a(b2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final List<w> a(q<?> paramq) {
/*     */     List<w> list;
/* 112 */     if ((list = this.c) == null) {
/*     */       a a; j j;
/* 114 */       if ((a = paramq.j()) != null && (
/*     */         
/* 116 */         j = e()) != null) {
/* 117 */         list = a.l(j);
/*     */       }
/*     */       
/* 120 */       if (list == null) {
/* 121 */         list = Collections.emptyList();
/*     */       }
/* 123 */       this.c = list;
/*     */     } 
/* 125 */     return list;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\f\v.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */