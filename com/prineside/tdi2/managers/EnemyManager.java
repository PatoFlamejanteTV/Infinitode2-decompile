/*     */ package com.prineside.tdi2.managers;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.utils.ObjectSet;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Manager;
/*     */ import com.prineside.tdi2.enemies.ArmoredEnemy;
/*     */ import com.prineside.tdi2.enemies.BossEnemy;
/*     */ import com.prineside.tdi2.enemies.FastEnemy;
/*     */ import com.prineside.tdi2.enemies.FighterEnemy;
/*     */ import com.prineside.tdi2.enemies.GenericEnemy;
/*     */ import com.prineside.tdi2.enemies.HealerEnemy;
/*     */ import com.prineside.tdi2.enemies.HeliEnemy;
/*     */ import com.prineside.tdi2.enemies.IcyEnemy;
/*     */ import com.prineside.tdi2.enemies.JetEnemy;
/*     */ import com.prineside.tdi2.enemies.LightEnemy;
/*     */ import com.prineside.tdi2.enemies.RegularEnemy;
/*     */ import com.prineside.tdi2.enemies.StrongEnemy;
/*     */ import com.prineside.tdi2.enemies.ToxicEnemy;
/*     */ import com.prineside.tdi2.enemies.bosses.BrootEnemy;
/*     */ import com.prineside.tdi2.enemies.bosses.ConstructorBossEnemy;
/*     */ import com.prineside.tdi2.enemies.bosses.MetaphorBossCreepEnemy;
/*     */ import com.prineside.tdi2.enemies.bosses.MetaphorBossEnemy;
/*     */ import com.prineside.tdi2.enemies.bosses.MobchainBossBodyEnemy;
/*     */ import com.prineside.tdi2.enemies.bosses.MobchainBossCreepEnemy;
/*     */ import com.prineside.tdi2.enemies.bosses.MobchainBossHeadEnemy;
/*     */ import com.prineside.tdi2.enemies.bosses.SnakeBossBodyEnemy;
/*     */ import com.prineside.tdi2.enemies.bosses.SnakeBossHeadEnemy;
/*     */ import com.prineside.tdi2.enemies.bosses.SnakeBossTailEnemy;
/*     */ import com.prineside.tdi2.enums.BossType;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.managers.preferences.categories.ProgressPrefs;
/*     */ import com.prineside.tdi2.managers.preferences.categories.SettingsPrefs;
/*     */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS(serializer = EnemyManager.Serializer.class)
/*     */ public class EnemyManager extends Manager.ManagerAdapter {
/*     */   public static class Serializer extends SingletonSerializer<EnemyManager> {
/*     */     public EnemyManager read() {
/*  44 */       return Game.i.enemyManager;
/*     */     } }
/*     */   
/*  47 */   public final Factories F = new Factories();
/*     */   
/*     */   public static class Factories {
/*     */     public HeliEnemy.HeliEnemyFactory HELI;
/*     */     public ArmoredEnemy.ArmoredEnemyFactory ARMORED;
/*     */     public BossEnemy.BossEnemyFactory BOSS;
/*     */     public FastEnemy.FastEnemyFactory FAST;
/*     */     public FighterEnemy.FighterEnemyFactory FIGHTER;
/*     */     public IcyEnemy.IcyEnemyFactory ICY;
/*     */     public JetEnemy.JetEnemyFactory JET;
/*     */     public LightEnemy.LightEnemyFactory LIGHT;
/*     */     public RegularEnemy.RegularEnemyFactory REGULAR;
/*     */     public StrongEnemy.StrongEnemyFactory STRONG;
/*     */     public ToxicEnemy.ToxicEnemyFactory TOXIC;
/*     */     public HealerEnemy.HealerEnemyFactory HEALER;
/*     */     public GenericEnemy.GenericEnemyFactory GENERIC;
/*     */     public SnakeBossHeadEnemy.SnakeBossHeadEnemyFactory SNAKE_BOSS_HEAD;
/*     */     public SnakeBossBodyEnemy.SnakeBossBodyEnemyFactory SNAKE_BOSS_BODY;
/*     */     public SnakeBossTailEnemy.SnakeBossTailEnemyFactory SNAKE_BOSS_TAIL;
/*     */     public BrootEnemy.BrootEnemyFactory BROOT_BOSS;
/*     */     public ConstructorBossEnemy.ConstructorBossBodyEnemyFactory CONSTRUCTOR_BOSS;
/*     */     public MobchainBossBodyEnemy.MobchainBossBodyEnemyFactory MOBCHAIN_BOSS_BODY;
/*     */     public MobchainBossHeadEnemy.MobchainBossHeadEnemyFactory MOBCHAIN_BOSS_HEAD;
/*     */     public MobchainBossCreepEnemy.MobchainBossCreepEnemyFactory MOBCHAIN_BOSS_CREEP;
/*     */     public MetaphorBossEnemy.MetaphorBossEnemyFactory METAPHOR_BOSS;
/*     */     public MetaphorBossCreepEnemy.MetaphorBossCreepEnemyFactory METAPHOR_BOSS_CREEP;
/*     */   }
/*  74 */   private final Enemy.Factory[] a = new Enemy.Factory[EnemyType.values.length];
/*  75 */   private final TextureRegion[] b = new TextureRegion[2];
/*  76 */   private final TextureRegion[] c = new TextureRegion[DamageType.values.length];
/*     */   
/*     */   public EnemyManager() {
/*  79 */     this.a[EnemyType.HELI.ordinal()] = (Enemy.Factory)(this.F.HELI = new HeliEnemy.HeliEnemyFactory());
/*  80 */     this.a[EnemyType.ARMORED.ordinal()] = (Enemy.Factory)(this.F.ARMORED = new ArmoredEnemy.ArmoredEnemyFactory());
/*  81 */     this.a[EnemyType.BOSS.ordinal()] = (Enemy.Factory)(this.F.BOSS = new BossEnemy.BossEnemyFactory());
/*  82 */     this.a[EnemyType.FAST.ordinal()] = (Enemy.Factory)(this.F.FAST = new FastEnemy.FastEnemyFactory());
/*  83 */     this.a[EnemyType.FIGHTER.ordinal()] = (Enemy.Factory)(this.F.FIGHTER = new FighterEnemy.FighterEnemyFactory());
/*  84 */     this.a[EnemyType.ICY.ordinal()] = (Enemy.Factory)(this.F.ICY = new IcyEnemy.IcyEnemyFactory());
/*  85 */     this.a[EnemyType.JET.ordinal()] = (Enemy.Factory)(this.F.JET = new JetEnemy.JetEnemyFactory());
/*  86 */     this.a[EnemyType.LIGHT.ordinal()] = (Enemy.Factory)(this.F.LIGHT = new LightEnemy.LightEnemyFactory());
/*  87 */     this.a[EnemyType.REGULAR.ordinal()] = (Enemy.Factory)(this.F.REGULAR = new RegularEnemy.RegularEnemyFactory());
/*  88 */     this.a[EnemyType.STRONG.ordinal()] = (Enemy.Factory)(this.F.STRONG = new StrongEnemy.StrongEnemyFactory());
/*  89 */     this.a[EnemyType.TOXIC.ordinal()] = (Enemy.Factory)(this.F.TOXIC = new ToxicEnemy.ToxicEnemyFactory());
/*  90 */     this.a[EnemyType.HEALER.ordinal()] = (Enemy.Factory)(this.F.HEALER = new HealerEnemy.HealerEnemyFactory());
/*  91 */     this.a[EnemyType.GENERIC.ordinal()] = (Enemy.Factory)(this.F.GENERIC = new GenericEnemy.GenericEnemyFactory());
/*     */     
/*  93 */     this.a[EnemyType.SNAKE_BOSS_HEAD.ordinal()] = (Enemy.Factory)(this.F.SNAKE_BOSS_HEAD = new SnakeBossHeadEnemy.SnakeBossHeadEnemyFactory());
/*  94 */     this.a[EnemyType.SNAKE_BOSS_BODY.ordinal()] = (Enemy.Factory)(this.F.SNAKE_BOSS_BODY = new SnakeBossBodyEnemy.SnakeBossBodyEnemyFactory());
/*  95 */     this.a[EnemyType.SNAKE_BOSS_TAIL.ordinal()] = (Enemy.Factory)(this.F.SNAKE_BOSS_TAIL = new SnakeBossTailEnemy.SnakeBossTailEnemyFactory());
/*  96 */     this.a[EnemyType.BROOT_BOSS.ordinal()] = (Enemy.Factory)(this.F.BROOT_BOSS = new BrootEnemy.BrootEnemyFactory());
/*  97 */     this.a[EnemyType.CONSTRUCTOR_BOSS.ordinal()] = (Enemy.Factory)(this.F.CONSTRUCTOR_BOSS = new ConstructorBossEnemy.ConstructorBossBodyEnemyFactory());
/*  98 */     this.a[EnemyType.MOBCHAIN_BOSS_BODY.ordinal()] = (Enemy.Factory)(this.F.MOBCHAIN_BOSS_BODY = new MobchainBossBodyEnemy.MobchainBossBodyEnemyFactory());
/*  99 */     this.a[EnemyType.MOBCHAIN_BOSS_HEAD.ordinal()] = (Enemy.Factory)(this.F.MOBCHAIN_BOSS_HEAD = new MobchainBossHeadEnemy.MobchainBossHeadEnemyFactory());
/* 100 */     this.a[EnemyType.MOBCHAIN_BOSS_CREEP.ordinal()] = (Enemy.Factory)(this.F.MOBCHAIN_BOSS_CREEP = new MobchainBossCreepEnemy.MobchainBossCreepEnemyFactory());
/* 101 */     this.a[EnemyType.METAPHOR_BOSS.ordinal()] = (Enemy.Factory)(this.F.METAPHOR_BOSS = new MetaphorBossEnemy.MetaphorBossEnemyFactory());
/* 102 */     this.a[EnemyType.METAPHOR_BOSS_CREEP.ordinal()] = (Enemy.Factory)(this.F.METAPHOR_BOSS_CREEP = new MetaphorBossCreepEnemy.MetaphorBossCreepEnemyFactory()); EnemyType[] arrayOfEnemyType; int i;
/*     */     byte b;
/* 104 */     for (i = (arrayOfEnemyType = EnemyType.values).length, b = 0; b < i; ) { EnemyType enemyType = arrayOfEnemyType[b];
/* 105 */       if (this.a[enemyType.ordinal()] == null)
/* 106 */         throw new RuntimeException("Not all enemy factories were created"); 
/*     */       b++; }
/*     */   
/*     */   }
/*     */   
/*     */   public EnemyType getBossEnemyType(BossType paramBossType) {
/* 112 */     switch (null.a[paramBossType.ordinal()]) { case 1:
/* 113 */         return EnemyType.BROOT_BOSS;
/* 114 */       case 2: return EnemyType.SNAKE_BOSS_HEAD;
/* 115 */       case 3: return EnemyType.METAPHOR_BOSS;
/* 116 */       case 4: return EnemyType.MOBCHAIN_BOSS_HEAD;
/* 117 */       case 5: return EnemyType.CONSTRUCTOR_BOSS; }
/*     */ 
/*     */     
/* 120 */     throw new IllegalArgumentException("Not implemented for " + paramBossType.name());
/*     */   } public void setup() {
/*     */     Enemy.Factory[] arrayOfFactory;
/*     */     int i;
/*     */     byte b;
/* 125 */     for (i = (arrayOfFactory = this.a).length, b = 0; b < i; b++) {
/* 126 */       Enemy.Factory factory; (factory = arrayOfFactory[b]).setup();
/*     */     } 
/*     */     
/* 129 */     if (Game.i.assetManager != null) {
/*     */       
/* 131 */       this.b[0] = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-ice-overlay-1");
/* 132 */       this.b[1] = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-ice-overlay-2");
/*     */       
/* 134 */       this.c[DamageType.BULLET.ordinal()] = (TextureRegion)Game.i.assetManager.getTextureRegion("icon-bullet");
/* 135 */       this.c[DamageType.ELECTRICITY.ordinal()] = (TextureRegion)Game.i.assetManager.getTextureRegion("icon-lightning-bolt");
/* 136 */       this.c[DamageType.EXPLOSION.ordinal()] = (TextureRegion)Game.i.assetManager.getTextureRegion("icon-explosion-range");
/* 137 */       this.c[DamageType.FIRE.ordinal()] = (TextureRegion)Game.i.assetManager.getTextureRegion("icon-flame");
/* 138 */       this.c[DamageType.LASER.ordinal()] = (TextureRegion)Game.i.assetManager.getTextureRegion("icon-laser");
/* 139 */       this.c[DamageType.POISON.ordinal()] = (TextureRegion)Game.i.assetManager.getTextureRegion("icon-poison");
/*     */     } 
/*     */   }
/*     */   
/*     */   public TextureRegion getIceOverlayTexture(int paramInt) {
/* 144 */     return this.b[paramInt];
/*     */   }
/*     */   
/*     */   public TextureRegion getDamageTypeIcon(DamageType paramDamageType) {
/* 148 */     return this.c[paramDamageType.ordinal()];
/*     */   }
/*     */   
/*     */   public Enemy.Factory<? extends Enemy> getFactory(EnemyType paramEnemyType) {
/* 152 */     return this.a[paramEnemyType.ordinal()];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEnemyTypeNewForPlayer(EnemyType paramEnemyType, boolean paramBoolean) {
/* 160 */     if (Config.isModdingMode()) return false;
/*     */     
/* 162 */     if (paramBoolean && 
/* 163 */       (SettingsPrefs.i()).enemy.enemiesMetWith.contains(paramEnemyType)) {
/* 164 */       return false;
/*     */     }
/*     */     
/* 167 */     return !(ProgressPrefs.i()).enemy.isEnemyMetWith(paramEnemyType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void markEnemyTypeAsNotNewForPlayer(EnemyType paramEnemyType) {
/* 174 */     if (!(ProgressPrefs.i()).enemy.isEnemyMetWith(paramEnemyType)) {
/* 175 */       (ProgressPrefs.i()).enemy.setEnemyMetWith(paramEnemyType, true);
/* 176 */       ProgressPrefs.i().requireSave();
/*     */     } 
/*     */     ObjectSet objectSet;
/* 179 */     if (!(objectSet = (SettingsPrefs.i()).enemy.enemiesMetWith).contains(paramEnemyType)) {
/* 180 */       objectSet.add(paramEnemyType);
/* 181 */       SettingsPrefs.i().requireSave();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void test() {}
/*     */   
/*     */   public void dispose() {}
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\EnemyManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */