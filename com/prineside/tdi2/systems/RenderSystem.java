/*     */ package com.prineside.tdi2.systems;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.OrthographicCamera;
/*     */ import com.badlogic.gdx.graphics.Pixmap;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.glutils.FrameBuffer;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.Matrix4;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystem;
/*     */ import com.prineside.tdi2.configs.GameRenderingOrder;
/*     */ import com.prineside.tdi2.events.game.GameStateTick;
/*     */ import com.prineside.tdi2.events.game.Render;
/*     */ import com.prineside.tdi2.managers.RenderingManager;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
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
/*     */ @NAGS
/*     */ public final class RenderSystem
/*     */   extends GameSystem
/*     */ {
/*  50 */   private static final TLog a = TLog.forClass(RenderSystem.class);
/*     */ 
/*     */   
/*  53 */   private final Array<Layer> b = new Array(true, 1, Layer.class);
/*     */   
/*     */   public float gameOverGameSpeed;
/*  56 */   public long gameOverTimestamp = -1L;
/*     */   
/*     */   public float gameOverInterpolatedTime;
/*     */   
/*     */   private OrthographicCamera c;
/*     */   
/*     */   private float d;
/*     */   
/*     */   public float currentInGameDeltaTime;
/*     */   public float currentInterpolatedDeltaTime;
/*     */   public float currentRealDeltaTime;
/*     */   private boolean e;
/*     */   private FrameBuffer f;
/*     */   
/*     */   public RenderSystem() {
/*  71 */     this.c = new OrthographicCamera(Game.i.uiManager.getScreenWidth(), Game.i.uiManager.getScreenHeight());
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setup() {
/*  76 */     this.S.events.getListeners(GameStateTick.class).add(paramGameStateTick -> this.d = 0.0F);
/*     */     
/*  78 */     this.S._render.addLayer((new Layer(GameRenderingOrder.EFFECTS_FBO_START, false, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> {
/*     */             this.e = (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.POSTPROCESSING) != 0.0D);
/*     */ 
/*     */             
/*     */             double d = Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.PP_EFFECTS_SCALE);
/*     */             
/*  84 */             int i = (this.e && Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.PP_CLEAN_DETAILED_MODE) != 0.0D) ? 1 : 0;
/*  85 */             if (i = (this.e && (i || d < 1.0D)) ? 1 : 0) {
/*     */               try {
/*     */                 d = MathUtils.clamp(d, 0.5D, 1.0D);
/*     */                 
/*     */                 i = Game.i.uiManager.getScreenWidth();
/*     */                 
/*     */                 int j = Game.i.uiManager.getScreenHeight();
/*     */                 
/*     */                 i = MathUtils.round((float)d * i);
/*     */                 
/*     */                 if ((j = MathUtils.round((float)d * j)) != 0 && (this.f == null || this.f.getWidth() != i)) {
/*     */                   a.i("recreating effects FBO with size " + i + "x" + j, new Object[0]);
/*     */                   
/*     */                   if (this.f != null) {
/*     */                     this.f.dispose();
/*     */                     this.f = null;
/*     */                   } 
/*     */                   this.f = new FrameBuffer(Pixmap.Format.RGB888, i, j, false);
/*     */                 } 
/*     */                 if (this.f != null) {
/*     */                   paramBatch.flush();
/*     */                   Game.i.renderingManager.startFBO(this.f, "RenderSystemEffects");
/*     */                   Gdx.gl.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
/*     */                   Gdx.gl.glClear(16640);
/*     */                 } 
/*     */                 return;
/* 111 */               } catch (Exception exception) {
/*     */                 throw new IllegalStateException("failed to recreate / begin drawing to effects FBO", exception);
/*     */               } 
/*     */             }
/*     */             
/*     */             if (this.f != null) {
/*     */               this.f.dispose();
/*     */               
/*     */               this.f = null;
/*     */             } 
/* 121 */           })).setName("Render-effectsFboStart"));
/*     */     
/* 123 */     this.S._render.addLayer((new Layer(GameRenderingOrder.EFFECTS_FBO_END, false, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> {
/*     */             if (this.f != null) {
/*     */               paramBatch.flush();
/*     */               
/*     */               Game.i.renderingManager.endFBO("RenderSystemEffects");
/*     */               
/*     */               Matrix4 matrix4;
/*     */               
/*     */               (matrix4 = paramBatch.getProjectionMatrix()).setToOrtho2D(0.0F, 0.0F, Game.i.uiManager.getScreenWidth(), Game.i.uiManager.getScreenHeight());
/*     */               
/*     */               paramBatch.setProjectionMatrix(matrix4);
/*     */               
/*     */               paramBatch.setBlendFunction(770, 1);
/*     */               
/*     */               if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.PP_CLEAN_DETAILED_MODE) != 0.0D && this.S._mapRendering.getDrawMode() == MapRenderingSystem.DrawMode.DETAILED) {
/*     */                 paramBatch.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*     */               } else {
/*     */                 paramBatch.setColor(Color.WHITE);
/*     */               } 
/*     */               
/*     */               Texture texture;
/*     */               (texture = (Texture)this.f.getColorBufferTexture()).setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
/*     */               paramBatch.draw(texture, 0.0F, 0.0F, Game.i.uiManager.getScreenWidth(), Game.i.uiManager.getScreenHeight(), 0, 0, this.f.getWidth(), this.f.getHeight(), false, true);
/*     */               paramBatch.flush();
/*     */               paramBatch.setColor(Color.WHITE);
/*     */               paramBatch.setProjectionMatrix(this.c.combined);
/*     */             } 
/* 150 */           })).setName("Render-effectsFboEnd"));
/*     */     
/* 152 */     this.S.events.getListeners(Render.class).addWithPriority(this::calculateDeltaTimes, 2000).setDescription("RenderSystem - calculates and updates frame time deltas, sets the interpolated delta time");
/* 153 */     this.S.events.getListeners(Render.class).addWithPriority(paramRender -> drawLayers((Batch)Game.i.renderingManager.batch), -2000).setDescription("RenderSystem - draws layers");
/*     */   }
/*     */   
/*     */   public final OrthographicCamera getCamera() {
/* 157 */     return this.c;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void dispose() {
/* 162 */     if (this.f != null) {
/* 163 */       this.f.dispose();
/* 164 */       this.f = null;
/*     */     } 
/*     */   }
/*     */   @Null
/*     */   public final Layer getLayer(int paramInt) {
/* 169 */     for (byte b = 0; b < this.b.size; ) {
/*     */       Layer layer;
/* 171 */       if (Layer.a(layer = ((Layer[])this.b.items)[b]) == paramInt)
/* 172 */         return layer; 
/* 173 */       if (Layer.a(layer) <= paramInt) {
/*     */         b++;
/*     */       }
/*     */     } 
/* 177 */     return null;
/*     */   }
/*     */   @Null
/*     */   public final Layer removeLayerByZIndex(int paramInt) {
/* 181 */     for (byte b = 0; b < this.b.size; ) {
/*     */       Layer layer;
/* 183 */       if (Layer.a(layer = ((Layer[])this.b.items)[b]) == paramInt)
/* 184 */         return (Layer)this.b.removeIndex(b); 
/* 185 */       if (Layer.a(layer) <= paramInt) {
/*     */         b++;
/*     */       }
/*     */     } 
/* 189 */     return null;
/*     */   }
/*     */   @Null
/*     */   public final Layer removeLayer(Layer paramLayer) {
/* 193 */     for (byte b = 0; b < this.b.size; b++) {
/* 194 */       Layer layer = ((Layer[])this.b.items)[b];
/* 195 */       if (paramLayer == layer) {
/* 196 */         return (Layer)this.b.removeIndex(b);
/*     */       }
/*     */     } 
/* 199 */     return null;
/*     */   }
/*     */   
/*     */   public final void addLayer(Layer paramLayer) {
/* 203 */     removeLayerByZIndex(Layer.a(paramLayer));
/* 204 */     this.b.add(paramLayer);
/* 205 */     a();
/*     */   }
/*     */   
/*     */   private void a() {
/* 209 */     this.b.sort((paramLayer1, paramLayer2) -> Integer.compare(Layer.a(paramLayer1), Layer.a(paramLayer2)));
/*     */   }
/*     */   
/*     */   public final void calculateDeltaTimes(Render paramRender) {
/* 213 */     float f1 = paramRender.getInGameDeltaTime();
/* 214 */     float f2 = paramRender.getRealDeltaTime();
/*     */     
/* 216 */     if (f1 < 0.0F || Float.isInfinite(f1) || Float.isNaN(f1)) {
/*     */       
/* 218 */       f1 = 0.0F;
/* 219 */     } else if (f1 > 10.0F) {
/* 220 */       f1 = 10.0F;
/*     */     } 
/*     */     
/* 223 */     if (f2 < 0.0F) {
/* 224 */       f2 = 0.0F;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 229 */     float f3 = this.d;
/* 230 */     if (this.S.gameValue != null && f3 > this.S.gameValue.getTickRateDeltaTime()) f3 = this.S.gameValue.getTickRateDeltaTime(); 
/* 231 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.GRAPHICS_INTERPOLATION_ENABLED) == 0.0D) {
/* 232 */       f3 = 0.0F;
/*     */     }
/*     */ 
/*     */     
/* 236 */     if (this.S.gameState != null && this.S.gameState.isGameOver()) {
/* 237 */       if (this.gameOverTimestamp == -1L) {
/* 238 */         this.gameOverTimestamp = Game.getRealTickCount();
/*     */       }
/*     */       
/* 241 */       long l = Game.getRealTickCount() - this.gameOverTimestamp;
/*     */       
/* 243 */       if ((f3 = 1.0F - (float)l / 2500000.0F) < 0.0F) {
/* 244 */         f3 = 0.0F;
/*     */       }
/*     */ 
/*     */       
/* 248 */       f1 = f2 / this.S.gameValue.getTickRateDeltaTime();
/*     */       
/* 250 */       f1 = (f1 = f2 * f1 * this.gameOverGameSpeed) * f3;
/* 251 */       this.gameOverInterpolatedTime += f1;
/* 252 */       f2 *= f3;
/* 253 */       f3 = this.gameOverInterpolatedTime;
/*     */     } 
/* 255 */     if (f3 < 0.0F) f3 = 0.0F; 
/* 256 */     if (f3 > 1.0F) f3 = 1.0F;
/*     */     
/* 258 */     this.currentInGameDeltaTime = f1;
/* 259 */     this.currentInterpolatedDeltaTime = f3;
/* 260 */     this.currentRealDeltaTime = f2;
/* 261 */     this.d += f1;
/*     */     
/* 263 */     paramRender.setInGameDeltaTime(f1);
/* 264 */     paramRender.setRealDeltaTime(f2);
/* 265 */     paramRender.setInterpolatedTime(f3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void drawLayers(Batch paramBatch) {
/* 271 */     for (byte b = 0; b < this.b.size; b++) {
/* 272 */       Layer layer = ((Layer[])this.b.items)[b];
/*     */       
/* 274 */       long l = Game.getRealTickCount();
/* 275 */       prepareBatch(paramBatch, layer.isAdditive());
/* 276 */       layer.renderer.render(paramBatch, this.currentRealDeltaTime, this.currentInGameDeltaTime, this.currentInterpolatedDeltaTime);
/* 277 */       Game.i.debugManager.registerFrameJob(layer.name, Game.getRealTickCount() - l);
/*     */     } 
/* 279 */     paramBatch.flush();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void prepareBatch(Batch paramBatch, boolean paramBoolean) {
/* 286 */     RenderingManager.prepareBatch(paramBatch, paramBoolean);
/* 287 */     paramBatch.setProjectionMatrix(this.c.combined);
/* 288 */     paramBatch.setTransformMatrix(new Matrix4());
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean profileUpdate() {
/* 293 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean affectsGameState() {
/* 298 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String getSystemName() {
/* 303 */     return "Render";
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class Layer
/*     */   {
/*     */     private final int a;
/*     */     private boolean b;
/*     */     public RenderSystem.LayerRenderer renderer;
/* 312 */     public String name = "unnamed";
/*     */     
/*     */     public Layer(int param1Int, boolean param1Boolean, RenderSystem.LayerRenderer param1LayerRenderer) {
/* 315 */       this.a = param1Int;
/* 316 */       this.b = param1Boolean;
/* 317 */       setRenderer(param1LayerRenderer);
/*     */     }
/*     */     
/*     */     public final boolean isAdditive() {
/* 321 */       return this.b;
/*     */     }
/*     */     
/*     */     public final Layer setAdditive(boolean param1Boolean) {
/* 325 */       this.b = param1Boolean;
/* 326 */       return this;
/*     */     }
/*     */     
/*     */     public final String getName() {
/* 330 */       return this.name;
/*     */     }
/*     */     
/*     */     public final Layer setName(String param1String) {
/* 334 */       Preconditions.checkNotNull(param1String);
/* 335 */       this.name = param1String;
/* 336 */       return this;
/*     */     }
/*     */     
/*     */     public final int getZ() {
/* 340 */       return this.a;
/*     */     }
/*     */     
/*     */     public final RenderSystem.LayerRenderer getRenderer() {
/* 344 */       return this.renderer;
/*     */     }
/*     */     
/*     */     public final Layer setRenderer(RenderSystem.LayerRenderer param1LayerRenderer) {
/* 348 */       Preconditions.checkNotNull(param1LayerRenderer);
/* 349 */       this.renderer = param1LayerRenderer;
/* 350 */       return this;
/*     */     }
/*     */   }
/*     */   
/*     */   @FunctionalInterface
/*     */   public static interface LayerRenderer {
/*     */     void render(Batch param1Batch, float param1Float1, float param1Float2, float param1Float3);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\systems\RenderSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */