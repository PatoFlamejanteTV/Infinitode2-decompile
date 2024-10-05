/*     */ package com.prineside.tdi2;
/*     */ 
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ 
/*     */ @REGS
/*     */ public class MapPrestigeConfig
/*     */   implements KryoSerializable
/*     */ {
/*     */   public static final int BASE_BONUS = 50;
/*     */   public static final int MAX_DIFFICULTY_BONUS = 50;
/*     */   public static final int NO_ABILITIES_BONUS = 10;
/*     */   public static final int WALKABLE_PLATFORMS_BONUS = 10;
/*     */   public static final int NO_BOUNTY_MOD_BONUS = 20;
/*     */   public static final int NO_MINERS_BONUS = 20;
/*     */   public static final int NO_RESEARCH_BONUS = 40;
/*     */   public String userMapId;
/*     */   public double mapPrice;
/*     */   public int averageDifficulty;
/*     */   public boolean noAbilities;
/*     */   public boolean noResearch;
/*     */   public boolean walkablePlatforms;
/*     */   public boolean noBounty;
/*     */   public boolean noMiners;
/*     */   public long score;
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  35 */     paramKryo.writeObjectOrNull(paramOutput, this.userMapId, String.class);
/*  36 */     paramOutput.writeDouble(this.mapPrice);
/*  37 */     paramOutput.writeVarInt(this.averageDifficulty, true);
/*  38 */     paramOutput.writeBoolean(this.noAbilities);
/*  39 */     paramOutput.writeBoolean(this.noResearch);
/*  40 */     paramOutput.writeBoolean(this.walkablePlatforms);
/*  41 */     paramOutput.writeBoolean(this.noBounty);
/*  42 */     paramOutput.writeBoolean(this.noMiners);
/*  43 */     paramOutput.writeVarLong(this.score, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  48 */     this.userMapId = (String)paramKryo.readObjectOrNull(paramInput, String.class);
/*  49 */     this.mapPrice = paramInput.readDouble();
/*  50 */     this.averageDifficulty = paramInput.readVarInt(true);
/*  51 */     this.noAbilities = paramInput.readBoolean();
/*  52 */     this.noResearch = paramInput.readBoolean();
/*  53 */     this.walkablePlatforms = paramInput.readBoolean();
/*  54 */     this.noBounty = paramInput.readBoolean();
/*  55 */     this.noMiners = paramInput.readBoolean();
/*  56 */     this.score = paramInput.readVarLong(true);
/*     */   }
/*     */   
/*     */   private MapPrestigeConfig() {}
/*     */   
/*     */   public MapPrestigeConfig(String paramString, double paramDouble, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, long paramLong) {
/*  62 */     this.userMapId = paramString;
/*  63 */     this.mapPrice = paramDouble;
/*  64 */     this.averageDifficulty = paramInt;
/*  65 */     this.noAbilities = paramBoolean1;
/*  66 */     this.noResearch = paramBoolean2;
/*  67 */     this.walkablePlatforms = paramBoolean3;
/*  68 */     this.noBounty = paramBoolean4;
/*  69 */     this.noMiners = paramBoolean5;
/*  70 */     this.score = paramLong;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCrownsCount() {
/*     */     int i;
/*  76 */     if ((i = getTotalBonus()) < 40) return 1; 
/*  77 */     if (i < 80) return 2; 
/*  78 */     if (i < 120) return 3; 
/*  79 */     if (i < 160) return 4; 
/*  80 */     return 5;
/*     */   }
/*     */   
/*     */   public double getScoreMultiplier() {
/*     */     double d;
/*  85 */     if ((d = this.score / getMaxPrestigeScore()) > 1.0D) d = 1.0D;
/*     */     
/*  87 */     return d;
/*     */   }
/*     */   
/*     */   public int getDifficultyBonus() {
/*  91 */     if (this.averageDifficulty <= 100)
/*  92 */       return 0; 
/*  93 */     if (this.averageDifficulty < 170)
/*  94 */       return 10; 
/*  95 */     if (this.averageDifficulty < 250)
/*  96 */       return 20; 
/*  97 */     if (this.averageDifficulty < 350)
/*  98 */       return 30; 
/*  99 */     if (this.averageDifficulty < 450) {
/* 100 */       return 40;
/*     */     }
/* 102 */     return 50;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTotalBonus() {
/* 107 */     double d = getScoreMultiplier();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int i;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 117 */     return MathUtils.floor((i = 50 + getDifficultyBonus() + (this.noResearch ? 40 : 0) + (this.noAbilities ? 10 : 0) + (this.walkablePlatforms ? 10 : 0) + (this.noBounty ? 20 : 0) + (this.noMiners ? 20 : 0)) * (float)d);
/*     */   }
/*     */   
/*     */   public int getFinalPrestigeTokens() {
/* 121 */     return MathUtils.floor((float)(this.mapPrice * getTotalBonus() * 0.01D) + (float)this.mapPrice);
/*     */   }
/*     */   
/*     */   public int getMaxPrestigeScore() {
/* 125 */     return getMaxPrestigeScore(this.averageDifficulty, this.noResearch);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getMaxPrestigeScore(int paramInt, boolean paramBoolean) {
/* 130 */     if (paramBoolean) {
/*     */       
/* 132 */       if ((paramInt = (int)((31800.0D / StrictMath.pow(paramInt, 1.1D) - 30.15D) * 1000.0D)) < 4000) paramInt = 4000; 
/* 133 */       if (paramInt > 400000) paramInt = 400000;
/*     */     
/*     */     } else {
/* 136 */       if ((paramInt = (int)((12000.0D / StrictMath.pow((paramInt - 11), 0.4D) - 807.0D) * 1000.0D)) < 150000) paramInt = 150000; 
/* 137 */       if (paramInt > 3000000) paramInt = 3000000; 
/*     */     } 
/* 139 */     if (paramInt > 1000000) {
/* 140 */       paramInt = (int)StrictMath.round(paramInt / 100000.0D) * 100000;
/* 141 */     } else if (paramInt > 100000) {
/* 142 */       paramInt = (int)StrictMath.round(paramInt / 10000.0D) * 10000;
/* 143 */     } else if (paramInt > 10000) {
/* 144 */       paramInt = (int)StrictMath.round(paramInt / 1000.0D) * 1000;
/*     */     } else {
/* 146 */       paramInt = (int)StrictMath.round(paramInt / 100.0D) * 100;
/*     */     } 
/*     */     
/* 149 */     return paramInt;
/*     */   }
/*     */   
/*     */   public String describe() {
/* 153 */     return "  Crowns: " + getCrownsCount() + "\n  Score multiplier: " + 
/* 154 */       getScoreMultiplier() + " (" + StringFormatter.commaSeparatedNumber(this.score) + " / " + StringFormatter.commaSeparatedNumber(getMaxPrestigeScore()) + ")\n  Difficulty bonus: " + 
/* 155 */       getDifficultyBonus() + " (" + this.averageDifficulty + "%)\n  Map price: " + this.mapPrice + "P, no abilities: " + this.noAbilities + ", no research: " + this.noResearch + ", walkable platforms: " + this.walkablePlatforms + ", no bounty: " + this.noBounty + ", no miners: " + this.noMiners + "\n  Final bonus: " + 
/*     */       
/* 157 */       getTotalBonus() + "%\n  Final Prestige tokens price: " + 
/* 158 */       getFinalPrestigeTokens() + "\n";
/*     */   }
/*     */   
/*     */   public void toJson(Json paramJson) {
/* 162 */     paramJson.writeValue("s", Long.valueOf(this.score));
/* 163 */     paramJson.writeValue("umi", this.userMapId);
/* 164 */     paramJson.writeValue("mp", Double.valueOf(this.mapPrice));
/* 165 */     paramJson.writeValue("ad", Integer.valueOf(this.averageDifficulty));
/* 166 */     paramJson.writeValue("na", Boolean.valueOf(this.noAbilities));
/* 167 */     paramJson.writeValue("nr", Boolean.valueOf(this.noResearch));
/* 168 */     paramJson.writeValue("wp", Boolean.valueOf(this.walkablePlatforms));
/* 169 */     paramJson.writeValue("nb", Boolean.valueOf(this.noBounty));
/* 170 */     paramJson.writeValue("nm", Boolean.valueOf(this.noMiners));
/*     */   }
/*     */   
/*     */   public static MapPrestigeConfig fromJson(JsonValue paramJsonValue) {
/* 174 */     return new MapPrestigeConfig(paramJsonValue
/* 175 */         .getString("umi"), paramJsonValue
/* 176 */         .getInt("mp"), paramJsonValue
/* 177 */         .getInt("ad"), paramJsonValue
/* 178 */         .getBoolean("na"), paramJsonValue
/* 179 */         .getBoolean("nr"), paramJsonValue
/* 180 */         .getBoolean("wp"), paramJsonValue
/* 181 */         .getBoolean("nb"), paramJsonValue
/* 182 */         .getBoolean("nm"), paramJsonValue
/* 183 */         .getInt("s"));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\MapPrestigeConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */