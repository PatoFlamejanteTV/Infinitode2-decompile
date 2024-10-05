/*    */ package com.prineside.tdi2;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g2d.Batch;
/*    */ import com.badlogic.gdx.utils.Disposable;
/*    */ import com.badlogic.gdx.utils.Pool;
/*    */ 
/*    */ public abstract class Shape
/*    */   implements Pool.Poolable
/*    */ {
/*    */   public abstract void draw(Batch paramBatch);
/*    */   
/*    */   public static abstract class Factory<T extends Shape>
/*    */     implements Disposable {
/* 14 */     private Pool<T> a = new Pool<T>(this, 1, 512)
/*    */       {
/*    */         private T a() {
/* 17 */           return this.a.a();
/*    */         }
/*    */       };
/*    */ 
/*    */     
/*    */     public abstract void setup();
/*    */     
/*    */     protected abstract T a();
/*    */     
/*    */     public final T obtain() {
/* 27 */       return (T)this.a.obtain();
/*    */     }
/*    */     
/*    */     public void free(T param1T) {
/* 31 */       this.a.free(param1T);
/*    */     }
/*    */     
/*    */     public void dispose() {}
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\Shape.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */