/*     */ package com.a.a.c.i.a;
/*     */ 
/*     */ import com.a.a.b.f.a;
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.i.g;
/*     */ import com.a.a.c.i.i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class u
/*     */   extends i
/*     */ {
/*     */   protected final g b;
/*     */   protected final c c;
/*     */   
/*     */   protected u(g paramg, c paramc) {
/*  22 */     this.b = paramg;
/*  23 */     this.c = paramc;
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
/*     */   public String b() {
/*  36 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final a a(h paramh, a parama) {
/*  45 */     a(parama);
/*     */ 
/*     */ 
/*     */     
/*  49 */     if (parama.c == null) {
/*  50 */       return null;
/*     */     }
/*  52 */     return paramh.a(parama);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final a b(h paramh, a parama) {
/*  60 */     if (parama == null) {
/*  61 */       return null;
/*     */     }
/*  63 */     return paramh.b(parama);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(a parama) {
/*     */     Object object;
/*  73 */     if ((object = parama.c) == null) {
/*  74 */       object = parama.a;
/*     */       Class<?> clazz;
/*  76 */       if ((clazz = parama.b) == null) {
/*  77 */         object = a(object);
/*     */       } else {
/*  79 */         object = a(object, clazz);
/*     */       } 
/*  81 */       parama.c = object;
/*     */     } 
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
/*     */   private String a(Object paramObject) {
/*  96 */     return (String)(paramObject = this.b.a(paramObject));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String a(Object paramObject, Class<?> paramClass) {
/* 104 */     return (String)(paramObject = this.b.a(paramObject, paramClass));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\i\\\u.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */