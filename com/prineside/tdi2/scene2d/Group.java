/*     */ package com.prineside.tdi2.scene2d;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
/*     */ import com.badlogic.gdx.math.Affine2;
/*     */ import com.badlogic.gdx.math.Matrix4;
/*     */ import com.badlogic.gdx.math.Rectangle;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.SnapshotArray;
/*     */ import com.prineside.tdi2.scene2d.utils.Cullable;
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
/*  37 */   private static final Vector2 k = new Vector2();
/*     */   
/*  39 */   protected final SnapshotArray<Actor> j = new SnapshotArray(true, 4, Actor.class);
/*  40 */   private Affine2 l = new Affine2();
/*  41 */   private Matrix4 m = new Matrix4();
/*  42 */   private Matrix4 n = new Matrix4(); private boolean o = true;
/*     */   @Null
/*     */   private Rectangle p;
/*     */   
/*     */   public void act(float paramFloat) {
/*  47 */     super.act(paramFloat);
/*  48 */     Actor[] arrayOfActor = (Actor[])this.j.begin(); byte b; int i;
/*  49 */     for (b = 0, i = this.j.size; b < i; b++)
/*  50 */       arrayOfActor[b].act(paramFloat); 
/*  51 */     this.j.end();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/*  57 */     if (this.o) a(paramBatch, b()); 
/*  58 */     a(paramBatch, paramFloat);
/*  59 */     if (this.o) a(paramBatch);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void a(Batch paramBatch, float paramFloat) {
/*  67 */     paramFloat *= this.i.a;
/*     */     SnapshotArray<Actor> snapshotArray;
/*  69 */     Actor[] arrayOfActor = (Actor[])(snapshotArray = this.j).begin();
/*     */     Rectangle rectangle;
/*  71 */     if ((rectangle = this.p) != null) {
/*     */ 
/*     */       
/*  74 */       float f2, f3 = (f2 = rectangle.x) + rectangle.width;
/*     */       
/*  76 */       float f4, f1 = (f4 = rectangle.y) + rectangle.height;
/*  77 */       if (this.o) {
/*  78 */         byte b; int i; for (b = 0, i = snapshotArray.size; b < i; b++) {
/*     */           Actor actor;
/*  80 */           if ((actor = arrayOfActor[b]).isVisible()) {
/*  81 */             float f5 = actor.getX(), f6 = actor.getY();
/*  82 */             if (f5 <= f3 && f6 <= f1 && f5 + actor.getWidth() >= f2 && f6 + actor.getHeight() >= f4)
/*  83 */               actor.draw(paramBatch, paramFloat); 
/*     */           } 
/*     */         } 
/*     */       } else {
/*  87 */         float f5 = getX(), f6 = getY();
/*  88 */         setX(0.0F);
/*  89 */         setY(0.0F); byte b; int i;
/*  90 */         for (b = 0, i = snapshotArray.size; b < i; b++) {
/*     */           Actor actor;
/*  92 */           if ((actor = arrayOfActor[b]).isVisible()) {
/*  93 */             float f7 = actor.getX(), f8 = actor.getY();
/*  94 */             if (f7 <= f3 && f8 <= f1 && f7 + actor.getWidth() >= f2 && f8 + actor.getHeight() >= f4) {
/*  95 */               actor.setX(f7 + f5);
/*  96 */               actor.setY(f8 + f6);
/*  97 */               actor.draw(paramBatch, paramFloat);
/*  98 */               actor.setX(f7);
/*  99 */               actor.setY(f8);
/*     */             } 
/*     */           } 
/* 102 */         }  setX(f5);
/* 103 */         setY(f6);
/*     */       }
/*     */     
/*     */     }
/* 107 */     else if (this.o) {
/* 108 */       byte b; int i; for (b = 0, i = snapshotArray.size; b < i; b++) {
/*     */         Actor actor;
/* 110 */         if ((actor = arrayOfActor[b]).isVisible()) {
/* 111 */           actor.draw(paramBatch, paramFloat);
/*     */         }
/*     */       } 
/*     */     } else {
/* 115 */       float f1 = getX(), f2 = getY();
/* 116 */       setX(0.0F);
/* 117 */       setY(0.0F); int i; byte b;
/* 118 */       for (b = 0, i = snapshotArray.size; b < i; b++) {
/*     */         Actor actor;
/* 120 */         if ((actor = arrayOfActor[b]).isVisible()) {
/* 121 */           float f3 = actor.getX(), f4 = actor.getY();
/* 122 */           actor.setX(f3 + f1);
/* 123 */           actor.setY(f4 + f2);
/* 124 */           actor.draw(paramBatch, paramFloat);
/* 125 */           actor.setX(f3);
/* 126 */           actor.setY(f4);
/*     */         } 
/* 128 */       }  setX(f1);
/* 129 */       setY(f2);
/*     */     } 
/*     */     
/* 132 */     snapshotArray.end();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawDebug(ShapeRenderer paramShapeRenderer) {
/* 138 */     a(paramShapeRenderer);
/* 139 */     if (this.o) a(paramShapeRenderer, b()); 
/* 140 */     b(paramShapeRenderer);
/* 141 */     if (this.o) c(paramShapeRenderer);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void b(ShapeRenderer paramShapeRenderer) {
/*     */     SnapshotArray<Actor> snapshotArray;
/* 150 */     Actor[] arrayOfActor = (Actor[])(snapshotArray = this.j).begin();
/*     */     
/* 152 */     if (this.o) {
/* 153 */       byte b; int i; for (b = 0, i = snapshotArray.size; b < i; b++) {
/*     */         Actor actor;
/* 155 */         if ((actor = arrayOfActor[b]).isVisible() && (
/* 156 */           actor.getDebug() || actor instanceof Group))
/* 157 */           actor.drawDebug(paramShapeRenderer); 
/*     */       } 
/* 159 */       paramShapeRenderer.flush();
/*     */     } else {
/*     */       
/* 162 */       float f1 = getX(), f2 = getY();
/* 163 */       setX(0.0F);
/* 164 */       setY(0.0F); byte b; int i;
/* 165 */       for (b = 0, i = snapshotArray.size; b < i; b++) {
/*     */         Actor actor;
/* 167 */         if ((actor = arrayOfActor[b]).isVisible() && (
/* 168 */           actor.getDebug() || actor instanceof Group)) {
/* 169 */           float f3 = actor.getX(), f4 = actor.getY();
/* 170 */           actor.setX(f3 + f1);
/* 171 */           actor.setY(f4 + f2);
/* 172 */           actor.drawDebug(paramShapeRenderer);
/* 173 */           actor.setX(f3);
/* 174 */           actor.setY(f4);
/*     */         } 
/* 176 */       }  setX(f1);
/* 177 */       setY(f2);
/*     */     } 
/* 179 */     snapshotArray.end();
/*     */   }
/*     */ 
/*     */   
/*     */   protected final Matrix4 b() {
/* 184 */     Affine2 affine2 = this.l;
/* 185 */     float f1 = this.d, f2 = this.e;
/* 186 */     affine2.setToTrnRotScl(getX() + f1, getY() + f2, this.h, this.f, this.g);
/* 187 */     if (f1 != 0.0F || f2 != 0.0F) affine2.translate(-f1, -f2);
/*     */ 
/*     */     
/* 190 */     Group group = this.b;
/* 191 */     while (group != null && 
/* 192 */       !group.o) {
/* 193 */       group = group.b;
/*     */     }
/* 195 */     if (group != null) affine2.preMul(group.l);
/*     */     
/* 197 */     this.m.set(affine2);
/* 198 */     return this.m;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void a(Batch paramBatch, Matrix4 paramMatrix4) {
/* 204 */     this.n.set(paramBatch.getTransformMatrix());
/* 205 */     paramBatch.setTransformMatrix(paramMatrix4);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void a(Batch paramBatch) {
/* 211 */     paramBatch.setTransformMatrix(this.n);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void a(ShapeRenderer paramShapeRenderer, Matrix4 paramMatrix4) {
/* 218 */     this.n.set(paramShapeRenderer.getTransformMatrix());
/* 219 */     paramShapeRenderer.setTransformMatrix(paramMatrix4);
/* 220 */     paramShapeRenderer.flush();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void c(ShapeRenderer paramShapeRenderer) {
/* 226 */     paramShapeRenderer.setTransformMatrix(this.n);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCullingArea(@Null Rectangle paramRectangle) {
/* 233 */     this.p = paramRectangle;
/*     */   }
/*     */ 
/*     */   
/*     */   @Null
/*     */   public Rectangle getCullingArea() {
/* 239 */     return this.p;
/*     */   }
/*     */   @Null
/*     */   public Actor hit(float paramFloat1, float paramFloat2, boolean paramBoolean) {
/* 243 */     if (paramBoolean && getTouchable() == Touchable.disabled) return null; 
/* 244 */     if (!isVisible()) return null; 
/* 245 */     Vector2 vector2 = k;
/* 246 */     Actor[] arrayOfActor = (Actor[])this.j.items;
/* 247 */     for (int i = this.j.size - 1; i >= 0; i--) {
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
/*     */   protected void c() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void addActor(Actor paramActor) {
/* 263 */     if (paramActor.b != null) {
/* 264 */       if (paramActor.b == this)
/* 265 */         return;  paramActor.b.removeActor(paramActor, false);
/*     */     } 
/* 267 */     this.j.add(paramActor);
/* 268 */     paramActor.a(this);
/* 269 */     paramActor.a(getStage());
/* 270 */     c();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addActorAt(int paramInt, Actor paramActor) {
/* 277 */     if (paramActor.b != null) {
/* 278 */       if (paramActor.b == this)
/* 279 */         return;  paramActor.b.removeActor(paramActor, false);
/*     */     } 
/* 281 */     if (paramInt >= this.j.size) {
/* 282 */       this.j.add(paramActor);
/*     */     } else {
/* 284 */       this.j.insert(paramInt, paramActor);
/* 285 */     }  paramActor.a(this);
/* 286 */     paramActor.a(getStage());
/* 287 */     c();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addActorBefore(Actor paramActor1, Actor paramActor2) {
/* 293 */     if (paramActor2.b != null) {
/* 294 */       if (paramActor2.b == this)
/* 295 */         return;  paramActor2.b.removeActor(paramActor2, false);
/*     */     } 
/* 297 */     int i = this.j.indexOf(paramActor1, true);
/* 298 */     this.j.insert(i, paramActor2);
/* 299 */     paramActor2.a(this);
/* 300 */     paramActor2.a(getStage());
/* 301 */     c();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addActorAfter(Actor paramActor1, Actor paramActor2) {
/* 308 */     if (paramActor2.b != null) {
/* 309 */       if (paramActor2.b == this)
/* 310 */         return;  paramActor2.b.removeActor(paramActor2, false);
/*     */     } 
/*     */     int i;
/* 313 */     if ((i = this.j.indexOf(paramActor1, true)) == this.j.size || i == -1) {
/* 314 */       this.j.add(paramActor2);
/*     */     } else {
/* 316 */       this.j.insert(i + 1, paramActor2);
/* 317 */     }  paramActor2.a(this);
/* 318 */     paramActor2.a(getStage());
/* 319 */     c();
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
/* 330 */     if ((i = this.j.indexOf(paramActor, true)) == -1) return false; 
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
/* 341 */     Actor actor = (Actor)this.j.removeIndex(paramInt);
/*     */     Stage stage;
/* 343 */     if ((stage = getStage()) != null) {
/* 344 */       if (paramBoolean) stage.unfocus(actor); 
/* 345 */       stage.a(actor);
/*     */     } 
/* 347 */     actor.a((Group)null);
/* 348 */     actor.a((Stage)null);
/* 349 */     c();
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
/* 360 */     Actor[] arrayOfActor = (Actor[])this.j.begin(); byte b; int i;
/* 361 */     for (b = 0, i = this.j.size; b < i; b++) {
/* 362 */       Actor actor = arrayOfActor[b]; Stage stage;
/* 363 */       if (paramBoolean && (
/*     */         
/* 365 */         stage = getStage()) != null) stage.unfocus(actor);
/*     */       
/* 367 */       actor.a((Stage)null);
/* 368 */       actor.a((Group)null);
/*     */     } 
/* 370 */     this.j.end();
/* 371 */     this.j.clear();
/* 372 */     c();
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
/* 390 */     SnapshotArray<Actor> snapshotArray = this.j; byte b; int i;
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
/*     */   protected void a(Stage paramStage) {
/* 404 */     super.a(paramStage);
/* 405 */     Actor[] arrayOfActor = (Actor[])this.j.items; byte b; int i;
/* 406 */     for (b = 0, i = this.j.size; b < i; b++) {
/* 407 */       arrayOfActor[b].a(paramStage);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean swapActor(int paramInt1, int paramInt2) {
/* 412 */     int i = this.j.size;
/* 413 */     if (paramInt1 < 0 || paramInt1 >= i) return false; 
/* 414 */     if (paramInt2 < 0 || paramInt2 >= i) return false; 
/* 415 */     this.j.swap(paramInt1, paramInt2);
/* 416 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean swapActor(Actor paramActor1, Actor paramActor2) {
/* 421 */     int i = this.j.indexOf(paramActor1, true);
/* 422 */     int j = this.j.indexOf(paramActor2, true);
/* 423 */     if (i == -1 || j == -1) return false; 
/* 424 */     this.j.swap(i, j);
/* 425 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Actor getChild(int paramInt) {
/* 430 */     return (Actor)this.j.get(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public SnapshotArray<Actor> getChildren() {
/* 435 */     return this.j;
/*     */   }
/*     */   
/*     */   public boolean hasChildren() {
/* 439 */     return (this.j.size > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransform(boolean paramBoolean) {
/* 448 */     this.o = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean isTransform() {
/* 452 */     return this.o;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector2 localToDescendantCoordinates(Actor paramActor, Vector2 paramVector2) {
/*     */     Group group;
/* 459 */     if ((group = paramActor.b) == null) throw new IllegalArgumentException("Actor is not a descendant: " + paramActor);
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
/* 471 */       for (Array.ArrayIterator<Actor> arrayIterator = this.j.iterator(); arrayIterator.hasNext(); ) {
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
/* 490 */     a(stringBuilder, 1);
/* 491 */     stringBuilder.setLength(stringBuilder.length() - 1);
/* 492 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private void a(StringBuilder paramStringBuilder, int paramInt) {
/* 496 */     paramStringBuilder.append(super.toString());
/* 497 */     paramStringBuilder.append('\n');
/*     */     
/* 499 */     Actor[] arrayOfActor = (Actor[])this.j.begin(); byte b; int i;
/* 500 */     for (b = 0, i = this.j.size; b < i; b++) {
/* 501 */       for (byte b1 = 0; b1 < paramInt; b1++)
/* 502 */         paramStringBuilder.append("|  "); 
/*     */       Actor actor;
/* 504 */       if (actor = arrayOfActor[b] instanceof Group) {
/* 505 */         ((Group)actor).a(paramStringBuilder, paramInt + 1);
/*     */       } else {
/* 507 */         paramStringBuilder.append(actor);
/* 508 */         paramStringBuilder.append('\n');
/*     */       } 
/*     */     } 
/* 511 */     this.j.end();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2d\Group.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */