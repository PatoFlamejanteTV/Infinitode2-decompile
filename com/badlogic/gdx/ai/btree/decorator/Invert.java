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
/*    */ public class Invert<E>
/*    */   extends Decorator<E>
/*    */ {
/*    */   public Invert() {}
/*    */   
/*    */   public Invert(Task<E> paramTask) {
/* 37 */     super(paramTask);
/*    */   }
/*    */ 
/*    */   
/*    */   public void childSuccess(Task<E> paramTask) {
/* 42 */     super.childFail(paramTask);
/*    */   }
/*    */ 
/*    */   
/*    */   public void childFail(Task<E> paramTask) {
/* 47 */     super.childSuccess(paramTask);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\btree\decorator\Invert.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */