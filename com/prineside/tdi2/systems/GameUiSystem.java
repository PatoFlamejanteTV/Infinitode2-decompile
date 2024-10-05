/*     */ package com.prineside.tdi2.systems;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystem;
/*     */ import com.prineside.tdi2.configs.GameRenderingOrder;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.actors.PanZoomTooltip;
/*     */ import com.prineside.tdi2.ui.actors.ScreenBorderGradient;
/*     */ import com.prineside.tdi2.ui.actors.SideMenu;
/*     */ import com.prineside.tdi2.ui.components.AbilityMenu;
/*     */ import com.prineside.tdi2.ui.components.BossTileMenu;
/*     */ import com.prineside.tdi2.ui.components.BuildMenu;
/*     */ import com.prineside.tdi2.ui.components.CoreMenu;
/*     */ import com.prineside.tdi2.ui.components.FlyingItemsOverlay;
/*     */ import com.prineside.tdi2.ui.components.GameOverOverlay;
/*     */ import com.prineside.tdi2.ui.components.GameStateEditor;
/*     */ import com.prineside.tdi2.ui.components.GameValueMenu;
/*     */ import com.prineside.tdi2.ui.components.GameplayBonusesOverlay;
/*     */ import com.prineside.tdi2.ui.components.GateMenu;
/*     */ import com.prineside.tdi2.ui.components.LiveLeaderboard;
/*     */ import com.prineside.tdi2.ui.components.MainUi;
/*     */ import com.prineside.tdi2.ui.components.MinerMenu;
/*     */ import com.prineside.tdi2.ui.components.ModifierMenu;
/*     */ import com.prineside.tdi2.ui.components.NewEnemyOverlay;
/*     */ import com.prineside.tdi2.ui.components.PauseMenu;
/*     */ import com.prineside.tdi2.ui.components.QuestList;
/*     */ import com.prineside.tdi2.ui.components.RoadMenu;
/*     */ import com.prineside.tdi2.ui.components.SpawnMenu;
/*     */ import com.prineside.tdi2.ui.components.StatisticsChart;
/*     */ import com.prineside.tdi2.ui.components.StorylineMessages;
/*     */ import com.prineside.tdi2.ui.components.Subtitles;
/*     */ import com.prineside.tdi2.ui.components.TargetMenu;
/*     */ import com.prineside.tdi2.ui.components.Tooltip;
/*     */ import com.prineside.tdi2.ui.components.TowerMenu;
/*     */ import com.prineside.tdi2.ui.components.UiElementsEmphasizer;
/*     */ import com.prineside.tdi2.ui.components.XmMusicTrackMenu;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ 
/*     */ @NAGS
/*     */ public final class GameUiSystem
/*     */   extends GameSystem
/*     */ {
/*     */   public ScreenBorderGradient screenBorderGradient;
/*     */   public PauseMenu pauseMenu;
/*     */   public MainUi mainUi;
/*     */   public QuestList questList;
/*     */   public StatisticsChart _statisticsChart;
/*     */   public GameStateEditor _stateEditor;
/*     */   public LiveLeaderboard liveLeaderboard;
/*     */   public AbilityMenu abilityMenu;
/*     */   public SideMenu sideMenu;
/*     */   public TowerMenu towerMenu;
/*     */   public RoadMenu roadMenu;
/*     */   public ModifierMenu modifierMenu;
/*     */   public MinerMenu minerMenu;
/*     */   public BuildMenu buildMenu;
/*     */   public SpawnMenu spawnMenu;
/*     */   public TargetMenu targetMenu;
/*     */   public BossTileMenu bossTileMenu;
/*     */   public CoreMenu coreMenu;
/*     */   public GameValueMenu gameValueMenu;
/*     */   public XmMusicTrackMenu xmMusicTrackMenu;
/*     */   public GateMenu gateMenu;
/*     */   public StorylineMessages storylineMessages;
/*     */   public Subtitles subtitles;
/*     */   public PanZoomTooltip panZoomTooltip;
/*     */   public UiElementsEmphasizer uiElementsEmphasizer;
/*     */   public GameplayBonusesOverlay gameplayBonusesOverlay;
/*     */   public NewEnemyOverlay newEnemyOverlay;
/*     */   public Tooltip tooltip;
/*     */   public GameOverOverlay gameOverOverlay;
/*     */   public FlyingItemsOverlay flyingItemsOverlay;
/*     */   
/*     */   public final boolean affectsGameState() {
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public final boolean profileUpdate() {
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public final String getSystemName() {
/*  88 */     return "GameUi";
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setup() {
/*  93 */     this.pauseMenu = new PauseMenu(this.S);
/*  94 */     this.mainUi = new MainUi(this.S);
/*  95 */     this.screenBorderGradient = new ScreenBorderGradient();
/*     */     
/*  97 */     this.sideMenu = new SideMenu(600.0F);
/*     */     
/*  99 */     this.roadMenu = new RoadMenu(this.sideMenu, this.S);
/* 100 */     this.towerMenu = new TowerMenu(this.sideMenu, this.S);
/* 101 */     this.modifierMenu = new ModifierMenu(this.sideMenu, this.S);
/* 102 */     this.minerMenu = new MinerMenu(this.sideMenu, this.S);
/* 103 */     this.buildMenu = new BuildMenu(this.sideMenu, this.S);
/* 104 */     this.spawnMenu = new SpawnMenu(this.sideMenu, this.S);
/* 105 */     this.targetMenu = new TargetMenu(this.sideMenu, this.S);
/* 106 */     this.bossTileMenu = new BossTileMenu(this.sideMenu, this.S);
/* 107 */     this.coreMenu = new CoreMenu(this.sideMenu, this.S);
/* 108 */     this.gameValueMenu = new GameValueMenu(this.sideMenu, this.S);
/* 109 */     this.xmMusicTrackMenu = new XmMusicTrackMenu(this.sideMenu, this.S);
/* 110 */     this.gateMenu = new GateMenu(this.sideMenu, this.S);
/*     */     
/*     */     Image image;
/*     */     
/* 114 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("ui-tile-menu-background"))).setSize(600.0F, Game.i.settingsManager.getScaledViewportHeight());
/*     */     
/* 116 */     image.setTouchable(Touchable.disabled);
/* 117 */     this.sideMenu.getBackgroundContainer().addActor((Actor)image);
/*     */     
/* 119 */     this.sideMenu.addOffscreenBackground();
/*     */     
/* 121 */     this.questList = new QuestList();
/* 122 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.STATISTICS_CHART_ENABLED) != 0.0D) this._statisticsChart = new StatisticsChart(this.S); 
/* 123 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.STATE_EDITOR_ENABLED) != 0.0D) {
/* 124 */       this._stateEditor = new GameStateEditor(this.S);
/*     */     }
/* 126 */     this.liveLeaderboard = new LiveLeaderboard(this.S);
/* 127 */     this.abilityMenu = new AbilityMenu(this.S);
/*     */     
/* 129 */     this.storylineMessages = new StorylineMessages(this.S);
/* 130 */     this.subtitles = new Subtitles();
/* 131 */     this.panZoomTooltip = new PanZoomTooltip();
/* 132 */     this.flyingItemsOverlay = new FlyingItemsOverlay(this.S);
/* 133 */     this.uiElementsEmphasizer = new UiElementsEmphasizer(this.S);
/* 134 */     this.gameplayBonusesOverlay = new GameplayBonusesOverlay(this.S);
/* 135 */     this.newEnemyOverlay = new NewEnemyOverlay(this.S);
/* 136 */     this.tooltip = new Tooltip();
/* 137 */     this.gameOverOverlay = new GameOverOverlay(this.S);
/*     */     
/* 139 */     this.S._render.addLayer((new RenderSystem.Layer(GameRenderingOrder.GAME_UI_DRAW, false, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> draw(paramFloat1)))
/*     */ 
/*     */         
/* 142 */         .setName("Graphics-draw"));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void postSetup() {
/* 148 */     this.mainUi.postSetup();
/* 149 */     this.buildMenu.postSetup();
/*     */   }
/*     */   
/*     */   public final MainUi getMainUi() {
/* 153 */     return this.mainUi;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void fadeOutUi() {
/* 161 */     this.mainUi.finalFadeOut();
/* 162 */     this.questList.finalFadeOut();
/* 163 */     this.liveLeaderboard.finalFadeOut();
/* 164 */     this.sideMenu.finalFadeOut();
/* 165 */     this.abilityMenu.finalFadeOut();
/* 166 */     this.subtitles.finalFadeOut();
/* 167 */     this.gameplayBonusesOverlay.hide();
/* 168 */     if (this._statisticsChart != null) this._statisticsChart.finalFadeOut(); 
/*     */   }
/*     */   
/*     */   public final void setUiScreenshotMode(ScreenshotModeConfig paramScreenshotModeConfig) {
/* 172 */     this.mainUi.setUiScreenshotMode(paramScreenshotModeConfig);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void draw(float paramFloat) {
/* 178 */     if (this.towerMenu.isVisible()) this.towerMenu.draw(paramFloat); 
/* 179 */     if (this.modifierMenu.isVisible()) this.modifierMenu.draw(paramFloat); 
/* 180 */     this.minerMenu.draw(paramFloat);
/* 181 */     this.mainUi.draw(paramFloat);
/* 182 */     this.abilityMenu.draw(paramFloat);
/* 183 */     this.targetMenu.draw(paramFloat);
/* 184 */     this.coreMenu.draw(paramFloat);
/* 185 */     this.subtitles.draw(paramFloat);
/* 186 */     if (this._statisticsChart != null) this._statisticsChart.draw(paramFloat); 
/* 187 */     if (this._stateEditor != null) this._stateEditor.draw(paramFloat);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void dispose() {
/* 196 */     this.screenBorderGradient.dispose();
/* 197 */     this.pauseMenu.dispose();
/* 198 */     this.mainUi.dispose();
/* 199 */     this.sideMenu.dispose();
/* 200 */     this.abilityMenu.dispose();
/*     */     
/* 202 */     this.towerMenu.dispose();
/* 203 */     this.roadMenu.dispose();
/* 204 */     this.modifierMenu.dispose();
/* 205 */     this.minerMenu.dispose();
/* 206 */     this.buildMenu.dispose();
/* 207 */     this.spawnMenu.dispose();
/* 208 */     this.xmMusicTrackMenu.dispose();
/* 209 */     this.gateMenu.dispose();
/*     */     
/* 211 */     if (this._statisticsChart != null) this._statisticsChart.dispose(); 
/* 212 */     if (this._stateEditor != null) this._stateEditor.dispose(); 
/* 213 */     this.questList.dispose();
/* 214 */     this.liveLeaderboard.dispose();
/* 215 */     this.storylineMessages.dispose();
/* 216 */     this.subtitles.dispose();
/* 217 */     this.panZoomTooltip.dispose();
/* 218 */     this.flyingItemsOverlay.dispose();
/* 219 */     this.uiElementsEmphasizer.dispose();
/* 220 */     this.newEnemyOverlay.dispose();
/* 221 */     this.tooltip.dispose();
/* 222 */     this.gameOverOverlay.dispose();
/* 223 */     this.gameplayBonusesOverlay.dispose();
/*     */     
/* 225 */     this.screenBorderGradient = null;
/* 226 */     this.pauseMenu = null;
/* 227 */     this.mainUi = null;
/* 228 */     this.questList = null;
/* 229 */     this._statisticsChart = null;
/* 230 */     this._stateEditor = null;
/* 231 */     this.liveLeaderboard = null;
/* 232 */     this.gameplayBonusesOverlay = null;
/*     */     
/* 234 */     this.abilityMenu = null;
/* 235 */     this.sideMenu = null;
/* 236 */     this.towerMenu = null;
/* 237 */     this.roadMenu = null;
/* 238 */     this.modifierMenu = null;
/* 239 */     this.minerMenu = null;
/* 240 */     this.buildMenu = null;
/* 241 */     this.spawnMenu = null;
/* 242 */     this.targetMenu = null;
/* 243 */     this.bossTileMenu = null;
/* 244 */     this.gameValueMenu = null;
/* 245 */     this.coreMenu = null;
/* 246 */     this.xmMusicTrackMenu = null;
/* 247 */     this.gateMenu = null;
/* 248 */     this.storylineMessages = null;
/* 249 */     this.subtitles = null;
/* 250 */     this.panZoomTooltip = null;
/* 251 */     this.flyingItemsOverlay = null;
/* 252 */     this.uiElementsEmphasizer = null;
/* 253 */     this.newEnemyOverlay = null;
/* 254 */     this.tooltip = null;
/* 255 */     this.gameOverOverlay = null;
/*     */     
/* 257 */     super.dispose();
/*     */   }
/*     */   
/*     */   public static class ScreenshotModeConfig {}
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\systems\GameUiSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */