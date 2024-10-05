/*     */ package com.prineside.tdi2.utils.mapeditor.tools;
/*     */ 
/*     */ import com.badlogic.gdx.InputAdapter;
/*     */ import com.badlogic.gdx.InputProcessor;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Gate;
/*     */ import com.prineside.tdi2.Map;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.systems.MapEditorSystem;
/*     */ import com.prineside.tdi2.ui.components.MapEditorUi;
/*     */ import com.prineside.tdi2.utils.InputMultiplexerExtended;
/*     */ 
/*     */ public class Remove implements MapEditorSystem.Tool {
/*     */   private GameSystemProvider a;
/*  19 */   private static final Vector2 d = new Vector2();
/*     */   private MapEditorUi.ToolButton b;
/*     */   
/*     */   public void setup(GameSystemProvider paramGameSystemProvider) {
/*  23 */     this.a = paramGameSystemProvider;
/*     */     
/*  25 */     this.b = new MapEditorUi.ToolButton((Drawable)Game.i.assetManager.getQuad("mapeditor.tools.remove"), () -> paramGameSystemProvider._mapEditor.selectTool(this), null);
/*     */ 
/*     */ 
/*     */     
/*  29 */     paramGameSystemProvider._mapEditorUi.mainUi.addToolButton(this.b);
/*     */   }
/*     */   private MapEditorSystem.HistoryImprint c;
/*     */   
/*     */   public MapEditorUi.PreparedTooltip getTooltip() {
/*  34 */     return new MapEditorUi.PreparedTooltip("map_editor_tool_move", (Actor)this.b, Game.i.localeManager.i18n.get("map_editor_tooltip_remove_tool"));
/*     */   }
/*     */ 
/*     */   
/*     */   public void enabled(MapEditorSystem.Tool paramTool) {
/*  39 */     this.b.setActive(true);
/*     */ 
/*     */     
/*  42 */     (this.a._input.getCameraController()).dragButtonIndices.clear();
/*  43 */     (this.a._input.getCameraController()).dragButtonIndices.add(1);
/*     */     
/*     */     InputMultiplexerExtended inputMultiplexerExtended;
/*  46 */     (inputMultiplexerExtended = this.a._input.setupInputMultiplexer(true, true, true)).addProcessor((InputProcessor)new InputAdapter(this)
/*     */         {
/*     */           private boolean a;
/*     */           
/*     */           public boolean touchDown(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/*  51 */             if (param1Int4 == 0) {
/*  52 */               this.a = true;
/*  53 */               Remove.a(this.b, (Remove.a(this.b))._mapEditor.startActionRecord());
/*  54 */               a(param1Int1, param1Int2);
/*  55 */               return false;
/*     */             } 
/*  57 */             return false;
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean touchUp(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/*  62 */             if (Remove.b(this.b) != null) {
/*  63 */               (Remove.a(this.b))._mapEditor.finishActionRecord(Remove.b(this.b));
/*     */             }
/*  65 */             this.a = false;
/*  66 */             return false;
/*     */           }
/*     */           
/*     */           private void a(float param1Float1, float param1Float2) {
/*  70 */             Remove.a().set(param1Float1, param1Float2);
/*  71 */             (Remove.a(this.b))._input.getCameraController().screenToStage(Remove.a());
/*     */             
/*  73 */             if (!(Remove.a(this.b))._mapEditorUi.inventoryMenu.isStagePointOnInventory((Remove.a()).x, (Remove.a()).y)) {
/*     */               
/*  75 */               (Remove.a(this.b))._input.getCameraController().stageToMap(Remove.a());
/*     */               
/*  77 */               Map map = (Remove.a(this.b)).map.getMap();
/*     */ 
/*     */               
/*  80 */               boolean bool = false;
/*     */               Tile tile;
/*  82 */               if ((tile = map.getTileByMapPos((Remove.a()).x, (Remove.a()).y)) != null) {
/*  83 */                 (Remove.a(this.b))._inventory.addTile(tile, 1);
/*  84 */                 if ((Remove.a(this.b))._mapEditor.selection.removeTile(tile)) {
/*  85 */                   bool = true;
/*     */                 }
/*  87 */                 (Remove.a(this.b)).map.setTile(tile.getX(), tile.getY(), null);
/*     */               } 
/*     */               Gate gate;
/*  90 */               if ((gate = map.getGateByMapPos((Remove.a()).x, (Remove.a()).y)) != null) {
/*  91 */                 (Remove.a(this.b))._inventory.addGate(gate, 1);
/*  92 */                 if ((Remove.a(this.b))._mapEditor.selection.removeGate(gate)) {
/*  93 */                   bool = true;
/*     */                 }
/*  95 */                 (Remove.a(this.b)).map.setGate(gate.getX(), gate.getY(), gate.isLeftSide(), null);
/*     */               } 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 101 */               if (bool) {
/* 102 */                 (Remove.a(this.b))._mapEditor.notifySelectionChanged();
/*     */               }
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean touchDragged(int param1Int1, int param1Int2, int param1Int3) {
/* 109 */             if (this.a) {
/* 110 */               a(param1Int1, param1Int2);
/*     */             }
/* 112 */             return false;
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public void disabled() {
/* 119 */     this.b.setActive(false);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\mapeditor\tools\Remove.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */