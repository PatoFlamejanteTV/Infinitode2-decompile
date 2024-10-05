/*     */ package com.prineside.tdi2.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.Stage;
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
/*     */ public class Widget
/*     */   extends Actor
/*     */   implements Layout
/*     */ {
/*     */   private boolean j = true;
/*     */   private boolean k;
/*     */   private boolean l = true;
/*     */   @Null
/*     */   private Value m;
/*     */   @Null
/*     */   private Value n;
/*     */   @Null
/*     */   private Value o;
/*     */   @Null
/*     */   private Value p;
/*     */   @Null
/*     */   private Value q;
/*     */   @Null
/*     */   private Value r;
/*     */   
/*     */   public float getMinWidth() {
/*  49 */     return (this.m == null) ? 0.0F : this.m.get(this);
/*     */   }
/*     */   
/*     */   public void setMinWidth(float paramFloat) {
/*  53 */     setMinWidth(new Value.Fixed(paramFloat));
/*     */   }
/*     */   
/*     */   public void setMinWidth(@Null Value paramValue) {
/*  57 */     this.m = paramValue;
/*  58 */     invalidateHierarchy();
/*     */   }
/*     */   @Null
/*     */   public Value getMinWidthValue() {
/*  62 */     return this.m;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getPrefWidth() {
/*  71 */     return (this.o == null) ? 0.0F : this.o.get(this);
/*     */   }
/*     */   
/*     */   public void setPrefWidth(@Null Value paramValue) {
/*  75 */     this.o = paramValue;
/*  76 */     invalidateHierarchy();
/*     */   }
/*     */   
/*     */   public void setPrefWidth(float paramFloat) {
/*  80 */     setPrefWidth(new Value.Fixed(paramFloat));
/*     */   }
/*     */   @Null
/*     */   public Value getPrefWidthValue() {
/*  84 */     return this.o;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getMaxWidth() {
/*  93 */     return (this.q == null) ? Float.MAX_VALUE : this.q.get(this);
/*     */   }
/*     */   
/*     */   public void setMaxWidth(@Null Value paramValue) {
/*  97 */     this.q = paramValue;
/*  98 */     invalidateHierarchy();
/*     */   }
/*     */   
/*     */   public void setMaxWidth(float paramFloat) {
/* 102 */     setMaxWidth(new Value.Fixed(paramFloat));
/*     */   }
/*     */   @Null
/*     */   public Value getMaxWidthValue() {
/* 106 */     return this.q;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getMinHeight() {
/* 115 */     return (this.n == null) ? 0.0F : this.n.get(this);
/*     */   }
/*     */   
/*     */   public void setMinHeight(@Null Value paramValue) {
/* 119 */     this.n = paramValue;
/* 120 */     invalidateHierarchy();
/*     */   }
/*     */   
/*     */   public void setMinHeight(float paramFloat) {
/* 124 */     setMinHeight(new Value.Fixed(paramFloat));
/*     */   }
/*     */   @Null
/*     */   public Value getMinHeightValue() {
/* 128 */     return this.n;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getPrefHeight() {
/* 137 */     return (this.p == null) ? 0.0F : this.p.get(this);
/*     */   }
/*     */   
/*     */   public void setPrefHeight(@Null Value paramValue) {
/* 141 */     this.p = paramValue;
/* 142 */     invalidateHierarchy();
/*     */   }
/*     */   
/*     */   public void setPrefHeight(float paramFloat) {
/* 146 */     setPrefHeight(new Value.Fixed(paramFloat));
/*     */   }
/*     */   @Null
/*     */   public Value getPrefHeightValue() {
/* 150 */     return this.p;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getMaxHeight() {
/* 159 */     return (this.r == null) ? Float.MAX_VALUE : this.r.get(this);
/*     */   }
/*     */   
/*     */   public void setMaxHeight(@Null Value paramValue) {
/* 163 */     this.r = paramValue;
/* 164 */     invalidateHierarchy();
/*     */   }
/*     */   
/*     */   public void setMaxHeight(float paramFloat) {
/* 168 */     setMaxHeight(new Value.Fixed(paramFloat));
/*     */   }
/*     */   @Null
/*     */   public Value getMaxHeightValue() {
/* 172 */     return this.r;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLayoutEnabled(boolean paramBoolean) {
/* 181 */     this.l = paramBoolean;
/* 182 */     if (paramBoolean) invalidateHierarchy();
/*     */   
/*     */   }
/*     */   
/*     */   public void validate() {
/* 187 */     if (!this.l)
/*     */       return; 
/* 189 */     Group group = getParent();
/* 190 */     if (this.k && group != null) {
/*     */       float f1, f2;
/*     */       Stage stage;
/* 193 */       if ((stage = getStage()) != null && group == stage.getRoot()) {
/* 194 */         f2 = stage.getWidth();
/* 195 */         f1 = stage.getHeight();
/*     */       } else {
/* 197 */         f2 = f1.getWidth();
/* 198 */         f1 = f1.getHeight();
/*     */       } 
/* 200 */       setSize(f2, f1);
/*     */     } 
/*     */     
/* 203 */     if (!this.j)
/* 204 */       return;  this.j = false;
/* 205 */     layout();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean needsLayout() {
/* 210 */     return this.j;
/*     */   }
/*     */ 
/*     */   
/*     */   public void invalidate() {
/* 215 */     this.j = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void invalidateHierarchy() {
/* 220 */     if (!this.l)
/* 221 */       return;  invalidate();
/*     */     Group group;
/* 223 */     if (group = getParent() instanceof Layout) ((Layout)group).invalidateHierarchy();
/*     */   
/*     */   }
/*     */   
/*     */   protected void sizeChanged() {
/* 228 */     invalidate();
/*     */   }
/*     */ 
/*     */   
/*     */   public void pack() {
/* 233 */     setSize(getPrefWidth(), getPrefHeight());
/* 234 */     validate();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFillParent(boolean paramBoolean) {
/* 239 */     this.k = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/* 245 */     validate();
/*     */   }
/*     */   
/*     */   public void layout() {}
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\ui\Widget.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */