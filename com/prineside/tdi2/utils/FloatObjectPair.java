/*    */ package com.prineside.tdi2.utils;
/*    */ 
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.KryoSerializable;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ 
/*    */ @REGS
/*    */ public final class FloatObjectPair<T>
/*    */   implements KryoSerializable {
/*    */   public float a;
/*    */   public T t;
/*    */   
/*    */   public final void write(Kryo paramKryo, Output paramOutput) {
/* 15 */     paramOutput.writeFloat(this.a);
/* 16 */     paramKryo.writeClassAndObject(paramOutput, this.t);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void read(Kryo paramKryo, Input paramInput) {
/* 21 */     this.a = paramInput.readFloat();
/* 22 */     this.t = (T)paramKryo.readClassAndObject(paramInput);
/*    */   }
/*    */   
/*    */   public FloatObjectPair() {}
/*    */   
/*    */   public FloatObjectPair(float paramFloat, T paramT) {
/* 28 */     this.a = paramFloat;
/* 29 */     this.t = paramT;
/*    */   }
/*    */ 
/*    */   
/*    */   public final String toString() {
/* 34 */     return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " {" + this.a + ", " + this.t + "}";
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\FloatObjectPair.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */