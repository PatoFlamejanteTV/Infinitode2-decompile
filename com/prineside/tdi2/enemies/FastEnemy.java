/*    */ package com.prineside.tdi2.enemies;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*    */ import com.prineside.tdi2.Enemy;
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.enums.BuffType;
/*    */ import com.prineside.tdi2.enums.EnemyType;
/*    */ import com.prineside.tdi2.utils.MaterialColor;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public final class FastEnemy extends Enemy {
/*    */   private FastEnemy() {
/* 15 */     super(EnemyType.FAST);
/*    */   }
/*    */ 
/*    */   
/*    */   public final float getBuffedSpeed() {
/* 20 */     float f = 1.0F;
/* 21 */     if (this.buffsByType != null) {
/* 22 */       f = 1.0F - (this.buffsByType[BuffType.POISON.ordinal()]).size * 0.07F;
/*    */     }
/* 24 */     if (f < 0.25F) f = 0.25F;
/*    */     
/* 26 */     return super.getBuffedSpeed() * f;
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean hasDrawPriority() {
/* 31 */     return false;
/*    */   }
/*    */   
/*    */   public static class FastEnemyFactory extends Enemy.Factory<FastEnemy> {
/*    */     private TextureRegion a;
/*    */     private TextureRegion b;
/*    */     private TextureRegion c;
/*    */     
/*    */     public FastEnemyFactory() {
/* 40 */       super(EnemyType.FAST);
/*    */     }
/*    */ 
/*    */     
/*    */     public void setupAssets() {
/* 45 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-fast");
/* 46 */       this.b = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-fast-hl");
/* 47 */       this.c = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-fast-emj");
/*    */     }
/*    */ 
/*    */     
/*    */     public TextureRegion getTexture() {
/* 52 */       return this.a;
/*    */     }
/*    */ 
/*    */     
/*    */     public TextureRegion getHighlightTexture() {
/* 57 */       return this.b;
/*    */     }
/*    */ 
/*    */     
/*    */     public TextureRegion getEmojiTexture() {
/* 62 */       return this.c;
/*    */     }
/*    */ 
/*    */     
/*    */     public FastEnemy create() {
/* 67 */       return new FastEnemy((byte)0);
/*    */     }
/*    */ 
/*    */     
/*    */     public Color getColor() {
/* 72 */       return MaterialColor.AMBER.P500;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enemies\FastEnemy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */