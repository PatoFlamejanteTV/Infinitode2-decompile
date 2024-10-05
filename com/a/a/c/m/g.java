/*    */ package com.a.a.c.m;
/*    */ 
/*    */ import java.io.InputStream;
/*    */ import java.nio.ByteBuffer;
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class g
/*    */   extends InputStream
/*    */ {
/*    */   private ByteBuffer a;
/*    */   
/*    */   public g(ByteBuffer paramByteBuffer) {
/* 14 */     this.a = paramByteBuffer;
/*    */   } public final int available() {
/* 16 */     return this.a.remaining();
/*    */   }
/*    */   public final int read() {
/* 19 */     return this.a.hasRemaining() ? (this.a.get() & 0xFF) : -1;
/*    */   }
/*    */   
/*    */   public final int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 23 */     if (!this.a.hasRemaining()) return -1; 
/* 24 */     paramInt2 = Math.min(paramInt2, this.a.remaining());
/* 25 */     this.a.get(paramArrayOfbyte, paramInt1, paramInt2);
/* 26 */     return paramInt2;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\m\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */