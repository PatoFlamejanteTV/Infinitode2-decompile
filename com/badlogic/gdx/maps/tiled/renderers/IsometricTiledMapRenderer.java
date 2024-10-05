/*     */ package com.badlogic.gdx.maps.tiled.renderers;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.maps.tiled.TiledMap;
/*     */ import com.badlogic.gdx.maps.tiled.TiledMapTile;
/*     */ import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
/*     */ import com.badlogic.gdx.math.Matrix4;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.math.Vector3;
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
/*     */ public class IsometricTiledMapRenderer
/*     */   extends BatchTiledMapRenderer
/*     */ {
/*     */   private Matrix4 isoTransform;
/*     */   private Matrix4 invIsotransform;
/*  36 */   private Vector3 screenPos = new Vector3();
/*     */   
/*  38 */   private Vector2 topRight = new Vector2();
/*  39 */   private Vector2 bottomLeft = new Vector2();
/*  40 */   private Vector2 topLeft = new Vector2();
/*  41 */   private Vector2 bottomRight = new Vector2();
/*     */   
/*     */   public IsometricTiledMapRenderer(TiledMap paramTiledMap) {
/*  44 */     super(paramTiledMap);
/*  45 */     init();
/*     */   }
/*     */   
/*     */   public IsometricTiledMapRenderer(TiledMap paramTiledMap, Batch paramBatch) {
/*  49 */     super(paramTiledMap, paramBatch);
/*  50 */     init();
/*     */   }
/*     */   
/*     */   public IsometricTiledMapRenderer(TiledMap paramTiledMap, float paramFloat) {
/*  54 */     super(paramTiledMap, paramFloat);
/*  55 */     init();
/*     */   }
/*     */   
/*     */   public IsometricTiledMapRenderer(TiledMap paramTiledMap, float paramFloat, Batch paramBatch) {
/*  59 */     super(paramTiledMap, paramFloat, paramBatch);
/*  60 */     init();
/*     */   }
/*     */ 
/*     */   
/*     */   private void init() {
/*  65 */     this.isoTransform = new Matrix4();
/*  66 */     this.isoTransform.idt();
/*     */ 
/*     */     
/*  69 */     this.isoTransform.scale((float)(Math.sqrt(2.0D) / 2.0D), (float)(Math.sqrt(2.0D) / 4.0D), 1.0F);
/*  70 */     this.isoTransform.rotate(0.0F, 0.0F, 1.0F, -45.0F);
/*     */ 
/*     */     
/*  73 */     this.invIsotransform = new Matrix4(this.isoTransform);
/*  74 */     this.invIsotransform.inv();
/*     */   }
/*     */   
/*     */   private Vector3 translateScreenToIso(Vector2 paramVector2) {
/*  78 */     this.screenPos.set(paramVector2.x, paramVector2.y, 0.0F);
/*  79 */     this.screenPos.mul(this.invIsotransform);
/*     */     
/*  81 */     return this.screenPos;
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderTileLayer(TiledMapTileLayer paramTiledMapTileLayer) {
/*     */     Color color;
/*  87 */     float f1 = Color.toFloatBits((color = this.batch.getColor()).r, color.g, color.b, color.a * paramTiledMapTileLayer.getOpacity());
/*     */     
/*  89 */     float f2 = paramTiledMapTileLayer.getTileWidth() * this.unitScale;
/*  90 */     float f3 = paramTiledMapTileLayer.getTileHeight() * this.unitScale;
/*     */     
/*  92 */     float f4 = paramTiledMapTileLayer.getRenderOffsetX() * this.unitScale - this.viewBounds.x * (paramTiledMapTileLayer.getParallaxX() - 1.0F);
/*     */     
/*  94 */     float f5 = -paramTiledMapTileLayer.getRenderOffsetY() * this.unitScale - this.viewBounds.y * (paramTiledMapTileLayer.getParallaxY() - 1.0F);
/*     */     
/*  96 */     float f6 = f2 * 0.5F;
/*  97 */     f3 *= 0.5F;
/*     */ 
/*     */ 
/*     */     
/* 101 */     this.topRight.set(this.viewBounds.x + this.viewBounds.width - f4, this.viewBounds.y - f5);
/*     */     
/* 103 */     this.bottomLeft.set(this.viewBounds.x - f4, this.viewBounds.y + this.viewBounds.height - f5);
/*     */     
/* 105 */     this.topLeft.set(this.viewBounds.x - f4, this.viewBounds.y - f5);
/*     */     
/* 107 */     this.bottomRight.set(this.viewBounds.x + this.viewBounds.width - f4, this.viewBounds.y + this.viewBounds.height - f5);
/*     */ 
/*     */     
/* 110 */     int j = (int)((translateScreenToIso(this.topLeft)).y / f2) - 2;
/* 111 */     int k = (int)((translateScreenToIso(this.bottomRight)).y / f2) + 2;
/*     */     
/* 113 */     int m = (int)((translateScreenToIso(this.bottomLeft)).x / f2) - 2;
/* 114 */     int i = (int)((translateScreenToIso(this.topRight)).x / f2) + 2;
/*     */     
/* 116 */     for (k = k; k >= j; k--) {
/* 117 */       for (int n = m; n <= i; n++) {
/* 118 */         float f7 = n * f6 + k * f6;
/* 119 */         float f8 = k * f3 - n * f3;
/*     */         TiledMapTileLayer.Cell cell;
/*     */         TiledMapTile tiledMapTile;
/* 122 */         if ((cell = paramTiledMapTileLayer.getCell(n, k)) != null && (
/*     */ 
/*     */           
/* 125 */           tiledMapTile = cell.getTile()) != null) {
/* 126 */           boolean bool1 = cell.getFlipHorizontally();
/* 127 */           boolean bool2 = cell.getFlipVertically();
/* 128 */           int i1 = cell.getRotation();
/*     */           
/* 130 */           TextureRegion textureRegion = tiledMapTile.getTextureRegion();
/*     */           
/* 132 */           f7 = f7 + tiledMapTile.getOffsetX() * this.unitScale + f4;
/* 133 */           f8 = f8 + tiledMapTile.getOffsetY() * this.unitScale + f5;
/* 134 */           float f9 = f7 + textureRegion.getRegionWidth() * this.unitScale;
/* 135 */           float f10 = f8 + textureRegion.getRegionHeight() * this.unitScale;
/*     */           
/* 137 */           float f11 = textureRegion.getU();
/* 138 */           float f12 = textureRegion.getV2();
/* 139 */           float f13 = textureRegion.getU2();
/* 140 */           float f14 = textureRegion.getV();
/*     */           
/* 142 */           this.vertices[0] = f7;
/* 143 */           this.vertices[1] = f8;
/* 144 */           this.vertices[2] = f1;
/* 145 */           this.vertices[3] = f11;
/* 146 */           this.vertices[4] = f12;
/*     */           
/* 148 */           this.vertices[5] = f7;
/* 149 */           this.vertices[6] = f10;
/* 150 */           this.vertices[7] = f1;
/* 151 */           this.vertices[8] = f11;
/* 152 */           this.vertices[9] = f14;
/*     */           
/* 154 */           this.vertices[10] = f9;
/* 155 */           this.vertices[11] = f10;
/* 156 */           this.vertices[12] = f1;
/* 157 */           this.vertices[13] = f13;
/* 158 */           this.vertices[14] = f14;
/*     */           
/* 160 */           this.vertices[15] = f9;
/* 161 */           this.vertices[16] = f8;
/* 162 */           this.vertices[17] = f1;
/* 163 */           this.vertices[18] = f13;
/* 164 */           this.vertices[19] = f12;
/*     */           
/* 166 */           if (bool1) {
/* 167 */             f7 = this.vertices[3];
/* 168 */             this.vertices[3] = this.vertices[13];
/* 169 */             this.vertices[13] = f7;
/* 170 */             f7 = this.vertices[8];
/* 171 */             this.vertices[8] = this.vertices[18];
/* 172 */             this.vertices[18] = f7;
/*     */           } 
/* 174 */           if (bool2) {
/* 175 */             f7 = this.vertices[4];
/* 176 */             this.vertices[4] = this.vertices[14];
/* 177 */             this.vertices[14] = f7;
/* 178 */             f7 = this.vertices[9];
/* 179 */             this.vertices[9] = this.vertices[19];
/* 180 */             this.vertices[19] = f7;
/*     */           } 
/* 182 */           if (i1 != 0) {
/* 183 */             switch (i1) {
/*     */               case 1:
/* 185 */                 f7 = this.vertices[4];
/* 186 */                 this.vertices[4] = this.vertices[9];
/* 187 */                 this.vertices[9] = this.vertices[14];
/* 188 */                 this.vertices[14] = this.vertices[19];
/* 189 */                 this.vertices[19] = f7;
/*     */                 
/* 191 */                 f7 = this.vertices[3];
/* 192 */                 this.vertices[3] = this.vertices[8];
/* 193 */                 this.vertices[8] = this.vertices[13];
/* 194 */                 this.vertices[13] = this.vertices[18];
/* 195 */                 this.vertices[18] = f7;
/*     */                 break;
/*     */               
/*     */               case 2:
/* 199 */                 f7 = this.vertices[3];
/* 200 */                 this.vertices[3] = this.vertices[13];
/* 201 */                 this.vertices[13] = f7;
/* 202 */                 f7 = this.vertices[8];
/* 203 */                 this.vertices[8] = this.vertices[18];
/* 204 */                 this.vertices[18] = f7;
/* 205 */                 f7 = this.vertices[4];
/* 206 */                 this.vertices[4] = this.vertices[14];
/* 207 */                 this.vertices[14] = f7;
/* 208 */                 f7 = this.vertices[9];
/* 209 */                 this.vertices[9] = this.vertices[19];
/* 210 */                 this.vertices[19] = f7;
/*     */                 break;
/*     */               
/*     */               case 3:
/* 214 */                 f7 = this.vertices[4];
/* 215 */                 this.vertices[4] = this.vertices[19];
/* 216 */                 this.vertices[19] = this.vertices[14];
/* 217 */                 this.vertices[14] = this.vertices[9];
/* 218 */                 this.vertices[9] = f7;
/*     */                 
/* 220 */                 f7 = this.vertices[3];
/* 221 */                 this.vertices[3] = this.vertices[18];
/* 222 */                 this.vertices[18] = this.vertices[13];
/* 223 */                 this.vertices[13] = this.vertices[8];
/* 224 */                 this.vertices[8] = f7;
/*     */                 break;
/*     */             } 
/*     */           
/*     */           }
/* 229 */           this.batch.draw(textureRegion.getTexture(), this.vertices, 0, 20);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\maps\tiled\renderers\IsometricTiledMapRenderer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */