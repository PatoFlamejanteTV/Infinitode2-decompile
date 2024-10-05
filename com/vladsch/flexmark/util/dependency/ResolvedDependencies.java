/*    */ package com.vladsch.flexmark.util.dependency;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Deprecated
/*    */ public class ResolvedDependencies<T>
/*    */ {
/*    */   private final List<T> dependentStages;
/*    */   
/*    */   public ResolvedDependencies(List<T> paramList) {
/* 14 */     this.dependentStages = paramList;
/*    */   }
/*    */   
/*    */   public List<T> getDependentStages() {
/* 18 */     return this.dependentStages;
/*    */   }
/*    */   
/*    */   public boolean isEmpty() {
/* 22 */     return getDependentStages().isEmpty();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\dependency\ResolvedDependencies.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */