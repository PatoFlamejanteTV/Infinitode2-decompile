/*     */ package com.prineside.tdi2;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
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
/*     */ @REGS(arrayLevels = 1)
/*     */ public final class Wave
/*     */   implements KryoSerializable
/*     */ {
/*     */   public int waveNumber;
/*     */   public int difficulty;
/*     */   public int totalEnemiesCount;
/*     */   public boolean enemiesCanBeSplitBetweenSpawns = true;
/*     */   public boolean enemiesCanHaveRandomSideShifts = true;
/*  28 */   public DelayedRemovalArray<EnemyGroup> enemyGroups = new DelayedRemovalArray(true, 1, EnemyGroup.class);
/*  29 */   public String waveMessage = null;
/*  30 */   public float enemiesSumHealth = 0.0F;
/*  31 */   public float enemiesSumBounty = 0.0F;
/*  32 */   public float enemiesTookDamage = 0.0F;
/*     */ 
/*     */   
/*  35 */   public WaveProcessor waveProcessor = null;
/*     */   public boolean started;
/*  37 */   public int killedEnemiesCount = 0;
/*  38 */   public int passedEnemiesCount = 0;
/*  39 */   public int killedEnemiesBountySum = 0;
/*     */   
/*     */   public boolean completed = false;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  44 */     paramOutput.writeVarInt(this.waveNumber, true);
/*  45 */     paramOutput.writeVarInt(this.difficulty, true);
/*  46 */     paramOutput.writeVarInt(this.totalEnemiesCount, true);
/*  47 */     paramOutput.writeBoolean(this.enemiesCanBeSplitBetweenSpawns);
/*  48 */     paramOutput.writeBoolean(this.enemiesCanHaveRandomSideShifts);
/*  49 */     paramKryo.writeObject(paramOutput, this.enemyGroups);
/*  50 */     paramKryo.writeObjectOrNull(paramOutput, this.waveMessage, String.class);
/*  51 */     paramOutput.writeFloat(this.enemiesSumHealth);
/*  52 */     paramOutput.writeFloat(this.enemiesSumBounty);
/*  53 */     paramOutput.writeFloat(this.enemiesTookDamage);
/*  54 */     paramKryo.writeClassAndObject(paramOutput, this.waveProcessor);
/*  55 */     paramOutput.writeBoolean(this.started);
/*  56 */     paramOutput.writeVarInt(this.killedEnemiesCount, true);
/*  57 */     paramOutput.writeVarInt(this.passedEnemiesCount, true);
/*  58 */     paramOutput.writeVarInt(this.killedEnemiesBountySum, true);
/*  59 */     paramOutput.writeBoolean(this.completed);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  64 */     this.waveNumber = paramInput.readVarInt(true);
/*  65 */     this.difficulty = paramInput.readVarInt(true);
/*  66 */     this.totalEnemiesCount = paramInput.readVarInt(true);
/*  67 */     this.enemiesCanBeSplitBetweenSpawns = paramInput.readBoolean();
/*  68 */     this.enemiesCanHaveRandomSideShifts = paramInput.readBoolean();
/*  69 */     this.enemyGroups = (DelayedRemovalArray<EnemyGroup>)paramKryo.readObject(paramInput, DelayedRemovalArray.class);
/*  70 */     this.waveMessage = (String)paramKryo.readObjectOrNull(paramInput, String.class);
/*  71 */     this.enemiesSumHealth = paramInput.readFloat();
/*  72 */     this.enemiesSumBounty = paramInput.readFloat();
/*  73 */     this.enemiesTookDamage = paramInput.readFloat();
/*  74 */     this.waveProcessor = (WaveProcessor)paramKryo.readClassAndObject(paramInput);
/*  75 */     this.started = paramInput.readBoolean();
/*  76 */     this.killedEnemiesCount = paramInput.readVarInt(true);
/*  77 */     this.passedEnemiesCount = paramInput.readVarInt(true);
/*  78 */     this.killedEnemiesBountySum = paramInput.readVarInt(true);
/*  79 */     this.completed = paramInput.readBoolean();
/*     */   }
/*     */   
/*     */   public static float calculateDefaultBossWaveCoinsSum(int paramInt) {
/*  83 */     return (float)((12.0D + StrictMath.pow(paramInt, 0.65D)) * (2.0F + paramInt * 0.05F)) * 3.0F;
/*     */   }
/*     */   
/*     */   public static float calculateDefaultBossWaveScoreSum(int paramInt) {
/*  87 */     return (float)((12.0D + StrictMath.pow(paramInt, 0.65D)) * 10.0D) * 3.0F;
/*     */   }
/*     */   
/*     */   public static float calculateDefaultBossWaveExpSum(int paramInt) {
/*  91 */     return (float)((12.0D + StrictMath.pow(paramInt, 0.65D)) * (1.0F + paramInt * 0.01F)) * 3.0F;
/*     */   }
/*     */   
/*     */   private Wave() {}
/*     */   
/*     */   public Wave(int paramInt1, int paramInt2, Array<EnemyGroup> paramArray) {
/*  97 */     this.waveNumber = paramInt1;
/*  98 */     this.difficulty = paramInt2;
/*  99 */     this.enemyGroups.addAll(paramArray);
/*     */     
/* 101 */     for (Array.ArrayIterator<EnemyGroup> arrayIterator = paramArray.iterator(); arrayIterator.hasNext(); ) { EnemyGroup enemyGroup = arrayIterator.next();
/* 102 */       this.totalEnemiesCount += enemyGroup.count;
/* 103 */       this.enemiesSumBounty += enemyGroup.count * enemyGroup.bounty;
/* 104 */       this.enemiesSumHealth += enemyGroup.count * enemyGroup.health; }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isFullySpawned() {
/* 110 */     for (byte b = 0; b < this.enemyGroups.size; b++) {
/* 111 */       if ((((EnemyGroup[])this.enemyGroups.items)[b]).a < (((EnemyGroup[])this.enemyGroups.items)[b]).count) {
/* 112 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 116 */     return true;
/*     */   }
/*     */   
/*     */   public final int getSpawnedEnemyCount() {
/* 120 */     int i = 0;
/* 121 */     for (byte b = 0; b < this.enemyGroups.size; b++) {
/* 122 */       i += (((EnemyGroup[])this.enemyGroups.items)[b]).a;
/*     */     }
/*     */     
/* 125 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String toString() {
/*     */     StringBuilder stringBuilder;
/* 131 */     (stringBuilder = new StringBuilder()).append("Wave {\n");
/* 132 */     stringBuilder.append("  waveNumber: ").append(this.waveNumber).append("\n");
/* 133 */     stringBuilder.append("  averageDifficulty: ").append(this.difficulty).append("\n");
/* 134 */     stringBuilder.append("  enemiesCount: ").append(this.totalEnemiesCount).append("\n");
/* 135 */     stringBuilder.append("  enemyGroups: {\n");
/* 136 */     for (Array.ArrayIterator<EnemyGroup> arrayIterator = this.enemyGroups.iterator(); arrayIterator.hasNext(); ) { EnemyGroup enemyGroup = arrayIterator.next();
/* 137 */       stringBuilder.append("    ").append(enemyGroup.toString()).append("\n"); }
/*     */     
/* 139 */     stringBuilder.append("  }\n");
/* 140 */     stringBuilder.append("}");
/*     */     
/* 142 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\Wave.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */