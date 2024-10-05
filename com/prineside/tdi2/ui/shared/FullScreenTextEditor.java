/*     */ package com.prineside.tdi2.ui.shared;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.Rectangle;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.global.PreRender;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.InputListener;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.ui.TextArea;
/*     */ import com.prineside.tdi2.scene2d.ui.TextField;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*     */ import com.prineside.tdi2.ui.actors.FancyButton;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.ObjectConsumer;
/*     */ 
/*     */ public final class FullScreenTextEditor extends UiManager.UiComponent.Adapter {
/*     */   private final UiManager.UiLayer a;
/*     */   
/*     */   static {
/*  28 */     TLog.forClass(FullScreenTextEditor.class);
/*     */   } private final UiManager.UiLayer b;
/*     */   public static FullScreenTextEditor i() {
/*  31 */     return (FullScreenTextEditor)Game.i.uiManager.getComponent(FullScreenTextEditor.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  37 */   private int c = -1;
/*     */   
/*     */   private final Listener<PreRender> d = paramPreRender -> a();
/*     */   
/*     */   private Image e;
/*     */   private Label f;
/*     */   private TextArea g;
/*     */   private ObjectConsumer<String> h;
/*     */   
/*     */   public FullScreenTextEditor() {
/*  47 */     this.a = Game.i.uiManager.addLayerIgnoreSafeArea(UiManager.MainUiLayer.OVERLAY, 9002, "FullScreenTextEditor background", true);
/*  48 */     this.a.ignoreVisibleFrame = true;
/*     */     
/*  50 */     this.b = Game.i.uiManager.addLayer(UiManager.MainUiLayer.OVERLAY, 9003, "FullScreenTextEditor main");
/*  51 */     this.b.followVisibleFrame = true;
/*  52 */     this.b.ignoreVisibleFrame = true;
/*  53 */     Game.i.uiManager.rebuildLayers();
/*     */     
/*  55 */     Drawable drawable = (new TextureRegionDrawable((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion())).tint(new Color(572662527));
/*  56 */     this.a.getTable().setBackground(drawable);
/*     */     
/*  58 */     Table table1 = new Table();
/*  59 */     this.b.getTable().add((Actor)table1).grow().row();
/*     */ 
/*     */     
/*  62 */     Table table2 = new Table();
/*  63 */     table1.add((Actor)table2).growX().height(56.0F).row();
/*     */     
/*     */     FancyButton fancyButton;
/*  66 */     (fancyButton = new FancyButton("regularRedButton.a", this::hide)).add((Actor)new Image((Drawable)Game.i.assetManager.getDrawable("icon-times"))).size(20.0F).padRight(4.0F);
/*  67 */     fancyButton.add((Actor)new Label("Cancel", Game.i.assetManager.getLabelStyle(21)));
/*  68 */     fancyButton.setBackgroundDrawable((Drawable)Game.i.assetManager.getDrawable("blank"));
/*  69 */     fancyButton.setBackgroundColors(MaterialColor.RED.P800, MaterialColor.RED.P700, MaterialColor.RED.P900, Color.WHITE);
/*  70 */     table2.add((Actor)fancyButton).size(128.0F, 56.0F);
/*     */     
/*  72 */     table2.add().growX();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  78 */     (fancyButton = new FancyButton("regularGreenButton.b", () -> { this.h.accept(this.g.getText()); hide(); })).add((Actor)new Image((Drawable)Game.i.assetManager.getDrawable("icon-check"))).size(20.0F).padRight(4.0F);
/*  79 */     fancyButton.add((Actor)new Label("Confirm", Game.i.assetManager.getLabelStyle(21)));
/*  80 */     fancyButton.setBackgroundDrawable((Drawable)Game.i.assetManager.getDrawable("blank"));
/*  81 */     fancyButton.setBackgroundColors(MaterialColor.LIGHT_GREEN.P800, MaterialColor.LIGHT_GREEN.P700, MaterialColor.LIGHT_GREEN.P900, Color.WHITE);
/*  82 */     table2.add((Actor)fancyButton).size(128.0F, 56.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     TextField.TextFieldStyle textFieldStyle;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  92 */     (textFieldStyle = new TextField.TextFieldStyle(Game.i.assetManager.getDebugFont(true), Color.WHITE, (Drawable)new TextureRegionDrawable((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion()), (new TextureRegionDrawable((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion())).tint(MaterialColor.BLUE.P800), (new TextureRegionDrawable((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion())).tint(new Color(0.0F, 0.0F, 0.0F, 0.4F)))).cursor.setMinWidth(2.0F);
/*  93 */     textFieldStyle.background.setLeftWidth(textFieldStyle.background.getLeftWidth() + 16.0F);
/*  94 */     textFieldStyle.background.setRightWidth(textFieldStyle.background.getRightWidth() + 8.0F);
/*  95 */     textFieldStyle.background.setBottomHeight(textFieldStyle.background.getBottomHeight() + 8.0F);
/*  96 */     textFieldStyle.background.setTopHeight(textFieldStyle.background.getTopHeight() + 8.0F);
/*     */     
/*     */     ScrollPane.ScrollPaneStyle scrollPaneStyle;
/*  99 */     (scrollPaneStyle = new ScrollPane.ScrollPaneStyle()).vScroll = Game.i.assetManager.getDrawable("blank").tint(new Color(0.0F, 0.0F, 0.0F, 1.0F));
/* 100 */     scrollPaneStyle.vScrollKnob = Game.i.assetManager.getDrawable("blank").tint(new Color(572662527));
/* 101 */     scrollPaneStyle.vScroll.setMinWidth(128.0F);
/* 102 */     scrollPaneStyle.vScrollKnob.setMinWidth(128.0F);
/*     */     
/* 104 */     Table table3 = new Table();
/*     */     ScrollPane scrollPane;
/* 106 */     (scrollPane = new ScrollPane((Actor)table3, scrollPaneStyle)).setOverscroll(false, false);
/* 107 */     scrollPane.setFadeScrollBars(false);
/* 108 */     table1.add((Actor)scrollPane).grow().row();
/*     */     
/* 110 */     this.e = new Image((Drawable)Game.i.assetManager.getDrawable("blank"));
/* 111 */     this.e.setColor(1.0F, 1.0F, 1.0F, 0.14F);
/* 112 */     table3.addActor((Actor)this.e);
/*     */     
/* 114 */     this.f = new Label("", Game.i.assetManager.getDebugLabelStyle());
/* 115 */     this.f.setAlignment(16);
/* 116 */     this.f.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 117 */     table3.add((Actor)this.f).top().width(118.0F).padTop(textFieldStyle.background.getTopHeight()).padRight(10.0F);
/*     */     
/* 119 */     this.g = new TextArea("", textFieldStyle);
/* 120 */     this.g.prefSizeDependsOnContents = true;
/* 121 */     this.g.setFocusTraversal(false);
/*     */ 
/*     */     
/* 124 */     this.g.replaceTabsWithSpaces = true;
/*     */ 
/*     */     
/* 127 */     this.g.addListener((EventListener)new InputListener(this)
/*     */         {
/*     */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/* 130 */             param1InputEvent.stop();
/* 131 */             param1InputEvent.cancel();
/* 132 */             return true;
/*     */           }
/*     */         });
/* 135 */     table3.add((Actor)this.g).grow();
/*     */   }
/*     */   
/*     */   private void a() {
/* 139 */     int i = this.g.getLines();
/* 140 */     if (this.c != i) {
/* 141 */       StringBuilder stringBuilder = new StringBuilder();
/* 142 */       for (byte b = 0; b < i; b++) {
/* 143 */         stringBuilder.append(b + 1).append("\n");
/*     */       }
/* 145 */       this.f.setText(stringBuilder);
/* 146 */       this.c = i;
/*     */     } 
/*     */     
/* 149 */     Rectangle rectangle = new Rectangle();
/* 150 */     this.g.getSelectionBoundingBox(rectangle);
/* 151 */     this.e.setX(0.0F);
/* 152 */     this.e.setY(rectangle.y - 1.0F);
/* 153 */     this.e.setHeight(rectangle.height);
/* 154 */     this.e.setWidth(Game.i.uiManager.stage.getWidth());
/*     */   }
/*     */   
/*     */   public final void show(String paramString, ObjectConsumer<String> paramObjectConsumer) {
/* 158 */     Preconditions.checkNotNull(paramObjectConsumer, "onConfirm can not be null");
/* 159 */     this.h = paramObjectConsumer;
/* 160 */     this.a.getTable().setVisible(true);
/* 161 */     this.b.getTable().setVisible(true);
/*     */     
/* 163 */     this.g.setText(paramString);
/*     */     
/* 165 */     Game.EVENTS.getListeners(PreRender.class).add(this.d);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void hide() {
/* 170 */     this.a.getTable().setVisible(false);
/* 171 */     this.b.getTable().setVisible(false);
/* 172 */     Game.EVENTS.getListeners(PreRender.class).remove(this.d);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\FullScreenTextEditor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */