/*     */ package com.prineside.tdi2.systems;
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.prineside.tdi2.GameSystem;
/*     */ import com.prineside.tdi2.Gate;
/*     */ import com.prineside.tdi2.Map;
/*     */ import com.prineside.tdi2.MapElementPos;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.configs.GameRenderingOrder;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.game.MapElementHover;
/*     */ import com.prineside.tdi2.events.game.MapElementSelect;
/*     */ import com.prineside.tdi2.events.game.MouseClick;
/*     */ import com.prineside.tdi2.events.game.MouseMove;
/*     */ import com.prineside.tdi2.managers.AssetManager;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import java.util.Objects;
/*     */ 
/*     */ @NAGS
/*     */ public final class GameMapSelectionSystem extends GameSystem {
/*     */   @Null
/*     */   private MapElementPos a;
/*     */   @Null
/*     */   private MapElementPos b;
/*     */   
/*     */   public final void setup() {
/*  30 */     if (Gdx.app.getType() == Application.ApplicationType.Desktop)
/*     */     {
/*  32 */       this.S.events.getListeners(MouseMove.class).add(paramMouseMove -> a(paramMouseMove.getMapX(), paramMouseMove.getMapY(), false));
/*     */     }
/*  34 */     this.S.events.getListeners(MouseClick.class).add(paramMouseClick -> a(paramMouseClick.getMapX(), paramMouseClick.getMapY(), true));
/*     */     
/*  36 */     this.S._render.addLayer((new RenderSystem.Layer(GameRenderingOrder.MAP_RENDERING_GAME_SELECTION, false, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> drawMapHoverSelect(paramBatch)))
/*     */ 
/*     */         
/*  39 */         .setName("MapRendering-postDrawBatch"));
/*     */   }
/*     */   
/*     */   public final void drawMapHoverSelect(Batch paramBatch) {
/*  43 */     Tile tile1 = getSelectedTile();
/*  44 */     Tile tile2 = getHoveredTile();
/*  45 */     Gate gate1 = getSelectedGate();
/*  46 */     Gate gate2 = getHoveredGate();
/*     */     
/*  48 */     if (tile1 != null) {
/*  49 */       drawTileSelection(paramBatch, tile1.getX(), tile1.getY());
/*  50 */     } else if (gate1 != null) {
/*  51 */       drawGateSelection(paramBatch, gate1.getX(), gate1.getY(), gate1.isLeftSide());
/*     */     } 
/*     */     
/*  54 */     if (gate2 != null && gate2 != gate1) {
/*  55 */       drawGateHover(paramBatch, gate2.getX(), gate2.getY(), gate2.isLeftSide()); return;
/*  56 */     }  if (tile2 != null && tile2 != tile1) {
/*  57 */       drawTileHover(paramBatch, tile2.getX(), tile2.getY());
/*     */     }
/*     */   }
/*     */   
/*     */   public static void drawTileHover(Batch paramBatch, int paramInt1, int paramInt2) {
/*  62 */     paramBatch.draw((TextureRegion)(AssetManager.TextureRegions.i()).tileOutlineHover, ((paramInt1 << 7) + 64) - 76.0F, ((paramInt2 << 7) + 64) - 76.0F, 152.0F, 152.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void drawTileSelection(Batch paramBatch, int paramInt1, int paramInt2) {
/*  71 */     paramBatch.draw((TextureRegion)(AssetManager.TextureRegions.i()).tileOutlineActive, ((paramInt1 << 7) + 64) - 76.0F, ((paramInt2 << 7) + 64) - 76.0F, 152.0F, 152.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void drawGateHover(Batch paramBatch, int paramInt1, int paramInt2, boolean paramBoolean) {
/*  80 */     if (paramBoolean) {
/*     */       
/*  82 */       paramBatch.draw((TextureRegion)(AssetManager.TextureRegions.i()).gateOutlineVerticalHover, (paramInt1 << 7) - 25.0F, ((paramInt2 << 7) + 64) - 81.0F, 50.0F, 162.0F);
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */     
/*  89 */     paramBatch.draw((TextureRegion)(AssetManager.TextureRegions.i()).gateOutlineHorizontalHover, ((paramInt1 << 7) + 64) - 81.0F, (paramInt2 << 7) - 25.0F, 162.0F, 50.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void drawGateSelection(Batch paramBatch, int paramInt1, int paramInt2, boolean paramBoolean) {
/*  98 */     if (paramBoolean) {
/*     */       
/* 100 */       paramBatch.draw((TextureRegion)(AssetManager.TextureRegions.i()).gateOutlineVerticalActive, (paramInt1 << 7) - 25.0F, ((paramInt2 << 7) + 64) - 81.0F, 50.0F, 162.0F);
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */     
/* 107 */     paramBatch.draw((TextureRegion)(AssetManager.TextureRegions.i()).gateOutlineHorizontalActive, ((paramInt1 << 7) + 64) - 81.0F, (paramInt2 << 7) - 25.0F, 162.0F, 50.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(float paramFloat1, float paramFloat2, boolean paramBoolean) {
/*     */     Map map;
/*     */     Gate gate;
/* 119 */     if ((gate = (map = this.S.map.getMap()).getGateByMapPos(paramFloat1, paramFloat2)) != null) {
/*     */       
/* 121 */       if (paramBoolean) {
/* 122 */         setSelectedGateAtPos(gate.getX(), gate.getY(), gate.isLeftSide()); return;
/*     */       } 
/* 124 */       setHoveredGateAtPos(gate.getX(), gate.getY(), gate.isLeftSide());
/*     */       
/*     */       return;
/*     */     } 
/*     */     Tile tile;
/* 129 */     if ((tile = map.getTileByMapPos(paramFloat1, paramFloat2)) == null) {
/*     */       
/* 131 */       if (paramBoolean) {
/* 132 */         disableSelection(); return;
/*     */       } 
/* 134 */       disableHover();
/*     */       
/*     */       return;
/*     */     } 
/* 138 */     if (paramBoolean) {
/* 139 */       setSelectedTileAtPos(tile.getX(), tile.getY()); return;
/*     */     } 
/* 141 */     setHoveredTileAtPos(tile.getX(), tile.getY());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(@Null MapElementPos paramMapElementPos) {
/* 149 */     MapElementPos mapElementPos = this.a;
/* 150 */     this.a = paramMapElementPos;
/* 151 */     if (!Objects.equals(paramMapElementPos, this.a) && ((MapElementSelect)this.S.events.trigger((Event)new MapElementSelect(mapElementPos, paramMapElementPos))).isCancelled()) {
/* 152 */       this.a = mapElementPos;
/* 153 */       this.S.events.trigger((Event)new MapElementSelect(paramMapElementPos, mapElementPos));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(@Null MapElementPos paramMapElementPos) {
/* 160 */     MapElementPos mapElementPos = this.b;
/* 161 */     this.b = paramMapElementPos;
/* 162 */     if (!Objects.equals(paramMapElementPos, this.b) && ((MapElementHover)this.S.events.trigger((Event)new MapElementHover(mapElementPos, paramMapElementPos))).isCancelled()) {
/* 163 */       this.b = mapElementPos;
/* 164 */       this.S.events.trigger((Event)new MapElementHover(paramMapElementPos, mapElementPos));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void disableSelection() {
/* 170 */     a((MapElementPos)null);
/*     */   }
/*     */   
/*     */   public final void disableHover() {
/* 174 */     b(null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setSelectedTile(@Null Tile paramTile) {
/* 180 */     if (paramTile == null) {
/* 181 */       disableSelection(); return;
/*     */     } 
/* 183 */     setSelectedTileAtPos(paramTile.getX(), paramTile.getY());
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setSelectedTileAtPos(int paramInt1, int paramInt2) {
/*     */     Tile tile;
/* 189 */     if ((tile = this.S.map.getMap().getTile(paramInt1, paramInt2)) != null && !tile.canBeSelected()) {
/* 190 */       tile = null;
/*     */     }
/* 192 */     if (tile == null) {
/* 193 */       disableSelection(); return;
/*     */     } 
/* 195 */     a((MapElementPos)new Tile.Pos(tile.getX(), tile.getY()));
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setHoveredTile(@Null Tile paramTile) {
/* 200 */     if (paramTile == null) {
/* 201 */       disableHover(); return;
/*     */     } 
/* 203 */     setHoveredTileAtPos(paramTile.getX(), paramTile.getY());
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setHoveredTileAtPos(int paramInt1, int paramInt2) {
/*     */     Tile tile;
/* 209 */     if ((tile = this.S.map.getMap().getTile(paramInt1, paramInt2)) != null && !tile.canBeSelected()) {
/* 210 */       tile = null;
/*     */     }
/* 212 */     if (tile == null) {
/* 213 */       disableHover(); return;
/*     */     } 
/* 215 */     b((MapElementPos)new Tile.Pos(tile.getX(), tile.getY()));
/*     */   }
/*     */   
/*     */   @Null
/*     */   public final Tile getSelectedTile() {
/* 220 */     return (this.a instanceof Tile.Pos) ? this.S.map.getMap().getTileAtPos((Tile.Pos)this.a) : null;
/*     */   }
/*     */   @Null
/*     */   public final Tile getHoveredTile() {
/* 224 */     return (this.b instanceof Tile.Pos) ? this.S.map.getMap().getTileAtPos((Tile.Pos)this.b) : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setSelectedGate(@Null Gate paramGate) {
/* 230 */     if (paramGate == null) {
/* 231 */       disableSelection(); return;
/*     */     } 
/* 233 */     setSelectedGateAtPos(paramGate.getX(), paramGate.getY(), paramGate.isLeftSide());
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setSelectedGateAtPos(int paramInt1, int paramInt2, boolean paramBoolean) {
/*     */     Gate gate;
/* 239 */     if ((gate = this.S.map.getMap().getGate(paramInt1, paramInt2, paramBoolean)) == null) {
/* 240 */       disableSelection(); return;
/*     */     } 
/* 242 */     a((MapElementPos)new Gate.Pos(gate.getX(), gate.getY(), gate.isLeftSide()));
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setHoveredGate(@Null Gate paramGate) {
/* 247 */     if (paramGate == null) {
/* 248 */       disableSelection(); return;
/*     */     } 
/* 250 */     setHoveredGateAtPos(paramGate.getX(), paramGate.getY(), paramGate.isLeftSide());
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setHoveredGateAtPos(int paramInt1, int paramInt2, boolean paramBoolean) {
/*     */     Gate gate;
/* 256 */     if ((gate = this.S.map.getMap().getGate(paramInt1, paramInt2, paramBoolean)) == null) {
/* 257 */       disableHover(); return;
/*     */     } 
/* 259 */     b((MapElementPos)new Gate.Pos(gate.getX(), gate.getY(), gate.isLeftSide()));
/*     */   }
/*     */   
/*     */   @Null
/*     */   public final Gate getSelectedGate() {
/* 264 */     return (this.a instanceof Gate.Pos) ? this.S.map.getMap().getGateAtPos((Gate.Pos)this.a) : null;
/*     */   }
/*     */   @Null
/*     */   public final Gate getHoveredGate() {
/* 268 */     return (this.b instanceof Gate.Pos) ? this.S.map.getMap().getGateAtPos((Gate.Pos)this.b) : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean affectsGameState() {
/* 273 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String getSystemName() {
/* 278 */     return "GameMapSelection";
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\systems\GameMapSelectionSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */