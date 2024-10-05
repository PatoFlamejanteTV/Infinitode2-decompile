/*    */ package com.prineside.tdi2;
/*    */ 
/*    */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*    */ import com.badlogic.gdx.utils.Disposable;
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
/*    */ public interface Manager
/*    */   extends Disposable
/*    */ {
/*    */   void setup();
/*    */   
/*    */   void preRender(float paramFloat);
/*    */   
/*    */   void postRender(float paramFloat);
/*    */   
/*    */   void test();
/*    */   
/*    */   public static abstract class ManagerAdapter
/*    */     implements Manager
/*    */   {
/*    */     public void setup() {}
/*    */     
/*    */     public void preRender(float param1Float) {}
/*    */     
/*    */     public void postRender(float param1Float) {}
/*    */     
/*    */     public void test() {}
/*    */     
/*    */     public void dispose() {}
/*    */   }
/*    */   
/*    */   public static abstract class ManagerWithListeners<T>
/*    */     implements Manager
/*    */   {
/* 46 */     protected final DelayedRemovalArray<T> a = new DelayedRemovalArray();
/*    */     
/*    */     public void addListener(T param1T) {
/* 49 */       if (param1T == null) {
/* 50 */         throw new IllegalArgumentException("listener is null");
/*    */       }
/*    */       
/* 53 */       if (!this.a.contains(param1T, true)) {
/* 54 */         this.a.add(param1T);
/*    */       }
/*    */     }
/*    */     
/*    */     public void removeListener(T param1T) {
/* 59 */       if (param1T == null) {
/* 60 */         throw new IllegalArgumentException("listener is null");
/*    */       }
/*    */       
/* 63 */       this.a.removeValue(param1T, true);
/*    */     }
/*    */     
/*    */     public void setup() {}
/*    */     
/*    */     public void preRender(float param1Float) {}
/*    */     
/*    */     public void postRender(float param1Float) {}
/*    */     
/*    */     public void test() {}
/*    */     
/*    */     public void dispose() {}
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\Manager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */