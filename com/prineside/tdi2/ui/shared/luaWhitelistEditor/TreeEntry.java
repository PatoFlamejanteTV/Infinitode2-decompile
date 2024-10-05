/*     */ package com.prineside.tdi2.ui.shared.luaWhitelistEditor;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.managers.script.Whitelist;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.LabelButton;
/*     */ import com.prineside.tdi2.ui.actors.PaddedImageButton;
/*     */ import com.prineside.tdi2.ui.shared.LuajavaWhitelistEditor;
/*     */ import com.prineside.tdi2.ui.shared.Notifications;
/*     */ import com.prineside.tdi2.ui.shared.luaWhitelistEditor.events.EntryStateChange;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.ObjectConsumer;
/*     */ 
/*     */ public abstract class TreeEntry
/*     */ {
/*     */   public static final int STATE_NONE = 0;
/*     */   public static final int STATE_WHITELISTED = 1;
/*     */   public static final int STATE_BLACKLISTED = 2;
/*     */   public static final int STATE_ALL_CHILDREN_HANDLED = 3;
/*     */   public static final int STATE_ALL_CHILDREN_WHITELISTED = 4;
/*     */   public static final int STATE_ALL_CHILDREN_BLACKLISTED = 5;
/*  31 */   public static final Color BLACKLISTED_BG_COLOR = MaterialColor.RED.P800;
/*  32 */   public static final Color BLACKLISTED_CHILDREN_BG_COLOR = MaterialColor.RED.P800.cpy().lerp(new Color(858993663), 0.56F);
/*  33 */   public static final Color WHITELISTED_BG_COLOR = MaterialColor.GREEN.P800;
/*  34 */   public static final Color WHITELISTED_CHILDREN_BG_COLOR = MaterialColor.GREEN.P800.cpy().lerp(new Color(858993663), 0.56F);
/*  35 */   public static final Color ALL_CHILDREN_HANDLED_BG_COLOR = MaterialColor.CYAN.P800;
/*     */   @Null
/*     */   public final TreeEntry parent;
/*     */   protected final String a;
/*  39 */   public Array<TreeEntry> children = new Array(true, 1, TreeEntry.class); public boolean collapsed = true;
/*     */   @Null
/*     */   private Table b;
/*     */   @Null
/*     */   private Image c;
/*     */   public boolean hovered;
/*  45 */   public int state = 0;
/*     */   
/*     */   protected TreeEntry(TreeEntry paramTreeEntry, String paramString) {
/*  48 */     this.parent = paramTreeEntry;
/*  49 */     this.a = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  60 */     return this.a;
/*     */   }
/*     */   
/*     */   public String getSortName() {
/*  64 */     return this.a;
/*     */   }
/*     */   
/*     */   public void addChild(TreeEntry paramTreeEntry) {
/*  68 */     this.children.add(paramTreeEntry);
/*     */   }
/*     */   
/*     */   public Array<TreeEntry> getChildren() {
/*  72 */     return this.children;
/*     */   }
/*     */   
/*     */   public void walkRecursively(ObjectConsumer<TreeEntry> paramObjectConsumer) {
/*  76 */     paramObjectConsumer.accept(this);
/*  77 */     for (byte b = 0; b < this.children.size; b++) {
/*  78 */       ((TreeEntry)this.children.get(b)).walkRecursively(paramObjectConsumer);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Table getListEntry() {
/*  85 */     if (this.b == null) {
/*  86 */       this.b = new Table();
/*  87 */       this.b.setTouchable(Touchable.enabled);
/*  88 */       this.b.setUserObject(this);
/*  89 */       c();
/*     */     } 
/*  91 */     return this.b;
/*     */   }
/*     */   
/*     */   public int getState() {
/*  95 */     return this.state;
/*     */   }
/*     */   
/*     */   public void updateParentsBackground() {
/*  99 */     TreeEntry treeEntry = this.parent;
/* 100 */     while (treeEntry != null) {
/* 101 */       treeEntry.updateBackground();
/* 102 */       treeEntry = treeEntry.parent;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateBackground() {
/* 107 */     if (this.c == null) {
/*     */       return;
/*     */     }
/*     */     
/* 111 */     if (this.hovered) {
/* 112 */       this.c.setColor(0.0F, 0.0F, 0.0F, 0.14F);
/*     */     } else {
/* 114 */       this.c.setColor(1.0F, 1.0F, 1.0F, 0.0F);
/*     */     } 
/*     */     
/* 117 */     updateBackgroundColorToState(getState(), getListEntry());
/*     */   }
/*     */   
/*     */   public static void updateBackgroundColorToState(int paramInt, Table paramTable) {
/* 121 */     switch (paramInt) {
/*     */       case 0:
/* 123 */         paramTable.setBackground((Drawable)null);
/*     */         return;
/*     */       
/*     */       case 2:
/* 127 */         paramTable.setBackground(Game.i.assetManager.getDrawable("blank").tint(BLACKLISTED_BG_COLOR));
/*     */         return;
/*     */       
/*     */       case 1:
/* 131 */         paramTable.setBackground(Game.i.assetManager.getDrawable("blank").tint(WHITELISTED_BG_COLOR));
/*     */         return;
/*     */       
/*     */       case 5:
/* 135 */         paramTable.setBackground(Game.i.assetManager.getDrawable("blank").tint(BLACKLISTED_CHILDREN_BG_COLOR));
/*     */         return;
/*     */       
/*     */       case 4:
/* 139 */         paramTable.setBackground(Game.i.assetManager.getDrawable("blank").tint(WHITELISTED_CHILDREN_BG_COLOR));
/*     */         return;
/*     */       
/*     */       case 3:
/* 143 */         paramTable.setBackground(Game.i.assetManager.getDrawable("blank").tint(ALL_CHILDREN_HANDLED_BG_COLOR));
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean b() {
/* 152 */     return (this.children.size != 0);
/*     */   }
/*     */   
/*     */   protected boolean a() {
/* 156 */     return false;
/*     */   }
/*     */   
/*     */   public void setChildrenCollapsedRecursively() {
/* 160 */     for (byte b = 0; b < this.children.size; b++) {
/*     */       TreeEntry treeEntry;
/* 162 */       (treeEntry = (TreeEntry)this.children.get(b)).collapsed = true;
/* 163 */       treeEntry.setChildrenCollapsedRecursively();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setWhiteListed() {
/* 168 */     TreeEntry treeEntry = this.parent;
/* 169 */     boolean bool = false;
/* 170 */     while (treeEntry != null) {
/* 171 */       if (treeEntry.getState() == 2) {
/* 172 */         bool = true;
/*     */         break;
/*     */       } 
/* 175 */       treeEntry = treeEntry.parent;
/*     */     } 
/* 177 */     if (bool) {
/* 178 */       Notifications.i().addFailure("This entry has blacklisted parent, can not whitelist");
/*     */     } else {
/* 180 */       this.state = 1;
/*     */     } 
/* 182 */     for (byte b = 0; b < this.children.size; b++) {
/* 183 */       ((TreeEntry)this.children.get(b)).setWhiteListed();
/*     */     }
/* 185 */     updateBackground();
/*     */     
/* 187 */     Game.EVENTS.getListeners(EntryStateChange.class).trigger((Event)new EntryStateChange(this));
/*     */   }
/*     */   
/*     */   public void unsetWhiteListed() {
/* 191 */     if (getState() == 1) {
/* 192 */       this.state = 0;
/*     */     }
/* 194 */     for (byte b = 0; b < this.children.size; b++) {
/* 195 */       ((TreeEntry)this.children.get(b)).unsetWhiteListed();
/*     */     }
/* 197 */     updateBackground();
/*     */     
/* 199 */     Game.EVENTS.getListeners(EntryStateChange.class).trigger((Event)new EntryStateChange(this));
/*     */   }
/*     */   
/*     */   public void setBlackListed() {
/* 203 */     this.state = 2;
/* 204 */     for (byte b = 0; b < this.children.size; b++) {
/* 205 */       ((TreeEntry)this.children.get(b)).setBlackListed();
/*     */     }
/* 207 */     updateBackground();
/*     */     
/* 209 */     Game.EVENTS.getListeners(EntryStateChange.class).trigger((Event)new EntryStateChange(this));
/*     */   }
/*     */   
/*     */   public void unsetBlackListed() {
/* 213 */     if (getState() == 2) {
/* 214 */       this.state = 0;
/*     */     }
/* 216 */     for (byte b = 0; b < this.children.size; b++) {
/* 217 */       ((TreeEntry)this.children.get(b)).unsetBlackListed();
/*     */     }
/* 219 */     updateBackground();
/*     */     
/* 221 */     Game.EVENTS.getListeners(EntryStateChange.class).trigger((Event)new EntryStateChange(this));
/*     */   }
/*     */   
/*     */   public void setCollapsed(boolean paramBoolean) {
/* 225 */     this.collapsed = paramBoolean;
/* 226 */     if (!this.collapsed) {
/*     */       
/* 228 */       setChildrenCollapsedRecursively();
/* 229 */       for (paramBoolean = false; paramBoolean < this.children.size; paramBoolean++) {
/* 230 */         ((TreeEntry)this.children.get(paramBoolean)).c();
/*     */       }
/*     */     } 
/* 233 */     c();
/*     */   }
/*     */   
/*     */   private void c() {
/*     */     Table table1;
/* 238 */     (table1 = getListEntry()).clearChildren();
/*     */     
/* 240 */     this.c = new Image((Drawable)Game.i.assetManager.getDrawable("blank"));
/* 241 */     this.c.setFillParent(true);
/* 242 */     this.c.setColor(1.0F, 1.0F, 1.0F, 0.0F);
/* 243 */     table1.addActor((Actor)this.c);
/*     */     
/* 245 */     Table table2 = new Table();
/* 246 */     table1.add((Actor)table2).growX().row();
/*     */     
/* 248 */     if (b()) {
/*     */       PaddedImageButton paddedImageButton;
/*     */ 
/*     */       
/* 252 */       (paddedImageButton = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable(this.collapsed ? "icon-triangle-right-hollow" : "icon-triangle-bottom-hollow"), () -> setCollapsed(!this.collapsed), new Color(1.0F, 1.0F, 1.0F, 0.56F), Color.WHITE, Color.WHITE)).setIconSize(16.0F, 16.0F);
/* 253 */       paddedImageButton.setIconPosition(4.0F, 4.0F);
/* 254 */       table2.add((Actor)paddedImageButton).width(24.0F).height(24.0F);
/*     */     } else {
/* 256 */       table2.add().height(1.0F).width(24.0F);
/*     */     } 
/*     */     
/* 259 */     Image image = new Image(getEntryIcon());
/* 260 */     table2.add((Actor)image).size(16.0F).padRight(8.0F);
/*     */     Label label;
/* 262 */     (label = new Label(getName(), Game.i.assetManager.getLabelStyle(21))).setWrap(true);
/* 263 */     table2.add((Actor)label).minWidth(400.0F).growX();
/* 264 */     table2.add().height(1.0F).growX();
/*     */ 
/*     */     
/* 267 */     if (this instanceof EClass) {
/*     */       LabelButton labelButton1;
/*     */ 
/*     */       
/* 271 */       (labelButton1 = new LabelButton(Game.i.assetManager.replaceRegionAliasesWithChars("<@icon-magnifying-glass>"), Game.i.assetManager.getLabelStyle(21), () -> LuajavaWhitelistEditor.i().showClassUsagesWindow(((EClass)this).getForClass()))).setColors(MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P300);
/* 272 */       table2.add((Actor)labelButton1).width(40.0F).height(24.0F);
/* 273 */       labelButton1.setAlignment(1);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     LabelButton labelButton;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 286 */     (labelButton = new LabelButton("W", Game.i.assetManager.getLabelStyle(21), () -> { int i; if ((i = getState()) == 1 || i == 4) { unsetWhiteListed(); } else { setWhiteListed(); }  updateBackground(); updateParentsBackground(); })).setColors(MaterialColor.LIGHT_GREEN.P500, MaterialColor.LIGHT_GREEN.P300);
/* 287 */     table2.add((Actor)labelButton).width(40.0F).height(24.0F);
/* 288 */     labelButton.setAlignment(1);
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
/* 299 */     (labelButton = new LabelButton("B", Game.i.assetManager.getLabelStyle(21), () -> { if (getState() == 2) { unsetBlackListed(); } else { setBlackListed(); }  updateBackground(); updateParentsBackground(); })).setColors(MaterialColor.RED.P500, MaterialColor.RED.P300);
/* 300 */     labelButton.setAlignment(1);
/* 301 */     table2.add((Actor)labelButton).width(40.0F).height(24.0F);
/*     */     
/* 303 */     if (!this.collapsed) {
/*     */       
/* 305 */       (table2 = new Table()).add().width(12.0F).growY();
/*     */       Image image1;
/* 307 */       (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 308 */       table2.add((Actor)image1).width(1.0F).growY();
/*     */       
/*     */       Table table;
/* 311 */       (table = new Table()).background(Game.i.assetManager.getDrawable("blank").tint(new Color(858993612)));
/* 312 */       for (Array.ArrayIterator<TreeEntry> arrayIterator = getChildren().iterator(); arrayIterator.hasNext(); ) {
/* 313 */         TreeEntry treeEntry; Table table3 = (treeEntry = arrayIterator.next()).getListEntry();
/*     */         
/* 315 */         (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 316 */         if (treeEntry.a()) {
/* 317 */           table.add((Actor)image1).height(1.0F).width(6.0F);
/*     */         } else {
/* 319 */           table.add((Actor)image1).height(1.0F).top().padTop(12.0F).width(6.0F);
/*     */         } 
/* 321 */         table.add((Actor)table3).padLeft(5.0F).padTop(1.0F).growX().row();
/*     */       } 
/* 323 */       table2.add((Actor)table).growX().growY().row();
/* 324 */       table1.add((Actor)table2).growX();
/*     */     } 
/*     */     
/* 327 */     updateBackground();
/*     */   }
/*     */   
/*     */   public abstract int getSortCategory();
/*     */   
/*     */   public abstract void applyStateFromWhitelist(Whitelist paramWhitelist);
/*     */   
/*     */   public abstract void gatherSaveData(Array<String> paramArray);
/*     */   
/*     */   public abstract Drawable getEntryIcon();
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\luaWhitelistEditor\TreeEntry.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */