/*     */ package com.prineside.tdi2.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.SnapshotArray;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.utils.Layout;
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
/*     */   private float k;
/*     */   private float l;
/*     */   private float m;
/*     */   private float n;
/*     */   private float o;
/*     */   private float p;
/*     */   private boolean q = true;
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
/*  60 */     this.q = true;
/*     */   }
/*     */   
/*     */   private void d() {
/*  64 */     this.q = false;
/*  65 */     this.k = 0.0F;
/*  66 */     this.l = 0.0F;
/*  67 */     this.m = 0.0F;
/*  68 */     this.n = 0.0F;
/*  69 */     this.o = 0.0F;
/*  70 */     this.p = 0.0F;
/*  71 */     SnapshotArray snapshotArray = getChildren(); byte b; int i;
/*  72 */     for (b = 0, i = snapshotArray.size; b < i; b++) {
/*     */       float f1; float f2;
/*     */       Actor actor;
/*  75 */       if (actor = (Actor)snapshotArray.get(b) instanceof Layout) {
/*  76 */         Layout layout = (Layout)actor;
/*  77 */         this.k = Math.max(this.k, layout.getPrefWidth());
/*  78 */         this.l = Math.max(this.l, layout.getPrefHeight());
/*  79 */         this.m = Math.max(this.m, layout.getMinWidth());
/*  80 */         this.n = Math.max(this.n, layout.getMinHeight());
/*  81 */         f1 = layout.getMaxWidth();
/*  82 */         f2 = layout.getMaxHeight();
/*     */       } else {
/*  84 */         this.k = Math.max(this.k, f1.getWidth());
/*  85 */         this.l = Math.max(this.l, f1.getHeight());
/*  86 */         this.m = Math.max(this.m, f1.getWidth());
/*  87 */         this.n = Math.max(this.n, f1.getHeight());
/*  88 */         f1 = 0.0F;
/*  89 */         f2 = 0.0F;
/*     */       } 
/*  91 */       if (f1 > 0.0F) this.o = (this.o == 0.0F) ? f1 : Math.min(this.o, f1); 
/*  92 */       if (f2 > 0.0F) this.p = (this.p == 0.0F) ? f2 : Math.min(this.p, f2); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void add(Actor paramActor) {
/*  97 */     addActor(paramActor);
/*     */   }
/*     */   
/*     */   public void layout() {
/* 101 */     if (this.q) d(); 
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
/* 112 */     if (this.q) d(); 
/* 113 */     return this.k;
/*     */   }
/*     */   
/*     */   public float getPrefHeight() {
/* 117 */     if (this.q) d(); 
/* 118 */     return this.l;
/*     */   }
/*     */   
/*     */   public float getMinWidth() {
/* 122 */     if (this.q) d(); 
/* 123 */     return this.m;
/*     */   }
/*     */   
/*     */   public float getMinHeight() {
/* 127 */     if (this.q) d(); 
/* 128 */     return this.n;
/*     */   }
/*     */   
/*     */   public float getMaxWidth() {
/* 132 */     if (this.q) d(); 
/* 133 */     return this.o;
/*     */   }
/*     */   
/*     */   public float getMaxHeight() {
/* 137 */     if (this.q) d(); 
/* 138 */     return this.p;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\ui\Stack.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */