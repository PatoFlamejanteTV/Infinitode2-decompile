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
/*    */ public class RandomSelector<E>
/*    */   extends Selector<E>
/*    */ {
/*    */   public RandomSelector() {}
/*    */   
/*    */   public RandomSelector(Task<E>... paramVarArgs) {
/* 38 */     super(new Array((Object[])paramVarArgs));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public RandomSelector(Array<Task<E>> paramArray) {
/* 45 */     super(paramArray);
/*    */   }
/*    */ 
/*    */   
/*    */   public void start() {
/* 50 */     super.start();
/* 51 */     if (this.randomChildren == null) this.randomChildren = createRandomChildren(); 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\btree\branch\RandomSelector.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */