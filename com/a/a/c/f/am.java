/*     */ package com.a.a.c.f;
/*     */ 
/*     */ import com.a.a.c.l.b;
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
/*     */ public final class am
/*     */   implements t.a, Serializable
/*     */ {
/*     */   private t.a a;
/*     */   private Map<b, Class<?>> b;
/*     */   
/*     */   public am(t.a parama) {
/*  36 */     this.a = parama;
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
/*     */   public final Class<?> i(Class<?> paramClass) {
/*     */     Class<?> clazz;
/*  93 */     if ((clazz = (Class<?>)((this.a == null) ? null : this.a.i(paramClass))) == null && this.b != null) {
/*  94 */       clazz = this.b.get(new b(paramClass));
/*     */     }
/*  96 */     return clazz;
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
/*     */   public final boolean a() {
/* 118 */     if (this.b == null) {
/*     */       
/* 120 */       if (this.a == null) {
/* 121 */         return false;
/*     */       }
/*     */       
/* 124 */       if (this.a instanceof am) {
/* 125 */         return ((am)this.a).a();
/*     */       }
/*     */     } 
/*     */     
/* 129 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\f\am.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */