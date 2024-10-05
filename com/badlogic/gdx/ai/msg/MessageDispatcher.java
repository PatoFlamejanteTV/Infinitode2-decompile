/*     */ package com.badlogic.gdx.ai.msg;
/*     */ 
/*     */ import com.badlogic.gdx.ai.GdxAI;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.IntMap;
/*     */ import com.badlogic.gdx.utils.Pool;
/*     */ import com.badlogic.gdx.utils.reflect.ClassReflection;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MessageDispatcher
/*     */   implements Telegraph
/*     */ {
/*  31 */   private static final String LOG_TAG = MessageDispatcher.class.getSimpleName();
/*     */   
/*  33 */   private static final Pool<Telegram> POOL = new Pool<Telegram>(16)
/*     */     {
/*     */       protected final Telegram newObject() {
/*  36 */         return new Telegram();
/*     */       }
/*     */     };
/*     */   
/*     */   private PriorityQueue<Telegram> queue;
/*     */   private IntMap<Array<Telegraph>> msgListeners;
/*     */   private IntMap<Array<TelegramProvider>> msgProviders;
/*     */   private boolean debugEnabled;
/*     */   
/*     */   public static interface PendingMessageCallback {
/*     */     void report(float param1Float, Telegraph param1Telegraph1, Telegraph param1Telegraph2, int param1Int1, Object param1Object, int param1Int2);
/*     */   }
/*     */   
/*     */   public MessageDispatcher() {
/*  50 */     this.queue = new PriorityQueue<>();
/*  51 */     this.msgListeners = new IntMap();
/*  52 */     this.msgProviders = new IntMap();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDebugEnabled() {
/*  57 */     return this.debugEnabled;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDebugEnabled(boolean paramBoolean) {
/*  62 */     this.debugEnabled = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addListener(Telegraph paramTelegraph, int paramInt) {
/*     */     Array array;
/*  71 */     if ((array = (Array)this.msgListeners.get(paramInt)) == null) {
/*     */       
/*  73 */       array = new Array(false, 16);
/*  74 */       this.msgListeners.put(paramInt, array);
/*     */     } 
/*  76 */     array.add(paramTelegraph);
/*     */ 
/*     */ 
/*     */     
/*  80 */     if ((array = (Array)this.msgProviders.get(paramInt)) != null) {
/*  81 */       byte b; int i; for (b = 0, i = array.size; b < i; b++) {
/*     */         TelegramProvider telegramProvider;
/*     */         Object object;
/*  84 */         if ((object = (telegramProvider = (TelegramProvider)array.get(b)).provideMessageInfo(paramInt, paramTelegraph)) != null) {
/*  85 */           Telegraph telegraph = ClassReflection.isInstance(Telegraph.class, telegramProvider) ? (Telegraph)telegramProvider : null;
/*  86 */           dispatchMessage(0.0F, telegraph, paramTelegraph, paramInt, object, false);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addListeners(Telegraph paramTelegraph, int... paramVarArgs) {
/*     */     int i;
/*     */     byte b;
/*  98 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { int j = paramVarArgs[b];
/*  99 */       addListener(paramTelegraph, j);
/*     */       b++; }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public void addProvider(TelegramProvider paramTelegramProvider, int paramInt) {
/*     */     Array array;
/* 107 */     if ((array = (Array)this.msgProviders.get(paramInt)) == null) {
/*     */       
/* 109 */       array = new Array(false, 16);
/* 110 */       this.msgProviders.put(paramInt, array);
/*     */     } 
/* 112 */     array.add(paramTelegramProvider);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addProviders(TelegramProvider paramTelegramProvider, int... paramVarArgs) {
/*     */     int i;
/*     */     byte b;
/* 119 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { int j = paramVarArgs[b];
/* 120 */       addProvider(paramTelegramProvider, j);
/*     */       b++; }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeListener(Telegraph paramTelegraph, int paramInt) {
/*     */     Array array;
/* 128 */     if ((array = (Array)this.msgListeners.get(paramInt)) != null) {
/* 129 */       array.removeValue(paramTelegraph, true);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeListener(Telegraph paramTelegraph, int... paramVarArgs) {
/*     */     int i;
/*     */     byte b;
/* 138 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { int j = paramVarArgs[b];
/* 139 */       removeListener(paramTelegraph, j);
/*     */       b++; }
/*     */   
/*     */   }
/*     */   
/*     */   public void clearListeners(int paramInt) {
/* 145 */     this.msgListeners.remove(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clearListeners(int... paramVarArgs) {
/*     */     int i;
/*     */     byte b;
/* 152 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { int j = paramVarArgs[b];
/* 153 */       clearListeners(j);
/*     */       b++; }
/*     */   
/*     */   }
/*     */   public void clearListeners() {
/* 158 */     this.msgListeners.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clearProviders(int paramInt) {
/* 164 */     this.msgProviders.remove(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clearProviders(int... paramVarArgs) {
/*     */     int i;
/*     */     byte b;
/* 171 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { int j = paramVarArgs[b];
/* 172 */       clearProviders(j);
/*     */       b++; }
/*     */   
/*     */   }
/*     */   public void clearProviders() {
/* 177 */     this.msgProviders.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clearQueue() {
/* 182 */     for (byte b = 0; b < this.queue.size(); b++) {
/* 183 */       POOL.free(this.queue.get(b));
/*     */     }
/* 185 */     this.queue.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 190 */     clearQueue();
/* 191 */     clearListeners();
/* 192 */     clearProviders();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispatchMessage(int paramInt) {
/* 202 */     dispatchMessage(0.0F, null, null, paramInt, null, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispatchMessage(Telegraph paramTelegraph, int paramInt) {
/* 213 */     dispatchMessage(0.0F, paramTelegraph, null, paramInt, null, false);
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
/*     */   public void dispatchMessage(Telegraph paramTelegraph, int paramInt, boolean paramBoolean) {
/* 226 */     dispatchMessage(0.0F, paramTelegraph, null, paramInt, null, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispatchMessage(int paramInt, Object paramObject) {
/* 237 */     dispatchMessage(0.0F, null, null, paramInt, paramObject, false);
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
/*     */   public void dispatchMessage(Telegraph paramTelegraph, int paramInt, Object paramObject) {
/* 249 */     dispatchMessage(0.0F, paramTelegraph, null, paramInt, paramObject, false);
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
/*     */   public void dispatchMessage(Telegraph paramTelegraph, int paramInt, Object paramObject, boolean paramBoolean) {
/* 263 */     dispatchMessage(0.0F, paramTelegraph, null, paramInt, paramObject, paramBoolean);
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
/*     */   public void dispatchMessage(Telegraph paramTelegraph1, Telegraph paramTelegraph2, int paramInt) {
/* 277 */     dispatchMessage(0.0F, paramTelegraph1, paramTelegraph2, paramInt, null, false);
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
/*     */   public void dispatchMessage(Telegraph paramTelegraph1, Telegraph paramTelegraph2, int paramInt, boolean paramBoolean) {
/* 293 */     dispatchMessage(0.0F, paramTelegraph1, paramTelegraph2, paramInt, null, paramBoolean);
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
/*     */   public void dispatchMessage(Telegraph paramTelegraph1, Telegraph paramTelegraph2, int paramInt, Object paramObject) {
/* 308 */     dispatchMessage(0.0F, paramTelegraph1, paramTelegraph2, paramInt, paramObject, false);
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
/*     */   public void dispatchMessage(Telegraph paramTelegraph1, Telegraph paramTelegraph2, int paramInt, Object paramObject, boolean paramBoolean) {
/* 325 */     dispatchMessage(0.0F, paramTelegraph1, paramTelegraph2, paramInt, paramObject, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispatchMessage(float paramFloat, int paramInt) {
/* 336 */     dispatchMessage(paramFloat, null, null, paramInt, null, false);
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
/*     */   public void dispatchMessage(float paramFloat, Telegraph paramTelegraph, int paramInt) {
/* 348 */     dispatchMessage(paramFloat, paramTelegraph, null, paramInt, null, false);
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
/*     */   public void dispatchMessage(float paramFloat, Telegraph paramTelegraph, int paramInt, boolean paramBoolean) {
/* 362 */     dispatchMessage(paramFloat, paramTelegraph, null, paramInt, null, paramBoolean);
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
/*     */   public void dispatchMessage(float paramFloat, int paramInt, Object paramObject) {
/* 374 */     dispatchMessage(paramFloat, null, null, paramInt, paramObject, false);
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
/*     */   public void dispatchMessage(float paramFloat, Telegraph paramTelegraph, int paramInt, Object paramObject) {
/* 387 */     dispatchMessage(paramFloat, paramTelegraph, null, paramInt, paramObject, false);
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
/*     */   public void dispatchMessage(float paramFloat, Telegraph paramTelegraph, int paramInt, Object paramObject, boolean paramBoolean) {
/* 402 */     dispatchMessage(paramFloat, paramTelegraph, null, paramInt, paramObject, paramBoolean);
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
/*     */   public void dispatchMessage(float paramFloat, Telegraph paramTelegraph1, Telegraph paramTelegraph2, int paramInt) {
/* 417 */     dispatchMessage(paramFloat, paramTelegraph1, paramTelegraph2, paramInt, null, false);
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
/*     */   public void dispatchMessage(float paramFloat, Telegraph paramTelegraph1, Telegraph paramTelegraph2, int paramInt, boolean paramBoolean) {
/* 434 */     dispatchMessage(paramFloat, paramTelegraph1, paramTelegraph2, paramInt, null, paramBoolean);
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
/*     */   public void dispatchMessage(float paramFloat, Telegraph paramTelegraph1, Telegraph paramTelegraph2, int paramInt, Object paramObject) {
/* 450 */     dispatchMessage(paramFloat, paramTelegraph1, paramTelegraph2, paramInt, paramObject, false);
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
/*     */   public void dispatchMessage(float paramFloat, Telegraph paramTelegraph1, Telegraph paramTelegraph2, int paramInt, Object paramObject, boolean paramBoolean) {
/* 465 */     if (paramTelegraph1 == null && paramBoolean) {
/* 466 */       throw new IllegalArgumentException("Sender cannot be null when a return receipt is needed");
/*     */     }
/*     */     
/*     */     Telegram telegram;
/* 470 */     (telegram = (Telegram)POOL.obtain()).sender = paramTelegraph1;
/* 471 */     telegram.receiver = paramTelegraph2;
/* 472 */     telegram.message = paramInt;
/* 473 */     telegram.extraInfo = paramObject;
/* 474 */     telegram.returnReceiptStatus = paramBoolean ? 1 : 0;
/*     */ 
/*     */     
/* 477 */     if (paramFloat <= 0.0F) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 482 */       if (this.debugEnabled) {
/* 483 */         float f1 = GdxAI.getTimepiece().getTime();
/* 484 */         GdxAI.getLogger().info(LOG_TAG, "Instant telegram dispatched at time: " + f1 + " by " + paramTelegraph1 + " for " + paramTelegraph2 + ". Message code is " + paramInt);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 491 */       discharge(telegram); return;
/*     */     } 
/* 493 */     float f = GdxAI.getTimepiece().getTime();
/*     */ 
/*     */     
/* 496 */     telegram.setTimestamp(f + paramFloat);
/*     */ 
/*     */     
/*     */     boolean bool;
/*     */ 
/*     */     
/* 502 */     if (!(bool = this.queue.add(telegram))) POOL.free(telegram);
/*     */     
/* 504 */     if (this.debugEnabled) {
/* 505 */       if (bool) {
/* 506 */         GdxAI.getLogger().info(LOG_TAG, "Delayed telegram from " + paramTelegraph1 + " for " + paramTelegraph2 + " recorded at time " + f + ". Message code is " + paramInt);
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 511 */       GdxAI.getLogger().info(LOG_TAG, "Delayed telegram from " + paramTelegraph1 + " for " + paramTelegraph2 + " rejected by the queue. Message code is " + paramInt);
/*     */     } 
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
/*     */   public void update() {
/* 527 */     float f = GdxAI.getTimepiece().getTime();
/*     */ 
/*     */     
/*     */     Telegram telegram;
/*     */ 
/*     */     
/* 533 */     while ((telegram = this.queue.peek()) != null) {
/*     */ 
/*     */       
/* 536 */       if (telegram.getTimestamp() <= f) {
/*     */         
/* 538 */         if (this.debugEnabled) {
/* 539 */           GdxAI.getLogger().info(LOG_TAG, "Queued telegram ready for dispatch: Sent to " + telegram.receiver + ". Message code is " + telegram.message);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 544 */         discharge(telegram);
/*     */ 
/*     */         
/* 547 */         this.queue.poll();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void scanQueue(PendingMessageCallback paramPendingMessageCallback) {
/* 558 */     float f = GdxAI.getTimepiece().getTime();
/* 559 */     int i = this.queue.size();
/* 560 */     for (byte b = 0; b < i; b++) {
/* 561 */       Telegram telegram = this.queue.get(b);
/* 562 */       paramPendingMessageCallback.report(telegram.getTimestamp() - f, telegram.sender, telegram.receiver, telegram.message, telegram.extraInfo, telegram.returnReceiptStatus);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void discharge(Telegram paramTelegram) {
/* 572 */     if (paramTelegram.receiver != null) {
/*     */       
/* 574 */       if (!paramTelegram.receiver.handleMessage(paramTelegram))
/*     */       {
/* 576 */         if (this.debugEnabled) GdxAI.getLogger().info(LOG_TAG, "Message " + paramTelegram.message + " not handled");
/*     */       
/*     */       }
/*     */     } else {
/* 580 */       byte b = 0;
/*     */       Array array;
/* 582 */       if ((array = (Array)this.msgListeners.get(paramTelegram.message)) != null) {
/* 583 */         for (byte b1 = 0; b1 < array.size; b1++) {
/* 584 */           if (((Telegraph)array.get(b1)).handleMessage(paramTelegram)) {
/* 585 */             b++;
/*     */           }
/*     */         } 
/*     */       }
/*     */       
/* 590 */       if (this.debugEnabled && b == 0) GdxAI.getLogger().info(LOG_TAG, "Message " + paramTelegram.message + " not handled");
/*     */     
/*     */     } 
/* 593 */     if (paramTelegram.returnReceiptStatus == 1) {
/*     */       
/* 595 */       paramTelegram.receiver = paramTelegram.sender;
/* 596 */       paramTelegram.sender = this;
/* 597 */       paramTelegram.returnReceiptStatus = 2;
/* 598 */       discharge(paramTelegram);
/*     */       return;
/*     */     } 
/* 601 */     POOL.free(paramTelegram);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean handleMessage(Telegram paramTelegram) {
/* 611 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\msg\MessageDispatcher.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */