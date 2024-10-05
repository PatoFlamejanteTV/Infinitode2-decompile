/*     */ package com.prineside.tdi2.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.NinePatch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.Scaling;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.scene2d.utils.NinePatchDrawable;
/*     */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*     */ import com.prineside.tdi2.scene2d.utils.TransformDrawable;
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
/*     */   private Scaling j;
/*  38 */   private int k = 1;
/*     */   
/*     */   private float l;
/*     */   private float m;
/*     */   
/*     */   public Image() {
/*  44 */     this((Drawable)null);
/*     */   }
/*     */   private float n; private float o;
/*     */   private Drawable p;
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
/*     */   
/*     */   public Image(@Null Drawable paramDrawable) {
/*  67 */     this(paramDrawable, Scaling.stretch, 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Image(@Null Drawable paramDrawable, Scaling paramScaling) {
/*  73 */     this(paramDrawable, paramScaling, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public Image(@Null Drawable paramDrawable, Scaling paramScaling, int paramInt) {
/*  78 */     setDrawable(paramDrawable);
/*  79 */     this.j = paramScaling;
/*  80 */     this.k = paramInt;
/*  81 */     setSize(getPrefWidth(), getPrefHeight());
/*     */   }
/*     */   
/*     */   public void layout() {
/*  85 */     if (this.p == null)
/*     */       return; 
/*  87 */     float f1 = this.p.getMinWidth();
/*  88 */     float f2 = this.p.getMinHeight();
/*  89 */     float f3 = getWidth();
/*  90 */     float f4 = getHeight();
/*     */     
/*  92 */     Vector2 vector2 = this.j.apply(f1, f2, f3, f4);
/*  93 */     this.n = vector2.x;
/*  94 */     this.o = vector2.y;
/*     */     
/*  96 */     if ((this.k & 0x8) != 0) {
/*  97 */       this.l = 0.0F;
/*  98 */     } else if ((this.k & 0x10) != 0) {
/*  99 */       this.l = (int)(f3 - this.n);
/*     */     } else {
/* 101 */       this.l = (int)(f3 / 2.0F - this.n / 2.0F);
/*     */     } 
/* 103 */     if ((this.k & 0x2) != 0) {
/* 104 */       this.m = (int)(f4 - this.o); return;
/* 105 */     }  if ((this.k & 0x4) != 0) {
/* 106 */       this.m = 0.0F; return;
/*     */     } 
/* 108 */     this.m = (int)(f4 / 2.0F - this.o / 2.0F);
/*     */   }
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/* 112 */     validate();
/*     */     
/* 114 */     Color color = getColor();
/* 115 */     paramBatch.setColor(color.r, color.g, color.b, color.a * paramFloat);
/*     */     
/* 117 */     paramFloat = getX();
/* 118 */     float f1 = getY();
/* 119 */     float f2 = getScaleX();
/* 120 */     float f3 = getScaleY();
/*     */     
/* 122 */     if (this.p instanceof TransformDrawable) {
/* 123 */       float f = getRotation();
/* 124 */       if (f2 != 1.0F || f3 != 1.0F || f != 0.0F) {
/* 125 */         ((TransformDrawable)this.p).draw(paramBatch, paramFloat + this.l, f1 + this.m, getOriginX() - this.l, getOriginY() - this.m, this.n, this.o, f2, f3, f);
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/* 130 */     if (this.p != null) this.p.draw(paramBatch, paramFloat + this.l, f1 + this.m, this.n * f2, this.o * f3);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDrawable(@Null Drawable paramDrawable) {
/* 137 */     if (this.p == paramDrawable)
/* 138 */       return;  if (paramDrawable != null) {
/* 139 */       if (getPrefWidth() != paramDrawable.getMinWidth() || getPrefHeight() != paramDrawable.getMinHeight()) invalidateHierarchy(); 
/*     */     } else {
/* 141 */       invalidateHierarchy();
/* 142 */     }  this.p = paramDrawable;
/*     */   }
/*     */   
/*     */   @Null
/*     */   public Drawable getDrawable() {
/* 147 */     return this.p;
/*     */   }
/*     */   
/*     */   public void setScaling(Scaling paramScaling) {
/* 151 */     if (paramScaling == null) throw new IllegalArgumentException("scaling cannot be null."); 
/* 152 */     this.j = paramScaling;
/* 153 */     invalidate();
/*     */   }
/*     */   
/*     */   public void setAlign(int paramInt) {
/* 157 */     this.k = paramInt;
/* 158 */     invalidate();
/*     */   }
/*     */   
/*     */   public int getAlign() {
/* 162 */     return this.k;
/*     */   }
/*     */   
/*     */   public float getMinWidth() {
/* 166 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public float getMinHeight() {
/* 170 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public float getPrefWidth() {
/* 174 */     if (this.p != null) return this.p.getMinWidth(); 
/* 175 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public float getPrefHeight() {
/* 179 */     if (this.p != null) return this.p.getMinHeight(); 
/* 180 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public float getImageX() {
/* 184 */     return this.l;
/*     */   }
/*     */   
/*     */   public float getImageY() {
/* 188 */     return this.m;
/*     */   }
/*     */   
/*     */   public float getImageWidth() {
/* 192 */     return this.n;
/*     */   }
/*     */   
/*     */   public float getImageHeight() {
/* 196 */     return this.o;
/*     */   }
/*     */   
/*     */   public String toString() {
/*     */     String str;
/* 201 */     if ((str = getName()) != null) return str;
/*     */     
/*     */     int i;
/* 204 */     if ((i = (str = getClass().getName()).lastIndexOf('.')) != -1) str = str.substring(i + 1); 
/* 205 */     return ((str.indexOf('$') != -1) ? "Image " : "") + str + ": " + this.p;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\ui\Image.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */