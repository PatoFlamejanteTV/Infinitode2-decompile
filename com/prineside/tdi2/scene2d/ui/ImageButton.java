/*     */ package com.prineside.tdi2.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.Scaling;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
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
/*     */   private final Image n;
/*     */   private ImageButtonStyle o;
/*     */   
/*     */   public ImageButton(ImageButtonStyle paramImageButtonStyle) {
/*  34 */     super(paramImageButtonStyle);
/*  35 */     this.n = d();
/*  36 */     add(this.n);
/*  37 */     setStyle(paramImageButtonStyle);
/*  38 */     setSize(getPrefWidth(), getPrefHeight());
/*     */   }
/*     */   
/*     */   public ImageButton(@Null Drawable paramDrawable) {
/*  42 */     this(new ImageButtonStyle(null, null, null, paramDrawable, null, null));
/*     */   }
/*     */   
/*     */   public ImageButton(@Null Drawable paramDrawable1, @Null Drawable paramDrawable2) {
/*  46 */     this(new ImageButtonStyle(null, null, null, paramDrawable1, paramDrawable2, null));
/*     */   }
/*     */   
/*     */   public ImageButton(@Null Drawable paramDrawable1, @Null Drawable paramDrawable2, @Null Drawable paramDrawable3) {
/*  50 */     this(new ImageButtonStyle(null, null, null, paramDrawable1, paramDrawable2, paramDrawable3));
/*     */   }
/*     */   
/*     */   private static Image d() {
/*  54 */     return new Image((Drawable)null, Scaling.fit);
/*     */   }
/*     */   
/*     */   public void setStyle(Button.ButtonStyle paramButtonStyle) {
/*  58 */     if (!(paramButtonStyle instanceof ImageButtonStyle)) throw new IllegalArgumentException("style must be an ImageButtonStyle."); 
/*  59 */     this.o = (ImageButtonStyle)paramButtonStyle;
/*  60 */     super.setStyle(paramButtonStyle);
/*     */     
/*  62 */     if (this.n != null) f(); 
/*     */   }
/*     */   
/*     */   public ImageButtonStyle getStyle() {
/*  66 */     return this.o;
/*     */   }
/*     */   
/*     */   @Null
/*     */   private Drawable e() {
/*  71 */     if (isDisabled() && this.o.imageDisabled != null) return this.o.imageDisabled; 
/*  72 */     if (isPressed()) {
/*  73 */       if (isChecked() && this.o.imageCheckedDown != null) return this.o.imageCheckedDown; 
/*  74 */       if (this.o.imageDown != null) return this.o.imageDown; 
/*     */     } 
/*  76 */     if (isOver()) {
/*  77 */       if (isChecked())
/*  78 */       { if (this.o.imageCheckedOver != null) return this.o.imageCheckedOver;
/*     */          }
/*  80 */       else if (this.o.imageOver != null) { return this.o.imageOver; }
/*     */     
/*     */     }
/*  83 */     if (isChecked()) {
/*  84 */       if (this.o.imageChecked != null) return this.o.imageChecked; 
/*  85 */       if (isOver() && this.o.imageOver != null) return this.o.imageOver; 
/*     */     } 
/*  87 */     return this.o.imageUp;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void f() {
/*  93 */     this.n.setDrawable(e());
/*     */   }
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/*  97 */     f();
/*  98 */     super.draw(paramBatch, paramFloat);
/*     */   }
/*     */   
/*     */   public Image getImage() {
/* 102 */     return this.n;
/*     */   }
/*     */   
/*     */   public Cell getImageCell() {
/* 106 */     return getCell(this.n);
/*     */   }
/*     */   
/*     */   public String toString() {
/*     */     String str;
/* 111 */     if ((str = getName()) != null) return str;
/*     */     
/*     */     int i;
/* 114 */     if ((i = (str = getClass().getName()).lastIndexOf('.')) != -1) str = str.substring(i + 1); 
/* 115 */     return ((str.indexOf('$') != -1) ? "ImageButton " : "") + str + ": " + this.n.getDrawable();
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
/* 129 */       super(param1Drawable1, param1Drawable2, param1Drawable3);
/* 130 */       this.imageUp = param1Drawable4;
/* 131 */       this.imageDown = param1Drawable5;
/* 132 */       this.imageChecked = param1Drawable6; } @Null
/*     */     public Drawable imageChecked; @Null
/*     */     public Drawable imageCheckedDown; @Null
/*     */     public Drawable imageCheckedOver; public ImageButtonStyle() {} public ImageButtonStyle(ImageButtonStyle param1ImageButtonStyle) {
/* 136 */       super(param1ImageButtonStyle);
/* 137 */       this.imageUp = param1ImageButtonStyle.imageUp;
/* 138 */       this.imageDown = param1ImageButtonStyle.imageDown;
/* 139 */       this.imageOver = param1ImageButtonStyle.imageOver;
/* 140 */       this.imageDisabled = param1ImageButtonStyle.imageDisabled;
/*     */       
/* 142 */       this.imageChecked = param1ImageButtonStyle.imageChecked;
/* 143 */       this.imageCheckedDown = param1ImageButtonStyle.imageCheckedDown;
/* 144 */       this.imageCheckedOver = param1ImageButtonStyle.imageCheckedOver;
/*     */     }
/*     */     
/*     */     public ImageButtonStyle(Button.ButtonStyle param1ButtonStyle) {
/* 148 */       super(param1ButtonStyle);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\ui\ImageButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */