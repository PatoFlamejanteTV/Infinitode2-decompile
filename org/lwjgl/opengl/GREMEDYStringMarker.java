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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GREMEDYStringMarker
/*    */ {
/*    */   static {
/* 33 */     GL.initialize();
/*    */   }
/*    */   protected GREMEDYStringMarker() {
/* 36 */     throw new UnsupportedOperationException();
/*    */   }
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
/*    */   public static void glStringMarkerGREMEDY(@NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/* 56 */     nglStringMarkerGREMEDY(paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glStringMarkerGREMEDY(@NativeType("GLchar const *") CharSequence paramCharSequence) {
/*    */     MemoryStack memoryStack;
/* 66 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*    */     try {
/* 68 */       int j = memoryStack.nUTF8(paramCharSequence, false);
/* 69 */       long l = memoryStack.getPointerAddress();
/* 70 */       nglStringMarkerGREMEDY(j, l); return;
/*    */     } finally {
/* 72 */       memoryStack.setPointer(i);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static native void nglStringMarkerGREMEDY(int paramInt, long paramLong);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GREMEDYStringMarker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */