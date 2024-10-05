/*     */ package com.prineside.tdi2;
/*     */ 
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.b.o;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.tdi2.enums.RequirementType;
/*     */ import com.prineside.tdi2.enums.ResearchType;
/*     */ import com.prineside.tdi2.enums.StatisticsType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ 
/*     */ public class Requirement
/*     */ {
/*  20 */   private static final TLog a = TLog.forClass(Requirement.class);
/*     */   
/*     */   public RequirementType type;
/*  23 */   private static final String b = StringFormatter.toRGB(MaterialColor.ORANGE.P500).toString();
/*  24 */   private static final String c = StringFormatter.toRGB(Color.WHITE).toString();
/*     */ 
/*     */   
/*     */   public ResearchType researchType;
/*     */   
/*     */   public int researchLevel;
/*     */   
/*     */   public String levelName;
/*     */   
/*     */   public int levelStars;
/*     */   
/*     */   public String stageName;
/*     */   
/*     */   public int stageStars;
/*     */   
/*     */   public StatisticsType statisticsType;
/*     */   
/*     */   public double statisticsValue;
/*     */   
/*     */   public String openedLevelName;
/*     */   
/*  45 */   private static final StringBuilder d = new StringBuilder();
/*     */   
/*     */   public Requirement() {
/*  48 */     setType(RequirementType.ALL_TIME_STATISTIC);
/*     */   }
/*     */   
/*     */   public void setType(RequirementType paramRequirementType) {
/*  52 */     if (this.type == paramRequirementType)
/*     */       return; 
/*  54 */     this.type = paramRequirementType;
/*  55 */     switch (null.a[paramRequirementType.ordinal()]) {
/*     */       case 1:
/*  57 */         if (this.statisticsType == null) { this.statisticsType = StatisticsType.WIP; return; }
/*     */         
/*     */         break;
/*     */       case 2:
/*  61 */         if (this.openedLevelName == null) { this.openedLevelName = "0.1"; return; }
/*     */         
/*     */         break;
/*     */       case 3:
/*  65 */         if (this.stageName == null) { this.stageName = "1"; return; }
/*     */         
/*     */         break;
/*     */       case 4:
/*  69 */         if (this.levelName == null) { this.levelName = "0.1"; return; }
/*     */         
/*     */         break;
/*     */       case 5:
/*  73 */         if (this.researchType == null) this.researchType = ResearchType.ROOT;
/*     */         
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void toJson(Json paramJson) {
/*  82 */     paramJson.writeValue("type", this.type.name());
/*     */     
/*  84 */     switch (null.a[this.type.ordinal()]) {
/*     */       case 5:
/*  86 */         paramJson.writeValue("name", this.researchType.name());
/*  87 */         paramJson.writeValue("level", Integer.valueOf(this.researchLevel));
/*     */         return;
/*     */       
/*     */       case 4:
/*  91 */         paramJson.writeValue("level", this.levelName);
/*  92 */         paramJson.writeValue("amount", Integer.valueOf(this.levelStars));
/*     */         return;
/*     */       
/*     */       case 3:
/*  96 */         paramJson.writeValue("stage", this.stageName);
/*  97 */         paramJson.writeValue("amount", Integer.valueOf(this.stageStars));
/*     */         return;
/*     */       
/*     */       case 1:
/* 101 */         paramJson.writeValue("name", this.statisticsType.name());
/* 102 */         paramJson.writeValue("value", Double.valueOf(this.statisticsValue));
/*     */         return;
/*     */       
/*     */       case 2:
/* 106 */         paramJson.writeValue("level", this.openedLevelName);
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 113 */     return getClass().getSimpleName() + " (" + getTitle(false) + ": " + getFormattedValue() + ")";
/*     */   }
/*     */   
/*     */   public static Requirement fromJson(l paraml) {
/* 117 */     Requirement requirement = new Requirement();
/* 118 */     RequirementType requirementType = null;
/*     */     
/* 120 */     while (paraml.g() != o.c) {
/*     */       String str;
/*     */       
/* 123 */       switch (str = paraml.u()) {
/*     */         case "type":
/* 125 */           requirementType = RequirementType.valueOf(paraml.i());
/*     */           continue;
/*     */         
/*     */         case "name":
/* 129 */           if (requirementType == null) {
/* 130 */             throw new IllegalArgumentException("requirement type must come before field " + str);
/*     */           }
/* 132 */           switch (null.a[requirementType.ordinal()]) {
/*     */             case 5:
/* 134 */               requirement.researchType = ResearchType.valueOf(paraml.i());
/*     */               continue;
/*     */             
/*     */             case 1:
/* 138 */               requirement.statisticsType = StatisticsType.valueOf(paraml.i());
/*     */               continue;
/*     */           } 
/*     */           
/* 142 */           a.i("skip name for " + requirementType, new Object[0]);
/* 143 */           paraml.g();
/* 144 */           paraml.j();
/*     */           continue;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         case "level":
/* 151 */           if (requirementType == null) {
/* 152 */             throw new IllegalArgumentException("requirement type must come before field " + str);
/*     */           }
/* 154 */           switch (null.a[requirementType.ordinal()]) {
/*     */             case 5:
/* 156 */               requirement.researchLevel = paraml.b(0);
/*     */               continue;
/*     */             
/*     */             case 4:
/* 160 */               requirement.levelName = paraml.i();
/*     */               continue;
/*     */             
/*     */             case 2:
/* 164 */               requirement.openedLevelName = paraml.i();
/*     */               continue;
/*     */           } 
/*     */           
/* 168 */           a.i("skip level for " + requirementType, new Object[0]);
/* 169 */           paraml.g();
/* 170 */           paraml.j();
/*     */           continue;
/*     */ 
/*     */ 
/*     */         
/*     */         case "value":
/* 176 */           if (requirementType == null)
/* 177 */             throw new IllegalArgumentException("requirement type must come before field " + str); 
/* 178 */           if (requirementType == RequirementType.ALL_TIME_STATISTIC) {
/* 179 */             paraml.g();
/* 180 */             requirement.statisticsValue = paraml.K();
/*     */             continue;
/*     */           } 
/* 183 */           a.i("skip value for " + requirementType, new Object[0]);
/* 184 */           paraml.g();
/* 185 */           paraml.j();
/*     */ 
/*     */         
/*     */         case "amount":
/* 189 */           if (requirementType == null) {
/* 190 */             throw new IllegalArgumentException("requirement type must come before field " + str);
/*     */           }
/* 192 */           switch (null.a[requirementType.ordinal()]) {
/*     */             case 4:
/* 194 */               requirement.levelStars = paraml.b(0);
/*     */               continue;
/*     */             
/*     */             case 3:
/* 198 */               requirement.stageStars = paraml.b(0);
/*     */               continue;
/*     */           } 
/*     */           
/* 202 */           a.i("skip amount for " + requirementType, new Object[0]);
/* 203 */           paraml.g();
/* 204 */           paraml.j();
/*     */           continue;
/*     */ 
/*     */ 
/*     */         
/*     */         case "stage":
/* 210 */           if (requirementType == null)
/* 211 */             throw new IllegalArgumentException("requirement type must come before field " + str); 
/* 212 */           if (requirementType == RequirementType.STAGE_STARS) {
/* 213 */             requirement.stageName = paraml.i();
/*     */             continue;
/*     */           } 
/* 216 */           a.i("skip stage for " + requirementType, new Object[0]);
/* 217 */           paraml.g();
/* 218 */           paraml.j();
/*     */           break;
/*     */       } 
/*     */       
/* 222 */       a.i("skipped " + str, new Object[0]);
/* 223 */       paraml.g();
/* 224 */       paraml.j();
/*     */     } 
/*     */ 
/*     */     
/* 228 */     requirement.type = requirementType;
/*     */     
/* 230 */     return requirement;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Requirement fromJson(JsonValue paramJsonValue) {
/*     */     Requirement requirement;
/* 236 */     (requirement = new Requirement()).type = RequirementType.valueOf(paramJsonValue.getString("type"));
/* 237 */     switch (null.a[requirement.type.ordinal()]) {
/*     */ 
/*     */ 
/*     */       
/*     */       case 5:
/* 242 */         requirement.researchType = ResearchType.valueOf(paramJsonValue.getString("name"));
/* 243 */         requirement.researchLevel = paramJsonValue.getInt("level");
/*     */         break;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 4:
/* 250 */         requirement.levelName = paramJsonValue.getString("level");
/* 251 */         requirement.levelStars = paramJsonValue.getInt("amount");
/*     */         break;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 3:
/* 258 */         requirement.stageName = paramJsonValue.getString("stage");
/* 259 */         requirement.stageStars = paramJsonValue.getInt("amount");
/*     */         break;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 1:
/* 266 */         requirement.statisticsType = StatisticsType.valueOf(paramJsonValue.getString("name"));
/* 267 */         requirement.statisticsValue = paramJsonValue.getDouble("value");
/*     */         break;
/*     */ 
/*     */ 
/*     */       
/*     */       case 2:
/* 273 */         requirement.openedLevelName = paramJsonValue.getString("level");
/*     */         break;
/*     */     } 
/*     */ 
/*     */     
/* 278 */     return requirement; } public boolean isSatisfied() { BasicLevel basicLevel2;
/*     */     BasicLevelStage basicLevelStage;
/*     */     Research research;
/*     */     BasicLevel basicLevel1;
/* 282 */     switch (null.a[this.type.ordinal()]) {
/*     */       
/*     */       case 4:
/* 285 */         if ((basicLevel2 = Game.i.basicLevelManager.getLevel(this.levelName)) == null) return false;
/*     */         
/* 287 */         return (Game.i.basicLevelManager.getGainedStarsOnLevel(basicLevel2) >= this.levelStars);
/*     */       
/*     */       case 3:
/* 290 */         basicLevelStage = Game.i.basicLevelManager.getStage(this.stageName);
/* 291 */         return (Game.i.basicLevelManager.getGainedStarsOnStage(basicLevelStage) >= this.stageStars);
/*     */ 
/*     */       
/*     */       case 5:
/* 295 */         return ((research = Game.i.researchManager.getResearchInstance(this.researchType)).getInstalledLevel() >= this.researchLevel);
/*     */       
/*     */       case 1:
/* 298 */         return (Game.i.statisticsManager.getAllTime(this.statisticsType) >= this.statisticsValue);
/*     */ 
/*     */       
/*     */       case 2:
/* 302 */         if ((basicLevel1 = Game.i.basicLevelManager.getLevel(this.openedLevelName)) == null) return false;
/*     */         
/* 304 */         return Game.i.basicLevelManager.isOpened(basicLevel1);
/*     */     } 
/*     */ 
/*     */     
/* 308 */     return false; }
/*     */ 
/*     */   
/*     */   public String getIconTextureName() {
/* 312 */     switch (null.a[this.type.ordinal()]) { case 1:
/* 313 */         return "icon-statistics";
/* 314 */       case 5: return "icon-research";
/* 315 */       case 3: return "icon-star-stack";
/* 316 */       case 4: return "icon-star";
/* 317 */       case 2: return "icon-joystick"; }
/* 318 */      return "blank";
/*     */   } public StringBuilder getTitle(boolean paramBoolean) { TowerType towerType;
/*     */     Research research;
/*     */     BasicLevelStage basicLevelStage;
/*     */     BasicLevel basicLevel;
/* 323 */     d.setLength(0);
/*     */     
/* 325 */     switch (null.a[this.type.ordinal()]) {
/*     */       case 1:
/* 327 */         d.append(Game.i.statisticsManager.getStatisticsTitle(this.statisticsType));
/*     */         break;
/*     */ 
/*     */       
/*     */       case 5:
/* 332 */         towerType = (research = Game.i.researchManager.getResearchInstance(this.researchType)).isUnlocksTower() ? research.getRelatedToTowerType() : null;
/*     */         
/* 334 */         d.append(research.getTitle());
/* 335 */         if (towerType != null) {
/* 336 */           d.append(" (").append(Game.i.towerManager.getFactory(towerType).getTitle()).append(')');
/*     */         }
/*     */         break;
/*     */       
/*     */       case 3:
/* 341 */         basicLevelStage = Game.i.basicLevelManager.getStage(this.stageName);
/*     */         
/* 343 */         if (towerType != null) {
/* 344 */           d.append(Game.i.localeManager.i18n.format("requirement_title_STAGE_STARS_colored", new Object[] { StringFormatter.toRGB(basicLevelStage.color), basicLevelStage.name })); break;
/*     */         } 
/* 346 */         d.append(Game.i.localeManager.i18n.format("requirement_title_STAGE_STARS", new Object[] { basicLevelStage.name }));
/*     */         break;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 4:
/* 353 */         if ((basicLevel = Game.i.basicLevelManager.getLevel(this.levelName)) != null) {
/* 354 */           if (towerType != null) {
/* 355 */             d.append(Game.i.localeManager.i18n.format("requirement_title_STARS_colored", new Object[] { StringFormatter.toRGB((Game.i.basicLevelManager.getStage(basicLevel.stageName)).color), basicLevel.name })); break;
/*     */           } 
/* 357 */           d.append(Game.i.localeManager.i18n.format("requirement_title_STARS", new Object[] { basicLevel.name }));
/*     */         } 
/*     */         break;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 2:
/* 365 */         if ((basicLevel = Game.i.basicLevelManager.getLevel(this.openedLevelName)) != null) {
/* 366 */           if (towerType != null) {
/* 367 */             d.append(Game.i.localeManager.i18n.format("requirement_title_OPENED_LEVEL_colored", new Object[] { StringFormatter.toRGB((Game.i.basicLevelManager.getStage(basicLevel.stageName)).color), basicLevel.name })); break;
/*     */           } 
/* 369 */           d.append(Game.i.localeManager.i18n.format("requirement_title_OPENED_LEVEL", new Object[] { basicLevel.name }));
/*     */         } 
/*     */         break;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 377 */     return d; } public StringBuilder getFormattedValue() {
/*     */     double d;
/*     */     BasicLevel basicLevel;
/*     */     int i;
/* 381 */     d.setLength(0);
/* 382 */     switch (null.a[this.type.ordinal()]) {
/*     */       
/*     */       case 1:
/* 385 */         if ((d = Game.i.statisticsManager.getAllTime(this.statisticsType)) >= this.statisticsValue) {
/* 386 */           d = this.statisticsValue;
/* 387 */           d.append("[#").append(c).append("]");
/*     */         } else {
/* 389 */           d.append("[#").append(b).append("]");
/*     */         } 
/* 391 */         if (this.statisticsType == StatisticsType.PT || this.statisticsType == StatisticsType.PRT) {
/* 392 */           d.append(StringFormatter.digestTime((int)d))
/* 393 */             .append("[] / ")
/* 394 */             .append(StringFormatter.digestTime((int)this.statisticsValue)); break;
/*     */         } 
/* 396 */         d.append(StringFormatter.compactNumber(d, false)).append("[] / ").append(StringFormatter.compactNumber(this.statisticsValue, false));
/*     */         break;
/*     */ 
/*     */ 
/*     */       
/*     */       case 4:
/* 402 */         if ((basicLevel = Game.i.basicLevelManager.getLevel(this.levelName)) != null) {
/*     */           int j;
/* 404 */           if ((j = Game.i.basicLevelManager.getGainedStarsOnLevel(basicLevel)) >= this.levelStars) {
/* 405 */             j = this.levelStars;
/* 406 */             d.append("[#").append(c).append("]");
/*     */           } else {
/* 408 */             d.append("[#").append(b).append("]");
/*     */           } 
/* 410 */           d.append(j).append("[] / ").append(this.levelStars);
/*     */         } 
/*     */         break;
/*     */ 
/*     */       
/*     */       case 3:
/* 416 */         if ((i = Game.i.basicLevelManager.getGainedStarsOnStage(Game.i.basicLevelManager.getStage(this.stageName))) >= this.stageStars) {
/* 417 */           i = this.stageStars;
/* 418 */           d.append("[#").append(c).append("]");
/*     */         } else {
/* 420 */           d.append("[#").append(b).append("]");
/*     */         } 
/* 422 */         d.append(i).append("[] / ").append(this.stageStars);
/*     */         break;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 428 */     return d;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\Requirement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */