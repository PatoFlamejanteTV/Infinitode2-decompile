/*     */ package com.prineside.tdi2.managers;
/*     */ import com.badlogic.gdx.Net;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.JsonReader;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.JsonWriter;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.IssuedItems;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.Manager;
/*     */ import com.prineside.tdi2.Threads;
/*     */ import com.prineside.tdi2.enums.CaseType;
/*     */ import com.prineside.tdi2.events.global.GameLoad;
/*     */ import com.prineside.tdi2.items.DoubleGainShardItem;
/*     */ import com.prineside.tdi2.managers.preferences.categories.ProgressPrefs;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*     */ import com.prineside.tdi2.ui.actors.FancyButton;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.WebView;
/*     */ import com.prineside.tdi2.ui.shared.MessagesOverlay;
/*     */ import com.prineside.tdi2.utils.Quad;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @REGS(serializer = MessageManager.Serializer.class)
/*     */ public final class MessageManager extends Manager.ManagerWithListeners<MessageManager.MessageManagerListener> {
/*  36 */   private static final TLog b = TLog.forClass(MessageManager.class);
/*     */   private boolean c;
/*     */   
/*     */   public static class Serializer extends SingletonSerializer<MessageManager> { public MessageManager read() {
/*  40 */       return Game.i.messageManager;
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  46 */   private final Array<Message> d = new Array(true, 1, Message.class);
/*     */ 
/*     */   
/*     */   public final void setup() {
/*  50 */     Game.EVENTS.getListeners(GameLoad.class).add(paramGameLoad -> {
/*     */           processLocalMessages();
/*     */           
/*     */           requestMessagesFromServer();
/*     */         });
/*  55 */     Game.i.authManager.addListener(new AuthManager.AuthManagerListener.AuthManagerListenerAdapter(this)
/*     */         {
/*     */           public void signInStatusUpdated() {
/*  58 */             this.a.processLocalMessages();
/*  59 */             this.a.requestMessagesFromServer();
/*     */           }
/*     */ 
/*     */           
/*     */           public void autoSaveModeChanged() {
/*  64 */             this.a.processLocalMessages();
/*     */           }
/*     */         });
/*     */     
/*  68 */     Game.i.preferencesManager.addListener(new PreferencesManager.PreferencesManagerListener.PreferencesManagerListenerAdapter(this)
/*     */         {
/*     */           public void reloaded() {
/*  71 */             this.a.processLocalMessages();
/*  72 */             this.a.requestMessagesFromServer();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void processLocalMessages() {
/*  81 */     Game.i.authManager.getNews(paramNewsResponse -> {
/*     */           Message message = getMessage("issued_items");
/*     */ 
/*     */           
/*     */           if (paramNewsResponse != null && paramNewsResponse.itemsFromServer.size != 0) {
/*     */             if (message != null && ((Integer)message.userData.get("count")).intValue() == paramNewsResponse.itemsFromServer.size) {
/*     */               return;
/*     */             }
/*     */ 
/*     */             
/*     */             if (message != null) {
/*     */               removeMessage(message);
/*     */             }
/*     */ 
/*     */             
/*     */             (message = new Message()).id = "issued_items";
/*     */ 
/*     */             
/*     */             message.date = Game.getTimestampSeconds();
/*     */             
/*     */             message.title = Game.i.localeManager.i18n.format("new_items_from_server_count", new Object[] { Integer.valueOf(paramNewsResponse.itemsFromServer.size) });
/*     */             
/*     */             message.local = true;
/*     */             
/*     */             message.notDeletable = true;
/*     */             
/*     */             message.notReadable = true;
/*     */             
/*     */             message.customIcon = (Drawable)Game.i.assetManager.getDrawable("icon-new-item");
/*     */             
/*     */             message.userData.put("count", Integer.valueOf(paramNewsResponse.itemsFromServer.size));
/*     */             
/*     */             Table table = new Table();
/*     */             
/*     */             message.contents = (Actor)table;
/*     */             
/*     */             FancyButton fancyButton = (new FancyButton("regularButton.a", ())).withLabel(24, Game.i.localeManager.i18n.get("receive_server_items_button"));
/*     */             
/*     */             table.add((Actor)fancyButton).size(400.0F, 64.0F);
/*     */             
/*     */             addMessage(message);
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/*     */           if (message != null) {
/*     */             removeMessage(message);
/*     */           }
/*     */         });
/*     */     
/* 131 */     if (!(ProgressPrefs.i()).progress.isMidGameDgRewardGiven() && !isMessageItemsReceived("stage_4_unlock_reward") && 
/* 132 */       Game.i.basicLevelManager.isOpened(Game.i.basicLevelManager.getLevel("4.1")) && 
/* 133 */       getMessage("stage_4_unlock_reward") == null) {
/*     */       Message message;
/* 135 */       (message = new Message()).id = "stage_4_unlock_reward";
/* 136 */       message.date = Game.getTimestampSeconds();
/* 137 */       message.title = Game.i.localeManager.i18n.format("reward_for_stage_4_unlock", new Object[0]);
/* 138 */       message.local = true;
/* 139 */       message.notDeletable = true;
/* 140 */       message.notReadable = true;
/* 141 */       message.customIcon = (Drawable)Game.i.assetManager.getDrawable("icon-new-item");
/* 142 */       Table table = new Table();
/*     */       Label label;
/* 144 */       (label = new Label(Game.i.localeManager.i18n.get("reward_for_stage_4_unlock_description"), Game.i.assetManager.getLabelStyle(24))).setWrap(true);
/* 145 */       table.add((Actor)label).growX().row();
/* 146 */       message.contents = (Actor)table;
/*     */       
/* 148 */       message.items = new Array(true, 1, ItemStack.class);
/* 149 */       message.items.add(new ItemStack((Item)Item.D.F_CASE.create(CaseType.CYAN, false), 1));
/* 150 */       if (Game.i.progressManager.hasPermanentDoubleGain()) {
/* 151 */         message.items.add(new ItemStack((Item)Item.D.ACCELERATOR, 400));
/*     */       } else {
/*     */         DoubleGainShardItem doubleGainShardItem;
/* 154 */         (doubleGainShardItem = Item.D.F_DOUBLE_GAIN_SHARD.create()).duration = 172800;
/* 155 */         message.items.add(new ItemStack((Item)doubleGainShardItem, 1));
/*     */         
/* 157 */         Label label1 = new Label(Game.i.localeManager.i18n.get("reward_for_stage_4_unlock_dg_shard_hint"), Game.i.assetManager.getLabelStyle(24));
/* 158 */         table.add((Actor)label1).growX().padTop(15.0F).row();
/*     */       } 
/* 160 */       message.onItemsReceive = (() -> {
/*     */           (ProgressPrefs.i()).progress.setMidGameDgRewardGiven(true);
/*     */           ProgressPrefs.i().requireSave();
/*     */           removeMessage(paramMessage);
/*     */         });
/* 165 */       addMessage(message);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Array<Message> getMessages() {
/* 175 */     this.d.sort((paramMessage1, paramMessage2) -> Integer.compare(paramMessage1.date, paramMessage2.date));
/* 176 */     return this.d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isMessageRead(String paramString) {
/* 184 */     return (ProgressPrefs.i()).message.isMessageRead(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void markMessageRead(Message paramMessage) {
/* 193 */     if (!isMessageRead(paramMessage.id)) {
/* 194 */       if (paramMessage.notReadable)
/*     */         return; 
/* 196 */       (ProgressPrefs.i()).message.setMessageRead(paramMessage.id);
/* 197 */       ProgressPrefs.i().requireSave();
/*     */       
/* 199 */       if (!paramMessage.local && Game.i.authManager.getSessionId() != null) {
/* 200 */         Game.i.httpManager.post(Config.MARK_MESSAGE_URL)
/* 201 */           .param("sessionid", Game.i.authManager.getSessionId())
/* 202 */           .param("message", paramMessage.id)
/* 203 */           .param("status", "read")
/* 204 */           .listener((paramBoolean1, paramHttpResponse, paramBoolean2, paramThrowable) -> {
/*     */               if (paramBoolean1) {
/*     */                 b.i("markMessageRead server: " + paramHttpResponse.getResultAsString(), new Object[0]);
/*     */                 
/*     */                 return;
/*     */               } 
/*     */               b.e("failed to mark message read on the server", new Object[] { paramThrowable });
/* 211 */             }).send();
/*     */       }
/* 213 */       a();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isMessageEverDeleted(String paramString) {
/* 222 */     return (ProgressPrefs.i()).message.isMessageDeleted(paramString);
/*     */   }
/*     */   
/*     */   public final boolean isMessageItemsReceived(String paramString) {
/* 226 */     return (ProgressPrefs.i()).message.isMessageItemsReceived(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void deleteMessage(Message paramMessage) {
/* 236 */     if (paramMessage.notDeletable) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 241 */     if (this.d.removeValue(paramMessage, true)) {
/*     */       
/* 243 */       if (!(ProgressPrefs.i()).message.isMessageDeleted(paramMessage.id)) {
/*     */         
/* 245 */         (ProgressPrefs.i()).message.setMessageDeleted(paramMessage.id);
/* 246 */         ProgressPrefs.i().requireSave();
/*     */       } 
/*     */       
/* 249 */       if (!paramMessage.local && Game.i.authManager.getSessionId() != null) {
/* 250 */         Game.i.httpManager.post(Config.MARK_MESSAGE_URL)
/* 251 */           .param("sessionid", Game.i.authManager.getSessionId())
/* 252 */           .param("message", paramMessage.id)
/* 253 */           .param("status", "deleted")
/* 254 */           .listener((paramBoolean1, paramHttpResponse, paramBoolean2, paramThrowable) -> {
/*     */               if (paramBoolean1) {
/*     */                 b.i("deleteMessage server: " + paramHttpResponse.getResultAsString(), new Object[0]);
/*     */                 
/*     */                 return;
/*     */               } 
/*     */               b.e("failed to mark message deleted on the server", new Object[] { paramThrowable });
/* 261 */             }).send();
/*     */       }
/*     */       
/* 264 */       (ProgressPrefs.i()).message.removeMessageReadRecord(paramMessage.id);
/* 265 */       ProgressPrefs.i().requireSave();
/*     */       
/* 267 */       a();
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void requestMessagesFromServer() {
/* 272 */     if (Game.i.authManager.getSessionId() == null)
/* 273 */       return;  if (this.c)
/*     */       return; 
/* 275 */     this.c = true;
/*     */     
/* 277 */     this.a.begin(); byte b; int i;
/* 278 */     for (b = 0, i = this.a.size; b < i; b++) {
/* 279 */       ((MessageManagerListener)this.a.get(b)).serverRequestStarted();
/*     */     }
/* 281 */     this.a.end();
/*     */     
/* 283 */     Game.i.httpManager.post(Config.GET_MESSAGES_URL)
/* 284 */       .param("locale", Game.i.localeManager.getLocale())
/* 285 */       .param("sessionid", Game.i.authManager.getSessionId())
/* 286 */       .listener((paramBoolean1, paramHttpResponse, paramBoolean2, paramThrowable) -> {
/*     */           if (paramBoolean1) {
/*     */             String str = paramHttpResponse.getResultAsString();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             Threads.i().runOnMainThread(());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             return;
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           b.e("failed to request server for messages", new Object[] { paramThrowable });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           Threads.i().runOnMainThread(());
/* 348 */         }).send();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void removeMessage(Message paramMessage) {
/* 357 */     if (this.d.removeValue(paramMessage, true)) {
/* 358 */       a();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void addMessage(Message paramMessage) {
/*     */     Message message;
/* 369 */     if ((message = getMessage(paramMessage.id)) != null) {
/* 370 */       removeMessage(message);
/*     */     }
/*     */     
/* 373 */     this.d.add(paramMessage);
/* 374 */     a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Null
/*     */   public final Message getMessage(String paramString) {
/* 383 */     Preconditions.checkNotNull(paramString, "id can not be null");
/* 384 */     for (byte b = 0; b < this.d.size; b++) {
/* 385 */       if (((Message)this.d.get(b)).id.equals(paramString)) {
/* 386 */         return (Message)this.d.get(b);
/*     */       }
/*     */     } 
/*     */     
/* 390 */     return null;
/*     */   }
/*     */   
/*     */   public final int getUnreadMessageCount() {
/* 394 */     byte b1 = 0;
/* 395 */     for (byte b2 = 0; b2 < this.d.size; b2++) {
/* 396 */       if (!isMessageRead((((Message[])this.d.items)[b2]).id)) {
/* 397 */         b1++;
/*     */       }
/*     */     } 
/*     */     
/* 401 */     return b1;
/*     */   }
/*     */   
/*     */   public final int getTotalMessageCount() {
/* 405 */     return this.d.size;
/*     */   }
/*     */   
/*     */   public final void receiveMessageItems(Message paramMessage) {
/* 409 */     if (isMessageItemsReceived(paramMessage.id))
/*     */       return; 
/* 411 */     IssuedItems issuedItems = new IssuedItems(IssuedItems.IssueReason.REGULAR_REWARD, Game.getTimestampSeconds());
/*     */     
/*     */     Array array;
/* 414 */     (array = new Array(ItemStack.class)).addAll(paramMessage.items);
/* 415 */     issuedItems.items.addAll(array);
/* 416 */     Game.i.progressManager.addIssuedPrizes(issuedItems, true);
/* 417 */     Game.i.progressManager.addItemArray(issuedItems.items, "message_items");
/* 418 */     Game.i.progressManager.showNewlyIssuedPrizesPopup();
/*     */     
/* 420 */     (ProgressPrefs.i()).message.setMessageItemsReceived(paramMessage.id);
/* 421 */     ProgressPrefs.i().requireSave();
/* 422 */     if (paramMessage.onItemsReceive != null) {
/* 423 */       paramMessage.onItemsReceive.run();
/*     */     }
/*     */     
/* 426 */     a();
/*     */   }
/*     */   
/*     */   private void a() {
/* 430 */     this.a.begin(); byte b; int i;
/* 431 */     for (b = 0, i = this.a.size; b < i; b++) {
/* 432 */       ((MessageManagerListener)this.a.get(b)).messagesUpdated();
/*     */     }
/* 434 */     this.a.end();
/*     */   }
/*     */   
/*     */   private void b() {
/* 438 */     this.a.begin(); byte b; int i;
/* 439 */     for (b = 0, i = this.a.size; b < i; b++) {
/* 440 */       ((MessageManagerListener)this.a.get(b)).serverRequestFinished();
/*     */     }
/* 442 */     this.a.end();
/*     */   }
/*     */   
/*     */   public final boolean isRequestingServer() {
/* 446 */     return this.c;
/*     */   }
/*     */   
/*     */   public static final class Message { public String id;
/*     */     public String title;
/*     */     public Actor contents;
/*     */     public Drawable customIcon;
/*     */     public int date;
/*     */     public boolean local;
/*     */     public boolean notDeletable;
/*     */     public boolean notReadable;
/*     */     @Null
/* 458 */     public Array<ItemStack> items = null;
/*     */     @Null
/*     */     public Runnable onItemsReceive;
/* 461 */     public ObjectMap<String, Object> userData = new ObjectMap();
/*     */ 
/*     */     
/*     */     public final String toString() {
/*     */       StringBuilder stringBuilder;
/* 466 */       (stringBuilder = new StringBuilder()).append(super.toString()).append(" {");
/* 467 */       stringBuilder.append("id: ").append(this.id).append(", ");
/* 468 */       stringBuilder.append("title: ").append(this.title).append(", ");
/* 469 */       stringBuilder.append("contents: ").append(this.contents).append(", ");
/* 470 */       stringBuilder.append("customIcon: ").append(this.customIcon).append(", ");
/* 471 */       stringBuilder.append("date: ").append(this.date).append(", ");
/* 472 */       stringBuilder.append("local: ").append(this.local).append(", ");
/* 473 */       stringBuilder.append("notDeletable: ").append(this.notDeletable).append(", ");
/* 474 */       stringBuilder.append("notReadable: ").append(this.notReadable).append(", ");
/* 475 */       stringBuilder.append("items: ").append(this.items).append(", ");
/* 476 */       stringBuilder.append("userData: ").append(this.userData);
/* 477 */       stringBuilder.append("}");
/* 478 */       return stringBuilder.toString();
/*     */     } }
/*     */ 
/*     */   
/*     */   public static interface MessageManagerListener {
/*     */     void messagesUpdated();
/*     */     
/*     */     void serverRequestStarted();
/*     */     
/*     */     void serverRequestFinished();
/*     */     
/*     */     public static abstract class Adapter implements MessageManagerListener {
/*     */       public void messagesUpdated() {}
/*     */       
/*     */       public void serverRequestStarted() {}
/*     */       
/*     */       public void serverRequestFinished() {}
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\MessageManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */