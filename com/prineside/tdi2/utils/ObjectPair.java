/*    */ package com.prineside.tdi2.utils;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Pool;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.KryoSerializable;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ 
/*    */ @REGS
/*    */ public final class ObjectPair<F, S> implements Pool.Poolable, KryoSerializable {
/*    */   public F first;
/*    */   public S second;
/*    */   
/*    */   public ObjectPair() {}
/*    */   
/*    */   public ObjectPair(F paramF, S paramS) {
/* 17 */     this.first = paramF;
/* 18 */     this.second = paramS;
/*    */   }
/*    */   
/*    */   public final ObjectPair<F, S> set(F paramF, S paramS) {
/* 22 */     this.first = paramF;
/* 23 */     this.second = paramS;
/* 24 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void reset() {
/* 29 */     this.first = null;
/* 30 */     this.second = null;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void write(Kryo paramKryo, Output paramOutput) {
/* 35 */     paramKryo.writeClassAndObject(paramOutput, this.first);
/* 36 */     paramKryo.writeClassAndObject(paramOutput, this.second);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void read(Kryo paramKryo, Input paramInput) {
/* 41 */     this.first = (F)paramKryo.readClassAndObject(paramInput);
/* 42 */     this.second = (S)paramKryo.readClassAndObject(paramInput);
/*    */   }
/*    */ 
/*    */   
/*    */   public final String toString() {
/* 47 */     return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " {" + this.first + ", " + this.second + "}";
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\ObjectPair.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */