/*     */ package com.badlogic.gdx.scenes.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*     */ import com.badlogic.gdx.scenes.scene2d.Touchable;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.Layout;
/*     */ import com.badlogic.gdx.utils.Array;
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
/*     */ 
/*     */ 
/*     */ public class Stack
/*     */   extends WidgetGroup
/*     */ {
/*     */   private float prefWidth;
/*     */   private float prefHeight;
/*     */   private float minWidth;
/*     */   private float minHeight;
/*     */   private float maxWidth;
/*     */   private float maxHeight;
/*     */   private boolean sizeInvalid = true;
/*     */   
/*     */   public Stack() {
/*  46 */     setTransform(false);
/*  47 */     setWidth(150.0F);
/*  48 */     setHeight(150.0F);
/*  49 */     setTouchable(Touchable.childrenOnly);
/*     */   }
/*     */   
/*     */   public Stack(Actor... paramVarArgs) {
/*  53 */     this(); int i; byte b;
/*  54 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { Actor actor = paramVarArgs[b];
/*  55 */       addActor(actor);
/*     */       b++; }
/*     */   
/*     */   } public void invalidate() {
/*  59 */     super.invalidate();
/*  60 */     this.sizeInvalid = true;
/*     */   }
/*     */   
/*     */   private void computeSize() {
/*  64 */     this.sizeInvalid = false;
/*  65 */     this.prefWidth = 0.0F;
/*  66 */     this.prefHeight = 0.0F;
/*  67 */     this.minWidth = 0.0F;
/*  68 */     this.minHeight = 0.0F;
/*  69 */     this.maxWidth = 0.0F;
/*  70 */     this.maxHeight = 0.0F;
/*  71 */     SnapshotArray snapshotArray = getChildren(); byte b; int i;
/*  72 */     for (b = 0, i = snapshotArray.size; b < i; b++) {
/*     */       float f1; float f2;
/*     */       Actor actor;
/*  75 */       if (actor = (Actor)snapshotArray.get(b) instanceof Layout) {
/*  76 */         Layout layout = (Layout)actor;
/*  77 */         this.prefWidth = Math.max(this.prefWidth, layout.getPrefWidth());
/*  78 */         this.prefHeight = Math.max(this.prefHeight, layout.getPrefHeight());
/*  79 */         this.minWidth = Math.max(this.minWidth, layout.getMinWidth());
/*  80 */         this.minHeight = Math.max(this.minHeight, layout.getMinHeight());
/*  81 */         f1 = layout.getMaxWidth();
/*  82 */         f2 = layout.getMaxHeight();
/*     */       } else {
/*  84 */         this.prefWidth = Math.max(this.prefWidth, f1.getWidth());
/*  85 */         this.prefHeight = Math.max(this.prefHeight, f1.getHeight());
/*  86 */         this.minWidth = Math.max(this.minWidth, f1.getWidth());
/*  87 */         this.minHeight = Math.max(this.minHeight, f1.getHeight());
/*  88 */         f1 = 0.0F;
/*  89 */         f2 = 0.0F;
/*     */       } 
/*  91 */       if (f1 > 0.0F) this.maxWidth = (this.maxWidth == 0.0F) ? f1 : Math.min(this.maxWidth, f1); 
/*  92 */       if (f2 > 0.0F) this.maxHeight = (this.maxHeight == 0.0F) ? f2 : Math.min(this.maxHeight, f2); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void add(Actor paramActor) {
/*  97 */     addActor(paramActor);
/*     */   }
/*     */   
/*     */   public void layout() {
/* 101 */     if (this.sizeInvalid) computeSize(); 
/* 102 */     float f1 = getWidth(), f2 = getHeight();
/* 103 */     SnapshotArray snapshotArray = getChildren(); byte b; int i;
/* 104 */     for (b = 0, i = ((Array)snapshotArray).size; b < i; b++) {
/*     */       Actor actor;
/* 106 */       (actor = (Actor)snapshotArray.get(b)).setBounds(0.0F, 0.0F, f1, f2);
/* 107 */       if (actor instanceof Layout) ((Layout)actor).validate(); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public float getPrefWidth() {
/* 112 */     if (this.sizeInvalid) computeSize(); 
/* 113 */     return this.prefWidth;
/*     */   }
/*     */   
/*     */   public float getPrefHeight() {
/* 117 */     if (this.sizeInvalid) computeSize(); 
/* 118 */     return this.prefHeight;
/*     */   }
/*     */   
/*     */   public float getMinWidth() {
/* 122 */     if (this.sizeInvalid) computeSize(); 
/* 123 */     return this.minWidth;
/*     */   }
/*     */   
/*     */   public float getMinHeight() {
/* 127 */     if (this.sizeInvalid) computeSize(); 
/* 128 */     return this.minHeight;
/*     */   }
/*     */   
/*     */   public float getMaxWidth() {
/* 132 */     if (this.sizeInvalid) computeSize(); 
/* 133 */     return this.maxWidth;
/*     */   }
/*     */   
/*     */   public float getMaxHeight() {
/* 137 */     if (this.sizeInvalid) computeSize(); 
/* 138 */     return this.maxHeight;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\ui\Stack.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */