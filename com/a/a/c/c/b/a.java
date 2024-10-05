/*     */ package com.a.a.c.c.b;
/*     */ 
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.c.c.s;
/*     */ import com.a.a.c.c.x;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.i.e;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.concurrent.ArrayBlockingQueue;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class a
/*     */   extends h
/*     */ {
/*     */   public a(j paramj, k<Object> paramk, e parame, x paramx) {
/*  33 */     super(paramj, paramk, parame, paramx);
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
/*     */   private a(j paramj, k<Object> paramk1, e parame, x paramx, k<Object> paramk2, s params, Boolean paramBoolean) {
/*  45 */     super(paramj, paramk1, parame, paramx, paramk2, params, paramBoolean);
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
/*     */   private a b(k<?> paramk1, k<?> paramk2, e parame, s params, Boolean paramBoolean) {
/*  66 */     return new a(this.b, (k)paramk2, parame, this.a, (k)paramk1, params, paramBoolean);
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
/*     */   protected final Collection<Object> d(g paramg) {
/*  85 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final Collection<Object> a(l paraml, g paramg, Collection<Object> paramCollection) {
/*  94 */     if (paramCollection == null) {
/*  95 */       paramCollection = new ArrayList();
/*     */     }
/*     */     
/*  98 */     if ((paramCollection = super.a(paraml, paramg, paramCollection)).isEmpty()) {
/*  99 */       return new ArrayBlockingQueue(1, false);
/*     */     }
/* 101 */     return new ArrayBlockingQueue(paramCollection.size(), false, paramCollection);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object a(l paraml, g paramg, e parame) {
/* 107 */     return parame.b(paraml, paramg);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\b\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */