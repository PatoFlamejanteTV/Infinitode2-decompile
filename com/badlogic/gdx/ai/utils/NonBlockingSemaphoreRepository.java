/*    */ package com.badlogic.gdx.ai.utils;
/*    */ 
/*    */ import com.badlogic.gdx.utils.ObjectMap;
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
/*    */ public class NonBlockingSemaphoreRepository
/*    */ {
/* 25 */   private static final ObjectMap<String, NonBlockingSemaphore> REPO = new ObjectMap();
/*    */   
/* 27 */   private static NonBlockingSemaphore.Factory FACTORY = new SimpleNonBlockingSemaphore.Factory();
/*    */   
/*    */   public static void setFactory(NonBlockingSemaphore.Factory paramFactory) {
/* 30 */     FACTORY = paramFactory;
/*    */   }
/*    */   
/*    */   public static NonBlockingSemaphore addSemaphore(String paramString, int paramInt) {
/* 34 */     NonBlockingSemaphore nonBlockingSemaphore = FACTORY.createSemaphore(paramString, paramInt);
/* 35 */     REPO.put(paramString, nonBlockingSemaphore);
/* 36 */     return nonBlockingSemaphore;
/*    */   }
/*    */   
/*    */   public static NonBlockingSemaphore getSemaphore(String paramString) {
/* 40 */     return (NonBlockingSemaphore)REPO.get(paramString);
/*    */   }
/*    */   
/*    */   public static NonBlockingSemaphore removeSemaphore(String paramString) {
/* 44 */     return (NonBlockingSemaphore)REPO.remove(paramString);
/*    */   }
/*    */   
/*    */   public static void clear() {
/* 48 */     REPO.clear();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\a\\utils\NonBlockingSemaphoreRepository.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */