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
/*    */ public class UntilFail<E>
/*    */   extends LoopDecorator<E>
/*    */ {
/*    */   public UntilFail() {}
/*    */   
/*    */   public UntilFail(Task<E> paramTask) {
/* 41 */     super(paramTask);
/*    */   }
/*    */ 
/*    */   
/*    */   public void childSuccess(Task<E> paramTask) {
/* 46 */     this.loop = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void childFail(Task<E> paramTask) {
/* 51 */     success();
/* 52 */     this.loop = false;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\btree\decorator\UntilFail.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */