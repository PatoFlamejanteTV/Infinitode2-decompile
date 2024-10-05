/*     */ package com.prineside.tdi2.scene2d;
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
/*     */   private Type a;
/*     */   private float b;
/*     */   private float c;
/*     */   private float d;
/*     */   private float e;
/*     */   private int f;
/*     */   private int g;
/*     */   private int h;
/*     */   private char i;
/*     */   @Null
/*     */   private Actor j;
/*     */   private boolean k = true;
/*     */   
/*     */   public void reset() {
/*  34 */     super.reset();
/*  35 */     this.j = null;
/*  36 */     this.g = -1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getStageX() {
/*  42 */     return this.b;
/*     */   }
/*     */   
/*     */   public void setStageX(float paramFloat) {
/*  46 */     this.b = paramFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getStageY() {
/*  52 */     return this.c;
/*     */   }
/*     */   
/*     */   public void setStageY(float paramFloat) {
/*  56 */     this.c = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public Type getType() {
/*  61 */     return this.a;
/*     */   }
/*     */   
/*     */   public void setType(Type paramType) {
/*  65 */     this.a = paramType;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPointer() {
/*  71 */     return this.f;
/*     */   }
/*     */   
/*     */   public void setPointer(int paramInt) {
/*  75 */     this.f = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getButton() {
/*  81 */     return this.g;
/*     */   }
/*     */   
/*     */   public void setButton(int paramInt) {
/*  85 */     this.g = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getKeyCode() {
/*  90 */     return this.h;
/*     */   }
/*     */   
/*     */   public void setKeyCode(int paramInt) {
/*  94 */     this.h = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public char getCharacter() {
/*  99 */     return this.i;
/*     */   }
/*     */   
/*     */   public void setCharacter(char paramChar) {
/* 103 */     this.i = paramChar;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getScrollAmountX() {
/* 108 */     return this.d;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getScrollAmountY() {
/* 113 */     return this.e;
/*     */   }
/*     */   
/*     */   public void setScrollAmountX(float paramFloat) {
/* 117 */     this.d = paramFloat;
/*     */   }
/*     */   
/*     */   public void setScrollAmountY(float paramFloat) {
/* 121 */     this.e = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   @Null
/*     */   public Actor getRelatedActor() {
/* 127 */     return this.j;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRelatedActor(@Null Actor paramActor) {
/* 132 */     this.j = paramActor;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector2 toCoordinates(Actor paramActor, Vector2 paramVector2) {
/* 138 */     paramVector2.set(this.b, this.c);
/* 139 */     paramActor.stageToLocalCoordinates(paramVector2);
/* 140 */     return paramVector2;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTouchFocusCancel() {
/* 145 */     return (this.b == -2.1474836E9F || this.c == -2.1474836E9F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getTouchFocus() {
/* 151 */     return this.k;
/*     */   }
/*     */   
/*     */   public void setTouchFocus(boolean paramBoolean) {
/* 155 */     this.k = paramBoolean;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 159 */     return this.a.toString();
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


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2d\InputEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */