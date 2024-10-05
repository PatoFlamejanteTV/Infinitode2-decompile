/*    */ package com.prineside.tdi2.events.mapEditor;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.ItemStack;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ 
/*    */ public final class InventoryStackChange extends StoppableEvent {
/*    */   private final ItemStack a;
/*    */   private final int b;
/*    */   
/*    */   public InventoryStackChange(ItemStack paramItemStack, int paramInt) {
/* 12 */     Preconditions.checkNotNull(paramItemStack, "itemStack can not be null");
/* 13 */     Preconditions.checkArgument((paramInt != 0), "delta can not be 0");
/*    */     
/* 15 */     this.a = paramItemStack;
/* 16 */     this.b = paramInt;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final ItemStack getItemStack() {
/* 23 */     return this.a;
/*    */   }
/*    */   
/*    */   public final int getDelta() {
/* 27 */     return this.b;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\mapEditor\InventoryStackChange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */