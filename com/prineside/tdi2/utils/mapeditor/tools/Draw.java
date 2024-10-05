/*     */ package com.prineside.tdi2.utils.mapeditor.tools;
/*     */ 
/*     */ import com.badlogic.gdx.InputAdapter;
/*     */ import com.badlogic.gdx.InputProcessor;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Gate;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.Map;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.systems.MapEditorSystem;
/*     */ import com.prineside.tdi2.ui.components.MapEditorUi;
/*     */ import com.prineside.tdi2.utils.InputMultiplexerExtended;
/*     */ import com.prineside.tdi2.utils.IntRectangle;
/*     */ import com.prineside.tdi2.utils.mapeditor.Selection;
/*     */ 
/*     */ public class Draw
/*     */   implements MapEditorSystem.Tool {
/*     */   private GameSystemProvider a;
/*     */   private MapEditorUi.ToolButton b;
/*  26 */   private final Gate e = (Gate)Game.i.gateManager.F.BARRIER_TYPE.create(); private Selection c;
/*     */   private MapEditorSystem.HistoryImprint d;
/*  28 */   private static final Vector2 f = new Vector2();
/*     */ 
/*     */   
/*     */   public void setup(GameSystemProvider paramGameSystemProvider) {
/*  32 */     this.a = paramGameSystemProvider;
/*     */     
/*  34 */     this.b = new MapEditorUi.ToolButton((Drawable)Game.i.assetManager.getQuad("mapeditor.tools.draw"), () -> paramGameSystemProvider._mapEditor.selectTool(this), null);
/*     */ 
/*     */ 
/*     */     
/*  38 */     paramGameSystemProvider._mapEditorUi.mainUi.addToolButton(this.b);
/*     */   }
/*     */ 
/*     */   
/*     */   public MapEditorUi.PreparedTooltip getTooltip() {
/*  43 */     return new MapEditorUi.PreparedTooltip("map_editor_tool_draw", (Actor)this.b, Game.i.localeManager.i18n.get("map_editor_tooltip_draw_tool"));
/*     */   }
/*     */   
/*     */   public void paintGate(Gate paramGate, int paramInt1, int paramInt2, boolean paramBoolean) {
/*  47 */     if (this.a._inventory.removeMany((Item)Item.D.F_GATE.create(paramGate), 1)) {
/*     */       Gate gate;
/*  49 */       if ((gate = this.a.map.getMap().getGate(paramInt1, paramInt2, paramBoolean)) != null) {
/*  50 */         this.a._inventory.addGate(gate, 1);
/*     */       }
/*  52 */       this.a.map.setGate(paramInt1, paramInt2, paramBoolean, paramGate.cloneGate());
/*     */     } 
/*     */   }
/*     */   
/*     */   public void paintTile(Tile paramTile, int paramInt1, int paramInt2) {
/*  57 */     if (this.a._inventory.removeMany((Item)Item.D.F_TILE.create(paramTile), 1)) {
/*     */       Tile tile;
/*  59 */       if ((tile = this.a.map.getMap().getTile(paramInt1, paramInt2)) != null) {
/*  60 */         this.a._inventory.addTile(tile, 1);
/*     */       }
/*  62 */       this.a.map.setTile(paramInt1, paramInt2, paramTile.cloneTile());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void enabled(MapEditorSystem.Tool paramTool) {
/*  68 */     this.b.setActive(true);
/*     */ 
/*     */     
/*  71 */     (this.a._input.getCameraController()).dragButtonIndices.clear();
/*  72 */     (this.a._input.getCameraController()).dragButtonIndices.add(1);
/*     */     
/*     */     InputMultiplexerExtended inputMultiplexerExtended;
/*  75 */     (inputMultiplexerExtended = this.a._input.setupInputMultiplexer(true, true, true)).addProcessor((InputProcessor)new InputAdapter(this) {
/*  76 */           private int a = -1;
/*     */ 
/*     */           
/*     */           public boolean touchDown(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/*  80 */             if (param1Int4 == 0) {
/*  81 */               this.a = -1;
/*  82 */               Draw.a(this.b, (Draw.a(this.b))._mapEditor.selection.cpy());
/*  83 */               Draw.a(this.b, (Draw.a(this.b))._mapEditor.startActionRecord());
/*  84 */               a(param1Int1, param1Int2);
/*  85 */               return false;
/*     */             } 
/*  87 */             return false;
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean touchUp(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/*  92 */             if (Draw.b(this.b) != null) {
/*  93 */               (Draw.a(this.b))._mapEditor.finishActionRecord(Draw.b(this.b));
/*  94 */               Draw.a(this.b, (MapEditorSystem.HistoryImprint)null);
/*     */             } 
/*     */             
/*  97 */             Draw.a(this.b, (Selection)null);
/*  98 */             return false;
/*     */           }
/*     */           private void a(float param1Float1, float param1Float2) {
/*     */             int i;
/* 102 */             Draw.a().set(param1Float1, param1Float2);
/* 103 */             (Draw.a(this.b))._input.getCameraController().screenToStage(Draw.a());
/* 104 */             boolean bool = (Draw.a(this.b))._mapEditorUi.inventoryMenu.isStagePointOnInventory((Draw.a()).x, (Draw.a()).y);
/* 105 */             (Draw.a(this.b))._input.getCameraController().stageToMap(Draw.a());
/*     */ 
/*     */ 
/*     */             
/* 109 */             if (bool) {
/* 110 */               i = 6961;
/*     */             } else {
/*     */               
/* 113 */               i = (i = 1627 + Map.posToCell((Draw.a()).x)) * 1627 + Map.posToCell((Draw.a()).y);
/*     */               
/* 115 */               if ((Draw.c(this.b)).gates.size != 0)
/*     */               {
/* 117 */                 if ((Draw.a(this.b)).map.getMap().fitGateToMapPos((Draw.a()).x, (Draw.a()).y, Draw.d(this.b)))
/*     */                 {
/*     */                   
/* 120 */                   i = (i = (i = i * 1627 + Draw.d(this.b).getX()) * 1627 + Draw.d(this.b).getY()) * 1627 + (Draw.d(this.b).isLeftSide() ? 0 : 1);
/*     */                 }
/*     */               }
/*     */             } 
/* 124 */             if (this.a == i)
/* 125 */               return;  this.a = i;
/*     */             
/* 127 */             if (!bool) {
/*     */               
/* 129 */               Map map = (Draw.a(this.b)).map.getMap();
/* 130 */               if (Draw.c(this.b).count() == 1 && (Draw.c(this.b)).gates.size == 1) {
/*     */                 
/* 132 */                 Gate gate = (Gate)(Draw.c(this.b)).gates.first();
/* 133 */                 if ((Draw.a(this.b)).map.getMap().fitGateToMapPos((Draw.a()).x, (Draw.a()).y, Draw.d(this.b)))
/*     */                 {
/* 135 */                   if ((Draw.a(this.b))._inventory.contains((Item)Item.D.F_GATE.create(gate), 1) && !gate.sameAs((Draw.a(this.b)).map.getMap().getGate(Draw.d(this.b).getX(), Draw.d(this.b).getY(), Draw.d(this.b).isLeftSide()))) {
/* 136 */                     this.b.paintGate(gate, Draw.d(this.b).getX(), Draw.d(this.b).getY(), Draw.d(this.b).isLeftSide());
/*     */                   }
/*     */                 }
/*     */                 return;
/*     */               } 
/* 141 */               float f1 = (Draw.a()).x;
/* 142 */               float f2 = (Draw.a()).y;
/* 143 */               int j = MathUtils.floor(f1 * 0.0078125F);
/* 144 */               int k = MathUtils.floor(f2 * 0.0078125F);
/*     */               
/* 146 */               IntRectangle intRectangle = Draw.c(this.b).dimensions(); Array.ArrayIterator<Tile> arrayIterator;
/* 147 */               for (arrayIterator = (Draw.c(this.b)).tiles.iterator(); arrayIterator.hasNext(); ) {
/* 148 */                 Tile tile; int m = (tile = arrayIterator.next()).getX() - intRectangle.minX + j;
/* 149 */                 int n = tile.getY() - intRectangle.minY + k;
/* 150 */                 if (m >= 0 && m < map.getWidth() && n >= 0 && n < map.getHeight())
/*     */                 {
/* 152 */                   if ((Draw.a(this.b))._inventory.contains((Item)Item.D.F_TILE.create(tile), 1) && !tile.sameAsWithExtras((Draw.a(this.b)).map.getMap().getTile(m, n))) {
/* 153 */                     this.b.paintTile(tile, m, n);
/*     */                   }
/*     */                 }
/*     */               } 
/* 157 */               for (arrayIterator = (Draw.c(this.b)).gates.iterator(); arrayIterator.hasNext(); ) {
/* 158 */                 Gate gate; int m = (gate = (Gate)arrayIterator.next()).getX() - intRectangle.minX + j;
/* 159 */                 int n = gate.getY() - intRectangle.minY + k;
/* 160 */                 if (m >= 0 && m <= map.getWidth() && n >= 0 && n <= map.getHeight())
/*     */                 {
/* 162 */                   if ((Draw.a(this.b))._inventory.contains((Item)Item.D.F_GATE.create(gate), 1) && !gate.sameAs((Draw.a(this.b)).map.getMap().getGate(m, n, gate.isLeftSide()))) {
/* 163 */                     this.b.paintGate(gate, m, n, gate.isLeftSide());
/*     */                   }
/*     */                 }
/*     */               } 
/*     */             } 
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public boolean touchDragged(int param1Int1, int param1Int2, int param1Int3) {
/* 176 */             if (Draw.c(this.b) != null) {
/* 177 */               a(param1Int1, param1Int2);
/*     */             }
/* 179 */             return false;
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public void disabled() {
/* 186 */     this.b.setActive(false);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\mapeditor\tools\Draw.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */