/*    */ package org.lwjgl.system.linux;
/*    */ 
/*    */ import org.lwjgl.system.Library;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ public class UIO
/*    */ {
/*    */   public static final int UIO_FASTIOV = 8;
/*    */   public static final int UIO_MAXIOV = 1024;
/*    */   public static final int RWF_HIPRI = 1;
/*    */   
/*    */   static {
/* 13 */     Library.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static final int RWF_DSYNC = 2;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static final int RWF_SYNC = 4;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static final int RWF_NOWAIT = 8;
/*    */ 
/*    */ 
/*    */   
/*    */   public static final int RWF_APPEND = 16;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected UIO() {
/* 40 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("ssize_t")
/*    */   public static long readv(int paramInt1, @NativeType("struct iovec const *") IOVec paramIOVec, int paramInt2) {
/* 49 */     return nreadv(paramInt1, paramIOVec.address(), paramInt2);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("ssize_t")
/*    */   public static long writev(int paramInt1, @NativeType("struct iovec const *") IOVec paramIOVec, int paramInt2) {
/* 58 */     return nwritev(paramInt1, paramIOVec.address(), paramInt2);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("ssize_t")
/*    */   public static long preadv(int paramInt1, @NativeType("struct iovec const *") IOVec paramIOVec, int paramInt2, @NativeType("off_t") long paramLong) {
/* 67 */     return npreadv(paramInt1, paramIOVec.address(), paramInt2, paramLong);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("ssize_t")
/*    */   public static long pwritev(int paramInt1, @NativeType("struct iovec const *") IOVec paramIOVec, int paramInt2, @NativeType("off_t") long paramLong) {
/* 76 */     return npwritev(paramInt1, paramIOVec.address(), paramInt2, paramLong);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("ssize_t")
/*    */   public static long process_vm_readv(@NativeType("pid_t") int paramInt, @NativeType("struct iovec const *") IOVec paramIOVec1, @NativeType("unsigned long int") long paramLong1, @NativeType("struct iovec const *") IOVec paramIOVec2, @NativeType("unsigned long int") long paramLong2, @NativeType("unsigned long int") long paramLong3) {
/* 87 */     return nprocess_vm_readv(paramInt, paramIOVec1.address(), paramLong1, paramIOVec2.address(), paramLong2, paramLong3);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("ssize_t")
/*    */   public static long process_vm_writev(@NativeType("pid_t") int paramInt, @NativeType("struct iovec const *") IOVec paramIOVec1, @NativeType("unsigned long int") long paramLong1, @NativeType("struct iovec const *") IOVec paramIOVec2, @NativeType("unsigned long int") long paramLong2, @NativeType("unsigned long int") long paramLong3) {
/* 98 */     return nprocess_vm_writev(paramInt, paramIOVec1.address(), paramLong1, paramIOVec2.address(), paramLong2, paramLong3);
/*    */   }
/*    */   
/*    */   public static native long nreadv(int paramInt1, long paramLong, int paramInt2);
/*    */   
/*    */   public static native long nwritev(int paramInt1, long paramLong, int paramInt2);
/*    */   
/*    */   public static native long npreadv(int paramInt1, long paramLong1, int paramInt2, long paramLong2);
/*    */   
/*    */   public static native long npwritev(int paramInt1, long paramLong1, int paramInt2, long paramLong2);
/*    */   
/*    */   public static native long nprocess_vm_readv(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */   
/*    */   public static native long nprocess_vm_writev(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\UIO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */