/*     */ package com.prineside.tdi2.scene2d.utils;
/*     */ 
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Stage;
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
/*     */ public class DragAndDrop
/*     */ {
/*  33 */   static final Vector2 a = new Vector2();
/*     */   
/*     */   Source b;
/*     */   Payload c;
/*     */   Actor d;
/*     */   boolean e;
/*     */   Target f;
/*     */   boolean g;
/*  41 */   final Array<Target> h = new Array(8);
/*  42 */   private ObjectMap<Source, DragListener> r = new ObjectMap(8);
/*  43 */   private float s = 8.0F;
/*     */   private int t;
/*  45 */   float i = 0.0F; float j = 0.0F; float k;
/*     */   float l;
/*     */   long m;
/*  48 */   int n = 250;
/*  49 */   int o = -1;
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
/*     */   boolean p = true;
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
/*     */   boolean q = true;
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
/*     */   public void addSource(Source paramSource) {
/*     */     DragListener dragListener;
/* 170 */     (dragListener = new DragListener(this, paramSource) { public void dragStart(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int) { if (this.b.o != -1) { param1InputEvent.stop(); return; }  this.b.o = param1Int; this.b.m = System.currentTimeMillis() + this.b.n; this.b.b = this.a; this.b.c = this.a.dragStart(param1InputEvent, getTouchDownX(), getTouchDownY(), param1Int); param1InputEvent.stop(); Stage stage; if (this.b.p && this.b.c != null && (stage = this.a.getActor().getStage()) != null) stage.cancelTouchFocusExcept((EventListener)this, this.a.getActor());  } public void drag(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int) { if (this.b.c == null) return;  if (param1Int != this.b.o) return;  this.a.drag(param1InputEvent, param1Float1, param1Float2, param1Int); Stage stage = param1InputEvent.getStage(); Actor actor1 = this.b.d; float f1 = 0.0F, f2 = 0.0F; if (actor1 != null) { f1 = actor1.getX(); f2 = actor1.getY(); actor1.setPosition(2.1474836E9F, 2.1474836E9F); }  float f3 = param1InputEvent.getStageX() + this.b.k, f4 = param1InputEvent.getStageY() + this.b.l; Actor actor3; if ((actor3 = param1InputEvent.getStage().hit(f3, f4, true)) == null) actor3 = param1InputEvent.getStage().hit(f3, f4, false);  if (actor1 != null) actor1.setPosition(f1, f2);  DragAndDrop.Target target = null; this.b.g = false; if (actor3 != null) { byte b; int i; for (b = 0, i = this.b.h.size; b < i; b++) { DragAndDrop.Target target1; if ((target1 = (DragAndDrop.Target)this.b.h.get(b)).a.isAscendantOf(actor3)) { target = target1; target1.a.stageToLocalCoordinates(DragAndDrop.a.set(f3, f4)); break; }  }  }  if (target != this.b.f) { if (this.b.f != null) this.b.f.reset(this.a, this.b.c);  this.b.f = target; }  if (target != null) this.b.g = target.drag(this.a, this.b.c, DragAndDrop.a.x, DragAndDrop.a.y, param1Int);  Actor actor2 = null; if (this.b.f != null) actor2 = this.b.g ? this.b.c.b : this.b.c.c;  if (actor2 == null) actor2 = this.b.c.a;  if (actor2 != actor1) { if (actor1 != null && this.b.e) actor1.remove();  this.b.d = actor2; this.b.e = (actor2.getStage() == null); if (this.b.e) stage.addActor(actor2);  }  if (actor2 == null) return;  float f5 = param1InputEvent.getStageX() - actor2.getWidth() + this.b.i; float f6 = param1InputEvent.getStageY() + this.b.j; if (this.b.q) { if (f5 < 0.0F) f5 = 0.0F;  if (f6 < 0.0F) f6 = 0.0F;  if (f5 + actor2.getWidth() > stage.getWidth()) f5 = stage.getWidth() - actor2.getWidth();  if (f6 + actor2.getHeight() > stage.getHeight()) f6 = stage.getHeight() - actor2.getHeight();  }  actor2.setPosition(f5, f6); } public void dragStop(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int) { if (param1Int != this.b.o) return;  this.b.o = -1; if (this.b.c == null) return;  if (System.currentTimeMillis() < this.b.m) { this.b.g = false; } else if (!this.b.g && this.b.f != null) { float f1 = param1InputEvent.getStageX() + this.b.k, f2 = param1InputEvent.getStageY() + this.b.l; this.b.f.a.stageToLocalCoordinates(DragAndDrop.a.set(f1, f2)); this.b.g = this.b.f.drag(this.a, this.b.c, DragAndDrop.a.x, DragAndDrop.a.y, param1Int); }  if (this.b.d != null && this.b.e) this.b.d.remove();  if (this.b.g) { float f1 = param1InputEvent.getStageX() + this.b.k, f2 = param1InputEvent.getStageY() + this.b.l; this.b.f.a.stageToLocalCoordinates(DragAndDrop.a.set(f1, f2)); this.b.f.drop(this.a, this.b.c, DragAndDrop.a.x, DragAndDrop.a.y, param1Int); }  this.a.dragStop(param1InputEvent, param1Float1, param1Float2, param1Int, this.b.c, this.b.g ? this.b.f : null); if (this.b.f != null) this.b.f.reset(this.a, this.b.c);  this.b.b = null; this.b.c = null; this.b.f = null; this.b.g = false; this.b.d = null; } }).setTapSquareSize(this.s);
/* 171 */     dragListener.setButton(this.t);
/* 172 */     paramSource.a.addCaptureListener((EventListener)dragListener);
/* 173 */     this.r.put(paramSource, dragListener);
/*     */   }
/*     */   
/*     */   public void removeSource(Source paramSource) {
/* 177 */     DragListener dragListener = (DragListener)this.r.remove(paramSource);
/* 178 */     paramSource.a.removeCaptureListener((EventListener)dragListener);
/*     */   }
/*     */   
/*     */   public void addTarget(Target paramTarget) {
/* 182 */     this.h.add(paramTarget);
/*     */   }
/*     */   
/*     */   public void removeTarget(Target paramTarget) {
/* 186 */     this.h.removeValue(paramTarget, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 191 */     this.h.clear();
/* 192 */     for (ObjectMap.Entries<ObjectMap.Entry> entries = this.r.entries().iterator(); entries.hasNext();)
/* 193 */       ((Source)(entry = entries.next()).key).a.removeCaptureListener((EventListener)entry.value); 
/* 194 */     this.r.clear(8);
/*     */   }
/*     */ 
/*     */   
/*     */   public void cancelTouchFocusExcept(Source paramSource) {
/*     */     DragListener dragListener;
/* 200 */     if ((dragListener = (DragListener)this.r.get(paramSource)) == null)
/*     */       return;  Stage stage;
/* 202 */     if ((stage = paramSource.getActor().getStage()) != null) stage.cancelTouchFocusExcept((EventListener)dragListener, paramSource.getActor());
/*     */   
/*     */   }
/*     */   
/*     */   public void setTapSquareSize(float paramFloat) {
/* 207 */     this.s = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setButton(int paramInt) {
/* 212 */     this.t = paramInt;
/*     */   }
/*     */   
/*     */   public void setDragActorPosition(float paramFloat1, float paramFloat2) {
/* 216 */     this.i = paramFloat1;
/* 217 */     this.j = paramFloat2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTouchOffset(float paramFloat1, float paramFloat2) {
/* 223 */     this.k = paramFloat1;
/* 224 */     this.l = paramFloat2;
/*     */   }
/*     */   
/*     */   public boolean isDragging() {
/* 228 */     return (this.c != null);
/*     */   }
/*     */   
/*     */   @Null
/*     */   public Actor getDragActor() {
/* 233 */     return this.d;
/*     */   }
/*     */   
/*     */   @Null
/*     */   public Payload getDragPayload() {
/* 238 */     return this.c;
/*     */   }
/*     */   
/*     */   @Null
/*     */   public Source getDragSource() {
/* 243 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDragTime(int paramInt) {
/* 249 */     this.n = paramInt;
/*     */   }
/*     */   
/*     */   public int getDragTime() {
/* 253 */     return this.n;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDragValid() {
/* 258 */     return (this.c != null && System.currentTimeMillis() >= this.m);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCancelTouchFocus(boolean paramBoolean) {
/* 265 */     this.p = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setKeepWithinStage(boolean paramBoolean) {
/* 269 */     this.q = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public static abstract class Source
/*     */   {
/*     */     final Actor a;
/*     */     
/*     */     public Source(Actor param1Actor) {
/* 278 */       if (param1Actor == null) throw new IllegalArgumentException("actor cannot be null."); 
/* 279 */       this.a = param1Actor;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     @Null
/*     */     public abstract DragAndDrop.Payload dragStart(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int);
/*     */ 
/*     */ 
/*     */     
/*     */     public void drag(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void dragStop(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, @Null DragAndDrop.Payload param1Payload, @Null DragAndDrop.Target param1Target) {}
/*     */ 
/*     */     
/*     */     public Actor getActor() {
/* 297 */       return this.a;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static abstract class Target
/*     */   {
/*     */     final Actor a;
/*     */     
/*     */     public Target(Actor param1Actor) {
/* 307 */       if (param1Actor == null) throw new IllegalArgumentException("actor cannot be null."); 
/* 308 */       this.a = param1Actor;
/*     */       Stage stage;
/* 310 */       if ((stage = param1Actor.getStage()) != null && param1Actor == stage.getRoot()) {
/* 311 */         throw new IllegalArgumentException("The stage root cannot be a drag and drop target.");
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public abstract boolean drag(DragAndDrop.Source param1Source, DragAndDrop.Payload param1Payload, float param1Float1, float param1Float2, int param1Int);
/*     */ 
/*     */ 
/*     */     
/*     */     public void reset(DragAndDrop.Source param1Source, DragAndDrop.Payload param1Payload) {}
/*     */ 
/*     */     
/*     */     public abstract void drop(DragAndDrop.Source param1Source, DragAndDrop.Payload param1Payload, float param1Float1, float param1Float2, int param1Int);
/*     */ 
/*     */     
/*     */     public Actor getActor() {
/* 328 */       return this.a;
/*     */     } }
/*     */   public static class Payload { @Null
/*     */     Actor a;
/*     */     @Null
/*     */     Actor b;
/*     */     @Null
/*     */     Actor c;
/*     */     @Null
/*     */     private Object d;
/*     */     
/*     */     public void setDragActor(@Null Actor param1Actor) {
/* 340 */       this.a = param1Actor;
/*     */     }
/*     */     @Null
/*     */     public Actor getDragActor() {
/* 344 */       return this.a;
/*     */     }
/*     */     
/*     */     public void setValidDragActor(@Null Actor param1Actor) {
/* 348 */       this.b = param1Actor;
/*     */     }
/*     */     @Null
/*     */     public Actor getValidDragActor() {
/* 352 */       return this.b;
/*     */     }
/*     */     
/*     */     public void setInvalidDragActor(@Null Actor param1Actor) {
/* 356 */       this.c = param1Actor;
/*     */     }
/*     */     @Null
/*     */     public Actor getInvalidDragActor() {
/* 360 */       return this.c;
/*     */     }
/*     */     @Null
/*     */     public Object getObject() {
/* 364 */       return this.d;
/*     */     }
/*     */     
/*     */     public void setObject(@Null Object param1Object) {
/* 368 */       this.d = param1Object;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\utils\DragAndDrop.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */