/*     */ package com.google.common.base;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ElementTypesAreNonnullByDefault
/*     */ public abstract class Equivalence<T>
/*     */ {
/*     */   public final boolean equivalent(T paramT1, T paramT2) {
/*  69 */     if (paramT1 == paramT2) {
/*  70 */       return true;
/*     */     }
/*  72 */     if (paramT1 == null || paramT2 == null) {
/*  73 */       return false;
/*     */     }
/*  75 */     return doEquivalent(paramT1, paramT2);
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
/*     */   protected abstract boolean doEquivalent(T paramT1, T paramT2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int hash(T paramT) {
/* 103 */     if (paramT == null) {
/* 104 */       return 0;
/*     */     }
/* 106 */     return doHash(paramT);
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
/*     */   protected abstract int doHash(T paramT);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final <F> Equivalence<F> onResultOf(Function<? super F, ? extends T> paramFunction) {
/* 145 */     return new FunctionalEquivalence<>(paramFunction, this);
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
/*     */   public final <S extends T> Wrapper<S> wrap(@ParametricNullness S paramS) {
/*     */     Wrapper<S> wrapper;
/* 192 */     return wrapper = new Wrapper<>(this, paramS);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Wrapper<T>
/*     */     implements Serializable
/*     */   {
/*     */     private final Equivalence<? super T> equivalence;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @ParametricNullness
/*     */     private final T reference;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static final long serialVersionUID = 0L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private Wrapper(Equivalence<? super T> param1Equivalence, @ParametricNullness T param1T) {
/* 220 */       this.equivalence = Preconditions.<Equivalence<? super T>>checkNotNull(param1Equivalence);
/* 221 */       this.reference = param1T;
/*     */     }
/*     */ 
/*     */     
/*     */     @ParametricNullness
/*     */     public final T get() {
/* 227 */       return this.reference;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean equals(Object param1Object) {
/* 237 */       if (param1Object == this) {
/* 238 */         return true;
/*     */       }
/* 240 */       if (param1Object instanceof Wrapper) {
/* 241 */         param1Object = param1Object;
/*     */         
/* 243 */         if (this.equivalence.equals(((Wrapper)param1Object).equivalence)) {
/*     */           Equivalence<? super T> equivalence;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 250 */           return (equivalence = this.equivalence).equivalent(this.reference, ((Wrapper)param1Object).reference);
/*     */         } 
/*     */       } 
/* 253 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final int hashCode() {
/* 259 */       return this.equivalence.hash(this.reference);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 268 */       String str1 = String.valueOf(this.equivalence), str2 = String.valueOf(this.reference); return (new StringBuilder(7 + String.valueOf(str1).length() + String.valueOf(str2).length())).append(str1).append(".wrap(").append(str2).append(")").toString();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final <S extends T> Equivalence<Iterable<S>> pairwise() {
/* 289 */     return new PairwiseEquivalence<>(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Predicate<T> equivalentTo(T paramT) {
/* 299 */     return new EquivalentToPredicate<>(this, paramT);
/*     */   }
/*     */   
/*     */   private static final class EquivalentToPredicate<T>
/*     */     implements Predicate<T>, Serializable {
/*     */     private final Equivalence<T> equivalence;
/*     */     private final T target;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     EquivalentToPredicate(Equivalence<T> param1Equivalence, T param1T) {
/* 309 */       this.equivalence = Preconditions.<Equivalence<T>>checkNotNull(param1Equivalence);
/* 310 */       this.target = param1T;
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean apply(T param1T) {
/* 315 */       return this.equivalence.equivalent(param1T, this.target);
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean equals(Object param1Object) {
/* 320 */       if (this == param1Object) {
/* 321 */         return true;
/*     */       }
/* 323 */       if (param1Object instanceof EquivalentToPredicate) {
/* 324 */         param1Object = param1Object;
/* 325 */         return (this.equivalence.equals(((EquivalentToPredicate)param1Object).equivalence) && Objects.equal(this.target, ((EquivalentToPredicate)param1Object).target));
/*     */       } 
/* 327 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public final int hashCode() {
/* 332 */       return Objects.hashCode(new Object[] { this.equivalence, this.target });
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 337 */       String str1 = String.valueOf(this.equivalence), str2 = String.valueOf(this.target); return (new StringBuilder(15 + String.valueOf(str1).length() + String.valueOf(str2).length())).append(str1).append(".equivalentTo(").append(str2).append(")").toString();
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
/*     */ 
/*     */   
/*     */   public static Equivalence<Object> equals() {
/* 354 */     return Equals.INSTANCE;
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
/*     */   public static Equivalence<Object> identity() {
/* 366 */     return Identity.INSTANCE;
/*     */   }
/*     */   
/*     */   static final class Equals
/*     */     extends Equivalence<Object> implements Serializable {
/* 371 */     static final Equals INSTANCE = new Equals();
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     protected final boolean doEquivalent(Object param1Object1, Object param1Object2) {
/* 375 */       return param1Object1.equals(param1Object2);
/*     */     }
/*     */ 
/*     */     
/*     */     protected final int doHash(Object param1Object) {
/* 380 */       return param1Object.hashCode();
/*     */     }
/*     */     
/*     */     private Object readResolve() {
/* 384 */       return INSTANCE;
/*     */     }
/*     */   }
/*     */   
/*     */   static final class Identity
/*     */     extends Equivalence<Object>
/*     */     implements Serializable
/*     */   {
/* 392 */     static final Identity INSTANCE = new Identity();
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     protected final boolean doEquivalent(Object param1Object1, Object param1Object2) {
/* 396 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     protected final int doHash(Object param1Object) {
/* 401 */       return System.identityHashCode(param1Object);
/*     */     }
/*     */     
/*     */     private Object readResolve() {
/* 405 */       return INSTANCE;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\google\common\base\Equivalence.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */