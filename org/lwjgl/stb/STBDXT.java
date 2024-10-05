/*    */ package org.lwjgl.stb;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import org.lwjgl.system.Checks;
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
/*    */ public class STBDXT
/*    */ {
/*    */   public static final int STB_DXT_NORMAL = 0;
/*    */   public static final int STB_DXT_DITHER = 1;
/*    */   public static final int STB_DXT_HIGHQUAL = 2;
/*    */   
/*    */   static {
/* 22 */     LibSTB.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected STBDXT() {
/* 33 */     throw new UnsupportedOperationException();
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
/*    */   public static void stb_compress_dxt_block(@NativeType("unsigned char *") ByteBuffer paramByteBuffer1, @NativeType("unsigned char const *") ByteBuffer paramByteBuffer2, @NativeType("int") boolean paramBoolean, int paramInt) {
/* 53 */     if (Checks.CHECKS) {
/* 54 */       Checks.check(paramByteBuffer1, paramBoolean ? 16 : 8);
/* 55 */       Checks.check(paramByteBuffer2, 64);
/*    */     } 
/* 57 */     nstb_compress_dxt_block(MemoryUtil.memAddress(paramByteBuffer1), MemoryUtil.memAddress(paramByteBuffer2), paramBoolean ? 1 : 0, paramInt);
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
/*    */   public static void stb_compress_bc4_block(@NativeType("unsigned char *") ByteBuffer paramByteBuffer1, @NativeType("unsigned char const *") ByteBuffer paramByteBuffer2) {
/* 72 */     if (Checks.CHECKS) {
/* 73 */       Checks.check(paramByteBuffer1, 8);
/* 74 */       Checks.check(paramByteBuffer2, 16);
/*    */     } 
/* 76 */     nstb_compress_bc4_block(MemoryUtil.memAddress(paramByteBuffer1), MemoryUtil.memAddress(paramByteBuffer2));
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
/*    */   public static void stb_compress_bc5_block(@NativeType("unsigned char *") ByteBuffer paramByteBuffer1, @NativeType("unsigned char const *") ByteBuffer paramByteBuffer2) {
/* 91 */     if (Checks.CHECKS) {
/* 92 */       Checks.check(paramByteBuffer1, 16);
/* 93 */       Checks.check(paramByteBuffer2, 32);
/*    */     } 
/* 95 */     nstb_compress_bc5_block(MemoryUtil.memAddress(paramByteBuffer1), MemoryUtil.memAddress(paramByteBuffer2));
/*    */   }
/*    */   
/*    */   public static native void nstb_compress_dxt_block(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
/*    */   
/*    */   public static native void nstb_compress_bc4_block(long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void nstb_compress_bc5_block(long paramLong1, long paramLong2);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\stb\STBDXT.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */