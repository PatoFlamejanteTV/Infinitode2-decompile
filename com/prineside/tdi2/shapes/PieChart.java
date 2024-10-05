/*     */ package com.prineside.tdi2.shapes;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Shape;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ public class PieChart extends Shape {
/*  16 */   private static final TLog a = TLog.forClass(PieChart.class);
/*     */ 
/*     */ 
/*     */   
/*  20 */   private float[] b = new float[0];
/*     */   
/*     */   private int c;
/*     */   private int d;
/*     */   private float e;
/*     */   private float f;
/*     */   private float g;
/*     */   private int h;
/*     */   private boolean i;
/*     */   private Array<ChartEntryConfig> j;
/*  30 */   public float innerRadius = 0.0F;
/*  31 */   public float angleShiftRad = 0.0F;
/*  32 */   public float rotationDirection = 1.0F;
/*     */   
/*  34 */   private final Vector2 k = new Vector2();
/*  35 */   private final Vector2 l = new Vector2();
/*  36 */   private final Vector2 m = new Vector2();
/*  37 */   private final Vector2 n = new Vector2();
/*  38 */   private final Vector2 o = new Vector2();
/*  39 */   private final Vector2 p = new Vector2();
/*     */   
/*     */   private final TextureRegion q;
/*     */   
/*     */   private float r;
/*     */   private float s;
/*  45 */   private final Color t = new Color();
/*     */   
/*     */   private boolean u = false;
/*     */   
/*     */   private PieChart() {
/*  50 */     this.q = (TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion();
/*  51 */     float f1 = this.q.getU2() - this.q.getU();
/*  52 */     float f2 = this.q.getV2() - this.q.getV();
/*  53 */     this.r = this.q.getU() + f1 * 0.5F;
/*  54 */     this.s = this.q.getV() + f2 * 0.5F;
/*     */   }
/*     */   
/*     */   public void requestVerticesRebuild() {
/*  58 */     this.u = false;
/*     */   }
/*     */   
/*     */   public void setShadowSegments(int paramInt) {
/*  62 */     this.h = paramInt;
/*  63 */     this.u = false;
/*     */   }
/*     */   
/*     */   public void setFadeToOut(boolean paramBoolean) {
/*  67 */     this.i = paramBoolean;
/*  68 */     this.u = false;
/*     */   }
/*     */   
/*     */   public float getX() {
/*  72 */     return this.e;
/*     */   }
/*     */   
/*     */   public float getY() {
/*  76 */     return this.f;
/*     */   }
/*     */   
/*     */   public void setup(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, Array<ChartEntryConfig> paramArray) {
/*  80 */     if (paramInt < 3) throw new IllegalArgumentException("Min segment count is 3, " + paramInt + " given");
/*     */     
/*  82 */     this.d = paramInt;
/*  83 */     this.e = paramFloat1;
/*  84 */     this.f = paramFloat2;
/*  85 */     this.g = paramFloat3;
/*  86 */     this.j = paramArray;
/*  87 */     this.u = false;
/*     */   }
/*     */   
/*     */   private void a() {
/*  91 */     if (this.j == null || this.j.size == 0) {
/*     */       return;
/*     */     }
/*  94 */     float f1 = 0.0F; int i, j;
/*  95 */     for (i = 0, j = this.j.size; i < j; i++) {
/*  96 */       f1 += ChartEntryConfig.a((ChartEntryConfig)this.j.get(i));
/*     */     }
/*  98 */     if (f1 <= 0.0F || Float.isNaN(f1) || Float.isInfinite(f1)) {
/*     */       
/* 100 */       a.e("invalid values sum: " + f1, new Object[0]);
/* 101 */       for (i = 0, j = this.j.size; i < j; i++) {
/* 102 */         a.e(ChartEntryConfig.a((ChartEntryConfig)this.j.get(i)), new Object[0]);
/*     */       }
/* 104 */       this.c = 0;
/* 105 */       this.u = true;
/*     */       
/*     */       return;
/*     */     } 
/* 109 */     i = 0; int k;
/* 110 */     for (j = 0, k = this.j.size; j < k; j++) {
/*     */       ChartEntryConfig chartEntryConfig;
/* 112 */       if (ChartEntryConfig.a(chartEntryConfig = (ChartEntryConfig)this.j.get(j)) < 0.0F) {
/* 113 */         throw new IllegalArgumentException("Config #" + j + " value must be >= 0, " + ChartEntryConfig.a(chartEntryConfig) + " given");
/*     */       }
/* 115 */       ChartEntryConfig.a(chartEntryConfig, MathUtils.round(ChartEntryConfig.a(chartEntryConfig) / f1 * this.d));
/* 116 */       i += ChartEntryConfig.b(chartEntryConfig);
/*     */     } 
/*     */ 
/*     */     
/* 120 */     this.c = i * 20;
/* 121 */     if (this.h != 0) {
/* 122 */       this.c += (this.j.size << 1) * 20;
/*     */     }
/* 124 */     if (this.b.length < this.c)
/*     */     {
/* 126 */       this.b = new float[MathUtils.nextPowerOfTwo(this.c)];
/*     */     }
/*     */     
/* 129 */     float f2 = 6.2831855F / i;
/* 130 */     k = 0;
/* 131 */     int m = StrictMath.abs(this.h);
/* 132 */     for (byte b = 0; b < i; b++) {
/*     */       ChartEntryConfig chartEntryConfig;
/*     */ 
/*     */       
/* 136 */       if ((chartEntryConfig = (ChartEntryConfig)this.j.get(b)).segmentShift > 0.0F && this.j.size > 1) {
/* 137 */         this.p.set(1.0F, 0.0F).rotateRad(ChartEntryConfig.b(chartEntryConfig) * f2 * 0.5F + f2 * k).scl(chartEntryConfig.segmentShift);
/*     */       } else {
/* 139 */         this.p.set(0.0F, 0.0F);
/*     */       } 
/*     */       
/* 142 */       float f3 = chartEntryConfig.color.toFloatBits();
/* 143 */       float f4 = this.t.set(chartEntryConfig.color).mul(1.2F, 1.2F, 1.2F, 1.0F).toFloatBits();
/* 144 */       float f5 = this.t.set(chartEntryConfig.color).mul(0.8F, 0.8F, 0.8F, 1.0F).toFloatBits();
/* 145 */       float f6 = this.t.set(chartEntryConfig.color).mul(1.0F, 1.0F, 1.0F, 0.0F).toFloatBits();
/*     */       
/* 147 */       for (byte b1 = 0; b1 < ChartEntryConfig.b(chartEntryConfig); b1++) {
/*     */         
/* 149 */         this.o.set(1.0F, 0.0F).rotateRad(f2 * k * this.rotationDirection + this.angleShiftRad);
/* 150 */         this.l.set(this.o).scl(this.g).add(this.e, this.f);
/* 151 */         this.k.set(this.o).scl(this.innerRadius).add(this.e, this.f);
/* 152 */         this.o.rotateRad(f2 * this.rotationDirection + this.angleShiftRad);
/* 153 */         this.n.set(this.o).scl(this.g).add(this.e, this.f);
/* 154 */         this.m.set(this.o).scl(this.innerRadius).add(this.e, this.f);
/*     */         
/* 156 */         int n = k * 20;
/*     */         
/* 158 */         float f = f3;
/* 159 */         if (b1 < m) {
/* 160 */           if (this.h < 0) {
/* 161 */             f = 0.0F;
/*     */           } else {
/* 163 */             f = f4;
/*     */           } 
/* 165 */         } else if (b1 > ChartEntryConfig.b(chartEntryConfig) - 1 - m) {
/* 166 */           if (this.h < 0) {
/* 167 */             f = 0.0F;
/*     */           } else {
/* 169 */             f = f5;
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 174 */         this.b[n] = this.k.x + this.p.x;
/* 175 */         this.b[n + 1] = this.k.y + this.p.y;
/* 176 */         this.b[n + 2] = f;
/* 177 */         this.b[n + 3] = this.r;
/* 178 */         this.b[n + 4] = this.s;
/*     */ 
/*     */         
/* 181 */         this.b[n + 5] = this.m.x + this.p.x;
/* 182 */         this.b[n + 6] = this.m.y + this.p.y;
/* 183 */         this.b[n + 7] = f;
/* 184 */         this.b[n + 8] = this.r;
/* 185 */         this.b[n + 9] = this.s;
/*     */ 
/*     */         
/* 188 */         this.b[n + 10] = this.n.x + this.p.x;
/* 189 */         this.b[n + 11] = this.n.y + this.p.y;
/* 190 */         this.b[n + 12] = this.i ? f6 : f;
/* 191 */         this.b[n + 13] = this.r;
/* 192 */         this.b[n + 14] = this.s;
/*     */ 
/*     */         
/* 195 */         this.b[n + 15] = this.l.x + this.p.x;
/* 196 */         this.b[n + 16] = this.l.y + this.p.y;
/* 197 */         this.b[n + 17] = this.i ? f6 : f;
/* 198 */         this.b[n + 18] = this.r;
/* 199 */         this.b[n + 19] = this.s;
/*     */         
/* 201 */         k++;
/*     */       } 
/*     */     } 
/* 204 */     this.u = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch) {
/* 209 */     if (this.j == null || this.j.size == 0)
/*     */       return; 
/* 211 */     if (!this.u) {
/* 212 */       a();
/*     */     }
/* 214 */     if (this.c == 0)
/*     */       return; 
/* 216 */     paramBatch.draw(this.q.getTexture(), this.b, 0, this.c);
/*     */   }
/*     */ 
/*     */   
/*     */   public void reset() {
/* 221 */     this.j = null;
/* 222 */     this.h = 0;
/* 223 */     this.u = false;
/* 224 */     this.i = false;
/*     */   }
/*     */   
/*     */   public void free() {
/* 228 */     Game.i.shapeManager.F.PIE_CHART.free(this);
/*     */   }
/*     */   
/*     */   public static class ChartEntryConfig {
/* 232 */     public Color color = new Color();
/*     */     
/*     */     private float a;
/*     */     
/*     */     public float segmentShift;
/*     */     public Object userObject;
/*     */     private int b;
/*     */     
/*     */     public ChartEntryConfig(Color param1Color, float param1Float1, float param1Float2) {
/* 241 */       this.color.set(param1Color);
/* 242 */       this.a = param1Float1;
/* 243 */       this.segmentShift = param1Float2;
/*     */     }
/*     */     
/*     */     public float getValue() {
/* 247 */       return this.a;
/*     */     }
/*     */     
/*     */     public void setValue(float param1Float) {
/* 251 */       Preconditions.checkArgument((PMath.isFinite(param1Float) && param1Float >= 0.0F), "Value must be >= 0, %s given", Float.valueOf(param1Float));
/* 252 */       this.a = param1Float;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class PieChartFactory
/*     */     extends Shape.Factory<PieChart>
/*     */   {
/*     */     public void setup() {}
/*     */     
/*     */     private static PieChart b() {
/* 262 */       return new PieChart((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\shapes\PieChart.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */