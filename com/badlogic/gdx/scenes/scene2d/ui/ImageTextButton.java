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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ImageTextButton
/*     */   extends Button
/*     */ {
/*     */   private final Image image;
/*     */   private Label label;
/*     */   private ImageTextButtonStyle style;
/*     */   
/*     */   public ImageTextButton(@Null String paramString, Skin paramSkin) {
/*  40 */     this(paramString, paramSkin.<ImageTextButtonStyle>get(ImageTextButtonStyle.class));
/*  41 */     setSkin(paramSkin);
/*     */   }
/*     */   
/*     */   public ImageTextButton(@Null String paramString1, Skin paramSkin, String paramString2) {
/*  45 */     this(paramString1, paramSkin.<ImageTextButtonStyle>get(paramString2, ImageTextButtonStyle.class));
/*  46 */     setSkin(paramSkin);
/*     */   }
/*     */   
/*     */   public ImageTextButton(@Null String paramString, ImageTextButtonStyle paramImageTextButtonStyle) {
/*  50 */     super(paramImageTextButtonStyle);
/*  51 */     this.style = paramImageTextButtonStyle;
/*     */     
/*  53 */     defaults().space(3.0F);
/*     */     
/*  55 */     this.image = newImage();
/*     */     
/*  57 */     this.label = newLabel(paramString, new Label.LabelStyle(paramImageTextButtonStyle.font, paramImageTextButtonStyle.fontColor));
/*  58 */     this.label.setAlignment(1);
/*     */     
/*  60 */     add(this.image);
/*  61 */     add(this.label);
/*     */     
/*  63 */     setStyle(paramImageTextButtonStyle);
/*     */     
/*  65 */     setSize(getPrefWidth(), getPrefHeight());
/*     */   }
/*     */   
/*     */   protected Image newImage() {
/*  69 */     return new Image((Drawable)null, Scaling.fit);
/*     */   }
/*     */   
/*     */   protected Label newLabel(String paramString, Label.LabelStyle paramLabelStyle) {
/*  73 */     return new Label(paramString, paramLabelStyle);
/*     */   }
/*     */   
/*     */   public void setStyle(Button.ButtonStyle paramButtonStyle) {
/*  77 */     if (!(paramButtonStyle instanceof ImageTextButtonStyle)) throw new IllegalArgumentException("style must be a ImageTextButtonStyle."); 
/*  78 */     this.style = (ImageTextButtonStyle)paramButtonStyle;
/*  79 */     super.setStyle(paramButtonStyle);
/*     */     
/*  81 */     if (this.image != null) updateImage();
/*     */     
/*  83 */     if (this.label != null) {
/*  84 */       paramButtonStyle = paramButtonStyle;
/*     */       Label.LabelStyle labelStyle;
/*  86 */       (labelStyle = this.label.getStyle()).font = ((ImageTextButtonStyle)paramButtonStyle).font;
/*  87 */       labelStyle.fontColor = getFontColor();
/*  88 */       this.label.setStyle(labelStyle);
/*     */     } 
/*     */   }
/*     */   
/*     */   public ImageTextButtonStyle getStyle() {
/*  93 */     return this.style;
/*     */   }
/*     */   
/*     */   @Null
/*     */   protected Drawable getImageDrawable() {
/*  98 */     if (isDisabled() && this.style.imageDisabled != null) return this.style.imageDisabled; 
/*  99 */     if (isPressed()) {
/* 100 */       if (isChecked() && this.style.imageCheckedDown != null) return this.style.imageCheckedDown; 
/* 101 */       if (this.style.imageDown != null) return this.style.imageDown; 
/*     */     } 
/* 103 */     if (isOver()) {
/* 104 */       if (isChecked())
/* 105 */       { if (this.style.imageCheckedOver != null) return this.style.imageCheckedOver;
/*     */          }
/* 107 */       else if (this.style.imageOver != null) { return this.style.imageOver; }
/*     */     
/*     */     }
/* 110 */     if (isChecked()) {
/* 111 */       if (this.style.imageChecked != null) return this.style.imageChecked; 
/* 112 */       if (isOver() && this.style.imageOver != null) return this.style.imageOver; 
/*     */     } 
/* 114 */     return this.style.imageUp;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateImage() {
/* 120 */     this.image.setDrawable(getImageDrawable());
/*     */   }
/*     */   
/*     */   @Null
/*     */   protected Color getFontColor() {
/* 125 */     if (isDisabled() && this.style.disabledFontColor != null) return this.style.disabledFontColor; 
/* 126 */     if (isPressed()) {
/* 127 */       if (isChecked() && this.style.checkedDownFontColor != null) return this.style.checkedDownFontColor; 
/* 128 */       if (this.style.downFontColor != null) return this.style.downFontColor; 
/*     */     } 
/* 130 */     if (isOver()) {
/* 131 */       if (isChecked())
/* 132 */       { if (this.style.checkedOverFontColor != null) return this.style.checkedOverFontColor;
/*     */          }
/* 134 */       else if (this.style.overFontColor != null) { return this.style.overFontColor; }
/*     */     
/*     */     }
/* 137 */     boolean bool = hasKeyboardFocus();
/* 138 */     if (isChecked()) {
/* 139 */       if (bool && this.style.checkedFocusedFontColor != null) return this.style.checkedFocusedFontColor; 
/* 140 */       if (this.style.checkedFontColor != null) return this.style.checkedFontColor; 
/* 141 */       if (isOver() && this.style.overFontColor != null) return this.style.overFontColor; 
/*     */     } 
/* 143 */     if (bool && this.style.focusedFontColor != null) return this.style.focusedFontColor; 
/* 144 */     return this.style.fontColor;
/*     */   }
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/* 148 */     updateImage();
/* 149 */     (this.label.getStyle()).fontColor = getFontColor();
/* 150 */     super.draw(paramBatch, paramFloat);
/*     */   }
/*     */   
/*     */   public Image getImage() {
/* 154 */     return this.image;
/*     */   }
/*     */   
/*     */   public Cell getImageCell() {
/* 158 */     return getCell(this.image);
/*     */   }
/*     */   
/*     */   public void setLabel(Label paramLabel) {
/* 162 */     getLabelCell().setActor(paramLabel);
/* 163 */     this.label = paramLabel;
/*     */   }
/*     */   
/*     */   public Label getLabel() {
/* 167 */     return this.label;
/*     */   }
/*     */   
/*     */   public Cell getLabelCell() {
/* 171 */     return getCell(this.label);
/*     */   }
/*     */   
/*     */   public void setText(CharSequence paramCharSequence) {
/* 175 */     this.label.setText(paramCharSequence);
/*     */   }
/*     */   
/*     */   public CharSequence getText() {
/* 179 */     return (CharSequence)this.label.getText();
/*     */   }
/*     */   
/*     */   public String toString() {
/*     */     String str;
/* 184 */     if ((str = getName()) != null) return str;
/*     */     
/*     */     int i;
/* 187 */     if ((i = (str = getClass().getName()).lastIndexOf('.')) != -1) str = str.substring(i + 1); 
/* 188 */     return ((str.indexOf('$') != -1) ? "ImageTextButton " : "") + str + ": " + this.image.getDrawable() + " " + this.label
/* 189 */       .getText();
/*     */   }
/*     */   
/*     */   public static class ImageTextButtonStyle extends TextButton.TextButtonStyle {
/*     */     @Null
/*     */     public Drawable imageUp;
/*     */     @Null
/*     */     public Drawable imageDown;
/*     */     @Null
/*     */     public Drawable imageOver;
/*     */     @Null
/*     */     public Drawable imageDisabled;
/*     */     
/* 202 */     public ImageTextButtonStyle(@Null Drawable param1Drawable1, @Null Drawable param1Drawable2, @Null Drawable param1Drawable3, BitmapFont param1BitmapFont) { super(param1Drawable1, param1Drawable2, param1Drawable3, param1BitmapFont); } @Null
/*     */     public Drawable imageChecked; @Null
/*     */     public Drawable imageCheckedDown; @Null
/*     */     public Drawable imageCheckedOver; public ImageTextButtonStyle() {} public ImageTextButtonStyle(ImageTextButtonStyle param1ImageTextButtonStyle) {
/* 206 */       super(param1ImageTextButtonStyle);
/* 207 */       this.imageUp = param1ImageTextButtonStyle.imageUp;
/* 208 */       this.imageDown = param1ImageTextButtonStyle.imageDown;
/* 209 */       this.imageOver = param1ImageTextButtonStyle.imageOver;
/* 210 */       this.imageDisabled = param1ImageTextButtonStyle.imageDisabled;
/*     */       
/* 212 */       this.imageChecked = param1ImageTextButtonStyle.imageChecked;
/* 213 */       this.imageCheckedDown = param1ImageTextButtonStyle.imageCheckedDown;
/* 214 */       this.imageCheckedOver = param1ImageTextButtonStyle.imageCheckedOver;
/*     */     }
/*     */     
/*     */     public ImageTextButtonStyle(TextButton.TextButtonStyle param1TextButtonStyle) {
/* 218 */       super(param1TextButtonStyle);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\ui\ImageTextButton.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */