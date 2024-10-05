/*    */ package com.prineside.tdi2.managers.preferences.categories.settings;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Null;
/*    */ import com.prineside.tdi2.managers.preferences.PrefMap;
/*    */ import com.prineside.tdi2.managers.preferences.PrefSubcategory;
/*    */ 
/*    */ public final class SP_Locale implements PrefSubcategory {
/*    */   @Null
/*    */   public String localeName;
/*    */   
/*    */   public final void load(PrefMap paramPrefMap) {
/* 12 */     this.localeName = paramPrefMap.get("locale", null);
/*    */   }
/*    */ 
/*    */   
/*    */   public final synchronized void save(PrefMap paramPrefMap) {
/* 17 */     paramPrefMap.set("locale", this.localeName);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\preferences\categories\settings\SP_Locale.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */