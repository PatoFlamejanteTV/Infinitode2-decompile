/*    */ package com.vladsch.flexmark.util.collection;
/*    */ 
/*    */ import java.util.function.Function;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CopyOnWriteRef<T>
/*    */ {
/*    */   private T value;
/*    */   private int referenceCount;
/*    */   private final Function<T, T> copyFunction;
/*    */   
/*    */   public CopyOnWriteRef(T paramT, Function<T, T> paramFunction) {
/* 14 */     this.value = paramT;
/* 15 */     this.referenceCount = 0;
/* 16 */     this.copyFunction = paramFunction;
/*    */   }
/*    */   
/*    */   public T getPeek() {
/* 20 */     return this.value;
/*    */   }
/*    */   
/*    */   public T getImmutable() {
/* 24 */     if (this.value != null) this.referenceCount++; 
/* 25 */     return this.value;
/*    */   }
/*    */   
/*    */   public T getMutable() {
/* 29 */     if (this.referenceCount > 0) {
/* 30 */       this.value = this.copyFunction.apply(this.value);
/* 31 */       this.referenceCount = 0;
/*    */     } 
/* 33 */     return this.value;
/*    */   }
/*    */   
/*    */   public void setValue(T paramT) {
/* 37 */     this.referenceCount = 0;
/* 38 */     this.value = this.copyFunction.apply(paramT);
/*    */   }
/*    */   
/*    */   public boolean isMutable() {
/* 42 */     return (this.referenceCount == 0);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\collection\CopyOnWriteRef.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */