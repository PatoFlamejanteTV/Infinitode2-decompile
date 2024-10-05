/*     */ package org.a.c.h.g.b;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.h.a.b;
/*     */ import org.a.c.h.a.c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class p
/*     */   implements c
/*     */ {
/*     */   private b a;
/*     */   
/*     */   private p() {}
/*     */   
/*     */   public p(b paramb) {
/*  49 */     this.a = paramb;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final b f() {
/*  55 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean a() {
/*  63 */     return !(this.a instanceof org.a.c.b.p);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean b() {
/*  71 */     return this.a instanceof org.a.c.b.p;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final q c() {
/*  81 */     if (!b())
/*     */     {
/*  83 */       throw new IllegalStateException("This entry is not an appearance stream");
/*     */     }
/*  85 */     return new q((org.a.c.b.p)this.a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Map<j, q> d() {
/*  95 */     if (!a())
/*     */     {
/*  97 */       throw new IllegalStateException("This entry is not an appearance subdictionary");
/*     */     }
/*     */     
/* 100 */     d d = (d)this.a;
/* 101 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/*     */     
/* 103 */     for (j j : d.d()) {
/*     */       b b1;
/*     */ 
/*     */ 
/*     */       
/* 108 */       if (b1 = d.a(j) instanceof org.a.c.b.p)
/*     */       {
/* 110 */         hashMap.put(j, new q((org.a.c.b.p)b1));
/*     */       }
/*     */     } 
/*     */     
/* 114 */     return (Map<j, q>)new b(hashMap, d);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\g\b\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */