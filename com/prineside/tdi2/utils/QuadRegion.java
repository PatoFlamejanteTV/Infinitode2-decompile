/*      */ package com.prineside.tdi2.utils;
/*      */ 
/*      */ import com.a.a.c.j.m;
/*      */ import com.a.a.c.m;
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.g2d.Batch;
/*      */ import com.badlogic.gdx.graphics.g2d.SpriteCache;
/*      */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*      */ import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
/*      */ import com.badlogic.gdx.math.MathUtils;
/*      */ import com.badlogic.gdx.utils.Json;
/*      */ import com.badlogic.gdx.utils.JsonValue;
/*      */ import com.badlogic.gdx.utils.Null;
/*      */ import com.badlogic.gdx.utils.NumberUtils;
/*      */ import com.badlogic.gdx.utils.StringBuilder;
/*      */ import com.google.common.base.Preconditions;
/*      */ import com.prineside.kryo.FixedInput;
/*      */ import com.prineside.kryo.FixedOutput;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.ResourcePack;
/*      */ import com.prineside.tdi2.scene2d.utils.TransformDrawable;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ import java.util.Objects;
/*      */ 
/*      */ public final class QuadRegion
/*      */   extends AbstractDrawable
/*      */   implements TransformDrawable
/*      */ {
/*   30 */   private static final TLog b = TLog.forClass(QuadRegion.class);
/*      */   
/*   32 */   private static final int c = Color.WHITE.toIntBits();
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final byte NINE_PATH_NONE = 0;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final byte COLOR_MODE_INHERIT = 0;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final byte COLOR_MODE_STATIC_RGB = 1;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final byte COLOR_MODE_STATIC_RGBA = 2;
/*      */ 
/*      */ 
/*      */   
/*   53 */   private static final float[] d = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   59 */   private static final float[] e = new float[32];
/*      */   
/*      */   public String regionName;
/*      */   public String quadName;
/*   63 */   private final float[] f = new float[8];
/*   64 */   private CornerColors g = AllWhiteCornerColors.INSTANCE; private float h; private float i;
/*      */   private float j;
/*      */   private float k;
/*      */   private TextureRegion l;
/*   68 */   private byte m = 0;
/*      */ 
/*      */   
/*      */   private byte n;
/*      */ 
/*      */   
/*      */   private float o;
/*      */   
/*      */   private float p;
/*      */ 
/*      */   
/*      */   public QuadRegion(QuadRegion paramQuadRegion) {
/*   80 */     set(paramQuadRegion);
/*      */   }
/*      */   
/*      */   public QuadRegion(float[] paramArrayOffloat, float paramFloat1, float paramFloat2) {
/*   84 */     this.h = paramFloat1;
/*   85 */     this.i = paramFloat2;
/*   86 */     setRegionName((String)null);
/*   87 */     setCornerPositions(paramArrayOffloat);
/*      */   }
/*      */   
/*      */   public QuadRegion(ResourcePack.AtlasTextureRegion paramAtlasTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*   91 */     if (Game.i.assetManager != null) {
/*   92 */       Preconditions.checkNotNull(paramAtlasTextureRegion, "region can not be null");
/*      */     }
/*   94 */     this.l = (TextureRegion)paramAtlasTextureRegion;
/*   95 */     this.regionName = paramAtlasTextureRegion.name;
/*   96 */     this.h = paramFloat1;
/*   97 */     this.i = paramFloat2;
/*   98 */     setCornerPositions(0.0F, 0.0F, 0.0F, paramFloat4, paramFloat3, paramFloat4, paramFloat3, 0.0F);
/*      */   }
/*      */   
/*      */   public QuadRegion(ResourcePack.AtlasTextureRegion paramAtlasTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Color paramColor) {
/*  102 */     this(paramAtlasTextureRegion, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*  103 */     setSameCornerColors(paramColor);
/*      */   }
/*      */   
/*      */   public final boolean sameAs(QuadRegion paramQuadRegion) {
/*  107 */     if (paramQuadRegion == this) return true;
/*      */     
/*  109 */     if (!Objects.equals(this.regionName, paramQuadRegion.regionName)) return false; 
/*  110 */     if (!Objects.equals(this.quadName, paramQuadRegion.quadName)) return false;
/*      */     
/*  112 */     for (byte b = 0; b < this.f.length; b++) {
/*  113 */       if (this.f[b] != paramQuadRegion.f[b]) return false; 
/*      */     } 
/*  115 */     if (!this.g.sameAs(paramQuadRegion.g)) {
/*  116 */       return false;
/*      */     }
/*      */     
/*  119 */     if (this.h != paramQuadRegion.h || this.i != paramQuadRegion.i || this.j != paramQuadRegion.j || this.k != paramQuadRegion.k) return false;
/*      */     
/*  121 */     if (getColorMode() != paramQuadRegion.getColorMode()) return false; 
/*  122 */     if (this.m != paramQuadRegion.m) return false; 
/*  123 */     if (isVisible() != paramQuadRegion.isVisible()) return false;
/*      */     
/*  125 */     return true;
/*      */   }
/*      */   @Null
/*      */   public final String getRegionName() {
/*  129 */     return this.regionName;
/*      */   }
/*      */   @Null
/*      */   public final String getQuadName() {
/*  133 */     return this.quadName;
/*      */   }
/*      */   
/*      */   public final boolean isDebugging() {
/*  137 */     return ((this.n & 0x8) != 0);
/*      */   }
/*      */   
/*      */   public final boolean isSingleColor() {
/*  141 */     return this.g.isSingleColor();
/*      */   }
/*      */   
/*      */   public final boolean isVisible() {
/*  145 */     return ((this.n & 0x4) == 0);
/*      */   }
/*      */   
/*      */   public final void setVisible(boolean paramBoolean) {
/*  149 */     if (paramBoolean) {
/*  150 */       this.n = (byte)(this.n & 0xFFFFFFFB); return;
/*      */     } 
/*  152 */     this.n = (byte)(this.n | 0x4);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void setDebugging(boolean paramBoolean) {
/*  157 */     if (!paramBoolean) {
/*  158 */       this.n = (byte)(this.n & 0xFFFFFFF7); return;
/*      */     } 
/*  160 */     this.n = (byte)(this.n | 0x8);
/*      */   }
/*      */ 
/*      */   
/*      */   public final byte getNinePathRegion() {
/*  165 */     return this.m;
/*      */   }
/*      */   
/*      */   public final void setNinePathRegion(byte paramByte) {
/*  169 */     this.m = paramByte;
/*      */   }
/*      */   
/*      */   public final byte getColorMode() {
/*  173 */     return (byte)(this.n & 0x3);
/*      */   }
/*      */   
/*      */   public final void setColorMode(byte paramByte) {
/*  177 */     this.n = (byte)(this.n & 0xFC);
/*  178 */     this.n = (byte)(this.n | paramByte & 0x3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void setRegionName(@Null String paramString) {
/*  186 */     if (paramString == null || paramString.length() == 0) {
/*  187 */       paramString = "blank";
/*      */     }
/*      */     
/*  190 */     this.regionName = paramString;
/*  191 */     if (Game.i.assetManager != null) {
/*  192 */       this.l = (TextureRegion)Game.i.assetManager.getTextureRegionSetThrowing(paramString, false);
/*  193 */       if (this.l == null) {
/*  194 */         throw new IllegalArgumentException("failed to set region name - specified region provider does not have 'blank' region");
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public final void setRegionNameFromProvider(String paramString, AssetProvider<TextureRegion> paramAssetProvider) {
/*  201 */     this.regionName = paramString;
/*  202 */     if (paramString == null || paramString.length() == 0) {
/*  203 */       this.l = paramAssetProvider.get("blank");
/*      */     } else {
/*  205 */       this.l = paramAssetProvider.get(paramString);
/*  206 */       if (this.l == null) {
/*  207 */         b.i("region with name '" + paramString + "' not found in the specified regionProvider, falling back to blank", new Object[0]);
/*  208 */         this.l = paramAssetProvider.get("blank");
/*      */       } 
/*      */     } 
/*  211 */     if (this.l == null) {
/*  212 */       throw new IllegalArgumentException("failed to set region name - specified region provider does not have 'blank' region");
/*      */     }
/*      */   }
/*      */   
/*      */   public final void setPosition(float paramFloat1, float paramFloat2) {
/*  217 */     this.h = paramFloat1;
/*  218 */     this.i = paramFloat2;
/*      */   }
/*      */   
/*      */   public final void set(QuadRegion paramQuadRegion) {
/*  222 */     this.h = paramQuadRegion.h;
/*  223 */     this.i = paramQuadRegion.i;
/*  224 */     this.j = paramQuadRegion.j;
/*  225 */     this.k = paramQuadRegion.k;
/*  226 */     System.arraycopy(paramQuadRegion.f, 0, this.f, 0, 8);
/*  227 */     this.g = paramQuadRegion.g.cpyCornerColors();
/*      */     
/*  229 */     if (Game.i.assetManager != null) {
/*  230 */       Preconditions.checkNotNull(paramQuadRegion.l);
/*      */     }
/*  232 */     this.l = paramQuadRegion.l;
/*  233 */     this.regionName = paramQuadRegion.regionName;
/*  234 */     this.quadName = paramQuadRegion.quadName;
/*  235 */     this.m = paramQuadRegion.m;
/*  236 */     this.n = paramQuadRegion.n;
/*  237 */     this.o = paramQuadRegion.o;
/*  238 */     this.p = paramQuadRegion.p;
/*      */     
/*  240 */     if (paramQuadRegion.a != null) {
/*  241 */       a();
/*  242 */       System.arraycopy(paramQuadRegion.a, 0, this.a, 0, this.a.length);
/*      */     } 
/*      */   }
/*      */   
/*      */   public final float getX() {
/*  247 */     return this.h;
/*      */   }
/*      */   
/*      */   public final float getY() {
/*  251 */     return this.i;
/*      */   }
/*      */   
/*      */   public final float getWidth() {
/*  255 */     return this.j;
/*      */   }
/*      */   
/*      */   public final float getHeight() {
/*  259 */     return this.k;
/*      */   }
/*      */   
/*      */   public final float[] getCornerPositions() {
/*  263 */     return this.f;
/*      */   }
/*      */   
/*      */   public final CornerColors getCornerColors() {
/*  267 */     return this.g;
/*      */   }
/*      */   
/*      */   public final void setCornerColorsSeparate(Color paramColor1, Color paramColor2, Color paramColor3, Color paramColor4) {
/*  271 */     int i = paramColor1.toIntBits();
/*  272 */     int j = paramColor2.toIntBits();
/*  273 */     int k = paramColor3.toIntBits();
/*  274 */     int m = paramColor4.toIntBits();
/*  275 */     if (i == c && j == c && k == c && m == c) {
/*      */       
/*  277 */       this.g = AllWhiteCornerColors.INSTANCE; return;
/*  278 */     }  if (i == j && i == k && i == m) {
/*      */       
/*  280 */       if (this.g instanceof SingleCornerColor) {
/*  281 */         ((SingleCornerColor)this.g).set(paramColor1); return;
/*      */       } 
/*  283 */       this.g = new SingleCornerColor(paramColor1);
/*      */       
/*      */       return;
/*      */     } 
/*  287 */     if (this.g instanceof FourCornerColors) {
/*      */       FourCornerColors fourCornerColors;
/*  289 */       FourCornerColors.a(fourCornerColors = (FourCornerColors)this.g).set(paramColor1);
/*  290 */       FourCornerColors.b(fourCornerColors).set(paramColor2);
/*  291 */       FourCornerColors.c(fourCornerColors).set(paramColor3);
/*  292 */       FourCornerColors.d(fourCornerColors).set(paramColor4); return;
/*      */     } 
/*  294 */     this.g = new FourCornerColors(paramColor1, paramColor2, paramColor3, paramColor4);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void setSameCornerColors(Color paramColor) {
/*  300 */     if (paramColor.toIntBits() == c) {
/*  301 */       this.g = AllWhiteCornerColors.INSTANCE; return;
/*      */     } 
/*  303 */     if (this.g instanceof SingleCornerColor) {
/*  304 */       ((SingleCornerColor)this.g).set(paramColor); return;
/*      */     } 
/*  306 */     this.g = new SingleCornerColor(paramColor);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void multiplyCornerColors(Color paramColor) {
/*  312 */     if (paramColor.toIntBits() == c)
/*      */       return; 
/*  314 */     if (this.g == AllWhiteCornerColors.INSTANCE) {
/*  315 */       this.g = new SingleCornerColor(paramColor); return;
/*  316 */     }  if (this.g instanceof SingleCornerColor) {
/*  317 */       ((SingleCornerColor)this.g).mul(paramColor);
/*  318 */       this.g = this.g.simplifyIfNeeded(); return;
/*      */     } 
/*      */     FourCornerColors fourCornerColors;
/*  321 */     FourCornerColors.a(fourCornerColors = (FourCornerColors)this.g).mul(paramColor);
/*  322 */     FourCornerColors.b(fourCornerColors).mul(paramColor);
/*  323 */     FourCornerColors.c(fourCornerColors).mul(paramColor);
/*  324 */     FourCornerColors.d(fourCornerColors).mul(paramColor);
/*  325 */     this.g = fourCornerColors.simplifyIfNeeded();
/*      */   }
/*      */ 
/*      */   
/*      */   public final void setCornerColorsObject(CornerColors paramCornerColors) {
/*  330 */     this.g = paramCornerColors;
/*      */   }
/*      */   
/*      */   @IgnoreMethodOverloadLuaDefWarning
/*      */   public final void setCornerPositions(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8) {
/*  335 */     this.f[0] = paramFloat1;
/*  336 */     this.f[1] = paramFloat2;
/*  337 */     this.f[2] = paramFloat3;
/*  338 */     this.f[3] = paramFloat4;
/*  339 */     this.f[4] = paramFloat5;
/*  340 */     this.f[5] = paramFloat6;
/*  341 */     this.f[6] = paramFloat7;
/*  342 */     this.f[7] = paramFloat8;
/*  343 */     updateSize();
/*      */   }
/*      */   
/*      */   @IgnoreMethodOverloadLuaDefWarning
/*      */   public final void setCornerPositions(float[] paramArrayOffloat) {
/*  348 */     if (paramArrayOffloat != this.f) {
/*  349 */       if (paramArrayOffloat.length != 8) throw new IllegalArgumentException("Must contain 8 floats");
/*      */       
/*  351 */       setCornerPositions(paramArrayOffloat[0], paramArrayOffloat[1], paramArrayOffloat[2], paramArrayOffloat[3], paramArrayOffloat[4], paramArrayOffloat[5], paramArrayOffloat[6], paramArrayOffloat[7]); return;
/*      */     } 
/*  353 */     updateSize();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void shiftPositionToMatchCorners() {
/*  361 */     float f1 = Math.min(this.f[0], Math.min(this.f[2], Math.min(this.f[4], this.f[6])));
/*  362 */     float f2 = Math.min(this.f[1], Math.min(this.f[3], Math.min(this.f[5], this.f[7])));
/*      */     
/*  364 */     this.h += f1;
/*  365 */     this.i += f2;
/*  366 */     for (byte b = 0; b < 4; b++) {
/*  367 */       this.f[b << 1] = this.f[b << 1] - f1;
/*  368 */       this.f[(b << 1) + 1] = this.f[(b << 1) + 1] - f2;
/*      */     } 
/*      */     
/*  371 */     updateSize();
/*      */   }
/*      */   
/*      */   public final void translate(float paramFloat1, float paramFloat2) {
/*  375 */     for (byte b = 0; b < 4; b++) {
/*  376 */       this.f[b << 1] = this.f[b << 1] + paramFloat1;
/*  377 */       this.f[(b << 1) + 1] = this.f[(b << 1) + 1] + paramFloat2;
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void setTextureRegion(ResourcePack.AtlasTextureRegion paramAtlasTextureRegion) {
/*  382 */     Preconditions.checkNotNull(paramAtlasTextureRegion);
/*  383 */     this.l = (TextureRegion)paramAtlasTextureRegion;
/*  384 */     this.regionName = paramAtlasTextureRegion.name;
/*      */   }
/*      */   
/*      */   public final void updateSize() {
/*  388 */     this.j = Math.max(this.f[0], Math.max(this.f[2], Math.max(this.f[4], this.f[6])));
/*  389 */     this.k = Math.max(this.f[1], Math.max(this.f[3], Math.max(this.f[5], this.f[7])));
/*  390 */     setMinWidth(this.j);
/*  391 */     setMinHeight(this.k);
/*  392 */     this.o = 1.0F / Math.max(1.0E-4F, this.j);
/*  393 */     this.p = 1.0F / Math.max(1.0E-4F, this.k);
/*      */   }
/*      */   
/*      */   public final TextureRegion getTextureRegion() {
/*  397 */     return (TextureRegion)((this.l != null) ? this.l : Game.i.assetManager.getTextureRegion(this.regionName));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @IgnoreMethodOverloadLuaDefWarning
/*      */   public final void draw(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  406 */     if (isDebugging()) {
/*  407 */       b.i("draw (Batch, float, float, float, float) " + this.regionName, new Object[0]);
/*      */     }
/*  409 */     a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramBatch.getColor());
/*  410 */     if (isDebugging()) {
/*  411 */       b.i("draw vertices:", new Object[0]);
/*  412 */       for (byte b = 0; b < 4; b++) {
/*  413 */         b.i("- x: " + d[b * 5], new Object[0]);
/*  414 */         b.i("- y: " + d[b * 5 + 1], new Object[0]);
/*  415 */         b.i("- color: " + Integer.toHexString(NumberUtils.floatToIntBits(d[b * 5 + 2])), new Object[0]);
/*      */       } 
/*      */     } 
/*  418 */     paramBatch.draw(getTextureRegion().getTexture(), d, 0, 20);
/*      */   }
/*      */   
/*      */   public final void drawToCache(SpriteCache paramSpriteCache, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  422 */     a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramSpriteCache.getColor());
/*      */ 
/*      */ 
/*      */     
/*  426 */     System.arraycopy(d, 0, e, 0, 15);
/*      */ 
/*      */     
/*  429 */     System.arraycopy(d, 10, e, 15, 5);
/*      */ 
/*      */     
/*  432 */     System.arraycopy(d, 15, e, 20, 5);
/*      */ 
/*      */     
/*  435 */     System.arraycopy(d, 0, e, 25, 5);
/*      */     
/*  437 */     paramSpriteCache.add(getTextureRegion().getTexture(), e, 0, 30);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @IgnoreMethodOverloadLuaDefWarning
/*      */   public final void draw(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9) {
/*  444 */     a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramBatch.getColor());
/*  445 */     paramBatch.draw(getTextureRegion().getTexture(), d, 0, 20);
/*      */   }
/*      */ 
/*      */   
/*      */   @IgnoreMethodOverloadLuaDefWarning
/*      */   final void a(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10) {
/*  451 */     a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, paramBatch.getColor());
/*  452 */     paramBatch.draw(getTextureRegion().getTexture(), d, 0, 20);
/*      */   }
/*      */   
/*      */   public final void rotateAround(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  456 */     paramFloat1 -= this.h;
/*  457 */     paramFloat2 -= this.i;
/*      */     
/*  459 */     a(0.0F, 0.0F, paramFloat1, paramFloat2, this.j, this.k, 1.0F, 1.0F, paramFloat3, Color.WHITE);
/*  460 */     setCornerPositions(d[0], d[1], d[5], d[6], d[10], d[11], d[15], d[16]);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  470 */     shiftPositionToMatchCorners();
/*      */   }
/*      */   
/*      */   private void a(Color paramColor) {
/*  474 */     if (isDebugging()) {
/*  475 */       b.i("computeVertexColor", new Object[0]);
/*      */     }
/*  477 */     float f2 = paramColor.r;
/*  478 */     float f3 = paramColor.g;
/*  479 */     float f4 = paramColor.b;
/*  480 */     float f1 = paramColor.a;
/*      */     byte b;
/*  482 */     if ((b = getColorMode()) == 1) {
/*  483 */       f2 = f3 = f4 = 1.0F;
/*  484 */     } else if (b == 2) {
/*  485 */       f2 = f3 = f4 = f1 = 1.0F;
/*      */     } 
/*  487 */     if (isSingleColor()) {
/*  488 */       Color color = this.g.get(0);
/*  489 */       if (isDebugging()) {
/*  490 */         b.i("computeVertexColor - single color " + Integer.toHexString((new Color(color.r * f2, color.g * f3, color.b * f4, color.a * f1)).toIntBits()), new Object[0]);
/*      */       }
/*  492 */       float f = Color.toFloatBits(color.r * f2, color.g * f3, color.b * f4, color.a * f1);
/*  493 */       for (byte b1 = 0; b1 < 4; b1++)
/*  494 */         d[b1 * 5 + 2] = f; 
/*      */       return;
/*      */     } 
/*  497 */     for (b = 0; b < 4; b++) {
/*      */       Color color;
/*  499 */       float f = Color.toFloatBits((color = this.g.get(b)).r * f2, color.g * f3, color.b * f4, color.a * f1);
/*  500 */       d[b * 5 + 2] = f;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, Color paramColor) {
/*  506 */     float f = MathUtils.cosDeg(paramFloat9);
/*  507 */     paramFloat9 = MathUtils.sinDeg(paramFloat9);
/*  508 */     a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, f, paramFloat9, paramColor);
/*      */   }
/*      */   
/*      */   private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Color paramColor) {
/*  512 */     if (isDebugging()) {
/*  513 */       b.i("computeVerticesSimple", new Object[0]);
/*      */     }
/*  515 */     float f2 = this.o;
/*  516 */     float f3 = this.p;
/*      */     
/*  518 */     float f4 = paramFloat3 * this.f[0] * f2;
/*  519 */     float f5 = paramFloat4 * this.f[1] * f3;
/*  520 */     float f6 = paramFloat3 * this.f[2] * f2;
/*  521 */     float f7 = paramFloat4 - paramFloat4 * (1.0F - this.f[3] * f3);
/*  522 */     float f8 = paramFloat3 - paramFloat3 * (1.0F - this.f[4] * f2);
/*  523 */     float f9 = paramFloat4 - paramFloat4 * (1.0F - this.f[5] * f3);
/*  524 */     paramFloat3 -= paramFloat3 * (1.0F - this.f[6] * f2);
/*  525 */     paramFloat4 = paramFloat4 * this.f[7] * f3;
/*      */     
/*      */     TextureRegion textureRegion;
/*  528 */     f3 = (textureRegion = getTextureRegion()).getU();
/*  529 */     float f10 = textureRegion.getV();
/*  530 */     float f11 = textureRegion.getU2();
/*  531 */     float f1 = textureRegion.getV2();
/*  532 */     d[0] = f4 + paramFloat1;
/*  533 */     d[1] = f5 + paramFloat2;
/*  534 */     d[3] = f3;
/*  535 */     d[4] = f1;
/*      */     
/*  537 */     d[5] = f6 + paramFloat1;
/*  538 */     d[6] = f7 + paramFloat2;
/*  539 */     d[8] = f3;
/*  540 */     d[9] = f10;
/*      */     
/*  542 */     d[10] = f8 + paramFloat1;
/*  543 */     d[11] = f9 + paramFloat2;
/*  544 */     d[13] = f11;
/*  545 */     d[14] = f10;
/*      */     
/*  547 */     d[15] = paramFloat3 + paramFloat1;
/*  548 */     d[16] = paramFloat4 + paramFloat2;
/*  549 */     d[18] = f11;
/*  550 */     d[19] = f1;
/*      */     
/*  552 */     a(paramColor);
/*      */   }
/*      */ 
/*      */   
/*      */   private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, Color paramColor) {
/*  557 */     float f2 = -paramFloat3;
/*  558 */     float f3 = -paramFloat4;
/*  559 */     float f4 = paramFloat5 - paramFloat3;
/*  560 */     float f5 = paramFloat6 - paramFloat4;
/*      */ 
/*      */     
/*  563 */     if (paramFloat7 != 1.0F || paramFloat8 != 1.0F) {
/*  564 */       f2 *= paramFloat7;
/*  565 */       f3 *= paramFloat8;
/*  566 */       f4 *= paramFloat7;
/*  567 */       f5 *= paramFloat8;
/*      */     } 
/*      */ 
/*      */     
/*  571 */     float f6 = this.o;
/*  572 */     float f7 = this.p;
/*      */     
/*  574 */     float f8 = f2 + paramFloat5 * this.f[0] * f6 * paramFloat7;
/*  575 */     float f9 = f3 + paramFloat6 * this.f[1] * f7 * paramFloat8;
/*  576 */     f2 += paramFloat5 * this.f[2] * f6 * paramFloat7;
/*  577 */     float f10 = f5 - paramFloat6 * (1.0F - this.f[3] * f7) * paramFloat8;
/*  578 */     float f11 = f4 - paramFloat5 * (1.0F - this.f[4] * f6) * paramFloat7;
/*  579 */     f5 -= paramFloat6 * (1.0F - this.f[5] * f7) * paramFloat8;
/*  580 */     paramFloat5 = f4 - paramFloat5 * (1.0F - this.f[6] * f6) * paramFloat7;
/*  581 */     paramFloat6 = f3 + paramFloat6 * this.f[7] * f7 * paramFloat8;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  586 */     if (paramFloat9 != 1.0F || paramFloat10 != 0.0F) {
/*  587 */       paramFloat7 = paramFloat9 * f8 - paramFloat10 * f9;
/*  588 */       paramFloat8 = paramFloat10 * f8 + paramFloat9 * f9;
/*      */       
/*  590 */       f3 = paramFloat9 * f2 - paramFloat10 * f10;
/*  591 */       f2 = paramFloat10 * f2 + paramFloat9 * f10;
/*      */       
/*  593 */       f4 = paramFloat9 * f11 - paramFloat10 * f5;
/*  594 */       f5 = paramFloat10 * f11 + paramFloat9 * f5;
/*      */       
/*  596 */       f6 = paramFloat9 * paramFloat5 - paramFloat10 * paramFloat6;
/*  597 */       paramFloat5 = paramFloat10 * paramFloat5 + paramFloat9 * paramFloat6;
/*      */     } else {
/*  599 */       paramFloat7 = f8;
/*  600 */       paramFloat8 = f9;
/*      */       
/*  602 */       f3 = f2;
/*  603 */       f2 = f10;
/*      */       
/*  605 */       f4 = f11;
/*  606 */       f5 = f5;
/*      */       
/*  608 */       f6 = paramFloat5;
/*  609 */       paramFloat5 = paramFloat6;
/*      */     } 
/*      */     
/*  612 */     paramFloat1 += paramFloat3;
/*  613 */     paramFloat2 += paramFloat4;
/*  614 */     paramFloat7 += paramFloat1;
/*  615 */     paramFloat8 += paramFloat2;
/*  616 */     f3 += paramFloat1;
/*  617 */     f2 += paramFloat2;
/*  618 */     f4 += paramFloat1;
/*  619 */     f5 += paramFloat2;
/*  620 */     f6 += paramFloat1;
/*  621 */     paramFloat5 += paramFloat2;
/*      */     
/*      */     TextureRegion textureRegion;
/*  624 */     paramFloat2 = (textureRegion = getTextureRegion()).getU();
/*  625 */     paramFloat3 = textureRegion.getV();
/*  626 */     paramFloat4 = textureRegion.getU2();
/*  627 */     float f1 = textureRegion.getV2();
/*  628 */     d[0] = paramFloat7;
/*  629 */     d[1] = paramFloat8;
/*  630 */     d[3] = paramFloat2;
/*  631 */     d[4] = f1;
/*      */     
/*  633 */     d[5] = f3;
/*  634 */     d[6] = f2;
/*  635 */     d[8] = paramFloat2;
/*  636 */     d[9] = paramFloat3;
/*      */     
/*  638 */     d[10] = f4;
/*  639 */     d[11] = f5;
/*  640 */     d[13] = paramFloat4;
/*  641 */     d[14] = paramFloat3;
/*      */     
/*  643 */     d[15] = f6;
/*  644 */     d[16] = paramFloat5;
/*  645 */     d[18] = paramFloat4;
/*  646 */     d[19] = f1;
/*      */     
/*  648 */     a(paramColor);
/*      */   }
/*      */   
/*      */   public final void drawDebug(ShapeRenderer paramShapeRenderer, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10) {
/*  652 */     a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, paramShapeRenderer.getColor());
/*      */     
/*  654 */     paramShapeRenderer.begin(ShapeRenderer.ShapeType.Line);
/*  655 */     Gdx.gl.glEnable(3042);
/*  656 */     paramShapeRenderer.setColor(0.0F, 1.0F, 0.0F, 0.5F);
/*  657 */     paramShapeRenderer.line(d[0], d[1], d[5], d[6]);
/*  658 */     paramShapeRenderer.line(d[5], d[6], d[10], d[11]);
/*  659 */     paramShapeRenderer.line(d[10], d[11], d[15], d[16]);
/*  660 */     paramShapeRenderer.line(d[15], d[16], d[0], d[1]);
/*      */     
/*  662 */     paramShapeRenderer.end();
/*      */   }
/*      */ 
/*      */   
/*      */   public static QuadRegion fromJson(m paramm, AssetProvider<TextureRegion> paramAssetProvider) {
/*      */     m m1;
/*      */     QuadRegion quadRegion;
/*  669 */     (quadRegion = new QuadRegion()).setRegionNameFromProvider((String)null, paramAssetProvider);
/*      */     
/*  671 */     if (paramm.b()) {
/*      */       float f;
/*  673 */       byte b = 0;
/*      */ 
/*      */ 
/*      */       
/*  677 */       if ((m3 = paramm.a(0)).e() || m3.f()) {
/*      */         
/*  679 */         if (m3.e()) {
/*  680 */           quadRegion.setRegionNameFromProvider(paramm.a(0).i(), paramAssetProvider);
/*      */         }
/*  682 */         b++;
/*      */       } 
/*      */       
/*      */       m m2;
/*      */       
/*  687 */       JsonAssertUtils.checkJsonType(m2 = paramm.a(b), m.a, "[QR][position]");
/*  688 */       if (m2.a() == 2) {
/*  689 */         quadRegion.h = (float)m2.a(0).k();
/*  690 */         quadRegion.i = (float)m2.a(1).k();
/*      */       } else {
/*  692 */         quadRegion.h = 0.0F;
/*  693 */         quadRegion.i = 0.0F;
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*  698 */       JsonAssertUtils.checkJsonType(m2 = paramm.a(b + 1), m.a, "[QR][vertices]");
/*  699 */       if (m2.a() == 2) {
/*      */         
/*  701 */         float f1 = (float)m2.a(0).k();
/*  702 */         f = (float)m2.a(1).k();
/*  703 */         quadRegion.j = f1;
/*  704 */         quadRegion.k = f;
/*  705 */         quadRegion.f[0] = 0.0F;
/*  706 */         quadRegion.f[1] = 0.0F;
/*  707 */         quadRegion.f[2] = 0.0F;
/*  708 */         quadRegion.f[3] = f;
/*  709 */         quadRegion.f[4] = f1;
/*  710 */         quadRegion.f[5] = f;
/*  711 */         quadRegion.f[6] = f1;
/*  712 */         quadRegion.f[7] = 0.0F;
/*      */       } else {
/*      */         
/*  715 */         byte b1 = 0;
/*  716 */         for (m m3 : f) {
/*  717 */           quadRegion.f[b1++] = (float)m3.k();
/*  718 */           if (b1 != quadRegion.f.length);
/*      */         } 
/*      */       } 
/*  721 */       quadRegion.updateSize();
/*      */       
/*  723 */       if (paramm.a() >= b + 3)
/*      */       {
/*      */         
/*  726 */         if ((m1 = paramm.a(b + 2)).a() == 1) {
/*      */           Color color;
/*      */           
/*  729 */           if ((color = Color.valueOf(m1.a(0).i())).toIntBits() == c) {
/*  730 */             quadRegion.g = AllWhiteCornerColors.INSTANCE;
/*      */           } else {
/*  732 */             quadRegion.g = new SingleCornerColor(color);
/*      */           } 
/*  734 */         } else if (m1.a() == 4) {
/*  735 */           quadRegion.g = FourCornerColors.of(m1);
/*      */         } 
/*      */       }
/*      */       
/*  739 */       if (paramm.a() >= b + 4)
/*      */       {
/*  741 */         quadRegion.m = (byte)paramm.a(b + 3).j();
/*      */       }
/*  743 */     } else if (paramm.c()) {
/*      */ 
/*      */       
/*  746 */       quadRegion.setRegionNameFromProvider(paramm.b("t").c(null), (AssetProvider<TextureRegion>)m1);
/*      */ 
/*      */       
/*  749 */       quadRegion.quadName = paramm.b("i").c(null);
/*      */ 
/*      */       
/*  752 */       quadRegion.setColorMode((byte)paramm.b("cm").b(0));
/*      */       
/*      */       m m2;
/*      */       
/*  756 */       if ((m2 = paramm.a("p")) != null) {
/*  757 */         quadRegion.setPosition((float)m2.a(0).k(), (float)m2.a(1).k());
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  762 */       if ((m2 = paramm.a("v")).a() == 2) {
/*      */         
/*  764 */         float f2 = (float)m2.a(0).k();
/*  765 */         float f1 = (float)m2.a(1).k();
/*  766 */         quadRegion.j = f2;
/*  767 */         quadRegion.k = f1;
/*  768 */         quadRegion.f[0] = 0.0F;
/*  769 */         quadRegion.f[1] = 0.0F;
/*  770 */         quadRegion.f[2] = 0.0F;
/*  771 */         quadRegion.f[3] = f1;
/*  772 */         quadRegion.f[4] = f2;
/*  773 */         quadRegion.f[5] = f1;
/*  774 */         quadRegion.f[6] = f2;
/*  775 */         quadRegion.f[7] = 0.0F;
/*      */       } else {
/*      */         
/*  778 */         byte b = 0;
/*  779 */         for (m m3 : m2) {
/*  780 */           quadRegion.f[b++] = (float)m3.k();
/*  781 */           if (b != quadRegion.f.length);
/*      */         } 
/*      */       } 
/*  784 */       quadRegion.updateSize();
/*      */ 
/*      */ 
/*      */       
/*  788 */       if ((m2 = paramm.a("c")) != null) {
/*  789 */         if (m2.a() == 1) {
/*      */           Color color;
/*      */           
/*  792 */           if ((color = Color.valueOf(m2.a(0).i())).toIntBits() == c) {
/*  793 */             quadRegion.g = AllWhiteCornerColors.INSTANCE;
/*      */           } else {
/*  795 */             quadRegion.g = new SingleCornerColor(color);
/*      */           } 
/*  797 */         } else if (m2.a() == 4) {
/*  798 */           quadRegion.g = FourCornerColors.of(m2);
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*  803 */       quadRegion.m = (byte)paramm.b("n").b(0);
/*      */     } 
/*      */     
/*  806 */     return quadRegion;
/*      */   }
/*      */   
/*      */   public static QuadRegion fromJson(JsonValue paramJsonValue) {
/*      */     QuadRegion quadRegion;
/*  811 */     (quadRegion = new QuadRegion()).setRegionName((String)null);
/*      */     
/*  813 */     if (paramJsonValue.isArray()) {
/*      */       
/*  815 */       byte b = 0;
/*      */       
/*      */       JsonValue jsonValue1;
/*      */       
/*  819 */       if ((jsonValue1 = paramJsonValue.get(0)).isString() || jsonValue1.isNull()) {
/*      */         
/*  821 */         if (jsonValue1.isString()) {
/*  822 */           quadRegion.setRegionName(paramJsonValue.get(0).asString());
/*      */         }
/*  824 */         b++;
/*      */       } 
/*      */       
/*      */       JsonValue jsonValue2;
/*      */       
/*  829 */       if ((jsonValue2 = paramJsonValue.get(b)).size == 2) {
/*  830 */         quadRegion.h = (float)jsonValue2.get(0).asDouble();
/*  831 */         quadRegion.i = (float)jsonValue2.get(1).asDouble();
/*      */       } else {
/*  833 */         quadRegion.h = 0.0F;
/*  834 */         quadRegion.i = 0.0F;
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*  839 */       if ((jsonValue2 = paramJsonValue.get(b + 1)).size == 2) {
/*      */         
/*  841 */         float f1 = (float)jsonValue2.get(0).asDouble();
/*  842 */         float f2 = (float)jsonValue2.get(1).asDouble();
/*  843 */         quadRegion.j = f1;
/*  844 */         quadRegion.k = f2;
/*  845 */         quadRegion.f[0] = 0.0F;
/*  846 */         quadRegion.f[1] = 0.0F;
/*  847 */         quadRegion.f[2] = 0.0F;
/*  848 */         quadRegion.f[3] = f2;
/*  849 */         quadRegion.f[4] = f1;
/*  850 */         quadRegion.f[5] = f2;
/*  851 */         quadRegion.f[6] = f1;
/*  852 */         quadRegion.f[7] = 0.0F;
/*      */       } else {
/*      */         
/*  855 */         byte b1 = 0;
/*  856 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue2.iterator(); jsonIterator.hasNext(); ) { jsonValue2 = jsonIterator.next();
/*  857 */           quadRegion.f[b1++] = (float)jsonValue2.asDouble();
/*  858 */           if (b1 != quadRegion.f.length); }
/*      */       
/*      */       } 
/*  861 */       quadRegion.updateSize();
/*      */       
/*  863 */       if (paramJsonValue.size >= b + 3)
/*      */       {
/*      */         
/*  866 */         if ((jsonValue2 = paramJsonValue.get(b + 2)).size == 1) {
/*      */           Color color;
/*      */           
/*  869 */           if ((color = Color.valueOf(jsonValue2.get(0).asString())).toIntBits() == c) {
/*  870 */             quadRegion.g = AllWhiteCornerColors.INSTANCE;
/*      */           } else {
/*  872 */             quadRegion.g = new SingleCornerColor(color);
/*      */           } 
/*  874 */         } else if (jsonValue2.size == 4) {
/*  875 */           quadRegion.g = FourCornerColors.of(jsonValue2);
/*      */         } 
/*      */       }
/*      */       
/*  879 */       if (paramJsonValue.size >= b + 4)
/*      */       {
/*  881 */         quadRegion.m = (byte)paramJsonValue.get(b + 3).asInt();
/*      */       }
/*  883 */     } else if (paramJsonValue.isObject()) {
/*      */       float f;
/*      */       
/*      */       JsonValue jsonValue1;
/*  887 */       if ((jsonValue1 = paramJsonValue.get("t")) != null) quadRegion.setRegionName(jsonValue1.asString());
/*      */ 
/*      */ 
/*      */       
/*  891 */       if ((jsonValue1 = paramJsonValue.get("i")) != null) quadRegion.quadName = jsonValue1.asString();
/*      */ 
/*      */ 
/*      */       
/*  895 */       if ((jsonValue1 = paramJsonValue.get("cm")) != null) {
/*  896 */         quadRegion.setColorMode((byte)jsonValue1.asInt());
/*      */       } else {
/*  898 */         quadRegion.setColorMode((byte)0);
/*      */       } 
/*      */       
/*      */       JsonValue jsonValue3;
/*      */       
/*  903 */       if ((jsonValue3 = paramJsonValue.get("p")) != null) {
/*  904 */         quadRegion.setPosition((float)jsonValue3.get(0).asDouble(), (float)jsonValue3.get(1).asDouble());
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  909 */       if ((jsonValue3 = paramJsonValue.get("v")).size == 2) {
/*      */         
/*  911 */         float f1 = (float)jsonValue3.get(0).asDouble();
/*  912 */         f = (float)jsonValue3.get(1).asDouble();
/*  913 */         quadRegion.j = f1;
/*  914 */         quadRegion.k = f;
/*  915 */         quadRegion.f[0] = 0.0F;
/*  916 */         quadRegion.f[1] = 0.0F;
/*  917 */         quadRegion.f[2] = 0.0F;
/*  918 */         quadRegion.f[3] = f;
/*  919 */         quadRegion.f[4] = f1;
/*  920 */         quadRegion.f[5] = f;
/*  921 */         quadRegion.f[6] = f1;
/*  922 */         quadRegion.f[7] = 0.0F;
/*      */       } else {
/*      */         
/*  925 */         byte b = 0;
/*  926 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = f.iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue = jsonIterator.next();
/*  927 */           quadRegion.f[b++] = (float)jsonValue.asDouble();
/*  928 */           if (b != quadRegion.f.length); }
/*      */       
/*      */       } 
/*  931 */       quadRegion.updateSize();
/*      */       
/*      */       JsonValue jsonValue2;
/*      */       
/*  935 */       if ((jsonValue2 = paramJsonValue.get("c")) != null) {
/*  936 */         if (jsonValue2.size == 1) {
/*      */           Color color;
/*      */           
/*  939 */           if ((color = Color.valueOf(jsonValue2.get(0).asString())).toIntBits() == c) {
/*  940 */             quadRegion.g = AllWhiteCornerColors.INSTANCE;
/*      */           } else {
/*  942 */             quadRegion.g = new SingleCornerColor(color);
/*      */           } 
/*  944 */         } else if (jsonValue2.size == 4) {
/*  945 */           quadRegion.g = FourCornerColors.of(jsonValue2);
/*      */         } 
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  951 */       if ((jsonValue2 = paramJsonValue.get("n")) != null) {
/*  952 */         quadRegion.m = (byte)jsonValue2.asInt();
/*      */       } else {
/*  954 */         quadRegion.m = 0;
/*      */       } 
/*      */     } 
/*      */     
/*  958 */     return quadRegion;
/*      */   }
/*      */   
/*      */   public final boolean isFullSizeRect() {
/*  962 */     return (this.f[0] == 0.0F && this.f[1] == 0.0F && this.f[2] == 0.0F && this.f[3] == this.k && this.f[4] == this.j && this.f[5] == this.k && this.f[6] == this.j && this.f[7] == 0.0F);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void toJson5String(StringBuilder paramStringBuilder) {
/*  976 */     paramStringBuilder.append('{');
/*  977 */     if (this.quadName != null) {
/*  978 */       paramStringBuilder.append("i:\"");
/*  979 */       paramStringBuilder.append(this.quadName);
/*  980 */       paramStringBuilder.append("\",");
/*      */     } 
/*  982 */     if (this.regionName != null) {
/*  983 */       paramStringBuilder.append("t:\"");
/*  984 */       paramStringBuilder.append(this.regionName);
/*  985 */       paramStringBuilder.append("\",");
/*      */     } 
/*  987 */     if (getColorMode() != 0) {
/*  988 */       paramStringBuilder.append("cm:");
/*  989 */       paramStringBuilder.append(getColorMode());
/*  990 */       paramStringBuilder.append(",");
/*      */     } 
/*  992 */     if (this.h != 0.0F || this.i != 0.0F) {
/*  993 */       paramStringBuilder.append("p:[");
/*  994 */       Quad.sbWriteIntOrFloat(paramStringBuilder, this.h);
/*  995 */       paramStringBuilder.append(',');
/*  996 */       Quad.sbWriteIntOrFloat(paramStringBuilder, this.i);
/*  997 */       paramStringBuilder.append("],");
/*      */     } 
/*  999 */     paramStringBuilder.append("v:[");
/* 1000 */     if (isFullSizeRect()) {
/*      */       
/* 1002 */       Quad.sbWriteIntOrFloat(paramStringBuilder, this.j);
/* 1003 */       paramStringBuilder.append(',');
/* 1004 */       Quad.sbWriteIntOrFloat(paramStringBuilder, this.k);
/*      */     } else {
/*      */       
/* 1007 */       for (byte b = 0; b < 8; b++) {
/* 1008 */         b % 2;
/*      */ 
/*      */         
/* 1011 */         Quad.sbWriteIntOrFloat(paramStringBuilder, this.f[b]);
/*      */         
/* 1013 */         if (b != 7) paramStringBuilder.append(','); 
/*      */       } 
/*      */     } 
/* 1016 */     paramStringBuilder.append("],");
/*      */ 
/*      */     
/* 1019 */     int i = paramStringBuilder.length;
/* 1020 */     this.g.toJson5String(paramStringBuilder);
/* 1021 */     if (i != paramStringBuilder.length)
/*      */     {
/* 1023 */       paramStringBuilder.append(',');
/*      */     }
/*      */     
/* 1026 */     if (this.m != 0)
/*      */     {
/* 1028 */       paramStringBuilder.append("n:").append(this.m);
/*      */     }
/* 1030 */     if (paramStringBuilder.charAt(paramStringBuilder.length - 1) == ',') {
/* 1031 */       paramStringBuilder.setLength(paramStringBuilder.length - 1);
/*      */     }
/* 1033 */     paramStringBuilder.append('}');
/*      */   }
/*      */   
/*      */   public final void toBytes(FixedOutput paramFixedOutput) {
/* 1037 */     boolean bool1 = (Quad.floatIsInt(this.h) && Quad.floatIsInt(this.i)) ? true : false; byte b;
/* 1038 */     for (b = 0; b < 8; b++) {
/* 1039 */       if (!Quad.floatIsInt(this.f[b])) {
/* 1040 */         bool1 = false;
/*      */         
/*      */         break;
/*      */       } 
/*      */     } 
/* 1045 */     b = (this.regionName != null && !"blank".equals(this.regionName)) ? 1 : 0;
/* 1046 */     boolean bool2 = isFullSizeRect();
/* 1047 */     boolean bool3 = (this.h != 0.0F || this.i != 0.0F) ? true : false;
/* 1048 */     boolean bool4 = (this.g != AllWhiteCornerColors.INSTANCE) ? true : false;
/* 1049 */     boolean bool5 = this.g.isSingleColor();
/* 1050 */     boolean bool6 = (this.m != 0) ? true : false;
/*      */     
/* 1052 */     byte b1 = 0;
/* 1053 */     if (bool1) b1 = 1; 
/* 1054 */     if (b != 0) b1 = (byte)(b1 | 0x2); 
/* 1055 */     if (bool2) b1 = (byte)(b1 | 0x4); 
/* 1056 */     if (bool3) b1 = (byte)(b1 | 0x8); 
/* 1057 */     if (bool4) b1 = (byte)(b1 | 0x10); 
/* 1058 */     if (bool5) b1 = (byte)(b1 | 0x20); 
/* 1059 */     if (bool6) b1 = (byte)(b1 | 0x40);
/*      */     
/* 1061 */     paramFixedOutput.writeByte(b1);
/*      */     
/* 1063 */     if (b != 0) {
/* 1064 */       paramFixedOutput.writeAscii(Quad.stripNonAscii(this.regionName));
/*      */     }
/* 1066 */     if (bool3) {
/* 1067 */       if (bool1) {
/* 1068 */         paramFixedOutput.writeVarInt(MathUtils.round(this.h), true);
/* 1069 */         paramFixedOutput.writeVarInt(MathUtils.round(this.i), true);
/*      */       } else {
/* 1071 */         paramFixedOutput.writeVarInt(MathUtils.round(this.h * 100.0F), true);
/* 1072 */         paramFixedOutput.writeVarInt(MathUtils.round(this.i * 100.0F), true);
/*      */       } 
/*      */     }
/*      */     
/* 1076 */     if (bool2) {
/*      */       
/* 1078 */       if (bool1) {
/* 1079 */         paramFixedOutput.writeVarInt(MathUtils.round(this.j), true);
/* 1080 */         paramFixedOutput.writeVarInt(MathUtils.round(this.k), true);
/*      */       } else {
/* 1082 */         paramFixedOutput.writeVarInt(MathUtils.round(this.j * 100.0F), true);
/* 1083 */         paramFixedOutput.writeVarInt(MathUtils.round(this.k * 100.0F), true);
/*      */       } 
/*      */     } else {
/*      */       
/* 1087 */       for (b = 0; b < 8; b++) {
/* 1088 */         if (bool1) {
/* 1089 */           paramFixedOutput.writeVarInt(MathUtils.round(this.f[b]), true);
/*      */         } else {
/* 1091 */           paramFixedOutput.writeVarInt(MathUtils.round(this.f[b] * 100.0F), true);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1097 */     if (bool4) {
/*      */       
/* 1099 */       paramFixedOutput.writeInt(this.g.get(0).toIntBits(), false);
/* 1100 */       if (!bool5) {
/*      */         
/* 1102 */         paramFixedOutput.writeInt(this.g.get(1).toIntBits(), false);
/* 1103 */         paramFixedOutput.writeInt(this.g.get(2).toIntBits(), false);
/* 1104 */         paramFixedOutput.writeInt(this.g.get(3).toIntBits(), false);
/*      */       } 
/*      */     } 
/*      */     
/* 1108 */     if (bool6) {
/* 1109 */       paramFixedOutput.writeByte(this.m);
/*      */     }
/*      */     
/* 1112 */     paramFixedOutput.writeByte(getColorMode());
/*      */   }
/*      */   
/*      */   public static QuadRegion fromBytes(FixedInput paramFixedInput) {
/*      */     float f;
/*      */     byte b;
/* 1118 */     boolean bool1 = (((b = paramFixedInput.readByte()) & 0x1) != 0) ? true : false;
/* 1119 */     boolean bool2 = ((b & 0x2) != 0) ? true : false;
/* 1120 */     boolean bool3 = ((b & 0x4) != 0) ? true : false;
/* 1121 */     boolean bool4 = ((b & 0x8) != 0) ? true : false;
/* 1122 */     boolean bool5 = ((b & 0x10) != 0) ? true : false;
/* 1123 */     boolean bool6 = ((b & 0x20) != 0) ? true : false;
/* 1124 */     b = ((b & 0x40) != 0) ? 1 : 0;
/*      */     
/* 1126 */     QuadRegion quadRegion = new QuadRegion();
/* 1127 */     if (bool2) {
/* 1128 */       quadRegion.setRegionName(paramFixedInput.readString());
/*      */     } else {
/* 1130 */       quadRegion.setRegionName((String)null);
/*      */     } 
/* 1132 */     if (bool4) {
/* 1133 */       if (bool1) {
/* 1134 */         quadRegion.h = paramFixedInput.readVarInt(true);
/* 1135 */         quadRegion.i = paramFixedInput.readVarInt(true);
/*      */       } else {
/* 1137 */         quadRegion.h = paramFixedInput.readVarInt(true) / 100.0F;
/* 1138 */         quadRegion.i = paramFixedInput.readVarInt(true) / 100.0F;
/*      */       } 
/*      */     }
/*      */     
/* 1142 */     if (bool3) {
/*      */       float f1;
/*      */       
/* 1145 */       if (bool1) {
/* 1146 */         f = paramFixedInput.readVarInt(true);
/* 1147 */         f1 = paramFixedInput.readVarInt(true);
/*      */       } else {
/* 1149 */         f = paramFixedInput.readVarInt(true) / 100.0F;
/* 1150 */         f1 = paramFixedInput.readVarInt(true) / 100.0F;
/*      */       } 
/* 1152 */       quadRegion.setCornerPositions(0.0F, 0.0F, 0.0F, f1, f, f1, f, 0.0F);
/*      */     
/*      */     }
/* 1155 */     else if (f != 0.0F) {
/* 1156 */       quadRegion.setCornerPositions(paramFixedInput
/* 1157 */           .readVarInt(true), paramFixedInput
/* 1158 */           .readVarInt(true), paramFixedInput
/* 1159 */           .readVarInt(true), paramFixedInput
/* 1160 */           .readVarInt(true), paramFixedInput
/* 1161 */           .readVarInt(true), paramFixedInput
/* 1162 */           .readVarInt(true), paramFixedInput
/* 1163 */           .readVarInt(true), paramFixedInput
/* 1164 */           .readVarInt(true));
/*      */     } else {
/*      */       
/* 1167 */       quadRegion.setCornerPositions(paramFixedInput
/* 1168 */           .readVarInt(true) / 100.0F, paramFixedInput
/* 1169 */           .readVarInt(true) / 100.0F, paramFixedInput
/* 1170 */           .readVarInt(true) / 100.0F, paramFixedInput
/* 1171 */           .readVarInt(true) / 100.0F, paramFixedInput
/* 1172 */           .readVarInt(true) / 100.0F, paramFixedInput
/* 1173 */           .readVarInt(true) / 100.0F, paramFixedInput
/* 1174 */           .readVarInt(true) / 100.0F, paramFixedInput
/* 1175 */           .readVarInt(true) / 100.0F);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1181 */     if (bool5) {
/*      */       
/* 1183 */       Color color = PMath.abgr8888ToColor(paramFixedInput.readInt(false));
/* 1184 */       if (bool6) {
/* 1185 */         quadRegion.setSameCornerColors(color);
/*      */       } else {
/* 1187 */         quadRegion.setCornerColorsSeparate(color, 
/*      */             
/* 1189 */             PMath.abgr8888ToColor(paramFixedInput.readInt(false)), 
/* 1190 */             PMath.abgr8888ToColor(paramFixedInput.readInt(false)), 
/* 1191 */             PMath.abgr8888ToColor(paramFixedInput.readInt(false)));
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1196 */     if (b != 0) {
/* 1197 */       quadRegion.m = paramFixedInput.readByte();
/*      */     }
/*      */     
/* 1200 */     quadRegion.setColorMode(paramFixedInput.readByte());
/* 1201 */     quadRegion.updateSize();
/*      */     
/* 1203 */     return quadRegion;
/*      */   }
/*      */   
/*      */   public final void toJson(Json paramJson) {
/* 1207 */     paramJson.writeObjectStart();
/*      */ 
/*      */     
/* 1210 */     if (this.quadName != null) {
/* 1211 */       paramJson.writeValue("i", this.quadName);
/*      */     }
/*      */ 
/*      */     
/* 1215 */     if (this.regionName != null) {
/* 1216 */       paramJson.writeValue("t", this.regionName);
/*      */     }
/*      */     
/* 1219 */     if (getColorMode() != 0) {
/* 1220 */       paramJson.writeValue("cm", Byte.valueOf(getColorMode()));
/*      */     }
/*      */ 
/*      */     
/* 1224 */     if (this.h != 0.0F || this.i != 0.0F) {
/* 1225 */       paramJson.writeArrayStart("p");
/* 1226 */       Quad.jsonWriteIntOrFloat(paramJson, this.h);
/* 1227 */       Quad.jsonWriteIntOrFloat(paramJson, this.i);
/* 1228 */       paramJson.writeArrayEnd();
/*      */     } 
/*      */ 
/*      */     
/* 1232 */     paramJson.writeArrayStart("v");
/* 1233 */     if (isFullSizeRect()) {
/*      */       
/* 1235 */       Quad.jsonWriteIntOrFloat(paramJson, this.j);
/* 1236 */       Quad.jsonWriteIntOrFloat(paramJson, this.k);
/*      */     } else {
/*      */       
/* 1239 */       for (byte b = 0; b < 8; b++) {
/* 1240 */         Quad.jsonWriteIntOrFloat(paramJson, this.f[b]);
/*      */       }
/*      */     } 
/* 1243 */     paramJson.writeArrayEnd();
/*      */ 
/*      */     
/* 1246 */     this.g.toJson(paramJson);
/*      */ 
/*      */     
/* 1249 */     if (this.m != 0)
/*      */     {
/* 1251 */       paramJson.writeValue("n", Byte.valueOf(this.m));
/*      */     }
/*      */     
/* 1254 */     paramJson.writeObjectEnd();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private QuadRegion() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class AllWhiteCornerColors
/*      */     implements CornerColors
/*      */   {
/* 1276 */     public static final AllWhiteCornerColors INSTANCE = new AllWhiteCornerColors();
/*      */ 
/*      */     
/*      */     public final boolean sameAs(QuadRegion.CornerColors param1CornerColors) {
/* 1280 */       return (param1CornerColors == INSTANCE);
/*      */     }
/*      */ 
/*      */     
/*      */     public final Color get(int param1Int) {
/* 1285 */       return Color.WHITE;
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean isSingleColor() {
/* 1290 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     public final QuadRegion.CornerColors cpyCornerColors() {
/* 1295 */       return this;
/*      */     }
/*      */ 
/*      */     
/*      */     public final void toJson5String(StringBuilder param1StringBuilder) {}
/*      */ 
/*      */     
/*      */     public final void toJson(Json param1Json) {}
/*      */ 
/*      */     
/*      */     public final QuadRegion.CornerColors simplifyIfNeeded() {
/* 1306 */       return this;
/*      */     }
/*      */   } public static interface CornerColors { boolean sameAs(CornerColors param1CornerColors); Color get(int param1Int); boolean isSingleColor();
/*      */     CornerColors cpyCornerColors();
/*      */     void toJson5String(StringBuilder param1StringBuilder);
/*      */     void toJson(Json param1Json);
/*      */     CornerColors simplifyIfNeeded(); }
/*      */   public static final class SingleCornerColor extends Color implements CornerColors { public SingleCornerColor(Color param1Color) {
/* 1314 */       set(param1Color);
/*      */     }
/*      */     public SingleCornerColor() {}
/*      */     
/*      */     public final boolean sameAs(QuadRegion.CornerColors param1CornerColors) {
/* 1319 */       if (param1CornerColors instanceof SingleCornerColor) {
/* 1320 */         return (toIntBits() == ((Color)param1CornerColors).toIntBits());
/*      */       }
/* 1322 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public final Color get(int param1Int) {
/* 1327 */       return this;
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean isSingleColor() {
/* 1332 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     public final QuadRegion.CornerColors cpyCornerColors() {
/* 1337 */       return new SingleCornerColor(this);
/*      */     }
/*      */ 
/*      */     
/*      */     public final void toJson5String(StringBuilder param1StringBuilder) {
/* 1342 */       param1StringBuilder.append("c:[");
/*      */       String str;
/* 1344 */       if ((str = "#" + this).endsWith("ff")) {
/* 1345 */         str = str.substring(0, str.length() - 2);
/*      */       }
/* 1347 */       param1StringBuilder.append('"');
/* 1348 */       param1StringBuilder.append(str);
/* 1349 */       param1StringBuilder.append("\"]");
/*      */     }
/*      */ 
/*      */     
/*      */     public final void toJson(Json param1Json) {
/* 1354 */       param1Json.writeArrayStart("c");
/*      */       String str;
/* 1356 */       if ((str = "#" + this).endsWith("ff")) {
/* 1357 */         str = str.substring(0, str.length() - 2);
/*      */       }
/* 1359 */       param1Json.writeValue(str);
/* 1360 */       param1Json.writeArrayEnd();
/*      */     }
/*      */ 
/*      */     
/*      */     public final QuadRegion.CornerColors simplifyIfNeeded() {
/* 1365 */       return (QuadRegion.CornerColors)((toIntBits() == QuadRegion.b()) ? QuadRegion.AllWhiteCornerColors.INSTANCE : this);
/*      */     } }
/*      */ 
/*      */   
/*      */   public static final class FourCornerColors implements CornerColors {
/* 1370 */     private final Color a = new Color();
/* 1371 */     private final Color b = new Color();
/* 1372 */     private final Color c = new Color();
/* 1373 */     private final Color d = new Color();
/*      */ 
/*      */ 
/*      */     
/*      */     public FourCornerColors(Color param1Color1, Color param1Color2, Color param1Color3, Color param1Color4) {
/* 1378 */       this.a.set(param1Color1);
/* 1379 */       this.b.set(param1Color2);
/* 1380 */       this.c.set(param1Color3);
/* 1381 */       this.d.set(param1Color4);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static FourCornerColors of(JsonValue param1JsonValue) {
/* 1388 */       return new FourCornerColors(
/* 1389 */           Color.valueOf(param1JsonValue.get(0).asString()), 
/* 1390 */           Color.valueOf(param1JsonValue.get(1).asString()), 
/* 1391 */           Color.valueOf(param1JsonValue.get(2).asString()), 
/* 1392 */           Color.valueOf(param1JsonValue.get(3).asString()));
/*      */     }
/*      */ 
/*      */     
/*      */     public static FourCornerColors of(m param1m) {
/* 1397 */       return new FourCornerColors(
/* 1398 */           Color.valueOf(param1m.a(0).i()), 
/* 1399 */           Color.valueOf(param1m.a(1).i()), 
/* 1400 */           Color.valueOf(param1m.a(2).i()), 
/* 1401 */           Color.valueOf(param1m.a(3).i()));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final boolean sameAs(QuadRegion.CornerColors param1CornerColors) {
/* 1407 */       if (param1CornerColors instanceof FourCornerColors) {
/* 1408 */         param1CornerColors = param1CornerColors;
/* 1409 */         if (this.a.toIntBits() == ((FourCornerColors)param1CornerColors).a.toIntBits() && this.b
/* 1410 */           .toIntBits() == ((FourCornerColors)param1CornerColors).b.toIntBits() && this.c
/* 1411 */           .toIntBits() == ((FourCornerColors)param1CornerColors).c.toIntBits() && this.d
/* 1412 */           .toIntBits() == ((FourCornerColors)param1CornerColors).d.toIntBits()) return true;  return false;
/*      */       } 
/* 1414 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final Color get(int param1Int) {
/* 1420 */       switch (param1Int) { case 0:
/* 1421 */           return this.a;
/* 1422 */         case 1: return this.b;
/* 1423 */         case 2: return this.c;
/* 1424 */         case 3: return this.d; }
/*      */       
/* 1426 */       throw new IllegalArgumentException("Invalid index: " + param1Int);
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean isSingleColor() {
/* 1431 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public final QuadRegion.CornerColors cpyCornerColors() {
/* 1436 */       return new FourCornerColors(this.a, this.b, this.c, this.d);
/*      */     }
/*      */ 
/*      */     
/*      */     public final void toJson5String(StringBuilder param1StringBuilder) {
/* 1441 */       param1StringBuilder.append("c:[");
/* 1442 */       for (byte b = 0; b < 4; b++) {
/*      */         String str;
/* 1444 */         if ((str = "#" + get(b)).endsWith("ff")) {
/* 1445 */           str = str.substring(0, str.length() - 2);
/*      */         }
/* 1447 */         param1StringBuilder.append('"');
/* 1448 */         param1StringBuilder.append(str);
/* 1449 */         param1StringBuilder.append('"');
/* 1450 */         if (b != 3) {
/* 1451 */           param1StringBuilder.append(',');
/*      */         }
/*      */       } 
/* 1454 */       param1StringBuilder.append("]");
/*      */     }
/*      */ 
/*      */     
/*      */     public final void toJson(Json param1Json) {
/* 1459 */       param1Json.writeArrayStart("c");
/* 1460 */       for (byte b = 0; b < 4; b++) {
/*      */         String str;
/* 1462 */         if ((str = "#" + get(b)).endsWith("ff")) {
/* 1463 */           str = str.substring(0, str.length() - 2);
/*      */         }
/* 1465 */         param1Json.writeValue(str);
/*      */       } 
/* 1467 */       param1Json.writeArrayEnd();
/*      */     }
/*      */ 
/*      */     
/*      */     public final QuadRegion.CornerColors simplifyIfNeeded() {
/* 1472 */       int i = this.a.toIntBits();
/* 1473 */       int j = this.b.toIntBits();
/* 1474 */       if (i != j) {
/* 1475 */         return this;
/*      */       }
/* 1477 */       j = this.a.toIntBits();
/* 1478 */       if (i != j) {
/* 1479 */         return this;
/*      */       }
/* 1481 */       j = this.a.toIntBits();
/* 1482 */       if (i != j) {
/* 1483 */         return this;
/*      */       }
/*      */ 
/*      */       
/* 1487 */       if (i == QuadRegion.b()) {
/* 1488 */         return QuadRegion.AllWhiteCornerColors.INSTANCE;
/*      */       }
/* 1490 */       return new QuadRegion.SingleCornerColor(this.a);
/*      */     }
/*      */     
/*      */     private FourCornerColors() {}
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\QuadRegion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */