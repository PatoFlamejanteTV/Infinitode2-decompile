/*     */ package com.prineside.tdi2.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.SnapshotArray;
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
/*     */ public class WidgetGroup
/*     */   extends Group
/*     */   implements Layout
/*     */ {
/*     */   private boolean k = true;
/*     */   private boolean l;
/*     */   private boolean m = true;
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
/*     */   @Null
/*     */   private Value s;
/*     */   
/*     */   public WidgetGroup() {}
/*     */   
/*     */   public WidgetGroup(Actor... paramVarArgs) {
/*     */     int i;
/*     */     byte b;
/*  53 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { Actor actor = paramVarArgs[b];
/*  54 */       addActor(actor);
/*     */       b++; }
/*     */   
/*     */   }
/*     */   public float getMinWidth() {
/*  59 */     return (this.n == null) ? 0.0F : this.n.get((Actor)this);
/*     */   }
/*     */   
/*     */   public void setMinWidth(float paramFloat) {
/*  63 */     setMinWidth(new Value.Fixed(paramFloat));
/*     */   }
/*     */   
/*     */   public void setMinWidth(@Null Value paramValue) {
/*  67 */     this.n = paramValue;
/*  68 */     invalidateHierarchy();
/*     */   }
/*     */   @Null
/*     */   public Value getMinWidthValue() {
/*  72 */     return this.n;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getMinHeight() {
/*  81 */     return (this.o == null) ? 0.0F : this.o.get((Actor)this);
/*     */   }
/*     */   
/*     */   public void setMinHeight(@Null Value paramValue) {
/*  85 */     this.o = paramValue;
/*  86 */     invalidateHierarchy();
/*     */   }
/*     */   
/*     */   public void setMinHeight(float paramFloat) {
/*  90 */     setMinHeight(new Value.Fixed(paramFloat));
/*     */   }
/*     */   @Null
/*     */   public Value getMinHeightValue() {
/*  94 */     return this.o;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getPrefWidth() {
/* 103 */     return (this.p == null) ? 0.0F : this.p.get((Actor)this);
/*     */   }
/*     */   
/*     */   public void setPrefWidth(@Null Value paramValue) {
/* 107 */     this.p = paramValue;
/* 108 */     invalidateHierarchy();
/*     */   }
/*     */   
/*     */   public void setPrefWidth(float paramFloat) {
/* 112 */     setPrefWidth(new Value.Fixed(paramFloat));
/*     */   }
/*     */   @Null
/*     */   public Value getPrefWidthValue() {
/* 116 */     return this.p;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getPrefHeight() {
/* 125 */     return (this.q == null) ? 0.0F : this.q.get((Actor)this);
/*     */   }
/*     */   
/*     */   public void setPrefHeight(@Null Value paramValue) {
/* 129 */     this.q = paramValue;
/* 130 */     invalidateHierarchy();
/*     */   }
/*     */   
/*     */   public void setPrefHeight(float paramFloat) {
/* 134 */     setPrefHeight(new Value.Fixed(paramFloat));
/*     */   }
/*     */   @Null
/*     */   public Value getPrefHeightValue() {
/* 138 */     return this.q;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getMaxWidth() {
/* 147 */     return (this.r == null) ? Float.MAX_VALUE : this.r.get((Actor)this);
/*     */   }
/*     */   
/*     */   public void setMaxWidth(@Null Value paramValue) {
/* 151 */     this.r = paramValue;
/* 152 */     invalidateHierarchy();
/*     */   }
/*     */   
/*     */   public void setMaxWidth(float paramFloat) {
/* 156 */     setMaxWidth(new Value.Fixed(paramFloat));
/*     */   }
/*     */   @Null
/*     */   public Value getMaxWidthValue() {
/* 160 */     return this.r;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getMaxHeight() {
/* 169 */     return (this.s == null) ? Float.MAX_VALUE : this.s.get((Actor)this);
/*     */   }
/*     */   
/*     */   public void setMaxHeight(@Null Value paramValue) {
/* 173 */     this.s = paramValue;
/* 174 */     invalidateHierarchy();
/*     */   }
/*     */   
/*     */   public void setMaxHeight(float paramFloat) {
/* 178 */     setMaxHeight(new Value.Fixed(paramFloat));
/*     */   }
/*     */   @Null
/*     */   public Value getMaxHeightValue() {
/* 182 */     return this.s;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLayoutEnabled(boolean paramBoolean) {
/* 190 */     this.m = paramBoolean;
/* 191 */     a(this, paramBoolean);
/*     */   }
/*     */   
/*     */   private void a(Group paramGroup, boolean paramBoolean) {
/* 195 */     SnapshotArray snapshotArray = paramGroup.getChildren(); byte b; int i;
/* 196 */     for (b = 0, i = snapshotArray.size; b < i; b++) {
/*     */       Actor actor;
/* 198 */       if (actor = (Actor)snapshotArray.get(b) instanceof Layout) {
/* 199 */         ((Layout)actor).setLayoutEnabled(paramBoolean);
/* 200 */       } else if (actor instanceof Group) {
/* 201 */         a((Group)actor, paramBoolean);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   public void validate() {
/* 206 */     if (!this.m)
/*     */       return; 
/* 208 */     Group group = getParent();
/* 209 */     if (this.l && group != null) {
/*     */       Stage stage;
/* 211 */       if ((stage = getStage()) != null && group == stage.getRoot()) {
/* 212 */         setSize(stage.getWidth(), stage.getHeight());
/*     */       } else {
/* 214 */         setSize(group.getWidth(), group.getHeight());
/*     */       } 
/*     */     } 
/* 217 */     if (!this.k)
/* 218 */       return;  this.k = false;
/* 219 */     layout();
/*     */ 
/*     */ 
/*     */     
/* 223 */     if (this.k) {
/* 224 */       if (group instanceof WidgetGroup)
/* 225 */         return;  for (byte b = 0; b < 5; ) {
/* 226 */         this.k = false;
/* 227 */         layout();
/* 228 */         if (this.k)
/*     */           b++; 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean needsLayout() {
/* 235 */     return this.k;
/*     */   }
/*     */   
/*     */   public void invalidate() {
/* 239 */     this.k = true;
/*     */   }
/*     */   
/*     */   public void invalidateHierarchy() {
/* 243 */     invalidate();
/*     */     Group group;
/* 245 */     if (group = getParent() instanceof Layout) ((Layout)group).invalidateHierarchy(); 
/*     */   }
/*     */   
/*     */   protected final void c() {
/* 249 */     invalidateHierarchy();
/*     */   }
/*     */   
/*     */   protected void sizeChanged() {
/* 253 */     invalidate();
/*     */   }
/*     */ 
/*     */   
/*     */   public void pack() {
/* 258 */     setSize(getPrefWidth(), getPrefHeight());
/* 259 */     validate();
/*     */ 
/*     */     
/* 262 */     setSize(getPrefWidth(), getPrefHeight());
/* 263 */     validate();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setWidth(float paramFloat) {
/* 268 */     super.setWidth(paramFloat);
/*     */   }
/*     */   
/*     */   public void setFillParent(boolean paramBoolean) {
/* 272 */     this.l = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void layout() {}
/*     */ 
/*     */   
/*     */   public Actor hit(float paramFloat1, float paramFloat2, boolean paramBoolean) {
/* 281 */     validate();
/* 282 */     return super.hit(paramFloat1, paramFloat2, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/* 288 */     validate();
/* 289 */     super.draw(paramBatch, paramFloat);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\ui\WidgetGroup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */