/*     */ package com.prineside.tdi2.miners;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameValueProvider;
/*     */ import com.prineside.tdi2.Miner;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.MinerType;
/*     */ import com.prineside.tdi2.enums.ResourceType;
/*     */ import com.prineside.tdi2.systems.MapRenderingSystem;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ 
/*     */ 
/*     */ @REGS
/*     */ public class VectorMiner
/*     */   extends Miner
/*     */ {
/*  21 */   private static final int[] a = new int[] { 170, 500, 1200, 1750, 2300, 3100, 4300, 5700, 7200, 9600 };
/*     */ 
/*     */ 
/*     */   
/*     */   @NAGS
/*  26 */   private float b = 0.0F;
/*     */   
/*     */   private VectorMiner() {
/*  29 */     super(MinerType.VECTOR);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getBaseUpgradePrice(int paramInt) {
/*  34 */     return a[paramInt - 1];
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawBatch(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, MapRenderingSystem.DrawMode paramDrawMode) {
/*  39 */     float f = paramFloat3 / 128.0F;
/*     */ 
/*     */     
/*  42 */     if (isPrepared() && this.nextMinedResourceType != null) {
/*  43 */       float f1 = getCurrentMiningSpeedFromSystem() * 120.0F;
/*  44 */       if (this.doubleSpeedTimeLeft > 0.0F) {
/*  45 */         f1 *= 2.0F;
/*     */       }
/*  47 */       this.b = (this.b + paramFloat4 * f1) % 360.0F;
/*     */     } else {
/*  49 */       this.b = 0.0F;
/*     */     } 
/*     */     
/*  52 */     paramBatch.draw(Game.i.minerManager.F.VECTOR.a, paramFloat1 + 15.0F * f, paramFloat2 + 15.0F * f, 29.0F * f, 29.0F * f, 58.0F * f, 58.0F * f, 1.0F, 1.0F, this.b);
/*  53 */     paramBatch.draw(Game.i.minerManager.F.VECTOR.a, paramFloat1 + 55.0F * f, paramFloat2 + 55.0F * f, 29.0F * f, 29.0F * f, 58.0F * f, 58.0F * f, 1.0F, 1.0F, this.b);
/*  54 */     paramBatch.draw(Game.i.minerManager.F.VECTOR.a, paramFloat1 + 15.0F * f, paramFloat2 + 55.0F * f, 29.0F * f, 29.0F * f, 58.0F * f, 58.0F * f, 1.0F, 1.0F, this.b + 90.0F);
/*  55 */     paramBatch.draw(Game.i.minerManager.F.VECTOR.a, paramFloat1 + 55.0F * f, paramFloat2 + 15.0F * f, 29.0F * f, 29.0F * f, 58.0F * f, 58.0F * f, 1.0F, 1.0F, this.b + 90.0F);
/*     */ 
/*     */     
/*  58 */     a(paramBatch, paramFloat1 + paramFloat3 * 0.5F, paramFloat2 + paramFloat3 * 0.5F, f, paramDrawMode);
/*     */ 
/*     */     
/*  61 */     b(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramDrawMode);
/*     */   }
/*     */   
/*     */   public static class VectorMinerFactory extends Miner.Factory<VectorMiner> {
/*     */     TextureRegion a;
/*     */     private TextureRegion b;
/*     */     
/*     */     public VectorMinerFactory() {
/*  69 */       super(MinerType.VECTOR, "miner-vector");
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getTexture() {
/*  74 */       return this.b;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getBaseBuildPrice(GameValueProvider param1GameValueProvider) {
/*  79 */       return 140;
/*     */     }
/*     */ 
/*     */     
/*     */     public float getBaseMiningSpeed(GameValueProvider param1GameValueProvider) {
/*  84 */       return (float)(8.699999809265137D * param1GameValueProvider.getPercentValueAsMultiplierSum(GameValueType.MINERS_SPEED, GameValueType.MINER_VECTOR_SPEED));
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean canMineResource(ResourceType param1ResourceType) {
/*  89 */       return (param1ResourceType.ordinal() <= ResourceType.VECTOR.ordinal());
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/*  94 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("miner-vector-blade");
/*  95 */       this.b = (TextureRegion)Game.i.assetManager.getTextureRegion("miner-vector-base");
/*     */     }
/*     */ 
/*     */     
/*     */     public VectorMiner create() {
/* 100 */       return new VectorMiner((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\miners\VectorMiner.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */