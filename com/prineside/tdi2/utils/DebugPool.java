/*    */ package com.prineside.tdi2.utils;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.badlogic.gdx.utils.Pool;
/*    */ import java.lang.reflect.Field;
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class DebugPool<T>
/*    */   extends Pool<T>
/*    */ {
/*    */   public DebugPool(int paramInt1, int paramInt2) {
/* 13 */     super(paramInt1, paramInt2);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public T obtain() {
/*    */     Object object;
/* 21 */     return (T)(object = super.obtain());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void free(T paramT) {
/*    */     try {
/*    */       Field field;
/* 29 */       (field = Pool.class.getDeclaredField("freeObjects")).setAccessible(true);
/* 30 */       Array array = (Array)field.get(this);
/* 31 */       for (byte b = 0; b < array.size; b++) {
/* 32 */         if (array.get(b) == paramT) {
/* 33 */           throw new IllegalArgumentException("Object is already freed: " + paramT);
/*    */         }
/*    */       } 
/* 36 */     } catch (NoSuchFieldException noSuchFieldException2) {
/* 37 */       NoSuchFieldException noSuchFieldException1; (noSuchFieldException1 = null).printStackTrace();
/* 38 */     } catch (IllegalAccessException illegalAccessException2) {
/* 39 */       IllegalAccessException illegalAccessException1; (illegalAccessException1 = null).printStackTrace();
/*    */     } 
/*    */     
/* 42 */     super.free(paramT);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\DebugPool.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */