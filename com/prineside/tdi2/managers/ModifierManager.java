/*     */ package com.prineside.tdi2.managers;
/*     */ 
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Manager;
/*     */ import com.prineside.tdi2.Modifier;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.ModifierType;
/*     */ import com.prineside.tdi2.modifiers.AttackSpeedModifier;
/*     */ import com.prineside.tdi2.modifiers.BalanceModifier;
/*     */ import com.prineside.tdi2.modifiers.BountyModifier;
/*     */ import com.prineside.tdi2.modifiers.DamageModifier;
/*     */ import com.prineside.tdi2.modifiers.ExperienceModifier;
/*     */ import com.prineside.tdi2.modifiers.MiningSpeedModifier;
/*     */ import com.prineside.tdi2.modifiers.PowerModifier;
/*     */ import com.prineside.tdi2.modifiers.SearchModifier;
/*     */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS(serializer = ModifierManager.Serializer.class)
/*     */ public class ModifierManager extends Manager.ManagerAdapter {
/*     */   public static class Serializer extends SingletonSerializer<ModifierManager> {
/*     */     public ModifierManager read() {
/*  24 */       return Game.i.modifierManager;
/*     */     } }
/*     */   
/*  27 */   private final Modifier.Factory[] a = new Modifier.Factory[ModifierType.values.length];
/*     */   
/*  29 */   private final GameValueType[] b = new GameValueType[ModifierType.values.length];
/*  30 */   private final String[] c = new String[ModifierType.values.length];
/*  31 */   private final String[] d = new String[ModifierType.values.length];
/*  32 */   private final String[] e = new String[ModifierType.values.length];
/*     */   
/*  34 */   public final Factories F = new Factories();
/*     */   
/*     */   public static class Factories {
/*     */     public BalanceModifier.BalanceModifierFactory BALANCE;
/*     */     public PowerModifier.PowerModifierFactory POWER;
/*     */     public SearchModifier.SearchModifierFactory SEARCH;
/*     */     public DamageModifier.DamageModifierFactory DAMAGE;
/*     */     public AttackSpeedModifier.AttackSpeedModifierFactory ATTACK_SPEED;
/*     */     public MiningSpeedModifier.MiningSpeedModifierFactory MINING_SPEED;
/*     */     public ExperienceModifier.ExperienceModifierFactory EXPERIENCE;
/*     */     public BountyModifier.BountyModifierFactory BOUNTY;
/*     */   }
/*     */   
/*  47 */   public ModifierManager() { this.a[ModifierType.BALANCE.ordinal()] = (Modifier.Factory)(this.F.BALANCE = new BalanceModifier.BalanceModifierFactory());
/*  48 */     this.a[ModifierType.POWER.ordinal()] = (Modifier.Factory)(this.F.POWER = new PowerModifier.PowerModifierFactory());
/*  49 */     this.a[ModifierType.SEARCH.ordinal()] = (Modifier.Factory)(this.F.SEARCH = new SearchModifier.SearchModifierFactory());
/*  50 */     this.a[ModifierType.DAMAGE.ordinal()] = (Modifier.Factory)(this.F.DAMAGE = new DamageModifier.DamageModifierFactory());
/*  51 */     this.a[ModifierType.ATTACK_SPEED.ordinal()] = (Modifier.Factory)(this.F.ATTACK_SPEED = new AttackSpeedModifier.AttackSpeedModifierFactory());
/*  52 */     this.a[ModifierType.MINING_SPEED.ordinal()] = (Modifier.Factory)(this.F.MINING_SPEED = new MiningSpeedModifier.MiningSpeedModifierFactory());
/*  53 */     this.a[ModifierType.EXPERIENCE.ordinal()] = (Modifier.Factory)(this.F.EXPERIENCE = new ExperienceModifier.ExperienceModifierFactory());
/*  54 */     this.a[ModifierType.BOUNTY.ordinal()] = (Modifier.Factory)(this.F.BOUNTY = new BountyModifier.BountyModifierFactory()); ModifierType[] arrayOfModifierType; int i;
/*     */     byte b;
/*  56 */     for (i = (arrayOfModifierType = ModifierType.values).length, b = 0; b < i; ) { ModifierType modifierType = arrayOfModifierType[b];
/*  57 */       if (this.a[modifierType.ordinal()] == null) {
/*  58 */         throw new RuntimeException("Not all modifier factories were created");
/*     */       }
/*     */       b++; }
/*     */     
/*  62 */     for (i = (arrayOfModifierType = ModifierType.values).length, b = 0; b < i; ) { ModifierType modifierType = arrayOfModifierType[b];
/*  63 */       this.c[modifierType.ordinal()] = "modifier_name_" + modifierType.name();
/*  64 */       this.d[modifierType.ordinal()] = "modifier_name_fancy_" + modifierType.name();
/*  65 */       this.e[modifierType.ordinal()] = "modifier_description_" + modifierType.name();
/*  66 */       this.b[modifierType.ordinal()] = GameValueType.valueOf("MODIFIER_" + modifierType.name() + "_COUNT");
/*     */       b++; }
/*     */      } public void setup() {
/*     */     ModifierType[] arrayOfModifierType;
/*     */     int i;
/*     */     byte b;
/*  72 */     for (i = (arrayOfModifierType = ModifierType.values).length, b = 0; b < i; ) { ModifierType modifierType = arrayOfModifierType[b];
/*  73 */       getFactory(modifierType).setup();
/*     */       b++; }
/*     */   
/*     */   }
/*     */   public Modifier.Factory<? extends Modifier> getFactory(ModifierType paramModifierType) {
/*  78 */     return this.a[paramModifierType.ordinal()];
/*     */   }
/*     */   
/*     */   public String getTitleAlias(ModifierType paramModifierType) {
/*  82 */     return this.c[paramModifierType.ordinal()];
/*     */   }
/*     */   
/*     */   public String getTitleFancyAlias(ModifierType paramModifierType) {
/*  86 */     return this.d[paramModifierType.ordinal()];
/*     */   }
/*     */   
/*     */   public String getDescriptionAlias(ModifierType paramModifierType) {
/*  90 */     return this.e[paramModifierType.ordinal()];
/*     */   }
/*     */   
/*     */   public GameValueType getCountGameValue(ModifierType paramModifierType) {
/*  94 */     return this.b[paramModifierType.ordinal()];
/*     */   }
/*     */   
/*     */   public Modifier fromJson(JsonValue paramJsonValue) {
/*  98 */     ModifierType modifierType = ModifierType.valueOf(paramJsonValue.getString("type"));
/*     */     
/*     */     Modifier modifier;
/* 101 */     (modifier = getFactory(modifierType).create()).loadFromJson(paramJsonValue);
/*     */     
/* 103 */     return modifier;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\ModifierManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */