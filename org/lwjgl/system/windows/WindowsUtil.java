/*    */ package org.lwjgl.system.windows;
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
/*    */ public final class WindowsUtil
/*    */ {
/*    */   public static void windowsThrowException(String paramString) {
/* 15 */     throw new RuntimeException(paramString + " (error code = " + WinBase.getLastError() + ")");
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\windows\WindowsUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */