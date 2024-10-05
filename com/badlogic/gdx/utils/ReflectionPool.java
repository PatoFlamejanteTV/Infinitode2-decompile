/*    */ package com.badlogic.gdx.utils;
/*    */ 
/*    */ import com.badlogic.gdx.utils.reflect.ClassReflection;
/*    */ import com.badlogic.gdx.utils.reflect.Constructor;
/*    */ import com.badlogic.gdx.utils.reflect.ReflectionException;
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
/*    */ public class ReflectionPool<T>
/*    */   extends Pool<T>
/*    */ {
/*    */   private final Constructor constructor;
/*    */   
/*    */   public ReflectionPool(Class<T> paramClass) {
/* 30 */     this(paramClass, 16, 2147483647);
/*    */   }
/*    */   
/*    */   public ReflectionPool(Class<T> paramClass, int paramInt) {
/* 34 */     this(paramClass, paramInt, 2147483647);
/*    */   }
/*    */   
/*    */   public ReflectionPool(Class<T> paramClass, int paramInt1, int paramInt2) {
/* 38 */     super(paramInt1, paramInt2);
/* 39 */     this.constructor = findConstructor(paramClass);
/* 40 */     if (this.constructor == null)
/* 41 */       throw new RuntimeException("Class cannot be created (missing no-arg constructor): " + paramClass.getName()); 
/*    */   }
/*    */   @Null
/*    */   private Constructor findConstructor(Class<T> paramClass) {
/*    */     try {
/* 46 */       return ClassReflection.getConstructor(paramClass, (Class[])null);
/* 47 */     } catch (Exception exception) {
/*    */       try {
/*    */         Constructor constructor;
/* 50 */         (constructor = ClassReflection.getDeclaredConstructor(paramClass, (Class[])null)).setAccessible(true);
/* 51 */         return constructor;
/* 52 */       } catch (ReflectionException reflectionException) {
/* 53 */         return null;
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   protected T newObject() {
/*    */     try {
/* 60 */       return (T)this.constructor.newInstance((Object[])null);
/* 61 */     } catch (Exception exception) {
/* 62 */       throw new GdxRuntimeException("Unable to create new instance: " + this.constructor.getDeclaringClass().getName(), exception);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\ReflectionPool.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */