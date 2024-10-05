/*    */ package com.prineside.tdi2.ui.actors;
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.badlogic.gdx.graphics.g2d.Batch;
/*    */ import com.badlogic.gdx.graphics.g2d.NinePatch;
/*    */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*    */ import com.badlogic.gdx.math.Interpolation;
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.managers.AssetManager;
/*    */ import com.prineside.tdi2.managers.UiManager;
/*    */ import com.prineside.tdi2.scene2d.Action;
/*    */ import com.prineside.tdi2.scene2d.Actor;
/*    */ import com.prineside.tdi2.scene2d.Touchable;
/*    */ import com.prineside.tdi2.scene2d.actions.Actions;
/*    */ import com.prineside.tdi2.scene2d.ui.Image;
/*    */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*    */ 
/*    */ public class ScreenBorderGradient implements Disposable {
/* 18 */   private final UiManager.UiLayer a = Game.i.uiManager.addLayerIgnoreSafeArea(UiManager.MainUiLayer.SCREEN, 100, "ScreenBorderGradient", true);
/* 19 */   private final UiManager.UiLayer b = Game.i.uiManager.addLayerIgnoreSafeArea(UiManager.MainUiLayer.SCREEN, 101, "ScreenBorderGradient - full screen", true);
/*    */   
/*    */   private NinePatch c;
/*    */   private Image d;
/*    */   private Image e;
/*    */   private Color f;
/* 25 */   private Color g = new Color(0.0F, 0.0F, 0.0F, 0.0F);
/*    */   
/*    */   public ScreenBorderGradient() {
/* 28 */     AssetManager assetManager = Game.i.assetManager;
/* 29 */     this.f = assetManager.getColor("screen_border_gradient_normal");
/*    */     
/* 31 */     this
/*    */ 
/*    */       
/* 34 */       .c = new NinePatch(new TextureRegion[] { (TextureRegion)assetManager.getTextureRegion("ui-screen-border-0"), (TextureRegion)assetManager.getTextureRegion("ui-screen-border-1"), (TextureRegion)assetManager.getTextureRegion("ui-screen-border-2"), (TextureRegion)assetManager.getTextureRegion("ui-screen-border-3"), null, (TextureRegion)assetManager.getTextureRegion("ui-screen-border-5"), (TextureRegion)assetManager.getTextureRegion("ui-screen-border-6"), (TextureRegion)assetManager.getTextureRegion("ui-screen-border-7"), (TextureRegion)assetManager.getTextureRegion("ui-screen-border-8") });
/*    */ 
/*    */     
/* 37 */     this.d = new Image((Drawable)new BaseDrawable(this)
/*    */         {
/*    */           public void draw(Batch param1Batch, float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
/* 40 */             ScreenBorderGradient.b(this.a).setColor(ScreenBorderGradient.a(this.a).getColor());
/* 41 */             ScreenBorderGradient.b(this.a).draw(param1Batch, param1Float1, param1Float2, 0.0F, 0.0F, param1Float3, param1Float4, 1.0F, 1.0F, 0.0F);
/*    */           }
/*    */         });
/* 44 */     this.d.setColor(this.f);
/* 45 */     this.a.getTable().add((Actor)this.d).expand().fill();
/* 46 */     this.a.getTable().setTouchable(Touchable.disabled);
/*    */     
/* 48 */     this.e = new Image(this, (Drawable)Game.i.assetManager.getDrawable("blank"))
/*    */       {
/*    */         public void draw(Batch param1Batch, float param1Float) {
/* 51 */           if ((ScreenBorderGradient.c(this.j).getColor()).a > 0.0F) {
/* 52 */             param1Batch.flush();
/* 53 */             param1Batch.setBlendFunction(770, 1);
/* 54 */             super.draw(param1Batch, param1Float);
/* 55 */             param1Batch.flush();
/* 56 */             param1Batch.setBlendFunction(770, 771);
/*    */           } 
/*    */         }
/*    */       };
/* 60 */     this.e.setColor(0.0F, 0.0F, 0.0F, 0.0F);
/* 61 */     this.b.getTable().add((Actor)this.e).expand().fill();
/* 62 */     this.b.getTable().setTouchable(Touchable.disabled);
/*    */   }
/*    */   
/*    */   public void flash(Color paramColor, float paramFloat) {
/* 66 */     this.d.clearActions();
/* 67 */     this.d.addAction((Action)Actions.sequence(
/* 68 */           (Action)Actions.color(paramColor, paramFloat * 0.1F), 
/* 69 */           (Action)Actions.color(this.f, paramFloat * 0.9F)));
/*    */   }
/*    */ 
/*    */   
/*    */   public void fullscreenFlash(Color paramColor, float paramFloat, Interpolation paramInterpolation) {
/* 74 */     this.e.clearActions();
/* 75 */     this.e.addAction((Action)Actions.sequence(
/* 76 */           (Action)Actions.color(paramColor, paramFloat * 0.05F), 
/* 77 */           (Action)Actions.color(this.g, paramFloat * 0.95F, paramInterpolation)));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void dispose() {
/* 83 */     Game.i.uiManager.removeLayer(this.a);
/* 84 */     Game.i.uiManager.removeLayer(this.b);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\actors\ScreenBorderGradient.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */