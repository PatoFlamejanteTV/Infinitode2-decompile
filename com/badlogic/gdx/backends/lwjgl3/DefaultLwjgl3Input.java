/*     */ package com.badlogic.gdx.backends.lwjgl3;
/*     */ 
/*     */ import com.badlogic.gdx.AbstractInput;
/*     */ import com.badlogic.gdx.Input;
/*     */ import com.badlogic.gdx.InputEventQueue;
/*     */ import com.badlogic.gdx.InputProcessor;
/*     */ import com.badlogic.gdx.graphics.glutils.HdpiMode;
/*     */ import com.badlogic.gdx.input.NativeInputConfiguration;
/*     */ import org.lwjgl.glfw.GLFW;
/*     */ import org.lwjgl.glfw.GLFWCharCallback;
/*     */ import org.lwjgl.glfw.GLFWCharCallbackI;
/*     */ import org.lwjgl.glfw.GLFWCursorPosCallback;
/*     */ import org.lwjgl.glfw.GLFWCursorPosCallbackI;
/*     */ import org.lwjgl.glfw.GLFWKeyCallback;
/*     */ import org.lwjgl.glfw.GLFWKeyCallbackI;
/*     */ import org.lwjgl.glfw.GLFWMouseButtonCallback;
/*     */ import org.lwjgl.glfw.GLFWMouseButtonCallbackI;
/*     */ import org.lwjgl.glfw.GLFWScrollCallback;
/*     */ import org.lwjgl.glfw.GLFWScrollCallbackI;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DefaultLwjgl3Input
/*     */   extends AbstractInput
/*     */   implements Lwjgl3Input
/*     */ {
/*     */   final Lwjgl3Window window;
/*     */   private InputProcessor inputProcessor;
/*  36 */   final InputEventQueue eventQueue = new InputEventQueue(); int mouseX;
/*     */   int mouseY;
/*     */   int mousePressed;
/*     */   int deltaX;
/*     */   int deltaY;
/*     */   boolean justTouched;
/*  42 */   final boolean[] justPressedButtons = new boolean[5];
/*     */   char lastCharacter;
/*     */   
/*  45 */   private GLFWKeyCallback keyCallback = new GLFWKeyCallback()
/*     */     {
/*     */       public void invoke(long param1Long, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/*  48 */         DefaultLwjgl3Input.this.keyCallback(param1Long, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */       }
/*     */     };
/*     */   
/*  52 */   GLFWCharCallback charCallback = new GLFWCharCallback()
/*     */     {
/*     */       public void invoke(long param1Long, int param1Int) {
/*  55 */         if ((param1Int & 0xFF00) == 63232)
/*  56 */           return;  DefaultLwjgl3Input.this.lastCharacter = (char)param1Int;
/*  57 */         DefaultLwjgl3Input.this.window.getGraphics().requestRendering();
/*  58 */         DefaultLwjgl3Input.this.eventQueue.keyTyped((char)param1Int, System.nanoTime());
/*     */       }
/*     */     };
/*     */   
/*  62 */   private GLFWScrollCallback scrollCallback = new GLFWScrollCallback()
/*     */     {
/*     */       public void invoke(long param1Long, double param1Double1, double param1Double2) {
/*  65 */         DefaultLwjgl3Input.this.window.getGraphics().requestRendering();
/*  66 */         DefaultLwjgl3Input.this.eventQueue.scrolled(-((float)param1Double1), -((float)param1Double2), System.nanoTime());
/*     */       }
/*     */     };
/*     */   
/*  70 */   private GLFWCursorPosCallback cursorPosCallback = new GLFWCursorPosCallback()
/*     */     {
/*     */       private int logicalMouseY;
/*     */       private int logicalMouseX;
/*     */       
/*     */       public void invoke(long param1Long, double param1Double1, double param1Double2) {
/*  76 */         DefaultLwjgl3Input.this.deltaX = (int)param1Double1 - this.logicalMouseX;
/*  77 */         DefaultLwjgl3Input.this.deltaY = (int)param1Double2 - this.logicalMouseY;
/*  78 */         DefaultLwjgl3Input.this.mouseX = this.logicalMouseX = (int)param1Double1;
/*  79 */         DefaultLwjgl3Input.this.mouseY = this.logicalMouseY = (int)param1Double2;
/*     */         
/*  81 */         if ((DefaultLwjgl3Input.this.window.getConfig()).hdpiMode == HdpiMode.Pixels) {
/*  82 */           float f1 = DefaultLwjgl3Input.this.window.getGraphics().getBackBufferWidth() / DefaultLwjgl3Input.this.window.getGraphics().getLogicalWidth();
/*  83 */           float f2 = DefaultLwjgl3Input.this.window.getGraphics().getBackBufferHeight() / DefaultLwjgl3Input.this.window.getGraphics().getLogicalHeight();
/*  84 */           DefaultLwjgl3Input.this.deltaX = (int)(DefaultLwjgl3Input.this.deltaX * f1);
/*  85 */           DefaultLwjgl3Input.this.deltaY = (int)(DefaultLwjgl3Input.this.deltaY * f2);
/*  86 */           DefaultLwjgl3Input.this.mouseX = (int)(DefaultLwjgl3Input.this.mouseX * f1);
/*  87 */           DefaultLwjgl3Input.this.mouseY = (int)(DefaultLwjgl3Input.this.mouseY * f2);
/*     */         } 
/*     */         
/*  90 */         DefaultLwjgl3Input.this.window.getGraphics().requestRendering();
/*  91 */         long l = System.nanoTime();
/*  92 */         if (DefaultLwjgl3Input.this.mousePressed > 0) {
/*  93 */           DefaultLwjgl3Input.this.eventQueue.touchDragged(DefaultLwjgl3Input.this.mouseX, DefaultLwjgl3Input.this.mouseY, 0, l); return;
/*     */         } 
/*  95 */         DefaultLwjgl3Input.this.eventQueue.mouseMoved(DefaultLwjgl3Input.this.mouseX, DefaultLwjgl3Input.this.mouseY, l);
/*     */       }
/*     */     };
/*     */ 
/*     */   
/* 100 */   private GLFWMouseButtonCallback mouseButtonCallback = new GLFWMouseButtonCallback()
/*     */     {
/*     */       public void invoke(long param1Long, int param1Int1, int param1Int2, int param1Int3) {
/* 103 */         int i = toGdxButton(param1Int1);
/* 104 */         if (param1Int1 != -1 && i == -1)
/*     */           return; 
/* 106 */         long l = System.nanoTime();
/* 107 */         if (param1Int2 == 1) {
/* 108 */           DefaultLwjgl3Input.this.mousePressed++;
/* 109 */           DefaultLwjgl3Input.this.justTouched = true;
/* 110 */           DefaultLwjgl3Input.this.justPressedButtons[i] = true;
/* 111 */           DefaultLwjgl3Input.this.window.getGraphics().requestRendering();
/* 112 */           DefaultLwjgl3Input.this.eventQueue.touchDown(DefaultLwjgl3Input.this.mouseX, DefaultLwjgl3Input.this.mouseY, 0, i, l); return;
/*     */         } 
/* 114 */         DefaultLwjgl3Input.this.mousePressed = Math.max(0, DefaultLwjgl3Input.this.mousePressed - 1);
/* 115 */         DefaultLwjgl3Input.this.window.getGraphics().requestRendering();
/* 116 */         DefaultLwjgl3Input.this.eventQueue.touchUp(DefaultLwjgl3Input.this.mouseX, DefaultLwjgl3Input.this.mouseY, 0, i, l);
/*     */       }
/*     */ 
/*     */       
/*     */       private int toGdxButton(int param1Int) {
/* 121 */         if (param1Int == 0) return 0; 
/* 122 */         if (param1Int == 1) return 1; 
/* 123 */         if (param1Int == 2) return 2; 
/* 124 */         if (param1Int == 3) return 3; 
/* 125 */         if (param1Int == 4) return 4; 
/* 126 */         return -1;
/*     */       }
/*     */     };
/*     */   
/*     */   public DefaultLwjgl3Input(Lwjgl3Window paramLwjgl3Window) {
/* 131 */     this.window = paramLwjgl3Window;
/* 132 */     windowHandleChanged(paramLwjgl3Window.getWindowHandle());
/*     */   }
/*     */   
/*     */   void keyCallback(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 136 */     switch (paramInt3) {
/*     */       case 1:
/* 138 */         paramInt1 = getGdxKeyCode(paramInt1);
/* 139 */         this.eventQueue.keyDown(paramInt1, System.nanoTime());
/* 140 */         this.pressedKeyCount++;
/* 141 */         this.keyJustPressed = true;
/* 142 */         this.pressedKeys[paramInt1] = true;
/* 143 */         this.justPressedKeys[paramInt1] = true;
/* 144 */         this.window.getGraphics().requestRendering();
/* 145 */         this.lastCharacter = Character.MIN_VALUE;
/*     */         
/* 147 */         if ((paramInt1 = characterForKeyCode(paramInt1)) != 0) { this.charCallback.invoke(paramLong, paramInt1); return; }
/*     */          break;
/*     */       case 0:
/* 150 */         paramInt1 = getGdxKeyCode(paramInt1);
/* 151 */         this.pressedKeyCount--;
/* 152 */         this.pressedKeys[paramInt1] = false;
/* 153 */         this.window.getGraphics().requestRendering();
/* 154 */         this.eventQueue.keyUp(paramInt1, System.nanoTime());
/*     */         return;
/*     */       case 2:
/* 157 */         if (this.lastCharacter != '\000') {
/* 158 */           this.window.getGraphics().requestRendering();
/* 159 */           this.eventQueue.keyTyped(this.lastCharacter, System.nanoTime());
/*     */         } 
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void resetPollingStates() {
/* 167 */     this.justTouched = false;
/* 168 */     this.keyJustPressed = false; byte b;
/* 169 */     for (b = 0; b < this.justPressedKeys.length; b++) {
/* 170 */       this.justPressedKeys[b] = false;
/*     */     }
/* 172 */     for (b = 0; b < this.justPressedButtons.length; b++) {
/* 173 */       this.justPressedButtons[b] = false;
/*     */     }
/* 175 */     this.eventQueue.drain(null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void windowHandleChanged(long paramLong) {
/* 180 */     resetPollingStates();
/* 181 */     GLFW.glfwSetKeyCallback(this.window.getWindowHandle(), (GLFWKeyCallbackI)this.keyCallback);
/* 182 */     GLFW.glfwSetCharCallback(this.window.getWindowHandle(), (GLFWCharCallbackI)this.charCallback);
/* 183 */     GLFW.glfwSetScrollCallback(this.window.getWindowHandle(), (GLFWScrollCallbackI)this.scrollCallback);
/* 184 */     GLFW.glfwSetCursorPosCallback(this.window.getWindowHandle(), (GLFWCursorPosCallbackI)this.cursorPosCallback);
/* 185 */     GLFW.glfwSetMouseButtonCallback(this.window.getWindowHandle(), (GLFWMouseButtonCallbackI)this.mouseButtonCallback);
/*     */   }
/*     */ 
/*     */   
/*     */   public void update() {
/* 190 */     this.eventQueue.drain(this.inputProcessor);
/*     */   }
/*     */ 
/*     */   
/*     */   public void prepareNext() {
/* 195 */     if (this.justTouched) {
/* 196 */       this.justTouched = false;
/* 197 */       for (byte b = 0; b < this.justPressedButtons.length; b++) {
/* 198 */         this.justPressedButtons[b] = false;
/*     */       }
/*     */     } 
/*     */     
/* 202 */     if (this.keyJustPressed) {
/* 203 */       this.keyJustPressed = false;
/* 204 */       for (byte b = 0; b < this.justPressedKeys.length; b++) {
/* 205 */         this.justPressedKeys[b] = false;
/*     */       }
/*     */     } 
/* 208 */     this.deltaX = 0;
/* 209 */     this.deltaY = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMaxPointers() {
/* 214 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getX() {
/* 219 */     return this.mouseX;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getX(int paramInt) {
/* 224 */     return (paramInt == 0) ? this.mouseX : 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDeltaX() {
/* 229 */     return this.deltaX;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDeltaX(int paramInt) {
/* 234 */     return (paramInt == 0) ? this.deltaX : 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getY() {
/* 239 */     return this.mouseY;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getY(int paramInt) {
/* 244 */     return (paramInt == 0) ? this.mouseY : 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDeltaY() {
/* 249 */     return this.deltaY;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDeltaY(int paramInt) {
/* 254 */     return (paramInt == 0) ? this.deltaY : 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTouched() {
/* 259 */     if (GLFW.glfwGetMouseButton(this.window.getWindowHandle(), 0) == 1 || 
/* 260 */       GLFW.glfwGetMouseButton(this.window.getWindowHandle(), 1) == 1 || 
/* 261 */       GLFW.glfwGetMouseButton(this.window.getWindowHandle(), 2) == 1 || 
/* 262 */       GLFW.glfwGetMouseButton(this.window.getWindowHandle(), 3) == 1 || 
/* 263 */       GLFW.glfwGetMouseButton(this.window.getWindowHandle(), 4) == 1) return true; 
/*     */     return false;
/*     */   }
/*     */   
/*     */   public boolean justTouched() {
/* 268 */     return this.justTouched;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTouched(int paramInt) {
/* 273 */     return (paramInt == 0) ? isTouched() : false;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getPressure() {
/* 278 */     return getPressure(0);
/*     */   }
/*     */ 
/*     */   
/*     */   public float getPressure(int paramInt) {
/* 283 */     return isTouched(paramInt) ? 1.0F : 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isButtonPressed(int paramInt) {
/* 288 */     return (GLFW.glfwGetMouseButton(this.window.getWindowHandle(), paramInt) == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isButtonJustPressed(int paramInt) {
/* 293 */     if (paramInt < 0 || paramInt >= this.justPressedButtons.length) {
/* 294 */       return false;
/*     */     }
/* 296 */     return this.justPressedButtons[paramInt];
/*     */   }
/*     */ 
/*     */   
/*     */   public void getTextInput(Input.TextInputListener paramTextInputListener, String paramString1, String paramString2, String paramString3) {
/* 301 */     getTextInput(paramTextInputListener, paramString1, paramString2, paramString3, Input.OnscreenKeyboardType.Default);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void getTextInput(Input.TextInputListener paramTextInputListener, String paramString1, String paramString2, String paramString3, Input.OnscreenKeyboardType paramOnscreenKeyboardType) {
/* 307 */     paramTextInputListener.canceled();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long getCurrentEventTime() {
/* 313 */     return this.eventQueue.getCurrentEventTime();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setInputProcessor(InputProcessor paramInputProcessor) {
/* 318 */     this.inputProcessor = paramInputProcessor;
/*     */   }
/*     */ 
/*     */   
/*     */   public InputProcessor getInputProcessor() {
/* 323 */     return this.inputProcessor;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCursorCatched(boolean paramBoolean) {
/* 328 */     GLFW.glfwSetInputMode(this.window.getWindowHandle(), 208897, 
/* 329 */         paramBoolean ? 212995 : 212993);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCursorCatched() {
/* 334 */     return (GLFW.glfwGetInputMode(this.window.getWindowHandle(), 208897) == 212995);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCursorPosition(int paramInt1, int paramInt2) {
/* 339 */     if ((this.window.getConfig()).hdpiMode == HdpiMode.Pixels) {
/* 340 */       float f1 = this.window.getGraphics().getLogicalWidth() / this.window.getGraphics().getBackBufferWidth();
/* 341 */       float f2 = this.window.getGraphics().getLogicalHeight() / this.window.getGraphics().getBackBufferHeight();
/* 342 */       paramInt1 = (int)(paramInt1 * f1);
/* 343 */       paramInt2 = (int)(paramInt2 * f2);
/*     */     } 
/* 345 */     GLFW.glfwSetCursorPos(this.window.getWindowHandle(), paramInt1, paramInt2);
/* 346 */     this.cursorPosCallback.invoke(this.window.getWindowHandle(), paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   protected char characterForKeyCode(int paramInt) {
/* 351 */     switch (paramInt) {
/*     */       case 67:
/* 353 */         return '\b';
/*     */       case 61:
/* 355 */         return '\t';
/*     */       case 112:
/* 357 */         return '';
/*     */       case 66:
/*     */       case 160:
/* 360 */         return '\n';
/*     */     } 
/* 362 */     return Character.MIN_VALUE;
/*     */   }
/*     */   
/*     */   public int getGdxKeyCode(int paramInt) {
/* 366 */     switch (paramInt) {
/*     */       case 32:
/* 368 */         return 62;
/*     */       case 39:
/* 370 */         return 75;
/*     */       case 44:
/* 372 */         return 55;
/*     */       case 45:
/* 374 */         return 69;
/*     */       case 46:
/* 376 */         return 56;
/*     */       case 47:
/* 378 */         return 76;
/*     */       case 48:
/* 380 */         return 7;
/*     */       case 49:
/* 382 */         return 8;
/*     */       case 50:
/* 384 */         return 9;
/*     */       case 51:
/* 386 */         return 10;
/*     */       case 52:
/* 388 */         return 11;
/*     */       case 53:
/* 390 */         return 12;
/*     */       case 54:
/* 392 */         return 13;
/*     */       case 55:
/* 394 */         return 14;
/*     */       case 56:
/* 396 */         return 15;
/*     */       case 57:
/* 398 */         return 16;
/*     */       case 59:
/* 400 */         return 74;
/*     */       case 61:
/* 402 */         return 70;
/*     */       case 65:
/* 404 */         return 29;
/*     */       case 66:
/* 406 */         return 30;
/*     */       case 67:
/* 408 */         return 31;
/*     */       case 68:
/* 410 */         return 32;
/*     */       case 69:
/* 412 */         return 33;
/*     */       case 70:
/* 414 */         return 34;
/*     */       case 71:
/* 416 */         return 35;
/*     */       case 72:
/* 418 */         return 36;
/*     */       case 73:
/* 420 */         return 37;
/*     */       case 74:
/* 422 */         return 38;
/*     */       case 75:
/* 424 */         return 39;
/*     */       case 76:
/* 426 */         return 40;
/*     */       case 77:
/* 428 */         return 41;
/*     */       case 78:
/* 430 */         return 42;
/*     */       case 79:
/* 432 */         return 43;
/*     */       case 80:
/* 434 */         return 44;
/*     */       case 81:
/* 436 */         return 45;
/*     */       case 82:
/* 438 */         return 46;
/*     */       case 83:
/* 440 */         return 47;
/*     */       case 84:
/* 442 */         return 48;
/*     */       case 85:
/* 444 */         return 49;
/*     */       case 86:
/* 446 */         return 50;
/*     */       case 87:
/* 448 */         return 51;
/*     */       case 88:
/* 450 */         return 52;
/*     */       case 89:
/* 452 */         return 53;
/*     */       case 90:
/* 454 */         return 54;
/*     */       case 91:
/* 456 */         return 71;
/*     */       case 92:
/* 458 */         return 73;
/*     */       case 93:
/* 460 */         return 72;
/*     */       case 96:
/* 462 */         return 68;
/*     */       case 161:
/*     */       case 162:
/* 465 */         return 0;
/*     */       case 256:
/* 467 */         return 111;
/*     */       case 257:
/* 469 */         return 66;
/*     */       case 258:
/* 471 */         return 61;
/*     */       case 259:
/* 473 */         return 67;
/*     */       case 260:
/* 475 */         return 124;
/*     */       case 261:
/* 477 */         return 112;
/*     */       case 262:
/* 479 */         return 22;
/*     */       case 263:
/* 481 */         return 21;
/*     */       case 264:
/* 483 */         return 20;
/*     */       case 265:
/* 485 */         return 19;
/*     */       case 266:
/* 487 */         return 92;
/*     */       case 267:
/* 489 */         return 93;
/*     */       case 268:
/* 491 */         return 3;
/*     */       case 269:
/* 493 */         return 123;
/*     */       case 280:
/* 495 */         return 115;
/*     */       case 281:
/* 497 */         return 116;
/*     */       case 283:
/* 499 */         return 120;
/*     */       case 284:
/* 501 */         return 121;
/*     */       case 290:
/* 503 */         return 131;
/*     */       case 291:
/* 505 */         return 132;
/*     */       case 292:
/* 507 */         return 133;
/*     */       case 293:
/* 509 */         return 134;
/*     */       case 294:
/* 511 */         return 135;
/*     */       case 295:
/* 513 */         return 136;
/*     */       case 296:
/* 515 */         return 137;
/*     */       case 297:
/* 517 */         return 138;
/*     */       case 298:
/* 519 */         return 139;
/*     */       case 299:
/* 521 */         return 140;
/*     */       case 300:
/* 523 */         return 141;
/*     */       case 301:
/* 525 */         return 142;
/*     */       case 302:
/* 527 */         return 183;
/*     */       case 303:
/* 529 */         return 184;
/*     */       case 304:
/* 531 */         return 185;
/*     */       case 305:
/* 533 */         return 186;
/*     */       case 306:
/* 535 */         return 187;
/*     */       case 307:
/* 537 */         return 188;
/*     */       case 308:
/* 539 */         return 189;
/*     */       case 309:
/* 541 */         return 190;
/*     */       case 310:
/* 543 */         return 191;
/*     */       case 311:
/* 545 */         return 192;
/*     */       case 312:
/* 547 */         return 193;
/*     */       case 313:
/* 549 */         return 194;
/*     */       case 314:
/* 551 */         return 0;
/*     */       case 282:
/* 553 */         return 143;
/*     */       case 320:
/* 555 */         return 144;
/*     */       case 321:
/* 557 */         return 145;
/*     */       case 322:
/* 559 */         return 146;
/*     */       case 323:
/* 561 */         return 147;
/*     */       case 324:
/* 563 */         return 148;
/*     */       case 325:
/* 565 */         return 149;
/*     */       case 326:
/* 567 */         return 150;
/*     */       case 327:
/* 569 */         return 151;
/*     */       case 328:
/* 571 */         return 152;
/*     */       case 329:
/* 573 */         return 153;
/*     */       case 330:
/* 575 */         return 158;
/*     */       case 331:
/* 577 */         return 154;
/*     */       case 332:
/* 579 */         return 155;
/*     */       case 333:
/* 581 */         return 156;
/*     */       case 334:
/* 583 */         return 157;
/*     */       case 335:
/* 585 */         return 160;
/*     */       case 336:
/* 587 */         return 161;
/*     */       case 340:
/* 589 */         return 59;
/*     */       case 341:
/* 591 */         return 129;
/*     */       case 342:
/* 593 */         return 57;
/*     */       case 343:
/* 595 */         return 63;
/*     */       case 344:
/* 597 */         return 60;
/*     */       case 345:
/* 599 */         return 130;
/*     */       case 346:
/* 601 */         return 58;
/*     */       case 347:
/* 603 */         return 63;
/*     */       case 348:
/* 605 */         return 82;
/*     */     } 
/* 607 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 613 */     this.keyCallback.free();
/* 614 */     this.charCallback.free();
/* 615 */     this.scrollCallback.free();
/* 616 */     this.cursorPosCallback.free();
/* 617 */     this.mouseButtonCallback.free();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getAccelerometerX() {
/* 626 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getAccelerometerY() {
/* 631 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getAccelerometerZ() {
/* 636 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPeripheralAvailable(Input.Peripheral paramPeripheral) {
/* 641 */     return (paramPeripheral == Input.Peripheral.HardwareKeyboard);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRotation() {
/* 646 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public Input.Orientation getNativeOrientation() {
/* 651 */     return Input.Orientation.Landscape;
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
/* 695 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getPitch() {
/* 700 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getRoll() {
/* 705 */     return 0.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void getRotationMatrix(float[] paramArrayOffloat) {}
/*     */ 
/*     */   
/*     */   public float getGyroscopeX() {
/* 714 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getGyroscopeY() {
/* 719 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getGyroscopeZ() {
/* 724 */     return 0.0F;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\lwjgl3\DefaultLwjgl3Input.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */