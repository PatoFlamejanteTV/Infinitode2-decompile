/*    */ package com.prineside.tdi2.serializers;
/*    */ 
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.Serializer;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import java.lang.reflect.InvocationHandler;
/*    */ import java.lang.reflect.Proxy;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class ProxySerializer
/*    */   extends Serializer<Object>
/*    */ {
/*    */   public final void write(Kryo paramKryo, Output paramOutput, Object paramObject) {
/* 35 */     paramKryo.writeClassAndObject(paramOutput, Proxy.getInvocationHandler(paramObject));
/* 36 */     paramKryo.writeObject(paramOutput, paramObject.getClass().getInterfaces());
/*    */   }
/*    */ 
/*    */   
/*    */   public final Object read(Kryo paramKryo, Input paramInput, Class paramClass) {
/* 41 */     InvocationHandler invocationHandler = (InvocationHandler)paramKryo.readClassAndObject(paramInput);
/* 42 */     Class[] arrayOfClass = (Class[])paramKryo.readObject(paramInput, Class[].class);
/*    */     ClassLoader classLoader;
/* 44 */     return Proxy.newProxyInstance(classLoader = paramKryo.getClassLoader(), arrayOfClass, invocationHandler);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\serializers\ProxySerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */