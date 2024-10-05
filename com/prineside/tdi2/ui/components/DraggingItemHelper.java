/*     */ package com.prineside.tdi2.ui.components;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.Render;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ 
/*     */ public class DraggingItemHelper implements Disposable, Listener<Render> {
/*  14 */   private final UiManager.UiLayer a = Game.i.uiManager.addLayerIgnoreSafeArea(UiManager.MainUiLayer.SCREEN, 113, "DraggingItemHelper", true);
/*     */   
/*     */   private final Group b;
/*     */   
/*     */   private final Group c;
/*  19 */   private float d = 1.0F;
/*  20 */   private float e = 0.0F;
/*  21 */   private Vector2 f = new Vector2();
/*     */   
/*     */   private float g;
/*     */   
/*     */   public DraggingItemHelper(GameSystemProvider paramGameSystemProvider) {
/*     */     Group group;
/*  27 */     (group = new Group()).setTransform(false);
/*  28 */     group.setTouchable(Touchable.disabled);
/*     */     
/*  30 */     this.a.getTable().add((Actor)group).expand().bottom().left().size(100.0F);
/*     */     
/*  32 */     this.b = new Group();
/*  33 */     this.b.setTransform(false);
/*  34 */     this.b.setSize(1.0F, 1.0F);
/*  35 */     group.addActor((Actor)this.b);
/*     */     
/*  37 */     this.c = new Group();
/*  38 */     this.c.setTransform(true);
/*  39 */     this.c.setSize(1.0F, 1.0F);
/*  40 */     this.c.setOrigin(0.5F, 0.5F);
/*  41 */     this.b.addActor((Actor)this.c);
/*     */ 
/*     */     
/*  44 */     this.c.setVisible(false);
/*     */     
/*  46 */     paramGameSystemProvider.events.getListeners(Render.class).add(this);
/*     */   }
/*     */   
/*     */   public Group show() {
/*  50 */     this.c.setVisible(true);
/*  51 */     this.c.clearChildren();
/*  52 */     this.c.setScale(this.e);
/*  53 */     return this.c;
/*     */   }
/*     */   
/*     */   public Group getIconContainer() {
/*  57 */     return this.c;
/*     */   }
/*     */   
/*     */   public void hide() {
/*  61 */     this.c.setVisible(false);
/*     */   }
/*     */   
/*     */   public void setPosition(float paramFloat1, float paramFloat2) {
/*  65 */     this.c.setPosition(paramFloat1, paramFloat2);
/*     */   }
/*     */   
/*     */   public void setScale(float paramFloat) {
/*  69 */     this.d = paramFloat;
/*     */   }
/*     */   
/*     */   public void setScaleInstantly(float paramFloat) {
/*  73 */     this.d = paramFloat;
/*  74 */     this.e = paramFloat;
/*     */   }
/*     */   
/*     */   public void setIconShift(float paramFloat1, float paramFloat2) {
/*  78 */     this.f.set(paramFloat1, paramFloat2);
/*     */   }
/*     */   
/*     */   public void setIconShiftInstantly(float paramFloat1, float paramFloat2) {
/*  82 */     this.f.set(paramFloat1, paramFloat2);
/*  83 */     this.b.setPosition(paramFloat1, paramFloat2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/*  88 */     Game.i.uiManager.removeLayer(this.a);
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleEvent(Render paramRender) {
/*  93 */     this.g += paramRender.getRealDeltaTime();
/*  94 */     if (this.g > 0.0166F) {
/*  95 */       this.g %= 0.0166F;
/*     */       
/*  97 */       if (this.f.x != this.b.getX() || this.f.y != this.b.getY()) {
/*  98 */         this.b.setX(this.b.getX() + (this.f.x - this.b.getX()) * 0.15F);
/*  99 */         this.b.setY(this.b.getY() + (this.f.y - this.b.getY()) * 0.15F);
/* 100 */         if ((Math.abs(this.f.x - this.b.getX()) + Math.abs(this.f.y - this.b.getY())) < 0.5D) {
/* 101 */           this.b.setPosition(this.f.x, this.f.y);
/*     */         }
/*     */       } 
/* 104 */       if (this.d != this.c.getScaleX()) {
/* 105 */         this.c.setScale(this.c.getScaleX() + (this.d - this.c.getScaleX()) * 0.15F);
/* 106 */         if (Math.abs(this.c.getScaleX() - this.d) < 0.01D)
/* 107 */           this.c.setScale(this.d, this.d); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\DraggingItemHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */