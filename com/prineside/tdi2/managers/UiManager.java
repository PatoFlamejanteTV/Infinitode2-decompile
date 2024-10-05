/*     */ package com.prineside.tdi2.managers;
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.Input;
/*     */ import com.badlogic.gdx.InputProcessor;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.badlogic.gdx.utils.ObjectSet;
/*     */ import com.badlogic.gdx.utils.SnapshotArray;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.badlogic.gdx.utils.viewport.ScreenViewport;
/*     */ import com.badlogic.gdx.utils.viewport.Viewport;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Manager;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.events.global.GameLoad;
/*     */ import com.prineside.tdi2.events.global.ScreenResize;
/*     */ import com.prineside.tdi2.events.global.VisibleDisplayFrameChange;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.Stage;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.scene2d.utils.FocusListener;
/*     */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*     */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*     */ import com.prineside.tdi2.ui.actors.HighlightActor;
/*     */ import com.prineside.tdi2.ui.actors.Window;
/*     */ import com.prineside.tdi2.ui.shared.DeveloperConsole;
/*     */ import com.prineside.tdi2.ui.shared.InventoryOverlay;
/*     */ import com.prineside.tdi2.ui.shared.TextInputOverlay;
/*     */ import com.prineside.tdi2.ui.shared.WebBrowser;
/*     */ import com.prineside.tdi2.utils.InputVoid;
/*     */ import com.prineside.tdi2.utils.IntRectangle;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.ReflectionUtils;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.util.Comparator;
/*     */ 
/*     */ @REGS(serializer = UiManager.Serializer.class)
/*     */ public final class UiManager extends Manager.ManagerAdapter {
/*  55 */   private static final TLog a = TLog.forClass(UiManager.class); private static final Comparator<UiLayer> b; public final ScreenViewport viewport;
/*     */   public final Stage stage;
/*     */   
/*     */   public static class Serializer extends SingletonSerializer<UiManager> { public UiManager read() {
/*  59 */       return Game.i.uiManager;
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @REGS
/*     */   public enum MainUiLayer
/*     */   {
/*  68 */     SCREEN,
/*  69 */     SHARED_COMPONENTS,
/*  70 */     OVERLAY; static {
/*     */     
/*  72 */     } public static final MainUiLayer[] values = values(); }
/*     */   
/*     */   static {
/*  75 */     b = ((paramUiLayer1, paramUiLayer2) -> (paramUiLayer1.zIndex == paramUiLayer2.zIndex) ? 0 : ((paramUiLayer1.zIndex < paramUiLayer2.zIndex) ? -1 : 1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  84 */   public final Array<UiLayer>[] layers = (Array<UiLayer>[])new Array[MainUiLayer.values.length];
/*     */   
/*  86 */   public final Group[] mainLayerGroups = new Group[MainUiLayer.values.length];
/*     */   
/*     */   private final UiLayer c;
/*     */   
/*     */   private final UiLayer d;
/*     */   
/*  92 */   private final ObjectMap<Class<? extends UiComponent>, UiComponent> e = new ObjectMap();
/*  93 */   private final Array<UiComponent> f = new Array(true, 1, UiComponent.class);
/*     */   
/*  95 */   private final Array<Runnable> g = new Array(true, 1, Runnable.class); private final UiLayer h; private final Group i; private int j; private float k;
/*     */   public ParticleEffectPool itemCellFlashParticles;
/*     */   
/*     */   public final <T extends UiComponent> T getComponent(Class<T> paramClass) {
/*     */     UiComponent uiComponent;
/* 100 */     if ((uiComponent = (UiComponent)this.e.get(paramClass)) == null) {
/*     */       
/*     */       try {
/* 103 */         uiComponent = (UiComponent)ReflectionUtils.newObject(paramClass);
/* 104 */         this.e.put(paramClass, uiComponent);
/* 105 */         this.f.add(uiComponent);
/*     */ 
/*     */       
/*     */       }
/* 109 */       catch (Exception exception) {
/* 110 */         throw new IllegalArgumentException("Unable to initialize UI component instance for type '" + paramClass + "'", exception);
/*     */       } 
/*     */     }
/*     */     
/* 114 */     return (T)exception;
/*     */   }
/*     */   
/*     */   public final <T extends UiComponent> boolean isComponentInit(Class<T> paramClass) {
/* 118 */     return this.e.containsKey(paramClass);
/*     */   }
/*     */ 
/*     */   
/*     */   public final <T extends UiComponent> void disposeComponent(Class<T> paramClass) {
/*     */     UiComponent uiComponent;
/* 124 */     if ((uiComponent = (UiComponent)this.e.get(paramClass)) != null) {
/* 125 */       uiComponent.dispose();
/* 126 */       this.e.remove(paramClass);
/* 127 */       this.f.removeValue(uiComponent, true);
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
/* 141 */   private Drawable[][] l = new Drawable[2][RarityType.values.length];
/* 142 */   private Drawable[][] m = new Drawable[2][RarityType.values.length];
/* 143 */   public Drawable[] itemCellShapes = new Drawable[2];
/*     */ 
/*     */   
/* 146 */   private final _ScreenManagerListener n = new _ScreenManagerListener((byte)0);
/*     */   
/* 148 */   private final boolean[] o = new boolean[256];
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UiManager() {
/* 154 */     this.viewport = new ScreenViewport();
/* 155 */     this.stage = new Stage(this, (Viewport)this.viewport, (Batch)Game.i.renderingManager.batch)
/*     */       {
/*     */         private int c;
/*     */         private int d;
/*     */         private int e;
/*     */         private boolean f;
/*     */         
/*     */         public boolean keyDown(int param1Int) {
/* 163 */           if (param1Int < (UiManager.a(this.g)).length) {
/* 164 */             UiManager.a(this.g)[param1Int] = true;
/*     */           }
/* 166 */           return super.keyDown(param1Int);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean keyUp(int param1Int) {
/* 171 */           if (param1Int < (UiManager.a(this.g)).length) {
/* 172 */             UiManager.a(this.g)[param1Int] = false;
/*     */           }
/* 174 */           return super.keyUp(param1Int);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean touchDown(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 179 */           Vector2 vector2 = new Vector2(param1Int1, param1Int2);
/* 180 */           screenToStageCoordinates(vector2);
/*     */           
/* 182 */           this.c = param1Int1;
/* 183 */           this.d = param1Int2;
/* 184 */           this.e = 0;
/* 185 */           this.f = this.g.stage.hit(vector2.x, vector2.y, true) instanceof com.prineside.tdi2.scene2d.ui.TextField;
/*     */           
/* 187 */           return super.touchDown(param1Int1, param1Int2, param1Int3, param1Int4);
/*     */         }
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
/*     */         public boolean touchDragged(int param1Int1, int param1Int2, int param1Int3) {
/* 207 */           this.e += Math.abs(param1Int1 - this.c);
/* 208 */           this.e += Math.abs(param1Int2 - this.d);
/* 209 */           return super.touchDragged(param1Int1, param1Int2, param1Int3);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean touchUp(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 214 */           if (!this.f) {
/*     */             Actor actor;
/* 216 */             if (this.e < 14 && 
/*     */               
/* 218 */               actor = this.g.stage.getKeyboardFocus() instanceof com.prineside.tdi2.scene2d.ui.TextField) {
/*     */               
/* 220 */               Vector2 vector2 = this.g.stage.screenToStageCoordinates(new Vector2(param1Int1, param1Int2));
/*     */               Actor actor1;
/* 222 */               if (!(actor1 = this.g.stage.hit(vector2.x, vector2.y, true) instanceof com.prineside.tdi2.scene2d.ui.TextField))
/*     */               {
/*     */ 
/*     */                 
/* 226 */                 this.g.stage.setKeyboardFocus(null);
/*     */               }
/*     */             } 
/*     */           } 
/*     */           
/* 231 */           return super.touchUp(param1Int1, param1Int2, param1Int3, param1Int4);
/*     */         }
/*     */       };
/*     */     
/* 235 */     this.stage.getRoot().setTransform(false);
/*     */ 
/*     */     
/* 238 */     this.stage.addListener((EventListener)new FocusListener(this)
/*     */         {
/*     */           public void keyboardFocusChanged(FocusListener.FocusEvent param1FocusEvent, Actor param1Actor, boolean param1Boolean) {
/* 241 */             if (!param1Boolean) {
/* 242 */               Gdx.input.setOnscreenKeyboardVisible(false);
/*     */             }
/*     */           }
/*     */         });
/*     */     
/* 247 */     if (Gdx.app.getType() == Application.ApplicationType.iOS)
/*     */     {
/* 249 */       Gdx.input.setKeyboardHeightObserver(new Input.KeyboardHeightObserver(this)
/*     */           {
/*     */             public void onKeyboardHeightChanged(int param1Int) {
/* 252 */               UiManager.a().d("onKeyboardHeightChanged %s %s %s", new Object[] { Integer.valueOf(param1Int), Integer.valueOf(Gdx.graphics.getHeight() - param1Int), Float.valueOf(Gdx.graphics.getDensity()) });
/* 253 */               Game.i.notifyVisibleDisplayFrameChanged(0, 0, 0, param1Int);
/*     */             }
/*     */           }); } 
/*     */     MainUiLayer[] arrayOfMainUiLayer;
/*     */     int i;
/*     */     byte b;
/* 259 */     for (i = (arrayOfMainUiLayer = MainUiLayer.values).length, b = 0; b < i; ) { MainUiLayer mainUiLayer = arrayOfMainUiLayer[b];
/*     */       Group group;
/* 261 */       (group = new Group()).setName("main_ui_layer_" + mainUiLayer.name());
/* 262 */       group.setTransform(false);
/* 263 */       group.setTouchable(Touchable.childrenOnly);
/* 264 */       this.mainLayerGroups[mainUiLayer.ordinal()] = group;
/* 265 */       this.stage.addActor((Actor)group);
/*     */       
/* 267 */       this.layers[mainUiLayer.ordinal()] = new Array(UiLayer.class);
/*     */       b++; }
/*     */     
/* 270 */     this.j = Gdx.input.getRotation();
/*     */ 
/*     */     
/* 273 */     this.h = addLayer(MainUiLayer.SCREEN, 110, "Highlight actors");
/* 274 */     this.i = new Group();
/* 275 */     this.i.setTransform(false);
/* 276 */     this.i.setTouchable(Touchable.childrenOnly);
/* 277 */     this.h.getTable().add((Actor)this.i).expand().fill();
/*     */ 
/*     */     
/* 280 */     this.d = addLayer(MainUiLayer.OVERLAY, 990000, "UiManager windows layer");
/* 281 */     this.c = addLayer(MainUiLayer.OVERLAY, 1000000, "UiManager safe area");
/*     */     
/* 283 */     this.itemCellFlashParticles = Game.i.assetManager.getParticleEffectPool("item-cell.prt");
/*     */     RarityType[] arrayOfRarityType;
/* 285 */     for (i = (arrayOfRarityType = RarityType.values).length, b = 0; b < i; ) { RarityType rarityType = arrayOfRarityType[b];
/* 286 */       this.l[0][rarityType.ordinal()] = (Drawable)Game.i.assetManager.getDrawable("item-cell-a-coat-" + rarityType.name());
/* 287 */       this.l[1][rarityType.ordinal()] = (Drawable)Game.i.assetManager.getDrawable("item-cell-b-coat-" + rarityType.name());
/* 288 */       this.m[0][rarityType.ordinal()] = (Drawable)Game.i.assetManager.getDrawable("item-cell-a-coat-" + rarityType.name());
/* 289 */       this.m[1][rarityType.ordinal()] = (Drawable)Game.i.assetManager.getDrawable("item-cell-b-coat-" + rarityType.name());
/* 290 */       if (rarityType == RarityType.VERY_RARE) {
/* 291 */         this.m[0][rarityType.ordinal()] = ((TextureRegionDrawable)this.m[0][rarityType.ordinal()]).tint(MaterialColor.RED.P200);
/* 292 */         this.m[1][rarityType.ordinal()] = ((TextureRegionDrawable)this.m[1][rarityType.ordinal()]).tint(MaterialColor.RED.P200);
/*     */       }  b++; }
/*     */     
/* 295 */     this.itemCellShapes[0] = (Drawable)Game.i.assetManager.getDrawable("item-cell-a-shape");
/* 296 */     this.itemCellShapes[1] = (Drawable)Game.i.assetManager.getDrawable("item-cell-b-shape");
/*     */ 
/*     */ 
/*     */     
/* 300 */     rebuildLayers();
/*     */   }
/*     */   
/*     */   public final boolean isStageKeyPressed(int paramInt) {
/* 304 */     if (paramInt < this.o.length) {
/* 305 */       return this.o[paramInt];
/*     */     }
/* 307 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final UiLayer getWindowsLayer() {
/* 312 */     return this.d;
/*     */   }
/*     */   
/*     */   public final void addWindow(Window paramWindow) {
/* 316 */     Preconditions.checkNotNull(paramWindow, "window can not be null");
/* 317 */     getWindowsLayer().getTable().addActor((Actor)paramWindow);
/*     */   }
/*     */   
/*     */   public final Drawable getItemCellRarityCoat(RarityType paramRarityType, int paramInt) {
/* 321 */     paramInt %= 2;
/* 322 */     if (Game.i.settingsManager.cvdFriendlyColors()) {
/* 323 */       return this.m[paramInt][paramRarityType.ordinal()];
/*     */     }
/* 325 */     return this.l[paramInt][paramRarityType.ordinal()];
/*     */   }
/*     */ 
/*     */   
/*     */   public final void getTextInput(Input.TextInputListener paramTextInputListener, String paramString1, String paramString2, String paramString3) {
/* 330 */     if (Gdx.app.getType() == Application.ApplicationType.Desktop) {
/* 331 */       TextInputOverlay.i().show(paramTextInputListener, paramString1, paramString2, paramString3); return;
/*     */     } 
/* 333 */     Gdx.input.getTextInput(paramTextInputListener, paramString1, paramString2, paramString3);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setLogTouchDownsEnabled(boolean paramBoolean) {
/* 338 */     if (paramBoolean) Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_DISABLE_UI_TOUCH_LOG);
/*     */   
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
/*     */   public final void hideAllComponents() {
/* 394 */     for (byte b = 0; b < this.f.size; b++) {
/* 395 */       if (!((UiComponent)this.f.get(b)).isPersistent()) {
/* 396 */         ((UiComponent)this.f.get(b)).hide();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setup() {
/* 403 */     Game.EVENTS.getListeners(GameLoad.class).add(paramGameLoad -> {
/*     */           DeveloperConsole.i();
/*     */           Game.i.progressManager.addListener(new ProgressManager.ProgressManagerListener.ProgressManagerListenerAdapter(this)
/*     */               {
/*     */                 public void developerConsoleEnabled()
/*     */                 {
/* 409 */                   DeveloperConsole.i();
/*     */                 }
/*     */               });
/*     */         });
/*     */     
/* 414 */     Game.EVENTS.getListeners(ScreenResize.class).addWithFlagsAndPriority(paramScreenResize -> rebuildLayers(), 0, 1000);
/* 415 */     Game.EVENTS.getListeners(VisibleDisplayFrameChange.class).addWithFlagsAndPriority(paramVisibleDisplayFrameChange -> rebuildLayers(), 0, 1000);
/*     */     
/* 417 */     setAsInputHandler();
/*     */     
/* 419 */     Game.i.screenManager.addListener(this.n);
/*     */     
/* 421 */     Game.i.settingsManager.addListener(new SettingsManager.SettingsManagerListener(this)
/*     */         {
/*     */           public void settingsChanged() {}
/*     */ 
/*     */ 
/*     */           
/*     */           public void customValueChanged(SettingsManager.CustomValueType param1CustomValueType, double param1Double) {
/* 428 */             if (param1CustomValueType == SettingsManager.CustomValueType.UI_SCALE) {
/* 429 */               if (this.a.isComponentInit(WebBrowser.class)) {
/*     */                 WebBrowser webBrowser;
/* 431 */                 (webBrowser = WebBrowser.i()).dispose();
/* 432 */                 UiManager.b(this.a).remove(WebBrowser.class);
/* 433 */                 UiManager.c(this.a).removeValue(webBrowser, true);
/*     */               } 
/* 435 */               InventoryOverlay.i().requireLayoutRebuild();
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           public void dynamicSettingsChanged() {}
/*     */         });
/*     */   }
/*     */   
/*     */   private void a(ObjectSet<String> paramObjectSet, Actor paramActor) {
/* 445 */     if (paramActor.getName() != null) {
/* 446 */       if (paramObjectSet.contains(paramActor.getName())) {
/* 447 */         throw new RuntimeException("Duplicate actor name: " + paramActor.getName());
/*     */       }
/* 449 */       paramObjectSet.add(paramActor.getName());
/*     */     } 
/*     */ 
/*     */     
/* 453 */     if (paramActor instanceof Group) {
/* 454 */       SnapshotArray snapshotArray = ((Group)paramActor).getChildren(); byte b; int i;
/* 455 */       for (b = 0, i = ((Array)snapshotArray).size; b < i; b++) {
/* 456 */         a(paramObjectSet, (Actor)snapshotArray.get(b));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void findDuplicateActorNames()
/*     */   {
/* 465 */     ObjectSet<String> objectSet = new ObjectSet(); Group[] arrayOfGroup; int i; byte b;
/* 466 */     for (i = (arrayOfGroup = this.mainLayerGroups).length, b = 0; b < i; ) { Group group = arrayOfGroup[b];
/* 467 */       a(objectSet, (Actor)group);
/*     */       b++; }
/*     */      } @Null public final Actor findActor(String paramString) { Group[] arrayOfGroup;
/*     */     int i;
/*     */     byte b;
/* 472 */     for (i = (arrayOfGroup = this.mainLayerGroups).length, b = 0; b < i; ) {
/* 473 */       Group group; if ((group = arrayOfGroup[b]).getName() != null && group.getName().equals(paramString)) {
/* 474 */         return (Actor)group;
/*     */       }
/*     */       
/*     */       Actor actor;
/* 478 */       if ((actor = group.findActor(paramString)) != null) return actor; 
/*     */       b++;
/*     */     } 
/* 481 */     return null; }
/*     */ 
/*     */   
/*     */   public final void dumpActorsHierarchy(Group paramGroup, int paramInt) {
/* 485 */     StringBuilder stringBuilder = new StringBuilder();
/* 486 */     for (byte b = 0; b < paramInt; b++) {
/* 487 */       stringBuilder.append("|");
/*     */     }
/*     */     
/* 490 */     if (paramGroup == null) {
/*     */       Group[] arrayOfGroup; byte b1;
/* 492 */       for (i = (arrayOfGroup = this.mainLayerGroups).length, b1 = 0; b1 < i; ) { Group group = arrayOfGroup[b1];
/* 493 */         a.i(stringBuilder + " " + group.getName() + " (Group)", new Object[0]);
/* 494 */         dumpActorsHierarchy(group, paramInt + 1); b1++; }
/*     */        return;
/*     */     } 
/* 497 */     SnapshotArray snapshotArray = i.getChildren();
/* 498 */     for (int i = 0, j = ((Array)snapshotArray).size; i < j; i++) {
/* 499 */       Actor actor = (Actor)snapshotArray.get(i);
/* 500 */       a.i(stringBuilder + " " + actor.getName() + " (" + actor.getClass().getSimpleName() + ")", new Object[0]);
/* 501 */       if (actor instanceof Group) {
/* 502 */         dumpActorsHierarchy((Group)actor, paramInt + 1);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setAsInputHandler() {
/* 512 */     a.i("stage now handles all input", new Object[0]);
/* 513 */     Gdx.input.setInputProcessor((InputProcessor)this.stage);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final UiLayer addLayer(MainUiLayer paramMainUiLayer, int paramInt, String paramString) {
/* 523 */     return addLayerIgnoreSafeArea(paramMainUiLayer, paramInt, paramString, false);
/*     */   }
/*     */   
/*     */   public final UiLayer addLayerIgnoreSafeArea(MainUiLayer paramMainUiLayer, int paramInt, String paramString, boolean paramBoolean) {
/*     */     UiLayer uiLayer;
/* 528 */     (uiLayer = new UiLayer(paramMainUiLayer, new Table(), paramInt, paramString, (byte)0)).ignoreSafeMargin = paramBoolean;
/* 529 */     this.layers[paramMainUiLayer.ordinal()].add(uiLayer);
/*     */     
/* 531 */     rebuildLayers();
/*     */     
/* 533 */     return uiLayer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void removeLayer(UiLayer paramUiLayer) {
/* 540 */     this.layers[paramUiLayer.mainUiLayer.ordinal()].removeValue(paramUiLayer, true);
/*     */     
/* 542 */     rebuildLayers();
/*     */   }
/*     */   
/*     */   public final int getScreenWidth() {
/* 546 */     return Math.max(10, Gdx.graphics.getWidth());
/*     */   }
/*     */   
/*     */   public final int getScreenHeight() {
/* 550 */     return Math.max(10, Gdx.graphics.getHeight());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getScreenSafeMargin() {
/* 557 */     return Game.i.actionResolver.getInitConfigManager().get(SettingsManager.InitConfig.GRAPHICS_SAFE_AREA);
/*     */   }
/*     */   
/*     */   public final float getRegularLayerWidth() {
/* 561 */     return this.viewport.getWorldWidth() - (getScreenSafeMargin() << 1);
/*     */   }
/*     */   
/*     */   public final void runOnStageAct(Runnable paramRunnable) {
/* 565 */     Preconditions.checkNotNull(paramRunnable);
/* 566 */     this.g.add(paramRunnable);
/*     */   }
/*     */   
/*     */   public final void runOnStageActOnce(Runnable paramRunnable) {
/* 570 */     Preconditions.checkNotNull(paramRunnable);
/* 571 */     if (this.g.contains(paramRunnable, true)) {
/*     */       return;
/*     */     }
/* 574 */     this.g.add(paramRunnable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void rebuildLayers() {
/* 581 */     if (Game.i.settingsManager == null) {
/* 582 */       a.d("skipped rebuildLayers() - managers are not loaded yet", new Object[0]);
/*     */       
/*     */       return;
/*     */     } 
/* 586 */     int i = getScreenWidth();
/* 587 */     int j = getScreenHeight();
/*     */     
/* 589 */     if (i <= 0) i = 1; 
/* 590 */     if (j <= 0) j = 1;
/*     */     
/* 592 */     float f1 = Game.i.settingsManager.getScaledViewportHeight() / j;
/* 593 */     this.viewport.setUnitsPerPixel(f1);
/* 594 */     this.viewport.update(i, j, true);
/*     */     
/* 596 */     int k = getScreenSafeMargin();
/*     */ 
/*     */     
/* 599 */     if (this.c != null) {
/* 600 */       if (k == 0) {
/* 601 */         this.c.getTable().setVisible(false);
/*     */       } else {
/*     */         Table table;
/* 604 */         (table = this.c.getTable()).setVisible(true);
/*     */         
/* 606 */         table.clearChildren();
/*     */         
/*     */         Image image1;
/* 609 */         (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("transparent"))).setColor(0.0F, 0.0F, 0.0F, 0.0F);
/* 610 */         table.add((Actor)image1).width(k).padLeft(-k).expandY().fillY();
/* 611 */         image1.setTouchable(Touchable.enabled);
/* 612 */         image1.addListener((EventListener)new InputVoid());
/*     */         
/* 614 */         table.add().fillX().expandX();
/*     */         
/*     */         Image image2;
/* 617 */         (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("transparent"))).setColor(0.0F, 0.0F, 0.0F, 0.0F);
/* 618 */         table.add((Actor)image2).width(k).padRight(-k).expandY().fillY();
/* 619 */         image2.setTouchable(Touchable.enabled);
/* 620 */         image2.addListener((EventListener)new InputVoid());
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 625 */     float f2, f3 = (f2 = this.viewport.getWorldWidth()) - k - k;
/* 626 */     float f4 = this.viewport.getWorldHeight(); MainUiLayer[] arrayOfMainUiLayer2; int m; byte b;
/* 627 */     for (m = (arrayOfMainUiLayer2 = MainUiLayer.values).length, b = 0; b < m; ) { MainUiLayer mainUiLayer = arrayOfMainUiLayer2[b];
/* 628 */       this.mainLayerGroups[mainUiLayer.ordinal()].setSize(f2, f4);
/* 629 */       this.mainLayerGroups[mainUiLayer.ordinal()].setPosition(0.0F, 0.0F);
/*     */       b++; }
/*     */     
/*     */     Array<UiLayer>[] arrayOfArray;
/* 633 */     for (m = (arrayOfArray = this.layers).length, b = 0; b < m; b++) {
/* 634 */       Array<UiLayer> array; (array = arrayOfArray[b]).sort(b);
/*     */     } 
/*     */     
/*     */     MainUiLayer[] arrayOfMainUiLayer1;
/* 638 */     for (m = (arrayOfMainUiLayer1 = MainUiLayer.values).length, b = 0; b < m; ) { MainUiLayer mainUiLayer = arrayOfMainUiLayer1[b];
/* 639 */       this.mainLayerGroups[mainUiLayer.ordinal()].clearChildren(false);
/*     */       
/*     */       Array<UiLayer> array;
/* 642 */       for (Array.ArrayIterator<UiLayer> arrayIterator = (array = this.layers[mainUiLayer.ordinal()]).iterator(); arrayIterator.hasNext(); ) { UiLayer uiLayer = arrayIterator.next();
/* 643 */         float f5 = k;
/* 644 */         float f6 = 0.0F;
/* 645 */         float f7 = f3;
/* 646 */         float f8 = f4;
/*     */         
/* 648 */         if (uiLayer.ignoreSafeMargin) {
/* 649 */           f5 = 0.0F;
/* 650 */           f6 = 0.0F;
/* 651 */           f7 = f2;
/* 652 */           f8 = f4;
/*     */         } 
/* 654 */         if (uiLayer.followVisibleFrame) {
/* 655 */           f6 = f2 / i;
/* 656 */           float f9 = f4 / j;
/*     */           IntRectangle intRectangle;
/* 658 */           float f10 = (intRectangle = Game.i.getVisibleDisplayFrame()).minX * f6;
/* 659 */           float f11 = intRectangle.minY * f9;
/* 660 */           float f12 = (i - intRectangle.maxX) * f6;
/* 661 */           f9 = (j - intRectangle.maxY) * f9;
/* 662 */           f5 = Math.max(f5, f10);
/* 663 */           f6 = Math.max(0.0F, f11);
/* 664 */           f7 = Math.min(f7, f12 - f5);
/* 665 */           f8 = Math.min(f8, f9 - f6);
/*     */         } 
/*     */         
/* 668 */         UiLayer.a(uiLayer).setPosition(MathUtils.round(f5), MathUtils.round(f6));
/* 669 */         UiLayer.a(uiLayer).setSize(MathUtils.round(f7), MathUtils.round(f8));
/* 670 */         UiLayer.a(uiLayer).setOrigin(1);
/* 671 */         this.mainLayerGroups[mainUiLayer.ordinal()].addActor((Actor)UiLayer.a(uiLayer)); }
/*     */        b++; }
/*     */     
/* 674 */     updateLayersYAccordingToVisibleFrame();
/*     */   }
/*     */   @Null
/*     */   public final UiLayer getActorLayer(Actor paramActor) {
/* 678 */     paramActor = paramActor;
/* 679 */     while (paramActor != null) {
/* 680 */       if (paramActor.getUserObject() instanceof UiLayer) {
/* 681 */         return (UiLayer)paramActor.getUserObject();
/*     */       }
/* 683 */       Group group = paramActor.getParent();
/*     */     } 
/* 685 */     return null;
/*     */   }
/*     */   
/*     */   public final void updateLayersYAccordingToVisibleFrame() {
/* 689 */     int i = 0; UiLayer uiLayer;
/* 690 */     if (this.stage.getKeyboardFocus() != null && (
/*     */       
/* 692 */       uiLayer = getActorLayer(this.stage.getKeyboardFocus())) != null && 
/* 693 */       !uiLayer.followVisibleFrame && !uiLayer.ignoreVisibleFrame) {
/*     */       
/* 695 */       int k = MathUtils.round((this.stage.screenToStageCoordinates(new Vector2(0.0F, (getScreenHeight() - (Game.i.getVisibleDisplayFrame()).minY)))).y);
/*     */       
/* 697 */       float f1 = (this.stage.getKeyboardFocus().localToStageCoordinates(new Vector2())).y;
/* 698 */       float f2 = (this.stage.getKeyboardFocus().localToStageCoordinates(new Vector2(0.0F, this.stage.getKeyboardFocus().getHeight()))).y;
/* 699 */       f2 = f1 + (f2 - f1) / 2.0F - UiLayer.a(uiLayer).getY();
/*     */       
/* 701 */       float f3 = this.stage.getHeight() - k;
/*     */       
/*     */       float f4;
/*     */       
/* 705 */       if ((i = MathUtils.round((f4 = k + f3 / 2.0F) - f2)) < 0) {
/* 706 */         i = 0;
/*     */       }
/* 708 */       if (i > k) {
/* 709 */         i = k;
/*     */       }
/*     */     } 
/*     */     
/*     */     MainUiLayer[] arrayOfMainUiLayer;
/*     */     int j;
/*     */     byte b;
/* 716 */     for (j = (arrayOfMainUiLayer = MainUiLayer.values).length, b = 0; b < j; ) { MainUiLayer mainUiLayer = arrayOfMainUiLayer[b];
/*     */       Array<UiLayer> array;
/* 718 */       for (Array.ArrayIterator<UiLayer> arrayIterator = (array = this.layers[mainUiLayer.ordinal()]).iterator(); arrayIterator.hasNext();) {
/* 719 */         if (!(uiLayer1 = arrayIterator.next()).followVisibleFrame && !uiLayer1.ignoreVisibleFrame) {
/* 720 */           UiLayer.a(uiLayer1).setY(i);
/*     */         }
/*     */       } 
/*     */       b++; }
/*     */   
/*     */   }
/*     */   
/*     */   public final void preRender(float paramFloat) {
/* 728 */     for (byte b = 0; b < this.f.size; b++) {
/* 729 */       ((UiComponent)this.f.get(b)).preRender(paramFloat);
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
/*     */   public final void render(float paramFloat) {
/*     */     int i;
/* 753 */     for (i = 0; i < this.f.size; i++) {
/* 754 */       ((UiComponent)this.f.get(i)).postRender(paramFloat);
/*     */     }
/*     */     
/* 757 */     if (this.stage.getBatch().isDrawing())
/*     */     {
/* 759 */       this.stage.getBatch().end();
/*     */     }
/*     */     
/* 762 */     if (Game.i.debugManager != null) {
/* 763 */       long l = Game.getRealTickCount();
/* 764 */       for (byte b = 0; b < this.g.size; b++) {
/*     */         try {
/* 766 */           ((Runnable[])this.g.items)[b].run();
/* 767 */         } catch (Exception exception) {
/* 768 */           a.e("failed to run stage.act runnable " + ((Runnable[])this.g.items)[b], new Object[] { exception });
/*     */         } 
/*     */       } 
/* 771 */       this.g.clear();
/* 772 */       Game.i.debugManager.registerFrameJob("UI-runnables", Game.getRealTickCount() - l);
/*     */       
/* 774 */       l = Game.getRealTickCount();
/* 775 */       this.stage.act(paramFloat);
/* 776 */       Game.i.debugManager.registerFrameJob("UI-act", Game.getRealTickCount() - l);
/*     */       
/* 778 */       l = Game.getRealTickCount();
/* 779 */       this.stage.draw();
/* 780 */       Game.i.debugManager.registerFrameJob("UI-draw", Game.getRealTickCount() - l);
/*     */     } else {
/* 782 */       for (i = 0; i < this.g.size; i++) {
/*     */         try {
/* 784 */           ((Runnable[])this.g.items)[i].run();
/* 785 */         } catch (Exception exception) {
/* 786 */           a.e("failed to run stage.act runnable " + ((Runnable[])this.g.items)[i], new Object[] { exception });
/*     */         } 
/*     */       } 
/* 789 */       this.g.clear();
/* 790 */       this.stage.act(paramFloat);
/* 791 */       this.stage.draw();
/*     */     } 
/*     */ 
/*     */     
/* 795 */     this.k += paramFloat;
/* 796 */     if (this.k > 1.0F) {
/* 797 */       this.k = 0.0F;
/*     */       
/* 799 */       i = Gdx.input.getRotation();
/* 800 */       if (this.j != i) {
/* 801 */         this.j = i;
/* 802 */         rebuildLayers();
/*     */       } 
/*     */     } 
/*     */     
/* 806 */     updateLayersYAccordingToVisibleFrame();
/*     */   }
/*     */   
/*     */   public final HighlightActor addHighlight(Actor paramActor) {
/* 810 */     HighlightActor highlightActor = new HighlightActor(paramActor);
/* 811 */     this.i.addActor((Actor)highlightActor);
/* 812 */     highlightActor.addAction((Action)Actions.sequence(
/* 813 */           (Action)Actions.alpha(0.0F), 
/* 814 */           (Action)Actions.alpha(1.0F, 0.3F)));
/*     */ 
/*     */     
/* 817 */     return highlightActor;
/*     */   }
/*     */   
/*     */   public final void removeHighlight(HighlightActor paramHighlightActor) {
/* 821 */     paramHighlightActor.addAction((Action)Actions.sequence(
/* 822 */           (Action)Actions.alpha(0.0F, 0.3F), 
/* 823 */           (Action)Actions.removeActor()));
/*     */   }
/*     */ 
/*     */   
/*     */   public final void removeAllHighlights() {
/* 828 */     SnapshotArray snapshotArray = this.i.getChildren();
/* 829 */     for (byte b = 0; b < ((Array)snapshotArray).size; b++) {
/* 830 */       ((Actor)snapshotArray.get(b)).clearActions();
/* 831 */       ((Actor)snapshotArray.get(b)).addAction((Action)Actions.sequence(
/* 832 */             (Action)Actions.alpha(0.0F, 0.3F), 
/* 833 */             (Action)Actions.removeActor()));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void dispose() {
/* 840 */     for (byte b = 0; b < this.f.size; b++) {
/* 841 */       ((UiComponent)this.f.get(b)).dispose();
/*     */     }
/*     */     
/* 844 */     this.e.clear();
/* 845 */     this.f.clear();
/*     */   }
/*     */   
/*     */   private class _ScreenManagerListener implements ScreenManager.ScreenManagerListener { private _ScreenManagerListener(UiManager this$0) {}
/*     */     
/*     */     public void screenChanged() {
/* 851 */       this.a.removeAllHighlights();
/*     */     } }
/*     */ 
/*     */   
/*     */   public static class UiLayer {
/*     */     private Table a;
/*     */     public final String name;
/*     */     public int zIndex;
/*     */     public final UiManager.MainUiLayer mainUiLayer;
/*     */     public boolean ignoreSafeMargin = false;
/*     */     public boolean ignoreVisibleFrame = false;
/*     */     public boolean followVisibleFrame = false;
/*     */     public Object userdata;
/*     */     
/*     */     private UiLayer(UiManager.MainUiLayer param1MainUiLayer, Table param1Table, int param1Int, String param1String) {
/* 866 */       param1Table.setUserObject(this);
/*     */       
/* 868 */       this.mainUiLayer = param1MainUiLayer;
/* 869 */       this.a = param1Table;
/* 870 */       this.zIndex = param1Int;
/* 871 */       this.name = param1String;
/*     */       
/* 873 */       param1Table.setName(param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Table getTable() {
/* 880 */       return this.a;
/*     */     }
/*     */   }
/*     */   
/*     */   public static interface UiComponent
/*     */     extends Disposable {
/*     */     void hide();
/*     */     
/*     */     boolean isPersistent();
/*     */     
/*     */     void preRender(float param1Float);
/*     */     
/*     */     void postRender(float param1Float);
/*     */     
/*     */     public static abstract class Adapter
/*     */       implements UiComponent {
/*     */       public boolean isPersistent() {
/* 897 */         return false;
/*     */       }
/*     */       
/*     */       public void postRender(float param2Float) {}
/*     */       
/*     */       public void preRender(float param2Float) {}
/*     */       
/*     */       public void dispose() {}
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\UiManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */