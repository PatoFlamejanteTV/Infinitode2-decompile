/*     */ package com.badlogic.gdx;
/*     */ 
/*     */ import com.badlogic.gdx.input.NativeInputConfiguration;
/*     */ import com.badlogic.gdx.utils.ObjectIntMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface Input
/*     */ {
/*     */   float getAccelerometerX();
/*     */   
/*     */   float getAccelerometerY();
/*     */   
/*     */   float getAccelerometerZ();
/*     */   
/*     */   float getGyroscopeX();
/*     */   
/*     */   float getGyroscopeY();
/*     */   
/*     */   float getGyroscopeZ();
/*     */   
/*     */   int getMaxPointers();
/*     */   
/*     */   int getX();
/*     */   
/*     */   int getX(int paramInt);
/*     */   
/*     */   int getDeltaX();
/*     */   
/*     */   int getDeltaX(int paramInt);
/*     */   
/*     */   int getY();
/*     */   
/*     */   int getY(int paramInt);
/*     */   
/*     */   int getDeltaY();
/*     */   
/*     */   int getDeltaY(int paramInt);
/*     */   
/*     */   boolean isTouched();
/*     */   
/*     */   boolean justTouched();
/*     */   
/*     */   boolean isTouched(int paramInt);
/*     */   
/*     */   float getPressure();
/*     */   
/*     */   float getPressure(int paramInt);
/*     */   
/*     */   boolean isButtonPressed(int paramInt);
/*     */   
/*     */   boolean isButtonJustPressed(int paramInt);
/*     */   
/*     */   boolean isKeyPressed(int paramInt);
/*     */   
/*     */   boolean isKeyJustPressed(int paramInt);
/*     */   
/*     */   void getTextInput(TextInputListener paramTextInputListener, String paramString1, String paramString2, String paramString3);
/*     */   
/*     */   void getTextInput(TextInputListener paramTextInputListener, String paramString1, String paramString2, String paramString3, OnscreenKeyboardType paramOnscreenKeyboardType);
/*     */   
/*     */   void setOnscreenKeyboardVisible(boolean paramBoolean);
/*     */   
/*     */   void setOnscreenKeyboardVisible(boolean paramBoolean, OnscreenKeyboardType paramOnscreenKeyboardType);
/*     */   
/*     */   void openTextInputField(NativeInputConfiguration paramNativeInputConfiguration);
/*     */   
/*     */   void closeTextInputField(boolean paramBoolean);
/*     */   
/*     */   void setKeyboardHeightObserver(KeyboardHeightObserver paramKeyboardHeightObserver);
/*     */   
/*     */   void vibrate(int paramInt);
/*     */   
/*     */   void vibrate(int paramInt, boolean paramBoolean);
/*     */   
/*     */   void vibrate(int paramInt1, int paramInt2, boolean paramBoolean);
/*     */   
/*     */   void vibrate(VibrationType paramVibrationType);
/*     */   
/*     */   float getAzimuth();
/*     */   
/*     */   float getPitch();
/*     */   
/*     */   float getRoll();
/*     */   
/*     */   void getRotationMatrix(float[] paramArrayOffloat);
/*     */   
/*     */   long getCurrentEventTime();
/*     */   
/*     */   @Deprecated
/*     */   void setCatchBackKey(boolean paramBoolean);
/*     */   
/*     */   @Deprecated
/*     */   boolean isCatchBackKey();
/*     */   
/*     */   @Deprecated
/*     */   void setCatchMenuKey(boolean paramBoolean);
/*     */   
/*     */   @Deprecated
/*     */   boolean isCatchMenuKey();
/*     */   
/*     */   void setCatchKey(int paramInt, boolean paramBoolean);
/*     */   
/*     */   boolean isCatchKey(int paramInt);
/*     */   
/*     */   void setInputProcessor(InputProcessor paramInputProcessor);
/*     */   
/*     */   InputProcessor getInputProcessor();
/*     */   
/*     */   boolean isPeripheralAvailable(Peripheral paramPeripheral);
/*     */   
/*     */   int getRotation();
/*     */   
/*     */   Orientation getNativeOrientation();
/*     */   
/*     */   void setCursorCatched(boolean paramBoolean);
/*     */   
/*     */   boolean isCursorCatched();
/*     */   
/*     */   void setCursorPosition(int paramInt1, int paramInt2);
/*     */   
/*     */   public static interface TextInputListener
/*     */   {
/*     */     void input(String param1String);
/*     */     
/*     */     void canceled();
/*     */   }
/*     */   
/*     */   public static class Buttons
/*     */   {
/*     */     public static final int LEFT = 0;
/*     */     public static final int RIGHT = 1;
/*     */     public static final int MIDDLE = 2;
/*     */     public static final int BACK = 3;
/*     */     public static final int FORWARD = 4;
/*     */   }
/*     */   
/*     */   public static class Keys
/*     */   {
/*     */     public static final int ANY_KEY = -1;
/*     */     public static final int NUM_0 = 7;
/*     */     public static final int NUM_1 = 8;
/*     */     public static final int NUM_2 = 9;
/*     */     public static final int NUM_3 = 10;
/*     */     public static final int NUM_4 = 11;
/*     */     public static final int NUM_5 = 12;
/*     */     public static final int NUM_6 = 13;
/*     */     public static final int NUM_7 = 14;
/*     */     public static final int NUM_8 = 15;
/*     */     public static final int NUM_9 = 16;
/*     */     public static final int A = 29;
/*     */     public static final int ALT_LEFT = 57;
/*     */     public static final int ALT_RIGHT = 58;
/*     */     public static final int APOSTROPHE = 75;
/*     */     public static final int AT = 77;
/*     */     public static final int B = 30;
/*     */     public static final int BACK = 4;
/*     */     public static final int BACKSLASH = 73;
/*     */     public static final int C = 31;
/*     */     public static final int CALL = 5;
/*     */     public static final int CAMERA = 27;
/*     */     public static final int CAPS_LOCK = 115;
/*     */     public static final int CLEAR = 28;
/*     */     public static final int COMMA = 55;
/*     */     public static final int D = 32;
/*     */     public static final int DEL = 67;
/*     */     public static final int BACKSPACE = 67;
/*     */     public static final int FORWARD_DEL = 112;
/*     */     public static final int DPAD_CENTER = 23;
/*     */     public static final int DPAD_DOWN = 20;
/*     */     public static final int DPAD_LEFT = 21;
/*     */     public static final int DPAD_RIGHT = 22;
/*     */     public static final int DPAD_UP = 19;
/*     */     public static final int CENTER = 23;
/*     */     public static final int DOWN = 20;
/*     */     public static final int LEFT = 21;
/*     */     public static final int RIGHT = 22;
/*     */     public static final int UP = 19;
/*     */     public static final int E = 33;
/*     */     public static final int ENDCALL = 6;
/*     */     public static final int ENTER = 66;
/*     */     public static final int ENVELOPE = 65;
/*     */     public static final int EQUALS = 70;
/*     */     public static final int EXPLORER = 64;
/*     */     public static final int F = 34;
/*     */     public static final int FOCUS = 80;
/*     */     public static final int G = 35;
/*     */     public static final int GRAVE = 68;
/*     */     public static final int H = 36;
/*     */     public static final int HEADSETHOOK = 79;
/*     */     public static final int HOME = 3;
/*     */     public static final int I = 37;
/*     */     public static final int J = 38;
/*     */     public static final int K = 39;
/*     */     public static final int L = 40;
/*     */     public static final int LEFT_BRACKET = 71;
/*     */     public static final int M = 41;
/*     */     public static final int MEDIA_FAST_FORWARD = 90;
/*     */     public static final int MEDIA_NEXT = 87;
/*     */     public static final int MEDIA_PLAY_PAUSE = 85;
/*     */     public static final int MEDIA_PREVIOUS = 88;
/*     */     public static final int MEDIA_REWIND = 89;
/*     */     public static final int MEDIA_STOP = 86;
/*     */     public static final int MENU = 82;
/*     */     public static final int MINUS = 69;
/*     */     public static final int MUTE = 91;
/*     */     public static final int N = 42;
/*     */     public static final int NOTIFICATION = 83;
/*     */     public static final int NUM = 78;
/*     */     public static final int O = 43;
/*     */     public static final int P = 44;
/*     */     public static final int PAUSE = 121;
/*     */     public static final int PERIOD = 56;
/*     */     public static final int PLUS = 81;
/*     */     public static final int POUND = 18;
/*     */     public static final int POWER = 26;
/*     */     public static final int PRINT_SCREEN = 120;
/*     */     public static final int Q = 45;
/*     */     public static final int R = 46;
/*     */     public static final int RIGHT_BRACKET = 72;
/*     */     public static final int S = 47;
/*     */     public static final int SCROLL_LOCK = 116;
/*     */     public static final int SEARCH = 84;
/*     */     public static final int SEMICOLON = 74;
/*     */     public static final int SHIFT_LEFT = 59;
/*     */     public static final int SHIFT_RIGHT = 60;
/*     */     public static final int SLASH = 76;
/*     */     public static final int SOFT_LEFT = 1;
/*     */     public static final int SOFT_RIGHT = 2;
/*     */     public static final int SPACE = 62;
/*     */     public static final int STAR = 17;
/*     */     
/*     */     public static String toString(int param1Int) {
/* 279 */       if (param1Int < 0) throw new IllegalArgumentException("keycode cannot be negative, keycode: " + param1Int); 
/* 280 */       if (param1Int > 255) throw new IllegalArgumentException("keycode cannot be greater than 255, keycode: " + param1Int); 
/* 281 */       switch (param1Int) {
/*     */         
/*     */         case 0:
/* 284 */           return "Unknown";
/*     */         case 1:
/* 286 */           return "Soft Left";
/*     */         case 2:
/* 288 */           return "Soft Right";
/*     */         case 3:
/* 290 */           return "Home";
/*     */         case 4:
/* 292 */           return "Back";
/*     */         case 5:
/* 294 */           return "Call";
/*     */         case 6:
/* 296 */           return "End Call";
/*     */         case 7:
/* 298 */           return "0";
/*     */         case 8:
/* 300 */           return "1";
/*     */         case 9:
/* 302 */           return "2";
/*     */         case 10:
/* 304 */           return "3";
/*     */         case 11:
/* 306 */           return "4";
/*     */         case 12:
/* 308 */           return "5";
/*     */         case 13:
/* 310 */           return "6";
/*     */         case 14:
/* 312 */           return "7";
/*     */         case 15:
/* 314 */           return "8";
/*     */         case 16:
/* 316 */           return "9";
/*     */         case 17:
/* 318 */           return "*";
/*     */         case 18:
/* 320 */           return "#";
/*     */         case 19:
/* 322 */           return "Up";
/*     */         case 20:
/* 324 */           return "Down";
/*     */         case 21:
/* 326 */           return "Left";
/*     */         case 22:
/* 328 */           return "Right";
/*     */         case 23:
/* 330 */           return "Center";
/*     */         case 24:
/* 332 */           return "Volume Up";
/*     */         case 25:
/* 334 */           return "Volume Down";
/*     */         case 26:
/* 336 */           return "Power";
/*     */         case 27:
/* 338 */           return "Camera";
/*     */         case 28:
/* 340 */           return "Clear";
/*     */         case 29:
/* 342 */           return "A";
/*     */         case 30:
/* 344 */           return "B";
/*     */         case 31:
/* 346 */           return "C";
/*     */         case 32:
/* 348 */           return "D";
/*     */         case 33:
/* 350 */           return "E";
/*     */         case 34:
/* 352 */           return "F";
/*     */         case 35:
/* 354 */           return "G";
/*     */         case 36:
/* 356 */           return "H";
/*     */         case 37:
/* 358 */           return "I";
/*     */         case 38:
/* 360 */           return "J";
/*     */         case 39:
/* 362 */           return "K";
/*     */         case 40:
/* 364 */           return "L";
/*     */         case 41:
/* 366 */           return "M";
/*     */         case 42:
/* 368 */           return "N";
/*     */         case 43:
/* 370 */           return "O";
/*     */         case 44:
/* 372 */           return "P";
/*     */         case 45:
/* 374 */           return "Q";
/*     */         case 46:
/* 376 */           return "R";
/*     */         case 47:
/* 378 */           return "S";
/*     */         case 48:
/* 380 */           return "T";
/*     */         case 49:
/* 382 */           return "U";
/*     */         case 50:
/* 384 */           return "V";
/*     */         case 51:
/* 386 */           return "W";
/*     */         case 52:
/* 388 */           return "X";
/*     */         case 53:
/* 390 */           return "Y";
/*     */         case 54:
/* 392 */           return "Z";
/*     */         case 55:
/* 394 */           return ",";
/*     */         case 56:
/* 396 */           return ".";
/*     */         case 57:
/* 398 */           return "L-Alt";
/*     */         case 58:
/* 400 */           return "R-Alt";
/*     */         case 59:
/* 402 */           return "L-Shift";
/*     */         case 60:
/* 404 */           return "R-Shift";
/*     */         case 61:
/* 406 */           return "Tab";
/*     */         case 62:
/* 408 */           return "Space";
/*     */         case 63:
/* 410 */           return "SYM";
/*     */         case 64:
/* 412 */           return "Explorer";
/*     */         case 65:
/* 414 */           return "Envelope";
/*     */         case 66:
/* 416 */           return "Enter";
/*     */         case 67:
/* 418 */           return "Delete";
/*     */         case 68:
/* 420 */           return "`";
/*     */         case 69:
/* 422 */           return "-";
/*     */         case 70:
/* 424 */           return "=";
/*     */         case 71:
/* 426 */           return "[";
/*     */         case 72:
/* 428 */           return "]";
/*     */         case 73:
/* 430 */           return "\\";
/*     */         case 74:
/* 432 */           return ";";
/*     */         case 75:
/* 434 */           return "'";
/*     */         case 76:
/* 436 */           return "/";
/*     */         case 77:
/* 438 */           return "@";
/*     */         case 78:
/* 440 */           return "Num";
/*     */         case 79:
/* 442 */           return "Headset Hook";
/*     */         case 80:
/* 444 */           return "Focus";
/*     */         case 81:
/* 446 */           return "Plus";
/*     */         case 82:
/* 448 */           return "Menu";
/*     */         case 83:
/* 450 */           return "Notification";
/*     */         case 84:
/* 452 */           return "Search";
/*     */         case 85:
/* 454 */           return "Play/Pause";
/*     */         case 86:
/* 456 */           return "Stop Media";
/*     */         case 87:
/* 458 */           return "Next Media";
/*     */         case 88:
/* 460 */           return "Prev Media";
/*     */         case 89:
/* 462 */           return "Rewind";
/*     */         case 90:
/* 464 */           return "Fast Forward";
/*     */         case 91:
/* 466 */           return "Mute";
/*     */         case 92:
/* 468 */           return "Page Up";
/*     */         case 93:
/* 470 */           return "Page Down";
/*     */         case 94:
/* 472 */           return "PICTSYMBOLS";
/*     */         case 95:
/* 474 */           return "SWITCH_CHARSET";
/*     */         case 96:
/* 476 */           return "A Button";
/*     */         case 97:
/* 478 */           return "B Button";
/*     */         case 98:
/* 480 */           return "C Button";
/*     */         case 99:
/* 482 */           return "X Button";
/*     */         case 100:
/* 484 */           return "Y Button";
/*     */         case 101:
/* 486 */           return "Z Button";
/*     */         case 102:
/* 488 */           return "L1 Button";
/*     */         case 103:
/* 490 */           return "R1 Button";
/*     */         case 104:
/* 492 */           return "L2 Button";
/*     */         case 105:
/* 494 */           return "R2 Button";
/*     */         case 106:
/* 496 */           return "Left Thumb";
/*     */         case 107:
/* 498 */           return "Right Thumb";
/*     */         case 108:
/* 500 */           return "Start";
/*     */         case 109:
/* 502 */           return "Select";
/*     */         case 110:
/* 504 */           return "Button Mode";
/*     */         case 112:
/* 506 */           return "Forward Delete";
/*     */         case 129:
/* 508 */           return "L-Ctrl";
/*     */         case 130:
/* 510 */           return "R-Ctrl";
/*     */         case 111:
/* 512 */           return "Escape";
/*     */         case 123:
/* 514 */           return "End";
/*     */         case 124:
/* 516 */           return "Insert";
/*     */         case 144:
/* 518 */           return "Numpad 0";
/*     */         case 145:
/* 520 */           return "Numpad 1";
/*     */         case 146:
/* 522 */           return "Numpad 2";
/*     */         case 147:
/* 524 */           return "Numpad 3";
/*     */         case 148:
/* 526 */           return "Numpad 4";
/*     */         case 149:
/* 528 */           return "Numpad 5";
/*     */         case 150:
/* 530 */           return "Numpad 6";
/*     */         case 151:
/* 532 */           return "Numpad 7";
/*     */         case 152:
/* 534 */           return "Numpad 8";
/*     */         case 153:
/* 536 */           return "Numpad 9";
/*     */         case 243:
/* 538 */           return ":";
/*     */         case 131:
/* 540 */           return "F1";
/*     */         case 132:
/* 542 */           return "F2";
/*     */         case 133:
/* 544 */           return "F3";
/*     */         case 134:
/* 546 */           return "F4";
/*     */         case 135:
/* 548 */           return "F5";
/*     */         case 136:
/* 550 */           return "F6";
/*     */         case 137:
/* 552 */           return "F7";
/*     */         case 138:
/* 554 */           return "F8";
/*     */         case 139:
/* 556 */           return "F9";
/*     */         case 140:
/* 558 */           return "F10";
/*     */         case 141:
/* 560 */           return "F11";
/*     */         case 142:
/* 562 */           return "F12";
/*     */         case 183:
/* 564 */           return "F13";
/*     */         case 184:
/* 566 */           return "F14";
/*     */         case 185:
/* 568 */           return "F15";
/*     */         case 186:
/* 570 */           return "F16";
/*     */         case 187:
/* 572 */           return "F17";
/*     */         case 188:
/* 574 */           return "F18";
/*     */         case 189:
/* 576 */           return "F19";
/*     */         case 190:
/* 578 */           return "F20";
/*     */         case 191:
/* 580 */           return "F21";
/*     */         case 192:
/* 582 */           return "F22";
/*     */         case 193:
/* 584 */           return "F23";
/*     */         case 194:
/* 586 */           return "F24";
/*     */         case 154:
/* 588 */           return "Num /";
/*     */         case 155:
/* 590 */           return "Num *";
/*     */         case 156:
/* 592 */           return "Num -";
/*     */         case 157:
/* 594 */           return "Num +";
/*     */         case 158:
/* 596 */           return "Num .";
/*     */         case 159:
/* 598 */           return "Num ,";
/*     */         case 160:
/* 600 */           return "Num Enter";
/*     */         case 161:
/* 602 */           return "Num =";
/*     */         case 162:
/* 604 */           return "Num (";
/*     */         case 163:
/* 606 */           return "Num )";
/*     */         case 143:
/* 608 */           return "Num Lock";
/*     */         case 115:
/* 610 */           return "Caps Lock";
/*     */         case 116:
/* 612 */           return "Scroll Lock";
/*     */         case 121:
/* 614 */           return "Pause";
/*     */         case 120:
/* 616 */           return "Print";
/*     */       } 
/*     */ 
/*     */       
/* 620 */       return null;
/*     */     }
/*     */     public static final int SYM = 63; public static final int T = 48; public static final int TAB = 61; public static final int U = 49; public static final int UNKNOWN = 0; public static final int V = 50; public static final int VOLUME_DOWN = 25; public static final int VOLUME_UP = 24; public static final int W = 51; public static final int X = 52; public static final int Y = 53; public static final int Z = 54; public static final int META_ALT_LEFT_ON = 16; public static final int META_ALT_ON = 2; public static final int META_ALT_RIGHT_ON = 32; public static final int META_SHIFT_LEFT_ON = 64; public static final int META_SHIFT_ON = 1; public static final int META_SHIFT_RIGHT_ON = 128; public static final int META_SYM_ON = 4; public static final int CONTROL_LEFT = 129; public static final int CONTROL_RIGHT = 130; public static final int ESCAPE = 111; public static final int END = 123; public static final int INSERT = 124; public static final int PAGE_UP = 92; public static final int PAGE_DOWN = 93; public static final int PICTSYMBOLS = 94; public static final int SWITCH_CHARSET = 95; public static final int BUTTON_CIRCLE = 255; public static final int BUTTON_A = 96; public static final int BUTTON_B = 97; public static final int BUTTON_C = 98; public static final int BUTTON_X = 99; public static final int BUTTON_Y = 100; public static final int BUTTON_Z = 101; public static final int BUTTON_L1 = 102; public static final int BUTTON_R1 = 103; public static final int BUTTON_L2 = 104; public static final int BUTTON_R2 = 105; public static final int BUTTON_THUMBL = 106; public static final int BUTTON_THUMBR = 107; public static final int BUTTON_START = 108; public static final int BUTTON_SELECT = 109; public static final int BUTTON_MODE = 110; public static final int NUMPAD_0 = 144; public static final int NUMPAD_1 = 145; public static final int NUMPAD_2 = 146; public static final int NUMPAD_3 = 147; public static final int NUMPAD_4 = 148; public static final int NUMPAD_5 = 149; public static final int NUMPAD_6 = 150; public static final int NUMPAD_7 = 151; public static final int NUMPAD_8 = 152; public static final int NUMPAD_9 = 153; public static final int NUMPAD_DIVIDE = 154; public static final int NUMPAD_MULTIPLY = 155; public static final int NUMPAD_SUBTRACT = 156; public static final int NUMPAD_ADD = 157; public static final int NUMPAD_DOT = 158; public static final int NUMPAD_COMMA = 159; public static final int NUMPAD_ENTER = 160; public static final int NUMPAD_EQUALS = 161; public static final int NUMPAD_LEFT_PAREN = 162; public static final int NUMPAD_RIGHT_PAREN = 163; public static final int NUM_LOCK = 143; public static final int COLON = 243; public static final int F1 = 131; public static final int F2 = 132; public static final int F3 = 133; public static final int F4 = 134; public static final int F5 = 135; public static final int F6 = 136; public static final int F7 = 137; public static final int F8 = 138; public static final int F9 = 139; public static final int F10 = 140; public static final int F11 = 141; public static final int F12 = 142; public static final int F13 = 183; public static final int F14 = 184; public static final int F15 = 185; public static final int F16 = 186; public static final int F17 = 187; public static final int F18 = 188; public static final int F19 = 189; public static final int F20 = 190; public static final int F21 = 191; public static final int F22 = 192;
/*     */     public static final int F23 = 193;
/*     */     public static final int F24 = 194;
/*     */     public static final int MAX_KEYCODE = 255;
/*     */     private static ObjectIntMap<String> keyNames;
/*     */     
/*     */     public static int valueOf(String param1String) {
/* 629 */       if (keyNames == null) initializeKeyNames(); 
/* 630 */       return keyNames.get(param1String, -1);
/*     */     }
/*     */ 
/*     */     
/*     */     private static void initializeKeyNames() {
/* 635 */       keyNames = new ObjectIntMap();
/* 636 */       for (byte b = 0; b < 'Ā'; b++) {
/*     */         String str;
/* 638 */         if ((str = toString(b)) != null) keyNames.put(str, b);
/*     */       
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public enum Peripheral
/*     */   {
/* 646 */     HardwareKeyboard, OnscreenKeyboard, MultitouchScreen, Accelerometer, Compass, Vibrator, HapticFeedback, Gyroscope, RotationVector, Pressure;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface InputStringValidator
/*     */   {
/*     */     boolean validate(String param1String);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface KeyboardHeightObserver
/*     */   {
/*     */     void onKeyboardHeightChanged(int param1Int);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum OnscreenKeyboardType
/*     */   {
/* 814 */     Default, NumberPad, PhonePad, Email, Password, URI;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum VibrationType
/*     */   {
/* 855 */     LIGHT, MEDIUM, HEAVY;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum Orientation
/*     */   {
/* 957 */     Landscape, Portrait;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\Input.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */