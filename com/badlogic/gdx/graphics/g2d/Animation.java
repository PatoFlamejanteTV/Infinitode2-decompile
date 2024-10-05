/*     */ package com.badlogic.gdx.graphics.g2d;
/*     */ 
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.reflect.ArrayReflection;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Animation<T>
/*     */ {
/*     */   T[] keyFrames;
/*     */   private float frameDuration;
/*     */   private float animationDuration;
/*     */   private int lastFrameNumber;
/*     */   private float lastStateTime;
/*     */   
/*     */   public enum PlayMode
/*     */   {
/*  38 */     NORMAL, REVERSED, LOOP, LOOP_REVERSED, LOOP_PINGPONG, LOOP_RANDOM;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  48 */   private PlayMode playMode = PlayMode.NORMAL;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Animation(float paramFloat, Array<? extends T> paramArray) {
/*  56 */     this.frameDuration = paramFloat;
/*     */     Class<?> clazz;
/*  58 */     Object[] arrayOfObject = (Object[])ArrayReflection.newInstance(clazz = paramArray.items.getClass().getComponentType(), paramArray.size); byte b; int i;
/*  59 */     for (b = 0, i = paramArray.size; b < i; b++) {
/*  60 */       arrayOfObject[b] = paramArray.get(b);
/*     */     }
/*  62 */     setKeyFrames((T[])arrayOfObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Animation(float paramFloat, Array<? extends T> paramArray, PlayMode paramPlayMode) {
/*  71 */     this(paramFloat, paramArray);
/*  72 */     setPlayMode(paramPlayMode);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Animation(float paramFloat, T... paramVarArgs) {
/*  80 */     this.frameDuration = paramFloat;
/*  81 */     setKeyFrames(paramVarArgs);
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
/*     */   public T getKeyFrame(float paramFloat, boolean paramBoolean) {
/*  93 */     PlayMode playMode = this.playMode;
/*  94 */     if (paramBoolean && (this.playMode == PlayMode.NORMAL || this.playMode == PlayMode.REVERSED))
/*  95 */     { if (this.playMode != PlayMode.NORMAL)
/*     */       
/*     */       { 
/*  98 */         this.playMode = PlayMode.LOOP_REVERSED;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 106 */         paramFloat = getKeyFrame(paramFloat);
/* 107 */         this.playMode = playMode;
/* 108 */         return paramFloat; }  } else if (!paramBoolean && this.playMode != PlayMode.NORMAL && this.playMode != PlayMode.REVERSED) { if (this.playMode == PlayMode.LOOP_REVERSED) { this.playMode = PlayMode.REVERSED; paramFloat = getKeyFrame(paramFloat); this.playMode = playMode; return paramFloat; }  } else { paramFloat = getKeyFrame(paramFloat); this.playMode = playMode; return paramFloat; }  this.playMode = PlayMode.LOOP; paramFloat = getKeyFrame(paramFloat); this.playMode = playMode; return paramFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T getKeyFrame(float paramFloat) {
/* 118 */     int i = getKeyFrameIndex(paramFloat);
/* 119 */     return this.keyFrames[i];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getKeyFrameIndex(float paramFloat) {
/*     */     int j;
/* 126 */     if (this.keyFrames.length == 1) return 0;
/*     */     
/* 128 */     int i = (int)(paramFloat / this.frameDuration);
/* 129 */     switch (this.playMode) {
/*     */       case NORMAL:
/* 131 */         i = Math.min(this.keyFrames.length - 1, i);
/*     */         break;
/*     */       case LOOP:
/* 134 */         i %= this.keyFrames.length;
/*     */         break;
/*     */       
/*     */       case LOOP_PINGPONG:
/* 138 */         if ((i = i % ((this.keyFrames.length << 1) - 2)) >= this.keyFrames.length) i = this.keyFrames.length - 2 - i - this.keyFrames.length;
/*     */         
/*     */         break;
/*     */       case LOOP_RANDOM:
/* 142 */         if ((j = (int)(this.lastStateTime / this.frameDuration)) != i) {
/* 143 */           i = MathUtils.random(this.keyFrames.length - 1); break;
/*     */         } 
/* 145 */         i = this.lastFrameNumber;
/*     */         break;
/*     */       
/*     */       case REVERSED:
/* 149 */         i = Math.max(this.keyFrames.length - i - 1, 0);
/*     */         break;
/*     */       case LOOP_REVERSED:
/* 152 */         i %= this.keyFrames.length;
/* 153 */         i = this.keyFrames.length - i - 1;
/*     */         break;
/*     */     } 
/*     */     
/* 157 */     this.lastFrameNumber = i;
/* 158 */     this.lastStateTime = paramFloat;
/*     */     
/* 160 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T[] getKeyFrames() {
/* 167 */     return this.keyFrames;
/*     */   }
/*     */   
/*     */   protected void setKeyFrames(T... paramVarArgs) {
/* 171 */     this.keyFrames = paramVarArgs;
/* 172 */     this.animationDuration = paramVarArgs.length * this.frameDuration;
/*     */   }
/*     */ 
/*     */   
/*     */   public PlayMode getPlayMode() {
/* 177 */     return this.playMode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPlayMode(PlayMode paramPlayMode) {
/* 184 */     this.playMode = paramPlayMode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAnimationFinished(float paramFloat) {
/* 191 */     int i = (int)(paramFloat / this.frameDuration);
/* 192 */     return (this.keyFrames.length - 1 < i);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFrameDuration(float paramFloat) {
/* 198 */     this.frameDuration = paramFloat;
/* 199 */     this.animationDuration = this.keyFrames.length * paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getFrameDuration() {
/* 204 */     return this.frameDuration;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getAnimationDuration() {
/* 209 */     return this.animationDuration;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g2d\Animation.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */