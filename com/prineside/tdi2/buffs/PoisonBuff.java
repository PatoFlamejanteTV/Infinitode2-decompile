/*    */ package com.prineside.tdi2.buffs;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.prineside.tdi2.Ability;
/*    */ import com.prineside.tdi2.Buff;
/*    */ import com.prineside.tdi2.BuffProcessor;
/*    */ import com.prineside.tdi2.Tower;
/*    */ import com.prineside.tdi2.buffs.processors.PoisonBuffProcessor;
/*    */ import com.prineside.tdi2.enums.BuffType;
/*    */ import com.prineside.tdi2.managers.AssetManager;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public final class PoisonBuff extends Buff {
/*    */   public Tower tower;
/*    */   public float hitDamage;
/*    */   public float poisonDamage;
/* 21 */   public int fastShellsStackCount = 1;
/*    */   
/*    */   public Ability fromAbility;
/*    */   
/*    */   public final void write(Kryo paramKryo, Output paramOutput) {
/* 26 */     super.write(paramKryo, paramOutput);
/* 27 */     paramKryo.writeClassAndObject(paramOutput, this.tower);
/* 28 */     paramOutput.writeFloat(this.hitDamage);
/* 29 */     paramOutput.writeFloat(this.poisonDamage);
/* 30 */     paramOutput.writeVarInt(this.fastShellsStackCount, true);
/* 31 */     paramKryo.writeClassAndObject(paramOutput, this.fromAbility);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void read(Kryo paramKryo, Input paramInput) {
/* 36 */     super.read(paramKryo, paramInput);
/* 37 */     this.tower = (Tower)paramKryo.readClassAndObject(paramInput);
/* 38 */     this.hitDamage = paramInput.readFloat();
/* 39 */     this.poisonDamage = paramInput.readFloat();
/* 40 */     this.fastShellsStackCount = paramInput.readVarInt(true);
/* 41 */     this.fromAbility = (Ability)paramKryo.readClassAndObject(paramInput);
/*    */   }
/*    */   
/*    */   public PoisonBuff() {
/* 45 */     super(BuffType.POISON);
/*    */   }
/*    */ 
/*    */   
/*    */   public final PoisonBuff cpy(float paramFloat) {
/* 50 */     PoisonBuff poisonBuff = new PoisonBuff();
/*    */     
/* 52 */     if ((paramFloat = this.duration * paramFloat) > this.maxDuration) paramFloat = this.maxDuration; 
/* 53 */     poisonBuff.setup(this.tower, paramFloat, this.maxDuration, this.hitDamage, this.poisonDamage, this.fromAbility);
/* 54 */     poisonBuff.fastShellsStackCount = this.fastShellsStackCount;
/*    */     
/* 56 */     return poisonBuff;
/*    */   }
/*    */ 
/*    */   
/*    */   @Deprecated
/*    */   public final void setup(float paramFloat1, float paramFloat2) {
/* 62 */     throw new IllegalStateException("Use other constructor");
/*    */   }
/*    */ 
/*    */   
/*    */   public final TextureRegion getHealthBarIcon() {
/* 67 */     switch (this.fastShellsStackCount) { case 0:
/*    */       case 1:
/* 69 */         return (TextureRegion)(AssetManager.TextureRegions.i()).buffHealthBarIconPoison;
/*    */       
/*    */       case 2:
/* 72 */         return (TextureRegion)(AssetManager.TextureRegions.i()).buffHealthBarIconPoisonTwo; }
/*    */ 
/*    */     
/* 75 */     return (TextureRegion)(AssetManager.TextureRegions.i()).buffHealthBarIconPoisonThree;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void setup(Tower paramTower, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Ability paramAbility) {
/* 82 */     super.setup(paramFloat1, paramFloat2);
/* 83 */     this.tower = paramTower;
/* 84 */     this.hitDamage = paramFloat3;
/* 85 */     this.poisonDamage = paramFloat4;
/* 86 */     this.fromAbility = paramAbility;
/*    */   }
/*    */   
/*    */   public static final class PoisonBuffFactory
/*    */     extends Buff.Factory<PoisonBuff> {
/*    */     public final BuffProcessor<PoisonBuff> createProcessor() {
/* 92 */       return (BuffProcessor<PoisonBuff>)new PoisonBuffProcessor();
/*    */     }
/*    */ 
/*    */     
/*    */     public final TextureRegion getHealthBarIcon() {
/* 97 */       return (TextureRegion)(AssetManager.TextureRegions.i()).buffHealthBarIconPoison;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\buffs\PoisonBuff.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */