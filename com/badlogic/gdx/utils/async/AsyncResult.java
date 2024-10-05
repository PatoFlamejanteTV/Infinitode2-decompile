/*    */ package com.badlogic.gdx.utils.async;
/*    */ 
/*    */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*    */ import java.util.concurrent.ExecutionException;
/*    */ import java.util.concurrent.Future;
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
/*    */ public class AsyncResult<T>
/*    */ {
/*    */   private final Future<T> future;
/*    */   
/*    */   AsyncResult(Future<T> paramFuture) {
/* 30 */     this.future = paramFuture;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isDone() {
/* 35 */     return this.future.isDone();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public T get() {
/*    */     try {
/* 42 */       return this.future.get();
/* 43 */     } catch (InterruptedException interruptedException) {
/* 44 */       return null;
/* 45 */     } catch (ExecutionException executionException) {
/* 46 */       throw new GdxRuntimeException(executionException.getCause());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\async\AsyncResult.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */