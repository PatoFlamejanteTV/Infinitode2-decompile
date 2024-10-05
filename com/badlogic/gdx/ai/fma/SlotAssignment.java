/*    */ package com.badlogic.gdx.ai.fma;
/*    */ 
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
/*    */ public class SlotAssignment<T extends Vector<T>>
/*    */ {
/*    */   public FormationMember<T> member;
/*    */   public int slotNumber;
/*    */   
/*    */   public SlotAssignment(FormationMember<T> paramFormationMember) {
/* 34 */     this(paramFormationMember, 0);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public SlotAssignment(FormationMember<T> paramFormationMember, int paramInt) {
/* 40 */     this.member = paramFormationMember;
/* 41 */     this.slotNumber = paramInt;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\fma\SlotAssignment.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */