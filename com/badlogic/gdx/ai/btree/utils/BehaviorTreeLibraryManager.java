/*    */ package com.badlogic.gdx.ai.btree.utils;
/*    */ 
/*    */ import com.badlogic.gdx.ai.btree.BehaviorTree;
/*    */ import com.badlogic.gdx.ai.btree.Task;
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
/*    */ public final class BehaviorTreeLibraryManager
/*    */ {
/* 31 */   private static BehaviorTreeLibraryManager instance = new BehaviorTreeLibraryManager();
/*    */   
/*    */   protected BehaviorTreeLibrary library;
/*    */   
/*    */   private BehaviorTreeLibraryManager() {
/* 36 */     setLibrary(new BehaviorTreeLibrary());
/*    */   }
/*    */ 
/*    */   
/*    */   public static BehaviorTreeLibraryManager getInstance() {
/* 41 */     return instance;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final BehaviorTreeLibrary getLibrary() {
/* 47 */     return this.library;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final void setLibrary(BehaviorTreeLibrary paramBehaviorTreeLibrary) {
/* 53 */     this.library = paramBehaviorTreeLibrary;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final <T> Task<T> createRootTask(String paramString) {
/* 62 */     return this.library.createRootTask(paramString);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final <T> BehaviorTree<T> createBehaviorTree(String paramString) {
/* 71 */     return this.library.createBehaviorTree(paramString);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final <T> BehaviorTree<T> createBehaviorTree(String paramString, T paramT) {
/* 81 */     return this.library.createBehaviorTree(paramString, paramT);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void disposeBehaviorTree(String paramString, BehaviorTree<?> paramBehaviorTree) {
/* 90 */     this.library.disposeBehaviorTree(paramString, paramBehaviorTree);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\btre\\utils\BehaviorTreeLibraryManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */