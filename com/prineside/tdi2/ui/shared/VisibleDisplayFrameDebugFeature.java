/*    */ package com.prineside.tdi2.ui.shared;
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.badlogic.gdx.math.Vector2;
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.managers.UiManager;
/*    */ import com.prineside.tdi2.scene2d.InputEvent;
/*    */ import com.prineside.tdi2.scene2d.InputListener;
/*    */ import com.prineside.tdi2.scene2d.Touchable;
/*    */ import com.prineside.tdi2.scene2d.ui.Cell;
/*    */ import com.prineside.tdi2.scene2d.ui.Image;
/*    */ import com.prineside.tdi2.utils.logging.TLog;
/*    */ 
/*    */ public class VisibleDisplayFrameDebugFeature extends UiManager.UiComponent.Adapter {
/*    */   static {
/* 15 */     TLog.forClass(VisibleDisplayFrameDebugFeature.class);
/*    */   }
/*    */   public static VisibleDisplayFrameDebugFeature i() {
/* 18 */     return (VisibleDisplayFrameDebugFeature)Game.i.uiManager.getComponent(VisibleDisplayFrameDebugFeature.class);
/*    */   }
/*    */   
/* 21 */   private final UiManager.UiLayer a = Game.i.uiManager.addLayerIgnoreSafeArea(UiManager.MainUiLayer.OVERLAY, 70001, "VisibleDisplayFrameDebugFeature", true);
/*    */   
/*    */   private Image b;
/*    */   private Cell<?> c;
/*    */   
/*    */   public VisibleDisplayFrameDebugFeature() {
/* 27 */     this.a.ignoreVisibleFrame = true;
/*    */     
/* 29 */     this.b = new Image((Drawable)Game.i.assetManager.getDrawable("blank"));
/* 30 */     this.b.setTouchable(Touchable.enabled);
/* 31 */     this.b.addListener((EventListener)new InputListener(this)
/*    */         {
/*    */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/* 34 */             return true;
/*    */           }
/*    */ 
/*    */ 
/*    */ 
/*    */           
/*    */           public void touchUp(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {}
/*    */ 
/*    */ 
/*    */           
/*    */           public void touchDragged(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int) {
/* 45 */             if ((param1Float1 = param1InputEvent.getStageY()) < 0.0F) {
/* 46 */               param1Float1 = 0.0F;
/* 47 */             } else if (param1Float1 > param1InputEvent.getStage().getHeight() - 4.0F) {
/* 48 */               param1Float1 = param1InputEvent.getStage().getHeight() - 4.0F;
/*    */             } 
/* 50 */             VisibleDisplayFrameDebugFeature.a(this.a).padBottom(param1Float1);
/* 51 */             VisibleDisplayFrameDebugFeature.b(this.a).getTable().invalidateHierarchy();
/* 52 */             VisibleDisplayFrameDebugFeature.c(this.a);
/*    */           }
/*    */         });
/* 55 */     this.a.getTable().add().width(1.0F).growY().row();
/* 56 */     this.c = this.a.getTable().add((Actor)this.b).growX().height(4.0F).bottom().padBottom(600.0F);
/*    */     
/* 58 */     this.a.getTable().setVisible(false);
/*    */   }
/*    */   
/*    */   private void a() {
/* 62 */     Vector2 vector2 = this.b.localToScreenCoordinates(new Vector2());
/* 63 */     Game.i.notifyVisibleDisplayFrameChanged(0, 0, 0, Gdx.graphics.getHeight() - (int)vector2.y);
/*    */   }
/*    */ 
/*    */   
/*    */   public void hide() {
/* 68 */     this.a.getTable().setVisible(false);
/* 69 */     Game.i.notifyVisibleDisplayFrameChanged(0, 0, 0, 0);
/*    */   }
/*    */   
/*    */   public void show() {
/* 73 */     this.a.getTable().setVisible(true);
/* 74 */     a();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isPersistent() {
/* 79 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\VisibleDisplayFrameDebugFeature.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */