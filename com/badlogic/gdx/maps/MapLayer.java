/*     */ package com.badlogic.gdx.maps;
/*     */ 
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
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
/*     */ public class MapLayer
/*     */ {
/*  23 */   private String name = "";
/*  24 */   private float opacity = 1.0F;
/*     */   private boolean visible = true;
/*     */   private float offsetX;
/*     */   private float offsetY;
/*     */   private float renderOffsetX;
/*     */   private float renderOffsetY;
/*  30 */   private float parallaxX = 1.0F;
/*  31 */   private float parallaxY = 1.0F;
/*     */   private boolean renderOffsetDirty = true;
/*     */   private MapLayer parent;
/*  34 */   private MapObjects objects = new MapObjects();
/*  35 */   private MapProperties properties = new MapProperties();
/*     */ 
/*     */   
/*     */   public String getName() {
/*  39 */     return this.name;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setName(String paramString) {
/*  44 */     this.name = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getOpacity() {
/*  49 */     return this.opacity;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setOpacity(float paramFloat) {
/*  54 */     this.opacity = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getOffsetX() {
/*  59 */     return this.offsetX;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setOffsetX(float paramFloat) {
/*  64 */     this.offsetX = paramFloat;
/*  65 */     invalidateRenderOffset();
/*     */   }
/*     */ 
/*     */   
/*     */   public float getOffsetY() {
/*  70 */     return this.offsetY;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setOffsetY(float paramFloat) {
/*  75 */     this.offsetY = paramFloat;
/*  76 */     invalidateRenderOffset();
/*     */   }
/*     */ 
/*     */   
/*     */   public float getParallaxX() {
/*  81 */     return this.parallaxX;
/*     */   }
/*     */   
/*     */   public void setParallaxX(float paramFloat) {
/*  85 */     this.parallaxX = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getParallaxY() {
/*  90 */     return this.parallaxY;
/*     */   }
/*     */   
/*     */   public void setParallaxY(float paramFloat) {
/*  94 */     this.parallaxY = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getRenderOffsetX() {
/*  99 */     if (this.renderOffsetDirty) calculateRenderOffsets(); 
/* 100 */     return this.renderOffsetX;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getRenderOffsetY() {
/* 105 */     if (this.renderOffsetDirty) calculateRenderOffsets(); 
/* 106 */     return this.renderOffsetY;
/*     */   }
/*     */ 
/*     */   
/*     */   public void invalidateRenderOffset() {
/* 111 */     this.renderOffsetDirty = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public MapLayer getParent() {
/* 116 */     return this.parent;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setParent(MapLayer paramMapLayer) {
/* 121 */     if (paramMapLayer == this) throw new GdxRuntimeException("Can't set self as the parent"); 
/* 122 */     this.parent = paramMapLayer;
/*     */   }
/*     */ 
/*     */   
/*     */   public MapObjects getObjects() {
/* 127 */     return this.objects;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isVisible() {
/* 132 */     return this.visible;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setVisible(boolean paramBoolean) {
/* 137 */     this.visible = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public MapProperties getProperties() {
/* 142 */     return this.properties;
/*     */   }
/*     */   
/*     */   protected void calculateRenderOffsets() {
/* 146 */     if (this.parent != null) {
/* 147 */       this.parent.calculateRenderOffsets();
/* 148 */       this.renderOffsetX = this.parent.getRenderOffsetX() + this.offsetX;
/* 149 */       this.renderOffsetY = this.parent.getRenderOffsetY() + this.offsetY;
/*     */     } else {
/* 151 */       this.renderOffsetX = this.offsetX;
/* 152 */       this.renderOffsetY = this.offsetY;
/*     */     } 
/* 154 */     this.renderOffsetDirty = false;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\maps\MapLayer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */