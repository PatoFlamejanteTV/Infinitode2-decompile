/*    */ package com.badlogic.gdx.ai.fma;
/*    */ 
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
/*    */ public class FreeSlotAssignmentStrategy<T extends Vector<T>>
/*    */   implements SlotAssignmentStrategy<T>
/*    */ {
/*    */   public void updateSlotAssignments(Array<SlotAssignment<T>> paramArray) {
/* 36 */     for (byte b = 0; b < paramArray.size; b++) {
/* 37 */       ((SlotAssignment)paramArray.get(b)).slotNumber = b;
/*    */     }
/*    */   }
/*    */   
/*    */   public int calculateNumberOfSlots(Array<SlotAssignment<T>> paramArray) {
/* 42 */     return paramArray.size;
/*    */   }
/*    */ 
/*    */   
/*    */   public void removeSlotAssignment(Array<SlotAssignment<T>> paramArray, int paramInt) {
/* 47 */     paramArray.removeIndex(paramInt);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\fma\FreeSlotAssignmentStrategy.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */