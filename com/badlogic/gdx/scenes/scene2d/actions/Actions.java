/*     */ package com.badlogic.gdx.scenes.scene2d.actions;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.badlogic.gdx.scenes.scene2d.Action;
/*     */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*     */ import com.badlogic.gdx.scenes.scene2d.EventListener;
/*     */ import com.badlogic.gdx.scenes.scene2d.Touchable;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.Pool;
/*     */ import com.badlogic.gdx.utils.Pools;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Actions
/*     */ {
/*     */   public static <T extends Action> T action(Class<T> paramClass) {
/*     */     Pool pool;
/*     */     Action action;
/*  36 */     (action = (Action)(pool = Pools.get(paramClass)).obtain()).setPool(pool);
/*  37 */     return (T)action;
/*     */   }
/*     */   
/*     */   public static AddAction addAction(Action paramAction) {
/*     */     AddAction addAction;
/*  42 */     (addAction = action(AddAction.class)).setAction(paramAction);
/*  43 */     return addAction;
/*     */   }
/*     */   
/*     */   public static AddAction addAction(Action paramAction, Actor paramActor) {
/*     */     AddAction addAction;
/*  48 */     (addAction = action(AddAction.class)).setTarget(paramActor);
/*  49 */     addAction.setAction(paramAction);
/*  50 */     return addAction;
/*     */   }
/*     */   
/*     */   public static RemoveAction removeAction(Action paramAction) {
/*     */     RemoveAction removeAction;
/*  55 */     (removeAction = action(RemoveAction.class)).setAction(paramAction);
/*  56 */     return removeAction;
/*     */   }
/*     */   
/*     */   public static RemoveAction removeAction(Action paramAction, Actor paramActor) {
/*     */     RemoveAction removeAction;
/*  61 */     (removeAction = action(RemoveAction.class)).setTarget(paramActor);
/*  62 */     removeAction.setAction(paramAction);
/*  63 */     return removeAction;
/*     */   }
/*     */ 
/*     */   
/*     */   public static MoveToAction moveTo(float paramFloat1, float paramFloat2) {
/*  68 */     return moveTo(paramFloat1, paramFloat2, 0.0F, null);
/*     */   }
/*     */   
/*     */   public static MoveToAction moveTo(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  72 */     return moveTo(paramFloat1, paramFloat2, paramFloat3, null);
/*     */   }
/*     */   
/*     */   public static MoveToAction moveTo(float paramFloat1, float paramFloat2, float paramFloat3, @Null Interpolation paramInterpolation) {
/*     */     MoveToAction moveToAction;
/*  77 */     (moveToAction = action(MoveToAction.class)).setPosition(paramFloat1, paramFloat2);
/*  78 */     moveToAction.setDuration(paramFloat3);
/*  79 */     moveToAction.setInterpolation(paramInterpolation);
/*  80 */     return moveToAction;
/*     */   }
/*     */   
/*     */   public static MoveToAction moveToAligned(float paramFloat1, float paramFloat2, int paramInt) {
/*  84 */     return moveToAligned(paramFloat1, paramFloat2, paramInt, 0.0F, null);
/*     */   }
/*     */   
/*     */   public static MoveToAction moveToAligned(float paramFloat1, float paramFloat2, int paramInt, float paramFloat3) {
/*  88 */     return moveToAligned(paramFloat1, paramFloat2, paramInt, paramFloat3, null);
/*     */   }
/*     */   
/*     */   public static MoveToAction moveToAligned(float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, @Null Interpolation paramInterpolation) {
/*     */     MoveToAction moveToAction;
/*  93 */     (moveToAction = action(MoveToAction.class)).setPosition(paramFloat1, paramFloat2, paramInt);
/*  94 */     moveToAction.setDuration(paramFloat3);
/*  95 */     moveToAction.setInterpolation(paramInterpolation);
/*  96 */     return moveToAction;
/*     */   }
/*     */ 
/*     */   
/*     */   public static MoveByAction moveBy(float paramFloat1, float paramFloat2) {
/* 101 */     return moveBy(paramFloat1, paramFloat2, 0.0F, null);
/*     */   }
/*     */   
/*     */   public static MoveByAction moveBy(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 105 */     return moveBy(paramFloat1, paramFloat2, paramFloat3, null);
/*     */   }
/*     */   
/*     */   public static MoveByAction moveBy(float paramFloat1, float paramFloat2, float paramFloat3, @Null Interpolation paramInterpolation) {
/*     */     MoveByAction moveByAction;
/* 110 */     (moveByAction = action(MoveByAction.class)).setAmount(paramFloat1, paramFloat2);
/* 111 */     moveByAction.setDuration(paramFloat3);
/* 112 */     moveByAction.setInterpolation(paramInterpolation);
/* 113 */     return moveByAction;
/*     */   }
/*     */ 
/*     */   
/*     */   public static SizeToAction sizeTo(float paramFloat1, float paramFloat2) {
/* 118 */     return sizeTo(paramFloat1, paramFloat2, 0.0F, null);
/*     */   }
/*     */   
/*     */   public static SizeToAction sizeTo(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 122 */     return sizeTo(paramFloat1, paramFloat2, paramFloat3, null);
/*     */   }
/*     */   
/*     */   public static SizeToAction sizeTo(float paramFloat1, float paramFloat2, float paramFloat3, @Null Interpolation paramInterpolation) {
/*     */     SizeToAction sizeToAction;
/* 127 */     (sizeToAction = action(SizeToAction.class)).setSize(paramFloat1, paramFloat2);
/* 128 */     sizeToAction.setDuration(paramFloat3);
/* 129 */     sizeToAction.setInterpolation(paramInterpolation);
/* 130 */     return sizeToAction;
/*     */   }
/*     */ 
/*     */   
/*     */   public static SizeByAction sizeBy(float paramFloat1, float paramFloat2) {
/* 135 */     return sizeBy(paramFloat1, paramFloat2, 0.0F, null);
/*     */   }
/*     */   
/*     */   public static SizeByAction sizeBy(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 139 */     return sizeBy(paramFloat1, paramFloat2, paramFloat3, null);
/*     */   }
/*     */   
/*     */   public static SizeByAction sizeBy(float paramFloat1, float paramFloat2, float paramFloat3, @Null Interpolation paramInterpolation) {
/*     */     SizeByAction sizeByAction;
/* 144 */     (sizeByAction = action(SizeByAction.class)).setAmount(paramFloat1, paramFloat2);
/* 145 */     sizeByAction.setDuration(paramFloat3);
/* 146 */     sizeByAction.setInterpolation(paramInterpolation);
/* 147 */     return sizeByAction;
/*     */   }
/*     */ 
/*     */   
/*     */   public static ScaleToAction scaleTo(float paramFloat1, float paramFloat2) {
/* 152 */     return scaleTo(paramFloat1, paramFloat2, 0.0F, null);
/*     */   }
/*     */   
/*     */   public static ScaleToAction scaleTo(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 156 */     return scaleTo(paramFloat1, paramFloat2, paramFloat3, null);
/*     */   }
/*     */   
/*     */   public static ScaleToAction scaleTo(float paramFloat1, float paramFloat2, float paramFloat3, @Null Interpolation paramInterpolation) {
/*     */     ScaleToAction scaleToAction;
/* 161 */     (scaleToAction = action(ScaleToAction.class)).setScale(paramFloat1, paramFloat2);
/* 162 */     scaleToAction.setDuration(paramFloat3);
/* 163 */     scaleToAction.setInterpolation(paramInterpolation);
/* 164 */     return scaleToAction;
/*     */   }
/*     */ 
/*     */   
/*     */   public static ScaleByAction scaleBy(float paramFloat1, float paramFloat2) {
/* 169 */     return scaleBy(paramFloat1, paramFloat2, 0.0F, null);
/*     */   }
/*     */   
/*     */   public static ScaleByAction scaleBy(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 173 */     return scaleBy(paramFloat1, paramFloat2, paramFloat3, null);
/*     */   }
/*     */   
/*     */   public static ScaleByAction scaleBy(float paramFloat1, float paramFloat2, float paramFloat3, @Null Interpolation paramInterpolation) {
/*     */     ScaleByAction scaleByAction;
/* 178 */     (scaleByAction = action(ScaleByAction.class)).setAmount(paramFloat1, paramFloat2);
/* 179 */     scaleByAction.setDuration(paramFloat3);
/* 180 */     scaleByAction.setInterpolation(paramInterpolation);
/* 181 */     return scaleByAction;
/*     */   }
/*     */ 
/*     */   
/*     */   public static RotateToAction rotateTo(float paramFloat) {
/* 186 */     return rotateTo(paramFloat, 0.0F, null);
/*     */   }
/*     */   
/*     */   public static RotateToAction rotateTo(float paramFloat1, float paramFloat2) {
/* 190 */     return rotateTo(paramFloat1, paramFloat2, null);
/*     */   }
/*     */   
/*     */   public static RotateToAction rotateTo(float paramFloat1, float paramFloat2, @Null Interpolation paramInterpolation) {
/*     */     RotateToAction rotateToAction;
/* 195 */     (rotateToAction = action(RotateToAction.class)).setRotation(paramFloat1);
/* 196 */     rotateToAction.setDuration(paramFloat2);
/* 197 */     rotateToAction.setInterpolation(paramInterpolation);
/* 198 */     return rotateToAction;
/*     */   }
/*     */ 
/*     */   
/*     */   public static RotateByAction rotateBy(float paramFloat) {
/* 203 */     return rotateBy(paramFloat, 0.0F, null);
/*     */   }
/*     */   
/*     */   public static RotateByAction rotateBy(float paramFloat1, float paramFloat2) {
/* 207 */     return rotateBy(paramFloat1, paramFloat2, null);
/*     */   }
/*     */   
/*     */   public static RotateByAction rotateBy(float paramFloat1, float paramFloat2, @Null Interpolation paramInterpolation) {
/*     */     RotateByAction rotateByAction;
/* 212 */     (rotateByAction = action(RotateByAction.class)).setAmount(paramFloat1);
/* 213 */     rotateByAction.setDuration(paramFloat2);
/* 214 */     rotateByAction.setInterpolation(paramInterpolation);
/* 215 */     return rotateByAction;
/*     */   }
/*     */ 
/*     */   
/*     */   public static ColorAction color(Color paramColor) {
/* 220 */     return color(paramColor, 0.0F, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static ColorAction color(Color paramColor, float paramFloat) {
/* 225 */     return color(paramColor, paramFloat, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static ColorAction color(Color paramColor, float paramFloat, @Null Interpolation paramInterpolation) {
/*     */     ColorAction colorAction;
/* 231 */     (colorAction = action(ColorAction.class)).setEndColor(paramColor);
/* 232 */     colorAction.setDuration(paramFloat);
/* 233 */     colorAction.setInterpolation(paramInterpolation);
/* 234 */     return colorAction;
/*     */   }
/*     */ 
/*     */   
/*     */   public static AlphaAction alpha(float paramFloat) {
/* 239 */     return alpha(paramFloat, 0.0F, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static AlphaAction alpha(float paramFloat1, float paramFloat2) {
/* 244 */     return alpha(paramFloat1, paramFloat2, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static AlphaAction alpha(float paramFloat1, float paramFloat2, @Null Interpolation paramInterpolation) {
/*     */     AlphaAction alphaAction;
/* 250 */     (alphaAction = action(AlphaAction.class)).setAlpha(paramFloat1);
/* 251 */     alphaAction.setDuration(paramFloat2);
/* 252 */     alphaAction.setInterpolation(paramInterpolation);
/* 253 */     return alphaAction;
/*     */   }
/*     */ 
/*     */   
/*     */   public static AlphaAction fadeOut(float paramFloat) {
/* 258 */     return alpha(0.0F, paramFloat, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static AlphaAction fadeOut(float paramFloat, @Null Interpolation paramInterpolation) {
/*     */     AlphaAction alphaAction;
/* 264 */     (alphaAction = action(AlphaAction.class)).setAlpha(0.0F);
/* 265 */     alphaAction.setDuration(paramFloat);
/* 266 */     alphaAction.setInterpolation(paramInterpolation);
/* 267 */     return alphaAction;
/*     */   }
/*     */ 
/*     */   
/*     */   public static AlphaAction fadeIn(float paramFloat) {
/* 272 */     return alpha(1.0F, paramFloat, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static AlphaAction fadeIn(float paramFloat, @Null Interpolation paramInterpolation) {
/*     */     AlphaAction alphaAction;
/* 278 */     (alphaAction = action(AlphaAction.class)).setAlpha(1.0F);
/* 279 */     alphaAction.setDuration(paramFloat);
/* 280 */     alphaAction.setInterpolation(paramInterpolation);
/* 281 */     return alphaAction;
/*     */   }
/*     */   
/*     */   public static VisibleAction show() {
/* 285 */     return visible(true);
/*     */   }
/*     */   
/*     */   public static VisibleAction hide() {
/* 289 */     return visible(false);
/*     */   }
/*     */   
/*     */   public static VisibleAction visible(boolean paramBoolean) {
/*     */     VisibleAction visibleAction;
/* 294 */     (visibleAction = action(VisibleAction.class)).setVisible(paramBoolean);
/* 295 */     return visibleAction;
/*     */   }
/*     */   
/*     */   public static TouchableAction touchable(Touchable paramTouchable) {
/*     */     TouchableAction touchableAction;
/* 300 */     (touchableAction = action(TouchableAction.class)).setTouchable(paramTouchable);
/* 301 */     return touchableAction;
/*     */   }
/*     */   
/*     */   public static RemoveActorAction removeActor() {
/* 305 */     return action(RemoveActorAction.class);
/*     */   }
/*     */   
/*     */   public static RemoveActorAction removeActor(Actor paramActor) {
/*     */     RemoveActorAction removeActorAction;
/* 310 */     (removeActorAction = action(RemoveActorAction.class)).setTarget(paramActor);
/* 311 */     return removeActorAction;
/*     */   }
/*     */   
/*     */   public static DelayAction delay(float paramFloat) {
/*     */     DelayAction delayAction;
/* 316 */     (delayAction = action(DelayAction.class)).setDuration(paramFloat);
/* 317 */     return delayAction;
/*     */   }
/*     */   
/*     */   public static DelayAction delay(float paramFloat, Action paramAction) {
/*     */     DelayAction delayAction;
/* 322 */     (delayAction = action(DelayAction.class)).setDuration(paramFloat);
/* 323 */     delayAction.setAction(paramAction);
/* 324 */     return delayAction;
/*     */   }
/*     */   
/*     */   public static TimeScaleAction timeScale(float paramFloat, Action paramAction) {
/*     */     TimeScaleAction timeScaleAction;
/* 329 */     (timeScaleAction = action(TimeScaleAction.class)).setScale(paramFloat);
/* 330 */     timeScaleAction.setAction(paramAction);
/* 331 */     return timeScaleAction;
/*     */   }
/*     */   
/*     */   public static SequenceAction sequence(Action paramAction) {
/*     */     SequenceAction sequenceAction;
/* 336 */     (sequenceAction = action(SequenceAction.class)).addAction(paramAction);
/* 337 */     return sequenceAction;
/*     */   }
/*     */   
/*     */   public static SequenceAction sequence(Action paramAction1, Action paramAction2) {
/*     */     SequenceAction sequenceAction;
/* 342 */     (sequenceAction = action(SequenceAction.class)).addAction(paramAction1);
/* 343 */     sequenceAction.addAction(paramAction2);
/* 344 */     return sequenceAction;
/*     */   }
/*     */   
/*     */   public static SequenceAction sequence(Action paramAction1, Action paramAction2, Action paramAction3) {
/*     */     SequenceAction sequenceAction;
/* 349 */     (sequenceAction = action(SequenceAction.class)).addAction(paramAction1);
/* 350 */     sequenceAction.addAction(paramAction2);
/* 351 */     sequenceAction.addAction(paramAction3);
/* 352 */     return sequenceAction;
/*     */   }
/*     */   
/*     */   public static SequenceAction sequence(Action paramAction1, Action paramAction2, Action paramAction3, Action paramAction4) {
/*     */     SequenceAction sequenceAction;
/* 357 */     (sequenceAction = action(SequenceAction.class)).addAction(paramAction1);
/* 358 */     sequenceAction.addAction(paramAction2);
/* 359 */     sequenceAction.addAction(paramAction3);
/* 360 */     sequenceAction.addAction(paramAction4);
/* 361 */     return sequenceAction;
/*     */   }
/*     */   
/*     */   public static SequenceAction sequence(Action paramAction1, Action paramAction2, Action paramAction3, Action paramAction4, Action paramAction5) {
/*     */     SequenceAction sequenceAction;
/* 366 */     (sequenceAction = action(SequenceAction.class)).addAction(paramAction1);
/* 367 */     sequenceAction.addAction(paramAction2);
/* 368 */     sequenceAction.addAction(paramAction3);
/* 369 */     sequenceAction.addAction(paramAction4);
/* 370 */     sequenceAction.addAction(paramAction5);
/* 371 */     return sequenceAction;
/*     */   }
/*     */   
/*     */   public static SequenceAction sequence(Action... paramVarArgs) {
/* 375 */     SequenceAction sequenceAction = action(SequenceAction.class); byte b; int i;
/* 376 */     for (b = 0, i = paramVarArgs.length; b < i; b++)
/* 377 */       sequenceAction.addAction(paramVarArgs[b]); 
/* 378 */     return sequenceAction;
/*     */   }
/*     */   
/*     */   public static SequenceAction sequence() {
/* 382 */     return action(SequenceAction.class);
/*     */   }
/*     */   
/*     */   public static ParallelAction parallel(Action paramAction) {
/*     */     ParallelAction parallelAction;
/* 387 */     (parallelAction = action(ParallelAction.class)).addAction(paramAction);
/* 388 */     return parallelAction;
/*     */   }
/*     */   
/*     */   public static ParallelAction parallel(Action paramAction1, Action paramAction2) {
/*     */     ParallelAction parallelAction;
/* 393 */     (parallelAction = action(ParallelAction.class)).addAction(paramAction1);
/* 394 */     parallelAction.addAction(paramAction2);
/* 395 */     return parallelAction;
/*     */   }
/*     */   
/*     */   public static ParallelAction parallel(Action paramAction1, Action paramAction2, Action paramAction3) {
/*     */     ParallelAction parallelAction;
/* 400 */     (parallelAction = action(ParallelAction.class)).addAction(paramAction1);
/* 401 */     parallelAction.addAction(paramAction2);
/* 402 */     parallelAction.addAction(paramAction3);
/* 403 */     return parallelAction;
/*     */   }
/*     */   
/*     */   public static ParallelAction parallel(Action paramAction1, Action paramAction2, Action paramAction3, Action paramAction4) {
/*     */     ParallelAction parallelAction;
/* 408 */     (parallelAction = action(ParallelAction.class)).addAction(paramAction1);
/* 409 */     parallelAction.addAction(paramAction2);
/* 410 */     parallelAction.addAction(paramAction3);
/* 411 */     parallelAction.addAction(paramAction4);
/* 412 */     return parallelAction;
/*     */   }
/*     */   
/*     */   public static ParallelAction parallel(Action paramAction1, Action paramAction2, Action paramAction3, Action paramAction4, Action paramAction5) {
/*     */     ParallelAction parallelAction;
/* 417 */     (parallelAction = action(ParallelAction.class)).addAction(paramAction1);
/* 418 */     parallelAction.addAction(paramAction2);
/* 419 */     parallelAction.addAction(paramAction3);
/* 420 */     parallelAction.addAction(paramAction4);
/* 421 */     parallelAction.addAction(paramAction5);
/* 422 */     return parallelAction;
/*     */   }
/*     */   
/*     */   public static ParallelAction parallel(Action... paramVarArgs) {
/* 426 */     ParallelAction parallelAction = action(ParallelAction.class); byte b; int i;
/* 427 */     for (b = 0, i = paramVarArgs.length; b < i; b++)
/* 428 */       parallelAction.addAction(paramVarArgs[b]); 
/* 429 */     return parallelAction;
/*     */   }
/*     */   
/*     */   public static ParallelAction parallel() {
/* 433 */     return action(ParallelAction.class);
/*     */   }
/*     */   
/*     */   public static RepeatAction repeat(int paramInt, Action paramAction) {
/*     */     RepeatAction repeatAction;
/* 438 */     (repeatAction = action(RepeatAction.class)).setCount(paramInt);
/* 439 */     repeatAction.setAction(paramAction);
/* 440 */     return repeatAction;
/*     */   }
/*     */   
/*     */   public static RepeatAction forever(Action paramAction) {
/*     */     RepeatAction repeatAction;
/* 445 */     (repeatAction = action(RepeatAction.class)).setCount(-1);
/* 446 */     repeatAction.setAction(paramAction);
/* 447 */     return repeatAction;
/*     */   }
/*     */   
/*     */   public static RunnableAction run(Runnable paramRunnable) {
/*     */     RunnableAction runnableAction;
/* 452 */     (runnableAction = action(RunnableAction.class)).setRunnable(paramRunnable);
/* 453 */     return runnableAction;
/*     */   }
/*     */   
/*     */   public static LayoutAction layout(boolean paramBoolean) {
/*     */     LayoutAction layoutAction;
/* 458 */     (layoutAction = action(LayoutAction.class)).setLayoutEnabled(paramBoolean);
/* 459 */     return layoutAction;
/*     */   }
/*     */   
/*     */   public static AfterAction after(Action paramAction) {
/*     */     AfterAction afterAction;
/* 464 */     (afterAction = action(AfterAction.class)).setAction(paramAction);
/* 465 */     return afterAction;
/*     */   }
/*     */   
/*     */   public static AddListenerAction addListener(EventListener paramEventListener, boolean paramBoolean) {
/*     */     AddListenerAction addListenerAction;
/* 470 */     (addListenerAction = action(AddListenerAction.class)).setListener(paramEventListener);
/* 471 */     addListenerAction.setCapture(paramBoolean);
/* 472 */     return addListenerAction;
/*     */   }
/*     */   
/*     */   public static AddListenerAction addListener(EventListener paramEventListener, boolean paramBoolean, Actor paramActor) {
/*     */     AddListenerAction addListenerAction;
/* 477 */     (addListenerAction = action(AddListenerAction.class)).setTarget(paramActor);
/* 478 */     addListenerAction.setListener(paramEventListener);
/* 479 */     addListenerAction.setCapture(paramBoolean);
/* 480 */     return addListenerAction;
/*     */   }
/*     */   
/*     */   public static RemoveListenerAction removeListener(EventListener paramEventListener, boolean paramBoolean) {
/*     */     RemoveListenerAction removeListenerAction;
/* 485 */     (removeListenerAction = action(RemoveListenerAction.class)).setListener(paramEventListener);
/* 486 */     removeListenerAction.setCapture(paramBoolean);
/* 487 */     return removeListenerAction;
/*     */   }
/*     */   
/*     */   public static RemoveListenerAction removeListener(EventListener paramEventListener, boolean paramBoolean, Actor paramActor) {
/*     */     RemoveListenerAction removeListenerAction;
/* 492 */     (removeListenerAction = action(RemoveListenerAction.class)).setTarget(paramActor);
/* 493 */     removeListenerAction.setListener(paramEventListener);
/* 494 */     removeListenerAction.setCapture(paramBoolean);
/* 495 */     return removeListenerAction;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Action targeting(Actor paramActor, Action paramAction) {
/* 503 */     paramAction.setTarget(paramActor);
/* 504 */     return paramAction;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2d\actions\Actions.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */