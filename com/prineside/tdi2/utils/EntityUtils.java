/*    */ package com.prineside.tdi2.utils;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.prineside.tdi2.Enemy;
/*    */ 
/*    */ public class EntityUtils {
/*    */   public static void removeNullRefs(Array<Enemy.EnemyReference> paramArray) {
/*  8 */     for (int i = paramArray.size - 1; i >= 0; i--) {
/*  9 */       if ((((Enemy.EnemyReference[])paramArray.items)[i]).enemy == null) {
/* 10 */         paramArray.removeIndex(i);
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   public static boolean removeByValue(Array<Enemy.EnemyReference> paramArray, Enemy paramEnemy) {
/* 16 */     for (byte b = 0; b < paramArray.size; b++) {
/* 17 */       if ((((Enemy.EnemyReference[])paramArray.items)[b]).enemy == paramEnemy) {
/* 18 */         paramArray.removeIndex(b);
/* 19 */         return true;
/*    */       } 
/*    */     } 
/* 22 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\EntityUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */