/*      */ package com.prineside.tdi2.systems;
/*      */ 
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.Texture;
/*      */ import com.badlogic.gdx.graphics.g2d.Batch;
/*      */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*      */ import com.badlogic.gdx.graphics.g2d.BitmapFontCache;
/*      */ import com.badlogic.gdx.graphics.g2d.GlyphLayout;
/*      */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*      */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*      */ import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
/*      */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*      */ import com.badlogic.gdx.math.Interpolation;
/*      */ import com.badlogic.gdx.math.Polygon;
/*      */ import com.badlogic.gdx.math.Vector2;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*      */ import com.badlogic.gdx.utils.IntFloatMap;
/*      */ import com.badlogic.gdx.utils.IntIntMap;
/*      */ import com.badlogic.gdx.utils.IntMap;
/*      */ import com.badlogic.gdx.utils.Null;
/*      */ import com.badlogic.gdx.utils.ObjectMap;
/*      */ import com.badlogic.gdx.utils.Pool;
/*      */ import com.badlogic.gdx.utils.StringBuilder;
/*      */ import com.prineside.tdi2.Config;
/*      */ import com.prineside.tdi2.Enemy;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.GameSystem;
/*      */ import com.prineside.tdi2.Projectile;
/*      */ import com.prineside.tdi2.Threads;
/*      */ import com.prineside.tdi2.Tower;
/*      */ import com.prineside.tdi2.configs.GameRenderingOrder;
/*      */ import com.prineside.tdi2.enums.DamageType;
/*      */ import com.prineside.tdi2.enums.LimitedParticleType;
/*      */ import com.prineside.tdi2.managers.SettingsManager;
/*      */ import com.prineside.tdi2.shapes.ChainLightning;
/*      */ import com.prineside.tdi2.utils.DrawUtils;
/*      */ import com.prineside.tdi2.utils.FastRandom;
/*      */ import com.prineside.tdi2.utils.MaterialColor;
/*      */ import com.prineside.tdi2.utils.MovingAverageLong;
/*      */ import com.prineside.tdi2.utils.NAGS;
/*      */ import com.prineside.tdi2.utils.PMath;
/*      */ import com.prineside.tdi2.utils.PooledCustomEffect;
/*      */ import com.prineside.tdi2.utils.StringFormatter;
/*      */ import java.util.Arrays;
/*      */ import java.util.Comparator;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @NAGS
/*      */ public final class ParticleSystem
/*      */   extends GameSystem
/*      */ {
/*      */   private static final float[] a;
/*      */   private final int b;
/*      */   private final int c;
/*      */   private final int d;
/*      */   private final int e;
/*      */   private final int f;
/*      */   private final int g;
/*      */   private final int h;
/*      */   private final int i;
/*      */   
/*      */   static {
/*   71 */     Arrays.fill(a = new float[LimitedParticleType.values.length], 4.0F * Config.UPDATE_DELTA_TIME);
/*   72 */     a[LimitedParticleType.EXPLOSION_FIREBALL.ordinal()] = 1.0F * Config.UPDATE_DELTA_TIME;
/*   73 */     a[LimitedParticleType.EXPLOSION_MISSILE.ordinal()] = 8.0F * Config.UPDATE_DELTA_TIME;
/*   74 */     a[LimitedParticleType.EXPLOSION_CANNON.ordinal()] = 8.0F * Config.UPDATE_DELTA_TIME;
/*   75 */     a[LimitedParticleType.ENEMY_HIT.ordinal()] = 5.0F * Config.UPDATE_DELTA_TIME;
/*   76 */     a[LimitedParticleType.ENEMY_DEAD.ordinal()] = 4.0F * Config.UPDATE_DELTA_TIME;
/*   77 */     a[LimitedParticleType.RESOURCE_MINED.ordinal()] = 5.0F * Config.UPDATE_DELTA_TIME;
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
/*      */ 
/*      */     
/*      */     (paramDamageParticle1, paramDamageParticle2) -> Long.compare(paramDamageParticle1.e, paramDamageParticle2.e);
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
/*      */     
/*  126 */     A = ((paramDamageParticle1, paramDamageParticle2) -> Float.compare(paramDamageParticle2.k, paramDamageParticle1.k));
/*      */   }
/*      */   private final float[] j = new float[LimitedParticleType.values.length]; private final DelayedRemovalArray<ParticleEffect> k = new DelayedRemovalArray(false, 16, ParticleEffect.class); private final DelayedRemovalArray<ParticleEffect> l = new DelayedRemovalArray(false, 16, ParticleEffect.class); private final DelayedRemovalArray<XpOrbParticle> m = new DelayedRemovalArray(XpOrbParticle.class); private final DelayedRemovalArray<ShatterPolygon> n = new DelayedRemovalArray(ShatterPolygon.class); private final DelayedRemovalArray<ShatterPolygon> o = new DelayedRemovalArray(ShatterPolygon.class); private final DelayedRemovalArray<CoinParticle> p = new DelayedRemovalArray(CoinParticle.class); private final DelayedRemovalArray<DamageParticle> q = new DelayedRemovalArray(DamageParticle.class); private final DelayedRemovalArray<ChainLightning> r = new DelayedRemovalArray(false, 1, ChainLightning.class);
/*  129 */   private static final IntIntMap C = new IntIntMap(); private final DelayedRemovalArray<DamageParticle> s = new DelayedRemovalArray(DamageParticle.class); private final DelayedRemovalArray<DamageParticle> t = new DelayedRemovalArray(DamageParticle.class); private final DelayedRemovalArray<DamageParticle> u = new DelayedRemovalArray(DamageParticle.class); private final DelayedRemovalArray<DamageParticle> v = new DelayedRemovalArray(DamageParticle.class); private final DelayedRemovalArray<FlashParticle> w = new DelayedRemovalArray(FlashParticle.class); private final Pool<XpOrbParticle> x = new Pool<XpOrbParticle>(this, 1, 512) { private static ParticleSystem.XpOrbParticle a() { return new ParticleSystem.XpOrbParticle((byte)0); } }
/*  130 */   ; private final Pool<ShatterPolygon> y = new Pool<ShatterPolygon>(this, 1, 512) { private static ParticleSystem.ShatterPolygon a() { return new ParticleSystem.ShatterPolygon((byte)0); } }; private final Pool<CoinParticle> z = new Pool<CoinParticle>(this, 1, 512) { private static ParticleSystem.CoinParticle a() { return new ParticleSystem.CoinParticle((byte)0); } }; private static final Comparator<DamageParticle> A; private int B; private final MovingAverageLong D = new MovingAverageLong(32);
/*      */   
/*  132 */   private final IntMap<Pool<DamageParticle>> E = new IntMap();
/*  133 */   private final Pool<FlashParticle> F = new Pool<FlashParticle>(this, 1, 512)
/*      */     {
/*      */       private static ParticleSystem.FlashParticle a() {
/*  136 */         return new ParticleSystem.FlashParticle((byte)0);
/*      */       }
/*      */     };
/*  139 */   private final IntMap<BitmapFontCache> G = new IntMap();
/*      */   
/*      */   private BitmapFontCache H;
/*      */   
/*      */   private TextureRegion I;
/*      */   
/*      */   private int J;
/*      */   private int K;
/*  147 */   private final IntIntMap L = new IntIntMap();
/*      */   private int M;
/*  149 */   private final IntFloatMap N = new IntFloatMap();
/*      */   
/*  151 */   private static final Vector2 O = new Vector2();
/*  152 */   private static final StringBuilder P = new StringBuilder();
/*  153 */   private static final float[] Q = new float[20];
/*  154 */   private static final Color R = Color.WHITE.cpy();
/*      */   
/*  156 */   private static final Vector2 T = new Vector2();
/*  157 */   private static final Vector2 U = new Vector2();
/*      */ 
/*      */   
/*      */   public final boolean affectsGameState() {
/*  161 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public ParticleSystem() {
/*  166 */     this.I = (TextureRegion)Game.i.assetManager.getTextureRegion("coin-small");
/*      */     
/*  168 */     this.H = new BitmapFontCache((BitmapFont)Game.i.assetManager.getFont(21));
/*  169 */     this.H.setUseIntegerPositions(false);
/*      */ 
/*      */     
/*  172 */     float f = (float)Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.PARTICLE_COUNT);
/*  173 */     this.b = (int)(200.0F * f);
/*  174 */     this.c = (int)(100.0F * f);
/*  175 */     this.d = (int)(600.0F * f);
/*  176 */     this.e = (int)(200.0F * f);
/*  177 */     this.f = (int)(200.0F * f);
/*  178 */     this.g = (int)(100.0F * f);
/*  179 */     this.h = (int)(200.0F * f);
/*  180 */     this.i = (int)(100.0F * f);
/*  181 */     System.arraycopy(a, 0, this.j, 0, this.j.length);
/*      */     
/*  183 */     f = (1.0F / f + 2.0F) / 3.0F;
/*  184 */     for (byte b = 0; b < this.j.length; b++) {
/*  185 */       this.j[b] = this.j[b] * f;
/*      */     }
/*      */   }
/*      */   
/*      */   public final void addFlashParticle(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7) {
/*  190 */     addFlashParticleColored(paramTextureRegion, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, Color.WHITE);
/*      */   }
/*      */   
/*      */   public final void addFlashParticleColored(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, Color paramColor) {
/*  194 */     if (this.S.gameState.canSkipMediaUpdate() || !Game.i.settingsManager.isParticlesDrawing())
/*      */       return; 
/*  196 */     if (this.w.size > this.b) {
/*      */       return;
/*      */     }
/*  199 */     if (this.w.size > this.c)
/*      */     {
/*  201 */       if (FastRandom.getFloat() < 0.5F) {
/*      */         return;
/*      */       }
/*      */     }
/*      */     
/*      */     FlashParticle flashParticle;
/*  207 */     (flashParticle = (FlashParticle)this.F.obtain()).time = 0.0F;
/*  208 */     flashParticle.texture = paramTextureRegion.getTexture();
/*  209 */     flashParticle.color.set(paramColor);
/*  210 */     DrawUtils.bakeVertices(flashParticle.vertices, paramTextureRegion, paramFloat1 - paramFloat3, paramFloat2 - paramFloat4, paramFloat3, paramFloat4, paramFloat5, paramFloat6, 1.0F, 1.0F, paramFloat7);
/*  211 */     this.w.add(flashParticle);
/*      */   }
/*      */   
/*      */   public final void addRegularShatterParticle(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5) {
/*  215 */     addShatterParticle(paramTextureRegion, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, Color.WHITE, Interpolation.pow2InInverse, true);
/*      */   }
/*      */   
/*      */   public final void addShatterParticle(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, Color paramColor, @Null Interpolation paramInterpolation, boolean paramBoolean) {
/*  219 */     if (this.S.gameState.canSkipMediaUpdate() || !Game.i.settingsManager.isParticlesDrawing())
/*      */       return; 
/*      */     DelayedRemovalArray<ShatterPolygon> delayedRemovalArray;
/*  222 */     if (((Array)(delayedRemovalArray = paramBoolean ? this.o : this.n)).size > this.d)
/*      */       return; 
/*  224 */     if (((Array)delayedRemovalArray).size > this.e && 
/*  225 */       FastRandom.getFloat() > 0.5F) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/*  230 */     if (paramInterpolation == null) {
/*  231 */       paramInterpolation = Interpolation.linear;
/*      */     }
/*      */     
/*  234 */     paramFloat1 -= paramFloat3 * 0.5F;
/*  235 */     paramFloat2 -= paramFloat3 * 0.5F;
/*      */     
/*  237 */     paramFloat3 *= paramFloat5;
/*      */ 
/*      */     
/*  240 */     paramFloat5 = 0.25F + FastRandom.getFloat() * 0.5F;
/*  241 */     float f1 = 0.25F + FastRandom.getFloat() * 0.5F;
/*  242 */     float f2 = 0.25F + FastRandom.getFloat() * 0.5F;
/*  243 */     float f3 = 0.25F + FastRandom.getFloat() * 0.5F;
/*  244 */     float f4 = 0.25F + FastRandom.getFloat() * 0.5F;
/*  245 */     float f5 = 0.25F + FastRandom.getFloat() * 0.5F;
/*  246 */     float f6 = paramTextureRegion.getU2();
/*  247 */     float f7 = paramTextureRegion.getU();
/*  248 */     float f8 = paramTextureRegion.getV2();
/*  249 */     float f9 = paramTextureRegion.getV();
/*      */     
/*  251 */     float f10 = f6 + (f7 - f6) * f4;
/*  252 */     float f11 = f8 + (f9 - f8) * f5;
/*  253 */     float f12 = f8 + (f9 - f8) * paramFloat5;
/*  254 */     float f13 = f6 + (f7 - f6) * f1;
/*  255 */     float f14 = f8 + (f9 - f8) * f2;
/*  256 */     float f15 = f6 + (f7 - f6) * f3;
/*      */     
/*      */     ShatterPolygon shatterPolygon;
/*      */     
/*  260 */     ShatterPolygon.a(shatterPolygon = (ShatterPolygon)this.y.obtain(), paramTextureRegion.getTexture());
/*  261 */     ShatterPolygon.a(shatterPolygon).set(paramColor);
/*  262 */     ShatterPolygon.a(shatterPolygon, paramInterpolation);
/*      */     
/*  264 */     ShatterPolygon.b(shatterPolygon)[0] = 0.0F;
/*  265 */     ShatterPolygon.b(shatterPolygon)[1] = paramFloat3 * paramFloat5;
/*  266 */     ShatterPolygon.b(shatterPolygon)[2] = 0.0F;
/*  267 */     ShatterPolygon.b(shatterPolygon)[3] = paramFloat3;
/*  268 */     ShatterPolygon.b(shatterPolygon)[4] = paramFloat3 * f1;
/*  269 */     ShatterPolygon.b(shatterPolygon)[5] = paramFloat3;
/*  270 */     ShatterPolygon.b(shatterPolygon)[6] = paramFloat3 * f4;
/*  271 */     ShatterPolygon.b(shatterPolygon)[7] = paramFloat3 * f5;
/*  272 */     ShatterPolygon.c(shatterPolygon).setVertices(ShatterPolygon.b(shatterPolygon));
/*      */     
/*  274 */     ShatterPolygon.d(shatterPolygon)[0] = f6;
/*  275 */     ShatterPolygon.d(shatterPolygon)[1] = f12;
/*  276 */     ShatterPolygon.d(shatterPolygon)[2] = f6;
/*  277 */     ShatterPolygon.d(shatterPolygon)[3] = f9;
/*  278 */     ShatterPolygon.d(shatterPolygon)[4] = f13;
/*  279 */     ShatterPolygon.d(shatterPolygon)[5] = f9;
/*  280 */     ShatterPolygon.d(shatterPolygon)[6] = f10;
/*  281 */     ShatterPolygon.d(shatterPolygon)[7] = f11;
/*      */     
/*  283 */     ShatterPolygon.c(shatterPolygon).setPosition(paramFloat1, paramFloat2);
/*  284 */     ShatterPolygon.c(shatterPolygon).setOrigin(paramFloat3 * 0.5F, paramFloat3 * 0.5F);
/*  285 */     ShatterPolygon.c(shatterPolygon).setRotation(paramFloat4);
/*      */     
/*  287 */     ShatterPolygon.a(shatterPolygon, 0.6F + FastRandom.getFloat() * 0.5F);
/*  288 */     ShatterPolygon.b(shatterPolygon, FastRandom.getFloat() * 0.5F - 1.0F);
/*  289 */     ShatterPolygon.c(shatterPolygon, 0.0F);
/*      */     
/*  291 */     ShatterPolygon.e(shatterPolygon).set(0.0F, 128.0F + FastRandom.getFloat() * 256.0F).rotateDeg(FastRandom.getFloat() * 60.0F + 15.0F + paramFloat4);
/*  292 */     delayedRemovalArray.add(shatterPolygon);
/*      */ 
/*      */ 
/*      */     
/*  296 */     ShatterPolygon.a(shatterPolygon = (ShatterPolygon)this.y.obtain(), paramTextureRegion.getTexture());
/*  297 */     ShatterPolygon.a(shatterPolygon).set(paramColor);
/*  298 */     ShatterPolygon.a(shatterPolygon, paramInterpolation);
/*      */     
/*  300 */     ShatterPolygon.b(shatterPolygon)[0] = paramFloat3 * f4;
/*  301 */     ShatterPolygon.b(shatterPolygon)[1] = paramFloat3 * f5;
/*  302 */     ShatterPolygon.b(shatterPolygon)[2] = paramFloat3 * f1;
/*  303 */     ShatterPolygon.b(shatterPolygon)[3] = paramFloat3;
/*  304 */     ShatterPolygon.b(shatterPolygon)[4] = paramFloat3;
/*  305 */     ShatterPolygon.b(shatterPolygon)[5] = paramFloat3;
/*  306 */     ShatterPolygon.b(shatterPolygon)[6] = paramFloat3;
/*  307 */     ShatterPolygon.b(shatterPolygon)[7] = paramFloat3 * f2;
/*  308 */     ShatterPolygon.c(shatterPolygon).setVertices(ShatterPolygon.b(shatterPolygon));
/*      */     
/*  310 */     ShatterPolygon.d(shatterPolygon)[0] = f10;
/*  311 */     ShatterPolygon.d(shatterPolygon)[1] = f11;
/*  312 */     ShatterPolygon.d(shatterPolygon)[2] = f13;
/*  313 */     ShatterPolygon.d(shatterPolygon)[3] = f9;
/*  314 */     ShatterPolygon.d(shatterPolygon)[4] = f7;
/*  315 */     ShatterPolygon.d(shatterPolygon)[5] = f9;
/*  316 */     ShatterPolygon.d(shatterPolygon)[6] = f7;
/*  317 */     ShatterPolygon.d(shatterPolygon)[7] = f14;
/*      */     
/*  319 */     ShatterPolygon.c(shatterPolygon).setPosition(paramFloat1, paramFloat2);
/*  320 */     ShatterPolygon.c(shatterPolygon).setOrigin(paramFloat3 * 0.5F, paramFloat3 * 0.5F);
/*  321 */     ShatterPolygon.c(shatterPolygon).setRotation(paramFloat4);
/*      */     
/*  323 */     ShatterPolygon.a(shatterPolygon, 0.6F + FastRandom.getFloat() * 0.5F);
/*  324 */     ShatterPolygon.c(shatterPolygon, 0.0F);
/*      */     
/*  326 */     ShatterPolygon.e(shatterPolygon).set(0.0F, 128.0F + FastRandom.getFloat() * 256.0F).rotateDeg(FastRandom.getFloat() * 60.0F + 15.0F + 270.0F + paramFloat4);
/*  327 */     delayedRemovalArray.add(shatterPolygon);
/*      */ 
/*      */ 
/*      */     
/*  331 */     ShatterPolygon.a(shatterPolygon = (ShatterPolygon)this.y.obtain(), paramTextureRegion.getTexture());
/*  332 */     ShatterPolygon.a(shatterPolygon).set(paramColor);
/*  333 */     ShatterPolygon.a(shatterPolygon, paramInterpolation);
/*      */     
/*  335 */     ShatterPolygon.b(shatterPolygon)[0] = paramFloat3;
/*  336 */     ShatterPolygon.b(shatterPolygon)[1] = paramFloat3 * f2;
/*  337 */     ShatterPolygon.b(shatterPolygon)[2] = paramFloat3;
/*  338 */     ShatterPolygon.b(shatterPolygon)[3] = 0.0F;
/*  339 */     ShatterPolygon.b(shatterPolygon)[4] = paramFloat3 * f3;
/*  340 */     ShatterPolygon.b(shatterPolygon)[5] = 0.0F;
/*  341 */     ShatterPolygon.b(shatterPolygon)[6] = paramFloat3 * f4;
/*  342 */     ShatterPolygon.b(shatterPolygon)[7] = paramFloat3 * f5;
/*  343 */     ShatterPolygon.c(shatterPolygon).setVertices(ShatterPolygon.b(shatterPolygon));
/*      */     
/*  345 */     ShatterPolygon.d(shatterPolygon)[0] = f7;
/*  346 */     ShatterPolygon.d(shatterPolygon)[1] = f14;
/*  347 */     ShatterPolygon.d(shatterPolygon)[2] = f7;
/*  348 */     ShatterPolygon.d(shatterPolygon)[3] = f8;
/*  349 */     ShatterPolygon.d(shatterPolygon)[4] = f15;
/*  350 */     ShatterPolygon.d(shatterPolygon)[5] = f8;
/*  351 */     ShatterPolygon.d(shatterPolygon)[6] = f10;
/*  352 */     ShatterPolygon.d(shatterPolygon)[7] = f11;
/*      */     
/*  354 */     ShatterPolygon.c(shatterPolygon).setPosition(paramFloat1, paramFloat2);
/*  355 */     ShatterPolygon.c(shatterPolygon).setOrigin(paramFloat3 * 0.5F, paramFloat3 * 0.5F);
/*  356 */     ShatterPolygon.c(shatterPolygon).setRotation(paramFloat4);
/*      */     
/*  358 */     ShatterPolygon.a(shatterPolygon, 0.6F + FastRandom.getFloat() * 0.5F);
/*  359 */     ShatterPolygon.c(shatterPolygon, 0.0F);
/*      */     
/*  361 */     ShatterPolygon.e(shatterPolygon).set(0.0F, 128.0F + FastRandom.getFloat() * 256.0F).rotateDeg(FastRandom.getFloat() * 60.0F + 15.0F + 180.0F + paramFloat4);
/*  362 */     delayedRemovalArray.add(shatterPolygon);
/*      */ 
/*      */ 
/*      */     
/*  366 */     ShatterPolygon.a(shatterPolygon = (ShatterPolygon)this.y.obtain(), paramTextureRegion.getTexture());
/*  367 */     ShatterPolygon.a(shatterPolygon).set(paramColor);
/*  368 */     ShatterPolygon.a(shatterPolygon, paramInterpolation);
/*      */     
/*  370 */     ShatterPolygon.b(shatterPolygon)[0] = paramFloat3 * f4;
/*  371 */     ShatterPolygon.b(shatterPolygon)[1] = paramFloat3 * f5;
/*  372 */     ShatterPolygon.b(shatterPolygon)[2] = paramFloat3 * f3;
/*  373 */     ShatterPolygon.b(shatterPolygon)[3] = 0.0F;
/*  374 */     ShatterPolygon.b(shatterPolygon)[4] = 0.0F;
/*  375 */     ShatterPolygon.b(shatterPolygon)[5] = 0.0F;
/*  376 */     ShatterPolygon.b(shatterPolygon)[6] = 0.0F;
/*  377 */     ShatterPolygon.b(shatterPolygon)[7] = paramFloat3 * paramFloat5;
/*  378 */     ShatterPolygon.c(shatterPolygon).setVertices(ShatterPolygon.b(shatterPolygon));
/*      */     
/*  380 */     ShatterPolygon.d(shatterPolygon)[0] = f10;
/*  381 */     ShatterPolygon.d(shatterPolygon)[1] = f11;
/*  382 */     ShatterPolygon.d(shatterPolygon)[2] = f15;
/*  383 */     ShatterPolygon.d(shatterPolygon)[3] = f8;
/*  384 */     ShatterPolygon.d(shatterPolygon)[4] = f6;
/*  385 */     ShatterPolygon.d(shatterPolygon)[5] = f8;
/*  386 */     ShatterPolygon.d(shatterPolygon)[6] = f6;
/*  387 */     ShatterPolygon.d(shatterPolygon)[7] = f12;
/*      */     
/*  389 */     ShatterPolygon.c(shatterPolygon).setPosition(paramFloat1, paramFloat2);
/*  390 */     ShatterPolygon.c(shatterPolygon).setOrigin(paramFloat3 * 0.5F, paramFloat3 * 0.5F);
/*  391 */     ShatterPolygon.c(shatterPolygon).setRotation(paramFloat4);
/*      */     
/*  393 */     ShatterPolygon.a(shatterPolygon, 0.6F + FastRandom.getFloat() * 0.5F);
/*  394 */     ShatterPolygon.c(shatterPolygon, 0.0F);
/*      */     
/*  396 */     ShatterPolygon.e(shatterPolygon).set(0.0F, 128.0F + FastRandom.getFloat() * 256.0F).rotateDeg(FastRandom.getFloat() * 60.0F + 15.0F + 90.0F + paramFloat4);
/*  397 */     delayedRemovalArray.add(shatterPolygon);
/*      */   }
/*      */   
/*      */   public final void addXpOrbParticle(float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  401 */     if (this.m.size > this.h) {
/*      */       return;
/*      */     }
/*      */     
/*      */     int i;
/*  406 */     if ((i = (int)(paramFloat / 5.0F)) <= 0) i = 1; 
/*  407 */     float f = 12.0F;
/*  408 */     byte b = 0;
/*  409 */     while (i > 4) {
/*  410 */       i /= 2;
/*  411 */       f *= 1.25F;
/*  412 */       b++;
/*  413 */       if (b == 7) {
/*  414 */         if (i > 4) {
/*  415 */           i = 4;
/*      */         }
/*      */         
/*      */         break;
/*      */       } 
/*      */     } 
/*  421 */     for (b = 0; b < i; b++) {
/*  422 */       addOrbParticle(Game.i.modifierManager.F.BALANCE.orbTexture, f, paramInt1, paramInt2, paramInt3, paramInt4);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  433 */   private static final Vector2 V = new Vector2();
/*      */   
/*      */   public final void addOrbParticle(TextureRegion paramTextureRegion, float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  436 */     if (this.S.state.canSkipMediaUpdate() || !Game.i.settingsManager.isParticlesDrawing())
/*      */       return; 
/*  438 */     if (this.m.size > this.h)
/*      */       return; 
/*  440 */     if (this.m.size > this.i && 
/*  441 */       FastRandom.getFloat() > 0.5F) {
/*      */       return;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  450 */     int i = (i = (i = (i = paramInt1 + 31) * 31 + paramInt2) * 31 + paramInt3) * 31 + paramInt4;
/*      */     
/*      */     int j;
/*      */     
/*  454 */     if ((j = this.L.get(i, 0)) < 4) {
/*  455 */       XpOrbParticle xpOrbParticle = (XpOrbParticle)this.x.obtain();
/*  456 */       V.set(1.0F, 0.0F)
/*  457 */         .rotateDeg(FastRandom.getFloat() * 360.0F)
/*  458 */         .scl(FastRandom.getFloat() * 64.0F * 0.8F)
/*  459 */         .add(((paramInt1 << 7) + 64), ((paramInt2 << 7) + 64));
/*  460 */       xpOrbParticle.f = V.x;
/*  461 */       xpOrbParticle.g = V.y;
/*      */       
/*  463 */       V
/*  464 */         .set(1.0F, 0.0F)
/*  465 */         .rotateDeg(FastRandom.getFloat() * 360.0F)
/*  466 */         .scl(FastRandom.getFloat() * 64.0F * 3.0F);
/*  467 */       xpOrbParticle.d = V.x;
/*  468 */       xpOrbParticle.e = V.y;
/*      */       
/*  470 */       V
/*  471 */         .set(1.0F, 0.0F)
/*  472 */         .rotateDeg(FastRandom.getFloat() * 360.0F)
/*  473 */         .scl(FastRandom.getFloat() * 64.0F * 0.4F)
/*  474 */         .add(((paramInt3 << 7) + 64), ((paramInt4 << 7) + 64));
/*  475 */       xpOrbParticle.h = V.x;
/*  476 */       xpOrbParticle.i = V.y;
/*      */       
/*  478 */       xpOrbParticle.b = xpOrbParticle.f;
/*  479 */       xpOrbParticle.c = xpOrbParticle.g;
/*      */       
/*  481 */       XpOrbParticle.a(xpOrbParticle, paramTextureRegion);
/*  482 */       xpOrbParticle.a = paramFloat;
/*      */       
/*  484 */       this.m.add(xpOrbParticle);
/*      */       
/*  486 */       this.L.put(i, j + 1);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private BitmapFontCache a(int paramInt, float paramFloat1, float paramFloat2) {
/*      */     BitmapFontCache bitmapFontCache;
/*  493 */     if (paramInt < 32) {
/*  494 */       if (!this.G.containsKey(paramInt)) {
/*  495 */         bitmapFontCache = new BitmapFontCache((BitmapFont)Game.i.assetManager.getFont(21));
/*  496 */         P.setLength(0);
/*  497 */         P.append(paramInt);
/*  498 */         bitmapFontCache.addText((CharSequence)P, 0.0F, 0.0F);
/*  499 */         this.G.put(paramInt, bitmapFontCache);
/*  500 */         bitmapFontCache.setUseIntegerPositions(false);
/*      */       } else {
/*  502 */         bitmapFontCache = (BitmapFontCache)this.G.get(paramInt);
/*      */       } 
/*      */     } else {
/*      */       
/*  506 */       (bitmapFontCache = this.H).clear();
/*  507 */       bitmapFontCache.addText((CharSequence)StringFormatter.compactNumber(paramInt, false), 0.0F, 0.0F);
/*      */     } 
/*      */     
/*  510 */     bitmapFontCache.translate(-bitmapFontCache.getX() + paramFloat1, -bitmapFontCache.getY() + paramFloat2);
/*  511 */     return bitmapFontCache;
/*      */   }
/*      */   
/*      */   public final void addCoinParticle(float paramFloat1, float paramFloat2, int paramInt) {
/*  515 */     if (this.S.state.canSkipMediaUpdate() || !Game.i.settingsManager.isParticlesDrawing())
/*      */       return; 
/*      */     CoinParticle coinParticle;
/*  518 */     (coinParticle = (CoinParticle)this.z.obtain()).a.set(paramFloat1, paramFloat2);
/*  519 */     coinParticle.b = 64.0F + FastRandom.getFloat() * 32.0F;
/*  520 */     coinParticle.c = 0.0F;
/*  521 */     coinParticle.d = paramInt;
/*      */     
/*  523 */     this.p.add(coinParticle);
/*      */   }
/*      */   
/*      */   public final void addChainLightning(ChainLightning paramChainLightning) {
/*  527 */     if (this.S.state.canSkipMediaUpdate() || !Game.i.settingsManager.isProjectilesDrawing())
/*  528 */       return;  if (this.r.size > this.f) {
/*  529 */       paramChainLightning.free(); return;
/*      */     } 
/*  531 */     if (this.r.size > this.g && 
/*  532 */       FastRandom.getFloat() > 0.5F) {
/*  533 */       paramChainLightning.free();
/*      */       
/*      */       return;
/*      */     } 
/*  537 */     this.r.add(paramChainLightning);
/*      */   }
/*      */   
/*      */   public final void addEnemyHitParticle(Tower paramTower, Enemy paramEnemy, float paramFloat, Projectile paramProjectile) {
/*      */     Vector2 vector2;
/*  542 */     float f = PMath.getAngleBetweenPoints(vector2 = (paramTower.getTile()).center, paramEnemy.getPosition()) - 90.0F;
/*  543 */     U.set(1.0F, 0.0F).rotateDeg(f).scl(paramEnemy.getSize() * 0.75F);
/*  544 */     T.set(paramEnemy.getPosition()).add(U);
/*      */     
/*      */     int j;
/*  547 */     if ((j = a(T.x, T.y, LimitedParticleType.ENEMY_HIT)) == 0) {
/*      */       return;
/*      */     }
/*      */     
/*      */     ParticleEffectPool.PooledEffect pooledEffect;
/*  552 */     (pooledEffect = paramEnemy.getHitParticle()).setPosition(T.x, T.y);
/*      */     
/*      */     ParticleEmitter particleEmitter;
/*      */     
/*      */     ParticleEmitter.ScaledNumericValue scaledNumericValue2;
/*  557 */     (scaledNumericValue2 = (particleEmitter = (ParticleEmitter)pooledEffect.getEmitters().first()).getAngle()).setHigh(f - 60.0F, f + 60.0F);
/*      */     
/*      */     ParticleEmitter.GradientColorValue gradientColorValue;
/*  560 */     float[] arrayOfFloat = (gradientColorValue = particleEmitter.getTint()).getColors();
/*  561 */     Color color = paramEnemy.getColor();
/*  562 */     arrayOfFloat[0] = color.r;
/*  563 */     arrayOfFloat[1] = color.g;
/*  564 */     arrayOfFloat[2] = color.b;
/*  565 */     gradientColorValue.setColors(arrayOfFloat);
/*      */     
/*  567 */     ParticleEmitter.ScaledNumericValue scaledNumericValue1 = particleEmitter.getEmission();
/*      */     int i;
/*  569 */     if ((i = (int)(paramFloat / paramEnemy.maxHealth * 50.0F)) < 3) i = 3; 
/*  570 */     scaledNumericValue1.setHigh(i);
/*      */     
/*  572 */     a((ParticleEffect)pooledEffect, LimitedParticleType.ENEMY_HIT, j);
/*      */   }
/*      */   
/*      */   private Pool<DamageParticle> a(int paramInt) {
/*      */     Pool<DamageParticle> pool;
/*  577 */     if ((pool = (Pool)this.E.get(paramInt, null)) == null) {
/*  578 */       pool = new Pool<DamageParticle>(this, paramInt)
/*      */         {
/*      */           private ParticleSystem.DamageParticle a() {
/*  581 */             return new ParticleSystem.DamageParticle(this.a);
/*      */           }
/*      */         };
/*  584 */       this.E.put(paramInt, pool);
/*      */     } 
/*      */     
/*  587 */     return pool;
/*      */   }
/*      */   
/*      */   private static int a(float paramFloat1, float paramFloat2) {
/*  591 */     int i = (int)(paramFloat1 * 0.0078125F);
/*      */     int j;
/*  593 */     return ((j = (int)(paramFloat2 * 0.0078125F)) * 48 << 1) + i;
/*      */   }
/*      */ 
/*      */   
/*  597 */   private static final DelayedRemovalArray<DamageParticle> W = new DelayedRemovalArray(true, 1, DamageParticle.class);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void b(float paramFloat1, float paramFloat2) {
/*  606 */     paramFloat1 = Math.min(paramFloat1, paramFloat2);
/*      */     
/*  608 */     C.clear();
/*  609 */     this
/*      */       
/*  611 */       .B = (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DAMAGE_PARTICLES_MORE) == 0.0D) ? 1 : 5;
/*      */ 
/*      */     
/*  614 */     this.q.begin(); byte b;
/*  615 */     for (b = 0; b < this.q.size; b++) {
/*      */       DamageParticle damageParticle;
/*  617 */       (damageParticle = ((DamageParticle[])this.q.items)[b]).k += paramFloat1;
/*  618 */       if (damageParticle.k >= damageParticle.i) {
/*  619 */         this.q.removeIndex(b);
/*  620 */         a(damageParticle.h).free(damageParticle);
/*      */       } else {
/*  622 */         int i = a(damageParticle.a, damageParticle.b);
/*  623 */         C.put(i, C.get(i, 0) + 1);
/*      */         
/*  625 */         if (paramFloat1 > 0.0F) {
/*  626 */           damageParticle.d -= paramFloat1 * 170.0F;
/*  627 */           damageParticle.c *= 0.995F;
/*  628 */           damageParticle.a += damageParticle.c * paramFloat1;
/*  629 */           damageParticle.b += damageParticle.d * paramFloat1;
/*      */         } 
/*      */       } 
/*      */     } 
/*  633 */     this.q.end();
/*      */ 
/*      */     
/*  636 */     W.clear();
/*  637 */     this.s.begin();
/*  638 */     for (b = 0; b < this.s.size; b++) {
/*      */       DamageParticle damageParticle;
/*  640 */       (damageParticle = ((DamageParticle[])this.s.items)[b]).l += paramFloat2;
/*  641 */       if (damageParticle.l >= 0.5F) {
/*      */         
/*  643 */         W.add(damageParticle);
/*  644 */         this.s.removeIndex(b);
/*      */       } 
/*      */     } 
/*  647 */     this.s.end();
/*      */     
/*  649 */     a(W, this.q);
/*      */ 
/*      */     
/*  652 */     a(this.t, this.q);
/*      */ 
/*      */     
/*  655 */     a(this.u, this.q);
/*      */ 
/*      */     
/*  658 */     a(this.v, this.q);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(DelayedRemovalArray<DamageParticle> paramDelayedRemovalArray1, DelayedRemovalArray<DamageParticle> paramDelayedRemovalArray2) {
/*  667 */     if (paramDelayedRemovalArray1.size == 0) {
/*      */       return;
/*      */     }
/*      */     
/*  671 */     byte b = ((DamageParticle)paramDelayedRemovalArray1.first()).j;
/*      */ 
/*      */     
/*  674 */     int i = -1;
/*  675 */     float f = 0.0F; byte b1;
/*  676 */     for (b1 = 0; b1 < paramDelayedRemovalArray2.size; b1++) {
/*      */       DamageParticle damageParticle;
/*  678 */       if ((damageParticle = ((DamageParticle[])paramDelayedRemovalArray2.items)[b1]).j == b) {
/*  679 */         f = Math.max(f, (float)damageParticle.e);
/*      */       }
/*      */     } 
/*      */     
/*  683 */     for (b1 = 0; b1 < paramDelayedRemovalArray1.size; b1++) {
/*      */       DamageParticle damageParticle;
/*  685 */       if ((float)(damageParticle = ((DamageParticle[])paramDelayedRemovalArray1.items)[b1]).e > f) {
/*  686 */         i = b1;
/*  687 */         f = (float)damageParticle.e;
/*      */       } 
/*      */     } 
/*  690 */     if (i != -1) {
/*  691 */       paramDelayedRemovalArray2.add(paramDelayedRemovalArray1.removeIndex(i));
/*      */     }
/*      */ 
/*      */     
/*  695 */     paramDelayedRemovalArray1.shuffle();
/*  696 */     for (b1 = 0; b1 < paramDelayedRemovalArray1.size; b1++) {
/*      */       DamageParticle damageParticle;
/*  698 */       int j = a((damageParticle = ((DamageParticle[])paramDelayedRemovalArray1.items)[b1]).a, damageParticle.b);
/*      */       
/*  700 */       if ((i = C.get(j, 0)) < this.B) {
/*  701 */         paramDelayedRemovalArray2.add(damageParticle);
/*  702 */         C.put(j, i + 1);
/*      */       } else {
/*  704 */         a(damageParticle.h).free(damageParticle);
/*      */       } 
/*      */     } 
/*  707 */     paramDelayedRemovalArray1.clear();
/*      */   }
/*      */   
/*      */   private float a(long paramLong) {
/*      */     float f;
/*  712 */     if ((f = (float)paramLong / (float)this.D.getAverage()) > 30.0F)
/*  713 */       return 1.4F; 
/*  714 */     if (f > 10.0F)
/*  715 */       return 1.3F; 
/*  716 */     if (f > 5.0F)
/*  717 */       return 1.2F; 
/*  718 */     if (f > 2.0F) {
/*  719 */       return 1.1F;
/*      */     }
/*  721 */     return 1.0F;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void addDamageParticle(float paramFloat1, float paramFloat2, long paramLong, int paramInt1, int paramInt2) {
/*  726 */     if (paramLong <= 0L)
/*  727 */       return;  if (this.S.state.canSkipMediaUpdate() || !Game.i.settingsManager.isParticlesDrawing() || Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DAMAGE_PARTICLES_ENABLED) == 0.0D)
/*      */       return; 
/*  729 */     if (paramInt2 != 0)
/*      */     {
/*  731 */       for (byte b = 0; b < this.s.size; b++) {
/*      */         DamageParticle damageParticle1;
/*  733 */         if ((damageParticle1 = ((DamageParticle[])this.s.items)[b]).f == paramInt2) {
/*      */           
/*  735 */           damageParticle1.e += paramLong;
/*  736 */           damageParticle1.g = 1.0F;
/*  737 */           damageParticle1.a = paramFloat1 + FastRandom.getFloat() * 8.0F - 4.0F;
/*  738 */           damageParticle1.b = paramFloat2 + 16.0F + FastRandom.getFloat() * 8.0F - 4.0F;
/*      */           
/*      */           return;
/*      */         } 
/*      */       } 
/*      */     }
/*  744 */     this.D.push(paramLong);
/*      */     DamageParticle damageParticle;
/*  746 */     (damageParticle = (DamageParticle)a(paramInt1).obtain()).a = paramFloat1 + FastRandom.getFloat() * 8.0F - 4.0F;
/*  747 */     damageParticle.b = paramFloat2 + 16.0F + FastRandom.getFloat() * 8.0F - 4.0F;
/*  748 */     damageParticle.g = a(paramLong);
/*  749 */     damageParticle.e = paramLong;
/*  750 */     damageParticle.f = paramInt2;
/*      */     
/*  752 */     if (DamageType.Efficiency.isOverTime(paramInt1)) {
/*  753 */       this.s.add(damageParticle); return;
/*  754 */     }  if (DamageType.Efficiency.isEspeciallyEffective(paramInt1)) {
/*  755 */       this.t.add(damageParticle); return;
/*  756 */     }  if (DamageType.Efficiency.isCritical(paramInt1)) {
/*  757 */       this.u.add(damageParticle); return;
/*      */     } 
/*  759 */     this.v.add(damageParticle);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void setup() {
/*  765 */     this.S._render.addLayer((new RenderSystem.Layer(GameRenderingOrder.PARTICLE_UPDATE_DRAW, false, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> updateDraw(paramFloat1, paramFloat2)))
/*      */ 
/*      */         
/*  768 */         .setName("Particle-updateDraw"));
/*      */     
/*  770 */     this.S._render.addLayer((new RenderSystem.Layer(GameRenderingOrder.PARTICLE_DRAW, true, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> draw(paramBatch, paramFloat1, paramFloat2)))
/*      */ 
/*      */         
/*  773 */         .setName("Particle-draw"));
/*      */     
/*  775 */     this.S._render.addLayer((new RenderSystem.Layer(GameRenderingOrder.PARTICLE_DRAW_DAMAGE, false, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> drawDamageParticles(paramBatch)))
/*      */ 
/*      */         
/*  778 */         .setName("Particle-drawDamage"));
/*      */   }
/*      */ 
/*      */   
/*      */   public final String getSystemName() {
/*  783 */     return "Particle";
/*      */   }
/*      */   
/*      */   public static void freeParticle(ParticleEffect paramParticleEffect) {
/*  787 */     if (paramParticleEffect instanceof ParticleEffectPool.PooledEffect) {
/*  788 */       ((ParticleEffectPool.PooledEffect)paramParticleEffect).free(); return;
/*  789 */     }  if (paramParticleEffect instanceof PooledCustomEffect) {
/*  790 */       ((PooledCustomEffect)paramParticleEffect).free();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int a(float paramFloat1, float paramFloat2, LimitedParticleType paramLimitedParticleType) {
/*  801 */     int i = (i = (i = 31 + (int)(paramFloat1 * 0.015625F)) * 31 + (int)(paramFloat2 * 0.015625F)) * 31 + paramLimitedParticleType.ordinal();
/*      */ 
/*      */     
/*  804 */     if ((paramFloat2 = this.N.get(i, 0.0F)) <= 0.0F) {
/*  805 */       return i;
/*      */     }
/*  807 */     return 0;
/*      */   }
/*      */ 
/*      */   
/*      */   private void a(ParticleEffect paramParticleEffect, LimitedParticleType paramLimitedParticleType, int paramInt) {
/*  812 */     addParticle(paramParticleEffect, true);
/*  813 */     this.N.put(paramInt, this.j[paramLimitedParticleType.ordinal()]);
/*  814 */     this.J++;
/*      */   }
/*      */   
/*      */   public final void addLimitedParticle(ParticleEffect paramParticleEffect, LimitedParticleType paramLimitedParticleType, float paramFloat1, float paramFloat2) {
/*      */     int i;
/*  819 */     if ((i = a(paramFloat1, paramFloat2, paramLimitedParticleType)) == 0) {
/*  820 */       freeParticle(paramParticleEffect);
/*  821 */       this.K++; return;
/*      */     } 
/*  823 */     a(paramParticleEffect, paramLimitedParticleType, i);
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean willParticleBeSkipped() {
/*  828 */     return this.S.state.canSkipMediaUpdate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean addParticle(ParticleEffect paramParticleEffect, boolean paramBoolean) {
/*  835 */     if (willParticleBeSkipped() && paramBoolean) {
/*  836 */       freeParticle(paramParticleEffect);
/*  837 */       return false;
/*      */     } 
/*      */     
/*  840 */     this.k.add(paramParticleEffect);
/*      */ 
/*      */     
/*  843 */     return true;
/*      */   }
/*      */   
/*      */   public final boolean addOpaqueParticle(ParticleEffect paramParticleEffect) {
/*  847 */     if (willParticleBeSkipped()) {
/*  848 */       freeParticle(paramParticleEffect);
/*  849 */       return false;
/*      */     } 
/*      */     
/*  852 */     this.l.add(paramParticleEffect);
/*      */     
/*  854 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   private void c(float paramFloat1, float paramFloat2) {
/*      */     byte b;
/*  860 */     if (b = (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.MULTITHREADING) != 0.0D && this.k.size > 300) ? 1 : 0) {
/*  861 */       this.k.begin(); int j;
/*  862 */       for (b = 0, j = this.k.size; b < j; b++) {
/*      */         ParticleEffect particleEffect;
/*  864 */         if ((particleEffect = ((ParticleEffect[])this.k.items)[b]).isComplete()) {
/*  865 */           this.k.removeIndex(b);
/*  866 */           particleEffect.reset();
/*  867 */           freeParticle(particleEffect);
/*      */         } 
/*      */       } 
/*  870 */       this.k.end();
/*      */       
/*  872 */       Threads.i().concurrentLoop((Array)this.k, (paramInt, paramParticleEffect) -> {
/*      */             if ((paramParticleEffect.getEmitters()).size != 0 && ((ParticleEmitter)paramParticleEffect.getEmitters().first()).getName().charAt(0) == '#') {
/*      */               paramParticleEffect.update(paramFloat1);
/*      */               return;
/*      */             } 
/*      */             paramParticleEffect.update(paramFloat2);
/*      */           });
/*      */       return;
/*      */     } 
/*  881 */     this.k.begin(); int i;
/*  882 */     for (b = 0, i = this.k.size; b < i; b++) {
/*      */       ParticleEffect particleEffect;
/*  884 */       if ((particleEffect = ((ParticleEffect[])this.k.items)[b]).isComplete()) {
/*  885 */         this.k.removeIndex(b);
/*  886 */         particleEffect.reset();
/*  887 */         freeParticle(particleEffect);
/*      */ 
/*      */       
/*      */       }
/*  891 */       else if ((particleEffect.getEmitters()).size != 0 && ((ParticleEmitter)particleEffect.getEmitters().first()).getName().charAt(0) == '#') {
/*      */         
/*  893 */         particleEffect.update(paramFloat1);
/*      */       } else {
/*  895 */         particleEffect.update(paramFloat2);
/*      */       } 
/*      */     } 
/*  898 */     this.k.end();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void d(float paramFloat1, float paramFloat2) {
/*  904 */     for (int i = this.l.size - 1; i >= 0; i--) {
/*      */       ParticleEffect particleEffect;
/*  906 */       if ((particleEffect = ((ParticleEffect[])this.l.items)[i]).isComplete()) {
/*  907 */         this.l.removeIndex(i);
/*  908 */         particleEffect.reset();
/*  909 */         freeParticle(particleEffect);
/*      */ 
/*      */       
/*      */       }
/*  913 */       else if ((particleEffect.getEmitters()).size != 0 && ((ParticleEmitter)particleEffect.getEmitters().first()).getName().charAt(0) == '#') {
/*      */         
/*  915 */         particleEffect.update(paramFloat1);
/*      */       } else {
/*  917 */         particleEffect.update(paramFloat2);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void a(float paramFloat) {
/*  924 */     if (paramFloat > 0.1F) {
/*  925 */       paramFloat = 0.1F;
/*      */     }
/*      */     
/*  928 */     this.m.begin();
/*  929 */     for (byte b = 0; b < this.m.size; b++) {
/*  930 */       XpOrbParticle xpOrbParticle = ((XpOrbParticle[])this.m.items)[b];
/*      */       
/*  932 */       O.set(xpOrbParticle.h, xpOrbParticle.i).sub(xpOrbParticle.f, xpOrbParticle.g).nor().scl(384.0F);
/*      */       
/*  934 */       xpOrbParticle.d += xpOrbParticle.d * -paramFloat + O.x * paramFloat;
/*  935 */       xpOrbParticle.e += xpOrbParticle.e * -paramFloat + O.y * paramFloat;
/*  936 */       xpOrbParticle.f += xpOrbParticle.d * paramFloat;
/*  937 */       xpOrbParticle.g += xpOrbParticle.e * paramFloat;
/*      */       
/*  939 */       if (PMath.getSquareDistanceBetweenPoints(xpOrbParticle.f, xpOrbParticle.g, xpOrbParticle.h, xpOrbParticle.i) < 16.0F) {
/*  940 */         this.m.removeIndex(b);
/*  941 */         this.x.free(xpOrbParticle);
/*      */       } 
/*      */     } 
/*  944 */     this.m.end();
/*      */   }
/*      */ 
/*      */   
/*      */   private void e(float paramFloat1, float paramFloat2) {
/*  949 */     paramFloat1 = Math.min(paramFloat1, paramFloat2);
/*      */     
/*  951 */     this.p.begin();
/*  952 */     for (byte b = 0; b < this.p.size; b++) {
/*  953 */       CoinParticle coinParticle = ((CoinParticle[])this.p.items)[b];
/*  954 */       float f = Interpolation.pow2Out.apply(1.0F - coinParticle.c / 1.5F) * coinParticle.b;
/*  955 */       coinParticle.a.y += f * paramFloat1;
/*      */       
/*  957 */       coinParticle.c += paramFloat1;
/*  958 */       if (coinParticle.c >= 1.5F) {
/*  959 */         this.p.removeIndex(b);
/*  960 */         this.z.free(coinParticle);
/*      */       } 
/*      */     } 
/*  963 */     this.p.end();
/*      */   }
/*      */   
/*      */   private void b(float paramFloat) {
/*  967 */     for (byte b = 0; b < this.r.size; b++) {
/*      */       ChainLightning chainLightning;
/*  969 */       (chainLightning = ((ChainLightning[])this.r.items)[b]).update(paramFloat);
/*  970 */       if (chainLightning.isFinished()) {
/*  971 */         this.r.removeIndex(b);
/*  972 */         chainLightning.free();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void c(float paramFloat) {
/*  979 */     this.w.begin();
/*  980 */     for (byte b = 0; b < this.w.size; b++) {
/*      */       FlashParticle flashParticle;
/*      */       
/*  983 */       (flashParticle = ((FlashParticle[])this.w.items)[b]).time += paramFloat;
/*  984 */       if (flashParticle.time >= 0.17F) {
/*  985 */         this.w.removeIndex(b);
/*  986 */         this.F.free(flashParticle);
/*      */       } 
/*      */     } 
/*  989 */     this.w.end();
/*      */   }
/*      */ 
/*      */   
/*      */   private void a(Batch paramBatch, float paramFloat) {
/*  994 */     if (this.n.size != 0) {
/*  995 */       paramBatch.end();
/*  996 */       paramBatch.begin();
/*  997 */       paramBatch.setBlendFunction(770, 771);
/*  998 */       a(paramBatch, this.n, paramFloat);
/*  999 */       paramBatch.end();
/*      */       
/* 1001 */       paramBatch.setBlendFunction(770, 1);
/* 1002 */       paramBatch.begin();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void a(Batch paramBatch) {
/* 1008 */     paramBatch.setColor(Color.WHITE); byte b; int i;
/* 1009 */     for (b = 0, i = this.k.size; b < i; b++) {
/* 1010 */       ((ParticleEffect[])this.k.items)[b].draw(paramBatch);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void b(Batch paramBatch) {
/* 1016 */     paramBatch.setColor(Color.WHITE);
/*      */     
/* 1018 */     if (this.S._mapRendering.getDrawMode() == MapRenderingSystem.DrawMode.DETAILED) {
/* 1019 */       paramBatch.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*      */     }
/* 1021 */     for (byte b = 0; b < this.m.size; b++) {
/*      */       XpOrbParticle xpOrbParticle;
/* 1023 */       float f1 = PMath.getSquareDistanceBetweenPoints((xpOrbParticle = ((XpOrbParticle[])this.m.items)[b]).f, xpOrbParticle.g, xpOrbParticle.h, xpOrbParticle.i) * 0.00390625F;
/* 1024 */       float f2 = PMath.getSquareDistanceBetweenPoints(xpOrbParticle.f, xpOrbParticle.g, xpOrbParticle.b, xpOrbParticle.c) * 0.00390625F;
/*      */       
/* 1026 */       if ((f1 = StrictMath.min(f1, f2)) > 1.0F) f1 = 1.0F; 
/* 1027 */       f1 = xpOrbParticle.a * f1;
/* 1028 */       paramBatch.draw(XpOrbParticle.a(xpOrbParticle), xpOrbParticle.f - f1 * 0.5F, xpOrbParticle.g - f1 * 0.5F, f1, f1);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void c(Batch paramBatch) {
/* 1034 */     paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*      */     
/* 1036 */     if (Game.i.settingsManager.isFlyingCoinsEnabled()) {
/* 1037 */       this.p.begin();
/* 1038 */       for (byte b = 0; b < this.p.size; b++) {
/* 1039 */         CoinParticle coinParticle = ((CoinParticle[])this.p.items)[b];
/* 1040 */         float f = 1.0F;
/* 1041 */         if (1.5F - coinParticle.c < 0.3F) {
/* 1042 */           f = (1.5F - coinParticle.c) / 0.3F;
/*      */         }
/* 1044 */         paramBatch.setColor(1.0F, 1.0F, 1.0F, f);
/* 1045 */         paramBatch.draw(this.I, coinParticle.a.x - 34.0F, coinParticle.a.y - 12.0F, 24.0F, 24.0F);
/*      */         BitmapFontCache bitmapFontCache;
/* 1047 */         (bitmapFontCache = a(coinParticle.d, coinParticle.a.x, coinParticle.a.y + 7.0F)).draw(paramBatch, f);
/*      */       } 
/* 1049 */       this.p.end();
/* 1050 */       paramBatch.setColor(Color.WHITE);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void d(Batch paramBatch) {
/* 1056 */     paramBatch.setColor(Color.WHITE);
/* 1057 */     this.w.begin();
/* 1058 */     for (byte b = 0; b < this.w.size; b++) {
/* 1059 */       FlashParticle flashParticle = ((FlashParticle[])this.w.items)[b];
/* 1060 */       float f = (0.17F - flashParticle.time) / 0.17F;
/* 1061 */       R.set(flashParticle.color);
/* 1062 */       R.a = f;
/* 1063 */       f = R.toFloatBits();
/* 1064 */       for (byte b1 = 0; b1 < 4; b1++) {
/* 1065 */         flashParticle.vertices[b1 * 5 + 2] = f;
/*      */       }
/* 1067 */       paramBatch.draw(flashParticle.texture, flashParticle.vertices, 0, 20);
/*      */     } 
/* 1069 */     this.w.end();
/* 1070 */     paramBatch.setColor(Color.WHITE);
/*      */   }
/*      */   
/* 1073 */   private static float[] X = new float[20];
/*      */ 
/*      */   
/*      */   public final void drawDamageParticles(Batch paramBatch) {
/* 1077 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DAMAGE_PARTICLES_ENABLED) != 0.0D && this.q.size != 0) {
/* 1078 */       this.q.sort(A);
/* 1079 */       this.q.begin();
/* 1080 */       Texture texture = Game.i.assetManager.getBlankWhiteTextureRegion().getTexture();
/*      */       
/* 1082 */       for (byte b = 0; b < this.q.size; b++) {
/*      */         float f1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         DamageParticle damageParticle;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1094 */         if ((damageParticle = ((DamageParticle[])this.q.items)[b]).k < 0.07F) {
/* 1095 */           f1 = 1.85F;
/* 1096 */         } else if (damageParticle.k < 0.19F) {
/* 1097 */           f1 = 1.0F + 0.85F * (1.0F - (damageParticle.k - 0.07F) / 0.12F);
/*      */         } else {
/* 1099 */           f1 = 1.0F;
/*      */         } 
/*      */         
/* 1102 */         f1 *= damageParticle.g;
/*      */         
/* 1104 */         float f3 = damageParticle.k / damageParticle.i;
/*      */         
/* 1106 */         float f5 = 1.0F;
/* 1107 */         float f6 = 1.0F;
/* 1108 */         if (f3 >= 0.07F)
/*      */         {
/* 1110 */           if (f3 < 0.3F) {
/*      */             
/* 1112 */             f3 = 1.0F - (f3 - 0.07F) / 0.23F;
/* 1113 */             f6 = 0.82F + 0.18F * f3;
/* 1114 */           } else if (f3 < 0.7F) {
/* 1115 */             f6 = 0.82F;
/*      */           } else {
/*      */             
/* 1118 */             f5 = 1.0F - (f3 - 0.7F) / 0.3F;
/*      */           } 
/*      */         }
/* 1121 */         DamageParticle.a(damageParticle);
/* 1122 */         float[] arrayOfFloat = damageParticle.getFontCache().getVertices();
/* 1123 */         int i = damageParticle.getFontCache().getVertexCount(0);
/* 1124 */         if (X.length < i) {
/* 1125 */           X = new float[i];
/*      */         }
/* 1127 */         System.arraycopy(arrayOfFloat, 0, X, 0, i);
/*      */         
/* 1129 */         float f2 = R.set(damageParticle.getFontCache().getColor()).mul(f6, f6, f6, f5).toFloatBits();
/* 1130 */         for (byte b1 = 2; b1 < i; b1 += 5) {
/* 1131 */           X[b1] = f2;
/*      */         }
/* 1133 */         float f4 = 0.0F;
/* 1134 */         f2 = 0.0F; byte b2;
/* 1135 */         for (b2 = 0; b2 < i; b2 += 20) {
/* 1136 */           float f7 = X[b2] * f1;
/* 1137 */           float f8 = X[b2 + 1] * f1;
/* 1138 */           float f9 = X[b2 + 10] * f1;
/* 1139 */           float f10 = X[b2 + 11] * f1;
/*      */ 
/*      */           
/* 1142 */           f2 = Math.max(f4 = Math.max(f4, f9), f10);
/*      */           
/* 1144 */           X[b2 + 5] = f7; X[b2] = f7;
/* 1145 */           X[b2 + 16] = f8; X[b2 + 1] = f8;
/* 1146 */           X[b2 + 15] = f9; X[b2 + 10] = f9;
/* 1147 */           X[b2 + 11] = f10; X[b2 + 6] = f10;
/*      */         } 
/*      */         
/* 1150 */         for (b2 = 0; b2 < i; b2 += 5) {
/* 1151 */           X[b2] = X[b2] + damageParticle.a - f4 * 0.5F;
/* 1152 */           X[b2 + 1] = X[b2 + 1] + damageParticle.b + f2 * 0.5F;
/*      */         } 
/*      */         
/* 1155 */         paramBatch.draw(texture, X, 0, i);
/*      */       } 
/*      */       
/* 1158 */       this.q.end();
/* 1159 */       paramBatch.setColor(Color.WHITE);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void e(Batch paramBatch) {
/* 1164 */     for (byte b = 0; b < this.r.size; b++) {
/* 1165 */       ((ChainLightning[])this.r.items)[b].draw(paramBatch);
/*      */     }
/*      */   }
/*      */   
/*      */   private void b(Batch paramBatch, float paramFloat) {
/* 1170 */     if (this.o.size != 0 || this.l.size != 0) {
/* 1171 */       paramBatch.end();
/* 1172 */       paramBatch.begin();
/* 1173 */       paramBatch.setBlendFunction(770, 771);
/*      */       
/* 1175 */       a(paramBatch, this.o, paramFloat);
/*      */       
/* 1177 */       paramBatch.setColor(Color.WHITE); byte b; int i;
/* 1178 */       for (b = 0, i = this.l.size; b < i; b++) {
/* 1179 */         ((ParticleEffect[])this.l.items)[b].draw(paramBatch);
/*      */       }
/* 1181 */       paramBatch.setColor(Color.WHITE);
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void updateDraw(float paramFloat1, float paramFloat2) {
/* 1186 */     if (this.S.gameState != null && this.S.gameState.isGameOver()) {
/* 1187 */       paramFloat2 = paramFloat1;
/*      */     }
/*      */ 
/*      */     
/* 1191 */     for (byte b = 0; b < this.S.map.spawnedEnemies.size; b++) {
/*      */       Enemy.EnemyReference enemyReference; ObjectMap objectMap;
/* 1193 */       if ((enemyReference = ((Enemy.EnemyReference[])this.S.map.spawnedEnemies.items)[b]) != null && enemyReference.enemy != null && (
/*      */         
/* 1195 */         objectMap = enemyReference.enemy.attachedParticles) != null) {
/* 1196 */         for (ObjectMap.Entries<ObjectMap.Entry> entries = objectMap.iterator(); entries.hasNext();) {
/* 1197 */           ((ParticleEffectPool.PooledEffect)(entry = entries.next()).value).setPosition((enemyReference.enemy.getPosition()).x, (enemyReference.enemy.getPosition()).y);
/*      */         }
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1204 */     c(paramFloat1 * 0.5F, paramFloat2 * 0.5F);
/* 1205 */     d(paramFloat1 * 0.5F, paramFloat2 * 0.5F);
/* 1206 */     a(paramFloat2);
/* 1207 */     e(paramFloat1, paramFloat2);
/* 1208 */     b(paramFloat1, paramFloat2);
/* 1209 */     c(paramFloat2);
/* 1210 */     b(paramFloat2);
/*      */     
/* 1212 */     IntFloatMap.Keys keys = this.N.keys();
/* 1213 */     while (keys.hasNext) {
/* 1214 */       int i = keys.next();
/*      */       float f;
/* 1216 */       if ((f = this.N.get(i, 0.0F)) > 0.0F) {
/* 1217 */         f -= paramFloat2;
/* 1218 */         this.N.put(i, f);
/*      */       } 
/*      */     } 
/*      */     
/* 1222 */     if (this.S.gameState != null && this.S.gameState.updateNumber != this.M) {
/* 1223 */       this.M = this.S.gameState.updateNumber;
/* 1224 */       this.L.clear();
/*      */     } 
/*      */     
/* 1227 */     if (Game.i.debugManager.isEnabled()) Game.i.debugManager.registerValue("Particles count").append(this.k.size); 
/* 1228 */     if (Game.i.debugManager.isEnabled()) Game.i.debugManager.registerValue("Limited particles added/skipped").append(this.J).append("/").append(this.K); 
/*      */   }
/*      */   
/*      */   public final void draw(Batch paramBatch, float paramFloat1, float paramFloat2) {
/* 1232 */     a(paramBatch, paramFloat2);
/* 1233 */     a(paramBatch);
/* 1234 */     e(paramBatch);
/* 1235 */     b(paramBatch);
/* 1236 */     c(paramBatch);
/* 1237 */     d(paramBatch);
/* 1238 */     b(paramBatch, paramFloat2);
/*      */   }
/*      */   
/*      */   private void a(Batch paramBatch, DelayedRemovalArray<ShatterPolygon> paramDelayedRemovalArray, float paramFloat) {
/* 1242 */     if (paramDelayedRemovalArray.size != 0) {
/* 1243 */       paramDelayedRemovalArray.begin();
/* 1244 */       for (byte b = 0; b < paramDelayedRemovalArray.size; b++) {
/*      */         ShatterPolygon shatterPolygon;
/* 1246 */         (shatterPolygon = ((ShatterPolygon[])paramDelayedRemovalArray.items)[b]).draw(paramBatch, Q, paramFloat);
/*      */         
/* 1248 */         if (ShatterPolygon.f(shatterPolygon) > ShatterPolygon.g(shatterPolygon)) {
/* 1249 */           paramDelayedRemovalArray.removeIndex(b);
/* 1250 */           this.y.free(shatterPolygon);
/*      */         } 
/*      */       } 
/* 1253 */       paramDelayedRemovalArray.end();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public final void dispose() {
/* 1259 */     Game.i.debugManager.unregisterValue("Particles count");
/* 1260 */     Game.i.debugManager.unregisterValue("Limited particles added/skipped");
/* 1261 */     Game.i.debugManager.unregisterValue("Particles remove queue");
/*      */     
/* 1263 */     this.k.clear();
/* 1264 */     this.l.clear();
/* 1265 */     this.m.clear();
/* 1266 */     this.o.clear();
/* 1267 */     this.n.clear();
/* 1268 */     this.p.clear();
/* 1269 */     this.x.clear();
/* 1270 */     this.z.clear();
/* 1271 */     this.G.clear();
/* 1272 */     this.H = null;
/*      */     
/* 1274 */     this.I = null;
/*      */     
/* 1276 */     super.dispose();
/*      */   }
/*      */   private static class XpOrbParticle {
/*      */     private TextureRegion j; float a;
/*      */     float b;
/*      */     float c;
/*      */     float d;
/*      */     float e;
/*      */     float f;
/*      */     float g;
/*      */     float h;
/*      */     float i;
/*      */     
/*      */     private XpOrbParticle() {} }
/*      */   
/*      */   private static class CoinParticle { private CoinParticle() {}
/*      */     
/* 1293 */     Vector2 a = new Vector2();
/*      */     float b;
/*      */     float c;
/*      */     int d; }
/*      */   
/*      */   private static final class DamageParticle implements Pool.Poolable { float a;
/*      */     float b;
/*      */     float c;
/*      */     float d;
/*      */     long e;
/*      */     int f;
/* 1304 */     float g = 1.0F;
/*      */     
/*      */     final int h;
/*      */     
/*      */     final float i;
/*      */     
/*      */     final byte j;
/*      */     
/*      */     float k;
/*      */     
/*      */     float l;
/*      */     
/*      */     private BitmapFontCache m;
/*      */     
/*      */     private boolean n;
/*      */ 
/*      */     
/*      */     public DamageParticle(int param1Int) {
/* 1322 */       reset();
/*      */       
/* 1324 */       this.h = param1Int;
/* 1325 */       if (DamageType.Efficiency.isEspeciallyEffective(param1Int)) {
/* 1326 */         this.i = 1.5F;
/* 1327 */         this.j = 0; return;
/* 1328 */       }  if (DamageType.Efficiency.isCritical(param1Int)) {
/* 1329 */         this.i = 1.1624999F;
/* 1330 */         this.j = 1; return;
/* 1331 */       }  if (DamageType.Efficiency.isOverTime(param1Int)) {
/* 1332 */         this.i = 1.05F;
/* 1333 */         this.j = 2; return;
/* 1334 */       }  if (DamageType.Efficiency.isEffective(param1Int)) {
/* 1335 */         this.i = 0.90000004F;
/* 1336 */         this.j = 3; return;
/*      */       } 
/* 1338 */       this.i = 0.75F;
/* 1339 */       this.j = 4;
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean isPrepared() {
/* 1344 */       return this.n;
/*      */     }
/*      */     
/*      */     public final BitmapFontCache getFontCache() {
/* 1348 */       if (this.m == null) {
/* 1349 */         if (DamageType.Efficiency.isOverTime(this.h)) {
/* 1350 */           this.m = new BitmapFontCache(Game.i.assetManager.getDamageNumbersOverTimeFont());
/* 1351 */         } else if (DamageType.Efficiency.isEspeciallyEffective(this.h)) {
/* 1352 */           this.m = new BitmapFontCache(Game.i.assetManager.getDamageNumbersEspeciallyEffectiveFont());
/*      */         } else {
/* 1354 */           this.m = new BitmapFontCache(Game.i.assetManager.getDamageNumbersFont());
/*      */         } 
/*      */         
/* 1357 */         if (DamageType.Efficiency.isEspeciallyEffective(this.h)) {
/* 1358 */           this.m.setColor(MaterialColor.PINK.P300);
/* 1359 */         } else if (DamageType.Efficiency.isCritical(this.h)) {
/* 1360 */           this.m.setColor(MaterialColor.ORANGE.P200);
/* 1361 */         } else if (DamageType.Efficiency.isEffective(this.h)) {
/* 1362 */           this.m.setColor(MaterialColor.LIGHT_GREEN.P300);
/* 1363 */         } else if (DamageType.Efficiency.isWeak(this.h)) {
/* 1364 */           this.m.setColor(MaterialColor.GREY.P400);
/* 1365 */         } else if (DamageType.Efficiency.isOverTime(this.h)) {
/* 1366 */           this.m.setColor(MaterialColor.BLUE.P200);
/*      */         } else {
/* 1368 */           this.m.setColor(Color.WHITE);
/*      */         } 
/*      */         
/* 1371 */         this.m.setUseIntegerPositions(true);
/*      */       } 
/*      */       
/* 1374 */       return this.m;
/*      */     }
/*      */     
/*      */     private void a() {
/* 1378 */       if (!this.n) {
/*      */         BitmapFontCache bitmapFontCache;
/* 1380 */         (bitmapFontCache = getFontCache()).clear();
/* 1381 */         StringBuilder stringBuilder = StringFormatter.commaSeparatedNumber(this.e);
/* 1382 */         if (DamageType.Efficiency.isCritical(this.h)) {
/* 1383 */           stringBuilder.append('!');
/*      */         }
/* 1385 */         bitmapFontCache.addText((CharSequence)stringBuilder, 0.0F, 0.0F);
/*      */         
/* 1387 */         float f = 0.0F;
/* 1388 */         for (byte b = 0; b < (bitmapFontCache.getLayouts()).size; b++) {
/* 1389 */           f = Math.max(f, ((GlyphLayout)bitmapFontCache.getLayouts().get(b)).width);
/*      */         }
/* 1391 */         this.n = true;
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public final void reset() {
/* 1397 */       this.k = 0.0F;
/* 1398 */       this.l = 0.0F;
/* 1399 */       this.n = false;
/* 1400 */       this.e = 0L;
/* 1401 */       this.f = 0;
/* 1402 */       this.g = 1.0F;
/* 1403 */       this.c = 48.0F + FastRandom.getFloat() * 24.0F;
/* 1404 */       if (FastRandom.getFloat() < 0.5F) {
/* 1405 */         this.c = -this.c;
/*      */       }
/* 1407 */       this.d = (0.9F + FastRandom.getFloat() * 0.1F) * 48.0F;
/*      */     } }
/*      */   private static class FlashParticle { public Texture texture; public float[] vertices; public float time;
/*      */     public Color color;
/*      */     
/*      */     private FlashParticle() {
/* 1413 */       this.vertices = new float[20];
/*      */       
/* 1415 */       this.color = Color.WHITE.cpy();
/*      */     } }
/*      */   private static class ShatterPolygon implements Pool.Poolable { private Polygon a; private float[] b; private Vector2 c; private float[] d; private float e; private float f; private float g; private Texture h; private Color i; private float j; private Interpolation k;
/*      */     private ShatterPolygon() {
/* 1419 */       this.a = new Polygon();
/* 1420 */       this.b = new float[8];
/* 1421 */       this.c = new Vector2();
/* 1422 */       this.d = new float[8];
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1427 */       this.i = Color.WHITE.cpy();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void draw(Batch param1Batch, float[] param1ArrayOffloat, float param1Float) {
/* 1434 */       float f1, f2 = (f1 = this.k.apply(this.g / this.e)) - this.j;
/* 1435 */       this.j = f1;
/*      */       
/* 1437 */       f1 = 1.0F - this.g / this.e;
/* 1438 */       ParticleSystem.a().set(this.i);
/* 1439 */       (ParticleSystem.a()).a *= Interpolation.pow5Out.apply(f1);
/* 1440 */       float f3 = ParticleSystem.a().toFloatBits();
/*      */       
/* 1442 */       this.a.translate(this.c.x * f2, this.c.y * f2);
/* 1443 */       this.a.rotate(this.f * 270.0F * (1.5F - f1) * f2);
/*      */       
/* 1445 */       float[] arrayOfFloat = this.a.getTransformedVertices();
/* 1446 */       for (byte b = 0; b < 4; b++) {
/* 1447 */         param1ArrayOffloat[b * 5] = arrayOfFloat[b << 1];
/* 1448 */         param1ArrayOffloat[b * 5 + 1] = arrayOfFloat[(b << 1) + 1];
/* 1449 */         param1ArrayOffloat[b * 5 + 2] = f3;
/* 1450 */         param1ArrayOffloat[b * 5 + 3] = this.b[b << 1];
/* 1451 */         param1ArrayOffloat[b * 5 + 4] = this.b[(b << 1) + 1];
/*      */       } 
/*      */       
/* 1454 */       this.g += param1Float;
/* 1455 */       param1Batch.draw(this.h, param1ArrayOffloat, 0, 20);
/*      */     }
/*      */ 
/*      */     
/*      */     public void reset() {
/* 1460 */       this.j = 0.0F;
/* 1461 */       this.h = null;
/*      */     } }
/*      */ 
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\systems\ParticleSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */