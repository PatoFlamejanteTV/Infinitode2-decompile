/*    */ package com.prineside.tdi2.serializers;
/*    */ 
/*    */ import com.badlogic.gdx.utils.FloatArray;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.Serializer;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ 
/*    */ public final class FloatArraySerializer
/*    */   extends Serializer<FloatArray> {
/*    */   public final void write(Kryo paramKryo, Output paramOutput, FloatArray paramFloatArray) {
/* 12 */     int i = paramFloatArray.size;
/* 13 */     paramOutput.writeBoolean(paramFloatArray.ordered);
/* 14 */     paramOutput.writeInt(i, true);
/* 15 */     if (i == 0) {
/*    */       return;
/*    */     }
/* 18 */     for (i = 0; i < paramFloatArray.size; i++) {
/* 19 */       paramOutput.writeFloat(paramFloatArray.items[i]);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public final FloatArray read(Kryo paramKryo, Input paramInput, Class<? extends FloatArray> paramClass) {
/*    */     try {
/* 26 */       boolean bool = paramInput.readBoolean();
/* 27 */       int i = paramInput.readInt(true);
/*    */       
/* 29 */       FloatArray floatArray = new FloatArray(bool, i);
/* 30 */       paramKryo.reference(floatArray);
/* 31 */       floatArray.ensureCapacity(i);
/* 32 */       for (byte b = 0; b < i; b++) {
/* 33 */         floatArray.add(paramInput.readFloat());
/*    */       }
/* 35 */       return floatArray;
/* 36 */     } catch (Exception exception) {
/* 37 */       throw new IllegalStateException("Can't create object instance", exception);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\serializers\FloatArraySerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */