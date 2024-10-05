/*    */ package com.google.common.base;
/*    */ 
/*    */ import java.io.Serializable;
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
/*    */ final class FunctionalEquivalence<F, T>
/*    */   extends Equivalence<F>
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 0L;
/*    */   private final Function<? super F, ? extends T> function;
/*    */   private final Equivalence<T> resultEquivalence;
/*    */   
/*    */   FunctionalEquivalence(Function<? super F, ? extends T> paramFunction, Equivalence<T> paramEquivalence) {
/* 43 */     this.function = Preconditions.<Function<? super F, ? extends T>>checkNotNull(paramFunction);
/* 44 */     this.resultEquivalence = Preconditions.<Equivalence<T>>checkNotNull(paramEquivalence);
/*    */   }
/*    */ 
/*    */   
/*    */   protected final boolean doEquivalent(F paramF1, F paramF2) {
/* 49 */     return this.resultEquivalence.equivalent(this.function.apply(paramF1), this.function.apply(paramF2));
/*    */   }
/*    */ 
/*    */   
/*    */   protected final int doHash(F paramF) {
/* 54 */     return this.resultEquivalence.hash(this.function.apply(paramF));
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean equals(Object paramObject) {
/* 59 */     if (paramObject == this) {
/* 60 */       return true;
/*    */     }
/* 62 */     if (paramObject instanceof FunctionalEquivalence) {
/* 63 */       paramObject = paramObject;
/* 64 */       return (this.function.equals(((FunctionalEquivalence)paramObject).function) && this.resultEquivalence.equals(((FunctionalEquivalence)paramObject).resultEquivalence));
/*    */     } 
/* 66 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public final int hashCode() {
/* 71 */     return Objects.hashCode(new Object[] { this.function, this.resultEquivalence });
/*    */   }
/*    */ 
/*    */   
/*    */   public final String toString() {
/* 76 */     String str1 = String.valueOf(this.resultEquivalence), str2 = String.valueOf(this.function); return (new StringBuilder(13 + String.valueOf(str1).length() + String.valueOf(str2).length())).append(str1).append(".onResultOf(").append(str2).append(")").toString();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\google\common\base\FunctionalEquivalence.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */