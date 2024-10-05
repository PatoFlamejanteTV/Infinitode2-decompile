/*    */ package com.badlogic.gdx.ai.utils;
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
/*    */ public class SimpleNonBlockingSemaphore
/*    */   implements NonBlockingSemaphore
/*    */ {
/*    */   String name;
/*    */   int maxResources;
/*    */   int acquiredResources;
/*    */   
/*    */   public SimpleNonBlockingSemaphore(String paramString, int paramInt) {
/* 32 */     this.name = paramString;
/* 33 */     this.maxResources = paramInt;
/* 34 */     this.acquiredResources = 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean acquire() {
/* 39 */     return acquire(1);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean acquire(int paramInt) {
/* 44 */     if (this.acquiredResources + paramInt <= this.maxResources) {
/* 45 */       this.acquiredResources += paramInt;
/*    */       
/* 47 */       return true;
/*    */     } 
/*    */     
/* 50 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean release() {
/* 55 */     return release(1);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean release(int paramInt) {
/* 60 */     if (this.acquiredResources - paramInt >= 0) {
/* 61 */       this.acquiredResources -= paramInt;
/*    */       
/* 63 */       return true;
/*    */     } 
/*    */     
/* 66 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static class Factory
/*    */     implements NonBlockingSemaphore.Factory
/*    */   {
/*    */     public NonBlockingSemaphore createSemaphore(String param1String, int param1Int) {
/* 79 */       return new SimpleNonBlockingSemaphore(param1String, param1Int);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\a\\utils\SimpleNonBlockingSemaphore.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */