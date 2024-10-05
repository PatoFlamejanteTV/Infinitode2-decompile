/*     */ package com.prineside.tdi2.ui.shared;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.graphics.g3d.Attribute;
/*     */ import com.badlogic.gdx.graphics.g3d.Environment;
/*     */ import com.badlogic.gdx.graphics.g3d.Model;
/*     */ import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.enums.TrophyType;
/*     */ import com.prineside.tdi2.managers.GameValueManager;
/*     */ import com.prineside.tdi2.managers.TrophyManager;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.ModelView;
/*     */ import com.prineside.tdi2.ui.actors.QuadActor;
/*     */ 
/*     */ public class TrophyViewOverlay extends UiManager.UiComponent.Adapter {
/*     */   public static TrophyViewOverlay i() {
/*  29 */     return (TrophyViewOverlay)Game.i.uiManager.getComponent(TrophyViewOverlay.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  34 */   private final UiManager.UiLayer a = Game.i.uiManager.addLayer(UiManager.MainUiLayer.OVERLAY, 161, "TrophyViewOverlay main");
/*     */   
/*     */   private Group b;
/*     */   
/*     */   private Label c;
/*     */   
/*     */   private Table d;
/*     */   private ModelView e;
/*     */   private ModelView f;
/*     */   private Image g;
/*     */   
/*     */   public TrophyViewOverlay() {
/*  46 */     this.b = new Group();
/*  47 */     this.b.setOrigin(458.0F, 203.0F);
/*  48 */     this.b.setTouchable(Touchable.childrenOnly);
/*  49 */     this.a.getTable().add((Actor)this.b).size(916.0F, 406.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     QuadActor quadActor;
/*     */ 
/*     */ 
/*     */     
/*  58 */     (quadActor = new QuadActor(new Color(0.0F, 0.0F, 0.0F, 0.28F), new float[] { 0.0F, 17.0F, 0.0F, 93.0F, 525.0F, 94.0F, 498.0F, 0.0F })).setPosition(389.0F, 253.0F);
/*  59 */     this.b.addActor((Actor)quadActor);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  67 */     (quadActor = new QuadActor(new Color(791621631), new float[] { 0.0F, 17.0F, 0.0F, 102.0F, 510.0F, 107.0F, 489.0F, 13.0F })).setPosition(389.0F, 253.0F);
/*  68 */     quadActor.setTouchable(Touchable.enabled);
/*  69 */     this.b.addActor((Actor)quadActor);
/*     */     
/*  71 */     this.c = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(36), Color.WHITE));
/*  72 */     this.c.setPosition(427.0F, 297.0F);
/*  73 */     this.c.setSize(500.0F, 26.0F);
/*  74 */     this.b.addActor((Actor)this.c);
/*     */ 
/*     */     
/*  77 */     quadActor = new QuadActor(new Color(0.0F, 0.0F, 0.0F, 0.28F), new float[] { 17.0F, 0.0F, 3.0F, 383.0F, 413.0F, 381.0F, 391.0F, 14.0F });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  83 */     this.b.addActor((Actor)quadActor);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  91 */     (quadActor = new QuadActor(new Color(791621631), new float[] { 3.0F, 14.0F, 0.0F, 406.0F, 391.0F, 402.0F, 387.0F, 18.0F })).setTouchable(Touchable.enabled);
/*  92 */     this.b.addActor((Actor)quadActor);
/*     */     
/*     */     Environment environment;
/*  95 */     (environment = new Environment()).set((Attribute)new ColorAttribute(ColorAttribute.AmbientLight, 0.3F, 0.3F, 0.3F, 1.0F));
/*  96 */     environment.add((new DirectionalLight()).set(0.75F, 0.75F, 0.75F, -0.5F, -1.0F, -0.2F));
/*  97 */     this.e = new ModelView(564, 564, ModelView.rotateModelAround, environment, false);
/*  98 */     this.e.setName("trophy-view-overlay-model-view");
/*  99 */     this.e.setPosition(-87.0F, -72.0F);
/* 100 */     this.e.setSize(564.0F, 564.0F);
/* 101 */     this.e.setTouchable(Touchable.disabled);
/*     */     
/* 103 */     this.e.camera.position.set(0.5F, 0.15F, 0.0F);
/* 104 */     this.e.camera.lookAt(0.0F, -0.03F, 0.0F);
/* 105 */     this.e.camera.update();
/*     */     
/* 107 */     this.b.addActor((Actor)this.e);
/*     */     
/* 109 */     this.g = new Image();
/* 110 */     this.g.setPosition(67.0F, 82.0F);
/* 111 */     this.g.setSize(256.0F, 256.0F);
/* 112 */     this.b.addActor((Actor)this.g);
/*     */     
/* 114 */     this.f = new ModelView(64, 64, ModelView.rotateModelAround, new Environment(), false);
/* 115 */     this.f.setName("trophy-view-overlay-model-view-locked");
/* 116 */     this.f.setPosition(-87.0F, -72.0F);
/* 117 */     this.f.setSize(564.0F, 564.0F);
/* 118 */     this.b.addActor((Actor)this.f);
/*     */ 
/*     */     
/* 121 */     this.d = new Table();
/* 122 */     this.d.setPosition(419.0F, -65.0F);
/* 123 */     this.d.setSize(450.0F, 301.0F);
/* 124 */     this.b.addActor((Actor)this.d);
/*     */     
/* 126 */     this.a.getTable().setVisible(false);
/*     */   } public void show(TrophyType paramTrophyType) {
/*     */     TrophyManager.TrophyConfig trophyConfig;
/*     */     Label label;
/* 130 */     this.d.clearChildren();
/*     */     
/* 132 */     this.f.setVisible(false);
/* 133 */     this.e.setVisible(false);
/* 134 */     this.g.setVisible(false);
/*     */     
/* 136 */     Model model = Game.i.assetManager.getSceneModelIfLoaded();
/* 137 */     if (Game.i.trophyManager.getConfig(paramTrophyType).isReceived()) {
/*     */       
/* 139 */       if (Game.i.settingsManager.isThreeDeeModelsEnabled() && model != null) {
/*     */         
/* 141 */         this.e.setModelPart(model, "t-" + paramTrophyType.name(), null, 0.3F);
/* 142 */         this.e.setVisible(true);
/*     */       } else {
/*     */         
/* 145 */         this.g.setDrawable((Drawable)new TextureRegionDrawable(Game.i.trophyManager.getConfig(paramTrophyType).getIconTexture()));
/* 146 */         this.g.setColor(Color.WHITE);
/* 147 */         this.g.setVisible(true);
/*     */       } 
/*     */       
/* 150 */       trophyConfig = Game.i.trophyManager.getConfig(paramTrophyType);
/* 151 */       this.c.setText(trophyConfig.getTitle());
/* 152 */       this.c.setColor(Color.WHITE);
/*     */       
/* 154 */       for (byte b = 0; b < trophyConfig.gameValues.size; b++) {
/* 155 */         GameValueManager.GameValueEffect gameValueEffect = (GameValueManager.GameValueEffect)trophyConfig.gameValues.get(b);
/* 156 */         GameValueManager.GameValueStockConfig gameValueStockConfig = Game.i.gameValueManager.getStockValueConfig(gameValueEffect.type);
/*     */         
/*     */         Group group;
/* 159 */         (group = new Group()).setTransform(false);
/* 160 */         this.d.add((Actor)group).size(64.0F).pad(8.0F);
/*     */         
/*     */         Image image;
/* 163 */         (image = new Image((Drawable)gameValueStockConfig.getIcon())).setSize(64.0F, 64.0F);
/* 164 */         group.addActor((Actor)image);
/*     */         
/*     */         Label label2;
/* 167 */         (label2 = new Label((CharSequence)Game.i.gameValueManager.getTitle(gameValueEffect.type), Game.i.assetManager.getLabelStyle(24))).setWrap(true);
/* 168 */         this.d.add((Actor)label2).padLeft(10.0F).height(80.0F).expandX().fillX();
/*     */         
/* 170 */         Label label1 = new Label((CharSequence)Game.i.gameValueManager.formatEffectValue(gameValueEffect.delta, gameValueStockConfig.units), Game.i.assetManager.getLabelStyle(30));
/* 171 */         this.d.add((Actor)label1).height(80.0F).padLeft(16.0F).row();
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 176 */       (label = new Label(Game.i.localeManager.i18n.get("trophy_view_effects_hint"), Game.i.assetManager.getLabelStyle(18))).setAlignment(1);
/* 177 */       label.setColor(MaterialColor.AMBER.P300.cpy().mul(1.0F, 1.0F, 1.0F, 0.56F));
/* 178 */       label.setWrap(true);
/* 179 */       this.d.add((Actor)label).minWidth(400.0F).fillX().colspan(2).padTop(15.0F).row();
/*     */       
/* 181 */       this.d.add().expandY().fillY().width(1.0F);
/*     */     } else {
/* 183 */       if (Game.i.settingsManager.isThreeDeeModelsEnabled() && label != null) {
/*     */         
/* 185 */         this.f.setModelPart((Model)label, "t-" + trophyConfig.name(), Game.i.assetManager.normalMaterial, 0.3F);
/* 186 */         this.f.setVisible(true);
/*     */       } else {
/*     */         
/* 189 */         this.g.setDrawable((Drawable)new TextureRegionDrawable(Game.i.trophyManager.getConfig((TrophyType)trophyConfig).getWhiteTexture()));
/* 190 */         this.g.setColor(Color.BLACK);
/* 191 */         this.g.setVisible(true);
/*     */       } 
/*     */       
/* 194 */       this.c.setText(Game.i.localeManager.i18n.get("unknown_trophy"));
/* 195 */       this.c.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*     */       
/*     */       Label label1;
/* 198 */       (label1 = new Label(Game.i.trophyManager.getHowToObtainHint((TrophyType)trophyConfig), Game.i.assetManager.getLabelStyle(24))).setWrap(true);
/* 199 */       this.d.add((Actor)label1).growX().row();
/* 200 */       this.d.add().width(1.0F).growY();
/*     */     } 
/*     */     
/* 203 */     this.a.getTable().setVisible(true);
/* 204 */     DarkOverlay.i().addCallerOverlayLayer("TrophyViewOverlay", this.a.zIndex - 1, () -> {
/*     */           hide();
/*     */           
/*     */           return true;
/*     */         });
/* 209 */     float f = Game.i.settingsManager.isUiAnimationsEnabled() ? 1.0F : 0.0F;
/*     */     
/* 211 */     this.b.clearActions();
/* 212 */     this.b.addAction((Action)Actions.sequence(
/* 213 */           (Action)Actions.scaleTo(0.0F, 0.0F), 
/* 214 */           (Action)Actions.parallel(
/* 215 */             (Action)Actions.sequence(
/* 216 */               (Action)Actions.delay(0.1F * f), 
/* 217 */               (Action)Actions.scaleBy(1.0F, 0.0F, 0.3F * f, (Interpolation)Interpolation.swingOut)), 
/*     */             
/* 219 */             (Action)Actions.scaleBy(0.0F, 1.0F, 0.3F * f, (Interpolation)Interpolation.swingOut))));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hide() {
/* 226 */     float f = Game.i.settingsManager.isUiAnimationsEnabled() ? 1.0F : 0.0F;
/*     */     
/* 228 */     DarkOverlay.i().removeCaller("TrophyViewOverlay");
/*     */     
/* 230 */     this.b.clearActions();
/* 231 */     this.b.addAction((Action)Actions.sequence(
/* 232 */           (Action)Actions.parallel(
/* 233 */             (Action)Actions.sequence(
/* 234 */               (Action)Actions.delay(0.07F * f), 
/* 235 */               (Action)Actions.scaleBy(0.0F, -this.b.getScaleY(), 0.3F * f, (Interpolation)Interpolation.swingIn)), 
/*     */             
/* 237 */             (Action)Actions.scaleBy(-this.b.getScaleX(), 0.0F, 0.3F * f, (Interpolation)Interpolation.swingIn)), 
/*     */           
/* 239 */           (Action)Actions.run(() -> this.a.getTable().setVisible(false))));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\TrophyViewOverlay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */