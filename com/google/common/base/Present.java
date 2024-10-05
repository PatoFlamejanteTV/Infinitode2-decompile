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
/*    */ @ElementTypesAreNonnullByDefault
/*    */ final class Present<T>
/*    */   extends Optional<T>
/*    */ {
/*    */   private final T reference;
/*    */   private static final long serialVersionUID = 0L;
/*    */   
/*    */   Present(T paramT) {
/* 31 */     this.reference = paramT;
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean isPresent() {
/* 36 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public final T get() {
/* 41 */     return this.reference;
/*    */   }
/*    */ 
/*    */   
/*    */   public final T or(T paramT) {
/* 46 */     Preconditions.checkNotNull(paramT, "use Optional.orNull() instead of Optional.or(null)");
/* 47 */     return this.reference;
/*    */   }
/*    */ 
/*    */   
/*    */   public final Optional<T> or(Optional<? extends T> paramOptional) {
/* 52 */     Preconditions.checkNotNull(paramOptional);
/* 53 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public final T or(Supplier<? extends T> paramSupplier) {
/* 58 */     Preconditions.checkNotNull(paramSupplier);
/* 59 */     return this.reference;
/*    */   }
/*    */ 
/*    */   
/*    */   public final T orNull() {
/* 64 */     return this.reference;
/*    */   }
/*    */ 
/*    */   
/*    */   public final Set<T> asSet() {
/* 69 */     return Collections.singleton(this.reference);
/*    */   }
/*    */ 
/*    */   
/*    */   public final <V> Optional<V> transform(Function<? super T, V> paramFunction) {
/* 74 */     return new Present(
/* 75 */         Preconditions.checkNotNull((T)paramFunction
/* 76 */           .apply(this.reference), "the Function passed to Optional.transform() must not return null."));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean equals(Object paramObject) {
/* 82 */     if (paramObject instanceof Present) {
/* 83 */       paramObject = paramObject;
/* 84 */       return this.reference.equals(((Present)paramObject).reference);
/*    */     } 
/* 86 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public final int hashCode() {
/* 91 */     return 1502476572 + this.reference.hashCode();
/*    */   }
/*    */ 
/*    */   
/*    */   public final String toString() {
/* 96 */     String str = String.valueOf(this.reference); return (new StringBuilder(13 + String.valueOf(str).length())).append("Optional.of(").append(str).append(")").toString();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\google\common\base\Present.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */