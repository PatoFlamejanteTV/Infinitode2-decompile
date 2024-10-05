/*     */ package com.prineside.tdi2.systems;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystem;
/*     */ import com.prineside.tdi2.Gate;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.enums.ItemSubcategoryType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.mapEditor.InventoryItemAdd;
/*     */ import com.prineside.tdi2.events.mapEditor.InventoryItemRemove;
/*     */ import com.prineside.tdi2.items.TileItem;
/*     */ import com.prineside.tdi2.managers.ProgressManager;
/*     */ 
/*     */ public class InventorySystem extends GameSystem {
/*  19 */   private final Array<DelayedRemovalArray<ItemStack>> a = new Array(true, ItemSubcategoryType.values.length, DelayedRemovalArray.class);
/*     */   
/*  21 */   private final _ProgressManagerListener b = new _ProgressManagerListener((byte)0);
/*     */   private boolean c;
/*     */   
/*     */   public InventorySystem() {
/*  25 */     this.a.setSize(ItemSubcategoryType.values.length); ItemSubcategoryType[] arrayOfItemSubcategoryType; int i; byte b;
/*  26 */     for (i = (arrayOfItemSubcategoryType = ItemSubcategoryType.values).length, b = 0; b < i; ) { ItemSubcategoryType itemSubcategoryType = arrayOfItemSubcategoryType[b];
/*  27 */       this.a.set(itemSubcategoryType.ordinal(), new DelayedRemovalArray(true, 8, ItemStack.class));
/*     */       b++; }
/*     */   
/*     */   }
/*     */   
/*     */   public void setup() {
/*  33 */     Game.i.progressManager.addListener((ProgressManager.ProgressManagerListener)this.b);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean affectsGameState() {
/*  38 */     return false;
/*     */   }
/*     */   
/*     */   public DelayedRemovalArray<ItemStack> getItemsBySubCategory(ItemSubcategoryType paramItemSubcategoryType) {
/*  42 */     return ((DelayedRemovalArray[])this.a.items)[paramItemSubcategoryType.ordinal()];
/*     */   }
/*     */   
/*     */   public Array<DelayedRemovalArray<ItemStack>> getAllItems() {
/*  46 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initAddItem(Item paramItem, int paramInt) {
/*  54 */     ProgressManager.addItemToStacksArray((Array)getItemsBySubCategory(paramItem.getSubcategory()), paramItem, paramInt);
/*  55 */     this.S._mapEditorUi.inventoryMenu.rebuildItemList();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initAddItems(Array<ItemStack> paramArray) {
/*  63 */     for (byte b = 0; b < paramArray.size; b++) {
/*  64 */       ItemStack itemStack = (ItemStack)paramArray.get(b);
/*  65 */       ProgressManager.addItemToStacksArray((Array)getItemsBySubCategory(itemStack.getItem().getSubcategory()), itemStack.getItem(), itemStack.getCount());
/*     */     } 
/*     */   }
/*     */   public void add(Item paramItem, int paramInt) {
/*     */     TileItem tileItem;
/*  70 */     Preconditions.checkArgument((paramInt > 0), "Count must be > 0, %s given", paramInt);
/*     */     
/*  72 */     if (paramItem instanceof TileItem) {
/*  73 */       tileItem = Item.D.F_TILE.create(((TileItem)paramItem).tile.cloneTile().removeExtrasForInventory());
/*     */     }
/*     */     
/*     */     InventoryItemAdd inventoryItemAdd;
/*     */     
/*  78 */     if (!(inventoryItemAdd = (InventoryItemAdd)this.S.events.trigger((Event)new InventoryItemAdd((Item)tileItem, paramInt))).isCancelled()) {
/*  79 */       Item item; if (!this.c) {
/*  80 */         item = inventoryItemAdd.getItem();
/*  81 */         int i = inventoryItemAdd.getCount();
/*  82 */         ProgressManager.addItemToStacksArray((Array)getItemsBySubCategory(item.getSubcategory()), item, i);
/*     */         return;
/*     */       } 
/*     */       ItemStack itemStack;
/*  86 */       if ((itemStack = ProgressManager.getItemStackFromArray((Array)getItemsBySubCategory(item.getSubcategory()), item)) == null) {
/*  87 */         ProgressManager.addItemToStacksArray((Array)getItemsBySubCategory(item.getSubcategory()), item, 1);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addTile(Tile paramTile, int paramInt) {
/*  97 */     add((Item)Item.D.F_TILE.create(paramTile.cloneTile()), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addGate(Gate paramGate, int paramInt) {
/* 104 */     add((Item)Item.D.F_GATE.create(paramGate.cloneGate()), paramInt);
/*     */   }
/*     */   
/*     */   public void setStaticMode(boolean paramBoolean) {
/* 108 */     this.c = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean contains(Item paramItem, int paramInt) {
/* 112 */     if (this.c) {
/* 113 */       return true;
/*     */     }
/*     */     
/* 116 */     Preconditions.checkArgument((paramInt > 0), "Count must be > 0, %s given", paramInt);
/*     */     
/*     */     ItemStack itemStack;
/*     */     
/*     */     DelayedRemovalArray<ItemStack> delayedRemovalArray;
/* 121 */     return ((itemStack = ProgressManager.getItemStackFromArray((Array)(delayedRemovalArray = getItemsBySubCategory(paramItem.getSubcategory())), paramItem)) != null && paramInt <= itemStack.getCount());
/*     */   }
/*     */   
/*     */   public boolean removeMany(Item paramItem, int paramInt) {
/* 125 */     if (this.c) {
/* 126 */       return true;
/*     */     }
/*     */     
/* 129 */     Preconditions.checkArgument((paramInt > 0), "Count must be > 0, %s given", paramInt);
/*     */     
/*     */     DelayedRemovalArray<ItemStack> delayedRemovalArray;
/*     */     ItemStack itemStack2;
/* 133 */     if ((itemStack2 = ProgressManager.getItemStackFromArray((Array)(delayedRemovalArray = getItemsBySubCategory(paramItem.getSubcategory())), paramItem)) == null || paramInt > itemStack2.getCount()) {
/* 134 */       return false;
/*     */     }
/*     */     
/*     */     InventoryItemRemove inventoryItemRemove;
/* 138 */     paramInt = (inventoryItemRemove = (InventoryItemRemove)this.S.events.trigger((Event)new InventoryItemRemove(paramItem, paramInt, itemStack2.getCount()))).getCount();
/*     */     
/*     */     ItemStack itemStack1;
/* 141 */     if ((itemStack1 = ProgressManager.removeItemFromStacksArray((Array)delayedRemovalArray, itemStack2.getItem(), paramInt)) != null) {
/* 142 */       if (itemStack1.getCount() == 0)
/*     */       {
/* 144 */         delayedRemovalArray.removeValue(itemStack1, true);
/*     */       }
/* 146 */       return true;
/*     */     } 
/* 148 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean remove(Item paramItem) {
/* 153 */     return removeMany(paramItem, 1);
/*     */   }
/*     */   
/*     */   public boolean profileUpdate() {
/* 157 */     return false;
/*     */   }
/*     */   
/*     */   public String getSystemName() {
/* 161 */     return "Inventory";
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 166 */     this.a.clear();
/* 167 */     Game.i.progressManager.removeListener((ProgressManager.ProgressManagerListener)this.b);
/*     */     
/* 169 */     super.dispose();
/*     */   }
/*     */   
/*     */   private class _ProgressManagerListener extends ProgressManager.ProgressManagerListener.ProgressManagerListenerAdapter { private _ProgressManagerListener(InventorySystem this$0) {}
/*     */     
/*     */     public void itemsChanged(Item param1Item, int param1Int1, int param1Int2) {
/* 175 */       if (param1Int2 > 0)
/* 176 */         this.a.initAddItem(param1Item, param1Int2); 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\systems\InventorySystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */