/*     */ package com.prineside.tdi2.shapes;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.FloatArray;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Shape;
/*     */ import com.prineside.tdi2.enums.ShapeType;
/*     */ import com.prineside.tdi2.utils.FastRandom;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ 
/*     */ 
/*     */ public final class ChainLightning
/*     */   extends Shape
/*     */ {
/*     */   public static final float AVERAGE_SEGMENT_LENGTH = 16.0F;
/*     */   public static final float MIN_SEGMENT_WIDTH = 8.96F;
/*     */   public static final float MAX_SEGMENT_WIDTH = 44.8F;
/*     */   private float a;
/*     */   private float b;
/*     */   private float c;
/*     */   private float d;
/*     */   private float e;
/*     */   private float f;
/*  27 */   private final Vector2 g = new Vector2();
/*  28 */   private final Vector2 h = new Vector2();
/*  29 */   private float i = 1.0F;
/*     */   
/*     */   private final MultiLine j;
/*  32 */   private int k = 0;
/*     */   
/*     */   private float[] l;
/*     */   
/*     */   private boolean m;
/*     */   
/*     */   private float n;
/*     */   private float o;
/*     */   private float p;
/*     */   private boolean q;
/*     */   private boolean r;
/*     */   private float s;
/*  44 */   private static final Color t = Color.WHITE.cpy();
/*  45 */   private final Color u = new Color(-1);
/*  46 */   private final FloatArray v = new FloatArray(8);
/*     */   
/*  48 */   private final Vector2 w = new Vector2();
/*  49 */   private final Color x = new Color(-1);
/*     */   
/*     */   private ChainLightning() {
/*  52 */     this.j = (MultiLine)Game.i.shapeManager.getFactory(ShapeType.MULTI_LINE).obtain();
/*  53 */     reset();
/*     */   }
/*     */   
/*     */   public final void setFadingToEnd(boolean paramBoolean) {
/*  57 */     this.r = paramBoolean;
/*     */   }
/*     */   
/*     */   public final float getExistsTime() {
/*  61 */     return this.s;
/*     */   }
/*     */   
/*     */   public final float getStartX() {
/*  65 */     return this.d;
/*     */   }
/*     */   
/*     */   public final float getStartY() {
/*  69 */     return this.e;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void reset() {
/*  74 */     this.m = false;
/*  75 */     this.r = false;
/*     */   }
/*     */   
/*     */   public final void setPosition(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  79 */     this.d = paramFloat1;
/*  80 */     this.e = paramFloat2;
/*     */     
/*  82 */     this.f = PMath.getDistanceBetweenPoints(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*  83 */     this.g.set(paramFloat3 - paramFloat1, paramFloat4 - paramFloat2);
/*  84 */     this.h.set(paramFloat3 - paramFloat1, paramFloat4 - paramFloat2);
/*  85 */     this.h.nor();
/*     */     
/*     */     int i;
/*  88 */     if ((i = (int)(this.f / this.a)) < 3) {
/*  89 */       i = 3;
/*     */     }
/*     */     
/*  92 */     if (this.k < i)
/*     */     {
/*  94 */       this.l = new float[i << 2];
/*     */     }
/*     */     
/*  97 */     this.k = i;
/*     */ 
/*     */     
/* 100 */     for (i = 0; i < this.k; i++) {
/*     */       
/* 102 */       if ((paramFloat2 = i / this.k * 2.0F) > 1.0F) paramFloat2 = 1.0F - paramFloat2 - 1.0F;
/*     */       
/* 104 */       this.l[(i << 2) + 2] = this.b + (this.c - this.b) * paramFloat2;
/*     */     } 
/*     */     
/* 107 */     setColor(this.u);
/*     */   }
/*     */   
/*     */   public final void setup(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean, float paramFloat7, float paramFloat8, float paramFloat9) {
/* 111 */     this.o = paramFloat5;
/* 112 */     this.s = 0.0F;
/* 113 */     this.p = paramFloat6;
/* 114 */     this.q = paramBoolean;
/*     */     
/* 116 */     this.b = paramFloat7;
/* 117 */     this.c = paramFloat8;
/* 118 */     this.a = paramFloat9;
/*     */     
/* 120 */     this.i = paramFloat9 / 16.0F;
/*     */     
/* 122 */     setPosition(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */   
/*     */   public final void setTexture(TextureRegion paramTextureRegion, boolean paramBoolean1, boolean paramBoolean2) {
/* 126 */     this.j.setTextureRegion(paramTextureRegion, paramBoolean1, paramBoolean2);
/*     */   }
/*     */   
/*     */   public final void setColor(Color paramColor) {
/* 130 */     this.u.set(paramColor);
/*     */     
/* 132 */     if (this.r) {
/* 133 */       this.x.set(paramColor);
/* 134 */       for (byte b1 = 0; b1 < this.k; b1++) {
/* 135 */         paramColor.a *= 1.0F - b1 / this.k;
/* 136 */         this.l[(b1 << 2) + 3] = this.x.toFloatBits();
/*     */       }  return;
/*     */     } 
/* 139 */     float f = paramColor.toFloatBits();
/* 140 */     for (byte b = 0; b < this.k; b++) {
/* 141 */       this.l[(b << 2) + 3] = f;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final Color getColor() {
/* 147 */     return this.u;
/*     */   }
/*     */ 
/*     */   
/*     */   private void a() {
/* 152 */     this.v.clear();
/*     */ 
/*     */     
/* 155 */     this.v.add(0.0F);
/* 156 */     this.v.add(1.0F); byte b1; int i;
/* 157 */     for (b1 = 2, i = this.k; b1 < i; b1++) {
/* 158 */       this.v.add(FastRandom.getFloat());
/*     */     }
/* 160 */     this.v.sort();
/*     */ 
/*     */     
/* 163 */     Vector2 vector2 = this.w.set(this.g.y, -this.g.x).nor();
/* 164 */     float f1 = 80.0F * this.i;
/* 165 */     float f2 = 1.0F / f1;
/* 166 */     float f3 = 0.0F;
/*     */     
/* 168 */     this.l[0] = this.d;
/* 169 */     this.l[1] = this.e;
/*     */     
/* 171 */     for (byte b2 = 1; b2 < this.k; b2++) {
/* 172 */       float f4 = this.v.items[b2];
/*     */ 
/*     */       
/* 175 */       float f5 = this.f * f2 * (f4 - this.v.items[b2 - 1]);
/*     */ 
/*     */       
/* 178 */       float f6 = (f4 > 0.95F) ? (20.0F * (1.0F - f4)) : 1.0F;
/*     */ 
/*     */ 
/*     */       
/* 182 */       float f7 = (f7 = (f7 = -f1 + FastRandom.getFloat() * f1 * 2.0F) - (f7 - f3) * (1.0F - f5)) * f6;
/*     */       
/* 184 */       this.l[b2 << 2] = this.d + f4 * this.g.x + f7 * vector2.x;
/* 185 */       this.l[(b2 << 2) + 1] = this.e + f4 * this.g.y + f7 * vector2.y;
/*     */       
/* 187 */       f3 = f7;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 194 */     this.j.setNodesWithCount(this.l, this.k);
/* 195 */     t.a = 1.0F;
/* 196 */     this.j.setTint(t);
/*     */     
/* 198 */     this.m = true;
/*     */   }
/*     */   
/*     */   public final void update(float paramFloat) {
/* 202 */     this.n += paramFloat;
/* 203 */     if (!this.m || this.n > this.o) {
/* 204 */       a();
/* 205 */       this.n = 0.0F;
/*     */     } 
/*     */     
/* 208 */     this.s += paramFloat;
/* 209 */     if (this.q) {
/*     */       
/* 211 */       if ((paramFloat = 1.0F - this.s / this.p) < 0.0F) paramFloat = 0.0F;
/*     */       
/* 213 */       t.a = paramFloat;
/* 214 */       this.j.setTint(t);
/*     */     } 
/*     */   }
/*     */   
/*     */   public final boolean isFinished() {
/* 219 */     return (this.s > this.p);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void draw(Batch paramBatch) {
/* 224 */     if (!this.m)
/*     */       return; 
/* 226 */     this.j.draw(paramBatch);
/*     */   }
/*     */   
/*     */   public final void free() {
/* 230 */     Game.i.shapeManager.F.CHAIN_LIGHTNING.free(this);
/*     */   }
/*     */   
/*     */   public static class ChainLightningFactory
/*     */     extends Shape.Factory<ChainLightning>
/*     */   {
/*     */     public void setup() {}
/*     */     
/*     */     private static ChainLightning b() {
/* 239 */       return new ChainLightning((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\shapes\ChainLightning.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */