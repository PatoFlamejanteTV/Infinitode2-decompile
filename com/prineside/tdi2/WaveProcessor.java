/*    */ package com.prineside.tdi2;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g2d.Batch;
/*    */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.prineside.tdi2.enums.BossType;
/*    */ import com.prineside.tdi2.utils.REGS;
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
/*    */ @REGS(classOnly = true)
/*    */ public interface WaveProcessor
/*    */ {
/*    */   Array<EnemyGroup> generateEnemyGroups(int paramInt1, int paramInt2);
/*    */   
/*    */   Wave setup(GameSystemProvider paramGameSystemProvider, int paramInt1, int paramInt2);
/*    */   
/*    */   void update(float paramFloat);
/*    */   
/*    */   void draw(Batch paramBatch, float paramFloat);
/*    */   
/*    */   boolean isDone();
/*    */   
/*    */   default float getNextWaveDelayMultiplier() {
/* 35 */     return 7.0F;
/*    */   }
/*    */   
/*    */   public static abstract class WaveProcessorFactory<T extends WaveProcessor>
/*    */   {
/*    */     public final BossType bossType;
/*    */     private TextureRegion a;
/*    */     
/*    */     public WaveProcessorFactory(BossType param1BossType) {
/* 44 */       this.bossType = param1BossType;
/*    */     }
/*    */     
/*    */     public void setup() {
/* 48 */       if (Game.i.assetManager != null) {
/* 49 */         this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("boss-wave-icon-" + this.bossType.name());
/*    */       }
/*    */     }
/*    */     
/*    */     public abstract T create();
/*    */     
/*    */     public TextureRegion getIconTexture() {
/* 56 */       return this.a;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\WaveProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */