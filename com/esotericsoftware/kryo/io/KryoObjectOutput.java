/*    */ package com.esotericsoftware.kryo.io;
/*    */ 
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import java.io.ObjectOutput;
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
/*    */ public class KryoObjectOutput
/*    */   extends KryoDataOutput
/*    */   implements ObjectOutput
/*    */ {
/*    */   private final Kryo kryo;
/*    */   
/*    */   public KryoObjectOutput(Kryo paramKryo, Output paramOutput) {
/* 37 */     super(paramOutput);
/* 38 */     this.kryo = paramKryo;
/*    */   }
/*    */   
/*    */   public void writeObject(Object paramObject) {
/* 42 */     this.kryo.writeClassAndObject(this.output, paramObject);
/*    */   }
/*    */   
/*    */   public void flush() {
/* 46 */     this.output.flush();
/*    */   }
/*    */   
/*    */   public void close() {
/* 50 */     this.output.close();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\io\KryoObjectOutput.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */