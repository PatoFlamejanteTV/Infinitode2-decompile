/*     */ package com.badlogic.gdx;
/*     */ 
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.NumberUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InputEventQueue
/*     */ {
/*     */   private static final int SKIP = -1;
/*     */   private static final int KEY_DOWN = 0;
/*     */   private static final int KEY_UP = 1;
/*     */   private static final int KEY_TYPED = 2;
/*     */   private static final int TOUCH_DOWN = 3;
/*     */   private static final int TOUCH_UP = 4;
/*     */   private static final int TOUCH_DRAGGED = 5;
/*     */   private static final int MOUSE_MOVED = 6;
/*     */   private static final int SCROLLED = 7;
/*  36 */   private final IntArray queue = new IntArray();
/*  37 */   private final IntArray processingQueue = new IntArray();
/*     */   private long currentEventTime;
/*     */   
/*     */   public void drain(@Null InputProcessor paramInputProcessor) {
/*  41 */     synchronized (this) {
/*  42 */       if (paramInputProcessor == null) {
/*  43 */         this.queue.clear();
/*     */         return;
/*     */       } 
/*  46 */       this.processingQueue.addAll(this.queue);
/*  47 */       this.queue.clear();
/*     */     } 
/*  49 */     int[] arrayOfInt = this.processingQueue.items;
/*  50 */     for (int i = 0, j = this.processingQueue.size; i < j; ) {
/*  51 */       int k = arrayOfInt[i++];
/*  52 */       this.currentEventTime = arrayOfInt[i++] << 32L | arrayOfInt[i++] & 0xFFFFFFFFL;
/*  53 */       switch (k) {
/*     */         case -1:
/*  55 */           i += arrayOfInt[i];
/*     */           continue;
/*     */         case 0:
/*  58 */           paramInputProcessor.keyDown(arrayOfInt[i++]);
/*     */           continue;
/*     */         case 1:
/*  61 */           paramInputProcessor.keyUp(arrayOfInt[i++]);
/*     */           continue;
/*     */         case 2:
/*  64 */           paramInputProcessor.keyTyped((char)arrayOfInt[i++]);
/*     */           continue;
/*     */         case 3:
/*  67 */           paramInputProcessor.touchDown(arrayOfInt[i++], arrayOfInt[i++], arrayOfInt[i++], arrayOfInt[i++]);
/*     */           continue;
/*     */         case 4:
/*  70 */           paramInputProcessor.touchUp(arrayOfInt[i++], arrayOfInt[i++], arrayOfInt[i++], arrayOfInt[i++]);
/*     */           continue;
/*     */         case 5:
/*  73 */           paramInputProcessor.touchDragged(arrayOfInt[i++], arrayOfInt[i++], arrayOfInt[i++]);
/*     */           continue;
/*     */         case 6:
/*  76 */           paramInputProcessor.mouseMoved(arrayOfInt[i++], arrayOfInt[i++]);
/*     */           continue;
/*     */         case 7:
/*  79 */           paramInputProcessor.scrolled(NumberUtils.intBitsToFloat(arrayOfInt[i++]), NumberUtils.intBitsToFloat(arrayOfInt[i++]));
/*     */           continue;
/*     */       } 
/*  82 */       throw new RuntimeException();
/*     */     } 
/*     */     
/*  85 */     this.processingQueue.clear();
/*     */   }
/*     */   
/*     */   private synchronized int next(int paramInt1, int paramInt2) {
/*  89 */     int[] arrayOfInt = this.queue.items;
/*  90 */     for (int i = this.queue.size; paramInt2 < i; ) {
/*     */       int j;
/*  92 */       if ((j = arrayOfInt[paramInt2]) == paramInt1) return paramInt2; 
/*  93 */       paramInt2 += 3;
/*  94 */       switch (j) {
/*     */         case -1:
/*  96 */           paramInt2 += arrayOfInt[paramInt2];
/*     */           continue;
/*     */         case 0:
/*  99 */           paramInt2++;
/*     */           continue;
/*     */         case 1:
/* 102 */           paramInt2++;
/*     */           continue;
/*     */         case 2:
/* 105 */           paramInt2++;
/*     */           continue;
/*     */         case 3:
/* 108 */           paramInt2 += 4;
/*     */           continue;
/*     */         case 4:
/* 111 */           paramInt2 += 4;
/*     */           continue;
/*     */         case 5:
/* 114 */           paramInt2 += 3;
/*     */           continue;
/*     */         case 6:
/* 117 */           paramInt2 += 2;
/*     */           continue;
/*     */         case 7:
/* 120 */           paramInt2 += 2;
/*     */           continue;
/*     */       } 
/* 123 */       throw new RuntimeException();
/*     */     } 
/*     */     
/* 126 */     return -1;
/*     */   }
/*     */   
/*     */   private void queueTime(long paramLong) {
/* 130 */     this.queue.add((int)(paramLong >> 32L));
/* 131 */     this.queue.add((int)paramLong);
/*     */   }
/*     */   
/*     */   public synchronized boolean keyDown(int paramInt, long paramLong) {
/* 135 */     this.queue.add(0);
/* 136 */     queueTime(paramLong);
/* 137 */     this.queue.add(paramInt);
/* 138 */     return false;
/*     */   }
/*     */   
/*     */   public synchronized boolean keyUp(int paramInt, long paramLong) {
/* 142 */     this.queue.add(1);
/* 143 */     queueTime(paramLong);
/* 144 */     this.queue.add(paramInt);
/* 145 */     return false;
/*     */   }
/*     */   
/*     */   public synchronized boolean keyTyped(char paramChar, long paramLong) {
/* 149 */     this.queue.add(2);
/* 150 */     queueTime(paramLong);
/* 151 */     this.queue.add(paramChar);
/* 152 */     return false;
/*     */   }
/*     */   
/*     */   public synchronized boolean touchDown(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong) {
/* 156 */     this.queue.add(3);
/* 157 */     queueTime(paramLong);
/* 158 */     this.queue.add(paramInt1);
/* 159 */     this.queue.add(paramInt2);
/* 160 */     this.queue.add(paramInt3);
/* 161 */     this.queue.add(paramInt4);
/* 162 */     return false;
/*     */   }
/*     */   
/*     */   public synchronized boolean touchUp(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong) {
/* 166 */     this.queue.add(4);
/* 167 */     queueTime(paramLong);
/* 168 */     this.queue.add(paramInt1);
/* 169 */     this.queue.add(paramInt2);
/* 170 */     this.queue.add(paramInt3);
/* 171 */     this.queue.add(paramInt4);
/* 172 */     return false;
/*     */   }
/*     */   
/*     */   public synchronized boolean touchDragged(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/*     */     int i;
/* 177 */     for (i = next(5, 0); i >= 0; i = next(5, i + 6)) {
/* 178 */       if (this.queue.get(i + 5) == paramInt3) {
/* 179 */         this.queue.set(i, -1);
/* 180 */         this.queue.set(i + 3, 3);
/*     */       } 
/*     */     } 
/* 183 */     this.queue.add(5);
/* 184 */     queueTime(paramLong);
/* 185 */     this.queue.add(paramInt1);
/* 186 */     this.queue.add(paramInt2);
/* 187 */     this.queue.add(paramInt3);
/* 188 */     return false;
/*     */   }
/*     */   
/*     */   public synchronized boolean mouseMoved(int paramInt1, int paramInt2, long paramLong) {
/*     */     int i;
/* 193 */     for (i = next(6, 0); i >= 0; i = next(6, i + 5)) {
/* 194 */       this.queue.set(i, -1);
/* 195 */       this.queue.set(i + 3, 2);
/*     */     } 
/* 197 */     this.queue.add(6);
/* 198 */     queueTime(paramLong);
/* 199 */     this.queue.add(paramInt1);
/* 200 */     this.queue.add(paramInt2);
/* 201 */     return false;
/*     */   }
/*     */   
/*     */   public synchronized boolean scrolled(float paramFloat1, float paramFloat2, long paramLong) {
/* 205 */     this.queue.add(7);
/* 206 */     queueTime(paramLong);
/* 207 */     this.queue.add(NumberUtils.floatToIntBits(paramFloat1));
/* 208 */     this.queue.add(NumberUtils.floatToIntBits(paramFloat2));
/* 209 */     return false;
/*     */   }
/*     */   
/*     */   public long getCurrentEventTime() {
/* 213 */     return this.currentEventTime;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\InputEventQueue.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */