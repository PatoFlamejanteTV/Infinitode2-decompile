/*    */ package com.prineside.tdi2.serializers;
/*    */ 
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.Serializer;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import java.lang.ref.WeakReference;
/*    */ 
/*    */ public final class WeakReferenceSerializer
/*    */   extends Serializer<WeakReference> {
/*    */   public final void write(Kryo paramKryo, Output paramOutput, WeakReference paramWeakReference) {
/* 12 */     paramOutput.position();
/* 13 */     paramKryo.writeClassAndObject(paramOutput, paramWeakReference.get());
/*    */   }
/*    */ 
/*    */   
/*    */   public final WeakReference read(Kryo paramKryo, Input paramInput, Class<? extends WeakReference> paramClass) {
/* 18 */     paramInput.position();
/* 19 */     Object object = paramKryo.readClassAndObject(paramInput);
/* 20 */     return new WeakReference(object);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\serializers\WeakReferenceSerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */