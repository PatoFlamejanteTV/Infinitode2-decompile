/*     */ package com.a.a.c.c.a;
/*     */ 
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.c.c.v;
/*     */ import com.a.a.c.f;
/*     */ import com.a.a.c.g;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
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
/*     */ public final class m
/*     */   extends v.a
/*     */ {
/*     */   private String h;
/*     */   private boolean i;
/*     */   private v j;
/*     */   
/*     */   public m(v paramv1, String paramString, v paramv2, boolean paramBoolean) {
/*  35 */     super(paramv1);
/*  36 */     this.h = paramString;
/*  37 */     this.j = paramv2;
/*  38 */     this.i = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   protected final v a(v paramv) {
/*  43 */     throw new IllegalStateException("Should never try to reset delegate");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(f paramf) {
/*  49 */     this.g.a(paramf);
/*  50 */     this.j.a(paramf);
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
/*     */   public final void a(l paraml, g paramg, Object paramObject) {
/*  62 */     a(paramObject, this.g.a(paraml, paramg));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object b(l paraml, g paramg, Object paramObject) {
/*  68 */     return b(paramObject, a(paraml, paramg));
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(Object paramObject1, Object paramObject2) {
/*  73 */     b(paramObject1, paramObject2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object b(Object paramObject1, Object paramObject2) {
/*  82 */     if (paramObject2 != null) {
/*  83 */       if (this.i) {
/*  84 */         if (paramObject2 instanceof Object[]) {
/*  85 */           Object[] arrayOfObject; int i; byte b; for (i = (arrayOfObject = (Object[])paramObject2).length, b = 0; b < i; b++) {
/*  86 */             Object object; if ((object = arrayOfObject[b]) != null) this.j.a(object, paramObject1); 
/*     */           } 
/*  88 */         } else if (paramObject2 instanceof Collection) {
/*  89 */           for (Iterator<Object> iterator = ((Collection)paramObject2).iterator(); iterator.hasNext();) {
/*  90 */             if ((object = iterator.next()) != null) this.j.a(object, paramObject1); 
/*     */           } 
/*  92 */         } else if (paramObject2 instanceof Map) {
/*  93 */           for (Iterator<Object> iterator = ((Map)paramObject2).values().iterator(); iterator.hasNext();) {
/*  94 */             if ((object = iterator.next()) != null) this.j.a(object, paramObject1); 
/*     */           } 
/*     */         } else {
/*  97 */           throw new IllegalStateException("Unsupported container type (" + paramObject2.getClass().getName() + ") when resolving reference '" + this.h + "'");
/*     */         } 
/*     */       } else {
/*     */         
/* 101 */         this.j.a(paramObject2, paramObject1);
/*     */       } 
/*     */     }
/*     */     
/* 105 */     return this.g.b(paramObject1, paramObject2);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\a\m.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */