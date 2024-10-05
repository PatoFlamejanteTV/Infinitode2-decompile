/*    */ package com.prineside.tdi2.enemies;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*    */ import com.prineside.tdi2.Enemy;
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.enums.EnemyType;
/*    */ import com.prineside.tdi2.utils.MaterialColor;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public final class BossEnemy extends Enemy {
/*    */   private BossEnemy() {
/* 14 */     super(EnemyType.BOSS);
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean hasDrawPriority() {
/* 19 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public final float getBaseDamage() {
/* 24 */     return 50.0F;
/*    */   }
/*    */   
/*    */   public static class BossEnemyFactory extends Enemy.Factory<BossEnemy> {
/*    */     private TextureRegion a;
/*    */     
/*    */     public BossEnemyFactory() {
/* 31 */       super(EnemyType.BOSS);
/*    */     }
/*    */ 
/*    */     
/*    */     public TextureRegion getTexture() {
/* 36 */       return this.a;
/*    */     }
/*    */ 
/*    */     
/*    */     public TextureRegion getHighlightTexture() {
/* 41 */       return this.a;
/*    */     }
/*    */ 
/*    */     
/*    */     public void setupAssets() {
/* 46 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-boss");
/*    */     }
/*    */ 
/*    */     
/*    */     public BossEnemy create() {
/* 51 */       return new BossEnemy((byte)0);
/*    */     }
/*    */ 
/*    */     
/*    */     public Color getColor() {
/* 56 */       return MaterialColor.YELLOW.P500;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enemies\BossEnemy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */