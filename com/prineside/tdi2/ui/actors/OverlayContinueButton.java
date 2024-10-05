/*     */ package com.prineside.tdi2.ui.actors;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ 
/*     */ public class OverlayContinueButton
/*     */   extends Group {
/*     */   private Image k;
/*     */   private boolean l;
/*     */   private boolean m;
/*     */   public Label label;
/*     */   private Color n;
/*     */   private Color o;
/*     */   private Color p;
/*     */   
/*     */   public OverlayContinueButton(String paramString1, String paramString2, Color paramColor1, Color paramColor2, Color paramColor3, Runnable paramRunnable) {
/*  27 */     this.n = paramColor1;
/*  28 */     this.o = paramColor2;
/*  29 */     this.p = paramColor3;
/*     */     
/*  31 */     setTransform(false);
/*     */     
/*  33 */     setSize(408.0F, 127.0F);
/*     */ 
/*     */ 
/*     */     
/*  37 */     this.k = new Image((Drawable)Game.i.assetManager.getDrawable("ui-level-selection-overlay-button"));
/*  38 */     this.k.setSize(408.0F, 127.0F);
/*  39 */     addActor((Actor)this.k);
/*     */ 
/*     */     
/*  42 */     this.label = new Label(paramString1, new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(30), Color.WHITE));
/*  43 */     this.label.setSize(305.0F, 20.0F);
/*  44 */     this.label.setPosition(0.0F, 45.0F);
/*  45 */     this.label.setAlignment(20);
/*  46 */     addActor((Actor)this.label);
/*     */     
/*     */     Image image;
/*     */     
/*  50 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable(paramString2))).setSize(64.0F, 64.0F);
/*  51 */     image.setPosition(313.0F, 30.0F);
/*  52 */     addActor((Actor)image);
/*     */     
/*  54 */     setTouchable(Touchable.enabled);
/*  55 */     addListener((EventListener)new ClickListener(this, paramRunnable)
/*     */         {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  58 */             this.a.run();
/*  59 */             Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  64 */             OverlayContinueButton.a(this.b, true);
/*  65 */             OverlayContinueButton.a(this.b);
/*     */             
/*  67 */             return super.touchDown(param1InputEvent, param1Float1, param1Float2, param1Int1, param1Int2);
/*     */           }
/*     */ 
/*     */           
/*     */           public void touchUp(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  72 */             OverlayContinueButton.a(this.b, false);
/*  73 */             OverlayContinueButton.a(this.b);
/*     */             
/*  75 */             super.touchUp(param1InputEvent, param1Float1, param1Float2, param1Int1, param1Int2);
/*     */           }
/*     */ 
/*     */           
/*     */           public void enter(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/*  80 */             if (param1Int == -1) {
/*  81 */               OverlayContinueButton.b(this.b, true);
/*  82 */               OverlayContinueButton.a(this.b);
/*     */             } 
/*     */             
/*  85 */             super.enter(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/*     */           }
/*     */ 
/*     */           
/*     */           public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/*  90 */             if (param1Int == -1) {
/*  91 */               OverlayContinueButton.b(this.b, false);
/*  92 */               OverlayContinueButton.a(this.b);
/*     */             } 
/*     */             
/*  95 */             super.exit(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/*     */           }
/*     */         });
/*     */     
/*  99 */     d();
/*     */   }
/*     */   
/*     */   private void d() {
/* 103 */     if (this.l) {
/* 104 */       this.k.setColor(this.o); return;
/* 105 */     }  if (this.m) {
/* 106 */       this.k.setColor(this.p); return;
/*     */     } 
/* 108 */     this.k.setColor(this.n);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\actors\OverlayContinueButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */