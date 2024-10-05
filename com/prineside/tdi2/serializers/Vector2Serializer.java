/*    */ package com.prineside.tdi2.serializers;
/*    */ 
/*    */ import com.badlogic.gdx.math.Vector2;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.Serializer;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ 
/*    */ public final class Vector2Serializer extends Serializer<Vector2> {
/*    */   public Vector2Serializer() {
/* 11 */     setAcceptsNull(true);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void write(Kryo paramKryo, Output paramOutput, Vector2 paramVector2) {
/* 16 */     paramOutput.writeFloat(paramVector2.x);
/* 17 */     paramOutput.writeFloat(paramVector2.y);
/*    */   }
/*    */ 
/*    */   
/*    */   public final Vector2 read(Kryo paramKryo, Input paramInput, Class<? extends Vector2> paramClass) {
/* 22 */     return new Vector2(paramInput.readFloat(), paramInput.readFloat());
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\serializers\Vector2Serializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */