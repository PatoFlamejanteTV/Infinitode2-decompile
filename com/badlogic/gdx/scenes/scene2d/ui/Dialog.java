/*     */ package com.badlogic.gdx.scenes.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.badlogic.gdx.scenes.scene2d.Action;
/*     */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*     */ import com.badlogic.gdx.scenes.scene2d.EventListener;
/*     */ import com.badlogic.gdx.scenes.scene2d.Group;
/*     */ import com.badlogic.gdx.scenes.scene2d.InputEvent;
/*     */ import com.badlogic.gdx.scenes.scene2d.InputListener;
/*     */ import com.badlogic.gdx.scenes.scene2d.Stage;
/*     */ import com.badlogic.gdx.scenes.scene2d.actions.Actions;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.FocusListener;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Dialog
/*     */   extends Window
/*     */ {
/*     */   Table contentTable;
/*     */   Table buttonTable;
/*     */   @Null
/*     */   private Skin skin;
/*  44 */   ObjectMap<Actor, Object> values = new ObjectMap();
/*     */   
/*     */   boolean cancelHide;
/*     */   Actor previousKeyboardFocus;
/*     */   
/*  49 */   protected InputListener ignoreTouchDown = new InputListener() {
/*     */       public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  51 */         param1InputEvent.cancel();
/*  52 */         return false;
/*     */       }
/*     */     };
/*     */   Actor previousScrollFocus; FocusListener focusListener;
/*     */   public Dialog(String paramString, Skin paramSkin) {
/*  57 */     super(paramString, paramSkin.<Window.WindowStyle>get(Window.WindowStyle.class));
/*  58 */     setSkin(paramSkin);
/*  59 */     this.skin = paramSkin;
/*  60 */     initialize();
/*     */   }
/*     */   
/*     */   public Dialog(String paramString1, Skin paramSkin, String paramString2) {
/*  64 */     super(paramString1, paramSkin.<Window.WindowStyle>get(paramString2, Window.WindowStyle.class));
/*  65 */     setSkin(paramSkin);
/*  66 */     this.skin = paramSkin;
/*  67 */     initialize();
/*     */   }
/*     */   
/*     */   public Dialog(String paramString, Window.WindowStyle paramWindowStyle) {
/*  71 */     super(paramString, paramWindowStyle);
/*  72 */     initialize();
/*     */   }
/*     */   
/*     */   private void initialize() {
/*  76 */     setModal(true);
/*     */     
/*  78 */     defaults().space(6.0F);
/*  79 */     add(this.contentTable = new Table(this.skin)).expand().fill();
/*  80 */     row();
/*  81 */     add(this.buttonTable = new Table(this.skin)).fillX();
/*     */     
/*  83 */     this.contentTable.defaults().space(6.0F);
/*  84 */     this.buttonTable.defaults().space(6.0F);
/*     */     
/*  86 */     this.buttonTable.addListener((EventListener)new ChangeListener() { public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*     */             Group group;
/*  88 */             if (!Dialog.this.values.containsKey(param1Actor))
/*  89 */               return;  while (param1Actor.getParent() != Dialog.this.buttonTable)
/*  90 */               group = param1Actor.getParent(); 
/*  91 */             Dialog.this.result(Dialog.this.values.get(group));
/*  92 */             if (!Dialog.this.cancelHide) Dialog.this.hide(); 
/*  93 */             Dialog.this.cancelHide = false;
/*     */           } }
/*     */       );
/*     */     
/*  97 */     this.focusListener = new FocusListener() {
/*     */         public void keyboardFocusChanged(FocusListener.FocusEvent param1FocusEvent, Actor param1Actor, boolean param1Boolean) {
/*  99 */           if (!param1Boolean) focusChanged(param1FocusEvent); 
/*     */         }
/*     */         
/*     */         public void scrollFocusChanged(FocusListener.FocusEvent param1FocusEvent, Actor param1Actor, boolean param1Boolean) {
/* 103 */           if (!param1Boolean) focusChanged(param1FocusEvent); 
/*     */         }
/*     */         
/*     */         private void focusChanged(FocusListener.FocusEvent param1FocusEvent) {
/* 107 */           Stage stage = Dialog.this.getStage(); Actor actor;
/* 108 */           if (Dialog.this.isModal && stage != null && (stage.getRoot().getChildren()).size > 0 && stage
/* 109 */             .getRoot().getChildren().peek() == Dialog.this && (
/*     */             
/* 111 */             actor = param1FocusEvent.getRelatedActor()) != null && !actor.isDescendantOf((Actor)Dialog.this) && 
/* 112 */             !actor.equals(Dialog.this.previousKeyboardFocus) && !actor.equals(Dialog.this.previousScrollFocus)) {
/* 113 */             param1FocusEvent.cancel();
/*     */           }
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   protected void setStage(Stage paramStage) {
/* 120 */     if (paramStage == null) {
/* 121 */       addListener((EventListener)this.focusListener);
/*     */     } else {
/* 123 */       removeListener((EventListener)this.focusListener);
/* 124 */     }  super.setStage(paramStage);
/*     */   }
/*     */   
/*     */   public Table getContentTable() {
/* 128 */     return this.contentTable;
/*     */   }
/*     */   
/*     */   public Table getButtonTable() {
/* 132 */     return this.buttonTable;
/*     */   }
/*     */ 
/*     */   
/*     */   public Dialog text(@Null String paramString) {
/* 137 */     if (this.skin == null)
/* 138 */       throw new IllegalStateException("This method may only be used if the dialog was constructed with a Skin."); 
/* 139 */     return text(paramString, this.skin.<Label.LabelStyle>get(Label.LabelStyle.class));
/*     */   }
/*     */ 
/*     */   
/*     */   public Dialog text(@Null String paramString, Label.LabelStyle paramLabelStyle) {
/* 144 */     return text(new Label(paramString, paramLabelStyle));
/*     */   }
/*     */ 
/*     */   
/*     */   public Dialog text(Label paramLabel) {
/* 149 */     this.contentTable.add(paramLabel);
/* 150 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Dialog button(@Null String paramString) {
/* 156 */     return button(paramString, (Object)null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Dialog button(@Null String paramString, @Null Object paramObject) {
/* 162 */     if (this.skin == null)
/* 163 */       throw new IllegalStateException("This method may only be used if the dialog was constructed with a Skin."); 
/* 164 */     return button(paramString, paramObject, this.skin.<TextButton.TextButtonStyle>get(TextButton.TextButtonStyle.class));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Dialog button(@Null String paramString, @Null Object paramObject, TextButton.TextButtonStyle paramTextButtonStyle) {
/* 170 */     return button(new TextButton(paramString, paramTextButtonStyle), paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public Dialog button(Button paramButton) {
/* 175 */     return button(paramButton, (Object)null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Dialog button(Button paramButton, @Null Object paramObject) {
/* 181 */     this.buttonTable.add(paramButton);
/* 182 */     setObject((Actor)paramButton, paramObject);
/* 183 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Dialog show(Stage paramStage, @Null Action paramAction) {
/* 191 */     clearActions();
/* 192 */     removeCaptureListener((EventListener)this.ignoreTouchDown);
/*     */     
/* 194 */     this.previousKeyboardFocus = null;
/*     */     Actor actor;
/* 196 */     if ((actor = paramStage.getKeyboardFocus()) != null && !actor.isDescendantOf((Actor)this)) this.previousKeyboardFocus = actor;
/*     */     
/* 198 */     this.previousScrollFocus = null;
/*     */     
/* 200 */     if ((actor = paramStage.getScrollFocus()) != null && !actor.isDescendantOf((Actor)this)) this.previousScrollFocus = actor;
/*     */     
/* 202 */     paramStage.addActor((Actor)this);
/* 203 */     pack();
/* 204 */     paramStage.cancelTouchFocus();
/* 205 */     paramStage.setKeyboardFocus((Actor)this);
/* 206 */     paramStage.setScrollFocus((Actor)this);
/* 207 */     if (paramAction != null) addAction(paramAction);
/*     */     
/* 209 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Dialog show(Stage paramStage) {
/* 215 */     show(paramStage, (Action)Actions.sequence((Action)Actions.alpha(0.0F), (Action)Actions.fadeIn(0.4F, Interpolation.fade)));
/* 216 */     setPosition(Math.round((paramStage.getWidth() - getWidth()) / 2.0F), Math.round((paramStage.getHeight() - getHeight()) / 2.0F));
/* 217 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hide(@Null Action paramAction) {
/*     */     Stage stage;
/* 226 */     if ((stage = getStage()) != null) {
/* 227 */       removeListener((EventListener)this.focusListener);
/* 228 */       if (this.previousKeyboardFocus != null && this.previousKeyboardFocus.getStage() == null) this.previousKeyboardFocus = null; 
/*     */       Actor actor;
/* 230 */       if ((actor = stage.getKeyboardFocus()) == null || actor.isDescendantOf((Actor)this)) stage.setKeyboardFocus(this.previousKeyboardFocus);
/*     */       
/* 232 */       if (this.previousScrollFocus != null && this.previousScrollFocus.getStage() == null) this.previousScrollFocus = null;
/*     */       
/* 234 */       if ((actor = stage.getScrollFocus()) == null || actor.isDescendantOf((Actor)this)) stage.setScrollFocus(this.previousScrollFocus); 
/*     */     } 
/* 236 */     if (paramAction != null) {
/* 237 */       addCaptureListener((EventListener)this.ignoreTouchDown);
/* 238 */       addAction((Action)Actions.sequence(paramAction, (Action)Actions.removeListener((EventListener)this.ignoreTouchDown, true), (Action)Actions.removeActor())); return;
/*     */     } 
/* 240 */     remove();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hide() {
/* 246 */     hide((Action)Actions.fadeOut(0.4F, Interpolation.fade));
/*     */   }
/*     */   
/*     */   public void setObject(Actor paramActor, @Null Object paramObject) {
/* 250 */     this.values.put(paramActor, paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Dialog key(final int keycode, @Null final Object object) {
/* 256 */     addListener((EventListener)new InputListener() {
/*     */           public boolean keyDown(InputEvent param1InputEvent, int param1Int) {
/* 258 */             if (keycode == param1Int)
/*     */             {
/* 260 */               Gdx.app.postRunnable(new Runnable() {
/*     */                     public void run() {
/* 262 */                       Dialog.this.result(object);
/* 263 */                       if (!Dialog.this.cancelHide) Dialog.this.hide(); 
/* 264 */                       Dialog.this.cancelHide = false;
/*     */                     }
/*     */                   });
/*     */             }
/* 268 */             return false;
/*     */           }
/*     */         });
/* 271 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void result(@Null Object paramObject) {}
/*     */ 
/*     */   
/*     */   public void cancel() {
/* 280 */     this.cancelHide = true;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\ui\Dialog.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */