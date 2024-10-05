/*     */ package com.prineside.tdi2.ui.shared;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.enums.TrophyType;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.scene2d.ui.Cell;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.ui.actors.ItemCell;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.QuadActor;
/*     */ import com.prineside.tdi2.utils.UiUtils;
/*     */ 
/*     */ public final class TrophiesListOverlay extends UiManager.UiComponent.Adapter {
/*     */   public static TrophiesListOverlay i() {
/*  27 */     return (TrophiesListOverlay)Game.i.uiManager.getComponent(TrophiesListOverlay.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  34 */   private final UiManager.UiLayer a = Game.i.uiManager.addLayer(UiManager.MainUiLayer.OVERLAY, 153, "TrophiesList main");
/*     */   
/*     */   private Table b;
/*     */   
/*     */   private ScrollPane c;
/*     */   
/*     */   private Label d;
/*     */   private Label e;
/*     */   private Label f;
/*     */   
/*     */   public TrophiesListOverlay() {
/*     */     Table table;
/*  46 */     (table = new Table()).setTouchable(Touchable.childrenOnly);
/*     */     
/*  48 */     this.c = new ScrollPane((Actor)table);
/*  49 */     UiUtils.enableMouseMoveScrollFocus(this.c);
/*  50 */     this.c.setTransform(true);
/*  51 */     this.c.setOrigin(559.0F, Game.i.settingsManager.getScaledViewportHeight() / 2.0F);
/*  52 */     this.c.setTouchable(Touchable.childrenOnly);
/*  53 */     this.a.getTable().add((Actor)this.c).width(1118.0F).expandY().fillY();
/*     */     
/*     */     Group group;
/*     */     
/*  57 */     (group = new Group()).setTransform(false);
/*     */ 
/*     */ 
/*     */     
/*     */     QuadActor quadActor;
/*     */ 
/*     */ 
/*     */     
/*  65 */     (quadActor = new QuadActor(new Color(791621631), new float[] { 0.0F, 0.0F, 0.0F, 110.0F, 1060.0F, 95.0F, 1060.0F, 0.0F })).setSize(1118.0F, 110.0F);
/*  66 */     group.addActor((Actor)quadActor);
/*  67 */     table.add((Actor)group).height(110.0F).padTop(160.0F).width(1118.0F).row();
/*     */     
/*  69 */     this.d = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(36), Color.WHITE));
/*  70 */     this.d.setSize(1000.0F, 26.0F);
/*  71 */     this.d.setPosition(40.0F, 26.0F);
/*  72 */     this.d.setAlignment(12);
/*  73 */     group.addActor((Actor)this.d);
/*     */     
/*  75 */     this.e = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE));
/*  76 */     this.e.setPosition(40.0F, 26.0F);
/*  77 */     this.e.setSize(1038.0F, 26.0F);
/*  78 */     this.e.setAlignment(20);
/*  79 */     this.e.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  80 */     group.addActor((Actor)this.e);
/*     */ 
/*     */     
/*  83 */     this.b = new Table();
/*  84 */     this.b.setTouchable(Touchable.enabled);
/*  85 */     this.b.setBackground(Game.i.assetManager.getDrawable("blank").tint(new Color(791621631)));
/*  86 */     table.add((Actor)this.b).expandX().fillX().row();
/*     */ 
/*     */ 
/*     */     
/*  90 */     (group = new Group()).setTransform(false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  98 */     (quadActor = new QuadActor(new Color(791621631), new float[] { 0.0F, 0.0F, 0.0F, 30.0F, 1060.0F, 30.0F, 1060.0F, 15.0F })).setSize(1118.0F, 30.0F);
/*  99 */     group.addActor((Actor)quadActor);
/*     */     
/* 101 */     this.f = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE));
/* 102 */     this.f.addAction((Action)Actions.forever(
/* 103 */           (Action)Actions.sequence(
/* 104 */             (Action)Actions.color(Color.WHITE, 0.4F), 
/* 105 */             (Action)Actions.color(new Color(1.0F, 1.0F, 1.0F, 0.56F), 0.8F), 
/* 106 */             (Action)Actions.delay(0.5F))));
/*     */ 
/*     */     
/* 109 */     this.f.setTouchable(Touchable.disabled);
/* 110 */     this.f.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 111 */     this.f.setSize(1118.0F, 20.0F);
/* 112 */     this.f.setPosition(0.0F, -60.0F);
/* 113 */     this.f.setAlignment(1);
/* 114 */     group.addActor((Actor)this.f);
/*     */     
/* 116 */     table.add((Actor)group).height(30.0F).padBottom(160.0F).width(1118.0F).row();
/*     */ 
/*     */     
/* 119 */     this.a.getTable().setVisible(false);
/*     */   }
/*     */   
/*     */   public final void show() {
/* 123 */     this.b.clear();
/*     */     
/* 125 */     this.d.setText(Game.i.localeManager.i18n.get("trophies").toUpperCase());
/* 126 */     this.e.setText(Game.i.localeManager.i18n.get("tap_icons_for_more_info"));
/* 127 */     this.f.setText(Game.i.localeManager.i18n.get("tap_outside_list_to_hide"));
/*     */     
/* 129 */     byte b1 = 0;
/* 130 */     byte b2 = 0; TrophyType[] arrayOfTrophyType; int i; byte b3;
/* 131 */     for (i = (arrayOfTrophyType = TrophyType.values).length, b3 = 0; b3 < i; ) { Image image; TrophyType trophyType = arrayOfTrophyType[b3];
/*     */       ItemCell itemCell;
/* 133 */       (itemCell = new ItemCell()).setColRow(b1, b2);
/*     */ 
/*     */       
/* 136 */       if (Game.i.trophyManager.getConfig(trophyType).isReceived()) {
/* 137 */         image = new Image(Game.i.trophyManager.getConfig(trophyType).getIconTexture());
/*     */       } else {
/*     */         
/* 140 */         (image = new Image(Game.i.trophyManager.getConfig(trophyType).getWhiteTexture())).setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*     */       } 
/*     */       
/* 143 */       itemCell.setIconAndCount((Actor)image, 1.25F, 0);
/*     */       
/* 145 */       itemCell.addListener((EventListener)new ClickListener(this, trophyType)
/*     */           {
/*     */             public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 148 */               TrophyViewOverlay.i().show(this.a);
/* 149 */               Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*     */             }
/*     */           });
/*     */       
/* 153 */       Cell cell = this.b.add((Actor)itemCell).size(128.0F, 140.0F);
/* 154 */       b1++;
/* 155 */       if (b1 == 8) {
/* 156 */         b1 = 0;
/* 157 */         b2++;
/*     */         
/* 159 */         cell.row();
/*     */       } 
/*     */       
/*     */       b3++; }
/*     */     
/* 164 */     float f = Game.i.settingsManager.isUiAnimationsEnabled() ? 1.0F : 0.0F;
/*     */     
/* 166 */     DarkOverlay.i().addCallerOverlayLayer("TrophiesListOverlay", this.a.zIndex - 1, () -> {
/*     */           hide();
/*     */           return true;
/*     */         });
/* 170 */     this.a.getTable().setVisible(true);
/*     */     
/* 172 */     this.c.clearActions();
/* 173 */     this.c.addAction((Action)Actions.sequence(
/* 174 */           (Action)Actions.scaleTo(0.0F, 0.0F), 
/* 175 */           (Action)Actions.parallel(
/* 176 */             (Action)Actions.sequence(
/* 177 */               (Action)Actions.delay(0.1F * f), 
/* 178 */               (Action)Actions.scaleBy(1.0F, 0.0F, 0.3F * f, (Interpolation)Interpolation.swingOut)), 
/*     */             
/* 180 */             (Action)Actions.scaleBy(0.0F, 1.0F, 0.3F * f, (Interpolation)Interpolation.swingOut))));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void hide() {
/* 187 */     float f = Game.i.settingsManager.isUiAnimationsEnabled() ? 1.0F : 0.0F;
/*     */     
/* 189 */     DarkOverlay.i().removeCaller("TrophiesListOverlay");
/*     */     
/* 191 */     this.c.clearActions();
/* 192 */     this.c.addAction((Action)Actions.sequence(
/* 193 */           (Action)Actions.parallel(
/* 194 */             (Action)Actions.sequence(
/* 195 */               (Action)Actions.delay(0.07F * f), 
/* 196 */               (Action)Actions.scaleBy(0.0F, -this.c.getScaleY(), 0.3F * f, (Interpolation)Interpolation.swingIn)), 
/*     */             
/* 198 */             (Action)Actions.scaleBy(-this.c.getScaleX(), 0.0F, 0.3F * f, (Interpolation)Interpolation.swingIn)), 
/*     */           
/* 200 */           (Action)Actions.run(() -> this.a.getTable().setVisible(false))));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\TrophiesListOverlay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */