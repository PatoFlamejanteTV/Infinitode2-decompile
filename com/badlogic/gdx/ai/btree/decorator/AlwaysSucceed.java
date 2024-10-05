/*    */ package com.badlogic.gdx.ai.btree.decorator;
/*    */ 
/*    */ import com.badlogic.gdx.ai.btree.Decorator;
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
/*    */ public class AlwaysSucceed<E>
/*    */   extends Decorator<E>
/*    */ {
/*    */   public AlwaysSucceed() {}
/*    */   
/*    */   public AlwaysSucceed(Task<E> paramTask) {
/* 37 */     super(paramTask);
/*    */   }
/*    */ 
/*    */   
/*    */   public void childFail(Task<E> paramTask) {
/* 42 */     childSuccess(paramTask);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\btree\decorator\AlwaysSucceed.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */