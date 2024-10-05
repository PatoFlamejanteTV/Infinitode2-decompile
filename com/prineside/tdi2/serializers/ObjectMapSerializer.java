/*    */ package com.prineside.tdi2.serializers;
/*    */ 
/*    */ import com.badlogic.gdx.utils.ObjectMap;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.Serializer;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ 
/*    */ public final class ObjectMapSerializer
/*    */   extends Serializer<ObjectMap> {
/*    */   public final void write(Kryo paramKryo, Output paramOutput, ObjectMap paramObjectMap) {
/* 12 */     int i = paramObjectMap.size;
/* 13 */     paramOutput.writeVarInt(i, true);
/*    */     
/* 15 */     ObjectMap.Keys keys = paramObjectMap.keys();
/* 16 */     while (keys.hasNext) {
/* 17 */       Object object = keys.next();
/* 18 */       paramKryo.writeClassAndObject(paramOutput, object);
/* 19 */       paramKryo.writeClassAndObject(paramOutput, paramObjectMap.get(object));
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public final ObjectMap read(Kryo paramKryo, Input paramInput, Class<? extends ObjectMap> paramClass) {
/* 25 */     int i = paramInput.readVarInt(true);
/* 26 */     ObjectMap objectMap = new ObjectMap(i);
/* 27 */     paramKryo.reference(objectMap);
/* 28 */     for (byte b = 0; b < i; b++) {
/* 29 */       Object object1 = paramKryo.readClassAndObject(paramInput);
/* 30 */       Object object2 = paramKryo.readClassAndObject(paramInput);
/* 31 */       objectMap.put(object1, object2);
/*    */     } 
/* 33 */     return objectMap;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\serializers\ObjectMapSerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */