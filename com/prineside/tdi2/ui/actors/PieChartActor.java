/*    */ package com.prineside.tdi2.ui.actors;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g2d.Batch;
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.badlogic.gdx.utils.Disposable;
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.Shape;
/*    */ import com.prineside.tdi2.enums.ShapeType;
/*    */ import com.prineside.tdi2.scene2d.ui.Widget;
/*    */ import com.prineside.tdi2.shapes.PieChart;
/*    */ 
/*    */ public class PieChartActor extends Widget implements Disposable {
/*    */   public final PieChart chart;
/*    */   private Array<PieChart.ChartEntryConfig> j;
/*    */   private float k;
/*    */   private float l;
/* 17 */   private float m = -1.0F;
/* 18 */   private int n = -1;
/*    */   
/*    */   public PieChartActor() {
/* 21 */     this.chart = (PieChart)((PieChart.PieChartFactory)Game.i.shapeManager.getFactory(ShapeType.PIE_CHART)).obtain();
/*    */   }
/*    */   
/*    */   public void setConfigs(Array<PieChart.ChartEntryConfig> paramArray) {
/* 25 */     this.j = paramArray;
/* 26 */     this.m = -1.0F;
/*    */   }
/*    */   
/*    */   public Array<PieChart.ChartEntryConfig> getConfigs() {
/* 30 */     return this.j;
/*    */   }
/*    */   
/*    */   public void setSegmentCount(int paramInt) {
/* 34 */     this.n = paramInt;
/* 35 */     this.m = -1.0F;
/*    */   }
/*    */ 
/*    */   
/*    */   public void draw(Batch paramBatch, float paramFloat) {
/* 40 */     super.draw(paramBatch, paramFloat);
/*    */     
/* 42 */     if (this.j == null)
/*    */       return; 
/* 44 */     paramFloat = getX() + getWidth() / 2.0F;
/* 45 */     float f1 = getY() + getHeight() / 2.0F;
/* 46 */     float f2 = (getWidth() > getHeight()) ? (getHeight() / 2.0F) : (getWidth() / 2.0F);
/*    */     
/* 48 */     if (paramFloat != this.k || f1 != this.l || f2 != this.m) {
/* 49 */       int i = (this.n == -1) ? (int)StrictMath.max(f2 * 2.0F, 8.0F) : this.n;
/* 50 */       this.chart.setup(paramFloat, f1, f2, i, this.j);
/* 51 */       this.k = paramFloat;
/* 52 */       this.l = f1;
/* 53 */       this.m = f2;
/*    */     } 
/*    */     
/* 56 */     this.chart.draw(paramBatch);
/*    */   }
/*    */ 
/*    */   
/*    */   public void dispose() {
/* 61 */     ((PieChart.PieChartFactory)Game.i.shapeManager.getFactory(ShapeType.PIE_CHART)).free((Shape)this.chart);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\actors\PieChartActor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */