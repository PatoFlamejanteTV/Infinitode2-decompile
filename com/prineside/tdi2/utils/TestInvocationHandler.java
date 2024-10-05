/*    */ package com.prineside.tdi2.utils;
/*    */ 
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.KryoSerializable;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import java.io.Serializable;
/*    */ import java.lang.reflect.InvocationHandler;
/*    */ import java.lang.reflect.Method;
/*    */ 
/*    */ @REGS
/*    */ public class TestInvocationHandler
/*    */   implements KryoSerializable, Serializable, InvocationHandler {
/* 14 */   public Object[] arr = new Object[1];
/*    */ 
/*    */   
/*    */   public void write(Kryo paramKryo, Output paramOutput) {
/* 18 */     paramKryo.writeObject(paramOutput, this.arr);
/*    */   }
/*    */ 
/*    */   
/*    */   public void read(Kryo paramKryo, Input paramInput) {
/* 23 */     this.arr = (Object[])paramKryo.readObject(paramInput, Object[].class);
/*    */   }
/*    */ 
/*    */   
/*    */   public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject) {
/* 28 */     if ("toString".equals(paramMethod.getName())) {
/* 29 */       return "TestInvocationHandler";
/*    */     }
/* 31 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\TestInvocationHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */