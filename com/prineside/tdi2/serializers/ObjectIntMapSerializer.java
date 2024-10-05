/*    */ package com.prineside.tdi2.serializers;
/*    */ 
/*    */ import com.badlogic.gdx.utils.ObjectIntMap;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.Serializer;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ 
/*    */ public class ObjectIntMapSerializer
/*    */   extends Serializer<ObjectIntMap> {
/*    */   public void write(Kryo paramKryo, Output paramOutput, ObjectIntMap paramObjectIntMap) {
/* 12 */     int i = paramObjectIntMap.size;
/* 13 */     paramOutput.writeVarInt(i, true);
/*    */     
/* 15 */     ObjectIntMap.Keys keys = paramObjectIntMap.keys();
/* 16 */     while (keys.hasNext) {
/* 17 */       Object object = keys.next();
/* 18 */       paramKryo.writeClassAndObject(paramOutput, object);
/* 19 */       paramOutput.writeVarInt(paramObjectIntMap.get(object, 0), false);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public ObjectIntMap read(Kryo paramKryo, Input paramInput, Class<? extends ObjectIntMap> paramClass) {
/* 25 */     int i = paramInput.readVarInt(true);
/* 26 */     ObjectIntMap objectIntMap = new ObjectIntMap(i);
/* 27 */     paramKryo.reference(objectIntMap);
/* 28 */     for (byte b = 0; b < i; b++) {
/* 29 */       Object object = paramKryo.readClassAndObject(paramInput);
/* 30 */       int j = paramInput.readVarInt(false);
/* 31 */       objectIntMap.put(object, j);
/*    */     } 
/* 33 */     return objectIntMap;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\serializers\ObjectIntMapSerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */