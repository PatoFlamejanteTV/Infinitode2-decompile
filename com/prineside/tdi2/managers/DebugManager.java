/*      */ package com.prineside.tdi2.managers;
/*      */ 
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.Net;
/*      */ import com.badlogic.gdx.graphics.Camera;
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.OrthographicCamera;
/*      */ import com.badlogic.gdx.graphics.g2d.Batch;
/*      */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*      */ import com.badlogic.gdx.graphics.g2d.SpriteBatch;
/*      */ import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
/*      */ import com.badlogic.gdx.graphics.profiling.GLProfiler;
/*      */ import com.badlogic.gdx.net.HttpParametersUtils;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.Json;
/*      */ import com.badlogic.gdx.utils.JsonWriter;
/*      */ import com.badlogic.gdx.utils.LongArray;
/*      */ import com.badlogic.gdx.utils.ObjectIntMap;
/*      */ import com.badlogic.gdx.utils.ObjectMap;
/*      */ import com.badlogic.gdx.utils.StringBuilder;
/*      */ import com.badlogic.gdx.utils.TimeUtils;
/*      */ import com.prineside.tdi2.Config;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.Manager;
/*      */ import com.prineside.tdi2.ResourcePack;
/*      */ import com.prineside.tdi2.enums.StaticSoundType;
/*      */ import com.prineside.tdi2.events.global.GameLoad;
/*      */ import com.prineside.tdi2.events.global.ScreenResize;
/*      */ import com.prineside.tdi2.scene2d.Actor;
/*      */ import com.prineside.tdi2.scene2d.Touchable;
/*      */ import com.prineside.tdi2.scene2d.ui.Table;
/*      */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*      */ import com.prineside.tdi2.ui.actors.Label;
/*      */ import com.prineside.tdi2.ui.shared.VisibleDisplayFrameDebugFeature;
/*      */ import com.prineside.tdi2.utils.FastRandom;
/*      */ import com.prineside.tdi2.utils.MaterialColor;
/*      */ import com.prineside.tdi2.utils.MovingAverageInt;
/*      */ import com.prineside.tdi2.utils.ObjectPair;
/*      */ import com.prineside.tdi2.utils.ObjectSupplier;
/*      */ import com.prineside.tdi2.utils.REGS;
/*      */ import com.prineside.tdi2.utils.StringFormatter;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ import java.io.StringWriter;
/*      */ import java.nio.charset.Charset;
/*      */ import java.util.Arrays;
/*      */ import java.util.Enumeration;
/*      */ import java.util.HashMap;
/*      */ import java.util.Properties;
/*      */ 
/*      */ @REGS(serializer = DebugManager.Serializer.class)
/*      */ public class DebugManager
/*      */   extends Manager.ManagerAdapter {
/*   53 */   private static final TLog a = TLog.forClass(DebugManager.class); private UiManager.UiLayer b;
/*      */   
/*      */   public static class Serializer extends SingletonSerializer<DebugManager> { public DebugManager read() {
/*   56 */       return Game.i.debugManager;
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   66 */   public static final Color[] RANDOM_COLORS = new Color[] { MaterialColor.RED.P500, MaterialColor.YELLOW.P500, MaterialColor.BLUE.P500, MaterialColor.LIGHT_GREEN.P500, MaterialColor.BLUE_GREY.P500, MaterialColor.ORANGE.P500, MaterialColor.BROWN.P500, MaterialColor.DEEP_ORANGE.P500, MaterialColor.CYAN.P500, MaterialColor.DEEP_PURPLE.P500, MaterialColor.GREEN.P500, MaterialColor.INDIGO.P500, MaterialColor.GREY.P500, MaterialColor.PURPLE.P500, MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIME.P500, MaterialColor.PINK.P500, MaterialColor.TEAL.P500, MaterialColor.AMBER.P500 };
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean c = false;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean d = false;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Label e;
/*      */ 
/*      */ 
/*      */   
/*      */   private long f;
/*      */ 
/*      */ 
/*      */   
/*      */   private long g;
/*      */ 
/*      */ 
/*      */   
/*   93 */   private StringBuilder h = new StringBuilder();
/*   94 */   private final Array<String> i = new Array(false, 1, String.class);
/*      */   private SettingsManager.SettingsManagerListener j;
/*   96 */   private final ObjectMap<String, StringBuilder> k = new ObjectMap();
/*   97 */   private final ObjectMap<String, long[]> l = new ObjectMap();
/*   98 */   private final ObjectIntMap<String> m = new ObjectIntMap();
/*   99 */   private final ObjectIntMap<String> n = new ObjectIntMap();
/*  100 */   private final LongArray o = new LongArray(false, 30);
/*      */   private int p;
/*  102 */   private final MovingAverageInt q = new MovingAverageInt(60);
/*      */   private float r;
/*  104 */   private int s = 1800;
/*  105 */   private int t = 400;
/*      */   
/*  107 */   private final long[] u = new long[240];
/*  108 */   private final int[] v = new int[720];
/*  109 */   private int w = 0;
/*  110 */   private int x = 1;
/*      */   
/*      */   private long y;
/*  113 */   private final long[] z = new long[60];
/*  114 */   private int A = 0;
/*      */   
/*  116 */   private float B = 16.0F;
/*      */   
/*      */   public final GLProfiler glProfiler;
/*      */   private long C;
/*  120 */   private static final int D = MusicManager.SpectrumConfig.DEFAULT.getSpectrumSize();
/*      */   
/*  122 */   private final float[] E = new float[D];
/*  123 */   private final float[] F = new float[D];
/*  124 */   private final float[] G = new float[D];
/*  125 */   private final float[] H = new float[D];
/*      */   
/*      */   private String I;
/*      */   
/*      */   private OrthographicCamera J;
/*  130 */   private final int[] K = new int[StaticSoundType.values.length];
/*      */   
/*      */   public DebugManager() {
/*  133 */     this.glProfiler = new GLProfiler(Gdx.graphics);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  139 */     this.J = new OrthographicCamera();
/*  140 */     this.J.setToOrtho(false, Game.i.uiManager.getScreenWidth() * 1.5F, Game.i.uiManager.getScreenHeight() * 1.5F);
/*      */   }
/*      */   
/*      */   private void b() {
/*      */     try {
/*  145 */       this.I = Config.PACKAGE.substring(Config.PACKAGE.length() - 4) + ".207" + "." + (Game.i.actionResolver.isAppModified() ? "M" : "V") + (Config.isModdingMode() ? ("(" + Config.getModId() + ")") : "");
/*  146 */       if (Game.i.authManager != null) {
/*  147 */         this.I += "." + Game.i.authManager.getPlayerId();
/*      */       }
/*  149 */     } catch (Exception exception) {
/*  150 */       this.I = "ERR";
/*      */     } 
/*  152 */     this.J.setToOrtho(false, Game.i.uiManager.getScreenWidth() * 1.5F, Game.i.uiManager.getScreenHeight() * 1.5F);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setup() {
/*  157 */     if (Config.isHeadless())
/*      */       return; 
/*  159 */     Game.i.authManager.addListener(new AuthManager.AuthManagerListener.AuthManagerListenerAdapter(this)
/*      */         {
/*      */           public void signInStatusUpdated() {
/*  162 */             DebugManager.a(this.a);
/*      */           }
/*      */         });
/*      */     
/*  166 */     Game.EVENTS.getListeners(GameLoad.class).add(paramGameLoad -> {
/*      */           b();
/*      */           
/*      */           try {
/*      */             Net.HttpRequest httpRequest;
/*      */             (httpRequest = new Net.HttpRequest("POST")).setUrl(Config.GAME_START_LOG_URL);
/*      */             HashMap<Object, Object> hashMap;
/*      */             (hashMap = new HashMap<>()).put("os", (Gdx.app == null) ? "unknown" : Gdx.app.getType().name());
/*      */             if (Game.isLoaded()) {
/*      */               String str;
/*      */               if ((str = Game.i.authManager.getPlayerIdCached()) == null) {
/*      */                 str = "G-0000-0000-000000";
/*      */               }
/*      */               hashMap.put("playerid", str);
/*      */               if (Game.i.authManager.getSessionId() != null) {
/*      */                 hashMap.put("sessionid", Game.i.authManager.getSessionId());
/*      */               }
/*      */             } else {
/*      */               hashMap.put("playerid", "G-0000-0000-000000");
/*      */             } 
/*      */             ObjectMap objectMap = Game.i.actionResolver.getDeviceInfo();
/*      */             Json json = new Json(JsonWriter.OutputType.json);
/*      */             StringWriter stringWriter = new StringWriter();
/*      */             json.setWriter(stringWriter);
/*      */             json.writeObjectStart();
/*      */             if (Game.i.localeManager != null) {
/*      */               try {
/*      */                 json.writeValue("g.locale", Charset.defaultCharset() + "," + Game.i.localeManager.getLocale() + "," + Game.i.localeManager.i18n.getLocale());
/*  194 */               } catch (Exception exception) {}
/*      */             }
/*      */             
/*      */             ObjectMap.Entries<ObjectMap.Entry> entries = objectMap.iterator();
/*      */             while (entries.hasNext()) {
/*      */               ObjectMap.Entry entry = entries.next();
/*      */               json.writeValue((String)entry.key, entry.value);
/*      */             } 
/*      */             json.writeObjectStart("s.properties");
/*      */             try {
/*      */               Properties properties;
/*      */               Enumeration<?> enumeration = (properties = System.getProperties()).propertyNames();
/*      */               while (enumeration.hasMoreElements()) {
/*      */                 Object object1 = enumeration.nextElement();
/*      */                 Object object2;
/*      */                 if ((object2 = properties.get(object1)) != null) {
/*      */                   json.writeValue(object1.toString(), ((String)object2).trim());
/*      */                 }
/*      */               } 
/*  213 */             } catch (Exception exception) {
/*      */               (entries = null).printStackTrace();
/*      */             } 
/*      */             
/*      */             json.writeObjectEnd();
/*      */             json.writeObjectStart("s.runtime");
/*      */             try {
/*      */               Runtime runtime = Runtime.getRuntime();
/*      */               json.writeValue("proc_av", Integer.valueOf(runtime.availableProcessors()));
/*      */               json.writeValue("mem_free", Long.valueOf(runtime.freeMemory()));
/*      */               json.writeValue("mem_max", Long.valueOf(runtime.maxMemory()));
/*      */               json.writeValue("mem_total", Long.valueOf(runtime.totalMemory()));
/*  225 */             } catch (Exception exception) {
/*      */               (entries = null).printStackTrace();
/*      */             } 
/*      */             
/*      */             json.writeObjectEnd();
/*      */             json.writeObjectStart("s.graphics");
/*      */             try {
/*      */               json.writeValue("type", Gdx.graphics.getGLVersion().getType().toString());
/*      */               json.writeValue("version", Gdx.graphics.getGLVersion().getMajorVersion() + "." + Gdx.graphics.getGLVersion().getMinorVersion() + "." + Gdx.graphics.getGLVersion().getReleaseVersion());
/*      */               json.writeValue("renderer", Gdx.graphics.getGLVersion().getRendererString());
/*      */               json.writeValue("vendor", Gdx.graphics.getGLVersion().getVendorString());
/*      */               json.writeValue("bb_size", Gdx.graphics.getBackBufferWidth() + "x" + Gdx.graphics.getBackBufferHeight());
/*      */               json.writeValue("density", Float.valueOf(Gdx.graphics.getDensity()));
/*      */               json.writeValue("max_txt_size", Integer.valueOf(Config.getMaxTextureSize()));
/*  239 */             } catch (Exception exception) {
/*      */               (entries = null).printStackTrace();
/*      */             } 
/*      */             
/*      */             json.writeObjectEnd();
/*      */             
/*      */             json.writeObjectEnd();
/*      */             hashMap.put("device", stringWriter.toString());
/*      */             try {
/*      */               httpRequest.setContent(HttpParametersUtils.convertHttpParameters(hashMap));
/*  249 */             } catch (Exception exception) {
/*      */               for (String str : hashMap.keySet()) {
/*      */                 a.i(str + ": " + (String)hashMap.get(str), new Object[0]);
/*      */               }
/*      */               throw exception;
/*      */             } 
/*      */             Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener(this)
/*      */                 {
/*      */                   public void handleHttpResponse(Net.HttpResponse param1HttpResponse) {
/*      */                     try {
/*  259 */                       String str = param1HttpResponse.getResultAsString();
/*  260 */                       DebugManager.a().d("logGameStart: %s", new Object[] { str }); return;
/*  261 */                     } catch (Exception exception) {
/*  262 */                       DebugManager.a().w("logGameStart", new Object[] { exception });
/*      */                       return;
/*      */                     } 
/*      */                   }
/*      */                   public void failed(Throwable param1Throwable) {
/*  267 */                     DebugManager.a().w("logGameStart failed", new Object[] { param1Throwable });
/*      */                   }
/*      */                   
/*      */                   public void cancelled() {
/*  271 */                     DebugManager.a().d("logGameStart: cancelled", new Object[0]); }
/*      */                 });
/*      */             return;
/*  274 */           } catch (Exception exception) {
/*      */             a.e("failed to log game start", new Object[] { exception }); return;
/*      */           } 
/*      */         });
/*  278 */     Game.EVENTS.getListeners(ScreenResize.class).add(paramScreenResize -> b());
/*      */     
/*  280 */     this.b = Game.i.uiManager.addLayer(UiManager.MainUiLayer.OVERLAY, 19001, "DebugManager main");
/*      */     
/*      */     Table table;
/*      */     
/*  284 */     (table = this.b.getTable()).setTouchable(Touchable.disabled);
/*  285 */     table.setDebug(false);
/*      */     
/*      */     Label.LabelStyle labelStyle;
/*  288 */     (labelStyle = new Label.LabelStyle()).font = (BitmapFont)Game.i.assetManager.getFont(16);
/*  289 */     labelStyle.background = Game.i.assetManager.getDrawable("blank").tint(new Color(0.0F, 0.0F, 0.0F, 0.28F));
/*      */     
/*  291 */     this.e = new Label("Debug", labelStyle);
/*  292 */     this.e.setAlignment(16);
/*  293 */     table.add((Actor)this.e).pad(5.0F).expand().top().right();
/*      */     
/*  295 */     this.j = new SettingsManager.SettingsManagerListener.SettingsManagerListenerAdapter(this)
/*      */       {
/*      */         public void settingsChanged() {
/*  298 */           DebugManager.b(this.a);
/*      */         }
/*      */ 
/*      */         
/*      */         public void customValueChanged(SettingsManager.CustomValueType param1CustomValueType, double param1Double) {
/*  303 */           if (param1CustomValueType == SettingsManager.CustomValueType.DBG_SIMULATE_VISIBLE_DISPLAY_FRAME) {
/*  304 */             DebugManager.c(this.a);
/*      */           }
/*      */         }
/*      */       };
/*  308 */     Game.i.settingsManager.addListener(this.j);
/*      */     
/*  310 */     d();
/*  311 */     c();
/*      */   }
/*      */   
/*      */   private static void c() {
/*  315 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_SIMULATE_VISIBLE_DISPLAY_FRAME) == 0.0D) {
/*  316 */       VisibleDisplayFrameDebugFeature.i().hide(); return;
/*      */     } 
/*  318 */     VisibleDisplayFrameDebugFeature.i().show();
/*      */   }
/*      */ 
/*      */   
/*      */   private void d() {
/*  323 */     this.c = Game.i.settingsManager.isInDebugMode();
/*  324 */     this.d = Game.i.settingsManager.isInDebugDetailedMode();
/*      */     
/*  326 */     if (this.c) {
/*      */       
/*  328 */       this.b.getTable().setVisible(true);
/*  329 */       if (this.d) {
/*  330 */         this.glProfiler.enable(); return;
/*      */       } 
/*  332 */       this.glProfiler.disable();
/*      */       return;
/*      */     } 
/*  335 */     this.b.getTable().setVisible(false);
/*  336 */     this.glProfiler.disable();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuilder registerValue(String paramString) {
/*  345 */     if (!this.c) return null;
/*      */     
/*  347 */     if (!this.k.containsKey(paramString)) {
/*  348 */       this.k.put(paramString, new StringBuilder());
/*      */     }
/*      */     
/*      */     StringBuilder stringBuilder;
/*  352 */     (stringBuilder = (StringBuilder)this.k.get(paramString)).setLength(0);
/*      */     
/*  354 */     return stringBuilder;
/*      */   }
/*      */   
/*      */   public boolean isEnabled() {
/*  358 */     return this.c;
/*      */   }
/*      */   
/*      */   public void unregisterValue(String paramString) {
/*  362 */     this.k.remove(paramString);
/*      */   }
/*      */   
/*      */   public void registerFrameJob(String paramString, long paramLong) {
/*  366 */     if (!this.c)
/*      */       return; 
/*  368 */     if (!this.l.containsKey(paramString)) {
/*  369 */       long[] arrayOfLong = new long[240];
/*  370 */       this.l.put(paramString, arrayOfLong);
/*      */     } 
/*  372 */     ((long[])this.l.get(paramString))[this.w] = ((long[])this.l.get(paramString))[this.w] + paramLong;
/*      */   }
/*      */   
/*      */   public void registerFrameDrawTimeAndMemory(long paramLong) {
/*  376 */     if (!this.c)
/*      */       return; 
/*  378 */     long l = TimeUtils.nanoTime();
/*  379 */     this.z[this.A] = l - this.y;
/*  380 */     this.y = l;
/*      */     
/*  382 */     if (this.d) {
/*      */       Runtime runtime;
/*  384 */       int j = (int)((runtime = Runtime.getRuntime()).freeMemory() / 1024L);
/*  385 */       int k = (int)(runtime.totalMemory() / 1024L);
/*  386 */       int i = (int)(((runtime.maxMemory() <= 0L) ? 536870912L : runtime.maxMemory()) / 1024L);
/*      */       
/*  388 */       this.u[this.w] = paramLong;
/*      */       
/*  390 */       this.v[this.w * 3] = j;
/*  391 */       this.v[this.w * 3 + 1] = k;
/*      */       
/*  393 */       this.v[this.w * 3 + 2] = i;
/*  394 */       if (this.x < i) {
/*  395 */         this.x = i;
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void preRender(float paramFloat) {
/*  404 */     this.C = Game.getRealTickCount();
/*      */   }
/*      */   
/*      */   public void registerGameStateUpdate() {
/*  408 */     if (!Config.isHeadless() && Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_SHOW_FPS) != 0.0D) {
/*  409 */       this.o.add(Game.getTimestampMillis());
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void postRender(float paramFloat) {
/*  415 */     if (Config.isHeadless())
/*      */       return; 
/*  417 */     if (this.b == null)
/*      */       return; 
/*  419 */     Game.getRealTickCount();
/*      */     
/*  421 */     registerFrameDrawTimeAndMemory(Game.getRealTickCount() - this.C);
/*      */     
/*  423 */     SpriteBatch spriteBatch = Game.i.renderingManager.batch;
/*  424 */     ShapeRenderer shapeRenderer = Game.i.renderingManager.shapeRenderer;
/*      */     
/*  426 */     Camera camera = this.b.getTable().getStage().getCamera();
/*      */     
/*  428 */     ResourcePack.ResourcePackBitmapFont resourcePackBitmapFont = Game.i.assetManager.getFont(24);
/*      */     
/*  430 */     int i = Game.i.uiManager.getScreenSafeMargin();
/*      */ 
/*      */     
/*  433 */     if (this.I == null) b(); 
/*  434 */     spriteBatch.setProjectionMatrix(this.J.combined);
/*  435 */     spriteBatch.begin();
/*  436 */     Gdx.gl.glEnable(3042);
/*  437 */     Gdx.gl.glBlendFunc(770, 771);
/*  438 */     Game.i.assetManager.getDebugFont(false).setColor(0.0F, 1.0F, 0.0F, 0.03F);
/*  439 */     Game.i.assetManager.getDebugFont(false).draw((Batch)spriteBatch, this.I, 1.0F, 17.0F);
/*  440 */     spriteBatch.end();
/*  441 */     Game.i.assetManager.getDebugFont(false).setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*      */     
/*  443 */     spriteBatch.setProjectionMatrix(camera.combined);
/*  444 */     shapeRenderer.setProjectionMatrix(camera.combined);
/*      */ 
/*      */     
/*  447 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_SHOW_FPS) != 0.0D) {
/*  448 */       this.r += paramFloat;
/*  449 */       if (this.r > 0.2F) {
/*  450 */         this.p = 0;
/*  451 */         long l1 = Game.getTimestampMillis();
/*  452 */         for (int m = this.o.size - 1; m >= 0; m--) {
/*  453 */           long l2 = this.o.items[m];
/*  454 */           if (l1 - l2 > 1000L) {
/*  455 */             this.o.removeIndex(m);
/*      */           } else {
/*  457 */             this.p++;
/*      */           } 
/*      */         } 
/*  460 */         this.r = 0.0F;
/*      */       } 
/*      */       
/*  463 */       spriteBatch.begin();
/*      */       try {
/*  465 */         this.h.setLength(0);
/*  466 */         this.q.push(this.p);
/*  467 */         this.h.append(Gdx.graphics.getFramesPerSecond()).append(" FPS / ").append(this.p).append(" (").append(this.q.getAverage()).append(") UPS");
/*      */         
/*  469 */         resourcePackBitmapFont.setColor(0.0F, 0.0F, 0.0F, 0.56F);
/*  470 */         resourcePackBitmapFont.draw((Batch)spriteBatch, (CharSequence)this.h, (i + 17), (Game.i.settingsManager.getScaledViewportHeight() - 17));
/*  471 */         resourcePackBitmapFont.setColor(1.0F, 1.0F, 1.0F, 1.0F);
/*  472 */         resourcePackBitmapFont.draw((Batch)spriteBatch, (CharSequence)this.h, (i + 15), (Game.i.settingsManager.getScaledViewportHeight() - 15));
/*  473 */       } catch (Exception exception) {
/*  474 */         a.e("failed to draw FPS", new Object[0]);
/*      */       } 
/*  476 */       spriteBatch.end();
/*      */     } 
/*      */     
/*  479 */     spriteBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*      */     
/*  481 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_VIEWPORT_CULLING) != 0.0D) {
/*  482 */       Gdx.gl.glEnable(3042);
/*  483 */       Gdx.gl.glBlendFunc(770, 771);
/*  484 */       shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
/*  485 */       shapeRenderer.setColor(0.0F, 1.0F, 0.0F, 0.28F);
/*  486 */       shapeRenderer.rectLine(camera.viewportWidth / 2.0F, 0.0F, camera.viewportWidth / 2.0F, Game.i.settingsManager.getScaledViewportHeight(), 2.0F);
/*  487 */       shapeRenderer.setColor(Color.WHITE);
/*  488 */       shapeRenderer.end();
/*      */     } 
/*  490 */     if (!this.c) {
/*      */       return;
/*      */     }
/*      */     long l;
/*  494 */     if ((l = Game.getRealTickCount()) - this.g > 100000L) {
/*  495 */       if (this.c) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  503 */         registerValue("GL calls").append(this.glProfiler.getCalls());
/*  504 */         registerValue("Draw calls").append(this.glProfiler.getDrawCalls());
/*  505 */         registerValue("Texture bindings").append(this.glProfiler.getTextureBindings());
/*  506 */         registerValue("Max sprites / batch").append(Game.i.renderingManager.batch.maxSpritesInBatch);
/*  507 */         registerValue("Resolution").append(Game.i.uiManager.getScreenWidth()).append('x').append(Game.i.uiManager.getScreenHeight());
/*      */ 
/*      */ 
/*      */         
/*  511 */         registerValue("Sounds").append(Game.i.soundManager.playingSoundStats.size).append(" / 48");
/*      */         
/*  513 */         if (Game.i.cursorGraphics.a.size != 0) {
/*  514 */           StringBuilder stringBuilder = registerValue("Cursors");
/*  515 */           for (byte b1 = 0; b1 < Game.i.cursorGraphics.a.size; b1++) {
/*  516 */             ObjectPair objectPair = (ObjectPair)Game.i.cursorGraphics.a.get(b1);
/*  517 */             stringBuilder.append("\n").append((String)objectPair.first).append(": ").append(((ObjectSupplier)objectPair.second).get()).append("    ");
/*      */           } 
/*      */         } else {
/*  520 */           unregisterValue("Cursors");
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  532 */       this.g = l;
/*      */     } 
/*      */ 
/*      */     
/*  536 */     if (Game.getRealTickCount() - this.f > 300000L) {
/*  537 */       this.f = Game.getRealTickCount();
/*  538 */       this.h.setLength(0);
/*  539 */       this.i.clear();
/*      */       
/*  541 */       for (ObjectMap.Entries<ObjectMap.Entry> entries = this.k.iterator(); entries.hasNext(); ) { ObjectMap.Entry entry = entries.next();
/*  542 */         this.i.add(entry.key); }
/*      */       
/*  544 */       this.i.sort();
/*      */       
/*  546 */       for (Array.ArrayIterator<String> arrayIterator = this.i.iterator(); arrayIterator.hasNext(); ) { String str = arrayIterator.next();
/*  547 */         this.h.append(str);
/*  548 */         this.h.append(" = ");
/*  549 */         this.h.append((StringBuilder)this.k.get(str));
/*  550 */         this.h.append("\n"); }
/*      */ 
/*      */       
/*  553 */       this.e.setText((CharSequence)this.h);
/*      */     } 
/*      */     
/*  556 */     this.A++;
/*  557 */     if (this.A == 60) {
/*  558 */       this.A = 0;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  566 */     float f1 = camera.viewportWidth - 240.0F - 5.0F - i;
/*      */     
/*  568 */     Gdx.gl.glEnable(3042);
/*  569 */     Gdx.gl.glBlendFunc(770, 771);
/*  570 */     shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
/*      */     
/*  572 */     int j = 0; int k;
/*  573 */     for (k = this.A; k < 60; k++) {
/*  574 */       long l1 = this.z[k];
/*  575 */       double d = 1.0E9D / l1;
/*      */       
/*  577 */       float f4 = f1 + 4.0F * j;
/*      */ 
/*      */       
/*  580 */       float f3 = (float)d;
/*  581 */       if (d > 50.0D) {
/*  582 */         shapeRenderer.setColor(0.0F, 1.0F, 0.0F, 0.3F);
/*  583 */       } else if (d > 20.0D) {
/*  584 */         shapeRenderer.setColor(0.5F, 0.5F, 0.0F, 0.5F);
/*      */       } else {
/*  586 */         shapeRenderer.setColor(1.0F, 0.0F, 0.0F, 0.5F);
/*      */       } 
/*  588 */       shapeRenderer.rect(f4 - 4.0F, 5.0F, 4.0F, f3);
/*      */       
/*  590 */       j++;
/*      */     } 
/*  592 */     for (k = 0; k < this.A; k++) {
/*  593 */       long l1 = this.z[k];
/*  594 */       double d = 1.0E9D / l1;
/*      */       
/*  596 */       float f4 = f1 + 4.0F * j;
/*      */ 
/*      */       
/*  599 */       float f3 = (float)d;
/*  600 */       if (d > 50.0D) {
/*  601 */         shapeRenderer.setColor(0.0F, 1.0F, 0.0F, 0.3F);
/*  602 */       } else if (d > 20.0D) {
/*  603 */         shapeRenderer.setColor(0.5F, 0.5F, 0.0F, 0.5F);
/*      */       } else {
/*  605 */         shapeRenderer.setColor(1.0F, 0.0F, 0.0F, 0.5F);
/*      */       } 
/*  607 */       shapeRenderer.rect(f4 - 4.0F, 5.0F, 4.0F, f3);
/*      */       
/*  609 */       j++;
/*      */     } 
/*      */     
/*  612 */     shapeRenderer.setColor(0.0F, 1.0F, 0.0F, 0.5F);
/*      */     
/*  614 */     float f2 = Game.i.uiManager.getRegularLayerWidth() * 0.5F;
/*      */ 
/*      */ 
/*      */     
/*  618 */     MusicManager.SpectrumConfig spectrumConfig = Game.i.musicManager.getSpectrumConfig(MusicManager.SpectrumConfig.DEFAULT);
/*      */ 
/*      */     
/*  621 */     float[] arrayOfFloat = new float[D];
/*  622 */     spectrumConfig.copySpectrum(arrayOfFloat, true); byte b;
/*  623 */     for (b = 0; b < arrayOfFloat.length; b++) {
/*      */       float f3, f4;
/*      */       
/*  626 */       if ((f4 = arrayOfFloat[b]) < this.E[b]) {
/*      */         
/*  628 */         f3 = this.E[b] - this.G[b];
/*  629 */         this.G[b] = this.G[b] + paramFloat * 0.35F;
/*  630 */         if (f3 < f4) f3 = f4;
/*      */       
/*      */       } else {
/*  633 */         this.E[b] = f4;
/*  634 */         f3 = f4;
/*  635 */         this.G[b] = 0.0F;
/*      */       } 
/*  637 */       this.E[b] = f3;
/*      */       
/*  639 */       f1 = f3 * 200.0F;
/*  640 */       shapeRenderer.rect(f2 - f1, 5.0F + b * 10.0F, f1, 8.0F);
/*      */     } 
/*      */ 
/*      */     
/*  644 */     shapeRenderer.setColor(0.0F, 0.5F, 1.0F, 0.5F);
/*  645 */     spectrumConfig.copySpectrum(arrayOfFloat, false);
/*  646 */     for (b = 0; b < arrayOfFloat.length; b++) {
/*      */       float f3, f4;
/*      */       
/*  649 */       if ((f4 = arrayOfFloat[b]) < this.F[b]) {
/*      */         
/*  651 */         f3 = this.F[b] - this.H[b];
/*  652 */         this.H[b] = this.H[b] + paramFloat * 0.35F;
/*  653 */         if (f3 < f4) f3 = f4;
/*      */       
/*      */       } else {
/*  656 */         this.F[b] = f4;
/*  657 */         f3 = f4;
/*  658 */         this.H[b] = 0.0F;
/*      */       } 
/*  660 */       this.F[b] = f3;
/*      */       
/*  662 */       f1 = f3 * 200.0F;
/*  663 */       shapeRenderer.rect(f2, 5.0F + b * 10.0F, f1, 8.0F);
/*      */     } 
/*  665 */     shapeRenderer.end();
/*      */     
/*  667 */     if (!this.d) {
/*      */       Runtime runtime;
/*      */ 
/*      */       
/*  671 */       int i1 = (int)((runtime = Runtime.getRuntime()).freeMemory() / 1024L);
/*  672 */       int n = (int)(runtime.totalMemory() / 1024L);
/*  673 */       int m = (int)(runtime.maxMemory() / 1024L);
/*  674 */       registerValue("Memory F/T/M").append(StringFormatter.commaSeparatedNumber(i1)).append(" / ").append(StringFormatter.commaSeparatedNumber(n)).append(" / ").append(StringFormatter.commaSeparatedNumber(m));
/*      */     } else {
/*  676 */       unregisterValue("Memory");
/*      */ 
/*      */       
/*  679 */       this.i.clear();
/*  680 */       for (ObjectMap.Entries<ObjectMap.Entry> entries = this.l.iterator(); entries.hasNext(); ) { ObjectMap.Entry entry = entries.next();
/*  681 */         this.i.add(entry.key); }
/*      */ 
/*      */ 
/*      */       
/*  685 */       long l1 = 1000L; long[] arrayOfLong;
/*      */       byte b2;
/*  687 */       for (j = (arrayOfLong = this.u).length, b2 = 0; b2 < j; b2++) {
/*      */         long l5;
/*  689 */         if ((l5 = arrayOfLong[b2]) > l1) {
/*  690 */           l1 = l5;
/*      */         }
/*      */       } 
/*      */ 
/*      */       
/*  695 */       if (l1 > 50000L) {
/*  696 */         l1 = 50000L;
/*      */       }
/*  698 */       float f3 = (int)((float)l1 / 1000.0F);
/*  699 */       float f6 = 1.0F / f3;
/*      */ 
/*      */       
/*  702 */       float f7 = this.B - f3;
/*  703 */       paramFloat *= 10.0F;
/*  704 */       if (StrictMath.abs(f7) > paramFloat) {
/*  705 */         f3 = this.B - f7 * paramFloat / StrictMath.abs(f7);
/*      */       }
/*  707 */       this.B = f3;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  712 */       int m = (int)Game.i.uiManager.getRegularLayerWidth() - 5 - 560 - 240;
/*  713 */       j = (int)(camera.viewportHeight / 2.0F);
/*  714 */       float f4 = m / 240.0F;
/*  715 */       Gdx.gl.glEnable(3042);
/*  716 */       Gdx.gl.glBlendFunc(770, 771);
/*  717 */       shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
/*  718 */       shapeRenderer.setColor(0.0F, 0.0F, 0.0F, 0.3F);
/*  719 */       shapeRenderer.rect(0.0F, 5.0F, camera.viewportWidth, camera.viewportHeight);
/*      */ 
/*      */       
/*  722 */       int n = 2;
/*  723 */       if (this.B < 10.0F) n = 1;
/*      */       
/*  725 */       shapeRenderer.setColor(1.0F, 1.0F, 1.0F, 0.14F); int i1;
/*  726 */       for (i1 = n; i1 <= f3; i1 += n) {
/*  727 */         float f = i1 * j * f6;
/*  728 */         shapeRenderer.rectLine((i + 560), f, camera.viewportWidth - 5.0F, f, 2.0F);
/*      */       } 
/*  730 */       shapeRenderer.end();
/*      */       
/*  732 */       ResourcePack.ResourcePackBitmapFont resourcePackBitmapFont1 = Game.i.assetManager.getFont(21);
/*  733 */       spriteBatch.begin();
/*  734 */       resourcePackBitmapFont1.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*  735 */       for (i1 = n; i1 <= f3; i1 += n) {
/*  736 */         float f = i1 * j * f6 + 24.0F;
/*  737 */         this.h.setLength(0);
/*  738 */         this.h.append(i1).append(" ms");
/*  739 */         resourcePackBitmapFont1.draw((Batch)spriteBatch, (CharSequence)this.h, (i + 560), f);
/*      */       } 
/*  741 */       resourcePackBitmapFont1.setColor(Color.WHITE);
/*  742 */       spriteBatch.end();
/*      */ 
/*      */       
/*  745 */       spriteBatch.begin();
/*      */       
/*  747 */       resourcePackBitmapFont1.setColor(Color.WHITE);
/*  748 */       resourcePackBitmapFont1.draw((Batch)spriteBatch, "min", (i + 320), 32.0F);
/*  749 */       resourcePackBitmapFont1.draw((Batch)spriteBatch, "avg", (i + 400), 32.0F);
/*  750 */       resourcePackBitmapFont1.draw((Batch)spriteBatch, "max", (i + 480), 32.0F);
/*      */       
/*  752 */       long l2 = 1L;
/*  753 */       long l3 = 1L;
/*  754 */       long l4 = 1L;
/*      */       
/*  756 */       byte b1 = 0;
/*      */ 
/*      */       
/*  759 */       for (n = this.i.size - 1; n >= 0; n--) {
/*  760 */         String str = ((String[])this.i.items)[n];
/*  761 */         long[] arrayOfLong1 = (long[])this.l.get(str);
/*  762 */         long l5 = 0L;
/*  763 */         long l6 = Long.MAX_VALUE;
/*  764 */         long l7 = Long.MIN_VALUE; long[] arrayOfLong2; byte b7;
/*  765 */         for (int i5 = (arrayOfLong2 = arrayOfLong1).length; b7 < i5; ) { long l9 = arrayOfLong2[b7];
/*  766 */           l5 += l9;
/*      */           
/*  768 */           if (l6 > l9) l6 = l9; 
/*  769 */           if (l7 < l9) l7 = l9;  b7++; }
/*      */         
/*  771 */         long l8 = l5 / arrayOfLong1.length;
/*  772 */         b7 = (l7 > this.s || l8 > this.t) ? 1 : 0;
/*      */ 
/*      */ 
/*      */         
/*  776 */         if (l8 > this.t) {
/*  777 */           b1++;
/*      */         }
/*  779 */         if (b7 != 0) {
/*  780 */           this.n.put(str, 60);
/*      */         }
/*      */         int i6;
/*  783 */         if ((i6 = this.n.get(str, 0)) <= 0) {
/*      */           
/*  785 */           if (b7 == 0) {
/*      */             
/*  787 */             this.i.removeIndex(n);
/*      */             
/*      */             continue;
/*      */           } 
/*      */         } else {
/*  792 */           this.n.put(str, i6 - 1);
/*      */         } 
/*      */         
/*  795 */         if (l2 < l6) {
/*  796 */           l2 = l6;
/*      */         }
/*  798 */         if (l3 < l8) {
/*  799 */           l3 = l8;
/*      */         }
/*  801 */         if (l4 < l7) {
/*  802 */           l4 = l7;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         continue;
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  816 */       if (b1 > 5) {
/*  817 */         this.t = (int)(this.t * 1.07D);
/*  818 */         a.i("increasing avg time threshold to " + this.t, new Object[0]);
/*  819 */       } else if (b1 <= 2 && this.t != 400) {
/*  820 */         this.t = (int)(this.t * 0.95D);
/*  821 */         if (this.t < 400) {
/*  822 */           this.t = 400;
/*      */         }
/*  824 */         a.i("decreasing avg time threshold to " + this.t, new Object[0]);
/*      */       } 
/*      */       
/*  827 */       this.i.sort();
/*  828 */       this.i.reverse();
/*      */ 
/*      */       
/*  831 */       Array array = new Array(true, this.m.size, String.class);
/*  832 */       for (ObjectIntMap.Keys<String> keys = this.m.keys().iterator(); keys.hasNext(); ) { String str = keys.next();
/*  833 */         array.add(str); }
/*      */        byte b3;
/*  835 */       for (b3 = 0; b3 < array.size; b3++) {
/*  836 */         String str = (String)array.get(b3);
/*  837 */         if (!this.i.contains(str, false)) {
/*  838 */           this.m.remove(str, 0);
/*      */         }
/*      */       } 
/*      */       
/*  842 */       b3 = 0; Array.ArrayIterator<String> arrayIterator1;
/*  843 */       for (arrayIterator1 = this.i.iterator(); arrayIterator1.hasNext(); ) { String str = arrayIterator1.next();
/*  844 */         long[] arrayOfLong1 = (long[])this.l.get(str);
/*      */         
/*  846 */         long l5 = Long.MAX_VALUE;
/*  847 */         long l6 = Long.MIN_VALUE;
/*  848 */         long l7 = 0L; long[] arrayOfLong2; int i6;
/*  849 */         for (int i5 = (arrayOfLong2 = arrayOfLong1).length; i6 < i5; ) { long l9 = arrayOfLong2[i6];
/*  850 */           l7 += l9;
/*      */           
/*  852 */           if (l5 > l9) l5 = l9; 
/*  853 */           if (l6 < l9) l6 = l9; 
/*      */           i6++; }
/*      */         
/*  856 */         long l8 = l7 / arrayOfLong1.length;
/*      */ 
/*      */         
/*  859 */         if ((i6 = this.m.get(str, -1)) == -1) {
/*      */           
/*  861 */           for (byte b7 = 0; b7 < RANDOM_COLORS.length; b7++) {
/*  862 */             if (!this.m.containsValue(b7)) {
/*  863 */               i6 = b7;
/*      */               break;
/*      */             } 
/*      */           } 
/*  867 */           if (i6 == -1) {
/*      */             
/*  869 */             i6 = 0;
/*      */           } else {
/*      */             
/*  872 */             this.m.put(str, i6);
/*      */           } 
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/*  878 */         resourcePackBitmapFont1.setColor(RANDOM_COLORS[i6]);
/*  879 */         resourcePackBitmapFont1.draw((Batch)spriteBatch, str, (i + 5), ((b3 + 2) * 24));
/*      */ 
/*      */         
/*  882 */         resourcePackBitmapFont1.setColor(1.0F, 1.0F, 1.0F, 0.5F + 0.5F * (float)l5 / (float)l2);
/*  883 */         this.h.setLength(0);
/*  884 */         this.h.append(l5);
/*  885 */         resourcePackBitmapFont1.draw((Batch)spriteBatch, (CharSequence)this.h, (i + 320), ((b3 + 2) * 24));
/*      */         
/*  887 */         resourcePackBitmapFont1.setColor(1.0F, 1.0F, 1.0F, 0.5F + 0.5F * (float)l8 / (float)l3);
/*  888 */         this.h.setLength(0);
/*  889 */         this.h.append(l8);
/*  890 */         resourcePackBitmapFont1.draw((Batch)spriteBatch, (CharSequence)this.h, (i + 400), ((b3 + 2) * 24));
/*      */         
/*  892 */         resourcePackBitmapFont1.setColor(1.0F, 1.0F, 1.0F, 0.5F + 0.5F * (float)l6 / (float)l4);
/*  893 */         this.h.setLength(0);
/*  894 */         this.h.append(l6);
/*  895 */         resourcePackBitmapFont1.draw((Batch)spriteBatch, (CharSequence)this.h, (i + 480), ((b3 + 2) * 24));
/*      */         
/*  897 */         b3++; }
/*      */       
/*  899 */       resourcePackBitmapFont1.setColor(Color.WHITE);
/*  900 */       spriteBatch.end();
/*      */ 
/*      */       
/*  903 */       shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
/*  904 */       Gdx.gl.glEnable(3042);
/*  905 */       Gdx.gl.glBlendFunc(770, 771);
/*      */ 
/*      */       
/*  908 */       for (arrayIterator1 = this.i.iterator(); arrayIterator1.hasNext(); ) { String str = arrayIterator1.next();
/*  909 */         long[] arrayOfLong1 = (long[])this.l.get(str);
/*      */         
/*  911 */         int i5 = this.m.get(str, 0);
/*  912 */         shapeRenderer.setColor(RANDOM_COLORS[i5]);
/*  913 */         float f = -1.0F;
/*  914 */         byte b7 = 0;
/*  915 */         for (byte b8 = 0; b8 < 'ð'; b8++) {
/*  916 */           int i6 = (this.w + b8) % 240;
/*      */           long l5;
/*  918 */           float f11 = (float)(l5 = arrayOfLong1[i6]) / 1000.0F;
/*  919 */           float f12 = 560.0F + f4 * b7 + i;
/*  920 */           float f13 = 5.0F + f11 * f6 * j;
/*  921 */           if (b7) {
/*  922 */             shapeRenderer.rectLine(f12 - f4, f, f12, f13, 2.0F);
/*      */           }
/*  924 */           f = f13;
/*  925 */           b7++;
/*      */         }  }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  931 */       float f5 = -1.0F;
/*  932 */       byte b4 = 0;
/*  933 */       shapeRenderer.setColor(1.0F, 1.0F, 1.0F, 0.21F);
/*  934 */       for (byte b5 = 0; b5 < 'ð'; b5++) {
/*  935 */         int i5 = (this.w + b5) % 240;
/*      */         long l5;
/*  937 */         float f11 = (float)(l5 = this.u[i5]) / 1000.0F;
/*  938 */         float f12 = 560.0F + f4 * b4 + i;
/*  939 */         float f13 = 5.0F + f11 * f6 * j;
/*  940 */         if (b4) {
/*  941 */           shapeRenderer.rectLine(f12 - f4, f5, f12, f13, 4.0F);
/*      */         }
/*  943 */         f5 = f13;
/*  944 */         b4++;
/*      */       } 
/*      */ 
/*      */       
/*  948 */       shapeRenderer.end();
/*      */       
/*  950 */       float f8 = (j + 5) + 50.0F;
/*  951 */       float f9 = j * 0.5F;
/*  952 */       f6 = 1.0F / this.x;
/*      */       
/*  954 */       Gdx.gl.glEnable(3042);
/*  955 */       Gdx.gl.glBlendFunc(770, 771);
/*  956 */       shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
/*  957 */       shapeRenderer.setColor(0.0F, 0.0F, 0.0F, 0.56F);
/*  958 */       shapeRenderer.rect(360.0F, f8 - 16.0F, m + 200.0F, f9 + 32.0F + 16.0F);
/*      */ 
/*      */       
/*  961 */       b4 = 0;
/*  962 */       shapeRenderer.setColor(0.0F, 0.7F, 1.0F, 0.21F); int i2;
/*  963 */       for (i2 = this.w; i2 < 240; i2++) {
/*  964 */         int i5 = this.v[i2 * 3 + 1] - this.v[i2 * 3];
/*      */         
/*  966 */         float f11 = 560.0F + f4 * b4 + i;
/*  967 */         float f12 = f6 * i5 * f9;
/*  968 */         if (b4 != 0) {
/*  969 */           shapeRenderer.rect(f11 - f4, f8, f4, f12);
/*      */         }
/*  971 */         b4++;
/*      */       } 
/*  973 */       for (i2 = 0; i2 < this.w; i2++) {
/*  974 */         int i5 = this.v[i2 * 3 + 1] - this.v[i2 * 3];
/*      */         
/*  976 */         float f11 = 560.0F + f4 * b4 + i;
/*  977 */         float f12 = f6 * i5 * f9;
/*  978 */         if (b4 != 0) {
/*  979 */           shapeRenderer.rect(f11 - f4, f8, f4, f12);
/*      */         }
/*  981 */         b4++;
/*      */       } 
/*      */ 
/*      */       
/*  985 */       b4 = 0;
/*  986 */       i2 = Integer.MAX_VALUE;
/*  987 */       shapeRenderer.setColor(0.0F, 1.0F, 0.0F, 0.21F); int i4;
/*  988 */       for (i4 = this.w; i4 < 240; i4++) {
/*  989 */         int i5 = this.v[i4 * 3 + 1] - this.v[i4 * 3];
/*  990 */         int i6 = this.v[i4 * 3];
/*      */         
/*  992 */         float f11 = 560.0F + f4 * b4 + i;
/*  993 */         float f12 = f8 + f6 * i5 * f9;
/*  994 */         float f13 = f6 * i6 * f9;
/*  995 */         if (b4 != 0) {
/*  996 */           shapeRenderer.rect(f11 - f4, f12, f4, f13);
/*      */         }
/*      */         
/*  999 */         if (i2 < i6) {
/*      */           
/* 1001 */           shapeRenderer.circle(f11, f12, 4.0F, 8);
/* 1002 */           shapeRenderer.circle(f11, f12, 4.0F, 8);
/*      */           
/* 1004 */           shapeRenderer.end();
/*      */           
/* 1006 */           spriteBatch.begin();
/* 1007 */           resourcePackBitmapFont1.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 1008 */           this.h.setLength(0);
/* 1009 */           this.h.append(StringFormatter.commaSeparatedNumber(i6)).append("kb");
/* 1010 */           resourcePackBitmapFont1.draw((Batch)spriteBatch, (CharSequence)this.h, f11 + 8.0F, f12);
/* 1011 */           resourcePackBitmapFont1.setColor(Color.WHITE);
/* 1012 */           spriteBatch.end();
/*      */           
/* 1014 */           Gdx.gl.glEnable(3042);
/* 1015 */           Gdx.gl.glBlendFunc(770, 771);
/* 1016 */           shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
/* 1017 */           shapeRenderer.setColor(0.0F, 1.0F, 0.0F, 0.21F);
/*      */         } 
/* 1019 */         i2 = i6;
/* 1020 */         b4++;
/*      */       } 
/* 1022 */       for (i4 = 0; i4 < this.w; i4++) {
/* 1023 */         int i5 = this.v[i4 * 3 + 1] - this.v[i4 * 3];
/* 1024 */         int i6 = this.v[i4 * 3];
/*      */         
/* 1026 */         float f11 = 560.0F + f4 * b4 + i;
/* 1027 */         float f12 = f8 + f6 * i5 * f9;
/* 1028 */         float f13 = f6 * i6 * f9;
/* 1029 */         if (b4 != 0) {
/* 1030 */           shapeRenderer.rect(f11 - f4, f12, f4, f13);
/*      */         }
/*      */         
/* 1033 */         if (i2 < i6) {
/*      */           
/* 1035 */           shapeRenderer.circle(f11, f12, 4.0F, 8);
/* 1036 */           shapeRenderer.circle(f11, f12, 4.0F, 8);
/*      */           
/* 1038 */           shapeRenderer.end();
/*      */           
/* 1040 */           spriteBatch.begin();
/* 1041 */           resourcePackBitmapFont1.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 1042 */           this.h.setLength(0);
/* 1043 */           this.h.append(String.valueOf(StringFormatter.commaSeparatedNumber(i6))).append("kb");
/* 1044 */           resourcePackBitmapFont1.draw((Batch)spriteBatch, (CharSequence)this.h, f11 + 8.0F, f12);
/* 1045 */           resourcePackBitmapFont1.setColor(Color.WHITE);
/* 1046 */           spriteBatch.end();
/*      */           
/* 1048 */           Gdx.gl.glEnable(3042);
/* 1049 */           Gdx.gl.glBlendFunc(770, 771);
/* 1050 */           shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
/* 1051 */           shapeRenderer.setColor(0.0F, 1.0F, 0.0F, 0.21F);
/*      */         } 
/* 1053 */         i2 = i6;
/* 1054 */         b4++;
/*      */       } 
/*      */ 
/*      */       
/* 1058 */       f5 = -1.0F;
/* 1059 */       b4 = 0;
/* 1060 */       shapeRenderer.setColor(1.0F, 0.8F, 0.0F, 0.21F);
/* 1061 */       for (i4 = this.w; i4 < 240; i4++) {
/* 1062 */         int i5 = this.v[i4 * 3 + 2];
/* 1063 */         float f11 = 560.0F + f4 * b4 + i;
/* 1064 */         float f12 = f8 + i5 * f6 * f9;
/* 1065 */         if (b4 != 0) {
/* 1066 */           shapeRenderer.rectLine(f11 - f4, f5, f11, f12, 3.0F);
/*      */         }
/* 1068 */         f5 = f12;
/* 1069 */         b4++;
/*      */       } 
/* 1071 */       for (i4 = 0; i4 < this.w; i4++) {
/* 1072 */         int i5 = this.v[i4 * 3 + 2];
/* 1073 */         float f11 = 560.0F + f4 * b4 + i;
/* 1074 */         float f12 = f8 + i5 * f6 * f9;
/* 1075 */         if (b4 != 0) {
/* 1076 */           shapeRenderer.rectLine(f11 - f4, f5, f11, f12, 3.0F);
/*      */         }
/* 1078 */         f5 = f12;
/* 1079 */         b4++;
/*      */       } 
/*      */       
/* 1082 */       shapeRenderer.setColor(Color.WHITE);
/* 1083 */       shapeRenderer.end();
/*      */       
/* 1085 */       spriteBatch.begin();
/*      */       
/* 1087 */       resourcePackBitmapFont1.setColor(0.0F, 0.7F, 1.0F, 0.56F);
/* 1088 */       this.h.setLength(0);
/* 1089 */       this.h.append("Total: ").append(StringFormatter.commaSeparatedNumber(this.v[this.w * 3 + 1])).append("kb");
/* 1090 */       resourcePackBitmapFont1.draw((Batch)spriteBatch, (CharSequence)this.h, 550.0F, f8 + this.v[this.w * 3 + 1] * f6 * f9, 1.0F, 16, false);
/*      */       
/* 1092 */       resourcePackBitmapFont1.setColor(0.0F, 1.0F, 0.0F, 0.56F);
/* 1093 */       this.h.setLength(0);
/* 1094 */       this.h.append("Free: ").append(StringFormatter.commaSeparatedNumber(this.v[this.w * 3])).append("kb");
/* 1095 */       resourcePackBitmapFont1.draw((Batch)spriteBatch, (CharSequence)this.h, 550.0F, f8 + this.v[this.w * 3] * f6 * f9, 1.0F, 16, false);
/*      */       
/* 1097 */       resourcePackBitmapFont1.setColor(1.0F, 0.7F, 0.0F, 0.56F);
/* 1098 */       this.h.setLength(0);
/* 1099 */       this.h.append("Max: ").append(StringFormatter.commaSeparatedNumber(this.v[this.w * 3 + 2])).append("kb");
/* 1100 */       resourcePackBitmapFont1.draw((Batch)spriteBatch, (CharSequence)this.h, 550.0F, f8 + this.v[this.w * 3 + 2] * f6 * f9 + 16.0F, 1.0F, 16, false);
/*      */       
/* 1102 */       resourcePackBitmapFont1.setColor(Color.WHITE);
/* 1103 */       spriteBatch.end();
/*      */       
/* 1105 */       this.w++;
/* 1106 */       if (this.w == 240) {
/* 1107 */         this.w = 0;
/*      */       }
/*      */ 
/*      */       
/* 1111 */       for (Array.ArrayIterator<String> arrayIterator2 = this.i.iterator(); arrayIterator2.hasNext(); ) { String str = arrayIterator2.next();
/*      */         long[] arrayOfLong1;
/* 1113 */         (arrayOfLong1 = (long[])this.l.get(str))[this.w] = 0L;
/*      */ 
/*      */         
/* 1116 */         boolean bool = true; long[] arrayOfLong2; int i5; byte b7;
/* 1117 */         for (i5 = (arrayOfLong2 = arrayOfLong1).length, b7 = 0; b7 < i5; b7++) {
/* 1118 */           long l5; if ((l5 = arrayOfLong2[b7]) != 0L) {
/* 1119 */             bool = false;
/*      */             break;
/*      */           } 
/*      */         } 
/* 1123 */         if (bool) {
/* 1124 */           this.l.remove(str);
/*      */         } }
/*      */ 
/*      */ 
/*      */       
/* 1129 */       Arrays.fill(this.K, 0);
/* 1130 */       for (int i3 = Game.i.soundManager.playingSoundStats.size - 1; i3 >= 0; i3--) {
/*      */         SoundManager.PlayingSoundStat playingSoundStat; StaticSoundType staticSoundType;
/* 1132 */         if ((playingSoundStat = ((SoundManager.PlayingSoundStat[])Game.i.soundManager.playingSoundStats.items)[i3]) != null && (
/*      */           
/* 1134 */           staticSoundType = playingSoundStat.type) != null) this.K[staticSoundType.ordinal()] = this.K[staticSoundType.ordinal()] + 1;
/*      */       
/*      */       } 
/*      */       
/* 1138 */       float f10 = 0.0F;
/* 1139 */       this.h.setLength(0);
/* 1140 */       for (byte b6 = 0; b6 < this.K.length; b6++) {
/* 1141 */         if (this.K[b6] != 0) {
/* 1142 */           if (this.K[b6] >= 8) {
/* 1143 */             this.h.append("[#FFFF00]");
/*      */           }
/* 1145 */           this.h.append(StaticSoundType.values[b6].name()).append(": ").append(this.K[b6]).append("\n");
/* 1146 */           if (this.K[b6] >= 8) {
/* 1147 */             this.h.append("[]");
/*      */           }
/* 1149 */           f10++;
/*      */         } 
/*      */       } 
/* 1152 */       if (this.h.length != 0) {
/* 1153 */         resourcePackBitmapFont1.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 1154 */         spriteBatch.begin();
/* 1155 */         resourcePackBitmapFont1.draw((Batch)spriteBatch, (CharSequence)this.h, camera.viewportWidth - 100.0F - i - 5.0F, 80.0F + f10 * resourcePackBitmapFont1.getLineHeight(), 100.0F, 16, false);
/* 1156 */         spriteBatch.end();
/* 1157 */         resourcePackBitmapFont1.setColor(Color.WHITE);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1162 */     this.glProfiler.reset();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void test() {
/* 1171 */     for (byte b = 0; b < 100; b++) {
/*      */       float f;
/* 1173 */       if ((f = FastRandom.random.nextFloat() - FastRandom.random.nextFloat()) < -1.0F || f > 1.0F) {
/* 1174 */         throw new RuntimeException("Manual triangular random failed: " + f);
/*      */       }
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void dispose() {
/* 1196 */     if (Game.i.settingsManager != null && this.j != null)
/* 1197 */       Game.i.settingsManager.removeListener(this.j); 
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\DebugManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */