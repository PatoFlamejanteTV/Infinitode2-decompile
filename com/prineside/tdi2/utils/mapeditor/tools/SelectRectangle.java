/*     */ package com.prineside.tdi2.utils.mapeditor.tools;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.InputAdapter;
/*     */ import com.badlogic.gdx.InputProcessor;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.Rectangle;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Gate;
/*     */ import com.prineside.tdi2.Map;
/*     */ import com.prineside.tdi2.ResourcePack;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.configs.GameRenderingOrder;
/*     */ import com.prineside.tdi2.managers.AssetManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.systems.MapEditorSystem;
/*     */ import com.prineside.tdi2.systems.RenderSystem;
/*     */ import com.prineside.tdi2.ui.components.MapEditorUi;
/*     */ import com.prineside.tdi2.utils.DrawUtils;
/*     */ import com.prineside.tdi2.utils.InputMultiplexerExtended;
/*     */ import com.prineside.tdi2.utils.mapeditor.Selection;
/*     */ 
/*     */ public class SelectRectangle implements MapEditorSystem.Tool {
/*     */   private GameSystemProvider a;
/*  29 */   private int c = -1; private MapEditorUi.ToolButton b;
/*     */   private boolean d;
/*  31 */   private final Vector2 e = new Vector2();
/*  32 */   private final Vector2 f = new Vector2();
/*     */   
/*     */   private Selection g;
/*     */   
/*     */   private Selection h;
/*     */   
/*     */   public void setup(GameSystemProvider paramGameSystemProvider) {
/*  39 */     this.a = paramGameSystemProvider;
/*     */     
/*  41 */     this.b = new MapEditorUi.ToolButton((Drawable)Game.i.assetManager.getQuad("mapeditor.tools.select-rectangle"), () -> paramGameSystemProvider._mapEditor.selectTool(this), null);
/*     */ 
/*     */ 
/*     */     
/*  45 */     paramGameSystemProvider._mapEditorUi.mainUi.addToolButton(this.b);
/*     */   }
/*     */ 
/*     */   
/*     */   public MapEditorUi.PreparedTooltip getTooltip() {
/*  50 */     return new MapEditorUi.PreparedTooltip("map_editor_tool_select", (Actor)this.b, Game.i.localeManager.i18n.get("map_editor_tooltip_select_rect_tool"));
/*     */   }
/*     */ 
/*     */   
/*     */   public void enabled(MapEditorSystem.Tool paramTool) {
/*  55 */     this.b.setActive(true);
/*     */ 
/*     */     
/*  58 */     (this.a._input.getCameraController()).dragButtonIndices.clear();
/*  59 */     (this.a._input.getCameraController()).dragButtonIndices.add(1);
/*     */ 
/*     */     
/*     */     InputMultiplexerExtended inputMultiplexerExtended;
/*     */     
/*  64 */     (inputMultiplexerExtended = this.a._input.setupInputMultiplexer(true, true, true)).addProcessor((InputProcessor)new InputAdapter(this)
/*     */         {
/*     */           public boolean touchDown(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/*  67 */             if (param1Int4 == 0) {
/*  68 */               SelectRectangle.a(this.a).set(param1Int1, param1Int2);
/*  69 */               (SelectRectangle.b(this.a))._input.getCameraController().screenToMap(SelectRectangle.a(this.a));
/*     */               
/*  71 */               SelectRectangle.c(this.a).set(param1Int1, param1Int2);
/*  72 */               (SelectRectangle.b(this.a))._input.getCameraController().screenToMap(SelectRectangle.c(this.a));
/*     */               
/*  74 */               SelectRectangle.a(this.a, param1Int3);
/*  75 */               SelectRectangle.a(this.a, (Gdx.input.isKeyPressed(129) || (SelectRectangle.b(this.a))._mapEditorUi.mainUi.isCtrlButtonEnabled()));
/*     */               
/*  77 */               if (!SelectRectangle.d(this.a)) {
/*  78 */                 SelectRectangle.a(this.a, (Selection)null);
/*  79 */                 SelectRectangle.e(this.a);
/*     */               } else {
/*  81 */                 SelectRectangle.a(this.a, (SelectRectangle.b(this.a))._mapEditor.selection.cpy());
/*     */               } 
/*  83 */               return false;
/*     */             } 
/*  85 */             return false;
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean touchUp(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/*  90 */             if (SelectRectangle.f(this.a) == param1Int3) {
/*  91 */               SelectRectangle.a(this.a, -1);
/*     */             }
/*  93 */             return false;
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean touchDragged(int param1Int1, int param1Int2, int param1Int3) {
/*  98 */             if (param1Int3 == SelectRectangle.f(this.a)) {
/*  99 */               SelectRectangle.c(this.a).set(param1Int1, param1Int2);
/* 100 */               (SelectRectangle.b(this.a))._input.getCameraController().screenToMap(SelectRectangle.c(this.a));
/* 101 */               SelectRectangle.e(this.a);
/* 102 */               return false;
/*     */             } 
/* 104 */             return false;
/*     */           }
/*     */         });
/*     */     
/* 108 */     this.a._render.addLayer(new RenderSystem.Layer(GameRenderingOrder.MAP_RENDERING_MAP_EDITOR_SELECTION + 50, false, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> {
/*     */             if (this.c != -1) {
/*     */               paramFloat1 = Math.min(this.e.x, this.f.x);
/*     */               paramFloat2 = Math.max(this.e.x, this.f.x);
/*     */               paramFloat3 = Math.min(this.e.y, this.f.y);
/*     */               float f1 = Math.max(this.e.y, this.f.y);
/*     */               ResourcePack.AtlasTextureRegion atlasTextureRegion = (AssetManager.TextureRegions.i()).blank;
/*     */               float f2 = (float)(2.0D * (this.a._input.getCameraController()).zoom);
/*     */               DrawUtils.texturedLineB(paramBatch, (TextureRegion)atlasTextureRegion, paramFloat1, this.e.y, paramFloat1, this.f.y, f2);
/*     */               DrawUtils.texturedLineB(paramBatch, (TextureRegion)atlasTextureRegion, paramFloat2, this.e.y, paramFloat2, this.f.y, f2);
/*     */               DrawUtils.texturedLineB(paramBatch, (TextureRegion)atlasTextureRegion, this.e.x, paramFloat3, this.f.x, paramFloat3, f2);
/*     */               DrawUtils.texturedLineB(paramBatch, (TextureRegion)atlasTextureRegion, this.e.x, f1, this.f.x, f1, f2);
/*     */             } 
/*     */           }));
/*     */   }
/*     */   
/*     */   private void a() {
/* 125 */     if (this.h == null) {
/* 126 */       this.h = this.a._mapEditor.selection.cpy();
/* 127 */       this.h.setFromInventory(false);
/*     */     } 
/* 129 */     this.h.clear();
/*     */ 
/*     */     
/* 132 */     float f1 = Math.min(this.e.x, this.f.x);
/* 133 */     float f2 = Math.max(this.e.x, this.f.x);
/* 134 */     float f3 = Math.min(this.e.y, this.f.y);
/* 135 */     float f4 = Math.max(this.e.y, this.f.y);
/* 136 */     Rectangle rectangle = new Rectangle(f1, f3, f2 - f1, f4 - f3);
/*     */ 
/*     */     
/* 139 */     int i = MathUtils.floor(f1 * 0.0078125F) - 1;
/* 140 */     int k = MathUtils.floor(f3 * 0.0078125F) - 1;
/* 141 */     int j = MathUtils.ceil(f2 * 0.0078125F) + 1;
/* 142 */     int m = MathUtils.ceil(f4 * 0.0078125F) + 1;
/*     */     
/* 144 */     Map map = this.a.map.getMap();
/* 145 */     for (i = i; i <= j; i++) {
/* 146 */       for (int n = k; n <= m; n++) {
/*     */         Tile tile;
/*     */         
/* 149 */         if ((tile = map.getTile(i, n)) != null && tile.getBoundingBox().overlaps(rectangle))
/* 150 */           this.h.addTile(tile);  boolean[] arrayOfBoolean;
/*     */         byte b;
/* 152 */         for (arrayOfBoolean = new boolean[] { false, true }, b = 0; b < 2; ) { boolean bool = arrayOfBoolean[b];
/*     */           Gate gate;
/* 154 */           if ((gate = map.getGate(i, n, bool)) != null && gate.getBoundingBox().overlaps(rectangle)) {
/* 155 */             this.h.addGate(gate);
/*     */           }
/*     */           b++; }
/*     */       
/*     */       } 
/*     */     } 
/* 161 */     if (this.d) {
/* 162 */       this.h.addAll(this.g);
/*     */     }
/*     */     
/* 165 */     if (this.a._mapEditor.selection.hash() != this.h.hash()) {
/* 166 */       this.a._mapEditor.selection.clear();
/* 167 */       this.a._mapEditor.selection.setFromInventory(false);
/* 168 */       this.a._mapEditor.selection.addAll(this.h);
/* 169 */       this.a._mapEditor.notifySelectionChanged();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void disabled() {
/* 175 */     this.c = -1;
/* 176 */     this.b.setActive(false);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\mapeditor\tools\SelectRectangle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */