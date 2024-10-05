/*    */ package org.lwjgl.system;
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
/*    */ public interface NativeResource
/*    */   extends AutoCloseable
/*    */ {
/*    */   void free();
/*    */   
/*    */   default void close() {
/* 20 */     free();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\NativeResource.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */