/*    */ package com.prineside.tdi2.events.mapEditor;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.Item;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ 
/*    */ public final class InventoryItemRemove extends StoppableEvent {
/*    */   private final Item a;
/*    */   private final int b;
/*    */   private int c;
/*    */   
/*    */   public InventoryItemRemove(Item paramItem, int paramInt1, int paramInt2) {
/* 13 */     Preconditions.checkNotNull(paramItem, "Item can not be null");
/* 14 */     Preconditions.checkArgument((paramInt2 > 0), "Available count must be > 0, %s given", paramInt2);
/* 15 */     this.a = paramItem;
/* 16 */     this.b = paramInt2;
/* 17 */     setCount(paramInt1);
/*    */   }
/*    */   
/*    */   public final Item getItem() {
/* 21 */     return this.a;
/*    */   }
/*    */   
/*    */   public final int getCount() {
/* 25 */     return this.c;
/*    */   }
/*    */   
/*    */   public final void setCount(int paramInt) {
/* 29 */     Preconditions.checkArgument((paramInt > 0 && paramInt <= this.b), "Count must be between 1 and %s, %s given", this.b, paramInt);
/* 30 */     this.c = paramInt;
/*    */   }
/*    */   
/*    */   public final int getAvailableCount() {
/* 34 */     return this.b;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\mapEditor\InventoryItemRemove.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */