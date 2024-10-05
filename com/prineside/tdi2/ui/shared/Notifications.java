/*     */ package com.prineside.tdi2.ui.shared;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.scene2d.actions.DelayAction;
/*     */ import com.prineside.tdi2.scene2d.actions.SequenceAction;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.QuadActor;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ 
/*     */ public class Notifications extends Group implements UiManager.UiComponent {
/*     */   public static final float DEFAULT_SHOW_DURATION = 5.0F;
/*     */   public static final float CONTENT_WIDTH = 340.0F;
/*     */   
/*     */   public static Notifications i() {
/*  32 */     return (Notifications)Game.i.uiManager.getComponent(Notifications.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final float CONTENT_MARGIN_LEFT = 106.0F;
/*     */ 
/*     */   
/*     */   public static final float CONTENT_MARGIN_BOTTOM = 20.0F;
/*     */ 
/*     */   
/*  44 */   private final UiManager.UiLayer k = Game.i.uiManager.addLayer(UiManager.MainUiLayer.OVERLAY, 300, "Notifications");
/*  45 */   private final Label.LabelStyle l = new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE);
/*     */   
/*     */   private final Group m;
/*  48 */   private final DelayedRemovalArray<Notification> n = new DelayedRemovalArray(true, 1, Notification.class);
/*     */ 
/*     */   
/*  51 */   private static Color o = new Color();
/*     */   
/*     */   public Notifications() {
/*     */     Table table;
/*  55 */     (table = this.k.getTable()).setTouchable(Touchable.childrenOnly);
/*     */     
/*  57 */     this.m = new Group();
/*  58 */     this.m.setTouchable(Touchable.childrenOnly);
/*  59 */     table.add((Actor)this.m).expand().top().left().padTop(160.0F).width(460.0F);
/*     */   }
/*     */   
/*     */   private Notification a(Notification paramNotification, float paramFloat) {
/*  63 */     Game.i.assertInMainThread();
/*     */     
/*  65 */     this.n.add(paramNotification);
/*  66 */     this.m.addActor((Actor)paramNotification);
/*     */     
/*  68 */     paramNotification.status = 1;
/*  69 */     paramNotification.setPosition(0.0F, getHeight());
/*  70 */     paramNotification.setVisible(true);
/*  71 */     paramNotification.addAction((Action)Actions.sequence(
/*  72 */           (Action)Actions.alpha(0.0F), 
/*  73 */           (Action)Actions.parallel(
/*  74 */             (Action)Actions.alpha(1.0F, 0.3F), 
/*  75 */             (Action)Actions.sizeTo(paramNotification.getWidth(), paramNotification.notificationHeight, 0.3F), 
/*  76 */             (Action)Actions.moveBy(0.0F, -paramNotification.notificationHeight, 0.3F)), 
/*     */           
/*  78 */           (Action)Actions.run(() -> paramNotification.status = 2), 
/*     */ 
/*     */           
/*  81 */           (Action)Actions.delay(paramFloat), 
/*  82 */           (Action)Actions.run(() -> a(paramNotification))));
/*     */ 
/*     */     
/*     */     byte b;
/*     */ 
/*     */     
/*  88 */     for (b = 0; b < this.n.size - 1; b++) {
/*     */       Notification notification;
/*  90 */       (notification = (Notification)this.n.get(b)).addAction((Action)Actions.moveBy(0.0F, -paramNotification.notificationHeight, 0.3F));
/*     */     } 
/*     */ 
/*     */     
/*  94 */     for (b = 0; b < this.n.size - 1 - 7; b++) {
/*  95 */       Notification notification = (Notification)this.n.get(b);
/*  96 */       a(notification);
/*     */     } 
/*     */     
/*  99 */     return paramNotification;
/*     */   }
/*     */   public Notification addWithContents(Table paramTable, Drawable paramDrawable, Color paramColor, StaticSoundType paramStaticSoundType, float paramFloat) {
/*     */     TextureRegionDrawable textureRegionDrawable;
/* 103 */     if (paramColor == null) {
/* 104 */       paramColor = MaterialColor.BLUE_GREY.P800;
/*     */     }
/* 106 */     o.set(paramColor);
/* 107 */     if (o.a > 0.85F) {
/* 108 */       o.a = 0.85F;
/*     */     }
/*     */     
/* 111 */     if (paramDrawable == null) {
/* 112 */       textureRegionDrawable = Game.i.assetManager.getDrawable("icon-info");
/*     */     }
/*     */     
/* 115 */     Notification notification = new Notification(paramTable, (Drawable)textureRegionDrawable, o, (byte)0);
/* 116 */     a(notification, paramFloat);
/* 117 */     if (paramStaticSoundType != null) Game.i.soundManager.playStatic(paramStaticSoundType);
/*     */     
/* 119 */     return notification;
/*     */   }
/*     */   
/*     */   public Notification addInfo(CharSequence paramCharSequence) {
/* 123 */     return add(paramCharSequence, (Drawable)null, (Color)null, (StaticSoundType)null);
/*     */   }
/*     */   
/*     */   public Notification add(CharSequence paramCharSequence, Drawable paramDrawable, Color paramColor, StaticSoundType paramStaticSoundType) {
/* 127 */     return addForDuration(paramCharSequence, paramDrawable, paramColor, paramStaticSoundType, 5.0F);
/*     */   }
/*     */   
/*     */   public Notification addFailure(CharSequence paramCharSequence) {
/* 131 */     return add(paramCharSequence, (Drawable)Game.i.assetManager.getDrawable("icon-times"), MaterialColor.RED.P800, StaticSoundType.FAIL);
/*     */   }
/*     */   
/*     */   public Notification addSuccess(CharSequence paramCharSequence) {
/* 135 */     return add(paramCharSequence, (Drawable)Game.i.assetManager.getDrawable("icon-check"), MaterialColor.GREEN.P800, StaticSoundType.SUCCESS);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Notification addForDuration(CharSequence paramCharSequence, Drawable paramDrawable, Color paramColor, StaticSoundType paramStaticSoundType, float paramFloat) {
/*     */     TextureRegionDrawable textureRegionDrawable;
/* 142 */     if (paramColor == null) {
/* 143 */       paramColor = MaterialColor.BLUE_GREY.P800;
/*     */     }
/* 145 */     o.set(paramColor);
/* 146 */     if (o.a > 0.85F) {
/* 147 */       o.a = 0.85F;
/*     */     }
/*     */     
/* 150 */     if (paramDrawable == null) {
/* 151 */       textureRegionDrawable = Game.i.assetManager.getDrawable("icon-info");
/*     */     }
/*     */     
/* 154 */     Notification notification = new Notification(paramCharSequence, (Drawable)textureRegionDrawable, o, (byte)0);
/* 155 */     a(notification, paramFloat);
/*     */     
/* 157 */     if (paramStaticSoundType != null) Game.i.soundManager.playStatic(paramStaticSoundType);
/*     */     
/* 159 */     return notification;
/*     */   }
/*     */   
/*     */   public void hideNotification(String paramString) {
/* 163 */     Preconditions.checkNotNull(paramString);
/* 164 */     Game.i.assertInMainThread();
/* 165 */     for (byte b = 0; b < this.n.size; b++) {
/* 166 */       if (paramString.equals(((Notification)this.n.get(b)).id) && ((Notification)this.n.get(b)).status != 3) {
/* 167 */         a((Notification)this.n.get(b));
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void a(Notification paramNotification) {
/* 174 */     Game.i.assertInMainThread();
/* 175 */     if (paramNotification.status != 3) {
/* 176 */       paramNotification.status = 3;
/* 177 */       paramNotification.clearActions();
/* 178 */       paramNotification.addAction((Action)Actions.sequence(
/* 179 */             (Action)Actions.parallel(
/* 180 */               (Action)Actions.moveBy(-500.0F, 0.0F, 0.2F), 
/* 181 */               (Action)Actions.alpha(0.0F, 0.2F)), 
/*     */             
/* 183 */             (Action)Actions.removeActor(), 
/* 184 */             (Action)Actions.run(() -> {
/*     */                 this.n.removeValue(paramNotification, true);
/*     */                 Game.i.assertInMainThread();
/*     */               })));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hide() {
/* 194 */     setVisible(false);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPersistent() {
/* 199 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void preRender(float paramFloat) {}
/*     */ 
/*     */   
/*     */   public void postRender(float paramFloat) {}
/*     */ 
/*     */   
/*     */   public void dispose() {}
/*     */ 
/*     */   
/*     */   public class Notification
/*     */     extends Group
/*     */   {
/*     */     public static final int STATUS_QUEUED = 0;
/*     */     public static final int STATUS_SHOWING = 1;
/*     */     public static final int STATUS_VISIBLE = 2;
/*     */     public static final int STATUS_HIDING = 3;
/*     */     public final float notificationHeight;
/* 220 */     public int status = 0;
/*     */     @Null
/*     */     public String id;
/*     */     private Image k;
/*     */     public Image iconImage;
/*     */     
/*     */     private Notification(Notifications this$0, Table param1Table, Drawable param1Drawable, Color param1Color) {
/* 227 */       setWidth(460.0F);
/*     */       
/* 229 */       setTouchable(Touchable.disabled);
/*     */       
/* 231 */       param1Table.setWidth(340.0F);
/* 232 */       param1Table.layout();
/* 233 */       param1Table.pack();
/* 234 */       param1Table.setWidth(340.0F);
/* 235 */       param1Table.setPosition(106.0F, 20.0F);
/*     */       
/* 237 */       if (param1Table.getHeight() < 48.0F) {
/* 238 */         param1Table.setHeight(48.0F);
/*     */       }
/*     */       
/* 241 */       float f = param1Table.getHeight() + 40.0F;
/*     */       
/* 243 */       this.iconImage = new Image(param1Drawable);
/* 244 */       this.iconImage.setSize(48.0F, 48.0F);
/* 245 */       this.iconImage.setPosition(40.0F, 20.0F + param1Table.getHeight() - 48.0F);
/* 246 */       this.iconImage.setTouchable(Touchable.disabled);
/*     */ 
/*     */ 
/*     */       
/*     */       QuadActor quadActor;
/*     */ 
/*     */ 
/*     */       
/* 254 */       (quadActor = new QuadActor(param1Color, new float[] { 0.0F, 0.0F, 0.0F, f, 460.0F, f, 451.0F, 0.0F })).setTouchable(Touchable.disabled);
/* 255 */       this.notificationHeight = f + 2.0F;
/* 256 */       setHeight(this.notificationHeight);
/*     */       
/* 258 */       addActor((Actor)quadActor);
/* 259 */       addActor((Actor)this.iconImage);
/* 260 */       addActor((Actor)param1Table);
/*     */       
/* 262 */       this.k = new Image((Drawable)Game.i.assetManager.getDrawable("blank"));
/* 263 */       this.k.setTouchable(Touchable.disabled);
/* 264 */       addActor((Actor)this.k);
/* 265 */       this.k.setVisible(false);
/*     */       
/* 267 */       setVisible(false);
/*     */     }
/*     */     
/*     */     private Notification(Notifications this$0, CharSequence param1CharSequence, Drawable param1Drawable, Color param1Color) {
/* 271 */       setWidth(460.0F);
/*     */       
/* 273 */       setTouchable(Touchable.disabled);
/*     */       
/*     */       Label label;
/* 276 */       (label = new Label(param1CharSequence, Notifications.a(Notifications.this))).setWrap(true);
/* 277 */       label.setWidth(340.0F);
/* 278 */       label.setAlignment(10);
/* 279 */       label.layout();
/* 280 */       label.pack();
/* 281 */       label.setWidth(340.0F);
/* 282 */       label.setPosition(106.0F, 20.0F);
/*     */       
/* 284 */       if (label.getHeight() < 48.0F) {
/* 285 */         label.setHeight(48.0F);
/* 286 */         label.setAlignment(8);
/*     */       } 
/*     */       
/* 289 */       float f = label.getHeight() + 40.0F;
/*     */       
/*     */       Image image;
/* 292 */       (image = new Image(param1Drawable)).setSize(48.0F, 48.0F);
/* 293 */       image.setPosition(40.0F, 20.0F + label.getHeight() - 48.0F);
/*     */       
/* 295 */       QuadActor quadActor = new QuadActor(param1Color, new float[] { 0.0F, 0.0F, 0.0F, f, 460.0F, f, 451.0F, 0.0F });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 301 */       this.notificationHeight = f + 2.0F;
/* 302 */       setHeight(this.notificationHeight);
/*     */       
/* 304 */       addActor((Actor)quadActor);
/* 305 */       addActor((Actor)image);
/* 306 */       addActor((Actor)label);
/*     */       
/* 308 */       this.k = new Image((Drawable)Game.i.assetManager.getDrawable("blank"));
/* 309 */       addActor((Actor)this.k);
/* 310 */       this.k.setVisible(false);
/*     */       
/* 312 */       setVisible(false);
/*     */     }
/*     */     
/*     */     public void showProgress(float param1Float, Color param1Color) {
/* 316 */       if (param1Float <= 0.0F) {
/* 317 */         this.k.setVisible(false); return;
/*     */       } 
/* 319 */       param1Float *= 451.0F;
/* 320 */       this.k.setColor(param1Color);
/* 321 */       this.k.setSize(param1Float, 6.0F);
/* 322 */       this.k.setVisible(true);
/*     */     }
/*     */ 
/*     */     
/*     */     public void hide(float param1Float) {
/*     */       Array array;
/* 328 */       if ((array = getActions()).size != 0) {
/*     */         SequenceAction sequenceAction;
/* 330 */         for (Array.ArrayIterator<Action> arrayIterator = (sequenceAction = (SequenceAction)array.first()).getActions().iterator(); arrayIterator.hasNext();) {
/* 331 */           if (action = arrayIterator.next() instanceof DelayAction) {
/* 332 */             ((DelayAction)action).setDuration(param1Float);
/* 333 */             ((DelayAction)action).setTime(0.0F);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\Notifications.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */