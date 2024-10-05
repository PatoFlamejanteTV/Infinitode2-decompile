/*    */ package com.prineside.tdi2.managers.preferences.categories.settings;
/*    */ 
/*    */ import com.badlogic.gdx.utils.ObjectSet;
/*    */ import com.prineside.tdi2.enums.EnemyType;
/*    */ import com.prineside.tdi2.managers.preferences.PrefMap;
/*    */ import com.prineside.tdi2.managers.preferences.PrefSubcategory;
/*    */ 
/*    */ public final class SP_Enemy implements PrefSubcategory {
/*  9 */   public final ObjectSet<EnemyType> enemiesMetWith = new ObjectSet();
/*    */ 
/*    */   
/*    */   public final void load(PrefMap paramPrefMap) {
/* 13 */     this.enemiesMetWith.clear();
/* 14 */     String str = paramPrefMap.get("enemyTypesMetWithCrossProgress", null);
/*    */     try {
/* 16 */       if (str != null) {
/*    */         String[] arrayOfString; int i;
/*    */         byte b;
/* 19 */         for (i = (arrayOfString = arrayOfString = str.split(",")).length, b = 0; b < i; b++) {
/* 20 */           String str1; if ((str1 = arrayOfString[b]).length() != 0)
/* 21 */             this.enemiesMetWith.add(EnemyType.valueOf(str1)); 
/*    */         } 
/*    */       }  return;
/* 24 */     } catch (Exception exception) {
/*    */       return;
/*    */     } 
/*    */   }
/*    */   public final synchronized void save(PrefMap paramPrefMap) {
/* 29 */     if (this.enemiesMetWith.size != 0) {
/* 30 */       StringBuilder stringBuilder = new StringBuilder();
/* 31 */       byte b = 0;
/* 32 */       for (ObjectSet.ObjectSetIterator<EnemyType> objectSetIterator = this.enemiesMetWith.iterator(); objectSetIterator.hasNext(); ) { EnemyType enemyType = objectSetIterator.next();
/* 33 */         stringBuilder.append(enemyType.name());
/* 34 */         b++;
/* 35 */         if (b != this.enemiesMetWith.size) {
/* 36 */           stringBuilder.append(",");
/*    */         } }
/*    */       
/* 39 */       paramPrefMap.set("enemyTypesMetWithCrossProgress", stringBuilder.toString());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\preferences\categories\settings\SP_Enemy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */