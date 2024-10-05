/*     */ package com.prineside.tdi2.utils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.IntMap;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.enums.BossType;
/*     */ import com.prineside.tdi2.tiles.BossTile;
/*     */ 
/*     */ @REGS(classOnly = true)
/*     */ public interface WaveBossSupplier {
/*     */   @Null
/*     */   BossType getWaveBoss(int paramInt);
/*     */   
/*     */   WaveBossSupplier cpy();
/*     */   
/*     */   @REGS
/*     */   public static final class MapBased implements KryoSerializable, WaveBossSupplier {
/*  21 */     private IntMap<BossType> a = new IntMap();
/*     */ 
/*     */     
/*     */     public final void write(Kryo param1Kryo, Output param1Output) {
/*  25 */       param1Kryo.writeObject(param1Output, this.a);
/*     */     }
/*     */ 
/*     */     
/*     */     public final void read(Kryo param1Kryo, Input param1Input) {
/*  30 */       this.a = (IntMap<BossType>)param1Kryo.readObject(param1Input, IntMap.class);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final void add(int param1Int, BossType param1BossType) {
/*  36 */       this.a.put(param1Int, param1BossType);
/*     */     }
/*     */     
/*     */     public final IntMap<BossType> getMap() {
/*  40 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public final BossType getWaveBoss(int param1Int) {
/*  45 */       return (BossType)this.a.get(param1Int);
/*     */     }
/*     */ 
/*     */     
/*     */     public final WaveBossSupplier cpy() {
/*  50 */       MapBased mapBased = new MapBased();
/*  51 */       for (IntMap.Entry entry : this.a) {
/*  52 */         mapBased.a.put(entry.key, entry.value);
/*     */       }
/*     */       
/*  55 */       return mapBased;
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class Procedural implements KryoSerializable, WaveBossSupplier {
/*  61 */     private BossTile.BossWavesConfig a = new BossTile.BossWavesConfig(20, 1, 0, new Array());
/*     */ 
/*     */     
/*     */     public final void write(Kryo param1Kryo, Output param1Output) {
/*  65 */       param1Kryo.writeObject(param1Output, this.a);
/*     */     }
/*     */ 
/*     */     
/*     */     public final void read(Kryo param1Kryo, Input param1Input) {
/*  70 */       this.a = (BossTile.BossWavesConfig)param1Kryo.readObject(param1Input, BossTile.BossWavesConfig.class);
/*     */     }
/*     */     
/*     */     public Procedural() {}
/*     */     
/*     */     public Procedural(BossTile.BossWavesConfig param1BossWavesConfig) {
/*  76 */       Preconditions.checkNotNull(param1BossWavesConfig, "config can not be null");
/*  77 */       this.a = param1BossWavesConfig;
/*     */     }
/*     */     
/*     */     public final BossTile.BossWavesConfig getWavesConfig() {
/*  81 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public final BossType getWaveBoss(int param1Int) {
/*  86 */       if (param1Int < this.a.startDelay) {
/*  87 */         return null;
/*     */       }
/*     */ 
/*     */       
/*  91 */       int i = ((param1Int = param1Int - this.a.startDelay) - 1) / this.a.cycleLength;
/*  92 */       param1Int -= i * this.a.cycleLength;
/*  93 */       if (this.a.repeatCount <= 0 || this.a.repeatCount > i) {
/*  94 */         for (i = 0; i < this.a.bossWavePairs.size; i++) {
/*     */           BossTile.BossTypeWavePair bossTypeWavePair;
/*  96 */           if ((bossTypeWavePair = (BossTile.BossTypeWavePair)this.a.bossWavePairs.get(i)).wave == param1Int) {
/*  97 */             return bossTypeWavePair.bossType;
/*     */           }
/*     */         } 
/* 100 */         return null;
/*     */       } 
/* 102 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final WaveBossSupplier cpy() {
/* 108 */       return new Procedural(this.a.cpy());
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 113 */       return super.toString() + " (" + this.a + ")";
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\WaveBossSupplier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */