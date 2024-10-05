/*    */ package com.prineside.tdi2;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g2d.Batch;
/*    */ import com.badlogic.gdx.utils.Json;
/*    */ import com.badlogic.gdx.utils.JsonValue;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.prineside.tdi2.enums.BuildingType;
/*    */ import com.prineside.tdi2.shapes.RangeCircle;
/*    */ import com.prineside.tdi2.systems.MapRenderingSystem;
/*    */ import com.prineside.tdi2.tiles.PlatformTile;
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class Building
/*    */   extends Registrable
/*    */ {
/*    */   public BuildingType buildingType;
/*    */   private PlatformTile a;
/*    */   
/*    */   public void write(Kryo paramKryo, Output paramOutput) {
/* 23 */     super.write(paramKryo, paramOutput);
/* 24 */     paramKryo.writeObjectOrNull(paramOutput, this.buildingType, BuildingType.class);
/* 25 */     paramKryo.writeObjectOrNull(paramOutput, this.a, PlatformTile.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public void read(Kryo paramKryo, Input paramInput) {
/* 30 */     super.read(paramKryo, paramInput);
/* 31 */     this.buildingType = (BuildingType)paramKryo.readObjectOrNull(paramInput, BuildingType.class);
/* 32 */     this.a = (PlatformTile)paramKryo.readObjectOrNull(paramInput, PlatformTile.class);
/*    */   }
/*    */   
/*    */   public Building(BuildingType paramBuildingType) {
/* 36 */     this.buildingType = paramBuildingType;
/*    */   }
/*    */   
/*    */   public boolean sameAs(Building paramBuilding) {
/* 40 */     if (paramBuilding == null) return false; 
/* 41 */     if (this.buildingType != paramBuilding.buildingType) return false; 
/* 42 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public abstract Building cloneBuilding();
/*    */ 
/*    */   
/*    */   public abstract void updateCache();
/*    */ 
/*    */   
/*    */   public abstract float getWalkCost();
/*    */   
/*    */   public PlatformTile getTile() {
/* 55 */     return this.a;
/*    */   }
/*    */   
/*    */   public void setTile(PlatformTile paramPlatformTile) {
/* 59 */     this.a = paramPlatformTile;
/*    */   }
/*    */   
/*    */   public void drawBase(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, MapRenderingSystem.DrawMode paramDrawMode) {}
/*    */   
/*    */   public void toJson(Json paramJson) {
/* 65 */     paramJson.writeValue("bType", this.buildingType.name());
/*    */   }
/*    */   
/*    */   public void placedOnMap() {}
/*    */   
/*    */   public void removedFromMap() {}
/*    */   
/*    */   public void drawSelectedRange(Batch paramBatch, RangeCircle paramRangeCircle) {}
/*    */   
/*    */   public void drawHoveredRange(Batch paramBatch, RangeCircle paramRangeCircle) {}
/*    */   
/*    */   public static Building fromJson(JsonValue paramJsonValue) {
/* 77 */     BuildingType buildingType = BuildingType.valueOf(paramJsonValue.getString("bType"));
/* 78 */     switch (null.a[buildingType.ordinal()]) { case 1:
/* 79 */         return Game.i.towerManager.fromJson(paramJsonValue);
/* 80 */       case 2: return Game.i.modifierManager.fromJson(paramJsonValue); }
/*    */ 
/*    */     
/* 83 */     throw new RuntimeException("Not implemented: " + buildingType.name());
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\Building.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */