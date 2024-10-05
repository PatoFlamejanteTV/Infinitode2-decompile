/*    */ package com.prineside.tdi2.serializers;
/*    */ 
/*    */ import com.badlogic.gdx.math.RandomXS128;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.Serializer;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ 
/*    */ public final class RandomXS128Serializer extends Serializer<RandomXS128> {
/*    */   public RandomXS128Serializer() {
/* 11 */     setAcceptsNull(true);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void write(Kryo paramKryo, Output paramOutput, RandomXS128 paramRandomXS128) {
/* 16 */     paramOutput.writeLong(paramRandomXS128.getState(0));
/* 17 */     paramOutput.writeLong(paramRandomXS128.getState(1));
/*    */   }
/*    */ 
/*    */   
/*    */   public final RandomXS128 read(Kryo paramKryo, Input paramInput, Class<? extends RandomXS128> paramClass) {
/* 22 */     long l1 = paramInput.readLong();
/* 23 */     long l2 = paramInput.readLong();
/* 24 */     RandomXS128 randomXS128 = new RandomXS128(l1, l2);
/* 25 */     paramKryo.reference(randomXS128);
/* 26 */     return randomXS128;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\serializers\RandomXS128Serializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */