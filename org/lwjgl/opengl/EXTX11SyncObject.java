/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
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
/*    */ public class EXTX11SyncObject
/*    */ {
/*    */   public static final int GL_SYNC_X11_FENCE_EXT = 37089;
/*    */   
/*    */   static {
/* 32 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected EXTX11SyncObject() {
/* 38 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */   @NativeType("GLsync")
/*    */   public static native long glImportSyncEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLintptr") long paramLong, @NativeType("GLbitfield") int paramInt2);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\EXTX11SyncObject.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */