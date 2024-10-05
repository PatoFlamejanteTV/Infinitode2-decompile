/*     */ package org.jsoup.internal;
/*     */ 
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.FilterInputStream;
/*     */ import java.io.InputStream;
/*     */ import java.net.SocketTimeoutException;
/*     */ import java.nio.ByteBuffer;
/*     */ import org.jsoup.helper.Validate;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ControllableInputStream
/*     */   extends FilterInputStream
/*     */ {
/*     */   private final BufferedInputStream buff;
/*     */   private final boolean capped;
/*     */   private final int maxSize;
/*     */   private long startTime;
/*  26 */   private long timeout = 0L;
/*     */   private int remaining;
/*     */   private int markPos;
/*     */   private boolean interrupted;
/*     */   
/*     */   private ControllableInputStream(BufferedInputStream paramBufferedInputStream, int paramInt) {
/*  32 */     super(paramBufferedInputStream);
/*  33 */     Validate.isTrue((paramInt >= 0));
/*  34 */     this.buff = paramBufferedInputStream;
/*  35 */     this.capped = (paramInt != 0);
/*  36 */     this.maxSize = paramInt;
/*  37 */     this.remaining = paramInt;
/*  38 */     this.markPos = -1;
/*  39 */     this.startTime = System.nanoTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ControllableInputStream wrap(InputStream paramInputStream, int paramInt1, int paramInt2) {
/*  50 */     if (paramInputStream instanceof ControllableInputStream)
/*  51 */       return (ControllableInputStream)paramInputStream; 
/*  52 */     if (paramInputStream instanceof BufferedInputStream) {
/*  53 */       return new ControllableInputStream((BufferedInputStream)paramInputStream, paramInt2);
/*     */     }
/*  55 */     return new ControllableInputStream(new BufferedInputStream(paramInputStream, paramInt1), paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  60 */     if (this.interrupted || (this.capped && this.remaining <= 0))
/*  61 */       return -1; 
/*  62 */     if (Thread.currentThread().isInterrupted()) {
/*     */       
/*  64 */       this.interrupted = true;
/*  65 */       return -1;
/*     */     } 
/*  67 */     if (expired()) {
/*  68 */       throw new SocketTimeoutException("Read timeout");
/*     */     }
/*  70 */     if (this.capped && paramInt2 > this.remaining) {
/*  71 */       paramInt2 = this.remaining;
/*     */     }
/*     */     try {
/*  74 */       int i = super.read(paramArrayOfbyte, paramInt1, paramInt2);
/*  75 */       this.remaining -= i;
/*  76 */       return i;
/*  77 */     } catch (SocketTimeoutException socketTimeoutException) {
/*  78 */       return 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ByteBuffer readToByteBuffer(InputStream paramInputStream, int paramInt) {
/*  87 */     Validate.isTrue((paramInt >= 0), "maxSize must be 0 (unlimited) or larger");
/*  88 */     Validate.notNull(paramInputStream);
/*     */     
/*     */     boolean bool1, bool2;
/*  91 */     byte[] arrayOfByte = new byte[bool2 = ((bool1 = (paramInt > 0) ? true : false) && paramInt < 32768) ? paramInt : true];
/*  92 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bool2);
/*     */ 
/*     */     
/*  95 */     int i = paramInt;
/*     */     
/*     */     while (true) {
/*  98 */       if ((paramInt = paramInputStream.read(arrayOfByte, 0, bool1 ? Math.min(i, bool2) : bool2)) != -1) {
/*  99 */         if (bool1) {
/* 100 */           if (paramInt >= i) {
/* 101 */             byteArrayOutputStream.write(arrayOfByte, 0, i);
/*     */             break;
/*     */           } 
/* 104 */           i -= paramInt;
/*     */         } 
/* 106 */         byteArrayOutputStream.write(arrayOfByte, 0, paramInt); continue;
/*     */       }  break;
/* 108 */     }  return ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
/*     */   }
/*     */ 
/*     */   
/*     */   public void reset() {
/* 113 */     super.reset();
/* 114 */     this.remaining = this.maxSize - this.markPos;
/*     */   }
/*     */ 
/*     */   
/*     */   public void mark(int paramInt) {
/* 119 */     super.mark(paramInt);
/* 120 */     this.markPos = this.maxSize - this.remaining;
/*     */   }
/*     */   
/*     */   public ControllableInputStream timeout(long paramLong1, long paramLong2) {
/* 124 */     this.startTime = paramLong1;
/* 125 */     this.timeout = paramLong2 * 1000000L;
/* 126 */     return this;
/*     */   }
/*     */   
/*     */   private boolean expired() {
/* 130 */     if (this.timeout == 0L) {
/* 131 */       return false;
/*     */     }
/*     */     long l1;
/*     */     long l2;
/* 135 */     return ((l2 = (l1 = System.nanoTime()) - this.startTime) > this.timeout);
/*     */   }
/*     */   
/*     */   public BufferedInputStream inputStream() {
/* 139 */     return this.buff;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\internal\ControllableInputStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */