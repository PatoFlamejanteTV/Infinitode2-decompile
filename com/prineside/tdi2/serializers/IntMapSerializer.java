/*    */ package com.prineside.tdi2.serializers;
/*    */ 
/*    */ import com.badlogic.gdx.utils.IntIntMap;
/*    */ import com.badlogic.gdx.utils.IntMap;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.Serializer;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ 
/*    */ public final class IntMapSerializer
/*    */   extends Serializer<IntMap> {
/*    */   static {
/*    */     (paramEntry1, paramEntry2) -> Integer.compare(paramEntry1.key, paramEntry2.key);
/*    */   }
/*    */   
/*    */   public final void write(Kryo paramKryo, Output paramOutput, IntMap paramIntMap) {
/* 17 */     int i = paramIntMap.size;
/* 18 */     paramOutput.writeVarInt(i, true);
/*    */     
/* 20 */     IntMap.Keys keys = paramIntMap.keys();
/* 21 */     while (keys.hasNext) {
/* 22 */       int j = keys.next();
/* 23 */       paramOutput.writeInt(j);
/* 24 */       paramKryo.writeClassAndObject(paramOutput, paramIntMap.get(j));
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public final IntMap read(Kryo paramKryo, Input paramInput, Class<? extends IntMap> paramClass) {
/* 30 */     int i = paramInput.readVarInt(true);
/* 31 */     IntMap intMap = new IntMap(i);
/* 32 */     paramKryo.reference(intMap);
/* 33 */     for (byte b = 0; b < i; b++) {
/* 34 */       int j = paramInput.readInt();
/* 35 */       Object object = paramKryo.readClassAndObject(paramInput);
/* 36 */       intMap.put(j, object);
/*    */     } 
/* 38 */     return intMap;
/*    */   }
/*    */ 
/*    */   
/*    */   public final IntMap copy(Kryo paramKryo, IntMap paramIntMap) {
/* 43 */     IntMap intMap = new IntMap(paramIntMap.size);
/* 44 */     paramKryo.reference(intMap);
/* 45 */     intMap.putAll(paramIntMap);
/* 46 */     return intMap;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\serializers\IntMapSerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */