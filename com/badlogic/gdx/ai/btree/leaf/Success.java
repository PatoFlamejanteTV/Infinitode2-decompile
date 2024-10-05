/*    */ package com.badlogic.gdx.ai.btree.leaf;
/*    */ 
/*    */ import com.badlogic.gdx.ai.btree.LeafTask;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Success<E>
/*    */   extends LeafTask<E>
/*    */ {
/*    */   public Task.Status execute() {
/* 37 */     return Task.Status.SUCCEEDED;
/*    */   }
/*    */ 
/*    */   
/*    */   protected Task<E> copyTo(Task<E> paramTask) {
/* 42 */     return paramTask;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\btree\leaf\Success.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */