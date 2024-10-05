/*     */ package com.badlogic.gdx.ai.btree.decorator;
/*     */ 
/*     */ import com.badlogic.gdx.ai.btree.LoopDecorator;
/*     */ import com.badlogic.gdx.ai.btree.Task;
/*     */ import com.badlogic.gdx.ai.btree.annotation.TaskAttribute;
/*     */ import com.badlogic.gdx.ai.utils.random.ConstantIntegerDistribution;
/*     */ import com.badlogic.gdx.ai.utils.random.IntegerDistribution;
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
/*     */ public class Repeat<E>
/*     */   extends LoopDecorator<E>
/*     */ {
/*     */   @TaskAttribute
/*     */   public IntegerDistribution times;
/*     */   private int count;
/*     */   
/*     */   public Repeat() {
/*  43 */     this(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Repeat(Task<E> paramTask) {
/*  50 */     this((IntegerDistribution)ConstantIntegerDistribution.NEGATIVE_ONE, paramTask);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Repeat(IntegerDistribution paramIntegerDistribution, Task<E> paramTask) {
/*  60 */     super(paramTask);
/*  61 */     this.times = paramIntegerDistribution;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void start() {
/*  70 */     this.count = this.times.nextInt();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean condition() {
/*  75 */     return (this.loop && this.count != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void childSuccess(Task<E> paramTask) {
/*  80 */     if (this.count > 0) this.count--; 
/*  81 */     if (this.count == 0) {
/*  82 */       super.childSuccess(paramTask);
/*  83 */       this.loop = false; return;
/*     */     } 
/*  85 */     this.loop = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void childFail(Task<E> paramTask) {
/*  90 */     childSuccess(paramTask);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Task<E> copyTo(Task<E> paramTask) {
/*     */     Repeat repeat;
/*  96 */     (repeat = (Repeat)paramTask).times = this.times;
/*     */     
/*  98 */     return super.copyTo(paramTask);
/*     */   }
/*     */ 
/*     */   
/*     */   public void reset() {
/* 103 */     this.count = 0;
/* 104 */     this.times = null;
/* 105 */     super.reset();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\btree\decorator\Repeat.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */