/*    */ package com.badlogic.gdx.utils.reflect;
/*    */ 
/*    */ import java.lang.reflect.Constructor;
/*    */ import java.lang.reflect.InvocationTargetException;
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
/*    */ public final class Constructor
/*    */ {
/*    */   private final Constructor constructor;
/*    */   
/*    */   Constructor(Constructor paramConstructor) {
/* 28 */     this.constructor = paramConstructor;
/*    */   }
/*    */ 
/*    */   
/*    */   public final Class[] getParameterTypes() {
/* 33 */     return this.constructor.getParameterTypes();
/*    */   }
/*    */ 
/*    */   
/*    */   public final Class getDeclaringClass() {
/* 38 */     return this.constructor.getDeclaringClass();
/*    */   }
/*    */   
/*    */   public final boolean isAccessible() {
/* 42 */     return this.constructor.isAccessible();
/*    */   }
/*    */   
/*    */   public final void setAccessible(boolean paramBoolean) {
/* 46 */     this.constructor.setAccessible(paramBoolean);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final Object newInstance(Object... paramVarArgs) {
/*    */     try {
/* 53 */       return this.constructor.newInstance(paramVarArgs);
/* 54 */     } catch (IllegalArgumentException illegalArgumentException) {
/* 55 */       throw new ReflectionException("Illegal argument(s) supplied to constructor for class: " + getDeclaringClass().getName(), illegalArgumentException);
/*    */     }
/* 57 */     catch (InstantiationException instantiationException) {
/* 58 */       throw new ReflectionException("Could not instantiate instance of class: " + getDeclaringClass().getName(), instantiationException);
/* 59 */     } catch (IllegalAccessException illegalAccessException) {
/* 60 */       throw new ReflectionException("Could not instantiate instance of class: " + getDeclaringClass().getName(), illegalAccessException);
/* 61 */     } catch (InvocationTargetException invocationTargetException) {
/* 62 */       throw new ReflectionException("Exception occurred in constructor for class: " + getDeclaringClass().getName(), invocationTargetException);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\reflect\Constructor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */