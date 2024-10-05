/*     */ package com.prineside.tdi2.shapes;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.FloatArray;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.ProjectileTrail;
/*     */ import com.prineside.tdi2.Shape;
/*     */ import com.prineside.tdi2.enums.ShapeType;
/*     */ import com.prineside.tdi2.utils.FastRandom;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ 
/*     */ 
/*     */ public final class BulletSmokeMultiLine
/*     */   extends Shape
/*     */   implements ProjectileTrail
/*     */ {
/*     */   private final MultiLine a;
/*  23 */   private int b = 0;
/*     */   private float[] c;
/*     */   private float[] d;
/*     */   private float[] e;
/*     */   private float[] f;
/*     */   private float[] g;
/*     */   private boolean h;
/*     */   private boolean i;
/*  31 */   private final Color j = new Color(-1);
/*     */   
/*     */   public float nodesDisperseTime;
/*     */   
/*     */   public float maxSegmentWidth;
/*     */   public float maxAlpha;
/*     */   public boolean fadeInOut;
/*  38 */   public float minSegmentWidth = 0.1F;
/*     */   
/*  40 */   private final FloatArray k = new FloatArray();
/*  41 */   private final Vector2 l = new Vector2();
/*     */   
/*     */   private BulletSmokeMultiLine() {
/*  44 */     this.a = (MultiLine)Game.i.shapeManager.getFactory(ShapeType.MULTI_LINE).obtain();
/*  45 */     reset();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void reset() {
/*  50 */     this.h = false;
/*  51 */     this.nodesDisperseTime = 3.0F;
/*  52 */     this.maxSegmentWidth = 96.0F;
/*  53 */     this.maxAlpha = 0.14F;
/*  54 */     this.minSegmentWidth = 0.1F;
/*  55 */     this.fadeInOut = false;
/*  56 */     this.a.setTint(Color.WHITE);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setup(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*     */     float f2;
/*     */     int i;
/*  63 */     if ((i = (int)((f2 = PMath.getDistanceBetweenPoints(paramFloat1, paramFloat2, paramFloat3, paramFloat4)) / 96.0F)) < 3) {
/*  64 */       i = 3;
/*     */     }
/*     */     
/*  67 */     if (this.b < i) {
/*     */       
/*  69 */       this.c = new float[i << 2];
/*  70 */       this.d = new float[i];
/*  71 */       this.e = new float[i];
/*  72 */       this.f = new float[i];
/*  73 */       this.g = new float[i];
/*     */     } 
/*     */     
/*  76 */     this.b = i;
/*     */ 
/*     */     
/*  79 */     this.k.clear();
/*  80 */     float f3 = 0.0F;
/*     */ 
/*     */     
/*  83 */     this.k.add(0.0F);
/*  84 */     for (byte b3 = 1; b3 < i; b3++) {
/*  85 */       float f = 64.0F + 64.0F * FastRandom.getFloat();
/*  86 */       if (b3 == 1 || b3 == i - 1) {
/*  87 */         f *= 0.1F;
/*     */       }
/*  89 */       f3 += f;
/*  90 */       this.k.add(f);
/*     */     } 
/*  92 */     float f4 = f2 / f3;
/*     */ 
/*     */     
/*  95 */     this.l.set(paramFloat3 - paramFloat1, paramFloat4 - paramFloat2);
/*  96 */     this.l.nor();
/*     */     
/*  98 */     float f5 = 0.0F;
/*  99 */     for (byte b1 = 0; b1 < this.b; b1++) {
/* 100 */       paramFloat4 = this.k.get(b1) * f4;
/* 101 */       this.c[b1 << 2] = paramFloat1 + this.l.x * (paramFloat4 + f5);
/* 102 */       this.c[(b1 << 2) + 1] = paramFloat2 + this.l.y * (paramFloat4 + f5);
/* 103 */       f5 += paramFloat4;
/*     */     } 
/*     */ 
/*     */     
/* 107 */     float f1 = 0.0F; byte b2;
/* 108 */     for (b2 = 0; b2 < this.b; b2++) {
/* 109 */       this.e[b2] = 0.0F;
/* 110 */       this.d[b2] = f1;
/* 111 */       f1 += 0.017F;
/*     */     } 
/*     */ 
/*     */     
/* 115 */     for (b2 = 0; b2 < this.b; b2++) {
/* 116 */       this.f[b2] = (FastRandom.getFloat() - 0.5F) * 20.0F;
/* 117 */       this.g[b2] = (FastRandom.getFloat() - 0.5F) * 20.0F;
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void setTexture(TextureRegion paramTextureRegion, boolean paramBoolean1, boolean paramBoolean2) {
/* 122 */     this.a.setTextureRegion(paramTextureRegion, paramBoolean1, paramBoolean2);
/*     */   }
/*     */   
/*     */   public final void setColor(Color paramColor) {
/* 126 */     this.j.set(paramColor);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/* 131 */     this.i = true; byte b;
/* 132 */     for (b = 0; b < this.b; b++) {
/* 133 */       this.e[b] = this.e[b] + paramFloat;
/* 134 */       if (this.e[b] - this.d[b] < this.nodesDisperseTime)
/*     */       {
/* 136 */         this.i = false;
/*     */       }
/*     */     } 
/* 139 */     if (this.i) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 144 */     for (b = 0; b < this.b; b++) {
/*     */       float f;
/*     */       
/* 147 */       if ((f = (this.e[b] - this.d[b]) / this.nodesDisperseTime) > 0.0F) {
/*     */         
/* 149 */         if (f >= 1.0F) {
/*     */           
/* 151 */           this.j.a = 0.0F;
/* 152 */           f = 1.0F;
/*     */         } else {
/*     */           
/* 155 */           if (this.fadeInOut) {
/*     */             
/* 157 */             float f1 = MathUtils.sin(f * 3.1415927F);
/* 158 */             this.j.a = f1 * this.maxAlpha;
/*     */           } else {
/*     */             
/* 161 */             this.j.a = (1.0F - f) * this.maxAlpha;
/*     */           } 
/* 163 */           f = Interpolation.pow2.apply(f);
/*     */ 
/*     */           
/* 166 */           this.c[b << 2] = this.c[b << 2] + this.f[b] * paramFloat;
/* 167 */           this.c[(b << 2) + 1] = this.c[(b << 2) + 1] + this.g[b] * paramFloat;
/*     */         } 
/*     */       } else {
/*     */         
/* 171 */         f = 0.0F;
/* 172 */         this.j.a = 0.0F;
/*     */       } 
/* 174 */       this.c[(b << 2) + 2] = (this.minSegmentWidth + Interpolation.pow2Out.apply(f)) * this.maxSegmentWidth;
/* 175 */       this.c[(b << 2) + 3] = this.j.toFloatBits();
/*     */     } 
/*     */ 
/*     */     
/* 179 */     this.j.a = 0.0F;
/* 180 */     this.c[3] = this.j.toFloatBits();
/* 181 */     this.c[(this.b - 1 << 2) + 3] = this.c[3];
/*     */     
/* 183 */     this.a.setNodes(this.c);
/*     */     
/* 185 */     this.h = true;
/*     */     
/* 187 */     this.a.bakeVerticesColorIfNeeded();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void draw(Batch paramBatch) {
/* 192 */     if (!this.h)
/*     */       return; 
/* 194 */     this.a.draw(paramBatch);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isFinished() {
/* 199 */     return this.i;
/*     */   }
/*     */   
/*     */   public final void free() {
/* 203 */     Game.i.shapeManager.F.BULLET_SMOKE_MULTI_LINE.free(this);
/*     */   }
/*     */   
/*     */   public static class BulletSmokeMultiLineFactory
/*     */     extends Shape.Factory<BulletSmokeMultiLine>
/*     */   {
/*     */     public void setup() {}
/*     */     
/*     */     private static BulletSmokeMultiLine b() {
/* 212 */       return new BulletSmokeMultiLine((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\shapes\BulletSmokeMultiLine.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */