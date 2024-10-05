/*     */ package com.prineside.tdi2;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.enums.ResourceType;
/*     */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*     */ import com.prineside.tdi2.utils.REGS;
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
/*     */ @REGS(classOnly = true)
/*     */ public abstract class Ability
/*     */   extends Registrable
/*     */   implements KryoSerializable
/*     */ {
/*     */   private AbilityType b;
/*  37 */   protected float a = 1.0F;
/*     */ 
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  41 */     super.write(paramKryo, paramOutput);
/*  42 */     paramKryo.writeObjectOrNull(paramOutput, this.b, AbilityType.class);
/*  43 */     paramOutput.writeFloat(this.a);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  48 */     super.read(paramKryo, paramInput);
/*  49 */     this.b = (AbilityType)paramKryo.readObjectOrNull(paramInput, AbilityType.class);
/*  50 */     this.a = paramInput.readFloat();
/*     */   }
/*     */   
/*     */   protected Ability(AbilityType paramAbilityType) {
/*  54 */     this.b = paramAbilityType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AbilityType getType() {
/*  62 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void configure(int paramInt1, int paramInt2, double paramDouble);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean start() {
/*  84 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void startEffects() {
/*  93 */     a(1.5F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void update(float paramFloat);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean isDone();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onDone() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void draw(Batch paramBatch, float paramFloat);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawBatchAdditive(Batch paramBatch, float paramFloat) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float getKilledEnemiesCoinMultiplier() {
/* 138 */     return this.a;
/*     */   }
/*     */   protected final void a(float paramFloat) {
/* 141 */     if (this.S._gameUi != null && !this.S.gameState.isFastForwarding()) {
/*     */       Color color;
/* 143 */       (color = Game.i.abilityManager.getFactory(this.b).getColor().cpy()).a = 0.56F;
/* 144 */       this.S._gameUi.screenBorderGradient.flash(color, paramFloat);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static abstract class Factory<T extends Ability>
/*     */     implements EntityFactory
/*     */   {
/*     */     public final AbilityType abilityType;
/*     */ 
/*     */     
/*     */     private String a;
/*     */ 
/*     */     
/*     */     private String b;
/*     */ 
/*     */     
/*     */     private String c;
/*     */ 
/*     */ 
/*     */     
/*     */     public Factory(AbilityType param1AbilityType) {
/* 167 */       this.abilityType = param1AbilityType;
/*     */       
/* 169 */       this.a = "ability_name_" + param1AbilityType.name();
/* 170 */       this.b = "ability_name_fancy_" + param1AbilityType.name();
/* 171 */       this.c = "ability_description_" + param1AbilityType.name();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setup() {
/* 179 */       if (Game.i.assetManager != null)
/* 180 */         setupAssets(); 
/*     */     }
/*     */     public void setupAssets() {}
/*     */     public abstract T create();
/*     */     
/*     */     public abstract boolean requiresMapPointing();
/*     */     
/*     */     public abstract Color getColor();
/*     */     
/*     */     public abstract Color getDarkerColor();
/*     */     
/*     */     public CharSequence getTitle() {
/* 192 */       return Game.i.localeManager.i18n.get(this.a);
/*     */     }
/*     */     
/*     */     public CharSequence getFancyTitle() {
/* 196 */       return Game.i.localeManager.i18n.get(this.b);
/*     */     }
/*     */     
/*     */     public CharSequence getDescription(GameValueProvider param1GameValueProvider) {
/* 200 */       return Game.i.localeManager.i18n.get(this.c);
/*     */     }
/*     */     
/*     */     public abstract TextureRegionDrawable getIconDrawable();
/*     */     
/* 205 */     public int getPriceInGreenPapers(int param1Int) { return 0; } public int getPriceInResources(ResourceType param1ResourceType, int param1Int) {
/* 206 */       return 0;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\Ability.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */