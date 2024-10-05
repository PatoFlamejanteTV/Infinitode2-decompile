/*    */ package com.badlogic.gdx.pay;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class FreeTrialPeriod
/*    */ {
/*    */   private final int numberOfUnits;
/*    */   private final PeriodUnit unit;
/*    */   
/*    */   public enum PeriodUnit
/*    */   {
/* 18 */     DAY,
/* 19 */     MONTH,
/* 20 */     WEEK,
/* 21 */     YEAR;
/*    */     
/*    */     public static PeriodUnit parse(char param1Char) {
/* 24 */       switch (param1Char) {
/*    */         case 'D':
/* 26 */           return DAY;
/*    */         case 'W':
/* 28 */           return WEEK;
/*    */         case 'M':
/* 30 */           return MONTH;
/*    */         case 'Y':
/* 32 */           return YEAR;
/*    */       } 
/* 34 */       throw new IllegalArgumentException("Character not mapped to PeriodUnit: " + param1Char);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public FreeTrialPeriod(int paramInt, PeriodUnit paramPeriodUnit) {
/* 40 */     this.numberOfUnits = paramInt;
/* 41 */     this.unit = paramPeriodUnit;
/*    */   }
/*    */   
/*    */   public final int getNumberOfUnits() {
/* 45 */     return this.numberOfUnits;
/*    */   }
/*    */ 
/*    */   
/*    */   public final PeriodUnit getUnit() {
/* 50 */     return this.unit;
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean equals(Object paramObject) {
/* 55 */     if (this == paramObject) return true; 
/* 56 */     if (paramObject == null || getClass() != paramObject.getClass()) return false;
/*    */     
/* 58 */     paramObject = paramObject;
/*    */     
/* 60 */     if (this.numberOfUnits != ((FreeTrialPeriod)paramObject).numberOfUnits) return false; 
/* 61 */     return (this.unit == ((FreeTrialPeriod)paramObject).unit);
/*    */   }
/*    */ 
/*    */   
/*    */   public final int hashCode() {
/* 66 */     int i = this.numberOfUnits;
/*    */     
/* 68 */     return i = i * 31 + this.unit.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\pay\FreeTrialPeriod.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */