/*     */ package com.prineside.tdi2.ui.shared.luaWhitelistEditor.windows;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.LabelButton;
/*     */ import com.prineside.tdi2.ui.actors.Window;
/*     */ import com.prineside.tdi2.ui.shared.LuajavaWhitelistEditor;
/*     */ import com.prineside.tdi2.ui.shared.luaWhitelistEditor.EClass;
/*     */ import com.prineside.tdi2.ui.shared.luaWhitelistEditor.EConstructor;
/*     */ import com.prineside.tdi2.ui.shared.luaWhitelistEditor.EField;
/*     */ import com.prineside.tdi2.ui.shared.luaWhitelistEditor.EMethod;
/*     */ import com.prineside.tdi2.ui.shared.luaWhitelistEditor.TreeEntry;
/*     */ import com.prineside.tdi2.ui.shared.luaWhitelistEditor.events.EntryStateChange;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.ObjectPair;
/*     */ 
/*     */ 
/*     */ public class ListClassUsagesWindow
/*     */   extends Window
/*     */ {
/*     */   private final Class<?> n;
/*     */   private final Table o;
/*  29 */   private final Array<Entry> p = new Array(true, 1, Entry.class);
/*     */ 
/*     */   
/*     */   private final Listener<EntryStateChange> q = paramEntryStateChange -> e();
/*     */ 
/*     */   
/*     */   private static Window.WindowStyle d() {
/*     */     Window.WindowStyle windowStyle;
/*  37 */     (windowStyle = Game.i.assetManager.createDefaultWindowStyle()).resizeable = true;
/*  38 */     windowStyle.inheritWidgetMinSize = true;
/*  39 */     return windowStyle;
/*     */   }
/*     */   
/*     */   public ListClassUsagesWindow(Class<?> paramClass, TreeEntry paramTreeEntry) {
/*  43 */     super(d());
/*  44 */     this.n = paramClass;
/*  45 */     this.minWidth = 400.0F;
/*  46 */     this.minHeight = 48.0F;
/*  47 */     setTitle("Usages of " + paramClass.getName());
/*     */     
/*  49 */     this.o = new Table();
/*  50 */     this.main.add((Actor)this.o).grow();
/*     */     
/*  52 */     Label.LabelStyle labelStyle = Game.i.assetManager.getLabelStyle(18);
/*     */     
/*  54 */     Array array = new Array(true, 1, ObjectPair.class);
/*  55 */     paramTreeEntry.walkRecursively(paramTreeEntry -> {
/*     */           EClass eClass; if (paramTreeEntry instanceof EClass) {
/*     */             if ((eClass = (EClass)paramTreeEntry).forClass == paramClass) {
/*     */               paramArray.add(new ObjectPair(eClass, "The class"));
/*     */             } else {
/*     */               if (paramClass.isAssignableFrom(eClass.forClass))
/*     */                 paramArray.add(new ObjectPair(eClass, "Extends this class"));  return;
/*     */             } 
/*     */           } else {
/*     */             EField eField; if (eClass instanceof EField) {
/*     */               if ((eField = (EField)eClass).getField().getType() == paramClass) {
/*     */                 paramArray.add(new ObjectPair(eField, "Field type"));
/*     */               } else {
/*     */                 if (paramClass.isAssignableFrom(eField.getField().getType()))
/*     */                   paramArray.add(new ObjectPair(eField, "Field type extends this class"));  return;
/*     */               } 
/*     */             } else {
/*     */               EConstructor eConstructor; if (eField instanceof EConstructor) {
/*     */                 Class[] arrayOfClass; int i = (arrayOfClass = (eConstructor = (EConstructor)eField).getConstructor().getParameterTypes()).length; byte b = 0; while (true) {
/*     */                   if (b < i) {
/*     */                     Class<?> clazz; if ((clazz = arrayOfClass[b]) == paramClass) {
/*     */                       paramArray.add(new ObjectPair(eConstructor, "Constructor parameter")); break;
/*     */                     } 
/*     */                     if (paramClass.isAssignableFrom(clazz)) {
/*     */                       paramArray.add(new ObjectPair(eConstructor, "Constructor parameter type extends this class"));
/*     */                       break;
/*     */                     } 
/*     */                     b++;
/*     */                     continue;
/*     */                   } 
/*     */                   return;
/*     */                 } 
/*     */               } else if (eConstructor instanceof EMethod) {
/*     */                 EMethod eMethod;
/*     */                 if ((eMethod = (EMethod)eConstructor).getMethod().getReturnType() == paramClass) {
/*     */                   paramArray.add(new ObjectPair(eMethod, "Method return type"));
/*     */                 } else if (paramClass.isAssignableFrom(eMethod.getMethod().getReturnType())) {
/*     */                   paramArray.add(new ObjectPair(eMethod, "Method return type extends this class"));
/*     */                 } 
/*     */                 Class[] arrayOfClass;
/*     */                 int i = (arrayOfClass = eMethod.getMethod().getParameterTypes()).length;
/*     */                 for (byte b = 0; b < i; b++) {
/*     */                   Class<?> clazz;
/*     */                   if ((clazz = arrayOfClass[b]) == paramClass) {
/*     */                     paramArray.add(new ObjectPair(eMethod, "Method parameter"));
/*     */                     return;
/*     */                   } 
/*     */                   if (paramClass.isAssignableFrom(clazz))
/*     */                     paramArray.add(new ObjectPair(eMethod, "Method parameter type extends this class")); 
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         });
/* 109 */     if (array.size == 0) {
/* 110 */       Label label = new Label("Nothing found", labelStyle);
/* 111 */       this.o.add((Actor)label).row();
/*     */     } else {
/*     */       
/* 114 */       Label label = new Label("Found " + array.size + " entries", labelStyle);
/* 115 */       this.o.add((Actor)label).row();
/*     */       
/* 117 */       for (Array.ArrayIterator<ObjectPair> arrayIterator = array.iterator(); arrayIterator.hasNext(); ) {
/* 118 */         ObjectPair objectPair; TreeEntry treeEntry = (TreeEntry)(objectPair = arrayIterator.next()).first;
/*     */         
/* 120 */         Table table = new Table();
/* 121 */         this.o.add((Actor)table).growX().minHeight(24.0F).padTop(1.0F).row();
/*     */         
/*     */         Entry entry;
/* 124 */         (entry = new Entry((byte)0)).row = table;
/* 125 */         entry.treeEntry = treeEntry;
/* 126 */         entry.updateColor();
/* 127 */         this.p.add(entry);
/*     */         
/* 129 */         Image image = new Image(treeEntry.getEntryIcon());
/* 130 */         table.add((Actor)image).size(16.0F).padLeft(4.0F).padRight(8.0F);
/*     */ 
/*     */         
/*     */         LabelButton labelButton2;
/*     */         
/* 135 */         (labelButton2 = new LabelButton(treeEntry.getName(), labelStyle, () -> LuajavaWhitelistEditor.i().goToEntry(paramTreeEntry))).setWrap(true);
/* 136 */         labelButton2.setAlignment(8);
/* 137 */         labelButton2.setColors(Color.WHITE, new Color(1.0F, 1.0F, 1.0F, 0.78F));
/* 138 */         table.add((Actor)labelButton2).minHeight(20.0F).padTop(2.0F).padBottom(2.0F).minWidth(300.0F).growX().padRight(8.0F);
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
/* 150 */         (labelButton2 = new LabelButton("W", Game.i.assetManager.getLabelStyle(21), () -> { int i; if ((i = paramTreeEntry.getState()) == 1 || i == 4) { paramTreeEntry.unsetWhiteListed(); } else { paramTreeEntry.setWhiteListed(); }  paramTreeEntry.updateBackground(); paramTreeEntry.updateParentsBackground(); })).setColors(MaterialColor.LIGHT_GREEN.P500, MaterialColor.LIGHT_GREEN.P300);
/* 151 */         table.add((Actor)labelButton2).width(24.0F).height(24.0F);
/* 152 */         labelButton2.setAlignment(1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         LabelButton labelButton1;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 163 */         (labelButton1 = new LabelButton("B", Game.i.assetManager.getLabelStyle(21), () -> { if (paramTreeEntry.getState() == 2) { paramTreeEntry.unsetBlackListed(); } else { paramTreeEntry.setBlackListed(); }  paramTreeEntry.updateBackground(); paramTreeEntry.updateParentsBackground(); })).setColors(MaterialColor.RED.P500, MaterialColor.RED.P300);
/* 164 */         labelButton1.setAlignment(1);
/* 165 */         table.add((Actor)labelButton1).width(24.0F).height(24.0F).padRight(8.0F);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 175 */     this.o.row();
/* 176 */     this.o.add().width(1.0F).growY();
/*     */     
/* 178 */     clampWindowPosition();
/*     */   }
/*     */ 
/*     */   
/*     */   public void show() {
/* 183 */     super.show();
/* 184 */     Game.EVENTS.getListeners(EntryStateChange.class).add(this.q).setName("ListClassUsagesWindow_" + this.n.getName()).setDescription("Updates list colors");
/*     */   }
/*     */   
/*     */   private void e() {
/* 188 */     for (Array.ArrayIterator<Entry> arrayIterator = this.p.iterator(); arrayIterator.hasNext();) {
/* 189 */       (entry = arrayIterator.next()).updateColor();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() {
/* 195 */     super.close();
/* 196 */     Game.EVENTS.getListeners(EntryStateChange.class).remove(this.q);
/*     */   }
/*     */   private static final class Entry { public Table row;
/*     */     public TreeEntry treeEntry;
/*     */     
/*     */     private Entry() {}
/*     */     
/*     */     public final void updateColor() {
/* 204 */       TreeEntry.updateBackgroundColorToState(this.treeEntry.getState(), this.row);
/* 205 */       if (this.row.getBackground() == null) {
/*     */         
/* 207 */         TreeEntry treeEntry = this.treeEntry.parent;
/* 208 */         while (treeEntry != null) {
/* 209 */           if (treeEntry.getState() == 2) {
/* 210 */             this.row.setBackground(Game.i.assetManager.getDrawable("blank").tint(MaterialColor.RED.P800.cpy().lerp(0.0F, 0.0F, 0.0F, 0.56F, 0.56F)));
/*     */             return;
/*     */           } 
/* 213 */           treeEntry = treeEntry.parent;
/*     */         } 
/*     */       } 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\luaWhitelistEditor\windows\ListClassUsagesWindow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */