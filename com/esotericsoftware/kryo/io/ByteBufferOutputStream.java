/*    */ package com.esotericsoftware.kryo.io;
/*    */ 
/*    */ import java.io.OutputStream;
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
/*    */ public class ByteBufferOutputStream
/*    */   extends OutputStream
/*    */ {
/*    */   private ByteBuffer byteBuffer;
/*    */   
/*    */   public ByteBufferOutputStream() {}
/*    */   
/*    */   public ByteBufferOutputStream(int paramInt) {
/* 38 */     this(ByteBuffer.allocate(paramInt));
/*    */   }
/*    */   
/*    */   public ByteBufferOutputStream(ByteBuffer paramByteBuffer) {
/* 42 */     this.byteBuffer = paramByteBuffer;
/*    */   }
/*    */   
/*    */   public ByteBuffer getByteBuffer() {
/* 46 */     return this.byteBuffer;
/*    */   }
/*    */   
/*    */   public void setByteBuffer(ByteBuffer paramByteBuffer) {
/* 50 */     this.byteBuffer = paramByteBuffer;
/*    */   }
/*    */   
/*    */   public void write(int paramInt) {
/* 54 */     if (!this.byteBuffer.hasRemaining()) flush(); 
/* 55 */     this.byteBuffer.put((byte)paramInt);
/*    */   }
/*    */   
/*    */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 59 */     if (this.byteBuffer.remaining() < paramInt2) flush(); 
/* 60 */     this.byteBuffer.put(paramArrayOfbyte, paramInt1, paramInt2);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\io\ByteBufferOutputStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */