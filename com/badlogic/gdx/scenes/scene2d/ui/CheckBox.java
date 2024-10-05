/*     */ package com.badlogic.gdx.scenes.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
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
/*     */ public class CheckBox
/*     */   extends TextButton
/*     */ {
/*     */   private Image image;
/*     */   private Cell imageCell;
/*     */   private CheckBoxStyle style;
/*     */   
/*     */   public CheckBox(@Null String paramString, Skin paramSkin) {
/*  35 */     this(paramString, paramSkin.<CheckBoxStyle>get(CheckBoxStyle.class));
/*     */   }
/*     */   
/*     */   public CheckBox(@Null String paramString1, Skin paramSkin, String paramString2) {
/*  39 */     this(paramString1, paramSkin.<CheckBoxStyle>get(paramString2, CheckBoxStyle.class));
/*     */   }
/*     */   
/*     */   public CheckBox(@Null String paramString, CheckBoxStyle paramCheckBoxStyle) {
/*  43 */     super(paramString, paramCheckBoxStyle);
/*     */     
/*     */     Label label;
/*  46 */     (label = getLabel()).setAlignment(8);
/*     */     
/*  48 */     this.image = newImage();
/*  49 */     this.image.setDrawable(paramCheckBoxStyle.checkboxOff);
/*     */     
/*  51 */     clearChildren();
/*  52 */     this.imageCell = add(this.image);
/*  53 */     add(label);
/*  54 */     setSize(getPrefWidth(), getPrefHeight());
/*     */   }
/*     */   
/*     */   protected Image newImage() {
/*  58 */     return new Image((Drawable)null, Scaling.none);
/*     */   }
/*     */   
/*     */   public void setStyle(Button.ButtonStyle paramButtonStyle) {
/*  62 */     if (!(paramButtonStyle instanceof CheckBoxStyle)) throw new IllegalArgumentException("style must be a CheckBoxStyle."); 
/*  63 */     this.style = (CheckBoxStyle)paramButtonStyle;
/*  64 */     super.setStyle(paramButtonStyle);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CheckBoxStyle getStyle() {
/*  70 */     return this.style;
/*     */   }
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/*  74 */     this.image.setDrawable(getImageDrawable());
/*  75 */     super.draw(paramBatch, paramFloat);
/*     */   }
/*     */   @Null
/*     */   protected Drawable getImageDrawable() {
/*  79 */     if (isDisabled()) {
/*  80 */       if (this.isChecked && this.style.checkboxOnDisabled != null) return this.style.checkboxOnDisabled; 
/*  81 */       return this.style.checkboxOffDisabled;
/*     */     } 
/*  83 */     boolean bool = (isOver() && !isDisabled()) ? true : false;
/*  84 */     if (this.isChecked && this.style.checkboxOn != null)
/*  85 */       return (bool && this.style.checkboxOnOver != null) ? this.style.checkboxOnOver : this.style.checkboxOn; 
/*  86 */     if (bool && this.style.checkboxOver != null) return this.style.checkboxOver; 
/*  87 */     return this.style.checkboxOff;
/*     */   }
/*     */   
/*     */   public Image getImage() {
/*  91 */     return this.image;
/*     */   }
/*     */   
/*     */   public Cell getImageCell() {
/*  95 */     return this.imageCell;
/*     */   }
/*     */ 
/*     */   
/*     */   public static class CheckBoxStyle
/*     */     extends TextButton.TextButtonStyle
/*     */   {
/*     */     public Drawable checkboxOn;
/*     */     public Drawable checkboxOff;
/*     */     @Null
/*     */     public Drawable checkboxOnOver;
/*     */     
/*     */     public CheckBoxStyle(Drawable param1Drawable1, Drawable param1Drawable2, BitmapFont param1BitmapFont, @Null Color param1Color) {
/* 108 */       this.checkboxOff = param1Drawable1;
/* 109 */       this.checkboxOn = param1Drawable2;
/* 110 */       this.font = param1BitmapFont;
/* 111 */       this.fontColor = param1Color; } @Null
/*     */     public Drawable checkboxOver; @Null
/*     */     public Drawable checkboxOnDisabled; @Null
/*     */     public Drawable checkboxOffDisabled; public CheckBoxStyle() {} public CheckBoxStyle(CheckBoxStyle param1CheckBoxStyle) {
/* 115 */       super(param1CheckBoxStyle);
/* 116 */       this.checkboxOff = param1CheckBoxStyle.checkboxOff;
/* 117 */       this.checkboxOn = param1CheckBoxStyle.checkboxOn;
/*     */       
/* 119 */       this.checkboxOnOver = param1CheckBoxStyle.checkboxOnOver;
/* 120 */       this.checkboxOver = param1CheckBoxStyle.checkboxOver;
/* 121 */       this.checkboxOnDisabled = param1CheckBoxStyle.checkboxOnDisabled;
/* 122 */       this.checkboxOffDisabled = param1CheckBoxStyle.checkboxOffDisabled;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\ui\CheckBox.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */