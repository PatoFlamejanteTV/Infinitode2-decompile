/*     */ package com.google.common.base;
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class Functions
/*     */ {
/*     */   public static Function<Object, String> toStringFunction() {
/*  63 */     return ToStringFunction.INSTANCE;
/*     */   }
/*     */   
/*     */   private enum ToStringFunction
/*     */     implements Function<Object, String> {
/*  68 */     INSTANCE;
/*     */ 
/*     */     
/*     */     public final String apply(Object param1Object) {
/*  72 */       Preconditions.checkNotNull(param1Object);
/*  73 */       return param1Object.toString();
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/*  78 */       return "Functions.toStringFunction()";
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> Function<E, E> identity() {
/*  86 */     return IdentityFunction.INSTANCE;
/*     */   }
/*     */   
/*     */   private enum IdentityFunction
/*     */     implements Function<Object, Object> {
/*  91 */     INSTANCE;
/*     */ 
/*     */ 
/*     */     
/*     */     public final Object apply(Object param1Object) {
/*  96 */       return param1Object;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 101 */       return "Functions.identity()";
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
/*     */   public static <K, V> Function<K, V> forMap(Map<K, V> paramMap) {
/* 120 */     return new FunctionForMapNoDefault<>(paramMap);
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
/*     */   public static <K, V> Function<K, V> forMap(Map<K, ? extends V> paramMap, @ParametricNullness V paramV) {
/* 138 */     return new ForMapWithDefault<>(paramMap, paramV);
/*     */   }
/*     */   
/*     */   private static class FunctionForMapNoDefault<K, V>
/*     */     implements Function<K, V>, Serializable {
/*     */     final Map<K, V> map;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     FunctionForMapNoDefault(Map<K, V> param1Map) {
/* 147 */       this.map = Preconditions.<Map<K, V>>checkNotNull(param1Map);
/*     */     }
/*     */ 
/*     */     
/*     */     @ParametricNullness
/*     */     public V apply(@ParametricNullness K param1K) {
/*     */       V v;
/* 154 */       Preconditions.checkArgument(((v = this.map.get(param1K)) != null || this.map.containsKey(param1K)), "Key '%s' not present in map", param1K);
/*     */       
/* 156 */       return NullnessCasts.uncheckedCastNullableTToT(v);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 161 */       if (param1Object instanceof FunctionForMapNoDefault) {
/* 162 */         param1Object = param1Object;
/* 163 */         return this.map.equals(((FunctionForMapNoDefault)param1Object).map);
/*     */       } 
/* 165 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 170 */       return this.map.hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 175 */       String str = String.valueOf(this.map); return (new StringBuilder(18 + String.valueOf(str).length())).append("Functions.forMap(").append(str).append(")").toString();
/*     */     }
/*     */   }
/*     */   
/*     */   private static class ForMapWithDefault<K, V>
/*     */     implements Function<K, V>, Serializable {
/*     */     final Map<K, ? extends V> map;
/*     */     @ParametricNullness
/*     */     final V defaultValue;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     ForMapWithDefault(Map<K, ? extends V> param1Map, @ParametricNullness V param1V) {
/* 187 */       this.map = Preconditions.<Map<K, ? extends V>>checkNotNull(param1Map);
/* 188 */       this.defaultValue = param1V;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     @ParametricNullness
/*     */     public V apply(@ParametricNullness K param1K) {
/*     */       V v;
/* 196 */       if ((v = this.map.get(param1K)) != null || this.map.containsKey(param1K))
/* 197 */         return NullnessCasts.uncheckedCastNullableTToT(v); 
/* 198 */       return this.defaultValue;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 203 */       if (param1Object instanceof ForMapWithDefault) {
/* 204 */         param1Object = param1Object;
/* 205 */         return (this.map.equals(((ForMapWithDefault)param1Object).map) && Objects.equal(this.defaultValue, ((ForMapWithDefault)param1Object).defaultValue));
/*     */       } 
/* 207 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 212 */       return Objects.hashCode(new Object[] { this.map, this.defaultValue });
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 218 */       String str1 = String.valueOf(this.map), str2 = String.valueOf(this.defaultValue); return (new StringBuilder(33 + String.valueOf(str1).length() + String.valueOf(str2).length())).append("Functions.forMap(").append(str1).append(", defaultValue=").append(str2).append(")").toString();
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
/*     */   public static <A, B, C> Function<A, C> compose(Function<B, C> paramFunction, Function<A, ? extends B> paramFunction1) {
/* 238 */     return new FunctionComposition<>(paramFunction, paramFunction1);
/*     */   }
/*     */   
/*     */   private static class FunctionComposition<A, B, C>
/*     */     implements Function<A, C>, Serializable {
/*     */     private final Function<B, C> g;
/*     */     private final Function<A, ? extends B> f;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     public FunctionComposition(Function<B, C> param1Function, Function<A, ? extends B> param1Function1) {
/* 248 */       this.g = Preconditions.<Function<B, C>>checkNotNull(param1Function);
/* 249 */       this.f = Preconditions.<Function<A, ? extends B>>checkNotNull(param1Function1);
/*     */     }
/*     */ 
/*     */     
/*     */     @ParametricNullness
/*     */     public C apply(@ParametricNullness A param1A) {
/* 255 */       return this.g.apply(this.f.apply(param1A));
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 260 */       if (param1Object instanceof FunctionComposition) {
/* 261 */         param1Object = param1Object;
/* 262 */         return (this.f.equals(((FunctionComposition)param1Object).f) && this.g.equals(((FunctionComposition)param1Object).g));
/*     */       } 
/* 264 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 269 */       return this.f.hashCode() ^ this.g.hashCode();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 275 */       String str1 = String.valueOf(this.g), str2 = String.valueOf(this.f); return (new StringBuilder(2 + String.valueOf(str1).length() + String.valueOf(str2).length())).append(str1).append("(").append(str2).append(")").toString();
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
/*     */   public static <T> Function<T, Boolean> forPredicate(Predicate<T> paramPredicate) {
/* 291 */     return new PredicateFunction<>(paramPredicate);
/*     */   }
/*     */   
/*     */   private static class PredicateFunction<T>
/*     */     implements Function<T, Boolean>, Serializable {
/*     */     private final Predicate<T> predicate;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     private PredicateFunction(Predicate<T> param1Predicate) {
/* 300 */       this.predicate = Preconditions.<Predicate<T>>checkNotNull(param1Predicate);
/*     */     }
/*     */ 
/*     */     
/*     */     public Boolean apply(@ParametricNullness T param1T) {
/* 305 */       return Boolean.valueOf(this.predicate.apply(param1T));
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 310 */       if (param1Object instanceof PredicateFunction) {
/* 311 */         param1Object = param1Object;
/* 312 */         return this.predicate.equals(((PredicateFunction)param1Object).predicate);
/*     */       } 
/* 314 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 319 */       return this.predicate.hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 324 */       String str = String.valueOf(this.predicate); return (new StringBuilder(24 + String.valueOf(str).length())).append("Functions.forPredicate(").append(str).append(")").toString();
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
/*     */   public static <E> Function<Object, E> constant(@ParametricNullness E paramE) {
/* 340 */     return new ConstantFunction<>(paramE);
/*     */   }
/*     */   
/*     */   private static class ConstantFunction<E> implements Function<Object, E>, Serializable { @ParametricNullness
/*     */     private final E value;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     public ConstantFunction(@ParametricNullness E param1E) {
/* 348 */       this.value = param1E;
/*     */     }
/*     */ 
/*     */     
/*     */     @ParametricNullness
/*     */     public E apply(Object param1Object) {
/* 354 */       return this.value;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 359 */       if (param1Object instanceof ConstantFunction) {
/* 360 */         param1Object = param1Object;
/* 361 */         return Objects.equal(this.value, ((ConstantFunction)param1Object).value);
/*     */       } 
/* 363 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 368 */       return (this.value == null) ? 0 : this.value.hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 373 */       String str = String.valueOf(this.value); return (new StringBuilder(20 + String.valueOf(str).length())).append("Functions.constant(").append(str).append(")").toString();
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <F, T> Function<F, T> forSupplier(Supplier<T> paramSupplier) {
/* 388 */     return new SupplierFunction<>(paramSupplier);
/*     */   }
/*     */   
/*     */   private static class SupplierFunction<F, T>
/*     */     implements Function<F, T>, Serializable
/*     */   {
/*     */     private final Supplier<T> supplier;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     private SupplierFunction(Supplier<T> param1Supplier) {
/* 398 */       this.supplier = Preconditions.<Supplier<T>>checkNotNull(param1Supplier);
/*     */     }
/*     */ 
/*     */     
/*     */     @ParametricNullness
/*     */     public T apply(@ParametricNullness F param1F) {
/* 404 */       return this.supplier.get();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 409 */       if (param1Object instanceof SupplierFunction) {
/* 410 */         param1Object = param1Object;
/* 411 */         return this.supplier.equals(((SupplierFunction)param1Object).supplier);
/*     */       } 
/* 413 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 418 */       return this.supplier.hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 423 */       String str = String.valueOf(this.supplier); return (new StringBuilder(23 + String.valueOf(str).length())).append("Functions.forSupplier(").append(str).append(")").toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\google\common\base\Functions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */