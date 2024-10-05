/*    */ package com.badlogic.gdx.graphics.g3d.particles;
/*    */ 
/*    */ import com.badlogic.gdx.assets.AssetManager;
/*    */ import com.badlogic.gdx.math.Matrix3;
/*    */ import com.badlogic.gdx.math.Matrix4;
/*    */ import com.badlogic.gdx.math.Quaternion;
/*    */ import com.badlogic.gdx.math.Vector3;
/*    */ import com.badlogic.gdx.utils.Disposable;
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
/*    */ public abstract class ParticleControllerComponent
/*    */   implements ResourceData.Configurable, Disposable, Json.Serializable
/*    */ {
/* 32 */   protected static final Vector3 TMP_V1 = new Vector3(), TMP_V2 = new Vector3(), TMP_V3 = new Vector3(), TMP_V4 = new Vector3();
/* 33 */   protected static final Vector3 TMP_V5 = new Vector3(); protected static final Vector3 TMP_V6 = new Vector3();
/* 34 */   protected static final Quaternion TMP_Q = new Quaternion(); protected static final Quaternion TMP_Q2 = new Quaternion();
/* 35 */   protected static final Matrix3 TMP_M3 = new Matrix3();
/* 36 */   protected static final Matrix4 TMP_M4 = new Matrix4();
/*    */ 
/*    */   
/*    */   protected ParticleController controller;
/*    */ 
/*    */ 
/*    */   
/*    */   public void activateParticles(int paramInt1, int paramInt2) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void killParticles(int paramInt1, int paramInt2) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void update() {}
/*    */ 
/*    */   
/*    */   public void init() {}
/*    */ 
/*    */   
/*    */   public void start() {}
/*    */ 
/*    */   
/*    */   public void end() {}
/*    */ 
/*    */   
/*    */   public void dispose() {}
/*    */ 
/*    */   
/*    */   public abstract ParticleControllerComponent copy();
/*    */ 
/*    */   
/*    */   public void allocateChannels() {}
/*    */ 
/*    */   
/*    */   public void set(ParticleController paramParticleController) {
/* 73 */     this.controller = paramParticleController;
/*    */   }
/*    */   
/*    */   public void save(AssetManager paramAssetManager, ResourceData paramResourceData) {}
/*    */   
/*    */   public void load(AssetManager paramAssetManager, ResourceData paramResourceData) {}
/*    */   
/*    */   public void write(Json paramJson) {}
/*    */   
/*    */   public void read(Json paramJson, JsonValue paramJsonValue) {}
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\ParticleControllerComponent.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */