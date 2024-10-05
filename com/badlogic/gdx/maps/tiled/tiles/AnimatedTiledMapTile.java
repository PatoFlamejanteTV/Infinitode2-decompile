/*     */ package com.badlogic.gdx.maps.tiled.tiles;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.maps.MapObjects;
/*     */ import com.badlogic.gdx.maps.MapProperties;
/*     */ import com.badlogic.gdx.maps.tiled.TiledMapTile;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.badlogic.gdx.utils.TimeUtils;
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
/*     */ public class AnimatedTiledMapTile
/*     */   implements TiledMapTile
/*     */ {
/*  31 */   private static long lastTiledMapRenderTime = 0L;
/*     */   
/*     */   private int id;
/*     */   
/*  35 */   private TiledMapTile.BlendMode blendMode = TiledMapTile.BlendMode.ALPHA;
/*     */   
/*     */   private MapProperties properties;
/*     */   
/*     */   private MapObjects objects;
/*     */   
/*     */   private StaticTiledMapTile[] frameTiles;
/*     */   
/*     */   private int[] animationIntervals;
/*     */   private int loopDuration;
/*  45 */   private static final long initialTimeOffset = TimeUtils.millis();
/*     */ 
/*     */   
/*     */   public int getId() {
/*  49 */     return this.id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setId(int paramInt) {
/*  54 */     this.id = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public TiledMapTile.BlendMode getBlendMode() {
/*  59 */     return this.blendMode;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBlendMode(TiledMapTile.BlendMode paramBlendMode) {
/*  64 */     this.blendMode = paramBlendMode;
/*     */   }
/*     */   
/*     */   public int getCurrentFrameIndex() {
/*  68 */     int i = (int)(lastTiledMapRenderTime % this.loopDuration);
/*     */     
/*  70 */     for (byte b = 0; b < this.animationIntervals.length; b++) {
/*  71 */       int j = this.animationIntervals[b];
/*  72 */       if (i <= j) return b; 
/*  73 */       i -= j;
/*     */     } 
/*     */     
/*  76 */     throw new GdxRuntimeException("Could not determine current animation frame in AnimatedTiledMapTile.  This should never happen.");
/*     */   }
/*     */ 
/*     */   
/*     */   public TiledMapTile getCurrentFrame() {
/*  81 */     return this.frameTiles[getCurrentFrameIndex()];
/*     */   }
/*     */ 
/*     */   
/*     */   public TextureRegion getTextureRegion() {
/*  86 */     return getCurrentFrame().getTextureRegion();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTextureRegion(TextureRegion paramTextureRegion) {
/*  91 */     throw new GdxRuntimeException("Cannot set the texture region of AnimatedTiledMapTile.");
/*     */   }
/*     */ 
/*     */   
/*     */   public float getOffsetX() {
/*  96 */     return getCurrentFrame().getOffsetX();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setOffsetX(float paramFloat) {
/* 101 */     throw new GdxRuntimeException("Cannot set offset of AnimatedTiledMapTile.");
/*     */   }
/*     */ 
/*     */   
/*     */   public float getOffsetY() {
/* 106 */     return getCurrentFrame().getOffsetY();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setOffsetY(float paramFloat) {
/* 111 */     throw new GdxRuntimeException("Cannot set offset of AnimatedTiledMapTile.");
/*     */   }
/*     */   
/*     */   public int[] getAnimationIntervals() {
/* 115 */     return this.animationIntervals;
/*     */   }
/*     */   
/*     */   public void setAnimationIntervals(int[] paramArrayOfint) {
/* 119 */     if (paramArrayOfint.length == this.animationIntervals.length) {
/* 120 */       this.animationIntervals = paramArrayOfint;
/*     */       
/* 122 */       this.loopDuration = 0;
/* 123 */       for (byte b = 0; b < paramArrayOfint.length; b++) {
/* 124 */         this.loopDuration += paramArrayOfint[b];
/*     */       }
/*     */       return;
/*     */     } 
/* 128 */     throw new GdxRuntimeException("Cannot set " + paramArrayOfint.length + " frame intervals. The given int[] must have a size of " + this.animationIntervals.length + ".");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MapProperties getProperties() {
/* 135 */     if (this.properties == null) {
/* 136 */       this.properties = new MapProperties();
/*     */     }
/* 138 */     return this.properties;
/*     */   }
/*     */ 
/*     */   
/*     */   public MapObjects getObjects() {
/* 143 */     if (this.objects == null) {
/* 144 */       this.objects = new MapObjects();
/*     */     }
/* 146 */     return this.objects;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void updateAnimationBaseTime() {
/* 152 */     lastTiledMapRenderTime = TimeUtils.millis() - initialTimeOffset;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AnimatedTiledMapTile(float paramFloat, Array<StaticTiledMapTile> paramArray) {
/* 160 */     this.frameTiles = new StaticTiledMapTile[paramArray.size];
/*     */     
/* 162 */     this.loopDuration = paramArray.size * (int)(paramFloat * 1000.0F);
/* 163 */     this.animationIntervals = new int[paramArray.size];
/* 164 */     for (byte b = 0; b < paramArray.size; b++) {
/* 165 */       this.frameTiles[b] = (StaticTiledMapTile)paramArray.get(b);
/* 166 */       this.animationIntervals[b] = (int)(paramFloat * 1000.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AnimatedTiledMapTile(IntArray paramIntArray, Array<StaticTiledMapTile> paramArray) {
/* 175 */     this.frameTiles = new StaticTiledMapTile[paramArray.size];
/*     */     
/* 177 */     this.animationIntervals = paramIntArray.toArray();
/* 178 */     this.loopDuration = 0;
/*     */     
/* 180 */     for (byte b = 0; b < paramIntArray.size; b++) {
/* 181 */       this.frameTiles[b] = (StaticTiledMapTile)paramArray.get(b);
/* 182 */       this.loopDuration += paramIntArray.get(b);
/*     */     } 
/*     */   }
/*     */   
/*     */   public StaticTiledMapTile[] getFrameTiles() {
/* 187 */     return this.frameTiles;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\maps\tiled\tiles\AnimatedTiledMapTile.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */