/*    */ package com.vladsch.flexmark.util.dependency;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Deprecated
/*    */ public class FlatDependencies<T>
/*    */   extends ResolvedDependencies<FlatDependencyStage<T>>
/*    */ {
/*    */   ArrayList<T> dependencies;
/*    */   
/*    */   public FlatDependencies(List<FlatDependencyStage<T>> paramList) {
/* 15 */     super(paramList);
/* 16 */     ArrayList<T> arrayList = new ArrayList();
/* 17 */     for (FlatDependencyStage<T> flatDependencyStage : paramList) {
/* 18 */       arrayList.addAll(flatDependencyStage.getDependents());
/*    */     }
/*    */     
/* 21 */     this.dependencies = arrayList;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\dependency\FlatDependencies.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */