/*    */ package com.prineside.tdi2.managers;
/*    */ 
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.Manager;
/*    */ import com.prineside.tdi2.Shape;
/*    */ import com.prineside.tdi2.enums.ShapeType;
/*    */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*    */ import com.prineside.tdi2.shapes.BulletSmokeMultiLine;
/*    */ import com.prineside.tdi2.shapes.ChainLightning;
/*    */ import com.prineside.tdi2.shapes.Circle;
/*    */ import com.prineside.tdi2.shapes.MultiLine;
/*    */ import com.prineside.tdi2.shapes.PieChart;
/*    */ import com.prineside.tdi2.shapes.RangeCircle;
/*    */ import com.prineside.tdi2.shapes.StraightMultiLine;
/*    */ import com.prineside.tdi2.shapes.TrailMultiLine;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(serializer = ShapeManager.Serializer.class)
/*    */ public class ShapeManager extends Manager.ManagerAdapter {
/*    */   public static class Serializer extends SingletonSerializer<ShapeManager> {
/*    */     public ShapeManager read() {
/* 22 */       return Game.i.shapeManager;
/*    */     } }
/*    */   
/* 25 */   private final Shape.Factory[] a = new Shape.Factory[ShapeType.values.length];
/*    */   
/* 27 */   public final Factories F = new Factories();
/*    */   
/*    */   public static class Factories {
/*    */     public MultiLine.MultiLineFactory MULTI_LINE;
/*    */     public TrailMultiLine.TrailMultiLineFactory TRAIL_MULTI_LINE;
/*    */     public Circle.CircleFactory CIRCLE;
/*    */     public RangeCircle.RangeCircleFactory RANGE_CIRCLE;
/*    */     public BulletSmokeMultiLine.BulletSmokeMultiLineFactory BULLET_SMOKE_MULTI_LINE;
/*    */     public PieChart.PieChartFactory PIE_CHART;
/*    */     public ChainLightning.ChainLightningFactory CHAIN_LIGHTNING;
/*    */     public StraightMultiLine.StraightMultiLineFactory STRAIGHT_MULTI_LINE; }
/*    */   
/*    */   public ShapeManager() {
/* 40 */     this.a[ShapeType.MULTI_LINE.ordinal()] = (Shape.Factory)(this.F.MULTI_LINE = new MultiLine.MultiLineFactory());
/* 41 */     this.a[ShapeType.TRAIL_MULTI_LINE.ordinal()] = (Shape.Factory)(this.F.TRAIL_MULTI_LINE = new TrailMultiLine.TrailMultiLineFactory());
/* 42 */     this.a[ShapeType.CIRCLE.ordinal()] = (Shape.Factory)(this.F.CIRCLE = new Circle.CircleFactory());
/* 43 */     this.a[ShapeType.RANGE_CIRCLE.ordinal()] = (Shape.Factory)(this.F.RANGE_CIRCLE = new RangeCircle.RangeCircleFactory());
/* 44 */     this.a[ShapeType.BULLET_SMOKE_MULTI_LINE.ordinal()] = (Shape.Factory)(this.F.BULLET_SMOKE_MULTI_LINE = new BulletSmokeMultiLine.BulletSmokeMultiLineFactory());
/* 45 */     this.a[ShapeType.PIE_CHART.ordinal()] = (Shape.Factory)(this.F.PIE_CHART = new PieChart.PieChartFactory());
/* 46 */     this.a[ShapeType.CHAIN_LIGHTNING.ordinal()] = (Shape.Factory)(this.F.CHAIN_LIGHTNING = new ChainLightning.ChainLightningFactory());
/* 47 */     this.a[ShapeType.STRAIGHT_MULTI_LINE.ordinal()] = (Shape.Factory)(this.F.STRAIGHT_MULTI_LINE = new StraightMultiLine.StraightMultiLineFactory()); ShapeType[] arrayOfShapeType; int i;
/*    */     byte b;
/* 49 */     for (i = (arrayOfShapeType = ShapeType.values).length, b = 0; b < i; ) { ShapeType shapeType = arrayOfShapeType[b];
/* 50 */       if (this.a[shapeType.ordinal()] == null)
/* 51 */         throw new RuntimeException("Not all shape factories were created"); 
/*    */       b++; }
/*    */   
/*    */   } public void setup() {
/*    */     Shape.Factory[] arrayOfFactory;
/*    */     int i;
/*    */     byte b;
/* 58 */     for (i = (arrayOfFactory = this.a).length, b = 0; b < i; b++) {
/* 59 */       Shape.Factory factory; (factory = arrayOfFactory[b]).setup();
/*    */     } 
/*    */   }
/*    */   
/*    */   public Shape.Factory<? extends Shape> getFactory(ShapeType paramShapeType) {
/* 64 */     return this.a[paramShapeType.ordinal()];
/*    */   }
/*    */   
/*    */   public void dispose() {}
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\ShapeManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */