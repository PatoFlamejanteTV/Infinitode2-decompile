/*    */ package org.lwjgl.system.linux;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import org.lwjgl.system.Library;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UNISTD
/*    */ {
/*    */   public static final int _SC_OPEN_MAX = 4;
/*    */   public static final int _SC_PAGE_SIZE = 30;
/*    */   public static final int _SC_IOV_MAX = 60;
/*    */   
/*    */   static {
/* 17 */     Library.initialize();
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
/*    */   protected UNISTD() {
/* 34 */     throw new UnsupportedOperationException();
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
/*    */   @NativeType("ssize_t")
/*    */   public static long read(int paramInt, @NativeType("void *") ByteBuffer paramByteBuffer) {
/* 53 */     return nread(paramInt, MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining());
/*    */   }
/*    */   
/*    */   public static native int close(int paramInt);
/*    */   
/*    */   public static native long sysconf(int paramInt);
/*    */   
/*    */   public static native long nread(int paramInt, long paramLong1, long paramLong2);
/*    */   
/*    */   @NativeType("pid_t")
/*    */   public static native int getpid();
/*    */   
/*    */   @NativeType("pid_t")
/*    */   public static native int getppid();
/*    */   
/*    */   @NativeType("pid_t")
/*    */   public static native int gettid();
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\UNISTD.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */