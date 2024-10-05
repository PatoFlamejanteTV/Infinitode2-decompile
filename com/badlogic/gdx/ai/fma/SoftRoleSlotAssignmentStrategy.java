/*     */ package com.badlogic.gdx.ai.fma;
/*     */ 
/*     */ import com.badlogic.gdx.math.Vector;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.BooleanArray;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SoftRoleSlotAssignmentStrategy<T extends Vector<T>>
/*     */   extends BoundedSlotAssignmentStrategy<T>
/*     */ {
/*     */   protected SlotCostProvider<T> slotCostProvider;
/*     */   protected float costThreshold;
/*     */   private BooleanArray filledSlots;
/*     */   
/*     */   public SoftRoleSlotAssignmentStrategy(SlotCostProvider<T> paramSlotCostProvider) {
/*  56 */     this(paramSlotCostProvider, Float.POSITIVE_INFINITY);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SoftRoleSlotAssignmentStrategy(SlotCostProvider<T> paramSlotCostProvider, float paramFloat) {
/*  63 */     this.slotCostProvider = paramSlotCostProvider;
/*  64 */     this.costThreshold = paramFloat;
/*     */     
/*  66 */     this.filledSlots = new BooleanArray();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateSlotAssignments(Array<SlotAssignment<T>> paramArray) {
/*  73 */     Array array = new Array();
/*     */ 
/*     */     
/*  76 */     int i = paramArray.size; byte b;
/*  77 */     for (b = 0; b < i; b++) {
/*  78 */       SlotAssignment slotAssignment = (SlotAssignment)paramArray.get(b);
/*     */ 
/*     */       
/*  81 */       MemberAndSlots<Vector> memberAndSlots = new MemberAndSlots<>(slotAssignment.member);
/*     */ 
/*     */       
/*  84 */       for (byte b1 = 0; b1 < i; b1++) {
/*     */         float f;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  90 */         if ((f = this.slotCostProvider.getCost(slotAssignment.member, b1)) < this.costThreshold) {
/*     */           
/*  92 */           SlotAssignment slotAssignment1 = (SlotAssignment)paramArray.get(b1);
/*     */ 
/*     */           
/*  95 */           CostAndSlot<Vector> costAndSlot = new CostAndSlot<>(f, slotAssignment1.slotNumber);
/*  96 */           memberAndSlots.costAndSlots.add(costAndSlot);
/*     */ 
/*     */           
/*  99 */           memberAndSlots.assignmentEase += 1.0F / (f + 1.0F);
/*     */         } 
/*     */       } 
/*     */       
/* 103 */       array.add(memberAndSlots);
/*     */     } 
/*     */ 
/*     */     
/* 107 */     if (i > this.filledSlots.size) this.filledSlots.ensureCapacity(i - this.filledSlots.size); 
/* 108 */     this.filledSlots.size = i;
/* 109 */     for (b = 0; b < i; b++) {
/* 110 */       this.filledSlots.set(b, false);
/*     */     }
/*     */     
/* 113 */     array.sort();
/*     */     
/* 115 */     for (b = 0; b < array.size; b++) {
/*     */       MemberAndSlots memberAndSlots;
/*     */ 
/*     */       
/* 119 */       (memberAndSlots = (MemberAndSlots)array.get(b)).costAndSlots.sort();
/* 120 */       int j = memberAndSlots.costAndSlots.size;
/* 121 */       byte b1 = 0; while (true) { if (b1 < j) {
/* 122 */           int k = ((CostAndSlot)memberAndSlots.costAndSlots.get(b1)).slotNumber;
/*     */ 
/*     */           
/* 125 */           if (!this.filledSlots.get(k)) {
/*     */             SlotAssignment slotAssignment;
/*     */             
/* 128 */             (slotAssignment = (SlotAssignment)paramArray.get(k)).member = memberAndSlots.member;
/* 129 */             slotAssignment.slotNumber = k;
/*     */ 
/*     */             
/* 132 */             this.filledSlots.set(k, true);
/*     */ 
/*     */             
/*     */             break;
/*     */           } 
/*     */           
/*     */           b1++;
/*     */           
/*     */           continue;
/*     */         } 
/*     */         
/* 143 */         throw new GdxRuntimeException("SoftRoleSlotAssignmentStrategy cannot find valid slot assignment for member " + memberAndSlots.member); }
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   static class CostAndSlot<T extends Vector<T>>
/*     */     implements Comparable<CostAndSlot<T>> {
/*     */     float cost;
/*     */     int slotNumber;
/*     */     
/*     */     public CostAndSlot(float param1Float, int param1Int) {
/* 154 */       this.cost = param1Float;
/* 155 */       this.slotNumber = param1Int;
/*     */     }
/*     */ 
/*     */     
/*     */     public int compareTo(CostAndSlot<T> param1CostAndSlot) {
/* 160 */       return (this.cost < param1CostAndSlot.cost) ? -1 : ((this.cost > param1CostAndSlot.cost) ? 1 : 0);
/*     */     }
/*     */   }
/*     */   
/*     */   static class MemberAndSlots<T extends Vector<T>> implements Comparable<MemberAndSlots<T>> {
/*     */     FormationMember<T> member;
/*     */     float assignmentEase;
/*     */     Array<SoftRoleSlotAssignmentStrategy.CostAndSlot<T>> costAndSlots;
/*     */     
/*     */     public MemberAndSlots(FormationMember<T> param1FormationMember) {
/* 170 */       this.member = param1FormationMember;
/* 171 */       this.assignmentEase = 0.0F;
/* 172 */       this.costAndSlots = new Array();
/*     */     }
/*     */ 
/*     */     
/*     */     public int compareTo(MemberAndSlots<T> param1MemberAndSlots) {
/* 177 */       return (this.assignmentEase < param1MemberAndSlots.assignmentEase) ? -1 : ((this.assignmentEase > param1MemberAndSlots.assignmentEase) ? 1 : 0);
/*     */     }
/*     */   }
/*     */   
/*     */   public static interface SlotCostProvider<T extends Vector<T>> {
/*     */     float getCost(FormationMember<T> param1FormationMember, int param1Int);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\fma\SoftRoleSlotAssignmentStrategy.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */