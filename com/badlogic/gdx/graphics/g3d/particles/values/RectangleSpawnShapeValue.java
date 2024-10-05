/*    */ package com.badlogic.gdx.graphics.g3d.particles.values;
/*    */ 
/*    */ import com.badlogic.gdx.math.MathUtils;
/*    */ import com.badlogic.gdx.math.Vector3;
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
/*    */ public final class RectangleSpawnShapeValue
/*    */   extends PrimitiveSpawnShapeValue
/*    */ {
/*    */   public RectangleSpawnShapeValue(RectangleSpawnShapeValue paramRectangleSpawnShapeValue) {
/* 26 */     super(paramRectangleSpawnShapeValue);
/* 27 */     load(paramRectangleSpawnShapeValue);
/*    */   }
/*    */ 
/*    */   
/*    */   public RectangleSpawnShapeValue() {}
/*    */ 
/*    */   
/*    */   public final void spawnAux(Vector3 paramVector3, float paramFloat) {
/* 35 */     float f1 = this.spawnWidth + this.spawnWidthDiff * this.spawnWidthValue.getScale(paramFloat);
/* 36 */     float f2 = this.spawnHeight + this.spawnHeightDiff * this.spawnHeightValue.getScale(paramFloat);
/* 37 */     paramFloat = this.spawnDepth + this.spawnDepthDiff * this.spawnDepthValue.getScale(paramFloat);
/*    */     
/* 39 */     if (this.edges) {
/*    */       int i;
/*    */       
/* 42 */       if ((i = MathUtils.random(-1, 1)) == -1) {
/*    */         
/* 44 */         if ((f1 = (MathUtils.random(1) == 0) ? (-f1 / 2.0F) : (f1 / 2.0F)) == 0.0F) {
/* 45 */           f2 = (MathUtils.random(1) == 0) ? (-f2 / 2.0F) : (f2 / 2.0F);
/* 46 */           paramFloat = (MathUtils.random(1) == 0) ? (-paramFloat / 2.0F) : (paramFloat / 2.0F);
/*    */         } else {
/* 48 */           f2 = MathUtils.random(f2) - f2 / 2.0F;
/* 49 */           paramFloat = MathUtils.random(paramFloat) - paramFloat / 2.0F;
/*    */         } 
/* 51 */       } else if (i == 0) {
/*    */ 
/*    */         
/* 54 */         if ((paramFloat = (MathUtils.random(1) == 0) ? (-paramFloat / 2.0F) : (paramFloat / 2.0F)) == 0.0F) {
/* 55 */           f2 = (MathUtils.random(1) == 0) ? (-f2 / 2.0F) : (f2 / 2.0F);
/* 56 */           f1 = (MathUtils.random(1) == 0) ? (-f1 / 2.0F) : (f1 / 2.0F);
/*    */         } else {
/* 58 */           f2 = MathUtils.random(f2) - f2 / 2.0F;
/* 59 */           f1 = MathUtils.random(f1) - f1 / 2.0F;
/*    */         
/*    */         }
/*    */       
/*    */       }
/* 64 */       else if ((f2 = (MathUtils.random(1) == 0) ? (-f2 / 2.0F) : (f2 / 2.0F)) == 0.0F) {
/* 65 */         f1 = (MathUtils.random(1) == 0) ? (-f1 / 2.0F) : (f1 / 2.0F);
/* 66 */         paramFloat = (MathUtils.random(1) == 0) ? (-paramFloat / 2.0F) : (paramFloat / 2.0F);
/*    */       } else {
/* 68 */         f1 = MathUtils.random(f1) - f1 / 2.0F;
/* 69 */         paramFloat = MathUtils.random(paramFloat) - paramFloat / 2.0F;
/*    */       } 
/*    */       
/* 72 */       paramVector3.x = f1;
/* 73 */       paramVector3.y = f2;
/* 74 */       paramVector3.z = paramFloat; return;
/*    */     } 
/* 76 */     paramVector3.x = MathUtils.random(f1) - f1 / 2.0F;
/* 77 */     paramVector3.y = MathUtils.random(f2) - f2 / 2.0F;
/* 78 */     paramVector3.z = MathUtils.random(paramFloat) - paramFloat / 2.0F;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final SpawnShapeValue copy() {
/* 84 */     return new RectangleSpawnShapeValue(this);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\values\RectangleSpawnShapeValue.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */