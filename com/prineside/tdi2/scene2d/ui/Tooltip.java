/*     */ package com.prineside.tdi2.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.InputListener;
/*     */ import com.prineside.tdi2.scene2d.Stage;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
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
/*  31 */   private static Vector2 e = new Vector2();
/*     */   private final TooltipManager f;
/*     */   final Container<T> a;
/*     */   boolean b;
/*     */   boolean c;
/*     */   private boolean g;
/*     */   Actor d;
/*     */   
/*     */   public Tooltip(@Null T paramT) {
/*  40 */     this(paramT, TooltipManager.getInstance());
/*     */   }
/*     */ 
/*     */   
/*     */   public Tooltip(@Null T paramT, TooltipManager paramTooltipManager) {
/*  45 */     this.f = paramTooltipManager;
/*     */     
/*  47 */     this.a = new Container<T>(this, (Actor)paramT) {
/*     */         public void act(float param1Float) {
/*  49 */           super.act(param1Float);
/*  50 */           if (this.k.d != null && this.k.d.getStage() == null) remove(); 
/*     */         }
/*     */       };
/*  53 */     this.a.setTouchable(Touchable.disabled);
/*     */   }
/*     */   
/*     */   public TooltipManager getManager() {
/*  57 */     return this.f;
/*     */   }
/*     */   
/*     */   public Container<T> getContainer() {
/*  61 */     return this.a;
/*     */   }
/*     */   
/*     */   public void setActor(@Null T paramT) {
/*  65 */     this.a.setActor(paramT);
/*     */   }
/*     */   @Null
/*     */   public T getActor() {
/*  69 */     return this.a.getActor();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setInstant(boolean paramBoolean) {
/*  74 */     this.b = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAlways(boolean paramBoolean) {
/*  79 */     this.c = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTouchIndependent(boolean paramBoolean) {
/*  84 */     this.g = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean touchDown(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2) {
/*  88 */     if (this.b) {
/*  89 */       this.a.toFront();
/*  90 */       return false;
/*     */     } 
/*  92 */     this.f.touchDown(this);
/*  93 */     return false;
/*     */   }
/*     */   
/*     */   public boolean mouseMoved(InputEvent paramInputEvent, float paramFloat1, float paramFloat2) {
/*  97 */     if (this.a.hasParent()) return false; 
/*  98 */     a(paramInputEvent.getListenerActor(), paramFloat1, paramFloat2);
/*  99 */     return true;
/*     */   }
/*     */   
/*     */   private void a(Actor paramActor, float paramFloat1, float paramFloat2) {
/* 103 */     this.d = paramActor;
/*     */     Stage stage;
/* 105 */     if ((stage = paramActor.getStage()) == null)
/*     */       return; 
/* 107 */     this.a.setSize(this.f.maxWidth, 2.1474836E9F);
/* 108 */     this.a.validate();
/* 109 */     this.a.width(this.a.getActor().getWidth());
/* 110 */     this.a.pack();
/*     */     
/* 112 */     float f1 = this.f.offsetX, f2 = this.f.offsetY, f3 = this.f.edgeDistance;
/*     */     Vector2 vector2;
/* 114 */     if ((vector2 = paramActor.localToStageCoordinates(e.set(paramFloat1 + f1, paramFloat2 - f2 - this.a.getHeight()))).y < f3) vector2 = paramActor.localToStageCoordinates(e.set(paramFloat1 + f1, paramFloat2 + f2)); 
/* 115 */     if (vector2.x < f3) vector2.x = f3; 
/* 116 */     if (vector2.x + this.a.getWidth() > stage.getWidth() - f3) vector2.x = stage.getWidth() - f3 - this.a.getWidth(); 
/* 117 */     if (vector2.y + this.a.getHeight() > stage.getHeight() - f3) vector2.y = stage.getHeight() - f3 - this.a.getHeight(); 
/* 118 */     this.a.setPosition(vector2.x, vector2.y);
/*     */ 
/*     */     
/* 121 */     (vector2 = paramActor.localToStageCoordinates(e.set(paramActor.getWidth() / 2.0F, paramActor.getHeight() / 2.0F))).sub(this.a.getX(), this.a.getY());
/* 122 */     this.a.setOrigin(vector2.x, vector2.y);
/*     */   }
/*     */   
/*     */   public void enter(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt, @Null Actor paramActor) {
/* 126 */     if (paramInt != -1)
/* 127 */       return;  if (this.g && Gdx.input.isTouched())
/* 128 */       return;  Actor actor = paramInputEvent.getListenerActor();
/* 129 */     if (paramActor != null && paramActor.isDescendantOf(actor))
/* 130 */       return;  a(actor, paramFloat1, paramFloat2);
/* 131 */     this.f.enter(this);
/*     */   }
/*     */   
/*     */   public void exit(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt, @Null Actor paramActor) {
/* 135 */     if (paramActor != null && paramActor.isDescendantOf(paramInputEvent.getListenerActor()))
/* 136 */       return;  hide();
/*     */   }
/*     */   
/*     */   public void hide() {
/* 140 */     this.f.hide(this);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\ui\Tooltip.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */