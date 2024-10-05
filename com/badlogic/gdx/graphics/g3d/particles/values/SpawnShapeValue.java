/*    */ package com.badlogic.gdx.graphics.g3d.particles.values;
/*    */ 
/*    */ import com.badlogic.gdx.assets.AssetManager;
/*    */ import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
/*    */ import com.badlogic.gdx.math.Vector3;
/*    */ import com.badlogic.gdx.utils.Json;
/*    */ import com.badlogic.gdx.utils.JsonValue;
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
/*    */ public abstract class SpawnShapeValue
/*    */   extends ParticleValue
/*    */   implements ResourceData.Configurable, Json.Serializable
/*    */ {
/* 32 */   public RangedNumericValue xOffsetValue = new RangedNumericValue();
/* 33 */   public RangedNumericValue yOffsetValue = new RangedNumericValue();
/* 34 */   public RangedNumericValue zOffsetValue = new RangedNumericValue();
/*    */ 
/*    */   
/*    */   public SpawnShapeValue(SpawnShapeValue paramSpawnShapeValue) {
/* 38 */     this();
/*    */   }
/*    */   public SpawnShapeValue() {}
/*    */   public abstract void spawnAux(Vector3 paramVector3, float paramFloat);
/*    */   
/*    */   public final Vector3 spawn(Vector3 paramVector3, float paramFloat) {
/* 44 */     spawnAux(paramVector3, paramFloat);
/* 45 */     if (this.xOffsetValue.active) paramVector3.x += this.xOffsetValue.newLowValue(); 
/* 46 */     if (this.yOffsetValue.active) paramVector3.y += this.yOffsetValue.newLowValue(); 
/* 47 */     if (this.zOffsetValue.active) paramVector3.z += this.zOffsetValue.newLowValue(); 
/* 48 */     return paramVector3;
/*    */   }
/*    */ 
/*    */   
/*    */   public void init() {}
/*    */ 
/*    */   
/*    */   public void start() {}
/*    */ 
/*    */   
/*    */   public void load(ParticleValue paramParticleValue) {
/* 59 */     super.load(paramParticleValue);
/* 60 */     paramParticleValue = paramParticleValue;
/* 61 */     this.xOffsetValue.load(((SpawnShapeValue)paramParticleValue).xOffsetValue);
/* 62 */     this.yOffsetValue.load(((SpawnShapeValue)paramParticleValue).yOffsetValue);
/* 63 */     this.zOffsetValue.load(((SpawnShapeValue)paramParticleValue).zOffsetValue);
/*    */   }
/*    */ 
/*    */   
/*    */   public abstract SpawnShapeValue copy();
/*    */   
/*    */   public void write(Json paramJson) {
/* 70 */     super.write(paramJson);
/* 71 */     paramJson.writeValue("xOffsetValue", this.xOffsetValue);
/* 72 */     paramJson.writeValue("yOffsetValue", this.yOffsetValue);
/* 73 */     paramJson.writeValue("zOffsetValue", this.zOffsetValue);
/*    */   }
/*    */ 
/*    */   
/*    */   public void read(Json paramJson, JsonValue paramJsonValue) {
/* 78 */     super.read(paramJson, paramJsonValue);
/* 79 */     this.xOffsetValue = (RangedNumericValue)paramJson.readValue("xOffsetValue", RangedNumericValue.class, paramJsonValue);
/* 80 */     this.yOffsetValue = (RangedNumericValue)paramJson.readValue("yOffsetValue", RangedNumericValue.class, paramJsonValue);
/* 81 */     this.zOffsetValue = (RangedNumericValue)paramJson.readValue("zOffsetValue", RangedNumericValue.class, paramJsonValue);
/*    */   }
/*    */   
/*    */   public void save(AssetManager paramAssetManager, ResourceData paramResourceData) {}
/*    */   
/*    */   public void load(AssetManager paramAssetManager, ResourceData paramResourceData) {}
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\values\SpawnShapeValue.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */