/*    */ package com.badlogic.gdx.utils;
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
/*    */ public class Pools
/*    */ {
/* 22 */   private static final ObjectMap<Class, Pool> typePools = new ObjectMap<>();
/*    */ 
/*    */ 
/*    */   
/*    */   public static <T> Pool<T> get(Class<T> paramClass, int paramInt) {
/*    */     Pool<T> pool;
/* 28 */     if ((pool = typePools.<Class>get((Class)paramClass)) == null) {
/* 29 */       pool = new ReflectionPool<>(paramClass, 4, paramInt);
/* 30 */       typePools.put(paramClass, pool);
/*    */     } 
/* 32 */     return pool;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static <T> Pool<T> get(Class<T> paramClass) {
/* 38 */     return get(paramClass, 100);
/*    */   }
/*    */ 
/*    */   
/*    */   public static <T> void set(Class<T> paramClass, Pool<T> paramPool) {
/* 43 */     typePools.put(paramClass, paramPool);
/*    */   }
/*    */ 
/*    */   
/*    */   public static <T> T obtain(Class<T> paramClass) {
/* 48 */     return get(paramClass).obtain();
/*    */   }
/*    */ 
/*    */   
/*    */   public static void free(Object paramObject) {
/* 53 */     if (paramObject == null) throw new IllegalArgumentException("object cannot be null."); 
/*    */     Pool<Object> pool;
/* 55 */     if ((pool = typePools.<Class>get(paramObject.getClass())) == null)
/* 56 */       return;  pool.free(paramObject);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void freeAll(Array paramArray) {
/* 62 */     freeAll(paramArray, false);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void freeAll(Array<Object> paramArray, boolean paramBoolean) {
/* 68 */     if (paramArray == null) throw new IllegalArgumentException("objects cannot be null."); 
/* 69 */     Pool pool = null; byte b; int i;
/* 70 */     for (b = 0, i = paramArray.size; b < i; b++) {
/*    */       Object object;
/* 72 */       if ((object = paramArray.get(b)) != null && (
/* 73 */         pool != null || (
/*    */         
/* 75 */         pool = typePools.<Class>get(object.getClass())) != null)) {
/*    */         
/* 77 */         pool.free(object);
/* 78 */         if (!paramBoolean) pool = null; 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\Pools.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */