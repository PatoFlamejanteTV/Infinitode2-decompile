/*    */ package com.prineside.tdi2.utils.mapeditor.tools;
/*    */ 
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.GameSystemProvider;
/*    */ import com.prineside.tdi2.Gate;
/*    */ import com.prineside.tdi2.Tile;
/*    */ import com.prineside.tdi2.events.Event;
/*    */ import com.prineside.tdi2.events.Listener;
/*    */ import com.prineside.tdi2.events.game.MouseClick;
/*    */ import com.prineside.tdi2.scene2d.Actor;
/*    */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*    */ import com.prineside.tdi2.systems.MapEditorSystem;
/*    */ import com.prineside.tdi2.ui.components.MapEditorUi;
/*    */ import com.prineside.tdi2.utils.mapeditor.Selection;
/*    */ 
/*    */ public class View
/*    */   implements Listener<MouseClick>, MapEditorSystem.Tool {
/*    */   private GameSystemProvider a;
/*    */   private MapEditorUi.ToolButton b;
/*    */   
/*    */   public void setup(GameSystemProvider paramGameSystemProvider) {
/* 23 */     this.a = paramGameSystemProvider;
/*    */     
/* 25 */     this.b = new MapEditorUi.ToolButton((Drawable)Game.i.assetManager.getQuad("mapeditor.tools.view"), () -> paramGameSystemProvider._mapEditor.selectTool(this), null);
/* 26 */     paramGameSystemProvider._mapEditorUi.mainUi.addToolButton(this.b);
/*    */   }
/*    */ 
/*    */   
/*    */   public MapEditorUi.PreparedTooltip getTooltip() {
/* 31 */     return new MapEditorUi.PreparedTooltip("map_editor_tool_view", (Actor)this.b, Game.i.localeManager.i18n.get("map_editor_tooltip_view_tool"));
/*    */   }
/*    */ 
/*    */   
/*    */   public void enabled(MapEditorSystem.Tool paramTool) {
/* 36 */     this.b.setActive(true);
/* 37 */     this.a.events.getListeners(MouseClick.class).add(this).setDescription("Tool.View");
/*    */   }
/*    */ 
/*    */   
/*    */   public void disabled() {
/* 42 */     this.b.setActive(false);
/* 43 */     this.a.events.getListeners(MouseClick.class).remove(this);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void handleEvent(MouseClick paramMouseClick) {
/*    */     Selection selection;
/* 50 */     if ((selection = this.a._mapEditor.selection).isFromInventory()) {
/* 51 */       this.a._mapEditor.deselectAll();
/* 52 */       selection.setFromInventory(false);
/*    */     } 
/*    */     
/*    */     boolean bool;
/* 56 */     if (!(bool = Gdx.input.isKeyPressed(129))) {
/* 57 */       this.a._mapEditor.deselectAll();
/*    */     }
/*    */     
/*    */     Gate gate;
/* 61 */     if ((gate = this.a.map.getMap().getGateByMapPos(paramMouseClick.getMapX(), paramMouseClick.getMapY())) != null) {
/* 62 */       if (bool && selection.gates.contains(gate, true)) {
/* 63 */         selection.gates.removeValue(gate, true);
/*    */       } else {
/* 65 */         selection.gates.add(gate);
/*    */       } 
/*    */     } else {
/*    */       Tile tile;
/* 69 */       if ((tile = this.a.map.getMap().getTileByMapPos(paramMouseClick.getMapX(), paramMouseClick.getMapY())) != null) {
/* 70 */         if (bool && selection.containsTile(tile)) {
/* 71 */           selection.removeTile(tile);
/*    */         } else {
/* 73 */           selection.addTile(tile);
/*    */         } 
/*    */       }
/*    */     } 
/* 77 */     this.a._mapEditor.notifySelectionChanged();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\mapeditor\tools\View.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */