/*     */ package com.prineside.tdi2.ui.components;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.ui.actors.PaddedImageButton;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ 
/*     */ public class MapShiftButtons implements Disposable {
/*     */   public static interface MapShiftButtonsListener {
/*     */     void shifted(MapShiftButtons.Direction param1Direction);
/*     */     
/*     */     void expanded(MapShiftButtons.Direction param1Direction);
/*     */     
/*     */     void reduced(MapShiftButtons.Direction param1Direction);
/*     */   }
/*     */   
/*  18 */   private final UiManager.UiLayer a = Game.i.uiManager.addLayerIgnoreSafeArea(UiManager.MainUiLayer.SCREEN, 95, "MapShiftButtons", true);
/*     */   
/*     */   public enum Direction {
/*  21 */     UP,
/*  22 */     DOWN,
/*  23 */     LEFT,
/*  24 */     RIGHT;
/*     */     
/*  26 */     public static final Direction[] values = values();
/*     */     static {
/*     */     
/*  29 */     } } private final DelayedRemovalArray<MapShiftButtonsListener> b = new DelayedRemovalArray();
/*     */   
/*     */   private WidgetGroup c;
/*  32 */   private ObjectMap<Direction, Group> d = new ObjectMap();
/*  33 */   private ObjectMap<Direction, PaddedImageButton> e = new ObjectMap();
/*  34 */   private ObjectMap<Direction, PaddedImageButton> f = new ObjectMap();
/*  35 */   private ObjectMap<Direction, PaddedImageButton> g = new ObjectMap();
/*     */   
/*     */   private boolean h;
/*     */   private CameraController i;
/*  39 */   private final _CameraControllerListener j = new _CameraControllerListener((byte)0);
/*     */   
/*  41 */   private final Runnable k = this::update;
/*     */   
/*     */   public MapShiftButtons(GameSystemProvider paramGameSystemProvider) {
/*  44 */     this.i = paramGameSystemProvider._input.getCameraController();
/*     */     
/*  46 */     this.i.addListener(this.j);
/*     */     
/*  48 */     this.c = new WidgetGroup();
/*  49 */     this.c.setTransform(false);
/*  50 */     this.a.getTable().add((Actor)this.c).expand().fill(); Direction[] arrayOfDirection1;
/*     */     int j;
/*  52 */     for (int i = (arrayOfDirection1 = Direction.values).length; j < i; ) { Direction direction = arrayOfDirection1[j];
/*     */       Group group;
/*  54 */       (group = new Group()).setTransform(false);
/*  55 */       this.d.put(direction, group);
/*  56 */       group.setSize(1.0F, 1.0F);
/*  57 */       this.c.addActor((Actor)group);
/*     */       j++; }
/*     */     
/*     */     ObjectMap objectMap;
/*  61 */     (objectMap = new ObjectMap()).put(Direction.LEFT, "icon-triangle-left-hollow");
/*  62 */     objectMap.put(Direction.RIGHT, "icon-triangle-right-hollow");
/*  63 */     objectMap.put(Direction.DOWN, "icon-triangle-bottom-hollow");
/*  64 */     objectMap.put(Direction.UP, "icon-triangle-top-hollow"); Direction[] arrayOfDirection2;
/*     */     byte b;
/*  66 */     for (j = (arrayOfDirection2 = Direction.values).length, b = 0; b < j; ) { Direction direction = arrayOfDirection2[b];
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       PaddedImageButton paddedImageButton;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  76 */       (paddedImageButton = (new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable((String)objectMap.get(direction)), () -> { this.b.begin(); for (byte b = 0; b < this.b.size; b++) ((MapShiftButtonsListener)this.b.get(b)).shifted(paramDirection);  this.b.end(); }MaterialColor.LIGHT_BLUE.P800, MaterialColor.LIGHT_BLUE.P700, MaterialColor.LIGHT_BLUE.P900)).setIconPosition(16.0F, 16.0F).setIconSize(64.0F, 64.0F)).setSize(96.0F, 96.0F);
/*     */       
/*  78 */       switch (null.a[direction.ordinal()]) { case 1:
/*  79 */           paddedImageButton.setPosition(-96.0F, -48.0F); break;
/*  80 */         case 2: paddedImageButton.setPosition(0.0F, -48.0F); break;
/*  81 */         case 3: paddedImageButton.setPosition(-48.0F, 0.0F); break;
/*  82 */         case 4: paddedImageButton.setPosition(-48.0F, -96.0F);
/*     */           break; }
/*     */       
/*  85 */       ((Group)this.d.get(direction)).addActor((Actor)paddedImageButton);
/*  86 */       this.e.put(direction, paddedImageButton);
/*     */       b++; }
/*     */     
/*  89 */     objectMap.clear();
/*  90 */     objectMap.put(Direction.LEFT, "icon-triangle-left");
/*  91 */     objectMap.put(Direction.RIGHT, "icon-triangle-right");
/*  92 */     objectMap.put(Direction.DOWN, "icon-triangle-bottom");
/*  93 */     objectMap.put(Direction.UP, "icon-triangle-top");
/*     */     
/*  95 */     for (j = (arrayOfDirection2 = Direction.values).length, b = 0; b < j; ) { Direction direction = arrayOfDirection2[b];
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       PaddedImageButton paddedImageButton;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 105 */       (paddedImageButton = (new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable((String)objectMap.get(direction)), () -> { this.b.begin(); for (byte b = 0; b < this.b.size; b++) ((MapShiftButtonsListener)this.b.get(b)).expanded(paramDirection);  this.b.end(); }MaterialColor.GREEN.P800, MaterialColor.GREEN.P700, MaterialColor.GREEN.P900)).setIconPosition(16.0F, 16.0F).setIconSize(64.0F, 64.0F)).setSize(96.0F, 96.0F);
/*     */       
/* 107 */       switch (null.a[direction.ordinal()]) { case 1:
/* 108 */           paddedImageButton.setPosition(-96.0F, 48.0F); break;
/* 109 */         case 2: paddedImageButton.setPosition(0.0F, 48.0F); break;
/* 110 */         case 3: paddedImageButton.setPosition(48.0F, 0.0F); break;
/* 111 */         case 4: paddedImageButton.setPosition(48.0F, -96.0F);
/*     */           break; }
/*     */       
/* 114 */       ((Group)this.d.get(direction)).addActor((Actor)paddedImageButton);
/* 115 */       this.f.put(direction, paddedImageButton);
/*     */       b++; }
/*     */     
/* 118 */     objectMap.clear();
/* 119 */     objectMap.put(Direction.LEFT, "icon-triangle-right");
/* 120 */     objectMap.put(Direction.RIGHT, "icon-triangle-left");
/* 121 */     objectMap.put(Direction.DOWN, "icon-triangle-top");
/* 122 */     objectMap.put(Direction.UP, "icon-triangle-bottom");
/*     */     
/* 124 */     for (j = (arrayOfDirection2 = Direction.values).length, b = 0; b < j; ) { Direction direction = arrayOfDirection2[b];
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       PaddedImageButton paddedImageButton;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 134 */       (paddedImageButton = (new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable((String)objectMap.get(direction)), () -> { this.b.begin(); for (byte b = 0; b < this.b.size; b++) ((MapShiftButtonsListener)this.b.get(b)).reduced(paramDirection);  this.b.end(); }MaterialColor.RED.P800, MaterialColor.RED.P700, MaterialColor.RED.P900)).setIconPosition(16.0F, 16.0F).setIconSize(64.0F, 64.0F)).setSize(96.0F, 96.0F);
/*     */       
/* 136 */       switch (null.a[direction.ordinal()]) { case 1:
/* 137 */           paddedImageButton.setPosition(-96.0F, -144.0F); break;
/* 138 */         case 2: paddedImageButton.setPosition(0.0F, -144.0F); break;
/* 139 */         case 3: paddedImageButton.setPosition(-144.0F, 0.0F); break;
/* 140 */         case 4: paddedImageButton.setPosition(-144.0F, -96.0F);
/*     */           break; }
/*     */       
/* 143 */       ((Group)this.d.get(direction)).addActor((Actor)paddedImageButton);
/* 144 */       this.g.put(direction, paddedImageButton);
/*     */       b++; }
/*     */     
/* 147 */     update();
/*     */     
/* 149 */     paramGameSystemProvider.events.getListeners(MapSizeChange.class).add(paramMapSizeChange -> Game.i.uiManager.runOnStageActOnce(this.k));
/*     */   }
/*     */   
/*     */   public void setMapSizeChangesAllowed(boolean paramBoolean) {
/* 153 */     this.h = paramBoolean;
/* 154 */     update();
/*     */   }
/*     */   
/*     */   public void addListener(MapShiftButtonsListener paramMapShiftButtonsListener) {
/* 158 */     if (paramMapShiftButtonsListener == null) {
/* 159 */       throw new IllegalArgumentException("listener is null");
/*     */     }
/*     */     
/* 162 */     if (!this.b.contains(paramMapShiftButtonsListener, true)) {
/* 163 */       this.b.add(paramMapShiftButtonsListener);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeListener(MapShiftButtonsListener paramMapShiftButtonsListener) {
/* 168 */     if (paramMapShiftButtonsListener == null) {
/* 169 */       throw new IllegalArgumentException("listener is null");
/*     */     }
/*     */     
/* 172 */     this.b.removeValue(paramMapShiftButtonsListener, true);
/*     */   }
/*     */   
/*     */   public void update() {
/* 176 */     if (this.h) {
/* 177 */       ObjectMap.Values<PaddedImageButton> values; for (values = this.f.values().iterator(); values.hasNext();) {
/* 178 */         (paddedImageButton = values.next()).setVisible(true);
/*     */       }
/* 180 */       for (values = this.g.values().iterator(); values.hasNext();)
/* 181 */         (paddedImageButton = values.next()).setVisible(true); 
/*     */     } else {
/*     */       ObjectMap.Values<PaddedImageButton> values;
/* 184 */       for (values = this.f.values().iterator(); values.hasNext();) {
/* 185 */         (paddedImageButton = values.next()).setVisible(false);
/*     */       }
/* 187 */       for (values = this.g.values().iterator(); values.hasNext();) {
/* 188 */         (paddedImageButton = values.next()).setVisible(false);
/*     */       }
/*     */     } 
/*     */     
/*     */     Vector2 vector2;
/*     */     
/* 194 */     (vector2 = new Vector2()).set(-16.0F, this.i.getMapHeight() * 0.5F);
/* 195 */     this.i.mapToStage(vector2);
/* 196 */     ((Group)this.d.get(Direction.LEFT)).setPosition(vector2.x, vector2.y);
/*     */     
/* 198 */     vector2.set(this.i.getMapWidth() + 16.0F, this.i.getMapHeight() * 0.5F);
/* 199 */     this.i.mapToStage(vector2);
/* 200 */     ((Group)this.d.get(Direction.RIGHT)).setPosition(vector2.x, vector2.y);
/*     */     
/* 202 */     vector2.set(this.i.getMapWidth() * 0.5F, -16.0F);
/* 203 */     this.i.mapToStage(vector2);
/* 204 */     ((Group)this.d.get(Direction.DOWN)).setPosition(vector2.x, vector2.y);
/*     */     
/* 206 */     vector2.set(this.i.getMapWidth() * 0.5F, this.i.getMapHeight() + 16.0F);
/* 207 */     this.i.mapToStage(vector2);
/* 208 */     ((Group)this.d.get(Direction.UP)).setPosition(vector2.x, vector2.y);
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 213 */     this.i.removeListener(this.j);
/* 214 */     Game.i.uiManager.removeLayer(this.a);
/*     */   }
/*     */   
/*     */   private class _CameraControllerListener implements CameraController.CameraControllerListener { private _CameraControllerListener(MapShiftButtons this$0) {}
/*     */     
/*     */     public void onViewportUpdated(CameraController param1CameraController) {
/* 220 */       this.a.update();
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\MapShiftButtons.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */