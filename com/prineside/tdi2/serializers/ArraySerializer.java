/*    */ package com.prineside.tdi2.serializers;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.Serializer;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ 
/*    */ public final class ArraySerializer<T extends Array> extends Serializer<T> {
/*    */   public ArraySerializer() {
/* 11 */     setAcceptsNull(true);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void write(Kryo paramKryo, Output paramOutput, T paramT) {
/* 16 */     paramOutput.writeInt(((Array)paramT).size, true);
/* 17 */     paramOutput.writeBoolean(((Array)paramT).ordered);
/* 18 */     paramKryo.writeClass(paramOutput, ((Array)paramT).items.getClass().getComponentType());
/*    */     
/* 20 */     for (byte b = 0; b < ((Array)paramT).size; b++) {
/* 21 */       paramKryo.writeClassAndObject(paramOutput, ((Array)paramT).items[b]);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public final T read(Kryo paramKryo, Input paramInput, Class<? extends T> paramClass) {
/*    */     try {
/* 28 */       int i = paramInput.readInt(true);
/* 29 */       boolean bool = paramInput.readBoolean();
/*    */       
/* 31 */       Class clazz = paramKryo.readClass(paramInput).getType();
/* 32 */       Array array = paramClass.getConstructor(new Class[] { boolean.class, int.class, Class.class }).newInstance(new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), clazz });
/* 33 */       paramKryo.reference(array);
/* 34 */       array.ensureCapacity(i);
/* 35 */       for (bool = false; bool < i; bool++) {
/* 36 */         array.add(paramKryo.readClassAndObject(paramInput));
/*    */       }
/* 38 */       return (T)array;
/* 39 */     } catch (Exception exception) {
/* 40 */       throw new IllegalStateException("Can't create object instance", exception);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\serializers\ArraySerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */