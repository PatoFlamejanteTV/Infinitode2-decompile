/*     */ package com.prineside.tdi2.ui.shared;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.EnemyGroup;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.tiles.SpawnTile;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.QuadActor;
/*     */ import com.prineside.tdi2.utils.UiUtils;
/*     */ 
/*     */ public class WavesTimelineOverlay extends UiManager.UiComponent.Adapter {
/*     */   public static WavesTimelineOverlay i() {
/*  26 */     return (WavesTimelineOverlay)Game.i.uiManager.getComponent(WavesTimelineOverlay.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  31 */   private final UiManager.UiLayer a = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 216, "WavesTimelineOverlay tint");
/*  32 */   private final UiManager.UiLayer b = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 217, "WavesTimelineOverlay main");
/*     */   
/*     */   private Group c;
/*     */   
/*     */   private Runnable d;
/*     */   private ScrollPane e;
/*     */   
/*     */   public WavesTimelineOverlay() {
/*     */     Image image;
/*  41 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(Config.BACKGROUND_COLOR);
/*  42 */     (image.getColor()).a = 0.78F;
/*  43 */     this.a.getTable().add((Actor)image).expand().fill();
/*  44 */     this.a.getTable().setTouchable(Touchable.enabled);
/*  45 */     this.a.getTable().addListener((EventListener)new ClickListener(this)
/*     */         {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  48 */             this.a.hide();
/*  49 */             Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*     */           }
/*     */         });
/*     */     
/*     */     Group group;
/*  54 */     (group = new Group()).setTransform(false);
/*  55 */     group.setOrigin(630.0F, 380.0F);
/*  56 */     group.setTouchable(Touchable.childrenOnly);
/*  57 */     this.b.getTable().add((Actor)group).size(1260.0F, 760.0F);
/*     */     
/*  59 */     this.c = new Group();
/*  60 */     this.c.setTransform(true);
/*  61 */     this.c.setOrigin(630.0F, 380.0F);
/*  62 */     this.c.setSize(1260.0F, 760.0F);
/*  63 */     group.addActor((Actor)this.c);
/*     */     
/*  65 */     this.a.getTable().setVisible(false);
/*  66 */     this.b.getTable().setVisible(false);
/*     */   }
/*     */   
/*     */   public void setHideListener(Runnable paramRunnable) {
/*  70 */     this.d = paramRunnable;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hide() {
/*  75 */     setVisible(false);
/*     */     
/*  77 */     if (this.d != null) {
/*  78 */       this.d.run();
/*  79 */       this.d = null;
/*     */     } 
/*  81 */     this.c.clearChildren();
/*  82 */     Game.i.uiManager.stage.setScrollFocus(null);
/*     */   }
/*     */   
/*     */   public void setConfiguration(WavesConfiguration paramWavesConfiguration) {
/*  86 */     this.c.clearChildren();
/*     */     
/*  88 */     byte b1 = 0;
/*  89 */     for (byte b3 = 0; b3 < paramWavesConfiguration.enemyConfigs.size; b3++) {
/*     */       SpawnTile.AllowedEnemyConfig allowedEnemyConfig;
/*     */       
/*  92 */       if (!EnemyType.isBoss((allowedEnemyConfig = ((SpawnTile.AllowedEnemyConfig[])paramWavesConfiguration.enemyConfigs.items)[b3]).enemyType)) {
/*  93 */         b1++;
/*     */       }
/*     */     } 
/*  96 */     if (b1 == 0) b1 = 1;
/*     */     
/*  98 */     float f = b1 * 50.0F + 132.0F + 30.0F;
/*  99 */     this.c.setOrigin(630.0F, f * 0.5F);
/* 100 */     this.c.setSize(1260.0F, f);
/* 101 */     this.c.setPosition(0.0F, (760.0F - f) * 0.5F);
/*     */     
/* 103 */     QuadActor quadActor = new QuadActor(new Color(791621631), new float[] { 0.0F, 0.0F, 0.0F, f, 1260.0F, f - 12.0F, 1260.0F, 21.0F });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 109 */     this.c.addActor((Actor)quadActor);
/*     */     
/*     */     Label label;
/* 112 */     (label = new Label(Game.i.localeManager.i18n.get("enemies_by_wave_from_all_portals"), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(30), Color.WHITE))).setPosition(40.0F, f - 76.0F);
/* 113 */     label.setSize(300.0F, 28.0F);
/* 114 */     this.c.addActor((Actor)label);
/*     */     
/* 116 */     f = b1 * 50.0F + 33.0F;
/*     */     
/*     */     Group group2;
/* 119 */     (group2 = new Group()).setTransform(false);
/* 120 */     group2.setSize(5096.0F, f);
/*     */     
/*     */     Group group3;
/* 123 */     (group3 = new Group()).setTransform(false);
/* 124 */     group3.setSize(5096.0F, f);
/* 125 */     group2.addActor((Actor)group3);
/*     */     
/* 127 */     this.e = new ScrollPane((Actor)group2);
/* 128 */     UiUtils.enableMouseMoveScrollFocus(this.e);
/* 129 */     this.e.setSize(1260.0F, f);
/* 130 */     this.e.setPosition(0.0F, 30.0F);
/* 131 */     this.e.setScrollingDisabled(false, true);
/* 132 */     this.c.addActor((Actor)this.e);
/*     */     
/*     */     Group group4;
/* 135 */     (group4 = new Group()).setTransform(false);
/* 136 */     group4.setTouchable(Touchable.disabled);
/* 137 */     group4.setSize(5096.0F, 33.0F);
/* 138 */     group4.setPosition(0.0F, f - 33.0F);
/* 139 */     group2.addActor((Actor)group4);
/*     */     
/*     */     Group group5;
/* 142 */     (group5 = new Group()).setTransform(false);
/* 143 */     group5.setSize(5096.0F, f);
/* 144 */     group2.addActor((Actor)group5);
/*     */     
/*     */     Image image;
/* 147 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setPosition(96.0F, 0.0F);
/* 148 */     image.setSize(5000.0F, 33.0F);
/* 149 */     image.setColor(new Color(909522687));
/* 150 */     group4.addActor((Actor)image);
/*     */     
/* 152 */     for (byte b4 = 1; b4 <= 100; b4++) {
/* 153 */       float f1 = ((b4 - 1) * 50) + 96.0F;
/*     */       
/*     */       Label label1;
/* 156 */       (label1 = new Label(String.valueOf(b4 + paramWavesConfiguration.startWave - 1), Game.i.assetManager.getLabelStyle(21))).setPosition(f1, 0.0F);
/* 157 */       label1.setAlignment(1);
/* 158 */       label1.setSize(48.0F, 33.0F);
/* 159 */       label1.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 160 */       group4.addActor((Actor)label1);
/*     */       
/*     */       Image image1;
/* 163 */       (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(2.0F, f);
/* 164 */       image1.setPosition(f1 + 48.0F, -f + 33.0F);
/* 165 */       image1.setColor(new Color(791621631));
/* 166 */       group4.addActor((Actor)image1);
/*     */     } 
/*     */     
/*     */     Group group1;
/* 170 */     (group1 = new Group()).setTransform(false);
/* 171 */     group1.setTouchable(Touchable.disabled);
/* 172 */     group1.setSize(96.0F, f);
/* 173 */     group1.setPosition(0.0F, 30.0F);
/* 174 */     this.c.addActor((Actor)group1);
/*     */ 
/*     */     
/* 177 */     int[] arrayOfInt = new int[EnemyType.values.length]; byte b2; EnemyType[] arrayOfEnemyType;
/* 178 */     for (int i = (arrayOfEnemyType = EnemyType.values).length; b2 < i; ) { EnemyType enemyType = arrayOfEnemyType[b2];
/* 179 */       arrayOfInt[enemyType.ordinal()] = -1;
/*     */       b2++; }
/*     */     
/* 182 */     byte b6 = 0;
/* 183 */     Color color = new Color();
/* 184 */     for (b2 = 0; b2 < paramWavesConfiguration.enemyConfigs.size; b2++) {
/*     */       SpawnTile.AllowedEnemyConfig allowedEnemyConfig;
/*     */       
/* 187 */       if (!EnemyType.isBoss((allowedEnemyConfig = ((SpawnTile.AllowedEnemyConfig[])paramWavesConfiguration.enemyConfigs.items)[b2]).enemyType)) {
/*     */         
/* 189 */         int j = (b1 - 1) * 50 - b6 * 50;
/* 190 */         arrayOfInt[allowedEnemyConfig.enemyType.ordinal()] = j;
/*     */ 
/*     */         
/* 193 */         color.set(Game.i.enemyManager.getFactory(allowedEnemyConfig.enemyType).getColor());
/* 194 */         color.lerp(new Color(673720575), 0.56F);
/*     */         
/*     */         Image image2;
/* 197 */         (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(86.0F, 48.0F);
/* 198 */         image2.setPosition(0.0F, j);
/* 199 */         image2.setColor(color);
/* 200 */         group1.addActor((Actor)image2);
/*     */ 
/*     */ 
/*     */         
/*     */         QuadActor quadActor1;
/*     */ 
/*     */ 
/*     */         
/* 208 */         (quadActor1 = new QuadActor(new float[] { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F, 0.0F, 0.0F }, color)).setPosition(86.0F, j);
/* 209 */         quadActor1.setSize(10.0F, 48.0F);
/* 210 */         group1.addActor((Actor)quadActor1);
/*     */         
/*     */         Image image3;
/* 213 */         (image3 = new Image(Game.i.enemyManager.getFactory(allowedEnemyConfig.enemyType).getTexture())).setPosition(30.0F, j + 7.0F);
/* 214 */         image3.setSize(32.0F, 32.0F);
/* 215 */         group1.addActor((Actor)image3);
/*     */ 
/*     */         
/*     */         Image image4;
/*     */         
/* 220 */         (image4 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(5096.0F, 48.0F);
/* 221 */         image4.setPosition(0.0F, j);
/* 222 */         image4.setColor(new Color(673720575));
/* 223 */         group3.addActor((Actor)image4);
/*     */ 
/*     */         
/* 226 */         float f1 = ((allowedEnemyConfig.firstWave <= 1) ? -96.0F : ((allowedEnemyConfig.firstWave - 1) * 50)) - ((paramWavesConfiguration.startWave - 1) * 50);
/* 227 */         float f2 = (allowedEnemyConfig.lastWave <= 0) ? 5000.0F : (allowedEnemyConfig.lastWave * 50.0F - ((paramWavesConfiguration.startWave - 1) * 50));
/*     */         
/* 229 */         color.a = 0.56F;
/*     */         Image image1;
/* 231 */         (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(f2 - f1, 48.0F);
/* 232 */         image1.setPosition(f1 + 96.0F, j);
/* 233 */         image1.setColor(color);
/* 234 */         group3.addActor((Actor)image1);
/*     */         
/* 236 */         b6++;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 241 */     boolean[] arrayOfBoolean = new boolean[EnemyType.values.length];
/* 242 */     for (byte b5 = 1; b5 < paramWavesConfiguration.enemyGroupsByWave.size; b5++) {
/* 243 */       Array array = ((Array[])paramWavesConfiguration.enemyGroupsByWave.items)[b5]; byte b;
/* 244 */       for (b = 0; b < arrayOfBoolean.length; b++) {
/* 245 */         arrayOfBoolean[b] = false;
/*     */       }
/* 247 */       for (b = 0; b < array.size; b++) {
/* 248 */         EnemyGroup enemyGroup = (EnemyGroup)array.get(b);
/* 249 */         float f1 = 96.0F + (b5 - 1) * 50.0F;
/*     */         
/* 251 */         if (EnemyType.isBoss(enemyGroup.getEnemyType())) {
/*     */           
/* 253 */           Image image1 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"));
/* 254 */           color.set(Game.i.enemyManager.getFactory(enemyGroup.getEnemyType()).getColor());
/* 255 */           color.lerp(new Color(673720575), 0.56F);
/* 256 */           image1.setColor(color);
/* 257 */           image1.setPosition(f1, 0.0F);
/* 258 */           image1.setSize(48.0F, b1 * 50.0F - 2.0F);
/* 259 */           group5.addActor((Actor)image1);
/*     */           
/*     */           Image image2;
/* 262 */           (image2 = new Image(Game.i.enemyManager.getFactory(enemyGroup.getEnemyType()).getTexture())).setPosition(f1 - 8.0F, (b1 * 50.0F - 2.0F) * 0.5F - 32.0F);
/* 263 */           image2.setSize(64.0F, 64.0F);
/* 264 */           group5.addActor((Actor)image2);
/*     */           
/*     */           break;
/*     */         } 
/*     */         
/*     */         int j;
/* 270 */         if ((j = arrayOfInt[enemyGroup.getEnemyType().ordinal()]) >= 0 && !arrayOfBoolean[enemyGroup.getEnemyType().ordinal()]) {
/*     */           String str;
/*     */           
/* 273 */           if (enemyGroup.interval <= 0.25F) {
/* 274 */             str = "icon-density-high";
/* 275 */           } else if (enemyGroup.interval >= 1.0F) {
/* 276 */             str = "icon-density-low";
/*     */           } else {
/* 278 */             str = "icon-density-medium";
/*     */           } 
/*     */           
/*     */           Image image1;
/* 282 */           (image1 = new Image((Drawable)Game.i.assetManager.getDrawable(str))).setPosition(f1, j);
/* 283 */           image1.setSize(48.0F, 48.0F);
/* 284 */           image1.setColor(Game.i.enemyManager.getFactory(enemyGroup.getEnemyType()).getColor());
/* 285 */           group5.addActor((Actor)image1);
/*     */           
/* 287 */           arrayOfBoolean[enemyGroup.getEnemyType().ordinal()] = true;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setVisible(boolean paramBoolean) {
/* 294 */     if (paramBoolean)
/* 295 */     { UiUtils.bouncyShowOverlay((Actor)this.a.getTable(), (Actor)this.b.getTable(), this.c);
/* 296 */       if (this.e != null) { Game.i.uiManager.stage.setScrollFocus((Actor)this.e); return; }
/*     */        }
/* 298 */     else { UiUtils.bouncyHideOverlay((Actor)this.a.getTable(), (Actor)this.b.getTable(), this.c); }
/*     */   
/*     */   }
/*     */   
/*     */   public static class WavesConfiguration { public int startWave;
/*     */     
/*     */     public WavesConfiguration() {
/* 305 */       this.startWave = 1;
/* 306 */       this.enemyConfigs = new Array(SpawnTile.AllowedEnemyConfig.class);
/* 307 */       this.enemyGroupsByWave = new Array(Array.class);
/*     */     }
/*     */     
/*     */     public Array<SpawnTile.AllowedEnemyConfig> enemyConfigs;
/*     */     public Array<Array<EnemyGroup>> enemyGroupsByWave; }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\WavesTimelineOverlay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */