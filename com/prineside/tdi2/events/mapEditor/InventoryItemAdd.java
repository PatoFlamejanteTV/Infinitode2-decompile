/*    */ package com.prineside.tdi2.events.mapEditor;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.Item;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ 
/*    */ public final class InventoryItemAdd
/*    */   extends StoppableEvent {
/*    */   private Item a;
/*    */   private int b;
/*    */   private boolean c;
/*    */   
/*    */   public InventoryItemAdd(Item paramItem, int paramInt) {
/* 14 */     setItem(paramItem);
/* 15 */     setCount(paramInt);
/*    */   }
/*    */   
/*    */   public final Item getItem() {
/* 19 */     return this.a;
/*    */   }
/*    */   
/*    */   public final void setItem(Item paramItem) {
/* 23 */     Preconditions.checkNotNull(paramItem, "Item can not be null");
/* 24 */     this.a = paramItem;
/*    */   }
/*    */   
/*    */   public final int getCount() {
/* 28 */     return this.b;
/*    */   }
/*    */   
/*    */   public final void setCount(int paramInt) {
/* 32 */     Preconditions.checkArgument((paramInt > 0), "Count must be > 0, %s given", paramInt);
/* 33 */     this.b = paramInt;
/*    */   }
/*    */   
/*    */   public final boolean isCancelled() {
/* 37 */     return this.c;
/*    */   }
/*    */   
/*    */   public final void setCancelled(boolean paramBoolean) {
/* 41 */     this.c = paramBoolean;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\mapEditor\InventoryItemAdd.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */