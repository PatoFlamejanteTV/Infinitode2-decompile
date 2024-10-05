/*     */ package com.prineside.tdi2.gameplayMods.mods;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Ability;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Map;
/*     */ import com.prineside.tdi2.SerializableListener;
/*     */ import com.prineside.tdi2.abilities.NukeAbility;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.BonusStageRequirementMet;
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
/*     */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*     */ 
/*     */ @REGS
/*     */ public final class NukeOnBonusStage
/*     */   extends GenericGameplayMod {
/*  35 */   private float a = 1.0F;
/*     */ 
/*     */ 
/*     */   
/*     */   private GameSystemProvider b;
/*     */ 
/*     */ 
/*     */   
/*  43 */   private OnBonusStageRequirementMet c = new OnBonusStageRequirementMet(this);
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  47 */     super.write(paramKryo, paramOutput);
/*  48 */     paramOutput.writeFloat(this.a);
/*  49 */     paramKryo.writeObjectOrNull(paramOutput, this.b, GameSystemProvider.class);
/*  50 */     paramKryo.writeObject(paramOutput, this.c);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  55 */     super.read(paramKryo, paramInput);
/*  56 */     this.a = paramInput.readFloat();
/*  57 */     this.b = (GameSystemProvider)paramKryo.readObjectOrNull(paramInput, GameSystemProvider.class);
/*  58 */     this.c = (OnBonusStageRequirementMet)paramKryo.readObject(paramInput, OnBonusStageRequirementMet.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final GameplayModCategory getCategory() {
/*  63 */     return GameplayModCategory.OFFENSIVE;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Drawable getIcon() {
/*  68 */     return (Drawable)Game.i.assetManager.getQuad("gpMods.NukeOnBonusStage");
/*     */   }
/*     */ 
/*     */   
/*     */   public final CharSequence getDescription() {
/*  73 */     String str = StringFormatter.compactNumberWithPrecisionTrimZeros((this.a * 100.0F), 1, true).toString();
/*  74 */     return Game.i.localeManager.i18n.format("gmod_descr_nuke_on_bonus_stage", new Object[] { str });
/*     */   }
/*     */ 
/*     */   
/*     */   public final GameplayMod cpy() {
/*  79 */     NukeOnBonusStage nukeOnBonusStage = new NukeOnBonusStage();
/*  80 */     a(nukeOnBonusStage);
/*  81 */     nukeOnBonusStage.a = this.a;
/*     */     
/*  83 */     return (GameplayMod)nukeOnBonusStage;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean register(GameSystemProvider paramGameSystemProvider, String paramString) {
/*     */     GameplayModSystem.ActiveMod activeMod;
/*  89 */     if ((activeMod = paramGameSystemProvider.gameplayMod.getActiveModFromSource(NukeOnBonusStage.class, paramString)) == null) {
/*     */       
/*  91 */       this.b = paramGameSystemProvider;
/*  92 */       paramGameSystemProvider.events.getListeners(BonusStageRequirementMet.class).addStateAffecting(this.c).setDescription("NukeOnBonusStage - throws Nuke");
/*  93 */       nuke();
/*  94 */       return true;
/*     */     } 
/*     */     
/*  97 */     activeMod.getMod().setRegisteredPower(this.power);
/*  98 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void nuke() {
/* 103 */     Map map = this.b.map.getMap();
/* 104 */     NukeAbility nukeAbility = (NukeAbility)Game.i.abilityManager.getFactory(AbilityType.NUKE).create();
/* 105 */     int j = (int)((map.getWidth() << 7) * 0.5F);
/* 106 */     int i = (int)((map.getHeight() << 7) * 0.5F); Enemy enemy;
/* 107 */     if (this.b.map.spawnedEnemies.size != 0 && (
/*     */       
/* 109 */       enemy = ((Enemy.EnemyReference)this.b.map.spawnedEnemies.get(this.b.gameState.randomInt(this.b.map.spawnedEnemies.size))).enemy) != null) {
/* 110 */       j = (int)(enemy.getPosition()).x;
/* 111 */       i = (int)(enemy.getPosition()).y;
/*     */     } 
/*     */     
/* 114 */     this.b.ability.registerAndConfigure((Ability)nukeAbility, j, i, this.b.damage.getTowersMaxDps() * this.a);
/* 115 */     nukeAbility.setKilledEnemyNotAffectsBonusSystem(true);
/*     */     
/* 117 */     if ((nukeAbility = (NukeAbility)this.b.ability.startAbility((Ability)nukeAbility)) != null) {
/* 118 */       nukeAbility.startEffects();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final NukeOnBonusStage applyConfig(JsonValue paramJsonValue) {
/* 124 */     super.applyConfig(paramJsonValue);
/* 125 */     this.a = paramJsonValue.getFloat("damageMultiplier", this.a);
/* 126 */     return this;
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class OnBonusStageRequirementMet extends SerializableListener<NukeOnBonusStage> implements Listener<BonusStageRequirementMet> {
/*     */     private OnBonusStageRequirementMet() {}
/*     */     
/*     */     public OnBonusStageRequirementMet(NukeOnBonusStage param1NukeOnBonusStage) {
/* 134 */       this.a = param1NukeOnBonusStage;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void handleEvent(BonusStageRequirementMet param1BonusStageRequirementMet) {
/* 139 */       ((NukeOnBonusStage)this.a).nuke();
/*     */     } }
/*     */   
/*     */   @REGS
/*     */   public static final class BonusProvider implements ProbableBonusesProvider, NoFieldKryoSerializable {
/*     */     private static final BonusProvider a;
/*     */     
/*     */     static {
/* 147 */       SyncChecker.addSyncShareableObject(a = new BonusProvider());
/*     */     }
/*     */     public static BonusProvider getInstance() {
/* 150 */       return a;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void provide(int param1Int, BonusStagesConfig param1BonusStagesConfig, Array<GameplayModSystem.ActiveMod> param1Array, Array<ProbableBonus> param1Array1) {
/* 155 */       JsonValue jsonValue = param1BonusStagesConfig.getBonusConfig("NukeOnBonusStage");
/*     */ 
/*     */ 
/*     */       
/*     */       ProbableBonus probableBonus;
/*     */ 
/*     */ 
/*     */       
/* 163 */       if ((probableBonus = ProbableBonusesProvider.addOrModify((new NukeOnBonusStage()).applyConfig(jsonValue), param1Int, param1Array, (new ProbableBonusesProvider.BonusProviderConfig(0.1F)).applyConfig(jsonValue))) != null)
/* 164 */         param1Array1.add(probableBonus); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\mods\NukeOnBonusStage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */