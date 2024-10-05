/*     */ package com.prineside.tdi2.ui.shared.stateDebugger.listeners;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.events.EventListeners;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.global.Render;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.LimitedWidthLabel;
/*     */ import com.prineside.tdi2.ui.actors.Window;
/*     */ import com.prineside.tdi2.ui.shared.StateDebugger;
/*     */ import com.prineside.tdi2.ui.shared.TooltipsOverlay;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ 
/*     */ 
/*     */ public class ListenerGroupViewer
/*     */   extends Window
/*     */ {
/*  26 */   private final Listener<Render> n = this::a;
/*     */   
/*     */   private final EventListeners<?> o;
/*     */   private Table p;
/*  30 */   private final Array<Entry> q = new Array(true, 1, Entry.class);
/*     */   private Integer r;
/*     */   
/*     */   private static Window.WindowStyle d() {
/*     */     Window.WindowStyle windowStyle;
/*  35 */     (windowStyle = Game.i.assetManager.createDefaultWindowStyle()).resizeable = true;
/*  36 */     windowStyle.inheritWidgetMinSize = true;
/*  37 */     return windowStyle;
/*     */   }
/*     */   
/*     */   public ListenerGroupViewer(EventListeners<?> paramEventListeners) {
/*  41 */     super(d());
/*  42 */     this.o = paramEventListeners;
/*  43 */     this.minWidth = 400.0F;
/*  44 */     this.minHeight = 200.0F;
/*  45 */     setTitle("Listeners of " + paramEventListeners.getEventClass().getSimpleName());
/*  46 */     this.p = new Table();
/*  47 */     a(new Render(0.0F));
/*     */   }
/*     */ 
/*     */   
/*     */   public void showAtPointAligned(float paramFloat1, float paramFloat2, int paramInt) {
/*  52 */     super.showAtPointAligned(paramFloat1, paramFloat2, paramInt);
/*  53 */     Game.EVENTS.getListeners(Render.class).add(this.n).setName("ListenerGroupViewer_" + this.o.getEventClass().getSimpleName()).setDescription("Updates listener list view");
/*     */     
/*  55 */     fitToContentSimple();
/*     */   }
/*     */   
/*     */   private void a(Render paramRender) {
/*  59 */     int i = -1; EventListeners.Entry[] arrayOfEntry1, arrayOfEntry2; int j;
/*     */     byte b2;
/*  61 */     for (j = (arrayOfEntry2 = arrayOfEntry1 = this.o.getEntriesBackingArray()).length, b2 = 0; b2 < j; b2++) {
/*  62 */       EventListeners.Entry entry; if ((entry = arrayOfEntry2[b2]) != null)
/*     */       {
/*  64 */         i = (i = i * 31 + entry.getListener().hashCode()) * 31 + entry.getName().hashCode();
/*     */       }
/*     */     } 
/*  67 */     if (this.r == null || i != this.r.intValue()) {
/*     */       
/*  69 */       this.r = Integer.valueOf(i);
/*  70 */       this.main.clear();
/*  71 */       this.p.clear();
/*  72 */       this.main.add((Actor)this.p).grow().pad(8.0F, 12.0F, 12.0F, 12.0F);
/*     */       
/*  74 */       this.q.clear();
/*     */       
/*  76 */       Label.LabelStyle labelStyle = Game.i.assetManager.getLabelStyle(18);
/*     */       
/*     */       Label label;
/*  79 */       (label = new Label("Listener name", labelStyle)).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  80 */       this.p.add((Actor)label).padRight(6.0F);
/*     */ 
/*     */       
/*  83 */       (label = new Label("Priority", labelStyle)).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  84 */       this.p.add((Actor)label).padRight(6.0F).padLeft(6.0F);
/*     */ 
/*     */       
/*  87 */       (label = new Label("Affects state", labelStyle)).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  88 */       this.p.add((Actor)label).padRight(6.0F).padLeft(6.0F);
/*     */ 
/*     */       
/*  91 */       (label = new Label("Scripted", labelStyle)).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  92 */       this.p.add((Actor)label).padRight(6.0F).padLeft(6.0F);
/*     */ 
/*     */       
/*  95 */       (label = new Label("Description", labelStyle)).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  96 */       this.p.add((Actor)label).growX().padLeft(6.0F);
/*     */       
/*  98 */       this.p.row();
/*  99 */       StateDebugger.tableRowSep(this.p, 6);
/*     */       
/* 101 */       Array array = new Array(true, this.o.size(), EventListeners.Entry.class); byte b;
/* 102 */       for (b = 0; b < this.o.size(); b++) {
/*     */         EventListeners.Entry entry;
/* 104 */         if ((entry = arrayOfEntry1[b]) != null)
/* 105 */           array.add(entry); 
/*     */       } 
/* 107 */       array.sort(EventListeners.Entry.COMPARATOR);
/*     */       
/* 109 */       for (b = 0; b < array.size; b++) {
/*     */         EventListeners.Entry entry;
/* 111 */         if ((entry = (EventListeners.Entry)array.get(b)) != null) {
/*     */           
/* 113 */           Entry entry1 = new Entry(entry, (byte)0);
/* 114 */           this.p.add((Actor)Entry.a(entry1)).growX().padRight(6.0F);
/* 115 */           this.p.add((Actor)Entry.b(entry1)).padRight(6.0F).padLeft(6.0F);
/* 116 */           this.p.add((Actor)Entry.c(entry1)).padRight(6.0F).padLeft(6.0F);
/* 117 */           this.p.add((Actor)Entry.d(entry1)).padRight(6.0F).padLeft(6.0F);
/* 118 */           this.p.add((Actor)Entry.e(entry1)).growX().minWidth(200.0F).padLeft(6.0F);
/*     */           
/* 120 */           this.q.add(entry1);
/*     */           
/* 122 */           this.p.row();
/* 123 */           StateDebugger.tableRowSep(this.p, 6);
/*     */         } 
/* 125 */       }  this.p.row();
/* 126 */       this.p.add().width(1.0F).growY();
/*     */       
/* 128 */       clampWindowPosition();
/*     */     } 
/*     */     
/* 131 */     for (byte b1 = 0; b1 < this.q.size; b1++) {
/* 132 */       Entry.f((Entry)this.q.get(b1));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() {
/* 138 */     super.close();
/* 139 */     Game.EVENTS.getListeners(Render.class).remove(this.n);
/*     */   }
/*     */   
/*     */   private static class Entry
/*     */   {
/*     */     private final EventListeners.Entry<?> a;
/*     */     private final Label b;
/*     */     private final Label c;
/*     */     private final Label d;
/*     */     private final Label e;
/*     */     private final LimitedWidthLabel f;
/*     */     
/*     */     private Entry(EventListeners.Entry<?> param1Entry) {
/* 152 */       this.a = param1Entry;
/*     */       
/* 154 */       Label.LabelStyle labelStyle = Game.i.assetManager.getLabelStyle(18);
/* 155 */       this.b = new Label("", labelStyle);
/* 156 */       this.b.setAlignment(8);
/*     */       
/* 158 */       this.b.addListener((EventListener)new ClickListener(this, param1Entry)
/*     */           {
/*     */             public void clicked(InputEvent param2InputEvent, float param2Float1, float param2Float2) {
/* 161 */               String str = this.a.getListener().getClass().getName() + "\n";
/* 162 */               if (this.a.getListener() instanceof com.prineside.luaj.lib.jse.LuajavaLib.ProxyInvocationHandler) {
/* 163 */                 str = str + "Lua script: \n";
/* 164 */                 str = str + this.a + "\n";
/*     */               } 
/* 166 */               str = str + this.a.getDescription();
/*     */               
/* 168 */               TooltipsOverlay.i().showText("ListenerGroupViewer-listenerDescr", (Actor)ListenerGroupViewer.Entry.a(this.b), str, UiManager.MainUiLayer.OVERLAY, (Game.i.uiManager.getWindowsLayer()).zIndex + 1, 4);
/*     */             }
/*     */           });
/*     */       
/* 172 */       this.c = new Label("", labelStyle);
/* 173 */       this.d = new Label("", labelStyle);
/* 174 */       this.e = new Label("", labelStyle);
/* 175 */       this.f = new LimitedWidthLabel("", 18, 18, 400.0F);
/*     */       
/* 177 */       a();
/*     */     }
/*     */     
/*     */     private void a() {
/* 181 */       Color color = new Color(1.0F, 1.0F, 1.0F, 0.28F);
/*     */       
/* 183 */       boolean bool = this.a.getListener() instanceof com.prineside.luaj.lib.jse.LuajavaLib.ProxyInvocationHandler;
/*     */       
/* 185 */       this.b.setText(this.a.getName());
/* 186 */       if (bool) {
/* 187 */         this.b.setColor(MaterialColor.LIME.P300);
/*     */       } else {
/* 189 */         this.b.setColor(Color.WHITE);
/*     */       } 
/*     */       
/* 192 */       this.c.setText(this.a.getPriority() + (this.a.isAutoPriority() ? " (A)" : ""));
/*     */       
/* 194 */       this.d.setText(this.a.isStateAffecting() ? "+" : "-");
/* 195 */       if (this.a.isStateAffecting()) {
/* 196 */         this.d.setColor(MaterialColor.LIGHT_GREEN.P500);
/*     */       } else {
/* 198 */         this.d.setColor(color);
/*     */       } 
/*     */       
/* 201 */       if (bool) {
/* 202 */         this.e.setText("+");
/* 203 */         this.e.setColor(MaterialColor.LIME.P500);
/*     */       } else {
/* 205 */         this.e.setText("-");
/* 206 */         this.e.setColor(color);
/*     */       } 
/*     */       
/*     */       String str;
/* 210 */       if ((str = this.a.getDescription()) == null) {
/* 211 */         this.f.setText("-"); return;
/*     */       } 
/* 213 */       this.f.setText(str);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\stateDebugger\listeners\ListenerGroupViewer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */