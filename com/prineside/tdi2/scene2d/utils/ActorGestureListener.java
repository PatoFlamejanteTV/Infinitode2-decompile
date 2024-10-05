/*     */ package com.prineside.tdi2.scene2d.utils;
/*     */ 
/*     */ import com.badlogic.gdx.input.GestureDetector;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Event;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
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
/*  33 */   static final Vector2 a = new Vector2(); static final Vector2 b = new Vector2();
/*     */   
/*     */   private final GestureDetector e;
/*     */   InputEvent c;
/*     */   Actor d;
/*     */   private Actor f;
/*     */   
/*     */   public ActorGestureListener() {
/*  41 */     this(20.0F, 0.4F, 1.1F, 2.1474836E9F);
/*     */   }
/*     */ 
/*     */   
/*     */   public ActorGestureListener(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  46 */     this.e = new GestureDetector(paramFloat1, paramFloat2, paramFloat3, paramFloat4, (GestureDetector.GestureListener)new GestureDetector.GestureAdapter(this) {
/*  47 */           private final Vector2 a = new Vector2(), b = new Vector2();
/*  48 */           private final Vector2 c = new Vector2(); private final Vector2 d = new Vector2();
/*     */           
/*     */           public boolean tap(float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  51 */             this.e.d.stageToLocalCoordinates(ActorGestureListener.a.set(param1Float1, param1Float2));
/*  52 */             this.e.tap(this.e.c, ActorGestureListener.a.x, ActorGestureListener.a.y, param1Int1, param1Int2);
/*  53 */             return true;
/*     */           }
/*     */           
/*     */           public boolean longPress(float param1Float1, float param1Float2) {
/*  57 */             this.e.d.stageToLocalCoordinates(ActorGestureListener.a.set(param1Float1, param1Float2));
/*  58 */             return this.e.longPress(this.e.d, ActorGestureListener.a.x, ActorGestureListener.a.y);
/*     */           }
/*     */           
/*     */           public boolean fling(float param1Float1, float param1Float2, int param1Int) {
/*  62 */             a(ActorGestureListener.a.set(param1Float1, param1Float2));
/*  63 */             this.e.fling(this.e.c, ActorGestureListener.a.x, ActorGestureListener.a.y, param1Int);
/*  64 */             return true;
/*     */           }
/*     */           
/*     */           public boolean pan(float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
/*  68 */             a(ActorGestureListener.a.set(param1Float3, param1Float4));
/*  69 */             param1Float3 = ActorGestureListener.a.x;
/*  70 */             param1Float4 = ActorGestureListener.a.y;
/*  71 */             this.e.d.stageToLocalCoordinates(ActorGestureListener.a.set(param1Float1, param1Float2));
/*  72 */             this.e.pan(this.e.c, ActorGestureListener.a.x, ActorGestureListener.a.y, param1Float3, param1Float4);
/*  73 */             return true;
/*     */           }
/*     */           
/*     */           public boolean panStop(float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  77 */             this.e.d.stageToLocalCoordinates(ActorGestureListener.a.set(param1Float1, param1Float2));
/*  78 */             this.e.panStop(this.e.c, ActorGestureListener.a.x, ActorGestureListener.a.y, param1Int1, param1Int2);
/*  79 */             return true;
/*     */           }
/*     */           
/*     */           public boolean zoom(float param1Float1, float param1Float2) {
/*  83 */             this.e.zoom(this.e.c, param1Float1, param1Float2);
/*  84 */             return true;
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean pinch(Vector2 param1Vector21, Vector2 param1Vector22, Vector2 param1Vector23, Vector2 param1Vector24) {
/*  89 */             this.e.d.stageToLocalCoordinates(this.a.set(param1Vector21));
/*  90 */             this.e.d.stageToLocalCoordinates(this.b.set(param1Vector22));
/*  91 */             this.e.d.stageToLocalCoordinates(this.c.set(param1Vector23));
/*  92 */             this.e.d.stageToLocalCoordinates(this.d.set(param1Vector24));
/*  93 */             this.e.pinch(this.e.c, this.a, this.b, this.c, this.d);
/*  94 */             return true;
/*     */           }
/*     */           
/*     */           private void a(Vector2 param1Vector2) {
/*  98 */             this.e.d.stageToLocalCoordinates(param1Vector2);
/*  99 */             param1Vector2.sub(this.e.d.stageToLocalCoordinates(ActorGestureListener.b.set(0.0F, 0.0F)));
/*     */           }
/*     */         });
/*     */   }
/*     */   public boolean handle(Event paramEvent) {
/*     */     boolean bool;
/* 105 */     if (!(paramEvent instanceof InputEvent)) return false; 
/* 106 */     InputEvent inputEvent = (InputEvent)paramEvent;
/*     */     
/* 108 */     switch (null.a[inputEvent.getType().ordinal()]) {
/*     */       case 1:
/* 110 */         this.d = inputEvent.getListenerActor();
/* 111 */         this.f = inputEvent.getTarget();
/* 112 */         this.e.touchDown(inputEvent.getStageX(), inputEvent.getStageY(), inputEvent.getPointer(), inputEvent.getButton());
/* 113 */         this.d.stageToLocalCoordinates(a.set(inputEvent.getStageX(), inputEvent.getStageY()));
/* 114 */         touchDown(inputEvent, a.x, a.y, inputEvent.getPointer(), inputEvent.getButton());
/* 115 */         if (inputEvent.getTouchFocus()) inputEvent.getStage().addTouchFocus(this, inputEvent.getListenerActor(), inputEvent.getTarget(), inputEvent
/* 116 */               .getPointer(), inputEvent.getButton()); 
/* 117 */         return true;
/*     */       
/*     */       case 2:
/* 120 */         if (bool = inputEvent.isTouchFocusCancel()) {
/* 121 */           this.e.reset();
/*     */         } else {
/* 123 */           this.c = inputEvent;
/* 124 */           this.d = inputEvent.getListenerActor();
/* 125 */           this.e.touchUp(inputEvent.getStageX(), inputEvent.getStageY(), inputEvent.getPointer(), inputEvent.getButton());
/* 126 */           this.d.stageToLocalCoordinates(a.set(inputEvent.getStageX(), inputEvent.getStageY()));
/* 127 */           touchUp(inputEvent, a.x, a.y, inputEvent.getPointer(), inputEvent.getButton());
/*     */         } 
/* 129 */         this.c = null;
/* 130 */         this.d = null;
/* 131 */         this.f = null;
/* 132 */         return !bool;
/*     */       case 3:
/* 134 */         this.c = inputEvent;
/* 135 */         this.d = inputEvent.getListenerActor();
/* 136 */         this.e.touchDragged(inputEvent.getStageX(), inputEvent.getStageY(), inputEvent.getPointer());
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
/* 174 */     return this.e;
/*     */   }
/*     */   @Null
/*     */   public Actor getTouchDownTarget() {
/* 178 */     return this.f;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\utils\ActorGestureListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */