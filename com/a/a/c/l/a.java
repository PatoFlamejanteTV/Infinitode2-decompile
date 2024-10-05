/*     */ package com.a.a.c.l;
/*     */ 
/*     */ import com.a.a.c.j;
/*     */ import java.lang.reflect.Array;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends m
/*     */ {
/*     */   private j e;
/*     */   private Object f;
/*     */   
/*     */   private a(j paramj, n paramn, Object paramObject1, Object paramObject2, Object paramObject3, boolean paramBoolean) {
/*  33 */     super(paramObject1.getClass(), paramn, (j)null, (j[])null, paramj
/*  34 */         .hashCode(), paramObject2, paramObject3, paramBoolean);
/*     */     
/*  36 */     this.e = paramj;
/*  37 */     this.f = paramObject1;
/*     */   }
/*     */   
/*     */   public static a a(j paramj, n paramn) {
/*  41 */     return a(paramj, paramn, (Object)null, (Object)null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static a a(j paramj, n paramn, Object paramObject1, Object paramObject2) {
/*  47 */     Object object = Array.newInstance(paramj.b(), 0);
/*  48 */     return new a(paramj, paramn, object, paramObject1, paramObject2, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public final j a(j paramj) {
/*  53 */     Object object = Array.newInstance(paramj.b(), 0);
/*  54 */     return new a(paramj, this.i, object, this.b, this.c, this.d);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private a e(Object paramObject) {
/*  61 */     if (paramObject == this.c) {
/*  62 */       return this;
/*     */     }
/*  64 */     return new a(this.e, this.i, this.f, this.b, paramObject, this.d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private a f(Object paramObject) {
/*  70 */     if (paramObject == this.e.B()) {
/*  71 */       return this;
/*     */     }
/*  73 */     return new a(this.e.a(paramObject), this.i, this.f, this.b, this.c, this.d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private a g(Object paramObject) {
/*  79 */     if (paramObject == this.b) {
/*  80 */       return this;
/*     */     }
/*  82 */     return new a(this.e, this.i, this.f, paramObject, this.c, this.d);
/*     */   }
/*     */ 
/*     */   
/*     */   private a h(Object paramObject) {
/*  87 */     if (paramObject == this.e.A()) {
/*  88 */       return this;
/*     */     }
/*  90 */     return new a(this.e.c(paramObject), this.i, this.f, this.b, this.c, this.d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private a J() {
/*  96 */     if (this.d) {
/*  97 */       return this;
/*     */     }
/*  99 */     return new a(this.e.a(), this.i, this.f, this.b, this.c, true);
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
/*     */   public final j a(Class<?> paramClass, n paramn, j paramj, j[] paramArrayOfj) {
/* 124 */     return null;
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
/*     */   public final boolean g() {
/* 138 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean d() {
/* 146 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean e() {
/* 154 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean s() {
/* 159 */     return this.e.s();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean n() {
/* 169 */     return true;
/*     */   }
/*     */   public final j u() {
/* 172 */     return this.e;
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
/*     */   public final boolean C() {
/* 186 */     return (super.C() || this.e.C());
/*     */   }
/*     */ 
/*     */   
/*     */   public final StringBuilder a(StringBuilder paramStringBuilder) {
/* 191 */     paramStringBuilder.append('[');
/* 192 */     return this.e.a(paramStringBuilder);
/*     */   }
/*     */ 
/*     */   
/*     */   public final StringBuilder b(StringBuilder paramStringBuilder) {
/* 197 */     paramStringBuilder.append('[');
/* 198 */     return this.e.b(paramStringBuilder);
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
/*     */   public final Object[] H() {
/* 211 */     return (Object[])this.f;
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
/*     */   public final String toString() {
/* 223 */     return "[array type, component type: " + this.e + "]";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 229 */     if (paramObject == this) return true; 
/* 230 */     if (paramObject == null) return false; 
/* 231 */     if (paramObject.getClass() != getClass()) return false;
/*     */     
/* 233 */     paramObject = paramObject;
/* 234 */     return this.e.equals(((a)paramObject).e);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\l\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */