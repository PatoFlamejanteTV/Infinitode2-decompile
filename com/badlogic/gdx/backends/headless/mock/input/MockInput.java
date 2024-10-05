/*     */ package com.badlogic.gdx.backends.headless.mock.input;
/*     */ 
/*     */ import com.badlogic.gdx.Input;
/*     */ import com.badlogic.gdx.InputAdapter;
/*     */ import com.badlogic.gdx.InputProcessor;
/*     */ import com.badlogic.gdx.input.NativeInputConfiguration;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MockInput
/*     */   implements Input
/*     */ {
/*     */   private InputProcessor mockInputProcessor;
/*     */   
/*     */   public float getAccelerometerX() {
/*  30 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getAccelerometerY() {
/*  35 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getAccelerometerZ() {
/*  40 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getGyroscopeX() {
/*  45 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getGyroscopeY() {
/*  50 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getGyroscopeZ() {
/*  55 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMaxPointers() {
/*  60 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getX() {
/*  65 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getX(int paramInt) {
/*  70 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDeltaX() {
/*  75 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDeltaX(int paramInt) {
/*  80 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getY() {
/*  85 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getY(int paramInt) {
/*  90 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDeltaY() {
/*  95 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDeltaY(int paramInt) {
/* 100 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTouched() {
/* 105 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean justTouched() {
/* 110 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTouched(int paramInt) {
/* 115 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getPressure() {
/* 120 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getPressure(int paramInt) {
/* 125 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isButtonPressed(int paramInt) {
/* 130 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isButtonJustPressed(int paramInt) {
/* 135 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isKeyPressed(int paramInt) {
/* 140 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isKeyJustPressed(int paramInt) {
/* 145 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void getTextInput(Input.TextInputListener paramTextInputListener, String paramString1, String paramString2, String paramString3) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void getTextInput(Input.TextInputListener paramTextInputListener, String paramString1, String paramString2, String paramString3, Input.OnscreenKeyboardType paramOnscreenKeyboardType) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOnscreenKeyboardVisible(boolean paramBoolean) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOnscreenKeyboardVisible(boolean paramBoolean, Input.OnscreenKeyboardType paramOnscreenKeyboardType) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void openTextInputField(NativeInputConfiguration paramNativeInputConfiguration) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void closeTextInputField(boolean paramBoolean) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKeyboardHeightObserver(Input.KeyboardHeightObserver paramKeyboardHeightObserver) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void vibrate(int paramInt) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void vibrate(int paramInt, boolean paramBoolean) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void vibrate(int paramInt1, int paramInt2, boolean paramBoolean) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void vibrate(Input.VibrationType paramVibrationType) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public float getAzimuth() {
/* 202 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getPitch() {
/* 207 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getRoll() {
/* 212 */     return 0.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void getRotationMatrix(float[] paramArrayOffloat) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public long getCurrentEventTime() {
/* 222 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCatchBackKey(boolean paramBoolean) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCatchBackKey() {
/* 232 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCatchMenuKey(boolean paramBoolean) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCatchMenuKey() {
/* 242 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCatchKey(int paramInt, boolean paramBoolean) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCatchKey(int paramInt) {
/* 252 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInputProcessor(InputProcessor paramInputProcessor) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InputProcessor getInputProcessor() {
/* 264 */     if (this.mockInputProcessor == null) {
/* 265 */       this.mockInputProcessor = (InputProcessor)new InputAdapter();
/*     */     }
/* 267 */     return this.mockInputProcessor;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPeripheralAvailable(Input.Peripheral paramPeripheral) {
/* 272 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRotation() {
/* 277 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public Input.Orientation getNativeOrientation() {
/* 282 */     return Input.Orientation.Landscape;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCursorCatched(boolean paramBoolean) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCursorCatched() {
/* 292 */     return false;
/*     */   }
/*     */   
/*     */   public void setCursorPosition(int paramInt1, int paramInt2) {}
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\headless\mock\input\MockInput.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */