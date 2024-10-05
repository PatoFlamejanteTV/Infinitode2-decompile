/*     */ package com.prineside.tdi2.enemies;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.enums.BuffType;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.enums.SpecialDamageType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ @REGS
/*     */ public final class GenericEnemy extends Enemy {
/*  26 */   public float size = 25.6F;
/*     */   public boolean mayHaveRandomSideShift = true;
/*     */   public boolean drawPriority = false;
/*  29 */   public int baseDamage = 1;
/*     */   
/*     */   public float[] towerDamageMultiplier;
/*     */   public float[] buffVulnerability;
/*     */   public boolean[] damageVulnerability;
/*     */   public boolean[] specialDamageVulnerability;
/*     */   public float[] abilityVulnerability;
/*     */   public boolean isFlying = false;
/*     */   public boolean allowsDynamicPathfinding = true;
/*     */   public Color color;
/*     */   @NAGS
/*     */   public TextureRegion texture;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  43 */     super.write(paramKryo, paramOutput);
/*  44 */     paramOutput.writeFloat(this.size);
/*  45 */     paramOutput.writeBoolean(this.mayHaveRandomSideShift);
/*  46 */     paramOutput.writeBoolean(this.drawPriority);
/*  47 */     paramKryo.writeObjectOrNull(paramOutput, this.towerDamageMultiplier, float[].class);
/*  48 */     paramOutput.writeVarInt(this.baseDamage, true);
/*  49 */     paramKryo.writeObjectOrNull(paramOutput, this.buffVulnerability, float[].class);
/*  50 */     paramKryo.writeObjectOrNull(paramOutput, this.damageVulnerability, boolean[].class);
/*  51 */     paramKryo.writeObjectOrNull(paramOutput, this.specialDamageVulnerability, boolean[].class);
/*  52 */     paramKryo.writeObjectOrNull(paramOutput, this.abilityVulnerability, float[].class);
/*  53 */     paramOutput.writeBoolean(this.isFlying);
/*  54 */     paramOutput.writeBoolean(this.allowsDynamicPathfinding);
/*  55 */     paramKryo.writeObjectOrNull(paramOutput, this.color, Color.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  60 */     super.read(paramKryo, paramInput);
/*  61 */     this.size = paramInput.readFloat();
/*  62 */     this.mayHaveRandomSideShift = paramInput.readBoolean();
/*  63 */     this.drawPriority = paramInput.readBoolean();
/*  64 */     this.towerDamageMultiplier = (float[])paramKryo.readObjectOrNull(paramInput, float[].class);
/*  65 */     this.baseDamage = paramInput.readVarInt(true);
/*  66 */     this.buffVulnerability = (float[])paramKryo.readObjectOrNull(paramInput, float[].class);
/*  67 */     this.damageVulnerability = (boolean[])paramKryo.readObjectOrNull(paramInput, boolean[].class);
/*  68 */     this.specialDamageVulnerability = (boolean[])paramKryo.readObjectOrNull(paramInput, boolean[].class);
/*  69 */     this.abilityVulnerability = (float[])paramKryo.readObjectOrNull(paramInput, float[].class);
/*  70 */     this.isFlying = paramInput.readBoolean();
/*  71 */     this.allowsDynamicPathfinding = paramInput.readBoolean();
/*  72 */     this.color = (Color)paramKryo.readObjectOrNull(paramInput, Color.class);
/*     */   }
/*     */   
/*     */   private GenericEnemy() {
/*  76 */     super(EnemyType.GENERIC);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean canHaveRandomSideShift() {
/*  81 */     return this.mayHaveRandomSideShift;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getSize() {
/*  86 */     return this.size;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getSquaredSize() {
/*  91 */     return this.size * this.size;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean hasDrawPriority() {
/*  96 */     return this.drawPriority;
/*     */   }
/*     */ 
/*     */   
/*     */   public final TextureRegion getTexture() {
/* 101 */     return (this.texture == null) ? this.S.enemy.getTexture(this.type) : this.texture;
/*     */   }
/*     */ 
/*     */   
/*     */   public final TextureRegion getHighlightTexture() {
/* 106 */     return getTexture();
/*     */   }
/*     */ 
/*     */   
/*     */   public final TextureRegion getEmojiTexture() {
/* 111 */     return getTexture();
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getTowerDamageMultiplier(TowerType paramTowerType) {
/* 116 */     return (this.towerDamageMultiplier == null) ? this.S.tower.towerEnemyDamageMultiplier[this.type.ordinal()][paramTowerType.ordinal()] : this.towerDamageMultiplier[paramTowerType.ordinal()];
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean canBeAttackedBy(Tower paramTower) {
/* 121 */     if (getTowerDamageMultiplier(paramTower.type) <= 0.0F) return false;
/*     */     
/* 123 */     return super.canBeAttackedBy(paramTower);
/*     */   }
/*     */   
/*     */   public final float getBaseDamage() {
/* 127 */     return this.baseDamage;
/*     */   }
/*     */   
/*     */   public final float getBuffVulnerability(BuffType paramBuffType) {
/* 131 */     return (this.buffVulnerability == null) ? this.S.enemy.enemyBuffVulnerability[this.type.ordinal()][paramBuffType.ordinal()] : this.buffVulnerability[paramBuffType.ordinal()];
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isVulnerableTo(DamageType paramDamageType) {
/* 136 */     return (this.damageVulnerability == null) ? this.S.enemy.enemyDamageVulnerability[this.type.ordinal()][paramDamageType.ordinal()] : this.damageVulnerability[paramDamageType.ordinal()];
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isVulnerableToSpecial(SpecialDamageType paramSpecialDamageType) {
/* 141 */     return (this.specialDamageVulnerability == null) ? this.S.enemy.enemySpecialDamageVulnerability[this.type.ordinal()][paramSpecialDamageType.ordinal()] : this.specialDamageVulnerability[paramSpecialDamageType.ordinal()];
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getAbilityVulnerability(AbilityType paramAbilityType) {
/* 146 */     return (this.abilityVulnerability == null) ? super.getAbilityVulnerability(paramAbilityType) : this.abilityVulnerability[paramAbilityType.ordinal()];
/*     */   }
/*     */   
/*     */   public final void setTowerDamageMultiplier(TowerType paramTowerType, float paramFloat) {
/* 150 */     if (this.towerDamageMultiplier == null) {
/* 151 */       this.towerDamageMultiplier = new float[TowerType.values.length];
/* 152 */       System.arraycopy(this.S.tower.towerEnemyDamageMultiplier[this.type.ordinal()], 0, this.towerDamageMultiplier, 0, this.towerDamageMultiplier.length);
/*     */     } 
/* 154 */     this.towerDamageMultiplier[paramTowerType.ordinal()] = paramFloat;
/*     */   }
/*     */   
/*     */   public final void setBuffVulnerability(BuffType paramBuffType, float paramFloat) {
/* 158 */     if (this.buffVulnerability == null) {
/* 159 */       this.buffVulnerability = new float[BuffType.values.length];
/* 160 */       System.arraycopy(this.S.enemy.enemyBuffVulnerability[this.type.ordinal()], 0, this.buffVulnerability, 0, this.buffVulnerability.length);
/*     */     } 
/* 162 */     this.buffVulnerability[paramBuffType.ordinal()] = paramFloat;
/*     */   }
/*     */   
/*     */   public final void setDamageVulnerability(DamageType paramDamageType, boolean paramBoolean) {
/* 166 */     if (this.damageVulnerability == null) {
/* 167 */       this.damageVulnerability = new boolean[DamageType.values.length];
/* 168 */       System.arraycopy(this.S.enemy.enemyDamageVulnerability[this.type.ordinal()], 0, this.damageVulnerability, 0, this.damageVulnerability.length);
/*     */     } 
/* 170 */     this.damageVulnerability[paramDamageType.ordinal()] = paramBoolean;
/*     */   }
/*     */   
/*     */   public final void setSpecialDamageVulnerability(SpecialDamageType paramSpecialDamageType, boolean paramBoolean) {
/* 174 */     if (this.specialDamageVulnerability == null) {
/* 175 */       this.specialDamageVulnerability = new boolean[SpecialDamageType.values.length];
/* 176 */       System.arraycopy(this.S.enemy.enemySpecialDamageVulnerability[this.type.ordinal()], 0, this.specialDamageVulnerability, 0, this.specialDamageVulnerability.length);
/*     */     } 
/* 178 */     this.specialDamageVulnerability[paramSpecialDamageType.ordinal()] = paramBoolean;
/*     */   }
/*     */   
/*     */   public final void setAbilityVulnerability(AbilityType paramAbilityType, float paramFloat) {
/* 182 */     if (this.abilityVulnerability == null) {
/* 183 */       this.abilityVulnerability = new float[AbilityType.values.length];
/* 184 */       Arrays.fill(this.abilityVulnerability, 1.0F);
/*     */     } 
/* 186 */     this.abilityVulnerability[paramAbilityType.ordinal()] = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public final ParticleEffectPool.PooledEffect getBreakParticle() {
/* 191 */     ParticleEffectPool.PooledEffect pooledEffect = super.getBreakParticle();
/* 192 */     Color color = getColor();
/*     */     float[] arrayOfFloat;
/* 194 */     (arrayOfFloat = ((ParticleEmitter)pooledEffect.getEmitters().first()).getTint().getColors())[0] = color.r;
/* 195 */     arrayOfFloat[1] = color.g;
/* 196 */     arrayOfFloat[2] = color.b;
/* 197 */     return pooledEffect;
/*     */   }
/*     */ 
/*     */   
/*     */   public final ParticleEffectPool.PooledEffect getHitParticle() {
/* 202 */     ParticleEffectPool.PooledEffect pooledEffect = super.getHitParticle();
/* 203 */     Color color = getColor();
/*     */     float[] arrayOfFloat;
/* 205 */     (arrayOfFloat = ((ParticleEmitter)pooledEffect.getEmitters().first()).getTint().getColors())[0] = color.r;
/* 206 */     arrayOfFloat[1] = color.g;
/* 207 */     arrayOfFloat[2] = color.b;
/* 208 */     return pooledEffect;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Color getColor() {
/* 213 */     return (this.color == null) ? MaterialColor.GREY.P500 : this.color;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isAir() {
/* 218 */     return this.isFlying;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean dynamicPathfindingAllowed() {
/* 223 */     return this.allowsDynamicPathfinding;
/*     */   }
/*     */   
/*     */   public static class GenericEnemyFactory extends Enemy.Factory<GenericEnemy> {
/*     */     public GenericEnemyFactory() {
/* 228 */       super(EnemyType.GENERIC);
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getTexture() {
/* 233 */       return (TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion();
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getHighlightTexture() {
/* 238 */       return (TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion();
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getEmojiTexture() {
/* 243 */       return (TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion();
/*     */     }
/*     */ 
/*     */     
/*     */     public GenericEnemy create() {
/* 248 */       return new GenericEnemy((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getColor() {
/* 253 */       return MaterialColor.GREY.P500;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enemies\GenericEnemy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */