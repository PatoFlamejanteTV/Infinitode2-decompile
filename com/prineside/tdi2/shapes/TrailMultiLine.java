/*     */ package com.prineside.tdi2.shapes;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.FloatArray;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.ProjectileTrail;
/*     */ import com.prineside.tdi2.ResourcePack;
/*     */ import com.prineside.tdi2.Shape;
/*     */ import com.prineside.tdi2.managers.AssetManager;
/*     */ import com.prineside.tdi2.utils.IgnoreMethodOverloadLuaDefWarning;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ public final class TrailMultiLine extends Shape implements ProjectileTrail {
/*     */   static {
/*  17 */     TLog.forClass(TrailMultiLine.class);
/*     */   }
/*     */ 
/*     */   
/*     */   private float a;
/*     */   
/*     */   private float b;
/*     */   private float c;
/*  25 */   private final Color d = new Color();
/*  26 */   private final FloatArray e = new FloatArray();
/*  27 */   private final FloatArray f = new FloatArray();
/*     */   
/*     */   private float g;
/*     */   private float h;
/*     */   private boolean i;
/*     */   private boolean j;
/*     */   
/*     */   public final TrailMultiLine cloneTrail() {
/*     */     TrailMultiLine trailMultiLine;
/*  36 */     (trailMultiLine = TrailMultiLineFactory.b()).setup(this.d, this.c * 2.0F, 1.0F / this.a, (float)Math.sqrt(this.b));
/*  37 */     return trailMultiLine;
/*     */   }
/*     */   
/*     */   public final void setup(Color paramColor, float paramFloat1, float paramFloat2, float paramFloat3) {
/*  41 */     this.c = paramFloat1 * 0.5F;
/*  42 */     paramFloat3 = Math.max(paramFloat3, this.c);
/*  43 */     this.a = 1.0F / paramFloat2;
/*  44 */     this.b = paramFloat3 * paramFloat3;
/*  45 */     this.d.set(paramColor);
/*     */ 
/*     */     
/*  48 */     this.i = false;
/*  49 */     this.j = false;
/*  50 */     this.e.clear();
/*  51 */     this.f.clear();
/*     */   }
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public final void setColor(Color paramColor) {
/*  56 */     this.d.set(paramColor);
/*     */   }
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public final void setColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  61 */     this.d.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */   
/*     */   public final Color getColor() {
/*  65 */     return this.d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setStartPoint(float paramFloat1, float paramFloat2) {
/*  72 */     this.e.clear();
/*  73 */     this.f.clear();
/*  74 */     this.g = paramFloat1;
/*  75 */     this.h = paramFloat2;
/*  76 */     this.e.setSize(10);
/*  77 */     this.e.items[0] = paramFloat1;
/*  78 */     this.e.items[1] = paramFloat2;
/*  79 */     this.e.items[2] = 0.0F;
/*  80 */     this.e.items[3] = 0.0F;
/*  81 */     this.e.items[4] = 0.0F;
/*  82 */     this.e.items[5] = paramFloat1;
/*  83 */     this.e.items[6] = paramFloat2;
/*  84 */     this.e.items[7] = 0.0F;
/*  85 */     this.e.items[8] = 0.0F;
/*  86 */     this.e.items[9] = 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   private void a() {
/*  91 */     float[] arrayOfFloat = this.e.items;
/*     */     Vector2 vector2;
/*  93 */     (vector2 = new Vector2()).set(arrayOfFloat[5] - arrayOfFloat[0], arrayOfFloat[6] - arrayOfFloat[1]).nor().rotate90(0);
/*  94 */     arrayOfFloat[2] = vector2.x;
/*  95 */     arrayOfFloat[3] = vector2.y;
/*     */     
/*  97 */     if (this.e.size == 10) {
/*     */       
/*  99 */       vector2.setZero();
/*     */     } else {
/*     */       
/* 102 */       vector2.set(arrayOfFloat[10] - arrayOfFloat[5], arrayOfFloat[11] - arrayOfFloat[6]).nor().rotate90(0);
/*     */     } 
/*     */     
/* 105 */     arrayOfFloat[7] = vector2.x;
/* 106 */     arrayOfFloat[8] = vector2.y;
/*     */   }
/*     */   
/*     */   public final void setHeadPositionAndAngle(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 110 */     if (isFinished())
/*     */       return; 
/*     */     float f;
/* 113 */     if ((f = PMath.getSquareDistanceBetweenPoints(this.g, this.h, paramFloat1, paramFloat2)) > this.b) {
/*     */       
/* 115 */       this.e.setSize(this.e.size + 5);
/* 116 */       System.arraycopy(this.e.items, 0, this.e.items, 5, this.e.size - 5);
/* 117 */       this.g = paramFloat1;
/* 118 */       this.h = paramFloat2;
/*     */     } 
/*     */     Vector2 vector2;
/* 121 */     (vector2 = new Vector2(1.0F, 0.0F)).rotateDeg(paramFloat3);
/*     */     
/* 123 */     this.e.items[0] = paramFloat1;
/* 124 */     this.e.items[1] = paramFloat2;
/* 125 */     this.e.items[2] = vector2.x;
/* 126 */     this.e.items[3] = vector2.y;
/* 127 */     this.e.items[4] = 1.0F;
/*     */   }
/*     */   
/*     */   public final void setHeadPosition(float paramFloat1, float paramFloat2) {
/* 131 */     if (isFinished())
/*     */       return; 
/* 133 */     if (this.e.items[0] == paramFloat1 && this.e.items[1] == paramFloat2) {
/*     */       return;
/*     */     }
/*     */     
/*     */     float f;
/* 138 */     if ((f = PMath.getSquareDistanceBetweenPoints(this.g, this.h, paramFloat1, paramFloat2)) > this.b) {
/*     */       
/* 140 */       this.e.setSize(this.e.size + 5);
/* 141 */       System.arraycopy(this.e.items, 0, this.e.items, 5, this.e.size - 5);
/* 142 */       this.g = paramFloat1;
/* 143 */       this.h = paramFloat2;
/*     */     } 
/* 145 */     this.e.items[0] = paramFloat1;
/* 146 */     this.e.items[1] = paramFloat2;
/* 147 */     this.e.items[4] = 1.0F;
/*     */     
/* 149 */     a();
/*     */   }
/*     */   
/*     */   public final void allowCompletion() {
/* 153 */     this.j = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isFinished() {
/* 158 */     return (this.i && this.j);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/* 164 */     paramFloat = this.a * paramFloat;
/* 165 */     float[] arrayOfFloat1 = this.e.items;
/* 166 */     int i = this.e.size / 5;
/* 167 */     boolean bool = false;
/* 168 */     int j = 0;
/* 169 */     for (byte b1 = 0; b1 < i; b1++) {
/*     */       float f;
/*     */       
/* 172 */       if ((f = (f = arrayOfFloat1[b1 * 5 + 4]) - paramFloat) > 0.0F)
/*     */       
/* 174 */       { arrayOfFloat1[b1 * 5 + 4] = f;
/* 175 */         bool = true;
/* 176 */         j++;
/*     */          }
/*     */       
/* 179 */       else if (bool)
/*     */       
/* 181 */       { arrayOfFloat1[b1 * 5 + 4] = 0.0F;
/* 182 */         j++;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 187 */         bool = false; }
/*     */       else { break; }
/*     */     
/* 190 */     }  this.i = (j == 0);
/* 191 */     this.e.setSize(Math.max(10, j * 5));
/*     */     
/*     */     ResourcePack.AtlasTextureRegion atlasTextureRegion;
/*     */     
/* 195 */     float f3 = (atlasTextureRegion = (AssetManager.TextureRegions.i()).bulletTraceThin).getU();
/* 196 */     paramFloat = atlasTextureRegion.getU2();
/* 197 */     float f1 = atlasTextureRegion.getV();
/* 198 */     float f2 = atlasTextureRegion.getV2();
/*     */     
/* 200 */     j = this.e.size / 5 - 1;
/* 201 */     this.f.setSize(j * 20);
/*     */     
/* 203 */     float[] arrayOfFloat2 = this.f.items;
/* 204 */     for (byte b2 = 0; b2 < j; b2++) {
/* 205 */       int k = b2 * 5;
/* 206 */       int m = (b2 + 1) * 5;
/*     */       
/* 208 */       int n = b2 * 20;
/*     */       
/* 210 */       float f6 = arrayOfFloat1[k];
/* 211 */       float f7 = arrayOfFloat1[k + 1];
/* 212 */       float f8 = arrayOfFloat1[m];
/* 213 */       float f9 = arrayOfFloat1[m + 1];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 222 */       float f10 = arrayOfFloat1[k + 2];
/* 223 */       float f11 = arrayOfFloat1[k + 3];
/* 224 */       float f4 = arrayOfFloat1[k + 4];
/* 225 */       float f12 = Color.toFloatBits(this.d.r, this.d.g, this.d.b, this.d.a * f4);
/* 226 */       f10 = f10 * this.c * f4;
/* 227 */       f4 = f11 * this.c * f4;
/*     */       
/* 229 */       f11 = arrayOfFloat1[m + 2];
/* 230 */       float f13 = arrayOfFloat1[m + 3];
/* 231 */       float f5 = arrayOfFloat1[m + 4];
/* 232 */       float f14 = Color.toFloatBits(this.d.r, this.d.g, this.d.b, this.d.a * f5);
/* 233 */       f11 = f11 * this.c * f5;
/* 234 */       f5 = f13 * this.c * f5;
/*     */ 
/*     */       
/* 237 */       arrayOfFloat2[n] = f8 - f11;
/* 238 */       arrayOfFloat2[n + 1] = f9 - f5;
/* 239 */       arrayOfFloat2[n + 2] = f14;
/* 240 */       arrayOfFloat2[n + 3] = paramFloat;
/* 241 */       arrayOfFloat2[n + 4] = f1;
/*     */ 
/*     */       
/* 244 */       arrayOfFloat2[n + 5] = f6 - f10;
/* 245 */       arrayOfFloat2[n + 6] = f7 - f4;
/* 246 */       arrayOfFloat2[n + 7] = f12;
/* 247 */       arrayOfFloat2[n + 8] = f3;
/* 248 */       arrayOfFloat2[n + 9] = f1;
/*     */ 
/*     */       
/* 251 */       arrayOfFloat2[n + 10] = f6 + f10;
/* 252 */       arrayOfFloat2[n + 11] = f7 + f4;
/* 253 */       arrayOfFloat2[n + 12] = f12;
/* 254 */       arrayOfFloat2[n + 13] = f3;
/* 255 */       arrayOfFloat2[n + 14] = f2;
/*     */ 
/*     */       
/* 258 */       arrayOfFloat2[n + 15] = f8 + f11;
/* 259 */       arrayOfFloat2[n + 16] = f9 + f5;
/* 260 */       arrayOfFloat2[n + 17] = f14;
/* 261 */       arrayOfFloat2[n + 18] = paramFloat;
/* 262 */       arrayOfFloat2[n + 19] = f2;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void draw(Batch paramBatch) {
/* 268 */     if (this.f.size != 0) {
/* 269 */       paramBatch.draw((AssetManager.TextureRegions.i()).bulletTraceThin.getTexture(), this.f.items, 0, this.f.size);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void free() {
/* 305 */     Game.i.shapeManager.F.TRAIL_MULTI_LINE.free(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void reset() {}
/*     */ 
/*     */   
/*     */   public static class TrailMultiLineFactory
/*     */     extends Shape.Factory<TrailMultiLine>
/*     */   {
/*     */     public void setup() {}
/*     */     
/*     */     protected static TrailMultiLine b() {
/* 318 */       return new TrailMultiLine();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\shapes\TrailMultiLine.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */