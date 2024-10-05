/*     */ package com.prineside.tdi2.ui.actors;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.FloatArray;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.enums.InterpolationType;
/*     */ import com.prineside.tdi2.enums.ShapeType;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.shapes.MultiLine;
/*     */ 
/*     */ public class LinearChartActor extends Actor {
/*     */   private MultiLine j;
/*  17 */   private float k = Color.WHITE.toFloatBits();
/*  18 */   private Color l = new Color(0.0F, 0.0F, 0.0F, 0.0F);
/*  19 */   private FloatArray m = new FloatArray();
/*  20 */   private float n = Float.NaN;
/*     */   private float o;
/*  22 */   private static Vector2 r = new Vector2();
/*     */   
/*     */   private float p;
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/*  27 */     if (this.s == null)
/*     */       return; 
/*  29 */     paramBatch.setColor(this.l);
/*  30 */     paramBatch.draw(this.s, getX(), getY(), getWidth(), getHeight());
/*     */     
/*  32 */     paramBatch.setColor(Color.WHITE);
/*  33 */     if (this.j != null) {
/*  34 */       this.j.draw(paramBatch);
/*     */     }
/*  36 */     paramBatch.setColor(Color.WHITE);
/*     */   }
/*     */   private float q; private TextureRegion s;
/*     */   public void setColor(Color paramColor1, Color paramColor2) {
/*  40 */     this.n = Float.NaN;
/*  41 */     this.k = paramColor1.toFloatBits();
/*  42 */     this.l.set(paramColor2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setChart(FloatArray paramFloatArray) {
/*  49 */     this.m.clear();
/*  50 */     this.m.addAll(paramFloatArray);
/*  51 */     this.n = Float.NaN;
/*     */   }
/*     */   
/*     */   public void setChartFromInterpolation(InterpolationType paramInterpolationType) {
/*  55 */     this.m.clear();
/*     */     
/*  57 */     Interpolation interpolation = InterpolationType.getObject(paramInterpolationType);
/*  58 */     for (double d = 0.0D; d <= 1.0D; d += 0.05D) {
/*  59 */       this.m.add(interpolation.apply((float)d));
/*     */     }
/*  61 */     this.n = Float.NaN;
/*     */   }
/*     */ 
/*     */   
/*     */   public void act(float paramFloat) {
/*  66 */     super.act(paramFloat);
/*     */     
/*  68 */     if (!isVisible() || this.m.size < 2)
/*     */       return; 
/*  70 */     if (this.s == null) {
/*  71 */       this.s = (TextureRegion)Game.i.assetManager.getTextureRegion("blank");
/*     */     }
/*     */     
/*  74 */     paramFloat = getWidth();
/*  75 */     float f = getHeight();
/*     */     
/*  77 */     r.setZero();
/*  78 */     localToStageCoordinates(r);
/*     */     
/*  80 */     if (r.x != this.n || r.y != this.o || paramFloat != this.p || f != this.q || this.j == null) {
/*  81 */       if (this.j == null) {
/*  82 */         this.j = (MultiLine)Game.i.shapeManager.getFactory(ShapeType.MULTI_LINE).obtain();
/*     */       }
/*     */       
/*  85 */       this.j.reset();
/*  86 */       this.j.setTextureRegion(this.s, false, false);
/*     */       
/*  88 */       float f1 = paramFloat / (this.m.size - 1);
/*     */       
/*  90 */       for (byte b = 0; b < this.m.size; b++) {
/*  91 */         float f2 = this.m.items[b];
/*     */         
/*  93 */         float f3 = r.x + b * f1;
/*  94 */         f2 = r.y + f2 * f;
/*  95 */         this.j.appendNode(f3, f2, 2.0F, this.k, false);
/*     */       } 
/*  97 */       this.j.updateAllNodes();
/*     */       
/*  99 */       this.n = r.x;
/* 100 */       this.o = r.y;
/* 101 */       this.p = paramFloat;
/* 102 */       this.q = f;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\actors\LinearChartActor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */