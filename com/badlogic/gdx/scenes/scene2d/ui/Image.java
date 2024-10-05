/*     */ package com.badlogic.gdx.scenes.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.NinePatch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.TransformDrawable;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.Scaling;
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
/*     */ public class Image
/*     */   extends Widget
/*     */ {
/*     */   private Scaling scaling;
/*  38 */   private int align = 1;
/*     */   
/*     */   private float imageX;
/*     */   private float imageY;
/*     */   
/*     */   public Image() {
/*  44 */     this((Drawable)null);
/*     */   }
/*     */   private float imageWidth; private float imageHeight;
/*     */   private Drawable drawable;
/*     */   
/*     */   public Image(@Null NinePatch paramNinePatch) {
/*  50 */     this((Drawable)new NinePatchDrawable(paramNinePatch), Scaling.stretch, 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Image(@Null TextureRegion paramTextureRegion) {
/*  56 */     this((Drawable)new TextureRegionDrawable(paramTextureRegion), Scaling.stretch, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public Image(Texture paramTexture) {
/*  61 */     this((Drawable)new TextureRegionDrawable(new TextureRegion(paramTexture)));
/*     */   }
/*     */ 
/*     */   
/*     */   public Image(Skin paramSkin, String paramString) {
/*  66 */     this(paramSkin.getDrawable(paramString), Scaling.stretch, 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Image(@Null Drawable paramDrawable) {
/*  72 */     this(paramDrawable, Scaling.stretch, 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Image(@Null Drawable paramDrawable, Scaling paramScaling) {
/*  78 */     this(paramDrawable, paramScaling, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public Image(@Null Drawable paramDrawable, Scaling paramScaling, int paramInt) {
/*  83 */     setDrawable(paramDrawable);
/*  84 */     this.scaling = paramScaling;
/*  85 */     this.align = paramInt;
/*  86 */     setSize(getPrefWidth(), getPrefHeight());
/*     */   }
/*     */   
/*     */   public void layout() {
/*  90 */     if (this.drawable == null)
/*     */       return; 
/*  92 */     float f1 = this.drawable.getMinWidth();
/*  93 */     float f2 = this.drawable.getMinHeight();
/*  94 */     float f3 = getWidth();
/*  95 */     float f4 = getHeight();
/*     */     
/*  97 */     Vector2 vector2 = this.scaling.apply(f1, f2, f3, f4);
/*  98 */     this.imageWidth = vector2.x;
/*  99 */     this.imageHeight = vector2.y;
/*     */     
/* 101 */     if ((this.align & 0x8) != 0) {
/* 102 */       this.imageX = 0.0F;
/* 103 */     } else if ((this.align & 0x10) != 0) {
/* 104 */       this.imageX = (int)(f3 - this.imageWidth);
/*     */     } else {
/* 106 */       this.imageX = (int)(f3 / 2.0F - this.imageWidth / 2.0F);
/*     */     } 
/* 108 */     if ((this.align & 0x2) != 0) {
/* 109 */       this.imageY = (int)(f4 - this.imageHeight); return;
/* 110 */     }  if ((this.align & 0x4) != 0) {
/* 111 */       this.imageY = 0.0F; return;
/*     */     } 
/* 113 */     this.imageY = (int)(f4 / 2.0F - this.imageHeight / 2.0F);
/*     */   }
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/* 117 */     validate();
/*     */     
/* 119 */     Color color = getColor();
/* 120 */     paramBatch.setColor(color.r, color.g, color.b, color.a * paramFloat);
/*     */     
/* 122 */     paramFloat = getX();
/* 123 */     float f1 = getY();
/* 124 */     float f2 = getScaleX();
/* 125 */     float f3 = getScaleY();
/*     */     
/* 127 */     if (this.drawable instanceof TransformDrawable) {
/* 128 */       float f = getRotation();
/* 129 */       if (f2 != 1.0F || f3 != 1.0F || f != 0.0F) {
/* 130 */         ((TransformDrawable)this.drawable).draw(paramBatch, paramFloat + this.imageX, f1 + this.imageY, getOriginX() - this.imageX, getOriginY() - this.imageY, this.imageWidth, this.imageHeight, f2, f3, f);
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/* 135 */     if (this.drawable != null) this.drawable.draw(paramBatch, paramFloat + this.imageX, f1 + this.imageY, this.imageWidth * f2, this.imageHeight * f3); 
/*     */   }
/*     */   
/*     */   public void setDrawable(Skin paramSkin, String paramString) {
/* 139 */     setDrawable(paramSkin.getDrawable(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDrawable(@Null Drawable paramDrawable) {
/* 146 */     if (this.drawable == paramDrawable)
/* 147 */       return;  if (paramDrawable != null) {
/* 148 */       if (getPrefWidth() != paramDrawable.getMinWidth() || getPrefHeight() != paramDrawable.getMinHeight()) invalidateHierarchy(); 
/*     */     } else {
/* 150 */       invalidateHierarchy();
/* 151 */     }  this.drawable = paramDrawable;
/*     */   }
/*     */   
/*     */   @Null
/*     */   public Drawable getDrawable() {
/* 156 */     return this.drawable;
/*     */   }
/*     */   
/*     */   public void setScaling(Scaling paramScaling) {
/* 160 */     if (paramScaling == null) throw new IllegalArgumentException("scaling cannot be null."); 
/* 161 */     this.scaling = paramScaling;
/* 162 */     invalidate();
/*     */   }
/*     */   
/*     */   public void setAlign(int paramInt) {
/* 166 */     this.align = paramInt;
/* 167 */     invalidate();
/*     */   }
/*     */   
/*     */   public int getAlign() {
/* 171 */     return this.align;
/*     */   }
/*     */   
/*     */   public float getMinWidth() {
/* 175 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public float getMinHeight() {
/* 179 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public float getPrefWidth() {
/* 183 */     if (this.drawable != null) return this.drawable.getMinWidth(); 
/* 184 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public float getPrefHeight() {
/* 188 */     if (this.drawable != null) return this.drawable.getMinHeight(); 
/* 189 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public float getImageX() {
/* 193 */     return this.imageX;
/*     */   }
/*     */   
/*     */   public float getImageY() {
/* 197 */     return this.imageY;
/*     */   }
/*     */   
/*     */   public float getImageWidth() {
/* 201 */     return this.imageWidth;
/*     */   }
/*     */   
/*     */   public float getImageHeight() {
/* 205 */     return this.imageHeight;
/*     */   }
/*     */   
/*     */   public String toString() {
/*     */     String str;
/* 210 */     if ((str = getName()) != null) return str;
/*     */     
/*     */     int i;
/* 213 */     if ((i = (str = getClass().getName()).lastIndexOf('.')) != -1) str = str.substring(i + 1); 
/* 214 */     return ((str.indexOf('$') != -1) ? "Image " : "") + str + ": " + this.drawable;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\ui\Image.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */