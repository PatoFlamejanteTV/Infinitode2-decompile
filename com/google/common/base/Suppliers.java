/*     */ package com.google.common.base;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Objects;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class Suppliers
/*     */ {
/*     */   public static <F, T> Supplier<T> compose(Function<? super F, T> paramFunction, Supplier<F> paramSupplier) {
/*  51 */     return new SupplierComposition<>(paramFunction, paramSupplier);
/*     */   }
/*     */   
/*     */   private static class SupplierComposition<F, T> implements Supplier<T>, Serializable {
/*     */     final Function<? super F, T> function;
/*     */     final Supplier<F> supplier;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     SupplierComposition(Function<? super F, T> param1Function, Supplier<F> param1Supplier) {
/*  60 */       this.function = Preconditions.<Function<? super F, T>>checkNotNull(param1Function);
/*  61 */       this.supplier = Preconditions.<Supplier<F>>checkNotNull(param1Supplier);
/*     */     }
/*     */ 
/*     */     
/*     */     @ParametricNullness
/*     */     public T get() {
/*  67 */       return this.function.apply(this.supplier.get());
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/*  72 */       if (param1Object instanceof SupplierComposition) {
/*  73 */         param1Object = param1Object;
/*  74 */         return (this.function.equals(((SupplierComposition)param1Object).function) && this.supplier.equals(((SupplierComposition)param1Object).supplier));
/*     */       } 
/*  76 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*  81 */       return Objects.hashCode(new Object[] { this.function, this.supplier });
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/*  86 */       String str1 = String.valueOf(this.function), str2 = String.valueOf(this.supplier); return (new StringBuilder(21 + String.valueOf(str1).length() + String.valueOf(str2).length())).append("Suppliers.compose(").append(str1).append(", ").append(str2).append(")").toString();
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
/*     */ 
/*     */   
/*     */   public static <T> Supplier<T> memoize(Supplier<T> paramSupplier) {
/* 109 */     if (paramSupplier instanceof NonSerializableMemoizingSupplier || paramSupplier instanceof MemoizingSupplier)
/*     */     {
/* 111 */       return paramSupplier;
/*     */     }
/* 113 */     if (paramSupplier instanceof Serializable)
/* 114 */       return new MemoizingSupplier<>(paramSupplier); 
/* 115 */     return new NonSerializableMemoizingSupplier<>(paramSupplier);
/*     */   }
/*     */   
/*     */   static class MemoizingSupplier<T>
/*     */     implements Supplier<T>, Serializable
/*     */   {
/*     */     final Supplier<T> delegate;
/*     */     volatile transient boolean initialized;
/*     */     transient T value;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     MemoizingSupplier(Supplier<T> param1Supplier) {
/* 127 */       this.delegate = Preconditions.<Supplier<T>>checkNotNull(param1Supplier);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     @ParametricNullness
/*     */     public T get() {
/* 134 */       if (!this.initialized) {
/* 135 */         synchronized (this) {
/* 136 */           if (!this.initialized) {
/* 137 */             T t = this.delegate.get();
/* 138 */             this.value = t;
/* 139 */             this.initialized = true;
/* 140 */             return t;
/*     */           } 
/*     */         } 
/*     */       }
/*     */       
/* 145 */       return NullnessCasts.uncheckedCastNullableTToT(this.value);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 151 */       String str = String.valueOf(this.value); str = String.valueOf(this.initialized ? (new StringBuilder(25 + String.valueOf(str).length())).append("<supplier that returned ").append(str).append(">").toString() : this.delegate); return (new StringBuilder(19 + String.valueOf(str).length())).append("Suppliers.memoize(").append(str).append(")").toString();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static class NonSerializableMemoizingSupplier<T>
/*     */     implements Supplier<T>
/*     */   {
/*     */     volatile Supplier<T> delegate;
/*     */     
/*     */     volatile boolean initialized;
/*     */     
/*     */     T value;
/*     */ 
/*     */     
/*     */     NonSerializableMemoizingSupplier(Supplier<T> param1Supplier) {
/* 167 */       this.delegate = Preconditions.<Supplier<T>>checkNotNull(param1Supplier);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     @ParametricNullness
/*     */     public T get() {
/* 174 */       if (!this.initialized) {
/* 175 */         synchronized (this) {
/* 176 */           if (!this.initialized) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 183 */             T t = (T)((Supplier<Object>)Objects.requireNonNull(this.delegate)).get();
/* 184 */             this.value = t;
/* 185 */             this.initialized = true;
/*     */             
/* 187 */             this.delegate = null;
/* 188 */             return t;
/*     */           } 
/*     */         } 
/*     */       }
/*     */       
/* 193 */       return NullnessCasts.uncheckedCastNullableTToT(this.value);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 200 */       String str = String.valueOf(this.value); Supplier<T> supplier; str = String.valueOf(((supplier = this.delegate) == null) ? (new StringBuilder(25 + String.valueOf(str).length())).append("<supplier that returned ").append(str).append(">").toString() : str); return (new StringBuilder(19 + String.valueOf(str).length())).append("Suppliers.memoize(").append(str).append(")").toString();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> Supplier<T> memoizeWithExpiration(Supplier<T> paramSupplier, long paramLong, TimeUnit paramTimeUnit) {
/* 229 */     return new ExpiringMemoizingSupplier<>(paramSupplier, paramLong, paramTimeUnit);
/*     */   }
/*     */ 
/*     */   
/*     */   static class ExpiringMemoizingSupplier<T>
/*     */     implements Supplier<T>, Serializable
/*     */   {
/*     */     final Supplier<T> delegate;
/*     */     final long durationNanos;
/*     */     volatile transient T value;
/*     */     volatile transient long expirationNanos;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     ExpiringMemoizingSupplier(Supplier<T> param1Supplier, long param1Long, TimeUnit param1TimeUnit) {
/* 243 */       this.delegate = Preconditions.<Supplier<T>>checkNotNull(param1Supplier);
/* 244 */       this.durationNanos = param1TimeUnit.toNanos(param1Long);
/* 245 */       Preconditions.checkArgument((param1Long > 0L), "duration (%s %s) must be > 0", param1Long, param1TimeUnit);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @ParametricNullness
/*     */     public T get() {
/* 257 */       long l1 = this.expirationNanos;
/* 258 */       long l2 = Platform.systemNanoTime();
/* 259 */       if (l1 == 0L || l2 - l1 >= 0L) {
/* 260 */         synchronized (this) {
/* 261 */           if (l1 == this.expirationNanos) {
/* 262 */             T t = this.delegate.get();
/* 263 */             this.value = t;
/* 264 */             l1 = l2 + this.durationNanos;
/*     */ 
/*     */             
/* 267 */             this.expirationNanos = (l1 == 0L) ? 1L : l1;
/* 268 */             return t;
/*     */           } 
/*     */         } 
/*     */       }
/*     */       
/* 273 */       return NullnessCasts.uncheckedCastNullableTToT(this.value);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 280 */       String str = String.valueOf(this.delegate); long l = this.durationNanos; return (new StringBuilder(62 + String.valueOf(str).length())).append("Suppliers.memoizeWithExpiration(").append(str).append(", ").append(l).append(", NANOS)").toString();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> Supplier<T> ofInstance(@ParametricNullness T paramT) {
/* 289 */     return new SupplierOfInstance<>(paramT);
/*     */   }
/*     */   
/*     */   private static class SupplierOfInstance<T> implements Supplier<T>, Serializable { @ParametricNullness
/*     */     final T instance;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     SupplierOfInstance(@ParametricNullness T param1T) {
/* 297 */       this.instance = param1T;
/*     */     }
/*     */ 
/*     */     
/*     */     @ParametricNullness
/*     */     public T get() {
/* 303 */       return this.instance;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 308 */       if (param1Object instanceof SupplierOfInstance) {
/* 309 */         param1Object = param1Object;
/* 310 */         return Objects.equal(this.instance, ((SupplierOfInstance)param1Object).instance);
/*     */       } 
/* 312 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 317 */       return Objects.hashCode(new Object[] { this.instance });
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 322 */       String str = String.valueOf(this.instance); return (new StringBuilder(22 + String.valueOf(str).length())).append("Suppliers.ofInstance(").append(str).append(")").toString();
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
/*     */   public static <T> Supplier<T> synchronizedSupplier(Supplier<T> paramSupplier) {
/* 334 */     return new ThreadSafeSupplier<>(paramSupplier);
/*     */   }
/*     */   
/*     */   private static class ThreadSafeSupplier<T> implements Supplier<T>, Serializable {
/*     */     final Supplier<T> delegate;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     ThreadSafeSupplier(Supplier<T> param1Supplier) {
/* 342 */       this.delegate = Preconditions.<Supplier<T>>checkNotNull(param1Supplier);
/*     */     }
/*     */ 
/*     */     
/*     */     @ParametricNullness
/*     */     public T get() {
/* 348 */       synchronized (this.delegate) {
/* 349 */         return this.delegate.get();
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 355 */       String str = String.valueOf(this.delegate); return (new StringBuilder(32 + String.valueOf(str).length())).append("Suppliers.synchronizedSupplier(").append(str).append(")").toString();
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
/*     */   public static <T> Function<Supplier<T>, T> supplierFunction() {
/*     */     SupplierFunctionImpl supplierFunctionImpl;
/* 372 */     return supplierFunctionImpl = SupplierFunctionImpl.INSTANCE;
/*     */   }
/*     */   
/*     */   private static interface SupplierFunction<T> extends Function<Supplier<T>, T> {}
/*     */   
/*     */   private enum SupplierFunctionImpl implements SupplierFunction<Object> {
/* 378 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Object apply(Supplier<Object> param1Supplier) {
/* 384 */       return param1Supplier.get();
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 389 */       return "Suppliers.supplierFunction()";
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\google\common\base\Suppliers.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */