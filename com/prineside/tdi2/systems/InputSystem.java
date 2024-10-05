/*     */ package com.prineside.tdi2.systems;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.InputAdapter;
/*     */ import com.badlogic.gdx.InputProcessor;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.prineside.tdi2.CameraController;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystem;
/*     */ import com.prineside.tdi2.configs.GameRenderingOrder;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.GamePaused;
/*     */ import com.prineside.tdi2.events.game.GameResumed;
/*     */ import com.prineside.tdi2.events.game.MouseClick;
/*     */ import com.prineside.tdi2.events.game.MouseMove;
/*     */ import com.prineside.tdi2.events.global.Render;
/*     */ import com.prineside.tdi2.events.global.ScreenResize;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.utils.InputMultiplexerExtended;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @NAGS
/*     */ public final class InputSystem
/*     */   extends GameSystem {
/*  28 */   private static final TLog a = TLog.forClass(InputSystem.class);
/*     */   
/*     */   private InputMultiplexerExtended b;
/*     */   
/*     */   public CameraController cameraController;
/*  33 */   private final Vector2 c = new Vector2();
/*     */   
/*     */   private InputProcessor d;
/*     */   
/*     */   private boolean e = false;
/*     */   
/*  39 */   private final Listener<ScreenResize> f = new Listener<ScreenResize>(this)
/*     */     {
/*     */       public void handleEvent(ScreenResize param1ScreenResize) {
/*  42 */         if (InputSystem.a(this.a))
/*  43 */           return;  this.a.cameraController.setScreenSize(param1ScreenResize.getWidth(), param1ScreenResize.getHeight());
/*     */       }
/*     */     };
/*  46 */   private final Listener<Render> g = new Listener<Render>(this)
/*     */     {
/*     */       public void handleEvent(Render param1Render) {
/*  49 */         this.a.cameraController.realUpdate(param1Render.getDeltaTime());
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   public final boolean affectsGameState() {
/*  55 */     return false;
/*     */   }
/*     */   
/*     */   public final boolean profileUpdate() {
/*  59 */     return false;
/*     */   }
/*     */   
/*     */   public final String getSystemName() {
/*  63 */     return "Input";
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setup() {
/*  68 */     Game.EVENTS.getListeners(Render.class).add(this.g).setDescription("InputSystem - updates cameraController");
/*     */     
/*  70 */     this.S.events.getListeners(GamePaused.class).add(paramGamePaused -> {
/*     */           this.d = Gdx.input.getInputProcessor();
/*     */           
/*     */           enableOnlyStage();
/*  74 */         }).setDescription("InputSystem - saves last InputProcessor and replaces it with stage-only processor");
/*     */     
/*  76 */     this.S.events.getListeners(GameResumed.class).add(paramGameResumed -> {
/*     */           a.i("game resumed, input processor: " + this.d, new Object[0]);
/*     */           
/*     */           Gdx.input.setInputProcessor(this.d);
/*  80 */         }).setDescription("InputSystem - restores stored InputProcessor from the GamePaused event");
/*     */     
/*  82 */     this.cameraController = new CameraController(this.S._render.getCamera(), this.S.map.getMap().getWidth() << 7, this.S.map.getMap().getHeight() << 7);
/*  83 */     this.cameraController.setScreenSize(Game.i.uiManager.getScreenWidth(), Game.i.uiManager.getScreenHeight());
/*  84 */     this.cameraController.lookAt((this.S.map.getMap().getWidth() << 7) / 2.0F, (this.S.map.getMap().getHeight() << 7) / 2.0F);
/*  85 */     this.cameraController.fitMapToScreen(60.0F);
/*     */     
/*  87 */     Gdx.input.setCatchKey(4, true);
/*  88 */     this.b = new InputMultiplexerExtended();
/*  89 */     disableInput();
/*     */ 
/*     */     
/*  92 */     Game.EVENTS.getListeners(ScreenResize.class).add(this.f);
/*     */     
/*  94 */     this.S._render.addLayer((new RenderSystem.Layer(GameRenderingOrder.INPUT_DRAW, false, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> draw(paramBatch, paramFloat2, paramFloat1)))
/*     */ 
/*     */         
/*  97 */         .setName("Input-draw"));
/*     */   }
/*     */ 
/*     */   
/*     */   public final void postSetup() {
/* 102 */     enableAllInput();
/*     */     
/* 104 */     this.cameraController.setMap(this.S.map.getMap());
/*     */   }
/*     */   
/*     */   public final void disableInput() {
/* 108 */     Gdx.input.setInputProcessor(null);
/*     */   }
/*     */   
/*     */   public final void enableOnlyStage() {
/* 112 */     Game.i.uiManager.setAsInputHandler();
/*     */   }
/*     */   
/*     */   public final void enableAllInput() {
/* 116 */     setupInputMultiplexer(true, true, true);
/* 117 */     Game.i.uiManager.stage.setScrollFocus(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final InputMultiplexerExtended setupInputMultiplexer(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/* 124 */     this.b.clear();
/* 125 */     if (paramBoolean1) this.b.addProcessor((InputProcessor)Game.i.uiManager.stage); 
/* 126 */     if (paramBoolean2) this.b.addProcessor(this.cameraController.getInputProcessor()); 
/* 127 */     if (paramBoolean3) this.b.addProcessor((InputProcessor)new MouseEventsInputProcessor((byte)0)); 
/* 128 */     Gdx.input.setInputProcessor((InputProcessor)this.b);
/* 129 */     return this.b;
/*     */   }
/*     */   
/*     */   public final InputProcessor getInputProcessor() {
/* 133 */     return Gdx.input.getInputProcessor();
/*     */   }
/*     */   
/*     */   public final CameraController getCameraController() {
/* 137 */     return this.cameraController;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void dispose() {
/* 142 */     Game.EVENTS.getListeners(Render.class).remove(this.g);
/* 143 */     Game.EVENTS.getListeners(ScreenResize.class).remove(this.f);
/*     */ 
/*     */     
/* 146 */     this.b = null;
/* 147 */     this.cameraController = null;
/*     */     
/* 149 */     this.d = null;
/*     */     
/* 151 */     this.e = true;
/*     */     
/* 153 */     super.dispose();
/*     */   }
/*     */   
/*     */   public final void draw(Batch paramBatch, float paramFloat1, float paramFloat2) {
/* 157 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_DRAW_CURSOR_POS) != 0.0D)
/* 158 */       Game.i.assetManager.getDebugFont(false).draw(paramBatch, (int)this.c.x + ":" + (int)this.c.y, this.c.x + 10.0F, this.c.y - 10.0F); 
/*     */   }
/*     */   
/*     */   private class MouseEventsInputProcessor extends InputAdapter {
/*     */     private MouseEventsInputProcessor(InputSystem this$0) {
/* 163 */       this.a = new Vector2();
/*     */     }
/*     */     private final Vector2 a;
/*     */     public boolean keyDown(int param1Int) {
/* 167 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean touchDragged(int param1Int1, int param1Int2, int param1Int3) {
/* 172 */       a(param1Int1, param1Int2, param1Int3);
/* 173 */       return false;
/*     */     }
/*     */     
/*     */     private void a(int param1Int1, int param1Int2, int param1Int3) {
/* 177 */       if (InputSystem.a(this.b) || this.b.cameraController == null)
/*     */         return; 
/* 179 */       this.a.set(param1Int1, param1Int2);
/* 180 */       this.b.cameraController.screenToMap(this.a);
/*     */       
/* 182 */       this.b.S.events.trigger((Event)new MouseMove(this.a.x, this.a.y, param1Int3));
/* 183 */       InputSystem.b(this.b).set(this.a.x, this.a.y);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean mouseMoved(int param1Int1, int param1Int2) {
/* 188 */       a(param1Int1, param1Int2, -1);
/* 189 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean touchUp(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 194 */       if (InputSystem.a(this.b) || this.b.cameraController == null) return false;
/*     */       
/* 196 */       this.a.set(param1Int1, param1Int2);
/* 197 */       this.b.cameraController.screenToMap(this.a);
/* 198 */       this.b.S.events.trigger((Event)new MouseClick(this.a.x, this.a.y, param1Int3, param1Int4));
/* 199 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\systems\InputSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */