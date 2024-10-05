/*    */ package org.lwjgl.system;
/*    */ 
/*    */ import org.lwjgl.system.libc.LibCString;
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
/*    */ final class MultiReleaseMemCopy
/*    */ {
/*    */   static void copy(long paramLong1, long paramLong2, long paramLong3) {
/* 17 */     if (paramLong3 <= 160L) {
/*    */       
/* 19 */       if (Pointer.BITS64 && ((paramLong1 | paramLong2) & 0x7L) == 0L) {
/*    */         
/* 21 */         MemoryUtil.memCopyAligned64(paramLong1, paramLong2, (int)paramLong3 & 0xFF);
/*    */         return;
/*    */       } 
/* 24 */       MemoryUtil.UNSAFE.copyMemory(null, paramLong1, null, paramLong2, paramLong3);
/*    */ 
/*    */       
/*    */       return;
/*    */     } 
/*    */     
/* 30 */     LibCString.nmemcpy(paramLong2, paramLong1, paramLong3);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\MultiReleaseMemCopy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */