/*     */ package com.badlogic.gdx.ai.steer.proximities;
/*     */ 
/*     */ import com.badlogic.gdx.ai.GdxAI;
/*     */ import com.badlogic.gdx.ai.steer.Proximity;
/*     */ import com.badlogic.gdx.ai.steer.Steerable;
/*     */ import com.badlogic.gdx.math.Vector;
/*     */ import java.util.Iterator;
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
/*     */ 
/*     */ public class FieldOfViewProximity<T extends Vector<T>>
/*     */   extends ProximityBase<T>
/*     */ {
/*     */   protected float radius;
/*     */   protected float angle;
/*     */   private float coneThreshold;
/*     */   private float lastTime;
/*     */   private T ownerOrientation;
/*     */   private T toAgent;
/*     */   
/*     */   public FieldOfViewProximity(Steerable<T> paramSteerable, Iterable<? extends Steerable<T>> paramIterable, float paramFloat1, float paramFloat2) {
/*  61 */     super(paramSteerable, paramIterable);
/*  62 */     this.radius = paramFloat1;
/*  63 */     setAngle(paramFloat2);
/*  64 */     this.lastTime = 0.0F;
/*  65 */     this.ownerOrientation = (T)paramSteerable.getPosition().cpy().setZero();
/*  66 */     this.toAgent = (T)paramSteerable.getPosition().cpy().setZero();
/*     */   }
/*     */ 
/*     */   
/*     */   public float getRadius() {
/*  71 */     return this.radius;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRadius(float paramFloat) {
/*  76 */     this.radius = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getAngle() {
/*  81 */     return this.angle;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAngle(float paramFloat) {
/*  86 */     this.angle = paramFloat;
/*  87 */     this.coneThreshold = (float)Math.cos((paramFloat * 0.5F));
/*     */   }
/*     */ 
/*     */   
/*     */   public int findNeighbors(Proximity.ProximityCallback<T> paramProximityCallback) {
/*  92 */     byte b = 0;
/*     */ 
/*     */ 
/*     */     
/*  96 */     float f = GdxAI.getTimepiece().getTime();
/*  97 */     if (this.lastTime != f) {
/*     */       
/*  99 */       this.lastTime = f;
/*     */       
/* 101 */       Vector vector = this.owner.getPosition();
/*     */ 
/*     */       
/* 104 */       this.owner.angleToVector((Vector)this.ownerOrientation, this.owner.getOrientation());
/*     */ 
/*     */       
/* 107 */       for (Iterator<? extends Steerable<T>> iterator = this.agents.iterator(); iterator.hasNext(); ) {
/*     */         Steerable<T> steerable;
/*     */         
/* 110 */         if ((steerable = iterator.next()) != this.owner) {
/*     */           
/* 112 */           this.toAgent.set(steerable.getPosition()).sub(vector);
/*     */ 
/*     */ 
/*     */           
/* 116 */           float f1 = this.radius + steerable.getBoundingRadius();
/*     */ 
/*     */           
/*     */           float f2;
/*     */ 
/*     */           
/* 122 */           if ((f2 = this.toAgent.len2()) < f1 * f1)
/*     */           {
/*     */ 
/*     */             
/* 126 */             if (this.ownerOrientation.dot((Vector)this.toAgent) > this.coneThreshold && 
/* 127 */               paramProximityCallback.reportNeighbor(steerable)) {
/* 128 */               steerable.setTagged(true);
/* 129 */               b++;
/*     */ 
/*     */               
/*     */               continue;
/*     */             } 
/*     */           }
/*     */         } 
/*     */         
/* 137 */         steerable.setTagged(false);
/*     */       } 
/*     */     } else {
/*     */       
/* 141 */       for (Iterator<? extends Steerable<T>> iterator = this.agents.iterator(); iterator.hasNext();) {
/*     */ 
/*     */ 
/*     */         
/* 145 */         if ((steerable = iterator.next()) != this.owner && steerable.isTagged())
/*     */         {
/* 147 */           if (paramProximityCallback.reportNeighbor(steerable)) {
/* 148 */             b++;
/*     */           }
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 154 */     return b;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\steer\proximities\FieldOfViewProximity.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */