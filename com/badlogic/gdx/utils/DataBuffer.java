/*    */ package com.badlogic.gdx.utils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DataBuffer
/*    */   extends DataOutput
/*    */ {
/*    */   private final StreamUtils.OptimizedByteArrayOutputStream outStream;
/*    */   
/*    */   public DataBuffer() {
/* 12 */     this(32);
/*    */   }
/*    */   
/*    */   public DataBuffer(int paramInt) {
/* 16 */     super(new StreamUtils.OptimizedByteArrayOutputStream(paramInt));
/* 17 */     this.outStream = (StreamUtils.OptimizedByteArrayOutputStream)this.out;
/*    */   }
/*    */ 
/*    */   
/*    */   public byte[] getBuffer() {
/* 22 */     return this.outStream.getBuffer();
/*    */   }
/*    */   
/*    */   public byte[] toArray() {
/* 26 */     return this.outStream.toByteArray();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\DataBuffer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */