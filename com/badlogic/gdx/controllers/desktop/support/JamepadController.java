/*     */ package com.badlogic.gdx.controllers.desktop.support;
/*     */ 
/*     */ import com.badlogic.gdx.controllers.Controller;
/*     */ import com.badlogic.gdx.controllers.ControllerListener;
/*     */ import com.badlogic.gdx.controllers.ControllerMapping;
/*     */ import com.badlogic.gdx.controllers.ControllerPowerLevel;
/*     */ import com.badlogic.gdx.utils.IntMap;
/*     */ import com.badlogic.gdx.utils.Logger;
/*     */ import com.badlogic.gdx.utils.TimeUtils;
/*     */ import com.studiohartman.jamepad.ControllerIndex;
/*     */ import com.studiohartman.jamepad.b;
/*     */ import com.studiohartman.jamepad.c;
/*     */ import com.studiohartman.jamepad.d;
/*     */ import com.studiohartman.jamepad.e;
/*     */ import java.util.UUID;
/*     */ 
/*     */ public class JamepadController implements Controller {
/*  18 */   private static final IntMap<c> CODE_TO_BUTTON = new IntMap((c.values()).length);
/*  19 */   private static final IntMap<b> CODE_TO_AXIS = new IntMap((b.values()).length);
/*  20 */   private static final Logger logger = new Logger(JamepadController.class.getSimpleName()); static { c[] arrayOfC;
/*     */     int i;
/*     */     byte b;
/*  23 */     for (i = (arrayOfC = c.values()).length, b = 0; b < i; ) { c c = arrayOfC[b];
/*  24 */       CODE_TO_BUTTON.put(c.ordinal(), c); b++; }
/*     */     
/*     */     b[] arrayOfB;
/*  27 */     for (i = (arrayOfB = b.values()).length, b = 0; b < i; ) { b b1 = arrayOfB[b];
/*  28 */       CODE_TO_AXIS.put(b1.ordinal(), b1);
/*     */       b++; }
/*     */      }
/*     */   
/*  32 */   private final CompositeControllerListener compositeControllerListener = new CompositeControllerListener();
/*     */   private final ControllerIndex controllerIndex;
/*  34 */   private final IntMap<Boolean> buttonState = new IntMap();
/*  35 */   private final IntMap<Float> axisState = new IntMap();
/*     */   private final String uuid;
/*     */   private boolean connected = true;
/*  38 */   private Boolean canVibrate = null;
/*     */   private long vibrationEndMs;
/*  40 */   private int axisCount = -1;
/*  41 */   private int maxButtonIndex = -1;
/*     */   
/*     */   public JamepadController(ControllerIndex paramControllerIndex) {
/*  44 */     this.controllerIndex = paramControllerIndex;
/*  45 */     this.uuid = UUID.randomUUID().toString();
/*  46 */     initializeState();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getButton(int paramInt) {
/*     */     try {
/*     */       c c;
/*  53 */       if ((c = toButton(paramInt)) != null && this.controllerIndex.a(c)) return true;  return false;
/*  54 */     } catch (e e) {
/*  55 */       setDisconnected();
/*     */       
/*  57 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public float getAxis(int paramInt) {
/*     */     try {
/*     */       b b;
/*  65 */       if ((b = toAxis(paramInt)) == null) {
/*  66 */         return 0.0F;
/*     */       }
/*  68 */       return this.controllerIndex.a(b);
/*     */     }
/*  70 */     catch (e e) {
/*  71 */       setDisconnected();
/*     */       
/*  73 */       return 0.0F;
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getName() {
/*     */     try {
/*  79 */       return this.controllerIndex.f();
/*  80 */     } catch (e e) {
/*  81 */       setDisconnected();
/*     */       
/*  83 */       return "Unknown";
/*     */     } 
/*     */   }
/*     */   private void setDisconnected() {
/*  87 */     if (this.connected) {
/*  88 */       this.connected = false;
/*  89 */       logger.info("Failed querying controller at index: " + this.controllerIndex.d());
/*  90 */       this.compositeControllerListener.disconnected(this);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void addListener(ControllerListener paramControllerListener) {
/*  96 */     this.compositeControllerListener.addListener(paramControllerListener);
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeListener(ControllerListener paramControllerListener) {
/* 101 */     this.compositeControllerListener.removeListener(paramControllerListener);
/*     */   }
/*     */   
/*     */   public boolean update() {
/* 105 */     updateButtonsState();
/* 106 */     updateAxisState();
/* 107 */     return this.connected;
/*     */   }
/*     */   
/*     */   private c toButton(int paramInt) {
/* 111 */     return (c)CODE_TO_BUTTON.get(paramInt);
/*     */   }
/*     */   
/*     */   private b toAxis(int paramInt) {
/* 115 */     return (b)CODE_TO_AXIS.get(paramInt);
/*     */   } private void updateAxisState() { b[] arrayOfB;
/*     */     int i;
/*     */     byte b;
/* 119 */     for (i = (arrayOfB = b.values()).length, b = 0; b < i; b++) {
/* 120 */       b b1; int j = (b1 = arrayOfB[b]).ordinal();
/*     */       
/*     */       float f;
/* 123 */       if ((f = getAxis(j)) != ((Float)this.axisState.get(j)).floatValue()) {
/* 124 */         if (logger.getLevel() == 3) {
/* 125 */           logger.debug("Axis [" + j + " - " + toAxis(j) + "] moved [" + f + "]");
/*     */         }
/* 127 */         this.compositeControllerListener.axisMoved(this, j, f);
/*     */       } 
/* 129 */       this.axisState.put(j, Float.valueOf(f));
/*     */     }  }
/*     */   private void updateButtonsState() { c[] arrayOfC;
/*     */     int i;
/*     */     byte b;
/* 134 */     for (i = (arrayOfC = c.values()).length, b = 0; b < i; b++) {
/* 135 */       c c; int j = (c = arrayOfC[b]).ordinal();
/*     */       
/*     */       boolean bool;
/* 138 */       if ((bool = getButton(j)) != ((Boolean)this.buttonState.get(j)).booleanValue()) {
/* 139 */         if (bool) {
/* 140 */           this.compositeControllerListener.buttonDown(this, j);
/*     */         } else {
/* 142 */           this.compositeControllerListener.buttonUp(this, j);
/*     */         } 
/*     */         
/* 145 */         if (logger.getLevel() == 3) {
/* 146 */           logger.debug("Button [" + j + " - " + toButton(j) + "] is " + (bool ? "pressed" : "released"));
/*     */         }
/*     */       } 
/* 149 */       this.buttonState.put(j, Boolean.valueOf(bool));
/*     */     }  } private void initializeState() {
/*     */     b[] arrayOfB;
/*     */     int i;
/*     */     byte b;
/* 154 */     for (i = (arrayOfB = b.values()).length, b = 0; b < i; ) { b b1 = arrayOfB[b];
/* 155 */       this.axisState.put(b1.ordinal(), Float.valueOf(0.0F)); b++; }
/*     */     
/*     */     c[] arrayOfC;
/* 158 */     for (i = (arrayOfC = c.values()).length, b = 0; b < i; ) { c c = arrayOfC[b];
/* 159 */       this.buttonState.put(c.ordinal(), Boolean.FALSE);
/*     */       b++; }
/*     */   
/*     */   }
/*     */   
/*     */   public boolean canVibrate() {
/* 165 */     if (this.canVibrate == null) {
/*     */       try {
/* 167 */         this.canVibrate = Boolean.valueOf(this.controllerIndex.e());
/* 168 */       } catch (e e) {
/* 169 */         setDisconnected();
/*     */       } 
/*     */     }
/*     */     
/* 173 */     return this.canVibrate.booleanValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isVibrating() {
/* 178 */     return (canVibrate() && TimeUtils.millis() < this.vibrationEndMs);
/*     */   }
/*     */ 
/*     */   
/*     */   public void startVibration(int paramInt, float paramFloat) {
/*     */     try {
/* 184 */       if (this.controllerIndex.a(paramFloat, paramFloat, paramInt)) {
/* 185 */         this.vibrationEndMs = TimeUtils.millis() + paramInt;
/* 186 */         this.canVibrate = Boolean.TRUE;
/*     */       }  return;
/* 188 */     } catch (e e) {
/* 189 */       setDisconnected();
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void cancelVibration() {
/* 195 */     if (isVibrating())
/*     */     {
/* 197 */       startVibration(0, 0.0F);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUniqueId() {
/* 203 */     return this.uuid;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean supportsPlayerIndex() {
/* 208 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPlayerIndex() {
/*     */     try {
/* 214 */       return this.controllerIndex.g();
/* 215 */     } catch (e e) {
/* 216 */       setDisconnected();
/* 217 */       return -1;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPlayerIndex(int paramInt) {
/*     */     try {
/* 224 */       this.controllerIndex.a(paramInt); return;
/* 225 */     } catch (e e) {
/* 226 */       setDisconnected();
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getMinButtonIndex() {
/* 232 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMaxButtonIndex() {
/* 237 */     if (this.maxButtonIndex >= 0) {
/* 238 */       return this.maxButtonIndex;
/*     */     }
/*     */     
/* 241 */     this.maxButtonIndex = CODE_TO_BUTTON.size - 1;
/*     */     try {
/* 243 */       while (this.maxButtonIndex > 0 && !this.controllerIndex.b((c)CODE_TO_BUTTON.get(this.maxButtonIndex))) {
/* 244 */         this.maxButtonIndex--;
/*     */       }
/* 246 */     } catch (e e) {
/* 247 */       setDisconnected();
/*     */     } 
/*     */     
/* 250 */     return this.maxButtonIndex;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getAxisCount() {
/* 255 */     if (this.axisCount >= 0) {
/* 256 */       return this.axisCount;
/*     */     }
/*     */     
/* 259 */     this.axisCount = CODE_TO_AXIS.size;
/*     */     try {
/* 261 */       while (this.axisCount > 0 && !this.controllerIndex.b((b)CODE_TO_AXIS.get(this.axisCount - 1))) {
/* 262 */         this.axisCount--;
/*     */       }
/* 264 */     } catch (e e) {
/* 265 */       setDisconnected();
/*     */     } 
/*     */     
/* 268 */     return this.axisCount;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isConnected() {
/* 273 */     return (this.connected && this.controllerIndex.c());
/*     */   }
/*     */ 
/*     */   
/*     */   public ControllerMapping getMapping() {
/* 278 */     return JamepadMapping.getInstance();
/*     */   }
/*     */ 
/*     */   
/*     */   public ControllerPowerLevel getPowerLevel() {
/*     */     try {
/* 284 */       switch (this.controllerIndex.h()) {
/*     */         case f:
/*     */         case d:
/* 287 */           return ControllerPowerLevel.POWER_FULL;
/*     */         case c:
/* 289 */           return ControllerPowerLevel.POWER_MEDIUM;
/*     */         case b:
/* 291 */           return ControllerPowerLevel.POWER_LOW;
/*     */         case a:
/* 293 */           return ControllerPowerLevel.POWER_EMPTY;
/*     */         case e:
/* 295 */           return ControllerPowerLevel.POWER_WIRED;
/*     */       } 
/* 297 */       return ControllerPowerLevel.POWER_UNKNOWN;
/*     */     }
/* 299 */     catch (Throwable throwable) {
/* 300 */       return ControllerPowerLevel.POWER_UNKNOWN;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\controllers\desktop\support\JamepadController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */