/*    */ package com.badlogic.gdx.ai.fma.patterns;
/*    */ 
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
/*    */ public class OffensiveCircleFormationPattern<T extends Vector<T>>
/*    */   extends DefensiveCircleFormationPattern<T>
/*    */ {
/*    */   public OffensiveCircleFormationPattern(float paramFloat) {
/* 35 */     super(paramFloat);
/*    */   }
/*    */ 
/*    */   
/*    */   public Location<T> calculateSlotLocation(Location<T> paramLocation, int paramInt) {
/* 40 */     super.calculateSlotLocation(paramLocation, paramInt);
/* 41 */     paramLocation.setOrientation(paramLocation.getOrientation() + 3.1415927F);
/* 42 */     return paramLocation;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\fma\patterns\OffensiveCircleFormationPattern.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */