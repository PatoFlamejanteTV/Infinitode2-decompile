/*    */ package com.esotericsoftware.kryonet.util;
/*    */ 
/*    */ import com.esotericsoftware.kryonet.KryoNetException;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
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
/*    */ public abstract class InputStreamSender
/*    */   extends TcpIdleSender
/*    */ {
/*    */   private final InputStream input;
/*    */   private final byte[] chunk;
/*    */   
/*    */   public InputStreamSender(InputStream paramInputStream, int paramInt) {
/* 32 */     this.input = paramInputStream;
/* 33 */     this.chunk = new byte[paramInt];
/*    */   }
/*    */ 
/*    */   
/*    */   protected final Object next() {
/*    */     try {
/* 39 */       int i = 0;
/* 40 */       while (i < this.chunk.length) {
/*    */         byte[] arrayOfByte; int j;
/* 42 */         if ((j = this.input.read(this.chunk, i, this.chunk.length - i)) < 0) {
/* 43 */           if (i == 0)
/* 44 */             return null; 
/* 45 */           arrayOfByte = new byte[i];
/* 46 */           System.arraycopy(this.chunk, 0, arrayOfByte, 0, i);
/* 47 */           return next(arrayOfByte);
/*    */         } 
/* 49 */         i += arrayOfByte;
/*    */       } 
/* 51 */     } catch (IOException iOException) {
/* 52 */       throw new KryoNetException(iOException);
/*    */     } 
/* 54 */     return next(this.chunk);
/*    */   }
/*    */   
/*    */   protected abstract Object next(byte[] paramArrayOfbyte);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryone\\util\InputStreamSender.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */