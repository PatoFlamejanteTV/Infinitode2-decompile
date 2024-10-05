/*     */ package com.prineside.tdi2.waves.processors;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.DamageRecord;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.EnemyGroup;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Wave;
/*     */ import com.prineside.tdi2.WaveProcessor;
/*     */ import com.prineside.tdi2.enemies.bosses.BrootEnemy;
/*     */ import com.prineside.tdi2.enums.BossType;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.EnemySpawn;
/*     */ import com.prineside.tdi2.events.game.GiveDamageToEnemy;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.systems.WaveSystem;
/*     */ import com.prineside.tdi2.ui.components.BossHpBar;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public final class BrootBossWaveProcessor
/*     */   implements KryoSerializable, WaveProcessor, Listener<EnemySpawn> {
/*     */   public static final float NEXT_WAVE_DELAY_MULT = 7.0F;
/*     */   public static final float HEALTH_MULT = 1.75F;
/*     */   public static final float DEFAULT_SPEED = 0.2F;
/*     */   public static final float RAGE_HP_COEFF = 0.25F;
/*     */   public static final float RAGE_HP_RESTORE_MULT = 1.5F;
/*     */   private Wave a;
/*     */   private Enemy.EnemyReference b;
/*     */   private boolean c = false;
/*     */   @NAGS
/*     */   private BossHpBar d;
/*     */   @NAGS
/*     */   private Drawable e;
/*  46 */   private OnGiveDamageToEnemy f = new OnGiveDamageToEnemy(this, (byte)0);
/*     */   
/*     */   private GameSystemProvider g;
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  52 */     paramKryo.writeObjectOrNull(paramOutput, this.a, Wave.class);
/*  53 */     paramKryo.writeObjectOrNull(paramOutput, this.b, Enemy.EnemyReference.class);
/*  54 */     paramOutput.writeBoolean(this.c);
/*  55 */     paramKryo.writeObjectOrNull(paramOutput, this.f, OnGiveDamageToEnemy.class);
/*  56 */     paramKryo.writeObjectOrNull(paramOutput, this.g, GameSystemProvider.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  61 */     this.a = (Wave)paramKryo.readObjectOrNull(paramInput, Wave.class);
/*  62 */     this.b = (Enemy.EnemyReference)paramKryo.readObjectOrNull(paramInput, Enemy.EnemyReference.class);
/*  63 */     this.c = paramInput.readBoolean();
/*  64 */     this.f = (OnGiveDamageToEnemy)paramKryo.readObjectOrNull(paramInput, OnGiveDamageToEnemy.class);
/*  65 */     this.g = (GameSystemProvider)paramKryo.readObjectOrNull(paramInput, GameSystemProvider.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Drawable a() {
/*  71 */     if (this.e == null) {
/*  72 */       this.e = Game.i.assetManager.getDrawable("particle-anger").tint(new Color(-445418497));
/*     */     }
/*  74 */     return this.e;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Array<EnemyGroup> generateEnemyGroups(int paramInt1, int paramInt2) {
/*  79 */     float f2 = Wave.calculateDefaultBossWaveCoinsSum(paramInt1);
/*  80 */     float f3 = Wave.calculateDefaultBossWaveExpSum(paramInt1);
/*  81 */     float f4 = Wave.calculateDefaultBossWaveScoreSum(paramInt1);
/*     */     
/*  83 */     Array<EnemyGroup> array = new Array();
/*  84 */     float f1 = WaveSystem.getWaveValue(paramInt1, paramInt2);
/*  85 */     f1 = 100.0F + (float)StrictMath.pow(f1 * 10.0D, 1.275D) * 2.2F;
/*  86 */     array.add(new EnemyGroup(EnemyType.BROOT_BOSS, 0.2F, f1 * 1.75F, 1, 0.0F, 0.0F, f2, f3, (int)f4));
/*     */     
/*  88 */     return array;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Wave setup(GameSystemProvider paramGameSystemProvider, int paramInt1, int paramInt2) {
/*  93 */     this.g = paramGameSystemProvider;
/*     */     
/*  95 */     this.a = new Wave(paramInt1, paramInt2, generateEnemyGroups(paramInt1, paramInt2));
/*  96 */     this.a.enemiesCanBeSplitBetweenSpawns = false;
/*  97 */     this.a.enemiesCanHaveRandomSideShifts = false;
/*  98 */     this.a.waveMessage = Config.isHeadless() ? null : Game.i.localeManager.i18n.get("enemy_name_BROOT_BOSS");
/*  99 */     this.a.waveProcessor = this;
/*     */     
/* 101 */     paramGameSystemProvider.events.getListeners(EnemySpawn.class).addStateAffecting(this).setDescription("Stores boss reference for the processor");
/* 102 */     paramGameSystemProvider.events.getListeners(GiveDamageToEnemy.class).addStateAffectingWithPriority(this.f, 1000);
/*     */     
/* 104 */     return this.a;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getNextWaveDelayMultiplier() {
/* 109 */     return 7.0F;
/*     */   }
/*     */   
/*     */   private void b() {
/* 113 */     if (this.d == null && this.g._gameUi != null) {
/* 114 */       this
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 121 */         .d = (new BossHpBar()).setBossName(Game.i.localeManager.i18n.get("enemy_name_BROOT_BOSS")).setMainBarColor(new Color(857478399), new Color(-9155841)).setSmallBarsCount(1).setFirstSmallBarColor(new Color(590230527), new Color(1618840575)).setLabelsColor(new Color(-445418497)).addMark(0.25F).setIcon((Drawable)Game.i.assetManager.getDrawable("boss-wave-icon-BROOT"));
/* 122 */       this.g._gameUi.mainUi.addBossHpBar(this.d);
/*     */     } 
/* 124 */     if (this.d != null && 
/* 125 */       this.b != null) {
/* 126 */       BrootEnemy brootEnemy = (BrootEnemy)this.b.enemy;
/* 127 */       this.d.setMainHP(brootEnemy.getHealth(), brootEnemy.maxHealth);
/*     */       
/* 129 */       if (brootEnemy.isInRage()) {
/* 130 */         if (!this.d.isEffectIconExists(a())) {
/* 131 */           this.d.addEffectIcon(a());
/*     */         }
/* 133 */         this.d.setSmallBarOneProgress((1.0F - brootEnemy.getRageDuration() / 15.0F)); return;
/*     */       } 
/* 135 */       this.d.clearEffectIcons().setSmallBarOneProgress(0.0D);
/* 136 */       if (brootEnemy.wasInRage()) {
/* 137 */         this.d.clearMarks();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void draw(Batch paramBatch, float paramFloat) {
/* 147 */     b();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/* 152 */     if (this.c || this.b == null)
/*     */       return; 
/* 154 */     if (this.b.enemy == null) {
/*     */       
/* 156 */       this.c = true;
/* 157 */       c();
/*     */       
/*     */       return;
/*     */     } 
/* 161 */     ((BrootEnemy)this.b.enemy).updateRageState(paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isDone() {
/* 166 */     return this.c;
/*     */   }
/*     */   
/*     */   private void c() {
/* 170 */     this.g.events.getListeners(EnemySpawn.class).remove(this);
/* 171 */     this.g.events.getListeners(GiveDamageToEnemy.class).remove(this.f);
/*     */     
/* 173 */     if (this.d != null) {
/* 174 */       this.g._gameUi.mainUi.removeBossHpBar(this.d);
/* 175 */       this.d = null;
/*     */     } 
/* 177 */     this.g = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void handleEvent(EnemySpawn paramEnemySpawn) {
/* 184 */     if ((paramEnemySpawn.getEnemy()).wave == this.a)
/* 185 */       this.b = this.g.enemy.getReference(paramEnemySpawn.getEnemy()); 
/*     */   }
/*     */   
/*     */   private BrootBossWaveProcessor() {}
/*     */   
/*     */   @REGS
/*     */   public static class OnGiveDamageToEnemy implements KryoSerializable, Listener<GiveDamageToEnemy> {
/*     */     private BrootBossWaveProcessor a;
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output) {
/* 195 */       param1Kryo.writeObjectOrNull(param1Output, this.a, BrootBossWaveProcessor.class);
/*     */     }
/*     */ 
/*     */     
/*     */     public void read(Kryo param1Kryo, Input param1Input) {
/* 200 */       this.a = (BrootBossWaveProcessor)param1Kryo.readObjectOrNull(param1Input, BrootBossWaveProcessor.class);
/*     */     }
/*     */     
/*     */     @Deprecated
/*     */     private OnGiveDamageToEnemy() {}
/*     */     
/*     */     private OnGiveDamageToEnemy(BrootBossWaveProcessor param1BrootBossWaveProcessor) {
/* 207 */       this.a = param1BrootBossWaveProcessor;
/*     */     }
/*     */ 
/*     */     
/*     */     public void handleEvent(GiveDamageToEnemy param1GiveDamageToEnemy) {
/* 212 */       DamageRecord damageRecord = param1GiveDamageToEnemy.getRecord();
/* 213 */       if (BrootBossWaveProcessor.a(this.a) != null && damageRecord.getEnemy() == (BrootBossWaveProcessor.a(this.a)).enemy) {
/*     */         BrootEnemy brootEnemy;
/* 215 */         if ((brootEnemy = (BrootEnemy)damageRecord.getEnemy()).getHealth() / brootEnemy.maxHealth < 0.25F && !brootEnemy.wasInRage())
/*     */         {
/* 217 */           brootEnemy.startRage();
/*     */         }
/*     */         
/* 220 */         if (brootEnemy.isInRage()) {
/*     */           
/* 222 */           param1GiveDamageToEnemy.cancel();
/*     */           float f;
/* 224 */           if ((f = brootEnemy.getHealth() + damageRecord.getDamage() * 1.5F) > brootEnemy.maxHealth) {
/* 225 */             f = brootEnemy.maxHealth;
/*     */           }
/* 227 */           brootEnemy.setHealth(f);
/*     */           
/* 229 */           brootEnemy.healthRestoredWithDamage();
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static class BrootBossWaveProcessorFactory extends WaveProcessor.WaveProcessorFactory<BrootBossWaveProcessor> {
/*     */     public BrootBossWaveProcessorFactory() {
/* 237 */       super(BossType.BROOT);
/*     */     }
/*     */ 
/*     */     
/*     */     public BrootBossWaveProcessor create() {
/* 242 */       return new BrootBossWaveProcessor((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\waves\processors\BrootBossWaveProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */