/*    */ package com.vladsch.flexmark.util.dependency;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Deprecated
/*    */ public class FlatDependencyStage<T>
/*    */ {
/*    */   private final List<T> dependents;
/*    */   
/*    */   public FlatDependencyStage(List<T> paramList) {
/* 15 */     this.dependents = paramList;
/*    */   }
/*    */   
/*    */   public List<T> getDependents() {
/* 19 */     return this.dependents;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\dependency\FlatDependencyStage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */