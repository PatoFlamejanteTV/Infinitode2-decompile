/*    */ package com.prineside.tdi2.modifiers.processors;
/*    */ 
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.GameSystemProvider;
/*    */ import com.prineside.tdi2.Modifier;
/*    */ import com.prineside.tdi2.ModifierProcessor;
/*    */ import com.prineside.tdi2.SerializableListener;
/*    */ import com.prineside.tdi2.Wave;
/*    */ import com.prineside.tdi2.enums.GameValueType;
/*    */ import com.prineside.tdi2.enums.ModifierType;
/*    */ import com.prineside.tdi2.enums.StatisticsType;
/*    */ import com.prineside.tdi2.events.Event;
/*    */ import com.prineside.tdi2.events.Listener;
/*    */ import com.prineside.tdi2.events.game.WaveComplete;
/*    */ import com.prineside.tdi2.modifiers.BountyModifier;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public class BountyModifierProcessor extends ModifierProcessor<BountyModifier> {
/* 23 */   private OnWaveComplete a = new OnWaveComplete(this, (byte)0);
/*    */ 
/*    */   
/*    */   public void write(Kryo paramKryo, Output paramOutput) {
/* 27 */     super.write(paramKryo, paramOutput);
/* 28 */     paramKryo.writeObject(paramOutput, this.a);
/*    */   }
/*    */ 
/*    */   
/*    */   public void read(Kryo paramKryo, Input paramInput) {
/* 33 */     super.read(paramKryo, paramInput);
/* 34 */     this.a = (OnWaveComplete)paramKryo.readObject(paramInput, OnWaveComplete.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setRegistered(GameSystemProvider paramGameSystemProvider) {
/* 39 */     super.setRegistered(paramGameSystemProvider);
/*    */     
/* 41 */     this.S.events.getListeners(WaveComplete.class).addStateAffecting(this.a);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setUnregistered() {
/* 46 */     this.S.events.getListeners(WaveComplete.class).remove(this.a);
/*    */     
/* 48 */     super.setUnregistered();
/*    */   }
/*    */   
/*    */   private void a() {
/* 52 */     int i = this.S.gameValue.getIntValue(GameValueType.MODIFIER_BOUNTY_VALUE);
/*    */     int j;
/* 54 */     if ((j = (int)(this.S.gameState.getMoney() * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.MODIFIER_BOUNTY_PERCENT))) > i) {
/* 55 */       j = i;
/*    */     }
/*    */     
/* 58 */     if (j == 0)
/*    */       return; 
/* 60 */     i = 0;
/* 61 */     for (byte b = 0; b < this.S.modifier.modifiers.size; b++) {
/*    */       Modifier modifier;
/* 63 */       if ((modifier = ((Modifier[])this.S.modifier.modifiers.items)[b]).type == ModifierType.BOUNTY) {
/*    */         
/* 65 */         BountyModifier bountyModifier = (BountyModifier)modifier;
/* 66 */         int k = j;
/* 67 */         if (bountyModifier.boostedByAbility) {
/* 68 */           k = (int)(k * 1.3F);
/* 69 */           bountyModifier.boostedByAbility = false;
/*    */         } 
/*    */         
/* 72 */         i += k;
/* 73 */         bountyModifier.coinsGained += k;
/*    */         
/* 75 */         if (this.S._particle != null && Game.i.settingsManager.isParticlesDrawing()) {
/* 76 */           this.S._particle.addCoinParticle((modifier.getTile()).center.x, (modifier.getTile()).center.y + 32.0F, k);
/*    */         }
/*    */       } 
/*    */     } 
/* 80 */     this.S.gameState.addMoney(i, true);
/* 81 */     this.S.statistics.addStatistic(StatisticsType.CG_B, i);
/*    */   }
/*    */   
/*    */   @REGS
/*    */   public static final class OnWaveComplete extends SerializableListener<BountyModifierProcessor> implements Listener<WaveComplete> {
/*    */     private OnWaveComplete() {}
/*    */     
/*    */     private OnWaveComplete(BountyModifierProcessor param1BountyModifierProcessor) {
/* 89 */       this.a = param1BountyModifierProcessor;
/*    */     }
/*    */ 
/*    */     
/*    */     public final void handleEvent(WaveComplete param1WaveComplete) {
/* 94 */       BountyModifierProcessor.a((BountyModifierProcessor)this.a, param1WaveComplete.getWave());
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\modifiers\processors\BountyModifierProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */