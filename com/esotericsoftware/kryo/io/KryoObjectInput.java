/*    */ package com.esotericsoftware.kryo.io;
/*    */ 
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import java.io.ObjectInput;
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
/*    */ public class KryoObjectInput
/*    */   extends KryoDataInput
/*    */   implements ObjectInput
/*    */ {
/*    */   private final Kryo kryo;
/*    */   
/*    */   public KryoObjectInput(Kryo paramKryo, Input paramInput) {
/* 36 */     super(paramInput);
/* 37 */     this.kryo = paramKryo;
/*    */   }
/*    */   
/*    */   public Object readObject() {
/* 41 */     return this.kryo.readClassAndObject(this.input);
/*    */   }
/*    */   
/*    */   public int read() {
/* 45 */     return this.input.read();
/*    */   }
/*    */   
/*    */   public int read(byte[] paramArrayOfbyte) {
/* 49 */     return this.input.read(paramArrayOfbyte);
/*    */   }
/*    */   
/*    */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 53 */     return this.input.read(paramArrayOfbyte, paramInt1, paramInt2);
/*    */   }
/*    */   
/*    */   public long skip(long paramLong) {
/* 57 */     return this.input.skip(paramLong);
/*    */   }
/*    */   
/*    */   public int available() {
/* 61 */     return 0;
/*    */   }
/*    */   
/*    */   public void close() {
/* 65 */     this.input.close();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\io\KryoObjectInput.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */