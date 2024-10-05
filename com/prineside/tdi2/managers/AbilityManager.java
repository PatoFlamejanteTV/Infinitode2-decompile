/*     */ package com.prineside.tdi2.managers;
/*     */ 
/*     */ import com.prineside.tdi2.Ability;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Manager;
/*     */ import com.prineside.tdi2.abilities.BallLightningAbility;
/*     */ import com.prineside.tdi2.abilities.BlizzardAbility;
/*     */ import com.prineside.tdi2.abilities.BulletWallAbility;
/*     */ import com.prineside.tdi2.abilities.FireballAbility;
/*     */ import com.prineside.tdi2.abilities.FirestormAbility;
/*     */ import com.prineside.tdi2.abilities.LoicAbility;
/*     */ import com.prineside.tdi2.abilities.LoopAbility;
/*     */ import com.prineside.tdi2.abilities.MagnetAbility;
/*     */ import com.prineside.tdi2.abilities.NukeAbility;
/*     */ import com.prineside.tdi2.abilities.OverloadAbility;
/*     */ import com.prineside.tdi2.abilities.SmokeBombAbility;
/*     */ import com.prineside.tdi2.abilities.ThunderAbility;
/*     */ import com.prineside.tdi2.abilities.WindstormAbility;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.ResourceType;
/*     */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS(serializer = AbilityManager.Serializer.class)
/*     */ public class AbilityManager extends Manager.ManagerAdapter {
/*     */   public static class Serializer extends SingletonSerializer<AbilityManager> {
/*     */     public AbilityManager read() {
/*  29 */       return Game.i.abilityManager;
/*     */     } }
/*     */   
/*  32 */   public final Factories F = new Factories();
/*     */   
/*     */   public static class Factories {
/*     */     public FireballAbility.FireballAbilityFactory FIREBALL;
/*     */     public BlizzardAbility.BlizzardAbilityFactory BLIZZARD;
/*     */     public WindstormAbility.WindstormAbilityFactory WINDSTORM;
/*     */     public ThunderAbility.ThunderAbilityFactory THUNDER;
/*     */     public SmokeBombAbility.SmokeBombAbilityFactory SMOKE_BOMB;
/*     */     public FirestormAbility.FirestormAbilityFactory FIRESTORM;
/*     */     public MagnetAbility.MagnetAbilityFactory MAGNET;
/*     */     public BulletWallAbility.BulletWallAbilityFactory BULLET_WALL;
/*     */     public BallLightningAbility.BallLightningAbilityFactory BALL_LIGHTNING;
/*     */     public LoicAbility.LoicAbilityFactory LOIC;
/*     */     public NukeAbility.NukeAbilityFactory NUKE;
/*     */     public OverloadAbility.OverloadAbilityFactory OVERLOAD;
/*     */     public LoopAbility.RepeatAbilityFactory REPEAT;
/*     */   }
/*  49 */   private final Ability.Factory[] a = new Ability.Factory[AbilityType.values.length];
/*     */   
/*  51 */   private final GameValueType[] b = new GameValueType[AbilityType.values.length];
/*  52 */   private final GameValueType[] c = new GameValueType[AbilityType.values.length]; public AbilityManager() { AbilityType[] arrayOfAbilityType;
/*     */     int i;
/*     */     byte b;
/*  55 */     for (i = (arrayOfAbilityType = AbilityType.values).length, b = 0; b < i; ) { AbilityType abilityType = arrayOfAbilityType[b];
/*  56 */       this.b[abilityType.ordinal()] = GameValueType.valueOf("ABILITY_" + abilityType.name() + "_MAX_PER_GAME");
/*  57 */       this.c[abilityType.ordinal()] = GameValueType.valueOf("ABILITY_" + abilityType.name() + "_ENERGY_COST");
/*     */       b++; }
/*     */     
/*  60 */     this.a[AbilityType.FIREBALL.ordinal()] = (Ability.Factory)(this.F.FIREBALL = new FireballAbility.FireballAbilityFactory(AbilityType.FIREBALL));
/*  61 */     this.a[AbilityType.BLIZZARD.ordinal()] = (Ability.Factory)(this.F.BLIZZARD = new BlizzardAbility.BlizzardAbilityFactory(AbilityType.BLIZZARD));
/*  62 */     this.a[AbilityType.WINDSTORM.ordinal()] = (Ability.Factory)(this.F.WINDSTORM = new WindstormAbility.WindstormAbilityFactory(AbilityType.WINDSTORM));
/*  63 */     this.a[AbilityType.THUNDER.ordinal()] = (Ability.Factory)(this.F.THUNDER = new ThunderAbility.ThunderAbilityFactory(AbilityType.THUNDER));
/*  64 */     this.a[AbilityType.SMOKE_BOMB.ordinal()] = (Ability.Factory)(this.F.SMOKE_BOMB = new SmokeBombAbility.SmokeBombAbilityFactory(AbilityType.SMOKE_BOMB));
/*  65 */     this.a[AbilityType.FIRESTORM.ordinal()] = (Ability.Factory)(this.F.FIRESTORM = new FirestormAbility.FirestormAbilityFactory(AbilityType.FIRESTORM));
/*  66 */     this.a[AbilityType.MAGNET.ordinal()] = (Ability.Factory)(this.F.MAGNET = new MagnetAbility.MagnetAbilityFactory(AbilityType.MAGNET));
/*  67 */     this.a[AbilityType.BULLET_WALL.ordinal()] = (Ability.Factory)(this.F.BULLET_WALL = new BulletWallAbility.BulletWallAbilityFactory(AbilityType.BULLET_WALL));
/*  68 */     this.a[AbilityType.BALL_LIGHTNING.ordinal()] = (Ability.Factory)(this.F.BALL_LIGHTNING = new BallLightningAbility.BallLightningAbilityFactory(AbilityType.BALL_LIGHTNING));
/*  69 */     this.a[AbilityType.LOIC.ordinal()] = (Ability.Factory)(this.F.LOIC = new LoicAbility.LoicAbilityFactory(AbilityType.LOIC));
/*  70 */     this.a[AbilityType.NUKE.ordinal()] = (Ability.Factory)(this.F.NUKE = new NukeAbility.NukeAbilityFactory(AbilityType.NUKE));
/*  71 */     this.a[AbilityType.OVERLOAD.ordinal()] = (Ability.Factory)(this.F.OVERLOAD = new OverloadAbility.OverloadAbilityFactory(AbilityType.OVERLOAD));
/*  72 */     this.a[AbilityType.LOOP.ordinal()] = (Ability.Factory)(this.F.REPEAT = new LoopAbility.RepeatAbilityFactory(AbilityType.LOOP));
/*     */     
/*  74 */     for (i = (arrayOfAbilityType = AbilityType.values).length, b = 0; b < i; ) { AbilityType abilityType = arrayOfAbilityType[b];
/*  75 */       if (this.a[abilityType.ordinal()] == null)
/*  76 */         throw new RuntimeException("Not all ability factories were created"); 
/*     */       b++; }
/*     */      }
/*     */    public void setup() {
/*     */     Ability.Factory[] arrayOfFactory;
/*     */     int i;
/*     */     byte b;
/*  83 */     for (i = (arrayOfFactory = this.a).length, b = 0; b < i; b++) {
/*  84 */       Ability.Factory factory; (factory = arrayOfFactory[b]).setup();
/*     */     } 
/*     */   } public void test() {
/*     */     AbilityType[] arrayOfAbilityType;
/*     */     int i;
/*     */     byte b;
/*  90 */     for (i = (arrayOfAbilityType = AbilityType.values).length, b = 0; b < i; ) { AbilityType abilityType = arrayOfAbilityType[b];
/*     */       Ability.Factory<? extends Ability> factory;
/*  92 */       if ((factory = getFactory(abilityType)).abilityType != abilityType) {
/*  93 */         throw new IllegalStateException(abilityType.name() + " factory.abilityType wrong ability type: " + String.valueOf(factory.abilityType));
/*     */       }
/*  95 */       if (factory.create() == null) {
/*  96 */         throw new IllegalStateException(abilityType.name() + " factory.create() is null");
/*     */       }
/*  98 */       if (factory.getColor() == null) {
/*  99 */         throw new IllegalStateException(abilityType.name() + " factory.getColor() is null");
/*     */       }
/* 101 */       if (factory.getDarkerColor() == null) {
/* 102 */         throw new IllegalStateException(abilityType.name() + " factory.getDarkerColor() is null");
/*     */       }
/* 104 */       if (factory.getTitle() == null || factory.getTitle().length() == 0) {
/* 105 */         throw new IllegalStateException(abilityType.name() + " factory.getTitle() is null or empty");
/*     */       }
/* 107 */       if (factory.getDescription(Game.i.gameValueManager.getSnapshot()) == null || factory.getDescription(Game.i.gameValueManager.getSnapshot()).length() == 0) {
/* 108 */         throw new IllegalStateException(abilityType.name() + " factory.getDescription() is null or empty");
/*     */       }
/* 110 */       if (factory.getIconDrawable() == null) {
/* 111 */         throw new IllegalStateException(abilityType.name() + " factory.getIconDrawable() is null");
/*     */       }
/* 113 */       for (byte b1 = 0; b1 < 20; b1++) {
/* 114 */         factory.getPriceInGreenPapers(b1); ResourceType[] arrayOfResourceType; int j; byte b2;
/* 115 */         for (j = (arrayOfResourceType = ResourceType.values).length, b2 = 0; b2 < j; ) { ResourceType resourceType = arrayOfResourceType[b2];
/* 116 */           factory.getPriceInResources(resourceType, b1);
/*     */           b2++; }
/*     */       
/*     */       } 
/*     */       b++; }
/*     */   
/*     */   } public boolean isAnyAbilityOpened() {
/*     */     AbilityType[] arrayOfAbilityType;
/*     */     int i;
/*     */     byte b;
/* 126 */     for (i = (arrayOfAbilityType = AbilityType.values).length, b = 0; b < i; ) { AbilityType abilityType = arrayOfAbilityType[b];
/* 127 */       if (Game.i.gameValueManager.getSnapshot().getIntValue(getMaxPerGameGameValueType(abilityType)) != 0) return true; 
/*     */       b++; }
/*     */     
/* 130 */     return false;
/*     */   }
/*     */   
/*     */   public Ability.Factory<? extends Ability> getFactory(AbilityType paramAbilityType) {
/* 134 */     return this.a[paramAbilityType.ordinal()];
/*     */   }
/*     */   
/*     */   public GameValueType getMaxPerGameGameValueType(AbilityType paramAbilityType) {
/* 138 */     return this.b[paramAbilityType.ordinal()];
/*     */   }
/*     */   
/*     */   public GameValueType getEnergyCostGameValueType(AbilityType paramAbilityType) {
/* 142 */     return this.c[paramAbilityType.ordinal()];
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\AbilityManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */