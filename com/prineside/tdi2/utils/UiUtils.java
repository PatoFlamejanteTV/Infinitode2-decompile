/*     */ package com.prineside.tdi2.utils;
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.Pools;
/*     */ import com.badlogic.gdx.utils.SnapshotArray;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.InputListener;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
/*     */ import com.prineside.tdi2.scene2d.utils.Layout;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.events.MoveToFrontListener;
/*     */ 
/*     */ public class UiUtils {
/*     */   public static void finishActions(Actor paramActor, float paramFloat) {
/*  23 */     float f = 0.0F;
/*     */     
/*  25 */     while (f < paramFloat && 
/*  26 */       paramActor.hasActions()) {
/*  27 */       paramActor.act(0.033333335F);
/*  28 */       f += 0.033333335F;
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
/*     */   public static void bringToFront(Actor paramActor) {
/*     */     Group group;
/*  41 */     if ((group = paramActor.getParent()) == null) {
/*     */       return;
/*     */     }
/*  44 */     Array array = null;
/*  45 */     SnapshotArray snapshotArray = group.getChildren();
/*  46 */     boolean bool = false;
/*  47 */     for (byte b = 0; b < snapshotArray.size; b++) {
/*     */       Actor actor;
/*  49 */       if ((actor = ((Actor[])snapshotArray.items)[b]) == paramActor) {
/*  50 */         bool = true;
/*  51 */       } else if (bool) {
/*  52 */         if (array == null)
/*     */         {
/*  54 */           array = (Array)Pools.obtain(Array.class);
/*     */         }
/*  56 */         array.add(((Actor[])snapshotArray.items)[b]);
/*     */       } 
/*     */     } 
/*     */     
/*  60 */     if (array != null) {
/*  61 */       array.add(paramActor);
/*     */       
/*     */       MoveToFrontListener.MoveToFrontEvent moveToFrontEvent;
/*     */       
/*  65 */       (moveToFrontEvent = (MoveToFrontListener.MoveToFrontEvent)Pools.obtain(MoveToFrontListener.MoveToFrontEvent.class)).setStage(paramActor.getStage());
/*  66 */       moveToFrontEvent.setTarget(paramActor);
/*  67 */       for (Array.ArrayIterator<Actor> arrayIterator = array.iterator(); arrayIterator.hasNext();) {
/*  68 */         (actor = arrayIterator.next()).notify((Event)moveToFrontEvent, false);
/*     */       }
/*  70 */       array.clear();
/*  71 */       Pools.free(array);
/*     */       
/*  73 */       boolean bool1 = moveToFrontEvent.isCancelled();
/*  74 */       Pools.free(moveToFrontEvent);
/*     */       
/*  76 */       if (!bool1) {
/*     */         
/*  78 */         bool = false;
/*  79 */         for (byte b1 = 0; b1 < snapshotArray.size; b1++) {
/*     */           Actor actor;
/*  81 */           if ((actor = ((Actor[])snapshotArray.items)[b1]) == paramActor) {
/*  82 */             bool = true;
/*  83 */           } else if (bool) {
/*  84 */             ((Actor[])snapshotArray.items)[b1 - 1] = ((Actor[])snapshotArray.items)[b1];
/*     */           } 
/*     */         } 
/*  87 */         ((Actor[])snapshotArray.items)[snapshotArray.size - 1] = paramActor;
/*     */         
/*  89 */         if (group instanceof Layout) {
/*  90 */           ((Layout)group).invalidateHierarchy();
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static boolean hasParent(Actor paramActor, Group paramGroup) {
/*  97 */     if (paramActor == null) throw new IllegalArgumentException("Actor is null"); 
/*  98 */     if (paramGroup == null) throw new IllegalArgumentException("Patent is null");
/*     */     
/* 100 */     paramActor = paramActor;
/* 101 */     while (paramActor.hasParent()) {
/*     */       Group group;
/* 103 */       if ((group = paramActor.getParent()) == paramGroup) return true;
/*     */     
/*     */     } 
/* 106 */     return false;
/*     */   }
/*     */   
/*     */   private static void a(Actor paramActor, StringBuilder paramStringBuilder) {
/* 110 */     if (paramActor == null) throw new IllegalArgumentException("Actor is null"); 
/* 111 */     if (paramStringBuilder == null) throw new IllegalArgumentException("sb is null");
/*     */     
/* 113 */     paramStringBuilder.append("- ").append(paramActor.getName()).append(" (").append(paramActor.getClass().getSimpleName()).append(")");
/* 114 */     if (paramActor instanceof Label) {
/* 115 */       Label label = (Label)paramActor;
/* 116 */       paramStringBuilder.append(", text: ").append(label.getText());
/*     */     } 
/* 118 */     paramStringBuilder.append("\n");
/* 119 */     if (paramActor.hasParent()) {
/* 120 */       a((Actor)paramActor.getParent(), paramStringBuilder);
/*     */     }
/*     */   }
/*     */   
/*     */   public static StringBuilder getFullPathToStage(Actor paramActor) {
/* 125 */     if (paramActor == null) throw new IllegalArgumentException("Actor is null");
/*     */     
/* 127 */     StringBuilder stringBuilder = new StringBuilder();
/* 128 */     a(paramActor, stringBuilder);
/*     */     
/* 130 */     return stringBuilder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void enableMouseMoveScrollFocus(ScrollPane paramScrollPane) {
/* 138 */     paramScrollPane.addListener((EventListener)new InputListener(paramScrollPane)
/*     */         {
/*     */           public void enter(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, @Null Actor param1Actor) {
/* 141 */             if (this.a.getStage() != null) this.a.getStage().setScrollFocus((Actor)this.a);
/*     */           
/*     */           }
/*     */           
/*     */           public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, @Null Actor param1Actor) {
/* 146 */             if (this.a.getStage() != null && this.a.getStage().getScrollFocus() == this.a) {
/* 147 */               this.a.getStage().setScrollFocus(null);
/*     */             }
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isVisibleRecursive(Actor paramActor) {
/* 157 */     if (paramActor == null) throw new IllegalArgumentException("Actor is null");
/*     */     
/* 159 */     if (!paramActor.isVisible()) return false; 
/* 160 */     if (paramActor.getStage() == null) return false;
/*     */     
/*     */     Group group;
/* 163 */     if ((group = paramActor.getParent()) != null) {
/* 164 */       return isVisibleRecursive((Actor)group);
/*     */     }
/*     */     
/* 167 */     return true;
/*     */   }
/*     */   
/*     */   public static void bouncyShowOverlay(Actor paramActor1, Actor paramActor2, Group paramGroup) {
/* 171 */     bouncyShowOverlayWithCallback(paramActor1, paramActor2, paramGroup, null);
/*     */   }
/*     */   
/*     */   public static void bouncyShowOverlayWithCallback(Actor paramActor1, Actor paramActor2, Group paramGroup, Runnable paramRunnable) {
/* 175 */     float f = Game.i.settingsManager.isUiAnimationsEnabled() ? 1.5F : 0.0F;
/*     */ 
/*     */     
/* 178 */     if (paramActor1 != null) {
/* 179 */       paramActor1.setTouchable(Touchable.enabled);
/* 180 */       paramActor1.clearActions();
/* 181 */       paramActor1.addAction((Action)Actions.sequence(
/* 182 */             (Action)Actions.show(), 
/* 183 */             (Action)Actions.fadeIn(0.15F * f)));
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 188 */     if (paramActor2 != null) {
/* 189 */       paramActor2.setVisible(true);
/*     */     }
/*     */     
/* 192 */     paramGroup.clearActions();
/* 193 */     paramGroup.setTouchable(Touchable.enabled);
/* 194 */     paramGroup.setTransform(true);
/* 195 */     paramGroup.addAction((Action)Actions.sequence(
/* 196 */           (Action)Actions.scaleTo(0.0F, 1.1F), 
/* 197 */           (Action)Actions.moveTo(0.0F, -Game.i.settingsManager.getScaledViewportHeight()), 
/* 198 */           (Action)Actions.parallel(
/* 199 */             (Action)Actions.sequence(
/* 200 */               (Action)Actions.moveTo(0.0F, Game.i.settingsManager.getScaledViewportHeight() * 0.05F, 0.15F * f, (Interpolation)Interpolation.pow4Out), 
/* 201 */               (Action)Actions.moveTo(0.0F, 0.0F, 0.07F * f, (Interpolation)Interpolation.pow2)), 
/*     */             
/* 203 */             (Action)Actions.sequence(
/* 204 */               (Action)Actions.scaleBy(1.1F, 0.0F, 0.15F * f, (Interpolation)Interpolation.pow2Out), 
/* 205 */               (Action)Actions.scaleBy(-0.1F, 0.0F, 0.07F * f, (Interpolation)Interpolation.pow2)), 
/*     */             
/* 207 */             (Action)Actions.sequence(
/* 208 */               (Action)Actions.scaleBy(0.0F, -0.2F, 0.15F * f, (Interpolation)Interpolation.pow2Out), 
/* 209 */               (Action)Actions.scaleBy(0.0F, 0.1F, 0.07F * f, (Interpolation)Interpolation.pow2))), 
/*     */ 
/*     */           
/* 212 */           (Action)Actions.run(() -> {
/*     */               paramGroup.setTransform(false);
/*     */               if (paramRunnable != null)
/*     */                 paramRunnable.run(); 
/*     */             })));
/*     */   }
/*     */   
/*     */   public static void bouncyHideOverlay(Actor paramActor1, Actor paramActor2, Group paramGroup) {
/* 220 */     bouncyHideOverlayWithCallback(paramActor1, paramActor2, paramGroup, null);
/*     */   }
/*     */   
/*     */   public static void bouncyHideOverlayWithCallback(Actor paramActor1, Actor paramActor2, Group paramGroup, Runnable paramRunnable) {
/* 224 */     float f = Game.i.settingsManager.isUiAnimationsEnabled() ? 1.5F : 0.0F;
/*     */     
/* 226 */     if (paramActor1 != null) {
/* 227 */       paramActor1.setTouchable(Touchable.disabled);
/* 228 */       paramActor1.clearActions();
/* 229 */       paramActor1.addAction((Action)Actions.sequence(
/* 230 */             (Action)Actions.fadeOut(0.15F * f), 
/* 231 */             (Action)Actions.hide()));
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 236 */     paramGroup.clearActions();
/* 237 */     paramGroup.setTouchable(Touchable.disabled);
/* 238 */     paramGroup.setTransform(true);
/* 239 */     paramGroup.addAction((Action)Actions.sequence(
/* 240 */           (Action)Actions.parallel(
/* 241 */             (Action)Actions.sequence(
/* 242 */               (Action)Actions.delay(0.12F * f), 
/* 243 */               (Action)Actions.moveTo(0.0F, -Game.i.settingsManager.getScaledViewportHeight(), 0.16F * f, Interpolation.sineIn)), 
/*     */             
/* 245 */             (Action)Actions.sequence(
/* 246 */               (Action)Actions.scaleBy(-paramGroup.getScaleX(), 0.0F, 0.17F * f, (Interpolation)Interpolation.swingIn)), 
/*     */             
/* 248 */             (Action)Actions.sequence(
/* 249 */               (Action)Actions.scaleBy(0.0F, -paramGroup.getScaleY() * 0.1F, 0.05F * f, (Interpolation)Interpolation.pow2), 
/* 250 */               (Action)Actions.scaleBy(0.0F, paramGroup.getScaleY() * 0.2F, 0.11F * f, (Interpolation)Interpolation.pow2), 
/* 251 */               (Action)Actions.scaleBy(0.0F, -paramGroup.getScaleY() * 1.1F, 0.11F * f, (Interpolation)Interpolation.pow2In))), 
/*     */ 
/*     */           
/* 254 */           (Action)Actions.run(() -> {
/*     */               if (paramActor != null)
/*     */                 paramActor.setVisible(false); 
/*     */               if (paramRunnable != null)
/*     */                 paramRunnable.run(); 
/*     */             })));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\UiUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */