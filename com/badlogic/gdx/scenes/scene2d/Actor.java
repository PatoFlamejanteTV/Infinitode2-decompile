/*     */ package com.badlogic.gdx.scenes.scene2d;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
/*     */ import com.badlogic.gdx.math.Rectangle;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.Pools;
/*     */ import com.badlogic.gdx.utils.SnapshotArray;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Actor
/*     */ {
/*     */   @Null
/*     */   private Stage stage;
/*     */   @Null
/*     */   Group parent;
/*  60 */   private final DelayedRemovalArray<EventListener> listeners = new DelayedRemovalArray(0);
/*  61 */   private final DelayedRemovalArray<EventListener> captureListeners = new DelayedRemovalArray(0);
/*  62 */   private final Array<Action> actions = new Array(0); @Null
/*     */   private String name; private boolean visible = true; private boolean debug; float x;
/*     */   float y;
/*  65 */   private Touchable touchable = Touchable.enabled;
/*     */   float width;
/*     */   float height;
/*     */   float originX;
/*     */   float originY;
/*  70 */   float scaleX = 1.0F; float scaleY = 1.0F;
/*     */   float rotation;
/*  72 */   final Color color = new Color(1.0F, 1.0F, 1.0F, 1.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Null
/*     */   private Object userObject;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void act(float paramFloat) {
/*     */     Array<Action> array;
/*  93 */     if ((array = this.actions).size == 0)
/*  94 */       return;  if (this.stage != null && this.stage.getActionsRequestRendering()) Gdx.graphics.requestRendering(); 
/*     */     try {
/*  96 */       for (byte b = 0; b < array.size; b++) {
/*     */         Action action;
/*  98 */         if ((action = (Action)array.get(b)).act(paramFloat) && b < array.size) {
/*     */           boolean bool;
/*     */           Action action1;
/* 101 */           if ((bool = ((action1 = (Action)array.get(b)) == action) ? b : array.indexOf(action, true)) != -1) {
/* 102 */             array.removeIndex(bool);
/* 103 */             action.setActor(null);
/* 104 */             b--;
/*     */           } 
/*     */         } 
/*     */       }  return;
/* 108 */     } catch (RuntimeException runtimeException) {
/* 109 */       String str = toString();
/* 110 */       throw new RuntimeException("Actor: " + str.substring(0, Math.min(str.length(), 128)), runtimeException);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean fire(Event paramEvent) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: invokevirtual getStage : ()Lcom/badlogic/gdx/scenes/scene2d/Stage;
/*     */     //   4: ifnonnull -> 15
/*     */     //   7: aload_1
/*     */     //   8: aload_0
/*     */     //   9: invokevirtual getStage : ()Lcom/badlogic/gdx/scenes/scene2d/Stage;
/*     */     //   12: invokevirtual setStage : (Lcom/badlogic/gdx/scenes/scene2d/Stage;)V
/*     */     //   15: aload_1
/*     */     //   16: aload_0
/*     */     //   17: invokevirtual setTarget : (Lcom/badlogic/gdx/scenes/scene2d/Actor;)V
/*     */     //   20: ldc com/badlogic/gdx/utils/Array
/*     */     //   22: invokestatic obtain : (Ljava/lang/Class;)Ljava/lang/Object;
/*     */     //   25: checkcast com/badlogic/gdx/utils/Array
/*     */     //   28: astore_2
/*     */     //   29: aload_0
/*     */     //   30: getfield parent : Lcom/badlogic/gdx/scenes/scene2d/Group;
/*     */     //   33: astore_3
/*     */     //   34: aload_3
/*     */     //   35: ifnull -> 51
/*     */     //   38: aload_2
/*     */     //   39: aload_3
/*     */     //   40: invokevirtual add : (Ljava/lang/Object;)V
/*     */     //   43: aload_3
/*     */     //   44: getfield parent : Lcom/badlogic/gdx/scenes/scene2d/Group;
/*     */     //   47: astore_3
/*     */     //   48: goto -> 34
/*     */     //   51: aload_2
/*     */     //   52: getfield items : [Ljava/lang/Object;
/*     */     //   55: astore_3
/*     */     //   56: aload_2
/*     */     //   57: getfield size : I
/*     */     //   60: iconst_1
/*     */     //   61: isub
/*     */     //   62: istore #4
/*     */     //   64: iload #4
/*     */     //   66: iflt -> 113
/*     */     //   69: aload_3
/*     */     //   70: iload #4
/*     */     //   72: aaload
/*     */     //   73: checkcast com/badlogic/gdx/scenes/scene2d/Group
/*     */     //   76: dup
/*     */     //   77: astore #5
/*     */     //   79: aload_1
/*     */     //   80: iconst_1
/*     */     //   81: invokevirtual notify : (Lcom/badlogic/gdx/scenes/scene2d/Event;Z)Z
/*     */     //   84: pop
/*     */     //   85: aload_1
/*     */     //   86: invokevirtual isStopped : ()Z
/*     */     //   89: ifeq -> 107
/*     */     //   92: aload_1
/*     */     //   93: invokevirtual isCancelled : ()Z
/*     */     //   96: istore_1
/*     */     //   97: aload_2
/*     */     //   98: invokevirtual clear : ()V
/*     */     //   101: aload_2
/*     */     //   102: invokestatic free : (Ljava/lang/Object;)V
/*     */     //   105: iload_1
/*     */     //   106: ireturn
/*     */     //   107: iinc #4, -1
/*     */     //   110: goto -> 64
/*     */     //   113: aload_0
/*     */     //   114: aload_1
/*     */     //   115: iconst_1
/*     */     //   116: invokevirtual notify : (Lcom/badlogic/gdx/scenes/scene2d/Event;Z)Z
/*     */     //   119: pop
/*     */     //   120: aload_1
/*     */     //   121: invokevirtual isStopped : ()Z
/*     */     //   124: ifeq -> 144
/*     */     //   127: aload_1
/*     */     //   128: invokevirtual isCancelled : ()Z
/*     */     //   131: istore #4
/*     */     //   133: aload_2
/*     */     //   134: invokevirtual clear : ()V
/*     */     //   137: aload_2
/*     */     //   138: invokestatic free : (Ljava/lang/Object;)V
/*     */     //   141: iload #4
/*     */     //   143: ireturn
/*     */     //   144: aload_0
/*     */     //   145: aload_1
/*     */     //   146: iconst_0
/*     */     //   147: invokevirtual notify : (Lcom/badlogic/gdx/scenes/scene2d/Event;Z)Z
/*     */     //   150: pop
/*     */     //   151: aload_1
/*     */     //   152: invokevirtual getBubbles : ()Z
/*     */     //   155: ifne -> 175
/*     */     //   158: aload_1
/*     */     //   159: invokevirtual isCancelled : ()Z
/*     */     //   162: istore #4
/*     */     //   164: aload_2
/*     */     //   165: invokevirtual clear : ()V
/*     */     //   168: aload_2
/*     */     //   169: invokestatic free : (Ljava/lang/Object;)V
/*     */     //   172: iload #4
/*     */     //   174: ireturn
/*     */     //   175: aload_1
/*     */     //   176: invokevirtual isStopped : ()Z
/*     */     //   179: ifeq -> 199
/*     */     //   182: aload_1
/*     */     //   183: invokevirtual isCancelled : ()Z
/*     */     //   186: istore #4
/*     */     //   188: aload_2
/*     */     //   189: invokevirtual clear : ()V
/*     */     //   192: aload_2
/*     */     //   193: invokestatic free : (Ljava/lang/Object;)V
/*     */     //   196: iload #4
/*     */     //   198: ireturn
/*     */     //   199: iconst_0
/*     */     //   200: istore #4
/*     */     //   202: aload_2
/*     */     //   203: getfield size : I
/*     */     //   206: istore #5
/*     */     //   208: iload #4
/*     */     //   210: iload #5
/*     */     //   212: if_icmpge -> 256
/*     */     //   215: aload_3
/*     */     //   216: iload #4
/*     */     //   218: aaload
/*     */     //   219: checkcast com/badlogic/gdx/scenes/scene2d/Group
/*     */     //   222: aload_1
/*     */     //   223: iconst_0
/*     */     //   224: invokevirtual notify : (Lcom/badlogic/gdx/scenes/scene2d/Event;Z)Z
/*     */     //   227: pop
/*     */     //   228: aload_1
/*     */     //   229: invokevirtual isStopped : ()Z
/*     */     //   232: ifeq -> 250
/*     */     //   235: aload_1
/*     */     //   236: invokevirtual isCancelled : ()Z
/*     */     //   239: istore_1
/*     */     //   240: aload_2
/*     */     //   241: invokevirtual clear : ()V
/*     */     //   244: aload_2
/*     */     //   245: invokestatic free : (Ljava/lang/Object;)V
/*     */     //   248: iload_1
/*     */     //   249: ireturn
/*     */     //   250: iinc #4, 1
/*     */     //   253: goto -> 208
/*     */     //   256: aload_1
/*     */     //   257: invokevirtual isCancelled : ()Z
/*     */     //   260: istore #4
/*     */     //   262: aload_2
/*     */     //   263: invokevirtual clear : ()V
/*     */     //   266: aload_2
/*     */     //   267: invokestatic free : (Ljava/lang/Object;)V
/*     */     //   270: iload #4
/*     */     //   272: ireturn
/*     */     //   273: astore_1
/*     */     //   274: aload_2
/*     */     //   275: invokevirtual clear : ()V
/*     */     //   278: aload_2
/*     */     //   279: invokestatic free : (Ljava/lang/Object;)V
/*     */     //   282: aload_1
/*     */     //   283: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #127	-> 0
/*     */     //   #128	-> 15
/*     */     //   #131	-> 20
/*     */     //   #132	-> 29
/*     */     //   #133	-> 34
/*     */     //   #134	-> 38
/*     */     //   #135	-> 43
/*     */     //   #140	-> 51
/*     */     //   #141	-> 56
/*     */     //   #142	-> 69
/*     */     //   #143	-> 77
/*     */     //   #144	-> 85
/*     */     //   #164	-> 97
/*     */     //   #165	-> 101
/*     */     //   #144	-> 105
/*     */     //   #141	-> 107
/*     */     //   #148	-> 113
/*     */     //   #149	-> 120
/*     */     //   #164	-> 133
/*     */     //   #165	-> 137
/*     */     //   #149	-> 141
/*     */     //   #152	-> 144
/*     */     //   #153	-> 151
/*     */     //   #164	-> 164
/*     */     //   #165	-> 168
/*     */     //   #153	-> 172
/*     */     //   #154	-> 175
/*     */     //   #164	-> 188
/*     */     //   #165	-> 192
/*     */     //   #154	-> 196
/*     */     //   #157	-> 199
/*     */     //   #158	-> 215
/*     */     //   #159	-> 228
/*     */     //   #164	-> 240
/*     */     //   #165	-> 244
/*     */     //   #159	-> 248
/*     */     //   #157	-> 250
/*     */     //   #162	-> 256
/*     */     //   #164	-> 262
/*     */     //   #165	-> 266
/*     */     //   #162	-> 270
/*     */     //   #164	-> 273
/*     */     //   #165	-> 278
/*     */     //   #166	-> 282
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   51	97	273	finally
/*     */     //   107	133	273	finally
/*     */     //   144	164	273	finally
/*     */     //   175	188	273	finally
/*     */     //   199	240	273	finally
/*     */     //   250	262	273	finally
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
/*     */   public boolean notify(Event paramEvent, boolean paramBoolean) {
/* 176 */     if (paramEvent.getTarget() == null) throw new IllegalArgumentException("The event target cannot be null.");
/*     */     
/*     */     DelayedRemovalArray<EventListener> delayedRemovalArray;
/* 179 */     if ((delayedRemovalArray = paramBoolean ? this.captureListeners : this.listeners).size == 0) return paramEvent.isCancelled();
/*     */     
/* 181 */     paramEvent.setListenerActor(this);
/* 182 */     paramEvent.setCapture(paramBoolean);
/* 183 */     if (paramEvent.getStage() == null) paramEvent.setStage(this.stage);
/*     */     
/*     */     try {
/* 186 */       delayedRemovalArray.begin(); int i;
/* 187 */       for (paramBoolean = false, i = delayedRemovalArray.size; paramBoolean < i; paramBoolean++) {
/* 188 */         if (((EventListener)delayedRemovalArray.get(paramBoolean)).handle(paramEvent)) paramEvent.handle(); 
/* 189 */       }  delayedRemovalArray.end();
/* 190 */     } catch (RuntimeException runtimeException) {
/* 191 */       String str = toString();
/* 192 */       throw new RuntimeException("Actor: " + str.substring(0, Math.min(str.length(), 128)), runtimeException);
/*     */     } 
/*     */     
/* 195 */     return paramEvent.isCancelled();
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
/*     */   @Null
/*     */   public Actor hit(float paramFloat1, float paramFloat2, boolean paramBoolean) {
/* 209 */     if (paramBoolean && this.touchable != Touchable.enabled) return null; 
/* 210 */     if (!isVisible()) return null; 
/* 211 */     return (paramFloat1 >= 0.0F && paramFloat1 < this.width && paramFloat2 >= 0.0F && paramFloat2 < this.height) ? this : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean remove() {
/* 217 */     if (this.parent != null) return this.parent.removeActor(this, true); 
/* 218 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addListener(EventListener paramEventListener) {
/* 225 */     if (paramEventListener == null) throw new IllegalArgumentException("listener cannot be null."); 
/* 226 */     if (!this.listeners.contains(paramEventListener, true)) {
/* 227 */       this.listeners.add(paramEventListener);
/* 228 */       return true;
/*     */     } 
/* 230 */     return false;
/*     */   }
/*     */   
/*     */   public boolean removeListener(EventListener paramEventListener) {
/* 234 */     if (paramEventListener == null) throw new IllegalArgumentException("listener cannot be null."); 
/* 235 */     return this.listeners.removeValue(paramEventListener, true);
/*     */   }
/*     */   
/*     */   public DelayedRemovalArray<EventListener> getListeners() {
/* 239 */     return this.listeners;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addCaptureListener(EventListener paramEventListener) {
/* 245 */     if (paramEventListener == null) throw new IllegalArgumentException("listener cannot be null."); 
/* 246 */     if (!this.captureListeners.contains(paramEventListener, true)) this.captureListeners.add(paramEventListener); 
/* 247 */     return true;
/*     */   }
/*     */   
/*     */   public boolean removeCaptureListener(EventListener paramEventListener) {
/* 251 */     if (paramEventListener == null) throw new IllegalArgumentException("listener cannot be null."); 
/* 252 */     return this.captureListeners.removeValue(paramEventListener, true);
/*     */   }
/*     */   
/*     */   public DelayedRemovalArray<EventListener> getCaptureListeners() {
/* 256 */     return this.captureListeners;
/*     */   }
/*     */   
/*     */   public void addAction(Action paramAction) {
/* 260 */     paramAction.setActor(this);
/* 261 */     this.actions.add(paramAction);
/*     */     
/* 263 */     if (this.stage != null && this.stage.getActionsRequestRendering()) Gdx.graphics.requestRendering();
/*     */   
/*     */   }
/*     */   
/*     */   public void removeAction(@Null Action paramAction) {
/* 268 */     if (paramAction != null && this.actions.removeValue(paramAction, true)) paramAction.setActor(null); 
/*     */   }
/*     */   
/*     */   public Array<Action> getActions() {
/* 272 */     return this.actions;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasActions() {
/* 277 */     return (this.actions.size > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clearActions() {
/* 282 */     for (int i = this.actions.size - 1; i >= 0; i--)
/* 283 */       ((Action)this.actions.get(i)).setActor(null); 
/* 284 */     this.actions.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clearListeners() {
/* 289 */     this.listeners.clear();
/* 290 */     this.captureListeners.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 295 */     clearActions();
/* 296 */     clearListeners();
/*     */   }
/*     */   
/*     */   @Null
/*     */   public Stage getStage() {
/* 301 */     return this.stage;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setStage(Stage paramStage) {
/* 307 */     this.stage = paramStage;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDescendantOf(Actor paramActor) {
/* 312 */     if (paramActor == null) throw new IllegalArgumentException("actor cannot be null."); 
/* 313 */     Actor actor = this;
/*     */     while (true) {
/* 315 */       if (actor == paramActor) return true;
/*     */       
/* 317 */       if ((actor = actor.parent) == null)
/* 318 */         return false; 
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isAscendantOf(Actor paramActor) {
/* 323 */     if (paramActor == null) throw new IllegalArgumentException("actor cannot be null."); 
/*     */     while (true) {
/* 325 */       if (paramActor == this) return true;
/*     */       
/* 327 */       if ((paramActor = paramActor.parent) == null)
/* 328 */         return false; 
/*     */     } 
/*     */   }
/*     */   
/*     */   @Null
/*     */   public <T extends Actor> T firstAscendant(Class<T> paramClass) {
/* 334 */     if (paramClass == null) throw new IllegalArgumentException("actor cannot be null."); 
/* 335 */     Actor actor = this;
/*     */     while (true) {
/* 337 */       if (ClassReflection.isInstance(paramClass, actor)) return (T)actor;
/*     */       
/* 339 */       if ((actor = actor.parent) == null)
/* 340 */         return null; 
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean hasParent() {
/* 345 */     return (this.parent != null);
/*     */   }
/*     */   
/*     */   @Null
/*     */   public Group getParent() {
/* 350 */     return this.parent;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setParent(@Null Group paramGroup) {
/* 356 */     this.parent = paramGroup;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTouchable() {
/* 361 */     return (this.touchable == Touchable.enabled);
/*     */   }
/*     */   
/*     */   public Touchable getTouchable() {
/* 365 */     return this.touchable;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTouchable(Touchable paramTouchable) {
/* 370 */     this.touchable = paramTouchable;
/*     */   }
/*     */   
/*     */   public boolean isVisible() {
/* 374 */     return this.visible;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setVisible(boolean paramBoolean) {
/* 379 */     this.visible = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ascendantsVisible() {
/* 384 */     Actor actor = this;
/*     */     while (true) {
/* 386 */       if (!actor.isVisible()) return false;
/*     */       
/* 388 */       if ((actor = actor.parent) == null)
/* 389 */         return true; 
/*     */     } 
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public boolean ancestorsVisible() {
/* 395 */     return ascendantsVisible();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasKeyboardFocus() {
/*     */     Stage stage;
/* 401 */     if ((stage = getStage()) != null && stage.getKeyboardFocus() == this) return true;  return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasScrollFocus() {
/*     */     Stage stage;
/* 407 */     if ((stage = getStage()) != null && stage.getScrollFocus() == this) return true;  return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTouchFocusTarget() {
/*     */     Stage stage;
/* 414 */     if ((stage = getStage()) == null) return false;  byte b; int i;
/* 415 */     for (b = 0, i = stage.touchFocuses.size; b < i; b++) {
/* 416 */       if (((Stage.TouchFocus)stage.touchFocuses.get(b)).target == this) return true; 
/* 417 */     }  return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTouchFocusListener() {
/*     */     Stage stage;
/* 424 */     if ((stage = getStage()) == null) return false;  byte b; int i;
/* 425 */     for (b = 0, i = stage.touchFocuses.size; b < i; b++) {
/* 426 */       if (((Stage.TouchFocus)stage.touchFocuses.get(b)).listenerActor == this) return true; 
/* 427 */     }  return false;
/*     */   }
/*     */   
/*     */   @Null
/*     */   public Object getUserObject() {
/* 432 */     return this.userObject;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setUserObject(@Null Object paramObject) {
/* 437 */     this.userObject = paramObject;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getX() {
/* 442 */     return this.x;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getX(int paramInt) {
/* 447 */     float f = this.x;
/* 448 */     if ((paramInt & 0x10) != 0) {
/* 449 */       f += this.width;
/* 450 */     } else if ((paramInt & 0x8) == 0) {
/* 451 */       f += this.width / 2.0F;
/* 452 */     }  return f;
/*     */   }
/*     */   
/*     */   public void setX(float paramFloat) {
/* 456 */     if (this.x != paramFloat) {
/* 457 */       this.x = paramFloat;
/* 458 */       positionChanged();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setX(float paramFloat, int paramInt) {
/* 466 */     if ((paramInt & 0x10) != 0) {
/* 467 */       paramFloat -= this.width;
/* 468 */     } else if ((paramInt & 0x8) == 0) {
/* 469 */       paramFloat -= this.width / 2.0F;
/*     */     } 
/* 471 */     if (this.x != paramFloat) {
/* 472 */       this.x = paramFloat;
/* 473 */       positionChanged();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public float getY() {
/* 479 */     return this.y;
/*     */   }
/*     */   
/*     */   public void setY(float paramFloat) {
/* 483 */     if (this.y != paramFloat) {
/* 484 */       this.y = paramFloat;
/* 485 */       positionChanged();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setY(float paramFloat, int paramInt) {
/* 493 */     if ((paramInt & 0x2) != 0) {
/* 494 */       paramFloat -= this.height;
/* 495 */     } else if ((paramInt & 0x4) == 0) {
/* 496 */       paramFloat -= this.height / 2.0F;
/*     */     } 
/* 498 */     if (this.y != paramFloat) {
/* 499 */       this.y = paramFloat;
/* 500 */       positionChanged();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public float getY(int paramInt) {
/* 506 */     float f = this.y;
/* 507 */     if ((paramInt & 0x2) != 0) {
/* 508 */       f += this.height;
/* 509 */     } else if ((paramInt & 0x4) == 0) {
/* 510 */       f += this.height / 2.0F;
/* 511 */     }  return f;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPosition(float paramFloat1, float paramFloat2) {
/* 516 */     if (this.x != paramFloat1 || this.y != paramFloat2) {
/* 517 */       this.x = paramFloat1;
/* 518 */       this.y = paramFloat2;
/* 519 */       positionChanged();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPosition(float paramFloat1, float paramFloat2, int paramInt) {
/* 526 */     if ((paramInt & 0x10) != 0) {
/* 527 */       paramFloat1 -= this.width;
/* 528 */     } else if ((paramInt & 0x8) == 0) {
/* 529 */       paramFloat1 -= this.width / 2.0F;
/*     */     } 
/* 531 */     if ((paramInt & 0x2) != 0) {
/* 532 */       paramFloat2 -= this.height;
/* 533 */     } else if ((paramInt & 0x4) == 0) {
/* 534 */       paramFloat2 -= this.height / 2.0F;
/*     */     } 
/* 536 */     if (this.x != paramFloat1 || this.y != paramFloat2) {
/* 537 */       this.x = paramFloat1;
/* 538 */       this.y = paramFloat2;
/* 539 */       positionChanged();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void moveBy(float paramFloat1, float paramFloat2) {
/* 545 */     if (paramFloat1 != 0.0F || paramFloat2 != 0.0F) {
/* 546 */       this.x += paramFloat1;
/* 547 */       this.y += paramFloat2;
/* 548 */       positionChanged();
/*     */     } 
/*     */   }
/*     */   
/*     */   public float getWidth() {
/* 553 */     return this.width;
/*     */   }
/*     */   
/*     */   public void setWidth(float paramFloat) {
/* 557 */     if (this.width != paramFloat) {
/* 558 */       this.width = paramFloat;
/* 559 */       sizeChanged();
/*     */     } 
/*     */   }
/*     */   
/*     */   public float getHeight() {
/* 564 */     return this.height;
/*     */   }
/*     */   
/*     */   public void setHeight(float paramFloat) {
/* 568 */     if (this.height != paramFloat) {
/* 569 */       this.height = paramFloat;
/* 570 */       sizeChanged();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public float getTop() {
/* 576 */     return this.y + this.height;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getRight() {
/* 581 */     return this.x + this.width;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void positionChanged() {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void sizeChanged() {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void scaleChanged() {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void rotationChanged() {}
/*     */ 
/*     */   
/*     */   public void setSize(float paramFloat1, float paramFloat2) {
/* 602 */     if (this.width != paramFloat1 || this.height != paramFloat2) {
/* 603 */       this.width = paramFloat1;
/* 604 */       this.height = paramFloat2;
/* 605 */       sizeChanged();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void sizeBy(float paramFloat) {
/* 611 */     if (paramFloat != 0.0F) {
/* 612 */       this.width += paramFloat;
/* 613 */       this.height += paramFloat;
/* 614 */       sizeChanged();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void sizeBy(float paramFloat1, float paramFloat2) {
/* 620 */     if (paramFloat1 != 0.0F || paramFloat2 != 0.0F) {
/* 621 */       this.width += paramFloat1;
/* 622 */       this.height += paramFloat2;
/* 623 */       sizeChanged();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBounds(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 629 */     if (this.x != paramFloat1 || this.y != paramFloat2) {
/* 630 */       this.x = paramFloat1;
/* 631 */       this.y = paramFloat2;
/* 632 */       positionChanged();
/*     */     } 
/* 634 */     if (this.width != paramFloat3 || this.height != paramFloat4) {
/* 635 */       this.width = paramFloat3;
/* 636 */       this.height = paramFloat4;
/* 637 */       sizeChanged();
/*     */     } 
/*     */   }
/*     */   
/*     */   public float getOriginX() {
/* 642 */     return this.originX;
/*     */   }
/*     */   
/*     */   public void setOriginX(float paramFloat) {
/* 646 */     this.originX = paramFloat;
/*     */   }
/*     */   
/*     */   public float getOriginY() {
/* 650 */     return this.originY;
/*     */   }
/*     */   
/*     */   public void setOriginY(float paramFloat) {
/* 654 */     this.originY = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setOrigin(float paramFloat1, float paramFloat2) {
/* 659 */     this.originX = paramFloat1;
/* 660 */     this.originY = paramFloat2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setOrigin(int paramInt) {
/* 665 */     if ((paramInt & 0x8) != 0) {
/* 666 */       this.originX = 0.0F;
/* 667 */     } else if ((paramInt & 0x10) != 0) {
/* 668 */       this.originX = this.width;
/*     */     } else {
/* 670 */       this.originX = this.width / 2.0F;
/*     */     } 
/* 672 */     if ((paramInt & 0x4) != 0) {
/* 673 */       this.originY = 0.0F; return;
/* 674 */     }  if ((paramInt & 0x2) != 0) {
/* 675 */       this.originY = this.height; return;
/*     */     } 
/* 677 */     this.originY = this.height / 2.0F;
/*     */   }
/*     */   
/*     */   public float getScaleX() {
/* 681 */     return this.scaleX;
/*     */   }
/*     */   
/*     */   public void setScaleX(float paramFloat) {
/* 685 */     if (this.scaleX != paramFloat) {
/* 686 */       this.scaleX = paramFloat;
/* 687 */       scaleChanged();
/*     */     } 
/*     */   }
/*     */   
/*     */   public float getScaleY() {
/* 692 */     return this.scaleY;
/*     */   }
/*     */   
/*     */   public void setScaleY(float paramFloat) {
/* 696 */     if (this.scaleY != paramFloat) {
/* 697 */       this.scaleY = paramFloat;
/* 698 */       scaleChanged();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setScale(float paramFloat) {
/* 704 */     if (this.scaleX != paramFloat || this.scaleY != paramFloat) {
/* 705 */       this.scaleX = paramFloat;
/* 706 */       this.scaleY = paramFloat;
/* 707 */       scaleChanged();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setScale(float paramFloat1, float paramFloat2) {
/* 713 */     if (this.scaleX != paramFloat1 || this.scaleY != paramFloat2) {
/* 714 */       this.scaleX = paramFloat1;
/* 715 */       this.scaleY = paramFloat2;
/* 716 */       scaleChanged();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void scaleBy(float paramFloat) {
/* 722 */     if (paramFloat != 0.0F) {
/* 723 */       this.scaleX += paramFloat;
/* 724 */       this.scaleY += paramFloat;
/* 725 */       scaleChanged();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void scaleBy(float paramFloat1, float paramFloat2) {
/* 731 */     if (paramFloat1 != 0.0F || paramFloat2 != 0.0F) {
/* 732 */       this.scaleX += paramFloat1;
/* 733 */       this.scaleY += paramFloat2;
/* 734 */       scaleChanged();
/*     */     } 
/*     */   }
/*     */   
/*     */   public float getRotation() {
/* 739 */     return this.rotation;
/*     */   }
/*     */   
/*     */   public void setRotation(float paramFloat) {
/* 743 */     if (this.rotation != paramFloat) {
/* 744 */       this.rotation = paramFloat;
/* 745 */       rotationChanged();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void rotateBy(float paramFloat) {
/* 751 */     if (paramFloat != 0.0F) {
/* 752 */       this.rotation = (this.rotation + paramFloat) % 360.0F;
/* 753 */       rotationChanged();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setColor(Color paramColor) {
/* 758 */     this.color.set(paramColor);
/*     */   }
/*     */   
/*     */   public void setColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 762 */     this.color.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */ 
/*     */   
/*     */   public Color getColor() {
/* 767 */     return this.color;
/*     */   }
/*     */ 
/*     */   
/*     */   @Null
/*     */   public String getName() {
/* 773 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setName(@Null String paramString) {
/* 780 */     this.name = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public void toFront() {
/* 785 */     setZIndex(2147483647);
/*     */   }
/*     */ 
/*     */   
/*     */   public void toBack() {
/* 790 */     setZIndex(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setZIndex(int paramInt) {
/* 798 */     if (paramInt < 0) throw new IllegalArgumentException("ZIndex cannot be < 0."); 
/*     */     Group group;
/* 800 */     if ((group = this.parent) == null) return false; 
/*     */     SnapshotArray<Actor> snapshotArray;
/* 802 */     if (((Array)(snapshotArray = group.children)).size <= 1) return false; 
/* 803 */     paramInt = Math.min(paramInt, ((Array)snapshotArray).size - 1);
/* 804 */     if (snapshotArray.get(paramInt) == this) return false; 
/* 805 */     if (!snapshotArray.removeValue(this, true)) return false; 
/* 806 */     snapshotArray.insert(paramInt, this);
/* 807 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getZIndex() {
/*     */     Group group;
/* 814 */     if ((group = this.parent) == null) return -1; 
/* 815 */     return group.children.indexOf(this, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean clipBegin() {
/* 820 */     return clipBegin(this.x, this.y, this.width, this.height);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean clipBegin(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 829 */     if (paramFloat3 <= 0.0F || paramFloat4 <= 0.0F) return false; 
/*     */     Stage stage;
/* 831 */     if ((stage = this.stage) == null) return false; 
/*     */     Rectangle rectangle2;
/* 833 */     (rectangle2 = Rectangle.tmp).x = paramFloat1;
/* 834 */     rectangle2.y = paramFloat2;
/* 835 */     rectangle2.width = paramFloat3;
/* 836 */     rectangle2.height = paramFloat4;
/* 837 */     Rectangle rectangle1 = (Rectangle)Pools.obtain(Rectangle.class);
/* 838 */     stage.calculateScissors(rectangle2, rectangle1);
/* 839 */     if (ScissorStack.pushScissors(rectangle1)) return true; 
/* 840 */     Pools.free(rectangle1);
/* 841 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void clipEnd() {
/* 846 */     Pools.free(ScissorStack.popScissors());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector2 screenToLocalCoordinates(Vector2 paramVector2) {
/*     */     Stage stage;
/* 853 */     if ((stage = this.stage) == null) return paramVector2; 
/* 854 */     return stageToLocalCoordinates(stage.screenToStageCoordinates(paramVector2));
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector2 stageToLocalCoordinates(Vector2 paramVector2) {
/* 859 */     if (this.parent != null) this.parent.stageToLocalCoordinates(paramVector2); 
/* 860 */     parentToLocalCoordinates(paramVector2);
/* 861 */     return paramVector2;
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector2 parentToLocalCoordinates(Vector2 paramVector2) {
/* 866 */     float f1 = this.rotation;
/* 867 */     float f2 = this.scaleX;
/* 868 */     float f3 = this.scaleY;
/* 869 */     float f4 = this.x;
/* 870 */     float f5 = this.y;
/* 871 */     if (f1 == 0.0F) {
/* 872 */       if (f2 == 1.0F && f3 == 1.0F) {
/* 873 */         paramVector2.x -= f4;
/* 874 */         paramVector2.y -= f5;
/*     */       } else {
/* 876 */         float f = this.originX;
/* 877 */         f1 = this.originY;
/* 878 */         paramVector2.x = (paramVector2.x - f4 - f) / f2 + f;
/* 879 */         paramVector2.y = (paramVector2.y - f5 - f1) / f3 + f1;
/*     */       } 
/*     */     } else {
/* 882 */       float f6 = (float)Math.cos((f1 * 0.017453292F));
/* 883 */       f1 = (float)Math.sin((f1 * 0.017453292F));
/* 884 */       float f7 = this.originX;
/* 885 */       float f8 = this.originY;
/* 886 */       f4 = paramVector2.x - f4 - f7;
/* 887 */       f5 = paramVector2.y - f5 - f8;
/* 888 */       paramVector2.x = (f4 * f6 + f5 * f1) / f2 + f7;
/* 889 */       paramVector2.y = (f4 * -f1 + f5 * f6) / f3 + f8;
/*     */     } 
/* 891 */     return paramVector2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector2 localToScreenCoordinates(Vector2 paramVector2) {
/*     */     Stage stage;
/* 898 */     if ((stage = this.stage) == null) return paramVector2; 
/* 899 */     return stage.stageToScreenCoordinates(localToAscendantCoordinates(null, paramVector2));
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector2 localToStageCoordinates(Vector2 paramVector2) {
/* 904 */     return localToAscendantCoordinates(null, paramVector2);
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector2 localToParentCoordinates(Vector2 paramVector2) {
/* 909 */     float f1 = -this.rotation;
/* 910 */     float f2 = this.scaleX;
/* 911 */     float f3 = this.scaleY;
/* 912 */     float f4 = this.x;
/* 913 */     float f5 = this.y;
/* 914 */     if (f1 == 0.0F) {
/* 915 */       if (f2 == 1.0F && f3 == 1.0F) {
/* 916 */         paramVector2.x += f4;
/* 917 */         paramVector2.y += f5;
/*     */       } else {
/* 919 */         float f = this.originX;
/* 920 */         f1 = this.originY;
/* 921 */         paramVector2.x = (paramVector2.x - f) * f2 + f + f4;
/* 922 */         paramVector2.y = (paramVector2.y - f1) * f3 + f1 + f5;
/*     */       } 
/*     */     } else {
/* 925 */       float f6 = (float)Math.cos((f1 * 0.017453292F));
/* 926 */       f1 = (float)Math.sin((f1 * 0.017453292F));
/* 927 */       float f7 = this.originX;
/* 928 */       float f8 = this.originY;
/* 929 */       f2 = (paramVector2.x - f7) * f2;
/* 930 */       f3 = (paramVector2.y - f8) * f3;
/* 931 */       paramVector2.x = f2 * f6 + f3 * f1 + f7 + f4;
/* 932 */       paramVector2.y = f2 * -f1 + f3 * f6 + f8 + f5;
/*     */     } 
/* 934 */     return paramVector2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector2 localToAscendantCoordinates(@Null Actor paramActor, Vector2 paramVector2) {
/* 940 */     Actor actor = this;
/*     */     while (true) {
/* 942 */       actor.localToParentCoordinates(paramVector2);
/*     */       
/* 944 */       if ((actor = actor.parent) == paramActor) return paramVector2; 
/* 945 */       if (actor == null)
/* 946 */         throw new IllegalArgumentException("Actor is not an ascendant: " + paramActor); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public Vector2 localToActorCoordinates(Actor paramActor, Vector2 paramVector2) {
/* 951 */     localToStageCoordinates(paramVector2);
/* 952 */     return paramActor.stageToLocalCoordinates(paramVector2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawDebug(ShapeRenderer paramShapeRenderer) {
/* 957 */     drawDebugBounds(paramShapeRenderer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void drawDebugBounds(ShapeRenderer paramShapeRenderer) {
/* 962 */     if (!this.debug)
/* 963 */       return;  paramShapeRenderer.set(ShapeRenderer.ShapeType.Line);
/* 964 */     if (this.stage != null) paramShapeRenderer.setColor(this.stage.getDebugColor()); 
/* 965 */     paramShapeRenderer.rect(this.x, this.y, this.originX, this.originY, this.width, this.height, this.scaleX, this.scaleY, this.rotation);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDebug(boolean paramBoolean) {
/* 970 */     this.debug = paramBoolean;
/* 971 */     if (paramBoolean) Stage.debug = true; 
/*     */   }
/*     */   
/*     */   public boolean getDebug() {
/* 975 */     return this.debug;
/*     */   }
/*     */ 
/*     */   
/*     */   public Actor debug() {
/* 980 */     setDebug(true);
/* 981 */     return this;
/*     */   }
/*     */   public String toString() {
/*     */     String str;
/*     */     int i;
/* 986 */     if ((str = this.name) == null && (
/*     */ 
/*     */       
/* 989 */       i = (str = getClass().getName()).lastIndexOf('.')) != -1) str = str.substring(i + 1);
/*     */     
/* 991 */     return str;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2d\Actor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */