/*     */ package com.prineside.tdi2.shapes;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.ResourcePack;
/*     */ import com.prineside.tdi2.Shape;
/*     */ 
/*     */ 
/*     */ public final class Circle
/*     */   extends Shape
/*     */ {
/*  13 */   private float[] a = new float[0];
/*     */   
/*     */   private int b;
/*     */   
/*     */   private float c;
/*     */   
/*     */   private float d;
/*     */   private float e;
/*     */   private float f;
/*     */   private float g;
/*     */   private float h;
/*  24 */   private final Vector2 i = new Vector2();
/*  25 */   private final Vector2 j = new Vector2();
/*  26 */   private final Vector2 k = new Vector2();
/*  27 */   private final Vector2 l = new Vector2();
/*  28 */   private final Vector2 m = new Vector2();
/*     */ 
/*     */   
/*     */   private boolean n;
/*     */ 
/*     */   
/*     */   private boolean o = true;
/*     */ 
/*     */   
/*     */   public final float getX() {
/*  38 */     return this.c;
/*     */   }
/*     */   
/*     */   public final float getY() {
/*  42 */     return this.d;
/*     */   }
/*     */   
/*     */   public final float getInnerColor() {
/*  46 */     return this.g;
/*     */   }
/*     */   
/*     */   public final float getOuterColor() {
/*  50 */     return this.h;
/*     */   }
/*     */   
/*     */   public final int getSegmentCount() {
/*  54 */     return this.b;
/*     */   }
/*     */   
/*     */   public final void setSegmentCount(int paramInt) {
/*  58 */     if (paramInt < 3) throw new IllegalArgumentException("Min segment count is 3, " + paramInt + " given"); 
/*  59 */     if (this.b != paramInt) {
/*  60 */       this.b = paramInt;
/*  61 */       this.o = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void setSkipOddSegments(boolean paramBoolean) {
/*  66 */     if (this.n != paramBoolean) {
/*  67 */       this.n = paramBoolean;
/*  68 */       this.o = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public final float getInnerRadius() {
/*  73 */     return this.e;
/*     */   }
/*     */   
/*     */   public final void setInnerRadius(float paramFloat) {
/*  77 */     if (this.e != paramFloat) {
/*  78 */       this.e = paramFloat;
/*  79 */       this.o = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public final float getOuterRadius() {
/*  84 */     return this.f;
/*     */   }
/*     */   
/*     */   public final void setOuterRadius(float paramFloat) {
/*  88 */     if (this.f != paramFloat) {
/*  89 */       this.f = paramFloat;
/*  90 */       this.o = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   private int a() {
/*  95 */     return (this.n ? (this.b / 2) : this.b) * 20;
/*     */   }
/*     */   
/*     */   public final void setPosition(float paramFloat1, float paramFloat2) {
/*  99 */     if (this.c != paramFloat1 || this.d != paramFloat2) {
/* 100 */       this.c = paramFloat1;
/* 101 */       this.d = paramFloat2;
/* 102 */       this.o = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void setColor(float paramFloat1, float paramFloat2) {
/* 107 */     if (this.g != paramFloat1 || this.h != paramFloat2) {
/* 108 */       this.g = paramFloat1;
/* 109 */       this.h = paramFloat2;
/* 110 */       this.o = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void setup(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, float paramFloat5, float paramFloat6) {
/* 115 */     setSegmentCount(paramInt);
/* 116 */     setPosition(paramFloat1, paramFloat2);
/* 117 */     setInnerRadius(paramFloat3);
/* 118 */     setOuterRadius(paramFloat4);
/* 119 */     setColor(paramFloat5, paramFloat6);
/*     */   }
/*     */   
/*     */   private void b() {
/* 123 */     float f1 = 6.2831855F / this.b;
/*     */     
/* 125 */     if (this.n && this.b % 2 == 1) {
/* 126 */       this.b++;
/*     */     }
/*     */ 
/*     */     
/* 130 */     int i = a();
/* 131 */     if (this.a.length < i) {
/* 132 */       this.a = new float[i];
/*     */     }
/*     */     
/*     */     ResourcePack.AtlasTextureRegion atlasTextureRegion;
/* 136 */     float f3 = (atlasTextureRegion = Game.i.assetManager.getBlankWhiteTextureRegion()).getU2() - atlasTextureRegion.getU();
/* 137 */     float f4 = atlasTextureRegion.getV2() - atlasTextureRegion.getV();
/* 138 */     f3 = atlasTextureRegion.getU() + f3 * 0.5F;
/* 139 */     float f2 = atlasTextureRegion.getV() + f4 * 0.5F;
/*     */     
/* 141 */     byte b1 = 0;
/* 142 */     for (byte b2 = 0; b2 < this.b; b2++) {
/*     */       
/* 144 */       if (!this.n || b2 % 2 != 0) {
/*     */ 
/*     */ 
/*     */         
/* 148 */         this.m.set(1.0F, 0.0F).rotateRad(f1 * b2);
/* 149 */         this.i.set(this.m).scl(this.e).add(this.c, this.d);
/* 150 */         this.k.set(this.m).scl(this.f).add(this.c, this.d);
/* 151 */         this.m.rotateRad(f1);
/* 152 */         this.j.set(this.m).scl(this.e).add(this.c, this.d);
/* 153 */         this.l.set(this.m).scl(this.f).add(this.c, this.d);
/*     */ 
/*     */         
/* 156 */         this.a[b1++] = this.i.x;
/* 157 */         this.a[b1++] = this.i.y;
/* 158 */         this.a[b1++] = this.g;
/* 159 */         this.a[b1++] = f3;
/* 160 */         this.a[b1++] = f2;
/*     */ 
/*     */         
/* 163 */         this.a[b1++] = this.j.x;
/* 164 */         this.a[b1++] = this.j.y;
/* 165 */         this.a[b1++] = this.g;
/* 166 */         this.a[b1++] = f3;
/* 167 */         this.a[b1++] = f2;
/*     */ 
/*     */         
/* 170 */         this.a[b1++] = this.l.x;
/* 171 */         this.a[b1++] = this.l.y;
/* 172 */         this.a[b1++] = this.h;
/* 173 */         this.a[b1++] = f3;
/* 174 */         this.a[b1++] = f2;
/*     */ 
/*     */         
/* 177 */         this.a[b1++] = this.k.x;
/* 178 */         this.a[b1++] = this.k.y;
/* 179 */         this.a[b1++] = this.h;
/* 180 */         this.a[b1++] = f3;
/* 181 */         this.a[b1++] = f2;
/*     */       } 
/* 183 */     }  this.o = false;
/*     */   }
/*     */   
/*     */   public final void draw(Batch paramBatch) {
/* 187 */     if (this.o) {
/* 188 */       b();
/*     */     }
/* 190 */     paramBatch.draw(Game.i.assetManager.getBlankWhiteTextureRegion().getTexture(), this.a, 0, a());
/*     */   }
/*     */ 
/*     */   
/*     */   public final void reset() {
/* 195 */     this.n = false;
/* 196 */     this.o = true;
/*     */   }
/*     */   
/*     */   public final void free() {
/* 200 */     Game.i.shapeManager.F.CIRCLE.free(this);
/*     */   }
/*     */   
/*     */   private Circle() {}
/*     */   
/*     */   public static class CircleFactory extends Shape.Factory<Circle> {
/*     */     public void setup() {}
/*     */     
/*     */     private static Circle b() {
/* 209 */       return new Circle((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\shapes\Circle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */