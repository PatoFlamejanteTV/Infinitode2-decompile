/*    */ package com.badlogic.gdx.utils.reflect;
/*    */ 
/*    */ import java.lang.reflect.Array;
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
/*    */ public final class ArrayReflection
/*    */ {
/*    */   public static Object newInstance(Class<?> paramClass, int paramInt) {
/* 25 */     return Array.newInstance(paramClass, paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   public static int getLength(Object paramObject) {
/* 30 */     return Array.getLength(paramObject);
/*    */   }
/*    */ 
/*    */   
/*    */   public static Object get(Object paramObject, int paramInt) {
/* 35 */     return Array.get(paramObject, paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void set(Object paramObject1, int paramInt, Object paramObject2) {
/* 40 */     Array.set(paramObject1, paramInt, paramObject2);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\reflect\ArrayReflection.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */