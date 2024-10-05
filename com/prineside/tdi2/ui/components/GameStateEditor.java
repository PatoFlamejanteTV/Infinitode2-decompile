/*     */ package com.prineside.tdi2.ui.components;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.screens.GameScreen;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.PaddedImageButton;
/*     */ import com.prineside.tdi2.ui.actors.TextFieldXPlatform;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ 
/*     */ public class GameStateEditor implements Disposable {
/*  21 */   private final UiManager.UiLayer a = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 104, "GameStateEditor");
/*     */   
/*     */   private Label b;
/*     */   
/*     */   private TextFieldXPlatform c;
/*     */   private GameSystemProvider d;
/*  27 */   private static final StringBuilder e = new StringBuilder();
/*     */   
/*     */   public GameStateEditor(GameSystemProvider paramGameSystemProvider) {
/*  30 */     this.d = paramGameSystemProvider;
/*     */     
/*     */     Group group;
/*  33 */     (group = new Group()).setTransform(false);
/*  34 */     this.a.getTable().add((Actor)group).size(600.0F, 200.0F).padBottom(40.0F).bottom().expandY();
/*     */     
/*     */     Image image;
/*  37 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(0.0F, 0.0F, 0.0F, 0.56F);
/*  38 */     image.setSize(600.0F, 200.0F);
/*  39 */     group.addActor((Actor)image);
/*     */     
/*  41 */     this.b = new Label("", Game.i.assetManager.getLabelStyle(24));
/*  42 */     this.b.setPosition(20.0F, 160.0F);
/*  43 */     this.b.setSize(100.0F, 20.0F);
/*  44 */     group.addActor((Actor)this.b);
/*     */ 
/*     */     
/*     */     PaddedImageButton paddedImageButton2;
/*     */     
/*  49 */     (paddedImageButton2 = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-pause"), () -> paramGameSystemProvider.gameState.setGameSpeed(0.0F), MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P300, MaterialColor.LIGHT_BLUE.P700)).setSize(48.0F, 48.0F);
/*  50 */     paddedImageButton2.setIconPosition(8.0F, 8.0F);
/*  51 */     paddedImageButton2.setIconSize(32.0F, 32.0F);
/*  52 */     paddedImageButton2.setPosition(20.0F, 100.0F);
/*  53 */     group.addActor((Actor)paddedImageButton2);
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
/*  64 */     (paddedImageButton2 = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-triangle-right"), () -> { GameScreen gameScreen; (gameScreen = a()).updateSystems(); gameScreen.updateDraw(paramGameSystemProvider.gameValue.getTickRateDeltaTime(), paramGameSystemProvider.gameValue.getTickRateDeltaTime()); }MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P300, MaterialColor.LIGHT_BLUE.P700)).setSize(48.0F, 48.0F);
/*  65 */     paddedImageButton2.setIconPosition(8.0F, 8.0F);
/*  66 */     paddedImageButton2.setIconSize(32.0F, 32.0F);
/*  67 */     paddedImageButton2.setPosition(84.0F, 100.0F);
/*  68 */     group.addActor((Actor)paddedImageButton2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     PaddedImageButton paddedImageButton1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  86 */     (paddedImageButton1 = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-double-triangle-right"), () -> { GameScreen gameScreen = a(); int i = 10; try { i = Integer.parseInt(this.c.getText()); } catch (Exception exception) {} for (byte b = 0; b < i; b++) { gameScreen.updateSystems(); gameScreen.updateDraw(paramGameSystemProvider.gameValue.getTickRateDeltaTime(), paramGameSystemProvider.gameValue.getTickRateDeltaTime()); }  }MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P300, MaterialColor.LIGHT_BLUE.P700)).setSize(48.0F, 48.0F);
/*  87 */     paddedImageButton1.setIconPosition(8.0F, 8.0F);
/*  88 */     paddedImageButton1.setIconSize(32.0F, 32.0F);
/*  89 */     paddedImageButton1.setPosition(148.0F, 100.0F);
/*  90 */     group.addActor((Actor)paddedImageButton1);
/*     */     
/*  92 */     this.c = new TextFieldXPlatform("10", Game.i.assetManager.getTextFieldStyle(24));
/*  93 */     this.c.setSize(96.0F, 48.0F);
/*  94 */     this.c.setPosition(212.0F, 100.0F);
/*  95 */     group.addActor((Actor)this.c);
/*     */     
/*  97 */     this.a.getTable().setVisible(false);
/*     */   }
/*     */   
/*     */   private static GameScreen a() {
/* 101 */     return (GameScreen)Game.i.screenManager.getCurrentScreen();
/*     */   }
/*     */   
/*     */   public void draw(float paramFloat) {
/* 105 */     if (Gdx.input.isKeyJustPressed(140)) {
/* 106 */       this.a.getTable().setVisible(!this.a.getTable().isVisible());
/*     */     }
/* 108 */     if (!this.a.getTable().isVisible())
/*     */       return; 
/* 110 */     e.setLength(0);
/* 111 */     e.append("F: ").append(StringFormatter.commaSeparatedNumber(this.d.gameState.updateNumber))
/* 112 */       .append("| S: ").append(StringFormatter.compactNumberWithPrecisionTrimZeros(this.d.gameState.getGameSpeed(), 2, true));
/* 113 */     this.b.setText((CharSequence)e);
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 118 */     Game.i.uiManager.removeLayer(this.a);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\GameStateEditor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */