/*     */ package com.prineside.tdi2;
/*     */ 
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.waves.templates.ArmoredLow;
/*     */ import com.prineside.tdi2.waves.templates.ArmoredRegular;
/*     */ import com.prineside.tdi2.waves.templates.ArmoredStrong;
/*     */ import com.prineside.tdi2.waves.templates.FastHigh;
/*     */ import com.prineside.tdi2.waves.templates.FastLow;
/*     */ import com.prineside.tdi2.waves.templates.FastMedium;
/*     */ import com.prineside.tdi2.waves.templates.FighterArmored;
/*     */ import com.prineside.tdi2.waves.templates.FighterLow;
/*     */ import com.prineside.tdi2.waves.templates.FighterMedium;
/*     */ import com.prineside.tdi2.waves.templates.HealerArmored;
/*     */ import com.prineside.tdi2.waves.templates.HealerIcy;
/*     */ import com.prineside.tdi2.waves.templates.HealerJet;
/*     */ import com.prineside.tdi2.waves.templates.HealerRegular;
/*     */ import com.prineside.tdi2.waves.templates.HealerSlow;
/*     */ import com.prineside.tdi2.waves.templates.HealerStrong;
/*     */ import com.prineside.tdi2.waves.templates.HeliMedium;
/*     */ import com.prineside.tdi2.waves.templates.IcyHigh;
/*     */ import com.prineside.tdi2.waves.templates.IcyToxic;
/*     */ import com.prineside.tdi2.waves.templates.JetMedium;
/*     */ import com.prineside.tdi2.waves.templates.LightFast;
/*     */ import com.prineside.tdi2.waves.templates.LightHigh;
/*     */ import com.prineside.tdi2.waves.templates.LightMedium;
/*     */ import com.prineside.tdi2.waves.templates.RegularHigh;
/*     */ import com.prineside.tdi2.waves.templates.RegularLow;
/*     */ import com.prineside.tdi2.waves.templates.RegularMedium;
/*     */ import com.prineside.tdi2.waves.templates.StrongLow;
/*     */ import com.prineside.tdi2.waves.templates.StrongMedium;
/*     */ import com.prineside.tdi2.waves.templates.ToxicArmored;
/*     */ import com.prineside.tdi2.waves.templates.ToxicHigh;
/*     */ import com.prineside.tdi2.waves.templates.ToxicMedium;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WaveTemplates
/*     */ {
/*     */   public static int calculateProbability(int paramInt1, float paramFloat1, int paramInt2, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, int paramInt3) {
/*  90 */     if (paramFloat1 < paramInt2) return 1;
/*     */     
/*  92 */     float f2 = Interpolation.pow2.apply(MathUtils.clamp((paramFloat1 - paramInt2) * paramFloat2, 0.0F, 1.0F));
/*  93 */     float f1 = 1.0F - paramFloat3 + StrictMath.abs(PMath.sin(paramInt1 * paramFloat4 + paramFloat5)) * paramFloat3;
/*     */     int i;
/*  95 */     if ((i = (int)((paramFloat6 - (int)(paramFloat1 * paramFloat7)) * f1 * f2)) < paramInt3 && paramFloat1 > 20.0F) i = paramInt3; 
/*  96 */     if (i <= 0) i = 1; 
/*  97 */     return i;
/*     */   }
/*     */   
/* 100 */   public static final RegularMedium REGULAR_MEDIUM = new RegularMedium();
/* 101 */   public static final RegularLow REGULAR_LOW = new RegularLow();
/* 102 */   public static final RegularHigh REGULAR_HIGH = new RegularHigh();
/* 103 */   public static final StrongMedium STRONG_MEDIUM = new StrongMedium();
/* 104 */   public static final StrongLow STRONG_LOW = new StrongLow();
/* 105 */   public static final FastMedium FAST_MEDIUM = new FastMedium();
/* 106 */   public static final FastHigh FAST_HIGH = new FastHigh();
/* 107 */   public static final FastLow FAST_LOW = new FastLow();
/* 108 */   public static final HeliMedium HELI_MEDIUM = new HeliMedium();
/* 109 */   public static final JetMedium JET_MEDIUM = new JetMedium();
/* 110 */   public static final ArmoredLow ARMORED_LOW = new ArmoredLow();
/* 111 */   public static final ArmoredRegular ARMORED_REGULAR = new ArmoredRegular();
/* 112 */   public static final ArmoredStrong ARMORED_STRONG = new ArmoredStrong();
/* 113 */   public static final HealerRegular HEALER_REGULAR = new HealerRegular();
/* 114 */   public static final HealerSlow HEALER_SLOW = new HealerSlow();
/* 115 */   public static final HealerStrong HEALER_STRONG = new HealerStrong();
/* 116 */   public static final HealerArmored HEALER_ARMORED = new HealerArmored();
/* 117 */   public static final HealerJet HEALER_JET = new HealerJet();
/* 118 */   public static final ToxicMedium TOXIC_MEDIUM = new ToxicMedium();
/* 119 */   public static final ToxicHigh TOXIC_HIGH = new ToxicHigh();
/* 120 */   public static final ToxicArmored TOXIC_ARMORED = new ToxicArmored();
/* 121 */   public static final IcyHigh ICY_HIGH = new IcyHigh();
/* 122 */   public static final IcyToxic ICY_TOXIC = new IcyToxic();
/* 123 */   public static final HealerIcy HEALER_ICY = new HealerIcy();
/* 124 */   public static final FighterLow FIGHTER_LOW = new FighterLow();
/* 125 */   public static final FighterMedium FIGHTER_MEDIUM = new FighterMedium();
/* 126 */   public static final FighterArmored FIGHTER_ARMORED = new FighterArmored();
/* 127 */   public static final LightMedium LIGHT_MEDIUM = new LightMedium();
/* 128 */   public static final LightHigh LIGHT_HIGH = new LightHigh();
/* 129 */   public static final LightFast LIGHT_FAST = new LightFast();
/*     */   
/* 131 */   public static final WaveTemplate[] WAVE_TEMPLATES = new WaveTemplate[] { (WaveTemplate)REGULAR_MEDIUM, (WaveTemplate)REGULAR_LOW, (WaveTemplate)REGULAR_HIGH, (WaveTemplate)STRONG_MEDIUM, (WaveTemplate)STRONG_LOW, (WaveTemplate)FAST_MEDIUM, (WaveTemplate)FAST_HIGH, (WaveTemplate)FAST_LOW, (WaveTemplate)HELI_MEDIUM, (WaveTemplate)JET_MEDIUM, (WaveTemplate)ARMORED_LOW, (WaveTemplate)ARMORED_REGULAR, (WaveTemplate)ARMORED_STRONG, (WaveTemplate)HEALER_REGULAR, (WaveTemplate)HEALER_SLOW, (WaveTemplate)HEALER_STRONG, (WaveTemplate)HEALER_ARMORED, (WaveTemplate)HEALER_JET, (WaveTemplate)TOXIC_MEDIUM, (WaveTemplate)TOXIC_HIGH, (WaveTemplate)TOXIC_ARMORED, (WaveTemplate)ICY_HIGH, (WaveTemplate)ICY_TOXIC, (WaveTemplate)HEALER_ICY, (WaveTemplate)FIGHTER_LOW, (WaveTemplate)FIGHTER_MEDIUM, (WaveTemplate)FIGHTER_ARMORED, (WaveTemplate)LIGHT_MEDIUM, (WaveTemplate)LIGHT_HIGH, (WaveTemplate)LIGHT_FAST };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Null
/*     */   public static WaveTemplate getByName(String paramString) {
/* 165 */     switch (paramString) { case "REGULAR_MEDIUM":
/* 166 */         return (WaveTemplate)REGULAR_MEDIUM;
/* 167 */       case "REGULAR_LOW": return (WaveTemplate)REGULAR_LOW;
/* 168 */       case "REGULAR_HIGH": return (WaveTemplate)REGULAR_HIGH;
/* 169 */       case "STRONG_MEDIUM": return (WaveTemplate)STRONG_MEDIUM;
/* 170 */       case "STRONG_LOW": return (WaveTemplate)STRONG_LOW;
/* 171 */       case "FAST_MEDIUM": return (WaveTemplate)FAST_MEDIUM;
/* 172 */       case "FAST_HIGH": return (WaveTemplate)FAST_HIGH;
/* 173 */       case "FAST_LOW": return (WaveTemplate)FAST_LOW;
/* 174 */       case "HELI_MEDIUM": return (WaveTemplate)HELI_MEDIUM;
/* 175 */       case "JET_MEDIUM": return (WaveTemplate)JET_MEDIUM;
/* 176 */       case "ARMORED_LOW": return (WaveTemplate)ARMORED_LOW;
/* 177 */       case "ARMORED_REGULAR": return (WaveTemplate)ARMORED_REGULAR;
/* 178 */       case "ARMORED_STRONG": return (WaveTemplate)ARMORED_STRONG;
/* 179 */       case "HEALER_REGULAR": return (WaveTemplate)HEALER_REGULAR;
/* 180 */       case "HEALER_SLOW": return (WaveTemplate)HEALER_SLOW;
/* 181 */       case "HEALER_STRONG": return (WaveTemplate)HEALER_STRONG;
/* 182 */       case "HEALER_ARMORED": return (WaveTemplate)HEALER_ARMORED;
/* 183 */       case "HEALER_JET": return (WaveTemplate)HEALER_JET;
/* 184 */       case "TOXIC_MEDIUM": return (WaveTemplate)TOXIC_MEDIUM;
/* 185 */       case "TOXIC_HIGH": return (WaveTemplate)TOXIC_HIGH;
/* 186 */       case "TOXIC_ARMORED": return (WaveTemplate)TOXIC_ARMORED;
/* 187 */       case "ICY_HIGH": return (WaveTemplate)ICY_HIGH;
/* 188 */       case "ICY_TOXIC": return (WaveTemplate)ICY_TOXIC;
/* 189 */       case "HEALER_ICY": return (WaveTemplate)HEALER_ICY;
/* 190 */       case "FIGHTER_LOW": return (WaveTemplate)FIGHTER_LOW;
/* 191 */       case "FIGHTER_MEDIUM": return (WaveTemplate)FIGHTER_MEDIUM;
/* 192 */       case "FIGHTER_ARMORED": return (WaveTemplate)FIGHTER_ARMORED;
/* 193 */       case "LIGHT_MEDIUM": return (WaveTemplate)LIGHT_MEDIUM;
/* 194 */       case "LIGHT_HIGH": return (WaveTemplate)LIGHT_HIGH;
/* 195 */       case "LIGHT_FAST": return (WaveTemplate)LIGHT_FAST; }
/* 196 */      return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static abstract class WaveTemplate
/*     */   {
/*     */     public abstract int getProbability(int param1Int, float param1Float1, float param1Float2);
/*     */ 
/*     */ 
/*     */     
/*     */     public abstract WaveTemplates.EnemyGroupConfig[] getEnemyGroupConfigs();
/*     */ 
/*     */ 
/*     */     
/*     */     public abstract String getWaveMessage();
/*     */ 
/*     */ 
/*     */     
/*     */     public abstract String getWaveName();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @REGS(arrayLevels = 1)
/*     */   public static class PredefinedWaveTemplate
/*     */     implements KryoSerializable
/*     */   {
/*     */     public String waveMessage;
/*     */ 
/*     */     
/*     */     public EnemyGroup[] enemyGroups;
/*     */ 
/*     */ 
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output) {
/* 232 */       param1Kryo.writeObjectOrNull(param1Output, this.waveMessage, String.class);
/* 233 */       param1Kryo.writeObjectOrNull(param1Output, this.enemyGroups, EnemyGroup[].class);
/*     */     }
/*     */ 
/*     */     
/*     */     public void read(Kryo param1Kryo, Input param1Input) {
/* 238 */       this.waveMessage = (String)param1Kryo.readObjectOrNull(param1Input, String.class);
/* 239 */       this.enemyGroups = (EnemyGroup[])param1Kryo.readObjectOrNull(param1Input, EnemyGroup[].class);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public PredefinedWaveTemplate() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public PredefinedWaveTemplate(EnemyGroup param1EnemyGroup) {
/* 250 */       this.enemyGroups = new EnemyGroup[1];
/* 251 */       this.enemyGroups[0] = param1EnemyGroup;
/*     */     }
/*     */     
/*     */     public PredefinedWaveTemplate(EnemyGroup param1EnemyGroup1, EnemyGroup param1EnemyGroup2) {
/* 255 */       this.enemyGroups = new EnemyGroup[2];
/* 256 */       this.enemyGroups[0] = param1EnemyGroup1;
/* 257 */       this.enemyGroups[1] = param1EnemyGroup2;
/*     */     }
/*     */     
/*     */     public PredefinedWaveTemplate(EnemyGroup param1EnemyGroup1, EnemyGroup param1EnemyGroup2, EnemyGroup param1EnemyGroup3) {
/* 261 */       this.enemyGroups = new EnemyGroup[3];
/* 262 */       this.enemyGroups[0] = param1EnemyGroup1;
/* 263 */       this.enemyGroups[1] = param1EnemyGroup2;
/* 264 */       this.enemyGroups[2] = param1EnemyGroup3;
/*     */     }
/*     */     
/*     */     public void toJson(Json param1Json) {
/* 268 */       if (this.waveMessage != null) param1Json.writeValue("message", this.waveMessage); 
/* 269 */       param1Json.writeArrayStart("enemyGroups"); EnemyGroup[] arrayOfEnemyGroup; int i; byte b;
/* 270 */       for (i = (arrayOfEnemyGroup = this.enemyGroups).length, b = 0; b < i; ) { EnemyGroup enemyGroup = arrayOfEnemyGroup[b];
/* 271 */         param1Json.writeObjectStart();
/* 272 */         enemyGroup.toJson(param1Json);
/* 273 */         param1Json.writeObjectEnd(); b++; }
/*     */       
/* 275 */       param1Json.writeArrayEnd();
/*     */     }
/*     */ 
/*     */     
/*     */     public static PredefinedWaveTemplate fromJson(JsonValue param1JsonValue) {
/*     */       PredefinedWaveTemplate predefinedWaveTemplate;
/* 281 */       (predefinedWaveTemplate = new PredefinedWaveTemplate()).waveMessage = param1JsonValue.getString("message", null);
/* 282 */       param1JsonValue = param1JsonValue.get("enemyGroups");
/* 283 */       predefinedWaveTemplate.enemyGroups = new EnemyGroup[param1JsonValue.size];
/* 284 */       byte b = 0;
/* 285 */       for (JsonValue.JsonIterator<JsonValue> jsonIterator = param1JsonValue.iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue = jsonIterator.next();
/* 286 */         predefinedWaveTemplate.enemyGroups[b] = EnemyGroup.fromJson(jsonValue);
/* 287 */         b++; }
/*     */ 
/*     */       
/* 290 */       return predefinedWaveTemplate;
/*     */     }
/*     */   }
/*     */   
/*     */   public static interface EnemyGroupConfig {
/*     */     EnemyType getEnemyType();
/*     */     
/*     */     float getInterval(int param1Int, float param1Float1, float param1Float2);
/*     */     
/*     */     int getCount(int param1Int, float param1Float1, float param1Float2);
/*     */     
/*     */     float getHealth(int param1Int, float param1Float1, float param1Float2);
/*     */     
/*     */     float getBounty(int param1Int, float param1Float1, float param1Float2);
/*     */     
/*     */     float getDelay(int param1Int, float param1Float1, float param1Float2);
/*     */     
/*     */     float getSpeed(int param1Int, float param1Float1, float param1Float2);
/*     */     
/*     */     float getKillExp(int param1Int, float param1Float1, float param1Float2);
/*     */     
/*     */     int getKillScore(int param1Int, float param1Float1, float param1Float2);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\WaveTemplates.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */