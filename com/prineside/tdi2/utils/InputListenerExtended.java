/*    */ package com.prineside.tdi2.utils;
/*    */ import com.badlogic.gdx.math.Vector2;
/*    */ import com.prineside.tdi2.scene2d.Event;
/*    */ import com.prineside.tdi2.scene2d.EventListener;
/*    */ import com.prineside.tdi2.scene2d.InputEvent;
/*    */ import com.prineside.tdi2.scene2d.InputListener;
/*    */ 
/*    */ public class InputListenerExtended extends InputListener {
/*  9 */   private static final Vector2 a = new Vector2();
/*    */   
/*    */   public static final int MODE_AUTO = 0;
/*    */   
/*    */   public static final int MODE_ALWAYS_TRUE = 1;
/*    */   public static final int MODE_ALWAYS_FALSE = 2;
/* 15 */   private final int[] b = new int[(InputEvent.Type.values()).length];
/*    */   
/*    */   public InputListenerExtended setMode(InputEvent.Type paramType, int paramInt) {
/* 18 */     this.b[paramType.ordinal()] = paramInt;
/* 19 */     return this;
/*    */   }
/*    */   
/*    */   public int getMode(InputEvent.Type paramType) {
/* 23 */     return this.b[paramType.ordinal()];
/*    */   }
/*    */   
/*    */   private boolean a(InputEvent.Type paramType, boolean paramBoolean) {
/*    */     int i;
/* 28 */     switch (i = getMode(paramType)) { case 1:
/* 29 */         return true;
/* 30 */       case 2: return false; }
/* 31 */      return paramBoolean;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean handle(Event paramEvent) {
/*    */     boolean bool;
/* 37 */     if (!(paramEvent instanceof InputEvent)) return false; 
/* 38 */     InputEvent inputEvent = (InputEvent)paramEvent;
/*    */     
/* 40 */     switch (null.a[inputEvent.getType().ordinal()]) {
/*    */       case 1:
/* 42 */         return a(InputEvent.Type.keyDown, keyDown(inputEvent, inputEvent.getKeyCode()));
/*    */       case 2:
/* 44 */         return a(InputEvent.Type.keyUp, keyUp(inputEvent, inputEvent.getKeyCode()));
/*    */       case 3:
/* 46 */         return a(InputEvent.Type.keyTyped, keyTyped(inputEvent, inputEvent.getCharacter()));
/*    */     } 
/*    */     
/* 49 */     inputEvent.toCoordinates(inputEvent.getListenerActor(), a);
/*    */     
/* 51 */     switch (null.a[inputEvent.getType().ordinal()]) {
/*    */       
/*    */       case 4:
/* 54 */         if ((bool = touchDown(inputEvent, a.x, a.y, inputEvent.getPointer(), inputEvent.getButton())) && inputEvent.getTouchFocus()) {
/* 55 */           inputEvent.getStage().addTouchFocus((EventListener)this, inputEvent.getListenerActor(), inputEvent.getTarget(), inputEvent.getPointer(), inputEvent
/* 56 */               .getButton());
/*    */         }
/* 58 */         return a(InputEvent.Type.touchDown, bool);
/*    */       case 5:
/* 60 */         touchUp(inputEvent, a.x, a.y, inputEvent.getPointer(), inputEvent.getButton());
/* 61 */         return a(InputEvent.Type.touchUp, true);
/*    */       case 6:
/* 63 */         touchDragged(inputEvent, a.x, a.y, inputEvent.getPointer());
/* 64 */         return a(InputEvent.Type.touchDragged, true);
/*    */       case 7:
/* 66 */         return a(InputEvent.Type.mouseMoved, mouseMoved(inputEvent, a.x, a.y));
/*    */       case 8:
/* 68 */         return a(InputEvent.Type.scrolled, scrolled(inputEvent, a.x, a.y, inputEvent.getScrollAmountX(), inputEvent.getScrollAmountY()));
/*    */       case 9:
/* 70 */         enter(inputEvent, a.x, a.y, inputEvent.getPointer(), inputEvent.getRelatedActor());
/* 71 */         return a(InputEvent.Type.enter, false);
/*    */       case 10:
/* 73 */         exit(inputEvent, a.x, a.y, inputEvent.getPointer(), inputEvent.getRelatedActor());
/* 74 */         return a(InputEvent.Type.exit, false);
/*    */     } 
/* 76 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\InputListenerExtended.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */