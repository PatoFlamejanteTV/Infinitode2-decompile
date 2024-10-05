/*     */ package com.badlogic.gdx.maps.objects;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.maps.MapObject;
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
/*     */ public class TextureMapObject
/*     */   extends MapObject
/*     */ {
/*  25 */   private float x = 0.0F;
/*  26 */   private float y = 0.0F;
/*  27 */   private float originX = 0.0F;
/*  28 */   private float originY = 0.0F;
/*  29 */   private float scaleX = 1.0F;
/*  30 */   private float scaleY = 1.0F;
/*  31 */   private float rotation = 0.0F;
/*  32 */   private TextureRegion textureRegion = null;
/*     */ 
/*     */   
/*     */   public float getX() {
/*  36 */     return this.x;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setX(float paramFloat) {
/*  41 */     this.x = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getY() {
/*  46 */     return this.y;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setY(float paramFloat) {
/*  51 */     this.y = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getOriginX() {
/*  56 */     return this.originX;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setOriginX(float paramFloat) {
/*  61 */     this.originX = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getOriginY() {
/*  66 */     return this.originY;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setOriginY(float paramFloat) {
/*  71 */     this.originY = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getScaleX() {
/*  76 */     return this.scaleX;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setScaleX(float paramFloat) {
/*  81 */     this.scaleX = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getScaleY() {
/*  86 */     return this.scaleY;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setScaleY(float paramFloat) {
/*  91 */     this.scaleY = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getRotation() {
/*  96 */     return this.rotation;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotation(float paramFloat) {
/* 101 */     this.rotation = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public TextureRegion getTextureRegion() {
/* 106 */     return this.textureRegion;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTextureRegion(TextureRegion paramTextureRegion) {
/* 111 */     this.textureRegion = paramTextureRegion;
/*     */   }
/*     */ 
/*     */   
/*     */   public TextureMapObject() {
/* 116 */     this(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TextureMapObject(TextureRegion paramTextureRegion) {
/* 124 */     this.textureRegion = paramTextureRegion;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\maps\objects\TextureMapObject.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */