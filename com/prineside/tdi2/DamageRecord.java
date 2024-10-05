/*     */ package com.prineside.tdi2;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public final class DamageRecord implements KryoSerializable {
/*     */   private Enemy a;
/*     */   private float b;
/*     */   private float c;
/*  18 */   private DamageType d = DamageType.BULLET;
/*  19 */   private int e = 0;
/*     */   
/*     */   @Null
/*     */   private Tower f;
/*     */   
/*     */   @Null
/*     */   private Ability g;
/*     */   @Null
/*     */   private Projectile h;
/*     */   private boolean i = true;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  31 */     paramKryo.writeClassAndObject(paramOutput, this.a);
/*  32 */     paramKryo.writeClassAndObject(paramOutput, this.f);
/*  33 */     paramOutput.writeFloat(this.b);
/*  34 */     paramOutput.writeFloat(this.c);
/*  35 */     paramKryo.writeObject(paramOutput, this.d);
/*  36 */     paramKryo.writeClassAndObject(paramOutput, this.g);
/*  37 */     paramOutput.writeBoolean(this.i);
/*  38 */     paramOutput.writeBoolean(this.j);
/*  39 */     paramKryo.writeClassAndObject(paramOutput, this.h);
/*  40 */     paramOutput.writeInt(this.e);
/*  41 */     paramOutput.writeBoolean(this.k);
/*  42 */     paramKryo.writeClassAndObject(paramOutput, this.l);
/*  43 */     paramKryo.writeClassAndObject(paramOutput, this.m);
/*     */   } private boolean j; private boolean k; @Null
/*     */   private Unit l; @Null
/*     */   private Explosion m;
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  48 */     this.a = (Enemy)paramKryo.readClassAndObject(paramInput);
/*  49 */     this.f = (Tower)paramKryo.readClassAndObject(paramInput);
/*  50 */     this.b = paramInput.readFloat();
/*  51 */     this.c = paramInput.readFloat();
/*  52 */     this.d = (DamageType)paramKryo.readObject(paramInput, DamageType.class);
/*  53 */     this.g = (Ability)paramKryo.readClassAndObject(paramInput);
/*  54 */     this.i = paramInput.readBoolean();
/*  55 */     this.j = paramInput.readBoolean();
/*  56 */     this.h = (Projectile)paramKryo.readClassAndObject(paramInput);
/*  57 */     this.e = paramInput.readInt();
/*  58 */     this.k = paramInput.readBoolean();
/*  59 */     this.l = (Unit)paramKryo.readClassAndObject(paramInput);
/*  60 */     this.m = (Explosion)paramKryo.readClassAndObject(paramInput);
/*     */   }
/*     */   
/*     */   public DamageRecord() {
/*  64 */     reset();
/*     */   }
/*     */   
/*     */   public final DamageRecord setup(Enemy paramEnemy, float paramFloat, DamageType paramDamageType) {
/*  68 */     setEnemy(paramEnemy);
/*  69 */     setDamage(paramFloat);
/*  70 */     setDamageType(paramDamageType);
/*  71 */     return this;
/*     */   }
/*     */   
/*     */   public final DamageRecord copyFor(Enemy paramEnemy, DamageRecord paramDamageRecord) {
/*     */     DamageRecord damageRecord;
/*  76 */     (damageRecord = paramDamageRecord.setup(paramEnemy, this.b, this.d)).c = this.c;
/*  77 */     damageRecord.e = this.e;
/*  78 */     damageRecord.f = this.f;
/*  79 */     damageRecord.g = this.g;
/*  80 */     damageRecord.h = this.h;
/*  81 */     damageRecord.i = this.i;
/*  82 */     damageRecord.j = this.j;
/*  83 */     damageRecord.k = this.k;
/*  84 */     damageRecord.l = this.l;
/*  85 */     damageRecord.m = this.m;
/*  86 */     return damageRecord;
/*     */   }
/*     */   
/*     */   public final void reset() {
/*  90 */     this.a = null;
/*  91 */     this.f = null;
/*  92 */     this.g = null;
/*  93 */     this.h = null;
/*  94 */     this.e = 0;
/*  95 */     this.i = true;
/*  96 */     this.j = false;
/*  97 */     this.k = false;
/*  98 */     this.l = null;
/*  99 */     this.m = null;
/*     */   }
/*     */   
/*     */   public final Enemy getEnemy() {
/* 103 */     return this.a;
/*     */   }
/*     */   
/*     */   public final DamageRecord setEnemy(Enemy paramEnemy) {
/* 107 */     Preconditions.checkNotNull(paramEnemy);
/* 108 */     this.a = paramEnemy;
/* 109 */     return this;
/*     */   }
/*     */   @Null
/*     */   public final Unit getUnit() {
/* 113 */     return this.l;
/*     */   }
/*     */   
/*     */   public final DamageRecord setUnit(@Null Unit paramUnit) {
/* 117 */     this.l = paramUnit;
/* 118 */     return this;
/*     */   }
/*     */   @Null
/*     */   public final Explosion getExplosion() {
/* 122 */     return this.m;
/*     */   }
/*     */   
/*     */   public final DamageRecord setExplosion(@Null Explosion paramExplosion) {
/* 126 */     this.m = paramExplosion;
/* 127 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Null
/*     */   public final Tower getTower() {
/* 134 */     if (this.f != null && !this.f.isRegistered()) return null; 
/* 135 */     return this.f;
/*     */   }
/*     */   
/*     */   public final DamageRecord setTower(@Null Tower paramTower) {
/* 139 */     this.f = paramTower;
/* 140 */     return this;
/*     */   }
/*     */   
/*     */   public final float getDamage() {
/* 144 */     return this.b;
/*     */   }
/*     */   
/*     */   public final DamageRecord setDamage(float paramFloat) {
/* 148 */     Preconditions.checkArgument((paramFloat > 0.0F && PMath.isFinite(paramFloat)), "Invalid damage: %s", Float.valueOf(paramFloat));
/* 149 */     this.b = paramFloat;
/* 150 */     return this;
/*     */   }
/*     */   
/*     */   public final float getFactDamage() {
/* 154 */     return this.c;
/*     */   }
/*     */   
/*     */   public final DamageRecord setFactDamage(float paramFloat) {
/* 158 */     Preconditions.checkArgument((paramFloat > 0.0F && PMath.isFinite(paramFloat)), "Invalid factDamage: %s", Float.valueOf(paramFloat));
/* 159 */     this.c = paramFloat;
/* 160 */     return this;
/*     */   }
/*     */   
/*     */   public final DamageType getDamageType() {
/* 164 */     return this.d;
/*     */   }
/*     */   
/*     */   public final DamageRecord setDamageType(DamageType paramDamageType) {
/* 168 */     Preconditions.checkNotNull(paramDamageType);
/* 169 */     this.d = paramDamageType;
/* 170 */     return this;
/*     */   }
/*     */   @Null
/*     */   public final Ability getAbility() {
/* 174 */     return this.g;
/*     */   }
/*     */   
/*     */   public final DamageRecord setAbility(@Null Ability paramAbility) {
/* 178 */     this.g = paramAbility;
/* 179 */     return this;
/*     */   }
/*     */   
/*     */   public final boolean isCleanForDps() {
/* 183 */     return this.i;
/*     */   }
/*     */   
/*     */   public final DamageRecord setCleanForDps(boolean paramBoolean) {
/* 187 */     this.i = paramBoolean;
/* 188 */     return this;
/*     */   }
/*     */   
/*     */   public final boolean isLethal() {
/* 192 */     return this.j;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final DamageRecord setLethal(boolean paramBoolean) {
/* 199 */     this.j = paramBoolean;
/* 200 */     return this;
/*     */   }
/*     */   @Null
/*     */   public final Projectile getProjectile() {
/* 204 */     return this.h;
/*     */   }
/*     */   
/*     */   public final DamageRecord setProjectile(@Null Projectile paramProjectile) {
/* 208 */     this.h = paramProjectile;
/* 209 */     return this;
/*     */   }
/*     */   
/*     */   public final int getEfficiency() {
/* 213 */     return this.e;
/*     */   }
/*     */   
/*     */   public final DamageRecord setEfficiency(int paramInt) {
/* 217 */     this.e = paramInt;
/* 218 */     return this;
/*     */   }
/*     */   
/*     */   public final boolean isIgnoreTowerEfficiency() {
/* 222 */     return this.k;
/*     */   }
/*     */   
/*     */   public final DamageRecord setIgnoreTowerEfficiency(boolean paramBoolean) {
/* 226 */     this.k = paramBoolean;
/* 227 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 232 */     return super.toString() + " (enemy: " + this.a + ", damage: " + this.b + ", factDamage: " + this.c + ", damageType: " + this.d + ", efficiency: " + this.e + ", tower: " + this.f + ", ability: " + this.g + ", projectile: " + this.h + ", cleanForDps: " + this.i + ", ignoreTowerEfficiency: " + this.k + ", unit: " + this.l + ", explosion: " + this.m + ")";
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\DamageRecord.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */