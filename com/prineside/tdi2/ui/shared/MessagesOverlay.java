/*     */ package com.prineside.tdi2.ui.shared;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.managers.MessageManager;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.InputListener;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.scene2d.ui.Cell;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*     */ import com.prineside.tdi2.ui.actors.ComplexButton;
/*     */ import com.prineside.tdi2.ui.actors.ItemCell;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.LabelButton;
/*     */ import com.prineside.tdi2.ui.actors.LimitedWidthLabel;
/*     */ import com.prineside.tdi2.ui.actors.PaddedImageButton;
/*     */ import com.prineside.tdi2.ui.actors.QuadActor;
/*     */ import com.prineside.tdi2.ui.actors.RectButton;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.QuadDrawable;
/*     */ import com.prineside.tdi2.utils.UiUtils;
/*     */ import java.text.DateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.Locale;
/*     */ 
/*     */ public class MessagesOverlay
/*     */   extends UiManager.UiComponent.Adapter {
/*     */   public static MessagesOverlay i() {
/*  46 */     return (MessagesOverlay)Game.i.uiManager.getComponent(MessagesOverlay.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  51 */   private final UiManager.UiLayer a = Game.i.uiManager.addLayer(UiManager.MainUiLayer.OVERLAY, 150, "MessagesOverlay main");
/*     */   
/*     */   private boolean b;
/*     */   
/*     */   private Table c;
/*     */   
/*     */   private Group d;
/*     */   
/*     */   private Label e;
/*     */   private PaddedImageButton f;
/*     */   private String g;
/*     */   
/*     */   public MessagesOverlay() {
/*  64 */     this.c = new Table();
/*  65 */     this.c.setOrigin(520.0F, 400.0F);
/*  66 */     this.c.setTransform(true);
/*  67 */     this.a.getTable().add((Actor)this.c).width(1040.0F);
/*     */     
/*     */     Group group;
/*     */     
/*  71 */     (group = new Group()).setTransform(false);
/*     */ 
/*     */ 
/*     */     
/*     */     QuadActor quadActor;
/*     */ 
/*     */     
/*  78 */     (quadActor = new QuadActor(new Color(791621631), new float[] { 0.0F, 0.0F, 0.0F, 15.0F, 1040.0F, 0.0F, 1040.0F, 0.0F })).setSize(1040.0F, 15.0F);
/*  79 */     group.addActor((Actor)quadActor);
/*  80 */     this.c.add((Actor)group).height(15.0F).padTop(160.0F).width(1040.0F).row();
/*     */ 
/*     */     
/*  83 */     this.d = new Group();
/*  84 */     this.d.setTransform(false);
/*     */     
/*  86 */     this.c.add((Actor)this.d).size(1040.0F, 800.0F).row();
/*     */ 
/*     */ 
/*     */     
/*  90 */     (group = new Group()).setTransform(false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  98 */     (quadActor = new QuadActor(new Color(791621631), new float[] { 0.0F, 0.0F, 0.0F, 30.0F, 1040.0F, 30.0F, 1040.0F, 15.0F })).setSize(1040.0F, 30.0F);
/*  99 */     group.addActor((Actor)quadActor);
/*     */     
/* 101 */     this.e = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE));
/* 102 */     this.e.addAction((Action)Actions.forever(
/* 103 */           (Action)Actions.sequence(
/* 104 */             (Action)Actions.color(Color.WHITE, 0.4F), 
/* 105 */             (Action)Actions.color(new Color(1.0F, 1.0F, 1.0F, 0.56F), 0.8F), 
/* 106 */             (Action)Actions.delay(0.5F))));
/*     */ 
/*     */     
/* 109 */     this.e.setTouchable(Touchable.disabled);
/* 110 */     this.e.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 111 */     this.e.setSize(1040.0F, 20.0F);
/* 112 */     this.e.setPosition(0.0F, -60.0F);
/* 113 */     this.e.setAlignment(1);
/* 114 */     group.addActor((Actor)this.e);
/*     */     
/* 116 */     this.c.add((Actor)group).height(30.0F).padBottom(160.0F).width(1040.0F).row();
/*     */ 
/*     */     
/* 119 */     this.a.getTable().setVisible(false);
/*     */     
/* 121 */     Game.i.messageManager.addListener(new MessageManager.MessageManagerListener.Adapter(this)
/*     */         {
/*     */           public void messagesUpdated() {
/* 124 */             if (this.a.isVisible() && MessagesOverlay.a(this.a) == null) {
/* 125 */               this.a.updateContents();
/*     */             }
/*     */           }
/*     */ 
/*     */           
/*     */           public void serverRequestStarted() {
/* 131 */             if (this.a.isVisible()) {
/* 132 */               MessagesOverlay.b(this.a);
/*     */             }
/*     */           }
/*     */ 
/*     */           
/*     */           public void serverRequestFinished() {
/* 138 */             if (this.a.isVisible()) {
/* 139 */               MessagesOverlay.c(this.a);
/*     */             }
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   private static String a(int paramInt) {
/* 146 */     Locale locale = Game.i.localeManager.i18n.getLocale();
/* 147 */     DateFormat dateFormat2 = DateFormat.getDateInstance(2, locale);
/* 148 */     DateFormat dateFormat1 = DateFormat.getTimeInstance(2, locale);
/* 149 */     Date date = new Date(paramInt * 1000L);
/*     */     
/* 151 */     return dateFormat2.format(date) + " " + dateFormat1.format(date);
/*     */   }
/*     */   
/*     */   public boolean isVisible() {
/* 155 */     return this.b;
/*     */   }
/*     */   
/*     */   public void show() {
/* 159 */     showAtMessage(null);
/*     */   }
/*     */   
/*     */   public void showAtMessage(@Null String paramString) {
/* 163 */     this.g = paramString;
/*     */     
/* 165 */     Game.i.messageManager.processLocalMessages();
/*     */     
/* 167 */     updateContents();
/*     */     
/* 169 */     this.e.setText(Game.i.localeManager.i18n.get("tap_outside_list_to_hide"));
/*     */     
/* 171 */     float f = Game.i.settingsManager.isUiAnimationsEnabled() ? 1.0F : 0.0F;
/*     */     
/* 173 */     DarkOverlay.i().addCallerOverlayLayer("MessagesOverlay", this.a.zIndex - 1, () -> {
/*     */           hide();
/*     */           return true;
/*     */         });
/* 177 */     this.a.getTable().setVisible(true);
/* 178 */     this.b = true;
/*     */     
/* 180 */     this.c.clearActions();
/* 181 */     this.c.addAction((Action)Actions.sequence(
/* 182 */           (Action)Actions.scaleTo(0.0F, 0.0F), 
/* 183 */           (Action)Actions.parallel(
/* 184 */             (Action)Actions.sequence(
/* 185 */               (Action)Actions.delay(0.1F * f), 
/* 186 */               (Action)Actions.scaleBy(1.0F, 0.0F, 0.3F * f, (Interpolation)Interpolation.swingOut)), 
/*     */             
/* 188 */             (Action)Actions.scaleBy(0.0F, 1.0F, 0.3F * f, (Interpolation)Interpolation.swingOut))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void a() {
/* 194 */     if (this.f != null) {
/* 195 */       this.f.clearActions();
/* 196 */       this.f.setTransform(true);
/* 197 */       this.f.addAction((Action)Actions.forever((Action)Actions.rotateBy(360.0F, 1.0F)));
/*     */     } 
/*     */   }
/*     */   
/*     */   private void b() {
/* 202 */     if (this.f != null) {
/* 203 */       this.f.clearActions();
/* 204 */       this.f.setRotation(0.0F);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void c() {
/*     */     Image image;
/* 210 */     (image = new Image(Game.i.assetManager.getDrawable("blank").tint(new Color(791621631)))).setSize(1040.0F, 800.0F);
/* 211 */     this.d.addActor((Actor)image);
/*     */     
/*     */     Label label;
/* 214 */     (label = new Label(Game.i.localeManager.i18n.get("mailbox").toUpperCase(), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(36), Color.WHITE))).setSize(1000.0F, 40.0F);
/* 215 */     label.setPosition(40.0F, 740.0F);
/* 216 */     this.d.addActor((Actor)label);
/*     */     
/* 218 */     this
/* 219 */       .f = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-restart"), () -> Game.i.messageManager.requestMessagesFromServer(), MaterialColor.LIGHT_BLUE.P800, MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P900);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 225 */     this.f.setSize(48.0F, 48.0F);
/* 226 */     this.f.setOrigin(24.0F, 24.0F);
/* 227 */     this.f.setPosition(952.0F, 732.0F);
/* 228 */     this.f.setIconSize(40.0F, 40.0F);
/* 229 */     this.f.setIconPosition(4.0F, 4.0F);
/* 230 */     if (Game.i.messageManager.isRequestingServer()) {
/* 231 */       a();
/*     */     }
/* 233 */     this.d.addActor((Actor)this.f);
/*     */     
/*     */     Table table;
/* 236 */     (table = new Table()).setTouchable(Touchable.enabled);
/*     */     
/*     */     ScrollPane scrollPane;
/* 239 */     UiUtils.enableMouseMoveScrollFocus(scrollPane = new ScrollPane((Actor)table, Game.i.assetManager.getScrollPaneStyle(10.0F)));
/* 240 */     scrollPane.setSize(1040.0F, 720.0F);
/* 241 */     this.d.addActor((Actor)scrollPane);
/*     */     
/*     */     MessageManager messageManager;
/* 244 */     Array array = (messageManager = Game.i.messageManager).getMessages();
/* 245 */     for (byte b = 0; b < array.size; b++) {
/* 246 */       TextureRegionDrawable textureRegionDrawable; MessageManager.Message message = (MessageManager.Message)array.get(b);
/*     */       
/*     */       Table table1;
/* 249 */       (table1 = new Table()).setTouchable(Touchable.enabled);
/* 250 */       if (messageManager.isMessageRead(message.id)) {
/* 251 */         table1.setBackground(Game.i.assetManager.getDrawable("blank").tint(new Color(0.0F, 0.0F, 0.0F, 0.14F)));
/*     */       } else {
/* 253 */         table1.setBackground(Game.i.assetManager.getDrawable("blank").tint(new Color(1.0F, 1.0F, 1.0F, 0.07F)));
/*     */       } 
/* 255 */       table1.addListener((EventListener)new InputListener(this, messageManager, message, table1)
/*     */           {
/*     */             public void enter(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, @Null Actor param1Actor) {
/* 258 */               if (this.a.isMessageRead(this.b.id)) {
/* 259 */                 this.c.setBackground(Game.i.assetManager.getDrawable("blank").tint(new Color(0.0F, 0.0F, 0.0F, 0.21F))); return;
/*     */               } 
/* 261 */               this.c.setBackground(Game.i.assetManager.getDrawable("blank").tint(new Color(1.0F, 1.0F, 1.0F, 0.1F)));
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, @Null Actor param1Actor) {
/* 267 */               if (this.a.isMessageRead(this.b.id)) {
/* 268 */                 this.c.setBackground(Game.i.assetManager.getDrawable("blank").tint(new Color(0.0F, 0.0F, 0.0F, 0.14F))); return;
/*     */               } 
/* 270 */               this.c.setBackground(Game.i.assetManager.getDrawable("blank").tint(new Color(1.0F, 1.0F, 1.0F, 0.07F)));
/*     */             }
/*     */           });
/*     */       
/* 274 */       table1.addListener((EventListener)new ClickListener(this, message)
/*     */           {
/*     */             public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 277 */               MessagesOverlay.a(this.b, this.a.id);
/* 278 */               this.b.updateContents();
/*     */             }
/*     */           });
/* 281 */       table.add((Actor)table1).height(96.0F).padBottom(4.0F).growX().row();
/*     */       
/*     */       Group group;
/*     */       
/* 285 */       (group = new Group()).setTransform(false);
/* 286 */       table1.add((Actor)group).size(64.0F).pad(16.0F).padLeft(40.0F);
/*     */       
/*     */       Drawable drawable;
/* 289 */       if ((drawable = message.customIcon) == null) {
/* 290 */         textureRegionDrawable = Game.i.assetManager.getDrawable("icon-letter");
/*     */       }
/*     */       Image image1;
/* 293 */       (image1 = new Image((Drawable)textureRegionDrawable)).setSize(64.0F, 64.0F);
/* 294 */       group.addActor((Actor)image1);
/* 295 */       if (messageManager.isMessageRead(message.id)) {
/* 296 */         image1.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*     */       } else {
/* 298 */         image1.setColor(Color.WHITE);
/*     */         
/* 300 */         (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("count-bubble"))).setSize(21.5F, 24.5F);
/* 301 */         image1.setPosition(51.0F, 38.0F);
/* 302 */         group.addActor((Actor)image1);
/*     */       } 
/*     */       
/* 305 */       Table table2 = new Table();
/* 306 */       table1.add((Actor)table2).padLeft(8.0F).growX();
/*     */       
/*     */       LimitedWidthLabel limitedWidthLabel;
/* 309 */       (limitedWidthLabel = new LimitedWidthLabel(message.title, 30, 24, 640.0F)).setAlignment(8);
/* 310 */       table2.add((Actor)limitedWidthLabel).growX().row();
/*     */       
/*     */       Label label1;
/* 313 */       (label1 = new Label(a(message.date), Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 314 */       label1.setAlignment(8);
/* 315 */       table2.add((Actor)label1).growX().row();
/*     */       
/* 317 */       if (!message.notDeletable) {
/*     */         ComplexButton complexButton;
/*     */ 
/*     */ 
/*     */         
/* 322 */         (complexButton = new ComplexButton("", Game.i.assetManager.getLabelStyle(21), () -> { Game.i.messageManager.deleteMessage(paramMessage); updateContents(); })).setBackground((Drawable)new QuadDrawable(new QuadActor(new Color[] { Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE }, new float[] { 0.0F, 0.0F, 8.0F, 96.0F, 100.0F, 96.0F, 100.0F, 0.0F })), 0.0F, 0.0F, 100.0F, 96.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 328 */         complexButton.setBackgroundColors(new Color(0.0F, 0.0F, 0.0F, 0.14F), MaterialColor.RED.P700, MaterialColor.RED.P500, Color.GRAY);
/* 329 */         complexButton.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-trash-bin"), 28.0F, 24.0F, 48.0F, 48.0F);
/* 330 */         table1.add((Actor)complexButton).width(100.0F).height(96.0F);
/*     */       } 
/*     */     } 
/*     */     
/* 334 */     if (array.size == 0) {
/*     */       Label label1;
/* 336 */       (label1 = new Label(Game.i.localeManager.i18n.get("no_new_messages"), Game.i.assetManager.getLabelStyle(30))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 337 */       table.add((Actor)label1).padTop(16.0F).row();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 357 */     table.add().width(1.0F).growY();
/*     */   }
/*     */   
/*     */   private void a(MessageManager.Message paramMessage) {
/*     */     Image image;
/* 362 */     (image = new Image(Game.i.assetManager.getDrawable("blank").tint(new Color(791621631)))).setSize(1040.0F, 800.0F);
/* 363 */     this.d.addActor((Actor)image);
/*     */     
/*     */     Table table1;
/* 366 */     (table1 = new Table()).setSize(1040.0F, 800.0F);
/* 367 */     this.d.addActor((Actor)table1);
/*     */     
/* 369 */     LabelButton labelButton = new LabelButton(Game.i.assetManager.replaceRegionAliasesWithChars("<@icon-triangle-left-hollow>") + " " + Game.i.localeManager.i18n.get("back_to_mailbox"), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(30), Color.WHITE), () -> {
/*     */           this.g = null;
/*     */           updateContents();
/*     */         });
/* 373 */     table1.add((Actor)labelButton).size(960.0F, 40.0F).padLeft(40.0F).padRight(40.0F).padTop(20.0F).padBottom(20.0F).row();
/*     */     
/*     */     Table table2;
/* 376 */     (table2 = new Table()).background(Game.i.assetManager.getDrawable("blank").tint(new Color(0.0F, 0.0F, 0.0F, 0.14F)));
/* 377 */     table1.add((Actor)table2).growX().row();
/*     */     
/*     */     Label label;
/* 380 */     (label = new Label(paramMessage.title, Game.i.assetManager.getLabelStyle(30))).setWrap(true);
/* 381 */     table2.add((Actor)label).width(960.0F).padTop(10.0F).row();
/*     */ 
/*     */     
/* 384 */     (label = new Label(a(paramMessage.date), Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 385 */     label.setAlignment(8);
/* 386 */     table2.add((Actor)label).width(960.0F).padBottom(10.0F).row();
/*     */ 
/*     */     
/* 389 */     (table2 = new Table()).setTouchable(Touchable.enabled);
/*     */     
/*     */     ScrollPane scrollPane;
/* 392 */     UiUtils.enableMouseMoveScrollFocus(scrollPane = new ScrollPane((Actor)table2, Game.i.assetManager.getScrollPaneStyle(10.0F)));
/* 393 */     scrollPane.setSize(1040.0F, 740.0F);
/* 394 */     table1.add((Actor)scrollPane).grow();
/*     */     
/* 396 */     Game.i.messageManager.markMessageRead(paramMessage);
/*     */     
/* 398 */     table2.add().width(1.0F).height(20.0F).row();
/* 399 */     table2.add(paramMessage.contents).width(960.0F).row();
/*     */     
/* 401 */     if (paramMessage.items != null && paramMessage.items.size != 0) {
/*     */       Image image1;
/*     */       
/* 404 */       (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-radial-top@flip-y"))).setColor(0.0F, 0.0F, 0.0F, 0.14F);
/* 405 */       table2.add((Actor)image1).height(9.0F).width(960.0F).padTop(15.0F).row();
/*     */       
/*     */       Table table3;
/* 408 */       (table3 = new Table()).background(Game.i.assetManager.getDrawable("gradient-radial-top").tint(MaterialColor.LIGHT_GREEN.P500.cpy().mul(1.0F, 1.0F, 1.0F, 0.14F)));
/* 409 */       table2.add((Actor)table3).width(960.0F).row();
/*     */       
/*     */       Label label1;
/* 412 */       (label1 = new Label(Game.i.localeManager.i18n.get("message_items_title"), Game.i.assetManager.getLabelStyle(24))).setColor(MaterialColor.LIGHT_GREEN.P500);
/* 413 */       label1.setAlignment(1);
/* 414 */       table3.add((Actor)label1).width(960.0F).padTop(15.0F).row();
/*     */       
/* 416 */       Table table4 = new Table();
/* 417 */       table3.add((Actor)table4).width(960.0F).padTop(15.0F).row();
/*     */       
/* 419 */       byte b1 = 0;
/* 420 */       byte b2 = 0;
/* 421 */       for (byte b3 = 0; b3 < paramMessage.items.size; b3++) {
/* 422 */         ItemStack itemStack = (ItemStack)paramMessage.items.get(b3);
/*     */         
/*     */         ItemCell itemCell;
/* 425 */         (itemCell = new ItemCell()).setColRow(b1, b2);
/* 426 */         itemCell.setItemStack(itemStack);
/* 427 */         itemCell.addListener((EventListener)new ClickListener(this, itemStack)
/*     */             {
/*     */               public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 430 */                 ItemDescriptionDialog.i().showWithCount(this.a.getItem(), this.a.getCount());
/* 431 */                 Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*     */               }
/*     */             });
/* 434 */         itemCell.setCompact();
/*     */         
/* 436 */         Cell cell = table4.add((Actor)itemCell).size(96.0F, 105.0F);
/* 437 */         b1++;
/* 438 */         if (b1 == 10) {
/* 439 */           b1 = 0;
/* 440 */           b2++;
/* 441 */           cell.row();
/*     */         } 
/*     */       } 
/*     */       
/* 445 */       if (Game.i.messageManager.isMessageItemsReceived(paramMessage.id)) {
/*     */         Label label2;
/* 447 */         (label2 = new Label(Game.i.localeManager.i18n.get("message_items_received"), Game.i.assetManager.getLabelStyle(24))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 448 */         label2.setAlignment(1);
/* 449 */         table3.add((Actor)label2).padTop(15.0F).size(400.0F, 64.0F);
/*     */       } else {
/* 451 */         RectButton rectButton = new RectButton(Game.i.localeManager.i18n.get("receive_message_items_button"), Game.i.assetManager.getLabelStyle(24), () -> {
/*     */               Game.i.messageManager.receiveMessageItems(paramMessage);
/*     */               updateContents();
/*     */             });
/* 455 */         table3.add((Actor)rectButton).padTop(15.0F).size(400.0F, 64.0F);
/*     */       } 
/*     */     } 
/*     */     
/* 459 */     table2.add().width(1.0F).growY();
/*     */   }
/*     */   
/*     */   public void updateContents() {
/* 463 */     this.d.clear();
/*     */     
/* 465 */     MessageManager.Message message = null;
/* 466 */     if (this.g != null) {
/* 467 */       message = Game.i.messageManager.getMessage(this.g);
/*     */     }
/*     */     
/* 470 */     if (message == null) {
/* 471 */       c(); return;
/*     */     } 
/* 473 */     a(message);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hide() {
/* 479 */     float f = Game.i.settingsManager.isUiAnimationsEnabled() ? 1.0F : 0.0F;
/*     */     
/* 481 */     DarkOverlay.i().removeCaller("MessagesOverlay");
/*     */     
/* 483 */     this.b = false;
/*     */     
/* 485 */     this.c.clearActions();
/* 486 */     this.c.addAction((Action)Actions.sequence(
/* 487 */           (Action)Actions.parallel(
/* 488 */             (Action)Actions.sequence(
/* 489 */               (Action)Actions.delay(0.07F * f), 
/* 490 */               (Action)Actions.scaleBy(0.0F, -this.c.getScaleY(), 0.3F * f, (Interpolation)Interpolation.swingIn)), 
/*     */             
/* 492 */             (Action)Actions.scaleBy(-this.c.getScaleX(), 0.0F, 0.3F * f, (Interpolation)Interpolation.swingIn)), 
/*     */           
/* 494 */           (Action)Actions.run(() -> this.a.getTable().setVisible(false))));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\MessagesOverlay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */