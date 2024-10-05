/*    */ package org.lwjgl.system.linux;
/*    */ 
/*    */ import org.lwjgl.system.Library;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PThread
/*    */ {
/*    */   static {
/* 13 */     Library.initialize();
/*    */   }
/*    */   protected PThread() {
/* 16 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */   @NativeType("pthread_t")
/*    */   public static native long pthread_self();
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\PThread.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */