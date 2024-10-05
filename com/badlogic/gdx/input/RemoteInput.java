/*     */ package com.badlogic.gdx.input;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.Input;
/*     */ import com.badlogic.gdx.InputProcessor;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import java.io.DataInputStream;
/*     */ import java.io.IOException;
/*     */ import java.net.InetAddress;
/*     */ import java.net.ServerSocket;
/*     */ import java.net.Socket;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RemoteInput
/*     */   implements Input, Runnable
/*     */ {
/*     */   private static final int MAX_TOUCHES = 20;
/*     */   
/*     */   public static interface RemoteInputListener
/*     */   {
/*     */     void onConnected();
/*     */     
/*     */     void onDisconnected();
/*     */   }
/*     */   
/*     */   class KeyEvent
/*     */   {
/*     */     static final int KEY_DOWN = 0;
/*     */     static final int KEY_UP = 1;
/*     */     static final int KEY_TYPED = 2;
/*     */     long timeStamp;
/*     */     int type;
/*     */     int keyCode;
/*     */     char keyChar;
/*     */   }
/*     */   
/*     */   class TouchEvent
/*     */   {
/*     */     static final int TOUCH_DOWN = 0;
/*     */     static final int TOUCH_UP = 1;
/*     */     static final int TOUCH_DRAGGED = 2;
/*     */     long timeStamp;
/*     */     int type;
/*     */     int x;
/*     */     int y;
/*     */     int pointer;
/*     */   }
/*     */   
/*     */   class EventTrigger
/*     */     implements Runnable
/*     */   {
/*     */     RemoteInput.TouchEvent touchEvent;
/*     */     RemoteInput.KeyEvent keyEvent;
/*     */     
/*     */     public EventTrigger(RemoteInput.TouchEvent param1TouchEvent, RemoteInput.KeyEvent param1KeyEvent) {
/*  83 */       this.touchEvent = param1TouchEvent;
/*  84 */       this.keyEvent = param1KeyEvent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void run() {
/*  89 */       RemoteInput.this.justTouched = false;
/*  90 */       if (RemoteInput.this.keyJustPressed) {
/*  91 */         RemoteInput.this.keyJustPressed = false;
/*  92 */         for (byte b = 0; b < RemoteInput.this.justPressedKeys.length; b++) {
/*  93 */           RemoteInput.this.justPressedKeys[b] = false;
/*     */         }
/*     */       } 
/*     */       
/*  97 */       if (RemoteInput.this.processor != null) {
/*  98 */         if (this.touchEvent != null) {
/*  99 */           switch (this.touchEvent.type) {
/*     */             case 0:
/* 101 */               RemoteInput.this.deltaX[this.touchEvent.pointer] = 0;
/* 102 */               RemoteInput.this.deltaY[this.touchEvent.pointer] = 0;
/* 103 */               RemoteInput.this.processor.touchDown(this.touchEvent.x, this.touchEvent.y, this.touchEvent.pointer, 0);
/* 104 */               RemoteInput.this.isTouched[this.touchEvent.pointer] = true;
/* 105 */               RemoteInput.this.justTouched = true;
/*     */               break;
/*     */             case 1:
/* 108 */               RemoteInput.this.deltaX[this.touchEvent.pointer] = 0;
/* 109 */               RemoteInput.this.deltaY[this.touchEvent.pointer] = 0;
/* 110 */               RemoteInput.this.processor.touchUp(this.touchEvent.x, this.touchEvent.y, this.touchEvent.pointer, 0);
/* 111 */               RemoteInput.this.isTouched[this.touchEvent.pointer] = false;
/*     */               break;
/*     */             case 2:
/* 114 */               RemoteInput.this.deltaX[this.touchEvent.pointer] = this.touchEvent.x - RemoteInput.this.touchX[this.touchEvent.pointer];
/* 115 */               RemoteInput.this.deltaY[this.touchEvent.pointer] = this.touchEvent.y - RemoteInput.this.touchY[this.touchEvent.pointer];
/* 116 */               RemoteInput.this.processor.touchDragged(this.touchEvent.x, this.touchEvent.y, this.touchEvent.pointer);
/*     */               break;
/*     */           } 
/* 119 */           RemoteInput.this.touchX[this.touchEvent.pointer] = this.touchEvent.x;
/* 120 */           RemoteInput.this.touchY[this.touchEvent.pointer] = this.touchEvent.y;
/*     */         } 
/* 122 */         if (this.keyEvent != null) {
/* 123 */           switch (this.keyEvent.type) {
/*     */             case 0:
/* 125 */               RemoteInput.this.processor.keyDown(this.keyEvent.keyCode);
/* 126 */               if (!RemoteInput.this.keys[this.keyEvent.keyCode]) {
/* 127 */                 RemoteInput.this.keyCount++;
/* 128 */                 RemoteInput.this.keys[this.keyEvent.keyCode] = true;
/*     */               } 
/* 130 */               RemoteInput.this.keyJustPressed = true;
/* 131 */               RemoteInput.this.justPressedKeys[this.keyEvent.keyCode] = true;
/*     */               return;
/*     */             case 1:
/* 134 */               RemoteInput.this.processor.keyUp(this.keyEvent.keyCode);
/* 135 */               if (RemoteInput.this.keys[this.keyEvent.keyCode]) {
/* 136 */                 RemoteInput.this.keyCount--;
/* 137 */                 RemoteInput.this.keys[this.keyEvent.keyCode] = false; return;
/*     */               } 
/*     */               break;
/*     */             case 2:
/* 141 */               RemoteInput.this.processor.keyTyped(this.keyEvent.keyChar); break;
/*     */           } 
/*     */           return;
/*     */         } 
/*     */       } else {
/* 146 */         if (this.touchEvent != null) {
/* 147 */           switch (this.touchEvent.type) {
/*     */             case 0:
/* 149 */               RemoteInput.this.deltaX[this.touchEvent.pointer] = 0;
/* 150 */               RemoteInput.this.deltaY[this.touchEvent.pointer] = 0;
/* 151 */               RemoteInput.this.isTouched[this.touchEvent.pointer] = true;
/* 152 */               RemoteInput.this.justTouched = true;
/*     */               break;
/*     */             case 1:
/* 155 */               RemoteInput.this.deltaX[this.touchEvent.pointer] = 0;
/* 156 */               RemoteInput.this.deltaY[this.touchEvent.pointer] = 0;
/* 157 */               RemoteInput.this.isTouched[this.touchEvent.pointer] = false;
/*     */               break;
/*     */             case 2:
/* 160 */               RemoteInput.this.deltaX[this.touchEvent.pointer] = this.touchEvent.x - RemoteInput.this.touchX[this.touchEvent.pointer];
/* 161 */               RemoteInput.this.deltaY[this.touchEvent.pointer] = this.touchEvent.y - RemoteInput.this.touchY[this.touchEvent.pointer];
/*     */               break;
/*     */           } 
/* 164 */           RemoteInput.this.touchX[this.touchEvent.pointer] = this.touchEvent.x;
/* 165 */           RemoteInput.this.touchY[this.touchEvent.pointer] = this.touchEvent.y;
/*     */         } 
/* 167 */         if (this.keyEvent != null) {
/* 168 */           if (this.keyEvent.type == 0) {
/* 169 */             if (!RemoteInput.this.keys[this.keyEvent.keyCode]) {
/* 170 */               RemoteInput.this.keyCount++;
/* 171 */               RemoteInput.this.keys[this.keyEvent.keyCode] = true;
/*     */             } 
/* 173 */             RemoteInput.this.keyJustPressed = true;
/* 174 */             RemoteInput.this.justPressedKeys[this.keyEvent.keyCode] = true;
/*     */           } 
/* 176 */           if (this.keyEvent.type == 1 && 
/* 177 */             RemoteInput.this.keys[this.keyEvent.keyCode]) {
/* 178 */             RemoteInput.this.keyCount--;
/* 179 */             RemoteInput.this.keys[this.keyEvent.keyCode] = false;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 189 */   public static int DEFAULT_PORT = 8190;
/*     */   private ServerSocket serverSocket;
/* 191 */   private float[] accel = new float[3];
/* 192 */   private float[] gyrate = new float[3];
/* 193 */   private float[] compass = new float[3];
/*     */   private boolean multiTouch = false;
/* 195 */   private float remoteWidth = 0.0F;
/* 196 */   private float remoteHeight = 0.0F;
/*     */   private boolean connected = false;
/*     */   private RemoteInputListener listener;
/* 199 */   int keyCount = 0;
/* 200 */   boolean[] keys = new boolean[256];
/*     */   boolean keyJustPressed = false;
/* 202 */   boolean[] justPressedKeys = new boolean[256];
/* 203 */   int[] deltaX = new int[20];
/* 204 */   int[] deltaY = new int[20];
/* 205 */   int[] touchX = new int[20];
/* 206 */   int[] touchY = new int[20];
/* 207 */   boolean[] isTouched = new boolean[20];
/*     */   boolean justTouched = false;
/* 209 */   InputProcessor processor = null;
/*     */   private final int port;
/*     */   public final String[] ips;
/*     */   
/*     */   public RemoteInput() {
/* 214 */     this(DEFAULT_PORT);
/*     */   }
/*     */   
/*     */   public RemoteInput(RemoteInputListener paramRemoteInputListener) {
/* 218 */     this(DEFAULT_PORT, paramRemoteInputListener);
/*     */   }
/*     */   
/*     */   public RemoteInput(int paramInt) {
/* 222 */     this(paramInt, null);
/*     */   }
/*     */   
/*     */   public RemoteInput(int paramInt, RemoteInputListener paramRemoteInputListener) {
/* 226 */     this.listener = paramRemoteInputListener;
/*     */     try {
/* 228 */       this.port = paramInt;
/* 229 */       this.serverSocket = new ServerSocket(paramInt);
/*     */       Thread thread;
/* 231 */       (thread = new Thread(this)).setDaemon(true);
/* 232 */       thread.start();
/* 233 */       InetAddress[] arrayOfInetAddress = InetAddress.getAllByName(InetAddress.getLocalHost().getHostName());
/* 234 */       this.ips = new String[arrayOfInetAddress.length];
/* 235 */       for (byte b = 0; b < arrayOfInetAddress.length; b++)
/* 236 */         this.ips[b] = arrayOfInetAddress[b].getHostAddress(); 
/*     */       return;
/* 238 */     } catch (Exception exception) {
/* 239 */       throw new GdxRuntimeException("Couldn't open listening socket at port '" + paramInt + "'", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void run() {
/*     */     while (true) {
/*     */       try {
/* 247 */         this.connected = false;
/* 248 */         if (this.listener != null) this.listener.onDisconnected();
/*     */         
/* 250 */         System.out.println("listening, port " + this.port);
/*     */         
/*     */         Socket socket;
/*     */         
/* 254 */         (socket = this.serverSocket.accept()).setTcpNoDelay(true);
/* 255 */         socket.setSoTimeout(3000);
/* 256 */         this.connected = true;
/* 257 */         if (this.listener != null) this.listener.onConnected();
/*     */         
/* 259 */         DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
/* 260 */         this.multiTouch = dataInputStream.readBoolean();
/*     */         while (true) {
/* 262 */           int i = dataInputStream.readInt();
/* 263 */           KeyEvent keyEvent = null;
/* 264 */           TouchEvent touchEvent = null;
/* 265 */           switch (i) {
/*     */             case 6:
/* 267 */               this.accel[0] = dataInputStream.readFloat();
/* 268 */               this.accel[1] = dataInputStream.readFloat();
/* 269 */               this.accel[2] = dataInputStream.readFloat();
/*     */               break;
/*     */             case 7:
/* 272 */               this.compass[0] = dataInputStream.readFloat();
/* 273 */               this.compass[1] = dataInputStream.readFloat();
/* 274 */               this.compass[2] = dataInputStream.readFloat();
/*     */               break;
/*     */             case 8:
/* 277 */               this.remoteWidth = dataInputStream.readFloat();
/* 278 */               this.remoteHeight = dataInputStream.readFloat();
/*     */               break;
/*     */             case 9:
/* 281 */               this.gyrate[0] = dataInputStream.readFloat();
/* 282 */               this.gyrate[1] = dataInputStream.readFloat();
/* 283 */               this.gyrate[2] = dataInputStream.readFloat();
/*     */               break;
/*     */             
/*     */             case 0:
/* 287 */               (keyEvent = new KeyEvent()).keyCode = dataInputStream.readInt();
/* 288 */               keyEvent.type = 0;
/*     */               break;
/*     */             
/*     */             case 1:
/* 292 */               (keyEvent = new KeyEvent()).keyCode = dataInputStream.readInt();
/* 293 */               keyEvent.type = 1;
/*     */               break;
/*     */             
/*     */             case 2:
/* 297 */               (keyEvent = new KeyEvent()).keyChar = dataInputStream.readChar();
/* 298 */               keyEvent.type = 2;
/*     */               break;
/*     */             
/*     */             case 3:
/* 302 */               (touchEvent = new TouchEvent()).x = (int)(dataInputStream.readInt() / this.remoteWidth * Gdx.graphics.getWidth());
/* 303 */               touchEvent.y = (int)(dataInputStream.readInt() / this.remoteHeight * Gdx.graphics.getHeight());
/* 304 */               touchEvent.pointer = dataInputStream.readInt();
/* 305 */               touchEvent.type = 0;
/*     */               break;
/*     */             
/*     */             case 4:
/* 309 */               (touchEvent = new TouchEvent()).x = (int)(dataInputStream.readInt() / this.remoteWidth * Gdx.graphics.getWidth());
/* 310 */               touchEvent.y = (int)(dataInputStream.readInt() / this.remoteHeight * Gdx.graphics.getHeight());
/* 311 */               touchEvent.pointer = dataInputStream.readInt();
/* 312 */               touchEvent.type = 1;
/*     */               break;
/*     */             
/*     */             case 5:
/* 316 */               (touchEvent = new TouchEvent()).x = (int)(dataInputStream.readInt() / this.remoteWidth * Gdx.graphics.getWidth());
/* 317 */               touchEvent.y = (int)(dataInputStream.readInt() / this.remoteHeight * Gdx.graphics.getHeight());
/* 318 */               touchEvent.pointer = dataInputStream.readInt();
/* 319 */               touchEvent.type = 2;
/*     */               break;
/*     */           } 
/*     */           
/* 323 */           Gdx.app.postRunnable(new EventTrigger(touchEvent, keyEvent));
/*     */         }  break;
/* 325 */       } catch (IOException iOException2) {
/* 326 */         IOException iOException1; (iOException1 = null).printStackTrace();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isConnected() {
/* 332 */     return this.connected;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getAccelerometerX() {
/* 337 */     return this.accel[0];
/*     */   }
/*     */ 
/*     */   
/*     */   public float getAccelerometerY() {
/* 342 */     return this.accel[1];
/*     */   }
/*     */ 
/*     */   
/*     */   public float getAccelerometerZ() {
/* 347 */     return this.accel[2];
/*     */   }
/*     */ 
/*     */   
/*     */   public float getGyroscopeX() {
/* 352 */     return this.gyrate[0];
/*     */   }
/*     */ 
/*     */   
/*     */   public float getGyroscopeY() {
/* 357 */     return this.gyrate[1];
/*     */   }
/*     */ 
/*     */   
/*     */   public float getGyroscopeZ() {
/* 362 */     return this.gyrate[2];
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMaxPointers() {
/* 367 */     return 20;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getX() {
/* 372 */     return this.touchX[0];
/*     */   }
/*     */ 
/*     */   
/*     */   public int getX(int paramInt) {
/* 377 */     return this.touchX[paramInt];
/*     */   }
/*     */ 
/*     */   
/*     */   public int getY() {
/* 382 */     return this.touchY[0];
/*     */   }
/*     */ 
/*     */   
/*     */   public int getY(int paramInt) {
/* 387 */     return this.touchY[paramInt];
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTouched() {
/* 392 */     return this.isTouched[0];
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean justTouched() {
/* 397 */     return this.justTouched;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTouched(int paramInt) {
/* 402 */     return this.isTouched[paramInt];
/*     */   }
/*     */ 
/*     */   
/*     */   public float getPressure() {
/* 407 */     return getPressure(0);
/*     */   }
/*     */ 
/*     */   
/*     */   public float getPressure(int paramInt) {
/* 412 */     return isTouched(paramInt) ? 1.0F : 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isButtonPressed(int paramInt) {
/* 417 */     if (paramInt != 0) return false; 
/* 418 */     for (paramInt = 0; paramInt < this.isTouched.length; paramInt++) {
/* 419 */       if (this.isTouched[paramInt]) return true; 
/* 420 */     }  return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isButtonJustPressed(int paramInt) {
/* 425 */     return (paramInt == 0 && this.justTouched);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isKeyPressed(int paramInt) {
/* 430 */     if (paramInt == -1) {
/* 431 */       return (this.keyCount > 0);
/*     */     }
/* 433 */     if (paramInt < 0 || paramInt > 255) {
/* 434 */       return false;
/*     */     }
/* 436 */     return this.keys[paramInt];
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isKeyJustPressed(int paramInt) {
/* 441 */     if (paramInt == -1) {
/* 442 */       return this.keyJustPressed;
/*     */     }
/* 444 */     if (paramInt < 0 || paramInt > 255) {
/* 445 */       return false;
/*     */     }
/* 447 */     return this.justPressedKeys[paramInt];
/*     */   }
/*     */ 
/*     */   
/*     */   public void getTextInput(Input.TextInputListener paramTextInputListener, String paramString1, String paramString2, String paramString3) {
/* 452 */     Gdx.app.getInput().getTextInput(paramTextInputListener, paramString1, paramString2, paramString3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void getTextInput(Input.TextInputListener paramTextInputListener, String paramString1, String paramString2, String paramString3, Input.OnscreenKeyboardType paramOnscreenKeyboardType) {
/* 457 */     Gdx.app.getInput().getTextInput(paramTextInputListener, paramString1, paramString2, paramString3, paramOnscreenKeyboardType);
/*     */   }
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
/*     */   public void openTextInputField(NativeInputConfiguration paramNativeInputConfiguration) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void closeTextInputField(boolean paramBoolean) {}
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
/* 501 */     return this.compass[0];
/*     */   }
/*     */ 
/*     */   
/*     */   public float getPitch() {
/* 506 */     return this.compass[1];
/*     */   }
/*     */ 
/*     */   
/*     */   public float getRoll() {
/* 511 */     return this.compass[2];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCatchBackKey(boolean paramBoolean) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCatchBackKey() {
/* 521 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCatchMenuKey(boolean paramBoolean) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCatchMenuKey() {
/* 531 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCatchKey(int paramInt, boolean paramBoolean) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCatchKey(int paramInt) {
/* 541 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setInputProcessor(InputProcessor paramInputProcessor) {
/* 546 */     this.processor = paramInputProcessor;
/*     */   }
/*     */ 
/*     */   
/*     */   public InputProcessor getInputProcessor() {
/* 551 */     return this.processor;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] getIPs() {
/* 557 */     return this.ips;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPeripheralAvailable(Input.Peripheral paramPeripheral) {
/* 562 */     if (paramPeripheral == Input.Peripheral.Accelerometer) return true; 
/* 563 */     if (paramPeripheral == Input.Peripheral.Compass) return true; 
/* 564 */     if (paramPeripheral == Input.Peripheral.MultitouchScreen) return this.multiTouch; 
/* 565 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRotation() {
/* 570 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public Input.Orientation getNativeOrientation() {
/* 575 */     return Input.Orientation.Landscape;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCursorCatched(boolean paramBoolean) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCursorCatched() {
/* 585 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDeltaX() {
/* 590 */     return this.deltaX[0];
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDeltaX(int paramInt) {
/* 595 */     return this.deltaX[paramInt];
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDeltaY() {
/* 600 */     return this.deltaY[0];
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDeltaY(int paramInt) {
/* 605 */     return this.deltaY[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCursorPosition(int paramInt1, int paramInt2) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public long getCurrentEventTime() {
/* 615 */     return 0L;
/*     */   }
/*     */   
/*     */   public void getRotationMatrix(float[] paramArrayOffloat) {}
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\input\RemoteInput.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */