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
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class BoundedSlotAssignmentStrategy<T extends Vector<T>>
/*    */   implements SlotAssignmentStrategy<T>
/*    */ {
/*    */   public abstract void updateSlotAssignments(Array<SlotAssignment<T>> paramArray);
/*    */   
/*    */   public int calculateNumberOfSlots(Array<SlotAssignment<T>> paramArray) {
/* 41 */     int i = -1;
/* 42 */     for (byte b = 0; b < paramArray.size; b++) {
/*    */       SlotAssignment slotAssignment;
/* 44 */       if ((slotAssignment = (SlotAssignment)paramArray.get(b)).slotNumber >= i) i = slotAssignment.slotNumber;
/*    */     
/*    */     } 
/*    */     
/* 48 */     return i + 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public void removeSlotAssignment(Array<SlotAssignment<T>> paramArray, int paramInt) {
/* 53 */     int i = ((SlotAssignment)paramArray.get(paramInt)).slotNumber;
/* 54 */     for (byte b = 0; b < paramArray.size; b++) {
/*    */       SlotAssignment slotAssignment;
/* 56 */       if ((slotAssignment = (SlotAssignment)paramArray.get(b)).slotNumber >= i) slotAssignment.slotNumber--; 
/*    */     } 
/* 58 */     paramArray.removeIndex(paramInt);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\fma\BoundedSlotAssignmentStrategy.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */