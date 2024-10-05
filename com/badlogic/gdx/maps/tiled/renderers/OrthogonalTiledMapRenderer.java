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
/*     */ public class OrthogonalTiledMapRenderer
/*     */   extends BatchTiledMapRenderer
/*     */ {
/*     */   public OrthogonalTiledMapRenderer(TiledMap paramTiledMap) {
/*  51 */     super(paramTiledMap);
/*     */   }
/*     */   
/*     */   public OrthogonalTiledMapRenderer(TiledMap paramTiledMap, Batch paramBatch) {
/*  55 */     super(paramTiledMap, paramBatch);
/*     */   }
/*     */   
/*     */   public OrthogonalTiledMapRenderer(TiledMap paramTiledMap, float paramFloat) {
/*  59 */     super(paramTiledMap, paramFloat);
/*     */   }
/*     */   
/*     */   public OrthogonalTiledMapRenderer(TiledMap paramTiledMap, float paramFloat, Batch paramBatch) {
/*  63 */     super(paramTiledMap, paramFloat, paramBatch);
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderTileLayer(TiledMapTileLayer paramTiledMapTileLayer) {
/*     */     Color color;
/*  69 */     float f1 = Color.toFloatBits((color = this.batch.getColor()).r, color.g, color.b, color.a * paramTiledMapTileLayer.getOpacity());
/*     */     
/*  71 */     int i = paramTiledMapTileLayer.getWidth();
/*  72 */     int j = paramTiledMapTileLayer.getHeight();
/*     */     
/*  74 */     float f2 = paramTiledMapTileLayer.getTileWidth() * this.unitScale;
/*  75 */     float f3 = paramTiledMapTileLayer.getTileHeight() * this.unitScale;
/*     */     
/*  77 */     float f4 = paramTiledMapTileLayer.getRenderOffsetX() * this.unitScale - this.viewBounds.x * (paramTiledMapTileLayer.getParallaxX() - 1.0F);
/*     */     
/*  79 */     float f5 = -paramTiledMapTileLayer.getRenderOffsetY() * this.unitScale - this.viewBounds.y * (paramTiledMapTileLayer.getParallaxY() - 1.0F);
/*     */     
/*  81 */     int k = Math.max(0, (int)((this.viewBounds.x - f4) / f2));
/*  82 */     i = Math.min(i, (int)((this.viewBounds.x + this.viewBounds.width + f2 - f4) / f2));
/*     */ 
/*     */     
/*  85 */     int m = Math.max(0, (int)((this.viewBounds.y - f5) / f3));
/*     */ 
/*     */ 
/*     */     
/*  89 */     f5 = (j = Math.min(j, (int)((this.viewBounds.y + this.viewBounds.height + f3 - f5) / f3))) * f3 + f5;
/*  90 */     f4 = k * f2 + f4;
/*  91 */     float[] arrayOfFloat = this.vertices;
/*     */     
/*  93 */     for (j = j; j >= m; j--) {
/*  94 */       float f = f4;
/*  95 */       for (int n = k; n < i; n++) {
/*     */         TiledMapTileLayer.Cell cell;
/*  97 */         if ((cell = paramTiledMapTileLayer.getCell(n, j)) != null) {
/*     */           TiledMapTile tiledMapTile;
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 103 */           if ((tiledMapTile = cell.getTile()) != null) {
/* 104 */             boolean bool1 = cell.getFlipHorizontally();
/* 105 */             boolean bool2 = cell.getFlipVertically();
/* 106 */             int i1 = cell.getRotation();
/*     */             
/* 108 */             TextureRegion textureRegion = tiledMapTile.getTextureRegion();
/*     */             
/* 110 */             float f7 = f + tiledMapTile.getOffsetX() * this.unitScale;
/* 111 */             float f6 = f5 + tiledMapTile.getOffsetY() * this.unitScale;
/* 112 */             float f8 = f7 + textureRegion.getRegionWidth() * this.unitScale;
/* 113 */             float f9 = f6 + textureRegion.getRegionHeight() * this.unitScale;
/*     */             
/* 115 */             float f10 = textureRegion.getU();
/* 116 */             float f11 = textureRegion.getV2();
/* 117 */             float f12 = textureRegion.getU2();
/* 118 */             float f13 = textureRegion.getV();
/*     */             
/* 120 */             arrayOfFloat[0] = f7;
/* 121 */             arrayOfFloat[1] = f6;
/* 122 */             arrayOfFloat[2] = f1;
/* 123 */             arrayOfFloat[3] = f10;
/* 124 */             arrayOfFloat[4] = f11;
/*     */             
/* 126 */             arrayOfFloat[5] = f7;
/* 127 */             arrayOfFloat[6] = f9;
/* 128 */             arrayOfFloat[7] = f1;
/* 129 */             arrayOfFloat[8] = f10;
/* 130 */             arrayOfFloat[9] = f13;
/*     */             
/* 132 */             arrayOfFloat[10] = f8;
/* 133 */             arrayOfFloat[11] = f9;
/* 134 */             arrayOfFloat[12] = f1;
/* 135 */             arrayOfFloat[13] = f12;
/* 136 */             arrayOfFloat[14] = f13;
/*     */             
/* 138 */             arrayOfFloat[15] = f8;
/* 139 */             arrayOfFloat[16] = f6;
/* 140 */             arrayOfFloat[17] = f1;
/* 141 */             arrayOfFloat[18] = f12;
/* 142 */             arrayOfFloat[19] = f11;
/*     */             
/* 144 */             if (bool1) {
/* 145 */               f6 = arrayOfFloat[3];
/* 146 */               arrayOfFloat[3] = arrayOfFloat[13];
/* 147 */               arrayOfFloat[13] = f6;
/* 148 */               f6 = arrayOfFloat[8];
/* 149 */               arrayOfFloat[8] = arrayOfFloat[18];
/* 150 */               arrayOfFloat[18] = f6;
/*     */             } 
/* 152 */             if (bool2) {
/* 153 */               f6 = arrayOfFloat[4];
/* 154 */               arrayOfFloat[4] = arrayOfFloat[14];
/* 155 */               arrayOfFloat[14] = f6;
/* 156 */               f6 = arrayOfFloat[9];
/* 157 */               arrayOfFloat[9] = arrayOfFloat[19];
/* 158 */               arrayOfFloat[19] = f6;
/*     */             } 
/* 160 */             if (i1 != 0) {
/* 161 */               float f14; switch (i1) {
/*     */                 case 1:
/* 163 */                   f6 = arrayOfFloat[4];
/* 164 */                   arrayOfFloat[4] = arrayOfFloat[9];
/* 165 */                   arrayOfFloat[9] = arrayOfFloat[14];
/* 166 */                   arrayOfFloat[14] = arrayOfFloat[19];
/* 167 */                   arrayOfFloat[19] = f6;
/*     */                   
/* 169 */                   f14 = arrayOfFloat[3];
/* 170 */                   arrayOfFloat[3] = arrayOfFloat[8];
/* 171 */                   arrayOfFloat[8] = arrayOfFloat[13];
/* 172 */                   arrayOfFloat[13] = arrayOfFloat[18];
/* 173 */                   arrayOfFloat[18] = f14;
/*     */                   break;
/*     */                 
/*     */                 case 2:
/* 177 */                   f6 = arrayOfFloat[3];
/* 178 */                   arrayOfFloat[3] = arrayOfFloat[13];
/* 179 */                   arrayOfFloat[13] = f6;
/* 180 */                   f6 = arrayOfFloat[8];
/* 181 */                   arrayOfFloat[8] = arrayOfFloat[18];
/* 182 */                   arrayOfFloat[18] = f6;
/* 183 */                   f14 = arrayOfFloat[4];
/* 184 */                   arrayOfFloat[4] = arrayOfFloat[14];
/* 185 */                   arrayOfFloat[14] = f14;
/* 186 */                   f14 = arrayOfFloat[9];
/* 187 */                   arrayOfFloat[9] = arrayOfFloat[19];
/* 188 */                   arrayOfFloat[19] = f14;
/*     */                   break;
/*     */                 
/*     */                 case 3:
/* 192 */                   f6 = arrayOfFloat[4];
/* 193 */                   arrayOfFloat[4] = arrayOfFloat[19];
/* 194 */                   arrayOfFloat[19] = arrayOfFloat[14];
/* 195 */                   arrayOfFloat[14] = arrayOfFloat[9];
/* 196 */                   arrayOfFloat[9] = f6;
/*     */                   
/* 198 */                   f14 = arrayOfFloat[3];
/* 199 */                   arrayOfFloat[3] = arrayOfFloat[18];
/* 200 */                   arrayOfFloat[18] = arrayOfFloat[13];
/* 201 */                   arrayOfFloat[13] = arrayOfFloat[8];
/* 202 */                   arrayOfFloat[8] = f14;
/*     */                   break;
/*     */               } 
/*     */             
/*     */             } 
/* 207 */             this.batch.draw(textureRegion.getTexture(), arrayOfFloat, 0, 20);
/*     */           } 
/* 209 */         }  f += f2;
/*     */       } 
/* 211 */       f5 -= f3;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\maps\tiled\renderers\OrthogonalTiledMapRenderer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */