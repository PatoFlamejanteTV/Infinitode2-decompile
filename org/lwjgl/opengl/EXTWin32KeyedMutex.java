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
/*    */ public class EXTWin32KeyedMutex
/*    */ {
/*    */   static {
/* 21 */     GL.initialize();
/*    */   }
/*    */   protected EXTWin32KeyedMutex() {
/* 24 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */   @NativeType("GLboolean")
/*    */   public static native boolean glReleaseKeyedMutexWin32EXT(@NativeType("GLuint") int paramInt, @NativeType("GLuint64") long paramLong);
/*    */   
/*    */   @NativeType("GLboolean")
/*    */   public static native boolean glAcquireKeyedMutexWin32EXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint64") long paramLong, @NativeType("GLuint") int paramInt2);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\EXTWin32KeyedMutex.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */