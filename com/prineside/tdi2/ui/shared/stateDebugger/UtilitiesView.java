/*    */ package com.prineside.tdi2.ui.shared.stateDebugger;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.prineside.tdi2.CameraController;
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.GameSystemProvider;
/*    */ import com.prineside.tdi2.scene2d.Actor;
/*    */ import com.prineside.tdi2.ui.actors.Label;
/*    */ import com.prineside.tdi2.ui.actors.TableButton;
/*    */ import com.prineside.tdi2.ui.shared.Notifications;
/*    */ import com.prineside.tdi2.ui.shared.StateDebugger;
/*    */ import com.prineside.tdi2.utils.MaterialColor;
/*    */ 
/*    */ public class UtilitiesView
/*    */   implements StateDebugger.View {
/*    */   public String getId() {
/* 17 */     return "UTILITIES";
/*    */   }
/*    */ 
/*    */   
/*    */   public String getName() {
/* 22 */     return "Utils";
/*    */   }
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
/*    */   public void rebuildWindow() {
/*    */     TableButton tableButton;
/* 39 */     (tableButton = new TableButton(() -> { GameSystemProvider gameSystemProvider; if ((gameSystemProvider = StateDebugger.i().getCurrentSystemProvider()) != null) { CameraController cameraController; (cameraController = gameSystemProvider._input.getCameraController()).hardZoomLimits = true; cameraController.hardMinZoom = 0.1D; cameraController.hardMaxZoom = 16.0D; cameraController.updateMinMaxZoom(); Notifications.i().addSuccess("Extra zoom enabled"); }  })).add((Actor)new Label("Extra zoom", Game.i.assetManager.getLabelStyle(18)));
/* 40 */     tableButton.setContentColors(MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P300, MaterialColor.LIGHT_BLUE.P700, Color.WHITE);
/* 41 */     (StateDebugger.i()).contentTable.add((Actor)tableButton).height(32.0F).growX().row();
/*    */   }
/*    */   
/*    */   public void init() {}
/*    */   
/*    */   public void postInit() {}
/*    */   
/*    */   public void onShow() {}
/*    */   
/*    */   public void onHide() {}
/*    */   
/*    */   public void onRender() {}
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\stateDebugger\UtilitiesView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */