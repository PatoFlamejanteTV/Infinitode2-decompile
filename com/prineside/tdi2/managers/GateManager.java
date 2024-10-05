/*    */ package com.prineside.tdi2.managers;
/*    */ 
/*    */ import com.badlogic.gdx.math.RandomXS128;
/*    */ import com.badlogic.gdx.utils.JsonValue;
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.Gate;
/*    */ import com.prineside.tdi2.Manager;
/*    */ import com.prineside.tdi2.enums.GateType;
/*    */ import com.prineside.tdi2.gates.BarrierHealthGate;
/*    */ import com.prineside.tdi2.gates.BarrierTypeGate;
/*    */ import com.prineside.tdi2.gates.TeleportGate;
/*    */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(serializer = GateManager.Serializer.class)
/*    */ public class GateManager extends Manager.ManagerAdapter {
/*    */   public static class Serializer extends SingletonSerializer<GateManager> {
/*    */     public GateManager read() {
/* 19 */       return Game.i.gateManager;
/*    */     } }
/*    */   
/* 22 */   public final Factories F = new Factories();
/*    */   
/*    */   public static class Factories {
/*    */     public BarrierTypeGate.BarrierTypeGateFactory BARRIER_TYPE;
/*    */     public BarrierHealthGate.BarrierHealthGateFactory BARRIER_HEALTH;
/*    */     public TeleportGate.TeleportGateFactory TELEPORT;
/*    */   }
/* 29 */   private final Gate.Factory[] a = new Gate.Factory[GateType.values.length];
/*    */   
/*    */   public GateManager() {
/* 32 */     this.a[GateType.BARRIER_TYPE.ordinal()] = (Gate.Factory)(this.F.BARRIER_TYPE = new BarrierTypeGate.BarrierTypeGateFactory());
/* 33 */     this.a[GateType.BARRIER_HEALTH.ordinal()] = (Gate.Factory)(this.F.BARRIER_HEALTH = new BarrierHealthGate.BarrierHealthGateFactory());
/* 34 */     this.a[GateType.TELEPORT.ordinal()] = (Gate.Factory)(this.F.TELEPORT = new TeleportGate.TeleportGateFactory()); GateType[] arrayOfGateType; int i;
/*    */     byte b;
/* 36 */     for (i = (arrayOfGateType = GateType.values).length, b = 0; b < i; ) { GateType gateType = arrayOfGateType[b];
/* 37 */       if (this.a[gateType.ordinal()] == null)
/* 38 */         throw new RuntimeException("Not all gate factories were created"); 
/*    */       b++; }
/*    */   
/*    */   } public void setup() {
/*    */     Gate.Factory[] arrayOfFactory;
/*    */     int i;
/*    */     byte b;
/* 45 */     for (i = (arrayOfFactory = this.a).length, b = 0; b < i; b++) {
/* 46 */       Gate.Factory factory; (factory = arrayOfFactory[b]).setup();
/*    */     } 
/*    */   }
/*    */   
/*    */   public Gate createRandomGate(GateType paramGateType, float paramFloat, RandomXS128 paramRandomXS128) {
/* 51 */     if (paramFloat < 0.0F) {
/* 52 */       paramFloat = 0.0F;
/* 53 */     } else if (paramFloat > 1.0F) {
/* 54 */       paramFloat = 1.0F;
/*    */     } 
/*    */     
/* 57 */     return getFactory(paramGateType).createRandom(paramFloat, paramRandomXS128);
/*    */   }
/*    */   
/*    */   public Gate.Factory<? extends Gate> getFactory(GateType paramGateType) {
/* 61 */     return this.a[paramGateType.ordinal()];
/*    */   }
/*    */   
/*    */   public Gate createGateFromJson(JsonValue paramJsonValue) {
/* 65 */     if (!paramJsonValue.isObject()) {
/* 66 */       throw new IllegalArgumentException("JsonValue must be an object");
/*    */     }
/*    */     
/* 69 */     GateType gateType = GateType.valueOf(paramJsonValue.getString("type"));
/*    */     
/* 71 */     return getFactory(gateType).fromJson(paramJsonValue);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\GateManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */