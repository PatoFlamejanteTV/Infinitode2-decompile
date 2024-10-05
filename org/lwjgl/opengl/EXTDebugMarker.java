/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import org.lwjgl.system.MemoryStack;
/*    */ import org.lwjgl.system.MemoryUtil;
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
/*    */ public class EXTDebugMarker
/*    */ {
/*    */   static {
/* 28 */     GL.initialize();
/*    */   }
/*    */   protected EXTDebugMarker() {
/* 31 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glInsertEventMarkerEXT(@NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/* 39 */     nglInsertEventMarkerEXT(paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*    */   }
/*    */   public static void glInsertEventMarkerEXT(@NativeType("GLchar const *") CharSequence paramCharSequence) {
/*    */     MemoryStack memoryStack;
/* 43 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*    */     try {
/* 45 */       int j = memoryStack.nUTF8(paramCharSequence, false);
/* 46 */       long l = memoryStack.getPointerAddress();
/* 47 */       nglInsertEventMarkerEXT(j, l); return;
/*    */     } finally {
/* 49 */       memoryStack.setPointer(i);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glPushGroupMarkerEXT(@NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/* 58 */     nglPushGroupMarkerEXT(paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*    */   }
/*    */   public static void glPushGroupMarkerEXT(@NativeType("GLchar const *") CharSequence paramCharSequence) {
/*    */     MemoryStack memoryStack;
/* 62 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*    */     try {
/* 64 */       int j = memoryStack.nUTF8(paramCharSequence, false);
/* 65 */       long l = memoryStack.getPointerAddress();
/* 66 */       nglPushGroupMarkerEXT(j, l); return;
/*    */     } finally {
/* 68 */       memoryStack.setPointer(i);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static native void nglInsertEventMarkerEXT(int paramInt, long paramLong);
/*    */   
/*    */   public static native void nglPushGroupMarkerEXT(int paramInt, long paramLong);
/*    */   
/*    */   public static native void glPopGroupMarkerEXT();
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\EXTDebugMarker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */