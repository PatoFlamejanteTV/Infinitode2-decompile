/*    */ package com.vladsch.flexmark.util.dependency;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Deprecated
/*    */ public class FlatDependencyHandler<T extends Dependent>
/*    */   extends DependencyHandler<T, FlatDependencyStage<T>, FlatDependencies<T>>
/*    */ {
/*    */   public List<T> resolvedDependencies(List<T> paramList) {
/*    */     FlatDependencies<T> flatDependencies;
/* 15 */     return (flatDependencies = resolveDependencies(paramList)).dependencies;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected FlatDependencyStage<T> createStage(List<T> paramList) {
/* 21 */     return new FlatDependencyStage<>(paramList);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected Class<? extends T> getDependentClass(T paramT) {
/* 28 */     return (Class)paramT.getClass();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected FlatDependencies<T> createResolvedDependencies(List<FlatDependencyStage<T>> paramList) {
/* 34 */     return new FlatDependencies<>(paramList);
/*    */   }
/*    */   
/*    */   public static <T extends Dependent> List<T> computeDependencies(List<T> paramList) {
/*    */     FlatDependencyHandler<Dependent> flatDependencyHandler;
/* 39 */     return (List)(flatDependencyHandler = new FlatDependencyHandler<>()).resolvedDependencies(paramList);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\dependency\FlatDependencyHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */