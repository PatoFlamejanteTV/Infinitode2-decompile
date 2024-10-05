/*    */ package com.badlogic.gdx.ai.btree.branch;
/*    */ 
/*    */ import com.badlogic.gdx.ai.btree.SingleRunningChildBranch;
/*    */ import com.badlogic.gdx.ai.btree.Task;
/*    */ import com.badlogic.gdx.utils.Array;
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
/*    */ public class Selector<E>
/*    */   extends SingleRunningChildBranch<E>
/*    */ {
/*    */   public Selector() {}
/*    */   
/*    */   public Selector(Task<E>... paramVarArgs) {
/* 40 */     super(new Array((Object[])paramVarArgs));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Selector(Array<Task<E>> paramArray) {
/* 47 */     super(paramArray);
/*    */   }
/*    */ 
/*    */   
/*    */   public void childFail(Task<E> paramTask) {
/* 52 */     super.childFail(paramTask);
/* 53 */     if (++this.currentChildIndex < this.children.size) {
/* 54 */       run(); return;
/*    */     } 
/* 56 */     fail();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void childSuccess(Task<E> paramTask) {
/* 62 */     super.childSuccess(paramTask);
/* 63 */     success();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\btree\branch\Selector.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */