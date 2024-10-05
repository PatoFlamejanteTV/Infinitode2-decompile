/*    */ package org.lwjgl.system;
/*    */ 
/*    */ import org.lwjgl.system.libffi.FFICIF;
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
/*    */ public interface CallbackI
/*    */   extends Pointer
/*    */ {
/*    */   FFICIF getCallInterface();
/*    */   
/*    */   default long address() {
/* 25 */     return Callback.create(getCallInterface(), this);
/*    */   }
/*    */   
/*    */   void callback(long paramLong1, long paramLong2);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\CallbackI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */