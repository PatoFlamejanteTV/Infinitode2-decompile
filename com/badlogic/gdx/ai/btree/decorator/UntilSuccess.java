/*    */ package com.badlogic.gdx.ai.btree.decorator;
/*    */ 
/*    */ import com.badlogic.gdx.ai.btree.LoopDecorator;
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
/*    */ 
/*    */ 
/*    */ public class UntilSuccess<E>
/*    */   extends LoopDecorator<E>
/*    */ {
/*    */   public UntilSuccess() {}
/*    */   
/*    */   public UntilSuccess(Task<E> paramTask) {
/* 41 */     super(paramTask);
/*    */   }
/*    */ 
/*    */   
/*    */   public void childSuccess(Task<E> paramTask) {
/* 46 */     success();
/* 47 */     this.loop = false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void childFail(Task<E> paramTask) {
/* 52 */     this.loop = true;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\btree\decorator\UntilSuccess.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */