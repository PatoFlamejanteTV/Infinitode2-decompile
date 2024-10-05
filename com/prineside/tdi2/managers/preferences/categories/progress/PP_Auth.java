/*    */ package com.prineside.tdi2.managers.preferences.categories.progress;
/*    */ import com.badlogic.gdx.utils.Null;
/*    */ import com.prineside.tdi2.managers.preferences.PrefMap;
/*    */ import com.prineside.tdi2.managers.preferences.PrefSubcategory;
/*    */ 
/*    */ public final class PP_Auth implements PrefSubcategory {
/*    */   @Null
/*    */   private String a;
/*    */   
/*    */   @Null
/*    */   public final String getProgressOwnerId() {
/* 12 */     return this.a;
/*    */   } @Null
/*    */   private String b;
/*    */   public final synchronized void setProgressOwnerId(@Null String paramString) {
/* 16 */     this.a = paramString;
/*    */   }
/*    */   @Null
/*    */   public final String getProgressOwnerNickname() {
/* 20 */     return this.b;
/*    */   }
/*    */   
/*    */   public final synchronized void setProgressOwnerNickname(@Null String paramString) {
/* 24 */     this.b = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public final synchronized void load(PrefMap paramPrefMap) {
/* 29 */     this.a = paramPrefMap.get("authProgressOwnerId", null);
/* 30 */     this.b = paramPrefMap.get("authProgressOwnerNickname", null);
/*    */   }
/*    */ 
/*    */   
/*    */   public final synchronized void save(PrefMap paramPrefMap) {
/* 35 */     paramPrefMap.set("authProgressOwnerId", this.a);
/* 36 */     paramPrefMap.set("authProgressOwnerNickname", this.b);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\preferences\categories\progress\PP_Auth.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */