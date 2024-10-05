/*    */ package org.lwjgl.system;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class SharedLibraryUtil
/*    */ {
/*    */   private static native int getLibraryPath(long paramLong1, long paramLong2, int paramInt);
/*    */   
/*    */   public static String getLibraryPath(long paramLong) {
/* 18 */     int i = 256;
/*    */     
/* 20 */     ByteBuffer byteBuffer = MemoryUtil.memAlloc(256);
/*    */     try {
/*    */       while (true) {
/*    */         int j;
/* 24 */         if ((j = getLibraryPath(paramLong, MemoryUtil.memAddress(byteBuffer), i)) == 0) {
/* 25 */           return null;
/*    */         }
/* 27 */         if (j < i) {
/* 28 */           return MemoryUtil.memUTF8(byteBuffer, j - 1);
/*    */         }
/* 30 */         byteBuffer = MemoryUtil.memRealloc(byteBuffer, i = i * 3 / 2);
/*    */       } 
/*    */     } finally {
/* 33 */       MemoryUtil.memFree(byteBuffer);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\SharedLibraryUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */