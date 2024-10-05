/*     */ package com.badlogic.gdx.scenes.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*     */ import com.badlogic.gdx.scenes.scene2d.Group;
/*     */ import com.badlogic.gdx.scenes.scene2d.Stage;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.Layout;
/*     */ import com.badlogic.gdx.utils.SnapshotArray;
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
/*     */ public class WidgetGroup
/*     */   extends Group
/*     */   implements Layout
/*     */ {
/*     */   private boolean needsLayout = true;
/*     */   private boolean fillParent;
/*     */   private boolean layoutEnabled = true;
/*     */   
/*     */   public WidgetGroup() {}
/*     */   
/*     */   public WidgetGroup(Actor... paramVarArgs) {
/*     */     int i;
/*     */     byte b;
/*  46 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { Actor actor = paramVarArgs[b];
/*  47 */       addActor(actor);
/*     */       b++; }
/*     */   
/*     */   } public float getMinWidth() {
/*  51 */     return getPrefWidth();
/*     */   }
/*     */   
/*     */   public float getMinHeight() {
/*  55 */     return getPrefHeight();
/*     */   }
/*     */   
/*     */   public float getPrefWidth() {
/*  59 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public float getPrefHeight() {
/*  63 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public float getMaxWidth() {
/*  67 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public float getMaxHeight() {
/*  71 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public void setLayoutEnabled(boolean paramBoolean) {
/*  75 */     this.layoutEnabled = paramBoolean;
/*  76 */     setLayoutEnabled(this, paramBoolean);
/*     */   }
/*     */   
/*     */   private void setLayoutEnabled(Group paramGroup, boolean paramBoolean) {
/*  80 */     SnapshotArray snapshotArray = paramGroup.getChildren(); byte b; int i;
/*  81 */     for (b = 0, i = snapshotArray.size; b < i; b++) {
/*     */       Actor actor;
/*  83 */       if (actor = (Actor)snapshotArray.get(b) instanceof Layout) {
/*  84 */         ((Layout)actor).setLayoutEnabled(paramBoolean);
/*  85 */       } else if (actor instanceof Group) {
/*  86 */         setLayoutEnabled((Group)actor, paramBoolean);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   public void validate() {
/*  91 */     if (!this.layoutEnabled)
/*     */       return; 
/*  93 */     Group group = getParent();
/*  94 */     if (this.fillParent && group != null) {
/*     */       Stage stage;
/*  96 */       if ((stage = getStage()) != null && group == stage.getRoot()) {
/*  97 */         setSize(stage.getWidth(), stage.getHeight());
/*     */       } else {
/*  99 */         setSize(group.getWidth(), group.getHeight());
/*     */       } 
/*     */     } 
/* 102 */     if (!this.needsLayout)
/* 103 */       return;  this.needsLayout = false;
/* 104 */     layout();
/*     */ 
/*     */ 
/*     */     
/* 108 */     if (this.needsLayout) {
/* 109 */       if (group instanceof WidgetGroup)
/* 110 */         return;  for (byte b = 0; b < 5; ) {
/* 111 */         this.needsLayout = false;
/* 112 */         layout();
/* 113 */         if (this.needsLayout)
/*     */           b++; 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean needsLayout() {
/* 120 */     return this.needsLayout;
/*     */   }
/*     */   
/*     */   public void invalidate() {
/* 124 */     this.needsLayout = true;
/*     */   }
/*     */   
/*     */   public void invalidateHierarchy() {
/* 128 */     invalidate();
/*     */     Group group;
/* 130 */     if (group = getParent() instanceof Layout) ((Layout)group).invalidateHierarchy(); 
/*     */   }
/*     */   
/*     */   protected void childrenChanged() {
/* 134 */     invalidateHierarchy();
/*     */   }
/*     */   
/*     */   protected void sizeChanged() {
/* 138 */     invalidate();
/*     */   }
/*     */   
/*     */   public void pack() {
/* 142 */     setSize(getPrefWidth(), getPrefHeight());
/* 143 */     validate();
/*     */ 
/*     */     
/* 146 */     setSize(getPrefWidth(), getPrefHeight());
/* 147 */     validate();
/*     */   }
/*     */   
/*     */   public void setFillParent(boolean paramBoolean) {
/* 151 */     this.fillParent = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void layout() {}
/*     */ 
/*     */   
/*     */   public Actor hit(float paramFloat1, float paramFloat2, boolean paramBoolean) {
/* 160 */     validate();
/* 161 */     return super.hit(paramFloat1, paramFloat2, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/* 167 */     validate();
/* 168 */     super.draw(paramBatch, paramFloat);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\ui\WidgetGroup.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */