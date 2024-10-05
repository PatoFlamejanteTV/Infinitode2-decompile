/*     */ package com.badlogic.gdx.maps.tiled.renderers;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.maps.tiled.TiledMap;
/*     */ import com.badlogic.gdx.maps.tiled.TiledMapTile;
/*     */ import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
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
/*     */ public class IsometricStaggeredTiledMapRenderer
/*     */   extends BatchTiledMapRenderer
/*     */ {
/*     */   public IsometricStaggeredTiledMapRenderer(TiledMap paramTiledMap) {
/*  32 */     super(paramTiledMap);
/*     */   }
/*     */   
/*     */   public IsometricStaggeredTiledMapRenderer(TiledMap paramTiledMap, Batch paramBatch) {
/*  36 */     super(paramTiledMap, paramBatch);
/*     */   }
/*     */   
/*     */   public IsometricStaggeredTiledMapRenderer(TiledMap paramTiledMap, float paramFloat) {
/*  40 */     super(paramTiledMap, paramFloat);
/*     */   }
/*     */   
/*     */   public IsometricStaggeredTiledMapRenderer(TiledMap paramTiledMap, float paramFloat, Batch paramBatch) {
/*  44 */     super(paramTiledMap, paramFloat, paramBatch);
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderTileLayer(TiledMapTileLayer paramTiledMapTileLayer) {
/*     */     Color color;
/*  50 */     float f1 = Color.toFloatBits((color = this.batch.getColor()).r, color.g, color.b, color.a * paramTiledMapTileLayer.getOpacity());
/*     */     
/*  52 */     int i = paramTiledMapTileLayer.getWidth();
/*  53 */     int j = paramTiledMapTileLayer.getHeight();
/*     */     
/*  55 */     float f2 = paramTiledMapTileLayer.getRenderOffsetX() * this.unitScale - this.viewBounds.x * (paramTiledMapTileLayer.getParallaxX() - 1.0F);
/*     */     
/*  57 */     float f3 = -paramTiledMapTileLayer.getRenderOffsetY() * this.unitScale - this.viewBounds.y * (paramTiledMapTileLayer.getParallaxY() - 1.0F);
/*     */     
/*  59 */     float f4 = paramTiledMapTileLayer.getTileWidth() * this.unitScale;
/*  60 */     float f5 = paramTiledMapTileLayer.getTileHeight() * this.unitScale;
/*     */     
/*  62 */     float f6 = f4 * 0.5F;
/*  63 */     float f7 = f5 * 0.5F;
/*     */     
/*  65 */     int k = Math.max(0, (int)((this.viewBounds.x - f6 - f2) / f4));
/*  66 */     i = Math.min(i, (int)((this.viewBounds.x + this.viewBounds.width + f4 + f6 - f2) / f4));
/*     */ 
/*     */     
/*  69 */     int m = Math.max(0, (int)((this.viewBounds.y - f5 - f3) / f5));
/*     */ 
/*     */ 
/*     */     
/*  73 */     for (j = (j = Math.min(j, (int)((this.viewBounds.y + this.viewBounds.height + f5 - f3) / f7))) - 1; j >= m; j--) {
/*  74 */       f5 = (j % 2 == 1) ? f6 : 0.0F;
/*  75 */       for (int n = i - 1; n >= k; n--) {
/*     */         TiledMapTileLayer.Cell cell; TiledMapTile tiledMapTile;
/*  77 */         if ((cell = paramTiledMapTileLayer.getCell(n, j)) != null && (
/*     */ 
/*     */           
/*  80 */           tiledMapTile = cell.getTile()) != null) {
/*  81 */           boolean bool1 = cell.getFlipHorizontally();
/*  82 */           boolean bool2 = cell.getFlipVertically();
/*  83 */           int i1 = cell.getRotation();
/*  84 */           TextureRegion textureRegion = tiledMapTile.getTextureRegion();
/*     */           
/*  86 */           float f9 = n * f4 - f5 + tiledMapTile.getOffsetX() * this.unitScale + f2;
/*  87 */           float f8 = j * f7 + tiledMapTile.getOffsetY() * this.unitScale + f3;
/*  88 */           float f10 = f9 + textureRegion.getRegionWidth() * this.unitScale;
/*  89 */           float f11 = f8 + textureRegion.getRegionHeight() * this.unitScale;
/*     */           
/*  91 */           float f12 = textureRegion.getU();
/*  92 */           float f13 = textureRegion.getV2();
/*  93 */           float f14 = textureRegion.getU2();
/*  94 */           float f15 = textureRegion.getV();
/*     */           
/*  96 */           this.vertices[0] = f9;
/*  97 */           this.vertices[1] = f8;
/*  98 */           this.vertices[2] = f1;
/*  99 */           this.vertices[3] = f12;
/* 100 */           this.vertices[4] = f13;
/*     */           
/* 102 */           this.vertices[5] = f9;
/* 103 */           this.vertices[6] = f11;
/* 104 */           this.vertices[7] = f1;
/* 105 */           this.vertices[8] = f12;
/* 106 */           this.vertices[9] = f15;
/*     */           
/* 108 */           this.vertices[10] = f10;
/* 109 */           this.vertices[11] = f11;
/* 110 */           this.vertices[12] = f1;
/* 111 */           this.vertices[13] = f14;
/* 112 */           this.vertices[14] = f15;
/*     */           
/* 114 */           this.vertices[15] = f10;
/* 115 */           this.vertices[16] = f8;
/* 116 */           this.vertices[17] = f1;
/* 117 */           this.vertices[18] = f14;
/* 118 */           this.vertices[19] = f13;
/*     */           
/* 120 */           if (bool1) {
/* 121 */             f8 = this.vertices[3];
/* 122 */             this.vertices[3] = this.vertices[13];
/* 123 */             this.vertices[13] = f8;
/* 124 */             f8 = this.vertices[8];
/* 125 */             this.vertices[8] = this.vertices[18];
/* 126 */             this.vertices[18] = f8;
/*     */           } 
/*     */           
/* 129 */           if (bool2) {
/* 130 */             f8 = this.vertices[4];
/* 131 */             this.vertices[4] = this.vertices[14];
/* 132 */             this.vertices[14] = f8;
/* 133 */             f8 = this.vertices[9];
/* 134 */             this.vertices[9] = this.vertices[19];
/* 135 */             this.vertices[19] = f8;
/*     */           } 
/*     */           
/* 138 */           if (i1 != 0) {
/* 139 */             float f; switch (i1) {
/*     */               case 1:
/* 141 */                 f8 = this.vertices[4];
/* 142 */                 this.vertices[4] = this.vertices[9];
/* 143 */                 this.vertices[9] = this.vertices[14];
/* 144 */                 this.vertices[14] = this.vertices[19];
/* 145 */                 this.vertices[19] = f8;
/*     */                 
/* 147 */                 f = this.vertices[3];
/* 148 */                 this.vertices[3] = this.vertices[8];
/* 149 */                 this.vertices[8] = this.vertices[13];
/* 150 */                 this.vertices[13] = this.vertices[18];
/* 151 */                 this.vertices[18] = f;
/*     */                 break;
/*     */               
/*     */               case 2:
/* 155 */                 f8 = this.vertices[3];
/* 156 */                 this.vertices[3] = this.vertices[13];
/* 157 */                 this.vertices[13] = f8;
/* 158 */                 f8 = this.vertices[8];
/* 159 */                 this.vertices[8] = this.vertices[18];
/* 160 */                 this.vertices[18] = f8;
/* 161 */                 f = this.vertices[4];
/* 162 */                 this.vertices[4] = this.vertices[14];
/* 163 */                 this.vertices[14] = f;
/* 164 */                 f = this.vertices[9];
/* 165 */                 this.vertices[9] = this.vertices[19];
/* 166 */                 this.vertices[19] = f;
/*     */                 break;
/*     */               
/*     */               case 3:
/* 170 */                 f8 = this.vertices[4];
/* 171 */                 this.vertices[4] = this.vertices[19];
/* 172 */                 this.vertices[19] = this.vertices[14];
/* 173 */                 this.vertices[14] = this.vertices[9];
/* 174 */                 this.vertices[9] = f8;
/*     */                 
/* 176 */                 f = this.vertices[3];
/* 177 */                 this.vertices[3] = this.vertices[18];
/* 178 */                 this.vertices[18] = this.vertices[13];
/* 179 */                 this.vertices[13] = this.vertices[8];
/* 180 */                 this.vertices[8] = f;
/*     */                 break;
/*     */             } 
/*     */           
/*     */           } 
/* 185 */           this.batch.draw(textureRegion.getTexture(), this.vertices, 0, 20);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\maps\tiled\renderers\IsometricStaggeredTiledMapRenderer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */