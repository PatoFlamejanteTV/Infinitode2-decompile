/*     */ package com.a.a.c.f;
/*     */ 
/*     */ import com.a.a.c.m.i;
/*     */ import java.io.Serializable;
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.lang.reflect.Member;
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
/*     */ public abstract class j
/*     */   extends b
/*     */   implements Serializable
/*     */ {
/*     */   protected final transient an a;
/*     */   protected final transient aa b;
/*     */   
/*     */   protected j(an paraman, aa paramaa) {
/*  37 */     this.a = paraman;
/*  38 */     this.b = paramaa;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract b a(aa paramaa);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract Class<?> h();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract Member i();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String j() {
/*  67 */     return h().getName() + "#" + b();
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
/*     */   public final <A extends Annotation> A a(Class<A> paramClass) {
/*  85 */     if (this.b == null) {
/*  86 */       return null;
/*     */     }
/*  88 */     return this.b.a(paramClass);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean b(Class<?> paramClass) {
/*  93 */     if (this.b == null) {
/*  94 */       return false;
/*     */     }
/*  96 */     return this.b.b(paramClass);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean a(Class<? extends Annotation>[] paramArrayOfClass) {
/* 101 */     if (this.b == null) {
/* 102 */       return false;
/*     */     }
/* 104 */     return this.b.a(paramArrayOfClass);
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
/*     */   public final aa k() {
/* 121 */     return this.b;
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
/*     */   public final void a(boolean paramBoolean) {
/*     */     Member member;
/* 138 */     if ((member = i()) != null)
/* 139 */       i.a(member, paramBoolean); 
/*     */   }
/*     */   
/*     */   public abstract void a(Object paramObject1, Object paramObject2);
/*     */   
/*     */   public abstract Object b(Object paramObject);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\f\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */