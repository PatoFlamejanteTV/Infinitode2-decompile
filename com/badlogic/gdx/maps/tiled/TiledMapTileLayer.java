/*     */ package com.badlogic.gdx.maps.tiled;
/*     */ 
/*     */ import com.badlogic.gdx.maps.MapLayer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TiledMapTileLayer
/*     */   extends MapLayer
/*     */ {
/*     */   private int width;
/*     */   private int height;
/*     */   private int tileWidth;
/*     */   private int tileHeight;
/*     */   private Cell[][] cells;
/*     */   
/*     */   public int getWidth() {
/*  34 */     return this.width;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHeight() {
/*  39 */     return this.height;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTileWidth() {
/*  44 */     return this.tileWidth;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTileHeight() {
/*  49 */     return this.tileHeight;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TiledMapTileLayer(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  60 */     this.width = paramInt1;
/*  61 */     this.height = paramInt2;
/*  62 */     this.tileWidth = paramInt3;
/*  63 */     this.tileHeight = paramInt4;
/*  64 */     this.cells = new Cell[paramInt1][paramInt2];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Cell getCell(int paramInt1, int paramInt2) {
/*  71 */     if (paramInt1 < 0 || paramInt1 >= this.width) return null; 
/*  72 */     if (paramInt2 < 0 || paramInt2 >= this.height) return null; 
/*  73 */     return this.cells[paramInt1][paramInt2];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCell(int paramInt1, int paramInt2, Cell paramCell) {
/*  82 */     if (paramInt1 < 0 || paramInt1 >= this.width)
/*  83 */       return;  if (paramInt2 < 0 || paramInt2 >= this.height)
/*  84 */       return;  this.cells[paramInt1][paramInt2] = paramCell;
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Cell
/*     */   {
/*     */     private TiledMapTile tile;
/*     */     private boolean flipHorizontally;
/*     */     private boolean flipVertically;
/*     */     private int rotation;
/*     */     public static final int ROTATE_0 = 0;
/*     */     public static final int ROTATE_90 = 1;
/*     */     public static final int ROTATE_180 = 2;
/*     */     public static final int ROTATE_270 = 3;
/*     */     
/*     */     public TiledMapTile getTile() {
/* 100 */       return this.tile;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Cell setTile(TiledMapTile param1TiledMapTile) {
/* 108 */       this.tile = param1TiledMapTile;
/* 109 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean getFlipHorizontally() {
/* 114 */       return this.flipHorizontally;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Cell setFlipHorizontally(boolean param1Boolean) {
/* 122 */       this.flipHorizontally = param1Boolean;
/* 123 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean getFlipVertically() {
/* 128 */       return this.flipVertically;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Cell setFlipVertically(boolean param1Boolean) {
/* 136 */       this.flipVertically = param1Boolean;
/* 137 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getRotation() {
/* 142 */       return this.rotation;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Cell setRotation(int param1Int) {
/* 150 */       this.rotation = param1Int;
/* 151 */       return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\maps\tiled\TiledMapTileLayer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */