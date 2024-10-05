/*    */ package com.prineside.tdi2.ui.actors;
/*    */ 
/*    */ import com.badlogic.gdx.Application;
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.badlogic.gdx.graphics.g2d.Batch;
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.prineside.tdi2.Threads;
/*    */ import com.prineside.tdi2.shapes.PieChart;
/*    */ 
/*    */ public class ButtonHoldHint
/*    */   extends PieChartActor
/*    */ {
/*    */   public boolean disappearing = false;
/* 15 */   private float j = 0.0F;
/* 16 */   private float k = 0.0F;
/*    */ 
/*    */   
/*    */   private final PieChart.ChartEntryConfig l;
/*    */ 
/*    */   
/*    */   private final PieChart.ChartEntryConfig m;
/*    */   
/*    */   private final float n;
/*    */ 
/*    */   
/*    */   public ButtonHoldHint(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 28 */     this.n = paramFloat3;
/*    */ 
/*    */ 
/*    */     
/* 32 */     Array<PieChart.ChartEntryConfig> array = new Array();
/* 33 */     this.l = new PieChart.ChartEntryConfig(Color.WHITE.cpy(), 0.0F, 0.0F);
/* 34 */     this.m = new PieChart.ChartEntryConfig(new Color(0.0F, 0.0F, 0.0F, 1.0F), 1.0F, 0.0F);
/* 35 */     array.add(this.l);
/* 36 */     array.add(this.m);
/*    */     
/* 38 */     this.chart.innerRadius = (Gdx.app.getType() == Application.ApplicationType.Desktop) ? 12.0F : 18.0F;
/* 39 */     this.chart.rotationDirection = -1.0F;
/* 40 */     this.chart.angleShiftRad = 0.7853982F;
/* 41 */     float f = (Gdx.app.getType() == Application.ApplicationType.Desktop) ? 48.0F : 72.0F;
/* 42 */     setSize(f, f);
/* 43 */     setPosition(paramFloat1 - f * 0.5F, paramFloat2 - f * 0.5F + ((Gdx.app.getType() == Application.ApplicationType.Desktop) ? 0.0F : 160.0F));
/* 44 */     setConfigs(array);
/*    */   }
/*    */ 
/*    */   
/*    */   public void draw(Batch paramBatch, float paramFloat) {
/* 49 */     if (!this.disappearing) {
/*    */       
/* 51 */       this.j += Gdx.graphics.getDeltaTime();
/*    */       
/* 53 */       float f1 = 0.1F;
/* 54 */       if (this.n < 0.2F) {
/* 55 */         f1 = 0.0F;
/* 56 */       } else if (this.n < 0.5F) {
/* 57 */         f1 = 0.05F;
/*    */       } 
/*    */       float f2;
/* 60 */       if ((f2 = (this.j - f1) / (this.n - f1)) > 1.0F) f2 = 1.0F; 
/* 61 */       if (f2 < 0.0F) f2 = 0.0F;
/*    */       
/* 63 */       this.l.color.a = f2 * 0.25F;
/* 64 */       this.l.setValue(f2);
/*    */       
/* 66 */       this.m.setValue(1.0F - f2);
/* 67 */       this.m.color.a = 0.14F * f2;
/*    */     } else {
/*    */       
/* 70 */       if (this.k <= -1.0F) {
/*    */         return;
/*    */       }
/*    */       
/* 74 */       this.k += Gdx.graphics.getDeltaTime();
/* 75 */       this.l.color.a = 1.0F;
/* 76 */       this.l.setValue(1.0F);
/* 77 */       this.m.setValue(0.0F);
/*    */       
/* 79 */       if (this.k <= 0.2F) {
/* 80 */         float f1 = this.k / 0.2F;
/* 81 */         float f2 = (Gdx.app.getType() == Application.ApplicationType.Desktop) ? 12.0F : 18.0F;
/* 82 */         this.chart.innerRadius = f2 + f2 * f1;
/*    */       } else {
/* 84 */         this.k = -2.0F;
/* 85 */         Threads.i().postRunnable(this::remove);
/*    */         
/*    */         return;
/*    */       } 
/*    */     } 
/* 90 */     this.chart.requestVerticesRebuild();
/*    */     
/* 92 */     super.draw(paramBatch, paramFloat);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\actors\ButtonHoldHint.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */