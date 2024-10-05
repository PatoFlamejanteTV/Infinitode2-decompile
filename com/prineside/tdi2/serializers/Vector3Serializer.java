/*    */ package com.prineside.tdi2.serializers;
/*    */ 
/*    */ import com.badlogic.gdx.math.Vector3;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.Serializer;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ 
/*    */ public final class Vector3Serializer extends Serializer<Vector3> {
/*    */   public Vector3Serializer() {
/* 11 */     setAcceptsNull(true);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void write(Kryo paramKryo, Output paramOutput, Vector3 paramVector3) {
/* 16 */     paramOutput.writeFloat(paramVector3.x);
/* 17 */     paramOutput.writeFloat(paramVector3.y);
/* 18 */     paramOutput.writeFloat(paramVector3.z);
/*    */   }
/*    */ 
/*    */   
/*    */   public final Vector3 read(Kryo paramKryo, Input paramInput, Class<? extends Vector3> paramClass) {
/* 23 */     return new Vector3(paramInput.readFloat(), paramInput.readFloat(), paramInput.readFloat());
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\serializers\Vector3Serializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */