/*    */ package com.prineside.tdi2.utils;
/*    */ 
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.KryoSerializable;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ 
/*    */ @REGS
/*    */ public final class IntObjectPair<T>
/*    */   implements KryoSerializable {
/*    */   public int a;
/*    */   public T t;
/*    */   
/*    */   public final void write(Kryo paramKryo, Output paramOutput) {
/* 15 */     paramOutput.writeInt(this.a);
/* 16 */     paramKryo.writeClassAndObject(paramOutput, this.t);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void read(Kryo paramKryo, Input paramInput) {
/* 21 */     this.a = paramInput.readInt();
/* 22 */     this.t = (T)paramKryo.readClassAndObject(paramInput);
/*    */   }
/*    */   
/*    */   public IntObjectPair() {}
/*    */   
/*    */   public IntObjectPair(int paramInt, T paramT) {
/* 28 */     this.a = paramInt;
/* 29 */     this.t = paramT;
/*    */   }
/*    */ 
/*    */   
/*    */   public final String toString() {
/* 34 */     return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " {" + this.a + ", " + this.t + "}";
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\IntObjectPair.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */