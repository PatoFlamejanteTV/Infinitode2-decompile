/*    */ package com.prineside.tdi2.enums;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public enum TowerStatType {
/*  8 */   RANGE,
/*  9 */   MIN_RANGE,
/* 10 */   DAMAGE,
/* 11 */   ATTACK_SPEED,
/* 12 */   ROTATION_SPEED,
/* 13 */   PROJECTILE_SPEED,
/* 14 */   AIM_SPEED,
/* 15 */   CHARGING_SPEED,
/* 16 */   FREEZE_PERCENT,
/* 17 */   FREEZE_SPEED,
/*    */   
/* 19 */   STUN_CHANCE,
/* 20 */   CHAIN_LIGHTNING_DAMAGE,
/* 21 */   RESOURCE_CONSUMPTION,
/* 22 */   DURATION,
/*    */   
/* 24 */   PRICE,
/* 25 */   STARTING_LEVEL,
/* 26 */   STARTING_POWER,
/* 27 */   MAX_EXP_LEVEL,
/* 28 */   MAX_UPGRADE_LEVEL,
/* 29 */   EXPERIENCE_MULTIPLIER,
/* 30 */   EXPERIENCE_GENERATION,
/* 31 */   UPGRADE_PRICE,
/*    */   
/* 33 */   U_PIERCING,
/* 34 */   U_DAMAGE_MULTIPLY,
/* 35 */   U_CRIT_CHANCE,
/* 36 */   U_CRIT_MULTIPLIER,
/* 37 */   U_EXPLOSION_RANGE,
/* 38 */   U_POISON_DURATION_BONUS,
/* 39 */   U_CHAIN_LIGHTNING_BONUS_LENGTH,
/* 40 */   U_POISON_DURATION,
/* 41 */   U_PROJECTILE_COUNT,
/* 42 */   U_STUN_DURATION,
/* 43 */   U_QUAKE_CHARGE_SPEED,
/* 44 */   U_BURN_CHANCE,
/* 45 */   U_BURN_DAMAGE,
/* 46 */   U_ACCELERATION,
/* 47 */   U_SHOOT_ANGLE,
/* 48 */   U_CHAIN_LIGHTNING_LENGTH,
/* 49 */   U_LRM_AIM_SPEED,
/* 50 */   U_BURNING_TIME,
/* 51 */   U_BATTERIES_CAPACITY,
/*    */   
/* 53 */   U_BONUS_COINS,
/* 54 */   U_BONUS_EXPERIENCE,
/* 55 */   U_SHARED_DAMAGE,
/* 56 */   U_DIRECT_FIRE_DAMAGE,
/* 57 */   U_MAGAZINE_SIZE; public static final TowerStatType[] values;
/*    */   static {
/* 59 */     values = values();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 65 */     Array array1 = new Array();
/* 66 */     Array array2 = new Array(); TowerStatType[] arrayOfTowerStatType; int i; byte b2;
/* 67 */     for (i = (arrayOfTowerStatType = values).length, b2 = 0; b2 < i; b2++) {
/* 68 */       TowerStatType towerStatType; if ((towerStatType = arrayOfTowerStatType[b2]).name().startsWith("U_")) {
/* 69 */         array2.add(towerStatType);
/*    */       } else {
/* 71 */         array1.add(towerStatType);
/*    */       } 
/*    */     } 
/* 74 */     defaultValues = new TowerStatType[array1.size];
/* 75 */     uniqueValues = new TowerStatType[array2.size];
/*    */     
/* 77 */     byte b1 = 0; Array.ArrayIterator<TowerStatType> arrayIterator;
/* 78 */     for (arrayIterator = array1.iterator(); arrayIterator.hasNext(); ) { TowerStatType towerStatType = arrayIterator.next();
/* 79 */       defaultValues[b1] = towerStatType;
/* 80 */       b1++; }
/*    */     
/* 82 */     b1 = 0;
/* 83 */     for (arrayIterator = array2.iterator(); arrayIterator.hasNext(); ) { TowerStatType towerStatType = arrayIterator.next();
/* 84 */       uniqueValues[b1] = towerStatType;
/* 85 */       b1++; }
/*    */   
/*    */   }
/*    */   
/*    */   public static final TowerStatType[] defaultValues;
/*    */   public static final TowerStatType[] uniqueValues;
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enums\TowerStatType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */