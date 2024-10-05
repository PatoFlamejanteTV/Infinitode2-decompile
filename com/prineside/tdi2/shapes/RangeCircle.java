/*     */ package com.prineside.tdi2.shapes;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Shape;
/*     */ import com.prineside.tdi2.enums.ShapeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RangeCircle
/*     */   extends Shape
/*     */ {
/*     */   private float a;
/*     */   private float b;
/*     */   private float c;
/*     */   private float d;
/*  18 */   private final Color e = new Color();
/*     */   
/*     */   private float f;
/*     */   
/*     */   private boolean g = false;
/*     */   private boolean h = false;
/*     */   private final Circle i;
/*     */   private final Circle j;
/*     */   private final Circle k;
/*     */   private final Circle l;
/*  28 */   private final Color m = new Color();
/*     */   
/*     */   private RangeCircle() {
/*  31 */     Circle.CircleFactory circleFactory = (Circle.CircleFactory)Game.i.shapeManager.getFactory(ShapeType.CIRCLE);
/*  32 */     this.i = (Circle)circleFactory.obtain();
/*  33 */     this.j = (Circle)circleFactory.obtain();
/*  34 */     this.k = (Circle)circleFactory.obtain();
/*  35 */     this.l = (Circle)circleFactory.obtain();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setup(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Color paramColor) {
/*  42 */     float f2 = paramColor.toFloatBits();
/*  43 */     this.e.set(paramColor);
/*  44 */     this.m.set(paramColor);
/*  45 */     this.m.a = 0.0F;
/*  46 */     float f1 = this.m.toFloatBits();
/*     */     
/*  48 */     if (paramFloat3 > 0.0F) {
/*     */       
/*  50 */       this.g = true;
/*     */       
/*  52 */       if (!this.h || this.c != paramFloat3 || this.d != paramFloat4)
/*     */       {
/*  54 */         this.j.setup(paramFloat1, paramFloat2, paramFloat3, paramFloat4 - (paramFloat4 - paramFloat3) * 0.5F, 32, f2, f1);
/*  55 */         this.i.setup(paramFloat1, paramFloat2, paramFloat3, paramFloat3 + 8.0F, 32, f2, f2);
/*     */       
/*     */       }
/*  58 */       else if (this.a != paramFloat1 || this.b != paramFloat2)
/*     */       {
/*  60 */         this.j.setPosition(paramFloat1, paramFloat2);
/*  61 */         this.i.setPosition(paramFloat1, paramFloat2);
/*     */         
/*  63 */         if (this.f != f2)
/*     */         {
/*  65 */           this.j.setColor(f2, f2);
/*  66 */           this.i.setColor(f2, f2);
/*     */         }
/*     */       
/*     */       }
/*  70 */       else if (this.f != f2)
/*     */       {
/*  72 */         this.j.setColor(f2, f1);
/*  73 */         this.i.setColor(f2, f2);
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/*  78 */       this.g = false;
/*     */     } 
/*     */ 
/*     */     
/*  82 */     if (!this.h || this.c != paramFloat3 || this.d != paramFloat4) {
/*     */       
/*  84 */       this.l.setup(paramFloat1, paramFloat2, paramFloat3 + (paramFloat4 - paramFloat3) * 0.5F, paramFloat4, 32, f1, f2);
/*  85 */       this.k.setup(paramFloat1, paramFloat2, paramFloat4 - 8.0F, paramFloat4, 32, f2, f2);
/*     */     
/*     */     }
/*  88 */     else if (this.a != paramFloat1 || this.b != paramFloat2) {
/*     */       
/*  90 */       this.l.setPosition(paramFloat1, paramFloat2);
/*  91 */       this.k.setPosition(paramFloat1, paramFloat2);
/*  92 */       if (this.f != f2)
/*     */       {
/*  94 */         this.l.setColor(f1, f2);
/*  95 */         this.k.setColor(f2, f2);
/*     */       }
/*     */     
/*     */     }
/*  99 */     else if (this.f != f2) {
/*     */       
/* 101 */       this.l.setColor(f1, f2);
/* 102 */       this.k.setColor(f2, f2);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 107 */     this.f = f2;
/* 108 */     this.c = paramFloat3;
/* 109 */     this.d = paramFloat4;
/* 110 */     this.a = paramFloat1;
/* 111 */     this.b = paramFloat2;
/* 112 */     this.h = true;
/*     */   }
/*     */   
/*     */   public float getX() {
/* 116 */     return this.a;
/*     */   }
/*     */   
/*     */   public float getY() {
/* 120 */     return this.b;
/*     */   }
/*     */   
/*     */   public float getMinRadius() {
/* 124 */     return this.c;
/*     */   }
/*     */   
/*     */   public float getMaxRadius() {
/* 128 */     return this.d;
/*     */   }
/*     */   
/*     */   public Color getColor() {
/* 132 */     return this.e;
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch) {
/* 137 */     if (!this.h) throw new IllegalStateException("Circle is not set up yet");
/*     */     
/* 139 */     if (this.g) {
/* 140 */       this.j.draw(paramBatch);
/* 141 */       this.i.draw(paramBatch);
/*     */     } 
/* 143 */     this.l.draw(paramBatch);
/* 144 */     this.k.draw(paramBatch);
/*     */   }
/*     */ 
/*     */   
/*     */   public void reset() {
/* 149 */     this.h = false;
/*     */   }
/*     */   
/*     */   public static class RangeCircleFactory
/*     */     extends Shape.Factory<RangeCircle>
/*     */   {
/*     */     public void setup() {}
/*     */     
/*     */     private static RangeCircle b() {
/* 158 */       return new RangeCircle((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\shapes\RangeCircle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */