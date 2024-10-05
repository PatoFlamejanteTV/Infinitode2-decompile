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
/*    */ public abstract class FlushablePool<T>
/*    */   extends Pool<T>
/*    */ {
/* 23 */   protected Array<T> obtained = new Array<>();
/*    */ 
/*    */   
/*    */   public FlushablePool() {}
/*    */ 
/*    */   
/*    */   public FlushablePool(int paramInt) {
/* 30 */     super(paramInt);
/*    */   }
/*    */   
/*    */   public FlushablePool(int paramInt1, int paramInt2) {
/* 34 */     super(paramInt1, paramInt2);
/*    */   }
/*    */ 
/*    */   
/*    */   public T obtain() {
/* 39 */     T t = super.obtain();
/* 40 */     this.obtained.add(t);
/* 41 */     return t;
/*    */   }
/*    */ 
/*    */   
/*    */   public void flush() {
/* 46 */     super.freeAll(this.obtained);
/* 47 */     this.obtained.clear();
/*    */   }
/*    */ 
/*    */   
/*    */   public void free(T paramT) {
/* 52 */     this.obtained.removeValue(paramT, true);
/* 53 */     super.free(paramT);
/*    */   }
/*    */ 
/*    */   
/*    */   public void freeAll(Array<T> paramArray) {
/* 58 */     this.obtained.removeAll(paramArray, true);
/* 59 */     super.freeAll(paramArray);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\FlushablePool.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */