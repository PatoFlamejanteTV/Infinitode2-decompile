/*     */ package com.badlogic.gdx.ai.btree.decorator;
/*     */ 
/*     */ import com.badlogic.gdx.ai.btree.Decorator;
/*     */ import com.badlogic.gdx.ai.btree.Task;
/*     */ import com.badlogic.gdx.ai.btree.annotation.TaskAttribute;
/*     */ import com.badlogic.gdx.ai.btree.annotation.TaskConstraint;
/*     */ import com.badlogic.gdx.ai.utils.random.ConstantFloatDistribution;
/*     */ import com.badlogic.gdx.ai.utils.random.FloatDistribution;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @TaskConstraint(minChildren = 0, maxChildren = 1)
/*     */ public class Random<E>
/*     */   extends Decorator<E>
/*     */ {
/*     */   @TaskAttribute
/*     */   public FloatDistribution success;
/*     */   private float p;
/*     */   
/*     */   public Random() {
/*  50 */     this((FloatDistribution)ConstantFloatDistribution.ZERO_POINT_FIVE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Random(Task<E> paramTask) {
/*  57 */     this((FloatDistribution)ConstantFloatDistribution.ZERO_POINT_FIVE, paramTask);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Random(FloatDistribution paramFloatDistribution) {
/*  65 */     this.success = paramFloatDistribution;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Random(FloatDistribution paramFloatDistribution, Task<E> paramTask) {
/*  73 */     super(paramTask);
/*  74 */     this.success = paramFloatDistribution;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void start() {
/*  82 */     this.p = this.success.nextFloat();
/*     */   }
/*     */ 
/*     */   
/*     */   public void run() {
/*  87 */     if (this.child != null) {
/*  88 */       super.run(); return;
/*     */     } 
/*  90 */     decide();
/*     */   }
/*     */ 
/*     */   
/*     */   public void childFail(Task<E> paramTask) {
/*  95 */     decide();
/*     */   }
/*     */ 
/*     */   
/*     */   public void childSuccess(Task<E> paramTask) {
/* 100 */     decide();
/*     */   }
/*     */   
/*     */   private void decide() {
/* 104 */     if (MathUtils.random() <= this.p) {
/* 105 */       success(); return;
/*     */     } 
/* 107 */     fail();
/*     */   }
/*     */ 
/*     */   
/*     */   protected Task<E> copyTo(Task<E> paramTask) {
/*     */     Random random;
/* 113 */     (random = (Random)paramTask).success = this.success;
/*     */     
/* 115 */     return super.copyTo(paramTask);
/*     */   }
/*     */ 
/*     */   
/*     */   public void reset() {
/* 120 */     this.p = 0.0F;
/* 121 */     this.success = (FloatDistribution)ConstantFloatDistribution.ZERO_POINT_FIVE;
/* 122 */     super.reset();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\btree\decorator\Random.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */