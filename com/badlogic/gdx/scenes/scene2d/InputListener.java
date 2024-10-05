/*     */ package com.badlogic.gdx.scenes.scene2d;
/*     */ 
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InputListener
/*     */   implements EventListener
/*     */ {
/*  39 */   private static final Vector2 tmpCoords = new Vector2();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean handle(Event paramEvent) {
/*     */     boolean bool;
/*  48 */     if (!(paramEvent instanceof InputEvent)) return false; 
/*  49 */     paramEvent = paramEvent;
/*     */     
/*  51 */     switch (paramEvent.getType()) {
/*     */       case keyDown:
/*  53 */         return keyDown((InputEvent)paramEvent, paramEvent.getKeyCode());
/*     */       case keyUp:
/*  55 */         return keyUp((InputEvent)paramEvent, paramEvent.getKeyCode());
/*     */       case keyTyped:
/*  57 */         return keyTyped((InputEvent)paramEvent, paramEvent.getCharacter());
/*     */     } 
/*     */     
/*  60 */     paramEvent.toCoordinates(paramEvent.getListenerActor(), tmpCoords);
/*     */     
/*  62 */     switch (paramEvent.getType()) {
/*     */       
/*     */       case touchDown:
/*  65 */         if ((bool = touchDown((InputEvent)paramEvent, tmpCoords.x, tmpCoords.y, paramEvent.getPointer(), paramEvent.getButton())) && paramEvent.getTouchFocus()) {
/*  66 */           paramEvent.getStage().addTouchFocus(this, paramEvent.getListenerActor(), paramEvent.getTarget(), paramEvent.getPointer(), paramEvent
/*  67 */               .getButton());
/*     */         }
/*  69 */         return bool;
/*     */       case touchUp:
/*  71 */         touchUp((InputEvent)paramEvent, tmpCoords.x, tmpCoords.y, paramEvent.getPointer(), paramEvent.getButton());
/*  72 */         return true;
/*     */       case touchDragged:
/*  74 */         touchDragged((InputEvent)paramEvent, tmpCoords.x, tmpCoords.y, paramEvent.getPointer());
/*  75 */         return true;
/*     */       case mouseMoved:
/*  77 */         return mouseMoved((InputEvent)paramEvent, tmpCoords.x, tmpCoords.y);
/*     */       case scrolled:
/*  79 */         return scrolled((InputEvent)paramEvent, tmpCoords.x, tmpCoords.y, paramEvent.getScrollAmountX(), paramEvent.getScrollAmountY());
/*     */       case enter:
/*  81 */         enter((InputEvent)paramEvent, tmpCoords.x, tmpCoords.y, paramEvent.getPointer(), paramEvent.getRelatedActor());
/*  82 */         return false;
/*     */       case exit:
/*  84 */         exit((InputEvent)paramEvent, tmpCoords.x, tmpCoords.y, paramEvent.getPointer(), paramEvent.getRelatedActor());
/*  85 */         return false;
/*     */     } 
/*  87 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean touchDown(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2) {
/*  96 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void touchUp(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void touchDragged(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean mouseMoved(InputEvent paramInputEvent, float paramFloat1, float paramFloat2) {
/* 115 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void enter(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt, @Null Actor paramActor) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void exit(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt, @Null Actor paramActor) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean scrolled(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 134 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean keyDown(InputEvent paramInputEvent, int paramInt) {
/* 139 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean keyUp(InputEvent paramInputEvent, int paramInt) {
/* 144 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean keyTyped(InputEvent paramInputEvent, char paramChar) {
/* 150 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2d\InputListener.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */