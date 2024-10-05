/*     */ package com.prineside.tdi2.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.Scaling;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.actors.Label;
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
/*     */   private Image n;
/*     */   private Cell o;
/*     */   private CheckBoxStyle p;
/*     */   
/*     */   public CheckBox(@Null String paramString, CheckBoxStyle paramCheckBoxStyle) {
/*  36 */     super(paramString, paramCheckBoxStyle);
/*     */     
/*     */     Label label;
/*  39 */     (label = getLabel()).setAlignment(8);
/*     */     
/*  41 */     this.n = d();
/*  42 */     this.n.setDrawable(paramCheckBoxStyle.checkboxOff);
/*     */     
/*  44 */     clearChildren();
/*  45 */     this.o = add(this.n);
/*  46 */     add(label);
/*  47 */     setSize(getPrefWidth(), getPrefHeight());
/*     */   }
/*     */   
/*     */   private static Image d() {
/*  51 */     return new Image((Drawable)null, Scaling.none);
/*     */   }
/*     */   
/*     */   public void setStyle(Button.ButtonStyle paramButtonStyle) {
/*  55 */     if (!(paramButtonStyle instanceof CheckBoxStyle)) throw new IllegalArgumentException("style must be a CheckBoxStyle."); 
/*  56 */     this.p = (CheckBoxStyle)paramButtonStyle;
/*  57 */     super.setStyle(paramButtonStyle);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CheckBoxStyle getStyle() {
/*  63 */     return this.p;
/*     */   }
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/*  67 */     this.n.setDrawable(e());
/*  68 */     super.draw(paramBatch, paramFloat);
/*     */   }
/*     */   @Null
/*     */   private Drawable e() {
/*  72 */     if (isDisabled()) {
/*  73 */       if (this.k && this.p.checkboxOnDisabled != null) return this.p.checkboxOnDisabled; 
/*  74 */       return this.p.checkboxOffDisabled;
/*     */     } 
/*  76 */     boolean bool = (isOver() && !isDisabled()) ? true : false;
/*  77 */     if (this.k && this.p.checkboxOn != null)
/*  78 */       return (bool && this.p.checkboxOnOver != null) ? this.p.checkboxOnOver : this.p.checkboxOn; 
/*  79 */     if (bool && this.p.checkboxOver != null) return this.p.checkboxOver; 
/*  80 */     return this.p.checkboxOff;
/*     */   }
/*     */   
/*     */   public Image getImage() {
/*  84 */     return this.n;
/*     */   }
/*     */   
/*     */   public Cell getImageCell() {
/*  88 */     return this.o;
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
/* 101 */       this.checkboxOff = param1Drawable1;
/* 102 */       this.checkboxOn = param1Drawable2;
/* 103 */       this.font = param1BitmapFont;
/* 104 */       this.fontColor = param1Color; } @Null
/*     */     public Drawable checkboxOver; @Null
/*     */     public Drawable checkboxOnDisabled; @Null
/*     */     public Drawable checkboxOffDisabled; public CheckBoxStyle() {} public CheckBoxStyle(CheckBoxStyle param1CheckBoxStyle) {
/* 108 */       super(param1CheckBoxStyle);
/* 109 */       this.checkboxOff = param1CheckBoxStyle.checkboxOff;
/* 110 */       this.checkboxOn = param1CheckBoxStyle.checkboxOn;
/*     */       
/* 112 */       this.checkboxOnOver = param1CheckBoxStyle.checkboxOnOver;
/* 113 */       this.checkboxOver = param1CheckBoxStyle.checkboxOver;
/* 114 */       this.checkboxOnDisabled = param1CheckBoxStyle.checkboxOnDisabled;
/* 115 */       this.checkboxOffDisabled = param1CheckBoxStyle.checkboxOffDisabled;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\ui\CheckBox.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */