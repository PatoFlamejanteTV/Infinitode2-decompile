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
/*    */ public class InfiarMiner
/*    */   extends Miner
/*    */ {
/* 21 */   private static final int[] a = new int[] { 250, 875, 1900, 2600, 3500, 5100, 6600, 8800, 11000, 14000 };
/*    */ 
/*    */ 
/*    */   
/*    */   @NAGS
/* 26 */   private float b = 0.0F;
/*    */   
/*    */   private InfiarMiner() {
/* 29 */     super(MinerType.INFIAR);
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
/* 51 */     paramBatch.draw(Game.i.minerManager.F.INFIAR.a, paramFloat1 + 6.0F * f, paramFloat2 + 6.0F * f, 58.0F * f, 58.0F * f, 116.0F * f, 116.0F * f, 1.0F, 1.0F, this.b);
/*    */ 
/*    */     
/* 54 */     a(paramBatch, paramFloat1 + paramFloat3 * 0.5F, paramFloat2 + paramFloat3 * 0.5F, f, paramDrawMode);
/*    */ 
/*    */     
/* 57 */     b(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramDrawMode);
/*    */   }
/*    */   
/*    */   public static class InfiarMinerFactory extends Miner.Factory<InfiarMiner> {
/*    */     TextureRegion a;
/*    */     private TextureRegion b;
/*    */     
/*    */     public InfiarMinerFactory() {
/* 65 */       super(MinerType.INFIAR, "miner-infiar");
/*    */     }
/*    */ 
/*    */     
/*    */     public float getBaseMiningSpeed(GameValueProvider param1GameValueProvider) {
/* 70 */       return (float)(4.5D * param1GameValueProvider.getPercentValueAsMultiplierSum(GameValueType.MINERS_SPEED, GameValueType.MINER_INFIAR_SPEED));
/*    */     }
/*    */ 
/*    */     
/*    */     public boolean canMineResource(ResourceType param1ResourceType) {
/* 75 */       return true;
/*    */     }
/*    */ 
/*    */     
/*    */     public int getBaseBuildPrice(GameValueProvider param1GameValueProvider) {
/* 80 */       return 200;
/*    */     }
/*    */ 
/*    */     
/*    */     public void setupAssets() {
/* 85 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("miner-infiar-blade");
/* 86 */       this.b = (TextureRegion)Game.i.assetManager.getTextureRegion("miner-infiar-base");
/*    */     }
/*    */ 
/*    */     
/*    */     public TextureRegion getTexture() {
/* 91 */       return this.b;
/*    */     }
/*    */ 
/*    */     
/*    */     public InfiarMiner create() {
/* 96 */       return new InfiarMiner((byte)0);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\miners\InfiarMiner.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */