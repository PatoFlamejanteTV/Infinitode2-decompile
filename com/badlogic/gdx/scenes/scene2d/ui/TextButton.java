/*     */ package com.badlogic.gdx.scenes.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
/*     */ import com.badlogic.gdx.utils.Null;
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
/*     */ public class TextButton
/*     */   extends Button
/*     */ {
/*     */   private Label label;
/*     */   private TextButtonStyle style;
/*     */   
/*     */   public TextButton(@Null String paramString, Skin paramSkin) {
/*  34 */     this(paramString, paramSkin.<TextButtonStyle>get(TextButtonStyle.class));
/*  35 */     setSkin(paramSkin);
/*     */   }
/*     */   
/*     */   public TextButton(@Null String paramString1, Skin paramSkin, String paramString2) {
/*  39 */     this(paramString1, paramSkin.<TextButtonStyle>get(paramString2, TextButtonStyle.class));
/*  40 */     setSkin(paramSkin);
/*     */   }
/*     */ 
/*     */   
/*     */   public TextButton(@Null String paramString, TextButtonStyle paramTextButtonStyle) {
/*  45 */     setStyle(paramTextButtonStyle);
/*  46 */     this.label = newLabel(paramString, new Label.LabelStyle(paramTextButtonStyle.font, paramTextButtonStyle.fontColor));
/*  47 */     this.label.setAlignment(1);
/*  48 */     add(this.label).expand().fill();
/*  49 */     setSize(getPrefWidth(), getPrefHeight());
/*     */   }
/*     */   
/*     */   protected Label newLabel(String paramString, Label.LabelStyle paramLabelStyle) {
/*  53 */     return new Label(paramString, paramLabelStyle);
/*     */   }
/*     */   
/*     */   public void setStyle(Button.ButtonStyle paramButtonStyle) {
/*  57 */     if (paramButtonStyle == null) throw new NullPointerException("style cannot be null"); 
/*  58 */     if (!(paramButtonStyle instanceof TextButtonStyle)) throw new IllegalArgumentException("style must be a TextButtonStyle."); 
/*  59 */     this.style = (TextButtonStyle)paramButtonStyle;
/*  60 */     super.setStyle(paramButtonStyle);
/*     */     
/*  62 */     if (this.label != null) {
/*  63 */       paramButtonStyle = paramButtonStyle;
/*     */       Label.LabelStyle labelStyle;
/*  65 */       (labelStyle = this.label.getStyle()).font = ((TextButtonStyle)paramButtonStyle).font;
/*  66 */       labelStyle.fontColor = ((TextButtonStyle)paramButtonStyle).fontColor;
/*  67 */       this.label.setStyle(labelStyle);
/*     */     } 
/*     */   }
/*     */   
/*     */   public TextButtonStyle getStyle() {
/*  72 */     return this.style;
/*     */   }
/*     */   
/*     */   @Null
/*     */   protected Color getFontColor() {
/*  77 */     if (isDisabled() && this.style.disabledFontColor != null) return this.style.disabledFontColor; 
/*  78 */     if (isPressed()) {
/*  79 */       if (isChecked() && this.style.checkedDownFontColor != null) return this.style.checkedDownFontColor; 
/*  80 */       if (this.style.downFontColor != null) return this.style.downFontColor; 
/*     */     } 
/*  82 */     if (isOver()) {
/*  83 */       if (isChecked())
/*  84 */       { if (this.style.checkedOverFontColor != null) return this.style.checkedOverFontColor;
/*     */          }
/*  86 */       else if (this.style.overFontColor != null) { return this.style.overFontColor; }
/*     */     
/*     */     }
/*  89 */     boolean bool = hasKeyboardFocus();
/*  90 */     if (isChecked()) {
/*  91 */       if (bool && this.style.checkedFocusedFontColor != null) return this.style.checkedFocusedFontColor; 
/*  92 */       if (this.style.checkedFontColor != null) return this.style.checkedFontColor; 
/*  93 */       if (isOver() && this.style.overFontColor != null) return this.style.overFontColor; 
/*     */     } 
/*  95 */     if (bool && this.style.focusedFontColor != null) return this.style.focusedFontColor; 
/*  96 */     return this.style.fontColor;
/*     */   }
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/* 100 */     (this.label.getStyle()).fontColor = getFontColor();
/* 101 */     super.draw(paramBatch, paramFloat);
/*     */   }
/*     */   
/*     */   public void setLabel(Label paramLabel) {
/* 105 */     if (paramLabel == null) throw new IllegalArgumentException("label cannot be null."); 
/* 106 */     getLabelCell().setActor(paramLabel);
/* 107 */     this.label = paramLabel;
/*     */   }
/*     */   
/*     */   public Label getLabel() {
/* 111 */     return this.label;
/*     */   }
/*     */   
/*     */   public Cell<Label> getLabelCell() {
/* 115 */     return getCell(this.label);
/*     */   }
/*     */   
/*     */   public void setText(@Null String paramString) {
/* 119 */     this.label.setText(paramString);
/*     */   }
/*     */   
/*     */   public CharSequence getText() {
/* 123 */     return (CharSequence)this.label.getText();
/*     */   }
/*     */   
/*     */   public String toString() {
/*     */     String str;
/* 128 */     if ((str = getName()) != null) return str;
/*     */     
/*     */     int i;
/* 131 */     if ((i = (str = getClass().getName()).lastIndexOf('.')) != -1) str = str.substring(i + 1); 
/* 132 */     return ((str.indexOf('$') != -1) ? "TextButton " : "") + str + ": " + this.label.getText();
/*     */   }
/*     */   
/*     */   public static class TextButtonStyle extends Button.ButtonStyle {
/*     */     public BitmapFont font;
/*     */     @Null
/*     */     public Color fontColor;
/*     */     @Null
/*     */     public Color downFontColor;
/*     */     @Null
/*     */     public Color overFontColor;
/*     */     @Null
/*     */     public Color focusedFontColor;
/*     */     
/* 146 */     public TextButtonStyle(@Null Drawable param1Drawable1, @Null Drawable param1Drawable2, @Null Drawable param1Drawable3, @Null BitmapFont param1BitmapFont) { super(param1Drawable1, param1Drawable2, param1Drawable3);
/* 147 */       this.font = param1BitmapFont; } @Null public Color disabledFontColor; @Null
/*     */     public Color checkedFontColor; @Null
/*     */     public Color checkedDownFontColor; @Null
/*     */     public Color checkedOverFontColor; @Null
/* 151 */     public Color checkedFocusedFontColor; public TextButtonStyle() {} public TextButtonStyle(TextButtonStyle param1TextButtonStyle) { super(param1TextButtonStyle);
/* 152 */       this.font = param1TextButtonStyle.font;
/*     */       
/* 154 */       if (param1TextButtonStyle.fontColor != null) this.fontColor = new Color(param1TextButtonStyle.fontColor); 
/* 155 */       if (param1TextButtonStyle.downFontColor != null) this.downFontColor = new Color(param1TextButtonStyle.downFontColor); 
/* 156 */       if (param1TextButtonStyle.overFontColor != null) this.overFontColor = new Color(param1TextButtonStyle.overFontColor); 
/* 157 */       if (param1TextButtonStyle.focusedFontColor != null) this.focusedFontColor = new Color(param1TextButtonStyle.focusedFontColor); 
/* 158 */       if (param1TextButtonStyle.disabledFontColor != null) this.disabledFontColor = new Color(param1TextButtonStyle.disabledFontColor);
/*     */       
/* 160 */       if (param1TextButtonStyle.checkedFontColor != null) this.checkedFontColor = new Color(param1TextButtonStyle.checkedFontColor); 
/* 161 */       if (param1TextButtonStyle.checkedDownFontColor != null) this.checkedDownFontColor = new Color(param1TextButtonStyle.checkedDownFontColor); 
/* 162 */       if (param1TextButtonStyle.checkedOverFontColor != null) this.checkedOverFontColor = new Color(param1TextButtonStyle.checkedOverFontColor); 
/* 163 */       if (param1TextButtonStyle.checkedFocusedFontColor != null) this.checkedFocusedFontColor = new Color(param1TextButtonStyle.checkedFocusedFontColor);  }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\ui\TextButton.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */