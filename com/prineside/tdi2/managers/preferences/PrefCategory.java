/*    */ package com.prineside.tdi2.managers.preferences;
/*    */ 
/*    */ import com.prineside.tdi2.utils.ObjectConsumer;
/*    */ 
/*    */ public abstract class PrefCategory
/*    */ {
/*    */   private boolean a;
/*    */   
/*    */   public abstract void load(PrefMap paramPrefMap);
/*    */   
/*    */   public abstract void save(PrefMap paramPrefMap);
/*    */   
/*    */   public abstract void saveAsync(PrefMap paramPrefMap, Runnable paramRunnable, ObjectConsumer<Exception> paramObjectConsumer);
/*    */   
/*    */   public void requireSave() {
/* 16 */     this.a = true;
/*    */   }
/*    */   
/*    */   public void setSaveRequired(boolean paramBoolean) {
/* 20 */     this.a = paramBoolean;
/*    */   }
/*    */   
/*    */   public boolean isSaveRequired() {
/* 24 */     return this.a;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\preferences\PrefCategory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */