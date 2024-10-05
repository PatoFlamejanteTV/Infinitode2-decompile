/*    */ package com.prineside.tdi2.gameplayMods;
/*    */ 
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.KryoSerializable;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public final class ProbableBonus
/*    */   implements KryoSerializable
/*    */ {
/*    */   public static final int DEFAULT = 100000;
/*    */   private GameplayMod a;
/*    */   private int b;
/*    */   
/*    */   public final void write(Kryo paramKryo, Output paramOutput) {
/* 19 */     paramKryo.writeClassAndObject(paramOutput, this.a);
/* 20 */     paramOutput.writeVarInt(this.b, true);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void read(Kryo paramKryo, Input paramInput) {
/* 25 */     this.a = (GameplayMod)paramKryo.readClassAndObject(paramInput);
/* 26 */     this.b = paramInput.readVarInt(true);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private ProbableBonus() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public ProbableBonus(GameplayMod paramGameplayMod, int paramInt) {
/* 36 */     if (paramInt <= 0) throw new IllegalArgumentException("probability can not be <= 0"); 
/* 37 */     Preconditions.checkNotNull(paramGameplayMod, "bonus can not be null");
/*    */     
/* 39 */     this.a = paramGameplayMod;
/* 40 */     this.b = paramInt;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final GameplayMod getBonus() {
/* 47 */     return this.a;
/*    */   }
/*    */   
/*    */   public final int getProbability() {
/* 51 */     return this.b;
/*    */   }
/*    */   
/*    */   public final void setProbability(int paramInt) {
/* 55 */     this.b = paramInt;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\ProbableBonus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */