/*     */ package com.prineside.tdi2.ui.shared;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ 
/*     */ public class ForwardButton extends UiManager.UiComponent.Adapter {
/*     */   public static ForwardButton i() {
/*  21 */     return (ForwardButton)Game.i.uiManager.getComponent(ForwardButton.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  27 */   public static final Color DEFAULT_NORMAL_COLOR = MaterialColor.LIGHT_BLUE.P700;
/*  28 */   public static final Color DEFAULT_HOVER_COLOR = MaterialColor.LIGHT_BLUE.P600;
/*  29 */   public static final Color DEFAULT_ACTIVE_COLOR = MaterialColor.LIGHT_BLUE.P800;
/*  30 */   public static final Color DEFAULT_DISABLED_COLOR = Color.GRAY;
/*     */   
/*     */   private Color a;
/*     */   
/*     */   private Color b;
/*     */   
/*     */   private Color c;
/*     */   
/*     */   private Color d;
/*     */   private final UiManager.UiLayer e;
/*     */   private final Image f;
/*     */   private final Label g;
/*     */   private final Image h;
/*     */   private boolean i = true;
/*     */   private boolean j = false;
/*     */   private boolean k = false;
/*     */   private Runnable l;
/*     */   
/*     */   public ForwardButton() {
/*  49 */     Label.LabelStyle labelStyle = new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(30), Color.WHITE);
/*  50 */     this.e = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SHARED_COMPONENTS, 100, "Forward button");
/*     */     
/*     */     Group group;
/*  53 */     (group = new Group()).setTouchable(Touchable.enabled);
/*  54 */     this.e.getTable().add((Actor)group).expand().bottom().right().size(442.0F, 128.0F);
/*     */     
/*  56 */     this.a = DEFAULT_NORMAL_COLOR;
/*  57 */     this.b = DEFAULT_HOVER_COLOR;
/*  58 */     this.c = DEFAULT_ACTIVE_COLOR;
/*  59 */     this.d = DEFAULT_DISABLED_COLOR;
/*     */     
/*  61 */     this.f = new Image((Drawable)Game.i.assetManager.getDrawable("ui-forward-button"));
/*  62 */     this.f.setSize(442.0F, 128.0F);
/*  63 */     this.f.setColor(DEFAULT_NORMAL_COLOR);
/*  64 */     group.addActor((Actor)this.f);
/*     */     
/*  66 */     this.h = new Image();
/*  67 */     this.h.setSize(64.0F, 64.0F);
/*  68 */     this.h.setPosition(346.0F, 28.0F);
/*  69 */     group.addActor((Actor)this.h);
/*     */     
/*  71 */     this.g = new Label("", labelStyle);
/*  72 */     this.g.setSize(330.0F, 124.0F);
/*  73 */     this.g.setAlignment(16);
/*  74 */     group.addActor((Actor)this.g);
/*     */     
/*  76 */     group.addListener((EventListener)new ClickListener(this)
/*     */         {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  79 */             if (ForwardButton.a(this.a) && ForwardButton.b(this.a) != null) {
/*  80 */               ForwardButton.b(this.a).run();
/*  81 */               Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  87 */             ForwardButton.a(this.a, true);
/*  88 */             ForwardButton.c(this.a);
/*     */             
/*  90 */             return super.touchDown(param1InputEvent, param1Float1, param1Float2, param1Int1, param1Int2);
/*     */           }
/*     */ 
/*     */           
/*     */           public void touchUp(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  95 */             ForwardButton.a(this.a, false);
/*  96 */             ForwardButton.c(this.a);
/*     */             
/*  98 */             super.touchUp(param1InputEvent, param1Float1, param1Float2, param1Int1, param1Int2);
/*     */           }
/*     */ 
/*     */           
/*     */           public void enter(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/* 103 */             if (param1Int == -1) {
/* 104 */               ForwardButton.b(this.a, true);
/* 105 */               ForwardButton.c(this.a);
/*     */             } 
/*     */             
/* 108 */             super.enter(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/*     */           }
/*     */ 
/*     */           
/*     */           public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/* 113 */             if (param1Int == -1) {
/* 114 */               ForwardButton.b(this.a, false);
/* 115 */               ForwardButton.c(this.a);
/*     */             } 
/*     */             
/* 118 */             super.exit(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/*     */           }
/*     */         });
/*     */     
/* 122 */     reset();
/*     */   }
/*     */   
/*     */   public ForwardButton reset() {
/* 126 */     setIcon((Drawable)Game.i.assetManager.getDrawable("icon-triangle-right"));
/* 127 */     setText(Game.i.localeManager.i18n.get("continue"));
/* 128 */     setVisible(false);
/* 129 */     setEnabled(true);
/* 130 */     setBackgroundColors(DEFAULT_NORMAL_COLOR, DEFAULT_HOVER_COLOR, DEFAULT_ACTIVE_COLOR, DEFAULT_DISABLED_COLOR);
/*     */     
/* 132 */     return this;
/*     */   }
/*     */   
/*     */   public ForwardButton setBackgroundColors(Color paramColor1, Color paramColor2, Color paramColor3, Color paramColor4) {
/* 136 */     this.a = paramColor1;
/* 137 */     this.b = paramColor2;
/* 138 */     this.c = paramColor3;
/* 139 */     this.d = paramColor4;
/*     */     
/* 141 */     a();
/*     */     
/* 143 */     return this;
/*     */   }
/*     */   
/*     */   public ForwardButton setIcon(Drawable paramDrawable) {
/* 147 */     this.h.setDrawable(paramDrawable);
/*     */     
/* 149 */     return this;
/*     */   }
/*     */   
/*     */   public ForwardButton setEnabled(boolean paramBoolean) {
/* 153 */     this.i = paramBoolean;
/* 154 */     a();
/*     */     
/* 156 */     return this;
/*     */   }
/*     */   
/*     */   private void a() {
/* 160 */     if (this.i) {
/* 161 */       if (this.j) {
/* 162 */         this.f.setColor(this.c); return;
/*     */       } 
/* 164 */       if (this.k) {
/* 165 */         this.f.setColor(this.b); return;
/*     */       } 
/* 167 */       this.f.setColor(this.a);
/*     */       
/*     */       return;
/*     */     } 
/* 171 */     this.f.setColor(this.d);
/*     */   }
/*     */ 
/*     */   
/*     */   public ForwardButton setText(CharSequence paramCharSequence) {
/* 176 */     this.g.setText(paramCharSequence);
/*     */     
/* 178 */     return this;
/*     */   }
/*     */   
/*     */   public ForwardButton setVisible(boolean paramBoolean) {
/* 182 */     this.e.getTable().setVisible(paramBoolean);
/*     */     
/* 184 */     return this;
/*     */   }
/*     */   
/*     */   public ForwardButton setClickHandler(Runnable paramRunnable) {
/* 188 */     this.l = paramRunnable;
/*     */     
/* 190 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hide() {
/* 195 */     setVisible(false);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\ForwardButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */