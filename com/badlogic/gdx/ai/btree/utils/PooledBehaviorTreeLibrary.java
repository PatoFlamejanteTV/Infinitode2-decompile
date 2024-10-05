/*    */ package com.badlogic.gdx.ai.btree.utils;
/*    */ 
/*    */ import com.badlogic.gdx.ai.btree.BehaviorTree;
/*    */ import com.badlogic.gdx.utils.ObjectMap;
/*    */ import com.badlogic.gdx.utils.Pool;
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
/*    */ public class PooledBehaviorTreeLibrary
/*    */   extends BehaviorTreeLibrary
/*    */ {
/* 19 */   protected ObjectMap<String, Pool<BehaviorTree>> pools = new ObjectMap();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected Pool<BehaviorTree> getPool(final String treeReference) {
/*    */     Pool<BehaviorTree> pool;
/* 28 */     if ((pool = (Pool)this.pools.get(treeReference)) == null) {
/* 29 */       pool = new Pool<BehaviorTree>()
/*    */         {
/*    */           protected BehaviorTree newObject() {
/* 32 */             return PooledBehaviorTreeLibrary.this.newBehaviorTree(treeReference);
/*    */           }
/*    */         };
/* 35 */       this.pools.put(treeReference, pool);
/*    */     } 
/* 37 */     return pool;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected <T> BehaviorTree<T> newBehaviorTree(String paramString) {
/* 46 */     return super.createBehaviorTree(paramString, null);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public <T> BehaviorTree<T> createBehaviorTree(String paramString, T paramT) {
/*    */     BehaviorTree<T> behaviorTree;
/*    */     Pool<BehaviorTree> pool;
/* 54 */     (behaviorTree = (BehaviorTree)(pool = getPool(paramString)).obtain()).setObject(paramT);
/* 55 */     return behaviorTree;
/*    */   }
/*    */ 
/*    */   
/*    */   public void disposeBehaviorTree(String paramString, BehaviorTree<?> paramBehaviorTree) {
/*    */     Pool<BehaviorTree> pool;
/* 61 */     (pool = getPool(paramString)).free(paramBehaviorTree);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void clear(String paramString) {
/*    */     Pool pool;
/* 70 */     if ((pool = (Pool)this.pools.get(paramString)) != null) {
/* 71 */       pool.clear();
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void clear() {
/* 79 */     for (ObjectMap.Entries<ObjectMap.Entry> entries = this.pools.entries().iterator(); entries.hasNext();) {
/* 80 */       ((Pool)(entry = entries.next()).value).clear();
/*    */     }
/* 82 */     this.pools.clear();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\btre\\utils\PooledBehaviorTreeLibrary.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */