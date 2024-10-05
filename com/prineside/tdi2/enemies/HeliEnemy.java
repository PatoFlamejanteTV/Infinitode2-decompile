/*    */ package com.prineside.tdi2.enemies;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.badlogic.gdx.graphics.g2d.Batch;
/*    */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*    */ import com.prineside.tdi2.Enemy;
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.enums.BuffType;
/*    */ import com.prineside.tdi2.enums.EnemyType;
/*    */ import com.prineside.tdi2.utils.MaterialColor;
/*    */ import com.prineside.tdi2.utils.NAGS;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public final class HeliEnemy
/*    */   extends Enemy {
/*    */   @NAGS
/* 18 */   private float a = 0.0F;
/*    */   
/*    */   private HeliEnemy() {
/* 21 */     super(EnemyType.HELI);
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean hasDrawPriority() {
/* 26 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public final float getBuffedSpeed() {
/* 31 */     float f = super.getBuffedSpeed();
/*    */     
/* 33 */     if (this.buffsAppliedByType != null && this.buffsAppliedByType[BuffType.BURN.ordinal()]) {
/* 34 */       f *= 0.65F;
/*    */     }
/*    */     
/* 37 */     return f;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void drawBatch(Batch paramBatch, float paramFloat) {
/* 42 */     this.a += paramFloat;
/* 43 */     float f = this.drawAngle;
/*    */     
/* 45 */     this.drawAngle = this.a % 0.5F / 0.5F * 360.0F;
/* 46 */     super.drawBatch(paramBatch, paramFloat);
/* 47 */     this.drawAngle = f;
/*    */   }
/*    */   
/*    */   public static class HeliEnemyFactory extends Enemy.Factory<HeliEnemy> {
/*    */     private TextureRegion a;
/*    */     private TextureRegion b;
/*    */     private TextureRegion c;
/*    */     
/*    */     public HeliEnemyFactory() {
/* 56 */       super(EnemyType.HELI);
/*    */     }
/*    */ 
/*    */     
/*    */     public void setupAssets() {
/* 61 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-heli");
/* 62 */       this.b = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-heli-hl");
/* 63 */       this.c = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-heli-emj");
/*    */     }
/*    */ 
/*    */     
/*    */     public TextureRegion getTexture() {
/* 68 */       return this.a;
/*    */     }
/*    */ 
/*    */     
/*    */     public TextureRegion getHighlightTexture() {
/* 73 */       return this.b;
/*    */     }
/*    */ 
/*    */     
/*    */     public TextureRegion getEmojiTexture() {
/* 78 */       return this.c;
/*    */     }
/*    */ 
/*    */     
/*    */     public HeliEnemy create() {
/* 83 */       return new HeliEnemy((byte)0);
/*    */     }
/*    */ 
/*    */     
/*    */     public Color getColor() {
/* 88 */       return MaterialColor.LIGHT_BLUE.P500;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enemies\HeliEnemy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */