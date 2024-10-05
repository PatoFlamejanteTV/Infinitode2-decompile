/*     */ package com.a.a.c;
/*     */ 
/*     */ import com.a.a.c.c.a.l;
/*     */ import com.a.a.c.l.n;
/*     */ import com.a.a.c.l.o;
/*     */ import com.a.a.c.m.i;
/*     */ import java.io.Serializable;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.lang.reflect.Type;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends l
/*     */   implements Serializable, Type
/*     */ {
/*     */   protected final Class<?> a;
/*     */   private int e;
/*     */   protected final Object b;
/*     */   protected final Object c;
/*     */   protected final boolean d;
/*     */   
/*     */   protected j(Class<?> paramClass, int paramInt, Object paramObject1, Object paramObject2, boolean paramBoolean) {
/*  88 */     this.a = paramClass;
/*  89 */     this.e = paramClass.getName().hashCode() + paramInt;
/*  90 */     this.b = paramObject1;
/*  91 */     this.c = paramObject2;
/*  92 */     this.d = paramBoolean;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public j b(j paramj) {
/* 210 */     j j1 = this;
/*     */     Object object;
/* 212 */     if ((object = paramj.B()) != this.c) {
/* 213 */       j1 = j1.a(object);
/*     */     }
/*     */     
/* 216 */     if ((object = paramj.A()) != this.b) {
/* 217 */       j1 = j1.c(object);
/*     */     }
/* 219 */     return j1;
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
/*     */   public final Class<?> b() {
/* 266 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean a(Class<?> paramClass) {
/* 274 */     return (this.a == paramClass);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean c() {
/* 284 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean b(Class<?> paramClass) {
/* 291 */     return (this.a == paramClass || paramClass.isAssignableFrom(this.a));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean c(Class<?> paramClass) {
/* 298 */     return (this.a == paramClass || this.a.isAssignableFrom(paramClass));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean d() {
/* 303 */     return Modifier.isAbstract(this.a.getModifiers());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean e() {
/*     */     int i;
/* 314 */     if (((i = this.a.getModifiers()) & 0x600) == 0) {
/* 315 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 320 */     return this.a.isPrimitive();
/*     */   }
/*     */   
/*     */   public final boolean f() {
/* 324 */     return Throwable.class.isAssignableFrom(this.a);
/*     */   }
/*     */   public boolean g() {
/* 327 */     return false;
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
/*     */   public final boolean h() {
/* 340 */     return i.k(this.a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean i() {
/* 350 */     return (i.k(this.a) && this.a != Enum.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean j() {
/* 357 */     return i.f(this.a);
/*     */   }
/*     */   
/*     */   public final boolean k() {
/* 361 */     return this.a.isInterface();
/*     */   }
/*     */   public final boolean l() {
/* 364 */     return this.a.isPrimitive();
/*     */   }
/*     */   public final boolean m() {
/* 367 */     return Modifier.isFinal(this.a.getModifiers());
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
/*     */   public boolean o() {
/* 382 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean p() {
/* 390 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean q() {
/* 401 */     return (this.a == Object.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean r() {
/* 411 */     return this.d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean s() {
/* 420 */     return (w() > 0);
/*     */   }
/*     */   public j t() {
/* 423 */     return null;
/*     */   }
/*     */   public j u() {
/* 426 */     return null;
/*     */   }
/*     */   public j v() {
/* 429 */     return null;
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
/*     */   public final j b(int paramInt) {
/*     */     j j1;
/* 471 */     return ((j1 = a(paramInt)) == null) ? o.b() : j1;
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
/*     */   
/*     */   public final <T> T A() {
/* 528 */     return (T)this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final <T> T B() {
/* 538 */     return (T)this.c;
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
/*     */   public boolean C() {
/* 576 */     return (this.c != null || this.b != null);
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
/*     */   public final String D() {
/* 596 */     StringBuilder stringBuilder = new StringBuilder(40);
/* 597 */     a(stringBuilder);
/* 598 */     return stringBuilder.toString();
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
/*     */   public final int hashCode() {
/* 648 */     return this.e;
/*     */   }
/*     */   
/*     */   public abstract j a(j paramj);
/*     */   
/*     */   public abstract j a();
/*     */   
/*     */   public abstract j a(Object paramObject);
/*     */   
/*     */   public abstract j b(Object paramObject);
/*     */   
/*     */   public abstract j c(Object paramObject);
/*     */   
/*     */   public abstract j d(Object paramObject);
/*     */   
/*     */   public abstract j a(Class<?> paramClass, n paramn, j paramj, j[] paramArrayOfj);
/*     */   
/*     */   public abstract boolean n();
/*     */   
/*     */   public abstract int w();
/*     */   
/*     */   public abstract j a(int paramInt);
/*     */   
/*     */   public abstract n x();
/*     */   
/*     */   public abstract j d(Class<?> paramClass);
/*     */   
/*     */   public abstract j y();
/*     */   
/*     */   public abstract List<j> z();
/*     */   
/*     */   public abstract StringBuilder a(StringBuilder paramStringBuilder);
/*     */   
/*     */   public abstract StringBuilder b(StringBuilder paramStringBuilder);
/*     */   
/*     */   public abstract String toString();
/*     */   
/*     */   public abstract boolean equals(Object paramObject);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */