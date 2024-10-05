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
/*     */ public class HexagonalTiledMapRenderer
/*     */   extends BatchTiledMapRenderer
/*     */ {
/*     */   private boolean staggerAxisX = true;
/*     */   private boolean staggerIndexEven = false;
/*  39 */   private float hexSideLength = 0.0F;
/*     */   
/*     */   public HexagonalTiledMapRenderer(TiledMap paramTiledMap) {
/*  42 */     super(paramTiledMap);
/*  43 */     init(paramTiledMap);
/*     */   }
/*     */   
/*     */   public HexagonalTiledMapRenderer(TiledMap paramTiledMap, float paramFloat) {
/*  47 */     super(paramTiledMap, paramFloat);
/*  48 */     init(paramTiledMap);
/*     */   }
/*     */   
/*     */   public HexagonalTiledMapRenderer(TiledMap paramTiledMap, Batch paramBatch) {
/*  52 */     super(paramTiledMap, paramBatch);
/*  53 */     init(paramTiledMap);
/*     */   }
/*     */   
/*     */   public HexagonalTiledMapRenderer(TiledMap paramTiledMap, float paramFloat, Batch paramBatch) {
/*  57 */     super(paramTiledMap, paramFloat, paramBatch);
/*  58 */     init(paramTiledMap);
/*     */   }
/*     */   
/*     */   private void init(TiledMap paramTiledMap) {
/*     */     String str;
/*  63 */     if ((str = (String)paramTiledMap.getProperties().get("staggeraxis", String.class)) != null) {
/*  64 */       if (str.equals("x")) {
/*  65 */         this.staggerAxisX = true;
/*     */       } else {
/*  67 */         this.staggerAxisX = false;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*  72 */     if ((str = (String)paramTiledMap.getProperties().get("staggerindex", String.class)) != null) {
/*  73 */       if (str.equals("even")) {
/*  74 */         this.staggerIndexEven = true;
/*     */       } else {
/*  76 */         this.staggerIndexEven = false;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  82 */     if (!this.staggerAxisX && ((Integer)paramTiledMap.getProperties().get("height", Integer.class)).intValue() % 2 == 0) this.staggerIndexEven = !this.staggerIndexEven;
/*     */     
/*     */     Integer integer;
/*  85 */     if ((integer = (Integer)paramTiledMap.getProperties().get("hexsidelength", Integer.class)) != null) {
/*  86 */       this.hexSideLength = integer.intValue(); return;
/*     */     } 
/*  88 */     if (this.staggerAxisX) {
/*     */       
/*  90 */       if ((integer = (Integer)paramTiledMap.getProperties().get("tilewidth", Integer.class)) != null) {
/*  91 */         this.hexSideLength = 0.5F * integer.intValue(); return;
/*     */       } 
/*  93 */       tiledMapTileLayer = (TiledMapTileLayer)paramTiledMap.getLayers().get(0);
/*  94 */       this.hexSideLength = 0.5F * tiledMapTileLayer.getTileWidth();
/*     */       
/*     */       return;
/*     */     } 
/*  98 */     if ((integer = (Integer)tiledMapTileLayer.getProperties().get("tileheight", Integer.class)) != null) {
/*  99 */       this.hexSideLength = 0.5F * integer.intValue(); return;
/*     */     } 
/* 101 */     TiledMapTileLayer tiledMapTileLayer = (TiledMapTileLayer)tiledMapTileLayer.getLayers().get(0);
/* 102 */     this.hexSideLength = 0.5F * tiledMapTileLayer.getTileHeight();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderTileLayer(TiledMapTileLayer paramTiledMapTileLayer) {
/*     */     int k;
/*     */     Color color;
/* 111 */     float f1 = Color.toFloatBits((color = this.batch.getColor()).r, color.g, color.b, color.a * paramTiledMapTileLayer.getOpacity());
/*     */     
/* 113 */     int i = paramTiledMapTileLayer.getWidth();
/* 114 */     int j = paramTiledMapTileLayer.getHeight();
/*     */     
/* 116 */     float f2 = paramTiledMapTileLayer.getTileWidth() * this.unitScale;
/* 117 */     float f3 = paramTiledMapTileLayer.getTileHeight() * this.unitScale;
/*     */     
/* 119 */     float f4 = paramTiledMapTileLayer.getRenderOffsetX() * this.unitScale - this.viewBounds.x * (paramTiledMapTileLayer.getParallaxX() - 1.0F);
/*     */     
/* 121 */     float f5 = -paramTiledMapTileLayer.getRenderOffsetY() * this.unitScale - this.viewBounds.y * (paramTiledMapTileLayer.getParallaxY() - 1.0F);
/*     */     
/* 123 */     float f6 = this.hexSideLength * this.unitScale;
/*     */     
/* 125 */     if (this.staggerAxisX) {
/* 126 */       float f9 = (f2 - f6) / 2.0F;
/* 127 */       f6 = (f2 + f6) / 2.0F;
/* 128 */       float f10 = f3 * 0.5F;
/*     */       
/* 130 */       int i3 = Math.max(0, (int)((this.viewBounds.y - f10 - f4) / f3));
/* 131 */       j = Math.min(j, (int)((this.viewBounds.y + this.viewBounds.height + f3 - f4) / f3));
/*     */ 
/*     */       
/* 134 */       int i2 = Math.max(0, (int)((this.viewBounds.x - f9 - f5) / f6));
/* 135 */       i = Math.min(i, (int)((this.viewBounds.x + this.viewBounds.width + f6 - f5) / f6));
/*     */ 
/*     */ 
/*     */       
/* 139 */       int i4 = (this.staggerIndexEven == ((i2 % 2 == 0))) ? (i2 + 1) : i2;
/* 140 */       int i5 = (this.staggerIndexEven == ((i2 % 2 == 0))) ? i2 : (i2 + 1);
/*     */       
/* 142 */       for (; --j >= i3; j--) {
/* 143 */         for (k = i4; k < i; k += 2) {
/* 144 */           renderCell(paramTiledMapTileLayer.getCell(k, j), f6 * k + f4, f10 + f3 * j + f5, f1);
/*     */         }
/*     */         
/* 147 */         for (k = i5; k < i; k += 2) {
/* 148 */           renderCell(paramTiledMapTileLayer.getCell(k, j), f6 * k + f4, f3 * j + f5, f1);
/*     */         }
/*     */       } 
/*     */       return;
/*     */     } 
/* 153 */     float f7 = (f3 - f6) / 2.0F;
/* 154 */     f6 = (f3 + f6) / 2.0F;
/* 155 */     float f8 = k * 0.5F;
/*     */     
/* 157 */     int n = Math.max(0, (int)((this.viewBounds.y - f7 - f4) / f6));
/* 158 */     j = Math.min(j, (int)((this.viewBounds.y + this.viewBounds.height + f6 - f4) / f6));
/*     */ 
/*     */     
/* 161 */     int m = Math.max(0, (int)((this.viewBounds.x - f8 - f5) / k));
/* 162 */     i = Math.min(i, (int)((this.viewBounds.x + this.viewBounds.width + k - f5) / k));
/*     */ 
/*     */ 
/*     */     
/* 166 */     for (int i1 = j - 1; i1 >= n; i1--) {
/*     */       float f;
/* 168 */       if (((i1 % 2 == 0)) == this.staggerIndexEven) {
/* 169 */         f = f8;
/*     */       } else {
/* 171 */         f = 0.0F;
/* 172 */       }  for (j = m; j < i; j++) {
/* 173 */         renderCell(paramTiledMapTileLayer.getCell(j, i1), k * j + f + f4, f6 * i1 + f5, f1);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void renderCell(TiledMapTileLayer.Cell paramCell, float paramFloat1, float paramFloat2, float paramFloat3) {
/*     */     TiledMapTile tiledMapTile;
/* 182 */     if (paramCell != null && (
/*     */       
/* 184 */       tiledMapTile = paramCell.getTile()) != null) {
/* 185 */       if (tiledMapTile instanceof com.badlogic.gdx.maps.tiled.tiles.AnimatedTiledMapTile)
/*     */         return; 
/* 187 */       boolean bool1 = paramCell.getFlipHorizontally();
/* 188 */       boolean bool2 = paramCell.getFlipVertically();
/* 189 */       int i = paramCell.getRotation();
/*     */       
/* 191 */       TextureRegion textureRegion = tiledMapTile.getTextureRegion();
/*     */       
/* 193 */       paramFloat1 += tiledMapTile.getOffsetX() * this.unitScale;
/* 194 */       paramFloat2 += tiledMapTile.getOffsetY() * this.unitScale;
/* 195 */       float f1 = paramFloat1 + textureRegion.getRegionWidth() * this.unitScale;
/* 196 */       float f2 = paramFloat2 + textureRegion.getRegionHeight() * this.unitScale;
/*     */       
/* 198 */       float f3 = textureRegion.getU();
/* 199 */       float f4 = textureRegion.getV2();
/* 200 */       float f5 = textureRegion.getU2();
/* 201 */       float f6 = textureRegion.getV();
/*     */       
/* 203 */       this.vertices[0] = paramFloat1;
/* 204 */       this.vertices[1] = paramFloat2;
/* 205 */       this.vertices[2] = paramFloat3;
/* 206 */       this.vertices[3] = f3;
/* 207 */       this.vertices[4] = f4;
/*     */       
/* 209 */       this.vertices[5] = paramFloat1;
/* 210 */       this.vertices[6] = f2;
/* 211 */       this.vertices[7] = paramFloat3;
/* 212 */       this.vertices[8] = f3;
/* 213 */       this.vertices[9] = f6;
/*     */       
/* 215 */       this.vertices[10] = f1;
/* 216 */       this.vertices[11] = f2;
/* 217 */       this.vertices[12] = paramFloat3;
/* 218 */       this.vertices[13] = f5;
/* 219 */       this.vertices[14] = f6;
/*     */       
/* 221 */       this.vertices[15] = f1;
/* 222 */       this.vertices[16] = paramFloat2;
/* 223 */       this.vertices[17] = paramFloat3;
/* 224 */       this.vertices[18] = f5;
/* 225 */       this.vertices[19] = f4;
/*     */       
/* 227 */       if (bool1) {
/* 228 */         paramFloat1 = this.vertices[3];
/* 229 */         this.vertices[3] = this.vertices[13];
/* 230 */         this.vertices[13] = paramFloat1;
/* 231 */         paramFloat1 = this.vertices[8];
/* 232 */         this.vertices[8] = this.vertices[18];
/* 233 */         this.vertices[18] = paramFloat1;
/*     */       } 
/* 235 */       if (bool2) {
/* 236 */         paramFloat1 = this.vertices[4];
/* 237 */         this.vertices[4] = this.vertices[14];
/* 238 */         this.vertices[14] = paramFloat1;
/* 239 */         paramFloat1 = this.vertices[9];
/* 240 */         this.vertices[9] = this.vertices[19];
/* 241 */         this.vertices[19] = paramFloat1;
/*     */       } 
/* 243 */       if (i == 2) {
/* 244 */         paramFloat1 = this.vertices[3];
/* 245 */         this.vertices[3] = this.vertices[13];
/* 246 */         this.vertices[13] = paramFloat1;
/* 247 */         paramFloat1 = this.vertices[8];
/* 248 */         this.vertices[8] = this.vertices[18];
/* 249 */         this.vertices[18] = paramFloat1;
/* 250 */         float f = this.vertices[4];
/* 251 */         this.vertices[4] = this.vertices[14];
/* 252 */         this.vertices[14] = f;
/* 253 */         f = this.vertices[9];
/* 254 */         this.vertices[9] = this.vertices[19];
/* 255 */         this.vertices[19] = f;
/*     */       } 
/* 257 */       this.batch.draw(textureRegion.getTexture(), this.vertices, 0, 20);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\maps\tiled\renderers\HexagonalTiledMapRenderer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */