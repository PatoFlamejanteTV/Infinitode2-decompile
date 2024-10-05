/*    */ package com.esotericsoftware.kryo.io;
/*    */ 
/*    */ import java.io.InputStream;
/*    */ import java.nio.Buffer;
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
/*    */ public class ByteBufferInputStream
/*    */   extends InputStream
/*    */ {
/*    */   private ByteBuffer byteBuffer;
/*    */   
/*    */   public ByteBufferInputStream() {}
/*    */   
/*    */   public ByteBufferInputStream(int paramInt) {
/* 38 */     this(ByteBuffer.allocate(paramInt));
/* 39 */     flipBuffer(this.byteBuffer);
/*    */   }
/*    */   
/*    */   public ByteBufferInputStream(ByteBuffer paramByteBuffer) {
/* 43 */     this.byteBuffer = paramByteBuffer;
/*    */   }
/*    */   
/*    */   public ByteBuffer getByteBuffer() {
/* 47 */     return this.byteBuffer;
/*    */   }
/*    */   
/*    */   public void setByteBuffer(ByteBuffer paramByteBuffer) {
/* 51 */     this.byteBuffer = paramByteBuffer;
/*    */   }
/*    */   
/*    */   public int read() {
/* 55 */     if (!this.byteBuffer.hasRemaining()) return -1; 
/* 56 */     return this.byteBuffer.get() & 0xFF;
/*    */   }
/*    */   
/*    */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 60 */     if (paramInt2 == 0) return 0;
/*    */     
/* 62 */     if ((paramInt2 = Math.min(this.byteBuffer.remaining(), paramInt2)) == 0) return -1; 
/* 63 */     this.byteBuffer.get(paramArrayOfbyte, paramInt1, paramInt2);
/* 64 */     return paramInt2;
/*    */   }
/*    */   
/*    */   public int available() {
/* 68 */     return this.byteBuffer.remaining();
/*    */   }
/*    */   
/*    */   private void flipBuffer(Buffer paramBuffer) {
/* 72 */     paramBuffer.flip();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\io\ByteBufferInputStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */