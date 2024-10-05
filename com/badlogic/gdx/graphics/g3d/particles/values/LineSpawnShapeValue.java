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
/*    */ 
/*    */ public final class LineSpawnShapeValue
/*    */   extends PrimitiveSpawnShapeValue
/*    */ {
/*    */   public LineSpawnShapeValue(LineSpawnShapeValue paramLineSpawnShapeValue) {
/* 27 */     super(paramLineSpawnShapeValue);
/* 28 */     load(paramLineSpawnShapeValue);
/*    */   }
/*    */ 
/*    */   
/*    */   public LineSpawnShapeValue() {}
/*    */ 
/*    */   
/*    */   public final void spawnAux(Vector3 paramVector3, float paramFloat) {
/* 36 */     float f1 = this.spawnWidth + this.spawnWidthDiff * this.spawnWidthValue.getScale(paramFloat);
/* 37 */     float f2 = this.spawnHeight + this.spawnHeightDiff * this.spawnHeightValue.getScale(paramFloat);
/* 38 */     paramFloat = this.spawnDepth + this.spawnDepthDiff * this.spawnDepthValue.getScale(paramFloat);
/*    */     
/* 40 */     float f3 = MathUtils.random();
/* 41 */     paramVector3.x = f3 * f1;
/* 42 */     paramVector3.y = f3 * f2;
/* 43 */     paramVector3.z = f3 * paramFloat;
/*    */   }
/*    */ 
/*    */   
/*    */   public final SpawnShapeValue copy() {
/* 48 */     return new LineSpawnShapeValue(this);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\values\LineSpawnShapeValue.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */