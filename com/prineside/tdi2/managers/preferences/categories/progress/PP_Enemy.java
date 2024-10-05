/*    */ package com.prineside.tdi2.managers.preferences.categories.progress;
/*    */ 
/*    */ import com.badlogic.gdx.utils.ObjectSet;
/*    */ import com.prineside.tdi2.enums.EnemyType;
/*    */ import com.prineside.tdi2.managers.preferences.PrefMap;
/*    */ import com.prineside.tdi2.managers.preferences.PrefSubcategory;
/*    */ import com.prineside.tdi2.utils.logging.TLog;
/*    */ 
/*    */ public final class PP_Enemy implements PrefSubcategory {
/* 10 */   private static final TLog a = TLog.forClass(PP_Enemy.class);
/*    */   
/* 12 */   private final ObjectSet<EnemyType> b = new ObjectSet();
/*    */   
/*    */   public final boolean isEnemyMetWith(EnemyType paramEnemyType) {
/* 15 */     return this.b.contains(paramEnemyType);
/*    */   }
/*    */   
/*    */   public final synchronized void setEnemyMetWith(EnemyType paramEnemyType, boolean paramBoolean) {
/* 19 */     if (paramBoolean) {
/* 20 */       this.b.add(paramEnemyType); return;
/*    */     } 
/* 22 */     this.b.remove(paramEnemyType);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final synchronized void load(PrefMap paramPrefMap) {
/* 29 */     this.b.clear();
/* 30 */     String str = paramPrefMap.get("enemyTypesMetWith", null);
/*    */     try {
/* 32 */       if (str != null) {
/*    */         String[] arrayOfString; int i;
/*    */         byte b;
/* 35 */         for (i = (arrayOfString = arrayOfString = str.split(",")).length, b = 0; b < i; b++) {
/* 36 */           String str1; if ((str1 = arrayOfString[b]).length() != 0)
/* 37 */             this.b.add(EnemyType.valueOf(str1)); 
/*    */         } 
/*    */       }  return;
/* 40 */     } catch (Exception exception) {
/* 41 */       a.e("Failed loading info about enemy types met with: " + str, new Object[] { exception });
/*    */       return;
/*    */     } 
/*    */   }
/*    */   
/*    */   public final synchronized void save(PrefMap paramPrefMap) {
/* 47 */     if (this.b.size != 0) {
/* 48 */       StringBuilder stringBuilder = new StringBuilder();
/* 49 */       byte b = 0;
/* 50 */       for (ObjectSet.ObjectSetIterator<EnemyType> objectSetIterator = this.b.iterator(); objectSetIterator.hasNext(); ) { EnemyType enemyType = objectSetIterator.next();
/* 51 */         stringBuilder.append(enemyType.name());
/* 52 */         b++;
/* 53 */         if (b != this.b.size) {
/* 54 */           stringBuilder.append(",");
/*    */         } }
/*    */       
/* 57 */       paramPrefMap.set("enemyTypesMetWith", stringBuilder.toString());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\preferences\categories\progress\PP_Enemy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */