/*     */ package com.prineside.tdi2.gameplayMods.mods;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.IntIntMap;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Ability;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Map;
/*     */ import com.prineside.tdi2.SerializableListener;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.abilities.ThunderAbility;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.TowerLevelUp;
/*     */ import com.prineside.tdi2.gameplayMods.BonusStagesConfig;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayMod;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayModCategory;
/*     */ import com.prineside.tdi2.gameplayMods.GenericGameplayMod;
/*     */ import com.prineside.tdi2.gameplayMods.ProbableBonus;
/*     */ import com.prineside.tdi2.gameplayMods.ProbableBonusesProvider;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.systems.GameplayModSystem;
/*     */ import com.prineside.tdi2.utils.NoFieldKryoSerializable;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*     */ 
/*     */ @REGS
/*     */ public final class LightningStrikeOnTowerLevelUp extends GenericGameplayMod {
/*  36 */   private static final TLog a = TLog.forClass(LightningStrikeOnTowerLevelUp.class);
/*     */ 
/*     */   
/*  39 */   private float b = 0.5F;
/*  40 */   private float c = 0.5F;
/*  41 */   private int d = 10;
/*  42 */   private float e = 2.0F;
/*  43 */   private float f = 1.0F;
/*     */ 
/*     */ 
/*     */   
/*     */   private GameSystemProvider g;
/*     */ 
/*     */ 
/*     */   
/*  51 */   private OnTowerLevelUp h = new OnTowerLevelUp(this, (byte)0);
/*  52 */   private IntIntMap i = new IntIntMap();
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  56 */     super.write(paramKryo, paramOutput);
/*  57 */     paramOutput.writeFloat(this.b);
/*  58 */     paramOutput.writeFloat(this.c);
/*  59 */     paramOutput.writeInt(this.d);
/*  60 */     paramOutput.writeFloat(this.e);
/*  61 */     paramOutput.writeFloat(this.f);
/*  62 */     paramKryo.writeObjectOrNull(paramOutput, this.g, GameSystemProvider.class);
/*  63 */     paramKryo.writeObject(paramOutput, this.h);
/*  64 */     paramKryo.writeObject(paramOutput, this.i);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  69 */     super.read(paramKryo, paramInput);
/*  70 */     this.b = paramInput.readFloat();
/*  71 */     this.c = paramInput.readFloat();
/*  72 */     this.d = paramInput.readInt();
/*  73 */     this.e = paramInput.readFloat();
/*  74 */     this.f = paramInput.readFloat();
/*  75 */     this.g = (GameSystemProvider)paramKryo.readObjectOrNull(paramInput, GameSystemProvider.class);
/*  76 */     this.h = (OnTowerLevelUp)paramKryo.readObject(paramInput, OnTowerLevelUp.class);
/*  77 */     this.i = (IntIntMap)paramKryo.readObject(paramInput, IntIntMap.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final GameplayModCategory getCategory() {
/*  82 */     return GameplayModCategory.OFFENSIVE;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Drawable getIcon() {
/*  87 */     return (Drawable)Game.i.assetManager.getQuad("gpMods.LightningStrikeOnTowerLevelUp");
/*     */   }
/*     */   
/*     */   public final int getStrikeCount() {
/*  91 */     return MathUtils.floor(this.e + this.f * this.power + 0.01F);
/*     */   }
/*     */   
/*     */   public final float getMdpsMultiplier() {
/*  95 */     return this.b + this.c * this.power;
/*     */   }
/*     */ 
/*     */   
/*     */   public final CharSequence getDescription() {
/* 100 */     String str = StringFormatter.compactNumberWithPrecisionTrimZeros((getMdpsMultiplier() * 100.0F), 1, true).toString();
/* 101 */     return Game.i.localeManager.i18n.format("gmod_descr_lightning_strike_on_tower_level_up", new Object[] { Integer.valueOf(this.d), Integer.valueOf(getStrikeCount()), str });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void resetStrikeLevelLimits() {
/* 109 */     this.i.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public final GameplayMod cpy() {
/* 114 */     LightningStrikeOnTowerLevelUp lightningStrikeOnTowerLevelUp = new LightningStrikeOnTowerLevelUp();
/* 115 */     a(lightningStrikeOnTowerLevelUp);
/* 116 */     lightningStrikeOnTowerLevelUp.b = this.b;
/* 117 */     lightningStrikeOnTowerLevelUp.c = this.c;
/* 118 */     lightningStrikeOnTowerLevelUp.d = this.d;
/* 119 */     lightningStrikeOnTowerLevelUp.e = this.e;
/* 120 */     lightningStrikeOnTowerLevelUp.f = this.f;
/*     */     
/* 122 */     return (GameplayMod)lightningStrikeOnTowerLevelUp;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean register(GameSystemProvider paramGameSystemProvider, String paramString) {
/*     */     GameplayModSystem.ActiveMod activeMod;
/* 128 */     if ((activeMod = paramGameSystemProvider.gameplayMod.getActiveModFromSource(LightningStrikeOnTowerLevelUp.class, paramString)) == null) {
/*     */       
/* 130 */       this.g = paramGameSystemProvider;
/* 131 */       paramGameSystemProvider.events.getListeners(TowerLevelUp.class).addStateAffecting(this.h);
/* 132 */       return true;
/*     */     } 
/*     */     
/* 135 */     activeMod.getMod().setRegisteredPower(this.power);
/* 136 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void strike(int paramInt1, int paramInt2, int paramInt3) {
/* 141 */     if (paramInt3 >= this.d) {
/* 142 */       int i; ThunderAbility thunderAbility; int j = paramInt2 * 65497 + paramInt1;
/* 143 */       int k = this.i.get(j, 0);
/* 144 */       if (paramInt3 > k) {
/* 145 */         this.i.put(j, paramInt3);
/* 146 */         Map map = this.g.map.getMap();
/* 147 */         thunderAbility = (ThunderAbility)Game.i.abilityManager.getFactory(AbilityType.THUNDER).create();
/* 148 */         paramInt3 = (int)((map.getWidth() << 7) * 0.5F);
/* 149 */         i = (int)((map.getHeight() << 7) * 0.5F);
/* 150 */         this.g.ability.registerAndConfigure((Ability)thunderAbility, paramInt3, i, this.g.damage.getTowersMaxDps() * getMdpsMultiplier());
/* 151 */         thunderAbility.targetChargesCount = getStrikeCount();
/*     */         
/* 153 */         if ((thunderAbility = (ThunderAbility)this.g.ability.startAbility((Ability)thunderAbility)) != null)
/* 154 */           thunderAbility.startEffects(); 
/*     */         return;
/*     */       } 
/* 157 */       a.i("skipped strike - observed max tower xp level on " + i + ":" + thunderAbility + " is >= than current (" + k + " >= " + paramInt3 + ")", new Object[0]);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final LightningStrikeOnTowerLevelUp applyConfig(JsonValue paramJsonValue) {
/* 164 */     super.applyConfig(paramJsonValue);
/* 165 */     this.b = paramJsonValue.getFloat("baseDamage", this.b);
/* 166 */     this.c = paramJsonValue.getFloat("damagePerPower", this.c);
/* 167 */     this.d = paramJsonValue.getInt("minXpLevel", this.d);
/* 168 */     this.e = paramJsonValue.getFloat("enemyCount", this.e);
/* 169 */     this.f = paramJsonValue.getFloat("enemyCountPerPower", this.f);
/* 170 */     return this;
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class OnTowerLevelUp extends SerializableListener<LightningStrikeOnTowerLevelUp> implements Listener<TowerLevelUp> {
/*     */     private OnTowerLevelUp() {}
/*     */     
/*     */     private OnTowerLevelUp(LightningStrikeOnTowerLevelUp param1LightningStrikeOnTowerLevelUp) {
/* 178 */       this.a = param1LightningStrikeOnTowerLevelUp;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void handleEvent(TowerLevelUp param1TowerLevelUp) {
/* 183 */       Tower tower = param1TowerLevelUp.getTower();
/* 184 */       ((LightningStrikeOnTowerLevelUp)this.a).strike(tower.getTile().getX(), tower.getTile().getY(), tower.getLevel());
/*     */     } }
/*     */   
/*     */   @REGS
/*     */   public static final class BonusProvider implements ProbableBonusesProvider, NoFieldKryoSerializable {
/*     */     private static final BonusProvider a;
/*     */     
/*     */     static {
/* 192 */       SyncChecker.addSyncShareableObject(a = new BonusProvider());
/*     */     }
/*     */     public static BonusProvider getInstance() {
/* 195 */       return a;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void provide(int param1Int, BonusStagesConfig param1BonusStagesConfig, Array<GameplayModSystem.ActiveMod> param1Array, Array<ProbableBonus> param1Array1) {
/* 200 */       JsonValue jsonValue = param1BonusStagesConfig.getBonusConfig("LightningStrikeOnTowerLevelUp");
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       ProbableBonus probableBonus;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 210 */       if ((probableBonus = ProbableBonusesProvider.addOrModify((new LightningStrikeOnTowerLevelUp()).applyConfig(jsonValue), param1Int, param1Array, (new ProbableBonusesProvider.BonusProviderConfig(0.7F)).setPowerUpProbabilityMultiplier(0.9F).applyConfig(jsonValue))) != null)
/* 211 */         param1Array1.add(probableBonus); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\mods\LightningStrikeOnTowerLevelUp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */