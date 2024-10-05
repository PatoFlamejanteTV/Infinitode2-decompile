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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ImageTextButton
/*     */   extends Button
/*     */ {
/*     */   private final Image n;
/*     */   private Label o;
/*     */   private ImageTextButtonStyle p;
/*     */   
/*     */   public ImageTextButton(@Null String paramString, ImageTextButtonStyle paramImageTextButtonStyle) {
/*  40 */     super(paramImageTextButtonStyle);
/*  41 */     this.p = paramImageTextButtonStyle;
/*     */     
/*  43 */     defaults().space(3.0F);
/*     */     
/*  45 */     this.n = d();
/*     */     
/*  47 */     this.o = a(paramString, new Label.LabelStyle(paramImageTextButtonStyle.font, paramImageTextButtonStyle.fontColor));
/*  48 */     this.o.setAlignment(1);
/*     */     
/*  50 */     add(this.n);
/*  51 */     add(this.o);
/*     */     
/*  53 */     setStyle(paramImageTextButtonStyle);
/*     */     
/*  55 */     setSize(getPrefWidth(), getPrefHeight());
/*     */   }
/*     */   
/*     */   private static Image d() {
/*  59 */     return new Image((Drawable)null, Scaling.fit);
/*     */   }
/*     */   
/*     */   private static Label a(String paramString, Label.LabelStyle paramLabelStyle) {
/*  63 */     return new Label(paramString, paramLabelStyle);
/*     */   }
/*     */   
/*     */   public void setStyle(Button.ButtonStyle paramButtonStyle) {
/*  67 */     if (!(paramButtonStyle instanceof ImageTextButtonStyle)) throw new IllegalArgumentException("style must be a ImageTextButtonStyle."); 
/*  68 */     this.p = (ImageTextButtonStyle)paramButtonStyle;
/*  69 */     super.setStyle(paramButtonStyle);
/*     */     
/*  71 */     if (this.n != null) f();
/*     */     
/*  73 */     if (this.o != null) {
/*  74 */       paramButtonStyle = paramButtonStyle;
/*     */       Label.LabelStyle labelStyle;
/*  76 */       (labelStyle = this.o.getStyle()).font = ((ImageTextButtonStyle)paramButtonStyle).font;
/*  77 */       labelStyle.fontColor = g();
/*  78 */       this.o.setStyle(labelStyle);
/*     */     } 
/*     */   }
/*     */   
/*     */   public ImageTextButtonStyle getStyle() {
/*  83 */     return this.p;
/*     */   }
/*     */   
/*     */   @Null
/*     */   private Drawable e() {
/*  88 */     if (isDisabled() && this.p.imageDisabled != null) return this.p.imageDisabled; 
/*  89 */     if (isPressed()) {
/*  90 */       if (isChecked() && this.p.imageCheckedDown != null) return this.p.imageCheckedDown; 
/*  91 */       if (this.p.imageDown != null) return this.p.imageDown; 
/*     */     } 
/*  93 */     if (isOver()) {
/*  94 */       if (isChecked())
/*  95 */       { if (this.p.imageCheckedOver != null) return this.p.imageCheckedOver;
/*     */          }
/*  97 */       else if (this.p.imageOver != null) { return this.p.imageOver; }
/*     */     
/*     */     }
/* 100 */     if (isChecked()) {
/* 101 */       if (this.p.imageChecked != null) return this.p.imageChecked; 
/* 102 */       if (isOver() && this.p.imageOver != null) return this.p.imageOver; 
/*     */     } 
/* 104 */     return this.p.imageUp;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void f() {
/* 110 */     this.n.setDrawable(e());
/*     */   }
/*     */   
/*     */   @Null
/*     */   private Color g() {
/* 115 */     if (isDisabled() && this.p.disabledFontColor != null) return this.p.disabledFontColor; 
/* 116 */     if (isPressed()) {
/* 117 */       if (isChecked() && this.p.checkedDownFontColor != null) return this.p.checkedDownFontColor; 
/* 118 */       if (this.p.downFontColor != null) return this.p.downFontColor; 
/*     */     } 
/* 120 */     if (isOver()) {
/* 121 */       if (isChecked())
/* 122 */       { if (this.p.checkedOverFontColor != null) return this.p.checkedOverFontColor;
/*     */          }
/* 124 */       else if (this.p.overFontColor != null) { return this.p.overFontColor; }
/*     */     
/*     */     }
/* 127 */     boolean bool = hasKeyboardFocus();
/* 128 */     if (isChecked()) {
/* 129 */       if (bool && this.p.checkedFocusedFontColor != null) return this.p.checkedFocusedFontColor; 
/* 130 */       if (this.p.checkedFontColor != null) return this.p.checkedFontColor; 
/* 131 */       if (isOver() && this.p.overFontColor != null) return this.p.overFontColor; 
/*     */     } 
/* 133 */     if (bool && this.p.focusedFontColor != null) return this.p.focusedFontColor; 
/* 134 */     return this.p.fontColor;
/*     */   }
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/* 138 */     f();
/* 139 */     (this.o.getStyle()).fontColor = g();
/* 140 */     super.draw(paramBatch, paramFloat);
/*     */   }
/*     */   
/*     */   public Image getImage() {
/* 144 */     return this.n;
/*     */   }
/*     */   
/*     */   public Cell getImageCell() {
/* 148 */     return getCell(this.n);
/*     */   }
/*     */   
/*     */   public void setLabel(Label paramLabel) {
/* 152 */     getLabelCell().setActor(paramLabel);
/* 153 */     this.o = paramLabel;
/*     */   }
/*     */   
/*     */   public Label getLabel() {
/* 157 */     return this.o;
/*     */   }
/*     */   
/*     */   public Cell getLabelCell() {
/* 161 */     return getCell(this.o);
/*     */   }
/*     */   
/*     */   public void setText(CharSequence paramCharSequence) {
/* 165 */     this.o.setText(paramCharSequence);
/*     */   }
/*     */   
/*     */   public CharSequence getText() {
/* 169 */     return (CharSequence)this.o.getText();
/*     */   }
/*     */   
/*     */   public String toString() {
/*     */     String str;
/* 174 */     if ((str = getName()) != null) return str;
/*     */     
/*     */     int i;
/* 177 */     if ((i = (str = getClass().getName()).lastIndexOf('.')) != -1) str = str.substring(i + 1); 
/* 178 */     return ((str.indexOf('$') != -1) ? "ImageTextButton " : "") + str + ": " + this.n.getDrawable() + " " + this.o
/* 179 */       .getText();
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
/* 192 */     public ImageTextButtonStyle(@Null Drawable param1Drawable1, @Null Drawable param1Drawable2, @Null Drawable param1Drawable3, BitmapFont param1BitmapFont) { super(param1Drawable1, param1Drawable2, param1Drawable3, param1BitmapFont); } @Null
/*     */     public Drawable imageChecked; @Null
/*     */     public Drawable imageCheckedDown; @Null
/*     */     public Drawable imageCheckedOver; public ImageTextButtonStyle() {} public ImageTextButtonStyle(ImageTextButtonStyle param1ImageTextButtonStyle) {
/* 196 */       super(param1ImageTextButtonStyle);
/* 197 */       this.imageUp = param1ImageTextButtonStyle.imageUp;
/* 198 */       this.imageDown = param1ImageTextButtonStyle.imageDown;
/* 199 */       this.imageOver = param1ImageTextButtonStyle.imageOver;
/* 200 */       this.imageDisabled = param1ImageTextButtonStyle.imageDisabled;
/*     */       
/* 202 */       this.imageChecked = param1ImageTextButtonStyle.imageChecked;
/* 203 */       this.imageCheckedDown = param1ImageTextButtonStyle.imageCheckedDown;
/* 204 */       this.imageCheckedOver = param1ImageTextButtonStyle.imageCheckedOver;
/*     */     }
/*     */     
/*     */     public ImageTextButtonStyle(TextButton.TextButtonStyle param1TextButtonStyle) {
/* 208 */       super(param1TextButtonStyle);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\ui\ImageTextButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */