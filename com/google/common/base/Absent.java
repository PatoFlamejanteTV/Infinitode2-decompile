/*    */ package com.google.common.base;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @ElementTypesAreNonnullByDefault
/*    */ final class Absent<T>
/*    */   extends Optional<T>
/*    */ {
/* 28 */   static final Absent<Object> INSTANCE = new Absent();
/*    */   private static final long serialVersionUID = 0L;
/*    */   
/*    */   static <T> Optional<T> withType() {
/* 32 */     return INSTANCE;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean isPresent() {
/* 39 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public final T get() {
/* 44 */     throw new IllegalStateException("Optional.get() cannot be called on an absent value");
/*    */   }
/*    */ 
/*    */   
/*    */   public final T or(T paramT) {
/* 49 */     return Preconditions.checkNotNull(paramT, "use Optional.orNull() instead of Optional.or(null)");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final Optional<T> or(Optional<? extends T> paramOptional) {
/* 55 */     return (Optional<T>)Preconditions.<Optional<? extends T>>checkNotNull(paramOptional);
/*    */   }
/*    */ 
/*    */   
/*    */   public final T or(Supplier<? extends T> paramSupplier) {
/* 60 */     return Preconditions.checkNotNull(paramSupplier
/* 61 */         .get(), "use Optional.orNull() instead of a Supplier that returns null");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final T orNull() {
/* 67 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public final Set<T> asSet() {
/* 72 */     return Collections.emptySet();
/*    */   }
/*    */ 
/*    */   
/*    */   public final <V> Optional<V> transform(Function<? super T, V> paramFunction) {
/* 77 */     Preconditions.checkNotNull(paramFunction);
/* 78 */     return Optional.absent();
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean equals(Object paramObject) {
/* 83 */     return (paramObject == this);
/*    */   }
/*    */ 
/*    */   
/*    */   public final int hashCode() {
/* 88 */     return 2040732332;
/*    */   }
/*    */ 
/*    */   
/*    */   public final String toString() {
/* 93 */     return "Optional.absent()";
/*    */   }
/*    */   
/*    */   private Object readResolve() {
/* 97 */     return INSTANCE;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\google\common\base\Absent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */