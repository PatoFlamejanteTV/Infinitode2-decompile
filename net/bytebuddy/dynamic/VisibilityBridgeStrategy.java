/*    */ package net.bytebuddy.dynamic;
/*    */ 
/*    */ import net.bytebuddy.description.method.MethodDescription;
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
/*    */ 
/*    */ 
/*    */ public interface VisibilityBridgeStrategy
/*    */ {
/*    */   boolean generateVisibilityBridge(MethodDescription paramMethodDescription);
/*    */   
/*    */   public enum Default
/*    */     implements VisibilityBridgeStrategy
/*    */   {
/* 43 */     ALWAYS
/*    */     {
/*    */       
/*    */       public final boolean generateVisibilityBridge(MethodDescription param2MethodDescription)
/*    */       {
/* 48 */         return true;
/*    */       }
/*    */     },
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 55 */     ON_NON_GENERIC_METHOD
/*    */     {
/*    */       
/*    */       public final boolean generateVisibilityBridge(MethodDescription param2MethodDescription)
/*    */       {
/* 60 */         return !param2MethodDescription.isGenerified();
/*    */       }
/*    */     },
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 67 */     NEVER
/*    */     {
/*    */       
/*    */       public final boolean generateVisibilityBridge(MethodDescription param2MethodDescription)
/*    */       {
/* 72 */         return false;
/*    */       }
/*    */     };
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\dynamic\VisibilityBridgeStrategy.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */