/*    */ package com.prineside.tdi2.miners;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g2d.Batch;
/*    */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.GameValueProvider;
/*    */ import com.prineside.tdi2.Miner;
/*    */ import com.prineside.tdi2.enums.GameValueType;
/*    */ import com.prineside.tdi2.enums.MinerType;
/*    */ import com.prineside.tdi2.enums.ResourceType;
/*    */ import com.prineside.tdi2.systems.MapRenderingSystem;
/*    */ import com.prineside.tdi2.utils.NAGS;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ 
/*    */ 
/*    */ @REGS
/*    */ public class ScalarMiner
/*    */   extends Miner
/*    */ {
/* 21 */   private static final int[] a = new int[] { 150, 400, 1000, 1500, 2100, 2800, 3700, 4800, 6000, 8000 };
/*    */ 
/*    */ 
/*    */   
/*    */   @NAGS
/* 26 */   private float b = 0.0F;
/*    */   
/*    */   private ScalarMiner() {
/* 29 */     super(MinerType.SCALAR);
/*    */   }
/*    */ 
/*    */   
/*    */   public int getBaseUpgradePrice(int paramInt) {
/* 34 */     return a[paramInt - 1];
/*    */   }
/*    */ 
/*    */   
/*    */   public void drawBatch(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, MapRenderingSystem.DrawMode paramDrawMode) {
/* 39 */     float f = paramFloat3 / 128.0F;
/*    */ 
/*    */     
/* 42 */     if (isPrepared() && this.nextMinedResourceType != null) {
/* 43 */       float f1 = getCurrentMiningSpeedFromSystem() * 120.0F;
/* 44 */       if (this.doubleSpeedTimeLeft > 0.0F) {
/* 45 */         f1 *= 2.0F;
/*    */       }
/* 47 */       this.b = (this.b + paramFloat4 * f1) % 360.0F;
/*    */     } else {
/* 49 */       this.b = 0.0F;
/*    */     } 
/* 51 */     paramBatch.draw(Game.i.minerManager.F.SCALAR.a, paramFloat1 + 15.0F * f, paramFloat2 + 15.0F * f, 29.0F * f, 29.0F * f, 58.0F * f, 58.0F * f, 1.0F, 1.0F, this.b);
/* 52 */     paramBatch.draw(Game.i.minerManager.F.SCALAR.a, paramFloat1 + 55.0F * f, paramFloat2 + 55.0F * f, 29.0F * f, 29.0F * f, 58.0F * f, 58.0F * f, 1.0F, 1.0F, this.b);
/*    */ 
/*    */     
/* 55 */     a(paramBatch, paramFloat1 + paramFloat3 * 0.5F, paramFloat2 + paramFloat3 * 0.5F, f, paramDrawMode);
/*    */ 
/*    */     
/* 58 */     b(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramDrawMode);
/*    */   }
/*    */   
/*    */   public static class ScalarMinerFactory extends Miner.Factory<ScalarMiner> {
/*    */     TextureRegion a;
/*    */     private TextureRegion b;
/*    */     
/*    */     public ScalarMinerFactory() {
/* 66 */       super(MinerType.SCALAR, "miner-scalar");
/*    */     }
/*    */ 
/*    */     
/*    */     public int getBaseBuildPrice(GameValueProvider param1GameValueProvider) {
/* 71 */       return 120;
/*    */     }
/*    */ 
/*    */     
/*    */     public float getBaseMiningSpeed(GameValueProvider param1GameValueProvider) {
/* 76 */       return (float)(10.0D * param1GameValueProvider.getPercentValueAsMultiplierSum(GameValueType.MINERS_SPEED, GameValueType.MINER_SCALAR_SPEED));
/*    */     }
/*    */ 
/*    */     
/*    */     public boolean canMineResource(ResourceType param1ResourceType) {
/* 81 */       return (param1ResourceType == ResourceType.SCALAR);
/*    */     }
/*    */ 
/*    */     
/*    */     public void setupAssets() {
/* 86 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("miner-scalar-blade");
/* 87 */       this.b = (TextureRegion)Game.i.assetManager.getTextureRegion("miner-scalar-base");
/*    */     }
/*    */ 
/*    */     
/*    */     public TextureRegion getTexture() {
/* 92 */       return this.b;
/*    */     }
/*    */ 
/*    */     
/*    */     public ScalarMiner create() {
/* 97 */       return new ScalarMiner((byte)0);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\miners\ScalarMiner.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */