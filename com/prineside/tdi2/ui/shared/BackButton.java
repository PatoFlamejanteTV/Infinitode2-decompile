/*     */ package com.prineside.tdi2.ui.shared;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.utils.IgnoreMethodOverloadLuaDefWarning;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ 
/*     */ public final class BackButton extends UiManager.UiComponent.Adapter {
/*     */   public static BackButton i() {
/*  20 */     return (BackButton)Game.i.uiManager.getComponent(BackButton.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  26 */   private static final Color a = MaterialColor.LIGHT_BLUE.P800;
/*  27 */   private static final Color b = MaterialColor.LIGHT_BLUE.P700;
/*  28 */   private static final Color c = MaterialColor.LIGHT_BLUE.P900;
/*     */   
/*  30 */   private final UiManager.UiLayer d = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SHARED_COMPONENTS, 100, "BackButton");
/*     */   
/*     */   private final Image e;
/*     */   private final Label f;
/*     */   private Group g;
/*     */   private Runnable h;
/*     */   
/*     */   public BackButton() {
/*  38 */     Label.LabelStyle labelStyle = new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(30), Color.WHITE);
/*     */     
/*  40 */     this.g = new Group();
/*  41 */     this.g.setTouchable(Touchable.enabled);
/*  42 */     this.g.setName("shared_back_button");
/*  43 */     this.d.getTable().add((Actor)this.g).expand().bottom().left().size(442.0F, 128.0F);
/*     */     
/*  45 */     this.e = new Image((Drawable)Game.i.assetManager.getDrawable("ui-back-button"));
/*  46 */     this.e.setSize(462.0F, 128.0F);
/*  47 */     this.e.setColor(a);
/*  48 */     this.e.setPosition(-20.0F, 0.0F);
/*  49 */     this.g.addActor((Actor)this.e);
/*     */     
/*     */     Image image;
/*  52 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-triangle-left"))).setSize(64.0F, 64.0F);
/*  53 */     image.setPosition(32.0F, 28.0F);
/*  54 */     this.g.addActor((Actor)image);
/*     */     
/*  56 */     this.f = new Label(Game.i.localeManager.i18n.get("back"), labelStyle);
/*  57 */     this.f.setSize(314.0F, 124.0F);
/*  58 */     this.f.setPosition(112.0F, 0.0F);
/*  59 */     this.g.addActor((Actor)this.f);
/*     */     
/*  61 */     this.g.addListener((EventListener)new ClickListener(this) {
/*     */           private boolean a = false;
/*     */           private boolean b = false;
/*     */           
/*     */           private void a() {
/*  66 */             if (this.a) {
/*  67 */               BackButton.a(this.c).setColor(BackButton.a()); return;
/*     */             } 
/*  69 */             if (this.b) {
/*  70 */               BackButton.a(this.c).setColor(BackButton.b()); return;
/*     */             } 
/*  72 */             BackButton.a(this.c).setColor(BackButton.c());
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  79 */             if (BackButton.b(this.c) != null) {
/*  80 */               BackButton.b(this.c).run();
/*  81 */               Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  87 */             this.a = true;
/*  88 */             a();
/*     */             
/*  90 */             return super.touchDown(param1InputEvent, param1Float1, param1Float2, param1Int1, param1Int2);
/*     */           }
/*     */ 
/*     */           
/*     */           public void touchUp(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  95 */             this.a = false;
/*  96 */             a();
/*     */             
/*  98 */             super.touchUp(param1InputEvent, param1Float1, param1Float2, param1Int1, param1Int2);
/*     */           }
/*     */ 
/*     */           
/*     */           public void enter(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/* 103 */             if (param1Int == -1) {
/* 104 */               this.b = true;
/* 105 */               a();
/*     */             } 
/*     */             
/* 108 */             super.enter(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/*     */           }
/*     */ 
/*     */           
/*     */           public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/* 113 */             if (param1Int == -1) {
/* 114 */               this.b = false;
/* 115 */               a();
/*     */             } 
/*     */             
/* 118 */             super.exit(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/*     */           }
/*     */         });
/*     */     
/* 122 */     setVisible(false, true);
/*     */   }
/*     */   
/*     */   public final BackButton setText(CharSequence paramCharSequence) {
/* 126 */     if (paramCharSequence == null) {
/* 127 */       this.f.setText(Game.i.localeManager.i18n.get("back"));
/*     */     } else {
/* 129 */       this.f.setText(paramCharSequence);
/*     */     } 
/*     */     
/* 132 */     return this;
/*     */   }
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public final BackButton setVisible(boolean paramBoolean) {
/* 137 */     setVisible(paramBoolean, false);
/* 138 */     return this;
/*     */   }
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public final BackButton setVisible(boolean paramBoolean1, boolean paramBoolean2) {
/* 143 */     this.d.getTable().setVisible(paramBoolean1);
/*     */     
/* 145 */     if (!paramBoolean1) this.h = null;
/*     */     
/* 147 */     return this;
/*     */   }
/*     */   
/*     */   public final BackButton setClickHandler(Runnable paramRunnable) {
/* 151 */     this.h = paramRunnable;
/*     */     
/* 153 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void hide() {
/* 158 */     setVisible(false, true);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\BackButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */