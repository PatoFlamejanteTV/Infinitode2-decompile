/*    */ package com.a.a.c.m;
/*    */ 
/*    */ import java.io.OutputStream;
/*    */ import java.nio.ByteBuffer;
/*    */ 
/*    */ 
/*    */ public final class h
/*    */   extends OutputStream
/*    */ {
/*    */   private ByteBuffer a;
/*    */   
/*    */   public h(ByteBuffer paramByteBuffer) {
/* 13 */     this.a = paramByteBuffer;
/*    */   }
/* 15 */   public final void write(int paramInt) { this.a.put((byte)paramInt); } public final void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 16 */     this.a.put(paramArrayOfbyte, paramInt1, paramInt2);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\m\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */