/*    */ package com.prineside.tdi2;
/*    */ 
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.KryoSerializable;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public abstract class SerializableListener<T>
/*    */   implements KryoSerializable {
/*    */   protected T a;
/*    */   
/*    */   public void write(Kryo paramKryo, Output paramOutput) {
/* 15 */     paramKryo.writeClassAndObject(paramOutput, this.a);
/*    */   }
/*    */ 
/*    */   
/*    */   public void read(Kryo paramKryo, Input paramInput) {
/* 20 */     this.a = (T)paramKryo.readClassAndObject(paramInput);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\SerializableListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */