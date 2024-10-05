/*     */ package com.badlogic.gdx.scenes.scene2d.utils;
/*     */ 
/*     */ import com.badlogic.gdx.input.GestureDetector;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*     */ import com.badlogic.gdx.scenes.scene2d.Event;
/*     */ import com.badlogic.gdx.scenes.scene2d.EventListener;
/*     */ import com.badlogic.gdx.scenes.scene2d.InputEvent;
/*     */ import com.badlogic.gdx.utils.Null;
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
/*     */ public class ActorGestureListener
/*     */   implements EventListener
/*     */ {
/*  33 */   static final Vector2 tmpCoords = new Vector2(); static final Vector2 tmpCoords2 = new Vector2();
/*     */   
/*     */   private final GestureDetector detector;
/*     */   InputEvent event;
/*     */   Actor actor;
/*     */   Actor touchDownTarget;
/*     */   
/*     */   public ActorGestureListener() {
/*  41 */     this(20.0F, 0.4F, 1.1F, 2.1474836E9F);
/*     */   }
/*     */ 
/*     */   
/*     */   public ActorGestureListener(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  46 */     this.detector = new GestureDetector(paramFloat1, paramFloat2, paramFloat3, paramFloat4, (GestureDetector.GestureListener)new GestureDetector.GestureAdapter() {
/*  47 */           private final Vector2 initialPointer1 = new Vector2(), initialPointer2 = new Vector2();
/*  48 */           private final Vector2 pointer1 = new Vector2(); private final Vector2 pointer2 = new Vector2();
/*     */           
/*     */           public boolean tap(float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  51 */             ActorGestureListener.this.actor.stageToLocalCoordinates(ActorGestureListener.tmpCoords.set(param1Float1, param1Float2));
/*  52 */             ActorGestureListener.this.tap(ActorGestureListener.this.event, ActorGestureListener.tmpCoords.x, ActorGestureListener.tmpCoords.y, param1Int1, param1Int2);
/*  53 */             return true;
/*     */           }
/*     */           
/*     */           public boolean longPress(float param1Float1, float param1Float2) {
/*  57 */             ActorGestureListener.this.actor.stageToLocalCoordinates(ActorGestureListener.tmpCoords.set(param1Float1, param1Float2));
/*  58 */             return ActorGestureListener.this.longPress(ActorGestureListener.this.actor, ActorGestureListener.tmpCoords.x, ActorGestureListener.tmpCoords.y);
/*     */           }
/*     */           
/*     */           public boolean fling(float param1Float1, float param1Float2, int param1Int) {
/*  62 */             stageToLocalAmount(ActorGestureListener.tmpCoords.set(param1Float1, param1Float2));
/*  63 */             ActorGestureListener.this.fling(ActorGestureListener.this.event, ActorGestureListener.tmpCoords.x, ActorGestureListener.tmpCoords.y, param1Int);
/*  64 */             return true;
/*     */           }
/*     */           
/*     */           public boolean pan(float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
/*  68 */             stageToLocalAmount(ActorGestureListener.tmpCoords.set(param1Float3, param1Float4));
/*  69 */             param1Float3 = ActorGestureListener.tmpCoords.x;
/*  70 */             param1Float4 = ActorGestureListener.tmpCoords.y;
/*  71 */             ActorGestureListener.this.actor.stageToLocalCoordinates(ActorGestureListener.tmpCoords.set(param1Float1, param1Float2));
/*  72 */             ActorGestureListener.this.pan(ActorGestureListener.this.event, ActorGestureListener.tmpCoords.x, ActorGestureListener.tmpCoords.y, param1Float3, param1Float4);
/*  73 */             return true;
/*     */           }
/*     */           
/*     */           public boolean panStop(float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  77 */             ActorGestureListener.this.actor.stageToLocalCoordinates(ActorGestureListener.tmpCoords.set(param1Float1, param1Float2));
/*  78 */             ActorGestureListener.this.panStop(ActorGestureListener.this.event, ActorGestureListener.tmpCoords.x, ActorGestureListener.tmpCoords.y, param1Int1, param1Int2);
/*  79 */             return true;
/*     */           }
/*     */           
/*     */           public boolean zoom(float param1Float1, float param1Float2) {
/*  83 */             ActorGestureListener.this.zoom(ActorGestureListener.this.event, param1Float1, param1Float2);
/*  84 */             return true;
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean pinch(Vector2 param1Vector21, Vector2 param1Vector22, Vector2 param1Vector23, Vector2 param1Vector24) {
/*  89 */             ActorGestureListener.this.actor.stageToLocalCoordinates(this.initialPointer1.set(param1Vector21));
/*  90 */             ActorGestureListener.this.actor.stageToLocalCoordinates(this.initialPointer2.set(param1Vector22));
/*  91 */             ActorGestureListener.this.actor.stageToLocalCoordinates(this.pointer1.set(param1Vector23));
/*  92 */             ActorGestureListener.this.actor.stageToLocalCoordinates(this.pointer2.set(param1Vector24));
/*  93 */             ActorGestureListener.this.pinch(ActorGestureListener.this.event, this.initialPointer1, this.initialPointer2, this.pointer1, this.pointer2);
/*  94 */             return true;
/*     */           }
/*     */           
/*     */           private void stageToLocalAmount(Vector2 param1Vector2) {
/*  98 */             ActorGestureListener.this.actor.stageToLocalCoordinates(param1Vector2);
/*  99 */             param1Vector2.sub(ActorGestureListener.this.actor.stageToLocalCoordinates(ActorGestureListener.tmpCoords2.set(0.0F, 0.0F)));
/*     */           }
/*     */         });
/*     */   }
/*     */   public boolean handle(Event paramEvent) {
/*     */     boolean bool;
/* 105 */     if (!(paramEvent instanceof InputEvent)) return false; 
/* 106 */     InputEvent inputEvent = (InputEvent)paramEvent;
/*     */     
/* 108 */     switch (inputEvent.getType()) {
/*     */       case touchDown:
/* 110 */         this.actor = inputEvent.getListenerActor();
/* 111 */         this.touchDownTarget = inputEvent.getTarget();
/* 112 */         this.detector.touchDown(inputEvent.getStageX(), inputEvent.getStageY(), inputEvent.getPointer(), inputEvent.getButton());
/* 113 */         this.actor.stageToLocalCoordinates(tmpCoords.set(inputEvent.getStageX(), inputEvent.getStageY()));
/* 114 */         touchDown(inputEvent, tmpCoords.x, tmpCoords.y, inputEvent.getPointer(), inputEvent.getButton());
/* 115 */         if (inputEvent.getTouchFocus()) inputEvent.getStage().addTouchFocus(this, inputEvent.getListenerActor(), inputEvent.getTarget(), inputEvent
/* 116 */               .getPointer(), inputEvent.getButton()); 
/* 117 */         return true;
/*     */       
/*     */       case touchUp:
/* 120 */         if (bool = inputEvent.isTouchFocusCancel()) {
/* 121 */           this.detector.reset();
/*     */         } else {
/* 123 */           this.event = inputEvent;
/* 124 */           this.actor = inputEvent.getListenerActor();
/* 125 */           this.detector.touchUp(inputEvent.getStageX(), inputEvent.getStageY(), inputEvent.getPointer(), inputEvent.getButton());
/* 126 */           this.actor.stageToLocalCoordinates(tmpCoords.set(inputEvent.getStageX(), inputEvent.getStageY()));
/* 127 */           touchUp(inputEvent, tmpCoords.x, tmpCoords.y, inputEvent.getPointer(), inputEvent.getButton());
/*     */         } 
/* 129 */         this.event = null;
/* 130 */         this.actor = null;
/* 131 */         this.touchDownTarget = null;
/* 132 */         return !bool;
/*     */       case touchDragged:
/* 134 */         this.event = inputEvent;
/* 135 */         this.actor = inputEvent.getListenerActor();
/* 136 */         this.detector.touchDragged(inputEvent.getStageX(), inputEvent.getStageY(), inputEvent.getPointer());
/* 137 */         return true;
/*     */     } 
/* 139 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void touchDown(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2) {}
/*     */ 
/*     */   
/*     */   public void touchUp(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2) {}
/*     */ 
/*     */   
/*     */   public void tap(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2) {}
/*     */ 
/*     */   
/*     */   public boolean longPress(Actor paramActor, float paramFloat1, float paramFloat2) {
/* 154 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fling(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt) {}
/*     */ 
/*     */   
/*     */   public void pan(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
/*     */ 
/*     */   
/*     */   public void panStop(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2) {}
/*     */ 
/*     */   
/*     */   public void zoom(InputEvent paramInputEvent, float paramFloat1, float paramFloat2) {}
/*     */ 
/*     */   
/*     */   public void pinch(InputEvent paramInputEvent, Vector2 paramVector21, Vector2 paramVector22, Vector2 paramVector23, Vector2 paramVector24) {}
/*     */ 
/*     */   
/*     */   public GestureDetector getGestureDetector() {
/* 174 */     return this.detector;
/*     */   }
/*     */   @Null
/*     */   public Actor getTouchDownTarget() {
/* 178 */     return this.touchDownTarget;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\utils\ActorGestureListener.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */