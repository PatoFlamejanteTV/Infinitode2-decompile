/*     */ package com.badlogic.gdx.scenes.scene2d;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
/*     */ import com.badlogic.gdx.math.Affine2;
/*     */ import com.badlogic.gdx.math.Matrix4;
/*     */ import com.badlogic.gdx.math.Rectangle;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.Cullable;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Null;
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
/*     */ public class Group
/*     */   extends Actor
/*     */   implements Cullable
/*     */ {
/*  37 */   private static final Vector2 tmp = new Vector2();
/*     */   
/*  39 */   final SnapshotArray<Actor> children = new SnapshotArray(true, 4, Actor.class);
/*  40 */   private final Affine2 worldTransform = new Affine2();
/*  41 */   private final Matrix4 computedTransform = new Matrix4();
/*  42 */   private final Matrix4 oldTransform = new Matrix4(); boolean transform = true;
/*     */   @Null
/*     */   private Rectangle cullingArea;
/*     */   
/*     */   public void act(float paramFloat) {
/*  47 */     super.act(paramFloat);
/*  48 */     Actor[] arrayOfActor = (Actor[])this.children.begin(); byte b; int i;
/*  49 */     for (b = 0, i = this.children.size; b < i; b++)
/*  50 */       arrayOfActor[b].act(paramFloat); 
/*  51 */     this.children.end();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/*  57 */     if (this.transform) applyTransform(paramBatch, computeTransform()); 
/*  58 */     drawChildren(paramBatch, paramFloat);
/*  59 */     if (this.transform) resetTransform(paramBatch);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void drawChildren(Batch paramBatch, float paramFloat) {
/*  67 */     paramFloat *= this.color.a;
/*     */     SnapshotArray<Actor> snapshotArray;
/*  69 */     Actor[] arrayOfActor = (Actor[])(snapshotArray = this.children).begin();
/*     */     Rectangle rectangle;
/*  71 */     if ((rectangle = this.cullingArea) != null) {
/*     */ 
/*     */       
/*  74 */       float f2, f3 = (f2 = rectangle.x) + rectangle.width;
/*     */       
/*  76 */       float f4, f1 = (f4 = rectangle.y) + rectangle.height;
/*  77 */       if (this.transform) {
/*  78 */         byte b; int i; for (b = 0, i = snapshotArray.size; b < i; b++) {
/*     */           Actor actor;
/*  80 */           if ((actor = arrayOfActor[b]).isVisible()) {
/*  81 */             float f5 = actor.x, f6 = actor.y;
/*  82 */             if (f5 <= f3 && f6 <= f1 && f5 + actor.width >= f2 && f6 + actor.height >= f4)
/*  83 */               actor.draw(paramBatch, paramFloat); 
/*     */           } 
/*     */         } 
/*     */       } else {
/*  87 */         float f5 = this.x, f6 = this.y;
/*  88 */         this.x = 0.0F;
/*  89 */         this.y = 0.0F; byte b; int i;
/*  90 */         for (b = 0, i = snapshotArray.size; b < i; b++) {
/*     */           Actor actor;
/*  92 */           if ((actor = arrayOfActor[b]).isVisible()) {
/*  93 */             float f7 = actor.x, f8 = actor.y;
/*  94 */             if (f7 <= f3 && f8 <= f1 && f7 + actor.width >= f2 && f8 + actor.height >= f4) {
/*  95 */               actor.x = f7 + f5;
/*  96 */               actor.y = f8 + f6;
/*  97 */               actor.draw(paramBatch, paramFloat);
/*  98 */               actor.x = f7;
/*  99 */               actor.y = f8;
/*     */             } 
/*     */           } 
/* 102 */         }  this.x = f5;
/* 103 */         this.y = f6;
/*     */       }
/*     */     
/*     */     }
/* 107 */     else if (this.transform) {
/* 108 */       byte b; int i; for (b = 0, i = snapshotArray.size; b < i; b++) {
/*     */         Actor actor;
/* 110 */         if ((actor = arrayOfActor[b]).isVisible()) {
/* 111 */           actor.draw(paramBatch, paramFloat);
/*     */         }
/*     */       } 
/*     */     } else {
/* 115 */       float f1 = this.x, f2 = this.y;
/* 116 */       this.x = 0.0F;
/* 117 */       this.y = 0.0F; int i; byte b;
/* 118 */       for (b = 0, i = snapshotArray.size; b < i; b++) {
/*     */         Actor actor;
/* 120 */         if ((actor = arrayOfActor[b]).isVisible()) {
/* 121 */           float f3 = actor.x, f4 = actor.y;
/* 122 */           actor.x = f3 + f1;
/* 123 */           actor.y = f4 + f2;
/* 124 */           actor.draw(paramBatch, paramFloat);
/* 125 */           actor.x = f3;
/* 126 */           actor.y = f4;
/*     */         } 
/* 128 */       }  this.x = f1;
/* 129 */       this.y = f2;
/*     */     } 
/*     */     
/* 132 */     snapshotArray.end();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawDebug(ShapeRenderer paramShapeRenderer) {
/* 138 */     drawDebugBounds(paramShapeRenderer);
/* 139 */     if (this.transform) applyTransform(paramShapeRenderer, computeTransform()); 
/* 140 */     drawDebugChildren(paramShapeRenderer);
/* 141 */     if (this.transform) resetTransform(paramShapeRenderer);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void drawDebugChildren(ShapeRenderer paramShapeRenderer) {
/*     */     SnapshotArray<Actor> snapshotArray;
/* 150 */     Actor[] arrayOfActor = (Actor[])(snapshotArray = this.children).begin();
/*     */     
/* 152 */     if (this.transform) {
/* 153 */       byte b; int i; for (b = 0, i = snapshotArray.size; b < i; b++) {
/*     */         Actor actor;
/* 155 */         if ((actor = arrayOfActor[b]).isVisible() && (
/* 156 */           actor.getDebug() || actor instanceof Group))
/* 157 */           actor.drawDebug(paramShapeRenderer); 
/*     */       } 
/* 159 */       paramShapeRenderer.flush();
/*     */     } else {
/*     */       
/* 162 */       float f1 = this.x, f2 = this.y;
/* 163 */       this.x = 0.0F;
/* 164 */       this.y = 0.0F; byte b; int i;
/* 165 */       for (b = 0, i = snapshotArray.size; b < i; b++) {
/*     */         Actor actor;
/* 167 */         if ((actor = arrayOfActor[b]).isVisible() && (
/* 168 */           actor.getDebug() || actor instanceof Group)) {
/* 169 */           float f3 = actor.x, f4 = actor.y;
/* 170 */           actor.x = f3 + f1;
/* 171 */           actor.y = f4 + f2;
/* 172 */           actor.drawDebug(paramShapeRenderer);
/* 173 */           actor.x = f3;
/* 174 */           actor.y = f4;
/*     */         } 
/* 176 */       }  this.x = f1;
/* 177 */       this.y = f2;
/*     */     } 
/* 179 */     snapshotArray.end();
/*     */   }
/*     */ 
/*     */   
/*     */   protected Matrix4 computeTransform() {
/* 184 */     Affine2 affine2 = this.worldTransform;
/* 185 */     float f1 = this.originX, f2 = this.originY;
/* 186 */     affine2.setToTrnRotScl(this.x + f1, this.y + f2, this.rotation, this.scaleX, this.scaleY);
/* 187 */     if (f1 != 0.0F || f2 != 0.0F) affine2.translate(-f1, -f2);
/*     */ 
/*     */     
/* 190 */     Group group = this.parent;
/* 191 */     while (group != null && 
/* 192 */       !group.transform) {
/* 193 */       group = group.parent;
/*     */     }
/* 195 */     if (group != null) affine2.preMul(group.worldTransform);
/*     */     
/* 197 */     this.computedTransform.set(affine2);
/* 198 */     return this.computedTransform;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void applyTransform(Batch paramBatch, Matrix4 paramMatrix4) {
/* 204 */     this.oldTransform.set(paramBatch.getTransformMatrix());
/* 205 */     paramBatch.setTransformMatrix(paramMatrix4);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void resetTransform(Batch paramBatch) {
/* 211 */     paramBatch.setTransformMatrix(this.oldTransform);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void applyTransform(ShapeRenderer paramShapeRenderer, Matrix4 paramMatrix4) {
/* 218 */     this.oldTransform.set(paramShapeRenderer.getTransformMatrix());
/* 219 */     paramShapeRenderer.setTransformMatrix(paramMatrix4);
/* 220 */     paramShapeRenderer.flush();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void resetTransform(ShapeRenderer paramShapeRenderer) {
/* 226 */     paramShapeRenderer.setTransformMatrix(this.oldTransform);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCullingArea(@Null Rectangle paramRectangle) {
/* 233 */     this.cullingArea = paramRectangle;
/*     */   }
/*     */ 
/*     */   
/*     */   @Null
/*     */   public Rectangle getCullingArea() {
/* 239 */     return this.cullingArea;
/*     */   }
/*     */   @Null
/*     */   public Actor hit(float paramFloat1, float paramFloat2, boolean paramBoolean) {
/* 243 */     if (paramBoolean && getTouchable() == Touchable.disabled) return null; 
/* 244 */     if (!isVisible()) return null; 
/* 245 */     Vector2 vector2 = tmp;
/* 246 */     Actor[] arrayOfActor = (Actor[])this.children.items;
/* 247 */     for (int i = this.children.size - 1; i >= 0; i--) {
/*     */       Actor actor;
/* 249 */       (actor = arrayOfActor[i]).parentToLocalCoordinates(vector2.set(paramFloat1, paramFloat2));
/*     */       
/* 251 */       if ((actor = actor.hit(vector2.x, vector2.y, paramBoolean)) != null) return actor; 
/*     */     } 
/* 253 */     return super.hit(paramFloat1, paramFloat2, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void childrenChanged() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void addActor(Actor paramActor) {
/* 263 */     if (paramActor.parent != null) {
/* 264 */       if (paramActor.parent == this)
/* 265 */         return;  paramActor.parent.removeActor(paramActor, false);
/*     */     } 
/* 267 */     this.children.add(paramActor);
/* 268 */     paramActor.setParent(this);
/* 269 */     paramActor.setStage(getStage());
/* 270 */     childrenChanged();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addActorAt(int paramInt, Actor paramActor) {
/* 277 */     if (paramActor.parent != null) {
/* 278 */       if (paramActor.parent == this)
/* 279 */         return;  paramActor.parent.removeActor(paramActor, false);
/*     */     } 
/* 281 */     if (paramInt >= this.children.size) {
/* 282 */       this.children.add(paramActor);
/*     */     } else {
/* 284 */       this.children.insert(paramInt, paramActor);
/* 285 */     }  paramActor.setParent(this);
/* 286 */     paramActor.setStage(getStage());
/* 287 */     childrenChanged();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addActorBefore(Actor paramActor1, Actor paramActor2) {
/* 293 */     if (paramActor2.parent != null) {
/* 294 */       if (paramActor2.parent == this)
/* 295 */         return;  paramActor2.parent.removeActor(paramActor2, false);
/*     */     } 
/* 297 */     int i = this.children.indexOf(paramActor1, true);
/* 298 */     this.children.insert(i, paramActor2);
/* 299 */     paramActor2.setParent(this);
/* 300 */     paramActor2.setStage(getStage());
/* 301 */     childrenChanged();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addActorAfter(Actor paramActor1, Actor paramActor2) {
/* 308 */     if (paramActor2.parent != null) {
/* 309 */       if (paramActor2.parent == this)
/* 310 */         return;  paramActor2.parent.removeActor(paramActor2, false);
/*     */     } 
/*     */     int i;
/* 313 */     if ((i = this.children.indexOf(paramActor1, true)) == this.children.size || i == -1) {
/* 314 */       this.children.add(paramActor2);
/*     */     } else {
/* 316 */       this.children.insert(i + 1, paramActor2);
/* 317 */     }  paramActor2.setParent(this);
/* 318 */     paramActor2.setStage(getStage());
/* 319 */     childrenChanged();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean removeActor(Actor paramActor) {
/* 324 */     return removeActor(paramActor, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean removeActor(Actor paramActor, boolean paramBoolean) {
/*     */     int i;
/* 330 */     if ((i = this.children.indexOf(paramActor, true)) == -1) return false; 
/* 331 */     removeActorAt(i, paramBoolean);
/* 332 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Actor removeActorAt(int paramInt, boolean paramBoolean) {
/* 341 */     Actor actor = (Actor)this.children.removeIndex(paramInt);
/*     */     Stage stage;
/* 343 */     if ((stage = getStage()) != null) {
/* 344 */       if (paramBoolean) stage.unfocus(actor); 
/* 345 */       stage.actorRemoved(actor);
/*     */     } 
/* 347 */     actor.setParent(null);
/* 348 */     actor.setStage(null);
/* 349 */     childrenChanged();
/* 350 */     return actor;
/*     */   }
/*     */ 
/*     */   
/*     */   public void clearChildren() {
/* 355 */     clearChildren(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clearChildren(boolean paramBoolean) {
/* 360 */     Actor[] arrayOfActor = (Actor[])this.children.begin(); byte b; int i;
/* 361 */     for (b = 0, i = this.children.size; b < i; b++) {
/* 362 */       Actor actor = arrayOfActor[b]; Stage stage;
/* 363 */       if (paramBoolean && (
/*     */         
/* 365 */         stage = getStage()) != null) stage.unfocus(actor);
/*     */       
/* 367 */       actor.setStage(null);
/* 368 */       actor.setParent(null);
/*     */     } 
/* 370 */     this.children.end();
/* 371 */     this.children.clear();
/* 372 */     childrenChanged();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 377 */     super.clear();
/* 378 */     clearChildren(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear(boolean paramBoolean) {
/* 383 */     super.clear();
/* 384 */     clearChildren(paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   @Null
/*     */   public <T extends Actor> T findActor(String paramString) {
/* 390 */     SnapshotArray<Actor> snapshotArray = this.children; byte b; int i;
/* 391 */     for (b = 0, i = ((Array)snapshotArray).size; b < i; b++) {
/* 392 */       if (paramString.equals(((Actor)snapshotArray.get(b)).getName())) return (T)snapshotArray.get(b); 
/* 393 */     }  for (b = 0, i = ((Array)snapshotArray).size; b < i; b++) {
/*     */       Actor actor;
/* 395 */       if (actor = (Actor)snapshotArray.get(b) instanceof Group && (
/*     */         
/* 397 */         actor = ((Group)actor).<Actor>findActor(paramString)) != null) return (T)actor;
/*     */     
/*     */     } 
/* 400 */     return null;
/*     */   }
/*     */   
/*     */   protected void setStage(Stage paramStage) {
/* 404 */     super.setStage(paramStage);
/* 405 */     Actor[] arrayOfActor = (Actor[])this.children.items; byte b; int i;
/* 406 */     for (b = 0, i = this.children.size; b < i; b++) {
/* 407 */       arrayOfActor[b].setStage(paramStage);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean swapActor(int paramInt1, int paramInt2) {
/* 412 */     int i = this.children.size;
/* 413 */     if (paramInt1 < 0 || paramInt1 >= i) return false; 
/* 414 */     if (paramInt2 < 0 || paramInt2 >= i) return false; 
/* 415 */     this.children.swap(paramInt1, paramInt2);
/* 416 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean swapActor(Actor paramActor1, Actor paramActor2) {
/* 421 */     int i = this.children.indexOf(paramActor1, true);
/* 422 */     int j = this.children.indexOf(paramActor2, true);
/* 423 */     if (i == -1 || j == -1) return false; 
/* 424 */     this.children.swap(i, j);
/* 425 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Actor getChild(int paramInt) {
/* 430 */     return (Actor)this.children.get(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public SnapshotArray<Actor> getChildren() {
/* 435 */     return this.children;
/*     */   }
/*     */   
/*     */   public boolean hasChildren() {
/* 439 */     return (this.children.size > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransform(boolean paramBoolean) {
/* 448 */     this.transform = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean isTransform() {
/* 452 */     return this.transform;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector2 localToDescendantCoordinates(Actor paramActor, Vector2 paramVector2) {
/*     */     Group group;
/* 459 */     if ((group = paramActor.parent) == null) throw new IllegalArgumentException("Actor is not a descendant: " + paramActor);
/*     */     
/* 461 */     if (group != this) localToDescendantCoordinates(group, paramVector2);
/*     */     
/* 463 */     paramActor.parentToLocalCoordinates(paramVector2);
/* 464 */     return paramVector2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDebug(boolean paramBoolean1, boolean paramBoolean2) {
/* 469 */     setDebug(paramBoolean1);
/* 470 */     if (paramBoolean2) {
/* 471 */       for (Array.ArrayIterator<Actor> arrayIterator = this.children.iterator(); arrayIterator.hasNext(); ) {
/* 472 */         Actor actor; if (actor = arrayIterator.next() instanceof Group) {
/* 473 */           ((Group)actor).setDebug(paramBoolean1, paramBoolean2); continue;
/*     */         } 
/* 475 */         actor.setDebug(paramBoolean1);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Group debugAll() {
/* 483 */     setDebug(true, true);
/* 484 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 489 */     StringBuilder stringBuilder = new StringBuilder(128);
/* 490 */     toString(stringBuilder, 1);
/* 491 */     stringBuilder.setLength(stringBuilder.length() - 1);
/* 492 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   void toString(StringBuilder paramStringBuilder, int paramInt) {
/* 496 */     paramStringBuilder.append(super.toString());
/* 497 */     paramStringBuilder.append('\n');
/*     */     
/* 499 */     Actor[] arrayOfActor = (Actor[])this.children.begin(); byte b; int i;
/* 500 */     for (b = 0, i = this.children.size; b < i; b++) {
/* 501 */       for (byte b1 = 0; b1 < paramInt; b1++)
/* 502 */         paramStringBuilder.append("|  "); 
/*     */       Actor actor;
/* 504 */       if (actor = arrayOfActor[b] instanceof Group) {
/* 505 */         ((Group)actor).toString(paramStringBuilder, paramInt + 1);
/*     */       } else {
/* 507 */         paramStringBuilder.append(actor);
/* 508 */         paramStringBuilder.append('\n');
/*     */       } 
/*     */     } 
/* 511 */     this.children.end();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2d\Group.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */