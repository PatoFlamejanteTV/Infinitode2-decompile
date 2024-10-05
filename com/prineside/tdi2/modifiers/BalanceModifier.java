/*     */ package com.prineside.tdi2.modifiers;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Modifier;
/*     */ import com.prineside.tdi2.ResourcePack;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.enums.BuildingType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.ModifierType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.systems.MapRenderingSystem;
/*     */ import com.prineside.tdi2.tiles.PlatformTile;
/*     */ import com.prineside.tdi2.ui.actors.ComplexButton;
/*     */ import com.prineside.tdi2.ui.actors.ExpLine;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.util.Comparator;
/*     */ 
/*     */ @REGS
/*     */ public final class BalanceModifier extends Modifier {
/*  44 */   private static final TLog a = TLog.forClass(BalanceModifier.class);
/*     */ 
/*     */   
/*     */   public static final int MAX_LEVEL = 5;
/*     */   
/*  49 */   public static int[] XP_FOR_LEVEL = new int[] { 0, 100, 300, 1000, 2500 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  57 */   public static float[] SPEED_BY_LEVEL = new float[] { 3.0F, 7.0F, 15.0F, 35.0F, 100.0F };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @REGS
/*     */   public enum Mode
/*     */   {
/*  67 */     BALANCE,
/*  68 */     EVOLVE;
/*     */     
/*  70 */     public static final Mode[] values = values();
/*     */     static {
/*     */     
/*  73 */     } } public Mode mode = Mode.BALANCE;
/*  74 */   private int b = 1;
/*     */   
/*     */   private float c;
/*     */   private float d;
/*  78 */   private static final StringBuilder e = new StringBuilder();
/*     */   @NAGS
/*  80 */   private final Array<NeighbourXpConfig> f = new Array(true, 8, NeighbourXpConfig.class); private static final Comparator<NeighbourXpConfig> g;
/*     */   
/*     */   static {
/*  83 */     g = ((paramNeighbourXpConfig1, paramNeighbourXpConfig2) -> Float.compare(NeighbourXpConfig.c(paramNeighbourXpConfig2), NeighbourXpConfig.c(paramNeighbourXpConfig1)));
/*     */   }
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  87 */     super.write(paramKryo, paramOutput);
/*  88 */     paramKryo.writeObject(paramOutput, this.mode);
/*  89 */     paramOutput.writeVarInt(this.b, true);
/*  90 */     paramOutput.writeFloat(this.c);
/*  91 */     paramOutput.writeFloat(this.d);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  96 */     super.read(paramKryo, paramInput);
/*  97 */     this.mode = (Mode)paramKryo.readObject(paramInput, Mode.class);
/*  98 */     this.b = paramInput.readVarInt(true);
/*  99 */     this.c = paramInput.readFloat();
/* 100 */     this.d = paramInput.readFloat();
/*     */   }
/*     */   
/*     */   private BalanceModifier() {
/* 104 */     super(ModifierType.BALANCE);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean connectsToMiners() {
/* 109 */     return false;
/*     */   }
/*     */   
/*     */   public final int getLevel() {
/* 113 */     return this.b;
/*     */   }
/*     */   
/*     */   public final void setLevel(int paramInt) {
/* 117 */     if (paramInt > 5 || paramInt <= 0) {
/* 118 */       throw new IllegalArgumentException("level invalid " + paramInt);
/*     */     }
/*     */     
/* 121 */     this.b = paramInt;
/* 122 */     this.S.map.markTilesDirtyNearTile((Tile)getTile(), 1);
/*     */   }
/*     */   
/*     */   public final int getXpEvolveRequirement() {
/* 126 */     return (int)(XP_FOR_LEVEL[this.b] * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.MODIFIER_BALANCE_UPGRADE_PRICE));
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean hasCustomButton() {
/* 131 */     return (this.mode == Mode.BALANCE && this.b < 5);
/*     */   }
/*     */   
/*     */   public final boolean isCustomButtonNeedMapPoint() {
/* 135 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void fillModifierMenu(Group paramGroup, ObjectMap<String, Object> paramObjectMap) {
/*     */     String str;
/* 141 */     int i = Game.i.settingsManager.getScaledViewportHeight() - 1080;
/*     */     
/* 143 */     if (paramObjectMap.size == 0 || !paramObjectMap.get("state", Integer.valueOf(-1)).equals(Integer.valueOf(1))) {
/* 144 */       a.i("recreate custom menu", new Object[0]);
/* 145 */       paramGroup.clear();
/*     */       
/*     */       Group group;
/* 148 */       (group = new Group()).setTransform(false);
/* 149 */       group.setPosition(40.0F, 606.0F + i);
/* 150 */       group.setSize(520.0F, 66.0F);
/* 151 */       paramGroup.addActor((Actor)group);
/*     */       
/*     */       Label label7;
/*     */       
/* 155 */       (label7 = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(36), Color.WHITE))).setSize(40.0F, 26.0F);
/* 156 */       label7.setPosition(480.0F, 40.0F);
/* 157 */       label7.setAlignment(16);
/* 158 */       group.addActor((Actor)label7);
/*     */       
/*     */       Label label8;
/*     */       
/* 162 */       (label8 = new Label("", Game.i.assetManager.getLabelStyle(24))).setPosition(0.0F, 0.0F);
/* 163 */       label8.setSize(520.0F, 24.0F);
/* 164 */       label8.setAlignment(16);
/* 165 */       group.addActor((Actor)label8);
/*     */       
/*     */       Label label9;
/*     */       
/* 169 */       (label9 = new Label("", Game.i.assetManager.getLabelStyle(30))).setPosition(0.0F, 40.0F);
/* 170 */       label9.setSize(520.0F, 26.0F);
/* 171 */       label9.setAlignment(8);
/* 172 */       group.addActor((Actor)label9);
/*     */       
/*     */       ExpLine expLine1;
/*     */       
/* 176 */       (expLine1 = new ExpLine()).setPosition(0.0F, 0.0F);
/* 177 */       expLine1.setColor(MaterialColor.LIME.P500);
/* 178 */       group.addActor((Actor)expLine1);
/*     */       
/*     */       Image image;
/*     */       
/* 182 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(0.0F, 0.0F, 0.0F, 0.14F);
/* 183 */       image.setPosition(0.0F, 478.0F + i);
/* 184 */       image.setSize(600.0F, 96.0F);
/* 185 */       paramGroup.addActor((Actor)image);
/*     */       
/*     */       Label label6;
/*     */       
/* 189 */       (label6 = new Label("", Game.i.assetManager.getLabelStyle(36))).setPosition(0.0F, 527.0F + i);
/* 190 */       label6.setSize(600.0F, 28.0F);
/* 191 */       label6.setAlignment(1);
/* 192 */       label6.setColor(MaterialColor.LIME.P500);
/* 193 */       paramGroup.addActor((Actor)label6);
/*     */       
/*     */       Label label10;
/*     */       
/* 197 */       (label10 = new Label("", Game.i.assetManager.getLabelStyle(24))).setPosition(0.0F, 498.0F + i);
/* 198 */       label10.setSize(600.0F, 17.0F);
/* 199 */       label10.setAlignment(1);
/* 200 */       label10.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 201 */       paramGroup.addActor((Actor)label10);
/*     */       
/* 203 */       paramObjectMap.put("statusLabel", label9);
/* 204 */       paramObjectMap.put("levelLabel", label7);
/* 205 */       paramObjectMap.put("speedLabel", label6);
/* 206 */       paramObjectMap.put("upgradeSpeedLabel", label10);
/* 207 */       paramObjectMap.put("xpLabel", label8);
/* 208 */       paramObjectMap.put("xpLine", expLine1);
/* 209 */       paramObjectMap.put("state", Integer.valueOf(1));
/*     */     } 
/*     */     
/* 212 */     ExpLine expLine = (ExpLine)paramObjectMap.get("xpLine");
/* 213 */     Label label1 = (Label)paramObjectMap.get("xpLabel");
/* 214 */     Label label2 = (Label)paramObjectMap.get("levelLabel");
/* 215 */     Label label3 = (Label)paramObjectMap.get("statusLabel");
/* 216 */     Label label4 = (Label)paramObjectMap.get("speedLabel");
/* 217 */     Label label5 = (Label)paramObjectMap.get("upgradeSpeedLabel");
/*     */     
/* 219 */     label2.setText("L" + this.b);
/* 220 */     if (this.b >= 5) {
/* 221 */       expLine.setCoeff(1.0F);
/* 222 */       label1.setText("MAX");
/*     */     } else {
/* 224 */       expLine.setCoeff(this.c / getXpEvolveRequirement());
/* 225 */       label1.setText((int)this.c + " / " + getXpEvolveRequirement());
/*     */     } 
/*     */ 
/*     */     
/* 229 */     if (this.mode == Mode.EVOLVE) {
/* 230 */       str = Game.i.localeManager.i18n.get("state_upgrading");
/* 231 */       label3.setColor(MaterialColor.LIGHT_BLUE.P500);
/*     */     } else {
/* 233 */       str = Game.i.localeManager.i18n.get("state_balancing");
/* 234 */       label3.setColor(MaterialColor.LIME.P500);
/*     */     } 
/* 236 */     label3.setText(str);
/*     */     
/* 238 */     e.setLength(0);
/* 239 */     e.append(StringFormatter.compactNumberWithPrecisionTrimZeros(getSpeed(), 1, true));
/* 240 */     e.append(" xp/").append(Game.i.localeManager.i18n.get("TIME_CHAR_SECOND"));
/* 241 */     label4.setText((CharSequence)e);
/*     */     
/* 243 */     if (this.b >= 5) {
/* 244 */       label4.setPosition(0.0F, 512.0F + i);
/*     */       
/* 246 */       label5.setVisible(false); return;
/*     */     } 
/* 248 */     label4.setPosition(0.0F, 527.0F + i);
/*     */     
/* 250 */     e.setLength(0);
/* 251 */     e.append("L").append(this.b + 1).append(": ");
/* 252 */     e.append(StringFormatter.compactNumberWithPrecisionTrimZeros(SPEED_BY_LEVEL[this.b], 1, true));
/* 253 */     e.append(" xp/").append(Game.i.localeManager.i18n.get("TIME_CHAR_SECOND"));
/* 254 */     label5.setText((CharSequence)e);
/* 255 */     label5.setVisible(true);
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void customButtonAction(int paramInt1, int paramInt2) {
/* 273 */     if (this.b < 5) {
/* 274 */       this.mode = Mode.EVOLVE;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final void updateCustomButton(ComplexButton paramComplexButton, boolean paramBoolean) {
/* 280 */     String str = Game.i.localeManager.i18n.get("do_upgrade");
/* 281 */     paramComplexButton.setText(str);
/* 282 */     paramComplexButton.setIcon((Drawable)Game.i.assetManager.getDrawable("icon-double-arrow-up"));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float getSpeed() {
/* 289 */     return SPEED_BY_LEVEL[this.b - 1];
/*     */   }
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/* 294 */     super.update(paramFloat);
/*     */     
/* 296 */     this.d += paramFloat;
/*     */     
/* 298 */     if (this.d > 0.265F) {
/* 299 */       paramFloat = this.d;
/* 300 */       this.d = 0.0F;
/* 301 */       this.f.clear();
/*     */ 
/*     */       
/* 304 */       this.S.map.traverseNeighborTilesAroundTile((Tile)getTile(), paramTile -> {
/*     */             PlatformTile platformTile;
/*     */             
/*     */             if (paramTile.type == TileType.PLATFORM && (platformTile = (PlatformTile)paramTile).building != null && platformTile.building.buildingType == BuildingType.TOWER) {
/*     */               Tower tower = (Tower)platformTile.building;
/*     */               
/*     */               NeighbourXpConfig neighbourXpConfig;
/*     */               
/*     */               NeighbourXpConfig.a(neighbourXpConfig = new NeighbourXpConfig(), tower);
/*     */               
/*     */               NeighbourXpConfig.d(neighbourXpConfig, tower.experience);
/*     */               
/*     */               float f = Tower.LEVEL_EXPERIENCE_MILESTONES[tower.getLevel()];
/*     */               NeighbourXpConfig.e(neighbourXpConfig, tower.experience - f);
/*     */               this.f.add(neighbourXpConfig);
/*     */             } 
/*     */             return true;
/*     */           });
/* 322 */       if (this.f.size != 0) {
/* 323 */         this.S.TSH.sort.sort(this.f, g);
/*     */         
/* 325 */         if (this.mode == Mode.EVOLVE) {
/*     */           
/* 327 */           paramFloat = getSpeed() * paramFloat;
/* 328 */           float f = getXpEvolveRequirement() - this.c;
/* 329 */           if (paramFloat > f) {
/* 330 */             paramFloat = f;
/*     */           }
/*     */           
/* 333 */           if (paramFloat > 0.0F) {
/* 334 */             for (byte b = 0; b < this.f.size; b++) {
/* 335 */               NeighbourXpConfig neighbourXpConfig = ((NeighbourXpConfig[])this.f.items)[b];
/*     */               float f1;
/* 337 */               if ((f1 = StrictMath.min(paramFloat, NeighbourXpConfig.a(neighbourXpConfig))) > 0.0F) {
/* 338 */                 float f2 = this.S.experience.removeExperienceRaw(NeighbourXpConfig.b(neighbourXpConfig), f1);
/* 339 */                 this.c += f2;
/* 340 */                 paramFloat -= f2;
/*     */                 
/* 342 */                 if (this.S._particle != null && Game.i.settingsManager.isParticlesDrawing() && !this.S.gameState.canSkipMediaUpdate()) {
/* 343 */                   this.S._particle.addXpOrbParticle(f2, 
/*     */                       
/* 345 */                       NeighbourXpConfig.b(neighbourXpConfig).getTile().getX(), 
/* 346 */                       NeighbourXpConfig.b(neighbourXpConfig).getTile().getY(), 
/* 347 */                       getTile().getX(), 
/* 348 */                       getTile().getY());
/*     */                 }
/*     */ 
/*     */                 
/* 352 */                 if (paramFloat > 0.0F) {
/*     */                   continue;
/*     */                 }
/*     */                 break;
/*     */               } 
/*     */               continue;
/*     */             } 
/*     */           }
/* 360 */           if (this.b >= 5) {
/* 361 */             this.mode = Mode.BALANCE;
/*     */           }
/* 363 */           else if (this.c >= getXpEvolveRequirement()) {
/*     */             
/* 365 */             setLevel(this.b + 1);
/* 366 */             this.c = 0.0F;
/* 367 */             this.mode = Mode.BALANCE;
/*     */             
/* 369 */             if (this.S._sound != null) this.S._sound.playStatic(StaticSoundType.UPGRADE);
/*     */ 
/*     */             
/* 372 */             if (this.S._particle != null && Game.i.settingsManager.isParticlesDrawing()) {
/*     */               ParticleEffectPool.PooledEffect pooledEffect;
/* 374 */               (pooledEffect = (ParticleEffectPool.PooledEffect)Game.i.towerManager.upgradeParticles.obtain()).setPosition((getTile()).center.x, (getTile()).center.y);
/* 375 */               this.S._particle.addParticle((ParticleEffect)pooledEffect, true);
/*     */             } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 383 */             if (this.S._gameUi != null) {
/* 384 */               this.S._gameUi.modifierMenu.updateCustomButton();
/*     */             }
/*     */           }
/*     */         
/* 388 */         } else if (this.mode == Mode.BALANCE) {
/*     */           
/* 390 */           if (this.f.size > 1) {
/* 391 */             paramFloat = getSpeed() * paramFloat;
/*     */             
/* 393 */             for (byte b = 0; b < this.f.size; b++) {
/*     */               NeighbourXpConfig neighbourXpConfig;
/*     */ 
/*     */               
/* 397 */               if (NeighbourXpConfig.a(neighbourXpConfig = ((NeighbourXpConfig[])this.f.items)[b]) >= 1.0F)
/*     */               {
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/* 403 */                 for (int i = this.f.size - 1; i > b; i--) {
/*     */                   
/* 405 */                   NeighbourXpConfig neighbourXpConfig1 = ((NeighbourXpConfig[])this.f.items)[i];
/*     */                   float f;
/* 407 */                   if ((f = (NeighbourXpConfig.c(neighbourXpConfig) - NeighbourXpConfig.c(neighbourXpConfig1)) * 0.5F) >= 1.0F)
/*     */                   {
/*     */                     
/* 410 */                     if ((f = StrictMath.min(paramFloat, StrictMath.min(NeighbourXpConfig.a(neighbourXpConfig), f))) != 0.0F) {
/*     */                       
/* 412 */                       f = this.S.experience.removeExperienceRaw(NeighbourXpConfig.b(neighbourXpConfig), f);
/* 413 */                       this.S.experience.addExperienceRaw(NeighbourXpConfig.b(neighbourXpConfig1), f);
/*     */ 
/*     */                       
/* 416 */                       paramFloat -= f;
/* 417 */                       NeighbourXpConfig.a(neighbourXpConfig, f);
/* 418 */                       NeighbourXpConfig.b(neighbourXpConfig, f);
/* 419 */                       NeighbourXpConfig.c(neighbourXpConfig1, f);
/*     */ 
/*     */                       
/* 422 */                       if (this.S._particle != null && Game.i.settingsManager.isParticlesDrawing() && !this.S.gameState.canSkipMediaUpdate()) {
/* 423 */                         this.S._particle.addXpOrbParticle(f, 
/*     */                             
/* 425 */                             NeighbourXpConfig.b(neighbourXpConfig).getTile().getX(), 
/* 426 */                             NeighbourXpConfig.b(neighbourXpConfig).getTile().getY(), 
/* 427 */                             NeighbourXpConfig.b(neighbourXpConfig1).getTile().getX(), 
/* 428 */                             NeighbourXpConfig.b(neighbourXpConfig1).getTile().getY());
/*     */                       }
/*     */ 
/*     */                       
/* 432 */                       if (paramFloat != 0.0F) {
/*     */                         continue;
/*     */                       }
/*     */                       
/*     */                       // Byte code: goto -> 791
/*     */                     } 
/*     */                   }
/*     */                   
/*     */                   continue;
/*     */                 } 
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/* 446 */         this.f.clear();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawBatch(Batch paramBatch, float paramFloat, MapRenderingSystem.DrawMode paramDrawMode) {
/* 453 */     super.drawBatch(paramBatch, paramFloat, paramDrawMode);
/*     */     
/* 455 */     if (paramDrawMode == MapRenderingSystem.DrawMode.DETAILED) {
/*     */       
/* 457 */       ResourcePack.ResourcePackBitmapFont resourcePackBitmapFont = Game.i.assetManager.getFont(36);
/* 458 */       e.setLength(0);
/* 459 */       e.append(this.b);
/*     */       
/* 461 */       float f1 = (getTile().getX() << 7);
/* 462 */       float f2 = (getTile().getY() << 7);
/*     */       
/* 464 */       resourcePackBitmapFont.setColor(0.0F, 0.0F, 0.0F, 0.56F);
/* 465 */       resourcePackBitmapFont.draw(paramBatch, (CharSequence)e, f1 + 3.0F, f2 + 74.0F - 3.0F, 128.0F, 1, false);
/* 466 */       resourcePackBitmapFont.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/* 467 */       resourcePackBitmapFont.draw(paramBatch, (CharSequence)e, f1, f2 + 74.0F, 128.0F, 1, false);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 474 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_DRAW_BUILDING_INFO) != 0.0D) {
/*     */       ResourcePack.ResourcePackBitmapFont resourcePackBitmapFont;
/* 476 */       (resourcePackBitmapFont = Game.i.assetManager.getFont(21)).draw(paramBatch, "B:" + ((int)(this.c * 10.0F) / 10.0F) + "xp", (getTile()).center.x - 32.0F, (getTile()).center.y - 64.0F + 40.0F);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static class BalanceModifierFactory extends Modifier.Factory<BalanceModifier> {
/*     */     private TextureRegion c;
/*     */     public TextureRegion orbTexture;
/*     */     
/*     */     public BalanceModifierFactory() {
/* 485 */       super(ModifierType.BALANCE, MaterialColor.LIME.P500, "icon-experience-balance");
/*     */     }
/*     */ 
/*     */     
/*     */     public int getBuildPrice(GameSystemProvider param1GameSystemProvider, int param1Int) {
/* 490 */       return a((int)(25.0F * (float)StrictMath.pow(1.399999976158142D, param1Int)));
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getBaseTexture() {
/* 495 */       return this.c;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 500 */       this.c = (TextureRegion)Game.i.assetManager.getTextureRegion("modifier-base-balance");
/* 501 */       this.orbTexture = (TextureRegion)Game.i.assetManager.getTextureRegion("xp-orb");
/*     */     }
/*     */ 
/*     */     
/*     */     public BalanceModifier create() {
/* 506 */       return new BalanceModifier((byte)0);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class NeighbourXpConfig
/*     */     implements Pool.Poolable
/*     */   {
/*     */     private Tower a;
/*     */     private float b;
/*     */     private float c;
/*     */     
/*     */     public void reset() {
/* 519 */       this.a = null;
/* 520 */       this.b = 0.0F;
/* 521 */       this.c = 0.0F;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\modifiers\BalanceModifier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */