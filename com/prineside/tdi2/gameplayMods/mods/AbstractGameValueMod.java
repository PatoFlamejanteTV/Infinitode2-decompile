/*     */ package com.prineside.tdi2.gameplayMods.mods;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.GameValueConfig;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayMod;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayModCategory;
/*     */ import com.prineside.tdi2.gameplayMods.GenericGameplayMod;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.systems.GameplayModSystem;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @REGS(classOnly = true)
/*     */ public abstract class AbstractGameValueMod extends GenericGameplayMod {
/*  26 */   private static final TLog a = TLog.forClass(AbstractGameValueMod.class);
/*     */   
/*     */   @NAGS
/*     */   private String b;
/*     */   public GameValueType gvType;
/*  31 */   public GameplayModCategory mainCategory = GameplayModCategory.OTHER;
/*  32 */   public GameplayModCategory additionalCategory = null;
/*     */   
/*     */   public float baseValue;
/*     */   public float deltaPerPower;
/*     */   public boolean roundToInt;
/*     */   public boolean isFinalMultiplier;
/*     */   @Null
/*     */   private GameSystemProvider c;
/*     */   @Null
/*     */   private GameValueConfig d;
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  44 */     super.write(paramKryo, paramOutput);
/*  45 */     paramKryo.writeObject(paramOutput, this.gvType);
/*  46 */     paramKryo.writeObject(paramOutput, this.mainCategory);
/*  47 */     paramKryo.writeObjectOrNull(paramOutput, this.additionalCategory, GameplayModCategory.class);
/*  48 */     paramOutput.writeFloat(this.baseValue);
/*  49 */     paramOutput.writeFloat(this.deltaPerPower);
/*  50 */     paramOutput.writeBoolean(this.roundToInt);
/*  51 */     paramOutput.writeBoolean(this.isFinalMultiplier);
/*  52 */     paramKryo.writeObjectOrNull(paramOutput, this.c, GameSystemProvider.class);
/*  53 */     paramKryo.writeObjectOrNull(paramOutput, this.d, GameValueConfig.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  58 */     super.read(paramKryo, paramInput);
/*  59 */     this.gvType = (GameValueType)paramKryo.readObject(paramInput, GameValueType.class);
/*  60 */     this.mainCategory = (GameplayModCategory)paramKryo.readObject(paramInput, GameplayModCategory.class);
/*  61 */     this.additionalCategory = (GameplayModCategory)paramKryo.readObjectOrNull(paramInput, GameplayModCategory.class);
/*  62 */     this.baseValue = paramInput.readFloat();
/*  63 */     this.deltaPerPower = paramInput.readFloat();
/*  64 */     this.roundToInt = paramInput.readBoolean();
/*  65 */     this.isFinalMultiplier = paramInput.readBoolean();
/*  66 */     this.c = (GameSystemProvider)paramKryo.readObjectOrNull(paramInput, GameSystemProvider.class);
/*  67 */     this.d = (GameValueConfig)paramKryo.readObjectOrNull(paramInput, GameValueConfig.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AbstractGameValueMod(GameValueType paramGameValueType) {
/*  73 */     Preconditions.checkNotNull(paramGameValueType, "gvType can not be null");
/*  74 */     this.gvType = paramGameValueType;
/*     */   }
/*     */   
/*     */   public AbstractGameValueMod(GameValueType paramGameValueType, float paramFloat1, float paramFloat2, boolean paramBoolean, GameplayModCategory paramGameplayModCategory1, @Null GameplayModCategory paramGameplayModCategory2) {
/*  78 */     Preconditions.checkNotNull(paramGameValueType, "gvType can not be null");
/*  79 */     this.gvType = paramGameValueType;
/*  80 */     this.deltaPerPower = paramFloat2;
/*  81 */     this.baseValue = paramFloat1;
/*  82 */     this.roundToInt = paramBoolean;
/*  83 */     this.mainCategory = paramGameplayModCategory1;
/*  84 */     this.additionalCategory = paramGameplayModCategory2;
/*     */   }
/*     */ 
/*     */   
/*     */   public Drawable getIcon() {
/*  89 */     return (Drawable)Game.i.gameValueManager.getStockValueConfig(this.gvType).createIconForBackground(new Color(454761471));
/*     */   }
/*     */   
/*     */   private float a() {
/*  93 */     float f = this.baseValue + this.deltaPerPower * this.power;
/*  94 */     if (this.roundToInt) {
/*  95 */       if (f < 0.0F) {
/*  96 */         f = -((int)-f);
/*     */       } else {
/*  98 */         f = (int)f;
/*     */       } 
/*     */     }
/*     */     
/* 102 */     return f;
/*     */   }
/*     */ 
/*     */   
/*     */   public AbstractGameValueMod applyConfig(JsonValue paramJsonValue) {
/* 107 */     super.applyConfig(paramJsonValue);
/*     */     String str;
/* 109 */     if ((str = paramJsonValue.getString("gvType", null)) != null) {
/*     */       try {
/* 111 */         this.gvType = GameValueType.valueOf(str);
/* 112 */       } catch (Exception exception) {
/* 113 */         a.e("failed to read gvType from config", new Object[] { exception });
/*     */       } 
/*     */     }
/* 116 */     this.deltaPerPower = paramJsonValue.getFloat("deltaPerPower", this.deltaPerPower);
/* 117 */     this.baseValue = paramJsonValue.getFloat("baseValue", this.baseValue);
/* 118 */     this.roundToInt = paramJsonValue.getBoolean("roundToInt", this.roundToInt);
/* 119 */     this.isFinalMultiplier = paramJsonValue.getBoolean("isFinalMultiplier", this.isFinalMultiplier);
/* 120 */     this.b = null;
/*     */     
/* 122 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getDescription() {
/* 127 */     if (this.isFinalMultiplier) {
/* 128 */       return Game.i.gameValueManager.getTitle(this.gvType) + " [#8BC34A]x" + StringFormatter.compactNumberWithPrecisionTrimZeros(a(), 2, true) + "[]";
/*     */     }
/* 130 */     return (CharSequence)Game.i.gameValueManager.formatEffectTitleValue(a(), this.gvType);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void a(GenericGameplayMod paramGenericGameplayMod) {
/* 136 */     paramGenericGameplayMod = paramGenericGameplayMod;
/* 137 */     super.a(paramGenericGameplayMod);
/* 138 */     ((AbstractGameValueMod)paramGenericGameplayMod).b = this.b;
/* 139 */     ((AbstractGameValueMod)paramGenericGameplayMod).gvType = this.gvType;
/* 140 */     ((AbstractGameValueMod)paramGenericGameplayMod).deltaPerPower = this.deltaPerPower;
/* 141 */     ((AbstractGameValueMod)paramGenericGameplayMod).baseValue = this.baseValue;
/* 142 */     ((AbstractGameValueMod)paramGenericGameplayMod).roundToInt = this.roundToInt;
/* 143 */     ((AbstractGameValueMod)paramGenericGameplayMod).isFinalMultiplier = this.isFinalMultiplier;
/* 144 */     ((AbstractGameValueMod)paramGenericGameplayMod).mainCategory = this.mainCategory;
/* 145 */     ((AbstractGameValueMod)paramGenericGameplayMod).additionalCategory = this.additionalCategory;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean register(GameSystemProvider paramGameSystemProvider, String paramString) {
/* 150 */     this.c = paramGameSystemProvider;
/*     */     
/* 152 */     AbstractGameValueMod abstractGameValueMod = null;
/* 153 */     for (byte b = 0; b < (paramGameSystemProvider.gameplayMod.getActiveMods()).size; b++) {
/*     */       GameplayModSystem.ActiveMod activeMod; AbstractGameValueMod abstractGameValueMod1;
/*     */       GameplayMod gameplayMod;
/* 156 */       if (gameplayMod = (activeMod = (GameplayModSystem.ActiveMod)paramGameSystemProvider.gameplayMod.getActiveMods().get(b)).getMod() instanceof AbstractGameValueMod && activeMod.getSource().equals(paramString) && 
/*     */         
/* 158 */         (abstractGameValueMod1 = (AbstractGameValueMod)gameplayMod).d.getType() == this.gvType) {
/* 159 */         abstractGameValueMod = abstractGameValueMod1;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*     */     
/* 165 */     if (abstractGameValueMod == null) {
/* 166 */       this.d = new GameValueConfig(this.gvType, a(), false, true);
/* 167 */       if (this.isFinalMultiplier) {
/* 168 */         this.d.setFinalGlobalMultiplier(true);
/*     */       }
/* 170 */       paramGameSystemProvider.gameValue.addCustomGameValue(this.d);
/* 171 */       b();
/* 172 */       return true;
/*     */     } 
/* 174 */     abstractGameValueMod.setRegisteredPower(this.power);
/* 175 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public GameplayModCategory getCategory() {
/* 181 */     return this.mainCategory;
/*     */   }
/*     */ 
/*     */   
/*     */   public GameplayModCategory getAdditionalCategory() {
/* 186 */     return this.additionalCategory;
/*     */   }
/*     */   
/*     */   private void b() {
/* 190 */     this.d.setValue(a());
/* 191 */     this.c.gameValue.recalculate();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRegisteredPower(int paramInt) {
/* 196 */     this.power = Math.min(paramInt, getMaxPower());
/* 197 */     b();
/*     */   }
/*     */   
/*     */   protected AbstractGameValueMod() {}
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\mods\AbstractGameValueMod.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */