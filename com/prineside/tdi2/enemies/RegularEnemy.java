/*    */ package com.prineside.tdi2.enemies;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*    */ import com.prineside.tdi2.Enemy;
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.enums.EnemyType;
/*    */ import com.prineside.tdi2.enums.TowerType;
/*    */ import com.prineside.tdi2.utils.MaterialColor;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public final class RegularEnemy extends Enemy {
/*    */   private RegularEnemy() {
/* 15 */     super(EnemyType.REGULAR);
/*    */   }
/*    */ 
/*    */   
/*    */   public final float getTowerDamageMultiplier(TowerType paramTowerType) {
/* 20 */     return super.getTowerDamageMultiplier(paramTowerType);
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean hasDrawPriority() {
/* 25 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static class RegularEnemyFactory
/*    */     extends Enemy.Factory<RegularEnemy>
/*    */   {
/*    */     private TextureRegion a;
/*    */     
/*    */     private TextureRegion b;
/*    */     
/*    */     private TextureRegion c;
/*    */ 
/*    */     
/*    */     public RegularEnemyFactory() {
/* 41 */       super(EnemyType.REGULAR);
/*    */     }
/*    */ 
/*    */     
/*    */     public void setupAssets() {
/* 46 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-regular");
/* 47 */       this.c = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-regular-hl");
/* 48 */       this.b = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-regular-emj");
/*    */     }
/*    */ 
/*    */     
/*    */     public TextureRegion getTexture() {
/* 53 */       return this.a;
/*    */     }
/*    */ 
/*    */     
/*    */     public TextureRegion getHighlightTexture() {
/* 58 */       return this.c;
/*    */     }
/*    */ 
/*    */     
/*    */     public TextureRegion getEmojiTexture() {
/* 63 */       return this.b;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public RegularEnemy create() {
/* 69 */       return new RegularEnemy((byte)0);
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public Color getColor() {
/* 79 */       return MaterialColor.GREEN.P500;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enemies\RegularEnemy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */