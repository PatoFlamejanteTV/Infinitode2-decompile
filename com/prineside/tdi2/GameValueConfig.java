/*     */ package com.prineside.tdi2;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @REGS
/*     */ public final class GameValueConfig
/*     */   implements KryoSerializable
/*     */ {
/*     */   private GameValueType a;
/*     */   private double b;
/*     */   private boolean c;
/*     */   private boolean d;
/*     */   private boolean e;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  29 */     paramKryo.writeObject(paramOutput, this.a);
/*  30 */     paramOutput.writeDouble(this.b);
/*  31 */     paramOutput.writeBoolean(this.c);
/*  32 */     paramOutput.writeBoolean(this.d);
/*  33 */     paramOutput.writeBoolean(this.e);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  38 */     this.a = (GameValueType)paramKryo.readObject(paramInput, GameValueType.class);
/*  39 */     this.b = paramInput.readDouble();
/*  40 */     this.c = paramInput.readBoolean();
/*  41 */     this.d = paramInput.readBoolean();
/*  42 */     this.e = paramInput.readBoolean();
/*     */   }
/*     */   
/*     */   private GameValueConfig() {}
/*     */   
/*     */   public GameValueConfig(GameValueType paramGameValueType, double paramDouble, boolean paramBoolean1, boolean paramBoolean2) {
/*  48 */     setType(paramGameValueType);
/*  49 */     this.b = paramDouble;
/*  50 */     this.c = paramBoolean1;
/*  51 */     this.d = paramBoolean2;
/*     */   }
/*     */   
/*     */   public final GameValueType getType() {
/*  55 */     return this.a;
/*     */   }
/*     */   
/*     */   public final void setType(GameValueType paramGameValueType) {
/*  59 */     Preconditions.checkNotNull(paramGameValueType, "type can not be null");
/*  60 */     this.a = paramGameValueType;
/*     */   }
/*     */   
/*     */   public final double getValue() {
/*  64 */     return this.b;
/*     */   }
/*     */   
/*     */   public final void setValue(double paramDouble) {
/*  68 */     this.b = paramDouble;
/*     */   }
/*     */   
/*     */   public final boolean isOverwrite() {
/*  72 */     return this.c;
/*     */   }
/*     */   
/*     */   public final void setOverwrite(boolean paramBoolean) {
/*  76 */     this.c = paramBoolean;
/*     */   }
/*     */   
/*     */   public final boolean isAllowBonuses() {
/*  80 */     return this.d;
/*     */   }
/*     */   
/*     */   public final void setAllowBonuses(boolean paramBoolean) {
/*  84 */     this.d = paramBoolean;
/*     */   }
/*     */   
/*     */   public final boolean isFinalGlobalMultiplier() {
/*  88 */     return this.e;
/*     */   }
/*     */   
/*     */   public final void setFinalGlobalMultiplier(boolean paramBoolean) {
/*  92 */     this.e = paramBoolean;
/*     */   }
/*     */   
/*     */   public final void toJson(Json paramJson) {
/*  96 */     paramJson.writeValue("t", this.a.name());
/*  97 */     paramJson.writeValue("v", Double.valueOf(this.b));
/*  98 */     paramJson.writeValue("o", Boolean.valueOf(this.c));
/*  99 */     paramJson.writeValue("b", Boolean.valueOf(this.d));
/* 100 */     if (this.e) paramJson.writeValue("fgm", Boolean.TRUE);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GameValueConfig fromJson(JsonValue paramJsonValue) {
/*     */     try {
/*     */       GameValueConfig gameValueConfig;
/* 110 */       (gameValueConfig = new GameValueConfig()).a = GameValueType.valueOf(paramJsonValue.getString("t"));
/* 111 */       gameValueConfig.b = paramJsonValue.getDouble("v");
/* 112 */       gameValueConfig.c = paramJsonValue.getBoolean("o", false);
/* 113 */       gameValueConfig.d = paramJsonValue.getBoolean("b", true);
/* 114 */       gameValueConfig.e = paramJsonValue.getBoolean("fgm", false);
/* 115 */       return gameValueConfig;
/* 116 */     } catch (Exception exception) {
/* 117 */       throw new IllegalArgumentException("failed to load from json", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   public final boolean sameAs(GameValueConfig paramGameValueConfig) {
/* 122 */     if (paramGameValueConfig.a != this.a) return false; 
/* 123 */     if (paramGameValueConfig.b != this.b) return false; 
/* 124 */     if (paramGameValueConfig.c != this.c) return false; 
/* 125 */     if (paramGameValueConfig.d != this.d) return false; 
/* 126 */     if (paramGameValueConfig.e != this.e) return false;
/*     */     
/* 128 */     return true;
/*     */   }
/*     */   
/*     */   public final GameValueConfig cpy() {
/*     */     GameValueConfig gameValueConfig;
/* 133 */     (gameValueConfig = new GameValueConfig(this.a, this.b, this.c, this.d)).e = this.e;
/* 134 */     return gameValueConfig;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 139 */     return super.toString() + " {type: " + this.a + ", value: " + this.b + ", ow: " + this.c + ", ab: " + this.d + ", fgm: " + this.e + "}";
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\GameValueConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */