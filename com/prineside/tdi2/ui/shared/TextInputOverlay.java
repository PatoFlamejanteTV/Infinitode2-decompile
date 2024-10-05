/*     */ package com.prineside.tdi2.ui.shared;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.Input;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.actors.ComplexButton;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.QuadActor;
/*     */ import com.prineside.tdi2.ui.actors.TextFieldXPlatform;
/*     */ import com.prineside.tdi2.utils.InputVoid;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.QuadDrawable;
/*     */ 
/*     */ public class TextInputOverlay extends UiManager.UiComponent.Adapter {
/*     */   public static TextInputOverlay i() {
/*  23 */     return (TextInputOverlay)Game.i.uiManager.getComponent(TextInputOverlay.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  28 */   private final UiManager.UiLayer a = Game.i.uiManager.addLayer(UiManager.MainUiLayer.OVERLAY, 20001, "TextInputOverlay main");
/*     */   
/*     */   private final Label b;
/*     */   
/*     */   private final TextFieldXPlatform c;
/*     */   
/*     */   private Input.TextInputListener d;
/*     */   
/*     */   public TextInputOverlay() {
/*  37 */     Table table = this.a.getTable();
/*     */     
/*     */     Group group;
/*  40 */     (group = new Group()).setTransform(false);
/*  41 */     group.setTouchable(Touchable.enabled);
/*  42 */     group.addListener((EventListener)new InputVoid());
/*  43 */     table.add((Actor)group).size(800.0F, 200.0F);
/*     */ 
/*     */ 
/*     */     
/*     */     QuadActor quadActor;
/*     */ 
/*     */ 
/*     */     
/*  51 */     (quadActor = new QuadActor(new Color(33), new float[] { 10.0F, 0.0F, 0.0F, 200.0F, 800.0F, 190.0F, 790.0F, 12.0F })).setSize(800.0F, 200.0F);
/*  52 */     quadActor.setPosition(12.0F, -12.0F);
/*  53 */     group.addActor((Actor)quadActor);
/*     */     
/*  55 */     quadActor = new QuadActor(new Color(724249599), new float[] { 10.0F, 0.0F, 0.0F, 200.0F, 800.0F, 190.0F, 790.0F, 12.0F });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  61 */     group.setSize(800.0F, 200.0F);
/*  62 */     group.addActor((Actor)quadActor);
/*     */     
/*  64 */     this.b = new Label("", Game.i.assetManager.getLabelStyle(30));
/*  65 */     this.b.setPosition(40.0F, 150.0F);
/*  66 */     group.addActor((Actor)this.b);
/*     */     
/*  68 */     this.c = new TextFieldXPlatform("", Game.i.assetManager.getTextFieldStyle(30));
/*  69 */     this.c.setSize(720.0F, 64.0F);
/*  70 */     this.c.setPosition(40.0F, 50.0F);
/*  71 */     group.addActor((Actor)this.c);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     ComplexButton complexButton;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  83 */     (complexButton = new ComplexButton("", Game.i.assetManager.getLabelStyle(30), () -> { Input.TextInputListener textInputListener = this.d; hide(); if (textInputListener != null) { textInputListener.canceled(); Game.i.soundManager.playStatic(StaticSoundType.BUTTON); }  })).setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-times"), 26.0F, 18.0F, 48.0F, 48.0F);
/*  84 */     complexButton.setIconLabelColors(MaterialColor.RED.P800, MaterialColor.RED.P900, MaterialColor.RED.P700, Color.GRAY);
/*  85 */     complexButton.setSize(100.0F, 80.0F);
/*  86 */     complexButton.setPosition(750.0F, 146.0F);
/*  87 */     group.addActor((Actor)complexButton);
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
/*  99 */     (complexButton = new ComplexButton("", Game.i.assetManager.getLabelStyle(30), () -> { Input.TextInputListener textInputListener = this.d; hide(); if (textInputListener != null) { textInputListener.input(this.c.getText()); Game.i.soundManager.playStatic(StaticSoundType.BUTTON); }  })).setBackground((Drawable)new QuadDrawable(new QuadActor(Color.WHITE, new float[] { 2.0F, 3.0F, 0.0F, 77.0F, 120.0F, 80.0F, 118.0F, 0.0F })), 0.0F, 0.0F, 120.0F, 80.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 105 */     complexButton.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-check"), 36.0F, 18.0F, 48.0F, 48.0F);
/* 106 */     complexButton.setBackgroundColors(MaterialColor.GREEN.P800, MaterialColor.GREEN.P900, MaterialColor.GREEN.P700, Color.GRAY);
/* 107 */     complexButton.setSize(120.0F, 80.0F);
/* 108 */     complexButton.setPosition(640.0F, -50.0F);
/* 109 */     group.addActor((Actor)complexButton);
/*     */     
/* 111 */     this.a.getTable().setVisible(false);
/*     */   }
/*     */   
/*     */   private void a() {
/* 115 */     DarkOverlay.i().addCallerOverlayLayer("TextInputOverlay", this.a.zIndex - 1, () -> false);
/* 116 */     this.a.getTable().setVisible(true);
/*     */     
/* 118 */     Game.i.uiManager.stage.setKeyboardFocus((Actor)this.c);
/*     */   }
/*     */   
/*     */   public void show(Input.TextInputListener paramTextInputListener, String paramString1, String paramString2, String paramString3) {
/* 122 */     this.d = paramTextInputListener;
/* 123 */     this.c.setText(paramString2);
/* 124 */     this.c.setMessageText(paramString3);
/* 125 */     this.b.setText(paramString1);
/*     */     
/* 127 */     a();
/*     */   }
/*     */   
/*     */   public boolean isVisible() {
/* 131 */     return this.a.getTable().isVisible();
/*     */   }
/*     */ 
/*     */   
/*     */   public void postRender(float paramFloat) {
/* 136 */     if (isVisible()) {
/* 137 */       if (Gdx.input.isKeyJustPressed(4) || Gdx.input.isKeyJustPressed(111)) {
/* 138 */         this.d.canceled();
/* 139 */         hide();
/*     */         
/* 141 */         Game.i.soundManager.playStatic(StaticSoundType.BUTTON); return;
/* 142 */       }  if (Gdx.input.isKeyJustPressed(66) || Gdx.input.isKeyJustPressed(160)) {
/* 143 */         Input.TextInputListener textInputListener = this.d;
/* 144 */         hide();
/*     */         
/* 146 */         if (textInputListener != null) {
/* 147 */           textInputListener.input(this.c.getText());
/* 148 */           Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void hide() {
/* 156 */     this.a.getTable().setVisible(false);
/* 157 */     DarkOverlay.i().removeCaller("TextInputOverlay");
/*     */     
/* 159 */     this.d = null;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\TextInputOverlay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */