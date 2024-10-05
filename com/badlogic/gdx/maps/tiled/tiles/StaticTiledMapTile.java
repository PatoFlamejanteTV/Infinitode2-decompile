/*     */ package com.badlogic.gdx.maps.tiled.tiles;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.maps.MapObjects;
/*     */ import com.badlogic.gdx.maps.MapProperties;
/*     */ import com.badlogic.gdx.maps.tiled.TiledMapTile;
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
/*     */ public class StaticTiledMapTile
/*     */   implements TiledMapTile
/*     */ {
/*     */   private int id;
/*  29 */   private TiledMapTile.BlendMode blendMode = TiledMapTile.BlendMode.ALPHA;
/*     */   
/*     */   private MapProperties properties;
/*     */   
/*     */   private MapObjects objects;
/*     */   
/*     */   private TextureRegion textureRegion;
/*     */   
/*     */   private float offsetX;
/*     */   
/*     */   private float offsetY;
/*     */ 
/*     */   
/*     */   public int getId() {
/*  43 */     return this.id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setId(int paramInt) {
/*  48 */     this.id = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public TiledMapTile.BlendMode getBlendMode() {
/*  53 */     return this.blendMode;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBlendMode(TiledMapTile.BlendMode paramBlendMode) {
/*  58 */     this.blendMode = paramBlendMode;
/*     */   }
/*     */ 
/*     */   
/*     */   public MapProperties getProperties() {
/*  63 */     if (this.properties == null) {
/*  64 */       this.properties = new MapProperties();
/*     */     }
/*  66 */     return this.properties;
/*     */   }
/*     */ 
/*     */   
/*     */   public MapObjects getObjects() {
/*  71 */     if (this.objects == null) {
/*  72 */       this.objects = new MapObjects();
/*     */     }
/*  74 */     return this.objects;
/*     */   }
/*     */ 
/*     */   
/*     */   public TextureRegion getTextureRegion() {
/*  79 */     return this.textureRegion;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTextureRegion(TextureRegion paramTextureRegion) {
/*  84 */     this.textureRegion = paramTextureRegion;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getOffsetX() {
/*  89 */     return this.offsetX;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setOffsetX(float paramFloat) {
/*  94 */     this.offsetX = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getOffsetY() {
/*  99 */     return this.offsetY;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setOffsetY(float paramFloat) {
/* 104 */     this.offsetY = paramFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StaticTiledMapTile(TextureRegion paramTextureRegion) {
/* 111 */     this.textureRegion = paramTextureRegion;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StaticTiledMapTile(StaticTiledMapTile paramStaticTiledMapTile) {
/* 118 */     if (paramStaticTiledMapTile.properties != null) {
/* 119 */       getProperties().putAll(paramStaticTiledMapTile.properties);
/*     */     }
/* 121 */     this.objects = paramStaticTiledMapTile.objects;
/* 122 */     this.textureRegion = paramStaticTiledMapTile.textureRegion;
/* 123 */     this.id = paramStaticTiledMapTile.id;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\maps\tiled\tiles\StaticTiledMapTile.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */