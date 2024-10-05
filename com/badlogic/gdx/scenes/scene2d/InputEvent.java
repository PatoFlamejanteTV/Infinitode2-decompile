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
/*     */ public class InputEvent
/*     */   extends Event
/*     */ {
/*     */   private Type type;
/*     */   private float stageX;
/*     */   private float stageY;
/*     */   private float scrollAmountX;
/*     */   private float scrollAmountY;
/*     */   private int pointer;
/*     */   private int button;
/*     */   private int keyCode;
/*     */   private char character;
/*     */   @Null
/*     */   private Actor relatedActor;
/*     */   private boolean touchFocus = true;
/*     */   
/*     */   public void reset() {
/*  34 */     super.reset();
/*  35 */     this.relatedActor = null;
/*  36 */     this.button = -1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getStageX() {
/*  42 */     return this.stageX;
/*     */   }
/*     */   
/*     */   public void setStageX(float paramFloat) {
/*  46 */     this.stageX = paramFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getStageY() {
/*  52 */     return this.stageY;
/*     */   }
/*     */   
/*     */   public void setStageY(float paramFloat) {
/*  56 */     this.stageY = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public Type getType() {
/*  61 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(Type paramType) {
/*  65 */     this.type = paramType;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPointer() {
/*  71 */     return this.pointer;
/*     */   }
/*     */   
/*     */   public void setPointer(int paramInt) {
/*  75 */     this.pointer = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getButton() {
/*  81 */     return this.button;
/*     */   }
/*     */   
/*     */   public void setButton(int paramInt) {
/*  85 */     this.button = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getKeyCode() {
/*  90 */     return this.keyCode;
/*     */   }
/*     */   
/*     */   public void setKeyCode(int paramInt) {
/*  94 */     this.keyCode = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public char getCharacter() {
/*  99 */     return this.character;
/*     */   }
/*     */   
/*     */   public void setCharacter(char paramChar) {
/* 103 */     this.character = paramChar;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getScrollAmountX() {
/* 108 */     return this.scrollAmountX;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getScrollAmountY() {
/* 113 */     return this.scrollAmountY;
/*     */   }
/*     */   
/*     */   public void setScrollAmountX(float paramFloat) {
/* 117 */     this.scrollAmountX = paramFloat;
/*     */   }
/*     */   
/*     */   public void setScrollAmountY(float paramFloat) {
/* 121 */     this.scrollAmountY = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   @Null
/*     */   public Actor getRelatedActor() {
/* 127 */     return this.relatedActor;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRelatedActor(@Null Actor paramActor) {
/* 132 */     this.relatedActor = paramActor;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector2 toCoordinates(Actor paramActor, Vector2 paramVector2) {
/* 138 */     paramVector2.set(this.stageX, this.stageY);
/* 139 */     paramActor.stageToLocalCoordinates(paramVector2);
/* 140 */     return paramVector2;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTouchFocusCancel() {
/* 145 */     return (this.stageX == -2.1474836E9F || this.stageY == -2.1474836E9F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getTouchFocus() {
/* 151 */     return this.touchFocus;
/*     */   }
/*     */   
/*     */   public void setTouchFocus(boolean paramBoolean) {
/* 155 */     this.touchFocus = paramBoolean;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 159 */     return this.type.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public enum Type
/*     */   {
/* 165 */     touchDown,
/*     */     
/* 167 */     touchUp,
/*     */     
/* 169 */     touchDragged,
/*     */     
/* 171 */     mouseMoved,
/*     */     
/* 173 */     enter,
/*     */     
/* 175 */     exit,
/*     */     
/* 177 */     scrolled,
/*     */     
/* 179 */     keyDown,
/*     */     
/* 181 */     keyUp,
/*     */     
/* 183 */     keyTyped;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2d\InputEvent.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */