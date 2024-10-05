/*    */ package com.prineside.tdi2.enemies;
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.badlogic.gdx.graphics.g2d.Batch;
/*    */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*    */ import com.badlogic.gdx.math.Vector2;
/*    */ import com.prineside.tdi2.Enemy;
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.enums.BuffType;
/*    */ import com.prineside.tdi2.enums.EnemyType;
/*    */ import com.prineside.tdi2.utils.MaterialColor;
/*    */ import com.prineside.tdi2.utils.NAGS;
/*    */ import com.prineside.tdi2.utils.PMath;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public final class JetEnemy extends Enemy {
/*    */   @NAGS
/* 18 */   private float a = 0.0F; @NAGS
/* 19 */   private final Vector2 b = new Vector2();
/*    */   
/*    */   private JetEnemy() {
/* 22 */     super(EnemyType.JET);
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean hasDrawPriority() {
/* 27 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public final float getBuffedSpeed() {
/* 32 */     float f = super.getBuffedSpeed();
/*    */     
/* 34 */     if (this.buffsAppliedByType != null && this.buffsAppliedByType[BuffType.BURN.ordinal()]) {
/* 35 */       f *= 0.65F;
/*    */     }
/*    */     
/* 38 */     return f;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void drawBatch(Batch paramBatch, float paramFloat) {
/* 43 */     this.a += paramFloat;
/*    */ 
/*    */     
/* 46 */     super.drawBatch(paramBatch, paramFloat);
/*    */ 
/*    */     
/* 49 */     paramFloat = 0.8F + PMath.sin(this.a / 0.15F) * 0.2F;
/* 50 */     float f = 0.9F + PMath.sin((this.a + 0.25F) / 0.15F) * 0.1F;
/* 51 */     this.b.x = this.drawPosition.x;
/* 52 */     this.b.y = this.drawPosition.y;
/* 53 */     PMath.shiftPointByAngle(this.b, this.drawAngle - 180.0F, 16.0F);
/* 54 */     PMath.shiftPointByAngle(this.b, this.drawAngle + 90.0F, 16.0F * f);
/* 55 */     paramBatch.draw(Game.i.enemyManager.F.JET.a, this.b.x, this.b.y, 0.0F, 0.0F, 64.0F * paramFloat, 32.0F * f, 1.0F, 1.0F, this.drawAngle - 90.0F);
/*    */   }
/*    */   
/*    */   public static class JetEnemyFactory
/*    */     extends Enemy.Factory<JetEnemy> {
/*    */     private TextureRegion b;
/*    */     TextureRegion a;
/*    */     private TextureRegion c;
/*    */     private TextureRegion d;
/*    */     
/*    */     public JetEnemyFactory() {
/* 66 */       super(EnemyType.JET);
/*    */     }
/*    */ 
/*    */     
/*    */     public void setupAssets() {
/* 71 */       this.b = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-jet");
/* 72 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("jet-thrust");
/* 73 */       this.c = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-jet-hl");
/* 74 */       this.d = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-jet-emj");
/*    */     }
/*    */ 
/*    */     
/*    */     public TextureRegion getTexture() {
/* 79 */       return this.b;
/*    */     }
/*    */ 
/*    */     
/*    */     public TextureRegion getHighlightTexture() {
/* 84 */       return this.c;
/*    */     }
/*    */ 
/*    */     
/*    */     public TextureRegion getEmojiTexture() {
/* 89 */       return this.d;
/*    */     }
/*    */ 
/*    */     
/*    */     public JetEnemy create() {
/* 94 */       return new JetEnemy((byte)0);
/*    */     }
/*    */ 
/*    */     
/*    */     public Color getColor() {
/* 99 */       return MaterialColor.LIGHT_BLUE.P500;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enemies\JetEnemy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */