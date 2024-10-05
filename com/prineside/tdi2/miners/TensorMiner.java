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
/*    */ public class TensorMiner
/*    */   extends Miner
/*    */ {
/* 21 */   private static final int[] a = new int[] { 240, 750, 1800, 2400, 2900, 4000, 5800, 7400, 9500, 12500 };
/*    */ 
/*    */ 
/*    */   
/*    */   @NAGS
/* 26 */   private float b = 0.0F;
/*    */   
/*    */   private TensorMiner() {
/* 29 */     super(MinerType.TENSOR);
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
/* 51 */     paramBatch.draw(Game.i.minerManager.F.TENSOR.a, paramFloat1, paramFloat2 + 34.0F * f, 30.0F * f, 30.0F * f, 60.0F * f, 60.0F * f, 1.0F, 1.0F, this.b);
/* 52 */     paramBatch.draw(Game.i.minerManager.F.TENSOR.a, paramFloat1 + 68.0F * f, paramFloat2 + 34.0F * f, 30.0F * f, 30.0F * f, 60.0F * f, 60.0F * f, 1.0F, 1.0F, this.b);
/* 53 */     paramBatch.draw(Game.i.minerManager.F.TENSOR.a, paramFloat1 + 34.0F * f, paramFloat2, 30.0F * f, 30.0F * f, 60.0F * f, 60.0F * f, 1.0F, 1.0F, this.b + 90.0F);
/* 54 */     paramBatch.draw(Game.i.minerManager.F.TENSOR.a, paramFloat1 + 34.0F * f, paramFloat2 + 68.0F * f, 30.0F * f, 30.0F * f, 60.0F * f, 60.0F * f, 1.0F, 1.0F, this.b + 90.0F);
/*    */ 
/*    */     
/* 57 */     a(paramBatch, paramFloat1 + paramFloat3 * 0.5F, paramFloat2 + paramFloat3 * 0.5F, f, paramDrawMode);
/*    */ 
/*    */     
/* 60 */     b(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramDrawMode);
/*    */   }
/*    */   
/*    */   public static class TensorMinerFactory extends Miner.Factory<TensorMiner> {
/*    */     TextureRegion a;
/*    */     private TextureRegion b;
/*    */     
/*    */     public TensorMinerFactory() {
/* 68 */       super(MinerType.TENSOR, "miner-tensor");
/*    */     }
/*    */ 
/*    */     
/*    */     public int getBaseBuildPrice(GameValueProvider param1GameValueProvider) {
/* 73 */       return 185;
/*    */     }
/*    */ 
/*    */     
/*    */     public float getBaseMiningSpeed(GameValueProvider param1GameValueProvider) {
/* 78 */       return (float)(6.0D * param1GameValueProvider.getPercentValueAsMultiplierSum(GameValueType.MINERS_SPEED, GameValueType.MINER_TENSOR_SPEED));
/*    */     }
/*    */ 
/*    */     
/*    */     public boolean canMineResource(ResourceType param1ResourceType) {
/* 83 */       return (param1ResourceType.ordinal() <= ResourceType.TENSOR.ordinal());
/*    */     }
/*    */ 
/*    */     
/*    */     public void setupAssets() {
/* 88 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("miner-tensor-blade");
/* 89 */       this.b = (TextureRegion)Game.i.assetManager.getTextureRegion("miner-tensor-base");
/*    */     }
/*    */ 
/*    */     
/*    */     public TextureRegion getTexture() {
/* 94 */       return this.b;
/*    */     }
/*    */ 
/*    */     
/*    */     public TensorMiner create() {
/* 99 */       return new TensorMiner((byte)0);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\miners\TensorMiner.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */