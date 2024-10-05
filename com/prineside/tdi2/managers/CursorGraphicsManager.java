/*     */ package com.prineside.tdi2.managers;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Cursor;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Manager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.InputListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Disableable;
/*     */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*     */ import com.prineside.tdi2.utils.ObjectPair;
/*     */ import com.prineside.tdi2.utils.ObjectSupplier;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ public class CursorGraphicsManager
/*     */   extends Manager.ManagerAdapter
/*     */ {
/*     */   static {
/*  25 */     TLog.forClass(CursorGraphicsManager.class);
/*     */   }
/*     */   
/*     */   public static class Serializer extends SingletonSerializer<CursorGraphicsManager> { public CursorGraphicsManager read() {
/*  29 */       return Game.i.cursorGraphics;
/*     */     } }
/*     */   
/*  32 */   protected Array<ObjectPair<String, ObjectSupplier<Cursor.SystemCursor>>> a = new Array(true, 1, ObjectPair.class);
/*     */   private Cursor.SystemCursor b;
/*     */   
/*     */   public void setActorCustomMouseCursor(Actor paramActor, Cursor.SystemCursor paramSystemCursor) {
/*  36 */     setActorCustomMouseCursorConditional(paramActor, () -> paramSystemCursor);
/*     */   }
/*     */   
/*     */   public void setActorCustomMouseCursorConditional(Actor paramActor, ObjectSupplier<Cursor.SystemCursor> paramObjectSupplier) {
/*  40 */     String str = paramActor.getClass().getSimpleName() + "_" + Integer.toHexString(paramActor.hashCode());
/*     */     DelayedRemovalArray delayedRemovalArray;
/*  42 */     (delayedRemovalArray = paramActor.getCaptureListeners()).begin(); byte b; int i;
/*  43 */     for (b = 0, i = delayedRemovalArray.size; b < i; b++) {
/*  44 */       if (delayedRemovalArray.get(b) instanceof CustomCursorActorListener) {
/*  45 */         delayedRemovalArray.removeIndex(b);
/*     */       }
/*     */     } 
/*  48 */     delayedRemovalArray.end();
/*  49 */     paramActor.addCaptureListener((EventListener)new CustomCursorActorListener(str, paramObjectSupplier));
/*     */   }
/*     */   
/*     */   private void a(String paramString, ObjectSupplier<Cursor.SystemCursor> paramObjectSupplier) {
/*  53 */     Preconditions.checkNotNull(paramString, "Owner can not be null");
/*  54 */     Preconditions.checkNotNull(paramObjectSupplier, "Type can not be null");
/*     */     
/*  56 */     a(paramString);
/*  57 */     this.a.add((new ObjectPair()).set(paramString, paramObjectSupplier));
/*     */   }
/*     */   
/*     */   public boolean remove(String paramString) {
/*  61 */     return a(paramString);
/*     */   }
/*     */   
/*     */   public boolean contains(String paramString) {
/*  65 */     for (byte b = 0; b < this.a.size; b++) {
/*  66 */       if (((String)(((ObjectPair[])this.a.items)[b]).first).equals(paramString)) {
/*  67 */         return true;
/*     */       }
/*     */     } 
/*     */     
/*  71 */     return false;
/*     */   }
/*     */   
/*     */   private boolean a(String paramString) {
/*  75 */     for (byte b = 0; b < this.a.size; b++) {
/*  76 */       if (((String)(((ObjectPair[])this.a.items)[b]).first).equals(paramString)) {
/*  77 */         this.a.removeIndex(b);
/*  78 */         return true;
/*     */       } 
/*     */     } 
/*     */     
/*  82 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void preRender(float paramFloat) {
/*  87 */     a();
/*     */   }
/*     */   
/*     */   private void a() {
/*  91 */     Cursor.SystemCursor systemCursor = Cursor.SystemCursor.Arrow;
/*  92 */     if (this.a.size != 0) {
/*  93 */       systemCursor = (Cursor.SystemCursor)((ObjectSupplier)(((ObjectPair[])this.a.items)[this.a.size - 1]).second).get();
/*     */     }
/*     */     
/*  96 */     if (this.b != systemCursor) {
/*  97 */       Gdx.graphics.setSystemCursor(systemCursor);
/*  98 */       this.b = systemCursor;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static class CustomCursorActorListener extends InputListener {
/*     */     private String a;
/*     */     private ObjectSupplier<Cursor.SystemCursor> b;
/*     */     
/*     */     public CustomCursorActorListener(String param1String, ObjectSupplier<Cursor.SystemCursor> param1ObjectSupplier) {
/* 107 */       Preconditions.checkNotNull(param1String, "ownerId can not be null");
/* 108 */       Preconditions.checkNotNull(param1ObjectSupplier, "cursor can not be null");
/* 109 */       this.a = param1String;
/* 110 */       this.b = param1ObjectSupplier;
/*     */     }
/*     */ 
/*     */     
/*     */     public void enter(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, @Null Actor param1Actor) {
/* 115 */       if (param1Int != -1) {
/*     */         return;
/*     */       }
/* 118 */       if (param1InputEvent.getListenerActor() instanceof Disableable && (
/* 119 */         (Disableable)param1InputEvent.getListenerActor()).isDisabled())
/*     */         return; 
/* 121 */       CursorGraphicsManager.a(Game.i.cursorGraphics, this.a, this.b);
/*     */     }
/*     */ 
/*     */     
/*     */     public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, @Null Actor param1Actor) {
/* 126 */       if (param1Int != -1) {
/*     */         return;
/*     */       }
/* 129 */       Game.i.cursorGraphics.remove(this.a);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\CursorGraphicsManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */