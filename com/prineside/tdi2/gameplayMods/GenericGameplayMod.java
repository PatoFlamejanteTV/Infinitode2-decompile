/*     */ package com.prineside.tdi2.gameplayMods;
/*     */ 
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @REGS(classOnly = true)
/*     */ public abstract class GenericGameplayMod implements KryoSerializable, GameplayMod {
/*  15 */   private static final TLog a = TLog.forClass(GenericGameplayMod.class);
/*     */   
/*  17 */   public int maxPower = 1;
/*  18 */   public int power = 1;
/*     */   public boolean multipleInstances = true;
/*  20 */   public IntArray powerLevelsUpgradedByMods = new IntArray();
/*     */   @Null
/*     */   public GameplayMod replacedMod;
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  25 */     paramOutput.writeInt(this.maxPower);
/*  26 */     paramOutput.writeInt(this.power);
/*  27 */     paramOutput.writeBoolean(this.multipleInstances);
/*  28 */     paramKryo.writeObject(paramOutput, this.powerLevelsUpgradedByMods);
/*  29 */     paramKryo.writeClassAndObject(paramOutput, this.replacedMod);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  34 */     this.maxPower = paramInput.readInt();
/*  35 */     this.power = paramInput.readInt();
/*  36 */     this.multipleInstances = paramInput.readBoolean();
/*  37 */     this.powerLevelsUpgradedByMods = (IntArray)paramKryo.readObject(paramInput, IntArray.class);
/*  38 */     this.replacedMod = (GameplayMod)paramKryo.readClassAndObject(paramInput);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getId() {
/*  43 */     return getClass().getSimpleName();
/*     */   }
/*     */   
/*     */   protected void a(GenericGameplayMod paramGenericGameplayMod) {
/*  47 */     paramGenericGameplayMod.maxPower = this.maxPower;
/*  48 */     paramGenericGameplayMod.power = this.power;
/*  49 */     paramGenericGameplayMod.multipleInstances = this.multipleInstances;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setReplacesUnsatisfiedMod(GameplayMod paramGameplayMod) {
/*  54 */     a.i("setReplacesUnsatisfiedMod " + paramGameplayMod + " " + paramGameplayMod.getId(), new Object[0]);
/*  55 */     this.replacedMod = paramGameplayMod;
/*     */   }
/*     */   
/*     */   @Null
/*     */   public GameplayMod getReplacesUnsatisfiedMod() {
/*  60 */     return this.replacedMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public void markPowerLevelUpgradedByOtherMod(int paramInt) {
/*  65 */     if (!this.powerLevelsUpgradedByMods.contains(paramInt)) {
/*  66 */       this.powerLevelsUpgradedByMods.add(paramInt);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPowerLevelUpgradedByOtherMod(int paramInt) {
/*  72 */     return this.powerLevelsUpgradedByMods.contains(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean allowsMultipleInstancesFromDifferentSources() {
/*  77 */     return this.multipleInstances;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPower() {
/*  82 */     return this.power;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMaxPower() {
/*  87 */     return this.maxPower;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRegisteredPower(int paramInt) {
/*  92 */     this.power = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GenericGameplayMod applyConfig(JsonValue paramJsonValue) {
/* 100 */     this.maxPower = paramJsonValue.getInt("maxPower", this.maxPower);
/* 101 */     this.power = paramJsonValue.getInt("power", this.power);
/* 102 */     this.multipleInstances = paramJsonValue.getBoolean("multipleInstances", this.multipleInstances);
/* 103 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\GenericGameplayMod.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */