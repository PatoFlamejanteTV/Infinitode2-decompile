/*    */ package org.lwjgl.system.linux;
/*    */ 
/*    */ import org.lwjgl.system.Library;
/*    */ 
/*    */ 
/*    */ public class Socket
/*    */ {
/*    */   public static final int SHUT_RD = 0;
/*    */   public static final int SHUT_WR = 1;
/*    */   public static final int SHUT_RDWR = 2;
/*    */   
/*    */   static {
/* 13 */     Library.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static native int socket(int paramInt1, int paramInt2, int paramInt3);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected Socket() {
/* 32 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\Socket.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */