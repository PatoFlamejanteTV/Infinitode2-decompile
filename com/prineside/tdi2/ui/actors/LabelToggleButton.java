/*     */ package com.prineside.tdi2.ui.actors;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.ObjectConsumer;
/*     */ 
/*     */ public class LabelToggleButton
/*     */   extends Table {
/*     */   public Image toggleImage;
/*     */   public Label label;
/*     */   private boolean k;
/*  22 */   public Color normalColor = MaterialColor.LIGHT_BLUE.P300.cpy();
/*  23 */   public Color hoverColor = Color.WHITE.cpy();
/*     */   
/*     */   private boolean l;
/*     */   
/*     */   public ObjectConsumer<Boolean> onToggle;
/*     */ 
/*     */   
/*     */   public void updateColor() {
/*  31 */     if (this.l) {
/*  32 */       this.label.setColor(this.hoverColor); return;
/*     */     } 
/*  34 */     this.label.setColor(this.normalColor);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setup(String paramString, boolean paramBoolean1, int paramInt, float paramFloat, boolean paramBoolean2, ObjectConsumer<Boolean> paramObjectConsumer) {
/*  39 */     this.onToggle = paramObjectConsumer;
/*     */     
/*  41 */     setTouchable(Touchable.enabled);
/*     */     
/*  43 */     this.label = new Label(paramString, Game.i.assetManager.getLabelStyle(paramInt));
/*  44 */     this.label.setColor(MaterialColor.LIGHT_BLUE.P300);
/*  45 */     this.label.setAlignment(8);
/*  46 */     this.toggleImage = new Image();
/*     */     
/*  48 */     if (paramBoolean2) {
/*  49 */       add((Actor)this.label).left().padRight(32.0F);
/*  50 */       add((Actor)this.toggleImage).size(paramFloat * 2.0F, paramFloat);
/*  51 */       add().height(1.0F).expandX().fillX();
/*     */     } else {
/*  53 */       add((Actor)this.label).left().padRight(16.0F).expand();
/*  54 */       add((Actor)this.toggleImage).right().size(paramFloat * 2.0F, paramFloat);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  59 */     addListener((EventListener)new ClickListener(this)
/*     */         {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  62 */             this.a.setEnabled(!LabelToggleButton.a(this.a));
/*     */             
/*  64 */             if (this.a.onToggle != null) {
/*  65 */               this.a.onToggle.accept(Boolean.valueOf(LabelToggleButton.a(this.a)));
/*     */             }
/*     */             
/*  68 */             Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*     */           }
/*     */ 
/*     */           
/*     */           public void enter(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/*  73 */             super.enter(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/*     */             
/*  75 */             if (param1Int == -1) {
/*  76 */               LabelToggleButton.a(this.a, true);
/*  77 */               this.a.updateColor();
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/*  83 */             super.exit(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/*     */             
/*  85 */             if (param1Int == -1) {
/*  86 */               LabelToggleButton.a(this.a, false);
/*  87 */               this.a.updateColor();
/*     */             } 
/*     */           }
/*     */         });
/*     */     
/*  92 */     setEnabled(paramBoolean1);
/*     */   }
/*     */   
/*     */   public LabelToggleButton(String paramString, boolean paramBoolean1, int paramInt, float paramFloat, boolean paramBoolean2, ObjectConsumer<Boolean> paramObjectConsumer) {
/*  96 */     setup(paramString, paramBoolean1, paramInt, paramFloat, paramBoolean2, paramObjectConsumer);
/*     */   }
/*     */   
/*     */   public LabelToggleButton(String paramString, boolean paramBoolean, int paramInt, float paramFloat, ObjectConsumer<Boolean> paramObjectConsumer) {
/* 100 */     this(paramString, paramBoolean, paramInt, paramFloat, false, paramObjectConsumer);
/*     */   }
/*     */   
/*     */   public LabelToggleButton(String paramString, boolean paramBoolean, ObjectConsumer<Boolean> paramObjectConsumer) {
/* 104 */     this(paramString, paramBoolean, 30, 48.0F, paramObjectConsumer);
/*     */   }
/*     */   
/*     */   public boolean isEnabled() {
/* 108 */     return this.k;
/*     */   }
/*     */   
/*     */   public void setEnabled(boolean paramBoolean) {
/* 112 */     this.k = paramBoolean;
/*     */     
/* 114 */     if (paramBoolean) {
/* 115 */       this.toggleImage.setDrawable((Drawable)Game.i.assetManager.getDrawable("settings-toggle-on")); return;
/*     */     } 
/* 117 */     this.toggleImage.setDrawable((Drawable)Game.i.assetManager.getDrawable("settings-toggle-off"));
/*     */   }
/*     */ 
/*     */   
/*     */   public void setText(CharSequence paramCharSequence) {
/* 122 */     this.label.setText(paramCharSequence);
/*     */   }
/*     */   
/*     */   public LabelToggleButton() {}
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\actors\LabelToggleButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */