/*    */ package org.lwjgl.system.linux;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.Library;
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
/*    */ public class Stat
/*    */ {
/*    */   static {
/* 19 */     Library.initialize();
/*    */   }
/*    */   protected Stat() {
/* 22 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static int stat(@NativeType("char const *") ByteBuffer paramByteBuffer, @NativeType("struct stat *") long paramLong) {
/* 30 */     if (Checks.CHECKS) {
/* 31 */       Checks.checkNT1(paramByteBuffer);
/* 32 */       Checks.check(paramLong);
/*    */     } 
/* 34 */     return nstat(MemoryUtil.memAddress(paramByteBuffer), paramLong);
/*    */   }
/*    */   
/*    */   public static int stat(@NativeType("char const *") CharSequence paramCharSequence, @NativeType("struct stat *") long paramLong) {
/* 38 */     if (Checks.CHECKS)
/* 39 */       Checks.check(paramLong); 
/*    */     MemoryStack memoryStack;
/* 41 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*    */     try {
/* 43 */       memoryStack.nUTF8(paramCharSequence, true);
/*    */       long l;
/* 45 */       return nstat(l = memoryStack.getPointerAddress(), paramLong);
/*    */     } finally {
/* 47 */       memoryStack.setPointer(i);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static int fstat(int paramInt, @NativeType("struct stat *") long paramLong) {
/* 56 */     if (Checks.CHECKS) {
/* 57 */       Checks.check(paramLong);
/*    */     }
/* 59 */     return nfstat(paramInt, paramLong);
/*    */   }
/*    */   
/*    */   public static native int nstat(long paramLong1, long paramLong2);
/*    */   
/*    */   public static native int nfstat(int paramInt, long paramLong);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\Stat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */