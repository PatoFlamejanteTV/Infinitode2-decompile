/*     */ package com.badlogic.gdx.scenes.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*     */ import com.badlogic.gdx.scenes.scene2d.InputEvent;
/*     */ import com.badlogic.gdx.scenes.scene2d.InputListener;
/*     */ import com.badlogic.gdx.scenes.scene2d.Stage;
/*     */ import com.badlogic.gdx.scenes.scene2d.Touchable;
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
/*     */ public class Tooltip<T extends Actor>
/*     */   extends InputListener
/*     */ {
/*  31 */   static Vector2 tmp = new Vector2();
/*     */   private final TooltipManager manager;
/*     */   final Container<T> container;
/*     */   boolean instant;
/*     */   boolean always;
/*     */   boolean touchIndependent;
/*     */   Actor targetActor;
/*     */   
/*     */   public Tooltip(@Null T paramT) {
/*  40 */     this(paramT, TooltipManager.getInstance());
/*     */   }
/*     */ 
/*     */   
/*     */   public Tooltip(@Null T paramT, TooltipManager paramTooltipManager) {
/*  45 */     this.manager = paramTooltipManager;
/*     */     
/*  47 */     this.container = new Container<T>((Actor)paramT) {
/*     */         public void act(float param1Float) {
/*  49 */           super.act(param1Float);
/*  50 */           if (Tooltip.this.targetActor != null && Tooltip.this.targetActor.getStage() == null) remove(); 
/*     */         }
/*     */       };
/*  53 */     this.container.setTouchable(Touchable.disabled);
/*     */   }
/*     */   
/*     */   public TooltipManager getManager() {
/*  57 */     return this.manager;
/*     */   }
/*     */   
/*     */   public Container<T> getContainer() {
/*  61 */     return this.container;
/*     */   }
/*     */   
/*     */   public void setActor(@Null T paramT) {
/*  65 */     this.container.setActor(paramT);
/*     */   }
/*     */   @Null
/*     */   public T getActor() {
/*  69 */     return this.container.getActor();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setInstant(boolean paramBoolean) {
/*  74 */     this.instant = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAlways(boolean paramBoolean) {
/*  79 */     this.always = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTouchIndependent(boolean paramBoolean) {
/*  84 */     this.touchIndependent = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean touchDown(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2) {
/*  88 */     if (this.instant) {
/*  89 */       this.container.toFront();
/*  90 */       return false;
/*     */     } 
/*  92 */     this.manager.touchDown(this);
/*  93 */     return false;
/*     */   }
/*     */   
/*     */   public boolean mouseMoved(InputEvent paramInputEvent, float paramFloat1, float paramFloat2) {
/*  97 */     if (this.container.hasParent()) return false; 
/*  98 */     setContainerPosition(paramInputEvent.getListenerActor(), paramFloat1, paramFloat2);
/*  99 */     return true;
/*     */   }
/*     */   
/*     */   private void setContainerPosition(Actor paramActor, float paramFloat1, float paramFloat2) {
/* 103 */     this.targetActor = paramActor;
/*     */     Stage stage;
/* 105 */     if ((stage = paramActor.getStage()) == null)
/*     */       return; 
/* 107 */     this.container.setSize(this.manager.maxWidth, 2.1474836E9F);
/* 108 */     this.container.validate();
/* 109 */     this.container.width(this.container.getActor().getWidth());
/* 110 */     this.container.pack();
/*     */     
/* 112 */     float f1 = this.manager.offsetX, f2 = this.manager.offsetY, f3 = this.manager.edgeDistance;
/*     */     Vector2 vector2;
/* 114 */     if ((vector2 = paramActor.localToStageCoordinates(tmp.set(paramFloat1 + f1, paramFloat2 - f2 - this.container.getHeight()))).y < f3) vector2 = paramActor.localToStageCoordinates(tmp.set(paramFloat1 + f1, paramFloat2 + f2)); 
/* 115 */     if (vector2.x < f3) vector2.x = f3; 
/* 116 */     if (vector2.x + this.container.getWidth() > stage.getWidth() - f3) vector2.x = stage.getWidth() - f3 - this.container.getWidth(); 
/* 117 */     if (vector2.y + this.container.getHeight() > stage.getHeight() - f3) vector2.y = stage.getHeight() - f3 - this.container.getHeight(); 
/* 118 */     this.container.setPosition(vector2.x, vector2.y);
/*     */ 
/*     */     
/* 121 */     (vector2 = paramActor.localToStageCoordinates(tmp.set(paramActor.getWidth() / 2.0F, paramActor.getHeight() / 2.0F))).sub(this.container.getX(), this.container.getY());
/* 122 */     this.container.setOrigin(vector2.x, vector2.y);
/*     */   }
/*     */   
/*     */   public void enter(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt, @Null Actor paramActor) {
/* 126 */     if (paramInt != -1)
/* 127 */       return;  if (this.touchIndependent && Gdx.input.isTouched())
/* 128 */       return;  Actor actor = paramInputEvent.getListenerActor();
/* 129 */     if (paramActor != null && paramActor.isDescendantOf(actor))
/* 130 */       return;  setContainerPosition(actor, paramFloat1, paramFloat2);
/* 131 */     this.manager.enter(this);
/*     */   }
/*     */   
/*     */   public void exit(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt, @Null Actor paramActor) {
/* 135 */     if (paramActor != null && paramActor.isDescendantOf(paramInputEvent.getListenerActor()))
/* 136 */       return;  hide();
/*     */   }
/*     */   
/*     */   public void hide() {
/* 140 */     this.manager.hide(this);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\ui\Tooltip.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */