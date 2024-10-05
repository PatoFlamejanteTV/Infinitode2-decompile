/*    */ package com.badlogic.gdx.ai.fma;
/*    */ 
/*    */ import com.badlogic.gdx.ai.utils.Location;
/*    */ import com.badlogic.gdx.math.Vector;
/*    */ import com.badlogic.gdx.utils.Array;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class FormationMotionModerator<T extends Vector<T>>
/*    */ {
/*    */   private Location<T> tempLocation;
/*    */   
/*    */   public abstract void updateAnchorPoint(Location<T> paramLocation);
/*    */   
/*    */   public Location<T> calculateDriftOffset(Location<T> paramLocation, Array<SlotAssignment<T>> paramArray, FormationPattern<T> paramFormationPattern) {
/* 47 */     paramLocation.getPosition().setZero();
/* 48 */     float f1 = 0.0F;
/*    */ 
/*    */     
/* 51 */     if (this.tempLocation == null) this.tempLocation = paramLocation.newLocation();
/*    */     
/* 53 */     Vector vector1 = paramLocation.getPosition();
/* 54 */     Vector vector2 = this.tempLocation.getPosition();
/*    */ 
/*    */     
/* 57 */     float f2 = paramArray.size;
/* 58 */     for (byte b = 0; b < f2; b++) {
/* 59 */       paramFormationPattern.calculateSlotLocation(this.tempLocation, ((SlotAssignment)paramArray.get(b)).slotNumber);
/* 60 */       vector1.add(vector2);
/* 61 */       f1 += this.tempLocation.getOrientation();
/*    */     } 
/*    */ 
/*    */     
/* 65 */     vector1.scl(1.0F / f2);
/* 66 */     f1 /= f2;
/* 67 */     paramLocation.setOrientation(f1);
/*    */     
/* 69 */     return paramLocation;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\fma\FormationMotionModerator.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */