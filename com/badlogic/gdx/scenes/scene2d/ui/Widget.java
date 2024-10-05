/*     */ package com.badlogic.gdx.scenes.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*     */ import com.badlogic.gdx.scenes.scene2d.Group;
/*     */ import com.badlogic.gdx.scenes.scene2d.Stage;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.Layout;
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
/*     */ public class Widget
/*     */   extends Actor
/*     */   implements Layout
/*     */ {
/*     */   private boolean needsLayout = true;
/*     */   private boolean fillParent;
/*     */   private boolean layoutEnabled = true;
/*     */   
/*     */   public float getMinWidth() {
/*  41 */     return getPrefWidth();
/*     */   }
/*     */   
/*     */   public float getMinHeight() {
/*  45 */     return getPrefHeight();
/*     */   }
/*     */   
/*     */   public float getPrefWidth() {
/*  49 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public float getPrefHeight() {
/*  53 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public float getMaxWidth() {
/*  57 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public float getMaxHeight() {
/*  61 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public void setLayoutEnabled(boolean paramBoolean) {
/*  65 */     this.layoutEnabled = paramBoolean;
/*  66 */     if (paramBoolean) invalidateHierarchy(); 
/*     */   }
/*     */   
/*     */   public void validate() {
/*  70 */     if (!this.layoutEnabled)
/*     */       return; 
/*  72 */     Group group = getParent();
/*  73 */     if (this.fillParent && group != null) {
/*     */       float f1, f2;
/*     */       Stage stage;
/*  76 */       if ((stage = getStage()) != null && group == stage.getRoot()) {
/*  77 */         f2 = stage.getWidth();
/*  78 */         f1 = stage.getHeight();
/*     */       } else {
/*  80 */         f2 = f1.getWidth();
/*  81 */         f1 = f1.getHeight();
/*     */       } 
/*  83 */       setSize(f2, f1);
/*     */     } 
/*     */     
/*  86 */     if (!this.needsLayout)
/*  87 */       return;  this.needsLayout = false;
/*  88 */     layout();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean needsLayout() {
/*  93 */     return this.needsLayout;
/*     */   }
/*     */   
/*     */   public void invalidate() {
/*  97 */     this.needsLayout = true;
/*     */   }
/*     */   
/*     */   public void invalidateHierarchy() {
/* 101 */     if (!this.layoutEnabled)
/* 102 */       return;  invalidate();
/*     */     Group group;
/* 104 */     if (group = getParent() instanceof Layout) ((Layout)group).invalidateHierarchy(); 
/*     */   }
/*     */   
/*     */   protected void sizeChanged() {
/* 108 */     invalidate();
/*     */   }
/*     */   
/*     */   public void pack() {
/* 112 */     setSize(getPrefWidth(), getPrefHeight());
/* 113 */     validate();
/*     */   }
/*     */   
/*     */   public void setFillParent(boolean paramBoolean) {
/* 117 */     this.fillParent = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/* 122 */     validate();
/*     */   }
/*     */   
/*     */   public void layout() {}
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\ui\Widget.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */