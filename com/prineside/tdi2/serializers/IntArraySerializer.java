/*    */ package com.prineside.tdi2.serializers;
/*    */ 
/*    */ import com.badlogic.gdx.utils.IntArray;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.Serializer;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ 
/*    */ public final class IntArraySerializer
/*    */   extends Serializer<IntArray> {
/*    */   public final void write(Kryo paramKryo, Output paramOutput, IntArray paramIntArray) {
/* 12 */     int i = paramIntArray.size;
/* 13 */     paramOutput.writeInt(i, true);
/* 14 */     if (i == 0) {
/*    */       return;
/*    */     }
/* 17 */     for (i = 0; i < paramIntArray.size; i++) {
/* 18 */       paramOutput.writeVarInt(paramIntArray.items[i], false);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public final IntArray read(Kryo paramKryo, Input paramInput, Class<? extends IntArray> paramClass) {
/*    */     try {
/* 25 */       IntArray intArray = new IntArray();
/* 26 */       paramKryo.reference(intArray);
/* 27 */       int i = paramInput.readInt(true);
/* 28 */       intArray.ensureCapacity(i);
/* 29 */       for (byte b = 0; b < i; b++) {
/* 30 */         intArray.add(paramInput.readVarInt(false));
/*    */       }
/* 32 */       return intArray;
/* 33 */     } catch (Exception exception) {
/* 34 */       throw new IllegalStateException("Can't create object instance", exception);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\serializers\IntArraySerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */