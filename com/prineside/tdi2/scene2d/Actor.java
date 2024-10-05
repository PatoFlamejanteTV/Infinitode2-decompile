/*     */ package com.prineside.tdi2.scene2d;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
/*     */ import com.badlogic.gdx.math.Rectangle;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.Pools;
/*     */ import com.badlogic.gdx.utils.SnapshotArray;
/*     */ import com.badlogic.gdx.utils.reflect.ClassReflection;
/*     */ import com.prineside.tdi2.scene2d.utils.ScissorStack;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   protected Stage a;
/*     */   @Null
/*     */   protected Group b;
/*  60 */   private final DelayedRemovalArray<EventListener> j = new DelayedRemovalArray(0);
/*  61 */   private DelayedRemovalArray<EventListener> k = new DelayedRemovalArray(0);
/*  62 */   private Array<Action> l = new Array(0); @Null
/*     */   private String m; protected boolean c = true; private boolean o; private float p;
/*     */   private float q;
/*  65 */   private Touchable n = Touchable.enabled;
/*     */   private float r;
/*     */   private float s;
/*     */   protected float d;
/*     */   protected float e;
/*  70 */   protected float f = 1.0F; protected float g = 1.0F;
/*     */   protected float h;
/*  72 */   protected final Color i = new Color(1.0F, 1.0F, 1.0F, 1.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Null
/*     */   private Object t;
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
/*  93 */     if ((array = this.l).size == 0)
/*  94 */       return;  if (this.a != null && this.a.getActionsRequestRendering()) Gdx.graphics.requestRendering(); 
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
/*     */     //   1: invokevirtual getStage : ()Lcom/prineside/tdi2/scene2d/Stage;
/*     */     //   4: ifnonnull -> 15
/*     */     //   7: aload_1
/*     */     //   8: aload_0
/*     */     //   9: invokevirtual getStage : ()Lcom/prineside/tdi2/scene2d/Stage;
/*     */     //   12: invokevirtual setStage : (Lcom/prineside/tdi2/scene2d/Stage;)V
/*     */     //   15: aload_1
/*     */     //   16: aload_0
/*     */     //   17: invokevirtual setTarget : (Lcom/prineside/tdi2/scene2d/Actor;)V
/*     */     //   20: ldc com/badlogic/gdx/utils/Array
/*     */     //   22: invokestatic obtain : (Ljava/lang/Class;)Ljava/lang/Object;
/*     */     //   25: checkcast com/badlogic/gdx/utils/Array
/*     */     //   28: astore_2
/*     */     //   29: aload_0
/*     */     //   30: getfield b : Lcom/prineside/tdi2/scene2d/Group;
/*     */     //   33: astore_3
/*     */     //   34: aload_3
/*     */     //   35: ifnull -> 51
/*     */     //   38: aload_2
/*     */     //   39: aload_3
/*     */     //   40: invokevirtual add : (Ljava/lang/Object;)V
/*     */     //   43: aload_3
/*     */     //   44: getfield b : Lcom/prineside/tdi2/scene2d/Group;
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
/*     */     //   73: checkcast com/prineside/tdi2/scene2d/Group
/*     */     //   76: dup
/*     */     //   77: astore #5
/*     */     //   79: aload_1
/*     */     //   80: iconst_1
/*     */     //   81: invokevirtual notify : (Lcom/prineside/tdi2/scene2d/Event;Z)Z
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
/*     */     //   116: invokevirtual notify : (Lcom/prineside/tdi2/scene2d/Event;Z)Z
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
/*     */     //   147: invokevirtual notify : (Lcom/prineside/tdi2/scene2d/Event;Z)Z
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
/*     */     //   219: checkcast com/prineside/tdi2/scene2d/Group
/*     */     //   222: aload_1
/*     */     //   223: iconst_0
/*     */     //   224: invokevirtual notify : (Lcom/prineside/tdi2/scene2d/Event;Z)Z
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
/* 179 */     if ((delayedRemovalArray = paramBoolean ? this.k : this.j).size == 0) return paramEvent.isCancelled();
/*     */     
/* 181 */     paramEvent.setListenerActor(this);
/* 182 */     paramEvent.setCapture(paramBoolean);
/* 183 */     if (paramEvent.getStage() == null) paramEvent.setStage(this.a);
/*     */     
/*     */     try {
/* 186 */       delayedRemovalArray.begin(); int i;
/* 187 */       for (paramBoolean = false, i = delayedRemovalArray.size; paramBoolean < i; ) {
/* 188 */         if (((EventListener)delayedRemovalArray.get(paramBoolean)).handle(paramEvent)) paramEvent.handle(); 
/* 189 */         if (!paramEvent.isHalted()) {
/*     */           paramBoolean++;
/*     */         }
/*     */       } 
/* 193 */       delayedRemovalArray.end();
/* 194 */     } catch (RuntimeException runtimeException) {
/* 195 */       String str = toString();
/* 196 */       throw new RuntimeException("Actor: " + str.substring(0, Math.min(str.length(), 128)), runtimeException);
/*     */     } 
/*     */     
/* 199 */     return paramEvent.isCancelled();
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
/* 213 */     if (paramBoolean && this.n != Touchable.enabled) return null; 
/* 214 */     if (!isVisible()) return null; 
/* 215 */     return (paramFloat1 >= 0.0F && paramFloat1 < this.r && paramFloat2 >= 0.0F && paramFloat2 < this.s) ? this : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean remove() {
/* 221 */     if (this.b != null) return this.b.removeActor(this, true); 
/* 222 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addListener(EventListener paramEventListener) {
/* 229 */     if (paramEventListener == null) throw new IllegalArgumentException("listener cannot be null."); 
/* 230 */     if (!this.j.contains(paramEventListener, true)) {
/* 231 */       this.j.add(paramEventListener);
/* 232 */       return true;
/*     */     } 
/* 234 */     return false;
/*     */   }
/*     */   
/*     */   public boolean removeListener(EventListener paramEventListener) {
/* 238 */     if (paramEventListener == null) throw new IllegalArgumentException("listener cannot be null."); 
/* 239 */     return this.j.removeValue(paramEventListener, true);
/*     */   }
/*     */   
/*     */   public DelayedRemovalArray<EventListener> getListeners() {
/* 243 */     return this.j;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addCaptureListener(EventListener paramEventListener) {
/* 249 */     if (paramEventListener == null) throw new IllegalArgumentException("listener cannot be null."); 
/* 250 */     if (!this.k.contains(paramEventListener, true)) this.k.add(paramEventListener); 
/* 251 */     return true;
/*     */   }
/*     */   
/*     */   public boolean removeCaptureListener(EventListener paramEventListener) {
/* 255 */     if (paramEventListener == null) throw new IllegalArgumentException("listener cannot be null."); 
/* 256 */     return this.k.removeValue(paramEventListener, true);
/*     */   }
/*     */   
/*     */   public DelayedRemovalArray<EventListener> getCaptureListeners() {
/* 260 */     return this.k;
/*     */   }
/*     */   
/*     */   public void addAction(Action paramAction) {
/* 264 */     paramAction.setActor(this);
/* 265 */     this.l.add(paramAction);
/*     */     
/* 267 */     if (this.a != null && this.a.getActionsRequestRendering()) Gdx.graphics.requestRendering();
/*     */   
/*     */   }
/*     */   
/*     */   public void removeAction(@Null Action paramAction) {
/* 272 */     if (paramAction != null && this.l.removeValue(paramAction, true)) paramAction.setActor(null); 
/*     */   }
/*     */   
/*     */   public Array<Action> getActions() {
/* 276 */     return this.l;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasActions() {
/* 281 */     return (this.l.size > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clearActions() {
/* 286 */     for (int i = this.l.size - 1; i >= 0; i--)
/* 287 */       ((Action)this.l.get(i)).setActor(null); 
/* 288 */     this.l.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clearListeners() {
/* 293 */     this.j.clear();
/* 294 */     this.k.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 299 */     clearActions();
/* 300 */     clearListeners();
/*     */   }
/*     */   
/*     */   @Null
/*     */   public Stage getStage() {
/* 305 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void a(Stage paramStage) {
/* 311 */     this.a = paramStage;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDescendantOf(Actor paramActor) {
/* 316 */     if (paramActor == null) throw new IllegalArgumentException("actor cannot be null."); 
/* 317 */     Actor actor = this;
/*     */     while (true) {
/* 319 */       if (actor == paramActor) return true;
/*     */       
/* 321 */       if ((actor = actor.b) == null)
/* 322 */         return false; 
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isAscendantOf(Actor paramActor) {
/* 327 */     if (paramActor == null) throw new IllegalArgumentException("actor cannot be null."); 
/*     */     while (true) {
/* 329 */       if (paramActor == this) return true;
/*     */       
/* 331 */       if ((paramActor = paramActor.b) == null)
/* 332 */         return false; 
/*     */     } 
/*     */   }
/*     */   
/*     */   @Null
/*     */   public <T extends Actor> T firstAscendant(Class<T> paramClass) {
/* 338 */     if (paramClass == null) throw new IllegalArgumentException("actor cannot be null."); 
/* 339 */     Actor actor = this;
/*     */     while (true) {
/* 341 */       if (ClassReflection.isInstance(paramClass, actor)) return (T)actor;
/*     */       
/* 343 */       if ((actor = actor.b) == null)
/* 344 */         return null; 
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean hasParent() {
/* 349 */     return (this.b != null);
/*     */   }
/*     */   
/*     */   @Null
/*     */   public Group getParent() {
/* 354 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void a(@Null Group paramGroup) {
/* 360 */     this.b = paramGroup;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTouchable() {
/* 365 */     return (this.n == Touchable.enabled);
/*     */   }
/*     */   
/*     */   public Touchable getTouchable() {
/* 369 */     return this.n;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTouchable(Touchable paramTouchable) {
/* 374 */     this.n = paramTouchable;
/*     */   }
/*     */   
/*     */   public boolean isVisible() {
/* 378 */     return this.c;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setVisible(boolean paramBoolean) {
/* 383 */     this.c = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ascendantsVisible() {
/* 388 */     Actor actor = this;
/*     */     while (true) {
/* 390 */       if (!actor.isVisible()) return false;
/*     */       
/* 392 */       if ((actor = actor.b) == null)
/* 393 */         return true; 
/*     */     } 
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public boolean ancestorsVisible() {
/* 399 */     return ascendantsVisible();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasKeyboardFocus() {
/*     */     Stage stage;
/* 405 */     if ((stage = getStage()) != null && stage.getKeyboardFocus() == this) return true;  return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasScrollFocus() {
/*     */     Stage stage;
/* 411 */     if ((stage = getStage()) != null && stage.getScrollFocus() == this) return true;  return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTouchFocusTarget() {
/*     */     Stage stage;
/* 418 */     if ((stage = getStage()) == null) return false;  byte b; int i;
/* 419 */     for (b = 0, i = stage.b.size; b < i; b++) {
/* 420 */       if (((Stage.TouchFocus)stage.b.get(b)).c == this) return true; 
/* 421 */     }  return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTouchFocusListener() {
/*     */     Stage stage;
/* 428 */     if ((stage = getStage()) == null) return false;  byte b; int i;
/* 429 */     for (b = 0, i = stage.b.size; b < i; b++) {
/* 430 */       if (((Stage.TouchFocus)stage.b.get(b)).b == this) return true; 
/* 431 */     }  return false;
/*     */   }
/*     */   
/*     */   @Null
/*     */   public Object getUserObject() {
/* 436 */     return this.t;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setUserObject(@Null Object paramObject) {
/* 441 */     this.t = paramObject;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getX() {
/* 446 */     return this.p;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getX(int paramInt) {
/* 451 */     float f = this.p;
/* 452 */     if ((paramInt & 0x10) != 0) {
/* 453 */       f += this.r;
/* 454 */     } else if ((paramInt & 0x8) == 0) {
/* 455 */       f += this.r / 2.0F;
/* 456 */     }  return f;
/*     */   }
/*     */   
/*     */   public void setX(float paramFloat) {
/* 460 */     if (this.p != paramFloat) {
/* 461 */       this.p = paramFloat;
/* 462 */       positionChanged();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setX(float paramFloat, int paramInt) {
/* 470 */     if ((paramInt & 0x10) != 0) {
/* 471 */       paramFloat -= this.r;
/* 472 */     } else if ((paramInt & 0x8) == 0) {
/* 473 */       paramFloat -= this.r / 2.0F;
/*     */     } 
/* 475 */     if (this.p != paramFloat) {
/* 476 */       this.p = paramFloat;
/* 477 */       positionChanged();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public float getY() {
/* 483 */     return this.q;
/*     */   }
/*     */   
/*     */   public void setY(float paramFloat) {
/* 487 */     if (this.q != paramFloat) {
/* 488 */       this.q = paramFloat;
/* 489 */       positionChanged();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setY(float paramFloat, int paramInt) {
/* 497 */     if ((paramInt & 0x2) != 0) {
/* 498 */       paramFloat -= this.s;
/* 499 */     } else if ((paramInt & 0x4) == 0) {
/* 500 */       paramFloat -= this.s / 2.0F;
/*     */     } 
/* 502 */     if (this.q != paramFloat) {
/* 503 */       this.q = paramFloat;
/* 504 */       positionChanged();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public float getY(int paramInt) {
/* 510 */     float f = this.q;
/* 511 */     if ((paramInt & 0x2) != 0) {
/* 512 */       f += this.s;
/* 513 */     } else if ((paramInt & 0x4) == 0) {
/* 514 */       f += this.s / 2.0F;
/* 515 */     }  return f;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPosition(float paramFloat1, float paramFloat2) {
/* 520 */     if (this.p != paramFloat1 || this.q != paramFloat2) {
/* 521 */       this.p = paramFloat1;
/* 522 */       this.q = paramFloat2;
/* 523 */       positionChanged();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPosition(float paramFloat1, float paramFloat2, int paramInt) {
/* 530 */     if ((paramInt & 0x10) != 0) {
/* 531 */       paramFloat1 -= this.r;
/* 532 */     } else if ((paramInt & 0x8) == 0) {
/* 533 */       paramFloat1 -= this.r / 2.0F;
/*     */     } 
/* 535 */     if ((paramInt & 0x2) != 0) {
/* 536 */       paramFloat2 -= this.s;
/* 537 */     } else if ((paramInt & 0x4) == 0) {
/* 538 */       paramFloat2 -= this.s / 2.0F;
/*     */     } 
/* 540 */     if (this.p != paramFloat1 || this.q != paramFloat2) {
/* 541 */       this.p = paramFloat1;
/* 542 */       this.q = paramFloat2;
/* 543 */       positionChanged();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void moveBy(float paramFloat1, float paramFloat2) {
/* 549 */     if (paramFloat1 != 0.0F || paramFloat2 != 0.0F) {
/* 550 */       this.p += paramFloat1;
/* 551 */       this.q += paramFloat2;
/* 552 */       positionChanged();
/*     */     } 
/*     */   }
/*     */   
/*     */   public float getWidth() {
/* 557 */     return this.r;
/*     */   }
/*     */   
/*     */   public void setWidth(float paramFloat) {
/* 561 */     if (this.r != paramFloat) {
/* 562 */       this.r = paramFloat;
/* 563 */       sizeChanged();
/*     */     } 
/*     */   }
/*     */   
/*     */   public float getHeight() {
/* 568 */     return this.s;
/*     */   }
/*     */   
/*     */   public void setHeight(float paramFloat) {
/* 572 */     if (this.s != paramFloat) {
/* 573 */       this.s = paramFloat;
/* 574 */       sizeChanged();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public float getTop() {
/* 580 */     return this.q + this.s;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getRight() {
/* 585 */     return this.p + this.r;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void positionChanged() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void sizeChanged() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void a() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSize(float paramFloat1, float paramFloat2) {
/* 606 */     if (this.r != paramFloat1 || this.s != paramFloat2) {
/* 607 */       this.r = paramFloat1;
/* 608 */       this.s = paramFloat2;
/* 609 */       sizeChanged();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void sizeBy(float paramFloat) {
/* 615 */     if (paramFloat != 0.0F) {
/* 616 */       this.r += paramFloat;
/* 617 */       this.s += paramFloat;
/* 618 */       sizeChanged();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void sizeBy(float paramFloat1, float paramFloat2) {
/* 624 */     if (paramFloat1 != 0.0F || paramFloat2 != 0.0F) {
/* 625 */       this.r += paramFloat1;
/* 626 */       this.s += paramFloat2;
/* 627 */       sizeChanged();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBounds(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 633 */     if (this.p != paramFloat1 || this.q != paramFloat2) {
/* 634 */       this.p = paramFloat1;
/* 635 */       this.q = paramFloat2;
/* 636 */       positionChanged();
/*     */     } 
/* 638 */     if (this.r != paramFloat3 || this.s != paramFloat4) {
/* 639 */       this.r = paramFloat3;
/* 640 */       this.s = paramFloat4;
/* 641 */       sizeChanged();
/*     */     } 
/*     */   }
/*     */   
/*     */   public float getOriginX() {
/* 646 */     return this.d;
/*     */   }
/*     */   
/*     */   public void setOriginX(float paramFloat) {
/* 650 */     this.d = paramFloat;
/*     */   }
/*     */   
/*     */   public float getOriginY() {
/* 654 */     return this.e;
/*     */   }
/*     */   
/*     */   public void setOriginY(float paramFloat) {
/* 658 */     this.e = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setOrigin(float paramFloat1, float paramFloat2) {
/* 663 */     this.d = paramFloat1;
/* 664 */     this.e = paramFloat2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setOrigin(int paramInt) {
/* 669 */     if ((paramInt & 0x8) != 0) {
/* 670 */       this.d = 0.0F;
/* 671 */     } else if ((paramInt & 0x10) != 0) {
/* 672 */       this.d = this.r;
/*     */     } else {
/* 674 */       this.d = this.r / 2.0F;
/*     */     } 
/* 676 */     if ((paramInt & 0x4) != 0) {
/* 677 */       this.e = 0.0F; return;
/* 678 */     }  if ((paramInt & 0x2) != 0) {
/* 679 */       this.e = this.s; return;
/*     */     } 
/* 681 */     this.e = this.s / 2.0F;
/*     */   }
/*     */   
/*     */   public float getScaleX() {
/* 685 */     return this.f;
/*     */   }
/*     */   
/*     */   public void setScaleX(float paramFloat) {
/* 689 */     if (this.f != paramFloat) {
/* 690 */       this.f = paramFloat;
/* 691 */       a();
/*     */     } 
/*     */   }
/*     */   
/*     */   public float getScaleY() {
/* 696 */     return this.g;
/*     */   }
/*     */   
/*     */   public void setScaleY(float paramFloat) {
/* 700 */     if (this.g != paramFloat) {
/* 701 */       this.g = paramFloat;
/* 702 */       a();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setScale(float paramFloat) {
/* 708 */     if (this.f != paramFloat || this.g != paramFloat) {
/* 709 */       this.f = paramFloat;
/* 710 */       this.g = paramFloat;
/* 711 */       a();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setScale(float paramFloat1, float paramFloat2) {
/* 717 */     if (this.f != paramFloat1 || this.g != paramFloat2) {
/* 718 */       this.f = paramFloat1;
/* 719 */       this.g = paramFloat2;
/* 720 */       a();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void scaleBy(float paramFloat) {
/* 726 */     if (paramFloat != 0.0F) {
/* 727 */       this.f += paramFloat;
/* 728 */       this.g += paramFloat;
/* 729 */       a();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void scaleBy(float paramFloat1, float paramFloat2) {
/* 735 */     if (paramFloat1 != 0.0F || paramFloat2 != 0.0F) {
/* 736 */       this.f += paramFloat1;
/* 737 */       this.g += paramFloat2;
/* 738 */       a();
/*     */     } 
/*     */   }
/*     */   
/*     */   public float getRotation() {
/* 743 */     return this.h;
/*     */   }
/*     */   
/*     */   public void setRotation(float paramFloat) {
/* 747 */     if (this.h != paramFloat) {
/* 748 */       this.h = paramFloat;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void rotateBy(float paramFloat) {
/* 755 */     if (paramFloat != 0.0F) {
/* 756 */       this.h = (this.h + paramFloat) % 360.0F;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void setColor(Color paramColor) {
/* 762 */     this.i.set(paramColor);
/*     */   }
/*     */   
/*     */   public void setColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 766 */     this.i.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */ 
/*     */   
/*     */   public Color getColor() {
/* 771 */     return this.i;
/*     */   }
/*     */ 
/*     */   
/*     */   @Null
/*     */   public String getName() {
/* 777 */     return this.m;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setName(@Null String paramString) {
/* 784 */     this.m = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public void toFront() {
/* 789 */     setZIndex(2147483647);
/*     */   }
/*     */ 
/*     */   
/*     */   public void toBack() {
/* 794 */     setZIndex(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setZIndex(int paramInt) {
/* 802 */     if (paramInt < 0) throw new IllegalArgumentException("ZIndex cannot be < 0."); 
/*     */     Group group;
/* 804 */     if ((group = this.b) == null) return false; 
/*     */     SnapshotArray<Actor> snapshotArray;
/* 806 */     if (((Array)(snapshotArray = group.j)).size <= 1) return false; 
/* 807 */     paramInt = Math.min(paramInt, ((Array)snapshotArray).size - 1);
/* 808 */     if (snapshotArray.get(paramInt) == this) return false; 
/* 809 */     if (!snapshotArray.removeValue(this, true)) return false; 
/* 810 */     snapshotArray.insert(paramInt, this);
/* 811 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getZIndex() {
/*     */     Group group;
/* 818 */     if ((group = this.b) == null) return -1; 
/* 819 */     return group.j.indexOf(this, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean clipBegin() {
/* 824 */     return clipBegin(this.p, this.q, this.r, this.s);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean clipBegin(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 833 */     if (paramFloat3 <= 0.0F || paramFloat4 <= 0.0F) return false; 
/*     */     Stage stage;
/* 835 */     if ((stage = this.a) == null) return false; 
/*     */     Rectangle rectangle2;
/* 837 */     (rectangle2 = Rectangle.tmp).x = paramFloat1;
/* 838 */     rectangle2.y = paramFloat2;
/* 839 */     rectangle2.width = paramFloat3;
/* 840 */     rectangle2.height = paramFloat4;
/* 841 */     Rectangle rectangle1 = (Rectangle)Pools.obtain(Rectangle.class);
/* 842 */     stage.calculateScissors(rectangle2, rectangle1);
/* 843 */     if (ScissorStack.pushScissors(rectangle1)) return true; 
/* 844 */     Pools.free(rectangle1);
/* 845 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void clipEnd() {
/* 850 */     Pools.free(ScissorStack.popScissors());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector2 screenToLocalCoordinates(Vector2 paramVector2) {
/*     */     Stage stage;
/* 857 */     if ((stage = this.a) == null) return paramVector2; 
/* 858 */     return stageToLocalCoordinates(stage.screenToStageCoordinates(paramVector2));
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector2 stageToLocalCoordinates(Vector2 paramVector2) {
/* 863 */     if (this.b != null) this.b.stageToLocalCoordinates(paramVector2); 
/* 864 */     parentToLocalCoordinates(paramVector2);
/* 865 */     return paramVector2;
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector2 parentToLocalCoordinates(Vector2 paramVector2) {
/* 870 */     float f1 = this.h;
/* 871 */     float f2 = this.f;
/* 872 */     float f3 = this.g;
/* 873 */     float f4 = this.p;
/* 874 */     float f5 = this.q;
/* 875 */     if (f1 == 0.0F) {
/* 876 */       if (f2 == 1.0F && f3 == 1.0F) {
/* 877 */         paramVector2.x -= f4;
/* 878 */         paramVector2.y -= f5;
/*     */       } else {
/* 880 */         float f = this.d;
/* 881 */         f1 = this.e;
/* 882 */         paramVector2.x = (paramVector2.x - f4 - f) / f2 + f;
/* 883 */         paramVector2.y = (paramVector2.y - f5 - f1) / f3 + f1;
/*     */       } 
/*     */     } else {
/* 886 */       float f6 = (float)Math.cos((f1 * 0.017453292F));
/* 887 */       f1 = (float)Math.sin((f1 * 0.017453292F));
/* 888 */       float f7 = this.d;
/* 889 */       float f8 = this.e;
/* 890 */       f4 = paramVector2.x - f4 - f7;
/* 891 */       f5 = paramVector2.y - f5 - f8;
/* 892 */       paramVector2.x = (f4 * f6 + f5 * f1) / f2 + f7;
/* 893 */       paramVector2.y = (f4 * -f1 + f5 * f6) / f3 + f8;
/*     */     } 
/* 895 */     return paramVector2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector2 localToScreenCoordinates(Vector2 paramVector2) {
/*     */     Stage stage;
/* 902 */     if ((stage = this.a) == null) return paramVector2; 
/* 903 */     return stage.stageToScreenCoordinates(localToAscendantCoordinates(null, paramVector2));
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector2 localToStageCoordinates(Vector2 paramVector2) {
/* 908 */     return localToAscendantCoordinates(null, paramVector2);
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector2 localToParentCoordinates(Vector2 paramVector2) {
/* 913 */     float f1 = -this.h;
/* 914 */     float f2 = this.f;
/* 915 */     float f3 = this.g;
/* 916 */     float f4 = this.p;
/* 917 */     float f5 = this.q;
/* 918 */     if (f1 == 0.0F) {
/* 919 */       if (f2 == 1.0F && f3 == 1.0F) {
/* 920 */         paramVector2.x += f4;
/* 921 */         paramVector2.y += f5;
/*     */       } else {
/* 923 */         float f = this.d;
/* 924 */         f1 = this.e;
/* 925 */         paramVector2.x = (paramVector2.x - f) * f2 + f + f4;
/* 926 */         paramVector2.y = (paramVector2.y - f1) * f3 + f1 + f5;
/*     */       } 
/*     */     } else {
/* 929 */       float f6 = (float)Math.cos((f1 * 0.017453292F));
/* 930 */       f1 = (float)Math.sin((f1 * 0.017453292F));
/* 931 */       float f7 = this.d;
/* 932 */       float f8 = this.e;
/* 933 */       f2 = (paramVector2.x - f7) * f2;
/* 934 */       f3 = (paramVector2.y - f8) * f3;
/* 935 */       paramVector2.x = f2 * f6 + f3 * f1 + f7 + f4;
/* 936 */       paramVector2.y = f2 * -f1 + f3 * f6 + f8 + f5;
/*     */     } 
/* 938 */     return paramVector2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector2 localToAscendantCoordinates(@Null Actor paramActor, Vector2 paramVector2) {
/* 944 */     Actor actor = this;
/*     */     while (true) {
/* 946 */       actor.localToParentCoordinates(paramVector2);
/*     */       
/* 948 */       if ((actor = actor.b) == paramActor) return paramVector2; 
/* 949 */       if (actor == null)
/* 950 */         throw new IllegalArgumentException("Actor is not an ascendant: " + paramActor); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public Vector2 localToActorCoordinates(Actor paramActor, Vector2 paramVector2) {
/* 955 */     localToStageCoordinates(paramVector2);
/* 956 */     return paramActor.stageToLocalCoordinates(paramVector2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawDebug(ShapeRenderer paramShapeRenderer) {
/* 961 */     a(paramShapeRenderer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void a(ShapeRenderer paramShapeRenderer) {
/* 966 */     if (!this.o)
/* 967 */       return;  paramShapeRenderer.set(ShapeRenderer.ShapeType.Line);
/* 968 */     if (this.a != null) paramShapeRenderer.setColor(this.a.getDebugColor()); 
/* 969 */     paramShapeRenderer.rect(this.p, this.q, this.d, this.e, this.r, this.s, this.f, this.g, this.h);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDebug(boolean paramBoolean) {
/* 974 */     this.o = paramBoolean;
/* 975 */     if (paramBoolean) Stage.a = true; 
/*     */   }
/*     */   
/*     */   public boolean getDebug() {
/* 979 */     return this.o;
/*     */   }
/*     */ 
/*     */   
/*     */   public Actor debug() {
/* 984 */     setDebug(true);
/* 985 */     return this;
/*     */   }
/*     */   public String toString() {
/*     */     String str;
/*     */     int i;
/* 990 */     if ((str = this.m) == null && (
/*     */ 
/*     */       
/* 993 */       i = (str = getClass().getName()).lastIndexOf('.')) != -1) str = str.substring(i + 1);
/*     */     
/* 995 */     return str;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2d\Actor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */