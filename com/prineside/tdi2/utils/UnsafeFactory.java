/*    */ package com.prineside.tdi2.utils;
/*    */ 
/*    */ import java.lang.reflect.Constructor;
/*    */ import java.lang.reflect.Field;
/*    */ import sun.misc.Unsafe;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class UnsafeFactory
/*    */ {
/*    */   public static final Unsafe INSTANCE;
/*    */   
/*    */   static {
/*    */     try {
/*    */       Constructor<Unsafe> constructor;
/* 17 */       (constructor = Unsafe.class.getDeclaredConstructor(new Class[0])).setAccessible(true);
/* 18 */       Unsafe unsafe = constructor.newInstance(new Object[0]);
/* 19 */     } catch (InstantiationException|IllegalAccessException|java.lang.reflect.InvocationTargetException|NoSuchMethodException instantiationException) {
/*    */       try {
/*    */         Field field;
/*    */ 
/*    */         
/* 24 */         (field = Unsafe.class.getDeclaredField("theUnsafe")).setAccessible(true);
/* 25 */         Unsafe unsafe = (Unsafe)field.get(null);
/* 26 */       } catch (Exception exception) {
/* 27 */         System.err.println("Failed to obtain Unsafe");
/* 28 */         instantiationException.printStackTrace();
/* 29 */         exception.printStackTrace();
/* 30 */         exception = null;
/*    */       } 
/*    */     } 
/* 33 */     INSTANCE = (Unsafe)exception;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\UnsafeFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */