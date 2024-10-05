/*     */ package com.prineside.tdi2.abilities;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Ability;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameValueProvider;
/*     */ import com.prineside.tdi2.Miner;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.ResourceType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*     */ import com.prineside.tdi2.tiles.PlatformTile;
/*     */ import com.prineside.tdi2.tiles.SourceTile;
/*     */ import com.prineside.tdi2.ui.shared.Notifications;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @REGS
/*     */ public class LoopAbility extends Ability {
/*     */   static {
/*  33 */     TLog.forClass(LoopAbility.class);
/*     */   }
/*     */   
/*  36 */   private static final int[] b = new int[] { 200, 250, 340, 500, 700, 900, 1200, 1500, 1900, 2400, 3000 };
/*     */ 
/*     */   
/*  39 */   private static final int[][] c = new int[][] { { 10, 20, 45, 80, 120, 180, 240, 300, 360, 420, 500 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
/*     */ 
/*     */   
/*     */   private int d;
/*     */ 
/*     */   
/*     */   private int e;
/*     */ 
/*     */   
/*     */   private float f;
/*     */   
/*     */   private float g;
/*     */ 
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  54 */     super.write(paramKryo, paramOutput);
/*  55 */     paramOutput.writeInt(this.d);
/*  56 */     paramOutput.writeInt(this.e);
/*  57 */     paramOutput.writeFloat(this.f);
/*  58 */     paramOutput.writeFloat(this.g);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  63 */     super.read(paramKryo, paramInput);
/*  64 */     this.d = paramInput.readInt();
/*  65 */     this.e = paramInput.readInt();
/*  66 */     this.f = paramInput.readFloat();
/*  67 */     this.g = paramInput.readFloat();
/*     */   }
/*     */ 
/*     */   
/*     */   public void configure(int paramInt1, int paramInt2, double paramDouble) {
/*  72 */     this.f = (float)(paramDouble * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.ABILITY_LOOP_DAMAGE_MULTIPLIER));
/*  73 */     this.g = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.ABILITY_LOOP_RESOURCE_AMOUNT);
/*  74 */     this.d = (int)(paramInt1 * 0.0078125F);
/*  75 */     this.e = (int)(paramInt2 * 0.0078125F);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean start() {
/*  80 */     if (this.f <= 0.0F) {
/*  81 */       if (this.S._gameUi != null) {
/*  82 */         Notifications.i().add(Game.i.localeManager.i18n.get("ability_cant_start_zero_damage"), (Drawable)Game.i.assetManager.getDrawable("icon-ability"), MaterialColor.ORANGE.P800, StaticSoundType.FAIL);
/*     */       }
/*  84 */       return false;
/*     */     } 
/*     */ 
/*     */     
/*  88 */     int[] arrayOfInt = { this.d, this.e, this.d - 1, this.e, this.d + 1, this.e, this.d, this.e + 1, this.d, this.e - 1 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  95 */     Array array = new Array();
/*  96 */     for (byte b = 0; b < 10; b += 2) {
/*  97 */       Tower tower; int i = arrayOfInt[b];
/*  98 */       int j = arrayOfInt[b + 1];
/*     */       Tile tile;
/* 100 */       if (tile = this.S.map.getMap().getTile(i, j) instanceof PlatformTile) {
/*     */         PlatformTile platformTile;
/* 102 */         if ((platformTile = (PlatformTile)tile).building instanceof Tower && 
/*     */           
/* 104 */           !(tower = (Tower)platformTile.building instanceof com.prineside.tdi2.towers.FreezingTower))
/* 105 */           array.add(platformTile); 
/*     */       } else {
/*     */         SourceTile sourceTile;
/* 108 */         if (tower instanceof SourceTile && 
/*     */           
/* 110 */           (sourceTile = (SourceTile)tower).miner != null) {
/* 111 */           array.add(sourceTile);
/*     */         }
/*     */       } 
/*     */     } 
/* 115 */     if (array.size == 0) {
/* 116 */       if (this.S._gameUi != null) {
/* 117 */         Notifications.i().add(Game.i.localeManager.i18n.get("ability_cant_start_affects_nothing"), (Drawable)Game.i.assetManager.getDrawable("icon-ability"), MaterialColor.ORANGE.P800, StaticSoundType.FAIL);
/*     */       }
/* 119 */       return false;
/*     */     } 
/*     */     Array.ArrayIterator<Tile> arrayIterator;
/* 122 */     for (arrayIterator = array.iterator(); arrayIterator.hasNext(); ) {
/* 123 */       Tile tile; if (tile = arrayIterator.next() instanceof PlatformTile) {
/*     */         Tower tower;
/* 125 */         (tower = (Tower)((PlatformTile)tile).building).loopAbilityDamageBuffer = Math.max(tower.loopAbilityDamageBuffer, this.f);
/* 126 */         tower.affectedByLoopAbility = this; continue;
/* 127 */       }  if (tile instanceof SourceTile) {
/* 128 */         Miner miner = ((SourceTile)tile).miner;
/* 129 */         int i = 0;
/* 130 */         for (byte b1 = 0; b1 < miner.minedResources.length; b1++) {
/* 131 */           i += miner.minedResources[b1];
/*     */         }
/* 133 */         miner.loopAbilityResourceBuffer = (int)(i * this.g);
/* 134 */         miner.affectedByLoopAbility = this;
/*     */       } 
/*     */     } 
/*     */     
/* 138 */     if (this.S._particle != null && Game.i.settingsManager.isParticlesDrawing()) {
/* 139 */       for (arrayIterator = array.iterator(); arrayIterator.hasNext(); ) { Tile tile = arrayIterator.next();
/* 140 */         ParticleEffectPool.PooledEffect pooledEffect = (ParticleEffectPool.PooledEffect)Game.i.assetManager.getParticleEffectPool("building-loop.p").obtain();
/* 141 */         this.S._particle.addParticle((ParticleEffect)pooledEffect, false);
/* 142 */         pooledEffect.setPosition(tile.center.x, tile.center.y); }
/*     */     
/*     */     }
/*     */     
/* 146 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void update(float paramFloat) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDone() {
/* 156 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {}
/*     */ 
/*     */   
/*     */   private LoopAbility() {
/* 165 */     super(AbilityType.LOOP);
/*     */   }
/*     */   
/*     */   public static class RepeatAbilityFactory extends Ability.Factory<LoopAbility> {
/*     */     public RepeatAbilityFactory(AbilityType param1AbilityType) {
/* 170 */       super(param1AbilityType);
/*     */     }
/*     */ 
/*     */     
/*     */     public LoopAbility create() {
/* 175 */       return new LoopAbility((byte)0);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void setupAssets() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean requiresMapPointing() {
/* 185 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getColor() {
/* 190 */       return MaterialColor.GREEN.P500;
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence getDescription(GameValueProvider param1GameValueProvider) {
/* 195 */       float f2 = param1GameValueProvider.getFloatValue(GameValueType.ABILITY_LOOP_DAMAGE_MULTIPLIER);
/* 196 */       float f1 = param1GameValueProvider.getFloatValue(GameValueType.ABILITY_LOOP_RESOURCE_AMOUNT);
/*     */       
/* 198 */       return Game.i.localeManager.i18n.format("ability_description_LOOP", new Object[] {
/* 199 */             StringFormatter.compactNumberWithPrecisionTrimZeros(f2, 1, true).toString(), 
/* 200 */             StringFormatter.compactNumberWithPrecisionTrimZeros(f1, 1, true).toString()
/*     */           });
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getDarkerColor() {
/* 206 */       return MaterialColor.GREEN.P700;
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence getTitle() {
/* 211 */       return Game.i.localeManager.i18n.get("ability_name_LOOP");
/*     */     }
/*     */ 
/*     */     
/*     */     public int getPriceInGreenPapers(int param1Int) {
/* 216 */       return LoopAbility.a()[StrictMath.min(param1Int, (LoopAbility.a()).length - 1)];
/*     */     }
/*     */ 
/*     */     
/*     */     public int getPriceInResources(ResourceType param1ResourceType, int param1Int) {
/* 221 */       return LoopAbility.b()[param1ResourceType.ordinal()][StrictMath.min(param1Int, (LoopAbility.b()[0]).length - 1)];
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegionDrawable getIconDrawable() {
/* 226 */       return Game.i.assetManager.getDrawable("icon-loop");
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\abilities\LoopAbility.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */