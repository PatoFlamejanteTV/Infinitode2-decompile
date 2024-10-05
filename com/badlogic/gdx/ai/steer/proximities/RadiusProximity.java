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
/*     */ public class RadiusProximity<T extends Vector<T>>
/*     */   extends ProximityBase<T>
/*     */ {
/*     */   protected float radius;
/*     */   private float lastTime;
/*     */   
/*     */   public RadiusProximity(Steerable<T> paramSteerable, Iterable<? extends Steerable<T>> paramIterable, float paramFloat) {
/*  51 */     super(paramSteerable, paramIterable);
/*  52 */     this.radius = paramFloat;
/*  53 */     this.lastTime = 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getRadius() {
/*  58 */     return this.radius;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRadius(float paramFloat) {
/*  63 */     this.radius = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public int findNeighbors(Proximity.ProximityCallback<T> paramProximityCallback) {
/*  68 */     byte b = 0;
/*     */ 
/*     */ 
/*     */     
/*  72 */     float f = GdxAI.getTimepiece().getTime();
/*  73 */     if (this.lastTime != f) {
/*     */       
/*  75 */       this.lastTime = f;
/*     */       
/*  77 */       Vector vector = this.owner.getPosition();
/*     */ 
/*     */       
/*  80 */       for (Iterator<? extends Steerable<T>> iterator = this.agents.iterator(); iterator.hasNext(); ) {
/*     */         Steerable<T> steerable;
/*  82 */         if ((steerable = iterator.next()) != this.owner) {
/*  83 */           float f1 = vector.dst2(steerable.getPosition());
/*     */ 
/*     */ 
/*     */           
/*  87 */           float f2 = this.radius + steerable.getBoundingRadius();
/*     */ 
/*     */ 
/*     */           
/*  91 */           if (f1 < f2 * f2 && 
/*  92 */             paramProximityCallback.reportNeighbor(steerable)) {
/*  93 */             steerable.setTagged(true);
/*  94 */             b++;
/*     */ 
/*     */             
/*     */             continue;
/*     */           } 
/*     */         } 
/*     */         
/* 101 */         steerable.setTagged(false);
/*     */       } 
/*     */     } else {
/*     */       
/* 105 */       for (Iterator<? extends Steerable<T>> iterator = this.agents.iterator(); iterator.hasNext();) {
/*     */ 
/*     */         
/* 108 */         if ((steerable = iterator.next()) != this.owner && steerable.isTagged())
/*     */         {
/* 110 */           if (paramProximityCallback.reportNeighbor(steerable)) {
/* 111 */             b++;
/*     */           }
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 117 */     return b;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\steer\proximities\RadiusProximity.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */