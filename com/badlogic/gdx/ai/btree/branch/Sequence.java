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
/*    */ public class Sequence<E>
/*    */   extends SingleRunningChildBranch<E>
/*    */ {
/*    */   public Sequence() {}
/*    */   
/*    */   public Sequence(Array<Task<E>> paramArray) {
/* 40 */     super(paramArray);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Sequence(Task<E>... paramVarArgs) {
/* 47 */     super(new Array((Object[])paramVarArgs));
/*    */   }
/*    */ 
/*    */   
/*    */   public void childSuccess(Task<E> paramTask) {
/* 52 */     super.childSuccess(paramTask);
/* 53 */     if (++this.currentChildIndex < this.children.size) {
/* 54 */       run(); return;
/*    */     } 
/* 56 */     success();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void childFail(Task<E> paramTask) {
/* 62 */     super.childFail(paramTask);
/* 63 */     fail();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\btree\branch\Sequence.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */