/*     */ package com.prineside.tdi2.managers.preferences.categories.progress;
/*     */ 
/*     */ import com.badlogic.gdx.math.RandomXS128;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonReader;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.JsonWriter;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.enums.CaseType;
/*     */ import com.prineside.tdi2.enums.DifficultyMode;
/*     */ import com.prineside.tdi2.managers.ProgressManager;
/*     */ import com.prineside.tdi2.managers.preferences.PrefMap;
/*     */ import com.prineside.tdi2.managers.preferences.PrefSubcategory;
/*     */ import com.prineside.tdi2.ui.shared.LuckyWheelOverlay;
/*     */ import com.prineside.tdi2.utils.FastRandom;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.io.StringWriter;
/*     */ 
/*     */ public final class PP_Progress
/*     */   implements PrefSubcategory {
/*  25 */   private static final TLog a = TLog.forClass(PP_Progress.class);
/*     */   
/*  27 */   private DifficultyMode b = DifficultyMode.NORMAL; private boolean c = false; private boolean d = false; private boolean e; private float f; private boolean g;
/*     */   private int h;
/*     */   private int i;
/*     */   private int j;
/*     */   private int k;
/*     */   private final RandomXS128 m;
/*     */   @Null
/*     */   private Array<LuckyWheelOverlay.WheelOption> n;
/*     */   private boolean o;
/*     */   private boolean p;
/*  37 */   private final RandomXS128[] l = new RandomXS128[CaseType.values.length]; private int q; private float r; private float s; private final RandomXS128 t;
/*     */   public PP_Progress() {
/*  39 */     for (byte b = 0; b < this.l.length; b++) {
/*  40 */       this.l[b] = new RandomXS128(b * 1023L);
/*     */     }
/*     */     
/*  43 */     this.m = new RandomXS128(1025L);
/*     */ 
/*     */ 
/*     */     
/*  47 */     this.q = 1;
/*     */ 
/*     */     
/*  50 */     this.t = new RandomXS128();
/*  51 */     this.u = new RandomXS128();
/*  52 */     this.v = new IntArray();
/*  53 */     this.w = 207;
/*  54 */     this.x = Game.getTimestampSeconds();
/*  55 */     this.y = FastRandom.getDistinguishableString(12, null);
/*     */   }
/*     */   private final RandomXS128 u; private final IntArray v; private int w; private int x; private String y; @Null
/*     */   private Array<ProgressManager.ShopOffer> z; private int A; private boolean B;
/*     */   
/*     */   public final boolean isCurrentShopOffersAreAfterSkip() {
/*  61 */     return this.B;
/*     */   }
/*     */   
/*     */   public final synchronized void setCurrentShopOffersAreAfterSkip(boolean paramBoolean) {
/*  65 */     this.B = paramBoolean;
/*     */   }
/*     */   
/*     */   public final int getPlayTimeUntilShopOffersUpdate() {
/*  69 */     return this.A;
/*     */   }
/*     */   
/*     */   public final synchronized void setPlayTimeUntilShopOffersUpdate(int paramInt) {
/*  73 */     this.A = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Null
/*     */   public final Array<ProgressManager.ShopOffer> getShopOffers() {
/*  80 */     return this.z;
/*     */   }
/*     */   
/*     */   public final synchronized void setShopOffers(@Null Array<ProgressManager.ShopOffer> paramArray) {
/*  84 */     this.z = paramArray;
/*     */   }
/*     */   
/*     */   public final String getGameStartHash() {
/*  88 */     return this.y;
/*     */   }
/*     */   
/*     */   public final int getGameStartTimestamp() {
/*  92 */     return this.x;
/*     */   }
/*     */   
/*     */   public final int getGameStartGameVersion() {
/*  96 */     return this.w;
/*     */   }
/*     */   
/*     */   public final boolean isConditionalCompensationHandled(int paramInt) {
/* 100 */     return this.v.contains(paramInt);
/*     */   }
/*     */   
/*     */   public final synchronized void addHandledConditionalCompensation(int paramInt) {
/* 104 */     if (!this.v.contains(paramInt)) {
/* 105 */       this.v.add(paramInt);
/*     */     }
/*     */   }
/*     */   
/*     */   public final RandomXS128 getLuckyWheelSpinRandom() {
/* 110 */     return this.u;
/*     */   }
/*     */   
/*     */   public final RandomXS128 getLuckyWheelWheelRandom() {
/* 114 */     return this.t;
/*     */   }
/*     */   
/*     */   public final float getLuckyWheelLastWeaponAngle() {
/* 118 */     return this.s;
/*     */   }
/*     */   
/*     */   public final void setLuckyWheelLastWeaponAngle(float paramFloat) {
/* 122 */     this.s = paramFloat;
/*     */   }
/*     */   
/*     */   public final float getLuckyWheelLastRotation() {
/* 126 */     return this.r;
/*     */   }
/*     */   
/*     */   public final void setLuckyWheelLastRotation(float paramFloat) {
/* 130 */     this.r = paramFloat;
/*     */   }
/*     */   
/*     */   public final int getLuckyWheelCurrentMultiplier() {
/* 134 */     return this.q;
/*     */   }
/*     */   
/*     */   public final void setLuckyWheelCurrentMultiplier(int paramInt) {
/* 138 */     this.q = paramInt;
/*     */   }
/*     */   
/*     */   public final boolean isLuckyWheelSpinInProgress() {
/* 142 */     return this.p;
/*     */   }
/*     */   
/*     */   public final synchronized void setLuckyWheelSpinInProgress(boolean paramBoolean) {
/* 146 */     this.p = paramBoolean;
/*     */   }
/*     */   
/*     */   public final boolean isLuckyWheelSpinAvailable() {
/* 150 */     return this.o;
/*     */   }
/*     */   
/*     */   public final synchronized void setLuckyWheelSpinAvailable(boolean paramBoolean) {
/* 154 */     this.o = paramBoolean;
/*     */   }
/*     */   @Null
/*     */   public final Array<LuckyWheelOverlay.WheelOption> getLuckyWheelOptions() {
/* 158 */     return this.n;
/*     */   }
/*     */   
/*     */   public final synchronized void setLuckyWheelOptions(@Null Array<LuckyWheelOverlay.WheelOption> paramArray) {
/* 162 */     this.n = paramArray;
/*     */   }
/*     */   
/*     */   public final RandomXS128 getOtherItemsRandom() {
/* 166 */     return this.m;
/*     */   }
/*     */   
/*     */   public final RandomXS128 getCaseRandom(CaseType paramCaseType) {
/* 170 */     return this.l[paramCaseType.ordinal()];
/*     */   }
/*     */   
/*     */   public final int getTempDoubleGainStartDate() {
/* 174 */     return this.j;
/*     */   }
/*     */   
/*     */   public final synchronized void setTempDoubleGainStartDate(int paramInt) {
/* 178 */     this.j = paramInt;
/*     */   }
/*     */   
/*     */   public final int getTempDoubleGainEndDate() {
/* 182 */     return this.k;
/*     */   }
/*     */   
/*     */   public final synchronized void setTempDoubleGainEndDate(int paramInt) {
/* 186 */     this.k = paramInt;
/*     */   }
/*     */   
/*     */   public final synchronized void registerVideoWatched() {
/* 190 */     this.h++;
/* 191 */     this.i++;
/*     */   }
/*     */   
/*     */   public final int getVideosWatchedForDoubleGain() {
/* 195 */     return this.h;
/*     */   }
/*     */   
/*     */   public final synchronized void setVideosWatchedForDoubleGain(int paramInt) {
/* 199 */     this.h = paramInt;
/*     */   }
/*     */   
/*     */   public final int getVideosWatchedForLuckyShot() {
/* 203 */     return this.i;
/*     */   }
/*     */   
/*     */   public final synchronized void setVideosWatchedForLuckyShot(int paramInt) {
/* 207 */     this.i = paramInt;
/*     */   }
/*     */   
/*     */   public final boolean isMidGameDgRewardGiven() {
/* 211 */     return this.g;
/*     */   }
/*     */   
/*     */   public final synchronized void setMidGameDgRewardGiven(boolean paramBoolean) {
/* 215 */     this.g = paramBoolean;
/*     */   }
/*     */   
/*     */   public final float getLootBoostTimeLeft() {
/* 219 */     return this.f;
/*     */   }
/*     */   
/*     */   public final synchronized void setLootBoostTimeLeft(float paramFloat) {
/* 223 */     this.f = paramFloat;
/*     */   }
/*     */   
/*     */   public final boolean isSteamRewardReceived() {
/* 227 */     return this.d;
/*     */   }
/*     */   
/*     */   public final synchronized void setSteamRewardReceived(boolean paramBoolean) {
/* 231 */     this.d = paramBoolean;
/*     */   }
/*     */   
/*     */   public final boolean isDoubleGainEnabled() {
/* 235 */     return this.c;
/*     */   }
/*     */   
/*     */   public final synchronized void setDoubleGainEnabled(boolean paramBoolean) {
/* 239 */     this.c = paramBoolean;
/*     */   }
/*     */   
/*     */   public final DifficultyMode getDifficultyMode() {
/* 243 */     return this.b;
/*     */   }
/*     */   
/*     */   public final synchronized void setDifficultyMode(DifficultyMode paramDifficultyMode) {
/* 247 */     this.b = paramDifficultyMode;
/*     */   }
/*     */   
/*     */   public final boolean isBonusGivenForRegByInvite() {
/* 251 */     return this.e;
/*     */   }
/*     */   
/*     */   public final synchronized void setBonusGivenForRegByInvite(boolean paramBoolean) {
/* 255 */     this.e = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public final synchronized void load(PrefMap paramPrefMap) {
/* 260 */     this.b = DifficultyMode.NORMAL;
/* 261 */     this.c = false;
/* 262 */     this.d = false;
/* 263 */     this.e = false;
/* 264 */     this.f = 0.0F;
/* 265 */     this.g = false;
/* 266 */     this.h = 0;
/* 267 */     this.i = 0;
/* 268 */     this.j = 0;
/* 269 */     this.k = 0;
/* 270 */     this.n = null;
/* 271 */     this.o = false;
/* 272 */     this.p = false;
/* 273 */     this.q = 1;
/* 274 */     this.v.clear();
/* 275 */     this.w = 207;
/* 276 */     this.x = Game.getTimestampSeconds();
/* 277 */     this.y = FastRandom.getDistinguishableString(12, null);
/* 278 */     this.A = 0;
/* 279 */     this.B = false;
/* 280 */     this.z = null;
/*     */     
/*     */     String str1;
/* 283 */     if ((str1 = paramPrefMap.get("gameStartGameVersion", null)) != null) {
/*     */       try {
/* 285 */         this.w = Integer.parseInt(str1);
/* 286 */       } catch (Exception exception) {
/* 287 */         a.e("failed to load gameStartGameVersion from " + str1 + ", using default", new Object[0]);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 292 */     if ((str1 = paramPrefMap.get("gameStartTimestamp", null)) != null) {
/*     */       try {
/* 294 */         this.x = Integer.parseInt(str1);
/* 295 */       } catch (Exception exception) {
/* 296 */         a.e("failed to load gameStartTimestamp from " + str1 + ", using default", new Object[0]);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 301 */     if ((str1 = paramPrefMap.get("gameStartHash", null)) == null || str1.length() < 4 || str1.length() > 16) {
/* 302 */       a.e("failed to load gameStartHash from " + str1 + ", using default", new Object[0]);
/*     */     } else {
/* 304 */       this.y = str1;
/*     */     } 
/*     */ 
/*     */     
/* 308 */     this.c = paramPrefMap.get("doubleGainEnabled", "false").equals("true");
/* 309 */     if (!Config.isHeadless()) a.i("Double gain " + (this.c ? "enabled" : "disabled") + " by preferences", new Object[0]);
/*     */     
/* 311 */     this.d = paramPrefMap.get("steamRewardReceived", "false").equals("true");
/* 312 */     if (!Config.isHeadless()) a.i("Steam reward " + (this.d ? "received" : "not received") + " according to preferences", new Object[0]);
/*     */ 
/*     */     
/*     */     try {
/* 316 */       int i = Game.getTimestampSeconds();
/* 317 */       this.j = Integer.parseInt(paramPrefMap.get("tempDoubleGainStartDate", "0"));
/* 318 */       this.k = Integer.parseInt(paramPrefMap.get("tempDoubleGainEndDate", "0"));
/* 319 */       if (i < this.j || i > this.k) {
/*     */         
/* 321 */         this.j = 0;
/* 322 */         this.k = 0;
/*     */       } 
/* 324 */     } catch (Exception exception) {
/* 325 */       a.e("failed to load temp double gain", new Object[] { exception });
/*     */     } 
/*     */     
/* 328 */     this.e = paramPrefMap.get("bonusGivenForRegByInvite", "false").equals("true");
/*     */     
/* 330 */     if ((str1 = paramPrefMap.get("difficultyMode", null)) != null) {
/*     */       try {
/* 332 */         this.b = DifficultyMode.valueOf(str1);
/* 333 */       } catch (Exception exception) {
/* 334 */         this.b = DifficultyMode.NORMAL;
/*     */       } 
/*     */     }
/* 337 */     a.i("difficulty mode: " + this.b, new Object[0]);
/*     */     
/*     */     try {
/* 340 */       this.f = Float.parseFloat(paramPrefMap.get("lootBoostTimeLeft", "0"));
/* 341 */     } catch (Exception exception) {
/* 342 */       a.e("failed to load lootBoostTimeLeft", new Object[] { exception });
/*     */     } 
/*     */     try {
/* 345 */       this.g = paramPrefMap.get("midGameDgRewardGiven", "false").equals("true");
/* 346 */     } catch (Exception exception) {
/* 347 */       a.e("failed to load midGameDgRewardGiven", new Object[] { exception });
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 352 */     if ((str1 = paramPrefMap.get("caseRandoms", null)) != null) {
/*     */       try {
/*     */         JsonValue jsonValue;
/* 355 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = (new JsonReader()).parse(str1)).iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/*     */           try {
/* 357 */             CaseType caseType = CaseType.valueOf(jsonValue1.getString("type"));
/* 358 */             this.l[caseType.ordinal()].setState(jsonValue1.getLong("stateA"), jsonValue1.getLong("stateB"));
/* 359 */           } catch (Exception exception) {
/* 360 */             a.e("failed to load case random", new Object[] { exception });
/*     */           }
/*     */            }
/*     */       
/* 364 */       } catch (Exception exception) {
/* 365 */         a.e("failed to load case randoms", new Object[] { exception });
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 371 */     if ((str1 = paramPrefMap.get("otherItemsRandom", null)) != null) {
/*     */       try {
/*     */         try {
/* 374 */           JsonValue jsonValue = (new JsonReader()).parse(str1);
/* 375 */           this.m.setState(jsonValue.getLong("stateA"), jsonValue.getLong("stateB"));
/* 376 */         } catch (Exception exception) {
/* 377 */           a.e("failed to load other items random", new Object[] { exception });
/*     */         } 
/* 379 */       } catch (Exception exception) {
/* 380 */         a.e("failed to load other items random", new Object[] { exception });
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 386 */     if ((str1 = paramPrefMap.get("luckyWheelOptions", null)) != null) {
/*     */       try {
/* 388 */         JsonValue jsonValue = (new JsonReader()).parse(str1);
/* 389 */         Array<LuckyWheelOverlay.WheelOption> array = new Array(LuckyWheelOverlay.WheelOption.class);
/* 390 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue.iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/* 391 */           array.add(LuckyWheelOverlay.WheelOption.fromJson(jsonValue1)); }
/*     */         
/* 393 */         this.n = array;
/* 394 */       } catch (Exception exception) {
/* 395 */         a.e("failed to load luckyWheelOptions", new Object[] { exception });
/*     */       } 
/*     */     }
/*     */     try {
/* 399 */       this.o = paramPrefMap.get("luckyWheelSpinAvailable", "false").equals("true");
/* 400 */       this.p = paramPrefMap.get("luckyWheelSpinInProgress", "false").equals("true");
/* 401 */       this.q = Integer.parseInt(paramPrefMap.get("luckyWheelCurrentMultiplier", "1"));
/* 402 */       this.r = Float.parseFloat(paramPrefMap.get("luckyWheelLastRotation", "0"));
/* 403 */       this.s = Float.parseFloat(paramPrefMap.get("luckyWheelLastWeaponAngle", "0"));
/*     */       
/* 405 */       long l1 = -1L, l2 = -1L;
/*     */       try {
/* 407 */         l1 = Long.parseLong(paramPrefMap.get("luckyWheelWR1", "-1"));
/* 408 */         l2 = Long.parseLong(paramPrefMap.get("luckyWheelWR2", "-1"));
/* 409 */       } catch (Exception exception) {
/* 410 */         a.e("failed to load lucky spin wheel seeds", new Object[0]);
/*     */       } 
/* 412 */       if (l1 == -1L || l2 == -1L) {
/* 413 */         l1 = FastRandom.random.nextInt();
/* 414 */         l2 = FastRandom.random.nextInt();
/*     */       } 
/* 416 */       this.t.setState(l1, l2);
/*     */       
/* 418 */       l1 = -1L;
/* 419 */       l2 = -1L;
/*     */       try {
/* 421 */         l1 = Long.parseLong(paramPrefMap.get("luckyWheelSR1", "-1"));
/* 422 */         l2 = Long.parseLong(paramPrefMap.get("luckyWheelSR2", "-1"));
/* 423 */       } catch (Exception exception) {
/* 424 */         a.e("failed to load lucky spin handle seeds", new Object[0]);
/*     */       } 
/* 426 */       if (l1 == -1L || l2 == -1L) {
/* 427 */         l1 = FastRandom.random.nextInt();
/* 428 */         l2 = FastRandom.random.nextInt();
/*     */       } 
/* 430 */       this.u.setState(l1, l2);
/* 431 */     } catch (Exception exception) {
/* 432 */       a.e("failed to load lucky wheel status", new Object[] { exception });
/*     */     } 
/*     */     
/*     */     String str2;
/*     */     
/* 437 */     if ((str2 = paramPrefMap.get("handledConditionalCompensations", null)) != null) {
/*     */       try {
/*     */         JsonValue jsonValue;
/* 440 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = (new JsonReader()).parse(str2)).iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/* 441 */           this.v.add(jsonValue1.asInt()); }
/*     */       
/* 443 */       } catch (Exception exception) {
/* 444 */         a.e("failed to load handledConditionalCompensations, marking all as completed", new Object[] { exception }); byte b; ProgressManager.ConditionalCompensation[] arrayOfConditionalCompensation; int i;
/* 445 */         for (i = (arrayOfConditionalCompensation = ProgressManager.CONDITIONAL_COMPENSATIONS).length, b = 0; b < i; ) { ProgressManager.ConditionalCompensation conditionalCompensation = arrayOfConditionalCompensation[b];
/* 446 */           this.v.add(conditionalCompensation.id);
/*     */           
/*     */           b++; }
/*     */       
/*     */       } 
/*     */     }
/*     */     try {
/* 453 */       this.i = Integer.parseInt(paramPrefMap.get("videosWatchedForLuckyShot", "0"));
/* 454 */       this.h = Integer.parseInt(paramPrefMap.get("videosWatchedForDoubleGain", "0"));
/* 455 */     } catch (Exception exception) {
/* 456 */       a.e("failed to load videos stats", new Object[] { exception });
/*     */     } 
/*     */     
/*     */     try {
/* 460 */       this.A = Integer.parseInt(paramPrefMap.get("playTimeUntilShopOffersUpdate", "0"));
/* 461 */     } catch (Exception exception) {
/* 462 */       a.e("failed to load playTimeUntilShopOffersUpdate", new Object[] { exception });
/*     */     } 
/*     */     
/*     */     try {
/* 466 */       this.B = Boolean.parseBoolean(paramPrefMap.get("currentShopOffersAreAfterSkip", "false"));
/* 467 */     } catch (Exception exception) {
/* 468 */       a.e("failed to load currentShopOffersAreAfterSkip", new Object[] { exception });
/*     */     } 
/*     */     
/*     */     try {
/*     */       String str;
/* 473 */       if ((str = paramPrefMap.get("shopOffers", null)) != null) {
/* 474 */         JsonValue jsonValue = (new JsonReader()).parse(str);
/* 475 */         Array<ProgressManager.ShopOffer> array = new Array(true, 1, ProgressManager.ShopOffer.class);
/* 476 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue.iterator(); jsonIterator.hasNext(); ) {
/* 477 */           JsonValue jsonValue1; ProgressManager.ShopOffer shopOffer = ProgressManager.ShopOffer.fromJson(jsonValue1 = jsonIterator.next());
/* 478 */           array.add(shopOffer);
/*     */         } 
/* 480 */         this.z = array;
/*     */       }  return;
/* 482 */     } catch (Exception exception) {
/* 483 */       a.e("failed to load shopOffers", new Object[] { exception });
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   public final synchronized void save(PrefMap paramPrefMap) {
/* 489 */     paramPrefMap.set("difficultyMode", this.b.name());
/* 490 */     if (this.c) paramPrefMap.set("doubleGainEnabled", "true"); 
/* 491 */     if (this.d) paramPrefMap.set("steamRewardReceived", "true"); 
/* 492 */     if (this.e) paramPrefMap.set("bonusGivenForRegByInvite", "true"); 
/* 493 */     if (this.f > 0.0F) paramPrefMap.set("lootBoostTimeLeft", String.valueOf(this.f)); 
/* 494 */     if (this.g) paramPrefMap.set("midGameDgRewardGiven", "true"); 
/* 495 */     if (this.h != 0) paramPrefMap.set("videosWatchedForDoubleGain", String.valueOf(this.h)); 
/* 496 */     if (this.i != 0) paramPrefMap.set("videosWatchedForLuckyShot", String.valueOf(this.i)); 
/* 497 */     if (this.j != 0) paramPrefMap.set("tempDoubleGainStartDate", String.valueOf(this.j)); 
/* 498 */     if (this.k != 0) paramPrefMap.set("tempDoubleGainEndDate", String.valueOf(this.k)); 
/* 499 */     paramPrefMap.set("gameStartGameVersion", String.valueOf(this.w));
/* 500 */     paramPrefMap.set("gameStartTimestamp", String.valueOf(this.x));
/* 501 */     paramPrefMap.set("gameStartHash", this.y);
/*     */ 
/*     */     
/* 504 */     Json json = new Json(JsonWriter.OutputType.minimal);
/* 505 */     StringWriter stringWriter = new StringWriter();
/* 506 */     json.setWriter(stringWriter);
/* 507 */     json.writeArrayStart(); CaseType[] arrayOfCaseType; int i; byte b2;
/* 508 */     for (i = (arrayOfCaseType = CaseType.values).length, b2 = 0; b2 < i; ) { CaseType caseType = arrayOfCaseType[b2];
/* 509 */       json.writeObjectStart();
/* 510 */       json.writeValue("type", caseType.name());
/* 511 */       json.writeValue("stateA", Long.valueOf(this.l[caseType.ordinal()].getState(0)));
/* 512 */       json.writeValue("stateB", Long.valueOf(this.l[caseType.ordinal()].getState(1)));
/* 513 */       json.writeObjectEnd(); b2++; }
/*     */     
/* 515 */     json.writeArrayEnd();
/* 516 */     paramPrefMap.set("caseRandoms", stringWriter.toString());
/*     */     
/* 518 */     json = new Json(JsonWriter.OutputType.minimal);
/* 519 */     stringWriter = new StringWriter();
/* 520 */     json.setWriter(stringWriter);
/* 521 */     json.writeObjectStart();
/* 522 */     json.writeValue("stateA", Long.valueOf(this.m.getState(0)));
/* 523 */     json.writeValue("stateB", Long.valueOf(this.m.getState(1)));
/* 524 */     json.writeObjectEnd();
/* 525 */     paramPrefMap.set("otherItemsRandom", stringWriter.toString());
/*     */ 
/*     */     
/* 528 */     if (this.n != null) {
/* 529 */       json = new Json(JsonWriter.OutputType.minimal);
/* 530 */       stringWriter = new StringWriter();
/* 531 */       json.setWriter(stringWriter);
/* 532 */       json.writeArrayStart();
/* 533 */       for (byte b = 0; b < this.n.size; b++) {
/* 534 */         json.writeObjectStart();
/* 535 */         ((LuckyWheelOverlay.WheelOption[])this.n.items)[b].toJson(json);
/* 536 */         json.writeObjectEnd();
/*     */       } 
/* 538 */       json.writeArrayEnd();
/* 539 */       paramPrefMap.set("luckyWheelOptions", stringWriter.toString());
/*     */     } 
/*     */     
/* 542 */     if (this.o) paramPrefMap.set("luckyWheelSpinAvailable", "true"); 
/* 543 */     if (this.p) paramPrefMap.set("luckyWheelSpinInProgress", "true"); 
/* 544 */     paramPrefMap.set("luckyWheelCurrentMultiplier", String.valueOf(this.q));
/* 545 */     paramPrefMap.set("luckyWheelLastRotation", String.valueOf(this.r));
/* 546 */     paramPrefMap.set("luckyWheelLastWeaponAngle", String.valueOf(this.s));
/*     */     
/* 548 */     paramPrefMap.set("luckyWheelWR1", String.valueOf(this.t.getState(0)));
/* 549 */     paramPrefMap.set("luckyWheelWR2", String.valueOf(this.t.getState(1)));
/* 550 */     paramPrefMap.set("luckyWheelSR1", String.valueOf(this.u.getState(0)));
/* 551 */     paramPrefMap.set("luckyWheelSR2", String.valueOf(this.u.getState(1)));
/*     */ 
/*     */     
/* 554 */     if (this.v.size != 0) {
/* 555 */       json = new Json(JsonWriter.OutputType.minimal);
/* 556 */       stringWriter = new StringWriter();
/* 557 */       json.setWriter(stringWriter);
/* 558 */       json.writeArrayStart();
/* 559 */       for (byte b = 0; b < this.v.size; b++) {
/* 560 */         json.writeValue(Integer.valueOf(this.v.items[b]));
/*     */       }
/* 562 */       json.writeArrayEnd();
/* 563 */       paramPrefMap.set("handledConditionalCompensations", stringWriter.toString());
/*     */     } 
/*     */     
/* 566 */     paramPrefMap.set("playTimeUntilShopOffersUpdate", String.valueOf(this.A));
/* 567 */     if (this.B) {
/* 568 */       paramPrefMap.set("currentShopOffersAreAfterSkip", "true");
/*     */     }
/* 570 */     if (this.z == null || this.z.size == 0) {
/* 571 */       paramPrefMap.set("shopOffers", null); return;
/*     */     } 
/* 573 */     json = new Json(JsonWriter.OutputType.minimal);
/* 574 */     stringWriter = new StringWriter();
/* 575 */     json.setWriter(stringWriter);
/* 576 */     json.writeArrayStart();
/* 577 */     for (byte b1 = 0; b1 < this.z.size; b1++) {
/*     */       ProgressManager.ShopOffer shopOffer;
/* 579 */       if ((shopOffer = (ProgressManager.ShopOffer)this.z.get(b1)) != null) {
/* 580 */         json.writeObjectStart();
/* 581 */         ((ProgressManager.ShopOffer)this.z.get(b1)).toJson(json);
/* 582 */         json.writeObjectEnd();
/*     */       } 
/*     */     } 
/* 585 */     json.writeArrayEnd();
/* 586 */     paramPrefMap.set("shopOffers", stringWriter.toString());
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\preferences\categories\progress\PP_Progress.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */