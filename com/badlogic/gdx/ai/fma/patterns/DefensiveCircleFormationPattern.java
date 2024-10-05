/*    */ package com.badlogic.gdx.ai.fma.patterns;
/*    */ 
/*    */ import com.badlogic.gdx.ai.fma.FormationPattern;
/*    */ import com.badlogic.gdx.ai.utils.Location;
/*    */ import com.badlogic.gdx.math.Vector;
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
/*    */ public class DefensiveCircleFormationPattern<T extends Vector<T>>
/*    */   implements FormationPattern<T>
/*    */ {
/*    */   int numberOfSlots;
/*    */   float memberRadius;
/*    */   
/*    */   public DefensiveCircleFormationPattern(float paramFloat) {
/* 41 */     this.memberRadius = paramFloat;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setNumberOfSlots(int paramInt) {
/* 46 */     this.numberOfSlots = paramInt;
/*    */   }
/*    */   
/*    */   public Location<T> calculateSlotLocation(Location<T> paramLocation, int paramInt) {
/*    */     float f;
/* 51 */     if (this.numberOfSlots > 1) {
/*    */       
/* 53 */       f = 6.2831855F * paramInt / this.numberOfSlots;
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 58 */       float f1 = this.memberRadius / (float)Math.sin(Math.PI / this.numberOfSlots);
/*    */ 
/*    */       
/* 61 */       paramLocation.angleToVector(paramLocation.getPosition(), f).scl(f1);
/*    */ 
/*    */       
/* 64 */       paramLocation.setOrientation(f);
/*    */     } else {
/*    */       
/* 67 */       paramLocation.getPosition().setZero();
/* 68 */       paramLocation.setOrientation(6.2831855F * f);
/*    */     } 
/*    */ 
/*    */     
/* 72 */     return paramLocation;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean supportsSlots(int paramInt) {
/* 78 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\fma\patterns\DefensiveCircleFormationPattern.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */