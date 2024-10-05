/*     */ package com.prineside.tdi2;
/*     */ 
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS(arrayLevels = 1)
/*     */ public class EnemyGroup
/*     */   implements KryoSerializable
/*     */ {
/*     */   private EnemyType b;
/*     */   public float speed;
/*     */   public float health;
/*     */   public float delay;
/*     */   public float interval;
/*     */   public float bounty;
/*  24 */   public float killExp = 1.0F;
/*  25 */   public int killScore = 1;
/*     */ 
/*     */   
/*     */   public int count;
/*     */   
/*  30 */   protected int a = 0;
/*     */ 
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  34 */     paramKryo.writeObject(paramOutput, this.b);
/*  35 */     paramOutput.writeFloat(this.speed);
/*  36 */     paramOutput.writeFloat(this.health);
/*  37 */     paramOutput.writeFloat(this.delay);
/*  38 */     paramOutput.writeFloat(this.interval);
/*  39 */     paramOutput.writeFloat(this.bounty);
/*  40 */     paramOutput.writeFloat(this.killExp);
/*  41 */     paramOutput.writeInt(this.killScore);
/*  42 */     paramOutput.writeVarInt(this.count, true);
/*  43 */     paramOutput.writeVarInt(this.a, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  48 */     this.b = (EnemyType)paramKryo.readObject(paramInput, EnemyType.class);
/*  49 */     this.speed = paramInput.readFloat();
/*  50 */     this.health = paramInput.readFloat();
/*  51 */     this.delay = paramInput.readFloat();
/*  52 */     this.interval = paramInput.readFloat();
/*  53 */     this.bounty = paramInput.readFloat();
/*  54 */     this.killExp = paramInput.readFloat();
/*  55 */     this.killScore = paramInput.readInt();
/*  56 */     this.count = paramInput.readVarInt(true);
/*  57 */     this.a = paramInput.readVarInt(true);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EnemyGroup(EnemyType paramEnemyType, float paramFloat1, float paramFloat2, int paramInt1, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, int paramInt2) {
/*  73 */     setEnemyType(paramEnemyType);
/*  74 */     this.speed = paramFloat1;
/*  75 */     this.health = paramFloat2;
/*  76 */     this.count = paramInt1;
/*  77 */     this.delay = paramFloat3;
/*  78 */     this.interval = paramFloat4;
/*  79 */     this.bounty = paramFloat5;
/*  80 */     this.killExp = paramFloat6;
/*  81 */     this.killScore = paramInt2;
/*     */   }
/*     */   
/*     */   public EnemyType getEnemyType() {
/*  85 */     return this.b;
/*     */   }
/*     */   
/*     */   public void setEnemyType(EnemyType paramEnemyType) {
/*  89 */     Preconditions.checkNotNull(paramEnemyType, "type can not be null");
/*  90 */     this.b = paramEnemyType;
/*     */   }
/*     */   
/*     */   public int getSpawnedCount() {
/*  94 */     return this.a;
/*     */   }
/*     */   
/*     */   public EnemyGroup cpy() {
/*     */     EnemyGroup enemyGroup;
/*  99 */     (enemyGroup = new EnemyGroup(this.b, this.speed, this.health, this.count, this.delay, this.interval, this.bounty, this.killExp, this.killScore)).a = this.a;
/*     */     
/* 101 */     return enemyGroup;
/*     */   }
/*     */   
/*     */   public SpawnEnemyGroup createSpawnPortion(int paramInt) {
/*     */     SpawnEnemyGroup spawnEnemyGroup;
/* 106 */     (spawnEnemyGroup = new SpawnEnemyGroup(this, this.b, this.speed, this.health, paramInt, this.delay, this.interval, this.bounty, this.killExp, this.killScore)).a = 0;
/*     */     
/* 108 */     return spawnEnemyGroup;
/*     */   }
/*     */   
/*     */   public void toJson(Json paramJson) {
/* 112 */     paramJson.writeValue("enemyType", this.b.name());
/* 113 */     if (this.delay > 0.0F) paramJson.writeValue("delay", Float.valueOf(this.delay)); 
/* 114 */     paramJson.writeValue("interval", Float.valueOf(this.interval));
/* 115 */     paramJson.writeValue("count", Integer.valueOf(this.count));
/* 116 */     paramJson.writeValue("health", Float.valueOf(this.health));
/* 117 */     paramJson.writeValue("speed", Float.valueOf(this.speed));
/* 118 */     paramJson.writeValue("bounty", Float.valueOf(this.bounty));
/* 119 */     paramJson.writeValue("exp", Float.valueOf(this.killExp));
/* 120 */     paramJson.writeValue("score", Integer.valueOf(this.killScore));
/*     */   }
/*     */ 
/*     */   
/*     */   public static EnemyGroup fromJson(JsonValue paramJsonValue) {
/*     */     EnemyGroup enemyGroup;
/* 126 */     (enemyGroup = new EnemyGroup()).b = EnemyType.valueOf(paramJsonValue.getString("enemyType"));
/* 127 */     enemyGroup.delay = paramJsonValue.getFloat("delay", 0.0F);
/* 128 */     enemyGroup.interval = paramJsonValue.getFloat("interval");
/* 129 */     enemyGroup.count = paramJsonValue.getInt("count");
/* 130 */     enemyGroup.health = paramJsonValue.getFloat("health");
/* 131 */     enemyGroup.speed = paramJsonValue.getFloat("speed");
/* 132 */     enemyGroup.bounty = paramJsonValue.getFloat("bounty");
/* 133 */     enemyGroup.killExp = paramJsonValue.getFloat("exp");
/* 134 */     enemyGroup.killScore = paramJsonValue.getInt("score");
/*     */ 
/*     */ 
/*     */     
/* 138 */     return enemyGroup;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSpawnCountByTime(float paramFloat) {
/* 148 */     if ((paramFloat = paramFloat - this.delay) < 0.0F)
/*     */     {
/* 150 */       return 0;
/*     */     }
/*     */     
/* 153 */     if (this.interval > 0.0F) {
/*     */       int i;
/* 155 */       if ((i = 1 + MathUtils.floor(paramFloat / this.interval)) > this.count) i = this.count;
/*     */       
/* 157 */       return i;
/*     */     } 
/*     */     
/* 160 */     return this.count;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 167 */     return "EnemyGroup { type: " + this.b
/* 168 */       .name() + ", speed: " + this.speed + ", health: " + this.health + ", delay: " + this.delay + ", interval: " + this.interval + ", bounty: " + this.bounty + ", killExp: " + this.killExp + ", killScore: " + this.killScore + ", count: " + this.count + ", spawnedCount: " + this.a + " }";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private EnemyGroup() {}
/*     */ 
/*     */ 
/*     */   
/*     */   @REGS
/*     */   public static class SpawnEnemyGroup
/*     */     extends EnemyGroup
/*     */   {
/*     */     public EnemyGroup waveGroup;
/*     */ 
/*     */ 
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output) {
/* 187 */       super.write(param1Kryo, param1Output);
/* 188 */       param1Kryo.writeObjectOrNull(param1Output, this.waveGroup, EnemyGroup.class);
/*     */     }
/*     */ 
/*     */     
/*     */     public void read(Kryo param1Kryo, Input param1Input) {
/* 193 */       super.read(param1Kryo, param1Input);
/* 194 */       this.waveGroup = (EnemyGroup)param1Kryo.readObjectOrNull(param1Input, EnemyGroup.class);
/*     */     }
/*     */     public SpawnEnemyGroup() {
/* 197 */       super((byte)0);
/*     */     } public SpawnEnemyGroup(EnemyGroup param1EnemyGroup, EnemyType param1EnemyType, float param1Float1, float param1Float2, int param1Int1, float param1Float3, float param1Float4, float param1Float5, float param1Float6, int param1Int2) {
/* 199 */       super(param1EnemyType, param1Float1, param1Float2, param1Int1, param1Float3, param1Float4, param1Float5, param1Float6, param1Int2);
/*     */       
/* 201 */       this.waveGroup = param1EnemyGroup;
/*     */     }
/*     */     
/*     */     public void addSpawnedCount(int param1Int) {
/* 205 */       this.a += param1Int;
/* 206 */       this.waveGroup.a += param1Int;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\EnemyGroup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */