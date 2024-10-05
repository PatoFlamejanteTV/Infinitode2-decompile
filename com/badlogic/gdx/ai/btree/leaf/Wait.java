/*    */ package com.badlogic.gdx.ai.btree.leaf;
/*    */ 
/*    */ import com.badlogic.gdx.ai.GdxAI;
/*    */ import com.badlogic.gdx.ai.btree.LeafTask;
/*    */ import com.badlogic.gdx.ai.btree.Task;
/*    */ import com.badlogic.gdx.ai.btree.annotation.TaskAttribute;
/*    */ import com.badlogic.gdx.ai.utils.random.ConstantFloatDistribution;
/*    */ import com.badlogic.gdx.ai.utils.random.FloatDistribution;
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
/*    */ public class Wait<E>
/*    */   extends LeafTask<E>
/*    */ {
/*    */   @TaskAttribute(required = true)
/*    */   public FloatDistribution seconds;
/*    */   private float startTime;
/*    */   private float timeout;
/*    */   
/*    */   public Wait() {
/* 42 */     this((FloatDistribution)ConstantFloatDistribution.ZERO);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Wait(float paramFloat) {
/* 49 */     this((FloatDistribution)new ConstantFloatDistribution(paramFloat));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Wait(FloatDistribution paramFloatDistribution) {
/* 56 */     this.seconds = paramFloatDistribution;
/*    */   }
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
/*    */   public void start() {
/* 69 */     this.timeout = this.seconds.nextFloat();
/* 70 */     this.startTime = GdxAI.getTimepiece().getTime();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Task.Status execute() {
/* 77 */     return (GdxAI.getTimepiece().getTime() - this.startTime < this.timeout) ? Task.Status.RUNNING : Task.Status.SUCCEEDED;
/*    */   }
/*    */ 
/*    */   
/*    */   protected Task<E> copyTo(Task<E> paramTask) {
/* 82 */     ((Wait)paramTask).seconds = this.seconds;
/* 83 */     return paramTask;
/*    */   }
/*    */ 
/*    */   
/*    */   public void reset() {
/* 88 */     this.seconds = (FloatDistribution)ConstantFloatDistribution.ZERO;
/* 89 */     this.startTime = 0.0F;
/* 90 */     this.timeout = 0.0F;
/* 91 */     super.reset();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\btree\leaf\Wait.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */