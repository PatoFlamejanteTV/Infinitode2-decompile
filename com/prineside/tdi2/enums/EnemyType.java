/*    */ package com.prineside.tdi2.enums;
/*    */ 
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public enum EnemyType
/*    */ {
/*  8 */   REGULAR,
/*  9 */   FAST,
/* 10 */   STRONG,
/* 11 */   HELI,
/* 12 */   JET,
/* 13 */   ARMORED,
/* 14 */   HEALER,
/* 15 */   TOXIC,
/* 16 */   ICY,
/* 17 */   FIGHTER,
/* 18 */   LIGHT,
/* 19 */   GENERIC,
/* 20 */   BOSS,
/*    */ 
/*    */   
/* 23 */   SNAKE_BOSS_HEAD,
/* 24 */   SNAKE_BOSS_BODY,
/* 25 */   SNAKE_BOSS_TAIL,
/*    */   
/* 27 */   BROOT_BOSS,
/*    */   
/* 29 */   CONSTRUCTOR_BOSS,
/*    */   
/* 31 */   MOBCHAIN_BOSS_HEAD,
/* 32 */   MOBCHAIN_BOSS_BODY,
/* 33 */   MOBCHAIN_BOSS_CREEP,
/*    */   
/* 35 */   METAPHOR_BOSS,
/* 36 */   METAPHOR_BOSS_CREEP;
/*    */   public static final EnemyType[] values;
/*    */   public static final EnemyType[] mainEnemyTypes;
/*    */   
/*    */   static {
/* 41 */     values = values();
/* 42 */     mainEnemyTypes = new EnemyType[] { REGULAR, FAST, STRONG, HELI, JET, ARMORED, HEALER, TOXIC, ICY, FIGHTER, LIGHT, BOSS };
/*    */   }
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
/*    */   public static EnemyType getMainEnemyType(EnemyType paramEnemyType) {
/* 61 */     if (isBoss(paramEnemyType)) {
/* 62 */       return BOSS;
/*    */     }
/*    */     
/* 65 */     return paramEnemyType;
/*    */   }
/*    */   
/*    */   public static boolean isBoss(EnemyType paramEnemyType) {
/* 69 */     return (paramEnemyType.ordinal() >= BOSS.ordinal());
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enums\EnemyType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */