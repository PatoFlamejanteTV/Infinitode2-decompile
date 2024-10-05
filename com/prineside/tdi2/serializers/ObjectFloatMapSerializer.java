/*    */ package com.prineside.tdi2.serializers;
/*    */ 
/*    */ import com.badlogic.gdx.utils.ObjectFloatMap;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.Serializer;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ 
/*    */ public class ObjectFloatMapSerializer
/*    */   extends Serializer<ObjectFloatMap> {
/*    */   public void write(Kryo paramKryo, Output paramOutput, ObjectFloatMap paramObjectFloatMap) {
/* 12 */     int i = paramObjectFloatMap.size;
/* 13 */     paramOutput.writeVarInt(i, true);
/*    */     
/* 15 */     ObjectFloatMap.Keys keys = paramObjectFloatMap.keys();
/* 16 */     while (keys.hasNext) {
/* 17 */       Object object = keys.next();
/* 18 */       paramKryo.writeClassAndObject(paramOutput, object);
/* 19 */       paramOutput.writeFloat(paramObjectFloatMap.get(object, 0.0F));
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public ObjectFloatMap read(Kryo paramKryo, Input paramInput, Class<? extends ObjectFloatMap> paramClass) {
/* 25 */     int i = paramInput.readVarInt(true);
/* 26 */     ObjectFloatMap objectFloatMap = new ObjectFloatMap(i);
/* 27 */     paramKryo.reference(objectFloatMap);
/* 28 */     for (byte b = 0; b < i; b++) {
/* 29 */       Object object = paramKryo.readClassAndObject(paramInput);
/* 30 */       float f = paramInput.readFloat();
/* 31 */       objectFloatMap.put(object, f);
/*    */     } 
/* 33 */     return objectFloatMap;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\serializers\ObjectFloatMapSerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */