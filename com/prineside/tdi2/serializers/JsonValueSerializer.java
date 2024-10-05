/*    */ package com.prineside.tdi2.serializers;
/*    */ 
/*    */ import com.badlogic.gdx.utils.JsonReader;
/*    */ import com.badlogic.gdx.utils.JsonValue;
/*    */ import com.badlogic.gdx.utils.JsonWriter;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.Serializer;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ 
/*    */ public final class JsonValueSerializer extends Serializer<JsonValue> {
/*    */   public JsonValueSerializer() {
/* 13 */     setAcceptsNull(true);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void write(Kryo paramKryo, Output paramOutput, JsonValue paramJsonValue) {
/* 18 */     paramOutput.writeString(paramJsonValue.toJson(JsonWriter.OutputType.minimal));
/*    */   }
/*    */ 
/*    */   
/*    */   public final JsonValue read(Kryo paramKryo, Input paramInput, Class<? extends JsonValue> paramClass) {
/* 23 */     return (new JsonReader()).parse(paramInput.readString());
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\serializers\JsonValueSerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */