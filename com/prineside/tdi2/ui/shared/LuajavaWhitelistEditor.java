/*     */ package com.prineside.tdi2.ui.shared;
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.Input;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.badlogic.gdx.utils.Timer;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Threads;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.global.Render;
/*     */ import com.prineside.tdi2.managers.AssetManager;
/*     */ import com.prineside.tdi2.managers.ScriptManager;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.managers.script.Whitelist;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.actors.FancyButton;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.Window;
/*     */ import com.prineside.tdi2.ui.shared.luaWhitelistEditor.EClass;
/*     */ import com.prineside.tdi2.ui.shared.luaWhitelistEditor.EConstructor;
/*     */ import com.prineside.tdi2.ui.shared.luaWhitelistEditor.EField;
/*     */ import com.prineside.tdi2.ui.shared.luaWhitelistEditor.EInterfaceConstructor;
/*     */ import com.prineside.tdi2.ui.shared.luaWhitelistEditor.EMethod;
/*     */ import com.prineside.tdi2.ui.shared.luaWhitelistEditor.EPackage;
/*     */ import com.prineside.tdi2.ui.shared.luaWhitelistEditor.TreeEntry;
/*     */ import com.prineside.tdi2.ui.shared.luaWhitelistEditor.windows.ListClassUsagesWindow;
/*     */ import com.prineside.tdi2.utils.ReflectionUtils;
/*     */ import com.prineside.tdi2.utils.UiUtils;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ public class LuajavaWhitelistEditor extends UiManager.UiComponent.Adapter {
/*  50 */   private static final TLog a = TLog.forClass(LuajavaWhitelistEditor.class); public static final String TYPE_COLOR = "#FFFFFF80"; private final Window b; private Table c; private volatile EPackage d; @Null
/*     */   private TreeEntry e; public static LuajavaWhitelistEditor i() {
/*  52 */     return (LuajavaWhitelistEditor)Game.i.uiManager.getComponent(LuajavaWhitelistEditor.class);
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
/*  63 */   private final Listener<Render> f = new Listener<Render>(this)
/*     */     {
/*     */       public void handleEvent(Render param1Render) {
/*  66 */         Vector2 vector2 = new Vector2(Gdx.input.getX(), Gdx.input.getY());
/*  67 */         Game.i.uiManager.stage.screenToStageCoordinates(vector2);
/*  68 */         Actor actor = Game.i.uiManager.stage.hit(vector2.x, vector2.y, true);
/*  69 */         TreeEntry treeEntry = null;
/*     */         
/*  71 */         while (actor != null) {
/*     */ 
/*     */           
/*  74 */           if (actor.getUserObject() instanceof TreeEntry) {
/*  75 */             treeEntry = (TreeEntry)actor.getUserObject();
/*     */             break;
/*     */           } 
/*  78 */           Group group = actor.getParent();
/*     */         } 
/*  80 */         if (LuajavaWhitelistEditor.a(this.a) != treeEntry) {
/*  81 */           if (LuajavaWhitelistEditor.a(this.a) != null) {
/*  82 */             (LuajavaWhitelistEditor.a(this.a)).hovered = false;
/*  83 */             LuajavaWhitelistEditor.a(this.a).updateBackground();
/*     */           } 
/*  85 */           LuajavaWhitelistEditor.a(this.a, treeEntry);
/*  86 */           if (treeEntry != null) {
/*  87 */             treeEntry.hovered = true;
/*  88 */             LuajavaWhitelistEditor.a(this.a).updateBackground();
/*     */           } 
/*     */         } 
/*     */       }
/*     */     };
/*     */   
/*     */   public LuajavaWhitelistEditor() {
/*     */     Window.WindowStyle windowStyle;
/*  96 */     (windowStyle = Game.i.assetManager.createDefaultWindowStyle()).resizeable = true;
/*  97 */     windowStyle.inheritWidgetMinSize = true;
/*  98 */     windowStyle.resizeHandleSize = 12.0F;
/*  99 */     windowStyle.resizeHandleOverlap = 2.0F;
/* 100 */     windowStyle.resizeHandleSizeHeader = 18.0F;
/* 101 */     windowStyle.resizeHandleOverlapHeader = 3.0F;
/*     */     
/* 103 */     this.b = new Window(windowStyle);
/* 104 */     this.b.setTitle("Lua whitelist editor");
/* 105 */     this.b.addListener((Window.WindowListener)new Window.WindowListener.Adapter(this)
/*     */         {
/*     */           public void closed() {
/* 108 */             this.a.hide();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public void hide() {
/* 115 */     Game.i.uiManager.stage.unfocusAll();
/* 116 */     Game.EVENTS.getListeners(Render.class).remove(this.f);
/*     */   }
/*     */   
/*     */   public void showClassUsagesWindow(Class<?> paramClass) {
/* 120 */     ListClassUsagesWindow listClassUsagesWindow = new ListClassUsagesWindow(paramClass, (TreeEntry)this.d);
/* 121 */     Game.i.uiManager.addWindow((Window)listClassUsagesWindow);
/* 122 */     listClassUsagesWindow.fitToContentSimple();
/* 123 */     listClassUsagesWindow.showAtCursor();
/*     */   }
/*     */   
/*     */   public void show() {
/* 127 */     if (!Config.isModdingMode() && !Game.i.progressManager.isDeveloperModeEnabled()) {
/* 128 */       Dialog.i().showAlert("Developer mode research required");
/*     */       
/*     */       return;
/*     */     } 
/* 132 */     if (Gdx.app.getType() != Application.ApplicationType.Desktop) {
/* 133 */       Dialog.i().showAlert("This thing only works on a PC version of the game");
/*     */       return;
/*     */     } 
/* 136 */     String str = System.getProperty("java.specification.version", "not set");
/* 137 */     a.i("Java version: " + str, new Object[0]);
/* 138 */     if (!"1.8".equals(str)) {
/* 139 */       Notifications.i().addFailure("You are running Java " + str + "! Use Java 8 for a list of classes and methods which is (kinda) compatible with all platforms. Using Java 9+ will show more methods on this list which may not be available on the other platforms.");
/* 140 */       Timer.schedule(new Timer.Task(this)
/*     */           {
/*     */             public void run() {
/* 143 */               Notifications.i().addFailure("If you are running the game through .exe, you are doing it wrong. Run the game through java -jar, otherwise you won't be able to see the whole class tree here");
/*     */             }
/*     */           },  2.0F);
/*     */     } 
/*     */ 
/*     */     
/* 149 */     this.c = new Table();
/* 150 */     Table table1 = new Table();
/*     */     
/* 152 */     Table table2 = new Table();
/* 153 */     table1.add((Actor)table2).growX().pad(10.0F).padBottom(0.0F).row();
/*     */ 
/*     */     
/*     */     FancyButton fancyButton;
/*     */     
/* 158 */     (fancyButton = new FancyButton("regularButton.a", () -> reInitialize())).add((Actor)new Label("Rebuild the tree", Game.i.assetManager.getLabelStyle(21))).padLeft(10.0F).padRight(10.0F);
/* 159 */     table2.add((Actor)fancyButton).height(32.0F).padRight(8.0F);
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
/* 178 */     (fancyButton = new FancyButton("regularButton.b", () -> TextInputOverlay.i().show(new Input.TextInputListener(this) { public void input(String param1String) { try { Class<?> clazz = Class.forName(param1String); this.a.showClassUsagesWindow(clazz); return; } catch (Exception exception) { LuajavaWhitelistEditor.a().e("failed to find class " + param1String, new Object[] { exception }); Notifications.i().addFailure("Class with this name not found"); return; }  } public void canceled() {} }"Class name", "", "Full class name"))).add((Actor)new Label("List class usages", Game.i.assetManager.getLabelStyle(21))).padLeft(10.0F).padRight(10.0F);
/* 179 */     table2.add((Actor)fancyButton).height(32.0F).padRight(8.0F);
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
/* 193 */     (fancyButton = new FancyButton("regularButton.a", () -> { Array array = new Array(); Array.ArrayIterator<TreeEntry> arrayIterator = this.d.getChildren().iterator(); while (arrayIterator.hasNext()) { TreeEntry treeEntry; (treeEntry = arrayIterator.next()).gatherSaveData(array); }  StringBuilder stringBuilder = new StringBuilder(); Array.ArrayIterator<String> arrayIterator1 = array.iterator(); while (arrayIterator1.hasNext()) { String str = arrayIterator1.next(); stringBuilder.append(str).append("\n"); }  Gdx.files.local("res/luaj/whitelist.txt").writeString(stringBuilder.toString(), false, "UTF-8"); Notifications.i().addSuccess("Saved!"); })).add((Actor)new Label("Save", Game.i.assetManager.getLabelStyle(21))).padLeft(10.0F).padRight(10.0F);
/* 194 */     table2.add((Actor)fancyButton).height(32.0F);
/*     */     
/* 196 */     table2.add().height(1.0F).growX();
/*     */     
/* 198 */     table1.add((Actor)this.c).pad(10.0F).grow();
/* 199 */     UiUtils.enableMouseMoveScrollFocus(this.b.getScrollPane());
/*     */     
/* 201 */     Game.EVENTS.getListeners(Render.class).add(this.f).setName("LuajavaWhitelistEditor").setDescription("Updates hovering");
/*     */     
/* 203 */     reInitialize();
/*     */     
/* 205 */     Game.i.uiManager.addWindow(this.b);
/* 206 */     this.b.setContents((Actor)table1);
/* 207 */     this.b.minWidth = 600.0F;
/* 208 */     this.b.minHeight = 400.0F;
/* 209 */     this.b.fitToContent(1, true, true, true);
/* 210 */     this.b.clampWindowPosition();
/* 211 */     this.b.showAtCursor();
/*     */   }
/*     */   
/*     */   public void goToEntry(TreeEntry paramTreeEntry) {
/* 215 */     this.d.setChildrenCollapsedRecursively();
/* 216 */     Array array = new Array(true, 1, TreeEntry.class);
/* 217 */     TreeEntry treeEntry = paramTreeEntry.parent;
/* 218 */     while (treeEntry != null) {
/* 219 */       array.add(treeEntry);
/* 220 */       treeEntry = treeEntry.parent;
/*     */     } 
/* 222 */     for (int i = array.size - 1; i >= 0; i--) {
/* 223 */       ((TreeEntry)array.get(i)).setCollapsed(false);
/*     */     }
/*     */     
/* 226 */     Game.i.uiManager.runOnStageActOnce(() -> {
/*     */           Vector2 vector2 = new Vector2();
/*     */           paramTreeEntry.getListEntry().localToActorCoordinates((Actor)this.c, vector2);
/*     */           this.b.getScrollPane().scrollTo(0.0F, vector2.y, 1.0F, 24.0F, false, true);
/*     */           this.b.getScrollPane().updateVisualScroll();
/*     */           Image image;
/*     */           (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setFillParent(true);
/*     */           paramTreeEntry.getListEntry().addActor((Actor)image);
/*     */           image.addAction((Action)Actions.sequence((Action)Actions.alpha(0.0F, 0.2F), (Action)Actions.removeActor()));
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void b() {
/*     */     HashSet<Class<Object>> hashSet;
/* 246 */     (hashSet = new HashSet<>()).add(Object.class);
/* 247 */     for (Array.ArrayIterator<String> arrayIterator = ScriptManager.getPackagesToScanFromConfig().iterator(); arrayIterator.hasNext(); ) { String str = arrayIterator.next();
/*     */       HashSet hashSet1;
/* 249 */       Array array1 = ReflectionUtils.LuaRelated.filterClasses(hashSet1 = Game.i.actionResolver.getClasses(str), null);
/* 250 */       hashSet.addAll(Arrays.asList((Class<Object>[])array1.toArray()));
/* 251 */       a.i("- " + str + ": " + array1.size, new Object[0]); }
/*     */     
/* 253 */     a.i("Total: " + hashSet.size(), new Object[0]);
/*     */     
/*     */     Array array;
/* 256 */     (array = new Array(true, hashSet.size(), Class.class)).addAll((Object[])hashSet.<Class<?>[]>toArray((Class<?>[][])new Class[0]));
/*     */ 
/*     */ 
/*     */     
/* 260 */     Threads.sortGdxArray(array, (paramClass1, paramClass2) -> {
/*     */           int i;
/*     */ 
/*     */           
/*     */           return ((i = Integer.compare(paramClass1.getName().length(), paramClass2.getName().length())) != 0) ? i : paramClass1.getName().compareTo(paramClass2.getName());
/*     */         });
/*     */ 
/*     */     
/* 268 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 269 */     EPackage ePackage = new EPackage(null, "", ""); Array.ArrayIterator<Class<?>> arrayIterator1;
/* 270 */     label71: for (arrayIterator1 = array.iterator(); arrayIterator1.hasNext(); ) {
/*     */       EPackage ePackage1; Class<?> clazz;
/* 272 */       String str, arrayOfString[] = (str = (clazz = arrayIterator1.next()).getName()).split("[.$]+");
/*     */ 
/*     */       
/* 275 */       TreeEntry treeEntry = null;
/* 276 */       StringBuilder stringBuilder = new StringBuilder();
/* 277 */       for (byte b1 = 0; b1 < arrayOfString.length - 1; b1++) {
/* 278 */         EPackage ePackage2; String str1 = arrayOfString[b1];
/* 279 */         if (stringBuilder.length() != 0) {
/* 280 */           stringBuilder.append(".");
/*     */         }
/* 282 */         stringBuilder.append(str1);
/* 283 */         String str2 = str.substring(0, stringBuilder.toString().length());
/*     */         TreeEntry treeEntry1;
/* 285 */         if ((treeEntry1 = (TreeEntry)hashMap.get(str2)) == null) {
/* 286 */           boolean bool = false;
/*     */           try {
/* 288 */             Class.forName(str2);
/* 289 */             bool = true;
/* 290 */           } catch (Exception exception) {}
/*     */           
/* 292 */           if (!bool)
/*     */           
/*     */           { 
/*     */             
/* 296 */             ePackage2 = new EPackage(treeEntry, str1, str2);
/*     */ 
/*     */             
/* 299 */             if (treeEntry != null) {
/* 300 */               treeEntry.addChild((TreeEntry)ePackage2);
/*     */             }
/* 302 */             if (b1 == 0) {
/* 303 */               ePackage.addChild((TreeEntry)ePackage2);
/*     */             }
/*     */             
/* 306 */             hashMap.put(str2, ePackage2); } else { continue label71; }
/*     */         
/* 308 */         }  ePackage1 = ePackage2;
/*     */       } 
/*     */       
/* 311 */       if (ePackage1 == null) {
/* 312 */         ePackage1 = new EPackage(null, "", null);
/*     */       }
/* 314 */       EClass eClass = new EClass(clazz, (TreeEntry)ePackage1);
/* 315 */       ePackage1.addChild((TreeEntry)eClass);
/* 316 */       hashMap.put(clazz.getName(), eClass);
/*     */       
/* 318 */       if (clazz.isInterface()) {
/* 319 */         EInterfaceConstructor eInterfaceConstructor = new EInterfaceConstructor((TreeEntry)eClass);
/* 320 */         eClass.addChild((TreeEntry)eInterfaceConstructor);
/*     */       } 
/*     */ 
/*     */       
/* 324 */       Array array1 = ReflectionUtils.LuaRelated.gatherConstructors(clazz);
/* 325 */       for (byte b2 = 0; b2 < array1.size; b2++) {
/* 326 */         Constructor constructor = (Constructor)array1.get(b2);
/* 327 */         EConstructor eConstructor = new EConstructor((TreeEntry)eClass, constructor);
/* 328 */         eClass.addChild((TreeEntry)eConstructor);
/*     */       } 
/* 330 */       Array array2 = ReflectionUtils.LuaRelated.gatherFields(clazz);
/* 331 */       for (byte b3 = 0; b3 < array2.size; b3++) {
/* 332 */         Field field = (Field)array2.get(b3);
/* 333 */         EField eField = new EField(field, (TreeEntry)eClass);
/* 334 */         eClass.addChild((TreeEntry)eField);
/*     */       } 
/*     */       
/* 337 */       Array array3 = ReflectionUtils.LuaRelated.gatherMethods(clazz);
/* 338 */       for (byte b4 = 0; b4 < array3.size; b4++) {
/* 339 */         Method method = (Method)array3.get(b4);
/* 340 */         EMethod eMethod = new EMethod(method, (TreeEntry)eClass);
/* 341 */         eClass.addChild((TreeEntry)eMethod);
/*     */       } 
/*     */     } 
/*     */     
/* 345 */     Comparator comparator = (paramTreeEntry1, paramTreeEntry2) -> {
/*     */         int i = paramTreeEntry1.getSortCategory();
/*     */ 
/*     */ 
/*     */         
/*     */         int j = paramTreeEntry2.getSortCategory();
/*     */ 
/*     */         
/*     */         return (i < j) ? -1 : ((j < i) ? 1 : paramTreeEntry1.getSortName().compareTo(paramTreeEntry2.getSortName()));
/*     */       };
/*     */ 
/*     */     
/* 357 */     for (Iterator<TreeEntry> iterator = hashMap.values().iterator(); iterator.hasNext();) {
/* 358 */       Threads.sortGdxArray((treeEntry = iterator.next()).children, comparator);
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/* 363 */       Whitelist whitelist = Whitelist.fromFile(AssetManager.localOrInternalFile("res/luaj/whitelist.txt"));
/* 364 */       for (Array.ArrayIterator<TreeEntry> arrayIterator2 = ePackage.getChildren().iterator(); arrayIterator2.hasNext(); ) { TreeEntry treeEntry = arrayIterator2.next();
/* 365 */         a(treeEntry, whitelist); }
/*     */     
/* 367 */     } catch (Exception exception) {
/* 368 */       a.e("failed to apply whitelist from file res/luaj/whitelist.txt", new Object[] { exception });
/* 369 */       Notifications.i().addFailure("Failed to load / apply the whitelist from file, check console");
/*     */     } 
/*     */     
/* 372 */     this.d = ePackage;
/*     */   }
/*     */   
/*     */   private void a(TreeEntry paramTreeEntry, Whitelist paramWhitelist) {
/* 376 */     paramTreeEntry.applyStateFromWhitelist(paramWhitelist);
/* 377 */     for (Array.ArrayIterator<TreeEntry> arrayIterator = paramTreeEntry.getChildren().iterator(); arrayIterator.hasNext(); ) { TreeEntry treeEntry = arrayIterator.next();
/* 378 */       a(treeEntry, paramWhitelist); }
/*     */   
/*     */   }
/*     */   
/*     */   public void rebuildUi() {
/* 383 */     this.c.clear();
/* 384 */     if (this.d == null) {
/* 385 */       a.i("rebuildUi: showing Loading...", new Object[0]);
/*     */       Image image;
/* 387 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("infinitode-2-logo"))).setOrigin(16.0F, 16.0F);
/* 388 */       image.addAction((Action)Actions.forever((Action)Actions.rotateBy(-360.0F, 2.0F)));
/* 389 */       this.c.add((Actor)image).size(32.0F);
/* 390 */       this.c.add((Actor)new Label("Loading...", Game.i.assetManager.getLabelStyle(24))).padLeft(8.0F); return;
/*     */     } 
/* 392 */     a.i("rebuildUi: visualizing a tree", new Object[0]);
/*     */     
/* 394 */     for (Array.ArrayIterator<TreeEntry> arrayIterator = this.d.getChildren().iterator(); arrayIterator.hasNext(); ) {
/* 395 */       TreeEntry treeEntry; Table table = (treeEntry = arrayIterator.next()).getListEntry();
/* 396 */       this.c.add((Actor)table).growX().row();
/*     */     } 
/* 398 */     this.c.row();
/* 399 */     this.c.add().width(1.0F).growY();
/* 400 */     this.b.fitToContent(1, true, false, true);
/* 401 */     Game.i.uiManager.runOnStageAct(() -> {
/*     */           if (this.b.getHeight() < 900.0F) {
/*     */             this.b.setHeight(900.0F);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public void reInitialize() {
/* 410 */     this.e = null;
/* 411 */     this.d = null;
/* 412 */     rebuildUi();
/*     */ 
/*     */     
/* 415 */     Threads.i().runAsync(() -> {
/*     */           try {
/*     */             b();
/* 418 */           } catch (Exception exception) {
/*     */             a.e("failed to load class tree", new Object[] { exception });
/*     */           } 
/*     */           Threads.i().runOnMainThread(());
/*     */         });
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\LuajavaWhitelistEditor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */