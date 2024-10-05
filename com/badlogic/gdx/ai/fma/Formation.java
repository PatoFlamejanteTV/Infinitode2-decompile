/*     */ package com.badlogic.gdx.ai.fma;
/*     */ 
/*     */ import com.badlogic.gdx.ai.utils.Location;
/*     */ import com.badlogic.gdx.math.Matrix3;
/*     */ import com.badlogic.gdx.math.Vector;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.math.Vector3;
/*     */ import com.badlogic.gdx.utils.Array;
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
/*     */ public class Formation<T extends Vector<T>>
/*     */ {
/*     */   Array<SlotAssignment<T>> slotAssignments;
/*     */   protected Location<T> anchor;
/*     */   protected FormationPattern<T> pattern;
/*     */   protected SlotAssignmentStrategy<T> slotAssignmentStrategy;
/*     */   protected FormationMotionModerator<T> motionModerator;
/*     */   private final T positionOffset;
/*  58 */   private final Matrix3 orientationMatrix = new Matrix3();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Location<T> driftOffset;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Formation(Location<T> paramLocation, FormationPattern<T> paramFormationPattern) {
/*  69 */     this(paramLocation, paramFormationPattern, new FreeSlotAssignmentStrategy<>(), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Formation(Location<T> paramLocation, FormationPattern<T> paramFormationPattern, SlotAssignmentStrategy<T> paramSlotAssignmentStrategy) {
/*  78 */     this(paramLocation, paramFormationPattern, paramSlotAssignmentStrategy, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Formation(Location<T> paramLocation, FormationPattern<T> paramFormationPattern, SlotAssignmentStrategy<T> paramSlotAssignmentStrategy, FormationMotionModerator<T> paramFormationMotionModerator) {
/*  89 */     if (paramLocation == null) throw new IllegalArgumentException("The anchor point cannot be null"); 
/*  90 */     this.anchor = paramLocation;
/*  91 */     this.pattern = paramFormationPattern;
/*  92 */     this.slotAssignmentStrategy = paramSlotAssignmentStrategy;
/*  93 */     this.motionModerator = paramFormationMotionModerator;
/*     */     
/*  95 */     this.slotAssignments = new Array();
/*  96 */     this.driftOffset = paramLocation.newLocation();
/*  97 */     this.positionOffset = (T)paramLocation.getPosition().cpy();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Location<T> getAnchorPoint() {
/* 104 */     return this.anchor;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAnchorPoint(Location<T> paramLocation) {
/* 110 */     this.anchor = paramLocation;
/*     */   }
/*     */ 
/*     */   
/*     */   public FormationPattern<T> getPattern() {
/* 115 */     return this.pattern;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPattern(FormationPattern<T> paramFormationPattern) {
/* 121 */     this.pattern = paramFormationPattern;
/*     */   }
/*     */ 
/*     */   
/*     */   public SlotAssignmentStrategy<T> getSlotAssignmentStrategy() {
/* 126 */     return this.slotAssignmentStrategy;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSlotAssignmentStrategy(SlotAssignmentStrategy<T> paramSlotAssignmentStrategy) {
/* 132 */     this.slotAssignmentStrategy = paramSlotAssignmentStrategy;
/*     */   }
/*     */ 
/*     */   
/*     */   public FormationMotionModerator<T> getMotionModerator() {
/* 137 */     return this.motionModerator;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMotionModerator(FormationMotionModerator<T> paramFormationMotionModerator) {
/* 143 */     this.motionModerator = paramFormationMotionModerator;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateSlotAssignments() {
/* 149 */     this.slotAssignmentStrategy.updateSlotAssignments(this.slotAssignments);
/*     */ 
/*     */     
/* 152 */     this.pattern.setNumberOfSlots(this.slotAssignmentStrategy.calculateNumberOfSlots(this.slotAssignments));
/*     */ 
/*     */     
/* 155 */     if (this.motionModerator != null) this.motionModerator.calculateDriftOffset(this.driftOffset, this.slotAssignments, this.pattern);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean changePattern(FormationPattern<T> paramFormationPattern) {
/* 164 */     int i = this.slotAssignments.size;
/*     */ 
/*     */     
/* 167 */     if (paramFormationPattern.supportsSlots(i)) {
/* 168 */       setPattern(paramFormationPattern);
/*     */ 
/*     */       
/* 171 */       updateSlotAssignments();
/*     */       
/* 173 */       return true;
/*     */     } 
/*     */     
/* 176 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addMember(FormationMember<T> paramFormationMember) {
/* 185 */     int i = this.slotAssignments.size;
/*     */ 
/*     */     
/* 188 */     if (this.pattern.supportsSlots(i + 1)) {
/*     */       
/* 190 */       this.slotAssignments.add(new SlotAssignment<>(paramFormationMember, i));
/*     */ 
/*     */       
/* 193 */       updateSlotAssignments();
/* 194 */       return true;
/*     */     } 
/*     */     
/* 197 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeMember(FormationMember<T> paramFormationMember) {
/*     */     int i;
/* 207 */     if ((i = findMemberSlot(paramFormationMember)) >= 0) {
/*     */ 
/*     */       
/* 210 */       this.slotAssignmentStrategy.removeSlotAssignment(this.slotAssignments, i);
/*     */ 
/*     */       
/* 213 */       updateSlotAssignments();
/*     */     } 
/*     */   }
/*     */   
/*     */   private int findMemberSlot(FormationMember<T> paramFormationMember) {
/* 218 */     for (byte b = 0; b < this.slotAssignments.size; b++) {
/* 219 */       if (((SlotAssignment)this.slotAssignments.get(b)).member == paramFormationMember) return b; 
/*     */     } 
/* 221 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public SlotAssignment<T> getSlotAssignmentAt(int paramInt) {
/* 226 */     return (SlotAssignment<T>)this.slotAssignments.get(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSlotAssignmentCount() {
/* 231 */     return this.slotAssignments.size;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateSlots() {
/* 237 */     Location<T> location = getAnchorPoint();
/*     */     
/* 239 */     this.positionOffset.set(location.getPosition());
/* 240 */     float f = location.getOrientation();
/* 241 */     if (this.motionModerator != null) {
/* 242 */       this.positionOffset.sub(this.driftOffset.getPosition());
/* 243 */       f -= this.driftOffset.getOrientation();
/*     */     } 
/*     */ 
/*     */     
/* 247 */     this.orientationMatrix.idt().rotateRad(location.getOrientation());
/*     */ 
/*     */     
/* 250 */     for (byte b = 0; b < this.slotAssignments.size; b++) {
/*     */       SlotAssignment slotAssignment;
/*     */ 
/*     */       
/* 254 */       Location<Vector> location1 = (slotAssignment = (SlotAssignment)this.slotAssignments.get(b)).member.getTargetLocation();
/*     */ 
/*     */       
/* 257 */       this.pattern.calculateSlotLocation((Location)location1, slotAssignment.slotNumber);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       Vector vector;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 273 */       if (vector = location1.getPosition() instanceof Vector2)
/* 274 */       { ((Vector2)vector).mul(this.orientationMatrix); }
/* 275 */       else if (vector instanceof Vector3) { ((Vector3)vector).mul(this.orientationMatrix); }
/*     */ 
/*     */       
/* 278 */       vector.add((Vector)this.positionOffset);
/* 279 */       location1.setOrientation(location1.getOrientation() + f);
/*     */     } 
/*     */ 
/*     */     
/* 283 */     if (this.motionModerator != null)
/* 284 */       this.motionModerator.updateAnchorPoint(location); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\fma\Formation.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */