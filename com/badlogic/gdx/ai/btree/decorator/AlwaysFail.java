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
/*    */ public class AlwaysFail<E>
/*    */   extends Decorator<E>
/*    */ {
/*    */   public AlwaysFail() {}
/*    */   
/*    */   public AlwaysFail(Task<E> paramTask) {
/* 37 */     super(paramTask);
/*    */   }
/*    */ 
/*    */   
/*    */   public void childSuccess(Task<E> paramTask) {
/* 42 */     childFail(paramTask);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\btree\decorator\AlwaysFail.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */