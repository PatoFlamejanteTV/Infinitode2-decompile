/*     */ package com.badlogic.gdx.scenes.scene2d.utils;
/*     */ 
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*     */ import com.badlogic.gdx.scenes.scene2d.EventListener;
/*     */ import com.badlogic.gdx.scenes.scene2d.InputEvent;
/*     */ import com.badlogic.gdx.scenes.scene2d.Stage;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
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
/*  33 */   static final Vector2 tmpVector = new Vector2();
/*     */   
/*     */   Source dragSource;
/*     */   Payload payload;
/*     */   Actor dragActor;
/*     */   boolean removeDragActor;
/*     */   Target target;
/*     */   boolean isValidTarget;
/*  41 */   final Array<Target> targets = new Array(8);
/*  42 */   final ObjectMap<Source, DragListener> sourceListeners = new ObjectMap(8);
/*  43 */   private float tapSquareSize = 8.0F;
/*     */   private int button;
/*  45 */   float dragActorX = 0.0F; float dragActorY = 0.0F; float touchOffsetX;
/*     */   float touchOffsetY;
/*     */   long dragValidTime;
/*  48 */   int dragTime = 250;
/*  49 */   int activePointer = -1;
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
/*     */   boolean cancelTouchFocus = true;
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
/*     */   boolean keepWithinStage = true;
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
/*     */   public void addSource(final Source source) {
/*     */     DragListener dragListener;
/* 170 */     (dragListener = new DragListener() { public void dragStart(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int) { if (DragAndDrop.this.activePointer != -1) { param1InputEvent.stop(); return; }  DragAndDrop.this.activePointer = param1Int; DragAndDrop.this.dragValidTime = System.currentTimeMillis() + DragAndDrop.this.dragTime; DragAndDrop.this.dragSource = source; DragAndDrop.this.payload = source.dragStart(param1InputEvent, getTouchDownX(), getTouchDownY(), param1Int); param1InputEvent.stop(); Stage stage; if (DragAndDrop.this.cancelTouchFocus && DragAndDrop.this.payload != null && (stage = source.getActor().getStage()) != null) stage.cancelTouchFocusExcept((EventListener)this, source.getActor());  } public void drag(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int) { if (DragAndDrop.this.payload == null) return;  if (param1Int != DragAndDrop.this.activePointer) return;  source.drag(param1InputEvent, param1Float1, param1Float2, param1Int); Stage stage = param1InputEvent.getStage(); Actor actor1 = DragAndDrop.this.dragActor; float f1 = 0.0F, f2 = 0.0F; if (actor1 != null) { f1 = actor1.getX(); f2 = actor1.getY(); actor1.setPosition(2.1474836E9F, 2.1474836E9F); }  float f3 = param1InputEvent.getStageX() + DragAndDrop.this.touchOffsetX, f4 = param1InputEvent.getStageY() + DragAndDrop.this.touchOffsetY; Actor actor3; if ((actor3 = param1InputEvent.getStage().hit(f3, f4, true)) == null) actor3 = param1InputEvent.getStage().hit(f3, f4, false);  if (actor1 != null) actor1.setPosition(f1, f2);  DragAndDrop.Target target = null; DragAndDrop.this.isValidTarget = false; if (actor3 != null) { byte b; int i; for (b = 0, i = DragAndDrop.this.targets.size; b < i; b++) { DragAndDrop.Target target1; if ((target1 = (DragAndDrop.Target)DragAndDrop.this.targets.get(b)).actor.isAscendantOf(actor3)) { target = target1; target1.actor.stageToLocalCoordinates(DragAndDrop.tmpVector.set(f3, f4)); break; }  }  }  if (target != DragAndDrop.this.target) { if (DragAndDrop.this.target != null) DragAndDrop.this.target.reset(source, DragAndDrop.this.payload);  DragAndDrop.this.target = target; }  if (target != null) DragAndDrop.this.isValidTarget = target.drag(source, DragAndDrop.this.payload, DragAndDrop.tmpVector.x, DragAndDrop.tmpVector.y, param1Int);  Actor actor2 = null; if (DragAndDrop.this.target != null) actor2 = DragAndDrop.this.isValidTarget ? DragAndDrop.this.payload.validDragActor : DragAndDrop.this.payload.invalidDragActor;  if (actor2 == null) actor2 = DragAndDrop.this.payload.dragActor;  if (actor2 != actor1) { if (actor1 != null && DragAndDrop.this.removeDragActor) actor1.remove();  DragAndDrop.this.dragActor = actor2; DragAndDrop.this.removeDragActor = (actor2.getStage() == null); if (DragAndDrop.this.removeDragActor) stage.addActor(actor2);  }  if (actor2 == null) return;  float f5 = param1InputEvent.getStageX() - actor2.getWidth() + DragAndDrop.this.dragActorX; float f6 = param1InputEvent.getStageY() + DragAndDrop.this.dragActorY; if (DragAndDrop.this.keepWithinStage) { if (f5 < 0.0F) f5 = 0.0F;  if (f6 < 0.0F) f6 = 0.0F;  if (f5 + actor2.getWidth() > stage.getWidth()) f5 = stage.getWidth() - actor2.getWidth();  if (f6 + actor2.getHeight() > stage.getHeight()) f6 = stage.getHeight() - actor2.getHeight();  }  actor2.setPosition(f5, f6); } public void dragStop(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int) { if (param1Int != DragAndDrop.this.activePointer) return;  DragAndDrop.this.activePointer = -1; if (DragAndDrop.this.payload == null) return;  if (System.currentTimeMillis() < DragAndDrop.this.dragValidTime) { DragAndDrop.this.isValidTarget = false; } else if (!DragAndDrop.this.isValidTarget && DragAndDrop.this.target != null) { float f1 = param1InputEvent.getStageX() + DragAndDrop.this.touchOffsetX, f2 = param1InputEvent.getStageY() + DragAndDrop.this.touchOffsetY; DragAndDrop.this.target.actor.stageToLocalCoordinates(DragAndDrop.tmpVector.set(f1, f2)); DragAndDrop.this.isValidTarget = DragAndDrop.this.target.drag(source, DragAndDrop.this.payload, DragAndDrop.tmpVector.x, DragAndDrop.tmpVector.y, param1Int); }  if (DragAndDrop.this.dragActor != null && DragAndDrop.this.removeDragActor) DragAndDrop.this.dragActor.remove();  if (DragAndDrop.this.isValidTarget) { float f1 = param1InputEvent.getStageX() + DragAndDrop.this.touchOffsetX, f2 = param1InputEvent.getStageY() + DragAndDrop.this.touchOffsetY; DragAndDrop.this.target.actor.stageToLocalCoordinates(DragAndDrop.tmpVector.set(f1, f2)); DragAndDrop.this.target.drop(source, DragAndDrop.this.payload, DragAndDrop.tmpVector.x, DragAndDrop.tmpVector.y, param1Int); }  source.dragStop(param1InputEvent, param1Float1, param1Float2, param1Int, DragAndDrop.this.payload, DragAndDrop.this.isValidTarget ? DragAndDrop.this.target : null); if (DragAndDrop.this.target != null) DragAndDrop.this.target.reset(source, DragAndDrop.this.payload);  DragAndDrop.this.dragSource = null; DragAndDrop.this.payload = null; DragAndDrop.this.target = null; DragAndDrop.this.isValidTarget = false; DragAndDrop.this.dragActor = null; } }).setTapSquareSize(this.tapSquareSize);
/* 171 */     dragListener.setButton(this.button);
/* 172 */     source.actor.addCaptureListener((EventListener)dragListener);
/* 173 */     this.sourceListeners.put(source, dragListener);
/*     */   }
/*     */   
/*     */   public void removeSource(Source paramSource) {
/* 177 */     DragListener dragListener = (DragListener)this.sourceListeners.remove(paramSource);
/* 178 */     paramSource.actor.removeCaptureListener((EventListener)dragListener);
/*     */   }
/*     */   
/*     */   public void addTarget(Target paramTarget) {
/* 182 */     this.targets.add(paramTarget);
/*     */   }
/*     */   
/*     */   public void removeTarget(Target paramTarget) {
/* 186 */     this.targets.removeValue(paramTarget, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 191 */     this.targets.clear();
/* 192 */     for (ObjectMap.Entries<ObjectMap.Entry> entries = this.sourceListeners.entries().iterator(); entries.hasNext();)
/* 193 */       ((Source)(entry = entries.next()).key).actor.removeCaptureListener((EventListener)entry.value); 
/* 194 */     this.sourceListeners.clear(8);
/*     */   }
/*     */ 
/*     */   
/*     */   public void cancelTouchFocusExcept(Source paramSource) {
/*     */     DragListener dragListener;
/* 200 */     if ((dragListener = (DragListener)this.sourceListeners.get(paramSource)) == null)
/*     */       return;  Stage stage;
/* 202 */     if ((stage = paramSource.getActor().getStage()) != null) stage.cancelTouchFocusExcept((EventListener)dragListener, paramSource.getActor());
/*     */   
/*     */   }
/*     */   
/*     */   public void setTapSquareSize(float paramFloat) {
/* 207 */     this.tapSquareSize = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setButton(int paramInt) {
/* 212 */     this.button = paramInt;
/*     */   }
/*     */   
/*     */   public void setDragActorPosition(float paramFloat1, float paramFloat2) {
/* 216 */     this.dragActorX = paramFloat1;
/* 217 */     this.dragActorY = paramFloat2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTouchOffset(float paramFloat1, float paramFloat2) {
/* 223 */     this.touchOffsetX = paramFloat1;
/* 224 */     this.touchOffsetY = paramFloat2;
/*     */   }
/*     */   
/*     */   public boolean isDragging() {
/* 228 */     return (this.payload != null);
/*     */   }
/*     */   
/*     */   @Null
/*     */   public Actor getDragActor() {
/* 233 */     return this.dragActor;
/*     */   }
/*     */   
/*     */   @Null
/*     */   public Payload getDragPayload() {
/* 238 */     return this.payload;
/*     */   }
/*     */   
/*     */   @Null
/*     */   public Source getDragSource() {
/* 243 */     return this.dragSource;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDragTime(int paramInt) {
/* 249 */     this.dragTime = paramInt;
/*     */   }
/*     */   
/*     */   public int getDragTime() {
/* 253 */     return this.dragTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDragValid() {
/* 258 */     return (this.payload != null && System.currentTimeMillis() >= this.dragValidTime);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCancelTouchFocus(boolean paramBoolean) {
/* 265 */     this.cancelTouchFocus = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setKeepWithinStage(boolean paramBoolean) {
/* 269 */     this.keepWithinStage = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public static abstract class Source
/*     */   {
/*     */     final Actor actor;
/*     */     
/*     */     public Source(Actor param1Actor) {
/* 278 */       if (param1Actor == null) throw new IllegalArgumentException("actor cannot be null."); 
/* 279 */       this.actor = param1Actor;
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
/* 297 */       return this.actor;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static abstract class Target
/*     */   {
/*     */     final Actor actor;
/*     */     
/*     */     public Target(Actor param1Actor) {
/* 307 */       if (param1Actor == null) throw new IllegalArgumentException("actor cannot be null."); 
/* 308 */       this.actor = param1Actor;
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
/* 328 */       return this.actor;
/*     */     } }
/*     */   public static class Payload { @Null
/*     */     Actor dragActor;
/*     */     @Null
/*     */     Actor validDragActor;
/*     */     @Null
/*     */     Actor invalidDragActor;
/*     */     @Null
/*     */     Object object;
/*     */     
/*     */     public void setDragActor(@Null Actor param1Actor) {
/* 340 */       this.dragActor = param1Actor;
/*     */     }
/*     */     @Null
/*     */     public Actor getDragActor() {
/* 344 */       return this.dragActor;
/*     */     }
/*     */     
/*     */     public void setValidDragActor(@Null Actor param1Actor) {
/* 348 */       this.validDragActor = param1Actor;
/*     */     }
/*     */     @Null
/*     */     public Actor getValidDragActor() {
/* 352 */       return this.validDragActor;
/*     */     }
/*     */     
/*     */     public void setInvalidDragActor(@Null Actor param1Actor) {
/* 356 */       this.invalidDragActor = param1Actor;
/*     */     }
/*     */     @Null
/*     */     public Actor getInvalidDragActor() {
/* 360 */       return this.invalidDragActor;
/*     */     }
/*     */     @Null
/*     */     public Object getObject() {
/* 364 */       return this.object;
/*     */     }
/*     */     
/*     */     public void setObject(@Null Object param1Object) {
/* 368 */       this.object = param1Object;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\utils\DragAndDrop.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */