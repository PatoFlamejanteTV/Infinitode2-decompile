/*    */ package com.prineside.tdi2.serializers;
/*    */ 
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.Serializer;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ 
/*    */ public abstract class SingletonSerializer<T>
/*    */   extends Serializer<T>
/*    */ {
/*    */   public SingletonSerializer() {
/* 12 */     setImmutable(true);
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(Kryo paramKryo, Output paramOutput, T paramT) {}
/*    */ 
/*    */   
/*    */   public T read(Kryo paramKryo, Input paramInput, Class<? extends T> paramClass) {
/* 20 */     return read();
/*    */   }
/*    */   
/*    */   public abstract T read();
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\serializers\SingletonSerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */