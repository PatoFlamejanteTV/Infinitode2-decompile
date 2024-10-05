/*    */ package org.jsoup.internal;
/*    */ 
/*    */ import java.io.BufferedInputStream;
/*    */ import java.io.InputStream;
/*    */ import java.net.SocketTimeoutException;
/*    */ import java.nio.ByteBuffer;
/*    */ import org.jsoup.helper.DataUtil;
/*    */ import org.jsoup.helper.Validate;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Deprecated
/*    */ public final class ConstrainableInputStream
/*    */   extends BufferedInputStream
/*    */ {
/*    */   private final boolean capped;
/*    */   private final int maxSize;
/*    */   private long startTime;
/* 22 */   private long timeout = 0L;
/*    */   private int remaining;
/*    */   private boolean interrupted;
/*    */   
/*    */   private ConstrainableInputStream(InputStream paramInputStream, int paramInt1, int paramInt2) {
/* 27 */     super(paramInputStream, paramInt1);
/* 28 */     Validate.isTrue((paramInt2 >= 0));
/* 29 */     this.maxSize = paramInt2;
/* 30 */     this.remaining = paramInt2;
/* 31 */     this.capped = (paramInt2 != 0);
/* 32 */     this.startTime = System.nanoTime();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static ConstrainableInputStream wrap(InputStream paramInputStream, int paramInt1, int paramInt2) {
/* 43 */     if (paramInputStream instanceof ConstrainableInputStream)
/* 44 */       return (ConstrainableInputStream)paramInputStream; 
/* 45 */     return new ConstrainableInputStream(paramInputStream, paramInt1, paramInt2);
/*    */   }
/*    */ 
/*    */   
/*    */   public final int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 50 */     if (this.interrupted || (this.capped && this.remaining <= 0))
/* 51 */       return -1; 
/* 52 */     if (Thread.currentThread().isInterrupted()) {
/*    */       
/* 54 */       this.interrupted = true;
/* 55 */       return -1;
/*    */     } 
/* 57 */     if (expired()) {
/* 58 */       throw new SocketTimeoutException("Read timeout");
/*    */     }
/* 60 */     if (this.capped && paramInt2 > this.remaining) {
/* 61 */       paramInt2 = this.remaining;
/*    */     }
/*    */     try {
/* 64 */       int i = super.read(paramArrayOfbyte, paramInt1, paramInt2);
/* 65 */       this.remaining -= i;
/* 66 */       return i;
/* 67 */     } catch (SocketTimeoutException socketTimeoutException) {
/* 68 */       return 0;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final ByteBuffer readToByteBuffer(int paramInt) {
/* 77 */     return DataUtil.readToByteBuffer(this, paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void reset() {
/* 82 */     super.reset();
/* 83 */     this.remaining = this.maxSize - this.markpos;
/*    */   }
/*    */   
/*    */   public final ConstrainableInputStream timeout(long paramLong1, long paramLong2) {
/* 87 */     this.startTime = paramLong1;
/* 88 */     this.timeout = paramLong2 * 1000000L;
/* 89 */     return this;
/*    */   }
/*    */   
/*    */   private boolean expired() {
/* 93 */     if (this.timeout == 0L) {
/* 94 */       return false;
/*    */     }
/*    */     long l1;
/*    */     long l2;
/* 98 */     return ((l2 = (l1 = System.nanoTime()) - this.startTime) > this.timeout);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\internal\ConstrainableInputStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */