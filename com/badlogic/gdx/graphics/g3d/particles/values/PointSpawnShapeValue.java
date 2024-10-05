/*    */ package com.badlogic.gdx.graphics.g3d.particles.values;
/*    */ 
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
/*    */ 
/*    */ public final class PointSpawnShapeValue
/*    */   extends PrimitiveSpawnShapeValue
/*    */ {
/*    */   public PointSpawnShapeValue(PointSpawnShapeValue paramPointSpawnShapeValue) {
/* 26 */     super(paramPointSpawnShapeValue);
/* 27 */     load(paramPointSpawnShapeValue);
/*    */   }
/*    */ 
/*    */   
/*    */   public PointSpawnShapeValue() {}
/*    */ 
/*    */   
/*    */   public final void spawnAux(Vector3 paramVector3, float paramFloat) {
/* 35 */     paramVector3.x = this.spawnWidth + this.spawnWidthDiff * this.spawnWidthValue.getScale(paramFloat);
/* 36 */     paramVector3.y = this.spawnHeight + this.spawnHeightDiff * this.spawnHeightValue.getScale(paramFloat);
/* 37 */     paramVector3.z = this.spawnDepth + this.spawnDepthDiff * this.spawnDepthValue.getScale(paramFloat);
/*    */   }
/*    */ 
/*    */   
/*    */   public final SpawnShapeValue copy() {
/* 42 */     return new PointSpawnShapeValue(this);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\values\PointSpawnShapeValue.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */