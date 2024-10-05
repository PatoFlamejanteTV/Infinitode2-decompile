/*     */ package com.prineside.tdi2.ui.shared.stateDebugger;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.events.EventDispatcher;
/*     */ import com.prineside.tdi2.events.EventListeners;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.LabelButton;
/*     */ import com.prineside.tdi2.ui.actors.Window;
/*     */ import com.prineside.tdi2.ui.shared.StateDebugger;
/*     */ import com.prineside.tdi2.ui.shared.stateDebugger.listeners.ListenerGroupViewer;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ 
/*     */ public abstract class ListenersView implements StateDebugger.View {
/*     */   private Table a;
/*     */   public EventDispatcher dispatcher;
/*  24 */   private final Array<Entry> b = new Array(true, 1, Entry.class);
/*     */   private Integer c;
/*     */   
/*     */   public void setDispatcher(EventDispatcher paramEventDispatcher) {
/*  28 */     this.dispatcher = paramEventDispatcher;
/*  29 */     rebuildWindow();
/*     */   }
/*     */ 
/*     */   
/*     */   public void rebuildWindow() {
/*  34 */     this.a = new Table();
/*     */     
/*     */     Table table;
/*  37 */     (table = (StateDebugger.i()).contentTable).clear();
/*  38 */     table.add((Actor)this.a).grow();
/*     */     
/*  40 */     onRender();
/*  41 */     (StateDebugger.i()).window.fitToContent(12, true, false, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void init() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void postInit() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void onShow() {
/*  56 */     StateDebugger.i().renderWindow();
/*     */   }
/*     */ 
/*     */   
/*     */   public void onHide() {
/*  61 */     setDispatcher(null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onRender() {
/*     */     int i;
/*  67 */     if (this.dispatcher == null) {
/*  68 */       i = -1;
/*     */     } else {
/*  70 */       Array array = this.dispatcher.getListenerGroups();
/*  71 */       i = 31 + array.size;
/*  72 */       for (byte b1 = 0; b1 < array.size; b1++) {
/*  73 */         EventListeners eventListeners = (EventListeners)array.get(b1);
/*  74 */         i = i * 31 + eventListeners.getEventClass().getName().hashCode();
/*     */       } 
/*     */     } 
/*     */     
/*  78 */     if (this.c == null || i != this.c.intValue()) {
/*     */       
/*  80 */       this.c = Integer.valueOf(i);
/*  81 */       this.a.clear();
/*  82 */       this.b.clear();
/*     */       
/*  84 */       Label.LabelStyle labelStyle = Game.i.assetManager.getLabelStyle(18);
/*     */       
/*  86 */       if (this.dispatcher == null) {
/*  87 */         this.a.add((Actor)new Label("Dispatcher not found", labelStyle));
/*     */       } else {
/*     */         Label label;
/*  90 */         (label = new Label("Event class", labelStyle)).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  91 */         this.a.add((Actor)label).growX().padRight(6.0F);
/*     */ 
/*     */         
/*  94 */         (label = new Label("Triggers", labelStyle)).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  95 */         this.a.add((Actor)label).padLeft(6.0F).padRight(6.0F);
/*     */ 
/*     */         
/*  98 */         (label = new Label("Stops", labelStyle)).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  99 */         this.a.add((Actor)label).padLeft(6.0F).padRight(6.0F);
/*     */ 
/*     */         
/* 102 */         (label = new Label("No state", labelStyle)).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 103 */         this.a.add((Actor)label).padLeft(6.0F).padRight(6.0F);
/*     */ 
/*     */         
/* 106 */         (label = new Label("State", labelStyle)).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 107 */         this.a.add((Actor)label).padLeft(6.0F).padRight(6.0F);
/*     */ 
/*     */         
/* 110 */         (label = new Label("Total", labelStyle)).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 111 */         this.a.add((Actor)label).padLeft(6.0F);
/*     */         
/* 113 */         this.a.row();
/* 114 */         StateDebugger.tableRowSep(this.a, 6);
/*     */         
/*     */         Array array;
/* 117 */         (array = new Array(this.dispatcher.getListenerGroups())).sort((paramEventListeners1, paramEventListeners2) -> paramEventListeners1.getEventClass().getSimpleName().compareTo(paramEventListeners2.getEventClass().getSimpleName()));
/*     */         
/* 119 */         for (i = 0; i < array.size; i++) {
/* 120 */           EventListeners eventListeners = (EventListeners)array.get(i);
/* 121 */           Entry entry = new Entry(eventListeners, (byte)0);
/* 122 */           this.a.add((Actor)Entry.a(entry)).growX().padRight(6.0F);
/* 123 */           this.a.add((Actor)Entry.b(entry)).padLeft(6.0F).padRight(6.0F);
/* 124 */           this.a.add((Actor)Entry.c(entry)).padLeft(6.0F).padRight(6.0F);
/* 125 */           this.a.add((Actor)Entry.d(entry)).padLeft(6.0F).padRight(6.0F);
/* 126 */           this.a.add((Actor)Entry.e(entry)).padLeft(6.0F).padRight(6.0F);
/* 127 */           this.a.add((Actor)Entry.f(entry)).padLeft(6.0F);
/* 128 */           this.b.add(entry);
/*     */           
/* 130 */           this.a.row();
/* 131 */           StateDebugger.tableRowSep(this.a, 6);
/*     */         } 
/*     */       } 
/* 134 */       this.a.row();
/* 135 */       this.a.add().width(1.0F).growY();
/*     */     } 
/*     */     
/* 138 */     for (byte b = 0; b < this.b.size; b++) {
/* 139 */       Entry.g((Entry)this.b.get(b));
/*     */     }
/*     */   }
/*     */   
/*     */   private static class Entry
/*     */   {
/*     */     private final EventListeners<?> a;
/*     */     private final LabelButton b;
/*     */     private final Label c;
/*     */     private final Label d;
/*     */     private final Label e;
/*     */     private final Label f;
/*     */     private final Label g;
/*     */     private long h;
/*     */     private long i;
/*     */     
/*     */     private Entry(EventListeners<?> param1EventListeners) {
/* 156 */       this.a = param1EventListeners;
/*     */       
/* 158 */       Label.LabelStyle labelStyle = Game.i.assetManager.getLabelStyle(18);
/* 159 */       this.b = new LabelButton(param1EventListeners.getEventClass().getSimpleName(), labelStyle, null);
/* 160 */       this.b.setClickHandler(() -> {
/*     */             ListenerGroupViewer listenerGroupViewer = new ListenerGroupViewer(param1EventListeners);
/*     */             
/*     */             Game.i.uiManager.addWindow((Window)listenerGroupViewer);
/*     */             listenerGroupViewer.fitToContentSimple();
/*     */             Vector2 vector2 = this.b.localToStageCoordinates(new Vector2());
/*     */             listenerGroupViewer.showAtPointAligned(vector2.x, vector2.y, 1);
/*     */           });
/* 168 */       this.b.setAlignment(8);
/*     */       
/* 170 */       this.c = new Label("", labelStyle);
/* 171 */       this.d = new Label("", labelStyle);
/* 172 */       this.e = new Label("", labelStyle);
/* 173 */       this.f = new Label("", labelStyle);
/* 174 */       this.g = new Label("", labelStyle);
/*     */     }
/*     */     
/*     */     private void a() {
/* 178 */       Color color = new Color(1.0F, 1.0F, 1.0F, 0.28F);
/*     */       
/* 180 */       this.c.setText((CharSequence)StringFormatter.compactNumber(this.a.getEventsTriggered(), false));
/* 181 */       if (this.a.getEventsTriggered() == 0) {
/* 182 */         this.c.setColor(color);
/*     */       }
/* 184 */       else if (this.h != this.a.getEventsTriggered()) {
/* 185 */         this.h = this.a.getEventsTriggered();
/*     */         
/* 187 */         this.c.setColor(MaterialColor.LIGHT_GREEN.P500);
/* 188 */         this.c.clearActions();
/* 189 */         this.c.addAction((Action)Actions.sequence(
/* 190 */               (Action)Actions.color(MaterialColor.LIGHT_GREEN.P500), 
/* 191 */               (Action)Actions.color(Color.WHITE, 0.25F)));
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 197 */       this.d.setText((CharSequence)StringFormatter.compactNumber(this.a.getEventsStopped(), false));
/* 198 */       if (this.a.getEventsStopped() == 0) {
/* 199 */         this.d.setColor(color);
/*     */       }
/* 201 */       else if (this.i != this.a.getEventsStopped()) {
/* 202 */         this.i = this.a.getEventsStopped();
/*     */         
/* 204 */         this.d.setColor(MaterialColor.LIGHT_GREEN.P500);
/* 205 */         this.d.clearActions();
/* 206 */         this.d.addAction((Action)Actions.sequence(
/* 207 */               (Action)Actions.color(MaterialColor.LIGHT_GREEN.P500), 
/* 208 */               (Action)Actions.color(Color.WHITE, 0.25F)));
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 213 */       this.e.setTextFromInt(this.a.getNonStateAffectingEntriesCount());
/* 214 */       if (this.a.getNonStateAffectingEntriesCount() == 0) {
/* 215 */         this.e.setColor(color);
/*     */       } else {
/* 217 */         this.e.setColor(MaterialColor.CYAN.P300);
/*     */       } 
/*     */       
/* 220 */       this.f.setTextFromInt(this.a.getStateAffectingEntriesCount());
/* 221 */       if (this.a.getStateAffectingEntriesCount() == 0) {
/* 222 */         this.f.setColor(color);
/*     */       } else {
/* 224 */         this.f.setColor(MaterialColor.PURPLE.P300);
/*     */       } 
/*     */       
/* 227 */       this.g.setTextFromInt(this.a.size());
/* 228 */       if (this.a.size() == 0) {
/* 229 */         this.g.setColor(color); return;
/*     */       } 
/* 231 */       this.g.setColor(Color.WHITE);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\stateDebugger\ListenersView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */