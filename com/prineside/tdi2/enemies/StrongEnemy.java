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
/*    */ public final class StrongEnemy extends Enemy {
/*    */   private StrongEnemy() {
/* 14 */     super(EnemyType.STRONG);
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean hasDrawPriority() {
/* 19 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public static class StrongEnemyFactory
/*    */     extends Enemy.Factory<StrongEnemy>
/*    */   {
/*    */     private TextureRegion a;
/*    */     
/*    */     private TextureRegion b;
/*    */     
/*    */     private TextureRegion c;
/*    */     
/*    */     public StrongEnemyFactory() {
/* 33 */       super(EnemyType.STRONG);
/*    */     }
/*    */ 
/*    */     
/*    */     public void setupAssets() {
/* 38 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-strong");
/* 39 */       this.b = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-strong-hl");
/* 40 */       this.c = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-strong-emj");
/*    */     }
/*    */ 
/*    */     
/*    */     public TextureRegion getTexture() {
/* 45 */       return this.a;
/*    */     }
/*    */ 
/*    */     
/*    */     public TextureRegion getHighlightTexture() {
/* 50 */       return this.b;
/*    */     }
/*    */ 
/*    */     
/*    */     public TextureRegion getEmojiTexture() {
/* 55 */       return this.c;
/*    */     }
/*    */ 
/*    */     
/*    */     public StrongEnemy create() {
/* 60 */       return new StrongEnemy((byte)0);
/*    */     }
/*    */ 
/*    */     
/*    */     public Color getColor() {
/* 65 */       return MaterialColor.DEEP_ORANGE.P500;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enemies\StrongEnemy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */