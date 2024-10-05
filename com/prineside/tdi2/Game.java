/*      */ package com.prineside.tdi2;
/*      */ 
/*      */ import com.badlogic.gdx.Game;
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.Graphics;
/*      */ import com.badlogic.gdx.graphics.Pixmap;
/*      */ import com.badlogic.gdx.graphics.Texture;
/*      */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*      */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.Null;
/*      */ import com.badlogic.gdx.utils.ObjectMap;
/*      */ import com.badlogic.gdx.utils.StringBuilder;
/*      */ import com.badlogic.gdx.utils.TimeUtils;
/*      */ import com.google.common.base.Preconditions;
/*      */ import com.prineside.tdi2.events.Event;
/*      */ import com.prineside.tdi2.events.EventDispatcher;
/*      */ import com.prineside.tdi2.events.global.GameDispose;
/*      */ import com.prineside.tdi2.events.global.GameLoad;
/*      */ import com.prineside.tdi2.events.global.GameStartLoad;
/*      */ import com.prineside.tdi2.events.global.PostRender;
/*      */ import com.prineside.tdi2.events.global.PreRender;
/*      */ import com.prineside.tdi2.events.global.Render;
/*      */ import com.prineside.tdi2.events.global.ScreenResize;
/*      */ import com.prineside.tdi2.events.global.StartRender;
/*      */ import com.prineside.tdi2.events.global.VisibleDisplayFrameChange;
/*      */ import com.prineside.tdi2.managers.AbilityManager;
/*      */ import com.prineside.tdi2.managers.AchievementManager;
/*      */ import com.prineside.tdi2.managers.AnalyticsManager;
/*      */ import com.prineside.tdi2.managers.AssetManager;
/*      */ import com.prineside.tdi2.managers.AuthManager;
/*      */ import com.prineside.tdi2.managers.BasicLevelManager;
/*      */ import com.prineside.tdi2.managers.BuffManager;
/*      */ import com.prineside.tdi2.managers.CursorGraphicsManager;
/*      */ import com.prineside.tdi2.managers.DailyQuestManager;
/*      */ import com.prineside.tdi2.managers.DebugManager;
/*      */ import com.prineside.tdi2.managers.EnemyManager;
/*      */ import com.prineside.tdi2.managers.GameValueManager;
/*      */ import com.prineside.tdi2.managers.GateManager;
/*      */ import com.prineside.tdi2.managers.HttpManager;
/*      */ import com.prineside.tdi2.managers.ItemManager;
/*      */ import com.prineside.tdi2.managers.LeaderBoardManager;
/*      */ import com.prineside.tdi2.managers.LocaleManager;
/*      */ import com.prineside.tdi2.managers.MapManager;
/*      */ import com.prineside.tdi2.managers.MessageManager;
/*      */ import com.prineside.tdi2.managers.MinerManager;
/*      */ import com.prineside.tdi2.managers.ModifierManager;
/*      */ import com.prineside.tdi2.managers.MusicManager;
/*      */ import com.prineside.tdi2.managers.NetworkManager;
/*      */ import com.prineside.tdi2.managers.PreferencesManager;
/*      */ import com.prineside.tdi2.managers.ProgressManager;
/*      */ import com.prineside.tdi2.managers.PurchaseManager;
/*      */ import com.prineside.tdi2.managers.RatingManager;
/*      */ import com.prineside.tdi2.managers.RenderingManager;
/*      */ import com.prineside.tdi2.managers.ReplayManager;
/*      */ import com.prineside.tdi2.managers.ResearchManager;
/*      */ import com.prineside.tdi2.managers.ResourceManager;
/*      */ import com.prineside.tdi2.managers.ScreenManager;
/*      */ import com.prineside.tdi2.managers.ScriptManager;
/*      */ import com.prineside.tdi2.managers.SecretCodeManager;
/*      */ import com.prineside.tdi2.managers.SettingsManager;
/*      */ import com.prineside.tdi2.managers.ShapeManager;
/*      */ import com.prineside.tdi2.managers.SoundManager;
/*      */ import com.prineside.tdi2.managers.StatisticsManager;
/*      */ import com.prineside.tdi2.managers.TileManager;
/*      */ import com.prineside.tdi2.managers.TowerManager;
/*      */ import com.prineside.tdi2.managers.TowerStatManager;
/*      */ import com.prineside.tdi2.managers.TriggeredActionManager;
/*      */ import com.prineside.tdi2.managers.TrophyManager;
/*      */ import com.prineside.tdi2.managers.UiManager;
/*      */ import com.prineside.tdi2.managers.UnitManager;
/*      */ import com.prineside.tdi2.managers.UserMapManager;
/*      */ import com.prineside.tdi2.ui.shared.DeveloperConsole;
/*      */ import com.prineside.tdi2.utils.GameSyncLoader;
/*      */ import com.prineside.tdi2.utils.IntRectangle;
/*      */ import com.prineside.tdi2.utils.errorhandling.CrashHandler;
/*      */ import com.prineside.tdi2.utils.logging.Logger;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*      */ import java.nio.charset.Charset;
/*      */ import java.util.Enumeration;
/*      */ import java.util.Properties;
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
/*      */ public abstract class Game
/*      */   extends Game
/*      */ {
/*   96 */   private static final TLog a = TLog.forClass(Game.class);
/*      */ 
/*      */   
/*      */   public static Game i;
/*      */   
/*  101 */   private static final long b = TimeUtils.nanoTime() / 1000L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  107 */   public static final EventDispatcher EVENTS = new EventDispatcher();
/*      */   
/*      */   public PreferencesManager preferencesManager;
/*      */   
/*      */   public ScreenManager screenManager;
/*      */   
/*      */   public AbilityManager abilityManager;
/*      */   
/*      */   public AchievementManager achievementManager;
/*      */   
/*      */   public AnalyticsManager analyticsManager;
/*      */   public AuthManager authManager;
/*      */   public BasicLevelManager basicLevelManager;
/*      */   public BuffManager buffManager;
/*      */   public CursorGraphicsManager cursorGraphics;
/*      */   public DailyQuestManager dailyQuestManager;
/*      */   public DebugManager debugManager;
/*      */   public EnemyManager enemyManager;
/*      */   public GameValueManager gameValueManager;
/*      */   public GateManager gateManager;
/*      */   public HttpManager httpManager;
/*      */   public ResearchManager researchManager;
/*      */   public ItemManager itemManager;
/*      */   public LocaleManager localeManager;
/*      */   public LeaderBoardManager leaderBoardManager;
/*      */   public MapManager mapManager;
/*      */   public MessageManager messageManager;
/*      */   public MinerManager minerManager;
/*      */   public ModifierManager modifierManager;
/*      */   public NetworkManager networkManager;
/*      */   public ProgressManager progressManager;
/*      */   public PurchaseManager purchaseManager;
/*      */   public RatingManager ratingManager;
/*      */   public RenderingManager renderingManager;
/*      */   public ReplayManager replayManager;
/*      */   public ResourceManager resourceManager;
/*      */   public AssetManager assetManager;
/*      */   public ScriptManager scriptManager;
/*      */   public ShapeManager shapeManager;
/*      */   public SoundManager soundManager;
/*      */   public StatisticsManager statisticsManager;
/*      */   public SecretCodeManager secretCodeManager;
/*      */   public SettingsManager settingsManager;
/*      */   public TileManager tileManager;
/*      */   public TowerManager towerManager;
/*      */   public TowerStatManager towerStatManager;
/*      */   public TriggeredActionManager triggeredActionManager;
/*      */   public TrophyManager trophyManager;
/*      */   public UnitManager unitManager;
/*      */   public UiManager uiManager;
/*      */   public UserMapManager userMapManager;
/*      */   public MusicManager musicManager;
/*  159 */   public final Array<Manager> managers = new Array(true, 1);
/*      */   
/*      */   private boolean c;
/*      */   
/*      */   private boolean d = false;
/*  164 */   private final IntRectangle e = new IntRectangle();
/*      */ 
/*      */ 
/*      */   
/*      */   public BitmapFont defaultSmallFuturaFont;
/*      */ 
/*      */ 
/*      */   
/*      */   @Null
/*      */   private final Runnable f;
/*      */ 
/*      */ 
/*      */   
/*      */   public final ActionResolver actionResolver;
/*      */ 
/*      */ 
/*      */   
/*      */   public GameSyncLoader gameSyncLoader;
/*      */ 
/*      */   
/*      */   private boolean g = false;
/*      */ 
/*      */   
/*      */   private long h;
/*      */ 
/*      */   
/*      */   private Thread j;
/*      */ 
/*      */   
/*      */   private int k;
/*      */ 
/*      */   
/*      */   private long l;
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkConfiguredForProduction() {
/*      */     StringBuilder stringBuilder;
/*  202 */     (stringBuilder = new StringBuilder()).append("                  Production checklist:\n");
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void exit() {
/*  227 */     if (Gdx.app != null) {
/*  228 */       Gdx.app.exit(); return;
/*      */     } 
/*  230 */     System.exit(0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isLoaded() {
/*  239 */     return (i != null && i.g);
/*      */   }
/*      */   
/*      */   public boolean isInMainThread() {
/*  243 */     if (this.j == Thread.currentThread()) {
/*  244 */       return true;
/*      */     }
/*  246 */     if (this.j == null) {
/*  247 */       a.w("isInMainThread - libgdxThread is null", new Object[0]);
/*  248 */       return true;
/*      */     } 
/*      */     
/*  251 */     if ("LibGDX rendering thread".equals(Thread.currentThread().getName())) {
/*  252 */       a.w("isInMainThread - current thread has correct name but libgdxThread not equals current thread (libgdxThread name:\"%s\"). Overwriting libgdxThread with current", new Object[] { this.j.getName() });
/*  253 */       this.j = Thread.currentThread();
/*  254 */       return true;
/*      */     } 
/*  256 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void assertInMainThread() {
/*  261 */     if (!isInMainThread()) {
/*  262 */       throw new IllegalStateException("Must be called in a main thread, called from " + Thread.currentThread().getName() + " instead");
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void create() {
/*  268 */     this.h = getTimestampMillis();
/*  269 */     if (this.f != null) {
/*  270 */       this.f.run();
/*      */     }
/*      */     
/*  273 */     checkConfiguredForProduction();
/*      */     
/*  275 */     long l = getTimestampMillis();
/*      */     
/*  277 */     Gdx.app.getType();
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
/*  416 */     this.j = Thread.currentThread();
/*  417 */     this.j.setName("LibGDX rendering thread");
/*  418 */     CrashHandler.handleThreadExceptions(this.j);
/*      */     
/*  420 */     if (!Config.isHeadless()) {
/*  421 */       this.defaultSmallFuturaFont = new BitmapFont(Gdx.files.internal("resourcepacks/default/futura.fnt"), new TextureRegion(new Texture(Gdx.files.internal("resourcepacks/default/futura.png"), Pixmap.Format.RGBA4444, false)));
/*  422 */       this.defaultSmallFuturaFont.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
/*  423 */       this.defaultSmallFuturaFont.getData().setScale(0.75F);
/*      */     } 
/*      */     
/*  426 */     Gdx.input.setCatchKey(4, true);
/*      */     
/*  428 */     byte b1 = 0;
/*      */     
/*  430 */     if (!Config.isHeadless()) {
/*  431 */       this.preferencesManager = new PreferencesManager();
/*  432 */       this.managers.add(this.preferencesManager);
/*  433 */       b1++;
/*      */       
/*  435 */       this.authManager = new AuthManager();
/*  436 */       this.managers.add(this.authManager);
/*  437 */       b1++;
/*      */       
/*  439 */       this.screenManager = new ScreenManager();
/*  440 */       this.managers.add(this.screenManager);
/*  441 */       b1++;
/*      */       
/*  443 */       this.renderingManager = new RenderingManager();
/*  444 */       this.managers.add(this.renderingManager);
/*  445 */       b1++;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  453 */     this.gameSyncLoader = new GameSyncLoader();
/*      */     
/*  455 */     this.gameSyncLoader.addTask(new GameSyncLoader.Task("Initialization", () -> {
/*      */             a.i("======== INFO ========", new Object[0]); a.i("|- Configuration", new Object[0]);
/*      */             a.i("|  |- version: R.1.9.1", new Object[0]);
/*      */             a.i("|  |- build: 207", new Object[0]);
/*      */             a.i("|  |- protocol: 207", new Object[0]);
/*      */             a.i("|  |- debug mode: disabled", new Object[0]);
/*      */             a.i("|  |- GDX app version: " + Gdx.app.getVersion(), new Object[0]);
/*      */             a.i("|  |- GDX version: 1.12.1", new Object[0]);
/*      */             a.i("`- Device", new Object[0]);
/*      */             a.i("   |- charset: " + Charset.defaultCharset(), new Object[0]);
/*      */             ObjectMap<String, String> objectMap;
/*      */             ObjectMap.Keys<String> keys = (objectMap = this.actionResolver.getDeviceInfo()).keys().iterator();
/*      */             while (keys.hasNext()) {
/*      */               String str = keys.next();
/*      */               a.i("   |- " + str + ": " + (String)objectMap.get(str), new Object[0]);
/*      */             } 
/*      */             Runtime runtime = Runtime.getRuntime();
/*      */             a.i("   |- system", new Object[0]);
/*      */             Properties properties;
/*      */             Enumeration<?> enumeration = (properties = System.getProperties()).propertyNames();
/*      */             while (enumeration.hasMoreElements()) {
/*      */               Object object1 = enumeration.nextElement();
/*      */               Object object2;
/*      */               if ((object2 = properties.get(object1)) != null)
/*      */                 a.i("   |  " + (enumeration.hasMoreElements() ? "|" : "`") + "- " + object1 + ": " + ((String)object2).trim(), new Object[0]); 
/*      */             } 
/*      */             a.i("   |- runtime", new Object[0]);
/*      */             a.i("   |  |- available processors: " + runtime.availableProcessors(), new Object[0]);
/*      */             a.i("   |  |- free memory: " + runtime.freeMemory(), new Object[0]);
/*      */             a.i("   |  |- max memory: " + runtime.maxMemory(), new Object[0]);
/*      */             a.i("   |  `- total memory: " + runtime.totalMemory(), new Object[0]);
/*      */             a.i("   `- graphics", new Object[0]);
/*      */             a.i("      |- type: " + Gdx.graphics.getGLVersion().getType(), new Object[0]);
/*      */             a.i("      |- version: " + Gdx.graphics.getGLVersion().getMajorVersion() + "." + Gdx.graphics.getGLVersion().getMinorVersion() + "." + Gdx.graphics.getGLVersion().getReleaseVersion(), new Object[0]);
/*      */             a.i("      |- renderer: " + Gdx.graphics.getGLVersion().getRendererString(), new Object[0]);
/*      */             a.i("      |- vendor: " + Gdx.graphics.getGLVersion().getVendorString(), new Object[0]);
/*      */             a.i("      |- back buffer size: " + Gdx.graphics.getBackBufferWidth() + "x" + Gdx.graphics.getBackBufferHeight(), new Object[0]);
/*      */             a.i("      |- density: " + Gdx.graphics.getDensity(), new Object[0]);
/*      */             a.i("      `- max texture size: " + Config.getMaxTextureSize(), new Object[0]);
/*      */             a.i("======================", new Object[0]);
/*      */           }));
/*  496 */     if (!Config.isHeadless()) {
/*  497 */       this.gameSyncLoader.addTask(new GameSyncLoader.Task("Settings", () -> {
/*      */               this.settingsManager = new SettingsManager();
/*      */               this.managers.add(this.settingsManager);
/*      */             }));
/*  501 */       b1++;
/*      */     } 
/*      */     
/*  504 */     if (!Config.isHeadless()) {
/*  505 */       this.gameSyncLoader.addTask(new GameSyncLoader.Task("Assets", () -> {
/*      */               this.assetManager = new AssetManager();
/*      */               this.managers.add(this.assetManager);
/*      */             }));
/*  509 */       b1++;
/*      */       
/*  511 */       this.gameSyncLoader.addTask(new GameSyncLoader.Task("Cursor graphics", () -> {
/*      */               this.cursorGraphics = new CursorGraphicsManager();
/*      */               this.managers.add(this.cursorGraphics);
/*      */             }));
/*  515 */       b1++;
/*      */     } 
/*      */     
/*  518 */     if (!Config.isHeadless()) {
/*  519 */       this.gameSyncLoader.addTask(new GameSyncLoader.Task("XM music", () -> {
/*      */               this.musicManager = MusicManager.createSelfSetuppingDummy();
/*      */               this.managers.add(this.musicManager);
/*      */             }));
/*  523 */       b1++;
/*      */     } 
/*      */     
/*  526 */     this.gameSyncLoader.addTask(new GameSyncLoader.Task("Game values", () -> {
/*      */             this.gameValueManager = new GameValueManager();
/*      */             this.managers.add(this.gameValueManager);
/*      */           }));
/*  530 */     b1++;
/*      */     
/*  532 */     if (!Config.isHeadless()) {
/*  533 */       this.gameSyncLoader.addTask(new GameSyncLoader.Task("Achievements", () -> {
/*      */               this.achievementManager = new AchievementManager();
/*      */               this.managers.add(this.achievementManager);
/*      */             }));
/*  537 */       b1++;
/*      */       
/*  539 */       this.gameSyncLoader.addTask(new GameSyncLoader.Task("Analytics", () -> {
/*      */               this.analyticsManager = new AnalyticsManager();
/*      */               this.managers.add(this.analyticsManager);
/*      */             }));
/*  543 */       b1++;
/*      */     } 
/*      */     
/*  546 */     this.gameSyncLoader.addTask(new GameSyncLoader.Task("Abilities", () -> {
/*      */             this.abilityManager = new AbilityManager();
/*      */             this.managers.add(this.abilityManager);
/*      */           }));
/*  550 */     b1++;
/*      */     
/*  552 */     if (!Config.isHeadless()) {
/*  553 */       this.gameSyncLoader.addTask(new GameSyncLoader.Task("Statistics", () -> {
/*      */               this.statisticsManager = new StatisticsManager();
/*      */               this.managers.add(this.statisticsManager);
/*      */             }));
/*  557 */       b1++;
/*      */       
/*  559 */       this.gameSyncLoader.addTask(new GameSyncLoader.Task("Progress", () -> {
/*      */               this.progressManager = new ProgressManager();
/*      */               this.managers.add(this.progressManager);
/*      */             }));
/*  563 */       b1++;
/*      */       
/*  565 */       this.gameSyncLoader.addTask(new GameSyncLoader.Task("Replays", () -> {
/*      */               this.replayManager = new ReplayManager();
/*      */               this.managers.add(this.replayManager);
/*      */             }));
/*  569 */       b1++;
/*      */     } 
/*      */     
/*  572 */     if (!Config.isHeadless()) {
/*  573 */       this.gameSyncLoader.addTask(new GameSyncLoader.Task("Leader boards", () -> {
/*      */               this.leaderBoardManager = new LeaderBoardManager();
/*      */               this.managers.add(this.leaderBoardManager);
/*      */             }));
/*  577 */       b1++;
/*      */     } 
/*      */     
/*  580 */     this.gameSyncLoader.addTask(new GameSyncLoader.Task("Maps", () -> {
/*      */             this.mapManager = new MapManager();
/*      */             this.managers.add(this.mapManager);
/*      */           }));
/*  584 */     b1++;
/*      */     
/*  586 */     this.gameSyncLoader.addTask(new GameSyncLoader.Task("Enemies", () -> {
/*      */             this.enemyManager = new EnemyManager();
/*      */             this.managers.add(this.enemyManager);
/*      */           }));
/*  590 */     b1++;
/*      */     
/*  592 */     this.gameSyncLoader.addTask(new GameSyncLoader.Task("Units", () -> {
/*      */             this.unitManager = new UnitManager();
/*      */             this.managers.add(this.unitManager);
/*      */           }));
/*  596 */     b1++;
/*      */     
/*  598 */     if (!Config.isHeadless()) {
/*  599 */       this.gameSyncLoader.addTask(new GameSyncLoader.Task("Sounds", () -> {
/*      */               this.soundManager = new SoundManager();
/*      */               this.managers.add(this.soundManager);
/*      */             }));
/*  603 */       b1++;
/*      */     } 
/*      */     
/*  606 */     if (!Config.isHeadless()) {
/*  607 */       this.gameSyncLoader.addTask(new GameSyncLoader.Task("Shapes", () -> {
/*      */               this.shapeManager = new ShapeManager();
/*      */               this.managers.add(this.shapeManager);
/*      */             }));
/*  611 */       b1++;
/*      */     } 
/*      */     
/*  614 */     this.gameSyncLoader.addTask(new GameSyncLoader.Task("Towers", () -> {
/*      */             this.towerManager = new TowerManager();
/*      */             this.managers.add(this.towerManager);
/*      */           }));
/*  618 */     b1++;
/*      */     
/*  620 */     this.gameSyncLoader.addTask(new GameSyncLoader.Task("Miners", () -> {
/*      */             this.minerManager = new MinerManager();
/*      */             this.managers.add(this.minerManager);
/*      */           }));
/*  624 */     b1++;
/*      */     
/*  626 */     this.gameSyncLoader.addTask(new GameSyncLoader.Task("Modifiers", () -> {
/*      */             this.modifierManager = new ModifierManager();
/*      */             this.managers.add(this.modifierManager);
/*      */           }));
/*  630 */     b1++;
/*      */     
/*  632 */     this.gameSyncLoader.addTask(new GameSyncLoader.Task("Network", () -> {
/*      */             this.networkManager = new NetworkManager();
/*      */             this.managers.add(this.networkManager);
/*      */           }));
/*  636 */     b1++;
/*      */     
/*  638 */     this.gameSyncLoader.addTask(new GameSyncLoader.Task("Tiles", () -> {
/*      */             this.tileManager = new TileManager();
/*      */             this.managers.add(this.tileManager);
/*      */           }));
/*  642 */     b1++;
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
/*  653 */     this.gameSyncLoader.addTask(new GameSyncLoader.Task("Gates", () -> {
/*      */             this.gateManager = new GateManager();
/*      */             this.managers.add(this.gateManager);
/*      */           }));
/*  657 */     b1++;
/*      */     
/*  659 */     this.gameSyncLoader.addTask(new GameSyncLoader.Task("Http", () -> {
/*      */             this.httpManager = new HttpManager();
/*      */             this.managers.add(this.httpManager);
/*      */           }));
/*  663 */     b1++;
/*      */     
/*  665 */     if (!Config.isHeadless()) {
/*  666 */       this.gameSyncLoader.addTask(new GameSyncLoader.Task("Locales", () -> {
/*      */               this.localeManager = new LocaleManager();
/*      */               this.managers.add(this.localeManager);
/*      */             }));
/*  670 */       b1++;
/*      */     } 
/*      */     
/*  673 */     if (!Config.isHeadless()) {
/*  674 */       this.gameSyncLoader.addTask(new GameSyncLoader.Task("Payments", () -> {
/*      */               this.purchaseManager = new PurchaseManager();
/*      */               this.managers.add(this.purchaseManager);
/*      */             }));
/*  678 */       b1++;
/*      */     } 
/*      */     
/*  681 */     this.gameSyncLoader.addTask(new GameSyncLoader.Task("Items", () -> {
/*      */             this.itemManager = new ItemManager();
/*      */             this.managers.add(this.itemManager);
/*      */           }));
/*  685 */     b1++;
/*      */     
/*  687 */     this.gameSyncLoader.addTask(new GameSyncLoader.Task("Basic levels", () -> {
/*      */             this.basicLevelManager = new BasicLevelManager();
/*      */             this.managers.add(this.basicLevelManager);
/*      */           }));
/*  691 */     b1++;
/*      */     
/*  693 */     this.gameSyncLoader.addTask(new GameSyncLoader.Task("Buffs", () -> {
/*      */             this.buffManager = new BuffManager();
/*      */             this.managers.add(this.buffManager);
/*      */           }));
/*  697 */     b1++;
/*      */     
/*  699 */     if (!Config.isHeadless()) {
/*  700 */       this.gameSyncLoader.addTask(new GameSyncLoader.Task("Custom maps", () -> {
/*      */               this.userMapManager = new UserMapManager();
/*      */               this.managers.add(this.userMapManager);
/*      */             }));
/*  704 */       b1++;
/*      */     } 
/*      */     
/*  707 */     this.gameSyncLoader.addTask(new GameSyncLoader.Task("Researches", () -> {
/*      */             this.researchManager = new ResearchManager();
/*      */             this.managers.add(this.researchManager);
/*      */           }));
/*  711 */     b1++;
/*      */     
/*  713 */     this.gameSyncLoader.addTask(new GameSyncLoader.Task("Triggered actions", () -> {
/*      */             this.triggeredActionManager = new TriggeredActionManager();
/*      */             this.managers.add(this.triggeredActionManager);
/*      */           }));
/*  717 */     b1++;
/*      */     
/*  719 */     this.gameSyncLoader.addTask(new GameSyncLoader.Task("Trophies", () -> {
/*      */             this.trophyManager = new TrophyManager();
/*      */             this.managers.add(this.trophyManager);
/*      */           }));
/*  723 */     b1++;
/*      */     
/*  725 */     this.gameSyncLoader.addTask(new GameSyncLoader.Task("Daily quests", () -> {
/*      */             this.dailyQuestManager = new DailyQuestManager();
/*      */             this.managers.add(this.dailyQuestManager);
/*      */           }));
/*  729 */     b1++;
/*      */     
/*  731 */     this.gameSyncLoader.addTask(new GameSyncLoader.Task("Resources", () -> {
/*      */             this.resourceManager = new ResourceManager();
/*      */             this.managers.add(this.resourceManager);
/*      */           }));
/*  735 */     b1++;
/*      */     
/*  737 */     if (!Config.isHeadless()) {
/*  738 */       this.gameSyncLoader.addTask(new GameSyncLoader.Task("Secrets", () -> {
/*      */               this.secretCodeManager = new SecretCodeManager();
/*      */               this.managers.add(this.secretCodeManager);
/*      */             }));
/*  742 */       b1++;
/*      */       
/*  744 */       this.gameSyncLoader.addTask(new GameSyncLoader.Task("Ratings", () -> {
/*      */               this.ratingManager = new RatingManager();
/*      */               this.managers.add(this.ratingManager);
/*      */             }));
/*  748 */       b1++;
/*      */     } 
/*      */     
/*  751 */     this.gameSyncLoader.addTask(new GameSyncLoader.Task("Tower stats", () -> {
/*      */             this.towerStatManager = new TowerStatManager();
/*      */             this.managers.add(this.towerStatManager);
/*      */           }));
/*  755 */     b1++;
/*      */     
/*  757 */     if (!Config.isHeadless()) {
/*  758 */       this.gameSyncLoader.addTask(new GameSyncLoader.Task("UI", () -> {
/*      */               this.uiManager = new UiManager();
/*      */               this.managers.add(this.uiManager);
/*      */             }));
/*  762 */       b1++;
/*      */     } 
/*      */     
/*  765 */     if (!Config.isHeadless()) {
/*  766 */       this.gameSyncLoader.addTask(new GameSyncLoader.Task("Debug", () -> {
/*      */               this.debugManager = new DebugManager();
/*      */               this.managers.add(this.debugManager);
/*      */             }));
/*  770 */       b1++;
/*      */     } 
/*      */     
/*  773 */     this.gameSyncLoader.addTask(new GameSyncLoader.Task("Scripts", () -> {
/*      */             this.scriptManager = new ScriptManager();
/*      */             this.managers.add(this.scriptManager);
/*      */           }));
/*  777 */     b1++;
/*      */     
/*  779 */     if (!Config.isHeadless()) {
/*  780 */       this.gameSyncLoader.addTask(new GameSyncLoader.Task("Messages", () -> {
/*      */               this.messageManager = new MessageManager();
/*      */               this.managers.add(this.messageManager);
/*      */             }));
/*  784 */       b1++;
/*      */     } 
/*      */ 
/*      */     
/*  788 */     for (byte b2 = 0; b2 < b1; b2++) {
/*  789 */       byte b = b2;
/*  790 */       this.gameSyncLoader.addTask(new GameSyncLoader.Task("Setting up managers (" + (b2 + 1) + "/" + b1 + ")", () -> {
/*      */               a.i("setting up manager " + (paramInt + 1) + "/" + this.managers.size + " (" + ((Manager)this.managers.get(paramInt)).getClass().getSimpleName() + ")", new Object[0]);
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               ((Manager)this.managers.get(paramInt)).setup();
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               SyncChecker.addSyncShareableObject(this.managers.get(paramInt));
/*      */             }));
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  808 */     this.gameSyncLoader.addListener(new GameSyncLoader.SyncExecutionListener(this, l)
/*      */         {
/*      */           public void startedTask(GameSyncLoader.Task param1Task1, GameSyncLoader.Task param1Task2) {
/*  811 */             Game.a().i("loading: " + param1Task1.title, new Object[0]);
/*      */           }
/*      */ 
/*      */           
/*      */           public void done() {
/*  816 */             Game.a(this.b, true);
/*  817 */             Game.EVENTS.trigger((Event)new GameLoad());
/*      */             
/*  819 */             Game.a().d("game loaded in " + ((float)(Game.getTimestampMillis() - this.a) * 0.001F) + "s", new Object[0]);
/*      */           }
/*      */         });
/*      */     
/*  823 */     EVENTS.trigger((Event)new GameStartLoad());
/*      */   }
/*      */ 
/*      */   
/*      */   public void pause() {
/*  828 */     super.pause();
/*  829 */     a.i("Paused", new Object[0]);
/*      */   }
/*      */ 
/*      */   
/*      */   public void resume() {
/*  834 */     super.resume();
/*  835 */     a.i("Resumed", new Object[0]);
/*      */   }
/*      */   
/*      */   public boolean isDisposed() {
/*  839 */     return this.c;
/*      */   }
/*      */ 
/*      */   
/*      */   public void dispose() {
/*  844 */     a.i("Dispose", new Object[0]);
/*      */     
/*  846 */     if (this.c) {
/*  847 */       a.i("skip dispose - already disposed", new Object[0]);
/*      */       
/*      */       return;
/*      */     } 
/*  851 */     if (i != null && i.actionResolver != null) {
/*  852 */       i.actionResolver.onExit();
/*      */     }
/*      */     
/*  855 */     this.c = true;
/*      */     
/*  857 */     super.dispose();
/*      */     
/*  859 */     EVENTS.trigger((Event)new GameDispose());
/*      */     
/*  861 */     if (isLoaded()) {
/*  862 */       for (Array.ArrayIterator<Manager> arrayIterator = this.managers.iterator(); arrayIterator.hasNext();) {
/*  863 */         (manager = arrayIterator.next()).dispose();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long getRealTickCount() {
/*  872 */     return TimeUtils.nanoTime() / 1000L - b;
/*      */   }
/*      */   
/*      */   public static int getTimestampSeconds() {
/*  876 */     return (int)(TimeUtils.millis() / 1000L);
/*      */   }
/*      */   
/*      */   public static long getTimestampMillis() {
/*  880 */     return TimeUtils.millis();
/*      */   }
/*      */   
/*      */   public long getMillisTillGameStart() {
/*  884 */     return getTimestampMillis() - this.h;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void notifyVisibleDisplayFrameChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  895 */     a.d("notifyVisibleDisplayFrameChanged %s %s %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
/*  896 */     this.d = true;
/*  897 */     this.e.set(paramInt1, paramInt2, paramInt4, paramInt3);
/*      */     
/*  899 */     EVENTS.trigger((Event)new VisibleDisplayFrameChange());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public IntRectangle getVisibleDisplayFrame() {
/*  906 */     if (this.d) {
/*  907 */       return this.e;
/*      */     }
/*  909 */     this.e.set(0, 0, 0, 0);
/*      */ 
/*      */     
/*  912 */     return this.e;
/*      */   }
/*      */ 
/*      */   
/*      */   public Game(ActionResolver paramActionResolver, @Null Runnable paramRunnable) {
/*  917 */     this.k = 0;
/*  918 */     this.l = -1L; System.out.println("bootstrapping..."); Preconditions.checkNotNull(paramActionResolver, "actionResolver can not be null"); i = this; SyncChecker.addSyncShareableObject(this); this.actionResolver = paramActionResolver; this.f = (() -> {
/*      */         EVENTS.reset(false); CrashHandler.setActionResolver(paramActionResolver); Logger.init(paramActionResolver);
/*      */         if (paramRunnable != null)
/*      */           paramRunnable.run(); 
/*  922 */       }); } public void render() { if (Config.isHeadless())
/*      */       return; 
/*  924 */     long l = getTimestampMillis();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  932 */     StartRender startRender = (new StartRender()).setDeltaTime(Gdx.graphics.getDeltaTime());
/*  933 */     EVENTS.trigger((Event)startRender);
/*  934 */     float f = startRender.getDeltaTime();
/*      */ 
/*      */     
/*  937 */     if (i.settingsManager != null && Gdx.input.isKeyJustPressed(141)) {
/*  938 */       if (Gdx.input.isKeyPressed(59)) {
/*      */         
/*  940 */         Gdx.graphics.setUndecorated(false);
/*  941 */         if (Gdx.input.isKeyPressed(129)) {
/*      */           
/*  943 */           Gdx.graphics.setWindowedMode(1440, 1080);
/*      */         } else {
/*      */           
/*  946 */           Gdx.graphics.setWindowedMode(960, 540);
/*      */         } 
/*  948 */       } else if (Gdx.input.isKeyPressed(129)) {
/*      */         
/*  950 */         Gdx.graphics.setUndecorated(false);
/*  951 */         Gdx.graphics.setWindowedMode(1920, 1080);
/*      */       
/*      */       }
/*  954 */       else if (i.actionResolver.getInitConfigManager().get(SettingsManager.InitConfig.GRAPHICS_FS_ENABLED) == 0) {
/*      */         
/*  956 */         int i = i.actionResolver.getInitConfigManager().get(SettingsManager.InitConfig.GRAPHICS_FS_WIDTH);
/*  957 */         int j = i.actionResolver.getInitConfigManager().get(SettingsManager.InitConfig.GRAPHICS_FS_HEIGHT);
/*      */         Graphics.DisplayMode displayMode;
/*  959 */         if ((displayMode = SettingsManager.getBestFullscreenMode(i, j)) != null) {
/*  960 */           if (i.actionResolver.getInitConfigManager().get(SettingsManager.InitConfig.GRAPHICS_FS_BORDERLESS) == 0) {
/*  961 */             Gdx.graphics.setUndecorated(false);
/*  962 */             Gdx.graphics.setFullscreenMode(displayMode);
/*      */           } else {
/*  964 */             Gdx.graphics.setUndecorated(true);
/*  965 */             Gdx.graphics.setWindowedMode(displayMode.width, displayMode.height);
/*      */           } 
/*      */           
/*      */           try {
/*  969 */             if (i.actionResolver.getInitConfigManager().get(SettingsManager.InitConfig.GRAPHICS_FS_ENABLED) == 0) {
/*  970 */               i.actionResolver.getInitConfigManager().set(SettingsManager.InitConfig.GRAPHICS_FS_ENABLED, 1);
/*  971 */               i.actionResolver.getInitConfigManager().saveIfRequired();
/*      */             } 
/*  973 */           } catch (Exception exception) {}
/*      */         } 
/*      */       } else {
/*  976 */         Gdx.graphics.setUndecorated(false);
/*  977 */         Gdx.graphics.setWindowedMode(1600, 900);
/*      */         
/*      */         try {
/*  980 */           if (i.actionResolver.getInitConfigManager().get(SettingsManager.InitConfig.GRAPHICS_FS_ENABLED) == 1) {
/*  981 */             i.actionResolver.getInitConfigManager().set(SettingsManager.InitConfig.GRAPHICS_FS_ENABLED, 0);
/*  982 */             i.actionResolver.getInitConfigManager().saveIfRequired();
/*      */           } 
/*  984 */         } catch (Exception exception) {}
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*  989 */     if (isLoaded() && i.uiManager != null && i.uiManager.isComponentInit(DeveloperConsole.class) && 
/*  990 */       Gdx.input.isKeyJustPressed(68)) {
/*  991 */       DeveloperConsole.i().toggleVisible();
/*      */     }
/*      */ 
/*      */     
/*  995 */     if (this.g) {
/*  996 */       EVENTS.trigger((Event)new PreRender(f));
/*      */       
/*  998 */       for (Array.ArrayIterator<Manager> arrayIterator = this.managers.iterator(); arrayIterator.hasNext();) {
/*  999 */         (manager = arrayIterator.next()).preRender(f);
/*      */       }
/*      */     } 
/*      */     
/* 1003 */     super.render();
/*      */     
/* 1005 */     EVENTS.trigger((Event)new Render(f));
/*      */     
/* 1007 */     if (this.g) {
/* 1008 */       this.uiManager.render(f);
/*      */       
/* 1010 */       for (Array.ArrayIterator<Manager> arrayIterator = this.managers.iterator(); arrayIterator.hasNext();) {
/* 1011 */         (manager = arrayIterator.next()).postRender(f);
/*      */       }
/*      */       
/* 1014 */       EVENTS.trigger((Event)new PostRender(f));
/*      */     } 
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1069 */     Threads.i().a();
/*      */     
/* 1071 */     if (this.k < 1000) {
/* 1072 */       this.k++;
/*      */       
/* 1074 */       long l1, l2 = (l1 = getTimestampMillis()) - l;
/* 1075 */       long l3 = 0L;
/* 1076 */       if (this.l != -1L) {
/* 1077 */         l3 = l1 - this.l;
/*      */       }
/* 1079 */       if (l2 > 50L || l3 > 50L) {
/* 1080 */         a.d("profiling - frame " + this.k + " took " + l2 + "ms, " + l3 + "ms since last frame", new Object[0]);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1088 */       this.l = getTimestampMillis();
/*      */     }  }
/*      */ 
/*      */ 
/*      */   
/*      */   public void resize(int paramInt1, int paramInt2) {
/* 1094 */     if (paramInt1 > 0 && paramInt2 > 0) {
/* 1095 */       EVENTS.trigger((Event)new ScreenResize(paramInt1, paramInt2));
/*      */     }
/*      */     
/* 1098 */     super.resize(paramInt1, paramInt2);
/*      */   }
/*      */   
/*      */   public static long getFreeHeapSpaceSize() {
/* 1102 */     return Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\Game.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */