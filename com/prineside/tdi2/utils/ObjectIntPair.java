/*    */ package com.prineside.tdi2.utils;
/*    */ 
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.KryoSerializable;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ 
/*    */ @REGS
/*    */ public final class ObjectIntPair<T>
/*    */   implements KryoSerializable {
/*    */   public T object;
/*    */   public int intValue;
/*    */   
/*    */   public final void write(Kryo paramKryo, Output paramOutput) {
/* 15 */     paramKryo.writeClassAndObject(paramOutput, this.object);
/* 16 */     paramOutput.writeInt(this.intValue);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void read(Kryo paramKryo, Input paramInput) {
/* 21 */     this.object = (T)paramKryo.readClassAndObject(paramInput);
/* 22 */     this.intValue = paramInput.readInt();
/*    */   }
/*    */ 
/*    */   
/*    */   public ObjectIntPair() {}
/*    */ 
/*    */   
/*    */   public ObjectIntPair(T paramT, int paramInt) {
/* 30 */     this.object = paramT;
/* 31 */     this.intValue = paramInt;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\ObjectIntPair.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */