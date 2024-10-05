/*     */ package com.badlogic.gdx.scenes.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
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
/*     */ 
/*     */ public class ImageButton
/*     */   extends Button
/*     */ {
/*     */   private final Image image;
/*     */   private ImageButtonStyle style;
/*     */   
/*     */   public ImageButton(Skin paramSkin) {
/*  34 */     this(paramSkin.<ImageButtonStyle>get(ImageButtonStyle.class));
/*  35 */     setSkin(paramSkin);
/*     */   }
/*     */   
/*     */   public ImageButton(Skin paramSkin, String paramString) {
/*  39 */     this(paramSkin.<ImageButtonStyle>get(paramString, ImageButtonStyle.class));
/*  40 */     setSkin(paramSkin);
/*     */   }
/*     */   
/*     */   public ImageButton(ImageButtonStyle paramImageButtonStyle) {
/*  44 */     super(paramImageButtonStyle);
/*  45 */     this.image = newImage();
/*  46 */     add(this.image);
/*  47 */     setStyle(paramImageButtonStyle);
/*  48 */     setSize(getPrefWidth(), getPrefHeight());
/*     */   }
/*     */   
/*     */   public ImageButton(@Null Drawable paramDrawable) {
/*  52 */     this(new ImageButtonStyle(null, null, null, paramDrawable, null, null));
/*     */   }
/*     */   
/*     */   public ImageButton(@Null Drawable paramDrawable1, @Null Drawable paramDrawable2) {
/*  56 */     this(new ImageButtonStyle(null, null, null, paramDrawable1, paramDrawable2, null));
/*     */   }
/*     */   
/*     */   public ImageButton(@Null Drawable paramDrawable1, @Null Drawable paramDrawable2, @Null Drawable paramDrawable3) {
/*  60 */     this(new ImageButtonStyle(null, null, null, paramDrawable1, paramDrawable2, paramDrawable3));
/*     */   }
/*     */   
/*     */   protected Image newImage() {
/*  64 */     return new Image((Drawable)null, Scaling.fit);
/*     */   }
/*     */   
/*     */   public void setStyle(Button.ButtonStyle paramButtonStyle) {
/*  68 */     if (!(paramButtonStyle instanceof ImageButtonStyle)) throw new IllegalArgumentException("style must be an ImageButtonStyle."); 
/*  69 */     this.style = (ImageButtonStyle)paramButtonStyle;
/*  70 */     super.setStyle(paramButtonStyle);
/*     */     
/*  72 */     if (this.image != null) updateImage(); 
/*     */   }
/*     */   
/*     */   public ImageButtonStyle getStyle() {
/*  76 */     return this.style;
/*     */   }
/*     */   
/*     */   @Null
/*     */   protected Drawable getImageDrawable() {
/*  81 */     if (isDisabled() && this.style.imageDisabled != null) return this.style.imageDisabled; 
/*  82 */     if (isPressed()) {
/*  83 */       if (isChecked() && this.style.imageCheckedDown != null) return this.style.imageCheckedDown; 
/*  84 */       if (this.style.imageDown != null) return this.style.imageDown; 
/*     */     } 
/*  86 */     if (isOver()) {
/*  87 */       if (isChecked())
/*  88 */       { if (this.style.imageCheckedOver != null) return this.style.imageCheckedOver;
/*     */          }
/*  90 */       else if (this.style.imageOver != null) { return this.style.imageOver; }
/*     */     
/*     */     }
/*  93 */     if (isChecked()) {
/*  94 */       if (this.style.imageChecked != null) return this.style.imageChecked; 
/*  95 */       if (isOver() && this.style.imageOver != null) return this.style.imageOver; 
/*     */     } 
/*  97 */     return this.style.imageUp;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateImage() {
/* 103 */     this.image.setDrawable(getImageDrawable());
/*     */   }
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/* 107 */     updateImage();
/* 108 */     super.draw(paramBatch, paramFloat);
/*     */   }
/*     */   
/*     */   public Image getImage() {
/* 112 */     return this.image;
/*     */   }
/*     */   
/*     */   public Cell getImageCell() {
/* 116 */     return getCell(this.image);
/*     */   }
/*     */   
/*     */   public String toString() {
/*     */     String str;
/* 121 */     if ((str = getName()) != null) return str;
/*     */     
/*     */     int i;
/* 124 */     if ((i = (str = getClass().getName()).lastIndexOf('.')) != -1) str = str.substring(i + 1); 
/* 125 */     return ((str.indexOf('$') != -1) ? "ImageButton " : "") + str + ": " + this.image.getDrawable();
/*     */   }
/*     */   
/*     */   public static class ImageButtonStyle extends Button.ButtonStyle {
/*     */     @Null
/*     */     public Drawable imageUp;
/*     */     @Null
/*     */     public Drawable imageDown;
/*     */     @Null
/*     */     public Drawable imageOver;
/*     */     @Null
/*     */     public Drawable imageDisabled;
/*     */     
/*     */     public ImageButtonStyle(@Null Drawable param1Drawable1, @Null Drawable param1Drawable2, @Null Drawable param1Drawable3, @Null Drawable param1Drawable4, @Null Drawable param1Drawable5, @Null Drawable param1Drawable6) {
/* 139 */       super(param1Drawable1, param1Drawable2, param1Drawable3);
/* 140 */       this.imageUp = param1Drawable4;
/* 141 */       this.imageDown = param1Drawable5;
/* 142 */       this.imageChecked = param1Drawable6; } @Null
/*     */     public Drawable imageChecked; @Null
/*     */     public Drawable imageCheckedDown; @Null
/*     */     public Drawable imageCheckedOver; public ImageButtonStyle() {} public ImageButtonStyle(ImageButtonStyle param1ImageButtonStyle) {
/* 146 */       super(param1ImageButtonStyle);
/* 147 */       this.imageUp = param1ImageButtonStyle.imageUp;
/* 148 */       this.imageDown = param1ImageButtonStyle.imageDown;
/* 149 */       this.imageOver = param1ImageButtonStyle.imageOver;
/* 150 */       this.imageDisabled = param1ImageButtonStyle.imageDisabled;
/*     */       
/* 152 */       this.imageChecked = param1ImageButtonStyle.imageChecked;
/* 153 */       this.imageCheckedDown = param1ImageButtonStyle.imageCheckedDown;
/* 154 */       this.imageCheckedOver = param1ImageButtonStyle.imageCheckedOver;
/*     */     }
/*     */     
/*     */     public ImageButtonStyle(Button.ButtonStyle param1ButtonStyle) {
/* 158 */       super(param1ButtonStyle);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\ui\ImageButton.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */