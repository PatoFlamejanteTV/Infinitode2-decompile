/*     */ package com.badlogic.gdx.controllers;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class AbstractController
/*     */   implements Controller, Disposable
/*     */ {
/*  11 */   private final Array<ControllerListener> listeners = new Array();
/*     */   
/*     */   private boolean connected = true;
/*     */   
/*     */   public void dispose() {
/*  16 */     synchronized (this.listeners) {
/*  17 */       this.listeners.clear();
/*     */     } 
/*  19 */     this.connected = false;
/*     */   }
/*     */   
/*     */   protected void notifyListenersButtonUp(int paramInt) {
/*     */     Array<ControllerListener> array;
/*  24 */     synchronized (array = Controllers.getListeners()) {
/*  25 */       ControllerListener controllerListener; for (Array.ArrayIterator<ControllerListener> arrayIterator = array.iterator(); arrayIterator.hasNext() && 
/*  26 */         !(controllerListener = arrayIterator.next()).buttonUp(this, paramInt););
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  31 */     synchronized (this.listeners) {
/*  32 */       ControllerListener controllerListener; for (Array.ArrayIterator<ControllerListener> arrayIterator = this.listeners.iterator(); arrayIterator.hasNext() && 
/*  33 */         !(controllerListener = arrayIterator.next()).buttonUp(this, paramInt););
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void notifyListenersButtonDown(int paramInt) {
/*     */     Array<ControllerListener> array;
/*  41 */     synchronized (array = Controllers.getListeners()) {
/*  42 */       ControllerListener controllerListener; for (Array.ArrayIterator<ControllerListener> arrayIterator = array.iterator(); arrayIterator.hasNext() && 
/*  43 */         !(controllerListener = arrayIterator.next()).buttonDown(this, paramInt););
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  48 */     synchronized (this.listeners) {
/*  49 */       ControllerListener controllerListener; for (Array.ArrayIterator<ControllerListener> arrayIterator = this.listeners.iterator(); arrayIterator.hasNext() && 
/*  50 */         !(controllerListener = arrayIterator.next()).buttonDown(this, paramInt););
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void notifyListenersAxisMoved(int paramInt, float paramFloat) {
/*     */     Array<ControllerListener> array;
/*  58 */     synchronized (array = Controllers.getListeners()) {
/*  59 */       ControllerListener controllerListener; for (Array.ArrayIterator<ControllerListener> arrayIterator = array.iterator(); arrayIterator.hasNext() && 
/*  60 */         !(controllerListener = arrayIterator.next()).axisMoved(this, paramInt, paramFloat););
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  65 */     synchronized (this.listeners) {
/*  66 */       ControllerListener controllerListener; for (Array.ArrayIterator<ControllerListener> arrayIterator = this.listeners.iterator(); arrayIterator.hasNext() && 
/*  67 */         !(controllerListener = arrayIterator.next()).axisMoved(this, paramInt, paramFloat););
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addListener(ControllerListener paramControllerListener) {
/*  75 */     synchronized (this.listeners) {
/*  76 */       if (!this.listeners.contains(paramControllerListener, true))
/*  77 */         this.listeners.add(paramControllerListener); 
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void removeListener(ControllerListener paramControllerListener) {
/*  83 */     synchronized (this.listeners) {
/*  84 */       this.listeners.removeValue(paramControllerListener, true);
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canVibrate() {
/*  92 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isVibrating() {
/*  97 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void startVibration(int paramInt, float paramFloat) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void cancelVibration() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean supportsPlayerIndex() {
/* 112 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isConnected() {
/* 117 */     return this.connected;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPlayerIndex() {
/* 122 */     return -1;
/*     */   }
/*     */   
/*     */   public void setPlayerIndex(int paramInt) {}
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\controllers\AbstractController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */