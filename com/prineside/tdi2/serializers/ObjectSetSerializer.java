/*    */ package com.prineside.tdi2.serializers;
/*    */ 
/*    */ import com.badlogic.gdx.utils.ObjectSet;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.Serializer;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ 
/*    */ public final class ObjectSetSerializer
/*    */   extends Serializer<ObjectSet> {
/*    */   public final void write(Kryo paramKryo, Output paramOutput, ObjectSet paramObjectSet) {
/* 12 */     paramOutput.writeVarInt(paramObjectSet.size, true);
/* 13 */     ObjectSet.ObjectSetIterator objectSetIterator = paramObjectSet.iterator();
/* 14 */     while (objectSetIterator.hasNext) {
/* 15 */       paramKryo.writeClassAndObject(paramOutput, objectSetIterator.next());
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public final ObjectSet read(Kryo paramKryo, Input paramInput, Class<? extends ObjectSet> paramClass) {
/* 21 */     int i = paramInput.readVarInt(true);
/* 22 */     ObjectSet objectSet = new ObjectSet(i);
/* 23 */     paramKryo.reference(objectSet);
/* 24 */     for (byte b = 0; b < i; b++) {
/* 25 */       objectSet.add(paramKryo.readClassAndObject(paramInput));
/*    */     }
/* 27 */     return objectSet;
/*    */   }
/*    */ 
/*    */   
/*    */   public final ObjectSet copy(Kryo paramKryo, ObjectSet paramObjectSet) {
/*    */     ObjectSet objectSet;
/* 33 */     (objectSet = new ObjectSet(paramObjectSet.size)).addAll(paramObjectSet);
/* 34 */     return objectSet;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\serializers\ObjectSetSerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */