/*     */ package com.prineside.tdi2.ui.components;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.actors.HotKeyHintLabel;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.shared.Dialog;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ 
/*     */ public class SellButton extends Group {
/*  21 */   private Color k = MaterialColor.RED.P800.cpy();
/*  22 */   private Color l = MaterialColor.RED.P900.cpy();
/*  23 */   private Color m = MaterialColor.RED.P700.cpy();
/*     */   
/*     */   private final Image n;
/*     */   
/*     */   private final Label o;
/*     */   private int p;
/*     */   private boolean q;
/*     */   private boolean r;
/*     */   
/*     */   public SellButton(Runnable paramRunnable) {
/*  33 */     setSize(192.0F, 80.0F);
/*  34 */     setTouchable(Touchable.enabled);
/*  35 */     setTransform(false);
/*     */ 
/*     */ 
/*     */     
/*  39 */     this.n = new Image((Drawable)Game.i.assetManager.getDrawable("ui-sell-button"));
/*  40 */     this.n.setSize(192.0F, 80.0F);
/*  41 */     addActor((Actor)this.n);
/*     */     
/*     */     Image image;
/*  44 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-dollar"))).setSize(40.0F, 40.0F);
/*  45 */     image.setPosition(35.0F, 20.0F);
/*  46 */     addActor((Actor)image);
/*     */     
/*  48 */     this.o = new Label("0", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(30), Color.WHITE));
/*  49 */     this.o.setSize(80.0F, 80.0F);
/*  50 */     this.o.setPosition(92.0F, 0.0F);
/*  51 */     this.o.setAlignment(16);
/*  52 */     addActor((Actor)this.o);
/*     */     
/*  54 */     if (HotKeyHintLabel.isEnabled()) {
/*  55 */       HotKeyHintLabel hotKeyHintLabel = new HotKeyHintLabel(Game.i.settingsManager.getHotKey(SettingsManager.HotkeyAction.SELL_BUILDING), 96.0F, -27.0F);
/*  56 */       addActor((Actor)hotKeyHintLabel);
/*     */     } 
/*     */     
/*  59 */     addListener((EventListener)new ClickListener(this, paramRunnable)
/*     */         {
/*     */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  62 */             SellButton.a(this.b, true);
/*  63 */             SellButton.a(this.b);
/*     */             
/*  65 */             return super.touchDown(param1InputEvent, param1Float1, param1Float2, param1Int1, param1Int2);
/*     */           }
/*     */ 
/*     */           
/*     */           public void touchUp(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  70 */             super.touchUp(param1InputEvent, param1Float1, param1Float2, param1Int1, param1Int2);
/*     */             
/*  72 */             SellButton.a(this.b, false);
/*  73 */             SellButton.a(this.b);
/*     */           }
/*     */ 
/*     */           
/*     */           public void enter(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/*  78 */             super.enter(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/*     */             
/*  80 */             if (param1Int == -1) {
/*  81 */               SellButton.b(this.b, true);
/*  82 */               SellButton.a(this.b);
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/*  88 */             super.exit(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/*     */             
/*  90 */             if (param1Int == -1) {
/*  91 */               SellButton.b(this.b, false);
/*  92 */               SellButton.a(this.b);
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  98 */             if (this.a != null) {
/*  99 */               Dialog.i().showConfirmWithId(Game.i.localeManager.i18n.format("sell_for_coins_price_confirm", new Object[] { StringFormatter.commaSeparatedNumber(SellButton.b(this.b)) }), this.a, "sellButton");
/*     */             }
/*     */           }
/*     */         });
/*     */     
/* 104 */     d();
/*     */   }
/*     */   
/*     */   public void setColors(Color paramColor1, Color paramColor2, Color paramColor3) {
/* 108 */     this.k.set(paramColor1);
/* 109 */     this.l.set(paramColor2);
/* 110 */     this.m.set(paramColor3);
/*     */     
/* 112 */     d();
/*     */   }
/*     */   
/*     */   private void d() {
/* 116 */     if (this.r) {
/* 117 */       this.n.setColor(this.l); return;
/*     */     } 
/* 119 */     if (this.q) {
/* 120 */       this.n.setColor(this.m); return;
/*     */     } 
/* 122 */     this.n.setColor(this.k);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPrice(int paramInt) {
/* 128 */     this.p = paramInt;
/* 129 */     this.o.setText((CharSequence)StringFormatter.commaSeparatedNumber(paramInt));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\SellButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */