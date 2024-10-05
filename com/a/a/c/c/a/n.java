/*     */ package com.a.a.c.c.a;
/*     */ 
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.c.c.v;
/*     */ import com.a.a.c.f.j;
/*     */ import com.a.a.c.g;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class n
/*     */   extends v.a
/*     */ {
/*     */   private j h;
/*     */   
/*     */   private n(v paramv, j paramj) {
/*  41 */     super(paramv);
/*  42 */     this.h = paramj;
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
/*     */   public static n a(v paramv, j paramj) {
/*  55 */     return new n(paramv, paramj);
/*     */   }
/*     */ 
/*     */   
/*     */   protected final v a(v paramv) {
/*  60 */     return (v)new n(paramv, this.h);
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
/*     */   public final void a(l paraml, g paramg, Object paramObject) {
/*     */     Object object1;
/*     */     Object object2;
/*  77 */     if ((object2 = this.h.b(paramObject)) == null) {
/*  78 */       object1 = this.g.a(paraml, paramg);
/*     */     } else {
/*  80 */       object1 = this.g.c((l)object1, paramg, object2);
/*     */     } 
/*  82 */     if (object1 != object2)
/*     */     {
/*     */       
/*  85 */       this.g.a(paramObject, object1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object b(l paraml, g paramg, Object paramObject) {
/*     */     Object object1;
/*     */     Object object2;
/*  97 */     if ((object2 = this.h.b(paramObject)) == null) {
/*  98 */       object1 = this.g.a(paraml, paramg);
/*     */     } else {
/* 100 */       object1 = this.g.c((l)object1, paramg, object2);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 105 */     if (object1 != object2)
/*     */     {
/*     */       
/* 108 */       if (object1 != null) {
/* 109 */         return this.g.b(paramObject, object1);
/*     */       }
/*     */     }
/* 112 */     return paramObject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(Object paramObject1, Object paramObject2) {
/* 119 */     if (paramObject2 != null) {
/* 120 */       this.g.a(paramObject1, paramObject2);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object b(Object paramObject1, Object paramObject2) {
/* 128 */     if (paramObject2 != null) {
/* 129 */       return this.g.b(paramObject1, paramObject2);
/*     */     }
/* 131 */     return paramObject1;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\a\n.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */