/*    */ package com.prineside.tdi2;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Json;
/*    */ import com.badlogic.gdx.utils.JsonValue;
/*    */ import com.esotericsoftware.kryo.KryoSerializable;
/*    */ import com.prineside.tdi2.actions.BuildMinerAction;
/*    */ import com.prineside.tdi2.actions.BuildModifierAction;
/*    */ import com.prineside.tdi2.actions.BuildTowerAction;
/*    */ import com.prineside.tdi2.actions.CallWaveAction;
/*    */ import com.prineside.tdi2.actions.ChangeTowerAimStrategyAction;
/*    */ import com.prineside.tdi2.actions.CoreUpgradeAction;
/*    */ import com.prineside.tdi2.actions.CustomAction;
/*    */ import com.prineside.tdi2.actions.CustomModifierButtonAction;
/*    */ import com.prineside.tdi2.actions.CustomTowerButtonAction;
/*    */ import com.prineside.tdi2.actions.GlobalUpgradeMinerAction;
/*    */ import com.prineside.tdi2.actions.GlobalUpgradeTowerAction;
/*    */ import com.prineside.tdi2.actions.ReRollBonusesAction;
/*    */ import com.prineside.tdi2.actions.RewardingAdAction;
/*    */ import com.prineside.tdi2.actions.ScriptAction;
/*    */ import com.prineside.tdi2.actions.SelectGameplayBonusAction;
/*    */ import com.prineside.tdi2.actions.SelectGlobalTowerAbilityAction;
/*    */ import com.prineside.tdi2.actions.SelectTowerAbilityAction;
/*    */ import com.prineside.tdi2.actions.SellMinerAction;
/*    */ import com.prineside.tdi2.actions.SellModifierAction;
/*    */ import com.prineside.tdi2.actions.SellTowerAction;
/*    */ import com.prineside.tdi2.actions.ToggleTowerEnabledAction;
/*    */ import com.prineside.tdi2.actions.UpgradeMinerAction;
/*    */ import com.prineside.tdi2.actions.UpgradeTowerAction;
/*    */ import com.prineside.tdi2.actions.UseAbilityAction;
/*    */ import com.prineside.tdi2.enums.ActionType;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(arrayLevels = 1)
/*    */ public abstract class Action implements KryoSerializable {
/*    */   public abstract ActionType getType();
/*    */   
/*    */   public boolean affectsPlayerXp() {
/* 38 */     return false;
/*    */   }
/*    */   
/*    */   public void toJson(Json paramJson) {}
/*    */   
/*    */   public static Action fromJson(JsonValue paramJsonValue) {
/* 44 */     ActionType actionType = ActionType.valueOf(paramJsonValue.getString("t"));
/* 45 */     switch (null.a[actionType.ordinal()]) { case 1:
/* 46 */         return (Action)new ScriptAction(paramJsonValue);
/* 47 */       case 2: return (Action)new BuildTowerAction(paramJsonValue);
/* 48 */       case 3: return (Action)new CallWaveAction(paramJsonValue);
/* 49 */       case 4: return (Action)new RewardingAdAction(paramJsonValue);
/* 50 */       case 5: return (Action)new UpgradeTowerAction(paramJsonValue);
/* 51 */       case 6: return (Action)new GlobalUpgradeTowerAction(paramJsonValue);
/* 52 */       case 7: return (Action)new SellTowerAction(paramJsonValue);
/* 53 */       case 8: return (Action)new BuildMinerAction(paramJsonValue);
/* 54 */       case 9: return (Action)new UpgradeMinerAction(paramJsonValue);
/* 55 */       case 10: return (Action)new GlobalUpgradeMinerAction(paramJsonValue);
/* 56 */       case 11: return (Action)new SellMinerAction(paramJsonValue);
/* 57 */       case 12: return (Action)new BuildModifierAction(paramJsonValue);
/* 58 */       case 13: return (Action)new SelectTowerAbilityAction(paramJsonValue);
/* 59 */       case 14: return (Action)new SelectGlobalTowerAbilityAction(paramJsonValue);
/* 60 */       case 15: return (Action)new ChangeTowerAimStrategyAction(paramJsonValue);
/* 61 */       case 16: return (Action)new UseAbilityAction(paramJsonValue);
/* 62 */       case 17: return (Action)new CustomTowerButtonAction(paramJsonValue);
/* 63 */       case 18: return (Action)new SellModifierAction(paramJsonValue);
/* 64 */       case 19: return (Action)new CoreUpgradeAction(paramJsonValue);
/* 65 */       case 20: return (Action)new CustomModifierButtonAction(paramJsonValue);
/* 66 */       case 21: return (Action)new SelectGameplayBonusAction(paramJsonValue);
/* 67 */       case 22: return (Action)new ReRollBonusesAction(paramJsonValue);
/* 68 */       case 23: return (Action)new ToggleTowerEnabledAction(paramJsonValue);
/* 69 */       case 24: return (Action)new CustomAction(paramJsonValue); }
/*    */ 
/*    */     
/* 72 */     throw new RuntimeException("Not implemented: " + actionType.name());
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\Action.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */