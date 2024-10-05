/*     */ package com.badlogic.gdx.graphics.g3d.utils;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g3d.ModelInstance;
/*     */ import com.badlogic.gdx.graphics.g3d.model.Animation;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.Pool;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AnimationController
/*     */   extends BaseAnimationController
/*     */ {
/*     */   public static interface AnimationListener
/*     */   {
/*     */     void onEnd(AnimationController.AnimationDesc param1AnimationDesc);
/*     */     
/*     */     void onLoop(AnimationController.AnimationDesc param1AnimationDesc);
/*     */   }
/*     */   
/*     */   public static class AnimationDesc
/*     */   {
/*     */     public AnimationController.AnimationListener listener;
/*     */     public Animation animation;
/*     */     public float speed;
/*     */     public float time;
/*     */     public float offset;
/*     */     public float duration;
/*     */     public int loopCount;
/*     */     
/*     */     protected float update(float param1Float) {
/*     */       float f;
/*  77 */       if (this.loopCount != 0 && this.animation != null) {
/*     */         byte b1;
/*  79 */         float f1 = this.speed * param1Float;
/*  80 */         if (!MathUtils.isZero(this.duration)) {
/*  81 */           this.time += f1;
/*  82 */           if (this.speed < 0.0F) {
/*     */             float f2;
/*  84 */             b1 = (int)Math.abs((f2 = this.duration - this.time) / this.duration);
/*  85 */             f2 = Math.abs(f2 % this.duration);
/*  86 */             this.time = this.duration - f2;
/*     */           } else {
/*  88 */             b1 = (int)Math.abs(this.time / this.duration);
/*  89 */             this.time = Math.abs(this.time % this.duration);
/*     */           } 
/*     */         } else {
/*  92 */           b1 = 1;
/*  93 */         }  for (byte b2 = 0; b2 < b1; b2++) {
/*  94 */           if (this.loopCount > 0) this.loopCount--; 
/*  95 */           if (this.loopCount != 0 && this.listener != null) this.listener.onLoop(this); 
/*  96 */           if (this.loopCount == 0) {
/*  97 */             f = (b1 - 1 - b2) * this.duration + ((f1 < 0.0F) ? (this.duration - this.time) : this.time);
/*  98 */             this.time = (f1 < 0.0F) ? 0.0F : this.duration;
/*  99 */             if (this.listener != null) this.listener.onEnd(this); 
/* 100 */             return f;
/*     */           } 
/*     */         } 
/* 103 */         return -1.0F;
/*     */       } 
/* 105 */       return f;
/*     */     }
/*     */   }
/*     */   
/* 109 */   protected final Pool<AnimationDesc> animationPool = new Pool<AnimationDesc>()
/*     */     {
/*     */       protected AnimationController.AnimationDesc newObject() {
/* 112 */         return new AnimationController.AnimationDesc();
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/*     */   public AnimationDesc current;
/*     */   
/*     */   public AnimationDesc queued;
/*     */   
/*     */   public float queuedTransitionTime;
/*     */   
/*     */   public AnimationDesc previous;
/*     */   
/*     */   public float transitionCurrentTime;
/*     */   
/*     */   public float transitionTargetTime;
/*     */   
/*     */   public boolean inAction;
/*     */   
/*     */   public boolean paused;
/*     */   
/*     */   public boolean allowSameAnimation;
/*     */   
/*     */   private boolean justChangedAnimation = false;
/*     */ 
/*     */   
/*     */   public AnimationController(ModelInstance paramModelInstance) {
/* 140 */     super(paramModelInstance);
/*     */   }
/*     */ 
/*     */   
/*     */   private AnimationDesc obtain(Animation paramAnimation, float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, AnimationListener paramAnimationListener) {
/* 145 */     if (paramAnimation == null) return null; 
/*     */     AnimationDesc animationDesc;
/* 147 */     (animationDesc = (AnimationDesc)this.animationPool.obtain()).animation = paramAnimation;
/* 148 */     animationDesc.listener = paramAnimationListener;
/* 149 */     animationDesc.loopCount = paramInt;
/* 150 */     animationDesc.speed = paramFloat3;
/* 151 */     animationDesc.offset = paramFloat1;
/* 152 */     animationDesc.duration = (paramFloat2 < 0.0F) ? (paramAnimation.duration - paramFloat1) : paramFloat2;
/* 153 */     animationDesc.time = (paramFloat3 < 0.0F) ? animationDesc.duration : 0.0F;
/* 154 */     return animationDesc;
/*     */   }
/*     */ 
/*     */   
/*     */   private AnimationDesc obtain(String paramString, float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, AnimationListener paramAnimationListener) {
/* 159 */     if (paramString == null) return null; 
/*     */     Animation animation;
/* 161 */     if ((animation = this.target.getAnimation(paramString)) == null) throw new GdxRuntimeException("Unknown animation: " + paramString); 
/* 162 */     return obtain(animation, paramFloat1, paramFloat2, paramInt, paramFloat3, paramAnimationListener);
/*     */   }
/*     */   
/*     */   private AnimationDesc obtain(AnimationDesc paramAnimationDesc) {
/* 166 */     return obtain(paramAnimationDesc.animation, paramAnimationDesc.offset, paramAnimationDesc.duration, paramAnimationDesc.loopCount, paramAnimationDesc.speed, paramAnimationDesc.listener);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void update(float paramFloat) {
/* 172 */     if (this.paused)
/* 173 */       return;  if (this.previous != null && (this.transitionCurrentTime += paramFloat) >= this.transitionTargetTime) {
/* 174 */       removeAnimation(this.previous.animation);
/* 175 */       this.justChangedAnimation = true;
/* 176 */       this.animationPool.free(this.previous);
/* 177 */       this.previous = null;
/*     */     } 
/* 179 */     if (this.justChangedAnimation) {
/* 180 */       this.target.calculateTransforms();
/* 181 */       this.justChangedAnimation = false;
/*     */     } 
/* 183 */     if (this.current == null || this.current.loopCount == 0 || this.current.animation == null)
/*     */       return; 
/* 185 */     if ((paramFloat = this.current.update(paramFloat)) >= 0.0F && this.queued != null) {
/* 186 */       this.inAction = false;
/* 187 */       animate(this.queued, this.queuedTransitionTime);
/* 188 */       this.queued = null;
/* 189 */       if (paramFloat > 0.0F) update(paramFloat); 
/*     */       return;
/*     */     } 
/* 192 */     if (this.previous != null) {
/* 193 */       applyAnimations(this.previous.animation, this.previous.offset + this.previous.time, this.current.animation, this.current.offset + this.current.time, this.transitionCurrentTime / this.transitionTargetTime);
/*     */       return;
/*     */     } 
/* 196 */     applyAnimation(this.current.animation, this.current.offset + this.current.time);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AnimationDesc setAnimation(String paramString) {
/* 204 */     return setAnimation(paramString, 1, 1.0F, (AnimationListener)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AnimationDesc setAnimation(String paramString, int paramInt) {
/* 214 */     return setAnimation(paramString, paramInt, 1.0F, (AnimationListener)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AnimationDesc setAnimation(String paramString, AnimationListener paramAnimationListener) {
/* 223 */     return setAnimation(paramString, 1, 1.0F, paramAnimationListener);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AnimationDesc setAnimation(String paramString, int paramInt, AnimationListener paramAnimationListener) {
/* 234 */     return setAnimation(paramString, paramInt, 1.0F, paramAnimationListener);
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
/*     */   public AnimationDesc setAnimation(String paramString, int paramInt, float paramFloat, AnimationListener paramAnimationListener) {
/* 248 */     return setAnimation(paramString, 0.0F, -1.0F, paramInt, paramFloat, paramAnimationListener);
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
/*     */   public AnimationDesc setAnimation(String paramString, float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, AnimationListener paramAnimationListener) {
/* 265 */     return setAnimation(obtain(paramString, paramFloat1, paramFloat2, paramInt, paramFloat3, paramAnimationListener));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected AnimationDesc setAnimation(Animation paramAnimation, float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, AnimationListener paramAnimationListener) {
/* 271 */     return setAnimation(obtain(paramAnimation, paramFloat1, paramFloat2, paramInt, paramFloat3, paramAnimationListener));
/*     */   }
/*     */ 
/*     */   
/*     */   protected AnimationDesc setAnimation(AnimationDesc paramAnimationDesc) {
/* 276 */     if (this.current == null) {
/* 277 */       this.current = paramAnimationDesc;
/*     */     } else {
/* 279 */       if (!this.allowSameAnimation && paramAnimationDesc != null && this.current.animation == paramAnimationDesc.animation) {
/* 280 */         paramAnimationDesc.time = this.current.time;
/*     */       } else {
/* 282 */         removeAnimation(this.current.animation);
/* 283 */       }  this.animationPool.free(this.current);
/* 284 */       this.current = paramAnimationDesc;
/*     */     } 
/* 286 */     this.justChangedAnimation = true;
/* 287 */     return paramAnimationDesc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AnimationDesc animate(String paramString, float paramFloat) {
/* 296 */     return animate(paramString, 1, 1.0F, (AnimationListener)null, paramFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AnimationDesc animate(String paramString, AnimationListener paramAnimationListener, float paramFloat) {
/* 306 */     return animate(paramString, 1, 1.0F, paramAnimationListener, paramFloat);
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
/*     */   public AnimationDesc animate(String paramString, int paramInt, AnimationListener paramAnimationListener, float paramFloat) {
/* 318 */     return animate(paramString, paramInt, 1.0F, paramAnimationListener, paramFloat);
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
/*     */   public AnimationDesc animate(String paramString, int paramInt, float paramFloat1, AnimationListener paramAnimationListener, float paramFloat2) {
/* 334 */     return animate(paramString, 0.0F, -1.0F, paramInt, paramFloat1, paramAnimationListener, paramFloat2);
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
/*     */   public AnimationDesc animate(String paramString, float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, AnimationListener paramAnimationListener, float paramFloat4) {
/* 352 */     return animate(obtain(paramString, paramFloat1, paramFloat2, paramInt, paramFloat3, paramAnimationListener), paramFloat4);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected AnimationDesc animate(Animation paramAnimation, float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, AnimationListener paramAnimationListener, float paramFloat4) {
/* 358 */     return animate(obtain(paramAnimation, paramFloat1, paramFloat2, paramInt, paramFloat3, paramAnimationListener), paramFloat4);
/*     */   }
/*     */ 
/*     */   
/*     */   protected AnimationDesc animate(AnimationDesc paramAnimationDesc, float paramFloat) {
/* 363 */     if (this.current == null || this.current.loopCount == 0) {
/* 364 */       this.current = paramAnimationDesc;
/* 365 */     } else if (this.inAction) {
/* 366 */       queue(paramAnimationDesc, paramFloat);
/* 367 */     } else if (!this.allowSameAnimation && paramAnimationDesc != null && this.current.animation == paramAnimationDesc.animation) {
/* 368 */       paramAnimationDesc.time = this.current.time;
/* 369 */       this.animationPool.free(this.current);
/* 370 */       this.current = paramAnimationDesc;
/*     */     } else {
/* 372 */       if (this.previous != null) {
/* 373 */         removeAnimation(this.previous.animation);
/* 374 */         this.animationPool.free(this.previous);
/*     */       } 
/* 376 */       this.previous = this.current;
/* 377 */       this.current = paramAnimationDesc;
/* 378 */       this.transitionCurrentTime = 0.0F;
/* 379 */       this.transitionTargetTime = paramFloat;
/*     */     } 
/* 381 */     return paramAnimationDesc;
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
/*     */   public AnimationDesc queue(String paramString, int paramInt, float paramFloat1, AnimationListener paramAnimationListener, float paramFloat2) {
/* 398 */     return queue(paramString, 0.0F, -1.0F, paramInt, paramFloat1, paramAnimationListener, paramFloat2);
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
/*     */   public AnimationDesc queue(String paramString, float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, AnimationListener paramAnimationListener, float paramFloat4) {
/* 417 */     return queue(obtain(paramString, paramFloat1, paramFloat2, paramInt, paramFloat3, paramAnimationListener), paramFloat4);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected AnimationDesc queue(Animation paramAnimation, float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, AnimationListener paramAnimationListener, float paramFloat4) {
/* 423 */     return queue(obtain(paramAnimation, paramFloat1, paramFloat2, paramInt, paramFloat3, paramAnimationListener), paramFloat4);
/*     */   }
/*     */ 
/*     */   
/*     */   protected AnimationDesc queue(AnimationDesc paramAnimationDesc, float paramFloat) {
/* 428 */     if (this.current == null || this.current.loopCount == 0) {
/* 429 */       animate(paramAnimationDesc, paramFloat);
/*     */     } else {
/* 431 */       if (this.queued != null) this.animationPool.free(this.queued); 
/* 432 */       this.queued = paramAnimationDesc;
/* 433 */       this.queuedTransitionTime = paramFloat;
/* 434 */       if (this.current.loopCount < 0) this.current.loopCount = 1; 
/*     */     } 
/* 436 */     return paramAnimationDesc;
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
/*     */   public AnimationDesc action(String paramString, int paramInt, float paramFloat1, AnimationListener paramAnimationListener, float paramFloat2) {
/* 452 */     return action(paramString, 0.0F, -1.0F, paramInt, paramFloat1, paramAnimationListener, paramFloat2);
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
/*     */   public AnimationDesc action(String paramString, float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, AnimationListener paramAnimationListener, float paramFloat4) {
/* 470 */     return action(obtain(paramString, paramFloat1, paramFloat2, paramInt, paramFloat3, paramAnimationListener), paramFloat4);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected AnimationDesc action(Animation paramAnimation, float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, AnimationListener paramAnimationListener, float paramFloat4) {
/* 476 */     return action(obtain(paramAnimation, paramFloat1, paramFloat2, paramInt, paramFloat3, paramAnimationListener), paramFloat4);
/*     */   }
/*     */ 
/*     */   
/*     */   protected AnimationDesc action(AnimationDesc paramAnimationDesc, float paramFloat) {
/* 481 */     if (paramAnimationDesc.loopCount < 0) throw new GdxRuntimeException("An action cannot be continuous"); 
/* 482 */     if (this.current == null || this.current.loopCount == 0) {
/* 483 */       animate(paramAnimationDesc, paramFloat);
/*     */     } else {
/* 485 */       AnimationDesc animationDesc = this.inAction ? null : obtain(this.current);
/* 486 */       this.inAction = false;
/* 487 */       animate(paramAnimationDesc, paramFloat);
/* 488 */       this.inAction = true;
/* 489 */       if (animationDesc != null) queue(animationDesc, paramFloat); 
/*     */     } 
/* 491 */     return paramAnimationDesc;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3\\utils\AnimationController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */