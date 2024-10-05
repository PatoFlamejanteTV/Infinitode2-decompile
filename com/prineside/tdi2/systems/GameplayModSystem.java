/*     */ package com.prineside.tdi2.systems;
/*     */ 
/*     */ import com.badlogic.gdx.math.RandomXS128;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.GameSystem;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayMod;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @REGS
/*     */ public final class GameplayModSystem extends GameSystem {
/*  18 */   private static final TLog a = TLog.forClass(GameplayModSystem.class);
/*     */   
/*  20 */   private DelayedRemovalArray<ActiveMod> b = new DelayedRemovalArray(true, 1, ActiveMod.class);
/*  21 */   private RandomXS128 c = new RandomXS128(1234L);
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  25 */     super.write(paramKryo, paramOutput);
/*  26 */     paramKryo.writeObject(paramOutput, this.b);
/*  27 */     paramKryo.writeObject(paramOutput, this.c);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  32 */     super.read(paramKryo, paramInput);
/*  33 */     this.b = (DelayedRemovalArray<ActiveMod>)paramKryo.readObject(paramInput, DelayedRemovalArray.class);
/*  34 */     this.c = (RandomXS128)paramKryo.readObject(paramInput, RandomXS128.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean affectsGameState() {
/*  39 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final RandomXS128 getModRandom(int paramInt) {
/*  47 */     this.c.setSeed(this.S.gameState.getSeed() * 31L + paramInt);
/*  48 */     return this.c;
/*     */   }
/*     */   
/*     */   public final DelayedRemovalArray<ActiveMod> getActiveMods() {
/*  52 */     return this.b;
/*     */   }
/*     */   @Null
/*     */   public final <T extends GameplayMod> ActiveMod getActiveModFromSource(Class<T> paramClass, String paramString) {
/*  56 */     for (byte b = 0; b < this.b.size; b++) {
/*     */       ActiveMod activeMod;
/*  58 */       if (ActiveMod.a(activeMod = ((ActiveMod[])this.b.items)[b]).getClass() == paramClass && activeMod.getSource().equals(paramString)) {
/*  59 */         return activeMod;
/*     */       }
/*     */     } 
/*     */     
/*  63 */     return null;
/*     */   }
/*     */   @Null
/*     */   public final <T extends GameplayMod> ActiveMod getActiveMod(Class<T> paramClass) {
/*  67 */     for (byte b = 0; b < this.b.size; b++) {
/*     */       ActiveMod activeMod;
/*  69 */       if (ActiveMod.a(activeMod = ((ActiveMod[])this.b.items)[b]).getClass() == paramClass) {
/*  70 */         return activeMod;
/*     */       }
/*     */     } 
/*     */     
/*  74 */     return null;
/*     */   }
/*     */   
/*     */   public final void activateMod(GameplayMod paramGameplayMod, String paramString) {
/*  78 */     if (paramGameplayMod.register(this.S, paramString)) {
/*  79 */       a.i("adding " + paramGameplayMod + " to activeMods", new Object[0]);
/*     */       
/*     */       ActiveMod activeMod;
/*  82 */       ActiveMod.a(activeMod = new ActiveMod((byte)0), paramGameplayMod);
/*  83 */       ActiveMod.a(activeMod, paramString);
/*  84 */       this.b.add(activeMod);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final String getSystemName() {
/*  90 */     return "GameplayMod";
/*     */   }
/*     */ 
/*     */   
/*     */   public final void dispose() {
/*  95 */     super.dispose();
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class ActiveMod
/*     */     implements KryoSerializable {
/*     */     private GameplayMod a;
/*     */     private String b;
/*     */     
/*     */     public final void write(Kryo param1Kryo, Output param1Output) {
/* 105 */       param1Kryo.writeClassAndObject(param1Output, this.a);
/* 106 */       param1Kryo.writeObject(param1Output, this.b);
/*     */     }
/*     */ 
/*     */     
/*     */     public final void read(Kryo param1Kryo, Input param1Input) {
/* 111 */       this.a = (GameplayMod)param1Kryo.readClassAndObject(param1Input);
/* 112 */       this.b = (String)param1Kryo.readObject(param1Input, String.class);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private ActiveMod() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public final GameplayMod getMod() {
/* 123 */       return this.a;
/*     */     }
/*     */     
/*     */     public final void setMod(GameplayMod param1GameplayMod) {
/* 127 */       Preconditions.checkNotNull(param1GameplayMod, "mod can not be null");
/* 128 */       this.a = param1GameplayMod;
/*     */     }
/*     */     
/*     */     public final String getSource() {
/* 132 */       return this.b;
/*     */     }
/*     */     
/*     */     public final void setSource(String param1String) {
/* 136 */       Preconditions.checkNotNull(param1String, "source can not be null");
/* 137 */       this.b = param1String;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\systems\GameplayModSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */