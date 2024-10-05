/*     */ package com.prineside.tdi2.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.utils.Null;
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
/*     */ public class TextButton
/*     */   extends Button
/*     */ {
/*     */   private Label n;
/*     */   private TextButtonStyle o;
/*     */   
/*     */   public TextButton(@Null String paramString, TextButtonStyle paramTextButtonStyle) {
/*  35 */     setStyle(paramTextButtonStyle);
/*  36 */     this.n = a(paramString, new Label.LabelStyle(paramTextButtonStyle.font, paramTextButtonStyle.fontColor));
/*  37 */     this.n.setAlignment(1);
/*  38 */     add(this.n).expand().fill();
/*  39 */     setSize(getPrefWidth(), getPrefHeight());
/*     */   }
/*     */   
/*     */   private static Label a(String paramString, Label.LabelStyle paramLabelStyle) {
/*  43 */     return new Label(paramString, paramLabelStyle);
/*     */   }
/*     */   
/*     */   public void setStyle(Button.ButtonStyle paramButtonStyle) {
/*  47 */     if (paramButtonStyle == null) throw new NullPointerException("style cannot be null"); 
/*  48 */     if (!(paramButtonStyle instanceof TextButtonStyle)) throw new IllegalArgumentException("style must be a TextButtonStyle."); 
/*  49 */     this.o = (TextButtonStyle)paramButtonStyle;
/*  50 */     super.setStyle(paramButtonStyle);
/*     */     
/*  52 */     if (this.n != null) {
/*  53 */       paramButtonStyle = paramButtonStyle;
/*     */       Label.LabelStyle labelStyle;
/*  55 */       (labelStyle = this.n.getStyle()).font = ((TextButtonStyle)paramButtonStyle).font;
/*  56 */       labelStyle.fontColor = ((TextButtonStyle)paramButtonStyle).fontColor;
/*  57 */       this.n.setStyle(labelStyle);
/*     */     } 
/*     */   }
/*     */   
/*     */   public TextButtonStyle getStyle() {
/*  62 */     return this.o;
/*     */   }
/*     */   
/*     */   @Null
/*     */   private Color d() {
/*  67 */     if (isDisabled() && this.o.disabledFontColor != null) return this.o.disabledFontColor; 
/*  68 */     if (isPressed()) {
/*  69 */       if (isChecked() && this.o.checkedDownFontColor != null) return this.o.checkedDownFontColor; 
/*  70 */       if (this.o.downFontColor != null) return this.o.downFontColor; 
/*     */     } 
/*  72 */     if (isOver()) {
/*  73 */       if (isChecked())
/*  74 */       { if (this.o.checkedOverFontColor != null) return this.o.checkedOverFontColor;
/*     */          }
/*  76 */       else if (this.o.overFontColor != null) { return this.o.overFontColor; }
/*     */     
/*     */     }
/*  79 */     boolean bool = hasKeyboardFocus();
/*  80 */     if (isChecked()) {
/*  81 */       if (bool && this.o.checkedFocusedFontColor != null) return this.o.checkedFocusedFontColor; 
/*  82 */       if (this.o.checkedFontColor != null) return this.o.checkedFontColor; 
/*  83 */       if (isOver() && this.o.overFontColor != null) return this.o.overFontColor; 
/*     */     } 
/*  85 */     if (bool && this.o.focusedFontColor != null) return this.o.focusedFontColor; 
/*  86 */     return this.o.fontColor;
/*     */   }
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/*  90 */     (this.n.getStyle()).fontColor = d();
/*  91 */     super.draw(paramBatch, paramFloat);
/*     */   }
/*     */   
/*     */   public void setLabel(Label paramLabel) {
/*  95 */     if (paramLabel == null) throw new IllegalArgumentException("label cannot be null."); 
/*  96 */     getLabelCell().setActor(paramLabel);
/*  97 */     this.n = paramLabel;
/*     */   }
/*     */   
/*     */   public Label getLabel() {
/* 101 */     return this.n;
/*     */   }
/*     */   
/*     */   public Cell<Label> getLabelCell() {
/* 105 */     return getCell(this.n);
/*     */   }
/*     */   
/*     */   public void setText(@Null String paramString) {
/* 109 */     this.n.setText(paramString);
/*     */   }
/*     */   
/*     */   public CharSequence getText() {
/* 113 */     return (CharSequence)this.n.getText();
/*     */   }
/*     */   
/*     */   public String toString() {
/*     */     String str;
/* 118 */     if ((str = getName()) != null) return str;
/*     */     
/*     */     int i;
/* 121 */     if ((i = (str = getClass().getName()).lastIndexOf('.')) != -1) str = str.substring(i + 1); 
/* 122 */     return ((str.indexOf('$') != -1) ? "TextButton " : "") + str + ": " + this.n.getText();
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
/* 136 */     public TextButtonStyle(@Null Drawable param1Drawable1, @Null Drawable param1Drawable2, @Null Drawable param1Drawable3, @Null BitmapFont param1BitmapFont) { super(param1Drawable1, param1Drawable2, param1Drawable3);
/* 137 */       this.font = param1BitmapFont; } @Null public Color disabledFontColor; @Null
/*     */     public Color checkedFontColor; @Null
/*     */     public Color checkedDownFontColor; @Null
/*     */     public Color checkedOverFontColor; @Null
/* 141 */     public Color checkedFocusedFontColor; public TextButtonStyle() {} public TextButtonStyle(TextButtonStyle param1TextButtonStyle) { super(param1TextButtonStyle);
/* 142 */       this.font = param1TextButtonStyle.font;
/*     */       
/* 144 */       if (param1TextButtonStyle.fontColor != null) this.fontColor = new Color(param1TextButtonStyle.fontColor); 
/* 145 */       if (param1TextButtonStyle.downFontColor != null) this.downFontColor = new Color(param1TextButtonStyle.downFontColor); 
/* 146 */       if (param1TextButtonStyle.overFontColor != null) this.overFontColor = new Color(param1TextButtonStyle.overFontColor); 
/* 147 */       if (param1TextButtonStyle.focusedFontColor != null) this.focusedFontColor = new Color(param1TextButtonStyle.focusedFontColor); 
/* 148 */       if (param1TextButtonStyle.disabledFontColor != null) this.disabledFontColor = new Color(param1TextButtonStyle.disabledFontColor);
/*     */       
/* 150 */       if (param1TextButtonStyle.checkedFontColor != null) this.checkedFontColor = new Color(param1TextButtonStyle.checkedFontColor); 
/* 151 */       if (param1TextButtonStyle.checkedDownFontColor != null) this.checkedDownFontColor = new Color(param1TextButtonStyle.checkedDownFontColor); 
/* 152 */       if (param1TextButtonStyle.checkedOverFontColor != null) this.checkedOverFontColor = new Color(param1TextButtonStyle.checkedOverFontColor); 
/* 153 */       if (param1TextButtonStyle.checkedFocusedFontColor != null) this.checkedFocusedFontColor = new Color(param1TextButtonStyle.checkedFocusedFontColor);  }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\ui\TextButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */