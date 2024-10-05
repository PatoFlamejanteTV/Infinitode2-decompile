/*     */ package com.a.a.c.b;
/*     */ 
/*     */ import com.a.a.a.ac;
/*     */ import com.a.a.a.l;
/*     */ import com.a.a.a.s;
/*     */ import com.a.a.c.f.ap;
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class h
/*     */   implements Serializable
/*     */ {
/*     */   private Map<Class<?>, Object> a;
/*     */   private s.b b;
/*     */   private ac.a c;
/*     */   private ap<?> d;
/*     */   private Boolean e;
/*     */   private Boolean f;
/*     */   
/*     */   public h() {
/*  64 */     this(null, 
/*     */         
/*  66 */         s.b.a(), 
/*  67 */         ac.a.a(), 
/*  68 */         (ap<?>)ap.a.a(), null, null);
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
/*     */   private h(Map<Class<?>, Object> paramMap, s.b paramb, ac.a parama, ap<?> paramap, Boolean paramBoolean1, Boolean paramBoolean2) {
/*  80 */     this.a = paramMap;
/*  81 */     this.b = paramb;
/*  82 */     this.c = parama;
/*  83 */     this.d = paramap;
/*  84 */     this.e = paramBoolean1;
/*  85 */     this.f = paramBoolean2;
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
/*     */   public final g a(Class<?> paramClass) {
/* 121 */     if (this.a == null) {
/* 122 */       return null;
/*     */     }
/* 124 */     return (g)this.a.get(paramClass);
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
/*     */   public final l.d b(Class<?> paramClass) {
/*     */     l.d d;
/*     */     g g;
/* 149 */     if (this.a != null && (
/*     */       
/* 151 */       g = (g)this.a.get(paramClass)) != null && (
/*     */       
/* 153 */       d = g.b()) != null) {
/* 154 */       if (!d.k()) {
/* 155 */         return d.a(this.f);
/*     */       }
/* 157 */       return d;
/*     */     } 
/*     */ 
/*     */     
/* 161 */     if (this.f == null) {
/* 162 */       return l.d.a();
/*     */     }
/* 164 */     return l.d.a(this.f.booleanValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final s.b a() {
/* 174 */     return this.b;
/*     */   }
/*     */   
/*     */   public final ac.a b() {
/* 178 */     return this.c;
/*     */   }
/*     */   
/*     */   public final Boolean c() {
/* 182 */     return this.e;
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
/*     */   public final ap<?> d() {
/* 196 */     return this.d;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\b\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */