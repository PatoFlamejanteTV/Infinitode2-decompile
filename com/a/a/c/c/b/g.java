/*    */ package com.a.a.c.c.b;
/*    */ 
/*    */ import com.a.a.b.l;
/*    */ import com.a.a.c.l.f;
/*    */ import com.a.a.c.m.h;
/*    */ import java.io.OutputStream;
/*    */ import java.nio.ByteBuffer;
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class g
/*    */   extends ai<ByteBuffer>
/*    */ {
/*    */   protected g() {
/* 15 */     super(ByteBuffer.class);
/*    */   }
/*    */   
/*    */   public final f b() {
/* 19 */     return f.k;
/*    */   }
/*    */ 
/*    */   
/*    */   private static ByteBuffer a(l paraml) {
/*    */     byte[] arrayOfByte;
/* 25 */     return ByteBuffer.wrap(arrayOfByte = paraml.O());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private static ByteBuffer a(l paraml, com.a.a.c.g paramg, ByteBuffer paramByteBuffer) {
/* 31 */     h h = new h(paramByteBuffer);
/* 32 */     paraml.a(paramg.k(), (OutputStream)h);
/* 33 */     h.close();
/* 34 */     return paramByteBuffer;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\b\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */