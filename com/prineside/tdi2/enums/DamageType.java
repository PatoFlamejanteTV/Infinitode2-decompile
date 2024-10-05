/*    */ package com.prineside.tdi2.enums;
/*    */ 
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public enum DamageType {
/*  7 */   BULLET,
/*  8 */   FIRE,
/*  9 */   POISON,
/* 10 */   EXPLOSION,
/* 11 */   ELECTRICITY,
/* 12 */   LASER;
/*    */ 
/*    */   
/*    */   public static final DamageType[] values;
/*    */ 
/*    */ 
/*    */   
/*    */   public static final class Efficiency
/*    */   {
/*    */     public static final int CRITICAL_BIT = 1;
/*    */ 
/*    */     
/*    */     public static final int EFFECTIVE_BIT = 2;
/*    */ 
/*    */     
/*    */     public static final int OVER_TIME_BIT = 4;
/*    */ 
/*    */     
/*    */     public static final int ESPECIALLY_EFFECTIVE_BIT = 8;
/*    */ 
/*    */     
/*    */     public static final int WEAK_BIT = 16;
/*    */ 
/*    */     
/*    */     public static final int NORMAL = 0;
/*    */ 
/*    */     
/*    */     public static final int CRITICAL = 1;
/*    */ 
/*    */     
/*    */     public static final int OVER_TIME = 4;
/*    */ 
/*    */     
/*    */     public static final int ESPECIALLY_EFFECTIVE = 8;
/*    */ 
/*    */     
/*    */     public static boolean isNormal(int param1Int) {
/* 49 */       return (param1Int == 0);
/*    */     }
/*    */     
/*    */     public static boolean isCritical(int param1Int) {
/* 53 */       return ((param1Int & 0x1) == 1);
/*    */     }
/*    */     
/*    */     public static boolean isEffective(int param1Int) {
/* 57 */       return ((param1Int & 0x2) == 2);
/*    */     }
/*    */     
/*    */     public static boolean isWeak(int param1Int) {
/* 61 */       return ((param1Int & 0x10) == 16);
/*    */     }
/*    */     
/*    */     public static boolean isOverTime(int param1Int) {
/* 65 */       return ((param1Int & 0x4) == 4);
/*    */     }
/*    */     
/*    */     public static boolean isEspeciallyEffective(int param1Int) {
/* 69 */       return ((param1Int & 0x8) == 8);
/*    */     } }
/*    */   
/*    */   static {
/* 73 */     values = values();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enums\DamageType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */