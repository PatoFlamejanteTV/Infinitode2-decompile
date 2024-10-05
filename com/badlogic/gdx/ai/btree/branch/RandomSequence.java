/*    */ package com.badlogic.gdx.ai.btree.branch;
/*    */ 
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
/*    */ public class RandomSequence<E>
/*    */   extends Sequence<E>
/*    */ {
/*    */   public RandomSequence() {}
/*    */   
/*    */   public RandomSequence(Array<Task<E>> paramArray) {
/* 38 */     super(paramArray);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public RandomSequence(Task<E>... paramVarArgs) {
/* 45 */     super(new Array((Object[])paramVarArgs));
/*    */   }
/*    */ 
/*    */   
/*    */   public void start() {
/* 50 */     super.start();
/* 51 */     if (this.randomChildren == null) this.randomChildren = createRandomChildren(); 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\btree\branch\RandomSequence.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */