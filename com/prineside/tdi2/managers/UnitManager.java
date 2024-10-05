/*    */ package com.prineside.tdi2.managers;
/*    */ 
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.Manager;
/*    */ import com.prineside.tdi2.Unit;
/*    */ import com.prineside.tdi2.enums.UnitType;
/*    */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*    */ import com.prineside.tdi2.units.BallLightningUnit;
/*    */ import com.prineside.tdi2.units.DisorientedUnit;
/*    */ import com.prineside.tdi2.units.IceFieldUnit;
/*    */ import com.prineside.tdi2.units.MicrogunUnit;
/*    */ import com.prineside.tdi2.units.MineUnit;
/*    */ import com.prineside.tdi2.units.SnowballUnit;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(serializer = UnitManager.Serializer.class)
/*    */ public final class UnitManager extends Manager.ManagerAdapter {
/*    */   public static class Serializer extends SingletonSerializer<UnitManager> {
/*    */     public UnitManager read() {
/* 20 */       return Game.i.unitManager;
/*    */     } }
/*    */   
/* 23 */   private final Unit.Factory<? extends Unit>[] a = (Unit.Factory<? extends Unit>[])new Unit.Factory[UnitType.values.length];
/*    */   
/* 25 */   public final Factories F = new Factories();
/*    */   
/*    */   public static class Factories {
/*    */     public SnowballUnit.SnowballUnitFactory SNOWBALL;
/*    */     public BallLightningUnit.BallLightningUnitFactory BALL_LIGHTNING;
/*    */     public DisorientedUnit.DisorientedUnitFactory DISORIENTED;
/*    */     public MicrogunUnit.MicrogunUnitFactory MICROGUN;
/*    */     public MineUnit.MineUnitFactory MINE;
/*    */     public IceFieldUnit.IceFieldUnitFactory ICE_FIELD; }
/*    */   
/*    */   public UnitManager() {
/* 36 */     this.a[UnitType.SNOWBALL.ordinal()] = (Unit.Factory<? extends Unit>)(this.F.SNOWBALL = new SnowballUnit.SnowballUnitFactory());
/* 37 */     this.a[UnitType.BALL_LIGHTNING.ordinal()] = (Unit.Factory<? extends Unit>)(this.F.BALL_LIGHTNING = new BallLightningUnit.BallLightningUnitFactory());
/* 38 */     this.a[UnitType.DISORIENTED.ordinal()] = (Unit.Factory<? extends Unit>)(this.F.DISORIENTED = new DisorientedUnit.DisorientedUnitFactory());
/* 39 */     this.a[UnitType.MICROGUN.ordinal()] = (Unit.Factory<? extends Unit>)(this.F.MICROGUN = new MicrogunUnit.MicrogunUnitFactory());
/* 40 */     this.a[UnitType.MINE.ordinal()] = (Unit.Factory<? extends Unit>)(this.F.MINE = new MineUnit.MineUnitFactory());
/* 41 */     this.a[UnitType.ICE_FIELD.ordinal()] = (Unit.Factory<? extends Unit>)(this.F.ICE_FIELD = new IceFieldUnit.IceFieldUnitFactory()); Unit.Factory<? extends Unit>[] arrayOfFactory; int i;
/*    */     byte b;
/* 43 */     for (i = (arrayOfFactory = this.a).length, b = 0; b < i; b++) {
/* 44 */       Unit.Factory<? extends Unit> factory; if ((factory = arrayOfFactory[b]) == null)
/* 45 */         throw new RuntimeException("Not all unit factories were created"); 
/*    */     } 
/*    */   }
/*    */   public final void setup() {
/*    */     Unit.Factory<? extends Unit>[] arrayOfFactory;
/*    */     int i;
/*    */     byte b;
/* 52 */     for (i = (arrayOfFactory = this.a).length, b = 0; b < i; b++) {
/* 53 */       Unit.Factory<? extends Unit> factory; (factory = arrayOfFactory[b]).setup();
/*    */     } 
/*    */   }
/*    */   
/*    */   public final Unit.Factory<? extends Unit> getFactory(UnitType paramUnitType) {
/* 58 */     return this.a[paramUnitType.ordinal()];
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\UnitManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */