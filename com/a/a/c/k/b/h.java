/*    */ package com.a.a.c.k.b;
/*    */ 
/*    */ import com.a.a.c.aa;
/*    */ import com.a.a.c.m.g;
/*    */ import java.io.InputStream;
/*    */ import java.nio.ByteBuffer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class h
/*    */   extends an<ByteBuffer>
/*    */ {
/*    */   public h() {
/* 16 */     super(ByteBuffer.class);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private static void a(ByteBuffer paramByteBuffer, com.a.a.b.h paramh) {
/* 22 */     if (paramByteBuffer.hasArray()) {
/* 23 */       int i = paramByteBuffer.position();
/* 24 */       paramh.a(paramByteBuffer.array(), paramByteBuffer.arrayOffset() + i, paramByteBuffer.limit() - i);
/*    */       
/*    */       return;
/*    */     } 
/*    */     
/*    */     ByteBuffer byteBuffer;
/* 30 */     if ((byteBuffer = paramByteBuffer.asReadOnlyBuffer()).position() > 0) {
/* 31 */       byteBuffer.rewind();
/*    */     }
/* 33 */     g g = new g(byteBuffer);
/* 34 */     paramh.a((InputStream)g, byteBuffer.remaining());
/* 35 */     g.close();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\b\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */